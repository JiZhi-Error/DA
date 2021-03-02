package com.tencent.tbs.one.impl.c.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.optional.TBSOneStandaloneService;
import dalvik.system.DexClassLoader;

public class b extends TBSOneStandaloneService.ServiceImpl {
    private byte _hellAccFlag_;

    @Override // com.tencent.tbs.one.optional.TBSOneStandaloneService.ServiceImpl
    public void onDestroy() {
        AppMethodBeat.i(173812);
        super.onDestroy();
        a a2 = c.a(0, new a());
        Object obj = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/tbs/one/impl/c/a/b", "onDestroy", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
        System.exit(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/tbs/one/impl/c/a/b", "onDestroy", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
        AppMethodBeat.o(173812);
    }

    @Override // com.tencent.tbs.one.optional.TBSOneStandaloneService.ServiceImpl
    public int onStartCommand(Intent intent, int i2, int i3) {
        AppMethodBeat.i(173811);
        if (intent != null) {
            String stringExtra = intent.getStringExtra("dexPath");
            String stringExtra2 = intent.getStringExtra("dexName");
            String stringExtra3 = intent.getStringExtra("optimizedDirectory");
            String stringExtra4 = intent.getStringExtra("librarySearchPath");
            long currentTimeMillis = System.currentTimeMillis();
            f.a("Optimizing dex %s in standalone service", stringExtra);
            try {
                new DexClassLoader(stringExtra, stringExtra3, stringExtra4, this.f2791a.getClassLoader());
                com.tencent.tbs.one.impl.a.c.b(c.b(stringExtra3, stringExtra2));
            } catch (Exception e2) {
                f.c("Failed to optimize dex %s", stringExtra, e2);
            }
            f.a("Optimized dex %s in standalone service, cost %dms", stringExtra, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        AppMethodBeat.o(173811);
        return 1;
    }
}
