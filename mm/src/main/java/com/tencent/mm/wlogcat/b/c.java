package com.tencent.mm.wlogcat.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class c {
    private static c RwP = new c();
    public Runnable RwD = new Runnable() {
        /* class com.tencent.mm.wlogcat.b.c.AnonymousClass1 */

        /* JADX WARNING: Removed duplicated region for block: B:26:0x00c0 A[SYNTHETIC, Splitter:B:26:0x00c0] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00c5 A[Catch:{ Exception -> 0x011b }] */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00ca A[Catch:{ Exception -> 0x011b }] */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0127 A[SYNTHETIC, Splitter:B:52:0x0127] */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x012c A[Catch:{ Exception -> 0x0138 }] */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x0131 A[Catch:{ Exception -> 0x0138 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 338
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.wlogcat.b.c.AnonymousClass1.run():void");
        }
    };
    private String RwQ;

    static {
        AppMethodBeat.i(224066);
        AppMethodBeat.o(224066);
    }

    private c() {
        AppMethodBeat.i(224064);
        AppMethodBeat.o(224064);
    }

    public static c hil() {
        return RwP;
    }

    static /* synthetic */ String him() {
        AppMethodBeat.i(224065);
        String processName = MMApplicationContext.getProcessName();
        if (MMApplicationContext.isMainProcess()) {
            String str = "STARTUP_LOGCAT_" + "MM";
            AppMethodBeat.o(224065);
            return str;
        } else if (processName.endsWith(":push")) {
            String str2 = "STARTUP_LOGCAT_" + "PUSH";
            AppMethodBeat.o(224065);
            return str2;
        } else if (processName.endsWith(":tools")) {
            String str3 = "STARTUP_LOGCAT_" + "TOOLS";
            AppMethodBeat.o(224065);
            return str3;
        } else if (processName.endsWith(":toolsmp")) {
            String str4 = "STARTUP_LOGCAT_" + "TOOLSMP";
            AppMethodBeat.o(224065);
            return str4;
        } else if (processName.endsWith(":appbrand0")) {
            String str5 = "STARTUP_LOGCAT_" + "APPBRAND0";
            AppMethodBeat.o(224065);
            return str5;
        } else if (processName.endsWith(":appbrand1")) {
            String str6 = "STARTUP_LOGCAT_" + "APPBRAND1";
            AppMethodBeat.o(224065);
            return str6;
        } else if (processName.endsWith(":appbrand2")) {
            String str7 = "STARTUP_LOGCAT_" + "APPBRAND2";
            AppMethodBeat.o(224065);
            return str7;
        } else if (processName.endsWith(":appbrand3")) {
            String str8 = "STARTUP_LOGCAT_" + "APPBRAND3";
            AppMethodBeat.o(224065);
            return str8;
        } else if (processName.endsWith(":appbrand4")) {
            String str9 = "STARTUP_LOGCAT_" + "APPBRAND4";
            AppMethodBeat.o(224065);
            return str9;
        } else {
            AppMethodBeat.o(224065);
            return "";
        }
    }
}
