using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PruebaGrafico0.LoginForm
{
    public partial class frmLogin : Form
    {
        public frmLogin()
        {
            InitializeComponent();
        }

        private void frmLogin_Load(object sender, EventArgs e)
        {
            this.gbChooseUserType.Paint += PaintBorderlessGroupBox;
            //this.gbChooseUserType.BackColor = Color.Transparent;
        }


        #region "DISEÑOS_Y_ESTÉTICA"

        private void PaintBorderlessGroupBox(object sender, PaintEventArgs p)
        {
            GroupBox box = (GroupBox)sender;
            box.BackColor = Color.Transparent;
            p.Graphics.Clear(SystemColors.ControlLightLight);
            //p.Graphics.DrawString(box.Text, box.Font, Brushes.Black, 0, 0);
            
        }

        #endregion



    }
}
