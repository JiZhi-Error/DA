package com.tencent.mm.plugin.fts.a.d;

public abstract class a implements d {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(d dVar) {
        d dVar2 = dVar;
        if (getPriority() < dVar2.getPriority()) {
            return -1;
        }
        if (getPriority() > dVar2.getPriority()) {
            return 1;
        }
        return 0;
    }
}
