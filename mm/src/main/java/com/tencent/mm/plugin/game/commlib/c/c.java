package com.tencent.mm.plugin.game.commlib.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.c.b;
import java.util.concurrent.CopyOnWriteArrayList;

public final class c<E extends b> extends CopyOnWriteArrayList<E> {
    private Object lock = new Object();

    public c() {
        AppMethodBeat.i(89953);
        AppMethodBeat.o(89953);
    }

    public final int b(E e2) {
        int i2;
        boolean z;
        AppMethodBeat.i(89954);
        synchronized (this.lock) {
            int i3 = 0;
            while (true) {
                try {
                    if (i3 >= size()) {
                        i2 = 0;
                        z = false;
                        break;
                    } else if (e2.a((b) get(i3)) < 0) {
                        i2 = i3;
                        z = true;
                        break;
                    } else {
                        i3++;
                    }
                } finally {
                    AppMethodBeat.o(89954);
                }
            }
            if (!z) {
                i2 = size();
            }
            add(i2, e2);
        }
        return i2;
    }

    public final int c(E e2) {
        int i2;
        boolean z;
        AppMethodBeat.i(89955);
        synchronized (this.lock) {
            int i3 = 0;
            while (true) {
                try {
                    if (i3 >= size()) {
                        i2 = 0;
                        z = false;
                        break;
                    } else if (e2.a((b) get(i3)) <= 0) {
                        i2 = i3;
                        z = true;
                        break;
                    } else {
                        i3++;
                    }
                } finally {
                    AppMethodBeat.o(89955);
                }
            }
            if (!z) {
                i2 = size();
            }
            add(i2, e2);
        }
        return i2;
    }

    public final int ds(Object obj) {
        AppMethodBeat.i(89956);
        int i2 = 0;
        for (int i3 = 0; i3 < size(); i3++) {
            if (((b) get(i3)).cCe().equals(obj)) {
                i2++;
            }
        }
        AppMethodBeat.o(89956);
        return i2;
    }
}
