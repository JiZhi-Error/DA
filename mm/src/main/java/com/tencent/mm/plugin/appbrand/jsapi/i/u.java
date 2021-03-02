package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.bluetooth.BluetoothAdapter;
import android.location.LocationManager;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.luggage.f.a.a;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.c;

public final class u extends a {
    private static volatile Boolean lXB;

    @Override // com.tencent.luggage.f.a.a
    public final boolean Pd() {
        boolean z;
        AppMethodBeat.i(46386);
        if (lXB != null) {
            lXB.booleanValue();
        } else {
            com.tencent.mm.ipcinvoker.wx_extension.a.a aVar = a.C0356a.hnM;
            c Fu = com.tencent.mm.ipcinvoker.wx_extension.a.a.Fu("100459");
            if (Fu == null) {
                Log.i("MicroMsg.TencentLocationManagerWxImp", "[sLocationLogOpen] item is null");
                lXB = Boolean.FALSE;
            } else {
                if (!Fu.isValid() || !ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(Fu.gzz().get("isLocationLogOpen"))) {
                    z = false;
                } else {
                    z = true;
                }
                lXB = Boolean.valueOf(z);
                Log.i("MicroMsg.TencentLocationManagerWxImp", "sLocationLogOpen:%b", lXB);
                lXB.booleanValue();
            }
        }
        boolean booleanValue = lXB.booleanValue();
        AppMethodBeat.o(46386);
        return booleanValue;
    }

    static {
        AppMethodBeat.i(46387);
        try {
            Log.i("MicroMsg.TencentLocationManagerWxImp", "printBluetoothEnable open:%b", Boolean.valueOf(BluetoothAdapter.getDefaultAdapter().isEnabled()));
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.TencentLocationManagerWxImp", e2, "", new Object[0]);
            Log.i("MicroMsg.TencentLocationManagerWxImp", "printBluetoothEnable fail");
        }
        try {
            LocationManager locationManager = (LocationManager) MMApplicationContext.getContext().getSystemService(FirebaseAnalytics.b.LOCATION);
            if (locationManager != null) {
                boolean isProviderEnabled = locationManager.isProviderEnabled("gps");
                Log.i("MicroMsg.TencentLocationManagerWxImp", "isGPSEnable " + isProviderEnabled + ", isNetworkEnable:" + locationManager.isProviderEnabled(TencentLocation.NETWORK_PROVIDER));
            } else {
                Log.e("MicroMsg.TencentLocationManagerWxImp", "locationManager is null");
            }
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.TencentLocationManagerWxImp", e3, "", new Object[0]);
        }
        Log.i("MicroMsg.TencentLocationManagerWxImp", "Imei:%s", q.dr(true));
        AppMethodBeat.o(46387);
    }
}
