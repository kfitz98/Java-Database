/* Program that connects to and takes data from a MYSql database
 * Database used: https://data.gov.ie/dataset/2016-nct-pass-fail-rates-by-test-centre
 * 
 * Author: Kevin Fitzpatrick
 * Student Number: C16456052
 */

package assignment;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new Screen();
		Database connect = new Database();
		connect.Data();

	}

}
