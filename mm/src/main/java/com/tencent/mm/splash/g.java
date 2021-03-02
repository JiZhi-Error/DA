package com.tencent.mm.splash;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class g {
    public static final boolean zF = o(System.getProperty("java.vm.version"));

    static {
        AppMethodBeat.i(40620);
        AppMethodBeat.o(40620);
    }

    private static boolean o(String str) {
        boolean z = false;
        AppMethodBeat.i(40619);
        if (str != null) {
            Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
            if (matcher.matches()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    int parseInt2 = Integer.parseInt(matcher.group(2));
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 > 0)) {
                        z = true;
                    }
                } catch (NumberFormatException e2) {
                }
            }
        }
        Log.i("MicroMsg.MultiDex", "VM with version " + str + (z ? " has multidex support" : " does not have multidex support"));
        AppMethodBeat.o(40619);
        return z;
    }
}
