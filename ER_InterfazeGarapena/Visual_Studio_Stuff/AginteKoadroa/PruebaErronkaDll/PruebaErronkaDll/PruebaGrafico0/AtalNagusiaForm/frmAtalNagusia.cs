using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PruebaGrafico0.AtalNagusiaForm
{
    public partial class frmAtalNagusia : Form
    {
        public frmAtalNagusia()
        {
            InitializeComponent();
        }

        private void frmAtalNagusia_Load(object sender, EventArgs e)
        {
            this.gbDatuMota.ForeColor = System.Drawing.Color.Green;
        }
    }
}
