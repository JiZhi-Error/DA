package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.fdg;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.g.g;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002'(J6\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J \u0010\u0014\u001a\u00020\n\"\u0004\b\u0000\u0010\u0015*\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0018H\u0016J\u0014\u0010\u0019\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\f\u0010\u001c\u001a\u00020\f*\u00020\u0006H\u0016J<\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u001e0\u0018\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u00020\u00062\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u001e0$H\u0016J\f\u0010%\u001a\u00020&*\u00020\u0010H\u0016R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ConstantsAppBrandJsApiMsg;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthConstants;", "Lcom/tencent/mm/wxaprotocol/ConstantsWxaProtocol;", "windowAndroid", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "getWindowAndroid", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;)Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "setUserInfoListData", "", "context", "Landroid/content/Context;", "bitmap", "Landroid/graphics/Bitmap;", "userNickName", "", "scope", "dialog", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "bridge", "_Var", "Lcom/tencent/mm/vending/pipeline/Mario;", "pipeable", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "fill", "Lcom/tencent/mm/protocal/protobuf/WxaExternalInfo;", "service", "notNullContext", "runCgi", "R", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "url", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "clazz", "Ljava/lang/Class;", "toByteString", "Lcom/tencent/mm/protobuf/ByteString;", "ApiInvokeInterruptCallbackException", "ComponentInterruptedException", "luggage-wechat-full-sdk_release"})
public interface f {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper$ComponentInterruptedException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "luggage-wechat-full-sdk_release"})
    public static final class b extends Exception {
        public static final b lFy = new b();

        static {
            AppMethodBeat.i(169557);
            AppMethodBeat.o(169557);
        }

        private b() {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper$ApiInvokeInterruptCallbackException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "luggage-wechat-full-sdk_release"})
    public static final class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    @l(hxD = {1, 1, 16})
    public static final class c {
        public static Context a(k kVar) {
            AppMethodBeat.i(169558);
            p.h(kVar, "$this$notNullContext");
            Context context = kVar.getContext();
            if (context == null) {
                Object invoke = new C0633c(kVar).invoke();
                p.g(invoke, "{\n            this.runtime.appContext\n        }()");
                context = (Context) invoke;
            }
            AppMethodBeat.o(169558);
            return context;
        }

        public static <R extends dpc> com.tencent.mm.vending.g.c<R> a(k kVar, String str, com.tencent.mm.bw.a aVar, Class<R> cls) {
            AppMethodBeat.i(169560);
            p.h(kVar, "$this$runCgi");
            p.h(str, "url");
            p.h(aVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            p.h(cls, "clazz");
            com.tencent.luggage.a.b M = kVar.M(com.tencent.mm.plugin.appbrand.networking.c.class);
            if (M == null) {
                p.hyc();
            }
            kVar.getAppId();
            com.tencent.mm.vending.g.c<R> a2 = ((com.tencent.mm.plugin.appbrand.networking.c) M).a(str, aVar, cls);
            p.g(a2, "this.customize(ICgiServi…is.appId, request, clazz)");
            AppMethodBeat.o(169560);
            return a2;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, hxF = {"<anonymous>", "", "_Var", LocaleUtil.ITALIAN, "kotlin.jvm.PlatformType", "onTerminate", "(Ljava/lang/Object;)V"})
        static final class a<T> implements d.b<_Var> {
            final /* synthetic */ com.tencent.mm.vending.g.b kQj;

            a(com.tencent.mm.vending.g.b bVar) {
                this.kQj = bVar;
            }

            @Override // com.tencent.mm.vending.g.d.b
            public final void bz(_Var _var) {
                AppMethodBeat.i(169564);
                g.a(this.kQj, _var);
                AppMethodBeat.o(169564);
            }
        }

        public static <_Var> void a(com.tencent.mm.vending.g.b bVar, com.tencent.mm.vending.g.c<_Var> cVar) {
            AppMethodBeat.i(169561);
            p.h(bVar, "$this$bridge");
            p.h(cVar, "pipeable");
            cVar.a(new a(bVar)).a(new b(bVar));
            AppMethodBeat.o(169561);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "_Var", LocaleUtil.ITALIAN, "", "kotlin.jvm.PlatformType", "onInterrupt"})
        static final class b<T> implements d.a<Object> {
            final /* synthetic */ com.tencent.mm.vending.g.b kQj;

            b(com.tencent.mm.vending.g.b bVar) {
                this.kQj = bVar;
            }

            @Override // com.tencent.mm.vending.g.d.a
            public final void cn(Object obj) {
                AppMethodBeat.i(169565);
                this.kQj.ej(obj);
                AppMethodBeat.o(169565);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class d implements Runnable {
            final /* synthetic */ Context $context;
            final /* synthetic */ Bitmap cKG;
            final /* synthetic */ String lFA;
            final /* synthetic */ String lFB;
            final /* synthetic */ com.tencent.mm.plugin.appbrand.permission.a.b lFC;

            d(String str, Context context, String str2, Bitmap bitmap, com.tencent.mm.plugin.appbrand.permission.a.b bVar) {
                this.lFA = str;
                this.$context = context;
                this.lFB = str2;
                this.cKG = bitmap;
                this.lFC = bVar;
            }

            public final void run() {
                AppMethodBeat.i(169567);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new i.a(this.lFA, this.$context.getResources().getString(R.string.a0j), this.lFB, this.cKG));
                this.lFC.setSelectListItem(arrayList);
                AppMethodBeat.o(169567);
            }
        }

        public static void a(Context context, Bitmap bitmap, String str, String str2, com.tencent.mm.plugin.appbrand.permission.a.b bVar) {
            AppMethodBeat.i(230070);
            p.h(context, "context");
            p.h(bVar, "dialog");
            MMHandlerThread.postToMainThread(new d(str, context, str2, bitmap, bVar));
            AppMethodBeat.o(230070);
        }

        public static fdg a(fdg fdg, k kVar) {
            AppBrandStatObject Nz;
            int i2 = 0;
            AppMethodBeat.i(169563);
            p.h(fdg, "$this$fill");
            p.h(kVar, "service");
            AppBrandRuntime runtime = kVar.getRuntime();
            if (!(runtime instanceof com.tencent.luggage.sdk.d.d)) {
                runtime = null;
            }
            com.tencent.luggage.sdk.d.d dVar = (com.tencent.luggage.sdk.d.d) runtime;
            fdg.scene = (dVar == null || (Nz = dVar.Nz()) == null) ? 0 : Nz.scene;
            if (kVar instanceof s) {
                i2 = 1;
            } else if (kVar instanceof ac) {
                i2 = 2;
            }
            fdg.NyS = i2;
            AppMethodBeat.o(169563);
            return fdg;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/content/Context;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.f$c$c  reason: collision with other inner class name */
        static final class C0633c extends q implements kotlin.g.a.a<Context> {
            final /* synthetic */ k lFz;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0633c(k kVar) {
                super(0);
                this.lFz = kVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ Context invoke() {
                AppMethodBeat.i(169566);
                AppBrandRuntime runtime = this.lFz.getRuntime();
                p.g(runtime, "this.runtime");
                Context appContext = runtime.getAppContext();
                AppMethodBeat.o(169566);
                return appContext;
            }
        }
    }
}
