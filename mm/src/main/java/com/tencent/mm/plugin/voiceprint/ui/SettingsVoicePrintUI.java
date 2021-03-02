package com.tencent.mm.plugin.voiceprint.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.qqmusic.mediaplayer.PlayerException;

public class SettingsVoicePrintUI extends MMPreference implements i {
    private VoiceHeaderPreference GRQ;
    private ProgressDialog gtM = null;
    private View lJI;
    private boolean sUn = false;
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(SettingsVoicePrintUI settingsVoicePrintUI) {
        AppMethodBeat.i(29840);
        settingsVoicePrintUI.fEP();
        AppMethodBeat.o(29840);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29831);
        super.onCreate(bundle);
        setMMTitle(R.string.gwe);
        bg.azz().a(615, this);
        this.lJI = findViewById(R.id.ffz);
        initView();
        this.lJI.setBackgroundResource(R.color.afz);
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_VOICEPRINT_MORE_TAB_DOT_SHOW_BOOLEAN, Boolean.FALSE);
        bg.aVF();
        c.azQ().set(ar.a.USERFINO_VOICEPRINT_SETTING_DOT_SHOW_BOOLEAN, Boolean.FALSE);
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_VOICEPRINT_SETTING_ACCOUNT_INFO_DOT_SHOW_BOOLEAN, Boolean.FALSE);
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_VOICEPRINT_SETTING_ACCOUNT_INFO_NEW_SHOW_BOOLEAN, Boolean.FALSE);
        Log.i("MicroMsg.VoiceSettingsUI", "unset all voiceprint config");
        AppMethodBeat.o(29831);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(29832);
        super.onResume();
        if (this.sUn) {
            this.sUn = false;
            if (this.gtM != null && this.gtM.isShowing()) {
                this.gtM.dismiss();
            }
            AppCompatActivity context = getContext();
            getString(R.string.zb);
            this.gtM = h.a((Context) context, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI.AnonymousClass1 */

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            Log.d("MicroMsg.VoiceSettingsUI", "resume after create voiceprint, get switch status");
            bg.azz().a(new com.tencent.mm.plugin.voiceprint.model.i(1), 0);
        }
        AppMethodBeat.o(29832);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(29833);
        super.onDestroy();
        bg.azz().b(615, this);
        if (this.gtM != null) {
            this.gtM.dismiss();
        }
        AppMethodBeat.o(29833);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(29834);
        bg.aVF();
        int nullAsInt = Util.nullAsInt(c.azQ().get(40, (Object) 0), 0);
        Log.i("MicroMsg.VoiceSettingsUI", "plugSwitch " + nullAsInt + " " + (nullAsInt & 131072));
        this.screen = getPreferenceScreen();
        this.GRQ = (VoiceHeaderPreference) this.screen.bmg("settings_voiceprint_header");
        ((CheckBoxPreference) this.screen.bmg("settings_voiceprint_title")).xZ(true);
        this.screen.notifyDataSetChanged();
        if (this.gtM != null && this.gtM.isShowing()) {
            this.gtM.dismiss();
        }
        AppCompatActivity context = getContext();
        getString(R.string.zb);
        this.gtM = h.a((Context) context, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI.AnonymousClass2 */

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        bg.azz().a(new com.tencent.mm.plugin.voiceprint.model.i(0), 0);
        this.screen.m38do("settings_voiceprint_unlock", true);
        this.screen.m38do("settings_voiceprint_reset", true);
        this.screen.m38do("settings_voiceprint_create", true);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(29827);
                SettingsVoicePrintUI.this.finish();
                AppMethodBeat.o(29827);
                return true;
            }
        });
        AppMethodBeat.o(29834);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.cw;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        int i4;
        AppMethodBeat.i(29836);
        Log.d("MicroMsg.VoiceSettingsUI", "onSceneEnd, errType:%d, errCode:%d, sceneType:%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(qVar.getType()));
        if (i2 == 0 || i3 == 0) {
            if (qVar.getType() == 615) {
                com.tencent.mm.plugin.voiceprint.model.i iVar = (com.tencent.mm.plugin.voiceprint.model.i) qVar;
                if (iVar.mStatus == 1) {
                    Log.d("MicroMsg.VoiceSettingsUI", "voiceprint exist");
                    this.screen.m38do("settings_voiceprint_unlock", false);
                    this.screen.notifyDataSetChanged();
                    int aUe = z.aUe();
                    CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.screen.bmg("settings_voiceprint_title");
                    Log.d("MicroMsg.VoiceSettingsUI", "opScene.getSwitch:%d", Integer.valueOf(iVar.GQZ));
                    if (iVar.GQZ > 0) {
                        Log.d("MicroMsg.VoiceSettingsUI", "voiceprint open");
                        checkBoxPreference.xZ(true);
                        this.screen.m38do("settings_voiceprint_reset", false);
                        this.screen.m38do("settings_voiceprint_unlock", false);
                        i4 = 131072 | aUe;
                        this.GRQ.gD(getString(R.string.i0c), "");
                    } else {
                        Log.d("MicroMsg.VoiceSettingsUI", "voiceprint close");
                        checkBoxPreference.xZ(false);
                        this.screen.m38do("settings_voiceprint_reset", true);
                        this.screen.m38do("settings_voiceprint_unlock", true);
                        i4 = -131073 & aUe;
                        this.GRQ.gD(getString(R.string.i0a), "");
                    }
                    Log.i("MicroMsg.VoiceSettingsUI", "scene end plugSwitch %d", Integer.valueOf(i4));
                    bf.iDu.aO("last_login_use_voice", String.valueOf(i4));
                    bg.aVF();
                    c.azQ().set(40, Integer.valueOf(i4));
                    this.screen.m38do("settings_voiceprint_create", true);
                    this.screen.m38do("settings_voiceprint_title", false);
                    this.GRQ.b(null);
                    this.screen.notifyDataSetChanged();
                } else {
                    Log.d("MicroMsg.VoiceSettingsUI", "voiceprint not exist");
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11390, 2);
                    this.screen.m38do("settings_voiceprint_unlock", true);
                    this.screen.m38do("settings_voiceprint_reset", true);
                    this.screen.m38do("settings_voiceprint_create", true);
                    this.screen.m38do("settings_voiceprint_title", true);
                    this.GRQ.gD(getString(R.string.i0e), getString(R.string.i0d));
                    this.GRQ.b(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI.AnonymousClass5 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(29828);
                            b bVar = new b();
                            bVar.bm(view);
                            a.b("com/tencent/mm/plugin/voiceprint/ui/SettingsVoicePrintUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(SettingsVoicePrintUI.this, "android.permission.RECORD_AUDIO", 80, "", "");
                            Log.i("MicroMsg.VoiceSettingsUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), SettingsVoicePrintUI.this);
                            if (!a2) {
                                a.a(this, "com/tencent/mm/plugin/voiceprint/ui/SettingsVoicePrintUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(29828);
                                return;
                            }
                            SettingsVoicePrintUI.a(SettingsVoicePrintUI.this);
                            a.a(this, "com/tencent/mm/plugin/voiceprint/ui/SettingsVoicePrintUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(29828);
                        }
                    });
                    this.screen.notifyDataSetChanged();
                }
            }
            if (this.gtM != null) {
                this.gtM.dismiss();
            }
            AppMethodBeat.o(29836);
            return;
        }
        this.screen.m38do("settings_voiceprint_unlock", true);
        this.screen.m38do("settings_voiceprint_reset", true);
        this.screen.m38do("settings_voiceprint_create", true);
        ((CheckBoxPreference) this.screen.bmg("settings_voiceprint_title")).xZ(false);
        this.GRQ.gD(getString(R.string.i0a), "");
        this.screen.notifyDataSetChanged();
        if (this.gtM != null) {
            this.gtM.dismiss();
        }
        AppMethodBeat.o(29836);
    }

    private void fEP() {
        AppMethodBeat.i(29837);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11390, 3);
        Intent intent = new Intent();
        intent.setClass(this, VoiceCreateUI.class);
        intent.putExtra("kscene_type", 71);
        intent.putExtra("createVoicePrint", true);
        startActivityForResult(intent, 1);
        this.sUn = false;
        AppMethodBeat.o(29837);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(29838);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && intent != null) {
            this.sUn = intent.getBooleanExtra("KIsCreateSuccess", false);
        }
        AppMethodBeat.o(29838);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(29839);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.VoiceSettingsUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(29839);
            return;
        }
        Log.i("MicroMsg.VoiceSettingsUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.flb), getString(R.string.flp), getString(R.string.e_k), getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI.AnonymousClass6 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(29829);
                            dialogInterface.dismiss();
                            SettingsVoicePrintUI settingsVoicePrintUI = SettingsVoicePrintUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            a.a(settingsVoicePrintUI, bl.axQ(), "com/tencent/mm/plugin/voiceprint/ui/SettingsVoicePrintUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            settingsVoicePrintUI.startActivity((Intent) bl.pG(0));
                            a.a(settingsVoicePrintUI, "com/tencent/mm/plugin/voiceprint/ui/SettingsVoicePrintUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(29829);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI.AnonymousClass7 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(29830);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(29830);
                        }
                    });
                    break;
                } else {
                    fEP();
                    AppMethodBeat.o(29839);
                    return;
                }
        }
        AppMethodBeat.o(29839);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(29835);
        String str = preference.mKey;
        Intent intent = new Intent();
        if (str.equals("settings_voiceprint_title")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) fVar.bmg("settings_voiceprint_title");
            Log.d("MicroMsg.VoiceSettingsUI", "checkPref.isChecked() " + checkBoxPreference.isChecked());
            if (this.gtM != null && this.gtM.isShowing()) {
                this.gtM.dismiss();
            }
            AppCompatActivity context = getContext();
            getString(R.string.zb);
            this.gtM = h.a((Context) context, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI.AnonymousClass4 */

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            if (checkBoxPreference.isChecked()) {
                bg.azz().a(new com.tencent.mm.plugin.voiceprint.model.i(1), 0);
            } else {
                bg.azz().a(new com.tencent.mm.plugin.voiceprint.model.i(2), 0);
            }
            AppMethodBeat.o(29835);
            return true;
        } else if (str.equals("settings_voiceprint_unlock")) {
            intent.setClass(this, VoiceUnLockUI.class);
            intent.putExtra("kscene_type", 73);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            a.a(this, bl.axQ(), "com/tencent/mm/plugin/voiceprint/ui/SettingsVoicePrintUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            a.a(this, "com/tencent/mm/plugin/voiceprint/ui/SettingsVoicePrintUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(29835);
            return true;
        } else if (str.equals("settings_voiceprint_reset")) {
            intent.setClass(this, VoiceCreateUI.class);
            intent.putExtra("KvoicePrintReset", true);
            intent.putExtra("kscene_type", 73);
            startActivityForResult(intent, 1);
            AppMethodBeat.o(29835);
            return true;
        } else {
            AppMethodBeat.o(29835);
            return false;
        }
    }
}
