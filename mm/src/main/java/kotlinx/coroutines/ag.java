package kotlinx.coroutines;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0018B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\t\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, hxF = {"Lkotlinx/coroutines/CoroutineId;", "Lkotlinx/coroutines/ThreadContextElement;", "", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "id", "", "(J)V", "getId", "()J", "component1", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "toString", "updateThreadContext", "Key", "kotlinx-coroutines-core"})
public final class ag extends kotlin.d.a implements co<String> {
    public static final a TTV = new a((byte) 0);
    final long id;

    static {
        AppMethodBeat.i(118241);
        AppMethodBeat.o(118241);
    }

    public final boolean equals(Object obj) {
        return this == obj || ((obj instanceof ag) && this.id == ((ag) obj).id);
    }

    public final int hashCode() {
        long j2 = this.id;
        return (int) (j2 ^ (j2 >>> 32));
    }

    public ag(long j2) {
        super(TTV);
        AppMethodBeat.i(118240);
        this.id = j2;
        AppMethodBeat.o(118240);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlinx.coroutines.co
    public final /* synthetic */ void fR(String str) {
        AppMethodBeat.i(192374);
        Thread.currentThread().setName(str);
        AppMethodBeat.o(192374);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, hxF = {"Lkotlinx/coroutines/CoroutineId$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineId;", "()V", "kotlinx-coroutines-core"})
    public static final class a implements f.c<ag> {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final String toString() {
        AppMethodBeat.i(118237);
        String str = "CoroutineId(" + this.id + ')';
        AppMethodBeat.o(118237);
        return str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlinx.coroutines.co
    public final /* synthetic */ String b(f fVar) {
        String str;
        String str2;
        AppMethodBeat.i(118238);
        ah ahVar = (ah) fVar.get(ah.TTW);
        if (ahVar == null || (str2 = ahVar.name) == null) {
            str = "coroutine";
        } else {
            str = str2;
        }
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        int g2 = n.g(name, " @");
        if (g2 < 0) {
            g2 = name.length();
        }
        StringBuilder sb = new StringBuilder(str.length() + g2 + 10);
        if (name == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(118238);
            throw tVar;
        }
        String substring = name.substring(0, g2);
        p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        sb.append(substring);
        sb.append(" @");
        sb.append(str);
        sb.append('#');
        sb.append(this.id);
        String sb2 = sb.toString();
        p.g(sb2, "StringBuilder(capacity).…builderAction).toString()");
        currentThread.setName(sb2);
        AppMethodBeat.o(118238);
        return name;
    }

    @Override // kotlin.d.a, kotlin.d.f
    public final <R> R fold(R r, m<? super R, ? super f.b, ? extends R> mVar) {
        AppMethodBeat.i(118242);
        R r2 = (R) f.b.a.a(this, r, mVar);
        AppMethodBeat.o(118242);
        return r2;
    }

    @Override // kotlin.d.f.b, kotlin.d.a, kotlin.d.f
    public final <E extends f.b> E get(f.c<E> cVar) {
        AppMethodBeat.i(118243);
        E e2 = (E) f.b.a.a(this, cVar);
        AppMethodBeat.o(118243);
        return e2;
    }

    @Override // kotlin.d.a, kotlin.d.f
    public final f minusKey(f.c<?> cVar) {
        AppMethodBeat.i(118244);
        f b2 = f.b.a.b(this, cVar);
        AppMethodBeat.o(118244);
        return b2;
    }

    @Override // kotlin.d.a, kotlin.d.f
    public final f plus(f fVar) {
        AppMethodBeat.i(118245);
        f a2 = f.b.a.a(this, fVar);
        AppMethodBeat.o(118245);
        return a2;
    }
}
