package kotlin.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.y;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.k;
import kotlin.n.n;

public final class i {
    public static final b TeS = new b((byte) 0);
    static final /* synthetic */ k[] cLI = {aa.a(new y(aa.bp(i.class), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), aa.a(new y(aa.bp(i.class), "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), aa.a(new y(aa.bp(i.class), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), aa.a(new y(aa.bp(i.class), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), aa.a(new y(aa.bp(i.class), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), aa.a(new y(aa.bp(i.class), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), aa.a(new y(aa.bp(i.class), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), aa.a(new y(aa.bp(i.class), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"))};
    private final f TeI;
    private final a TeJ = new a(1);
    private final a TeK = new a(1);
    private final a TeL = new a(1);
    private final a TeM = new a(2);
    private final a TeN = new a(3);
    private final a TeO = new a(1);
    private final a TeP = new a(2);
    private final a TeQ = new a(3);
    private final kotlin.l.b.a.b.b.aa TeR;

    static {
        AppMethodBeat.i(56690);
        AppMethodBeat.o(56690);
    }

    public i(kotlin.l.b.a.b.b.y yVar, kotlin.l.b.a.b.b.aa aaVar) {
        p.h(yVar, "module");
        p.h(aaVar, "notFoundClasses");
        AppMethodBeat.i(56692);
        this.TeR = aaVar;
        this.TeI = g.a(kotlin.k.PUBLICATION, new c(yVar));
        AppMethodBeat.o(56692);
    }

    static final class a {
        final int TeT;

        public a(int i2) {
            this.TeT = i2;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    static final class c extends q implements kotlin.g.a.a<h> {
        final /* synthetic */ kotlin.l.b.a.b.b.y TeU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(kotlin.l.b.a.b.b.y yVar) {
            super(0);
            this.TeU = yVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ h invoke() {
            AppMethodBeat.i(56689);
            h hAp = this.TeU.e(j.hzw()).hAp();
            AppMethodBeat.o(56689);
            return hAp;
        }
    }

    public final e hzv() {
        AppMethodBeat.i(56691);
        a aVar = this.TeJ;
        k kVar = cLI[0];
        p.h(this, "types");
        p.h(kVar, "property");
        String capitalize = n.capitalize(kVar.getName());
        int i2 = aVar.TeT;
        kotlin.l.b.a.b.f.f btY = kotlin.l.b.a.b.f.f.btY(capitalize);
        p.g(btY, "Name.identifier(className)");
        kotlin.l.b.a.b.b.h c2 = ((h) this.TeI.getValue()).c(btY, kotlin.l.b.a.b.c.a.c.FROM_REFLECTION);
        if (!(c2 instanceof e)) {
            c2 = null;
        }
        e eVar = (e) c2;
        if (eVar == null) {
            eVar = this.TeR.a(new kotlin.l.b.a.b.f.a(j.hzw(), btY), j.listOf(Integer.valueOf(i2)));
        }
        AppMethodBeat.o(56691);
        return eVar;
    }
}
