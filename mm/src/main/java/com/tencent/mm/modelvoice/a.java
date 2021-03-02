package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class a implements b {
    private RandomAccessFile file = null;
    private String fileName = "";

    public a(String str) {
        this.fileName = str;
    }

    @Override // com.tencent.mm.modelvoice.b
    public final void bhP() {
        AppMethodBeat.i(130033);
        if (this.file != null) {
            try {
                this.file.close();
                this.file = null;
                Log.d("MicroMsg.AmrFileOperator", "Close :" + this.fileName);
                AppMethodBeat.o(130033);
                return;
            } catch (IOException e2) {
            }
        }
        AppMethodBeat.o(130033);
    }

    private boolean fS(boolean z) {
        boolean z2;
        AppMethodBeat.i(130034);
        Assert.assertTrue(this.fileName.length() >= 0);
        if (this.file == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        Log.d("MicroMsg.AmrFileOperator", "Open file:" + this.file + " forWrite:" + z);
        try {
            this.file = s.dB(this.fileName, z);
            AppMethodBeat.o(130034);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.AmrFileOperator", "ERR: OpenFile[" + this.fileName + "] failed:[" + e2.getMessage() + "]");
            this.file = null;
            AppMethodBeat.o(130034);
            return false;
        }
    }

    @Override // com.tencent.mm.modelvoice.b
    public final g dB(int i2, int i3) {
        AppMethodBeat.i(130035);
        g gVar = new g();
        if (i2 < 0 || i3 <= 0) {
            gVar.ret = -3;
            AppMethodBeat.o(130035);
        } else if (this.file != null || fS(false)) {
            int i4 = i2 + 6;
            gVar.buf = new byte[i3];
            try {
                long length = this.file.length();
                this.file.seek((long) i4);
                int read = this.file.read(gVar.buf, 0, i3);
                Log.d("MicroMsg.AmrFileOperator", "DBG: ReadFile[" + this.fileName + "] readOffset:" + i4 + " readRet:" + read + " fileNow:" + this.file.getFilePointer() + " fileSize:" + length);
                if (read < 0) {
                    read = 0;
                }
                gVar.dAc = read;
                gVar.jsR = (read + i4) - 6;
                gVar.ret = 0;
                AppMethodBeat.o(130035);
            } catch (Exception e2) {
                Log.e("MicroMsg.AmrFileOperator", "ERR: ReadFile[" + this.fileName + "] Offset:" + i4 + "  failed:[" + e2.getMessage() + "] ");
                bhP();
                gVar.ret = -1;
                AppMethodBeat.o(130035);
            }
        } else {
            gVar.ret = -2;
            AppMethodBeat.o(130035);
        }
        return gVar;
    }

    @Override // com.tencent.mm.modelvoice.b
    public final int write(byte[] bArr, int i2, int i3) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(130036);
        Assert.assertTrue(bArr.length > 0 && i2 > 0);
        if (this.file != null || fS(true)) {
            if (i3 == 0) {
                try {
                    this.file.write("#!AMR\n".getBytes(), 0, 6);
                } catch (Exception e2) {
                    Log.e("MicroMsg.AmrFileOperator", "ERR: WriteHeadToFile[" + this.fileName + "] failed:[" + e2.getMessage() + "]");
                    bhP();
                    AppMethodBeat.o(130036);
                    return -2;
                }
            }
            int i4 = i3 + 6;
            try {
                this.file.seek((long) i4);
                this.file.write(bArr, 0, i2);
                int i5 = i4 + i2;
                if (((int) this.file.getFilePointer()) == i5) {
                    z = true;
                } else {
                    z = false;
                }
                Assert.assertTrue(z);
                int i6 = i5 - 6;
                if (i6 < 0) {
                    z2 = false;
                }
                Assert.assertTrue(z2);
                AppMethodBeat.o(130036);
                return i6;
            } catch (Exception e3) {
                Log.e("MicroMsg.AmrFileOperator", "ERR: WriteFile[" + this.fileName + "] Offset:" + i4 + " failed:[" + e3.getMessage() + "]");
                bhP();
                AppMethodBeat.o(130036);
                return -3;
            }
        } else {
            AppMethodBeat.o(130036);
            return -1;
        }
    }

    @Override // com.tencent.mm.modelvoice.b
    public final int getFormat() {
        return 0;
    }
}
