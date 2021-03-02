package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelstat.k;
import com.tencent.mm.modelstat.m;
import com.tencent.mm.modelstat.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SettingsNetStatUI extends MMPreference {
    private long period;
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(SettingsNetStatUI settingsNetStatUI) {
        AppMethodBeat.i(74287);
        settingsNetStatUI.eTn();
        AppMethodBeat.o(74287);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.cl;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean autoRefresh() {
        return false;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74281);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(74281);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(74282);
        super.onResume();
        eTn();
        AppMethodBeat.o(74282);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(74283);
        setMMTitle(R.string.gvg);
        m bgo = q.bgo();
        int currentDayInMills = (int) (Util.currentDayInMills() / Util.MILLSECONDS_OF_DAY);
        if (bgo.tU(currentDayInMills) == null) {
            k kVar = new k();
            kVar.jog = currentDayInMills;
            kVar.id = -1;
            bgo.b(kVar);
        }
        this.screen = getPreferenceScreen();
        this.period = q.bgo().bgj();
        Preference bmg = this.screen.bmg("settings_netstat_info");
        String format = new SimpleDateFormat(getString(R.string.dev), Locale.US).format(new Date(this.period));
        bmg.setTitle(getString(R.string.gve, new Object[]{format}));
        Log.i("MicroMsg.SettingsNetStatUI", "title datatime = ".concat(String.valueOf(format)));
        Log.d("MicroMsg.SettingsNetStatUI", "title datatime = ".concat(String.valueOf(format)));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsNetStatUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74278);
                SettingsNetStatUI.this.hideVKB();
                SettingsNetStatUI.this.finish();
                AppMethodBeat.o(74278);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.gvh), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsNetStatUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74279);
                SettingsNetStatUI.a(SettingsNetStatUI.this);
                AppMethodBeat.o(74279);
                return true;
            }
        });
        AppMethodBeat.o(74283);
    }

    private void eTn() {
        AppMethodBeat.i(74284);
        k tV = q.bgo().tV((int) (this.period / Util.MILLSECONDS_OF_DAY));
        if (tV == null) {
            tV = new k();
        }
        this.period = q.bgo().bgj();
        this.screen.bmg("settings_netstat_info").setTitle(getString(R.string.gve, new Object[]{DateFormat.format(getString(R.string.dev, new Object[]{""}), this.period).toString()}));
        Preference bmg = this.screen.bmg("settings_netstat_mobile");
        Log.i("MicroMsg.SettingsNetStatUI", "dknetflow updateFlowStatistic mobile out:%d in:%d", Long.valueOf(tV.joB), Long.valueOf(tV.jop));
        bmg.setSummary(p(this, tV.joB + tV.jop));
        bmg.alO(8);
        Preference bmg2 = this.screen.bmg("settings_netstat_wifi");
        Log.i("MicroMsg.SettingsNetStatUI", "dknetflow updateFlowStatistic wifi out:%d in:%d", Long.valueOf(tV.joC), Long.valueOf(tV.joq));
        bmg2.setSummary(p(this, tV.joC + tV.joq));
        bmg2.alO(8);
        ((NetStatPreference) this.screen.bmg("settings_netstat_mobile_detail")).CZf = false;
        ((NetStatPreference) this.screen.bmg("settings_netstat_wifi_detail")).CZf = true;
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(74284);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        return false;
    }

    private static String p(Context context, long j2) {
        AppMethodBeat.i(74285);
        String string = context.getString(R.string.gvd, Util.getSizeKB(j2));
        AppMethodBeat.o(74285);
        return string;
    }

    static /* synthetic */ void a(SettingsNetStatUI settingsNetStatUI) {
        AppMethodBeat.i(74286);
        h.a(settingsNetStatUI.getContext(), (int) R.string.gvi, (int) R.string.gvj, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsNetStatUI.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(74280);
                m bgo = q.bgo();
                int currentDayInMills = (int) (Util.currentDayInMills() / Util.MILLSECONDS_OF_DAY);
                bgo.joS.clear();
                bgo.iFy.delete("netstat", null, null);
                k kVar = new k();
                kVar.jog = currentDayInMills;
                kVar.id = -1;
                bgo.b(kVar);
                SettingsNetStatUI.b(SettingsNetStatUI.this);
                AppMethodBeat.o(74280);
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsNetStatUI.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        }, (int) R.color.cd);
        AppMethodBeat.o(74286);
    }
}
