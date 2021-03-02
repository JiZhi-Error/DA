package com.tencent.mm.app;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class x {
    private static final List<a> dlZ = new ArrayList();
    private static final boolean[] dma = {false};

    static {
        AppMethodBeat.i(200817);
        AppMethodBeat.o(200817);
    }

    static abstract class a {
        final SimpleDateFormat dmb;
        final String dmc;

        /* access modifiers changed from: package-private */
        public abstract void execute();

        private a() {
            this.dmb = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);
            this.dmc = this.dmb.format(new Date());
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    static class e extends a {
        final int level;
        final String msg;
        final String tag;

        e(int i2, String str, String str2) {
            super((byte) 0);
            this.level = i2;
            this.tag = str;
            this.msg = str2;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.x.a
        public final void execute() {
            AppMethodBeat.i(200809);
            switch (this.level) {
                case 2:
                    Log.v("MicroMsg.PendingLogAndReport", "[%s @ %s] %s", this.tag, this.dmc, this.msg);
                    AppMethodBeat.o(200809);
                    return;
                case 3:
                    Log.d("MicroMsg.PendingLogAndReport", "[%s @ %s] %s", this.tag, this.dmc, this.msg);
                    AppMethodBeat.o(200809);
                    return;
                case 4:
                    Log.i("MicroMsg.PendingLogAndReport", "[%s @ %s] %s", this.tag, this.dmc, this.msg);
                    AppMethodBeat.o(200809);
                    return;
                case 5:
                    Log.w("MicroMsg.PendingLogAndReport", "[%s @ %s] %s", this.tag, this.dmc, this.msg);
                    AppMethodBeat.o(200809);
                    return;
                case 6:
                    Log.e("MicroMsg.PendingLogAndReport", "[%s @ %s] %s", this.tag, this.dmc, this.msg);
                    break;
            }
            AppMethodBeat.o(200809);
        }
    }

    static class d extends a {
        final Object[] apH;
        final int id;

        d(int i2, Object... objArr) {
            super((byte) 0);
            this.id = i2;
            this.apH = objArr;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.x.a
        public final void execute() {
            AppMethodBeat.i(200808);
            com.tencent.mm.plugin.report.e.INSTANCE.a(this.id, true, true, false, this.apH);
            AppMethodBeat.o(200808);
        }
    }

    static class c extends a {
        final int id = 1557;
        final int key = 40;
        final int value = 1;

        c() {
            super((byte) 0);
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.x.a
        public final void execute() {
            AppMethodBeat.i(200807);
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat((long) this.id, (long) this.key, (long) this.value, true);
            AppMethodBeat.o(200807);
        }
    }

    static class b extends a {
        final ArrayList<IDKey> dmd;

        b(ArrayList<IDKey> arrayList) {
            super((byte) 0);
            this.dmd = arrayList;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.x.a
        public final void execute() {
            AppMethodBeat.i(200806);
            com.tencent.mm.plugin.report.e.INSTANCE.b(this.dmd, true);
            AppMethodBeat.o(200806);
        }
    }

    public static void a(String str, String str2, Object... objArr) {
        AppMethodBeat.i(200810);
        synchronized (dma) {
            try {
                if (dma[0]) {
                    Log.i(str, str2, objArr);
                } else {
                    synchronized (dlZ) {
                        try {
                            if (objArr.length > 0) {
                                str2 = String.format(str2, objArr);
                            }
                            dlZ.add(new e(4, str, str2));
                        } catch (Throwable th) {
                            AppMethodBeat.o(200810);
                            throw th;
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(200810);
            }
        }
    }

    public static void b(String str, String str2, Object... objArr) {
        AppMethodBeat.i(200811);
        synchronized (dma) {
            try {
                if (dma[0]) {
                    Log.w(str, str2, objArr);
                } else {
                    synchronized (dlZ) {
                        try {
                            if (objArr.length > 0) {
                                str2 = String.format(str2, objArr);
                            }
                            dlZ.add(new e(5, str, str2));
                        } catch (Throwable th) {
                            AppMethodBeat.o(200811);
                            throw th;
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(200811);
            }
        }
    }

    public static void a(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.i(200812);
        synchronized (dma) {
            try {
                if (dma[0]) {
                    Log.printErrStackTrace(str, th, str2, objArr);
                } else {
                    StringBuilder sb = new StringBuilder();
                    if (objArr.length > 0) {
                        sb.append(String.format(str2, objArr));
                    } else {
                        sb.append(str2);
                    }
                    sb.append("  ").append(android.util.Log.getStackTraceString(th));
                    synchronized (dlZ) {
                        try {
                            dlZ.add(new e(6, str, sb.toString()));
                        } catch (Throwable th2) {
                            AppMethodBeat.o(200812);
                            throw th2;
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(200812);
            }
        }
    }

    public static void a(int i2, Object... objArr) {
        AppMethodBeat.i(200813);
        synchronized (dma) {
            try {
                if (dma[0]) {
                    com.tencent.mm.plugin.report.e.INSTANCE.a(i2, objArr);
                } else {
                    synchronized (dlZ) {
                        try {
                            dlZ.add(new d(i2, objArr));
                        } catch (Throwable th) {
                            AppMethodBeat.o(200813);
                            throw th;
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(200813);
            }
        }
    }

    public static void WF() {
        AppMethodBeat.i(200814);
        synchronized (dma) {
            try {
                if (dma[0]) {
                    com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1557, 40, 1, true);
                } else {
                    synchronized (dlZ) {
                        try {
                            dlZ.add(new c());
                        } catch (Throwable th) {
                            AppMethodBeat.o(200814);
                            throw th;
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(200814);
            }
        }
    }

    public static void f(ArrayList<IDKey> arrayList) {
        AppMethodBeat.i(200815);
        synchronized (dma) {
            try {
                if (dma[0]) {
                    com.tencent.mm.plugin.report.e.INSTANCE.b(arrayList, true);
                } else {
                    synchronized (dlZ) {
                        try {
                            dlZ.add(new b(arrayList));
                        } catch (Throwable th) {
                            AppMethodBeat.o(200815);
                            throw th;
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(200815);
            }
        }
    }

    public static void execute() {
        AppMethodBeat.i(200816);
        synchronized (dma) {
            try {
                synchronized (dlZ) {
                    try {
                        for (a aVar : dlZ) {
                            aVar.execute();
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(200816);
                        throw th;
                    }
                }
                dma[0] = true;
            } finally {
                AppMethodBeat.o(200816);
            }
        }
    }
}
