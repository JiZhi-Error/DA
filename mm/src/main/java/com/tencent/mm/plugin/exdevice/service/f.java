package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class f {
    public HashMap<Long, a> rDC = new HashMap<>();

    public static class a {
        public String brandName;
        public int dHO;
        public String mURL;
        public long phx;
        public long rDD;
        public byte[] rDE;
        public byte[] rDF;
        public boolean rDG;
        public byte[] sessionKey;
    }

    public f() {
        AppMethodBeat.i(23649);
        AppMethodBeat.o(23649);
    }

    public final boolean CW(long j2) {
        AppMethodBeat.i(23650);
        if (CX(j2) == 2) {
            AppMethodBeat.o(23650);
            return true;
        }
        AppMethodBeat.o(23650);
        return false;
    }

    public final int CX(long j2) {
        AppMethodBeat.i(23651);
        if (this.rDC.containsKey(Long.valueOf(j2))) {
            int i2 = this.rDC.get(Long.valueOf(j2)).dHO;
            AppMethodBeat.o(23651);
            return i2;
        }
        AppMethodBeat.o(23651);
        return 0;
    }

    public final a CY(long j2) {
        AppMethodBeat.i(23652);
        if (!this.rDC.containsKey(Long.valueOf(j2))) {
            Dd(j2);
        }
        a aVar = this.rDC.get(Long.valueOf(j2));
        AppMethodBeat.o(23652);
        return aVar;
    }

    public final a CZ(long j2) {
        AppMethodBeat.i(23653);
        if (this.rDC.containsKey(Long.valueOf(j2))) {
            a aVar = this.rDC.get(Long.valueOf(j2));
            AppMethodBeat.o(23653);
            return aVar;
        }
        a aVar2 = new a();
        aVar2.rDD = j2;
        aVar2.rDF = null;
        aVar2.sessionKey = null;
        aVar2.rDE = null;
        aVar2.brandName = null;
        aVar2.mURL = null;
        aVar2.dHO = 0;
        aVar2.rDG = false;
        aVar2.phx = 0;
        this.rDC.put(Long.valueOf(j2), aVar2);
        AppMethodBeat.o(23653);
        return aVar2;
    }

    public final boolean Da(long j2) {
        AppMethodBeat.i(23654);
        Log.i("MicroMsg.exdevice.ExdeviceInfoManager", "setDeviceAuthFlag, device id = %d", Long.valueOf(j2));
        a CY = CY(j2);
        if (CY == null) {
            Log.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
            AppMethodBeat.o(23654);
            return false;
        }
        CY.rDG = true;
        AppMethodBeat.o(23654);
        return true;
    }

    public final boolean Db(long j2) {
        AppMethodBeat.i(23655);
        Log.i("MicroMsg.exdevice.ExdeviceInfoManager", "delDeviceAuthFlag, device id = %d", Long.valueOf(j2));
        a CY = CY(j2);
        if (CY == null) {
            Log.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
            AppMethodBeat.o(23655);
            return false;
        }
        CY.rDG = false;
        AppMethodBeat.o(23655);
        return true;
    }

    public final boolean Dc(long j2) {
        AppMethodBeat.i(23656);
        Log.i("MicroMsg.exdevice.ExdeviceInfoManager", "isDeviceAuthed, device id = %d", Long.valueOf(j2));
        a CY = CY(j2);
        if (CY == null) {
            Log.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
            AppMethodBeat.o(23656);
            return false;
        }
        boolean z = CY.rDG;
        AppMethodBeat.o(23656);
        return z;
    }

    private void Dd(long j2) {
        AppMethodBeat.i(23657);
        b anI = ad.cKL().anI(String.valueOf(j2));
        if (anI == null) {
            Log.e("MicroMsg.exdevice.ExdeviceInfoManager", "get harddevice info from db failed : %d", Long.valueOf(j2));
            AppMethodBeat.o(23657);
            return;
        }
        a aVar = new a();
        aVar.rDD = j2;
        aVar.rDF = anI.field_authBuf;
        aVar.sessionKey = anI.field_sessionKey;
        aVar.rDE = anI.field_sessionBuf;
        aVar.brandName = anI.field_brandName;
        aVar.mURL = anI.field_url;
        aVar.dHO = 0;
        aVar.rDG = false;
        this.rDC.put(Long.valueOf(j2), aVar);
        Log.i("MicroMsg.exdevice.ExdeviceInfoManager", "not contains the device info, device id = %d, load from db", Long.valueOf(j2));
        AppMethodBeat.o(23657);
    }

    public final byte[] r(long j2, int i2) {
        byte[] bArr;
        AppMethodBeat.i(23658);
        if (j2 < 0) {
            Log.e("MicroMsg.exdevice.ExdeviceInfoManager", "device is lower than 0");
            AppMethodBeat.o(23658);
            return null;
        }
        a aVar = this.rDC.get(Long.valueOf(j2));
        if (aVar == null) {
            Dd(j2);
            aVar = this.rDC.get(Long.valueOf(j2));
        }
        if (aVar == null) {
            AppMethodBeat.o(23658);
            return null;
        }
        switch (i2) {
            case 1:
                bArr = aVar.rDF;
                break;
            case 2:
                bArr = aVar.sessionKey;
                break;
            case 3:
                bArr = aVar.rDE;
                break;
            default:
                bArr = null;
                break;
        }
        AppMethodBeat.o(23658);
        return bArr;
    }

    public final void b(long j2, byte[] bArr, int i2) {
        AppMethodBeat.i(23659);
        if (j2 < 0 || bArr == null || bArr.length == 0) {
            Object[] objArr = new Object[3];
            objArr[0] = Long.valueOf(j2);
            objArr[1] = Boolean.valueOf(bArr == null);
            objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            Log.e("MicroMsg.exdevice.ExdeviceInfoManager", "device id low than 0 or authbuf is null, deviceid = %d, buffer == null : %b, buffer length = %d", objArr);
            AppMethodBeat.o(23659);
            return;
        }
        a aVar = this.rDC.get(Long.valueOf(j2));
        if (aVar == null) {
            aVar = new a();
            aVar.rDD = j2;
        }
        switch (i2) {
            case 1:
                aVar.rDF = bArr;
                break;
            case 2:
                aVar.sessionKey = bArr;
                break;
            case 3:
                aVar.rDE = bArr;
                break;
            default:
                Log.e("MicroMsg.exdevice.ExdeviceInfoManager", "unkown buffer type : %d", Integer.valueOf(i2));
                break;
        }
        this.rDC.put(Long.valueOf(j2), aVar);
        AppMethodBeat.o(23659);
    }
}
