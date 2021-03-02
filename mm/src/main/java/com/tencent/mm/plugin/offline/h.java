package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.zv;
import com.tencent.mm.plugin.offline.a.k;
import com.tencent.mm.plugin.offline.a.n;
import com.tencent.mm.plugin.offline.a.p;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class h extends d {
    @Override // com.tencent.mm.wallet_core.d
    public final d a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(66233);
        b(activity, WalletCheckPwdUI.class, bundle);
        AppMethodBeat.o(66233);
        return this;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void a(Activity activity, int i2, Bundle bundle) {
        AppMethodBeat.i(66234);
        if (activity instanceof WalletCheckPwdUI) {
            P(activity);
        }
        AppMethodBeat.o(66234);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void g(Activity activity, int i2) {
        AppMethodBeat.i(66235);
        if (activity != null) {
            activity.finish();
        }
        AppMethodBeat.o(66235);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(66236);
        P(activity);
        if (bundle != null && bundle.getBoolean("is_offline_create")) {
            a.aA((WalletBaseUI) activity);
        }
        AppMethodBeat.o(66236);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void P(Activity activity) {
        int i2 = 2;
        AppMethodBeat.i(66237);
        if (activity != null) {
            int i3 = this.dQL.getInt("offline_from_scene", -1);
            if (i3 != 1) {
                if (i3 == 2) {
                    i2 = 1;
                } else if (i3 == 3) {
                    i2 = 3;
                } else if (i3 == 4) {
                    i2 = 6;
                } else if (i3 == 8) {
                    i2 = 4;
                } else {
                    i2 = 1;
                }
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14096, Integer.valueOf(i2));
            Intent intent = new Intent(activity, WalletOfflineEntranceUI.class);
            intent.putExtra("key_from_scene", i3);
            intent.putExtra("is_offline_create", true);
            a(activity, WalletOfflineEntranceUI.class, intent);
            activity.finish();
        }
        AppMethodBeat.o(66237);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(66238);
        if (mMActivity instanceof WalletCheckPwdUI) {
            AnonymousClass1 r0 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.offline.h.AnonymousClass1 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(66229);
                    if (i2 == 0 && i3 == 0) {
                        if (qVar instanceof k) {
                            Log.i("MicroMsg.OfflineProcess", "Offline is Create ");
                            ezl();
                            h.this.dQL.putBoolean("is_offline_create", true);
                        } else if (qVar instanceof n) {
                            Log.i("MicroMsg.OfflineProcess", "OfflineQueryUser is ok ");
                            i iVar = this.Ruz;
                            if (iVar.tipDialog == null || (iVar.tipDialog != null && !iVar.tipDialog.isShowing())) {
                                if (iVar.tipDialog != null) {
                                    iVar.tipDialog.dismiss();
                                }
                                if (iVar.mContext == null) {
                                    Log.w("MicroMsg.WalletNetSceneMgr", "activity has destroyed!!!");
                                } else {
                                    iVar.tipDialog = com.tencent.mm.wallet_core.ui.h.a(iVar.mContext, false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                        /* class com.tencent.mm.wallet_core.d.i.AnonymousClass8 */

                                        public final void onCancel(DialogInterface dialogInterface) {
                                            AppMethodBeat.i(72862);
                                            i.this.forceCancel();
                                            AppMethodBeat.o(72862);
                                        }
                                    });
                                }
                            }
                            zv zvVar = new zv();
                            zvVar.efR.scene = 8;
                            zvVar.efS.efJ = new Runnable() {
                                /* class com.tencent.mm.plugin.offline.h.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(66226);
                                    Log.d("MicroMsg.OfflineProcess", "tofutest do callback");
                                    h.this.a(AnonymousClass1.this.activity, 0, h.this.dQL);
                                    AnonymousClass1.this.Ruz.closeTipDialog();
                                    AppMethodBeat.o(66226);
                                }
                            };
                            EventCenter.instance.publish(zvVar);
                        } else if (qVar instanceof com.tencent.mm.plugin.offline.a.i) {
                            com.tencent.mm.plugin.offline.a.i iVar2 = (com.tencent.mm.plugin.offline.a.i) qVar;
                            if ("1".equals(iVar2.AJx)) {
                                MMActivity mMActivity = this.activity;
                                String str2 = iVar2.dSf;
                                Bundle bundle = new Bundle();
                                bundle.putParcelable("key_authen", new Authen());
                                bundle.putString("key_pwd1", h.this.dQL.getString("key_pwd1"));
                                bundle.putString("key_mobile", str2);
                                bundle.putInt("verify_scene", 1);
                                bundle.putInt("offline_add_fee", h.this.dQL.getInt("offline_chg_fee", 0));
                                com.tencent.mm.wallet_core.a.a(mMActivity, l.class, bundle);
                                h.this.a(mMActivity, 0, h.this.dQL);
                            } else {
                                h.this.dQL.putBoolean("back_to_coin_purse_ui", true);
                                ezl();
                            }
                        } else if (qVar instanceof p) {
                            a.aJj("");
                            k.ezn();
                            k.ezo().AKa = null;
                            h.this.a(this.activity, 0, h.this.dQL);
                        }
                        AppMethodBeat.o(66229);
                        return true;
                    }
                    if (qVar instanceof k) {
                        Log.i("MicroMsg.OfflineProcess", "Offline Create is failed!");
                        k kVar = (k) qVar;
                        if (i3 == 410) {
                            final MMActivity mMActivity2 = this.activity;
                            final int i4 = kVar.AJL;
                            com.tencent.mm.ui.base.h.c(mMActivity2, str, "", mMActivity2.getString(R.string.imy), mMActivity2.getString(R.string.sz), new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.offline.h.AnonymousClass1.AnonymousClass2 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(66227);
                                    f.aE(mMActivity2, i4);
                                    h.this.a(mMActivity2, 0, h.this.dQL);
                                    AppMethodBeat.o(66227);
                                }
                            }, new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.offline.h.AnonymousClass1.AnonymousClass3 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(66228);
                                    h.this.a(mMActivity2, 0, h.this.dQL);
                                    AppMethodBeat.o(66228);
                                }
                            });
                            AppMethodBeat.o(66229);
                            return true;
                        }
                    }
                    AppMethodBeat.o(66229);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(66230);
                    String str = (String) objArr[0];
                    h.this.dQL.putString("key_pwd1", str);
                    Bankcard eAn = a.eAn();
                    if (eAn == null) {
                        Log.e("MicroMsg.OfflineProcess", "no support bank car for offline");
                        eAn = a.eAo();
                    }
                    if (eAn == null) {
                        Log.e("MicroMsg.OfflineProcess", "no any bank car for offline");
                        AppMethodBeat.o(66230);
                        return false;
                    }
                    String string = h.this.dQL.getString("oper");
                    if (!a.eAj()) {
                        Log.i("MicroMsg.OfflineProcess", "Offline is not Create ");
                        this.Ruz.a(new k(eAn, (String) objArr[0], h.this.dQL.getInt("offline_chg_fee", 0)), true, 1);
                    } else if (string != null) {
                        Log.i("MicroMsg.OfflineProcess", "oper == ".concat(String.valueOf(string)));
                        if (string.equals("create")) {
                            this.Ruz.a(new k(eAn, (String) objArr[0], h.this.dQL.getInt("offline_chg_fee", 0)), true, 1);
                        } else if (string.equals("clr")) {
                            this.Ruz.a(new com.tencent.mm.plugin.offline.a.i(eAn, str, "clr", 0, ""), true, 1);
                        } else if (string.equals("changeto")) {
                            this.Ruz.a(new com.tencent.mm.plugin.offline.a.i(eAn, str, "changeto", h.this.dQL.getInt("offline_chg_fee"), ""), true, 1);
                        } else if (string.equals("freeze")) {
                            this.Ruz.a(new p(str), true, 1);
                        } else {
                            AppMethodBeat.o(66230);
                            return false;
                        }
                    }
                    AppMethodBeat.o(66230);
                    return true;
                }

                private void ezl() {
                    AppMethodBeat.i(66231);
                    this.Ruz.a(new n(new StringBuilder().append(System.currentTimeMillis()).toString(), h.this.dQL.getInt("offline_from_scene", -1)), false, 1);
                    AppMethodBeat.o(66231);
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final /* synthetic */ CharSequence getTips(int i2) {
                    AppMethodBeat.i(66232);
                    switch (i2) {
                        case 0:
                            String string = this.activity.getString(R.string.ib3);
                            AppMethodBeat.o(66232);
                            return string;
                        case 1:
                            String string2 = this.activity.getString(R.string.ib2);
                            AppMethodBeat.o(66232);
                            return string2;
                        default:
                            AppMethodBeat.o(66232);
                            return "";
                    }
                }
            };
            AppMethodBeat.o(66238);
            return r0;
        }
        g a2 = super.a(mMActivity, iVar);
        AppMethodBeat.o(66238);
        return a2;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final String dKC() {
        return "OfflineProcess";
    }
}
