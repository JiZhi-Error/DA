package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.launching.e.f;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Method;

public abstract class a implements f {
    /* access modifiers changed from: protected */
    public abstract boolean b(Context context, LaunchParcel launchParcel);

    @Override // com.tencent.mm.plugin.appbrand.launching.e.f
    public final boolean a(Context context, String str, String str2, String str3, int i2, int i3, AppBrandStatObject appBrandStatObject, AppBrandLaunchReferrer appBrandLaunchReferrer, LaunchParamsOptional launchParamsOptional) {
        LaunchParcel launchParcel = new LaunchParcel();
        launchParcel.username = str;
        launchParcel.appId = str2;
        launchParcel.kHw = str3 == null ? null : str3.trim();
        if (j.a.isValid(i2)) {
            launchParcel.iOo = i2;
        } else {
            Log.e("MicroMsg.AppBrand.Precondition.AbstractLaunchEntry", "start with invalid versionType[%d], use 0 instead, stack=%s", Integer.valueOf(i2), android.util.Log.getStackTraceString(new Throwable()));
            launchParcel.iOo = 0;
        }
        launchParcel.version = i3;
        launchParcel.mYK = appBrandStatObject;
        launchParcel.cys = appBrandLaunchReferrer;
        launchParcel.mYL = launchParamsOptional;
        return a(context, launchParcel);
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.e.f
    public final boolean a(Context context, LaunchParcel launchParcel) {
        if (Util.isNullOrNil(launchParcel.username) && Util.isNullOrNil(launchParcel.appId)) {
            return false;
        }
        launchParcel.mYM = Util.nowMilliSecond();
        if (context == null || ((context instanceof Activity) && ((Activity) context).isFinishing())) {
            context = MMApplicationContext.getContext();
        } else if (context instanceof Activity) {
            TypedArray typedArray = null;
            try {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{16842840});
                if (!obtainStyledAttributes.getBoolean(0, false)) {
                    Activity activity = (Activity) context;
                    try {
                        Method declaredMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
                        declaredMethod.setAccessible(true);
                        declaredMethod.invoke(activity, new Object[0]);
                    } catch (Throwable th) {
                        Log.printErrStackTrace("MicroMsg.AppBrand.Precondition.AbstractLaunchEntry", th, "call convertActivityFromTranslucent Fail: %s", th.getMessage());
                    }
                }
                if (obtainStyledAttributes != null) {
                    obtainStyledAttributes.recycle();
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppBrand.Precondition.AbstractLaunchEntry", e2, "convertActivityFromTranslucent %s", context.getClass().getSimpleName());
                if (0 != 0) {
                    typedArray.recycle();
                }
            } catch (Throwable th2) {
                if (0 != 0) {
                    typedArray.recycle();
                }
                throw th2;
            }
        }
        return b(context, launchParcel);
    }
}
