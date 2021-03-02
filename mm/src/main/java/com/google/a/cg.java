package com.google.a;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class cg extends AbstractList<String> implements ak, RandomAccess {
    private final ak cab;

    public cg(ak akVar) {
        this.cab = akVar;
    }

    @Override // com.google.a.ak
    public final Object getRaw(int i2) {
        return this.cab.getRaw(i2);
    }

    public final int size() {
        return this.cab.size();
    }

    @Override // com.google.a.ak
    public final void d(g gVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final ListIterator<String> listIterator(final int i2) {
        return new ListIterator<String>() {
            /* class com.google.a.cg.AnonymousClass1 */
            ListIterator<String> cac = cg.this.cab.listIterator(i2);

            public final boolean hasNext() {
                return this.cac.hasNext();
            }

            public final boolean hasPrevious() {
                return this.cac.hasPrevious();
            }

            public final int nextIndex() {
                return this.cac.nextIndex();
            }

            public final int previousIndex() {
                return this.cac.previousIndex();
            }

            public final void remove() {
                throw new UnsupportedOperationException();
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // java.util.ListIterator
            public final /* synthetic */ void add(String str) {
                throw new UnsupportedOperationException();
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // java.util.ListIterator
            public final /* synthetic */ void set(String str) {
                throw new UnsupportedOperationException();
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.ListIterator
            public final /* bridge */ /* synthetic */ String previous() {
                return this.cac.previous();
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.Iterator, java.util.ListIterator
            public final /* bridge */ /* synthetic */ String next() {
                return this.cac.next();
            }
        };
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Iterable
    public final Iterator<String> iterator() {
        return new Iterator<String>() {
            /* class com.google.a.cg.AnonymousClass2 */
            Iterator<String> bWx = cg.this.cab.iterator();

            public final boolean hasNext() {
                return this.bWx.hasNext();
            }

            public final void remove() {
                throw new UnsupportedOperationException();
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.Iterator
            public final /* bridge */ /* synthetic */ String next() {
                return this.bWx.next();
            }
        };
    }

    @Override // com.google.a.ak
    public final List<?> GQ() {
        return this.cab.GQ();
    }

    @Override // com.google.a.ak
    public final ak GR() {
        return this;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList
    public final /* bridge */ /* synthetic */ String get(int i2) {
        return (String) this.cab.get(i2);
    }
}
