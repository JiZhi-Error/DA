package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.bn;
import com.tencent.mm.plugin.appbrand.appcache.r;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.launching.l;
import com.tencent.mm.plugin.appbrand.launching.v;
import com.tencent.mm.plugin.appbrand.p.e;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u00012\u00020\u0002:\u0004\u000f\u0010\u0011\u0012B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible;", "Lcom/tencent/mm/plugin/appbrand/modularizing/ModularizingPkgRetriever;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "requestedModuleName", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/plugin/appbrand/modularizing/ModularizingPkgRetriever$RetrieveCallbackEx;", "dead", "", "setCallback", "Lcom/tencent/mm/plugin/appbrand/modularizing/ModularizingPkgRetriever$RetrieveCallback;", "start", "Companion", "IPCCallParams", "IPCCallResult", "IPCCallTask", "plugin-appbrand-integration_release"})
public final class ModularizingPkgRetrieverSeparatedPluginsCompatible implements e, com.tencent.mm.vending.e.a {
    public static final a mWg = new a((byte) 0);
    private AppBrandRuntime cBW;
    private e.b mWe;
    private final String mWf;

    static {
        AppMethodBeat.i(180638);
        AppMethodBeat.o(180638);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "callbackResult", "Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class c<T> implements d<ResultType> {
        final /* synthetic */ ModularizingPkgRetrieverSeparatedPluginsCompatible mWo;

        c(ModularizingPkgRetrieverSeparatedPluginsCompatible modularizingPkgRetrieverSeparatedPluginsCompatible) {
            this.mWo = modularizingPkgRetrieverSeparatedPluginsCompatible;
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(Object obj) {
            AppMethodBeat.i(180635);
            final IPCCallResult iPCCallResult = (IPCCallResult) obj;
            try {
                switch (iPCCallResult.mWj) {
                    case 1:
                        e.b bVar = this.mWo.mWe;
                        if (bVar != null) {
                            WxaPkgLoadProgress wxaPkgLoadProgress = iPCCallResult.mWk;
                            if (wxaPkgLoadProgress == null) {
                                p.hyc();
                            }
                            bVar.a(wxaPkgLoadProgress);
                            AppMethodBeat.o(180635);
                            return;
                        }
                        AppMethodBeat.o(180635);
                        return;
                    case 2:
                        e.b bVar2 = this.mWo.mWe;
                        if (bVar2 != null) {
                            bVar2.a(new android.arch.a.c.a<AppBrandRuntime, Boolean>(this) {
                                /* class com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverSeparatedPluginsCompatible.c.AnonymousClass1 */
                                final /* synthetic */ c mWp;

                                {
                                    this.mWp = r1;
                                }

                                /* Return type fixed from 'java.lang.Object' to match base method */
                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                @Override // android.arch.a.c.a
                                public final /* synthetic */ Boolean apply(AppBrandRuntime appBrandRuntime) {
                                    String str;
                                    AppMethodBeat.i(180634);
                                    AppBrandRuntime appBrandRuntime2 = appBrandRuntime;
                                    StringBuilder sb = new StringBuilder("onResultCustomAction, appId:");
                                    if (appBrandRuntime2 != null) {
                                        str = appBrandRuntime2.getAppId();
                                    } else {
                                        str = null;
                                    }
                                    Log.i("MicroMsg.AppBrand.ModularizingPkgRetrieverSeparatedPluginsCompatible", sb.append(str).append(", module:").append(this.mWp.mWo.mWf).append(", succeed:").append(iPCCallResult.dVA).toString());
                                    if (iPCCallResult.dVA) {
                                        bn.a aVar = bn.kOt;
                                        p.g(appBrandRuntime2, "rt");
                                        bn O = bn.a.O(appBrandRuntime2);
                                        if (O != null) {
                                            List<? extends IPkgInfo> list = iPCCallResult.mWl;
                                            if (list == null) {
                                                p.hyc();
                                            }
                                            p.h(list, "_pkgList");
                                            if (!O.closed) {
                                                O.t(new bn.i(O, new LinkedList(list)));
                                            }
                                        }
                                        Boolean bool = Boolean.TRUE;
                                        AppMethodBeat.o(180634);
                                        return bool;
                                    }
                                    Boolean bool2 = Boolean.FALSE;
                                    AppMethodBeat.o(180634);
                                    return bool2;
                                }
                            });
                            AppMethodBeat.o(180635);
                            return;
                        }
                        AppMethodBeat.o(180635);
                        return;
                    default:
                        AppMethodBeat.o(180635);
                        return;
                }
            } catch (Throwable th) {
                Log.e("MicroMsg.AppBrand.ModularizingPkgRetrieverSeparatedPluginsCompatible", "IPCCallTask.onCallback t=".concat(String.valueOf(th)));
                h.RTc.aV(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverSeparatedPluginsCompatible.c.AnonymousClass2 */

                    public final void run() {
                        throw th;
                    }
                });
                AppMethodBeat.o(180635);
            }
        }
    }

    public ModularizingPkgRetrieverSeparatedPluginsCompatible(AppBrandRuntime appBrandRuntime, String str) {
        p.h(appBrandRuntime, "rt");
        p.h(str, "requestedModuleName");
        AppMethodBeat.i(180637);
        this.mWf = str;
        this.cBW = appBrandRuntime;
        AppMethodBeat.o(180637);
    }

    @Override // com.tencent.mm.plugin.appbrand.p.e
    public final void a(e.a aVar) {
        this.mWe = (e.b) aVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.p.e
    public final void start() {
        AppMethodBeat.i(180636);
        String str = MainProcessIPCService.dkO;
        AppBrandRuntime appBrandRuntime = this.cBW;
        if (appBrandRuntime == null) {
            p.hyc();
        }
        XIPCInvoker.a(str, new IPCCallParams(appBrandRuntime, this.mWf), b.class, new c(this));
        AppMethodBeat.o(180636);
    }

    @Override // com.tencent.mm.vending.e.a
    public final void dead() {
        this.cBW = null;
        this.mWe = null;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 <2\u00020\u0001:\u0001<B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tBY\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0011¢\u0006\u0002\u0010\u0018J\b\u00107\u001a\u00020\fH\u0016J\u0018\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\fH\u0016R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\n\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010!\"\u0004\b$\u0010#R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\u0017\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010!\"\u0004\b,\u0010#R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u0010\r\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010.\"\u0004\b2\u00100R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006="}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallParams;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "moduleName", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;)V", "appId", "version", "", "versionType", "wxaVersionInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "isGame", "", "isFromRemoteDebug", "acceptedLibReader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "reportQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "underPreRenderMode", "(Ljava/lang/String;Ljava/lang/String;IILcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;ZZLcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;Z)V", "getAcceptedLibReader", "()Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "setAcceptedLibReader", "(Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;)V", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "()Z", "setFromRemoteDebug", "(Z)V", "setGame", "getModuleName", "setModuleName", "getReportQualitySession", "()Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "setReportQualitySession", "(Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;)V", "getUnderPreRenderMode", "setUnderPreRenderMode", "getVersion", "()I", "setVersion", "(I)V", "getVersionType", "setVersionType", "getWxaVersionInfo", "()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "setWxaVersionInfo", "(Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;)V", "describeContents", "writeToParcel", "", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
    static final class IPCCallParams implements Parcelable {
        public static final Parcelable.Creator<IPCCallParams> CREATOR = new b();
        public static final a mWi = new a((byte) 0);
        String appId;
        String cBp;
        boolean cuy;
        WxaAttributes.WxaVersionInfo cyv;
        int iOo;
        ICommLibReader leM;
        boolean mSa;
        QualitySession mUY;
        boolean mWh;
        int version;

        private IPCCallParams(String str, String str2, int i2, int i3, WxaAttributes.WxaVersionInfo wxaVersionInfo, boolean z, boolean z2, ICommLibReader iCommLibReader, QualitySession qualitySession, boolean z3) {
            p.h(str, "appId");
            p.h(str2, "moduleName");
            p.h(wxaVersionInfo, "wxaVersionInfo");
            p.h(iCommLibReader, "acceptedLibReader");
            p.h(qualitySession, "reportQualitySession");
            AppMethodBeat.i(228725);
            this.appId = str;
            this.cBp = str2;
            this.version = i2;
            this.iOo = i3;
            this.cyv = wxaVersionInfo;
            this.cuy = z;
            this.mSa = z2;
            this.leM = iCommLibReader;
            this.mUY = qualitySession;
            this.mWh = z3;
            AppMethodBeat.o(228725);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public IPCCallParams(android.os.Parcel r14) {
            /*
            // Method dump skipped, instructions count: 141
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallParams.<init>(android.os.Parcel):void");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public IPCCallParams(com.tencent.mm.plugin.appbrand.AppBrandRuntime r13, java.lang.String r14) {
            /*
            // Method dump skipped, instructions count: 144
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallParams.<init>(com.tencent.mm.plugin.appbrand.AppBrandRuntime, java.lang.String):void");
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            byte b2;
            int i3 = 1;
            AppMethodBeat.i(180620);
            p.h(parcel, "dest");
            parcel.writeString(this.appId);
            parcel.writeString(this.cBp);
            parcel.writeInt(this.version);
            parcel.writeInt(this.iOo);
            parcel.writeParcelable(this.cyv, 0);
            parcel.writeByte(this.cuy ? (byte) 1 : 0);
            if (this.mSa) {
                b2 = 1;
            } else {
                b2 = 0;
            }
            parcel.writeByte(b2);
            ICommLibReader.b.a(this.leM, parcel, i2);
            parcel.writeParcelable(this.mUY, 0);
            if (!this.mWh) {
                i3 = 0;
            }
            parcel.writeByte((byte) i3);
            AppMethodBeat.o(180620);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallParams$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallParams;", "plugin-appbrand-integration_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallParams$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallParams;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallParams;", "plugin-appbrand-integration_release"})
        public static final class b implements Parcelable.Creator<IPCCallParams> {
            b() {
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ IPCCallParams createFromParcel(Parcel parcel) {
                AppMethodBeat.i(180619);
                p.h(parcel, "source");
                IPCCallParams iPCCallParams = new IPCCallParams(parcel);
                AppMethodBeat.o(180619);
                return iPCCallParams;
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ IPCCallParams[] newArray(int i2) {
                return new IPCCallParams[i2];
            }
        }

        static {
            AppMethodBeat.i(180624);
            AppMethodBeat.o(180624);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 .2\u00020\u0001:\u0001.B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BK\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\b\u0010(\u001a\u00020\u0006H\u0016J\u000e\u0010)\u001a\u00020*2\u0006\u0010\u0002\u001a\u00020\u0003J\u0018\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0006H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "callbackType", "", "progress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "result", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", StateEvent.ProcessResult.SUCCEED, "", "errCode", "errMsg", "", "(ILcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;Ljava/util/List;ZILjava/lang/String;)V", "getCallbackType", "()I", "setCallbackType", "(I)V", "getErrCode", "setErrCode", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "getProgress", "()Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "setProgress", "(Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;)V", "getResult", "()Ljava/util/List;", "setResult", "(Ljava/util/List;)V", "getSucceed", "()Z", "setSucceed", "(Z)V", "describeContents", "readFromParcel", "", "writeToParcel", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
    static final class IPCCallResult implements Parcelable {
        public static final Parcelable.Creator<IPCCallResult> CREATOR = new b();
        public static final a mWm = new a((byte) 0);
        boolean dVA;
        private int errCode;
        private String errMsg;
        int mWj;
        WxaPkgLoadProgress mWk;
        List<? extends IPkgInfo> mWl;

        private IPCCallResult(int i2, WxaPkgLoadProgress wxaPkgLoadProgress, List<? extends IPkgInfo> list, boolean z, int i3, String str) {
            this.mWj = i2;
            this.mWk = wxaPkgLoadProgress;
            this.mWl = list;
            this.dVA = z;
            this.errCode = i3;
            this.errMsg = str;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ IPCCallResult(int r9, com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress r10, java.util.List r11, boolean r12, int r13, java.lang.String r14, int r15) {
            /*
                r8 = this;
                r7 = 180627(0x2c193, float:2.53112E-40)
                r5 = 0
                r6 = 0
                r0 = r15 & 2
                if (r0 == 0) goto L_0x0030
                r2 = r6
            L_0x000a:
                r0 = r15 & 4
                if (r0 == 0) goto L_0x002e
                r3 = r6
            L_0x000f:
                r0 = r15 & 8
                if (r0 == 0) goto L_0x002c
                r4 = r5
            L_0x0014:
                r0 = r15 & 16
                if (r0 == 0) goto L_0x002a
            L_0x0018:
                r0 = r15 & 32
                if (r0 == 0) goto L_0x0028
            L_0x001c:
                r0 = r8
                r1 = r9
                r0.<init>(r1, r2, r3, r4, r5, r6)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r7)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
                return
            L_0x0028:
                r6 = r14
                goto L_0x001c
            L_0x002a:
                r5 = r13
                goto L_0x0018
            L_0x002c:
                r4 = r12
                goto L_0x0014
            L_0x002e:
                r3 = r11
                goto L_0x000f
            L_0x0030:
                r2 = r10
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverSeparatedPluginsCompatible.IPCCallResult.<init>(int, com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress, java.util.List, boolean, int, java.lang.String, int):void");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public IPCCallResult(Parcel parcel) {
            this(0, null, null, false, 0, null, 62);
            ClassLoader classLoader;
            boolean z = false;
            p.h(parcel, "source");
            AppMethodBeat.i(180628);
            p.h(parcel, "source");
            this.mWj = parcel.readInt();
            switch (this.mWj) {
                case 1:
                    this.mWk = (WxaPkgLoadProgress) parcel.readParcelable(WxaPkgLoadProgress.class.getClassLoader());
                    AppMethodBeat.o(180628);
                    return;
                case 2:
                    a aVar = ModularizingPkgRetrieverSeparatedPluginsCompatible.mWg;
                    int readInt = parcel.readInt();
                    ArrayList arrayList = new ArrayList(readInt);
                    for (int i2 = 0; i2 < readInt; i2++) {
                        String readString = parcel.readString();
                        if (p.j(readString, ModulePkgInfo.class.getName())) {
                            classLoader = ModulePkgInfo.class.getClassLoader();
                        } else {
                            classLoader = p.j(readString, WxaPluginPkgInfo.class.getName()) ? WxaPluginPkgInfo.class.getClassLoader() : null;
                        }
                        if (classLoader == null) {
                            p.hyc();
                        }
                        Parcelable readParcelable = parcel.readParcelable(classLoader);
                        if (readParcelable == null) {
                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.IPkgInfo");
                            AppMethodBeat.o(180628);
                            throw tVar;
                        }
                        arrayList.add((IPkgInfo) readParcelable);
                    }
                    this.mWl = arrayList;
                    this.dVA = parcel.readByte() > 0 ? true : z;
                    this.errCode = parcel.readInt();
                    this.errMsg = parcel.readString();
                    break;
            }
            AppMethodBeat.o(180628);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(180626);
            p.h(parcel, "dest");
            parcel.writeInt(this.mWj);
            switch (this.mWj) {
                case 1:
                    parcel.writeParcelable(this.mWk, 0);
                    AppMethodBeat.o(180626);
                    return;
                case 2:
                    a aVar = ModularizingPkgRetrieverSeparatedPluginsCompatible.mWg;
                    v vVar = this.mWl;
                    if (vVar == null) {
                        vVar = v.SXr;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (T t : vVar) {
                        T t2 = t;
                        if ((t2 instanceof ModulePkgInfo) || (t2 instanceof WxaPluginPkgInfo)) {
                            arrayList.add(t);
                        }
                    }
                    ArrayList<Parcelable> arrayList2 = arrayList;
                    parcel.writeInt(arrayList2.size());
                    for (Parcelable parcelable : arrayList2) {
                        parcel.writeString(parcelable.getClass().getName());
                        parcel.writeParcelable(parcelable, 0);
                    }
                    parcel.writeByte(this.dVA ? (byte) 1 : 0);
                    parcel.writeInt(this.errCode);
                    parcel.writeString(this.errMsg);
                    break;
            }
            AppMethodBeat.o(180626);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult;", "plugin-appbrand-integration_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult;", "plugin-appbrand-integration_release"})
        public static final class b implements Parcelable.Creator<IPCCallResult> {
            b() {
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ IPCCallResult createFromParcel(Parcel parcel) {
                AppMethodBeat.i(180625);
                p.h(parcel, "source");
                IPCCallResult iPCCallResult = new IPCCallResult(parcel);
                AppMethodBeat.o(180625);
                return iPCCallResult;
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ IPCCallResult[] newArray(int i2) {
                return new IPCCallResult[i2];
            }
        }

        static {
            AppMethodBeat.i(180629);
            AppMethodBeat.o(180629);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallParams;", "Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$IPCCallResult;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
    static final class b implements com.tencent.mm.ipcinvoker.b<IPCCallParams, IPCCallResult> {

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "resultPkgList", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "invoke"})
        static final class a extends q implements kotlin.g.a.b<List<? extends IPkgInfo>, x> {
            final /* synthetic */ d kFf;
            final /* synthetic */ IPCCallParams mWn;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar, IPCCallParams iPCCallParams) {
                super(1);
                this.kFf = dVar;
                this.mWn = iPCCallParams;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(List<? extends IPkgInfo> list) {
                AppMethodBeat.i(180630);
                List<? extends IPkgInfo> list2 = list;
                p.h(list2, "resultPkgList");
                this.kFf.bn(new IPCCallResult(2, null, list2, true, 0, null, 50));
                this.mWn.leM.close();
                x xVar = x.SXb;
                AppMethodBeat.o(180630);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "wholeProgressInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverSeparatedPluginsCompatible$b$b  reason: collision with other inner class name */
        static final class C0731b extends q implements kotlin.g.a.b<WxaPkgLoadProgress, x> {
            final /* synthetic */ d kFf;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0731b(d dVar) {
                super(1);
                this.kFf = dVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(WxaPkgLoadProgress wxaPkgLoadProgress) {
                AppMethodBeat.i(180631);
                WxaPkgLoadProgress wxaPkgLoadProgress2 = wxaPkgLoadProgress;
                p.h(wxaPkgLoadProgress2, "wholeProgressInfo");
                this.kFf.bn(new IPCCallResult(1, wxaPkgLoadProgress2, null, false, 0, null, 60));
                x xVar = x.SXb;
                AppMethodBeat.o(180631);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "err", "", "errMsg", "", "invoke"})
        static final class c extends q implements m<Integer, String, x> {
            final /* synthetic */ d kFf;
            final /* synthetic */ IPCCallParams mWn;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(d dVar, IPCCallParams iPCCallParams) {
                super(2);
                this.kFf = dVar;
                this.mWn = iPCCallParams;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(Integer num, String str) {
                AppMethodBeat.i(180632);
                this.kFf.bn(new IPCCallResult(2, null, null, false, num.intValue(), str, 6));
                this.mWn.leM.close();
                x xVar = x.SXb;
                AppMethodBeat.o(180632);
                return xVar;
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCCallParams iPCCallParams, d<IPCCallResult> dVar) {
            boolean z;
            AppMethodBeat.i(180633);
            IPCCallParams iPCCallParams2 = iPCCallParams;
            if (iPCCallParams2 == null) {
                AppMethodBeat.o(180633);
            } else if (dVar == null) {
                AppMethodBeat.o(180633);
            } else {
                l lVar = l.mSI;
                String str = iPCCallParams2.appId;
                int i2 = iPCCallParams2.version;
                int i3 = iPCCallParams2.iOo;
                List listOf = j.listOf(iPCCallParams2.cBp);
                ac acVar = ac.mUH;
                WxaAttributes.WxaVersionInfo wxaVersionInfo = iPCCallParams2.cyv;
                String str2 = iPCCallParams2.appId;
                ac acVar2 = ac.mUH;
                Map<String, WxaAttributes.WxaWidgetInfo> a2 = ac.a(wxaVersionInfo, str2, ac.a(iPCCallParams2.appId, iPCCallParams2.iOo, iPCCallParams2.cyv.appVersion, iPCCallParams2.cuy, iPCCallParams2.leM));
                QualitySession qualitySession = iPCCallParams2.mUY;
                a aVar = new a(dVar, iPCCallParams2);
                C0731b bVar = new C0731b(dVar);
                c cVar = new c(dVar, iPCCallParams2);
                if (!iPCCallParams2.mSa) {
                    v.a.C0742a aVar2 = v.a.mTH;
                    if (v.a.C0742a.hW(iPCCallParams2.cuy)) {
                        aa.a aVar3 = aa.nqC;
                        if (aa.a.d(iPCCallParams2.leM)) {
                            z = false;
                            ac acVar3 = ac.mUH;
                            l.a a3 = ac.a(iPCCallParams2.mUY, iPCCallParams2.mWh);
                            acc acc = new acc();
                            acc.dUS = iPCCallParams2.mUY.scene;
                            acc.LmF = iPCCallParams2.mWh;
                            acc.LmG = 1;
                            l.a(str, i2, i3, listOf, a2, qualitySession, aVar, bVar, cVar, z, acc, a3);
                            AppMethodBeat.o(180633);
                        }
                    }
                }
                z = true;
                ac acVar32 = ac.mUH;
                l.a a32 = ac.a(iPCCallParams2.mUY, iPCCallParams2.mWh);
                acc acc2 = new acc();
                acc2.dUS = iPCCallParams2.mUY.scene;
                acc2.LmF = iPCCallParams2.mWh;
                acc2.LmG = 1;
                l.a(str, i2, i3, listOf, a2, qualitySession, aVar, bVar, cVar, z, acc2, a32);
                AppMethodBeat.o(180633);
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0012\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r*\u00020\u000fH\u0002J\u001a\u0010\u0010\u001a\u00020\u0011*\b\u0012\u0004\u0012\u00020\u00120\r2\u0006\u0010\u0013\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/ModularizingPkgRetrieverSeparatedPluginsCompatible$Companion;", "", "()V", "CALLBACK_TYPE_PROGRESS", "", "CALLBACK_TYPE_RESULT", "TAG", "", "shouldIntercept", "", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "readPkgList", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "Landroid/os/Parcel;", "writePkgListToParcel", "", "Landroid/os/Parcelable;", "dest", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final boolean Z(AppBrandRuntime appBrandRuntime) {
        com.tencent.mm.plugin.appbrand.appcache.q qVar = null;
        AppMethodBeat.i(180639);
        p.h(appBrandRuntime, "rt");
        r M = bg.M(appBrandRuntime);
        if (!(M instanceof bg)) {
            M = null;
        }
        bg bgVar = (bg) M;
        if (bgVar != null) {
            qVar = bgVar.bwy();
        }
        boolean z = qVar instanceof bn;
        AppMethodBeat.o(180639);
        return z;
    }
}
