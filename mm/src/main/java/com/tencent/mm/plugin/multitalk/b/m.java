package com.tencent.mm.plugin.multitalk.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import com.tencent.f.h;
import com.tencent.mars.ilink.comm.PlatformComm;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.n;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.acv;
import com.tencent.mm.protocal.protobuf.acy;
import com.tencent.mm.protocal.protobuf.efi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wxmm.IConfCallBack;
import com.tencent.wxmm.v2conference;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.LinkedList;

public class m {
    private static final String[] qrx = {"ilink_network", "ilink_xlog", "confService"};
    private static v2conference qsB = new v2conference();

    static {
        AppMethodBeat.i(239085);
        final Context context = MMApplicationContext.getContext();
        Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "hy: load so");
        String[] strArr = qrx;
        for (String str : strArr) {
            m.class.getClassLoader();
            j.Ed(str);
        }
        Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "load so end");
        h.RTc.aW(new Runnable() {
            /* class com.tencent.mm.plugin.multitalk.b.m.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(239058);
                PlatformComm.init(context, new Handler(Looper.getMainLooper()));
                Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "PlatformComm.init finish");
                AppMethodBeat.o(239058);
            }
        });
        AppMethodBeat.o(239085);
    }

    public static void czc() {
        AppMethodBeat.i(239059);
        Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "preloadInit");
        AppMethodBeat.o(239059);
    }

    private static boolean a(ConnectivityManager connectivityManager) {
        AppMethodBeat.i(239060);
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            boolean booleanValue = ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
            AppMethodBeat.o(239060);
            return booleanValue;
        } catch (Exception e2) {
            AppMethodBeat.o(239060);
            return false;
        }
    }

    private static String elH() {
        AppMethodBeat.i(239061);
        if (!a((ConnectivityManager) MMApplicationContext.getContext().getSystemService("connectivity"))) {
            Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "mobile network not connectedorconnecting");
            AppMethodBeat.o(239061);
            return "";
        }
        String simOperator = ((TelephonyManager) MMApplicationContext.getContext().getSystemService("phone")).getSimOperator();
        if (simOperator == null || simOperator.length() < 3) {
            Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "nic_op NULL");
            AppMethodBeat.o(239061);
            return "";
        }
        String str = simOperator.substring(0, 3) + ":" + simOperator.substring(3, simOperator.length());
        AppMethodBeat.o(239061);
        return str;
    }

    public static v2conference czd() {
        return qsB;
    }

    public static int a(String str, int i2, int i3, int i4, IConfCallBack iConfCallBack) {
        IOException e2;
        int i5;
        AppMethodBeat.i(239062);
        Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "hy: init voip");
        try {
            acu acu = new acu();
            acu.app_id = "wechat";
            acu.LnF = str;
            acu.LnG = b.aKA() + "/ilink";
            acu.LnR = 1;
            acu.LnH = 0;
            acu.LnJ = 1;
            acu.LnK = s.cyW();
            acu.LnL = i2;
            acu.LnM = i3;
            acu.LnN = i4;
            acu.LnS = n.getNumCores();
            acu.LnT = Util.getInt(com.tencent.mm.compatible.deviceinfo.m.aop(), 0);
            acu.LnU = com.tencent.mm.compatible.deviceinfo.m.aon();
            acu.LnV = Build.MANUFACTURER;
            acu.LnW = Build.MODEL;
            acu.LnX = Build.VERSION.RELEASE;
            acu.LnY = Build.VERSION.INCREMENTAL;
            acu.LnZ = Build.DISPLAY;
            acu.Loc = elH();
            acu.LnQ = 2;
            int Qr = ((a) g.af(a.class)).Qr(2);
            if (Qr == 3) {
                Qr = 1;
            }
            acu.Lod = Qr;
            String dr = q.dr(false);
            if (dr == null || dr.isEmpty()) {
                Log.e("MicroMsg.Multitalk.ILinkNativeEngine", "getDeviceId failed");
            } else {
                acu.Loa = com.tencent.mm.bw.b.cD(MD5Util.getMD5String(dr).getBytes());
            }
            acu.Lob = Build.VERSION.RELEASE;
            Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "envInfo:" + new String(acu.toByteArray()) + ",length:" + acu.toByteArray().length);
            i5 = qsB.InitSDK(acu.toByteArray(), acu.toByteArray().length, iConfCallBack);
            try {
                Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "init ret:".concat(String.valueOf(i5)));
            } catch (IOException e3) {
                e2 = e3;
                Log.printErrStackTrace("MicroMsg.Multitalk.ILinkNativeEngine", e2, "envInfo exception", new Object[0]);
                AppMethodBeat.o(239062);
                return i5;
            }
        } catch (IOException e4) {
            e2 = e4;
            i5 = -1;
            Log.printErrStackTrace("MicroMsg.Multitalk.ILinkNativeEngine", e2, "envInfo exception", new Object[0]);
            AppMethodBeat.o(239062);
            return i5;
        }
        AppMethodBeat.o(239062);
        return i5;
    }

    public static int akF(String str) {
        AppMethodBeat.i(239063);
        int UpdateAuthKey = qsB.UpdateAuthKey(str.getBytes(), str.getBytes().length);
        AppMethodBeat.o(239063);
        return UpdateAuthKey;
    }

    public static int av(String str, int i2, int i3) {
        AppMethodBeat.i(239064);
        acy acy = new acy();
        acy.KBt = str;
        acy.Lof = i2;
        acy.Loh = i3;
        acy.Log = true;
        int i4 = -1;
        try {
            i4 = qsB.JoinRoom(acy.toByteArray(), acy.toByteArray().length);
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.Multitalk.ILinkNativeEngine", e2, "JoinRoom exception", new Object[0]);
        }
        Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "joinRoom ret:" + i4 + ", groupId:" + str);
        AppMethodBeat.o(239064);
        return i4;
    }

    public static int a(LinkedList<String> linkedList, int i2, int i3) {
        AppMethodBeat.i(239065);
        int i4 = -1;
        acv acv = new acv();
        acv.Loe = linkedList;
        acv.Lof = i2;
        acv.Log = true;
        acv.Loh = i3;
        try {
            i4 = qsB.Invite(acv.toByteArray(), acv.toByteArray().length);
            Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "steve: invite ret:".concat(String.valueOf(i4)));
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.Multitalk.ILinkNativeEngine", e2, "Invite exception", new Object[0]);
        }
        AppMethodBeat.o(239065);
        return i4;
    }

    public static int F(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(239066);
        int SendAudioData = qsB.SendAudioData(bArr, i2, i3);
        AppMethodBeat.o(239066);
        return SendAudioData;
    }

    public static int R(byte[] bArr, int i2) {
        AppMethodBeat.i(239067);
        int GetAudioData = qsB.GetAudioData(bArr, i2);
        AppMethodBeat.o(239067);
        return GetAudioData;
    }

    public static int c(byte[] bArr, int i2, int i3, int i4) {
        AppMethodBeat.i(239068);
        int SendVideoData = qsB.SendVideoData(bArr, bArr.length, i2, i3, i4);
        AppMethodBeat.o(239068);
        return SendVideoData;
    }

    public static int W(byte[] bArr, int i2) {
        AppMethodBeat.i(239069);
        int GetDecodeVideoData = qsB.GetDecodeVideoData(bArr, i2);
        AppMethodBeat.o(239069);
        return GetDecodeVideoData;
    }

    public static int EU(int i2) {
        AppMethodBeat.i(239070);
        int GetVoiceActivity = qsB.GetVoiceActivity(i2);
        AppMethodBeat.o(239070);
        return GetVoiceActivity;
    }

    static int EV(int i2) {
        AppMethodBeat.i(239071);
        int ExitRoom = qsB.ExitRoom(i2);
        Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "exitRoom ret:".concat(String.valueOf(ExitRoom)));
        AppMethodBeat.o(239071);
        return ExitRoom;
    }

    public static int QZ(int i2) {
        AppMethodBeat.i(239072);
        int Hangup = qsB.Hangup(i2);
        Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "Hangup ret:".concat(String.valueOf(Hangup)));
        AppMethodBeat.o(239072);
        return Hangup;
    }

    public static int cze() {
        AppMethodBeat.i(239073);
        int UnInit = qsB.UnInit();
        Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "unInit ret:".concat(String.valueOf(UnInit)));
        AppMethodBeat.o(239073);
        return UnInit;
    }

    public static int e(int i2, byte[] bArr, int i3) {
        AppMethodBeat.i(239074);
        int SetAppCmd = qsB.SetAppCmd(i2, bArr, i3);
        AppMethodBeat.o(239074);
        return SetAppCmd;
    }

    public static void EW(int i2) {
        AppMethodBeat.i(239075);
        qsB.OnNetworkChange(i2, elH().getBytes());
        AppMethodBeat.o(239075);
    }

    public static void Q(boolean z, int i2) {
        AppMethodBeat.i(239076);
        qsB.SwitchAV(1, z ? 1 : 0, i2);
        AppMethodBeat.o(239076);
    }

    public static int videoHWProcess(byte[] bArr, int i2, int i3, int i4, int i5, byte[] bArr2, int i6, int i7) {
        AppMethodBeat.i(239077);
        int videoHWProcess = qsB.videoHWProcess(bArr, i2, i3, i4, i5, bArr2, i6, i7);
        AppMethodBeat.o(239077);
        return videoHWProcess;
    }

    public static u a(byte[] bArr, int i2, int i3, int i4, int i5, int[] iArr) {
        AppMethodBeat.i(239078);
        if (bArr == null || qsB == null) {
            Log.e("MicroMsg.Multitalk.ILinkNativeEngine", "steve:videoTrans null,  engine:" + qsB);
            AppMethodBeat.o(239078);
            return null;
        }
        int videoTrans = qsB.videoTrans(bArr, i2, i3, i4, i5, iArr);
        u uVar = new u();
        uVar.zKJ = iArr;
        uVar.zKK = qsB.field_localImgWidth;
        uVar.zKL = qsB.field_localImgHeight;
        uVar.ret = videoTrans;
        AppMethodBeat.o(239078);
        return uVar;
    }

    public static int a(efi efi) {
        int i2 = -1;
        AppMethodBeat.i(239079);
        if (efi == null) {
            Log.e("MicroMsg.Multitalk.ILinkNativeEngine", "steve: videoResParam is null");
            AppMethodBeat.o(239079);
        } else {
            try {
                Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "videoResParam:" + efi + ",length:" + efi.toByteArray().length);
                i2 = qsB.SubscribeVideo(efi.toByteArray(), efi.toByteArray().length);
                Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "steve: subScribeVideoAndResList ret:".concat(String.valueOf(i2)));
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.Multitalk.ILinkNativeEngine", e2, "SetVideoResolution exception", new Object[0]);
            }
            AppMethodBeat.o(239079);
        }
        return i2;
    }

    public static int X(byte[] bArr, int i2) {
        AppMethodBeat.i(239080);
        int SetAppCmd = qsB.SetAppCmd(10, bArr, i2);
        AppMethodBeat.o(239080);
        return SetAppCmd;
    }

    public static int b(LinkedList<String> linkedList, int i2, int i3) {
        AppMethodBeat.i(239081);
        int i4 = -1;
        acv acv = new acv();
        acv.Loe = linkedList;
        acv.Lof = i2;
        acv.Loh = i3;
        try {
            i4 = qsB.Add(acv.toByteArray(), acv.toByteArray().length);
            Log.i("MicroMsg.Multitalk.ILinkNativeEngine", "steve: addmember ret:".concat(String.valueOf(i4)));
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.Multitalk.ILinkNativeEngine", e2, "Invite exception", new Object[0]);
        }
        AppMethodBeat.o(239081);
        return i4;
    }

    public static void elI() {
        AppMethodBeat.i(239082);
        qsB.Ack();
        AppMethodBeat.o(239082);
    }

    public static void H(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(239083);
        qsB.RecvNotify(bArr, i2, i3);
        AppMethodBeat.o(239083);
    }

    public static int elJ() {
        AppMethodBeat.i(239084);
        int Accept = qsB.Accept(1);
        AppMethodBeat.o(239084);
        return Accept;
    }
}
