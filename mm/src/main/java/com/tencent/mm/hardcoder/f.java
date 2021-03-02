package com.tencent.mm.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f {
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b1 A[SYNTHETIC, Splitter:B:22:0x00b1] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b6 A[SYNTHETIC, Splitter:B:25:0x00b6] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00fb A[SYNTHETIC, Splitter:B:35:0x00fb] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0100 A[SYNTHETIC, Splitter:B:38:0x0100] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long[] axO() {
        /*
        // Method dump skipped, instructions count: 331
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.hardcoder.f.axO():long[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00f0 A[SYNTHETIC, Splitter:B:34:0x00f0] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f5 A[SYNTHETIC, Splitter:B:37:0x00f5] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x013a A[SYNTHETIC, Splitter:B:47:0x013a] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x013f A[SYNTHETIC, Splitter:B:50:0x013f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int pE(int r8) {
        /*
        // Method dump skipped, instructions count: 394
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.hardcoder.f.pE(int):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a2 A[SYNTHETIC, Splitter:B:26:0x00a2] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a7 A[SYNTHETIC, Splitter:B:29:0x00a7] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00eb A[SYNTHETIC, Splitter:B:39:0x00eb] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f0 A[SYNTHETIC, Splitter:B:42:0x00f0] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long pF(int r9) {
        /*
        // Method dump skipped, instructions count: 315
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.hardcoder.f.pF(int):long");
    }

    private static int cL(String str) {
        int i2 = 0;
        AppMethodBeat.i(62483);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i2 = Integer.decode(str).intValue();
                    AppMethodBeat.o(62483);
                    return i2;
                }
            } catch (NumberFormatException e2) {
                d.printErrStackTrace("Hardcoder.HardCoderUtil", e2, "getInt", new Object[0]);
                AppMethodBeat.o(62483);
            }
        }
        AppMethodBeat.o(62483);
        return i2;
    }

    private static long Fk(String str) {
        long j2 = 0;
        AppMethodBeat.i(62484);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    j2 = Long.decode(str).longValue();
                    AppMethodBeat.o(62484);
                    return j2;
                }
            } catch (NumberFormatException e2) {
                d.printErrStackTrace("Hardcoder.HardCoderUtil", e2, "getLong", new Object[0]);
                AppMethodBeat.o(62484);
            }
        }
        AppMethodBeat.o(62484);
        return j2;
    }
}
