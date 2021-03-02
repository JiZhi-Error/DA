package com.tencent.mm.plugin.wepkg.downloader;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.service.IBSPatchJNIService;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.b.b;
import com.tencent.mm.plugin.wepkg.c.a;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.e;
import com.tencent.mm.plugin.wepkg.model.j;
import com.tencent.mm.plugin.wepkg.utils.a;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WePkgDownloader {
    private static volatile WePkgDownloader JMj = null;
    private a JMk = new a() {
        /* class com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.wepkg.downloader.a
        public final synchronized void a(g gVar) {
            IWepkgUpdateCallback.RetCode retCode;
            AppMethodBeat.i(110603);
            if (gVar.mStatus == 1) {
                h.INSTANCE.idkeyStat(859, 2, 1, false);
                String str = gVar.JLZ.mFilePath;
                if (Util.isNullOrNil(str) || !new o(str).exists()) {
                    Log.e("MicroMsg.Wepkg.WepkgDownloader", "onDownloadComplete, pkgPath is null or nil");
                    IWepkgUpdateCallback.RetCode retCode2 = IWepkgUpdateCallback.RetCode.LOCAL_FILE_NOT_FOUND;
                    h.INSTANCE.idkeyStat(859, 4, 1, false);
                    retCode = retCode2;
                } else {
                    String str2 = gVar.JLZ.lAl;
                    String bhK = s.bhK(str);
                    if (!Util.nullAsNil(bhK).equalsIgnoreCase(str2)) {
                        Log.e("MicroMsg.Wepkg.WepkgDownloader", "onDownloadComplete, file.md5(%s) != net.md5(%s)", bhK, str2);
                        s.deleteFile(str);
                        IWepkgUpdateCallback.RetCode retCode3 = IWepkgUpdateCallback.RetCode.PKG_INTEGRITY_FAILED;
                        gVar.rxv = 1012;
                        h.INSTANCE.idkeyStat(859, 3, 1, false);
                        retCode = retCode3;
                    } else {
                        IWepkgUpdateCallback.RetCode retCode4 = IWepkgUpdateCallback.RetCode.OK;
                        h.INSTANCE.idkeyStat(859, 5, 1, false);
                        retCode = retCode4;
                    }
                }
            } else {
                h.INSTANCE.idkeyStat(859, 1, 1, false);
                retCode = IWepkgUpdateCallback.RetCode.FAILED;
            }
            Log.i("MicroMsg.Wepkg.WepkgDownloader", "download callback retCode:".concat(String.valueOf(retCode)));
            IWepkgUpdateCallback iWepkgUpdateCallback = (IWepkgUpdateCallback) WePkgDownloader.this.mCallBackMap.remove(gVar.JLZ.JMx);
            if (iWepkgUpdateCallback != null) {
                iWepkgUpdateCallback.a(gVar.JLZ.JMy, gVar.JLZ.mFilePath, retCode);
            } else {
                Log.i("MicroMsg.Wepkg.WepkgDownloader", "download callback invalid");
                a.b("CallbackInvalid", gVar.JLZ.mUrl, gVar.JLZ.JMy, null, -1, 0, null);
            }
            if (gVar.JLZ.qIG == 1 || gVar.JLZ.qIG == 3) {
                String str3 = gVar.JLZ.JMy;
                WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                wepkgCrossProcessTask.EX = TXLiteAVCode.WARNING_RTMP_NO_DATA;
                wepkgCrossProcessTask.JNh.hhD = str3;
                if (MMApplicationContext.isMMProcess()) {
                    wepkgCrossProcessTask.bjj();
                } else {
                    AppBrandMainProcessService.b(wepkgCrossProcessTask);
                }
            } else {
                String str4 = gVar.JLZ.JMy;
                String str5 = gVar.JLZ.JMz;
                WepkgCrossProcessTask wepkgCrossProcessTask2 = new WepkgCrossProcessTask();
                wepkgCrossProcessTask2.EX = WearableStatusCodes.ASSET_UNAVAILABLE;
                wepkgCrossProcessTask2.JNk.hhD = str4;
                wepkgCrossProcessTask2.JNk.JNn = str5;
                if (MMApplicationContext.isMMProcess()) {
                    wepkgCrossProcessTask2.bjj();
                } else {
                    AppBrandMainProcessService.b(wepkgCrossProcessTask2);
                }
            }
            WePkgDownloader.b(gVar);
            d.gkL().bcv(gVar.JLZ.JMx);
            AppMethodBeat.o(110603);
        }
    };
    private Map<String, IWepkgUpdateCallback> mCallBackMap;

    static /* synthetic */ boolean m(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(110617);
        boolean l = l(str, str2, str3, str4, str5);
        AppMethodBeat.o(110617);
        return l;
    }

    static /* synthetic */ String mr(String str, String str2) {
        AppMethodBeat.i(110616);
        String mq = mq(str, str2);
        AppMethodBeat.o(110616);
        return mq;
    }

    public static WePkgDownloader gkM() {
        AppMethodBeat.i(110609);
        if (JMj == null) {
            synchronized (WePkgDownloader.class) {
                try {
                    if (JMj == null) {
                        JMj = new WePkgDownloader();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(110609);
                    throw th;
                }
            }
        }
        WePkgDownloader wePkgDownloader = JMj;
        AppMethodBeat.o(110609);
        return wePkgDownloader;
    }

    public WePkgDownloader() {
        AppMethodBeat.i(110610);
        if (this.mCallBackMap == null) {
            this.mCallBackMap = new ConcurrentHashMap();
        }
        AppMethodBeat.o(110610);
    }

    public final synchronized void a(String str, final IWepkgUpdateCallback iWepkgUpdateCallback) {
        AppMethodBeat.i(110611);
        final WepkgVersion bcH = j.bcH(str);
        if (bcH == null) {
            Log.e("MicroMsg.Wepkg.WepkgDownloader", "downloadWepkg, wepkgVersion is null");
            AppMethodBeat.o(110611);
        } else {
            String mq = mq(str, bcH.version);
            if (!s.YS(mq) || !Util.nullAsNil(s.bhK(mq)).equals(bcH.md5)) {
                final com.tencent.mm.plugin.wepkg.b.a bcj = b.gkD().bcj(str);
                boolean z = false;
                if (bcj != null) {
                    Log.i("MicroMsg.Wepkg.WepkgDownloader", "diff is not null, pkgId: %s", str);
                    if (!Util.nullAsNil(bcj.field_version).equals(bcH.version)) {
                        Log.i("MicroMsg.Wepkg.WepkgDownloader", "diff version is not equal to package version, pkgId: %s, diffVersion: %s, packageVersion: %s", str, bcj.field_version, bcH.version);
                        b.gkD().gC(str);
                    } else if (Util.isNullOrNil(bcj.field_downloadUrl)) {
                        Log.i("MicroMsg.Wepkg.WepkgDownloader", "diff downloadurl is null, pkgId: %s, diffVersion: %s", str, bcj.field_version);
                        b.gkD().gC(str);
                    } else if (!s.YS(bcj.field_oldPath)) {
                        Log.i("MicroMsg.Wepkg.WepkgDownloader", "old package is not exists, pkgId: %s, oldPath: %s", str, bcj.field_oldPath);
                        b.gkD().gC(str);
                    } else {
                        z = true;
                    }
                }
                Log.i("MicroMsg.Wepkg.WepkgDownloader", "downloadBigPackage, downloadDiff = %b", Boolean.valueOf(z));
                if (z) {
                    h.INSTANCE.dN(859, 22);
                    AnonymousClass1 r14 = new IWepkgUpdateCallback() {
                        /* class com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback
                        public final void a(String str, String str2, IWepkgUpdateCallback.RetCode retCode) {
                            AppMethodBeat.i(110602);
                            String mr = WePkgDownloader.mr(str, bcH.version);
                            if (retCode == IWepkgUpdateCallback.RetCode.OK) {
                                h.INSTANCE.dN(859, 24);
                                boolean m = WePkgDownloader.m(str, mr, bcj.field_oldPath, str2, bcH.md5);
                                s.deleteFile(str2);
                                b.gkD().gC(str);
                                if (m) {
                                    iWepkgUpdateCallback.a(str, mr, IWepkgUpdateCallback.RetCode.OK);
                                    AppMethodBeat.o(110602);
                                    return;
                                }
                                WePkgDownloader.this.a(str, iWepkgUpdateCallback);
                                AppMethodBeat.o(110602);
                            } else if (retCode == IWepkgUpdateCallback.RetCode.CANCEL) {
                                iWepkgUpdateCallback.a(str, mr, retCode);
                                AppMethodBeat.o(110602);
                            } else {
                                if (retCode == IWepkgUpdateCallback.RetCode.FAILED) {
                                    h.INSTANCE.dN(859, 23);
                                } else if (retCode == IWepkgUpdateCallback.RetCode.PKG_INTEGRITY_FAILED) {
                                    h.INSTANCE.dN(859, 25);
                                } else if (retCode == IWepkgUpdateCallback.RetCode.LOCAL_FILE_NOT_FOUND) {
                                    h.INSTANCE.dN(859, 26);
                                }
                                s.deleteFile(str2);
                                b.gkD().gC(str);
                                WePkgDownloader.this.a(str, iWepkgUpdateCallback);
                                AppMethodBeat.o(110602);
                            }
                        }
                    };
                    String ms = e.ms(bcj.field_pkgId, bcj.field_version);
                    d.checkMkdir(ms);
                    a(3, bcj.field_pkgId, ms + "/diff", "", bcj.field_downloadUrl, (long) bcj.field_pkgSize, bcj.field_version, bcj.field_oldVersion, bcj.field_md5, bcj.field_downloadNetType, r14);
                    AppMethodBeat.o(110611);
                } else {
                    a(1, bcH.hhD, mq, "", bcH.downloadUrl, (long) bcH.JNT, bcH.version, "", bcH.md5, bcH.JMZ, iWepkgUpdateCallback);
                    AppMethodBeat.o(110611);
                }
            } else {
                Log.i("MicroMsg.Wepkg.WepkgDownloader", "file exist in current %s version, pkgPath:%s", bcH.version, mq);
                a.C2009a.JOa.q(str, bcH.downloadUrl, 0);
                if (iWepkgUpdateCallback != null) {
                    iWepkgUpdateCallback.a(str, mq, IWepkgUpdateCallback.RetCode.OK);
                }
                AppMethodBeat.o(110611);
            }
        }
    }

    private static boolean l(String str, String str2, String str3, String str4, String str5) {
        boolean equalsIgnoreCase;
        AppMethodBeat.i(110612);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            int bspatch = ((IBSPatchJNIService) g.af(IBSPatchJNIService.class)).bspatch(str3, str2, str4);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            Log.i("MicroMsg.Wepkg.WepkgDownloader", "mergeDiffPackage, result: %d, cost: %d", Integer.valueOf(bspatch), Long.valueOf(currentTimeMillis2));
            if (bspatch == 0) {
                h.INSTANCE.dN(859, 34);
                if (Util.isNullOrNil(str5)) {
                    equalsIgnoreCase = true;
                } else {
                    String bhK = s.bhK(str2);
                    if (Util.isNullOrNil(bhK)) {
                        equalsIgnoreCase = false;
                    } else {
                        Log.i("MicroMsg.Wepkg.WepkgDownloader", "matchMd5, fileMd5: %s, md5: %s", bhK, str5);
                        equalsIgnoreCase = str5.trim().equalsIgnoreCase(bhK.trim());
                    }
                }
                if (equalsIgnoreCase) {
                    com.tencent.mm.plugin.wepkg.utils.a.c(str, 0, "", currentTimeMillis2);
                    AppMethodBeat.o(110612);
                    return true;
                }
                h.INSTANCE.dN(859, 35);
                com.tencent.mm.plugin.wepkg.utils.a.c(str, 2007, "", currentTimeMillis2);
            } else {
                h.INSTANCE.dN(859, 27);
                h.INSTANCE.dN(859, 25 - bspatch);
                com.tencent.mm.plugin.wepkg.utils.a.c(str, 1998 - bspatch, "", currentTimeMillis2);
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.Wepkg.WepkgDownloader", "mergeDiffPkg e = %s, old[%s], new[%s], diff[%s]", e2, str3, str2, str4);
            Log.printErrStackTrace("MicroMsg.Wepkg.WepkgDownloader", e2, "", new Object[0]);
            h.INSTANCE.dN(859, 33);
            com.tencent.mm.plugin.wepkg.utils.a.c(str, 2006, "", System.currentTimeMillis() - currentTimeMillis);
        }
        AppMethodBeat.o(110612);
        return false;
    }

    private static String mq(String str, String str2) {
        AppMethodBeat.i(110613);
        String ms = e.ms(str, str2);
        d.checkMkdir(ms);
        String str3 = ms + "/package";
        AppMethodBeat.o(110613);
        return str3;
    }

    public final void a(int i2, String str, String str2, String str3, String str4, long j2, String str5, String str6, String str7, int i3, IWepkgUpdateCallback iWepkgUpdateCallback) {
        String str8;
        boolean z;
        String str9;
        AppMethodBeat.i(110614);
        Log.i("MicroMsg.Wepkg.WepkgDownloader", "triggerDownloadWepkg, fileType:%s, pkgid:%s, downloadUrl:%s, pkgSize:%d, version:%s, md5:%s, downloadNetType:%d", Integer.valueOf(i2), str, str4, Long.valueOf(j2), str5, str7, Integer.valueOf(i3));
        if (i2 == 2) {
            String str10 = e.ms(str, str5) + "/preload_files";
            d.checkMkdir(str10);
            str8 = str10 + FilePathGenerator.ANDROID_DIR_SEP + str7;
        } else {
            str8 = str2;
        }
        if (Util.isNullOrNil(str8)) {
            Log.i("MicroMsg.Wepkg.WepkgDownloader", "pkgPath:%s is null", str8);
            a.C2009a.JOa.q(str, str4, 0);
            if (iWepkgUpdateCallback != null) {
                iWepkgUpdateCallback.a(str, "", IWepkgUpdateCallback.RetCode.FAILED);
            }
            AppMethodBeat.o(110614);
            return;
        }
        if (!com.tencent.mm.pluginsdk.j.a.d.a.YS(str8)) {
            String bcx = e.bcx(str);
            if (!Util.isNullOrNil(bcx)) {
                o oVar = new o(bcx);
                ArrayList<String> arrayList = new ArrayList();
                if (str8 == null || str8.length() <= 0) {
                    str9 = "";
                } else {
                    str9 = new o(str8).getName();
                    int lastIndexOf = str9.lastIndexOf(46);
                    if (lastIndexOf >= 0) {
                        if (lastIndexOf == 0) {
                            str9 = "";
                        } else {
                            str9 = str9.substring(0, lastIndexOf);
                        }
                    }
                }
                a(oVar, str9, arrayList);
                Log.i("MicroMsg.Wepkg.WepkgDownloader", "local have the same file. size:%s", Integer.valueOf(arrayList.size()));
                for (String str11 : arrayList) {
                    o oVar2 = new o(str11);
                    if (oVar2.isFile() && oVar2.length() == j2 && Util.nullAsNil(s.bhK(aa.z(oVar2.mUri))).equalsIgnoreCase(str7)) {
                        s.nw(aa.z(oVar2.her()), str8);
                        Log.i("MicroMsg.Wepkg.WepkgDownloader", "file exist in other version path:%s, pkgPath:%s", aa.z(oVar2.her()), str8);
                        a.C2009a.JOa.q(str, str4, 0);
                        if (iWepkgUpdateCallback != null) {
                            iWepkgUpdateCallback.a(str, str8, IWepkgUpdateCallback.RetCode.OK);
                        }
                        AppMethodBeat.o(110614);
                        return;
                    }
                }
            }
        } else if (Util.nullAsNil(s.bhK(str8)).equals(str7)) {
            Log.i("MicroMsg.Wepkg.WepkgDownloader", "file exist in current %s version, pkgPath:%s", str5, str8);
            a.C2009a.JOa.q(str, str4, 0);
            if (iWepkgUpdateCallback != null) {
                iWepkgUpdateCallback.a(str, str8, IWepkgUpdateCallback.RetCode.OK);
            }
            AppMethodBeat.o(110614);
            return;
        }
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        switch (i3) {
            case 1:
                if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                    z3 = true;
                    z4 = true;
                    break;
                }
                break;
            case 3:
                if (NetStatusUtil.isWifiOr4G(MMApplicationContext.getContext()) || NetStatusUtil.is3G(MMApplicationContext.getContext())) {
                    z3 = true;
                }
                z2 = true;
                break;
            case 4:
                z3 = true;
                z2 = true;
                break;
            case 9:
                if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                    z3 = true;
                } else if ((NetStatusUtil.isWifiOr4G(MMApplicationContext.getContext()) || NetStatusUtil.is3G(MMApplicationContext.getContext())) && d.gkY()) {
                    z3 = true;
                }
                z2 = true;
                break;
        }
        if (z2) {
            a.C2009a.JOa.q(str, str4, j2);
        } else {
            a.C2009a.JOa.q(str, str4, 0);
        }
        Log.i("MicroMsg.Wepkg.WepkgDownloader", "allowDownload:%s", Boolean.valueOf(z3));
        if (z3) {
            c cVar = new c(new f(com.tencent.mm.b.g.getMessageDigest(str4.getBytes()), i2, str, str3, str5, str6, str4, str8, j2, str7, z4, this.JMk));
            d gkL = d.gkL();
            if (!gkL.JMi.containsKey(cVar.JLZ.JMx)) {
                cVar.jKp = b.gkJ().JLY.submit(cVar);
                gkL.JMi.put(cVar.JLZ.JMx, cVar);
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.mCallBackMap.put(com.tencent.mm.b.g.getMessageDigest(str4.getBytes()), iWepkgUpdateCallback);
                h.INSTANCE.idkeyStat(859, 0, 1, false);
                AppMethodBeat.o(110614);
                return;
            }
            if (iWepkgUpdateCallback != null) {
                iWepkgUpdateCallback.a(str, "", IWepkgUpdateCallback.RetCode.CANCEL);
            }
            AppMethodBeat.o(110614);
            return;
        }
        Log.i("MicroMsg.Wepkg.WepkgDownloader", "net is not match, dont download");
        if (iWepkgUpdateCallback != null) {
            iWepkgUpdateCallback.a(str, "", IWepkgUpdateCallback.RetCode.CANCEL);
        }
        AppMethodBeat.o(110614);
    }

    public interface IWepkgUpdateCallback {
        void a(String str, String str2, RetCode retCode);

        public enum RetCode implements Parcelable {
            OK,
            LOCAL_FILE_NOT_FOUND,
            PKG_INTEGRITY_FAILED,
            PKG_INVALID,
            FAILED,
            CANCEL;
            
            public static final Parcelable.Creator<RetCode> CREATOR = new Parcelable.Creator<RetCode>() {
                /* class com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object[]' to match base method */
                @Override // android.os.Parcelable.Creator
                public final /* bridge */ /* synthetic */ RetCode[] newArray(int i2) {
                    return new RetCode[i2];
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // android.os.Parcelable.Creator
                public final /* synthetic */ RetCode createFromParcel(Parcel parcel) {
                    AppMethodBeat.i(110604);
                    RetCode retCode = RetCode.values()[parcel.readInt()];
                    AppMethodBeat.o(110604);
                    return retCode;
                }
            };

            public static RetCode valueOf(String str) {
                AppMethodBeat.i(110606);
                RetCode retCode = (RetCode) Enum.valueOf(RetCode.class, str);
                AppMethodBeat.o(110606);
                return retCode;
            }

            static {
                AppMethodBeat.i(110608);
                AppMethodBeat.o(110608);
            }

            public final int describeContents() {
                return 0;
            }

            public final void writeToParcel(Parcel parcel, int i2) {
                AppMethodBeat.i(110607);
                parcel.writeInt(ordinal());
                AppMethodBeat.o(110607);
            }
        }
    }

    private void a(o oVar, String str, List<String> list) {
        o[] het;
        AppMethodBeat.i(177087);
        if (oVar == null || !oVar.exists()) {
            AppMethodBeat.o(177087);
        } else if (!oVar.isFile() || !oVar.getName().equals(str)) {
            if (oVar.isDirectory() && (het = oVar.het()) != null) {
                for (o oVar2 : het) {
                    a(oVar2, str, list);
                }
            }
            AppMethodBeat.o(177087);
        } else {
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(aa.z(oVar.her()));
            AppMethodBeat.o(177087);
        }
    }

    static /* synthetic */ void b(g gVar) {
        int i2;
        long j2;
        AppMethodBeat.i(110618);
        f fVar = gVar.JLZ;
        if (fVar != null) {
            String str = fVar.JMy;
            String str2 = fVar.JMA;
            int i3 = gVar.JMI;
            int i4 = gVar.rxv;
            int i5 = gVar.mRetryTimes;
            Context context = MMApplicationContext.getContext();
            if (!NetStatusUtil.isNetworkConnected(context)) {
                i2 = -1;
            } else if (NetStatusUtil.is2G(context)) {
                i2 = 2;
            } else if (NetStatusUtil.is3G(context)) {
                i2 = 3;
            } else if (NetStatusUtil.is4G(context)) {
                i2 = 4;
            } else if (NetStatusUtil.isWifi(context)) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            String bcN = com.tencent.mm.plugin.wepkg.utils.a.bcN(fVar.mUrl);
            int i6 = fVar.qIG;
            long j3 = fVar.mStartTime;
            if (j3 > 0) {
                j2 = System.currentTimeMillis() - j3;
            } else {
                j2 = 0;
            }
            String str3 = fVar.JMH;
            long j4 = fVar.JMB;
            Log.i("MicroMsg.WePkgReport", "pkgId = %s, version = %s, isRange = %d, errCode=%d, retryTimes = %d, netType = %d,costTime = %d, fileSize = %d", str, str2, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j4));
            com.tencent.mm.game.report.api.a.hhr.a(new com.tencent.mm.game.report.api.b(14229, com.tencent.mm.plugin.wepkg.utils.a.s(str, str2, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i5), bcN, "", str3, Integer.valueOf(i6), Long.valueOf(j2), Long.valueOf(j4))));
        }
        AppMethodBeat.o(110618);
    }
}
