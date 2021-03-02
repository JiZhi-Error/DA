package com.tencent.mm.danmaku.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.a.g;
import com.tencent.mm.danmaku.b.a;
import com.tencent.mm.danmaku.d.f;
import com.tencent.mm.danmaku.d.g;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e {
    final f gNv;
    final List<a> gOk;
    final g<a> gOl;
    private final AtomicBoolean gOm;
    volatile long gOn = -1;

    public e(f fVar, g.a aVar) {
        AppMethodBeat.i(241637);
        this.gNv = fVar;
        this.gOl = new com.tencent.mm.danmaku.d.g<>(aVar, new g.b<a>() {
            /* class com.tencent.mm.danmaku.a.e.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, long] */
            @Override // com.tencent.mm.danmaku.d.g.b
            public final /* synthetic */ int m(a aVar, long j2) {
                AppMethodBeat.i(241636);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    long time = aVar2.getTime() - j2;
                    if (time == 0) {
                        AppMethodBeat.o(241636);
                        return 0;
                    } else if (time > 0) {
                        AppMethodBeat.o(241636);
                        return 1;
                    }
                }
                AppMethodBeat.o(241636);
                return -1;
            }
        });
        this.gOk = new LinkedList();
        this.gOm = new AtomicBoolean(false);
        AppMethodBeat.o(241637);
    }

    /* access modifiers changed from: package-private */
    public final void aa(List<a> list) {
        AppMethodBeat.i(241638);
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = list.get(size);
            if (aVar.getTime() <= this.gOn) {
                aVar.asu();
            }
        }
        AppMethodBeat.o(241638);
    }

    public final a asl() {
        AppMethodBeat.i(241639);
        a peekFirst = this.gOl.peekFirst();
        AppMethodBeat.o(241639);
        return peekFirst;
    }

    public final void clear() {
        AppMethodBeat.i(241640);
        com.tencent.mm.danmaku.e.e.v("DanmakuDataSource", "clear danmaku queue");
        asm();
        this.gOl.clear();
        asn();
        AppMethodBeat.o(241640);
    }

    /* access modifiers changed from: package-private */
    public final void asm() {
        AppMethodBeat.i(241641);
        while (!this.gOm.compareAndSet(false, true)) {
            com.tencent.mm.danmaku.e.e.d("DanmakuDataSource", "lock is blocked");
            Thread.yield();
        }
        AppMethodBeat.o(241641);
    }

    /* access modifiers changed from: package-private */
    public final void asn() {
        AppMethodBeat.i(241642);
        while (!this.gOm.compareAndSet(true, false)) {
            com.tencent.mm.danmaku.e.e.e("DanmakuDataSource", "update end is blocked! this can not happend!");
            Thread.yield();
        }
        AppMethodBeat.o(241642);
    }
}
