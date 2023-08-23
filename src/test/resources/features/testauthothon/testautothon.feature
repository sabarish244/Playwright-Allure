Feature: Post to Twitter and validate in Instagram

  @UI
  Scenario Outline: Tweet using UI
    Given User launched Twitter
    And User Tweets TestAutothon "<Unique_text>" over UI "<post>"

    Examples: 
      | post  | Unique_text                                          |
      | 1 | so are we the expleons climbing the summit           |
      | 2 | Joyful to be part of  @stepin_forum @verity_software |
      | 3 | Hardwork paves off  |
