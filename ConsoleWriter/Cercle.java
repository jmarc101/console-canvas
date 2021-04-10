public final class Cercle extends Forme {

    private final int rayon;  //Rayon du cercle


    /**
     * Constructeur du cercle
     * @param canva le Tableau principal
     * @param x coordonnée x du centre
     * @param y coordonnée y du centre
     * @param r rayon du cercle
     */
    public Cercle(Tableau canva, int x, int y, int r){
        super(canva, x, y);
        this.rayon = r;
        creeForme();
    }


    /**
     * Algorithme pour créer le cercle dans la matrice 2D forme.
     * PseudoCode pris de l'énoncé du TP.
     */
    @Override
    protected void creeForme() {
        int r = this.rayon;
        int posX = this.getPosX();
        int posY = this.getPosY();
        char car = this.getCar();

        char[][] nouveauTableau = getTabVide();

        int x = 0;
        int y = r;
        int m = 5 - 4 * r;

        int haut = nouveauTableau.length; //hauteur
        int larg = nouveauTableau[0].length; //largeur

        while (x <= y) {

            //if imbriqués: vérifient que le pixel n'est pas out of bounds

            if ((y + posY) >= 0 && (y + posY) < haut){
                if ((x + posX) >= 0 && (x + posX) < larg)
                    nouveauTableau[y + posY][x + posX] = car;
                if ((-x + posX) >= 0 && (-x + posX) < larg)
                    nouveauTableau[y + posY][-x + posX] = car;

            }

            if ((x + posY) >= 0 && (x + posY) < haut){
                if ((y + posX) >= 0 && (y + posX) < larg)
                    nouveauTableau[x + posY][y + posX] = car;
                if ((-y + posX) >= 0 && (-y + posX) < larg)
                    nouveauTableau[x + posY][-y + posX] = car;
            }

            if ((-y + posY) >= 0 && (-y + posY) < haut){
                if ((x + posX) >= 0 && (x + posX) < larg)
                    nouveauTableau[-y + posY][x + posX] = car;
                if ((-x + posX) >= 0 && (-x + posX) < larg)
                    nouveauTableau[-y + posY][-x + posX] = car;
            }

            if ((-x + posY) >= 0 && (-x + posY) < haut){
                if ((y + posX) >= 0 && (y + posX) < larg)
                    nouveauTableau[-x + posY][y + posX] = car;
                if ((-y + posX) >= 0 && (-y + posX) < larg)
                    nouveauTableau[-x + posY][-y + posX] = car;
            }


            if (m > 0) {
                y--;
                m = m - 8 * y;
            }

            x++;
            m = m + 8 * x + 4;

        }
        this.setForme(nouveauTableau);
    }
}
