package com.tencent.mm.plugin.webview;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.yb;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.webview.model.j;
import com.tencent.mm.plugin.webview.model.r;
import com.tencent.mm.protocal.protobuf.ekr;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.q;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.xweb.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class c {
    public int IJA = 0;
    public int IJB = 0;
    public CountDownLatch IJC = new CountDownLatch(1);
    public IListener IJD = new IListener<yb>() {
        /* class com.tencent.mm.plugin.webview.c.AnonymousClass4 */

        {
            AppMethodBeat.i(160410);
            this.__eventId = yb.class.getName().hashCode();
            AppMethodBeat.o(160410);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(yb ybVar) {
            AppMethodBeat.i(77819);
            yb ybVar2 = ybVar;
            Log.d("MicroMsg.WebViewTranslateHelper", "translate: TranslateMessageListResultEvent  recv");
            if (ybVar2 instanceof yb) {
                HashMap hashMap = (HashMap) ((ArrayList) ybVar2.eet.eeu).get(0);
                String str = (String) hashMap.get("BrandWording");
                if (str == null || str.trim().length() == 0) {
                    str = c.this.IJz;
                }
                c.this.IJy = str + c.this.IJy;
                hashMap.remove("BrandWording");
                final Bundle bundle = new Bundle();
                bundle.putSerializable("translate_hashmap", hashMap);
                bundle.putSerializable("is_mp_url", Boolean.FALSE);
                bundle.putSerializable("translate_tips", c.this.IJy);
                m.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.c.AnonymousClass4.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(77818);
                        c.this.IJw.invokeMiscMethod("replaceTranslatedString", bundle);
                        AppMethodBeat.o(77818);
                    }
                });
            }
            AppMethodBeat.o(77819);
            return false;
        }
    };
    private final int IJt = 0;
    private final int IJu = 1;
    private final int IJv = 2;
    WebView IJw = null;
    public LinkedList<String> IJx = null;
    public String IJy = null;
    public String IJz = null;
    public q tipDialog;

    public c() {
        AppMethodBeat.i(77820);
        AppMethodBeat.o(77820);
    }

    public static boolean a(WebView webView) {
        boolean z;
        AppMethodBeat.i(77821);
        if (webView == null || webView.isSysKernel()) {
            AppMethodBeat.o(77821);
            return false;
        }
        try {
            Bundle invokeMiscMethod = webView.invokeMiscMethod("supportTranslateWebSite", null);
            if (invokeMiscMethod != null) {
                z = invokeMiscMethod.getBoolean("result");
                Log.i("MicroMsg.WebViewTranslateHelper", "supportTranslate %b", Boolean.valueOf(z));
                AppMethodBeat.o(77821);
                return z;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.WebViewTranslateHelper", "supportTranslateWebSite error %s", e2.getMessage());
        }
        z = false;
        Log.i("MicroMsg.WebViewTranslateHelper", "supportTranslate %b", Boolean.valueOf(z));
        AppMethodBeat.o(77821);
        return z;
    }

    public final int a(WebView webView, boolean z) {
        int i2;
        AppMethodBeat.i(77822);
        if (webView == null || webView.isSysKernel()) {
            AppMethodBeat.o(77822);
            return 2;
        }
        Bundle bundle = new Bundle();
        String applicationLanguage = LocaleUtil.getApplicationLanguage();
        bundle.putString("destLanguage", applicationLanguage);
        if (z) {
            bundle.putBoolean("isFastOpen", true);
        } else {
            bundle.putBoolean("isFastOpen", false);
        }
        try {
            if (webView.isXWalkKernel()) {
                i2 = k(webView, applicationLanguage);
            } else {
                Bundle invokeMiscMethod = webView.invokeMiscMethod("detectTranslateWebSiteIsNeeded", bundle);
                if (invokeMiscMethod != null) {
                    i2 = invokeMiscMethod.getInt(OpenSDKTool4Assistant.EXTRA_ERROR_CODE, 2);
                }
                i2 = 2;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.WebViewTranslateHelper", "detectTranslateWebSiteIsNeeded error %s", e2.getMessage());
        }
        Log.i("MicroMsg.WebViewTranslateHelper", "needTranslate errCode %d,languageCode %s", Integer.valueOf(i2), applicationLanguage);
        AppMethodBeat.o(77822);
        return i2;
    }

    public final void fZn() {
        AppMethodBeat.i(77823);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        AppMethodBeat.o(77823);
    }

    private int k(WebView webView, String str) {
        AppMethodBeat.i(77824);
        Log.i("MicroMsg.WebViewTranslateHelper", "xWalkNeedTranslate in");
        this.IJw = webView;
        try {
            int[] iArr = {2};
            this.IJC = new CountDownLatch(1);
            try {
                m.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.c.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(77817);
                        c.this.IJw.invokeMiscMethod("getTranslateSampleString", null);
                        AppMethodBeat.o(77817);
                    }
                });
                Log.i("MicroMsg.WebViewTranslateHelper", "invokeMiscMethod getTranslateSampleString begin");
                this.IJC.await(500, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e2) {
                Log.w("MicroMsg.WebViewTranslateHelper", e2.getMessage());
                Log.printErrStackTrace("MicroMsg.WebViewTranslateHelper", e2, "", new Object[0]);
            }
            Log.i("MicroMsg.WebViewTranslateHelper", "xWalkNeedTranslate end");
            iArr[0] = new j().h(this.IJx, str);
            Log.i("MicroMsg.WebViewTranslateHelper", "xWalkNeedTranslate doScene end ret[0] = " + iArr[0]);
            int i2 = iArr[0];
            AppMethodBeat.o(77824);
            return i2;
        } catch (Exception e3) {
            Log.e("MicroMsg.WebViewTranslateHelper", "xWalkNeedTranslate failed");
            AppMethodBeat.o(77824);
            return 2;
        }
    }

    public final void a(WebView webView, HashMap<String, String> hashMap) {
        AppMethodBeat.i(182684);
        this.IJw = webView;
        LinkedList<ekr> linkedList = new LinkedList<>();
        for (String str : hashMap.keySet()) {
            ekr ekr = new ekr();
            ekr.NjV = Util.safeParseInt(str);
            ekr.NjW = hashMap.get(str);
            ekr.Scene = 8;
            linkedList.add(ekr);
        }
        if (!new r().d(linkedList, this.IJA, this.IJB)) {
            fZn();
            Log.d("MicroMsg.WebViewTranslateHelper", "translate: BatchGetTranslateString err !!!!");
        }
        AppMethodBeat.o(182684);
    }

    static /* synthetic */ void aXv(String str) {
        AppMethodBeat.i(77825);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("hide_option_menu", true);
        intent.putExtra("translate_webview", true);
        intent.putExtra("title", MMApplicationContext.getContext().getString(R.string.izy));
        com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(77825);
    }
}
