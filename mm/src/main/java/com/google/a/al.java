package com.google.a;

import com.google.a.ae;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class al {
    private static final al bXN = new a((byte) 0);
    private static final al bXO = new b((byte) 0);

    /* access modifiers changed from: package-private */
    public abstract void a(Object obj, long j2);

    /* access modifiers changed from: package-private */
    public abstract <L> void a(Object obj, Object obj2, long j2);

    /* synthetic */ al(byte b2) {
        this();
    }

    private al() {
    }

    static al GS() {
        return bXN;
    }

    static al GT() {
        return bXO;
    }

    static final class a extends al {
        private static final Class<?> bXP = Collections.unmodifiableList(Collections.emptyList()).getClass();

        private a() {
            super((byte) 0);
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.a.al
        public final void a(Object obj, long j2) {
            Object unmodifiableList;
            List list = (List) ch.k(obj, j2);
            if (list instanceof ak) {
                unmodifiableList = ((ak) list).GR();
            } else if (bXP.isAssignableFrom(list.getClass())) {
                return;
            } else {
                if (!(list instanceof bk) || !(list instanceof ae.e)) {
                    unmodifiableList = Collections.unmodifiableList(list);
                } else if (((ae.e) list).yJ()) {
                    ((ae.e) list).yK();
                    return;
                } else {
                    return;
                }
            }
            ch.a(obj, j2, unmodifiableList);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.a.al
        public final <E> void a(Object obj, Object obj2, long j2) {
            List b2 = b(obj2, j2);
            int size = b2.size();
            List b3 = b(obj, j2);
            if (b3.isEmpty()) {
                if (b3 instanceof ak) {
                    b3 = new aj(size);
                } else if (!(b3 instanceof bk) || !(b3 instanceof ae.e)) {
                    b3 = new ArrayList(size);
                } else {
                    b3 = ((ae.e) b3).gI(size);
                }
                ch.a(obj, j2, b3);
            } else if (bXP.isAssignableFrom(b3.getClass())) {
                ArrayList arrayList = new ArrayList(size + b3.size());
                arrayList.addAll(b3);
                ch.a(obj, j2, arrayList);
                b3 = arrayList;
            } else if (b3 instanceof cg) {
                aj ajVar = new aj(size + b3.size());
                ajVar.addAll((cg) b3);
                ch.a(obj, j2, ajVar);
                b3 = ajVar;
            } else if ((b3 instanceof bk) && (b3 instanceof ae.e) && !((ae.e) b3).yJ()) {
                b3 = ((ae.e) b3).gI(b3.size() + size);
                ch.a(obj, j2, b3);
            }
            int size2 = b3.size();
            int size3 = b2.size();
            if (size2 > 0 && size3 > 0) {
                b3.addAll(b2);
            }
            if (size2 <= 0) {
                b3 = b2;
            }
            ch.a(obj, j2, b3);
        }

        private static <E> List<E> b(Object obj, long j2) {
            return (List) ch.k(obj, j2);
        }
    }

    static final class b extends al {
        private b() {
            super((byte) 0);
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.a.al
        public final void a(Object obj, long j2) {
            c(obj, j2).yK();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [com.google.a.ae$e] */
        /* access modifiers changed from: package-private */
        @Override // com.google.a.al
        public final <E> void a(Object obj, Object obj2, long j2) {
            ae.e<E> c2 = c(obj, j2);
            ae.e<E> c3 = c(obj2, j2);
            int size = c2.size();
            int size2 = c3.size();
            ae.e<E> eVar = c2;
            eVar = c2;
            if (size > 0 && size2 > 0) {
                boolean yJ = c2.yJ();
                ae.e<E> eVar2 = c2;
                if (!yJ) {
                    eVar2 = c2.gI(size2 + size);
                }
                eVar2.addAll(c3);
                eVar = eVar2;
            }
            if (size <= 0) {
                eVar = c3;
            }
            ch.a(obj, j2, eVar);
        }

        private static <E> ae.e<E> c(Object obj, long j2) {
            return (ae.e) ch.k(obj, j2);
        }
    }
}
