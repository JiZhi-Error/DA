package kotlin.l.b.a.b.b.d.b;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.d.b.d;
import kotlin.l.b.a.b.d.a.e.a;
import kotlin.l.b.a.b.d.a.e.b;
import kotlin.l.b.a.b.d.a.e.g;
import kotlin.l.b.a.b.f.f;

public final class c extends n implements a {
    public final Annotation TmG;

    public c(Annotation annotation) {
        p.h(annotation, "annotation");
        AppMethodBeat.i(57414);
        this.TmG = annotation;
        AppMethodBeat.o(57414);
    }

    @Override // kotlin.l.b.a.b.d.a.e.a
    public final Collection<b> hCD() {
        AppMethodBeat.i(57408);
        Method[] declaredMethods = kotlin.g.a.a(kotlin.g.a.a(this.TmG)).getDeclaredMethods();
        p.g(declaredMethods, "annotation.annotationClass.java.declaredMethods");
        ArrayList arrayList = new ArrayList(declaredMethods.length);
        for (Method method : declaredMethods) {
            d.a aVar = d.Tnd;
            Object invoke = method.invoke(this.TmG, new Object[0]);
            p.g(invoke, "method.invoke(annotation)");
            p.g(method, FirebaseAnalytics.b.METHOD);
            arrayList.add(d.a.a(invoke, f.btY(method.getName())));
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(57408);
        return arrayList2;
    }

    @Override // kotlin.l.b.a.b.d.a.e.a
    public final kotlin.l.b.a.b.f.a hyy() {
        AppMethodBeat.i(57409);
        kotlin.l.b.a.b.f.a bB = b.bB(kotlin.g.a.a(kotlin.g.a.a(this.TmG)));
        AppMethodBeat.o(57409);
        return bB;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(57411);
        if (!(obj instanceof c) || !p.j(this.TmG, ((c) obj).TmG)) {
            AppMethodBeat.o(57411);
            return false;
        }
        AppMethodBeat.o(57411);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.i(57412);
        int hashCode = this.TmG.hashCode();
        AppMethodBeat.o(57412);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(57413);
        String str = getClass().getName() + ": " + this.TmG;
        AppMethodBeat.o(57413);
        return str;
    }

    @Override // kotlin.l.b.a.b.d.a.e.a
    public final /* synthetic */ g hCE() {
        AppMethodBeat.i(57410);
        j jVar = new j(kotlin.g.a.a(kotlin.g.a.a(this.TmG)));
        AppMethodBeat.o(57410);
        return jVar;
    }
}
