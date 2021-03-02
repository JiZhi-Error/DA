package com.tencent.matrix.report;

import java.util.HashSet;

public class d {
    private final a cWg;
    private final HashSet<String> cWh = new HashSet<>();

    public interface a {
        void onDetectIssue(c cVar);
    }

    public d(a aVar) {
        this.cWg = aVar;
    }

    /* access modifiers changed from: protected */
    public final void b(c cVar) {
        if (this.cWg == null) {
            throw new RuntimeException("publish issue, but issue listener is null");
        }
        this.cWg.onDetectIssue(cVar);
    }

    /* access modifiers changed from: protected */
    public boolean eC(String str) {
        if (str == null) {
            return false;
        }
        return this.cWh.contains(str);
    }

    /* access modifiers changed from: protected */
    public void eB(String str) {
        if (str != null) {
            this.cWh.add(str);
        }
    }
}
