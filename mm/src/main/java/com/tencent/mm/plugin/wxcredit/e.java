package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.c.v;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.plugin.wxcredit.a.a;
import com.tencent.mm.plugin.wxcredit.a.b;
import com.tencent.mm.plugin.wxcredit.a.h;
import com.tencent.mm.plugin.wxcredit.ui.WalletBindDepositUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletCheckIdentityUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenResultUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class e extends d {
    static /* synthetic */ boolean an(e eVar) {
        AppMethodBeat.i(72288);
        boolean hgM = eVar.hgM();
        AppMethodBeat.o(72288);
        return hgM;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final d a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(72283);
        if (t.fQI().fRp()) {
            Log.e("MicroMsg.OpenWXCreditProcess", "unknow wallet reg status!");
        } else if (t.fQI().fRk()) {
            b(activity, WalletCheckPwdUI.class, bundle);
        } else {
            b(activity, WalletWXCreditOpenUI.class, bundle);
        }
        AppMethodBeat.o(72283);
        return this;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void a(Activity activity, int i2, Bundle bundle) {
        AppMethodBeat.i(72284);
        if (activity instanceof WalletWXCreditOpenUI) {
            b(activity, WalletCheckIdentityUI.class, bundle);
            AppMethodBeat.o(72284);
        } else if (activity instanceof WalletCheckPwdUI) {
            P(activity);
            b(activity, WalletWXCreditOpenUI.class, bundle);
            AppMethodBeat.o(72284);
        } else if (activity instanceof WalletWXCreditOpenUI) {
            b(activity, WalletCheckIdentityUI.class, bundle);
            AppMethodBeat.o(72284);
        } else if (activity instanceof WalletCheckIdentityUI) {
            if (bundle.getBoolean("key_need_bind_deposit", true)) {
                b(activity, WalletBindDepositUI.class, bundle);
                AppMethodBeat.o(72284);
                return;
            }
            b(activity, WalletVerifyCodeUI.class, bundle);
            AppMethodBeat.o(72284);
        } else if (activity instanceof WalletBindDepositUI) {
            b(activity, WalletVerifyCodeUI.class, bundle);
            AppMethodBeat.o(72284);
        } else if (activity instanceof WalletVerifyCodeUI) {
            if (t.fQI().fRk()) {
                b(activity, WalletWXCreditOpenResultUI.class, bundle);
                AppMethodBeat.o(72284);
                return;
            }
            b(activity, WalletSetPasswordUI.class, bundle);
            AppMethodBeat.o(72284);
        } else if (activity instanceof WalletSetPasswordUI) {
            b(activity, WalletPwdConfirmUI.class, bundle);
            AppMethodBeat.o(72284);
        } else if (activity instanceof WalletPwdConfirmUI) {
            b(activity, WalletWXCreditOpenResultUI.class, bundle);
            AppMethodBeat.o(72284);
        } else {
            if (activity instanceof WalletWXCreditOpenResultUI) {
                b(activity, bundle);
            }
            AppMethodBeat.o(72284);
        }
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void g(Activity activity, int i2) {
        AppMethodBeat.i(72285);
        P(activity);
        AppMethodBeat.o(72285);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(72286);
        e(activity, "wallet", ".bind.ui.WalletBankcardManageUI");
        AppMethodBeat.o(72286);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(72287);
        if (mMActivity instanceof WalletCheckPwdUI) {
            AnonymousClass1 r0 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wxcredit.e.AnonymousClass1 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(72267);
                    if (i2 == 0 && i3 == 0) {
                        if (qVar instanceof b) {
                            b bVar = (b) qVar;
                            e.this.dQL.putString("KEY_SESSION_KEY", bVar.token);
                            e.this.dQL.putString("key_pre_name", bVar.name);
                            e.this.dQL.putString("key_pre_indentity", bVar.hXp);
                            e.this.dQL.putBoolean("key_has_indentity_info", bVar.JPF);
                        }
                        e.this.a(this.activity, 0, e.this.dQL);
                        AppMethodBeat.o(72267);
                        return true;
                    }
                    AppMethodBeat.o(72267);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    int i2 = 0;
                    AppMethodBeat.i(72268);
                    e.this.dQL.putString("key_pwd1", (String) objArr[0]);
                    i iVar = this.Ruz;
                    String str = (String) objArr[0];
                    if (objArr[1] != null) {
                        i2 = Util.safeParseInt((String) objArr[1]);
                    }
                    iVar.a(new b(str, i2, e.this.dQL.getString("key_bank_type")), true, 1);
                    AppMethodBeat.o(72268);
                    return true;
                }
            };
            AppMethodBeat.o(72287);
            return r0;
        } else if (mMActivity instanceof WalletCheckIdentityUI) {
            AnonymousClass2 r02 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wxcredit.e.AnonymousClass2 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(72269);
                    if (i2 == 0 && i3 == 0) {
                        if (qVar instanceof a) {
                            a aVar = (a) qVar;
                            e.this.dQL.putString("KEY_SESSION_KEY", aVar.token);
                            e.this.dQL.putString("key_mobile", aVar.dSf);
                            e.this.dQL.putBoolean("key_need_bind_deposit", aVar.efW);
                            e.this.dQL.putBoolean("key_is_bank_user", aVar.JPE);
                        }
                        e.this.a(this.activity, 0, e.this.dQL);
                        AppMethodBeat.o(72269);
                        return true;
                    }
                    AppMethodBeat.o(72269);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(72270);
                    String str = (String) objArr[0];
                    String str2 = (String) objArr[1];
                    e.this.dQL.putString("key_name", str);
                    e.this.dQL.putString("key_indentity", str2);
                    this.Ruz.a(new a(str, str2, e.this.dQL.getString("KEY_SESSION_KEY"), e.this.dQL.getString("key_bank_type")), true, 1);
                    AppMethodBeat.o(72270);
                    return true;
                }
            };
            AppMethodBeat.o(72287);
            return r02;
        } else if (mMActivity instanceof WalletVerifyCodeUI) {
            AnonymousClass3 r03 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wxcredit.e.AnonymousClass3 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(72271);
                    if (i2 != 0 || i3 != 0) {
                        AppMethodBeat.o(72271);
                        return false;
                    } else if (qVar instanceof com.tencent.mm.plugin.wxcredit.a.g) {
                        String str2 = ((com.tencent.mm.plugin.wxcredit.a.g) qVar).dVu;
                        if (!Util.isNullOrNil(str2)) {
                            e.this.dQL.putString("key_bank_username", str2);
                        }
                        e.this.a(this.activity, 0, e.this.dQL);
                        AppMethodBeat.o(72271);
                        return true;
                    } else if (qVar instanceof h) {
                        e.this.a(this.activity, 0, e.this.dQL);
                        AppMethodBeat.o(72271);
                        return true;
                    } else if (qVar instanceof v) {
                        if (t.fQI().fRk()) {
                            this.Ruz.a(new ad(), true, 1);
                            AppMethodBeat.o(72271);
                            return true;
                        }
                        e.this.a(this.activity, 0, e.this.dQL);
                        AppMethodBeat.o(72271);
                        return true;
                    } else if (qVar instanceof ad) {
                        this.Ruz.a(new com.tencent.mm.plugin.wxcredit.a.g(e.this.dQL.getString("key_verify_code"), e.this.dQL.getString("KEY_SESSION_KEY"), e.this.dQL.getString("key_pwd1"), t.fQI().fRQ(), e.this.dQL.getString("key_bank_type")), true, 1);
                        AppMethodBeat.o(72271);
                        return true;
                    } else {
                        AppMethodBeat.o(72271);
                        return false;
                    }
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(72272);
                    String str = (String) objArr[0];
                    e.this.dQL.putString("key_verify_code", str);
                    if (t.fQI().fRk()) {
                        if (!e.this.dQL.getBoolean("key_need_bind_deposit", true) || e.this.dQL.getBoolean("key_is_bank_user")) {
                            this.Ruz.a(new com.tencent.mm.plugin.wxcredit.a.g(str, e.this.dQL.getString("KEY_SESSION_KEY"), e.this.dQL.getString("key_pwd1"), e.this.dQL.getString("key_bind_serial"), e.this.dQL.getString("key_bank_type")), true, 1);
                        } else {
                            com.tencent.mm.plugin.wallet_core.model.v vVar = (com.tencent.mm.plugin.wallet_core.model.v) objArr[1];
                            vVar.flag = "2";
                            this.Ruz.a(new v(vVar), true, 1);
                        }
                    } else if (e.this.dQL.getBoolean("key_is_bank_user", false)) {
                        e.this.dQL.putString("key_verify_code", str);
                        this.Ruz.a(new h(str, e.this.dQL.getString("KEY_SESSION_KEY"), e.this.dQL.getString("key_pwd1"), e.this.dQL.getString("key_bind_serial"), e.this.dQL.getString("key_bank_type")), true, 1);
                    } else {
                        com.tencent.mm.plugin.wallet_core.model.v vVar2 = (com.tencent.mm.plugin.wallet_core.model.v) objArr[1];
                        vVar2.flag = "1";
                        this.Ruz.a(new v(vVar2), true, 1);
                    }
                    AppMethodBeat.o(72272);
                    return true;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final /* synthetic */ CharSequence getTips(int i2) {
                    AppMethodBeat.i(72273);
                    if (e.this.dQL.getBoolean("key_is_bank_user", false)) {
                        Bankcard bankcard = (Bankcard) e.this.dQL.getParcelable("key_bankcard");
                        String string = this.activity.getString(R.string.iu1, new Object[]{bankcard.field_bankName, bankcard.field_bankName, e.this.dQL.getString("key_mobile")});
                        AppMethodBeat.o(72273);
                        return string;
                    }
                    String string2 = this.activity.getString(R.string.iu2, new Object[]{e.this.dQL.getString("key_mobile")});
                    AppMethodBeat.o(72273);
                    return string2;
                }
            };
            AppMethodBeat.o(72287);
            return r03;
        } else if (mMActivity instanceof WalletBindDepositUI) {
            AnonymousClass4 r04 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wxcredit.e.AnonymousClass4 */
                Authen HFI;

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(72276);
                    if (i2 == 0 && i3 == 0 && (qVar instanceof com.tencent.mm.plugin.wallet_core.b.a.a)) {
                        com.tencent.mm.plugin.wallet_core.b.a.a aVar = (com.tencent.mm.plugin.wallet_core.b.a.a) qVar;
                        if (aVar.HPz == null) {
                            Log.d("MicroMsg.OpenWXCreditProcess", "reqKey  " + aVar.mReqKey);
                            e.this.dQL.putString("kreq_token", aVar.getToken());
                            e.this.a(this.activity, 0, e.this.dQL);
                        } else {
                            Log.i("MicroMsg.OpenWXCreditProcess", "NetSceneTenpayBindBankcard show juveniles dialog");
                            com.tencent.mm.ui.base.h.c(this.activity, aVar.HPz.dQx, "", aVar.HPz.IaV, aVar.HPz.IaU, new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.wxcredit.e.AnonymousClass4.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(72274);
                                    Log.i("MicroMsg.OpenWXCreditProcess", "NetSceneTenpayBindBankcard dialog lOk");
                                    AnonymousClass4.this.Ruz.a(new com.tencent.mm.plugin.wallet_core.b.a.a(AnonymousClass4.this.HFI, "1", ""), true, 1);
                                    u.xV(1);
                                    AppMethodBeat.o(72274);
                                }
                            }, new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.wxcredit.e.AnonymousClass4.AnonymousClass2 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(72275);
                                    Log.i("MicroMsg.OpenWXCreditProcess", "NetSceneTenpayBindBankcard dialog lCancel");
                                    u.xV(0);
                                    AppMethodBeat.o(72275);
                                }
                            });
                        }
                        AppMethodBeat.o(72276);
                        return true;
                    }
                    AppMethodBeat.o(72276);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(72277);
                    f.fUi();
                    this.HFI = new Authen();
                    this.HFI.HUR = (String) objArr[0];
                    this.HFI.dDj = (String) objArr[1];
                    this.HFI.HQc = (String) objArr[2];
                    e.this.dQL.putString("key_bank_phone", (String) objArr[3]);
                    this.HFI.cSx = t.fQI().fRk() ? 2 : 1;
                    this.HFI.HUQ = 1;
                    this.HFI.BDB = (PayInfo) e.this.dQL.getParcelable("key_pay_info");
                    this.HFI.HUO = e.this.dQL.getString("key_pwd1");
                    if (!e.this.dQL.getBoolean("key_has_indentity_info", false)) {
                        this.HFI.HTZ = e.this.dQL.getString("key_name");
                        this.HFI.HUP = e.this.dQL.getString("key_indentity");
                    }
                    e.this.dQL.putString("key_mobile", com.tencent.mm.wallet_core.ui.f.bpt(this.HFI.HQc));
                    e.this.dQL.putBoolean("key_is_oversea", false);
                    this.Ruz.a(new com.tencent.mm.plugin.wallet_core.b.a.a(this.HFI, "", ""), true, 1);
                    AppMethodBeat.o(72277);
                    return true;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean B(Object... objArr) {
                    AppMethodBeat.i(72278);
                    this.Ruz.a(new y("", (String) objArr[0], (PayInfo) e.this.dQL.getParcelable("key_pay_info")), true, 1);
                    AppMethodBeat.o(72278);
                    return true;
                }
            };
            AppMethodBeat.o(72287);
            return r04;
        } else if (mMActivity instanceof WalletPwdConfirmUI) {
            AnonymousClass5 r05 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wxcredit.e.AnonymousClass5 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(72279);
                    if (i2 == 0 && i3 == 0) {
                        if (qVar instanceof com.tencent.mm.plugin.wallet_core.b.a.b) {
                            this.Ruz.a(new ad(), true, 1);
                            AppMethodBeat.o(72279);
                            return true;
                        } else if (qVar instanceof ad) {
                            this.Ruz.a(new com.tencent.mm.plugin.wxcredit.a.g(e.this.dQL.getString("key_verify_code"), e.this.dQL.getString("KEY_SESSION_KEY"), e.this.dQL.getString("key_pwd1"), t.fQI().fRQ(), e.this.dQL.getString("key_bank_type")), true, 1);
                            AppMethodBeat.o(72279);
                            return true;
                        } else if (qVar instanceof com.tencent.mm.plugin.wxcredit.a.g) {
                            String str2 = ((com.tencent.mm.plugin.wxcredit.a.g) qVar).dVu;
                            if (!Util.isNullOrNil(str2)) {
                                e.this.dQL.putString("key_bank_username", str2);
                            }
                            e.this.a(this.activity, 0, e.this.dQL);
                            AppMethodBeat.o(72279);
                            return true;
                        }
                    }
                    AppMethodBeat.o(72279);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(72280);
                    if (!e.this.dQL.getBoolean("key_is_bank_user", false)) {
                        this.Ruz.a(new com.tencent.mm.plugin.wallet_core.b.a.b((com.tencent.mm.plugin.wallet_core.model.v) objArr[0]), true, 1);
                    } else {
                        this.Ruz.a(new com.tencent.mm.plugin.wxcredit.a.g(e.this.dQL.getString("key_verify_code"), e.this.dQL.getString("KEY_SESSION_KEY"), e.this.dQL.getString("key_pwd1"), t.fQI().fRQ(), e.this.dQL.getString("key_bank_type")), true, 1);
                    }
                    AppMethodBeat.o(72280);
                    return true;
                }
            };
            AppMethodBeat.o(72287);
            return r05;
        } else if (mMActivity instanceof WalletWXCreditOpenResultUI) {
            AnonymousClass6 r06 = new g(mMActivity, iVar) {
                /* class com.tencent.mm.plugin.wxcredit.e.AnonymousClass6 */

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(72281);
                    if (i2 == 0 && i3 == 0) {
                        e.this.a(this.activity, 0, e.this.dQL);
                        AppMethodBeat.o(72281);
                        return true;
                    }
                    AppMethodBeat.o(72281);
                    return false;
                }

                @Override // com.tencent.mm.wallet_core.d.g
                public final boolean r(Object... objArr) {
                    AppMethodBeat.i(72282);
                    e.this.dQL.putBoolean("key_is_follow_bank_username", ((Boolean) objArr[0]).booleanValue());
                    e.an(e.this);
                    this.Ruz.a(new ad(), true, 1);
                    AppMethodBeat.o(72282);
                    return true;
                }
            };
            AppMethodBeat.o(72287);
            return r06;
        } else {
            AppMethodBeat.o(72287);
            return null;
        }
    }

    @Override // com.tencent.mm.wallet_core.d
    public final String dKC() {
        return "WXCreditOpenProcess";
    }
}
