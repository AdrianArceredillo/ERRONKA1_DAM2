using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HJAA_Grafikoak_HaritzOtero.models
{
    public class product_product
    { //aa
        [Key]
        public int id { get; set; }
        
        public int product_tmpl_id { get; set; }

        public product_template product_template { get; set; }

        public virtual List<stock_quant> stock_quant { get; set; }

    }
}
