package src.output;

public class Error {
	 boolean error = false;
	 boolean makeNoSenseError = false;
	 boolean divedeByZeroError = false;
	
	public void DivedeByZerroError(){
		error = true;
		divedeByZeroError = true;
	}
	
	public void MakesNoSenseError() { 
	error = true;
	makeNoSenseError = true;
	}
	
	public String ErrorCheck(){
		if (error){
			if (makeNoSenseError) {
				return "ERROR: Calculation doesn't make sense";
			}
			if (divedeByZeroError) {
				return "ERROR: Divede by zero Error";
			}
		}
		
		return "";
	}
	
	public void errorReset() {
		 error = false;
		 makeNoSenseError = false;
		 divedeByZeroError = false;
	}

	
}
