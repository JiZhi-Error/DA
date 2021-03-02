package com.tencent.mm.audio.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class b {
    private OutputStream dBk;
    private int dBl;
    public String mFilePath;

    public b(String str, int i2, int i3) {
        AppMethodBeat.i(130011);
        this.mFilePath = str;
        try {
            this.dBk = s.dw(str, false);
            ByteBuffer allocate = ByteBuffer.allocate(44);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(1179011410);
            allocate.putInt(0);
            allocate.putInt(1163280727);
            allocate.putInt(544501094);
            allocate.putInt(16);
            allocate.putShort(1);
            allocate.putShort((short) i2);
            allocate.putInt(i3);
            allocate.putInt(i3 * i2 * 2);
            allocate.putShort((short) (i2 * 2));
            allocate.putShort(16);
            allocate.putInt(1635017060);
            allocate.putInt(0);
            this.dBl = 44;
            this.dBk.write(allocate.array());
            AppMethodBeat.o(130011);
        } catch (IOException e2) {
            Log.e("MicroMsg.PcmWriter", "create file failed: " + e2.getMessage());
            AppMethodBeat.o(130011);
        }
    }

    public final boolean A(byte[] bArr, int i2) {
        AppMethodBeat.i(130012);
        if (this.dBk == null) {
            AppMethodBeat.o(130012);
            return false;
        }
        try {
            this.dBk.write(bArr, 0, i2);
            this.dBl += i2;
            AppMethodBeat.o(130012);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.PcmWriter", "write to file failed: " + e2.getMessage());
            AppMethodBeat.o(130012);
            return false;
        }
    }

    public final void closeFile() {
        AppMethodBeat.i(130013);
        try {
            this.dBk.close();
        } catch (IOException e2) {
            Log.e("MicroMsg.PcmWriter", "close file failed: " + e2.getMessage());
        }
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = s.dB(this.mFilePath, true);
            randomAccessFile.seek(4);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(this.dBl - 8);
            randomAccessFile.write(allocate.array());
            allocate.rewind();
            allocate.putInt(this.dBl - 42);
            randomAccessFile.seek(40);
            randomAccessFile.write(allocate.array());
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                    AppMethodBeat.o(130013);
                    return;
                } catch (IOException e3) {
                    Log.printErrStackTrace("MicroMsg.PcmWriter", e3, "", new Object[0]);
                    AppMethodBeat.o(130013);
                    return;
                }
            }
        } catch (FileNotFoundException e4) {
            Log.printErrStackTrace("MicroMsg.PcmWriter", e4, "", new Object[0]);
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                    AppMethodBeat.o(130013);
                    return;
                } catch (IOException e5) {
                    Log.printErrStackTrace("MicroMsg.PcmWriter", e5, "", new Object[0]);
                    AppMethodBeat.o(130013);
                    return;
                }
            }
        } catch (IOException e6) {
            Log.printErrStackTrace("MicroMsg.PcmWriter", e6, "", new Object[0]);
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                    AppMethodBeat.o(130013);
                    return;
                } catch (IOException e7) {
                    Log.printErrStackTrace("MicroMsg.PcmWriter", e7, "", new Object[0]);
                    AppMethodBeat.o(130013);
                    return;
                }
            }
        } catch (Throwable th) {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e8) {
                    Log.printErrStackTrace("MicroMsg.PcmWriter", e8, "", new Object[0]);
                }
            }
            AppMethodBeat.o(130013);
            throw th;
        }
        AppMethodBeat.o(130013);
    }
}
