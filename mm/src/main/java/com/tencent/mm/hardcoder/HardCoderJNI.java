package com.tencent.mm.hardcoder;

import android.os.Process;
import android.os.SystemClock;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.a;
import com.tencent.mm.hardcoder.c;
import com.tencent.mm.loader.BuildConfig;
import java.lang.reflect.Method;
import java.util.HashMap;

public class HardCoderJNI {
    public static final int APP_SCENE_COMMUNICATE = 6;
    public static final int APP_SCENE_DATA_LOADING_AND_PROCESS = 4;
    public static final int APP_SCENE_MULTI_MEDIA_PROCESS = 5;
    public static final int APP_SCENE_STARTUP = 1;
    public static final int APP_SCENE_SYSTEM_DEVICE = 7;
    public static final int APP_SCENE_UNDEFINE = 0;
    public static final int APP_SCENE_WINDOW_SCROLL = 3;
    public static final int APP_SCENE_WINDOW_SWITCH = 2;
    public static final int CALLBACK_TYPE_BASE = 0;
    public static final int CALLBACK_TYPE_DATA = 2;
    public static final int CALLBACK_TYPE_STATUS = 1;
    public static final int CLIENT_CONNECT = -20000;
    public static final int CLIENT_DISCONNECT = -20001;
    public static final String CLIENT_SOCK = ".hardcoder.client.sock";
    public static final int CPU_LEVEL_0 = 0;
    public static final int CPU_LEVEL_1 = 1;
    public static final int CPU_LEVEL_2 = 2;
    public static final int CPU_LEVEL_3 = 3;
    public static final int ERROR_CODE_CHECKENV_FAIL = -2;
    public static final int ERROR_CODE_DISCONNECT = -6;
    public static final int ERROR_CODE_FAILED = -1;
    public static final int ERROR_CODE_HCPERFMANAGER_NULL = -5;
    public static final int ERROR_CODE_NOT_ENABLE = -3;
    public static final int ERROR_CODE_NOT_FOREGROUND = -4;
    public static final int ERROR_CODE_SUCCESS = 0;
    public static final int ERR_CLIENT_ALREADY_INIT = -20002;
    public static final int ERR_UNAUTHORIZED = -10001;
    public static final int FUNC_BASE = 1000;
    public static final int FUNC_CANCEL_CPU_CORE_FOR_THREAD = 1005;
    public static final int FUNC_CANCEL_CPU_HIGH_FREQ = 1003;
    public static final int FUNC_CANCEL_GPU_HIGH_FREQ = 1017;
    public static final int FUNC_CANCEL_HIGH_IO_FREQ = 1007;
    public static final int FUNC_CANCEL_UNIFY_CPU_IO_THREAD_CORE = 1014;
    public static final int FUNC_CHECK_PERMISSION = 1001;
    public static final int FUNC_CONFIGURE = 1018;
    public static final int FUNC_CPU_CORE_FOR_THREAD = 1004;
    public static final int FUNC_CPU_HIGH_FREQ = 1002;
    public static final int FUNC_GPU_HIGH_FREQ = 1016;
    public static final int FUNC_HIGH_IO_FREQ = 1006;
    public static final int FUNC_LOCAL = 0;
    public static final int FUNC_REG_ANR_CALLBACK = 1010;
    public static final int FUNC_REG_PRELOAD_BOOT_RESOURCE = 1011;
    public static final int FUNC_REG_SYSTEM_EVENT_CALLBACK = 1015;
    public static final int FUNC_RESET_SCREEN_RESOLUTION = 1009;
    public static final int FUNC_SET_SCREEN_RESOLUTION = 1008;
    public static final int FUNC_TERMINATE_APP = 1012;
    public static final int FUNC_UNIFY_CPU_IO_THREAD_CORE = 1013;
    public static final int GPU_LEVEL_0 = 0;
    public static final int GPU_LEVEL_1 = 1;
    public static final int IO_LEVEL_0 = 0;
    public static final int IO_LEVEL_1 = 1;
    public static final int IO_LEVEL_2 = 2;
    public static final int IO_LEVEL_3 = 3;
    public static final int RET_CPU_HIGH_FREQ = 8;
    public static final int RET_CPU_HIGH_FREQ_LEVEL_1 = 9;
    public static final int RET_CPU_HIGH_FREQ_LEVEL_2 = 10;
    public static final int RET_CPU_HIGH_FREQ_LEVEL_3 = 11;
    public static final int RET_GPU_HIGH_FREQ = 32;
    public static final int RET_HIGH_IO_FREQ = 16;
    public static final int RET_HIGH_IO_FREQ_LEVEL_1 = 17;
    public static final int RET_HIGH_IO_FREQ_LEVEL_2 = 18;
    public static final int RET_HIGH_IO_FREQ_LEVEL_3 = 19;
    public static final int RET_LEVEL_1 = 1;
    public static final int RET_LEVEL_2 = 2;
    public static final int RET_LEVEL_3 = 3;
    public static final int RET_OK = 0;
    public static final String SERVER_PROP_KEY = "persist.sys.hardcoder.name";
    private static final String TAG = "Hardcoder.HardCoderJNI";
    private static AnrCallback anrCallback;
    private static boolean checkEnv = false;
    private static boolean connect = false;
    private static c.a connectStatusCallback;
    private static HashMap<Long, c.b> funcRetCallback = new HashMap<>();
    private static boolean hcDebug = false;
    private static boolean hcEnable = true;
    private static a hcPerfManager;
    private static byte[] lock = new byte[0];
    private static HashMap<Long, c.C0350c> requestStatusCallback = new HashMap<>();
    private static Method sGetStringPropsMethod = null;
    private static volatile Class<?> sSystemPropertiesClazz = null;
    public static c.d sceneReportCallback;
    public static int tickRate = 100;

    public interface AnrCallback {
        void onANR(byte[] bArr);
    }

    public interface HCPerfManagerThread {
        Thread newThread(Runnable runnable, String str, int i2);
    }

    public static native long cancelCpuCoreForThread(int[] iArr, int i2, long j2);

    public static native long cancelCpuHighFreq(int i2, long j2);

    public static native long cancelGpuHighFreq(int i2, long j2);

    public static native long cancelHighIOFreq(int i2, long j2);

    public static native long cancelUnifyCpuIOThreadCoreGpu(boolean z, boolean z2, boolean z3, boolean z4, int[] iArr, int i2, long j2);

    public static native long checkPermission(String[] strArr, String[] strArr2, int i2, int i3, int i4, long j2);

    public static native long configure(byte[] bArr, int i2, long j2);

    public static native long getParameters(byte[] bArr, int i2, long j2);

    private static native int getTickRate();

    private static native int initHardCoder(String str, int i2, String str2);

    public static native int isRunning();

    public static native long registerANRCallback(int i2, long j2);

    public static native long registerBootPreloadResource(String[] strArr, int i2, long j2);

    public static native long registerSystemEventCallback(int i2, long j2);

    public static native long requestCpuCoreForThread(int i2, long j2, int[] iArr, int i3, int i4, long j3);

    public static native long requestCpuHighFreq(int i2, long j2, int i3, int i4, int i5, long j3);

    public static native long requestGpuHighFreq(int i2, long j2, int i3, int i4, int i5, long j3);

    public static native long requestHighIOFreq(int i2, long j2, int i3, int i4, int i5, long j3);

    public static native long requestScreenResolution(int i2, String str, int i3, long j2);

    public static native long requestUnifyCpuIOThreadCoreGpu(int i2, long j2, int i3, int i4, int i5, int[] iArr, int i6, int i7, long j3);

    public static native long resetScreenResolution(int i2, long j2);

    private static native void setDebug(boolean z);

    private static native void setHCEnable(boolean z);

    public static native void setRetryConnectInterval(int i2);

    public static native int startTraceCpuLoad(int i2, int i3);

    public static native int stopTraceCpuLoad(int i2);

    public static native long terminateApp(int i2, long j2);

    static {
        AppMethodBeat.i(62473);
        System.loadLibrary("hardcoder");
        AppMethodBeat.o(62473);
    }

    private HardCoderJNI() {
    }

    public boolean isConnect() {
        return connect;
    }

    public static void setCheckEnv(boolean z) {
        checkEnv = z;
    }

    public static boolean isCheckEnv() {
        return checkEnv;
    }

    public static boolean isHcDebug() {
        return hcDebug;
    }

    public static void setHcDebug(boolean z) {
        AppMethodBeat.i(62460);
        hcDebug = z;
        if (checkEnv) {
            setDebug(z);
        }
        AppMethodBeat.o(62460);
    }

    public static boolean isHcEnable() {
        return hcEnable;
    }

    public static void setHcEnable(boolean z) {
        AppMethodBeat.i(62461);
        hcEnable = z;
        if (checkEnv) {
            setHCEnable(z);
        }
        AppMethodBeat.o(62461);
    }

    public static int initHardCoder(String str, int i2, String str2, HCPerfManagerThread hCPerfManagerThread, c.a aVar) {
        boolean z = true;
        AppMethodBeat.i(62462);
        if (!isHcEnable()) {
            d.e(TAG, String.format("initHardCoder client not enable Hardcoder, hcEnable:%b, checkEnv:%b", Boolean.valueOf(isHcEnable()), Boolean.valueOf(isCheckEnv())));
            AppMethodBeat.o(62462);
            return -3;
        }
        if (str == null || str.equals("")) {
            z = false;
        }
        checkEnv = z;
        synchronized (lock) {
            try {
                if (hcPerfManager == null) {
                    if (hCPerfManagerThread == null) {
                        hCPerfManagerThread = new HCPerfManagerThread() {
                            /* class com.tencent.mm.hardcoder.HardCoderJNI.AnonymousClass1 */

                            @Override // com.tencent.mm.hardcoder.HardCoderJNI.HCPerfManagerThread
                            public final Thread newThread(Runnable runnable, String str, int i2) {
                                AppMethodBeat.i(62459);
                                Thread thread = new Thread(runnable, str);
                                AppMethodBeat.o(62459);
                                return thread;
                            }
                        };
                    }
                    hcPerfManager = new a(hCPerfManagerThread);
                }
            } catch (Throwable th) {
                AppMethodBeat.o(62462);
                throw th;
            }
        }
        tickRate = getTickRate();
        connectStatusCallback = aVar;
        int initHardCoder = initHardCoder(str, i2, str2);
        AppMethodBeat.o(62462);
        return initHardCoder;
    }

    public static long checkPermission(String[] strArr, String[] strArr2, c.b bVar) {
        AppMethodBeat.i(62463);
        if (!connect) {
            d.e(TAG, "startPerformance error disconnect");
            AppMethodBeat.o(62463);
            return -6;
        }
        long checkPermission = checkPermission(strArr, strArr2, Process.myPid(), Process.myUid(), Process.myTid(), SystemClock.elapsedRealtimeNanos());
        funcRetCallback.put(Long.valueOf(checkPermission), bVar);
        AppMethodBeat.o(62463);
        return checkPermission;
    }

    public static int startPerformance(int i2, int i3, int i4, int i5, int i6, int i7, long j2, int i8, String str) {
        AppMethodBeat.i(62464);
        int startPerformance = startPerformance(i2, i3, i4, 0, new int[]{i5}, i6, i7, j2, i8, str);
        AppMethodBeat.o(62464);
        return startPerformance;
    }

    public static int startPerformance(int i2, int i3, int i4, int i5, int[] iArr, int i6, int i7, long j2, int i8, String str) {
        AppMethodBeat.i(62465);
        if (hcPerfManager == null) {
            d.e(TAG, "startPerformance error HCPerfManager is null, please initHardCoder first!");
            AppMethodBeat.o(62465);
            return -5;
        } else if (!connect) {
            d.e(TAG, "startPerformance error disconnect");
            AppMethodBeat.o(62465);
            return -6;
        } else {
            int a2 = hcPerfManager.a(i2, i3, i4, i5, iArr, i6, i7, j2, i8, str);
            d.i(TAG, String.format("hcPerfManager startPerformance:%d, scene:%d", Integer.valueOf(a2), Integer.valueOf(i7)));
            AppMethodBeat.o(62465);
            return a2;
        }
    }

    public static int stopPerformance(int i2) {
        AppMethodBeat.i(62466);
        if (hcPerfManager == null) {
            d.e(TAG, "stopPerformance error HCPerfManager is null, please initHardCoder first!");
            AppMethodBeat.o(62466);
            return -5;
        } else if (!connect) {
            d.e(TAG, "stopPerformance error disconnect");
            AppMethodBeat.o(62466);
            return -6;
        } else {
            a aVar = hcPerfManager;
            a.c cVar = new a.c();
            cVar.hla = System.currentTimeMillis();
            cVar.aHK = i2;
            boolean offer = i2 != 0 ? aVar.hkY.offer(cVar) : false;
            d.d("Hardcoder.HCPerfManager", String.format("stop ret:%b, hashcode:%x", Boolean.valueOf(offer), Integer.valueOf(i2)));
            d.i(TAG, String.format("stopPerformance:%d, ret:%b", Integer.valueOf(i2), Boolean.valueOf(offer)));
            if (offer) {
                AppMethodBeat.o(62466);
                return 0;
            }
            AppMethodBeat.o(62466);
            return -1;
        }
    }

    public static void onData(int i2, long j2, long j3, int i3, int i4, int i5, byte[] bArr) {
        AppMethodBeat.i(62467);
        d.i(TAG, "onData callbackType:" + i2 + ", requestId:" + j2 + ", timestamp:" + j3 + ", retCode:" + i3 + ", funcId:" + i4 + ", dataType:" + i5);
        switch (i2) {
            case 1:
                switch (i4) {
                    case 0:
                        switch (i3) {
                            case ERR_CLIENT_ALREADY_INIT /*{ENCODED_INT: -20002}*/:
                                connect = true;
                                d.i(TAG, "onData callback, already initHardcoder!");
                                break;
                            case CLIENT_DISCONNECT /*{ENCODED_INT: -20001}*/:
                                connect = false;
                                if (connectStatusCallback != null) {
                                    connectStatusCallback.em(connect);
                                    AppMethodBeat.o(62467);
                                    return;
                                }
                                break;
                            case CLIENT_CONNECT /*{ENCODED_INT: -20000}*/:
                                connect = true;
                                if (connectStatusCallback != null) {
                                    connectStatusCallback.em(connect);
                                    AppMethodBeat.o(62467);
                                    return;
                                }
                                break;
                        }
                        AppMethodBeat.o(62467);
                        return;
                    default:
                        onRequestCallback(i2, j2, i3, i4, i5, bArr);
                        AppMethodBeat.o(62467);
                        return;
                }
            case 2:
                switch (i4) {
                    default:
                        onRequestCallback(i2, j2, i3, i4, i5, bArr);
                        AppMethodBeat.o(62467);
                        return;
                    case 1010:
                        if (anrCallback != null) {
                            anrCallback.onANR(bArr);
                            AppMethodBeat.o(62467);
                            return;
                        }
                        break;
                }
            default:
                onRequestCallback(i2, j2, i3, i4, i5, bArr);
                break;
        }
        AppMethodBeat.o(62467);
    }

    public static String readServerAddr() {
        String str;
        AppMethodBeat.i(62468);
        try {
            synchronized (lock) {
                try {
                    if (sSystemPropertiesClazz == null) {
                        Class<?> cls = Class.forName("android.os.SystemProperties");
                        sSystemPropertiesClazz = cls;
                        Method declaredMethod = cls.getDeclaredMethod("get", String.class, String.class);
                        sGetStringPropsMethod = declaredMethod;
                        declaredMethod.setAccessible(true);
                    }
                    str = (String) sGetStringPropsMethod.invoke(null, SERVER_PROP_KEY, "");
                    d.i(TAG, String.format("readServerAddr, serverprop[%s] result[%s]", SERVER_PROP_KEY, str));
                } catch (Throwable th) {
                    AppMethodBeat.o(62468);
                    throw th;
                }
            }
            AppMethodBeat.o(62468);
            return str;
        } catch (Throwable th2) {
            d.printErrStackTrace(TAG, th2, "readServerAddr", new Object[0]);
            AppMethodBeat.o(62468);
            return "";
        }
    }

    public static void putRequestStatusHashMap(long j2, c.C0350c cVar) {
        AppMethodBeat.i(62469);
        if (requestStatusCallback != null) {
            requestStatusCallback.put(Long.valueOf(j2), cVar);
        }
        AppMethodBeat.o(62469);
    }

    public static void putFuncRetHashMap(long j2, c.b bVar) {
        AppMethodBeat.i(62470);
        if (funcRetCallback != null) {
            funcRetCallback.put(Long.valueOf(j2), bVar);
        }
        AppMethodBeat.o(62470);
    }

    public static void onRequestCallback(int i2, long j2, int i3, int i4, int i5, byte[] bArr) {
        c.C0350c cVar;
        String cVar2;
        AppMethodBeat.i(62471);
        c.b bVar = null;
        if (requestStatusCallback != null) {
            cVar = requestStatusCallback.remove(Long.valueOf(j2));
        } else {
            cVar = null;
        }
        if (funcRetCallback != null) {
            c.b remove = funcRetCallback.remove(Long.valueOf(j2));
            if (remove != null) {
                remove.onFuncRet(i2, j2, i3, i4, i5, bArr);
            }
            bVar = remove;
        }
        if (!(cVar == null && bVar == null)) {
            StringBuilder append = new StringBuilder("onRequestCallback, funcId:").append(i4).append(", requestId:").append(j2).append(", retCode:").append(i3).append(", requestStatus:");
            if (cVar == null) {
                cVar2 = BuildConfig.COMMAND;
            } else {
                cVar2 = cVar.toString();
            }
            d.i(TAG, append.append(cVar2).append(", funcRetCallback:").append(bVar == null ? "false" : ServerProtocol.DIALOG_RETURN_SCOPES_TRUE).toString());
        }
        AppMethodBeat.o(62471);
    }

    public static long registerANRCallback(AnrCallback anrCallback2) {
        AppMethodBeat.i(62472);
        anrCallback = anrCallback2;
        long registerANRCallback = registerANRCallback(Process.myTid(), SystemClock.elapsedRealtime());
        AppMethodBeat.o(62472);
        return registerANRCallback;
    }

    public static void setSceneReportCallback(c.d dVar) {
        sceneReportCallback = dVar;
    }
}
