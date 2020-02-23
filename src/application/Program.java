package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import etities.ImportedProduct;
import etities.Product;
import etities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> list = new ArrayList<>();
		System.out.print("Enter the number of products:");
		int n = sc.nextInt();
	    
		for(int i = 1;i<=n; i++) {
			System.out.println("Product #"+i+ " data:");
			
			System.out.print("Common, used or imported (c/u/i)?");
			char comon = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if(comon == 'i') {
				System.out.print("Customs fee: ");
				double customsfee = sc.nextDouble();
				Product importedProduct = new ImportedProduct(name, price, customsfee);
				list.add(importedProduct);
			}else if(comon == 'c') {
			     Product  product = new Product(name, price);
				 list.add(product);
			}else {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufacturedate = sdf.parse(sc.next());
				Product usedproduct = new UsedProduct(name, price, manufacturedate);
				list.add(usedproduct);
			}
		}
		
		System.out.println();
		System.out.println("Price Tags");
		for (Product prod : list) {
			//para todaal isa que contem alguma coisa 
			System.out.println(prod.priceTag());
		}
		sc.close();

	}

}
