package com.tencent.mm.plugin.wxcredit.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a;

public class WalletBindDepositUI extends WalletBaseUI {
    private ElementQuery HRy = new ElementQuery();
    private WalletFormView Idp;
    private WalletFormView IeY;
    private WalletFormView JQf;
    private Button gxv;
    private boolean isFirst = true;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletBindDepositUI() {
        AppMethodBeat.i(72318);
        AppMethodBeat.o(72318);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(72319);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(72319);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c7b;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(72320);
        setMMTitle(R.string.i8f);
        this.Idp = (WalletFormView) findViewById(R.id.jel);
        a.b(this.Idp);
        this.IeY = (WalletFormView) findViewById(R.id.jf2);
        this.JQf = (WalletFormView) findViewById(R.id.fgm);
        a.c(this, this.JQf);
        this.gxv = (Button) findViewById(R.id.fz0);
        setEditFocusListener(this.Idp, 0, false);
        setEditFocusListener(this.JQf, 0, false);
        this.IeY.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wxcredit.ui.WalletBindDepositUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(72316);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wxcredit/ui/WalletBindDepositUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                String text = WalletBindDepositUI.this.Idp.getText();
                if (Util.isNullOrNil(text)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletBindDepositUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(72316);
                    return;
                }
                if (WalletBindDepositUI.this.isFirst) {
                    WalletBindDepositUI.this.getNetController().B(text);
                    WalletBindDepositUI.this.isFirst = false;
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putInt("key_support_bankcard", 1);
                    bundle.putString("key_bank_type", WalletBindDepositUI.this.HRy.dDj);
                    bundle.putInt("key_bankcard_type", 1);
                    com.tencent.mm.wallet_core.a.by(WalletBindDepositUI.this).a(WalletBindDepositUI.this, WalletCardSelectUI.class, bundle, 1);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletBindDepositUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(72316);
            }
        });
        this.gxv.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wxcredit.ui.WalletBindDepositUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(72317);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wxcredit/ui/WalletBindDepositUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (WalletBindDepositUI.e(WalletBindDepositUI.this)) {
                    WalletBindDepositUI.this.getNetController().r(WalletBindDepositUI.this.Idp.getText(), WalletBindDepositUI.this.HRy.dDj, WalletBindDepositUI.this.JQf.getText(), WalletBindDepositUI.this.HRy.HXo, Boolean.FALSE);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletBindDepositUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(72317);
            }
        });
        AppMethodBeat.o(72320);
    }

    private void updateView() {
        AppMethodBeat.i(72321);
        if (Util.isNullOrNil(this.HRy.ynT)) {
            this.IeY.setText("");
            AppMethodBeat.o(72321);
        } else if (2 == this.HRy.HXl) {
            this.IeY.setText(this.HRy.ynT + " " + getString(R.string.ibk));
            AppMethodBeat.o(72321);
        } else {
            this.IeY.setText(this.HRy.ynT + " " + getString(R.string.ic4));
            AppMethodBeat.o(72321);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(72322);
        Log.i("MicroMsg.WalletBindDepositUI", "onAcvityResult requestCode:".concat(String.valueOf(i2)));
        if (i3 != -1) {
            AppMethodBeat.o(72322);
            return;
        }
        switch (i2) {
            case 1:
                ElementQuery elementQuery = (ElementQuery) intent.getParcelableExtra("elemt_query");
                if (!elementQuery.fQr()) {
                    h.n(this, R.string.i8d, R.string.zb);
                    break;
                } else {
                    this.HRy = elementQuery;
                    updateView();
                    AppMethodBeat.o(72322);
                    return;
                }
        }
        AppMethodBeat.o(72322);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z = false;
        AppMethodBeat.i(72323);
        if (i2 == 0 && i3 == 0 && (qVar instanceof y)) {
            y yVar = (y) qVar;
            if (yVar.HQf != null) {
                if (!yVar.HQf.fQr()) {
                    h.n(this, R.string.i8d, R.string.zb);
                    AppMethodBeat.o(72323);
                    return true;
                }
                this.HRy = yVar.HQf;
                updateView();
                if (!this.HRy.HXj || !this.HRy.isError()) {
                    d by = com.tencent.mm.wallet_core.a.by(this);
                    if (by != null) {
                        int i4 = this.HRy.HQg;
                        if (by != null) {
                            if (!by.dQL.containsKey("key_support_bankcard")) {
                                z = true;
                            } else {
                                int hgI = by.hgI();
                                if (hgI == 0) {
                                    z = true;
                                } else {
                                    z = Bankcard.jT(hgI, i4);
                                }
                            }
                        }
                        if (!z) {
                            if (by.fTp()) {
                                Log.w("MicroMsg.WalletBindDepositUI", "Overseas user try to bind domestic card!");
                                h.n(this, R.string.i5p, R.string.zb);
                            } else {
                                Log.w("MicroMsg.WalletBindDepositUI", "Domestic user try to bind international card!");
                                h.n(this, R.string.i5o, R.string.zb);
                            }
                            this.Idp.eIj();
                            AppMethodBeat.o(72323);
                            return true;
                        }
                    }
                    updateView();
                    AppMethodBeat.o(72323);
                    return true;
                }
                h.n(this, R.string.i7k, R.string.zb);
                AppMethodBeat.o(72323);
                return true;
            }
        }
        AppMethodBeat.o(72323);
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    static /* synthetic */ boolean e(WalletBindDepositUI walletBindDepositUI) {
        AppMethodBeat.i(72324);
        if (!walletBindDepositUI.Idp.bql()) {
            u.makeText(walletBindDepositUI, (int) R.string.i9y, 0).show();
            AppMethodBeat.o(72324);
            return false;
        } else if (!walletBindDepositUI.IeY.bql()) {
            u.makeText(walletBindDepositUI, (int) R.string.i93, 0).show();
            AppMethodBeat.o(72324);
            return false;
        } else if (!walletBindDepositUI.JQf.bql()) {
            u.makeText(walletBindDepositUI, (int) R.string.i_h, 0).show();
            AppMethodBeat.o(72324);
            return false;
        } else {
            AppMethodBeat.o(72324);
            return true;
        }
    }
}
