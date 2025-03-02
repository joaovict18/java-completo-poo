package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		String strPath = "d:\\temp\\exercicio_arquivos_fixacao\\source.csv";
		
		File path = new File(strPath);
		
		boolean sucess = new File(path.getParent() + "\\out").mkdir();
		
		List<String> listLines = new ArrayList<>();
		List<Product> listProducts = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(strPath))) {
			String line;
			
			// a atribuicao de br.readLine() a variavel line precisa estar dentro do loop, para que haja iteracao
			while ((line = br.readLine()) != null) {
				listLines.add(line);
			}
			
			for (String product : listLines) {
				String[] fields = product.split(",");
				
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);
				listProducts.add(new Product(name, price, quantity));
			}
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(path.getParent() + "\\out" + "\\summary.csv"));
			
			for (Product product : listProducts) {
				bw.write(product.getName() + "," + product.getPrice() * product.getQuantity());
				bw.newLine();
			}
			bw.close();
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
