package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.e;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.d;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.Log;

public final class f extends ae {
    private int mErrorCode;
    private e rEE;
    private a rEF;

    public f(int i2, long j2, int i3, int i4, byte[] bArr) {
        AppMethodBeat.i(23802);
        this.rEE = new e(j2, i3, i4, bArr);
        this.mErrorCode = i2;
        AppMethodBeat.o(23802);
    }

    @Override // com.tencent.mm.plugin.exdevice.model.ae
    public final boolean a(m mVar, d dVar) {
        byte[] bArr;
        byte[] bArr2;
        AppMethodBeat.i(23803);
        if (!u.cLx().Dc(this.rEE.pkb)) {
            Log.e("MicroMsg.exdevice.MMInitTaskExcuter", "This device send other cmd before do auth, device id = %d", Long.valueOf(this.rEE.pkb));
            this.rEE.a(-2, "", new byte[0], new byte[0], 0, 0);
            this.rEF = new a(this.rEE, dVar);
            boolean b2 = this.rEF.b(mVar);
            Log.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", Boolean.valueOf(b2));
            AppMethodBeat.o(23803);
            return b2;
        } else if (-5 == this.mErrorCode || -3 == this.mErrorCode || -4 == this.mErrorCode) {
            Log.e("MicroMsg.exdevice.MMInitTaskExcuter", "Error Code = %d, reply errorcode to device and close channel", Integer.valueOf(this.mErrorCode));
            this.rEE.a(-1, "", new byte[0], new byte[0], 0, 0);
            this.rEF = new a(this.rEE, dVar);
            boolean b3 = this.rEF.b(mVar);
            Log.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", Boolean.valueOf(b3));
            AppMethodBeat.o(23803);
            return b3;
        } else {
            com.tencent.mm.plugin.exdevice.f.f fVar = (com.tencent.mm.plugin.exdevice.f.f) this.rEE.cKj();
            if (fVar == null) {
                Log.e("MicroMsg.exdevice.MMInitTaskExcuter", "Init Request parse failed, Tell device before stop this task");
                this.rEE.a(-4, "", new byte[0], new byte[0], 0, 0);
                this.rEF = new a(this.rEE, dVar);
                boolean b4 = this.rEF.b(mVar);
                Log.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", Boolean.valueOf(b4));
                AppMethodBeat.o(23803);
                return b4;
            }
            if (fVar.rBO != null) {
                bArr = fVar.rBO.toByteArray();
            } else {
                bArr = null;
            }
            if (fVar.rBN != null) {
                bArr2 = fVar.rBN.toByteArray();
            } else {
                bArr2 = null;
            }
            ad.cKS();
            int cKt = d.cKt();
            switch (cKt) {
                case 1:
                case 2:
                    break;
                default:
                    Log.e("MicroMsg.exdevice.MMInitTaskExcuter", "initScene = %d, Cannot start init response", Integer.valueOf(cKt));
                    break;
            }
            this.rEE.a(0, null, bArr2, bArr, cKt, (int) (b.cMj() / 1000));
            this.rEF = new a(this.rEE, dVar);
            boolean b5 = this.rEF.b(mVar);
            AppMethodBeat.o(23803);
            return b5;
        }
    }
}
