package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.MMActivity;

public class SettingDeleteAccountUI extends MMActivity {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bqg;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74002);
        super.onCreate(bundle);
        setMMTitle(R.string.glh);
        initView();
        AppMethodBeat.o(74002);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(74003);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingDeleteAccountUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74000);
                SettingDeleteAccountUI.this.hideVKB();
                SettingDeleteAccountUI.this.finish();
                AppMethodBeat.o(74000);
                return true;
            }
        });
        ((TextView) findViewById(R.id.bma)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingDeleteAccountUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(74001);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/setting/ui/setting/SettingDeleteAccountUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingDeleteAccountUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(74001);
            }
        });
        AppMethodBeat.o(74003);
    }
}
