package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004\t\n\u000b\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0005\u001a\u00020\u00062\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations;", "", "()V", "TAG", "", "enqueueWorker", "", "block", "Lkotlin/Function0;", "IPC_accessRecord", "IPC_createRecord", "IPC_deleteRecord", "WebRenderingCacheRecordParcel", "plugin-appbrand-integration_release"})
public final class WebRenderingCacheIPCOperations {
    public static final WebRenderingCacheIPCOperations nwo = new WebRenderingCacheIPCOperations();

    static {
        AppMethodBeat.i(50983);
        AppMethodBeat.o(50983);
    }

    private WebRenderingCacheIPCOperations() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B1\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0015H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "appId", "", "commLibVersionId", "appVersionId", "pageURL", "filePath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getAppVersionId", "getCommLibVersionId", "getFilePath", "setFilePath", "(Ljava/lang/String;)V", "getPageURL", "describeContents", "", "toDBBean", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheAccessRecord;", "writeToParcel", "", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
    public static class WebRenderingCacheRecordParcel implements Parcelable {
        public static final Parcelable.Creator<WebRenderingCacheRecordParcel> CREATOR = new b();
        public static final a nwt = new a((byte) 0);
        private final String appId;
        String filePath;
        private final String nwq;
        private final String nwr;
        private final String nws;

        public /* synthetic */ WebRenderingCacheRecordParcel(String str, String str2, String str3, String str4) {
            this(str, str2, str3, str4, null);
        }

        private WebRenderingCacheRecordParcel(String str, String str2, String str3, String str4, String str5) {
            p.h(str, "appId");
            p.h(str2, "commLibVersionId");
            p.h(str3, "appVersionId");
            p.h(str4, "pageURL");
            AppMethodBeat.i(50980);
            this.appId = str;
            this.nwq = str2;
            this.nwr = str3;
            this.nws = str4;
            this.filePath = str5;
            AppMethodBeat.o(50980);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public WebRenderingCacheRecordParcel(android.os.Parcel r8) {
            /*
                r7 = this;
                r6 = 50981(0xc725, float:7.144E-41)
                java.lang.String r0 = "source"
                kotlin.g.b.p.h(r8, r0)
                java.lang.String r1 = r8.readString()
                if (r1 != 0) goto L_0x0012
                kotlin.g.b.p.hyc()
            L_0x0012:
                java.lang.String r0 = "source.readString()!!"
                kotlin.g.b.p.g(r1, r0)
                java.lang.String r2 = r8.readString()
                if (r2 != 0) goto L_0x0021
                kotlin.g.b.p.hyc()
            L_0x0021:
                java.lang.String r0 = "source.readString()!!"
                kotlin.g.b.p.g(r2, r0)
                java.lang.String r3 = r8.readString()
                if (r3 != 0) goto L_0x0030
                kotlin.g.b.p.hyc()
            L_0x0030:
                java.lang.String r0 = "source.readString()!!"
                kotlin.g.b.p.g(r3, r0)
                java.lang.String r4 = r8.readString()
                if (r4 != 0) goto L_0x003f
                kotlin.g.b.p.hyc()
            L_0x003f:
                java.lang.String r0 = "source.readString()!!"
                kotlin.g.b.p.g(r4, r0)
                java.lang.String r5 = r8.readString()
                r0 = r7
                r0.<init>(r1, r2, r3, r4, r5)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.page.web_renderingcache.WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel.<init>(android.os.Parcel):void");
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(50978);
            p.h(parcel, "dest");
            parcel.writeString(this.appId);
            parcel.writeString(this.nwq);
            parcel.writeString(this.nwr);
            parcel.writeString(this.nws);
            parcel.writeString(this.filePath);
            AppMethodBeat.o(50978);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "plugin-appbrand-integration_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "plugin-appbrand-integration_release"})
        public static final class b implements Parcelable.Creator<WebRenderingCacheRecordParcel> {
            b() {
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ WebRenderingCacheRecordParcel createFromParcel(Parcel parcel) {
                AppMethodBeat.i(50977);
                p.h(parcel, "source");
                WebRenderingCacheRecordParcel webRenderingCacheRecordParcel = new WebRenderingCacheRecordParcel(parcel);
                AppMethodBeat.o(50977);
                return webRenderingCacheRecordParcel;
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ WebRenderingCacheRecordParcel[] newArray(int i2) {
                return new WebRenderingCacheRecordParcel[i2];
            }
        }

        static {
            AppMethodBeat.i(50982);
            AppMethodBeat.o(50982);
        }

        public final b bSH() {
            AppMethodBeat.i(50979);
            b bVar = new b();
            bVar.field_appId = this.appId;
            bVar.field_commLibVersionId = this.nwq;
            bVar.field_appVersionId = this.nwr;
            bVar.field_pageURL = this.nws;
            AppMethodBeat.o(50979);
            return bVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$IPC_deleteRecord;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
    public static final class c implements com.tencent.mm.ipcinvoker.b<WebRenderingCacheRecordParcel, IPCVoid> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(WebRenderingCacheRecordParcel webRenderingCacheRecordParcel, d<IPCVoid> dVar) {
            AppMethodBeat.i(50976);
            WebRenderingCacheRecordParcel webRenderingCacheRecordParcel2 = webRenderingCacheRecordParcel;
            if (webRenderingCacheRecordParcel2 == null) {
                AppMethodBeat.o(50976);
                return;
            }
            WebRenderingCacheIPCOperations webRenderingCacheIPCOperations = WebRenderingCacheIPCOperations.nwo;
            com.tencent.mm.ac.d.b("MicroMsg.AppBrand.WebRenderingCacheIPCOperations", new a(webRenderingCacheRecordParcel2));
            AppMethodBeat.o(50976);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$enqueueWorker$1"})
        public static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ WebRenderingCacheRecordParcel nwp;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(WebRenderingCacheRecordParcel webRenderingCacheRecordParcel) {
                super(0);
                this.nwp = webRenderingCacheRecordParcel;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(50975);
                b bSH = this.nwp.bSH();
                Log.i("MicroMsg.AppBrand.WebRenderingCacheIPCOperations", "delete ".concat(String.valueOf(bSH)));
                c cVar = (c) n.W(c.class);
                if (cVar != null) {
                    cVar.delete(bSH, new String[0]);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(50975);
                return xVar;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$IPC_accessRecord;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
    public static final class a implements com.tencent.mm.ipcinvoker.b<WebRenderingCacheRecordParcel, IPCVoid> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(WebRenderingCacheRecordParcel webRenderingCacheRecordParcel, d<IPCVoid> dVar) {
            AppMethodBeat.i(50972);
            WebRenderingCacheRecordParcel webRenderingCacheRecordParcel2 = webRenderingCacheRecordParcel;
            if (webRenderingCacheRecordParcel2 == null) {
                AppMethodBeat.o(50972);
                return;
            }
            WebRenderingCacheIPCOperations webRenderingCacheIPCOperations = WebRenderingCacheIPCOperations.nwo;
            com.tencent.mm.ac.d.b("MicroMsg.AppBrand.WebRenderingCacheIPCOperations", new C0776a(webRenderingCacheRecordParcel2));
            AppMethodBeat.o(50972);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$enqueueWorker$1"})
        /* renamed from: com.tencent.mm.plugin.appbrand.page.web_renderingcache.WebRenderingCacheIPCOperations$a$a  reason: collision with other inner class name */
        public static final class C0776a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ WebRenderingCacheRecordParcel nwp;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0776a(WebRenderingCacheRecordParcel webRenderingCacheRecordParcel) {
                super(0);
                this.nwp = webRenderingCacheRecordParcel;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(50971);
                c cVar = (c) n.W(c.class);
                if (cVar != null) {
                    b bSH = this.nwp.bSH();
                    if (cVar.get(bSH, new String[0])) {
                        bSH.field_accessTime = Util.nowMilliSecond();
                        cVar.update(bSH, new String[0]);
                        Log.i("MicroMsg.AppBrand.WebRenderingCacheIPCOperations", "access ".concat(String.valueOf(bSH)));
                    } else {
                        Log.e("MicroMsg.AppBrand.WebRenderingCacheIPCOperations", "access failed ".concat(String.valueOf(bSH)));
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(50971);
                return xVar;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$IPC_createRecord;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
    public static final class b implements com.tencent.mm.ipcinvoker.b<WebRenderingCacheRecordParcel, IPCVoid> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(WebRenderingCacheRecordParcel webRenderingCacheRecordParcel, d<IPCVoid> dVar) {
            AppMethodBeat.i(50974);
            WebRenderingCacheRecordParcel webRenderingCacheRecordParcel2 = webRenderingCacheRecordParcel;
            if (webRenderingCacheRecordParcel2 == null) {
                AppMethodBeat.o(50974);
                return;
            }
            WebRenderingCacheIPCOperations webRenderingCacheIPCOperations = WebRenderingCacheIPCOperations.nwo;
            com.tencent.mm.ac.d.b("MicroMsg.AppBrand.WebRenderingCacheIPCOperations", new a(webRenderingCacheRecordParcel2));
            AppMethodBeat.o(50974);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$enqueueWorker$1"})
        public static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ WebRenderingCacheRecordParcel nwp;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(WebRenderingCacheRecordParcel webRenderingCacheRecordParcel) {
                super(0);
                this.nwp = webRenderingCacheRecordParcel;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(50973);
                c cVar = (c) n.W(c.class);
                if (cVar != null) {
                    b bSH = this.nwp.bSH();
                    boolean z = cVar.get(bSH, new String[0]);
                    bSH.field_cacheFilePath = this.nwp.filePath;
                    bSH.field_accessTime = Util.nowMilliSecond();
                    if (z) {
                        cVar.update(bSH, new String[0]);
                        Log.i("MicroMsg.AppBrand.WebRenderingCacheIPCOperations", "update record[" + bSH + "] with path[" + this.nwp.filePath + ']');
                    } else {
                        cVar.insert(bSH);
                        Log.i("MicroMsg.AppBrand.WebRenderingCacheIPCOperations", "insert record[" + bSH + "] with path[" + this.nwp.filePath + ']');
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(50973);
                return xVar;
            }
        }
    }
}
