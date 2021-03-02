package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.ui.MMActivity;

public class SettingsAliasResultUI extends MMActivity {
    private TextView Dbl;
    private Button Dbm;
    private ImageView Dbn;
    private boolean Dbo;
    private String fMb;
    private TextView jBR;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74109);
        super.onCreate(bundle);
        this.fMb = (String) g.aAh().azQ().get(42, (Object) null);
        this.Dbo = getIntent().getBooleanExtra("has_pwd", true);
        initView();
        AppMethodBeat.o(74109);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bqp;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(74110);
        super.onPause();
        AppMethodBeat.o(74110);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(74111);
        super.onDestroy();
        AppMethodBeat.o(74111);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(74112);
        setMMTitle(R.string.f35);
        this.jBR = (TextView) findViewById(R.id.bn6);
        this.Dbl = (TextView) findViewById(R.id.lq);
        this.Dbm = (Button) findViewById(R.id.hlk);
        this.Dbn = (ImageView) findViewById(R.id.g3l);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAliasResultUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74107);
                SettingsAliasResultUI.this.finish();
                AppMethodBeat.o(74107);
                return true;
            }
        });
        this.Dbl.setText(this.fMb);
        if (!this.Dbo) {
            this.Dbm.setVisibility(0);
            this.jBR.setText(getString(R.string.f3_));
        } else {
            this.Dbm.setVisibility(8);
            this.jBR.setText(getString(R.string.f3a));
        }
        this.Dbm.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAliasResultUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(74108);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsAliasResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(SettingsAliasResultUI.this.getContext(), RegByMobileSetPwdUI.class);
                intent.putExtra("kintent_hint", SettingsAliasResultUI.this.getString(R.string.fzx));
                SettingsAliasResultUI.this.startActivityForResult(intent, 0);
                a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAliasResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(74108);
            }
        });
        AppMethodBeat.o(74112);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(74113);
        if (i3 == -1) {
            finish();
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(74113);
    }
}
