package com.tencent.magicbrush.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.l.h;
import kotlin.l.k;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007B)\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\tB3\u0012\b\u0010\n\u001a\u0004\u0018\u00018\u0000\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\fJ$\u0010\u0010\u001a\u00028\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0002¢\u0006\u0002\u0010\u0014J\u0014\u0010\u0015\u001a\u00020\u00162\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\bJ\u0013\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0017J,\u0010\u0018\u001a\u00020\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u0019\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u001aR\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\n\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/magicbrush/utils/Alias;", "R", "T", "", "receiver", "backingProperty", "Lkotlin/reflect/KMutableProperty1;", "(Ljava/lang/Object;Lkotlin/reflect/KMutableProperty1;)V", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/reflect/KMutableProperty1;)V", "receiver_field", "receiver_getter", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/reflect/KMutableProperty1;)V", "getReceiver", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setReceiver", "", "(Ljava/lang/Object;)V", "setValue", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "lib-magicbrush-nano_release"})
public class a<R, T> {
    private R cPp;
    private kotlin.g.a.a<? extends R> cPq;
    private final h<R, T> cPr;

    private a(kotlin.g.a.a<? extends R> aVar, h<R, T> hVar) {
        p.h(hVar, "backingProperty");
        AppMethodBeat.i(140286);
        this.cPp = null;
        this.cPq = aVar;
        this.cPr = hVar;
        AppMethodBeat.o(140286);
    }

    private R RD() {
        AppMethodBeat.i(140283);
        R r = this.cPp;
        if (r != null) {
            AppMethodBeat.o(140283);
            return r;
        }
        kotlin.g.a.a<? extends R> aVar = this.cPq;
        if (aVar == null) {
            p.hyc();
        }
        R r2 = (R) aVar.invoke();
        AppMethodBeat.o(140283);
        return r2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public a(kotlin.g.a.a<? extends R> aVar, h<R, T> hVar, byte b2) {
        this(aVar, hVar);
        p.h(aVar, "receiver");
        p.h(hVar, "backingProperty");
        AppMethodBeat.i(140287);
        AppMethodBeat.o(140287);
    }

    public final T a(k<?> kVar) {
        AppMethodBeat.i(140284);
        p.h(kVar, "property");
        T t = this.cPr.get(RD());
        AppMethodBeat.o(140284);
        return t;
    }

    public final void a(k<?> kVar, T t) {
        AppMethodBeat.i(140285);
        p.h(kVar, "property");
        this.cPr.set(RD(), t);
        AppMethodBeat.o(140285);
    }
}
