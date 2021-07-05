/*
 * Copyright 2021 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import uk.gov.hmrc.test.ui.pages._


class RegistrationStepDef extends BaseStepDef {

  Given("a user is on the home screen"){
    driver.navigate().to(HomePage.url)
  }

  When("the user fills in all the fields with valid information"){
      HomePage.registerButton.click()

      BusinessNamePage.bNameField.sendKeys("Business Name")
      BusinessNamePage.submitButton.click()

      EmailPage.emailField.sendKeys("test@test.com")
      EmailPage.submitButton.click()

      ContactNumberPage.contactNumberField.sendKeys("0123456789")
      ContactNumberPage.submitButton.click()

      AddressPage.pNameField.sendKeys("23")
      AddressPage.postcodeField.sendKeys("AA1 2BC")
      AddressPage.submitButton.click()

      CorrespondencePage.callBox.click()
      CorrespondencePage.letterBox.click()
      CorrespondencePage.submitButton.click()

      PasswordPage.passField.sendKeys("Password1?")
      PasswordPage.passCheckField.sendKeys("Password1?")
      PasswordPage.submitButton.click()
  }

  When("the user presses the submit button") {
    SummaryPage.submitButton.click()
  }

  Then("the user should be taken to the Registration success page"){()=>
    driver.getTitle shouldBe SummaryConfPage.title
    SummaryConfPage.successText.getText should include("Application complete")
    SummaryConfPage.arnText.getText should include("Agent Reference Number:")
  }

  When("clicks change on the update business name and submits a new value"){
      SummaryPage.updateBName.click()
      BusinessNamePage.bNameField.sendKeys("New Business Name")
      BusinessNamePage.submitButton.click()
  }

  Then("the summary page should display the new business name"){()=>
    SummaryPage.bNameText.getText shouldBe "New Business Name"
  }
}