package com.tencent.mm.compatible.deviceinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public final class p {
    private RandomAccessFile gHW;
    private RandomAccessFile gHX;
    private a gHY;
    private ArrayList<a> gHZ;
    private long pid = 0;

    public p() {
    }

    public p(long j2) {
        this.pid = j2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void aow() {
        /*
        // Method dump skipped, instructions count: 595
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.compatible.deviceinfo.p.aow():void");
    }

    public final String toString() {
        AppMethodBeat.i(155684);
        update();
        StringBuffer stringBuffer = new StringBuffer();
        if (this.gHY != null) {
            stringBuffer.append("Cpu Total : ");
            stringBuffer.append(this.gHY.KN);
            stringBuffer.append("%");
            if (this.pid > 0) {
                stringBuffer.append("pid(");
                stringBuffer.append(this.pid + ") :");
                stringBuffer.append(this.gHY.gId);
                stringBuffer.append("%");
            }
        }
        if (this.gHZ != null) {
            for (int i2 = 0; i2 < this.gHZ.size(); i2++) {
                stringBuffer.append(" Cpu Core(" + i2 + ") : ");
                stringBuffer.append(this.gHZ.get(i2).KN);
                stringBuffer.append("%");
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(155684);
        return stringBuffer2;
    }

    public class a {
        int KN;
        long gIa;
        long gIb;
        long gIc;
        int gId;
        long mLastIdle;

        public a() {
            this.KN = 0;
            this.gIa = 0;
            this.mLastIdle = 0;
            this.gIb = 0;
            this.gIc = 0;
            this.gId = 0;
        }

        public a(long j2) {
            this.gIb = j2;
        }

        public final void i(String[] strArr) {
            AppMethodBeat.i(155678);
            long parseLong = Long.parseLong(strArr[4], 10);
            long j2 = 0;
            boolean z = true;
            for (String str : strArr) {
                if (z) {
                    z = false;
                } else {
                    j2 += Long.parseLong(str, 10);
                }
            }
            long j3 = j2 - this.gIa;
            this.KN = (int) ((((float) (j3 - (parseLong - this.mLastIdle))) / ((float) j3)) * 100.0f);
            this.gIa = j2;
            this.mLastIdle = parseLong;
            Log.i(" MicroMsg.CpuUsage", "CpuUsageInfo(" + hashCode() + ") CPU total=" + j2 + "; idle=" + parseLong + "; usage=" + this.KN);
            AppMethodBeat.o(155678);
        }
    }

    private void update() {
        AppMethodBeat.i(155679);
        try {
            this.gHW = s.dB("/proc/stat", false);
            if (this.pid > 0) {
                this.gHX = s.dB("/proc/" + this.pid + "/stat", false);
            }
            aow();
            if (this.gHW != null) {
                this.gHW.close();
            }
            if (this.gHX != null) {
                this.gHX.close();
            }
            AppMethodBeat.o(155679);
        } catch (Exception e2) {
            Log.printErrStackTrace(" MicroMsg.CpuUsage", e2, "update e:", new Object[0]);
            if (this.gHW != null) {
                try {
                    this.gHW.close();
                } catch (Exception e3) {
                }
                this.gHW = null;
            }
            if (this.gHX != null) {
                try {
                    this.gHX.close();
                } catch (Exception e4) {
                }
                this.gHX = null;
            }
            AppMethodBeat.o(155679);
        }
    }

    public final int aox() {
        AppMethodBeat.i(215251);
        update();
        int i2 = 0;
        if (this.gHY != null) {
            i2 = this.gHY.KN;
        }
        AppMethodBeat.o(215251);
        return i2;
    }
}
