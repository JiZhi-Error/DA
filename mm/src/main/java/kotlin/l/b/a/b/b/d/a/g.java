package kotlin.l.b.a.b.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.io.InputStream;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.d.a.f;
import kotlin.l.b.a.b.d.b.n;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.k.a.a.a;

public final class g implements n {
    private final ClassLoader TmI;

    public g(ClassLoader classLoader) {
        p.h(classLoader, "classLoader");
        AppMethodBeat.i(57377);
        this.TmI = classLoader;
        AppMethodBeat.o(57377);
    }

    private final n.a btG(String str) {
        n.a.b bVar;
        AppMethodBeat.i(57373);
        Class<?> a2 = e.a(this.TmI, str);
        if (a2 != null) {
            f.a aVar = f.TmL;
            f bw = f.a.bw(a2);
            if (bw != null) {
                bVar = new n.a.b(bw);
                n.a.b bVar2 = bVar;
                AppMethodBeat.o(57373);
                return bVar2;
            }
        }
        bVar = null;
        n.a.b bVar22 = bVar;
        AppMethodBeat.o(57373);
        return bVar22;
    }

    @Override // kotlin.l.b.a.b.d.b.n
    public final n.a a(kotlin.l.b.a.b.d.a.e.g gVar) {
        String sG;
        AppMethodBeat.i(57375);
        p.h(gVar, "javaClass");
        b hBk = gVar.hBk();
        if (hBk == null || (sG = hBk.sG()) == null) {
            AppMethodBeat.o(57375);
            return null;
        }
        n.a btG = btG(sG);
        AppMethodBeat.o(57375);
        return btG;
    }

    @Override // kotlin.l.b.a.b.k.a.u
    public final InputStream k(b bVar) {
        AppMethodBeat.i(57376);
        p.h(bVar, "packageFqName");
        if (!bVar.q(kotlin.l.b.a.b.a.g.TcC)) {
            AppMethodBeat.o(57376);
            return null;
        }
        ClassLoader classLoader = this.TmI;
        a aVar = a.TLQ;
        p.h(bVar, "fqName");
        StringBuilder sb = new StringBuilder();
        String sG = bVar.sG();
        p.g(sG, "fqName.asString()");
        StringBuilder append = sb.append(kotlin.n.n.a(sG, '.', '/')).append(FilePathGenerator.ANDROID_DIR_SEP);
        p.h(bVar, "fqName");
        InputStream resourceAsStream = classLoader.getResourceAsStream(append.append(a.r(bVar) + ".kotlin_builtins").toString());
        AppMethodBeat.o(57376);
        return resourceAsStream;
    }

    @Override // kotlin.l.b.a.b.d.b.n
    public final n.a c(kotlin.l.b.a.b.f.a aVar) {
        AppMethodBeat.i(57374);
        p.h(aVar, "classId");
        String sG = aVar.hIZ().sG();
        p.g(sG, "relativeClassName.asString()");
        String a2 = kotlin.n.n.a(sG, '.', '$');
        b hIY = aVar.hIY();
        p.g(hIY, "packageFqName");
        if (!hIY.TCR.TCW.isEmpty()) {
            a2 = aVar.hIY() + '.' + a2;
        }
        n.a btG = btG(a2);
        AppMethodBeat.o(57374);
        return btG;
    }
}
