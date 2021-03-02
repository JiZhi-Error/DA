package com.tencent.mm.plugin.flutter.model;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import io.flutter.embedding.engine.plugins.a;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import java.util.Map;

public final class a implements io.flutter.embedding.engine.plugins.a, k.c {
    private k wJr;

    @Override // io.flutter.plugin.a.k.c
    public final void a(j jVar, k.d dVar) {
        AppMethodBeat.i(148871);
        Log.d("MicroMsg.Flutter.FlutterCrashReportPlugin", "onMethodCall method", jVar.method);
        String str = jVar.method;
        char c2 = 65535;
        switch (str.hashCode()) {
            case 257086668:
                if (str.equals("crash_report")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                Map map = (Map) jVar.btq("crashInfo");
                String str2 = (String) jVar.btq("sessionId");
                boolean booleanValue = ((Boolean) jVar.btq("killSelf")).booleanValue();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("\n#deviceParameters=" + map.get("deviceParameters"));
                stringBuffer.append("\n#customParameters=" + map.get("customParameters"));
                stringBuffer.append("\n#applicationParameters=" + map.get("applicationParameters"));
                stringBuffer.append("\n#dateTime=" + map.get("dateTime"));
                com.tencent.mm.plugin.flutter.c.a aVar = com.tencent.mm.plugin.flutter.c.a.wJq;
                com.tencent.mm.plugin.flutter.c.a.b(map, booleanValue);
                long currentTimeMillis = System.currentTimeMillis();
                Log.i("MicroMsg.Flutter.FlutterReportLogic", "reportFlutterActionAction %s %s", "FlutterCrash", str2);
                e.INSTANCE.a(17326, Long.valueOf(currentTimeMillis), "FlutterCrash", str2);
                e.INSTANCE.idkeyStat(1053, 2, 1, false);
                CrashReportFactory.reportCrashMessage(stringBuffer.toString(), "Flutter\n\tErrorMsg=" + map.get("error") + "\n" + map.get("stackTrace") + "\nkillSelf" + booleanValue);
                Log.appenderFlushSync();
                if (booleanValue) {
                    Log.appenderClose();
                    com.tencent.mm.hellhoundlib.b.a a2 = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
                    Object obj = new Object();
                    com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/plugin/flutter/model/FlutterCrashReportPlugin", "onMethodCall", "(Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                    Process.killProcess(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/flutter/model/FlutterCrashReportPlugin", "onMethodCall", "(Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                    com.tencent.mm.hellhoundlib.b.a a3 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                    Object obj2 = new Object();
                    com.tencent.mm.hellhoundlib.a.a.a(obj2, a3.axQ(), "com/tencent/mm/plugin/flutter/model/FlutterCrashReportPlugin", "onMethodCall", "(Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "java/lang/System_EXEC_", "exit", "(I)V");
                    System.exit(((Integer) a3.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(obj2, "com/tencent/mm/plugin/flutter/model/FlutterCrashReportPlugin", "onMethodCall", "(Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "java/lang/System_EXEC_", "exit", "(I)V");
                    break;
                }
                break;
        }
        AppMethodBeat.o(148871);
    }

    @Override // io.flutter.embedding.engine.plugins.a
    public final void a(a.b bVar) {
        AppMethodBeat.i(240942);
        Log.i("MicroMsg.Flutter.FlutterCrashReportPlugin", "onAttachedToEngine FlutterCrashReportPlugin CHANNEL%s", "com.tencent.mm.flutter.crashreport");
        this.wJr = new k(bVar.SOH, "com.tencent.mm.flutter.crashreport");
        this.wJr.a(this);
        AppMethodBeat.o(240942);
    }

    @Override // io.flutter.embedding.engine.plugins.a
    public final void b(a.b bVar) {
        AppMethodBeat.i(240943);
        this.wJr.a(null);
        AppMethodBeat.o(240943);
    }
}
