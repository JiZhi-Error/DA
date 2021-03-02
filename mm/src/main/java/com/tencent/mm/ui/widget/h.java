package com.tencent.mm.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

public final class h {
    private static LinkedList<WeakReference<a>> hfm = new LinkedList<>();

    public interface a {
        boolean forceRemoveNoMatchOnPath();

        void onSettle(boolean z, int i2);

        void onSwipe(float f2);
    }

    static {
        AppMethodBeat.i(143472);
        AppMethodBeat.o(143472);
    }

    public static void a(a aVar) {
        AppMethodBeat.i(143468);
        Log.d("MicroMsg.SwipeBackHelper", "pushCallback size %d, %s", Integer.valueOf(hfm.size()), aVar);
        hfm.add(0, new WeakReference<>(aVar));
        AppMethodBeat.o(143468);
    }

    public static boolean b(a aVar) {
        AppMethodBeat.i(143469);
        int size = hfm.size();
        Log.d("MicroMsg.SwipeBackHelper", "popCallback size %d, %s", Integer.valueOf(size), aVar);
        if (aVar == null) {
            AppMethodBeat.o(143469);
            return true;
        }
        LinkedList linkedList = new LinkedList();
        int i2 = 0;
        while (true) {
            if (i2 >= hfm.size()) {
                break;
            } else if (aVar == hfm.get(i2).get()) {
                hfm.remove(i2);
                Log.d("MicroMsg.SwipeBackHelper", "popCallback directly, index %d", Integer.valueOf(i2));
                break;
            } else {
                linkedList.add(0, Integer.valueOf(i2));
                i2++;
            }
        }
        if (aVar.forceRemoveNoMatchOnPath() || linkedList.size() != size) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                WeakReference<a> remove = hfm.remove(((Integer) it.next()).intValue());
                Object[] objArr = new Object[1];
                objArr[0] = remove != null ? remove.get() : "NULL-CALLBACK";
                Log.d("MicroMsg.SwipeBackHelper", "popCallback, popup %s", objArr);
            }
            boolean isEmpty = linkedList.isEmpty();
            AppMethodBeat.o(143469);
            return isEmpty;
        }
        Log.d("MicroMsg.SwipeBackHelper", "popCallback Fail! Maybe Top Activity");
        AppMethodBeat.o(143469);
        return false;
    }

    public static void aq(float f2) {
        AppMethodBeat.i(143470);
        if (hfm.size() <= 0) {
            Log.w("MicroMsg.SwipeBackHelper", "notifySwipe callback stack empty!, scrollParent:%f", Float.valueOf(f2));
            AppMethodBeat.o(143470);
            return;
        }
        a aVar = hfm.get(0).get();
        if (aVar == null) {
            Log.w("MicroMsg.SwipeBackHelper", "notifySwipe null, scrollParent:%f", Float.valueOf(f2));
            AppMethodBeat.o(143470);
            return;
        }
        aVar.onSwipe(f2);
        Log.v("MicroMsg.SwipeBackHelper", "notifySwipe scrollParent:%f, callback:%s ", Float.valueOf(f2), aVar);
        AppMethodBeat.o(143470);
    }

    public static void h(boolean z, int i2) {
        AppMethodBeat.i(143471);
        if (hfm.size() <= 0) {
            Log.w("MicroMsg.SwipeBackHelper", "notifySettle callback stack empty!, open:%B, speed:%d", Boolean.valueOf(z), Integer.valueOf(i2));
            AppMethodBeat.o(143471);
            return;
        }
        a aVar = hfm.get(0).get();
        if (aVar == null) {
            Log.w("MicroMsg.SwipeBackHelper", "notifySettle null, open:%B, speed:%d", Boolean.valueOf(z), Integer.valueOf(i2));
            AppMethodBeat.o(143471);
            return;
        }
        aVar.onSettle(z, i2);
        Log.v("MicroMsg.SwipeBackHelper", "notifySettle, open:%B speed:%d callback:%s", Boolean.valueOf(z), Integer.valueOf(i2), aVar);
        AppMethodBeat.o(143471);
    }
}
