package com.tencent.mm.ui.l.a;

import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.d.b.j;
import com.tencent.mm.ui.l.a.a.b;
import com.tencent.mm.ui.m;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedDeque;

public class e {
    g QlU;
    public d QlV = null;
    WeakReference<com.tencent.mm.ui.chatting.e.a> QlW = null;
    bd QlX = null;
    final m QlY = new m() {
        /* class com.tencent.mm.ui.l.a.e.AnonymousClass1 */

        @Override // com.tencent.mm.ui.m
        public final void gIk() {
        }

        @Override // com.tencent.mm.ui.m
        public final void gIl() {
        }

        @Override // com.tencent.mm.ui.m
        public final void gIm() {
        }

        @Override // com.tencent.mm.ui.m
        public final void cFx() {
            AppMethodBeat.i(234380);
            Log.i("MicroMsg.MagicEmojiRuntime", "hy: chatting resume");
            AppMethodBeat.o(234380);
        }

        @Override // com.tencent.mm.ui.m
        public final void cFy() {
            AppMethodBeat.i(234381);
            Log.i("MicroMsg.MagicEmojiRuntime", "hy: chatting pause");
            e.this.Rd();
            AppMethodBeat.o(234381);
        }

        @Override // com.tencent.mm.ui.m
        public final void gIn() {
        }

        @Override // com.tencent.mm.ui.m
        public final void gIo() {
        }
    };
    final ConcurrentLinkedDeque<a> Vmb = new ConcurrentLinkedDeque<>();
    private volatile q kAz = null;
    public final String mAppId;
    public boolean mIsRunning = false;

    public interface a {
        void onDestroy();

        void onPause();
    }

    public e(g gVar) {
        AppMethodBeat.i(234382);
        Log.i("MicroMsg.MagicEmojiRuntime", "hy: establish magic emoji runtime, %s", gVar.getAppId());
        this.mAppId = gVar.getAppId();
        this.QlU = gVar;
        AppMethodBeat.o(234382);
    }

    public final void a(c cVar) {
        AppMethodBeat.i(234383);
        Log.d("MicroMsg.MagicEmojiRuntime", "hy: notify message come %s", cVar.toString());
        com.tencent.mm.ui.chatting.e.a aVar = cVar.QlK.get();
        FrameLayout frameLayout = cVar.QlL.get();
        if (aVar == null || frameLayout == null || !aVar.cQp) {
            Log.w("MicroMsg.MagicEmojiRuntime", "hy: chatting or holder lost. ignore");
            com.tencent.mm.ui.l.b.a.bnK("chatting or holder lost. ignore the msg");
            AppMethodBeat.o(234383);
        } else if (this.QlV == null) {
            Log.e("MicroMsg.MagicEmojiRuntime", "hy: page not prepared!!");
            AppMethodBeat.o(234383);
        } else {
            if (this.QlW == null || aVar != this.QlW.get()) {
                Log.i("MicroMsg.MagicEmojiRuntime", "hy: last chatting released or changed to new chatting");
                if (!(this.QlW == null || this.QlW.get() == null)) {
                    ((j) this.QlW.get().bh(j.class)).b(this.QlY);
                }
                ((j) aVar.bh(j.class)).a(this.QlY);
                this.QlW = new WeakReference<>(aVar);
            }
            this.QlV.e(frameLayout);
            this.QlV.gWD();
            this.QlU.a(cVar);
            Rc();
            AppMethodBeat.o(234383);
        }
    }

    public final q getFileSystem() {
        AppMethodBeat.i(234384);
        if (this.kAz == null) {
            synchronized (this) {
                try {
                    if (this.kAz == null) {
                        this.kAz = new b(this);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(234384);
                    throw th;
                }
            }
        }
        q qVar = this.kAz;
        AppMethodBeat.o(234384);
        return qVar;
    }

    public String bes() {
        return this.QlX.field_pkgPath;
    }

    public String gWF() {
        return this.QlX.field_versionMd5;
    }

    private void Rc() {
        AppMethodBeat.i(259037);
        synchronized (this) {
            try {
                ConcurrentLinkedDeque concurrentLinkedDeque = new ConcurrentLinkedDeque(this.Vmb);
                while (!concurrentLinkedDeque.isEmpty()) {
                    Objects.requireNonNull(concurrentLinkedDeque.poll());
                }
            } catch (Throwable th) {
                AppMethodBeat.o(259037);
                throw th;
            }
        }
        a(this.QlU, true);
        a(this.QlV, true);
        AppMethodBeat.o(259037);
    }

    static void a(a aVar) {
        AppMethodBeat.i(234386);
        if (aVar != null) {
            aVar.notifyDestroy();
        }
        AppMethodBeat.o(234386);
    }

    public final synchronized void a(a aVar) {
        AppMethodBeat.i(259038);
        this.Vmb.add(aVar);
        AppMethodBeat.o(259038);
    }

    static void a(a aVar, boolean z) {
        AppMethodBeat.i(234387);
        if (aVar != null) {
            aVar.CB(z);
        }
        AppMethodBeat.o(234387);
    }

    /* access modifiers changed from: package-private */
    public final void Rd() {
        AppMethodBeat.i(259039);
        synchronized (this) {
            try {
                ConcurrentLinkedDeque concurrentLinkedDeque = new ConcurrentLinkedDeque(this.Vmb);
                while (!concurrentLinkedDeque.isEmpty()) {
                    ((a) Objects.requireNonNull(concurrentLinkedDeque.poll())).onPause();
                }
            } catch (Throwable th) {
                AppMethodBeat.o(259039);
                throw th;
            }
        }
        a(this.QlV, false);
        a(this.QlU, false);
        AppMethodBeat.o(259039);
    }

    public final synchronized void hYO() {
        AppMethodBeat.i(259040);
        if (this.kAz != null) {
            this.kAz.release();
        }
        AppMethodBeat.o(259040);
    }

    public final com.tencent.mm.ui.chatting.e.a gWG() {
        AppMethodBeat.i(234388);
        if (this.QlW != null) {
            com.tencent.mm.ui.chatting.e.a aVar = this.QlW.get();
            AppMethodBeat.o(234388);
            return aVar;
        }
        AppMethodBeat.o(234388);
        return null;
    }
}
