package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 ,2\u00060\u0001j\u0002`\u0002:\u0002,-B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001d\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0002\u0010\u000bB\u000f\b\u0001\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0017J\u0011\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0004J\"\u0010 \u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170\"J\u0016\u0010 \u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0004J\u0016\u0010$\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0004J\u001e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010'\u001a\u00020\u001bJ\u0006\u0010(\u001a\u00020\rJ\b\u0010)\u001a\u00020\u0004H\u0016J\b\u0010*\u001a\u00020+H\u0002R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006."}, hxF = {"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "(Ljava/lang/String;)V", "option", "Lkotlin/text/RegexOption;", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "options", "", "(Ljava/lang/String;Ljava/util/Set;)V", "nativePattern", "Ljava/util/regex/Pattern;", "(Ljava/util/regex/Pattern;)V", "_options", "getOptions", "()Ljava/util/Set;", "getPattern", "()Ljava/lang/String;", "containsMatchIn", "", "input", "", "find", "Lkotlin/text/MatchResult;", "startIndex", "", "findAll", "Lkotlin/sequences/Sequence;", "matchEntire", "matches", "replace", "transform", "Lkotlin/Function1;", "replacement", "replaceFirst", "split", "", "limit", "toPattern", "toString", "writeReplace", "", "Companion", "Serialized", "kotlin-stdlib"})
public final class k implements Serializable {
    public static final a TTh = new a((byte) 0);
    private final Pattern TTg;

    static {
        AppMethodBeat.i(129433);
        AppMethodBeat.o(129433);
    }

    public k(Pattern pattern) {
        p.h(pattern, "nativePattern");
        AppMethodBeat.i(129431);
        this.TTg = pattern;
        AppMethodBeat.o(129431);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public k(java.lang.String r4) {
        /*
            r3 = this;
            r2 = 129432(0x1f998, float:1.81373E-40)
            java.lang.String r0 = "pattern"
            kotlin.g.b.p.h(r4, r0)
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r4)
            java.lang.String r1 = "Pattern.compile(pattern)"
            kotlin.g.b.p.g(r0, r1)
            r3.<init>(r0)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.n.k.<init>(java.lang.String):void");
    }

    public final boolean aJ(CharSequence charSequence) {
        AppMethodBeat.i(129423);
        p.h(charSequence, "input");
        boolean matches = this.TTg.matcher(charSequence).matches();
        AppMethodBeat.o(129423);
        return matches;
    }

    public static /* synthetic */ i a(k kVar, CharSequence charSequence) {
        AppMethodBeat.i(129425);
        i p = kVar.p(charSequence, 0);
        AppMethodBeat.o(129425);
        return p;
    }

    public final i p(CharSequence charSequence, int i2) {
        AppMethodBeat.i(206254);
        p.h(charSequence, "input");
        Matcher matcher = this.TTg.matcher(charSequence);
        p.g(matcher, "nativePattern.matcher(input)");
        i a2 = l.a(matcher, i2, charSequence);
        AppMethodBeat.o(206254);
        return a2;
    }

    public final i aK(CharSequence charSequence) {
        AppMethodBeat.i(206255);
        p.h(charSequence, "input");
        Matcher matcher = this.TTg.matcher(charSequence);
        p.g(matcher, "nativePattern.matcher(input)");
        i a2 = l.a(matcher, charSequence);
        AppMethodBeat.o(206255);
        return a2;
    }

    public final String e(CharSequence charSequence, String str) {
        AppMethodBeat.i(129426);
        p.h(charSequence, "input");
        p.h(str, "replacement");
        String replaceAll = this.TTg.matcher(charSequence).replaceAll(str);
        p.g(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        AppMethodBeat.o(129426);
        return replaceAll;
    }

    public final String f(CharSequence charSequence, String str) {
        AppMethodBeat.i(129427);
        p.h(charSequence, "input");
        p.h(str, "replacement");
        String replaceFirst = this.TTg.matcher(charSequence).replaceFirst(str);
        p.g(replaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        AppMethodBeat.o(129427);
        return replaceFirst;
    }

    public final List<String> q(CharSequence charSequence, int i2) {
        int i3 = 10;
        AppMethodBeat.i(129428);
        p.h(charSequence, "input");
        if (!(i2 >= 0)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
            AppMethodBeat.o(129428);
            throw illegalArgumentException;
        }
        Matcher matcher = this.TTg.matcher(charSequence);
        if (!matcher.find() || i2 == 1) {
            List<String> listOf = j.listOf(charSequence.toString());
            AppMethodBeat.o(129428);
            return listOf;
        }
        if (i2 > 0) {
            i3 = kotlin.k.j.na(i2, 10);
        }
        ArrayList arrayList = new ArrayList(i3);
        int i4 = i2 - 1;
        int i5 = 0;
        do {
            arrayList.add(charSequence.subSequence(i5, matcher.start()).toString());
            i5 = matcher.end();
            if (i4 >= 0 && arrayList.size() == i4) {
                break;
            }
        } while (matcher.find());
        arrayList.add(charSequence.subSequence(i5, charSequence.length()).toString());
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(129428);
        return arrayList2;
    }

    public final String toString() {
        AppMethodBeat.i(129429);
        String pattern = this.TTg.toString();
        p.g(pattern, "nativePattern.toString()");
        AppMethodBeat.o(129429);
        return pattern;
    }

    private final Object writeReplace() {
        AppMethodBeat.i(129430);
        String pattern = this.TTg.pattern();
        p.g(pattern, "nativePattern.pattern()");
        b bVar = new b(pattern, this.TTg.flags());
        AppMethodBeat.o(129430);
        return bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000e2\u00060\u0001j\u0002`\u0002:\u0001\u000eB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, hxF = {"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "flags", "", "(Ljava/lang/String;I)V", "getFlags", "()I", "getPattern", "()Ljava/lang/String;", "readResolve", "", "Companion", "kotlin-stdlib"})
    static final class b implements Serializable {
        public static final a TTi = new a((byte) 0);
        private final int flags;
        private final String pattern;

        static {
            AppMethodBeat.i(129358);
            AppMethodBeat.o(129358);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lkotlin/text/Regex$Serialized$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        public b(String str, int i2) {
            p.h(str, "pattern");
            AppMethodBeat.i(129357);
            this.pattern = str;
            this.flags = i2;
            AppMethodBeat.o(129357);
        }

        private final Object readResolve() {
            AppMethodBeat.i(129356);
            Pattern compile = Pattern.compile(this.pattern, this.flags);
            p.g(compile, "Pattern.compile(pattern, flags)");
            k kVar = new k(compile);
            AppMethodBeat.o(129356);
            return kVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007¨\u0006\f"}, hxF = {"Lkotlin/text/Regex$Companion;", "", "()V", "ensureUnicodeCase", "", "flags", "escape", "", "literal", "escapeReplacement", "fromLiteral", "Lkotlin/text/Regex;", "kotlin-stdlib"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
