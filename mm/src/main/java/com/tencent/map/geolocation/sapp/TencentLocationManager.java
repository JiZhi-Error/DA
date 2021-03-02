package com.tencent.map.geolocation.sapp;

import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import c.t.m.sapp.c.e;
import c.t.m.sapp.c.f;
import c.t.m.sapp.c.j;
import c.t.m.sapp.c.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.DexClassLoader;
import java.lang.reflect.Method;

public final class TencentLocationManager {
    public static final int COORDINATE_TYPE_GCJ02 = 1;
    public static final int COORDINATE_TYPE_WGS84 = 0;
    public static final boolean DEBUG = false;
    public static final String TAG = "TencentLocationManager";
    public static final String TYPE_OAID = "oaId";
    public static final String TYPE_QIMEI = "qImei";
    public static Context mContext;
    public static Pair<String, String> mPair;
    public static Class mProxyClass;
    public static Object mProxyObj;
    public static TencentLocationManager sInstance;
    public int mInitStatus = 0;
    public final byte[] mLock = new byte[0];

    public TencentLocationManager(Context context, Pair<String, String> pair) {
        boolean a2;
        Pair<String, String> pair2;
        AppMethodBeat.i(223065);
        if (TencentLocationManagerOptions.isLoadLibraryEnabled()) {
            try {
                System.loadLibrary("tencentlocsapp");
            } catch (Throwable th) {
                j.a("libtencentloc", th);
                this.mInitStatus = 3;
                AppMethodBeat.o(223065);
                return;
            }
        }
        mContext = context;
        e.a(context).c();
        for (int i2 = 0; i2 < 3; i2++) {
            if (pair != null || (pair2 = mPair) == null) {
                a2 = a(context, pair, i2);
            } else {
                a2 = a(context, pair2, i2);
            }
            if (a2) {
                break;
            }
        }
        AppMethodBeat.o(223065);
    }

    private boolean a(Context context, Pair<String, String> pair, int i2) {
        AppMethodBeat.i(223066);
        if (i2 > 0) {
            q.a(q.d(context));
            q.a(q.i(context));
            q.a();
            f.a(context).c();
        }
        try {
            DexClassLoader a2 = f.a(context).a();
            if (a2 == null) {
                j.a("class loader is null," + i2);
                e.b().a("LMI", "41");
                this.mInitStatus = 4;
                AppMethodBeat.o(223066);
                return false;
            }
            mProxyClass = a2.loadClass("com.tencent.map.geolocation.sapp.proxy.TencentLocationManagerProxy");
            if (pair != null) {
                mProxyObj = mProxyClass.getConstructor(Context.class, Pair.class).newInstance(context, pair);
            } else {
                mProxyObj = mProxyClass.getConstructor(Context.class).newInstance(context);
            }
            if (mProxyObj == null) {
                this.mInitStatus = 4;
                j.a("Mgr init failed," + i2);
                e.b().a("LMI", "42," + i2);
                AppMethodBeat.o(223066);
                return false;
            }
            e.b().a("LMI", "0," + i2);
            AppMethodBeat.o(223066);
            return true;
        } catch (Throwable th) {
            this.mInitStatus = 5;
            j.a("initLocManager", th);
            e.b().a("LMI", "5" + th.toString());
            AppMethodBeat.o(223066);
            return false;
        }
    }

    public static synchronized TencentLocationManager getInstance(Context context) {
        TencentLocationManager tencentLocationManager;
        synchronized (TencentLocationManager.class) {
            AppMethodBeat.i(223067);
            if (sInstance == null) {
                if (context == null) {
                    NullPointerException nullPointerException = new NullPointerException("context is null");
                    AppMethodBeat.o(223067);
                    throw nullPointerException;
                } else if (context.getApplicationContext() != null) {
                    System.currentTimeMillis();
                    sInstance = new TencentLocationManager(context.getApplicationContext(), null);
                } else {
                    NullPointerException nullPointerException2 = new NullPointerException("application context is null");
                    AppMethodBeat.o(223067);
                    throw nullPointerException2;
                }
            }
            tencentLocationManager = sInstance;
            AppMethodBeat.o(223067);
        }
        return tencentLocationManager;
    }

    public static boolean isOtherIdIllegal(String str) {
        AppMethodBeat.i(223070);
        boolean matches = str.matches("^[a-z0-9A-Z]{6,32}$");
        AppMethodBeat.o(223070);
        return matches;
    }

    public static void setDeviceID(Pair<String, String> pair) {
        AppMethodBeat.i(223069);
        if (pair == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("deviceID is null!");
            AppMethodBeat.o(223069);
            throw illegalArgumentException;
        } else if (((String) pair.first).equals(TYPE_QIMEI) || ((String) pair.first).equals(TYPE_OAID) || isOtherIdIllegal((String) pair.first)) {
            try {
                if (mContext != null) {
                    if (mProxyClass != null) {
                        try {
                            Method declaredMethod = mProxyClass.getDeclaredMethod("uploadLimeiInfo", Context.class, Pair.class);
                            declaredMethod.setAccessible(true);
                            if (mProxyObj != null) {
                                declaredMethod.invoke(mProxyObj, mContext, pair);
                                AppMethodBeat.o(223069);
                                return;
                            }
                        } catch (Exception e2) {
                            AppMethodBeat.o(223069);
                            return;
                        }
                    }
                    AppMethodBeat.o(223069);
                    return;
                }
                mPair = pair;
                AppMethodBeat.o(223069);
            } catch (Throwable th) {
            }
        } else {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("your deviceID is illegal!");
            AppMethodBeat.o(223069);
            throw illegalArgumentException2;
        }
    }

    public final String getBuild() {
        AppMethodBeat.i(223081);
        try {
            String str = (String) mProxyClass.getDeclaredMethod("getBuild", new Class[0]).invoke(mProxyObj, new Object[0]);
            AppMethodBeat.o(223081);
            return str;
        } catch (Throwable th) {
            AppMethodBeat.o(223081);
            return "error";
        }
    }

    public final int getCoordinateType() {
        AppMethodBeat.i(223072);
        try {
            int intValue = ((Integer) mProxyClass.getDeclaredMethod("getCoordinateType", new Class[0]).invoke(mProxyObj, new Object[0])).intValue();
            AppMethodBeat.o(223072);
            return intValue;
        } catch (Throwable th) {
            AppMethodBeat.o(223072);
            return -1;
        }
    }

    public final TencentLocation getLastKnownLocation() {
        AppMethodBeat.i(223079);
        try {
            TencentLocation tencentLocation = (TencentLocation) mProxyClass.getDeclaredMethod("getLastKnownLocation", new Class[0]).invoke(mProxyObj, new Object[0]);
            AppMethodBeat.o(223079);
            return tencentLocation;
        } catch (Throwable th) {
            AppMethodBeat.o(223079);
            return null;
        }
    }

    public final String getVersion() {
        AppMethodBeat.i(223082);
        try {
            String str = (String) mProxyClass.getDeclaredMethod("getVersion", new Class[0]).invoke(mProxyObj, new Object[0]);
            AppMethodBeat.o(223082);
            return str;
        } catch (Throwable th) {
            AppMethodBeat.o(223082);
            return "error";
        }
    }

    public final void removeUpdates(TencentLocationListener tencentLocationListener) {
        AppMethodBeat.i(223080);
        synchronized (this.mLock) {
            try {
                mProxyClass.getDeclaredMethod("removeUpdates", TencentLocationListener.class).invoke(mProxyObj, tencentLocationListener);
                e.b().d();
            } catch (Throwable th) {
            }
            try {
            } catch (Throwable th2) {
                AppMethodBeat.o(223080);
                throw th2;
            }
        }
        AppMethodBeat.o(223080);
    }

    public final int requestLocationUpdates(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener) {
        AppMethodBeat.i(223073);
        int i2 = this.mInitStatus;
        if (i2 > 0) {
            AppMethodBeat.o(223073);
            return i2;
        }
        try {
            int intValue = ((Integer) mProxyClass.getDeclaredMethod("requestLocationUpdates", TencentLocationRequest.class, TencentLocationListener.class).invoke(mProxyObj, tencentLocationRequest, tencentLocationListener)).intValue();
            AppMethodBeat.o(223073);
            return intValue;
        } catch (Throwable th) {
            j.a("reqLocUpdates error. ", th);
            AppMethodBeat.o(223073);
            return 5;
        }
    }

    public final int requestSingleFreshLocation(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper, boolean z) {
        AppMethodBeat.i(223075);
        if (tencentLocationListener == null) {
            NullPointerException nullPointerException = new NullPointerException("listener is null");
            AppMethodBeat.o(223075);
            throw nullPointerException;
        } else if (looper != null) {
            int i2 = this.mInitStatus;
            if (i2 > 0) {
                AppMethodBeat.o(223075);
            } else {
                synchronized (this.mLock) {
                    try {
                        Class cls = mProxyClass;
                        i2 = ((Integer) cls.getDeclaredMethod("requestSingleFreshLocation", TencentLocationRequest.class, TencentLocationListener.class, Looper.class, Boolean.TYPE).invoke(mProxyObj, tencentLocationRequest, tencentLocationListener, looper, Boolean.valueOf(z))).intValue();
                        try {
                        } catch (Throwable th) {
                            AppMethodBeat.o(223075);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        j.a("reqSigLoc error. ", th2);
                        i2 = 5;
                        AppMethodBeat.o(223075);
                    }
                }
                AppMethodBeat.o(223075);
            }
            return i2;
        } else {
            NullPointerException nullPointerException2 = new NullPointerException("looper is null");
            AppMethodBeat.o(223075);
            throw nullPointerException2;
        }
    }

    /* JADX INFO: finally extract failed */
    public final void setCoordinateType(int i2) {
        AppMethodBeat.i(223071);
        if (i2 == 1 || i2 == 0) {
            synchronized (this.mLock) {
                try {
                    Class cls = mProxyClass;
                    cls.getDeclaredMethod("setCoordinateType", Integer.TYPE).invoke(mProxyObj, Integer.valueOf(i2));
                } catch (Throwable th) {
                }
                try {
                } catch (Throwable th2) {
                    AppMethodBeat.o(223071);
                    throw th2;
                }
            }
            AppMethodBeat.o(223071);
            return;
        }
        try {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("unknown coordinate type: " + i2);
            AppMethodBeat.o(223071);
            throw illegalArgumentException;
        } catch (Exception e2) {
            AppMethodBeat.o(223071);
        }
    }

    public final boolean startIndoorLocation() {
        AppMethodBeat.i(223077);
        try {
            boolean booleanValue = ((Boolean) mProxyClass.getDeclaredMethod("startIndoorLocation", new Class[0]).invoke(mProxyObj, new Object[0])).booleanValue();
            AppMethodBeat.o(223077);
            return booleanValue;
        } catch (Throwable th) {
            AppMethodBeat.o(223077);
            return false;
        }
    }

    public final boolean stopIndoorLocation() {
        AppMethodBeat.i(223078);
        try {
            boolean booleanValue = ((Boolean) mProxyClass.getDeclaredMethod("stopIndoorLocation", new Class[0]).invoke(mProxyObj, new Object[0])).booleanValue();
            AppMethodBeat.o(223078);
            return booleanValue;
        } catch (Throwable th) {
            AppMethodBeat.o(223078);
            return false;
        }
    }

    public final int requestLocationUpdates(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper) {
        AppMethodBeat.i(223074);
        System.currentTimeMillis();
        if (tencentLocationRequest == null) {
            NullPointerException nullPointerException = new NullPointerException("request is null");
            AppMethodBeat.o(223074);
            throw nullPointerException;
        } else if (tencentLocationListener == null) {
            NullPointerException nullPointerException2 = new NullPointerException("listener is null");
            AppMethodBeat.o(223074);
            throw nullPointerException2;
        } else if (looper != null) {
            int i2 = this.mInitStatus;
            if (i2 > 0) {
                AppMethodBeat.o(223074);
            } else {
                synchronized (this.mLock) {
                    try {
                        Integer num = (Integer) mProxyClass.getDeclaredMethod("requestLocationUpdates", TencentLocationRequest.class, TencentLocationListener.class, Looper.class).invoke(mProxyObj, tencentLocationRequest, tencentLocationListener, looper);
                        e.b().a("RLU", num.toString());
                        i2 = num.intValue();
                        try {
                        } catch (Throwable th) {
                            AppMethodBeat.o(223074);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        e.b().a("RLU", "5," + th2.toString());
                        j.a("reqLocUpdates looper error. ", th2);
                        i2 = 5;
                        AppMethodBeat.o(223074);
                    }
                }
                AppMethodBeat.o(223074);
            }
            return i2;
        } else {
            NullPointerException nullPointerException3 = new NullPointerException("looper is null");
            AppMethodBeat.o(223074);
            throw nullPointerException3;
        }
    }

    public static synchronized TencentLocationManager getInstance(Context context, Pair<String, String> pair) {
        TencentLocationManager tencentLocationManager;
        synchronized (TencentLocationManager.class) {
            AppMethodBeat.i(223068);
            if (sInstance == null) {
                if (context == null) {
                    NullPointerException nullPointerException = new NullPointerException("context is null");
                    AppMethodBeat.o(223068);
                    throw nullPointerException;
                } else if (context.getApplicationContext() != null) {
                    System.currentTimeMillis();
                    sInstance = new TencentLocationManager(context.getApplicationContext(), pair);
                } else {
                    NullPointerException nullPointerException2 = new NullPointerException("application context is null");
                    AppMethodBeat.o(223068);
                    throw nullPointerException2;
                }
            }
            tencentLocationManager = sInstance;
            AppMethodBeat.o(223068);
        }
        return tencentLocationManager;
    }

    public final int requestSingleFreshLocation(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper) {
        AppMethodBeat.i(223076);
        int requestSingleFreshLocation = requestSingleFreshLocation(tencentLocationRequest, tencentLocationListener, looper, false);
        AppMethodBeat.o(223076);
        return requestSingleFreshLocation;
    }
}
