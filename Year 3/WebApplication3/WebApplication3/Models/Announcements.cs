using System;
using System.ComponentModel.DataAnnotations;

namespace WebApplication3.Models
{
    public class Announcements
    {
        public int Id { get; set; }

        [Required]
        [Display(Name = "Title")]
        public string AnnouceTitle { get; set; }

        [Required]
        [Display(Name = "Post")]
        public string AnnouceBody { get; set; }
        [DisplayFormat(DataFormatString = "{0:dd/MM/yyyy}")]
        public DateTime DatePosted { get; set; }
        
       

        public int StatsCounter { get; set; }

        public virtual ApplicationUser User { get; set; }

       
    }   
}
