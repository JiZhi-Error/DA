package com.tencent.mm.plugin.remittance.mobile.ui;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ao;
import org.xwalk.core.Log;

public class MobileRemitWelcomeUI extends MobileRemitBaseUI {
    @Override // com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(67755);
        super.onCreate(bundle);
        initView();
        overridePendingTransition(R.anim.eq, R.anim.en);
        AppMethodBeat.o(67755);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(67756);
        super.initView();
        setMMTitle("");
        hideActionbarLine();
        setActionbarColor(getResources().getColor(R.color.afz));
        setBackGroundColorResource(R.color.afz);
        setBackBtn(null);
        ((ImageView) findViewById(R.id.fid)).getDrawable().setColorFilter(getResources().getColor(R.color.Brand), PorterDuff.Mode.SRC_ATOP);
        findViewById(R.id.fib).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitWelcomeUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(67754);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitWelcomeUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.mobileRemit.MobileRemitWelcomeUI", "goto MobileRemitNumberInputUI");
                g.aAh().azQ().set(ar.a.USERINFO_MOBILE_REMITTANCE_WELOCOME_PAGE_SHOW_BOOLEAN_SYNC, Boolean.FALSE);
                c.b(MobileRemitWelcomeUI.this.getContext(), "remittance", ".mobile.ui.MobileRemitNumberInputUI", MobileRemitWelcomeUI.this.getIntent());
                MobileRemitWelcomeUI.this.finish();
                a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitWelcomeUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67754);
            }
        });
        ao.a(((TextView) findViewById(R.id.fih)).getPaint(), 0.8f);
        AppMethodBeat.o(67756);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bb_;
    }
}
