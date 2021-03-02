package com.tencent.mm.plugin.fts.a.a;

import java.util.ArrayList;
import java.util.List;

public abstract class a implements Comparable<a> {
    public boolean mCancelled = false;
    public int mPriority = Integer.MAX_VALUE;
    public long wVP = 0;
    public long wVQ = 0;
    public List<C1373a> wVR;
    public Object wVS;

    public abstract boolean execute();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(a aVar) {
        return this.mPriority - aVar.mPriority;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public boolean isCancelled() {
        return this.mCancelled;
    }

    public int getId() {
        return -1;
    }

    /* access modifiers changed from: protected */
    public final void ayx(String str) {
        if (this.wVR == null) {
            this.wVR = new ArrayList();
        }
        C1373a aVar = new C1373a();
        aVar.wVT = str;
        aVar.timestamp = System.currentTimeMillis();
        this.wVR.add(aVar);
    }

    /* renamed from: com.tencent.mm.plugin.fts.a.a.a$a  reason: collision with other inner class name */
    public class C1373a {
        public long timestamp;
        public String wVT;

        public C1373a() {
        }
    }

    public String getName() {
        return "";
    }

    public String bCQ() {
        return "";
    }
}
