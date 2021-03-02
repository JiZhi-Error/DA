package com.tencent.smtt.sdk.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5CoreCacheManager;
import com.tencent.smtt.export.external.interfaces.IX5CoreCookieManager;
import com.tencent.smtt.export.external.interfaces.IX5CoreEntry;
import com.tencent.smtt.export.external.interfaces.IX5CoreGeolocationPermissions;
import com.tencent.smtt.export.external.interfaces.IX5CoreJsCore;
import com.tencent.smtt.export.external.interfaces.IX5CoreMessy;
import com.tencent.smtt.export.external.interfaces.IX5CoreNetwork;
import com.tencent.smtt.export.external.interfaces.IX5CoreOptimizedBitmap;
import com.tencent.smtt.export.external.interfaces.IX5CoreUrlUtil;
import com.tencent.smtt.export.external.interfaces.IX5CoreWebIconDB;
import com.tencent.smtt.export.external.interfaces.IX5CoreWebStorage;
import com.tencent.smtt.export.external.interfaces.IX5CoreWebViewDB;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.TbsCoreLoadStat;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.TbsShareManager;
import com.tencent.smtt.sdk.TbsWizard;
import com.tencent.smtt.utils.TbsLog;
import java.lang.reflect.Method;
import java.util.Map;

public class b implements IX5CoreEntry {

    /* renamed from: a  reason: collision with root package name */
    DexLoader f1990a;

    /* renamed from: b  reason: collision with root package name */
    Context f1991b;

    /* renamed from: c  reason: collision with root package name */
    Context f1992c;

    /* renamed from: d  reason: collision with root package name */
    String f1993d;

    /* renamed from: e  reason: collision with root package name */
    String f1994e;

    public b(DexLoader dexLoader, Context context, Context context2, String str, String str2) {
        this.f1990a = dexLoader;
        this.f1991b = context;
        this.f1992c = context2;
        this.f1993d = str;
        this.f1994e = str2;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreEntry
    public void initRuntimeEnvironment() {
        Object invokeStaticMethod;
        int i2;
        AppMethodBeat.i(188512);
        if (this.f1992c != null || TbsShareManager.getHostCorePathAppDefined() == null) {
            TbsLog.i("DexLoaderX5CoreEntry", "initTesRuntimeEnvironment callerContext is " + this.f1991b + " mHostContext is " + this.f1992c + " mDexLoader is " + this.f1990a + " mtbsInstallLocation is " + this.f1993d + " mDexOptPath is " + this.f1994e);
            invokeStaticMethod = this.f1990a.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, Integer.TYPE, String.class}, this.f1991b, this.f1992c, this.f1990a, this.f1993d, this.f1994e, TbsConfig.TBS_SDK_VERSIONNAME, Integer.valueOf((int) TbsConfig.TBS_SDK_VERSIONCODE), QbSdk.getTbsCoreVersionString());
        } else {
            invokeStaticMethod = this.f1990a.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, Integer.TYPE, String.class, String.class}, this.f1991b, this.f1992c, this.f1990a, this.f1993d, this.f1994e, TbsConfig.TBS_SDK_VERSIONNAME, Integer.valueOf((int) TbsConfig.TBS_SDK_VERSIONCODE), QbSdk.getTbsCoreVersionString(), TbsShareManager.getHostCorePathAppDefined());
        }
        if (invokeStaticMethod == null) {
            invokeStaticMethod = this.f1990a.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class}, this.f1991b, this.f1992c, this.f1990a, this.f1993d, this.f1994e);
        }
        if (invokeStaticMethod == null) {
            i2 = -3;
        } else if (invokeStaticMethod instanceof Integer) {
            i2 = ((Integer) invokeStaticMethod).intValue();
        } else if (invokeStaticMethod instanceof Throwable) {
            TbsCoreLoadStat.getInstance().setLoadErrorCode(this.f1991b, TbsListener.ErrorCode.THROWABLE_INITTESRUNTIMEENVIRONMENT, (Throwable) invokeStaticMethod);
            i2 = -5;
        } else {
            i2 = -4;
        }
        if (i2 < 0) {
            Object invokeStaticMethod2 = this.f1990a.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
            TbsLog.d("DexLoaderX5CoreEntry", "tbswizard.init --> getLoadFailureDetails:".concat(String.valueOf(invokeStaticMethod2)));
            if (invokeStaticMethod2 instanceof Throwable) {
                Throwable th = (Throwable) invokeStaticMethod2;
                new StringBuilder("#").append(th.getMessage()).append("; cause: ").append(th.getCause()).append("; th: ").append(th);
            }
        }
        AppMethodBeat.o(188512);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreEntry
    public void initSettings(Map map) {
        AppMethodBeat.i(188513);
        this.f1990a.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[]{Map.class}, QbSdk.mSettings);
        AppMethodBeat.o(188513);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreEntry
    public void setSdkVersionName(String str) {
        AppMethodBeat.i(188514);
        this.f1990a.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "setTesSdkVersionName", new Class[]{String.class}, TbsConfig.TBS_SDK_VERSIONNAME);
        AppMethodBeat.o(188514);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreEntry
    public void setSdkVersionCode(int i2) {
        AppMethodBeat.i(188515);
        this.f1990a.setStaticField("com.tencent.tbs.tbsshell.TBSShell", "VERSION", Integer.valueOf((int) TbsConfig.TBS_SDK_VERSIONCODE));
        AppMethodBeat.o(188515);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreEntry
    public void setQua2_v3(String str, String str2, String str3, String str4, String str5, boolean z) {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreEntry
    public void setQua1(String str) {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreEntry
    public boolean canUseX5() {
        Boolean bool;
        AppMethodBeat.i(188516);
        new Throwable();
        try {
            Method method = this.f1990a.getClassLoader().loadClass(TbsWizard.WEBCOREPROXY_CLASSNAME).getMethod("canUseX5", new Class[0]);
            method.setAccessible(true);
            Object invoke = method.invoke(null, new Object[0]);
            try {
                if (invoke instanceof Boolean) {
                    TbsLog.d("DexLoaderX5CoreEntry", "canUseX5 objRet=".concat(String.valueOf(invoke)));
                    boolean booleanValue = ((Boolean) invoke).booleanValue();
                    AppMethodBeat.o(188516);
                    return booleanValue;
                }
                bool = invoke;
                boolean booleanValue2 = bool.booleanValue();
                AppMethodBeat.o(188516);
                return booleanValue2;
            } catch (Throwable th) {
                bool = invoke;
            }
        } catch (Throwable th2) {
            bool = null;
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreEntry
    public IX5WebViewBase createX5WebView(Context context, boolean z) {
        IX5WebViewBase iX5WebViewBase;
        AppMethodBeat.i(188517);
        Object invokeStaticMethod = this.f1990a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "createSDKWebview", new Class[]{Context.class}, context);
        if (invokeStaticMethod == null) {
            try {
                Object invokeStaticMethod2 = this.f1990a.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
                if (invokeStaticMethod2 != null && (invokeStaticMethod2 instanceof Throwable)) {
                    TbsCoreLoadStat.getInstance().setLoadErrorCode(context, TbsListener.ErrorCode.THROWABLE_INITX5CORE, (Throwable) invokeStaticMethod2);
                }
                if (invokeStaticMethod2 != null && (invokeStaticMethod2 instanceof String)) {
                    TbsCoreLoadStat.getInstance().setLoadErrorCode(context, TbsListener.ErrorCode.THROWABLE_INITX5CORE, new Throwable((String) invokeStaticMethod2));
                }
                iX5WebViewBase = null;
                invokeStaticMethod = null;
            } catch (Exception e2) {
                iX5WebViewBase = null;
            }
        } else {
            iX5WebViewBase = (IX5WebViewBase) invokeStaticMethod;
            if (iX5WebViewBase != null) {
                try {
                    if (iX5WebViewBase.getView() == null) {
                        TbsCoreLoadStat.getInstance().setLoadErrorCode(context, TbsListener.ErrorCode.THROWABLE_INITX5CORE, new Throwable("x5webview.getView is null!"));
                        invokeStaticMethod = null;
                    }
                } catch (Exception e3) {
                }
            }
        }
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(188517);
            return null;
        }
        AppMethodBeat.o(188517);
        return iX5WebViewBase;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreEntry
    public IX5CoreCookieManager getX5CoreCookieManager() {
        AppMethodBeat.i(188518);
        j jVar = new j(this.f1990a);
        AppMethodBeat.o(188518);
        return jVar;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreEntry
    public IX5CoreCacheManager getX5CoreCacheManager() {
        AppMethodBeat.i(188519);
        a aVar = new a(this.f1990a);
        AppMethodBeat.o(188519);
        return aVar;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreEntry
    public IX5CoreMessy getX5CoreMessy() {
        AppMethodBeat.i(188520);
        l lVar = new l(this.f1990a, this.f1991b);
        AppMethodBeat.o(188520);
        return lVar;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreEntry
    public IX5CoreNetwork getX5CoreNetwork() {
        AppMethodBeat.i(188521);
        m mVar = new m(this.f1990a);
        AppMethodBeat.o(188521);
        return mVar;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreEntry
    public IX5CoreOptimizedBitmap getX5CoreOptimizedBitmap() {
        return null;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreEntry
    public IX5CoreUrlUtil getX5CoreUrlUtil() {
        AppMethodBeat.i(188522);
        f fVar = new f(this.f1990a);
        AppMethodBeat.o(188522);
        return fVar;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreEntry
    public IX5CoreWebIconDB getX5CoreWebIconDB() {
        AppMethodBeat.i(188523);
        g gVar = new g(this.f1990a);
        AppMethodBeat.o(188523);
        return gVar;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreEntry
    public IX5CoreWebStorage getX5CoreWebStorage() {
        AppMethodBeat.i(188524);
        h hVar = new h(this.f1990a);
        AppMethodBeat.o(188524);
        return hVar;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreEntry
    public IX5CoreWebViewDB getX5CoreWebViewDB() {
        AppMethodBeat.i(188525);
        i iVar = new i(this.f1990a);
        AppMethodBeat.o(188525);
        return iVar;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreEntry
    public IX5CoreJsCore getX5CoreJsCore() {
        AppMethodBeat.i(188526);
        n nVar = new n(this.f1990a);
        AppMethodBeat.o(188526);
        return nVar;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreEntry
    public IX5CoreGeolocationPermissions getX5CoreGeolocationPermissions() {
        AppMethodBeat.i(188527);
        k kVar = new k(this.f1990a);
        AppMethodBeat.o(188527);
        return kVar;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreEntry
    public boolean canLoadX5(Context context) {
        return false;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreEntry
    public int getCoreVersion() {
        return 0;
    }
}
