package com.kltn.utils;

public class Response<T> {
	private int statusCode;
	private String message;
	private int dataCount;
	private int totalData;
	private T data;
	public Response() {
	}
	public Response(String message, int statusCode, T data) {
		this.message = message;
		this.statusCode = statusCode;
		this.data = data;
	}
	public Response(String message, int statusCode, T data, int dataCount, int totalData) {
		this.message = message;
		this.statusCode = statusCode;
		this.data = data;
		this.dataCount = dataCount;
		this.totalData = totalData;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public int getDataCount() {
		return dataCount;
	}
	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}
	public int getTotalData() {
		return totalData;
	}
	public void setTotalData(int totalData) {
		this.totalData = totalData;
	}
	public static class Builder<T> {
		private Response<T> response;
		public Builder() {
			this.response = new Response<T>();
		}
		public Builder<T> message(String message) {
			this.response.setMessage(message);
			return this;
		}
		public Builder<T> status(int status) {
			this.response.setStatusCode(status);
			return this;
		}
		public Builder<T> data(T data) {
			this.response.setData(data);
			return this;
		}
		public Builder<T> dataCout(int dataCount) {
			this.response.setDataCount(dataCount);
			return this;
		}
		public Builder<T> totalData(int totalData) {
			this.response.setTotalData(totalData);
			return this;
		}
		public Response<T> build() {
			return this.response;
		}
	}
}
