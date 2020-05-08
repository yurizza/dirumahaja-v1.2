package projek.dirumahaja.model.tugas;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TugasResponse{

	@SerializedName("kelas")
	private ArrayList<KelasItem> kelas;

	@SerializedName("error")
	private boolean error;

	@SerializedName("message")
	private String message;

	public ArrayList<KelasItem> getKelas(){
		return kelas;
	}

	public boolean isError(){
		return error;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"TugasResponse{" + 
			"kelas = '" + kelas + '\'' + 
			",error = '" + error + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}