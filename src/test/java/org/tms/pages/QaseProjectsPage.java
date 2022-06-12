package org.tms.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class QaseProjectsPage extends BasePage {

    @FindBy(xpath = "//div[@class='col-lg-12']//h1")
    private WebElement textProjects;

    @FindBy(xpath = "//a[@id='createButton']")
    private WebElement createNewProjectButton;

    @FindBy(xpath = "//a[contains(text(),'Projects')]")
    private WebElement menuProjectsButton;

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
    public void getProjectsPage(){
        waitVisibilityOf(menuProjectsButton);
        menuProjectsButton.click();
    }

    @Step("Get page to create a project")
    public void getPageToCreateProject(){
        waitVisibilityOf(createNewProjectButton);
        createNewProjectButton.click();
    }

    @Step("Сhose a dropdown for the project")
    public void choseDropdownForProject (WebElement dropdown){
        waitVisibilityOf(dropdown);
        dropdown.click();
    }

    @Step("Chose option dropdown")
    public void choseOptionDropdown(WebElement valueOfDropdown){
        waitVisibilityOf(valueOfDropdown);
        valueOfDropdown.click();
    }

    @Step("Click on delete Public project")
    public void clickDropdownDeletePublicProject(){
        choseDropdownForProject(dropdownPublicProject);
        choseOptionDropdown(valueDeleteDropdownPublicProject);
    }

    @Step("Click on delete Private project")
    public void clickDropdownDeletePrivateProject(){
        choseDropdownForProject(dropdownPrivateProject);
        choseOptionDropdown(valueDeleteDropdownPrivateProject);
    }


    @Step("Displayed Public project")
    public boolean displayedPublicProject() {
        waitVisibilityOf(createNewProjectButton);
        return displayedElement(namePublicProject);
    }

    @Step("Displayed Public project")
    public boolean displayedPrivateProject() {
        waitVisibilityOf(createNewProjectButton);
        return displayedElement(namePrivateProject);
    }


    @Step("Click on public project")
    public void clickOnPublicProject(){
        waitVisibilityOf(namePublicProject);
        namePublicProject.click();
    }

    @Step("Click on private project")
    public void clickOnPrivateProject(){
        waitVisibilityOf(namePrivateProject);
        namePrivateProject.click();
    }
}







