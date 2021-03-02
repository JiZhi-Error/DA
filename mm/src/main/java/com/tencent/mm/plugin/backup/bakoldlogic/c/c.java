package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.j;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.plugin.backup.i.y;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.protocal.protobuf.it;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.LinkedList;

public final class c extends b {
    private static int progress;
    private String filePath;
    private int iKP = 0;
    private byte[] key;
    private y oPA = new y();
    public x oPz = new x();
    private j oSq = null;
    private byte[] oSr;
    private int offset = 0;
    private int start = 0;
    private int type;

    public c(String str, int i2, LinkedList<is> linkedList, String str2, j jVar, byte[] bArr) {
        AppMethodBeat.i(21940);
        this.oPz.oUz = str;
        this.oPz.oUA = i2;
        this.type = i2;
        if (i2 == 1) {
            it itVar = new it();
            itVar.oTA = linkedList;
            itVar.oTz = linkedList.size();
            try {
                this.oSr = itVar.toByteArray();
                this.iKP = this.oSr.length;
            } catch (IOException e2) {
                Log.e("MicroMsg.BakSceneDataPush", "backList to buffer error");
                Log.printErrStackTrace("MicroMsg.BakSceneDataPush", e2, "", new Object[0]);
            }
        } else {
            this.filePath = str2;
            this.iKP = (int) s.boW(str2);
        }
        this.oPz.oUB = (16 - (this.iKP % 16)) + this.iKP;
        Log.i("MicroMsg.BakSceneDataPush", "BakSceneDataPush init:%s  type:%d, localTotalLen:%d, reqDataSize:%d", this.oPz.oUz, Integer.valueOf(this.oPz.oUA), Integer.valueOf(this.iKP), Integer.valueOf(this.oPz.oUB));
        this.oSq = jVar;
        this.key = bArr;
        AppMethodBeat.o(21940);
    }

    public static void setProgress(int i2) {
        AppMethodBeat.i(21941);
        Log.i("MicroMsg.BakSceneDataPush", "setProgress %d", Integer.valueOf(i2));
        progress = i2;
        AppMethodBeat.o(21941);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0128  */
    @Override // com.tencent.mm.plugin.backup.g.b
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean cgA() {
        /*
        // Method dump skipped, instructions count: 330
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.bakoldlogic.c.c.cgA():boolean");
    }

    @Override // com.tencent.mm.plugin.backup.g.b
    public final a cgq() {
        return this.oPA;
    }

    @Override // com.tencent.mm.plugin.backup.g.b
    public final a cgr() {
        return this.oPz;
    }

    @Override // com.tencent.mm.plugin.backup.g.b
    public final void Bm(int i2) {
        AppMethodBeat.i(21943);
        Log.i("MicroMsg.BakSceneDataPush", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", this.oPA.oUz, Integer.valueOf(this.oPA.oUA), Integer.valueOf(this.oPA.oUC), Integer.valueOf(this.oPA.oUD), Integer.valueOf(this.oPA.oTW));
        if (this.oPA.oTW != 0) {
            Log.e("MicroMsg.BakSceneDataPush", "status:%d", Integer.valueOf(this.oPA.oTW));
            q(4, this.oPA.oTW, "error");
            AppMethodBeat.o(21943);
            return;
        }
        this.oSq.a(this.oPz.oUD - this.oPz.oUC, this.iKP, this);
        if (this.offset == this.iKP) {
            Log.i("MicroMsg.BakSceneDataPush", "back complete: %s,  %d", this.oPz.oUz, Integer.valueOf(this.iKP));
            q(0, 0, "success");
            AppMethodBeat.o(21943);
            return;
        }
        cgA();
        AppMethodBeat.o(21943);
    }

    @Override // com.tencent.mm.plugin.backup.g.b, com.tencent.mm.ak.q
    public final int getType() {
        return 5;
    }
}
