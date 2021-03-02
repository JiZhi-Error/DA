package com.tencent.mm.plugin.voip.b;

import android.os.BatteryManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.plugin.appbrand.jsapi.z.d;
import com.tencent.mm.plugin.voip.b.h;
import com.tencent.mm.plugin.voip.b.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\fJ\u0016\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/voip/util/BatteryUtils;", "", "()V", "avgAverageBattery", "", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isStartCounter", "", "mBatteryManager", "Landroid/os/BatteryManager;", d.NAME, "", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "releaseBatteryCounter", "startBatteryCounter", "stopBatteryCounter", "isNewRenderer", "renderType", "", "Companion", "plugin-voip_release"})
public final class a {
    public static final C1888a Hgo = new C1888a((byte) 0);
    private long Hgl;
    private boolean Hgm;
    private final BatteryManager Hgn;
    private MMHandler handler;

    static {
        AppMethodBeat.i(235996);
        AppMethodBeat.o(235996);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/voip/util/BatteryUtils$Companion;", "", "()V", "TAG", "", "plugin-voip_release"})
    /* renamed from: com.tencent.mm.plugin.voip.b.a$a  reason: collision with other inner class name */
    public static final class C1888a {
        private C1888a() {
        }

        public /* synthetic */ C1888a(byte b2) {
            this();
        }
    }

    public a() {
        AppMethodBeat.i(235995);
        Object systemService = MMApplicationContext.getContext().getSystemService("batterymanager");
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.os.BatteryManager");
            AppMethodBeat.o(235995);
            throw tVar;
        }
        this.Hgn = (BatteryManager) systemService;
        init();
        AppMethodBeat.o(235995);
    }

    private void init() {
        AppMethodBeat.i(235991);
        this.Hgl = 0;
        this.handler = new MMHandler("batteryCounter");
        AppMethodBeat.o(235991);
    }

    public final void fJK() {
        AppMethodBeat.i(235992);
        while (true) {
            this.Hgm = true;
            MMHandler mMHandler = this.handler;
            if ((mMHandler == null || !mMHandler.isQuit()) && this.Hgm) {
                break;
            }
            init();
        }
        MMHandler mMHandler2 = this.handler;
        if (mMHandler2 != null) {
            mMHandler2.postDelayed(new b(this), 1000);
            AppMethodBeat.o(235992);
            return;
        }
        AppMethodBeat.o(235992);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ a Hgp;

        b(a aVar) {
            this.Hgp = aVar;
        }

        public final void run() {
            AppMethodBeat.i(235990);
            a.a(this.Hgp);
            this.Hgp.fJK();
            AppMethodBeat.o(235990);
        }
    }

    public final void Z(boolean z, int i2) {
        AppMethodBeat.i(235993);
        this.Hgm = false;
        if (this.Hgl > 0) {
            Log.i("MicroMsg.BatteryUtils", "sum avgBattery=￥avgAverageBattery} microAmpere and avg avgBattery= " + this.Hgl + ' ');
            if (z) {
                h.a aVar = h.Hhl;
                h.a.aj(this.Hgl / 1000, i2);
                AppMethodBeat.o(235993);
                return;
            }
            i.a aVar2 = i.Hho;
            i.a.aj(this.Hgl / 1000, i2);
        }
        AppMethodBeat.o(235993);
    }

    public final void fJL() {
        AppMethodBeat.i(235994);
        MMHandler mMHandler = this.handler;
        if (mMHandler != null) {
            mMHandler.removeCallbacksAndMessages(null);
        }
        MMHandler mMHandler2 = this.handler;
        if (mMHandler2 != null) {
            mMHandler2.quitSafely();
            AppMethodBeat.o(235994);
            return;
        }
        AppMethodBeat.o(235994);
    }

    public static final /* synthetic */ void a(a aVar) {
        long j2;
        AppMethodBeat.i(235997);
        long longProperty = aVar.Hgn.getLongProperty(5);
        int intProperty = aVar.Hgn.getIntProperty(1);
        int intProperty2 = aVar.Hgn.getIntProperty(2);
        int intProperty3 = aVar.Hgn.getIntProperty(3);
        int intProperty4 = aVar.Hgn.getIntProperty(4);
        Log.i("MicroMsg.BatteryUtils", "mBatteryEnergyCounter=" + longProperty + " nanoWattHours ");
        Log.i("MicroMsg.BatteryUtils", "mBatteryChargeCounter=" + intProperty + "  microAmpereHours");
        Log.i("MicroMsg.BatteryUtils", "mBatteryCurrentNow=" + intProperty2 + "   microAmpere");
        Log.i("MicroMsg.BatteryUtils", "mBatteryCurrentAverage=" + intProperty3 + "  microAmpere");
        Log.i("MicroMsg.BatteryUtils", "mBatteryCapacity=" + intProperty4 + "  ");
        Log.i("MicroMsg.BatteryUtils", "mBatteryEnergyCounter=" + longProperty + " nanoWattHours ");
        if (aVar.Hgl != 0) {
            j2 = (aVar.Hgl + ((long) intProperty3)) / 2;
        } else {
            j2 = (long) intProperty3;
        }
        aVar.Hgl = j2;
        AppMethodBeat.o(235997);
    }
}
