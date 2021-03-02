package kotlinx.a.b;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.QLog;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.h;
import kotlinx.a.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\b\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012*\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002H\u00010\u0004j\b\u0012\u0004\u0012\u0002H\u0001`\u00050\u0002B\u0013\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\r\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005H\u0014J\u001c\u0010\u000e\u001a\u00020\u000f*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005H\u0014J$\u0010\u0010\u001a\u00020\u0011*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u00052\u0006\u0010\u0012\u001a\u00020\u000fH\u0014J\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014*\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0014J\u0012\u0010\u0015\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0014J1\u0010\u0016\u001a\u00020\u0011*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u00052\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\"\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0014J\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005H\u0014R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001c"}, hxF = {"Lkotlinx/serialization/internal/LinkedHashSetSerializer;", QLog.TAG_REPORTLEVEL_USER, "Lkotlinx/serialization/internal/ListLikeSerializer;", "", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "eSerializer", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "builder", "builderSize", "", "checkCapacity", "", "size", "collectionIterator", "", "collectionSize", "insert", FirebaseAnalytics.b.INDEX, "element", "(Ljava/util/LinkedHashSet;ILjava/lang/Object;)V", "toBuilder", "toResult", "kotlinx-serialization-runtime"})
public final class ag<E> extends ai<E, Set<? extends E>, LinkedHashSet<E>> {
    private final n TXo;

    @Override // kotlinx.a.b.ai
    public final /* synthetic */ void a(Object obj, int i2, Object obj2) {
        AppMethodBeat.i(225586);
        LinkedHashSet linkedHashSet = (LinkedHashSet) obj;
        p.h(linkedHashSet, "$this$insert");
        linkedHashSet.add(obj2);
        AppMethodBeat.o(225586);
    }

    @Override // kotlinx.a.b.a
    public final /* synthetic */ int gj(Object obj) {
        AppMethodBeat.i(225580);
        Set set = (Set) obj;
        p.h(set, "$this$collectionSize");
        int size = set.size();
        AppMethodBeat.o(225580);
        return size;
    }

    @Override // kotlinx.a.b.a
    public final /* synthetic */ Iterator gk(Object obj) {
        AppMethodBeat.i(225581);
        Set set = (Set) obj;
        p.h(set, "$this$collectionIterator");
        Iterator<E> it = set.iterator();
        AppMethodBeat.o(225581);
        return it;
    }

    @Override // kotlinx.a.b.a
    public final /* synthetic */ int gl(Object obj) {
        AppMethodBeat.i(225583);
        LinkedHashSet linkedHashSet = (LinkedHashSet) obj;
        p.h(linkedHashSet, "$this$builderSize");
        int size = linkedHashSet.size();
        AppMethodBeat.o(225583);
        return size;
    }

    @Override // kotlinx.a.b.a
    public final /* synthetic */ Object gm(Object obj) {
        AppMethodBeat.i(225584);
        LinkedHashSet linkedHashSet = (LinkedHashSet) obj;
        p.h(linkedHashSet, "$this$toResult");
        LinkedHashSet linkedHashSet2 = linkedHashSet;
        AppMethodBeat.o(225584);
        return linkedHashSet2;
    }

    @Override // kotlinx.a.b.a
    public final /* synthetic */ Object gn(Object obj) {
        AppMethodBeat.i(225585);
        Set set = (Set) obj;
        p.h(set, "$this$toBuilder");
        LinkedHashSet linkedHashSet = (LinkedHashSet) (!(set instanceof LinkedHashSet) ? null : set);
        if (linkedHashSet == null) {
            linkedHashSet = new LinkedHashSet(set);
        }
        AppMethodBeat.o(225585);
        return linkedHashSet;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ag(h<E> hVar) {
        super(hVar, (byte) 0);
        p.h(hVar, "eSerializer");
        AppMethodBeat.i(225587);
        this.TXo = new af(hVar.fWv());
        AppMethodBeat.o(225587);
    }

    @Override // kotlinx.a.h, kotlinx.a.b.ai, kotlinx.a.f
    public final n fWv() {
        return this.TXo;
    }

    @Override // kotlinx.a.b.a
    public final /* synthetic */ Object hOE() {
        AppMethodBeat.i(225582);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        AppMethodBeat.o(225582);
        return linkedHashSet;
    }
}
