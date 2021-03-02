package com.tencent.mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h<E> extends LinkedList<E> {
    private byte[] lock = new byte[0];

    public h() {
        AppMethodBeat.i(111324);
        AppMethodBeat.o(111324);
    }

    public final E dRl() {
        E e2;
        AppMethodBeat.i(111325);
        synchronized (this.lock) {
            try {
                if (size() > 0) {
                    e2 = (E) super.poll();
                } else {
                    e2 = null;
                    AppMethodBeat.o(111325);
                }
            } finally {
                AppMethodBeat.o(111325);
            }
        }
        return e2;
    }

    private boolean check(E e2) {
        boolean contains;
        AppMethodBeat.i(111326);
        synchronized (this.lock) {
            try {
                contains = super.contains(e2);
            } finally {
                AppMethodBeat.o(111326);
            }
        }
        return contains;
    }

    public final void dr(E e2) {
        AppMethodBeat.i(111327);
        synchronized (this.lock) {
            try {
                if (check(e2)) {
                    super.remove(e2);
                }
            } finally {
                AppMethodBeat.o(111327);
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.util.Queue, java.util.LinkedList, java.util.Deque
    public final boolean add(E e2) {
        boolean add;
        AppMethodBeat.i(111328);
        synchronized (this.lock) {
            try {
                add = super.add(e2);
            } finally {
                AppMethodBeat.o(111328);
            }
        }
        return add;
    }

    public final int size() {
        int size;
        AppMethodBeat.i(111329);
        synchronized (this.lock) {
            try {
                size = super.size();
            } finally {
                AppMethodBeat.o(111329);
            }
        }
        return size;
    }

    public final void clear() {
        AppMethodBeat.i(111330);
        synchronized (this.lock) {
            try {
                super.clear();
            } finally {
                AppMethodBeat.o(111330);
            }
        }
    }
}
