package com.tencent.e.e.b.a.a.a;

import android.content.Context;
import com.tencent.e.e.b.a.a.a;
import com.tencent.e.e.b.a.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import java.lang.reflect.Method;

public final class i implements a {
    private static Object RNV;
    private static Class<?> RNW = null;
    private static Method RNX = null;
    private c RNM;
    private String RNU = "";
    private int mErrorCode = -1;
    private long mTime = -1;

    @Override // com.tencent.e.e.b.a.a.a
    public final synchronized c kV(Context context) {
        c aqC;
        AppMethodBeat.i(138447);
        if (this.RNM == null || this.RNM.errorCode != 0) {
            this.mErrorCode = 0;
            try {
                RNW = Class.forName("com.android.id.impl.IdProviderImpl");
                if (RNW == null) {
                    aqC = c.aqC(-301);
                    AppMethodBeat.o(138447);
                } else {
                    try {
                        RNV = RNW.newInstance();
                        try {
                            RNX = RNW.getMethod(bh.NAME, Context.class);
                            if (!(RNV == null || RNX == null)) {
                                try {
                                    Object invoke = RNX.invoke(RNV, context);
                                    if (invoke != null) {
                                        this.RNU = (String) invoke;
                                    } else {
                                        this.mErrorCode = -305;
                                    }
                                } catch (Throwable th) {
                                    this.mErrorCode = -306;
                                }
                            }
                            aqC = new c(this.RNU, this.mErrorCode);
                            AppMethodBeat.o(138447);
                        } catch (Throwable th2) {
                            aqC = c.aqC(-304);
                            AppMethodBeat.o(138447);
                        }
                    } catch (InstantiationException e2) {
                        aqC = c.aqC(-302);
                        AppMethodBeat.o(138447);
                    } catch (IllegalAccessException e3) {
                        aqC = c.aqC(-303);
                        AppMethodBeat.o(138447);
                    }
                }
            } catch (Throwable th3) {
                aqC = c.aqC(-301);
                AppMethodBeat.o(138447);
            }
        } else {
            aqC = this.RNM;
            AppMethodBeat.o(138447);
        }
        return aqC;
    }
}
