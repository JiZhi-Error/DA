package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.l;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.backup.b.c;
import com.tencent.mm.plugin.backup.i.v;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a extends b {
    final String authId;
    public v oPh = new v();
    public w oPi = new w();
    final int oPj;
    final String oPk;
    final byte[] oPl;

    public a(String str, String str2, byte[] bArr, String str3, int i2, int i3, boolean z) {
        AppMethodBeat.i(231596);
        Log.i("MicroMsg.BackupAuthScene", "BackupAuthScene init, backupType[%d], stack:%s", Integer.valueOf(i3), Util.getStack());
        this.oPh.oTm = new b(l.e(str.getBytes(), bArr));
        this.oPh.oUu = 0;
        this.oPh.ID = str3;
        this.oPh.Version = i2;
        this.oPh.oUv = z ? c.oIO : c.oIN;
        this.oPk = str2;
        this.authId = str3;
        this.oPl = bArr;
        this.oPj = i3;
        AppMethodBeat.o(231596);
    }

    @Override // com.tencent.mm.plugin.backup.g.b, com.tencent.mm.ak.q
    public final int getType() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.backup.g.b
    public final com.tencent.mm.bw.a cgq() {
        return this.oPi;
    }

    @Override // com.tencent.mm.plugin.backup.g.b
    public final com.tencent.mm.bw.a cgr() {
        return this.oPh;
    }

    @Override // com.tencent.mm.plugin.backup.g.b
    public final void Bm(int i2) {
        boolean equals;
        AppMethodBeat.i(21696);
        if (this.oPi.oTW != 0) {
            Log.e("MicroMsg.BackupAuthScene", "onSceneEnd errType[%d]", Integer.valueOf(this.oPi.oTW));
            q(4, this.oPi.oTW, "onSceneEnd status failed");
            AppMethodBeat.o(21696);
        } else if (!this.authId.equals(this.oPi.ID)) {
            Log.e("MicroMsg.BackupAuthScene", "onSceneEnd not the same id");
            q(4, -1, "onSceneEnd not the same id");
            AppMethodBeat.o(21696);
        } else {
            String str = new String(l.d(this.oPi.oTm.zy, this.oPl));
            if (str.length() != this.oPk.length()) {
                equals = false;
            } else {
                equals = str.equals(this.oPk);
            }
            Log.i("MicroMsg.BackupAuthScene", "onSceneEnd check ok result[%b]", Boolean.valueOf(equals));
            if (!equals) {
                Log.e("MicroMsg.BackupAuthScene", "onSceneEnd check ok failed");
                q(4, -3, "onSceneEnd check ok failed");
                AppMethodBeat.o(21696);
                return;
            }
            q(0, 0, "onSceneEnd auth success");
            if (this.oPj != 22 || this.oPi.Version >= c.oIM) {
                this.oPh.oTm = new b(l.e(this.oPk.getBytes(), this.oPl));
                this.oPh.oUu = 1;
                this.oPh.ID = this.authId;
                try {
                    Log.i("MicroMsg.BackupAuthScene", "directSendAuthOk");
                    b.D(this.oPh.toByteArray(), getType(), i2);
                    AppMethodBeat.o(21696);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.BackupAuthScene", e2, "directSendAuthOk req to bur err.", new Object[0]);
                    AppMethodBeat.o(21696);
                }
            } else {
                AppMethodBeat.o(21696);
            }
        }
    }

    public final void A(boolean z, boolean z2) {
        if (z) {
            this.oPh.oUw |= c.oIQ;
        }
        this.oPh.oUw |= c.oIR;
        this.oPh.oUw |= c.oIS;
        if (z2) {
            this.oPh.oUw |= c.oIT;
        }
    }
}
