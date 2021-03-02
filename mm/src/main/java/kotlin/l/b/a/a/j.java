package kotlin.l.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0016¢\u0006\u0002\u0010\u0013R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, hxF = {"Lkotlin/reflect/jvm/internal/calls/ThrowingCaller;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "", "()V", "member", "getMember", "()Ljava/lang/Void;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
public final class j implements d {
    public static final j Tct = new j();

    static {
        AppMethodBeat.i(56646);
        AppMethodBeat.o(56646);
    }

    private j() {
    }

    @Override // kotlin.l.b.a.a.d
    public final /* bridge */ /* synthetic */ Member hyV() {
        return null;
    }

    @Override // kotlin.l.b.a.a.d
    public final Type hyW() {
        AppMethodBeat.i(56644);
        Class cls = Void.TYPE;
        p.g(cls, "Void.TYPE");
        Class cls2 = cls;
        AppMethodBeat.o(56644);
        return cls2;
    }

    @Override // kotlin.l.b.a.a.d
    public final Object ag(Object[] objArr) {
        AppMethodBeat.i(56645);
        p.h(objArr, "args");
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("call/callBy are not supported for this declaration.");
        AppMethodBeat.o(56645);
        throw unsupportedOperationException;
    }

    @Override // kotlin.l.b.a.a.d
    public final List<Type> hyX() {
        return v.SXr;
    }
}
