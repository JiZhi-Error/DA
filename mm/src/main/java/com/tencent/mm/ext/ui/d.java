package com.tencent.mm.ext.ui;

import com.tencent.liteapp.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

public final class d {
    private static LinkedList<WeakReference<a>> hfm = new LinkedList<>();

    public interface a {
        void onSettle(boolean z, int i2);

        void onSwipe(float f2);
    }

    static {
        AppMethodBeat.i(197840);
        AppMethodBeat.o(197840);
    }

    public static void a(a aVar) {
        AppMethodBeat.i(197836);
        b.d("MicroMsg.SwipeBackHelper", "pushCallback size %d, %s", Integer.valueOf(hfm.size()), aVar);
        hfm.add(0, new WeakReference<>(aVar));
        AppMethodBeat.o(197836);
    }

    public static boolean b(a aVar) {
        AppMethodBeat.i(197837);
        int size = hfm.size();
        b.d("MicroMsg.SwipeBackHelper", "popCallback size %d, %s", Integer.valueOf(size), aVar);
        LinkedList linkedList = new LinkedList();
        int i2 = 0;
        while (true) {
            if (i2 >= hfm.size()) {
                break;
            } else if (aVar == hfm.get(i2).get()) {
                hfm.remove(i2);
                b.d("MicroMsg.SwipeBackHelper", "popCallback directly, index %d", Integer.valueOf(i2));
                break;
            } else {
                linkedList.add(0, Integer.valueOf(i2));
                i2++;
            }
        }
        if (linkedList.size() == size) {
            b.d("MicroMsg.SwipeBackHelper", "popCallback Fail! Maybe Top Activity", new Object[0]);
            AppMethodBeat.o(197837);
            return false;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            WeakReference<a> remove = hfm.remove(((Integer) it.next()).intValue());
            Object[] objArr = new Object[1];
            objArr[0] = remove != null ? remove.get() : "NULL-CALLBACK";
            b.d("MicroMsg.SwipeBackHelper", "popCallback, popup %s", objArr);
        }
        boolean isEmpty = linkedList.isEmpty();
        AppMethodBeat.o(197837);
        return isEmpty;
    }

    public static void aq(float f2) {
        AppMethodBeat.i(197838);
        if (hfm.size() <= 0) {
            b.w("MicroMsg.SwipeBackHelper", "notifySwipe callback stack empty!, scrollParent:%f", Float.valueOf(f2));
            AppMethodBeat.o(197838);
            return;
        }
        a aVar = hfm.get(0).get();
        if (aVar == null) {
            b.w("MicroMsg.SwipeBackHelper", "notifySwipe null, scrollParent:%f", Float.valueOf(f2));
            AppMethodBeat.o(197838);
            return;
        }
        aVar.onSwipe(f2);
        b.v("MicroMsg.SwipeBackHelper", "notifySwipe scrollParent:%f, callback:%s ", Float.valueOf(f2), aVar);
        AppMethodBeat.o(197838);
    }

    public static void h(boolean z, int i2) {
        AppMethodBeat.i(197839);
        if (hfm.size() <= 0) {
            b.w("MicroMsg.SwipeBackHelper", "notifySettle callback stack empty!, open:%B, speed:%d", Boolean.valueOf(z), Integer.valueOf(i2));
            AppMethodBeat.o(197839);
            return;
        }
        a aVar = hfm.get(0).get();
        if (aVar == null) {
            b.w("MicroMsg.SwipeBackHelper", "notifySettle null, open:%B, speed:%d", Boolean.valueOf(z), Integer.valueOf(i2));
            AppMethodBeat.o(197839);
            return;
        }
        aVar.onSettle(z, i2);
        b.v("MicroMsg.SwipeBackHelper", "notifySettle, open:%B speed:%d callback:%s", Boolean.valueOf(z), Integer.valueOf(i2), aVar);
        AppMethodBeat.o(197839);
    }
}
