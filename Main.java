/** 
* Autor: João Ribeiro Bezerra
*/

import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();

		while (s != null) {
			System.out.println(s);

			String[] partes = s.split(":");

			if(partes.length != 3) break;

			//Checar se e' comum ou premium
			boolean premium = false;

			if(partes[0].trim().equals("Premium")){
				premium = true;
			}
			else if(!partes[0].trim().equals("Normal")) break;

			//Numero de passageiros
			int passageiros = Integer.parseInt(partes[1].trim());
			if(passageiros <= 0) break;

			//Dias de emprestimo
			String[] dias = partes[2].split(",");

			//Somar valores cobrados
			int somaSouth = 0;
			int somaWest = 0;
			int somaNorth = 0;

			for(int i=0; i<dias.length; i++){
				boolean fimDeSemana = false;
				if(dias[i].contains("sab") || dias[i].contains("dom")) fimDeSemana = true;

				//South
				if(passageiros<=4){
					if(premium == false){
						if(fimDeSemana == false) somaSouth += 210;
						else somaSouth += 200;
					}
					else{
						if(fimDeSemana == false) somaSouth += 150;
						else somaSouth += 90;
					}
				}

				//West
				if(passageiros<=2){
					if(premium == false){
						if(fimDeSemana == false) somaWest += 530;
						else somaWest += 200;
					}
					else{
						if(fimDeSemana == false) somaWest += 150;
						else somaWest += 90;
					}
				}

				//North
				if(passageiros<=7){
					if(premium == false){
						if(fimDeSemana == false) somaNorth += 630;
						else somaNorth += 600;
					}
					else{
						if(fimDeSemana == false) somaNorth += 580;
						else somaNorth += 590;
					}
				}
			}

			//Checar qual e' a melhor opcao
			if((somaNorth < somaWest || somaWest == 0) && (somaNorth < somaSouth || somaSouth == 0) && somaNorth != 0){
				System.out.println("SUVs:NorthCar");
			}
			else if((somaWest < somaNorth || somaNorth == 0) && (somaWest < somaSouth || somaSouth == 0) && somaWest != 0){
				System.out.println("Esportivos:WestCar");
			}
			else{
				System.out.println("Compactos:SouthCar");
			}

			s = br.readLine();
		}

		br.close();
	}
}
