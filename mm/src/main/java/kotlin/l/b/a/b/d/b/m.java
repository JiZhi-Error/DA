package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.pay.b;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.l.b.a.b.d.b.k;
import kotlin.l.b.a.b.j.e.c;
import kotlin.l.b.a.b.j.e.d;
import kotlin.n.n;

/* access modifiers changed from: package-private */
public final class m implements l<k> {
    public static final m TvN = new m();

    static {
        AppMethodBeat.i(58216);
        AppMethodBeat.o(58216);
    }

    private m() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.l.b.a.b.d.b.l
    public final /* synthetic */ k btM(String str) {
        AppMethodBeat.i(58210);
        k btO = btO(str);
        AppMethodBeat.o(58210);
        return btO;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.l.b.a.b.d.b.l
    public final /* synthetic */ k btN(String str) {
        AppMethodBeat.i(58212);
        k.b btP = btP(str);
        AppMethodBeat.o(58212);
        return btP;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.l.b.a.b.d.b.l
    public final /* synthetic */ k fu(k kVar) {
        AppMethodBeat.i(58208);
        k kVar2 = kVar;
        p.h(kVar2, "possiblyPrimitiveType");
        if (!(kVar2 instanceof k.c) || ((k.c) kVar2).TvM == null) {
            AppMethodBeat.o(58208);
            return kVar2;
        }
        c q = c.q(((k.c) kVar2).TvM.hKL());
        p.g(q, "JvmClassName.byFqNameWit…mitiveType.wrapperFqName)");
        String hKI = q.hKI();
        p.g(hKI, "JvmClassName.byFqNameWit…apperFqName).internalName");
        k.b btP = btP(hKI);
        AppMethodBeat.o(58208);
        return btP;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.l.b.a.b.d.b.l
    public final /* synthetic */ String toString(k kVar) {
        AppMethodBeat.i(58214);
        String a2 = a(kVar);
        AppMethodBeat.o(58214);
        return a2;
    }

    private k btO(String str) {
        d dVar;
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(58209);
        p.h(str, "representation");
        boolean z3 = str.length() > 0;
        if (!aa.SXc || z3) {
            char charAt = str.charAt(0);
            d[] values = d.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    dVar = null;
                    break;
                }
                d dVar2 = values[i2];
                if (dVar2.getDesc().charAt(0) == charAt) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    dVar = dVar2;
                    break;
                }
                i2++;
            }
            if (dVar != null) {
                k.c cVar = new k.c(dVar);
                AppMethodBeat.o(58209);
                return cVar;
            }
            switch (charAt) {
                case b.CTRL_INDEX:
                    k.c cVar2 = new k.c(null);
                    AppMethodBeat.o(58209);
                    return cVar2;
                case PlayerException.EXCEPTION_IN_PREPARE:
                    String substring = str.substring(1);
                    p.g(substring, "(this as java.lang.String).substring(startIndex)");
                    k.a aVar = new k.a(btO(substring));
                    AppMethodBeat.o(58209);
                    return aVar;
                default:
                    if (charAt == 'L' && n.a((CharSequence) str, ';')) {
                        z2 = true;
                    }
                    if (!aa.SXc || z2) {
                        String substring2 = str.substring(1, str.length() - 1);
                        p.g(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        k.b bVar = new k.b(substring2);
                        AppMethodBeat.o(58209);
                        return bVar;
                    }
                    AssertionError assertionError = new AssertionError("Type that is not primitive nor array should be Object, but '" + str + "' was found");
                    AppMethodBeat.o(58209);
                    throw assertionError;
            }
        } else {
            AssertionError assertionError2 = new AssertionError("empty string as JvmType");
            AppMethodBeat.o(58209);
            throw assertionError2;
        }
    }

    private static k.b btP(String str) {
        AppMethodBeat.i(58211);
        p.h(str, "internalName");
        k.b bVar = new k.b(str);
        AppMethodBeat.o(58211);
        return bVar;
    }

    public final String a(k kVar) {
        String desc;
        AppMethodBeat.i(58213);
        p.h(kVar, "type");
        if (kVar instanceof k.a) {
            String str = "[" + a(((k.a) kVar).TvK);
            AppMethodBeat.o(58213);
            return str;
        } else if (kVar instanceof k.c) {
            d dVar = ((k.c) kVar).TvM;
            if (dVar == null || (desc = dVar.getDesc()) == null) {
                AppMethodBeat.o(58213);
                return "V";
            }
            AppMethodBeat.o(58213);
            return desc;
        } else if (kVar instanceof k.b) {
            String str2 = "L" + ((k.b) kVar).TvL + ";";
            AppMethodBeat.o(58213);
            return str2;
        } else {
            kotlin.m mVar = new kotlin.m();
            AppMethodBeat.o(58213);
            throw mVar;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.l.b.a.b.d.b.l
    public final /* synthetic */ k hEn() {
        AppMethodBeat.i(58215);
        k.b btP = btP("java/lang/Class");
        AppMethodBeat.o(58215);
        return btP;
    }
}
