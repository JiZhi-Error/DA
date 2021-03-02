package kotlin.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.l.b.a.b.b.a.c;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.b.g;
import kotlin.l.b.a.b.m.ab;

public final class d implements c {
    private final ab Tii;
    private final Map<f, g<?>> Tij;
    private final an Tik;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(56934);
        switch (i2) {
            case 3:
            case 4:
            case 5:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 3:
            case 4:
            case 5:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "valueArguments";
                break;
            case 2:
                objArr[0] = "source";
                break;
            case 3:
            case 4:
            case 5:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
                break;
            default:
                objArr[0] = "annotationType";
                break;
        }
        switch (i2) {
            case 3:
                objArr[1] = "getType";
                break;
            case 4:
                objArr[1] = "getAllValueArguments";
                break;
            case 5:
                objArr[1] = "getSource";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
                break;
        }
        switch (i2) {
            case 3:
            case 4:
            case 5:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 3:
            case 4:
            case 5:
                illegalStateException = new IllegalStateException(format);
                break;
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(56934);
        throw illegalStateException;
    }

    public d(ab abVar, Map<f, g<?>> map, an anVar) {
        if (abVar == null) {
            atM(0);
        }
        if (map == null) {
            atM(1);
        }
        if (anVar == null) {
            atM(2);
        }
        AppMethodBeat.i(56928);
        this.Tii = abVar;
        this.Tij = map;
        this.Tik = anVar;
        AppMethodBeat.o(56928);
    }

    @Override // kotlin.l.b.a.b.b.a.c
    public final ab hBy() {
        AppMethodBeat.i(56929);
        ab abVar = this.Tii;
        if (abVar == null) {
            atM(3);
        }
        AppMethodBeat.o(56929);
        return abVar;
    }

    @Override // kotlin.l.b.a.b.b.a.c
    public final b hBk() {
        AppMethodBeat.i(56930);
        b b2 = c.a.b(this);
        AppMethodBeat.o(56930);
        return b2;
    }

    @Override // kotlin.l.b.a.b.b.a.c
    public final Map<f, g<?>> hBO() {
        AppMethodBeat.i(56931);
        Map<f, g<?>> map = this.Tij;
        if (map == null) {
            atM(4);
        }
        AppMethodBeat.o(56931);
        return map;
    }

    @Override // kotlin.l.b.a.b.b.a.c
    public final an hzM() {
        AppMethodBeat.i(56932);
        an anVar = this.Tik;
        if (anVar == null) {
            atM(5);
        }
        AppMethodBeat.o(56932);
        return anVar;
    }

    public final String toString() {
        AppMethodBeat.i(56933);
        String a2 = kotlin.l.b.a.b.i.c.TFg.a(this, (e) null);
        AppMethodBeat.o(56933);
        return a2;
    }
}
