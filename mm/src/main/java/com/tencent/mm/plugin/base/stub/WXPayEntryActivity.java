package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.jc;
import com.tencent.mm.kernel.a;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.modelpay.WXJointPay;
import com.tencent.mm.plugin.wallet_index.ui.e;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class WXPayEntryActivity extends AutoLoginActivity {
    private String jjd = null;
    private long peJ = 0;

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22320);
        this.peJ = System.currentTimeMillis();
        IntentUtil.putExtra(getIntent(), "key_auto_login_wizard_exit", true);
        super.onCreate(bundle);
        AppMethodBeat.o(22320);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity
    public final boolean ab(Intent intent) {
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity
    public final void a(AutoLoginActivity.a aVar, Intent intent) {
        boolean z;
        AppMethodBeat.i(22321);
        if (intent == null) {
            finish();
            AppMethodBeat.o(22321);
            return;
        }
        Log.i("MicroMsg.WXPayEntryActivity", "postLogin, delegate intent to OrderHandlerUI, resultCode = ".concat(String.valueOf(aVar)));
        switch (aVar) {
            case LOGIN_OK:
                Log.i("MicroMsg.WXPayEntryActivity", "coreaccount st %s", Boolean.valueOf(a.azj()));
                if (a.azj()) {
                    finish();
                    AppMethodBeat.o(22321);
                    return;
                }
                break;
            case LOGIN_CANCEL:
                CH(-2);
                Log.e("MicroMsg.WXPayEntryActivity", "postLogin fail, loginResult = ".concat(String.valueOf(aVar)));
                finish();
                AppMethodBeat.o(22321);
                return;
            case LOGIN_FAIL:
                CH(-1);
                Log.e("MicroMsg.WXPayEntryActivity", "postLogin fail, loginResult = ".concat(String.valueOf(aVar)));
                finish();
                AppMethodBeat.o(22321);
                return;
            default:
                Log.e("MicroMsg.WXPayEntryActivity", "postLogin, unknown login result = ".concat(String.valueOf(aVar)));
                break;
        }
        this.jjd = IntentUtil.getStringExtra(intent, ConstantsAPI.APP_PACKAGE);
        Log.i("MicroMsg.WXPayEntryActivity", "postLogin, getCallingPackage success, value = " + this.jjd);
        if (getIntent() == null || IntentUtil.getExtras(getIntent()) == null) {
            z = false;
        } else {
            String str = ckn().appId;
            Log.d("MicroMsg.WXPayEntryActivity", "postLogin, appId = ".concat(String.valueOf(str)));
            if (str == null || str.length() == 0) {
                Log.e("MicroMsg.WXPayEntryActivity", "checkApp fail, appId is null");
                z = false;
            } else {
                g o = h.o(str, true, false);
                if (o == null) {
                    Log.w("MicroMsg.WXPayEntryActivity", "checkApp fail, not reg");
                    g gVar = new g();
                    gVar.field_appId = str;
                    gVar.field_appName = "";
                    gVar.field_packageName = this.jjd;
                    gVar.field_status = 0;
                    String ch = q.ch(this, this.jjd);
                    if (ch != null) {
                        gVar.field_signature = ch;
                    }
                    if (ao.eAS().r(gVar) && Util.isNullOrNil(gVar.field_openId)) {
                        Log.d("MicroMsg.WXPayEntryActivity", "checkApp, trigger getAppSetting, appId = ".concat(String.valueOf(str)));
                        ao.eAU().add(str);
                    }
                    z = true;
                } else if (o.field_status == 3) {
                    Log.e("MicroMsg.WXPayEntryActivity", "checkApp fail, app is in blacklist");
                    z = false;
                } else if (!q.a(this, o, this.jjd, true)) {
                    a(this, o, this.jjd, IntentUtil.getInt(getIntent().getExtras(), "_wxapi_command_type", 0));
                    Log.e("MicroMsg.WXPayEntryActivity", "checkApp fail, app invalid");
                    z = false;
                } else {
                    z = true;
                }
            }
        }
        if (!z) {
            Log.e("MicroMsg.WXPayEntryActivity", "postLogin, checkApp fail");
        }
        if (!((com.tencent.mm.pluginsdk.wallet.a) com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).canOpenKindaCashier(this)) {
            com.tencent.mm.ui.base.h.a(this, getString(R.string.ieo), "", getString(R.string.ame), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.base.stub.WXPayEntryActivity.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(22318);
                    WXPayEntryActivity.this.finish();
                    AppMethodBeat.o(22318);
                }
            });
            AppMethodBeat.o(22321);
            return;
        }
        IntentUtil.putExtra(intent, "key_scene", 0);
        Bundle extras = IntentUtil.getExtras(intent);
        extras.putLong("wallet_pay_key_check_time", this.peJ);
        f.a(this, extras, z, "");
        finish();
        AppMethodBeat.o(22321);
    }

    private static void a(Context context, g gVar, String str, int i2) {
        AppMethodBeat.i(22322);
        Signature[] cj = q.cj(context, str);
        String str2 = "";
        if (cj != null && cj.length > 0) {
            for (int i3 = 0; i3 < cj.length; i3++) {
                str2 = str2 + r.bdM(com.tencent.mm.b.g.getMessageDigest(cj[i3].toByteArray())) + "|";
            }
        }
        if (str2.length() > 1) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("raw_package_name", Util.nullAs(str, ""));
            jSONObject.put("package_name", Util.nullAs(gVar.field_packageName, ""));
            jSONObject.put("raw_signature", str2);
            jSONObject.put("signature", Util.nullAs(gVar.field_signature, ""));
            jSONObject.put("scene", i2);
        } catch (Exception e2) {
            Log.i("MicroMsg.WXPayEntryActivity", "doIfAppInValid, jsonException = " + e2.getMessage());
        }
        jc jcVar = new jc();
        jcVar.dNK.appId = gVar.field_appId;
        jcVar.dNK.opType = 3;
        jcVar.dNK.dFN = jSONObject.toString();
        EventCenter.instance.publish(jcVar);
        AppMethodBeat.o(22322);
    }

    private void CH(int i2) {
        AppMethodBeat.i(22323);
        PayReq ckn = ckn();
        PayReq.Options options = new PayReq.Options();
        options.fromBundle(IntentUtil.getExtras(getIntent()));
        PayResp cko = cko();
        cko.prepayId = ckn.prepayId;
        cko.extData = ckn.extData;
        cko.errCode = i2;
        e.a(this, IntentUtil.getStringExtra(getIntent(), ConstantsAPI.APP_PACKAGE), cko, options);
        AppMethodBeat.o(22323);
    }

    private PayReq ckn() {
        PayReq payReq;
        AppMethodBeat.i(22324);
        if (IntentUtil.getInt(getIntent().getExtras(), "_wxapi_command_type", 0) == 27) {
            payReq = new WXJointPay.JointPayReq();
        } else {
            payReq = new PayReq();
        }
        payReq.fromBundle(IntentUtil.getExtras(getIntent()));
        AppMethodBeat.o(22324);
        return payReq;
    }

    private PayResp cko() {
        PayResp payResp;
        AppMethodBeat.i(22325);
        if (IntentUtil.getInt(getIntent().getExtras(), "_wxapi_command_type", 0) == 27) {
            payResp = new WXJointPay.JointPayResp();
        } else {
            payResp = new PayResp();
        }
        AppMethodBeat.o(22325);
        return payResp;
    }
}
