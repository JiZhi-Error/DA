package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet_core.c.h;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemGroupView;
import com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemView;
import com.tencent.mm.protocal.protobuf.aea;
import com.tencent.mm.protocal.protobuf.ix;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@a(19)
public class WalletSwitchVerifyPhoneUI extends WalletBaseUI {
    private SwitchPhoneItemGroupView Ikh;
    private List<ix> Iki;
    public boolean Ikj = false;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(71240);
        overridePendingTransition(R.anim.dq, R.anim.s);
        super.onCreate(bundle);
        setMMTitle(getString(R.string.it3));
        initView();
        this.Ikj = getInput().getBoolean("key_block_bind_new_card", false);
        if (!this.Ikj) {
            SwitchPhoneItemView switchPhoneItemView = new SwitchPhoneItemView(getContext());
            switchPhoneItemView.setTag(-1);
            switchPhoneItemView.a(getString(R.string.isz), null);
            this.Ikh.a(switchPhoneItemView, -1);
        }
        if (getProcess() != null && getProcess().dKC().equals("PayProcess") && getInput().getInt("key_can_verify_tail", 0) == 1) {
            Log.i("MicroMsg.WalletSwitchVerifyPhoneUI", "show verify id card item");
            String string = getString(R.string.idh);
            SwitchPhoneItemView switchPhoneItemView2 = new SwitchPhoneItemView(getContext(), (int) R.layout.ca6);
            switchPhoneItemView2.setTag(-2);
            switchPhoneItemView2.a(string, null);
            this.Ikh.a(switchPhoneItemView2, -1);
        }
        addSceneEndListener(1667);
        addSceneEndListener(461);
        addSceneEndListener(1505);
        doSceneProgress(new h(getPayReqKey()));
        AppMethodBeat.o(71240);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(71241);
        this.Ikh = (SwitchPhoneItemGroupView) findViewById(R.id.gah);
        this.Ikh.setOnItemSelectListener(new SwitchPhoneItemGroupView.a() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletSwitchVerifyPhoneUI.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemGroupView.a
            public final void gb(View view) {
                AppMethodBeat.i(71237);
                if (view.getTag() != null) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    Log.d("MicroMsg.WalletSwitchVerifyPhoneUI", "index: %d", Integer.valueOf(intValue));
                    if (intValue == -1) {
                        Log.i("MicroMsg.WalletSwitchVerifyPhoneUI", "do bind new card");
                        WalletSwitchVerifyPhoneUI.a(WalletSwitchVerifyPhoneUI.this);
                        AppMethodBeat.o(71237);
                        return;
                    } else if (intValue == -2) {
                        Log.i("MicroMsg.WalletSwitchVerifyPhoneUI", "do verify idcard tail");
                        WalletSwitchVerifyPhoneUI.this.getInput().putBoolean("key_forward_to_id_verify", true);
                        com.tencent.mm.wallet_core.a.l(WalletSwitchVerifyPhoneUI.this, WalletSwitchVerifyPhoneUI.this.getInput());
                        AppMethodBeat.o(71237);
                        return;
                    } else {
                        ix ixVar = (ix) WalletSwitchVerifyPhoneUI.this.Iki.get(intValue);
                        WalletSwitchVerifyPhoneUI.this.getInput().putBoolean("key_balance_change_phone_need_confirm_phone", false);
                        WalletSwitchVerifyPhoneUI.this.getInput().putBoolean("key_forward_to_id_verify", false);
                        Log.i("MicroMsg.WalletSwitchVerifyPhoneUI", "select wx phone: %s", Boolean.valueOf(ixVar.KNr.equals("wx")));
                        WalletSwitchVerifyPhoneUI.this.getNetController().r(ixVar);
                    }
                }
                AppMethodBeat.o(71237);
            }
        });
        AppMethodBeat.o(71241);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(71242);
        super.onDestroy();
        removeSceneEndListener(1667);
        removeSceneEndListener(461);
        removeSceneEndListener(1505);
        AppMethodBeat.o(71242);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        String string;
        SpannableString spannableString;
        AppMethodBeat.i(71243);
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof h) {
                h hVar = (h) qVar;
                this.Iki = ((h) qVar).HPF.LSL;
                if (this.Iki != null) {
                    Collections.sort(this.Iki, new Comparator<ix>() {
                        /* class com.tencent.mm.plugin.wallet_core.ui.WalletSwitchVerifyPhoneUI.AnonymousClass2 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                        @Override // java.util.Comparator
                        public final /* synthetic */ int compare(ix ixVar, ix ixVar2) {
                            AppMethodBeat.i(71238);
                            ix ixVar3 = ixVar;
                            ix ixVar4 = ixVar2;
                            if (ixVar3 == null || ixVar4 == null) {
                                AppMethodBeat.o(71238);
                                return 0;
                            } else if ("wx".equals(ixVar3.KNr) && "cft".equals(ixVar4.KNr)) {
                                AppMethodBeat.o(71238);
                                return -1;
                            } else if (!"cft".equals(ixVar3.KNr) || !"wx".equals(ixVar4.KNr)) {
                                AppMethodBeat.o(71238);
                                return 0;
                            } else {
                                AppMethodBeat.o(71238);
                                return 1;
                            }
                        }
                    });
                }
                if (hVar.HPF.LSM != null) {
                    aea aea = hVar.HPF.LSM;
                    getInput().putString("key_true_name", aea.HTZ);
                    getInput().putString("key_cre_name", aea.HUd);
                    getInput().putString("key_cre_type", aea.IaZ);
                }
                if (this.Iki == null || this.Iki.isEmpty()) {
                    Log.i("MicroMsg.WalletSwitchVerifyPhoneUI", "empty mobile info");
                } else {
                    for (int size = this.Iki.size() - 1; size >= 0; size--) {
                        final ix ixVar = this.Iki.get(size);
                        if (Util.isNullOrNil(ixVar.KNr) || !ixVar.KNr.equals("cft")) {
                            SwitchPhoneItemView switchPhoneItemView = new SwitchPhoneItemView(getContext());
                            switchPhoneItemView.setTag(Integer.valueOf(size));
                            switchPhoneItemView.a(ixVar.HQc, getString(R.string.it6));
                            this.Ikh.a(switchPhoneItemView, 0);
                        } else {
                            SwitchPhoneItemView switchPhoneItemView2 = new SwitchPhoneItemView(getContext());
                            if (Util.isNullOrNil(ixVar.KNs) || !ixVar.KNs.equals("1")) {
                                string = getString(R.string.it1);
                            } else {
                                string = getString(R.string.it2);
                            }
                            String string2 = getString(R.string.it0, new Object[]{ixVar.ynT, string, ixVar.KNt});
                            if (this.Ikj) {
                                spannableString = new SpannableString(string2);
                            } else {
                                String string3 = getString(R.string.it5);
                                l lVar = new l(this);
                                String str2 = string2 + "，";
                                lVar.mColor = getResources().getColor(R.color.fx);
                                spannableString = new SpannableString(str2 + string3);
                                spannableString.setSpan(lVar, str2.length(), str2.length() + string3.length(), 33);
                                lVar.IgH = new l.a() {
                                    /* class com.tencent.mm.plugin.wallet_core.ui.WalletSwitchVerifyPhoneUI.AnonymousClass3 */

                                    @Override // com.tencent.mm.plugin.wallet_core.ui.l.a
                                    public final void onClick(View view) {
                                        AppMethodBeat.i(71239);
                                        Log.d("MicroMsg.WalletSwitchVerifyPhoneUI", "span click");
                                        WalletSwitchVerifyPhoneUI.a(WalletSwitchVerifyPhoneUI.this, ixVar);
                                        AppMethodBeat.o(71239);
                                    }
                                };
                            }
                            switchPhoneItemView2.setTag(Integer.valueOf(size));
                            switchPhoneItemView2.a(ixVar.HQc, spannableString);
                            this.Ikh.a(switchPhoneItemView2, 0);
                        }
                    }
                }
                AppMethodBeat.o(71243);
                return true;
            } else if (qVar instanceof y) {
                fOl();
            }
        }
        AppMethodBeat.o(71243);
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ca8;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean needConfirmFinish() {
        return true;
    }

    private void fOl() {
        AppMethodBeat.i(71244);
        Log.i("MicroMsg.WalletSwitchVerifyPhoneUI", "directToNext()");
        Authen authen = (Authen) getInput().getParcelable("key_authen");
        Bankcard bankcard = (Bankcard) getInput().getParcelable("key_bankcard");
        if (authen == null || bankcard == null) {
            Log.w("MicroMsg.WalletSwitchVerifyPhoneUI", "authen or bankcard is null");
            AppMethodBeat.o(71244);
            return;
        }
        ElementQuery aVi = t.fQQ().aVi(bankcard.field_bankcardType);
        getInput().putParcelable("elemt_query", aVi);
        authen.dDj = bankcard.field_bankcardType;
        authen.ANo = bankcard.field_bindSerial;
        bankcard.field_bankPhone = aVi.HXo;
        getInput().putBoolean("key_balance_change_phone_need_confirm_phone", true);
        getInput().putBoolean("key_is_changing_balance_phone_num", true);
        getInput().putInt("key_err_code", 418);
        com.tencent.mm.wallet_core.a.l(this, getInput());
        AppMethodBeat.o(71244);
    }

    static /* synthetic */ void a(WalletSwitchVerifyPhoneUI walletSwitchVerifyPhoneUI) {
        AppMethodBeat.i(71245);
        walletSwitchVerifyPhoneUI.getInput().putBoolean("key_is_changing_balance_phone_num", true);
        walletSwitchVerifyPhoneUI.getInput().putInt("key_pay_flag", 2);
        com.tencent.mm.wallet_core.a.l(walletSwitchVerifyPhoneUI, walletSwitchVerifyPhoneUI.getInput());
        AppMethodBeat.o(71245);
    }

    static /* synthetic */ void a(WalletSwitchVerifyPhoneUI walletSwitchVerifyPhoneUI, ix ixVar) {
        AppMethodBeat.i(71246);
        Bankcard bankcard = new Bankcard();
        bankcard.field_bindSerial = ixVar.ANo;
        bankcard.field_mobile = ixVar.HQc;
        bankcard.field_bankcardType = ixVar.dDj;
        bankcard.field_desc = ixVar.ynT;
        Log.d("MicroMsg.WalletSwitchVerifyPhoneUI", "serial: %s,mobile: %s, bankcardType: %s, desc: %s", bankcard.field_bindSerial, bankcard.field_mobile, bankcard.field_bankcardType, bankcard.field_bankName);
        walletSwitchVerifyPhoneUI.getInput().putParcelable("key_bankcard", bankcard);
        if (t.fQQ().aVi(bankcard.field_bankcardType) != null) {
            Log.i("MicroMsg.WalletSwitchVerifyPhoneUI", "go to reset directly");
            walletSwitchVerifyPhoneUI.fOl();
            AppMethodBeat.o(71246);
            return;
        }
        walletSwitchVerifyPhoneUI.doSceneProgress(new y("", "", null), true);
        AppMethodBeat.o(71246);
    }
}
