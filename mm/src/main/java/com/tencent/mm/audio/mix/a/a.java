package com.tencent.mm.audio.mix.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.i.b;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class a {
    private String appId;
    private String fileName;
    private String mUrl;
    private RandomAccessFile randomAccessFile = null;

    public a(String str, String str2) {
        AppMethodBeat.i(136700);
        this.appId = str;
        this.mUrl = str2;
        this.fileName = com.tencent.mm.audio.mix.i.a.S(str, this.mUrl);
        b.i("MicroMsg.Mix.AudioPcmCacheFile", "AudioPcmCacheFile mUrl:%s, fileName:%s,", this.mUrl, this.fileName);
        AppMethodBeat.o(136700);
    }

    public final boolean open() {
        AppMethodBeat.i(136701);
        b.i("MicroMsg.Mix.AudioPcmCacheFile", WeChatBrands.Business.GROUP_OPEN);
        try {
            o oVar = new o(this.fileName);
            if (!oVar.exists()) {
                b.i("MicroMsg.Mix.AudioPcmCacheFile", "create file:%b", Boolean.valueOf(oVar.createNewFile()));
            } else {
                oVar.delete();
            }
            this.randomAccessFile = s.dB(aa.z(oVar.mUri), true);
            b.e("MicroMsg.Mix.AudioPcmCacheFile", "create RandomAccessFile file  %s  success", this.fileName);
            AppMethodBeat.o(136701);
            return true;
        } catch (FileNotFoundException e2) {
            b.e("MicroMsg.Mix.AudioPcmCacheFile", "file not found", e2);
            b.e("MicroMsg.Mix.AudioPcmCacheFile", "create RandomAccessFile file  %s  success", this.fileName);
            AppMethodBeat.o(136701);
            return false;
        } catch (IOException e3) {
            b.e("MicroMsg.Mix.AudioPcmCacheFile", "io ", e3);
            b.e("MicroMsg.Mix.AudioPcmCacheFile", "create RandomAccessFile file  %s  success", this.fileName);
            AppMethodBeat.o(136701);
            return false;
        } catch (Throwable th) {
            b.e("MicroMsg.Mix.AudioPcmCacheFile", "create RandomAccessFile file  %s  success", this.fileName);
            AppMethodBeat.o(136701);
            throw th;
        }
    }

    public final synchronized void close() {
        AppMethodBeat.i(136702);
        b.i("MicroMsg.Mix.AudioPcmCacheFile", "close");
        if (this.randomAccessFile != null) {
            try {
                this.randomAccessFile.close();
                AppMethodBeat.o(136702);
            } catch (IOException e2) {
                b.e("MicroMsg.Mix.AudioPcmCacheFile", "close RandomAccessFile error ", e2.getMessage());
            }
        }
        AppMethodBeat.o(136702);
    }

    public final synchronized int read(byte[] bArr, long j2, int i2) {
        int i3 = -1;
        synchronized (this) {
            AppMethodBeat.i(136703);
            if (i2 == 0) {
                b.e("MicroMsg.Mix.AudioPcmCacheFile", "read error, length == 0");
                AppMethodBeat.o(136703);
            } else if (this.randomAccessFile == null) {
                b.e("MicroMsg.Mix.AudioPcmCacheFile", "read error, randomAccessFile is null");
                AppMethodBeat.o(136703);
            } else {
                try {
                    this.randomAccessFile.seek(j2);
                    i3 = this.randomAccessFile.read(bArr, 0, i2);
                    AppMethodBeat.o(136703);
                } catch (IOException e2) {
                    b.e("MicroMsg.Mix.AudioPcmCacheFile", String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(getLength()), Integer.valueOf(bArr.length)));
                    AppMethodBeat.o(136703);
                }
            }
        }
        return i3;
    }

    public final synchronized boolean b(byte[] bArr, long j2, int i2) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(136704);
            if (i2 == 0) {
                b.e("MicroMsg.Mix.AudioPcmCacheFile", "write error, length == 0");
                AppMethodBeat.o(136704);
            } else if (this.randomAccessFile == null) {
                b.e("MicroMsg.Mix.AudioPcmCacheFile", "write error, randomAccessFile is null");
                AppMethodBeat.o(136704);
            } else {
                try {
                    this.randomAccessFile.seek(j2);
                    this.randomAccessFile.write(bArr, 0, i2);
                    AppMethodBeat.o(136704);
                    z = true;
                } catch (IOException e2) {
                    b.e("MicroMsg.Mix.AudioPcmCacheFile", String.format("Error writing %d bytes to from buffer with size %d", Integer.valueOf(i2), Integer.valueOf(bArr.length)));
                    AppMethodBeat.o(136704);
                }
            }
        }
        return z;
    }

    public final synchronized int getLength() {
        int i2 = -1;
        synchronized (this) {
            AppMethodBeat.i(136705);
            if (this.randomAccessFile == null) {
                b.e("MicroMsg.Mix.AudioPcmCacheFile", "getLength error, randomAccessFile is null");
                AppMethodBeat.o(136705);
            } else {
                try {
                    i2 = (int) this.randomAccessFile.length();
                    AppMethodBeat.o(136705);
                } catch (IOException e2) {
                    b.e("MicroMsg.Mix.AudioPcmCacheFile", "Error get length of file , err %s", e2.getMessage());
                    AppMethodBeat.o(136705);
                }
            }
        }
        return i2;
    }

    public final synchronized void setLength(long j2) {
        AppMethodBeat.i(136706);
        if (this.randomAccessFile == null) {
            b.e("MicroMsg.Mix.AudioPcmCacheFile", "setLength error, randomAccessFile is null");
            AppMethodBeat.o(136706);
        } else if (j2 <= 0) {
            b.e("MicroMsg.Mix.AudioPcmCacheFile", "setLength error, length is ".concat(String.valueOf(j2)));
            AppMethodBeat.o(136706);
        } else {
            b.e("MicroMsg.Mix.AudioPcmCacheFile", "set file length %s ", String.valueOf(j2));
            try {
                this.randomAccessFile.setLength(j2);
                AppMethodBeat.o(136706);
            } catch (IOException e2) {
                b.e("MicroMsg.Mix.AudioPcmCacheFile", "Error set length of file, err %s", e2.getMessage());
                AppMethodBeat.o(136706);
            }
        }
    }

    public final void Yq() {
        AppMethodBeat.i(136707);
        b.i("MicroMsg.Mix.AudioPcmCacheFile", "deleteFile");
        String str = this.fileName;
        b.i("MicroMsg.Mix.AudioPcmCacheFile", "deleteFile, fileName:".concat(String.valueOf(str)));
        o oVar = new o(str);
        if (oVar.exists()) {
            b.i("MicroMsg.Mix.AudioPcmCacheFile", "delete the piece File");
            oVar.delete();
            AppMethodBeat.o(136707);
            return;
        }
        b.e("MicroMsg.Mix.AudioPcmCacheFile", "file not exist, delete piece File fail");
        AppMethodBeat.o(136707);
    }
}
