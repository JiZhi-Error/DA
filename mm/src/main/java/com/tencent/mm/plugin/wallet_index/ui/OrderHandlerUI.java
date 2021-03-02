package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.g.a.lk;
import com.tencent.mm.g.a.pi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.modelpay.WXJointPay;
import com.tencent.mm.plugin.appbrand.jsapi.ct;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.wallet_index.c.h;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.czn;
import com.tencent.mm.protocal.protobuf.exi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.af;

@a(3)
public class OrderHandlerUI extends MMActivity implements i {
    private IListener BaR = new IListener<aaa>() {
        /* class com.tencent.mm.plugin.wallet_index.ui.OrderHandlerUI.AnonymousClass1 */

        {
            AppMethodBeat.i(160897);
            this.__eventId = aaa.class.getName().hashCode();
            AppMethodBeat.o(160897);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aaa aaa) {
            AppMethodBeat.i(71863);
            aaa aaa2 = aaa;
            if (aaa2 == null) {
                Log.f(OrderHandlerUI.this.TAG, "event == null!!!");
                AppMethodBeat.o(71863);
            } else if (aaa2.egJ.egL) {
                Log.f(OrderHandlerUI.this.TAG, "WalletPayResultEvent is from kinda, ScanQRCodePay");
                AppMethodBeat.o(71863);
            } else {
                OrderHandlerUI.this.Irz = true;
                Log.e(OrderHandlerUI.this.TAG, "onPayEnd, isOk = %s notifyPay %s reqKey %s %s, manualresult %s, from %s", Integer.valueOf(aaa2.egJ.result), Boolean.valueOf(OrderHandlerUI.this.IrB), OrderHandlerUI.this.dDL, aaa2.egJ.dDL, Integer.valueOf(aaa2.egJ.egK), Util.getStack().toString());
                if (OrderHandlerUI.this.IrB) {
                    AppMethodBeat.o(71863);
                } else if (aaa2.egJ.egK == 1000) {
                    if (Util.isNullOrNil(aaa2.egJ.dDL) || !aaa2.egJ.dDL.equals(OrderHandlerUI.this.dDL)) {
                        AppMethodBeat.o(71863);
                    } else {
                        OrderHandlerUI.this.finish();
                        AppMethodBeat.o(71863);
                    }
                } else if (aaa2.egJ.egK == 1001) {
                    AppMethodBeat.o(71863);
                } else if (Util.isNullOrNil(aaa2.egJ.dDL) || aaa2.egJ.dDL.equals(OrderHandlerUI.this.dDL)) {
                    if (aaa2.egJ.result == -1) {
                        OrderHandlerUI.this.Iry.errCode = 0;
                        if (OrderHandlerUI.this.IrG) {
                            OrderHandlerUI.this.Iry.returnKey = OrderHandlerUI.this.IrA;
                        } else if (aaa2.egJ.intent == null) {
                            AppMethodBeat.o(71863);
                        } else {
                            Bundle extras = aaa2.egJ.intent.getExtras();
                            String string = extras.getString("intent_pay_app_url");
                            OrderHandlerUI.this.IrA = extras.getString("intent_wap_pay_jump_url");
                            Log.d(OrderHandlerUI.this.TAG, "onPayEnd, returnUrl = ".concat(String.valueOf(string)));
                            OrderHandlerUI.this.Iry.returnKey = string;
                        }
                    } else {
                        OrderHandlerUI.this.Iry.errCode = -2;
                    }
                    if (OrderHandlerUI.this.mScene == 1) {
                        OrderHandlerUI.a(OrderHandlerUI.this, OrderHandlerUI.this, OrderHandlerUI.this.IrA);
                    } else {
                        e.a(OrderHandlerUI.this, OrderHandlerUI.this.jjd, OrderHandlerUI.this.Iry, OrderHandlerUI.this.options);
                    }
                    OrderHandlerUI.this.IrB = true;
                    OrderHandlerUI.this.finish();
                    AppMethodBeat.o(71863);
                } else {
                    Log.e(OrderHandlerUI.this.TAG, "pass notify this req1 %s req2 %s", aaa2.egJ.dDL, OrderHandlerUI.this.dDL);
                    AppMethodBeat.o(71863);
                }
            }
            return false;
        }
    };
    private boolean CsL = false;
    private String IrA = "";
    private boolean IrB = false;
    private boolean IrC = false;
    private boolean IrD = false;
    private boolean IrE = false;
    private boolean IrF = false;
    private boolean IrG = false;
    private IListener IrH = new IListener<lk>() {
        /* class com.tencent.mm.plugin.wallet_index.ui.OrderHandlerUI.AnonymousClass2 */

        {
            AppMethodBeat.i(160898);
            this.__eventId = lk.class.getName().hashCode();
            AppMethodBeat.o(160898);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lk lkVar) {
            AppMethodBeat.i(71864);
            lk lkVar2 = lkVar;
            Log.i(OrderHandlerUI.this.TAG, "KindaGotoExternAppEventCallback event.data.returnKey:%s, event.data.errcode：%d", lkVar2.dQI.returnKey, Integer.valueOf(lkVar2.dQI.dIZ));
            OrderHandlerUI.this.Iry.returnKey = lkVar2.dQI.returnKey;
            OrderHandlerUI.this.Iry.errCode = lkVar2.dQI.dIZ;
            e.a(OrderHandlerUI.this, OrderHandlerUI.this.jjd, OrderHandlerUI.this.Iry, OrderHandlerUI.this.options);
            OrderHandlerUI.this.finish();
            AppMethodBeat.o(71864);
            return true;
        }
    };
    private PayReq Irx;
    private PayResp Iry;
    private boolean Irz = false;
    public String TAG = "MicroMsg.OrderHandlerUI";
    private String dDL;
    private String jjd;
    private int mScene = 0;
    private PayReq.Options options;
    private long peJ = 0;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public OrderHandlerUI() {
        AppMethodBeat.i(71868);
        AppMethodBeat.o(71868);
    }

    static /* synthetic */ void a(OrderHandlerUI orderHandlerUI, Context context, String str) {
        AppMethodBeat.i(71881);
        orderHandlerUI.bR(context, str);
        AppMethodBeat.o(71881);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(71869);
        super.onCreate(bundle);
        this.TAG = "MicroMsg.OrderHandlerUI@" + hashCode();
        this.peJ = getIntent().getLongExtra("wallet_pay_key_check_time", -1);
        setContentViewVisibility(8);
        ab.hht();
        EventCenter.instance.addListener(this.BaR);
        EventCenter.instance.addListener(this.IrH);
        b.hgC();
        this.IrC = b.b(b.a.clicfg_kinda_open, true);
        this.IrD = this.IrC;
        this.IrE = this.IrC;
        com.tencent.mm.wallet_core.b.hgC();
        this.IrF = com.tencent.mm.wallet_core.b.b(b.a.clicfg_kinda_sns_app_pay_open_android, false);
        ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).triggerSoterReInit();
        com.tencent.soter.a.a.hlD();
        AppMethodBeat.o(71869);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0206  */
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        /*
        // Method dump skipped, instructions count: 575
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet_index.ui.OrderHandlerUI.onResume():void");
    }

    private PayReq ckn() {
        PayReq payReq;
        AppMethodBeat.i(71871);
        if (IntentUtil.getInt(getIntent().getExtras(), "_wxapi_command_type", 0) == 27) {
            payReq = new WXJointPay.JointPayReq();
        } else {
            payReq = new PayReq();
        }
        payReq.fromBundle(IntentUtil.getExtras(getIntent()));
        AppMethodBeat.o(71871);
        return payReq;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(71872);
        g.aAi();
        g.aAg().hqi.b(397, this);
        g.aAi();
        g.aAg().hqi.b(2655, this);
        g.aAi();
        g.aAg().hqi.b(ct.CTRL_INDEX, this);
        EventCenter.instance.removeListener(this.BaR);
        EventCenter.instance.removeListener(this.IrH);
        super.onDestroy();
        AppMethodBeat.o(71872);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bh6;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        String str2;
        String str3;
        int i4;
        String str4;
        String str5;
        String str6;
        exi exi;
        AppMethodBeat.i(71873);
        if (qVar.getType() == 397 || qVar.getType() == 2655 || qVar.getType() == 283) {
            PayInfo payInfo = new PayInfo();
            if (this.mScene == 1) {
                payInfo.dVv = 36;
            } else {
                payInfo.dVv = 2;
            }
            g.aAi();
            g.aAg().hqi.b(qVar.getType(), this);
            Log.i(this.TAG, "onSceneEnd, errType = " + i2 + ", errCode = " + i3);
            h hVar = (h) qVar;
            czn czn = (czn) hVar.rr.iLL.iLR;
            if (czn == null) {
                str2 = null;
            } else {
                str2 = czn.MER;
            }
            this.IrA = str2;
            if (i2 == 4 && i3 == -5) {
                Log.e(this.TAG, "onSceneEnd, auth access denied");
                this.Iry.errCode = -1;
                cJ(str, true);
                af.z(payInfo.dVv, this.Irx == null ? "" : this.Irx.prepayId, i3);
                AppMethodBeat.o(71873);
            } else if (i2 == 0 && i3 == 0) {
                czn czn2 = (czn) hVar.rr.iLL.iLR;
                if (czn2 == null) {
                    i4 = -1;
                } else {
                    i4 = czn2.rBL;
                }
                czn czn3 = (czn) hVar.rr.iLL.iLR;
                if (czn3 == null) {
                    str4 = null;
                } else {
                    str4 = czn3.rBM;
                }
                czn czn4 = (czn) hVar.rr.iLL.iLR;
                if (czn4 == null) {
                    str5 = null;
                } else {
                    str5 = czn4.LQv;
                }
                czn czn5 = (czn) hVar.rr.iLL.iLR;
                if (czn5 == null) {
                    str6 = null;
                } else {
                    str6 = czn5.LQw;
                }
                czn czn6 = (czn) hVar.rr.iLL.iLR;
                if (czn6 == null) {
                    exi = null;
                } else {
                    exi = czn6.LQB;
                }
                Log.i(this.TAG, "onSceneEnd, respErrCode = %d, respErrMsg = %s, respPrepayId = %s, respAppSource = %s", Integer.valueOf(i4), str4, str5, str6);
                if (Util.isNullOrNil(str5)) {
                    Log.e(this.TAG, "onSceneEnd, respPrepayId is null");
                    this.Iry.errCode = -1;
                    cJ(str, true);
                    AppMethodBeat.o(71873);
                    return;
                }
                af.z(payInfo.dVv, str5, i3);
                if (exi == null || Util.isNullOrNil(exi.NuI)) {
                    payInfo.appId = this.Irx.appId;
                    payInfo.dDL = str5;
                    payInfo.partnerId = this.Irx.partnerId;
                    payInfo.IqM = str6;
                    payInfo.Kxt = String.valueOf(i4);
                    payInfo.errMsg = str4;
                    if (this.peJ > 0) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(641, 1, 1, true);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(641, 2, Util.milliSecondsToNow(this.peJ), true);
                        if (payInfo.iqp == null) {
                            payInfo.iqp = new Bundle();
                        }
                        payInfo.iqp.putLong("wallet_pay_key_check_time", this.peJ);
                    }
                    f.a(this, payInfo, 123);
                } else {
                    this.IrG = true;
                    Intent intent = new Intent();
                    intent.putExtra("prepayId", str5);
                    intent.putExtra("is_jsapi_offline_pay", false);
                    intent.putExtra("pay_gate_url", exi.NuI);
                    intent.putExtra("need_dialog", exi.NuK);
                    intent.putExtra("dialog_text", exi.NuL);
                    intent.putExtra("max_count", exi.NuJ.LbT);
                    intent.putExtra("inteval_time", exi.NuJ.LbS);
                    intent.putExtra("default_wording", exi.NuJ.LbU);
                    c.c(this, "wallet_core", ".ui.WalletMixOrderInfoUI", intent);
                }
                this.dDL = str5;
                this.Irz = false;
                AppMethodBeat.o(71873);
            } else {
                Log.e(this.TAG, "onSceneEnd,  PayAuthApp is failed!");
                this.Iry.errCode = -1;
                cJ(str, true);
                int i5 = payInfo.dVv;
                if (this.Irx == null) {
                    str3 = "";
                } else {
                    str3 = this.Irx.prepayId;
                }
                af.z(i5, str3, i3);
                AppMethodBeat.o(71873);
            }
        } else {
            AppMethodBeat.o(71873);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(71874);
        Log.i(this.TAG, "onActivityResult resp %s, onPayEndCalled %s", this.Iry, Boolean.valueOf(this.Irz));
        if (intent != null) {
            int intExtra = intent.getIntExtra("key_pay_reslut_type", 0);
            if (intExtra == 1000) {
                Log.i(this.TAG, "onActivityResult resp %s, onPayEndCalled %s payResultType %s", this.Iry, Boolean.valueOf(this.Irz), Integer.valueOf(intExtra));
                finish();
                AppMethodBeat.o(71874);
                return;
            } else if (intExtra == 1001) {
                AppMethodBeat.o(71874);
                return;
            }
        }
        if (this.Iry != null && !this.Irz) {
            Log.e(this.TAG, "onActivityResult, onPayEnd not called");
            this.Iry.errCode = -2;
            cJ("", false);
        }
        AppMethodBeat.o(71874);
    }

    private void cJ(String str, boolean z) {
        AppMethodBeat.i(71875);
        if (this.mScene != 1) {
            e.a(this, this.jjd, this.Iry, this.options);
            finish();
            AppMethodBeat.o(71875);
        } else if (!TextUtils.isEmpty(this.IrA) || !z) {
            bR(this, this.IrA);
            finish();
            AppMethodBeat.o(71875);
        } else {
            setContentViewVisibility(0);
            amW(str);
            AppMethodBeat.o(71875);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(71876);
        Log.i(this.TAG, "finish hasFinish %s %s", Boolean.valueOf(this.CsL), Util.getStack().toString());
        if (this.CsL) {
            AppMethodBeat.o(71876);
            return;
        }
        this.CsL = true;
        super.finish();
        AppMethodBeat.o(71876);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(71877);
        super.onConfigurationChanged(configuration);
        Log.i(this.TAG, "onConfigurationChanged");
        AppMethodBeat.o(71877);
    }

    private void fUt() {
        AppMethodBeat.i(71878);
        if (!((com.tencent.mm.pluginsdk.wallet.a) g.af(com.tencent.mm.pluginsdk.wallet.a.class)).canOpenKindaCashier(this)) {
            com.tencent.mm.ui.base.h.a(this, getString(R.string.ieo), "", getString(R.string.ame), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_index.ui.OrderHandlerUI.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(71865);
                    OrderHandlerUI.this.finish();
                    AppMethodBeat.o(71865);
                }
            });
            AppMethodBeat.o(71878);
        } else if (((Boolean) com.tencent.mm.pluginsdk.wallet.g.gsU().get("key_pay_offline_is_auth_doing", Boolean.FALSE)).booleanValue()) {
            com.tencent.mm.ui.base.h.a(this, getString(R.string.ieo), "", getString(R.string.ame), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_index.ui.OrderHandlerUI.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(71866);
                    OrderHandlerUI.this.finish();
                    AppMethodBeat.o(71866);
                }
            });
            AppMethodBeat.o(71878);
        } else {
            pi piVar = new pi();
            piVar.dVr.ret = 1;
            EventCenter.instance.publish(piVar);
            AppMethodBeat.o(71878);
        }
    }

    private void bR(Context context, String str) {
        AppMethodBeat.i(71879);
        if (context == null) {
            Log.e(this.TAG, "startOuterApp context == null");
            AppMethodBeat.o(71879);
        } else if (TextUtils.isEmpty(str)) {
            Log.e(this.TAG, "startOuterApp callbackUrl is empty");
            AppMethodBeat.o(71879);
        } else {
            Log.i(this.TAG, "startOuterApp callbackUrl is ".concat(String.valueOf(str)));
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            if (Util.isIntentAvailable(context, intent)) {
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI", "startOuterApp", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI", "startOuterApp", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            AppMethodBeat.o(71879);
        }
    }

    private void amW(String str) {
        AppMethodBeat.i(71880);
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.itf);
        }
        com.tencent.mm.ui.base.h.a((Context) this, str, (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_index.ui.OrderHandlerUI.AnonymousClass5 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(71867);
                dialogInterface.dismiss();
                OrderHandlerUI.this.finish();
                AppMethodBeat.o(71867);
            }
        });
        AppMethodBeat.o(71880);
    }
}
