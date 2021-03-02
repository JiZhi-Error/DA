package com.tencent.mm.plugin.sns.ad.timeline.feedback.a;

import android.view.View;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.ad.i.i;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.AdFrameLayout;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import org.json.JSONObject;

public final class b implements i.a {
    private String DyA;
    private String DyB;
    private int DyC;
    private int DyD;
    private int DyE;
    private Long DyF;
    private int DyG;
    private long Dyz;
    private int mScene;

    public static i.a a(String str, View view, k kVar) {
        AppMethodBeat.i(202182);
        try {
            i.a a2 = a(aj.faO().aQm(str), true, view, kVar);
            AppMethodBeat.o(202182);
            return a2;
        } catch (Throwable th) {
            AppMethodBeat.o(202182);
            return null;
        }
    }

    public static i.a a(SnsInfo snsInfo, boolean z, View view, k kVar) {
        View at;
        int i2 = 2;
        AppMethodBeat.i(202183);
        if (snsInfo == null || view == null) {
            AppMethodBeat.o(202183);
            return null;
        }
        try {
            if (!snsInfo.isAd()) {
                AppMethodBeat.o(202183);
                return null;
            }
            boolean z2 = (kVar == null || kVar.source == 0) ? false : true;
            ADInfo adInfo = snsInfo.getAdInfo();
            ADXml adXml = snsInfo.getAdXml();
            if (snsInfo == null || adInfo == null || adXml == null || view == null) {
                AppMethodBeat.o(202183);
                return null;
            } else if (!snsInfo.isAd()) {
                AppMethodBeat.o(202183);
                return null;
            } else {
                b bVar = new b();
                bVar.Dyz = snsInfo.field_snsId;
                bVar.DyA = com.tencent.mm.plugin.sns.data.i.aNZ(adInfo.uxInfo);
                bVar.mScene = z2 ? 2 : 1;
                bVar.DyB = adXml.adExtInfo;
                if (!z) {
                    i2 = 1;
                }
                bVar.DyG = i2;
                if (z2) {
                    at = at(view, R.id.jh);
                } else {
                    at = at(view, R.id.hyf);
                    if (!(at instanceof AdFrameLayout)) {
                        at = view;
                    }
                }
                if (at != null) {
                    int[] iArr = new int[2];
                    at.getLocationOnScreen(iArr);
                    bVar.DyC = iArr[1];
                }
                if (view != null) {
                    int[] iArr2 = new int[2];
                    view.getLocationOnScreen(iArr2);
                    int width = view.getWidth();
                    int height = view.getHeight();
                    bVar.DyD = (width / 2) + iArr2[0];
                    bVar.DyE = iArr2[1] + (height / 2);
                }
                if (!(kVar == null || snsInfo.getTimeLine() == null || snsInfo.getTimeLine().ContentObj == null || snsInfo.getTimeLine().ContentObj.LoU != 15)) {
                    bVar.DyF = Long.valueOf(kVar.IV(bVar.Dyz));
                }
                AppMethodBeat.o(202183);
                return bVar;
            }
        } catch (Throwable th) {
            AppMethodBeat.o(202183);
            return null;
        }
    }

    private JSONObject eXR() {
        AppMethodBeat.i(202184);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("snsid", String.valueOf(this.Dyz));
            jSONObject.put("uxinfo", Util.nullAs(this.DyA, ""));
            jSONObject.put("scene", this.mScene);
            jSONObject.put("adExtInfo", Util.nullAs(this.DyB, ""));
        } catch (Throwable th) {
        }
        AppMethodBeat.o(202184);
        return jSONObject;
    }

    private JSONObject eXS() {
        AppMethodBeat.i(202185);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adOffSetTop", this.DyC);
            jSONObject.put("clickPosX", this.DyD);
            jSONObject.put("clickPosY", this.DyE);
            if (this.DyF != null) {
                jSONObject.put("videoPlayTime", this.DyF.longValue());
            }
            jSONObject.put("buttonType", this.DyG);
        } catch (Throwable th) {
        }
        AppMethodBeat.o(202185);
        return jSONObject;
    }

    private String bie() {
        AppMethodBeat.i(202186);
        try {
            JSONObject eXR = eXR();
            eXR.put(IssueStorage.COLUMN_EXT_INFO, eXS());
            String jSONObject = eXR.toString();
            AppMethodBeat.o(202186);
            return jSONObject;
        } catch (Throwable th) {
            AppMethodBeat.o(202186);
            return "{}";
        }
    }

    private static View at(View view, int i2) {
        AppMethodBeat.i(202187);
        if (view != null) {
            while (true) {
                ViewParent parent = view.getParent();
                if (!(parent instanceof View)) {
                    break;
                }
                View view2 = (View) parent;
                if (view2.getId() == i2) {
                    view = view2;
                    break;
                }
                view = view2;
            }
        }
        AppMethodBeat.o(202187);
        return view;
    }

    @Override // com.tencent.mm.plugin.sns.ad.i.i.a
    public final String eWH() {
        return "timeline_ad_feedback_and_sns_button_click";
    }

    @Override // com.tencent.mm.plugin.sns.ad.i.i.a
    public final String getContent() {
        AppMethodBeat.i(202188);
        try {
            String bie = bie();
            AppMethodBeat.o(202188);
            return bie;
        } catch (Throwable th) {
            AppMethodBeat.o(202188);
            return "";
        }
    }
}
