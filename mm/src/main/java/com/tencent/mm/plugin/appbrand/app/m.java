package com.tencent.mm.plugin.appbrand.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.g;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToMiniProgramFromH5Event;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0004\u0018\u0019\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0017J$\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u0015\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0017\u001a\u00020\nH\u0016¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebViewAnyProcess;", "Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebView;", "()V", "batchSyncWxaAttr", "", "usernameList", "", "", "html_bridge_invokeMiniProgramAPI", "binderID", "", "name", "args", "", "preloadEnv", "appId", "privateOpenWeappFunctionalPage", "uuid", "transferJson", "reportMiniProgramPageData", "Lcom/tencent/mm/vending/pipeline/Pipeline;", "sendDataToMiniProgram", "data", "webviewId", "BatchSyncWxaAttr", "PreloadCdnEnv", "PrivateOpenFunctionalPage", "SendDataToMiniProgram", "plugin-appbrand-integration_release"})
public final class m extends l {
    @Override // com.tencent.mm.plugin.appbrand.service.j, com.tencent.mm.plugin.appbrand.app.l
    public final com.tencent.mm.vending.g.e<Integer> UK(String str) {
        AppMethodBeat.i(50172);
        com.tencent.mm.co.f<_Ret> b2 = g.hio().b(f.kIW);
        p.g(b2, "pipelineExt().`$ui` {\n  …turn@`$ui` null\n        }");
        com.tencent.mm.co.f<_Ret> fVar = b2;
        AppMethodBeat.o(50172);
        return fVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.j, com.tencent.mm.plugin.appbrand.app.l
    public final void UL(String str) {
        AppMethodBeat.i(50173);
        XIPCInvoker.a(MainProcessIPCService.dkO, new IPCString(str), b.class, null);
        AppMethodBeat.o(50173);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebViewAnyProcess$PreloadCdnEnv;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
    static final class b implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCString iPCString, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(50167);
            IPCString iPCString2 = iPCString;
            ((j) com.tencent.mm.kernel.g.af(j.class)).UL(iPCString2 != null ? iPCString2.value : null);
            if (dVar != null) {
                dVar.bn(IPCVoid.hnE);
                AppMethodBeat.o(50167);
                return;
            }
            AppMethodBeat.o(50167);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.service.j, com.tencent.mm.plugin.appbrand.app.l
    public final void p(String str, String str2, int i2) {
        AppMethodBeat.i(50174);
        String str3 = MainProcessIPCService.dkO;
        SendDataToMiniProgramFromH5Event sendDataToMiniProgramFromH5Event = new SendDataToMiniProgramFromH5Event();
        sendDataToMiniProgramFromH5Event.lWe = str;
        sendDataToMiniProgramFromH5Event.data = str2;
        sendDataToMiniProgramFromH5Event.lWf = i2;
        XIPCInvoker.a(str3, sendDataToMiniProgramFromH5Event, d.class, null);
        AppMethodBeat.o(50174);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebViewAnyProcess$SendDataToMiniProgram;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/jsapi/h5_interact/SendDataToMiniProgramFromH5Event;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
    static final class d implements com.tencent.mm.ipcinvoker.b<SendDataToMiniProgramFromH5Event, IPCVoid> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(SendDataToMiniProgramFromH5Event sendDataToMiniProgramFromH5Event, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(50169);
            SendDataToMiniProgramFromH5Event sendDataToMiniProgramFromH5Event2 = sendDataToMiniProgramFromH5Event;
            if (sendDataToMiniProgramFromH5Event2 != null) {
                com.tencent.mm.plugin.appbrand.ipc.e.b(sendDataToMiniProgramFromH5Event2.lWe, sendDataToMiniProgramFromH5Event2);
            }
            if (dVar != null) {
                dVar.bn(IPCVoid.hnE);
                AppMethodBeat.o(50169);
                return;
            }
            AppMethodBeat.o(50169);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.service.j, com.tencent.mm.plugin.appbrand.app.l
    @SuppressLint({"Recycle"})
    public final void bc(List<String> list) {
        AppMethodBeat.i(50175);
        if (list == null) {
            AppMethodBeat.o(50175);
            return;
        }
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        obtain.writeStringList(list);
        obtain.setDataPosition(0);
        XIPCInvoker.a(MainProcessIPCService.dkO, obtain, a.class, new e(obtain));
        AppMethodBeat.o(50175);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebViewAnyProcess$BatchSyncWxaAttr;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Parcel;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
    static final class a implements com.tencent.mm.ipcinvoker.b<Parcel, IPCVoid> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(Parcel parcel, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(164004);
            Parcel parcel2 = parcel;
            if (parcel2 != null) {
                try {
                    ArrayList<String> createStringArrayList = parcel2.createStringArrayList();
                    if (createStringArrayList != null) {
                        ((j) com.tencent.mm.kernel.g.af(j.class)).bc(createStringArrayList);
                    }
                } catch (Exception e2) {
                }
            }
            if (dVar != null) {
                dVar.bn(IPCVoid.hnE);
                AppMethodBeat.o(164004);
                return;
            }
            AppMethodBeat.o(164004);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.service.j, com.tencent.mm.plugin.appbrand.app.l
    public final void cr(String str, String str2) {
        AppMethodBeat.i(50176);
        if (str2 == null) {
            AppMethodBeat.o(50176);
        } else if (str == null) {
            AppMethodBeat.o(50176);
        } else {
            Parcel obtain = Parcel.obtain();
            obtain.setDataPosition(0);
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.setDataPosition(0);
            try {
                XIPCInvoker.a(MainProcessIPCService.dkO, obtain, c.class);
            } finally {
                obtain.recycle();
                AppMethodBeat.o(50176);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebViewAnyProcess$PrivateOpenFunctionalPage;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Parcel;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "data", "plugin-appbrand-integration_release"})
    static final class c implements k<Parcel, IPCVoid> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCVoid invoke(Parcel parcel) {
            AppMethodBeat.i(50168);
            Parcel parcel2 = parcel;
            if (parcel2 != null) {
                ((j) com.tencent.mm.kernel.g.af(j.class)).cr(parcel2.readString(), parcel2.readString());
            }
            IPCVoid iPCVoid = IPCVoid.hnE;
            p.g(iPCVoid, "IPCVoid.VOID");
            AppMethodBeat.o(50168);
            return iPCVoid;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.service.j, com.tencent.mm.plugin.appbrand.app.l
    public final void a(int i2, String str, Object obj) {
        AppMethodBeat.i(175113);
        com.tencent.mm.plugin.appbrand.jsapi.af.b bVar = com.tencent.mm.plugin.appbrand.jsapi.af.b.mHb;
        com.tencent.mm.plugin.appbrand.jsapi.af.a xL = com.tencent.mm.plugin.appbrand.jsapi.af.b.xL(i2);
        if (xL != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", str);
            jSONObject.put("arg", obj);
            xL.ah(jSONObject);
            AppMethodBeat.o(175113);
            return;
        }
        AppMethodBeat.o(175113);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
    static final class f<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        public static final f kIW = new f();

        static {
            AppMethodBeat.i(50171);
            AppMethodBeat.o(50171);
        }

        f() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(50170);
            com.tencent.mm.vending.g.g.hdx().ej(new IllegalAccessError("Not Support XPC invoke for now"));
            AppMethodBeat.o(50170);
            return null;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class e<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        final /* synthetic */ Parcel kIV;

        e(Parcel parcel) {
            this.kIV = parcel;
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(Object obj) {
            AppMethodBeat.i(164005);
            this.kIV.recycle();
            AppMethodBeat.o(164005);
        }
    }
}
