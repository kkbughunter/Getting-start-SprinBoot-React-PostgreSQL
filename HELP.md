# Getting Started
1. Database Name: `Training`
2. User Name: `postgres`
3. Password: `admin`

# Testing
- GET
  http://localhost:8080/users/vijay@gmail.com
- POST
  http://localhost:8080/users
```chatinput
{
    "name":"vijay",
    "email":"vijay@gmail.com",
    "password":"0987654321"
}
```
- DELETE
  http://localhost:8080/users/vijay@gmail.com
- PUT
  http://localhost:8080/users/updatePassword
```chatinput
{
    "email":"vijay@gmail.com",
    "newPassword":"admin"
}
```