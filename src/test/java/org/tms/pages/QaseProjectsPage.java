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

    @FindBy(xpath = "//a[contains(text(),'Projects')]")
    private WebElement menuProjectsButton;

    /*
    локаторы ниже не превращались в переменные т.к. подобрать не зависящие от названия проекта локаторы я не смогла и под эти
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


    @Step("Сhose a dropdown for the project")
    public QaseProjectsPage choseDropdownForProject (WebElement dropdown){
        waitVisibilityOf(dropdown);
        dropdown.click();
        return this;
    }

    @Step("Chose option dropdown")
    public QaseDeleteProjectPage choseOptionDropdown(WebElement valueOfDropdown){
        waitVisibilityOf(valueOfDropdown);
        valueOfDropdown.click();
        return new QaseDeleteProjectPage();
    }

    @Step("Click on delete Public project")
    public QaseDeleteProjectPage clickDropdownDeletePublicProject(){
        choseDropdownForProject(dropdownPublicProject);
        choseOptionDropdown(valueDeleteDropdownPublicProject);
        return new QaseDeleteProjectPage();
    }

    @Step("Click on delete Private project")
    public QaseDeleteProjectPage clickDropdownDeletePrivateProject(){
        choseDropdownForProject(dropdownPrivateProject);
        choseOptionDropdown(valueDeleteDropdownPrivateProject);
        return new QaseDeleteProjectPage();
    }


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







