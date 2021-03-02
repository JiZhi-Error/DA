package com.tencent.mm.plugin.exdevice.service;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class x implements m {
    private h rDX;

    public x(h hVar) {
        this.rDX = hVar;
    }

    @Override // com.tencent.mm.plugin.exdevice.service.m
    public final boolean b(int i2, j jVar) {
        boolean z = false;
        AppMethodBeat.i(23701);
        try {
            z = this.rDX.b(i2, jVar);
            AppMethodBeat.o(23701);
        } catch (RemoteException e2) {
            Log.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "scan failed!!! %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e2, "", new Object[0]);
            AppMethodBeat.o(23701);
        }
        return z;
    }

    @Override // com.tencent.mm.plugin.exdevice.service.m
    public final boolean c(int i2, j jVar) {
        boolean z = false;
        AppMethodBeat.i(23702);
        try {
            z = this.rDX.c(i2, jVar);
            AppMethodBeat.o(23702);
        } catch (RemoteException e2) {
            Log.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "stopScan failed!!! %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e2, "", new Object[0]);
            AppMethodBeat.o(23702);
        }
        return z;
    }

    @Override // com.tencent.mm.plugin.exdevice.service.m
    public final long[] cLa() {
        AppMethodBeat.i(23703);
        try {
            long[] cLa = this.rDX.cLa();
            AppMethodBeat.o(23703);
            return cLa;
        } catch (RemoteException e2) {
            Log.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "getDeviceList failed!!! %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e2, "", new Object[0]);
            AppMethodBeat.o(23703);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.exdevice.service.m
    public final boolean a(long j2, int i2, k kVar) {
        boolean z = false;
        AppMethodBeat.i(23704);
        u.cLx().Db(j2);
        try {
            z = this.rDX.a(j2, i2, kVar);
            AppMethodBeat.o(23704);
        } catch (RemoteException e2) {
            Log.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "startChannel failed!!! %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e2, "", new Object[0]);
            AppMethodBeat.o(23704);
        }
        return z;
    }

    @Override // com.tencent.mm.plugin.exdevice.service.m
    public final boolean De(long j2) {
        boolean z = false;
        AppMethodBeat.i(23705);
        u.cLx().Db(j2);
        try {
            z = this.rDX.De(j2);
            AppMethodBeat.o(23705);
        } catch (RemoteException e2) {
            Log.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "stopChannel failed!!! %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e2, "", new Object[0]);
            AppMethodBeat.o(23705);
        }
        return z;
    }

    @Override // com.tencent.mm.plugin.exdevice.service.m
    public final long a(p pVar) {
        AppMethodBeat.i(23706);
        try {
            long a2 = this.rDX.a(pVar);
            AppMethodBeat.o(23706);
            return a2;
        } catch (RemoteException e2) {
            Log.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "startTask failed!!! %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e2, "", new Object[0]);
            AppMethodBeat.o(23706);
            return -1;
        }
    }

    public final boolean a(i iVar) {
        boolean z = false;
        AppMethodBeat.i(23707);
        try {
            z = this.rDX.a(iVar);
            AppMethodBeat.o(23707);
        } catch (RemoteException e2) {
            Log.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "registOnDeviceRequest failed!!! %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e2, "", new Object[0]);
            AppMethodBeat.o(23707);
        }
        return z;
    }

    @Override // com.tencent.mm.plugin.exdevice.service.m
    public final void setChannelSessionKey(long j2, byte[] bArr) {
        AppMethodBeat.i(23708);
        Log.i("MicroMsg.exdevice.RDeviceTaskDispatcher", "------setChannelSessionKey------ deviceId = %d", Long.valueOf(j2));
        try {
            this.rDX.setChannelSessionKey(j2, bArr);
            AppMethodBeat.o(23708);
        } catch (RemoteException e2) {
            Log.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e2, "", new Object[0]);
            AppMethodBeat.o(23708);
        }
    }

    @Override // com.tencent.mm.plugin.exdevice.service.m
    public final boolean a(String str, boolean z, q qVar) {
        boolean z2 = false;
        AppMethodBeat.i(23709);
        Log.i("MicroMsg.exdevice.RDeviceTaskDispatcher", "ranging, uuid = %s, op = %s", str, String.valueOf(z));
        try {
            z2 = this.rDX.a(str, z, qVar);
            AppMethodBeat.o(23709);
        } catch (RemoteException e2) {
            Log.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "mDispatcher.ranging failed!!!(%s)", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e2, "", new Object[0]);
            AppMethodBeat.o(23709);
        }
        return z2;
    }

    public final boolean b(n nVar) {
        AppMethodBeat.i(23710);
        try {
            this.rDX.a(nVar);
            AppMethodBeat.o(23710);
            return true;
        } catch (RemoteException e2) {
            Log.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "mDispatcher.registExDeviceInvokerHandler failed!!, %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e2, "", new Object[0]);
            AppMethodBeat.o(23710);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.exdevice.service.m
    public final boolean a(j jVar) {
        boolean z = false;
        AppMethodBeat.i(23711);
        try {
            z = this.rDX.d(0, jVar);
            AppMethodBeat.o(23711);
        } catch (RemoteException e2) {
            Log.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e2, "", new Object[0]);
            AppMethodBeat.o(23711);
        }
        return z;
    }

    @Override // com.tencent.mm.plugin.exdevice.service.m
    public final boolean b(j jVar) {
        boolean z = false;
        AppMethodBeat.i(23712);
        try {
            z = this.rDX.e(0, jVar);
            AppMethodBeat.o(23712);
        } catch (RemoteException e2) {
            Log.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e2, "", new Object[0]);
            AppMethodBeat.o(23712);
        }
        return z;
    }

    @Override // com.tencent.mm.plugin.exdevice.service.m
    public final boolean a(long j2, k kVar) {
        boolean z = false;
        AppMethodBeat.i(23713);
        try {
            z = this.rDX.b(j2, 0, kVar);
            AppMethodBeat.o(23713);
        } catch (RemoteException e2) {
            Log.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e2, "", new Object[0]);
            AppMethodBeat.o(23713);
        }
        return z;
    }

    @Override // com.tencent.mm.plugin.exdevice.service.m
    public final boolean Dh(long j2) {
        boolean z = false;
        AppMethodBeat.i(23714);
        try {
            z = this.rDX.Dh(j2);
            AppMethodBeat.o(23714);
        } catch (RemoteException e2) {
            Log.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e2, "", new Object[0]);
            AppMethodBeat.o(23714);
        }
        return z;
    }

    public final boolean a(s sVar) {
        boolean z = false;
        AppMethodBeat.i(23715);
        try {
            z = this.rDX.a(sVar);
            AppMethodBeat.o(23715);
        } catch (RemoteException e2) {
            Log.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e2, "", new Object[0]);
            AppMethodBeat.o(23715);
        }
        return z;
    }

    @Override // com.tencent.mm.plugin.exdevice.service.m
    public final boolean b(long j2, byte[] bArr, t tVar) {
        boolean z = false;
        AppMethodBeat.i(23716);
        try {
            z = this.rDX.b(j2, bArr, tVar);
            AppMethodBeat.o(23716);
        } catch (RemoteException e2) {
            Log.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e2, "", new Object[0]);
            AppMethodBeat.o(23716);
        }
        return z;
    }
}
