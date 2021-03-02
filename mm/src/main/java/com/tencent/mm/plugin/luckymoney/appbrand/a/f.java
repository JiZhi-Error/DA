package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.mm.vending.c.a;

public abstract class f<T> implements a<Void, T> {
    public abstract void dv(T t);

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.vending.c.a
    public /* synthetic */ Void call(Object obj) {
        dv(obj);
        return QZL;
    }
}
