package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.a.a;
import kotlin.d.b.a.e;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.af;
import kotlin.l;
import kotlin.t;
import kotlinx.coroutines.an;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.cs;
import kotlinx.coroutines.internal.s;
import kotlinx.coroutines.v;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a9\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u001a\u0010\u0005\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\b\u001a>\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\t\u001aR\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u0002*\u001e\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b2\u0006\u0010\f\u001a\u0002H\n2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a>\u0010\u000e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\t\u001aR\u0010\u000e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u0002*\u001e\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b2\u0006\u0010\f\u001a\u0002H\n2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\r\u001aY\u0010\u000f\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u0002H\u00020\u00102\u0006\u0010\f\u001a\u0002H\n2'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b¢\u0006\u0002\b\u0011H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aY\u0010\u0013\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u0002H\u00020\u00102\u0006\u0010\f\u001a\u0002H\n2'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b¢\u0006\u0002\b\u0011H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a?\u0010\u0014\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00102\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00062\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0019H\b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, hxF = {"startDirect", "", "T", "completion", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/Function1;", "", "startCoroutineUndispatched", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "startCoroutineUnintercepted", "startUndispatchedOrReturn", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/internal/ScopeCoroutine;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "startUndispatchedOrReturnIgnoreTimeout", "undispatchedResult", "shouldThrow", "", "", "startBlock", "Lkotlin/Function0;", "kotlinx-coroutines-core"})
public final class b {
    public static final <T, R> Object a(s<? super T> sVar, R r, m<? super R, ? super d<? super T>, ? extends Object> mVar) {
        Object obj;
        Throwable th;
        AppMethodBeat.i(192393);
        sVar.hMl();
        try {
            s<? super T> sVar2 = sVar;
            if (mVar == null) {
                t tVar = new t("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                AppMethodBeat.o(192393);
                throw tVar;
            }
            obj = ((m) af.r(mVar, 2)).invoke(r, sVar2);
            if (obj == a.COROUTINE_SUSPENDED) {
                a aVar = a.COROUTINE_SUSPENDED;
                AppMethodBeat.o(192393);
                return aVar;
            }
            Object fZ = sVar.fZ(obj);
            if (fZ == cb.TVb) {
                a aVar2 = a.COROUTINE_SUSPENDED;
                AppMethodBeat.o(192393);
                return aVar2;
            } else if (fZ instanceof v) {
                Throwable th2 = ((v) fZ).cause;
                d<T> dVar = sVar.TWf;
                if (!an.hML() || !(dVar instanceof e)) {
                    th = th2;
                } else {
                    th = kotlinx.coroutines.internal.t.a(th2, (e) dVar);
                }
                AppMethodBeat.o(192393);
                throw th;
            } else {
                Object gd = cb.gd(fZ);
                AppMethodBeat.o(192393);
                return gd;
            }
        } catch (Throwable th3) {
            obj = new v(th3);
        }
    }

    public static final <T, R> Object b(s<? super T> sVar, R r, m<? super R, ? super d<? super T>, ? extends Object> mVar) {
        Object obj;
        boolean z;
        Throwable th;
        Throwable th2;
        AppMethodBeat.i(192394);
        sVar.hMl();
        try {
            s<? super T> sVar2 = sVar;
            if (mVar == null) {
                t tVar = new t("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                AppMethodBeat.o(192394);
                throw tVar;
            }
            obj = ((m) af.r(mVar, 2)).invoke(r, sVar2);
            if (obj == a.COROUTINE_SUSPENDED) {
                a aVar = a.COROUTINE_SUSPENDED;
                AppMethodBeat.o(192394);
                return aVar;
            }
            Object fZ = sVar.fZ(obj);
            if (fZ == cb.TVb) {
                a aVar2 = a.COROUTINE_SUSPENDED;
                AppMethodBeat.o(192394);
                return aVar2;
            } else if (fZ instanceof v) {
                Throwable th3 = ((v) fZ).cause;
                if (!(th3 instanceof cs) || ((cs) th3).TVm != sVar) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    Throwable th4 = ((v) fZ).cause;
                    d<T> dVar = sVar.TWf;
                    if (!an.hML() || !(dVar instanceof e)) {
                        th2 = th4;
                    } else {
                        th2 = kotlinx.coroutines.internal.t.a(th4, (e) dVar);
                    }
                    AppMethodBeat.o(192394);
                    throw th2;
                } else if (obj instanceof v) {
                    Throwable th5 = ((v) obj).cause;
                    d<T> dVar2 = sVar.TWf;
                    if (!an.hML() || !(dVar2 instanceof e)) {
                        th = th5;
                    } else {
                        th = kotlinx.coroutines.internal.t.a(th5, (e) dVar2);
                    }
                    AppMethodBeat.o(192394);
                    throw th;
                } else {
                    AppMethodBeat.o(192394);
                    return obj;
                }
            } else {
                Object gd = cb.gd(fZ);
                AppMethodBeat.o(192394);
                return gd;
            }
        } catch (Throwable th6) {
            obj = new v(th6);
        }
    }
}
