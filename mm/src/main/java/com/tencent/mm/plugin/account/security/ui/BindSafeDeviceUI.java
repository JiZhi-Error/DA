package com.tencent.mm.plugin.account.security.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.ui.MMWizardActivity;

public class BindSafeDeviceUI extends MMWizardActivity {
    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bp8;
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(125542);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(125542);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(125543);
        setMMTitle(R.string.g_q);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.security.ui.BindSafeDeviceUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(125540);
                BindSafeDeviceUI.this.finish();
                AppMethodBeat.o(125540);
                return true;
            }
        });
        ((ImageView) findViewById(R.id.hg9)).setImageResource(R.raw.accounts_saftphone_icon);
        ((TextView) findViewById(R.id.hg_)).setText(R.string.g_w);
        ((TextView) findViewById(R.id.iop)).setText(R.string.g_x);
        findViewById(R.id.iop).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.security.ui.BindSafeDeviceUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(125541);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/account/security/ui/BindSafeDeviceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("bind_scene", 1);
                intent.setClass(BindSafeDeviceUI.this, BindMContactUI.class);
                MMWizardActivity.ay(BindSafeDeviceUI.this, intent);
                a.a(this, "com/tencent/mm/plugin/account/security/ui/BindSafeDeviceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(125541);
            }
        });
        AppMethodBeat.o(125543);
    }
}
