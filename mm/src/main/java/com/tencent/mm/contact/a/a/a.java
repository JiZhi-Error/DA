package com.tencent.mm.contact.a.a;

import com.tencent.mm.model.aq;
import com.tencent.mm.model.t;
import com.tencent.mm.ui.base.q;
import java.util.ArrayList;
import java.util.List;

public abstract class a implements aq {
    protected List<t> gNc = new ArrayList();
    protected List<t> gNd = new ArrayList();
    protected List<t> gNe = new ArrayList();
    protected boolean gNf = true;
    protected q tipDialog;

    public static b arN() {
        return new b(false);
    }

    @Override // com.tencent.mm.model.aq
    public final aq a(t tVar) {
        this.gNc.add(tVar);
        return this;
    }

    @Override // com.tencent.mm.model.aq
    public final aq b(t tVar) {
        this.gNe.add(tVar);
        return this;
    }
}
