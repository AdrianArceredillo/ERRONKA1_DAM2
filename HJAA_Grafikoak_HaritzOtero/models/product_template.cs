using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HJAA_Grafikoak_HaritzOtero.models
{
    public class product_template
    {
        
        [Key]

        public int id { get; set; }
        
        public string name { get; set; }

        public int list_price { get; set; }
        
        
        public List<product_product> product_product { get; set; }

    }
}
