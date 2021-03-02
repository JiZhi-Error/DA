package com.tencent.mm.videocomposition.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 15}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/videocomposition/render/RenderProcessCallbackList;", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallback;", "()V", "callbackList", "Ljava/util/LinkedList;", "addCallback", "", "callback", "onFrameStart", "pts", "", "onRelease", "removeCallback", "video_composition_release"})
public final class f implements e {
    private final LinkedList<e> NNT = new LinkedList<>();

    public f() {
        AppMethodBeat.i(216851);
        AppMethodBeat.o(216851);
    }

    public final void b(e eVar) {
        AppMethodBeat.i(216848);
        p.h(eVar, "callback");
        synchronized (this.NNT) {
            try {
                if (!this.NNT.contains(eVar)) {
                    this.NNT.add(eVar);
                }
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(216848);
            }
        }
    }

    @Override // com.tencent.mm.videocomposition.b.e
    public final void KM(long j2) {
        AppMethodBeat.i(216849);
        synchronized (this.NNT) {
            try {
                Iterator<T> it = this.NNT.iterator();
                while (it.hasNext()) {
                    it.next().KM(j2);
                }
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(216849);
            }
        }
    }

    @Override // com.tencent.mm.videocomposition.b.e
    public final void onRelease() {
        AppMethodBeat.i(216850);
        synchronized (this.NNT) {
            try {
                Iterator<T> it = this.NNT.iterator();
                while (it.hasNext()) {
                    it.next().onRelease();
                }
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(216850);
            }
        }
    }
}
