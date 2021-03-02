package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.luggage.h.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import junit.framework.Assert;

/* access modifiers changed from: package-private */
public final class l extends ArrayList<AppBrandRecentTaskInfo> {
    private final ArrayList<AppBrandRecentTaskInfo> odI = new ArrayList<>(50);
    private final ArrayList<AppBrandRecentTaskInfo> odJ = new ArrayList<>(10000);

    @Override // java.lang.Object
    public final /* synthetic */ Object clone() {
        AppMethodBeat.i(49224);
        l bYL = bYL();
        AppMethodBeat.o(49224);
        return bYL;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList, java.util.ArrayList
    public final /* synthetic */ AppBrandRecentTaskInfo get(int i2) {
        AppMethodBeat.i(49223);
        AppBrandRecentTaskInfo zw = zw(i2);
        AppMethodBeat.o(49223);
        return zw;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList, java.util.ArrayList
    public final /* synthetic */ AppBrandRecentTaskInfo remove(int i2) {
        AppMethodBeat.i(49222);
        AppBrandRecentTaskInfo zx = zx(i2);
        AppMethodBeat.o(49222);
        return zx;
    }

    l() {
        AppMethodBeat.i(49209);
        AppMethodBeat.o(49209);
    }

    static l d(ArrayList<AppBrandRecentTaskInfo> arrayList, ArrayList<AppBrandRecentTaskInfo> arrayList2) {
        AppMethodBeat.i(49210);
        l lVar = new l();
        b.c(lVar.odI, arrayList);
        b.c(lVar.odJ, arrayList2);
        AppMethodBeat.o(49210);
        return lVar;
    }

    /* access modifiers changed from: package-private */
    public final synchronized ArrayList<AppBrandRecentTaskInfo> bYJ() {
        return this.odI;
    }

    /* access modifiers changed from: package-private */
    public final synchronized ArrayList<AppBrandRecentTaskInfo> bYK() {
        return this.odJ;
    }

    /* access modifiers changed from: package-private */
    public final synchronized l e(ArrayList<AppBrandRecentTaskInfo> arrayList, ArrayList<AppBrandRecentTaskInfo> arrayList2) {
        AppMethodBeat.i(49211);
        this.odI.clear();
        if (!Util.isNullOrNil(arrayList)) {
            this.odI.addAll(arrayList);
        }
        this.odJ.clear();
        if (!Util.isNullOrNil(arrayList2)) {
            this.odJ.addAll(arrayList2);
        }
        AppMethodBeat.o(49211);
        return this;
    }

    /* access modifiers changed from: package-private */
    public final synchronized l a(l lVar) {
        l e2;
        AppMethodBeat.i(49212);
        e2 = e(lVar.odI, lVar.odJ);
        AppMethodBeat.o(49212);
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.ArrayList
    public final boolean addAll(Collection<? extends AppBrandRecentTaskInfo> collection) {
        boolean z = false;
        AppMethodBeat.i(49213);
        if (l.class.isInstance(collection)) {
            synchronized (this) {
                try {
                    l lVar = (l) collection;
                    this.odI.addAll(lVar.odI);
                    this.odJ.addAll(lVar.odJ);
                    z = true;
                } finally {
                    AppMethodBeat.o(49213);
                }
            }
        } else {
            Assert.assertTrue("collection type mismatch!!", false);
            AppMethodBeat.o(49213);
        }
        return z;
    }

    public final synchronized l bYL() {
        l lVar;
        AppMethodBeat.i(49214);
        lVar = new l();
        lVar.odI.addAll(this.odI);
        lVar.odJ.addAll(this.odJ);
        AppMethodBeat.o(49214);
        return lVar;
    }

    public final synchronized int size() {
        int size;
        AppMethodBeat.i(49215);
        size = this.odI.size() + this.odJ.size();
        AppMethodBeat.o(49215);
        return size;
    }

    private synchronized AppBrandRecentTaskInfo zw(int i2) {
        AppBrandRecentTaskInfo appBrandRecentTaskInfo;
        AppMethodBeat.i(49216);
        if (i2 < this.odI.size()) {
            appBrandRecentTaskInfo = this.odI.get(i2);
            AppMethodBeat.o(49216);
        } else {
            appBrandRecentTaskInfo = this.odJ.get(i2 - this.odI.size());
            AppMethodBeat.o(49216);
        }
        return appBrandRecentTaskInfo;
    }

    public final synchronized AppBrandRecentTaskInfo zx(int i2) {
        AppBrandRecentTaskInfo remove;
        AppMethodBeat.i(49217);
        if (i2 < this.odI.size()) {
            remove = this.odI.remove(i2);
            AppMethodBeat.o(49217);
        } else {
            remove = this.odJ.remove(i2 - this.odI.size());
            AppMethodBeat.o(49217);
        }
        return remove;
    }

    public final synchronized void clear() {
        AppMethodBeat.i(49218);
        this.odI.clear();
        this.odJ.clear();
        AppMethodBeat.o(49218);
    }

    public final synchronized boolean isEmpty() {
        boolean z;
        AppMethodBeat.i(49219);
        if (size() == 0) {
            z = true;
            AppMethodBeat.o(49219);
        } else {
            z = false;
            AppMethodBeat.o(49219);
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.List] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // java.util.List, java.util.AbstractList, java.util.ArrayList
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.List<com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo> subList(int r4, int r5) {
        /*
        // Method dump skipped, instructions count: 152
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.ui.recents.l.subList(int, int):java.util.List");
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Iterable, java.util.ArrayList
    public final Iterator<AppBrandRecentTaskInfo> iterator() {
        AppMethodBeat.i(49221);
        Assert.assertTrue("Why you need this?? call @smoothieli fix it", false);
        AnonymousClass1 r0 = new Iterator<AppBrandRecentTaskInfo>() {
            /* class com.tencent.mm.plugin.appbrand.ui.recents.l.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.Iterator
            public final /* bridge */ /* synthetic */ AppBrandRecentTaskInfo next() {
                return null;
            }

            public final boolean hasNext() {
                return false;
            }

            public final void remove() {
            }
        };
        AppMethodBeat.o(49221);
        return r0;
    }
}
