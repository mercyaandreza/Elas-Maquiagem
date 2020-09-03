package com.store.api.models;


public class Purchase  {
			private Product product;
			
			private String email;
			private String nameUser = "teste";
			private String telefone;
			private String instagramAccount;
			
			
			public Purchase(Product product, String email, String nameUser, String telefone, String instagramAccount) {
				super();
				this.product = product;
				this.email = email;
				this.nameUser = nameUser;
				this.telefone = telefone;
				this.instagramAccount = instagramAccount;
			}
			
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			public String getNameUser() {
				return nameUser;
			}
			public void setNameUser(String nameUser) {
				this.nameUser = nameUser;
			}
			public String getTelefone() {
				return telefone;
			}
			public void setTelefone(String telefone) {
				this.telefone = telefone;
			}
			public String getInstagramAccount() {
				return instagramAccount;
			}
			public void setInstagramAccount(String instagramAccount) {
				this.instagramAccount = instagramAccount;
			}

			public Product getProduct() {
				return product;
			}

			public void setProduct(Product product) {
				this.product = product;
			}
			
			
			
}
