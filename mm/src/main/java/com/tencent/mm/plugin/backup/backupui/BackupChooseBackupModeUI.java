package com.tencent.mm.plugin.backup.backupui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.app.n;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.backup.backupmoveui.BackupUI;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class BackupChooseBackupModeUI extends MMPreference {
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(21780);
        super.onCreate(bundle);
        this.screen = getPreferenceScreen();
        setMMTitle(R.string.a9m);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.backup.backupui.BackupChooseBackupModeUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(21779);
                BackupChooseBackupModeUI.this.finish();
                AppMethodBeat.o(21779);
                return true;
            }
        });
        ((n) g.af(n.class)).Wr();
        AppMethodBeat.o(21780);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.n;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(21782);
        super.onDestroy();
        ((n) g.af(n.class)).Wq();
        AppMethodBeat.o(21782);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(21781);
        if (preference.mKey.equals("backup_move_to_device")) {
            try {
                if (((l) g.af(l.class)).aTq().eiC()) {
                    bp.aVQ();
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.BackupChooseBackupModeUI", e2, "", new Object[0]);
            }
            MMWizardActivity.ay(this, new Intent(getContext(), BackupUI.class));
            AppMethodBeat.o(21781);
            return true;
        } else if (preference.mKey.equals("backup_to_pc")) {
            Intent intent = new Intent();
            intent.putExtra("title", getString(R.string.a7k));
            intent.putExtra("rawUrl", getString(R.string.a92, new Object[]{LocaleUtil.getApplicationLanguage()}));
            intent.putExtra("showShare", false);
            intent.putExtra("neverGetA8Key", true);
            c.b(this, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(21781);
            return true;
        } else {
            AppMethodBeat.o(21781);
            return false;
        }
    }
}
