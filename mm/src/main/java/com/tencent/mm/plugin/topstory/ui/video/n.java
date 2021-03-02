package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.facebook.appevents.UserDataStore;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.d;
import com.tencent.mm.network.x;
import com.tencent.mm.plugin.appbrand.jsapi.storage.m;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.topstory.a.b.c;
import com.tencent.mm.plugin.topstory.a.c.e;
import com.tencent.mm.plugin.topstory.a.c.h;
import com.tencent.mm.plugin.topstory.a.c.k;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.any;
import com.tencent.mm.protocal.protobuf.dky;
import com.tencent.mm.protocal.protobuf.dyi;
import com.tencent.mm.protocal.protobuf.eio;
import com.tencent.mm.protocal.protobuf.eip;
import com.tencent.mm.protocal.protobuf.eir;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eiu;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.protocal.protobuf.eiy;
import com.tencent.mm.protocal.protobuf.eoj;
import com.tencent.mm.protocal.protobuf.era;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.wxmm.v2helper;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class n {
    public boolean GhN;
    public b GlS;
    public int GnE;
    k GnF;
    private int GnG;
    private int GnH;
    public h GnI;
    public i gNh = new i() {
        /* class com.tencent.mm.plugin.topstory.ui.video.n.AnonymousClass2 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            boolean z = true;
            AppMethodBeat.i(126123);
            Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "onSceneEnd, errType: %s, errCode: %s, scene: %s", Integer.valueOf(i2), Integer.valueOf(i3), qVar);
            if (qVar.equals(n.this.GnF)) {
                g.azz().b(1943, n.this.gNh);
                n.this.GnF = null;
                k kVar = (k) qVar;
                if (i2 == 0 && i3 == 0) {
                    a aVar = new a(n.this, (byte) 0);
                    aVar.sTh = kVar.fxZ().MaZ;
                    if (kVar.GjJ.offset != 0) {
                        z = false;
                    }
                    aVar.xwi = z;
                    com.tencent.f.h.RTc.b(aVar, "TopStory.DecodeRecommendResultTask");
                    AppMethodBeat.o(126123);
                    return;
                }
                Log.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "fetch page failed!, response json: %s", kVar.fxZ().MaZ);
                com.tencent.mm.plugin.websearch.api.a.a.pl(2);
                n.this.GlS.aTE(str);
                n.this.GhN = false;
                AppMethodBeat.o(126123);
                return;
            }
            if (qVar.equals(n.this.GnI)) {
                g.azz().b(1943, n.this.gNh);
                n.this.GnI = null;
                final h hVar = (h) qVar;
                if (i2 == 0 && i3 == 0) {
                    Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "onSceneEnd relevantVideoNetScene %s", hVar.fxZ().MaZ);
                    com.tencent.f.h.RTc.b(new Runnable() {
                        /* class com.tencent.mm.plugin.topstory.ui.video.n.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(126122);
                            try {
                                JSONArray optJSONArray = new JSONObject(hVar.fxZ().MaZ).optJSONArray("data");
                                if (optJSONArray != null && optJSONArray.length() > 0) {
                                    List b2 = n.b(n.this.GlS.fyL(), optJSONArray);
                                    hVar.GjK.Niz.NhV.addAll(b2);
                                    Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "netSceneTopStoryRelevantVideo add result list %d", Integer.valueOf(b2.size()));
                                }
                                AppMethodBeat.o(126122);
                            } catch (Exception e2) {
                                AppMethodBeat.o(126122);
                            }
                        }
                    }, "TopStory.DecodeRelevantResult");
                } else {
                    Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "requestRelVideo failed!, errType:%s, errCode:%s", Integer.valueOf(i2), Integer.valueOf(i3));
                    com.tencent.mm.plugin.websearch.api.a.a.pl(2);
                    AppMethodBeat.o(126123);
                    return;
                }
            }
            AppMethodBeat.o(126123);
        }
    };

    static /* synthetic */ List b(boolean z, JSONArray jSONArray) {
        AppMethodBeat.i(126148);
        List<eiw> a2 = a(z, jSONArray);
        AppMethodBeat.o(126148);
        return a2;
    }

    static /* synthetic */ void b(eiw eiw, String str, String str2) {
        AppMethodBeat.i(126147);
        a(eiw, str, str2);
        AppMethodBeat.o(126147);
    }

    public n() {
        AppMethodBeat.i(126125);
        AppMethodBeat.o(126125);
    }

    public final List<eiw> GW() {
        AppMethodBeat.i(126126);
        LinkedList<eiw> linkedList = this.GlS.fyD().Nif;
        AppMethodBeat.o(126126);
        return linkedList;
    }

    public final int fzy() {
        AppMethodBeat.i(126127);
        int size = GW().size();
        AppMethodBeat.o(126127);
        return size;
    }

    public final void h(eiw eiw) {
        AppMethodBeat.i(126128);
        synchronized (this) {
            try {
                GW().add(eiw);
            } finally {
                AppMethodBeat.o(126128);
            }
        }
    }

    public final void acc(int i2) {
        AppMethodBeat.i(126129);
        synchronized (this) {
            if (i2 >= 0) {
                try {
                    if (i2 < GW().size()) {
                        GW().remove(i2);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(126129);
                    throw th;
                }
            }
        }
        AppMethodBeat.o(126129);
    }

    public final eiw acd(int i2) {
        eiw eiw;
        AppMethodBeat.i(126130);
        synchronized (this) {
            if (i2 >= 0) {
                try {
                    if (i2 < GW().size()) {
                        eiw = GW().get(i2);
                    }
                } finally {
                    AppMethodBeat.o(126130);
                }
            }
            eiw = null;
            AppMethodBeat.o(126130);
        }
        return eiw;
    }

    public final boolean ace(int i2) {
        boolean z;
        String str;
        AppMethodBeat.i(126131);
        if (this.GhN) {
            Log.w("MicroMsg.TopStory.TopStoryVideoDataMgr", "RequestingData");
            AppMethodBeat.o(126131);
            return false;
        }
        Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "requestData: %s", Integer.valueOf(i2));
        this.GhN = true;
        eit a2 = com.tencent.mm.plugin.topstory.a.h.a(this.GlS.fyD());
        a2.offset = i2;
        if (!Util.isNullOrNil(this.GlS.fyD().NhX)) {
            aca aca = new aca();
            aca.key = "relevant_vid";
            aca.LmD = this.GlS.fyD().NhX;
            a2.IDO.add(aca);
        }
        if (!Util.isNullOrNil(this.GlS.fyD().NhY)) {
            aca aca2 = new aca();
            aca2.key = "relevant_expand";
            aca2.LmD = this.GlS.fyD().NhY;
            a2.IDO.add(aca2);
        }
        if (!Util.isNullOrNil(this.GlS.fyD().NhZ)) {
            aca aca3 = new aca();
            aca3.key = "relevant_pre_searchid";
            aca3.LmD = this.GlS.fyD().NhZ;
            a2.IDO.add(aca3);
        }
        if (!Util.isNullOrNil(this.GlS.fyD().Nia)) {
            aca aca4 = new aca();
            aca4.key = "relevant_shared_openid";
            aca4.LmD = this.GlS.fyD().Nia;
            a2.IDO.add(aca4);
        }
        if (this.GlS.fyD().Nid != null) {
            aca aca5 = new aca();
            aca5.key = "rec_category";
            aca5.LmC = this.GlS.fyD().Nid.MXW;
            a2.IDO.add(aca5);
        } else {
            aca aca6 = new aca();
            aca6.key = "rec_category";
            aca6.LmC = this.GlS.fyD().Nib;
            a2.IDO.add(aca6);
        }
        Iterator<aca> it = a2.IDO.iterator();
        while (true) {
            if (it.hasNext()) {
                if ("show_tag_list".equals(it.next().key)) {
                    z = false;
                    break;
                }
            } else {
                z = true;
                break;
            }
        }
        if (this.GlS.fyD().Nid != null && z) {
            aca aca7 = new aca();
            aca7.key = "show_tag_list";
            aca7.LmD = this.GlS.fyD().Nid.id;
            a2.IDO.add(aca7);
        }
        aca aca8 = new aca();
        aca8.key = "fetch_seed_videoinfo";
        if (this.GlS.fyD().Nid == null || Util.isNullOrNil(this.GlS.fyD().Nid.id)) {
            aca8.LmC = 1;
        } else {
            aca8.LmC = 0;
        }
        a2.IDO.add(aca8);
        if (fzy() == 1) {
            eiw acd = acd(0);
            aca aca9 = new aca();
            aca9.key = "first_video_tag_list";
            aca9.LmD = com.tencent.mm.plugin.topstory.a.h.hK(acd.xuO).toString();
            a2.IDO.add(aca9);
        }
        o fyB = this.GlS.fyB();
        if (fyB.GnR.size() > 0) {
            ArrayList<c> arrayList = new ArrayList();
            arrayList.addAll(fyB.GnR.values());
            StringBuffer stringBuffer = new StringBuffer("");
            for (c cVar : arrayList) {
                stringBuffer.append(cVar.GjI ? 1 : 0);
                stringBuffer.append("_");
                stringBuffer.append(cVar.GjH.psI);
                stringBuffer.append(";");
            }
            str = stringBuffer.toString();
        } else {
            str = null;
        }
        if (!Util.isNullOrNil(str)) {
            aca aca10 = new aca();
            aca10.key = "client_exposed_info";
            aca10.LmD = str;
            a2.IDO.add(aca10);
        }
        aca aca11 = new aca();
        aca11.key = "is_prefetch";
        aca11.LmC = (long) this.GnE;
        a2.IDO.add(aca11);
        if (this.GnF != null) {
            g.azz().a(this.GnF);
            this.GnF = null;
        }
        this.GnF = new k(a2);
        g.azz().a(this.GnF, 0);
        g.azz().a(1943, this.gNh);
        com.tencent.mm.plugin.websearch.api.a.a.pl(0);
        AppMethodBeat.o(126131);
        return true;
    }

    public final void a(eit eit, int i2) {
        int i3;
        AppMethodBeat.i(126132);
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                List<eiw> GW = GW();
                if (!Util.isNullOrNil(GW) && i2 < GW.size()) {
                    if (i2 > 0) {
                        i3 = i2 - 1;
                    } else {
                        i3 = 0;
                    }
                    int i4 = i3;
                    while (i4 < GW.size() && i4 < i3 + 10) {
                        arrayList.add(GW.get(i4).psI);
                        i4++;
                    }
                    final e eVar = new e(eit, arrayList);
                    g.azz().a(eVar, 0);
                    g.azz().a(eVar.getType(), new i() {
                        /* class com.tencent.mm.plugin.topstory.ui.video.n.AnonymousClass1 */

                        @Override // com.tencent.mm.ak.i
                        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                            AppMethodBeat.i(126121);
                            if ((qVar instanceof e) && qVar.equals(eVar)) {
                                g.azz().b(eVar.getType(), this);
                                if (i2 == 0 && i3 == 0) {
                                    final dky dky = (dky) ((e) qVar).rr.iLL.iLR;
                                    com.tencent.f.h.RTc.aX(new com.tencent.f.i.h() {
                                        /* class com.tencent.mm.plugin.topstory.ui.video.n.AnonymousClass1.AnonymousClass1 */

                                        @Override // com.tencent.f.i.h, com.tencent.f.i.g
                                        public final String getKey() {
                                            return "requestVideoUrlResultParse";
                                        }

                                        public final void run() {
                                            AppMethodBeat.i(126120);
                                            ArrayList<eiw> arrayList = new ArrayList();
                                            Iterator<era> it = dky.MOS.KKx.iterator();
                                            while (it.hasNext()) {
                                                era next = it.next();
                                                eiw eiw = new eiw();
                                                if (!Util.isNullOrNil(next.Nor.pLq)) {
                                                    eiw.psI = next.Nor.pLq;
                                                    if (next.Not == null || next.Not.NnT != 1) {
                                                        if (next.Not == null || next.Not.NnT != 2) {
                                                            if (!Util.isNullOrNil(next.Nou)) {
                                                                eiw.Niw.clear();
                                                                n.b(eiw, next.Nou, "");
                                                                eiy hJ = com.tencent.mm.plugin.topstory.a.h.hJ(eiw.Niw);
                                                                if (hJ != null) {
                                                                    eiw.videoUrl = hJ.url;
                                                                    eiw.NiF = hJ.NiF;
                                                                    if (next.Not != null) {
                                                                        eiw.NiB = next.Not.NnW;
                                                                    }
                                                                }
                                                            }
                                                        } else if (next.Not.NnU != null && !Util.isNullOrNil(next.Not.NnU.Lfy)) {
                                                            eiw.Niw.clear();
                                                            eiw.NiB = next.Not.NnW;
                                                            Iterator<eoj> it2 = next.Not.NnU.Lfy.iterator();
                                                            while (it2.hasNext()) {
                                                                eoj next2 = it2.next();
                                                                eiy eiy = new eiy();
                                                                eiy.url = next2.Nmh.yO();
                                                                eiy.NiF = 0;
                                                                eiw.Niw.add(eiy);
                                                                eiw.Niv = next2.Nmj;
                                                            }
                                                            eiy hJ2 = com.tencent.mm.plugin.topstory.a.h.hJ(eiw.Niw);
                                                            if (hJ2 != null) {
                                                                eiw.videoUrl = hJ2.url;
                                                                eiw.NiF = hJ2.NiF;
                                                            }
                                                        }
                                                    } else if (next.Not.NnV != null && !Util.isNullOrNil(next.Not.NnV.Lfy)) {
                                                        eiw.Niw.clear();
                                                        eiw.NiB = next.Not.NnW;
                                                        Iterator<eoj> it3 = next.Not.NnV.Lfy.iterator();
                                                        while (it3.hasNext()) {
                                                            eoj next3 = it3.next();
                                                            eiy eiy2 = new eiy();
                                                            eiy2.url = next3.Nmh.yO();
                                                            eiy2.NiF = 0;
                                                            eiw.Niw.add(eiy2);
                                                            eiw.Niv = next3.Nmj;
                                                        }
                                                        eiy hJ3 = com.tencent.mm.plugin.topstory.a.h.hJ(eiw.Niw);
                                                        if (hJ3 != null) {
                                                            eiw.videoUrl = hJ3.url;
                                                            eiw.NiF = hJ3.NiF;
                                                        }
                                                    }
                                                    arrayList.add(eiw);
                                                }
                                            }
                                            synchronized (n.this) {
                                                try {
                                                    List<eiw> GW = n.this.GW();
                                                    if (!Util.isNullOrNil(GW)) {
                                                        for (int i2 = 0; i2 < GW.size(); i2++) {
                                                            eiw eiw2 = GW.get(i2);
                                                            for (eiw eiw3 : arrayList) {
                                                                if (eiw2.psI.equals(eiw3.psI)) {
                                                                    eiw2.Niw = eiw3.Niw;
                                                                    eiw2.Niv = eiw3.Niv;
                                                                    eiw2.videoUrl = eiw3.videoUrl;
                                                                    eiw2.NiB = eiw3.NiB;
                                                                    Log.d("MicroMsg.TopStory.TopStoryVideoDataMgr", "item title:%s, after url:%s", eiw2.title, eiw2.videoUrl);
                                                                }
                                                            }
                                                        }
                                                        AppMethodBeat.o(126120);
                                                    }
                                                } finally {
                                                    AppMethodBeat.o(126120);
                                                }
                                            }
                                        }
                                    });
                                } else {
                                    Log.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "fetch videourl failed!, errType %s, errCode %s", Integer.valueOf(i2), Integer.valueOf(i3));
                                    AppMethodBeat.o(126121);
                                    return;
                                }
                            }
                            AppMethodBeat.o(126121);
                        }
                    });
                    AppMethodBeat.o(126132);
                }
            } finally {
                AppMethodBeat.o(126132);
            }
        }
    }

    public final void onUIDestroy() {
        AppMethodBeat.i(126133);
        if (this.GnF != null) {
            g.azz().a(this.GnF);
            this.GnF = null;
        }
        if (this.GnI != null) {
            g.azz().a(this.GnI);
            this.GnI = null;
        }
        g.azz().b(1943, this.gNh);
        AppMethodBeat.o(126133);
    }

    class a implements Runnable {
        private String sTh;
        private boolean xwi;

        private a() {
        }

        /* synthetic */ a(n nVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(126124);
            try {
                n.a(n.this, new JSONObject(this.sTh), this.xwi);
            } catch (Exception e2) {
            } finally {
                n.this.GhN = false;
                AppMethodBeat.o(126124);
            }
        }
    }

    private static List<eiw> a(boolean z, JSONArray jSONArray) {
        AppMethodBeat.i(126134);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
            long optLong = jSONObject.optLong("resultType");
            long optLong2 = jSONObject.optLong("type");
            String optString = jSONObject.optString("expand");
            JSONArray optJSONArray = jSONObject.optJSONArray("items");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i3);
                    eiw a2 = a(jSONObject2, optLong, optLong2, optString, z);
                    if (a2 != null) {
                        Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "videoid: %s, videoUrl: %s, videoSize: %s", a2.psI, a2.videoUrl, Long.valueOf(a2.Niv));
                        arrayList.add(a2);
                    } else {
                        Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "Can not add video %s", jSONObject2.toString());
                    }
                }
            }
        }
        AppMethodBeat.o(126134);
        return arrayList;
    }

    private static eiw a(JSONObject jSONObject, long j2, long j3, String str, boolean z) {
        AppMethodBeat.i(126135);
        String optString = jSONObject.optString("videoId");
        String optString2 = jSONObject.optString("docID");
        int optInt = jSONObject.optInt("mediaDuration", 0);
        if (!Util.isNullOrNil(optString)) {
            eiw eiw = new eiw();
            eiw.psI = optString;
            b(jSONObject, eiw);
            a(z, eiw, jSONObject);
            if (Util.isNullOrNil(eiw.videoUrl)) {
                com.tencent.mm.plugin.websearch.api.a.a.pl(11);
            }
            eiw.Eso = optInt;
            eiw.title = jSONObject.optString("title");
            eiw.msN = jSONObject.optString("shareTitle");
            eiw.xDQ = jSONObject.optString("shareDesc");
            eiw.IED = jSONObject.optString("shareImgUrl");
            eiw.IEE = jSONObject.optString("shareString");
            eiw.IEF = jSONObject.optString("shareStringUrl");
            eiw.source = jSONObject.optString("source");
            eiw.eby = jSONObject.optString("sourceUrl");
            eiw.rCq = jSONObject.optString("shareUrl");
            eiw.Nip = jSONObject.optLong("relevant_category", -1);
            eiw.Niq = jSONObject.optString("shareOpenId");
            eiw.Nir = jSONObject.optString("expand");
            eiw.IEG = jSONObject.optString("strPlayCount");
            eiw.IEH = jSONObject.optString("titleUrl");
            eiw.Nis = jSONObject.optInt("itemType");
            eiw.MwR = jSONObject.optString("bizIcon");
            eiw.Niy = jSONObject.optLong("shareChannelId", eiw.Nip);
            eiw.timestamp = Util.currentTicks();
            eiw.dEF = false;
            eiw.wWb = optString2;
            eiw.Niu = j2;
            eiw.dDw = j3;
            eiw.Nit = str;
            eiw.Nix = jSONObject.optInt("switchFlag", 0);
            eiw.BmI = jSONObject.optString("bizUserName");
            eiw.NiJ = jSONObject.optInt("sourceJumpType", 1);
            JSONObject optJSONObject = jSONObject.optJSONObject("colikeInfo");
            if (optJSONObject != null) {
                eiw.NiC = optJSONObject.optBoolean("isSelfThumb");
                eiw.NiD = optJSONObject.optString("byPass", "");
                eiw.NiH = optJSONObject.optInt("globalColikeCnt", 0);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("extReqParams");
            if (optJSONArray != null) {
                com.tencent.mm.plugin.topstory.a.h.q(eiw.IDO, optJSONArray.toString());
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("show_tag_list");
            if (optJSONArray2 != null) {
                a(optJSONArray2, eiw);
            }
            if (!jSONObject.optBoolean("not_show_feedback", false)) {
                a(jSONObject.optJSONObject("feedbackObj"), eiw);
            }
            try {
                JSONArray optJSONArray3 = jSONObject.optJSONArray("videoMpDotInfo");
                if (optJSONArray3 != null) {
                    try {
                        JSONObject optJSONObject2 = optJSONArray3.optJSONObject(0);
                        eiw.NiI = new eip();
                        eiw.NiI.NhM = optJSONObject2.optString("bizuin");
                        eiw.NiI.id = optJSONObject2.optString("id");
                        JSONObject optJSONObject3 = optJSONObject2.optJSONArray("list").optJSONObject(0);
                        eiw.NiI.LHa = optJSONObject3.optInt("beginTime");
                        eiw.NiI.iqg = optJSONObject3.optInt("endTime");
                        eiw.NiI.NhL = optJSONObject3.optInt("minShowTime");
                        eiw.NiI.type = optJSONObject3.optInt("type");
                        eiw.NiI.lYE = optJSONObject3.optString("id");
                        JSONObject jSONObject2 = new JSONObject(optJSONObject3.optString("dot"));
                        eiw.NiI.NhN = new eio();
                        eiw.NiI.NhN.title = jSONObject2.optString("title");
                        eiw.NiI.NhN.desc = jSONObject2.optString("desc");
                        eiw.NiI.NhN.ecK = jSONObject2.optString("relativeURL");
                        eiw.NiI.NhN.NhJ = jSONObject2.optString("originalId");
                        eiw.NiI.NhN.NhK = jSONObject2.optString("weAppName");
                        eiw.NiI.NhN.appId = jSONObject2.optString("appId");
                        eiw.NiI.NhN.uNR = jSONObject2.optString("avatar");
                    } catch (Exception e2) {
                    }
                }
            } catch (Exception e3) {
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("videoSecondInfo");
            if (optJSONObject4 != null) {
                eiw.Niz = new eir();
                eiw.Niz.Kmn = optJSONObject4.optInt("insertPos", 2);
                eiw.Niz.NhS = optJSONObject4.optString("originVideoId", "");
                eiw.Niz.NhR = optJSONObject4.optInt("videoSecondType", 1);
                eiw.Niz.NhT = optJSONObject4.optInt("requestDuration", 0);
                eiw.Niz.NhU = optJSONObject4.optInt("requestPercent", 0);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("longVideoItem");
            if (optJSONObject5 != null) {
                eiw.NiG = new eiw();
                eiw.NiG.wWb = optJSONObject5.optString("docID", "");
                eiw.NiG.title = optJSONObject5.optString("title", "");
                eiw.NiG.Eso = optJSONObject5.optInt("mediaDuration", 0);
                eiw.NiG.Nis = optJSONObject5.optInt("itemType", 0);
                eiw.NiG.psI = optJSONObject5.optString("videoId", "");
                JSONArray optJSONArray4 = optJSONObject5.optJSONArray("show_tag_list");
                if (optJSONArray4 != null) {
                    a(optJSONArray4, eiw.NiG);
                }
                JSONObject optJSONObject6 = optJSONObject5.optJSONObject("feedbackObj");
                if (optJSONObject6 != null) {
                    a(optJSONObject6, eiw.NiG);
                }
                JSONArray optJSONArray5 = optJSONObject5.optJSONArray("extReqParams");
                if (optJSONArray5 != null) {
                    com.tencent.mm.plugin.topstory.a.h.q(eiw.NiG.IDO, optJSONArray5.toString());
                }
                b(optJSONObject5, eiw.NiG);
                a(z, eiw.NiG, optJSONObject5);
                eiw.NiG.source = eiw.source;
                eiw.NiG.eby = eiw.eby;
                eiw.NiG.MwR = eiw.MwR;
                eiw.NiG.Niy = eiw.Niy;
                eiw.NiG.msN = eiw.msN;
                eiw.NiG.xDQ = eiw.xDQ;
                eiw.NiG.Niq = eiw.Niq;
                eiw.NiG.IED = eiw.IED;
                eiw.NiG.IEE = eiw.IEE;
                eiw.NiG.IEF = eiw.IEF;
                eiw.NiG.Niq = eiw.Niq;
                eiw.NiG.rCq = optJSONObject5.optString("shareUrl", "");
            }
            if (!Util.isNullOrNil(eiw.videoUrl)) {
                Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "videoid: %s, videoUrl: %s, videoSize: %s", eiw.psI, eiw.videoUrl, Long.valueOf(eiw.Niv));
                AppMethodBeat.o(126135);
                return eiw;
            }
            AppMethodBeat.o(126135);
            return null;
        }
        AppMethodBeat.o(126135);
        return null;
    }

    private static void a(JSONArray jSONArray, eiw eiw) {
        AppMethodBeat.i(126136);
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            dyi dyi = new dyi();
            dyi.id = jSONArray.getJSONObject(i2).optString("id");
            dyi.dQx = jSONArray.getJSONObject(i2).optString("wording");
            dyi.MXW = jSONArray.getJSONObject(i2).optLong("category");
            dyi.actionType = jSONArray.getJSONObject(i2).optInt("actionType");
            dyi.url = jSONArray.getJSONObject(i2).optString("url");
            dyi.title = jSONArray.getJSONObject(i2).optString("title");
            dyi.oqZ = jSONArray.getJSONObject(i2).optString("subTitle");
            dyi.icon = jSONArray.getJSONObject(i2).optString("icon");
            eiw.xuO.add(dyi);
        }
        AppMethodBeat.o(126136);
    }

    private static void a(JSONObject jSONObject, eiw eiw) {
        AppMethodBeat.i(126137);
        eiw.NiE = new eiu();
        eiw.NiE.Nil = jSONObject.optString("detailWording");
        eiw.NiE.Nim = jSONObject.optString("detailUrl");
        JSONArray optJSONArray = jSONObject.optJSONArray("feedbackData");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                any any = new any();
                any.id = optJSONArray.optJSONObject(i2).optString("id", "");
                any.dQx = optJSONArray.optJSONObject(i2).optString("wording", "");
                any.LzD = optJSONArray.optJSONObject(i2).optBoolean("isUseToConfirm", false);
                eiw.NiE.Nin.add(any);
            }
        }
        AppMethodBeat.o(126137);
    }

    private static void b(JSONObject jSONObject, eiw eiw) {
        eiy hJ;
        AppMethodBeat.i(126138);
        String optString = jSONObject.optString("videoPlatform");
        String optString2 = jSONObject.optString("videoApi");
        JSONObject optJSONObject = jSONObject.optJSONObject("videoInfo");
        if (!(optJSONObject == null || !c(optJSONObject, eiw) || (hJ = com.tencent.mm.plugin.topstory.a.h.hJ(eiw.Niw)) == null)) {
            eiw.videoUrl = hJ.url;
            eiw.NiF = hJ.NiF;
        }
        if (Util.isNullOrNil(eiw.videoUrl) && !Util.isNullOrNil(optString2)) {
            a(eiw, optString2, optString);
            if (Util.isNullOrNil(eiw.Niw)) {
                com.tencent.mm.plugin.websearch.api.a.a.pl(29);
                Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByVideoApi retry");
                a(eiw, optString2, optString);
            }
            eiy hJ2 = com.tencent.mm.plugin.topstory.a.h.hJ(eiw.Niw);
            if (hJ2 != null) {
                eiw.videoUrl = hJ2.url;
                eiw.NiF = hJ2.NiF;
            }
        }
        AppMethodBeat.o(126138);
    }

    private static boolean c(JSONObject jSONObject, eiw eiw) {
        AppMethodBeat.i(126139);
        JSONObject jSONObject2 = null;
        if (jSONObject != null) {
            jSONObject2 = jSONObject.optJSONObject("videoCdnInfo");
        }
        if (jSONObject2 != null) {
            eiw.NiA = jSONObject2.optInt("cdnScene", 0);
            eiw.NiB = jSONObject2.optInt("cdnSourceType", 0);
        }
        if (eiw.NiA != 1 && eiw.NiB != 2) {
            AppMethodBeat.o(126139);
            return false;
        } else if (!a(eiw.NiA, eiw, jSONObject2)) {
            AppMethodBeat.o(126139);
            return false;
        } else {
            Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "useCdnData, cdnScene:%s, vid:%s, title:%s, size:%s", Integer.valueOf(eiw.NiA), eiw.psI, eiw.title, Long.valueOf(eiw.Niv));
            AppMethodBeat.o(126139);
            return true;
        }
    }

    private static void a(boolean z, eiw eiw, JSONObject jSONObject) {
        AppMethodBeat.i(126140);
        eiw.Nio = jSONObject.optString("thumbUrl");
        if (z) {
            eiw.thumbWidth = v2helper.VOIP_ENC_HEIGHT_LV1;
            eiw.thumbHeight = 640;
        } else {
            eiw.thumbWidth = m.CTRL_INDEX;
            eiw.thumbHeight = 280;
        }
        if (Util.isNullOrNil(eiw.Nio)) {
            eiw.Nio = "http://shp.qpic.cn/qqvideo_ori/0/" + eiw.psI + String.format("_%s_%s/0", Integer.valueOf(eiw.thumbWidth), Integer.valueOf(eiw.thumbHeight));
        }
        Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "setThumbnailUrl %s %s", eiw.psI, eiw.Nio);
        AppMethodBeat.o(126140);
    }

    private static boolean a(int i2, eiw eiw, JSONObject jSONObject) {
        JSONObject optJSONObject;
        AppMethodBeat.i(126141);
        if (i2 == 1) {
            try {
                optJSONObject = jSONObject.optJSONObject("mpInfo");
            } catch (Exception e2) {
                Log.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByCdn exception: " + e2.getMessage());
                AppMethodBeat.o(126141);
                return false;
            }
        } else {
            optJSONObject = jSONObject.optJSONObject("ctnInfo");
        }
        if (optJSONObject == null || optJSONObject.optJSONArray("urlInfo") == null) {
            AppMethodBeat.o(126141);
            return false;
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("urlInfo");
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i3);
            if (jSONObject2.has("url") && jSONObject2.has(FFmpegMetadataRetriever.METADATA_KEY_FILESIZE)) {
                eiw.Niv = (long) jSONObject2.optInt(FFmpegMetadataRetriever.METADATA_KEY_FILESIZE, 0);
                eiy eiy = new eiy();
                eiy.url = jSONObject2.optString("url");
                eiy.NiF = 0;
                eiw.Niw.add(eiy);
            }
        }
        eiw.Nio = optJSONObject.optString("coverUrl");
        if (eiw.Niv <= 0 || Util.isNullOrNil(eiw.Niw)) {
            AppMethodBeat.o(126141);
            return false;
        }
        AppMethodBeat.o(126141);
        return true;
    }

    private static void a(eiw eiw, String str, String str2) {
        InputStream inputStream;
        JSONArray optJSONArray;
        JSONObject jSONObject;
        JSONArray optJSONArray2;
        JSONArray optJSONArray3;
        AppMethodBeat.i(126142);
        x xVar = null;
        aa aaVar = null;
        StringBuilder sb = new StringBuilder("");
        try {
            int fzz = fzz();
            int ape = ape();
            int fzA = fzA();
            Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByVideoApi, videoapi: %s", str);
            if (URLUtil.isHttpsUrl(str)) {
                aaVar = d.RR(str);
                aaVar.bjX();
                aaVar.setConnectTimeout(3000);
                aaVar.setReadTimeout(3000);
                inputStream = aaVar.jFs.getInputStream();
            } else {
                xVar = d.a(str, null);
                xVar.setUseCaches(true);
                xVar.setConnectTimeout(3000);
                xVar.setReadTimeout(3000);
                inputStream = xVar.getInputStream();
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            JSONObject jSONObject2 = new JSONObject(sb.toString().substring(13));
            JSONObject optJSONObject = jSONObject2.optJSONObject("fl");
            if (optJSONObject != null && (optJSONArray3 = optJSONObject.optJSONArray("fi")) != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= optJSONArray3.length()) {
                        break;
                    }
                    JSONObject jSONObject3 = optJSONArray3.getJSONObject(i2);
                    if (jSONObject3.optInt("sl", 0) == 1) {
                        eiw.Niv = jSONObject3.optLong("fs");
                        break;
                    }
                    i2++;
                }
            }
            JSONObject optJSONObject2 = jSONObject2.optJSONObject("vl");
            if (!(optJSONObject2 == null || (optJSONArray = optJSONObject2.optJSONArray(LocaleUtil.VIETNAMESE)) == null || optJSONArray.length() <= 0 || (jSONObject = optJSONArray.getJSONObject(0)) == null)) {
                String optString = jSONObject.optString(UserDataStore.FIRST_NAME);
                String optString2 = jSONObject.optString("fvkey");
                JSONObject optJSONObject3 = jSONObject.optJSONObject("ul");
                if (!(optJSONObject3 == null || (optJSONArray2 = optJSONObject3.optJSONArray("ui")) == null || optJSONArray2.length() <= 0)) {
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        JSONObject jSONObject4 = optJSONArray2.getJSONObject(i3);
                        if (jSONObject4 != null) {
                            String optString3 = jSONObject4.optString("url");
                            int optInt = jSONObject4.optInt("vt", 0);
                            if (!Util.isNullOrNil(optString3) && !Util.isNullOrNil(optString2) && !Util.isNullOrNil(optString)) {
                                String str3 = optString3 + optString + "?vkey=" + optString2;
                                if (!Util.isNullOrNil(str2)) {
                                    str3 = str3 + "&platform=" + str2;
                                }
                                String c2 = c(str3, "&", fzz, ape, fzA);
                                eiy eiy = new eiy();
                                eiy.url = c2;
                                eiy.NiF = optInt;
                                eiw.Niw.add(eiy);
                            }
                        }
                    }
                }
            }
            if (xVar != null) {
                xVar.disconnect();
            }
            if (aaVar != null) {
                aaVar.disconnect();
            }
            if (inputStream != null) {
                com.tencent.mm.vfs.aa.closeQuietly(inputStream);
                AppMethodBeat.o(126142);
                return;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                xVar.disconnect();
            }
            if (0 != 0) {
                aaVar.disconnect();
            }
            if (0 != 0) {
                com.tencent.mm.vfs.aa.closeQuietly(null);
            }
            AppMethodBeat.o(126142);
            throw th;
        }
        AppMethodBeat.o(126142);
    }

    private static int fzz() {
        AppMethodBeat.i(126143);
        if (ai.isFreeSimCard()) {
            AppMethodBeat.o(126143);
            return 2;
        }
        AppMethodBeat.o(126143);
        return -1;
    }

    public static int ape() {
        AppMethodBeat.i(126144);
        switch (NetStatusUtil.getNetType(MMApplicationContext.getContext())) {
            case -1:
                AppMethodBeat.o(126144);
                return 0;
            case 0:
                AppMethodBeat.o(126144);
                return 1;
            default:
                if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
                    AppMethodBeat.o(126144);
                    return 2;
                } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
                    AppMethodBeat.o(126144);
                    return 3;
                } else if (NetStatusUtil.is4G(MMApplicationContext.getContext())) {
                    AppMethodBeat.o(126144);
                    return 4;
                } else {
                    AppMethodBeat.o(126144);
                    return 0;
                }
        }
    }

    private static int fzA() {
        AppMethodBeat.i(126145);
        int iSPCode = NetStatusUtil.getISPCode(MMApplicationContext.getContext());
        if (iSPCode == 0) {
            AppMethodBeat.o(126145);
            return 0;
        }
        int i2 = iSPCode / 100;
        int i3 = iSPCode % 100;
        if (i2 == 460) {
            if (i3 == 0 || i3 == 2 || i3 == 7) {
                AppMethodBeat.o(126145);
                return 3;
            } else if (i3 == 1 || i3 == 6 || i3 == 9) {
                AppMethodBeat.o(126145);
                return 2;
            } else if (i3 == 3 || i3 == 5 || i3 == 11) {
                AppMethodBeat.o(126145);
                return 1;
            }
        }
        AppMethodBeat.o(126145);
        return 0;
    }

    private static String c(String str, String str2, int i2, int i3, int i4) {
        AppMethodBeat.i(126146);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(126146);
            return str;
        }
        String str3 = str + str2 + "Unicomtype=" + i2 + "&newnettype=" + i3 + "&Netoperator=" + i4;
        Log.d("MicroMsg.TopStory.TopStoryVideoDataMgr", "joinUrlWithNetInfo: ".concat(String.valueOf(str3)));
        AppMethodBeat.o(126146);
        return str3;
    }

    public static boolean i(eiw eiw) {
        AppMethodBeat.i(236392);
        if (eiw != null) {
            if (eiw.NiJ == 1 && !TextUtils.isEmpty(eiw.eby)) {
                AppMethodBeat.o(236392);
                return true;
            } else if (eiw.NiJ == 2 && !TextUtils.isEmpty(eiw.BmI)) {
                AppMethodBeat.o(236392);
                return true;
            }
        }
        AppMethodBeat.o(236392);
        return false;
    }

    public static boolean a(final eiw eiw, final Context context) {
        AppMethodBeat.i(236393);
        if (eiw != null) {
            Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "jumpToProfile sJumpType:%s", Integer.valueOf(eiw.NiJ));
            if (eiw.NiJ == 1) {
                if (!Util.isNullOrNil(eiw.eby)) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", eiw.eby);
                    com.tencent.mm.br.c.b(context, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(236393);
                    return true;
                }
            } else if (eiw.NiJ == 2 && !TextUtils.isEmpty(eiw.BmI)) {
                as Kn = ((l) g.af(l.class)).aSN().Kn(eiw.BmI);
                if (Kn == null || ((int) Kn.gMZ) <= 0) {
                    Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "jumpToProfile contact not exist, getNow");
                    final boolean[] zArr = {false};
                    final com.tencent.mm.ui.base.q a2 = com.tencent.mm.ui.base.h.a(context, context.getString(R.string.ek_), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.topstory.ui.video.n.AnonymousClass3 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            zArr[0] = true;
                        }
                    });
                    try {
                        ay.a.iDq.a(eiw.BmI, "", new ay.b.a() {
                            /* class com.tencent.mm.plugin.topstory.ui.video.n.AnonymousClass4 */

                            @Override // com.tencent.mm.model.ay.b.a
                            public final void p(String str, boolean z) {
                                AppMethodBeat.i(236391);
                                a2.dismiss();
                                Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "jumpToProfile getNow:%s, isCancel:%s", Boolean.valueOf(z), Boolean.valueOf(zArr[0]));
                                if (zArr[0]) {
                                    AppMethodBeat.o(236391);
                                    return;
                                }
                                if (z) {
                                    Intent intent = new Intent();
                                    intent.putExtra("Contact_User", eiw.BmI);
                                    intent.putExtra("biz_profile_tab_type", 1);
                                    com.tencent.mm.br.c.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                                }
                                AppMethodBeat.o(236391);
                            }
                        });
                    } catch (Throwable th) {
                        a2.dismiss();
                        Log.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "jumpToProfile err:%s", th.getMessage());
                    }
                } else {
                    Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "jumpToProfile contact exist");
                    Intent intent2 = new Intent();
                    intent2.putExtra("Contact_User", eiw.BmI);
                    intent2.putExtra("biz_profile_tab_type", 1);
                    com.tencent.mm.br.c.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                }
                AppMethodBeat.o(236393);
                return true;
            }
        }
        AppMethodBeat.o(236393);
        return false;
    }

    static /* synthetic */ void a(n nVar, JSONObject jSONObject, boolean z) {
        AppMethodBeat.i(126149);
        JSONObject optJSONObject = jSONObject.optJSONObject("client_conf");
        if (!(optJSONObject == null || optJSONObject == null)) {
            nVar.GnE = optJSONObject.optInt("enable_prefetch", 0);
            nVar.GnG = optJSONObject.optInt("max_report_exposed_cnt", 0);
            nVar.GnH = optJSONObject.optInt("max_report_exposed_cnt", 0);
            Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "parseAndSetPreFetchReportInfo %s", optJSONObject.toString());
        }
        String optString = jSONObject.optString("searchID");
        Log.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "fetch response newsearchid: %s originSearchId: %s", optString, nVar.GlS.fyD().hes);
        if (!Util.isNullOrNil(optString)) {
            nVar.GlS.fyD().hes = optString;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        boolean optBoolean = jSONObject.optBoolean("isSinglePage", false);
        nVar.GlS.fyD().Nik = optBoolean;
        if (optBoolean) {
            nVar.GlS.fyR();
        }
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            com.tencent.mm.plugin.websearch.api.a.a.pl(1);
            nVar.GlS.aTE(jSONObject.optString("nomoreText"));
            AppMethodBeat.o(126149);
            return;
        }
        try {
            List<eiw> a2 = a(nVar.GlS.fyL(), optJSONArray);
            if (a2.size() == 0) {
                nVar.GlS.aTE(MMApplicationContext.getContext().getString(R.string.fvb));
                AppMethodBeat.o(126149);
                return;
            }
            nVar.GlS.s(a2, z);
            AppMethodBeat.o(126149);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoDataMgr", e2, "parseAndRequestVideoList error: %s", e2.getMessage());
            com.tencent.mm.plugin.websearch.api.a.a.pl(3);
            nVar.GlS.aTE("ParseDataError");
            AppMethodBeat.o(126149);
        }
    }
}
