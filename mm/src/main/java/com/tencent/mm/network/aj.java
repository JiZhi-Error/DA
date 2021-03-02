package com.tencent.mm.network;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class aj {
    public static final String jFY = (b.aKD() + "/tencent/noop.dat");
    private static long jFZ;
    private static long lastUpdateTime;

    static {
        long j2;
        AppMethodBeat.i(132942);
        lastUpdateTime = 0;
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("noop_prefs", 0);
        int i2 = sharedPreferences.getInt("noop_strategy", 1);
        if (1 == i2) {
            jFZ = 270;
            new StringBuilder("getNoopIntervalInMs use hard code noop:").append(jFZ);
            j2 = jFZ * 1000;
        } else if (3 == i2) {
            long j3 = sharedPreferences.getLong("noop_min_interval", 270);
            if (j3 < 180 || j3 > 3600) {
                jFZ = 270;
                new StringBuilder("getNoopIntervalInMs use wx noop:").append(jFZ);
                j2 = jFZ * 1000;
            } else {
                jFZ = j3;
                j2 = j3 * 1000;
            }
        } else {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis - lastUpdateTime > 3600) {
                long[] bkq = bkq();
                if (bkq[0] < 180 || bkq[0] > 3600) {
                    jFZ = 270;
                } else {
                    jFZ = bkq[0];
                }
                lastUpdateTime = currentTimeMillis;
            }
            new StringBuilder("getNoopIntervalInMs use sync noop:").append(jFZ);
            j2 = jFZ * 1000;
        }
        jFZ = j2 / 1000;
        AppMethodBeat.o(132942);
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x0164 A[SYNTHETIC, Splitter:B:52:0x0164] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x017b A[SYNTHETIC, Splitter:B:59:0x017b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void E(long r10, long r12) {
        /*
        // Method dump skipped, instructions count: 397
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.network.aj.E(long, long):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0082 A[SYNTHETIC, Splitter:B:31:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008d A[SYNTHETIC, Splitter:B:37:0x008d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long[] bkq() {
        /*
        // Method dump skipped, instructions count: 174
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.network.aj.bkq():long[]");
    }
}
