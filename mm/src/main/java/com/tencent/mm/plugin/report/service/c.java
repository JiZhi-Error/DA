package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public final class c {
    public static Set<Integer> Cyd = new HashSet();
    private static boolean hasInit = false;

    public static boolean Wj(int i2) {
        AppMethodBeat.i(224153);
        synchronized (Cyd) {
            try {
                if (!hasInit) {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(MMApplicationContext.getContext().getResources().openRawResource(R.raw.invalid_idkey)));
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            Cyd.add(Integer.valueOf(Integer.parseInt(readLine)));
                        }
                    } catch (IOException e2) {
                        Log.e("IDKeyInvalidList", "invalid value in R file");
                    }
                    hasInit = true;
                }
            } catch (Throwable th) {
                AppMethodBeat.o(224153);
                throw th;
            }
        }
        if (Cyd.contains(Integer.valueOf(i2))) {
            AppMethodBeat.o(224153);
            return true;
        }
        AppMethodBeat.o(224153);
        return false;
    }

    static {
        AppMethodBeat.i(224154);
        AppMethodBeat.o(224154);
    }
}
