package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ra;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.pluginsdk.j.a.a.b;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.ctz;
import com.tencent.mm.protocal.protobuf.egk;
import com.tencent.mm.protocal.protobuf.eou;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.d;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class i implements com.tencent.mm.ak.i {
    private static final long IOO = ((long) (d.gGT() + 500));
    private static i IOX = new i();
    private MMHandler IOP = new MMHandler("RecommendLogic_worker");
    private Set<String> IOQ;
    public a IOR = new a(this, (byte) 0);
    private volatile boolean IOT;
    private volatile boolean IOU;
    private volatile CountDownLatch IOV;
    private volatile v IOW;
    private volatile boolean IOY;
    public IListener IOZ = new IListener<ra>() {
        /* class com.tencent.mm.plugin.webview.fts.i.AnonymousClass1 */

        {
            AppMethodBeat.i(160415);
            this.__eventId = ra.class.getName().hashCode();
            AppMethodBeat.o(160415);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ra raVar) {
            AppMethodBeat.i(77937);
            i.this.gaA();
            AppMethodBeat.o(77937);
            return false;
        }
    };

    static {
        AppMethodBeat.i(77950);
        AppMethodBeat.o(77950);
    }

    public i() {
        AppMethodBeat.i(77941);
        Log.d("MicroMsg.TopStory.RecommendLogic", "create RecommendLogic");
        Log.d("MicroMsg.TopStory.RecommendLogic", "create RecommendLogic, duplicate for patch fix");
        this.IOZ.alive();
        this.IOQ = new HashSet();
        this.IOQ.add(DownloadInfo.NETTYPE);
        this.IOQ.add("time_zone_min");
        this.IOQ.add("currentPage");
        this.IOQ.add("is_prefetch");
        this.IOQ.add(TencentLocation.EXTRA_DIRECTION);
        this.IOQ.add("seq");
        this.IOQ.add("client_exposed_info");
        this.IOQ.add("requestId");
        this.IOQ.add("recType");
        this.IOQ.add("redPointMsgId");
        gaA();
        AppMethodBeat.o(77941);
    }

    public static i gaz() {
        return IOX;
    }

    private boolean w(Set<String> set) {
        AppMethodBeat.i(77942);
        if (set == null || this.IOQ.containsAll(set)) {
            AppMethodBeat.o(77942);
            return true;
        }
        AppMethodBeat.o(77942);
        return false;
    }

    public final boolean bC(Map<String, Object> map) {
        boolean z;
        AppMethodBeat.i(77943);
        Log.i("MicroMsg.TopStory.RecommendLogic", "getSearchData: %s", map.toString());
        g.ahd(Util.nullAsInt(map.get("webview_instance_id"), -1)).d(ai.b(map, "type", 0), ai.N(map, SearchIntents.EXTRA_QUERY), map);
        if (this.IOT) {
            this.IOT = false;
            int nullAsInt = Util.nullAsInt(map.get("webview_instance_id"), -1);
            if (this.IOW != null) {
                this.IOW.dVL = nullAsInt;
            }
            if (!w(bD(map))) {
                Log.e("MicroMsg.TopStory.RecommendLogic", "wtf , recv unsupported commKvSet after pre get, interrupt pre get now");
                this.IOU = true;
                if (this.IOV != null) {
                    this.IOV.countDown();
                }
                z = false;
            } else {
                if (this.IOV != null) {
                    this.IOV.countDown();
                }
                if (this.IOW != null) {
                    Log.i("MicroMsg.TopStory.RecommendLogic", "do not send this call, wait for pre get, webivewId %d, %s", Integer.valueOf(this.IOW.dVL), this.IOW);
                }
                z = true;
            }
        } else {
            if (this.IOV != null) {
                this.IOV.countDown();
            }
            z = false;
        }
        if (z) {
            AppMethodBeat.o(77943);
        } else {
            v bE = bE(map);
            a aVar = this.IOR;
            if (aVar.IPf != null) {
                aVar.IPf.stopped = true;
            }
            aVar.IPf = new a.RunnableC1955a(aVar, (byte) 0);
            aVar.IPf.IDt = bE;
            i.this.IOW = bE;
            aVar.IPf.run();
            AppMethodBeat.o(77943);
        }
        return false;
    }

    private static Set<String> bD(Map<String, Object> map) {
        Set<String> emptySet;
        Exception e2;
        AppMethodBeat.i(77944);
        String N = ai.N(map, "extReqParams");
        if (!Util.isNullOrNil(N)) {
            try {
                emptySet = new HashSet<>();
                try {
                    JSONArray jSONArray = new JSONArray(N);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        new aca();
                        emptySet.add(jSONObject.optString("key", ""));
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    Log.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", e2, "", new Object[0]);
                    AppMethodBeat.o(77944);
                    return emptySet;
                }
            } catch (Exception e4) {
                e2 = e4;
                emptySet = null;
                Log.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", e2, "", new Object[0]);
                AppMethodBeat.o(77944);
                return emptySet;
            }
        } else {
            emptySet = Collections.emptySet();
        }
        AppMethodBeat.o(77944);
        return emptySet;
    }

    private static v bE(Map<String, Object> map) {
        AppMethodBeat.i(77945);
        v vVar = new v();
        vVar.dDv = ai.N(map, SearchIntents.EXTRA_QUERY);
        vVar.offset = ai.b(map, "offset", 0);
        vVar.businessType = ai.b(map, "type", 0);
        vVar.scene = ai.b(map, "scene", 0);
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
        String N = ai.N(map, "extReqParams");
        if (!Util.isNullOrNil(N)) {
            try {
                JSONArray jSONArray = new JSONArray(N);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    aca aca = new aca();
                    aca.key = jSONObject.optString("key", "");
                    aca.LmC = (long) jSONObject.optInt("uintValue", 0);
                    aca.LmD = jSONObject.optString("textValue", "");
                    vVar.IDO.add(aca);
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", e2, "commKvJSONArray", new Object[0]);
            }
        }
        String N2 = ai.N(map, "matchUser");
        if (!Util.isNullOrNil(N2)) {
            try {
                JSONObject jSONObject2 = new JSONObject(N2);
                eou eou = new eou();
                eou.UserName = jSONObject2.optString("userName");
                eou.NmU = jSONObject2.optString("matchWord");
                if (!TextUtils.isEmpty(eou.UserName)) {
                    vVar.IDF.add(eou);
                }
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", e3, "matchUserJSONArray", new Object[0]);
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
                Log.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", e4, "prefixQueryJSONArray", new Object[0]);
            }
        }
        String N4 = ai.N(map, "tagInfo");
        if (!Util.isNullOrNil(N4)) {
            try {
                JSONObject jSONObject3 = new JSONObject(N4);
                vVar.IDN = new egk();
                vVar.IDN.Ngs = jSONObject3.optString("tagText");
                vVar.IDN.Ngr = jSONObject3.optInt("tagType");
                vVar.IDN.Ngt = jSONObject3.optString("tagExtValue");
            } catch (Exception e5) {
                Log.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", e5, "tagInfoObj", new Object[0]);
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
                Log.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", e6, "numConditionsArray", new Object[0]);
            }
        }
        vVar.dVL = Util.nullAsInt(map.get("webview_instance_id"), -1);
        vVar.language = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
        vVar.wVW = ai.b(map, "subType", 0);
        vVar.channelId = ai.b(map, "channelId", 0);
        vVar.IDW = ai.N(map, "navigationId");
        AppMethodBeat.o(77945);
        return vVar;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(77946);
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = str;
        objArr[3] = Integer.valueOf(qVar != null ? qVar.getType() : 0);
        Log.v("MicroMsg.TopStory.RecommendLogic", "onSceneEnd(type : %s), errType : %s, errCode : %s, errMsg : %s", objArr);
        if (qVar instanceof com.tencent.mm.plugin.websearch.api.a) {
            com.tencent.mm.kernel.g.azz().b(qVar.getType(), this);
            com.tencent.mm.plugin.websearch.api.a aVar = (com.tencent.mm.plugin.websearch.api.a) qVar;
            if (i2 == 0 && i3 == 0) {
                String fXC = aVar.fXC();
                int fXD = aVar.fXD();
                Log.i("MicroMsg.TopStory.RecommendLogic", "callback %s", aVar.getKeyword());
                a(aVar.fXz(), fXC, aVar.fXA(), aVar.fXE());
                if (fXD > 0) {
                    Log.i("MicroMsg.TopStory.RecommendLogic", "updateCode %d, need update", Integer.valueOf(fXD));
                    b.gnC();
                    b.ahP(27);
                }
            } else {
                Log.i("MicroMsg.TopStory.RecommendLogic", "net scene fail %s", aVar.getKeyword());
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ret", -1);
                } catch (JSONException e2) {
                }
                a(aVar.fXz(), jSONObject.toString(), aVar.fXA(), aVar.fXE());
                AppMethodBeat.o(77946);
                return;
            }
        }
        AppMethodBeat.o(77946);
    }

    private void a(final int i2, final String str, final boolean z, final String str2) {
        AppMethodBeat.i(77947);
        this.IOP.postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.webview.fts.i.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(77938);
                if (i.this.IOV != null) {
                    Log.i("MicroMsg.TopStory.RecommendLogic", "waiting for countdown, %d", Long.valueOf(i.this.IOV.getCount()));
                    try {
                        i.this.IOV.await();
                    } catch (InterruptedException e2) {
                        Log.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", e2, "", new Object[0]);
                    }
                } else {
                    Log.i("MicroMsg.TopStory.RecommendLogic", "count down latch null");
                }
                int i2 = i2;
                if (i.this.IOW != null) {
                    i2 = i.this.IOW.dVL;
                    if (i.this.IOW.IDV && i.this.IOU) {
                        Log.w("MicroMsg.TopStory.RecommendLogic", "ingore pre get data");
                        AppMethodBeat.o(77938);
                        return;
                    }
                }
                Log.i("MicroMsg.TopStory.RecommendLogic", "calling back to webview, id %d, reqId %s,  %s", Integer.valueOf(i2), str2, i.this.IOW);
                g.ahd(i2).a(str, z, str2, (Bundle) null);
                AppMethodBeat.o(77938);
            }
        });
        AppMethodBeat.o(77947);
    }

    public static void start() {
        AppMethodBeat.i(77948);
        try {
            Looper.prepare();
            AppMethodBeat.o(77948);
        } catch (Exception e2) {
            AppMethodBeat.o(77948);
        }
    }

    public class a implements Comparable {
        public com.tencent.mm.plugin.websearch.api.a IPe;
        public RunnableC1955a IPf;

        private a() {
        }

        /* synthetic */ a(i iVar, byte b2) {
            this();
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            return 0;
        }

        /* renamed from: com.tencent.mm.plugin.webview.fts.i$a$a  reason: collision with other inner class name */
        public class RunnableC1955a implements Runnable {
            v IDt;
            public volatile boolean stopped;

            private RunnableC1955a() {
            }

            /* synthetic */ RunnableC1955a(a aVar, byte b2) {
                this();
            }

            public final void run() {
                AppMethodBeat.i(77939);
                if (Thread.interrupted()) {
                    AppMethodBeat.o(77939);
                } else if (Util.isNullOrNil(this.IDt.dDv)) {
                    Log.i("MicroMsg.TopStory.RecommendLogic", "error query %d %d %d %d %s %d", Integer.valueOf(this.IDt.businessType), Integer.valueOf(this.IDt.scene), Integer.valueOf(this.IDt.IDE), Integer.valueOf(this.IDt.dVS), this.IDt.rjq, Integer.valueOf(this.IDt.offset));
                    AppMethodBeat.o(77939);
                } else {
                    Log.i("MicroMsg.TopStory.RecommendLogic", "start New NetScene %s ,  %d", this.IDt.dDv, Integer.valueOf(this.IDt.dVL));
                    if (a.this.IPe != null) {
                        com.tencent.mm.kernel.g.azz().a(a.this.IPe);
                    }
                    if (this.stopped) {
                        Log.i("MicroMsg.TopStory.RecommendLogic", "was cancelled");
                        AppMethodBeat.o(77939);
                        return;
                    }
                    com.tencent.mm.plugin.webview.modeltools.g.gds().IOd.v(this.IDt.scene, this.IDt.dDv, this.IDt.businessType);
                    a.this.IPe = a.a(this.IDt);
                    com.tencent.mm.kernel.g.azz().a(a.this.IPe.getType(), i.this);
                    com.tencent.mm.kernel.g.azz().a(a.this.IPe, 0);
                    Log.i("MicroMsg.TopStory.RecommendLogic", "doScene(type : %s)", Integer.valueOf(a.this.IPe.getType()));
                    AppMethodBeat.o(77939);
                }
            }
        }

        static /* synthetic */ com.tencent.mm.plugin.websearch.api.a a(v vVar) {
            com.tencent.mm.plugin.websearch.api.a fVar;
            AppMethodBeat.i(77940);
            if (i.afP(vVar.scene)) {
                fVar = new z(vVar);
            } else {
                fVar = new f(vVar);
            }
            fVar.afo(vVar.dVL);
            AppMethodBeat.o(77940);
            return fVar;
        }
    }

    public final void gaA() {
        AppMethodBeat.i(77949);
        String fXW = ai.fXW();
        Log.i("MicroMsg.TopStory.RecommendLogic", "config commKV %s", fXW);
        if (TextUtils.isEmpty(fXW)) {
            this.IOY = true;
            AppMethodBeat.o(77949);
            return;
        }
        this.IOY = w(new HashSet(Arrays.asList(fXW.split(","))));
        AppMethodBeat.o(77949);
    }

    static /* synthetic */ boolean afP(int i2) {
        return i2 == 21;
    }
}
