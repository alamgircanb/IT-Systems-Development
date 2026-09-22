using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using Comp235MVCFinal.Models;

namespace Comp235MVCFinal.DataAccessObjects
{
    public class MovieDAO
    {
        string conString = "Data Source=localhost;Initial Catalog=Movies;Integrated Security=True";

        public void updateMovie(Movie movie)
        {
            using (SqlConnection con = new SqlConnection(conString))
            {
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = con;
                if (movie.Description != null)
                {
                    cmd.CommandText = "UPDATE Movies SET Title=@Title, Director=@Director, Description=@Description WHERE Id=@Id";
                    cmd.Parameters.AddWithValue("@Description", movie.Description);
                }
                else
                {
                    cmd.CommandText = "UPDATE Movies SET Title=@Title, Director=@Director WHERE Id=@Id";
                }
                cmd.Parameters.AddWithValue("@Title", movie.Title);
                cmd.Parameters.AddWithValue("@Director", movie.Director);
                cmd.Parameters.AddWithValue("@Id", movie.Id);
                con.Open();
                cmd.ExecuteNonQuery();
            }
        }

        public int setMovieToEditMode(List<Movie> movies, int id)
        {
            int editIndex = 0;
            foreach (Movie m in movies)
            {
                if (m.Id == id)
                {
                    m.IsEditable = true;
                    return editIndex;
                }
                editIndex++;
            }
            return -1;
        }

        // Following Code Segment [2] exactly as requested
        public Movies getAllMovies()
        {
            SqlConnection con = new SqlConnection(conString);
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = con;
            cmd.CommandText = "SELECT Id,Title,Director FROM Movies";

            List<Movie> ms = new List<Movie>();
            con.Open();
            SqlDataReader reader = cmd.ExecuteReader();
            while (reader.Read())
            {
                Movie m = new Movie(
                    Convert.ToInt32(reader["Id"]),
                    reader["Title"].ToString(),
                    reader["Director"].ToString()
                );
                ms.Add(m);
            }
            // create an instance of the class assign the collection and return it
            Movies allMovies = new Movies(); 
            allMovies.Items = ms;
            // Ensuring the connection closes
            con.Close(); 
            return allMovies;
        }

        public void deleteMovie(int id)
        {
            using (SqlConnection con = new SqlConnection(conString))
            {
                SqlCommand cmd = new SqlCommand("DELETE FROM Movies WHERE Id=@Id", con);
                cmd.Parameters.AddWithValue("@Id", id);
                con.Open();
                cmd.ExecuteNonQuery();
            }
        }

        public Movie getMovieById(int id)
        {
            using (SqlConnection con = new SqlConnection(conString))
            {
                SqlCommand cmd = new SqlCommand("SELECT Id, Title, Director, Description FROM Movies WHERE Id=@Id", con);
                cmd.Parameters.AddWithValue("Id", id);
                con.Open();
                SqlDataReader reader = cmd.ExecuteReader();
                if (reader.Read())
                {
                    return new Movie(
                        Convert.ToInt32(reader["Id"]),
                        reader["Title"].ToString(),
                        reader["Director"].ToString(),
                        reader["Description"].ToString());
                }
            }
            return null;
        }

        public void InsertMovie(Movie m)
        {
            using (SqlConnection con = new SqlConnection(conString))
            {
                SqlCommand cmd = new SqlCommand("INSERT INTO Movies(Title, Director) VALUES(@Title, @Director)", con);
                cmd.Parameters.AddWithValue("@Title", m.Title);
                cmd.Parameters.AddWithValue("@Director", m.Director);
                con.Open();
                cmd.ExecuteNonQuery();
            }
        }
    }
}