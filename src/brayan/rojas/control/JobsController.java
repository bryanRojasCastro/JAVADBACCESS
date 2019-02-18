package brayan.rojas.control;

import java.util.ArrayList;

import brayan.rojas.models.JobsVO;
import brayan.rojas.models.MasterModel;

public class JobsController {
	// comunicandono con la bd
	private MasterModel objMasterModel;
	private ArrayList<String> tipoEmpleo;
	
	
	// establecer en el combo box de jobs
	// los titulos de empleos que existen en la bd
	

	
	public String[] tipos(){
		objMasterModel = new MasterModel();
		tipoEmpleo = objMasterModel.readData("SELECT job_title FROM jobs");
		String data[];
		//--retunr all employestypesSystem.out.println(tipoEmpleo);
		int tamanioDyanmic = tipoEmpleo.size();
		data =new String[tamanioDyanmic];
		for (int i = 0; i < data.length; i++) {
			data[i] = tipoEmpleo.get(i);
		}
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		

	}

}
