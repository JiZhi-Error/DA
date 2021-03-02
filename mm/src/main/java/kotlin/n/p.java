package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\u001a!\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0002\b\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0002¢\u0006\u0002\b\u0007\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001aJ\u0010\t\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\b¢\u0006\u0002\b\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u001a\u001e\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u001a\n\u0010\u0013\u001a\u00020\u0002*\u00020\u0002\u001a\u0014\u0010\u0014\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002¨\u0006\u0015"}, hxF = {"getIndentFunction", "Lkotlin/Function1;", "", "indent", "getIndentFunction$StringsKt__IndentKt", "indentWidth", "", "indentWidth$StringsKt__IndentKt", "prependIndent", "reindent", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "replaceIndent", "newIndent", "replaceIndentByMargin", "marginPrefix", "trimIndent", "trimMargin", "kotlin-stdlib"}, hxG = 1)
public class p extends o {
    public static final String buv(String str) {
        AppMethodBeat.i(129467);
        kotlin.g.b.p.h(str, "$this$trimIndent");
        String oy = n.oy(str, "");
        AppMethodBeat.o(129467);
        return oy;
    }

    public static final String oy(String str, String str2) {
        String str3;
        AppMethodBeat.i(129468);
        kotlin.g.b.p.h(str, "$this$replaceIndent");
        kotlin.g.b.p.h(str2, "newIndent");
        List<String> aR = n.aR(str);
        ArrayList arrayList = new ArrayList();
        for (T t : aR) {
            if (!n.aL(t)) {
                arrayList.add(t);
            }
        }
        ArrayList<String> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(j.a(arrayList2, 10));
        for (String str4 : arrayList2) {
            arrayList3.add(Integer.valueOf(buw(str4)));
        }
        Integer num = (Integer) j.y(arrayList3);
        int intValue = num != null ? num.intValue() : 0;
        int length = str.length() + (str2.length() * aR.size());
        kotlin.g.a.b<String, String> bux = bux(str2);
        int kq = j.kq(aR);
        ArrayList arrayList4 = new ArrayList();
        int i2 = 0;
        for (T t2 : aR) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            T t3 = t2;
            if ((i2 == 0 || i2 == kq) && n.aL(t3)) {
                str3 = null;
            } else {
                String hV = n.hV(t3, intValue);
                if (hV == null || (str3 = bux.invoke(hV)) == null) {
                    str3 = t3;
                }
            }
            if (str3 != null) {
                arrayList4.add(str3);
                i2 = i3;
            } else {
                i2 = i3;
            }
        }
        String sb = ((StringBuilder) j.a(arrayList4, new StringBuilder(length), "\n", null, null, 0, null, null, 124)).toString();
        kotlin.g.b.p.g(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        AppMethodBeat.o(129468);
        return sb;
    }

    private static final int buw(String str) {
        int i2;
        AppMethodBeat.i(129469);
        String str2 = str;
        int length = str2.length();
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                i2 = -1;
                break;
            }
            if (!a.isWhitespace(str2.charAt(i3))) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 == -1) {
            int length2 = str.length();
            AppMethodBeat.o(129469);
            return length2;
        }
        AppMethodBeat.o(129469);
        return i2;
    }

    private static final kotlin.g.a.b<String, String> bux(String str) {
        AppMethodBeat.i(129470);
        if (str.length() == 0) {
            a aVar = a.TTl;
            AppMethodBeat.o(129470);
            return aVar;
        }
        b bVar = new b(str);
        AppMethodBeat.o(129470);
        return bVar;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "line", "invoke"})
    public static final class a extends q implements kotlin.g.a.b<String, String> {
        public static final a TTl = new a();

        static {
            AppMethodBeat.i(129443);
            AppMethodBeat.o(129443);
        }

        a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(String str) {
            AppMethodBeat.i(129442);
            String str2 = str;
            kotlin.g.b.p.h(str2, "line");
            AppMethodBeat.o(129442);
            return str2;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "line", "invoke"})
    public static final class b extends q implements kotlin.g.a.b<String, String> {
        final /* synthetic */ String TTm;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(1);
            this.TTm = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(String str) {
            AppMethodBeat.i(129434);
            String str2 = str;
            kotlin.g.b.p.h(str2, "line");
            String str3 = this.TTm + str2;
            AppMethodBeat.o(129434);
            return str3;
        }
    }
}
