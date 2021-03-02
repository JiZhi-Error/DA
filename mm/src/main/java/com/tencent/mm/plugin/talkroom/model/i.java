package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.d;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.LinkedList;
import java.util.List;

public final class i {
    List<d> callbacks = new LinkedList();
    MMHandler handler = new MMHandler(Looper.getMainLooper());

    public i() {
        AppMethodBeat.i(29541);
        AppMethodBeat.o(29541);
    }

    public final void bgz() {
        AppMethodBeat.i(29542);
        AnonymousClass1 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.talkroom.model.i.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(29529);
                synchronized (i.this.callbacks) {
                    try {
                        for (d dVar : i.this.callbacks) {
                            dVar.bgz();
                        }
                    } finally {
                        AppMethodBeat.o(29529);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            r0.run();
            AppMethodBeat.o(29542);
            return;
        }
        this.handler.post(r0);
        AppMethodBeat.o(29542);
    }

    public final void s(final String str, final int i2, final int i3) {
        AppMethodBeat.i(29543);
        AnonymousClass5 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.talkroom.model.i.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(29533);
                synchronized (i.this.callbacks) {
                    try {
                        for (d dVar : i.this.callbacks) {
                            dVar.s(str, i2, i3);
                        }
                    } finally {
                        AppMethodBeat.o(29533);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            r0.run();
            AppMethodBeat.o(29543);
            return;
        }
        this.handler.post(r0);
        AppMethodBeat.o(29543);
    }

    public final void ua(final int i2) {
        AppMethodBeat.i(29544);
        AnonymousClass7 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.talkroom.model.i.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(29535);
                synchronized (i.this.callbacks) {
                    try {
                        for (d dVar : i.this.callbacks) {
                            dVar.ua(i2);
                        }
                    } finally {
                        AppMethodBeat.o(29535);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            r0.run();
            AppMethodBeat.o(29544);
            return;
        }
        this.handler.post(r0);
        AppMethodBeat.o(29544);
    }

    public final void PX(final String str) {
        AppMethodBeat.i(29545);
        AnonymousClass8 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.talkroom.model.i.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(29536);
                synchronized (i.this.callbacks) {
                    try {
                        for (d dVar : i.this.callbacks) {
                            dVar.PX(str);
                        }
                    } finally {
                        AppMethodBeat.o(29536);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            r0.run();
            AppMethodBeat.o(29545);
            return;
        }
        this.handler.post(r0);
        AppMethodBeat.o(29545);
    }

    public final void j(final int i2, final int i3, final String str) {
        AppMethodBeat.i(29546);
        AnonymousClass9 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.talkroom.model.i.AnonymousClass9 */

            public final void run() {
                AppMethodBeat.i(29537);
                synchronized (i.this.callbacks) {
                    try {
                        for (d dVar : i.this.callbacks) {
                            dVar.j(i2, i3, str);
                        }
                    } finally {
                        AppMethodBeat.o(29537);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            r0.run();
            AppMethodBeat.o(29546);
            return;
        }
        this.handler.post(r0);
        AppMethodBeat.o(29546);
    }

    public final void bgB() {
        AppMethodBeat.i(29547);
        AnonymousClass12 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.talkroom.model.i.AnonymousClass12 */

            public final void run() {
                AppMethodBeat.i(29540);
                synchronized (i.this.callbacks) {
                    try {
                        for (d dVar : i.this.callbacks) {
                            dVar.bgB();
                        }
                    } finally {
                        AppMethodBeat.o(29540);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            r0.run();
            AppMethodBeat.o(29547);
            return;
        }
        this.handler.post(r0);
        AppMethodBeat.o(29547);
    }

    public final void bgE() {
        AppMethodBeat.i(29548);
        AnonymousClass4 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.talkroom.model.i.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(29532);
                synchronized (i.this.callbacks) {
                    try {
                        for (d dVar : i.this.callbacks) {
                            dVar.bgE();
                        }
                    } finally {
                        AppMethodBeat.o(29532);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            r0.run();
            AppMethodBeat.o(29548);
            return;
        }
        this.handler.post(r0);
        AppMethodBeat.o(29548);
    }
}
