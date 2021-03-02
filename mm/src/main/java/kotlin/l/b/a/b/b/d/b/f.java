package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l.b.a.b.d.a.e.d;
import kotlin.l.b.a.b.f.b;

public interface f extends d {
    AnnotatedElement hCG();

    public static final class a {
        public static List<c> a(f fVar) {
            Annotation[] declaredAnnotations;
            AppMethodBeat.i(57418);
            AnnotatedElement hCG = fVar.hCG();
            if (hCG == null || (declaredAnnotations = hCG.getDeclaredAnnotations()) == null) {
                v vVar = v.SXr;
                AppMethodBeat.o(57418);
                return vVar;
            }
            List<c> a2 = g.a(declaredAnnotations);
            AppMethodBeat.o(57418);
            return a2;
        }

        public static c a(f fVar, b bVar) {
            Annotation[] declaredAnnotations;
            AppMethodBeat.i(57419);
            p.h(bVar, "fqName");
            AnnotatedElement hCG = fVar.hCG();
            if (hCG == null || (declaredAnnotations = hCG.getDeclaredAnnotations()) == null) {
                AppMethodBeat.o(57419);
                return null;
            }
            c a2 = g.a(declaredAnnotations, bVar);
            AppMethodBeat.o(57419);
            return a2;
        }
    }
}
