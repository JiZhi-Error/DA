package com.tencent.mm.plugin.webview.fts;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.a.gr;
import com.tencent.mm.g.a.vr;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.vfs.s;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements MStorage.IOnStorageChange {
    public IListener DFm = new IListener<vr>() {
        /* class com.tencent.mm.plugin.webview.fts.b.AnonymousClass2 */

        {
            AppMethodBeat.i(160413);
            this.__eventId = vr.class.getName().hashCode();
            AppMethodBeat.o(160413);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(vr vrVar) {
            AppMethodBeat.i(77879);
            boolean a2 = a(vrVar);
            AppMethodBeat.o(77879);
            return a2;
        }

        private boolean a(vr vrVar) {
            AppMethodBeat.i(77878);
            if ((vrVar instanceof vr) && vrVar.ebQ.dDe == 2) {
                Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "Download callback %s", vrVar.ebQ.mediaId);
                if (b.this.INR.containsKey(vrVar.ebQ.mediaId)) {
                    synchronized (b.this.INR) {
                        try {
                            int intValue = ((Integer) b.this.INU.get(vrVar.ebQ.mediaId)).intValue();
                            JSONArray jSONArray = new JSONArray();
                            Iterator it = ((HashSet) b.this.INR.get(vrVar.ebQ.mediaId)).iterator();
                            while (it.hasNext()) {
                                String str = (String) it.next();
                                String str2 = "weixin://fts/sns?path=" + s.k(vrVar.ebQ.path, false);
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("id", str);
                                    jSONObject.put("src", str2);
                                } catch (JSONException e2) {
                                }
                                jSONArray.put(jSONObject);
                            }
                            g.ahd(intValue).cQ(0, jSONArray.toString());
                            b.this.INR.remove(vrVar.ebQ.mediaId);
                            b.this.INU.remove(vrVar.ebQ.mediaId);
                        } finally {
                            AppMethodBeat.o(77878);
                        }
                    }
                }
            }
            return false;
        }
    };
    private volatile HashMap<String, HashSet<String>> IHg = new HashMap<>();
    private volatile HashMap<String, HashSet<String>> IHh = new HashMap<>();
    private volatile HashMap<String, HashSet<String>> INR = new HashMap<>();
    private volatile HashMap<String, Integer> INS = new HashMap<>();
    private volatile HashMap<String, Integer> INU = new HashMap<>();
    private volatile HashMap<String, Integer> INV = new HashMap<>();
    public IListener<gr> INW = new IListener<gr>() {
        /* class com.tencent.mm.plugin.webview.fts.b.AnonymousClass1 */

        {
            AppMethodBeat.i(160412);
            this.__eventId = gr.class.getName().hashCode();
            AppMethodBeat.o(160412);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(gr grVar) {
            AppMethodBeat.i(77877);
            boolean a2 = a(grVar);
            AppMethodBeat.o(77877);
            return a2;
        }

        private boolean a(gr grVar) {
            AppMethodBeat.i(77876);
            if (grVar.dKH.dDe == 2) {
                Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "Emoji Download callback %s", grVar.dKH.md5);
                if (b.this.IHg.containsKey(grVar.dKH.md5)) {
                    synchronized (b.this.IHg) {
                        try {
                            int intValue = ((Integer) b.this.INV.get(grVar.dKH.md5)).intValue();
                            JSONArray jSONArray = new JSONArray();
                            Iterator it = ((HashSet) b.this.IHg.get(grVar.dKH.md5)).iterator();
                            while (it.hasNext()) {
                                String str = (String) it.next();
                                String str2 = "weixin://fts/emoji?path=" + grVar.dKI.path;
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("id", str);
                                    jSONObject.put("src", str2);
                                } catch (JSONException e2) {
                                }
                                jSONArray.put(jSONObject);
                            }
                            g.ahd(intValue).cQ(0, jSONArray.toString());
                            b.this.IHg.remove(grVar.dKH.md5);
                            b.this.INV.remove(grVar.dKH.md5);
                        } finally {
                            AppMethodBeat.o(77876);
                        }
                    }
                }
            }
            return false;
        }
    };

    public b() {
        AppMethodBeat.i(77880);
        this.DFm.alive();
        this.INW.alive();
        p.aYB().add(this);
        AppMethodBeat.o(77880);
    }

    public final boolean bl(Map<String, Object> map) {
        AppMethodBeat.i(77881);
        Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "getSearchAvatarList");
        String N = ai.N(map, "data");
        int nullAsInt = Util.nullAsInt(map.get("webview_instance_id"), -1);
        try {
            JSONArray jSONArray = new JSONArray(N);
            JSONArray jSONArray2 = new JSONArray();
            String str = null;
            int i2 = 0;
            while (i2 < jSONArray.length()) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                String optString = jSONObject.optString("id");
                String optString2 = jSONObject.optString("userName");
                int optInt = jSONObject.optInt("type");
                String optString3 = jSONObject.optString("imageUrl");
                String optString4 = jSONObject.optString("bigImageUrl");
                switch (optInt) {
                    case 1:
                    case 4:
                    case 64:
                        break;
                    case 32:
                        i iVar = new i();
                        iVar.username = optString2;
                        iVar.iKX = optString4;
                        iVar.iKW = optString3;
                        iVar.cSx = -1;
                        iVar.fuz = 3;
                        iVar.fv(true);
                        p.aYB().b(iVar);
                    default:
                        p.aYn();
                        String M = e.M(optString2, false);
                        if (!s.YS(M)) {
                            Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "avatar file not exist %s", M);
                            this.INS.put(optString2, Integer.valueOf(nullAsInt));
                            HashSet<String> hashSet = this.IHh.get(optString2);
                            if (hashSet == null) {
                                hashSet = new HashSet<>();
                            }
                            hashSet.add(optString);
                            this.IHh.put(optString2, hashSet);
                            a.b.gov().fZ(optString2);
                            optString3 = str;
                            break;
                        } else {
                            Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "avatar file exist %s", M);
                            optString3 = "weixin://fts/avatar?path=".concat(String.valueOf(M));
                            break;
                        }
                }
                if (optString3 != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", optString);
                    jSONObject2.put("src", optString3);
                    jSONArray2.put(jSONObject2);
                    optString3 = null;
                }
                i2++;
                str = optString3;
            }
            if (jSONArray2.length() > 0) {
                g.ahd(nullAsInt).cQ(0, jSONArray2.toString());
            }
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.WebSearch.FTSWebViewImageLogic", e2, "", new Object[0]);
            g.ahd(nullAsInt).cQ(-1, "");
        }
        AppMethodBeat.o(77881);
        return false;
    }

    public final boolean bm(Map<String, Object> map) {
        String str;
        HashSet<String> hashSet;
        AppMethodBeat.i(77882);
        Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "getSearchSnsImageList");
        String N = ai.N(map, "data");
        int nullAsInt = Util.nullAsInt(map.get("webview_instance_id"), -1);
        try {
            JSONArray jSONArray = new JSONArray(N);
            JSONArray jSONArray2 = new JSONArray();
            String str2 = null;
            int i2 = 0;
            while (i2 < jSONArray.length()) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                String string = jSONObject.getString("id");
                String string2 = jSONObject.getString("objectXmlDesc");
                int i3 = jSONObject.getInt(FirebaseAnalytics.b.INDEX);
                TimeLineObject PM = ((n) com.tencent.mm.kernel.g.af(n.class)).PM(string2);
                if (PM.ContentObj.LoV.size() > i3) {
                    cnb cnb = PM.ContentObj.LoV.get(i3);
                    vr vrVar = new vr();
                    vrVar.ebQ.dDe = 3;
                    vrVar.ebQ.mediaId = cnb.Id;
                    EventCenter.instance.publish(vrVar);
                    Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "generatePath: %s", vrVar.ebQ.path);
                    if (s.YS(vrVar.ebQ.path)) {
                        str = "weixin://fts/sns?path=" + s.k(vrVar.ebQ.path, false);
                    } else {
                        synchronized (this.INR) {
                            try {
                                if (this.INR.containsKey(cnb.Id)) {
                                    hashSet = this.INR.get(cnb.Id);
                                } else {
                                    hashSet = new HashSet<>();
                                }
                                hashSet.add(string);
                                this.INR.put(cnb.Id, hashSet);
                                this.INU.put(cnb.Id, Integer.valueOf(nullAsInt));
                            } catch (Throwable th) {
                                AppMethodBeat.o(77882);
                                throw th;
                            }
                        }
                        vr vrVar2 = new vr();
                        vrVar2.ebQ.dDe = 1;
                        vrVar2.ebQ.ebR = cnb;
                        EventCenter.instance.publish(vrVar2);
                        str = str2;
                    }
                    if (str != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("id", string);
                        jSONObject2.put("src", str);
                        jSONArray2.put(jSONObject2);
                        str = null;
                    }
                } else {
                    str = str2;
                }
                i2++;
                str2 = str;
            }
            if (jSONArray2.length() > 0) {
                g.ahd(nullAsInt).cQ(0, jSONArray2.toString());
            }
        } catch (JSONException e2) {
        }
        AppMethodBeat.o(77882);
        return false;
    }

    public final boolean bn(Map<String, Object> map) {
        String str;
        HashSet<String> hashSet;
        AppMethodBeat.i(77883);
        Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "getSearchImageList");
        int b2 = ai.b(map, "requestType", 0);
        String N = ai.N(map, "data");
        int nullAsInt = Util.nullAsInt(map.get("webview_instance_id"), -1);
        boolean isWifi = NetStatusUtil.isWifi(MMApplicationContext.getContext());
        switch (b2) {
            case 1:
                try {
                    JSONArray jSONArray = new JSONArray(N);
                    JSONArray jSONArray2 = new JSONArray();
                    String str2 = null;
                    int i2 = 0;
                    while (i2 < jSONArray.length()) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        int optInt = jSONObject.optInt("emojiType");
                        String optString = jSONObject.optString("id");
                        if (optInt == 2) {
                            gr grVar = new gr();
                            grVar.dKH.dDe = 3;
                            grVar.dKH.md5 = jSONObject.optString("md5");
                            grVar.dKH.dKJ = jSONObject.optString("designerId");
                            grVar.dKH.aeskey = jSONObject.optString("aesKey");
                            grVar.dKH.dKK = jSONObject.optString("encryptUrl");
                            grVar.dKH.productId = jSONObject.optString("productID");
                            grVar.dKH.name = jSONObject.optString("express");
                            grVar.dKH.thumbUrl = jSONObject.optString("imageUrl");
                            EventCenter.instance.publish(grVar);
                            if (s.YS(grVar.dKI.path)) {
                                str = "weixin://fts/emoji?path=" + grVar.dKI.path;
                                Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "path=%s", grVar.dKI.path);
                            } else if (isWifi) {
                                synchronized (this.IHg) {
                                    try {
                                        if (this.IHg.containsKey(grVar.dKH.md5)) {
                                            hashSet = this.IHg.get(grVar.dKH.md5);
                                        } else {
                                            hashSet = new HashSet<>();
                                        }
                                        hashSet.add(optString);
                                        this.IHg.put(grVar.dKH.md5, hashSet);
                                        this.INV.put(grVar.dKH.md5, Integer.valueOf(nullAsInt));
                                    } catch (Throwable th) {
                                        AppMethodBeat.o(77883);
                                        throw th;
                                    }
                                }
                                grVar.dKH.dDe = 1;
                                EventCenter.instance.publish(grVar);
                                str = str2;
                            } else {
                                str = jSONObject.optString("imageUrl");
                            }
                            if (str != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("id", optString);
                                jSONObject2.put("src", str);
                                jSONArray2.put(jSONObject2);
                                str = null;
                            }
                        } else if (optInt == 4) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("id", optString);
                            if (isWifi) {
                                jSONObject3.put("src", jSONObject.optString(ShareConstants.DEXMODE_RAW));
                            } else {
                                jSONObject3.put("src", jSONObject.optString("imageUrl"));
                            }
                            jSONArray2.put(jSONObject3);
                            str = str2;
                        } else {
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("id", optString);
                            jSONObject4.put("src", jSONObject.optString("imageUrl"));
                            jSONArray2.put(jSONObject4);
                            str = str2;
                        }
                        i2++;
                        str2 = str;
                    }
                    if (jSONArray2.length() > 0) {
                        g.ahd(nullAsInt).cQ(0, jSONArray2.toString());
                        break;
                    }
                } catch (Exception e2) {
                    break;
                }
                break;
            default:
                try {
                    JSONArray jSONArray3 = new JSONArray(N);
                    JSONArray jSONArray4 = new JSONArray();
                    for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                        JSONObject jSONObject5 = jSONArray3.getJSONObject(i3);
                        JSONObject jSONObject6 = new JSONObject();
                        String string = jSONObject5.getString("id");
                        String string2 = jSONObject5.getString("imageUrl");
                        jSONObject6.put("id", string);
                        jSONObject6.put("src", string2);
                        jSONArray4.put(jSONObject6);
                    }
                    g.ahd(nullAsInt).cQ(0, jSONArray4.toString());
                    break;
                } catch (JSONException e3) {
                    break;
                }
        }
        AppMethodBeat.o(77883);
        return false;
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(77884);
        if (mStorageEventData == null || mStorageEventData.obj == null) {
            AppMethodBeat.o(77884);
            return;
        }
        synchronized (this.IHh) {
            try {
                Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "event %s，eventData %s", str, mStorageEventData.toString());
                String obj = mStorageEventData.obj.toString();
                if (this.IHh.containsKey(obj) && this.INS.containsKey(obj)) {
                    Log.i("MicroMsg.WebSearch.FTSWebViewImageLogic", "notify avatar changed %s", obj);
                    int intValue = this.INS.get(obj).intValue();
                    HashSet hashSet = new HashSet(this.IHh.get(obj));
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        p.aYn();
                        String concat = "weixin://fts/avatar?path=".concat(String.valueOf(e.M(obj, false)));
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str2);
                            jSONObject.put("src", concat);
                        } catch (JSONException e2) {
                        }
                        jSONArray.put(jSONObject);
                    }
                    g.ahd(intValue).cQ(0, jSONArray.toString());
                    this.IHh.remove(obj);
                    this.INS.remove(obj);
                }
            } finally {
                AppMethodBeat.o(77884);
            }
        }
    }
}
