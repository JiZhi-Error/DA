package com.tencent.map.geolocation.sapp.internal;

import android.content.Context;
import android.location.Location;
import c.t.m.sapp.c.e;
import c.t.m.sapp.c.f;
import c.t.m.sapp.c.j;
import c.t.m.sapp.c.q;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.map.geolocation.sapp.TencentLocationManagerOptions;
import com.tencent.map.geolocation.sapp.TencentLocationRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.DexClassLoader;
import java.io.File;

public class TencentExtraKeys {
    public static final boolean ALLOW_NLP_LOCATION = true;
    public static final boolean DIDI_INTERNAL = false;
    public static final String LOCATION_KEY_ADMIN_LEVEL1 = "admin_level_1";
    public static final String LOCATION_KEY_ADMIN_LEVEL2 = "admin_level_2";
    public static final String LOCATION_KEY_ADMIN_LEVEL3 = "admin_level_3";
    public static final String LOCATION_KEY_LOCALITY = "locality";
    public static final String LOCATION_KEY_NATION = "nation";
    public static final String LOCATION_KEY_ROUTE = "route";
    public static final String LOCATION_KEY_SUBLOCALITY = "sublocality";
    public static final String LOCATION_SOURCE_CELL = "cell";
    public static final String LOCATION_SOURCE_GPS = "gps";
    public static final String LOCATION_SOURCE_WIFI = "wifi";
    public static final String RAW_DATA = "raw_data";
    public static final String REQUEST_RAW_DATA = "request_raw_data";
    public static final boolean STRICT_CELL_FILTER = true;
    public static final String TAG = "TencentExtraKeys";
    public static final boolean TENCENT_INTERNAL = true;
    public static Context mContext;
    public static DexClassLoader mLoader;
    public static Object mProxyObj;
    public static Class mProxyclass;

    public static boolean a(Context context, int i2) {
        AppMethodBeat.i(223103);
        if (i2 > 0) {
            try {
                q.a(q.d(context));
                q.a(q.i(context));
                q.a();
                f.a(context).c();
            } catch (Throwable th) {
                e.b().a("EKS", "init error 3," + i2 + "," + th.toString());
                AppMethodBeat.o(223103);
                return false;
            }
        }
        DexClassLoader a2 = f.a(context).a();
        if (a2 == null) {
            j.a("EKS,loader is null");
            e.b().a("EKS", "init error 2," + i2);
            AppMethodBeat.o(223103);
            return false;
        }
        if (mProxyclass == null || mProxyObj == null) {
            Class loadClass = a2.loadClass("com.tencent.map.geolocation.sapp.proxy.TencentExtraKeysProxy");
            mProxyclass = loadClass;
            mProxyObj = loadClass.newInstance();
        }
        e.b().a("EKS", "init ok 0," + i2);
        AppMethodBeat.o(223103);
        return true;
    }

    public static void enableMockLocationFilter(boolean z) {
        AppMethodBeat.i(223104);
        try {
            if (initProxy()) {
                Class cls = mProxyclass;
                cls.getDeclaredMethod("enableMockLocationFilter", Boolean.TYPE).invoke(mProxyObj, Boolean.valueOf(z));
                AppMethodBeat.o(223104);
                return;
            }
            Exception exc = new Exception("proxy is error");
            AppMethodBeat.o(223104);
            throw exc;
        } catch (Throwable th) {
            Exception exc2 = new Exception(th.toString());
            AppMethodBeat.o(223104);
            throw exc2;
        }
    }

    public static String getLocationSource(TencentLocation tencentLocation) {
        AppMethodBeat.i(223115);
        try {
            if (initProxy()) {
                String str = (String) mProxyclass.getDeclaredMethod("getLocationSource", TencentLocation.class).invoke(mProxyObj, tencentLocation);
                AppMethodBeat.o(223115);
                return str;
            }
            Exception exc = new Exception("proxy is error");
            AppMethodBeat.o(223115);
            throw exc;
        } catch (Throwable th) {
            Exception exc2 = new Exception(th.toString());
            AppMethodBeat.o(223115);
            throw exc2;
        }
    }

    public static synchronized File getLogDir() {
        File file;
        synchronized (TencentExtraKeys.class) {
            AppMethodBeat.i(223121);
            try {
                if (initProxy()) {
                    file = (File) mProxyclass.getDeclaredMethod("getLogDir", new Class[0]).invoke(mProxyObj, new Object[0]);
                    AppMethodBeat.o(223121);
                } else {
                    Exception exc = new Exception("proxy is error");
                    AppMethodBeat.o(223121);
                    throw exc;
                }
            } catch (Throwable th) {
                Exception exc2 = new Exception(th.toString());
                AppMethodBeat.o(223121);
                throw exc2;
            }
        }
        return file;
    }

    public static byte[] getRawData(TencentLocation tencentLocation) {
        AppMethodBeat.i(223105);
        try {
            if (initProxy()) {
                byte[] bArr = (byte[]) mProxyclass.getDeclaredMethod("getRawData", TencentLocation.class).invoke(mProxyObj, tencentLocation);
                AppMethodBeat.o(223105);
                return bArr;
            }
            Exception exc = new Exception("proxy is error");
            AppMethodBeat.o(223105);
            throw exc;
        } catch (Throwable th) {
            Exception exc2 = new Exception(th.toString());
            AppMethodBeat.o(223105);
            throw exc2;
        }
    }

    public static Location getRawGps(TencentLocation tencentLocation) {
        AppMethodBeat.i(223109);
        try {
            if (initProxy()) {
                Location location = (Location) mProxyclass.getDeclaredMethod("getRawGps", TencentLocation.class).invoke(mProxyObj, tencentLocation);
                AppMethodBeat.o(223109);
                return location;
            }
            Exception exc = new Exception("proxy is error");
            AppMethodBeat.o(223109);
            throw exc;
        } catch (Throwable th) {
            Exception exc2 = new Exception(th.toString());
            AppMethodBeat.o(223109);
            throw exc2;
        }
    }

    public static String getRawQuery(TencentLocation tencentLocation) {
        AppMethodBeat.i(223107);
        try {
            if (initProxy()) {
                String str = (String) mProxyclass.getDeclaredMethod("getRawQuery", TencentLocation.class).invoke(mProxyObj, tencentLocation);
                AppMethodBeat.o(223107);
                return str;
            }
            Exception exc = new Exception("proxy is error");
            AppMethodBeat.o(223107);
            throw exc;
        } catch (Throwable th) {
            Exception exc2 = new Exception(th.toString());
            AppMethodBeat.o(223107);
            throw exc2;
        }
    }

    public static boolean initProxy() {
        AppMethodBeat.i(223102);
        if (mContext == null) {
            AppMethodBeat.o(223102);
            return false;
        }
        for (int i2 = 0; i2 < 3; i2++) {
            if (a(mContext, i2)) {
                AppMethodBeat.o(223102);
                return true;
            }
        }
        AppMethodBeat.o(223102);
        return false;
    }

    public static boolean isAllowedLevel(int i2) {
        AppMethodBeat.i(223113);
        try {
            if (initProxy()) {
                Class cls = mProxyclass;
                boolean booleanValue = ((Boolean) cls.getDeclaredMethod("isAllowedLevel", Integer.TYPE).invoke(mProxyObj, Integer.valueOf(i2))).booleanValue();
                AppMethodBeat.o(223113);
                return booleanValue;
            }
            Exception exc = new Exception("proxy is error");
            AppMethodBeat.o(223113);
            throw exc;
        } catch (Throwable th) {
            Exception exc2 = new Exception(th.toString());
            AppMethodBeat.o(223113);
            throw exc2;
        }
    }

    @Deprecated
    public static synchronized boolean isDebugEnabled() {
        boolean booleanValue;
        synchronized (TencentExtraKeys.class) {
            AppMethodBeat.i(223119);
            try {
                if (initProxy()) {
                    booleanValue = ((Boolean) mProxyclass.getDeclaredMethod("isDebugEnabled", new Class[0]).invoke(mProxyObj, new Object[0])).booleanValue();
                    AppMethodBeat.o(223119);
                } else {
                    Exception exc = new Exception("proxy is error");
                    AppMethodBeat.o(223119);
                    throw exc;
                }
            } catch (Throwable th) {
                Exception exc2 = new Exception(th.toString());
                AppMethodBeat.o(223119);
                throw exc2;
            }
        }
        return booleanValue;
    }

    public static int isInsIllegalApp(Context context) {
        AppMethodBeat.i(223114);
        try {
            mContext = context;
            if (initProxy()) {
                int intValue = ((Integer) mProxyclass.getDeclaredMethod("isInsIllegalApp", Context.class).invoke(mProxyObj, context)).intValue();
                AppMethodBeat.o(223114);
                return intValue;
            }
            Exception exc = new Exception("proxy is error");
            AppMethodBeat.o(223114);
            throw exc;
        } catch (Throwable th) {
            Exception exc2 = new Exception(th.toString());
            AppMethodBeat.o(223114);
            throw exc2;
        }
    }

    public static boolean isRequestRawData(TencentLocationRequest tencentLocationRequest) {
        AppMethodBeat.i(223112);
        try {
            if (initProxy()) {
                boolean booleanValue = ((Boolean) mProxyclass.getDeclaredMethod("isRequestRawData", TencentLocationRequest.class).invoke(mProxyObj, tencentLocationRequest)).booleanValue();
                AppMethodBeat.o(223112);
                return booleanValue;
            }
            Exception exc = new Exception("proxy is error");
            AppMethodBeat.o(223112);
            throw exc;
        } catch (Throwable th) {
            Exception exc2 = new Exception(th.toString());
            AppMethodBeat.o(223112);
            throw exc2;
        }
    }

    public static void loadLibrary(String str) {
        AppMethodBeat.i(223116);
        try {
            System.load(str);
            AppMethodBeat.o(223116);
        } catch (Throwable th) {
            Exception exc = new Exception(th.toString());
            AppMethodBeat.o(223116);
            throw exc;
        }
    }

    public static void setContext(Context context) {
        AppMethodBeat.i(223101);
        mContext = context;
        e.a(context).c();
        AppMethodBeat.o(223101);
    }

    public static synchronized void setLogDir(File file) {
        synchronized (TencentExtraKeys.class) {
            AppMethodBeat.i(223120);
            try {
                if (initProxy()) {
                    mProxyclass.getDeclaredMethod("setLogDir", File.class).invoke(mProxyObj, file);
                    AppMethodBeat.o(223120);
                } else {
                    Exception exc = new Exception("proxy is error");
                    AppMethodBeat.o(223120);
                    throw exc;
                }
            } catch (Throwable th) {
                Exception exc2 = new Exception(th.toString());
                AppMethodBeat.o(223120);
                throw exc2;
            }
        }
    }

    public static TencentLocation setRawData(TencentLocation tencentLocation, byte[] bArr) {
        AppMethodBeat.i(223106);
        try {
            if (initProxy()) {
                TencentLocation tencentLocation2 = (TencentLocation) mProxyclass.getDeclaredMethod("setRawData", TencentLocation.class, byte[].class).invoke(mProxyObj, tencentLocation, bArr);
                AppMethodBeat.o(223106);
                return tencentLocation2;
            }
            Exception exc = new Exception("proxy is error");
            AppMethodBeat.o(223106);
            throw exc;
        } catch (Throwable th) {
            Exception exc2 = new Exception(th.toString());
            AppMethodBeat.o(223106);
            throw exc2;
        }
    }

    public static void setRawGps(TencentLocation tencentLocation, Location location) {
        AppMethodBeat.i(223110);
        try {
            if (initProxy()) {
                mProxyclass.getDeclaredMethod("setRawGps", TencentLocation.class, Location.class).invoke(mProxyObj, tencentLocation, location);
                AppMethodBeat.o(223110);
                return;
            }
            Exception exc = new Exception("proxy is error");
            AppMethodBeat.o(223110);
            throw exc;
        } catch (Throwable th) {
            Exception exc2 = new Exception(th.toString());
            AppMethodBeat.o(223110);
            throw exc2;
        }
    }

    public static void setRawQuery(TencentLocation tencentLocation, String str) {
        AppMethodBeat.i(223108);
        try {
            if (initProxy()) {
                mProxyclass.getDeclaredMethod("setRawQuery", TencentLocation.class, String.class).invoke(mProxyObj, tencentLocation, str);
                AppMethodBeat.o(223108);
                return;
            }
            Exception exc = new Exception("proxy is error");
            AppMethodBeat.o(223108);
            throw exc;
        } catch (Throwable th) {
            Exception exc2 = new Exception(th.toString());
            AppMethodBeat.o(223108);
            throw exc2;
        }
    }

    public static TencentLocationRequest setRequestRawData(TencentLocationRequest tencentLocationRequest, boolean z) {
        AppMethodBeat.i(223111);
        try {
            if (initProxy()) {
                Class cls = mProxyclass;
                TencentLocationRequest tencentLocationRequest2 = (TencentLocationRequest) cls.getDeclaredMethod("setRequestRawData", TencentLocationRequest.class, Boolean.TYPE).invoke(mProxyObj, tencentLocationRequest, Boolean.valueOf(z));
                AppMethodBeat.o(223111);
                return tencentLocationRequest2;
            }
            Exception exc = new Exception("proxy is error");
            AppMethodBeat.o(223111);
            throw exc;
        } catch (Throwable th) {
            Exception exc2 = new Exception(th.toString());
            AppMethodBeat.o(223111);
            throw exc2;
        }
    }

    public static void setTencentLog(Context context, File file) {
        AppMethodBeat.i(223117);
        try {
            mContext = context;
            if (initProxy()) {
                mProxyclass.getDeclaredMethod("setTencentLog", Context.class, File.class).invoke(mProxyObj, context, file);
                AppMethodBeat.o(223117);
                return;
            }
            Exception exc = new Exception("proxy is error");
            AppMethodBeat.o(223117);
            throw exc;
        } catch (Throwable th) {
            Exception exc2 = new Exception(th.toString());
            AppMethodBeat.o(223117);
            throw exc2;
        }
    }

    public static void setTencentLogCallback(LocationLogCallback locationLogCallback) {
        AppMethodBeat.i(223118);
        try {
            j.a(locationLogCallback);
            if (initProxy()) {
                mProxyclass.getDeclaredMethod("setTencentLogCallback", LocationLogCallback.class).invoke(mProxyObj, locationLogCallback);
                AppMethodBeat.o(223118);
                return;
            }
            Exception exc = new Exception("proxy is error");
            AppMethodBeat.o(223118);
            throw exc;
        } catch (Throwable th) {
            Exception exc2 = new Exception(th.toString());
            AppMethodBeat.o(223118);
            throw exc2;
        }
    }

    public static boolean wgs84ToGcj02(double[] dArr, double[] dArr2) {
        AppMethodBeat.i(223122);
        try {
            if (TencentLocationManagerOptions.isLoadLibraryEnabled()) {
                try {
                    System.loadLibrary("tencentlocsapp");
                } catch (Throwable th) {
                    new StringBuilder().append("LOAD:").append(th.toString());
                    AppMethodBeat.o(223122);
                    return false;
                }
            }
            if (initProxy()) {
                boolean booleanValue = ((Boolean) mProxyclass.getDeclaredMethod("wgs84ToGcj02", double[].class, double[].class).invoke(mProxyObj, dArr, dArr2)).booleanValue();
                AppMethodBeat.o(223122);
                return booleanValue;
            }
            Exception exc = new Exception("proxy is error");
            AppMethodBeat.o(223122);
            throw exc;
        } catch (Throwable th2) {
            Exception exc2 = new Exception(th2.toString());
            AppMethodBeat.o(223122);
            throw exc2;
        }
    }
}
