package com.tencent.mm.gpu.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public final class b {
    public static int axx() {
        AppMethodBeat.i(186214);
        try {
            int parseInt = Integer.parseInt(new BufferedReader(new InputStreamReader(new FileInputStream(new File("/proc/self/oom_score")))).readLine());
            AppMethodBeat.o(186214);
            return parseInt;
        } catch (IOException | NumberFormatException e2) {
            AppMethodBeat.o(186214);
            return -4398;
        }
    }
}
