package com.tencent.mm.plugin.topstory.ui.home;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.ui.a.b;
import com.tencent.mm.plugin.topstory.ui.a.c;
import com.tencent.mm.plugin.topstory.ui.a.e;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.protocal.protobuf.eii;
import com.tencent.mm.protocal.protobuf.eij;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;

public final class d {
    private eii GlH;
    private c GlI;
    private WebSearchWebView GlJ;
    private e GlK;
    public HashMap<Integer, eij> GlL = new HashMap<>();
    public HashMap<Integer, String> GlM = new HashMap<>();
    boolean ygl = false;

    public d() {
        AppMethodBeat.i(126060);
        AppMethodBeat.o(126060);
    }

    public final void a(eii eii, boolean z) {
        AppMethodBeat.i(126061);
        if (!this.ygl) {
            this.ygl = true;
            com.tencent.mm.plugin.topstory.ui.c.c(eii, "startCreateWB", System.currentTimeMillis());
            this.GlH = eii;
            this.GlI = new c();
            int i2 = eii.channelId <= 0 ? 100 : eii.channelId;
            String a2 = a(eii, i2, z);
            this.GlJ = new WebSearchWebView(MMApplicationContext.getContext());
            b bVar = new b();
            com.tencent.mm.plugin.topstory.ui.a.d dVar = new com.tencent.mm.plugin.topstory.ui.a.d(eii, this.GlI);
            this.GlK = new e(this.GlJ, eii, this.GlI);
            this.GlJ.a(bVar, dVar);
            this.GlJ.addJavascriptInterface(this.GlK, "topStoryJSApi");
            if (this.GlI.Gqp != null) {
                this.GlI.A(a2, this.GlM.get(Integer.valueOf(i2)), fyw());
                this.GlJ.loadDataWithBaseURL(eii.url, new String(this.GlI.Gqp), "text/html", ProtocolPackage.ServerEncoding, null);
                this.GlI.Gqp = null;
                com.tencent.mm.plugin.topstory.ui.c.c(eii, "endCreateWBWithLoadData", System.currentTimeMillis());
            } else {
                this.GlJ.loadUrl(eii.url);
                com.tencent.mm.plugin.topstory.ui.c.c(eii, "endCreateWBWithLoadURL", System.currentTimeMillis());
            }
            if (100 == i2) {
                this.GlK.aTI("");
            }
        }
        AppMethodBeat.o(126061);
    }

    public final void b(b bVar) {
        AppMethodBeat.i(126062);
        Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "attachWebViewToActivity %s", Integer.valueOf(bVar.hashCode()));
        bVar.a(this.GlI, this.GlJ, this.GlK, this.GlH);
        this.GlI = null;
        this.GlJ = null;
        this.GlK = null;
        this.GlH = null;
        this.ygl = false;
        AppMethodBeat.o(126062);
    }

    private String a(eii eii, int i2, boolean z) {
        AppMethodBeat.i(126063);
        String str = "";
        if (this.GlL.containsKey(Integer.valueOf(i2))) {
            eij eij = this.GlL.get(Integer.valueOf(i2));
            Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData SaveTs:%sms, DirectShowTs:%ss, ShowAndRefreshTs:%ss, curTs:%sms", Long.valueOf(eij.NhD), Integer.valueOf(eij.MOb), Integer.valueOf(eij.NhE), Long.valueOf(System.currentTimeMillis()));
            if (eij.NhD + ((long) (eij.MOb * 1000)) > System.currentTimeMillis()) {
                this.GlI.fzT();
                Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData No Need Auto Refresh");
                str = eij.iAc;
            } else {
                if (eij.NhD + ((long) (eij.NhE * 1000)) > System.currentTimeMillis()) {
                    this.GlI.fzT();
                    Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData Need Auto Refresh");
                    str = eij.iAc;
                } else {
                    this.GlI.fzT();
                    Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "loadWebViewShowData No Need Show CacheData");
                }
                eii.NhB.addAll(eij.MOd);
                if (z) {
                    this.GlI.a(eii, false, false, 0);
                }
            }
        } else {
            this.GlI.fzT();
            if (z) {
                this.GlI.a(eii, false, false, 0);
            }
        }
        AppMethodBeat.o(126063);
        return str;
    }

    private boolean fyw() {
        AppMethodBeat.i(126064);
        if (this.GlL.containsKey(100)) {
            eij eij = this.GlL.get(100);
            if (((long) (eij.MOb * 1000)) + eij.NhD > System.currentTimeMillis()) {
                Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "needRefreshCache false");
                AppMethodBeat.o(126064);
                return false;
            }
        }
        Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "needRefreshCache true");
        AppMethodBeat.o(126064);
        return true;
    }

    public final void cC(int i2, String str) {
        AppMethodBeat.i(126065);
        this.GlM.put(Integer.valueOf(i2), str);
        try {
            byte[] bytes = str.getBytes(ProtocolPackage.ServerEncoding);
            o oVar = new o(h.fxT());
            if (!oVar.exists()) {
                oVar.mkdirs();
            }
            s.f(h.fxT() + i2, bytes, bytes.length);
            Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "putNegDataCache write data key: %d length: %d", Integer.valueOf(i2), Integer.valueOf(bytes.length));
            AppMethodBeat.o(126065);
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", e2, "putNegDataCache", new Object[0]);
            AppMethodBeat.o(126065);
        }
    }

    public final synchronized void cD(final int i2, final String str) {
        AppMethodBeat.i(126066);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(126066);
        } else {
            Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "addNegDocId begin: %s, %s", Integer.valueOf(i2), str);
            ThreadPool.post(new Runnable() {
                /* class com.tencent.mm.plugin.topstory.ui.home.d.AnonymousClass1 */

                public final void run() {
                    JSONArray jSONArray;
                    AppMethodBeat.i(126059);
                    try {
                        String str = d.this.GlM.get(Integer.valueOf(i2));
                        if (Util.isNullOrNil(str)) {
                            jSONArray = new JSONArray();
                        } else {
                            jSONArray = new JSONArray(str);
                        }
                        jSONArray.put(str);
                        d.this.cC(i2, jSONArray.toString());
                        Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "addNegDocId finish: %s, %s", Integer.valueOf(i2), str);
                        AppMethodBeat.o(126059);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.TopStory.TopStoryWebViewMgr", "addNegDocId, exception: " + e2.getMessage());
                        AppMethodBeat.o(126059);
                    }
                }
            }, "addNegDocId");
            AppMethodBeat.o(126066);
        }
    }
}
