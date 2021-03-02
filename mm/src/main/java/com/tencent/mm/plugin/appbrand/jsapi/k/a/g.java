package com.tencent.mm.plugin.appbrand.jsapi.k.a;

import android.annotation.TargetApi;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@TargetApi(3)
public final class g {
    public static a mbA;
    private static Runnable mbB = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.k.a.g.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(143718);
            g.access$000();
            AppMethodBeat.o(143718);
        }
    };
    private static Map<String, HashMap<String, b>> mbx = new HashMap();
    private static Set<b> mby = new CopyOnWriteArraySet();
    private static Set<b> mbz = new HashSet();
    public static SensorManager sensorManager;

    static {
        AppMethodBeat.i(143728);
        AppMethodBeat.o(143728);
    }

    private static synchronized void init() {
        synchronized (g.class) {
            AppMethodBeat.i(143720);
            Log.i("MicroMsg.AppBrandMapManager", APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
            if (mbA == null) {
                mbA = new a();
                SensorManager sensorManager2 = (SensorManager) MMApplicationContext.getContext().getSystemService("sensor");
                sensorManager = sensorManager2;
                sensorManager.registerListener(mbA, sensorManager2.getDefaultSensor(3), 1);
            }
            AppMethodBeat.o(143720);
        }
    }

    public static synchronized void a(b bVar) {
        synchronized (g.class) {
            AppMethodBeat.i(143721);
            Log.i("MicroMsg.AppBrandMapManager", "registerListener map:%s", bVar);
            mbz.add(bVar);
            if (mbz.size() == 1) {
                init();
            }
            AppMethodBeat.o(143721);
        }
    }

    private static synchronized void uninit() {
        synchronized (g.class) {
            AppMethodBeat.i(143722);
            Log.i("MicroMsg.AppBrandMapManager", "uninit");
            if (!(mbA == null || sensorManager == null)) {
                Log.i("MicroMsg.AppBrandMapManager", "sensorListener uninit");
                sensorManager.unregisterListener(mbA);
                sensorManager = null;
                mbA = null;
            }
            AppMethodBeat.o(143722);
        }
    }

    public static synchronized void b(b bVar) {
        synchronized (g.class) {
            AppMethodBeat.i(143723);
            Log.i("MicroMsg.AppBrandMapManager", "unregisterListener map:%s", bVar);
            mbz.remove(bVar);
            if (mbz.size() == 0) {
                uninit();
            }
            AppMethodBeat.o(143723);
        }
    }

    public static synchronized boolean a(String str, String str2, b bVar) {
        boolean z;
        synchronized (g.class) {
            AppMethodBeat.i(143724);
            if ("invalid_map_id".equals(str2)) {
                Log.e("MicroMsg.AppBrandMapManager", "[createMapView]INVALID_MAP_ID");
                AppMethodBeat.o(143724);
                z = false;
            } else {
                HashMap<String, b> hashMap = mbx.get(str);
                if (hashMap == null) {
                    hashMap = new HashMap<>();
                    mbx.put(str, hashMap);
                }
                if (hashMap.containsKey(str2)) {
                    Log.w("MicroMsg.AppBrandMapManager", "map is exist, return");
                    AppMethodBeat.o(143724);
                    z = false;
                } else {
                    hashMap.put(str2, bVar);
                    Log.i("MicroMsg.AppBrandMapManager", "initMapView appId:%s, mapId:%s", str, str2);
                    AppMethodBeat.o(143724);
                    z = true;
                }
            }
        }
        return z;
    }

    public static synchronized b dz(String str, String str2) {
        b bVar;
        synchronized (g.class) {
            AppMethodBeat.i(143725);
            if ("invalid_map_id".equals(str2)) {
                Log.e("MicroMsg.AppBrandMapManager", "[getMapView]INVALID_MAP_ID");
                AppMethodBeat.o(143725);
                bVar = null;
            } else {
                HashMap<String, b> hashMap = mbx.get(str);
                if (hashMap == null) {
                    AppMethodBeat.o(143725);
                    bVar = null;
                } else {
                    bVar = hashMap.get(str2);
                    AppMethodBeat.o(143725);
                }
            }
        }
        return bVar;
    }

    public static synchronized boolean dA(String str, String str2) {
        boolean z;
        synchronized (g.class) {
            AppMethodBeat.i(143726);
            HashMap<String, b> hashMap = mbx.get(str);
            if (hashMap == null) {
                AppMethodBeat.o(143726);
                z = false;
            } else {
                b bVar = hashMap.get(str2);
                if (bVar == null) {
                    Log.e("MicroMsg.AppBrandMapManager", "[destroyMapView] mapview not exist, err");
                    AppMethodBeat.o(143726);
                    z = false;
                } else {
                    Log.i("MicroMsg.AppBrandMapManager", "destoryMapView map:%s", bVar);
                    hashMap.remove(str2);
                    b(bVar);
                    if (hashMap.size() <= 0) {
                        mbx.remove(str);
                    }
                    mby.add(bVar);
                    MMHandlerThread.removeRunnable(mbB);
                    MMHandlerThread.postToMainThreadDelayed(mbB, 100);
                    Log.i("MicroMsg.AppBrandMapManager", "[destroyMapView]appid:%s, map count:%d", str, Integer.valueOf(hashMap.size()));
                    AppMethodBeat.o(143726);
                    z = true;
                }
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public static class a implements SensorEventListener {
        private float mbC = 0.0f;
        private long timestamp = 200;

        public final void onSensorChanged(SensorEvent sensorEvent) {
            AppMethodBeat.i(143719);
            if (sensorEvent.sensor.getType() == 3) {
                long currentTimeMillis = System.currentTimeMillis() - this.timestamp;
                float aL = f.aL(sensorEvent.values[0]);
                if (currentTimeMillis > 200 && Math.abs(aL - this.mbC) > 3.0f) {
                    synchronized (g.mbx) {
                        try {
                            for (HashMap hashMap : g.mbx.values()) {
                                for (b bVar : hashMap.values()) {
                                    if (bVar != null) {
                                        bVar.L(this.mbC, aL);
                                    }
                                }
                            }
                        } finally {
                            AppMethodBeat.o(143719);
                        }
                    }
                    this.mbC = aL;
                    this.timestamp = System.currentTimeMillis();
                }
            }
        }

        public final void onAccuracyChanged(Sensor sensor, int i2) {
        }
    }

    static /* synthetic */ void access$000() {
        AppMethodBeat.i(143727);
        HashSet<b> hashSet = new HashSet(mby);
        mby.clear();
        for (b bVar : hashSet) {
            bVar.onDestroy();
        }
        AppMethodBeat.o(143727);
    }
}
