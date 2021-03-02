package com.tencent.mm.plugin.finder.viewmodel;

import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.hy;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.location.model.g;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponentPlugin;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\f\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001'B\u0005¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u000fJ\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u0015J\u0006\u0010\u0017\u001a\u00020\u0018J,\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0006\u0010\"\u001a\u00020\u001aJ\u000e\u0010#\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u0016H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "lastAddress", "Lcom/tencent/mm/protocal/protobuf/GetCurLocationResponse;", "getLastAddress", "()Lcom/tencent/mm/protocal/protobuf/GetCurLocationResponse;", "setLastAddress", "(Lcom/tencent/mm/protocal/protobuf/GetCurLocationResponse;)V", "locationListener", "com/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$locationListener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$locationListener$1;", "checkLocationPermissionWithRequest", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "checkLocationPermissionWithoutRequest", "forceRequestLocation", "lastLocation", "Lkotlin/Pair;", "", "lastLocationTime", "", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "requestLocation", "requestLocationPermission", "storeLocation", "longitude", "latitude", "Companion", "plugin-finder_release"})
public final class FinderGlobalLocationVM extends UIComponentPlugin<PluginFinder> implements i {
    public static final a wtQ = new a((byte) 0);
    public bme wtO;
    private final c wtP = new c(this);

    static {
        AppMethodBeat.i(255328);
        AppMethodBeat.o(255328);
    }

    public FinderGlobalLocationVM() {
        AppMethodBeat.i(255327);
        StringBuilder sb = new StringBuilder("isGetGps=");
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        Log.i("Finder.GlobalLocationVM", sb.append(com.tencent.mm.plugin.finder.storage.c.drM()).toString());
        AppMethodBeat.o(255327);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$Companion;", "", "()V", "REQUST_PERMISSION_CODE", "", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$locationListener$1", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "onGetLocation", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "speed", "", "accuracy", "altitude", "plugin-finder_release"})
    public static final class c implements b.a {
        final /* synthetic */ FinderGlobalLocationVM wtR;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(FinderGlobalLocationVM finderGlobalLocationVM) {
            this.wtR = finderGlobalLocationVM;
        }

        @Override // com.tencent.mm.modelgeo.b.a
        public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
            AppMethodBeat.i(255317);
            com.tencent.mm.modelgeo.d.bca().c(this);
            z.b bVar = new z.b();
            bVar.SYC = (double) f2;
            z.b bVar2 = new z.b();
            bVar2.SYC = (double) f3;
            if (z) {
                FinderGlobalLocationVM.U(f2, f3);
                Log.i("Finder.GlobalLocationVM", "[onGetLocation] longitude=" + bVar.SYC + " latitude=" + bVar2.SYC);
                hy hyVar = new hy();
                hyVar.dMA.lng = (double) f2;
                hyVar.dMA.lat = (double) f3;
                EventCenter.instance.publish(hyVar);
            } else {
                o<Float, Float> dHP = FinderGlobalLocationVM.dHP();
                bVar.SYC = (double) dHP.first.floatValue();
                bVar2.SYC = (double) dHP.second.floatValue();
                Log.i("Finder.GlobalLocationVM", "[onGetLocation] from cache. longitude=" + bVar.SYC + " latitude=" + bVar2.SYC);
            }
            h.RTc.aX(new a(this, bVar2, bVar));
            AppMethodBeat.o(255317);
            return true;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ c wtS;
            final /* synthetic */ z.b wtT;
            final /* synthetic */ z.b wtU;

            a(c cVar, z.b bVar, z.b bVar2) {
                this.wtS = cVar;
                this.wtT = bVar;
                this.wtU = bVar2;
            }

            public final void run() {
                AppMethodBeat.i(255316);
                g gVar = new g(this.wtT.SYC, this.wtU.SYC);
                com.tencent.mm.kernel.g.azz().a(665, this.wtS.wtR);
                com.tencent.mm.kernel.g.azz().b(gVar);
                AppMethodBeat.o(255316);
            }
        }
    }

    public static boolean dHO() {
        AppMethodBeat.i(255321);
        boolean k = com.tencent.mm.pluginsdk.permission.b.k(MMApplicationContext.getContext(), "android.permission.ACCESS_FINE_LOCATION", false);
        AppMethodBeat.o(255321);
        return k;
    }

    public static boolean h(MMActivity mMActivity) {
        AppMethodBeat.i(255322);
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(mMActivity, "android.permission.ACCESS_FINE_LOCATION", 79, (String) null, (String) null);
        AppMethodBeat.o(255322);
        return a2;
    }

    public final void cxh() {
        AppMethodBeat.i(255323);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (!com.tencent.mm.plugin.finder.storage.c.drM()) {
            Log.w("Finder.GlobalLocationVM", "[requestLocation] is not enabel");
            AppMethodBeat.o(255323);
        } else if (!dHO()) {
            Log.w("Finder.GlobalLocationVM", "[requestLocation] without perssion.");
            AppMethodBeat.o(255323);
        } else {
            Log.i("Finder.GlobalLocationVM", "[requestLocation]...");
            com.tencent.mm.ac.d.c("Finder.GlobalLocationVM#RequestLocation", new d(this));
            AppMethodBeat.o(255323);
        }
    }

    public static o<Float, Float> dHP() {
        float f2;
        float f3 = 0.0f;
        AppMethodBeat.i(255324);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        Object obj = aAh.azQ().get(ar.a.USERINFO_FINDER_LOCATION_STRING, ";");
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(255324);
            throw tVar;
        }
        List<String> a2 = n.a((CharSequence) ((String) obj), new char[]{';'});
        Float buy = n.buy(a2.get(0));
        if (buy != null) {
            f2 = buy.floatValue();
        } else {
            f2 = 0.0f;
        }
        Float buy2 = n.buy(a2.get(1));
        if (buy2 != null) {
            f3 = buy2.floatValue();
        }
        o<Float, Float> oVar = new o<>(Float.valueOf(f2), Float.valueOf(f3));
        AppMethodBeat.o(255324);
        return oVar;
    }

    public static long dHQ() {
        AppMethodBeat.i(255325);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        long a2 = aAh.azQ().a(ar.a.USERINFO_FINDER_LOCATION_TIME_LONG, 0);
        AppMethodBeat.o(255325);
        return a2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    public static final class e implements DialogInterface.OnClickListener {
        final /* synthetic */ MMActivity nbB;

        public e(MMActivity mMActivity) {
            this.nbB = mMActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(255319);
            k kVar = k.vfA;
            k.ac(this.nbB, 4);
            MMActivity mMActivity = this.nbB;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            com.tencent.mm.hellhoundlib.a.a.a(mMActivity, bl.axQ(), "com/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$requestLocationPermission$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            mMActivity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(mMActivity, "com/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM$requestLocationPermission$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(255319);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    public static final class f implements DialogInterface.OnClickListener {
        final /* synthetic */ MMActivity nbB;

        public f(MMActivity mMActivity) {
            this.nbB = mMActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(255320);
            k kVar = k.vfA;
            k.ac(this.nbB, 3);
            AppMethodBeat.o(255320);
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(255326);
        if (qVar != null) {
            switch (qVar.getType()) {
                case 665:
                    com.tencent.mm.kernel.g.azz().b(665, this);
                    if (i2 == 0 && i3 == 0) {
                        this.wtO = ((g) qVar).ecK();
                    }
                    bme bme = this.wtO;
                    if (bme == null) {
                        Log.i("Finder.GlobalLocationVM", "Get Location Fail");
                        break;
                    } else if (Util.isNullOrNil(bme.keh)) {
                        this.wtO = null;
                        Log.i("Finder.GlobalLocationVM", "Get Location Fail");
                        AppMethodBeat.o(255326);
                        return;
                    } else {
                        String str2 = bme.kdZ;
                        if (str2 == null) {
                            str2 = "";
                        }
                        bme.kdZ = str2;
                        String str3 = bme.kea;
                        if (str3 == null) {
                            str3 = "";
                        }
                        bme.kea = str3;
                        Log.i("Finder.GlobalLocationVM", "Get Location " + bme.keh + ' ' + bme.kdZ + ' ' + bme.kea);
                        AppMethodBeat.o(255326);
                        return;
                    }
            }
        }
        AppMethodBeat.o(255326);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderGlobalLocationVM wtR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderGlobalLocationVM finderGlobalLocationVM) {
            super(0);
            this.wtR = finderGlobalLocationVM;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(255318);
            com.tencent.mm.modelgeo.d.bca().b(this.wtR.wtP);
            x xVar = x.SXb;
            AppMethodBeat.o(255318);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderGlobalLocationVM wtR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(FinderGlobalLocationVM finderGlobalLocationVM) {
            super(0);
            this.wtR = finderGlobalLocationVM;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(255315);
            com.tencent.mm.modelgeo.d.bca().b(this.wtR.wtP);
            x xVar = x.SXb;
            AppMethodBeat.o(255315);
            return xVar;
        }
    }

    public static final /* synthetic */ void U(float f2, float f3) {
        AppMethodBeat.i(255329);
        long aWA = cl.aWA();
        Log.i("Finder.GlobalLocationVM", "[storeLocation] longitude=" + f2 + " latitude=" + f3 + " time=" + aWA);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_FINDER_LOCATION_STRING, new StringBuilder().append(f2).append(';').append(f3).toString());
        com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh2, "MMKernel.storage()");
        aAh2.azQ().set(ar.a.USERINFO_FINDER_LOCATION_TIME_LONG, Long.valueOf(aWA));
        AppMethodBeat.o(255329);
    }
}
