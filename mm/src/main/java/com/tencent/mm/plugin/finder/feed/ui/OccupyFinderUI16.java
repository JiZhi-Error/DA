package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.protocal.protobuf.ax;
import com.tencent.mm.protocal.protobuf.az;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0014J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI16;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "TAG", "", "accountExtConfig", "Lcom/tencent/mm/protocal/protobuf/AccountExtraSettingConfig;", "getResourceId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "Companion", "plugin-finder_release"})
public final class OccupyFinderUI16 extends MMPreference {
    private static final String ueE = ueE;
    public static final a ueF = new a((byte) 0);
    private final String TAG = "Finder.FinderAccountManagent";
    private HashMap _$_findViewCache;
    private ax ueD;

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245719);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245719);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245718);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245718);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI16$Companion;", "", "()V", OccupyFinderUI16.ueE, "", "getACCOUNT_EXTRA_CONFIG", "()Ljava/lang/String;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(245717);
        AppMethodBeat.o(245717);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public final void onCreate(Bundle bundle) {
        ax axVar;
        OccupyFinderUI16 occupyFinderUI16;
        AppMethodBeat.i(245714);
        super.onCreate(bundle);
        setMMTitle(R.string.cgi);
        setBackBtn(new b(this));
        byte[] byteArrayExtra = getIntent().getByteArrayExtra(ueE);
        if (byteArrayExtra != null) {
            axVar = new ax();
            axVar.parseFrom(byteArrayExtra);
            occupyFinderUI16 = this;
        } else {
            axVar = null;
            occupyFinderUI16 = this;
        }
        occupyFinderUI16.ueD = axVar;
        if (this.ueD == null) {
            finish();
            AppMethodBeat.o(245714);
            return;
        }
        initView();
        AppMethodBeat.o(245714);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ OccupyFinderUI16 ueG;

        b(OccupyFinderUI16 occupyFinderUI16) {
            this.ueG = occupyFinderUI16;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(245713);
            this.ueG.finish();
            AppMethodBeat.o(245713);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        LinkedList<az> linkedList;
        AppMethodBeat.i(245715);
        super.initView();
        ax axVar = this.ueD;
        if (!(axVar == null || (linkedList = axVar.KDT) == null)) {
            for (T t : linkedList) {
                f preferenceScreen = getPreferenceScreen();
                p.g(t, LocaleUtil.ITALIAN);
                preferenceScreen.c(new com.tencent.mm.plugin.finder.widget.pref.a(t, this));
            }
        }
        getPreferenceScreen().notifyDataSetChanged();
        AppMethodBeat.o(245715);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public final boolean onPreferenceTreeClick(f fVar, Preference preference) {
        String str;
        String str2;
        String str3 = null;
        AppMethodBeat.i(245716);
        if (preference == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.widget.pref.FinderAccountManagementPref");
            AppMethodBeat.o(245716);
            throw tVar;
        }
        com.tencent.mm.plugin.finder.widget.pref.a aVar = (com.tencent.mm.plugin.finder.widget.pref.a) preference;
        az azVar = aVar.wDE;
        Integer valueOf = azVar != null ? Integer.valueOf(azVar.pTI) : null;
        if (valueOf != null && valueOf.intValue() == 2) {
            Intent intent = new Intent();
            az azVar2 = aVar.wDE;
            if (azVar2 != null) {
                str3 = azVar2.qHg;
            }
            intent.putExtra("rawUrl", str3);
            c.b(aVar.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        } else if (valueOf != null && valueOf.intValue() == 1) {
            g gVar = new g();
            az azVar3 = aVar.wDE;
            if (azVar3 == null || (str = azVar3.KDV) == null) {
                str = "";
            }
            gVar.username = str;
            az azVar4 = aVar.wDE;
            if (azVar4 == null || (str2 = azVar4.KDW) == null) {
                str2 = "";
            }
            gVar.kHw = str2;
            az azVar5 = aVar.wDE;
            gVar.scene = azVar5 != null ? azVar5.KDY : 1000;
            ((r) com.tencent.mm.kernel.g.af(r.class)).a(aVar.getContext(), gVar);
        }
        AppMethodBeat.o(245716);
        return true;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public final int getResourceId() {
        return R.xml.b0;
    }
}
