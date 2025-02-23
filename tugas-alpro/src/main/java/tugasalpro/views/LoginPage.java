package tugasalpro.views;

import java.util.Scanner;

import tugasalpro.*;
import tugasalpro.managers.*;

public class LoginPage {
    private LoginManager loginManager;
    private UserMenuPage userMenuPage;
    Scanner scanner;

    public LoginPage() {
        loginManager = new LoginManager();
        userMenuPage = new UserMenuPage();

    }
    public void Logout()
    {
        loginManager.Logout();
        System.out.println("logout success");
        showWelcome();
    }
    private void showLogin()
    {
        System.out.println("#LOGIN#");
        String username;
        String password;
        do
        {
            scanner= new Scanner(System.in);
            System.out.print("username :");
            username = scanner.nextLine();
            System.out.print("password :");
            password = scanner.nextLine();
            loginManager.Login(username, password);
            
        }while(!loginManager.HasLogin());
        if(loginManager.HasLogin())
        {
            if(ApplicationSession.getLoggedUser().isAdmin())
            {
                userMenuPage.ShowMenuAdmin();
        
            }else
            {
                userMenuPage.ShowMenuPengguna();
            }
        }
    }
    
    public void showWelcome()
    {
        System.out.println("#SELAMAT DATANG#");
        int pilihan=-1;
        scanner= new Scanner(System.in);
        ///Using default user: admin, password admin for login as admin
        do
        {
            System.out.println("1. Login");
            System.out.println("2. Registrasi");
            System.out.print("Pilihan :");
            pilihan = scanner.nextInt();
        }while(pilihan < 0 || pilihan > 2) ;
        switch(pilihan)
        {
            case 1:
                showLogin();
                break;
            case 2:
                ProfilePenggunaPage registrasiPenggunaPage = new ProfilePenggunaPage();
                registrasiPenggunaPage.Registrasi();
                break;
        }
    }

}