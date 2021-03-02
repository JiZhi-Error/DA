package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SelectPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.f;
import org.xwalk.core.XWalkEnvironment;

public class SettingDarkMode extends MMPreference {
    private SelectPreference CZO;
    private SelectPreference CZP;
    private int CZQ = 0;
    private boolean CZR;
    private boolean CZS;
    private boolean crv;
    private boolean hfZ;
    private int nGn = 0;
    private f screen;
    private boolean thE = false;
    private int xGO = 0;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void d(SettingDarkMode settingDarkMode) {
        AppMethodBeat.i(256495);
        settingDarkMode.eSQ();
        AppMethodBeat.o(256495);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.c7;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(256488);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(256488);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(256489);
        setMMTitle(getString(R.string.go9));
        this.screen = getPreferenceScreen();
        if (!ao.awN()) {
            MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_follow_system", false);
            ao.gJU();
        }
        this.crv = ao.isDarkMode();
        this.CZR = this.crv;
        MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_follow_system_need_report", false);
        this.hfZ = MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getBoolean("dark_mode_follow_system", false);
        this.CZS = this.hfZ;
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.screen.bmg("follow_system");
        this.CZO = (SelectPreference) this.screen.bmg("dark_mode");
        this.CZP = (SelectPreference) this.screen.bmg("normal_mode");
        if (!ao.awN()) {
            this.screen.m38do("follow_system", true);
            this.screen.m38do("manual_title", true);
        } else if (checkBoxPreference != null) {
            checkBoxPreference.setChecked(this.hfZ);
            checkBoxPreference.xZ(this.hfZ);
            checkBoxPreference.OZw = false;
        }
        if (this.hfZ) {
            up(true);
        } else {
            up(false);
            if (this.crv) {
                this.CZO.isSelected = true;
                this.CZP.isSelected = false;
            } else {
                this.CZP.isSelected = true;
                this.CZO.isSelected = false;
            }
        }
        this.screen.notifyDataSetChanged();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingDarkMode.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(256485);
                SettingDarkMode.this.finish();
                AppMethodBeat.o(256485);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.vl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingDarkMode.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(256486);
                SettingDarkMode.a(SettingDarkMode.this);
                AppMethodBeat.o(256486);
                return true;
            }
        }, null, t.b.GREEN);
        AppMethodBeat.o(256489);
    }

    private void up(boolean z) {
        AppMethodBeat.i(256490);
        if (!ao.awN()) {
            this.screen.m38do("manual_title", true);
        } else {
            this.screen.m38do("manual_title", z);
        }
        this.screen.m38do("dark_mode", z);
        this.screen.m38do("normal_mode", z);
        AppMethodBeat.o(256490);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(256492);
        if (i2 == 4 && keyEvent.getAction() == 0) {
            finish();
            AppMethodBeat.o(256492);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(256492);
        return onKeyDown;
    }

    private void eSQ() {
        AppMethodBeat.i(256493);
        if (this.thE) {
            if (ao.awS()) {
                MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_follow_system_need_report", true);
                AppMethodBeat.o(256493);
                return;
            }
            if (this.CZS != this.hfZ) {
                this.nGn = 4;
            }
            h hVar = h.INSTANCE;
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(this.nGn);
            objArr[1] = Integer.valueOf(this.CZQ);
            objArr[2] = 2;
            objArr[3] = Integer.valueOf(this.xGO);
            objArr[4] = Integer.valueOf(ao.awN() ? 1 : 0);
            hVar.a(18893, objArr);
            Log.i(MMPreference.TAG, "dark mode kvReport logID:%s, action:%s, dark:%s, mode:%s", 18893, Integer.valueOf(this.nGn), Integer.valueOf(this.CZQ), Integer.valueOf(this.xGO));
        }
        AppMethodBeat.o(256493);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        int i2 = 1;
        AppMethodBeat.i(256491);
        String str = preference.mKey;
        this.thE = true;
        if (str.equals("follow_system")) {
            if (((CheckBoxPreference) preference).isChecked()) {
                this.nGn = 4;
                this.CZQ = ao.f(getResources()) ? 1 : 0;
                this.xGO = 1;
                this.CZS = true;
                up(true);
            } else {
                this.nGn = 4;
                this.CZQ = this.crv ? 1 : 0;
                this.xGO = 2;
                this.CZS = false;
                up(false);
                if (this.crv) {
                    this.CZO.isSelected = true;
                    this.CZP.isSelected = false;
                } else {
                    this.CZP.isSelected = true;
                    this.CZO.isSelected = false;
                }
            }
            this.CZR = this.crv;
            fVar.notifyDataSetChanged();
        } else {
            boolean z = this.crv;
            if (str.equals("dark_mode")) {
                this.CZO.isSelected = true;
                this.CZP.isSelected = false;
                fVar.notifyDataSetChanged();
                z = true;
            } else if (str.equals("normal_mode")) {
                this.CZO.isSelected = false;
                this.CZP.isSelected = true;
                fVar.notifyDataSetChanged();
                z = false;
            }
            this.nGn = 2;
            if (!z) {
                i2 = 0;
            }
            this.CZQ = i2;
            this.xGO = 2;
            this.CZR = z;
        }
        AppMethodBeat.o(256491);
        return false;
    }

    static /* synthetic */ void a(SettingDarkMode settingDarkMode) {
        AppMethodBeat.i(256494);
        if ((!settingDarkMode.CZS || settingDarkMode.hfZ == settingDarkMode.CZS) && (settingDarkMode.CZS || settingDarkMode.crv == settingDarkMode.CZR)) {
            MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_follow_system", settingDarkMode.CZS);
            ao.gJU();
            MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode", settingDarkMode.CZR);
            settingDarkMode.eSQ();
            settingDarkMode.finish();
            AppMethodBeat.o(256494);
            return;
        }
        f.a aVar = new f.a(settingDarkMode.getContext());
        aVar.bow(settingDarkMode.getContext().getResources().getString(R.string.gld)).Dq(true);
        aVar.c(new f.c() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingDarkMode.AnonymousClass3 */

            @Override // com.tencent.mm.ui.widget.a.f.c
            public final void e(boolean z, String str) {
                AppMethodBeat.i(256487);
                if (z) {
                    MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_follow_system", SettingDarkMode.this.CZS);
                    ao.gJU();
                    MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode", SettingDarkMode.this.CZR);
                    SettingDarkMode.d(SettingDarkMode.this);
                    SettingDarkMode.this.finish();
                    if (!SettingDarkMode.this.CZS) {
                        XWalkEnvironment.setForceDarkMode(SettingDarkMode.this.CZR);
                        MMWebView.CU(SettingDarkMode.this.CZR);
                    }
                    com.tencent.mm.plugin.sns.ui.widget.f.resetConfig();
                    b.aXY().clearCache();
                    if (g.af(com.tencent.mm.plugin.ball.c.b.class) != null) {
                        ((com.tencent.mm.plugin.ball.c.b) g.af(com.tencent.mm.plugin.ball.c.b.class)).onAccountRelease();
                        ((com.tencent.mm.plugin.ball.c.b) g.af(com.tencent.mm.plugin.ball.c.b.class)).chL();
                    }
                    Intent intent = new Intent();
                    intent.putExtra("Intro_Need_Clear_Top ", true);
                    intent.addFlags(67108864);
                    intent.addFlags(536870912);
                    c.jRt.o(intent, SettingDarkMode.this.getContext());
                    a.iH(MMApplicationContext.getContext());
                }
                AppMethodBeat.o(256487);
            }
        }).show();
        AppMethodBeat.o(256494);
    }
}
