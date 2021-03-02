package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.modelsimple.ae;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.updater.a.a;
import com.tencent.mm.plugin.updater.a.b;
import com.tencent.mm.pluginsdk.i.c;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.bwo;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSummaryPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.tools.v;
import com.tencent.tav.coremedia.TimeUtil;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@i
public class SettingsAboutMicroMsgUI extends MMPreference implements com.tencent.mm.ak.i {
    private boolean Dar = false;
    private bwo Das;
    private int Dat = 0;
    Intent Dau = null;
    private ProgressDialog Dav;
    private MTimerHandler Daw;
    private com.tencent.mm.ak.i Dax = null;
    private b Day = new b() {
        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.AnonymousClass7 */

        @Override // com.tencent.mm.plugin.updater.a.b
        public final void uq(boolean z) {
            AppMethodBeat.i(256506);
            if (z) {
                SettingsAboutMicroMsgUI.h(SettingsAboutMicroMsgUI.this);
            }
            AppMethodBeat.o(256506);
        }
    };
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingsAboutMicroMsgUI() {
        AppMethodBeat.i(256507);
        AppMethodBeat.o(256507);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.ce;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public View getBottomView() {
        AppMethodBeat.i(74029);
        LinearLayout linearLayout = (LinearLayout) aa.jQ(getContext()).inflate(R.layout.bqk, (ViewGroup) null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.ijk);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.ijj);
        TextView textView3 = (TextView) linearLayout.findViewById(R.id.iji);
        String obj = g.aAh().azQ().get(274436, "").toString();
        if (Util.isNullOrNil(obj)) {
            obj = LocaleUtil.getCurrentCountryCode();
        }
        if (!Util.isNullOrNil(obj) && !Util.isAllAlpha(obj)) {
            obj = "";
        }
        String string = getString(R.string.ee8, new Object[]{LocaleUtil.getApplicationLanguage(), obj, "setting", 0, 0});
        String string2 = getString(R.string.htp, new Object[]{LocaleUtil.getApplicationLanguage(), obj});
        String string3 = getString(R.string.ee0, new Object[]{LocaleUtil.getApplicationLanguage(), obj});
        textView.setText(String.format("<a href='%s'>%s</a>", string2, getString(R.string.ee3)));
        textView2.setText(String.format("<a href='%s'>%s</a>", string, getString(R.string.fp8)));
        textView3.setText(String.format("<a href='%s'>%s</a>", string3, getString(R.string.edz)));
        l.p(textView, 1);
        l.p(textView2, 1);
        l.p(textView3, 1);
        if (obj.equalsIgnoreCase("KR")) {
            textView3.setVisibility(0);
        }
        TextView textView4 = (TextView) linearLayout.findViewById(R.id.bg5);
        int i2 = TXLiteAVCode.EVT_VIDEO_DECODER_CACHE_TOO_MANY_FRAMES;
        try {
            Date parse = new SimpleDateFormat(TimeUtil.YYYY2MM2DD_HH1MM1SS).parse(BuildInfo.TIME);
            Calendar instance = Calendar.getInstance();
            instance.setTime(parse);
            i2 = instance.get(1);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SettingsAboutMicroMsgUI", e2, "", new Object[0]);
        }
        textView4.setText(linearLayout.getResources().getString(R.string.tb, Integer.valueOf(i2)));
        AppMethodBeat.o(74029);
        return linearLayout;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74030);
        super.onCreate(bundle);
        hideActionbarLine();
        initView();
        g.azz().a(11, this);
        if (d.elq() != null) {
            g.azz().a((q) d.elq().elp(), 0);
            h.INSTANCE.idkeyStat(405, 15, 1, true);
        }
        ((a) g.ah(a.class)).addManualCheckUpdateListener(this.Day);
        AppMethodBeat.o(74030);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(74031);
        super.onResume();
        eST();
        AppMethodBeat.o(74031);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(74032);
        ((a) g.ah(a.class)).removeManualCheckUpdateListener(this.Day);
        g.azz().b(11, this);
        super.onDestroy();
        AppMethodBeat.o(74032);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(74033);
        setMMTitle("");
        setActionbarColor(getContext().getResources().getColor(R.color.f3045c));
        setBackGroundColorResource(R.color.afz);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74019);
                SettingsAboutMicroMsgUI.this.hideVKB();
                SettingsAboutMicroMsgUI.this.finish();
                AppMethodBeat.o(74019);
                return true;
            }
        });
        if (getListView() != null) {
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ce);
            getListView().setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            getListView().setBackgroundColor(getContext().getResources().getColor(R.color.f3045c));
        }
        eST();
        AppMethodBeat.o(74033);
    }

    private void eST() {
        String formatVersion;
        boolean z;
        AppMethodBeat.i(164132);
        this.screen = getPreferenceScreen();
        this.screen.removeAll();
        this.screen.addPreferencesFromResource(R.xml.ce);
        SettingsAboutMMHeaderPreference settingsAboutMMHeaderPreference = (SettingsAboutMMHeaderPreference) this.screen.bmg("settings_about_mm_header");
        if (com.tencent.mm.protocal.d.KyO < 671088896 || com.tencent.mm.protocal.d.KyO > 671089151) {
            formatVersion = ChannelUtil.formatVersion(getContext(), com.tencent.mm.protocal.d.KyO);
        } else {
            formatVersion = "8.0.1";
        }
        if (com.tencent.mm.protocal.d.KyR || BuildInfo.IS_FLAVOR_BLUE) {
            formatVersion = formatVersion + " " + com.tencent.mm.cc.h.jr(this);
        }
        settingsAboutMMHeaderPreference.Dak = formatVersion;
        if (LocaleUtil.isSimplifiedChineseAppLang()) {
            int nullAsNil = Util.nullAsNil((Integer) g.aAh().azQ().get(12304, (Object) null));
            IconPreference iconPreference = (IconPreference) this.screen.bmg("settings_update");
            if (nullAsNil > 0) {
                iconPreference.alD(0);
                iconPreference.gY(String.valueOf(nullAsNil), v.aQ(getContext(), nullAsNil));
            } else {
                iconPreference.alD(8);
                iconPreference.gY("", -1);
            }
        }
        if ((ChannelUtil.updateMode & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.Dar && !ChannelUtil.isNokiaAol) {
            IconSummaryPreference iconSummaryPreference = (IconSummaryPreference) this.screen.bmg("funtion_update");
            iconSummaryPreference.CZl = 0;
            String formatVersion2 = ChannelUtil.formatVersion(null, this.Dat);
            iconSummaryPreference.bmk(getString(R.string.x4));
            iconSummaryPreference.setSummary(formatVersion2);
            iconSummaryPreference.gLH();
            this.screen.bmi("funtion_check_update");
        } else if (((a) g.ah(a.class)).hasCheckUpdateTabRedDot()) {
            IconSummaryPreference iconSummaryPreference2 = (IconSummaryPreference) this.screen.bmg("funtion_update");
            iconSummaryPreference2.CZl = 0;
            String formatVersion3 = ChannelUtil.formatVersion(null, ((a) g.ah(a.class)).getUpdateVersion());
            iconSummaryPreference2.bmk(getString(R.string.x4));
            iconSummaryPreference2.setSummary(formatVersion3);
            iconSummaryPreference2.gLH();
            this.screen.bmi("funtion_check_update");
        } else if (z || this.Das == null || this.Das.Mcs == 0 || Util.isNullOrNil(this.Das.Mct) || ChannelUtil.isNokiaAol) {
            this.screen.bmi("funtion_update");
        } else {
            Log.i("MicroMsg.SettingsAboutMicroMsgUI", "show alpha update. url:%s, hint:%d", this.Das.Mct, Integer.valueOf(this.Das.Mcu));
            if (this.Das.Mcu != 0) {
                IconSummaryPreference iconSummaryPreference3 = (IconSummaryPreference) this.screen.bmg("funtion_update");
                iconSummaryPreference3.CZl = 0;
                iconSummaryPreference3.bmk(getString(R.string.x4));
                this.screen.bmi("funtion_check_update");
            } else {
                this.screen.bmi("funtion_update");
            }
        }
        if (!LocaleUtil.isSimplifiedChineseAppLang()) {
            this.screen.m38do("settings_report", true);
        }
        if (!c.JYn.Xl()) {
            this.screen.m38do("funtion_about_wechat", true);
        }
        if (!Util.isNullOrNil((String) g.aAh().azQ().get(ar.a.USERINFO_CROWDTEST_APPLY_LINK_STRING, (Object) null))) {
            IconPreference iconPreference2 = (IconPreference) this.screen.bmg("funtion_crowdtest_update");
            if (com.tencent.mm.y.c.axV().cP(262157, 266263)) {
                iconPreference2.alF(0);
            }
        } else {
            this.screen.bmi("funtion_crowdtest_update");
        }
        if (!BuildInfo.IS_FLAVOR_BLUE) {
            this.screen.m38do("funtion_about_flavor_blue", true);
            this.screen.m38do("funtion_invite_flavor_blue", true);
        } else {
            IconPreference iconPreference3 = (IconPreference) this.screen.bmg("funtion_about_flavor_blue");
            if (com.tencent.mm.y.c.axV().cP(262164, 266270)) {
                iconPreference3.alF(0);
            }
        }
        if (WeChatBrands.Business.Entries.MeSetAboutIntros.banned()) {
            this.screen.bmi("settings_update");
        }
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(164132);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0099, code lost:
        if (com.tencent.mm.kernel.g.aAf().azp() == false) goto L_0x009b;
     */
    @Override // com.tencent.mm.ak.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int r6, int r7, java.lang.String r8, com.tencent.mm.ak.q r9) {
        /*
        // Method dump skipped, instructions count: 200
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        String str;
        String str2;
        AppMethodBeat.i(74035);
        String str3 = preference.mKey;
        Log.i("MicroMsg.SettingsAboutMicroMsgUI", str3 + " item has been clicked!");
        Log.i("MicroMsg.SettingsAboutMicroMsgUI", str3 + " item has been clicked!");
        Log.i("MicroMsg.SettingsAboutMicroMsgUI", str3 + " item has been clicked!");
        if (str3.equals("settings_update")) {
            if (LocaleUtil.isSimplifiedChineseAppLang()) {
                g.aAf();
                String string = getString(R.string.gv4, new Object[]{Integer.valueOf(com.tencent.mm.kernel.a.getUin()), Integer.valueOf(Util.nullAsNil((Integer) g.aAh().azQ().get(12304, (Object) null)))});
                if (string == null) {
                    AppMethodBeat.o(74035);
                    return true;
                }
                g.aAh().azQ().set(12304, (Object) 0);
                Intent intent = new Intent();
                intent.putExtra("title", getString(R.string.gv3));
                intent.putExtra("rawUrl", string);
                intent.putExtra("showShare", false);
                com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(74035);
                return true;
            }
            if (LocaleUtil.isSimplifiedChineseAppLang()) {
                str2 = getString(R.string.gp5, new Object[]{LocaleUtil.getApplicationLanguage(), Integer.valueOf(com.tencent.mm.protocal.d.KyO)});
            } else {
                str2 = HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1f) + FilePathGenerator.ANDROID_DIR_SEP;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("rawUrl", str2);
            intent2.putExtra("showShare", false);
            intent2.putExtra("show_bottom", false);
            com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", intent2);
            AppMethodBeat.o(74035);
            return true;
        } else if (str3.equals("funtion_update")) {
            h.INSTANCE.idkeyStat(405, 16, 1, true);
            Intent intent3 = new Intent();
            intent3.putExtra("showShare", true);
            intent3.putExtra("show_bottom", false);
            if (this.Dar) {
                str = getString(R.string.gp6, new Object[]{LocaleUtil.getApplicationLanguage(), Integer.valueOf(this.Dat), 1});
            } else if (((a) g.ah(a.class)).hasCheckUpdateTabRedDot()) {
                str = getString(R.string.gp6, new Object[]{LocaleUtil.getApplicationLanguage(), Integer.valueOf(((a) g.ah(a.class)).getUpdateVersion()), 1});
                intent3.putExtra("showShare", false);
            } else if (this.Das == null || this.Das.Mcs == 0 || Util.isNullOrNil(this.Das.Mct)) {
                str = "";
            } else {
                str = this.Das.Mct;
            }
            intent3.putExtra("rawUrl", str);
            com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", intent3);
            ((a) g.ah(a.class)).clickCheckUpdateRedDot();
            AppMethodBeat.o(74035);
            return true;
        } else if (str3.equals("funtion_check_update")) {
            h.INSTANCE.idkeyStat(405, 17, 1, true);
            if (((a) g.ah(a.class)).openUpdater()) {
                ((a) g.ah(a.class)).manualCheckUpdate(0);
                AppMethodBeat.o(74035);
                return true;
            }
            if (d.elq() != null) {
                d.elq().elo();
                if ((ChannelUtil.updateMode & 1) != 0) {
                    Log.e("MicroMsg.SettingsAboutMicroMsgUI", "package has set external update mode");
                    Uri parse = Uri.parse(ChannelUtil.marketURL);
                    Intent addFlags = new Intent("android.intent.action.VIEW", parse).addFlags(268435456);
                    if (parse == null || addFlags == null || !Util.isIntentAvailable(getContext(), addFlags)) {
                        Log.e("MicroMsg.SettingsAboutMicroMsgUI", "parse market uri failed, jump to weixin.qq.com");
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.intent.action.VIEW", Uri.parse(e.OyP)).addFlags(268435456));
                        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMicroMsgUI", "setUpdate", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMicroMsgUI", "setUpdate", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        h.INSTANCE.idkeyStat(405, 18, 1, true);
                    } else {
                        Log.i("MicroMsg.SettingsAboutMicroMsgUI", "parse market uri ok");
                        com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(addFlags);
                        com.tencent.mm.hellhoundlib.a.a.a(this, bl2.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMicroMsgUI", "setUpdate", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        startActivity((Intent) bl2.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMicroMsgUI", "setUpdate", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        h.INSTANCE.idkeyStat(405, 19, 1, true);
                    }
                    AppMethodBeat.o(74035);
                    return true;
                } else if (this.Das == null || this.Das.Mcs == 0 || Util.isNullOrNil(this.Das.Mct)) {
                    MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", Util.nowSecond()).commit();
                    com.tencent.mm.plugin.p.a c2 = d.elq().c(this, new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.AnonymousClass6 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(74028);
                            h.INSTANCE.idkeyStat(405, 23, 1, true);
                            AppMethodBeat.o(74028);
                        }
                    });
                    if (c2 == null) {
                        h.INSTANCE.idkeyStat(405, 21, 1, true);
                    } else {
                        h.INSTANCE.idkeyStat(405, 22, 1, true);
                        c2.update(3);
                        AppMethodBeat.o(74035);
                        return true;
                    }
                } else {
                    String str4 = this.Das.Mct;
                    Intent intent4 = new Intent();
                    intent4.putExtra("rawUrl", str4);
                    intent4.putExtra("showShare", false);
                    intent4.putExtra("show_bottom", false);
                    com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", intent4);
                    h.INSTANCE.idkeyStat(405, 20, 1, true);
                    AppMethodBeat.o(74035);
                    return true;
                }
            }
            AppMethodBeat.o(74035);
            return false;
        } else if (str3.equals("funtion_about_wechat")) {
            Intent intent5 = new Intent();
            intent5.putExtra("from_about", true);
            com.tencent.mm.br.c.b(this, "whatsnew", ".ui.WhatsNewUI", intent5);
            AppMethodBeat.o(74035);
            return true;
        } else if (str3.equals("settings_report")) {
            Intent intent6 = new Intent();
            intent6.putExtra("showShare", false);
            intent6.putExtra("show_feedback", false);
            intent6.putExtra("rawUrl", HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2f) + "/security/readtemplate?t=complaints/index");
            com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", intent6);
            AppMethodBeat.o(74035);
            return true;
        } else if (str3.equals("settings_quit_wechat")) {
            com.tencent.mm.ui.base.h.a(getContext(), (int) R.string.ev_, (int) R.string.ev9, (int) R.string.a0_, (int) R.string.x6, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.AnonymousClass2 */
                private MTimerHandler jer = null;
                private com.tencent.mm.ak.i onSceneEndCallback = null;

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    String str;
                    AppMethodBeat.i(74023);
                    com.tencent.mm.modelstat.c.bgb().commitNow();
                    ((com.tencent.mm.plugin.expt.b.e) g.af(com.tencent.mm.plugin.expt.b.e.class)).logout();
                    g.aAi();
                    if (com.tencent.mm.kernel.a.qd(g.aAf().hpS)) {
                        t azz = g.azz();
                        AnonymousClass1 r2 = new com.tencent.mm.ak.i() {
                            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.AnonymousClass2.AnonymousClass1 */

                            @Override // com.tencent.mm.ak.i
                            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                                AppMethodBeat.i(74020);
                                g.azz().b(281, AnonymousClass2.this.onSceneEndCallback);
                                AnonymousClass2.this.onSceneEndCallback = null;
                                if (AnonymousClass2.this.jer != null) {
                                    AnonymousClass2.this.jer.stopTimer();
                                    AnonymousClass2.this.jer = null;
                                }
                                if (SettingsAboutMicroMsgUI.this.Dav != null) {
                                    SettingsAboutMicroMsgUI.this.Dav.dismiss();
                                }
                                SettingsAboutMicroMsgUI.b(SettingsAboutMicroMsgUI.this);
                                AppMethodBeat.o(74020);
                            }
                        };
                        this.onSceneEndCallback = r2;
                        azz.a(281, r2);
                        final ae aeVar = new ae(2);
                        g.azz().a(aeVar, 0);
                        this.jer = new MTimerHandler(new MTimerHandler.CallBack() {
                            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.AnonymousClass2.AnonymousClass2 */

                            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                            public final boolean onTimerExpired() {
                                AppMethodBeat.i(74021);
                                g.azz().a(aeVar);
                                g.azz().b(281, AnonymousClass2.this.onSceneEndCallback);
                                AnonymousClass2.this.onSceneEndCallback = null;
                                if (AnonymousClass2.this.jer != null) {
                                    AnonymousClass2.this.jer.stopTimer();
                                    AnonymousClass2.this.jer = null;
                                }
                                if (SettingsAboutMicroMsgUI.this.Dav != null) {
                                    SettingsAboutMicroMsgUI.this.Dav.dismiss();
                                }
                                SettingsAboutMicroMsgUI.b(SettingsAboutMicroMsgUI.this);
                                AppMethodBeat.o(74021);
                                return false;
                            }
                        }, false);
                        this.jer.startTimer(5000);
                        o oVar = (o) g.af(o.class);
                        String string = SettingsAboutMicroMsgUI.this.getString(R.string.j19);
                        if (!Util.isNullOrNil(oVar.beO())) {
                            str = oVar.beO() + "...";
                        } else {
                            str = string;
                        }
                        SettingsAboutMicroMsgUI settingsAboutMicroMsgUI = SettingsAboutMicroMsgUI.this;
                        AppCompatActivity context = SettingsAboutMicroMsgUI.this.getContext();
                        SettingsAboutMicroMsgUI.this.getString(R.string.zb);
                        settingsAboutMicroMsgUI.Dav = com.tencent.mm.ui.base.h.a((Context) context, str, true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.AnonymousClass2.AnonymousClass3 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(74022);
                                g.azz().a(aeVar);
                                g.azz().b(281, AnonymousClass2.this.onSceneEndCallback);
                                AnonymousClass2.this.onSceneEndCallback = null;
                                if (AnonymousClass2.this.jer != null) {
                                    AnonymousClass2.this.jer.stopTimer();
                                    AnonymousClass2.this.jer = null;
                                }
                                if (SettingsAboutMicroMsgUI.this.Dav != null) {
                                    SettingsAboutMicroMsgUI.this.Dav.dismiss();
                                }
                                AppMethodBeat.o(74022);
                            }
                        });
                        AppMethodBeat.o(74023);
                        return;
                    }
                    SettingsAboutMicroMsgUI.b(SettingsAboutMicroMsgUI.this);
                    AppMethodBeat.o(74023);
                }
            }, (DialogInterface.OnClickListener) null);
            AppMethodBeat.o(74035);
            return true;
        } else if (str3.equals("funtion_crowdtest_update")) {
            com.tencent.mm.y.c.axV().cQ(262157, 266263);
            Intent intent7 = new Intent();
            intent7.putExtra("rawUrl", (String) g.aAh().azQ().get(ar.a.USERINFO_CROWDTEST_APPLY_LINK_STRING, (Object) null));
            intent7.putExtra("showShare", false);
            intent7.putExtra("show_bottom", false);
            com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", intent7);
            AppMethodBeat.o(74035);
            return true;
        } else {
            if (str3.equals("funtion_about_flavor_blue")) {
                com.tencent.mm.y.c.axV().cQ(262164, 266270);
                com.tencent.mm.y.c.axV().B(262164, false);
                AppCompatActivity context = getContext();
                com.tencent.mm.hellhoundlib.b.a bl3 = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(this, SettingsAboutMicroMsgFlavorBlue.class));
                com.tencent.mm.hellhoundlib.a.a.a(context, bl3.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMicroMsgUI", "showFlavorBlueActivity", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl3.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutMicroMsgUI", "showFlavorBlueActivity", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            } else if (str3.equals("funtion_invite_flavor_blue")) {
                Intent intent8 = new Intent();
                intent8.putExtra("title", getString(R.string.dl9));
                intent8.putExtra("rawUrl", "https://mp.weixin.qq.com/wxawap/devwxsubscribe#wechat_redirect");
                intent8.putExtra("showShare", false);
                intent8.putExtra("show_bottom", false);
                com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", intent8);
            }
            AppMethodBeat.o(74035);
            return false;
        }
    }

    static /* synthetic */ void b(SettingsAboutMicroMsgUI settingsAboutMicroMsgUI) {
        AppMethodBeat.i(74037);
        t azz = g.azz();
        AnonymousClass3 r2 = new com.tencent.mm.ak.i() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.AnonymousClass3 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(final int i2, final int i3, String str, final q qVar) {
                AppMethodBeat.i(74025);
                Log.d("MicroMsg.SettingsAboutMicroMsgUI", "onSceneEnd " + i2 + " errCode " + i3 + " errMsg " + str + "  " + qVar.getType());
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(74024);
                        g.azz().b(255, SettingsAboutMicroMsgUI.this.Dax);
                        SettingsAboutMicroMsgUI.this.Dax = null;
                        if (SettingsAboutMicroMsgUI.this.Daw != null) {
                            SettingsAboutMicroMsgUI.this.Daw.stopTimer();
                            SettingsAboutMicroMsgUI.this.Daw = null;
                        }
                        if (SettingsAboutMicroMsgUI.this.Dav != null) {
                            SettingsAboutMicroMsgUI.this.Dav.dismiss();
                        }
                        if (qVar.getType() == 255 && ((u) qVar).jkg == 1) {
                            if (i3 == -3 && i2 == 4) {
                                Intent intent = new Intent(SettingsAboutMicroMsgUI.this.getContext(), RegByMobileSetPwdUI.class);
                                intent.putExtra("kintent_hint", SettingsAboutMicroMsgUI.this.getString(R.string.fzz));
                                SettingsAboutMicroMsgUI.this.startActivityForResult(intent, 0);
                                AppMethodBeat.o(74024);
                                return;
                            }
                            SettingsAboutMicroMsgUI.g(SettingsAboutMicroMsgUI.this);
                        }
                        AppMethodBeat.o(74024);
                    }
                });
                AppMethodBeat.o(74025);
            }
        };
        settingsAboutMicroMsgUI.Dax = r2;
        azz.a(255, r2);
        final u uVar = new u(2);
        uVar.jkg = 1;
        g.azz().a(uVar, 0);
        settingsAboutMicroMsgUI.Daw = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.AnonymousClass4 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(74026);
                g.azz().a(uVar);
                g.azz().b(255, SettingsAboutMicroMsgUI.this.Dax);
                SettingsAboutMicroMsgUI.this.Dax = null;
                if (SettingsAboutMicroMsgUI.this.Daw != null) {
                    SettingsAboutMicroMsgUI.this.Daw.stopTimer();
                    SettingsAboutMicroMsgUI.this.Daw = null;
                }
                if (SettingsAboutMicroMsgUI.this.Dav != null) {
                    SettingsAboutMicroMsgUI.this.Dav.cancel();
                }
                SettingsAboutMicroMsgUI.g(SettingsAboutMicroMsgUI.this);
                AppMethodBeat.o(74026);
                return false;
            }
        }, false);
        settingsAboutMicroMsgUI.Daw.startTimer(3000);
        AppCompatActivity context = settingsAboutMicroMsgUI.getContext();
        settingsAboutMicroMsgUI.getString(R.string.zb);
        settingsAboutMicroMsgUI.Dav = com.tencent.mm.ui.base.h.a((Context) context, settingsAboutMicroMsgUI.getString(R.string.j5d), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.AnonymousClass5 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(74027);
                g.azz().a(uVar);
                g.azz().b(255, SettingsAboutMicroMsgUI.this.Dax);
                SettingsAboutMicroMsgUI.this.Dax = null;
                if (SettingsAboutMicroMsgUI.this.Daw != null) {
                    SettingsAboutMicroMsgUI.this.Daw.stopTimer();
                    SettingsAboutMicroMsgUI.this.Daw = null;
                }
                if (SettingsAboutMicroMsgUI.this.Dav != null) {
                    SettingsAboutMicroMsgUI.this.Dav.dismiss();
                }
                AppMethodBeat.o(74027);
            }
        });
        AppMethodBeat.o(74037);
    }

    static /* synthetic */ void g(SettingsAboutMicroMsgUI settingsAboutMicroMsgUI) {
        AppMethodBeat.i(74038);
        MMEntryLock.unlock("welcome_page_show");
        com.tencent.mm.kernel.l.s(settingsAboutMicroMsgUI, true);
        com.tencent.mm.plugin.setting.c.jRu.Xc();
        ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().alb();
        c.JYn.bV(settingsAboutMicroMsgUI.getContext());
        settingsAboutMicroMsgUI.finish();
        AppMethodBeat.o(74038);
    }

    static /* synthetic */ void h(SettingsAboutMicroMsgUI settingsAboutMicroMsgUI) {
        AppMethodBeat.i(256508);
        settingsAboutMicroMsgUI.eST();
        AppMethodBeat.o(256508);
    }
}
