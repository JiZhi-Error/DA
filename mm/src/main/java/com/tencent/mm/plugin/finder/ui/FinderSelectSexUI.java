package com.tencent.mm.plugin.finder.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SelectPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.t;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderSelectSexUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "TAG", "", "selectFeMale", "Lcom/tencent/mm/ui/base/preference/SelectPreference;", "selectMale", "complete", "", "getFooterResourceId", "", "getResourceId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "updateComplete", "plugin-finder_release"})
public final class FinderSelectSexUI extends MMPreference {
    private final String TAG = "Finder.FinderSelectSexUI";
    private HashMap _$_findViewCache;
    private SelectPreference vNQ;
    private SelectPreference vNR;

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252653);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252653);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252652);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252652);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(167565);
        super.onCreate(bundle);
        Preference bmg = getPreferenceScreen().bmg("select_male");
        if (bmg == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.SelectPreference");
            AppMethodBeat.o(167565);
            throw tVar;
        }
        this.vNQ = (SelectPreference) bmg;
        Preference bmg2 = getPreferenceScreen().bmg("select_female");
        if (bmg2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.SelectPreference");
            AppMethodBeat.o(167565);
            throw tVar2;
        }
        this.vNR = (SelectPreference) bmg2;
        String stringExtra = getIntent().getStringExtra("key_input_sex");
        if (stringExtra == null) {
            stringExtra = "";
        }
        "inputSex = ".concat(String.valueOf(stringExtra));
        h.hkS();
        SelectPreference selectPreference = this.vNQ;
        if (selectPreference == null) {
            p.btv("selectMale");
        }
        selectPreference.setEnabled(true);
        SelectPreference selectPreference2 = this.vNR;
        if (selectPreference2 == null) {
            p.btv("selectFeMale");
        }
        selectPreference2.setEnabled(true);
        if (p.j(stringExtra, "male")) {
            SelectPreference selectPreference3 = this.vNQ;
            if (selectPreference3 == null) {
                p.btv("selectMale");
            }
            selectPreference3.setSelected(true);
            SelectPreference selectPreference4 = this.vNR;
            if (selectPreference4 == null) {
                p.btv("selectFeMale");
            }
            selectPreference4.setSelected(false);
        } else if (p.j(stringExtra, "female")) {
            SelectPreference selectPreference5 = this.vNQ;
            if (selectPreference5 == null) {
                p.btv("selectMale");
            }
            selectPreference5.setSelected(false);
            SelectPreference selectPreference6 = this.vNR;
            if (selectPreference6 == null) {
                p.btv("selectFeMale");
            }
            selectPreference6.setSelected(true);
        } else {
            SelectPreference selectPreference7 = this.vNQ;
            if (selectPreference7 == null) {
                p.btv("selectMale");
            }
            selectPreference7.setSelected(false);
            SelectPreference selectPreference8 = this.vNR;
            if (selectPreference8 == null) {
                p.btv("selectFeMale");
            }
            selectPreference8.setSelected(false);
        }
        addTextOptionMenu(0, getString(R.string.vl), new a(this), null, t.b.GREEN);
        setBackBtn(new b(this));
        dzZ();
        AppMethodBeat.o(167565);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class a implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderSelectSexUI vNS;

        a(FinderSelectSexUI finderSelectSexUI) {
            this.vNS = finderSelectSexUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(167563);
            FinderSelectSexUI.a(this.vNS);
            AppMethodBeat.o(167563);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderSelectSexUI vNS;

        b(FinderSelectSexUI finderSelectSexUI) {
            this.vNS = finderSelectSexUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(167564);
            this.vNS.finish();
            AppMethodBeat.o(167564);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public final int getFooterResourceId() {
        return R.layout.ajk;
    }

    private final void dzZ() {
        AppMethodBeat.i(167566);
        SelectPreference selectPreference = this.vNR;
        if (selectPreference == null) {
            p.btv("selectFeMale");
        }
        if (!selectPreference.getSelected()) {
            SelectPreference selectPreference2 = this.vNQ;
            if (selectPreference2 == null) {
                p.btv("selectMale");
            }
            if (!selectPreference2.getSelected()) {
                enableOptionMenu(0, false);
                AppMethodBeat.o(167566);
                return;
            }
        }
        enableOptionMenu(0, true);
        AppMethodBeat.o(167566);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public final boolean onPreferenceTreeClick(f fVar, Preference preference) {
        String str;
        AppMethodBeat.i(167567);
        if (preference == null || (str = preference.getKey()) == null) {
            str = "";
        }
        if (p.j(str, "select_male")) {
            SelectPreference selectPreference = this.vNQ;
            if (selectPreference == null) {
                p.btv("selectMale");
            }
            selectPreference.setSelected(true);
            SelectPreference selectPreference2 = this.vNR;
            if (selectPreference2 == null) {
                p.btv("selectFeMale");
            }
            selectPreference2.setSelected(false);
            if (fVar != null) {
                fVar.notifyDataSetChanged();
            }
        } else if (p.j(str, "select_female")) {
            SelectPreference selectPreference3 = this.vNQ;
            if (selectPreference3 == null) {
                p.btv("selectMale");
            }
            selectPreference3.setSelected(false);
            SelectPreference selectPreference4 = this.vNR;
            if (selectPreference4 == null) {
                p.btv("selectFeMale");
            }
            selectPreference4.setSelected(true);
        } else {
            SelectPreference selectPreference5 = this.vNQ;
            if (selectPreference5 == null) {
                p.btv("selectMale");
            }
            selectPreference5.setSelected(false);
            SelectPreference selectPreference6 = this.vNR;
            if (selectPreference6 == null) {
                p.btv("selectFeMale");
            }
            selectPreference6.setSelected(false);
        }
        dzZ();
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
        AppMethodBeat.o(167567);
        return false;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public final int getResourceId() {
        return R.xml.b5;
    }

    public static final /* synthetic */ void a(FinderSelectSexUI finderSelectSexUI) {
        String str;
        AppMethodBeat.i(167568);
        Intent intent = new Intent();
        SelectPreference selectPreference = finderSelectSexUI.vNQ;
        if (selectPreference == null) {
            p.btv("selectMale");
        }
        if (selectPreference.getSelected()) {
            str = "male";
        } else {
            SelectPreference selectPreference2 = finderSelectSexUI.vNR;
            if (selectPreference2 == null) {
                p.btv("selectFeMale");
            }
            if (selectPreference2.getSelected()) {
                str = "female";
            } else {
                AppMethodBeat.o(167568);
                return;
            }
        }
        "outputSex = ".concat(String.valueOf(str));
        h.hkS();
        intent.putExtra("key_output_sex", str);
        finderSelectSexUI.setResult(-1, intent);
        finderSelectSexUI.finish();
        AppMethodBeat.o(167568);
    }
}
