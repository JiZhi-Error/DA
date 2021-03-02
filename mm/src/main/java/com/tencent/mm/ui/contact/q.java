package com.tencent.mm.ui.contact;

import java.util.List;

public abstract class q extends p {
    protected boolean PWC;
    protected List<String> gzY;

    /* access modifiers changed from: protected */
    public final List<String> cfd() {
        return this.gzY;
    }

    /* access modifiers changed from: protected */
    public final boolean hYL() {
        return this.PWC;
    }

    public q(n nVar, List<String> list, boolean z, boolean z2, boolean z3) {
        this(nVar, list, z, z2, 0, z3);
    }

    public q(n nVar, List<String> list, boolean z, boolean z2) {
        this(nVar, list, z, z2, 0);
    }

    public q(n nVar, List<String> list, boolean z, boolean z2, int i2) {
        this(nVar, list, z, z2, i2, false);
    }

    private q(n nVar, List<String> list, boolean z, boolean z2, int i2, boolean z3) {
        super(nVar, z2, i2, z3);
        this.gzY = list;
        this.PWC = z;
    }

    public int bnr(String str) {
        return -1;
    }

    public void and() {
    }
}
