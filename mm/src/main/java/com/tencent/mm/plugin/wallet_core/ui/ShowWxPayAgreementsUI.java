package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.MMWebView;

@a(3)
public class ShowWxPayAgreementsUI extends MMActivity {
    private TextView IcX;
    private TextView IcY;
    private String content;
    private MMWebView tcN;
    private int type;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(70684);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(70684);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(70685);
        h.INSTANCE.a(15236, 1);
        getSupportActionBar().hide();
        overridePendingTransition(R.anim.dq, R.anim.s);
        this.type = getIntent().getIntExtra("agreement_type", 0);
        this.tcN = MMWebView.a.a(this, getContentView(), R.id.il);
        this.tcN.getSettings().setJavaScriptEnabled(true);
        this.IcX = (TextView) findViewById(R.id.ij);
        this.IcY = (TextView) findViewById(R.id.ig);
        this.content = getIntent().getStringExtra("agreement_content");
        this.IcY.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.ShowWxPayAgreementsUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(70682);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/ShowWxPayAgreementsUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                h.INSTANCE.a(15236, 2);
                ShowWxPayAgreementsUI.this.setResult(-1);
                ShowWxPayAgreementsUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/ShowWxPayAgreementsUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70682);
            }
        });
        this.IcX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.ShowWxPayAgreementsUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(70683);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/ShowWxPayAgreementsUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                h.INSTANCE.a(15236, 3);
                ShowWxPayAgreementsUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/ShowWxPayAgreementsUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70683);
            }
        });
        this.tcN.setWebViewClient(new i(this));
        if (getContext().getApplicationInfo().targetSdkVersion >= 29) {
            this.tcN.loadData(Base64.encodeToString(this.content.getBytes(), 0), "text/html; charset=UTF-8", "base64");
            AppMethodBeat.o(70685);
            return;
        }
        this.tcN.loadData(this.content, "text/html; charset=UTF-8", null);
        AppMethodBeat.o(70685);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bsl;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(70686);
        Log.i("MicroMsg.ShowWxPayAgreementsUI", "onRefreshed");
        super.finish();
        overridePendingTransition(R.anim.s, R.anim.f6do);
        AppMethodBeat.o(70686);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(70687);
        super.onResume();
        AppMethodBeat.o(70687);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(70688);
        super.onPause();
        AppMethodBeat.o(70688);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(70689);
        if (i2 == 4) {
            AppMethodBeat.o(70689);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(70689);
        return onKeyDown;
    }
}
