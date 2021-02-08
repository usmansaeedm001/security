problem statement:

a database stores the products and users for this application. The
passwords for each user are hashed with either bcrypt or scrypt. I chose two hashing
algorithms to give us a reason to customize the authentication logic in the example. A
column in the users table stores the encryption type. A third table stores the users’
authorities.

Solution statement:
The AuthenticationFilter intercepts the request and
then delegates the authentication responsibility to the AuthenticationManager,
which uses the AuthenticationProvider to authenticate the request. It returns the
details of a successfully authenticated call so that the AuthenticationFilter can
store these in the SecurityContext.

The custom authentication provider implements the authentication logic. 
For this, the AuthenticationProvider uses a UserDetailsService implementation 
and two PasswordEncoder implementations, one for each requested hashing algorithm. 
The UserDetailsService implementation, called JpaUserDetailsService, uses Spring Data 
and JPA to work with the database and to obtain the user’s details.


Steps : 

1 Define the password encoder objects for the two hashing algorithms.
2 Define the JPA entities to represent the user and authority tables that store the
details needed in the authentication process.
3 Declare the JpaRepository contracts for Spring Data. we
only need to refer directly to the users, so we declare a repository named
UserRepository.
4 Create a decorator that implements the UserDetails contract over the User
JPA entity.
5 Implement the UserDetailsService contract. For this, create a class named
JpaUserDetailsService. This class uses the UserRepository we create in
step 3 to obtain the details about users from the database. If JpaUser-
DetailsService finds the users, it returns them as an implementation of the
decorator we define in step 4.