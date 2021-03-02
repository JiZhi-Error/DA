package com.b.a.a;

import android.content.Context;
import android.location.LocationManager;
import android.os.Handler;
import com.b.a.a.n;
import com.b.a.a.s;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class t {
    private static Context ckW;
    private static WeakReference<b> ckX;
    private static WeakReference<d> ckY;
    private static WeakReference<c> ckZ;
    private static WeakReference<e> cla;
    private static final a clb = new a((byte) 0);
    private static String imei;
    private static boolean isRunning = false;

    public interface b {
        void onLocationUpdate(double d2, double d3, int i2, int i3, long j2);
    }

    public interface c {
        void onRefAdded(int i2);

        void onTrackProcessed(boolean z);
    }

    public interface d {
        void onMessage(int i2, String str);
    }

    public interface e {
    }

    static {
        AppMethodBeat.i(87923);
        AppMethodBeat.o(87923);
    }

    public static void a(Context context, q qVar) {
        AppMethodBeat.i(87924);
        ckW = context.getApplicationContext();
        try {
            w.JC().a(context, clb);
            r.Jg().cks = qVar;
            r.Jg().ckt = imei;
            AppMethodBeat.o(87924);
        } catch (Exception e2) {
            AppMethodBeat.o(87924);
        }
    }

    public static void setImei(String str) {
        imei = str;
    }

    public static boolean a(Handler handler, long j2, b bVar, d dVar) {
        boolean z;
        AppMethodBeat.i(87925);
        if (ckW == null) {
            AppMethodBeat.o(87925);
            return false;
        } else if (isRunning) {
            AppMethodBeat.o(87925);
            return true;
        } else {
            ckX = new WeakReference<>(bVar);
            ckY = new WeakReference<>(dVar);
            ckZ = new WeakReference<>(null);
            try {
                w JC = w.JC();
                if (handler == null) {
                    handler = new Handler(ckW.getMainLooper());
                }
                JC.a(handler, new n.c(j2, 5000));
                if (y.cnn) {
                    y.cnu = o.Jf();
                    o.t("filter_input_log_" + y.cnu, "type,unixTime,latR,lngR,alt,acc,numWap,speed,maturity,numStep,stepLength,bearingR");
                    o.t("filter_output_log_" + y.cnu, "time,lat,lng,err,speed");
                    o.t("gps_log_" + y.cnu, "lat,lng,alt,accuracy,speed,numSatVisible,numSatUsedInFix,quality,timeSinceFixS");
                    o.t("post_processing_log_" + y.cnu, "tag,lat,lng");
                }
                if (!(cla == null || cla.get() == null)) {
                    LocationManager locationManager = (LocationManager) ckW.getSystemService(FirebaseAnalytics.b.LOCATION);
                    try {
                        z = locationManager.isProviderEnabled("gps");
                    } catch (SecurityException e2) {
                        z = false;
                    }
                    if (!z) {
                        try {
                            locationManager.isProviderEnabled(TencentLocation.NETWORK_PROVIDER);
                        } catch (SecurityException e3) {
                        }
                    }
                }
                isRunning = true;
                AppMethodBeat.o(87925);
                return true;
            } catch (Exception e4) {
                isRunning = false;
                AppMethodBeat.o(87925);
                return false;
            }
        }
    }

    public static void Jt() {
        AppMethodBeat.i(87926);
        try {
            w.JC().stop();
        } catch (Exception e2) {
        } finally {
            isRunning = false;
            AppMethodBeat.o(87926);
        }
    }

    public static void finish() {
        AppMethodBeat.i(87927);
        try {
            w.JC().IY();
            AppMethodBeat.o(87927);
        } catch (Exception e2) {
            AppMethodBeat.o(87927);
        }
    }

    static class a implements m {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.b.a.a.m
        public final void a(p pVar) {
            c cVar;
            c cVar2;
            d dVar;
            b bVar;
            AppMethodBeat.i(87922);
            switch (pVar.what) {
                case 8901:
                    if (!(t.ckZ == null || (cVar2 = (c) t.ckZ.get()) == null)) {
                        cVar2.onRefAdded(((s.e) pVar).ckU);
                        AppMethodBeat.o(87922);
                        return;
                    }
                case 8902:
                    if (!(t.ckZ == null || (cVar = (c) t.ckZ.get()) == null)) {
                        cVar.onTrackProcessed(((s.g) pVar).ckV);
                        break;
                    }
                case 9901:
                    if (!(t.ckX == null || (bVar = (b) t.ckX.get()) == null)) {
                        n.a aVar = (n.a) pVar;
                        bVar.onLocationUpdate(aVar.lat, aVar.lng, aVar.cjQ, aVar.cjR, aVar.cjS);
                        AppMethodBeat.o(87922);
                        return;
                    }
                case 9902:
                    if (!(t.ckY == null || (dVar = (d) t.ckY.get()) == null)) {
                        n.b bVar2 = (n.b) pVar;
                        dVar.onMessage(bVar2.code, bVar2.message);
                        AppMethodBeat.o(87922);
                        return;
                    }
            }
            AppMethodBeat.o(87922);
        }
    }
}
