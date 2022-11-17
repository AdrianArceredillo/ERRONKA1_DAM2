using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PruebaGrafico0.Models
{
    public class res_partner
    {
        [Key]
        public int id { get; set; }
        public string name { get; set; }
        public string display_name { get; set; }
        public string email { get; set; }

        public virtual List<purchase_order_line> Purchase_Order_Lines { get; set; }

    }
}
