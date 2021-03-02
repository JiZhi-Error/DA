package com.tencent.mm.plugin.expansions;

import android.content.res.AssetManager;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.cr.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.toolkit.frontia.a;
import com.tencent.mm.toolkit.frontia.a.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class a {
    private static volatile boolean dmI = true;
    private static final byte[] rNj = {7, 2, -1, -1, -4, 8, -10, -3, 4, 2, -8, -4, 9, 5, -6, -17, 3, 4, 3, 1};
    private static final byte[] rNk = new byte[0];
    private static final byte[] rNl = new byte[0];
    private static final Object rNm = j.class;
    private static volatile boolean rNn = true;
    private static volatile c.a rNo = new c.a() {
        /* class com.tencent.mm.plugin.expansions.a.AnonymousClass1 */

        @Override // com.tencent.mm.toolkit.frontia.a.c.a
        public final File cMt() {
            AppMethodBeat.i(201274);
            File file = new File(MMApplicationContext.getContext().getApplicationInfo().nativeLibraryDir);
            AppMethodBeat.o(201274);
            return file;
        }

        @Override // com.tencent.mm.toolkit.frontia.a.c.a
        public final AssetManager getAssets() {
            AppMethodBeat.i(152955);
            AssetManager assets = MMApplicationContext.getContext().getAssets();
            AppMethodBeat.o(152955);
            return assets;
        }
    };
    private static volatile a.C2068a rNp;
    private static final List<String> rNq = new ArrayList();

    /* renamed from: com.tencent.mm.plugin.expansions.a$a  reason: collision with other inner class name */
    public interface AbstractC1006a {
        void a(AssetManager assetManager);
    }

    public interface b {
        void a(c.a aVar);
    }

    static {
        AppMethodBeat.i(152964);
        d cMu = d.cMu();
        rNp = new a.C2068a(cMu, new c(cMu));
        AppMethodBeat.o(152964);
    }

    static boolean cMk() {
        boolean z;
        synchronized (rNl) {
            z = rNp != null;
        }
        return z;
    }

    static boolean cMl() {
        return true;
    }

    static void cMm() {
    }

    static void cMn() {
    }

    static void prepare() {
        AppMethodBeat.i(201277);
        com.tencent.mm.cr.d.a(new d.a() {
            /* class com.tencent.mm.plugin.expansions.a.AnonymousClass2 */

            @Override // com.tencent.mm.cr.d.a
            public final boolean isInstalled() {
                AppMethodBeat.i(201275);
                boolean isInstalled = a.isInstalled();
                AppMethodBeat.o(201275);
                return isInstalled;
            }

            @Override // com.tencent.mm.cr.d.a
            public final String cMs() {
                AppMethodBeat.i(201276);
                String cMs = a.cMs();
                AppMethodBeat.o(201276);
                return cMs;
            }
        });
        AppMethodBeat.o(201277);
    }

    public static boolean cMo() {
        return true;
    }

    public static boolean cMp() {
        return true;
    }

    public static boolean isEnabled() {
        return false;
    }

    public static boolean cMq() {
        return false;
    }

    public static boolean isInstalled() {
        return true;
    }

    public static boolean cMr() {
        return true;
    }

    public static Future<?> a(b bVar) {
        AppMethodBeat.i(152960);
        bVar.a(rNo);
        Future<com.tencent.mm.toolkit.frontia.core.b> future = rNp.jKp;
        AppMethodBeat.o(152960);
        return future;
    }

    public static Future<?> a(AbstractC1006a aVar) {
        AppMethodBeat.i(152961);
        aVar.a(rNo.getAssets());
        Future<com.tencent.mm.toolkit.frontia.core.b> future = rNp.jKp;
        AppMethodBeat.o(152961);
        return future;
    }

    public static boolean aoa(String str) {
        AppMethodBeat.i(152962);
        if (rNq.contains(str)) {
            AppMethodBeat.o(152962);
            return true;
        }
        try {
            a.class.getClassLoader();
            j.Ed(str);
            rNq.add(str);
            AppMethodBeat.o(152962);
            return true;
        } catch (Throwable th) {
            Log.w("MicroMsg.exp.Expansions", "tryLoadLibrary fail, error = " + th.getMessage());
            AppMethodBeat.o(152962);
            return false;
        }
    }

    public static String cMs() {
        AppMethodBeat.i(201278);
        if (rNo == null) {
            AppMethodBeat.o(201278);
            return null;
        }
        String str = rNo.cMt().getAbsolutePath() + File.separator;
        AppMethodBeat.o(201278);
        return str;
    }

    static boolean isMainProcess() {
        AppMethodBeat.i(152963);
        boolean isMainProcess = MMApplicationContext.isMainProcess();
        AppMethodBeat.o(152963);
        return isMainProcess;
    }

    static class d extends com.tencent.mm.toolkit.frontia.a.a<Object> {
        public static final String rNr;
        public boolean rNs = true;

        static {
            AppMethodBeat.i(152959);
            StringBuilder sb = new StringBuilder("expansions-");
            String str = Build.CPU_ABI;
            "Capable cpu abi = ".concat(String.valueOf(str));
            com.tencent.mm.toolkit.frontia.b.gGg();
            rNr = sb.append(str).append(".obb").toString();
            AppMethodBeat.o(152959);
        }

        private d() {
            AppMethodBeat.i(152957);
            gGi();
            AppMethodBeat.o(152957);
        }

        public static d cMu() {
            AppMethodBeat.i(152958);
            d dVar = new d();
            dVar.gGh();
            dVar.blD("use builtin impl");
            AppMethodBeat.o(152958);
            return dVar;
        }
    }

    static class c<T> implements Future<T> {
        private final T result;

        public c(T t) {
            this.result = t;
        }

        public final boolean cancel(boolean z) {
            return false;
        }

        public final boolean isCancelled() {
            return false;
        }

        public final boolean isDone() {
            return true;
        }

        @Override // java.util.concurrent.Future
        public final T get() {
            return this.result;
        }

        @Override // java.util.concurrent.Future
        public final T get(long j2, TimeUnit timeUnit) {
            AppMethodBeat.i(152956);
            T t = get();
            AppMethodBeat.o(152956);
            return t;
        }
    }
}
