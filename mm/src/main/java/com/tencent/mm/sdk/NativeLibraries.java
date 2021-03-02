package com.tencent.mm.sdk;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.io.BufferedReader;
import java.util.HashSet;
import java.util.Set;

public class NativeLibraries {
    private static final String TAG = "MicroMsg.NativeLibraries";

    public static Set list() {
        AppMethodBeat.i(32814);
        try {
            HashSet<String> hashSet = new HashSet();
            BufferedReader bufferedReader = new BufferedReader(new u("/proc/" + Process.myPid() + "/maps"));
            Log.i(TAG, "Dump NativeLibrares:");
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (readLine.endsWith(".so")) {
                    hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                }
            }
            for (String str : hashSet) {
                Log.i(TAG, String.valueOf(str));
            }
            AppMethodBeat.o(32814);
            return hashSet;
        } catch (Throwable th) {
            Log.printErrStackTrace(TAG, th, "", new Object[0]);
            AppMethodBeat.o(32814);
            return null;
        }
    }
}
