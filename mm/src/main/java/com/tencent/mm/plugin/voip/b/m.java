package com.tencent.mm.plugin.voip.b;

import android.app.Notification;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.s;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.bj;
import com.tencent.mm.g.a.bl;
import com.tencent.mm.g.a.bu;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.n.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class m {
    public static Context Hhs = null;
    private static final Uri Hht = Uri.parse("content://com.lbe.security.miui.permmgr/active");
    private static final String SYS_INFO;

    static {
        AppMethodBeat.i(115542);
        StringBuilder sb = new StringBuilder();
        sb.append("VERSION.RELEASE:[" + Build.VERSION.RELEASE);
        sb.append("] VERSION.CODENAME:[" + Build.VERSION.CODENAME);
        sb.append("] VERSION.INCREMENTAL:[" + Build.VERSION.INCREMENTAL);
        sb.append("] BOARD:[" + Build.BOARD);
        sb.append("] DEVICE:[" + Build.DEVICE);
        sb.append("] DISPLAY:[" + Build.DISPLAY);
        sb.append("] FINGERPRINT:[" + Build.FINGERPRINT);
        sb.append("] HOST:[" + Build.HOST);
        sb.append("] MANUFACTURER:[" + Build.MANUFACTURER);
        sb.append("] MODEL:[" + Build.MODEL);
        sb.append("] PRODUCT:[" + Build.PRODUCT);
        sb.append("] TAGS:[" + Build.TAGS);
        sb.append("] TYPE:[" + Build.TYPE);
        sb.append("] USER:[" + Build.USER + "]");
        SYS_INFO = sb.toString();
        AppMethodBeat.o(115542);
    }

    public static boolean fKF() {
        return true;
    }

    public static int getApiLevel() {
        return Build.VERSION.SDK_INT;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0056, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0057, code lost:
        com.tencent.mm.vfs.aa.closeQuietly(null);
        com.tencent.matrix.trace.core.AppMethodBeat.o(115530);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005d, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0056 A[ExcHandler: all (r0v1 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x0008] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean fKG() {
        /*
            r1 = 0
            r0 = 0
            r6 = 115530(0x1c34a, float:1.61892E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            java.util.Properties r2 = new java.util.Properties     // Catch:{ IOException -> 0x004c, all -> 0x0056 }
            r2.<init>()     // Catch:{ IOException -> 0x004c, all -> 0x0056 }
            com.tencent.mm.vfs.o r3 = new com.tencent.mm.vfs.o     // Catch:{ IOException -> 0x004c, all -> 0x0056 }
            java.io.File r4 = android.os.Environment.getRootDirectory()     // Catch:{ IOException -> 0x004c, all -> 0x0056 }
            java.lang.String r5 = "build.prop"
            r3.<init>(r4, r5)     // Catch:{ IOException -> 0x004c, all -> 0x0056 }
            java.io.InputStream r1 = com.tencent.mm.vfs.s.ao(r3)     // Catch:{ IOException -> 0x004c, all -> 0x0056 }
            r2.load(r1)     // Catch:{ IOException -> 0x004c, all -> 0x0056 }
            java.lang.String r3 = "ro.miui.ui.version.name"
            r4 = 0
            java.lang.String r2 = r2.getProperty(r3, r4)     // Catch:{ IOException -> 0x004c, all -> 0x0056 }
            if (r2 == 0) goto L_0x0034
            java.lang.String r3 = "V6"
            boolean r2 = r2.equals(r3)     // Catch:{ IOException -> 0x004c, all -> 0x0056 }
            if (r2 == 0) goto L_0x0034
            r0 = 1
        L_0x0034:
            com.tencent.mm.vfs.aa.closeQuietly(r1)
        L_0x0037:
            java.lang.String r1 = "VoipUtil"
            java.lang.String r2 = "isMIUIv6 "
            java.lang.String r3 = java.lang.String.valueOf(r0)
            java.lang.String r2 = r2.concat(r3)
            com.tencent.mm.sdk.platformtools.Log.d(r1, r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            return r0
        L_0x004c:
            r2 = move-exception
            if (r1 == 0) goto L_0x0052
            r1.close()     // Catch:{ IOException -> 0x005e, all -> 0x0056 }
        L_0x0052:
            com.tencent.mm.vfs.aa.closeQuietly(r1)
            goto L_0x0037
        L_0x0056:
            r0 = move-exception
            com.tencent.mm.vfs.aa.closeQuietly(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            throw r0
        L_0x005e:
            r2 = move-exception
            goto L_0x0052
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voip.b.m.fKG():boolean");
    }

    public static boolean hC(Context context) {
        AppMethodBeat.i(115531);
        boolean z = false;
        if (fKG()) {
            z = hF(context);
        }
        Log.d("VoipUtil", "isLbePermissionEnable ret:".concat(String.valueOf(z)));
        AppMethodBeat.o(115531);
        return z;
    }

    public static boolean hD(Context context) {
        AppMethodBeat.i(115532);
        boolean z = false;
        if (fKG()) {
            z = hE(context);
        }
        Log.d("VoipUtil", "setLbePermissionEnable ret:".concat(String.valueOf(z)));
        AppMethodBeat.o(115532);
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d8, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d9, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00dc, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0109, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x010a, code lost:
        r2 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d8 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x000d] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0110  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean hE(android.content.Context r12) {
        /*
        // Method dump skipped, instructions count: 278
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voip.b.m.hE(android.content.Context):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean hF(android.content.Context r11) {
        /*
        // Method dump skipped, instructions count: 171
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voip.b.m.hF(android.content.Context):boolean");
    }

    public static void hG(Context context) {
        AppMethodBeat.i(115535);
        Toast.makeText(context, (int) R.string.i2y, 0).show();
        AppMethodBeat.o(115535);
    }

    public static int Se(String str) {
        int i2 = 0;
        AppMethodBeat.i(115536);
        try {
            i2 = Util.getInt(h.aqJ().getValue(str), 0);
        } catch (Exception e2) {
            Log.e("VoipUtil", "getIntValFromDynamicConfig parseInt failed, val: ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(115536);
        return i2;
    }

    public static boolean fKH() {
        AppMethodBeat.i(115537);
        bl blVar = new bl();
        EventCenter.instance.publish(blVar);
        boolean z = blVar.dEG.isStarted;
        AppMethodBeat.o(115537);
        return z;
    }

    public static boolean isVoipStarted() {
        AppMethodBeat.i(115538);
        zj zjVar = new zj();
        zjVar.efx.dKy = 2;
        EventCenter.instance.publish(zjVar);
        boolean z = zjVar.efy.calling;
        AppMethodBeat.o(115538);
        return z;
    }

    public static boolean fKI() {
        AppMethodBeat.i(115539);
        bu buVar = new bu();
        EventCenter.instance.publish(buVar);
        boolean z = buVar.dEZ.isStarted;
        AppMethodBeat.o(115539);
        return z;
    }

    public static boolean fKJ() {
        AppMethodBeat.i(115540);
        bj bjVar = new bj();
        EventCenter.instance.publish(bjVar);
        boolean z = bjVar.dEB.dEC;
        AppMethodBeat.o(115540);
        return z;
    }

    public static Notification e(s.c cVar) {
        AppMethodBeat.i(115541);
        if (d.oE(16)) {
            Notification build = cVar.build();
            AppMethodBeat.o(115541);
            return build;
        }
        Notification build2 = cVar.build();
        AppMethodBeat.o(115541);
        return build2;
    }
}
