
/**
 * AccountManager.
 * 
 * @author Manh Nam Tran) 
 * @version (29.08.2023)
 */
import java.io.BufferedReader;//Zeile
import java.io.BufferedWriter;
import java.io.FileReader;//char
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AccountManager {
    private Map<String, EmployeeAccount> _accounts;
    
    /**
     * Initialisiert AccountManager ein HashMap
     */
    public AccountManager() {
        this._accounts = new HashMap<>();
    }

    /**
     * Registiert ein neues Konto
     * @param username ist name der Mitarbeiter
     * @param password ist passwort der Mitarbeiter
     */
    public void registerAccount(String username, String password) {
        EmployeeAccount newAccount = new EmployeeAccount(username, password);
        _accounts.put(username, newAccount);
    }

    /**
     * Uberprufen ob username und passwort richtig sind
     * @param username ist name der Mitarbeiter
     * @param password ist passwort der Mitarbeiter
     */
    public boolean authenticate(String username, String password) {
        EmployeeAccount account = _accounts.get(username); //username existiert ?
        if (account != null && account.getPassword().equals(password) ) {
            return true;
        }
        return false;
    }

    /**
     * Speichert Daten Username und Password in .txt file
     * @param filename ist name des File 
     */
    public void save_accountsToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (EmployeeAccount account : _accounts.values()) { //_accounts.values() ist EmployeeAccount newAccount = new EmployeeAccount(username, password);
                writer.write(account.getUsername() + " " + account.getPassword());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace(); //throw exception , falls es gibt
        }
    }

    /**
     * Liest die Informationen des Konto von ein File und speichert in _accounts-HashMap
     * @param filename ist name des File 
     */
    public void load_accountsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 2) {//bitte keine leerzeichnen 
                    String username = parts[0];
                    String password = parts[1];
                    EmployeeAccount account = new EmployeeAccount(username, password);
                    _accounts.put(username, account);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); //throw exception , falls es gibt
        }
    }
}

