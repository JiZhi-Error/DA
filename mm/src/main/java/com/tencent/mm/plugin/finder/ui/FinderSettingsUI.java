package com.tencent.mm.plugin.finder.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.storage.config.e;
import com.tencent.mm.plugin.finder.ui.j;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.h;
import com.tencent.mm.ui.tools.s;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0002J\b\u0010\u0010\u001a\u00020\fH\u0002J\b\u0010\u0011\u001a\u00020\fH\u0014J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\fH\u0014J\u001c\u0010\u0017\u001a\u00020\u00182\b\u0010\u0007\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderSettingsUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "screen", "Lcom/tencent/mm/ui/base/preference/MMPreferenceAdapter;", "getResourceId", "", "handleAddPreference", "", "list", "", "Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "importConfig", "initView", "intiViewByConfigArray", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPreferenceTreeClick", "", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "Companion", "plugin-finder_release"})
public final class FinderSettingsUI extends MMPreference {
    private static ArrayList<e> vOB;
    public static final a vOC = new a((byte) 0);
    private final String TAG = "MicroMsg.FinderDebugSettingsUI";
    private HashMap _$_findViewCache;
    private h vOA;

    static {
        AppMethodBeat.i(167667);
        AppMethodBeat.o(167667);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252694);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252694);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252693);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252693);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FinderSettingsUI() {
        AppMethodBeat.i(167666);
        AppMethodBeat.o(167666);
    }

    public static final /* synthetic */ void a(FinderSettingsUI finderSettingsUI, List list) {
        AppMethodBeat.i(252692);
        finderSettingsUI.ex(list);
        AppMethodBeat.o(252692);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R.\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderSettingsUI$Companion;", "", "()V", "CONFIG_ARRAY", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "Lkotlin/collections/ArrayList;", "getCONFIG_ARRAY", "()Ljava/util/ArrayList;", "setCONFIG_ARRAY", "(Ljava/util/ArrayList;)V", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(167662);
        super.onCreate(bundle);
        setMMTitle("视频号维修厂");
        setBackBtn(new c(this));
        ArrayList<e> arrayList = vOB;
        if (arrayList == null || arrayList.isEmpty()) {
            e[] eVarArr = new e[TbsListener.ErrorCode.DECOUPLE_TPATCH_FAIL];
            eVarArr[0] = new com.tencent.mm.plugin.finder.storage.config.a("新版本");
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[1] = com.tencent.mm.plugin.finder.storage.c.hVj();
            com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[2] = com.tencent.mm.plugin.finder.storage.c.hVi();
            com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[3] = com.tencent.mm.plugin.finder.storage.c.hVk();
            com.tencent.mm.plugin.finder.storage.c cVar4 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[4] = com.tencent.mm.plugin.finder.storage.c.hUO();
            com.tencent.mm.plugin.finder.storage.c cVar5 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[5] = com.tencent.mm.plugin.finder.storage.c.dra();
            com.tencent.mm.plugin.finder.storage.c cVar6 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[6] = com.tencent.mm.plugin.finder.storage.c.dqE();
            com.tencent.mm.plugin.finder.storage.c cVar7 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[7] = com.tencent.mm.plugin.finder.storage.c.dqF();
            com.tencent.mm.plugin.finder.storage.c cVar8 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[8] = com.tencent.mm.plugin.finder.storage.c.dvM();
            com.tencent.mm.plugin.finder.storage.c cVar9 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[9] = com.tencent.mm.plugin.finder.storage.c.dvN();
            com.tencent.mm.plugin.finder.storage.c cVar10 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[10] = com.tencent.mm.plugin.finder.storage.c.dvO();
            com.tencent.mm.plugin.finder.storage.c cVar11 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[11] = com.tencent.mm.plugin.finder.storage.c.dtp();
            com.tencent.mm.plugin.finder.storage.c cVar12 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[12] = com.tencent.mm.plugin.finder.storage.c.dsE();
            com.tencent.mm.plugin.finder.storage.c cVar13 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[13] = com.tencent.mm.plugin.finder.storage.c.dsF();
            com.tencent.mm.plugin.finder.storage.c cVar14 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[14] = com.tencent.mm.plugin.finder.storage.c.dsG();
            com.tencent.mm.plugin.finder.storage.c cVar15 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[15] = com.tencent.mm.plugin.finder.storage.c.dsH();
            com.tencent.mm.plugin.finder.storage.c cVar16 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[16] = com.tencent.mm.plugin.finder.storage.c.dsI();
            com.tencent.mm.plugin.finder.storage.c cVar17 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[17] = com.tencent.mm.plugin.finder.storage.c.dsJ();
            com.tencent.mm.plugin.finder.storage.c cVar18 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[18] = com.tencent.mm.plugin.finder.storage.c.dsK();
            com.tencent.mm.plugin.finder.storage.c cVar19 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[19] = com.tencent.mm.plugin.finder.storage.c.dsL();
            com.tencent.mm.plugin.finder.storage.c cVar20 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[20] = com.tencent.mm.plugin.finder.storage.c.dsM();
            com.tencent.mm.plugin.finder.storage.c cVar21 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[21] = com.tencent.mm.plugin.finder.storage.c.duy();
            com.tencent.mm.plugin.finder.storage.c cVar22 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[22] = com.tencent.mm.plugin.finder.storage.c.dvD();
            com.tencent.mm.plugin.finder.storage.c cVar23 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[23] = com.tencent.mm.plugin.finder.storage.c.dvI();
            com.tencent.mm.plugin.finder.storage.c cVar24 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[24] = com.tencent.mm.plugin.finder.storage.c.dvP();
            com.tencent.mm.plugin.finder.storage.c cVar25 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[25] = com.tencent.mm.plugin.finder.storage.c.dvQ();
            com.tencent.mm.plugin.finder.storage.c cVar26 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[26] = com.tencent.mm.plugin.finder.storage.c.dqK();
            com.tencent.mm.plugin.finder.storage.c cVar27 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[27] = com.tencent.mm.plugin.finder.storage.c.dvF();
            com.tencent.mm.plugin.finder.storage.c cVar28 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[28] = com.tencent.mm.plugin.finder.storage.c.dvG();
            com.tencent.mm.plugin.finder.storage.c cVar29 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[29] = com.tencent.mm.plugin.finder.storage.c.dvH();
            com.tencent.mm.plugin.finder.storage.c cVar30 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[30] = com.tencent.mm.plugin.finder.storage.c.dvy();
            com.tencent.mm.plugin.finder.storage.c cVar31 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[31] = com.tencent.mm.plugin.finder.storage.c.dvz();
            com.tencent.mm.plugin.finder.storage.c cVar32 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[32] = com.tencent.mm.plugin.finder.storage.c.duA();
            com.tencent.mm.plugin.finder.storage.c cVar33 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[33] = com.tencent.mm.plugin.finder.storage.c.duC();
            com.tencent.mm.plugin.finder.storage.c cVar34 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[34] = com.tencent.mm.plugin.finder.storage.c.duD();
            com.tencent.mm.plugin.finder.storage.c cVar35 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[35] = com.tencent.mm.plugin.finder.storage.c.duv();
            com.tencent.mm.plugin.finder.storage.c cVar36 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[36] = com.tencent.mm.plugin.finder.storage.c.dtQ();
            com.tencent.mm.plugin.finder.storage.c cVar37 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[37] = com.tencent.mm.plugin.finder.storage.c.dtN();
            com.tencent.mm.plugin.finder.storage.c cVar38 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[38] = com.tencent.mm.plugin.finder.storage.c.dud();
            com.tencent.mm.plugin.finder.storage.c cVar39 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[39] = com.tencent.mm.plugin.finder.storage.c.duw();
            com.tencent.mm.plugin.finder.storage.c cVar40 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[40] = com.tencent.mm.plugin.finder.storage.c.dux();
            com.tencent.mm.plugin.finder.storage.c cVar41 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[41] = com.tencent.mm.plugin.finder.storage.c.duz();
            com.tencent.mm.plugin.finder.storage.c cVar42 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[42] = com.tencent.mm.plugin.finder.storage.c.dtV();
            com.tencent.mm.plugin.finder.storage.c cVar43 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[43] = com.tencent.mm.plugin.finder.storage.c.dtW();
            com.tencent.mm.plugin.finder.storage.c cVar44 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[44] = com.tencent.mm.plugin.finder.storage.c.dso();
            com.tencent.mm.plugin.finder.storage.c cVar45 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[45] = com.tencent.mm.plugin.finder.storage.c.dsq();
            com.tencent.mm.plugin.finder.storage.c cVar46 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[46] = com.tencent.mm.plugin.finder.storage.c.dsr();
            com.tencent.mm.plugin.finder.storage.c cVar47 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[47] = com.tencent.mm.plugin.finder.storage.c.dtB();
            com.tencent.mm.plugin.finder.storage.c cVar48 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[48] = com.tencent.mm.plugin.finder.storage.c.dtS();
            com.tencent.mm.plugin.finder.storage.c cVar49 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[49] = com.tencent.mm.plugin.finder.storage.c.dss();
            com.tencent.mm.plugin.finder.storage.c cVar50 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[50] = com.tencent.mm.plugin.finder.storage.c.dte();
            com.tencent.mm.plugin.finder.storage.c cVar51 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[51] = com.tencent.mm.plugin.finder.storage.c.dst();
            com.tencent.mm.plugin.finder.storage.c cVar52 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[52] = com.tencent.mm.plugin.finder.storage.c.dtC();
            com.tencent.mm.plugin.finder.storage.c cVar53 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[53] = com.tencent.mm.plugin.finder.storage.c.dtI();
            com.tencent.mm.plugin.finder.storage.c cVar54 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[54] = com.tencent.mm.plugin.finder.storage.c.dtT();
            com.tencent.mm.plugin.finder.storage.c cVar55 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[55] = com.tencent.mm.plugin.finder.storage.c.dtR();
            com.tencent.mm.plugin.finder.storage.c cVar56 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[56] = com.tencent.mm.plugin.finder.storage.c.dtZ();
            com.tencent.mm.plugin.finder.storage.c cVar57 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[57] = com.tencent.mm.plugin.finder.storage.c.dqz();
            com.tencent.mm.plugin.finder.storage.c cVar58 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[58] = com.tencent.mm.plugin.finder.storage.c.dvK();
            com.tencent.mm.plugin.finder.storage.c cVar59 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[59] = com.tencent.mm.plugin.finder.storage.c.dvL();
            com.tencent.mm.plugin.finder.storage.c cVar60 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[60] = com.tencent.mm.plugin.finder.storage.c.hUV();
            com.tencent.mm.plugin.finder.storage.c cVar61 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[61] = com.tencent.mm.plugin.finder.storage.c.hUW();
            com.tencent.mm.plugin.finder.storage.c cVar62 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[62] = com.tencent.mm.plugin.finder.storage.c.dvv();
            com.tencent.mm.plugin.finder.storage.c cVar63 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[63] = com.tencent.mm.plugin.finder.storage.c.dvw();
            com.tencent.mm.plugin.finder.storage.c cVar64 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[64] = com.tencent.mm.plugin.finder.storage.c.dxh();
            com.tencent.mm.plugin.finder.storage.c cVar65 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[65] = com.tencent.mm.plugin.finder.storage.c.hVb();
            com.tencent.mm.plugin.finder.storage.c cVar66 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[66] = com.tencent.mm.plugin.finder.storage.c.dwX();
            eVarArr[67] = new com.tencent.mm.plugin.finder.storage.config.a("体验相关");
            com.tencent.mm.plugin.finder.storage.c cVar67 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[68] = com.tencent.mm.plugin.finder.storage.c.hVc();
            com.tencent.mm.plugin.finder.storage.c cVar68 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[69] = com.tencent.mm.plugin.finder.storage.c.dwq();
            com.tencent.mm.plugin.finder.storage.c cVar69 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[70] = com.tencent.mm.plugin.finder.storage.c.dwp();
            com.tencent.mm.plugin.finder.storage.c cVar70 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[71] = com.tencent.mm.plugin.finder.storage.c.dwz();
            com.tencent.mm.plugin.finder.storage.c cVar71 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[72] = com.tencent.mm.plugin.finder.storage.c.dws();
            com.tencent.mm.plugin.finder.storage.c cVar72 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[73] = com.tencent.mm.plugin.finder.storage.c.dwr();
            com.tencent.mm.plugin.finder.storage.c cVar73 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[74] = com.tencent.mm.plugin.finder.storage.c.dwt();
            com.tencent.mm.plugin.finder.storage.c cVar74 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[75] = com.tencent.mm.plugin.finder.storage.c.dwu();
            com.tencent.mm.plugin.finder.storage.c cVar75 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[76] = com.tencent.mm.plugin.finder.storage.c.dww();
            com.tencent.mm.plugin.finder.storage.c cVar76 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[77] = com.tencent.mm.plugin.finder.storage.c.dwv();
            com.tencent.mm.plugin.finder.storage.c cVar77 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[78] = com.tencent.mm.plugin.finder.storage.c.dwx();
            com.tencent.mm.plugin.finder.storage.c cVar78 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[79] = com.tencent.mm.plugin.finder.storage.c.hVa();
            com.tencent.mm.plugin.finder.storage.c cVar79 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[80] = com.tencent.mm.plugin.finder.storage.c.dwy();
            com.tencent.mm.plugin.finder.storage.c cVar80 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[81] = com.tencent.mm.plugin.finder.storage.c.dtK();
            com.tencent.mm.plugin.finder.storage.c cVar81 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[82] = com.tencent.mm.plugin.finder.storage.c.dtL();
            com.tencent.mm.plugin.finder.storage.c cVar82 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[83] = com.tencent.mm.plugin.finder.storage.c.dsu();
            com.tencent.mm.plugin.finder.storage.c cVar83 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[84] = com.tencent.mm.plugin.finder.storage.c.dsv();
            com.tencent.mm.plugin.finder.storage.c cVar84 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[85] = com.tencent.mm.plugin.finder.storage.c.hUP();
            com.tencent.mm.plugin.finder.storage.c cVar85 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[86] = com.tencent.mm.plugin.finder.storage.c.dsx();
            com.tencent.mm.plugin.finder.storage.c cVar86 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[87] = com.tencent.mm.plugin.finder.storage.c.dvJ();
            eVarArr[88] = new com.tencent.mm.plugin.finder.storage.config.a("直播");
            com.tencent.mm.plugin.finder.storage.c cVar87 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[89] = com.tencent.mm.plugin.finder.storage.c.duL();
            com.tencent.mm.plugin.finder.storage.c cVar88 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[90] = com.tencent.mm.plugin.finder.storage.c.duM();
            com.tencent.mm.plugin.finder.storage.c cVar89 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[91] = com.tencent.mm.plugin.finder.storage.c.hUS();
            com.tencent.mm.plugin.finder.storage.c cVar90 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[92] = com.tencent.mm.plugin.finder.storage.c.duN();
            com.tencent.mm.plugin.finder.storage.c cVar91 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[93] = com.tencent.mm.plugin.finder.storage.c.duR();
            com.tencent.mm.plugin.finder.storage.c cVar92 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[94] = com.tencent.mm.plugin.finder.storage.c.duT();
            com.tencent.mm.plugin.finder.storage.c cVar93 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[95] = com.tencent.mm.plugin.finder.storage.c.duV();
            com.tencent.mm.plugin.finder.storage.c cVar94 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[96] = com.tencent.mm.plugin.finder.storage.c.dvb();
            com.tencent.mm.plugin.finder.storage.c cVar95 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[97] = com.tencent.mm.plugin.finder.storage.c.duO();
            com.tencent.mm.plugin.finder.storage.c cVar96 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[98] = com.tencent.mm.plugin.finder.storage.c.dwi();
            com.tencent.mm.plugin.finder.storage.c cVar97 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[99] = com.tencent.mm.plugin.finder.storage.c.dvi();
            com.tencent.mm.plugin.finder.storage.c cVar98 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[100] = com.tencent.mm.plugin.finder.storage.c.dvl();
            com.tencent.mm.plugin.finder.storage.c cVar99 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[101] = com.tencent.mm.plugin.finder.storage.c.dwF();
            com.tencent.mm.plugin.finder.storage.c cVar100 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[102] = com.tencent.mm.plugin.finder.storage.c.dwG();
            com.tencent.mm.plugin.finder.storage.c cVar101 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[103] = com.tencent.mm.plugin.finder.storage.c.dvW();
            com.tencent.mm.plugin.finder.storage.c cVar102 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[104] = com.tencent.mm.plugin.finder.storage.c.dvX();
            com.tencent.mm.plugin.finder.storage.c cVar103 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[105] = com.tencent.mm.plugin.finder.storage.c.dvo();
            com.tencent.mm.plugin.finder.storage.c cVar104 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[106] = com.tencent.mm.plugin.finder.storage.c.dwd();
            com.tencent.mm.plugin.finder.storage.c cVar105 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[107] = com.tencent.mm.plugin.finder.storage.c.dwg();
            com.tencent.mm.plugin.finder.storage.c cVar106 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[108] = com.tencent.mm.plugin.finder.storage.c.dwe();
            com.tencent.mm.plugin.finder.storage.c cVar107 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[109] = com.tencent.mm.plugin.finder.storage.c.dwh();
            com.tencent.mm.plugin.finder.storage.c cVar108 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[110] = com.tencent.mm.plugin.finder.storage.c.dwf();
            com.tencent.mm.plugin.finder.storage.c cVar109 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[111] = com.tencent.mm.plugin.finder.storage.c.dwl();
            com.tencent.mm.plugin.finder.storage.c cVar110 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[112] = com.tencent.mm.plugin.finder.storage.c.dwm();
            com.tencent.mm.plugin.finder.storage.c cVar111 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[113] = com.tencent.mm.plugin.finder.storage.c.hUX();
            com.tencent.mm.plugin.finder.storage.c cVar112 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[114] = com.tencent.mm.plugin.finder.storage.c.hUY();
            com.tencent.mm.plugin.finder.storage.c cVar113 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[115] = com.tencent.mm.plugin.finder.storage.c.dxe();
            com.tencent.mm.plugin.finder.storage.c cVar114 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[116] = com.tencent.mm.plugin.finder.storage.c.hVf();
            eVarArr[117] = new com.tencent.mm.plugin.finder.storage.config.a("测试");
            com.tencent.mm.plugin.finder.storage.c cVar115 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[118] = com.tencent.mm.plugin.finder.storage.c.dxc();
            com.tencent.mm.plugin.finder.storage.c cVar116 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[119] = com.tencent.mm.plugin.finder.storage.c.dwB();
            com.tencent.mm.plugin.finder.storage.c cVar117 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[120] = com.tencent.mm.plugin.finder.storage.c.hUR();
            com.tencent.mm.plugin.finder.storage.c cVar118 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[121] = com.tencent.mm.plugin.finder.storage.c.dwn();
            com.tencent.mm.plugin.finder.storage.c cVar119 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[122] = com.tencent.mm.plugin.finder.storage.c.dtJ();
            com.tencent.mm.plugin.finder.storage.c cVar120 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[123] = com.tencent.mm.plugin.finder.storage.c.dtY();
            com.tencent.mm.plugin.finder.storage.c cVar121 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[124] = com.tencent.mm.plugin.finder.storage.c.dsy();
            com.tencent.mm.plugin.finder.storage.c cVar122 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[125] = com.tencent.mm.plugin.finder.storage.c.dsz();
            com.tencent.mm.plugin.finder.storage.c cVar123 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[126] = com.tencent.mm.plugin.finder.storage.c.hUQ();
            com.tencent.mm.plugin.finder.storage.c cVar124 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[127] = com.tencent.mm.plugin.finder.storage.c.dsA();
            com.tencent.mm.plugin.finder.storage.c cVar125 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[128] = com.tencent.mm.plugin.finder.storage.c.dsB();
            com.tencent.mm.plugin.finder.storage.c cVar126 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[129] = com.tencent.mm.plugin.finder.storage.c.dsC();
            com.tencent.mm.plugin.finder.storage.c cVar127 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[130] = com.tencent.mm.plugin.finder.storage.c.dsD();
            com.tencent.mm.plugin.finder.storage.c cVar128 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[131] = com.tencent.mm.plugin.finder.storage.c.dsN();
            com.tencent.mm.plugin.finder.storage.c cVar129 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[132] = com.tencent.mm.plugin.finder.storage.c.dsO();
            com.tencent.mm.plugin.finder.storage.c cVar130 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[133] = com.tencent.mm.plugin.finder.storage.c.dsQ();
            com.tencent.mm.plugin.finder.storage.c cVar131 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[134] = com.tencent.mm.plugin.finder.storage.c.dsT();
            com.tencent.mm.plugin.finder.storage.c cVar132 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[135] = com.tencent.mm.plugin.finder.storage.c.dsU();
            com.tencent.mm.plugin.finder.storage.c cVar133 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[136] = com.tencent.mm.plugin.finder.storage.c.dsV();
            com.tencent.mm.plugin.finder.storage.c cVar134 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[137] = com.tencent.mm.plugin.finder.storage.c.dsW();
            com.tencent.mm.plugin.finder.storage.c cVar135 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[138] = com.tencent.mm.plugin.finder.storage.c.dsX();
            com.tencent.mm.plugin.finder.storage.c cVar136 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[139] = com.tencent.mm.plugin.finder.storage.c.dsY();
            com.tencent.mm.plugin.finder.storage.c cVar137 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[140] = com.tencent.mm.plugin.finder.storage.c.dsZ();
            com.tencent.mm.plugin.finder.storage.c cVar138 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[141] = com.tencent.mm.plugin.finder.storage.c.dta();
            com.tencent.mm.plugin.finder.storage.c cVar139 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[142] = com.tencent.mm.plugin.finder.storage.c.dtb();
            com.tencent.mm.plugin.finder.storage.c cVar140 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[143] = com.tencent.mm.plugin.finder.storage.c.dtc();
            com.tencent.mm.plugin.finder.storage.c cVar141 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[144] = com.tencent.mm.plugin.finder.storage.c.dtd();
            com.tencent.mm.plugin.finder.storage.c cVar142 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[145] = com.tencent.mm.plugin.finder.storage.c.dtf();
            com.tencent.mm.plugin.finder.storage.c cVar143 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[146] = com.tencent.mm.plugin.finder.storage.c.dtg();
            com.tencent.mm.plugin.finder.storage.c cVar144 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[147] = com.tencent.mm.plugin.finder.storage.c.dti();
            com.tencent.mm.plugin.finder.storage.c cVar145 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[148] = com.tencent.mm.plugin.finder.storage.c.dtj();
            com.tencent.mm.plugin.finder.storage.c cVar146 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[149] = com.tencent.mm.plugin.finder.storage.c.dtk();
            com.tencent.mm.plugin.finder.storage.c cVar147 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[150] = com.tencent.mm.plugin.finder.storage.c.dua();
            com.tencent.mm.plugin.finder.storage.c cVar148 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[151] = com.tencent.mm.plugin.finder.storage.c.dub();
            com.tencent.mm.plugin.finder.storage.c cVar149 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[152] = com.tencent.mm.plugin.finder.storage.c.duc();
            eVarArr[153] = new com.tencent.mm.plugin.finder.storage.config.a("私信");
            com.tencent.mm.plugin.finder.storage.c cVar150 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[154] = com.tencent.mm.plugin.finder.storage.c.dtG();
            com.tencent.mm.plugin.finder.storage.c cVar151 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[155] = com.tencent.mm.plugin.finder.storage.c.dqZ();
            eVarArr[156] = new com.tencent.mm.plugin.finder.storage.config.a("三天两夜");
            com.tencent.mm.plugin.finder.storage.c cVar152 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[157] = com.tencent.mm.plugin.finder.storage.c.duI();
            com.tencent.mm.plugin.finder.storage.c cVar153 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[158] = com.tencent.mm.plugin.finder.storage.c.duJ();
            com.tencent.mm.plugin.finder.storage.c cVar154 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[159] = com.tencent.mm.plugin.finder.storage.c.duK();
            eVarArr[160] = new com.tencent.mm.plugin.finder.storage.config.a("tab流预加载");
            com.tencent.mm.plugin.finder.storage.c cVar155 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[161] = com.tencent.mm.plugin.finder.storage.c.duH();
            com.tencent.mm.plugin.finder.storage.c cVar156 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[162] = com.tencent.mm.plugin.finder.storage.c.dsa();
            com.tencent.mm.plugin.finder.storage.c cVar157 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[163] = com.tencent.mm.plugin.finder.storage.c.due();
            com.tencent.mm.plugin.finder.storage.c cVar158 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[164] = com.tencent.mm.plugin.finder.storage.c.duf();
            com.tencent.mm.plugin.finder.storage.c cVar159 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[165] = com.tencent.mm.plugin.finder.storage.c.dug();
            com.tencent.mm.plugin.finder.storage.c cVar160 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[166] = com.tencent.mm.plugin.finder.storage.c.duh();
            com.tencent.mm.plugin.finder.storage.c cVar161 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[167] = com.tencent.mm.plugin.finder.storage.c.dui();
            com.tencent.mm.plugin.finder.storage.c cVar162 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[168] = com.tencent.mm.plugin.finder.storage.c.duj();
            com.tencent.mm.plugin.finder.storage.c cVar163 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[169] = com.tencent.mm.plugin.finder.storage.c.duk();
            com.tencent.mm.plugin.finder.storage.c cVar164 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[170] = com.tencent.mm.plugin.finder.storage.c.dul();
            com.tencent.mm.plugin.finder.storage.c cVar165 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[171] = com.tencent.mm.plugin.finder.storage.c.dum();
            com.tencent.mm.plugin.finder.storage.c cVar166 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[172] = com.tencent.mm.plugin.finder.storage.c.dun();
            com.tencent.mm.plugin.finder.storage.c cVar167 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[173] = com.tencent.mm.plugin.finder.storage.c.duo();
            com.tencent.mm.plugin.finder.storage.c cVar168 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[174] = com.tencent.mm.plugin.finder.storage.c.dup();
            com.tencent.mm.plugin.finder.storage.c cVar169 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[175] = com.tencent.mm.plugin.finder.storage.c.duq();
            com.tencent.mm.plugin.finder.storage.c cVar170 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[176] = com.tencent.mm.plugin.finder.storage.c.dur();
            com.tencent.mm.plugin.finder.storage.c cVar171 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[177] = com.tencent.mm.plugin.finder.storage.c.dus();
            com.tencent.mm.plugin.finder.storage.c cVar172 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[178] = com.tencent.mm.plugin.finder.storage.c.dut();
            com.tencent.mm.plugin.finder.storage.c cVar173 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[179] = com.tencent.mm.plugin.finder.storage.c.duu();
            eVarArr[180] = new com.tencent.mm.plugin.finder.storage.config.a("其他");
            com.tencent.mm.plugin.finder.storage.c cVar174 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[181] = com.tencent.mm.plugin.finder.storage.c.dtl();
            com.tencent.mm.plugin.finder.storage.c cVar175 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[182] = com.tencent.mm.plugin.finder.storage.c.dtm();
            com.tencent.mm.plugin.finder.storage.c cVar176 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[183] = com.tencent.mm.plugin.finder.storage.c.dtn();
            com.tencent.mm.plugin.finder.storage.c cVar177 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[184] = com.tencent.mm.plugin.finder.storage.c.dto();
            com.tencent.mm.plugin.finder.storage.c cVar178 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[185] = com.tencent.mm.plugin.finder.storage.c.dtq();
            com.tencent.mm.plugin.finder.storage.c cVar179 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[186] = com.tencent.mm.plugin.finder.storage.c.dtr();
            com.tencent.mm.plugin.finder.storage.c cVar180 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[187] = com.tencent.mm.plugin.finder.storage.c.dts();
            com.tencent.mm.plugin.finder.storage.c cVar181 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[188] = com.tencent.mm.plugin.finder.storage.c.dtt();
            com.tencent.mm.plugin.finder.storage.c cVar182 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[189] = com.tencent.mm.plugin.finder.storage.c.dtu();
            com.tencent.mm.plugin.finder.storage.c cVar183 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[190] = com.tencent.mm.plugin.finder.storage.c.dtv();
            com.tencent.mm.plugin.finder.storage.c cVar184 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[191] = com.tencent.mm.plugin.finder.storage.c.dtw();
            com.tencent.mm.plugin.finder.storage.c cVar185 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[192] = com.tencent.mm.plugin.finder.storage.c.dtx();
            com.tencent.mm.plugin.finder.storage.c cVar186 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[193] = com.tencent.mm.plugin.finder.storage.c.dty();
            com.tencent.mm.plugin.finder.storage.c cVar187 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[194] = com.tencent.mm.plugin.finder.storage.c.dtz();
            com.tencent.mm.plugin.finder.storage.c cVar188 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[195] = com.tencent.mm.plugin.finder.storage.c.dtA();
            com.tencent.mm.plugin.finder.storage.c cVar189 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[196] = com.tencent.mm.plugin.finder.storage.c.dth();
            com.tencent.mm.plugin.finder.storage.c cVar190 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[197] = com.tencent.mm.plugin.finder.storage.c.dtM();
            com.tencent.mm.plugin.finder.storage.c cVar191 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[198] = com.tencent.mm.plugin.finder.storage.c.duF();
            com.tencent.mm.plugin.finder.storage.c cVar192 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[199] = com.tencent.mm.plugin.finder.storage.c.duG();
            com.tencent.mm.plugin.finder.storage.c cVar193 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[200] = com.tencent.mm.plugin.finder.storage.c.dvx();
            com.tencent.mm.plugin.finder.storage.c cVar194 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[201] = com.tencent.mm.plugin.finder.storage.c.duG();
            com.tencent.mm.plugin.finder.storage.c cVar195 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[202] = com.tencent.mm.plugin.finder.storage.c.dvA();
            com.tencent.mm.plugin.finder.storage.c cVar196 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[203] = com.tencent.mm.plugin.finder.storage.c.dvB();
            com.tencent.mm.plugin.finder.storage.c cVar197 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[204] = com.tencent.mm.plugin.finder.storage.c.dvC();
            com.tencent.mm.plugin.finder.storage.c cVar198 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[205] = com.tencent.mm.plugin.finder.storage.c.dvE();
            com.tencent.mm.plugin.finder.storage.c cVar199 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[206] = com.tencent.mm.plugin.finder.storage.c.dwo();
            com.tencent.mm.plugin.finder.storage.c cVar200 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[207] = com.tencent.mm.plugin.finder.storage.c.dvR();
            com.tencent.mm.plugin.finder.storage.c cVar201 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[208] = com.tencent.mm.plugin.finder.storage.c.dvS();
            com.tencent.mm.plugin.finder.storage.c cVar202 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[209] = com.tencent.mm.plugin.finder.storage.c.dvT();
            com.tencent.mm.plugin.finder.storage.c cVar203 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[210] = com.tencent.mm.plugin.finder.storage.c.dvU();
            com.tencent.mm.plugin.finder.storage.c cVar204 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[211] = com.tencent.mm.plugin.finder.storage.c.dvV();
            com.tencent.mm.plugin.finder.storage.c cVar205 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[212] = com.tencent.mm.plugin.finder.storage.c.dwj();
            com.tencent.mm.plugin.finder.storage.c cVar206 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[213] = com.tencent.mm.plugin.finder.storage.c.dwk();
            com.tencent.mm.plugin.finder.storage.c cVar207 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[214] = com.tencent.mm.plugin.finder.storage.c.dwC();
            com.tencent.mm.plugin.finder.storage.c cVar208 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[215] = com.tencent.mm.plugin.finder.storage.c.dwD();
            com.tencent.mm.plugin.finder.storage.c cVar209 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[216] = com.tencent.mm.plugin.finder.storage.c.dwE();
            com.tencent.mm.plugin.finder.storage.c cVar210 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[217] = com.tencent.mm.plugin.finder.storage.c.dwH();
            com.tencent.mm.plugin.finder.storage.c cVar211 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[218] = com.tencent.mm.plugin.finder.storage.c.dwI();
            com.tencent.mm.plugin.finder.storage.c cVar212 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[219] = com.tencent.mm.plugin.finder.storage.c.dwL();
            com.tencent.mm.plugin.finder.storage.c cVar213 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[220] = com.tencent.mm.plugin.finder.storage.c.dwJ();
            com.tencent.mm.plugin.finder.storage.c cVar214 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[221] = com.tencent.mm.plugin.finder.storage.c.dwK();
            com.tencent.mm.plugin.finder.storage.c cVar215 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[222] = com.tencent.mm.plugin.finder.storage.c.dwR();
            com.tencent.mm.plugin.finder.storage.c cVar216 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[223] = com.tencent.mm.plugin.finder.storage.c.dwS();
            com.tencent.mm.plugin.finder.storage.c cVar217 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[224] = com.tencent.mm.plugin.finder.storage.c.dwT();
            com.tencent.mm.plugin.finder.storage.c cVar218 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[225] = com.tencent.mm.plugin.finder.storage.c.dwM();
            com.tencent.mm.plugin.finder.storage.c cVar219 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[226] = com.tencent.mm.plugin.finder.storage.c.dwN();
            com.tencent.mm.plugin.finder.storage.c cVar220 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[227] = com.tencent.mm.plugin.finder.storage.c.dwO();
            com.tencent.mm.plugin.finder.storage.c cVar221 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[228] = com.tencent.mm.plugin.finder.storage.c.dwP();
            com.tencent.mm.plugin.finder.storage.c cVar222 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[229] = com.tencent.mm.plugin.finder.storage.c.dwQ();
            com.tencent.mm.plugin.finder.storage.c cVar223 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[230] = com.tencent.mm.plugin.finder.storage.c.dwU();
            com.tencent.mm.plugin.finder.storage.c cVar224 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[231] = com.tencent.mm.plugin.finder.storage.c.dwV();
            com.tencent.mm.plugin.finder.storage.c cVar225 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[232] = com.tencent.mm.plugin.finder.storage.c.dwW();
            com.tencent.mm.plugin.finder.storage.c cVar226 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[233] = com.tencent.mm.plugin.finder.storage.c.dxa();
            com.tencent.mm.plugin.finder.storage.c cVar227 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[234] = com.tencent.mm.plugin.finder.storage.c.dxb();
            com.tencent.mm.plugin.finder.storage.c cVar228 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[235] = com.tencent.mm.plugin.finder.storage.c.hVd();
            com.tencent.mm.plugin.finder.storage.c cVar229 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[236] = com.tencent.mm.plugin.finder.storage.c.hVg();
            com.tencent.mm.plugin.finder.storage.c cVar230 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[237] = com.tencent.mm.plugin.finder.storage.c.hVd();
            com.tencent.mm.plugin.finder.storage.c cVar231 = com.tencent.mm.plugin.finder.storage.c.vCb;
            eVarArr[238] = com.tencent.mm.plugin.finder.storage.c.hVh();
            ArrayList<e> ac = j.ac(eVarArr);
            vOB = ac;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : ac) {
                String dyq = ((e) obj).dyq();
                if (dyq == null) {
                    t tVar = new t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(167662);
                    throw tVar;
                }
                String upperCase = dyq.toUpperCase();
                p.g(upperCase, "(this as java.lang.String).toUpperCase()");
                if ("T5".compareTo(upperCase) <= 0) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = arrayList2;
            ac.removeAll(arrayList3);
            ac.add(0, new com.tencent.mm.plugin.finder.storage.config.a("T5"));
            Boolean.valueOf(ac.addAll(1, arrayList3));
            ArrayList<e> arrayList4 = vOB;
            if (arrayList4 != null) {
                Iterator<T> it = arrayList4.iterator();
                while (it.hasNext()) {
                    it.next().dKq = this;
                }
                x xVar = x.SXb;
            }
        }
        initView();
        s sVar = new s((byte) 0);
        sVar.a(new b(this));
        addSearchMenu(true, sVar);
        AppMethodBeat.o(167662);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class c implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderSettingsUI vOD;

        c(FinderSettingsUI finderSettingsUI) {
            this.vOD = finderSettingsUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(167660);
            this.vOD.finish();
            AppMethodBeat.o(167660);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\f¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$onCreate$searchViewHelper$1$1", "Lcom/tencent/mm/ui/tools/SearchViewHelper$ISearchListener;", "onClickClearText", "", "onEnterSearch", "onQuitSearch", "onSearchChange", "searchText", "", "onSearchEditTextReady", "onSearchKeyDown", "", "plugin-finder_release"})
    public static final class b implements s.b {
        final /* synthetic */ FinderSettingsUI vOD;

        b(FinderSettingsUI finderSettingsUI) {
            this.vOD = finderSettingsUI;
        }

        @Override // com.tencent.mm.ui.tools.s.b
        public final boolean SN(String str) {
            return false;
        }

        @Override // com.tencent.mm.ui.tools.s.b
        public final void bnA() {
        }

        @Override // com.tencent.mm.ui.tools.s.b
        public final void bnz() {
        }

        @Override // com.tencent.mm.ui.tools.s.b
        public final void SO(String str) {
            ArrayList arrayList;
            FinderSettingsUI finderSettingsUI;
            AppMethodBeat.i(252687);
            p.h(str, "searchText");
            h hVar = this.vOD.vOA;
            if (hVar != null) {
                hVar.removeAll();
            }
            FinderSettingsUI finderSettingsUI2 = this.vOD;
            a aVar = FinderSettingsUI.vOC;
            ArrayList arrayList2 = FinderSettingsUI.vOB;
            if (arrayList2 != null) {
                ArrayList arrayList3 = new ArrayList();
                for (Object obj : arrayList2) {
                    if (n.e(((e) obj).title, str)) {
                        arrayList3.add(obj);
                    }
                }
                arrayList = arrayList3;
                finderSettingsUI = finderSettingsUI2;
            } else {
                arrayList = null;
                finderSettingsUI = finderSettingsUI2;
            }
            FinderSettingsUI.a(finderSettingsUI, arrayList);
            AppMethodBeat.o(252687);
        }

        @Override // com.tencent.mm.ui.tools.s.b
        public final void bny() {
            AppMethodBeat.i(252688);
            h hVar = this.vOD.vOA;
            if (hVar != null) {
                hVar.removeAll();
            }
            FinderSettingsUI finderSettingsUI = this.vOD;
            a aVar = FinderSettingsUI.vOC;
            FinderSettingsUI.a(finderSettingsUI, FinderSettingsUI.vOB);
            AppMethodBeat.o(252688);
        }

        @Override // com.tencent.mm.ui.tools.s.b
        public final void bnB() {
        }
    }

    private final void ex(List<? extends e> list) {
        AppMethodBeat.i(252689);
        if (list != null) {
            for (T t : list) {
                if (t instanceof com.tencent.mm.plugin.finder.storage.config.a) {
                    h hVar = this.vOA;
                    if (hVar != null) {
                        PreferenceTitleCategory preferenceTitleCategory = new PreferenceTitleCategory(this);
                        preferenceTitleCategory.setTitle(t.title);
                        hVar.c(preferenceTitleCategory);
                    }
                } else if (t instanceof com.tencent.mm.plugin.finder.storage.config.c) {
                    new j.e(this, t);
                } else if (t instanceof com.tencent.mm.plugin.finder.storage.config.item.integer.a) {
                    new j.d(this, t);
                } else if (t instanceof com.tencent.mm.plugin.finder.storage.config.item.c) {
                    new j.d(this, t);
                } else if (t instanceof com.tencent.mm.plugin.finder.storage.config.item.longtype.a) {
                    new j.d(this, t);
                } else if (t instanceof com.tencent.mm.plugin.finder.storage.config.item.booleantype.a) {
                    new j.c(this, t);
                }
            }
            AppMethodBeat.o(252689);
            return;
        }
        AppMethodBeat.o(252689);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(167663);
        super.onDestroy();
        ArrayList<e> arrayList = vOB;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().dKq = null;
            }
            AppMethodBeat.o(167663);
            return;
        }
        AppMethodBeat.o(167663);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(252690);
        f preferenceScreen = getPreferenceScreen();
        if (preferenceScreen == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.MMPreferenceAdapter");
            AppMethodBeat.o(252690);
            throw tVar;
        }
        this.vOA = (h) preferenceScreen;
        if (this.vOA == null) {
            p.hyc();
        }
        ex(vOB);
        h hVar = this.vOA;
        if (hVar != null) {
            hVar.notifyDataSetChanged();
            AppMethodBeat.o(252690);
            return;
        }
        AppMethodBeat.o(252690);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public final int getResourceId() {
        return R.xml.b2;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public final boolean onPreferenceTreeClick(f fVar, Preference preference) {
        Preference preference2;
        AppMethodBeat.i(252691);
        if (!(preference instanceof j.f)) {
            preference2 = null;
        } else {
            preference2 = preference;
        }
        j.f fVar2 = (j.f) preference2;
        if (fVar2 != null) {
            fVar2.dAo();
        }
        MediaPreloadCore.a aVar = MediaPreloadCore.uTV;
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        MediaPreloadCore.uTU = ((Boolean) com.tencent.mm.plugin.finder.storage.c.dsv().value()).booleanValue();
        AppMethodBeat.o(252691);
        return true;
    }
}
