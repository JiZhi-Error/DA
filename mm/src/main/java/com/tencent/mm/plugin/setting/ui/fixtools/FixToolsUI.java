package com.tencent.mm.plugin.setting.ui.fixtools;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cc.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMMHeaderPreference;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

@a(3)
public class FixToolsUI extends MMPreference {
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(73813);
        super.onCreate(bundle);
        this.screen = getPreferenceScreen();
        setMMTitle(R.string.dcb);
        SettingsAboutMMHeaderPreference settingsAboutMMHeaderPreference = (SettingsAboutMMHeaderPreference) this.screen.bmg("fix_tools_micromsg_header");
        String formatVersion = ChannelUtil.formatVersion(getContext(), d.KyO);
        if (d.KyR || BuildInfo.IS_FLAVOR_BLUE) {
            formatVersion = formatVersion + " " + h.jr(this);
        }
        settingsAboutMMHeaderPreference.Dak = formatVersion;
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(873, (long) getIntent().getIntExtra("entry_fix_tools", 2), 1, false);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(873, 0, 1, false);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(73812);
                FixToolsUI.this.finish();
                AppMethodBeat.o(73812);
                return true;
            }
        });
        AppMethodBeat.o(73813);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.b9;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(73814);
        if (preference.mKey.equals("fix_tools_uplog")) {
            if (com.tencent.mm.plugin.setting.model.a.eSG().jkK) {
                MMWizardActivity.ay(this, new Intent(getContext(), FixToolsUpLogUploadingUI.class));
            } else {
                Intent intent = new Intent(getContext(), FixToolsUplogUI.class);
                intent.putExtra("entry_fix_tools_uplog", 9);
                MMWizardActivity.ay(this, intent);
            }
            AppMethodBeat.o(73814);
            return true;
        } else if (preference.mKey.equals("fix_tools_db_recover")) {
            Intent className = new Intent().setClassName(getContext(), "com.tencent.mm.plugin.dbbackup.DBRecoveryUI");
            className.putExtra("scene", 2);
            AppCompatActivity context = getContext();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(className);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/setting/ui/fixtools/FixToolsUI", "goToRecovery", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/setting/ui/fixtools/FixToolsUI", "goToRecovery", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(73814);
            return true;
        } else if (preference.mKey.endsWith("fix_tools_matrix")) {
            if (!b.isInstalled()) {
                Toast.makeText(this, "Matrix is never installed", 0).show();
            } else {
                Intent intent2 = new Intent();
                intent2.setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.matrix.MatrixSettingUI");
                intent2.addFlags(67108864);
                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl2.axQ(), "com/tencent/mm/plugin/setting/ui/fixtools/FixToolsUI", "goToMatrixUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl2.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/fixtools/FixToolsUI", "goToMatrixUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            AppMethodBeat.o(73814);
            return true;
        } else if (preference.mKey.endsWith("fix_tools_search")) {
            Intent intent3 = new Intent(MMApplicationContext.getContext(), FixSearchUI.class);
            intent3.addFlags(67108864);
            com.tencent.mm.hellhoundlib.b.a bl3 = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl3.axQ(), "com/tencent/mm/plugin/setting/ui/fixtools/FixToolsUI", "goToSearchUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl3.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/fixtools/FixToolsUI", "goToSearchUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(73814);
            return true;
        } else if (preference.mKey.equals("fix_force_update")) {
            ((com.tencent.mm.plugin.updater.a.a) g.ah(com.tencent.mm.plugin.updater.a.a.class)).manualCheckUpdate(1);
            AppMethodBeat.o(73814);
            return true;
        } else {
            AppMethodBeat.o(73814);
            return false;
        }
    }
}
