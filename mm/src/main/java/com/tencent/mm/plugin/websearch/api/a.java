package com.tencent.mm.plugin.websearch.api;

import android.os.Bundle;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.eou;
import java.util.LinkedList;

public abstract class a extends q {
    protected int IDq;
    protected Bundle IDr;
    protected String dVP;
    protected int fs;
    protected int mScene;
    protected String xsj;

    public abstract String fXC();

    public abstract int fXD();

    public final int fXz() {
        return this.IDq;
    }

    public final void afo(int i2) {
        this.IDq = i2;
    }

    public final boolean fXA() {
        return this.fs == 0;
    }

    public final Bundle fXB() {
        return this.IDr;
    }

    public final String getKeyword() {
        return this.xsj;
    }

    public void by(LinkedList<eou> linkedList) {
    }

    public final String fXE() {
        return this.dVP;
    }

    public final void aWX(String str) {
        this.dVP = str;
    }
}
