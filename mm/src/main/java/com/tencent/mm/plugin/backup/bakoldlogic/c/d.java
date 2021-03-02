package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.j;
import com.tencent.mm.hardcoder.g;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.i.ad;
import com.tencent.mm.plugin.backup.i.ae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class d extends b {
    private static int progress;
    private int iKP;
    public String id;
    private byte[] key;
    private j oSq = null;
    private ad oSs = new ad();
    private ae oSt = new ae();
    private String oSu;
    private int offset = 0;
    private int start = 0;

    public d(String str, String str2, int i2, int i3, j jVar, byte[] bArr) {
        AppMethodBeat.i(21944);
        if (i2 == 1) {
            this.oSu = str + "backupItem/" + a.agK(str2);
        } else {
            this.oSu = str + "backupMeida/" + a.agK(str2);
        }
        this.id = str2;
        this.oSs.oUz = str2;
        this.oSs.oUA = i2;
        this.iKP = i3;
        Log.i("MicroMsg.BakSceneRestoreData", "BakSceneRestoreData init, %s, type:%d, totalLen:%d", this.oSs.oUz, Integer.valueOf(this.oSs.oUA), Integer.valueOf(this.iKP));
        this.oSq = jVar;
        this.key = bArr;
        AppMethodBeat.o(21944);
    }

    @Override // com.tencent.mm.plugin.backup.g.b
    public final boolean cgA() {
        int i2;
        long j2 = g.ACTION_MINI_PROGRAM_LAUNCH;
        AppMethodBeat.i(21945);
        Log.i("MicroMsg.BakSceneRestoreData", "doSecne");
        int i3 = this.iKP;
        if (this.oSs.oUA == 2) {
            if (((long) (this.iKP - this.offset)) <= g.ACTION_MINI_PROGRAM_LAUNCH) {
                j2 = (long) (this.iKP - this.offset);
            }
            i2 = (int) j2;
        } else {
            i2 = i3;
        }
        this.start = this.offset;
        this.offset = i2 + this.start;
        this.oSs.oUC = this.start;
        this.oSs.oUD = this.offset;
        this.oSs.oUF = progress;
        boolean cgA = super.cgA();
        AppMethodBeat.o(21945);
        return cgA;
    }

    public static void setProgress(int i2) {
        AppMethodBeat.i(21946);
        Log.i("MicroMsg.BakSceneRestoreData", "setProgress %d", Integer.valueOf(i2));
        progress = i2;
        AppMethodBeat.o(21946);
    }

    @Override // com.tencent.mm.plugin.backup.g.b
    public final com.tencent.mm.bw.a cgq() {
        return this.oSt;
    }

    @Override // com.tencent.mm.plugin.backup.g.b
    public final com.tencent.mm.bw.a cgr() {
        return this.oSs;
    }

    @Override // com.tencent.mm.plugin.backup.g.b
    public final void Bm(int i2) {
        byte[] bArr;
        AppMethodBeat.i(21947);
        Log.i("MicroMsg.BakSceneRestoreData", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", this.oSt.oUz, Integer.valueOf(this.oSt.oUA), Integer.valueOf(this.oSt.oUC), Integer.valueOf(this.oSt.oUD), Integer.valueOf(this.oSt.oTW));
        if (this.oSt.oTW != 0 && this.oSt.oTW != 10) {
            q(4, this.oSt.oTW, "error");
            AppMethodBeat.o(21947);
        } else if (this.oSt.oUC == this.start && this.oSt.oUD == this.offset) {
            this.oSq.a(this.oSs.oUD - this.oSs.oUC, this.iKP, this);
            byte[] bArr2 = this.oSt.oTm.zy;
            if (this.key != null) {
                bArr = AesEcb.aesCryptEcb(bArr2, this.key, false, this.offset == this.iKP);
            } else {
                bArr = bArr2;
            }
            String str = this.oSu;
            String str2 = this.id;
            o oVar = new o(str + str2);
            long length = oVar.exists() ? oVar.length() : 0;
            s.e(str + str2, bArr, bArr.length);
            o oVar2 = new o(str + str2);
            if (length == (oVar2.exists() ? oVar2.length() : 0)) {
                Log.e("MicroMsg.BakSceneRestoreData", "append failed and try again:%s", str + str2);
                s.e(str + str2, bArr, bArr.length);
            }
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(bArr == null ? 0 : bArr.length);
            Log.i("MicroMsg.BakSceneRestoreData", "onSceneEnd appendbuf len:%d", objArr);
            if (this.offset == this.iKP) {
                Log.i("MicroMsg.BakSceneRestoreData", "recover cmoplete:%s  %d", this.id, Integer.valueOf(this.iKP));
                q(0, 0, "success");
                AppMethodBeat.o(21947);
                return;
            }
            cgA();
            AppMethodBeat.o(21947);
        } else {
            Log.e("MicroMsg.BakSceneRestoreData", "err local:%d, %d;   server:%d,%d", Integer.valueOf(this.start), Integer.valueOf(this.offset), Integer.valueOf(this.oSt.oUC), Integer.valueOf(this.oSt.oUD));
            q(3, -1, "error");
            AppMethodBeat.o(21947);
        }
    }

    @Override // com.tencent.mm.plugin.backup.g.b, com.tencent.mm.ak.q
    public final int getType() {
        return 7;
    }
}
