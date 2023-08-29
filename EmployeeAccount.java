/**
 * Account fur Mitarbeiter
 * @author (Manh Nam Tran) 
 * @version (29.08.2023)
 */
public class EmployeeAccount {
    private String _username;
    private String _password;
    /**
     * Initialisiert das Konto mit username und passwort
     * @param username ist name der Mitarbeiter, bitte keine leerzeichnen 
     * @param password ist passwort der Mitarbeiter, bitte keine leerzeichnen 
     */
    public EmployeeAccount(String username, String password) {
        this._username = username;
        this._password = password;
    }
    
    /**
     * Username
     */
    public String getUsername() {
        return _username;
    }
    
    /**
     * Passwort
     */
    public String getPassword() {
        return _password;
    }
}

