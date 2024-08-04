package dummysite;

public enum UserType {

  PRIME("Prime"),
  STANDARD("Standard"),
  NORMAL("Normal");

  String userType;

  UserType(String userType) {
    this.userType = userType;
  }
}
