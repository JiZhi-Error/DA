package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wxcredit.a.c;
import com.tencent.mm.plugin.wxcredit.a.e;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountResultUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class b extends d {
    @Override // com.tencent.mm.wallet_core.d
    public final d a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(72246);
        Log.d("MicroMsg.WXCreditChangeAmountProcess", "start Process : WXCreditChangeAmountProcess");
        b(activity, WalletCheckPwdUI.class, bundle);
        AppMethodBeat.o(72246);
        return this;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void a(Activity activity, int i2, Bundle bundle) {
        AppMethodBeat.i(72247);
        if (activity instanceof WalletCheckPwdUI) {
            b(activity, WalletWXCreditChangeAmountUI.class, bundle);
            AppMethodBeat.o(72247);
        } else if (activity instanceof WalletWXCreditChangeAmountUI) {
            b(activity, WalletWXCreditChangeAmountResultUI.class, bundle);
            AppMethodBeat.o(72247);
        } else {
            if (activity instanceof WalletWXCreditChangeAmountResultUI) {
                b(activity, bundle);
            }
            AppMethodBeat.o(72247);
        }
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void g(Activity activity, int i2) {
        AppMethodBeat.i(72248);
        P(activity);
        AppMethodBeat.o(72248);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(72249);
        e(activity, "wallet", ".bind.ui.WalletBankcardManageUI");
        AppMethodBeat.o(72249);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(72250);
        if (mMActivity instanceof WalletWXCreditChangeAmountUI) {
            AnonymousClass1 r0 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wxcredit.b.AnonymousClass1 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(72242);
                    if (i2 == 0 && i3 == 0) {
                        if (qVar instanceof e) {
                            b.this.dQL.putString("kreq_token", ((e) qVar).token);
                            AppMethodBeat.o(72242);
                            return false;
                        } else if (qVar instanceof c) {
                            b.this.dQL.putDouble("key_credit_amount", ((c) qVar).JPH);
                            b.this.a(this.activity, 0, b.this.dQL);
                            AppMethodBeat.o(72242);
                            return true;
                        }
                    }
                    AppMethodBeat.o(72242);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(72243);
                    this.Ruz.a(new e(((Bankcard) b.this.dQL.getParcelable("key_bankcard")).field_bindSerial), true, 1);
                    AppMethodBeat.o(72243);
                    return true;
                }
            };
            AppMethodBeat.o(72250);
            return r0;
        } else if (mMActivity instanceof WalletCheckPwdUI) {
            AnonymousClass2 r02 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wxcredit.b.AnonymousClass2 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(72244);
                    if (i2 == 0 && i3 == 0) {
                        b.this.a(this.activity, 0, b.this.dQL);
                        this.activity.finish();
                        AppMethodBeat.o(72244);
                        return true;
                    }
                    AppMethodBeat.o(72244);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(72245);
                    b.this.dQL.putString("key_pwd1", (String) objArr[0]);
                    this.Ruz.a(new w((String) objArr[0], 5, ""), true, 1);
                    AppMethodBeat.o(72245);
                    return true;
                }
            };
            AppMethodBeat.o(72250);
            return r02;
        } else {
            AppMethodBeat.o(72250);
            return null;
        }
    }

    @Override // com.tencent.mm.wallet_core.d
    public final String dKC() {
        return "WXCreditChangeAmountProcess";
    }
}
