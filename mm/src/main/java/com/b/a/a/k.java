package com.b.a.a;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import com.b.a.a.d;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class k extends c implements GpsStatus.Listener, LocationListener {
    private static k cjg;
    private LocationManager aah;
    private boolean cjh;
    private GpsStatus cji;
    private a cjj;
    private final l cjk = new l();
    private Context mAppContext;
    private Looper mLooper;

    private k() {
        AppMethodBeat.i(87938);
        AppMethodBeat.o(87938);
    }

    static k Jc() {
        AppMethodBeat.i(87939);
        if (cjg == null) {
            cjg = new k();
        }
        k kVar = cjg;
        AppMethodBeat.o(87939);
        return kVar;
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.d
    public final void au(Context context) {
        AppMethodBeat.i(87941);
        this.mAppContext = context;
        this.aah = (LocationManager) context.getSystemService(FirebaseAnalytics.b.LOCATION);
        this.cjh = (this.aah == null || this.aah.getProvider("gps") == null) ? false : true;
        AppMethodBeat.o(87941);
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.d
    public final void IV() {
    }

    public final void onLocationChanged(Location location) {
        int i2;
        int i3;
        boolean z;
        AppMethodBeat.i(87944);
        if (!y.cnn) {
            if (Settings.Secure.getString(this.mAppContext.getContentResolver(), "mock_location").equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                AppMethodBeat.o(87944);
                return;
            }
        }
        int i4 = 0;
        if (this.cji != null) {
            int i5 = 0;
            for (GpsSatellite gpsSatellite : this.cji.getSatellites()) {
                i4++;
                if (gpsSatellite.usedInFix()) {
                    i5++;
                }
            }
            i2 = i5;
            i3 = i4;
        } else {
            i2 = 0;
            i3 = 0;
        }
        this.cjk.a(location.getAccuracy(), i2, location.getTime());
        c(new b(location.getLatitude(), location.getLongitude(), location.getAltitude(), location.getAccuracy(), location.getSpeed(), i3, i2, this.cjk.cjo, this.cjk.cjw / 1000, (byte) 0));
        AppMethodBeat.o(87944);
    }

    public final void onStatusChanged(String str, int i2, Bundle bundle) {
    }

    public final void onProviderEnabled(String str) {
    }

    public final void onProviderDisabled(String str) {
    }

    public final void onGpsStatusChanged(int i2) {
        AppMethodBeat.i(87945);
        if (i2 == 4) {
            if (this.cji == null) {
                this.cji = this.aah.getGpsStatus(null);
                AppMethodBeat.o(87945);
                return;
            }
            this.aah.getGpsStatus(this.cji);
        }
        AppMethodBeat.o(87945);
    }

    private void a(long j2, float f2) {
        AppMethodBeat.i(87946);
        this.aah.requestLocationUpdates("gps", j2, f2, this, this.mLooper);
        AppMethodBeat.o(87946);
    }

    static class b extends p {
        final float bdN;
        final double cjm;
        final float cjn;
        final float cjo;
        final int cjp;
        final int cjq;
        final long cjr;
        final double lat;
        final double lng;

        /* synthetic */ b(double d2, double d3, double d4, float f2, float f3, int i2, int i3, float f4, long j2, byte b2) {
            this(d2, d3, d4, f2, f3, i2, i3, f4, j2);
        }

        private b(double d2, double d3, double d4, float f2, float f3, int i2, int i3, float f4, long j2) {
            super(401);
            this.lat = d2;
            this.lng = d3;
            this.cjm = d4;
            this.cjn = f2;
            this.bdN = f3;
            this.cjp = i2;
            this.cjq = i3;
            this.cjo = f4;
            this.cjr = j2;
        }
    }

    static class a extends d.a {
        final int cjl = 0;

        a(long j2) {
            super(j2);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.d, com.b.a.a.c
    public final synchronized void a(Handler handler, d.a aVar) {
        a aVar2;
        AppMethodBeat.i(87940);
        if (aVar == null) {
            aVar2 = new a(30000);
        } else if (aVar instanceof a) {
            aVar2 = (a) aVar;
        } else {
            aVar2 = new a(aVar.chx);
        }
        super.a(handler, aVar2);
        AppMethodBeat.o(87940);
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.d
    public final void a(Context context, Handler handler, d.a aVar) {
        AppMethodBeat.i(87942);
        if (!this.cjh) {
            AppMethodBeat.o(87942);
            return;
        }
        this.cjj = (a) aVar;
        this.mLooper = handler != null ? handler.getLooper() : null;
        a(this.cjj.chx, (float) this.cjj.cjl);
        this.aah.addGpsStatusListener(this);
        this.cjk.cjs = Math.max(5000L, Math.min(this.cjj.chx + 5000, 65000L));
        AppMethodBeat.o(87942);
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.d
    public final void av(Context context) {
        AppMethodBeat.i(87943);
        if (!this.cjh) {
            AppMethodBeat.o(87943);
            return;
        }
        this.aah.removeUpdates(this);
        this.aah.removeGpsStatusListener(this);
        AppMethodBeat.o(87943);
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.c
    public final void IW() {
        AppMethodBeat.i(87947);
        if (!this.cjh || !this.isRunning || this.cjj.chx >= 300000) {
            AppMethodBeat.o(87947);
            return;
        }
        a(300000, (float) this.cjj.cjl);
        AppMethodBeat.o(87947);
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.c
    public final void IX() {
        AppMethodBeat.i(87948);
        if (!this.cjh || !this.isRunning || this.cjj.chx >= 300000) {
            AppMethodBeat.o(87948);
            return;
        }
        a(this.cjj.chx, (float) this.cjj.cjl);
        AppMethodBeat.o(87948);
    }
}
