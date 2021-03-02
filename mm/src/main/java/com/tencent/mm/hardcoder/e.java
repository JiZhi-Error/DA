package com.tencent.mm.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.a;

public final class e {
    private static a hlA = null;

    public interface a {
        void a(int[] iArr, int i2, int i3, int i4, int i5, long j2, int i6, int i7, int[] iArr2, int i8, int i9, int i10, int[] iArr3, int[] iArr4);
    }

    public static void a(a aVar) {
        AppMethodBeat.i(62478);
        if (hlA == null) {
            d.i("Hardcoder.HardCoderReporter", String.format("setReporter[%s]", aVar));
            hlA = aVar;
        }
        AppMethodBeat.o(62478);
    }

    public static void a(a.b bVar) {
        AppMethodBeat.i(62479);
        int i2 = (int) (bVar.hla - bVar.hlg);
        int i3 = HardCoderJNI.isHcEnable() ? 1 : 0;
        int isRunning = HardCoderJNI.isRunning();
        int i4 = i2 - bVar.delay <= 0 ? 1 : 0;
        int i5 = bVar.scene;
        long j2 = bVar.hlf;
        int i6 = bVar.hlb;
        int i7 = bVar.hld;
        int[] iArr = bVar.hln;
        int i8 = (int) (bVar.hlh - bVar.startTime);
        int i9 = HardCoderJNI.tickRate;
        int[] iArr2 = bVar.hll;
        int[] iArr3 = bVar.hlm;
        StringBuilder sb = new StringBuilder();
        if (iArr != null) {
            int length = iArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                sb.append(iArr[i10] + "#");
            }
        }
        StringBuilder sb2 = new StringBuilder();
        if (iArr2 != null) {
            int length2 = iArr2.length;
            for (int i11 = 0; i11 < length2; i11++) {
                sb2.append(iArr2[i11] + "#");
            }
        }
        StringBuilder sb3 = new StringBuilder();
        if (iArr3 != null) {
            int length3 = iArr3.length;
            for (int i12 = 0; i12 < length3; i12++) {
                sb3.append(iArr3[i12] + "#");
            }
        }
        d.d("Hardcoder.HardCoderReporter", String.format("performanceReport, hash:%s, threadId:%s, enable:%s, engineStatus:%s, cancelInDelay:%s, scene:%s, action:%s, lastCpuLevel:%s, cpuLevel:%s, lastIoLevel:%s, ioLevel:%s, bindCoreIds:%s, executeTime:%s, runtime:%s, phoneHZ:%s, cpuLevelTimeArray:%s, ioLevelTimeArray:%s", Integer.valueOf(bVar.hashCode()), bVar.axN(), Integer.valueOf(i3), Integer.valueOf(isRunning), Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j2), Integer.valueOf(bVar.hlj), Integer.valueOf(i6), Integer.valueOf(bVar.hlk), Integer.valueOf(i7), sb.toString(), Integer.valueOf(i8), Integer.valueOf(i2), Integer.valueOf(i9), sb2.toString(), sb3.toString()));
        if (hlA != null) {
            hlA.a(bVar.hle, i3, isRunning, i4, i5, j2, i6, i7, iArr, i8, i2, i9, iArr2, iArr3);
        }
        AppMethodBeat.o(62479);
    }
}
