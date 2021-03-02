package com.tencent.mm.plugin.appbrand.performance;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class e implements Closeable {
    private final int Mq;
    private volatile RandomAccessFile nwS;
    private volatile RandomAccessFile nwT;
    private boolean nwU;
    private long nwV;
    private long nwW;
    private long nwX;

    public e(int i2) {
        this.Mq = i2;
    }

    public final double bSU() {
        long safeParseLong;
        AppMethodBeat.i(147594);
        if (this.nwU) {
            AppMethodBeat.o(147594);
            return 0.0d;
        }
        double d2 = 0.0d;
        try {
            if (this.nwT == null) {
                this.nwT = s.dB("/proc/" + this.Mq + "/stat", false);
            }
            this.nwT.seek(0);
            String readLine = this.nwT.readLine();
            if (Util.isNullOrNil(readLine)) {
                AppMethodBeat.o(147594);
                return 0.0d;
            }
            String[] split = readLine.split(" ");
            if (split.length < 17) {
                AppMethodBeat.o(147594);
                return 0.0d;
            }
            if (this.nwS == null) {
                this.nwS = s.dB("/proc/stat", false);
            }
            this.nwS.seek(0);
            String readLine2 = this.nwS.readLine();
            if (Util.isNullOrNil(readLine2)) {
                safeParseLong = 0;
            } else {
                String[] split2 = readLine2.split(" ");
                if (split2.length < 9) {
                    safeParseLong = 0;
                } else {
                    long safeParseLong2 = Util.safeParseLong(split2[2]);
                    long safeParseLong3 = Util.safeParseLong(split2[3]);
                    long safeParseLong4 = Util.safeParseLong(split2[4]);
                    long safeParseLong5 = Util.safeParseLong(split2[5]);
                    long safeParseLong6 = Util.safeParseLong(split2[6]);
                    long safeParseLong7 = Util.safeParseLong(split2[7]);
                    safeParseLong = Util.safeParseLong(split2[9]) + safeParseLong2 + safeParseLong3 + safeParseLong4 + safeParseLong5 + safeParseLong6 + safeParseLong7 + Util.safeParseLong(split2[8]);
                }
            }
            long safeParseLong8 = Util.safeParseLong(split[13]);
            long safeParseLong9 = Util.safeParseLong(split[14]);
            if (this.nwV != 0) {
                d2 = Math.max(0.0d, ((double) ((safeParseLong9 - this.nwX) * 100)) / ((double) (safeParseLong - this.nwV))) + Math.max(0.0d, ((double) ((safeParseLong8 - this.nwW) * 100)) / ((double) (safeParseLong - this.nwV)));
            }
            this.nwV = safeParseLong;
            this.nwW = safeParseLong8;
            this.nwX = safeParseLong9;
            AppMethodBeat.o(147594);
            return d2;
        } catch (Exception e2) {
            Log.e(" MicroMsg.CpuSampler", "read pid stat file error: ".concat(String.valueOf(e2)));
            this.nwU = true;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(147595);
        try {
            if (this.nwT != null) {
                this.nwT.close();
            }
        } catch (IOException e2) {
        }
        try {
            if (this.nwS != null) {
                this.nwS.close();
            }
            AppMethodBeat.o(147595);
        } catch (IOException e3) {
            AppMethodBeat.o(147595);
        }
    }
}
