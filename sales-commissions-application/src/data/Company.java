package data;
public class Company {

		private String companyName;
		private Address companyAddress;
		
		
		public Company(){
			companyAddress = new Address();
		}
		
		public String getName() {
			return companyName;
		}
		
		public void setName(String name) {
			this.companyName = name;
		}
		
		public void setCompanyAddress(Address companyAddress) {
		        this.companyAddress = companyAddress;
		}
		
		
		public Address getCompanyAddress(){
			
			return companyAddress;
		}
		
}
