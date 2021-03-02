package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.pu;
import com.tencent.mm.g.a.ra;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.al;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.plugin.websearch.b.a.e;
import com.tencent.mm.plugin.webview.fts.h;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.ctz;
import com.tencent.mm.protocal.protobuf.egk;
import com.tencent.mm.protocal.protobuf.eou;
import com.tencent.mm.protocal.protobuf.fap;
import com.tencent.mm.protocal.protobuf.fel;
import com.tencent.mm.protocal.protobuf.qu;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.d;
import com.tencent.mmkv.MMKV;
import com.tencent.recovery.log.RecoveryFileLog;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class j implements i {
    static final long IOO = ((long) (d.gGT() + 500));
    private static MMKV mmkv;
    private l Bdt = new l() {
        /* class com.tencent.mm.plugin.webview.fts.j.AnonymousClass7 */

        @Override // com.tencent.mm.plugin.fts.a.l
        public final void b(k kVar) {
            AppMethodBeat.i(210846);
            switch (kVar.resultCode) {
                case 0:
                    if (kVar.wXb == null || kVar.wXb.size() == 0) {
                        Log.i("MicroMsg.WebSearch.WebSearchLogic", "local contact search size 0");
                        g.ahd(((Integer) j.this.wXa.wVS).intValue()).aXm("");
                        AppMethodBeat.o(210846);
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        JSONArray jSONArray = new JSONArray();
                        JSONObject jSONObject2 = new JSONObject();
                        JSONArray jSONArray2 = new JSONArray();
                        for (m mVar : kVar.wXb) {
                            if (mVar.type == 131072) {
                                jSONArray2.put(j.a(mVar, kVar.wWd));
                            }
                        }
                        jSONObject2.put("items", jSONArray2);
                        jSONObject2.put("title", MMApplicationContext.getContext().getString(R.string.dke));
                        jSONObject2.put("count", jSONArray2.length());
                        jSONObject2.put("type", 3);
                        jSONArray.put(jSONObject2);
                        jSONObject.put("data", jSONArray);
                        jSONObject.put("ret", 0);
                        g.ahd(((Integer) j.this.wXa.wVS).intValue()).aXm(jSONObject.toString());
                        AppMethodBeat.o(210846);
                        return;
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", e2, "onSearchDone", new Object[0]);
                        AppMethodBeat.o(210846);
                        return;
                    }
                case -3:
                case -2:
                case -1:
                    g.ahd(((Integer) j.this.wXa.wVS).intValue()).aXm("");
                    break;
            }
            AppMethodBeat.o(210846);
        }
    };
    public fap IDS;
    h.a INN = new h.a() {
        /* class com.tencent.mm.plugin.webview.fts.j.AnonymousClass6 */

        @Override // com.tencent.mm.plugin.webview.fts.h.a
        public final void a(h.b bVar) {
            AppMethodBeat.i(210845);
            Log.i("MicroMsg.WebSearch.WebSearchLogic", "handleCallback %s", bVar);
            if (bVar == null) {
                AppMethodBeat.o(210845);
                return;
            }
            int intValue = ((Integer) bVar.IOM).intValue();
            a aVar = (a) bVar.ION;
            if (aVar == null) {
                AppMethodBeat.o(210845);
                return;
            }
            Log.i("MicroMsg.WebSearch.WebSearchLogic", "calling back to webview, id %d, reqId %s,  %s", Integer.valueOf(intValue), aVar.dVP, j.this.IOW);
            g.ahd(intValue).a(aVar.data, aVar.IPu, aVar.dVP, aVar.dNV);
            AppMethodBeat.o(210845);
        }
    };
    public final MMHandler IOP;
    private volatile v IOW;
    public IListener IOZ = new IListener<ra>() {
        /* class com.tencent.mm.plugin.webview.fts.j.AnonymousClass1 */

        {
            AppMethodBeat.i(160416);
            this.__eventId = ra.class.getName().hashCode();
            AppMethodBeat.o(160416);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* bridge */ /* synthetic */ boolean callback(ra raVar) {
            AppMethodBeat.i(77951);
            AppMethodBeat.o(77951);
            return false;
        }
    };
    public int IPh = 0;
    public fap IPi;
    public Map<String, Integer> IPj = new HashMap();
    long IPk;
    public IListener IPl = new IListener<pu>() {
        /* class com.tencent.mm.plugin.webview.fts.j.AnonymousClass2 */

        {
            AppMethodBeat.i(160417);
            this.__eventId = pu.class.getName().hashCode();
            AppMethodBeat.o(160417);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(pu puVar) {
            AppMethodBeat.i(77952);
            pu puVar2 = puVar;
            j jVar = j.this;
            String str = puVar2.dVN.dVP;
            String str2 = puVar2.dVN.sessionId;
            String str3 = puVar2.dVN.dVO;
            String str4 = puVar2.dVN.query;
            int i2 = puVar2.dVN.scene;
            String str5 = puVar2.dVN.dVQ;
            String str6 = puVar2.dVN.dVR;
            int i3 = puVar2.dVN.dVS;
            int i4 = puVar2.dVN.dVT;
            String str7 = puVar2.dVN.dDL;
            Map<String, String> map = puVar2.dVN.dVU;
            if (i2 == 20) {
                Log.i("MicroMsg.WebSearch.WebSearchLogic", "preGetTeachSearchData requestId:%s, sessionId:%s", str, str2);
                c gds = com.tencent.mm.plugin.webview.modeltools.g.gds();
                if (!gds.ke(20, 0).isAvailable()) {
                    Log.i("MicroMsg.WebSearch.WebSearchLogic", "do real preGetTeachSearchData");
                    jVar.IPn.p(2, str);
                    com.tencent.mm.kernel.g.azz().a(1048, gds);
                    com.tencent.mm.kernel.g.azz().a(new ac(20, 0, ai.aft(0), -1, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), ak.aXe("discoverSearchEntry").optLong("guideParam"), str, str2, null), 0);
                }
            }
            if (!TextUtils.isEmpty(str4) || !TextUtils.isEmpty(str7)) {
                MMKV gaC = j.gaC();
                String decodeString = gaC.decodeString("websearch_preget_extReqParams", "");
                int decodeInt = gaC.decodeInt("websearch_preget_version", 0);
                int aft = ai.aft(0);
                Log.i("MicroMsg.WebSearch.WebSearchLogic", "getPreGetExtReqParams:%s,set %s, cur %s", decodeString, Integer.valueOf(decodeInt), Integer.valueOf(aft));
                if (decodeInt != aft) {
                    decodeString = "";
                }
                if (!(!TextUtils.isEmpty(decodeString))) {
                    Log.w("MicroMsg.WebSearch.WebSearchLogic", "do no support pre get data, h5.ver %d, seq %s, sessionId %s, subSessionId %s", Integer.valueOf(ai.aft(0)), str, str2, str3);
                } else if (System.currentTimeMillis() - jVar.IPk <= j.IOO) {
                    Log.w("MicroMsg.WebSearch.WebSearchLogic", "pre get data fail for time interval limit");
                } else {
                    Log.w("MicroMsg.WebSearch.WebSearchLogic", "pre get data, h5.ver %d, seq %s, sessionId %s, subSessionId %s", Integer.valueOf(ai.aft(0)), str, str2, str3);
                    jVar.a(str, str2, str3, str4, i2, str5, str6, i3, i4, str7, decodeString, map);
                    jVar.IPk = System.currentTimeMillis();
                }
            } else {
                Log.i("MicroMsg.WebSearch.WebSearchLogic", "do not pre get data query:%s,reqKey:%s", str4, str7);
            }
            AppMethodBeat.o(77952);
            return false;
        }
    };
    private com.tencent.mm.plugin.websearch.b.a.c IPm = new com.tencent.mm.plugin.websearch.b.a.b();
    public final h IPn;
    public b IPo = new b(this, (byte) 0);
    public c IPp = new c(this, (byte) 0);
    public com.tencent.mm.plugin.fts.a.a.a wXa;

    static /* synthetic */ v a(j jVar, Map map) {
        AppMethodBeat.i(210853);
        v bE = jVar.bE(map);
        AppMethodBeat.o(210853);
        return bE;
    }

    static {
        AppMethodBeat.i(77974);
        AppMethodBeat.o(77974);
    }

    public j() {
        AppMethodBeat.i(77960);
        Log.d("MicroMsg.WebSearch.WebSearchLogic", "create WebSearchLogic");
        this.IOZ.alive();
        this.IPl.alive();
        this.IOP = new MMHandler("WebSearchLogic_worker");
        this.IPn = new h(this.IOP);
        AppMethodBeat.o(77960);
    }

    public final h gaB() {
        return this.IPn;
    }

    public class b implements Comparable {
        public com.tencent.mm.plugin.websearch.api.a IPe;
        public a IPv;
        private ThreadPoolExecutor dvM;

        private b() {
            AppMethodBeat.i(77957);
            this.dvM = new ThreadPoolExecutor(0, 10, 120, TimeUnit.SECONDS, new ArrayBlockingQueue(32));
            AppMethodBeat.o(77957);
        }

        /* synthetic */ b(j jVar, byte b2) {
            this();
        }

        public final void b(v vVar) {
            AppMethodBeat.i(77958);
            if (this.IPv != null) {
                this.IPv.stopped = true;
            }
            this.IPv = new a(this, (byte) 0);
            this.IPv.IDt = vVar;
            j.this.IOW = vVar;
            this.dvM.execute(this.IPv);
            AppMethodBeat.o(77958);
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            return 0;
        }

        public class a implements Runnable {
            v IDt;
            public volatile boolean stopped;

            private a() {
            }

            /* synthetic */ a(b bVar, byte b2) {
                this();
            }

            public final void run() {
                AppMethodBeat.i(77956);
                if (Thread.interrupted()) {
                    AppMethodBeat.o(77956);
                } else if (!Util.isNullOrNil(this.IDt.dDv) || this.IDt.IDX == 2) {
                    switch (this.IDt.scene) {
                        case 3:
                        case 16:
                        case 20:
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("word", this.IDt.dDv);
                                jSONObject.put("id", String.valueOf(System.currentTimeMillis()));
                                jSONObject.put(AppMeasurement.Param.TIMESTAMP, String.valueOf(System.currentTimeMillis()));
                                jSONObject.put("showType", 0);
                            } catch (Exception e2) {
                            }
                            ((n) com.tencent.mm.kernel.g.ah(n.class)).addSOSHistory(this.IDt.dDv + "​0", jSONObject.toString());
                            break;
                    }
                    Log.i("MicroMsg.WebSearch.WebSearchLogic", "start New NetScene %s ,  %d", this.IDt.dDv, Integer.valueOf(this.IDt.dVL));
                    if (b.this.IPe != null) {
                        com.tencent.mm.kernel.g.azz().a(b.this.IPe);
                    }
                    e eVar = null;
                    if ((this.IDt.IDF == null || this.IDt.IDF.isEmpty()) && j.aE(this.IDt.dDv, this.IDt.scene, this.IDt.businessType)) {
                        long currentTimeMillis = System.currentTimeMillis();
                        eVar = (e) j.this.IPm.aXo(this.IDt.dDv);
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        Log.i("MicroMsg.WebSearch.WebSearchLogic", "match contact cost %d ms", Long.valueOf(currentTimeMillis2));
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14717, this.IDt.dDv, Integer.valueOf(ab.aVb()), Integer.valueOf(eVar.mWl.size()), Long.valueOf(currentTimeMillis2), Integer.valueOf(this.IDt.scene));
                    }
                    if (this.stopped) {
                        Log.i("MicroMsg.WebSearch.WebSearchLogic", "was cancelled");
                        AppMethodBeat.o(77956);
                        return;
                    }
                    com.tencent.mm.plugin.webview.modeltools.g.gds().IOd.v(this.IDt.scene, this.IDt.dDv, this.IDt.businessType);
                    b.this.IPe = b.c(this.IDt);
                    if (eVar != null) {
                        LinkedList<eou> linkedList = new LinkedList<>();
                        for (e.a aVar : new ArrayList(eVar.mWl)) {
                            eou eou = new eou();
                            eou.UserName = aVar.userName;
                            eou.NmU = aVar.IGC;
                            eou.oUJ = aVar.nickName;
                            eou.LoI = aVar.remark;
                            eou.ked = aVar.fMb;
                            eou.KHk = aVar.desc;
                            linkedList.add(eou);
                        }
                        b.this.IPe.by(linkedList);
                    }
                    com.tencent.mm.kernel.g.azz().a(b.this.IPe.getType(), j.this);
                    com.tencent.mm.kernel.g.azz().a(b.this.IPe, 0);
                    Log.i("MicroMsg.WebSearch.WebSearchLogic", "doScene(type : %s)", Integer.valueOf(b.this.IPe.getType()));
                    AppMethodBeat.o(77956);
                } else {
                    Log.i("MicroMsg.WebSearch.WebSearchLogic", "error query %d %d %d %d %s %d", Integer.valueOf(this.IDt.businessType), Integer.valueOf(this.IDt.scene), Integer.valueOf(this.IDt.IDE), Integer.valueOf(this.IDt.dVS), this.IDt.rjq, Integer.valueOf(this.IDt.offset));
                    AppMethodBeat.o(77956);
                }
            }
        }

        static /* synthetic */ com.tencent.mm.plugin.websearch.api.a c(v vVar) {
            com.tencent.mm.plugin.websearch.api.a fVar;
            AppMethodBeat.i(210848);
            if (vVar.IDX == 2) {
                fVar = new p(vVar);
            } else {
                fVar = new f(vVar);
            }
            fVar.afo(vVar.dVL);
            AppMethodBeat.o(210848);
            return fVar;
        }
    }

    public final boolean bC(final Map<String, Object> map) {
        AppMethodBeat.i(77961);
        int nullAsInt = Util.nullAsInt(map.get("webview_instance_id"), -1);
        String N = ai.N(map, "requestId");
        if (!ai.O(map, "isBackButtonClick")) {
            g.ahd(nullAsInt).d(ai.b(map, "type", 0), ai.N(map, SearchIntents.EXTRA_QUERY), map);
        }
        Log.i("MicroMsg.WebSearch.WebSearchLogic", "getSearchData: %s,wid: %s,rid: %s", map.toString(), Integer.valueOf(nullAsInt), N);
        this.IPn.a(1, N, Integer.valueOf(nullAsInt), new Runnable() {
            /* class com.tencent.mm.plugin.webview.fts.j.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(77954);
                j.this.IPo.b(j.a(j.this, map));
                AppMethodBeat.o(77954);
            }
        }, this.INN);
        AppMethodBeat.o(77961);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x001f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void setPreGetParams(java.lang.String r7) {
        /*
            r6 = 210849(0x337a1, float:2.95462E-40)
            r4 = 1
            r5 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            java.lang.String r0 = "MicroMsg.WebSearch.WebSearchLogic"
            java.lang.String r1 = "setPreGetParams: %s"
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r2[r5] = r7
            com.tencent.mm.sdk.platformtools.Log.i(r0, r1, r2)
            r1 = 0
            if (r7 == 0) goto L_0x004c
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Throwable -> 0x003e }
            r0.<init>(r7)     // Catch:{ Throwable -> 0x003e }
        L_0x001d:
            if (r0 == 0) goto L_0x004e
            java.lang.String r1 = "extReqParams"
            java.lang.String r0 = r0.optString(r1)
        L_0x0026:
            com.tencent.mmkv.MMKV r1 = gaC()
            java.lang.String r2 = "websearch_preget_extReqParams"
            r1.encode(r2, r0)
            java.lang.String r0 = "websearch_preget_version"
            int r2 = com.tencent.mm.plugin.websearch.api.ai.aft(r5)
            r1.encode(r0, r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            return
        L_0x003e:
            r0 = move-exception
            java.lang.String r2 = "MicroMsg.WebSearch.WebSearchLogic"
            java.lang.String r3 = "setPreGetParams err"
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r5] = r0
            com.tencent.mm.sdk.platformtools.Log.e(r2, r3, r4)
        L_0x004c:
            r0 = r1
            goto L_0x001d
        L_0x004e:
            java.lang.String r0 = ""
            goto L_0x0026
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.fts.j.setPreGetParams(java.lang.String):void");
    }

    static MMKV gaC() {
        AppMethodBeat.i(210850);
        if (mmkv == null) {
            mmkv = MMKV.mmkvWithID("WebSearchLogic", 2);
        }
        MMKV mmkv2 = mmkv;
        AppMethodBeat.o(210850);
        return mmkv2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0102 A[SYNTHETIC, Splitter:B:18:0x0102] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, int r12, java.lang.String r13, java.lang.String r14, int r15, int r16, java.lang.String r17, java.lang.String r18, java.util.Map<java.lang.String, java.lang.String> r19) {
        /*
        // Method dump skipped, instructions count: 405
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.fts.j.a(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, int, int, java.lang.String, java.lang.String, java.util.Map):boolean");
    }

    private v bE(Map<String, Object> map) {
        String str;
        AppMethodBeat.i(77967);
        int b2 = ai.b(map, "scene", 0);
        v vVar = new v();
        vVar.dDv = ai.N(map, SearchIntents.EXTRA_QUERY);
        vVar.offset = ai.b(map, "offset", 0);
        vVar.businessType = ai.b(map, "type", 0);
        vVar.scene = b2;
        vVar.IDG = ai.N(map, "sugId");
        vVar.IDI = ai.b(map, "sugType", 0);
        vVar.IDH = ai.N(map, "prefixSug");
        vVar.IDT = ai.N(map, "poiInfo");
        vVar.IDE = ai.O(map, "isHomePage") ? 1 : 0;
        vVar.rjq = ai.N(map, "searchId");
        if (map.containsKey("sessionId")) {
            vVar.sessionId = ai.N(map, "sessionId");
        }
        vVar.dVS = ai.b(map, "sceneActionType", 1);
        vVar.IDK = ai.b(map, "displayPattern", 2);
        vVar.IDL = ai.b(map, "sugPosition", 0);
        vVar.IDM = ai.N(map, "sugBuffer");
        vVar.dPI = ai.N(map, "requestId");
        vVar.sessionId = ai.N(map, "sessionId");
        vVar.dVO = ai.N(map, "subSessionId");
        vVar.IDU = ai.N(map, "tagId");
        vVar.IDY = ai.O(map, "fromTagSearch");
        try {
            JSONObject jSONObject = new JSONObject(URLDecoder.decode(ai.N(map, "extClientParams"), ProtocolPackage.ServerEncoding));
            vVar.IEb = jSONObject.optString("ShareSceneId");
            vVar.IEc = jSONObject.optInt("SnsContentType");
            String optString = jSONObject.optString("exposedFingerWord");
            String optString2 = jSONObject.optString("matchedFingerWord");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                aca aca = new aca();
                aca.key = "exposedFingerWord";
                aca.LmD = optString;
                aca aca2 = new aca();
                aca2.key = "matchedFingerWord";
                aca2.LmD = optString2;
                vVar.IDO.add(aca);
                vVar.IDO.add(aca2);
            }
        } catch (Throwable th) {
        }
        String N = ai.N(map, "extReqParams");
        if (!Util.isNullOrNil(N)) {
            try {
                JSONArray jSONArray = new JSONArray(N);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    aca aca3 = new aca();
                    aca3.key = jSONObject2.optString("key", "");
                    aca3.LmC = (long) jSONObject2.optInt("uintValue", 0);
                    aca3.LmD = jSONObject2.optString("textValue", "");
                    vVar.IDO.add(aca3);
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", e2, "commKvJSONArray", new Object[0]);
            }
        }
        String N2 = ai.N(map, "matchUser");
        if (!Util.isNullOrNil(N2)) {
            try {
                JSONObject jSONObject3 = new JSONObject(N2);
                eou eou = new eou();
                eou.UserName = jSONObject3.optString("userName");
                eou.NmU = jSONObject3.optString("matchWord");
                if (!TextUtils.isEmpty(eou.UserName)) {
                    vVar.IDF.add(eou);
                }
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", e3, "matchUserJSONArray", new Object[0]);
            }
        }
        String N3 = ai.N(map, "prefixQuery");
        if (!Util.isNullOrNil(N3)) {
            try {
                JSONArray jSONArray2 = new JSONArray(N3);
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    vVar.IDJ.add(jSONArray2.getString(i3));
                }
            } catch (Exception e4) {
                Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", e4, "prefixQueryJSONArray", new Object[0]);
            }
        }
        String N4 = ai.N(map, "tagInfo");
        if (!Util.isNullOrNil(N4)) {
            try {
                JSONObject jSONObject4 = new JSONObject(N4);
                vVar.IDN = new egk();
                vVar.IDN.Ngs = jSONObject4.optString("tagText");
                vVar.IDN.Ngr = jSONObject4.optInt("tagType");
                vVar.IDN.Ngt = jSONObject4.optString("tagExtValue");
            } catch (Exception e5) {
                Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", e5, "tagInfoObj", new Object[0]);
            }
        }
        String N5 = ai.N(map, "numConditions");
        if (!Util.isNullOrNil(N5)) {
            try {
                JSONArray jSONArray3 = new JSONArray(N5);
                for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                    JSONObject optJSONObject = jSONArray3.optJSONObject(i4);
                    ctz ctz = new ctz();
                    ctz.Mzn = optJSONObject.optLong("from");
                    ctz.Mzo = optJSONObject.optLong("to");
                    ctz.Mzm = optJSONObject.optInt("field");
                    vVar.IDP.add(ctz);
                }
            } catch (Exception e6) {
                Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", e6, "numConditionsArray", new Object[0]);
            }
        }
        vVar.dVL = Util.nullAsInt(map.get("webview_instance_id"), -1);
        vVar.language = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
        vVar.wVW = ai.b(map, "subType", 0);
        vVar.IDQ = ai.b(map, "isWeAppMore", 0);
        if (vVar.IDQ == 1) {
            vVar.IDR = new fel();
            vVar.IDR.KRN = ai.aft(3);
            vVar.IDR.NzF = com.tencent.mm.modelappbrand.b.iIn;
            vVar.IDR.Mzg = ai.b(map, "subType", 0);
            vVar.IDR.session_id = com.tencent.mm.modelappbrand.b.iIm;
            vVar.IDR.NzG = vVar.IDL;
            Object obj = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WXA_SEARCH_INPUT_HINT_CONTENT_ID_STRING_SYNC, (Object) null);
            if (obj != null && (obj instanceof String)) {
                vVar.IDR.MOt = (String) obj;
            }
        }
        if (this.IPh == 1) {
            vVar.IDS = this.IDS;
        } else {
            vVar.IDS = null;
        }
        String str2 = vVar.dDv;
        com.tencent.mm.plugin.webview.fts.b.a.a.gaG();
        com.tencent.mm.plugin.webview.fts.b.a.a.a aXY = com.tencent.mm.plugin.webview.fts.b.a.a.aXY(str2);
        if (aXY == null) {
            str = "";
        } else {
            Log.i("MicroMsg.WebSearch.WebSearchLogic", "test-widget-ui args %s, %s, %s, %s", aXY.IPJ, aXY.dNI, aXY.IPH, aXY.IPI);
            this.IDS = new fap();
            this.IDS.NwQ = 1;
            this.IDS.NwR = new qu();
            this.IDS.NwR.dNI = aXY.dNI;
            this.IDS.NwR.KXC = Util.safeParseInt(aXY.IPH);
            this.IDS.NwR.qHp = aXY.IPI;
            str = aXY.IPJ;
        }
        if (!TextUtils.isEmpty(str)) {
            vVar.dDv = str;
            vVar.IDS = this.IDS;
        }
        if (vVar.scene == 33 && this.IPi != null) {
            if (vVar.IDS == null) {
                vVar.IDS = new fap();
            }
            if (vVar.IDS.NwR == null) {
                vVar.IDS.NwR = new qu();
            }
            if (this.IPi.NwR != null) {
                vVar.IDS.NwR.KXJ = this.IPi.NwR.KXJ;
                Log.i("MicroMsg.WebSearch.WebSearchLogic", "websearch from url [%s]", this.IPi.NwR.KXJ);
            }
            this.IPi = null;
        }
        if (vVar.businessType == 262144 && this.IPi != null && this.IPi.NwR.KXG == 1) {
            Bundle bundle = new Bundle();
            bundle.putInt("isRefresh", 1);
            bundle.putString("widgetId", ai.N(map, "widgetId"));
            vVar.CAJ = bundle;
            vVar.IDS = this.IPi;
            this.IPi = null;
        }
        String N6 = ai.N(map, "specialSearch");
        if (!Util.isNullOrNil(N6)) {
            try {
                JSONObject jSONObject5 = new JSONObject(N6);
                vVar.IDX = jSONObject5.optInt("type", 0);
                vVar.dDL = jSONObject5.optJSONObject(NativeProtocol.WEB_DIALOG_PARAMS).optString("reqKey");
            } catch (Exception e7) {
            }
        }
        AppMethodBeat.o(77967);
        return vVar;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(77968);
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(qVar != null ? qVar.getType() : 0);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = str;
        Log.v("MicroMsg.WebSearch.WebSearchLogic", "onSceneEnd websearch (type : %s), errType : %s, errCode : %s, errMsg : %s", objArr);
        if (qVar instanceof com.tencent.mm.plugin.websearch.api.a) {
            com.tencent.mm.kernel.g.azz().b(qVar.getType(), this);
            com.tencent.mm.plugin.websearch.api.a aVar = (com.tencent.mm.plugin.websearch.api.a) qVar;
            if (i2 == 0 && i3 == 0) {
                String fXC = aVar.fXC();
                int fXD = aVar.fXD();
                Log.i("MicroMsg.WebSearch.WebSearchLogic", "callback %s", aVar.getKeyword());
                a(aVar.fXz(), fXC, aVar.fXA(), aVar.fXE(), aVar.fXB());
                if (fXD > 0) {
                    Log.i("MicroMsg.WebSearch.WebSearchLogic", "updateCode %d, need update", Integer.valueOf(fXD));
                    com.tencent.mm.pluginsdk.j.a.a.b.gnC();
                    com.tencent.mm.pluginsdk.j.a.a.b.ahP(27);
                }
                AppMethodBeat.o(77968);
                return;
            }
            Log.i("MicroMsg.WebSearch.WebSearchLogic", "net scene fail %s", aVar.getKeyword());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ret", -1);
            } catch (JSONException e2) {
            }
            a(aVar.fXz(), jSONObject.toString(), aVar.fXA(), aVar.fXE(), null);
            AppMethodBeat.o(77968);
            return;
        }
        if (qVar instanceof com.tencent.mm.plugin.websearch.api.b) {
            com.tencent.mm.kernel.g.azz().b(qVar.getType(), this);
            com.tencent.mm.plugin.websearch.api.b bVar = (com.tencent.mm.plugin.websearch.api.b) qVar;
            if (i2 == 0 && i3 == 0) {
                g.ahd(bVar.fXz()).aXm(bVar.fXC());
            } else {
                Log.i("MicroMsg.WebSearch.WebSearchLogic", "net scene fail %s", bVar.getQuery());
                g.ahd(bVar.fXz()).aXm("{}");
                AppMethodBeat.o(77968);
                return;
            }
        }
        AppMethodBeat.o(77968);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        int IOx;
        boolean IPu;
        Bundle dNV;
        String dVP;
        String data;

        public final String toString() {
            AppMethodBeat.i(210847);
            String str = "NetReqResult{webviewId=" + this.IOx + ", data='" + this.data + '\'' + ", isNewQuery=" + this.IPu + ", reqId='" + this.dVP + '\'' + ", extData=" + this.dNV + '}';
            AppMethodBeat.o(210847);
            return str;
        }

        public a(int i2, String str, boolean z, String str2, Bundle bundle) {
            this.IOx = i2;
            this.data = str;
            this.IPu = z;
            this.dVP = str2;
            this.dNV = bundle;
        }
    }

    private void a(int i2, String str, boolean z, String str2, Bundle bundle) {
        AppMethodBeat.i(77969);
        this.IPn.a(1, str2, new a(i2, str, z, str2, bundle), this.INN);
        AppMethodBeat.o(77969);
    }

    public class c {
        public com.tencent.mm.plugin.websearch.api.b IPx;

        private c() {
        }

        /* synthetic */ c(j jVar, byte b2) {
            this();
        }
    }

    public final boolean bF(Map<String, Object> map) {
        int[] iArr;
        AppMethodBeat.i(77970);
        Log.i("MicroMsg.WebSearch.WebSearchLogic", "getSuggestionData %s", map);
        v vVar = new v();
        vVar.dDv = ai.N(map, SearchIntents.EXTRA_QUERY);
        try {
            vVar.dDv = URLDecoder.decode(vVar.dDv, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e2) {
        }
        vVar.businessType = ai.b(map, "type", 0);
        vVar.scene = ai.b(map, "scene", 0);
        vVar.IDE = ai.O(map, "isHomePage") ? 1 : 0;
        vVar.dVL = Util.nullAsInt(map.get("webview_instance_id"), -1);
        vVar.IDJ.add(ai.N(map, "prefixQuery"));
        int b2 = ai.b(map, "requestType", 0);
        vVar.wVW = ai.b(map, "subtype", 0);
        vVar.IDQ = ai.b(map, "isWeAppMore", 0);
        if (vVar.IDQ == 1) {
            vVar.IDR = new fel();
            vVar.IDR.KRN = ai.aft(3);
            vVar.IDR.NzF = com.tencent.mm.modelappbrand.b.iIn;
            vVar.IDR.Mzg = ai.b(map, "subType", 0);
            vVar.IDR.session_id = com.tencent.mm.modelappbrand.b.iIm;
            Object obj = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WXA_SEARCH_INPUT_HINT_CONTENT_ID_STRING_SYNC, (Object) null);
            if (obj != null && (obj instanceof String)) {
                vVar.IDR.MOt = (String) obj;
            }
        }
        Log.i("MicroMsg.WebSearch.WebSearchLogic", "getSearchData, webviewID = %d", Integer.valueOf(vVar.dVL));
        switch (b2) {
            case 0:
                c cVar = this.IPp;
                if (cVar.IPx != null) {
                    com.tencent.mm.kernel.g.azz().b(cVar.IPx.getType(), j.this);
                    com.tencent.mm.kernel.g.azz().a(cVar.IPx);
                    cVar.IPx = null;
                }
                if (cVar.IPx == null) {
                    cVar.IPx = new g(vVar);
                    com.tencent.mm.kernel.g.azz().a(cVar.IPx.getType(), j.this);
                    com.tencent.mm.kernel.g.azz().a(cVar.IPx, 0);
                    break;
                }
                break;
            case 1:
                String str = vVar.dDv;
                int i2 = vVar.businessType;
                int i3 = vVar.dVL;
                if (!Util.isNullOrNil(str)) {
                    if (this.wXa != null) {
                        ((n) com.tencent.mm.kernel.g.ah(n.class)).cancelSearchTask(this.wXa);
                        this.wXa = null;
                    }
                    switch (i2) {
                        case 8:
                            iArr = new int[]{131072};
                            break;
                        default:
                            iArr = null;
                            break;
                    }
                    if (iArr != null) {
                        com.tencent.mm.plugin.fts.a.a.j jVar = new com.tencent.mm.plugin.fts.a.a.j();
                        jVar.kXb = 16;
                        jVar.query = str;
                        jVar.wWU = iArr;
                        jVar.wWW = 5;
                        jVar.wWY = com.tencent.mm.plugin.fts.a.c.b.wXy;
                        jVar.wWX = new HashSet<>();
                        jVar.wWZ = this.Bdt;
                        this.wXa = ((n) com.tencent.mm.kernel.g.ah(n.class)).search(2, jVar);
                        this.wXa.wVS = Integer.valueOf(i3);
                        break;
                    }
                }
                break;
            case 2:
                g.ahd(vVar.dVL).aXm(al.fYh());
                break;
        }
        AppMethodBeat.o(77970);
        return false;
    }

    public static final JSONObject a(m mVar, com.tencent.mm.plugin.fts.a.a.h hVar) {
        boolean z;
        boolean z2;
        boolean z3;
        String substring;
        boolean z4;
        boolean z5;
        boolean z6;
        String str;
        String string;
        String str2;
        String str3;
        String str4;
        AppMethodBeat.i(77971);
        as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(mVar.wVX);
        String arL = com.tencent.mm.plugin.fts.a.d.arL(mVar.wVX);
        switch (mVar.wVW) {
            case 1:
                z3 = false;
                z2 = false;
                z4 = z3;
                z5 = false;
                z6 = true;
                str = null;
                string = null;
                break;
            case 2:
                z3 = false;
                z2 = true;
                z4 = z3;
                z5 = false;
                z6 = true;
                str = null;
                string = null;
                break;
            case 3:
                z3 = true;
                z2 = true;
                z4 = z3;
                z5 = false;
                z6 = true;
                str = null;
                string = null;
                break;
            case 4:
                z4 = false;
                z2 = false;
                z5 = true;
                z6 = false;
                str = Kn.fuR;
                string = MMApplicationContext.getContext().getString(R.string.gfz);
                break;
            case 5:
                z = false;
                z2 = false;
                str = Kn.field_nickname;
                z4 = z;
                z5 = true;
                z6 = false;
                string = MMApplicationContext.getContext().getString(R.string.gg4);
                break;
            case 6:
                z = false;
                z2 = true;
                str = Kn.field_nickname;
                z4 = z;
                z5 = true;
                z6 = false;
                string = MMApplicationContext.getContext().getString(R.string.gg4);
                break;
            case 7:
                z = true;
                z2 = true;
                str = Kn.field_nickname;
                z4 = z;
                z5 = true;
                z6 = false;
                string = MMApplicationContext.getContext().getString(R.string.gg4);
                break;
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
            case 14:
            default:
                z4 = false;
                z2 = false;
                z5 = false;
                z6 = false;
                str = null;
                string = null;
                break;
            case 11:
                List<String> aym = ((n) com.tencent.mm.kernel.g.ah(n.class)).getFTSMainDB().aym(Kn.field_contactLabelIds);
                StringBuffer stringBuffer = new StringBuffer();
                String[] strArr = hVar.wWD;
                for (String str5 : strArr) {
                    for (String str6 : aym) {
                        if (com.tencent.mm.plugin.fts.a.d.ayq(str6).contains(str5)) {
                            stringBuffer.append(str6);
                            stringBuffer.append(",");
                        }
                    }
                }
                stringBuffer.trimToSize();
                if (stringBuffer.length() == 0) {
                    substring = "";
                } else {
                    substring = stringBuffer.substring(0, stringBuffer.length() - 1);
                }
                z4 = false;
                z2 = false;
                z5 = true;
                z6 = false;
                str = substring;
                string = MMApplicationContext.getContext().getString(R.string.gg8);
                break;
            case 15:
                String ajx = Kn.ajx();
                if (Util.isNullOrNil(ajx)) {
                    ajx = Kn.field_username;
                }
                z4 = false;
                z2 = false;
                z5 = true;
                z6 = false;
                str = ajx;
                string = MMApplicationContext.getContext().getString(R.string.gg9);
                break;
            case 16:
                String str7 = mVar.content;
                if (!Util.isNullOrNil(str7)) {
                    String[] split = str7.split(RecoveryFileLog.SPLITTER);
                    int length = split.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length) {
                            str2 = split[i2];
                            if (!str2.startsWith(hVar.wWB)) {
                                i2++;
                            }
                        }
                    }
                }
                str2 = str7;
                z4 = false;
                z2 = false;
                z5 = true;
                z6 = false;
                str = str2;
                string = MMApplicationContext.getContext().getString(R.string.gg3);
                break;
            case 17:
                z4 = false;
                z2 = false;
                z5 = true;
                z6 = false;
                str = mVar.content;
                string = MMApplicationContext.getContext().getString(R.string.gfy);
                break;
            case 18:
                z4 = false;
                z2 = false;
                z5 = true;
                z6 = false;
                str = mVar.content;
                string = MMApplicationContext.getContext().getString(R.string.gg5);
                break;
        }
        if (z6) {
            com.tencent.mm.plugin.fts.a.a.e a2 = com.tencent.mm.plugin.fts.a.a.e.a(arL, hVar, z2, z4);
            a2.wWg = e.a.CustomTag;
            a2.wWl = "<em class=\"highlight\">";
            a2.wWm = "</em>";
            str3 = f.a(a2).wWu.toString();
        } else {
            str3 = arL;
        }
        if (z5) {
            com.tencent.mm.plugin.fts.a.a.e a3 = com.tencent.mm.plugin.fts.a.a.e.a(str, hVar, z2, z4);
            a3.wWg = e.a.CustomTag;
            a3.wWl = "<em class=\"highlight\">";
            a3.wWm = "</em>";
            str4 = string + f.a(a3).wWu.toString();
        } else {
            str4 = str;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("nickName", com.tencent.mm.plugin.fts.a.d.arL(mVar.wVX));
            jSONObject.put("userName", mVar.wVX);
            if (z6) {
                jSONObject.put("nickNameHighlight", str3);
            }
            if (z5) {
                jSONObject.put("extraHighlight", str4);
            }
        } catch (JSONException e2) {
        }
        AppMethodBeat.o(77971);
        return jSONObject;
    }

    static /* synthetic */ boolean aE(String str, int i2, int i3) {
        int fYc;
        AppMethodBeat.i(210852);
        if (!TextUtils.isEmpty(str) && ai.fYb() && (((fYc = ai.fYc()) <= 0 || str.length() <= fYc) && (i2 != 3 || i3 == 8))) {
            if ((i2 == 3 || i2 == 20) && i3 == 8) {
                AppMethodBeat.o(210852);
                return true;
            } else if ((i2 == 14 || i2 == 22) && i3 == 8) {
                AppMethodBeat.o(210852);
                return true;
            } else if (i2 == 16) {
                AppMethodBeat.o(210852);
                return true;
            }
        }
        AppMethodBeat.o(210852);
        return false;
    }
}
