package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.wallet.bind.a;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUBankcardDetailUI;
import com.tencent.mm.plugin.wallet_payu.pwd.a.c;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUCheckPwdUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.d.i;

public class d extends a {
    @Override // com.tencent.mm.plugin.wallet.bind.a
    public final void e(Activity activity, Bundle bundle) {
        AppMethodBeat.i(71989);
        b(activity, WalletPayUBankcardDetailUI.class, bundle);
        AppMethodBeat.o(71989);
    }

    @Override // com.tencent.mm.plugin.wallet.bind.a, com.tencent.mm.wallet_core.d
    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(71990);
        if (this.dQL.getInt("key_errcode_payu", -1) == 0) {
            u.makeText(activity, (int) R.string.ikd, 0).show();
        } else {
            u.makeText(activity, (int) R.string.ice, 0).show();
        }
        boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_android_walletv2_open_config, true);
        Log.i("MicroMsg.PayUUnbindProcess", " walletMallV2 switch is ：%s", Boolean.valueOf(a2));
        if (a2) {
            e(activity, "mall", ".ui.MallIndexUIv2");
            AppMethodBeat.o(71990);
            return;
        }
        e(activity, "mall", ".ui.MallIndexUI");
        AppMethodBeat.o(71990);
    }

    @Override // com.tencent.mm.plugin.wallet.bind.a, com.tencent.mm.wallet_core.d
    public final void a(Activity activity, int i2, Bundle bundle) {
        AppMethodBeat.i(71991);
        if (activity instanceof WalletBankcardDetailUI) {
            b(activity, WalletPayUCheckPwdUI.class, bundle);
            AppMethodBeat.o(71991);
            return;
        }
        if (activity instanceof WalletPayUCheckPwdUI) {
            b(activity, bundle);
        }
        AppMethodBeat.o(71991);
    }

    @Override // com.tencent.mm.plugin.wallet.bind.a, com.tencent.mm.wallet_core.d
    public final com.tencent.mm.wallet_core.d.g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(71992);
        if (mMActivity instanceof WalletPayUCheckPwdUI) {
            AnonymousClass1 r0 = new com.tencent.mm.wallet_core.d.g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet_payu.bind.model.d.AnonymousClass1 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final CharSequence getTips(int i2) {
                    AppMethodBeat.i(71986);
                    if (i2 == 0) {
                        String string = this.activity.getString(R.string.ib9);
                        AppMethodBeat.o(71986);
                        return string;
                    }
                    CharSequence tips = super.getTips(i2);
                    AppMethodBeat.o(71986);
                    return tips;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(71987);
                    if (qVar instanceof c) {
                        if (i3 == 0 && i2 == 0) {
                            c cVar = (c) qVar;
                            d.this.dQL.putString("payu_reference", cVar.token);
                            if (!Util.isNullOrNil(cVar.token)) {
                                Log.d("MicroMsg.PayUUnbindProcess", "hy: check pwd pass");
                                Bankcard bankcard = (Bankcard) d.this.dQL.getParcelable("key_bankcard");
                                if (bankcard != null) {
                                    this.Ruz.b(new b(bankcard.field_bindSerial, d.this.dQL.getString("payu_reference")), true);
                                }
                            } else {
                                Log.w("MicroMsg.PayUUnbindProcess", "hy: check pwd failed");
                            }
                        }
                    } else if (qVar instanceof b) {
                        if (i2 == 0 && i3 == 0) {
                            d.this.dQL.putInt("key_errcode_payu", 0);
                            d.this.b(this.activity, d.this.dQL);
                        }
                        AppMethodBeat.o(71987);
                        return false;
                    }
                    AppMethodBeat.o(71987);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(71988);
                    d.this.dQL.putString("key_pwd1", (String) objArr[0]);
                    this.Ruz.b(new c(d.this.dQL.getString("key_pwd1")), true);
                    AppMethodBeat.o(71988);
                    return true;
                }
            };
            AppMethodBeat.o(71992);
            return r0;
        }
        com.tencent.mm.wallet_core.d.g a2 = super.a(mMActivity, iVar);
        AppMethodBeat.o(71992);
        return a2;
    }

    @Override // com.tencent.mm.plugin.wallet.bind.a, com.tencent.mm.wallet_core.d
    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }
}
