package angular.with.spring.jwt.resource;

import java.io.Serializable;

public class  JwtTokenRequest implements Serializable {
  
  private static final long serialVersionUID = -5616176897013108345L;

  	private String username;
    private String password;
    
    //{
      //  "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJpbjI4bWludXRlcyIsImV4cCI6MTU3OTkxMjY2OSwiaWF0IjoxNTc5MzA3ODY5fQ.iSWHHpqFL8p_38xCVYYZwLE3qwfjpjtBmnudB2thG4-GDQ9dQ4vyNSTVYv61FnrLQ4FceHSCgPgIAnZ7Ez4YJQ"
    //}

    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

