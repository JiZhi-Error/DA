package com.tencent.matrix.trace.g;

import com.tencent.matrix.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public final class a {

    /* renamed from: com.tencent.matrix.trace.g.a$a  reason: collision with other inner class name */
    public interface AbstractC0238a {
        boolean b(long j2, int i2);

        void d(List<com.tencent.matrix.trace.d.a> list, int i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0108 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(long[] r17, java.util.LinkedList<com.tencent.matrix.trace.d.a> r18, boolean r19, long r20) {
        /*
        // Method dump skipped, instructions count: 501
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.matrix.trace.g.a.a(long[], java.util.LinkedList, boolean, long):void");
    }

    private static boolean bj(long j2) {
        return ((j2 >> 63) & 1) == 1;
    }

    private static int bk(long j2) {
        return (int) ((j2 >> 43) & 1048575);
    }

    private static int a(LinkedList<com.tencent.matrix.trace.d.a> linkedList, com.tencent.matrix.trace.d.a aVar) {
        com.tencent.matrix.trace.d.a aVar2;
        if (AppMethodBeat.isDev) {
            new StringBuilder("method:").append(aVar);
        }
        if (!linkedList.isEmpty()) {
            aVar2 = linkedList.peek();
        } else {
            aVar2 = null;
        }
        if (aVar2 == null || aVar2.dbJ != aVar.dbJ || aVar2.bCe != aVar.bCe || aVar.bCe == 0) {
            linkedList.push(aVar);
            return aVar.dbK;
        }
        aVar.dbK = aVar.dbK == 5000 ? aVar2.dbK : aVar.dbK;
        aVar2.bi((long) aVar.dbK);
        return aVar2.dbK;
    }

    private static void a(b bVar, LinkedList<com.tencent.matrix.trace.d.a> linkedList) {
        for (int i2 = 0; i2 < bVar.ddp.size(); i2++) {
            b bVar2 = bVar.ddp.get(i2);
            if (bVar2 != null) {
                if (bVar2.ddn != null) {
                    linkedList.add(bVar2.ddn);
                }
                if (!bVar2.ddp.isEmpty()) {
                    a(bVar2, linkedList);
                }
            }
        }
    }

    private static int a(LinkedList<com.tencent.matrix.trace.d.a> linkedList, b bVar) {
        ListIterator<com.tencent.matrix.trace.d.a> listIterator = linkedList.listIterator(0);
        int i2 = 0;
        b bVar2 = null;
        while (listIterator.hasNext()) {
            b bVar3 = new b(listIterator.next(), bVar2);
            int i3 = i2 + 1;
            if (bVar2 != null || bVar3.TI() == 0) {
                int TI = bVar3.TI();
                if (bVar2 == null || TI == 0) {
                    bVar.a(bVar3);
                } else if (bVar2.TI() >= TI) {
                    while (bVar2 != null && bVar2.TI() > TI) {
                        bVar2 = bVar2.ddo;
                    }
                    if (!(bVar2 == null || bVar2.ddo == null)) {
                        bVar3.ddo = bVar2.ddo;
                        bVar2.ddo.a(bVar3);
                    }
                } else {
                    bVar2.a(bVar3);
                }
                i2 = i3;
                bVar2 = bVar3;
            } else {
                c.e("Matrix.TraceDataUtils", "[stackToTree] begin error! why the first node'depth is not 0!", new Object[0]);
                return 0;
            }
        }
        return i2;
    }

    public static long a(LinkedList<com.tencent.matrix.trace.d.a> linkedList, StringBuilder sb, StringBuilder sb2) {
        sb2.append("|*\t\tTraceStack:\n");
        sb2.append("|*\t\t[id count cost]\n");
        Iterator<com.tencent.matrix.trace.d.a> it = linkedList.iterator();
        long j2 = 0;
        while (it.hasNext()) {
            com.tencent.matrix.trace.d.a next = it.next();
            sb.append(next.toString()).append('\n');
            StringBuilder append = sb2.append("|*\t\t");
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < next.bCe; i2++) {
                stringBuffer.append('.');
            }
            append.append(stringBuffer.toString() + next.dbJ + " " + next.count + " " + next.dbK).append('\n');
            if (j2 < ((long) next.dbK)) {
                j2 = (long) next.dbK;
            } else {
                j2 = j2;
            }
        }
        return j2;
    }

    public static final class b {
        com.tencent.matrix.trace.d.a ddn;
        b ddo;
        LinkedList<b> ddp = new LinkedList<>();

        b(com.tencent.matrix.trace.d.a aVar, b bVar) {
            this.ddn = aVar;
            this.ddo = bVar;
        }

        /* access modifiers changed from: package-private */
        public final int TI() {
            if (this.ddn == null) {
                return 0;
            }
            return this.ddn.bCe;
        }

        /* access modifiers changed from: package-private */
        public final void a(b bVar) {
            this.ddp.addFirst(bVar);
        }
    }

    public static void a(List<com.tencent.matrix.trace.d.a> list, AbstractC0238a aVar) {
        int size = list.size();
        int i2 = 1;
        while (size > 30) {
            ListIterator<com.tencent.matrix.trace.d.a> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                if (aVar.b((long) listIterator.previous().dbK, i2)) {
                    listIterator.remove();
                    size--;
                    if (size <= 30) {
                        return;
                    }
                } else {
                    size = size;
                }
            }
            size = list.size();
            int i3 = i2 + 1;
            if (60 < i3) {
                break;
            }
            i2 = i3;
        }
        int size2 = list.size();
        if (size2 > 30) {
            aVar.d(list, size2);
        }
    }

    public static String b(List<com.tencent.matrix.trace.d.a> list, long j2) {
        StringBuilder sb = new StringBuilder();
        long j3 = (long) (((float) j2) * 0.3f);
        LinkedList linkedList = new LinkedList();
        for (com.tencent.matrix.trace.d.a aVar : list) {
            if (((long) aVar.dbK) >= j3) {
                linkedList.add(aVar);
            }
        }
        Collections.sort(linkedList, new Comparator<com.tencent.matrix.trace.d.a>() {
            /* class com.tencent.matrix.trace.g.a.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(com.tencent.matrix.trace.d.a aVar, com.tencent.matrix.trace.d.a aVar2) {
                com.tencent.matrix.trace.d.a aVar3 = aVar;
                com.tencent.matrix.trace.d.a aVar4 = aVar2;
                return Integer.compare((aVar4.bCe + 1) * aVar4.dbK, (aVar3.bCe + 1) * aVar3.dbK);
            }
        });
        if (linkedList.isEmpty() && !list.isEmpty()) {
            linkedList.add(list.get(0));
        } else if (linkedList.size() > 1 && ((com.tencent.matrix.trace.d.a) linkedList.peek()).dbJ == 1048574) {
            linkedList.removeFirst();
        }
        Iterator it = linkedList.iterator();
        if (it.hasNext()) {
            sb.append(((com.tencent.matrix.trace.d.a) it.next()).dbJ + "|");
        }
        return sb.toString();
    }
}
