package com.tencent.mm.plugin.finder.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.widget.pref.FinderLocationPreference;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.t;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderSelectDistrictUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "TAG", "", "currentDistrictPref", "Lcom/tencent/mm/plugin/finder/widget/pref/FinderLocationPreference;", "currentLocationPref", "selectCityCode", "selectCountryCode", "selectProvinceCode", "complete", "", "getResourceId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "plugin-finder_release"})
public class FinderSelectDistrictUI extends MMPreference {
    private final String TAG = "Finder.FinderSelectDistrictUI";
    private HashMap _$_findViewCache;
    private String vNK = "";
    private String vNL = "";
    private String vNM = "";
    private FinderLocationPreference vNN;
    private FinderLocationPreference vNO;

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252651);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252651);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252650);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252650);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(178436);
        super.onCreate(bundle);
        setMMTitle(R.string.d8k);
        String stringExtra = getIntent().getStringExtra("SelectedCountryCode");
        p.g(stringExtra, "intent.getStringExtra(Co…tUI.KSelectedCountryCode)");
        this.vNK = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("SelectedProvinceCode");
        p.g(stringExtra2, "intent.getStringExtra(Co…UI.KSelectedProvinceCode)");
        this.vNL = stringExtra2;
        String stringExtra3 = getIntent().getStringExtra("SelectedCityCode");
        p.g(stringExtra3, "intent.getStringExtra(Co…rictUI.KSelectedCityCode)");
        this.vNM = stringExtra3;
        Preference bmg = getPreferenceScreen().bmg("select_current_district");
        if (bmg == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.widget.pref.FinderLocationPreference");
            AppMethodBeat.o(178436);
            throw tVar;
        }
        this.vNN = (FinderLocationPreference) bmg;
        FinderLocationPreference finderLocationPreference = this.vNN;
        if (finderLocationPreference == null) {
            p.btv("currentDistrictPref");
        }
        finderLocationPreference.wDH = false;
        FinderLocationPreference finderLocationPreference2 = this.vNN;
        if (finderLocationPreference2 == null) {
            p.btv("currentDistrictPref");
        }
        finderLocationPreference2.uOQ = true;
        FinderLocationPreference finderLocationPreference3 = this.vNN;
        if (finderLocationPreference3 == null) {
            p.btv("currentDistrictPref");
        }
        finderLocationPreference3.setCountryCode(this.vNK);
        FinderLocationPreference finderLocationPreference4 = this.vNN;
        if (finderLocationPreference4 == null) {
            p.btv("currentDistrictPref");
        }
        finderLocationPreference4.awY(this.vNL);
        FinderLocationPreference finderLocationPreference5 = this.vNN;
        if (finderLocationPreference5 == null) {
            p.btv("currentDistrictPref");
        }
        finderLocationPreference5.awZ(this.vNM);
        FinderLocationPreference finderLocationPreference6 = this.vNN;
        if (finderLocationPreference6 == null) {
            p.btv("currentDistrictPref");
        }
        finderLocationPreference6.updateTitle();
        Preference bmg2 = getPreferenceScreen().bmg("select_current_location");
        if (bmg2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.widget.pref.FinderLocationPreference");
            AppMethodBeat.o(178436);
            throw tVar2;
        }
        this.vNO = (FinderLocationPreference) bmg2;
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        bme bme = ((FinderGlobalLocationVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class)).wtO;
        if (bme != null) {
            FinderLocationPreference finderLocationPreference7 = this.vNO;
            if (finderLocationPreference7 == null) {
                p.btv("currentLocationPref");
            }
            finderLocationPreference7.wDH = true;
            FinderLocationPreference finderLocationPreference8 = this.vNO;
            if (finderLocationPreference8 == null) {
                p.btv("currentLocationPref");
            }
            String str = bme.keh;
            p.g(str, "it.Country");
            finderLocationPreference8.setCountryCode(str);
            FinderLocationPreference finderLocationPreference9 = this.vNO;
            if (finderLocationPreference9 == null) {
                p.btv("currentLocationPref");
            }
            String str2 = bme.kdZ;
            p.g(str2, "it.Province");
            finderLocationPreference9.awY(str2);
            FinderLocationPreference finderLocationPreference10 = this.vNO;
            if (finderLocationPreference10 == null) {
                p.btv("currentLocationPref");
            }
            String str3 = bme.kea;
            p.g(str3, "it.City");
            finderLocationPreference10.awZ(str3);
            FinderLocationPreference finderLocationPreference11 = this.vNO;
            if (finderLocationPreference11 == null) {
                p.btv("currentLocationPref");
            }
            finderLocationPreference11.updateTitle();
        } else {
            FinderSelectDistrictUI finderSelectDistrictUI = this;
            finderSelectDistrictUI.getPreferenceScreen().m38do("select_current_location_title", true);
            finderSelectDistrictUI.getPreferenceScreen().m38do("select_current_location", true);
        }
        getPreferenceScreen().notifyDataSetChanged();
        addTextOptionMenu(0, getString(R.string.vl), new a(this), null, t.b.GREEN);
        setBackBtn(new b(this));
        new StringBuilder("init location ").append(this.vNK).append(' ').append(this.vNL).append(' ').append(this.vNM);
        h.hkS();
        AppMethodBeat.o(178436);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class a implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderSelectDistrictUI vNP;

        a(FinderSelectDistrictUI finderSelectDistrictUI) {
            this.vNP = finderSelectDistrictUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(178434);
            FinderSelectDistrictUI.a(this.vNP);
            AppMethodBeat.o(178434);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderSelectDistrictUI vNP;

        b(FinderSelectDistrictUI finderSelectDistrictUI) {
            this.vNP = finderSelectDistrictUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(178435);
            this.vNP.finish();
            AppMethodBeat.o(178435);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.b3;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(178437);
        if (preference != null) {
            String key = preference.getKey();
            if (key != null) {
                switch (key.hashCode()) {
                    case -2021587849:
                        if (key.equals("select_current_district")) {
                            FinderLocationPreference finderLocationPreference = this.vNN;
                            if (finderLocationPreference == null) {
                                p.btv("currentDistrictPref");
                            }
                            finderLocationPreference.uOQ = true;
                            FinderLocationPreference finderLocationPreference2 = this.vNO;
                            if (finderLocationPreference2 == null) {
                                p.btv("currentLocationPref");
                            }
                            finderLocationPreference2.uOQ = false;
                            FinderLocationPreference finderLocationPreference3 = this.vNN;
                            if (finderLocationPreference3 == null) {
                                p.btv("currentDistrictPref");
                            }
                            this.vNK = finderLocationPreference3.countryCode;
                            FinderLocationPreference finderLocationPreference4 = this.vNN;
                            if (finderLocationPreference4 == null) {
                                p.btv("currentDistrictPref");
                            }
                            this.vNL = finderLocationPreference4.provinceCode;
                            FinderLocationPreference finderLocationPreference5 = this.vNN;
                            if (finderLocationPreference5 == null) {
                                p.btv("currentDistrictPref");
                            }
                            this.vNM = finderLocationPreference5.cityCode;
                            break;
                        }
                        break;
                    case -409505634:
                        if (key.equals("select_current_location")) {
                            FinderLocationPreference finderLocationPreference6 = this.vNN;
                            if (finderLocationPreference6 == null) {
                                p.btv("currentDistrictPref");
                            }
                            finderLocationPreference6.uOQ = false;
                            FinderLocationPreference finderLocationPreference7 = this.vNO;
                            if (finderLocationPreference7 == null) {
                                p.btv("currentLocationPref");
                            }
                            finderLocationPreference7.uOQ = true;
                            FinderLocationPreference finderLocationPreference8 = this.vNO;
                            if (finderLocationPreference8 == null) {
                                p.btv("currentLocationPref");
                            }
                            this.vNK = finderLocationPreference8.countryCode;
                            FinderLocationPreference finderLocationPreference9 = this.vNO;
                            if (finderLocationPreference9 == null) {
                                p.btv("currentLocationPref");
                            }
                            this.vNL = finderLocationPreference9.provinceCode;
                            FinderLocationPreference finderLocationPreference10 = this.vNO;
                            if (finderLocationPreference10 == null) {
                                p.btv("currentLocationPref");
                            }
                            this.vNM = finderLocationPreference10.cityCode;
                            break;
                        }
                        break;
                }
            }
            if (fVar != null) {
                fVar.notifyDataSetChanged();
            }
        }
        AppMethodBeat.o(178437);
        return true;
    }

    public static final /* synthetic */ void a(FinderSelectDistrictUI finderSelectDistrictUI) {
        AppMethodBeat.i(178438);
        new StringBuilder("complete location ").append(finderSelectDistrictUI.vNK).append(' ').append(finderSelectDistrictUI.vNL).append(' ').append(finderSelectDistrictUI.vNM);
        h.hkS();
        Intent intent = new Intent();
        intent.putExtra("Country", finderSelectDistrictUI.vNK);
        intent.putExtra("Contact_Province", finderSelectDistrictUI.vNL);
        intent.putExtra("Contact_City", finderSelectDistrictUI.vNM);
        finderSelectDistrictUI.setResult(-1, intent);
        finderSelectDistrictUI.finish();
        AppMethodBeat.o(178438);
    }
}
