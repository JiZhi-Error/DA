package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.r;
import kotlin.l.b.a.y;
import kotlin.l.h;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004:\u0001\u001cB)\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB\u0017\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u001d\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001bR4\u0010\u0010\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001 \u0013*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00120\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, hxF = {"Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;", "T", "R", "Lkotlin/reflect/jvm/internal/KProperty1Impl;", "Lkotlin/reflect/KMutableProperty1;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "_setter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "kotlin.jvm.PlatformType", "setter", "getSetter", "()Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "set", "", "receiver", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Setter", "kotlin-reflection"})
public final class l<T, R> extends p<T, R> implements h<T, R> {
    private final y.b<a<T, R>> TaL;

    @Override // kotlin.l.h
    public final /* synthetic */ h.a hyf() {
        AppMethodBeat.i(56403);
        a<T, R> hyG = hyG();
        AppMethodBeat.o(56403);
        return hyG;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(i iVar, String str, String str2, Object obj) {
        super(iVar, str, str2, obj);
        p.h(iVar, "container");
        p.h(str, "name");
        p.h(str2, "signature");
        AppMethodBeat.i(56405);
        y.b<a<T, R>> aj = y.aj(new b(this));
        p.g(aj, "ReflectProperties.lazy { Setter(this) }");
        this.TaL = aj;
        AppMethodBeat.o(56405);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(i iVar, ah ahVar) {
        super(iVar, ahVar);
        p.h(iVar, "container");
        p.h(ahVar, "descriptor");
        AppMethodBeat.i(56406);
        y.b<a<T, R>> aj = y.aj(new b(this));
        p.g(aj, "ReflectProperties.lazy { Setter(this) }");
        this.TaL = aj;
        AppMethodBeat.o(56406);
    }

    private a<T, R> hyG() {
        AppMethodBeat.i(56402);
        a<T, R> invoke = this.TaL.invoke();
        p.g(invoke, "_setter()");
        a<T, R> aVar = invoke;
        AppMethodBeat.o(56402);
        return aVar;
    }

    @Override // kotlin.l.h
    public final void set(T t, R r) {
        AppMethodBeat.i(56404);
        hyG().ag(t, r);
        AppMethodBeat.o(56404);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00022\u0006\u0010\r\u001a\u00028\u0003H\u0002¢\u0006\u0002\u0010\u000eR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, hxF = {"Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "T", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "Lkotlin/reflect/KMutableProperty1$Setter;", "property", "Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;", "(Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;", "invoke", "", "receiver", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-reflection"})
    public static final class a<T, R> extends r.d<R> implements h.a<T, R> {
        private final l<T, R> TaO;

        public a(l<T, R> lVar) {
            p.h(lVar, "property");
            AppMethodBeat.i(56400);
            this.TaO = lVar;
            AppMethodBeat.o(56400);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Object obj, Object obj2) {
            AppMethodBeat.i(56399);
            this.TaO.set(obj, obj2);
            x xVar = x.SXb;
            AppMethodBeat.o(56399);
            return xVar;
        }

        @Override // kotlin.l.b.a.r.a
        public final /* bridge */ /* synthetic */ r hyF() {
            return this.TaO;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "T", "R", "invoke"})
    static final class b extends q implements kotlin.g.a.a<a<T, R>> {
        final /* synthetic */ l TaP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(l lVar) {
            super(0);
            this.TaP = lVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(56401);
            a aVar = new a(this.TaP);
            AppMethodBeat.o(56401);
            return aVar;
        }
    }
}
