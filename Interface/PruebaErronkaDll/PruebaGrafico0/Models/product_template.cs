using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PruebaGrafico0.Models
{
    public class product_template
    {

        [Key]
        public int id { get; set; }
        //public int message_main_attachment_id { get; set; }
        public string name { get; set; }
        //public int sequence { get; set; }
        public string description { get; set; }
        public string description_purchase { get; set; }
        public string description_sale { get; set; }
        //public string detailed_type { get; set; }
        //public string type { get; set; }
        //public int categ_id { get; set; }
        //public int list_price { get; set; }
        //public int volume { get; set; }
        //public int weight { get; set; }
        //public bool sale_ok { get; set; }
        //public bool purchase_ok { get; set; }
        //public int uom_id { get; set; }
        //public int uom_po_id { get; set; }
        public int company_id { get; set; }
        //public bool active { get; set; }
        //public int color { get; set; }
        //public string default_code { get; set; }
        //public bool can_image_1024_be_zoomed { get; set; }
        //public bool has_configurable_attributes { get; set; }
        //public string priority { get; set; }
        //public int create_uid { get; set; }
        //public DateTime create_date { get; set; }
        //public int write_uid { get; set; }
        //public DateTime write_date { get; set; }
        //public string service_type { get; set; }
        //public string sale_line_warn { get; set; }
        //public string sale_line_warn_msg { get; set; }
        //public string expense_policy { get; set; }
        //public string invoice_policy { get; set; }
        //public double sale_delay { get; set; }
        //public string tracking { get; set; }
        //public string description_picking { get; set; }
        //public string description_pickingout { get; set; }
        //public string description_pickingin { get; set; }
        //public string purchase_method { get; set; }
        //public string purchase_line_warn { get; set; }
        //public string purchase_line_warn_msg { get; set; }
        //public bool service_to_purchase { get; set; }

        

    }
}
