package com.tencent.mm.plugin.wxcredit.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.af.h;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wxcredit.a.i;
import com.tencent.mm.plugin.wxcredit.a.k;
import com.tencent.mm.plugin.wxcredit.c;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import java.util.ArrayList;

@a(3)
public class WalletWXCreditDetailUI extends WalletPreferenceUI {
    private Bankcard HDV;
    private d JQH;
    private k JQI;
    private boolean hasInit = false;
    private f screen;
    private View.OnClickListener zHh = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailUI.AnonymousClass3 */

        public final void onClick(View view) {
            AppMethodBeat.i(72366);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditDetailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view.getId() == R.id.jis) {
                if (WalletWXCreditDetailUI.this.JQI != null) {
                    com.tencent.mm.wallet_core.ui.f.an(WalletWXCreditDetailUI.this, WalletWXCreditDetailUI.this.JQI.JQa.username);
                }
            } else if (view.getId() == R.id.jiq && WalletWXCreditDetailUI.this.JQI != null) {
                com.tencent.mm.wallet_core.ui.f.p(WalletWXCreditDetailUI.this, WalletWXCreditDetailUI.this.JQI.JPZ, false);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditDetailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(72366);
        }
    };

    @Override // com.tencent.mm.wallet_core.ui.WalletPreferenceUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletWXCreditDetailUI() {
        AppMethodBeat.i(72369);
        AppMethodBeat.o(72369);
    }

    static /* synthetic */ void gle() {
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.dj;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletPreferenceUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(72370);
        super.onCreate(bundle);
        hhW().addSceneEndListener(h.CTRL_INDEX);
        hhW().addSceneEndListener(600);
        setContentViewVisibility(4);
        this.JQH = com.tencent.mm.wallet_core.a.by(this);
        if (this.HDV == null) {
            this.HDV = (Bankcard) this.JQH.dQL.getParcelable("key_bankcard");
        }
        if (gld()) {
            if (this.mNetController == null) {
                if (this.mProcess == null) {
                    this.mProcess = com.tencent.mm.wallet_core.a.by(this);
                }
                this.mNetController = this.mProcess.a(this, this.mNetSceneMgr);
            }
            if (!this.mNetController.A(this.HDV)) {
                setContentViewVisibility(0);
                initView();
            }
        }
        AppMethodBeat.o(72370);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean gld() {
        AppMethodBeat.i(72371);
        if (this.HDV == null) {
            AppMethodBeat.o(72371);
            return false;
        } else if (this.HDV.field_bankcardState == 0) {
            AppMethodBeat.o(72371);
            return true;
        } else {
            int i2 = this.HDV.field_wxcreditState;
            if (this.JQI != null) {
                i2 = this.JQI.JPM;
            }
            switch (i2) {
                case 1:
                    if (t.fQI().fRS()) {
                        AppMethodBeat.o(72371);
                        return true;
                    }
                    AppMethodBeat.o(72371);
                    return false;
                case 2:
                default:
                    AppMethodBeat.o(72371);
                    return true;
                case 3:
                    com.tencent.mm.ui.base.h.a((Context) this, (int) R.string.iw8, -1, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailUI.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(72364);
                            WalletWXCreditDetailUI.this.hhW().a(new i(WalletWXCreditDetailUI.this.HDV.field_bankcardType, WalletWXCreditDetailUI.this.HDV.HVy), true, 1);
                            AppMethodBeat.o(72364);
                        }
                    });
                    AppMethodBeat.o(72371);
                    return false;
                case 4:
                    break;
                case 5:
                    this.JQH.dQL.putBoolean("key_can_unbind", false);
                    break;
            }
            if (this.JQI != null) {
                this.JQH.dQL.putString("key_repayment_url", this.JQI.JPU);
                this.JQH.a(this, 1, this.JQH.dQL);
                AppMethodBeat.o(72371);
                return false;
            }
            AppMethodBeat.o(72371);
            return true;
        }
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletPreferenceUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(72372);
        hhW().removeSceneEndListener(h.CTRL_INDEX);
        hhW().removeSceneEndListener(600);
        super.onDestroy();
        AppMethodBeat.o(72372);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(72373);
        this.hasInit = true;
        setMMTitle(R.string.iw9);
        this.screen = getPreferenceScreen();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(72365);
                WalletWXCreditDetailUI.this.hideVKB();
                WalletWXCreditDetailUI.this.finish();
                AppMethodBeat.o(72365);
                return true;
            }
        });
        addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(72368);
                ArrayList arrayList = new ArrayList();
                t.fQI();
                Bankcard unused = WalletWXCreditDetailUI.this.HDV;
                com.tencent.mm.ui.base.h.b(WalletWXCreditDetailUI.this, null, (String[]) arrayList.toArray(new String[arrayList.size()]), WalletWXCreditDetailUI.this.getString(R.string.ie8), new h.d() {
                    /* class com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailUI.AnonymousClass4.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.h.d
                    public final void oj(int i2) {
                        AppMethodBeat.i(72367);
                        switch (i2) {
                            case 0:
                                t.fQI();
                                Bankcard unused = WalletWXCreditDetailUI.this.HDV;
                                WalletWXCreditDetailUI.gle();
                                AppMethodBeat.o(72367);
                                return;
                            case 1:
                                WalletWXCreditDetailUI.c(WalletWXCreditDetailUI.this);
                                break;
                        }
                        AppMethodBeat.o(72367);
                    }
                });
                AppMethodBeat.o(72368);
                return true;
            }
        });
        AppMethodBeat.o(72373);
    }

    private void updateView() {
        AppMethodBeat.i(72374);
        if (!this.hasInit) {
            initView();
        }
        if (this.JQI != null) {
            WalletWXCreditDetailHeaderPreference walletWXCreditDetailHeaderPreference = (WalletWXCreditDetailHeaderPreference) this.screen.bmg("wallet_wxcredit_header");
            walletWXCreditDetailHeaderPreference.jUP.setText(com.tencent.mm.wallet_core.ui.f.D(this.JQI.JPN));
            String str = this.HDV.field_bankName;
            walletWXCreditDetailHeaderPreference.JQG.setText(walletWXCreditDetailHeaderPreference.mContext.getString(R.string.iwz, this.JQI.JPY, str));
        }
        if (this.JQI != null) {
            this.screen.bmg("wallet_wxcredit_total_amount").setTitle(getString(R.string.iw_, new Object[]{com.tencent.mm.wallet_core.ui.f.D(this.JQI.JPH)}));
            this.screen.m38do("wallet_wxcredit_change_amount", !this.JQI.JPS);
            Preference bmg = this.screen.bmg("wallet_wxcredit_bill");
            if (this.JQI.JPO != 0.0d) {
                bmg.setSummary(com.tencent.mm.wallet_core.ui.f.D(this.JQI.JPO));
            }
            Preference bmg2 = this.screen.bmg("wallet_wxcredit_repayment");
            Preference bmg3 = this.screen.bmg("wallet_wxcredit_repayment_tips");
            if (this.JQI.JPQ > 0.0d) {
                bmg2.setSummary(com.tencent.mm.wallet_core.ui.f.D(this.JQI.JPQ));
                bmg3.setTitle(getString(R.string.iwx, new Object[]{this.JQI.JPV}));
                this.screen.m38do("wallet_wxcredit_repayment_tips", false);
            } else {
                this.screen.m38do("wallet_wxcredit_repayment_tips", true);
            }
        }
        if (this.HDV != null) {
            this.screen.bmg("wallet_wxcredit_bank_name").setTitle(this.HDV.field_bankName);
        }
        ((WalletWXCreditDetailFooterPreference) this.screen.bmg("wallet_wxcredit_footer")).zHh = this.zHh;
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(72374);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletPreferenceUI
    public final boolean e(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(72376);
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof com.tencent.mm.plugin.wxcredit.a.d) {
                t.fQI().IbU = System.currentTimeMillis() / 1000;
                this.JQI = ((com.tencent.mm.plugin.wxcredit.a.d) qVar).JPI;
                if (this.JQI != null && this.JQI.JPM == 2) {
                    g.aAi();
                    if (((Boolean) g.aAh().azQ().get(196658, Boolean.FALSE)).booleanValue()) {
                        d by = com.tencent.mm.wallet_core.a.by(this);
                        Bundle bundle = by.dQL;
                        bundle.putDouble("key_total_amount", this.JQI.JPH);
                        bundle.putBoolean("key_can_upgrade_amount", this.JQI.JPS);
                        by.a(this, WalletWXCreditOpenNotifyUI.class, bundle, 1);
                        AppMethodBeat.o(72376);
                        return true;
                    }
                }
                if (gld()) {
                    setContentViewVisibility(0);
                    updateView();
                }
                AppMethodBeat.o(72376);
                return true;
            } else if (qVar instanceof i) {
                hhW().a(new ad(), true, 1);
            } else if (qVar instanceof ad) {
                finish();
            }
        }
        AppMethodBeat.o(72376);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(72377);
        setContentViewVisibility(0);
        updateView();
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(72377);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(72375);
        String str = preference.mKey;
        if ("wallet_wxcredit_change_amount".equals(str)) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_bankcard", this.HDV);
            com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wxcredit.b.class, bundle);
            AppMethodBeat.o(72375);
            return true;
        }
        if ("wallet_wxcredit_bill".equals(str)) {
            if (this.JQI != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("key_url", this.JQI.Cpy);
                com.tencent.mm.wallet_core.a.a(this, c.class, bundle2);
            }
        } else if ("wallet_wxcredit_card_info".equals(str)) {
            if (this.JQI != null) {
                Bundle bundle3 = new Bundle();
                bundle3.putString("key_url", this.JQI.JPW);
                com.tencent.mm.wallet_core.a.a(this, c.class, bundle3);
            }
        } else if ("wallet_wxcredit_right".equals(str)) {
            if (this.JQI != null) {
                com.tencent.mm.wallet_core.ui.f.p(this, this.JQI.JPX, false);
            }
        } else if ("wallet_wxcredit_repayment".equals(str)) {
            if (this.JQI != null) {
                com.tencent.mm.wallet_core.ui.f.p(this, this.JQI.JPU, false);
            }
        } else if ("wallet_wxcredit_bank_name".equals(str) && this.JQI != null) {
            com.tencent.mm.wallet_core.ui.f.am(this, this.JQI.JQa.username);
        }
        AppMethodBeat.o(72375);
        return false;
    }

    static /* synthetic */ void c(WalletWXCreditDetailUI walletWXCreditDetailUI) {
        AppMethodBeat.i(72378);
        Bundle bundle = walletWXCreditDetailUI.JQH.dQL;
        bundle.putBoolean("offline_pay", false);
        bundle.putBoolean("key_is_show_detail", false);
        com.tencent.mm.wallet_core.a.a(walletWXCreditDetailUI, com.tencent.mm.plugin.wxcredit.f.class, bundle);
        AppMethodBeat.o(72378);
    }
}
