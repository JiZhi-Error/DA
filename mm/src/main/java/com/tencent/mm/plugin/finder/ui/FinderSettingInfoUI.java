package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.cgi.cd;
import com.tencent.mm.plugin.finder.extension.reddot.h;
import com.tencent.mm.plugin.finder.extension.reddot.k;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI16;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.report.j;
import com.tencent.mm.plugin.finder.utils.b;
import com.tencent.mm.plugin.finder.utils.x;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.newtips.NewTipPreference;
import com.tencent.mm.protocal.protobuf.aet;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.ax;
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.protocal.protobuf.bel;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.HeadImgAndNamePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.u;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\"H\u0016J\u0006\u0010#\u001a\u00020 J\u0012\u0010$\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020 H\u0014J\u001c\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020 H\u0014J,\u0010/\u001a\u00020 2\u0006\u00100\u001a\u00020\"2\u0006\u00101\u001a\u00020\"2\b\u00102\u001a\u0004\u0018\u00010\u00052\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u00020 H\u0014J\b\u00106\u001a\u00020 H\u0002J\b\u00107\u001a\u00020 H\u0002J\u0012\u00108\u001a\u00020 2\b\b\u0002\u00109\u001a\u00020)H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderSettingInfoUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "CREATER_GUIDE_URL", "", "CREATER_GUIDE_URL_EN", "CREATER_GUIDE_URL_Traditional", "TAG", "accountExtConfig", "Lcom/tencent/mm/protocal/protobuf/AccountExtraSettingConfig;", "hasExposeOriginalTips", "loadingComponent", "Lcom/tencent/mm/plugin/finder/utils/DelayLoadingComponent;", "getLoadingComponent", "()Lcom/tencent/mm/plugin/finder/utils/DelayLoadingComponent;", "setLoadingComponent", "(Lcom/tencent/mm/plugin/finder/utils/DelayLoadingComponent;)V", "myFinderUser", "originalTag", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "profileSettingCallback", "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI$profileSettingCallback$1", "Lcom/tencent/mm/plugin/finder/ui/FinderSettingInfoUI$profileSettingCallback$1;", "profileSettingTag", "self", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "shopBindInfo", "Lcom/tencent/mm/protocal/protobuf/FinderWxAppInfo;", "shopInfo", "doPrepareUser", "", "getResourceId", "", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "resetLoading", "switchWxProfileSetting", "updateView", "isFromSceneEnd", "plugin-finder_release"})
public final class FinderSettingInfoUI extends MMPreference implements i {
    private final String TAG = "Finder.FinderSettingInfoUI";
    private HashMap _$_findViewCache;
    com.tencent.mm.plugin.finder.utils.b tux;
    private bed udb;
    private ax ueD;
    private String vOl;
    private g vOm;
    private final String vOo = "setting_original";
    private final String vOp = "settings_show_my_finder";
    private bel vOq = new bel();
    private String vOr = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1p) + "/touch/scene_product.html?scene_id=kf7428");
    private String vOs = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1p) + "/touch/scene_faq.html?scene_id=kf7467");
    private String vOt = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1p) + "/touch/scene_faq.html?scene_id=kf7468");
    private String vOu = "";
    private final c vOv = new c(this);
    private bel vcb = new bel();

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252676);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252676);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252675);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252675);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
    public static final class f<T> implements Observer<h.a> {
        final /* synthetic */ FinderSettingInfoUI vOw;

        f(FinderSettingInfoUI finderSettingInfoUI) {
            this.vOw = finderSettingInfoUI;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(h.a aVar) {
            boolean z;
            String str;
            bbn bbn;
            bbi bbi;
            AppMethodBeat.i(252668);
            h.a aVar2 = aVar;
            Preference bmg = this.vOw.getPreferenceScreen().bmg(this.vOw.vOo);
            if (bmg == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.newtips.NewTipPreference");
                AppMethodBeat.o(252668);
                throw tVar;
            }
            NewTipPreference newTipPreference = (NewTipPreference) bmg;
            if (aVar2 != null) {
                z = aVar2.dEF;
            } else {
                z = false;
            }
            newTipPreference.qW(z);
            if (aVar2 != null) {
                if (aVar2.dEF) {
                    com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                    p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
                    bdo asW = ((PluginFinder) ah).getRedDotManager().asW("OriginalEntrance");
                    com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                    p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
                    k asX = ((PluginFinder) ah2).getRedDotManager().asX("OriginalEntrance");
                    if (asX == null || (bbi = asX.field_ctrInfo) == null || (str = bbi.LKM) == null) {
                        str = "";
                    }
                    p.g(str, "ctrInfo?.field_ctrInfo?.tips_id ?: \"\"");
                    if (!p.j(str, this.vOw.vOu)) {
                        this.vOw.vOu = str;
                        if (!(asX == null || asW == null)) {
                            j jVar = j.vft;
                            FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.vOw);
                            if (fH != null) {
                                bbn = fH.dIx();
                            } else {
                                bbn = null;
                            }
                            j.a(PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT, asX, asW, 1, bbn, 0, 0, 96);
                        }
                    }
                }
                AppMethodBeat.o(252668);
                return;
            }
            AppMethodBeat.o(252668);
        }
    }

    public FinderSettingInfoUI() {
        AppMethodBeat.i(252674);
        AppMethodBeat.o(252674);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(167614);
        super.onCreate(bundle);
        this.vOl = z.aUg();
        Log.i(this.TAG, "myFinderUser " + this.vOl);
        setMMTitle(R.string.d9c);
        setBackBtn(new a(this));
        getPreferenceScreen().m38do(this.vOo, true);
        getPreferenceScreen().m38do(this.vOp, true);
        getPreferenceScreen().notifyDataSetChanged();
        com.tencent.mm.kernel.g.azz().a(3761, this);
        AppMethodBeat.o(167614);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class a implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderSettingInfoUI vOw;

        a(FinderSettingInfoUI finderSettingInfoUI) {
            this.vOw = finderSettingInfoUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(167610);
            this.vOw.finish();
            AppMethodBeat.o(167610);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public final void onResume() {
        AppMethodBeat.i(167615);
        super.onResume();
        getContentView().post(new b(this));
        com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.b(this, 1, 2);
        com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.b(this, 2, 2);
        com.tencent.mm.plugin.finder.report.k kVar3 = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.b(this, 3, 2);
        com.tencent.mm.plugin.finder.report.k kVar4 = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.b(this, 4, 2);
        com.tencent.mm.plugin.finder.report.k kVar5 = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.b(this, 5, 2);
        com.tencent.mm.kernel.g.azz().b(new cd(2));
        AppMethodBeat.o(167615);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ FinderSettingInfoUI vOw;

        b(FinderSettingInfoUI finderSettingInfoUI) {
            this.vOw = finderSettingInfoUI;
        }

        public final void run() {
            AppMethodBeat.i(167611);
            FinderSettingInfoUI.a(this.vOw);
            AppMethodBeat.o(167611);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(252669);
        com.tencent.mm.kernel.g.azz().b(3761, this);
        super.onDestroy();
        AppMethodBeat.o(252669);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        Integer num = null;
        AppMethodBeat.i(252670);
        Log.i(this.TAG, "onSceneEnd errType " + i2 + ", errCode " + i3 + ", errMsg " + str + " scene " + (qVar != null ? Integer.valueOf(qVar.getType()) : null) + " scene:" + qVar);
        if (qVar != null) {
            num = Integer.valueOf(qVar.getType());
        }
        if (num == null) {
            AppMethodBeat.o(252670);
            return;
        }
        if (num.intValue() == 3761 && i2 == 0 && i3 == 0) {
            if (qVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
                AppMethodBeat.o(252670);
                throw tVar;
            }
            this.udb = ((cd) qVar).cZc();
            bed bed = this.udb;
            if (bed != null) {
                bel bel = bed.LNT;
                if (bel == null) {
                    bel = new bel();
                }
                this.vOq = bel;
                bel bel2 = bed.wxaShopInfo;
                if (bel2 == null) {
                    bel2 = new bel();
                }
                this.vcb = bel2;
                this.ueD = bed.LNZ;
                is(true);
                AppMethodBeat.o(252670);
                return;
            }
        }
        AppMethodBeat.o(252670);
    }

    static /* synthetic */ void a(FinderSettingInfoUI finderSettingInfoUI) {
        AppMethodBeat.i(252672);
        finderSettingInfoUI.is(false);
        AppMethodBeat.o(252672);
    }

    private final void is(boolean z) {
        boolean z2;
        int i2;
        boolean z3;
        boolean z4 = true;
        AppMethodBeat.i(252671);
        c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
        this.vOm = c.a.asG(Util.nullAsNil(this.vOl));
        if (this.vOm == null) {
            finish();
            AppMethodBeat.o(252671);
            return;
        }
        Preference bmg = getPreferenceScreen().bmg("settings_avatar");
        if (bmg == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.HeadImgAndNamePreference");
            AppMethodBeat.o(252671);
            throw tVar;
        }
        HeadImgAndNamePreference headImgAndNamePreference = (HeadImgAndNamePreference) bmg;
        headImgAndNamePreference.a(new d(this));
        FinderSettingInfoUI finderSettingInfoUI = this;
        g gVar = this.vOm;
        if (gVar == null) {
            p.hyc();
        }
        headImgAndNamePreference.setTitle(com.tencent.mm.pluginsdk.ui.span.l.c(finderSettingInfoUI, gVar.getNickname()));
        headImgAndNamePreference.gLE();
        headImgAndNamePreference.bmf(this.vOl);
        headImgAndNamePreference.h(new e(this));
        getPreferenceScreen().m38do(this.vOo, true);
        com.tencent.mm.plugin.finder.utils.p pVar = com.tencent.mm.plugin.finder.utils.p.vVY;
        if (com.tencent.mm.plugin.finder.utils.p.dBV()) {
            getPreferenceScreen().m38do(this.vOo, false);
            h hVar = h.tKR;
            h hVar2 = h.tKR;
            h.a(h.daO(), this, new f(this));
            if (z) {
                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                com.tencent.mm.plugin.finder.report.k.b(this, 6, 2);
            }
        }
        bed bed = this.udb;
        aet aet = bed != null ? bed.LNQ : null;
        if (aet == null) {
            getPreferenceScreen().m38do("settings_data", true);
        } else {
            getPreferenceScreen().m38do("settings_data", !aet.enable);
        }
        com.tencent.mm.ui.base.preference.f preferenceScreen = getPreferenceScreen();
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (!com.tencent.mm.plugin.finder.storage.c.dqH()) {
            z2 = true;
        } else {
            z2 = false;
        }
        preferenceScreen.m38do("settings_creater_guide", z2);
        Log.i(this.TAG, "update shop:" + this.vOq.appId + ',' + this.vOq.LOg);
        if (!Util.isNullOrNil(this.vOq.appId)) {
            getPreferenceScreen().m38do("settings_shop", false);
        } else {
            getPreferenceScreen().m38do("settings_shop", true);
        }
        g gVar2 = this.vOm;
        if (gVar2 != null) {
            i2 = gVar2.field_extFlag;
        } else {
            i2 = 0;
        }
        if ((i2 & 131072) > 0) {
            if (z) {
                com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                com.tencent.mm.plugin.finder.report.k.b(this, 7, 2);
            }
            getPreferenceScreen().m38do("setting_live_lottery_history", false);
        } else {
            getPreferenceScreen().m38do("setting_live_lottery_history", true);
        }
        x xVar = x.vXq;
        AppCompatActivity context = getContext();
        p.g(context, "context");
        com.tencent.mm.ui.base.preference.f preferenceScreen2 = getPreferenceScreen();
        p.g(preferenceScreen2, "preferenceScreen");
        if (x.a(context, preferenceScreen2, this.vOp) && z) {
            com.tencent.mm.plugin.finder.report.k kVar3 = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.b(this, 12, 2);
        }
        if (this.ueD != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        com.tencent.mm.ui.base.preference.f preferenceScreen3 = getPreferenceScreen();
        if (z3) {
            z4 = false;
        }
        preferenceScreen3.m38do("account_management", z4);
        if (z3) {
            com.tencent.mm.plugin.finder.report.k kVar4 = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.b(this, 10, 2);
        }
        getPreferenceScreen().notifyDataSetChanged();
        AppMethodBeat.o(252671);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI$updateView$1", "Lcom/tencent/mm/ui/base/preference/HeadImgAndNamePreference$IAvatarLoaderEx;", "loadAvatar", "", ch.COL_USERNAME, "", "icon", "Landroid/widget/ImageView;", "isRound", "", "plugin-finder_release"})
    public static final class d implements HeadImgAndNamePreference.a {
        final /* synthetic */ FinderSettingInfoUI vOw;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(FinderSettingInfoUI finderSettingInfoUI) {
            this.vOw = finderSettingInfoUI;
        }

        @Override // com.tencent.mm.ui.base.preference.HeadImgAndNamePreference.a
        public final void b(String str, ImageView imageView) {
            AppMethodBeat.i(167612);
            p.h(str, ch.COL_USERNAME);
            p.h(imageView, "icon");
            if (this.vOw.vOm == null) {
                Log.e(this.vOw.TAG, "error self contact is null");
                AppMethodBeat.o(167612);
                return;
            }
            m mVar = m.uJa;
            com.tencent.mm.loader.d<o> dka = m.dka();
            g gVar = this.vOw.vOm;
            if (gVar == null) {
                p.hyc();
            }
            com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(gVar.field_avatarUrl);
            m mVar2 = m.uJa;
            dka.a(aVar, imageView, m.a(m.a.AVATAR));
            AppMethodBeat.o(167612);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class e implements View.OnClickListener {
        final /* synthetic */ FinderSettingInfoUI vOw;

        e(FinderSettingInfoUI finderSettingInfoUI) {
            this.vOw = finderSettingInfoUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(167613);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI$updateView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.vOw.vOl != null) {
                Intent intent = new Intent();
                String[] strArr = new String[1];
                g gVar = this.vOw.vOm;
                if (gVar == null) {
                    p.hyc();
                }
                strArr[0] = gVar.cXH();
                intent.putStringArrayListExtra("key_url_list", kotlin.a.j.ac(strArr));
                intent.putExtra("key_preview_avatar", true);
                com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.M(this.vOw, intent);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI$updateView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(167613);
        }
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public final int getResourceId() {
        return R.xml.b7;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public final boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        String str;
        aet aet;
        AppMethodBeat.i(167616);
        if (preference == null) {
            p.hyc();
        }
        String key = preference.getKey();
        Log.i(this.TAG, "click ".concat(String.valueOf(key)));
        if (p.j(key, "settings_avatar")) {
            Intent intent = new Intent();
            intent.setClass(this, FinderSettingDetailInfoUI.class);
            AppCompatActivity context = getContext();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.b(this, 1, 1);
        } else if (p.j(key, "settings_auth")) {
            wq wqVar = new wq();
            wqVar.ecI.userName = "gh_4ee148a6ecaa@app";
            wqVar.ecI.appId = "wxdfda2588e999a42d";
            wqVar.ecI.ecK = "pages/index/index.html";
            wqVar.ecI.scene = TXLiteAVCode.WARNING_MICROPHONE_DEVICE_EMPTY;
            EventCenter.instance.publish(wqVar);
            com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.b(this, 3, 1);
        } else if (p.j(key, "settings_qrcode")) {
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.fv(this);
            com.tencent.mm.plugin.finder.report.k kVar3 = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.b(this, 2, 1);
        } else if (p.j(key, "settings_privacy")) {
            Intent intent2 = new Intent();
            intent2.setClass(this, FinderSettingPrivacyUI.class);
            AppCompatActivity context2 = getContext();
            com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
            com.tencent.mm.hellhoundlib.a.a.a(context2, bl2.axQ(), "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context2.startActivity((Intent) bl2.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.finder.report.k kVar4 = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.b(this, 5, 1);
        } else if (p.j(key, "settings_data")) {
            bed bed = this.udb;
            if (!(bed == null || (aet = bed.LNQ) == null)) {
                if (aet.Lqc == 1) {
                    if (!Util.isNullOrNil(aet.lDS)) {
                        Intent intent3 = new Intent();
                        intent3.putExtra("rawUrl", aet.lDS);
                        com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", intent3);
                    }
                } else if (aet.Lqc == 2) {
                    wq wqVar2 = new wq();
                    wqVar2.ecI.userName = aet.Lqd;
                    wqVar2.ecI.ecK = aet.Lqe;
                    wqVar2.ecI.scene = TXLiteAVCode.WARNING_MICROPHONE_DEVICE_EMPTY;
                    EventCenter.instance.publish(wqVar2);
                }
            }
        } else if (p.j(key, "settings_creater_guide")) {
            Intent intent4 = new Intent();
            if (LocaleUtil.isSimplifiedChineseAppLang()) {
                str = this.vOr;
            } else if (LocaleUtil.isTraditionalChineseAppLang()) {
                str = this.vOs;
            } else {
                p.j(LocaleUtil.getApplicationLanguage(), LocaleUtil.ENGLISH);
                str = this.vOt;
            }
            Log.i(this.TAG, "url = ".concat(String.valueOf(str)));
            intent4.putExtra("rawUrl", str);
            com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", intent4);
            com.tencent.mm.plugin.finder.report.k kVar5 = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.b(this, 4, 1);
        } else if (p.j(key, "settings_shop")) {
            Log.i(this.TAG, "enter shop:" + this.vOq.appId + ',' + this.vOq.LOg);
            String str2 = "setting:0" + z.aUg() + ":0:" + Util.getUuidRandom();
            com.tencent.mm.plugin.finder.report.k kVar6 = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.a(2, String.valueOf(this.vOq.appId), Util.getUuidRandom().toString(), 1176, String.valueOf(SystemClock.elapsedRealtimeNanos()), "setting", "");
            com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
            FinderSettingInfoUI finderSettingInfoUI = this;
            String str3 = this.vOq.appId;
            if (str3 == null) {
                str3 = "";
            }
            String str4 = this.vOq.LOg;
            if (str4 == null) {
                str4 = "";
            }
            com.tencent.mm.plugin.finder.utils.a.a(finderSettingInfoUI, str3, str4, 1176, str2);
        } else if (p.j(key, this.vOo)) {
            Preference bmg = getPreferenceScreen().bmg(this.vOo);
            if (bmg == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.newtips.NewTipPreference");
                AppMethodBeat.o(167616);
                throw tVar;
            }
            com.tencent.mm.plugin.finder.report.k kVar7 = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.a(this, 6, 1, ((NewTipPreference) bmg).exi());
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            bdo asW = ((PluginFinder) ah).getRedDotManager().asW("OriginalEntrance");
            com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
            k asX = ((PluginFinder) ah2).getRedDotManager().asX("OriginalEntrance");
            if (!(asX == null || asW == null)) {
                j jVar = j.vft;
                FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                FinderReporterUIC fH = FinderReporterUIC.a.fH(this);
                j.a(PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT, asX, asW, 2, fH != null ? fH.dIx() : null, 0, 0, 96);
            }
            com.tencent.mm.kernel.b.a ah3 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            p.g(ah3, "MMKernel.plugin(PluginFinder::class.java)");
            ((PluginFinder) ah3).getRedDotManager().asV("OriginalEntrance");
            com.tencent.mm.kernel.b.a ah4 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            p.g(ah4, "MMKernel.plugin(PluginFinder::class.java)");
            ((PluginFinder) ah4).getRedDotManager().e("FinderSetting", new int[]{1000});
            com.tencent.mm.kernel.b.a ah5 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            p.g(ah5, "MMKernel.plugin(PluginFinder::class.java)");
            ((PluginFinder) ah5).getRedDotManager().e("ProfileEntrance", new int[]{1000});
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            getIntent().putExtra("rawUrl", com.tencent.mm.plugin.finder.storage.c.duB());
            com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", getIntent());
        } else if (p.j(key, "setting_live_lottery_history")) {
            com.tencent.mm.plugin.finder.report.k kVar8 = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.b(this, 7, 1);
            FinderReporterUIC.a aVar4 = FinderReporterUIC.wzC;
            Intent intent5 = getIntent();
            p.g(intent5, "intent");
            FinderReporterUIC.a.a(this, intent5, 0, 0, false, 124);
            com.tencent.mm.plugin.finder.utils.a aVar5 = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.a((Activity) this, (Intent) null, true);
        } else if (p.j(key, this.vOp)) {
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_WXPROFILE_ENTRY_EDU_INT_SYNC, (Object) 1);
            com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh2, "MMKernel.storage()");
            aAh2.azQ().set(ar.a.USERINFO_FINDER_WXPROFILE_ENTRY_EDU2_INT_SYNC, (Object) 1);
            com.tencent.mm.plugin.finder.report.k kVar9 = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.b(this, 12, 1);
            Preference bmg2 = getPreferenceScreen().bmg(this.vOp);
            if (bmg2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
                AppMethodBeat.o(167616);
                throw tVar2;
            }
            boolean isChecked = ((CheckBoxPreference) bmg2).isChecked();
            y yVar = y.vXH;
            if (isChecked != y.dCG()) {
                Log.i(this.TAG, "change isShowAtWxProfile, now:".concat(String.valueOf(isChecked)));
                com.tencent.mm.plugin.finder.utils.b bVar = this.tux;
                if (bVar != null) {
                    bVar.end();
                }
                b.a aVar6 = com.tencent.mm.plugin.finder.utils.b.vVa;
                AppCompatActivity context3 = getContext();
                p.g(context3, "context");
                this.tux = b.a.e(context3, getContext().getString(R.string.a06), 500);
                com.tencent.mm.plugin.finder.utils.b bVar2 = this.tux;
                if (bVar2 != null) {
                    bVar2.begin();
                }
                ((com.tencent.mm.plugin.i.a.x) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.x.class)).a(isChecked, this.vOv);
            }
        } else if (p.j(key, "account_management")) {
            Intent intent6 = new Intent();
            com.tencent.mm.plugin.finder.report.k kVar10 = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.b(this, 10, 1);
            ax axVar = this.ueD;
            if (axVar != null) {
                OccupyFinderUI16.a aVar7 = OccupyFinderUI16.ueF;
                intent6.putExtra(OccupyFinderUI16.ueE, axVar.toByteArray());
                com.tencent.mm.plugin.finder.utils.a aVar8 = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.ah(this, intent6);
            }
        }
        AppMethodBeat.o(167616);
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderSettingInfoUI$profileSettingCallback$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
    public static final class c implements ai<azg> {
        final /* synthetic */ FinderSettingInfoUI vOw;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(FinderSettingInfoUI finderSettingInfoUI) {
            this.vOw = finderSettingInfoUI;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.protocal.protobuf.apg] */
        @Override // com.tencent.mm.plugin.i.a.ai
        public final /* synthetic */ void a(azg azg, apg apg) {
            AppMethodBeat.i(252667);
            p.h(azg, "req");
            p.h(apg, "ret");
            Log.i(this.vOw.TAG, "profileSettingCallback, " + apg.retCode);
            if (apg.retCode != 0) {
                Preference bmg = this.vOw.getPreferenceScreen().bmg(this.vOw.vOp);
                if (bmg == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.CheckBoxPreference");
                    AppMethodBeat.o(252667);
                    throw tVar;
                }
                com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(aj.class);
                p.g(ah, "MMKernel.plugin(IPluginFinder::class.java)");
                ((CheckBoxPreference) bmg).setChecked(((aj) ah).getFinderSwitchApi().dCv());
                u.makeText(this.vOw, this.vOw.getString(R.string.dax), 0).show();
            }
            com.tencent.mm.plugin.finder.utils.b bVar = this.vOw.tux;
            if (bVar != null) {
                bVar.end();
                AppMethodBeat.o(252667);
                return;
            }
            AppMethodBeat.o(252667);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onStop() {
        AppMethodBeat.i(252673);
        super.onStop();
        this.vOu = "";
        AppMethodBeat.o(252673);
    }
}
