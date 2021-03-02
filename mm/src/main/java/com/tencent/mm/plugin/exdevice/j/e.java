package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.exdevice.c.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.r;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.Log;

public final class e extends ae implements i {
    private int mErrorCode;
    private d rEB;
    private b rEC = null;
    private a rED;
    private m rxT;

    public e(int i2, long j2, int i3, int i4, byte[] bArr) {
        AppMethodBeat.i(23799);
        this.rEC = new b(j2, i3, i4, bArr);
        this.mErrorCode = i2;
        AppMethodBeat.o(23799);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(23800);
        bg.azz().b(541, this);
        Log.i("MicroMsg.exdevice.MMAuthTaskExcuter", "onscen end, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        r rVar = (r) qVar;
        com.tencent.mm.plugin.exdevice.i.b anI = ad.cKL().anI(new StringBuilder().append(this.rEC.pkb).toString());
        if (anI == null) {
            Log.e("MicroMsg.exdevice.MMAuthTaskExcuter", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
            AppMethodBeat.o(23800);
            return;
        }
        if (System.currentTimeMillis() / 1000 < ((long) anI.fLY)) {
            Log.e("MicroMsg.exdevice.MMAuthTaskExcuter", "device has been blocked");
            this.rEC.a(-5, "", new byte[0]);
            this.rED = new a(this.rEC, this.rEB);
            Log.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", Boolean.valueOf(this.rED.b(this.rxT)));
            AppMethodBeat.o(23800);
            return;
        }
        this.rEC.a(i3, str, rVar.cKF());
        this.rED = new a(this.rEC, this.rEB);
        Log.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", Boolean.valueOf(this.rED.b(this.rxT)));
        AppMethodBeat.o(23800);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00fa, code lost:
        if (r0 != r10.rEC.pkb) goto L_0x00fc;
     */
    @Override // com.tencent.mm.plugin.exdevice.model.ae
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.tencent.mm.plugin.exdevice.service.m r11, com.tencent.mm.plugin.exdevice.j.d r12) {
        /*
        // Method dump skipped, instructions count: 866
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.j.e.a(com.tencent.mm.plugin.exdevice.service.m, com.tencent.mm.plugin.exdevice.j.d):boolean");
    }
}
