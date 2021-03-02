package com.tencent.mm.plugin.luckymoney.sns;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.vt;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class a extends d {
    @Override // com.tencent.mm.wallet_core.d
    public final d a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(65346);
        if (activity instanceof SnsLuckyMoneyFreePwdSetting) {
            b(activity, WalletCheckPwdUI.class, bundle);
        }
        AppMethodBeat.o(65346);
        return this;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void a(Activity activity, int i2, Bundle bundle) {
        AppMethodBeat.i(65347);
        b(activity, bundle);
        AppMethodBeat.o(65347);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void g(Activity activity, int i2) {
        AppMethodBeat.i(65348);
        b(activity, null);
        AppMethodBeat.o(65348);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(65349);
        Intent intent = new Intent();
        if (bundle == null) {
            bundle = new Bundle();
        }
        intent.putExtras(bundle);
        a(activity, "luckymoney", ".sns.SnsLuckyMoneyFreePwdSetting", -1, intent, true);
        AppMethodBeat.o(65349);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final String dKC() {
        return "LuckyFreePwdProcess";
    }

    @Override // com.tencent.mm.wallet_core.d
    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(65350);
        if (mMActivity instanceof WalletCheckPwdUI) {
            AnonymousClass1 r0 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.luckymoney.sns.a.AnonymousClass1 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(65344);
                    if (qVar instanceof com.tencent.mm.plugin.luckymoney.sns.a.a) {
                        Log.i("MicroMsg.ProcessManager", "OpenSnsPayProcess onSceneEnd, errType:" + i2 + " errCode:" + i3 + " errMsg:" + str);
                        if (i2 == 0 && i3 == 0) {
                            h.cD(this.activity, this.activity.getString(R.string.eqz));
                            a.PM(121);
                            a.this.dQL.putBoolean("is_open_sns_pay", true);
                            a.this.a(this.activity, 0, a.this.dQL);
                        } else {
                            h.cD(this.activity, this.activity.getString(R.string.eqy));
                            a.PM(122);
                            a.this.g(this.activity, 0);
                        }
                        AppMethodBeat.o(65344);
                        return true;
                    }
                    AppMethodBeat.o(65344);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(65345);
                    this.Ruz.a(new com.tencent.mm.plugin.luckymoney.sns.a.a(1, (String) objArr[0], ""), true, 1);
                    AppMethodBeat.o(65345);
                    return true;
                }
            };
            AppMethodBeat.o(65350);
            return r0;
        }
        g a2 = super.a(mMActivity, iVar);
        AppMethodBeat.o(65350);
        return a2;
    }

    static /* synthetic */ void PM(int i2) {
        AppMethodBeat.i(65351);
        vt vtVar = new vt();
        vtVar.ebU.key = i2;
        vtVar.ebU.value = 1;
        vtVar.ebU.ebV = true;
        EventCenter.instance.publish(vtVar);
        AppMethodBeat.o(65351);
    }
}
