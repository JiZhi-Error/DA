package com.tencent.mm.plugin.setting.ui.fixtools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cc.h;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMMHeaderPreference;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.util.c;
import com.tencent.mm.vfs.s;

public class FixSearchUI extends MMPreference {
    private d CYs;
    private d CYt;
    private d CYu;
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(73809);
        super.onCreate(bundle);
        this.screen = getPreferenceScreen();
        setMMTitle(R.string.dcj);
        SettingsAboutMMHeaderPreference settingsAboutMMHeaderPreference = (SettingsAboutMMHeaderPreference) this.screen.bmg("fix_tools_micromsg_header");
        String formatVersion = ChannelUtil.formatVersion(getContext(), com.tencent.mm.protocal.d.KyO);
        if (com.tencent.mm.protocal.d.KyR || BuildInfo.IS_FLAVOR_BLUE) {
            formatVersion = formatVersion + " " + h.jr(this);
        }
        settingsAboutMMHeaderPreference.Dak = formatVersion;
        c cVar = c.QYz;
        if (c.hdg()) {
            this.screen.m38do("fix_tools_fts_info", false);
        } else {
            this.screen.m38do("fix_tools_fts_info", true);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.fixtools.FixSearchUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(73805);
                FixSearchUI.this.finish();
                AppMethodBeat.o(73805);
                return true;
            }
        });
        AppMethodBeat.o(73809);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.b_;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(73810);
        if (preference.mKey.endsWith("fix_tools_fts")) {
            if (this.CYs == null) {
                this.CYs = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dcg), "", true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.setting.ui.fixtools.FixSearchUI.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(73806);
                        Log.i("MicroMsg.FixSearchUI", "delete fts db, and kill process");
                        e.Nk(24);
                        StringBuilder sb = new StringBuilder();
                        g.aAi();
                        String sb2 = sb.append(g.aAh().cachePath).append("FTS5IndexMicroMsg_encrypt.db").toString();
                        String[] strArr = {"", "-journal", "-wal", "-shm"};
                        for (int i3 = 0; i3 < 4; i3++) {
                            String str = sb2 + strArr[i3];
                            Log.i("MicroMsg.FixSearchUI", "deleteIndexDB %s %s", str, Boolean.valueOf(s.YS(str)));
                            s.deleteFile(str);
                        }
                        FixSearchUI.this.finish();
                        if (com.tencent.mm.pluginsdk.i.c.JYn != null) {
                            com.tencent.mm.pluginsdk.i.c.JYn.bV(FixSearchUI.this.getContext());
                        }
                        AppMethodBeat.o(73806);
                    }
                }, (DialogInterface.OnClickListener) null);
            }
            this.CYs.show();
            AppMethodBeat.o(73810);
            return true;
        } else if (preference.mKey.endsWith("fix_tools_websearch")) {
            if (this.CYt == null) {
                this.CYt = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dct), "", true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.setting.ui.fixtools.FixSearchUI.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(73807);
                        Log.i("MicroMsg.FixSearchUI", "delete web search template, and kill process");
                        s.dy(ai.afr(0).fYs(), true);
                        ar.afB(30);
                        FixSearchUI.this.finish();
                        if (com.tencent.mm.pluginsdk.i.c.JYn != null) {
                            com.tencent.mm.pluginsdk.i.c.JYn.bV(FixSearchUI.this.getContext());
                        }
                        AppMethodBeat.o(73807);
                    }
                }, (DialogInterface.OnClickListener) null);
            }
            this.CYt.show();
            AppMethodBeat.o(73810);
            return true;
        } else if (preference.mKey.endsWith("fix_tools_topstory")) {
            if (this.CYu == null) {
                this.CYu = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dct), "", true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.setting.ui.fixtools.FixSearchUI.AnonymousClass4 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(73808);
                        Log.i("MicroMsg.FixSearchUI", "delete topstory template, and kill process");
                        s.dy(ai.afr(1).fYs(), true);
                        ar.afB(31);
                        FixSearchUI.this.finish();
                        if (com.tencent.mm.pluginsdk.i.c.JYn != null) {
                            com.tencent.mm.pluginsdk.i.c.JYn.bV(FixSearchUI.this.getContext());
                        }
                        AppMethodBeat.o(73808);
                    }
                }, (DialogInterface.OnClickListener) null);
            }
            this.CYu.show();
            AppMethodBeat.o(73810);
            return true;
        } else if (preference.mKey.endsWith("fix_tools_fts_info")) {
            Intent intent = new Intent();
            intent.setClassName(getContext(), "com.tencent.mm.plugin.search.ui.FTSInfoUI");
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/setting/ui/fixtools/FixSearchUI", "goToFTSInfoUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/fixtools/FixSearchUI", "goToFTSInfoUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(73810);
            return true;
        } else {
            AppMethodBeat.o(73810);
            return false;
        }
    }
}
