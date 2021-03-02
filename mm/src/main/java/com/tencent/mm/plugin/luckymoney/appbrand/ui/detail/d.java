package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.plugin.luckymoney.appbrand.a.c;
import com.tencent.mm.plugin.luckymoney.appbrand.a.f;
import com.tencent.mm.protocal.protobuf.cai;
import com.tencent.mm.protocal.protobuf.cxg;
import com.tencent.mm.protocal.protobuf.din;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public final class d implements a {
    private String appId;
    boolean isLoading = false;
    b yQD;
    private String yQE;
    int yQF = 0;
    final List<cai> yQG = new LinkedList();

    public d() {
        AppMethodBeat.i(64933);
        AppMethodBeat.o(64933);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.content.Intent] */
    @Override // com.tencent.mm.plugin.luckymoney.appbrand.ui.a
    public final /* synthetic */ void d(b bVar, Intent intent) {
        AppMethodBeat.i(64938);
        this.yQD = bVar;
        this.yQE = intent.getStringExtra("key_sendid");
        this.appId = intent.getStringExtra("key_appid");
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_data");
        String stringExtra = intent.getStringExtra("key_from");
        if (stringExtra != null && stringExtra.equalsIgnoreCase("value_open")) {
            cxg bH = bH(byteArrayExtra);
            if (bH == null) {
                Log.e("MicroMsg.WxaLuckyMoneyLogicDetail", "parse OpenWxaHBResponse failed.");
            } else {
                this.yQF = bH.MBN;
                this.yQG.addAll(bH.MBI);
                this.yQD.eeG();
                this.yQD.a(bH);
                AppMethodBeat.o(64938);
                return;
            }
        }
        PD(0);
        AppMethodBeat.o(64938);
    }

    private static cxg bH(byte[] bArr) {
        AppMethodBeat.i(64934);
        if (bArr == null || bArr.length == 0) {
            Log.e("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom failed. No data found.");
            AppMethodBeat.o(64934);
            return null;
        }
        cxg cxg = new cxg();
        try {
            cxg.parseFrom(bArr);
            Log.i("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom succeed.");
            AppMethodBeat.o(64934);
            return cxg;
        } catch (IOException e2) {
            Log.e("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom failed. IOException: %s", e2);
            AppMethodBeat.o(64934);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.ui.a
    public final void onDestroy() {
        AppMethodBeat.i(64935);
        Log.i("MicroMsg.WxaLuckyMoneyLogicDetail", "onDestroy() called");
        this.yQD = null;
        AppMethodBeat.o(64935);
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.a
    public final void PB(int i2) {
        AppMethodBeat.i(64936);
        if (this.yQD == null) {
            Log.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage ui == null");
            AppMethodBeat.o(64936);
        } else if (i2 < this.yQG.size()) {
            Log.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage. offset = [%d], list.size() = [%d], skip load", Integer.valueOf(i2), Integer.valueOf(this.yQG.size()));
            AppMethodBeat.o(64936);
        } else if (this.isLoading) {
            Log.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage failed. is loading now...");
            AppMethodBeat.o(64936);
        } else if (this.yQF == 0) {
            Log.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage failed. do not has more...");
            AppMethodBeat.o(64936);
        } else {
            Log.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage load");
            this.isLoading = true;
            PD(i2);
            AppMethodBeat.o(64936);
        }
    }

    private void PD(final int i2) {
        AppMethodBeat.i(64937);
        new c(this.appId, this.yQE, i2).b(new f<c.a<din>>() {
            /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.d.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.plugin.luckymoney.appbrand.a.f
            public final /* synthetic */ void dv(c.a<din> aVar) {
                AppMethodBeat.i(64932);
                c.a<din> aVar2 = aVar;
                d.this.isLoading = false;
                if (d.this.yQD == null) {
                    Log.e("MicroMsg.WxaLuckyMoneyLogicDetail", "CgiQueryWxaHB got its response. but ui is destroyed.");
                    AppMethodBeat.o(64932);
                } else if (aVar2.errType != 0 || aVar2.errCode != 0) {
                    Log.e("MicroMsg.WxaLuckyMoneyLogicDetail", "CgiQueryWxaHB failed [%d, %d, %s]", Integer.valueOf(aVar2.errType), Integer.valueOf(aVar2.errCode), aVar2.errMsg);
                    d.a(d.this, aVar2.errMsg, new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error query errType = " + aVar2.errType + ",errCode" + aVar2.errCode + "}}"));
                    AppMethodBeat.o(64932);
                } else if (((din) aVar2.iLC).MBD != 0) {
                    Log.e("MicroMsg.WxaLuckyMoneyLogicDetail", "CgiQueryWxaHB error wxahb_status = [%d] errorwording = [%s]", Integer.valueOf(((din) aVar2.iLC).MBD), ((din) aVar2.iLC).MBO);
                    d.a(d.this, ((din) aVar2.iLC).MBO, new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error query red packet fail errStatus = " + ((din) aVar2.iLC).MBD + ",errMsg" + ((din) aVar2.iLC).MBO + "}}"));
                    AppMethodBeat.o(64932);
                } else {
                    Log.i("MicroMsg.WxaLuckyMoneyLogicDetail", "CgiQueryWxaHB succeed. hasmore = [%b] rcvd_user_list.size() = [%d], currentlist.size = [%d]", Integer.valueOf(((din) aVar2.iLC).MBN), Integer.valueOf(((din) aVar2.iLC).MBI.size()), Integer.valueOf(d.this.yQG.size()));
                    d.this.yQF = ((din) aVar2.iLC).MBN;
                    d.this.yQG.addAll(((din) aVar2.iLC).MBI);
                    d.this.yQD.eeG();
                    if (i2 == 0) {
                        d.this.yQD.a((din) aVar2.iLC);
                        AppMethodBeat.o(64932);
                        return;
                    }
                    d.this.yQD.fp(d.this.yQG);
                    AppMethodBeat.o(64932);
                }
            }
        });
        AppMethodBeat.o(64937);
    }

    static /* synthetic */ void a(d dVar, String str, Intent intent) {
        AppMethodBeat.i(64939);
        if (dVar.yQD == null) {
            Log.e("MicroMsg.WxaLuckyMoneyLogicDetail", "fail ui == null");
            AppMethodBeat.o(64939);
            return;
        }
        dVar.yQD.eeG();
        dVar.yQD.error(str);
        dVar.yQD.aF(intent);
        AppMethodBeat.o(64939);
    }
}
