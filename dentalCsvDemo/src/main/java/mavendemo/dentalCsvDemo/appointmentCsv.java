package mavendemo.dentalCsvDemo;

public class appointmentCsv {
	int ap_no;
	String p_name,p_address,date;
	
	public int getAp_no() {
		return ap_no;
	}

	public void setAp_no(int ap_no) {
		this.ap_no = ap_no;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_address() {
		return p_address;
	}

	public void setP_address(String p_address) {
		this.p_address = p_address;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	appointmentCsv(int ap_no,String p_name,String p_address,String date){
		this.ap_no = ap_no;
		this.p_name = p_name;
		this.p_address = p_address;
		this.date = date;
	}

}
