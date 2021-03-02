package com.tencent.mm.plugin.appbrand.platform.window.a;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.platform.window.a.h;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;
import java.util.List;

public final class g implements c {
    private static final SparseArray<g> nEQ = new SparseArray<>();
    private int mCurrentOrientation;
    public boolean mFinished = false;
    private b nER;
    private b nES;
    private ContentObserver nET = null;
    private e.b nEU = null;
    private h nEV = null;
    private WeakReference<Activity> nhy;

    static /* synthetic */ void b(Activity activity, e.b bVar) {
        AppMethodBeat.i(219581);
        a(activity, bVar);
        AppMethodBeat.o(219581);
    }

    static {
        AppMethodBeat.i(176737);
        AppMethodBeat.o(176737);
    }

    public static g E(Activity activity) {
        g gVar;
        AppMethodBeat.i(176718);
        synchronized (nEQ) {
            try {
                gVar = nEQ.get(activity.hashCode());
                if (gVar == null) {
                    gVar = new g(activity);
                    nEQ.put(activity.hashCode(), gVar);
                }
            } finally {
                AppMethodBeat.o(176718);
            }
        }
        return gVar;
    }

    private g(Activity activity) {
        AppMethodBeat.i(176719);
        Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationHandler construct");
        this.mCurrentOrientation = activity.getResources().getConfiguration().orientation;
        this.nhy = new WeakReference<>(activity);
        a(activity, iz(bTQ()));
        AppMethodBeat.o(176719);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00e2, code lost:
        if (r0 == null) goto L_0x00f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00e4, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "dismissRequest not null");
        a(r0.nEY, r4, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00f2, code lost:
        r12.nEU = r13;
        com.tencent.matrix.trace.core.AppMethodBeat.o(176720);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        return;
     */
    @Override // com.tencent.mm.plugin.appbrand.platform.window.e
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.plugin.appbrand.platform.window.e.b r13, com.tencent.mm.plugin.appbrand.platform.window.e.a r14) {
        /*
        // Method dump skipped, instructions count: 272
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.platform.window.a.g.a(com.tencent.mm.plugin.appbrand.platform.window.e$b, com.tencent.mm.plugin.appbrand.platform.window.e$a):void");
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.a.c
    public final void onResume() {
        AppMethodBeat.i(176721);
        a(this.nEU, (e.a) null);
        ContentResolver contentResolver = MMApplicationContext.getContext().getApplicationContext().getContentResolver();
        Uri uriFor = Settings.System.getUriFor("accelerometer_rotation");
        this.nET = new ContentObserver(new Handler()) {
            /* class com.tencent.mm.plugin.appbrand.platform.window.a.g.AnonymousClass1 */

            public final void onChange(boolean z) {
                AppMethodBeat.i(176713);
                super.onChange(z);
                Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "hy: lock orientation settings changed! request now");
                if (!(g.this.nEU == null || g.this.nhy.get() == null)) {
                    Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "hy: need change");
                    g.this.a(g.e(g.this.nEU), (e.a) null);
                    g.this.nES = null;
                }
                AppMethodBeat.o(176713);
            }

            public final boolean deliverSelfNotifications() {
                return true;
            }
        };
        try {
            contentResolver.registerContentObserver(uriFor, false, this.nET);
            AppMethodBeat.o(176721);
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.AppBrandDeviceOrientationHandler", th, "registerContentObserver [Settings.System.ACCELEROMETER_ROTATION] ", new Object[0]);
            AppMethodBeat.o(176721);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.a.c
    public final void onPause() {
        AppMethodBeat.i(176722);
        if (this.nET != null) {
            try {
                MMApplicationContext.getContext().getContentResolver().unregisterContentObserver(this.nET);
                AppMethodBeat.o(176722);
                return;
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.AppBrandDeviceOrientationHandler", th, "unregisterContentObserver", new Object[0]);
            }
        }
        AppMethodBeat.o(176722);
    }

    private static boolean bTQ() {
        AppMethodBeat.i(176723);
        int i2 = Settings.System.getInt(MMApplicationContext.getContext().getContentResolver(), "accelerometer_rotation", 0);
        Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "hy: systenm orientation %d", Integer.valueOf(i2));
        if (i2 == 1) {
            AppMethodBeat.o(176723);
            return false;
        }
        AppMethodBeat.o(176723);
        return true;
    }

    private static void a(Activity activity, e.b bVar) {
        AppMethodBeat.i(219580);
        activity.setRequestedOrientation(bVar.nEr);
        AppMethodBeat.o(219580);
    }

    private void a(final b bVar) {
        AppMethodBeat.i(176724);
        Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationConfig.requestDeviceOrientationImpl setRequestOrientation [%s]", bVar);
        final Activity activity = this.nhy.get();
        if (activity == null) {
            Log.w("MicroMsg.AppBrandDeviceOrientationHandler", "hy: ui already released!");
            if (bVar.nEY != null) {
                bVar.nEY.a(bVar.nEZ, false);
            }
            AppMethodBeat.o(176724);
            return;
        }
        a(activity, bVar.nEZ);
        if (b(bVar)) {
            d(bVar.nEZ);
            AppMethodBeat.o(176724);
            return;
        }
        if (this.nEV == null) {
            this.nEV = new h();
        }
        this.nEV.a(new h.a() {
            /* class com.tencent.mm.plugin.appbrand.platform.window.a.g.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.platform.window.a.h.a
            public final void bTS() {
                AppMethodBeat.i(176714);
                Log.e("MicroMsg.AppBrandDeviceOrientationHandler", "hy: activity not turn to correct orientation for long time, request[%s]", bVar);
                if (bVar.nEY != null) {
                    bVar.nEY.a(bVar.nEZ, false);
                }
                AppMethodBeat.o(176714);
            }

            @Override // com.tencent.mm.plugin.appbrand.platform.window.a.h.a
            public final void bTT() {
                AppMethodBeat.i(176715);
                Log.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: trigger retry, request[%s]", bVar);
                if (!activity.isDestroyed()) {
                    g.b(activity, bVar.nEZ);
                }
                AppMethodBeat.o(176715);
            }
        });
        AppMethodBeat.o(176724);
    }

    private boolean b(b bVar) {
        AppMethodBeat.i(176725);
        Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "current orientation=" + this.mCurrentOrientation + "  request orientation=" + bVar.nEZ);
        if (this.mCurrentOrientation == 2 && (bVar.nEZ.b(e.b.LANDSCAPE_SENSOR) || bVar.nEZ.b(e.b.LANDSCAPE_LEFT) || bVar.nEZ.b(e.b.LANDSCAPE_RIGHT))) {
            Log.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: same landscape");
            AppMethodBeat.o(176725);
            return true;
        } else if (this.mCurrentOrientation == 1 && bVar.nEZ.b(e.b.PORTRAIT)) {
            Log.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: same portrait");
            AppMethodBeat.o(176725);
            return true;
        } else if (this.mCurrentOrientation == 0) {
            Log.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: former is undefined, always return immediately");
            AppMethodBeat.o(176725);
            return true;
        } else if (bVar.nEZ == e.b.UNSPECIFIED) {
            Log.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: request is UNSPECIFIED, return true");
            AppMethodBeat.o(176725);
            return true;
        } else {
            AppMethodBeat.o(176725);
            return false;
        }
    }

    private void bTR() {
        AppMethodBeat.i(176726);
        if (this.nEV != null) {
            this.nEV.bTU();
            this.nEV = null;
        }
        AppMethodBeat.o(176726);
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.a.c
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(176727);
        bTR();
        this.mCurrentOrientation = configuration.orientation;
        Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "onConfigurationChanged  " + this.mCurrentOrientation);
        d(Q(this.mCurrentOrientation, bTQ()));
        AppMethodBeat.o(176727);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a8, code lost:
        r1 = r6.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b0, code lost:
        if (r1.hasNext() == false) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b2, code lost:
        r1.next().execute();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00c7, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(176728);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d(com.tencent.mm.plugin.appbrand.platform.window.e.b r10) {
        /*
        // Method dump skipped, instructions count: 203
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.platform.window.a.g.d(com.tencent.mm.plugin.appbrand.platform.window.e$b):void");
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.a.c
    public final void release() {
        AppMethodBeat.i(176729);
        Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "release");
        synchronized (nEQ) {
            try {
                int indexOfValue = nEQ.indexOfValue(this);
                if (indexOfValue >= 0) {
                    nEQ.removeAt(indexOfValue);
                }
            } finally {
                AppMethodBeat.o(176729);
            }
        }
        synchronized (this) {
            try {
                if (this.nER == null && this.nES == null) {
                    Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "Every request is executed well");
                    return;
                }
                Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "Still has request not executed current[%s] pending[%s]", this.nER, this.nES);
                this.nER = null;
                this.nES = null;
                this.mFinished = true;
                AppMethodBeat.o(176729);
            } finally {
                AppMethodBeat.o(176729);
            }
        }
    }

    private void a(e.b bVar, List<a> list) {
        AppMethodBeat.i(176730);
        if (bVar == this.nES.nEZ) {
            if (this.nES.nEY != null) {
                list.add(new a(this.nES.nEY, bVar, true, "PendingRequest.Listener orientation equal direct", (byte) 0));
            }
            this.nES = null;
            AppMethodBeat.o(176730);
        } else if (this.nhy.get() == null) {
            Log.e("MicroMsg.AppBrandDeviceOrientationHandler", "No Activity when handle pending request");
            if (this.nES.nEY != null) {
                list.add(new a(this.nES.nEY, bVar, false, "PendingRequest.Listener activity == null", (byte) 0));
            }
            AppMethodBeat.o(176730);
        } else {
            this.nER = this.nES;
            this.nES = null;
            a(this.nER);
            AppMethodBeat.o(176730);
        }
    }

    private e.b iz(boolean z) {
        AppMethodBeat.i(176731);
        Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "getCurrentOrientation");
        e.b Q = Q(this.mCurrentOrientation, z);
        AppMethodBeat.o(176731);
        return Q;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.e
    public final e.b btm() {
        AppMethodBeat.i(176732);
        e.b iz = iz(bTQ());
        AppMethodBeat.o(176732);
        return iz;
    }

    private static void a(e.a aVar, e.b bVar, boolean z) {
        AppMethodBeat.i(176733);
        if (aVar == null) {
            AppMethodBeat.o(176733);
            return;
        }
        aVar.a(bVar, z);
        AppMethodBeat.o(176733);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        e.a nEY;
        e.b nEZ;
        String name;
        boolean success;

        /* synthetic */ a(e.a aVar, e.b bVar, boolean z, String str, byte b2) {
            this(aVar, bVar, z, str);
        }

        private a(e.a aVar, e.b bVar, boolean z, String str) {
            this.nEY = aVar;
            this.nEZ = bVar;
            this.success = z;
            this.name = str;
        }

        /* access modifiers changed from: package-private */
        public final void execute() {
            AppMethodBeat.i(176716);
            Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "Notify Listener[%s]", this.name);
            if (this.nEY == null) {
                Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "PendingNotify: Listener is null when execute.");
                AppMethodBeat.o(176716);
                return;
            }
            this.nEY.a(this.nEZ, this.success);
            AppMethodBeat.o(176716);
        }
    }

    /* access modifiers changed from: package-private */
    public static class b {
        e.a nEY;
        e.b nEZ;

        /* synthetic */ b(e.b bVar, e.a aVar, byte b2) {
            this(bVar, aVar);
        }

        private b(e.b bVar, e.a aVar) {
            this.nEZ = bVar;
            this.nEY = aVar;
        }

        public final String toString() {
            AppMethodBeat.i(176717);
            String str = "Req{" + this.nEZ + ", " + this.nEY + "}";
            AppMethodBeat.o(176717);
            return str;
        }
    }

    private e.b Q(int i2, boolean z) {
        AppMethodBeat.i(176734);
        if (i2 == 2) {
            Log.d("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == landscape ");
            if (z) {
                Log.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: parseConfiguration configuration == landscape but screen locked");
                e.b bVar = e.b.LANDSCAPE_LOCKED;
                AppMethodBeat.o(176734);
                return bVar;
            } else if (this.nEU == e.b.LANDSCAPE_LEFT) {
                e.b bVar2 = e.b.LANDSCAPE_LEFT;
                AppMethodBeat.o(176734);
                return bVar2;
            } else if (this.nEU == e.b.LANDSCAPE_RIGHT) {
                e.b bVar3 = e.b.LANDSCAPE_RIGHT;
                AppMethodBeat.o(176734);
                return bVar3;
            } else {
                e.b bVar4 = e.b.LANDSCAPE_SENSOR;
                AppMethodBeat.o(176734);
                return bVar4;
            }
        } else if (i2 == 1) {
            Log.d("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == portrait ");
            e.b bVar5 = e.b.PORTRAIT;
            AppMethodBeat.o(176734);
            return bVar5;
        } else {
            Log.i("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == %d", Integer.valueOf(i2));
            AppMethodBeat.o(176734);
            return null;
        }
    }

    static /* synthetic */ e.b e(e.b bVar) {
        AppMethodBeat.i(176735);
        if (bVar == e.b.UNSPECIFIED) {
            e.b bVar2 = e.b.UNSPECIFIED;
            AppMethodBeat.o(176735);
            return bVar2;
        } else if (!bVar.b(e.b.LANDSCAPE_SENSOR)) {
            e.b bVar3 = e.b.PORTRAIT;
            AppMethodBeat.o(176735);
            return bVar3;
        } else if (bTQ()) {
            e.b bVar4 = e.b.LANDSCAPE_LOCKED;
            AppMethodBeat.o(176735);
            return bVar4;
        } else {
            e.b bVar5 = e.b.LANDSCAPE_SENSOR;
            AppMethodBeat.o(176735);
            return bVar5;
        }
    }
}
