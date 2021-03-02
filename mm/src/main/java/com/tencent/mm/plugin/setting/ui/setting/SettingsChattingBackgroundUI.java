package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bb.b;
import com.tencent.mm.bb.r;
import com.tencent.mm.bb.v;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.tools.a;

public class SettingsChattingBackgroundUI extends MMPreference {
    private boolean Dbz;
    private f screen;
    private String username;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.ca;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74130);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(74130);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(74131);
        super.onDestroy();
        AppMethodBeat.o(74131);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(74132);
        super.onActivityResult(i2, i3, intent);
        switch (i2) {
            case 1:
                if (intent == null) {
                    AppMethodBeat.o(74132);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 2);
                intent2.putExtra("CropImage_bg_vertical", ut(true));
                intent2.putExtra("CropImage_bg_horizontal", ut(false));
                c.jRt.a(this, intent, intent2, d.aSY(), 4, (a.AbstractC2129a) null);
                AppMethodBeat.o(74132);
                return;
            case 2:
                String h2 = s.h(getApplicationContext(), intent, d.aSY());
                if (h2 == null) {
                    AppMethodBeat.o(74132);
                    return;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("CropImageMode", 2);
                intent3.putExtra("CropImage_ImgPath", h2);
                intent3.putExtra("CropImage_bg_vertical", ut(true));
                intent3.putExtra("CropImage_bg_horizontal", ut(false));
                c.jRt.a(this, intent3, 4);
                AppMethodBeat.o(74132);
                return;
            case 3:
                if (i3 != -1) {
                    AppMethodBeat.o(74132);
                    return;
                }
                break;
            case 4:
                if (i3 == -1) {
                    g.aAh().azQ().set(66820, (Object) -1);
                    h.INSTANCE.a(10198, -1);
                    Log.i("MicroMsg.SettingsChattingBackgroundUI", "set chating bg id:%d", -1);
                    if (!this.Dbz) {
                        b bew = v.bew();
                        com.tencent.mm.bb.a Pp = bew.Pp(this.username);
                        if (Pp != null) {
                            Pp.jgE = -1;
                            bew.b(Pp);
                            break;
                        } else {
                            com.tencent.mm.bb.a aVar = new com.tencent.mm.bb.a();
                            aVar.username = this.username;
                            aVar.jgE = -1;
                            bew.a(aVar);
                            break;
                        }
                    } else {
                        g.aAh().azQ().set(12311, (Object) -1);
                        v.bev().tH(1);
                        break;
                    }
                }
                break;
        }
        if (!this.Dbz) {
            setResult(-1);
            finish();
        }
        AppMethodBeat.o(74132);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        Preference bmg;
        AppMethodBeat.i(74133);
        setMMTitle(R.string.go0);
        this.screen = getPreferenceScreen();
        this.Dbz = getIntent().getBooleanExtra("isApplyToAll", true);
        if (!this.Dbz && (bmg = this.screen.bmg("settings_chatting_bg_apply_to_all")) != null) {
            this.screen.e(bmg);
        }
        this.username = getIntent().getStringExtra(ch.COL_USERNAME);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsChattingBackgroundUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74127);
                SettingsChattingBackgroundUI.this.hideVKB();
                SettingsChattingBackgroundUI.this.finish();
                AppMethodBeat.o(74127);
                return true;
            }
        });
        AppMethodBeat.o(74133);
    }

    private void dRW() {
        AppMethodBeat.i(74135);
        if (!s.d(this, com.tencent.mm.loader.j.b.aKV(), "microMsg." + System.currentTimeMillis() + ".jpg", 2)) {
            Toast.makeText(this, getString(R.string.gix), 1).show();
        }
        AppMethodBeat.o(74135);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(74136);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.SettingsChattingBackgroundUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(74136);
            return;
        }
        Log.i("MicroMsg.SettingsChattingBackgroundUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case 16:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.fl0), getString(R.string.flp), getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsChattingBackgroundUI.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(74128);
                            SettingsChattingBackgroundUI settingsChattingBackgroundUI = SettingsChattingBackgroundUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(settingsChattingBackgroundUI, bl.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsChattingBackgroundUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            settingsChattingBackgroundUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(settingsChattingBackgroundUI, "com/tencent/mm/plugin/setting/ui/setting/SettingsChattingBackgroundUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(74128);
                        }
                    }, (DialogInterface.OnClickListener) null);
                    break;
                } else {
                    dRW();
                    AppMethodBeat.o(74136);
                    return;
                }
        }
        AppMethodBeat.o(74136);
    }

    private String ut(boolean z) {
        AppMethodBeat.i(74137);
        v.bev();
        if (this.Dbz) {
            String T = r.T(BuildConfig.KINDA_DEFAULT, z);
            AppMethodBeat.o(74137);
            return T;
        }
        String T2 = r.T(this.username, z);
        AppMethodBeat.o(74137);
        return T2;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(74134);
        String str = preference.mKey;
        Log.i("MicroMsg.SettingsChattingBackgroundUI", str + " item has been clicked!");
        if (str.equals("settings_chatting_bg_select_bg")) {
            Intent intent = new Intent();
            intent.setClass(this, SettingsSelectBgUI.class);
            intent.putExtra("isApplyToAll", this.Dbz);
            intent.putExtra(ch.COL_USERNAME, this.username);
            startActivityForResult(intent, 3);
            AppMethodBeat.o(74134);
            return true;
        } else if (str.equals("settings_chatting_bg_select_from_album")) {
            s.c(this, 1, null);
            AppMethodBeat.o(74134);
            return true;
        } else if (str.equals("settings_chatting_bg_take_photo")) {
            boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(getContext(), "android.permission.CAMERA", 16, "", "");
            Log.i("MicroMsg.SettingsChattingBackgroundUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), getContext());
            if (!a2) {
                AppMethodBeat.o(74134);
                return false;
            }
            dRW();
            AppMethodBeat.o(74134);
            return true;
        } else if (str.equals("settings_chatting_bg_apply_to_all")) {
            com.tencent.mm.ui.base.h.a(getContext(), getString(R.string.go1), "", new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsChattingBackgroundUI.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(74129);
                    SettingsChattingBackgroundUI.eTe();
                    AppMethodBeat.o(74129);
                }
            }, (DialogInterface.OnClickListener) null);
            AppMethodBeat.o(74134);
            return true;
        } else {
            AppMethodBeat.o(74134);
            return false;
        }
    }

    static /* synthetic */ void eTe() {
        AppMethodBeat.i(74138);
        b bew = v.bew();
        Cursor rawQuery = bew.iFy.rawQuery("select chattingbginfo.username,chattingbginfo.bgflag,chattingbginfo.path,chattingbginfo.reserved1,chattingbginfo.reserved2,chattingbginfo.reserved3,chattingbginfo.reserved4 from chattingbginfo  ", null);
        if (rawQuery == null) {
            Log.i("MicroMsg.SettingsChattingBackgroundUI", "applyToAll : cursor is null");
            AppMethodBeat.o(74138);
            return;
        }
        v.bev();
        if (rawQuery.moveToFirst()) {
            com.tencent.mm.bb.a aVar = new com.tencent.mm.bb.a();
            while (!rawQuery.isAfterLast()) {
                aVar.convertFrom(rawQuery);
                com.tencent.mm.vfs.s.deleteFile(r.T(aVar.getUsername(), true));
                com.tencent.mm.vfs.s.deleteFile(r.T(aVar.getUsername(), false));
                rawQuery.moveToNext();
            }
        }
        rawQuery.close();
        if (bew.iFy.delete("chattingbginfo", null, null) > 0) {
            bew.doNotify();
        }
        AppMethodBeat.o(74138);
    }
}
