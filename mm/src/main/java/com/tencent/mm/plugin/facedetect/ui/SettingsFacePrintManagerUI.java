package com.tencent.mm.plugin.facedetect.ui;

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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.facedetect.b.q;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsFacePrintManagerUI extends MMPreference implements i {
    private ProgressDialog gtM = null;
    private View lJI;
    private FaceHeaderPreference sUm;
    private boolean sUn = false;
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(104050);
        super.onCreate(bundle);
        setMMTitle(R.string.c62);
        g.azz().a(d.CTRL_INDEX, this);
        this.lJI = findViewById(R.id.ffz);
        initView();
        this.lJI.setBackgroundResource(R.color.afz);
        p.aj(this);
        AppMethodBeat.o(104050);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(104051);
        super.onResume();
        if (this.sUn) {
            this.sUn = false;
            if (this.gtM != null && this.gtM.isShowing()) {
                this.gtM.dismiss();
            }
            AppCompatActivity context = getContext();
            getString(R.string.zb);
            this.gtM = h.a((Context) context, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.facedetect.ui.SettingsFacePrintManagerUI.AnonymousClass1 */

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            Log.d("MicroMsg.FaceSettingsManagerUI", "hy: resume after create face, get switch status");
            g.azz().a(new q(1), 0);
        }
        AppMethodBeat.o(104051);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(104052);
        super.onDestroy();
        g.azz().b(d.CTRL_INDEX, this);
        if (this.gtM != null) {
            this.gtM.dismiss();
        }
        AppMethodBeat.o(104052);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(104053);
        int nullAsInt = Util.nullAsInt(g.aAh().azQ().get(40, (Object) 0), 0);
        Log.i("MicroMsg.FaceSettingsManagerUI", "plugSwitch " + nullAsInt + " " + (nullAsInt & 4194304));
        this.screen = getPreferenceScreen();
        this.sUm = (FaceHeaderPreference) this.screen.bmg("settings_faceprint_header");
        ((CheckBoxPreference) this.screen.bmg("settings_faceprint_title")).xZ(true);
        this.screen.notifyDataSetChanged();
        if (this.gtM != null && this.gtM.isShowing()) {
            this.gtM.dismiss();
        }
        AppCompatActivity context = getContext();
        getString(R.string.zb);
        this.gtM = h.a((Context) context, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.facedetect.ui.SettingsFacePrintManagerUI.AnonymousClass2 */

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        g.azz().a(new q(3), 0);
        this.screen.m38do("settings_faceprint_create", true);
        this.screen.m38do("settings_faceeprint_reset", true);
        this.screen.m38do("settings_faceprint_unlock", true);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.facedetect.ui.SettingsFacePrintManagerUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(104048);
                SettingsFacePrintManagerUI.this.finish();
                AppMethodBeat.o(104048);
                return true;
            }
        });
        AppMethodBeat.o(104053);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.cb;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        int i4;
        AppMethodBeat.i(104055);
        Log.d("MicroMsg.FaceSettingsManagerUI", "hy: onSceneEnd, errType:%d, errCode:%d, sceneType:%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(qVar.getType()));
        if (i2 == 0 || i3 == 0) {
            if (qVar.getType() == 938) {
                q qVar2 = (q) qVar;
                if (qVar2.sQf) {
                    Log.d("MicroMsg.FaceSettingsManagerUI", "faceprint exist");
                    this.screen.m38do("settings_faceprint_unlock", false);
                    this.screen.notifyDataSetChanged();
                    int aUe = z.aUe();
                    CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.screen.bmg("settings_faceprint_title");
                    Log.d("MicroMsg.FaceSettingsManagerUI", "opScene.isOpenSwitch:%b", Boolean.valueOf(qVar2.sQg));
                    if (qVar2.sQg) {
                        Log.d("MicroMsg.FaceSettingsManagerUI", "hy: faceprint open");
                        checkBoxPreference.xZ(true);
                        this.screen.m38do("settings_faceeprint_reset", false);
                        this.screen.m38do("settings_faceprint_unlock", false);
                        i4 = 4194304 | aUe;
                        this.sUm.gD(getString(R.string.goq), "");
                    } else {
                        Log.d("MicroMsg.FaceSettingsManagerUI", "hy: faceprint close");
                        checkBoxPreference.xZ(false);
                        this.screen.m38do("settings_faceeprint_reset", true);
                        this.screen.m38do("settings_faceprint_unlock", true);
                        i4 = -4194305 & aUe;
                        this.sUm.gD(getString(R.string.gop), "");
                    }
                    Log.i("MicroMsg.FaceSettingsManagerUI", "scene end plugSwitch %d", Integer.valueOf(i4));
                    bf.iDu.aO("last_login_use_voice", String.valueOf(i4));
                    g.aAh().azQ().set(40, Integer.valueOf(i4));
                    this.screen.m38do("settings_faceprint_create", true);
                    this.screen.m38do("settings_faceprint_title", false);
                    this.sUm.b(null);
                    this.screen.notifyDataSetChanged();
                } else {
                    Log.d("MicroMsg.FaceSettingsManagerUI", "faceprint not exist");
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11390, 2);
                    this.screen.m38do("settings_faceprint_create", true);
                    this.screen.m38do("settings_faceprint_title", true);
                    this.screen.m38do("settings_faceprint_unlock", true);
                    this.screen.m38do("settings_faceeprint_reset", true);
                    this.sUm.setTitle(getString(R.string.gol));
                    this.sUm.b(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.facedetect.ui.SettingsFacePrintManagerUI.AnonymousClass5 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(104049);
                            b bVar = new b();
                            bVar.bm(view);
                            a.b("com/tencent/mm/plugin/facedetect/ui/SettingsFacePrintManagerUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            SettingsFacePrintManagerUI.a(SettingsFacePrintManagerUI.this);
                            a.a(this, "com/tencent/mm/plugin/facedetect/ui/SettingsFacePrintManagerUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(104049);
                        }
                    });
                    this.screen.notifyDataSetChanged();
                }
            }
            if (this.gtM != null) {
                this.gtM.dismiss();
            }
            AppMethodBeat.o(104055);
            return;
        }
        this.screen.m38do("settings_faceprint_create", true);
        this.screen.m38do("settings_faceprint_unlock", true);
        this.screen.m38do("settings_faceeprint_reset", true);
        ((CheckBoxPreference) this.screen.bmg("settings_faceprint_title")).xZ(false);
        this.sUm.setTitle(getString(R.string.gop));
        this.screen.notifyDataSetChanged();
        if (this.gtM != null) {
            this.gtM.dismiss();
        }
        AppMethodBeat.o(104055);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(104056);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1) {
            if (intent != null && intent.getIntExtra("err_code", 10) == 0) {
                this.sUn = true;
            }
            Log.i("MicroMsg.FaceSettingsManagerUI", "hy: is reg ok: %b", Boolean.valueOf(this.sUn));
        }
        AppMethodBeat.o(104056);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(104057);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.FaceSettingsManagerUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(104057);
            return;
        }
        Log.i("MicroMsg.FaceSettingsManagerUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case 23:
                if (!(iArr[0] == 0 && iArr[1] == 0)) {
                    Log.w("MicroMsg.FaceSettingsManagerUI", "hy: permission not granted");
                    finish();
                    break;
                }
        }
        AppMethodBeat.o(104057);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(104054);
        String str = preference.mKey;
        Intent intent = new Intent();
        if (str.equals("settings_faceprint_title")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) fVar.bmg("settings_faceprint_title");
            Log.d("MicroMsg.FaceSettingsManagerUI", "hy: checkPref.isChecked() " + checkBoxPreference.isChecked());
            if (this.gtM != null && this.gtM.isShowing()) {
                this.gtM.dismiss();
            }
            AppCompatActivity context = getContext();
            getString(R.string.zb);
            this.gtM = h.a((Context) context, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.facedetect.ui.SettingsFacePrintManagerUI.AnonymousClass4 */

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            if (checkBoxPreference.isChecked()) {
                g.azz().a(new q(1), 0);
            } else {
                g.azz().a(new q(2), 0);
            }
            AppMethodBeat.o(104054);
            return true;
        } else if (str.equals("settings_faceprint_unlock")) {
            intent.setClass(this, FaceDetectUI.class);
            intent.putExtra("k_need_signature", true);
            intent.putExtra("k_user_name", z.aUb());
            intent.putExtra("k_purpose", 2);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            a.a(this, bl.axQ(), "com/tencent/mm/plugin/facedetect/ui/SettingsFacePrintManagerUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            a.a(this, "com/tencent/mm/plugin/facedetect/ui/SettingsFacePrintManagerUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(104054);
            return true;
        } else if (str.equals("settings_faceeprint_reset")) {
            intent.setClass(this, FaceDetectUI.class);
            intent.putExtra("k_need_signature", true);
            intent.putExtra("k_user_name", z.aUb());
            intent.putExtra("k_purpose", 1);
            startActivityForResult(intent, 1);
            AppMethodBeat.o(104054);
            return true;
        } else {
            AppMethodBeat.o(104054);
            return false;
        }
    }

    static /* synthetic */ void a(SettingsFacePrintManagerUI settingsFacePrintManagerUI) {
        AppMethodBeat.i(104058);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11390, 3);
        Intent intent = new Intent();
        intent.setClass(settingsFacePrintManagerUI, FaceDetectUI.class);
        intent.putExtra("k_need_signature", true);
        intent.putExtra("k_user_name", z.aUb());
        intent.putExtra("k_purpose", 1);
        settingsFacePrintManagerUI.startActivityForResult(intent, 1);
        settingsFacePrintManagerUI.sUn = false;
        AppMethodBeat.o(104058);
    }
}
