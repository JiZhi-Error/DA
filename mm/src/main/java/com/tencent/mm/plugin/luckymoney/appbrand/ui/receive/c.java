package com.tencent.mm.plugin.luckymoney.appbrand.ui.receive;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.plugin.luckymoney.appbrand.a.b;
import com.tencent.mm.plugin.luckymoney.appbrand.a.d;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.d;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.protocal.protobuf.cxg;
import com.tencent.mm.protocal.protobuf.dkk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.c.a;
import java.io.IOException;

public final class c implements a {
    private String appId = null;
    int state = -1;
    String yQE = null;
    b yRr = null;
    byte[] yRs;
    cxg yRt;
    public RealnameGuideHelper yRu;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.content.Intent] */
    @Override // com.tencent.mm.plugin.luckymoney.appbrand.ui.a
    public final /* synthetic */ void d(b bVar, Intent intent) {
        AppMethodBeat.i(65023);
        Log.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onCreate ");
        this.yRr = bVar;
        if (intent == null) {
            Log.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onCreate intent == null");
            aG(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{intent is null}}"));
            AppMethodBeat.o(65023);
            return;
        }
        this.appId = intent.getStringExtra("appId");
        this.yQE = intent.getStringExtra("sendId");
        if (Util.isNullOrNil(this.appId) || Util.isNullOrNil(this.yQE)) {
            Log.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onCreate appId = [%s] sendId = [%s]", this.appId, this.yQE);
            aG(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{appid or send is nil}}"));
            AppMethodBeat.o(65023);
            return;
        }
        new d(this.appId, this.yQE).b(new a<Void, c.a<dkk>>() {
            /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.c.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(c.a<dkk> aVar) {
                AppMethodBeat.i(65013);
                Void a2 = a(aVar);
                AppMethodBeat.o(65013);
                return a2;
            }

            private Void a(c.a<dkk> aVar) {
                boolean z;
                AppMethodBeat.i(182452);
                if (aVar.errType == 0 && aVar.errCode == 0) {
                    Log.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiReceiveWxaHB succeed, wxahb_status = [%d],receive_status = [%d],sendId = [%s]", Integer.valueOf(((dkk) aVar.iLC).MBD), Integer.valueOf(((dkk) aVar.iLC).yPI), c.this.yQE);
                    if (!(((dkk) aVar.iLC).MBD == 1 || ((dkk) aVar.iLC).MBC == null)) {
                        c.this.yRs = ((dkk) aVar.iLC).MBC.toByteArray();
                    }
                    c.this.state = ((dkk) aVar.iLC).MBD;
                    c cVar = c.this;
                    dkk dkk = (dkk) aVar.iLC;
                    if (cVar.yRr == null) {
                        Log.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiReceiveWxaHB succeed but ui == null");
                    } else {
                        if (dkk.MBM == 1 && dkk.yPJ == 0) {
                            z = true;
                        } else if (dkk.yPI == 2) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            Log.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onLuckyMoneyReceived shouldSkipToDetailUI");
                            cVar.eeO();
                        } else if (dkk.MBD == 1) {
                            cVar.yRr.a(dkk.MBK, dkk.MBL, dkk.MBD, dkk.MBO, dkk.MBM == 1, dkk.yPJ == 1);
                        } else if (dkk.MBD == 0) {
                            cVar.yRr.a(dkk.MBK, dkk.MBL, dkk.pWf, dkk.yPK, dkk.MBM == 1, dkk.yPJ == 1);
                        } else {
                            Log.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "back.resp.wxahb_status is invalid.resp. wxahb_status = [%d] receive_status = [%d] hb_type = [%d]", Integer.valueOf(dkk.MBD), Integer.valueOf(dkk.yPI), Integer.valueOf(dkk.yPJ));
                        }
                    }
                    AppMethodBeat.o(182452);
                    return null;
                }
                Log.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiReceiveWxaHB failed [%d, %d, %s]", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.errMsg);
                c.this.aG(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error Receive errType = " + aVar.errType + ",errCode" + aVar.errCode + "}}"));
                AppMethodBeat.o(182452);
                return null;
            }
        });
        AppMethodBeat.o(65023);
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.ui.a
    public final void onDestroy() {
        AppMethodBeat.i(65018);
        Log.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onDestroy ");
        this.yRr = null;
        this.yRt = null;
        this.yRu = null;
        AppMethodBeat.o(65018);
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.a
    public final void eeK() {
        AppMethodBeat.i(65019);
        if (this.yRr == null) {
            Log.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onDetailBtnClick ui == null");
            AppMethodBeat.o(65019);
            return;
        }
        eeO();
        AppMethodBeat.o(65019);
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.a
    public final void eeJ() {
        AppMethodBeat.i(65020);
        if (this.state != 0) {
            Log.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onOpenBtnClick return state = %d", Integer.valueOf(this.state));
            AppMethodBeat.o(65020);
        } else if (this.yRr == null) {
            Log.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "openLuckyMoney ui == null");
            AppMethodBeat.o(65020);
        } else {
            new b(this.appId, this.yQE, this.yRs).b(new a<Void, c.a<cxg>>() {
                /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.c.AnonymousClass2 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Void call(c.a<cxg> aVar) {
                    AppMethodBeat.i(65015);
                    Void a2 = a(aVar);
                    AppMethodBeat.o(65015);
                    return a2;
                }

                private Void a(c.a<cxg> aVar) {
                    AppMethodBeat.i(182453);
                    if (aVar.errType == 0 && aVar.errCode == 0) {
                        Log.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB success");
                        if (((cxg) aVar.iLC).MBD != 0) {
                            Log.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB error wxahb_status = [%d] errorwording = [%s]", Integer.valueOf(((cxg) aVar.iLC).MBD), ((cxg) aVar.iLC).MBO);
                            c cVar = c.this;
                            int i2 = ((cxg) aVar.iLC).MBD;
                            switch (i2) {
                                case 1:
                                    cVar.aG(new Intent().putExtra("result_error_code", 20001).putExtra("result_error_msg", "fail:the red packet is expired"));
                                    break;
                                case 2:
                                    cVar.aG(new Intent().putExtra("result_error_code", 20002).putExtra("result_error_msg", "fail:the red packet has been received completly"));
                                    break;
                                case 3:
                                    cVar.aG(new Intent().putExtra("result_error_code", 20003).putExtra("result_error_msg", "fail:risk control"));
                                    break;
                                default:
                                    cVar.aG(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{unknow open retun errCode:" + i2 + "}"));
                                    break;
                            }
                            AppMethodBeat.o(182453);
                        } else {
                            c cVar2 = c.this;
                            cxg cxg = (cxg) aVar.iLC;
                            if (cVar2.yRr == null) {
                                Log.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.CgiOpenWxaHB end. ui == null");
                            } else {
                                cVar2.yRt = cxg;
                                cVar2.yRr.eeL();
                                if (cVar2.yRt.LgT != null) {
                                    cVar2.yRu = new RealnameGuideHelper();
                                    cVar2.yRu.b(String.valueOf(cVar2.yRt.LgT.KCl), cVar2.yRt.LgT.yXJ, cVar2.yRt.LgT.lHA, cVar2.yRt.LgT.lHB, cVar2.yRt.LgT.yXK, 1003);
                                    RealnameGuideHelper realnameGuideHelper = cVar2.yRu;
                                    Bundle bundle = new Bundle();
                                    bundle.putString("realname_verify_process_jump_activity", ".appbrand.ui.receive.WxaLuckyMoneyReceiveUI");
                                    bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                                    if (!realnameGuideHelper.b(cVar2.yRr.eeF(), bundle, new DialogInterface.OnClickListener() {
                                        /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.c.AnonymousClass4 */

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            AppMethodBeat.i(65017);
                                            Log.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "RealnameGuideHelper dialog click cancel");
                                            c.this.aG(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{user cancel realname}}"));
                                            AppMethodBeat.o(65017);
                                        }
                                    })) {
                                        cVar2.aG(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{launch realname fail}}"));
                                    }
                                } else {
                                    cVar2.eeO();
                                }
                            }
                            AppMethodBeat.o(182453);
                        }
                    } else {
                        Log.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB failed [%d, %d, %s]", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.errMsg);
                        c.this.aG(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error open errType = " + aVar.errType + ",errCode" + aVar.errCode + "}}"));
                        AppMethodBeat.o(182453);
                    }
                    return null;
                }
            });
            AppMethodBeat.o(65020);
        }
    }

    /* access modifiers changed from: package-private */
    public final void eeO() {
        AppMethodBeat.i(65021);
        Intent intent = new Intent();
        intent.putExtra("key_sendid", this.yQE);
        intent.putExtra("key_appid", this.appId);
        if (this.yRt != null) {
            Bundle bundle = new Bundle();
            try {
                bundle.putByteArray("key_data", this.yRt.toByteArray());
                intent.putExtras(bundle);
                intent.putExtra("key_from", "value_open");
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.WxaReceiveLuckyMoneyLogic", e2, "goLuckyMoneyDetailUI WxaDetailResponse putByteArray error", new Object[0]);
                aG(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{byte detail response fail}}"));
                AppMethodBeat.o(65021);
                return;
            }
        } else {
            intent.putExtra("key_from", "value_query");
        }
        this.yRr.a(com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.b.class, intent, new d.a() {
            /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.c.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.luckymoney.appbrand.ui.d.a
            public final void g(int i2, Intent intent) {
                AppMethodBeat.i(65016);
                if (i2 == -1) {
                    c cVar = c.this;
                    if (cVar.yRr == null) {
                        Log.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.succeed ui == null");
                        AppMethodBeat.o(65016);
                        return;
                    }
                    cVar.yRr.eeG();
                    cVar.yRr.f(-1, new Intent());
                    AppMethodBeat.o(65016);
                    return;
                }
                c.this.aG(intent);
                AppMethodBeat.o(65016);
            }
        });
        AppMethodBeat.o(65021);
    }

    /* access modifiers changed from: package-private */
    public final void aG(Intent intent) {
        AppMethodBeat.i(65022);
        if (this.yRr == null) {
            Log.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.fail ui == null");
            AppMethodBeat.o(65022);
            return;
        }
        this.yRr.eeG();
        this.yRr.f(0, intent);
        AppMethodBeat.o(65022);
    }
}
