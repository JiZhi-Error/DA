package kotlinx.a.c;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.a.j;
import kotlin.g.b.i;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 42\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002:\u00014B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002¢\u0006\u0002\u0010\u0004J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002HÆ\u0003J\u0011\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0001H\u0003J\u0017\u0010\u0012\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H\u0001J\u0019\u0010\u0015\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0011\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u000bH\u0003J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u000bJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u001a\u001a\u00020\u000bJ\"\u0010\u001d\u001a\u0002H\u001e\"\n\b\u0000\u0010\u001e\u0018\u0001*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u000bH\b¢\u0006\u0002\u0010\u001fJ$\u0010 \u001a\u0004\u0018\u0001H\u001e\"\n\b\u0000\u0010\u001e\u0018\u0001*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u000bH\b¢\u0006\u0002\u0010\u001fJ\u000e\u0010!\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\u000bJ\u0010\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001a\u001a\u00020\u000bJ\u000e\u0010$\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u000bJ\u0010\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010\u001a\u001a\u00020\u000bJ\b\u0010'\u001a\u00020\u000bH\u0016J\u0011\u0010(\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0001H\u0001J\t\u0010)\u001a\u00020\u0010H\u0001J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010+H\u0003J\u0011\u0010,\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0001H\u0001J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00010.H\u0001J\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00010.2\u0006\u0010\u001a\u001a\u00020\u000bH\u0001J\u001f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u000bH\u0001J\b\u00102\u001a\u000203H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u00065"}, hxF = {"Lkotlinx/serialization/json/JsonArray;", "Lkotlinx/serialization/json/JsonElement;", "", "content", "(Ljava/util/List;)V", "getContent", "()Ljava/util/List;", "jsonArray", "getJsonArray", "()Lkotlinx/serialization/json/JsonArray;", "size", "", "getSize", "()I", "component1", "contains", "", "element", "containsAll", MessengerShareContentUtility.ELEMENTS, "", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "", "get", FirebaseAnalytics.b.INDEX, "getArray", "getArrayOrNull", "getAs", "J", "(I)Lkotlinx/serialization/json/JsonElement;", "getAsOrNull", "getObject", "Lkotlinx/serialization/json/JsonObject;", "getObjectOrNull", "getPrimitive", "Lkotlinx/serialization/json/JsonPrimitive;", "getPrimitiveOrNull", "hashCode", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "toString", "", "Companion", "kotlinx-serialization-runtime"})
public final class b extends f implements List<f>, kotlin.g.b.a.a {
    public static final a TZo = new a((byte) 0);
    private final b TZm = this;
    public final List<f> TZn;

    static {
        AppMethodBeat.i(225785);
        AppMethodBeat.o(225785);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // java.util.List
    public final /* synthetic */ void add(int i2, f fVar) {
        AppMethodBeat.i(225807);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(225807);
        throw unsupportedOperationException;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.List, java.util.Collection
    public final /* synthetic */ boolean add(f fVar) {
        AppMethodBeat.i(225806);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(225806);
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public final boolean addAll(int i2, Collection<? extends f> collection) {
        AppMethodBeat.i(225798);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(225798);
        throw unsupportedOperationException;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends f> collection) {
        AppMethodBeat.i(225799);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(225799);
        throw unsupportedOperationException;
    }

    public final f awe(int i2) {
        AppMethodBeat.i(225789);
        f fVar = this.TZn.get(i2);
        p.g(fVar, "get(...)");
        f fVar2 = fVar;
        AppMethodBeat.o(225789);
        return fVar2;
    }

    public final void clear() {
        AppMethodBeat.i(225800);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(225800);
        throw unsupportedOperationException;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection<? extends Object> collection) {
        AppMethodBeat.i(225788);
        p.h(collection, MessengerShareContentUtility.ELEMENTS);
        boolean containsAll = this.TZn.containsAll(collection);
        AppMethodBeat.o(225788);
        return containsAll;
    }

    public final boolean isEmpty() {
        AppMethodBeat.i(225792);
        boolean isEmpty = this.TZn.isEmpty();
        AppMethodBeat.o(225792);
        return isEmpty;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<f> iterator() {
        AppMethodBeat.i(225793);
        Iterator<f> it = this.TZn.iterator();
        AppMethodBeat.o(225793);
        return it;
    }

    @Override // java.util.List
    public final ListIterator<f> listIterator() {
        AppMethodBeat.i(225795);
        ListIterator<f> listIterator = this.TZn.listIterator();
        AppMethodBeat.o(225795);
        return listIterator;
    }

    @Override // java.util.List
    public final ListIterator<f> listIterator(int i2) {
        AppMethodBeat.i(225796);
        ListIterator<f> listIterator = this.TZn.listIterator(i2);
        AppMethodBeat.o(225796);
        return listIterator;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List
    public final /* synthetic */ f remove(int i2) {
        AppMethodBeat.i(225808);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(225808);
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public final boolean remove(Object obj) {
        AppMethodBeat.i(225801);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(225801);
        throw unsupportedOperationException;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection<? extends Object> collection) {
        AppMethodBeat.i(225802);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(225802);
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public final void replaceAll(UnaryOperator<f> unaryOperator) {
        AppMethodBeat.i(225803);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(225803);
        throw unsupportedOperationException;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection<? extends Object> collection) {
        AppMethodBeat.i(225804);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(225804);
        throw unsupportedOperationException;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // java.util.List
    public final /* synthetic */ f set(int i2, f fVar) {
        AppMethodBeat.i(225809);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(225809);
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public final void sort(Comparator<? super f> comparator) {
        AppMethodBeat.i(225805);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(225805);
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public final List<f> subList(int i2, int i3) {
        AppMethodBeat.i(225797);
        List<f> subList = this.TZn.subList(i2, i3);
        AppMethodBeat.o(225797);
        return subList;
    }

    public final Object[] toArray() {
        AppMethodBeat.i(225810);
        Object[] w = i.w(this);
        AppMethodBeat.o(225810);
        return w;
    }

    @Override // java.util.List, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        AppMethodBeat.i(225811);
        T[] tArr2 = (T[]) i.a(this, tArr);
        AppMethodBeat.o(225811);
        return tArr2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, hxF = {"Lkotlinx/serialization/json/JsonArray$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonArray;", "kotlinx-serialization-runtime"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends kotlinx.a.c.f> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(List<? extends f> list) {
        super((byte) 0);
        p.h(list, "content");
        AppMethodBeat.i(225784);
        this.TZn = list;
        AppMethodBeat.o(225784);
    }

    public final boolean contains(Object obj) {
        AppMethodBeat.i(225787);
        if (!(obj instanceof f)) {
            AppMethodBeat.o(225787);
            return false;
        }
        f fVar = (f) obj;
        p.h(fVar, "element");
        boolean contains = this.TZn.contains(fVar);
        AppMethodBeat.o(225787);
        return contains;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List
    public final /* synthetic */ f get(int i2) {
        AppMethodBeat.i(225790);
        f awe = awe(i2);
        AppMethodBeat.o(225790);
        return awe;
    }

    public final int indexOf(Object obj) {
        AppMethodBeat.i(225791);
        if (!(obj instanceof f)) {
            AppMethodBeat.o(225791);
            return -1;
        }
        f fVar = (f) obj;
        p.h(fVar, "element");
        int indexOf = this.TZn.indexOf(fVar);
        AppMethodBeat.o(225791);
        return indexOf;
    }

    public final int lastIndexOf(Object obj) {
        AppMethodBeat.i(225794);
        if (!(obj instanceof f)) {
            AppMethodBeat.o(225794);
            return -1;
        }
        f fVar = (f) obj;
        p.h(fVar, "element");
        int lastIndexOf = this.TZn.lastIndexOf(fVar);
        AppMethodBeat.o(225794);
        return lastIndexOf;
    }

    public final String toString() {
        AppMethodBeat.i(225781);
        String a2 = j.a(this.TZn, ",", "[", "]", 0, (CharSequence) null, (kotlin.g.a.b) null, 56);
        AppMethodBeat.o(225781);
        return a2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(225782);
        boolean j2 = p.j(this.TZn, obj);
        AppMethodBeat.o(225782);
        return j2;
    }

    public final int hashCode() {
        AppMethodBeat.i(225783);
        int hashCode = this.TZn.hashCode();
        AppMethodBeat.o(225783);
        return hashCode;
    }

    public final /* bridge */ int size() {
        AppMethodBeat.i(225786);
        int size = this.TZn.size();
        AppMethodBeat.o(225786);
        return size;
    }
}
