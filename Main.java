/**
 * 
 * 
 */
public class Main {
    public static void main(String[] args) {
        Expediteur[] expediteurs = {
            new ExpediteurCourriel(),
            new ExpediteurSms()
        };

        for (Expediteur expediteur : expediteurs) {
            expediteur.notifier("Votre commande a été expédiée.");
        }
    }
}

/**
 * 
 */
interface Notification {
    /**
     * 
     *
     * 
     */
    void envoyer(String message);
}

/**
 * 
 */
class NotificationCourriel implements Notification {
    @Override
    public void envoyer(String message) {
        System.out.println("[Courriel] " + message);
    }
}

/**
 * 
 */
class NotificationSms implements Notification {
    @Override
    public void envoyer(String message) {
        System.out.println("[SMS] " + message);
    }
}

/**
 * 
 * 
 */
abstract class Expediteur {

    /**
     * 
     * 
     *
     * 
     */
    protected abstract Notification creerNotification();

    /**
     * 
     * 
     *
     * 
     */
    public void notifier(String message) {
        Notification notification = creerNotification();
        notification.envoyer(message);
    }
}

/**
 * 
 */
class ExpediteurCourriel extends Expediteur {
    @Override
    protected Notification creerNotification() {
        return new NotificationCourriel();
    }
}

/**
 * 
 */
class ExpediteurSms extends Expediteur {
    @Override
    protected Notification creerNotification() {
        return new NotificationSms();
    }
}
