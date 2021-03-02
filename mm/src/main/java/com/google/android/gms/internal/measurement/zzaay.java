package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* access modifiers changed from: package-private */
public class zzaay<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzbls;
    private final int zzbtx;
    private List<zzabd> zzbty;
    private Map<K, V> zzbtz;
    private volatile zzabf zzbua;
    private Map<K, V> zzbub;

    private zzaay(int i2) {
        AppMethodBeat.i(40157);
        this.zzbtx = i2;
        this.zzbty = Collections.emptyList();
        this.zzbtz = Collections.emptyMap();
        this.zzbub = Collections.emptyMap();
        AppMethodBeat.o(40157);
    }

    /* synthetic */ zzaay(int i2, zzaaz zzaaz) {
        this(i2);
    }

    private final int zza(K k) {
        AppMethodBeat.i(40169);
        int i2 = 0;
        int size = this.zzbty.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.zzbty.get(size).getKey());
            if (compareTo > 0) {
                int i3 = -(size + 2);
                AppMethodBeat.o(40169);
                return i3;
            } else if (compareTo == 0) {
                AppMethodBeat.o(40169);
                return size;
            }
        }
        int i4 = size;
        while (i2 <= i4) {
            int i5 = (i2 + i4) / 2;
            int compareTo2 = k.compareTo((Comparable) this.zzbty.get(i5).getKey());
            if (compareTo2 < 0) {
                i4 = i5 - 1;
            } else if (compareTo2 > 0) {
                i2 = i5 + 1;
            } else {
                AppMethodBeat.o(40169);
                return i5;
            }
        }
        int i6 = -(i2 + 1);
        AppMethodBeat.o(40169);
        return i6;
    }

    static /* synthetic */ Object zza(zzaay zzaay, int i2) {
        AppMethodBeat.i(40177);
        Object zzai = zzaay.zzai(i2);
        AppMethodBeat.o(40177);
        return zzai;
    }

    static /* synthetic */ void zza(zzaay zzaay) {
        AppMethodBeat.i(40176);
        zzaay.zzul();
        AppMethodBeat.o(40176);
    }

    static <FieldDescriptorType extends zzzo<FieldDescriptorType>> zzaay<FieldDescriptorType, Object> zzag(int i2) {
        AppMethodBeat.i(40156);
        zzaaz zzaaz = new zzaaz(i2);
        AppMethodBeat.o(40156);
        return zzaaz;
    }

    private final V zzai(int i2) {
        AppMethodBeat.i(40168);
        zzul();
        V v = (V) this.zzbty.remove(i2).getValue();
        if (!this.zzbtz.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = zzum().entrySet().iterator();
            this.zzbty.add(new zzabd(this, it.next()));
            it.remove();
        }
        AppMethodBeat.o(40168);
        return v;
    }

    private final void zzul() {
        AppMethodBeat.i(40171);
        if (this.zzbls) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(40171);
            throw unsupportedOperationException;
        }
        AppMethodBeat.o(40171);
    }

    private final SortedMap<K, V> zzum() {
        AppMethodBeat.i(40172);
        zzul();
        if (this.zzbtz.isEmpty() && !(this.zzbtz instanceof TreeMap)) {
            this.zzbtz = new TreeMap();
            this.zzbub = ((TreeMap) this.zzbtz).descendingMap();
        }
        SortedMap<K, V> sortedMap = (SortedMap) this.zzbtz;
        AppMethodBeat.o(40172);
        return sortedMap;
    }

    public void clear() {
        AppMethodBeat.i(40166);
        zzul();
        if (!this.zzbty.isEmpty()) {
            this.zzbty.clear();
        }
        if (!this.zzbtz.isEmpty()) {
            this.zzbtz.clear();
        }
        AppMethodBeat.o(40166);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.android.gms.internal.measurement.zzaay<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsKey(Object obj) {
        AppMethodBeat.i(40163);
        Comparable comparable = (Comparable) obj;
        if (zza(comparable) >= 0 || this.zzbtz.containsKey(comparable)) {
            AppMethodBeat.o(40163);
            return true;
        }
        AppMethodBeat.o(40163);
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        AppMethodBeat.i(40170);
        if (this.zzbua == null) {
            this.zzbua = new zzabf(this, null);
        }
        zzabf zzabf = this.zzbua;
        AppMethodBeat.o(40170);
        return zzabf;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(40173);
        if (this == obj) {
            AppMethodBeat.o(40173);
            return true;
        } else if (!(obj instanceof zzaay)) {
            boolean equals = super.equals(obj);
            AppMethodBeat.o(40173);
            return equals;
        } else {
            zzaay zzaay = (zzaay) obj;
            int size = size();
            if (size != zzaay.size()) {
                AppMethodBeat.o(40173);
                return false;
            }
            int zzuj = zzuj();
            if (zzuj != zzaay.zzuj()) {
                boolean equals2 = entrySet().equals(zzaay.entrySet());
                AppMethodBeat.o(40173);
                return equals2;
            }
            for (int i2 = 0; i2 < zzuj; i2++) {
                if (!zzah(i2).equals(zzaay.zzah(i2))) {
                    AppMethodBeat.o(40173);
                    return false;
                }
            }
            if (zzuj != size) {
                boolean equals3 = this.zzbtz.equals(zzaay.zzbtz);
                AppMethodBeat.o(40173);
                return equals3;
            }
            AppMethodBeat.o(40173);
            return true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.android.gms.internal.measurement.zzaay<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        AppMethodBeat.i(40164);
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            V v = (V) this.zzbty.get(zza).getValue();
            AppMethodBeat.o(40164);
            return v;
        }
        V v2 = this.zzbtz.get(comparable);
        AppMethodBeat.o(40164);
        return v2;
    }

    public int hashCode() {
        AppMethodBeat.i(40174);
        int zzuj = zzuj();
        int i2 = 0;
        for (int i3 = 0; i3 < zzuj; i3++) {
            i2 += this.zzbty.get(i3).hashCode();
        }
        int hashCode = this.zzbtz.size() > 0 ? this.zzbtz.hashCode() + i2 : i2;
        AppMethodBeat.o(40174);
        return hashCode;
    }

    public final boolean isImmutable() {
        return this.zzbls;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.android.gms.internal.measurement.zzaay<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        AppMethodBeat.i(40175);
        Object zza = zza((Comparable) obj, obj2);
        AppMethodBeat.o(40175);
        return zza;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.android.gms.internal.measurement.zzaay<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        AppMethodBeat.i(40167);
        zzul();
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            V v = (V) zzai(zza);
            AppMethodBeat.o(40167);
            return v;
        } else if (this.zzbtz.isEmpty()) {
            AppMethodBeat.o(40167);
            return null;
        } else {
            V remove = this.zzbtz.remove(comparable);
            AppMethodBeat.o(40167);
            return remove;
        }
    }

    public int size() {
        AppMethodBeat.i(40162);
        int size = this.zzbty.size() + this.zzbtz.size();
        AppMethodBeat.o(40162);
        return size;
    }

    public final V zza(K k, V v) {
        AppMethodBeat.i(40165);
        zzul();
        int zza = zza(k);
        if (zza >= 0) {
            V v2 = (V) this.zzbty.get(zza).setValue(v);
            AppMethodBeat.o(40165);
            return v2;
        }
        zzul();
        if (this.zzbty.isEmpty() && !(this.zzbty instanceof ArrayList)) {
            this.zzbty = new ArrayList(this.zzbtx);
        }
        int i2 = -(zza + 1);
        if (i2 >= this.zzbtx) {
            V put = zzum().put(k, v);
            AppMethodBeat.o(40165);
            return put;
        }
        if (this.zzbty.size() == this.zzbtx) {
            zzabd remove = this.zzbty.remove(this.zzbtx - 1);
            zzum().put((K) ((Comparable) remove.getKey()), (V) remove.getValue());
        }
        this.zzbty.add(i2, new zzabd(this, k, v));
        AppMethodBeat.o(40165);
        return null;
    }

    public final Map.Entry<K, V> zzah(int i2) {
        AppMethodBeat.i(40160);
        zzabd zzabd = this.zzbty.get(i2);
        AppMethodBeat.o(40160);
        return zzabd;
    }

    public void zzrg() {
        AppMethodBeat.i(40158);
        if (!this.zzbls) {
            this.zzbtz = this.zzbtz.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzbtz);
            this.zzbub = this.zzbub.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzbub);
            this.zzbls = true;
        }
        AppMethodBeat.o(40158);
    }

    public final int zzuj() {
        AppMethodBeat.i(40159);
        int size = this.zzbty.size();
        AppMethodBeat.o(40159);
        return size;
    }

    public final Iterable<Map.Entry<K, V>> zzuk() {
        AppMethodBeat.i(40161);
        if (this.zzbtz.isEmpty()) {
            Iterable<Map.Entry<K, V>> zzun = zzaba.zzun();
            AppMethodBeat.o(40161);
            return zzun;
        }
        Set<Map.Entry<K, V>> entrySet = this.zzbtz.entrySet();
        AppMethodBeat.o(40161);
        return entrySet;
    }
}
