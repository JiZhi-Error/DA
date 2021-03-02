package com.tencent.mm.plugin.music.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.h.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class h {
    public String fileName;
    private String mUrl;
    public RandomAccessFile randomAccessFile = null;

    public h(String str) {
        AppMethodBeat.i(137195);
        this.mUrl = str;
        this.fileName = b.aIe(this.mUrl);
        Log.i("MicroMsg.Music.PieceFileCache", "PieceFileCache mUrl:%s, fileName:%s,", this.mUrl, this.fileName);
        AppMethodBeat.o(137195);
    }

    public final synchronized void close() {
        AppMethodBeat.i(137196);
        Logger.i("MicroMsg.Music.PieceFileCache", "close");
        if (this.randomAccessFile != null) {
            try {
                this.randomAccessFile.close();
                AppMethodBeat.o(137196);
            } catch (IOException e2) {
                Logger.e("MicroMsg.Music.PieceFileCache", "close RandomAccessFile error ", e2.getMessage());
            }
        }
        AppMethodBeat.o(137196);
    }

    public final synchronized int read(byte[] bArr, long j2, int i2) {
        int i3 = -1;
        synchronized (this) {
            AppMethodBeat.i(137197);
            if (i2 == 0) {
                Logger.e("MicroMsg.Music.PieceFileCache", "read error, length == 0");
                AppMethodBeat.o(137197);
            } else if (this.randomAccessFile == null) {
                Logger.e("MicroMsg.Music.PieceFileCache", "read error, randomAccessFile is null");
                AppMethodBeat.o(137197);
            } else {
                try {
                    this.randomAccessFile.seek(j2);
                    i3 = this.randomAccessFile.read(bArr, 0, i2);
                    AppMethodBeat.o(137197);
                } catch (IOException e2) {
                    Logger.e("MicroMsg.Music.PieceFileCache", String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(getLength()), Integer.valueOf(bArr.length)));
                    AppMethodBeat.o(137197);
                }
            }
        }
        return i3;
    }

    public final synchronized boolean b(byte[] bArr, long j2, int i2) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(137198);
            if (i2 == 0) {
                Logger.e("MicroMsg.Music.PieceFileCache", "write error, length == 0");
                AppMethodBeat.o(137198);
            } else if (this.randomAccessFile == null) {
                Logger.e("MicroMsg.Music.PieceFileCache", "write error, randomAccessFile is null");
                AppMethodBeat.o(137198);
            } else {
                try {
                    this.randomAccessFile.seek(j2);
                    this.randomAccessFile.write(bArr, 0, i2);
                    AppMethodBeat.o(137198);
                    z = true;
                } catch (IOException e2) {
                    Logger.e("MicroMsg.Music.PieceFileCache", String.format("Error writing %d bytes to from buffer with size %d", Integer.valueOf(i2), Integer.valueOf(bArr.length)));
                    AppMethodBeat.o(137198);
                }
            }
        }
        return z;
    }

    public final synchronized int getLength() {
        int i2 = -1;
        synchronized (this) {
            AppMethodBeat.i(137199);
            if (this.randomAccessFile == null) {
                Logger.e("MicroMsg.Music.PieceFileCache", "getLength error, randomAccessFile is null");
                AppMethodBeat.o(137199);
            } else {
                try {
                    i2 = (int) this.randomAccessFile.length();
                    AppMethodBeat.o(137199);
                } catch (IOException e2) {
                    Logger.e("MicroMsg.Music.PieceFileCache", "Error get length of file , err %s", e2.getMessage());
                    AppMethodBeat.o(137199);
                }
            }
        }
        return i2;
    }

    public final synchronized void setLength(long j2) {
        AppMethodBeat.i(137200);
        if (this.randomAccessFile == null) {
            Logger.e("MicroMsg.Music.PieceFileCache", "setLength error, randomAccessFile is null");
            AppMethodBeat.o(137200);
        } else if (j2 <= 0) {
            Logger.e("MicroMsg.Music.PieceFileCache", "setLength error, length is ".concat(String.valueOf(j2)));
            AppMethodBeat.o(137200);
        } else {
            Logger.e("MicroMsg.Music.PieceFileCache", "set file length %s ", String.valueOf(j2));
            try {
                this.randomAccessFile.setLength(j2);
                AppMethodBeat.o(137200);
            } catch (IOException e2) {
                Logger.e("MicroMsg.Music.PieceFileCache", "Error set length of file, err %s", e2.getMessage());
                AppMethodBeat.o(137200);
            }
        }
    }

    public final synchronized long etL() {
        long j2;
        AppMethodBeat.i(137201);
        o oVar = new o(this.fileName);
        if (oVar.exists()) {
            j2 = oVar.length();
            AppMethodBeat.o(137201);
        } else {
            j2 = -1;
            AppMethodBeat.o(137201);
        }
        return j2;
    }

    public static long hv(String str) {
        AppMethodBeat.i(137202);
        o oVar = new o(b.aIe(str));
        if (oVar.exists()) {
            long length = oVar.length();
            AppMethodBeat.o(137202);
            return length;
        }
        AppMethodBeat.o(137202);
        return -1;
    }

    public static void aHD(String str) {
        AppMethodBeat.i(137203);
        Logger.i("MicroMsg.Music.PieceFileCache", "deleteFile, fileName:".concat(String.valueOf(str)));
        o oVar = new o(str);
        if (oVar.exists()) {
            Logger.i("MicroMsg.Music.PieceFileCache", "delete the piece File");
            oVar.delete();
            AppMethodBeat.o(137203);
            return;
        }
        Logger.e("MicroMsg.Music.PieceFileCache", "file not exist, delete piece File fail");
        AppMethodBeat.o(137203);
    }

    public static boolean aHG(String str) {
        AppMethodBeat.i(137204);
        Logger.i("MicroMsg.Music.PieceFileCache", "existFileByUrl");
        String aIe = b.aIe(str);
        Logger.i("MicroMsg.Music.PieceFileCache", "existFile, fileName:".concat(String.valueOf(aIe)));
        boolean exists = new o(aIe).exists();
        Log.i("MicroMsg.Music.PieceFileCache", "the piece File exist:%b", Boolean.valueOf(exists));
        AppMethodBeat.o(137204);
        return exists;
    }
}
