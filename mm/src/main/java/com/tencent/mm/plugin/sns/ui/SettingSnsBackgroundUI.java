package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.a;
import java.util.LinkedList;

public class SettingSnsBackgroundUI extends MMPreference {
    protected String filePath;
    private f screen;
    private SharedPreferences sp;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(SettingSnsBackgroundUI settingSnsBackgroundUI, int i2, Intent intent) {
        AppMethodBeat.i(98257);
        settingSnsBackgroundUI.l(i2, intent);
        AppMethodBeat.o(98257);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.cu;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(98247);
        Log.d("MicroMsg.SettingSnsBackgroundUI", "onCreate");
        super.onCreate(bundle);
        this.screen = getPreferenceScreen();
        this.sp = getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
        initView();
        AppMethodBeat.o(98247);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(98248);
        Log.d("MicroMsg.SettingSnsBackgroundUI", "onNewIntent");
        super.onNewIntent(intent);
        setIntent(intent);
        setResult(-1);
        finish();
        AppMethodBeat.o(98248);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(98249);
        super.onDestroy();
        Log.d("MicroMsg.SettingSnsBackgroundUI", "onDestroy");
        AppMethodBeat.o(98249);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(98250);
        super.onResume();
        if (this.screen != null) {
            this.screen.notifyDataSetChanged();
        }
        AppMethodBeat.o(98250);
    }

    private void l(int i2, Intent intent) {
        AppMethodBeat.i(98251);
        switch (i2) {
            case 2:
                Log.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult CONTEXT_MENU_TAKE_PICTURE");
                this.filePath = s.h(getApplicationContext(), intent, aj.getAccSnsTmpPath());
                if (this.filePath == null) {
                    AppMethodBeat.o(98251);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 1);
                intent2.putExtra("CropImage_ImgPath", this.filePath);
                intent2.putExtra("CropImage_OutputPath", aj.getAccSnsTmpPath() + g.getMessageDigest((this.filePath + System.currentTimeMillis()).getBytes()));
                a.jRt.a(this, intent2, 6);
                AppMethodBeat.o(98251);
                return;
            case 3:
            case 4:
            default:
                Log.e("MicroMsg.SettingSnsBackgroundUI", "onActivityResult: not found this requestCode");
                AppMethodBeat.o(98251);
                return;
            case 5:
                Log.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult CONTEXT_MENU_IMAGE_BROUND");
                if (intent == null) {
                    AppMethodBeat.o(98251);
                    return;
                }
                this.filePath = s.h(getApplicationContext(), intent, aj.getAccSnsTmpPath());
                if (this.filePath == null) {
                    AppMethodBeat.o(98251);
                    return;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("CropImageMode", 1);
                intent3.putExtra("CropImage_ImgPath", this.filePath);
                a.jRt.a(this, intent, intent3, aj.getAccSnsTmpPath(), 6, new a.AbstractC2129a() {
                    /* class com.tencent.mm.plugin.sns.ui.SettingSnsBackgroundUI.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.tools.a.AbstractC2129a
                    public final String aQX(String str) {
                        AppMethodBeat.i(98241);
                        String str2 = aj.getAccSnsTmpPath() + g.getMessageDigest((SettingSnsBackgroundUI.this.filePath + System.currentTimeMillis()).getBytes());
                        AppMethodBeat.o(98241);
                        return str2;
                    }
                });
                AppMethodBeat.o(98251);
                return;
            case 6:
                Log.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM");
                new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.SettingSnsBackgroundUI.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(98242);
                        com.tencent.mm.plugin.sns.c.a.jRu.Xb();
                        AppMethodBeat.o(98242);
                    }
                });
                if (intent == null) {
                    AppMethodBeat.o(98251);
                    return;
                }
                this.filePath = intent.getStringExtra("CropImage_OutputPath");
                if (this.filePath == null) {
                    AppMethodBeat.o(98251);
                    return;
                }
                Log.d("MicroMsg.SettingSnsBackgroundUI", "REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM   " + this.filePath);
                be faK = aj.faK();
                String str = this.filePath;
                new LinkedList().add(new q(str, 2));
                if (faK.fau() != null && !faK.fau().equals("")) {
                    String ki = ar.ki(aj.getAccSnsPath(), faK.fau());
                    com.tencent.mm.vfs.s.boN(ki);
                    com.tencent.mm.vfs.s.deleteFile(ki + faK.fau() + "bg_");
                    com.tencent.mm.vfs.s.nw(str, ki + faK.fau() + "bg_");
                    m faS = aj.faS();
                    l aQr = faS.aQr(faK.fau());
                    aQr.field_bgId = "";
                    faS.c(aQr);
                }
                faK.fbT();
                faK.fau();
                bf bfVar = new bf(7);
                bfVar.kn(str, "");
                bfVar.YH(1);
                bfVar.commit();
                setResult(-1);
                finish();
                AppMethodBeat.o(98251);
                return;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(final int i2, final int i3, final Intent intent) {
        AppMethodBeat.i(98252);
        Log.i("MicroMsg.SettingSnsBackgroundUI", "onAcvityResult requestCode:" + i2 + " " + i3);
        if (i3 != -1) {
            if (i2 == 2 || i2 == 5 || i2 == 6) {
                new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.SettingSnsBackgroundUI.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(98243);
                        com.tencent.mm.plugin.sns.c.a.jRu.Xb();
                        AppMethodBeat.o(98243);
                    }
                });
            }
            AppMethodBeat.o(98252);
            return;
        }
        StringBuilder sb = new StringBuilder("result ok ");
        com.tencent.mm.kernel.g.aAi();
        Log.d("MicroMsg.SettingSnsBackgroundUI", sb.append(com.tencent.mm.kernel.g.aAf().azp()).toString());
        if (aj.isInValid()) {
            new MMHandler(Looper.myLooper()).postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.SettingSnsBackgroundUI.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(98244);
                    SettingSnsBackgroundUI.a(SettingSnsBackgroundUI.this, i2, intent);
                    AppMethodBeat.o(98244);
                }
            }, 2000);
            AppMethodBeat.o(98252);
            return;
        }
        Log.d("MicroMsg.SettingSnsBackgroundUI", "isInValid ok");
        l(i2, intent);
        AppMethodBeat.o(98252);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(98253);
        setMMTitle(R.string.gua);
        SnsArtistPreference snsArtistPreference = (SnsArtistPreference) this.screen.bmg("settings_sns_bg_select_bg");
        if (snsArtistPreference != null) {
            String string = this.sp.getString("artist_name", "");
            Log.d("MicroMsg.SettingSnsBackgroundUI", "artistName".concat(String.valueOf(string)));
            snsArtistPreference.EAb = string;
            snsArtistPreference.fhz();
            this.screen.notifyDataSetChanged();
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SettingSnsBackgroundUI.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(98245);
                SettingSnsBackgroundUI.this.finish();
                AppMethodBeat.o(98245);
                return true;
            }
        });
        AppMethodBeat.o(98253);
    }

    private void dRW() {
        AppMethodBeat.i(98255);
        if (!s.d(this, b.aKV(), "microMsg." + System.currentTimeMillis() + ".jpg", 2)) {
            Toast.makeText(this, getString(R.string.gix), 1).show();
        }
        AppMethodBeat.o(98255);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(98256);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.SettingSnsBackgroundUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(98256);
            return;
        }
        Log.i("MicroMsg.SettingSnsBackgroundUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case 16:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.fl0), getString(R.string.flp), getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.sns.ui.SettingSnsBackgroundUI.AnonymousClass6 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(98246);
                            SettingSnsBackgroundUI settingSnsBackgroundUI = SettingSnsBackgroundUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(settingSnsBackgroundUI, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SettingSnsBackgroundUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            settingSnsBackgroundUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(settingSnsBackgroundUI, "com/tencent/mm/plugin/sns/ui/SettingSnsBackgroundUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(98246);
                        }
                    }, (DialogInterface.OnClickListener) null);
                    break;
                } else {
                    dRW();
                    AppMethodBeat.o(98256);
                    return;
                }
        }
        AppMethodBeat.o(98256);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(98254);
        String str = preference.mKey;
        Log.i("MicroMsg.SettingSnsBackgroundUI", str + " item has been clicked!");
        if (str.equals("settings_sns_bg_select_from_album")) {
            com.tencent.mm.kernel.g.aAi();
            if (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable()) {
                u.g(this, null);
                AppMethodBeat.o(98254);
                return false;
            }
            s.c(this, 5, null);
            AppMethodBeat.o(98254);
            return true;
        } else if (str.equals("settings_sns_bg_take_photo")) {
            com.tencent.mm.kernel.g.aAi();
            if (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable()) {
                u.g(this, null);
                AppMethodBeat.o(98254);
                return false;
            }
            boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(getContext(), "android.permission.CAMERA", 16, "", "");
            Log.i("MicroMsg.SettingSnsBackgroundUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), getContext());
            if (!a2) {
                AppMethodBeat.o(98254);
                return false;
            }
            dRW();
            AppMethodBeat.o(98254);
            return true;
        } else if (str.equals("settings_sns_bg_select_bg")) {
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(this, ArtistUI.class));
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SettingSnsBackgroundUI", "setSelectBg", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SettingSnsBackgroundUI", "setSelectBg", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(98254);
            return true;
        } else {
            AppMethodBeat.o(98254);
            return false;
        }
    }
}
