package kotlin.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.y;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.b.c;
import kotlin.l.b.a.b.b.c.w;
import kotlin.l.b.a.b.l.f;
import kotlin.l.b.a.b.l.i;
import kotlin.l.b.a.b.l.j;
import kotlin.l.k;

public final class e extends g {
    static final /* synthetic */ k[] cLI = {aa.a(new y(aa.bp(e.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsSettings;"))};
    public kotlin.l.b.a.b.b.y Tgn;
    public boolean Tgo = true;
    private final f Tgp;

    public enum a {
        FROM_DEPENDENCIES,
        FROM_CLASS_LOADER,
        FALLBACK;

        static {
            AppMethodBeat.i(56778);
            AppMethodBeat.o(56778);
        }

        public static a valueOf(String str) {
            AppMethodBeat.i(56780);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(56780);
            return aVar;
        }
    }

    static {
        AppMethodBeat.i(56785);
        AppMethodBeat.o(56785);
    }

    public final h hAg() {
        AppMethodBeat.i(56786);
        h hVar = (h) i.a(this.Tgp, cLI[0]);
        AppMethodBeat.o(56786);
        return hVar;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(j jVar, a aVar) {
        super(jVar);
        p.h(jVar, "storageManager");
        p.h(aVar, "kind");
        AppMethodBeat.i(56790);
        this.Tgp = jVar.al(new b(this, jVar));
        switch (f.$EnumSwitchMapping$0[aVar.ordinal()]) {
            case 1:
                AppMethodBeat.o(56790);
                return;
            case 2:
                hzc();
                AppMethodBeat.o(56790);
                return;
            case 3:
                hzc();
                break;
        }
        AppMethodBeat.o(56790);
    }

    @Override // kotlin.l.b.a.b.a.g
    public final c hze() {
        AppMethodBeat.i(56787);
        h hAg = hAg();
        AppMethodBeat.o(56787);
        return hAg;
    }

    @Override // kotlin.l.b.a.b.a.g
    public final kotlin.l.b.a.b.b.b.a hzd() {
        AppMethodBeat.i(56788);
        h hAg = hAg();
        AppMethodBeat.o(56788);
        return hAg;
    }

    static final class b extends q implements kotlin.g.a.a<h> {
        final /* synthetic */ j Tgm;
        final /* synthetic */ e Tgu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(e eVar, j jVar) {
            super(0);
            this.Tgu = eVar;
            this.Tgm = jVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ h invoke() {
            AppMethodBeat.i(56784);
            w hzg = this.Tgu.hzg();
            p.g(hzg, "builtInsModule");
            h hVar = new h(hzg, this.Tgm, new kotlin.g.a.a<kotlin.l.b.a.b.b.y>(this) {
                /* class kotlin.l.b.a.b.a.b.e.b.AnonymousClass1 */
                final /* synthetic */ b Tgv;

                {
                    this.Tgv = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ kotlin.l.b.a.b.b.y invoke() {
                    AppMethodBeat.i(56782);
                    kotlin.l.b.a.b.b.y yVar = this.Tgv.Tgu.Tgn;
                    if (yVar == null) {
                        AssertionError assertionError = new AssertionError("JvmBuiltins has not been initialized properly");
                        AppMethodBeat.o(56782);
                        throw assertionError;
                    }
                    AppMethodBeat.o(56782);
                    return yVar;
                }
            }, new kotlin.g.a.a<Boolean>(this) {
                /* class kotlin.l.b.a.b.a.b.e.b.AnonymousClass2 */
                final /* synthetic */ b Tgv;

                {
                    this.Tgv = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ Boolean invoke() {
                    AppMethodBeat.i(56783);
                    if (this.Tgv.Tgu.Tgn == null) {
                        AssertionError assertionError = new AssertionError("JvmBuiltins has not been initialized properly");
                        AppMethodBeat.o(56783);
                        throw assertionError;
                    }
                    Boolean valueOf = Boolean.valueOf(this.Tgv.Tgu.Tgo);
                    AppMethodBeat.o(56783);
                    return valueOf;
                }
            });
            AppMethodBeat.o(56784);
            return hVar;
        }
    }

    @Override // kotlin.l.b.a.b.a.g
    public final /* synthetic */ Iterable hzf() {
        AppMethodBeat.i(56789);
        Iterable<kotlin.l.b.a.b.b.b.b> hzf = super.hzf();
        p.g(hzf, "super.getClassDescriptorFactories()");
        j jVar = this.TcN;
        if (jVar == null) {
            g.atM(5);
        }
        p.g(jVar, "storageManager");
        w hzg = hzg();
        p.g(hzg, "builtInsModule");
        List d2 = kotlin.a.j.d(hzf, new d(jVar, hzg));
        AppMethodBeat.o(56789);
        return d2;
    }
}
