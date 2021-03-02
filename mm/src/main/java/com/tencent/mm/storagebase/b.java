package com.tencent.mm.storagebase;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    static final boolean OsW;

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c6 A[SYNTHETIC, Splitter:B:28:0x00c6] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d0 A[SYNTHETIC, Splitter:B:34:0x00d0] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String gFt() {
        /*
        // Method dump skipped, instructions count: 223
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storagebase.b.gFt():java.lang.String");
    }

    static {
        boolean z = false;
        AppMethodBeat.i(133325);
        if (Build.VERSION.SDK_INT == 28 && Build.BRAND.equals("samsung")) {
            String lowerCase = Build.HARDWARE.toLowerCase();
            char c2 = 65535;
            switch (lowerCase.hashCode()) {
                case -1359763720:
                    if (lowerCase.equals("exynos7884a")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1359763719:
                    if (lowerCase.equals("exynos7884b")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 2034346633:
                    if (lowerCase.equals("exynos7884")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 2034346634:
                    if (lowerCase.equals("exynos7885")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 2034347346:
                    if (lowerCase.equals("exynos7904")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 2034347347:
                    if (lowerCase.equals("exynos7905")) {
                        c2 = 5;
                        break;
                    }
                    break;
            }
            switch (c2) {
            }
            OsW = z;
            AppMethodBeat.o(133325);
        }
        z = true;
        OsW = z;
        AppMethodBeat.o(133325);
    }
}
