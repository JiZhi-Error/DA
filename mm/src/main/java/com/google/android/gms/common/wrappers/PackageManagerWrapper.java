package com.google.android.gms.common.wrappers;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Process;
import android.support.v4.content.f;
import android.support.v4.e.k;
import com.google.android.gms.common.util.PlatformVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PackageManagerWrapper {
    private final Context zzjp;

    public PackageManagerWrapper(Context context) {
        this.zzjp = context;
    }

    public boolean allowApiAccess(String str, int i2) {
        return true;
    }

    public void checkCallerIsNotInstantApp() {
        AppMethodBeat.i(5347);
        if (isCallerInstantApp()) {
            SecurityException securityException = new SecurityException("This operation is not supported for instant apps.");
            AppMethodBeat.o(5347);
            throw securityException;
        }
        AppMethodBeat.o(5347);
    }

    public int checkCallingOrSelfPermission(String str) {
        AppMethodBeat.i(5338);
        int checkCallingOrSelfPermission = this.zzjp.checkCallingOrSelfPermission(str);
        AppMethodBeat.o(5338);
        return checkCallingOrSelfPermission;
    }

    public int checkCallingOrSelfPermissionAndAppOps(String str) {
        AppMethodBeat.i(5339);
        int f2 = f.f(this.zzjp, str);
        AppMethodBeat.o(5339);
        return f2;
    }

    public int checkCallingPermission(String str) {
        AppMethodBeat.i(5336);
        int checkCallingPermission = this.zzjp.checkCallingPermission(str);
        AppMethodBeat.o(5336);
        return checkCallingPermission;
    }

    @Deprecated
    public int checkCallingPermission(String str, String str2) {
        AppMethodBeat.i(5340);
        int checkPermission = checkPermission(str, str2);
        AppMethodBeat.o(5340);
        return checkPermission;
    }

    public void checkPackage(int i2, String str) {
        AppMethodBeat.i(5331);
        if (!uidHasPackageName(i2, str)) {
            SecurityException securityException = new SecurityException(new StringBuilder(String.valueOf(str).length() + 39).append("Package ").append(str).append(" does not belong to ").append(i2).toString());
            AppMethodBeat.o(5331);
            throw securityException;
        }
        AppMethodBeat.o(5331);
    }

    public int checkPermission(String str, int i2, int i3) {
        AppMethodBeat.i(5333);
        int checkPermission = this.zzjp.checkPermission(str, i2, i3);
        AppMethodBeat.o(5333);
        return checkPermission;
    }

    @Deprecated
    public int checkPermission(String str, int i2, int i3, String str2) {
        AppMethodBeat.i(5334);
        int checkPermission = checkPermission(str, i2, i3);
        AppMethodBeat.o(5334);
        return checkPermission;
    }

    public int checkPermission(String str, String str2) {
        AppMethodBeat.i(5341);
        int checkPermission = this.zzjp.getPackageManager().checkPermission(str, str2);
        AppMethodBeat.o(5341);
        return checkPermission;
    }

    public int checkPermissionAndAppOps(String str, int i2, int i3, String str2) {
        AppMethodBeat.i(5335);
        int a2 = f.a(this.zzjp, str, i2, i3, str2);
        AppMethodBeat.o(5335);
        return a2;
    }

    public ApplicationInfo getApplicationInfo(String str, int i2) {
        AppMethodBeat.i(5328);
        ApplicationInfo applicationInfo = this.zzjp.getPackageManager().getApplicationInfo(str, i2);
        AppMethodBeat.o(5328);
        return applicationInfo;
    }

    public CharSequence getApplicationLabel(String str) {
        AppMethodBeat.i(5344);
        CharSequence applicationLabel = this.zzjp.getPackageManager().getApplicationLabel(this.zzjp.getPackageManager().getApplicationInfo(str, 0));
        AppMethodBeat.o(5344);
        return applicationLabel;
    }

    public k<CharSequence, Drawable> getApplicationLabelAndIcon(String str) {
        AppMethodBeat.i(5345);
        ApplicationInfo applicationInfo = this.zzjp.getPackageManager().getApplicationInfo(str, 0);
        k<CharSequence, Drawable> c2 = k.c(this.zzjp.getPackageManager().getApplicationLabel(applicationInfo), this.zzjp.getPackageManager().getApplicationIcon(applicationInfo));
        AppMethodBeat.o(5345);
        return c2;
    }

    public ComponentName getCallingActivity(Activity activity) {
        AppMethodBeat.i(5343);
        ComponentName callingActivity = activity.getCallingActivity();
        AppMethodBeat.o(5343);
        return callingActivity;
    }

    public String getCallingPackage(Activity activity) {
        AppMethodBeat.i(5342);
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity == null) {
            AppMethodBeat.o(5342);
            return null;
        }
        String packageName = callingActivity.getPackageName();
        if (packageName == null) {
            String valueOf = String.valueOf(callingActivity);
            new StringBuilder(String.valueOf(valueOf).length() + 54).append("getCallingPackage(): Couldn't get a package name from ").append(valueOf);
            AppMethodBeat.o(5342);
            return null;
        }
        AppMethodBeat.o(5342);
        return packageName;
    }

    /* access modifiers changed from: protected */
    public Context getContext() {
        return this.zzjp;
    }

    public PackageInfo getPackageInfo(String str, int i2) {
        AppMethodBeat.i(5329);
        PackageInfo packageInfo = this.zzjp.getPackageManager().getPackageInfo(str, i2);
        AppMethodBeat.o(5329);
        return packageInfo;
    }

    public String[] getPackagesForUid(int i2) {
        AppMethodBeat.i(5330);
        String[] packagesForUid = this.zzjp.getPackageManager().getPackagesForUid(i2);
        AppMethodBeat.o(5330);
        return packagesForUid;
    }

    public boolean isCallerInstantApp() {
        String nameForUid;
        AppMethodBeat.i(5346);
        if (Binder.getCallingUid() == Process.myUid()) {
            boolean isInstantApp = InstantApps.isInstantApp(this.zzjp);
            AppMethodBeat.o(5346);
            return isInstantApp;
        } else if (!PlatformVersion.isAtLeastO() || (nameForUid = this.zzjp.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            AppMethodBeat.o(5346);
            return false;
        } else {
            boolean isInstantApp2 = this.zzjp.getPackageManager().isInstantApp(nameForUid);
            AppMethodBeat.o(5346);
            return isInstantApp2;
        }
    }

    public boolean isInstantAppUid(int i2) {
        return false;
    }

    @TargetApi(19)
    public boolean uidHasPackageName(int i2, String str) {
        AppMethodBeat.i(5332);
        if (PlatformVersion.isAtLeastKitKat()) {
            try {
                ((AppOpsManager) this.zzjp.getSystemService("appops")).checkPackage(i2, str);
                AppMethodBeat.o(5332);
                return true;
            } catch (SecurityException e2) {
                AppMethodBeat.o(5332);
                return false;
            }
        } else {
            String[] packagesForUid = this.zzjp.getPackageManager().getPackagesForUid(i2);
            if (!(str == null || packagesForUid == null)) {
                for (String str2 : packagesForUid) {
                    if (str.equals(str2)) {
                        AppMethodBeat.o(5332);
                        return true;
                    }
                }
            }
            AppMethodBeat.o(5332);
            return false;
        }
    }

    public int checkCallingPermissionAndAppOps(String str, String str2) {
        AppMethodBeat.i(5337);
        Context context = this.zzjp;
        if (Binder.getCallingPid() == Process.myPid()) {
            AppMethodBeat.o(5337);
            return -1;
        }
        int a2 = f.a(context, str, Binder.getCallingPid(), Binder.getCallingUid(), str2);
        AppMethodBeat.o(5337);
        return a2;
    }
}
