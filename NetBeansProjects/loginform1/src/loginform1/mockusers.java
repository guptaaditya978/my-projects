package loginform1;

public class mockusers {
	
		int id;
		String name;
		String gender;
		String password;
		String mobile;
		String email;
		
		mockusers(int i,String n,String g,String p,String m,String e)
		{
			this.id=i;
			this.name=n;
			this.gender=g;
			this.password=p;
			this.mobile=m;
			this.email=e;
		}

		

		public int getId() {
			return id;
		}



		public void setId(int id) {
			this.id = id;
		}



		public String getName() {
			return name;
		}



		public void setName(String name) {
			this.name = name;
		}



		public String getGender() {
			return gender;
		}



		public void setGender(String gender) {
			this.gender = gender;
		}



		public String getPassword() {
			return password;
		}



		public void setPassword(String password) {
			this.password = password;
		}



		public String getMobile() {
			return mobile;
		}



		public void setMobile(String mobile) {
			this.mobile = mobile;
		}



		public String getEmail() {
			return email;
		}



		public void setEmail(String email) {
			this.email = email;
		}



		@Override
		public String toString() {
			return "mockusers [id=" + id + ", name=" + name + ", gender=" + gender + ", password=" + password +", mobile=" + mobile + ", email=" + email +"]";
		}
		
		
}


