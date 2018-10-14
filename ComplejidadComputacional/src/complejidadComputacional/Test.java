package complejidadComputacional;

public class Test {

	public static void main(String[] args) {
		int k=5,x=1;
		long startTime, endTime, totalTime;
		BinomioNewton b=new BinomioNewton();
		Polinomio p= new Polinomio(k,b.coeficientesDinamica(1, 0, k));
		
		System.out.println("Punto 2.1: ");
		System.out.println(p.evaluarHorner(x));
		System.out.println(p.evaluarMsucesivas(x));
		System.out.println(p.evaluarPow(x));
		System.out.println(p.evaluarProgDinamica(x));
		System.out.println(p.evaluarRecursiva(x));
		System.out.println(p.evaluarRecursivaPar(x));
		
		
		System.out.println("\nTiempos(En nanosegundos):\nPunto 2.1: ");
		
		
		startTime = System.nanoTime();
		p.evaluarMsucesivas(x);
		endTime   = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println("\n\nSumas Sucesivas: "+totalTime);
		
		startTime = System.nanoTime();
		p.evaluarRecursiva(x);
		endTime   = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println("REcursiva: "+totalTime);
		
		startTime = System.nanoTime();
		p.evaluarRecursivaPar(x);
		endTime   = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println("Recursiva Par: "+totalTime);
		
		startTime = System.nanoTime();
		p.evaluarProgDinamica(x);
		endTime   = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println("Dinamica: "+totalTime);
		
		startTime = System.nanoTime();
		p.evaluarPow(x);
		endTime   = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println("Pow: "+totalTime);
		
		startTime = System.nanoTime();
		p.evaluarHorner(x);
		endTime   = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println("Horner: "+totalTime);
	
		System.out.println("Punto 2.2 : ");
		System.out.println("\n\n\n");
		startTime = System.nanoTime();
		b.coeficientes(1, 1, k);
		endTime   = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println("Coeficientes: "+totalTime);
		
		
		
		startTime = System.nanoTime();
		b.coeficientesDinamica(1, 1, k);
		endTime   = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println("CoeficientesDinamica: "+totalTime);
		
		startTime = System.nanoTime();
		b.coeficientesRecursiva(1, 1, k);
		endTime   = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println("CoeficientesRecursiva: "+totalTime);
		
		
	}

}
