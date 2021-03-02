package com.tencent.tbs.one;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.tbs.one.impl.c;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public abstract class TBSOneManager {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f2318a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static TBSOneManager f2319b;

    /* renamed from: c  reason: collision with root package name */
    private static final Object f2320c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static Map<String, TBSOneManager> f2321d;

    public enum Policy {
        AUTO,
        BUILTIN_ONLY,
        BUILTIN_FIRST,
        LOCAL_ONLY,
        LOCAL_FIRST,
        ONLINE;

        static {
            AppMethodBeat.i(53735);
            AppMethodBeat.o(53735);
        }

        public static Policy valueOf(String str) {
            AppMethodBeat.i(53734);
            Policy policy = (Policy) Enum.valueOf(Policy.class, str);
            AppMethodBeat.o(53734);
            return policy;
        }
    }

    public static synchronized TBSOneManager getDefaultInstance(Context context) {
        TBSOneManager tBSOneManager;
        synchronized (TBSOneManager.class) {
            synchronized (f2318a) {
                if (f2319b == null) {
                    f2319b = new c(context, BuildConfig.KINDA_DEFAULT);
                }
                tBSOneManager = f2319b;
            }
        }
        return tBSOneManager;
    }

    public static TBSOneManager getInstance(Context context, String str) {
        TBSOneManager tBSOneManager;
        if (str.equals(BuildConfig.KINDA_DEFAULT)) {
            return getDefaultInstance(context);
        }
        synchronized (f2320c) {
            if (f2321d == null) {
                f2321d = new HashMap();
            }
            tBSOneManager = f2321d.get(str);
            if (tBSOneManager == null) {
                tBSOneManager = new c(context, str);
                f2321d.put(str, tBSOneManager);
            }
        }
        return tBSOneManager;
    }

    public abstract void configure(String str, Object obj);

    public abstract TBSOneDebugger getDebugger();

    public abstract int[] getInstalledVersionCodesOfComponent(String str);

    public abstract TBSOneComponent getLoadedComponent(String str);

    public abstract TBSOneOnlineService getOnlineService();

    public abstract void installComponent(String str, Bundle bundle, TBSOneCallback<File> tBSOneCallback);

    public abstract void installComponent(String str, TBSOneCallback<File> tBSOneCallback);

    public abstract boolean isComponentInstalled(String str);

    public abstract void loadComponentAsync(String str, Bundle bundle, TBSOneCallback<TBSOneComponent> tBSOneCallback);

    public abstract void loadComponentAsync(String str, TBSOneCallback<TBSOneComponent> tBSOneCallback);

    public abstract TBSOneComponent loadComponentSync(String str);

    public abstract TBSOneComponent loadComponentSync(String str, Bundle bundle);

    public abstract void setAutoUpdateEnabled(boolean z);

    public abstract void setDelegate(TBSOneDelegate tBSOneDelegate);

    public abstract void setPolicy(Policy policy);
}
