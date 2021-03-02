package org.xwalk.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.xweb.a;
import com.tencent.xweb.util.h;
import com.tencent.xweb.util.i;
import com.tencent.xweb.xwalk.updater.Scheduler;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import org.xwalk.core.resource.XWalkContextWrapper;

public class XWalkCoreWrapper {
    private static final String BRIDGE_PACKAGE = "org.xwalk.core.internal";
    public static final int INVOKE_NOTITY_FUNCTION_ID_FOR_TEST = 10001;
    public static final int INVOKE_NOTITY_FUNCTION_ID_IDKEY = 50001;
    public static final int INVOKE_NOTITY_FUNCTION_ID_KVSTAT = 50002;
    public static final int InvokeChannel_func_id_log = 30002;
    public static final int InvokeChannel_func_native_trans = 30003;
    private static final String TAG = "XWalkLib";
    private static final String WRAPPER_PACKAGE = "org.xwalk.core";
    private static ClassLoader mStandAloneClassLoader;
    private static XWalkCoreWrapper sInstance;
    private static XWalkCoreWrapper sProvisionalInstance;
    private static HashMap<String, LinkedList<ReservedAction>> sReservedActions = new HashMap<>();
    private static LinkedList<String> sReservedActivities = new LinkedList<>();
    private int mApiVersion = 8;
    private int mApkVersion;
    private Context mBridgeContext;
    private ClassLoader mBridgeLoader;
    private int mCoreStatus;
    private int mMinApiVersion;
    private Context mWrapperContext;
    ClassLoader sBridgeLoader;

    static {
        AppMethodBeat.i(154682);
        AppMethodBeat.o(154682);
    }

    /* access modifiers changed from: package-private */
    public static class ReservedAction {
        Object[] mArguments;
        Class<?> mClass;
        ReflectMethod mMethod;
        Object mObject;

        ReservedAction(Object obj) {
            this.mObject = obj;
        }

        ReservedAction(Class<?> cls) {
            this.mClass = cls;
        }

        ReservedAction(ReflectMethod reflectMethod) {
            AppMethodBeat.i(154645);
            this.mMethod = reflectMethod;
            if (reflectMethod.getArguments() != null) {
                this.mArguments = Arrays.copyOf(reflectMethod.getArguments(), reflectMethod.getArguments().length);
            }
            AppMethodBeat.o(154645);
        }
    }

    public static XWalkCoreWrapper getInstance() {
        return sInstance;
    }

    public static int getCoreStatus() {
        if (sInstance != null) {
            return sInstance.mCoreStatus;
        }
        if (sProvisionalInstance == null) {
            return 0;
        }
        return sProvisionalInstance.mCoreStatus;
    }

    public static void handlePreInit(String str) {
        AppMethodBeat.i(154646);
        if (sInstance != null) {
            AppMethodBeat.o(154646);
            return;
        }
        Log.d(TAG, "Pre init xwalk core in ".concat(String.valueOf(str)));
        if (sReservedActions.containsKey(str)) {
            sReservedActions.remove(str);
        } else {
            sReservedActivities.add(str);
        }
        sReservedActions.put(str, new LinkedList<>());
        AppMethodBeat.o(154646);
    }

    public static void reserveReflectObject(Object obj) {
        AppMethodBeat.i(154647);
        String last = sReservedActivities.getLast();
        Log.d(TAG, "Reserve object " + obj.getClass() + " to " + last);
        sReservedActions.get(last).add(new ReservedAction(obj));
        AppMethodBeat.o(154647);
    }

    public static void reserveReflectClass(Class<?> cls) {
        AppMethodBeat.i(154648);
        String last = sReservedActivities.getLast();
        Log.d(TAG, "Reserve class " + cls.toString() + " to " + last);
        sReservedActions.get(last).add(new ReservedAction(cls));
        AppMethodBeat.o(154648);
    }

    public static void reserveReflectMethod(ReflectMethod reflectMethod) {
        AppMethodBeat.i(154649);
        String last = sReservedActivities.getLast();
        Log.d(TAG, "Reserve method " + reflectMethod.toString() + " to " + last);
        sReservedActions.get(last).add(new ReservedAction(reflectMethod));
        AppMethodBeat.o(154649);
    }

    public static void handlePostInit(String str) {
        AppMethodBeat.i(154650);
        Log.d(TAG, "Post init xwalk core in ".concat(String.valueOf(str)));
        if (!sReservedActions.containsKey(str)) {
            AppMethodBeat.o(154650);
            return;
        }
        LinkedList<ReservedAction> linkedList = sReservedActions.get(str);
        while (linkedList.size() != 0) {
            ReservedAction pop = linkedList.pop();
            if (pop.mObject != null) {
                Log.d(TAG, "Init reserved object: " + pop.mObject.getClass());
                new ReflectMethod(pop.mObject, "reflectionInit", new Class[0]).invoke(new Object[0]);
            } else if (pop.mClass != null) {
                Log.d(TAG, "Init reserved class: " + pop.mClass.toString());
                new ReflectMethod(pop.mClass, "reflectionInit", (Class<?>[]) new Class[0]).invoke(new Object[0]);
            } else {
                Log.d(TAG, "Call reserved method: " + pop.mMethod.toString());
                Object[] objArr = pop.mArguments;
                if (objArr != null) {
                    for (int i2 = 0; i2 < objArr.length; i2++) {
                        if (objArr[i2] instanceof ReflectMethod) {
                            objArr[i2] = ((ReflectMethod) objArr[i2]).invokeWithArguments();
                        }
                    }
                }
                pop.mMethod.invoke(objArr);
            }
        }
        sReservedActions.remove(str);
        sReservedActivities.remove(str);
        AppMethodBeat.o(154650);
    }

    public static void handleRuntimeError(Exception exc) {
        AppMethodBeat.i(154651);
        Log.e(TAG, "This API is incompatible with the Crosswalk runtime library:" + exc.getMessage());
        AppMethodBeat.o(154651);
    }

    public ClassLoader getBridgeLoader() {
        AppMethodBeat.i(183749);
        if (this.sBridgeLoader != null) {
            ClassLoader classLoader = this.sBridgeLoader;
            AppMethodBeat.o(183749);
            return classLoader;
        }
        this.sBridgeLoader = i.asW(this.mApkVersion);
        ClassLoader classLoader2 = this.sBridgeLoader;
        AppMethodBeat.o(183749);
        return classLoader2;
    }

    public int getApkVersion() {
        int i2;
        AppMethodBeat.i(154653);
        ClassLoader bridgeLoader = getBridgeLoader();
        if (bridgeLoader == null) {
            AppMethodBeat.o(154653);
            return 0;
        }
        try {
            Class<?> loadClass = bridgeLoader.loadClass("org.xwalk.core.internal.XWalkCoreVersion");
            if (loadClass == null) {
                AppMethodBeat.o(154653);
                return 0;
            }
            try {
                i2 = ((Integer) new ReflectField(loadClass, "XWALK_APK_VERSION").get()).intValue();
            } catch (RuntimeException e2) {
                i2 = 0;
            }
            AppMethodBeat.o(154653);
            return i2;
        } catch (ClassNotFoundException e3) {
            AppMethodBeat.o(154653);
            return 0;
        }
    }

    public boolean isDownLoadCoreAvailable() {
        AppMethodBeat.i(154654);
        ClassLoader bridgeLoader = getBridgeLoader();
        if (bridgeLoader == null) {
            AppMethodBeat.o(154654);
            return false;
        }
        try {
            if (bridgeLoader.loadClass("org.xwalk.core.internal.XWalkCoreVersion") == null) {
                AppMethodBeat.o(154654);
                return false;
            }
            AppMethodBeat.o(154654);
            return true;
        } catch (ClassNotFoundException e2) {
            AppMethodBeat.o(154654);
            return false;
        }
    }

    public static int attachXWalkCore(int i2) {
        AppMethodBeat.i(154655);
        if (sReservedActivities.isEmpty()) {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(154655);
            throw assertionError;
        } else if (sInstance != null) {
            AssertionError assertionError2 = new AssertionError();
            AppMethodBeat.o(154655);
            throw assertionError2;
        } else {
            Log.i(TAG, "Attach xwalk core");
            if (i2 == -1) {
                Log.i(TAG, "version = -1, no xwalk");
                AppMethodBeat.o(154655);
                return 10;
            }
            sProvisionalInstance = new XWalkCoreWrapper(XWalkEnvironment.getApplicationContext(), 1, i2);
            if (XWalkEnvironment.isDownloadMode()) {
                sProvisionalInstance.findDownloadedCore();
                int i3 = sProvisionalInstance.mCoreStatus;
                AppMethodBeat.o(154655);
                return i3;
            }
            int i4 = sProvisionalInstance.mCoreStatus;
            AppMethodBeat.o(154655);
            return i4;
        }
    }

    public static void dockXWalkCore() {
        AppMethodBeat.i(154656);
        if (sProvisionalInstance == null) {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(154656);
            throw assertionError;
        } else if (sInstance != null) {
            AssertionError assertionError2 = new AssertionError();
            AppMethodBeat.o(154656);
            throw assertionError2;
        } else {
            Log.d(TAG, "Dock xwalk core");
            sInstance = sProvisionalInstance;
            sProvisionalInstance = null;
            a.hsb().nT("DIS_INIT_XWALK_AT_LOAD", "tools");
            AppMethodBeat.o(154656);
        }
    }

    public static void initEmbeddedMode() {
        AppMethodBeat.i(154657);
        if (sInstance != null || !sReservedActivities.isEmpty()) {
            AppMethodBeat.o(154657);
            return;
        }
        RuntimeException runtimeException = new RuntimeException("royle:downloadmode should not goto this");
        AppMethodBeat.o(154657);
        throw runtimeException;
    }

    private XWalkCoreWrapper(Context context, int i2, int i3) {
        AppMethodBeat.i(154658);
        this.mMinApiVersion = (i2 <= 0 || i2 > this.mApiVersion) ? this.mApiVersion : i2;
        this.mCoreStatus = 0;
        this.mWrapperContext = new XWalkContextWrapper(context, XWalkEnvironment.getAvailableVersion());
        this.mApkVersion = i3;
        AppMethodBeat.o(154658);
    }

    private void initCoreBridge() {
        AppMethodBeat.i(154659);
        Log.d(TAG, "Init core bridge");
        new ReflectMethod(getBridgeClass("XWalkCoreBridge"), APMidasPluginInfo.LAUNCH_INTERFACE_INIT, (Class<?>[]) new Class[]{Context.class, Object.class}).invoke(this.mBridgeContext, this);
        AppMethodBeat.o(154659);
    }

    private void initXWalkView() {
        AppMethodBeat.i(154660);
        Log.d(TAG, "Init xwalk view");
        new ReflectMethod(getBridgeClass("XWalkViewDelegate"), APMidasPluginInfo.LAUNCH_INTERFACE_INIT, (Class<?>[]) new Class[]{Context.class, Context.class}).invoke(this.mBridgeContext, this.mWrapperContext);
        AppMethodBeat.o(154660);
    }

    private boolean findDownloadedCore() {
        AppMethodBeat.i(154661);
        this.mBridgeLoader = getBridgeLoader();
        sProvisionalInstance.initCoreBridge();
        if (this.mBridgeLoader == null || !checkCoreVersion() || !checkCoreArchitecture() || !checkCoreApk()) {
            Log.e(TAG, "mBridgeLoader set to null , prev mBridgeLoader =  " + this.mBridgeLoader);
            this.mBridgeLoader = null;
            AppMethodBeat.o(154661);
            return false;
        }
        if (!initLog(sProvisionalInstance)) {
            Log.e(TAG, "initLog failed !");
        } else {
            Log.i(TAG, "initLog success!");
        }
        Log.d(TAG, "Running in downloaded mode");
        this.mCoreStatus = 1;
        AppMethodBeat.o(154661);
        return true;
    }

    public boolean checkCoreVersion() {
        AppMethodBeat.i(154662);
        Log.i(TAG, "[Environment] SDK:" + Build.VERSION.SDK_INT);
        Log.i(TAG, "[App Version] build:24.53.595.0, api:" + this.mApiVersion + ", min_api:" + this.mMinApiVersion);
        try {
            Class<?> bridgeClass = getBridgeClass("XWalkCoreVersion");
            String str = "";
            try {
                str = (String) new ReflectField(bridgeClass, "XWALK_BUILD_VERSION").get();
            } catch (RuntimeException e2) {
            }
            int intValue = ((Integer) new ReflectField(bridgeClass, "API_VERSION").get()).intValue();
            int intValue2 = ((Integer) new ReflectField(bridgeClass, "MIN_API_VERSION").get()).intValue();
            Log.i(TAG, "[Lib Version] build:" + str + ", api:" + intValue + ", min_api:" + intValue2);
            if (XWalkEnvironment.isDownloadMode() && XWalkEnvironment.isDownloadModeUpdate() && !str.isEmpty() && !str.equals(XWalkAppVersion.XWALK_BUILD_VERSION)) {
                this.mCoreStatus = 8;
                AppMethodBeat.o(154662);
                return false;
            } else if (this.mMinApiVersion > intValue) {
                this.mCoreStatus = 3;
                AppMethodBeat.o(154662);
                return false;
            } else if (this.mApiVersion < intValue2) {
                this.mCoreStatus = 4;
                AppMethodBeat.o(154662);
                return false;
            } else {
                Log.i(TAG, "XWalk core version matched");
                AppMethodBeat.o(154662);
                return true;
            }
        } catch (RuntimeException e3) {
            Log.e(TAG, "XWalk core not found");
            this.mCoreStatus = 2;
            AppMethodBeat.o(154662);
            return false;
        }
    }

    private boolean initLog(XWalkCoreWrapper xWalkCoreWrapper) {
        AppMethodBeat.i(154663);
        if (XWalkEnvironment.getAvailableVersion() < 153) {
            Log.d(TAG, "XWalk runtime version not matched 153");
            AppMethodBeat.o(154663);
            return false;
        }
        AnonymousClass1 r2 = new XWalkLogMessageListener(xWalkCoreWrapper) {
            /* class org.xwalk.core.XWalkCoreWrapper.AnonymousClass1 */

            @Override // org.xwalk.core.XWalkLogMessageListener
            public void onLogMessage(int i2, String str, int i3, String str2) {
                AppMethodBeat.i(154643);
                Log.i(XWalkCoreWrapper.TAG, "[WCWebview] :".concat(String.valueOf(str2)));
                AppMethodBeat.o(154643);
            }
        };
        try {
            Class<?> bridgeClass = getBridgeClass("XWalkViewDelegate");
            Object bridge = r2.getBridge();
            new ReflectMethod(bridgeClass, "setLogCallBack", (Class<?>[]) new Class[]{Object.class}).invoke(bridge);
            AppMethodBeat.o(154663);
            return true;
        } catch (RuntimeException e2) {
            Log.d(TAG, e2.getLocalizedMessage());
            AppMethodBeat.o(154663);
            return false;
        }
    }

    public boolean initNotifyChannnel() {
        AppMethodBeat.i(154664);
        if (XWalkEnvironment.getAvailableVersion() < 153) {
            Log.d(TAG, "XWalk runtime version not matched 153");
            AppMethodBeat.o(154664);
            return false;
        }
        AnonymousClass2 r2 = new XWalkNotifyChannelListener() {
            /* class org.xwalk.core.XWalkCoreWrapper.AnonymousClass2 */

            @Override // org.xwalk.core.XWalkNotifyChannelListener
            public void onNotifyCallBackChannel(int i2, Object[] objArr) {
                AppMethodBeat.i(154644);
                Log.i(XWalkCoreWrapper.TAG, "XWalkNotifyChannelListener called  funid = " + i2 + " para size = " + objArr.length);
                switch (i2) {
                    case XWalkCoreWrapper.INVOKE_NOTITY_FUNCTION_ID_IDKEY /*{ENCODED_INT: 50001}*/:
                        h.s(Long.parseLong((String) objArr[0]), Long.parseLong((String) objArr[1]), (long) Integer.parseInt((String) objArr[2]));
                        AppMethodBeat.o(154644);
                        return;
                    case XWalkCoreWrapper.INVOKE_NOTITY_FUNCTION_ID_KVSTAT /*{ENCODED_INT: 50002}*/:
                        h.dz(Integer.parseInt((String) objArr[0]), (String) objArr[1]);
                        AppMethodBeat.o(154644);
                        return;
                    default:
                        try {
                            Log.i(XWalkCoreWrapper.TAG, "XWalkNotifyChannelListener called  funid = " + i2 + " do not match");
                            AppMethodBeat.o(154644);
                            return;
                        } catch (RuntimeException e2) {
                            Log.e(XWalkCoreWrapper.TAG, "XWalkNotifyChannelListener error:" + e2.getLocalizedMessage());
                            AppMethodBeat.o(154644);
                            return;
                        }
                }
            }
        };
        try {
            Class<?> bridgeClass = getBridgeClass("XWalkViewDelegate");
            Object bridge = r2.getBridge();
            new ReflectMethod(bridgeClass, "setNotifyCallBackChannel", (Class<?>[]) new Class[]{Object.class}).invoke(bridge);
            AppMethodBeat.o(154664);
            return true;
        } catch (RuntimeException e2) {
            Log.d(TAG, e2.getLocalizedMessage());
            AppMethodBeat.o(154664);
            return false;
        }
    }

    public static Object invokeRuntimeChannel(int i2, Object[] objArr) {
        AppMethodBeat.i(154665);
        Object invokeRuntimeChannel = invokeRuntimeChannel(null, i2, objArr);
        AppMethodBeat.o(154665);
        return invokeRuntimeChannel;
    }

    private static Object invokeRuntimeChannel(ClassLoader classLoader, int i2, Object[] objArr) {
        Object obj = null;
        AppMethodBeat.i(154666);
        if (classLoader == null) {
            Log.i(TAG, "invokeRuntimeChannel class loader is null. may be gp version");
        }
        if (XWalkEnvironment.getAvailableVersion() < 255) {
            Log.d(TAG, "invokeRuntimeChannel version below SDK_SUPPORT_INVOKE_RUNTIME_MIN_APKVERSION");
            AppMethodBeat.o(154666);
        } else {
            try {
                obj = invokeReflectMethod(classLoader, "invokeRuntimeChannel", i2, objArr);
                AppMethodBeat.o(154666);
            } catch (RuntimeException e2) {
                Log.e(TAG, "invokeRuntimeChannel error:" + e2.getLocalizedMessage());
                h.huF();
                AppMethodBeat.o(154666);
                return obj;
            } catch (ClassCircularityError e3) {
                Log.e(TAG, "invokeRuntimeChannel error:" + e3.getLocalizedMessage());
                h.huG();
                AppMethodBeat.o(154666);
                return obj;
            } catch (Exception e4) {
                Log.e(TAG, "invokeRuntimeChannel error:" + e4.getLocalizedMessage());
                h.huH();
                AppMethodBeat.o(154666);
                return obj;
            }
        }
        return obj;
    }

    public static boolean invokeNativeChannel(ClassLoader classLoader, int i2, Object[] objArr) {
        AppMethodBeat.i(154667);
        if (XWalkEnvironment.getAvailableVersion() < 153) {
            Log.d(TAG, "XWalk invokeNativeChannel runtime version not matched 153");
            AppMethodBeat.o(154667);
            return false;
        }
        try {
            invokeReflectMethod(classLoader, "invokeNativeChannel", i2, objArr);
        } catch (RuntimeException e2) {
            Log.e(TAG, "invokeNativeChannel error:" + e2.getLocalizedMessage());
            h.huF();
            AppMethodBeat.o(154667);
            return false;
        } catch (ClassCircularityError e3) {
            Log.e(TAG, "invokeRuntimeChannel error:" + e3.getLocalizedMessage());
            h.huG();
        } catch (Exception e4) {
            Log.e(TAG, "invokeRuntimeChannel error:" + e4.getLocalizedMessage());
            h.huH();
        }
        AppMethodBeat.o(154667);
        return true;
    }

    private static Object invokeReflectMethod(ClassLoader classLoader, String str, int i2, Object[] objArr) {
        AppMethodBeat.i(154668);
        if (classLoader == null) {
            Object invoke = new ReflectMethod(getInstance().getBridgeClass("XWalkViewDelegate"), str, (Class<?>[]) new Class[]{Integer.TYPE, Object[].class}).invoke(Integer.valueOf(i2), objArr);
            AppMethodBeat.o(154668);
            return invoke;
        }
        try {
            Class<?> loadClass = classLoader.loadClass("org.xwalk.core.internal.XWalkViewDelegate");
            Object invoke2 = new ReflectMethod(loadClass, str, (Class<?>[]) new Class[]{Integer.TYPE, Object[].class}).invoke(Integer.valueOf(i2), objArr);
            AppMethodBeat.o(154668);
            return invoke2;
        } catch (ClassNotFoundException e2) {
            Log.e(TAG, "invokeRuntimeChannel with classloader error:" + e2.getMessage());
            AppMethodBeat.o(154668);
            return null;
        }
    }

    public boolean hasFeature(int i2) {
        AppMethodBeat.i(154669);
        Object invokeRuntimeChannel = invokeRuntimeChannel(80003, new Object[]{Integer.valueOf(i2)});
        if (invokeRuntimeChannel instanceof Boolean) {
            boolean booleanValue = ((Boolean) invokeRuntimeChannel).booleanValue();
            AppMethodBeat.o(154669);
            return booleanValue;
        }
        AppMethodBeat.o(154669);
        return false;
    }

    public boolean isSupportTranslateWebSite() {
        AppMethodBeat.i(154670);
        Object invokeRuntimeChannel = invokeRuntimeChannel(80011, null);
        if (invokeRuntimeChannel instanceof Boolean) {
            boolean booleanValue = ((Boolean) invokeRuntimeChannel).booleanValue();
            AppMethodBeat.o(154670);
            return booleanValue;
        }
        AppMethodBeat.o(154670);
        return false;
    }

    private static ClassLoader getStandAloneClassLoader() {
        AppMethodBeat.i(154671);
        if (getInstance() != null && getInstance().sBridgeLoader != null) {
            ClassLoader classLoader = getInstance().sBridgeLoader;
            AppMethodBeat.o(154671);
            return classLoader;
        } else if (mStandAloneClassLoader != null) {
            ClassLoader classLoader2 = mStandAloneClassLoader;
            AppMethodBeat.o(154671);
            return classLoader2;
        } else {
            try {
                mStandAloneClassLoader = i.huI();
                ClassLoader classLoader3 = mStandAloneClassLoader;
                AppMethodBeat.o(154671);
                return classLoader3;
            } catch (Exception e2) {
                Log.e(TAG, "getXWalkClassLoader error:" + e2.getMessage());
                AppMethodBeat.o(154671);
                return null;
            }
        }
    }

    public static boolean hasFeatureStatic(int i2) {
        AppMethodBeat.i(154672);
        Object invokeRuntimeChannel = invokeRuntimeChannel(getStandAloneClassLoader(), 80003, new Object[]{Integer.valueOf(i2)});
        if (invokeRuntimeChannel instanceof Boolean) {
            boolean booleanValue = ((Boolean) invokeRuntimeChannel).booleanValue();
            AppMethodBeat.o(154672);
            return booleanValue;
        }
        AppMethodBeat.o(154672);
        return false;
    }

    private boolean checkCoreArchitecture() {
        boolean z;
        AppMethodBeat.i(154673);
        try {
            ReflectMethod reflectMethod = new ReflectMethod(getBridgeClass("XWalkViewDelegate"), "loadXWalkLibrary", (Class<?>[]) new Class[]{Context.class, String.class});
            String str = null;
            if (this.mBridgeContext != null) {
                if (Build.VERSION.SDK_INT < 17) {
                    str = "/data/data/" + this.mBridgeContext.getPackageName() + "/lib";
                }
                z = ((Boolean) reflectMethod.invoke(this.mBridgeContext, str)).booleanValue();
            } else if (this.mWrapperContext != null) {
                z = ((Boolean) reflectMethod.invoke(this.mWrapperContext, XWalkEnvironment.getExtractedCoreDir(this.mApkVersion))).booleanValue();
            } else {
                z = false;
            }
            if (!z) {
                h.OQ(191);
                Log.e(TAG, "Mismatch of CPU architecture current device abi is " + XWalkEnvironment.getRuntimeAbi() + ", runtime abi is " + XWalkEnvironment.getRuntimeAbi() + ", core detail is " + XWalkEnvironment.getAvailableVersionDetail());
                this.mCoreStatus = 6;
                AppMethodBeat.o(154673);
                return false;
            }
            Log.i(TAG, "XWalk core architecture matched");
            AppMethodBeat.o(154673);
            return true;
        } catch (RuntimeException e2) {
            Log.e(TAG, e2.getLocalizedMessage());
            Log.e(TAG, "current device abi is " + XWalkEnvironment.getRuntimeAbi() + ", runtime abi is " + XWalkEnvironment.getRuntimeAbi() + ", core detail is " + XWalkEnvironment.getAvailableVersionDetail());
            h.OQ(192);
            if (e2.getCause() instanceof UnsatisfiedLinkError) {
                this.mCoreStatus = 6;
                String message = e2.getMessage();
                Log.e(TAG, "UnsatisfiedLinkError : ".concat(String.valueOf(message)));
                if (!TextUtils.isEmpty(message)) {
                    if (message.contains("is 64-bit instead of 32-bit")) {
                        h.OQ(193);
                        if (!ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(a.brJ("dis_abandon_when_32runtime_use_64so"))) {
                            XWalkEnvironment.setAvailableVersion(-1, "", XWalkEnvironment.getRuntimeAbi());
                            Scheduler.hvE();
                        }
                    } else if (message.contains("is 32-bit instead of 64-bit")) {
                        h.OQ(194);
                        if (!ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(a.brJ("dis_abandon_when_64runtime_use_32so"))) {
                            XWalkEnvironment.setAvailableVersion(-1, "", XWalkEnvironment.getRuntimeAbi());
                            Scheduler.hvE();
                        }
                    } else {
                        h.OQ(195);
                    }
                }
            } else {
                this.mCoreStatus = 5;
                AppMethodBeat.o(154673);
                return false;
            }
        } catch (Throwable th) {
            Log.e(TAG, "clear version failed , errmsg:" + th.getMessage());
        }
        AppMethodBeat.o(154673);
        return false;
    }

    private boolean checkCorePackage(String str) {
        AppMethodBeat.i(154674);
        try {
            this.mBridgeContext = this.mWrapperContext.createPackageContext(str, 3);
            Log.d(TAG, "Created package context for ".concat(String.valueOf(str)));
            AppMethodBeat.o(154674);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.d(TAG, str + " not found");
            AppMethodBeat.o(154674);
            return false;
        }
    }

    private boolean checkCoreApk() {
        AppMethodBeat.i(154675);
        if (!new File(XWalkEnvironment.getDownloadApkPath(this.mApkVersion)).exists()) {
            Log.e(TAG, "checkCoreApk apk not exists");
            this.mCoreStatus = 9;
            AppMethodBeat.o(154675);
            return false;
        }
        Log.i(TAG, "XWalk checkCoreApk matched");
        AppMethodBeat.o(154675);
        return true;
    }

    private boolean verifyPackageInfo(PackageInfo packageInfo, String str, String str2) {
        AppMethodBeat.i(154676);
        if (packageInfo.signatures == null) {
            Log.e(TAG, "No signature in package info");
            AppMethodBeat.o(154676);
            return false;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            byte[] hexStringToByteArray = hexStringToByteArray(str2);
            if (hexStringToByteArray == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid hash code");
                AppMethodBeat.o(154676);
                throw illegalArgumentException;
            }
            for (int i2 = 0; i2 < packageInfo.signatures.length; i2++) {
                Log.d(TAG, "Checking signature ".concat(String.valueOf(i2)));
                if (!MessageDigest.isEqual(instance.digest(packageInfo.signatures[i2].toByteArray()), hexStringToByteArray)) {
                    Log.e(TAG, "Hash code does not match");
                } else {
                    Log.d(TAG, "Signature passed verification");
                    AppMethodBeat.o(154676);
                    return true;
                }
            }
            AppMethodBeat.o(154676);
            return false;
        } catch (NullPointerException | NoSuchAlgorithmException e2) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Invalid hash algorithm");
            AppMethodBeat.o(154676);
            throw illegalArgumentException2;
        }
    }

    private byte[] hexStringToByteArray(String str) {
        AppMethodBeat.i(154677);
        if (str == null || str.isEmpty() || str.length() % 2 != 0) {
            AppMethodBeat.o(154677);
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i2 = 0; i2 < str.length(); i2 += 2) {
            bArr[i2 / 2] = (byte) ((Character.digit(str.charAt(i2), 16) << 4) + Character.digit(str.charAt(i2 + 1), 16));
        }
        AppMethodBeat.o(154677);
        return bArr;
    }

    public boolean isSharedMode() {
        return this.mBridgeContext != null;
    }

    public Object getBridgeObject(Object obj) {
        AppMethodBeat.i(154678);
        try {
            Object invoke = new ReflectMethod(obj, "getBridge", new Class[0]).invoke(new Object[0]);
            AppMethodBeat.o(154678);
            return invoke;
        } catch (RuntimeException e2) {
            AppMethodBeat.o(154678);
            return null;
        }
    }

    public Object getWrapperObject(Object obj) {
        AppMethodBeat.i(154679);
        try {
            Object invoke = new ReflectMethod(obj, "getWrapper", new Class[0]).invoke(new Object[0]);
            AppMethodBeat.o(154679);
            return invoke;
        } catch (RuntimeException e2) {
            AppMethodBeat.o(154679);
            return null;
        }
    }

    public Class<?> getBridgeClass(String str) {
        AppMethodBeat.i(154680);
        try {
            Class<?> loadClass = this.mBridgeLoader.loadClass("org.xwalk.core.internal.".concat(String.valueOf(str)));
            AppMethodBeat.o(154680);
            return loadClass;
        } catch (ClassNotFoundException e2) {
            AppMethodBeat.o(154680);
            return null;
        }
    }

    public Class<?> getClass(String str) {
        AppMethodBeat.i(154681);
        try {
            Class<?> loadClass = this.mBridgeLoader.loadClass(str);
            AppMethodBeat.o(154681);
            return loadClass;
        } catch (ClassNotFoundException e2) {
            AppMethodBeat.o(154681);
            return null;
        }
    }

    public static void bindNativeTrans(long j2) {
        AppMethodBeat.i(161640);
        invokeNativeChannel(null, 30003, new String[]{String.valueOf(j2)});
        AppMethodBeat.o(161640);
    }
}
