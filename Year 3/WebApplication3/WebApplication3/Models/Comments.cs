using System;
using System.ComponentModel.DataAnnotations;

namespace WebApplication3.Models
{
    public class Comments
    {
        public int Id { get; set; }
        //public string CommentTitle { get; set; }
        [Required]
        [Display(Name = "Comment")]
        public string CommentBody { get; set; }
        
        public DateTime DatePosted { get; set; }

        public virtual ApplicationUser User { get; set; }
        public virtual Announcements Announcement { get; set; }

    }
}

