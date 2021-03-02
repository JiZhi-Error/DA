package com.tencent.mm.ipcinvoker.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class b {
    private static final Set<Object> hnC = new HashSet();
    private static final Map<String, Set<c>> hno = new HashMap();

    static {
        AppMethodBeat.i(158826);
        AppMethodBeat.o(158826);
    }

    public static void br(Object obj) {
        AppMethodBeat.i(158821);
        hnC.add(obj);
        AppMethodBeat.o(158821);
    }

    public static void bs(Object obj) {
        AppMethodBeat.i(158822);
        hnC.remove(obj);
        AppMethodBeat.o(158822);
    }

    public static boolean a(String str, c cVar) {
        HashSet hashSet;
        boolean add;
        AppMethodBeat.i(158823);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(158823);
            return false;
        }
        synchronized (hno) {
            try {
                Set<c> set = hno.get(str);
                if (set == null) {
                    HashSet hashSet2 = new HashSet();
                    hno.put(str, hashSet2);
                    hashSet = hashSet2;
                } else {
                    hashSet = set;
                }
            } finally {
                AppMethodBeat.o(158823);
            }
        }
        com.tencent.mm.ipcinvoker.h.b.i("IPC.ObjectRecycler", "addIntoSet(%s)", str);
        synchronized (hashSet) {
            try {
                add = hashSet.add(cVar);
            } finally {
                AppMethodBeat.o(158823);
            }
        }
        return add;
    }

    public static boolean b(String str, c cVar) {
        Set<c> set;
        boolean remove;
        AppMethodBeat.i(158824);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(158824);
            return false;
        }
        synchronized (hno) {
            try {
                set = hno.get(str);
            } finally {
                AppMethodBeat.o(158824);
            }
        }
        if (set == null) {
            AppMethodBeat.o(158824);
            return false;
        }
        com.tencent.mm.ipcinvoker.h.b.i("IPC.ObjectRecycler", "removeFromSet(%s)", str);
        synchronized (set) {
            try {
                remove = set.remove(cVar);
            } finally {
                AppMethodBeat.o(158824);
            }
        }
        return remove;
    }

    public static void Ft(String str) {
        Set<c> remove;
        AppMethodBeat.i(158825);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(158825);
            return;
        }
        synchronized (hno) {
            try {
                remove = hno.remove(str);
            } finally {
                AppMethodBeat.o(158825);
            }
        }
        if (remove == null) {
            AppMethodBeat.o(158825);
            return;
        }
        com.tencent.mm.ipcinvoker.h.b.i("IPC.ObjectRecycler", "recycleAll(%s)", str);
        synchronized (remove) {
            try {
                for (c cVar : remove) {
                    com.tencent.mm.ipcinvoker.h.b.i("IPC.ObjectRecycler", "recycle(%s)", Integer.valueOf(cVar.hashCode()));
                    cVar.recycle();
                }
                remove.clear();
            } finally {
                AppMethodBeat.o(158825);
            }
        }
    }
}
