package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.emk;
import com.tencent.mm.protocal.protobuf.eml;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.d;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J-\u0010\r\u001a\u00020\u000e2%\u0010\u000f\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiUpdateUserPhone;", "", "appId", "", "mobile", "type", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "getMobile", "getType", "()I", "run", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/UpdateUserPhoneResp;", "Lkotlin/ParameterName;", "name", "resp", "Companion", "luggage-wechat-full-sdk_release"})
public final class g {
    public static final a nyL = new a((byte) 0);
    private final String appId;
    private final String dSf;
    private final int type;

    static {
        AppMethodBeat.i(148041);
        AppMethodBeat.o(148041);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/UpdateUserPhoneResp;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/protocal/protobuf/UpdateUserPhoneResp;)Lkotlin/Unit;"})
    static final class b<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ kotlin.g.a.b gWe;

        b(kotlin.g.a.b bVar) {
            this.gWe = bVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(148037);
            eml eml = (eml) obj;
            kotlin.g.a.b bVar = this.gWe;
            if (bVar != null) {
                x xVar = (x) bVar.invoke(eml);
                AppMethodBeat.o(148037);
                return xVar;
            }
            AppMethodBeat.o(148037);
            return null;
        }
    }

    public g(String str, String str2, int i2) {
        p.h(str, "appId");
        p.h(str2, "mobile");
        AppMethodBeat.i(148040);
        this.appId = str;
        this.dSf = str2;
        this.type = i2;
        AppMethodBeat.o(148040);
    }

    public final void y(kotlin.g.a.b<? super eml, x> bVar) {
        AppMethodBeat.i(148039);
        emk emk = new emk();
        emk.dNI = this.appId;
        emk.dSf = this.dSf;
        emk.type = this.type;
        ((com.tencent.mm.plugin.appbrand.networking.c) e.M(com.tencent.mm.plugin.appbrand.networking.c.class)).a("/cgi-bin/mmbiz-bin/wxaapp/customphone/updateuserphone", emk, eml.class).c(new b(bVar)).a(new c(bVar));
        AppMethodBeat.o(148039);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "kotlin.jvm.PlatformType", "onInterrupt"})
    static final class c<T> implements d.a<Object> {
        final /* synthetic */ kotlin.g.a.b gWe;

        c(kotlin.g.a.b bVar) {
            this.gWe = bVar;
        }

        @Override // com.tencent.mm.vending.g.d.a
        public final void cn(Object obj) {
            AppMethodBeat.i(148038);
            if (obj instanceof Exception) {
                Log.e("Luggage.FULL.CgiPhoneNumber", "CgiUpdateUserPhone " + ((Exception) obj).getMessage());
            }
            kotlin.g.a.b bVar = this.gWe;
            if (bVar != null) {
                bVar.invoke(null);
                AppMethodBeat.o(148038);
                return;
            }
            AppMethodBeat.o(148038);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiUpdateUserPhone$Companion;", "", "()V", "ADD", "", "DELETE", "luggage-wechat-full-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
