package com.tencent.liteav.basic.util;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.media.MediaFormat;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.ugc.TXRecordCommon;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.UUID;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public static long f465a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f466b = true;

    /* renamed from: c  reason: collision with root package name */
    private static String f467c = "";

    /* renamed from: d  reason: collision with root package name */
    private static int f468d = 0;

    /* renamed from: e  reason: collision with root package name */
    private static long f469e = 0;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f470f = false;

    /* renamed from: g  reason: collision with root package name */
    private static a<b> f471g = new a<>(new a.AbstractC0156a<b>() {
        /* class com.tencent.liteav.basic.util.f.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.liteav.basic.util.a.AbstractC0156a
        public final /* synthetic */ b a() {
            AppMethodBeat.i(222127);
            b b2 = b();
            AppMethodBeat.o(222127);
            return b2;
        }

        public final b b() {
            AppMethodBeat.i(222126);
            b bVar = new b();
            AppMethodBeat.o(222126);
            return bVar;
        }
    });

    /* renamed from: h  reason: collision with root package name */
    private static final Object f472h = new Object();

    /* renamed from: i  reason: collision with root package name */
    private static boolean f473i = false;

    /* renamed from: j  reason: collision with root package name */
    private static int[] f474j = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, TXRecordCommon.AUDIO_SAMPLERATE_8000, 7350};

    static {
        AppMethodBeat.i(222110);
        AppMethodBeat.o(222110);
    }

    public static int[] a() {
        AppMethodBeat.i(222089);
        if (f466b) {
            f466b = false;
            f471g.a().a();
            int[] iArr = {0, 0};
            AppMethodBeat.o(222089);
            return iArr;
        }
        int[] a2 = f471g.a().a();
        AppMethodBeat.o(222089);
        return a2;
    }

    public static int b() {
        AppMethodBeat.i(222090);
        if (f470f || (f469e != 0 && TXCTimeUtil.getTimeTick() - f469e < 15000)) {
            int i2 = f468d;
            AppMethodBeat.o(222090);
            return i2;
        }
        f470f = true;
        AsyncTask.execute(new Runnable() {
            /* class com.tencent.liteav.basic.util.f.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(222125);
                System.currentTimeMillis();
                boolean unused = f.f470f = false;
                try {
                    Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
                    Debug.getMemoryInfo(memoryInfo);
                    int totalPss = memoryInfo.getTotalPss();
                    long unused2 = f.f469e = TXCTimeUtil.getTimeTick();
                    int unused3 = f.f468d = totalPss / 1024;
                    AppMethodBeat.o(222125);
                } catch (Exception e2) {
                    AppMethodBeat.o(222125);
                }
            }
        });
        int i3 = f468d;
        AppMethodBeat.o(222090);
        return i3;
    }

    public static boolean a(Context context) {
        AppMethodBeat.i(222091);
        if (context == null) {
            AppMethodBeat.o(222091);
            return false;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            if (activityManager.getRunningTasks(1) == null) {
                TXCLog.e("TXCSystemUtil", "running task is null, ams is abnormal!!!");
                AppMethodBeat.o(222091);
                return false;
            }
            ActivityManager.RunningTaskInfo runningTaskInfo = activityManager.getRunningTasks(1).get(0);
            if (runningTaskInfo == null || runningTaskInfo.topActivity == null) {
                TXCLog.e("TXCSystemUtil", "failed to get RunningTaskInfo");
                AppMethodBeat.o(222091);
                return false;
            } else if (!runningTaskInfo.topActivity.getPackageName().equals(context.getPackageName())) {
                AppMethodBeat.o(222091);
                return true;
            } else {
                AppMethodBeat.o(222091);
                return false;
            }
        } catch (Exception e2) {
            AppMethodBeat.o(222091);
            return false;
        }
    }

    public static String b(Context context) {
        AppMethodBeat.i(222092);
        String simulateIDFA = TXCDRApi.getSimulateIDFA(context);
        AppMethodBeat.o(222092);
        return simulateIDFA;
    }

    public static String c(Context context) {
        AppMethodBeat.i(222093);
        String str = "";
        if (context != null) {
            try {
                str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(222093);
        return str;
    }

    public static boolean d(Context context) {
        NetworkInfo activeNetworkInfo;
        AppMethodBeat.i(222094);
        try {
            System.currentTimeMillis();
            if (!(context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null)) {
                boolean isAvailable = activeNetworkInfo.isAvailable();
                AppMethodBeat.o(222094);
                return isAvailable;
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(222094);
        return false;
    }

    public static int e(Context context) {
        AppMethodBeat.i(222095);
        if (context == null) {
            AppMethodBeat.o(222095);
            return 0;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            AppMethodBeat.o(222095);
            return 0;
        } else if (!activeNetworkInfo.isConnected()) {
            AppMethodBeat.o(222095);
            return 0;
        } else if (activeNetworkInfo.getType() == 9) {
            AppMethodBeat.o(222095);
            return 5;
        } else if (activeNetworkInfo.getType() == 1) {
            AppMethodBeat.o(222095);
            return 1;
        } else if (activeNetworkInfo.getType() == 0) {
            switch (telephonyManager.getNetworkType()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    AppMethodBeat.o(222095);
                    return 4;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    AppMethodBeat.o(222095);
                    return 3;
                case 13:
                    AppMethodBeat.o(222095);
                    return 2;
                default:
                    AppMethodBeat.o(222095);
                    return 2;
            }
        } else {
            AppMethodBeat.o(222095);
            return 0;
        }
    }

    public static String c() {
        return Build.MODEL;
    }

    public static String d() {
        return Build.VERSION.RELEASE;
    }

    public static String e() {
        AppMethodBeat.i(222096);
        String uuid = UUID.randomUUID().toString();
        AppMethodBeat.o(222096);
        return uuid;
    }

    public static String f(Context context) {
        AppMethodBeat.i(222097);
        String devUUID = TXCDRApi.getDevUUID(context, TXCDRApi.getSimulateIDFA(context));
        AppMethodBeat.o(222097);
        return devUUID;
    }

    public static void a(WeakReference<b> weakReference, String str, int i2, String str2) {
        AppMethodBeat.i(222098);
        Bundle bundle = new Bundle();
        bundle.putString("EVT_USERID", str);
        bundle.putInt("EVT_ID", i2);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        if (str2 != null) {
            bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str2);
        }
        a(weakReference, i2, bundle);
        AppMethodBeat.o(222098);
    }

    public static void a(WeakReference<b> weakReference, int i2, String str) {
        AppMethodBeat.i(222099);
        Bundle bundle = new Bundle();
        bundle.putInt("EVT_ID", i2);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        if (str != null) {
            bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str);
        }
        a(weakReference, i2, bundle);
        AppMethodBeat.o(222099);
    }

    public static void a(WeakReference<b> weakReference, int i2, Bundle bundle) {
        AppMethodBeat.i(222100);
        if (weakReference == null) {
            AppMethodBeat.o(222100);
            return;
        }
        b bVar = weakReference.get();
        if (bVar != null) {
            bVar.onNotifyEvent(i2, bundle);
        }
        AppMethodBeat.o(222100);
    }

    public static void a(WeakReference<b> weakReference, String str, int i2, Bundle bundle) {
        AppMethodBeat.i(222101);
        if (weakReference == null) {
            AppMethodBeat.o(222101);
            return;
        }
        b bVar = weakReference.get();
        if (bVar != null) {
            bundle.putString("EVT_USERID", str);
            bVar.onNotifyEvent(i2, bundle);
        }
        AppMethodBeat.o(222101);
    }

    public static com.tencent.liteav.basic.c.a a(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9 = 0;
        AppMethodBeat.i(222102);
        if (i2 * i5 >= i3 * i4) {
            i6 = (i3 * i4) / i5;
            i7 = i3;
        } else {
            i6 = i2;
            i7 = (i2 * i5) / i4;
        }
        if (i2 > i6) {
            i8 = (i2 - i6) >> 1;
        } else {
            i8 = 0;
        }
        if (i3 > i7) {
            i9 = (i3 - i7) >> 1;
        }
        com.tencent.liteav.basic.c.a aVar = new com.tencent.liteav.basic.c.a(i8, i9, i6, i7);
        AppMethodBeat.o(222102);
        return aVar;
    }

    public static boolean f() {
        boolean z;
        AppMethodBeat.i(222103);
        synchronized (f472h) {
            try {
                if (!f473i) {
                    a("txffmpeg");
                    a("traeimp-rtmp");
                    f473i = a("liteavsdk");
                    new StringBuilder("load library liteavsdk ").append(f473i);
                }
                z = f473i;
            } finally {
                AppMethodBeat.o(222103);
            }
        }
        return z;
    }

    public static boolean a(String str) {
        AppMethodBeat.i(222104);
        try {
            new StringBuilder("load library ").append(str).append(" from system path ");
            System.loadLibrary(str);
            AppMethodBeat.o(222104);
            return true;
        } catch (Error e2) {
            new StringBuilder("load library : ").append(e2.toString());
            boolean b2 = b(f467c, str);
            AppMethodBeat.o(222104);
            return b2;
        } catch (Exception e3) {
            new StringBuilder("load library : ").append(e3.toString());
            boolean b3 = b(f467c, str);
            AppMethodBeat.o(222104);
            return b3;
        }
    }

    private static boolean b(String str, String str2) {
        AppMethodBeat.i(222105);
        boolean z = false;
        try {
            if (!TextUtils.isEmpty(str)) {
                new StringBuilder("load library ").append(str2).append(" from path ").append(str);
                System.load(str + "/lib" + str2 + ".so");
                z = true;
            }
        } catch (Error e2) {
            new StringBuilder("load library : ").append(e2.toString());
        } catch (Exception e3) {
            new StringBuilder("load library : ").append(e3.toString());
        }
        AppMethodBeat.o(222105);
        return z;
    }

    public static void b(String str) {
        f467c = str;
    }

    public static String g() {
        return f467c;
    }

    public static int a(int i2) {
        int i3 = 0;
        while (i3 < f474j.length && f474j[i3] != i2) {
            i3++;
        }
        if (i3 >= f474j.length) {
            return -1;
        }
        return i3;
    }

    @TargetApi(16)
    public static MediaFormat a(int i2, int i3, int i4) {
        AppMethodBeat.i(222106);
        int a2 = a(i2);
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.put(0, (byte) ((i4 << 3) | (a2 >> 1)));
        allocate.put(1, (byte) (((a2 & 1) << 7) | (i3 << 3)));
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat(EncoderWriter.OUTPUT_AUDIO_MIME_TYPE, i2, i3);
        createAudioFormat.setInteger("channel-count", i3);
        createAudioFormat.setInteger("sample-rate", i2);
        createAudioFormat.setByteBuffer("csd-0", allocate);
        AppMethodBeat.o(222106);
        return createAudioFormat;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0061 A[SYNTHETIC, Splitter:B:25:0x0061] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0072 A[SYNTHETIC, Splitter:B:33:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0077  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.String r7, java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 142
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.basic.util.f.a(java.lang.String, java.lang.String):boolean");
    }

    private static void a(String str, MediaFormat mediaFormat, byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(222108);
        ByteBuffer allocate = ByteBuffer.allocate(i3 - i2);
        allocate.put(bArr, i2, i3 - i2);
        allocate.position(0);
        mediaFormat.setByteBuffer(str, allocate);
        AppMethodBeat.o(222108);
    }

    @TargetApi(16)
    public static MediaFormat a(byte[] bArr, int i2, int i3) {
        int i4;
        int i5;
        AppMethodBeat.i(222109);
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i2, i3);
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        boolean z = false;
        boolean z2 = false;
        while (i6 + 3 < bArr.length) {
            if (bArr[i6] == 0 && bArr[i6 + 1] == 0 && bArr[i6 + 2] == 1) {
                i4 = 3;
            } else {
                i4 = 0;
            }
            if (bArr[i6] == 0 && bArr[i6 + 1] == 0 && bArr[i6 + 2] == 0 && bArr[i6 + 3] == 1) {
                i4 = 4;
            }
            if (i4 > 0) {
                if (i8 == 0) {
                    i6 += i4;
                    i8 = i4;
                } else {
                    int i9 = bArr[i8] & 31;
                    if (i9 == 7) {
                        a("csd-0", createVideoFormat, bArr, i8, i6);
                        z2 = true;
                    } else if (i9 == 8) {
                        a("csd-1", createVideoFormat, bArr, i8, i6);
                        z = true;
                    }
                    int i10 = i6 + i4;
                    if (!z2 || !z) {
                        i5 = i10;
                        i7 = i6;
                        i8 = i10;
                        i6 = i5 + 1;
                    } else {
                        AppMethodBeat.o(222109);
                        return createVideoFormat;
                    }
                }
            }
            i5 = i6;
            i6 = i5 + 1;
        }
        int i11 = bArr[i8] & 31;
        if (z2 && i11 == 8) {
            a("csd-1", createVideoFormat, bArr, i8, i7);
            AppMethodBeat.o(222109);
            return createVideoFormat;
        } else if (!z || i11 != 7) {
            AppMethodBeat.o(222109);
            return null;
        } else {
            a("csd-0", createVideoFormat, bArr, i8, i7);
            AppMethodBeat.o(222109);
            return createVideoFormat;
        }
    }
}
