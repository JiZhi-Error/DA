package com.tencent.wecall.talkroom.model;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class g {
    List<a> callbacks = new LinkedList();
    Handler handler = new Handler(Looper.getMainLooper());

    public interface a {
        void F(String str, byte[] bArr);

        void Rd(int i2);

        void Ri(int i2);

        void a(int i2, MultiTalkGroup multiTalkGroup);

        void asG(int i2);

        void asH(int i2);

        void b(MultiTalkGroup multiTalkGroup);

        void bgz();

        void dH(String str, boolean z);

        void enG();

        void enH();

        void enI();

        void f(MultiTalkGroup multiTalkGroup);

        void fz(List<a.as> list);

        void hK(String str, int i2);

        void hrc();

        void hrd();

        void hre();

        void ki(List<MultiTalkGroup> list);

        void n(int i2, Object obj);

        void onStateChanged(int i2);

        void p(MultiTalkGroup multiTalkGroup);

        void q(MultiTalkGroup multiTalkGroup);

        void rv(boolean z);
    }

    public g() {
        AppMethodBeat.i(62692);
        AppMethodBeat.o(62692);
    }

    public final void ki(final List<MultiTalkGroup> list) {
        AppMethodBeat.i(62693);
        AnonymousClass2 r0 = new Runnable() {
            /* class com.tencent.wecall.talkroom.model.g.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(62660);
                synchronized (g.this.callbacks) {
                    try {
                        for (a aVar : g.this.callbacks) {
                            aVar.ki(list);
                        }
                    } finally {
                        AppMethodBeat.o(62660);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            r0.run();
            AppMethodBeat.o(62693);
            return;
        }
        this.handler.post(r0);
        AppMethodBeat.o(62693);
    }

    public final void a(final int i2, final MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.i(62694);
        AnonymousClass4 r0 = new Runnable() {
            /* class com.tencent.wecall.talkroom.model.g.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(62662);
                synchronized (g.this.callbacks) {
                    try {
                        for (a aVar : g.this.callbacks) {
                            aVar.a(i2, multiTalkGroup);
                        }
                    } finally {
                        AppMethodBeat.o(62662);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            r0.run();
            AppMethodBeat.o(62694);
            return;
        }
        this.handler.post(r0);
        AppMethodBeat.o(62694);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(62695);
        synchronized (aVar) {
            try {
                if (!this.callbacks.contains(aVar)) {
                    this.callbacks.add(aVar);
                    AppMethodBeat.o(62695);
                }
            } finally {
                AppMethodBeat.o(62695);
            }
        }
    }

    public final void n(final int i2, final Object obj) {
        AppMethodBeat.i(62696);
        AnonymousClass7 r0 = new Runnable() {
            /* class com.tencent.wecall.talkroom.model.g.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(62688);
                synchronized (g.this.callbacks) {
                    try {
                        for (a aVar : g.this.callbacks) {
                            aVar.n(i2, obj);
                        }
                    } finally {
                        AppMethodBeat.o(62688);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            r0.run();
            AppMethodBeat.o(62696);
            return;
        }
        this.handler.post(r0);
        AppMethodBeat.o(62696);
    }

    public final void f(final MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.i(62697);
        AnonymousClass8 r0 = new Runnable() {
            /* class com.tencent.wecall.talkroom.model.g.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(62721);
                synchronized (g.this.callbacks) {
                    try {
                        for (a aVar : g.this.callbacks) {
                            aVar.f(multiTalkGroup);
                        }
                    } finally {
                        AppMethodBeat.o(62721);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            r0.run();
            AppMethodBeat.o(62697);
            return;
        }
        this.handler.post(r0);
        AppMethodBeat.o(62697);
    }

    public final void dH(final String str, final boolean z) {
        AppMethodBeat.i(62698);
        AnonymousClass12 r0 = new Runnable() {
            /* class com.tencent.wecall.talkroom.model.g.AnonymousClass12 */

            public final void run() {
                ArrayList<a> arrayList;
                AppMethodBeat.i(62549);
                synchronized (g.this.callbacks) {
                    try {
                        arrayList = new ArrayList(g.this.callbacks);
                    } finally {
                        AppMethodBeat.o(62549);
                    }
                }
                for (a aVar : arrayList) {
                    aVar.dH(str, z);
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            r0.run();
            AppMethodBeat.o(62698);
            return;
        }
        this.handler.post(r0);
        AppMethodBeat.o(62698);
    }

    public final void onStateChanged(final int i2) {
        AppMethodBeat.i(62699);
        AnonymousClass13 r0 = new Runnable() {
            /* class com.tencent.wecall.talkroom.model.g.AnonymousClass13 */

            public final void run() {
                AppMethodBeat.i(183712);
                synchronized (g.this.callbacks) {
                    try {
                        for (a aVar : g.this.callbacks) {
                            aVar.onStateChanged(i2);
                        }
                    } finally {
                        AppMethodBeat.o(183712);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            r0.run();
            AppMethodBeat.o(62699);
            return;
        }
        this.handler.post(r0);
        AppMethodBeat.o(62699);
    }

    public final void hK(final String str, final int i2) {
        AppMethodBeat.i(62700);
        com.tencent.pb.common.c.g.runOnMainThread(new Runnable() {
            /* class com.tencent.wecall.talkroom.model.g.AnonymousClass16 */

            public final void run() {
                AppMethodBeat.i(199669);
                synchronized (g.this.callbacks) {
                    try {
                        for (a aVar : g.this.callbacks) {
                            aVar.hK(str, i2);
                        }
                    } finally {
                        AppMethodBeat.o(199669);
                    }
                }
            }
        });
        AppMethodBeat.o(62700);
    }
}
