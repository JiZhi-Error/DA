package com.tencent.mm.modelgeo;

import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.map.geolocation.sapp.TencentLocationListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public abstract class f implements TencentLocationListener {
    private final Map<String, Integer> iVN = new HashMap();

    public f() {
        this.iVN.put("gps", 0);
        this.iVN.put(TencentLocation.NETWORK_PROVIDER, 1);
    }

    @Override // com.tencent.map.geolocation.sapp.TencentLocationListener
    public void onLocationChanged(TencentLocation tencentLocation, int i2, String str) {
        Log.i("MicroMsg.SLocationListener", "lat=%f, lng=%f, accuracy=%f errcode=%d, areastat=%d, speed=%f, bearing=%f, reason=%s, provider=%s", Double.valueOf(tencentLocation.getLatitude()), Double.valueOf(tencentLocation.getLongitude()), Float.valueOf(tencentLocation.getAccuracy()), Integer.valueOf(i2), tencentLocation.getAreaStat(), Float.valueOf(tencentLocation.getSpeed()), Float.valueOf(tencentLocation.getBearing()), str, tencentLocation.getProvider());
        if (i2 == 0) {
            h.INSTANCE.idkeyStat(584, 1, 1, true);
            a(true, tencentLocation.getLatitude(), tencentLocation.getLongitude(), this.iVN.get(tencentLocation.getProvider()).intValue(), (double) tencentLocation.getSpeed(), (double) tencentLocation.getAccuracy(), tencentLocation.getAltitude(), tencentLocation.getIndoorBuildingId(), tencentLocation.getIndoorBuildingFloor(), tencentLocation.getIndoorLocationType());
            return;
        }
        h.INSTANCE.idkeyStat(584, 2, 1, true);
        if (i2 == 1) {
            h.INSTANCE.idkeyStat(584, 3, 1, true);
        } else if (i2 == 4) {
            h.INSTANCE.idkeyStat(584, 4, 1, true);
        }
        a(false, tencentLocation.getLatitude(), tencentLocation.getLongitude(), this.iVN.get(tencentLocation.getProvider()).intValue(), (double) tencentLocation.getSpeed(), (double) tencentLocation.getAccuracy(), tencentLocation.getAltitude(), tencentLocation.getIndoorBuildingId(), tencentLocation.getIndoorBuildingFloor(), tencentLocation.getIndoorLocationType());
    }

    @Override // com.tencent.map.geolocation.sapp.TencentLocationListener
    public void onStatusUpdate(String str, int i2, String str2) {
        Log.d("MicroMsg.SLocationListener", "onStatusUpdate, name=%s, status=%d, desc=%s", str, Integer.valueOf(i2), str2);
    }

    public void a(boolean z, double d2, double d3, int i2, double d4, double d5, double d6, String str, String str2, int i3) {
    }
}
