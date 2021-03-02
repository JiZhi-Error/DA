package com.tencent.toybrick.c;

import android.os.Handler;
import android.view.View;
import com.tencent.toybrick.c.f;
import com.tencent.toybrick.f.a;
import com.tencent.toybrick.g.b;
import com.tencent.toybrick.ui.BaseToyUI;

public abstract class f<S extends f, T extends a> {
    BaseToyUI SnR;
    public Runnable SnS;
    public String SnT;
    public b.a<S> SnU;
    public boolean isVisible;
    public Handler mMainHandler;

    public abstract void a(T t);

    public abstract int getLayoutResource();

    public abstract T hM(View view);
}
