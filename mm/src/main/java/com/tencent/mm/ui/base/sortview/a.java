package com.tencent.mm.ui.base.sortview;

import android.content.Context;
import android.view.View;

public abstract class a {
    protected boolean OZN;
    protected Object data;
    public int type;

    /* renamed from: com.tencent.mm.ui.base.sortview.a$a  reason: collision with other inner class name */
    public interface AbstractC2082a {
    }

    public static abstract class b {
        public abstract void a(Context context, AbstractC2082a aVar, a aVar2);

        public abstract void a(View view, AbstractC2082a aVar);

        public abstract boolean a(Context context, a aVar, Object... objArr);

        public abstract View c(Context context, View view);
    }

    public abstract void a(Context context, AbstractC2082a aVar, Object... objArr);

    public abstract b clS();

    public abstract AbstractC2082a clT();

    public a(int i2, Object obj) {
        this.type = i2;
        this.data = obj;
    }

    public final Object getData() {
        return this.data;
    }

    public final boolean gLT() {
        return this.OZN;
    }
}
