package com.tencent.mars;

import android.content.Context;
import com.tencent.mars.comm.PlatformComm;
import com.tencent.mm.app.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import java.util.ArrayList;
import java.util.Arrays;

public class Mars {
    private static final int CertVersion_Mainland = 1;
    private static final int CertVersion_WeChatUS = 2;
    private static final o.a appForegroundListener = new o.a() {
        /* class com.tencent.mars.Mars.AnonymousClass1 */

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            Mars.onForeground(true);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            Mars.onForeground(false);
        }
    };
    private static volatile boolean hasInitialized = false;
    public static final String libMarsBase = "wechatbase";
    public static final String libMarsHttp = "wechathttp";
    public static final String libMarsMM = "wechatmm";
    public static final String libMarsNetwork = "wechatnetwork";
    private static ArrayList<String[]> libModules = new ArrayList<>();

    public static void loadDefaultMarsLibrary() {
        try {
            System.loadLibrary("c++_shared");
        } catch (Throwable th) {
        }
    }

    public static synchronized void checkLoadedModules(ArrayList<String> arrayList, String str) {
        synchronized (Mars.class) {
            if (arrayList != null) {
                String[] strArr = new String[0];
                Log.i(str, "loaded modules: " + Arrays.toString(arrayList.toArray(strArr)));
                Arrays.sort(strArr);
                libModules.add(strArr);
                int i2 = 0;
                boolean z = true;
                while (i2 < libModules.size()) {
                    boolean z2 = !Arrays.equals(libModules.get(i2), libModules.get(0)) ? false : z;
                    i2++;
                    z = z2;
                }
                if (!z) {
                    for (int i3 = 0; i3 < libModules.size(); i3++) {
                        for (int i4 = i3 + 1; i4 < libModules.size(); i4++) {
                            z = !hasInterSection(libModules.get(i3), libModules.get(i4));
                            if (!z) {
                                break;
                            }
                        }
                        if (!z) {
                            break;
                        }
                    }
                }
                if (!z) {
                    throw new IllegalStateException("mars lib module custom made error, pls check your *.so.");
                }
            }
        }
    }

    public static void init(Context context, MMHandler mMHandler) {
        PlatformComm.init(context, mMHandler);
        hasInitialized = true;
    }

    public static void onCreate(boolean z) {
        if (z && hasInitialized) {
            onCreate();
        } else if (!z) {
            onCreate();
        } else {
            throw new IllegalStateException("function MarsCore.init must be executed before Mars.onCreate when application firststartup.");
        }
        appForegroundListener.alive();
    }

    public static void onDestroy() {
        onDestroyImpl();
        appForegroundListener.dead();
    }

    private static boolean hasInterSection(String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(str);
        }
        for (String str2 : strArr2) {
            if (arrayList.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public static void onCreate() {
        initCert();
        BaseEvent.onCreate();
    }

    public static int currentCertVer() {
        switch (WeChatBrands.AppInfo.current().getDefaultXAgreementId()) {
            case 0:
            case 1:
            case 2:
            default:
                return 1;
            case 3:
                return 2;
        }
    }

    private static void initCert() {
        onInit(currentCertVer());
    }

    private static void onInit(int i2) {
        Log.i("MicroMsg.Mars", "packerEncoderVersion %s", Integer.valueOf(i2));
        BaseEvent.onInitConfigBeforeOnCreate(i2);
    }

    private static void onDestroyImpl() {
        BaseEvent.onDestroy();
    }

    public static void onNetworkChange() {
        BaseEvent.onNetworkChange();
    }

    public static void onForeground(boolean z) {
        BaseEvent.onForeground(z);
    }

    public static void onSingalCrash(int i2) {
        BaseEvent.onSingalCrash(i2);
    }

    public static void onExceptionCrash() {
        BaseEvent.onExceptionCrash();
    }
}
