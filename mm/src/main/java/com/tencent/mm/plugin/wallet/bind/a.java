package com.tencent.mm.plugin.wallet.bind;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.og;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class a extends d {
    @Override // com.tencent.mm.wallet_core.d
    public final d a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(69055);
        Log.d("MicroMsg.ProcessManager", "start Process : UnbindProcess");
        if (bundle.getBoolean("key_is_show_detail", true)) {
            e(activity, bundle);
        } else {
            b(activity, WalletCheckPwdUI.class, bundle);
        }
        AppMethodBeat.o(69055);
        return this;
    }

    /* access modifiers changed from: protected */
    public void e(Activity activity, Bundle bundle) {
        AppMethodBeat.i(69056);
        b(activity, WalletBankcardDetailUI.class, bundle);
        AppMethodBeat.o(69056);
    }

    @Override // com.tencent.mm.wallet_core.d
    public void a(Activity activity, int i2, Bundle bundle) {
        AppMethodBeat.i(69057);
        if (activity instanceof WalletBankcardDetailUI) {
            b(activity, WalletCheckPwdUI.class, bundle);
            AppMethodBeat.o(69057);
            return;
        }
        if (activity instanceof WalletCheckPwdUI) {
            b(activity, bundle);
        }
        AppMethodBeat.o(69057);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void g(Activity activity, int i2) {
        AppMethodBeat.i(69058);
        P(activity);
        AppMethodBeat.o(69058);
    }

    @Override // com.tencent.mm.wallet_core.d
    public void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(69059);
        if (this.dQL.getInt("scene", -1) == 1) {
            int i2 = bundle.getInt("key_process_result_code", 0);
            a(activity, "wallet", ".bind.ui.WalletUnbindBankCardProxyUI", i2, false);
            if (i2 == -1) {
                og ogVar = new og();
                ogVar.dUv.scene = 2;
                EventCenter.instance.publish(ogVar);
            }
            AppMethodBeat.o(69059);
        } else if (this.dQL.getInt("scene", -1) == 2) {
            e(activity, "wallet", ".balance.ui.WalletBalanceManagerUI");
            AppMethodBeat.o(69059);
        } else {
            boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_android_walletv2_open_config, true);
            Log.i("MicroMsg.ProcessManager", " walletMallV2 switch is ：%s", Boolean.valueOf(a2));
            if (a2) {
                e(activity, "mall", ".ui.MallIndexUIv2");
                AppMethodBeat.o(69059);
                return;
            }
            e(activity, "mall", ".ui.MallIndexUI");
            AppMethodBeat.o(69059);
        }
    }

    @Override // com.tencent.mm.wallet_core.d
    public com.tencent.mm.wallet_core.d.g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(69060);
        if (mMActivity instanceof WalletCheckPwdUI) {
            AnonymousClass1 r0 = new com.tencent.mm.wallet_core.d.g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wallet.bind.a.AnonymousClass1 */
                private String dDL = null;

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(69051);
                    if (qVar instanceof com.tencent.mm.plugin.wallet.bind.a.d) {
                        if (i2 == 0 && i3 == 0) {
                            a.this.dQL.putInt("key_process_result_code", -1);
                            if (a.this.c(this.activity, (Bundle) null)) {
                                this.Ruz.a(new ad(this.dDL, 14), true, 1);
                            } else {
                                a.this.a(this.activity, 0, (Bundle) null);
                                if (this.activity instanceof WalletBaseUI) {
                                    ((WalletBaseUI) this.activity).cleanUiData(0);
                                }
                                this.activity.finish();
                            }
                            AppMethodBeat.o(69051);
                            return true;
                        }
                        a.this.dQL.putInt("key_process_result_code", 1);
                    }
                    AppMethodBeat.o(69051);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean A(Object... objArr) {
                    boolean z;
                    AppMethodBeat.i(69052);
                    Bankcard bankcard = (Bankcard) a.this.dQL.getParcelable("key_bankcard");
                    if (bankcard == null || bankcard.field_bankcardState != 1) {
                        a.this.dQL.putInt("key_process_result_code", 1);
                        boolean A = super.A(objArr);
                        AppMethodBeat.o(69052);
                        return A;
                    }
                    i iVar = this.Ruz;
                    String str = bankcard.field_bankcardType;
                    String str2 = bankcard.field_bindSerial;
                    if (a.this.dQL.getInt("scene", -1) == 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    iVar.a(new com.tencent.mm.plugin.wallet.bind.a.d(str, str2, z), true, 1);
                    a.this.dQL.putBoolean("key_is_expired_bankcard", true);
                    AppMethodBeat.o(69052);
                    return true;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    boolean z;
                    AppMethodBeat.i(69053);
                    Bankcard bankcard = (Bankcard) a.this.dQL.getParcelable("key_bankcard");
                    String str = (String) objArr[0];
                    this.dDL = (String) objArr[1];
                    if (bankcard != null) {
                        i iVar = this.Ruz;
                        String str2 = bankcard.field_bankcardType;
                        String str3 = bankcard.field_bindSerial;
                        if (a.this.dQL.getInt("scene", -1) == 2) {
                            z = true;
                        } else {
                            z = false;
                        }
                        iVar.a(new com.tencent.mm.plugin.wallet.bind.a.d(str2, str3, str, z), true, 1);
                        AppMethodBeat.o(69053);
                        return true;
                    }
                    a.this.dQL.putInt("key_process_result_code", 1);
                    AppMethodBeat.o(69053);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final CharSequence getTips(int i2) {
                    AppMethodBeat.i(69054);
                    switch (i2) {
                        case 1:
                            String string = this.activity.getString(R.string.ie9);
                            AppMethodBeat.o(69054);
                            return string;
                        default:
                            CharSequence tips = super.getTips(i2);
                            AppMethodBeat.o(69054);
                            return tips;
                    }
                }
            };
            AppMethodBeat.o(69060);
            return r0;
        }
        com.tencent.mm.wallet_core.d.g a2 = super.a(mMActivity, iVar);
        AppMethodBeat.o(69060);
        return a2;
    }

    @Override // com.tencent.mm.wallet_core.d
    public boolean c(Activity activity, Bundle bundle) {
        if (activity instanceof WalletCheckPwdUI) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final String dKC() {
        return "UnbindProcess";
    }
}
