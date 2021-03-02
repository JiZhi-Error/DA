package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import kotlin.g.b.p;
import kotlin.l.b.a.b.d.a.e.b;
import kotlin.l.b.a.b.f.f;

public abstract class d implements b {
    public static final a Tnd = new a((byte) 0);
    private final f TjT;

    public d(f fVar) {
        this.TjT = fVar;
    }

    @Override // kotlin.l.b.a.b.d.a.e.b
    public final f hAH() {
        return this.TjT;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static d a(Object obj, f fVar) {
            AppMethodBeat.i(57415);
            p.h(obj, "value");
            if (b.by(obj.getClass())) {
                o oVar = new o(fVar, (Enum) obj);
                AppMethodBeat.o(57415);
                return oVar;
            } else if (obj instanceof Annotation) {
                e eVar = new e(fVar, (Annotation) obj);
                AppMethodBeat.o(57415);
                return eVar;
            } else if (obj instanceof Object[]) {
                h hVar = new h(fVar, (Object[]) obj);
                AppMethodBeat.o(57415);
                return hVar;
            } else if (obj instanceof Class) {
                k kVar = new k(fVar, (Class) obj);
                AppMethodBeat.o(57415);
                return kVar;
            } else {
                q qVar = new q(fVar, obj);
                AppMethodBeat.o(57415);
                return qVar;
            }
        }
    }
}
