package com.tencent.mm.platformtools;

import android.app.Activity;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.qqmusic.mediaplayer.PlayerException;

public final class x {
    private Runnable jNB;
    private boolean jNC = false;

    /* access modifiers changed from: package-private */
    public final void c(Activity activity, Runnable runnable) {
        AppMethodBeat.i(169125);
        boolean a2 = b.a(activity, "android.permission.WRITE_EXTERNAL_STORAGE", 32, "", "");
        Log.i("MicroMsg.PermissionCheckHelper", "check init, summerper checkPermission checkStorage[%b]", Boolean.valueOf(a2));
        if (!a2) {
            e.INSTANCE.idkeyStat(462, 18, 1, true);
            this.jNB = runnable;
            AppMethodBeat.o(169125);
            return;
        }
        d(activity, runnable);
        AppMethodBeat.o(169125);
    }

    private void d(Activity activity, Runnable runnable) {
        AppMethodBeat.i(169126);
        boolean a2 = b.a(activity, "android.permission.READ_PHONE_STATE", 96, "", "");
        Log.i("MicroMsg.PermissionCheckHelper", "check init, summerper checkPermission checkPhone[%b]", Boolean.valueOf(a2));
        if (!a2) {
            e.INSTANCE.idkeyStat(462, 20, 1, true);
            this.jNB = runnable;
            AppMethodBeat.o(169126);
            return;
        }
        q.aoy();
        if (runnable != null) {
            runnable.run();
        }
        AppMethodBeat.o(169126);
    }

    public final boolean a(Activity activity, int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(169127);
        if (iArr == null || iArr.length <= 0) {
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = strArr;
            objArr[3] = Util.getStack();
            Log.w("MicroMsg.PermissionCheckHelper", "onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s", objArr);
            AppMethodBeat.o(169127);
            return true;
        }
        Log.i("MicroMsg.PermissionCheckHelper", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case 32:
            case PlayerException.EXCEPTION_IN_SETAUDIOEFFECT /*{ENCODED_INT: 96}*/:
                if (iArr[0] != 0) {
                    SharedPreferences sharedPreferences = activity.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
                    sharedPreferences.edit().putBoolean(i2 == 32 ? "SP_PERMISSION_HAD_REQUEST_PERMISSION_STORAGE" : "SP_PERMISSION_HAD_REQUEST_PERMISSION_PHONE", true).apply();
                    sharedPreferences.edit().putInt("SP_PERMISSION_HAD_REQUEST_PERMISSION_UID", MMApplicationContext.getContext().getApplicationInfo().uid).apply();
                } else if (i2 == 32) {
                    e.INSTANCE.idkeyStat(462, 19, 1, true);
                } else if (i2 == 96) {
                    e.INSTANCE.idkeyStat(462, 21, 1, true);
                    q.aoH();
                    q.aoy();
                }
                if (i2 == 32) {
                    d(activity, this.jNB);
                } else if (this.jNB != null) {
                    this.jNB.run();
                }
                AppMethodBeat.o(169127);
                return true;
            default:
                AppMethodBeat.o(169127);
                return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(final android.app.Activity r7, final java.lang.Runnable r8) {
        /*
            r6 = this;
            r0 = 0
            r5 = 169124(0x294a4, float:2.36993E-40)
            r1 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            boolean r2 = r6.jNC
            if (r2 != 0) goto L_0x0044
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]
            java.lang.String r3 = "android.permission.WRITE_EXTERNAL_STORAGE"
            r2[r0] = r3
            java.lang.String r3 = "android.permission.READ_PHONE_STATE"
            r2[r1] = r3
            boolean r2 = com.tencent.mm.pluginsdk.permission.b.e(r7, r2)
            if (r2 != 0) goto L_0x0044
            r6.jNC = r1
            r1 = 2131763872(0x7f1022a0, float:1.9158861E38)
            java.lang.String r1 = r7.getString(r1)
            r2 = 2131763890(0x7f1022b2, float:1.9158898E38)
            java.lang.String r2 = r7.getString(r2)
            r3 = 2131763873(0x7f1022a1, float:1.9158863E38)
            java.lang.String r3 = r7.getString(r3)
            com.tencent.mm.platformtools.x$1 r4 = new com.tencent.mm.platformtools.x$1
            r4.<init>(r7, r8)
            com.tencent.mm.ui.base.h.a(r7, r1, r2, r3, r4)
        L_0x003e:
            if (r0 != 0) goto L_0x0046
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
        L_0x0043:
            return
        L_0x0044:
            r0 = r1
            goto L_0x003e
        L_0x0046:
            r6.c(r7, r8)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            goto L_0x0043
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.platformtools.x.b(android.app.Activity, java.lang.Runnable):void");
    }
}
