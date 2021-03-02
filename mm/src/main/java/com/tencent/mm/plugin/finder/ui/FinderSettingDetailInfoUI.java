package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.e;
import com.tencent.mm.loader.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.cgi.cd;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.x;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.app;
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.protocal.protobuf.azn;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.HeadImgNewPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.u;
import java.util.HashMap;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\"\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\u0012\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0014J\u0018\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H\u0016J\u001c\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020\u0015H\u0014J,\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\b\u0010.\u001a\u0004\u0018\u00010\f2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020\u0015H\u0002J\b\u00102\u001a\u00020\u0015H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u00063"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderSettingDetailInfoUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "REQUEST_CODE_CROP_AVATAR", "", "REQUEST_CODE_SELECT_AVATAR", "REQUEST_DISTRICT", "REQUEST_SEX", "TAG", "", "myFinderUser", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "progressDialog", "Landroid/app/ProgressDialog;", "self", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "doPrepareUser", "", "getResourceId", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showProgress", "updateView", "plugin-finder_release"})
public class FinderSettingDetailInfoUI extends MMPreference implements i, ai<azg> {
    private final String TAG = "Finder.FinderSettingDetailInfoUI";
    private HashMap _$_findViewCache;
    private bed udb;
    private ProgressDialog vIA;
    private final int vIw = 1000;
    private final int vIx = 1001;
    private final int vOj = 1002;
    private final int vOk = 1003;
    private String vOl;
    private g vOm;

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252666);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252666);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252665);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252665);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.protocal.protobuf.apg] */
    @Override // com.tencent.mm.plugin.i.a.ai
    public final /* synthetic */ void a(azg azg, apg apg) {
        AppMethodBeat.i(167606);
        p.h(azg, "req");
        p.h(apg, "ret");
        ProgressDialog progressDialog = this.vIA;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        if (apg.retCode == 0) {
            u.makeText(this, getString(R.string.daz), 0).show();
            doPrepareUser();
            AppMethodBeat.o(167606);
            return;
        }
        u.makeText(this, getString(R.string.dax), 0).show();
        AppMethodBeat.o(167606);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(167601);
        super.onCreate(bundle);
        this.vOl = z.aUg();
        Log.i(this.TAG, "myFinderUser " + this.vOl);
        setMMTitle(R.string.d9b);
        setBackBtn(new a(this));
        com.tencent.mm.kernel.g.azz().a(3761, this);
        AppMethodBeat.o(167601);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class a implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderSettingDetailInfoUI vOn;

        a(FinderSettingDetailInfoUI finderSettingDetailInfoUI) {
            this.vOn = finderSettingDetailInfoUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(167598);
            this.vOn.finish();
            AppMethodBeat.o(167598);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(167602);
        super.onResume();
        doPrepareUser();
        updateView();
        AppMethodBeat.o(167602);
    }

    private static void doPrepareUser() {
        AppMethodBeat.i(167603);
        com.tencent.mm.kernel.g.azz().b(new cd(2));
        AppMethodBeat.o(167603);
    }

    private final void updateView() {
        boolean z;
        app app;
        app app2;
        FinderAuthInfo finderAuthInfo;
        String str;
        AppMethodBeat.i(167604);
        c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
        this.vOm = c.a.asG(Util.nullAsNil(this.vOl));
        if (this.vOm == null) {
            finish();
            AppMethodBeat.o(167604);
            return;
        }
        Preference bmg = getPreferenceScreen().bmg("settings_avatar");
        if (bmg == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.HeadImgNewPreference");
            AppMethodBeat.o(167604);
            throw tVar;
        }
        HeadImgNewPreference headImgNewPreference = (HeadImgNewPreference) bmg;
        headImgNewPreference.a(new b(this));
        headImgNewPreference.gLE();
        headImgNewPreference.bmf(this.vOl);
        headImgNewPreference.h(new c(this));
        Preference bmg2 = getPreferenceScreen().bmg("settings_nickname");
        bmg2.gLS();
        e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_PREPARE_USER_FLAG_INT_SYNC, 0);
        Log.i(this.TAG, "userFlag %d", Integer.valueOf(i2));
        if ((i2 & 2) == 0 || this.udb == null) {
            p.g(bmg2, "prefNickname");
            FinderSettingDetailInfoUI finderSettingDetailInfoUI = this;
            g gVar = this.vOm;
            if (gVar == null) {
                p.hyc();
            }
            bmg2.setSummary(com.tencent.mm.pluginsdk.ui.span.l.c(finderSettingDetailInfoUI, gVar.getNickname()));
        } else {
            p.g(bmg2, "prefNickname");
            FinderSettingDetailInfoUI finderSettingDetailInfoUI2 = this;
            Object[] objArr = new Object[1];
            bed bed = this.udb;
            if (bed == null) {
                p.hyc();
            }
            azn azn = bed.verifyInfo;
            if (azn == null || (str = azn.LJq) == null) {
                str = "";
            }
            objArr[0] = str;
            bmg2.setSummary(com.tencent.mm.pluginsdk.ui.span.l.c(finderSettingDetailInfoUI2, getString(R.string.d3c, objArr)));
        }
        Preference bmg3 = getPreferenceScreen().bmg("settings_signature");
        bmg3.gLS();
        p.g(bmg3, "prefSignature");
        FinderSettingDetailInfoUI finderSettingDetailInfoUI3 = this;
        g gVar2 = this.vOm;
        if (gVar2 == null) {
            p.hyc();
        }
        bmg3.setSummary(com.tencent.mm.pluginsdk.ui.span.l.c(finderSettingDetailInfoUI3, gVar2.field_signature));
        Preference bmg4 = getPreferenceScreen().bmg("settings_sex");
        g gVar3 = this.vOm;
        if (gVar3 == null || (finderAuthInfo = gVar3.field_authInfo) == null || finderAuthInfo.authIconType != 2) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            p.g(bmg4, "prefSex");
            bmg4.setSummary(getString(R.string.d9h));
            bmg4.alO(8);
            bmg4.setEnabled(false);
        } else {
            g gVar4 = this.vOm;
            if (gVar4 == null || (app = gVar4.field_extInfo) == null) {
                p.g(bmg4, "prefSex");
                bmg4.setSummary("");
            } else {
                Log.i(this.TAG, "sex " + app.fuA);
                if (app.fuA == 1) {
                    p.g(bmg4, "prefSex");
                    bmg4.setSummary(getString(R.string.gxi));
                } else if (app.fuA == 2) {
                    p.g(bmg4, "prefSex");
                    bmg4.setSummary(getString(R.string.gxh));
                } else {
                    p.g(bmg4, "prefSex");
                    bmg4.setSummary("");
                }
            }
            bmg4.alO(0);
            bmg4.setEnabled(true);
        }
        e aAh2 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh2, "MMKernel.storage()");
        int i3 = aAh2.azQ().getInt(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, 0);
        Log.i(this.TAG, "updateView userExtFlag:".concat(String.valueOf(i3)));
        Preference bmg5 = getPreferenceScreen().bmg("settings_district");
        if ((i3 & 4) > 0) {
            g gVar5 = this.vOm;
            if (!(gVar5 == null || (app2 = gVar5.field_extInfo) == null)) {
                Log.i(this.TAG, "countryCode " + app2.country + " provinceCode " + app2.fuJ + " cityCode " + app2.fuK);
                RegionCodeDecoder.gEm();
                String country = RegionCodeDecoder.getCountry(app2.country);
                RegionCodeDecoder.gEm();
                String mV = RegionCodeDecoder.mV(app2.country, app2.fuJ);
                RegionCodeDecoder.gEm();
                String br = RegionCodeDecoder.br(app2.country, app2.fuJ, app2.fuK);
                if (!Util.isNullOrNil(br)) {
                    p.g(bmg5, "prefDistrict");
                    bmg5.setSummary(((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.b.class)).It(mV) + " " + br);
                } else if (!Util.isNullOrNil(mV)) {
                    p.g(bmg5, "prefDistrict");
                    bmg5.setSummary(country + ' ' + mV);
                } else if (!Util.isNullOrNil(country)) {
                    p.g(bmg5, "prefDistrict");
                    bmg5.setSummary(country);
                } else {
                    p.g(bmg5, "prefDistrict");
                    bmg5.setSummary("");
                }
            }
        } else {
            p.g(bmg5, "prefDistrict");
            bmg5.setSummary("");
        }
        getPreferenceScreen().notifyDataSetChanged();
        AppMethodBeat.o(167604);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderSettingDetailInfoUI$updateView$1", "Lcom/tencent/mm/ui/base/preference/HeadImgNewPreference$IAvatarLoaderEx;", "loadAvatar", "", ch.COL_USERNAME, "", "icon", "Landroid/widget/ImageView;", "isRound", "", "plugin-finder_release"})
    public static final class b implements HeadImgNewPreference.a {
        final /* synthetic */ FinderSettingDetailInfoUI vOn;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(FinderSettingDetailInfoUI finderSettingDetailInfoUI) {
            this.vOn = finderSettingDetailInfoUI;
        }

        @Override // com.tencent.mm.ui.base.preference.HeadImgNewPreference.a
        public final void b(String str, ImageView imageView) {
            AppMethodBeat.i(167599);
            p.h(str, ch.COL_USERNAME);
            p.h(imageView, "icon");
            if (this.vOn.vOm == null) {
                Log.e(this.vOn.TAG, "error self contact is null");
                AppMethodBeat.o(167599);
                return;
            }
            m mVar = m.uJa;
            d<o> dka = m.dka();
            g gVar = this.vOn.vOm;
            if (gVar == null) {
                p.hyc();
            }
            com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(gVar.field_avatarUrl);
            m mVar2 = m.uJa;
            dka.a(aVar, imageView, m.a(m.a.AVATAR));
            AppMethodBeat.o(167599);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ FinderSettingDetailInfoUI vOn;

        c(FinderSettingDetailInfoUI finderSettingDetailInfoUI) {
            this.vOn = finderSettingDetailInfoUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(167600);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSettingDetailInfoUI$updateView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.vOn.vOl != null) {
                Intent intent = new Intent();
                String[] strArr = new String[1];
                g gVar = this.vOn.vOm;
                if (gVar == null) {
                    p.hyc();
                }
                strArr[0] = gVar.cXH();
                intent.putStringArrayListExtra("key_url_list", j.ac(strArr));
                intent.putExtra("key_preview_avatar", true);
                com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.M(this.vOn, intent);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSettingDetailInfoUI$updateView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(167600);
        }
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.b6;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        String str;
        String str2;
        app app;
        String str3;
        app app2;
        String str4;
        String str5;
        app app3;
        app app4;
        int i2 = 0;
        AppMethodBeat.i(167605);
        if (preference == null) {
            p.hyc();
        }
        String key = preference.getKey();
        Log.i(this.TAG, "click ".concat(String.valueOf(key)));
        if (key != null) {
            switch (key.hashCode()) {
                case -1298291467:
                    if (key.equals("settings_avatar")) {
                        com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
                        if (!com.tencent.mm.plugin.finder.spam.a.avp("personalInfo")) {
                            s.o(this, this.vIw);
                            break;
                        }
                    }
                    break;
                case 281722780:
                    if (key.equals("settings_signature")) {
                        Intent intent = new Intent();
                        intent.putExtra("key_scene", 2);
                        com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                        com.tencent.mm.plugin.finder.utils.a.N(this, intent);
                        break;
                    }
                    break;
                case 460789002:
                    if (key.equals("settings_nickname")) {
                        if (this.udb == null) {
                            doPrepareUser();
                            break;
                        } else {
                            e aAh = com.tencent.mm.kernel.g.aAh();
                            p.g(aAh, "MMKernel.storage()");
                            int i3 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_PREPARE_USER_FLAG_INT_SYNC, 0);
                            Log.i(this.TAG, "userFlag %d", Integer.valueOf(i3));
                            if ((i3 & 2) == 0) {
                                Intent intent2 = new Intent();
                                intent2.putExtra("key_scene", 1);
                                com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
                                com.tencent.mm.plugin.finder.utils.a.N(this, intent2);
                                break;
                            } else {
                                r rVar = (r) com.tencent.mm.kernel.g.af(r.class);
                                FinderSettingDetailInfoUI finderSettingDetailInfoUI = this;
                                bed bed = this.udb;
                                if (bed == null) {
                                    p.hyc();
                                }
                                azn azn = bed.verifyInfo;
                                if (azn == null || (str = azn.appName) == null) {
                                    str = "";
                                }
                                bed bed2 = this.udb;
                                if (bed2 == null) {
                                    p.hyc();
                                }
                                azn azn2 = bed2.verifyInfo;
                                if (azn2 == null || (str2 = azn2.LJp) == null) {
                                    str2 = "";
                                }
                                rVar.a(finderSettingDetailInfoUI, str, (String) null, 0, 0, str2, new AppBrandStatObject());
                                break;
                            }
                        }
                    }
                    break;
                case 534699594:
                    if (key.equals("settings_sex")) {
                        Intent intent3 = new Intent();
                        e aAh2 = com.tencent.mm.kernel.g.aAh();
                        p.g(aAh2, "MMKernel.storage()");
                        if ((aAh2.azQ().getInt(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, 0) & 8) > 0) {
                            g gVar = this.vOm;
                            if (!(gVar == null || (app = gVar.field_extInfo) == null)) {
                                i2 = app.fuA;
                            }
                            if (i2 == 1) {
                                intent3.putExtra("key_input_sex", "male");
                            } else if (i2 == 2) {
                                intent3.putExtra("key_input_sex", "female");
                            } else {
                                intent3.putExtra("key_input_sex", "");
                            }
                        } else {
                            intent3.putExtra("key_input_sex", "");
                        }
                        com.tencent.mm.plugin.finder.utils.a aVar4 = com.tencent.mm.plugin.finder.utils.a.vUU;
                        com.tencent.mm.plugin.finder.utils.a.a((MMActivity) this, intent3, this.vOk);
                        break;
                    }
                    break;
                case 679059498:
                    if (key.equals("settings_district")) {
                        Intent intent4 = new Intent();
                        intent4.putExtra("GetAddress", true);
                        intent4.putExtra("ShowSelectedLocation", true);
                        intent4.putExtra("SetSelectLocation", true);
                        e aAh3 = com.tencent.mm.kernel.g.aAh();
                        p.g(aAh3, "MMKernel.storage()");
                        if ((aAh3.azQ().getInt(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, 0) & 4) == 0) {
                            intent4.putExtra("SelectedCountryCode", "unshow");
                        } else {
                            g gVar2 = this.vOm;
                            if (gVar2 == null || (app2 = gVar2.field_extInfo) == null || (str3 = app2.country) == null) {
                                str3 = "";
                            }
                            intent4.putExtra("SelectedCountryCode", str3);
                        }
                        g gVar3 = this.vOm;
                        if (gVar3 == null || (app4 = gVar3.field_extInfo) == null || (str4 = app4.fuJ) == null) {
                            str4 = "";
                        }
                        intent4.putExtra("SelectedProvinceCode", str4);
                        g gVar4 = this.vOm;
                        if (gVar4 == null || (app3 = gVar4.field_extInfo) == null || (str5 = app3.fuK) == null) {
                            str5 = "";
                        }
                        intent4.putExtra("SelectedCityCode", str5);
                        intent4.putExtra("NeedUnshowItem", false);
                        com.tencent.mm.br.c.c(getContext(), ".ui.tools.MultiStageCitySelectUI", intent4, this.vOj);
                        break;
                    }
                    break;
            }
        }
        AppMethodBeat.o(167605);
        return true;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        Integer num = null;
        AppMethodBeat.i(167607);
        Log.i(this.TAG, "onSceneEnd errType " + i2 + ", errCode " + i3 + ", errMsg " + str + " scene " + (qVar != null ? Integer.valueOf(qVar.getType()) : null) + " scene:" + qVar);
        if (qVar != null) {
            num = Integer.valueOf(qVar.getType());
        }
        if (num == null) {
            AppMethodBeat.o(167607);
            return;
        }
        if (num.intValue() == 3761 && i2 == 0 && i3 == 0) {
            if (qVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
                AppMethodBeat.o(167607);
                throw tVar;
            }
            this.udb = ((cd) qVar).cZc();
            if (this.udb != null) {
                updateView();
            }
        }
        AppMethodBeat.o(167607);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        int i4;
        int i5;
        String str;
        int i6 = 1;
        AppMethodBeat.i(167608);
        super.onActivityResult(i2, i3, intent);
        if (i2 != this.vIw) {
            if (i2 == this.vIx) {
                if (intent != null && i3 == -1) {
                    String stringExtra = intent.getStringExtra("key_result_img_path");
                    if (Util.isNullOrNil(stringExtra) || !com.tencent.mm.vfs.s.YS(stringExtra)) {
                        Log.w(this.TAG, "no avatar set");
                        AppMethodBeat.o(167608);
                        return;
                    }
                    Log.i(this.TAG, "avatar file length %d KB", Long.valueOf(com.tencent.mm.vfs.s.boW(stringExtra) / 1024));
                    p.g(stringExtra, "avatarPath");
                    ((x) com.tencent.mm.kernel.g.af(x.class)).c(stringExtra, this);
                }
            } else if (i2 == this.vOj) {
                if (intent != null && i3 == -1) {
                    String stringExtra2 = intent.getStringExtra("Country");
                    if (stringExtra2 == null) {
                        stringExtra2 = "";
                    }
                    String stringExtra3 = intent.getStringExtra("Contact_Province");
                    if (stringExtra3 == null) {
                        stringExtra3 = "";
                    }
                    String stringExtra4 = intent.getStringExtra("Contact_City");
                    if (stringExtra4 == null) {
                        stringExtra4 = "";
                    }
                    Log.i(this.TAG, "countryCode " + stringExtra2 + " provinceCode" + stringExtra3 + " cityCode" + stringExtra4);
                    if (p.j(stringExtra2, "unshow")) {
                        e aAh = com.tencent.mm.kernel.g.aAh();
                        p.g(aAh, "MMKernel.storage()");
                        e aAh2 = com.tencent.mm.kernel.g.aAh();
                        p.g(aAh2, "MMKernel.storage()");
                        aAh2.azQ().set(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, Integer.valueOf(aAh.azQ().getInt(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, 0) & -5));
                        str = "";
                    } else {
                        i6 = 0;
                        str = stringExtra2;
                    }
                    g gVar = this.vOm;
                    if (gVar != null) {
                        app app = gVar.field_extInfo;
                        if (app != null) {
                            app.country = str;
                            app.fuJ = stringExtra3;
                            app.fuK = stringExtra4;
                        } else {
                            gVar.field_extInfo = new app();
                            gVar.field_extInfo.country = str;
                            gVar.field_extInfo.fuJ = stringExtra3;
                            gVar.field_extInfo.fuK = stringExtra4;
                        }
                        c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
                        c.a.c(gVar);
                    }
                    ((x) com.tencent.mm.kernel.g.af(x.class)).a(str, stringExtra3, stringExtra4, i6, this);
                }
            } else if (i2 == this.vOk && intent != null && i3 == -1) {
                String stringExtra5 = intent.getStringExtra("key_output_sex");
                if (stringExtra5 == null) {
                    stringExtra5 = "";
                }
                if (stringExtra5.length() > 0) {
                    e aAh3 = com.tencent.mm.kernel.g.aAh();
                    p.g(aAh3, "MMKernel.storage()");
                    int i7 = aAh3.azQ().getInt(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, 0);
                    g gVar2 = this.vOm;
                    if (gVar2 != null) {
                        switch (stringExtra5.hashCode()) {
                            case -1278174388:
                                if (stringExtra5.equals("female")) {
                                    app app2 = gVar2.field_extInfo;
                                    if (app2 != null) {
                                        app2.fuA = 2;
                                    } else {
                                        gVar2.field_extInfo = new app();
                                        gVar2.field_extInfo.fuA = 2;
                                    }
                                    c.a aVar2 = com.tencent.mm.plugin.finder.api.c.tsp;
                                    c.a.c(gVar2);
                                    e aAh4 = com.tencent.mm.kernel.g.aAh();
                                    p.g(aAh4, "MMKernel.storage()");
                                    aAh4.azQ().set(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, Integer.valueOf(i7 | 8));
                                    x xVar = (x) com.tencent.mm.kernel.g.af(x.class);
                                    app app3 = gVar2.field_extInfo;
                                    if (app3 != null) {
                                        i5 = app3.fuA;
                                    } else {
                                        i5 = 0;
                                    }
                                    xVar.a(i5, this);
                                    break;
                                }
                                AppMethodBeat.o(167608);
                                return;
                            case 3343885:
                                if (stringExtra5.equals("male")) {
                                    app app4 = gVar2.field_extInfo;
                                    if (app4 != null) {
                                        app4.fuA = 1;
                                    } else {
                                        gVar2.field_extInfo = new app();
                                        gVar2.field_extInfo.fuA = 1;
                                    }
                                    c.a aVar3 = com.tencent.mm.plugin.finder.api.c.tsp;
                                    c.a.c(gVar2);
                                    e aAh5 = com.tencent.mm.kernel.g.aAh();
                                    p.g(aAh5, "MMKernel.storage()");
                                    aAh5.azQ().set(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, Integer.valueOf(i7 | 8));
                                    x xVar2 = (x) com.tencent.mm.kernel.g.af(x.class);
                                    app app5 = gVar2.field_extInfo;
                                    if (app5 != null) {
                                        i4 = app5.fuA;
                                    } else {
                                        i4 = 0;
                                    }
                                    xVar2.a(i4, this);
                                    break;
                                }
                                AppMethodBeat.o(167608);
                                return;
                            default:
                                AppMethodBeat.o(167608);
                                return;
                        }
                    }
                }
            }
            ProgressDialog progressDialog = this.vIA;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
            this.vIA = h.a((Context) this, getString(R.string.ys), false, (DialogInterface.OnCancelListener) null);
        } else if (intent != null && i3 == -1) {
            setIntent(new Intent());
            String i8 = com.tencent.mm.ui.tools.a.i(getContext(), intent, com.tencent.mm.plugin.image.d.aSY());
            if (Util.isNullOrNil(i8) || !com.tencent.mm.vfs.s.YS(i8)) {
                Log.w(this.TAG, "no img select");
                AppMethodBeat.o(167608);
                return;
            }
            getIntent().putExtra("key_source_img_path", i8);
            com.tencent.mm.plugin.finder.utils.a aVar4 = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.b((Activity) this, getIntent(), this.vIx);
            AppMethodBeat.o(167608);
            return;
        }
        AppMethodBeat.o(167608);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(167609);
        super.onDestroy();
        com.tencent.mm.kernel.g.azz().b(3761, this);
        AppMethodBeat.o(167609);
    }
}
