package com.tencent.mm.plugin.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class WepkgDownloadProcessTask extends BaseWepkgProcessTask {
    public static final Parcelable.Creator<WepkgDownloadProcessTask> CREATOR = new Parcelable.Creator<WepkgDownloadProcessTask>() {
        /* class com.tencent.mm.plugin.wepkg.model.WepkgDownloadProcessTask.AnonymousClass2 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WepkgDownloadProcessTask[] newArray(int i2) {
            return new WepkgDownloadProcessTask[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WepkgDownloadProcessTask createFromParcel(Parcel parcel) {
            AppMethodBeat.i(110697);
            WepkgDownloadProcessTask wepkgDownloadProcessTask = new WepkgDownloadProcessTask(parcel, (byte) 0);
            AppMethodBeat.o(110697);
            return wepkgDownloadProcessTask;
        }
    };
    public int JMZ;
    public String JNn;
    public long JNo;
    public WePkgDownloader.IWepkgUpdateCallback.RetCode JNp;
    public String downloadUrl;
    public String eig;
    public int fileType;
    public Runnable lyv;
    public String md5;
    public String pkgPath;
    public String version;

    /* synthetic */ WepkgDownloadProcessTask(Parcel parcel, byte b2) {
        this(parcel);
    }

    static /* synthetic */ boolean a(WepkgDownloadProcessTask wepkgDownloadProcessTask) {
        AppMethodBeat.i(110703);
        boolean bDU = wepkgDownloadProcessTask.bDU();
        AppMethodBeat.o(110703);
        return bDU;
    }

    public WepkgDownloadProcessTask() {
    }

    private WepkgDownloadProcessTask(Parcel parcel) {
        AppMethodBeat.i(110698);
        f(parcel);
        AppMethodBeat.o(110698);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjj() {
        AppMethodBeat.i(110699);
        bDJ();
        AnonymousClass1 r12 = new WePkgDownloader.IWepkgUpdateCallback() {
            /* class com.tencent.mm.plugin.wepkg.model.WepkgDownloadProcessTask.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback
            public final void a(String str, String str2, WePkgDownloader.IWepkgUpdateCallback.RetCode retCode) {
                AppMethodBeat.i(110696);
                Log.i("MicroMsg.Wepkg.WepkgDownloadProcessTask", "onPkgUpdatingCallback errCode:%s", retCode);
                WepkgDownloadProcessTask.this.eig = str;
                WepkgDownloadProcessTask.this.pkgPath = str2;
                WepkgDownloadProcessTask.this.JNp = retCode;
                WepkgDownloadProcessTask.this.bDK();
                WepkgDownloadProcessTask.a(WepkgDownloadProcessTask.this);
                AppMethodBeat.o(110696);
            }
        };
        if (this.fileType == 1) {
            WePkgDownloader.gkM().a(this.eig, r12);
            AppMethodBeat.o(110699);
            return;
        }
        WePkgDownloader.gkM().a(this.fileType, Util.nullAsNil(this.eig), "", Util.nullAsNil(this.JNn), Util.nullAsNil(this.downloadUrl), this.JNo, Util.nullAsNil(this.version), "", Util.nullAsNil(this.md5), this.JMZ, r12);
        AppMethodBeat.o(110699);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjk() {
        AppMethodBeat.i(110700);
        if (this.lyv != null) {
            this.lyv.run();
        }
        AppMethodBeat.o(110700);
    }

    @Override // com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask
    public final void p(Parcel parcel) {
        AppMethodBeat.i(110701);
        this.fileType = parcel.readInt();
        this.eig = parcel.readString();
        this.JNn = parcel.readString();
        this.downloadUrl = parcel.readString();
        this.JNo = parcel.readLong();
        this.version = parcel.readString();
        this.md5 = parcel.readString();
        this.JMZ = parcel.readInt();
        this.pkgPath = parcel.readString();
        this.JNp = (WePkgDownloader.IWepkgUpdateCallback.RetCode) parcel.readParcelable(WePkgDownloader.IWepkgUpdateCallback.RetCode.class.getClassLoader());
        AppMethodBeat.o(110701);
    }

    @Override // com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask
    public final void a(Parcel parcel, int i2) {
        AppMethodBeat.i(110702);
        parcel.writeInt(this.fileType);
        parcel.writeString(this.eig);
        parcel.writeString(this.JNn);
        parcel.writeString(this.downloadUrl);
        parcel.writeLong(this.JNo);
        parcel.writeString(this.version);
        parcel.writeString(this.md5);
        parcel.writeInt(this.JMZ);
        parcel.writeString(this.pkgPath);
        parcel.writeParcelable(this.JNp, i2);
        AppMethodBeat.o(110702);
    }

    static {
        AppMethodBeat.i(110704);
        AppMethodBeat.o(110704);
    }
}
