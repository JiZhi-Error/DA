package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.v;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.permission.d;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.vendor.MIUI;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.util.HashMap;
import java.util.Map;

public class SettingsNotificationUI extends MMPreference {
    private boolean Ddl = true;
    private boolean Ddm = true;
    private HashMap<Integer, Integer> kbt = new HashMap<>();
    private f screen;
    private int status;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingsNotificationUI() {
        AppMethodBeat.i(74293);
        AppMethodBeat.o(74293);
    }

    static /* synthetic */ void a(SettingsNotificationUI settingsNotificationUI, d dVar, String str) {
        AppMethodBeat.i(74302);
        settingsNotificationUI.a(dVar, str);
        AppMethodBeat.o(74302);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.cm;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74294);
        super.onCreate(bundle);
        this.status = z.aUc();
        this.Ddl = c.aZU("sns") && (z.aUl() & 32768) == 0;
        setMMTitle(R.string.gry);
        AppMethodBeat.o(74294);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        AppMethodBeat.i(74295);
        this.screen = getPreferenceScreen();
        this.screen.removeAll();
        this.screen.addPreferencesFromResource(getResourceId());
        if (com.tencent.mm.compatible.util.d.oD(26)) {
            this.screen.m38do("settings_notification_top", true);
            this.screen.m38do("settings_notification_title", false);
            this.screen.m38do("settings_notification_sound_shake", false);
            this.screen.m38do("settings_voip_sound_and_shake", false);
        } else {
            this.screen.m38do("settings_notification_top", false);
            this.screen.m38do("settings_notification_title", true);
            this.screen.m38do("settings_notification_sound_shake", true);
            this.screen.m38do("settings_voip_sound_and_shake", true);
        }
        if ((z.aUd() & 34359738368L) != 0) {
            z = true;
        } else {
            z = false;
        }
        boolean z5 = !z;
        f fVar = this.screen;
        if (!((aj) g.ah(aj.class)).showFinderEntry() || !z5) {
            z2 = true;
        } else {
            z2 = false;
        }
        fVar.m38do("settings_notification_finder", z2);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.screen.bmg("settings_notification_finder");
        checkBoxPreference.OZw = false;
        boolean daH = ((aj) g.ah(aj.class)).getRedDotManager().daH();
        Log.i("MicroMsg.SettingsNotificationUI", "settings_notification_finder : initState".concat(String.valueOf(daH)));
        checkBoxPreference.setChecked(daH);
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.screen.bmg("settings_new_msg_notification");
        if (com.tencent.mm.compatible.util.d.oD(26)) {
            if (!com.tencent.mm.n.g.apN() || !com.tencent.mm.n.g.apO()) {
                z3 = false;
            } else {
                z3 = true;
            }
            checkBoxPreference2.setChecked(z3);
        } else {
            checkBoxPreference2.setChecked(com.tencent.mm.n.g.apN());
        }
        ((CheckBoxPreference) this.screen.bmg("settings_new_voip_msg_notification")).setChecked(com.tencent.mm.n.g.apP());
        if (checkBoxPreference2.isChecked()) {
            if (com.tencent.mm.compatible.util.d.oD(26)) {
                this.screen.m38do("settings_notification_sound_and_shake", false);
                this.screen.m38do("settings_sound", true);
                this.screen.m38do("settings_shake", true);
                this.screen.m38do("settings_notification_ringtone", true);
                b.aqd();
                Log.i("MicroMsg.SettingsNotificationUI", "initView() mSpecialSceneSwitchEnable:%s", Integer.valueOf(b.aqc()));
                f fVar2 = this.screen;
                if (b.aqc() != 1) {
                    z4 = true;
                }
                fVar2.m38do("settings_special_scene_notification_sound_and_shake", z4);
            } else {
                CheckBoxPreference checkBoxPreference3 = (CheckBoxPreference) this.screen.bmg("settings_sound");
                checkBoxPreference3.setChecked(com.tencent.mm.n.g.apR());
                if (checkBoxPreference3.isChecked()) {
                    Preference bmg = this.screen.bmg("settings_notification_ringtone");
                    if (com.tencent.mm.compatible.util.d.oD(26)) {
                        String apX = com.tencent.mm.n.g.apX();
                        if (apX != com.tencent.mm.n.g.gLX) {
                            bmg.setSummary(RingtoneManager.getRingtone(this, Uri.parse(apX)).getTitle(this));
                        } else {
                            bmg.setSummary(getString(R.string.gs2));
                        }
                    } else if (bmg != null) {
                        bmg.setSummary(getDefaultSharedPreferences().getString("settings.ringtone.name", getString(R.string.gs2)));
                    }
                } else {
                    this.screen.bmi("settings_notification_ringtone");
                }
                ((CheckBoxPreference) this.screen.bmg("settings_shake")).setChecked(com.tencent.mm.n.g.apV());
                this.screen.m38do("settings_notification_sound_and_shake", true);
                this.screen.m38do("settings_special_scene_notification_title", true);
                this.screen.m38do("settings_specail_scene_sound", true);
                this.screen.m38do("settings_specail_scene_shake", true);
                this.screen.m38do("settings_special_scene_notification_sound_and_shake", true);
            }
            ((CheckBoxPreference) this.screen.bmg("settings_show_detail")).setChecked(com.tencent.mm.n.g.apQ());
        } else {
            this.screen.bmi("settings_show_detail");
            this.screen.bmi("settings_sound");
            this.screen.bmi("settings_notification_ringtone");
            this.screen.bmi("settings_shake");
            this.screen.bmi("settings_active_time");
            this.screen.bmi("settings_notification_sound_and_shake");
            this.screen.bmi("settings_special_scene_notification_sound_and_shake");
        }
        if (WeChatBrands.Business.Entries.MeSetNewMsgChannels.banned()) {
            this.screen.bmi("settings_notification_finder");
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74288);
                SettingsNotificationUI.this.hideVKB();
                SettingsNotificationUI.this.finish();
                AppMethodBeat.o(74288);
                return true;
            }
        });
        eTo();
        AppMethodBeat.o(74295);
    }

    private void eTo() {
        AppMethodBeat.i(256585);
        Log.i("MicroMsg.SettingsNotificationUI", "isSnsOpenEntrance " + this.Ddl + ", install " + c.aZU("sns") + ", flag " + ((z.aUl() & 32768) == 0));
        if (this.Ddl) {
            this.screen.m38do("settings_sns_notify", false);
        } else {
            this.screen.m38do("settings_sns_notify", true);
        }
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.screen.bmg("settings_sns_notify");
        if (checkBoxPreference != null) {
            checkBoxPreference.OZw = false;
            this.Ddm = Util.nullAs((Boolean) g.aAh().azQ().get(68384, (Object) null), true);
            if (this.Ddm) {
                checkBoxPreference.setChecked(true);
                AppMethodBeat.o(256585);
                return;
            }
            checkBoxPreference.setChecked(false);
        }
        AppMethodBeat.o(256585);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(74296);
        super.onPause();
        g.aAh().azQ().set(7, Integer.valueOf(this.status));
        for (Map.Entry<Integer, Integer> entry : this.kbt.entrySet()) {
            int intValue = entry.getKey().intValue();
            int intValue2 = entry.getValue().intValue();
            bfx bfx = new bfx();
            bfx.LPB = intValue;
            bfx.BsD = intValue2;
            ((l) g.af(l.class)).aSM().d(new k.a(23, bfx));
            Log.d("MicroMsg.SettingsNotificationUI", "switch  " + intValue + " " + intValue2);
        }
        this.kbt.clear();
        AppMethodBeat.o(74296);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(74297);
        super.onResume();
        initView();
        AppMethodBeat.o(74297);
    }

    private boolean eTp() {
        AppMethodBeat.i(256586);
        getDefaultSharedPreferences();
        this.Ddm = !this.Ddm;
        if (this.Ddm) {
            h.INSTANCE.a(14098, 3);
        } else {
            h.INSTANCE.a(14098, 4);
        }
        g.aAh().azQ().set(68384, Boolean.valueOf(this.Ddm));
        eTo();
        AppMethodBeat.o(256586);
        return true;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(74299);
        super.onDestroy();
        be.rY(3);
        AppMethodBeat.o(74299);
    }

    private void aNd(String str) {
        AppMethodBeat.i(74300);
        a(new d() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI.AnonymousClass5 */

            @Override // com.tencent.mm.pluginsdk.permission.d
            public final void Xq(int i2) {
            }
        }, str);
        AppMethodBeat.o(74300);
    }

    private void a(d dVar, String str) {
        AppMethodBeat.i(74301);
        Intent intent = new Intent();
        if (!com.tencent.mm.compatible.util.d.oD(26)) {
            if (com.tencent.mm.compatible.util.d.oD(21)) {
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("app_package", getPackageName());
                intent.putExtra("app_uid", getApplicationInfo().uid);
                intent.addFlags(268435456);
            } else {
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.fromParts("package", getPackageName(), null));
                intent.addFlags(268435456);
            }
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "openSysSetting", "(Lcom/tencent/mm/pluginsdk/permission/SettingsListener;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "openSysSetting", "(Lcom/tencent/mm/pluginsdk/permission/SettingsListener;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(74301);
        } else if (!MIUI.ifMIUI() || (MIUI.isMIUI10() && (!MIUI.isMIUI10() || MIUI.ifNotificationChannelSupportNativeActionJump()))) {
            Log.i("MicroMsg.SettingsNotificationUI", "openSysSetting() native notificationchannel jump");
            if (v.P(getContext()).areNotificationsEnabled()) {
                intent.setAction("android.settings.CHANNEL_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.CHANNEL_ID", str);
            } else {
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            }
            intent.putExtra("android.provider.extra.APP_PACKAGE", getPackageName());
            com.tencent.mm.pluginsdk.permission.b.a(intent, dVar);
            AppMethodBeat.o(74301);
        } else {
            Log.i("MicroMsg.SettingsNotificationUI", "openSysSetting() ifNotificationChannelSupportNativeActionJump = false");
            Intent intent2 = new Intent("android.intent.action.MAIN");
            intent2.setClassName("com.android.settings", "com.android.settings.Settings$NotificationFilterActivity");
            intent2.putExtra("appName", MMApplicationContext.getContext().getResources().getString(R.string.wx));
            intent2.putExtra(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME, getPackageName());
            com.tencent.mm.pluginsdk.permission.b.a(intent2, dVar);
            AppMethodBeat.o(74301);
        }
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        boolean z;
        AppMethodBeat.i(74298);
        String str = preference.mKey;
        if (str.equals("settings_new_msg_notification")) {
            if (!com.tencent.mm.compatible.util.d.oD(26) || com.tencent.mm.n.g.apO()) {
                com.tencent.mm.n.g.dA(((CheckBoxPreference) preference).isChecked());
                initView();
                if (((CheckBoxPreference) preference).isChecked()) {
                    h.INSTANCE.idkeyStat(500, 0, 1, false);
                } else {
                    h.INSTANCE.idkeyStat(500, 1, 1, false);
                }
                be.m(true, false);
                AppMethodBeat.o(74298);
                return true;
            }
            f.a aVar = new f.a(getContext());
            aVar.bow(getString(R.string.gln)).Dq(false);
            aVar.c(new f.c() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI.AnonymousClass2 */

                @Override // com.tencent.mm.ui.widget.a.f.c
                public final void e(boolean z, String str) {
                    AppMethodBeat.i(74290);
                    if (z) {
                        SettingsNotificationUI.a(SettingsNotificationUI.this, new d() {
                            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI.AnonymousClass2.AnonymousClass1 */

                            @Override // com.tencent.mm.pluginsdk.permission.d
                            public final void Xq(int i2) {
                                AppMethodBeat.i(74289);
                                if (!com.tencent.mm.n.g.apO()) {
                                    SettingsNotificationUI.this.initView();
                                    AppMethodBeat.o(74289);
                                    return;
                                }
                                com.tencent.mm.n.g.dA(true);
                                SettingsNotificationUI.this.initView();
                                h.INSTANCE.idkeyStat(500, 0, 1, false);
                                be.m(true, false);
                                AppMethodBeat.o(74289);
                            }
                        }, com.tencent.mm.bq.a.apJ());
                        AppMethodBeat.o(74290);
                        return;
                    }
                    SettingsNotificationUI.this.initView();
                    AppMethodBeat.o(74290);
                }
            }).show();
        } else if (str.equals("settings_sns_notify")) {
            boolean eTp = eTp();
            AppMethodBeat.o(74298);
            return eTp;
        } else if (str.equals("settings_notification_finder")) {
            boolean isChecked = ((CheckBoxPreference) preference).isChecked();
            Log.i("MicroMsg.SettingsNotificationUI", "settings_notification_finder isEnable=%s", Boolean.valueOf(isChecked));
            ((aj) g.ah(aj.class)).getRedDotManager().mS(isChecked);
        } else if (str.equals("settings_new_voip_msg_notification")) {
            if (!((CheckBoxPreference) preference).isChecked()) {
                com.tencent.mm.ui.base.h.a(getContext(), false, getContext().getString(R.string.gru), "", getContext().getString(R.string.grt), getContext().getString(R.string.gpw), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(74291);
                        com.tencent.mm.n.g.dB(false);
                        ca caVar = new ca();
                        caVar.nv(2);
                        caVar.setCreateTime(System.currentTimeMillis());
                        caVar.setType(1);
                        caVar.Cy("weixin");
                        caVar.setContent(SettingsNotificationUI.this.getContext().getString(R.string.grw, new Object[]{Build.MODEL}));
                        bp.x(caVar);
                        az bjY = ((l) g.af(l.class)).aST().bjY("weixin");
                        if (bjY != null) {
                            bjY.setContent(SettingsNotificationUI.this.getContext().getString(R.string.grw, new Object[]{Build.MODEL}));
                            bjY.nt(bjY.field_unReadCount + 1);
                            ((l) g.af(l.class)).aST().a(bjY, "weixin");
                        } else {
                            az azVar = new az();
                            azVar.setContent(SettingsNotificationUI.this.getContext().getString(R.string.grw, new Object[]{Build.MODEL}));
                            azVar.setUsername("weixin");
                            azVar.nt(1);
                            ((l) g.af(l.class)).aST().e(azVar);
                        }
                        SettingsNotificationUI.this.initView();
                        h.INSTANCE.idkeyStat(500, 3, 1, false);
                        be.m(false, true);
                        AppMethodBeat.o(74291);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI.AnonymousClass4 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(74292);
                        com.tencent.mm.n.g.dB(true);
                        ((CheckBoxPreference) SettingsNotificationUI.this.screen.bmg("settings_new_voip_msg_notification")).setChecked(true);
                        SettingsNotificationUI.this.initView();
                        be.m(false, true);
                        AppMethodBeat.o(74292);
                    }
                }, R.color.cd, 0);
            } else {
                com.tencent.mm.n.g.dB(true);
                h.INSTANCE.idkeyStat(500, 2, 1, false);
                be.m(false, true);
                initView();
            }
            AppMethodBeat.o(74298);
            return true;
        }
        if (str.equals("settings_voip_notification_sound")) {
            boolean isChecked2 = ((CheckBoxPreference) preference).isChecked();
            g.aAh().azQ().set(73217, Boolean.valueOf(isChecked2));
            g.aAh().azQ().set(73218, Boolean.valueOf(isChecked2));
            h.INSTANCE.idkeyStat(500, isChecked2 ? 8 : 9, 1, false);
            Log.i("MicroMsg.SettingsNotificationUI", "void sound checkbox %b", Boolean.valueOf(isChecked2));
            AppMethodBeat.o(74298);
            return true;
        } else if (str.equals("settings_sound")) {
            com.tencent.mm.n.g.dD(((CheckBoxPreference) preference).isChecked());
            initView();
            if (((CheckBoxPreference) preference).isChecked()) {
                h.INSTANCE.idkeyStat(500, 10, 1, false);
            } else {
                h.INSTANCE.idkeyStat(500, 11, 1, false);
            }
            AppMethodBeat.o(74298);
            return true;
        } else if (str.equals("settings_shake")) {
            com.tencent.mm.n.g.dE(((CheckBoxPreference) preference).isChecked());
            initView();
            if (((CheckBoxPreference) preference).isChecked()) {
                h.INSTANCE.idkeyStat(500, 16, 1, false);
            } else {
                h.INSTANCE.idkeyStat(500, 17, 1, false);
            }
            Util.shake(this, ((CheckBoxPreference) preference).isChecked());
            AppMethodBeat.o(74298);
            return true;
        } else if (str.equals("settings_show_detail")) {
            boolean isChecked3 = ((CheckBoxPreference) preference).isChecked();
            com.tencent.mm.n.g.dC(isChecked3);
            if (!isChecked3) {
                z = true;
            } else {
                z = false;
            }
            Log.d("MicroMsg.SettingsNotificationUI", "switch change : open = " + z + " item value = 2048 functionId = 10");
            if (z) {
                this.status |= 2048;
            } else {
                this.status &= -2049;
            }
            this.kbt.put(10, Integer.valueOf(z ? 1 : 2));
            AppMethodBeat.o(74298);
            return true;
        } else if (str.equals("settings_notification_ringtone")) {
            a bl = new a().bl(new Intent(getContext(), SettingsRingtoneUI.class));
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "setRingtone", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "setRingtone", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(74298);
            return true;
        } else if (str.equals("settings_notification_sound_and_shake")) {
            aNd(com.tencent.mm.bq.a.apJ());
            AppMethodBeat.o(74298);
            return true;
        } else if (str.equals("settings_special_scene_notification_sound_and_shake")) {
            Intent intent = new Intent();
            intent.setClass(this, SettingsSpecialSceneNotificationUI.class);
            a bl2 = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl2.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "goSettingsSpecialSceneNotificationUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl2.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "goSettingsSpecialSceneNotificationUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(74298);
            return true;
        } else if (str.equals("settings_voip_sound_and_shake")) {
            if (com.tencent.mm.compatible.util.d.oF(28) || Build.VERSION.CODENAME.equals("Q")) {
                aNd(com.tencent.mm.bq.a.glD());
            } else {
                Intent intent2 = new Intent();
                intent2.setClass(this, SettingsVoipSoundVibrateUI.class);
                a bl3 = new a().bl(intent2);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl3.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "goSettingsVoipSoundVibrateUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl3.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsNotificationUI", "goSettingsVoipSoundVibrateUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            AppMethodBeat.o(74298);
            return true;
        } else {
            AppMethodBeat.o(74298);
            return false;
        }
    }
}
