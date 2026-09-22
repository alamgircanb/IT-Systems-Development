using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Comp235MVCFinal.Models;
using Comp235MVCFinal.DataAccessObjects;

namespace Comp235MVCFinal.Controllers
{
    public class HomeController : Controller
    {
        MovieDAO dAO = new MovieDAO();

        public ActionResult Index()
        {
            return View();
        }

        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";
            return View();
        }

        public ActionResult Contact()
        {
            ViewBag.Message = "Do Not Hesitate To Contact With Us.";
            return View();
        }

        public ActionResult AllMovies(Movies m, string Save)
        {
            ViewBag.Message = "All movies.";
            if (Save == "Save")
            {
                Movie movie = m.Items[m.EditIndex];
                dAO.updateMovie(movie);
                movie.IsEditable = false;
                m.EditIndex = -1;
            }
            return View(dAO.getAllMovies());
        }

        public ActionResult MoviesEdit(int? id)
        {
            int realId = id ?? 0;
            Movies movies = dAO.getAllMovies();
            movies.EditIndex = dAO.setMovieToEditMode(movies.Items, realId);
            ViewBag.Message = "All movies.";
            return View("AllMovies", movies);
        }

        public ActionResult Details(int id)
        {
            return View("Movie", dAO.getMovieById(id));
        }

        public ActionResult DeleteMovie(int id)
        {
            dAO.deleteMovie(id);
            return RedirectToAction("AllMovies");
        }

        public ActionResult AddMovie()
        {
            ViewBag.Message = "Add A Movie Page";
            return View();
        }

        [HttpPost]
        public ActionResult AddMovie(Movie m, string Save)
        {
            if (Save == "Save")
            {
                dAO.InsertMovie(m);
                ViewBag.Message = "Movie Added successfully";
            }
            return View();
        }
    }
}