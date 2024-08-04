package dummysite;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder(setterPrefix = "set",builderMethodName = "BuildUser",buildMethodName = "returnUser")
@Getter
@Setter
public class AmazonUser {

  String userName;
  String passWord;
  UserType userType;
}
