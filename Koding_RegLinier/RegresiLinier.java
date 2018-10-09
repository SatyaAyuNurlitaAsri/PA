/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubahdata3;

import java.lang.Math;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class RegresiLinier {
	private int n;
	private double a;
	private ArrayList<Double> b = new ArrayList<Double>();
	private ArrayList<Double> varDependen = new ArrayList<Double>();
	private ArrayList<Double> sumVarIndependen = new ArrayList<Double>();
	private ArrayList<Double> h = new ArrayList<Double>();
	private ArrayList<ArrayList<Double>> varIndependen = new ArrayList<ArrayList<Double>>();
	private ArrayList<Matriks> matriksAN = new ArrayList<Matriks>();
	private Matriks matriksA;
	
        
        //Untuk menyimpan nilai dari variable dependen dan variabel independen
        //Untuk memproses nilai keseluruhan determinan
        //menghitung nilai Y = a + b1.x1 + b2.x2 + b3.x3 dst
	public RegresiLinier(double[] varDependen, double[][] varIndependen) {
		for(int i=0; i<varDependen.length; i++) {
			this.varDependen.add(varDependen[i]);
		}
		
		for(int i=0; i<varIndependen.length; i++) {
			ArrayList<Double> varIndDump = new ArrayList<Double>();
			
			for(int j=0; j<varIndependen[i].length; j++) {
				varIndDump.add(varIndependen[i][j]);
				
				if(i == 0) {
					n = varIndependen[i].length;
				} else if(n > varIndependen[i].length) {
					n = varIndependen[i].length;
				}
			}
			
			this.varIndependen.add(varIndDump);
		}
		
		this.calcSumVarInd();
		this.generateMatriksA();
		this.generateH();
		this.generateMatriksAN();
		
		for(int i=0; i<matriksAN.size(); i++) {
			if(i==0) {
				a = matriksAN.get(i).getDeterminan()
				/matriksA.getDeterminan();
				
				System.out.println("a=" + a);
				System.out.println();
			} else {
				b.add(
					matriksAN.get(i).getDeterminan()
					/matriksA.getDeterminan()
				);
			}
		}
		
                //System.out.println("b="+String.format("%.3f",b));
		System.out.println("b=" + b);
                System.out.println("\n");
	}
        
        //menghitung jumlah sum baris dari variable independen
	private void calcSumVarInd() {
		for(int i=0; i<varIndependen.size(); i++) {
			double sumDump = 0;
			
			for(int j=0; j<this.n; j++) {
				sumDump += Double.parseDouble(
					varIndependen.get(i).get(j).toString()
				);
			}
			
			this.sumVarIndependen.add(sumDump);
		}
	}
	
        
        //membuat matriks A
	private void generateMatriksA() {
		int ukuran = varIndependen.size() + 1;
		double[][] matriksVarInd = new double[ukuran][ukuran];
		
		for(int i=0; i<ukuran; i++) {
			for(int j=0; j<ukuran; j++) {
				if(i==0 && j==0) {
					matriksVarInd[i][j] = this.getN();
				} else if(i==0) {
					matriksVarInd[i][j] = this.getSumX(j-1);
				} else if(j==0) {
					matriksVarInd[i][j] = this.getSumX(i-1);
				} else {
					matriksVarInd[i][j] = this.getSumOf(
						this.getVarIndependen(i-1),
						this.getVarIndependen(j-1)
					);
				}
			}
		}
		
		matriksA = new Matriks(matriksVarInd, ukuran, ukuran);
	}
	
        //membuat matriks A0, A1, A2 dst sekaligus hitung perkalian antar variable
	private void generateMatriksAN() {
		int ukuran = varIndependen.size() + 1;
		
		for(int i=0; i<ukuran; i++) { // Banyaknya matriks
			double[][] matriksANDump = new double[ukuran][ukuran];
			
			for(int j=0; j<ukuran; j++) { // Banyaknya baris per matriks
				for(int k=0; k<ukuran; k++) { // Banyaknya kolom per matriks
					if(i==k) {
						matriksANDump[j][k] = (double) this.h.get(j);
					} else if(j==0 && k==0) {
						matriksANDump[j][k] = this.getN();
					} else if(j==0) {
						matriksANDump[j][k] = this.getSumX(k-1);
					} else if(k==0) {
						matriksANDump[j][k] = this.getSumX(j-1);
					} else {
						matriksANDump[j][k] = this.getSumOf(
							this.getVarIndependen(j-1),
							this.getVarIndependen(k-1)
						);
					}
				}
			}
			
			Matriks matriksDump = new Matriks(matriksANDump, ukuran, ukuran);
			
			matriksAN.add(matriksDump);
		}
	}
	
        //digunakan untuk mengenerate Nilai matriks H (X1.Y, X2.Y, X3.Y dst)
	private void generateH() {
		int ukuran = varIndependen.size() + 1;
		double[] hDump = new double[ukuran];
		
		for(int i=0; i<ukuran; i++) {
			if(i==0) {
				for(int j=0; j<varDependen.size(); j++) {
					hDump[i] += (double) this.varDependen.get(j);
				}
			} else {
				for(int j=0; j<varDependen.size(); j++) {
					hDump[i] += (double) this.varDependen.get(j)
						* (double) this.varIndependen.get(i-1).get(j);
				}
			}
			
			this.h.add(hDump[i]);
		}
	}
	
	public int getN() {
		return this.n;
	}
	
	public double getSumX(int index) {
		return Double.parseDouble(
			this.sumVarIndependen.get(index).toString()
		);
	}
	
	public double[] getAllSumX() {
		double[] toReturn = new double[sumVarIndependen.size()];
		
		for(int i=0; i<toReturn.length; i++) {
			toReturn[i] = Double.parseDouble(
				this.sumVarIndependen.get(i).toString()
			);
		}
		
		return toReturn;
	}
	
	public double[] getVarIndependen(int index) {
		double[] toReturn = new double[varIndependen.get(index).size()];
		
		for(int i=0; i<toReturn.length; i++) {
			toReturn[i] = Double.parseDouble(
				this.varIndependen.get(index).get(i).toString()
			);
		}
		
		return toReturn;
	}
	
	public double getSumOf(double[] x, double[] y) {
		double toReturn = 0;
		int n = 0;
		
		if(x.length <= y.length) {
			n = x.length;
		} else {
			n = y.length;
		}
		
		for(int i=0; i<n; i++) {
			toReturn += x[i] * y[i];
		}
		
		return toReturn;
	}
	
	public double getA() {
		return a;
	}
	
	public ArrayList<Double> getB() {
		return b;
	}
	
	public double getRegression(double[] parameter) {
		double regressionValue = 0;
		
		if(parameter.length == b.size()) {
			regressionValue = a;
			
			for(int i=0; i<b.size(); i++) {
				regressionValue += parameter[i] * (double) b.get(i);
			}
		}
		
		return regressionValue;
	}

}
