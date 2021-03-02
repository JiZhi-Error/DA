package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\f\b\u0017\u0018\u00002\u00020C:\u0005JKLMNB\u0007¢\u0006\u0004\b\u0001\u0010\u0002J\u0019\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u0003¢\u0006\u0004\b\u0006\u0010\u0007J,\u0010\u000b\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\u000e\b\u0004\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\b¢\u0006\u0004\b\u000b\u0010\fJ4\u0010\u000f\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\u0016\u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0003\u0012\u0004\u0012\u00020\t0\rH\b¢\u0006\u0004\b\u000f\u0010\u0010JD\u0010\u0011\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\u0016\u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0003\u0012\u0004\u0012\u00020\t0\r2\u000e\b\u0004\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\b¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0014\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u0003H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\u001a\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ)\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d\"\f\b\u0000\u0010\u001c*\u00060\u0000j\u0002`\u00032\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\f\u0012\b\u0012\u00060\u0000j\u0002`\u00030 ¢\u0006\u0004\b!\u0010\"J \u0010$\u001a\u00060\u0000j\u0002`\u00032\n\u0010#\u001a\u00060\u0000j\u0002`\u0003H\u0010¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00052\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u0003H\u0002¢\u0006\u0004\b&\u0010\u0007J\r\u0010'\u001a\u00020\u0005¢\u0006\u0004\b'\u0010\u0002J\u000f\u0010(\u001a\u00020\u0005H\u0001¢\u0006\u0004\b(\u0010\u0002J,\u0010*\u001a\u00020)2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\u000e\b\u0004\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\b¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0003H\u0014¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\tH\u0016¢\u0006\u0004\b.\u0010/J.\u00100\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u001c\u0018\u00012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\rH\b¢\u0006\u0004\b0\u00101J\u0015\u00102\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0003¢\u0006\u0004\b2\u0010-J\u0017\u00103\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0003H\u0001¢\u0006\u0004\b3\u0010-J\u000f\u00105\u001a\u000204H\u0002¢\u0006\u0004\b5\u00106J\u000f\u00108\u001a\u000207H\u0016¢\u0006\u0004\b8\u00109J/\u0010<\u001a\u00020;2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u00032\u0006\u0010:\u001a\u00020)H\u0001¢\u0006\u0004\b<\u0010=J'\u0010A\u001a\u00020\u00052\n\u0010>\u001a\u00060\u0000j\u0002`\u00032\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u0003H\u0000¢\u0006\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020\t8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bB\u0010/R\u0013\u0010\u0013\u001a\u00020C8F@\u0006¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0017\u0010G\u001a\u00060\u0000j\u0002`\u00038F@\u0006¢\u0006\u0006\u001a\u0004\bF\u0010-R\u0017\u0010I\u001a\u00060\u0000j\u0002`\u00038F@\u0006¢\u0006\u0006\u001a\u0004\bH\u0010-¨\u0006O"}, hxF = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "<init>", "()V", "Lkotlinx/coroutines/internal/Node;", "node", "", "addLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlin/Function0;", "", "condition", "addLastIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Z", "Lkotlin/Function1;", "predicate", "addLastIfPrev", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;)Z", "addLastIfPrevAndIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Z", "next", "addNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "addOneIfEmpty", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "correctPrev", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "describeAddLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "describeRemoveFirst", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "current", "findPrevNonRemoved", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "finishAdd", "helpRemove", "helpRemovePrev", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "makeCondAddOp", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "nextIfRemoved", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "remove", "()Z", "removeFirstIfIsInstanceOfOrPeekIf", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "removeFirstOrNull", "removeOrNext", "Lkotlinx/coroutines/internal/Removed;", "removed", "()Lkotlinx/coroutines/internal/Removed;", "", "toString", "()Ljava/lang/String;", "condAdd", "", "tryCondAddNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;)I", "prev", "validateNode$kotlinx_coroutines_core", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "validateNode", "isRemoved", "", "getNext", "()Ljava/lang/Object;", "getNextNode", "nextNode", "getPrevNode", "prevNode", "AbstractAtomicDesc", "AddLastDesc", "CondAddOp", "PrepareOp", "RemoveFirstDesc", "kotlinx-coroutines-core"})
public class k {
    static final AtomicReferenceFieldUpdater TVO = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_next");
    static final AtomicReferenceFieldUpdater TVP = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_prev");
    private static final AtomicReferenceFieldUpdater TVQ = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_removedRef");
    volatile Object _next = this;
    volatile Object _prev = this;
    private volatile Object _removedRef = null;

    static {
        AppMethodBeat.i(118104);
        AppMethodBeat.o(118104);
    }

    public k() {
        AppMethodBeat.i(118102);
        AppMethodBeat.o(118102);
    }

    public static final /* synthetic */ void a(k kVar, k kVar2) {
        AppMethodBeat.i(118103);
        kVar.d(kVar2);
        AppMethodBeat.o(118103);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b!\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0011\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\u0002j\u0002`\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "newNode", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "oldNext", "complete", "", "affected", "failure", "", "kotlinx-coroutines-core"})
    public static abstract class a extends c<k> {
        public k TVR;
        public final k TVS;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlinx.coroutines.internal.c
        public final /* synthetic */ void Z(k kVar, Object obj) {
            k kVar2 = kVar;
            boolean z = obj == null;
            k kVar3 = z ? this.TVS : this.TVR;
            if (kVar3 != null && k.TVO.compareAndSet(kVar2, this, kVar3) && z) {
                k kVar4 = this.TVS;
                k kVar5 = this.TVR;
                if (kVar5 == null) {
                    p.hyc();
                }
                k.a(kVar4, kVar5);
            }
        }

        public a(k kVar) {
            this.TVS = kVar;
        }
    }

    public boolean isRemoved() {
        AppMethodBeat.i(192462);
        boolean z = hNI() instanceof r;
        AppMethodBeat.o(192462);
        return z;
    }

    public final k hNJ() {
        AppMethodBeat.i(258812);
        k gf = j.gf(hNI());
        AppMethodBeat.o(258812);
        return gf;
    }

    public final k hNK() {
        AppMethodBeat.i(192464);
        k hNL = hNL();
        if (hNL == null) {
            hNL = b((k) this._prev);
        }
        AppMethodBeat.o(192464);
        return hNL;
    }

    private static k b(k kVar) {
        AppMethodBeat.i(192465);
        while (kVar.isRemoved()) {
            kVar = (k) kVar._prev;
        }
        AppMethodBeat.o(192465);
        return kVar;
    }

    public final boolean c(k kVar) {
        AppMethodBeat.i(118094);
        TVP.lazySet(kVar, this);
        TVO.lazySet(kVar, this);
        while (hNI() == this) {
            if (TVO.compareAndSet(this, this, kVar)) {
                kVar.d(this);
                AppMethodBeat.o(118094);
                return true;
            }
        }
        AppMethodBeat.o(118094);
        return false;
    }

    public final int a(k kVar, k kVar2, a aVar) {
        AppMethodBeat.i(118095);
        TVP.lazySet(kVar, this);
        TVO.lazySet(kVar, kVar2);
        aVar.TVR = kVar2;
        if (!TVO.compareAndSet(this, kVar2, aVar)) {
            AppMethodBeat.o(118095);
            return 0;
        } else if (aVar.ge(this) == null) {
            AppMethodBeat.o(118095);
            return 1;
        } else {
            AppMethodBeat.o(118095);
            return 2;
        }
    }

    private final k hNL() {
        Object obj;
        AppMethodBeat.i(192466);
        while (true) {
            k kVar = (k) this._prev;
            k kVar2 = null;
            k kVar3 = kVar;
            while (true) {
                Object obj2 = kVar3._next;
                if (obj2 == this) {
                    if (kVar == kVar3) {
                        AppMethodBeat.o(192466);
                        return kVar3;
                    } else if (TVP.compareAndSet(this, kVar, kVar3)) {
                        AppMethodBeat.o(192466);
                        return kVar3;
                    }
                } else if (isRemoved()) {
                    AppMethodBeat.o(192466);
                    return null;
                } else if (obj2 == null) {
                    AppMethodBeat.o(192466);
                    return kVar3;
                } else if (obj2 instanceof q) {
                    ((q) obj2).ge(kVar3);
                    break;
                } else {
                    if (obj2 instanceof r) {
                        if (kVar2 != null) {
                            if (!TVO.compareAndSet(kVar2, kVar3, ((r) obj2).TWe)) {
                                break;
                            }
                            kVar3 = kVar2;
                            kVar2 = null;
                        } else {
                            obj = kVar3._prev;
                        }
                    } else if (obj2 == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                        AppMethodBeat.o(192466);
                        throw tVar;
                    } else {
                        obj = obj2;
                        kVar2 = kVar3;
                    }
                    kVar3 = (k) obj;
                }
            }
        }
    }

    public String toString() {
        AppMethodBeat.i(118101);
        String str = getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
        AppMethodBeat.o(118101);
        return str;
    }

    public final Object hNI() {
        AppMethodBeat.i(118091);
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof q)) {
                AppMethodBeat.o(118091);
                return obj;
            }
            ((q) obj).ge(this);
        }
    }

    private final void d(k kVar) {
        k kVar2;
        AppMethodBeat.i(118097);
        do {
            kVar2 = (k) kVar._prev;
            if (hNI() != kVar) {
                AppMethodBeat.o(118097);
                return;
            }
        } while (!TVP.compareAndSet(kVar, kVar2, this));
        if (isRemoved()) {
            kVar.hNL();
        }
        AppMethodBeat.o(118097);
    }

    public boolean remove() {
        k kVar;
        AppMethodBeat.i(118096);
        while (true) {
            Object hNI = hNI();
            if (!(hNI instanceof r)) {
                if (hNI != this) {
                    if (hNI != null) {
                        k kVar2 = (k) hNI;
                        r rVar = (r) kVar2._removedRef;
                        if (rVar == null) {
                            rVar = new r(kVar2);
                            TVQ.lazySet(kVar2, rVar);
                        }
                        if (TVO.compareAndSet(this, hNI, rVar)) {
                            ((k) hNI).hNL();
                            kVar = null;
                            break;
                        }
                    } else {
                        t tVar = new t("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                        AppMethodBeat.o(118096);
                        throw tVar;
                    }
                } else {
                    kVar = (k) hNI;
                    break;
                }
            } else {
                kVar = ((r) hNI).TWe;
                break;
            }
        }
        if (kVar == null) {
            AppMethodBeat.o(118096);
            return true;
        }
        AppMethodBeat.o(118096);
        return false;
    }
}
