package com.tencent.mm.plugin.webview.fts;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.al;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.plugin.websearch.b.a.c;
import com.tencent.mm.plugin.webview.fts.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.clt;
import com.tencent.mm.protocal.protobuf.clu;
import com.tencent.mm.protocal.protobuf.crg;
import com.tencent.mm.protocal.protobuf.crh;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.ext;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c implements i {
    h.a INN = new h.a() {
        /* class com.tencent.mm.plugin.webview.fts.c.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.webview.fts.h.a
        public final void a(h.b bVar) {
            AppMethodBeat.i(210819);
            Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "handleCallback %s", bVar);
            if (bVar == null) {
                AppMethodBeat.o(210819);
                return;
            }
            int intValue = ((Integer) bVar.IOM).intValue();
            h hVar = (h) bVar.ION;
            if (hVar == null || hVar.IOz == null) {
                Log.e("MicroMsg.WebSearch.FTSWebViewLogic", "onSceneEnd netResult invalid");
                AppMethodBeat.o(210819);
            } else if (hVar.errType == 0 && hVar.errCode == 0) {
                ac acVar = hVar.IOz;
                ah.a(acVar.scene, acVar.sessionId, "", "", acVar.dPI, true, "", acVar.getType());
                b bVar2 = new b();
                bVar2.scene = acVar.scene;
                bVar2.IOq = (long) acVar.IEi.Mrk;
                bVar2.dNA = acVar.IEi.MaZ;
                bVar2.IOr = System.currentTimeMillis() / 1000;
                bVar2.rjq = acVar.IEi.Mbb;
                bVar2.type = acVar.businessType;
                String G = c.G(bVar2.scene, bVar2.type, true);
                Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "NetSceneWebSearchGuide cgi data %s ", bVar2.dNA);
                if (!Util.isNullOrNil(bVar2.dNA)) {
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(intValue).e(0, bVar2.dNA, 0, acVar.dPI);
                    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "onTeachSearchDataReady, %s", bVar2.dNA);
                }
                c.this.IOa.put(G, bVar2);
                if (bVar2.IOq == 0) {
                    int i2 = bVar2.scene;
                    int i3 = bVar2.type;
                    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "delete biz cache %d %d", Integer.valueOf(i2), Integer.valueOf(i3));
                    String aTb = com.tencent.mm.plugin.record.b.aTb();
                    o oVar = new o(aTb, c.G(i2, i3, true));
                    if (oVar.exists()) {
                        oVar.delete();
                    }
                    o oVar2 = new o(aTb, c.G(i2, i3, false));
                    if (oVar2.exists()) {
                        oVar2.delete();
                    }
                } else {
                    clt clt = new clt();
                    clt.scene = bVar2.scene;
                    clt.MaZ = bVar2.dNA;
                    clt.Mre = bVar2.IOq;
                    clt.Mrf = bVar2.IOr;
                    clt.KZj = bVar2.rjq;
                    clt.oUv = bVar2.type;
                    byte[] bArr = null;
                    try {
                        bArr = clt.toByteArray();
                    } catch (IOException e2) {
                    }
                    if (bArr != null) {
                        o oVar3 = new o(com.tencent.mm.plugin.record.b.aTb(), c.G(bVar2.scene, bVar2.type, true));
                        if (!oVar3.heq().exists()) {
                            oVar3.heq().mkdirs();
                        }
                        if (oVar3.exists()) {
                            oVar3.delete();
                        }
                        s.f(aa.z(oVar3.her()), bArr, bArr.length);
                        Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "save bizCacheFile %s %d", aa.z(oVar3.her()), Integer.valueOf(bArr.length));
                    } else {
                        Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "save bizCacheFile fail");
                    }
                }
                if (bVar2.scene == 20 && bVar2.type == 0) {
                    ar.a(bVar2.scene, 1, bVar2.rjq, bVar2.type, 2, bVar2.gax(), 1);
                    AppMethodBeat.o(210819);
                    return;
                }
                ar.a(bVar2.scene, 1, bVar2.rjq, bVar2.type, 1, "", 0);
                AppMethodBeat.o(210819);
            } else {
                Log.e("MicroMsg.WebSearch.FTSWebViewLogic", "onSceneEnd errType %d,errCode %d", Integer.valueOf(hVar.errType), Integer.valueOf(hVar.errCode));
                ac acVar2 = hVar.IOz;
                if (acVar2 != null) {
                    ah.a(acVar2.scene, acVar2.sessionId, "", "", acVar2.dPI, false, "", acVar2.getType());
                }
                AppMethodBeat.o(210819);
            }
        }
    };
    public Set<Integer> INY;
    public l INZ = new l() {
        /* class com.tencent.mm.plugin.webview.fts.c.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.fts.a.l
        public final void b(k kVar) {
            AppMethodBeat.i(77886);
            final f fVar = (f) kVar.wTn;
            Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "historySearchResultListener ret %d, webViewId %s", Integer.valueOf(kVar.resultCode), Integer.valueOf(fVar.IOx));
            if (kVar.resultCode == 0) {
                final JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ret", 0);
                    JSONArray jSONArray = new JSONArray();
                    JSONArray jSONArray2 = new JSONArray();
                    for (m mVar : kVar.wXb) {
                        if (mVar.content != null) {
                            JSONObject jSONObject2 = new JSONObject(mVar.content);
                            jSONObject2.put("timeStamp", mVar.timestamp);
                            jSONArray2.put(jSONObject2);
                        }
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("items", jSONArray2);
                    jSONArray.put(jSONObject3);
                    jSONObject.put("data", jSONArray);
                } catch (Exception e2) {
                }
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.fts.c.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(77885);
                        if (fVar.IOx != 0) {
                            Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "historySearchResultListener callback， id %d", Integer.valueOf(fVar.IOx));
                            com.tencent.mm.plugin.webview.ui.tools.jsapi.f ahd = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(fVar.IOx);
                            String jSONObject = jSONObject.toString();
                            Bundle bundle = new Bundle();
                            bundle.putString("data", jSONObject);
                            try {
                                if (ahd.ISw != null) {
                                    ahd.ISw.f(TbsListener.ErrorCode.NEEDDOWNLOAD_4, bundle);
                                    AppMethodBeat.o(77885);
                                    return;
                                }
                                Log.i("MicroMsg.MsgHandler", "callbacker is null");
                                AppMethodBeat.o(77885);
                                return;
                            } catch (RemoteException e2) {
                                Log.w("MicroMsg.MsgHandler", "onGetSearchHistory exception" + e2.getMessage());
                            }
                        }
                        AppMethodBeat.o(77885);
                    }
                });
            }
            AppMethodBeat.o(77886);
        }
    };
    HashMap<String, b> IOa;
    public ac IOb;
    private Map<Integer, g> IOc = new HashMap();
    public e IOd = new e();
    public List<com.tencent.mm.ay.f> IOe;
    private com.tencent.mm.plugin.websearch.b.a.c IOf;
    com.tencent.mm.plugin.websearch.b.a.d IOg;
    private d IOh;
    public IListener lEl = new IListener<mx>() {
        /* class com.tencent.mm.plugin.webview.fts.c.AnonymousClass4 */

        {
            AppMethodBeat.i(210820);
            this.__eventId = mx.class.getName().hashCode();
            AppMethodBeat.o(210820);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mx mxVar) {
            AppMethodBeat.i(210822);
            boolean b2 = b(mxVar);
            AppMethodBeat.o(210822);
            return b2;
        }

        private boolean b(mx mxVar) {
            AppMethodBeat.i(210821);
            com.tencent.mm.ay.f fVar = mxVar.dSE.dSy;
            if (fVar != null && com.tencent.mm.ay.a.e(fVar)) {
                switch (mxVar.dSE.action) {
                    case 0:
                    case 1:
                        for (Integer num : c.this.INY) {
                            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(num.intValue()).gq(fVar.jeV, 1);
                        }
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 7:
                        for (Integer num2 : c.this.INY) {
                            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(num2.intValue()).gq(fVar.jeV, 0);
                        }
                        break;
                }
            }
            AppMethodBeat.o(210821);
            return false;
        }
    };
    private long mZq;

    public c() {
        AppMethodBeat.i(77898);
        Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "create FTSWebViewLogic");
        this.IOa = new HashMap<>();
        this.INY = Collections.synchronizedSet(new HashSet());
        EventCenter.instance.addListener(this.lEl);
        com.tencent.mm.kernel.g.azz().a(2975, this);
        AppMethodBeat.o(77898);
    }

    public class f extends j {
        public int IOx;

        private f() {
        }

        public /* synthetic */ f(c cVar, byte b2) {
            this();
        }
    }

    public static Bundle u(int i2, Bundle bundle) {
        AppMethodBeat.i(77899);
        Bundle bundle2 = new Bundle();
        switch (i2) {
            case 2:
                try {
                    String string = bundle.getString("key");
                    bundle2.putString("result", ak.aXe(string).toString());
                    if ("educationTab".equals(string)) {
                        JSONObject aXe = ak.aXe("discoverSearchGuide");
                        if (aXe.optJSONArray("items").length() > 0) {
                            bundle2.putString("result_1", aXe.toString());
                            break;
                        }
                    }
                } catch (Exception e2) {
                    break;
                }
                break;
            case 4:
                Map<String, String> h2 = ai.h(bundle.getInt("scene"), bundle.getBoolean("isHomePage"), bundle.getInt("type"));
                bundle2.putString("type", h2.get("type"));
                bundle2.putString("isMostSearchBiz", h2.get("isMostSearchBiz"));
                bundle2.putString("isLocalSug", h2.get("isLocalSug"));
                bundle2.putString("isSug", h2.get("isSug"));
                bundle2.putString("scene", h2.get("scene"));
                break;
            case 6:
                try {
                    bundle2.putString("result", ak.aXf(bundle.getString("key")));
                    break;
                } catch (Exception e3) {
                    break;
                }
            case 7:
                bundle2.putString("data", com.tencent.mm.plugin.webview.modeltools.g.gds().gaw());
                break;
        }
        AppMethodBeat.o(77899);
        return bundle2;
    }

    public final boolean bo(Map<String, Object> map) {
        AppMethodBeat.i(77900);
        switch (ai.b(map, NativeProtocol.WEB_DIALOG_ACTION, 0)) {
            case 1:
                if (al.IEV == null) {
                    al.fYg();
                }
                al.IEV.oTA.clear();
                SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("fts_history_search_sp", 0);
                try {
                    String bKh = al.bKh();
                    String encodeToString = Base64.encodeToString(al.IEV.toByteArray(), 0);
                    sharedPreferences.edit().putString(bKh, encodeToString).apply();
                    Log.i("MicroMsg.WebSearch.WebSearchHistoryLogic", "addHistory pbListString %s", encodeToString);
                    break;
                } catch (IOException e2) {
                    break;
                }
            case 2:
                int b2 = ai.b(map, "type", 0);
                int b3 = ai.b(map, "scene", 0);
                if (System.currentTimeMillis() - this.mZq > 1000) {
                    this.mZq = System.currentTimeMillis();
                    if (ai.afs(0)) {
                        ar.N(b2, b3, ak.aXf("searchID"));
                        Intent fXX = ai.fXX();
                        fXX.putExtra("ftsneedkeyboard", true);
                        fXX.putExtra("ftsbizscene", b3);
                        fXX.putExtra("ftsType", b2);
                        fXX.putExtra("rawUrl", ai.bd(ai.h(b3, true, b2)));
                        fXX.putExtra("key_load_js_without_delay", true);
                        fXX.putExtra("key_change_search_icon", true);
                        com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", fXX);
                        break;
                    } else {
                        Log.e("MicroMsg.WebSearch.FTSWebViewLogic", "fts h5 template not avail");
                        break;
                    }
                }
                break;
            case 3:
                com.tencent.mm.plugin.webview.ui.tools.jsapi.f ahd = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(ai.b(map, "webview_instance_id", -1));
                int b4 = ai.b(map, "scene", 0);
                String N = ai.N(map, SearchIntents.EXTRA_QUERY);
                if (b4 == 20 && !Util.isNullOrNil(N)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("fts_key_new_query", N);
                    try {
                        if (ahd.ISw != null) {
                            ahd.ISw.f(r.CTRL_INDEX, bundle);
                            break;
                        }
                    } catch (Exception e3) {
                        Log.w("MicroMsg.MsgHandler", "doSearchHotWordOperation exception" + e3.getMessage());
                        break;
                    }
                } else {
                    Log.w("MicroMsg.MsgHandler", "doSearchHotWordOperation warning, scene=%d, query=%s", Integer.valueOf(b4), N);
                    break;
                }
                break;
        }
        AppMethodBeat.o(77900);
        return false;
    }

    public final String gaw() {
        AppMethodBeat.i(77901);
        String G = G(20, 0, true);
        if (this.IOa.get(G) == null) {
            b bVar = new b();
            bVar.kf(20, 0);
            this.IOa.put(G, bVar);
        }
        b bVar2 = this.IOa.get(G);
        String str = bVar2.isAvailable() ? bVar2.dNA : "";
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(77901);
            return "";
        }
        AppMethodBeat.o(77901);
        return str;
    }

    public final b ke(int i2, int i3) {
        AppMethodBeat.i(210826);
        String G = G(i2, i3, true);
        if (this.IOa.get(G) == null) {
            b bVar = new b();
            bVar.kf(i2, i3);
            this.IOa.put(G, bVar);
        }
        b bVar2 = this.IOa.get(G);
        AppMethodBeat.o(210826);
        return bVar2;
    }

    public final boolean bp(Map<String, Object> map) {
        com.tencent.mm.api.c fJ;
        AppMethodBeat.i(77902);
        Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "getTeachSearchData: %s", map);
        final int b2 = ai.b(map, "scene", 0);
        final int b3 = ai.b(map, "type", 0);
        int b4 = ai.b(map, "requestType", 0);
        final int nullAsInt = Util.nullAsInt(map.get("webview_instance_id"), -1);
        final String str = (String) map.get("requestId");
        final String str2 = (String) map.get("guideInfo");
        final String str3 = (String) map.get("sessionId");
        boolean O = ai.O(map, "ignoreCache");
        if (b4 == 0) {
            b ke = ke(b2, b3);
            if (!ke.isAvailable() || O) {
                com.tencent.mm.plugin.webview.modeltools.g.gdt().IPn.a(2, str, Integer.valueOf(nullAsInt), new Runnable() {
                    /* class com.tencent.mm.plugin.webview.fts.c.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(210818);
                        Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "getTeachSearchData realTime, webviewID = %d", Integer.valueOf(nullAsInt));
                        com.tencent.mm.kernel.g.azz().a(1048, c.this);
                        String currentLanguage = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
                        long optLong = ak.aXe("discoverSearchEntry").optLong("guideParam");
                        c.this.IOb = new ac(b2, b3, ai.aft(0), nullAsInt, currentLanguage, optLong, str, str3, str2);
                        com.tencent.mm.kernel.g.azz().a(c.this.IOb, 0);
                        AppMethodBeat.o(210818);
                    }
                }, this.INN);
            } else {
                Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "hit the cache: webviewID = %d %d %d %d %d, data %s", Integer.valueOf(nullAsInt), Integer.valueOf(ke.scene), Long.valueOf(ke.IOq), Long.valueOf(ke.IOr), Integer.valueOf(ke.type), ke.dNA);
                com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(nullAsInt).e(b4, ke.dNA, 1, str);
                if (ke.scene == 20 && ke.type == 0) {
                    ar.a(ke.scene, 0, ke.rjq, ke.type, 2, ke.gax(), 1);
                } else {
                    ar.a(ke.scene, 0, ke.rjq, ke.type, 1, "", 0);
                }
            }
        } else {
            crh fYi = am.fYi();
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject2 = new JSONObject();
                JSONArray jSONArray2 = new JSONArray();
                for (int size = fYi.oTA.size() - 1; size >= 0; size--) {
                    JSONObject jSONObject3 = new JSONObject();
                    crg crg = fYi.oTA.get(size);
                    if (ab.IS(crg.Username) && (fJ = com.tencent.mm.al.g.fJ(crg.Username)) != null) {
                        jSONObject3.put("avatarUrl", fJ.field_brandIconURL);
                        jSONObject3.put("userName", fJ.field_username);
                        jSONObject3.put("nickName", ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(fJ.field_username));
                        jSONArray2.put(jSONObject3);
                    }
                }
                jSONObject2.put("items", jSONArray2);
                jSONObject2.put("type", 5);
                jSONObject2.put("title", "");
                jSONArray.put(jSONObject2);
                jSONObject.put("data", jSONArray);
                String jSONObject4 = jSONObject.toString();
                Log.d("MicroMsg.WebSearch.FTSWebViewLogic", "getTeachSearchData returnString=%s", jSONObject4);
                com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(nullAsInt).e(1, jSONObject4, 1, str);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewLogic", e2, "gen mostSearchBizContactList error", new Object[0]);
            }
        }
        AppMethodBeat.o(77902);
        return false;
    }

    static class h {
        ac IOz;
        int errCode;
        int errType;

        public h(int i2, int i3, ac acVar) {
            this.errType = i2;
            this.errCode = i3;
            this.IOz = acVar;
        }
    }

    public final boolean bq(Map<String, Object> map) {
        boolean z = true;
        AppMethodBeat.i(77903);
        int b2 = ai.b(map, "scene", 201);
        int nullAsInt = Util.nullAsInt(map.get("webview_instance_id"), -1);
        g afM = afM(b2);
        if (afM != null) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(nullAsInt).r(afM.dNA, 1, afM.isExpired() ? 1 : 0, afM.IOy);
            z = afM.isExpired();
        }
        if (z) {
            com.tencent.mm.kernel.g.azz().a(1866, this);
            e eVar = new e(map, b2, 0);
            if (map != null) {
                eVar.dVL = ai.b(map, "webview_instance_id", -1);
            }
            com.tencent.mm.kernel.g.azz().a(eVar, 0);
        }
        AppMethodBeat.o(77903);
        return false;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00e6 A[SYNTHETIC, Splitter:B:15:0x00e6] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0280  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x028c  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x04bc  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x00c5 A[SYNTHETIC, Splitter:B:9:0x00c5] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.util.Map<java.lang.String, java.lang.Object> r24, com.tencent.mm.plugin.webview.ui.tools.jsapi.f r25) {
        /*
        // Method dump skipped, instructions count: 1464
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.fts.c.a(java.util.Map, com.tencent.mm.plugin.webview.ui.tools.jsapi.f):boolean");
    }

    private static String aeL(String str) {
        AppMethodBeat.i(210827);
        try {
            str = q.encode(str, ProtocolPackage.ServerEncoding);
        } catch (Throwable th) {
        }
        AppMethodBeat.o(210827);
        return str;
    }

    public final boolean a(Map<String, Object> map, com.tencent.mm.plugin.webview.ui.tools.jsapi.f fVar, String str) {
        String str2;
        AppMethodBeat.i(77905);
        this.IOd.GjI = true;
        boolean O = ai.O(map, "isTeachPage");
        boolean O2 = ai.O(map, "isMoreButton");
        boolean z = ai.b(map, "isFeedBack", 0) == 1;
        boolean z2 = ai.b(map, "isWeAppMore", 0) == 1;
        String N = ai.N(map, "srcUserName");
        String N2 = ai.N(map, "sessionId");
        String str3 = (String) map.get("navBarColor");
        int b2 = ai.b(map, "subType", 0);
        String N3 = ai.N(map, "searchPlaceHolder");
        int i2 = 0;
        if (!Util.isNullOrNil(str3)) {
            try {
                i2 = Color.parseColor(str3);
            } catch (IllegalArgumentException e2) {
                Log.e("MicroMsg.WebSearch.FTSWebViewLogic", "startSearchItemDetailPage: " + e2.getMessage());
                AppMethodBeat.o(77905);
                return true;
            }
        }
        String str4 = (String) map.get("statusBarStyle");
        if (!z) {
            int b3 = ai.b(map, "type", 0);
            int b4 = ai.b(map, "opType", 0);
            if (b4 <= 0) {
                if (!O2) {
                    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "doStartSearchItemDetailPage: type=%d link=%s", Integer.valueOf(b3), (String) map.get("url"));
                    switch (b3) {
                        case 1:
                            a(bs(map), false);
                            break;
                        case 8:
                            ai.N(map, "snsid");
                            String N4 = ai.N(map, "objectXmlDesc");
                            String N5 = ai.N(map, "userName");
                            boolean O3 = ai.O(map, "fromMusicItem");
                            com.tencent.mm.plugin.webview.modeltools.g.gds();
                            B(N4, N5, O3);
                            break;
                        case 32:
                            a(bt(map));
                            break;
                        default:
                            String N6 = ai.N(map, "jumpUrl");
                            String N7 = ai.N(map, "publishId");
                            int b5 = ai.b(map, "payScene", 0);
                            int b6 = ai.b(map, "scene", 0);
                            Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "jump url = %s, publishId = %s, payScene = %d", N6, N7, Integer.valueOf(b5));
                            String N8 = ai.N(map, "cookie");
                            Bundle bundle = null;
                            if (fVar != null) {
                                bundle = fVar.ghB();
                            }
                            if (!Util.isNullOrNil(N6)) {
                                com.tencent.mm.plugin.webview.modeltools.g.gds();
                                a(N6, bundle, i2, str4, N7, b5, N, b6, b2, N8);
                                break;
                            }
                            break;
                    }
                } else {
                    String N9 = ai.N(map, SearchIntents.EXTRA_QUERY);
                    int b7 = ai.b(map, "scene", 0);
                    String N10 = ai.N(map, "searchId");
                    Intent intent = new Intent();
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("key_load_js_without_delay", true);
                    intent.putExtra("ftsQuery", N9);
                    intent.putExtra("ftsType", b3);
                    intent.putExtra("sessionId", N2);
                    if (z2) {
                        Map<String, String> a2 = com.tencent.mm.plugin.websearch.c.a.a(b7, false, b3, str);
                        try {
                            a2.put(SearchIntents.EXTRA_QUERY, q.encode(N9, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                        } catch (Exception e3) {
                            a2.put(SearchIntents.EXTRA_QUERY, N9);
                        }
                        a2.put("searchId", N10);
                        a2.put("subType", String.valueOf(b2));
                        a2.put("isWeAppMore", String.valueOf(ai.b(map, "isWeAppMore", 0)));
                        a2.put("sessionId", N2);
                        String aXE = com.tencent.mm.modelappbrand.b.aXE();
                        a2.put("sessionId", aXE);
                        String afq = ai.afq(Util.safeParseInt(a2.get("scene")));
                        a2.put("subSessionId", afq);
                        intent.putExtra("subSessionId", afq);
                        intent.putExtra("key_session_id", aXE);
                        intent.putExtra("rawUrl", com.tencent.mm.plugin.websearch.c.a.bd(a2));
                        intent.putExtra("ftsbizscene", b7);
                        intent.putExtra("key_search_place_holder", N3);
                        com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "appbrand", ".ui.AppBrandSearchUI", intent);
                    } else {
                        Map<String, String> a3 = ai.a(b7, false, b3, str);
                        try {
                            a3.put(SearchIntents.EXTRA_QUERY, q.encode(N9, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                        } catch (Exception e4) {
                            a3.put(SearchIntents.EXTRA_QUERY, N9);
                        }
                        a3.put("searchId", N10);
                        a3.put("sessionId", N2);
                        String afq2 = ai.afq(Util.safeParseInt(a3.get("scene")));
                        a3.put("subSessionId", afq2);
                        intent.putExtra("subSessionId", afq2);
                        intent.putExtra("rawUrl", i(b7, a3));
                        intent.putExtra("key_session_id", N2);
                        intent.putExtra("searchId", N10);
                        if (b7 == 20 || b7 == 22 || b7 == 24 || b7 == 33) {
                            str2 = ".ui.tools.fts.FTSSOSMoreWebViewUI";
                        } else {
                            str2 = ".ui.tools.fts.FTSSearchTabWebViewUI";
                        }
                        com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", str2, intent);
                    }
                }
            } else {
                switch (b4) {
                    case 2:
                        a(bs(map), O);
                        break;
                    case 3:
                        C1954c bs = bs(map);
                        if (ab.IS(bs.username)) {
                            am.aXh(bs.username);
                            Intent intent2 = new Intent();
                            intent2.putExtra("Chat_User", bs.username);
                            intent2.putExtra("finish_direct", true);
                            intent2.putExtra("key_temp_session_show_type", 0);
                            intent2.putExtra("preChatTYPE", 9);
                            com.tencent.mm.br.c.f(MMApplicationContext.getContext(), ".ui.chatting.ChattingUI", intent2);
                            break;
                        } else {
                            a(bs, O);
                            break;
                        }
                    case 4:
                        String N11 = ai.N(map, "jumpUrl");
                        Bundle bundle2 = null;
                        if (fVar != null) {
                            bundle2 = fVar.ghB();
                        }
                        com.tencent.mm.plugin.webview.modeltools.g.gds();
                        p(N11, bundle2);
                        break;
                }
            }
        } else {
            String N12 = ai.N(map, "jumpUrl");
            Bundle bundle3 = null;
            if (fVar != null) {
                bundle3 = fVar.ghB();
            }
            com.tencent.mm.plugin.webview.modeltools.g.gds();
            p(N12, bundle3);
        }
        AppMethodBeat.o(77905);
        return false;
    }

    public final boolean br(Map<String, Object> map) {
        AppMethodBeat.i(77906);
        Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "reportSearchRealTimeReport: %s", map.toString());
        doc doc = new doc();
        doc.MRe = ai.N(map, "logString");
        com.tencent.mm.kernel.g.azz().a(1134, this);
        com.tencent.mm.kernel.g.azz().a(new ad(doc), 0);
        AppMethodBeat.o(77906);
        return false;
    }

    private static void p(String str, Bundle bundle) {
        AppMethodBeat.i(77907);
        a(str, bundle, 0, "", "", 0, "", 0, 0, "");
        AppMethodBeat.o(77907);
    }

    private static void a(String str, Bundle bundle, int i2, String str2, String str3, int i3, String str4, int i4, int i5, String str5) {
        AppMethodBeat.i(210828);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("convertActivityFromTranslucent", false);
        intent.putExtra("customize_status_bar_color", i2);
        intent.putExtra("status_bar_style", str2);
        intent.putExtra("from_scence", i4);
        intent.putExtra("subtype", i5);
        intent.putExtra("key_h5pay_cookie", str5);
        if (!Util.isNullOrNil(str3)) {
            intent.putExtra("prePublishId", str3);
            intent.putExtra("KPublisherId", str3);
        } else if (bundle != null && !Util.isNullOrNil(str)) {
            String str6 = bundle.getString("publishIdPrefix", "gs") + "_" + com.tencent.mm.b.g.getMessageDigest(str.getBytes());
            intent.putExtra("prePublishId", str6);
            intent.putExtra("KPublisherId", str6);
        }
        if (i3 > 0) {
            intent.putExtra("pay_channel", i3);
        }
        intent.putExtra("geta8key_scene", 65);
        intent.putExtra("preChatTYPE", 10);
        if (!Util.isNullOrNil(str4)) {
            intent.putExtra("srcUsername", str4);
        }
        com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.fts.SosWebViewUI", intent);
        AppMethodBeat.o(210828);
    }

    private static void B(String str, String str2, boolean z) {
        AppMethodBeat.i(77909);
        TimeLineObject PM = ((n) com.tencent.mm.kernel.g.af(n.class)).PM(str);
        Intent intent = new Intent();
        intent.putExtra("INTENT_TALKER", str2);
        intent.putExtra("INTENT_SNSID", new BigInteger(PM.Id).longValue());
        intent.putExtra("SNS_FROM_MUSIC_ITEM", z);
        try {
            intent.putExtra("INTENT_SNS_TIMELINEOBJECT", PM.toByteArray());
        } catch (IOException e2) {
        }
        com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "sns", ".ui.SnsCommentDetailUI", intent);
        AppMethodBeat.o(77909);
    }

    private static void a(d dVar) {
        AppMethodBeat.i(77910);
        Intent intent = new Intent();
        intent.putExtra("Contact_User", dVar.username);
        intent.putExtra("Contact_Nick", dVar.nickname);
        intent.putExtra("Contact_Alias", dVar.fMb);
        intent.putExtra("Contact_Sex", dVar.fuA);
        intent.putExtra("Contact_Scene", dVar.scene);
        intent.putExtra("Contact_KHideExpose", true);
        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.bq(dVar.country, dVar.fuJ, dVar.fuK));
        intent.putExtra("Contact_Signature", dVar.signature);
        intent.putExtra("Contact_KSnsIFlag", dVar.IOw);
        intent.putExtra("Contact_full_Mobile_MD5", dVar.query);
        com.tencent.mm.br.c.b(MMApplicationContext.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        AppMethodBeat.o(77910);
    }

    private static void a(C1954c cVar, boolean z) {
        int i2;
        AppMethodBeat.i(77911);
        if (cVar.IOv != 0) {
            i2 = cVar.IOv;
        } else if (cVar.dVS == 2) {
            i2 = 89;
        } else if (z) {
            i2 = 85;
        } else if (cVar.scene != 3 && cVar.scene != 16) {
            i2 = 39;
        } else if (cVar.IOt) {
            i2 = 88;
        } else {
            i2 = 87;
        }
        am.aXh(cVar.username);
        Intent intent = new Intent();
        intent.putExtra("Contact_User", cVar.username);
        intent.putExtra("Contact_Nick", cVar.nickname);
        intent.putExtra("Contact_BrandIconURL", cVar.BdC);
        intent.putExtra("Contact_Signature", cVar.signature);
        intent.putExtra("Contact_VUser_Info_Flag", cVar.IOs);
        intent.putExtra("Contact_Scene", i2);
        if (cVar.BeX != null) {
            try {
                intent.putExtra("Contact_customInfo", cVar.BeX.toByteArray());
            } catch (IOException e2) {
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("Contact_Ext_Args_Search_Id", cVar.hes);
        bundle.putString("Contact_Ext_Args_Query_String", cVar.query);
        bundle.putInt("Contact_Scene", i2);
        bundle.putInt("Contact_Ext_Args_Index", cVar.position);
        bundle.putString("Contact_Ext_Extra_Params", cVar.IOu);
        intent.putExtra("preChatTYPE", 10);
        intent.putExtra("Contact_Ext_Args", bundle);
        com.tencent.mm.br.c.b(MMApplicationContext.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        AppMethodBeat.o(77911);
    }

    public static int d(Map<String, Object> map, Map<String, Object> map2) {
        AppMethodBeat.i(77912);
        try {
            JSONArray jSONArray = new JSONArray(ai.N(map, "data"));
            JSONArray jSONArray2 = new JSONArray();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                String string = jSONObject.has("id") ? jSONObject.getString("id") : "";
                String string2 = jSONObject.has("userName") ? jSONObject.getString("userName") : "";
                String displayName = ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(string2);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", string);
                jSONObject2.put("userName", string2);
                jSONObject2.put("displayName", displayName);
                jSONArray2.put(jSONObject2);
            }
            map2.put("ret", 0);
            map2.put("data", jSONArray2.toString());
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewLogic", e2, "", new Object[0]);
        }
        AppMethodBeat.o(77912);
        return 0;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(77913);
        if (qVar instanceof ac) {
            com.tencent.mm.kernel.g.azz().b(1048, this);
            com.tencent.mm.plugin.webview.modeltools.g.gdt().IPn.a(2, ((ac) qVar).dPI, new h(i2, i3, (ac) qVar), this.INN);
            AppMethodBeat.o(77913);
        } else if (qVar instanceof ad) {
            com.tencent.mm.kernel.g.azz().b(1134, this);
            AppMethodBeat.o(77913);
        } else if (qVar instanceof e) {
            com.tencent.mm.kernel.g.azz().b(1866, this);
            if (i2 == 0 && i3 == 0) {
                e eVar = (e) qVar;
                if (eVar.dVL != -1) {
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(eVar.dVL).r(((ext) eVar.rr.iLL.iLR).dNA, 0, 0, 0);
                }
                if (eVar.IOB != null) {
                    this.IOc.put(Integer.valueOf(eVar.IOB.scene), eVar.IOB);
                }
                AppMethodBeat.o(77913);
                return;
            }
            AppMethodBeat.o(77913);
        } else if (qVar instanceof d) {
            com.tencent.mm.kernel.g.azz().b(2999, this);
            d dVar = (d) qVar;
            String nullAs = Util.nullAs(dVar.IOA.MaZ, "");
            if (dVar.dVL != -1) {
                com.tencent.mm.plugin.webview.ui.tools.jsapi.f ahd = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(dVar.dVL);
                Bundle bundle = new Bundle();
                bundle.putString("fts_key_json_data", nullAs);
                bundle.putString("fts_key_err_msg", str);
                bundle.putInt("fts_key_ret_code", i3);
                try {
                    if (ahd.ISw != null) {
                        ahd.ISw.f(152, bundle);
                    }
                    AppMethodBeat.o(77913);
                    return;
                } catch (Exception e2) {
                }
            }
            AppMethodBeat.o(77913);
        } else {
            if (qVar instanceof w) {
                w wVar = (w) qVar;
                String nullAs2 = Util.nullAs(wVar.fxY().NvZ, "");
                if (wVar.dVL != -1) {
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.f ahd2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(wVar.dVL);
                    String str2 = wVar.dPI;
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("fts_key_id", str2);
                    bundle2.putString("fts_key_json_data", nullAs2);
                    bundle2.putString("fts_key_err_msg", str);
                    bundle2.putInt("fts_key_ret_code", i3);
                    try {
                        if (ahd2.ISw != null) {
                            ahd2.ISw.f(153, bundle2);
                        }
                        AppMethodBeat.o(77913);
                        return;
                    } catch (Exception e3) {
                    }
                }
            }
            AppMethodBeat.o(77913);
        }
    }

    private C1954c bs(Map<String, Object> map) {
        AppMethodBeat.i(77914);
        C1954c cVar = new C1954c(this, (byte) 0);
        cVar.username = ai.N(map, "userName");
        cVar.nickname = ai.N(map, "nickName");
        cVar.BdC = ai.N(map, "headHDImgUrl");
        cVar.IOs = ai.b(map, "verifyFlag", 0);
        cVar.signature = ai.N(map, "signature");
        cVar.scene = ai.b(map, "scene", 0);
        cVar.dVS = ai.b(map, "sceneActionType", 1);
        cVar.BeX = new aeq();
        cVar.BeX.kem = ai.b(map, "brandFlag", 0);
        cVar.BeX.kep = ai.N(map, "iconUrl");
        cVar.BeX.keo = ai.N(map, "brandInfo");
        cVar.BeX.ken = ai.N(map, "externalInfo");
        cVar.hes = ai.N(map, "searchId");
        cVar.query = ai.N(map, SearchIntents.EXTRA_QUERY);
        cVar.position = ai.b(map, "position", 0);
        cVar.IOt = ai.O(map, "isCurrentDetailPage");
        cVar.IOu = ai.N(map, "extraParams");
        cVar.IOv = ai.b(map, "friendScene", 0);
        AppMethodBeat.o(77914);
        return cVar;
    }

    private d bt(Map<String, Object> map) {
        int i2 = 3;
        AppMethodBeat.i(77915);
        d dVar = new d(this, (byte) 0);
        dVar.username = ai.N(map, "userName");
        dVar.nickname = ai.N(map, "nickName");
        dVar.fMb = ai.N(map, "alias");
        dVar.signature = ai.N(map, "signature");
        dVar.fuA = ai.b(map, "sex", 0);
        dVar.country = ai.N(map, UserDataStore.COUNTRY);
        dVar.fuK = ai.N(map, "city");
        dVar.fuJ = ai.N(map, "province");
        dVar.IOw = ai.b(map, "snsFlag", 0);
        String N = ai.N(map, SearchIntents.EXTRA_QUERY);
        if (!Util.isNullOrNil(N)) {
            if (Character.isDigit(N.charAt(0))) {
                i2 = 15;
            }
            dVar.scene = i2;
            if (dVar.scene == 15) {
                if ("mobile".equals(ai.N(map, "matchType"))) {
                    dVar.query = N;
                } else {
                    dVar.scene = 1;
                }
            }
        } else {
            dVar.scene = 3;
        }
        AppMethodBeat.o(77915);
        return dVar;
    }

    /* access modifiers changed from: package-private */
    public class d {
        public int IOw;
        public String country;
        public String fMb;
        public int fuA;
        public String fuJ;
        public String fuK;
        public String nickname;
        public String query;
        public int scene;
        public String signature;
        public String username;

        private d() {
        }

        /* synthetic */ d(c cVar, byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.webview.fts.c$c  reason: collision with other inner class name */
    public class C1954c {
        public String BdC;
        public aeq BeX;
        public int IOs;
        public boolean IOt;
        public String IOu;
        public int IOv;
        public int dVS;
        public String hes;
        public String nickname;
        public int position;
        public String query;
        public int scene;
        public String signature;
        public String username;

        private C1954c() {
        }

        /* synthetic */ C1954c(c cVar, byte b2) {
            this();
        }
    }

    public static class b {
        long IOq;
        long IOr;
        String dNA;
        boolean hjq = false;
        private String mdi = null;
        String rjq;
        int scene;
        int type;

        /* access modifiers changed from: package-private */
        public final boolean isAvailable() {
            AppMethodBeat.i(77891);
            if (this.hjq) {
                AppMethodBeat.o(77891);
                return false;
            } else if (Util.isNullOrNil(this.dNA) || (System.currentTimeMillis() / 1000) - this.IOr > this.IOq) {
                AppMethodBeat.o(77891);
                return false;
            } else {
                AppMethodBeat.o(77891);
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public final String gax() {
            AppMethodBeat.i(77892);
            if (this.mdi == null) {
                this.mdi = "";
                try {
                    JSONArray optJSONArray = new JSONObject(this.dNA).optJSONObject("data").optJSONObject("hotwords").optJSONArray("items");
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        arrayList.add(Uri.encode(optJSONArray.optJSONObject(i2).optString("hotword")));
                    }
                    this.mdi = TextUtils.join("|", arrayList);
                } catch (Exception e2) {
                }
            }
            String str = this.mdi;
            AppMethodBeat.o(77892);
            return str;
        }

        /* access modifiers changed from: package-private */
        public final void kf(int i2, int i3) {
            AppMethodBeat.i(77893);
            clt clt = new clt();
            String aTb = com.tencent.mm.plugin.record.b.aTb();
            String G = c.G(i2, i3, false);
            if (!G.equals(c.G(i2, i3, true))) {
                this.hjq = true;
            }
            o oVar = new o(aTb, G);
            byte[] aW = s.aW(aa.z(oVar.her()), 0, (int) oVar.length());
            if (aW != null) {
                try {
                    clt.parseFrom(aW);
                    this.scene = clt.scene;
                    this.dNA = clt.MaZ;
                    this.IOq = clt.Mre;
                    this.IOr = clt.Mrf;
                    this.rjq = clt.KZj;
                    this.type = clt.oUv;
                    Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "load bizCacheFile %s %d", aa.z(oVar.her()), Integer.valueOf(aW.length));
                    AppMethodBeat.o(77893);
                    return;
                } catch (IOException e2) {
                }
            }
            AppMethodBeat.o(77893);
        }
    }

    static String G(int i2, int i3, boolean z) {
        AppMethodBeat.i(77916);
        String str = "FTS_BizCacheObj" + i2 + "-" + i3;
        String str2 = str + "-" + LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
        if (z) {
            AppMethodBeat.o(77916);
            return str2;
        } else if (new o(com.tencent.mm.plugin.record.b.aTb(), str2).exists()) {
            AppMethodBeat.o(77916);
            return str2;
        } else {
            AppMethodBeat.o(77916);
            return str;
        }
    }

    /* access modifiers changed from: package-private */
    public static class g {
        public long IOr = 0;
        public int IOy = 0;
        public String dNA = "";
        public long interval = 0;
        public int scene = 0;

        public g() {
        }

        public g(int i2, ext ext, int i3) {
            AppMethodBeat.i(210824);
            this.scene = i2;
            this.dNA = ext.dNA;
            this.interval = (long) ext.gTn;
            this.IOr = System.currentTimeMillis() / 1000;
            this.IOy = i3;
            AppMethodBeat.o(210824);
        }

        public static g afN(int i2) {
            g gVar;
            AppMethodBeat.i(210825);
            o oVar = new o(com.tencent.mm.plugin.record.b.aTb(), afO(i2));
            byte[] aW = s.aW(aa.z(oVar.her()), 0, (int) oVar.length());
            try {
                clu clu = new clu();
                clu.parseFrom(aW);
                gVar = new g();
                try {
                    gVar.scene = clu.Scene;
                    gVar.dNA = clu.MaZ;
                    gVar.interval = clu.Mrg;
                    gVar.IOr = clu.Mrf;
                    gVar.IOy = clu.Mrh;
                } catch (Exception e2) {
                }
            } catch (Exception e3) {
                gVar = null;
            }
            AppMethodBeat.o(210825);
            return gVar;
        }

        static String afO(int i2) {
            AppMethodBeat.i(77896);
            String str = "SearchGuide_" + i2 + "-" + LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
            AppMethodBeat.o(77896);
            return str;
        }

        public final boolean isExpired() {
            AppMethodBeat.i(77897);
            if (this.IOr + this.interval <= System.currentTimeMillis() / 1000) {
                AppMethodBeat.o(77897);
                return true;
            }
            AppMethodBeat.o(77897);
            return false;
        }
    }

    public final g afM(int i2) {
        g afN;
        AppMethodBeat.i(210829);
        if (this.IOc.get(Integer.valueOf(i2)) == null && (afN = g.afN(i2)) != null) {
            this.IOc.put(Integer.valueOf(i2), afN);
        }
        g gVar = this.IOc.get(Integer.valueOf(i2));
        AppMethodBeat.o(210829);
        return gVar;
    }

    public class e {
        public boolean GjI;
        public boolean dDz;
        public boolean gqx = true;
        public String query;
        public int rjr;
        public int scene;

        public e() {
        }

        public final void v(int i2, String str, int i3) {
            this.query = str;
            this.scene = i2;
            this.dDz = false;
            this.rjr = i3;
            this.GjI = false;
            this.gqx = false;
        }
    }

    public static boolean bu(Map<String, Object> map) {
        AppMethodBeat.i(77917);
        Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "setSearchInputWord %s", map);
        String N = ai.N(map, "word");
        boolean O = ai.O(map, "isInputChange");
        String N2 = ai.N(map, "custom");
        String N3 = ai.N(map, "tagList");
        boolean O2 = ai.O(map, "cache");
        com.tencent.mm.plugin.webview.ui.tools.jsapi.f ahd = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(Util.nullAsInt(map.get("webview_instance_id"), -1));
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_new_query", N);
        bundle.putString("fts_key_custom_query", N2);
        bundle.putBoolean("fts_key_need_keyboard", O);
        bundle.putString("fts_key_tag_list", N3);
        bundle.putBoolean("fts_key_cache", O2);
        try {
            if (ahd.ISw != null) {
                ahd.ISw.f(122, bundle);
            }
        } catch (RemoteException e2) {
            Log.w("MicroMsg.MsgHandler", "onFTSSearchQueryChange exception" + e2.getMessage());
        }
        AppMethodBeat.o(77917);
        return false;
    }

    public class a implements Runnable {
        public boolean IOp;
        public String data;

        private a() {
        }

        public /* synthetic */ a(c cVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(77890);
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(this.data);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    TimeLineObject PM = ((n) com.tencent.mm.kernel.g.af(n.class)).PM(jSONArray.getString(i2));
                    com.tencent.mm.kernel.g.aAi();
                    com.tencent.mm.ay.f a2 = com.tencent.mm.ay.i.a(com.tencent.mm.kernel.g.aAh().hqG, PM, 9, null);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
                if (!this.IOp || c.this.IOe == null) {
                    c.this.IOe = arrayList;
                    AppMethodBeat.o(77890);
                    return;
                }
                c.this.IOe.addAll(arrayList);
                AppMethodBeat.o(77890);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewLogic", e2, "", new Object[0]);
                AppMethodBeat.o(77890);
            }
        }
    }

    public final boolean bv(Map<String, Object> map) {
        AppMethodBeat.i(77918);
        String str = (String) map.get(SearchIntents.EXTRA_QUERY);
        String str2 = (String) map.get("sortedContacts");
        final int safeParseInt = Util.safeParseInt((String) map.get("offset"));
        final int safeParseInt2 = Util.safeParseInt((String) map.get("count"));
        final int nullAsInt = Util.nullAsInt(map.get("webview_instance_id"), -1);
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str2);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                arrayList.add(jSONArray.optString(i2));
            }
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewLogic", e2, "", new Object[0]);
        }
        if (this.IOf == null) {
            this.IOf = new com.tencent.mm.plugin.websearch.b.a.b();
        }
        com.tencent.mm.plugin.websearch.b.a.d dVar = new com.tencent.mm.plugin.websearch.b.a.d(str, arrayList);
        if (this.IOg == null || !this.IOg.equals(dVar)) {
            this.IOg = dVar;
            this.IOf.a(dVar, new c.a() {
                /* class com.tencent.mm.plugin.webview.fts.c.AnonymousClass5 */

                @Override // com.tencent.mm.plugin.websearch.b.a.c.a
                public final void fYI() {
                    AppMethodBeat.i(210823);
                    c.a(c.this.IOg, safeParseInt, safeParseInt2, nullAsInt);
                    AppMethodBeat.o(210823);
                }
            });
        } else if (this.IOg.dDz) {
            a(this.IOg, safeParseInt, safeParseInt2, nullAsInt);
        }
        AppMethodBeat.o(77918);
        return false;
    }

    static void a(com.tencent.mm.plugin.websearch.b.a.d dVar, int i2, int i3, int i4) {
        AppMethodBeat.i(77919);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i4).cd(dVar.kd(i2, i3));
        AppMethodBeat.o(77919);
    }

    public final boolean bw(Map<String, Object> map) {
        AppMethodBeat.i(77920);
        String N = ai.N(map, "md5");
        int b2 = ai.b(map, "offset", 0);
        String N2 = ai.N(map, "searchId");
        String N3 = ai.N(map, "sessionId");
        int b3 = ai.b(map, "tab", 0);
        String N4 = ai.N(map, "requestId");
        int b4 = ai.b(map, "scene", 0);
        int b5 = ai.b(map, "webview_instance_id", -1);
        String N5 = ai.N(map, "emojiUrl");
        String N6 = ai.N(map, "aesKey");
        if (this.IOh != null) {
            com.tencent.mm.kernel.g.azz().a(this.IOh);
            com.tencent.mm.kernel.g.azz().b(2999, this);
        }
        com.tencent.mm.kernel.g.azz().a(2999, this);
        this.IOh = new d(N, b2, N2, N3, b3, N4, b4, N5, N6);
        this.IOh.dVL = b5;
        com.tencent.mm.kernel.g.azz().a(this.IOh, 0);
        AppMethodBeat.o(77920);
        return false;
    }

    private static String i(int i2, Map<String, String> map) {
        AppMethodBeat.i(77922);
        switch (i2) {
            case 21:
                String g2 = ai.g(map, 1);
                AppMethodBeat.o(77922);
                return g2;
            case 201:
                String bd = com.tencent.mm.plugin.websearch.c.a.bd(map);
                AppMethodBeat.o(77922);
                return bd;
            default:
                String bd2 = ai.bd(map);
                AppMethodBeat.o(77922);
                return bd2;
        }
    }

    public static boolean bx(Map<String, Object> map) {
        AppMethodBeat.i(210830);
        Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "openFinderFeed %s", map);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("feedId", ai.N(map, "feedId"));
            jSONObject.put(IssueStorage.COLUMN_EXT_INFO, new JSONObject(ai.N(map, IssueStorage.COLUMN_EXT_INFO)));
            jSONObject.put("extraInfo", ai.N(map, "extraInfo"));
            Intent intent = new Intent();
            intent.putExtra("tab_type", 8);
            ((aj) com.tencent.mm.kernel.g.ah(aj.class)).fillContextIdToIntent(6, 2, 25, intent);
            ((aj) com.tencent.mm.kernel.g.ah(aj.class)).enterFinderShareFeedUI(MMApplicationContext.getContext(), jSONObject.toString(), intent);
        } catch (Exception e2) {
        }
        AppMethodBeat.o(210830);
        return false;
    }

    public static boolean by(Map<String, Object> map) {
        AppMethodBeat.i(210831);
        Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "getCurrentLocation %s", map);
        try {
            int b2 = ai.b(map, "webview_instance_id", -1);
            chl clJ = ai.clJ();
            if (clJ != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("latitude", (double) clJ.LbD);
                jSONObject.put("longitude", (double) clJ.LbC);
                jSONObject.put("precision", clJ.LuT);
                jSONObject.put("macAddr", (double) clJ.LbD);
                jSONObject.put("cellId", (double) clJ.LbD);
                jSONObject.put("gpsSource", (double) clJ.LbD);
                jSONObject.put("address", (double) clJ.LbD);
                com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(b2).baW(jSONObject.toString());
            } else {
                com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(b2).baW("");
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(210831);
        return false;
    }

    public static boolean bz(Map<String, Object> map) {
        AppMethodBeat.i(210832);
        Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "navControl %s", map);
        try {
            int b2 = ai.b(map, "webview_instance_id", -1);
            String N = ai.N(map, NativeProtocol.WEB_DIALOG_ACTION);
            com.tencent.mm.plugin.webview.ui.tools.jsapi.f ahd = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(b2);
            Bundle bundle = new Bundle();
            bundle.putString("fts_key_data", N);
            try {
                if (ahd.ISw != null) {
                    ahd.ISw.f(154, bundle);
                }
            } catch (RemoteException e2) {
                Log.w("MicroMsg.MsgHandler", "onNavControl exception" + e2.getMessage());
            }
        } catch (Exception e3) {
        }
        AppMethodBeat.o(210832);
        return false;
    }

    public static boolean bA(Map<String, Object> map) {
        AppMethodBeat.i(210833);
        Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "showNavBarShadow %s", map);
        try {
            int b2 = ai.b(map, "webview_instance_id", -1);
            String N = ai.N(map, "color");
            double doubleValue = Double.valueOf(map.get("alpha").toString()).doubleValue();
            int parseInt = Integer.parseInt(N.substring(1, N.length()), 16);
            com.tencent.mm.plugin.webview.ui.tools.jsapi.f ahd = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(b2);
            Bundle bundle = new Bundle();
            bundle.putInt("fts_key_data", parseInt);
            bundle.putInt("fts_key_cache", (int) (doubleValue * 255.0d));
            try {
                if (ahd.ISw != null) {
                    ahd.ISw.f(155, bundle);
                }
            } catch (RemoteException e2) {
                Log.w("MicroMsg.MsgHandler", "showNavBarShadow exception" + e2.getMessage());
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(210833);
        return false;
    }

    public static boolean bB(Map<String, Object> map) {
        AppMethodBeat.i(210834);
        Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "hideNavBarShadow");
        try {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.f ahd = com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(ai.b(map, "webview_instance_id", -1));
            try {
                if (ahd.ISw != null) {
                    ahd.ISw.f(156, new Bundle());
                }
            } catch (RemoteException e2) {
                Log.w("MicroMsg.MsgHandler", "hideNavBarShadow exception" + e2.getMessage());
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(210834);
        return false;
    }
}
