package com.tencent.mm.vending.base;

import com.tencent.mm.vending.base.Vending;

public abstract class a<_Struct> extends Vending<_Struct, Class<?>, Void> {

    /* renamed from: com.tencent.mm.vending.base.a$a  reason: collision with other inner class name */
    public interface AbstractC2150a extends Vending.e {
    }

    /* access modifiers changed from: protected */
    /* renamed from: bl */
    public abstract _Struct resolveAsynchronous(Class<?> cls);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.vending.base.Vending
    public /* bridge */ /* synthetic */ void applyChangeSynchronized(Void r1) {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.vending.base.Vending
    public /* bridge */ /* synthetic */ Void prepareVendingDataAsynchronous() {
        return null;
    }

    @Override // com.tencent.mm.vending.base.Vending
    public void notifyVendingDataChange() {
    }

    @Override // com.tencent.mm.vending.base.Vending
    public void notifyVendingDataChangeSynchronize() {
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.vending.base.Vending
    public void destroyAsynchronous() {
    }
}
