package com.tencent.smtt.export.external;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.hellhoundlib.b.c;
import java.io.File;
import java.util.ArrayList;

public class DexClassLoaderProviderService extends Service {
    private static final String LOGTAG = "dexloader";
    private byte _hellAccFlag_;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        AppMethodBeat.i(53132);
        super.onCreate();
        DexClassLoaderProvider.setForceLoadDexFlag(true, this);
        AppMethodBeat.o(53132);
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        AppMethodBeat.i(53133);
        new StringBuilder("DexClassLoaderProviderService -- onStartCommand(").append(intent).append(")");
        if (intent == null) {
            AppMethodBeat.o(53133);
        } else {
            try {
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("dex2oat");
                if (stringArrayListExtra == null) {
                    AppMethodBeat.o(53133);
                } else {
                    String str = stringArrayListExtra.get(1);
                    String str2 = stringArrayListExtra.get(2);
                    String str3 = stringArrayListExtra.get(3);
                    new StringBuilder("DexClassLoaderProviderService -- onStartCommand(").append(stringArrayListExtra.get(0)).append(")");
                    ClassLoader classLoader = getClassLoader();
                    File file = new File(str2);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    DexClassLoaderProvider.createDexClassLoader(str, str2, str3, classLoader, getApplicationContext());
                    AppMethodBeat.o(53133);
                }
            } catch (Exception e2) {
            }
        }
        return 1;
    }

    public void onDestroy() {
        AppMethodBeat.i(53134);
        a a2 = c.a(0, new a());
        Object obj = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/smtt/export/external/DexClassLoaderProviderService", "onDestroy", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
        System.exit(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/smtt/export/external/DexClassLoaderProviderService", "onDestroy", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
        AppMethodBeat.o(53134);
    }
}
