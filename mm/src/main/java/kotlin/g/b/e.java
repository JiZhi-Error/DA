package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.g.b;
import kotlin.l.d;
import kotlin.l.j;

public abstract class e implements Serializable, kotlin.l.a {
    public static final Object SYm = a.SYn;
    private transient kotlin.l.a SYk;
    protected final Object SYl;

    /* access modifiers changed from: protected */
    public abstract kotlin.l.a hxP();

    static class a implements Serializable {
        private static final a SYn = new a();

        private a() {
        }

        static {
            AppMethodBeat.i(128955);
            AppMethodBeat.o(128955);
        }

        private Object readResolve() {
            return SYn;
        }
    }

    public e() {
        this(SYm);
    }

    protected e(Object obj) {
        this.SYl = obj;
    }

    public final Object hxQ() {
        return this.SYl;
    }

    public final kotlin.l.a hxR() {
        kotlin.l.a aVar = this.SYk;
        if (aVar != null) {
            return aVar;
        }
        kotlin.l.a hxP = hxP();
        this.SYk = hxP;
        return hxP;
    }

    /* access modifiers changed from: protected */
    public kotlin.l.a hxS() {
        kotlin.l.a hxR = hxR();
        if (hxR != this) {
            return hxR;
        }
        throw new b();
    }

    public d Rs() {
        throw new AbstractMethodError();
    }

    @Override // kotlin.l.a
    public String getName() {
        throw new AbstractMethodError();
    }

    public String getSignature() {
        throw new AbstractMethodError();
    }

    @Override // kotlin.l.a
    public final List<j> getParameters() {
        return hxS().getParameters();
    }

    @Override // kotlin.l.a
    public final Object ag(Object... objArr) {
        return hxS().ag(objArr);
    }

    @Override // kotlin.l.a
    public final Object cx(Map map) {
        return hxS().cx(map);
    }
}
