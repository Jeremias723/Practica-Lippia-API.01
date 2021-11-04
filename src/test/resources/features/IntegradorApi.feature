Feature: Time tracker example
  As an api user I want to execute request in order to get proper responses.

  @TimeTracker @GetTimeEntries
  Scenario Outline: Example scenario for get all time entries
    Given My account created in clockify and my X-Api-Key
    And My valid workspace id
    And My valid project id
    When I perform a '<operation>' to '<entity>' with the endpoint '<jsonName>' and ''
    And status code <status> is obtained
    Then Validate the expected response was obtained in <entity>

    Examples:
      | operation | entity   | jsonName         | status |
      | GET       | GET_TIME | time/getAllTimes | 200    |


  @TimeTracker @AdHours
  Scenario Outline: Example scenario for add hours on the selected proyect

    Given My account created in clockify and my X-Api-Key
    And My valid project id
    And My valid workspace id
    And A <description> for the time entrie
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And status code <status> is obtained
    Then Validate the expected <description> on the new time entrie

    Examples:
      | operation | entity   | jsonName     | status | description           |
      | POST      | ADD_TIME | time/addTime | 201    | CREADO DESDE INTELLIJ |


  @TimeTracker @EditHour
  Scenario Outline:Example scenario for edit a hour on the project

    Given My account created in clockify and my X-Api-Key
    And My valid project id
    And My valid workspace id
    And Save the time entry id
    And I have a new hour <startedHour> to set
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And status code <status> is obtained

    Examples:
      | operation | entity    | jsonName      | status | startedHour          |
      | PUT       | EDIT_TIME | time/editTime | 200    | 2018-06-12T10:00:37Z |

  @TimeTracker @DeleteTimeEntry
  Scenario Outline: Example scenario for delete a time entry on the project

    Given My account created in clockify and my X-Api-Key
    And My valid project id
    And My valid workspace id
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And status code <status> is obtained
    Examples:
      | operation | entity      | jsonName        | status |
      | DELETE    | DELETE_TIME | time/deleteTime | 204    |
