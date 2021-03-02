package com.tencent.mm.plugin.exdevice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.e;
import com.tencent.mm.plugin.exdevice.j.f;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.plugin.exdevice.service.i;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends i.a {
    private static a rxt = null;

    /* renamed from: com.tencent.mm.plugin.exdevice.c.a$a  reason: collision with other inner class name */
    static class RunnableC0985a implements Runnable {
        private int mCmdId = -1;
        private long pkb = -1;
        private int rxu = -1;
        private int rxv;
        private byte[] rxw = null;

        public RunnableC0985a(int i2, long j2, int i3, int i4, byte[] bArr) {
            this.pkb = j2;
            this.rxu = i3;
            this.mCmdId = i4;
            this.rxw = bArr;
            this.rxv = i2;
        }

        public final void cKf() {
            AppMethodBeat.i(23143);
            if (this.pkb == -1 || this.rxu == -1 || this.mCmdId == -1) {
                Log.e("MicroMsg.RequestProcessThread", "invalid arguments, do nothing");
                AppMethodBeat.o(23143);
                return;
            }
            switch (this.mCmdId) {
                case 10001:
                    u.cLy().a(new e(this.rxv, this.pkb, this.rxu, this.mCmdId, this.rxw));
                    AppMethodBeat.o(23143);
                    return;
                case 10002:
                    k.cKl().b(this.rxv, this.pkb, this.rxu, this.mCmdId, this.rxw);
                    AppMethodBeat.o(23143);
                    return;
                case ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL /*{ENCODED_INT: 10003}*/:
                    u.cLy().a(new f(this.rxv, this.pkb, this.rxu, this.mCmdId, this.rxw));
                    AppMethodBeat.o(23143);
                    return;
                default:
                    Log.e("MicroMsg.RequestProcessThread", "unknown cmdId = %d, do nothing", Integer.valueOf(this.mCmdId));
                    AppMethodBeat.o(23143);
                    return;
            }
        }

        public final void run() {
            AppMethodBeat.i(23144);
            cKf();
            AppMethodBeat.o(23144);
        }
    }

    private a() {
    }

    public static a cKe() {
        AppMethodBeat.i(23145);
        if (rxt == null) {
            a aVar = new a();
            rxt = aVar;
            AppMethodBeat.o(23145);
            return aVar;
        }
        a aVar2 = rxt;
        AppMethodBeat.o(23145);
        return aVar2;
    }

    @Override // com.tencent.mm.plugin.exdevice.service.i
    public final void a(int i2, long j2, int i3, int i4, byte[] bArr) {
        int i5;
        AppMethodBeat.i(23146);
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Long.valueOf(j2);
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = Integer.valueOf(i4);
        objArr[4] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        Log.i("MicroMsg.exdevice.DeviceRequestManager", "------onDeviceRequest------ errorCode = %d, deviceId = %d, seq = %d, cmdId = %d, datalength = %d", objArr);
        if (i2 == 0) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        com.tencent.mm.plugin.exdevice.h.a.q(j2, i5);
        String bw = b.bw(bArr);
        if (bw == null) {
            Log.e("MicroMsg.exdevice.DeviceRequestManager", "dataIn is null!!! Just leave without process data");
            AppMethodBeat.o(23146);
            return;
        }
        Log.d("MicroMsg.exdevice.DeviceRequestManager", "data dump = %s", bw);
        new RunnableC0985a(i2, j2, i3, i4, bArr).cKf();
        AppMethodBeat.o(23146);
    }
}
