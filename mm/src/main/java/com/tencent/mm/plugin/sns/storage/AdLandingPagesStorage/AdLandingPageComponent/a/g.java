package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.sns.ad.i.f;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.waid.b;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.bs;
import com.tencent.mm.protocal.protobuf.bt;
import com.tencent.mm.protocal.protobuf.bu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import org.json.JSONObject;

public final class g extends q implements m {
    private i callback;
    private d rr;

    public g(String str, String str2) {
        int i2 = 2;
        int i3 = 0;
        AppMethodBeat.i(97146);
        d.a aVar = new d.a();
        aVar.iLN = new bt();
        aVar.iLO = new bu();
        aVar.uri = "/cgi-bin/mmoc-bin/ad/adchannelmsg";
        aVar.funcId = 2538;
        this.rr = aVar.aXF();
        bt btVar = (bt) this.rr.iLK.iLR;
        bs bsVar = new bs();
        bsVar.KFB = 2;
        Context context = MMApplicationContext.getContext();
        if (NetStatusUtil.isWifi(context)) {
            i2 = 1;
        } else if (!NetStatusUtil.is2G(context)) {
            if (NetStatusUtil.is3G(context)) {
                i2 = 3;
            } else if (NetStatusUtil.is4G(context)) {
                i2 = 4;
            } else if (NetStatusUtil.is5G(context)) {
                i2 = 5;
            } else {
                i2 = 0;
            }
        }
        bsVar.KFy = i2;
        bsVar.Dsg = com.tencent.mm.plugin.sns.ad.b.a.aoK();
        bsVar.imei = com.tencent.mm.plugin.sns.ad.b.a.eWE();
        bsVar.KFG = com.tencent.mm.plugin.sns.ad.b.a.eWC();
        bsVar.KFF = f.eYk();
        PString pString = new PString();
        bsVar.KFH = b(str, str2, pString);
        bsVar.KFI = Util.nullAsNil(pString.value);
        btVar.KFJ = bsVar;
        btVar.dfC = str;
        btVar.content = str2;
        try {
            int i4 = TextUtils.isEmpty(bsVar.Dsg) ? 0 : 1;
            if (!TextUtils.isEmpty(bsVar.imei) && !"1234567890ABCDEF".equals(bsVar.imei)) {
                i3 = 1;
            }
            String aoz = k.aoz();
            String str3 = TextUtils.isEmpty(aoz) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1";
            String str4 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            if (bsVar.imei != null && bsVar.imei.equals(aoz)) {
                str4 = "1";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("##oaid:").append(bsVar.Dsg).append(", imei:").append(bsVar.imei).append(", rawImei:").append(aoz).append(", waid:").append(bsVar.KFH).append(", waidPkg:").append(bsVar.KFI).append(", common_device_id:").append(bsVar.KFG).append(", ua:").append(bsVar.KFF);
            Log.i("NetSceneAdLadingPageClick", sb.toString());
            j.b(j.DEc, str3, i4, i3, str4);
            AppMethodBeat.o(97146);
        } catch (Throwable th) {
            Log.e("NetSceneAdLadingPageClick", "adTecReport exp=" + th.toString());
            AppMethodBeat.o(97146);
        }
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(97147);
        Log.i("NetSceneAdLadingPageClick", "errType=" + i3 + ", errCode=" + i4 + ", errMsg=" + str);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(97147);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        AppMethodBeat.i(97148);
        int type = this.rr.getType();
        AppMethodBeat.o(97148);
        return type;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(97149);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(97149);
        return dispatch;
    }

    private static String b(String str, String str2, PString pString) {
        AppMethodBeat.i(203142);
        if (str2.contains("uxinfo")) {
            try {
                String optString = new JSONObject(str2).optString("uxinfo");
                if (TextUtils.isEmpty(optString)) {
                    Log.e("NetSceneAdLadingPageClick", "getWaid, has no uxinfo, channel=".concat(String.valueOf(str)));
                    AppMethodBeat.o(203142);
                    return "";
                }
                String waidPkgByUxInfo = ADInfo.getWaidPkgByUxInfo(optString);
                Log.i("NetSceneAdLadingPageClick", "getWaid, waidPkg=" + waidPkgByUxInfo + ", uxinfo=" + optString);
                if (!TextUtils.isEmpty(waidPkgByUxInfo)) {
                    pString.value = waidPkgByUxInfo;
                    String aRy = b.aRy(waidPkgByUxInfo);
                    AppMethodBeat.o(203142);
                    return aRy;
                }
            } catch (Throwable th) {
                Log.e("NetSceneAdLadingPageClick", "getWaid exop=" + th.toString());
            }
        }
        AppMethodBeat.o(203142);
        return "";
    }

    public static class a {
        public com.tencent.mm.ab.i Ecy = new com.tencent.mm.ab.i();
        com.tencent.mm.ab.i EiR = new com.tencent.mm.ab.i();

        public a(String str, int i2, int i3, long j2, int i4, String str2, String str3) {
            AppMethodBeat.i(179131);
            try {
                this.Ecy.h("uxinfo", str);
                this.Ecy.U("scene", i2);
                this.Ecy.U("originScene", i3);
                this.Ecy.v("canvasId", j2);
                this.Ecy.U("type", 21);
                this.Ecy.U("subType", i4);
                this.Ecy.U(NativeProtocol.WEB_DIALOG_ACTION, 1);
                if (!Util.isNullOrNil(str2, str3)) {
                    this.Ecy.h("viewid", str2);
                    this.Ecy.h("commInfo", str3);
                }
                AppMethodBeat.o(179131);
            } catch (Exception e2) {
                Log.e("NetSceneAdLadingPageClick", "ContentBuilder exp=" + e2.toString());
                AppMethodBeat.o(179131);
            }
        }

        public final com.tencent.mm.ab.i kv(String str, String str2) {
            AppMethodBeat.i(97142);
            try {
                this.EiR.h(str, Util.nullAsNil(str2));
            } catch (Exception e2) {
                Log.e("NetSceneAdLadingPageClick", "appendExtInfo exp=" + e2.toString());
            }
            com.tencent.mm.ab.i iVar = this.EiR;
            AppMethodBeat.o(97142);
            return iVar;
        }

        public final com.tencent.mm.ab.i bo(String str, long j2) {
            AppMethodBeat.i(97143);
            try {
                this.EiR.v(str, j2);
            } catch (Exception e2) {
                Log.e("NetSceneAdLadingPageClick", "appendExtInfo exp=" + e2.toString());
            }
            com.tencent.mm.ab.i iVar = this.EiR;
            AppMethodBeat.o(97143);
            return iVar;
        }

        private String build() {
            AppMethodBeat.i(97144);
            try {
                this.Ecy.h(IssueStorage.COLUMN_EXT_INFO, this.EiR);
            } catch (Exception e2) {
                Log.e("NetSceneAdLadingPageClick", "build exp=" + e2.toString());
            }
            String iVar = this.Ecy.toString();
            AppMethodBeat.o(97144);
            return iVar;
        }

        public final void report(String str) {
            AppMethodBeat.i(203141);
            try {
                String build = build();
                AdLandingPagesProxy.getInstance().onAdLandingPageClick(str, build);
                Log.i("NetSceneAdLadingPageClick", "report, channel=" + str + ", content=" + build);
                AppMethodBeat.o(203141);
            } catch (Exception e2) {
                Log.e("NetSceneAdLadingPageClick", "report exp=" + e2.toString());
                AppMethodBeat.o(203141);
            }
        }
    }
}
