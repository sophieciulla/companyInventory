import java.util.*;
import java.io.*;
public class buyerMenu
	{
		public static ArrayList<Item> stock = new ArrayList<Item>();
		public static void main(String[] args)
			{
				fillStock();
				mainBuyer();
				
			}
		public static void mainBuyer()
		{
			System.out.println("Welcome! Are you searching for anything specific today?");
			System.out.println("1) yes");
			System.out.println("2) no");
			Scanner response = new Scanner(System.in);
			int specific = response.nextInt();
			if(specific == 1)
				{
					// Search function input
				}
			else if(specific == 2)
				{
					listInventory();
				}
		}
		public static void listInventory()
		{
			Scanner reply = new Scanner(System.in);
			System.out.println("We currently have:");
			System.out.println("--------------------");
			for(int x=0; x<stock.size(); x++)
				{
					System.out.println((x+1) + ") " + stock.get(x).getName() + " " + stock.get(x).getWholeSaleCost() + "$");
				}
			System.out.println("--------------------");
			System.out.println("What would you like to buy?");
			int buy = reply.nextInt() -1;
			boolean runner = true;
			int amount = 0;
			while(runner)
				{
					Scanner replies = new Scanner(System.in);
					System.out.println("How many would you like to buy?");
					amount = replies.nextInt();
					if(amount<=stock.get(buy).getAmount())
						{
							runner = false;
						}
					else
						{
							System.out.println("Sorry, we only have " + stock.get(buy).getAmount());
						}
				}
			System.out.println("Congradulation on your purchase of " + amount + " " + stock.get(buy).getName() + "s!");
		}
		public static void fillStock()
		{
			String fileName = "StockIndex.txt";
			String line = null;
			FileReader fileReader;
			try
				{
					fileReader = new FileReader(fileName);
					BufferedReader bufferedReader = new BufferedReader(fileReader);
					while((line = bufferedReader.readLine()) != null) {
						int x1 = 0;
						int x2 = 0;
						int x3 = 0;
						boolean one = false;
						boolean two = false;
						boolean three = false;
						for(int x=0; x<line.length(); x++)
							{
								if(line.substring(x,x+1).equals(" ") && one == false)
									{
										x1 = x;
										one = true;
									}
								else if(line.substring(x,x+1).equals(" ") && two == false)
									{
										x2 = x;
										two = true;
									}
								else if(line.substring(x,x+1).equals(" ") && three == false)
									{
										x3 = x;
										three = true;
									}
							}
						stock.add(new Item(line.substring(0, x1), line.substring(x1+1, x2), Integer.parseInt(line.substring(x2+1, x3)), Integer.parseInt(line.substring(x3+1))));
					}
		            bufferedReader.close();
				} 
			catch (FileNotFoundException e)
				{
					System.out.println("Can't find the file");
				} catch (IOException e)
				{
					System.out.println("IOException");
					
				}
		}
	}
