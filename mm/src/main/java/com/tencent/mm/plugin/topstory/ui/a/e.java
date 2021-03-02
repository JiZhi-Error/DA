package com.tencent.mm.plugin.topstory.ui.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.webkit.JavascriptInterface;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.x;
import com.tencent.mm.av.q;
import com.tencent.mm.av.r;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.topstory.a.c.a;
import com.tencent.mm.plugin.topstory.a.c.f;
import com.tencent.mm.plugin.topstory.a.c.j;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.ui.c;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.websearch.webview.b;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.beo;
import com.tencent.mm.protocal.protobuf.bep;
import com.tencent.mm.protocal.protobuf.eii;
import com.tencent.mm.protocal.protobuf.eiq;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.s;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e extends b<eii> {
    private c Gqx;
    WebSearchWebView Gqy;
    private boolean Gqz = true;
    private eii eel;

    public e(WebSearchWebView webSearchWebView, eii eii, c cVar) {
        this.Gqy = webSearchWebView;
        this.eel = eii;
        this.Gqx = cVar;
    }

    @Override // com.tencent.mm.plugin.websearch.webview.b
    public final int ddN() {
        return 2;
    }

    @JavascriptInterface
    public final String getSearchData(String str) {
        String str2;
        AppMethodBeat.i(126590);
        Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "getSearchData %s", str);
        if (fzV() != null) {
            fzV().fyj();
        }
        c.c(this.eel, "getSearchData", System.currentTimeMillis());
        try {
            JSONObject jSONObject = new JSONObject(str);
            eii eii = new eii();
            eii.sGQ = this.eel.sGQ;
            eii.dDv = jSONObject.optString(SearchIntents.EXTRA_QUERY, "");
            eii.offset = jSONObject.optInt("offset", 0);
            eii.scene = jSONObject.optInt("scene", 21);
            eii.sessionId = jSONObject.optString("sessionId", "");
            eii.dVO = jSONObject.optString("subSessionId", "");
            eii.hes = jSONObject.optString("searchId", "");
            eii.dPI = jSONObject.optString("requestId", "");
            eii.channelId = jSONObject.optInt("tagId", 0);
            eii.IDW = jSONObject.optString("navigationId", "");
            eii.wib = ai.ait();
            boolean optBoolean = jSONObject.optBoolean("directRequest", false);
            String optString = jSONObject.optString("extReqParams", "");
            String optString2 = jSONObject.optString("homeMsgId", "");
            if (!Util.isNullOrNil(optString)) {
                JSONArray jSONArray = new JSONArray(optString);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    aca aca = new aca();
                    aca.key = jSONObject2.optString("key", "");
                    aca.LmC = (long) jSONObject2.optInt("uintValue", 0);
                    aca.LmD = jSONObject2.optString("textValue", "");
                    eii.IDO.add(aca);
                }
            }
            if (((com.tencent.mm.plugin.ball.c.b) g.af(com.tencent.mm.plugin.ball.c.b.class)).chQ().size() > 0) {
                eii.NhC = new beo();
                for (BallInfo ballInfo : ((com.tencent.mm.plugin.ball.c.b) g.af(com.tencent.mm.plugin.ball.c.b.class)).chQ()) {
                    if (ballInfo.type == 2) {
                        String eT = ballInfo.eT("rawUrl", "");
                        if (!Util.isNullOrNil(eT) && (eT.startsWith(HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e20) + "/s") || eT.startsWith(HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e20) + "/s"))) {
                            bep bep = new bep();
                            bep.LOr = eT;
                            eii.NhC.LOq.add(bep);
                            Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "add float ball url %s", eT);
                        }
                    }
                }
            }
            if (eii.channelId == 100) {
                c cVar = this.Gqx;
                if (cVar.Gqo == null) {
                    str2 = null;
                } else {
                    str2 = (!cVar.Gqo.Gqw.sessionId.equals(eii.sessionId) || System.currentTimeMillis() - cVar.Gqo.pnE > Util.MILLSECONDS_OF_MINUTE) ? null : cVar.Gqo.Gqv;
                    cVar.Gqo = null;
                    if (Util.isNullOrNil(str2)) {
                        Log.i("MicroMsg.TopStory.TopStoryWebData", "load data from cache fail");
                    } else {
                        Log.i("MicroMsg.TopStory.TopStoryWebData", "load data from cache success %d", Integer.valueOf(str2.length()));
                    }
                }
                if (Util.isNullOrNil(str2) || optBoolean) {
                    this.Gqx.a(eii, true, optBoolean, fzV() == null ? 0 : fzV().fyn(), optString2);
                } else {
                    aTA(str2);
                }
            } else {
                this.Gqx.a(eii, true, optBoolean, fzV() == null ? 0 : fzV().fyn());
            }
            String jSONObject3 = fYQ().toString();
            AppMethodBeat.o(126590);
            return jSONObject3;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e2, "getSearchData", new Object[0]);
            String jSONObject4 = fYR().toString();
            AppMethodBeat.o(126590);
            return jSONObject4;
        }
    }

    @JavascriptInterface
    public final String searchDataHasResult(String str) {
        AppMethodBeat.i(126591);
        Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "searchDataHasResult %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("tagId", 0);
            int optInt2 = jSONObject.optInt("resultCount", 0);
            if (optInt == 110) {
                if (optInt2 > 0) {
                    g.aAh().azQ().set(ar.a.USERINFO_TOP_STORY_HAS_HAOKAN_RESULT_INT, (Object) 1);
                } else {
                    g.aAh().azQ().set(ar.a.USERINFO_TOP_STORY_HAS_HAOKAN_RESULT_INT, (Object) 0);
                }
            }
            String jSONObject2 = fYQ().toString();
            AppMethodBeat.o(126591);
            return jSONObject2;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e2, "searchDataHasResult", new Object[0]);
            String jSONObject3 = fYR().toString();
            AppMethodBeat.o(126591);
            return jSONObject3;
        }
    }

    @JavascriptInterface
    public final String stage(String str) {
        AppMethodBeat.i(126594);
        try {
            Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "stage %s", str);
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.keys() != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    c.c(this.eel, next, jSONObject.optLong(next));
                }
            }
            String jSONObject2 = fYQ().toString();
            AppMethodBeat.o(126594);
            return jSONObject2;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e2, "stage", new Object[0]);
            String jSONObject3 = fYR().toString();
            AppMethodBeat.o(126594);
            return jSONObject3;
        }
    }

    @JavascriptInterface
    public final String startSearchItemDetailPage(String str) {
        boolean z;
        AppMethodBeat.i(126595);
        Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "startSearchItemDetailPage %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("jumpUrl", "");
            String optString2 = jSONObject.optString("publishId", "");
            Intent intent = new Intent();
            intent.putExtra("rawUrl", optString);
            intent.putExtra("KPublisherId", optString2);
            Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "jump url = %s, publishId = %s", optString, optString2);
            intent.putExtra("srcUsername", jSONObject.optString("srcUserName"));
            intent.putExtra("geta8key_scene", 64);
            int optInt = jSONObject.optInt("openScene", 10000);
            int optInt2 = jSONObject.optInt("subScene", -1);
            int optInt3 = jSONObject.optInt("itemType", -1);
            intent.putExtra(e.p.OzA, optInt3);
            if (optInt3 == 5 && ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CQ(optInt3)) {
                if (!jSONObject.has("srcUserName")) {
                    Log.w("MicroMsg.TopStory.TopStoryWebViewJSApi", "invalid srcUserName");
                    z = false;
                } else if (!jSONObject.has("cover")) {
                    Log.w("MicroMsg.TopStory.TopStoryWebViewJSApi", "invalid cover");
                    z = false;
                } else if (!jSONObject.has("vid")) {
                    Log.w("MicroMsg.TopStory.TopStoryWebViewJSApi", "invalid vid");
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    Bundle bundle = new Bundle();
                    x xVar = new x();
                    xVar.dHc = jSONObject.optString("srcUserName");
                    xVar.iAg = jSONObject.optString("srcDisplayName");
                    xVar.iAi.url = optString;
                    xVar.iAi.title = jSONObject.optString("title");
                    xVar.iAi.iAq = jSONObject.optString("digest");
                    xVar.iAi.iAo = jSONObject.optString("cover");
                    xVar.iAi.type = optInt3;
                    xVar.iAi.time = (long) jSONObject.optInt("pubTime");
                    xVar.iAi.iAs = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                    xVar.iAi.videoWidth = jSONObject.optInt("videoWidth");
                    xVar.iAi.videoHeight = jSONObject.optInt("videoHeight");
                    xVar.iAi.vid = jSONObject.optString("vid");
                    xVar.z(bundle);
                    intent.putExtras(bundle);
                }
            }
            Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openScene:%s, subScene:%s, itemType:%s", Integer.valueOf(optInt), Integer.valueOf(optInt2), Integer.valueOf(optInt3));
            if (!((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(7) || !((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(fzV().eeF(), optString, optInt3, optInt, optInt2, intent)) {
                Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "startSearchItemDetailPage jump to WebViewMpUI");
                com.tencent.mm.br.c.b(fzV().eeF(), "webview", ".ui.tools.WebviewMpUI", intent);
            } else {
                Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "startSearchItemDetailPage jump to TmplWebview");
            }
            String jSONObject2 = fYQ().toString();
            AppMethodBeat.o(126595);
            return jSONObject2;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e2, "reportSearchRealTimeReport", new Object[0]);
            String jSONObject3 = fYR().toString();
            AppMethodBeat.o(126595);
            return jSONObject3;
        }
    }

    @JavascriptInterface
    public final String openProfileWithOpenId(String str) {
        AppMethodBeat.i(126598);
        Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openProfileWithOpenId %s", str);
        try {
            String string = new JSONObject(str).getString("openId");
            if (!Util.isNullOrNil(string)) {
                c.aTz(string);
            }
            String jSONObject = fYQ().toString();
            AppMethodBeat.o(126598);
            return jSONObject;
        } catch (Exception e2) {
            String jSONObject2 = fYR().toString();
            AppMethodBeat.o(126598);
            return jSONObject2;
        }
    }

    @JavascriptInterface
    public final String updateReddotTimeStamps(String str) {
        AppMethodBeat.i(126599);
        Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "updateReddotTimeStamps %s", str);
        try {
            ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().KH(new JSONObject(str).optLong("reddotTimeStamps", 0));
            String jSONObject = fYQ().toString();
            AppMethodBeat.o(126599);
            return jSONObject;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e2, "updateReddotTimeStamps", new Object[0]);
            String jSONObject2 = fYR().toString();
            AppMethodBeat.o(126599);
            return jSONObject2;
        }
    }

    @JavascriptInterface
    public final String doGoToRecVideoList(String str) {
        AppMethodBeat.i(126600);
        Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "doGoToRecVideoList %s", str);
        try {
            eit br = h.br(new JSONObject(str));
            if (fzV() != null) {
                ai.a(fzV().eeF(), br, 1);
            }
            String jSONObject = fYQ().toString();
            AppMethodBeat.o(126600);
            return jSONObject;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e2, "doGoToRecVideoList", new Object[0]);
            String jSONObject2 = fYR().toString();
            AppMethodBeat.o(126600);
            return jSONObject2;
        }
    }

    @JavascriptInterface
    public final String webViewUIReady(String str) {
        AppMethodBeat.i(126601);
        try {
            if (this.Gqz) {
                this.Gqz = false;
                if (fzV() != null) {
                    fzV().fyk();
                }
                c.c(this.eel, "webViewUIReady", System.currentTimeMillis());
                Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "traceResult:\n%s", c.a(this.eel));
            }
            String jSONObject = fYQ().toString();
            AppMethodBeat.o(126601);
            return jSONObject;
        } catch (Exception e2) {
            String jSONObject2 = fYR().toString();
            AppMethodBeat.o(126601);
            return jSONObject2;
        }
    }

    @JavascriptInterface
    public final String renderFinish(String str) {
        AppMethodBeat.i(126602);
        Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "renderFinish %s", str);
        try {
            fzV().fym();
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e2, "renderFinish error", new Object[0]);
        }
        String jSONObject = fYQ().toString();
        AppMethodBeat.o(126602);
        return jSONObject;
    }

    public final void aTA(String str) {
        AppMethodBeat.i(126603);
        try {
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("json", str);
            jSONObject.put("newQuery", this.Gqz);
            jSONObject.put("isCache", false);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.topstory.ui.a.e.AnonymousClass1 */

                @TargetApi(7)
                public final void run() {
                    AppMethodBeat.i(126577);
                    a.a(e.this, "onSearchDataReady", jSONObject.toString());
                    c.c(e.this.eel, "dataReady", System.currentTimeMillis());
                    AppMethodBeat.o(126577);
                }
            });
            AppMethodBeat.o(126603);
        } catch (Exception e2) {
            AppMethodBeat.o(126603);
        }
    }

    public final void c(String str, String str2, int i2, int i3, int i4, String str3) {
        AppMethodBeat.i(126604);
        try {
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("beginMsgId", str);
            jSONObject.put("endMsgId", str2);
            jSONObject.put("beginSeq", i2);
            jSONObject.put("endSeq", i3);
            jSONObject.put("reddotNum", i4);
            jSONObject.put(IssueStorage.COLUMN_EXT_INFO, str3);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.topstory.ui.a.e.AnonymousClass11 */

                @TargetApi(7)
                public final void run() {
                    AppMethodBeat.i(126582);
                    a.a(e.this, "notifyNumReddotChange", jSONObject.toString());
                    AppMethodBeat.o(126582);
                }
            });
            AppMethodBeat.o(126604);
        } catch (JSONException e2) {
            Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "notifyNumReddotChange " + e2.getMessage());
            AppMethodBeat.o(126604);
        }
    }

    public final void q(String str, long j2, int i2) {
        AppMethodBeat.i(236413);
        try {
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("msgId", str);
            jSONObject.put("latestTimeStamp", j2);
            jSONObject.put("reddotType", i2);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.topstory.ui.a.e.AnonymousClass12 */

                @TargetApi(7)
                public final void run() {
                    AppMethodBeat.i(126583);
                    a.a(e.this, "notifyReddot", jSONObject.toString());
                    AppMethodBeat.o(126583);
                }
            });
            AppMethodBeat.o(236413);
        } catch (JSONException e2) {
            Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "notifyReddot " + e2.getMessage());
            AppMethodBeat.o(236413);
        }
    }

    public final void aTI(final String str) {
        AppMethodBeat.i(126606);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.topstory.ui.a.e.AnonymousClass14 */

            @TargetApi(7)
            public final void run() {
                AppMethodBeat.i(126585);
                a.a(e.this, "onWebCommendEnterFromFindPage", str);
                AppMethodBeat.o(126585);
            }
        });
        AppMethodBeat.o(126606);
    }

    public final void m(String str, int i2, int i3, String str2) {
        AppMethodBeat.i(126607);
        Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "onTabSelected: %s, %s, %s, %s", str, Integer.valueOf(i2), Integer.valueOf(i3), str2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tabInfo", str);
            jSONObject.put("contentReddot", i2);
            jSONObject.put("numberReddot", i3);
            jSONObject.put("msgId", str2);
        } catch (JSONException e2) {
            Log.w("MicroMsg.TopStory.TopStoryWebViewJSApi", "onTabSelected json exception: " + e2.getMessage());
        }
        a.a(this, "onTabSelected", jSONObject.toString());
        AppMethodBeat.o(126607);
    }

    public final void fzW() {
        AppMethodBeat.i(126608);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.topstory.ui.a.e.AnonymousClass3 */

            @TargetApi(7)
            public final void run() {
                AppMethodBeat.i(126579);
                a.a(e.this, "onNavBarShadowManuallyHidden", "");
                AppMethodBeat.o(126579);
            }
        });
        AppMethodBeat.o(126608);
    }

    @JavascriptInterface
    public final String fetchNumReddot(String str) {
        AppMethodBeat.i(126609);
        Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl fetchNumReddot %s", str);
        try {
            int fxu = ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxu();
            eiq fxw = ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxw();
            eiq fxx = ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxx();
            c(fxx.msgId, fxw.msgId, fxx.jlm, fxw.jlm, fxu, fxw.extInfo);
            String jSONObject = fYQ().toString();
            AppMethodBeat.o(126609);
            return jSONObject;
        } catch (Exception e2) {
            String jSONObject2 = fYR().toString();
            AppMethodBeat.o(126609);
            return jSONObject2;
        }
    }

    @JavascriptInterface
    public final String fetchReddot(String str) {
        AppMethodBeat.i(126610);
        Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl fetchReddot %s", str);
        try {
            eiq fxo = ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxo();
            if (fxo != null) {
                q(fxo.msgId, fxo.NhO, fxo.type);
            }
            String jSONObject = fYQ().toString();
            AppMethodBeat.o(126610);
            return jSONObject;
        } catch (Exception e2) {
            String jSONObject2 = fYR().toString();
            AppMethodBeat.o(126610);
            return jSONObject2;
        }
    }

    @JavascriptInterface
    public final String shareImage(String str) {
        AppMethodBeat.i(236414);
        Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl shareImage %s", str);
        try {
            final String optString = new JSONObject(str).optString("imagePath");
            if (TextUtils.isEmpty(optString)) {
                String jSONObject = fYR().toString();
                AppMethodBeat.o(236414);
                return jSONObject;
            }
            final MMActivity eeF = fzV().eeF();
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) eeF, 1, false);
            eVar.HLX = new o.f() {
                /* class com.tencent.mm.plugin.topstory.ui.a.e.AnonymousClass4 */

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(m mVar) {
                    AppMethodBeat.i(236407);
                    mVar.aS(0, R.string.hxr, R.raw.bottomsheet_icon_transmit);
                    mVar.aS(1, R.string.hxs, R.raw.bottomsheet_icon_moment);
                    AppMethodBeat.o(236407);
                }
            };
            eVar.HLY = new o.g() {
                /* class com.tencent.mm.plugin.topstory.ui.a.e.AnonymousClass5 */

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(236408);
                    if (menuItem == null) {
                        AppMethodBeat.o(236408);
                        return;
                    }
                    Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl shareImage ItemId click:%s", Integer.valueOf(menuItem.getItemId()));
                    if (menuItem.getItemId() == 1) {
                        e.a(e.this, eeF, optString);
                        AppMethodBeat.o(236408);
                        return;
                    }
                    if (menuItem.getItemId() == 0) {
                        e.b(e.this, eeF, optString);
                    }
                    AppMethodBeat.o(236408);
                }
            };
            eVar.PGl = new e.b() {
                /* class com.tencent.mm.plugin.topstory.ui.a.e.AnonymousClass6 */

                @Override // com.tencent.mm.ui.widget.a.e.b
                public final void onDismiss() {
                }
            };
            eVar.dGm();
            String jSONObject2 = fYQ().toString();
            AppMethodBeat.o(236414);
            return jSONObject2;
        } catch (Throwable th) {
            String jSONObject3 = fYR().toString();
            AppMethodBeat.o(236414);
            return jSONObject3;
        }
    }

    @JavascriptInterface
    public final String queryWebCommCgi(String str) {
        AppMethodBeat.i(126611);
        Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl queryWebCommCgi %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            g.azz().a(new a(jSONObject.optString("requestId", ""), jSONObject.optString("commReq", "")), 0);
            String jSONObject2 = fYQ().toString();
            AppMethodBeat.o(126611);
            return jSONObject2;
        } catch (Exception e2) {
            String jSONObject3 = fYR().toString();
            AppMethodBeat.o(126611);
            return jSONObject3;
        }
    }

    @JavascriptInterface
    public final String updateNumReddot(String str) {
        AppMethodBeat.i(126612);
        Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl updateNumReddot %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().j(jSONObject.getLong("latestTimeStamp"), jSONObject.getInt("seq"), false);
            String jSONObject2 = fYQ().toString();
            AppMethodBeat.o(126612);
            return jSONObject2;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e2, "lxl updateNumReddot", new Object[0]);
            String jSONObject3 = fYR().toString();
            AppMethodBeat.o(126612);
            return jSONObject3;
        }
    }

    @JavascriptInterface
    public final String setComments(String str) {
        AppMethodBeat.i(126613);
        Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl setComments %s", str);
        try {
            g.azz().a(new j(new JSONObject(str)), 0);
            String jSONObject = fYQ().toString();
            AppMethodBeat.o(126613);
            return jSONObject;
        } catch (Exception e2) {
            String jSONObject2 = fYR().toString();
            AppMethodBeat.o(126613);
            return jSONObject2;
        }
    }

    @JavascriptInterface
    public final String postComments(String str) {
        AppMethodBeat.i(126614);
        Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl postComments %s", str);
        try {
            g.azz().a(new f(new JSONObject(str)), 0);
            String jSONObject = fYQ().toString();
            AppMethodBeat.o(126614);
            return jSONObject;
        } catch (Exception e2) {
            String jSONObject2 = fYR().toString();
            AppMethodBeat.o(126614);
            return jSONObject2;
        }
    }

    @JavascriptInterface
    public final String showNavBarShadow(String str) {
        AppMethodBeat.i(126615);
        Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl showNavBarShadow %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("color");
            String substring = string.substring(1, string.length());
            int i2 = (int) (jSONObject.getDouble("alpha") * 255.0d);
            fzV().jn(Integer.parseInt(substring, 16), i2);
            String jSONObject2 = fYQ().toString();
            AppMethodBeat.o(126615);
            return jSONObject2;
        } catch (Exception e2) {
            String jSONObject3 = fYR().toString();
            AppMethodBeat.o(126615);
            return jSONObject3;
        }
    }

    @JavascriptInterface
    public final String hideNavBarShadow(String str) {
        AppMethodBeat.i(126616);
        Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "lxl hideNavBarShadow %s", str);
        try {
            fzV().fyl();
            String jSONObject = fYQ().toString();
            AppMethodBeat.o(126616);
            return jSONObject;
        } catch (Exception e2) {
            String jSONObject2 = fYR().toString();
            AppMethodBeat.o(126616);
            return jSONObject2;
        }
    }

    public final void aTJ(String str) {
        AppMethodBeat.i(126617);
        try {
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("state", str);
            jSONObject.put("sessionId", this.eel.sessionId);
            jSONObject.put("subSessionId", this.eel.dVO);
            jSONObject.put("scene", this.eel.scene);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.topstory.ui.a.e.AnonymousClass9 */

                @TargetApi(7)
                public final void run() {
                    AppMethodBeat.i(236411);
                    e.this.Gqy.evaluateJavascript(String.format("javascript:window.activity_state_change && activity_state_change(%s)", jSONObject.toString()), null);
                    AppMethodBeat.o(236411);
                }
            });
            AppMethodBeat.o(126617);
        } catch (Exception e2) {
            AppMethodBeat.o(126617);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x01c9  */
    @android.webkit.JavascriptInterface
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String openSearchWebView(java.lang.String r15) {
        /*
        // Method dump skipped, instructions count: 502
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.topstory.ui.a.e.openSearchWebView(java.lang.String):java.lang.String");
    }

    @JavascriptInterface
    public final void doNegFeedback(String str) {
        AppMethodBeat.i(126621);
        Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "doNegFeedback %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("filterDocid") || !jSONObject.has("category")) {
                AppMethodBeat.o(126621);
                return;
            }
            String string = jSONObject.getString("filterDocid");
            ((com.tencent.mm.plugin.topstory.ui.b) g.ah(com.tencent.mm.plugin.topstory.ui.b.class)).getWebViewMgr().cD(jSONObject.getInt("category"), string);
            AppMethodBeat.o(126621);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e2, "doNegFeedback", new Object[0]);
            AppMethodBeat.o(126621);
        }
    }

    @JavascriptInterface
    public final String openWeAppPage(String str) {
        AppMethodBeat.i(126622);
        Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openWeAppPage %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = FaceManager.FACE_ACQUIRED_UP;
            ((r) g.af(r.class)).a(MMApplicationContext.getContext(), jSONObject.getString("userName"), jSONObject.getString("appid"), jSONObject.optInt("debugMode", 0), 0, jSONObject.getString("path"), appBrandStatObject);
            String jSONObject2 = fYQ().toString();
            AppMethodBeat.o(126622);
            return jSONObject2;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e2, "openWeAppPage", new Object[0]);
            String jSONObject3 = fYR().toString();
            AppMethodBeat.o(126622);
            return jSONObject3;
        }
    }

    @JavascriptInterface
    public final String openWowColikeSetting(String str) {
        AppMethodBeat.i(126623);
        Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openWowColikeSetting %s", str);
        try {
            c.hw(MMApplicationContext.getContext());
            String jSONObject = fYQ().toString();
            AppMethodBeat.o(126623);
            return jSONObject;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e2, "openWowColikeSetting", new Object[0]);
            String jSONObject2 = fYR().toString();
            AppMethodBeat.o(126623);
            return jSONObject2;
        }
    }

    @Override // com.tencent.mm.plugin.websearch.webview.b
    @JavascriptInterface
    public final String getSearchDisplayNameList(String str) {
        AppMethodBeat.i(170150);
        try {
            JSONArray jSONArray = new JSONArray(new JSONObject(str).optString("data"));
            JSONArray jSONArray2 = new JSONArray();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                String string = jSONObject.has("id") ? jSONObject.getString("id") : "";
                String string2 = jSONObject.has("userName") ? jSONObject.getString("userName") : "";
                String displayName = ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(string2);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", string);
                jSONObject2.put("userName", string2);
                jSONObject2.put("displayName", displayName);
                jSONArray2.put(jSONObject2);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ret", 0);
            jSONObject3.put("data", jSONArray2.toString());
            String jSONObject4 = jSONObject3.toString();
            AppMethodBeat.o(170150);
            return jSONObject4;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e2, "getSearchDisplayNameList", new Object[0]);
            String jSONObject5 = fYR().toString();
            AppMethodBeat.o(170150);
            return jSONObject5;
        }
    }

    @Override // com.tencent.mm.plugin.websearch.webview.b
    @JavascriptInterface
    public final String openFinderProfile(String str) {
        AppMethodBeat.i(236415);
        try {
            Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openFinderProfile %s", str);
            String optString = new JSONObject(str).optString("userName", "");
            Intent intent = new Intent();
            intent.putExtra("finder_username", optString);
            intent.putExtra("key_from_profile_share_scene", 15);
            intent.putExtra("key_enter_profile_type", 1);
            ((aj) g.ah(aj.class)).fillContextIdToIntent(7, 2, 32, intent);
            ((aj) g.ah(aj.class)).enterFinderProfileUI(MMApplicationContext.getContext(), intent);
            String jSONObject = fYQ().toString();
            AppMethodBeat.o(236415);
            return jSONObject;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e2, com.tencent.mm.plugin.appbrand.jsapi.finder.h.NAME, new Object[0]);
            String jSONObject2 = fYR().toString();
            AppMethodBeat.o(236415);
            return jSONObject2;
        }
    }

    @Override // com.tencent.mm.plugin.websearch.webview.b
    @JavascriptInterface
    public final String openFinderFeed(String str) {
        AppMethodBeat.i(236416);
        try {
            Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openFinderFeed %s", str);
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("feedId", jSONObject.optString("feedId", ""));
            jSONObject2.put(IssueStorage.COLUMN_EXT_INFO, new JSONObject(jSONObject.optString(IssueStorage.COLUMN_EXT_INFO, "")));
            jSONObject2.put("extraInfo", jSONObject.optString("extraInfo", ""));
            Intent intent = new Intent();
            intent.putExtra("tab_type", 7);
            ((aj) g.ah(aj.class)).fillContextIdToIntent(7, 2, 25, intent);
            ((aj) g.ah(aj.class)).enterFinderShareFeedUI(MMApplicationContext.getContext(), jSONObject2.toString(), intent);
            String jSONObject3 = fYQ().toString();
            AppMethodBeat.o(236416);
            return jSONObject3;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e2, com.tencent.mm.plugin.appbrand.jsapi.finder.h.NAME, new Object[0]);
            String jSONObject4 = fYR().toString();
            AppMethodBeat.o(236416);
            return jSONObject4;
        }
    }

    @JavascriptInterface
    public final String openFinderView(String str) {
        AppMethodBeat.i(263563);
        try {
            Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "openFinderView %s", str);
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IssueStorage.COLUMN_EXT_INFO, new JSONObject(jSONObject.optString(IssueStorage.COLUMN_EXT_INFO, "")));
            ((aj) g.ah(aj.class)).enterFinderUI(MMApplicationContext.getContext(), jSONObject2.toString());
            String jSONObject3 = fYQ().toString();
            AppMethodBeat.o(263563);
            return jSONObject3;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewJSApi", e2, "openFinderView", new Object[0]);
            String jSONObject4 = fYR().toString();
            AppMethodBeat.o(263563);
            return jSONObject4;
        }
    }

    private com.tencent.mm.plugin.topstory.ui.home.a fzV() {
        if (this.IHe != null) {
            return (com.tencent.mm.plugin.topstory.ui.home.a) this.IHe;
        }
        return null;
    }

    static /* synthetic */ void a(e eVar, Context context, String str) {
        AppMethodBeat.i(236417);
        final WeakReference weakReference = new WeakReference(context);
        q.bcU().a(str, new r.a() {
            /* class com.tencent.mm.plugin.topstory.ui.a.e.AnonymousClass7 */

            @Override // com.tencent.mm.av.r.a
            public final void a(String str, Bitmap bitmap, String str2) {
                AppMethodBeat.i(236409);
                Context context = (Context) weakReference.get();
                if (context == null) {
                    AppMethodBeat.o(236409);
                    return;
                }
                if (!TextUtils.isEmpty(str2) && s.YS(str2)) {
                    Intent intent = new Intent();
                    intent.putExtra("sns_kemdia_path", str2);
                    intent.putExtra("KFilterId", -1);
                    intent.putExtra("Ksnsupload_source", 1);
                    intent.putExtra("KBlockAdd", true);
                    com.tencent.mm.br.c.b(context, "sns", ".ui.SnsUploadUI", intent);
                }
                AppMethodBeat.o(236409);
            }
        });
        AppMethodBeat.o(236417);
    }

    static /* synthetic */ void b(e eVar, Context context, String str) {
        AppMethodBeat.i(236418);
        if (context == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(236418);
            return;
        }
        final WeakReference weakReference = new WeakReference(context);
        q.bcU().a(str, new r.a() {
            /* class com.tencent.mm.plugin.topstory.ui.a.e.AnonymousClass8 */

            @Override // com.tencent.mm.av.r.a
            public final void a(String str, Bitmap bitmap, String str2) {
                EmojiInfo emojiInfo;
                AppMethodBeat.i(236410);
                Context context = (Context) weakReference.get();
                if (context == null) {
                    AppMethodBeat.o(236410);
                    return;
                }
                if (!TextUtils.isEmpty(str2) && s.YS(str2)) {
                    if (ImgUtil.isGif(str2)) {
                        EmojiInfo aml = ((d) g.ah(d.class)).getEmojiMgr().aml(com.tencent.mm.b.g.getMD5(str2));
                        if (aml == null || !aml.hYi()) {
                            com.tencent.mm.pluginsdk.a.d emojiMgr = ((d) g.ah(d.class)).getEmojiMgr();
                            MMApplicationContext.getContext();
                            emojiInfo = ((d) g.ah(d.class)).getEmojiMgr().aml(emojiMgr.amn(str2));
                        } else {
                            emojiInfo = aml;
                        }
                        long boW = emojiInfo == null ? 0 : s.boW(emojiInfo.hYx());
                        boolean z = false;
                        if (emojiInfo != null) {
                            str2 = emojiInfo.hYx();
                        }
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        if ((BitmapUtil.decodeFile(str2, options) != null && options.outHeight > com.tencent.mm.n.c.aqo()) || options.outWidth > com.tencent.mm.n.c.aqo()) {
                            z = true;
                        }
                        if (boW > ((long) com.tencent.mm.n.c.aqp()) || z) {
                            com.tencent.mm.ui.base.h.a(context, context.getString(R.string.bs3), "", context.getString(R.string.e2u), (DialogInterface.OnClickListener) null);
                            com.tencent.mm.ui.base.h.a(context, context.getString(R.string.bs3), "", context.getString(R.string.e2u), "", false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.topstory.ui.a.e.AnonymousClass8.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                }
                            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.topstory.ui.a.e.AnonymousClass8.AnonymousClass2 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                }
                            });
                            AppMethodBeat.o(236410);
                            return;
                        }
                        Intent intent = new Intent();
                        intent.putExtra("Retr_File_Name", emojiInfo != null ? emojiInfo.getMd5() : "");
                        intent.putExtra("Retr_Msg_Type", 5);
                        intent.putExtra("Retr_MsgImgScene", 1);
                        com.tencent.mm.br.c.f(context, ".ui.transmit.MsgRetransmitUI", intent);
                        AppMethodBeat.o(236410);
                        return;
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtra("Retr_File_Name", str2);
                    intent2.putExtra("Retr_Compress_Type", 0);
                    intent2.putExtra("Retr_Msg_Type", 0);
                    intent2.addFlags(268435456);
                    com.tencent.mm.br.c.f(context, ".ui.transmit.MsgRetransmitUI", intent2);
                }
                AppMethodBeat.o(236410);
            }
        });
        AppMethodBeat.o(236418);
    }
}
