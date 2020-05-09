package projek.dirumahaja.model.tugas;

import com.google.gson.annotations.SerializedName;

public class KelasItem{

	@SerializedName("deskripsiTugas")
	private String deskripsiTugas;

	@SerializedName("idTugas")
	private int idTugas;

	@SerializedName("judulTugas")
	private String judulTugas;

	@SerializedName("tanggalUpload")
	private String tanggalUpload;

	@SerializedName("namaKelas")
	private String namaKelas;

	@SerializedName("idKelas")
	private int idKelas;

	@SerializedName("keterangan")
	private int keterangan;

	@SerializedName("tanggalTenggat")
	private String tanggalTenggat;

	@SerializedName("subKelas")
	private String subKelas;

	public int getKeterangan() {
		return keterangan;
	}

	public String getDeskripsiTugas(){
		return deskripsiTugas;
	}

	public int getIdTugas(){
		return idTugas;
	}

	public String getJudulTugas(){
		return judulTugas;
	}

	public String getTanggalUpload(){
		return tanggalUpload;
	}

	public String getNamaKelas(){
		return namaKelas;
	}

	public int getIdKelas(){
		return idKelas;
	}

	public String getTanggalTenggat(){
		return tanggalTenggat;
	}

	public String getSubKelas() {
		return subKelas;
	}

	@Override
 	public String toString(){
		return
			"KelasItem{" + 
			"deskripsiTugas = '" + deskripsiTugas + '\'' + 
			",idTugas = '" + idTugas + '\'' + 
			",judulTugas = '" + judulTugas + '\'' +
			",keterangan = '" + keterangan + '\'' +
			",tanggalUpload = '" + tanggalUpload + '\'' +
			",namaKelas = '" + namaKelas + '\'' + 
			",idKelas = '" + idKelas + '\'' +
			",subKelas = '" + subKelas + '\'' +
			",tanggalTenggat = '" + tanggalTenggat + '\'' +
			"}";
		}
}