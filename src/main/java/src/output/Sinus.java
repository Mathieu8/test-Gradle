package src.output;

public class Sinus {
	static double Sine(double rightChild){
		rightChild = rightChild % (2 * Math.PI);
		
		double sin= rightChild;
		for (int i = 1; i < 20 ; i++){
			double a = Math.pow(-1, i);
			int j = 2*i +1;
			double b = Math.pow(rightChild, j);
			double c = SimpleOperations.factorial(j);
			double d = (a*b)/c;
			sin = sin + d;
		}
		
		return sin;
	}
	
	static double cosine(double rightChild){
		rightChild = rightChild % (2 * Math.PI);
		double cos = 1;
		for (int i = 1; i < 20 ; i++){
			double a = Math.pow(-1, i);
			int j = 2*i;
			double b = Math.pow(rightChild, j);
			double c = SimpleOperations.factorial(j);
			double d = (a*b)/c;
			cos = cos + d;
		}
		return cos;
	}
	
	static double tangent(double rightChild){
		rightChild = rightChild % (2 * Math.PI);
		double tan;
		double sin = Sine(rightChild); 
		double cos = cosine(rightChild);
		tan = SimpleOperations.division(sin,cos);
		return tan;
	}
	

}
