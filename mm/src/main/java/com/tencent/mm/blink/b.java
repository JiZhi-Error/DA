package com.tencent.mm.blink;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.h.h;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b {
    private static b gkG = new b();
    private final Queue<a> gkH = new LinkedList();
    private boolean gkI = false;
    private volatile boolean gkJ = false;
    private boolean gkK = true;
    private volatile c gkL = g.hdG();
    private AtomicBoolean gkM = new AtomicBoolean(false);
    private MMHandler gkN = new MMHandler("pending-stage");

    public b() {
        AppMethodBeat.i(131823);
        AppMethodBeat.o(131823);
    }

    static /* synthetic */ void a(b bVar, EnumC0279b bVar2) {
        AppMethodBeat.i(131831);
        bVar.a(bVar2);
        AppMethodBeat.o(131831);
    }

    static /* synthetic */ void b(b bVar) {
        AppMethodBeat.i(131830);
        bVar.akl();
        AppMethodBeat.o(131830);
    }

    static {
        AppMethodBeat.i(131832);
        AppMethodBeat.o(131832);
    }

    public static b ake() {
        return gkG;
    }

    public final synchronized void akf() {
        this.gkI = true;
    }

    public final synchronized void akg() {
        AppMethodBeat.i(131824);
        this.gkK = true;
        if (this.gkI) {
            akk();
        }
        AppMethodBeat.o(131824);
    }

    public final synchronized void akh() {
        this.gkK = false;
    }

    public final synchronized void aki() {
        AppMethodBeat.i(131825);
        if (this.gkI) {
            this.gkI = false;
            akk();
        }
        AppMethodBeat.o(131825);
    }

    public final synchronized void arrange(Runnable runnable) {
        AppMethodBeat.i(131826);
        d current = d.current();
        if (!(current instanceof com.tencent.mm.vending.h.c)) {
            com.tencent.mm.vending.h.g.a(current.getType(), current);
        }
        if (!akj()) {
            Log.i("MicroMsg.FirstScreenArrangement", "arrange first screen runnable: %s, %s, %s, %s", Boolean.valueOf(this.gkI), Boolean.valueOf(this.gkK), Boolean.valueOf(this.gkJ), this.gkH);
            this.gkH.add(new a(runnable, current));
            AppMethodBeat.o(131826);
        } else {
            Log.i("MicroMsg.FirstScreenArrangement", "FirstScreenArrangement arrange runnable postToMainThread %s", runnable);
            this.gkL.c(new a(runnable, current));
            AppMethodBeat.o(131826);
        }
    }

    private synchronized boolean akj() {
        return (!this.gkI || this.gkK) && this.gkJ;
    }

    /* access modifiers changed from: package-private */
    public static class a implements e {
        private Runnable mRunnable;
        private d mScheduler;

        public a(Runnable runnable, d dVar) {
            this.mRunnable = runnable;
            this.mScheduler = dVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final Object call(Object obj) {
            AppMethodBeat.i(131818);
            Log.i("MicroMsg.FirstScreenArrangement", "FirstScreenArrangement tryConsumingWaitingQueue runnable %s, %s", this.mRunnable, this.mScheduler.getType());
            try {
                if (this.mRunnable != null) {
                    this.mRunnable.run();
                } else {
                    Log.e("MicroMsg.FirstScreenArrangement", "ERROR: FirstScreenArrangement gonna retry!");
                }
                return null;
            } finally {
                this.mRunnable = null;
                AppMethodBeat.o(131818);
            }
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            AppMethodBeat.i(131819);
            if (!(this.mScheduler instanceof com.tencent.mm.vending.h.c)) {
                String type = this.mScheduler.getType();
                AppMethodBeat.o(131819);
                return type;
            } else if (d.current() instanceof com.tencent.mm.vending.h.c) {
                String type2 = d.UI.getType();
                AppMethodBeat.o(131819);
                return type2;
            } else {
                String type3 = d.current().getType();
                AppMethodBeat.o(131819);
                return type3;
            }
        }
    }

    private void akk() {
        AppMethodBeat.i(131827);
        a(EnumC0279b.FirstScreen);
        akl();
        AppMethodBeat.o(131827);
    }

    private synchronized void akl() {
        AppMethodBeat.i(131828);
        if (!akj()) {
            AppMethodBeat.o(131828);
        } else {
            while (true) {
                a poll = this.gkH.poll();
                if (poll == null) {
                    break;
                }
                Log.i("MicroMsg.FirstScreenArrangement", "FirstScreenArrangement tryConsumingWaitingQueue runnable %s, %s", poll.mRunnable, poll.mScheduler.getType());
                this.gkL.c(poll);
            }
            AppMethodBeat.o(131828);
        }
    }

    /* renamed from: com.tencent.mm.blink.b$b  reason: collision with other inner class name */
    public enum EnumC0279b {
        Now,
        Timeout,
        FirstScreen;

        public static EnumC0279b valueOf(String str) {
            AppMethodBeat.i(131821);
            EnumC0279b bVar = (EnumC0279b) Enum.valueOf(EnumC0279b.class, str);
            AppMethodBeat.o(131821);
            return bVar;
        }

        static {
            AppMethodBeat.i(131822);
            AppMethodBeat.o(131822);
        }
    }

    public final void a(final EnumC0279b bVar) {
        AppMethodBeat.i(131829);
        if (!this.gkM.compareAndSet(false, true)) {
            AppMethodBeat.o(131829);
        } else if (bVar == EnumC0279b.Now) {
            Log.i("MicroMsg.FirstScreenArrangement", "initialize pending plugins from %s", bVar);
            com.tencent.mm.kernel.a.c.aAu().aAx();
            synchronized (this) {
                try {
                    this.gkJ = true;
                    akl();
                } finally {
                    AppMethodBeat.o(131829);
                }
            }
        } else {
            h hVar = new h(new com.tencent.mm.co.d(this.gkN), "pending-stage");
            synchronized (this) {
                try {
                    this.gkL.b(hVar).c(new com.tencent.mm.vending.c.a<Object, Void>() {
                        /* class com.tencent.mm.blink.b.AnonymousClass1 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.tencent.mm.vending.c.a
                        public final /* synthetic */ Object call(Void r3) {
                            AppMethodBeat.i(131816);
                            Object akm = akm();
                            AppMethodBeat.o(131816);
                            return akm;
                        }

                        private Object akm() {
                            AppMethodBeat.i(131815);
                            Log.i("MicroMsg.FirstScreenArrangement", "initialize pending plugins from %s", bVar);
                            com.tencent.mm.kernel.a.c.aAu().aAx();
                            synchronized (this) {
                                try {
                                    b.this.gkJ = true;
                                    b.b(b.this);
                                } catch (Throwable th) {
                                    AppMethodBeat.o(131815);
                                    throw th;
                                }
                            }
                            AppMethodBeat.o(131815);
                            return null;
                        }
                    });
                } finally {
                    AppMethodBeat.o(131829);
                }
            }
        }
    }
}
