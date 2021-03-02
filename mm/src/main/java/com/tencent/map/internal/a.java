package com.tencent.map.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.map.lib.JNIInterface;
import com.tencent.map.tools.Util;
import com.tencent.map.tools.sheet.SheetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.BaseMapView;
import com.tencent.tencentmap.mapsdk.maps.BuildConfig;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;

public final class a extends SheetManager.UncaughtListener {

    /* renamed from: a  reason: collision with root package name */
    public final SheetManager.Options f1298a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f1299b;

    static /* synthetic */ BaseMapView.MapViewProxy a(a aVar, ViewGroup viewGroup, TencentMapOptions tencentMapOptions) {
        AppMethodBeat.i(193491);
        BaseMapView.MapViewProxy a2 = aVar.a(viewGroup, tencentMapOptions);
        AppMethodBeat.o(193491);
        return a2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context, TencentMapOptions tencentMapOptions) {
        super(Thread.getDefaultUncaughtExceptionHandler());
        String mapKey;
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(193488);
        this.f1299b = context.getApplicationContext();
        String str = "";
        if (TextUtils.isEmpty(tencentMapOptions.getMapKey())) {
            try {
                Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                mapKey = bundle != null ? bundle.getString(Util.META_NAME_API_KEY) : str;
            } catch (Exception e2) {
                mapKey = str;
            }
        } else {
            mapKey = tencentMapOptions.getMapKey();
        }
        if (context == null || Util.findClass("com.tencent.bugly.crashreport.CrashReport", getClass().getClassLoader()) == null) {
            z = false;
        } else {
            SharedPreferences.Editor edit = context.getSharedPreferences("BuglySdkInfos", 0).edit();
            edit.putString("4025282fa3", "4.4.0.0_3359e9135");
            edit.apply();
            z = true;
        }
        this.f1298a = new SheetManager.Options().setAdapterType(SheetManager.Options.AdapterType.LOC_SHEET).setSheetEnable(true).setSheetProjectName(BuildConfig.SHEET_PROJECT_NAME).setSoLibName(JNIInterface.LIB_NAME).setVersion(BuildConfig.VERSION_NAME).setVersionCode(AppEventsConstants.EVENT_PARAM_VALUE_NO).setSdkRepo(BuildConfig.REPO_VERSION).setFlavor(BuildConfig.FLAVOR).setAppKey(mapKey).setCoreLogOn(z ? false : z2).setCoreLogReportUrl("https://analytics.map.qq.com/tr?mllc").setUncaughtListener(this);
        AppMethodBeat.o(193488);
    }

    public final BaseMapView.MapViewProxy a(ViewGroup viewGroup, TencentMapOptions tencentMapOptions) {
        AppMethodBeat.i(193489);
        Object newSheetIns = SheetManager.getInstance().newSheetIns(SheetManager.getInstance().findSheet("com.tencent.mapsdk.core.MapDelegateFactoryImpl"), new Object[0]);
        BaseMapView.MapViewProxy mapViewProxy = (BaseMapView.MapViewProxy) SheetManager.getInstance().callSheetMth(newSheetIns, "createDelegate", new Class[]{Context.class, TencentMapOptions.class, ViewGroup.class}, new Object[]{this.f1299b, tencentMapOptions, viewGroup});
        AppMethodBeat.o(193489);
        return mapViewProxy;
    }

    @Override // com.tencent.map.tools.sheet.listener.ModuleUncaughtListener
    public final boolean onModuleSDKCrashed(Throwable th) {
        AppMethodBeat.i(193490);
        Class findSheet = SheetManager.getInstance().findSheet("com.tencent.mapsdk.core.utils.log.TraceUtil");
        SheetManager.getInstance().callSheetStaMth(findSheet, "reportCrash", new Class[]{Throwable.class}, new Object[]{th});
        AppMethodBeat.o(193490);
        return false;
    }
}
