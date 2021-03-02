package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k;
import kotlin.l;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.r;
import kotlin.l.b.a.y;
import kotlin.l.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0010\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001cB\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB)\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\r\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\n\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u001b\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0019R(\u0010\u000f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \u0012*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00110\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0014X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, hxF = {"Lkotlin/reflect/jvm/internal/KProperty0Impl;", "R", "Lkotlin/reflect/KProperty0;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "_getter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "kotlin.jvm.PlatformType", "delegateFieldValue", "Lkotlin/Lazy;", "getter", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "get", "()Ljava/lang/Object;", "getDelegate", "invoke", "Getter", "kotlin-reflection"})
public class o<R> extends r<R> implements kotlin.l.l<R> {
    private final y.b<a<R>> TaV;
    private final f<Object> TaW = g.a(k.PUBLICATION, new c(this));

    @Override // kotlin.l.b.a.r
    public final /* synthetic */ r.c hyJ() {
        AppMethodBeat.i(56448);
        a<R> hyI = hyI();
        AppMethodBeat.o(56448);
        return hyI;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(i iVar, ah ahVar) {
        super(iVar, ahVar);
        p.h(iVar, "container");
        p.h(ahVar, "descriptor");
        AppMethodBeat.i(56451);
        y.b<a<R>> aj = y.aj(new b(this));
        p.g(aj, "ReflectProperties.lazy { Getter(this) }");
        this.TaV = aj;
        AppMethodBeat.o(56451);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(i iVar, String str, String str2, Object obj) {
        super(iVar, str, str2, obj);
        p.h(iVar, "container");
        p.h(str, "name");
        p.h(str2, "signature");
        AppMethodBeat.i(56452);
        y.b<a<R>> aj = y.aj(new b(this));
        p.g(aj, "ReflectProperties.lazy { Getter(this) }");
        this.TaV = aj;
        AppMethodBeat.o(56452);
    }

    private a<R> hyI() {
        AppMethodBeat.i(56446);
        a<R> invoke = this.TaV.invoke();
        p.g(invoke, "_getter()");
        a<R> aVar = invoke;
        AppMethodBeat.o(56446);
        return aVar;
    }

    @Override // kotlin.l.l
    public final R get() {
        AppMethodBeat.i(56449);
        R ag = hyI().ag(new Object[0]);
        AppMethodBeat.o(56449);
        return ag;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "R", "invoke"})
    static final class c extends q implements kotlin.g.a.a<Object> {
        final /* synthetic */ o TaY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(o oVar) {
            super(0);
            this.TaY = oVar;
        }

        @Override // kotlin.g.a.a
        public final Object invoke() {
            AppMethodBeat.i(56445);
            Object a2 = this.TaY.a(this.TaY.hyN(), this.TaY.hxQ());
            AppMethodBeat.o(56445);
            return a2;
        }
    }

    @Override // kotlin.g.a.a
    public R invoke() {
        AppMethodBeat.i(56450);
        R r = get();
        AppMethodBeat.o(56450);
        return r;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\nR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, hxF = {"Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "Lkotlin/reflect/KProperty0$Getter;", "property", "Lkotlin/reflect/jvm/internal/KProperty0Impl;", "(Lkotlin/reflect/jvm/internal/KProperty0Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty0Impl;", "invoke", "()Ljava/lang/Object;", "kotlin-reflection"})
    public static final class a<R> extends r.c<R> implements l.a<R> {
        private final o<R> TaX;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.l.b.a.o<? extends R> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(o<? extends R> oVar) {
            p.h(oVar, "property");
            AppMethodBeat.i(56443);
            this.TaX = oVar;
            AppMethodBeat.o(56443);
        }

        @Override // kotlin.g.a.a
        public final R invoke() {
            AppMethodBeat.i(56442);
            R r = this.TaX.get();
            AppMethodBeat.o(56442);
            return r;
        }

        @Override // kotlin.l.b.a.r.a
        public final /* bridge */ /* synthetic */ r hyF() {
            return this.TaX;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "R", "invoke"})
    static final class b extends q implements kotlin.g.a.a<a<? extends R>> {
        final /* synthetic */ o TaY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(o oVar) {
            super(0);
            this.TaY = oVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(56444);
            a aVar = new a(this.TaY);
            AppMethodBeat.o(56444);
            return aVar;
        }
    }
}
