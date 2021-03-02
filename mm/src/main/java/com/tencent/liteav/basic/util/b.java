package com.tencent.liteav.basic.util;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final long f450a = TimeUnit.SECONDS.toMillis(2);

    /* renamed from: b  reason: collision with root package name */
    private final long f451b = TXCTimeUtil.getClockTickInHz();

    /* renamed from: c  reason: collision with root package name */
    private final int f452c = Runtime.getRuntime().availableProcessors();

    /* renamed from: d  reason: collision with root package name */
    private RandomAccessFile f453d;

    /* renamed from: e  reason: collision with root package name */
    private RandomAccessFile f454e;

    /* renamed from: f  reason: collision with root package name */
    private long f455f = 0;

    /* renamed from: g  reason: collision with root package name */
    private float f456g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    private float f457h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    private long f458i = 0;

    /* renamed from: j  reason: collision with root package name */
    private long f459j = 0;
    private float k = 0.0f;

    static {
        AppMethodBeat.i(14738);
        AppMethodBeat.o(14738);
    }

    public b() {
        AppMethodBeat.i(14733);
        try {
            this.f453d = new RandomAccessFile(String.format(Locale.ENGLISH, "/proc/%d/stat", Integer.valueOf(Process.myPid())), "r");
        } catch (IOException e2) {
            TXCLog.e("CpuUsageMeasurer", "open /proc/[PID]/stat failed. " + e2.getMessage());
        }
        try {
            this.f454e = new RandomAccessFile("/proc/stat", "r");
            AppMethodBeat.o(14733);
        } catch (IOException e3) {
            AppMethodBeat.o(14733);
        }
    }

    public int[] a() {
        int[] iArr;
        AppMethodBeat.i(14734);
        synchronized (this) {
            try {
                if (TXCTimeUtil.getTimeTick() - this.f455f >= f450a) {
                    b();
                }
                iArr = new int[]{(int) (this.f457h * 10.0f), (int) (this.k * 10.0f)};
            } finally {
                AppMethodBeat.o(14734);
            }
        }
        return iArr;
    }

    private void b() {
        long j2;
        long j3;
        AppMethodBeat.i(14735);
        String[] a2 = a(this.f453d);
        if (a2 == null || a2.length < 52) {
            AppMethodBeat.o(14735);
            return;
        }
        long parseLong = (long) ((((float) (Long.parseLong(a2[16]) + ((Long.parseLong(a2[13]) + Long.parseLong(a2[14])) + Long.parseLong(a2[15])))) * 1000.0f) / ((float) this.f451b));
        String[] a3 = a(this.f454e);
        if (a3 == null || a3.length < 8) {
            long timeTick = ((long) this.f452c) * TXCTimeUtil.getTimeTick();
            j3 = timeTick;
            j2 = timeTick;
        } else {
            long parseLong2 = Long.parseLong(a3[1]) + Long.parseLong(a3[2]) + Long.parseLong(a3[3]) + Long.parseLong(a3[4]) + Long.parseLong(a3[5]) + Long.parseLong(a3[6]) + Long.parseLong(a3[7]);
            long parseLong3 = Long.parseLong(a3[4]) + Long.parseLong(a3[5]);
            j3 = (long) ((((float) parseLong2) * 1000.0f) / ((float) this.f451b));
            j2 = (long) ((((float) parseLong3) * 1000.0f) / ((float) this.f451b));
        }
        long j4 = j3 - this.f458i;
        this.f457h = ((((float) parseLong) - this.f456g) * 100.0f) / ((float) j4);
        this.k = (((float) (j4 - (j2 - this.f459j))) * 100.0f) / ((float) j4);
        this.f456g = (float) parseLong;
        this.f459j = j2;
        this.f458i = j3;
        this.f455f = TXCTimeUtil.getTimeTick();
        AppMethodBeat.o(14735);
    }

    private static String[] a(RandomAccessFile randomAccessFile) {
        String str;
        AppMethodBeat.i(14736);
        if (randomAccessFile == null) {
            AppMethodBeat.o(14736);
            return null;
        }
        try {
            randomAccessFile.seek(0);
            str = randomAccessFile.readLine();
        } catch (IOException e2) {
            TXCLog.e("CpuUsageMeasurer", "read line failed. " + e2.getMessage());
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(14736);
            return null;
        }
        String[] split = str.split("\\s+");
        AppMethodBeat.o(14736);
        return split;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(14737);
        super.finalize();
        c.a(this.f453d);
        c.a(this.f454e);
        TXCLog.i("CpuUsageMeasurer", "measurer is released");
        AppMethodBeat.o(14737);
    }
}
