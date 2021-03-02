package com.tencent.mm.plugin.collect.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.collect.model.n;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.f;

public class CollectHKMainUI extends CollectMainUI {
    private boolean qAt = false;

    @Override // com.tencent.mm.wallet_core.ui.WalletPreferenceUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.collect.ui.CollectMainUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletPreferenceUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.collect.ui.CollectMainUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(64107);
        super.onCreate(bundle);
        this.qBs.setVisibility(8);
        findViewById(R.id.b6w).setVisibility(0);
        findViewById(R.id.b7m).setVisibility(8);
        hhW().addSceneEndListener(1335);
        addIconOptionMenu(0, R.drawable.crt, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.collect.ui.CollectHKMainUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(64104);
                f.p(CollectHKMainUI.this.getContext(), "https://hkwallet.moneydata.hk/hybrid/www/weixin/f2f/zh_hk/faq.shtml", true);
                AppMethodBeat.o(64104);
                return false;
            }
        });
        cAr();
        AppMethodBeat.o(64107);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletPreferenceUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.collect.ui.CollectMainUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(64108);
        super.onDestroy();
        hhW().removeSceneEndListener(1335);
        AppMethodBeat.o(64108);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.collect.ui.CollectMainUI
    public final void cAn() {
        AppMethodBeat.i(64109);
        g.aAi();
        this.qAT = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_HK_PAY_URL_STRING, "");
        n nVar = new n(z.aUf());
        if (!Util.isNullOrNil(this.qAT)) {
            hhW().a(nVar, false, 1);
            AppMethodBeat.o(64109);
            return;
        }
        Log.i("MicroMsg.CollectHKMainUI", "force load payurl");
        this.qAt = true;
        hhW().a(nVar, true, 1);
        AppMethodBeat.o(64109);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.collect.ui.CollectMainUI
    public final String getTrueName() {
        return this.mTrueName;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.collect.ui.CollectMainUI
    public final String cAo() {
        AppMethodBeat.i(64110);
        if (Util.isNullOrNil(this.qAU)) {
            this.qAU = ah.hhz();
        }
        String str = this.qAU;
        AppMethodBeat.o(64110);
        return str;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletPreferenceUI, com.tencent.mm.plugin.collect.ui.CollectMainUI
    public final boolean e(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(64111);
        if (qVar instanceof n) {
            final n nVar = (n) qVar;
            if (i2 != 0 || i3 != 0) {
                Log.e("MicroMsg.CollectHKMainUI", "net error: %s", qVar);
            } else if (nVar.dDN == 0) {
                this.qAT = nVar.qwo;
                this.mTrueName = nVar.qwy;
                this.qAU = nVar.qwx;
                refreshView();
                if (!Util.isNullOrNil(nVar.qwu)) {
                    this.qBp.setText(nVar.qwu);
                    this.qBs.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.collect.ui.CollectHKMainUI.AnonymousClass2 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(64105);
                            b bVar = new b();
                            bVar.bm(view);
                            a.b("com/tencent/mm/plugin/collect/ui/CollectHKMainUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            f.p(CollectHKMainUI.this.getContext(), nVar.qwv, false);
                            a.a(this, "com/tencent/mm/plugin/collect/ui/CollectHKMainUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(64105);
                        }
                    });
                    this.qBs.setVisibility(0);
                } else {
                    this.qBs.setVisibility(8);
                }
                if (!Util.isNullOrNil(nVar.jTx)) {
                    this.qAQ.setText(nVar.jTx);
                    this.qAQ.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.collect.ui.CollectHKMainUI.AnonymousClass3 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(64106);
                            b bVar = new b();
                            bVar.bm(view);
                            a.b("com/tencent/mm/plugin/collect/ui/CollectHKMainUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            if (!Util.isNullOrNil(nVar.jTy)) {
                                f.p(CollectHKMainUI.this.getContext(), nVar.jTy, true);
                            }
                            a.a(this, "com/tencent/mm/plugin/collect/ui/CollectHKMainUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(64106);
                        }
                    });
                    this.qAP.setVisibility(0);
                } else {
                    this.qAP.setVisibility(8);
                }
                AppMethodBeat.o(64111);
                return true;
            }
            if (!this.qAt) {
                AppMethodBeat.o(64111);
                return true;
            }
        }
        AppMethodBeat.o(64111);
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.collect.ui.CollectMainUI
    public final void cAp() {
        AppMethodBeat.i(64112);
        ImageView imageView = (ImageView) this.qyA.findViewById(R.id.b7c);
        ImageView imageView2 = (ImageView) this.qyA.findViewById(R.id.b74);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        layoutParams.addRule(13);
        imageView2.setLayoutParams(layoutParams);
        if (LocaleUtil.getApplicationLanguage().equals(LocaleUtil.HONGKONG)) {
            imageView.setImageResource(R.raw.collect_top_logo_hk_traditional);
            imageView2.setImageResource(R.raw.collect_bottom_logo_hk_traditional);
            AppMethodBeat.o(64112);
            return;
        }
        imageView.setImageResource(R.raw.collect_top_logo_hk);
        imageView2.setImageResource(R.raw.collect_bottom_logo_hk);
        AppMethodBeat.o(64112);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.collect.ui.CollectMainUI
    public final void cAq() {
        AppMethodBeat.i(64113);
        super.cAq();
        if (this.qBb) {
            findViewById(R.id.b6w).setVisibility(8);
            AppMethodBeat.o(64113);
            return;
        }
        findViewById(R.id.b6w).setVisibility(0);
        AppMethodBeat.o(64113);
    }
}
