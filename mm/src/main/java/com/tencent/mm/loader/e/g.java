package com.tencent.mm.loader.e;

import com.tencent.mm.loader.f.e;
import com.tencent.mm.loader.h.a.a;

public final class g<T, R> implements e<T, R> {
    private e<T, R> iam = null;

    @Override // com.tencent.mm.loader.f.e
    public final void a(a<T> aVar, com.tencent.mm.loader.e.b.g<?> gVar, R r) {
        if (this.iam != null) {
            this.iam.a(aVar, gVar, r);
        }
    }
}
