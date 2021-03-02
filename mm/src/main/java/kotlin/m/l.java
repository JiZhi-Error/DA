package kotlin.m;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u001c\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\b\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001a&\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0004\u001a<\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\b2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000b\u001a=\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\b2\b\u0010\f\u001a\u0004\u0018\u0001H\u00022\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000bH\u0007¢\u0006\u0002\u0010\r\u001a+\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0010\"\u0002H\u0002¢\u0006\u0002\u0010\u0011\u001a\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001aC\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0015*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u00050\u000bH\u0002¢\u0006\u0002\b\u0016\u001a)\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00170\u0001H\u0007¢\u0006\u0002\b\u0018\u001a\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0001\u001a2\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0004H\u0007\u001a!\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\b\u001a@\u0010\u001c\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u001e0\u001d\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0015*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00150\u001d0\u0001¨\u0006\u001f"}, hxF = {"Sequence", "Lkotlin/sequences/Sequence;", "T", "iterator", "Lkotlin/Function0;", "", "emptySequence", "generateSequence", "", "nextFunction", "seedFunction", "Lkotlin/Function1;", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "sequenceOf", MessengerShareContentUtility.ELEMENTS, "", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "asSequence", "constrainOnce", "flatten", "R", "flatten$SequencesKt__SequencesKt", "", "flattenSequenceOfIterable", "ifEmpty", "defaultValue", "orEmpty", "unzip", "Lkotlin/Pair;", "", "kotlin-stdlib"}, hxG = 1)
public class l extends k {

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¨\u0006\u0004¸\u0006\u0000"}, hxF = {"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"})
    public static final class a implements h<T> {
        final /* synthetic */ Iterator TSI;

        public a(Iterator it) {
            this.TSI = it;
        }

        @Override // kotlin.m.h
        public final Iterator<T> iterator() {
            return this.TSI;
        }
    }

    public static final <T> h<T> d(Iterator<? extends T> it) {
        AppMethodBeat.i(206259);
        p.h(it, "$this$asSequence");
        h<T> a2 = i.a(new a(it));
        AppMethodBeat.o(206259);
        return a2;
    }

    public static final <T> h<T> aj(T... tArr) {
        boolean z;
        AppMethodBeat.i(129530);
        p.h(tArr, MessengerShareContentUtility.ELEMENTS);
        if (tArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            d dVar = d.TSv;
            AppMethodBeat.o(129530);
            return dVar;
        }
        h<T> aa = kotlin.a.e.aa(tArr);
        AppMethodBeat.o(129530);
        return aa;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0004\n\u0002\b\u0006\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "T", "R", LocaleUtil.ITALIAN, "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"})
    public static final class c extends q implements kotlin.g.a.b<T, T> {
        public static final c TSK = new c();

        static {
            AppMethodBeat.i(129488);
            AppMethodBeat.o(129488);
        }

        c() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final T invoke(T t) {
            return t;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.m.h<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> h<T> a(h<? extends T> hVar) {
        AppMethodBeat.i(129531);
        p.h(hVar, "$this$constrainOnce");
        if (hVar instanceof a) {
            AppMethodBeat.o(129531);
            return hVar;
        }
        a aVar = new a(hVar);
        AppMethodBeat.o(129531);
        return aVar;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u0002H\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "T", "", LocaleUtil.ITALIAN, "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"})
    static final class d extends q implements kotlin.g.a.b<T, T> {
        final /* synthetic */ kotlin.g.a.a TSL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(kotlin.g.a.a aVar) {
            super(1);
            this.TSL = aVar;
        }

        @Override // kotlin.g.a.b
        public final T invoke(T t) {
            AppMethodBeat.i(129473);
            p.h(t, LocaleUtil.ITALIAN);
            T t2 = (T) this.TSL.invoke();
            AppMethodBeat.o(129473);
            return t2;
        }
    }

    public static final <T> h<T> ao(kotlin.g.a.a<? extends T> aVar) {
        AppMethodBeat.i(129532);
        p.h(aVar, "nextFunction");
        h<T> a2 = i.a(new g(aVar, new d(aVar)));
        AppMethodBeat.o(129532);
        return a2;
    }

    public static final <T> h<T> b(T t, kotlin.g.a.b<? super T, ? extends T> bVar) {
        AppMethodBeat.i(129533);
        p.h(bVar, "nextFunction");
        if (t == null) {
            d dVar = d.TSv;
            AppMethodBeat.o(129533);
            return dVar;
        }
        g gVar = new g(new e(t), bVar);
        AppMethodBeat.o(129533);
        return gVar;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "T", "", "invoke", "()Ljava/lang/Object;"})
    static final class e extends q implements kotlin.g.a.a<T> {
        final /* synthetic */ Object TSM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(Object obj) {
            super(0);
            this.TSM = obj;
        }

        @Override // kotlin.g.a.a
        public final T invoke() {
            return (T) this.TSM;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "T", LocaleUtil.ITALIAN, "Lkotlin/sequences/Sequence;", "invoke"})
    public static final class b extends q implements kotlin.g.a.b<h<? extends T>, Iterator<? extends T>> {
        public static final b TSJ = new b();

        static {
            AppMethodBeat.i(129476);
            AppMethodBeat.o(129476);
        }

        b() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Object invoke(Object obj) {
            AppMethodBeat.i(129475);
            h hVar = (h) obj;
            p.h(hVar, LocaleUtil.ITALIAN);
            Iterator it = hVar.iterator();
            AppMethodBeat.o(129475);
            return it;
        }
    }
}
