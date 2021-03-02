package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet_core.c.ah;
import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class p extends d {
    private String HQd;
    private String kof;
    private int scene;
    private String token;

    @Override // com.tencent.mm.wallet_core.d
    public final d a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(70970);
        Log.i("MicroMsg.WalletJSApiVerifyCodeProcess", "start WalletJSApiVerifyCodeProcess");
        this.HQd = bundle.getString("key_relation_key");
        this.kof = bundle.getString("key_pwd1");
        this.token = bundle.getString("key_jsapi_token");
        this.scene = bundle.getInt("key_verify_scene");
        b(activity, WalletVerifyCodeUI.class, bundle);
        AppMethodBeat.o(70970);
        return this;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void a(Activity activity, int i2, Bundle bundle) {
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void g(Activity activity, int i2) {
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(70971);
        Log.i("MicroMsg.WalletJSApiVerifyCodeProcess", "end WalletJSApiVerifyCodeProcess");
        if (this.scene == 8) {
            a(activity, "wallet", ".pay.ui.WalletLoanRepaymentUI", -1, null, false);
            AppMethodBeat.o(70971);
            return;
        }
        a(activity, WalletCheckPwdUI.class, -1, (Intent) null, false);
        AppMethodBeat.o(70971);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final String dKC() {
        return null;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final g a(final MMActivity mMActivity, final i iVar) {
        AppMethodBeat.i(70972);
        AnonymousClass1 r0 = new g(iVar, mMActivity) {
            /* class com.tencent.mm.plugin.wallet_core.ui.p.AnonymousClass1 */

            @Override // com.tencent.mm.wallet_core.d.g
            public final boolean r(Object... objArr) {
                AppMethodBeat.i(70967);
                if (objArr.length == 2) {
                    v vVar = (v) objArr[1];
                    vVar.token = p.this.token;
                    Log.i("MicroMsg.WalletJSApiVerifyCodeProcess", "do NetSceneTenpayVerifySmsByPasswd");
                    iVar.a(new ah(vVar, p.this.HQd), true, 1);
                    AppMethodBeat.o(70967);
                    return true;
                }
                Log.e("MicroMsg.WalletJSApiVerifyCodeProcess", "arguments is error");
                AppMethodBeat.o(70967);
                return false;
            }

            @Override // com.tencent.mm.wallet_core.d.g
            public final boolean B(Object... objArr) {
                AppMethodBeat.i(70968);
                Log.i("MicroMsg.WalletJSApiVerifyCodeProcess", "resend sms");
                iVar.a(new x(p.this.kof, p.this.token, (char) 0), true, 1);
                AppMethodBeat.o(70968);
                return true;
            }

            @Override // com.tencent.mm.wallet_core.d.g
            public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(70969);
                if (i2 != 0 || i3 != 0) {
                    if (qVar instanceof ah) {
                        Log.e("MicroMsg.WalletJSApiVerifyCodeProcess", "send sms fail,errType=" + i2 + ",errCode=" + i3 + ",errMsg=" + str);
                    }
                    AppMethodBeat.o(70969);
                    return false;
                } else if (qVar instanceof ah) {
                    Log.i("MicroMsg.WalletJSApiVerifyCodeProcess", "send sms succ");
                    Bundle bundle = p.this.dQL;
                    bundle.putString("key_jsapi_token", ((ah) qVar).HQm);
                    p.this.b(mMActivity, bundle);
                    AppMethodBeat.o(70969);
                    return true;
                } else if (qVar instanceof x) {
                    AppMethodBeat.o(70969);
                    return true;
                } else {
                    AppMethodBeat.o(70969);
                    return false;
                }
            }
        };
        AppMethodBeat.o(70972);
        return r0;
    }
}
