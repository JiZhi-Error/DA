package android.support.v4.content;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.Process;

public final class f {
    public static int a(Context context, String str, int i2, int i3, String str2) {
        String str3;
        int i4;
        if (context.checkPermission(str, i2, i3) == -1) {
            return -1;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            str3 = AppOpsManager.permissionToOp(str);
        } else {
            str3 = null;
        }
        if (str3 == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i3);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        if (Build.VERSION.SDK_INT >= 23) {
            i4 = ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(str3, str2);
        } else {
            i4 = 1;
        }
        if (i4 != 0) {
            return -2;
        }
        return 0;
    }

    public static int checkSelfPermission(Context context, String str) {
        return a(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }

    public static int f(Context context, String str) {
        return a(context, str, Binder.getCallingPid(), Binder.getCallingUid(), Binder.getCallingPid() == Process.myPid() ? context.getPackageName() : null);
    }
}
