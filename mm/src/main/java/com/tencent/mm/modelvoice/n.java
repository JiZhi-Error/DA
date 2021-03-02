package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class n implements b {
    private RandomAccessFile file = null;
    private String fileName = "";

    public n(String str) {
        this.fileName = str;
    }

    @Override // com.tencent.mm.modelvoice.b
    public final void bhP() {
        AppMethodBeat.i(130087);
        if (this.file != null) {
            try {
                this.file.close();
                this.file = null;
                Log.d("MicroMsg.SpxFileOperator", "Close :" + this.fileName);
                AppMethodBeat.o(130087);
                return;
            } catch (IOException e2) {
            }
        }
        AppMethodBeat.o(130087);
    }

    private boolean fS(boolean z) {
        boolean z2;
        AppMethodBeat.i(130088);
        Assert.assertTrue(this.fileName.length() >= 0);
        if (this.file == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        Log.d("MicroMsg.SpxFileOperator", "Open file:" + this.file + " forWrite:" + z);
        try {
            this.file = s.dB(this.fileName, z);
            AppMethodBeat.o(130088);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.SpxFileOperator", "ERR: OpenFile[" + this.fileName + "] failed:[" + e2.getMessage() + "]");
            this.file = null;
            AppMethodBeat.o(130088);
            return false;
        }
    }

    @Override // com.tencent.mm.modelvoice.b
    public final g dB(int i2, int i3) {
        AppMethodBeat.i(130089);
        g gVar = new g();
        if (i2 < 0 || i3 <= 0) {
            gVar.ret = -3;
            AppMethodBeat.o(130089);
        } else if (this.file != null || fS(false)) {
            gVar.buf = new byte[i3];
            try {
                long length = this.file.length();
                this.file.seek((long) i2);
                int read = this.file.read(gVar.buf, 0, i3);
                Log.d("MicroMsg.SpxFileOperator", "DBG: ReadFile[" + this.fileName + "] readOffset:" + i2 + " readRet:" + read + " fileNow:" + this.file.getFilePointer() + " fileSize:" + length);
                if (read < 0) {
                    read = 0;
                }
                gVar.dAc = read;
                gVar.jsR = read + i2;
                gVar.ret = 0;
                AppMethodBeat.o(130089);
            } catch (Exception e2) {
                Log.e("MicroMsg.SpxFileOperator", "ERR: ReadFile[" + this.fileName + "] Offset:" + i2 + "  failed:[" + e2.getMessage() + "] ");
                bhP();
                gVar.ret = -1;
                AppMethodBeat.o(130089);
            }
        } else {
            gVar.ret = -2;
            AppMethodBeat.o(130089);
        }
        return gVar;
    }

    @Override // com.tencent.mm.modelvoice.b
    public final int write(byte[] bArr, int i2, int i3) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(130090);
        Assert.assertTrue(bArr.length > 0 && i2 > 0);
        if (this.file != null || fS(true)) {
            try {
                this.file.seek((long) i3);
                this.file.write(bArr, 0, i2);
                int i4 = i3 + i2;
                if (((int) this.file.getFilePointer()) == i4) {
                    z = true;
                } else {
                    z = false;
                }
                Assert.assertTrue(z);
                if (i4 < 0) {
                    z2 = false;
                }
                Assert.assertTrue(z2);
                AppMethodBeat.o(130090);
                return i4;
            } catch (Exception e2) {
                Log.e("MicroMsg.SpxFileOperator", "ERR: WriteFile[" + this.fileName + "] Offset:" + i3 + " failed:[" + e2.getMessage() + "]");
                bhP();
                AppMethodBeat.o(130090);
                return -3;
            }
        } else {
            AppMethodBeat.o(130090);
            return -1;
        }
    }

    @Override // com.tencent.mm.modelvoice.b
    public final int getFormat() {
        return 1;
    }
}
