package com.tencent.map.tools.net.adapter;

import android.content.Context;
import android.os.Bundle;
import com.tencent.map.tools.net.NetAdapter;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.http.HttpCanceler;
import java.util.HashMap;

public abstract class AbsNetImpl implements NetAdapter {
    private static final String TAG = "NetImpl";
    private boolean mForceHttps = true;
    protected Bundle mParams;

    /* access modifiers changed from: protected */
    public abstract void onCreateNet(Context context, Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract NetResponse onGetRequest(String str, String str2, int i2, int i3, HashMap<String, String> hashMap, HttpCanceler httpCanceler);

    /* access modifiers changed from: protected */
    public abstract NetResponse onPostNoBuffer(String str, String str2, byte[] bArr);

    /* access modifiers changed from: protected */
    public abstract NetResponse onPostRequest(String str, String str2, byte[] bArr, int i2, HashMap<String, String> hashMap, HttpCanceler httpCanceler, int i3);

    /* access modifiers changed from: protected */
    public abstract void onRangePost(String str, byte[] bArr, String str2, String str3, String str4, String str5, HttpCanceler httpCanceler);

    public void setArguments(Bundle bundle) {
        this.mParams = bundle;
    }

    public void setForceHttps(boolean z) {
        this.mForceHttps = z;
    }

    public boolean isForceHttps() {
        return this.mForceHttps;
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public void initNet(Context context) {
        try {
            onCreateNet(context, this.mParams);
        } catch (Exception e2) {
            new StringBuilder("initNet error:").append(e2.toString());
        }
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public NetResponse doGet(String str, String str2, int i2, int i3, HashMap<String, String> hashMap, HttpCanceler httpCanceler) {
        try {
            return onGetRequest(str, str2, i2, i3, hashMap, httpCanceler);
        } catch (Exception e2) {
            return new NetResponse(e2);
        }
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public NetResponse doPost(String str, String str2, byte[] bArr, int i2, int i3, HashMap<String, String> hashMap, HttpCanceler httpCanceler) {
        try {
            return onPostRequest(str, str2, bArr, i2, hashMap, httpCanceler, i3);
        } catch (Exception e2) {
            return new NetResponse(e2);
        }
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public NetResponse doPostNoBuffer(String str, String str2, byte[] bArr) {
        try {
            return onPostNoBuffer(str, str2, bArr);
        } catch (Exception e2) {
            return new NetResponse(e2);
        }
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public void doRangePost(String str, byte[] bArr, String str2, String str3, String str4, String str5, HttpCanceler httpCanceler) {
        try {
            onRangePost(str, bArr, str2, str3, str4, str5, httpCanceler);
        } catch (Exception e2) {
        }
    }

    protected static String parseCharset(String str) {
        if (str == null) {
            return "GBK";
        }
        String[] split = str.split(";");
        for (String str2 : split) {
            if (str2.contains("charset")) {
                String[] split2 = str2.split("=");
                if (split2.length > 1) {
                    return split2[1].trim();
                }
                return "GBK";
            }
        }
        return "GBK";
    }
}
