package kotlinx.a.b;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.h;
import kotlinx.a.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0007\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012*\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002H\u00010\u0004j\b\u0012\u0004\u0012\u0002H\u0001`\u00050\u0002B\u0013\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\r\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005H\u0014J\u001c\u0010\u000e\u001a\u00020\u000f*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005H\u0014J$\u0010\u0010\u001a\u00020\u0011*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u00052\u0006\u0010\u0012\u001a\u00020\u000fH\u0014J\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014*\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0014J\u0012\u0010\u0015\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0014J1\u0010\u0016\u001a\u00020\u0011*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u00052\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J\"\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0014J\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005H\u0014R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, hxF = {"Lkotlinx/serialization/internal/ArrayListSerializer;", QLog.TAG_REPORTLEVEL_USER, "Lkotlinx/serialization/internal/ListLikeSerializer;", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "element", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "builder", "builderSize", "", "checkCapacity", "", "size", "collectionIterator", "", "collectionSize", "insert", FirebaseAnalytics.b.INDEX, "(Ljava/util/ArrayList;ILjava/lang/Object;)V", "toBuilder", "toResult", "kotlinx-serialization-runtime"})
public final class e<E> extends ai<E, List<? extends E>, ArrayList<E>> {
    private final n TXo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(h<E> hVar) {
        super(hVar, (byte) 0);
        p.h(hVar, "element");
        AppMethodBeat.i(225597);
        this.TXo = new d(hVar.fWv());
        AppMethodBeat.o(225597);
    }

    @Override // kotlinx.a.b.ai
    public final /* synthetic */ void a(Object obj, int i2, Object obj2) {
        AppMethodBeat.i(225596);
        ArrayList arrayList = (ArrayList) obj;
        p.h(arrayList, "$this$insert");
        arrayList.add(i2, obj2);
        AppMethodBeat.o(225596);
    }

    @Override // kotlinx.a.b.a
    public final /* synthetic */ int gj(Object obj) {
        AppMethodBeat.i(225590);
        List list = (List) obj;
        p.h(list, "$this$collectionSize");
        int size = list.size();
        AppMethodBeat.o(225590);
        return size;
    }

    @Override // kotlinx.a.b.a
    public final /* synthetic */ Iterator gk(Object obj) {
        AppMethodBeat.i(225591);
        List list = (List) obj;
        p.h(list, "$this$collectionIterator");
        Iterator<E> it = list.iterator();
        AppMethodBeat.o(225591);
        return it;
    }

    @Override // kotlinx.a.b.a
    public final /* synthetic */ int gl(Object obj) {
        AppMethodBeat.i(225593);
        ArrayList arrayList = (ArrayList) obj;
        p.h(arrayList, "$this$builderSize");
        int size = arrayList.size();
        AppMethodBeat.o(225593);
        return size;
    }

    @Override // kotlinx.a.b.a
    public final /* synthetic */ Object gm(Object obj) {
        AppMethodBeat.i(225594);
        ArrayList arrayList = (ArrayList) obj;
        p.h(arrayList, "$this$toResult");
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(225594);
        return arrayList2;
    }

    @Override // kotlinx.a.b.a
    public final /* synthetic */ Object gn(Object obj) {
        AppMethodBeat.i(225595);
        List list = (List) obj;
        p.h(list, "$this$toBuilder");
        ArrayList arrayList = (ArrayList) (!(list instanceof ArrayList) ? null : list);
        if (arrayList == null) {
            arrayList = new ArrayList(list);
        }
        AppMethodBeat.o(225595);
        return arrayList;
    }

    @Override // kotlinx.a.h, kotlinx.a.b.ai, kotlinx.a.f
    public final n fWv() {
        return this.TXo;
    }

    @Override // kotlinx.a.b.a
    public final /* synthetic */ Object hOE() {
        AppMethodBeat.i(225592);
        ArrayList arrayList = new ArrayList();
        AppMethodBeat.o(225592);
        return arrayList;
    }
}
