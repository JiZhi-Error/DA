package com.tencent.mm.plugin.appbrand.app;

import com.tencent.luggage.sdk.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.jsapi.auth.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\t\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/app/AppBrandUserInfoProvider;", "Lcom/tencent/luggage/sdk/userinfo/IWechatUserInfoProvider;", "()V", "getUserAvatarHDHeadImage", "", "callback", "Lcom/tencent/luggage/sdk/userinfo/IWechatUserInfoProvider$OnGetImagePathCallback;", "getUserDisplayNickName", "", "IPCGetHeadIconPath", "IPCGetUserDisplayNickName", "plugin-appbrand-integration_release"})
public final class g implements com.tencent.luggage.sdk.f.a {
    public static final g kIF = new g();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "path", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class c<T> implements d<ResultType> {
        final /* synthetic */ a.b kIG;

        c(a.b bVar) {
            this.kIG = bVar;
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(Object obj) {
            String str;
            AppMethodBeat.i(175109);
            IPCString iPCString = (IPCString) obj;
            if (iPCString == null || (str = iPCString.value) == null) {
                new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.appbrand.app.g.c.AnonymousClass1 */
                    final /* synthetic */ c kIH;

                    {
                        this.kIH = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(175108);
                        this.kIH.kIG.o(null);
                        x xVar = x.SXb;
                        AppMethodBeat.o(175108);
                        return xVar;
                    }
                }.invoke();
                AppMethodBeat.o(175109);
                return;
            }
            this.kIG.o(e.Mq(str));
            AppMethodBeat.o(175109);
        }
    }

    static {
        AppMethodBeat.i(175112);
        AppMethodBeat.o(175112);
    }

    private g() {
    }

    @Override // com.tencent.luggage.sdk.f.a
    public final void a(a.b bVar) {
        AppMethodBeat.i(175110);
        p.h(bVar, "callback");
        XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, a.class, new c(bVar));
        AppMethodBeat.o(175110);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/app/AppBrandUserInfoProvider$IPCGetHeadIconPath;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
    public static final class a implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCString> {

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/appbrand/app/AppBrandUserInfoProvider$IPCGetHeadIconPath$invoke$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper$GetHeadIconPathCallback;", "onCallback", "", "path", "", "plugin-appbrand-integration_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.app.g$a$a  reason: collision with other inner class name */
        public static final class C0541a implements g.b {
            final /* synthetic */ d kFf;

            C0541a(d dVar) {
                this.kFf = dVar;
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.g.b
            public final void UI(String str) {
                AppMethodBeat.i(175105);
                d dVar = this.kFf;
                if (dVar != null) {
                    dVar.bn(new IPCString(str));
                    AppMethodBeat.o(175105);
                    return;
                }
                AppMethodBeat.o(175105);
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCVoid iPCVoid, d<IPCString> dVar) {
            AppMethodBeat.i(175106);
            g.a aVar = com.tencent.mm.plugin.appbrand.jsapi.auth.g.lFD;
            g.a.a(z.aTY(), new C0541a(dVar));
            AppMethodBeat.o(175106);
        }
    }

    @Override // com.tencent.luggage.sdk.f.a
    public final String Pa() {
        AppMethodBeat.i(175111);
        IPCString iPCString = (IPCString) XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, b.class);
        if (iPCString != null) {
            String str = iPCString.value;
            AppMethodBeat.o(175111);
            return str;
        }
        AppMethodBeat.o(175111);
        return null;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/app/AppBrandUserInfoProvider$IPCGetUserDisplayNickName;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "()V", "invoke", "data", "plugin-appbrand-integration_release"})
    public static final class b implements k<IPCVoid, IPCString> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCString invoke(IPCVoid iPCVoid) {
            AppMethodBeat.i(175107);
            String aUa = z.aUa();
            String str = aUa;
            if (str == null || str.length() == 0) {
                aUa = z.aTY();
            }
            IPCString iPCString = new IPCString(aUa);
            AppMethodBeat.o(175107);
            return iPCString;
        }
    }
}
