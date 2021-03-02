package com.tencent.mm.ui.chatting;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aq {
    private static LinkedList<View> Ple = new LinkedList<>();
    private static LinkedList<View> Plf = new LinkedList<>();
    private static LinkedList<View> Plg = new LinkedList<>();

    static {
        AppMethodBeat.i(123728);
        AppMethodBeat.o(123728);
    }

    public static View ams(int i2) {
        AppMethodBeat.i(123725);
        LinkedList<View> linkedList = i2 == 1 ? Ple : i2 == 2 ? Plf : Plg;
        if (linkedList.size() != 0) {
            View removeFirst = linkedList.removeFirst();
            AppMethodBeat.o(123725);
            return removeFirst;
        }
        AppMethodBeat.o(123725);
        return null;
    }

    public static void aH(View view, int i2) {
        AppMethodBeat.i(123726);
        LinkedList<View> linkedList = i2 == 1 ? Ple : i2 == 2 ? Plf : Plg;
        if (linkedList.size() >= 35) {
            linkedList.removeFirst();
        }
        linkedList.addLast(view);
        AppMethodBeat.o(123726);
    }

    public static void clear() {
        AppMethodBeat.i(123727);
        Ple.clear();
        Plf.clear();
        Plg.clear();
        AppMethodBeat.o(123727);
    }
}
