package com.tencent.mm.plugin.appbrand.appcache.predownload.export;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.predownload.export.b;
import com.tencent.mm.plugin.appbrand.service.u;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u0011\u0012\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J.\u0010\u000b\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgDownloaderExportServiceIPC;", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPkgDownloaderExportService;", "()V", "TAG", "", "registerPkgSpecs", "", "appUsername", "appId", "visitScene", "", "startDownloadPkg", "versionType", "onSuccess", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPkgDownloaderExportService$OnDownloadSuccessListener;", "onError", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPkgDownloaderExportService$OnDownloadErrorListener;", "DownloadPkgParam", "DownloadPkgResult", "RegisterPkgSpecs", "plugin-appbrand-integration_release"})
public final class WxaPkgDownloaderExportServiceIPC implements u {
    public static final WxaPkgDownloaderExportServiceIPC kQa = new WxaPkgDownloaderExportServiceIPC();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032*\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "data", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgDownloaderExportServiceIPC$RegisterPkgSpecs;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
    static final class a<InputType, ResultType> implements com.tencent.mm.ipcinvoker.b<RegisterPkgSpecs, IPCVoid> {
        public static final a kQc = new a();

        static {
            AppMethodBeat.i(228065);
            AppMethodBeat.o(228065);
        }

        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(RegisterPkgSpecs registerPkgSpecs, d<IPCVoid> dVar) {
            AppMethodBeat.i(228064);
            RegisterPkgSpecs registerPkgSpecs2 = registerPkgSpecs;
            String str = registerPkgSpecs2.username;
            String str2 = registerPkgSpecs2.appId;
            int i2 = registerPkgSpecs2.scene;
            try {
                b.a aVar = b.kQg;
                b.a.bwT().r(str, str2, i2);
            } catch (Exception e2) {
                Log.e("MicroMsg.WxaPkgDownloaderExportServiceIPC", "registerPkgSpecs(username:" + str + ", appId:" + str2 + ", scene:" + i2 + ") get exception:" + e2);
            }
            if (dVar != null) {
                com.tencent.mm.ipcinvoker.wx_extension.b.a.a(dVar);
                AppMethodBeat.o(228064);
                return;
            }
            AppMethodBeat.o(228064);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032*\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "data", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgDownloaderExportServiceIPC$DownloadPkgParam;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgDownloaderExportServiceIPC$DownloadPkgResult;", "invoke"})
    static final class b<InputType, ResultType> implements com.tencent.mm.ipcinvoker.b<DownloadPkgParam, DownloadPkgResult> {
        public static final b kQd = new b();

        static {
            AppMethodBeat.i(228069);
            AppMethodBeat.o(228069);
        }

        b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(DownloadPkgParam downloadPkgParam, final d<DownloadPkgResult> dVar) {
            AppMethodBeat.i(228068);
            DownloadPkgParam downloadPkgParam2 = downloadPkgParam;
            String str = downloadPkgParam2.appId;
            int i2 = downloadPkgParam2.iOo;
            try {
                b.a aVar = b.kQg;
                b.a.bwT().a(str, i2, new u.b() {
                    /* class com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgDownloaderExportServiceIPC.b.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.appbrand.service.u.b
                    public final /* synthetic */ void a(bd bdVar, String str) {
                        AppMethodBeat.i(228066);
                        p.h(bdVar, "record");
                        p.h(str, "filePath");
                        d dVar = dVar;
                        if (dVar != null) {
                            dVar.bn(new DownloadPkgResult(true, bdVar.convertTo(), str, 0, null, 24));
                            AppMethodBeat.o(228066);
                            return;
                        }
                        AppMethodBeat.o(228066);
                    }
                }, new u.a() {
                    /* class com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgDownloaderExportServiceIPC.b.AnonymousClass2 */

                    @Override // com.tencent.mm.plugin.appbrand.service.u.a
                    public final /* synthetic */ void onError(int i2, String str) {
                        AppMethodBeat.i(228067);
                        d dVar = dVar;
                        if (dVar != null) {
                            dVar.bn(new DownloadPkgResult(false, null, null, i2, str, 6));
                            AppMethodBeat.o(228067);
                            return;
                        }
                        AppMethodBeat.o(228067);
                    }
                });
                AppMethodBeat.o(228068);
            } catch (Exception e2) {
                Log.e("MicroMsg.WxaPkgDownloaderExportServiceIPC", "startDownloadPkg(appId:" + str + ", versionType:" + i2 + ") get exception:" + e2);
                if (dVar != null) {
                    dVar.bn(new DownloadPkgResult(false, null, null, -1, "Exception{" + e2 + '}', 6));
                    AppMethodBeat.o(228068);
                    return;
                }
                AppMethodBeat.o(228068);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgDownloaderExportServiceIPC$DownloadPkgResult;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class c<T> implements d<DownloadPkgResult> {
        final /* synthetic */ u.b kQe;
        final /* synthetic */ u.a kQf;

        c(u.b bVar, u.a aVar) {
            this.kQe = bVar;
            this.kQf = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(DownloadPkgResult downloadPkgResult) {
            AppMethodBeat.i(228070);
            DownloadPkgResult downloadPkgResult2 = downloadPkgResult;
            if (downloadPkgResult2.isSuccess) {
                bd bdVar = new bd();
                a aVar = a.kPZ;
                bd bdVar2 = bdVar;
                ContentValues contentValues = downloadPkgResult2.kQb;
                if (contentValues == null) {
                    p.hyc();
                }
                a.a(bdVar2, contentValues);
                String str = downloadPkgResult2.filePath;
                if (str == null) {
                    p.hyc();
                }
                u.b bVar = this.kQe;
                if (bVar != null) {
                    bVar.a(bdVar, str);
                    AppMethodBeat.o(228070);
                    return;
                }
                AppMethodBeat.o(228070);
                return;
            }
            u.a aVar2 = this.kQf;
            if (aVar2 != null) {
                aVar2.onError(downloadPkgResult2.errCode, downloadPkgResult2.errMsg);
                AppMethodBeat.o(228070);
                return;
            }
            AppMethodBeat.o(228070);
        }
    }

    static {
        AppMethodBeat.i(228073);
        AppMethodBeat.o(228073);
    }

    private WxaPkgDownloaderExportServiceIPC() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgDownloaderExportServiceIPC$DownloadPkgParam;", "Landroid/os/Parcelable;", "appId", "", "versionType", "", "(Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "getVersionType", "()I", "component1", "component2", "copy", "describeContents", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
    public static final class DownloadPkgParam implements Parcelable {
        public static final Parcelable.Creator CREATOR = new a();
        final String appId;
        final int iOo;

        @l(hxD = {1, 1, 16})
        public static class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(228044);
                p.h(parcel, LocaleUtil.INDONESIAN_NEWNAME);
                DownloadPkgParam downloadPkgParam = new DownloadPkgParam(parcel.readString(), parcel.readInt());
                AppMethodBeat.o(228044);
                return downloadPkgParam;
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i2) {
                return new DownloadPkgParam[i2];
            }
        }

        static {
            AppMethodBeat.i(228049);
            AppMethodBeat.o(228049);
        }

        public final int describeContents() {
            return 0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
            if (r3.iOo == r4.iOo) goto L_0x001e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 228047(0x37acf, float:3.19562E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x001e
                boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgDownloaderExportServiceIPC.DownloadPkgParam
                if (r0 == 0) goto L_0x0023
                com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgDownloaderExportServiceIPC$DownloadPkgParam r4 = (com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgDownloaderExportServiceIPC.DownloadPkgParam) r4
                java.lang.String r0 = r3.appId
                java.lang.String r1 = r4.appId
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0023
                int r0 = r3.iOo
                int r1 = r4.iOo
                if (r0 != r1) goto L_0x0023
            L_0x001e:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0022:
                return r0
            L_0x0023:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0022
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgDownloaderExportServiceIPC.DownloadPkgParam.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(228046);
            String str = this.appId;
            int hashCode = ((str != null ? str.hashCode() : 0) * 31) + this.iOo;
            AppMethodBeat.o(228046);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(228045);
            String str = "DownloadPkgParam(appId=" + this.appId + ", versionType=" + this.iOo + ")";
            AppMethodBeat.o(228045);
            return str;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(228048);
            p.h(parcel, "parcel");
            parcel.writeString(this.appId);
            parcel.writeInt(this.iOo);
            AppMethodBeat.o(228048);
        }

        public DownloadPkgParam(String str, int i2) {
            this.appId = str;
            this.iOo = i2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003JA\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\tHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\tHÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgDownloaderExportServiceIPC$DownloadPkgResult;", "Landroid/os/Parcelable;", "isSuccess", "", "recordContentValues", "Landroid/content/ContentValues;", "filePath", "", "errCode", "", "errMsg", "(ZLandroid/content/ContentValues;Ljava/lang/String;ILjava/lang/String;)V", "getErrCode", "()I", "getErrMsg", "()Ljava/lang/String;", "getFilePath", "()Z", "getRecordContentValues", "()Landroid/content/ContentValues;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
    public static final class DownloadPkgResult implements Parcelable {
        public static final Parcelable.Creator CREATOR = new a();
        final int errCode;
        final String errMsg;
        final String filePath;
        final boolean isSuccess;
        final ContentValues kQb;

        @l(hxD = {1, 1, 16})
        public static class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(228050);
                p.h(parcel, LocaleUtil.INDONESIAN_NEWNAME);
                DownloadPkgResult downloadPkgResult = new DownloadPkgResult(parcel.readInt() != 0, parcel.readInt() != 0 ? (ContentValues) ContentValues.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readInt(), parcel.readString());
                AppMethodBeat.o(228050);
                return downloadPkgResult;
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i2) {
                return new DownloadPkgResult[i2];
            }
        }

        static {
            AppMethodBeat.i(228056);
            AppMethodBeat.o(228056);
        }

        public final int describeContents() {
            return 0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
            if (kotlin.g.b.p.j(r3.errMsg, r4.errMsg) != false) goto L_0x0038;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 228054(0x37ad6, float:3.19572E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0038
                boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgDownloaderExportServiceIPC.DownloadPkgResult
                if (r0 == 0) goto L_0x003d
                com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgDownloaderExportServiceIPC$DownloadPkgResult r4 = (com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgDownloaderExportServiceIPC.DownloadPkgResult) r4
                boolean r0 = r3.isSuccess
                boolean r1 = r4.isSuccess
                if (r0 != r1) goto L_0x003d
                android.content.ContentValues r0 = r3.kQb
                android.content.ContentValues r1 = r4.kQb
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x003d
                java.lang.String r0 = r3.filePath
                java.lang.String r1 = r4.filePath
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x003d
                int r0 = r3.errCode
                int r1 = r4.errCode
                if (r0 != r1) goto L_0x003d
                java.lang.String r0 = r3.errMsg
                java.lang.String r1 = r4.errMsg
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x003d
            L_0x0038:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x003c:
                return r0
            L_0x003d:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x003c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgDownloaderExportServiceIPC.DownloadPkgResult.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(228053);
            boolean z = this.isSuccess;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = i3 * 31;
            ContentValues contentValues = this.kQb;
            int hashCode = ((contentValues != null ? contentValues.hashCode() : 0) + i6) * 31;
            String str = this.filePath;
            int hashCode2 = ((((str != null ? str.hashCode() : 0) + hashCode) * 31) + this.errCode) * 31;
            String str2 = this.errMsg;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            int i7 = hashCode2 + i2;
            AppMethodBeat.o(228053);
            return i7;
        }

        public final String toString() {
            AppMethodBeat.i(228052);
            String str = "DownloadPkgResult(isSuccess=" + this.isSuccess + ", recordContentValues=" + this.kQb + ", filePath=" + this.filePath + ", errCode=" + this.errCode + ", errMsg=" + this.errMsg + ")";
            AppMethodBeat.o(228052);
            return str;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(228055);
            p.h(parcel, "parcel");
            parcel.writeInt(this.isSuccess ? 1 : 0);
            ContentValues contentValues = this.kQb;
            if (contentValues != null) {
                parcel.writeInt(1);
                contentValues.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeString(this.filePath);
            parcel.writeInt(this.errCode);
            parcel.writeString(this.errMsg);
            AppMethodBeat.o(228055);
        }

        public DownloadPkgResult(boolean z, ContentValues contentValues, String str, int i2, String str2) {
            this.isSuccess = z;
            this.kQb = contentValues;
            this.filePath = str;
            this.errCode = i2;
            this.errMsg = str2;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ DownloadPkgResult(boolean r8, android.content.ContentValues r9, java.lang.String r10, int r11, java.lang.String r12, int r13) {
            /*
                r7 = this;
                r6 = 228051(0x37ad3, float:3.19568E-40)
                r5 = 0
                r0 = r13 & 2
                if (r0 == 0) goto L_0x0029
                r2 = r5
            L_0x0009:
                r0 = r13 & 4
                if (r0 == 0) goto L_0x0027
                r3 = r5
            L_0x000e:
                r0 = r13 & 8
                if (r0 == 0) goto L_0x0025
                r4 = -1
            L_0x0013:
                r0 = r13 & 16
                if (r0 == 0) goto L_0x0023
            L_0x0017:
                r0 = r7
                r1 = r8
                r0.<init>(r1, r2, r3, r4, r5)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                return
            L_0x0023:
                r5 = r12
                goto L_0x0017
            L_0x0025:
                r4 = r11
                goto L_0x0013
            L_0x0027:
                r3 = r10
                goto L_0x000e
            L_0x0029:
                r2 = r9
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgDownloaderExportServiceIPC.DownloadPkgResult.<init>(boolean, android.content.ContentValues, java.lang.String, int, java.lang.String, int):void");
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.service.u
    public final void a(String str, int i2, u.b bVar, u.a aVar) {
        AppMethodBeat.i(228071);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            aVar.onError(-1, "invalid appId");
            AppMethodBeat.o(228071);
            return;
        }
        com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new DownloadPkgParam(str, i2), b.kQd, new c(bVar, aVar));
        AppMethodBeat.o(228071);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgDownloaderExportServiceIPC$RegisterPkgSpecs;", "Landroid/os/Parcelable;", ch.COL_USERNAME, "", "appId", "scene", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "getScene", "()I", "getUsername", "component1", "component2", "component3", "copy", "describeContents", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
    public static final class RegisterPkgSpecs implements Parcelable {
        public static final Parcelable.Creator CREATOR = new a();
        final String appId;
        final int scene;
        final String username;

        @l(hxD = {1, 1, 16})
        public static class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(228057);
                p.h(parcel, LocaleUtil.INDONESIAN_NEWNAME);
                RegisterPkgSpecs registerPkgSpecs = new RegisterPkgSpecs(parcel.readString(), parcel.readString(), parcel.readInt());
                AppMethodBeat.o(228057);
                return registerPkgSpecs;
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i2) {
                return new RegisterPkgSpecs[i2];
            }
        }

        static {
            AppMethodBeat.i(228063);
            AppMethodBeat.o(228063);
        }

        public final int describeContents() {
            return 0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
            if (r3.scene == r4.scene) goto L_0x0028;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 228061(0x37add, float:3.19582E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0028
                boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgDownloaderExportServiceIPC.RegisterPkgSpecs
                if (r0 == 0) goto L_0x002d
                com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgDownloaderExportServiceIPC$RegisterPkgSpecs r4 = (com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgDownloaderExportServiceIPC.RegisterPkgSpecs) r4
                java.lang.String r0 = r3.username
                java.lang.String r1 = r4.username
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x002d
                java.lang.String r0 = r3.appId
                java.lang.String r1 = r4.appId
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x002d
                int r0 = r3.scene
                int r1 = r4.scene
                if (r0 != r1) goto L_0x002d
            L_0x0028:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x002c:
                return r0
            L_0x002d:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x002c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgDownloaderExportServiceIPC.RegisterPkgSpecs.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(228060);
            String str = this.username;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.appId;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            int i3 = ((hashCode + i2) * 31) + this.scene;
            AppMethodBeat.o(228060);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(228059);
            String str = "RegisterPkgSpecs(username=" + this.username + ", appId=" + this.appId + ", scene=" + this.scene + ")";
            AppMethodBeat.o(228059);
            return str;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(228062);
            p.h(parcel, "parcel");
            parcel.writeString(this.username);
            parcel.writeString(this.appId);
            parcel.writeInt(this.scene);
            AppMethodBeat.o(228062);
        }

        public RegisterPkgSpecs(String str, String str2, int i2) {
            p.h(str, ch.COL_USERNAME);
            p.h(str2, "appId");
            AppMethodBeat.i(228058);
            this.username = str;
            this.appId = str2;
            this.scene = i2;
            AppMethodBeat.o(228058);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.service.u
    public final void r(String str, String str2, int i2) {
        AppMethodBeat.i(228072);
        String str3 = str;
        if (!(str3 == null || str3.length() == 0)) {
            String str4 = str2;
            if (!(str4 == null || str4.length() == 0)) {
                com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new RegisterPkgSpecs(str, str2, i2), a.kQc, null);
                AppMethodBeat.o(228072);
                return;
            }
        }
        AppMethodBeat.o(228072);
    }
}
