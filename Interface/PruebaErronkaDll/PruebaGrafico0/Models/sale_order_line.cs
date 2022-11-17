using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PruebaGrafico0.Models
{
    public class sale_order_line
    {
        [Key]
        public int id { get; set; }
        public int order_id { get; set; }
        public string name { get; set; }
        public int price_unit { get; set; }
        public int price_total { get; set; }
        public int price_subtotal { get; set; }
        public int product_id { get; set; }
        public int product_uom_qty { get; set; }
        public int order_partner_id { get; set; }

        [ForeignKey("order_partner_id")]
        public res_partner res_Partner { get; set; }
        //public product_template product_Template { get; set; }


    }
}
