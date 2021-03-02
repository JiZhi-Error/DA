package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.l.b.a.b.h.h;

/* access modifiers changed from: package-private */
public class v<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private volatile v<K, V>.d TEk;
    boolean bUC;
    private final int bZc;
    private List<v<K, V>.b> bZd;
    private Map<K, V> bZe;

    /* synthetic */ v(int i2, byte b2) {
        this(i2);
    }

    static /* synthetic */ Object a(v vVar, int i2) {
        AppMethodBeat.i(59613);
        Object gN = vVar.gN(i2);
        AppMethodBeat.o(59613);
        return gN;
    }

    static /* synthetic */ void a(v vVar) {
        AppMethodBeat.i(59612);
        vVar.Hz();
        AppMethodBeat.o(59612);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.l.b.a.b.h.v<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        AppMethodBeat.i(59611);
        Object a2 = a((Comparable) obj, obj2);
        AppMethodBeat.o(59611);
        return a2;
    }

    static <FieldDescriptorType extends h.a<FieldDescriptorType>> v<FieldDescriptorType, Object> avE(int i2) {
        AppMethodBeat.i(59593);
        AnonymousClass1 r0 = new v<FieldDescriptorType, Object>(i2) {
            /* class kotlin.l.b.a.b.h.v.AnonymousClass1 */

            @Override // java.util.AbstractMap, java.util.Map, kotlin.l.b.a.b.h.v
            public final /* synthetic */ Object put(Object obj, Object obj2) {
                AppMethodBeat.i(59571);
                Object a2 = v.super.a((h.a) obj, obj2);
                AppMethodBeat.o(59571);
                return a2;
            }

            @Override // kotlin.l.b.a.b.h.v
            public final void yK() {
                AppMethodBeat.i(59570);
                if (!this.bUC) {
                    for (int i2 = 0; i2 < Hx(); i2++) {
                        Map.Entry<K, V> gM = gM(i2);
                        if (((h.a) gM.getKey()).FJ()) {
                            gM.setValue((V) Collections.unmodifiableList(gM.getValue()));
                        }
                    }
                    for (Map.Entry<K, V> entry : Hy()) {
                        if (((h.a) entry.getKey()).FJ()) {
                            entry.setValue((V) Collections.unmodifiableList(entry.getValue()));
                        }
                    }
                }
                v.super.yK();
                AppMethodBeat.o(59570);
            }
        };
        AppMethodBeat.o(59593);
        return r0;
    }

    private v(int i2) {
        AppMethodBeat.i(59594);
        this.bZc = i2;
        this.bZd = Collections.emptyList();
        this.bZe = Collections.emptyMap();
        AppMethodBeat.o(59594);
    }

    public void yK() {
        AppMethodBeat.i(59595);
        if (!this.bUC) {
            this.bZe = this.bZe.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.bZe);
            this.bUC = true;
        }
        AppMethodBeat.o(59595);
    }

    public final int Hx() {
        AppMethodBeat.i(59596);
        int size = this.bZd.size();
        AppMethodBeat.o(59596);
        return size;
    }

    public final Map.Entry<K, V> gM(int i2) {
        AppMethodBeat.i(59597);
        v<K, V>.b bVar = this.bZd.get(i2);
        AppMethodBeat.o(59597);
        return bVar;
    }

    public final Iterable<Map.Entry<K, V>> Hy() {
        AppMethodBeat.i(59598);
        if (this.bZe.isEmpty()) {
            Iterable<Map.Entry<K, V>> HC = a.HC();
            AppMethodBeat.o(59598);
            return HC;
        }
        Set<Map.Entry<K, V>> entrySet = this.bZe.entrySet();
        AppMethodBeat.o(59598);
        return entrySet;
    }

    public int size() {
        AppMethodBeat.i(59599);
        int size = this.bZd.size() + this.bZe.size();
        AppMethodBeat.o(59599);
        return size;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.l.b.a.b.h.v<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsKey(Object obj) {
        AppMethodBeat.i(59600);
        Comparable comparable = (Comparable) obj;
        if (a(comparable) >= 0 || this.bZe.containsKey(comparable)) {
            AppMethodBeat.o(59600);
            return true;
        }
        AppMethodBeat.o(59600);
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.l.b.a.b.h.v<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        AppMethodBeat.i(59601);
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            V v = (V) this.bZd.get(a2).getValue();
            AppMethodBeat.o(59601);
            return v;
        }
        V v2 = this.bZe.get(comparable);
        AppMethodBeat.o(59601);
        return v2;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, K] */
    public final V a(K k, V v) {
        AppMethodBeat.i(59602);
        Hz();
        int a2 = a(k);
        if (a2 >= 0) {
            V v2 = (V) this.bZd.get(a2).setValue(v);
            AppMethodBeat.o(59602);
            return v2;
        }
        HB();
        int i2 = -(a2 + 1);
        if (i2 >= this.bZc) {
            V put = HA().put(k, v);
            AppMethodBeat.o(59602);
            return put;
        }
        if (this.bZd.size() == this.bZc) {
            v<K, V>.b remove = this.bZd.remove(this.bZc - 1);
            HA().put(remove.bZj, (V) remove.getValue());
        }
        this.bZd.add(i2, new b(k, v));
        AppMethodBeat.o(59602);
        return null;
    }

    public void clear() {
        AppMethodBeat.i(59603);
        Hz();
        if (!this.bZd.isEmpty()) {
            this.bZd.clear();
        }
        if (!this.bZe.isEmpty()) {
            this.bZe.clear();
        }
        AppMethodBeat.o(59603);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.l.b.a.b.h.v<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        AppMethodBeat.i(59604);
        Hz();
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            V v = (V) gN(a2);
            AppMethodBeat.o(59604);
            return v;
        } else if (this.bZe.isEmpty()) {
            AppMethodBeat.o(59604);
            return null;
        } else {
            V remove = this.bZe.remove(comparable);
            AppMethodBeat.o(59604);
            return remove;
        }
    }

    private V gN(int i2) {
        AppMethodBeat.i(59605);
        Hz();
        V v = (V) this.bZd.remove(i2).getValue();
        if (!this.bZe.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = HA().entrySet().iterator();
            this.bZd.add(new b(this, it.next()));
            it.remove();
        }
        AppMethodBeat.o(59605);
        return v;
    }

    private int a(K k) {
        AppMethodBeat.i(59606);
        int i2 = 0;
        int size = this.bZd.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo(this.bZd.get(size).bZj);
            if (compareTo > 0) {
                int i3 = -(size + 2);
                AppMethodBeat.o(59606);
                return i3;
            } else if (compareTo == 0) {
                AppMethodBeat.o(59606);
                return size;
            }
        }
        int i4 = size;
        while (i2 <= i4) {
            int i5 = (i2 + i4) / 2;
            int compareTo2 = k.compareTo(this.bZd.get(i5).bZj);
            if (compareTo2 < 0) {
                i4 = i5 - 1;
            } else if (compareTo2 > 0) {
                i2 = i5 + 1;
            } else {
                AppMethodBeat.o(59606);
                return i5;
            }
        }
        int i6 = -(i2 + 1);
        AppMethodBeat.o(59606);
        return i6;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        AppMethodBeat.i(59607);
        if (this.TEk == null) {
            this.TEk = new d(this, (byte) 0);
        }
        v<K, V>.d dVar = this.TEk;
        AppMethodBeat.o(59607);
        return dVar;
    }

    private void Hz() {
        AppMethodBeat.i(59608);
        if (this.bUC) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(59608);
            throw unsupportedOperationException;
        }
        AppMethodBeat.o(59608);
    }

    private SortedMap<K, V> HA() {
        AppMethodBeat.i(59609);
        Hz();
        if (this.bZe.isEmpty() && !(this.bZe instanceof TreeMap)) {
            this.bZe = new TreeMap();
        }
        SortedMap<K, V> sortedMap = (SortedMap) this.bZe;
        AppMethodBeat.o(59609);
        return sortedMap;
    }

    private void HB() {
        AppMethodBeat.i(59610);
        Hz();
        if (this.bZd.isEmpty() && !(this.bZd instanceof ArrayList)) {
            this.bZd = new ArrayList(this.bZc);
        }
        AppMethodBeat.o(59610);
    }

    /* access modifiers changed from: package-private */
    public class b implements Comparable<v<K, V>.b>, Map.Entry<K, V> {
        final K bZj;
        private V value;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(v<K, V>.b bVar) {
            AppMethodBeat.i(59582);
            int compareTo = this.bZj.compareTo(bVar.bZj);
            AppMethodBeat.o(59582);
            return compareTo;
        }

        b(v vVar, Map.Entry<K, V> entry) {
            this(entry.getKey(), entry.getValue());
            AppMethodBeat.i(59576);
            AppMethodBeat.o(59576);
        }

        b(K k, V v) {
            this.bZj = k;
            this.value = v;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v) {
            AppMethodBeat.i(59577);
            v.a(v.this);
            V v2 = this.value;
            this.value = v;
            AppMethodBeat.o(59577);
            return v2;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(59578);
            if (obj == this) {
                AppMethodBeat.o(59578);
                return true;
            } else if (!(obj instanceof Map.Entry)) {
                AppMethodBeat.o(59578);
                return false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                if (!equals(this.bZj, entry.getKey()) || !equals(this.value, entry.getValue())) {
                    AppMethodBeat.o(59578);
                    return false;
                }
                AppMethodBeat.o(59578);
                return true;
            }
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(59579);
            int hashCode = this.bZj == null ? 0 : this.bZj.hashCode();
            if (this.value != null) {
                i2 = this.value.hashCode();
            }
            int i3 = hashCode ^ i2;
            AppMethodBeat.o(59579);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(59580);
            String valueOf = String.valueOf(String.valueOf(this.bZj));
            String valueOf2 = String.valueOf(String.valueOf(this.value));
            String sb = new StringBuilder(valueOf.length() + 1 + valueOf2.length()).append(valueOf).append("=").append(valueOf2).toString();
            AppMethodBeat.o(59580);
            return sb;
        }

        private static boolean equals(Object obj, Object obj2) {
            AppMethodBeat.i(59581);
            if (obj != null) {
                boolean equals = obj.equals(obj2);
                AppMethodBeat.o(59581);
                return equals;
            } else if (obj2 == null) {
                AppMethodBeat.o(59581);
                return true;
            } else {
                AppMethodBeat.o(59581);
                return false;
            }
        }

        @Override // java.util.Map.Entry
        public final /* bridge */ /* synthetic */ Object getKey() {
            return this.bZj;
        }
    }

    /* access modifiers changed from: package-private */
    public class d extends AbstractSet<Map.Entry<K, V>> {
        private d() {
        }

        /* synthetic */ d(v vVar, byte b2) {
            this();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.l.b.a.b.h.v */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final /* synthetic */ boolean add(Object obj) {
            AppMethodBeat.i(59592);
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                v.this.a((Comparable) entry.getKey(), entry.getValue());
                AppMethodBeat.o(59592);
                return true;
            }
            AppMethodBeat.o(59592);
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public final Iterator<Map.Entry<K, V>> iterator() {
            AppMethodBeat.i(59587);
            c cVar = new c(v.this, (byte) 0);
            AppMethodBeat.o(59587);
            return cVar;
        }

        public final int size() {
            AppMethodBeat.i(59588);
            int size = v.this.size();
            AppMethodBeat.o(59588);
            return size;
        }

        public final boolean contains(Object obj) {
            AppMethodBeat.i(59589);
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = v.this.get(entry.getKey());
            Object value = entry.getValue();
            if (obj2 == value || (obj2 != null && obj2.equals(value))) {
                AppMethodBeat.o(59589);
                return true;
            }
            AppMethodBeat.o(59589);
            return false;
        }

        public final boolean remove(Object obj) {
            AppMethodBeat.i(59590);
            Map.Entry entry = (Map.Entry) obj;
            if (contains(entry)) {
                v.this.remove(entry.getKey());
                AppMethodBeat.o(59590);
                return true;
            }
            AppMethodBeat.o(59590);
            return false;
        }

        public final void clear() {
            AppMethodBeat.i(59591);
            v.this.clear();
            AppMethodBeat.o(59591);
        }
    }

    class c implements Iterator<Map.Entry<K, V>> {
        private boolean bZl;
        private Iterator<Map.Entry<K, V>> bZm;
        private int pos;

        private c() {
            this.pos = -1;
        }

        /* synthetic */ c(v vVar, byte b2) {
            this();
        }

        public final boolean hasNext() {
            AppMethodBeat.i(59583);
            if (this.pos + 1 < v.this.bZd.size() || HE().hasNext()) {
                AppMethodBeat.o(59583);
                return true;
            }
            AppMethodBeat.o(59583);
            return false;
        }

        public final void remove() {
            AppMethodBeat.i(59584);
            if (!this.bZl) {
                IllegalStateException illegalStateException = new IllegalStateException("remove() was called before next()");
                AppMethodBeat.o(59584);
                throw illegalStateException;
            }
            this.bZl = false;
            v.a(v.this);
            if (this.pos < v.this.bZd.size()) {
                v vVar = v.this;
                int i2 = this.pos;
                this.pos = i2 - 1;
                v.a(vVar, i2);
                AppMethodBeat.o(59584);
                return;
            }
            HE().remove();
            AppMethodBeat.o(59584);
        }

        /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.Iterator<java.util.Map$Entry<K, V>>, java.util.Iterator<java.util.Map$Entry<K extends java.lang.Comparable<K>, V>> */
        private Iterator<Map.Entry<K, V>> HE() {
            AppMethodBeat.i(59585);
            if (this.bZm == null) {
                this.bZm = v.this.bZe.entrySet().iterator();
            }
            Iterator it = (Iterator<Map.Entry<K, V>>) this.bZm;
            AppMethodBeat.o(59585);
            return it;
        }

        @Override // java.util.Iterator
        public final /* synthetic */ Object next() {
            AppMethodBeat.i(59586);
            this.bZl = true;
            int i2 = this.pos + 1;
            this.pos = i2;
            if (i2 < v.this.bZd.size()) {
                Map.Entry entry = (Map.Entry) v.this.bZd.get(this.pos);
                AppMethodBeat.o(59586);
                return entry;
            }
            Map.Entry<K, V> next = HE().next();
            AppMethodBeat.o(59586);
            return next;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        private static final Iterator<Object> bZh = new Iterator<Object>() {
            /* class kotlin.l.b.a.b.h.v.a.AnonymousClass1 */

            public final boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public final Object next() {
                AppMethodBeat.i(59572);
                NoSuchElementException noSuchElementException = new NoSuchElementException();
                AppMethodBeat.o(59572);
                throw noSuchElementException;
            }

            public final void remove() {
                AppMethodBeat.i(59573);
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                AppMethodBeat.o(59573);
                throw unsupportedOperationException;
            }
        };
        private static final Iterable<Object> bZi = new Iterable<Object>() {
            /* class kotlin.l.b.a.b.h.v.a.AnonymousClass2 */

            @Override // java.lang.Iterable
            public final Iterator<Object> iterator() {
                AppMethodBeat.i(59574);
                Iterator<Object> it = a.bZh;
                AppMethodBeat.o(59574);
                return it;
            }
        };

        static {
            AppMethodBeat.i(59575);
            AppMethodBeat.o(59575);
        }

        static <T> Iterable<T> HC() {
            return (Iterable<T>) bZi;
        }
    }
}
