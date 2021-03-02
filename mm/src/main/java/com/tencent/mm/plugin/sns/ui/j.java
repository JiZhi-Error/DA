package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.ad.e.h;
import com.tencent.mm.plugin.sns.ad.timeline.a.c;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.data.b;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;

public class j implements q.a {
    private ai Epj;
    Activity activity;
    public int source = 0;

    public j(Activity activity2, int i2, ai aiVar) {
        this.activity = activity2;
        this.source = i2;
        this.Epj = aiVar;
    }

    private ADInfo g(SnsInfo snsInfo) {
        AppMethodBeat.i(97834);
        if (snsInfo == null) {
            AppMethodBeat.o(97834);
            return null;
        } else if (this.source == 2) {
            ADInfo atAdInfo = snsInfo.getAtAdInfo();
            AppMethodBeat.o(97834);
            return atAdInfo;
        } else {
            ADInfo adInfo = snsInfo.getAdInfo();
            AppMethodBeat.o(97834);
            return adInfo;
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.span.q.a
    public void b(View view, Object obj) {
        String str;
        long j2;
        k tP;
        k tP2;
        AppMethodBeat.i(97835);
        Intent intent = new Intent();
        if (this.activity == null) {
            AppMethodBeat.o(97835);
            return;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            Log.d("Micro.ClickableCallBack", "onClick : " + bVar.userName + " activity: " + (this.activity == null) + ", source=" + this.source);
            SnsInfo aQm = aj.faO().aQm(bVar.dJX);
            if (bVar.isAd) {
                ADXml adXml = aQm.getAdXml();
                String str2 = g(aQm).viewId;
                int i2 = bVar.jkU > 0 ? bVar.jkU : 2;
                SnsAdClick snsAdClick = new SnsAdClick(this.source, this.source == 0 ? 1 : 2, aQm.getAdSnsInfo().field_snsId, i2, 0);
                com.tencent.mm.plugin.sns.ad.g.k kVar = null;
                if (this.activity instanceof SnsTimeLineUI) {
                    kVar = ((SnsTimeLineUI) this.activity).fjf();
                } else if (this.activity instanceof SnsCommentDetailUI) {
                    kVar = ((SnsCommentDetailUI) this.activity).EBv;
                }
                com.tencent.mm.plugin.sns.data.k.a(snsAdClick, kVar, aQm, i2);
                if (adXml != null) {
                    if (adXml.headClickType == 1 && !Util.isNullOrNil(adXml.headClickParam)) {
                        String str3 = adXml.headClickParam;
                        ADInfo g2 = g(aQm);
                        if (g2 != null) {
                            str3 = r.kb(str3, g2.uxInfo);
                        }
                        Log.i("Micro.ClickableCallBack", "headClickParam url " + str3 + " " + adXml.headClickRightBarShow);
                        Intent intent2 = new Intent();
                        boolean z = adXml.headClickRightBarShow == 0;
                        intent2.putExtra("KsnsViewId", str2);
                        intent2.putExtra("KRightBtn", z);
                        intent2.putExtra("jsapiargs", new Bundle());
                        intent2.putExtra("rawUrl", str3);
                        intent2.putExtra("useJs", true);
                        a.jRt.i(intent2, this.activity);
                        r.a(snsAdClick);
                        AppMethodBeat.o(97835);
                        return;
                    } else if (h.b(this.activity, adXml, g(aQm), aQm.field_snsId, 1)) {
                        com.tencent.mm.plugin.sns.ad.i.j.a(snsAdClick, 41);
                        r.a(snsAdClick);
                        AppMethodBeat.o(97835);
                        return;
                    } else {
                        d dVar = new d();
                        dVar.put("ext_sns_ad_click", (Object) snsAdClick);
                        c d2 = com.tencent.mm.plugin.sns.ad.timeline.a.a.d(1, this.activity);
                        if (d2 != null && d2.a(view, this.source, aQm, dVar)) {
                            AppMethodBeat.o(97835);
                            return;
                        }
                    }
                }
                this.Epj.fat().e(aQm, false);
                if (bVar.userName.endsWith("@ad")) {
                    AppMethodBeat.o(97835);
                    return;
                }
                com.tencent.mm.plugin.sns.ad.i.j.a(snsAdClick, 40);
                r.a(snsAdClick);
                intent.putExtra("Contact_User", bVar.userName);
                intent.putExtra("KSnsAdTag", snsAdClick);
                intent.putExtra("Contact_Scene", 79);
                intent.putExtra("CONTACT_INFO_UI_SOURCE", this.source == 0 ? 6 : 1);
                a.jRt.c(intent, this.activity);
                Log.i("Micro.ClickableCallBack", "startContactInfo, addScene=79");
                AppMethodBeat.o(97835);
                return;
            }
            str = bVar.userName;
            if (this.source == 0) {
                tP = k.tO(719);
            } else {
                tP = k.tP(719);
            }
            tP.PH(r.v(aQm)).tR(aQm.field_type).fL(aQm.isAd()).PH(aQm.getUxinfo()).PH(str);
            tP.bfK();
            if (this.source == 0) {
                tP2 = k.tO(746);
            } else {
                tP2 = k.tP(746);
            }
            tP2.PH(str).fL(str.endsWith(z.aTY()));
            tP2.b(intent, "intent_key_StatisticsOplog");
            if (this.source == 0) {
                this.Epj.fat().e(aQm, false);
            }
        } else {
            str = (String) obj;
            g.aAi();
            as bjJ = ((l) g.af(l.class)).aSN().bjJ(str);
            if (bjJ != null && bjJ.gBM()) {
                intent.putExtra("Contact_User", str);
                intent.putExtra("Contact_Scene", 37);
                intent.putExtra("CONTACT_INFO_UI_SOURCE", this.source);
                a.jRt.c(intent, this.activity);
                AppMethodBeat.o(97835);
                return;
            } else if (this.source == 0) {
                SnsInfo snsInfo = new SnsInfo();
                snsInfo.setUserName(str);
                this.Epj.fat().e(snsInfo, false);
            }
        }
        intent.putExtra("Contact_User", str);
        intent.putExtra("CONTACT_INFO_UI_SOURCE", this.source);
        a.jRt.c(intent, this.activity);
        com.tencent.mm.plugin.textstatus.a.c cVar = (com.tencent.mm.plugin.textstatus.a.c) g.ah(com.tencent.mm.plugin.textstatus.a.c.class);
        if (this.source == 0) {
            j2 = 6;
        } else {
            j2 = this.source == 13 ? 7 : 8;
        }
        cVar.report22210(str, j2);
        AppMethodBeat.o(97835);
    }
}
