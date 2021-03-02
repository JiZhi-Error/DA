package android.support.v7.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.content.f;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Calendar;

final class i {
    private static i aag;
    private final LocationManager aah;
    private final a aai = new a();
    private final Context mContext;

    static i aa(Context context) {
        if (aag == null) {
            Context applicationContext = context.getApplicationContext();
            aag = new i(applicationContext, (LocationManager) applicationContext.getSystemService(FirebaseAnalytics.b.LOCATION));
        }
        return aag;
    }

    private i(Context context, LocationManager locationManager) {
        this.mContext = context;
        this.aah = locationManager;
    }

    /* access modifiers changed from: package-private */
    public final boolean gT() {
        a aVar = this.aai;
        if (gV()) {
            return aVar.aaj;
        }
        Location gU = gU();
        if (gU != null) {
            a(gU);
            return aVar.aaj;
        }
        int i2 = Calendar.getInstance().get(11);
        return i2 < 6 || i2 >= 22;
    }

    @SuppressLint({"MissingPermission"})
    private Location gU() {
        Location location;
        Location location2 = null;
        if (f.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            location = C(TencentLocation.NETWORK_PROVIDER);
        } else {
            location = null;
        }
        if (f.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location2 = C("gps");
        }
        return (location2 == null || location == null) ? location2 != null ? location2 : location : location2.getTime() > location.getTime() ? location2 : location;
    }

    private Location C(String str) {
        try {
            if (this.aah.isProviderEnabled(str)) {
                return this.aah.getLastKnownLocation(str);
            }
        } catch (Exception e2) {
        }
        return null;
    }

    private boolean gV() {
        return this.aai.aao > System.currentTimeMillis();
    }

    private void a(Location location) {
        long j2;
        long j3;
        a aVar = this.aai;
        long currentTimeMillis = System.currentTimeMillis();
        h gS = h.gS();
        gS.b(currentTimeMillis - Util.MILLSECONDS_OF_DAY, location.getLatitude(), location.getLongitude());
        long j4 = gS.aae;
        gS.b(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = gS.state == 1;
        long j5 = gS.aaf;
        long j6 = gS.aae;
        gS.b(Util.MILLSECONDS_OF_DAY + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j7 = gS.aaf;
        if (j5 == -1 || j6 == -1) {
            j2 = 43200000 + currentTimeMillis;
        } else {
            if (currentTimeMillis > j6) {
                j3 = 0 + j7;
            } else if (currentTimeMillis > j5) {
                j3 = 0 + j6;
            } else {
                j3 = 0 + j5;
            }
            j2 = j3 + Util.MILLSECONDS_OF_MINUTE;
        }
        aVar.aaj = z;
        aVar.aak = j4;
        aVar.aal = j5;
        aVar.aam = j6;
        aVar.aan = j7;
        aVar.aao = j2;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        boolean aaj;
        long aak;
        long aal;
        long aam;
        long aan;
        long aao;

        a() {
        }
    }
}
