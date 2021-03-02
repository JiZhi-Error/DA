package com.tencent.mm.sandbox;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class c {
    private static c NEa = null;
    private static Map<Integer, Boolean> NEb = new HashMap();

    static {
        AppMethodBeat.i(32577);
        AppMethodBeat.o(32577);
    }

    public static void q(int i2, Object obj) {
        AppMethodBeat.i(32575);
        Log.i("MicroMsg.SandBoxCore", "regLifeCycle, id=" + i2 + ", class=%s", obj.getClass().getName());
        NEb.put(Integer.valueOf(i2), Boolean.TRUE);
        Log.i("MicroMsg.SandBoxCore", "regLifeCycle, map size=" + NEb.size());
        AppMethodBeat.o(32575);
    }

    public static void r(int i2, Object obj) {
        AppMethodBeat.i(32576);
        Log.i("MicroMsg.SandBoxCore", "unregLifeCycle, id=" + i2 + ", class=%s", obj.getClass().getName());
        NEb.remove(Integer.valueOf(i2));
        Log.i("MicroMsg.SandBoxCore", "unregLifeCycle, map size=" + NEb.size());
        if (NEb.size() == 0) {
            a a2 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new a());
            Object obj2 = new Object();
            com.tencent.mm.hellhoundlib.a.a.a(obj2, a2.axQ(), "com/tencent/mm/sandbox/SandBoxCore", "unregLifeCycle", "(ILjava/lang/Object;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
            Process.killProcess(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(obj2, "com/tencent/mm/sandbox/SandBoxCore", "unregLifeCycle", "(ILjava/lang/Object;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
            Log.w("MicroMsg.SandBoxCore", "Sandbox exit Now.");
            Log.appenderFlushSync();
        }
        AppMethodBeat.o(32576);
    }
}
