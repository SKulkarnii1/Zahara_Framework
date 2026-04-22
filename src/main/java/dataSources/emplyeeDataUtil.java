package dataSources;
import dataSources.RewriteExcel;

import java.io.IOException;

import Wrappers.WebCommonPath;

public class emplyeeDataUtil {
	// static method to get employee full name by srNo without UI
    public static String getEmployeeName(int srNo) throws IOException {
        String firstName = RewriteExcel.readDataFromExcel(
                WebCommonPath.TestData, "Sheet1", "FirstName", srNo);

        String lastName = RewriteExcel.readDataFromExcel(
                WebCommonPath.TestData, "Sheet1", "LastName", srNo);

        return lastName + ", "+ firstName;
    }

}
