package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.aab;
import com.tencent.mm.g.a.zp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_index.c.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.wxmm.v2helper;

@a(7)
public class WalletIapUI extends MMActivity implements i {
    private final int BKj = 1002;
    private IListener BaR = new IListener<zp>() {
        /* class com.tencent.mm.plugin.wallet_index.ui.WalletIapUI.AnonymousClass4 */

        {
            AppMethodBeat.i(160902);
            this.__eventId = zp.class.getName().hashCode();
            AppMethodBeat.o(160902);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zp zpVar) {
            AppMethodBeat.i(71917);
            Log.i("MicroMsg.WalletIapUI", "payListener callback to close progress");
            if (zpVar instanceof zp) {
                WalletIapUI.e(WalletIapUI.this);
                AppMethodBeat.o(71917);
                return true;
            }
            Log.f("MicroMsg.WalletIapUI", "mismatched event");
            AppMethodBeat.o(71917);
            return false;
        }
    };
    private final int DEFAULT = 1003;
    private int GAF = 0;
    private IListener IrQ = new IListener<aab>() {
        /* class com.tencent.mm.plugin.wallet_index.ui.WalletIapUI.AnonymousClass1 */

        {
            AppMethodBeat.i(160901);
            this.__eventId = aab.class.getName().hashCode();
            AppMethodBeat.o(160901);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aab aab) {
            AppMethodBeat.i(71914);
            aab aab2 = aab;
            Log.i("MicroMsg.WalletIapUI", "walletPayResultListener onPayEnd payResult:%s, reqKey:%s,  comeFrom:%s,requestCode:%d", Integer.valueOf(aab2.egN.result), aab2.egN.dDL, Integer.valueOf(aab2.egN.egM), Integer.valueOf(aab2.egN.requestCode));
            if (aab2.egN == null || Util.isNullOrNil(aab2.egN.dDL) || !aab2.egN.dDL.equalsIgnoreCase("key_from_scene_appbrandgame") || aab2.egN.egM != 1) {
                Log.i("MicroMsg.WalletIapUI", "FuncId %s,is not current request key || comeFrom:%s is not FINISH", "key_from_scene_appbrandgame", Integer.valueOf(aab2.egN.egM));
                AppMethodBeat.o(71914);
            } else {
                if (aab2.egN.intent == null || aab2.egN.intent.getExtras() == null || aab2.egN.intent.getExtras().get("key_total_fee") == null) {
                    Log.i("MicroMsg.WalletIapUI", "no payAmount");
                } else {
                    WalletIapUI.this.Ish = aab2.egN.intent.getExtras().get("key_total_fee").toString();
                    Log.i("MicroMsg.WalletIapUI", "has payAmount:%s", WalletIapUI.this.Ish);
                }
                if (WalletIapUI.this.Isi != null) {
                    WalletIapUI.this.Isi.a(WalletIapUI.this, aab2.egN.requestCode, aab2.egN.result, aab2.egN.intent);
                    Log.d("MicroMsg.WalletIapUI", "walletPayResultListener handled by mWalletPay.");
                } else {
                    Log.e("MicroMsg.WalletIapUI", "havn't handle user action");
                    Intent intent = new Intent();
                    c cJ = c.cJ(6, "");
                    intent.putExtra("key_err_code", cJ.mResponse);
                    intent.putExtra("key_err_msg", cJ.mMessage);
                    intent.putExtra("key_launch_ts", a.Iri);
                    WalletIapUI.this.setResult(-1, intent);
                    WalletIapUI.this.finish();
                }
                AppMethodBeat.o(71914);
            }
            return true;
        }
    };
    private final int IrZ = 4;
    public c Irh;
    private d Irj = new d() {
        /* class com.tencent.mm.plugin.wallet_index.ui.WalletIapUI.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.wallet_index.ui.d
        public final void a(c cVar, com.tencent.mm.plugin.wallet_index.b.a.c cVar2) {
            AppMethodBeat.i(71916);
            Log.i("MicroMsg.WalletIapUI", "Consume finished: " + cVar + ", purchase: " + cVar2);
            if (cVar.isFailure()) {
                WalletIapUI.this.currentState = 1002;
                Log.i("MicroMsg.WalletIapUI", "back to preview UI, reason: consume Fail ! ");
            } else {
                WalletIapUI.this.currentState = 1000;
                Log.i("MicroMsg.WalletIapUI", "back to preview UI, reason: consume Success ! ");
            }
            Intent intent = new Intent();
            intent.putExtra("key_err_code", cVar.mResponse);
            intent.putExtra("key_err_msg", cVar.mMessage);
            intent.putStringArrayListExtra("key_response_product_ids", WalletIapUI.this.Irh.Irp);
            intent.putStringArrayListExtra("key_response_series_ids", WalletIapUI.this.Irh.Irq);
            intent.putExtra("key_launch_ts", a.Iri);
            WalletIapUI.this.setResult(-1, intent);
            WalletIapUI.this.finish();
            AppMethodBeat.o(71916);
        }
    };
    private final int Isa = 0;
    private final int Isb = 1;
    private final int Isc = 2;
    private final int Isd = 3;
    private final int Ise = 1001;
    private boolean Isf = false;
    private boolean Isg;
    private String Ish = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    private b Isi;
    public d Isj = new d() {
        /* class com.tencent.mm.plugin.wallet_index.ui.WalletIapUI.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.wallet_index.ui.d
        public final void a(c cVar, com.tencent.mm.plugin.wallet_index.b.a.c cVar2) {
            AppMethodBeat.i(71915);
            Log.i("MicroMsg.WalletIapUI", "Pay Purchase finished: " + cVar + ", purchase: " + cVar2);
            if (WalletIapUI.this.Isi instanceof a) {
                Log.i("MicroMsg.WalletIapUI", "Pay Purchase finished mWallet is  GoogleWallet");
                if (cVar2 != null) {
                    ab.e(cVar2.IqB, cVar2.rcD, cVar2.IqG, cVar.mResponse, cVar.mMessage);
                } else {
                    a aVar = (a) WalletIapUI.this.Isi;
                    ab.e(aVar.Irm, aVar.rcD, aVar.IqG, cVar.mResponse, cVar.mMessage);
                }
            }
            if (cVar.isFailure()) {
                Log.i("MicroMsg.WalletIapUI", "back to preview UI, reason: purchase finish , errCode: " + cVar.mResponse + " , errMsg: " + cVar.mMessage);
                if (cVar.mResponse == 1) {
                    WalletIapUI.this.currentState = 1001;
                } else {
                    WalletIapUI.this.currentState = 1002;
                }
                Intent intent = new Intent();
                intent.putExtra("key_err_code", cVar.mResponse);
                intent.putExtra("key_err_msg", cVar.mMessage);
                intent.putExtra("key_launch_ts", a.Iri);
                intent.putExtra("key_gw_error_code", cVar.IqK);
                WalletIapUI.this.setResult(-1, intent);
                WalletIapUI.this.finish();
                AppMethodBeat.o(71915);
            } else if (cVar.fUp()) {
                WalletIapUI.this.GAF = 3;
                Log.i("MicroMsg.WalletIapUI", "start to restore the purchase!");
                WalletIapUI.this.Isi.c(WalletIapUI.this, false);
                AppMethodBeat.o(71915);
            } else if (cVar2 != null) {
                Log.i("MicroMsg.WalletIapUI", "verify purchase! productId:" + cVar2.rcD + ",billNo:" + cVar2.IqE);
                g.aAi();
                g.aAg().hqi.a(WalletIapUI.this.Irh.a(cVar2, false), 0);
                WalletIapUI.this.GAF = 2;
                WalletIapUI.d(WalletIapUI.this);
                AppMethodBeat.o(71915);
            } else {
                WalletIapUI.this.currentState = 1002;
                Intent intent2 = new Intent();
                c cJ = c.cJ(6, "");
                intent2.putExtra("key_err_code", cJ.mResponse);
                intent2.putExtra("key_err_msg", cJ.mMessage);
                intent2.putExtra("key_launch_ts", a.Iri);
                intent2.putExtra("key_gw_error_code", cJ.IqK);
                WalletIapUI.this.setResult(-1, intent2);
                WalletIapUI.this.finish();
                AppMethodBeat.o(71915);
            }
        }
    };
    private final int OK = 1000;
    private int currentState = 1003;
    private int mRequestCode = 0;
    private Dialog ocE;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletIapUI() {
        AppMethodBeat.i(71919);
        AppMethodBeat.o(71919);
    }

    static /* synthetic */ void d(WalletIapUI walletIapUI) {
        AppMethodBeat.i(214279);
        walletIapUI.bnj();
        AppMethodBeat.o(214279);
    }

    static /* synthetic */ void e(WalletIapUI walletIapUI) {
        AppMethodBeat.i(71929);
        walletIapUI.bnk();
        AppMethodBeat.o(71929);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(71920);
        super.onCreate(bundle);
        Log.i("MicroMsg.WalletIapUI", "onCreate");
        ao.jV(this);
        g.aAi();
        g.aAg().hqi.a(v2helper.EMethodOutputVolumeGainEnable, this);
        g.aAi();
        g.aAg().hqi.a(414, this);
        g.aAi();
        g.aAg().hqi.a(1130, this);
        g.aAi();
        g.aAg().hqi.a(1306, this);
        if (getIntent().getIntExtra("key_action_type", 200001) == 200001) {
            bnj();
        }
        this.Isg = getIntent().getBooleanExtra("key_is_mini_program", false);
        if (getIntent().getBooleanExtra("key_request_fullscreen", false)) {
            getWindow().addFlags(1024);
        }
        this.Irh = new c();
        this.Irh.Iru = this.Isg;
        if (getIntent().getBooleanExtra("key_force_google", false) || z.aUn()) {
            Log.d("MicroMsg.WalletIapUI", "Pay use Google Wallet!");
            this.Isi = new a(this, this.Irh, this.Irj);
        } else {
            Log.d("MicroMsg.WalletIapUI", "Pay use WeiXin Wallet!");
            this.Isi = new f(this.Irh, this.BaR);
        }
        this.Irh.AQo = this.Isi.fUr();
        EventCenter.instance.addListener(this.IrQ);
        AppMethodBeat.o(71920);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(71921);
        Log.i("MicroMsg.WalletIapUI", "onResume");
        super.onResume();
        Log.i("MicroMsg.WalletIapUI", "Handler jump");
        if (!this.Isf) {
            this.Isf = true;
            Intent intent = getIntent();
            if (intent.getIntExtra("key_action_type", 200001) == 200002) {
                Log.i("MicroMsg.WalletIapUI", "start to restore the purchase!");
                this.GAF = 3;
                this.Isi.c(this, true);
                AppMethodBeat.o(71921);
                return;
            }
            Log.i("MicroMsg.WalletIapUI", "start to doScene!");
            c cVar = this.Irh;
            String stringExtra = intent.getStringExtra("key_product_id");
            cVar.rcD = stringExtra;
            cVar.Irt.add(stringExtra);
            Log.d("MicroMsg.IapData", "prepare pay product: ".concat(String.valueOf(stringExtra)));
            this.Irh.IqG = intent.getStringExtra("key_price");
            this.Irh.IqF = intent.getStringExtra("key_currency_type");
            String stringExtra2 = intent.getStringExtra("key_ext_info");
            this.Irh.mCount = intent.getIntExtra("key_count", 1);
            String stringExtra3 = intent.getStringExtra("key_appid");
            String stringExtra4 = intent.getStringExtra("key_desc");
            String stringExtra5 = intent.getStringExtra("key_busiid");
            this.Irh.Irv = intent.getStringExtra("key_virtual_pay_sign");
            this.Irh.Irw = intent.getStringExtra("key_attach");
            q f2 = this.Irh.f(this.Isi.fUr(), stringExtra2, stringExtra3, stringExtra4, stringExtra5);
            if (f2 != null) {
                g.aAi();
                g.aAg().hqi.a(f2, 0);
                AppMethodBeat.o(71921);
                return;
            }
            Log.e("MicroMsg.WalletIapUI", "getPrepareNetScene error netScene is null");
            this.currentState = 1002;
            c cJ = c.cJ(8, "");
            Intent intent2 = new Intent();
            intent2.putExtra("key_err_code", cJ.mResponse);
            intent2.putExtra("key_err_msg", cJ.mMessage);
            setResult(-1, intent2);
            finish();
        }
        AppMethodBeat.o(71921);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(71922);
        Log.i("MicroMsg.WalletIapUI", "onNewIntent");
        super.onNewIntent(intent);
        AppMethodBeat.o(71922);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        int i2;
        AppMethodBeat.i(71923);
        Log.i("MicroMsg.WalletIapUI", "onDestroy");
        bnk();
        if (this.currentState == 1003) {
            this.currentState = 1001;
        }
        String str = "";
        if (getIntent() != null) {
            str = getIntent().getStringExtra("key_appid");
        }
        if (this.Isi instanceof f) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        long j2 = (long) (Util.getDouble(this.Ish, 0.0d) * 100.0d);
        Log.i("MicroMsg.WalletIapUI", "reportPaymentState report(%s), isMiniProgram : %b, appid %s, walletType %s, currentScene %s, currentState %s, payAmount %s, payamount %s", 15751, Boolean.valueOf(this.Isg), str, Integer.valueOf(i2), Integer.valueOf(this.GAF), Integer.valueOf(this.currentState), this.Ish, Long.valueOf(j2));
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(this.Isg ? 0 : 1);
        objArr[1] = str;
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(this.GAF);
        objArr[4] = Integer.valueOf(this.currentState);
        objArr[5] = this.Ish;
        objArr[6] = Long.valueOf(j2);
        hVar.a(15751, objArr);
        h.INSTANCE.idkeyStat(1044, (long) (this.currentState - 1000), 1, false);
        if (this.currentState == 1001) {
            h.INSTANCE.idkeyStat(1044, (long) (this.GAF + 4), 1, false);
        } else if (this.currentState == 1002) {
            h.INSTANCE.idkeyStat(1044, (long) (this.GAF + 8), 1, false);
        }
        if (this.Isi != null) {
            this.Isi.p(this);
        }
        g.aAi();
        g.aAg().hqi.b(v2helper.EMethodOutputVolumeGainEnable, this);
        g.aAi();
        g.aAg().hqi.b(414, this);
        g.aAi();
        g.aAg().hqi.b(1130, this);
        g.aAi();
        g.aAg().hqi.b(1306, this);
        EventCenter.instance.removeListener(this.IrQ);
        super.onDestroy();
        AppMethodBeat.o(71923);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(71924);
        super.onActivityResult(i2, i3, intent);
        Log.i("MicroMsg.WalletIapUI", "onActivityResult resultCode : ".concat(String.valueOf(i3)));
        if (intent == null || intent.getExtras() == null || intent.getExtras().get("key_total_fee") == null) {
            Log.i("MicroMsg.WalletIapUI", "no payAmount");
        } else {
            this.Ish = intent.getExtras().get("key_total_fee").toString();
            Log.i("MicroMsg.WalletIapUI", "has payAmount:%s", this.Ish);
        }
        if (this.Isi != null) {
            this.Isi.a(this, i2, i3, intent);
            Log.d("MicroMsg.WalletIapUI", "onActivityResult handled by mWalletPay.");
            AppMethodBeat.o(71924);
            return;
        }
        Log.e("MicroMsg.WalletIapUI", "havn't handle user action");
        Intent intent2 = new Intent();
        c cJ = c.cJ(6, "");
        intent2.putExtra("key_err_code", cJ.mResponse);
        intent2.putExtra("key_err_msg", cJ.mMessage);
        intent2.putExtra("key_launch_ts", a.Iri);
        setResult(-1, intent2);
        finish();
        AppMethodBeat.o(71924);
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x020b  */
    @Override // com.tencent.mm.ak.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int r12, int r13, java.lang.String r14, com.tencent.mm.ak.q r15) {
        /*
        // Method dump skipped, instructions count: 846
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet_index.ui.WalletIapUI.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(71926);
        Log.i("MicroMsg.WalletIapUI", "finish");
        bnk();
        super.finish();
        AppMethodBeat.o(71926);
    }

    private void bnj() {
        AppMethodBeat.i(71927);
        Log.i("MicroMsg.WalletIapUI", "showLoadingDialog!");
        this.ocE = com.tencent.mm.wallet_core.ui.h.c(this, getString(R.string.a06), true, new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.wallet_index.ui.WalletIapUI.AnonymousClass5 */

            public final void onCancel(DialogInterface dialogInterface) {
                c cJ;
                AppMethodBeat.i(71918);
                Log.i("MicroMsg.WalletIapUI", "showLoadingDialog onCancel currentScene: %d", Integer.valueOf(WalletIapUI.this.GAF));
                if (WalletIapUI.this.GAF == 2) {
                    cJ = c.cJ(7, "");
                } else {
                    cJ = c.cJ(1, "");
                }
                Intent intent = new Intent();
                intent.putExtra("key_err_code", cJ.mResponse);
                intent.putExtra("key_err_msg", cJ.mMessage);
                WalletIapUI.this.setResult(-1, intent);
                WalletIapUI.this.finish();
                AppMethodBeat.o(71918);
            }
        });
        AppMethodBeat.o(71927);
    }

    private void bnk() {
        AppMethodBeat.i(71928);
        Log.i("MicroMsg.WalletIapUI", "hideLoadingDialog!");
        if (this.ocE != null && this.ocE.isShowing()) {
            this.ocE.dismiss();
            this.ocE = null;
        }
        AppMethodBeat.o(71928);
    }
}
