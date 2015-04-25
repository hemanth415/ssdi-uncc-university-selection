package com.dto;

public class WishListDTO {
	private int post_id;
	private int user_id;
	
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "WishListDTO [post_id=" + post_id + ", user_id=" + user_id + "]";
	}
}
