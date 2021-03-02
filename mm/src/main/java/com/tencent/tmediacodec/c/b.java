package com.tencent.tmediacodec.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmediacodec.a;
import com.tencent.tmediacodec.b.e;
import com.tencent.tmediacodec.b.f;
import com.tencent.tmediacodec.e.a;
import com.tencent.tmediacodec.e.b;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final class b {
    c Smv;
    private final CopyOnWriteArraySet<f> Smw = new CopyOnWriteArraySet<>();
    private final int bwA;
    private final String name;

    public b(int i2, String str) {
        AppMethodBeat.i(190154);
        this.bwA = i2;
        this.name = str;
        AppMethodBeat.o(190154);
    }

    private boolean isFull() {
        AppMethodBeat.i(190155);
        if (this.Smw.size() == this.bwA) {
            AppMethodBeat.o(190155);
            return true;
        }
        AppMethodBeat.o(190155);
        return false;
    }

    public final void j(f fVar) {
        AppMethodBeat.i(190156);
        if (isFull()) {
            l(k(fVar));
        }
        this.Smw.add(fVar);
        AppMethodBeat.o(190156);
    }

    private f k(f fVar) {
        f a2;
        AppMethodBeat.i(190157);
        Iterator<f> it = this.Smw.iterator();
        if (a.hpn().Slb.SmJ != b.a.SAME || (a2 = a(fVar, it)) == null) {
            f hpD = hpD();
            AppMethodBeat.o(190157);
            return hpD;
        }
        AppMethodBeat.o(190157);
        return a2;
    }

    private static f a(f fVar, Iterator it) {
        AppMethodBeat.i(190158);
        while (it.hasNext()) {
            f fVar2 = (f) it.next();
            if (TextUtils.equals(fVar.hpz(), fVar2.hpz())) {
                AppMethodBeat.o(190158);
                return fVar2;
            }
        }
        AppMethodBeat.o(190158);
        return null;
    }

    private f hpD() {
        AppMethodBeat.i(190159);
        Iterator<f> it = this.Smw.iterator();
        if (it.hasNext()) {
            f next = it.next();
            AppMethodBeat.o(190159);
            return next;
        }
        AppMethodBeat.o(190159);
        return null;
    }

    public final void l(f fVar) {
        AppMethodBeat.i(190160);
        if (!this.Smw.remove(fVar)) {
            new StringBuilder("pool:").append(this.name).append(" remove ").append(fVar).append(" not found");
            com.tencent.tmediacodec.g.b.bqS("CodecWrapperPool");
        } else if (this.Smv != null) {
            this.Smv.i(fVar);
            AppMethodBeat.o(190160);
            return;
        }
        AppMethodBeat.o(190160);
    }

    public final f d(e eVar) {
        AppMethodBeat.i(190161);
        f e2 = e(eVar);
        if (com.tencent.tmediacodec.g.b.isLogEnable()) {
            "obtain codecWrapper:".concat(String.valueOf(e2));
            com.tencent.tmediacodec.g.b.bqQ("CodecWrapperPool");
        }
        if (e2 != null) {
            this.Smw.remove(e2);
            AppMethodBeat.o(190161);
            return e2;
        }
        AppMethodBeat.o(190161);
        return null;
    }

    public final void clear() {
        AppMethodBeat.i(190162);
        new StringBuilder("CodecWrapperPool clear:").append(this.Smw);
        com.tencent.tmediacodec.g.b.bqR("CodecWrapperPool");
        Iterator<f> it = this.Smw.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (this.Smv != null) {
                this.Smv.i(next);
            }
        }
        this.Smw.clear();
        AppMethodBeat.o(190162);
    }

    public final String toString() {
        AppMethodBeat.i(190163);
        String str = "size:" + this.Smw.size() + " elements:" + this.Smw;
        AppMethodBeat.o(190163);
        return str;
    }

    private final f e(e eVar) {
        AppMethodBeat.i(190164);
        Iterator<f> it = this.Smw.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (next.aHN || next.a(eVar) == a.b.KEEP_CODEC_RESULT_NO) {
                next.hpx();
                if (next.hpy()) {
                    l(next);
                }
            } else {
                AppMethodBeat.o(190164);
                return next;
            }
        }
        AppMethodBeat.o(190164);
        return null;
    }
}
