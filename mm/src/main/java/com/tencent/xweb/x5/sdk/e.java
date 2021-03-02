package com.tencent.xweb.x5.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.WebView;
import com.tencent.xweb.x5.a;
import java.util.HashMap;
import java.util.Map;

public final class e implements a {
    @Override // com.tencent.xweb.x5.sdk.a
    public final void reset(Context context) {
        AppMethodBeat.i(154126);
        QbSdk.reset(context);
        AppMethodBeat.o(154126);
    }

    @Override // com.tencent.xweb.x5.sdk.a
    public final boolean getTBSInstalling() {
        AppMethodBeat.i(154127);
        boolean tBSInstalling = QbSdk.getTBSInstalling();
        AppMethodBeat.o(154127);
        return tBSInstalling;
    }

    @Override // com.tencent.xweb.x5.sdk.a
    public final int getTbsVersion(Context context) {
        AppMethodBeat.i(154128);
        int tbsVersion = QbSdk.getTbsVersion(context);
        AppMethodBeat.o(154128);
        return tbsVersion;
    }

    @Override // com.tencent.xweb.x5.sdk.a
    public final void a(h hVar) {
        AppMethodBeat.i(154129);
        QbSdk.setTbsListener(new a(hVar));
        AppMethodBeat.o(154129);
    }

    @Override // com.tencent.xweb.x5.sdk.a
    public final int startMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(154130);
        int startMiniQBToLoadUrl = QbSdk.startMiniQBToLoadUrl(context, str, hashMap, valueCallback);
        AppMethodBeat.o(154130);
        return startMiniQBToLoadUrl;
    }

    @Override // com.tencent.xweb.x5.sdk.a
    public final boolean a(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(154131);
        boolean startQbOrMiniQBToLoadUrl = QbSdk.startQbOrMiniQBToLoadUrl(context, str, hashMap, new a.d(valueCallback));
        AppMethodBeat.o(154131);
        return startQbOrMiniQBToLoadUrl;
    }

    @Override // com.tencent.xweb.x5.sdk.a
    public final void a(Context context, String str, ValueCallback<Boolean> valueCallback) {
        AppMethodBeat.i(154132);
        TbsDownloader.setAppContext(context);
        QbSdk.canOpenFile(context, str, new a.d(valueCallback));
        AppMethodBeat.o(154132);
    }

    @Override // com.tencent.xweb.x5.sdk.a
    public final void disableAutoCreateX5Webview() {
        AppMethodBeat.i(207240);
        QbSdk.disableAutoCreateX5Webview();
        AppMethodBeat.o(207240);
    }

    @Override // com.tencent.xweb.x5.sdk.a
    public final void initTbsSettings(Map<String, Object> map) {
        AppMethodBeat.i(154134);
        QbSdk.initTbsSettings(map);
        AppMethodBeat.o(154134);
    }

    @Override // com.tencent.xweb.x5.sdk.a
    public final boolean canOpenWebPlus(Context context) {
        AppMethodBeat.i(154135);
        boolean canOpenWebPlus = QbSdk.canOpenWebPlus(context);
        AppMethodBeat.o(154135);
        return canOpenWebPlus;
    }

    @Override // com.tencent.xweb.x5.sdk.a
    public final void closeFileReader(Context context) {
        AppMethodBeat.i(154136);
        QbSdk.closeFileReader(context);
        AppMethodBeat.o(154136);
    }

    @Override // com.tencent.xweb.x5.sdk.a
    public final void forceSysWebView() {
        AppMethodBeat.i(154137);
        QbSdk.forceSysWebView();
        AppMethodBeat.o(154137);
    }

    @Override // com.tencent.xweb.x5.sdk.a
    public final String getMiniQBVersion(Context context) {
        AppMethodBeat.i(207241);
        String miniQBVersion = QbSdk.getMiniQBVersion(context);
        AppMethodBeat.o(207241);
        return miniQBVersion;
    }

    @Override // com.tencent.xweb.x5.sdk.a
    public final void setUploadCode(Context context, int i2) {
        AppMethodBeat.i(154138);
        QbSdk.setUploadCode(context, i2);
        AppMethodBeat.o(154138);
    }

    @Override // com.tencent.xweb.x5.sdk.a
    public final void setWebContentsDebuggingEnabled(boolean z) {
        AppMethodBeat.i(207242);
        WebView.setWebContentsDebuggingEnabled(z);
        AppMethodBeat.o(207242);
    }

    @Override // com.tencent.xweb.x5.sdk.a
    public final void setNewDnsHostList(String str) {
        AppMethodBeat.i(207243);
        QbSdk.setNewDnsHostList(str);
        AppMethodBeat.o(207243);
    }

    static class a implements TbsListener {
        h SFI;

        public a(h hVar) {
            this.SFI = hVar;
        }

        @Override // com.tencent.smtt.sdk.TbsListener
        public final void onDownloadFinish(int i2) {
            AppMethodBeat.i(154121);
            if (this.SFI != null) {
                this.SFI.onDownloadFinish(i2);
            }
            AppMethodBeat.o(154121);
        }

        @Override // com.tencent.smtt.sdk.TbsListener
        public final void onInstallFinish(int i2) {
            AppMethodBeat.i(154122);
            if (this.SFI != null) {
                this.SFI.onInstallFinish(i2);
            }
            AppMethodBeat.o(154122);
        }

        @Override // com.tencent.smtt.sdk.TbsListener
        public final void onDownloadProgress(int i2) {
            AppMethodBeat.i(154123);
            if (this.SFI != null) {
                this.SFI.onDownloadProgress(i2);
            }
            AppMethodBeat.o(154123);
        }
    }
}
