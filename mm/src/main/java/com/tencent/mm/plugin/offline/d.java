package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.oe;
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
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class d extends b {
    @Override // com.tencent.mm.plugin.wallet_core.b.b, com.tencent.mm.wallet_core.d
    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(66200);
        EventCenter.instance.publish(new oe());
        c(activity, WalletOfflineEntranceUI.class);
        if (activity != null) {
            activity.finish();
        }
        AppMethodBeat.o(66200);
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.wallet_core.d
    public final void g(Activity activity, int i2) {
        AppMethodBeat.i(66201);
        super.g(activity, i2);
        AppMethodBeat.o(66201);
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.b, com.tencent.mm.wallet_core.d
    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(66202);
        if (mMActivity instanceof WalletVerifyCodeUI) {
            AnonymousClass1 r0 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.offline.d.AnonymousClass1 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(66196);
                    v vVar = (v) objArr[1];
                    vVar.flag = "1";
                    this.Ruz.a(new com.tencent.mm.plugin.wallet_core.c.v(vVar), true, 1);
                    AppMethodBeat.o(66196);
                    return true;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(66197);
                    if (i2 == 0 && i3 == 0) {
                        if (qVar instanceof ad) {
                            if (((WalletBaseUI) this.activity).getInput() != null && ((WalletBaseUI) this.activity).getInput().getInt("key_bind_scene", -1) == 5 && !a.eAj()) {
                                d.m(this.activity);
                                AppMethodBeat.o(66197);
                                return true;
                            }
                        } else if (qVar instanceof k) {
                            com.tencent.mm.wallet_core.a.l(this.activity, ((WalletBaseUI) this.activity).getInput());
                            a.aA(this.activity);
                            AppMethodBeat.o(66197);
                            return true;
                        }
                    }
                    AppMethodBeat.o(66197);
                    return false;
                }
            };
            AppMethodBeat.o(66202);
            return r0;
        } else if (mMActivity instanceof WalletPwdConfirmUI) {
            AnonymousClass2 r02 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.offline.d.AnonymousClass2 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(66198);
                    this.Ruz.a(new com.tencent.mm.plugin.wallet_core.b.a.b((v) objArr[0]), true, 1);
                    AppMethodBeat.o(66198);
                    return true;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(66199);
                    if (i2 == 0 && i3 == 0) {
                        if (qVar instanceof ad) {
                            if (((WalletBaseUI) this.activity).getInput() != null && ((WalletBaseUI) this.activity).getInput().getInt("key_bind_scene", -1) == 5 && !a.eAj()) {
                                d.m(this.activity);
                            }
                            AppMethodBeat.o(66199);
                            return true;
                        } else if (qVar instanceof k) {
                            Bundle input = ((WalletBaseUI) this.activity).getInput();
                            input.putBoolean("intent_bind_end", true);
                            com.tencent.mm.wallet_core.a.l(this.activity, input);
                            a.aA(this.activity);
                            AppMethodBeat.o(66199);
                            return true;
                        }
                    }
                    AppMethodBeat.o(66199);
                    return false;
                }
            };
            AppMethodBeat.o(66202);
            return r02;
        } else {
            g a2 = super.a(mMActivity, iVar);
            AppMethodBeat.o(66202);
            return a2;
        }
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.a, com.tencent.mm.plugin.wallet_core.b.b, com.tencent.mm.wallet_core.d
    public final boolean c(Activity activity, Bundle bundle) {
        AppMethodBeat.i(66203);
        boolean c2 = super.c(activity, bundle);
        AppMethodBeat.o(66203);
        return c2;
    }

    @Override // com.tencent.mm.plugin.wallet_core.b.b, com.tencent.mm.wallet_core.d
    public final String dKC() {
        return "OfflineBindCardRegProcess";
    }

    static /* synthetic */ void m(MMActivity mMActivity) {
        AppMethodBeat.i(66204);
        String string = ((WalletBaseUI) mMActivity).getInput().getString("key_pwd1");
        int i2 = ((WalletBaseUI) mMActivity).getInput().getInt("offline_add_fee", 0);
        Bankcard eAn = a.eAn();
        if (eAn != null) {
            ((WalletBaseUI) mMActivity).doSceneForceProgress(new k(eAn, string, i2));
        }
        AppMethodBeat.o(66204);
    }
}
