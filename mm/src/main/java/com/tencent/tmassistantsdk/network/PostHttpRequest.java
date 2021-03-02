package com.tencent.tmassistantsdk.network;

import com.qq.taf.jce.JceStruct;
import com.tencent.f.h;
import com.tencent.mm.R;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.tmassistantsdk.util.TMLog;
import org.apache.http.client.methods.HttpPost;

public abstract class PostHttpRequest {
    static final String REQUEST_SERVER_URL = (HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e1u) + FilePathGenerator.ANDROID_DIR_SEP);
    static final String TAG = "BaseHttpRequest";
    HttpPost mHttpPost = null;

    /* access modifiers changed from: protected */
    public abstract void onFinished(JceStruct jceStruct, JceStruct jceStruct2, int i2);

    /* access modifiers changed from: protected */
    public synchronized boolean sendRequest(final JceStruct jceStruct) {
        if (jceStruct != null) {
            if (this.mHttpPost == null) {
                h.RTc.ba(new Runnable() {
                    /* class com.tencent.tmassistantsdk.network.PostHttpRequest.AnonymousClass1 */

                    /* JADX WARNING: Removed duplicated region for block: B:20:0x0091  */
                    /* JADX WARNING: Removed duplicated region for block: B:42:0x0102  */
                    /* JADX WARNING: Removed duplicated region for block: B:47:0x0129  */
                    /* JADX WARNING: Removed duplicated region for block: B:52:0x0153  */
                    /* JADX WARNING: Removed duplicated region for block: B:57:0x0167  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                        // Method dump skipped, instructions count: 388
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmassistantsdk.network.PostHttpRequest.AnonymousClass1.run():void");
                    }
                });
            }
        }
        return false;
    }

    public synchronized void cancleRequest() {
        if (this.mHttpPost != null && !this.mHttpPost.isAborted()) {
            TMLog.i(TAG, "BaseHttpRequest:" + this + " cancleRequest");
            try {
                this.mHttpPost.abort();
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            } finally {
                this.mHttpPost = null;
            }
        }
    }
}
