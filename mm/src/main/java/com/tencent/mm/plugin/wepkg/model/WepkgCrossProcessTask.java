package com.tencent.mm.plugin.wepkg.model;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.wepkg.b.c;
import com.tencent.mm.plugin.wepkg.b.d;
import com.tencent.mm.plugin.wepkg.b.e;
import com.tencent.mm.plugin.wepkg.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.List;

public class WepkgCrossProcessTask extends BaseWepkgProcessTask {
    public static final Parcelable.Creator<WepkgCrossProcessTask> CREATOR = new Parcelable.Creator<WepkgCrossProcessTask>() {
        /* class com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WepkgCrossProcessTask[] newArray(int i2) {
            return new WepkgCrossProcessTask[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WepkgCrossProcessTask createFromParcel(Parcel parcel) {
            AppMethodBeat.i(110688);
            WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask(parcel, (byte) 0);
            AppMethodBeat.o(110688);
            return wepkgCrossProcessTask;
        }
    };
    public int EX;
    public WepkgVersion JNh;
    public List<WepkgVersion> JNi;
    public WePkgDiffInfo JNj;
    public WepkgPreloadFile JNk;
    public List<WepkgPreloadFile> JNl;
    public String JNm;
    public Runnable lyv;

    /* synthetic */ WepkgCrossProcessTask(Parcel parcel, byte b2) {
        this(parcel);
    }

    public WepkgCrossProcessTask() {
        AppMethodBeat.i(110689);
        this.EX = -1;
        this.JNh = new WepkgVersion();
        this.JNi = new ArrayList();
        this.JNj = new WePkgDiffInfo();
        this.JNk = new WepkgPreloadFile();
        this.JNl = new ArrayList();
        AppMethodBeat.o(110689);
    }

    private WepkgCrossProcessTask(Parcel parcel) {
        AppMethodBeat.i(110690);
        f(parcel);
        AppMethodBeat.o(110690);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjj() {
        WepkgCrossProcessTask wepkgCrossProcessTask;
        String str;
        Cursor rawQuery;
        String str2 = null;
        r2 = null;
        r2 = null;
        ArrayList arrayList = null;
        str2 = null;
        str2 = null;
        boolean z = false;
        boolean z2 = true;
        AppMethodBeat.i(110691);
        switch (this.EX) {
            case 1001:
                this.result = true;
                break;
            case 1002:
                this.result = a.dSV();
                break;
            case 2002:
                if (this.JNh != null && !Util.isNullOrNil(this.JNh.hhD)) {
                    f gkF = f.gkF();
                    WepkgVersion wepkgVersion = this.JNh;
                    e eVar = new e();
                    eVar.field_pkgId = wepkgVersion.hhD;
                    eVar.field_appId = wepkgVersion.appId;
                    eVar.field_version = wepkgVersion.version;
                    eVar.field_pkgPath = wepkgVersion.pkgPath;
                    eVar.field_disableWvCache = wepkgVersion.JNP;
                    eVar.field_clearPkgTime = wepkgVersion.JNQ;
                    eVar.field_checkIntervalTime = wepkgVersion.JNR;
                    eVar.field_packMethod = wepkgVersion.JNS;
                    eVar.field_domain = wepkgVersion.domain;
                    eVar.field_md5 = wepkgVersion.md5;
                    eVar.field_downloadUrl = wepkgVersion.downloadUrl;
                    eVar.field_pkgSize = wepkgVersion.JNT;
                    eVar.field_downloadNetType = wepkgVersion.JMZ;
                    eVar.field_nextCheckTime = wepkgVersion.JNU;
                    eVar.field_createTime = wepkgVersion.createTime;
                    eVar.field_charset = wepkgVersion.charset;
                    eVar.field_bigPackageReady = wepkgVersion.JNV;
                    eVar.field_preloadFilesReady = wepkgVersion.JNW;
                    eVar.field_preloadFilesAtomic = wepkgVersion.JNX;
                    eVar.field_totalDownloadCount = wepkgVersion.JNY;
                    eVar.field_downloadTriggerType = wepkgVersion.eij;
                    gkF.a(eVar, this.JNj);
                    if (!Util.isNullOrNil(this.JNl)) {
                        for (WepkgPreloadFile wepkgPreloadFile : this.JNl) {
                            if (wepkgPreloadFile != null) {
                                d gkE = d.gkE();
                                c cVar = new c();
                                cVar.field_key = wepkgPreloadFile.key;
                                cVar.field_pkgId = wepkgPreloadFile.hhD;
                                cVar.field_version = wepkgPreloadFile.version;
                                cVar.field_filePath = wepkgPreloadFile.filePath;
                                cVar.field_rid = wepkgPreloadFile.JNn;
                                cVar.field_mimeType = wepkgPreloadFile.mimeType;
                                cVar.field_md5 = wepkgPreloadFile.md5;
                                cVar.field_downloadUrl = wepkgPreloadFile.downloadUrl;
                                cVar.field_size = wepkgPreloadFile.size;
                                cVar.field_downloadNetType = wepkgPreloadFile.JMZ;
                                cVar.field_completeDownload = wepkgPreloadFile.JNA;
                                cVar.field_createTime = wepkgPreloadFile.createTime;
                                if (gkE.lsb) {
                                    if (gkE.mp(cVar.field_pkgId, cVar.field_rid) == null) {
                                        cVar.field_createTime = com.tencent.mm.plugin.wepkg.utils.d.currentTime();
                                        Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "insertPreloadFile pkgid:%s, version:%s, rid:%s, ret:%s", cVar.field_pkgId, cVar.field_version, cVar.field_rid, Boolean.valueOf(gkE.insert(cVar)));
                                    } else {
                                        Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "relacePreloadFile pkgid:%s, version:%s, rid:%s, ret:%s", cVar.field_pkgId, cVar.field_version, cVar.field_rid, Boolean.valueOf(gkE.replace(cVar)));
                                    }
                                }
                            }
                        }
                    }
                    this.result = true;
                    break;
                }
            case 2003:
                if (this.JNh != null) {
                    f gkF2 = f.gkF();
                    if (!gkF2.lsb) {
                        str = null;
                    } else {
                        Cursor rawQuery2 = gkF2.rawQuery(String.format("select * from %s where %s=0 and %s=1 and %s<1 and %s<?", "WepkgVersion", "bigPackageReady", "preloadFilesAtomic", "autoDownloadCount", "packageDownloadCount"), TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                        if (rawQuery2 == null) {
                            str = null;
                        } else if (rawQuery2.moveToFirst()) {
                            int count = rawQuery2.getCount();
                            rawQuery2.move(count > 1 ? Util.getIntRandom(count - 1, 0) : 0);
                            e eVar2 = new e();
                            eVar2.convertFrom(rawQuery2);
                            rawQuery2.close();
                            gkF2.bcp(eVar2.field_pkgId);
                            Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, bigPackageReady:false, preloadFilesAtomic:true", eVar2.field_pkgId, eVar2.field_version);
                            str = eVar2.field_pkgId;
                        } else {
                            rawQuery2.close();
                            Cursor rawQuery3 = gkF2.rawQuery(String.format("select * from %s where %s=0 and %s<1 and %s<?", "WepkgVersion", "bigPackageReady", "autoDownloadCount", "packageDownloadCount"), TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                            if (rawQuery3 == null) {
                                str = null;
                            } else if (rawQuery3.moveToFirst()) {
                                int count2 = rawQuery3.getCount();
                                rawQuery3.move(count2 > 1 ? Util.getIntRandom(count2 - 1, 0) : 0);
                                e eVar3 = new e();
                                eVar3.convertFrom(rawQuery3);
                                rawQuery3.close();
                                gkF2.bcp(eVar3.field_pkgId);
                                Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, bigPackageReady:false, preloadFilesAtomic:false", eVar3.field_pkgId, eVar3.field_version);
                                str = eVar3.field_pkgId;
                            } else {
                                rawQuery3.close();
                                Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "randomNeedDownloadPkgid no download record in DB");
                                str = null;
                            }
                        }
                    }
                    if (Util.isNullOrNil(str)) {
                        d gkE2 = d.gkE();
                        if (gkE2.lsb && (rawQuery = gkE2.rawQuery(String.format("select * from %s where %s=0 and %s<1 and %s<?", "WepkgPreloadFiles", "completeDownload", "autoDownloadCount", "fileDownloadCount"), TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) != null) {
                            if (rawQuery.moveToFirst()) {
                                int count3 = rawQuery.getCount();
                                rawQuery.move(count3 > 1 ? Util.getIntRandom(count3 - 1, 0) : 0);
                                c cVar2 = new c();
                                cVar2.convertFrom(rawQuery);
                                rawQuery.close();
                                String str3 = cVar2.field_pkgId;
                                String str4 = cVar2.field_rid;
                                if (gkE2.lsb && !Util.isNullOrNil(str3) && !Util.isNullOrNil(str4)) {
                                    Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord addAutoDownloadCount ret:%s", Boolean.valueOf(gkE2.execSQL("WepkgPreloadFiles", String.format("update %s set %s=%s+1 where %s='%s' and %s='%s'", "WepkgPreloadFiles", "autoDownloadCount", "autoDownloadCount", "pkgId", str3, "rid", str4))));
                                }
                                Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, rid:%s", cVar2.field_pkgId, cVar2.field_version, cVar2.field_rid);
                                str2 = cVar2.field_pkgId;
                            } else {
                                rawQuery.close();
                                Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "randomNeedDownloadPkgid no download record in DB");
                            }
                        }
                    } else {
                        str2 = str;
                    }
                    if (Util.isNullOrNil(str2)) {
                        f gkF3 = f.gkF();
                        if (gkF3.lsb) {
                            Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord resetAutoDownloadCount ret:%s", Boolean.valueOf(gkF3.execSQL("WepkgVersion", String.format("update %s set %s=0", "WepkgVersion", "autoDownloadCount"))));
                            Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgPreloadFilesRecord resetAutoDownloadCount ret:%s", Boolean.valueOf(gkF3.execSQL("WepkgPreloadFiles", String.format("update %s set %s=0", "WepkgPreloadFiles", "autoDownloadCount"))));
                        }
                    }
                    this.JNh.hhD = str2;
                    break;
                }
                break;
            case 2004:
                if (this.JNh != null) {
                    z2 = f.gkF().bcq(this.JNh.hhD);
                    wepkgCrossProcessTask = this;
                    wepkgCrossProcessTask.result = z2;
                    break;
                }
                break;
            case 2005:
                this.JNi = f.gkF().gkH();
                wepkgCrossProcessTask = this;
                wepkgCrossProcessTask.result = z2;
                break;
            case 2006:
                if (this.JNh != null) {
                    f gkF4 = f.gkF();
                    String str5 = this.JNh.hhD;
                    if (gkF4.lsb && !Util.isNullOrNil(str5)) {
                        Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addTotalDownloadCount ret:%s", Boolean.valueOf(gkF4.execSQL("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", "WepkgVersion", "totalDownloadCount", "totalDownloadCount", "pkgId", str5))));
                        z = true;
                    }
                    this.result = z;
                    break;
                }
                break;
            case 3001:
                if (this.JNh != null) {
                    e bcm = f.gkF().bcm(this.JNh.hhD);
                    if (bcm != null) {
                        this.JNh.a(bcm);
                        this.result = true;
                        break;
                    } else {
                        this.JNh = null;
                        break;
                    }
                }
                break;
            case 3002:
                if (this.JNh != null) {
                    e bcn = f.gkF().bcn(this.JNh.hhD);
                    if (bcn != null) {
                        this.JNh.a(bcn);
                        wepkgCrossProcessTask = this;
                        wepkgCrossProcessTask.result = z2;
                        break;
                    } else {
                        this.JNh = null;
                        break;
                    }
                }
                break;
            case 3003:
                if (this.JNh != null) {
                    this.result = f.gkF().bco(this.JNh.hhD);
                    break;
                }
                break;
            case 3004:
                if (this.JNh != null) {
                    this.result = f.gkF().a(this.JNh.hhD, this.JNh.JNP, this.JNh.JNQ, this.JNh.JNR);
                    break;
                }
                break;
            case 3005:
                if (this.JNh != null) {
                    this.result = f.gkF().C(this.JNh.hhD, this.JNh.pkgPath, this.JNh.JNV);
                    break;
                }
                break;
            case 3006:
                if (this.JNh != null) {
                    this.result = f.gkF().cV(this.JNh.hhD, this.JNh.JNW);
                    break;
                }
                break;
            case TXLiteAVCode.WARNING_RTMP_READ_FAIL:
                if (this.JNh != null) {
                    z2 = f.gkF().bcr(this.JNh.hhD);
                    wepkgCrossProcessTask = this;
                    wepkgCrossProcessTask.result = z2;
                    break;
                }
                break;
            case TXLiteAVCode.WARNING_RTMP_NO_DATA:
                if (this.JNh != null) {
                    f gkF5 = f.gkF();
                    String str6 = this.JNh.hhD;
                    if (!gkF5.lsb || Util.isNullOrNil(str6)) {
                        z2 = false;
                    } else {
                        Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addPackageDownloadCount ret:%s", Boolean.valueOf(gkF5.execSQL("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", "WepkgVersion", "packageDownloadCount", "packageDownloadCount", "pkgId", str6))));
                    }
                    this.result = z2;
                    break;
                }
                break;
            case TXLiteAVCode.WARNING_PLAY_LIVE_STREAM_INFO_CONNECT_FAIL:
                if (this.JNh != null) {
                    f gkF6 = f.gkF();
                    String str7 = this.JNh.hhD;
                    if (!gkF6.lsb || Util.isNullOrNil(str7)) {
                        z2 = false;
                    } else {
                        Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord resetPackageDownloadCount ret:%s", Boolean.valueOf(gkF6.execSQL("WepkgVersion", String.format("update %s set %s=0 where %s='%s'", "WepkgVersion", "packageDownloadCount", "pkgId", str7))));
                    }
                    this.result = z2;
                    break;
                }
                break;
            case 4001:
                if (this.JNh != null && !Util.isNullOrNil(this.JNh.hhD)) {
                    try {
                        d gkE3 = d.gkE();
                        String str8 = this.JNh.hhD;
                        if (gkE3.lsb || !Util.isNullOrNil(str8)) {
                            String format = String.format("select * from %s where %s=? and %s=0", "WepkgPreloadFiles", "pkgId", "completeDownload");
                            Cursor rawQuery4 = gkE3.rawQuery(format, str8);
                            Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getNeedDownloadPreLoadFileList queryStr:%s", format);
                            if (rawQuery4 == null) {
                                Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "cursor is null");
                            } else if (rawQuery4.moveToFirst()) {
                                arrayList = new ArrayList();
                                do {
                                    WepkgPreloadFile wepkgPreloadFile2 = new WepkgPreloadFile();
                                    c cVar3 = new c();
                                    cVar3.convertFrom(rawQuery4);
                                    wepkgPreloadFile2.a(cVar3);
                                    arrayList.add(wepkgPreloadFile2);
                                } while (rawQuery4.moveToNext());
                                rawQuery4.close();
                                Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "record list size:%s", Integer.valueOf(arrayList.size()));
                            } else {
                                rawQuery4.close();
                                Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "no record");
                            }
                        }
                        this.JNl = arrayList;
                    } catch (Exception e2) {
                    }
                    wepkgCrossProcessTask = this;
                    wepkgCrossProcessTask.result = z2;
                    break;
                }
            case 4002:
                if (this.JNk != null) {
                    z2 = d.gkE().h(this.JNk.hhD, this.JNk.JNn, this.JNk.filePath, this.JNk.JNA);
                    wepkgCrossProcessTask = this;
                    wepkgCrossProcessTask.result = z2;
                    break;
                }
                break;
            case WearableStatusCodes.DATA_ITEM_TOO_LARGE:
                if (this.JNh != null) {
                    this.JNl = d.gkE().bck(this.JNh.hhD);
                    wepkgCrossProcessTask = this;
                    wepkgCrossProcessTask.result = z2;
                    break;
                }
                break;
            case WearableStatusCodes.INVALID_TARGET_NODE:
                if (this.JNk != null) {
                    c mp = d.gkE().mp(this.JNk.hhD, this.JNk.JNn);
                    if (mp != null) {
                        this.JNk.a(mp);
                        wepkgCrossProcessTask = this;
                        wepkgCrossProcessTask.result = z2;
                        break;
                    } else {
                        this.JNk = null;
                        break;
                    }
                }
                break;
            case WearableStatusCodes.ASSET_UNAVAILABLE:
                if (this.JNk != null) {
                    d gkE4 = d.gkE();
                    String str9 = this.JNk.hhD;
                    String str10 = this.JNk.JNn;
                    if (!gkE4.lsb || Util.isNullOrNil(str9) || Util.isNullOrNil(str10)) {
                        z2 = false;
                    } else {
                        Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord addFileDownloadCount ret:%s", Boolean.valueOf(gkE4.execSQL("WepkgPreloadFiles", String.format("update %s set %s=%s+1 where %s='%s' and %s='%s'", "WepkgPreloadFiles", "fileDownloadCount", "fileDownloadCount", "pkgId", str9, "rid", str10))));
                    }
                    this.result = z2;
                    break;
                }
                break;
            case WearableStatusCodes.DUPLICATE_CAPABILITY:
                if (this.JNk != null) {
                    d gkE5 = d.gkE();
                    String str11 = this.JNk.hhD;
                    if (!gkE5.lsb || Util.isNullOrNil(str11)) {
                        z2 = false;
                        wepkgCrossProcessTask = this;
                    } else {
                        Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord resetFileDownloadCount ret:%s", Boolean.valueOf(gkE5.execSQL("WepkgPreloadFiles", String.format("update %s set %s=0 where %s='%s'", "WepkgPreloadFiles", "fileDownloadCount", "pkgId", str11))));
                        wepkgCrossProcessTask = this;
                    }
                    wepkgCrossProcessTask.result = z2;
                    break;
                }
                break;
        }
        bDU();
        AppMethodBeat.o(110691);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjk() {
        AppMethodBeat.i(110692);
        if (this.lyv != null) {
            this.lyv.run();
        }
        AppMethodBeat.o(110692);
    }

    @Override // com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask
    public final void p(Parcel parcel) {
        AppMethodBeat.i(110693);
        this.EX = parcel.readInt();
        this.JNh = (WepkgVersion) parcel.readParcelable(WepkgVersion.class.getClassLoader());
        if (this.JNi == null) {
            this.JNi = new ArrayList();
        }
        parcel.readList(this.JNi, WepkgVersion.class.getClassLoader());
        this.JNk = (WepkgPreloadFile) parcel.readParcelable(WepkgPreloadFile.class.getClassLoader());
        if (this.JNl == null) {
            this.JNl = new ArrayList();
        }
        parcel.readList(this.JNl, WepkgPreloadFile.class.getClassLoader());
        this.JNm = parcel.readString();
        AppMethodBeat.o(110693);
    }

    @Override // com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask
    public final void a(Parcel parcel, int i2) {
        AppMethodBeat.i(110694);
        parcel.writeInt(this.EX);
        parcel.writeParcelable(this.JNh, i2);
        if (this.JNi == null) {
            this.JNi = new ArrayList();
        }
        parcel.writeList(this.JNi);
        parcel.writeParcelable(this.JNk, i2);
        if (this.JNl == null) {
            this.JNl = new ArrayList();
        }
        parcel.writeList(this.JNl);
        parcel.writeString(this.JNm);
        AppMethodBeat.o(110694);
    }

    static {
        AppMethodBeat.i(110695);
        AppMethodBeat.o(110695);
    }
}
