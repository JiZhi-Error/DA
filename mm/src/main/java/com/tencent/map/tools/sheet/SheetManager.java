package com.tencent.map.tools.sheet;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.Util;
import com.tencent.map.tools.internal.c;
import com.tencent.map.tools.internal.d;
import com.tencent.map.tools.internal.e;
import com.tencent.map.tools.sheet.listener.ModuleUncaughtListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.lang.Thread;

public class SheetManager implements d {
    private static final SheetManager ourInstance = new SheetManager();
    private boolean mPluginExists;
    private c mSheetAdapter;
    private d mSheetProxy;

    static {
        AppMethodBeat.i(180964);
        AppMethodBeat.o(180964);
    }

    public static SheetManager getInstance() {
        return ourInstance;
    }

    private SheetManager() {
    }

    public void initAsync(final Context context, final Options options, final Callback<Void> callback) {
        AppMethodBeat.i(180953);
        final Handler handler = new Handler(Looper.getMainLooper());
        new Thread(new Runnable() {
            /* class com.tencent.map.tools.sheet.SheetManager.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(180948);
                SheetManager.this.init(context, options);
                handler.post(new Runnable() {
                    /* class com.tencent.map.tools.sheet.SheetManager.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(180947);
                        if (callback != null) {
                            callback.callback(null);
                        }
                        AppMethodBeat.o(180947);
                    }
                });
                AppMethodBeat.o(180948);
            }
        }, "tencentmap-sheetinit").start();
        AppMethodBeat.o(180953);
    }

    public void init(Context context, Options options) {
        AppMethodBeat.i(180954);
        switch (options.mAdapterType) {
            case LOC_SHEET:
                this.mSheetAdapter = new e(context, options);
                break;
        }
        if (this.mSheetAdapter.a()) {
            this.mSheetProxy = this.mSheetAdapter.c();
            this.mPluginExists = this.mSheetProxy.getSheetLoader() != null;
        }
        AppMethodBeat.o(180954);
    }

    @Override // com.tencent.map.tools.internal.d
    public Class findSheet(String str) {
        AppMethodBeat.i(180955);
        if (this.mPluginExists) {
            Class findSheet = this.mSheetProxy.findSheet(str);
            AppMethodBeat.o(180955);
            return findSheet;
        }
        Class findClass = Util.findClass(str, getSheetLoader());
        AppMethodBeat.o(180955);
        return findClass;
    }

    @Override // com.tencent.map.tools.internal.d
    public <T> Class<? extends T> findSheet(String str, Class<T> cls) {
        AppMethodBeat.i(180956);
        if (this.mPluginExists) {
            Class<? extends T> findSheet = this.mSheetProxy.findSheet(str, cls);
            AppMethodBeat.o(180956);
            return findSheet;
        }
        Class<? extends T> findClass = Util.findClass(str, cls, getSheetLoader());
        AppMethodBeat.o(180956);
        return findClass;
    }

    @Override // com.tencent.map.tools.internal.d
    public Object newSheetIns(String str) {
        AppMethodBeat.i(180957);
        if (this.mPluginExists) {
            Object newSheetIns = this.mSheetProxy.newSheetIns(str);
            AppMethodBeat.o(180957);
            return newSheetIns;
        }
        Object newInstance = Util.newInstance(findSheet(str), new Object[0]);
        AppMethodBeat.o(180957);
        return newInstance;
    }

    @Override // com.tencent.map.tools.internal.d
    public <T> T newSheetIns(Class<T> cls, Object... objArr) {
        AppMethodBeat.i(180958);
        if (this.mPluginExists) {
            T t = (T) this.mSheetProxy.newSheetIns(cls, objArr);
            AppMethodBeat.o(180958);
            return t;
        }
        T t2 = (T) Util.newInstance(cls, objArr);
        AppMethodBeat.o(180958);
        return t2;
    }

    @Override // com.tencent.map.tools.internal.d
    public ClassLoader getSheetLoader() {
        AppMethodBeat.i(180959);
        if (this.mPluginExists) {
            ClassLoader sheetLoader = this.mSheetProxy.getSheetLoader();
            AppMethodBeat.o(180959);
            return sheetLoader;
        }
        ClassLoader classLoader = getClass().getClassLoader();
        AppMethodBeat.o(180959);
        return classLoader;
    }

    @Override // com.tencent.map.tools.internal.d
    public Object callSheetMth(Object obj, String str, Object... objArr) {
        AppMethodBeat.i(180960);
        if (this.mPluginExists) {
            Object callSheetMth = this.mSheetProxy.callSheetMth(obj, str, objArr);
            AppMethodBeat.o(180960);
            return callSheetMth;
        }
        Object invokeMethod = Util.invokeMethod(obj, str, objArr);
        AppMethodBeat.o(180960);
        return invokeMethod;
    }

    @Override // com.tencent.map.tools.internal.d
    public Object callSheetMth(Object obj, String str, Class[] clsArr, Object[] objArr) {
        AppMethodBeat.i(180961);
        if (this.mPluginExists) {
            Object callSheetMth = this.mSheetProxy.callSheetMth(obj, str, clsArr, objArr);
            AppMethodBeat.o(180961);
            return callSheetMth;
        }
        Object invokeMethod = Util.invokeMethod(obj, str, clsArr, objArr);
        AppMethodBeat.o(180961);
        return invokeMethod;
    }

    @Override // com.tencent.map.tools.internal.d
    public Object callSheetStaMth(Class cls, String str, Class[] clsArr, Object[] objArr) {
        AppMethodBeat.i(193596);
        if (this.mPluginExists) {
            Object callSheetStaMth = this.mSheetProxy.callSheetStaMth(cls, str, clsArr, objArr);
            AppMethodBeat.o(193596);
            return callSheetStaMth;
        }
        Object invokeStaticMethod = Util.invokeStaticMethod(cls, str, clsArr, objArr);
        AppMethodBeat.o(193596);
        return invokeStaticMethod;
    }

    @Override // com.tencent.map.tools.internal.d
    public int loadSheetGroups() {
        AppMethodBeat.i(180962);
        if (this.mPluginExists) {
            int loadSheetGroups = this.mSheetProxy.loadSheetGroups();
            AppMethodBeat.o(180962);
            return loadSheetGroups;
        }
        AppMethodBeat.o(180962);
        return 0;
    }

    public File getLogDir() {
        AppMethodBeat.i(180963);
        if (this.mSheetAdapter != null) {
            File b2 = this.mSheetAdapter.b();
            AppMethodBeat.o(180963);
            return b2;
        }
        AppMethodBeat.o(180963);
        return null;
    }

    public static abstract class UncaughtListener extends ModuleUncaughtListener {
        public UncaughtListener(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            super(uncaughtExceptionHandler);
        }
    }

    public static class Options {
        private AdapterType mAdapterType = AdapterType.LOC_SHEET;
        private File mCoreLogDir;
        private String mCoreLogReportUrl;
        private String mCoreLogToken;
        private boolean mIsCoreLogOn;
        private boolean mIsSheetEnable;
        private String mPluginName;
        private String mPluginUpdateUrl;
        private String mSdkFlavor;
        private String mSdkMapKey;
        private String mSdkRepo;
        private String mSdkVersion;
        private String mSdkVersionCode;
        private String mSoLibName;
        private UncaughtListener mUncaughtListener;

        public enum AdapterType {
            LOC_SHEET;

            public static AdapterType valueOf(String str) {
                AppMethodBeat.i(180951);
                AdapterType adapterType = (AdapterType) Enum.valueOf(AdapterType.class, str);
                AppMethodBeat.o(180951);
                return adapterType;
            }

            static {
                AppMethodBeat.i(180952);
                AppMethodBeat.o(180952);
            }
        }

        public UncaughtListener getUncaughtListener() {
            return this.mUncaughtListener;
        }

        public Options setUncaughtListener(UncaughtListener uncaughtListener) {
            this.mUncaughtListener = uncaughtListener;
            return this;
        }

        public AdapterType getAdapterType() {
            return this.mAdapterType;
        }

        public Options setAdapterType(AdapterType adapterType) {
            this.mAdapterType = adapterType;
            return this;
        }

        public String getPluginName() {
            return this.mPluginName;
        }

        public Options setSheetProjectName(String str) {
            this.mPluginName = str;
            return this;
        }

        public String getPluginUpdateUrl() {
            return this.mPluginUpdateUrl;
        }

        public Options setPluginUpdateUrl(String str) {
            this.mPluginUpdateUrl = str;
            return this;
        }

        public String getSdkVersion() {
            return this.mSdkVersion;
        }

        public Options setVersion(String str) {
            this.mSdkVersion = str;
            return this;
        }

        public String getSdkVersionCode() {
            return this.mSdkVersionCode;
        }

        public Options setVersionCode(String str) {
            this.mSdkVersionCode = str;
            return this;
        }

        public String getSdkRepo() {
            return this.mSdkRepo;
        }

        public Options setSdkRepo(String str) {
            this.mSdkRepo = str;
            return this;
        }

        public String getSdkFlavor() {
            return this.mSdkFlavor;
        }

        public Options setFlavor(String str) {
            this.mSdkFlavor = str;
            return this;
        }

        public String getSdkMapKey() {
            return this.mSdkMapKey;
        }

        public Options setAppKey(String str) {
            this.mSdkMapKey = str;
            return this;
        }

        public boolean isCoreLogOn() {
            return this.mIsCoreLogOn;
        }

        public Options setCoreLogOn(boolean z) {
            this.mIsCoreLogOn = z;
            return this;
        }

        public Options setSheetEnable(boolean z) {
            this.mIsSheetEnable = z;
            return this;
        }

        public boolean isSheetEnable() {
            return this.mIsSheetEnable;
        }

        public String getCoreLogReportUrl() {
            return this.mCoreLogReportUrl;
        }

        public Options setCoreLogReportUrl(String str) {
            this.mCoreLogReportUrl = str;
            return this;
        }

        public String getCoreLogToken() {
            return this.mCoreLogToken;
        }

        public Options setCoreLogToken(String str) {
            this.mCoreLogToken = str;
            return this;
        }

        public File getCoreLogDir() {
            return this.mCoreLogDir;
        }

        public void setCoreLogDir(File file) {
            this.mCoreLogDir = file;
        }

        public String getSoLibName() {
            return this.mSoLibName;
        }

        public Options setSoLibName(String str) {
            this.mSoLibName = str;
            return this;
        }
    }
}
