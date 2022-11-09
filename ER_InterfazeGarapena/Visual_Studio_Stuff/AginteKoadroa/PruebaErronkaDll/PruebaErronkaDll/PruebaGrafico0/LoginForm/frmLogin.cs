using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.ToolTip;
using PruebaGrafico0.AtalNagusiaForm;

namespace PruebaGrafico0.LoginForm
{
    public partial class frmLogin : Form
    {

        #region "DECLARACIONES"
        //String usuarioLogin = "HJAAenpresa", passwordLogin = "password";
        String usuarioLogin = "adrian", passwordLogin = "password";
        int intentos_InicioSesion = 3;
        #endregion

        public frmLogin()
        {
            InitializeComponent();
        }

        private void frmLogin_Load(object sender, EventArgs e)
        {
            //textBox1.PasswordChar
            this.txtLoginPassword.Text = "";
            this.txtLoginPassword.PasswordChar = '*';
            this.txtLoginPassword.MaxLength = 25;
        }

        private async void btnDelayPrueba_Click(object sender, EventArgs e)
        {
            Thread.Sleep(2000);
            this.lblDelay.Text = "Delay Establecido Correctamente! ";
        }

        private void btnSartu_Click(object sender, EventArgs e)
        {
            //guardar los datos (usuario y contraseña) que introduce el usuario
            String user_Usuario = this.txtLoginUsername.Text;
            String user_Password = this.txtLoginPassword.Text;

            //mostrar mensaje de espera durante la "comprobación"
            this.lblDelay.Visible = true;
            this.lblDelay.Text = "Itxaron datuak egiaztatu bitartean . . .";


            if (intentos_InicioSesion == 3)
            {
                MessageBox.Show("Saioa hastean, enpresaren aurrerapenarekin lotutako datuak ikusi ahal izango dituzu.", "Terminoak onartu");
            }

            Thread.Sleep(2000);

            if (usuarioLogin.Equals(user_Usuario) && passwordLogin.Equals(user_Password))   //comprobación del login
            {
                MessageBox.Show("Saio-hasiera zuzena. Ongi etorri! ", "Identifikazioa", MessageBoxButtons.OK);
                this.lblDelay.Visible = false;
                //abrir la ventana de los gráficos
                frmAtalNagusia _frmAtalNagusia = new frmAtalNagusia();
                _frmAtalNagusia.ShowDialog();
            }
            else
            {
                --intentos_InicioSesion;

                if (intentos_InicioSesion == 0)
                {
                    MessageBox.Show("Gainerako ahaleginak: " + intentos_InicioSesion.ToString() + ". Itxi eta ireki programa berriro hasteko. ", "Identifikazioa", MessageBoxButtons.OK);
                    this.Close();
                }
                else
                {
                    this.lblDelay.Visible = false;
                    MessageBox.Show("Sartutako daturen bat ez da zuzena. Gainerako ahaleginak: " + intentos_InicioSesion.ToString() + ". ", "Identifikazioa", MessageBoxButtons.OK);
                    this.txtLoginPassword.Text = "";
                    return;
                }
            }
        }

        private void btnIrten_Click(object sender, EventArgs e)
        {
            this.Close();
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
