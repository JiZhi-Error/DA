package com.tencent.e.d.a;

import com.tencent.e.d.b.b;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;

public final class a {
    public static boolean bpZ(String str) {
        AppMethodBeat.i(138342);
        if (!new File(str).exists()) {
            AppMethodBeat.o(138342);
            return true;
        }
        try {
            boolean bpZ = b.bpZ(str);
            if (!bpZ) {
                "BootScriptChecker found no-elf file : ".concat(String.valueOf(str));
                h.hkR();
            }
            AppMethodBeat.o(138342);
            return bpZ;
        } catch (IOException e2) {
            h.w(e2);
            AppMethodBeat.o(138342);
            return true;
        }
    }

    public static boolean bqa(String str) {
        boolean z = true;
        AppMethodBeat.i(138343);
        File file = new File(str);
        if (!file.exists() || file.length() > 51200) {
            AppMethodBeat.o(138343);
        } else {
            try {
                String str2 = new String(b.aVb(file.getAbsolutePath()));
                z = str2.contains("applypatch ");
                new StringBuilder("BootScriptChecker script (").append(str).append(") content : \n").append(str2);
                h.gGd();
                if (!z) {
                    "BootScriptChecker found unofficial file : ".concat(String.valueOf(str));
                    h.hkR();
                }
                AppMethodBeat.o(138343);
            } catch (Exception e2) {
                h.w(e2);
                AppMethodBeat.o(138343);
            }
        }
        return z;
    }
}
