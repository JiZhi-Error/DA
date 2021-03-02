package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.wallet.pay.a.c;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.p;
import com.tencent.mm.plugin.wallet_core.ui.s;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class WalletLoanRepaymentUI extends WalletBaseUI {
    private IListener<lj> AJa = new IListener<lj>() {
        /* class com.tencent.mm.plugin.wallet.pay.ui.WalletLoanRepaymentUI.AnonymousClass7 */

        {
            AppMethodBeat.i(160866);
            this.__eventId = lj.class.getName().hashCode();
            AppMethodBeat.o(160866);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lj ljVar) {
            AppMethodBeat.i(69346);
            lj ljVar2 = ljVar;
            Log.i("MicroMsg.WalletLoanRepaymentUI", "KindaBindCardEvent callback");
            if (ljVar2 == null || !(ljVar2 instanceof lj)) {
                AppMethodBeat.o(69346);
                return false;
            }
            z.hhs();
            if (ljVar2.dQz != null) {
                if (ljVar2.dQz.dQA) {
                    Log.i("MicroMsg.WalletLoanRepaymentUI", "KindaBindCardEvent bindCard Succ");
                    WalletLoanRepaymentUI.b(WalletLoanRepaymentUI.this, WalletLoanRepaymentUI.this.token);
                } else {
                    Log.i("MicroMsg.WalletLoanRepaymentUI", "KindaBindCardEvent bindCard Cancel");
                    ak fQJ = t.fQJ();
                    if (fQJ.fQW()) {
                        Bankcard fQX = fQJ.fQX();
                        if (fQX == null || !Util.isNullOrNil(fQX.field_forbidWord)) {
                            WalletLoanRepaymentUI.c(WalletLoanRepaymentUI.this);
                        } else {
                            WalletLoanRepaymentUI.a(WalletLoanRepaymentUI.this, fQX, WalletLoanRepaymentUI.this.Cpj, WalletLoanRepaymentUI.this.AOl);
                        }
                    } else {
                        WalletLoanRepaymentUI.this.setResult(0, null);
                    }
                }
            }
            EventCenter.instance.removeListener(WalletLoanRepaymentUI.this.AJa);
            AppMethodBeat.o(69346);
            return true;
        }
    };
    private String AOl = "CNY";
    private double Cpj;
    protected s HGb;
    private String HGn;
    private String HGo;
    private String HGp;
    private String HGq;
    private String HGr;
    private String HGs;
    private String HGt;
    private String HGu;
    private int HGv;
    private String desc;
    private String kof;
    private String token;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletLoanRepaymentUI() {
        AppMethodBeat.i(69347);
        AppMethodBeat.o(69347);
    }

    static /* synthetic */ void a(WalletLoanRepaymentUI walletLoanRepaymentUI, Bankcard bankcard, double d2, String str) {
        AppMethodBeat.i(69360);
        walletLoanRepaymentUI.a(bankcard, d2, str);
        AppMethodBeat.o(69360);
    }

    static /* synthetic */ void b(WalletLoanRepaymentUI walletLoanRepaymentUI, String str) {
        AppMethodBeat.i(69359);
        walletLoanRepaymentUI.aUX(str);
        AppMethodBeat.o(69359);
    }

    static /* synthetic */ void c(WalletLoanRepaymentUI walletLoanRepaymentUI) {
        AppMethodBeat.i(69358);
        walletLoanRepaymentUI.fOt();
        AppMethodBeat.o(69358);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(69348);
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.HGs = intent.getStringExtra("appId");
        this.HGn = intent.getStringExtra("timeStamp");
        this.HGo = intent.getStringExtra("nonceStr");
        this.HGp = intent.getStringExtra("packageExt");
        this.HGq = intent.getStringExtra("signtype");
        this.HGr = intent.getStringExtra("paySignature");
        this.HGt = intent.getStringExtra("url");
        this.HGv = intent.getIntExtra("pay_channel", 0);
        addSceneEndListener(580);
        doSceneForceProgress(new d(this.HGs, this.HGn, this.HGo, this.HGp, this.HGq, this.HGr, this.HGt, 7, "getWebPayCheckoutCounterRequst", this.HGv));
        AppMethodBeat.o(69348);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(69349);
        super.onResume();
        AppMethodBeat.o(69349);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(69350);
        super.onDestroy();
        removeSceneEndListener(580);
        AppMethodBeat.o(69350);
    }

    private void aUX(String str) {
        AppMethodBeat.i(69351);
        doSceneProgress(new c(str), true);
        AppMethodBeat.o(69351);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(69352);
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof d) {
                e.bfP(((d) qVar).fPP());
                this.token = ((d) qVar).getToken();
                aUX(this.token);
                AppMethodBeat.o(69352);
                return true;
            } else if (qVar instanceof c) {
                c cVar = (c) qVar;
                this.AOl = cVar.AOl;
                this.Cpj = cVar.Cpj;
                this.desc = cVar.desc;
                ak fQJ = t.fQJ();
                if (fQJ.fQW()) {
                    Bankcard fQX = fQJ.fQX();
                    if (fQX == null || !Util.isNullOrNil(fQX.field_forbidWord)) {
                        fOt();
                    } else {
                        a(fQX, this.Cpj, this.AOl);
                    }
                } else {
                    h.c(this, getResources().getString(R.string.ier), "", getString(R.string.imy), getString(R.string.sz), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet.pay.ui.WalletLoanRepaymentUI.AnonymousClass4 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(69343);
                            Log.i("MicroMsg.WalletLoanRepaymentUI", "to bind a new bankcard");
                            WalletLoanRepaymentUI.this.fOu();
                            AppMethodBeat.o(69343);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet.pay.ui.WalletLoanRepaymentUI.AnonymousClass5 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(69344);
                            if (WalletLoanRepaymentUI.this.isTransparent()) {
                                WalletLoanRepaymentUI.this.finish();
                            }
                            AppMethodBeat.o(69344);
                        }
                    });
                }
                AppMethodBeat.o(69352);
                return true;
            } else if (qVar instanceof x) {
                x xVar = (x) qVar;
                if (xVar.fPR()) {
                    Log.i("MicroMsg.WalletLoanRepaymentUI", "need free sms");
                    Bundle bundle = new Bundle();
                    bundle.putString("key_pwd1", this.kof);
                    bundle.putString("key_jsapi_token", this.token);
                    bundle.putString("key_relation_key", xVar.HQd);
                    bundle.putInt("key_verify_scene", 8);
                    bundle.putString("key_mobile", xVar.HQc);
                    com.tencent.mm.wallet_core.a.a(this, p.class, bundle);
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("token", xVar.HQa);
                    intent.putExtra("bind_serial", this.HGu);
                    setResult(-1, intent);
                    finish();
                }
                AppMethodBeat.o(69352);
                return true;
            }
        }
        AppMethodBeat.o(69352);
        return false;
    }

    private void a(Bankcard bankcard, double d2, String str) {
        AppMethodBeat.i(69353);
        AnonymousClass1 r6 = new s.c() {
            /* class com.tencent.mm.plugin.wallet.pay.ui.WalletLoanRepaymentUI.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.s.c
            public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
                AppMethodBeat.i(69340);
                WalletLoanRepaymentUI.this.kof = str;
                WalletLoanRepaymentUI.this.doSceneProgress(new x(WalletLoanRepaymentUI.this.kof, WalletLoanRepaymentUI.this.token, (byte) 0));
                AppMethodBeat.o(69340);
            }
        };
        AnonymousClass2 r7 = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.pay.ui.WalletLoanRepaymentUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(69341);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletLoanRepaymentUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletLoanRepaymentUI.c(WalletLoanRepaymentUI.this);
                if (WalletLoanRepaymentUI.this.HGb != null) {
                    WalletLoanRepaymentUI.this.HGb.dismiss();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletLoanRepaymentUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(69341);
            }
        };
        AnonymousClass3 r8 = new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.wallet.pay.ui.WalletLoanRepaymentUI.AnonymousClass3 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(69342);
                if (WalletLoanRepaymentUI.this.HGb != null) {
                    WalletLoanRepaymentUI.this.HGb.cancel();
                    WalletLoanRepaymentUI.this.setResult(0);
                    WalletLoanRepaymentUI.this.finish();
                }
                AppMethodBeat.o(69342);
            }
        };
        this.HGu = bankcard.field_bindSerial;
        this.HGb = s.a(this, this.desc, d2, str, bankcard, r6, r7, r8);
        AppMethodBeat.o(69353);
    }

    private void fOt() {
        AppMethodBeat.i(69354);
        Log.i("MicroMsg.WalletLoanRepaymentUI", "to change a bankcard");
        startActivityForResult(new Intent(this, WalletChangeLoanRepayBankcardUI.class), 1);
        AppMethodBeat.o(69354);
    }

    /* access modifiers changed from: protected */
    public final void fOu() {
        boolean z;
        AppMethodBeat.i(69355);
        Bundle bundle = new Bundle();
        bundle.putInt("key_bind_scene", 8);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putString("kreq_token", this.token);
        com.tencent.mm.wallet_core.b.hgC();
        if (com.tencent.mm.wallet_core.b.b(b.a.clicfg_open_kinda_bind_card, true)) {
            EventCenter.instance.add(this.AJa);
            Log.d("MicroMsg.WalletLoanRepaymentUI", "startKindaBindCard:true");
            ab.mg(6, bundle.getInt("key_bind_scene"));
            z.aqh(bundle.getInt("key_bind_scene"));
            ((com.tencent.mm.pluginsdk.wallet.a) g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(this, bundle);
            z = true;
        } else {
            Log.d("MicroMsg.WalletLoanRepaymentUI", "startKindaBindCard:false");
            z = false;
        }
        if (z) {
            AppMethodBeat.o(69355);
            return;
        }
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.loan.a.class, bundle, new d.a() {
            /* class com.tencent.mm.plugin.wallet.pay.ui.WalletLoanRepaymentUI.AnonymousClass6 */

            @Override // com.tencent.mm.wallet_core.d.a
            public final Intent q(int i2, Bundle bundle) {
                AppMethodBeat.i(69345);
                if (i2 == -1) {
                    WalletLoanRepaymentUI.b(WalletLoanRepaymentUI.this, WalletLoanRepaymentUI.this.token);
                } else {
                    ak fQJ = t.fQJ();
                    if (fQJ.fQW()) {
                        Bankcard fQX = fQJ.fQX();
                        if (fQX == null || !Util.isNullOrNil(fQX.field_forbidWord)) {
                            WalletLoanRepaymentUI.c(WalletLoanRepaymentUI.this);
                        } else {
                            WalletLoanRepaymentUI.a(WalletLoanRepaymentUI.this, fQX, WalletLoanRepaymentUI.this.Cpj, WalletLoanRepaymentUI.this.AOl);
                        }
                    } else {
                        WalletLoanRepaymentUI.this.setResult(0, null);
                    }
                }
                AppMethodBeat.o(69345);
                return null;
            }
        });
        AppMethodBeat.o(69355);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(69356);
        Bundle extras = intent.getExtras();
        Log.i("MicroMsg.WalletLoanRepaymentUI", "onNewIntent");
        if (extras.containsKey("intent_bind_end")) {
            Log.i("MicroMsg.WalletLoanRepaymentUI", "back from bind card");
            aUX(this.token);
            AppMethodBeat.o(69356);
        } else if (extras.containsKey("jsapi_verifycode_process_end")) {
            Log.i("MicroMsg.WalletLoanRepaymentUI", "back from verify code");
            Intent intent2 = new Intent();
            intent2.putExtra("token", intent.getStringExtra("token"));
            intent2.putExtra("bind_serial", this.HGu);
            setResult(-1, intent2);
            finish();
            AppMethodBeat.o(69356);
        } else {
            Log.i("MicroMsg.WalletLoanRepaymentUI", "need to deal with,finish");
            finish();
            AppMethodBeat.o(69356);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(69357);
        if (i2 != 1) {
            super.onActivityResult(i2, i3, intent);
            AppMethodBeat.o(69357);
        } else if (i3 == -1) {
            int intExtra = intent.getIntExtra("ret", -1000);
            if (intExtra == -1003) {
                Log.i("MicroMsg.WalletLoanRepaymentUI", "to bind a new card");
                fOu();
                AppMethodBeat.o(69357);
            } else if (intExtra == 0) {
                Log.i("MicroMsg.WalletLoanRepaymentUI", "change card ok");
                Bankcard aVl = t.fQJ().aVl(intent.getStringExtra("bindSerial"));
                if (aVl == null) {
                    Log.e("MicroMsg.WalletLoanRepaymentUI", "bankcard is null by getBankcardBySerialNo");
                    finish();
                    AppMethodBeat.o(69357);
                    return;
                }
                a(aVl, this.Cpj, this.AOl);
                AppMethodBeat.o(69357);
            } else {
                Log.e("MicroMsg.WalletLoanRepaymentUI", "activity return unknow error");
                AppMethodBeat.o(69357);
            }
        } else {
            ak fQJ = t.fQJ();
            if (fQJ.fQW()) {
                Bankcard fQX = fQJ.fQX();
                if (fQX == null || !Util.isNullOrNil(fQX.field_forbidWord)) {
                    finish();
                    AppMethodBeat.o(69357);
                    return;
                }
                a(fQX, this.Cpj, this.AOl);
                AppMethodBeat.o(69357);
                return;
            }
            Log.e("MicroMsg.WalletLoanRepaymentUI", "onActivityResult hasRepaymentBankcard is false");
            AppMethodBeat.o(69357);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }
}
