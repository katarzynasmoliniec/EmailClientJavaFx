package com.test;

import com.test.controller.persistence.PersistenceAccess;
import com.test.controller.persistence.ValidAccount;
import com.test.controller.services.LoginService;
import com.test.model.EmailAccount;
import com.test.view.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch();
    }
    private PersistenceAccess persistenceAccess = new PersistenceAccess();
    private EmailManager emailManager = new EmailManager();

    @Override
    public void start(Stage stage) throws Exception {
        ViewFactory viewFactory = new ViewFactory(emailManager);
        List<ValidAccount> validAccountLis = persistenceAccess.loadFromPersistence();
        if (validAccountLis.size() > 0) {
            viewFactory.showMainWindow();
            for (ValidAccount validAccount: validAccountLis) {
                EmailAccount emailAccount = new EmailAccount(validAccount.getAddress(), validAccount.getPassword());
                LoginService loginService = new LoginService(emailAccount, emailManager);
                loginService.start();
            }
        } else {
            viewFactory.showLoginWindow();
        }
    }

    @Override
    public void stop() throws Exception {
        List<ValidAccount> validAccountList = new ArrayList<ValidAccount>();
        for (EmailAccount emailAccount: emailManager.getEmailAccounts()) {
            validAccountList.add(new ValidAccount(emailAccount.getAddress(), emailAccount.getPassword()));
        }
        persistenceAccess.saveToPersistence(validAccountList);
    }
}