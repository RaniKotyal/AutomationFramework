package lord.taylor.testsuites;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lord.taylor.screens.BagPage;
import lord.taylor.screens.CountryChange;
import lord.taylor.screens.MiniBag;
import lord.taylor.screens.PaymentPage;
import lord.taylor.screens.ProductDetailsPage;
import lord.taylor.screens.ReviewAndSubmitPag;
import lord.taylor.screens.SearchProduct;
import lord.taylor.screens.ShippingAndBillingPage;
import lord.taylor.screens.ThankYouPage;
import lord.taylor.testBase.TestBase;
import lord.taylor.utils.Excel;

public class Testing extends TestBase {
	static Excel excel = new Excel();
	@DataProvider
    public static Object[][] readVariant() throws IOException

    {

        return excel.readVariant();

    }

	@BeforeClass

	public void setup() throws Exception {
		init();

	}

	
	
	@Test(dataProvider = "readVariant")
	public void changeTheCountryCode(String productID,String itemquantity,String promoCode,String firstName ,String lastName,String addressLine1,String addressLine2,String city,String state,String zipCode,String emailID ,String phoneNumber,String paymentType,String cardNumber,String cardName,String month,String year,String cVV, String password) throws Exception {

		CountryChange us = new CountryChange(driver);
		// CountryChange us = PageFactory.initElements( driver, CountryChange.class );
		us.ShipToUS();
		
		System.out.println("*------- Searching Product -------*");
		SearchProduct se = new SearchProduct(driver);
		se.search(productID);
		
		System.out.println("*------- Product Details Page -------*");
		ProductDetailsPage pd = new ProductDetailsPage(driver);
		pd.pdpPage();
		
		System.out.println("*------- Mini Bag Page ---------*");
		MiniBag mb = new MiniBag(driver);
		mb.miniBag();
		
		System.out.println("*------- Bag Page ---------*");
		BagPage bp = new BagPage(driver);
		bp.bagPage(itemquantity,  promoCode,  zipCode );
		bp.loginAsGuestUser();
		
		System.out.println("*------- Shipping And Billing Page ---------*");
		ShippingAndBillingPage sb = new ShippingAndBillingPage(driver);
		sb.verifyShippingAndBillingPage( firstName , lastName, addressLine1, addressLine2, city, state, zipCode, emailID , phoneNumber);
		
		System.out.println("*------- Payment Page ---------*");
		PaymentPage pp = new PaymentPage(driver);
		pp.verifyingPaymentPage(paymentType,cardNumber,cardName,month,year,cVV);

		System.out.println("*------- Review And SubmitPag ---------*");
		ReviewAndSubmitPag rs = new ReviewAndSubmitPag(driver);
		rs.verifyReviewSubmit();
		
		System.out.println("*------- Thank You Pag ---------*");
		ThankYouPage tp = new ThankYouPage(driver);
		tp.thankyouPage();
		System.out.println("productID"+productID);
	}

	
}
