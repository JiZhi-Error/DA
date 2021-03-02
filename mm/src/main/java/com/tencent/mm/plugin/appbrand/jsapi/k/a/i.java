package com.tencent.mm.plugin.appbrand.jsapi.k.a;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.e.b;
import com.tencent.mm.plugin.appbrand.widget.e.d;
import java.util.LinkedList;

public final class i {
    private static LinkedList<View> mbD = new LinkedList<>();
    private static LinkedList<d> mbE = new LinkedList<>();
    private static LinkedList<b> mbF = new LinkedList<>();

    static {
        AppMethodBeat.i(146564);
        AppMethodBeat.o(146564);
    }

    public static b bHm() {
        b removeFirst;
        AppMethodBeat.i(146559);
        synchronized (mbF) {
            try {
                if (mbF.size() <= 0) {
                    removeFirst = null;
                } else {
                    removeFirst = mbF.removeFirst();
                    detachView(removeFirst);
                    AppMethodBeat.o(146559);
                }
            } finally {
                AppMethodBeat.o(146559);
            }
        }
        return removeFirst;
    }

    public static boolean a(b bVar) {
        boolean z;
        AppMethodBeat.i(146560);
        synchronized (mbF) {
            try {
                if (mbF.size() > 0) {
                    z = false;
                } else {
                    mbF.push(bVar);
                    z = true;
                    AppMethodBeat.o(146560);
                }
            } finally {
                AppMethodBeat.o(146560);
            }
        }
        return z;
    }

    public static d bHn() {
        d removeFirst;
        AppMethodBeat.i(146561);
        synchronized (mbE) {
            try {
                if (mbE.size() <= 0) {
                    removeFirst = null;
                } else {
                    removeFirst = mbE.removeFirst();
                    detachView(removeFirst);
                    AppMethodBeat.o(146561);
                }
            } finally {
                AppMethodBeat.o(146561);
            }
        }
        return removeFirst;
    }

    public static boolean a(d dVar) {
        boolean z;
        AppMethodBeat.i(146562);
        synchronized (mbE) {
            try {
                if (mbE.size() > 0) {
                    z = false;
                } else {
                    mbE.push(dVar);
                    z = true;
                    AppMethodBeat.o(146562);
                }
            } finally {
                AppMethodBeat.o(146562);
            }
        }
        return z;
    }

    private static void detachView(View view) {
        AppMethodBeat.i(146563);
        if (view == null) {
            AppMethodBeat.o(146563);
        } else if (!ViewGroup.class.isInstance(view.getParent())) {
            AppMethodBeat.o(146563);
        } else {
            ((ViewGroup) view.getParent()).removeView(view);
            AppMethodBeat.o(146563);
        }
    }
}
