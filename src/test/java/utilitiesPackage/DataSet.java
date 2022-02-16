package utilitiesPackage;

import org.testng.annotations.DataProvider;

public class DataSet {
	@DataProvider(name = "data")
	public static Object dataset() {
		Object[][] obj = {
				{ "Johnnnw@gmal.com", "John", "Kanir", "1234567541a", "12", "7", "2000", "Tech", "Nikunja, Dhaka, ",
						"Dhanmodi, 1245", "New York", "6", "12345", "21", "Dhaka Dhaka Dhaka", "012345678912",
						"32145678987", " My address" },
				{ "Jacccncyy@dffda.com", "Jacy", "Jane", "455784567541a", "28", "5", "1990", "Rokomary",
						"Nilpamary, Dhaka, ", "Gulistan, 555", "Dhaka", "12", "55555", "21", "Dhakaaaaa Daka",
						"0987456123014", "4555512789", " My address" } };
		return obj;

	}

	@DataProvider(name = "userInfo")
	public static Object emailset() {
		Object[][] obj = { { "John@gmal.com", "1234567541a" }};
		return obj;

	}

}
