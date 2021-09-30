package pojos;

    public class Estudiante
    {
        private int idEstudiante;
        private String primer_nom;
        private String primer_ape;
        private String seg_nom;
        private String seg_ape;

        public Estudiante(int idEstudiante, String primer_nom, String primer_ape, String seg_nom, String seg_ape)
        {
            this.idEstudiante = idEstudiante;
            this.primer_nom = primer_nom;
            this.primer_ape = primer_ape;
            this.seg_nom = seg_nom;
            this.seg_ape = seg_ape;
        }

        public Estudiante()
        {

        }

        public int getIdEstudiante() {
            return idEstudiante;
        }

        public void setIdEstudiante(int idEstudiante) {
            this.idEstudiante = idEstudiante;
        }

        public String getPrimer_nom() {
            return primer_nom;
        }

        public void setPrimer_nom(String primer_nom) {
            this.primer_nom = primer_nom;
        }

        public String getPrimer_ape() {
            return primer_ape;
        }

        public void setPrimer_ape(String primer_ape) {
            this.primer_ape = primer_ape;
        }

        public String getSeg_nom() {
            return seg_nom;
        }

        public void setSeg_nom(String seg_nom) {
            this.seg_nom = seg_nom;
        }

        public String getSeg_ape() {
            return seg_ape;
        }

        public void setSeg_ape(String seg_ape) {
            this.seg_ape = seg_ape;
        }
    }
