package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.k.f;
import kotlin.k.j;
import kotlin.l;
import kotlin.m.h;
import kotlin.o;
import kotlin.t;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BY\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012:\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u000fJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0002RB\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "input", "", "startIndex", "", "limit", "getNextMatch", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentIndex", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"})
public final class e implements h<f> {
    final CharSequence TST;
    final m<CharSequence, Integer, o<Integer, Integer>> TSU;
    final int limit;
    final int startIndex = 0;

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.g.a.m<? super java.lang.CharSequence, ? super java.lang.Integer, kotlin.o<java.lang.Integer, java.lang.Integer>> */
    /* JADX WARN: Multi-variable type inference failed */
    public e(CharSequence charSequence, int i2, int i3, m<? super CharSequence, ? super Integer, o<Integer, Integer>> mVar) {
        p.h(charSequence, "input");
        p.h(mVar, "getNextMatch");
        AppMethodBeat.i(206250);
        this.TST = charSequence;
        this.limit = i3;
        this.TSU = mVar;
        AppMethodBeat.o(206250);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\t\u0010\u0019\u001a\u00020\u001aH\u0002J\t\u0010\u001b\u001a\u00020\u0002H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001a\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\b¨\u0006\u001c"}, hxF = {"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "currentStartIndex", "getCurrentStartIndex", "setCurrentStartIndex", "nextItem", "getNextItem", "()Lkotlin/ranges/IntRange;", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextSearchIndex", "getNextSearchIndex", "setNextSearchIndex", "nextState", "getNextState", "setNextState", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
    public static final class a implements Iterator<f>, kotlin.g.b.a.a {
        private int TSV;
        private int TSW;
        private f TSX;
        final /* synthetic */ e TSY;
        private int TSy = -1;
        private int cBY;

        public final void remove() {
            AppMethodBeat.i(129464);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            AppMethodBeat.o(129464);
            throw unsupportedOperationException;
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(e eVar) {
            this.TSY = eVar;
            AppMethodBeat.i(129463);
            this.TSV = j.bh(eVar.startIndex, 0, eVar.TST.length());
            this.TSW = this.TSV;
            AppMethodBeat.o(129463);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0028, code lost:
            if (r7.cBY < r7.TSY.limit) goto L_0x002a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void hMe() {
            /*
            // Method dump skipped, instructions count: 159
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.n.e.a.hMe():void");
        }

        public final boolean hasNext() {
            AppMethodBeat.i(129462);
            if (this.TSy == -1) {
                hMe();
            }
            if (this.TSy == 1) {
                AppMethodBeat.o(129462);
                return true;
            }
            AppMethodBeat.o(129462);
            return false;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public final /* synthetic */ f next() {
            AppMethodBeat.i(129461);
            if (this.TSy == -1) {
                hMe();
            }
            if (this.TSy == 0) {
                NoSuchElementException noSuchElementException = new NoSuchElementException();
                AppMethodBeat.o(129461);
                throw noSuchElementException;
            }
            f fVar = this.TSX;
            if (fVar == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.ranges.IntRange");
                AppMethodBeat.o(129461);
                throw tVar;
            }
            this.TSX = null;
            this.TSy = -1;
            AppMethodBeat.o(129461);
            return fVar;
        }
    }

    @Override // kotlin.m.h
    public final Iterator<f> iterator() {
        AppMethodBeat.i(129455);
        a aVar = new a(this);
        AppMethodBeat.o(129455);
        return aVar;
    }
}
