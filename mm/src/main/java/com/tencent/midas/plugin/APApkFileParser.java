package com.tencent.midas.plugin;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

public class APApkFileParser {
    public static boolean isSignaturesSame(Signature[] signatureArr, Signature[] signatureArr2) {
        AppMethodBeat.i(193211);
        if (signatureArr == null) {
            AppMethodBeat.o(193211);
            return true;
        } else if (signatureArr2 == null) {
            AppMethodBeat.o(193211);
            return true;
        } else {
            HashSet hashSet = new HashSet();
            for (Signature signature : signatureArr) {
                hashSet.add(signature);
            }
            HashSet hashSet2 = new HashSet();
            for (Signature signature2 : signatureArr2) {
                hashSet2.add(signature2);
            }
            boolean equals = hashSet.equals(hashSet2);
            AppMethodBeat.o(193211);
            return equals;
        }
    }

    public static PackageInfo getPackageInfo(Context context, String str, int i2) {
        AppMethodBeat.i(193212);
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageArchiveInfo(str, i2);
        } catch (Exception e2) {
        }
        AppMethodBeat.o(193212);
        return packageInfo;
    }

    public static Drawable getAPKIcon(Context context, String str) {
        AppMethodBeat.i(193213);
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1);
            if (packageArchiveInfo == null || packageArchiveInfo.applicationInfo == null) {
                AppMethodBeat.o(193213);
                return null;
            }
            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            Class<?> cls = Class.forName("android.content.res.AssetManager");
            AssetManager assetManager = (AssetManager) cls.getConstructor(null).newInstance(null);
            cls.getDeclaredMethod("addAssetPath", String.class).invoke(assetManager, str);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics.setToDefaults();
            Resources resources = new Resources(assetManager, displayMetrics, context.getResources().getConfiguration());
            if (applicationInfo.icon != 0) {
                Drawable drawable = resources.getDrawable(applicationInfo.icon);
                AppMethodBeat.o(193213);
                return drawable;
            }
            AppMethodBeat.o(193213);
            return null;
        } catch (Throwable th) {
        }
    }

    public static boolean isApkFileBroken(Context context, String str) {
        AppMethodBeat.i(193214);
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 64);
        if (packageArchiveInfo == null || packageArchiveInfo.applicationInfo == null) {
            AppMethodBeat.o(193214);
            return true;
        }
        AppMethodBeat.o(193214);
        return false;
    }
}
