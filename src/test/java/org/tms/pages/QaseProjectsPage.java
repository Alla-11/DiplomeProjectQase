package org.tms.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class QaseProjectsPage extends BasePage {

    @FindBy(xpath = "//div[@class='col-lg-12']//h1")
    private WebElement textProjects;

    @FindBy(xpath = "//a[@id='createButton']")
    private WebElement createNewProjectButton;

    @FindBy(xpath = "//span[contains(text(),'Projects')]/ancestor::a[@class='nav-link menu-link']")
    private WebElement menuProjectsButton;

    /*
    локаторы ниже не превращались в переменные т.к. подобрать не зависящие от названия локаторы я не смогла и под эти
    локаторы настроены waiter, иначе все будет ломаться
     */

    @FindBy(xpath = "//a[contains(text(),'Public web site')]/ancestor::tr/descendant::*[@class='btn btn-dropdown']")
    private WebElement dropdownPublicProject;

    @FindBy(xpath = "//a[contains(text(),'Private web site')]/ancestor::tr/descendant::*[@class='btn btn-dropdown']")
    private WebElement dropdownPrivateProject;

    @FindBy(xpath = "//a[contains(text(),'Public web site')]")
    private WebElement namePublicProject;

    @FindBy(xpath = "//a[contains(text(),'Private web site')]")
    private WebElement namePrivateProject;

    @FindBy(xpath = "//a[contains(text(),'Public web site')]/ancestor::tr/descendant::*[contains(text(),'Delete')]")
    private WebElement valueDeleteDropdownPublicProject;

    @FindBy(xpath = "//a[contains(text(),'Private web site')]/ancestor::tr/descendant::*[contains(text(),'Delete')]")
    private WebElement valueDeleteDropdownPrivateProject;




    @Step ("Get text 'Projects'")
    public String getTextProjects(){
        waitVisibilityOf(textProjects);
        return textProjects.getText();
    }

    @Step ("Get projects page")
    public QaseProjectsPage getProjectsPage(){
        waitVisibilityOf(menuProjectsButton);
        menuProjectsButton.click();
        return this;
    }

    @Step("Get page to create a project")
    public QaseCreateProjectsPage getPageToCreateProject(){
        waitVisibilityOf(createNewProjectButton);
        createNewProjectButton.click();
        return new QaseCreateProjectsPage();
    }

    @Step("Choose option select")
    public QaseProjectsPage chooseDropdownForProject (WebElement dropdown){
        waitVisibilityOf(dropdown);
        dropdown.click();
        return this;
    }

    @Step("Choose option select")
    public QaseDeleteProjectPage chooseOptionDropdown(WebElement valueOfDropdown){
        waitVisibilityOf(valueOfDropdown);
        valueOfDropdown.click();
        return new QaseDeleteProjectPage();
    }

    @Step("Click on delete Public project")
    public QaseDeleteProjectPage clickDropdownDeletePublicProject(){
        chooseDropdownForProject(dropdownPublicProject);
        chooseOptionDropdown(valueDeleteDropdownPublicProject);
        return new QaseDeleteProjectPage();
    }

    @Step("Click on delete Private project")
    public QaseDeleteProjectPage clickDropdownDeletePrivateProject(){
        chooseDropdownForProject(dropdownPrivateProject);
        chooseOptionDropdown(valueDeleteDropdownPrivateProject);
        return new QaseDeleteProjectPage();
    }


//    @Step("Displayed project")
//    public boolean displayedProject(WebElement nameProject){
//        boolean value = true;
//        waitVisibilityOf(createNewProjectButton);
//        if (nameProject == null){
//            value = false;
//        }
//        return value;
//    }
//
//    @Step("Displayed Public projects")
//    public boolean displayedPublicProject(){
//        return displayedProject(namePublicProject);
//    }
//
//    @Step("Displayed Private projects")
//    public boolean displayedPrivateProject(){
//        return displayedProject(namePrivateProject);
//    }

    @Step("Displayed Public project")
    public boolean displayedPublicProject() {
        waitVisibilityOf(createNewProjectButton);
        try {
            this.namePublicProject.isDisplayed();
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    @Step("Displayed Public project")
    public boolean displayedPrivateProject() {
        waitVisibilityOf(createNewProjectButton);
        try {
            this.namePrivateProject.isDisplayed();
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }


    @Step("Click on public project")
    public QaseRepositoryPage clickOnPublicProject(){
        waitVisibilityOf(namePublicProject);
        namePublicProject.click();
        return new QaseRepositoryPage();
    }

    @Step("Click on private project")
    public QaseRepositoryPage clickOnPrivateProject(){
        waitVisibilityOf(namePrivateProject);
        namePrivateProject.click();
        return new QaseRepositoryPage();
    }
}







