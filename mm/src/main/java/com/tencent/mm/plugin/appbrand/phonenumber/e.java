package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.networking.c;
import com.tencent.mm.protocal.protobuf.duk;
import com.tencent.mm.protocal.protobuf.dul;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.d;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J-\u0010\t\u001a\u00020\n2%\u0010\u000b\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiSendVerifyCode;", "", "appId", "", "mobile", "(Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getMobile", "run", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "Lkotlin/ParameterName;", "name", "resp", "luggage-wechat-full-sdk_release"})
public final class e {
    private final String appId;
    private final String dSf;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;)Lkotlin/Unit;"})
    static final class a<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ kotlin.g.a.b gWe;

        a(kotlin.g.a.b bVar) {
            this.gWe = bVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(148029);
            dul dul = (dul) obj;
            kotlin.g.a.b bVar = this.gWe;
            if (bVar != null) {
                x xVar = (x) bVar.invoke(dul);
                AppMethodBeat.o(148029);
                return xVar;
            }
            AppMethodBeat.o(148029);
            return null;
        }
    }

    public e(String str, String str2) {
        p.h(str, "appId");
        p.h(str2, "mobile");
        AppMethodBeat.i(148032);
        this.appId = str;
        this.dSf = str2;
        AppMethodBeat.o(148032);
    }

    public final void y(kotlin.g.a.b<? super dul, x> bVar) {
        AppMethodBeat.i(148031);
        duk duk = new duk();
        duk.dNI = this.appId;
        duk.dSf = this.dSf;
        ((c) com.tencent.luggage.a.e.M(c.class)).a("/cgi-bin/mmbiz-bin/wxaapp/customphone/sendverifycode", duk, dul.class).c(new a(bVar)).a(new b(bVar));
        AppMethodBeat.o(148031);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "kotlin.jvm.PlatformType", "onInterrupt"})
    static final class b<T> implements d.a<Object> {
        final /* synthetic */ kotlin.g.a.b gWe;

        b(kotlin.g.a.b bVar) {
            this.gWe = bVar;
        }

        @Override // com.tencent.mm.vending.g.d.a
        public final void cn(Object obj) {
            AppMethodBeat.i(148030);
            if (obj instanceof Exception) {
                Log.e("Luggage.FULL.CgiPhoneNumber", "CgiSendVerifyCode " + ((Exception) obj).getMessage());
            }
            kotlin.g.a.b bVar = this.gWe;
            if (bVar != null) {
                bVar.invoke(null);
                AppMethodBeat.o(148030);
                return;
            }
            AppMethodBeat.o(148030);
        }
    }
}
