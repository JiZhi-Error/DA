package com.tencent.kinda.framework.animate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashMap;
import java.util.Map;

public class KindaAnimatorWatch {
    private static final String TAG = "MicroMsg.KindaAnimatorWatch";
    private static Map<Integer, Runnable> pendingActions = new HashMap();
    private static int pendingObj = 0;

    static {
        AppMethodBeat.i(18326);
        AppMethodBeat.o(18326);
    }

    public static void post(final Runnable runnable) {
        AppMethodBeat.i(18323);
        if (pendingObj != 0) {
            pendingActions.put(Integer.valueOf(pendingObj), runnable);
            pendingObj = 0;
            AppMethodBeat.o(18323);
            return;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.kinda.framework.animate.KindaAnimatorWatch.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(18320);
                runnable.run();
                AppMethodBeat.o(18320);
            }
        });
        AppMethodBeat.o(18323);
    }

    public static void didObjCreated(final int i2) {
        AppMethodBeat.i(18324);
        pendingObj = i2;
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.kinda.framework.animate.KindaAnimatorWatch.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(18321);
                if (KindaAnimatorWatch.pendingActions.containsKey(Integer.valueOf(i2))) {
                    KindaAnimatorWatch.pendingActions.remove(Integer.valueOf(i2));
                }
                AppMethodBeat.o(18321);
            }
        }, 5000);
        AppMethodBeat.o(18324);
    }

    public static void didViewCreated(int i2) {
        AppMethodBeat.i(18325);
        pendingObj = 0;
        if (pendingActions.containsKey(Integer.valueOf(i2))) {
            final Runnable runnable = pendingActions.get(Integer.valueOf(i2));
            pendingActions.remove(Integer.valueOf(i2));
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.kinda.framework.animate.KindaAnimatorWatch.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(18322);
                    runnable.run();
                    AppMethodBeat.o(18322);
                }
            });
        }
        AppMethodBeat.o(18325);
    }
}
