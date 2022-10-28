using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PruebaGrafico0.Models
{
    public class purchase_order_line
    {
        [Key]
        public int id { get; set; }
        public string name { get; set; }
        public int sequence { get; set; }
        public int product_qty { get; set; }
        //public int product_uom_qty { get; set; }
        //public DateTime date_planned { get; set; }
        //public int product_uom { get; set; }
        public int product_id { get; set; }
        //public int price_unit { get; set; }
        public double price_subtotal { get; set; }
        public double price_total { get; set; }
        public double price_tax { get; set; }
        public int order_id { get; set; }
        //public int account_analytic_id { get; set; }
        //public int company_id { get; set; }
        //public string state { get; set; }
        //public int qty_invoiced { get; set; }
        //public string qty_received_method { get; set; }
        //public int qty_received { get; set; }
        //public int qty_received_manual { get; set; }
        //public int qty_to_invoice { get; set; }
        public int partner_id { get; set; }
        //public int currency_id { get; set; }
        //public int product_packaging_id { get; set; }
        //public double product_packaging_qty { get; set; }
        //public string display_type { get; set; }
        //public int create_uid { get; set; }
        //public DateTime create_date { get; set; }
        //public int write_uid { get; set; }
        //public DateTime write_date { get; set; }
        //public int orderpoint_id { get; set; }
        //public string product_description_variants { get; set; }
        //public Boolean propagate_cancel { get; set; }
        public int sale_order_id { get; set; }
        public int sale_line_id { get; set; }


        [ForeignKey("partner_id")]
        public res_partner res_Partner { get; set; }

    }
}
