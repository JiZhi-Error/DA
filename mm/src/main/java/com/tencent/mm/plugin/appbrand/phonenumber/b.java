package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.networking.c;
import com.tencent.mm.protocal.protobuf.zy;
import com.tencent.mm.protocal.protobuf.zz;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.d;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J-\u0010\u000b\u001a\u00020\f2%\u0010\r\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\f\u0018\u00010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiCheckVerifyCode;", "", "appId", "", "mobile", TMQQDownloaderOpenSDKConst.UINTYPE_CODE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getCode", "getMobile", "run", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "Lkotlin/ParameterName;", "name", "resp", "luggage-wechat-full-sdk_release"})
public final class b {
    private final String appId;
    private final String code;
    private final String dSf;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;)Lkotlin/Unit;"})
    static final class a<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ kotlin.g.a.b gWe;

        a(kotlin.g.a.b bVar) {
            this.gWe = bVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(148017);
            zz zzVar = (zz) obj;
            kotlin.g.a.b bVar = this.gWe;
            if (bVar != null) {
                x xVar = (x) bVar.invoke(zzVar);
                AppMethodBeat.o(148017);
                return xVar;
            }
            AppMethodBeat.o(148017);
            return null;
        }
    }

    public b(String str, String str2, String str3) {
        p.h(str, "appId");
        p.h(str2, "mobile");
        p.h(str3, TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
        AppMethodBeat.i(148020);
        this.appId = str;
        this.dSf = str2;
        this.code = str3;
        AppMethodBeat.o(148020);
    }

    public final void y(kotlin.g.a.b<? super zz, x> bVar) {
        AppMethodBeat.i(148019);
        zy zyVar = new zy();
        zyVar.dNI = this.appId;
        zyVar.dSf = this.dSf;
        zyVar.IaW = this.code;
        ((c) e.M(c.class)).a("/cgi-bin/mmbiz-bin/wxaapp/customphone/checkverifycode", zyVar, zz.class).c(new a(bVar)).a(new C0783b(bVar));
        AppMethodBeat.o(148019);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "kotlin.jvm.PlatformType", "onInterrupt"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.b$b  reason: collision with other inner class name */
    static final class C0783b<T> implements d.a<Object> {
        final /* synthetic */ kotlin.g.a.b gWe;

        C0783b(kotlin.g.a.b bVar) {
            this.gWe = bVar;
        }

        @Override // com.tencent.mm.vending.g.d.a
        public final void cn(Object obj) {
            AppMethodBeat.i(148018);
            if (obj instanceof Exception) {
                Log.e("Luggage.FULL.CgiPhoneNumber", "CgiCheckVerifyCode " + ((Exception) obj).getMessage());
            }
            kotlin.g.a.b bVar = this.gWe;
            if (bVar != null) {
                bVar.invoke(null);
                AppMethodBeat.o(148018);
                return;
            }
            AppMethodBeat.o(148018);
        }
    }
}
