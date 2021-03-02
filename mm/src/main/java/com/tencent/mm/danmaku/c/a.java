package com.tencent.mm.danmaku.c;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.b.c;
import com.tencent.mm.danmaku.d.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a {
    private static final String TAG = a.class.getSimpleName();
    private static m gPp;
    private static c gPq;
    private static k gPw;
    private boolean cFH;
    private c gPA;
    private List<com.tencent.mm.danmaku.render.a> gPB;
    private com.tencent.mm.danmaku.render.c gPC;
    private int gPD;
    public final d<Drawable> gPo;
    private final SparseArray<i> gPr;
    private boolean gPs;
    private h gPt;
    private f gPu;
    private e gPv;
    private j gPx;
    public g gPy;
    public d gPz;

    /* synthetic */ a(C0311a aVar, byte b2) {
        this(aVar);
    }

    static {
        AppMethodBeat.i(241692);
        AppMethodBeat.o(241692);
    }

    private a(C0311a aVar) {
        AppMethodBeat.i(241684);
        this.gPr = new SparseArray<>();
        this.gPs = false;
        this.gPC = new com.tencent.mm.danmaku.render.c();
        this.gPs = aVar.gPs;
        this.gPt = aVar.gPt;
        this.gPu = aVar.gPu;
        this.gPv = aVar.gPv;
        gPw = aVar.gPE;
        this.gPx = aVar.gPx;
        this.gPy = aVar.gPy;
        this.gPz = aVar.gPz;
        this.gPA = aVar.gPA;
        this.gPD = aVar.gPD;
        this.cFH = aVar.cFH;
        this.gPo = new d<>();
        this.gPB = new ArrayList();
        this.gPB.addAll(aVar.gPB);
        if (this.gPs || this.gPt != null) {
            AppMethodBeat.o(241684);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Danmaku module need an IDanmakuPlayTimeSupplier or is live setter for computing timeline");
        AppMethodBeat.o(241684);
        throw illegalArgumentException;
    }

    public final com.tencent.mm.danmaku.render.a e(com.tencent.mm.danmaku.b.a aVar) {
        com.tencent.mm.danmaku.render.a aVar2;
        AppMethodBeat.i(241685);
        Iterator<com.tencent.mm.danmaku.render.a> it = this.gPB.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar2 = null;
                break;
            }
            aVar2 = it.next();
            if (aVar2.f(aVar)) {
                break;
            }
        }
        if (aVar2 == null) {
            aVar2 = this.gPC;
        }
        AppMethodBeat.o(241685);
        return aVar2;
    }

    public static m asO() {
        AppMethodBeat.i(241686);
        if (gPp == null) {
            synchronized (a.class) {
                try {
                    if (gPp == null && gPw != null) {
                        gPp = gPw.asW();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(241686);
                    throw th;
                }
            }
        }
        if (gPp == null) {
            gPp = new m();
        }
        m mVar = gPp;
        AppMethodBeat.o(241686);
        return mVar;
    }

    public final i oZ(int i2) {
        AppMethodBeat.i(241687);
        i iVar = this.gPr.get(i2);
        if (iVar == null) {
            synchronized (a.class) {
                try {
                    iVar = this.gPr.get(i2);
                    if (iVar == null && this.gPx != null) {
                        iVar = this.gPx.asV();
                        this.gPr.put(i2, iVar);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(241687);
                    throw th;
                }
            }
        }
        if (iVar == null) {
            iVar = asP();
        }
        AppMethodBeat.o(241687);
        return iVar;
    }

    private static c asP() {
        AppMethodBeat.i(241688);
        if (gPq == null) {
            synchronized (a.class) {
                try {
                    if (gPq == null) {
                        gPq = new c();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(241688);
                    throw th;
                }
            }
        }
        c cVar = gPq;
        AppMethodBeat.o(241688);
        return cVar;
    }

    public final boolean isLive() {
        AppMethodBeat.i(241689);
        if (this.gPs || asQ() < 0) {
            AppMethodBeat.o(241689);
            return true;
        }
        AppMethodBeat.o(241689);
        return false;
    }

    public final long asQ() {
        AppMethodBeat.i(241690);
        if (this.gPt == null) {
            AppMethodBeat.o(241690);
            return -1;
        }
        long asQ = this.gPt.asQ();
        AppMethodBeat.o(241690);
        return asQ;
    }

    public static C0311a asR() {
        AppMethodBeat.i(241691);
        C0311a aVar = new C0311a((byte) 0);
        AppMethodBeat.o(241691);
        return aVar;
    }

    /* renamed from: com.tencent.mm.danmaku.c.a$a  reason: collision with other inner class name */
    public static final class C0311a {
        boolean cFH;
        c gPA;
        List<com.tencent.mm.danmaku.render.a> gPB;
        int gPD;
        k gPE;
        boolean gPs;
        h gPt;
        f gPu;
        e gPv;
        j gPx;
        public g gPy;
        public d gPz;

        /* synthetic */ C0311a(byte b2) {
            this();
        }

        private C0311a() {
            AppMethodBeat.i(241681);
            this.gPB = new ArrayList();
            this.cFH = false;
            AppMethodBeat.o(241681);
        }

        public final C0311a a(h hVar) {
            this.gPt = hVar;
            return this;
        }

        public final C0311a a(com.tencent.mm.danmaku.render.a aVar) {
            AppMethodBeat.i(241682);
            this.gPB.add(aVar);
            AppMethodBeat.o(241682);
            return this;
        }

        public final C0311a a(d dVar) {
            this.gPz = dVar;
            return this;
        }

        public final a asS() {
            AppMethodBeat.i(241683);
            a aVar = new a(this, (byte) 0);
            AppMethodBeat.o(241683);
            return aVar;
        }
    }
}
