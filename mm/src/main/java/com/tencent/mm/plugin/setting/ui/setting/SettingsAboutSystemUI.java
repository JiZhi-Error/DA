package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.h.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.newtips.a;
import com.tencent.mm.plugin.newtips.a.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.List;

public class SettingsAboutSystemUI extends MMPreference {
    private boolean DaE = false;
    private int DaF = -1;
    private int DaG = -1;
    private boolean DaH = false;
    private ProgressDialog Dav = null;
    private boolean isDeleteCancel = false;
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void e(SettingsAboutSystemUI settingsAboutSystemUI) {
        AppMethodBeat.i(74066);
        settingsAboutSystemUI.eSW();
        AppMethodBeat.o(74066);
    }

    static /* synthetic */ void f(SettingsAboutSystemUI settingsAboutSystemUI) {
        AppMethodBeat.i(74067);
        settingsAboutSystemUI.eSX();
        AppMethodBeat.o(74067);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.ct;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74054);
        super.onCreate(bundle);
        this.DaE = false;
        initView();
        AppMethodBeat.o(74054);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(74055);
        setMMTitle(R.string.gn1);
        this.screen = getPreferenceScreen();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74039);
                SettingsAboutSystemUI.this.hideVKB();
                SettingsAboutSystemUI.this.finish();
                AppMethodBeat.o(74039);
                return true;
            }
        });
        this.screen.m38do("settings_swipeback_mode", !d.oD(19));
        if (!c.aZU("backup")) {
            this.screen.m38do("settings_bak_chat", true);
        }
        eSU();
        this.screen.m38do("settings_traffic_statistic", c.gsX());
        if (eSY()) {
            if (this.screen.bmg("settings_take_photo") != null) {
                this.screen.bmg("settings_take_photo").setTitle(R.string.gsf);
            }
        } else if (this.screen.bmg("settings_take_photo") != null) {
            this.screen.bmg("settings_take_photo").setTitle(R.string.gse);
        }
        if (ac.jPB) {
            this.screen.m38do("settings_take_photo", true);
        }
        if (com.tencent.mm.cc.c.gvD() || (!BuildInfo.IS_FLAVOR_RED && !BuildInfo.IS_FLAVOR_PURPLE && !ao.awO())) {
            this.screen.m38do("settings_dark", true);
            this.screen.m38do("small_divider", true);
        }
        AppMethodBeat.o(74055);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        String string;
        IconPreference iconPreference;
        AppMethodBeat.i(74056);
        super.onResume();
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.screen.bmg("settings_voice_play_mode");
        if (checkBoxPreference != null) {
            checkBoxPreference.setChecked(((Boolean) g.aAh().azQ().get(26, Boolean.FALSE)).booleanValue());
            checkBoxPreference.OZw = false;
        }
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.screen.bmg("settings_enter_button_send");
        if (checkBoxPreference2 != null) {
            checkBoxPreference2.setChecked(((Boolean) g.aAh().azQ().get(66832, Boolean.FALSE)).booleanValue());
            checkBoxPreference2.OZw = false;
        }
        CheckBoxPreference checkBoxPreference3 = (CheckBoxPreference) this.screen.bmg("settings_swipeback_mode");
        if (checkBoxPreference3 != null) {
            checkBoxPreference3.setChecked(b.apl());
            checkBoxPreference3.OZw = false;
        }
        Preference bmg = this.screen.bmg("settings_language");
        if (bmg != null) {
            bmg.setSummary(LocaleUtil.getLanguageName(getContext(), R.array.q, R.string.w8));
        }
        eSU();
        eSX();
        eSX();
        eSW();
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this);
        CheckBoxPreference checkBoxPreference4 = (CheckBoxPreference) this.screen.bmg("settings_nfc_switch");
        if (defaultAdapter == null) {
            this.screen.m38do("settings_nfc_switch", true);
        } else {
            this.screen.m38do("settings_nfc_switch", false);
            checkBoxPreference4.setSummary(Util.nullAsNil((String) g.aAh().azQ().get(ar.a.USERINFO_NFC_OPEN_SWITCH_WORDING_STRING_SYNC, (Object) null)));
            if (this.DaE) {
                Log.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-updateNfcOpenSwitch go setSystemNfc and back");
                if (defaultAdapter.isEnabled()) {
                    st(true);
                    ur(true);
                }
            }
            int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, (Object) 0)).intValue();
            if (intValue == 0) {
                if (((Integer) g.aAh().azQ().get(ar.a.USERINFO_NFC_OPEN_DEFAULT_SWITCH_INT_SYNC, (Object) 0)).intValue() == 1) {
                    ur(true);
                } else {
                    ur(false);
                }
            } else if (intValue == 1) {
                ur(true);
            } else {
                ur(false);
            }
            this.screen.notifyDataSetChanged();
        }
        IconPreference iconPreference2 = (IconPreference) this.screen.bmg("settings_dark");
        if (ao.awN()) {
            if (ao.awS()) {
                string = getString(R.string.w8);
                iconPreference = iconPreference2;
            } else if (ao.isDarkMode()) {
                string = getString(R.string.glo);
                iconPreference = iconPreference2;
            } else {
                string = getString(R.string.glc);
                iconPreference = iconPreference2;
            }
            iconPreference.setSummary(string);
        }
        com.tencent.mm.cc.c.gvE();
        iconPreference2.alF(8);
        this.screen.m38do("settngs_matrix_trace", true);
        AppMethodBeat.o(74056);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(74057);
        super.onDestroy();
        if (this.DaH) {
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.DaG);
            if (this.DaF == this.DaG) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            Log.i("MicroMsg.SettingsAboutSystemUI", "kvstat, autodownload sight change: %d, %b", objArr);
            h hVar = h.INSTANCE;
            Object[] objArr2 = new Object[3];
            objArr2[0] = 1;
            objArr2[1] = Integer.valueOf(this.DaG);
            if (this.DaF != this.DaG) {
                z2 = false;
            }
            objArr2[2] = Boolean.valueOf(z2);
            hVar.a(11437, objArr2);
        }
        AppMethodBeat.o(74057);
    }

    private void eSU() {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(74059);
        IconPreference iconPreference = (IconPreference) this.screen.bmg("settings_plugins");
        if (Util.nullAs((Boolean) g.aAh().azQ().get(-2046825377, (Object) null), false)) {
            iconPreference.alD(0);
            iconPreference.gY(getString(R.string.x4), R.drawable.amr);
        } else {
            iconPreference.alD(8);
            iconPreference.gY("", -1);
        }
        if (com.tencent.mm.y.c.axV().cP(262158, 266266)) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        iconPreference.alF(i2);
        a.exo();
        if (!e.Ty(com.tencent.mm.plugin.newtips.a.d.ADb)) {
            i3 = 8;
        }
        iconPreference.alF(i3);
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(74059);
    }

    private boolean eSV() {
        AppMethodBeat.i(74060);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(this, SettingsFontUI.class));
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetTextSize", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetTextSize", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(74060);
        return true;
    }

    private void st(boolean z) {
        AppMethodBeat.i(74061);
        if (z) {
            getPackageManager().setComponentEnabledSetting(new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
            g.aAh().azQ().set(ar.a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, (Object) 1);
            AppMethodBeat.o(74061);
            return;
        }
        getPackageManager().setComponentEnabledSetting(new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
        g.aAh().azQ().set(ar.a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, (Object) 2);
        AppMethodBeat.o(74061);
    }

    private void ur(boolean z) {
        AppMethodBeat.i(74062);
        MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putBoolean("settings_nfc_switch", z).commit();
        ((CheckBoxPreference) this.screen.bmg("settings_nfc_switch")).setChecked(z);
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(74062);
    }

    private void eSW() {
        boolean z = true;
        AppMethodBeat.i(74063);
        boolean z2 = Util.safeParseInt(com.tencent.mm.n.h.aqJ().getValue("SilentDownloadApkAtWiFi")) != 0;
        if ((ChannelUtil.updateMode & 1) != 0) {
            Log.d("MicroMsg.SettingsAboutSystemUI", "channel pack, not silence download.");
            z2 = true;
        }
        if (z2) {
            this.screen.m38do("settings_silence_update_mode", true);
            AppMethodBeat.o(74063);
            return;
        }
        this.screen.m38do("settings_silence_update_mode", false);
        if ((((Integer) g.aAh().azQ().get(7, (Object) 0)).intValue() & TPMediaCodecProfileLevel.HEVCMainTierLevel62) != 0) {
            z = false;
        }
        this.screen.bmg("settings_silence_update_mode").setSummary(getString(z ? R.string.gu4 : R.string.gu3));
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(74063);
    }

    private void a(LinearLayout linearLayout, int i2, int i3, boolean z, View.OnClickListener onClickListener) {
        AppMethodBeat.i(74064);
        TextView textView = (TextView) View.inflate(getContext(), R.layout.bkg, null);
        textView.setText(i2);
        textView.setTag(Integer.valueOf(i3));
        linearLayout.addView(textView);
        textView.setOnClickListener(onClickListener);
        if (z) {
            textView.setCompoundDrawablesWithIntrinsicBounds(R.raw.radio_on, 0, 0, 0);
        }
        AppMethodBeat.o(74064);
    }

    private void eSX() {
        int i2;
        AppMethodBeat.i(74065);
        int i3 = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("SIGHTAutoLoadNetwork"), 1);
        int nullAs = Util.nullAs((Integer) g.aAh().azQ().get(327686, (Object) null), i3);
        Log.i("MicroMsg.SettingsAboutSystemUI", "auto getSightViewSummary %d, %d", Integer.valueOf(i3), Integer.valueOf(nullAs));
        if (this.DaF == -1) {
            this.DaF = nullAs;
        }
        this.DaG = nullAs;
        if (3 == nullAs) {
            i2 = R.string.gug;
        } else if (2 == nullAs) {
            i2 = R.string.gui;
        } else {
            i2 = R.string.guf;
        }
        Preference bmg = this.screen.bmg("settings_sns_sight_auto_download");
        if (bmg != null) {
            bmg.setSummary(getString(i2));
        }
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(74065);
    }

    public static boolean eSY() {
        AppMethodBeat.i(256509);
        boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.mmvoip_multipath_switch, false);
        AppMethodBeat.o(256509);
        return a2;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        AppMethodBeat.i(74058);
        String str = preference.mKey;
        if (str.equals("settings_landscape_mode")) {
            Log.i("MicroMsg.SettingsAboutSystemUI", "set ScreenOrientation，now is ： %s", Boolean.valueOf(getDefaultSharedPreferences().getBoolean("settings_landscape_mode", false)));
            if (getDefaultSharedPreferences().getBoolean("settings_landscape_mode", false)) {
                setRequestedOrientation(-1);
            } else {
                setRequestedOrientation(1);
            }
            AppMethodBeat.o(74058);
            return true;
        } else if (str.equals("settings_voicerecorder_mode")) {
            if (!getDefaultSharedPreferences().getBoolean("settings_voicerecorder_mode", ae.gKu.gDI != 1)) {
                com.tencent.mm.ui.base.h.a(getContext(), (int) R.string.gwn, (int) R.string.zb, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.AnonymousClass8 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.AnonymousClass9 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(74051);
                        SettingsAboutSystemUI.this.getDefaultSharedPreferences().edit().putBoolean("settings_voicerecorder_mode", true).commit();
                        ((CheckBoxPreference) SettingsAboutSystemUI.this.screen.bmg("settings_voicerecorder_mode")).setChecked(true);
                        SettingsAboutSystemUI.this.screen.notifyDataSetChanged();
                        AppMethodBeat.o(74051);
                    }
                });
            }
            AppMethodBeat.o(74058);
            return true;
        } else if (str.equals("settings_nfc_switch")) {
            NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this);
            if (defaultAdapter == null) {
                Log.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-goTosetNfcSwitch phone not suppot nfc");
            } else {
                int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, (Object) 0)).intValue();
                int intValue2 = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_NFC_OPEN_DEFAULT_SWITCH_INT_SYNC, (Object) 0)).intValue();
                if ((intValue == 2 || (intValue == 0 && intValue2 != 1)) && !defaultAdapter.isEnabled() && getDefaultSharedPreferences().getBoolean("settings_nfc_switch", false)) {
                    ur(false);
                    com.tencent.mm.ui.base.h.c(getContext(), getString(R.string.fd3), "", getString(R.string.fd4), getString(R.string.sz), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.AnonymousClass6 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(74049);
                            Log.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-goTosetNfcSwitch user go set system nfc switch");
                            SettingsAboutSystemUI.this.DaE = true;
                            SettingsAboutSystemUI settingsAboutSystemUI = SettingsAboutSystemUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.NFC_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(settingsAboutSystemUI, bl.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            settingsAboutSystemUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(settingsAboutSystemUI, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$5", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(74049);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.AnonymousClass7 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(74050);
                            Log.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-goTosetNfcSwitch user cancel go set system nfc switch");
                            AppMethodBeat.o(74050);
                        }
                    });
                } else {
                    st(getDefaultSharedPreferences().getBoolean("settings_nfc_switch", false));
                }
            }
            AppMethodBeat.o(74058);
            return true;
        } else if (str.equals("settings_voice_play_mode")) {
            boolean booleanValue = ((Boolean) g.aAh().azQ().get(26, Boolean.FALSE)).booleanValue();
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(booleanValue);
            objArr[1] = Boolean.valueOf(!booleanValue);
            Log.d("MicroMsg.SettingsAboutSystemUI", "set voice mode from %B to %B", objArr);
            com.tencent.mm.storage.ao azQ = g.aAh().azQ();
            if (!booleanValue) {
                z4 = true;
            }
            azQ.set(26, Boolean.valueOf(z4));
            AppMethodBeat.o(74058);
            return true;
        } else if (str.equals("settings_enter_button_send")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.screen.bmg("settings_enter_button_send");
            if (checkBoxPreference != null) {
                boolean isChecked = checkBoxPreference.isChecked();
                Log.d("MicroMsg.SettingsAboutSystemUI", "set enter button send : %s", Boolean.valueOf(isChecked));
                g.aAh().azQ().set(66832, Boolean.valueOf(isChecked));
            }
            AppMethodBeat.o(74058);
            return true;
        } else if (str.equals("settings_sns_sight_auto_download")) {
            d.a aVar = new d.a(getContext());
            aVar.aoW(R.string.sz);
            aVar.aoO(R.string.guh);
            View inflate = View.inflate(getContext(), R.layout.b7l, null);
            final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.ifm);
            final int nullAs = Util.nullAs((Integer) g.aAh().azQ().get(327686, (Object) null), Util.getInt(com.tencent.mm.n.h.aqJ().getValue("SIGHTAutoLoadNetwork"), 1));
            View.OnClickListener r5 = new View.OnClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(74041);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    for (int i2 = 0; i2 < linearLayout.getChildCount(); i2++) {
                        TextView textView = (TextView) linearLayout.getChildAt(i2);
                        if (R.id.ipe != textView.getId()) {
                            textView.setCompoundDrawablesWithIntrinsicBounds(R.raw.radio_off, 0, 0, 0);
                        }
                    }
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(R.raw.radio_on, 0, 0, 0);
                    final int intValue = ((Integer) view.getTag()).intValue();
                    Log.i("MicroMsg.SettingsAboutSystemUI", "choice: %d, %d", Integer.valueOf(nullAs), Integer.valueOf(intValue));
                    if (nullAs == intValue) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(74041);
                        return;
                    }
                    view.post(new Runnable() {
                        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(74040);
                            ((Dialog) linearLayout.getTag()).dismiss();
                            g.aAh().azQ().set(327686, Integer.valueOf(intValue));
                            g.aAh().azQ().gBI();
                            SettingsAboutSystemUI.f(SettingsAboutSystemUI.this);
                            AppMethodBeat.o(74040);
                        }
                    });
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(74041);
                }
            };
            a(linearLayout, R.string.guf, 1, 1 == nullAs, r5);
            if (2 == nullAs) {
                z2 = true;
            } else {
                z2 = false;
            }
            a(linearLayout, R.string.gui, 2, z2, r5);
            if (3 == nullAs) {
                z3 = true;
            } else {
                z3 = false;
            }
            a(linearLayout, R.string.gug, 3, z3, r5);
            aVar.hs(inflate);
            com.tencent.mm.ui.widget.a.d hbn = aVar.hbn();
            linearLayout.setTag(hbn);
            hbn.show();
            addDialog(hbn);
            this.DaH = true;
            AppMethodBeat.o(74058);
            return true;
        } else if (str.equals("settings_silence_update_mode")) {
            d.a aVar2 = new d.a(getContext());
            aVar2.aoW(R.string.sz);
            aVar2.aoO(R.string.gu2);
            View inflate2 = View.inflate(getContext(), R.layout.b7l, null);
            final LinearLayout linearLayout2 = (LinearLayout) inflate2.findViewById(R.id.ifm);
            View.OnClickListener r52 = new View.OnClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.AnonymousClass10 */

                public final void onClick(View view) {
                    int i2;
                    boolean z = false;
                    AppMethodBeat.i(74053);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    for (int i3 = 0; i3 < linearLayout2.getChildCount(); i3++) {
                        TextView textView = (TextView) linearLayout2.getChildAt(i3);
                        if (R.id.ipe != textView.getId()) {
                            textView.setCompoundDrawablesWithIntrinsicBounds(R.raw.radio_off, 0, 0, 0);
                        }
                    }
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(R.raw.radio_on, 0, 0, 0);
                    int intValue = ((Integer) g.aAh().azQ().get(7, (Object) 0)).intValue();
                    int intValue2 = ((Integer) view.getTag()).intValue();
                    Log.d("MicroMsg.SettingsAboutSystemUI", "settings_silence_update_mode choice: %d", Integer.valueOf(intValue2));
                    if ((intValue2 == 0) == ((intValue & TPMediaCodecProfileLevel.HEVCMainTierLevel62) == 0)) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(74053);
                        return;
                    }
                    if (intValue2 == 0) {
                        z = true;
                    }
                    if (z) {
                        i2 = -16777217 & intValue;
                    } else {
                        i2 = intValue | TPMediaCodecProfileLevel.HEVCMainTierLevel62;
                    }
                    int i4 = !z ? 1 : 2;
                    g.aAh().azQ().set(7, Integer.valueOf(i2));
                    bfx bfx = new bfx();
                    bfx.LPB = 35;
                    bfx.BsD = i4;
                    ((l) g.af(l.class)).aSM().d(new k.a(23, bfx));
                    com.tencent.mm.plugin.setting.c.jRu.WZ();
                    view.post(new Runnable() {
                        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.AnonymousClass10.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(74052);
                            ((Dialog) linearLayout2.getTag()).dismiss();
                            SettingsAboutSystemUI.e(SettingsAboutSystemUI.this);
                            AppMethodBeat.o(74052);
                        }
                    });
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(74053);
                }
            };
            boolean z5 = (((Integer) g.aAh().azQ().get(7, 0)).intValue() & TPMediaCodecProfileLevel.HEVCMainTierLevel62) == 0;
            a(linearLayout2, R.string.gu4, 0, z5, r52);
            if (!z5) {
                z = true;
            } else {
                z = false;
            }
            a(linearLayout2, R.string.gu3, 1, z, r52);
            aVar2.hs(inflate2);
            com.tencent.mm.ui.widget.a.d hbn2 = aVar2.hbn();
            linearLayout2.setTag(hbn2);
            hbn2.show();
            addDialog(hbn2);
            AppMethodBeat.o(74058);
            return true;
        } else if (str.equals("settings_language")) {
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(getContext(), SettingsLanguageUI.class));
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetLanguage", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetLanguage", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(74058);
            return true;
        } else if (str.equals("settings_text_size")) {
            boolean eSV = eSV();
            AppMethodBeat.o(74058);
            return eSV;
        } else if (str.equals("settings_chatting_bg")) {
            Intent intent = new Intent();
            intent.setClass(this, SettingsChattingBackgroundUI.class);
            AppCompatActivity context = getContext();
            com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl2.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetChattingBackground", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl2.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetChattingBackground", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(74058);
            return true;
        } else if (str.equals("settings_manage_findmoreui")) {
            Intent intent2 = new Intent();
            intent2.setClass(this, SettingsManageFindMoreUI.class);
            com.tencent.mm.hellhoundlib.b.a bl3 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl3.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goToManageFindMoreUI", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl3.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goToManageFindMoreUI", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(74058);
            return true;
        } else if (str.equals("settings_plugins")) {
            g.aAh().azQ().set(-2046825377, Boolean.FALSE);
            Intent intent3 = new Intent();
            intent3.setClass(this, SettingsPluginsUI.class);
            com.tencent.mm.hellhoundlib.b.a bl4 = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl4.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetPlugins", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl4.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetPlugins", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.y.c.axV().cQ(262158, 266266);
            AppMethodBeat.o(74058);
            return true;
        } else if (str.equals("settings_reset")) {
            com.tencent.mm.ui.base.h.c(getContext(), getResources().getString(R.string.gtd), "", getString(R.string.t2), getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    List<Boolean> am;
                    AppMethodBeat.i(74048);
                    SettingsAboutSystemUI.this.isDeleteCancel = false;
                    SettingsAboutSystemUI settingsAboutSystemUI = SettingsAboutSystemUI.this;
                    SettingsAboutSystemUI settingsAboutSystemUI2 = SettingsAboutSystemUI.this;
                    SettingsAboutSystemUI.this.getString(R.string.zb);
                    settingsAboutSystemUI.Dav = com.tencent.mm.ui.base.h.a((Context) settingsAboutSystemUI2, SettingsAboutSystemUI.this.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.AnonymousClass5.AnonymousClass1 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(74045);
                            SettingsAboutSystemUI.this.isDeleteCancel = true;
                            AppMethodBeat.o(74045);
                        }
                    });
                    List<String> gCw = ((l) g.af(l.class)).aST().gCw();
                    if (gCw.size() > 0 && (am = u.am(gCw)) != null) {
                        for (int i3 = 0; i3 < am.size(); i3++) {
                            if (am.get(i3).booleanValue()) {
                                com.tencent.mm.plugin.setting.c.jRu.gr(gCw.get(i3));
                            }
                        }
                    }
                    bp.a(new bp.a() {
                        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.AnonymousClass5.AnonymousClass2 */

                        {
                            AppMethodBeat.i(161717);
                            AppMethodBeat.o(161717);
                        }

                        @Override // com.tencent.mm.model.bp.a
                        public final boolean amG() {
                            AppMethodBeat.i(74046);
                            boolean z = SettingsAboutSystemUI.this.isDeleteCancel;
                            AppMethodBeat.o(74046);
                            return z;
                        }

                        @Override // com.tencent.mm.model.bp.a
                        public final void amH() {
                            AppMethodBeat.i(74047);
                            if (SettingsAboutSystemUI.this.Dav != null) {
                                SettingsAboutSystemUI.this.Dav.dismiss();
                                SettingsAboutSystemUI.this.Dav = null;
                            }
                            AppMethodBeat.o(74047);
                        }
                    });
                    AppMethodBeat.o(74048);
                }
            }, null);
            AppMethodBeat.o(74058);
            return true;
        } else if (str.equals("settings_emoji_manager")) {
            Intent intent4 = new Intent();
            intent4.putExtra("10931", 2);
            c.b(getContext(), "emoji", ".ui.EmojiMineUI", intent4);
            AppMethodBeat.o(74058);
            return true;
        } else if (str.equals("settngs_clean")) {
            if (!g.aAh().isSDCardAvailable()) {
                com.tencent.mm.ui.base.u.g(getContext(), null);
                AppMethodBeat.o(74058);
                return true;
            }
            c.b(getContext(), "clean", ".ui.CleanUI", new Intent());
            AppMethodBeat.o(74058);
            return true;
        } else if (str.equals("settings_traffic_statistic")) {
            com.tencent.mm.hellhoundlib.b.a bl5 = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(this, SettingsNetStatUI.class));
            com.tencent.mm.hellhoundlib.a.a.a(this, bl5.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goToSetTrafficStatistic", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl5.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goToSetTrafficStatistic", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(74058);
            return true;
        } else if (str.equals("settings_text_size")) {
            boolean eSV2 = eSV();
            AppMethodBeat.o(74058);
            return eSV2;
        } else if (str.equals("settings_swipeback_mode")) {
            final CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) preference;
            final boolean apl = com.tencent.mm.compatible.h.b.apl();
            com.tencent.mm.ui.base.h.a(getContext(), getString(!apl ? R.string.gut : R.string.gus), (String) null, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(74043);
                    com.tencent.mm.compatible.h.b.du(!com.tencent.mm.compatible.h.b.apl());
                    g.aAi().releaseAll();
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.AnonymousClass3.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(74042);
                            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
                            Object obj = new Object();
                            com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$2$1", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                            Process.killProcess(((Integer) a2.pG(0)).intValue());
                            com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$2$1", "run", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                            AppMethodBeat.o(74042);
                        }
                    });
                    AppMethodBeat.o(74043);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(74044);
                    checkBoxPreference2.setChecked(apl);
                    SettingsAboutSystemUI.this.screen.notifyDataSetChanged();
                    AppMethodBeat.o(74044);
                }
            });
            AppMethodBeat.o(74058);
            return true;
        } else {
            if (str.equals("settings_take_photo")) {
                com.tencent.mm.hellhoundlib.b.a bl6 = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(this, SettingsAboutCamera.class));
                com.tencent.mm.hellhoundlib.a.a.a(this, bl6.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl6.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            } else if (str.equalsIgnoreCase("settngs_matrix_trace")) {
                if (!com.tencent.matrix.b.isInstalled()) {
                    Toast.makeText(this, "Matrix is never installed", 0).show();
                    AppMethodBeat.o(74058);
                    return false;
                }
                Intent intent5 = new Intent();
                intent5.setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.matrix.MatrixSettingUI");
                intent5.addFlags(67108864);
                com.tencent.mm.hellhoundlib.b.a bl7 = new com.tencent.mm.hellhoundlib.b.a().bl(intent5);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl7.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl7.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            } else if (str.equals("settings_dark")) {
                MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_red_dot", false);
                com.tencent.mm.hellhoundlib.b.a bl8 = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(this, SettingDarkMode.class));
                com.tencent.mm.hellhoundlib.a.a.a(this, bl8.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetDarkMode", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl8.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetDarkMode", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            AppMethodBeat.o(74058);
            return false;
        }
    }
}
