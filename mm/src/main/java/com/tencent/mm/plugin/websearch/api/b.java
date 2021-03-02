package com.tencent.mm.plugin.websearch.api;

import com.tencent.mm.ak.q;

public abstract class b extends q {
    protected int IDq;
    protected String Nv;
    protected int mScene;

    public abstract String fXC();

    public final int fXz() {
        return this.IDq;
    }

    public final String getQuery() {
        return this.Nv;
    }
}
