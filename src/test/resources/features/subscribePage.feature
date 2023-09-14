Feature: Verify Subscription Packages on stc tv website

  Scenario Outline: Validate Subscription Packages for different countries
    Given user navigate to the stc tv website "<URL>"
    When user loaded successfully to '<Country>' page
    Then I should see the subscription packages

    Examples:
      | URL | Country  | Package Type |
      | bh  | Bahrai  | LITE         |
      | sa  | KSA      | CLASSIC      |
      | kw  | Kuwait   | Premium      |

  Scenario Outline: check Price, currency and Packages for different countries
    Given user navigate to the stc tv website "<URL>"
    When user loaded successfully to "<Country>" page
    Then verify '<Package Type>', '<Price>' and '<Currency>'
    Examples:
      | URL | Country  | Package Type | Price  | Currency |
      | bh  | Bahrain  | LITE         | BHD 2  | BHD      |
      | sa  | KSA      | CLASSIC      | BHD 2  | BHD      |
      | kw  | Kuwait   | Premium      | BHD 2  | BHD      |







#  Scenario Outline: Validate Subscription Packages for different countries
#    Given I am on the stc tv website "https://subscribe.stctv.com/sa-en"
#    When I click on countries menu
#    And I select my country as '<Country>'
#    Then I should see the subscription packages
#    Examples:
#      | Country      |
#      | Bahrain      |
#      | KSA          |
#      | Kuwait       |
#
#    When I select my country as "Kuwait"
#    Then I should see the subscription packages
#      | Package Type | Price   | Currency |
#      | LITE         | KWD 1.2 | KWD      |
#      | CLASSIC      | KWD 2.5 | KWD      |
#      | Premium      | KWD 4.8 | KWD      |
#
#    When I select my country as "Bahrain"
#    Then I should see the subscription packages
#      | Package Type | Price | Currency |
#      | LITE         | BHD 2 | BHD      |
#      | CLASSIC      | BHD 3 | BHD      |
#      | Premium      | BHD 6 | BHD      |
