package kotlin.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.y;
import kotlin.l.b.a.b.i.b;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.av;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

public abstract class c {
    public static final c TFb = a.T(d.TFo);
    public static final c TFc = a.T(b.TFm);
    public static final c TFd = a.T(C2340c.TFn);
    public static final c TFe = a.T(e.TFp);
    public static final c TFf = a.T(j.TFu);
    public static final c TFg = a.T(g.TFr);
    public static final c TFh = a.T(h.TFs);
    public static final c TFi = a.T(k.TFv);
    public static final c TFj = a.T(f.TFq);
    public static final c TFk = a.T(i.TFt);
    public static final a TFl = new a((byte) 0);

    public abstract String a(String str, String str2, kotlin.l.b.a.b.a.g gVar);

    public abstract String a(kotlin.l.b.a.b.b.a.c cVar, kotlin.l.b.a.b.b.a.e eVar);

    public abstract String a(av avVar);

    public abstract String b(kotlin.l.b.a.b.f.f fVar, boolean z);

    public abstract String b(ab abVar);

    public abstract String f(kotlin.l.b.a.b.f.c cVar);

    public abstract String k(kotlin.l.b.a.b.b.l lVar);

    public final c T(kotlin.g.a.b<? super i, x> bVar) {
        p.h(bVar, "changeOptions");
        if (this == null) {
            throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
        }
        j jVar = ((e) this).TFz;
        j jVar2 = new j();
        Field[] declaredFields = jVar.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            p.g(field, "field");
            if ((field.getModifiers() & 8) == 0) {
                field.setAccessible(true);
                Object obj = field.get(jVar);
                if (!(obj instanceof kotlin.i.b)) {
                    obj = null;
                }
                kotlin.i.b bVar2 = (kotlin.i.b) obj;
                if (bVar2 == null) {
                    continue;
                } else {
                    String name = field.getName();
                    p.g(name, "field.name");
                    boolean z = !n.J(name, "is", false);
                    if (!aa.SXc || z) {
                        String name2 = field.getName();
                        StringBuilder sb = new StringBuilder("get");
                        String name3 = field.getName();
                        p.g(name3, "field.name");
                        field.set(jVar2, jVar2.fy(bVar2.a(new y(kotlin.g.b.aa.bp(j.class), name2, sb.append(n.capitalize(name3)).toString()))));
                    } else {
                        throw new AssertionError("Fields named is* are not supported here yet");
                    }
                }
            }
        }
        bVar.invoke(jVar2);
        jVar2.lock();
        return new e(jVar2);
    }

    public interface l {
        void a(kotlin.l.b.a.b.b.av avVar, int i2, int i3, StringBuilder sb);

        void a(kotlin.l.b.a.b.b.av avVar, StringBuilder sb);

        void e(StringBuilder sb);

        void f(StringBuilder sb);

        public static final class a implements l {
            public static final a TFw = new a();

            static {
                AppMethodBeat.i(59681);
                AppMethodBeat.o(59681);
            }

            private a() {
            }

            @Override // kotlin.l.b.a.b.i.c.l
            public final void e(StringBuilder sb) {
                AppMethodBeat.i(59677);
                p.h(sb, "builder");
                sb.append("(");
                AppMethodBeat.o(59677);
            }

            @Override // kotlin.l.b.a.b.i.c.l
            public final void f(StringBuilder sb) {
                AppMethodBeat.i(59678);
                p.h(sb, "builder");
                sb.append(")");
                AppMethodBeat.o(59678);
            }

            @Override // kotlin.l.b.a.b.i.c.l
            public final void a(kotlin.l.b.a.b.b.av avVar, StringBuilder sb) {
                AppMethodBeat.i(59679);
                p.h(avVar, "parameter");
                p.h(sb, "builder");
                AppMethodBeat.o(59679);
            }

            @Override // kotlin.l.b.a.b.i.c.l
            public final void a(kotlin.l.b.a.b.b.av avVar, int i2, int i3, StringBuilder sb) {
                AppMethodBeat.i(59680);
                p.h(avVar, "parameter");
                p.h(sb, "builder");
                if (i2 != i3 - 1) {
                    sb.append(", ");
                }
                AppMethodBeat.o(59680);
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static c T(kotlin.g.a.b<? super i, x> bVar) {
            AppMethodBeat.i(59676);
            p.h(bVar, "changeOptions");
            j jVar = new j();
            bVar.invoke(jVar);
            jVar.lock();
            e eVar = new e(jVar);
            AppMethodBeat.o(59676);
            return eVar;
        }
    }

    static final class b extends q implements kotlin.g.a.b<i, x> {
        public static final b TFm = new b();

        static {
            AppMethodBeat.i(59658);
            AppMethodBeat.o(59658);
        }

        b() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(i iVar) {
            AppMethodBeat.i(59657);
            i iVar2 = iVar;
            p.h(iVar2, "$receiver");
            iVar2.EO(false);
            iVar2.E(kotlin.a.x.SXt);
            x xVar = x.SXb;
            AppMethodBeat.o(59657);
            return xVar;
        }
    }

    /* renamed from: kotlin.l.b.a.b.i.c$c */
    static final class C2340c extends q implements kotlin.g.a.b<i, x> {
        public static final C2340c TFn = new C2340c();

        static {
            AppMethodBeat.i(59660);
            AppMethodBeat.o(59660);
        }

        C2340c() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(i iVar) {
            AppMethodBeat.i(59659);
            i iVar2 = iVar;
            p.h(iVar2, "$receiver");
            iVar2.EO(false);
            iVar2.E(kotlin.a.x.SXt);
            iVar2.EP(true);
            x xVar = x.SXb;
            AppMethodBeat.o(59659);
            return xVar;
        }
    }

    static final class d extends q implements kotlin.g.a.b<i, x> {
        public static final d TFo = new d();

        static {
            AppMethodBeat.i(59662);
            AppMethodBeat.o(59662);
        }

        d() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(i iVar) {
            AppMethodBeat.i(59661);
            i iVar2 = iVar;
            p.h(iVar2, "$receiver");
            iVar2.EO(false);
            x xVar = x.SXb;
            AppMethodBeat.o(59661);
            return xVar;
        }
    }

    static final class e extends q implements kotlin.g.a.b<i, x> {
        public static final e TFp = new e();

        static {
            AppMethodBeat.i(59664);
            AppMethodBeat.o(59664);
        }

        e() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(i iVar) {
            AppMethodBeat.i(59663);
            i iVar2 = iVar;
            p.h(iVar2, "$receiver");
            iVar2.E(kotlin.a.x.SXt);
            iVar2.a(b.C2339b.TEZ);
            iVar2.a(n.ONLY_NON_SYNTHESIZED);
            x xVar = x.SXb;
            AppMethodBeat.o(59663);
            return xVar;
        }
    }

    static final class f extends q implements kotlin.g.a.b<i, x> {
        public static final f TFq = new f();

        static {
            AppMethodBeat.i(59666);
            AppMethodBeat.o(59666);
        }

        f() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(i iVar) {
            AppMethodBeat.i(59665);
            i iVar2 = iVar;
            p.h(iVar2, "$receiver");
            iVar2.setDebugMode(true);
            iVar2.a(b.a.TEY);
            iVar2.E(h.TFT);
            x xVar = x.SXb;
            AppMethodBeat.o(59665);
            return xVar;
        }
    }

    static final class g extends q implements kotlin.g.a.b<i, x> {
        public static final g TFr = new g();

        static {
            AppMethodBeat.i(59668);
            AppMethodBeat.o(59668);
        }

        g() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(i iVar) {
            AppMethodBeat.i(59667);
            i iVar2 = iVar;
            p.h(iVar2, "$receiver");
            iVar2.E(h.TFS);
            x xVar = x.SXb;
            AppMethodBeat.o(59667);
            return xVar;
        }
    }

    static final class h extends q implements kotlin.g.a.b<i, x> {
        public static final h TFs = new h();

        static {
            AppMethodBeat.i(186255);
            AppMethodBeat.o(186255);
        }

        h() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(i iVar) {
            AppMethodBeat.i(186254);
            i iVar2 = iVar;
            p.h(iVar2, "$receiver");
            iVar2.E(h.TFT);
            x xVar = x.SXb;
            AppMethodBeat.o(186254);
            return xVar;
        }
    }

    static final class i extends q implements kotlin.g.a.b<i, x> {
        public static final i TFt = new i();

        static {
            AppMethodBeat.i(59670);
            AppMethodBeat.o(59670);
        }

        i() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(i iVar) {
            AppMethodBeat.i(59669);
            i iVar2 = iVar;
            p.h(iVar2, "$receiver");
            iVar2.a(p.THk);
            iVar2.E(h.TFT);
            x xVar = x.SXb;
            AppMethodBeat.o(59669);
            return xVar;
        }
    }

    static final class j extends q implements kotlin.g.a.b<i, x> {
        public static final j TFu = new j();

        static {
            AppMethodBeat.i(59672);
            AppMethodBeat.o(59672);
        }

        j() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(i iVar) {
            AppMethodBeat.i(59671);
            i iVar2 = iVar;
            p.h(iVar2, "$receiver");
            iVar2.EO(false);
            iVar2.E(kotlin.a.x.SXt);
            iVar2.a(b.C2339b.TEZ);
            iVar2.EQ(true);
            iVar2.a(n.NONE);
            iVar2.EK(true);
            iVar2.EL(true);
            iVar2.EP(true);
            iVar2.EM(true);
            x xVar = x.SXb;
            AppMethodBeat.o(59671);
            return xVar;
        }
    }

    static final class k extends q implements kotlin.g.a.b<i, x> {
        public static final k TFv = new k();

        static {
            AppMethodBeat.i(59674);
            AppMethodBeat.o(59674);
        }

        k() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(i iVar) {
            AppMethodBeat.i(59673);
            i iVar2 = iVar;
            p.h(iVar2, "$receiver");
            iVar2.a(b.C2339b.TEZ);
            iVar2.a(n.ONLY_NON_SYNTHESIZED);
            x xVar = x.SXb;
            AppMethodBeat.o(59673);
            return xVar;
        }
    }
}
