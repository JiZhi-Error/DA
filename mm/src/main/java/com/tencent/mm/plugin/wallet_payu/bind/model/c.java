package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery;
import com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUBankcardManageUI;
import com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUCardElementUI;
import com.tencent.mm.plugin.wallet_payu.pwd.a.a;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUCheckPwdUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class c extends d {
    @Override // com.tencent.mm.wallet_core.d
    public final d a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(71981);
        Log.d("MicroMsg.PayUBindProcess", "hy: start process: PayUBindProcess");
        b(activity, WalletPayUCheckPwdUI.class, bundle);
        AppMethodBeat.o(71981);
        return this;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void a(Activity activity, int i2, Bundle bundle) {
        AppMethodBeat.i(71982);
        if (activity instanceof WalletPayUCheckPwdUI) {
            b(activity, WalletPayUCardElementUI.class, bundle);
        }
        AppMethodBeat.o(71982);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void g(Activity activity, int i2) {
        AppMethodBeat.i(71983);
        P(activity);
        AppMethodBeat.o(71983);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(71984);
        if (this.dQL.getInt("key_errcode_payu", -1) == 0) {
            u.makeText(activity, (int) R.string.ikd, 0).show();
            a(activity, WalletPayUBankcardManageUI.class, -1, false);
            AppMethodBeat.o(71984);
            return;
        }
        u.makeText(activity, (int) R.string.ice, 0).show();
        a(activity, WalletPayUBankcardManageUI.class, 0, false);
        AppMethodBeat.o(71984);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(71985);
        if (mMActivity instanceof WalletPayUCheckPwdUI) {
            AnonymousClass1 r0 = new a(mMActivity, iVar, this.dQL) {
                /* class com.tencent.mm.plugin.wallet_payu.bind.model.c.AnonymousClass1 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final CharSequence getTips(int i2) {
                    AppMethodBeat.i(71978);
                    if (i2 == 0) {
                        String string = this.activity.getString(R.string.iaw);
                        AppMethodBeat.o(71978);
                        return string;
                    }
                    CharSequence tips = super.getTips(i2);
                    AppMethodBeat.o(71978);
                    return tips;
                }
            };
            AppMethodBeat.o(71985);
            return r0;
        } else if (mMActivity instanceof WalletPayUCardElementUI) {
            AnonymousClass2 r02 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet_payu.bind.model.c.AnonymousClass2 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(71979);
                    if ((qVar instanceof a) && i2 == 0 && i3 == 0) {
                        c.this.dQL.putInt("key_errcode_payu", 0);
                        c.this.b(this.activity, c.this.dQL);
                    }
                    if (qVar instanceof NetScenePayUElementQuery) {
                        if (i2 == 0 && i3 == 0) {
                            NetScenePayUElementQuery.PayUBankcardElement payUBankcardElement = ((NetScenePayUElementQuery) qVar).IsE;
                            if (Util.isNullOrNil(payUBankcardElement.IsF)) {
                                payUBankcardElement.IsG = MMApplicationContext.getContext().getString(R.string.iob);
                            }
                            c.this.dQL.putParcelable("key_card_element", ((NetScenePayUElementQuery) qVar).IsE);
                        } else {
                            NetScenePayUElementQuery.PayUBankcardElement payUBankcardElement2 = new NetScenePayUElementQuery.PayUBankcardElement();
                            if (Util.isNullOrNil(str)) {
                                str = "err card element";
                            }
                            payUBankcardElement2.IsG = str;
                            c.this.dQL.putParcelable("key_card_element", payUBankcardElement2);
                        }
                    }
                    AppMethodBeat.o(71979);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(71980);
                    NetScenePayUElementQuery.PayUBankcardElement payUBankcardElement = (NetScenePayUElementQuery.PayUBankcardElement) c.this.dQL.getParcelable("key_card_element");
                    this.Ruz.b(new a(payUBankcardElement.AOj, payUBankcardElement.IsG, c.this.dQL.getString("key_bank_username"), c.this.dQL.getString("key_card_id"), c.this.dQL.getString("key_expire_data"), payUBankcardElement.cardType, c.this.dQL.getString("key_cvv"), c.this.dQL.getString("key_pwd1")), true);
                    AppMethodBeat.o(71980);
                    return false;
                }
            };
            AppMethodBeat.o(71985);
            return r02;
        } else {
            g a2 = super.a(mMActivity, iVar);
            AppMethodBeat.o(71985);
            return a2;
        }
    }

    @Override // com.tencent.mm.wallet_core.d
    public final String dKC() {
        return "PayUBindProcess";
    }
}
