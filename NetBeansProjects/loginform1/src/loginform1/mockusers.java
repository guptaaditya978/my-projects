package loginform1;

public class mockusers {

		int id;
		String name;
		String password;

		mockusers(int i,String n,String p)
		{
			this.id=i;
			this.name=n;
			this.password=p;
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

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public String toString() {
			return "mockusers [id=" + id + ", name=" + name + ", password=" + password + "]";
		}
		
		
}


