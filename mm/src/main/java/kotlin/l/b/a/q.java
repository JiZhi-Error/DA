package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.QLog;
import java.lang.reflect.Field;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.k;
import kotlin.l;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.r;
import kotlin.l.b.a.y;
import kotlin.l.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0006\b\u0002\u0010\u0003 \u00012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\b\u0012\u0004\u0012\u0002H\u00030\u0005:\u0001 B\u001f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bB\u0017\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u001d\u0010\u0019\u001a\u00028\u00022\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001cJ\u001f\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001cJ\u001e\u0010\u001f\u001a\u00028\u00022\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u001cR@\u0010\u000f\u001a4\u00120\u0012.\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002 \u0012*\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u00110\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R&\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006!"}, hxF = {"Lkotlin/reflect/jvm/internal/KProperty2Impl;", QLog.TAG_REPORTLEVEL_DEVELOPER, QLog.TAG_REPORTLEVEL_USER, "R", "Lkotlin/reflect/KProperty2;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "_getter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", "kotlin.jvm.PlatformType", "delegateField", "Lkotlin/Lazy;", "Ljava/lang/reflect/Field;", "getter", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", "get", "receiver1", "receiver2", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getDelegate", "", "invoke", "Getter", "kotlin-reflection"})
public class q<D, E, R> extends r<R> implements n<D, E, R> {
    private final y.b<a<D, E, R>> TaV;
    private final f<Field> TaZ = g.a(k.PUBLICATION, new c(this));

    @Override // kotlin.l.b.a.r
    public final /* synthetic */ r.c hyJ() {
        AppMethodBeat.i(56469);
        a<D, E, R> hyL = hyL();
        AppMethodBeat.o(56469);
        return hyL;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(i iVar, ah ahVar) {
        super(iVar, ahVar);
        p.h(iVar, "container");
        p.h(ahVar, "descriptor");
        AppMethodBeat.i(56472);
        y.b<a<D, E, R>> aj = y.aj(new b(this));
        p.g(aj, "ReflectProperties.lazy { Getter(this) }");
        this.TaV = aj;
        AppMethodBeat.o(56472);
    }

    private a<D, E, R> hyL() {
        AppMethodBeat.i(56468);
        a<D, E, R> invoke = this.TaV.invoke();
        p.g(invoke, "_getter()");
        a<D, E, R> aVar = invoke;
        AppMethodBeat.o(56468);
        return aVar;
    }

    public final R F(D d2, E e2) {
        AppMethodBeat.i(56470);
        R ag = hyL().ag(d2, e2);
        AppMethodBeat.o(56470);
        return ag;
    }

    @Override // kotlin.g.a.m
    public R invoke(D d2, E e2) {
        AppMethodBeat.i(56471);
        R F = F(d2, e2);
        AppMethodBeat.o(56471);
        return F;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0003\u0010\u0001*\u0004\b\u0004\u0010\u0002*\u0006\b\u0005\u0010\u0003 \u00012\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005B\u001f\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\u000b\u001a\u00028\u00052\u0006\u0010\f\u001a\u00028\u00032\u0006\u0010\r\u001a\u00028\u0004H\u0002¢\u0006\u0002\u0010\u000eR&\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, hxF = {"Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", QLog.TAG_REPORTLEVEL_DEVELOPER, QLog.TAG_REPORTLEVEL_USER, "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "Lkotlin/reflect/KProperty2$Getter;", "property", "Lkotlin/reflect/jvm/internal/KProperty2Impl;", "(Lkotlin/reflect/jvm/internal/KProperty2Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty2Impl;", "invoke", "receiver1", "receiver2", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class a<D, E, R> extends r.c<R> implements n.a<D, E, R> {
        private final q<D, E, R> Tbc;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.l.b.a.q<D, E, ? extends R> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(q<D, E, ? extends R> qVar) {
            p.h(qVar, "property");
            AppMethodBeat.i(56465);
            this.Tbc = qVar;
            AppMethodBeat.o(56465);
        }

        @Override // kotlin.g.a.m
        public final R invoke(D d2, E e2) {
            AppMethodBeat.i(56464);
            R F = this.Tbc.F(d2, e2);
            AppMethodBeat.o(56464);
            return F;
        }

        @Override // kotlin.l.b.a.r.a
        public final /* bridge */ /* synthetic */ r hyF() {
            return this.Tbc;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0006\b\u0002\u0010\u0004 \u0001H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", QLog.TAG_REPORTLEVEL_DEVELOPER, QLog.TAG_REPORTLEVEL_USER, "R", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<a<D, E, ? extends R>> {
        final /* synthetic */ q Tbd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(q qVar) {
            super(0);
            this.Tbd = qVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(56466);
            a aVar = new a(this.Tbd);
            AppMethodBeat.o(56466);
            return aVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0006\b\u0002\u0010\u0004 \u0001H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Ljava/lang/reflect/Field;", QLog.TAG_REPORTLEVEL_DEVELOPER, QLog.TAG_REPORTLEVEL_USER, "R", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<Field> {
        final /* synthetic */ q Tbd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(q qVar) {
            super(0);
            this.Tbd = qVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Field invoke() {
            AppMethodBeat.i(56467);
            Field hyN = this.Tbd.hyN();
            AppMethodBeat.o(56467);
            return hyN;
        }
    }
}
