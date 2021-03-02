package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class MMEntryLock {
    private static final String TAG = "MicroMsg.MMEntryLock";
    private static Set<String> locks = new HashSet();

    static {
        AppMethodBeat.i(157622);
        AppMethodBeat.o(157622);
    }

    private MMEntryLock() {
    }

    public static boolean lock(String str) {
        AppMethodBeat.i(157619);
        if (isLocked(str)) {
            Log.d(TAG, "locked-".concat(String.valueOf(str)));
            AppMethodBeat.o(157619);
            return false;
        }
        Log.d(TAG, "lock-".concat(String.valueOf(str)));
        boolean add = locks.add(str);
        AppMethodBeat.o(157619);
        return add;
    }

    public static void unlock(String str) {
        AppMethodBeat.i(157620);
        locks.remove(str);
        Log.d(TAG, "unlock-".concat(String.valueOf(str)));
        AppMethodBeat.o(157620);
    }

    public static boolean isLocked(String str) {
        AppMethodBeat.i(157621);
        boolean contains = locks.contains(str);
        AppMethodBeat.o(157621);
        return contains;
    }
}
