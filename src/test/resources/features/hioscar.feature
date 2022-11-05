Feature: Hioscar Search
@hioskar
  Scenario: Title Verification

  Given user is on homepage and user clicks "Search network"
  When and Selects "2023" year for Coverage year
  And From Coverage access dropdown Selects "Employer-provided" option
  And From Network partner dropdown Select "Oscar" option
  And From Coverage area dropdown Select "New Jersey"
  And Clicks Continue button
  Then Verify title contains "Oscar"