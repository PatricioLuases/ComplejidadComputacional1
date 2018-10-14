package complejidadComputacional;

public class Polinomio {

	int grado;
	double coeficientes[];
	
	public Polinomio(int grado2, double[] v) {
		this.grado=grado2;
		this.coeficientes=new double[grado+1];
		for(int i=0;i<v.length;i++)
			this.coeficientes[i]=v[i];
	}


	public double evaluarMsucesivas(double x)
	{
		double res=0,aux;
		
		for(int i=0;i<this.coeficientes.length;i++)
		{
			aux=1;
			for(int j=0;j<this.grado-i;j++)
				aux*=x;
			res+=aux*this.coeficientes[i];
		}
		
		//Complejidad: O(n²)
		
		return res;
	}
	
	public double evaluarRecursiva(double x)
	{
		double res=0;
		
		for(int i=0;i<this.coeficientes.length;i++)
				res+=this.coeficientes[i]*potencia(x,grado-i);
		return res;
		//Complejidad: O(n²)
	}
	public double evaluarRecursivaPar(double x)
	{
		double res=0;
		
		for(int i=0;i<this.coeficientes.length;i++) {
			res+=this.coeficientes[i]*potencia2(x,grado-i);}
		return res;
		//Complejidad: O(n log n)
	}
	
	
	
	
	public double evaluarProgDinamica(double x)
	{
		double res=0;
		double tabla[]=new double[this.coeficientes.length];
		for(int i=tabla.length-1;i>=0;i--)
		{
			tabla[i]=i==tabla.length-1?1:x*tabla[i+1];
			res+=this.coeficientes[i]*tabla[i];
		}
		return res;
		//Complejidad: O(n)
	}
	
	
	/*
	public double evaluarMejorada(double x)
	{
		
	}
	*/
	public double evaluarPow(double x)
	{
		double res=0;
		
		for(int i=0;i<this.coeficientes.length;i++)
			res+=this.coeficientes[i]*Math.pow(x,grado-i);
		return res;
		/*Complejidad: O(n)
		 
		  
		Nota: Es seguro asumir que el metodo Math.pow tiene una complejidad computacional O(1)
		Fuentes: https://stackoverflow.com/questions/32418731/java-math-powa-b-time-complexity
		  */
		 
	}
	
	public double evaluarHorner(double x)
	{
		double res=1;
		for(int i=0;i<this.coeficientes.length;i++)
			res=i==0?this.coeficientes[i]:res*x+this.coeficientes[i];
		return res;
		//Complejidad O(n)
	}
	
	
	private double potencia2(double x, double exp)
	{
		if(exp==0)
			return 1;
		if(exp%2==0)
			return potencia2(x*x,exp/2);
		return x*potencia2(x,exp-1);		
	}
	
	
	
	
	private double potencia(double x, double exp)
	{
		if(exp==0)
			return 1;
		return x*potencia(x,exp-1);		
	}
}