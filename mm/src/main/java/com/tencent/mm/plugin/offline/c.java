package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.oe;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.offline.a.k;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class c extends b {
    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.plugin.wallet_core.b.b, com.tencent.mm.wallet_core.d
    public final d a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(66190);
        d a2 = super.a(activity, bundle);
        AppMethodBeat.o(66190);
        return a2;
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.plugin.wallet_core.b.b, com.tencent.mm.wallet_core.d
    public final void a(Activity activity, int i2, Bundle bundle) {
        AppMethodBeat.i(66191);
        super.a(activity, i2, bundle);
        AppMethodBeat.o(66191);
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.b, com.tencent.mm.wallet_core.d
    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(66192);
        EventCenter.instance.publish(new oe());
        if (a.eAj()) {
            c(activity, WalletOfflineEntranceUI.class);
        } else if (bundle.getInt("key_entry_scene", -1) == 2) {
            e(activity, "offline", "ui.WalletOfflineEntranceUI");
        } else if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_walletv2_open_config, true)) {
            e(activity, "mall", ".ui.MallIndexUIv2");
        } else {
            e(activity, "mall", ".ui.MallIndexUI");
        }
        if (activity != null) {
            activity.finish();
        }
        AppMethodBeat.o(66192);
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.b, com.tencent.mm.wallet_core.d
    public final com.tencent.mm.wallet_core.d.g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(66193);
        if (mMActivity instanceof WalletVerifyCodeUI) {
            AnonymousClass1 r0 = new com.tencent.mm.wallet_core.d.g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.offline.c.AnonymousClass1 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(66186);
                    v vVar = (v) objArr[1];
                    vVar.flag = "2";
                    this.Ruz.a(new com.tencent.mm.plugin.wallet_core.c.v(vVar), true, 1);
                    AppMethodBeat.o(66186);
                    return true;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(66187);
                    if (i2 == 0 && i3 == 0) {
                        if (qVar instanceof ad) {
                            if (((WalletBaseUI) this.activity).getInput() != null && ((WalletBaseUI) this.activity).getInput().getInt("key_bind_scene", -1) == 5 && !a.eAj()) {
                                c.l(this.activity);
                                AppMethodBeat.o(66187);
                                return true;
                            }
                        } else if (qVar instanceof k) {
                            com.tencent.mm.wallet_core.a.l(this.activity, ((WalletBaseUI) this.activity).getInput());
                            a.aA(this.activity);
                            AppMethodBeat.o(66187);
                            return true;
                        }
                    }
                    AppMethodBeat.o(66187);
                    return false;
                }
            };
            AppMethodBeat.o(66193);
            return r0;
        } else if (mMActivity instanceof WalletPwdConfirmUI) {
            AnonymousClass2 r02 = new com.tencent.mm.wallet_core.d.g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.offline.c.AnonymousClass2 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(66188);
                    this.Ruz.a(new com.tencent.mm.plugin.wallet_core.b.a.b((v) objArr[0]), true, 1);
                    AppMethodBeat.o(66188);
                    return true;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(66189);
                    if (i2 == 0 && i3 == 0) {
                        if (qVar instanceof ad) {
                            if (((WalletBaseUI) this.activity).getInput() != null && ((WalletBaseUI) this.activity).getInput().getInt("key_bind_scene", -1) == 5 && !a.eAj()) {
                                c.l(this.activity);
                                AppMethodBeat.o(66189);
                                return true;
                            }
                        } else if (qVar instanceof k) {
                            Bundle input = ((WalletBaseUI) this.activity).getInput();
                            input.putBoolean("intent_bind_end", true);
                            com.tencent.mm.wallet_core.a.l(this.activity, input);
                            a.aA(this.activity);
                            AppMethodBeat.o(66189);
                            return true;
                        }
                    }
                    AppMethodBeat.o(66189);
                    return false;
                }
            };
            AppMethodBeat.o(66193);
            return r02;
        } else {
            com.tencent.mm.wallet_core.d.g a2 = super.a(mMActivity, iVar);
            AppMethodBeat.o(66193);
            return a2;
        }
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.plugin.wallet_core.b.b, com.tencent.mm.wallet_core.d
    public final boolean c(Activity activity, Bundle bundle) {
        AppMethodBeat.i(66194);
        boolean c2 = super.c(activity, bundle);
        AppMethodBeat.o(66194);
        return c2;
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.b, com.tencent.mm.wallet_core.d
    public final String dKC() {
        return "OfflineBindCardProcess";
    }

    static /* synthetic */ void l(MMActivity mMActivity) {
        AppMethodBeat.i(66195);
        String string = ((WalletBaseUI) mMActivity).getInput().getString("key_pwd1");
        int i2 = ((WalletBaseUI) mMActivity).getInput().getInt("offline_add_fee", 0);
        Bankcard eAn = a.eAn();
        if (eAn != null) {
            ((WalletBaseUI) mMActivity).doSceneForceProgress(new k(eAn, string, i2));
        }
        AppMethodBeat.o(66195);
    }
}
