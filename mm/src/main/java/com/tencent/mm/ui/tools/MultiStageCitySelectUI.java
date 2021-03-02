package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.location.model.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.tools.ZoneSelectOtherCountryPreference;
import com.tencent.mm.ui.tools.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiStageCitySelectUI extends MMPreference implements i {
    private static List<RegionCodeDecoder.Region> QvA;
    private String Cfy = null;
    private String QvB;
    private ArrayList<String> QvC;
    private Runnable QvD = new Runnable() {
        /* class com.tencent.mm.ui.tools.MultiStageCitySelectUI.AnonymousClass4 */

        public final void run() {
            AppMethodBeat.i(39091);
            MultiStageCitySelectUI.n(MultiStageCitySelectUI.this);
            AppMethodBeat.o(39091);
        }
    };
    private String Qvq = null;
    private boolean Qvr = false;
    private int Qvs = -1;
    private RegionCodeDecoder.Region[] Qvt;
    private boolean Qvu = false;
    private boolean Qvv = true;
    private boolean Qvw = false;
    private boolean Qvx = false;
    private boolean Qvy = false;
    private ZoneRecommandPreference Qvz;
    private String cityCode = null;
    private String countryCode = null;
    private int dTz = 0;
    private b.a gmA = new b.a() {
        /* class com.tencent.mm.ui.tools.MultiStageCitySelectUI.AnonymousClass1 */

        @Override // com.tencent.mm.modelgeo.b.a
        public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
            AppMethodBeat.i(39085);
            if (MultiStageCitySelectUI.this.iOv == null) {
                AppMethodBeat.o(39085);
                return false;
            }
            if (z) {
                Log.i("MicroMsg.MultiStageCitySelectUI", "lat:%f lng:%f accuracy:%f", Float.valueOf(f3), Float.valueOf(f2), Double.valueOf(d3));
                bg.azz().a(new g((double) f3, (double) f2), 0);
            } else {
                MultiStageCitySelectUI.b(MultiStageCitySelectUI.this);
                if (!MultiStageCitySelectUI.this.uSu && !d.bcc()) {
                    MultiStageCitySelectUI.this.uSu = true;
                    h.a((Context) MultiStageCitySelectUI.this, MultiStageCitySelectUI.this.getString(R.string.dvi), MultiStageCitySelectUI.this.getString(R.string.zb), MultiStageCitySelectUI.this.getString(R.string.e_k), MultiStageCitySelectUI.this.getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.tools.MultiStageCitySelectUI.AnonymousClass1.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(39084);
                            d.cZ(MultiStageCitySelectUI.this);
                            AppMethodBeat.o(39084);
                        }
                    }, (DialogInterface.OnClickListener) null);
                }
            }
            if (MultiStageCitySelectUI.this.iOv != null) {
                MultiStageCitySelectUI.this.iOv.c(MultiStageCitySelectUI.this.gmA);
                MultiStageCitySelectUI.this.iOv = null;
            }
            AppMethodBeat.o(39085);
            return false;
        }
    };
    private s gzP = new s((byte) 0);
    private MMHandler handler = new MMHandler(Looper.getMainLooper());
    private d iOv;
    private String jbZ = null;
    private boolean kgv = true;
    private boolean mShowSelectedLocation = true;
    private String provinceCode = null;
    private f screen;
    private boolean uSu;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MultiStageCitySelectUI() {
        AppMethodBeat.i(39093);
        AppMethodBeat.o(39093);
    }

    static /* synthetic */ void b(MultiStageCitySelectUI multiStageCitySelectUI) {
        AppMethodBeat.i(39106);
        multiStageCitySelectUI.gXM();
        AppMethodBeat.o(39106);
    }

    static /* synthetic */ void o(MultiStageCitySelectUI multiStageCitySelectUI) {
        AppMethodBeat.i(180079);
        multiStageCitySelectUI.gXK();
        AppMethodBeat.o(180079);
    }

    private void gXK() {
        switch (this.dTz) {
            case 0:
                this.countryCode = null;
                return;
            case 1:
                this.provinceCode = null;
                return;
            case 2:
                this.cityCode = null;
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x013d A[SYNTHETIC, Splitter:B:57:0x013d] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0142 A[SYNTHETIC, Splitter:B:60:0x0142] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0147 A[SYNTHETIC, Splitter:B:63:0x0147] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0153 A[SYNTHETIC, Splitter:B:69:0x0153] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0158 A[SYNTHETIC, Splitter:B:72:0x0158] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x015d A[SYNTHETIC, Splitter:B:75:0x015d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.tencent.mm.storage.RegionCodeDecoder.Region> gXL() {
        /*
        // Method dump skipped, instructions count: 397
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.tools.MultiStageCitySelectUI.gXL():java.util.List");
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39096);
        super.onCreate(bundle);
        bg.azz().a(665, this);
        this.screen = getPreferenceScreen();
        initView();
        if (this.Qvy) {
            if (QvA == null || QvA.size() <= 0) {
                long currentTicks = Util.currentTicks();
                RegionCodeDecoder.Region[] gEo = RegionCodeDecoder.gEm().gEo();
                if (gEo != null && gEo.length > 0 && (QvA == null || QvA.size() <= 0)) {
                    List<RegionCodeDecoder.Region> gXL = gXL();
                    QvA = gXL;
                    if (gXL != null) {
                        Log.i("MicroMsg.MultiStageCitySelectUI", "buildAllSearchRegion used %sms, size: %s", Long.valueOf(Util.ticksToNow(currentTicks)), Integer.valueOf(QvA.size()));
                    }
                }
            }
            addSearchMenu(true, this.gzP);
            this.gzP.Qwi = new s.b() {
                /* class com.tencent.mm.ui.tools.MultiStageCitySelectUI.AnonymousClass3 */

                @Override // com.tencent.mm.ui.tools.s.b
                public final void bnz() {
                }

                @Override // com.tencent.mm.ui.tools.s.b
                public final void bny() {
                    AppMethodBeat.i(39087);
                    MultiStageCitySelectUI.this.hideVKB();
                    MultiStageCitySelectUI.j(MultiStageCitySelectUI.this);
                    MultiStageCitySelectUI.this.gXJ();
                    AppMethodBeat.o(39087);
                }

                @Override // com.tencent.mm.ui.tools.s.b
                public final void SO(String str) {
                    AppMethodBeat.i(39088);
                    if (!Util.isNullOrNil(str)) {
                        MultiStageCitySelectUI.this.QvB = str;
                        MultiStageCitySelectUI.this.screen.removeAll();
                        MultiStageCitySelectUI.this.handler.removeCallbacks(MultiStageCitySelectUI.this.QvD);
                        MultiStageCitySelectUI.this.handler.postDelayed(MultiStageCitySelectUI.this.QvD, 50);
                    }
                    AppMethodBeat.o(39088);
                }

                @Override // com.tencent.mm.ui.tools.s.b
                public final boolean SN(String str) {
                    AppMethodBeat.i(39089);
                    if (!Util.isNullOrNil(str)) {
                        MultiStageCitySelectUI.this.QvB = str;
                        MultiStageCitySelectUI.this.screen.removeAll();
                        MultiStageCitySelectUI.this.handler.removeCallbacks(MultiStageCitySelectUI.this.QvD);
                        MultiStageCitySelectUI.this.handler.postDelayed(MultiStageCitySelectUI.this.QvD, 50);
                        AppMethodBeat.o(39089);
                        return true;
                    }
                    AppMethodBeat.o(39089);
                    return false;
                }

                @Override // com.tencent.mm.ui.tools.s.b
                public final void bnA() {
                    AppMethodBeat.i(39090);
                    MultiStageCitySelectUI.j(MultiStageCitySelectUI.this);
                    MultiStageCitySelectUI.this.gXJ();
                    AppMethodBeat.o(39090);
                }

                @Override // com.tencent.mm.ui.tools.s.b
                public final void bnB() {
                }
            };
        }
        AppMethodBeat.o(39096);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(39097);
        super.onResume();
        if (this.kgv) {
            boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 64, (String) null, (String) null);
            Log.i("MicroMsg.MultiStageCitySelectUI", "settings district,checkPermission checkLocation[%b]", Boolean.valueOf(a2));
            if (a2) {
                if (this.iOv == null) {
                    this.iOv = d.bca();
                }
                this.iOv.a(this.gmA, true);
            }
        }
        AppMethodBeat.o(39097);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(39098);
        bg.azz().b(665, this);
        if (this.iOv != null) {
            this.iOv.c(this.gmA);
        }
        super.onDestroy();
        AppMethodBeat.o(39098);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.layout.cd8;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(39099);
        setMMTitle(R.string.f_n);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.tools.MultiStageCitySelectUI.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(39092);
                MultiStageCitySelectUI.o(MultiStageCitySelectUI.this);
                MultiStageCitySelectUI.this.finish();
                AppMethodBeat.o(39092);
                return true;
            }
        });
        this.Qvu = getIntent().getBooleanExtra("GetAddress", false);
        this.countryCode = getIntent().getStringExtra("Country");
        this.provinceCode = getIntent().getStringExtra("Provice");
        this.jbZ = getIntent().getStringExtra("CountryName");
        this.Qvq = getIntent().getStringExtra("ProviceName");
        this.Qvv = getIntent().getBooleanExtra("IsAutoPosition", !Util.isOverseasUser(this));
        this.Qvr = getIntent().getBooleanExtra("IsRealNameVerifyScene", false);
        this.Qvx = getIntent().getBooleanExtra("IsSelectNonChinaCountry", false);
        this.QvC = getIntent().getStringArrayListExtra("BlockedCountries");
        if (this.QvC == null) {
            this.QvC = new ArrayList<>();
        }
        this.Qvy = getIntent().getBooleanExtra("IsNeedShowSearchBar", false);
        Log.i("MicroMsg.MultiStageCitySelectUI", " country = " + this.countryCode + " province =" + this.provinceCode + " city = " + this.cityCode + " " + this.jbZ + " " + this.Qvq + " " + this.Qvr + " " + this.Qvx);
        if (this.Qvr) {
            this.dTz = 3;
        } else if (this.countryCode == null) {
            this.dTz = 0;
            this.provinceCode = null;
            this.cityCode = null;
        } else if (this.provinceCode == null) {
            this.dTz = 1;
            this.cityCode = null;
        } else {
            this.dTz = 2;
        }
        gXJ();
        AppMethodBeat.o(39099);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        boolean z;
        String str = null;
        AppMethodBeat.i(39100);
        if (preference instanceof ZonePreference) {
            RegionCodeDecoder.Region region = ((ZonePreference) preference).Qxt;
            if (region == null || Util.isNullOrNil(region.getCode())) {
                Log.e("MicroMsg.MultiStageCitySelectUI", "onPreferenceTreeClick error item, code:" + (region == null ? -1 : region.getCode()) + " ,name:" + (region == null ? BuildConfig.COMMAND : region.getName()));
                AppMethodBeat.o(39100);
                return false;
            }
            if (this.dTz == 3) {
                this.countryCode = WeChatBrands.AppInfo.LANG_CN;
                this.provinceCode = region.getCode();
                this.Qvq = region.getName();
            }
            if (this.dTz == 0) {
                this.countryCode = region.getCode();
                this.jbZ = region.getName();
            } else if (this.dTz == 1) {
                this.provinceCode = region.getCode();
                this.Qvq = region.getName();
            } else if (this.dTz == 2) {
                this.cityCode = region.getCode();
                this.Cfy = region.getName();
                if (WeChatBrands.AppInfo.LANG_CN.equalsIgnoreCase(this.countryCode) || WeChatBrands.AppInfo.LANG_HK.equalsIgnoreCase(this.countryCode) || "MO".equalsIgnoreCase(this.countryCode) || WeChatBrands.AppInfo.LANG_TW.equalsIgnoreCase(this.countryCode)) {
                    this.jbZ = null;
                } else {
                    this.Qvq = null;
                }
            } else if (this.dTz == 4) {
                if (region.getParent() != null && !region.hasChildren()) {
                    this.cityCode = region.getCode();
                    this.Cfy = region.getName();
                    this.provinceCode = region.getParent().getCode();
                    this.Qvq = region.getParent().getName();
                    this.countryCode = region.getCountryCode();
                    this.jbZ = null;
                } else if (!region.hasChildren() || region.getParent() == null) {
                    this.countryCode = region.getCode();
                    this.jbZ = region.getName();
                    this.provinceCode = null;
                    this.Qvq = null;
                    this.cityCode = null;
                    this.Cfy = null;
                } else {
                    this.provinceCode = region.getCode();
                    this.Qvq = region.getName();
                    this.countryCode = region.getCountryCode();
                    this.jbZ = null;
                }
            }
            if (!region.hasChildren()) {
                if (!this.Qvu) {
                    bg.aVF();
                    c.azQ().set(12324, this.countryCode);
                    bg.aVF();
                    c.azQ().set(12325, this.provinceCode);
                    bg.aVF();
                    c.azQ().set(12326, this.cityCode);
                }
                Intent intent = new Intent();
                intent.putExtra("CountryName", this.jbZ);
                intent.putExtra("ProviceName", this.Qvq);
                intent.putExtra("CityName", this.Cfy);
                intent.putExtra("Country", this.countryCode);
                intent.putExtra("Contact_Province", this.provinceCode);
                intent.putExtra("Contact_City", this.cityCode);
                hideVKB();
                setResult(-1, intent);
                finish();
            } else {
                Intent intent2 = new Intent(this, MultiStageCitySelectUI.class);
                Bundle bundle = new Bundle();
                bundle.putString("Country", this.countryCode);
                bundle.putString("Provice", this.provinceCode);
                bundle.putString("CountryName", this.jbZ);
                bundle.putString("ProviceName", this.Qvq);
                bundle.putBoolean("GetAddress", this.Qvu);
                bundle.putBoolean("ShowSelectedLocation", this.mShowSelectedLocation);
                bundle.putString("SelectedCountryCode", getIntent().getStringExtra("SelectedCountryCode"));
                bundle.putString("SelectedProvinceCode", getIntent().getStringExtra("SelectedProvinceCode"));
                bundle.putString("SelectedCityCode", getIntent().getStringExtra("SelectedCityCode"));
                if (this.Qvr) {
                    String countryCode2 = region.getCountryCode();
                    if (Util.isNullOrNil(countryCode2)) {
                        countryCode2 = this.countryCode;
                    }
                    if (WeChatBrands.AppInfo.LANG_CN.equalsIgnoreCase(countryCode2) || WeChatBrands.AppInfo.LANG_HK.equalsIgnoreCase(countryCode2) || "MO".equalsIgnoreCase(countryCode2) || WeChatBrands.AppInfo.LANG_TW.equalsIgnoreCase(countryCode2)) {
                        bundle.putBoolean("IsNeedShowSearchBar", true);
                    }
                    String code = region.getCode();
                    if (WeChatBrands.AppInfo.LANG_HK.equalsIgnoreCase(code) || "MO".equalsIgnoreCase(code) || WeChatBrands.AppInfo.LANG_TW.equalsIgnoreCase(code)) {
                        bundle.putString("Country", code);
                        bundle.putString("CountryName", region.getName());
                        bundle.remove("Provice");
                    }
                }
                intent2.putExtras(bundle);
                hideVKB();
                startActivityForResult(intent2, 1);
            }
            AppMethodBeat.o(39100);
            return true;
        }
        if (preference.mKey.equals("current_location")) {
            if (this.Qvz.status == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                ZoneRecommandPreference zoneRecommandPreference = this.Qvz;
                RegionCodeDecoder.Region[] regionArr = {zoneRecommandPreference.Qxw, zoneRecommandPreference.Qxx, zoneRecommandPreference.Qxy};
                if (!this.Qvu) {
                    bg.aVF();
                    c.azQ().set(12324, regionArr[0] == null ? null : regionArr[0].getCode());
                    bg.aVF();
                    c.azQ().set(12325, regionArr[1] == null ? null : regionArr[1].getCode());
                    bg.aVF();
                    c.azQ().set(12326, regionArr[2] == null ? null : regionArr[2].getCode());
                }
                String code2 = regionArr[0] == null ? null : regionArr[0].getCode();
                String name = regionArr[0] == null ? null : regionArr[0].getName();
                String code3 = regionArr[1] == null ? null : regionArr[1].getCode();
                String name2 = regionArr[1] == null ? null : regionArr[1].getName();
                if (WeChatBrands.AppInfo.LANG_CN.equalsIgnoreCase(code2) || WeChatBrands.AppInfo.LANG_HK.equalsIgnoreCase(code2) || "MO".equalsIgnoreCase(code2) || WeChatBrands.AppInfo.LANG_TW.equalsIgnoreCase(code2)) {
                    name = null;
                } else {
                    name2 = null;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("CountryName", name);
                intent3.putExtra("ProviceName", name2);
                intent3.putExtra("CityName", regionArr[2] == null ? null : regionArr[2].getName());
                intent3.putExtra("Country", code2);
                intent3.putExtra("Contact_Province", code3);
                if (regionArr[2] != null) {
                    str = regionArr[2].getCode();
                }
                intent3.putExtra("Contact_City", str);
                hideVKB();
                setResult(-1, intent3);
                finish();
            }
        }
        AppMethodBeat.o(39100);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(39101);
        gXK();
        super.onBackPressed();
        AppMethodBeat.o(39101);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(39102);
        switch (i2) {
            case 1:
                if (i3 == -1) {
                    setResult(-1, intent);
                    finish();
                    break;
                }
                break;
        }
        AppMethodBeat.o(39102);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        RegionCodeDecoder.Region region;
        RegionCodeDecoder.Region region2;
        RegionCodeDecoder.Region region3;
        AppMethodBeat.i(39103);
        if (i2 != 0 || i3 != 0) {
            gXM();
        } else if (qVar.getType() == 665) {
            g gVar = (g) qVar;
            String str2 = gVar.country;
            String str3 = gVar.fuJ;
            String str4 = gVar.fuK;
            Log.i("MicroMsg.MultiStageCitySelectUI", "current location country %s, province %s, city %s", str2, str3, str4);
            RegionCodeDecoder.Region[] gEo = RegionCodeDecoder.gEm().gEo();
            int length = gEo.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    region = null;
                    region2 = null;
                    region3 = null;
                    break;
                }
                region3 = gEo[i4];
                if (region3.getCode().equalsIgnoreCase(str2)) {
                    RegionCodeDecoder.Region[] bkQ = RegionCodeDecoder.gEm().bkQ(region3.getCode());
                    int length2 = bkQ.length;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length2) {
                            region = null;
                            region2 = null;
                            break;
                        }
                        region2 = bkQ[i5];
                        if (region2.getCode().equalsIgnoreCase(str3)) {
                            RegionCodeDecoder.Region[] mX = RegionCodeDecoder.gEm().mX(region3.getCode(), region2.getCode());
                            int length3 = mX.length;
                            int i6 = 0;
                            while (true) {
                                if (i6 >= length3) {
                                    region = null;
                                    break;
                                }
                                region = mX[i6];
                                if (region.getCode().equalsIgnoreCase(str4)) {
                                    break;
                                }
                                i6++;
                            }
                        } else {
                            i5++;
                        }
                    }
                } else {
                    i4++;
                }
            }
            if (region3 == null && region2 == null && region == null) {
                if (this.Qvz != null) {
                    this.Qvz.gYb();
                    AppMethodBeat.o(39103);
                    return;
                }
            } else if (this.Qvz != null) {
                ZoneRecommandPreference zoneRecommandPreference = this.Qvz;
                zoneRecommandPreference.status = 1;
                zoneRecommandPreference.Qxw = region3;
                zoneRecommandPreference.Qxx = region2;
                zoneRecommandPreference.Qxy = region;
                zoneRecommandPreference.gYa();
            }
            AppMethodBeat.o(39103);
            return;
        }
        AppMethodBeat.o(39103);
    }

    private void gXM() {
        AppMethodBeat.i(39104);
        if (this.Qvz != null) {
            this.Qvz.gYb();
        }
        AppMethodBeat.o(39104);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(39105);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.MultiStageCitySelectUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(39105);
            return;
        }
        Log.i("MicroMsg.MultiStageCitySelectUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        if (iArr.length == 0) {
            AppMethodBeat.o(39105);
            return;
        }
        switch (i2) {
            case 64:
                if (iArr[0] != 0) {
                    if (this.Qvz != null) {
                        this.Qvz.gYb();
                    }
                    this.kgv = false;
                    break;
                }
                break;
        }
        AppMethodBeat.o(39105);
    }

    public final void gXJ() {
        RegionCodeDecoder.Region[] regionArr;
        String str;
        String str2;
        String str3;
        AppMethodBeat.i(39094);
        if (this.dTz == 3) {
            ArrayList<RegionCodeDecoder.Region> arrayList = new ArrayList();
            RegionCodeDecoder.Region[] gEo = RegionCodeDecoder.gEm().gEo();
            if (gEo != null) {
                for (RegionCodeDecoder.Region region : gEo) {
                    if (WeChatBrands.AppInfo.LANG_HK.equalsIgnoreCase(region.getCode()) || WeChatBrands.AppInfo.LANG_TW.equalsIgnoreCase(region.getCode()) || "MO".equalsIgnoreCase(region.getCode())) {
                        arrayList.add(region);
                    }
                }
            }
            RegionCodeDecoder.Region[] bkQ = RegionCodeDecoder.gEm().bkQ(WeChatBrands.AppInfo.LANG_CN);
            int length = bkQ.length;
            regionArr = (RegionCodeDecoder.Region[]) Arrays.copyOf(bkQ, arrayList.size() + length);
            int i2 = 0;
            for (RegionCodeDecoder.Region region2 : arrayList) {
                regionArr[length + i2] = region2;
                i2++;
            }
        } else if (Util.isNullOrNil(this.countryCode)) {
            regionArr = RegionCodeDecoder.gEm().gEo();
            if (this.Qvx) {
                ArrayList arrayList2 = new ArrayList();
                if (regionArr != null) {
                    for (RegionCodeDecoder.Region region3 : regionArr) {
                        if (!this.QvC.contains(region3.getCode()) && !WeChatBrands.AppInfo.LANG_CN.equalsIgnoreCase(region3.getCode()) && !WeChatBrands.AppInfo.LANG_HK.equalsIgnoreCase(region3.getCode()) && !WeChatBrands.AppInfo.LANG_TW.equalsIgnoreCase(region3.getCode()) && !"MO".equalsIgnoreCase(region3.getCode())) {
                            arrayList2.add(region3);
                        }
                    }
                }
                regionArr = new RegionCodeDecoder.Region[arrayList2.size()];
                arrayList2.toArray(regionArr);
            } else if (regionArr != null) {
                ArrayList arrayList3 = new ArrayList();
                for (RegionCodeDecoder.Region region4 : regionArr) {
                    if (!this.QvC.contains(region4.getCode())) {
                        arrayList3.add(region4);
                    }
                }
                regionArr = new RegionCodeDecoder.Region[arrayList3.size()];
                arrayList3.toArray(regionArr);
            }
        } else if (Util.isNullOrNil(this.provinceCode)) {
            regionArr = RegionCodeDecoder.gEm().bkQ(this.countryCode);
        } else {
            regionArr = RegionCodeDecoder.gEm().mX(this.countryCode, this.provinceCode);
        }
        this.Qvt = regionArr;
        if (this.Qvt == null || this.Qvt.length <= 0) {
            Log.e("MicroMsg.MultiStageCitySelectUI", "initZoneItems error ,check zone lists!");
            AppMethodBeat.o(39094);
            return;
        }
        this.screen.removeAll();
        if (getIntent().getBooleanExtra("SetSelectLocation", false)) {
            str = getIntent().getStringExtra("SelectedCountryCode");
            str2 = getIntent().getStringExtra("SelectedProvinceCode");
            str3 = getIntent().getStringExtra("SelectedCityCode");
        } else {
            bg.aVF();
            str = (String) c.azQ().get(12324, (Object) null);
            bg.aVF();
            str2 = (String) c.azQ().get(12325, (Object) null);
            bg.aVF();
            str3 = (String) c.azQ().get(12326, (Object) null);
        }
        this.mShowSelectedLocation = getIntent().getBooleanExtra("ShowSelectedLocation", true);
        this.Qvw = getIntent().getBooleanExtra("NeedUnshowItem", false);
        if (this.Qvw) {
            ZonePreference zonePreference = new ZonePreference(this);
            RegionCodeDecoder.Region region5 = new RegionCodeDecoder.Region();
            region5.setName(getString(R.string.d9g));
            region5.setHasChildren(false);
            region5.setCountry(false);
            region5.setCode("unshow");
            zonePreference.a(region5);
            this.screen.c(zonePreference);
            if ("unshow".equals(str)) {
                zonePreference.setSummary(R.string.gmt);
            }
        }
        for (int i3 = 0; i3 < this.Qvt.length; i3++) {
            if (this.Qvt[i3] != null && !Util.isNullOrNil(this.Qvt[i3].getCode()) && !Util.isNullOrNil(this.Qvt[i3].getName())) {
                ZonePreference zonePreference2 = new ZonePreference(this);
                zonePreference2.a(this.Qvt[i3]);
                if (!this.mShowSelectedLocation) {
                    this.screen.c(zonePreference2);
                } else if (this.dTz == 0 && this.Qvt[i3].getCode().equalsIgnoreCase(str)) {
                    this.screen.a(zonePreference2, 0);
                    zonePreference2.setSummary(R.string.gmu);
                } else if (this.dTz == 1 && this.Qvt[i3].getCode().equalsIgnoreCase(str2)) {
                    this.screen.a(zonePreference2, 0);
                    zonePreference2.setSummary(R.string.gmu);
                } else if (this.dTz != 2 || !this.Qvt[i3].getCode().equalsIgnoreCase(str3)) {
                    this.screen.c(zonePreference2);
                } else {
                    this.screen.a(zonePreference2, 0);
                    zonePreference2.setSummary(R.string.gmu);
                }
            }
        }
        if (this.dTz == 3) {
            ZoneSelectOtherCountryPreference zoneSelectOtherCountryPreference = new ZoneSelectOtherCountryPreference(this);
            zoneSelectOtherCountryPreference.text = getString(R.string.gmp);
            zoneSelectOtherCountryPreference.QxB = new ZoneSelectOtherCountryPreference.a() {
                /* class com.tencent.mm.ui.tools.MultiStageCitySelectUI.AnonymousClass2 */

                @Override // com.tencent.mm.ui.tools.ZoneSelectOtherCountryPreference.a
                public final void onClick() {
                    AppMethodBeat.i(39086);
                    Intent intent = new Intent(MultiStageCitySelectUI.this, MultiStageCitySelectUI.class);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("GetAddress", MultiStageCitySelectUI.this.Qvu);
                    bundle.putBoolean("ShowSelectedLocation", MultiStageCitySelectUI.this.mShowSelectedLocation);
                    bundle.putBoolean("IsSelectNonChinaCountry", true);
                    bundle.putBoolean("IsAutoPosition", false);
                    bundle.putBoolean("IsNeedShowSearchBar", true);
                    intent.putExtras(bundle);
                    if (!MultiStageCitySelectUI.this.QvC.isEmpty()) {
                        intent.putStringArrayListExtra("BlockedCountries", MultiStageCitySelectUI.this.QvC);
                    }
                    MultiStageCitySelectUI.this.startActivityForResult(intent, 1);
                    AppMethodBeat.o(39086);
                }
            };
            this.screen.c(zoneSelectOtherCountryPreference);
        }
        this.screen.c(new PreferenceCategory(getContext()));
        if (this.dTz == 0 || this.dTz == 3) {
            if (this.Qvv) {
                PreferenceTitleCategory preferenceTitleCategory = new PreferenceTitleCategory(this);
                preferenceTitleCategory.setTitle(R.string.gmn);
                this.screen.a(preferenceTitleCategory, 0);
                this.Qvz = new ZoneRecommandPreference(this);
                this.Qvz.setKey("current_location");
                this.screen.a(this.Qvz, 1);
            }
            PreferenceTitleCategory preferenceTitleCategory2 = new PreferenceTitleCategory(this);
            preferenceTitleCategory2.setTitle(R.string.gmm);
            if (this.Qvv) {
                this.screen.a(preferenceTitleCategory2, 2);
                AppMethodBeat.o(39094);
                return;
            }
            this.screen.a(preferenceTitleCategory2, 0);
        }
        AppMethodBeat.o(39094);
    }

    static /* synthetic */ void j(MultiStageCitySelectUI multiStageCitySelectUI) {
        if (multiStageCitySelectUI.Qvr) {
            multiStageCitySelectUI.dTz = 3;
        } else if (multiStageCitySelectUI.countryCode == null) {
            multiStageCitySelectUI.dTz = 0;
        } else if (multiStageCitySelectUI.provinceCode == null) {
            multiStageCitySelectUI.dTz = 1;
        } else {
            multiStageCitySelectUI.dTz = 2;
        }
    }

    static /* synthetic */ void n(MultiStageCitySelectUI multiStageCitySelectUI) {
        AppMethodBeat.i(39108);
        if (!Util.isNullOrNil(multiStageCitySelectUI.QvB)) {
            new ArrayList();
            ArrayList<RegionCodeDecoder.Region> arrayList = new ArrayList();
            ArrayList<RegionCodeDecoder.Region> arrayList2 = new ArrayList();
            ArrayList<RegionCodeDecoder.Region> arrayList3 = new ArrayList();
            for (RegionCodeDecoder.Region region : QvA) {
                if (region.getName() != null && region.getName().contains(multiStageCitySelectUI.QvB)) {
                    if ((WeChatBrands.AppInfo.LANG_CN.equalsIgnoreCase(region.getCountryCode()) || WeChatBrands.AppInfo.LANG_HK.equalsIgnoreCase(region.getCountryCode()) || "MO".equalsIgnoreCase(region.getCountryCode()) || WeChatBrands.AppInfo.LANG_TW.equalsIgnoreCase(region.getCountryCode()) || ((region.getParent() == null || !region.hasChildren()) && (region.getParent() == null || region.hasChildren()))) && !multiStageCitySelectUI.QvC.contains(region.getCountryCode())) {
                        if (region.getParent() == null || (!WeChatBrands.AppInfo.LANG_HK.equalsIgnoreCase(region.getParent().getCode()) && !"MO".equalsIgnoreCase(region.getParent().getCode()) && !WeChatBrands.AppInfo.LANG_TW.equalsIgnoreCase(region.getParent().getCode()))) {
                            if (region.getParent() == null || (!WeChatBrands.AppInfo.LANG_CN.equalsIgnoreCase(region.getCountryCode()) && !WeChatBrands.AppInfo.LANG_HK.equalsIgnoreCase(region.getCountryCode()) && !"MO".equalsIgnoreCase(region.getCountryCode()) && !WeChatBrands.AppInfo.LANG_TW.equalsIgnoreCase(region.getCountryCode()))) {
                                if (region.getParent() != null || (!WeChatBrands.AppInfo.LANG_HK.equalsIgnoreCase(region.getCountryCode()) && !"MO".equalsIgnoreCase(region.getCountryCode()) && !WeChatBrands.AppInfo.LANG_TW.equalsIgnoreCase(region.getCountryCode()))) {
                                    arrayList.add(region);
                                } else {
                                    arrayList.add(region);
                                }
                            } else if (region.hasChildren() && region.getParent() != null) {
                                arrayList2.add(region);
                            } else if (!region.hasChildren() && region.getParent() != null) {
                                arrayList3.add(region);
                            }
                        }
                    }
                }
            }
            if (arrayList3.size() > 0) {
                PreferenceTitleCategory preferenceTitleCategory = new PreferenceTitleCategory(multiStageCitySelectUI);
                preferenceTitleCategory.setTitle(R.string.gmq);
                multiStageCitySelectUI.screen.c(preferenceTitleCategory);
                for (RegionCodeDecoder.Region region2 : arrayList3) {
                    ZonePreference zonePreference = new ZonePreference(multiStageCitySelectUI);
                    region2.setHasChildren(false);
                    zonePreference.a(region2);
                    multiStageCitySelectUI.screen.d(zonePreference);
                }
            }
            if (arrayList2.size() > 0) {
                PreferenceTitleCategory preferenceTitleCategory2 = new PreferenceTitleCategory(multiStageCitySelectUI);
                preferenceTitleCategory2.setTitle(R.string.gms);
                multiStageCitySelectUI.screen.c(preferenceTitleCategory2);
                for (RegionCodeDecoder.Region region3 : arrayList2) {
                    ZonePreference zonePreference2 = new ZonePreference(multiStageCitySelectUI);
                    zonePreference2.a(region3);
                    multiStageCitySelectUI.screen.d(zonePreference2);
                }
            }
            if (arrayList.size() > 0) {
                PreferenceTitleCategory preferenceTitleCategory3 = new PreferenceTitleCategory(multiStageCitySelectUI);
                preferenceTitleCategory3.setTitle(R.string.gmr);
                multiStageCitySelectUI.screen.c(preferenceTitleCategory3);
                for (RegionCodeDecoder.Region region4 : arrayList) {
                    ZonePreference zonePreference3 = new ZonePreference(multiStageCitySelectUI);
                    zonePreference3.a(region4);
                    multiStageCitySelectUI.screen.d(zonePreference3);
                }
            }
            multiStageCitySelectUI.screen.notifyDataSetChanged();
            multiStageCitySelectUI.Qvs = multiStageCitySelectUI.dTz;
            multiStageCitySelectUI.dTz = 4;
        }
        AppMethodBeat.o(39108);
    }
}
