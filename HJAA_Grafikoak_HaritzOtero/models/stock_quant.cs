using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HJAA_Grafikoak_HaritzOtero.models
{
    public class stock_quant
    {
        [Key]
        public int id { get; set; } 
        
        
        public int product_id { get; set; }

        public int company_id { get; set; }
        public int quantity { get; set; }

        public int location_id { get; set; }


        [ForeignKey("product_id")]
        public virtual product_product product_product { get; set; }

        







    }
}
