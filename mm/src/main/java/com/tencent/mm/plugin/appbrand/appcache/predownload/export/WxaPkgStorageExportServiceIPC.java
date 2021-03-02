package com.tencent.mm.plugin.appbrand.appcache.predownload.export;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.predownload.export.c;
import com.tencent.mm.plugin.appbrand.service.v;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J$\u0010\u000b\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceIPC;", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPkgStorageExportService;", "()V", "TAG", "", "getPkgRecord", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestRecord;", "appId", "versionType", "", "version", "insertPkg", "", "filePath", "setPkgIsOccupied", "", "PkgParams", "plugin-appbrand-integration_release"})
public final class WxaPkgStorageExportServiceIPC implements v {
    public static final WxaPkgStorageExportServiceIPC kQn = new WxaPkgStorageExportServiceIPC();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Landroid/content/ContentValues;", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceIPC$PkgParams;", "kotlin.jvm.PlatformType", "invoke"})
    public static final class a<InputType, ResultType> implements k<PkgParams, ContentValues> {
        public static final a kQo = new a();

        static {
            AppMethodBeat.i(228093);
            AppMethodBeat.o(228093);
        }

        a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ ContentValues invoke(PkgParams pkgParams) {
            AppMethodBeat.i(228092);
            PkgParams pkgParams2 = pkgParams;
            String str = pkgParams2.appId;
            int i2 = pkgParams2.iOo;
            int i3 = pkgParams2.version;
            c.a aVar = c.kQs;
            bd H = c.a.bwU().H(str, i2, i3);
            if (H == null) {
                AppMethodBeat.o(228092);
                return null;
            }
            ContentValues convertTo = H.convertTo();
            AppMethodBeat.o(228092);
            return convertTo;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceIPC$PkgParams;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b<InputType, ResultType> implements k<PkgParams, IPCBoolean> {
        public static final b kQp = new b();

        static {
            AppMethodBeat.i(228095);
            AppMethodBeat.o(228095);
        }

        b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCBoolean invoke(PkgParams pkgParams) {
            AppMethodBeat.i(228094);
            PkgParams pkgParams2 = pkgParams;
            String str = pkgParams2.appId;
            int i2 = pkgParams2.version;
            String str2 = pkgParams2.filePath;
            c.a aVar = c.kQs;
            IPCBoolean iPCBoolean = new IPCBoolean(c.a.bwU().s(str, i2, str2));
            AppMethodBeat.o(228094);
            return iPCBoolean;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032*\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "data", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceIPC$PkgParams;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
    static final class c<InputType, ResultType> implements com.tencent.mm.ipcinvoker.b<PkgParams, IPCVoid> {
        public static final c kQq = new c();

        static {
            AppMethodBeat.i(228097);
            AppMethodBeat.o(228097);
        }

        c() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(PkgParams pkgParams, d<IPCVoid> dVar) {
            AppMethodBeat.i(228096);
            PkgParams pkgParams2 = pkgParams;
            String str = pkgParams2.appId;
            int i2 = pkgParams2.iOo;
            c.a aVar = c.kQs;
            c.a.bwU().bc(str, i2);
            if (dVar != null) {
                com.tencent.mm.ipcinvoker.wx_extension.b.a.a(dVar);
                AppMethodBeat.o(228096);
                return;
            }
            AppMethodBeat.o(228096);
        }
    }

    static {
        AppMethodBeat.i(228102);
        AppMethodBeat.o(228102);
    }

    private WxaPkgStorageExportServiceIPC() {
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceIPC$PkgParams;", "Landroid/os/Parcelable;", "appId", "", "versionType", "", "version", "filePath", "(Ljava/lang/String;IILjava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getFilePath", "getVersion", "()I", "getVersionType", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
    public static final class PkgParams implements Parcelable {
        public static final Parcelable.Creator CREATOR = new a();
        final String appId;
        final String filePath;
        final int iOo;
        final int version;

        @l(hxD = {1, 1, 16})
        public static class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(228084);
                p.h(parcel, LocaleUtil.INDONESIAN_NEWNAME);
                PkgParams pkgParams = new PkgParams(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString());
                AppMethodBeat.o(228084);
                return pkgParams;
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i2) {
                return new PkgParams[i2];
            }
        }

        static {
            AppMethodBeat.i(228091);
            AppMethodBeat.o(228091);
        }

        public final int describeContents() {
            return 0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
            if (kotlin.g.b.p.j(r3.filePath, r4.filePath) != false) goto L_0x002e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 228089(0x37af9, float:3.19621E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x002e
                boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgStorageExportServiceIPC.PkgParams
                if (r0 == 0) goto L_0x0033
                com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgStorageExportServiceIPC$PkgParams r4 = (com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgStorageExportServiceIPC.PkgParams) r4
                java.lang.String r0 = r3.appId
                java.lang.String r1 = r4.appId
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0033
                int r0 = r3.iOo
                int r1 = r4.iOo
                if (r0 != r1) goto L_0x0033
                int r0 = r3.version
                int r1 = r4.version
                if (r0 != r1) goto L_0x0033
                java.lang.String r0 = r3.filePath
                java.lang.String r1 = r4.filePath
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0033
            L_0x002e:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0032:
                return r0
            L_0x0033:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0032
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgStorageExportServiceIPC.PkgParams.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(228088);
            String str = this.appId;
            int hashCode = (((((str != null ? str.hashCode() : 0) * 31) + this.iOo) * 31) + this.version) * 31;
            String str2 = this.filePath;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            int i3 = hashCode + i2;
            AppMethodBeat.o(228088);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(228087);
            String str = "PkgParams(appId=" + this.appId + ", versionType=" + this.iOo + ", version=" + this.version + ", filePath=" + this.filePath + ")";
            AppMethodBeat.o(228087);
            return str;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(228090);
            p.h(parcel, "parcel");
            parcel.writeString(this.appId);
            parcel.writeInt(this.iOo);
            parcel.writeInt(this.version);
            parcel.writeString(this.filePath);
            AppMethodBeat.o(228090);
        }

        public PkgParams(String str, int i2, int i3, String str2) {
            p.h(str, "appId");
            AppMethodBeat.i(228085);
            this.appId = str;
            this.iOo = i2;
            this.version = i3;
            this.filePath = str2;
            AppMethodBeat.o(228085);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PkgParams(String str, int i2, int i3, int i4) {
            this(str, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3, (String) null);
            AppMethodBeat.i(228086);
            AppMethodBeat.o(228086);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.service.v
    public final boolean s(String str, int i2, String str2) {
        boolean z;
        AppMethodBeat.i(228098);
        String str3 = str;
        if (str3 == null || str3.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            String str4 = str2;
            if (!(str4 == null || str4.length() == 0)) {
                IPCBoolean iPCBoolean = (IPCBoolean) com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new PkgParams(str, 0, i2, str2), b.kQp);
                if (iPCBoolean == null || !iPCBoolean.value) {
                    AppMethodBeat.o(228098);
                    return false;
                }
                AppMethodBeat.o(228098);
                return true;
            }
        }
        Log.e("MicroMsg.WxaPkgStorageExportIPC", "insertPkg, invalid args: appId:" + str + ", version:" + i2 + ", filePath:" + str2);
        AppMethodBeat.o(228098);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.v
    public final bd VF(String str) {
        AppMethodBeat.i(228099);
        bd H = H(str, 0, 0);
        AppMethodBeat.o(228099);
        return H;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.v
    public final bd H(String str, int i2, int i3) {
        AppMethodBeat.i(228100);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(228100);
            return null;
        }
        ContentValues contentValues = (ContentValues) com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new PkgParams(str, i2, i3, 8), a.kQo);
        if (contentValues != null) {
            bd bdVar = new bd();
            a aVar = a.kPZ;
            a.a(bdVar, contentValues);
            AppMethodBeat.o(228100);
            return bdVar;
        }
        AppMethodBeat.o(228100);
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.v
    public final void bc(String str, int i2) {
        AppMethodBeat.i(228101);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(228101);
            return;
        }
        com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new PkgParams(str, 0, i2, 10), c.kQq, null);
        AppMethodBeat.o(228101);
    }
}
