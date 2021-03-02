package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ServiceAppUI extends MMPreference implements i {
    private ServicePreference FMA;
    private ServicePreference FMB;
    private PreferenceTitleCategory FMC;
    private PreferenceTitleCategory FMD;
    private List<g> FME = new ArrayList();
    private List<g> FMF = new ArrayList();
    private AdapterView.OnItemClickListener FMG;
    private AdapterView.OnItemClickListener FMH;
    private f screen;
    private String talker;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ServiceAppUI() {
        AppMethodBeat.i(29168);
        AppMethodBeat.o(29168);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.c6;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29169);
        super.onCreate(bundle);
        AppMethodBeat.o(29169);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(29170);
        super.onResume();
        initView();
        if (this.FMA != null) {
            this.FMA.onResume();
        }
        if (this.FMB != null) {
            this.FMB.onResume();
        }
        AppMethodBeat.o(29170);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(29171);
        super.onPause();
        if (this.FMA != null) {
            this.FMA.onPause();
        }
        if (this.FMB != null) {
            this.FMB.onPause();
        }
        AppMethodBeat.o(29171);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        Cursor hG;
        AppMethodBeat.i(29172);
        setMMTitle(R.string.gkt);
        this.talker = getIntent().getStringExtra("service_app_talker_user");
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.subapp.ui.openapi.ServiceAppUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(29165);
                ServiceAppUI.this.finish();
                AppMethodBeat.o(29165);
                return true;
            }
        });
        this.FME.clear();
        this.FMF.clear();
        if (ab.Eq(this.talker)) {
            hG = ao.eAS().hG(0, 2);
        } else if (ab.IT(this.talker)) {
            hG = ao.eAS().hG(0, 4);
        } else {
            hG = ao.eAS().hG(0, 1);
        }
        if (hG != null) {
            if (hG.moveToFirst()) {
                do {
                    g gVar = new g();
                    gVar.convertFrom(hG);
                    if (gVar.field_serviceAppType == 1) {
                        this.FME.add(gVar);
                    } else if (gVar.field_serviceAppType == 2) {
                        this.FMF.add(gVar);
                    }
                } while (hG.moveToNext());
            }
            hG.close();
        }
        Log.i("MicroMsg.ServiceAppUI", "initAppList: wxServiceList size %s, bizServiceList size %s", Integer.valueOf(this.FME.size()), Integer.valueOf(this.FMF.size()));
        if (this.FMG == null) {
            this.FMG = new AdapterView.OnItemClickListener() {
                /* class com.tencent.mm.plugin.subapp.ui.openapi.ServiceAppUI.AnonymousClass2 */

                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppMethodBeat.i(29166);
                    b bVar = new b();
                    bVar.bm(adapterView);
                    bVar.bm(view);
                    bVar.pH(i2);
                    bVar.zo(j2);
                    a.b("com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                    if (ServiceAppUI.this.FMA == null) {
                        Log.e("MicroMsg.ServiceAppUI", "wx onItemClick wxServicePref null");
                        a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(29166);
                        return;
                    }
                    g abn = ServiceAppUI.this.FMA.abn(i2);
                    if (abn == null) {
                        Log.e("MicroMsg.ServiceAppUI", "wx onItemClick app is null");
                        a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(29166);
                        return;
                    }
                    Log.i("MicroMsg.ServiceAppUI", "onItemClick, jumpType[%d], package[%s], appid[%s]", Integer.valueOf(abn.fmZ), abn.field_packageName, abn.field_appId);
                    ServiceAppUI.a(ServiceAppUI.this, abn);
                    a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(29166);
                }
            };
        }
        if (this.FMH == null) {
            this.FMH = new AdapterView.OnItemClickListener() {
                /* class com.tencent.mm.plugin.subapp.ui.openapi.ServiceAppUI.AnonymousClass3 */

                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppMethodBeat.i(29167);
                    b bVar = new b();
                    bVar.bm(adapterView);
                    bVar.bm(view);
                    bVar.pH(i2);
                    bVar.zo(j2);
                    a.b("com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                    if (ServiceAppUI.this.FMB == null) {
                        Log.e("MicroMsg.ServiceAppUI", "biz onItemClick bizServicePref null");
                        a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(29167);
                        return;
                    }
                    g abn = ServiceAppUI.this.FMB.abn(i2);
                    if (abn == null) {
                        Log.e("MicroMsg.ServiceAppUI", "biz onItemClick app is null");
                        a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(29167);
                        return;
                    }
                    Log.i("MicroMsg.ServiceAppUI", "onItemClick, jumpType[%d], package[%s], appid[%s]", Integer.valueOf(abn.fmZ), abn.field_packageName, abn.field_appId);
                    ServiceAppUI.a(ServiceAppUI.this, abn);
                    a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(29167);
                }
            };
        }
        this.screen = getPreferenceScreen();
        this.screen.removeAll();
        if (this.FME.size() > 0) {
            this.FMA = new ServicePreference(this);
            this.FMA.Dcn = this.FME;
            if (this.FMG != null) {
                this.FMA.FMs = this.FMG;
            }
            if (this.FMC == null) {
                this.FMC = new PreferenceTitleCategory(this);
                this.FMC.setTitle(R.string.j5g);
            }
            this.screen.c(this.FMC);
            this.screen.c(this.FMA);
        }
        if (this.FMF.size() > 0) {
            this.FMB = new ServicePreference(this);
            this.FMB.Dcn = this.FMF;
            if (this.FMH != null) {
                this.FMB.FMs = this.FMH;
            }
            if (this.FMD == null) {
                this.FMD = new PreferenceTitleCategory(this);
                this.FMD.setTitle(R.string.ahl);
            }
            this.screen.c(this.FMD);
            this.screen.c(this.FMB);
        }
        AppMethodBeat.o(29172);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        return false;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(29173);
        Log.d("MicroMsg.ServiceAppUI", "onSceneEnd, errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            AppMethodBeat.o(29173);
            return;
        }
        Log.e("MicroMsg.ServiceAppUI", "onSceneEnd, errType = " + i2 + ", errCode = " + i3);
        AppMethodBeat.o(29173);
    }

    static /* synthetic */ void a(ServiceAppUI serviceAppUI, g gVar) {
        int i2;
        AppMethodBeat.i(29174);
        if (gVar == null) {
            Log.e("MicroMsg.ServiceAppUI", "app is null");
            AppMethodBeat.o(29174);
            return;
        }
        h.INSTANCE.a(10923, 13, gVar.field_appId, 1);
        if (gVar.fmZ == 2 && !Util.isNullOrNil(gVar.fmY)) {
            String loadApplicationLanguage = LocaleUtil.loadApplicationLanguage(serviceAppUI.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), serviceAppUI.getContext());
            if (LocaleUtil.LANGUAGE_DEFAULT.equalsIgnoreCase(loadApplicationLanguage) && Locale.getDefault() != null) {
                loadApplicationLanguage = Locale.getDefault().toString();
            }
            if (ab.Eq(serviceAppUI.talker)) {
                bg.aVF();
                ah Kd = c.aSX().Kd(serviceAppUI.talker);
                if (Kd != null) {
                    i2 = Kd.bax().size();
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putString("jsapi_args_appid", gVar.field_appId);
                    bundle.putBoolean("isFromService", true);
                    bundle.putString("sendAppMsgToUserName", serviceAppUI.talker);
                    intent.putExtra("jsapiargs", bundle);
                    intent.putExtra("forceHideShare", true);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", gVar.fmY, Integer.valueOf(i2), loadApplicationLanguage));
                    com.tencent.mm.br.c.b(serviceAppUI.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    serviceAppUI.finish();
                    AppMethodBeat.o(29174);
                }
            }
            i2 = 1;
            Intent intent2 = new Intent();
            Bundle bundle2 = new Bundle();
            bundle2.putString("jsapi_args_appid", gVar.field_appId);
            bundle2.putBoolean("isFromService", true);
            bundle2.putString("sendAppMsgToUserName", serviceAppUI.talker);
            intent2.putExtra("jsapiargs", bundle2);
            intent2.putExtra("forceHideShare", true);
            intent2.putExtra("show_bottom", false);
            intent2.putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", gVar.fmY, Integer.valueOf(i2), loadApplicationLanguage));
            com.tencent.mm.br.c.b(serviceAppUI.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
            serviceAppUI.finish();
            AppMethodBeat.o(29174);
        } else if (gVar.fmZ == 3) {
            Intent intent3 = new Intent();
            intent3.putExtra("service_app_package_name", gVar.field_packageName);
            intent3.putExtra("service_app_openid", gVar.field_openId);
            intent3.putExtra("service_app_appid", gVar.field_appId);
            serviceAppUI.setResult(-1, intent3);
            serviceAppUI.finish();
            AppMethodBeat.o(29174);
        } else {
            if (gVar.fmZ == 1) {
                com.tencent.mm.plugin.subapp.b.jRt.t(serviceAppUI.getContext(), gVar.fmY);
                serviceAppUI.finish();
            }
            AppMethodBeat.o(29174);
        }
    }
}
