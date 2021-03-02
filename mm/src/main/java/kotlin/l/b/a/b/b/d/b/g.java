package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.a;
import kotlin.g.b.p;
import kotlin.l.b.a.b.f.b;

public final class g {
    public static final List<c> a(Annotation[] annotationArr) {
        AppMethodBeat.i(57420);
        p.h(annotationArr, "$this$getAnnotations");
        ArrayList arrayList = new ArrayList(annotationArr.length);
        for (Annotation annotation : annotationArr) {
            arrayList.add(new c(annotation));
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(57420);
        return arrayList2;
    }

    public static final c a(Annotation[] annotationArr, b bVar) {
        Annotation annotation;
        AppMethodBeat.i(57421);
        p.h(annotationArr, "$this$findAnnotation");
        p.h(bVar, "fqName");
        int length = annotationArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                annotation = null;
                break;
            }
            annotation = annotationArr[i2];
            if (p.j(b.bB(a.a(a.a(annotation))).hJd(), bVar)) {
                break;
            }
            i2++;
        }
        if (annotation != null) {
            c cVar = new c(annotation);
            AppMethodBeat.o(57421);
            return cVar;
        }
        AppMethodBeat.o(57421);
        return null;
    }
}
