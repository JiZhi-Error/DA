package com.tencent.qbar;

import android.app.ActivityManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.qbar.QbarNative;
import com.tencent.qbar.WxQbarNative;
import com.tencent.qbar.a;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.UnsupportedEncodingException;
import java.util.List;

public final class f extends a {
    private static boolean CJM = true;
    private static volatile boolean RKm = true;
    private WxQbarNative RKn = new WxQbarNative();
    int RKo = 0;

    public f() {
        AppMethodBeat.i(91157);
        AppMethodBeat.o(91157);
    }

    static {
        AppMethodBeat.i(91167);
        hkl();
        AppMethodBeat.o(91167);
    }

    public static void DN(boolean z) {
        AppMethodBeat.i(176206);
        Log.i("MicroMsg.WxQBar", "alvinluo setEnableMultiCode: %b", Boolean.valueOf(z));
        CJM = z;
        AppMethodBeat.o(176206);
    }

    public static void hkl() {
        int a2;
        AppMethodBeat.i(91158);
        int a3 = ((b) g.af(b.class)).a(b.a.clicfg_scan_upgrade_rollback, 0);
        RKm = a3 != 1;
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
            RKm = true;
        }
        if (RKm && (a2 = ((b) g.af(b.class)).a(b.a.clicfg_scan_code_new_interface_memory_min_limit, 0)) > 0) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getMemoryInfo(memoryInfo);
            if (memoryInfo.totalMem > 0 && (((float) memoryInfo.totalMem) * 1.0f) / 1048576.0f <= ((float) a2)) {
                RKm = false;
            }
            Log.i("MicroMsg.WxQBar", "alvinluo checkMemoryLimit totalMemory: %s bytes, %s MB, config memoryLimit: %d, useNewScanInterface: %b", Long.valueOf(memoryInfo.totalMem), Float.valueOf((((float) memoryInfo.totalMem) * 1.0f) / 1048576.0f), Integer.valueOf(a2), Boolean.valueOf(RKm));
        }
        Log.i("MicroMsg.WxQBar", "alvinluo updateUseNewScanInterfaceStatus config: %d, useNewScanInterface: %b", Integer.valueOf(a3), Boolean.valueOf(RKm));
        AppMethodBeat.o(91158);
    }

    public static boolean hkm() {
        return RKm;
    }

    public final int d(byte[] bArr, int i2, int i3, boolean z) {
        AppMethodBeat.i(91159);
        if (z) {
            int S = S(bArr, i2, i3);
            AppMethodBeat.o(91159);
            return S;
        }
        int S2 = super.S(bArr, i2, i3);
        AppMethodBeat.o(91159);
        return S2;
    }

    @Override // com.tencent.qbar.a
    public final int S(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(91160);
        Log.i("MicroMsg.WxQBar", "alvinluo scanImage width: %d, height: %d, grayImage: %d, useNewScanInterface: %b", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bArr.length), Boolean.valueOf(RKm));
        if (RKm) {
            synchronized (this) {
                try {
                    if (this.RJt < 0) {
                        return -1;
                    }
                    int ScanImage712 = this.RKn.ScanImage712(bArr, i2, i3, this.RJt);
                    AppMethodBeat.o(91160);
                    return ScanImage712;
                } finally {
                    AppMethodBeat.o(91160);
                }
            }
        } else {
            int S = super.S(bArr, i2, i3);
            AppMethodBeat.o(91160);
            return S;
        }
    }

    public final void reset(boolean z) {
        AppMethodBeat.i(194828);
        if (RKm) {
            synchronized (this) {
                try {
                    if (this.RJt >= 0) {
                        Log.i("MicroMsg.WxQBar", "alvinluo reset WxQBar qbarId: %d, forZoom: %b", Integer.valueOf(this.RJt), Boolean.valueOf(z));
                        this.RKn.Reset(this.RJt, z);
                        AppMethodBeat.o(194828);
                    }
                } finally {
                    AppMethodBeat.o(194828);
                }
            }
        } else {
            AppMethodBeat.o(194828);
        }
    }

    public final String jS() {
        String GetDebugString;
        AppMethodBeat.i(194829);
        synchronized (this) {
            try {
                if (this.RJt < 0) {
                    GetDebugString = null;
                } else {
                    GetDebugString = this.RKn.GetDebugString(this.RJt);
                    AppMethodBeat.o(194829);
                }
            } finally {
                AppMethodBeat.o(194829);
            }
        }
        return GetDebugString;
    }

    public final int b(List<a.C2180a> list, List<QbarNative.QBarPoint> list2, List<WxQbarNative.QBarReportMsg> list3, boolean z) {
        AppMethodBeat.i(91162);
        QbarNative.QBarResultJNI[] qBarResultJNIArr = new QbarNative.QBarResultJNI[3];
        QbarNative.QBarPoint[] qBarPointArr = new QbarNative.QBarPoint[3];
        WxQbarNative.QBarReportMsg[] qBarReportMsgArr = new WxQbarNative.QBarReportMsg[3];
        for (int i2 = 0; i2 < 3; i2++) {
            qBarResultJNIArr[i2] = new QbarNative.QBarResultJNI();
            qBarResultJNIArr[i2].charset = new String();
            qBarResultJNIArr[i2].data = new byte[1024];
            qBarResultJNIArr[i2].typeName = new String();
            qBarPointArr[i2] = new QbarNative.QBarPoint();
            qBarReportMsgArr[i2] = new WxQbarNative.QBarReportMsg();
            qBarReportMsgArr[i2].binaryMethod = new String();
            qBarReportMsgArr[i2].charsetMode = new String();
            qBarReportMsgArr[i2].ecLevel = new String();
            qBarReportMsgArr[i2].scaleList = new String();
        }
        int i3 = 0;
        if (!RKm || !z) {
            this.RKn.GetDetailResults(qBarResultJNIArr, qBarPointArr, qBarReportMsgArr, this.RJt);
        } else {
            i3 = this.RKn.GetDetailResultsNew(qBarResultJNIArr, qBarPointArr, qBarReportMsgArr, this.RJt);
            this.RKo = i3 - 1;
            if (CJM && i3 <= 0) {
                Log.w("MicroMsg.WxQBar", "alvinluo getResults ret: %d", Integer.valueOf(i3));
                AppMethodBeat.o(91162);
                return 0;
            }
        }
        int i4 = 0;
        while (true) {
            if (i4 >= 3) {
                break;
            }
            try {
                QbarNative.QBarResultJNI qBarResultJNI = qBarResultJNIArr[i4];
                if (!Util.isNullOrNil(qBarResultJNI.typeName)) {
                    a.C2180a aVar = new a.C2180a();
                    aVar.charset = qBarResultJNI.charset;
                    aVar.typeID = qBarResultJNI.typeID;
                    aVar.typeName = qBarResultJNI.typeName;
                    aVar.rawData = qBarResultJNI.data;
                    aVar.priorityLevel = qBarResultJNI.priorityLevel;
                    if (aVar.charset.equals("ANY")) {
                        aVar.data = new String(qBarResultJNI.data, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                        if (aVar.data.length() == 0) {
                            aVar.data = new String(qBarResultJNI.data, "ASCII");
                        }
                    } else {
                        aVar.data = new String(qBarResultJNI.data, aVar.charset);
                    }
                    list.add(aVar);
                    if (!CJM && list.size() > 0) {
                        Log.w("MicroMsg.WxQBar", "alvinluo getResults not enableMultiCode and ignore other results");
                        break;
                    }
                }
                i4++;
            } catch (UnsupportedEncodingException e2) {
                Log.e("MicroMsg.WxQBar", "GetResults exp:" + e2.getMessage());
            }
        }
        if (list2 != null && RKm) {
            for (int i5 = 0; i5 < 3; i5++) {
                QbarNative.QBarPoint qBarPoint = qBarPointArr[i5];
                if (qBarPoint.point_cnt != 0) {
                    list2.add(qBarPoint);
                }
            }
        }
        if (list3 != null) {
            for (int i6 = 0; i6 < 3; i6++) {
                WxQbarNative.QBarReportMsg qBarReportMsg = qBarReportMsgArr[i6];
                if (!Util.isNullOrNil(qBarReportMsg.charsetMode)) {
                    list3.add(qBarReportMsg);
                }
            }
        }
        if (!RKm || !z || !CJM || i3 <= 0) {
            int size = list.size();
            AppMethodBeat.o(91162);
            return size;
        }
        Log.i("MicroMsg.WxQBar", "alvinluo getResults ret: %d, result size: %d", Integer.valueOf(i3), Integer.valueOf(list.size()));
        int size2 = list.size();
        AppMethodBeat.o(91162);
        return size2;
    }

    public final int aG(float f2, float f3) {
        AppMethodBeat.i(194830);
        int SetTouchCoordinate = this.RKn.SetTouchCoordinate(this.RJt, f2, f3);
        AppMethodBeat.o(194830);
        return SetTouchCoordinate;
    }

    public final int bpW(String str) {
        AppMethodBeat.i(91164);
        this.RKn.AddWhiteList(str, this.RJt);
        AppMethodBeat.o(91164);
        return 0;
    }

    public final int bpX(String str) {
        AppMethodBeat.i(91165);
        this.RKn.AddBlackList(str, this.RJt);
        AppMethodBeat.o(91165);
        return 0;
    }

    public final int aqy(int i2) {
        AppMethodBeat.i(176207);
        this.RKn.AddBlackInternal(i2, this.RJt);
        AppMethodBeat.o(176207);
        return 0;
    }
}
