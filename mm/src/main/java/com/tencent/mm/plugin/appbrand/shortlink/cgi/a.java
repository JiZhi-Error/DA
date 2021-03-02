package com.tencent.mm.plugin.appbrand.shortlink.cgi;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.shortlink.cgi.WxaShortLinkInfo;
import com.tencent.mm.protocal.protobuf.zl;
import com.tencent.mm.protocal.protobuf.zm;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vending.g.d;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u0005¢\u0006\u0002\u0010\u0002JP\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b28\u0010\t\u001a4\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00040\n¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink;", "", "()V", "checkAsync", "", "shortLink", "", "businessType", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink$TYPE;", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "cgiSuccess", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo;", "info", "Companion", "TYPE", "luggage-wechat-full-sdk_release"})
public final class a {
    public static final C0795a nNV = new C0795a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink$TYPE;", "", "(Ljava/lang/String;I)V", "BusinessTypeNone", "BusinessTypeWxaBase", "BusinessTypeOpenSdk", "BusinessTypeVideoAct", "luggage-wechat-full-sdk_release"})
    public enum b {
        BusinessTypeNone,
        BusinessTypeWxaBase,
        BusinessTypeOpenSdk,
        BusinessTypeVideoAct;

        static {
            AppMethodBeat.i(230177);
            AppMethodBeat.o(230177);
        }

        public static b valueOf(String str) {
            AppMethodBeat.i(230179);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(230179);
            return bVar;
        }
    }

    static {
        AppMethodBeat.i(230183);
        AppMethodBeat.o(230183);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/CheckShortLinkResp;", "kotlin.jvm.PlatformType", "call"})
    static final class c<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ m nzd;

        c(m mVar) {
            this.nzd = mVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            String str;
            AppMethodBeat.i(230180);
            zm zmVar = (zm) obj;
            if (zmVar.BaseResponse.Ret != 0) {
                Log.e("MicroMsg.CgiCheckWxaShortLink", "checkAsync cig fail. Ret[" + zmVar.BaseResponse.Ret + "]  ErrMsg[" + zmVar.BaseResponse.ErrMsg + ']');
                this.nzd.invoke(Boolean.FALSE, null);
            } else {
                Log.i("MicroMsg.CgiCheckWxaShortLink", "checkAsync cig success.");
                m mVar = this.nzd;
                Boolean bool = Boolean.TRUE;
                WxaShortLinkInfo.a aVar = WxaShortLinkInfo.nOb;
                p.g(zmVar, "resp");
                p.h(zmVar, "resp");
                com.tencent.mm.bw.b bVar = zmVar.LkM;
                String bVar2 = bVar != null ? bVar.toString(MimeTypeUtil.ContentType.DEFAULT_CHARSET) : "";
                com.tencent.mm.bw.b bVar3 = zmVar.LkO;
                String bVar4 = bVar3 != null ? bVar3.toString(MimeTypeUtil.ContentType.DEFAULT_CHARSET) : "";
                com.tencent.mm.bw.b bVar5 = zmVar.LkN;
                String bVar6 = bVar5 != null ? bVar5.toString(MimeTypeUtil.ContentType.DEFAULT_CHARSET) : "";
                int i2 = zmVar.version;
                int i3 = zmVar.KXC;
                com.tencent.mm.bw.b bVar7 = zmVar.LkP;
                if (bVar7 != null) {
                    str = bVar7.yO();
                } else {
                    str = "";
                }
                mVar.invoke(bool, new WxaShortLinkInfo(bVar2, bVar4, bVar6, i2, i3, str));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(230180);
            return xVar;
        }
    }

    public static void a(String str, b bVar, m<? super Boolean, ? super WxaShortLinkInfo, x> mVar) {
        AppMethodBeat.i(230182);
        p.h(str, "shortLink");
        p.h(bVar, "businessType");
        p.h(mVar, "callback");
        zl zlVar = new zl();
        zlVar.LkL = bVar.ordinal();
        zlVar.LkK = str;
        com.tencent.luggage.a.b M = e.M(com.tencent.mm.plugin.appbrand.networking.c.class);
        if (M == null) {
            p.hyc();
        }
        ((com.tencent.mm.plugin.appbrand.networking.c) M).a("/cgi-bin/mmbiz-bin/wxaapp/wxaapp_checkshortlink", zlVar, zm.class).c(new c(mVar)).a(new d(mVar));
        AppMethodBeat.o(230182);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "kotlin.jvm.PlatformType", "onInterrupt"})
    static final class d<T> implements d.a<Object> {
        final /* synthetic */ m nzd;

        d(m mVar) {
            this.nzd = mVar;
        }

        @Override // com.tencent.mm.vending.g.d.a
        public final void cn(Object obj) {
            AppMethodBeat.i(230181);
            if (obj instanceof Exception) {
                Log.e("MicroMsg.CgiCheckWxaShortLink", "checkAsync exception" + ((Exception) obj).getMessage());
            }
            this.nzd.invoke(Boolean.FALSE, null);
            AppMethodBeat.o(230181);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink$Companion;", "", "()V", "TAG", "", "URI", "luggage-wechat-full-sdk_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.shortlink.cgi.a$a  reason: collision with other inner class name */
    public static final class C0795a {
        private C0795a() {
        }

        public /* synthetic */ C0795a(byte b2) {
            this();
        }
    }
}
