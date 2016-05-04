Feature: Create blog post
  As blog owner
  In order to share my thoughts with descenants
  I should be able to create blog posts

  Scenario: User creates blog post
    Given I am blog owner Bob
    #todo put new lines to content and fix string comparison
    When I create blog post "My first blog post" with contents
    """
    Hey everyone! It's my blog! Can you imagine? Feel free to comment posts (through commenting is not implemented yet).
    """
    Then I should see blog post with title "My first blog post" on blog index page
    And this blog post should have preview text "Hey everyone! It's..."
    When I go to this blog post view page
    Then I should see complete blog post contents
    """
    Hey everyone! It's my blog! Can you imagine? Feel free to comment posts (through commenting is not implemented yet).
    """

  Scenario: User creates hidden blog post
    Given I am blog owner Bob
    When I create hidden blog post "My first blog post" with contents
    """
    Hey everyone! It's my blog! Can you imagine? Feel free to comment posts (through commenting is not implemented yet).
    """
    Then I should see no posts on blog index page

  Scenario: User tries to create blog post, but he provides empty title
    Given I am blog owner Bob
    When I try to create blog post with empty title
    Then I should receive validation message saying that title should not have empty value
