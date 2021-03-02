package com.tencent.mm.plugin.mmsight;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentSkipListSet;

public final class c {
    private static ConcurrentSkipListSet<Integer> zsq = new ConcurrentSkipListSet<>();

    static {
        AppMethodBeat.i(148776);
        AppMethodBeat.o(148776);
    }

    public static synchronized void QE(int i2) {
        synchronized (c.class) {
            AppMethodBeat.i(148773);
            try {
                Log.i("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxing: %s", Integer.valueOf(i2));
                zsq.add(Integer.valueOf(i2));
                AppMethodBeat.o(148773);
            } catch (Exception e2) {
                Log.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxing error: %s", e2.getMessage());
                AppMethodBeat.o(148773);
            }
        }
    }

    public static synchronized void QF(int i2) {
        synchronized (c.class) {
            AppMethodBeat.i(148774);
            try {
                Log.i("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxingFinish: %s", Integer.valueOf(i2));
                zsq.remove(Integer.valueOf(i2));
                AppMethodBeat.o(148774);
            } catch (Exception e2) {
                Log.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxingFinish error: %s", e2.getMessage());
                AppMethodBeat.o(148774);
            }
        }
    }

    public static synchronized boolean QG(int i2) {
        boolean z;
        synchronized (c.class) {
            AppMethodBeat.i(148775);
            try {
                z = zsq.contains(Integer.valueOf(i2));
                Log.d("MicroMsg.MMSightCaptureVideoRemuxStatus", "isMsgRemuxing: %s, %s", Integer.valueOf(i2), Boolean.valueOf(z));
                AppMethodBeat.o(148775);
            } catch (Exception e2) {
                Log.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "isMsgRemuxing error: %s", e2.getMessage());
                AppMethodBeat.o(148775);
                z = false;
            }
        }
        return z;
    }
}
