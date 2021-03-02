package com.tencent.mm.plugin.appbrand.launching;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.bmm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0012Jf\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001e\u0010\u0006\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0006\u0012\u0004\u0018\u00010\t0\bj\u0002`\n\u0012\u0004\u0012\u00020\u00030\u00072\"\b\u0002\u0010\u000b\u001a\u001c\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u00030\f2\b\b\u0002\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "", "waitForDownloadUrl", "", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "onSuccess", "Lkotlin/Function1;", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "Lcom/tencent/mm/plugin/appbrand/launching/LocalUnifiedGetDownloadUrlResp;", "onError", "Lkotlin/Function3;", "", "", "scene", "cgiCommRequestSource", "Lcom/tencent/mm/protocal/protobuf/CommRequestSource;", "LocalUnifiedGetDownloadUrlRequest", "plugin-appbrand-integration_release"})
public interface y {
    void a(b bVar, kotlin.g.a.b<? super bmm[], x> bVar2, q<? super Integer, ? super Integer, ? super String, x> qVar, int i2, acc acc);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001-B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u0000H\u0002J\u0013\u0010)\u001a\u00020\u00192\b\u0010(\u001a\u0004\u0018\u00010*H\u0002J\b\u0010+\u001a\u00020\nH\u0016J\b\u0010,\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001a\u0010!\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001a\u0010$\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000e¨\u0006."}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "appVersion", "", "getAppVersion", "()I", "setAppVersion", "(I)V", "localPkgEncryptVersion", "getLocalPkgEncryptVersion", "setLocalPkgEncryptVersion", "localPkgVersion", "getLocalPkgVersion", "setLocalPkgVersion", "moduleName", "getModuleName", "setModuleName", "needLatestVersion", "", "getNeedLatestVersion", "()Z", "setNeedLatestVersion", "(Z)V", "packageType", "getPackageType", "setPackageType", "supportEncryptVersion", "getSupportEncryptVersion", "setSupportEncryptVersion", "versionType", "getVersionType", "setVersionType", "compareTo", FacebookRequestErrorClassification.KEY_OTHER, "equals", "", "hashCode", "toString", "Companion", "plugin-appbrand-integration_release"})
    public static final class b implements Comparable<b> {
        @Deprecated
        public static final a mUy = new a((byte) 0);
        String appId = "";
        int appVersion;
        String cBp;
        int iOo;
        int mUu;
        int mUv;
        int mUw;
        boolean mUx;
        int packageType;

        static {
            AppMethodBeat.i(180587);
            AppMethodBeat.o(180587);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
        static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(b bVar) {
            int i2;
            AppMethodBeat.i(180583);
            b bVar2 = bVar;
            p.h(bVar2, FacebookRequestErrorClassification.KEY_OTHER);
            b bVar3 = this;
            if (!p.j(bVar3.appId, bVar2.appId)) {
                i2 = bVar3.appId.compareTo(bVar2.appId);
            } else if (!p.j(Util.nullAsNil(bVar3.cBp), Util.nullAsNil(bVar2.cBp))) {
                String nullAsNil = Util.nullAsNil(bVar3.cBp);
                String nullAsNil2 = Util.nullAsNil(bVar2.cBp);
                p.g(nullAsNil2, "Util.nullAsNil(other.moduleName)");
                i2 = nullAsNil.compareTo(nullAsNil2);
            } else if (bVar3.packageType != bVar2.packageType) {
                i2 = p.compare(bVar3.packageType, bVar2.packageType);
            } else if (bVar3.iOo != bVar2.iOo) {
                i2 = p.compare(bVar3.iOo, bVar2.iOo);
            } else if (bVar3.mUx != bVar2.mUx) {
                i2 = p.compare(bVar3.mUx ? 1 : 0, bVar2.mUx ? 1 : 0);
            } else if (bVar3.appVersion != bVar2.appVersion) {
                i2 = p.compare(bVar3.appVersion, bVar2.appVersion);
            } else if (bVar3.mUu != bVar2.mUu) {
                i2 = p.compare(bVar3.mUu, bVar2.mUu);
            } else if (bVar3.mUv != bVar2.mUv) {
                i2 = p.compare(bVar3.mUv, bVar2.mUv);
            } else if (bVar3.mUw != bVar2.mUw) {
                i2 = p.compare(bVar3.mUw, bVar2.mUw);
            } else {
                i2 = 0;
            }
            Log.i("IGetDownloadUrlCgiExecutor.LocalUnifiedGetDownloadUrlRequest", "request.compareTo=" + i2 + ", this=" + this + ", other=" + bVar2);
            AppMethodBeat.o(180583);
            return i2;
        }

        public final void setAppId(String str) {
            AppMethodBeat.i(180582);
            p.h(str, "<set-?>");
            this.appId = str;
            AppMethodBeat.o(180582);
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(180584);
            if (!(obj instanceof b) || !(this == obj || hashCode() == obj.hashCode())) {
                AppMethodBeat.o(180584);
                return false;
            }
            AppMethodBeat.o(180584);
            return true;
        }

        public final int hashCode() {
            AppMethodBeat.i(180585);
            int hashCode = toString().hashCode();
            AppMethodBeat.o(180585);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(180586);
            String str = "LocalUnifiedGetDownloadUrlRequest(appId='" + this.appId + "', moduleName=" + this.cBp + ", packageType=" + this.packageType + ", versionType=" + this.iOo + ", appVersion=" + this.appVersion + ", supportEncryptVersion=" + this.mUu + ", localPkgVersion=" + this.mUv + ", localPkgEncryptVersion=" + this.mUw + ", needLatestVersion=" + this.mUx + ')';
            AppMethodBeat.o(180586);
            return str;
        }
    }

    @l(hxD = {1, 1, 16})
    public static final class a {
        public static /* synthetic */ void a(y yVar, b bVar, kotlin.g.a.b bVar2, q qVar, acc acc) {
            AppMethodBeat.i(228661);
            yVar.a(bVar, bVar2, qVar, 0, acc);
            AppMethodBeat.o(228661);
        }
    }
}
