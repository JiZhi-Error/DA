package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;
import kotlin.d.d;
import kotlin.d.e;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlinx.coroutines.a.a;
import kotlinx.coroutines.a.b;
import kotlinx.coroutines.internal.s;
import kotlinx.coroutines.internal.y;

public final /* synthetic */ class g {
    public static /* synthetic */ bu a(ai aiVar, f fVar, ak akVar, m mVar, int i2) {
        kotlin.d.g gVar;
        AppMethodBeat.i(118173);
        if ((i2 & 1) != 0) {
            gVar = kotlin.d.g.SXK;
        } else {
            gVar = fVar;
        }
        if ((i2 & 2) != 0) {
            akVar = ak.DEFAULT;
        }
        bu b2 = f.b(aiVar, gVar, akVar, mVar);
        AppMethodBeat.o(118173);
        return b2;
    }

    public static /* synthetic */ ar b(ai aiVar, f fVar, ak akVar, m mVar, int i2) {
        kotlin.d.g gVar;
        AppMethodBeat.i(192495);
        if ((i2 & 1) != 0) {
            gVar = kotlin.d.g.SXK;
        } else {
            gVar = fVar;
        }
        if ((i2 & 2) != 0) {
            akVar = ak.DEFAULT;
        }
        ar a2 = f.a(aiVar, gVar, akVar, mVar);
        AppMethodBeat.o(192495);
        return a2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v21, resolved type: java.util.concurrent.atomic.AtomicIntegerFieldUpdater */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Object a(f fVar, m<? super ai, ? super d<? super T>, ? extends Object> mVar, d<? super T> dVar) {
        boolean z;
        Object gd;
        AppMethodBeat.i(192496);
        f context = dVar.getContext();
        f plus = context.plus(fVar);
        bu buVar = (bu) plus.get(bu.TUO);
        if (buVar == null || buVar.isActive()) {
            if (plus == context) {
                s sVar = new s(plus, dVar);
                gd = b.a(sVar, sVar, mVar);
            } else if (p.j((e) plus.get(e.SXH), (e) context.get(e.SXH))) {
                cw cwVar = new cw(plus, dVar);
                Object a2 = y.a(plus, null);
                try {
                    gd = b.a(cwVar, cwVar, mVar);
                    y.b(plus, a2);
                } catch (Throwable th) {
                    y.b(plus, a2);
                    AppMethodBeat.o(192496);
                    throw th;
                }
            } else {
                ax axVar = new ax(plus, dVar);
                axVar.hMl();
                a.b(mVar, axVar, axVar);
                while (true) {
                    switch (axVar._decision) {
                        case 0:
                            if (ax.TTC.compareAndSet(axVar, 0, 1)) {
                                z = true;
                                break;
                            }
                        case 1:
                        default:
                            IllegalStateException illegalStateException = new IllegalStateException("Already suspended".toString());
                            AppMethodBeat.o(192496);
                            throw illegalStateException;
                        case 2:
                            z = false;
                            break;
                    }
                }
                if (z) {
                    gd = kotlin.d.a.a.COROUTINE_SUSPENDED;
                } else {
                    gd = cb.gd(axVar.hNm());
                    if (gd instanceof v) {
                        Throwable th2 = ((v) gd).cause;
                        AppMethodBeat.o(192496);
                        throw th2;
                    }
                }
            }
            if (gd == kotlin.d.a.a.COROUTINE_SUSPENDED) {
                p.h(dVar, "frame");
            }
            AppMethodBeat.o(192496);
            return gd;
        }
        CancellationException hNj = buVar.hNj();
        AppMethodBeat.o(192496);
        throw hNj;
    }
}
