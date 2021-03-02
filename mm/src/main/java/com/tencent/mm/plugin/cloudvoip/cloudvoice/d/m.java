package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.tencent.f.h;
import com.tencent.mars.ilink.comm.PlatformComm;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.n;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.c;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.acy;
import com.tencent.mm.protocal.protobuf.efi;
import com.tencent.mm.protocal.protobuf.efj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wxmm.IConfCallBack;
import com.tencent.wxmm.v2conference;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class m {
    private static final String[] qrx = {"ilink_network", "ilink_xlog", "confService"};
    private static v2conference qsB = new v2conference();

    static {
        AppMethodBeat.i(90838);
        MMApplicationContext.getContext();
        Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "hy: load so");
        String[] strArr = qrx;
        for (String str : strArr) {
            try {
                m.class.getClassLoader();
                j.Ed(str);
            } catch (Throwable th) {
                Log.w("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "tryLoadLibrary fail, error = " + th.getMessage());
            }
        }
        Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "load so end");
        h.RTc.aW(new Runnable() {
            /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.m.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(184467);
                PlatformComm.init(MMApplicationContext.getContext(), new Handler(Looper.getMainLooper()));
                Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "PlatformComm.init finish");
                AppMethodBeat.o(184467);
            }
        });
        AppMethodBeat.o(90838);
    }

    public static void czc() {
        AppMethodBeat.i(186729);
        Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "preloadInit");
        AppMethodBeat.o(186729);
    }

    public static v2conference czd() {
        return qsB;
    }

    public static int a(String str, String str2, String str3, int i2, int i3, int i4, IConfCallBack iConfCallBack) {
        AppMethodBeat.i(90824);
        Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "hy: init voip");
        int i5 = -1;
        try {
            acu acu = new acu();
            acu.app_id = str;
            acu.LnD = str2;
            acu.LnE = str3;
            acu.LnG = b.aKA() + "/openvoice";
            acu.LnH = 0;
            acu.LnJ = 1;
            acu.LnK = c.cyW();
            acu.LnL = i2;
            acu.LnO = i3;
            acu.LnP = i4;
            acu.LnQ = 1;
            acu.LnS = n.getNumCores();
            acu.LnT = Util.getInt(com.tencent.mm.compatible.deviceinfo.m.aop(), 0);
            acu.LnU = com.tencent.mm.compatible.deviceinfo.m.aon();
            acu.LnV = Build.MANUFACTURER;
            acu.LnW = Build.MODEL;
            acu.LnX = Build.VERSION.RELEASE;
            acu.LnY = Build.VERSION.INCREMENTAL;
            acu.LnZ = Build.DISPLAY;
            String dr = q.dr(false);
            if (dr == null || dr.isEmpty()) {
                Log.e("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "getDeviceId failed");
            } else {
                acu.Loa = com.tencent.mm.bw.b.cD(MD5Util.getMD5String(dr).getBytes());
            }
            acu.Lob = Build.VERSION.RELEASE;
            Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "envInfo:" + new String(acu.toByteArray()) + ",length:" + acu.toByteArray().length);
            i5 = qsB.InitSDK(acu.toByteArray(), acu.toByteArray().length, iConfCallBack);
            Log.v("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "init ret:".concat(String.valueOf(i5)));
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceNativeEngine", e2, "envInfo exception", new Object[0]);
        }
        AppMethodBeat.o(90824);
        return i5;
    }

    public static int akF(String str) {
        AppMethodBeat.i(90825);
        int UpdateAuthKey = qsB.UpdateAuthKey(str.getBytes(), str.getBytes().length);
        AppMethodBeat.o(90825);
        return UpdateAuthKey;
    }

    public static int o(long j2, int i2) {
        AppMethodBeat.i(90826);
        acy acy = new acy();
        acy.Lnv = j2;
        acy.Lof = i2;
        acy.Loh = 4;
        acy.Log = false;
        int i3 = -1;
        try {
            i3 = qsB.JoinRoom(acy.toByteArray(), acy.toByteArray().length);
            Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "join room ret:".concat(String.valueOf(i3)));
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceNativeEngine", e2, "JoinRoom exception", new Object[0]);
        }
        Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "joinRoom ret:".concat(String.valueOf(i3)));
        AppMethodBeat.o(90826);
        return i3;
    }

    public static int F(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(90827);
        int SendAudioData = qsB.SendAudioData(bArr, i2, i3);
        AppMethodBeat.o(90827);
        return SendAudioData;
    }

    public static int R(byte[] bArr, int i2) {
        AppMethodBeat.i(90828);
        int GetAudioData = qsB.GetAudioData(bArr, i2);
        AppMethodBeat.o(90828);
        return GetAudioData;
    }

    public static int c(byte[] bArr, int i2, int i3, int i4) {
        AppMethodBeat.i(90829);
        int SendVideoData = qsB.SendVideoData(bArr, bArr.length, i2, i3, i4);
        AppMethodBeat.o(90829);
        return SendVideoData;
    }

    public static int bg(byte[] bArr) {
        AppMethodBeat.i(186730);
        int GetDecodeVideoData = qsB.GetDecodeVideoData(bArr, 0);
        AppMethodBeat.o(186730);
        return GetDecodeVideoData;
    }

    public static int EU(int i2) {
        AppMethodBeat.i(90831);
        int GetVoiceActivity = qsB.GetVoiceActivity(i2);
        AppMethodBeat.o(90831);
        return GetVoiceActivity;
    }

    static int EV(int i2) {
        AppMethodBeat.i(90832);
        int ExitRoom = qsB.ExitRoom(i2);
        Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "exitRoom ret:".concat(String.valueOf(ExitRoom)));
        AppMethodBeat.o(90832);
        return ExitRoom;
    }

    public static int cze() {
        AppMethodBeat.i(90833);
        int UnInit = qsB.UnInit();
        Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "unInit ret:".concat(String.valueOf(UnInit)));
        AppMethodBeat.o(90833);
        return UnInit;
    }

    public static int e(int i2, byte[] bArr, int i3) {
        AppMethodBeat.i(90834);
        int SetAppCmd = qsB.SetAppCmd(i2, bArr, i3);
        AppMethodBeat.o(90834);
        return SetAppCmd;
    }

    public static void EW(int i2) {
        AppMethodBeat.i(90835);
        qsB.OnNetworkChange(i2, null);
        AppMethodBeat.o(90835);
    }

    public static void b(boolean z, boolean z2, int i2) {
        int i3;
        int i4 = 1;
        AppMethodBeat.i(186731);
        v2conference v2conference = qsB;
        if (z) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (!z2) {
            i4 = 0;
        }
        v2conference.SwitchAV(i3, i4, i2);
        AppMethodBeat.o(186731);
    }

    public static int videoHWProcess(byte[] bArr, int i2, int i3, int i4, int i5, byte[] bArr2, int i6, int i7) {
        AppMethodBeat.i(186732);
        int videoHWProcess = qsB.videoHWProcess(bArr, i2, i3, i4, i5, bArr2, i6, i7);
        AppMethodBeat.o(186732);
        return videoHWProcess;
    }

    public static int R(ArrayList<efj> arrayList) {
        IOException e2;
        int i2;
        AppMethodBeat.i(184468);
        if (arrayList.size() == 0) {
            Log.e("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "steve: memberIdArr is null");
            AppMethodBeat.o(184468);
            return -1;
        }
        efi efi = new efi();
        LinkedList<efj> linkedList = new LinkedList<>();
        Iterator<efj> it = arrayList.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next());
        }
        efi.xuS = linkedList;
        try {
            Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "videoResParam:" + new String(efi.toByteArray()) + ",length:" + efi.toByteArray().length);
            i2 = qsB.SubscribeVideo(efi.toByteArray(), efi.toByteArray().length);
            try {
                Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "steve: subScribeVideoAndResList ret:".concat(String.valueOf(i2)));
            } catch (IOException e3) {
                e2 = e3;
                Log.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceNativeEngine", e2, "SetVideoResolution exception", new Object[0]);
                AppMethodBeat.o(184468);
                return i2;
            }
        } catch (IOException e4) {
            e2 = e4;
            i2 = -1;
            Log.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceNativeEngine", e2, "SetVideoResolution exception", new Object[0]);
            AppMethodBeat.o(184468);
            return i2;
        }
        AppMethodBeat.o(184468);
        return i2;
    }
}
