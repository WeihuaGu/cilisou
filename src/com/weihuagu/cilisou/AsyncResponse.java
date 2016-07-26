package com.weihuagu.cilisou;

public interface AsyncResponse {
	void onDataReceivedSuccess(String[] accouts);
   void onDataReceivedFailed();
}
