package com.tencent.e.d.a;

import com.tencent.e.d.b.b;
import com.tencent.e.d.b.d;
import com.tencent.e.d.b.g;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;

public final class f {
    private static boolean Y(File file) {
        AppMethodBeat.i(138351);
        try {
            if ((d.bqb(file.getAbsolutePath()) & 2048) > 0) {
                AppMethodBeat.o(138351);
                return true;
            }
            AppMethodBeat.o(138351);
            return false;
        } catch (Exception e2) {
            h.w(e2);
            AppMethodBeat.o(138351);
            return false;
        }
    }

    public static boolean hky() {
        boolean z;
        AppMethodBeat.i(138352);
        if (g.hkA()) {
            h.hkR();
            AppMethodBeat.o(138352);
            return false;
        }
        try {
            String str = new String(b.aVb("/proc/mounts"));
            "SetuidBitChecker mounts : ".concat(String.valueOf(str));
            h.gGd();
            String[] split = str.split("\n");
            int length = split.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                String str2 = split[i2];
                if (!str2.contains(" /system ")) {
                    i2++;
                } else if (str2.contains(",nosuid")) {
                    h.hkR();
                    z = true;
                }
            }
            z = false;
            if (z) {
                AppMethodBeat.o(138352);
                return false;
            } else if (!d.isAvailable()) {
                h.hkR();
                AppMethodBeat.o(138352);
                return false;
            } else {
                File[] listFiles = new File("/system/bin").listFiles();
                if (listFiles != null) {
                    for (File file : listFiles) {
                        if (!"run-as".equals(file.getName()) && Y(file)) {
                            new StringBuilder("SetuidBitChecker s-bit found : ").append(file.getAbsolutePath());
                            h.hkR();
                            AppMethodBeat.o(138352);
                            return true;
                        }
                    }
                }
                File[] listFiles2 = new File("/system/xbin").listFiles();
                if (listFiles2 != null) {
                    for (File file2 : listFiles2) {
                        if (Y(file2)) {
                            new StringBuilder("SetuidBitChecker s-bit found : ").append(file2.getAbsolutePath());
                            h.hkR();
                            AppMethodBeat.o(138352);
                            return true;
                        }
                    }
                }
                h.hkR();
                AppMethodBeat.o(138352);
                return false;
            }
        } catch (IOException e2) {
            h.w(e2);
            AppMethodBeat.o(138352);
            return false;
        }
    }
}
