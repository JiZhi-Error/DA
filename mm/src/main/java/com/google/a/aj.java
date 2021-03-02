package com.google.a;

import com.google.a.ae;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class aj extends d<String> implements ak, RandomAccess {
    private static final aj bXL;
    public static final ak bXM = bXL;
    private final List<Object> list;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // com.google.a.d, java.util.List, java.util.AbstractList
    public final /* synthetic */ void add(int i2, String str) {
        yL();
        this.list.add(i2, str);
        this.modCount++;
    }

    @Override // com.google.a.d
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.a.d
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.a.d, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.a.d, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.a.d, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // com.google.a.d, java.util.List, java.util.AbstractList
    public final /* synthetic */ String set(int i2, String str) {
        yL();
        return as(this.list.set(i2, str));
    }

    @Override // com.google.a.ae.e, com.google.a.d
    public final /* bridge */ /* synthetic */ boolean yJ() {
        return super.yJ();
    }

    static {
        aj ajVar = new aj();
        bXL = ajVar;
        ajVar.bNd = false;
    }

    public aj() {
        this(10);
    }

    public aj(int i2) {
        this(new ArrayList(i2));
    }

    public aj(ak akVar) {
        this.list = new ArrayList(akVar.size());
        addAll(akVar);
    }

    private aj(ArrayList<Object> arrayList) {
        this.list = arrayList;
    }

    public final int size() {
        return this.list.size();
    }

    @Override // com.google.a.d, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.a.d, java.util.List, java.util.AbstractList
    public final boolean addAll(int i2, Collection<? extends String> collection) {
        yL();
        if (collection instanceof ak) {
            collection = ((ak) collection).GQ();
        }
        boolean addAll = this.list.addAll(i2, collection);
        this.modCount++;
        return addAll;
    }

    @Override // com.google.a.d
    public final void clear() {
        yL();
        this.list.clear();
        this.modCount++;
    }

    @Override // com.google.a.ak
    public final void d(g gVar) {
        yL();
        this.list.add(gVar);
        this.modCount++;
    }

    @Override // com.google.a.ak
    public final Object getRaw(int i2) {
        return this.list.get(i2);
    }

    private static String as(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof g) {
            return ((g) obj).yO();
        }
        return ae.G((byte[]) obj);
    }

    @Override // com.google.a.ak
    public final List<?> GQ() {
        return Collections.unmodifiableList(this.list);
    }

    @Override // com.google.a.ak
    public final ak GR() {
        if (super.yJ()) {
            return new cg(this);
        }
        return this;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.a.d, java.util.List, java.util.AbstractList
    public final /* synthetic */ String remove(int i2) {
        yL();
        Object remove = this.list.remove(i2);
        this.modCount++;
        return as(remove);
    }

    @Override // com.google.a.ae.e
    public final /* synthetic */ ae.e gI(int i2) {
        if (i2 < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i2);
        arrayList.addAll(this.list);
        return new aj(arrayList);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ String get(int i2) {
        Object obj = this.list.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            String yO = gVar.yO();
            if (gVar.yP()) {
                this.list.set(i2, yO);
            }
            return yO;
        }
        byte[] bArr = (byte[]) obj;
        String G = ae.G(bArr);
        if (ae.F(bArr)) {
            this.list.set(i2, G);
        }
        return G;
    }
}
