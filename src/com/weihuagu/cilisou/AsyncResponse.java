package com.weihuagu.cilisou;

import java.util.List;

public interface AsyncResponse {
	public void onDataReceivedSuccess(List<CiliInfo> cililist);
    public  void onDataReceivedFailed();
}
