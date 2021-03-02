package com.tencent.tmassistantsdk.network;

import android.text.TextUtils;
import com.tencent.f.h;
import com.tencent.mm.R;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONObject;

public abstract class GetHttpRequest {
    protected static final String REQUEST_SERVER_URL = (HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e1e) + "/cgi-bin/appstage/yyb_get_userapp_info");
    protected static final String TAG = "NetworkTask";
    protected HttpGet mHttpGet = null;

    /* access modifiers changed from: protected */
    public abstract void onFinished(JSONObject jSONObject, int i2);

    /* access modifiers changed from: protected */
    public synchronized boolean sendData(final String str) {
        if (!TextUtils.isEmpty(str) && this.mHttpGet == null) {
            h.RTc.aY(new Runnable() {
                /* class com.tencent.tmassistantsdk.network.GetHttpRequest.AnonymousClass1 */

                /* JADX WARNING: Removed duplicated region for block: B:39:0x0109  */
                /* JADX WARNING: Removed duplicated region for block: B:44:0x0130  */
                /* JADX WARNING: Removed duplicated region for block: B:49:0x0158  */
                /* JADX WARNING: Removed duplicated region for block: B:54:0x0180  */
                /* JADX WARNING: Removed duplicated region for block: B:59:0x0194  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                    // Method dump skipped, instructions count: 432
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmassistantsdk.network.GetHttpRequest.AnonymousClass1.run():void");
                }
            });
        }
        return false;
    }
}
