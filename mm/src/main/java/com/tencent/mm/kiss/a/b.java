package com.tencent.mm.kiss.a;

import android.app.Activity;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    private static b htK;
    public static a htO;
    private ConcurrentHashMap<String, c> htJ = new ConcurrentHashMap<>();
    public String htL;
    public MMHandler htM;
    public boolean htN = false;
    public LayoutInflater mInflater;
    public boolean mInitialized = false;
    public int mMode = 2;

    public b() {
        AppMethodBeat.i(141001);
        AppMethodBeat.o(141001);
    }

    static {
        AppMethodBeat.i(141007);
        htK = null;
        htK = new b();
        AppMethodBeat.o(141007);
    }

    public static b aBh() {
        return htK;
    }

    public static View c(Activity activity, int i2) {
        AppMethodBeat.i(141002);
        View inflate = LayoutInflater.from(activity).inflate(i2, (ViewGroup) null);
        AppMethodBeat.o(141002);
        return inflate;
    }

    public static void aBi() {
        AppMethodBeat.i(141005);
        if (htO != null) {
            a aVar = htO;
            try {
                if (!aVar.init()) {
                    AppMethodBeat.o(141005);
                    return;
                } else {
                    aVar.mHandler.removeCallbacksAndMessages(null);
                    aVar.mHandler.sendEmptyMessageDelayed(0, 1000);
                }
            } catch (Throwable th) {
                AppMethodBeat.o(141005);
                return;
            }
        }
        AppMethodBeat.o(141005);
    }

    public static final class a {
        Class htQ;
        Field htR;
        Class htS;
        Field htT = null;
        private boolean htU = false;
        private boolean htV = false;
        MMHandler mHandler;

        public a(String str) {
            AppMethodBeat.i(182560);
            this.mHandler = new MMHandler(str) {
                /* class com.tencent.mm.kiss.a.b.a.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.platformtools.MMHandler
                public final void handleMessage(Message message) {
                    Object obj;
                    AppMethodBeat.i(140998);
                    try {
                        long nanoTime = System.nanoTime();
                        a aVar = a.this;
                        try {
                            ThreadLocal threadLocal = (ThreadLocal) aVar.htR.get(null);
                            if (!(threadLocal == null || (obj = threadLocal.get()) == null)) {
                                try {
                                    Object obj2 = aVar.htT.get(obj);
                                    if (obj2 != null && (obj2 instanceof List)) {
                                        ((List) obj2).clear();
                                    }
                                } catch (IllegalAccessException e2) {
                                    Log.printErrStackTrace("KISS.InflateRecycler", e2, "", new Object[0]);
                                }
                            }
                        } catch (IllegalAccessException e3) {
                            Log.printErrStackTrace("KISS.InflateRecycler", e3, "", new Object[0]);
                        }
                        Log.i("KISS.InflateRecycler", "durtion %s", Long.valueOf(System.nanoTime() - nanoTime));
                        AppMethodBeat.o(140998);
                    } catch (Throwable th) {
                        AppMethodBeat.o(140998);
                    }
                }
            };
            AppMethodBeat.o(182560);
        }

        /* access modifiers changed from: package-private */
        public final boolean init() {
            AppMethodBeat.i(141000);
            if (this.htU) {
                boolean z = this.htV;
                AppMethodBeat.o(141000);
                return z;
            }
            this.htU = true;
            try {
                this.htQ = Class.forName("android.view.ViewRootImpl");
                try {
                    this.htR = this.htQ.getDeclaredField("sRunQueues");
                    this.htR.setAccessible(true);
                    try {
                        this.htS = Class.forName("android.view.ViewRootImpl$RunQueue");
                        try {
                            this.htT = this.htS.getDeclaredField("mActions");
                            this.htT.setAccessible(true);
                            this.htV = true;
                            AppMethodBeat.o(141000);
                            return true;
                        } catch (NoSuchFieldException e2) {
                            Log.printErrStackTrace("KISS.InflateRecycler", e2, "", new Object[0]);
                            AppMethodBeat.o(141000);
                            return false;
                        }
                    } catch (ClassNotFoundException e3) {
                        Log.printErrStackTrace("KISS.InflateRecycler", e3, "", new Object[0]);
                        AppMethodBeat.o(141000);
                        return false;
                    }
                } catch (NoSuchFieldException e4) {
                    Log.printErrStackTrace("KISS.InflateRecycler", e4, "", new Object[0]);
                    AppMethodBeat.o(141000);
                    return false;
                }
            } catch (ClassNotFoundException e5) {
                Log.printErrStackTrace("KISS.InflateRecycler", e5, "", new Object[0]);
                AppMethodBeat.o(141000);
                return false;
            }
        }
    }

    static /* synthetic */ void a(b bVar, c cVar) {
        AppMethodBeat.i(141006);
        if (bVar.mInitialized && !bVar.htN && cVar.dpI > cVar.htX.size()) {
            bVar.htM.sendMessage(bVar.htM.obtainMessage(0, cVar));
        }
        AppMethodBeat.o(141006);
    }
}
