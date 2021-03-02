package com.tencent.mm.modelgeo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.h;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d implements b {
    public static d iOv;
    double cin = 0.0d;
    private MMHandler hAk = new MMHandler(Looper.getMainLooper());
    private f iVA = new f() {
        /* class com.tencent.mm.modelgeo.d.AnonymousClass1 */

        @Override // com.tencent.mm.modelgeo.f
        public final void a(final boolean z, final double d2, final double d3, final int i2, final double d4, final double d5, final double d6, String str, String str2, int i3) {
            AppMethodBeat.i(150482);
            d.a(d.this, z, d2, d3, d5, true);
            if (z) {
                d.this.iVq = d2;
                d.this.iVr = d3;
                d.this.iVs = i2;
                d.this.iVt = d4;
                d.this.iVu = d5;
                d.this.cin = d6;
                d.this.iVv = str;
                d.this.iVw = str2;
                d.this.iVx = i3;
                d.this.iVn = System.currentTimeMillis();
                d.this.iVo = true;
                d.this.iVp = false;
                d.a(d.this, 67592);
            }
            Log.d("MicroMsg.LocationGeo", "onGetLocation fLongitude: %f fLatitude:%f locType:%d %f:spped", Double.valueOf(d3), Double.valueOf(d2), Integer.valueOf(i2), Double.valueOf(d4));
            new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.tencent.mm.modelgeo.d.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(150481);
                    Bundle bundle = new Bundle();
                    bundle.putString("indoor_building_floor", d.this.iVw);
                    bundle.putString("indoor_building_id", d.this.iVv);
                    bundle.putInt("indoor_building_type", d.this.iVx);
                    d.a(d.this, z, d2, d3, i2, d4, d5, bundle);
                    AppMethodBeat.o(150481);
                }
            });
            AppMethodBeat.o(150482);
        }

        @Override // com.tencent.mm.modelgeo.f, com.tencent.map.geolocation.sapp.TencentLocationListener
        public final void onStatusUpdate(String str, int i2, String str2) {
            AppMethodBeat.i(150483);
            Log.i("MicroMsg.LocationGeo", "onStatusUpdate name %s, status %d", str, Integer.valueOf(i2));
            AppMethodBeat.o(150483);
        }
    };
    private g iVB = new g() {
        /* class com.tencent.mm.modelgeo.d.AnonymousClass2 */

        @Override // com.tencent.mm.modelgeo.g
        public final void a(final boolean z, final double d2, final double d3, final int i2, final double d4, final double d5, final double d6, String str, String str2, int i3) {
            AppMethodBeat.i(150485);
            d.a(d.this, z, d2, d3, d5, false);
            if (z) {
                d.this.iVq = d2;
                d.this.iVr = d3;
                d.this.iVs = i2;
                d.this.iVt = d4;
                d.this.iVu = d5;
                d.this.cin = d6;
                d.this.iVv = str;
                d.this.iVw = str2;
                d.this.iVx = i3;
                d.this.iVp = true;
                d.this.iVo = false;
                d.this.iVn = System.currentTimeMillis();
                d.a(d.this, 67591);
            }
            Log.d("MicroMsg.LocationGeo", "onGetLocationWgs84 fLongitude: %f fLatitude:%f locType:%d %f:spped", Double.valueOf(d3), Double.valueOf(d2), Integer.valueOf(i2), Double.valueOf(d4));
            new MMHandler(Looper.getMainLooper()).postDelayed(new Runnable() {
                /* class com.tencent.mm.modelgeo.d.AnonymousClass2.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(150484);
                    Bundle bundle = new Bundle();
                    bundle.putString("indoor_building_floor", d.this.iVw);
                    bundle.putString("indoor_building_id", d.this.iVv);
                    bundle.putInt("indoor_building_type", d.this.iVx);
                    d.a(d.this, z, d2, d3, i2, d4, d5, bundle);
                    AppMethodBeat.o(150484);
                }
            }, 200);
            AppMethodBeat.o(150485);
        }
    };
    public boolean iVk = false;
    h iVl;
    long iVm = 0;
    public long iVn = 0;
    boolean iVo = false;
    public boolean iVp = false;
    double iVq = 23.0d;
    double iVr = 100.0d;
    int iVs = 0;
    double iVt = 0.0d;
    double iVu = 0.0d;
    String iVv;
    String iVw;
    int iVx;
    private boolean iVy = false;
    private boolean iVz = false;
    List<WeakReference<b.a>> listeners = new ArrayList();
    private Context mContext;

    public static d bca() {
        AppMethodBeat.i(150487);
        if (iOv == null) {
            iOv = new d(MMApplicationContext.getContext());
        }
        d dVar = iOv;
        AppMethodBeat.o(150487);
        return dVar;
    }

    private d(Context context) {
        AppMethodBeat.i(150488);
        this.mContext = context;
        this.iVl = h.da(context);
        AppMethodBeat.o(150488);
    }

    public final void a(b.a aVar, boolean z) {
        boolean z2;
        AppMethodBeat.i(150489);
        Log.i("MicroMsg.LocationGeo", "startWgs84 %s userCache %s delay %d", aVar, Boolean.valueOf(z), 0);
        if (this.iVk && this.listeners.size() > 0) {
            try {
                this.iVm = System.currentTimeMillis();
                this.iVy = false;
                this.iVz = false;
                this.iVl.bcf();
                this.iVl.a(this.iVB, 0, Looper.getMainLooper());
            } catch (h.a e2) {
                Log.d("MicroMsg.LocationGeo", e2.toString());
            }
        }
        this.iVk = false;
        Iterator<WeakReference<b.a>> it = this.listeners.iterator();
        while (true) {
            if (!it.hasNext()) {
                z2 = true;
                break;
            }
            WeakReference<b.a> next = it.next();
            if (next != null && next.get() != null && next.get().equals(aVar)) {
                z2 = false;
                break;
            }
        }
        if (z2) {
            this.listeners.add(new WeakReference<>(aVar));
        }
        Log.i("MicroMsg.LocationGeo", "add listeners size %d", Integer.valueOf(this.listeners.size()));
        if (this.listeners.size() == 1 && z2) {
            try {
                this.iVm = System.currentTimeMillis();
                this.iVy = false;
                this.iVz = false;
                this.iVl.a(this.iVB, 0, Looper.getMainLooper());
            } catch (h.a e3) {
                Log.d("MicroMsg.LocationGeo", e3.toString());
            }
        }
        if (z && this.iVp && System.currentTimeMillis() - this.iVn < Util.MILLSECONDS_OF_MINUTE) {
            this.iVB.a(true, this.iVq, this.iVr, this.iVs, this.iVt, this.iVu, this.cin, this.iVv, this.iVw, this.iVx);
        }
        AppMethodBeat.o(150489);
    }

    @Override // com.tencent.mm.modelgeo.b
    public final void b(b.a aVar) {
        AppMethodBeat.i(263517);
        a(aVar, true);
        AppMethodBeat.o(263517);
    }

    public final boolean bcb() {
        return this.iVk;
    }

    @Override // com.tencent.mm.modelgeo.b
    public final void a(b.a aVar) {
        AppMethodBeat.i(150491);
        b(aVar, true);
        AppMethodBeat.o(150491);
    }

    public final void b(b.a aVar, boolean z) {
        boolean z2;
        AppMethodBeat.i(150492);
        if (!this.iVk && this.listeners.size() > 0) {
            try {
                this.iVm = System.currentTimeMillis();
                this.iVy = false;
                this.iVz = false;
                this.iVl.bcf();
                this.iVl.a(this.iVA, 1, Looper.getMainLooper());
            } catch (h.a e2) {
                Log.d("MicroMsg.LocationGeo", e2.toString());
            }
        }
        this.iVk = true;
        Iterator<WeakReference<b.a>> it = this.listeners.iterator();
        while (true) {
            if (!it.hasNext()) {
                z2 = true;
                break;
            }
            WeakReference<b.a> next = it.next();
            if (next != null && next.get() != null && next.get().equals(aVar)) {
                z2 = false;
                break;
            }
        }
        if (z2) {
            this.listeners.add(new WeakReference<>(aVar));
        }
        Log.i("MicroMsg.LocationGeo", "add listeners size %d", Integer.valueOf(this.listeners.size()));
        if (this.listeners.size() == 1 && z2) {
            try {
                this.iVm = System.currentTimeMillis();
                this.iVy = false;
                this.iVz = false;
                this.iVl.a(this.iVA, 1, Looper.getMainLooper());
            } catch (h.a e3) {
                Log.d("MicroMsg.LocationGeo", e3.toString());
            }
        }
        if (z && this.iVo && System.currentTimeMillis() - this.iVn < Util.MILLSECONDS_OF_MINUTE) {
            this.iVA.a(true, this.iVq, this.iVr, this.iVs, this.iVt, this.iVu, this.cin, this.iVv, this.iVw, this.iVx);
        }
        AppMethodBeat.o(150492);
    }

    @Override // com.tencent.mm.modelgeo.b
    public final void c(final b.a aVar) {
        AppMethodBeat.i(150493);
        new MMHandler().post(new Runnable() {
            /* class com.tencent.mm.modelgeo.d.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(150486);
                ArrayList<WeakReference> arrayList = new ArrayList();
                for (WeakReference<b.a> weakReference : d.this.listeners) {
                    if (weakReference == null || weakReference.get() == null || weakReference.get().equals(aVar)) {
                        arrayList.add(weakReference);
                    }
                }
                for (WeakReference weakReference2 : arrayList) {
                    d.this.listeners.remove(weakReference2);
                }
                Log.i("MicroMsg.LocationGeo", "stop listeners size %d", Integer.valueOf(d.this.listeners.size()));
                if (d.this.listeners.size() == 0 && d.this.iVl != null) {
                    d.this.iVl.bcf();
                }
                AppMethodBeat.o(150486);
            }
        });
        AppMethodBeat.o(150493);
    }

    public static boolean bcc() {
        AppMethodBeat.i(150494);
        try {
            boolean isProviderEnabled = ((LocationManager) MMApplicationContext.getContext().getSystemService(FirebaseAnalytics.b.LOCATION)).isProviderEnabled("gps");
            AppMethodBeat.o(150494);
            return isProviderEnabled;
        } catch (Exception e2) {
            Log.e("MicroMsg.LocationGeo", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(150494);
            return false;
        }
    }

    public static boolean bcd() {
        AppMethodBeat.i(150496);
        try {
            boolean isProviderEnabled = ((LocationManager) MMApplicationContext.getContext().getSystemService(FirebaseAnalytics.b.LOCATION)).isProviderEnabled(TencentLocation.NETWORK_PROVIDER);
            AppMethodBeat.o(150496);
            return isProviderEnabled;
        } catch (Exception e2) {
            Log.e("MicroMsg.LocationGeo", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(150496);
            return false;
        }
    }

    public static void cZ(Context context) {
        AppMethodBeat.i(150495);
        Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, -1);
            AppMethodBeat.o(150495);
            return;
        }
        intent.addFlags(268435456);
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/modelgeo/LocationGeo", "jumpToOpenGps", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/modelgeo/LocationGeo", "jumpToOpenGps", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(150495);
    }

    static /* synthetic */ void a(d dVar, boolean z, double d2, double d3, double d4, boolean z2) {
        AppMethodBeat.i(150497);
        if ((!z || !dVar.iVy) && (z || !dVar.iVz)) {
            int i2 = 10;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - dVar.iVm <= 500) {
                i2 = 10;
            } else if (currentTimeMillis - dVar.iVm <= 1000) {
                i2 = 12;
            } else if (currentTimeMillis - dVar.iVm <= 2000) {
                i2 = 14;
            } else if (currentTimeMillis - dVar.iVm <= 4000) {
                i2 = 16;
            } else if (currentTimeMillis - dVar.iVm <= 8000) {
                i2 = 18;
            }
            if (!z) {
                i2++;
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(584, (long) i2, 1, true);
            if (z) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(584, 30, 1, true);
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(584, 31, currentTimeMillis - dVar.iVm, true);
                dVar.iVy = true;
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr = new Object[5];
                objArr[0] = Integer.valueOf((int) (1000000.0d * d2));
                objArr[1] = Integer.valueOf((int) (1000000.0d * d3));
                objArr[2] = Integer.valueOf((int) (1000000.0d * d4));
                objArr[3] = Integer.valueOf((int) d4);
                objArr[4] = Integer.valueOf(z2 ? 1 : 2);
                hVar.a(15391, objArr);
                AppMethodBeat.o(150497);
                return;
            }
            dVar.iVz = true;
        }
        AppMethodBeat.o(150497);
    }

    static /* synthetic */ void a(d dVar, int i2) {
        AppMethodBeat.i(150498);
        if (g.aAf().azp()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append((int) dVar.iVu);
            stringBuffer.append(",");
            stringBuffer.append(dVar.iVs);
            stringBuffer.append(",");
            stringBuffer.append((int) (dVar.iVq * 1000000.0d));
            stringBuffer.append(",");
            stringBuffer.append((int) (dVar.iVr * 1000000.0d));
            g.aAh().azQ().set(i2, stringBuffer.toString());
            Log.d("MicroMsg.LocationGeo", "Save Location Success id=%d|content=%s", Integer.valueOf(i2), stringBuffer.toString());
        }
        AppMethodBeat.o(150498);
    }

    static /* synthetic */ void a(d dVar, boolean z, double d2, double d3, int i2, double d4, double d5, Bundle bundle) {
        AppMethodBeat.i(150499);
        LinkedList<b.a> linkedList = new LinkedList();
        for (WeakReference<b.a> weakReference : dVar.listeners) {
            if (!(weakReference == null || weakReference.get() == null)) {
                linkedList.add(weakReference.get());
            }
        }
        if (linkedList.isEmpty()) {
            Log.w("MicroMsg.LocationGeo", "no location listener weakrefers, may have leak, stop location");
            dVar.listeners.clear();
            dVar.iVl.bcf();
        }
        for (b.a aVar : linkedList) {
            if (!ac.jOa || !CrashReportFactory.hasDebuger()) {
                aVar.a(z, (float) d3, (float) d2, i2, (double) ((float) d4), d5);
            } else {
                aVar.a(z, (float) ac.lng, (float) ac.lat, i2, (double) ((float) d4), d5);
            }
            if (aVar instanceof b.AbstractC0452b) {
                ((b.AbstractC0452b) aVar).a(z, (float) d3, (float) d2, i2, (double) ((float) d4), d5, bundle);
            }
        }
        AppMethodBeat.o(150499);
    }
}
