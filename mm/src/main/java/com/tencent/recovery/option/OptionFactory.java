package com.tencent.recovery.option;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.recovery.ConstantsRecovery;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.util.Util;

public class OptionFactory {
    private static final String TAG = "Recovery.OptionFactory";
    private static IOptionsCreator creator;

    public static ProcessOptions getProcessOptions(String str, int i2) {
        ProcessOptions processOptions = null;
        if (creator != null) {
            processOptions = creator.createProcessOptions(str, i2);
        }
        if (processOptions != null) {
            return processOptions;
        }
        RecoveryLog.i(TAG, "not found custom process options, use default %d", Integer.valueOf(i2));
        if (i2 == 1) {
            return ConstantsRecovery.DefaultProcessOptions.ForegroundCrash;
        }
        return ConstantsRecovery.DefaultProcessOptions.Background;
    }

    public static void initOptionCreator(String str) {
        creator = getCreator(str);
    }

    public static CommonOptions getCommonOptions(Context context) {
        CommonOptions commonOptions = null;
        if (creator != null) {
            commonOptions = creator.createCommonOptions(context);
        }
        if (commonOptions != null) {
            return commonOptions;
        }
        RecoveryLog.i(TAG, "not found custom custom options, use default", new Object[0]);
        CommonOptions.Builder builder = new CommonOptions.Builder();
        builder.setConfigUrl("");
        builder.setDebugMode(false);
        builder.setUUID(String.valueOf(Util.getUUID(context)));
        try {
            builder.setClientVersion(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName);
        } catch (PackageManager.NameNotFoundException e2) {
        }
        builder.setUploadInterval(600000);
        builder.setHandleRetryInterval(600000);
        return builder.build();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.tencent.recovery.option.IOptionsCreator getCreator(java.lang.String r6) {
        /*
            r1 = 0
            r5 = 0
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ ClassNotFoundException -> 0x0032 }
            java.lang.String r0 = java.lang.String.format(r6, r0)     // Catch:{ ClassNotFoundException -> 0x0032 }
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x0032 }
            r2 = r0
        L_0x000e:
            if (r2 == 0) goto L_0x0036
            java.lang.Object r0 = r2.newInstance()     // Catch:{ Exception -> 0x0035 }
            com.tencent.recovery.option.IOptionsCreator r0 = (com.tencent.recovery.option.IOptionsCreator) r0     // Catch:{ Exception -> 0x0035 }
        L_0x0016:
            if (r0 == 0) goto L_0x0038
            java.lang.String r1 = "Recovery.OptionFactory"
            java.lang.String r3 = "getCreator %s success %s"
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r2 = r2.getName()
            r4[r5] = r2
            r2 = 1
            java.lang.String r5 = r0.toString()
            r4[r2] = r5
            com.tencent.recovery.log.RecoveryLog.i(r1, r3, r4)
        L_0x0031:
            return r0
        L_0x0032:
            r0 = move-exception
            r2 = r1
            goto L_0x000e
        L_0x0035:
            r0 = move-exception
        L_0x0036:
            r0 = r1
            goto L_0x0016
        L_0x0038:
            java.lang.String r1 = "Recovery.OptionFactory"
            java.lang.String r2 = "getCreator fail"
            java.lang.Object[] r3 = new java.lang.Object[r5]
            com.tencent.recovery.log.RecoveryLog.i(r1, r2, r3)
            goto L_0x0031
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.recovery.option.OptionFactory.getCreator(java.lang.String):com.tencent.recovery.option.IOptionsCreator");
    }
}
