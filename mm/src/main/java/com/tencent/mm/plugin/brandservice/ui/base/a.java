package com.tencent.mm.plugin.brandservice.ui.base;

import com.tencent.mm.plugin.brandservice.ui.c;
import java.util.List;

public abstract class a extends com.tencent.mm.ui.base.sortview.a {
    protected c.b pok;
    protected int position;
    protected List<String> pqn;
    protected int pqo;

    public a(int i2, Object obj) {
        super(i2, obj);
    }

    public final void setReporter(c.b bVar) {
        this.pok = bVar;
    }

    public final c.b cmj() {
        return this.pok;
    }

    public final void Dd(int i2) {
        this.pqo = i2;
    }

    public final int cmk() {
        return this.pqo;
    }

    public final void setPosition(int i2) {
        this.position = i2;
    }

    public final int getPosition() {
        return this.position;
    }
}
