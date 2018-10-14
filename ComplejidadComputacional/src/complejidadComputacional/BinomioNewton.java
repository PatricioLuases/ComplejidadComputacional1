package complejidadComputacional;

public class BinomioNewton {
	
	
	 double terminok(double a, double b, int n, int k) {
	    	return combinatorio(n,k)*Math.pow(a,k)*Math.pow(b,n-k);
	    	//Complejidad: O(n)
	 }

	
	double[] coeficientes(double a, double b, int n)
	{
		double v[]=new double[n+1];
		int k;
		for(int i=0;i<v.length;i++)
			v[i]=combinatorio(n,k=n-i)*Math.pow(a,k)*Math.pow(b,n-k);
		return v;
		//Complejidad:O(n²)
	}
		
   
	double[] coeficientesRecursiva(double a, double b, int n)
	{
		double v[]=new double[n+1];
		double k;
		for(int i=0;i<v.length;i++)
			v[i]=combinatorioRecursivo(n,k=n-i)*Math.pow(a,k)*Math.pow(b,n-k);
		return v;
		//Complejidad: O(n*2^n)
	} 


	
	double [] coeficientesDinamica(double a, double b, int n)
	{
		double[] v=trianguloTartaglia(n);
		for(int i=0;i<v.length;i++)
			v[i]*=(Math.pow(a,n--)*Math.pow(b, i));
		return v;
		//Complejidad: O(n²)
	}
	
	
	
//----------------------------------------------------------------------------------------------------
	
	
	double [] trianguloTartaglia(int n)  //Calculo el triangulo de Tartaglia mediante programacion dinamica
	{
		double [][]m=new double[n+1][n+1];
		for(int i=0;i<=n;i++)
			for(int j=0;j<=i;j++)
				m[i][j]=j==0||j==i?1:m[i-1][j]+m[i-1][j-1];
		return m[n];
		//Complejidad: O(n²)
	}
	
	double combinatorio(double m, double n)
	{
		return factorial(m)/(factorial(n)*factorial(m-n));
		//Complejidad: O(n)
	}
	
	double combinatorioRecursivo(double n, double k) 
	{
		if(k==0||k==n)
			return 1;
		return combinatorioRecursivo(n-1, k-1)+combinatorioRecursivo(n-1, k);	
		//Complejidad: O(2^n)
	}
	
	
	
	static double factorial(double n)
	{
		double r=1;
		for(double i=n;i>1;i--)
			r*=i;
		return r;
		//Complejidad: O(n)
	}
}
