using System.Collections.Generic;

namespace Comp235MVCFinal.Models
{
    public class Movies
    {
        public List<Movie> Items { get; set; }
        public int EditIndex { get; set; }

        public Movies()
        {
            Items = new List<Movie>();
        }
    }
}