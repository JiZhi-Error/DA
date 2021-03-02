package com.google.android.gms.common.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.gms.common.wrappers.Wrappers;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WorkSourceUtil {
    public static final String TAG = "WorkSourceUtil";
    private static final int zzaam = Process.myUid();
    private static final Method zzaan = zzdf();
    private static final Method zzaao = zzdg();
    private static final Method zzaap = zzdh();
    private static final Method zzaaq = zzdi();
    private static final Method zzaar = zzdj();
    private static final Method zzaas = zzdk();
    private static final Method zzaat = zzdl();

    static {
        AppMethodBeat.i(5318);
        AppMethodBeat.o(5318);
    }

    private WorkSourceUtil() {
    }

    public static void add(WorkSource workSource, int i2, String str) {
        AppMethodBeat.i(5303);
        if (zzaao != null) {
            if (str == null) {
                str = "";
            }
            try {
                zzaao.invoke(workSource, Integer.valueOf(i2), str);
                AppMethodBeat.o(5303);
            } catch (Exception e2) {
                Log.wtf(TAG, "Unable to assign blame through WorkSource", e2);
                AppMethodBeat.o(5303);
            }
        } else {
            if (zzaan != null) {
                try {
                    zzaan.invoke(workSource, Integer.valueOf(i2));
                    AppMethodBeat.o(5303);
                    return;
                } catch (Exception e3) {
                    Log.wtf(TAG, "Unable to assign blame through WorkSource", e3);
                }
            }
            AppMethodBeat.o(5303);
        }
    }

    public static WorkSource fromPackage(Context context, String str) {
        AppMethodBeat.i(5302);
        if (context == null || context.getPackageManager() == null || str == null) {
            AppMethodBeat.o(5302);
            return null;
        }
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
            if (applicationInfo == null) {
                String valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    "Could not get applicationInfo from package: ".concat(valueOf);
                } else {
                    new String("Could not get applicationInfo from package: ");
                }
                AppMethodBeat.o(5302);
                return null;
            }
            WorkSource fromUidAndPackage = fromUidAndPackage(applicationInfo.uid, str);
            AppMethodBeat.o(5302);
            return fromUidAndPackage;
        } catch (PackageManager.NameNotFoundException e2) {
            String valueOf2 = String.valueOf(str);
            if (valueOf2.length() != 0) {
                "Could not find package: ".concat(valueOf2);
            } else {
                new String("Could not find package: ");
            }
            AppMethodBeat.o(5302);
            return null;
        }
    }

    public static WorkSource fromPackageAndModuleExperimentalPi(Context context, String str, String str2) {
        WorkSource workSource = null;
        AppMethodBeat.i(5304);
        if (context == null || context.getPackageManager() == null || str2 == null || str == null) {
            AppMethodBeat.o(5304);
        } else {
            int zzc = zzc(context, str);
            if (zzc < 0) {
                AppMethodBeat.o(5304);
            } else {
                workSource = new WorkSource();
                if (zzaas == null || zzaat == null) {
                    add(workSource, zzc, str);
                } else {
                    try {
                        Object invoke = zzaas.invoke(workSource, new Object[0]);
                        if (zzc != zzaam) {
                            zzaat.invoke(invoke, Integer.valueOf(zzc), str);
                        }
                        zzaat.invoke(invoke, Integer.valueOf(zzaam), str2);
                    } catch (Exception e2) {
                    }
                }
                AppMethodBeat.o(5304);
            }
        }
        return workSource;
    }

    public static WorkSource fromUidAndPackage(int i2, String str) {
        AppMethodBeat.i(5301);
        WorkSource workSource = new WorkSource();
        add(workSource, i2, str);
        AppMethodBeat.o(5301);
        return workSource;
    }

    public static int get(WorkSource workSource, int i2) {
        AppMethodBeat.i(5306);
        if (zzaaq != null) {
            try {
                int intValue = ((Integer) zzaaq.invoke(workSource, Integer.valueOf(i2))).intValue();
                AppMethodBeat.o(5306);
                return intValue;
            } catch (Exception e2) {
                Log.wtf(TAG, "Unable to assign blame through WorkSource", e2);
            }
        }
        AppMethodBeat.o(5306);
        return 0;
    }

    public static String getName(WorkSource workSource, int i2) {
        AppMethodBeat.i(5307);
        if (zzaar != null) {
            try {
                String str = (String) zzaar.invoke(workSource, Integer.valueOf(i2));
                AppMethodBeat.o(5307);
                return str;
            } catch (Exception e2) {
                Log.wtf(TAG, "Unable to assign blame through WorkSource", e2);
            }
        }
        AppMethodBeat.o(5307);
        return null;
    }

    public static List<String> getNames(WorkSource workSource) {
        AppMethodBeat.i(5308);
        int size = workSource == null ? 0 : size(workSource);
        if (size == 0) {
            List<String> emptyList = Collections.emptyList();
            AppMethodBeat.o(5308);
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            String name = getName(workSource, i2);
            if (!Strings.isEmptyOrWhitespace(name)) {
                arrayList.add(name);
            }
        }
        AppMethodBeat.o(5308);
        return arrayList;
    }

    public static boolean hasWorkSourcePermission(Context context) {
        AppMethodBeat.i(5309);
        if (context == null) {
            AppMethodBeat.o(5309);
            return false;
        } else if (context.getPackageManager() == null) {
            AppMethodBeat.o(5309);
            return false;
        } else if (Wrappers.packageManager(context).checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) == 0) {
            AppMethodBeat.o(5309);
            return true;
        } else {
            AppMethodBeat.o(5309);
            return false;
        }
    }

    public static int size(WorkSource workSource) {
        AppMethodBeat.i(5305);
        if (zzaap != null) {
            try {
                int intValue = ((Integer) zzaap.invoke(workSource, new Object[0])).intValue();
                AppMethodBeat.o(5305);
                return intValue;
            } catch (Exception e2) {
                Log.wtf(TAG, "Unable to assign blame through WorkSource", e2);
            }
        }
        AppMethodBeat.o(5305);
        return 0;
    }

    private static int zzc(Context context, String str) {
        AppMethodBeat.i(5310);
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
            if (applicationInfo == null) {
                String valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    "Could not get applicationInfo from package: ".concat(valueOf);
                } else {
                    new String("Could not get applicationInfo from package: ");
                }
                AppMethodBeat.o(5310);
                return -1;
            }
            int i2 = applicationInfo.uid;
            AppMethodBeat.o(5310);
            return i2;
        } catch (PackageManager.NameNotFoundException e2) {
            String valueOf2 = String.valueOf(str);
            if (valueOf2.length() != 0) {
                "Could not find package: ".concat(valueOf2);
            } else {
                new String("Could not find package: ");
            }
            AppMethodBeat.o(5310);
            return -1;
        }
    }

    private static Method zzdf() {
        AppMethodBeat.i(5311);
        Method method = null;
        try {
            method = WorkSource.class.getMethod("add", Integer.TYPE);
        } catch (Exception e2) {
        }
        AppMethodBeat.o(5311);
        return method;
    }

    private static Method zzdg() {
        AppMethodBeat.i(5312);
        Method method = null;
        if (PlatformVersion.isAtLeastJellyBeanMR2()) {
            try {
                method = WorkSource.class.getMethod("add", Integer.TYPE, String.class);
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(5312);
        return method;
    }

    private static Method zzdh() {
        AppMethodBeat.i(5313);
        Method method = null;
        try {
            method = WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception e2) {
        }
        AppMethodBeat.o(5313);
        return method;
    }

    private static Method zzdi() {
        AppMethodBeat.i(5314);
        Method method = null;
        try {
            method = WorkSource.class.getMethod("get", Integer.TYPE);
        } catch (Exception e2) {
        }
        AppMethodBeat.o(5314);
        return method;
    }

    private static Method zzdj() {
        AppMethodBeat.i(5315);
        Method method = null;
        if (PlatformVersion.isAtLeastJellyBeanMR2()) {
            try {
                method = WorkSource.class.getMethod("getName", Integer.TYPE);
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(5315);
        return method;
    }

    private static final Method zzdk() {
        AppMethodBeat.i(5316);
        Method method = null;
        if (PlatformVersion.isAtLeastP()) {
            try {
                method = WorkSource.class.getMethod("createWorkChain", new Class[0]);
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(5316);
        return method;
    }

    @SuppressLint({"PrivateApi"})
    private static final Method zzdl() {
        AppMethodBeat.i(5317);
        Method method = null;
        if (PlatformVersion.isAtLeastP()) {
            try {
                method = Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", Integer.TYPE, String.class);
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(5317);
        return method;
    }
}
