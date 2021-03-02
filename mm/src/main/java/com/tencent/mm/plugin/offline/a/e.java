package com.tencent.mm.plugin.offline.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.hilive.mediasdk.SdkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.cun;
import com.tencent.mm.protocal.protobuf.cuo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.ui.f;
import org.json.JSONObject;

public final class e extends w {
    public String AJn = "";
    public int AJo = -1;
    public String AJp = "";
    public int AJq = 1;
    public RealnameGuideHelper AJr;
    private String AJs;
    private String AJt;
    private String AJu;
    private String AJv;
    private String AJw;
    private i callback;
    public int dDN = -1;
    private String qwn = "";
    private final d rr;

    public e(int i2, String str, String str2, String str3) {
        AppMethodBeat.i(66289);
        d.a aVar = new d.a();
        aVar.iLN = new cun();
        aVar.iLO = new cuo();
        aVar.uri = "/cgi-bin/mmpay-bin/offlinepayconfirm";
        aVar.funcId = SdkInfo.ErrCode.kErrCodeFormatUnSupport;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        aVar.routeInfo = f.bpA(str3);
        this.rr = aVar.aXF();
        cun cun = (cun) this.rr.iLK.iLR;
        cun.MzP = i2;
        cun.Id = str;
        cun.kdF = str2;
        cun.Lcc = k.fQy();
        this.AJq = i2;
        AppMethodBeat.o(66289);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return SdkInfo.ErrCode.kErrCodeFormatUnSupport;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(66290);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(66290);
        return dispatch;
    }

    @Override // com.tencent.mm.wallet_core.c.w
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr, long j2) {
        AppMethodBeat.i(66291);
        if (i3 != 0) {
            Log.e("MicroMsg.NetSceneOfflinePayConfirm", "Cmd : " + getType() + ", errType = " + i3 + ", errCode = " + i4 + ", errMsg = " + str);
        }
        cuo cuo = (cuo) ((d) sVar).iLL.iLR;
        if (i3 == 0 && i4 == 0) {
            try {
                if (cuo.LYE != null) {
                    JSONObject jSONObject = new JSONObject(cuo.LYE);
                    this.AJn = jSONObject.optString(FirebaseAnalytics.b.TRANSACTION_ID);
                    this.dDN = jSONObject.optInt("retcode");
                    this.qwn = jSONObject.optString("retmsg");
                    this.AJo = jSONObject.optInt("wx_error_type");
                    this.AJp = jSONObject.optString("wx_error_msg");
                    Log.d("MicroMsg.NetSceneOfflinePayConfirm", "onGYNetEnd %s", jSONObject.toString());
                    if (jSONObject.has("real_name_info")) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
                        this.AJs = optJSONObject.optString("guide_flag");
                        this.AJt = optJSONObject.optString("guide_wording");
                        this.AJu = optJSONObject.optString("left_button_wording");
                        this.AJv = optJSONObject.optString("right_button_wording");
                        this.AJw = optJSONObject.optString("upload_credit_url");
                        if ("1".equals(this.AJs) || "2".equals(this.AJs)) {
                            this.AJr = new RealnameGuideHelper();
                            this.AJr.b(this.AJs, this.AJt, this.AJu, this.AJv, this.AJw, 0);
                        }
                    }
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.NetSceneOfflinePayConfirm", e2, "", new Object[0]);
                i3 = 1000;
                i4 = 2;
                str = MMApplicationContext.getContext().getString(R.string.ibn);
            }
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(66291);
    }
}
