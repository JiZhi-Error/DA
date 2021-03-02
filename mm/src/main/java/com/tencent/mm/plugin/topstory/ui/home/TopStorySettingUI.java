package com.tencent.mm.plugin.topstory.ui.home;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.topstory.a.b.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class TopStorySettingUI extends MMPreference {
    private final String Gle = "unlike";
    private final String Glf = "black";
    private final String Glg = "feedback";
    private IconPreference Glh;
    private IconPreference Gli;
    private int Glj = -1;
    private int Glk = -1;
    private int Gll = -1;
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(TopStorySettingUI topStorySettingUI) {
        AppMethodBeat.i(125991);
        topStorySettingUI.fyq();
        AppMethodBeat.o(125991);
    }

    static /* synthetic */ void b(TopStorySettingUI topStorySettingUI) {
        AppMethodBeat.i(125992);
        topStorySettingUI.fyr();
        AppMethodBeat.o(125992);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.d6;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(125985);
        super.onCreate(bundle);
        setMMTitle(getString(R.string.d0));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.home.TopStorySettingUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(125981);
                TopStorySettingUI.this.finish();
                AppMethodBeat.o(125981);
                return true;
            }
        });
        this.screen = getPreferenceScreen();
        this.Glh = (IconPreference) this.screen.bmg("unlike");
        this.Gli = (IconPreference) this.screen.bmg("black");
        a fxV = a.fxV();
        fxV.ae(fxV.Gje, 0);
        a fxV2 = a.fxV();
        fxV2.af(fxV2.Gjf, 0);
        fyq();
        fyr();
        a.fxV().Gjk = new a.AbstractC1838a() {
            /* class com.tencent.mm.plugin.topstory.ui.home.TopStorySettingUI.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.topstory.a.b.a.AbstractC1838a
            public final void awp() {
                AppMethodBeat.i(125982);
                TopStorySettingUI.a(TopStorySettingUI.this);
                TopStorySettingUI.b(TopStorySettingUI.this);
                AppMethodBeat.o(125982);
            }
        };
        a.fxV().Gjl = new a.b() {
            /* class com.tencent.mm.plugin.topstory.ui.home.TopStorySettingUI.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.topstory.a.b.a.b
            public final void awp() {
                AppMethodBeat.i(125983);
                TopStorySettingUI.a(TopStorySettingUI.this);
                TopStorySettingUI.b(TopStorySettingUI.this);
                AppMethodBeat.o(125983);
            }
        };
        AppMethodBeat.o(125985);
    }

    private void fyq() {
        AppMethodBeat.i(125986);
        this.Glk = a.fxV().FjN.size();
        this.Glj = a.fxV().Gjd.size();
        AppMethodBeat.o(125986);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(125987);
        super.onResume();
        fyq();
        fyr();
        AppMethodBeat.o(125987);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(125988);
        super.onDestroy();
        a.fxV().Gjl = null;
        a.fxV().Gjk = null;
        AppMethodBeat.o(125988);
    }

    private void fyr() {
        AppMethodBeat.i(125989);
        Log.i("MicroMsg.TopStory.TopStorySettingUI", "updateSummary %s, %s", Integer.valueOf(this.Glj), Integer.valueOf(this.Glk));
        if (this.Glj <= 0) {
            this.Glh.setSummary("");
        } else {
            this.Glh.setSummary(new StringBuilder().append(this.Glj).toString());
        }
        if (this.Glk <= 0) {
            this.Gli.setSummary("");
        } else {
            this.Gli.setSummary(new StringBuilder().append(this.Glk).toString());
        }
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(125989);
    }

    private boolean abT(int i2) {
        AppMethodBeat.i(125990);
        Log.i("MicroMsg.TopStory.TopStorySettingUI", "goDetailSettingUI, type:%s", Integer.valueOf(i2));
        if (i2 == 1 || i2 == 2) {
            this.Gll = i2;
            Intent intent = new Intent();
            if (i2 == 1) {
                String listToString = Util.listToString(a.fxV().Gjd, ",");
                intent.putExtra("k_topstory_type", 1);
                intent.putExtra("k_topstory_user_list", listToString);
                ai.e(this, ".ui.home.TopStorySettingVisibilityDetailUI", intent);
            } else {
                String listToString2 = Util.listToString(a.fxV().FjN, ",");
                intent.putExtra("k_topstory_type", 2);
                intent.putExtra("k_topstory_user_list", listToString2);
                ai.e(this, ".ui.home.TopStorySettingVisibilityDetailUI", intent);
            }
            AppMethodBeat.o(125990);
            return true;
        }
        this.Gll = -1;
        AppMethodBeat.o(125990);
        return false;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(125984);
        String str = preference.mKey;
        if ("unlike".equals(str)) {
            h.INSTANCE.a(17080, 1, 2, new StringBuilder().append(this.Glj).toString());
            boolean abT = abT(1);
            AppMethodBeat.o(125984);
            return abT;
        } else if ("black".equals(str)) {
            h.INSTANCE.a(17080, 2, 2, new StringBuilder().append(this.Glk).toString());
            boolean abT2 = abT(2);
            AppMethodBeat.o(125984);
            return abT2;
        } else if ("feedback".equals(str)) {
            h.INSTANCE.a(17080, 18, 2, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            StringBuilder sb = new StringBuilder(HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2f) + "/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index");
            try {
                sb.append("&deviceName=").append(q.encode(d.DEVICE_NAME, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            } catch (Exception e2) {
            }
            sb.append("&imei=");
            try {
                sb.append("&deviceBrand=").append(q.encode(Build.BRAND, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            } catch (Exception e3) {
            }
            try {
                sb.append("&deviceModel=").append(q.encode(Build.MODEL, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            } catch (Exception e4) {
            }
            sb.append("&from=settingPage");
            StringBuilder append = sb.append("&uin=");
            g.aAf();
            append.append(com.tencent.mm.kernel.a.ayV());
            sb.append("&version=").append(d.KyO);
            try {
                sb.append("&lang=").append(q.encode(LocaleUtil.getApplicationLanguage(), MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            } catch (Exception e5) {
            }
            try {
                sb.append("&ostype=").append(q.encode(d.KyK, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            } catch (Exception e6) {
            }
            sb.append("&scene=32");
            sb.append("&timeZone=").append(Util.getTimeZoneOffset());
            sb.append("&templateVersion=").append(ai.aft(1));
            sb.append("#/list/4155");
            Log.i("MicroMsg.TopStory.TopStorySettingUI", "url is:" + sb.toString());
            Intent intent = new Intent();
            intent.putExtra("rawUrl", sb.toString());
            intent.putExtra("convertActivityFromTranslucent", false);
            intent.putExtra("customize_status_bar_color", 0);
            intent.putExtra("status_bar_style", (String) null);
            intent.putExtra("prePublishId", "wes##2##1");
            intent.putExtra("KPublisherId", "wes##2##1");
            intent.putExtra("preChatTYPE", 10);
            c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(125984);
            return true;
        } else {
            AppMethodBeat.o(125984);
            return false;
        }
    }
}
