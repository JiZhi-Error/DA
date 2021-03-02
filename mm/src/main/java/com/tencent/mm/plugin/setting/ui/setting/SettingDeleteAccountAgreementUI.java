package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.MMActivity;

public class SettingDeleteAccountAgreementUI extends MMActivity {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bqh;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(73994);
        super.onCreate(bundle);
        setMMTitle(R.string.glh);
        initView();
        AppMethodBeat.o(73994);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(73995);
        final TextView textView = (TextView) findViewById(R.id.fz0);
        textView.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingDeleteAccountAgreementUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(73991);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/setting/ui/setting/SettingDeleteAccountAgreementUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SettingDeleteAccountAgreementUI settingDeleteAccountAgreementUI = SettingDeleteAccountAgreementUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(SettingDeleteAccountAgreementUI.this, SettingDeleteAccountInputPassUI.class));
                a.a(settingDeleteAccountAgreementUI, bl.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingDeleteAccountAgreementUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                settingDeleteAccountAgreementUI.startActivity((Intent) bl.pG(0));
                a.a(settingDeleteAccountAgreementUI, "com/tencent/mm/plugin/setting/ui/setting/SettingDeleteAccountAgreementUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingDeleteAccountAgreementUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(73991);
            }
        });
        final CheckedTextView checkedTextView = (CheckedTextView) findViewById(R.id.ih);
        checkedTextView.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingDeleteAccountAgreementUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(73992);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/setting/ui/setting/SettingDeleteAccountAgreementUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                textView.setEnabled(checkedTextView.isChecked());
                a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingDeleteAccountAgreementUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(73992);
            }
        });
        textView.setEnabled(checkedTextView.isChecked());
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingDeleteAccountAgreementUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(73993);
                SettingDeleteAccountAgreementUI.this.hideVKB();
                SettingDeleteAccountAgreementUI.this.finish();
                AppMethodBeat.o(73993);
                return true;
            }
        });
        AppMethodBeat.o(73995);
    }
}
