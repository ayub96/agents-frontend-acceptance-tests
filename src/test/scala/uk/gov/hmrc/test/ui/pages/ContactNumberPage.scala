/*
 * Copyright 2021 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.{By, WebElement}
import uk.gov.hmrc.test.ui.conf.TestConfiguration

object ContactNumberPage extends BasePage {
  val url: String = TestConfiguration.url("contact-frontend")
  val title: String = "Contact Number"
  def contactNumberField: WebElement = driver.findElement(By.id("number"))
  def submitButton: WebElement = driver.findElement(By.id("next-button"))
}
