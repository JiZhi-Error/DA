package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.model.t;
import com.tencent.mm.plugin.finder.storage.data.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.a.j;
import kotlin.g.b.p;

public final class c {
    public static final boolean tUM;
    public static final a tUN = new a((byte) 0);
    public final String TAG = "Finder.FinderCommentLoader";
    public final ArrayList<s> data = new ArrayList<>();
    public long tUJ;
    public long tUK;
    public t tUL;

    static {
        AppMethodBeat.i(166031);
        AppMethodBeat.o(166031);
    }

    public c() {
        AppMethodBeat.i(166030);
        AppMethodBeat.o(166030);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(long j2, long j3, ArrayList<s> arrayList) {
            AppMethodBeat.i(166023);
            p.h(arrayList, "data");
            if (c.tUM) {
                AppMethodBeat.o(166023);
                return;
            }
            f fVar = f.vGd;
            ArrayList<s> arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(j.a(arrayList2, 10));
            Iterator<T> it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(it.next().uOf);
            }
            fVar.a(j2, j3, arrayList3);
            AppMethodBeat.o(166023);
        }
    }

    private final void a(t tVar) {
        AppMethodBeat.i(244550);
        this.tUL = tVar;
        this.data.add(tVar);
        AppMethodBeat.o(244550);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.o<com.tencent.mm.plugin.finder.storage.data.f.b, java.lang.Boolean> a(long r13, com.tencent.mm.plugin.finder.storage.FinderItem r15, long r16, boolean r18, int r19) {
        /*
        // Method dump skipped, instructions count: 395
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.feed.model.c.a(long, com.tencent.mm.plugin.finder.storage.FinderItem, long, boolean, int):kotlin.o");
    }

    public final s IL(int i2) {
        AppMethodBeat.i(166026);
        s sVar = this.data.get(i2);
        p.g(sVar, "data[index]");
        s sVar2 = sVar;
        AppMethodBeat.o(166026);
        return sVar2;
    }

    public final int b(s sVar) {
        int i2;
        boolean z;
        boolean z2;
        int i3 = 0;
        AppMethodBeat.i(178286);
        p.h(sVar, "item");
        Log.i(this.TAG, "addItem " + sVar.lT() + ", sort:true");
        if (sVar.uOf.dyb().commentId != 0) {
            Iterator<s> it = this.data.iterator();
            int i4 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                }
                if (it.next().uOf.dyb().commentId == sVar.uOf.dyb().commentId) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    i2 = i4;
                    break;
                }
                i4++;
            }
        } else {
            Iterator<s> it2 = this.data.iterator();
            int i5 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i2 = -1;
                    break;
                }
                if (it2.next().uOf.field_localCommentId == sVar.uOf.field_localCommentId) {
                    i2 = i5;
                    break;
                }
                i5++;
            }
        }
        if (i2 >= 0) {
            this.data.set(i2, sVar);
            AppMethodBeat.o(178286);
            return i2;
        } else if (sVar.uOf.field_actionInfo.tuf == 0) {
            this.data.size();
            if (sVar.uOf.field_state != -1 && sVar.uOf.dyb().displayid != 0) {
                Iterator<s> it3 = this.data.iterator();
                int i6 = 0;
                while (true) {
                    if (!it3.hasNext()) {
                        i3 = -1;
                        break;
                    }
                    if (it3.next().uOf.dyb().displayid <= sVar.uOf.dyb().displayid) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        i3 = i6;
                        break;
                    }
                    i6++;
                }
                if (i3 < 0) {
                    i3 = this.data.size();
                }
            } else if (this.tUL != null) {
                i3 = 1;
            }
            this.data.add(i3, sVar);
            AppMethodBeat.o(178286);
            return i3;
        } else {
            int t = t(sVar.uOf.field_actionInfo.tuf, true);
            this.data.add(t, sVar);
            AppMethodBeat.o(178286);
            return t;
        }
    }

    public static final class b<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(166024);
            int a2 = kotlin.b.a.a(Long.valueOf(t2.uOf.dyb().displayid), Long.valueOf(t.uOf.dyb().displayid));
            AppMethodBeat.o(166024);
            return a2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.finder.feed.model.c$c */
    public static final class C1158c<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(178285);
            int a2 = kotlin.b.a.a(Long.valueOf(t2.uOf.dyb().displayid), Long.valueOf(t.uOf.dyb().displayid));
            AppMethodBeat.o(178285);
            return a2;
        }
    }

    public final void a(List<? extends s> list, boolean z, boolean z2) {
        int i2 = 1;
        AppMethodBeat.i(166028);
        p.h(list, "itemList");
        List<s> dV = dV(list);
        if (dV.size() > 1) {
            j.a((List) dV, (Comparator) new b());
        }
        Log.i(this.TAG, "reduce size: " + (list.size() - dV.size()) + ", data size: " + this.data.size());
        if (z) {
            ArrayList<s> arrayList = this.data;
            if (this.tUL == null) {
                i2 = 0;
            }
            arrayList.addAll(i2, dV);
            AppMethodBeat.o(166028);
            return;
        }
        if (z2) {
            this.data.addAll(this.data.size(), dV);
        }
        AppMethodBeat.o(166028);
    }

    public final List<s> dV(List<? extends s> list) {
        int i2;
        boolean z;
        AppMethodBeat.i(178287);
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            int i3 = 0;
            Iterator<s> it = this.data.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i3 = -1;
                    break;
                }
                if (it.next().uOf.dyb().commentId == t.uOf.dyb().commentId) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    break;
                }
                i3++;
            }
            int i4 = 0;
            Iterator it2 = arrayList.iterator();
            while (true) {
                i2 = i4;
                if (!it2.hasNext()) {
                    i2 = -1;
                    break;
                }
                if (((s) it2.next()).uOf.dyb().commentId == t.uOf.dyb().commentId) {
                    break;
                }
                i4 = i2 + 1;
            }
            if (i3 >= 0) {
                this.data.set(i3, t);
                Log.i(this.TAG, "filter1:" + t.uOf.dyb().commentId + ", " + t.uOf.dyg());
            } else if (i2 >= 0) {
                Log.i(this.TAG, "filter2:" + t.uOf.dyb().commentId);
            } else {
                arrayList.add(t);
            }
        }
        AppMethodBeat.o(178287);
        return arrayList;
    }

    public final void EE(long j2) {
        AppMethodBeat.i(166029);
        ArrayList arrayList = new ArrayList();
        for (T t : this.data) {
            if (t.uOf.field_localCommentId == j2) {
                arrayList.add(t);
            }
        }
        this.data.removeAll(arrayList);
        AppMethodBeat.o(166029);
    }

    public static /* synthetic */ void a(c cVar) {
        AppMethodBeat.i(244553);
        cVar.nc(false);
        AppMethodBeat.o(244553);
    }

    public final void nc(boolean z) {
        t tVar;
        AppMethodBeat.i(244552);
        this.data.clear();
        if (z || (tVar = this.tUL) == null) {
            AppMethodBeat.o(244552);
            return;
        }
        a(tVar);
        AppMethodBeat.o(244552);
    }

    public final int t(long j2, boolean z) {
        boolean z2;
        int i2 = -1;
        AppMethodBeat.i(178288);
        Iterator<s> it = this.data.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            }
            if (it.next().uOf.dyb().commentId == j2) {
                break;
            }
            i3++;
        }
        ArrayList<s> arrayList = this.data;
        ListIterator<s> listIterator = arrayList.listIterator(arrayList.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                if (listIterator.previous().uOf.field_actionInfo.tuf == j2) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    i2 = listIterator.nextIndex();
                    break;
                }
            } else {
                break;
            }
        }
        if (!z || i2 < 0) {
            int i4 = i3 + 1;
            AppMethodBeat.o(178288);
            return i4;
        }
        int i5 = i2 + 1;
        AppMethodBeat.o(178288);
        return i5;
    }

    public final boolean c(s sVar) {
        int i2;
        AppMethodBeat.i(178289);
        p.h(sVar, "level2Comment");
        int i3 = 0;
        int i4 = -1;
        for (T t : this.data) {
            int i5 = i3 + 1;
            if (i3 < 0) {
                j.hxH();
            }
            T t2 = t;
            if (b(t2, sVar)) {
                Log.d(this.TAG, "hasLevel2ItemAfter cur:" + i3 + ", before:" + i4);
                if (i4 >= 0 && i3 > i4) {
                    AppMethodBeat.o(178289);
                    return true;
                }
                AppMethodBeat.o(178289);
                return false;
            }
            if (a(t2, sVar)) {
                i2 = i3;
            } else {
                i2 = i4;
            }
            i3 = i5;
            i4 = i2;
        }
        AppMethodBeat.o(178289);
        return false;
    }

    public static boolean b(s sVar, s sVar2) {
        AppMethodBeat.i(178291);
        p.h(sVar, "comment1");
        p.h(sVar2, "comment2");
        if (sVar.lT() == sVar2.lT()) {
            AppMethodBeat.o(178291);
            return true;
        }
        AppMethodBeat.o(178291);
        return false;
    }

    public static boolean a(s sVar, s sVar2) {
        AppMethodBeat.i(178290);
        p.h(sVar, "comment1");
        p.h(sVar2, "comment2");
        if (sVar.uOf.field_actionInfo.tuf == 0 || sVar.uOf.field_actionInfo.tuf != sVar2.uOf.field_actionInfo.tuf) {
            AppMethodBeat.o(178290);
            return false;
        }
        AppMethodBeat.o(178290);
        return true;
    }
}
