/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubahdata3;

public class Matriks {
	private int i;
	private int j;
	private int baris;
	private int kolom;
	private double[][] matriks;
	
        
        //objek hitung matriks
	public Matriks(double[][] matriks, int baris, int kolom) {
		this.baris = baris;
		this.kolom = kolom;
		this.matriks = new double[baris][kolom];
		
		for(i=0; i<this.baris; i++) {
			for(j=0; j<this.kolom; j++) {
				this.matriks[i][j] = matriks[i][j];
			}
		}
	}
	
	public void printMatriks() {
		for(i=0; i<baris; i++) {
			for(j=0; j<kolom; j++) {
				System.out.print(matriks[i][j] + " ");
			}
			
			System.out.println();
		}
	}
	
	public double getDeterminan() {
		double toReturn = 0;
		
		if(baris == kolom) {
			if(baris < 2) {
				toReturn = 0;
			} else if(baris == 2) {
				double toReturnD = (matriks[0][0] * matriks[1][1]) - (matriks[0][1] * matriks[1][0]);
				
				toReturn = toReturnD;
			} else if(baris > 2) {
				int iBaris = 0;
				int iKolom = 0;
				int i, j, k;
				double determinan = 0;
				double pengali;
				double[][] dMatriksS = new double[baris-1][kolom-1];
				
				for(i=0; i < baris; i++) {
					for(j=0; j < baris; j++) {
						if(j != 0) {
							for(k=0; k < kolom; k++) {
								if(k != i) {
									dMatriksS[iBaris][iKolom] = matriks[j][k];
									
									iKolom++;
								}
							}
							
							iBaris++;
						}
						
						iKolom = 0;
					}
					
					Matriks mDeterminan = new Matriks(dMatriksS, baris-1, kolom-1);
					pengali = matriks[0][i];
					
					if((i+1)%2 == 0) {
						pengali *= -1;
					}
					
					determinan += pengali * mDeterminan.getDeterminan();
					iBaris = 0;
				}
				
				toReturn = determinan;
			}
		} else {
			toReturn = 0;
		}
		
		return toReturn;
	}
	
	public int getBaris() {
		return baris;
	}
	
	public int getKolom() {
		return kolom;
	}
}

