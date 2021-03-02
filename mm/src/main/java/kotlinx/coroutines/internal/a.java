package kotlinx.coroutines.internal;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.a.e;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0013\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u000eJ\b\u0010\u0012\u001a\u00020\u000eH\u0002J\r\u0010\u0013\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0014R\u0018\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005X\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u000e\u0010\f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lkotlinx/coroutines/internal/ArrayQueue;", "T", "", "()V", MessengerShareContentUtility.ELEMENTS, "", "[Ljava/lang/Object;", "head", "", "isEmpty", "", "()Z", "tail", "addLast", "", "element", "(Ljava/lang/Object;)V", "clear", "ensureCapacity", "removeFirstOrNull", "()Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class a<T> {
    private Object[] TVw = new Object[16];
    private int TVx;
    private int TVy;

    public a() {
        AppMethodBeat.i(118120);
        AppMethodBeat.o(118120);
    }

    public final boolean isEmpty() {
        return this.TVx == this.TVy;
    }

    public final void addLast(T t) {
        AppMethodBeat.i(118117);
        this.TVw[this.TVy] = t;
        this.TVy = (this.TVy + 1) & (this.TVw.length - 1);
        if (this.TVy == this.TVx) {
            hND();
        }
        AppMethodBeat.o(118117);
    }

    public final T hNC() {
        AppMethodBeat.i(118118);
        if (this.TVx == this.TVy) {
            AppMethodBeat.o(118118);
            return null;
        }
        T t = (T) this.TVw[this.TVx];
        this.TVw[this.TVx] = null;
        this.TVx = (this.TVx + 1) & (this.TVw.length - 1);
        if (t == null) {
            t tVar = new t("null cannot be cast to non-null type T");
            AppMethodBeat.o(118118);
            throw tVar;
        }
        AppMethodBeat.o(118118);
        return t;
    }

    private final void hND() {
        AppMethodBeat.i(118119);
        int length = this.TVw.length;
        Object[] objArr = new Object[(length << 1)];
        e.a(this.TVw, objArr, 0, this.TVx, 0, 10);
        e.a(this.TVw, objArr, this.TVw.length - this.TVx, 0, this.TVx, 4);
        this.TVw = objArr;
        this.TVx = 0;
        this.TVy = length;
        AppMethodBeat.o(118119);
    }
}
