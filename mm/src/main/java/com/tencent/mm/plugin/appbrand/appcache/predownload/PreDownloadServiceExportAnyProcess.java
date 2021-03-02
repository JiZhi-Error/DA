package com.tencent.mm.plugin.appbrand.appcache.predownload;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J$\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000eH\u0016J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportAnyProcess;", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPreDownloadServiceExport;", "()V", "triggerPreDownload", "", ch.COL_USERNAME, "", "scene", "", "appId", "triggerPrefetchChattingItemAppBrandPiece", "triggerPrefetchChattingItemWeishiVideoFakeNative", "triggerPrefetchMallIndexWeAppLinks", "appLinks", "", "triggerPrefetchMallIndexWeAppV2", "appUsernames", "triggerPrefetchWeAppQRCode", "PreDownloadInvokeParams", "plugin-appbrand-integration_release"})
public final class PreDownloadServiceExportAnyProcess implements w {
    public static final PreDownloadServiceExportAnyProcess kOX = new PreDownloadServiceExportAnyProcess();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032*\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "data", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportAnyProcess$PreDownloadInvokeParams;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
    static final class a<InputType, ResultType> implements b<PreDownloadInvokeParams, IPCVoid> {
        public static final a kOY = new a();

        static {
            AppMethodBeat.i(228002);
            AppMethodBeat.o(228002);
        }

        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(PreDownloadInvokeParams preDownloadInvokeParams, d<IPCVoid> dVar) {
            AppMethodBeat.i(228001);
            PreDownloadInvokeParams preDownloadInvokeParams2 = preDownloadInvokeParams;
            if (preDownloadInvokeParams2 != null) {
                ((w) g.af(w.class)).bb(preDownloadInvokeParams2.username, preDownloadInvokeParams2.scene);
            }
            AppMethodBeat.o(228001);
        }
    }

    static {
        AppMethodBeat.i(228004);
        AppMethodBeat.o(228004);
    }

    private PreDownloadServiceExportAnyProcess() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportAnyProcess$PreDownloadInvokeParams;", "Landroid/os/Parcelable;", ch.COL_USERNAME, "", "scene", "", "appId", "(Ljava/lang/String;ILjava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getScene", "()I", "getUsername", "component1", "component2", "component3", "copy", "describeContents", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
    public static final class PreDownloadInvokeParams implements Parcelable {
        public static final Parcelable.Creator CREATOR = new a();
        private final String appId;
        final int scene;
        final String username;

        @l(hxD = {1, 1, 16})
        public static class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(227995);
                p.h(parcel, LocaleUtil.INDONESIAN_NEWNAME);
                PreDownloadInvokeParams preDownloadInvokeParams = new PreDownloadInvokeParams(parcel.readString(), parcel.readInt(), parcel.readString());
                AppMethodBeat.o(227995);
                return preDownloadInvokeParams;
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i2) {
                return new PreDownloadInvokeParams[i2];
            }
        }

        static {
            AppMethodBeat.i(228000);
            AppMethodBeat.o(228000);
        }

        public final int describeContents() {
            return 0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
            if (kotlin.g.b.p.j(r3.appId, r4.appId) != false) goto L_0x0028;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 227998(0x37a9e, float:3.19493E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0028
                boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.appcache.predownload.PreDownloadServiceExportAnyProcess.PreDownloadInvokeParams
                if (r0 == 0) goto L_0x002d
                com.tencent.mm.plugin.appbrand.appcache.predownload.PreDownloadServiceExportAnyProcess$PreDownloadInvokeParams r4 = (com.tencent.mm.plugin.appbrand.appcache.predownload.PreDownloadServiceExportAnyProcess.PreDownloadInvokeParams) r4
                java.lang.String r0 = r3.username
                java.lang.String r1 = r4.username
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x002d
                int r0 = r3.scene
                int r1 = r4.scene
                if (r0 != r1) goto L_0x002d
                java.lang.String r0 = r3.appId
                java.lang.String r1 = r4.appId
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x002d
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
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appcache.predownload.PreDownloadServiceExportAnyProcess.PreDownloadInvokeParams.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(227997);
            String str = this.username;
            int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.scene) * 31;
            String str2 = this.appId;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            int i3 = hashCode + i2;
            AppMethodBeat.o(227997);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(227996);
            String str = "PreDownloadInvokeParams(username=" + this.username + ", scene=" + this.scene + ", appId=" + this.appId + ")";
            AppMethodBeat.o(227996);
            return str;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(227999);
            p.h(parcel, "parcel");
            parcel.writeString(this.username);
            parcel.writeInt(this.scene);
            parcel.writeString(this.appId);
            AppMethodBeat.o(227999);
        }

        public /* synthetic */ PreDownloadInvokeParams(String str, int i2) {
            this(str, i2, null);
        }

        public PreDownloadInvokeParams(String str, int i2, String str2) {
            this.username = str;
            this.scene = i2;
            this.appId = str2;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.service.w
    public final void bb(String str, int i2) {
        AppMethodBeat.i(228003);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(228003);
            return;
        }
        com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new PreDownloadInvokeParams(str, i2), a.kOY, null);
        AppMethodBeat.o(228003);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.w
    public final void bg(List<String> list) {
    }

    @Override // com.tencent.mm.plugin.appbrand.service.w
    public final void bh(List<String> list) {
    }

    @Override // com.tencent.mm.plugin.appbrand.service.w
    public final void VA(String str) {
    }

    @Override // com.tencent.mm.plugin.appbrand.service.w
    public final void bwL() {
    }
}
