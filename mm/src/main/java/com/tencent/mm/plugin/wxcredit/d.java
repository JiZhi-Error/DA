package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wxcredit.a.f;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditErrDetailUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.i;

public class d extends com.tencent.mm.wallet_core.d {
    @Override // com.tencent.mm.wallet_core.d
    public final com.tencent.mm.wallet_core.d a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(72262);
        Log.d("MicroMsg.WXCreditManagerProcess", "start Process : WXCreditManagerProcess");
        b(activity, WalletWXCreditDetailUI.class, bundle);
        AppMethodBeat.o(72262);
        return this;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void a(Activity activity, int i2, Bundle bundle) {
        AppMethodBeat.i(72263);
        if (i2 == 1) {
            b(activity, WalletWXCreditErrDetailUI.class, bundle);
            activity.finish();
            AppMethodBeat.o(72263);
        } else if (activity instanceof WalletWXCreditDetailUI) {
            b(activity, WalletCheckPwdUI.class, bundle);
            AppMethodBeat.o(72263);
        } else if (activity instanceof WalletCheckPwdUI) {
            b(activity, bundle);
            AppMethodBeat.o(72263);
        } else {
            if (activity instanceof WalletWXCreditErrDetailUI) {
                b(activity, WalletCheckPwdUI.class, bundle);
            }
            AppMethodBeat.o(72263);
        }
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void g(Activity activity, int i2) {
        AppMethodBeat.i(72264);
        P(activity);
        AppMethodBeat.o(72264);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(72265);
        boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_android_walletv2_open_config, true);
        Log.i("MicroMsg.WXCreditManagerProcess", " walletMallV2 switch is ：%s", Boolean.valueOf(a2));
        if (a2) {
            e(activity, "mall", ".ui.MallIndexUIv2");
            AppMethodBeat.o(72265);
            return;
        }
        e(activity, "mall", ".ui.MallIndexUI");
        AppMethodBeat.o(72265);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final com.tencent.mm.wallet_core.d.g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(72266);
        if (mMActivity instanceof WalletWXCreditDetailUI) {
            AnonymousClass1 r0 = new com.tencent.mm.wallet_core.d.g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wxcredit.d.AnonymousClass1 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean A(Object... objArr) {
                    AppMethodBeat.i(72258);
                    Bankcard bankcard = (Bankcard) objArr[0];
                    this.Ruz.a(new com.tencent.mm.plugin.wxcredit.a.d(bankcard.field_bindSerial, bankcard.field_bankcardType), true, 1);
                    AppMethodBeat.o(72258);
                    return true;
                }
            };
            AppMethodBeat.o(72266);
            return r0;
        } else if (mMActivity instanceof WalletCheckPwdUI) {
            AnonymousClass2 r02 = new com.tencent.mm.wallet_core.d.g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wxcredit.d.AnonymousClass2 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(72259);
                    if (i2 == 0 && i3 == 0) {
                        if (qVar instanceof f) {
                            this.Ruz.b(new ad(), true);
                        } else if (qVar instanceof ad) {
                            d.this.b(this.activity, d.this.dQL);
                        }
                        AppMethodBeat.o(72259);
                        return true;
                    }
                    AppMethodBeat.o(72259);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(72260);
                    Bankcard bankcard = (Bankcard) d.this.dQL.getParcelable("key_bankcard");
                    this.Ruz.a(new f(bankcard.field_bankcardType, bankcard.field_bindSerial, (String) objArr[0]), true, 1);
                    AppMethodBeat.o(72260);
                    return true;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean A(Object... objArr) {
                    AppMethodBeat.i(72261);
                    Bankcard bankcard = (Bankcard) objArr[0];
                    this.Ruz.a(new com.tencent.mm.plugin.wxcredit.a.d(bankcard.field_bindSerial, bankcard.field_bankcardType), true, 1);
                    AppMethodBeat.o(72261);
                    return true;
                }
            };
            AppMethodBeat.o(72266);
            return r02;
        } else {
            com.tencent.mm.wallet_core.d.g a2 = super.a(mMActivity, iVar);
            AppMethodBeat.o(72266);
            return a2;
        }
    }

    @Override // com.tencent.mm.wallet_core.d
    public final String dKC() {
        return "WXCreditManagerProcess";
    }
}
