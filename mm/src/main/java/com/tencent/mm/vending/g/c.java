package com.tencent.mm.vending.g;

import com.tencent.mm.vending.e.b;
import com.tencent.mm.vending.h.d;

public interface c<_Var> extends com.tencent.mm.vending.e.a, d<_Var> {

    public interface a<_Ret> {
        _Ret call();
    }

    c<_Var> Du(boolean z);

    c<_Var> Oc(long j2);

    c<_Var> b(b bVar);

    c<_Var> b(d dVar);

    <_Ret> c<_Ret> c(com.tencent.mm.vending.c.a<_Ret, _Var> aVar);

    <_Ret> c<_Ret> d(com.tencent.mm.vending.c.a<_Ret, _Var> aVar);

    <_Ret> c<_Ret> e(com.tencent.mm.vending.c.a<_Ret, _Var> aVar);

    <_Ret> c<_Ret> f(com.tencent.mm.vending.c.a<_Ret, _Var> aVar);

    b hdx();

    d<_Var> hdy();

    void stop();
}
