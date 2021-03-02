package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.q;
import kotlin.k;
import kotlin.l;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.r;
import kotlin.l.b.a.y;
import kotlin.l.m;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004:\u0001\u001fB)\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB\u0017\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0015\u0010\u001a\u001a\u00028\u00012\u0006\u0010\u001b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ\u0017\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001e\u001a\u00028\u00012\u0006\u0010\u001b\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001cR4\u0010\u0010\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001 \u0013*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00120\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015X\u0004¢\u0006\u0002\n\u0000R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006 "}, hxF = {"Lkotlin/reflect/jvm/internal/KProperty1Impl;", "T", "R", "Lkotlin/reflect/KProperty1;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "_getter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "kotlin.jvm.PlatformType", "delegateField", "Lkotlin/Lazy;", "Ljava/lang/reflect/Field;", "getter", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "get", "receiver", "(Ljava/lang/Object;)Ljava/lang/Object;", "getDelegate", "invoke", "Getter", "kotlin-reflection"})
public class p<T, R> extends r<R> implements m<T, R> {
    private final y.b<a<T, R>> TaV;
    private final f<Field> TaZ = g.a(k.PUBLICATION, new c(this));

    @Override // kotlin.l.b.a.r
    public final /* synthetic */ r.c hyJ() {
        AppMethodBeat.i(56459);
        a<T, R> hyK = hyK();
        AppMethodBeat.o(56459);
        return hyK;
    }

    @Override // kotlin.l.m
    public final /* synthetic */ m.a hye() {
        AppMethodBeat.i(56458);
        a<T, R> hyK = hyK();
        AppMethodBeat.o(56458);
        return hyK;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(i iVar, String str, String str2, Object obj) {
        super(iVar, str, str2, obj);
        kotlin.g.b.p.h(iVar, "container");
        kotlin.g.b.p.h(str, "name");
        kotlin.g.b.p.h(str2, "signature");
        AppMethodBeat.i(56462);
        y.b<a<T, R>> aj = y.aj(new b(this));
        kotlin.g.b.p.g(aj, "ReflectProperties.lazy { Getter(this) }");
        this.TaV = aj;
        AppMethodBeat.o(56462);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(i iVar, ah ahVar) {
        super(iVar, ahVar);
        kotlin.g.b.p.h(iVar, "container");
        kotlin.g.b.p.h(ahVar, "descriptor");
        AppMethodBeat.i(56463);
        y.b<a<T, R>> aj = y.aj(new b(this));
        kotlin.g.b.p.g(aj, "ReflectProperties.lazy { Getter(this) }");
        this.TaV = aj;
        AppMethodBeat.o(56463);
    }

    private a<T, R> hyK() {
        AppMethodBeat.i(56457);
        a<T, R> invoke = this.TaV.invoke();
        kotlin.g.b.p.g(invoke, "_getter()");
        a<T, R> aVar = invoke;
        AppMethodBeat.o(56457);
        return aVar;
    }

    @Override // kotlin.l.m
    public final R get(T t) {
        AppMethodBeat.i(56460);
        R ag = hyK().ag(t);
        AppMethodBeat.o(56460);
        return ag;
    }

    @Override // kotlin.g.a.b
    public R invoke(T t) {
        AppMethodBeat.i(56461);
        R r = get(t);
        AppMethodBeat.o(56461);
        return r;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0006\b\u0003\u0010\u0002 \u00012\b\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\n\u001a\u00028\u00032\u0006\u0010\u000b\u001a\u00028\u0002H\u0002¢\u0006\u0002\u0010\fR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, hxF = {"Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "T", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "Lkotlin/reflect/KProperty1$Getter;", "property", "Lkotlin/reflect/jvm/internal/KProperty1Impl;", "(Lkotlin/reflect/jvm/internal/KProperty1Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty1Impl;", "invoke", "receiver", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class a<T, R> extends r.c<R> implements m.a<T, R> {
        private final p<T, R> Tba;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.l.b.a.p<T, ? extends R> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(p<T, ? extends R> pVar) {
            kotlin.g.b.p.h(pVar, "property");
            AppMethodBeat.i(56454);
            this.Tba = pVar;
            AppMethodBeat.o(56454);
        }

        @Override // kotlin.g.a.b
        public final R invoke(T t) {
            AppMethodBeat.i(56453);
            R r = this.Tba.get(t);
            AppMethodBeat.o(56453);
            return r;
        }

        @Override // kotlin.l.b.a.r.a
        public final /* bridge */ /* synthetic */ r hyF() {
            return this.Tba;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "T", "R", "invoke"})
    static final class b extends q implements kotlin.g.a.a<a<T, ? extends R>> {
        final /* synthetic */ p Tbb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(p pVar) {
            super(0);
            this.Tbb = pVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(56455);
            a aVar = new a(this.Tbb);
            AppMethodBeat.o(56455);
            return aVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Ljava/lang/reflect/Field;", "T", "R", "invoke"})
    static final class c extends q implements kotlin.g.a.a<Field> {
        final /* synthetic */ p Tbb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(p pVar) {
            super(0);
            this.Tbb = pVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Field invoke() {
            AppMethodBeat.i(56456);
            Field hyN = this.Tbb.hyN();
            AppMethodBeat.o(56456);
            return hyN;
        }
    }
}
