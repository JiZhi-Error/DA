package com.tencent.luggage.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class o implements a {
    protected n ctG;
    private Context mContext;

    public o(Context context, Class<? extends g> cls) {
        AppMethodBeat.i(221188);
        init();
        this.mContext = context;
        this.ctG = new f(context, cls);
        AppMethodBeat.o(221188);
    }

    /* access modifiers changed from: protected */
    public void init() {
    }

    @Override // com.tencent.luggage.d.a
    public final n Lc() {
        return this.ctG;
    }

    @Override // com.tencent.luggage.d.a
    public final Context getContext() {
        return this.mContext;
    }
}
