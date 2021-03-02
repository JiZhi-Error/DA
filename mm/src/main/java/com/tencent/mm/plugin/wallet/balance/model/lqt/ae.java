package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.UseCaseCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.cki;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.protocal.protobuf.cux;
import com.tencent.mm.protocal.protobuf.dgc;
import com.tencent.mm.protocal.protobuf.dhj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.HashMap;
import java.util.Map;

public final class ae {
    public static int Huu = 123;
    public static int Huv = 456;
    public static String Huw = "key_bind_serial";
    public String HuA;
    int HuB;
    public int HuC;
    public String HuD;
    public Bankcard HuE;
    public int HuF;
    public Map<String, String> HuG = new HashMap();
    private ac Hux = null;
    public ad Huy = null;
    public WalletBaseUI Huz = null;
    public int accountType;
    public String dDM;
    public b jSi;
    public int mode;

    static /* synthetic */ void a(ae aeVar, String str, int i2) {
        AppMethodBeat.i(213865);
        aeVar.fW(str, i2);
        AppMethodBeat.o(213865);
    }

    public ae() {
        AppMethodBeat.i(68535);
        AppMethodBeat.o(68535);
    }

    public ae(ac acVar, ad adVar, WalletBaseUI walletBaseUI) {
        AppMethodBeat.i(68536);
        this.Hux = acVar;
        this.Huy = adVar;
        this.Huz = walletBaseUI;
        this.mode = 1;
        AppMethodBeat.o(68536);
    }

    public final void fW(final String str, int i2) {
        AppMethodBeat.i(213863);
        Log.i("MicroMsg.LqtSaveFetchLogic", "doQueryPurchaseResult");
        this.Huz.showLoading(false);
        this.Huy.Huq.a(this.HuA, this.dDM, this.HuB, this.accountType, this.Huz.getIntent().getStringExtra("operate_id"), this.HuF, i2).f(new a<Void, dhj>() {
            /* class com.tencent.mm.plugin.wallet.balance.model.lqt.ae.AnonymousClass12 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(dhj dhj) {
                AppMethodBeat.i(68532);
                dhj dhj2 = dhj;
                Log.i("MicroMsg.LqtSaveFetchLogic", "doQueryPurchaseResult finish: %s", dhj2);
                ae.this.Huz.hideLoading();
                ae.this.aUG(str);
                if (ae.this.jSi != null) {
                    ae.this.jSi.G(dhj2);
                }
                Void r0 = QZL;
                AppMethodBeat.o(68532);
                return r0;
            }
        }).a(new d.a() {
            /* class com.tencent.mm.plugin.wallet.balance.model.lqt.ae.AnonymousClass11 */

            @Override // com.tencent.mm.vending.g.d.a
            public final void cn(Object obj) {
                AppMethodBeat.i(68531);
                Log.i("MicroMsg.LqtSaveFetchLogic", "doQueryPurchaseResult interrupt: %s", obj);
                ae.this.Huz.hideLoading();
                if (ae.this.Huz instanceof WalletLqtSaveFetchUI) {
                    ((WalletLqtSaveFetchUI) ae.this.Huz).xQ(false);
                    MMHandlerThread.postToMainThreadDelayed(((WalletLqtSaveFetchUI) ae.this.Huz).jVx, 300);
                }
                if (ae.this.jSi != null) {
                    ae.this.jSi.ej(obj);
                }
                AppMethodBeat.o(68531);
            }
        });
        AppMethodBeat.o(213863);
    }

    public final void aI(int i2, int i3, int i4) {
        AppMethodBeat.i(68537);
        Log.i("MicroMsg.LqtSaveFetchLogic", "updateBindBankcard, mode: %s, accountType: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.jSi = g.hdx();
        this.jSi.hdw();
        if (i2 == 1) {
            new i(i3, i4).aYI().b(new a<Void, c.a<cuv>>() {
                /* class com.tencent.mm.plugin.wallet.balance.model.lqt.ae.AnonymousClass3 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Void call(c.a<cuv> aVar) {
                    AppMethodBeat.i(213857);
                    Void a2 = a(aVar);
                    AppMethodBeat.o(213857);
                    return a2;
                }

                private Void a(c.a<cuv> aVar) {
                    AppMethodBeat.i(213856);
                    Log.i("MicroMsg.LqtSaveFetchLogic", "CgiLqtOnClickPurchase end, errType: %s, errCode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
                    if (aVar.errType == 0 && aVar.errCode == 0) {
                        ag.aUH(((cuv) aVar.iLC).HuS);
                        u.HtN.a(((cuv) aVar.iLC).MAb, true, false);
                        u.HtN.a((cuv) aVar.iLC);
                    }
                    if (ae.this.jSi != null) {
                        ae.this.jSi.resume();
                    }
                    Void r0 = QZL;
                    AppMethodBeat.o(213856);
                    return r0;
                }
            });
            AppMethodBeat.o(68537);
            return;
        }
        new j(i3).aYI().b(new a<Void, c.a<cux>>() {
            /* class com.tencent.mm.plugin.wallet.balance.model.lqt.ae.AnonymousClass4 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(c.a<cux> aVar) {
                AppMethodBeat.i(213859);
                Void a2 = a(aVar);
                AppMethodBeat.o(213859);
                return a2;
            }

            private Void a(c.a<cux> aVar) {
                AppMethodBeat.i(213858);
                Log.i("MicroMsg.LqtSaveFetchLogic", "CgiLqtOnClickRedeem end, errType: %s, errCode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
                if (aVar.errType == 0 && aVar.errCode == 0) {
                    ag.aUH(((cux) aVar.iLC).HuS);
                    x.fMZ().a((cux) aVar.iLC);
                    u.HtN.a(((cux) aVar.iLC).MAb, false, false);
                }
                if (ae.this.jSi != null) {
                    ae.this.jSi.resume();
                }
                Void r0 = QZL;
                AppMethodBeat.o(213858);
                return r0;
            }
        });
        AppMethodBeat.o(68537);
    }

    public final void aUG(String str) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(68538);
        if (this.mode == 1) {
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_LQT_DEFAULTCARD_SAVE_STRING_SYNC, str);
        } else {
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_LQT_DEFAULTCARD_FETCH_STRING_SYNC, str);
        }
        u uVar = u.HtN;
        if (this.mode == 1) {
            z = true;
        } else {
            z = false;
        }
        uVar.xI(z);
        cki cki = z ? uVar.Htx : uVar.Hty;
        if (cki != null) {
            Log.i("MicroMsg.LqtBindQueryInfoCache", "isReqAgainAfterDeal: %s", Boolean.valueOf(cki.MpK));
            z2 = cki.MpK;
        }
        if (z2) {
            Log.i("MicroMsg.LqtSaveFetchLogic", "saveOrfetchDone, req again after deal");
            aI(this.mode, this.accountType, 1);
        }
        AppMethodBeat.o(68538);
    }

    static /* synthetic */ void a(ae aeVar, final dgc dgc, final Bankcard bankcard) {
        String str;
        int i2 = 45;
        AppMethodBeat.i(213864);
        switch (dgc.MKQ) {
            case 2:
                String str2 = dgc.MKP;
                int i3 = dgc.dVv;
                if (bankcard == null) {
                    bankcard = aeVar.HuE;
                }
                aeVar.jSi = g.hdx();
                aeVar.jSi.hdw();
                if (i3 <= 0) {
                    if (aeVar.accountType != 0) {
                        i2 = 52;
                    }
                    i3 = i2;
                }
                String str3 = bankcard != null ? bankcard.field_bindSerial : "";
                String str4 = bankcard != null ? bankcard.field_bankcardType : "";
                Log.i("MicroMsg.LqtSaveFetchLogic", "doKindaSaveLqt, startInWxAppPayUseCase reqKey:%s bindSerial:%s bankType:%s", str2, str3, str4);
                ((com.tencent.mm.pluginsdk.wallet.a) com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startInWxAppPayUseCase(aeVar.Huz, str2, str3, str4, i3, 0);
                AppMethodBeat.o(213864);
                return;
            case 3:
                ITransmitKvData create = ITransmitKvData.create();
                create.putInt("payScene", 45);
                if (!TextUtils.isEmpty(dgc.MKP)) {
                    create.putString("prepay_id", dgc.MKP);
                }
                create.putString("bankType", bankcard.field_bankcardType);
                create.putString("bindSerial", bankcard.field_bindSerial);
                aeVar.jSi = g.hdx();
                aeVar.jSi.hdw();
                ((com.tencent.mm.pluginsdk.wallet.a) com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startUseCase("jointPay", create, new UseCaseCallback() {
                    /* class com.tencent.mm.plugin.wallet.balance.model.lqt.ae.AnonymousClass8 */

                    @Override // com.tencent.kinda.gen.UseCaseCallback
                    public final void call(ITransmitKvData iTransmitKvData) {
                        AppMethodBeat.i(213861);
                        if (iTransmitKvData != null && iTransmitKvData.getString("result").equals("ok")) {
                            boolean bool = iTransmitKvData.getBool("use_joint_channel");
                            ae.this.dDM = iTransmitKvData.getString(FirebaseAnalytics.b.TRANSACTION_ID);
                            String str = (String) ae.this.HuG.get(dgc.MKP);
                            if (!Util.isNullOrNil(str)) {
                                ae.this.HuA = str;
                            }
                            if (ae.this.Huz instanceof WalletLqtSaveFetchUI) {
                                ((WalletLqtSaveFetchUI) ae.this.Huz).xQ(true);
                                ((WalletLqtSaveFetchUI) ae.this.Huz).fNV();
                            }
                            ae.a(ae.this, bankcard.field_bindSerial, bool ? 1 : 0);
                        }
                        AppMethodBeat.o(213861);
                    }
                });
                AppMethodBeat.o(213864);
                return;
            default:
                String str5 = dgc.MKP;
                int i4 = dgc.dVv;
                if (bankcard == null) {
                    bankcard = aeVar.HuE;
                }
                aeVar.jSi = g.hdx();
                aeVar.jSi.hdw();
                if (i4 <= 0) {
                    if (aeVar.accountType != 0) {
                        i2 = 52;
                    }
                    i4 = i2;
                }
                WalletBaseUI walletBaseUI = aeVar.Huz;
                if (bankcard != null) {
                    str = bankcard.field_bindSerial;
                } else {
                    str = "";
                }
                f.b(walletBaseUI, str, str5, "", i4, Huu);
                AppMethodBeat.o(213864);
                return;
        }
    }
}
