package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.Preference;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.f.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.task.preload.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.weui.base.preference.CheckBoxPreference;
import com.tencent.weui.base.preference.WeUIPreference;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0014J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0015J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u001e\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandDebugUI;", "Lcom/tencent/weui/base/preference/WeUIPreference;", "()V", "activityMonitor", "Lcom/tencent/threadpool/runnable/FutureEx;", "getActivityMonitor", "()Lcom/tencent/threadpool/runnable/FutureEx;", "setActivityMonitor", "(Lcom/tencent/threadpool/runnable/FutureEx;)V", "getFooterResourceId", "", "getResourceId", "onDestroy", "", "onPostCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/weui/base/preference/IPreferenceScreen;", "pref", "Landroid/preference/Preference;", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandDebugUI extends WeUIPreference {
    @Deprecated
    public static final a nSO = new a((byte) 0);
    public d<?> nSN;

    static {
        AppMethodBeat.i(229478);
        AppMethodBeat.o(229478);
    }

    @Override // com.tencent.weui.base.preference.WeUIPreference, com.tencent.mm.ui.BaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "mb", "", "<anonymous parameter 1>", "invoke"})
    static final class b extends q implements m<Integer, Integer, x> {
        final /* synthetic */ AppBrandDebugUI nSP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(AppBrandDebugUI appBrandDebugUI) {
            super(2);
            this.nSP = appBrandDebugUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Integer num, Integer num2) {
            AppMethodBeat.i(229473);
            int intValue = num.intValue();
            num2.intValue();
            a unused = AppBrandDebugUI.nSO;
            Log.i("MicroMsg.AppBrandDebugUI", "getAllTaskMemUsageAsync: [%d]MB", Integer.valueOf(intValue));
            View findViewById = this.nSP.findViewById(R.id.fci);
            p.g(findViewById, "findViewById<TextView>(R.id.mem_total_usage)");
            ((TextView) findViewById).setText("AppBrand Total Mem Usage: " + intValue + "MB");
            x xVar = x.SXb;
            AppMethodBeat.o(229473);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandDebugUI$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v7.app.AppCompatActivity
    @SuppressLint({"SetTextI18n"})
    public final void onPostCreate(Bundle bundle) {
        AppMethodBeat.i(229475);
        if (!f.bWW()) {
            finish();
            AppMethodBeat.o(229475);
            return;
        }
        super.onPostCreate(bundle);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle("AppBrand Client Debug");
        }
        Preference brv = hrD().brv("pref_key_enable_preload");
        if (brv == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.weui.base.preference.CheckBoxPreference");
            AppMethodBeat.o(229475);
            throw tVar;
        }
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) brv;
        checkBoxPreference.setChecked(!e.bWG());
        checkBoxPreference.aez(8);
        Preference brv2 = hrD().brv("pref_key_enable_v2_manager");
        if (brv2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.weui.base.preference.CheckBoxPreference");
            AppMethodBeat.o(229475);
            throw tVar2;
        }
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) brv2;
        checkBoxPreference2.setChecked(p.bXu());
        checkBoxPreference2.aez(8);
        Preference brv3 = hrD().brv("pref_key_enable_single_task_dispatch");
        if (brv3 == null) {
            t tVar3 = new t("null cannot be cast to non-null type com.tencent.weui.base.preference.CheckBoxPreference");
            AppMethodBeat.o(229475);
            throw tVar3;
        }
        CheckBoxPreference checkBoxPreference3 = (CheckBoxPreference) brv3;
        checkBoxPreference3.setChecked(p.bXv());
        checkBoxPreference3.aez(8);
        Preference brv4 = hrD().brv("pref_key_enable_three_proc_tasks_dispatch");
        if (brv4 == null) {
            t tVar4 = new t("null cannot be cast to non-null type com.tencent.weui.base.preference.CheckBoxPreference");
            AppMethodBeat.o(229475);
            throw tVar4;
        }
        CheckBoxPreference checkBoxPreference4 = (CheckBoxPreference) brv4;
        checkBoxPreference4.setChecked(p.bXw());
        checkBoxPreference4.aez(8);
        com.tencent.mm.plugin.appbrand.task.c cVar = com.tencent.mm.plugin.appbrand.task.c.nOr;
        com.tencent.mm.plugin.appbrand.task.c.c(new b(this));
        AppMethodBeat.o(229475);
    }

    @Override // com.tencent.weui.base.preference.WeUIPreference
    public final boolean a(com.tencent.weui.base.preference.a aVar, Preference preference) {
        boolean z;
        AppMethodBeat.i(229476);
        p.h(aVar, "screen");
        p.h(preference, "pref");
        Preference brv = aVar.brv("pref_key_enable_preload");
        if (brv == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.weui.base.preference.CheckBoxPreference");
            AppMethodBeat.o(229476);
            throw tVar;
        }
        if (!((CheckBoxPreference) brv).isChecked()) {
            z = true;
        } else {
            z = false;
        }
        e.iG(z);
        Preference brv2 = aVar.brv("pref_key_enable_v2_manager");
        if (brv2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.weui.base.preference.CheckBoxPreference");
            AppMethodBeat.o(229476);
            throw tVar2;
        }
        p.iN(((CheckBoxPreference) brv2).isChecked());
        Preference brv3 = aVar.brv("pref_key_enable_single_task_dispatch");
        if (brv3 == null) {
            t tVar3 = new t("null cannot be cast to non-null type com.tencent.weui.base.preference.CheckBoxPreference");
            AppMethodBeat.o(229476);
            throw tVar3;
        }
        boolean isChecked = ((CheckBoxPreference) brv3).isChecked();
        Preference brv4 = aVar.brv("pref_key_enable_three_proc_tasks_dispatch");
        if (brv4 == null) {
            t tVar4 = new t("null cannot be cast to non-null type com.tencent.weui.base.preference.CheckBoxPreference");
            AppMethodBeat.o(229476);
            throw tVar4;
        }
        boolean isChecked2 = ((CheckBoxPreference) brv4).isChecked();
        p.iP(isChecked);
        p.iO(isChecked2);
        Preference brv5 = aVar.brv("pref_key_enable_single_task_dispatch");
        if (brv5 == null) {
            t tVar5 = new t("null cannot be cast to non-null type com.tencent.weui.base.preference.CheckBoxPreference");
            AppMethodBeat.o(229476);
            throw tVar5;
        }
        ((CheckBoxPreference) brv5).xZ(isChecked);
        Preference brv6 = aVar.brv("pref_key_enable_three_proc_tasks_dispatch");
        if (brv6 == null) {
            t tVar6 = new t("null cannot be cast to non-null type com.tencent.weui.base.preference.CheckBoxPreference");
            AppMethodBeat.o(229476);
            throw tVar6;
        }
        ((CheckBoxPreference) brv6).xZ(isChecked2);
        String key = preference.getKey();
        if (key != null) {
            switch (key.hashCode()) {
                case 811513037:
                    if (key.equals("pref_key_preload_next_plugin")) {
                        h.bWb().e(z.TEST_ONLY);
                        Toast.makeText(this, "preloading", 0).show();
                        break;
                    }
                    break;
                case 1323416913:
                    if (key.equals("pref_key_test_kill_all")) {
                        h.bWb().zn(2);
                        break;
                    }
                    break;
                case 1361184451:
                    if (key.equals("pref_key_preload_downgrade")) {
                        EditText editText = new EditText(this);
                        com.tencent.mm.plugin.appbrand.task.preload.a aVar2 = com.tencent.mm.plugin.appbrand.task.preload.a.nQO;
                        editText.setText(String.valueOf(com.tencent.mm.plugin.appbrand.task.preload.a.bWD()));
                        new AlertDialog.Builder(this).setNegativeButton("Save", new c(editText)).setView(editText).show();
                        break;
                    }
                    break;
                case 1564999238:
                    if (key.equals("pref_key_preload_next_wxa")) {
                        h.bWb().a(g.WASERVICE, z.TEST_ONLY);
                        Toast.makeText(this, "preloading", 0).show();
                        break;
                    }
                    break;
            }
        }
        AppMethodBeat.o(229476);
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    static final class c implements DialogInterface.OnClickListener {
        final /* synthetic */ EditText nSQ;

        c(EditText editText) {
            this.nSQ = editText;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(229474);
            com.tencent.mm.plugin.appbrand.task.preload.a aVar = com.tencent.mm.plugin.appbrand.task.preload.a.nQO;
            com.tencent.mm.plugin.appbrand.task.preload.a.zo(Integer.parseInt(this.nSQ.getText().toString()));
            AppMethodBeat.o(229474);
        }
    }

    @Override // com.tencent.weui.base.preference.WeUIPreference
    public final int getFooterResourceId() {
        return R.layout.d4;
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(229477);
        super.onDestroy();
        if (this.nSN != null) {
            d<?> dVar = this.nSN;
            if (dVar == null) {
                p.btv("activityMonitor");
            }
            dVar.cancel(true);
        }
        AppMethodBeat.o(229477);
    }
}
