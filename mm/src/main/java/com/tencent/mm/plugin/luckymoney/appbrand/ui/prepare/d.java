package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.plugin.luckymoney.appbrand.a.e;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.d;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.dos;
import com.tencent.mm.protocal.protobuf.dot;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.c.a;

public final class d implements a, MMActivity.a {
    private String appId = null;
    c yRd;
    dot yRe;
    boolean yRf;
    final int yRg = (hashCode() & 65535);

    public d() {
        AppMethodBeat.i(64978);
        AppMethodBeat.o(64978);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.content.Intent] */
    @Override // com.tencent.mm.plugin.luckymoney.appbrand.ui.a
    public final /* synthetic */ void d(c cVar, Intent intent) {
        AppMethodBeat.i(64985);
        Log.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "onCreate ");
        this.appId = intent.getStringExtra("appId");
        this.yRd = cVar;
        AppMethodBeat.o(64985);
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.ui.a
    public final void onDestroy() {
        AppMethodBeat.i(64979);
        Log.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "onDestroy ");
        this.yRd = null;
        AppMethodBeat.o(64979);
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.a
    public final void d(int i2, int i3, String str, int i4) {
        AppMethodBeat.i(64980);
        Log.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareRandomLuckyMoney() called with: moneyTotalAmount = [" + i2 + "], packageAmount = [" + i3 + "], wishing = [" + str + "], scope = [" + i4 + "]");
        if (this.yRd == null) {
            AppMethodBeat.o(64980);
            return;
        }
        dos dos = new dos();
        dos.dNI = this.appId;
        dos.yPJ = 1;
        dos.KBv = i3;
        dos.MBH = (long) i2;
        dos.yPK = str;
        dos.MRW = i4;
        a(dos);
        AppMethodBeat.o(64980);
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.a
    public final void e(int i2, int i3, String str, int i4) {
        AppMethodBeat.i(64981);
        Log.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareFixLuckyMoney() called with: packageMoneyAmount = [" + i2 + "], packageAmount = [" + i3 + "], wishing = [" + str + "], scope = [" + i4 + "]");
        if (this.yRd == null) {
            AppMethodBeat.o(64981);
            return;
        }
        dos dos = new dos();
        dos.dNI = this.appId;
        dos.yPJ = 0;
        dos.KBv = i3;
        dos.MRV = i2;
        dos.yPK = str;
        dos.MRW = i4;
        a(dos);
        AppMethodBeat.o(64981);
    }

    private void a(dos dos) {
        AppMethodBeat.i(64982);
        Log.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareImpl ");
        if (this.yRf) {
            Log.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareImpl isRequesting");
            AppMethodBeat.o(64982);
            return;
        }
        this.yRf = true;
        new e(dos).b(new a<Void, c.a<dot>>() {
            /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.d.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(c.a<dot> aVar) {
                AppMethodBeat.i(64976);
                c.a<dot> aVar2 = aVar;
                if (aVar2.errType == 0 && aVar2.errCode == 0) {
                    d.this.yRe = (dot) aVar2.iLC;
                    if (d.this.yRe == null) {
                        d.this.aG(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error Request resp is nil}}"));
                    } else if (d.this.yRe.MBD != 0 || d.this.yRe.wFL.equalsIgnoreCase("")) {
                        Log.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "CgiRequestWxaHB fail.  sendid = [%s] reqkey = [%s] wxahb_status = [%d]", d.this.yRe.MBB, d.this.yRe.wFL, Integer.valueOf(d.this.yRe.MBD));
                        d.this.aG(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error Request errStatus = " + d.this.yRe.MBD + ",errMsg" + d.this.yRe.MBO + "}}"));
                        AppMethodBeat.o(64976);
                        return null;
                    } else {
                        Log.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "CgiRequestWxaHB succeed sendid = [%s] reqkey = [%s]", ((dot) aVar2.iLC).MBB, ((dot) aVar2.iLC).wFL);
                        d dVar = d.this;
                        String str = d.this.yRe.wFL;
                        if (dVar.yRd == null) {
                            Log.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "doWalletPay() called with: ui == null");
                        } else {
                            MMActivity eeF = dVar.yRd.eeF();
                            eeF.mmSetOnActivityResultCallback(dVar);
                            PayInfo payInfo = new PayInfo();
                            payInfo.dDL = str;
                            payInfo.dVv = 37;
                            payInfo.channel = 50;
                            f.a(eeF, payInfo, dVar.yRg);
                        }
                        AppMethodBeat.o(64976);
                        return null;
                    }
                }
                Log.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "CgiRequestWxaHB fail. [%d, %d, %s]", Integer.valueOf(aVar2.errType), Integer.valueOf(aVar2.errCode), aVar2.errMsg);
                d.this.aG(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error Request errType = " + aVar2.errType + ",errCode" + aVar2.errCode + "}}"));
                AppMethodBeat.o(64976);
                return null;
            }
        });
        AppMethodBeat.o(64982);
    }

    /* access modifiers changed from: package-private */
    public final void aG(Intent intent) {
        AppMethodBeat.i(64983);
        this.yRf = false;
        if (this.yRd == null) {
            AppMethodBeat.o(64983);
            return;
        }
        this.yRd.f(0, intent);
        AppMethodBeat.o(64983);
    }

    @Override // com.tencent.mm.ui.MMActivity.a
    public final void d(int i2, int i3, Intent intent) {
        AppMethodBeat.i(64984);
        Log.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "mmOnActivityResult() called with: requestCode = [" + i2 + "], resultCode = [" + i3 + "], data = [" + intent + "]");
        if (i2 == this.yRg) {
            if (i3 == -1) {
                this.yRd.a(b.class, new Intent(), new d.a() {
                    /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.d.AnonymousClass2 */

                    @Override // com.tencent.mm.plugin.luckymoney.appbrand.ui.d.a
                    public final void g(int i2, Intent intent) {
                        AppMethodBeat.i(64977);
                        Intent putExtra = new Intent().putExtra("sendId", d.this.yRe.MBB);
                        if (i2 == -1) {
                            putExtra.putExtra("result_share_msg", true);
                        } else {
                            putExtra.putExtra("result_share_msg", false);
                        }
                        d dVar = d.this;
                        dVar.yRf = false;
                        if (dVar.yRd != null) {
                            dVar.yRd.f(-1, putExtra);
                        }
                        AppMethodBeat.o(64977);
                    }
                });
                AppMethodBeat.o(64984);
                return;
            }
            Log.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "mmOnActivityResult() REQUEST_CODE_WALLET called cancel ");
            aG(new Intent().putExtra("result_error_code", 10001).putExtra("result_error_msg", "fail:pay fail"));
        }
        AppMethodBeat.o(64984);
    }
}
