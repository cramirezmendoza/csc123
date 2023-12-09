package labWeek11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Objects;

public class Network {
// class attribute	
	String Currency;
	String Country;
	double Rate;
// constructor
	public Network(String currency, String country, double rate) 
	{
		super();
		Currency = currency;
		Country = country;
		Rate = rate;
	}

// equals
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Network other = (Network) obj;
		return Objects.equals(Country, other.Country) && Objects.equals(Currency, other.Currency)
				&& Objects.equals(Rate, other.Rate);
	}
// getters and setters
	public String getCurrency() 
	{
		return Currency;
	}

	public void setCurrency(String currency) 
	{
		Currency = currency;
	}

	public String getCountry() 
	{
		return Country;
	}

	public void setCountry(String country) 
	{
		Country = country;
	}

	public double getRate() 
	{
		return Rate;
	}

	public void setRate(double rate) 
	{
		Rate = rate;
	}
// toString
	@Override
	public String toString() 
	{
		return "Network [Currency=" + Currency + ", Country=" + Country + ", Rate=" + Rate + "]";
	}
		
//converter method
/*
 * 
 */
	

	public static void main(String[] args) throws UnknownHostException, IOException 
	{
		// TODO Auto-generated method stub
		Network usdCurrency = new Network("USD", "United States", 1.0); 
	    Network eurCurrency = new Network("ZAG", "Silver", 0.85); 
        
	    //
	    Socket client=new Socket("www.usman.cloud",80);
		
		
		OutputStream out=client.getOutputStream();
		InputStream in=client.getInputStream();
		
		//Sending reqeust 
		String request="GET /exchange-rate.csv \r\n";
		out.write(request.getBytes());
		//This will read all bytes at once
		
		Reader r=new InputStreamReader(in);
		BufferedReader br=new BufferedReader(r);
		
		String line;
		while((line=br.readLine())!=null) 
		{
			String[] currencyLine=line.split(",");
			System.out.println("CURRENCY CODE: "+currencyLine[0]+" COUNTRY: "+currencyLine[1]+ " RATE: "+currencyLine[2]);
			
			
			
		}
			
		

	}


}
