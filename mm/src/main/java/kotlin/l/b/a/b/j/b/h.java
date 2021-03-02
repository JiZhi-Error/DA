package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;

public final class h {
    public static final h TIu = new h();

    /* access modifiers changed from: package-private */
    public static final class a extends q implements kotlin.g.a.b<y, ab> {
        final /* synthetic */ ab TIv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(ab abVar) {
            super(1);
            this.TIv = abVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ ab invoke(y yVar) {
            AppMethodBeat.i(60054);
            p.h(yVar, LocaleUtil.ITALIAN);
            ab abVar = this.TIv;
            AppMethodBeat.o(60054);
            return abVar;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b extends q implements kotlin.g.a.b<y, aj> {
        final /* synthetic */ kotlin.l.b.a.b.a.h TIw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(kotlin.l.b.a.b.a.h hVar) {
            super(1);
            this.TIw = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ aj invoke(y yVar) {
            AppMethodBeat.i(60055);
            y yVar2 = yVar;
            p.h(yVar2, "module");
            aj b2 = yVar2.hBh().b(this.TIw);
            p.g(b2, "module.builtIns.getPrimi…KotlinType(componentType)");
            AppMethodBeat.o(60055);
            return b2;
        }
    }

    static {
        AppMethodBeat.i(60059);
        AppMethodBeat.o(60059);
    }

    private h() {
    }

    public static b a(List<? extends g<?>> list, ab abVar) {
        AppMethodBeat.i(60056);
        p.h(list, "value");
        p.h(abVar, "type");
        b bVar = new b(list, new a(abVar));
        AppMethodBeat.o(60056);
        return bVar;
    }

    public final g<?> fz(Object obj) {
        AppMethodBeat.i(60057);
        if (obj instanceof Byte) {
            d dVar = new d(((Number) obj).byteValue());
            AppMethodBeat.o(60057);
            return dVar;
        } else if (obj instanceof Short) {
            u uVar = new u(((Number) obj).shortValue());
            AppMethodBeat.o(60057);
            return uVar;
        } else if (obj instanceof Integer) {
            m mVar = new m(((Number) obj).intValue());
            AppMethodBeat.o(60057);
            return mVar;
        } else if (obj instanceof Long) {
            s sVar = new s(((Number) obj).longValue());
            AppMethodBeat.o(60057);
            return sVar;
        } else if (obj instanceof Character) {
            e eVar = new e(((Character) obj).charValue());
            AppMethodBeat.o(60057);
            return eVar;
        } else if (obj instanceof Float) {
            l lVar = new l(((Number) obj).floatValue());
            AppMethodBeat.o(60057);
            return lVar;
        } else if (obj instanceof Double) {
            i iVar = new i(((Number) obj).doubleValue());
            AppMethodBeat.o(60057);
            return iVar;
        } else if (obj instanceof Boolean) {
            c cVar = new c(((Boolean) obj).booleanValue());
            AppMethodBeat.o(60057);
            return cVar;
        } else if (obj instanceof String) {
            v vVar = new v((String) obj);
            AppMethodBeat.o(60057);
            return vVar;
        } else if (obj instanceof byte[]) {
            b a2 = a(e.df((byte[]) obj), kotlin.l.b.a.b.a.h.BYTE);
            AppMethodBeat.o(60057);
            return a2;
        } else if (obj instanceof short[]) {
            b a3 = a(e.b((short[]) obj), kotlin.l.b.a.b.a.h.SHORT);
            AppMethodBeat.o(60057);
            return a3;
        } else if (obj instanceof int[]) {
            b a4 = a(e.Y((int[]) obj), kotlin.l.b.a.b.a.h.INT);
            AppMethodBeat.o(60057);
            return a4;
        } else if (obj instanceof long[]) {
            b a5 = a(e.h((long[]) obj), kotlin.l.b.a.b.a.h.LONG);
            AppMethodBeat.o(60057);
            return a5;
        } else if (obj instanceof char[]) {
            b a6 = a(e.d((char[]) obj), kotlin.l.b.a.b.a.h.CHAR);
            AppMethodBeat.o(60057);
            return a6;
        } else if (obj instanceof float[]) {
            b a7 = a(e.s((float[]) obj), kotlin.l.b.a.b.a.h.FLOAT);
            AppMethodBeat.o(60057);
            return a7;
        } else if (obj instanceof double[]) {
            b a8 = a(e.d((double[]) obj), kotlin.l.b.a.b.a.h.DOUBLE);
            AppMethodBeat.o(60057);
            return a8;
        } else if (obj instanceof boolean[]) {
            b a9 = a(e.d((boolean[]) obj), kotlin.l.b.a.b.a.h.BOOLEAN);
            AppMethodBeat.o(60057);
            return a9;
        } else if (obj == null) {
            t tVar = new t();
            AppMethodBeat.o(60057);
            return tVar;
        } else {
            AppMethodBeat.o(60057);
            return null;
        }
    }

    private final b a(List<?> list, kotlin.l.b.a.b.a.h hVar) {
        AppMethodBeat.i(60058);
        ArrayList arrayList = new ArrayList();
        for (Object obj : j.p(list)) {
            g<?> fz = fz(obj);
            if (fz != null) {
                arrayList.add(fz);
            }
        }
        b bVar = new b(arrayList, new b(hVar));
        AppMethodBeat.o(60058);
        return bVar;
    }
}
