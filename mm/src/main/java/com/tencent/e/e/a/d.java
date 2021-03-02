package com.tencent.e.e.a;

import android.content.Context;
import com.tencent.e.e.a.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    long Gfd;
    int RMA;
    int action;
    Context context;
    long delayTime;
    int requestType;

    public /* synthetic */ d(a aVar, byte b2) {
        this(aVar);
    }

    private d(a aVar) {
        this.requestType = aVar.requestType;
        this.RMA = aVar.RMA;
        this.action = aVar.action;
        this.Gfd = aVar.Gfd;
        this.delayTime = aVar.delayTime;
        this.context = aVar.context;
    }

    public static final class a {
        public long Gfd;
        int RMA;
        int action;
        Context context;
        long delayTime;
        int requestType;

        public /* synthetic */ a(Context context2, int i2, int i3, byte b2) {
            this(context2, i2, i3);
        }

        private a(Context context2, int i2, int i3) {
            AppMethodBeat.i(138375);
            this.requestType = 0;
            this.RMA = 0;
            this.action = 0;
            this.Gfd = f.RMR * 12;
            this.delayTime = 0;
            if (i2 < 0) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("scenes invalid: ".concat(String.valueOf(i2)));
                AppMethodBeat.o(138375);
                throw illegalArgumentException;
            }
            this.context = context2.getApplicationContext();
            this.RMA = i2;
            this.action = i3;
            AppMethodBeat.o(138375);
        }
    }
}
