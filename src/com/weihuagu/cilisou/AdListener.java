package com.weihuagu.cilisou;
import com.baidu.appx.BDBannerAd;
import com.baidu.appx.BDInterstitialAd;
import com.baidu.appx.BDSplashAd;
import com.baidu.appx.BaiduAppX;

import android.util.Log;
public class AdListener implements  BDBannerAd.BannerAdListener, BDInterstitialAd.InterstitialAdListener, BDSplashAd.SplashAdListener{
	private String stringTag;
	public AdListener(String tag) {
		this.stringTag = tag;
	}
	
	@Override
	public void onAdvertisementDataDidLoadFailure() {
		Log.v("ad", "data load failure");
		
	}

	@Override
	public void onAdvertisementDataDidLoadSuccess() {
		Log.v("ad", "data load success");
	}

	@Override
	public void onAdvertisementViewDidClick() {
		Log.v("ad", "click");
	}

	@Override
	public void onAdvertisementViewDidShow() {
		Log.v("ad","show");
	}

	@Override
	public void onAdvertisementViewWillStartNewIntent() {
		Log.v("ad", "start new intent");
	}

	@Override
	public void onAdvertisementViewDidHide() {
		Log.v("ad", "hide");
	}
}
