package com.tencent.mm.ui.matrix;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.c.a.a;
import com.tencent.matrix.b;
import com.tencent.matrix.e;
import com.tencent.matrix.g.c;
import com.tencent.matrix.strategy.MatrixStrategyNotifyBroadcast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.matrix.MatrixSettingHeaderPreference;
import com.tencent.mm.ui.matrix.MatrixSettingSeekBarPreference;

public class MatrixSettingUI extends MMPreference implements MatrixSettingHeaderPreference.a {
    private static Object QmU = null;
    private static boolean QmV = false;
    private MultiProcessMMKV cPL = MultiProcessMMKV.getMMKV("MatrixDelegate");

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MatrixSettingUI() {
        AppMethodBeat.i(38889);
        AppMethodBeat.o(38889);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        MatrixSettingUI matrixSettingUI;
        AppMethodBeat.i(38890);
        super.onCreate(bundle);
        setMMTitle(getContext().getResources().getString(R.string.ez4));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.matrix.MatrixSettingUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(38886);
                MatrixSettingUI.this.finish();
                AppMethodBeat.o(38886);
                return true;
            }
        });
        if (!b.isInstalled()) {
            Log.e("Matrix.SettingUI", "Matrix is not installed!");
            AppMethodBeat.o(38890);
            return;
        }
        MatrixSettingHeaderPreference matrixSettingHeaderPreference = (MatrixSettingHeaderPreference) getPreferenceScreen().bmg("matrix_header_pref");
        if (QmV || !dCM()) {
            matrixSettingUI = null;
        } else {
            matrixSettingUI = this;
        }
        matrixSettingHeaderPreference.QmP = matrixSettingUI;
        MatrixSettingSeekBarPreference matrixSettingSeekBarPreference = (MatrixSettingSeekBarPreference) getPreferenceScreen().bmg("matrix_jank_seek_bar");
        matrixSettingSeekBarPreference.KVM = this.cPL.getInt(a.EnumC0131a.clicfg_matrix_trace_evil_method_threshold.name(), 700);
        matrixSettingSeekBarPreference.QmR = new MatrixSettingSeekBarPreference.a() {
            /* class com.tencent.mm.ui.matrix.MatrixSettingUI.AnonymousClass2 */

            @Override // com.tencent.mm.ui.matrix.MatrixSettingSeekBarPreference.a
            public final void aok(int i2) {
                AppMethodBeat.i(38887);
                Log.i("Matrix.SettingUI", "[onConfirm] threshold=".concat(String.valueOf(i2)));
                MatrixSettingUI.cj("MODIFY_EVIL_THRESHOLD", (long) i2);
                AppMethodBeat.o(38887);
            }
        };
        AppMethodBeat.o(38890);
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x026a  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0276  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0137 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01e7  */
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onStart() {
        /*
        // Method dump skipped, instructions count: 639
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.matrix.MatrixSettingUI.onStart():void");
    }

    private static boolean dCM() {
        return BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.DEBUG;
    }

    @Override // com.tencent.mm.ui.matrix.MatrixSettingHeaderPreference.a
    public final void gWW() {
        AppMethodBeat.i(38892);
        Log.i("Matrix.SettingUI", "onOpenDev...");
        QmV = true;
        getPreferenceScreen().m38do("matrix_dev_wording", false);
        getPreferenceScreen().m38do("make_leak_preference", false);
        getPreferenceScreen().m38do("methodBeat_preference", false);
        getPreferenceScreen().m38do("trace_dev_log_preference", false);
        ((CheckBoxPreference) getPreferenceScreen().bmg("methodBeat_preference")).setChecked(com.tencent.matrix.trace.a.Ts().isAlive());
        ((CheckBoxPreference) getPreferenceScreen().bmg("trace_dev_log_preference")).setChecked(((com.tencent.matrix.trace.a) b.RG().Y(com.tencent.matrix.trace.a.class)).daC.daO);
        getPreferenceScreen().notifyDataSetChanged();
        AppMethodBeat.o(38892);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.bk;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(38893);
        if (!b.isInstalled()) {
            AppMethodBeat.o(38893);
            return false;
        }
        String str = preference.mKey;
        if (str.equalsIgnoreCase("startup_preference")) {
            dt("ENABLE_START_UP", ((CheckBoxPreference) preference).isChecked());
        } else if (str.equalsIgnoreCase("jank_preference")) {
            dt("ENABLE_EVIL_METHOD", ((CheckBoxPreference) preference).isChecked());
        } else if (str.equalsIgnoreCase("anr_preference")) {
            dt("ENABLE_ANR", ((CheckBoxPreference) preference).isChecked());
        } else if (str.equalsIgnoreCase("fps_preference")) {
            dt("ENABLE_FPS", ((CheckBoxPreference) preference).isChecked());
        } else if (str.equalsIgnoreCase("methodBeat_preference")) {
            dt("ENABLE_METHOD_BEAT", ((CheckBoxPreference) preference).isChecked());
        } else if (str.equalsIgnoreCase("make_leak_preference")) {
            if (((CheckBoxPreference) preference).isChecked()) {
                QmU = this;
            } else {
                QmU = null;
            }
        } else if (str.equalsIgnoreCase("fps_decorator_preference")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
            if (!RN()) {
                startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())), 2);
            } else {
                CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) getPreferenceScreen().bmg("fps_preference");
                if (checkBoxPreference.isChecked()) {
                    checkBoxPreference2.setChecked(true);
                    dt("ENABLE_FPS", true);
                }
                dt("ENABLE_FPS_FLOAT", checkBoxPreference.isChecked());
            }
        } else if (str.equalsIgnoreCase("trace_dev_log_preference")) {
            dt("ENABLE_DEV_LOG", ((CheckBoxPreference) preference).isChecked());
        } else if (str.equalsIgnoreCase("battery_preference")) {
            dt("ENABLE_BATTERY", ((CheckBoxPreference) preference).isChecked());
        } else if (str.equalsIgnoreCase("thread_preference")) {
            dt("ENABLE_THREAD", ((CheckBoxPreference) preference).isChecked());
        }
        AppMethodBeat.o(38893);
        return true;
    }

    private static void dt(String str, boolean z) {
        AppMethodBeat.i(38894);
        Intent intent = new Intent();
        intent.setAction(str);
        intent.putExtra(str, z);
        MMApplicationContext.getContext();
        e.j(intent);
        MMApplicationContext.getContext().sendBroadcast(intent, MatrixStrategyNotifyBroadcast.dag);
        AppMethodBeat.o(38894);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(38895);
        super.onActivityResult(i2, i3, intent);
        c.i("Matrix.SettingUI", "requestCode:%s resultCode:%s", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 2) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) getPreferenceScreen().bmg("fps_decorator_preference");
            if (!RN()) {
                Toast.makeText(this, getResources().getString(R.string.eyp), 1).show();
                checkBoxPreference.setChecked(false);
            } else {
                checkBoxPreference.setChecked(true);
                dt("ENABLE_FPS_FLOAT", checkBoxPreference.isChecked());
                ((CheckBoxPreference) getPreferenceScreen().bmg("fps_preference")).setChecked(true);
                dt("ENABLE_FPS", true);
            }
            getPreferenceScreen().notifyDataSetChanged();
        }
        AppMethodBeat.o(38895);
    }

    private boolean RN() {
        AppMethodBeat.i(38896);
        if (Build.VERSION.SDK_INT >= 23) {
            boolean canDrawOverlays = Settings.canDrawOverlays(this);
            AppMethodBeat.o(38896);
            return canDrawOverlays;
        }
        AppMethodBeat.o(38896);
        return true;
    }

    static /* synthetic */ void cj(String str, long j2) {
        AppMethodBeat.i(38897);
        Intent intent = new Intent();
        intent.setAction(str);
        intent.putExtra(str, j2);
        MMApplicationContext.getContext();
        e.j(intent);
        MMApplicationContext.getContext().sendBroadcast(intent, MatrixStrategyNotifyBroadcast.dag);
        AppMethodBeat.o(38897);
    }
}
