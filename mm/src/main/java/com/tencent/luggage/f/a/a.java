package com.tencent.luggage.f.a;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.f.h;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.map.geolocation.sapp.TencentLocationListener;
import com.tencent.map.geolocation.sapp.TencentLocationManager;
import com.tencent.map.geolocation.sapp.TencentLocationRequest;
import com.tencent.map.geolocation.sapp.TencentLocationUtils;
import com.tencent.map.geolocation.sapp.internal.LocationLogCallback;
import com.tencent.map.geolocation.sapp.internal.TencentExtraKeys;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class a implements com.tencent.mm.plugin.appbrand.utils.b.a {
    private volatile TencentLocationManager cCN;
    @SuppressLint({"NewApi"})
    private final List<a.b> cCO = new CopyOnWriteArrayList();
    @SuppressLint({"NewApi"})
    private final List<a.b> cCP = new CopyOnWriteArrayList();
    @SuppressLint({"NewApi"})
    private final List<a.b> cCQ = new CopyOnWriteArrayList();
    @SuppressLint({"NewApi"})
    private final List<a.b> cCR = new CopyOnWriteArrayList();
    TencentLocationListener cCS = new TencentLocationListener() {
        /* class com.tencent.luggage.f.a.a.AnonymousClass2 */

        @Override // com.tencent.map.geolocation.sapp.TencentLocationListener
        public final void onLocationChanged(final TencentLocation tencentLocation, final int i2, final String str) {
            AppMethodBeat.i(217173);
            if (MMHandlerThread.isMainThread()) {
                h.RTc.b(new Runnable() {
                    /* class com.tencent.luggage.f.a.a.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(217172);
                        this.onLocationChanged(tencentLocation, i2, str);
                        AppMethodBeat.o(217172);
                    }
                }, "MicroMsg.DefaultTencentLocationManager");
                AppMethodBeat.o(217173);
                return;
            }
            Log.v("MicroMsg.DefaultTencentLocationManager", "[mlocationListener]error:%d, reason:%s", Integer.valueOf(i2), str);
            if (i2 != 0) {
                Log.e("MicroMsg.DefaultTencentLocationManager", "[mlocationListener]error:%d, reason:%s", Integer.valueOf(i2), str);
            }
            if (a.this.cCP != null && a.this.cCP.size() > 0) {
                a.a(a.this.cCP, i2, str, a.a(tencentLocation, false));
                a.this.cCP.clear();
            }
            if (a.this.cCO != null && a.this.cCO.size() > 0) {
                a.a(a.this.cCO, i2, str, a.a(tencentLocation, true));
                a.this.cCO.clear();
            }
            if (a.this.cCR != null && a.this.cCR.size() > 0) {
                a.a(a.this.cCR, i2, str, a.a(tencentLocation, false));
            }
            if (a.this.cCQ != null && a.this.cCQ.size() > 0) {
                a.a(a.this.cCQ, i2, str, a.a(tencentLocation, true));
            }
            a.e(a.this);
            AppMethodBeat.o(217173);
        }

        @Override // com.tencent.map.geolocation.sapp.TencentLocationListener
        public final void onStatusUpdate(String str, int i2, String str2) {
            AppMethodBeat.i(146445);
            Log.i("MicroMsg.DefaultTencentLocationManager", "[mlocationListener]name:%s, status:%d, desc:%s", str, Integer.valueOf(i2), str2);
            AppMethodBeat.o(146445);
        }
    };
    private Set<String> cCT = new HashSet();
    private Runnable cCU = new Runnable() {
        /* class com.tencent.luggage.f.a.a.AnonymousClass3 */

        public final void run() {
            AppMethodBeat.i(146446);
            if (a.this.cCP != null && a.this.cCP.size() > 0) {
                a.a(a.this.cCP, -1, "timeout", null);
            }
            if (a.this.cCP != null && a.this.cCP.size() > 0) {
                a.a(a.this.cCP, -1, "timeout", null);
            }
            AppMethodBeat.o(146446);
        }
    };

    static /* synthetic */ void e(a aVar) {
        AppMethodBeat.i(146455);
        aVar.Pe();
        AppMethodBeat.o(146455);
    }

    public a() {
        AppMethodBeat.i(146447);
        Log.i("MicroMsg.DefaultTencentLocationManager", "DefaultTencentLocationManager() construct in process %s", MMApplicationContext.getProcessName());
        AppMethodBeat.o(146447);
    }

    private TencentLocationManager Pc() {
        AppMethodBeat.i(217174);
        if (this.cCN == null) {
            synchronized (this) {
                try {
                    if (this.cCN == null) {
                        if (Pd()) {
                            try {
                                TencentExtraKeys.setTencentLog(MMApplicationContext.getContext(), new File(s.k(aa.z(new o(s.k(b.aKJ() + "/lbs" + MMApplicationContext.getProcessName().substring(MMApplicationContext.getPackageName().length() + 1), true)).mUri), true)));
                            } catch (Exception e2) {
                                Log.printInfoStack("MicroMsg.DefaultTencentLocationManager", "", e2);
                            }
                        }
                        TencentExtraKeys.setContext(MMApplicationContext.getContext());
                        try {
                            TencentExtraKeys.setTencentLogCallback(new LocationLogCallback() {
                                /* class com.tencent.luggage.f.a.a.AnonymousClass1 */

                                /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                                @Override // com.tencent.map.geolocation.sapp.internal.LocationLogCallback
                                public final void onLog(int i2, String str, String str2, Throwable th) {
                                    AppMethodBeat.i(146443);
                                    switch (i2) {
                                        case 2:
                                            Log.v("MicroMsg.DefaultTencentLocationManager", "tag:%s msg:%s", str, str2);
                                            AppMethodBeat.o(146443);
                                            return;
                                        case 3:
                                            Log.d("MicroMsg.DefaultTencentLocationManager", "tag:%s msg:%s", str, str2);
                                            AppMethodBeat.o(146443);
                                            return;
                                        case 4:
                                            Log.i("MicroMsg.DefaultTencentLocationManager", "tag:%s msg:%s", str, str2);
                                            AppMethodBeat.o(146443);
                                            return;
                                        case 5:
                                            Log.w("MicroMsg.DefaultTencentLocationManager", "tag:%s msg:%s", str, str2);
                                            AppMethodBeat.o(146443);
                                            return;
                                        case 6:
                                            Object[] objArr = new Object[3];
                                            objArr[0] = str;
                                            objArr[1] = str2;
                                            objArr[2] = th != null ? th.getMessage() : "";
                                            Log.e("MicroMsg.DefaultTencentLocationManager", "tag:%s msg:%s th:%s", objArr);
                                            break;
                                    }
                                    AppMethodBeat.o(146443);
                                }
                            });
                        } catch (Exception e3) {
                            Log.printInfoStack("MicroMsg.DefaultTencentLocationManager", "", e3);
                        }
                        String aoK = q.aoK();
                        if (TextUtils.isEmpty(aoK)) {
                            this.cCN = TencentLocationManager.getInstance(MMApplicationContext.getContext());
                        } else {
                            this.cCN = TencentLocationManager.getInstance(MMApplicationContext.getContext(), new Pair(TencentLocationManager.TYPE_OAID, aoK));
                        }
                        this.cCN.setCoordinateType(0);
                        Log.i("MicroMsg.DefaultTencentLocationManager", "%s Location Sdk Version %s", aoK, this.cCN.getVersion());
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(217174);
                    throw th;
                }
            }
        }
        TencentLocationManager tencentLocationManager = this.cCN;
        AppMethodBeat.o(217174);
        return tencentLocationManager;
    }

    /* access modifiers changed from: protected */
    public boolean Pd() {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.utils.b.a
    public final void a(String str, a.b bVar, Bundle bundle) {
        AppMethodBeat.i(146449);
        if ("wgs84".equals(str)) {
            this.cCO.add(bVar);
        } else {
            this.cCP.add(bVar);
        }
        m.bZn().removeCallbacks(this.cCU);
        m.bZn().j(this.cCU, 20000);
        boolean z = bundle.getBoolean("enableIndoor");
        boolean z2 = bundle.getBoolean("isHighAccuracy", false);
        int i2 = bundle.getInt("highAccuracyExpireTime", 3000);
        TencentLocationRequest create = TencentLocationRequest.create();
        create.setInterval(2000);
        create.setIndoorLocationMode(z);
        create.setSmallAppKey(bundle.getString("smallAppKey"));
        create.setmExpirationTime((long) i2);
        int requestSingleFreshLocation = Pc().requestSingleFreshLocation(create, this.cCS, Looper.getMainLooper(), z2);
        Log.d("MicroMsg.DefaultTencentLocationManager", "MapReport:%s getLocation", bundle.getString("smallAppKey"));
        Log.i("MicroMsg.DefaultTencentLocationManager", "requestCode %d", Integer.valueOf(requestSingleFreshLocation));
        AppMethodBeat.o(146449);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a4 A[LOOP:1: B:34:0x009e->B:36:0x00a4, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e7  */
    @Override // com.tencent.mm.plugin.appbrand.utils.b.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean b(java.lang.String r9, com.tencent.mm.plugin.appbrand.utils.b.a.b r10, android.os.Bundle r11) {
        /*
        // Method dump skipped, instructions count: 301
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.luggage.f.a.a.b(java.lang.String, com.tencent.mm.plugin.appbrand.utils.b.a$b, android.os.Bundle):boolean");
    }

    @Override // com.tencent.mm.plugin.appbrand.utils.b.a
    public final synchronized boolean c(String str, a.b bVar, Bundle bundle) {
        AppMethodBeat.i(146451);
        Log.i("MicroMsg.DefaultTencentLocationManager", "[unregisterLocation]type:%s", str);
        if ("wgs84".equals(str)) {
            this.cCQ.remove(bVar);
        } else {
            this.cCR.remove(bVar);
        }
        if (bundle != null) {
            this.cCT.remove(bundle.getString("smallAppKey"));
        }
        Pe();
        AppMethodBeat.o(146451);
        return false;
    }

    private void Pe() {
        AppMethodBeat.i(146452);
        if (this.cCP.size() <= 0 && this.cCO.size() <= 0 && this.cCQ.size() <= 0 && this.cCR.size() <= 0) {
            Log.i("MicroMsg.DefaultTencentLocationManager", "releaseLocationManager");
            Pc().removeUpdates(null);
        }
        AppMethodBeat.o(146452);
    }

    static /* synthetic */ a.C0814a a(TencentLocation tencentLocation, boolean z) {
        String str;
        AppMethodBeat.i(217175);
        a.C0814a aVar = new a.C0814a();
        if (z) {
            aVar.latitude = tencentLocation.getLatitude();
            aVar.longitude = tencentLocation.getLongitude();
        } else {
            double[] dArr = new double[2];
            TencentLocationUtils.wgs84ToGcj02(new double[]{tencentLocation.getLatitude(), tencentLocation.getLongitude()}, dArr);
            aVar.latitude = dArr[0];
            aVar.longitude = dArr[1];
        }
        if ("gps".equals(tencentLocation.getProvider())) {
            str = "gps";
        } else {
            str = TencentLocation.NETWORK_PROVIDER;
        }
        aVar.provider = str;
        aVar.dxQ = (double) tencentLocation.getSpeed();
        aVar.ohZ = (double) tencentLocation.getAccuracy();
        aVar.altitude = tencentLocation.getAltitude();
        aVar.oia = tencentLocation.getIndoorLocationType();
        aVar.oib = tencentLocation.getBearing();
        if (tencentLocation.getExtra() != null) {
            aVar.oic = tencentLocation.getExtra().getDouble("steps");
        }
        Log.v("MicroMsg.DefaultTencentLocationManager", "buildingId:%s floorName:%s steps:%f", tencentLocation.getIndoorBuildingId(), tencentLocation.getIndoorBuildingFloor(), Double.valueOf(aVar.oic));
        if (!Util.isNullOrNil(tencentLocation.getIndoorBuildingId())) {
            aVar.buildingId = tencentLocation.getIndoorBuildingId();
            aVar.floorName = tencentLocation.getIndoorBuildingFloor();
        } else {
            aVar.buildingId = "";
            aVar.floorName = "";
        }
        AppMethodBeat.o(217175);
        return aVar;
    }

    static /* synthetic */ void a(List list, int i2, String str, a.C0814a aVar) {
        AppMethodBeat.i(146454);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a.b bVar = (a.b) it.next();
            if (bVar != null) {
                bVar.a(i2, str, aVar);
            }
        }
        AppMethodBeat.o(146454);
    }
}
