package com.tencent.mm.plugin.subapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class c {
    private RandomAccessFile file = null;
    private String fileName = "";

    public static class a {
        public byte[] buf = null;
        public int dAc = 0;
        public int jsR = 0;
        public int ret = 0;
    }

    public c(String str) {
        this.fileName = str;
    }

    public static int Qy(String str) {
        AppMethodBeat.i(28935);
        Assert.assertTrue(str.length() >= 0);
        o oVar = new o(str);
        if (!oVar.exists()) {
            AppMethodBeat.o(28935);
            return 0;
        }
        int length = (int) oVar.length();
        if (length <= 0) {
            AppMethodBeat.o(28935);
            return 0;
        }
        AppMethodBeat.o(28935);
        return length;
    }

    public final void bhP() {
        AppMethodBeat.i(28936);
        if (this.file != null) {
            try {
                this.file.close();
                this.file = null;
                Log.d("MicroMsg.SpxFileOperator", "Close :" + this.fileName);
                AppMethodBeat.o(28936);
                return;
            } catch (IOException e2) {
            }
        }
        AppMethodBeat.o(28936);
    }

    private boolean ftf() {
        boolean z;
        AppMethodBeat.i(169765);
        Assert.assertTrue(this.fileName.length() >= 0);
        if (this.file == null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        Log.d("MicroMsg.SpxFileOperator", "Open file:" + this.file + " forWrite:false");
        try {
            this.file = s.dB(this.fileName, false);
            AppMethodBeat.o(169765);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.SpxFileOperator", "ERR: OpenFile[" + this.fileName + "] failed:[" + e2.getMessage() + "]");
            this.file = null;
            AppMethodBeat.o(169765);
            return false;
        }
    }

    public final a abk(int i2) {
        AppMethodBeat.i(28938);
        a aVar = new a();
        if (i2 < 0) {
            aVar.ret = -3;
            AppMethodBeat.o(28938);
        } else if (this.file != null || ftf()) {
            aVar.buf = new byte[6000];
            try {
                long length = this.file.length();
                this.file.seek((long) i2);
                int read = this.file.read(aVar.buf, 0, 6000);
                Log.d("MicroMsg.SpxFileOperator", "DBG: ReadFile[" + this.fileName + "] readOffset:" + i2 + " readRet:" + read + " fileNow:" + this.file.getFilePointer() + " fileSize:" + length);
                if (read < 0) {
                    read = 0;
                }
                aVar.dAc = read;
                aVar.jsR = read + i2;
                aVar.ret = 0;
                AppMethodBeat.o(28938);
            } catch (Exception e2) {
                Log.e("MicroMsg.SpxFileOperator", "ERR: ReadFile[" + this.fileName + "] Offset:" + i2 + "  failed:[" + e2.getMessage() + "] ");
                bhP();
                aVar.ret = -1;
                AppMethodBeat.o(28938);
            }
        } else {
            aVar.ret = -2;
            AppMethodBeat.o(28938);
        }
        return aVar;
    }
}
