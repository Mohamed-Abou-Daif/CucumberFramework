Feature: Verify Subscription Packages on stc tv website
  @Skip
  Scenario Outline: Validate Subscription Packages for different countries
    Given user navigate to the stc tv website '<Country>'
    When user loaded successfully to '<Country>' page
    Then I should see the subscription '<Package Type>'

    Examples:
      | Country  | Package Type |
      | Bahrain  | lite         |
      | KSA      | classic      |
      | Kuwait   | premium      |

  Scenario Outline: Validate Subscription Packages for KSA
    Given user navigate to the stc tv website "KSA"
    When user loaded successfully to "KSA" page
    Then I should see the subscription '<Package Type>', '<Price>' and '<Currency>'
    Examples:
      | Package Type | Price       | Currency |
      | lite        | 15 SAR/month | SAR      |
      | classic     | 25 SAR/month | SAR      |
      | premium     | 60 SAR/month | SAR      |

  Scenario Outline: Validate Subscription Packages for Kuwait
    Given user navigate to the stc tv website "Kuwait"
    When user loaded successfully to "Kuwait" page
    Then I should see the subscription '<Package Type>', '<Price>' and '<Currency>'
    Examples:
      | Package Type | Price         | Currency |
      | lite         | 1.2 KWD/month | KWD      |
      | classic      | 2.5 KWD/month | KWD      |
      | premium      | 4.8 KWD/month | KWD      |

  Scenario Outline: Validate Subscription Packages for Bahrain
    Given user navigate to the stc tv website "Bahrain"
    When user loaded successfully to "Bahrain" page
    Then I should see the subscription '<Package Type>', '<Price>' and '<Currency>'
    Examples:
      | Package Type | Price       | Currency |
      | lite         | 2 BHD/month | BHD      |
      | classic      | 3 BHD/month | BHD      |
      | premium      | 6 BHD/month | BHD      |
