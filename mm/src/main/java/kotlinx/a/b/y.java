package kotlinx.a.b;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.h;
import kotlinx.a.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\b\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012*\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002H\u00010\u0004j\b\u0012\u0004\u0012\u0002H\u0001`\u00050\u0002B\u0013\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\r\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005H\u0014J\u001c\u0010\u000e\u001a\u00020\u000f*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005H\u0014J$\u0010\u0010\u001a\u00020\u0011*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u00052\u0006\u0010\u0012\u001a\u00020\u000fH\u0014J\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014*\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0014J\u0012\u0010\u0015\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0014J1\u0010\u0016\u001a\u00020\u0011*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u00052\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\"\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0014J\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005H\u0014R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001c"}, hxF = {"Lkotlinx/serialization/internal/HashSetSerializer;", QLog.TAG_REPORTLEVEL_USER, "Lkotlinx/serialization/internal/ListLikeSerializer;", "", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "eSerializer", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "builder", "builderSize", "", "checkCapacity", "", "size", "collectionIterator", "", "collectionSize", "insert", FirebaseAnalytics.b.INDEX, "element", "(Ljava/util/HashSet;ILjava/lang/Object;)V", "toBuilder", "toResult", "kotlinx-serialization-runtime"})
public final class y<E> extends ai<E, Set<? extends E>, HashSet<E>> {
    private final n TXo;

    @Override // kotlinx.a.b.ai
    public final /* synthetic */ void a(Object obj, int i2, Object obj2) {
        AppMethodBeat.i(225417);
        HashSet hashSet = (HashSet) obj;
        p.h(hashSet, "$this$insert");
        hashSet.add(obj2);
        AppMethodBeat.o(225417);
    }

    @Override // kotlinx.a.b.a
    public final /* synthetic */ int gj(Object obj) {
        AppMethodBeat.i(225411);
        Set set = (Set) obj;
        p.h(set, "$this$collectionSize");
        int size = set.size();
        AppMethodBeat.o(225411);
        return size;
    }

    @Override // kotlinx.a.b.a
    public final /* synthetic */ Iterator gk(Object obj) {
        AppMethodBeat.i(225412);
        Set set = (Set) obj;
        p.h(set, "$this$collectionIterator");
        Iterator<E> it = set.iterator();
        AppMethodBeat.o(225412);
        return it;
    }

    @Override // kotlinx.a.b.a
    public final /* synthetic */ int gl(Object obj) {
        AppMethodBeat.i(225414);
        HashSet hashSet = (HashSet) obj;
        p.h(hashSet, "$this$builderSize");
        int size = hashSet.size();
        AppMethodBeat.o(225414);
        return size;
    }

    @Override // kotlinx.a.b.a
    public final /* synthetic */ Object gm(Object obj) {
        AppMethodBeat.i(225415);
        HashSet hashSet = (HashSet) obj;
        p.h(hashSet, "$this$toResult");
        HashSet hashSet2 = hashSet;
        AppMethodBeat.o(225415);
        return hashSet2;
    }

    @Override // kotlinx.a.b.a
    public final /* synthetic */ Object gn(Object obj) {
        AppMethodBeat.i(225416);
        Set set = (Set) obj;
        p.h(set, "$this$toBuilder");
        HashSet hashSet = (HashSet) (!(set instanceof HashSet) ? null : set);
        if (hashSet == null) {
            hashSet = new HashSet(set);
        }
        AppMethodBeat.o(225416);
        return hashSet;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(h<E> hVar) {
        super(hVar, (byte) 0);
        p.h(hVar, "eSerializer");
        AppMethodBeat.i(225418);
        this.TXo = new x(hVar.fWv());
        AppMethodBeat.o(225418);
    }

    @Override // kotlinx.a.h, kotlinx.a.b.ai, kotlinx.a.f
    public final n fWv() {
        return this.TXo;
    }

    @Override // kotlinx.a.b.a
    public final /* synthetic */ Object hOE() {
        AppMethodBeat.i(225413);
        HashSet hashSet = new HashSet();
        AppMethodBeat.o(225413);
        return hashSet;
    }
}
