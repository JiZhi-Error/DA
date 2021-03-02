package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.media.record.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class c {
    private static Map<String, IListener> ndn = new HashMap();
    private static ArrayList<String> ndo = new ArrayList<>();
    private static boolean ndp = false;

    static {
        AppMethodBeat.i(146148);
        AppMethodBeat.o(146148);
    }

    public static void onCreate() {
    }

    public static void onDestroy() {
        AppMethodBeat.i(146143);
        Log.i("MicroMsg.Record.AppBrandRecordClientService", "onDestroy");
        Iterator<String> it = ndo.iterator();
        while (it.hasNext()) {
            IListener remove = ndn.remove(it.next());
            if (remove != null) {
                EventCenter.instance.removeListener(remove);
            }
        }
        ndn.clear();
        ndo.clear();
        g bPa = g.bPa();
        Log.i("MicroMsg.Record.AudioRecordMgr", "destroy");
        if (bPa.ndv == g.a.START || bPa.ndv == g.a.RESUME || bPa.ndv == g.a.ERROR) {
            bPa.ZZ();
        }
        if (bPa.ndB) {
            if (!(bPa.ndu == null || bPa.ndu.nev == null)) {
                bPa.ndu.nev.a(null);
                bPa.ndu.nev.bOZ();
            }
            bPa.ndB = false;
        }
        AppMethodBeat.o(146143);
    }

    public static void b(String str, IListener iListener) {
        AppMethodBeat.i(146144);
        if (ndn.containsKey(str)) {
            Log.e("MicroMsg.Record.AppBrandRecordClientService", "appId:%s has add listener", str);
            AppMethodBeat.o(146144);
        } else if (iListener == null) {
            Log.e("MicroMsg.Record.AppBrandRecordClientService", "listener is null");
            AppMethodBeat.o(146144);
        } else {
            Log.i("MicroMsg.Record.AppBrandRecordClientService", "addRecordListener,appId:%s", str);
            ndn.put(str, iListener);
            if (!ndo.contains(str)) {
                ndo.add(str);
            }
            EventCenter.instance.add(iListener);
            AppMethodBeat.o(146144);
        }
    }

    public static void acF(String str) {
        AppMethodBeat.i(146145);
        if (!ndn.containsKey(str)) {
            Log.e("MicroMsg.Record.AppBrandRecordClientService", "appId:%s not exist the appId for listener", str);
            AppMethodBeat.o(146145);
            return;
        }
        Log.i("MicroMsg.Record.AppBrandRecordClientService", "removeRecordListener,appId:%s", str);
        ndo.remove(str);
        IListener remove = ndn.remove(str);
        if (remove != null) {
            EventCenter.instance.removeListener(remove);
        }
        AppMethodBeat.o(146145);
    }

    public static void bOS() {
        AppMethodBeat.i(146146);
        if (ndp) {
            Log.i("MicroMsg.Record.AppBrandRecordClientService", "update device info done!");
            AppMethodBeat.o(146146);
            return;
        }
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.media.record.c.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(146140);
                c.access$000();
                AppMethodBeat.o(146140);
            }
        }, "record_update_device_info");
        AppMethodBeat.o(146146);
    }

    /* access modifiers changed from: package-private */
    public static final class a implements k<IPCVoid, IPCString> {
        private a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCString invoke(IPCVoid iPCVoid) {
            AppMethodBeat.i(146142);
            IPCString bOT = bOT();
            AppMethodBeat.o(146142);
            return bOT;
        }

        private static IPCString bOT() {
            AppMethodBeat.i(146141);
            try {
                Log.i("MicroMsg.Record.AppBrandRecordClientService", "ipc updateDeviceInfo");
                IPCString iPCString = new IPCString(com.tencent.mm.kernel.g.aAh().azR().gEu());
                AppMethodBeat.o(146141);
                return iPCString;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Record.AppBrandRecordClientService", e2, "ipc updateDeviceInfo task", new Object[0]);
                IPCString iPCString2 = new IPCString("");
                AppMethodBeat.o(146141);
                return iPCString2;
            }
        }
    }

    static /* synthetic */ void access$000() {
        AppMethodBeat.i(146147);
        if (ndp) {
            Log.i("MicroMsg.Record.AppBrandRecordClientService", "update device info done!");
            AppMethodBeat.o(146147);
            return;
        }
        Log.i("MicroMsg.Record.AppBrandRecordClientService", "to do update device info!");
        ndp = true;
        IPCString iPCString = (IPCString) XIPCInvoker.a(MainProcessIPCService.dkO, null, a.class);
        if (!(iPCString == null || iPCString.value == null)) {
            ae.DV(iPCString.value);
            Log.i("MicroMsg.Record.AppBrandRecordClientService", "update device info success!");
        }
        AppMethodBeat.o(146147);
    }
}
