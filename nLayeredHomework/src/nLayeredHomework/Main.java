package nLayeredHomework;

import nLayeredHomework.business.abstracts.UserService;
import nLayeredHomework.business.concretes.CheckUser;
import nLayeredHomework.business.concretes.UserManager;
import nLayeredHomework.core.concretes.AuthWithGoogleManagerAdapter;
import nLayeredHomework.core.concretes.EmailVerificationManager;
import nLayeredHomework.dataAccess.concretes.HibernateUserDao;
import nLayeredHomework.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		UserService service= new UserManager(new HibernateUserDao(),new CheckUser(),new AuthWithGoogleManagerAdapter(),new EmailVerificationManager());
		service.add(new User(1, "Melih", "Can", "meli@gmail.com", "12345456"));
		service.addWithGoogle(new User(1, "Melih", "Can", "meli@melih.com", "12345456"));
		service.logIn("melih@melih.com", "11111");

	}

}
