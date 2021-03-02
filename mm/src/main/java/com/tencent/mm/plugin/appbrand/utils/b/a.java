package com.tencent.mm.plugin.appbrand.utils.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface a extends com.tencent.luggage.a.b {

    public interface b {
        void a(int i2, String str, C0814a aVar);
    }

    void a(String str, b bVar, Bundle bundle);

    boolean b(String str, b bVar, Bundle bundle);

    boolean c(String str, b bVar, Bundle bundle);

    /* renamed from: com.tencent.mm.plugin.appbrand.utils.b.a$a  reason: collision with other inner class name */
    public static class C0814a {
        public double altitude;
        public String buildingId;
        public double dxQ;
        public String floorName;
        public Object iMa;
        public double latitude;
        public double longitude;
        public double ohZ;
        public int oia;
        public float oib;
        public double oic = 0.0d;
        public String provider;

        public final String toString() {
            AppMethodBeat.i(143729);
            String str = "Location{latitude=" + this.latitude + ", longitude=" + this.longitude + ", provider='" + this.provider + '\'' + ", speed=" + this.dxQ + ", accuracy=" + this.ohZ + ", altitude=" + this.altitude + ", buildingId='" + this.buildingId + '\'' + ", floorName='" + this.floorName + '\'' + ", extra=" + this.iMa + ", indoorLocationType=" + this.oia + ", direction=" + this.oib + '}';
            AppMethodBeat.o(143729);
            return str;
        }
    }
}
