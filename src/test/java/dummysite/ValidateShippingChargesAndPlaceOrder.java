// package dummysite;

//import io.github.sskorol.core.DataSupplier;
//import org.testng.annotations.Test;
//import java.util.stream.Stream;
//import static dummysite.Product.IPHONE14;
//import static dummysite.UserType.*;
//
//public class ValidateShippingChargesAndPlaceOrder {
//
//  @Test(dataProvider = "getUser")
//  public void validateShippingChargesAndPlaceOrder(AmazonUser amazonUser) {
//    new LoginPage()
//      .logIntoApplication(amazonUser.getUserName(),amazonUser.getPassWord())
//      .SearchForProductAndClick(IPHONE14)
//      .ValidateShippingCharges(amazonUser.getUserType());
//      //.AddToCart()
//      //.Validate_ShippingCharges_In_OrderConfirmationPage()
//      //.PlaceOrder();
//
//    //Add assertion for order confirmation text
//  }
//
//  @DataSupplier
//  public Stream<AmazonUser> getUser () {
//    return Stream.of(
//      AmazonUser.BuildUser().setUserName("primeusername").setPassWord("primeuserpassword").setUserType(PRIME).returnUser(),
//      AmazonUser.BuildUser().setUserName("primeusername").setPassWord("primeuserpassword").setUserType(STANDARD).returnUser(),
//      AmazonUser.BuildUser().setUserName("primeusername").setPassWord("primeuserpassword").setUserType(NORMAL).returnUser());
//  }
//
//}
