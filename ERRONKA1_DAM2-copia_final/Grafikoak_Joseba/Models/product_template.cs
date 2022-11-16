using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Grafikoak_Joseba.Models   
{
    public class product_template
    {
        [Key]
        public int id { get; set; }
        public string name { get; set; }
    }
}
