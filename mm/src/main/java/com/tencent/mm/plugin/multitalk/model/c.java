package com.tencent.mm.plugin.multitalk.model;

import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0004@\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/model/BaseDataSource;", "", "()V", "mVideoDisplayDataHandler", "Lcom/tencent/mm/plugin/multitalk/model/VideoDisplayDataHandler;", "registerDataHandler", "", "handler", "plugin-multitalk_release"})
public abstract class c {
    protected ad zLj;

    public final void a(ad adVar) {
        p.h(adVar, "handler");
        adVar.eor();
        this.zLj = adVar;
    }
}
