package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.g.a.zq;
import com.tencent.mm.g.a.zr;
import com.tencent.mm.g.a.zv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.bind.a.c;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.ui.u;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class WalletBindUI extends WalletBaseUI {
    private IListener<lj> AJa = new IListener<lj>() {
        /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBindUI.AnonymousClass9 */

        {
            AppMethodBeat.i(160860);
            this.__eventId = lj.class.getName().hashCode();
            AppMethodBeat.o(160860);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lj ljVar) {
            AppMethodBeat.i(69143);
            lj ljVar2 = ljVar;
            Log.i("MicroMsg.WalletBindUI", "KindaBindCardEvent callback");
            if (ljVar2 == null || !(ljVar2 instanceof lj)) {
                AppMethodBeat.o(69143);
                return false;
            }
            z.hhs();
            if (ljVar2.dQz != null) {
                WalletBindUI.a(WalletBindUI.this, ljVar2.dQz.dQA, ljVar2.dQz.dQB);
            }
            EventCenter.instance.removeListener(WalletBindUI.this.AJa);
            AppMethodBeat.o(69143);
            return true;
        }
    };
    private PayInfo BDB = new PayInfo();
    private boolean HDC = false;
    private String HDD;
    private int HDE = -1;
    private boolean HDF = false;
    private String HDG = null;
    private d HDH = null;
    private boolean HDI = false;
    IListener HDJ = new IListener<zr>() {
        /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBindUI.AnonymousClass4 */

        {
            AppMethodBeat.i(160859);
            this.__eventId = zr.class.getName().hashCode();
            AppMethodBeat.o(160859);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zr zrVar) {
            AppMethodBeat.i(69138);
            WalletBindUI.this.finish();
            AppMethodBeat.o(69138);
            return false;
        }
    };
    private String token = null;
    private u zmb = new u();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletBindUI() {
        AppMethodBeat.i(69144);
        AppMethodBeat.o(69144);
    }

    static /* synthetic */ void a(WalletBindUI walletBindUI, int i2) {
        AppMethodBeat.i(69161);
        walletBindUI.aew(i2);
        AppMethodBeat.o(69161);
    }

    static /* synthetic */ void c(WalletBindUI walletBindUI) {
        AppMethodBeat.i(69160);
        walletBindUI.fOc();
        AppMethodBeat.o(69160);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        int i2 = -1;
        AppMethodBeat.i(69145);
        super.onCreate(bundle);
        addSceneEndListener(580);
        this.zmb.IkQ = new u.b() {
            /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBindUI.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.u.b
            public final int eho() {
                return 1;
            }

            @Override // com.tencent.mm.plugin.wallet_core.ui.u.b
            public final Context getContext() {
                return WalletBindUI.this;
            }
        };
        this.HDD = getIntent().getStringExtra("key_import_key");
        this.HDE = getIntent().getIntExtra("key_bind_scene", -1);
        if (getIntent() != null) {
            i2 = getIntent().getIntExtra("key_bind_scene", 13);
        }
        zv zvVar = new zv();
        if (i2 == 4) {
            zvVar.efR.scene = 20;
        } else {
            zvVar.efR.scene = 13;
        }
        zvVar.callback = new Runnable() {
            /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBindUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(69136);
                if (WalletBindUI.this.HDI) {
                    AppMethodBeat.o(69136);
                    return;
                }
                if (WalletBindUI.this.HDE == 4) {
                    WalletBindUI.this.zmb.a(new u.a() {
                        /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBindUI.AnonymousClass2.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.wallet_core.ui.u.a
                        public final void ehm() {
                            AppMethodBeat.i(69133);
                            WalletBindUI.c(WalletBindUI.this);
                            AppMethodBeat.o(69133);
                        }

                        @Override // com.tencent.mm.plugin.wallet_core.ui.u.a
                        public final void cancel() {
                            AppMethodBeat.i(69134);
                            WalletBindUI.this.finish();
                            AppMethodBeat.o(69134);
                        }

                        @Override // com.tencent.mm.plugin.wallet_core.ui.u.a
                        public final void ehn() {
                            AppMethodBeat.i(69135);
                            WalletBindUI.c(WalletBindUI.this);
                            AppMethodBeat.o(69135);
                        }
                    }, new al().fRi());
                } else {
                    WalletBindUI.c(WalletBindUI.this);
                }
                if (!WalletBindUI.this.HDI) {
                    WalletBindUI.this.HDI = true;
                }
                AppMethodBeat.o(69136);
            }
        };
        EventCenter.instance.publish(zvVar);
        EventCenter.instance.addListener(this.HDJ);
        ab.mg(6, 0);
        AppMethodBeat.o(69145);
    }

    private void fOc() {
        AppMethodBeat.i(69146);
        this.BDB.dVw = this.HDE;
        getInput().putParcelable("key_pay_info", this.BDB);
        if (this.HDE == 2) {
            if (!Util.isNullOrNil(this.HDD)) {
                Log.d("MicroMsg.WalletBindUI", "importKey " + this.HDD);
                doSceneForceProgress(new c(this.HDD, this.BDB));
                AppMethodBeat.o(69146);
                return;
            }
            amW("");
            AppMethodBeat.o(69146);
        } else if (this.HDE == 4) {
            z.aqh(4);
            if (getIntent() == null) {
                amW("");
                AppMethodBeat.o(69146);
                return;
            }
            String stringExtra = getIntent().getStringExtra("appId");
            String stringExtra2 = getIntent().getStringExtra("timeStamp");
            String stringExtra3 = getIntent().getStringExtra("nonceStr");
            String stringExtra4 = getIntent().getStringExtra("packageExt");
            String stringExtra5 = getIntent().getStringExtra("signtype");
            String stringExtra6 = getIntent().getStringExtra("paySignature");
            String stringExtra7 = getIntent().getStringExtra("url");
            int intExtra = getIntent().getIntExtra("pay_channel", 0);
            if (this.HDE == 6) {
                this.HDH = new d(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6, stringExtra7, 2, "getBrandWCPayCreateCreditCardRequest", intExtra);
            } else {
                this.HDH = new d(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6, stringExtra7, 1, "getBrandWCPayBindCardRequest", intExtra);
            }
            doSceneForceProgress(this.HDH);
            AppMethodBeat.o(69146);
        } else if (this.HDE == 6) {
            fOd();
            AppMethodBeat.o(69146);
        } else {
            aev(this.HDE);
            AppMethodBeat.o(69146);
        }
    }

    private void aev(int i2) {
        AppMethodBeat.i(69147);
        Log.i("MicroMsg.WalletBindUI", "doBindCardForOtherScene " + Util.getStack().toString());
        Bundle input = getInput();
        input.putParcelable("key_pay_info", this.BDB);
        input.putBoolean("key_need_bind_response", true);
        input.putString("key_custom_bind_tips", getIntent().getStringExtra("key_custom_bind_tips"));
        boolean booleanExtra = getIntent().getBooleanExtra("from_kinda", false);
        if (booleanExtra) {
            input.putBoolean("is_from_new_cashier", true);
            input.putString("start_activity_class", getClass().getName());
        }
        s.fOg();
        if (s.fOh().fRp()) {
            Log.i("MicroMsg.WalletBindUI", "user status invalid");
            if (i2 == 4) {
                doSceneForceProgress(new ad(null, 20));
            } else {
                doSceneForceProgress(new ad(null, 12));
            }
        } else {
            s.fOg();
            if (s.fOh().fRk()) {
                Log.i("MicroMsg.WalletBindUI", "user status reg");
                this.HDC = true;
                this.BDB.dVw = this.HDE;
                input.putInt("key_bind_scene", this.BDB.dVw);
                if (!Util.isNullOrNil(this.token)) {
                    input.putString("kreq_token", this.token);
                }
                if (!this.HDF || Util.isNullOrNil(this.HDG)) {
                    input.putBoolean("key_bind_card_can_pass_pwd", false);
                } else {
                    input.putBoolean("key_bind_card_can_pass_pwd", true);
                    input.putString("key_bind_card_user_token", this.HDG);
                }
                if (e.gsR() != null) {
                    input.putString("jsapi_reqkey", e.gsR());
                }
                b.hgC();
                if (b.b(b.a.clicfg_open_kinda_bind_card, true)) {
                    EventCenter.instance.add(this.AJa);
                    aH(input);
                    AppMethodBeat.o(69147);
                    return;
                }
                getIntent().putExtra("process_id", com.tencent.mm.plugin.wallet_core.b.b.class.hashCode());
                com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.b.b.class, input, (d.a) null);
            } else {
                Log.i("MicroMsg.WalletBindUI", "user status unreg");
                this.HDC = true;
                if (this.HDE >= 0) {
                    this.BDB.dVw = this.HDE;
                } else {
                    this.BDB.dVw = 1;
                }
                input.putInt("key_bind_scene", this.BDB.dVw);
                if (!this.HDF || Util.isNullOrNil(this.HDG)) {
                    input.putBoolean("key_bind_card_can_pass_pwd", false);
                } else {
                    input.putBoolean("key_bind_card_can_pass_pwd", true);
                    input.putString("key_bind_card_user_token", this.HDG);
                }
                com.tencent.mm.wallet_core.b.hgC();
                if (com.tencent.mm.wallet_core.b.b(b.a.clicfg_open_kinda_bind_card, true)) {
                    EventCenter.instance.add(this.AJa);
                    aH(input);
                    AppMethodBeat.o(69147);
                    return;
                }
                getIntent().putExtra("process_id", com.tencent.mm.plugin.wallet_core.b.b.class.hashCode());
                com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.b.b.class, input, (d.a) null);
            }
        }
        if (booleanExtra) {
            com.tencent.mm.wallet_core.d by = com.tencent.mm.wallet_core.a.by(this);
            if (by instanceof com.tencent.mm.plugin.wallet_core.b.b) {
                ((com.tencent.mm.plugin.wallet_core.b.b) by).HPw = new b.a() {
                    /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBindUI.AnonymousClass3 */

                    @Override // com.tencent.mm.plugin.wallet_core.b.b.a
                    public final void run(int i2) {
                        AppMethodBeat.i(69137);
                        if (i2 == -1) {
                            WalletBindUI.this.setResult(-1);
                            WalletBindUI.a(WalletBindUI.this, -1);
                            AppMethodBeat.o(69137);
                            return;
                        }
                        WalletBindUI.this.setResult(0);
                        WalletBindUI.a(WalletBindUI.this, 0);
                        AppMethodBeat.o(69137);
                    }
                };
            }
        }
        AppMethodBeat.o(69147);
    }

    private void fOd() {
        AppMethodBeat.i(69148);
        s.fOg();
        if (s.fOh().fRp()) {
            doSceneForceProgress(new ad(null, 12));
            AppMethodBeat.o(69148);
            return;
        }
        String str = getIntent().getStringExtra("packageExt");
        String[] split = str.split("&");
        if (!Util.isNullOrNil(str) && split.length >= 2) {
            String str2 = null;
            String str3 = null;
            for (String str4 : split) {
                if (str4.startsWith("bankType=")) {
                    str3 = str4.replace("bankType=", "");
                } else if (str4.startsWith("bankName=")) {
                    str2 = str4.replace("bankName=", "");
                }
            }
            if (!Util.isNullOrNil(str2) && !Util.isNullOrNil(str3)) {
                s.fOg();
                if (s.fOh().aVn(str3)) {
                    Bundle bundle = new Bundle();
                    Bankcard bankcard = new Bankcard();
                    bankcard.field_bankName = str2;
                    bankcard.field_bankcardType = str3;
                    bundle.putParcelable("key_bankcard", bankcard);
                    bundle.putString("key_bank_type", bankcard.field_bankcardType);
                    com.tencent.mm.wallet_core.a.a(this, "WXCreditOpenProcess", bundle, (d.a) null);
                    AppMethodBeat.o(69148);
                    return;
                }
            }
        }
        finish();
        AppMethodBeat.o(69148);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(69149);
        if (this.HDC) {
            finish();
        }
        super.onResume();
        this.zmb.onResume();
        AppMethodBeat.o(69149);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(69150);
        super.onPause();
        this.zmb.onPause();
        AppMethodBeat.o(69150);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(69151);
        removeSceneEndListener(580);
        EventCenter.instance.removeListener(this.HDJ);
        super.onDestroy();
        AppMethodBeat.o(69151);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(69152);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1) {
            if (i3 == -1) {
                this.zmb.ehm();
                AppMethodBeat.o(69152);
                return;
            }
            this.zmb.cancel();
            finish();
        }
        AppMethodBeat.o(69152);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(69153);
        if (qVar instanceof c) {
            this.HDC = true;
        }
        if (i2 != 0 || i3 != 0) {
            amW(str);
            AppMethodBeat.o(69153);
            return true;
        } else if (qVar instanceof ad) {
            if (this.HDE == 6) {
                fOd();
            } else {
                fOc();
            }
            AppMethodBeat.o(69153);
            return true;
        } else if (qVar instanceof c) {
            c cVar = (c) qVar;
            Bundle input = getInput();
            input.putBoolean("key_is_import_bind", true);
            if (cVar.Hva == null || cVar.Hva.size() <= 0) {
                if (Util.isNullOrNil(str)) {
                    str = getString(R.string.i8g);
                }
                h.a((Context) this, str, (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBindUI.AnonymousClass7 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(69141);
                        WalletBindUI.this.finish();
                        AppMethodBeat.o(69141);
                    }
                });
            } else {
                Bankcard bankcard = cVar.Hva.get(0);
                if (!bankcard.dKO) {
                    input.putBoolean("key_need_bind_response", true);
                    input.putString("kreq_token", cVar.token);
                    input.putString("key_bank_username", cVar.HCw);
                    input.putString("key_recommand_desc", cVar.HCx);
                    input.putParcelable("key_import_bankcard", bankcard);
                    this.HDC = true;
                    input.putInt("key_bind_scene", 2);
                    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.b.b.class, input, new d.a() {
                        /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBindUI.AnonymousClass5 */

                        @Override // com.tencent.mm.wallet_core.d.a
                        public final Intent q(int i2, Bundle bundle) {
                            AppMethodBeat.i(69139);
                            Intent intent = new Intent(WalletBindUI.this.getContext(), WalletBankcardManageUI.class);
                            AppMethodBeat.o(69139);
                            return intent;
                        }
                    });
                } else {
                    h.a((Context) this, (int) R.string.i_d, 0, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBindUI.AnonymousClass6 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(69140);
                            WalletBindUI.this.finish();
                            AppMethodBeat.o(69140);
                        }
                    });
                }
            }
            AppMethodBeat.o(69153);
            return true;
        } else {
            if (qVar instanceof com.tencent.mm.plugin.wallet_core.c.d) {
                if (this.HDH == null || !this.HDH.equals(qVar)) {
                    z.hhs();
                } else {
                    e.bfP(((com.tencent.mm.plugin.wallet_core.c.d) qVar).fPP());
                    this.token = ((com.tencent.mm.plugin.wallet_core.c.d) qVar).getToken();
                    this.HDF = ((zf) ((com.tencent.mm.plugin.wallet_core.c.d) qVar).rr.iLL.iLR).Lky;
                    this.HDG = ((zf) ((com.tencent.mm.plugin.wallet_core.c.d) qVar).rr.iLL.iLR).HQm;
                    aev(4);
                    AppMethodBeat.o(69153);
                    return true;
                }
            }
            AppMethodBeat.o(69153);
            return false;
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(69154);
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("key_is_jump", this.HDC);
        AppMethodBeat.o(69154);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public void onRestoreInstanceState(Bundle bundle) {
        AppMethodBeat.i(69155);
        super.onRestoreInstanceState(bundle);
        this.HDC = bundle.getBoolean("key_is_jump", false);
        AppMethodBeat.o(69155);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean checkProcLife() {
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(69156);
        if (intent == null) {
            Log.e("MicroMsg.WalletBindUI", "onNewIntent intent null");
            setResult(0);
            aew(0);
            finish();
            AppMethodBeat.o(69156);
            return;
        }
        super.onNewIntent(intent);
        Log.v("MicroMsg.WalletBindUI", "onNewIntent");
        setIntent(intent);
        if (intent == null || !intent.getBooleanExtra("intent_bind_end", false)) {
            Log.i("MicroMsg.WalletBindUI", "pay cancel");
            setResult(0);
            aew(0);
        } else {
            Log.d("MicroMsg.WalletBindUI", "pay done... errCode:" + intent.getBooleanExtra("intent_bind_end", false));
            setResult(-1, getIntent());
            aew(-1);
        }
        finish();
        AppMethodBeat.o(69156);
    }

    private void amW(String str) {
        AppMethodBeat.i(69157);
        if (Util.isNullOrNil(str)) {
            str = getString(R.string.itf);
        }
        h.a((Context) this, str, (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBindUI.AnonymousClass8 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(69142);
                WalletBindUI.this.setResult(0);
                WalletBindUI.a(WalletBindUI.this, 0);
                WalletBindUI.this.finish();
                AppMethodBeat.o(69142);
            }
        });
        AppMethodBeat.o(69157);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    private void aH(Bundle bundle) {
        AppMethodBeat.i(69158);
        Log.d("MicroMsg.WalletBindUI", "startKindaBindCard");
        if (bundle != null) {
            ab.mg(6, bundle.getInt("key_bind_scene"));
            z.aqh(bundle.getInt("key_bind_scene"));
        } else {
            ab.mg(6, 0);
            z.aqh(0);
        }
        ((com.tencent.mm.pluginsdk.wallet.a) g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(this, bundle);
        AppMethodBeat.o(69158);
    }

    private void aew(int i2) {
        AppMethodBeat.i(69159);
        if (getIntent().getBooleanExtra("from_kinda", false)) {
            zq zqVar = new zq();
            zqVar.efK.result = i2;
            EventCenter.instance.publish(zqVar);
        }
        AppMethodBeat.o(69159);
    }

    static /* synthetic */ void a(WalletBindUI walletBindUI, boolean z, boolean z2) {
        AppMethodBeat.i(69162);
        if (z) {
            Log.i("MicroMsg.WalletBindUI", "kindaBindCardCallback bindCard Succ");
            if (walletBindUI.HDE == 4) {
                walletBindUI.doSceneForceProgress(new ad(null, 20));
            } else {
                walletBindUI.doSceneForceProgress(new ad(null, 12));
            }
            if (z2 && walletBindUI.HDC) {
                walletBindUI.setResult(-1);
                walletBindUI.aew(-1);
                walletBindUI.finish();
                AppMethodBeat.o(69162);
                return;
            }
        } else {
            Log.i("MicroMsg.WalletBindUI", "kindaBindCardCallback bindCard Cancel");
            if (z2 && walletBindUI.HDC) {
                walletBindUI.setResult(0);
                walletBindUI.aew(0);
                walletBindUI.finish();
            }
        }
        AppMethodBeat.o(69162);
    }
}
