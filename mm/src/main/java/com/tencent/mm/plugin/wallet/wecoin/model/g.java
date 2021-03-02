package com.tencent.mm.plugin.wallet.wecoin.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.wallet.wecoin.a.c;
import com.tencent.mm.plugin.wallet.wecoin.a.d;
import com.tencent.mm.plugin.wallet.wecoin.a.e;
import com.tencent.mm.plugin.wallet.wecoin.b.f;
import com.tencent.mm.plugin.wallet.wecoin.model.e;
import com.tencent.mm.plugin.wallet.wecoin.model.h;
import com.tencent.mm.plugin.wallet.wecoin.ui.WeCoinIncomeDetailView;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.adm;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.cdg;
import com.tencent.mm.protocal.protobuf.ddc;
import com.tencent.mm.protocal.protobuf.den;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.vending.c.a;

public final class g implements c {
    static /* synthetic */ void K(String str, int i2, String str2) {
        AppMethodBeat.i(214158);
        a(str, 2, 3, i2, str2);
        AppMethodBeat.o(214158);
    }

    @Override // com.tencent.mm.plugin.wallet.wecoin.a.c
    public final void a(Context context, final e<Boolean> eVar) {
        AppMethodBeat.i(214149);
        if (context == null) {
            Log.e("MicroMsg.WeCoinManagerImplement", "initEngine context is null.");
            h.RTc.aV(new Runnable() {
                /* class com.tencent.mm.plugin.wallet.wecoin.model.g.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(214140);
                    if (eVar != null) {
                        eVar.p(3, -2, "");
                    }
                    AppMethodBeat.o(214140);
                }
            });
            AppMethodBeat.o(214149);
            return;
        }
        h.a aVar = h.HNL;
        h.HNK.b(context, eVar);
        AppMethodBeat.o(214149);
    }

    @Override // com.tencent.mm.plugin.wallet.wecoin.a.c
    public final boolean dfq() {
        boolean z;
        AppMethodBeat.i(214150);
        boolean equalsIgnoreCase = WeChatBrands.AppInfo.LANG_CN.equalsIgnoreCase(Util.nullAs((String) com.tencent.mm.kernel.g.aAh().azQ().get(274436, (Object) null), WeChatBrands.AppInfo.LANG_CN));
        Log.i("MicroMsg.WeCoinManagerImplement", "isWeCoinEntranceAvailable, isChinaReg: %s", Boolean.valueOf(equalsIgnoreCase));
        if (equalsIgnoreCase) {
            int a2 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_close_wecoin_entrance, 0);
            Log.i("MicroMsg.WeCoinUtils", "isWeCoinEntranceABTestHit, %s", Integer.valueOf(a2));
            if (a2 == 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                AppMethodBeat.o(214150);
                return true;
            }
        }
        AppMethodBeat.o(214150);
        return false;
    }

    @Override // com.tencent.mm.plugin.wallet.wecoin.a.c
    public final Long hXF() {
        AppMethodBeat.i(258734);
        Long valueOf = Long.valueOf(com.tencent.mm.plugin.wallet.wecoin.c.c.hXG());
        AppMethodBeat.o(258734);
        return valueOf;
    }

    @Override // com.tencent.mm.plugin.wallet.wecoin.a.c
    public final void a(final e<Long> eVar) {
        AppMethodBeat.i(214151);
        new f().aYI().b(new a<Object, c.a<byn>>() {
            /* class com.tencent.mm.plugin.wallet.wecoin.model.g.AnonymousClass5 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(c.a<byn> aVar) {
                AppMethodBeat.i(214145);
                c.a<byn> aVar2 = aVar;
                Log.i("MicroMsg.WeCoinManagerImplement", "CgiGetWecoinBalanceRequest errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(aVar2.errType), Integer.valueOf(aVar2.errCode), aVar2.errMsg);
                if (com.tencent.mm.plugin.wallet.wecoin.c.c.h(aVar2)) {
                    if (eVar != null) {
                        eVar.p(aVar2.errType, aVar2.errCode, aVar2.errMsg);
                    }
                    AppMethodBeat.o(214145);
                } else {
                    byn byn = (byn) aVar2.iLC;
                    if (byn == null) {
                        if (eVar != null) {
                            eVar.p(3, -1, "");
                        }
                        AppMethodBeat.o(214145);
                    } else {
                        if (eVar != null) {
                            Log.i("MicroMsg.WeCoinManagerImplement", "CgiGetWecoinBalanceRequest response.balance: %s", Long.valueOf(byn.MdV));
                            com.tencent.mm.plugin.wallet.wecoin.c.c.LS(byn.MdV);
                            eVar.onSuccess(Long.valueOf(byn.MdV));
                        }
                        AppMethodBeat.o(214145);
                    }
                }
                return null;
            }
        });
        AppMethodBeat.o(214151);
    }

    @Override // com.tencent.mm.plugin.wallet.wecoin.a.c
    public final void a(Context context, final String str, byte[] bArr, final e<Long> eVar) {
        cdg cdg;
        AppMethodBeat.i(214152);
        if (bArr == null) {
            Log.e("MicroMsg.WeCoinManagerImplement", "consumeWeCoin contextBuff is null");
            a(str, 1, 3, 3, "consumeWeCoin contextBuff is null");
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1581, 72);
            com.tencent.f.h.RTc.aV(new Runnable() {
                /* class com.tencent.mm.plugin.wallet.wecoin.model.g.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(214146);
                    if (eVar != null) {
                        eVar.p(3, -2, "");
                    }
                    AppMethodBeat.o(214146);
                }
            });
            AppMethodBeat.o(214152);
            return;
        }
        final den den = new den();
        try {
            den.parseFrom(bArr);
            com.tencent.mm.plugin.wallet.wecoin.c.c.d("MicroMsg.WeCoinManagerImplement", den);
            BaseResponse baseResponse = den.BaseResponse;
            if (baseResponse == null || baseResponse.Ret == 0) {
                a(den, str, eVar, false);
                AppMethodBeat.o(214152);
                return;
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1581, 72);
            int i2 = baseResponse.Ret;
            String str2 = "";
            if (den.MJy != null) {
                Log.i("MicroMsg.WeCoinManagerImplement", "consumeWeCoin intercept_info is not null");
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1581, 77);
                i2 = 10000;
                str2 = den.MJy.dQx;
                if (!(context == null || (cdg = den.MJy) == null)) {
                    com.tencent.mm.plugin.wallet.wecoin.c.c.a(context, cdg, new b() {
                        /* class com.tencent.mm.plugin.wallet.wecoin.model.g.AnonymousClass4 */

                        @Override // com.tencent.mm.plugin.wallet.wecoin.model.b
                        public final void a(ddc ddc) {
                            AppMethodBeat.i(214144);
                            if (ddc != null && ddc.action == 3) {
                                g.this.a(den, str, eVar, false);
                            }
                            AppMethodBeat.o(214144);
                        }
                    });
                }
            }
            if (baseResponse.ErrMsg != null && baseResponse.ErrMsg.MTp) {
                str2 = baseResponse.ErrMsg.MTo;
            }
            Log.i("MicroMsg.WeCoinManagerImplement", "serialize PrepareWecoinConsumeResponse, errCode: %s, errMsg: %s", Integer.valueOf(baseResponse.Ret), str2);
            eVar.p(4, i2, str2);
            a(str, 1, 3, baseResponse.Ret, str2);
            AppMethodBeat.o(214152);
        } catch (Exception e2) {
            a(str, 1, 3, 3, "parse response failed");
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1581, 72);
            Log.e("MicroMsg.WeCoinManagerImplement", "parse PrepareWecoinConsumeResponse failed, exception: %s", e2.getMessage());
            com.tencent.f.h.RTc.aV(new Runnable() {
                /* class com.tencent.mm.plugin.wallet.wecoin.model.g.AnonymousClass7 */

                public final void run() {
                    AppMethodBeat.i(214147);
                    if (eVar != null) {
                        eVar.p(3, -1, "");
                    }
                    AppMethodBeat.o(214147);
                }
            });
            AppMethodBeat.o(214152);
        }
    }

    @Override // com.tencent.mm.plugin.wallet.wecoin.a.c
    public final d a(FragmentActivity fragmentActivity, int i2, String str, e<Boolean> eVar) {
        AppMethodBeat.i(214153);
        if (fragmentActivity == null) {
            AppMethodBeat.o(214153);
            return null;
        }
        e.a aVar = new e.a();
        aVar.HMJ = true;
        aVar.mScene = i2;
        aVar.HMK = str;
        aVar.HML = eVar;
        com.tencent.mm.plugin.wallet.wecoin.ui.a aVar2 = new com.tencent.mm.plugin.wallet.wecoin.ui.a(fragmentActivity, aVar.fPD());
        AppMethodBeat.o(214153);
        return aVar2;
    }

    @Override // com.tencent.mm.plugin.wallet.wecoin.a.c
    public final void bN(Context context, String str) {
        AppMethodBeat.i(214154);
        if (context == null) {
            AppMethodBeat.o(214154);
            return;
        }
        Intent intent = new Intent(context, WeCoinIncomeDetailView.class);
        intent.addFlags(268435456);
        intent.putExtra("wecoin_enter_encash_business_kv_data", new WecoinEncashKVData(1, str, ""));
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/wallet/wecoin/model/WeCoinManagerImplement", "startWeCoinIncomeDetailView", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/wallet/wecoin/model/WeCoinManagerImplement", "startWeCoinIncomeDetailView", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(214154);
    }

    @Override // com.tencent.mm.plugin.wallet.wecoin.a.c
    public final com.tencent.mm.plugin.wallet.wecoin.a.b aP(Activity activity) {
        AppMethodBeat.i(214155);
        if (activity == null) {
            AppMethodBeat.o(214155);
            return null;
        }
        com.tencent.mm.plugin.wallet.wecoin.ui.b bVar = new com.tencent.mm.plugin.wallet.wecoin.ui.b(activity);
        AppMethodBeat.o(214155);
        return bVar;
    }

    public final void a(final den den, final String str, final com.tencent.mm.plugin.wallet.wecoin.a.e<Long> eVar, boolean z) {
        AppMethodBeat.i(214156);
        com.tencent.mm.bw.b bVar = den.Loz;
        if (bVar == null) {
            a(str, 1, 3, 3, "contextByteString is null");
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1581, 72);
            Log.e("MicroMsg.WeCoinManagerImplement", "contextByteString is null");
            com.tencent.f.h.RTc.aV(new Runnable() {
                /* class com.tencent.mm.plugin.wallet.wecoin.model.g.AnonymousClass8 */

                public final void run() {
                    AppMethodBeat.i(214148);
                    if (eVar != null) {
                        eVar.p(3, -1, "");
                    }
                    AppMethodBeat.o(214148);
                }
            });
            AppMethodBeat.o(214156);
            return;
        }
        if (!z) {
            a(str, 1, 3, 0, "");
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1581, 71);
        }
        a(str, 2, 1, 0, "");
        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1581, 73);
        byte[] az = com.tencent.mm.network.b.bjq().az(bVar.zy);
        if (az == null) {
            Log.e("MicroMsg.WeCoinManagerImplement", "signData is null");
            a(str, 2, 3, 4, "sign data failed.");
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1581, 76);
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1581, 75);
            com.tencent.f.h.RTc.aV(new Runnable() {
                /* class com.tencent.mm.plugin.wallet.wecoin.model.g.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(214141);
                    if (eVar != null) {
                        eVar.p(3, -1, "");
                    }
                    AppMethodBeat.o(214141);
                }
            });
            AppMethodBeat.o(214156);
            return;
        }
        new com.tencent.mm.plugin.wallet.wecoin.b.b(bVar, str, new com.tencent.mm.bw.b(az)).aYI().b(new a<Object, c.a<adm>>() {
            /* class com.tencent.mm.plugin.wallet.wecoin.model.g.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(c.a<adm> aVar) {
                AppMethodBeat.i(214143);
                c.a<adm> aVar2 = aVar;
                Log.i("MicroMsg.WeCoinManagerImplement", "CgiConsumeWecoinRequest errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(aVar2.errType), Integer.valueOf(aVar2.errCode), aVar2.errMsg);
                adm adm = (adm) aVar2.iLC;
                if (com.tencent.mm.plugin.wallet.wecoin.c.c.h(aVar2)) {
                    g.K(str, aVar2.errCode, aVar2.errMsg);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1581, 75);
                    if (aVar2.errCode != 10001 || adm == null || adm.LoD == null) {
                        if (eVar != null) {
                            eVar.p(aVar2.errType, aVar2.errCode, aVar2.errMsg);
                        }
                        AppMethodBeat.o(214143);
                        return null;
                    }
                    Log.i("MicroMsg.WeCoinManagerImplement", "CgiConsumeWecoinRequest retry, retry time: %s", Integer.valueOf(adm.LoD.MSB));
                    com.tencent.f.h.RTc.o(new Runnable() {
                        /* class com.tencent.mm.plugin.wallet.wecoin.model.g.AnonymousClass3.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(214142);
                            g.this.a(den, str, eVar, true);
                            AppMethodBeat.o(214142);
                        }
                    }, (long) adm.LoD.MSB);
                } else if (adm == null) {
                    g.K(str, 3, "response is null");
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1581, 75);
                    if (eVar != null) {
                        eVar.p(3, -1, "");
                    }
                    AppMethodBeat.o(214143);
                    return null;
                } else {
                    g.K(str, 0, "");
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1581, 74);
                    if (eVar != null) {
                        Log.i("MicroMsg.WeCoinManagerImplement", "CgiConsumeWecoinRequest, balance: %s", Long.valueOf(adm.LoC));
                        com.tencent.mm.plugin.wallet.wecoin.c.c.LS(adm.LoC);
                        eVar.onSuccess(Long.valueOf(adm.LoC));
                    }
                }
                AppMethodBeat.o(214143);
                return null;
            }
        });
        AppMethodBeat.o(214156);
    }

    private static void a(String str, int i2, int i3, int i4, String str2) {
        AppMethodBeat.i(214157);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(22129, 1, str, "", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str2);
        AppMethodBeat.o(214157);
    }
}
