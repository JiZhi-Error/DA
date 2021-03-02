package kotlin.l.b.a.b.e.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l.b.a.b.e.a;
import kotlin.l.b.a.b.e.b.b;
import kotlin.l.b.a.b.e.b.c;
import kotlin.l.b.a.b.e.b.f;
import kotlin.l.b.a.b.e.b.h;
import kotlin.l.b.a.b.e.c.a;
import kotlin.l.b.a.b.e.c.a.e;
import kotlin.l.b.a.b.h.g;
import kotlin.l.b.a.b.h.i;
import kotlin.o;

public final class i {
    private static final g TCM;
    public static final i TCN = new i();

    static {
        AppMethodBeat.i(59261);
        g hJv = g.hJv();
        a.a(hJv);
        p.g(hJv, "ExtensionRegistryLite.ne…f::registerAllExtensions)");
        TCM = hJv;
        AppMethodBeat.o(59261);
    }

    private i() {
    }

    public static g hIX() {
        return TCM;
    }

    public static final o<g, a.b> e(String[] strArr, String[] strArr2) {
        AppMethodBeat.i(59251);
        p.h(strArr, "data");
        p.h(strArr2, "strings");
        byte[] al = a.al(strArr);
        p.g(al, "BitEncoding.decodeBytes(data)");
        p.h(al, "bytes");
        p.h(strArr2, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(al);
        o<g, a.b> oVar = new o<>(a(byteArrayInputStream, strArr2), a.b.a(byteArrayInputStream, TCM));
        AppMethodBeat.o(59251);
        return oVar;
    }

    public static final o<g, a.k> f(String[] strArr, String[] strArr2) {
        AppMethodBeat.i(59252);
        p.h(strArr, "data");
        p.h(strArr2, "strings");
        byte[] al = a.al(strArr);
        p.g(al, "BitEncoding.decodeBytes(data)");
        p.h(al, "bytes");
        p.h(strArr2, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(al);
        o<g, a.k> oVar = new o<>(a(byteArrayInputStream, strArr2), a.k.c(byteArrayInputStream, TCM));
        AppMethodBeat.o(59252);
        return oVar;
    }

    public static final o<g, a.h> g(String[] strArr, String[] strArr2) {
        AppMethodBeat.i(59253);
        p.h(strArr, "data");
        p.h(strArr2, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(a.al(strArr));
        o<g, a.h> oVar = new o<>(a(byteArrayInputStream, strArr2), a.h.b(byteArrayInputStream, TCM));
        AppMethodBeat.o(59253);
        return oVar;
    }

    private static g a(InputStream inputStream, String[] strArr) {
        AppMethodBeat.i(59254);
        a.d f2 = a.d.f(inputStream, TCM);
        p.g(f2, "JvmProtoBuf.StringTableT…this, EXTENSION_REGISTRY)");
        g gVar = new g(f2, strArr);
        AppMethodBeat.o(59254);
        return gVar;
    }

    public static e.b a(a.h hVar, c cVar, h hVar2) {
        int i2;
        String str;
        AppMethodBeat.i(59255);
        p.h(hVar, "proto");
        p.h(cVar, "nameResolver");
        p.h(hVar2, "typeTable");
        i.f<a.h, a.b> fVar = kotlin.l.b.a.b.e.c.a.TBM;
        p.g(fVar, "JvmProtoBuf.methodSignature");
        a.b bVar = (a.b) f.a(hVar, fVar);
        if (bVar == null || !bVar.Az()) {
            i2 = hVar.Tyk;
        } else {
            i2 = bVar.Tyk;
        }
        if (bVar == null || !bVar.hIn()) {
            List eR = j.eR(kotlin.l.b.a.b.e.b.g.b(hVar, hVar2));
            List<a.t> list = hVar.TxT;
            p.g(list, "proto.valueParameterList");
            List<a.t> list2 = list;
            ArrayList arrayList = new ArrayList(j.a(list2, 10));
            for (T t : list2) {
                p.g(t, LocaleUtil.ITALIAN);
                arrayList.add(kotlin.l.b.a.b.e.b.g.a((a.t) t, hVar2));
            }
            List<a.p> b2 = j.b((Collection) eR, (Iterable) arrayList);
            ArrayList arrayList2 = new ArrayList(j.a(b2, 10));
            for (a.p pVar : b2) {
                String b3 = b(pVar, cVar);
                if (b3 == null) {
                    AppMethodBeat.o(59255);
                    return null;
                }
                arrayList2.add(b3);
            }
            ArrayList arrayList3 = arrayList2;
            String b4 = b(kotlin.l.b.a.b.e.b.g.a(hVar, hVar2), cVar);
            if (b4 == null) {
                AppMethodBeat.o(59255);
                return null;
            }
            str = j.a(arrayList3, "", "(", ")", 0, (CharSequence) null, (b) null, 56) + b4;
        } else {
            str = cVar.getString(bVar.TBX);
        }
        e.b bVar2 = new e.b(cVar.getString(i2), str);
        AppMethodBeat.o(59255);
        return bVar2;
    }

    public static e.b a(a.c cVar, c cVar2, h hVar) {
        String str;
        String a2;
        AppMethodBeat.i(59256);
        p.h(cVar, "proto");
        p.h(cVar2, "nameResolver");
        p.h(hVar, "typeTable");
        i.f<a.c, a.b> fVar = kotlin.l.b.a.b.e.c.a.TBL;
        p.g(fVar, "JvmProtoBuf.constructorSignature");
        a.b bVar = (a.b) f.a(cVar, fVar);
        if (bVar == null || !bVar.Az()) {
            str = "<init>";
        } else {
            str = cVar2.getString(bVar.Tyk);
        }
        if (bVar == null || !bVar.hIn()) {
            List<a.t> list = cVar.TxT;
            p.g(list, "proto.valueParameterList");
            List<a.t> list2 = list;
            ArrayList arrayList = new ArrayList(j.a(list2, 10));
            for (T t : list2) {
                p.g(t, LocaleUtil.ITALIAN);
                String b2 = b(kotlin.l.b.a.b.e.b.g.a((a.t) t, hVar), cVar2);
                if (b2 == null) {
                    AppMethodBeat.o(59256);
                    return null;
                }
                arrayList.add(b2);
            }
            a2 = j.a(arrayList, "", "(", ")V", 0, (CharSequence) null, (b) null, 56);
        } else {
            a2 = cVar2.getString(bVar.TBX);
        }
        e.b bVar2 = new e.b(str, a2);
        AppMethodBeat.o(59256);
        return bVar2;
    }

    public static /* synthetic */ e.a a(a.m mVar, c cVar, h hVar) {
        AppMethodBeat.i(59258);
        e.a a2 = a(mVar, cVar, hVar, true);
        AppMethodBeat.o(59258);
        return a2;
    }

    public static e.a a(a.m mVar, c cVar, h hVar, boolean z) {
        a.C2330a aVar;
        int i2;
        String b2;
        AppMethodBeat.i(59257);
        p.h(mVar, "proto");
        p.h(cVar, "nameResolver");
        p.h(hVar, "typeTable");
        i.f<a.m, a.c> fVar = kotlin.l.b.a.b.e.c.a.TBO;
        p.g(fVar, "JvmProtoBuf.propertySignature");
        a.c cVar2 = (a.c) f.a(mVar, fVar);
        if (cVar2 == null) {
            AppMethodBeat.o(59257);
            return null;
        }
        if (cVar2.hIy()) {
            aVar = cVar2.TCa;
        } else {
            aVar = null;
        }
        if (aVar != null || !z) {
            if (aVar == null || !aVar.Az()) {
                i2 = mVar.Tyk;
            } else {
                i2 = aVar.Tyk;
            }
            if (aVar == null || !aVar.hIn()) {
                b2 = b(kotlin.l.b.a.b.e.b.g.a(mVar, hVar), cVar);
                if (b2 == null) {
                    AppMethodBeat.o(59257);
                    return null;
                }
            } else {
                b2 = cVar.getString(aVar.TBX);
            }
            e.a aVar2 = new e.a(cVar.getString(i2), b2);
            AppMethodBeat.o(59257);
            return aVar2;
        }
        AppMethodBeat.o(59257);
        return null;
    }

    private static String b(a.p pVar, c cVar) {
        AppMethodBeat.i(59259);
        if (pVar.hGX()) {
            String btW = b.btW(cVar.avl(pVar.Tzo));
            AppMethodBeat.o(59259);
            return btW;
        }
        AppMethodBeat.o(59259);
        return null;
    }

    public static final boolean f(a.m mVar) {
        AppMethodBeat.i(59260);
        p.h(mVar, "proto");
        d dVar = d.TCC;
        b.a hIW = d.hIW();
        Object e2 = mVar.e(kotlin.l.b.a.b.e.c.a.TBP);
        p.g(e2, "proto.getExtension(JvmProtoBuf.flags)");
        Boolean avk = hIW.avk(((Number) e2).intValue());
        p.g(avk, "JvmFlags.IS_MOVED_FROM_I…nsion(JvmProtoBuf.flags))");
        boolean booleanValue = avk.booleanValue();
        AppMethodBeat.o(59260);
        return booleanValue;
    }
}
