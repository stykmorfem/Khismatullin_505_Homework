public class Main {
    public static void main(String[] args) {
        boolean ivanOnly3D = true;


        int ivanBudget;
        int andreyBudget;
        int katyaBudget;
        boolean vikaNoCare;

        ivanBudget = 500;
        andreyBudget = 200;
        katyaBudget = 300;
        vikaNoCare = true;
        andreyBudget = andreyBudget + 200;

        for (int i = 0; i < 1000; i++) {
            if (i % 27 == 0){
                ivanOnly3D = false;
            }
            else {
                ivanOnly3D = true;
            }
            if (ivanBudget >= i && andreyBudget >= i && katyaBudget < i && vikaNoCare) {
                if (i % 27 == 0 && ivanOnly3D){
                    System.out.println("2D, " + i + ", " + i * 0.85);
                    break;
                }
                else if (i % 35 == 1 && ivanOnly3D){
                    System.out.println("3D, " + i + ", " + i * 0.85);
                    break;
                }
            }
        }
    }
}
