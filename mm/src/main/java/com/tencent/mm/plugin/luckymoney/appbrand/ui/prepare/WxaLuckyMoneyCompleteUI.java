package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI;
import com.tencent.mm.ui.MMActivity;

public class WxaLuckyMoneyCompleteUI extends WxaLuckyMoneyBaseUI implements b {
    private Button nAa;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(64941);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(64941);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(64942);
        this.nAa = (Button) findViewById(R.id.jrh);
        this.nAa.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyCompleteUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(64940);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyCompleteUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WxaLuckyMoneyCompleteUI.this.setResult(0, null);
                WxaLuckyMoneyCompleteUI.this.finish();
                a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyCompleteUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64940);
            }
        });
        AppMethodBeat.o(64942);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(64943);
        setResult(0, null);
        finish();
        AppMethodBeat.o(64943);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ccu;
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.ui.b
    public final MMActivity eeF() {
        return this;
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.ui.b
    public final void error(String str) {
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.ui.b
    public final void eeG() {
    }
}
