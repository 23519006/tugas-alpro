package tugasalpro;
//import tugasalpro.views.BookingPage;
import tugasalpro.views.LoginPage;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    
    public static void main(String[] args) {
        
        LoginPage loginPage = new LoginPage();
        loginPage.showWelcome();
        //BookingPage bp = new BookingPage();
        //bp.showInput();
    }
}
