package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.l;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.i.v;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a extends b {
    final byte[] key;
    final int oIY;
    private v oPh = new v();
    private w oPi = new w();
    final String oSl;
    final String oSm;
    private boolean oSn = false;

    public a(String str, String str2, byte[] bArr, String str3) {
        AppMethodBeat.i(21936);
        Log.i("MicroMsg.BakOldAuthScene", "summerbak init id:%s,  hello:%s, ok:%s, stack[%s]", str3, str, str2, Util.getStack());
        this.oPh.oTm = new com.tencent.mm.bw.b(l.e(str.getBytes(), bArr));
        this.oPh.oUu = 0;
        this.oPh.ID = str3;
        this.oPh.Version = 0;
        this.oSl = str2;
        this.oSm = str3;
        this.key = bArr;
        this.oIY = -1;
        AppMethodBeat.o(21936);
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
        AppMethodBeat.i(21937);
        if (this.oPi.oTW != 0) {
            Log.e("MicroMsg.BakOldAuthScene", "errType %d", Integer.valueOf(this.oPi.oTW));
            q(4, this.oPi.oTW, "not not success");
            AppMethodBeat.o(21937);
        } else if (this.oSm.equals(this.oPi.ID)) {
            String str = new String(l.d(this.oPi.oTm.zy, this.key));
            if (str.length() != this.oSl.length()) {
                equals = false;
            } else {
                equals = str.equals(this.oSl);
            }
            this.oSn = equals;
            Log.i("MicroMsg.BakOldAuthScene", "check ok result:%b", Boolean.valueOf(this.oSn));
            if (this.oSn) {
                q(0, 0, "auth ok");
                this.oPh.oTm = new com.tencent.mm.bw.b(l.e(this.oSl.getBytes(), this.key));
                this.oPh.oUu = 1;
                this.oPh.ID = this.oSm;
                try {
                    Log.i("MicroMsg.BakOldAuthScene", "directSendAuthOk");
                    b.D(this.oPh.toByteArray(), getType(), i2);
                    AppMethodBeat.o(21937);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.BakOldAuthScene", e2, "directSendAuthOk req to bur err.", new Object[0]);
                    AppMethodBeat.o(21937);
                }
            } else {
                Log.e("MicroMsg.BakOldAuthScene", "check ok failed");
                q(4, 1, "not ok packet");
                AppMethodBeat.o(21937);
            }
        } else {
            Log.e("MicroMsg.BakOldAuthScene", "not the same id");
            q(4, -1, "not the same id");
            AppMethodBeat.o(21937);
        }
    }
}
