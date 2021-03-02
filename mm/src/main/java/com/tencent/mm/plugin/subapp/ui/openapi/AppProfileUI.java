package com.tencent.mm.plugin.subapp.ui.openapi;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ba.i;
import com.tencent.mm.cb.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.subapp.ui.openapi.AppHeaderPreference;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.LinkedList;
import junit.framework.Assert;

public class AppProfileUI extends MMPreference implements MStorage.IOnStorageChange {
    private AppHeaderPreference.a FMy;
    private MMHandler handler = null;
    private f screen;
    private g xOH;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.f3183j;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29148);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(29148);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(29149);
        super.onResume();
        ao.eAS().add(this);
        AppMethodBeat.o(29149);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(29150);
        ao.eAS().remove(this);
        super.onPause();
        AppMethodBeat.o(29150);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z = true;
        AppMethodBeat.i(29151);
        this.FMy = new AppHeaderPreference.a() {
            /* class com.tencent.mm.plugin.subapp.ui.openapi.AppProfileUI.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.subapp.ui.openapi.AppHeaderPreference.a
            public final String ftq() {
                AppMethodBeat.i(29142);
                String a2 = h.a(AppProfileUI.this.getContext(), AppProfileUI.this.xOH, (String) null);
                AppMethodBeat.o(29142);
                return a2;
            }

            @Override // com.tencent.mm.plugin.subapp.ui.openapi.AppHeaderPreference.a
            public final Bitmap ftr() {
                AppMethodBeat.i(29143);
                Bitmap c2 = h.c(AppProfileUI.this.xOH.field_appId, 1, a.getDensity(AppProfileUI.this));
                AppMethodBeat.o(29143);
                return c2;
            }

            @Override // com.tencent.mm.plugin.subapp.ui.openapi.AppHeaderPreference.a
            public final String wf(boolean z) {
                AppMethodBeat.i(29144);
                String string = AppProfileUI.this.getContext().getString(z ? R.string.gsr : R.string.gsy);
                AppMethodBeat.o(29144);
                return string;
            }

            @Override // com.tencent.mm.plugin.subapp.ui.openapi.AppHeaderPreference.a
            public final String getHint() {
                AppMethodBeat.i(29145);
                AppCompatActivity context = AppProfileUI.this.getContext();
                g gVar = AppProfileUI.this.xOH;
                if (context == null || gVar == null) {
                    AppMethodBeat.o(29145);
                    return null;
                }
                String it = h.it(context);
                if (it.equalsIgnoreCase(LocaleUtil.CHINA)) {
                    String str = gVar.field_appDiscription;
                    AppMethodBeat.o(29145);
                    return str;
                } else if (it.equalsIgnoreCase(LocaleUtil.TAIWAN) || it.equalsIgnoreCase(LocaleUtil.HONGKONG)) {
                    if (Util.isNullOrNil(gVar.field_appDiscription_tw)) {
                        String str2 = gVar.field_appDiscription;
                        AppMethodBeat.o(29145);
                        return str2;
                    }
                    String str3 = gVar.field_appDiscription_tw;
                    AppMethodBeat.o(29145);
                    return str3;
                } else if (it.equalsIgnoreCase(LocaleUtil.ENGLISH)) {
                    if (Util.isNullOrNil(gVar.field_appDiscription_en)) {
                        String str4 = gVar.field_appDiscription;
                        AppMethodBeat.o(29145);
                        return str4;
                    }
                    String str5 = gVar.field_appDiscription_en;
                    AppMethodBeat.o(29145);
                    return str5;
                } else if (Util.isNullOrNil(gVar.field_appDiscription_en)) {
                    String str6 = gVar.field_appDiscription;
                    AppMethodBeat.o(29145);
                    return str6;
                } else {
                    String str7 = gVar.field_appDiscription_en;
                    AppMethodBeat.o(29145);
                    return str7;
                }
            }
        };
        this.xOH = h.o(getIntent().getStringExtra("AppProfileUI_AppId"), true, false);
        if (this.xOH == null) {
            z = false;
        }
        Assert.assertTrue("initView : appInfo does not exist", z);
        setMMTitle(R.string.y5);
        this.screen = getPreferenceScreen();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.subapp.ui.openapi.AppProfileUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(29146);
                AppProfileUI.this.finish();
                AppMethodBeat.o(29146);
                return true;
            }
        });
        refresh();
        AppMethodBeat.o(29151);
    }

    private void refresh() {
        boolean z = true;
        AppMethodBeat.i(29152);
        this.screen.removeAll();
        this.screen.addPreferencesFromResource(getResourceId());
        if (this.xOH.field_status == 1) {
            this.screen.bmi("app_profile_add");
        } else {
            this.screen.bmi("app_profile_remove");
        }
        AppHeaderPreference appHeaderPreference = (AppHeaderPreference) this.screen.bmg("app_profile_header");
        AppHeaderPreference.a aVar = this.FMy;
        if (this.xOH.field_status != 1) {
            z = false;
        }
        appHeaderPreference.a(aVar, z);
        AppMethodBeat.o(29152);
    }

    private void fts() {
        AppMethodBeat.i(29153);
        this.handler = new MMHandler() {
            /* class com.tencent.mm.plugin.subapp.ui.openapi.AppProfileUI.AnonymousClass3 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(29147);
                AppProfileUI.this.finish();
                AppMethodBeat.o(29147);
            }
        };
        this.handler.sendEmptyMessageDelayed(0, 30);
        AppMethodBeat.o(29153);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(29155);
        if (str.equals(this.xOH.field_appId)) {
            initView();
        }
        AppMethodBeat.o(29155);
    }

    private static void a(g gVar, boolean z) {
        AppMethodBeat.i(29156);
        LinkedList linkedList = new LinkedList();
        linkedList.add(new i.a(10165, gVar.field_appId + "," + (z ? "1" : "2")));
        bg.aVF();
        c.aSM().d(new i(linkedList));
        AppMethodBeat.o(29156);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(29154);
        String str = preference.mKey;
        Log.i("MicroMsg.AppProfileUI", str + " item has been clicked!");
        if (str.equals("app_profile_add")) {
            this.xOH.field_status = 1;
            this.xOH.field_modifyTime = System.currentTimeMillis();
            ao.eAS().a(this.xOH, new String[0]);
            refresh();
            a(this.xOH, true);
            fts();
            AppMethodBeat.o(29154);
            return true;
        } else if (str.equals("app_profile_remove")) {
            this.xOH.field_status = 0;
            this.xOH.field_modifyTime = System.currentTimeMillis();
            ao.eAS().a(this.xOH, new String[0]);
            refresh();
            a(this.xOH, false);
            fts();
            AppMethodBeat.o(29154);
            return true;
        } else {
            AppMethodBeat.o(29154);
            return false;
        }
    }
}
