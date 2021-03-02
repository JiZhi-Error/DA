package com.tencent.mm.plugin.wallet_core.id_verify;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class WcPayRealnameVerifySuccessUI extends WalletBaseUI {
    private Button HTy;
    private Button HTz;
    private TextView jVn;
    private ImageView lIM;
    private TextView mPa;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(70137);
        super.onCreate(bundle);
        setActionbarColor(getResources().getColor(R.color.f3048f));
        hideActionbarLine();
        showHomeBtn(false);
        setMMTitle("");
        this.mPa = (TextView) findViewById(R.id.jqv);
        this.jVn = (TextView) findViewById(R.id.jqu);
        this.lIM = (ImageView) findViewById(R.id.jqw);
        this.HTy = (Button) findViewById(R.id.jqs);
        this.HTz = (Button) findViewById(R.id.jqt);
        if (getInput().getInt("realname_verify_process_finish_err_jump") == 1) {
            this.HTy.setVisibility(0);
            this.HTz.setVisibility(0);
            this.lIM.setImageDrawable(ar.m(getContext(), R.raw.icons_outlined_error1, getResources().getColor(R.color.Red_100)));
            String string = getInput().getString("realname_verify_process_finish_page");
            if (!Util.isNullOrNil(string)) {
                this.HTy.setText(string);
            }
            this.HTz.setText(R.string.sz);
            this.HTy.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifySuccessUI.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(70134);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifySuccessUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    com.tencent.mm.wallet_core.a.s(WcPayRealnameVerifySuccessUI.this.getContext(), 1);
                    a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifySuccessUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(70134);
                }
            });
            this.HTz.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifySuccessUI.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(70135);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifySuccessUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    com.tencent.mm.wallet_core.a.c(WcPayRealnameVerifySuccessUI.this.getContext(), WcPayRealnameVerifySuccessUI.this.getInput(), 0);
                    a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifySuccessUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(70135);
                }
            });
        } else {
            this.HTy.setVisibility(8);
            this.HTz.setVisibility(0);
            this.lIM.setImageResource(R.raw.realname_done);
            String string2 = getInput().getString("realname_verify_process_finish_page");
            if (!Util.isNullOrNil(string2)) {
                this.HTz.setText(string2);
            }
            this.HTz.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifySuccessUI.AnonymousClass4 */

                public final void onClick(View view) {
                    AppMethodBeat.i(70136);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifySuccessUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    com.tencent.mm.wallet_core.a.c(WcPayRealnameVerifySuccessUI.this.getContext(), WcPayRealnameVerifySuccessUI.this.getInput(), 0);
                    a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifySuccessUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(70136);
                }
            });
        }
        String string3 = getInput().getString("realname_verify_process_finish_title");
        String string4 = getInput().getString("realname_verify_process_finish_desc");
        if (!Util.isNullOrNil(string3)) {
            this.mPa.setText(string3);
        }
        if (!Util.isNullOrNil(string4)) {
            this.jVn.setText(string4);
            this.jVn.setVisibility(0);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifySuccessUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(70133);
                com.tencent.mm.wallet_core.a.c(WcPayRealnameVerifySuccessUI.this.getContext(), WcPayRealnameVerifySuccessUI.this.getInput(), 0);
                AppMethodBeat.o(70133);
                return false;
            }
        });
        AppMethodBeat.o(70137);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.cb5;
    }
}
