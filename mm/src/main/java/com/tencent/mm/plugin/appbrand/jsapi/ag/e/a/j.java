package com.tencent.mm.plugin.appbrand.jsapi.ag.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.k;
import com.tencent.mm.sdk.platformtools.InetUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.v;
import kotlin.l;
import kotlin.l.k;
import kotlin.n.n;
import kotlin.x;
import rx.d;
import rx.schedulers.Schedulers;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e*\u0002\u0014'\u0018\u0000 92\u00020\u0001:\u00019B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010/\u001a\u00020\u000eJ\u0006\u00100\u001a\u00020\u000eJ\u0006\u00101\u001a\u00020\u000eJ\u0006\u00102\u001a\u00020\u000eJ)\u00103\u001a\u00020\u000e2!\u00104\u001a\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u000e0\u001dJ\u0006\u00105\u001a\u00020\u000eJ\u0018\u00106\u001a\u00020\u000e2\u000e\b\u0002\u00107\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\b\u00108\u001a\u00020\u001eH\u0002R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR7\u0010\u001c\u001a\u001f\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0010\u0010&\u001a\u00020'X\u0004¢\u0006\u0004\n\u0002\u0010(R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR\u0011\u0010+\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u0006:"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager;", "", "()V", "<set-?>", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "currentSelectedDevice", "getCurrentSelectedDevice", "()Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "setCurrentSelectedDevice", "(Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;)V", "currentSelectedDevice$delegate", "Lkotlin/properties/ReadWriteProperty;", "deviceDataChanged", "Lkotlin/Function0;", "", "getDeviceDataChanged", "()Lkotlin/jvm/functions/Function0;", "setDeviceDataChanged", "(Lkotlin/jvm/functions/Function0;)V", "deviceSearchEventListener", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$deviceSearchEventListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$deviceSearchEventListener$1;", "dummyMRDevice", "recentDevices", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/MRDeviceWithStatus;", "getRecentDevices", "()Ljava/util/ArrayList;", "reconnectCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isReconnectSuccess", "getReconnectCallback", "()Lkotlin/jvm/functions/Function1;", "setReconnectCallback", "(Lkotlin/jvm/functions/Function1;)V", "reconnectListener", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$reconnectListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$reconnectListener$1;", "scannedDevices", "getScannedDevices", "subscription", "Lrx/subscriptions/CompositeSubscription;", "getSubscription", "()Lrx/subscriptions/CompositeSubscription;", "clear", "playError", "playSuccess", "prepareAndSearchDevice", "reconnect", "callback", "search", "searchReleaseTimer", "onTimeOut", "tryInit", "Companion", "luggage-xweb-ext_release"})
public final class j {
    static final /* synthetic */ k[] cLI = {aa.a(new v(aa.bp(j.class), "currentSelectedDevice", "getCurrentSelectedDevice()Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;"))};
    public static final b mNb = new b((byte) 0);
    private final com.tencent.mm.plugin.appbrand.g.b.c mMS = new com.tencent.mm.plugin.appbrand.g.b.c(null);
    private final kotlin.i.c mMT;
    final ArrayList<e> mMU;
    final ArrayList<e> mMV;
    kotlin.g.a.a<x> mMW;
    final rx.f.b mMX;
    kotlin.g.a.b<? super Boolean, x> mMY;
    private final d mMZ;
    private final c mNa;

    static {
        AppMethodBeat.i(139796);
        AppMethodBeat.o(139796);
    }

    public final com.tencent.mm.plugin.appbrand.g.b.c bMs() {
        AppMethodBeat.i(139797);
        com.tencent.mm.plugin.appbrand.g.b.c cVar = (com.tencent.mm.plugin.appbrand.g.b.c) this.mMT.a(cLI[0]);
        AppMethodBeat.o(139797);
        return cVar;
    }

    public final void g(com.tencent.mm.plugin.appbrand.g.b.c cVar) {
        AppMethodBeat.i(139798);
        p.h(cVar, "<set-?>");
        this.mMT.a(cLI[0], cVar);
        AppMethodBeat.o(139798);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class f extends q implements kotlin.g.a.a<x> {
        public static final f mNe = new f();

        static {
            AppMethodBeat.i(139794);
            AppMethodBeat.o(139794);
        }

        f() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    public j() {
        AppMethodBeat.i(139807);
        kotlin.i.a aVar = kotlin.i.a.SYL;
        com.tencent.mm.plugin.appbrand.g.b.c cVar = this.mMS;
        this.mMT = new a(cVar, cVar, this);
        this.mMU = new ArrayList<>();
        this.mMV = new ArrayList<>();
        this.mMX = new rx.f.b();
        this.mMZ = new d(this);
        this.mNa = new c(this);
        AppMethodBeat.o(139807);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$Companion;", "", "()V", "KEY_MMKV_SAVED_DEVICE", "", "SEARCH_PERIOD_MS", "", "SEARCH_TIMES", "", "SEARCH_TIME_OUT", "TAG", "luggage-xweb-ext_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\b¨\u0006\t¸\u0006\u0000"}, hxF = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
    public static final class a extends kotlin.i.b<com.tencent.mm.plugin.appbrand.g.b.c> {
        final /* synthetic */ Object mKT;
        final /* synthetic */ j mNc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Object obj, Object obj2, j jVar) {
            super(obj2);
            this.mKT = obj;
            this.mNc = jVar;
        }

        @Override // kotlin.i.b
        public final void a(k<?> kVar, com.tencent.mm.plugin.appbrand.g.b.c cVar, com.tencent.mm.plugin.appbrand.g.b.c cVar2) {
            AppMethodBeat.i(139787);
            p.h(kVar, "property");
            com.tencent.mm.plugin.appbrand.g.b.c cVar3 = cVar2;
            if ((!p.j(cVar, cVar3)) && cVar3.bBo() != null) {
                p.h(cVar3, "$this$saveDevice");
                com.tencent.f.h.RTc.aX(new k.a(cVar3, MultiProcessMMKV.getSingleDefault()));
                for (T t : this.mNc.mMU) {
                    t.isSelected = false;
                    t.hmV = false;
                    com.tencent.mm.plugin.appbrand.g.b.b bBo = t.mLG.bBo();
                    String str = bBo != null ? bBo.ljS : null;
                    com.tencent.mm.plugin.appbrand.g.b.b bBo2 = this.mNc.bMs().bBo();
                    if (p.j(str, bBo2 != null ? bBo2.ljS : null)) {
                        t.hmV = true;
                        t.mLF = false;
                        t.isSelected = true;
                    }
                }
                for (T t2 : this.mNc.mMV) {
                    t2.isSelected = false;
                    t2.hmV = false;
                    com.tencent.mm.plugin.appbrand.g.b.b bBo3 = t2.mLG.bBo();
                    String str2 = bBo3 != null ? bBo3.ljS : null;
                    com.tencent.mm.plugin.appbrand.g.b.b bBo4 = this.mNc.bMs().bBo();
                    if (p.j(str2, bBo4 != null ? bBo4.ljS : null)) {
                        t2.hmV = true;
                        t2.mLF = false;
                        t2.isSelected = true;
                    }
                }
                kotlin.g.a.a<x> aVar = this.mNc.mMW;
                if (aVar != null) {
                    aVar.invoke();
                    AppMethodBeat.o(139787);
                    return;
                }
            }
            AppMethodBeat.o(139787);
        }
    }

    public final void bMt() {
        AppMethodBeat.i(139799);
        Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", "prepare");
        if (!bMw()) {
            AppMethodBeat.o(139799);
            return;
        }
        com.tencent.mm.plugin.appbrand.g.b.a.bBl().a(this.mNa);
        bMu();
        a(this);
        AppMethodBeat.o(139799);
    }

    private void bMu() {
        AppMethodBeat.i(139800);
        String Ph = com.tencent.luggage.h.h.Ph();
        String aN = com.tencent.luggage.h.h.aN(MMApplicationContext.getContext());
        boolean z = InetUtil.isIPv6Address(Ph) && InetUtil.isIPv6Address(aN);
        Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", "searchDevice: selfIp = [%s], wifiIp = [%s], ipv6 = [%b]", Ph, aN, Boolean.valueOf(z));
        this.mMX.b(rx.d.a(TimeUnit.MILLISECONDS, Schedulers.computation()).hQz().a(com.tencent.mm.plugin.appbrand.g.d.a.bBF()).a(new e(z)));
        AppMethodBeat.o(139800);
    }

    private static /* synthetic */ void a(j jVar) {
        AppMethodBeat.i(139802);
        f fVar = f.mNe;
        jVar.bMv();
        AppMethodBeat.o(139802);
    }

    private final void bMv() {
        AppMethodBeat.i(139801);
        this.mMX.b(rx.d.a((d.a) new rx.internal.a.f(TimeUnit.SECONDS, Schedulers.computation())).a(new g(this)));
        AppMethodBeat.o(139801);
    }

    public final void v(kotlin.g.a.b<? super Boolean, x> bVar) {
        AppMethodBeat.i(178860);
        p.h(bVar, "callback");
        try {
            this.mMX.clear();
            com.tencent.mm.plugin.appbrand.g.b.a bBl = com.tencent.mm.plugin.appbrand.g.b.a.bBl();
            bBl.bBn();
            p.g(bBl, "deviceManager");
            for (com.tencent.mm.plugin.appbrand.g.b.c cVar : bBl.bBm()) {
                cVar.bBs();
                cVar.bBt();
                cVar.a((com.tencent.mm.plugin.appbrand.g.b.d) null);
            }
            bBl.b(this.mNa);
            bBl.b(this.mMZ);
            bBl.destroy();
            try {
                com.tencent.mm.plugin.appbrand.g.c.h.bBB().disable();
            } catch (com.tencent.mm.plugin.appbrand.g.c.c.a e2) {
            }
            com.tencent.mm.plugin.appbrand.g.c.c.bBw().disable();
        } catch (Exception e3) {
            Log.e("MicroMsg.VideoCast.VideoCastDeviceManager", "Error happen while cleaning up " + e3.getMessage());
        }
        if (!bMw()) {
            Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", "reconnect: not enableRouter");
            AppMethodBeat.o(178860);
            return;
        }
        this.mMY = bVar;
        com.tencent.mm.plugin.appbrand.g.b.a.bBl().a(this.mMZ);
        bMu();
        a(this);
        AppMethodBeat.o(178860);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$tryInit$1", "Lcom/tencent/mm/plugin/appbrand/dlna/IDlnaLogger;", "e", "", "tag", "", "msg", "i", "printErrStackTrace", LocaleUtil.TURKEY, "", "format", "luggage-xweb-ext_release"})
    public static final class h implements com.tencent.mm.plugin.appbrand.g.b {
        h() {
        }

        @Override // com.tencent.mm.plugin.appbrand.g.b
        public final void a(String str, Throwable th, String str2) {
            AppMethodBeat.i(216008);
            p.h(str, "tag");
            p.h(th, LocaleUtil.TURKEY);
            p.h(str2, "format");
            Log.printErrStackTrace(str, th, str2, new Object[0]);
            AppMethodBeat.o(216008);
        }

        @Override // com.tencent.mm.plugin.appbrand.g.b
        public final void i(String str, String str2) {
            AppMethodBeat.i(216009);
            p.h(str, "tag");
            p.h(str2, "msg");
            Log.i(str, str2);
            AppMethodBeat.o(216009);
        }

        @Override // com.tencent.mm.plugin.appbrand.g.b
        public final void e(String str, String str2) {
            AppMethodBeat.i(216010);
            p.h(str, "tag");
            p.h(str2, "msg");
            Log.e(str, str2);
            AppMethodBeat.o(216010);
        }
    }

    private static boolean bMw() {
        AppMethodBeat.i(216011);
        try {
            com.tencent.mm.plugin.appbrand.g.a.a("MicroMsg.VideoCast.", new h());
            com.tencent.mm.plugin.appbrand.g.c.h.bBB().enable();
            com.tencent.mm.plugin.appbrand.g.c.c.bBw().enable();
            AppMethodBeat.o(216011);
            return true;
        } catch (com.tencent.mm.plugin.appbrand.g.c.c.a e2) {
            Log.e("MicroMsg.VideoCast.VideoCastDeviceManager", "prepareAndSearchDevice: RouterException = " + e2.getMessage());
            AppMethodBeat.o(216011);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$reconnectListener$1", "Lcom/tencent/mm/plugin/appbrand/dlna/device/DeviceManager$OnDeviceChangeListener;", "onAddDevice", "", "device", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "onRemoveDevice", "onUpdateDevice", "luggage-xweb-ext_release"})
    public static final class d implements a.AbstractC0581a {
        final /* synthetic */ j mNc;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(j jVar) {
            this.mNc = jVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.g.b.a.AbstractC0581a
        public final void a(com.tencent.mm.plugin.appbrand.g.b.c cVar) {
            String str;
            com.tencent.mm.plugin.appbrand.g.b.b bBo;
            AppMethodBeat.i(139791);
            if (cVar == null || (bBo = cVar.bBo()) == null || (str = bBo.ljS) == null) {
                str = "";
            }
            Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", "onAddDevice: udn = ".concat(String.valueOf(str)));
            if (cVar == null || n.aL(str)) {
                kotlin.g.a.b<? super Boolean, x> bVar = this.mNc.mMY;
                if (bVar != null) {
                    bVar.invoke(Boolean.FALSE);
                    AppMethodBeat.o(139791);
                    return;
                }
                AppMethodBeat.o(139791);
                return;
            }
            com.tencent.mm.plugin.appbrand.g.b.b bBo2 = this.mNc.bMs().bBo();
            if (p.j(str, bBo2 != null ? bBo2.ljS : null)) {
                kotlin.g.a.b<? super Boolean, x> bVar2 = this.mNc.mMY;
                if (bVar2 != null) {
                    bVar2.invoke(Boolean.TRUE);
                }
                this.mNc.g(cVar);
            }
            AppMethodBeat.o(139791);
        }

        @Override // com.tencent.mm.plugin.appbrand.g.b.a.AbstractC0581a
        public final void b(com.tencent.mm.plugin.appbrand.g.b.c cVar) {
            AppMethodBeat.i(161190);
            Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", "reconnect: onRemoveDevice");
            AppMethodBeat.o(161190);
        }

        @Override // com.tencent.mm.plugin.appbrand.g.b.a.AbstractC0581a
        public final void c(com.tencent.mm.plugin.appbrand.g.b.c cVar) {
            AppMethodBeat.i(161191);
            Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", "reconnect: onUpdateDevice");
            AppMethodBeat.o(161191);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$deviceSearchEventListener$1", "Lcom/tencent/mm/plugin/appbrand/dlna/device/DeviceManager$OnDeviceChangeListener;", "onAddDevice", "", "device", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "onRemoveDevice", "onUpdateDevice", "luggage-xweb-ext_release"})
    public static final class c implements a.AbstractC0581a {
        final /* synthetic */ j mNc;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(j jVar) {
            this.mNc = jVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x0082  */
        @Override // com.tencent.mm.plugin.appbrand.g.b.a.AbstractC0581a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.plugin.appbrand.g.b.c r11) {
            /*
            // Method dump skipped, instructions count: 293
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.j.c.a(com.tencent.mm.plugin.appbrand.g.b.c):void");
        }

        @Override // com.tencent.mm.plugin.appbrand.g.b.a.AbstractC0581a
        public final void b(com.tencent.mm.plugin.appbrand.g.b.c cVar) {
            AppMethodBeat.i(139789);
            p.h(cVar, "device");
            this.mNc.mMU.remove(new e(cVar));
            this.mNc.mMV.remove(new e(cVar));
            kotlin.g.a.a<x> aVar = this.mNc.mMW;
            if (aVar != null) {
                aVar.invoke();
            }
            StringBuilder sb = new StringBuilder("onRemoveDevice: ");
            com.tencent.mm.plugin.appbrand.g.b.b bBo = cVar.bBo();
            Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", sb.append(bBo != null ? bBo.ljP : null).toString());
            AppMethodBeat.o(139789);
        }

        @Override // com.tencent.mm.plugin.appbrand.g.b.a.AbstractC0581a
        public final void c(com.tencent.mm.plugin.appbrand.g.b.c cVar) {
            AppMethodBeat.i(139790);
            p.h(cVar, "device");
            try {
                Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", "onUpdateDevice: ".concat(String.valueOf(cVar)));
                AppMethodBeat.o(139790);
            } catch (Exception e2) {
                Log.e("MicroMsg.VideoCast.VideoCastDeviceManager", "onUpdateDevice", e2);
                AppMethodBeat.o(139790);
            }
        }
    }

    public final void clear() {
        AppMethodBeat.i(139804);
        try {
            this.mMX.clear();
            this.mMV.clear();
            this.mMU.clear();
            com.tencent.mm.plugin.appbrand.g.b.a bBl = com.tencent.mm.plugin.appbrand.g.b.a.bBl();
            bBl.bBn();
            p.g(bBl, "deviceManager");
            for (com.tencent.mm.plugin.appbrand.g.b.c cVar : bBl.bBm()) {
                cVar.bBs();
                cVar.bBt();
                cVar.a((com.tencent.mm.plugin.appbrand.g.b.d) null);
            }
            bBl.b(this.mNa);
            bBl.b(this.mMZ);
            bBl.destroy();
            try {
                com.tencent.mm.plugin.appbrand.g.c.h.bBB().disable();
            } catch (com.tencent.mm.plugin.appbrand.g.c.c.a e2) {
            }
            com.tencent.mm.plugin.appbrand.g.c.c.bBw().disable();
            AppMethodBeat.o(139804);
        } catch (Exception e3) {
            Log.e("MicroMsg.VideoCast.VideoCastDeviceManager", "Error happen while cleaning up " + e3.getMessage());
            AppMethodBeat.o(139804);
        }
    }

    public final void bMx() {
        AppMethodBeat.i(139805);
        for (T t : this.mMU) {
            com.tencent.mm.plugin.appbrand.g.b.b bBo = t.mLG.bBo();
            String str = bBo != null ? bBo.ljS : null;
            com.tencent.mm.plugin.appbrand.g.b.b bBo2 = bMs().bBo();
            if (p.j(str, bBo2 != null ? bBo2.ljS : null)) {
                t.hmV = false;
                t.mLF = false;
                t.isSelected = true;
            }
        }
        for (T t2 : this.mMV) {
            com.tencent.mm.plugin.appbrand.g.b.b bBo3 = t2.mLG.bBo();
            String str2 = bBo3 != null ? bBo3.ljS : null;
            com.tencent.mm.plugin.appbrand.g.b.b bBo4 = bMs().bBo();
            if (p.j(str2, bBo4 != null ? bBo4.ljS : null)) {
                t2.hmV = false;
                t2.mLF = false;
                t2.isSelected = true;
            }
        }
        kotlin.g.a.a<x> aVar = this.mMW;
        if (aVar != null) {
            aVar.invoke();
            AppMethodBeat.o(139805);
            return;
        }
        AppMethodBeat.o(139805);
    }

    public final void bMy() {
        AppMethodBeat.i(139806);
        for (T t : this.mMU) {
            com.tencent.mm.plugin.appbrand.g.b.b bBo = t.mLG.bBo();
            String str = bBo != null ? bBo.ljS : null;
            com.tencent.mm.plugin.appbrand.g.b.b bBo2 = bMs().bBo();
            if (p.j(str, bBo2 != null ? bBo2.ljS : null)) {
                t.hmV = false;
                t.mLF = true;
                t.isSelected = true;
            }
        }
        for (T t2 : this.mMV) {
            com.tencent.mm.plugin.appbrand.g.b.b bBo3 = t2.mLG.bBo();
            String str2 = bBo3 != null ? bBo3.ljS : null;
            com.tencent.mm.plugin.appbrand.g.b.b bBo4 = bMs().bBo();
            if (p.j(str2, bBo4 != null ? bBo4.ljS : null)) {
                t2.hmV = false;
                t2.mLF = true;
                t2.isSelected = true;
            }
        }
        kotlin.g.a.a<x> aVar = this.mMW;
        if (aVar != null) {
            aVar.invoke();
            AppMethodBeat.o(139806);
            return;
        }
        AppMethodBeat.o(139806);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Long;)V"})
    public static final class e<T> implements rx.b.b<Long> {
        final /* synthetic */ boolean mNd;

        e(boolean z) {
            this.mNd = z;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // rx.b.b
        public final /* synthetic */ void cA(Long l) {
            AppMethodBeat.i(139792);
            com.tencent.mm.plugin.appbrand.g.c.h.bBB().gZ(this.mNd);
            Log.i("MicroMsg.VideoCast.VideoCastDeviceManager", "prepareAndSearchDevice: searching...");
            AppMethodBeat.o(139792);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Long;)V"})
    public static final class g<T> implements rx.b.b<Long> {
        final /* synthetic */ j mNc;

        g(j jVar) {
            this.mNc = jVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // rx.b.b
        public final /* synthetic */ void cA(Long l) {
            AppMethodBeat.i(139795);
            Log.e("MicroMsg.VideoCast.VideoCastDeviceManager", "search time out");
            this.mNc.mMX.clear();
            AppMethodBeat.o(139795);
        }
    }
}
