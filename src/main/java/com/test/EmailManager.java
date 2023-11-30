package com.test;

import com.test.controller.services.FetchFolderService;
import com.test.model.EmailAccount;
import com.test.model.EmailTreeItem;
import javafx.scene.control.TreeItem;

public class EmailManager {
    //Folder handling:
    private EmailTreeItem<String> foldersRoot = new EmailTreeItem<String>("");

    public EmailTreeItem<String> getFoldersRoot() {
        return foldersRoot;
    }
    public void addEmailAccount(EmailAccount emailAccount) {
        EmailTreeItem<String> treeItem = new EmailTreeItem<>(emailAccount.getAddress());
        FetchFolderService fetchFolderService = new FetchFolderService(emailAccount.getStore(), treeItem);
        fetchFolderService.start();
        foldersRoot.getChildren().add(treeItem);
    }
}
