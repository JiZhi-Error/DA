package com.tencent.mars.smc;

import com.tencent.mm.plugin.report.e;
import java.util.ArrayList;

public class IPCSmcLogic {
    private static void reportKV(long j2, String str, boolean z, boolean z2, long j3) {
        e.INSTANCE.a((int) j2, (int) j3, str, z2, z);
    }

    private static void reportIDKey(long j2, long j3, long j4, boolean z) {
        e.INSTANCE.idkeyStat(j2, j3, j4, z);
    }

    private static void reportGroupIDKey(int[] iArr, int[] iArr2, int[] iArr3, int i2, boolean z) {
        ArrayList<IDKey> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(new IDKey(iArr[i3], iArr2[i3], iArr3[i3]));
        }
        e.INSTANCE.b(arrayList, z);
    }
}
