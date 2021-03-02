package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.gc;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.setting.d;
import com.tencent.mm.protocal.protobuf.ye;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.ArrayList;
import java.util.List;

public class SettingsModifyAliasCheckUI extends MMWizardActivity {
    private List<ye> Dbs = null;
    private boolean Dbt = false;
    private List<View> DcA = new ArrayList();
    private LinearLayout Dcz;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingsModifyAliasCheckUI() {
        AppMethodBeat.i(256550);
        AppMethodBeat.o(256550);
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(256551);
        super.onCreate(bundle);
        initView();
        if (h.aqJ().getInt("EnableModAlias", 0) == 0) {
            finish();
        }
        AppMethodBeat.o(256551);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bqo;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(256552);
        setMMTitle("");
        hideActionbarLine();
        setActionbarColor(getResources().getColor(R.color.afz));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyAliasCheckUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(256548);
                gc gcVar = new gc();
                gcVar.tm(SettingsAliasUI.Dbv);
                gcVar.ejW = 7;
                gcVar.bfK();
                SettingsModifyAliasCheckUI.this.onBackPressed();
                AppMethodBeat.o(256548);
                return true;
            }
        });
        this.Dcz = (LinearLayout) findViewById(R.id.hmu);
        ((TextView) findViewById(R.id.hmv)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyAliasCheckUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(256549);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasCheckUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.plugin.account.a.b.a.b(SettingsModifyAliasCheckUI.this, SettingsModifyAliasCheckUI.this.getString(R.string.gl2, new Object[]{LocaleUtil.getApplicationLanguage()}), -1, true);
                gc gcVar = new gc();
                gcVar.tm(SettingsAliasUI.Dbv);
                gcVar.ejW = 8;
                gcVar.bfK();
                a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasCheckUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(256549);
            }
        });
        this.Dbs = d.eSE();
        if (this.Dbs == null || this.Dbs.isEmpty()) {
            this.Dbt = false;
            this.Dcz.removeAllViews();
            AppMethodBeat.o(256552);
            return;
        }
        Log.i("MicroMsg.SettingsModifyAliasCheckUI", "conditions %s", Integer.valueOf(this.Dbs.size()));
        this.Dcz.removeAllViews();
        this.Dbt = true;
        for (int i2 = 0; i2 < this.Dbs.size(); i2++) {
            View inflate = View.inflate(this, R.layout.br0, null);
            this.DcA.add(inflate);
            TextView textView = (TextView) inflate.findViewById(R.id.fiy);
            TextView textView2 = (TextView) inflate.findViewById(R.id.fiz);
            ((TextView) inflate.findViewById(R.id.fj0)).setText(this.Dbs.get(i2).title);
            if (!Util.isNullOrNil(this.Dbs.get(i2).desc)) {
                textView.setText(this.Dbs.get(i2).desc);
                textView.setVisibility(0);
            }
            textView2.setText(this.Dbs.get(i2).result);
            if (this.Dbs.get(i2).Lje) {
                textView2.setTextColor(getResources().getColor(R.color.ts));
            } else {
                textView2.setTextColor(getResources().getColor(R.color.a5e));
            }
            if (i2 % 2 == 0) {
                inflate.findViewById(R.id.fj1).setVisibility(0);
            }
            inflate.findViewById(R.id.fix).setVisibility(0);
            this.Dcz.addView(inflate, new LinearLayout.LayoutParams(-1, -2));
            this.Dbt = this.Dbt && this.Dbs.get(i2).Lje;
        }
        AppMethodBeat.o(256552);
    }
}
