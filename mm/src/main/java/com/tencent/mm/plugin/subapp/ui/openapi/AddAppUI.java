package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class AddAppUI extends MMPreference implements i {
    private AppPreference FMl;
    private AppPreference FMm;
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.f3178e;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29115);
        super.onCreate(bundle);
        AppMethodBeat.o(29115);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(29116);
        super.onResume();
        initView();
        if (this.FMl != null) {
            this.FMl.onResume();
        }
        if (this.FMm != null) {
            this.FMm.onResume();
        }
        AppMethodBeat.o(29116);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(29117);
        super.onPause();
        if (this.FMl != null) {
            this.FMl.onPause();
        }
        if (this.FMm != null) {
            this.FMm.onPause();
        }
        AppMethodBeat.o(29117);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(29118);
        setMMTitle(R.string.f21do);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.subapp.ui.openapi.AddAppUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(29111);
                AddAppUI.this.finish();
                AppMethodBeat.o(29111);
                return true;
            }
        });
        this.screen = getPreferenceScreen();
        this.screen.removeAll();
        this.screen.addPreferencesFromResource(getResourceId());
        this.FMl = (AppPreference) this.screen.bmg("addapp_added");
        this.FMl.FMp = 1;
        this.FMl.FMs = new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.subapp.ui.openapi.AddAppUI.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(29112);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                a.b("com/tencent/mm/plugin/subapp/ui/openapi/AddAppUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                AddAppUI.a(AddAppUI.this, AddAppUI.this.FMl.abn(i2).field_appId);
                a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/AddAppUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(29112);
            }
        };
        this.FMl.FMt = new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.subapp.ui.openapi.AddAppUI.AnonymousClass3 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(29113);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                a.b("com/tencent/mm/plugin/subapp/ui/openapi/AddAppUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                AddAppUI.h(AddAppUI.this.FMl.abn(i2));
                AddAppUI.this.initView();
                a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/AddAppUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(29113);
            }
        };
        this.FMm = (AppPreference) this.screen.bmg("addapp_available");
        this.FMm.FMp = 0;
        this.FMm.FMs = new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.subapp.ui.openapi.AddAppUI.AnonymousClass4 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(29114);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                a.b("com/tencent/mm/plugin/subapp/ui/openapi/AddAppUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                AddAppUI.a(AddAppUI.this, AddAppUI.this.FMm.abn(i2).field_appId);
                a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/AddAppUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(29114);
            }
        };
        AppMethodBeat.o(29118);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(29120);
        Log.d("MicroMsg.AddAppUI", "onSceneEnd, errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            AppMethodBeat.o(29120);
            return;
        }
        Log.e("MicroMsg.AddAppUI", "onSceneEnd, errType = " + i2 + ", errCode = " + i3);
        AppMethodBeat.o(29120);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(29119);
        if (preference.mKey.equals("addapp_recommend")) {
            String string = getString(R.string.dt, new Object[]{Integer.valueOf(d.KyO), LocaleUtil.loadApplicationLanguage(getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), getContext()), LocaleUtil.getCurrentCountryCode()});
            Intent intent = new Intent();
            intent.putExtra("rawUrl", string);
            c.b(this, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(29119);
            return true;
        }
        AppMethodBeat.o(29119);
        return false;
    }

    static /* synthetic */ void a(AddAppUI addAppUI, String str) {
        AppMethodBeat.i(29121);
        Intent intent = new Intent(addAppUI, AppProfileUI.class);
        intent.putExtra("AppProfileUI_AppId", str);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        a.a(addAppUI, bl.axQ(), "com/tencent/mm/plugin/subapp/ui/openapi/AddAppUI", "gotoProfile", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        addAppUI.startActivity((Intent) bl.pG(0));
        a.a(addAppUI, "com/tencent/mm/plugin/subapp/ui/openapi/AddAppUI", "gotoProfile", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(29121);
    }

    static /* synthetic */ void h(g gVar) {
        AppMethodBeat.i(29122);
        gVar.field_status = 0;
        gVar.field_modifyTime = System.currentTimeMillis();
        ao.eAS().a(gVar, new String[0]);
        AppMethodBeat.o(29122);
    }
}
