package com.pay;

import android.app.Activity;
import android.content.Context;
import com.pay.api.APPayResponseInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;

public class AndroidPay {
    public static final int LANDSCAPE = 0;
    public static final int PORTRAINT = 1;
    private static volatile AndroidPay gInstance = null;
    public Context applicationContext;
    public Activity fromActivity;
    public boolean isShowListOtherNum;
    public boolean isShowNum;
    public String offerId;
    public APPayResponseInfo payResponseInfo;
    public byte[] resdata;
    public String unit;

    private AndroidPay() {
        AppMethodBeat.i(193305);
        this.applicationContext = null;
        this.payResponseInfo = null;
        this.unit = "";
        this.isShowNum = true;
        this.isShowListOtherNum = true;
        this.payResponseInfo = new APPayResponseInfo();
        AppMethodBeat.o(193305);
    }

    public static AndroidPay singleton() {
        AppMethodBeat.i(193306);
        if (gInstance == null) {
            synchronized (AndroidPay.class) {
                try {
                    if (gInstance == null) {
                        gInstance = new AndroidPay();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(193306);
                    throw th;
                }
            }
        }
        AndroidPay androidPay = gInstance;
        AppMethodBeat.o(193306);
        return androidPay;
    }

    public static void Destory() {
    }

    public static void setOfferId(String str) {
        gInstance.offerId = str;
    }

    public static void setEnv(String str) {
        AppMethodBeat.i(193307);
        APMidasPayAPI.setEnv(str);
        AppMethodBeat.o(193307);
    }

    public static void setCustomUrlParam(String str) {
    }

    public static void setLogEnable(boolean z) {
        AppMethodBeat.i(193308);
        APMidasPayAPI.setLogEnable(z);
        AppMethodBeat.o(193308);
    }

    public static void setNumberVisible(boolean z) {
        AppMethodBeat.i(193309);
        setIsShowSaveNum(z);
        AppMethodBeat.o(193309);
    }

    public static void setResData(byte[] bArr) {
        gInstance.resdata = bArr;
    }

    public static void setPropUnit(String str) {
        gInstance.unit = str;
    }

    public static void setIsShowSaveNum(boolean z) {
        gInstance.isShowNum = z;
    }

    public static void setWechatAppId(String str) {
    }

    public static void setElseNumberVisible(boolean z) {
        gInstance.isShowListOtherNum = z;
    }

    public static String getPaySDKVersion(Activity activity) {
        AppMethodBeat.i(193310);
        String midasSDKVersion = APMidasPayAPI.getMidasSDKVersion(activity);
        AppMethodBeat.o(193310);
        return midasSDKVersion;
    }

    public static void setScreenType(int i2) {
    }

    public Context getContext() {
        return this.applicationContext;
    }
}
