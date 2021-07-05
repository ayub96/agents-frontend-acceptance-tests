/*
 * Copyright 2021 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.{By, WebElement}
import uk.gov.hmrc.test.ui.conf.TestConfiguration

object EmailPage extends BasePage {
  val url: String = TestConfiguration.url("email-frontend")
  val title: String = "Email"
  def emailField: WebElement = driver.findElement(By.id("email"))
  def submitButton: WebElement = driver.findElement(By.id("next-button"))
}
