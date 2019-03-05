# Application Flow


### User Sign up

1. User chooses sign up on the menu (available on all pages, unless the user
is signed in already).
1. User fills out the sign up form and submits.
1. Request goes to sign up servlet.
1. Servlet creates a user object and then creates user in the database.
1. Response to user confirming addition (show a message on the jsp)

### User Sign In

1. User chooses sign in on the menu (available on all pages, unless the user
is signed in already).
1. User enters username and password on form and submits.
1. If user is authenticated, the server will handle allowing access their account
 and custom feed. Something for authentication (users, users_roles, and roles table).
1. If authentication fails, show error message/page.

### View What's Happening

1. Page sends a request to view what congress has been doing most recently (limit 10)
1. Servlet? Something calls out to the API and is returned most recent json
1. Servlet sends list back to jsp?
1. Whats happening jsp displays the reports.

### View My Account

1. Page sends a request to view user account along with all favorites/personal data
1. Servlet uses the user dao to select relevant data according to criteria
1. Dao performs select and creates preference objects if used decides to add/delete
1. Servlet sends list back to my account jsp.
1. my account jsp displays the preferences/user data.

### Whats Happening Custom

1. Page sends a request to view what congress has been doing based on user preferences
that dao retrieves
1. Servlet? Something calls out to the API and is returned most recent json matching parameters
1. Servlet sends list back to jsp
1. Whats happening Custom jsp displays the reports.








