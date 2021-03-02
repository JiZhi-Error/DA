package com.tencent.mm.plugin.sns.ad.timeline.c.a;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.f;
import com.tencent.mm.plugin.sns.ad.a.d;
import com.tencent.mm.plugin.sns.ad.a.e;
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.plugin.sns.ad.i.i;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends i.b {
    int Dzm = 0;
    List<C1709a> Dzn = new ArrayList();
    String adExtInfo;
    int currentIndex = -1;
    String dRS;
    int scene;
    String uxInfo;

    public a(int i2) {
        AppMethodBeat.i(202257);
        this.scene = i2;
        AppMethodBeat.o(202257);
    }

    public final void a(SnsInfo snsInfo, int i2, d dVar) {
        AppMethodBeat.i(202258);
        if (snsInfo == null) {
            Log.i("SnsAd.AdChannelData", "the sns info is null!");
            AppMethodBeat.o(202258);
            return;
        }
        String v = r.v(snsInfo);
        if (TextUtils.isEmpty(this.dRS) || !this.dRS.equals(v)) {
            setSnsId(v);
            if (snsInfo.getAdInfo(i2) != null) {
                aNS(snsInfo.getUxinfo());
            }
            this.Dzn.clear();
            if (!(dVar == null || dVar.DrS == null)) {
                int size = dVar.DrS.size();
                for (int i3 = 0; i3 < size; i3++) {
                    e eVar = dVar.DrS.get(i3);
                    C1709a aVar = new C1709a();
                    aVar.index = i3;
                    this.Dzn.add(aVar);
                    if (eVar != null) {
                        aVar.mediaType = eVar.eWB() ? 2 : 1;
                        aVar.DrW = Util.nullAsNil(eVar.DrW);
                    }
                }
            }
            AppMethodBeat.o(202258);
            return;
        }
        Log.i("SnsAd.AdChannelData", "the new sns id is same as the old one!");
        AppMethodBeat.o(202258);
    }

    private void setSnsId(String str) {
        AppMethodBeat.i(202259);
        this.dRS = Util.nullAsNil(str);
        AppMethodBeat.o(202259);
    }

    private void aNS(String str) {
        AppMethodBeat.i(202260);
        this.uxInfo = Util.nullAsNil(str);
        AppMethodBeat.o(202260);
    }

    public final void eXZ() {
        this.Dzm++;
    }

    public final void XN(int i2) {
        AppMethodBeat.i(202261);
        C1709a XP = XP(i2);
        if (XP != null) {
            XP.clickCount++;
        }
        AppMethodBeat.o(202261);
    }

    public final void io(int i2, int i3) {
        AppMethodBeat.i(202262);
        C1709a XP = XP(i2);
        if (XP != null) {
            XP.Dzs = i3;
            XP.Dzq += XP.Dzt;
            XP.Dzt = 0;
        }
        AppMethodBeat.o(202262);
    }

    private boolean XO(int i2) {
        AppMethodBeat.i(202263);
        int size = this.Dzn.size();
        if (i2 < 0 || i2 >= size) {
            AppMethodBeat.o(202263);
            return false;
        }
        AppMethodBeat.o(202263);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final C1709a XP(int i2) {
        AppMethodBeat.i(202264);
        if (XO(i2)) {
            C1709a aVar = this.Dzn.get(i2);
            AppMethodBeat.o(202264);
            return aVar;
        }
        AppMethodBeat.o(202264);
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.sns.ad.timeline.c.a.a$a  reason: collision with other inner class name */
    public static class C1709a {
        int Aiv;
        String DrW;
        int Dzo;
        int Dzp;
        int Dzq;
        int Dzr;
        int Dzs;
        int Dzt;
        int clickCount;
        int index;
        int mediaType;

        C1709a() {
        }

        /* access modifiers changed from: package-private */
        public final JSONObject toJson() {
            AppMethodBeat.i(202256);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt(FirebaseAnalytics.b.INDEX, Integer.valueOf(this.index));
                jSONObject.putOpt("mediaType", Integer.valueOf(this.mediaType));
                jSONObject.putOpt("finderType", Util.nullAsNil(this.DrW));
                jSONObject.putOpt(f.COL_EXPOSURECOUNT, Integer.valueOf(this.Dzo));
                jSONObject.putOpt("clickCount", Integer.valueOf(this.clickCount));
                jSONObject.putOpt("playCount", Integer.valueOf(this.Aiv));
                jSONObject.putOpt("finishPlayCount", Integer.valueOf(this.Dzp));
                jSONObject.putOpt("playTotalTime", Integer.valueOf(this.Dzq + this.Dzt));
                jSONObject.putOpt("maxPlayTime", Integer.valueOf(this.Dzp > 0 ? this.Dzs : this.Dzr));
                jSONObject.putOpt("videoTotalTime", Integer.valueOf(this.Dzs));
                AppMethodBeat.o(202256);
                return jSONObject;
            } catch (Throwable th) {
                AppMethodBeat.o(202256);
                return null;
            }
        }
    }

    @Override // com.tencent.mm.plugin.sns.ad.i.i.a
    public final String eWH() {
        return "sns_ad_finder_topic_report";
    }

    @Override // com.tencent.mm.plugin.sns.ad.i.i.a, com.tencent.mm.plugin.sns.ad.i.i.b
    public final String getContent() {
        AppMethodBeat.i(202265);
        String content = super.getContent();
        if (this.Dzn != null) {
            this.Dzn.clear();
        }
        this.dRS = "";
        this.Dzm = 0;
        AppMethodBeat.o(202265);
        return content;
    }

    @Override // com.tencent.mm.plugin.sns.ad.i.i.b
    public final void bn(JSONObject jSONObject) {
        AppMethodBeat.i(202266);
        try {
            jSONObject.putOpt("snsid", this.dRS);
            jSONObject.putOpt("uxinfo", this.uxInfo);
            jSONObject.putOpt("adExtInfo", this.adExtInfo);
            jSONObject.putOpt("scene", Integer.valueOf(this.scene));
            AppMethodBeat.o(202266);
        } catch (Throwable th) {
            AppMethodBeat.o(202266);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ad.i.i.b
    public final void bo(JSONObject jSONObject) {
        AppMethodBeat.i(202267);
        try {
            jSONObject.putOpt("infoBarClickCount", Integer.valueOf(this.Dzm));
            JSONArray jSONArray = new JSONArray();
            jSONObject.putOpt("reportItemList", jSONArray);
            H(jSONArray);
            AppMethodBeat.o(202267);
        } catch (Throwable th) {
            AppMethodBeat.o(202267);
        }
    }

    private void H(JSONArray jSONArray) {
        JSONObject json;
        AppMethodBeat.i(202268);
        if (c.isEmpty(this.Dzn)) {
            AppMethodBeat.o(202268);
            return;
        }
        for (C1709a aVar : this.Dzn) {
            if (!(aVar == null || (json = aVar.toJson()) == null)) {
                jSONArray.put(json);
            }
        }
        AppMethodBeat.o(202268);
    }
}
