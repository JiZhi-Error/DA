package com.tencent.mm.plugin.finder.upload.postui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.widget.post.a;
import com.tencent.mm.pluginsdk.location.b;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010+\u001a\u00020\u0018H\u0016J\u0006\u0010,\u001a\u00020-J\u0018\u0010.\u001a\u00020-2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010/\u001a\u00020-H\u0016J\b\u00100\u001a\u00020-H\u0016J\b\u00101\u001a\u00020-H\u0016J\u0006\u00102\u001a\u00020-J\u000e\u00103\u001a\u00020-2\u0006\u00104\u001a\u00020\u001eJ\u0006\u00105\u001a\u00020-J\u0006\u00106\u001a\u00020-J\b\u00107\u001a\u00020-H\u0002J\b\u00108\u001a\u00020\u0018H\u0016J\u0006\u00109\u001a\u00020-J\"\u0010:\u001a\u00020-2\b\u0010;\u001a\u0004\u0018\u00010\u000e2\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?R\u000e\u0010\r\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X.¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006@"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/postui/FinderLocationWidget;", "Lcom/tencent/mm/plugin/finder/upload/postui/IFinderPostWidget;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "locationView", "Lcom/tencent/mm/pluginsdk/location/ILocationView;", "poiTipsLayout", "Landroid/view/View;", "poiTipsTv", "Landroid/widget/TextView;", "reqCode", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/pluginsdk/location/ILocationView;Landroid/view/View;Landroid/widget/TextView;I)V", "TAG", "", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "finderLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getFinderLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "setFinderLocation", "(Lcom/tencent/mm/protocal/protobuf/FinderLocation;)V", "hasSet", "", "getHasSet", "()Z", "setHasSet", "(Z)V", "intent", "Landroid/content/Intent;", "isLoading", "setLoading", "getLocationView", "()Lcom/tencent/mm/pluginsdk/location/ILocationView;", "getPoiTipsLayout", "()Landroid/view/View;", "getPoiTipsTv", "()Landroid/widget/TextView;", "postData", "Landroid/os/Bundle;", "getReqCode", "()I", "canPost", "hidePoiTips", "", "onCreate", "onDestroy", "onPause", "onResume", "refreshLocationView", "saveLocationData", "i", "setDefaultState", "setLoadingState", "setPoi", "shouldInterceptBackPress", "showPoiTips", "trySuggestLocation", "city", "lbsLife", "Lcom/tencent/mm/protocal/protobuf/LbsLife;", "geoDegree", "Lcom/tencent/mm/plugin/finder/utils/GeoDegree;", "plugin-finder_release"})
public final class c {
    private final String TAG = "Finder.FinderLocationWidget";
    final MMActivity activity;
    private Intent intent;
    public boolean isLoading;
    final int lxP;
    private Bundle vUI;
    public axt vUM;
    public boolean vUN;
    public final b vUO;
    private final View vUP;
    private final TextView vUQ;

    public c(MMActivity mMActivity, b bVar, View view, TextView textView, int i2) {
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(bVar, "locationView");
        AppMethodBeat.i(253249);
        this.activity = mMActivity;
        this.vUO = bVar;
        this.vUP = view;
        this.vUQ = textView;
        this.lxP = i2;
        AppMethodBeat.o(253249);
    }

    public final void c(Intent intent2, Bundle bundle) {
        AppMethodBeat.i(253241);
        p.h(intent2, "intent");
        p.h(bundle, "postData");
        this.intent = intent2;
        this.vUI = bundle;
        View view = this.vUP;
        if (view != null) {
            view.setVisibility(8);
        }
        this.vUO.setLocationName(this.activity.getString(R.string.d0s));
        this.vUO.setOnClickLocationListener(new a(this, intent2));
        dBu();
        AppMethodBeat.o(253241);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onClickLocationView"})
    public static final class a implements b.a {
        final /* synthetic */ Intent $intent;
        final /* synthetic */ c vUR;

        a(c cVar, Intent intent) {
            this.vUR = cVar;
            this.$intent = intent;
        }

        @Override // com.tencent.mm.pluginsdk.location.b.a
        public final void dBx() {
            String str;
            String str2;
            float f2 = 0.0f;
            AppMethodBeat.i(253240);
            Intent intent = new Intent();
            intent.putExtra("near_life_scene", 6);
            axt axt = this.vUR.vUM;
            intent.putExtra("get_lat", axt != null ? axt.latitude : 0.0f);
            axt axt2 = this.vUR.vUM;
            if (axt2 != null) {
                f2 = axt2.dTj;
            }
            intent.putExtra("get_lng", f2);
            axt axt3 = this.vUR.vUM;
            if (axt3 == null || (str = axt3.LIb) == null) {
                str = "";
            }
            intent.putExtra("get_poi_classify_id", str);
            axt axt4 = this.vUR.vUM;
            if (axt4 == null || (str2 = axt4.fuK) == null) {
                str2 = "";
            }
            intent.putExtra("get_city", str2);
            intent.putExtra("is_force_dark_mode", this.$intent.getBooleanExtra("is_force_dark_mode", false));
            intent.putExtra("show_city", this.$intent.getBooleanExtra("show_city", true));
            intent.putExtra("poi_show_none", this.$intent.getBooleanExtra("poi_show_none", true));
            com.tencent.mm.br.c.b(this.vUR.activity, "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", intent, this.vUR.lxP);
            AppMethodBeat.o(253240);
        }
    }

    public final void dBu() {
        AppMethodBeat.i(253242);
        Intent intent2 = this.intent;
        if (intent2 == null) {
            p.btv("intent");
        }
        if (!intent2.getBooleanExtra("saveLocation", false)) {
            Log.i(this.TAG, "refreshLocationView no location data, return");
            AppMethodBeat.o(253242);
            return;
        }
        this.isLoading = false;
        dBv();
        axt axt = new axt();
        Intent intent3 = this.intent;
        if (intent3 == null) {
            p.btv("intent");
        }
        axt.kHV = Util.nullAs(intent3.getStringExtra("get_poi_name"), "");
        Intent intent4 = this.intent;
        if (intent4 == null) {
            p.btv("intent");
        }
        axt.fuK = Util.nullAs(intent4.getStringExtra("get_city"), "");
        Intent intent5 = this.intent;
        if (intent5 == null) {
            p.btv("intent");
        }
        axt.latitude = intent5.getFloatExtra("get_lat", -85.0f);
        Intent intent6 = this.intent;
        if (intent6 == null) {
            p.btv("intent");
        }
        axt.dTj = intent6.getFloatExtra("get_lng", -1000.0f);
        Intent intent7 = this.intent;
        if (intent7 == null) {
            p.btv("intent");
        }
        axt.ErZ = Util.nullAsNil(intent7.getStringExtra("get_poi_address"));
        Intent intent8 = this.intent;
        if (intent8 == null) {
            p.btv("intent");
        }
        axt.LIb = Util.nullAsNil(intent8.getStringExtra("get_poi_classify_id"));
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
        if (!FinderGlobalLocationVM.dHO()) {
            axt.source = 1;
        }
        this.vUM = axt;
        axt axt2 = this.vUM;
        if (axt2 != null) {
            Bundle bundle = this.vUI;
            if (bundle == null) {
                p.btv("postData");
            }
            a.C1355a aVar2 = com.tencent.mm.plugin.finder.widget.post.a.wCk;
            bundle.putByteArray(com.tencent.mm.plugin.finder.widget.post.a.dIY(), axt2.toByteArray());
            if (!Util.isNullOrNil(axt2.kHV) || !Util.isNullOrNil(axt2.fuK)) {
                b bVar = this.vUO;
                String str = axt2.fuK;
                if (str == null) {
                    str = "";
                }
                String str2 = axt2.kHV;
                if (str2 == null) {
                    str2 = "";
                }
                bVar.gM(str, str2);
            } else {
                this.vUO.diy();
            }
        }
        dBw();
        AppMethodBeat.o(253242);
    }

    public final void a(String str, chj chj) {
        AppMethodBeat.i(253243);
        p.h(chj, "lbsLife");
        if (!this.isLoading) {
            AppMethodBeat.o(253243);
            return;
        }
        this.vUN = true;
        if (Util.isNullOrNil(str)) {
            this.vUO.diy();
            i iVar = i.vfo;
            i.a(0, this.vUM);
            AppMethodBeat.o(253243);
            return;
        }
        Intent intent2 = this.intent;
        if (intent2 == null) {
            p.btv("intent");
        }
        intent2.putExtra("saveLocation", true);
        Intent intent3 = this.intent;
        if (intent3 == null) {
            p.btv("intent");
        }
        intent3.putExtra("get_poi_name", "");
        Intent intent4 = this.intent;
        if (intent4 == null) {
            p.btv("intent");
        }
        intent4.putExtra("get_city", Util.nullAsNil(str));
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
        o<Float, Float> dHP = FinderGlobalLocationVM.dHP();
        Intent intent5 = this.intent;
        if (intent5 == null) {
            p.btv("intent");
        }
        intent5.putExtra("get_lat", dHP.second.floatValue());
        Intent intent6 = this.intent;
        if (intent6 == null) {
            p.btv("intent");
        }
        intent6.putExtra("get_lng", dHP.first.floatValue());
        Intent intent7 = this.intent;
        if (intent7 == null) {
            p.btv("intent");
        }
        intent7.putExtra("get_poi_classify_type", chj.oUv);
        Intent intent8 = this.intent;
        if (intent8 == null) {
            p.btv("intent");
        }
        intent8.putExtra("get_poi_classify_id", "");
        dBu();
        axt axt = this.vUM;
        if (axt != null) {
            Bundle bundle = this.vUI;
            if (bundle == null) {
                p.btv("postData");
            }
            a.C1355a aVar2 = com.tencent.mm.plugin.finder.widget.post.a.wCk;
            bundle.putByteArray(com.tencent.mm.plugin.finder.widget.post.a.dIY(), axt.toByteArray());
        }
        this.vUO.setSuggestView(str);
        i iVar2 = i.vfo;
        i.a(1, this.vUM);
        AppMethodBeat.o(253243);
    }

    public final void diy() {
        AppMethodBeat.i(253244);
        this.isLoading = false;
        this.vUN = true;
        this.vUO.diy();
        AppMethodBeat.o(253244);
    }

    public final void ar(Intent intent2) {
        AppMethodBeat.i(253246);
        p.h(intent2, "i");
        Intent intent3 = this.intent;
        if (intent3 == null) {
            p.btv("intent");
        }
        intent3.putExtra("saveLocation", true);
        Intent intent4 = this.intent;
        if (intent4 == null) {
            p.btv("intent");
        }
        intent4.putExtra("get_poi_name", Util.nullAs(intent2.getStringExtra("get_poi_name"), ""));
        Intent intent5 = this.intent;
        if (intent5 == null) {
            p.btv("intent");
        }
        intent5.putExtra("get_city", Util.nullAs(intent2.getStringExtra("get_city"), ""));
        Intent intent6 = this.intent;
        if (intent6 == null) {
            p.btv("intent");
        }
        intent6.putExtra("get_lat", intent2.getFloatExtra("get_lat", -85.0f));
        Intent intent7 = this.intent;
        if (intent7 == null) {
            p.btv("intent");
        }
        intent7.putExtra("get_lng", intent2.getFloatExtra("get_lng", -1000.0f));
        Intent intent8 = this.intent;
        if (intent8 == null) {
            p.btv("intent");
        }
        intent8.putExtra("get_poi_address", Util.nullAsNil(intent2.getStringExtra("get_poi_address")));
        Intent intent9 = this.intent;
        if (intent9 == null) {
            p.btv("intent");
        }
        intent9.putExtra("get_poi_classify_id", Util.nullAsNil(intent2.getStringExtra("get_poi_classify_id")));
        AppMethodBeat.o(253246);
    }

    private void dBv() {
        AppMethodBeat.i(253247);
        View view = this.vUP;
        if (view != null) {
            view.setVisibility(8);
            AppMethodBeat.o(253247);
            return;
        }
        AppMethodBeat.o(253247);
    }

    private final void dBw() {
        String str;
        String str2;
        String str3 = null;
        AppMethodBeat.i(253248);
        JSONObject jSONObject = new JSONObject();
        axt axt = this.vUM;
        if (axt == null || (str = axt.LIb) == null) {
            str = "";
        }
        jSONObject.put("poiClassifyId", str);
        axt axt2 = this.vUM;
        jSONObject.put("longitude", axt2 != null ? Float.valueOf(axt2.dTj) : Float.valueOf(0.0f));
        axt axt3 = this.vUM;
        jSONObject.put("latitude", axt3 != null ? Float.valueOf(axt3.latitude) : Float.valueOf(0.0f));
        axt axt4 = this.vUM;
        if (axt4 != null) {
            str2 = axt4.fuK;
        } else {
            str2 = null;
        }
        jSONObject.put("city", Util.nullAs(str2, ""));
        axt axt5 = this.vUM;
        if (axt5 != null) {
            str3 = axt5.ErZ;
        }
        jSONObject.put("poiname", Util.nullAs(str3, ""));
        k kVar = k.vkd;
        k.aM(jSONObject);
        AppMethodBeat.o(253248);
    }
}
