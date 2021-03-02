package kotlin.n;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k.f;
import kotlin.l;
import kotlin.m.i;
import kotlin.n.i;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, hxF = {"Lkotlin/text/MatcherMatchResult;", "Lkotlin/text/MatchResult;", "matcher", "Ljava/util/regex/Matcher;", "input", "", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groupValues_", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "matchResult", "Ljava/util/regex/MatchResult;", "getMatchResult", "()Ljava/util/regex/MatchResult;", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "getValue", "()Ljava/lang/String;", "next", "kotlin-stdlib"})
public final class j implements i {
    private final CharSequence TST;
    private final g TTb = new b(this);
    private List<String> TTc;
    final Matcher TTd;

    public j(Matcher matcher, CharSequence charSequence) {
        p.h(matcher, "matcher");
        p.h(charSequence, "input");
        AppMethodBeat.i(129453);
        this.TTd = matcher;
        this.TST = charSequence;
        AppMethodBeat.o(129453);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u0011\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000fH\u0002R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, hxF = {"kotlin/text/MatcherMatchResult$groups$1", "Lkotlin/text/MatchNamedGroupCollection;", "Lkotlin/collections/AbstractCollection;", "Lkotlin/text/MatchGroup;", "size", "", "getSize", "()I", "get", FirebaseAnalytics.b.INDEX, "name", "", "isEmpty", "", "iterator", "", "kotlin-stdlib"})
    public static final class b extends kotlin.a.a<f> implements h {
        final /* synthetic */ j TTe;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Lkotlin/text/MatchGroup;", LocaleUtil.ITALIAN, "", "invoke"})
        static final class a extends q implements kotlin.g.a.b<Integer, f> {
            final /* synthetic */ b TTf;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar) {
                super(1);
                this.TTf = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ f invoke(Integer num) {
                AppMethodBeat.i(129354);
                f avS = this.TTf.avS(num.intValue());
                AppMethodBeat.o(129354);
                return avS;
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(j jVar) {
            this.TTe = jVar;
        }

        @Override // kotlin.a.a
        public final /* bridge */ boolean contains(Object obj) {
            AppMethodBeat.i(129438);
            if (!(obj != null ? obj instanceof f : true)) {
                AppMethodBeat.o(129438);
                return false;
            }
            boolean contains = super.contains((f) obj);
            AppMethodBeat.o(129438);
            return contains;
        }

        @Override // kotlin.a.a
        public final int getSize() {
            AppMethodBeat.i(129435);
            int groupCount = this.TTe.TTd.groupCount() + 1;
            AppMethodBeat.o(129435);
            return groupCount;
        }

        @Override // kotlin.a.a
        public final boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public final Iterator<f> iterator() {
            AppMethodBeat.i(129436);
            Iterator<f> it = i.d(kotlin.a.j.z(kotlin.a.j.r((Collection<?>) this)), new a(this)).iterator();
            AppMethodBeat.o(129436);
            return it;
        }

        @Override // kotlin.n.g
        public final f avS(int i2) {
            AppMethodBeat.i(129437);
            Matcher matcher = this.TTe.TTd;
            f mY = kotlin.k.j.mY(matcher.start(i2), matcher.end(i2));
            if (mY.SYU >= 0) {
                String group = this.TTe.TTd.group(i2);
                p.g(group, "matchResult.group(index)");
                f fVar = new f(group, mY);
                AppMethodBeat.o(129437);
                return fVar;
            }
            AppMethodBeat.o(129437);
            return null;
        }
    }

    @Override // kotlin.n.i
    public final g hMh() {
        return this.TTb;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, hxF = {"kotlin/text/MatcherMatchResult$groupValues$1", "Lkotlin/collections/AbstractList;", "", "size", "", "getSize", "()I", "get", FirebaseAnalytics.b.INDEX, "kotlin-stdlib"})
    public static final class a extends kotlin.a.b<String> {
        final /* synthetic */ j TTe;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(j jVar) {
            this.TTe = jVar;
        }

        @Override // kotlin.a.a
        public final /* bridge */ boolean contains(Object obj) {
            AppMethodBeat.i(129364);
            if (!(obj instanceof String)) {
                AppMethodBeat.o(129364);
                return false;
            }
            boolean contains = super.contains((String) obj);
            AppMethodBeat.o(129364);
            return contains;
        }

        @Override // kotlin.a.b
        public final /* bridge */ int indexOf(Object obj) {
            AppMethodBeat.i(129362);
            if (!(obj instanceof String)) {
                AppMethodBeat.o(129362);
                return -1;
            }
            int indexOf = super.indexOf((String) obj);
            AppMethodBeat.o(129362);
            return indexOf;
        }

        @Override // kotlin.a.b
        public final /* bridge */ int lastIndexOf(Object obj) {
            AppMethodBeat.i(129363);
            if (!(obj instanceof String)) {
                AppMethodBeat.o(129363);
                return -1;
            }
            int lastIndexOf = super.lastIndexOf((String) obj);
            AppMethodBeat.o(129363);
            return lastIndexOf;
        }

        @Override // kotlin.a.a
        public final int getSize() {
            AppMethodBeat.i(129360);
            int groupCount = this.TTe.TTd.groupCount() + 1;
            AppMethodBeat.o(129360);
            return groupCount;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.a.b, java.util.List
        public final /* synthetic */ String get(int i2) {
            AppMethodBeat.i(129361);
            String group = this.TTe.TTd.group(i2);
            if (group == null) {
                group = "";
            }
            AppMethodBeat.o(129361);
            return group;
        }
    }

    @Override // kotlin.n.i
    public final List<String> hMi() {
        AppMethodBeat.i(129452);
        if (this.TTc == null) {
            this.TTc = new a(this);
        }
        List<String> list = this.TTc;
        if (list == null) {
            p.hyc();
        }
        AppMethodBeat.o(129452);
        return list;
    }

    @Override // kotlin.n.i
    public final f hMg() {
        AppMethodBeat.i(206251);
        Matcher matcher = this.TTd;
        f mY = kotlin.k.j.mY(matcher.start(), matcher.end());
        AppMethodBeat.o(206251);
        return mY;
    }

    @Override // kotlin.n.i
    public final String getValue() {
        AppMethodBeat.i(129451);
        String group = this.TTd.group();
        p.g(group, "matchResult.group()");
        AppMethodBeat.o(129451);
        return group;
    }

    @Override // kotlin.n.i
    public final i.a hMj() {
        AppMethodBeat.i(129454);
        i.a aVar = new i.a(this);
        AppMethodBeat.o(129454);
        return aVar;
    }
}
