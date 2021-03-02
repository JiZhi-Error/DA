package com.tencent.mm.plugin.ab;

import android.graphics.Color;
import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.ab.f;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.k;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007JP\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0007¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/webjsapi/WxPopupAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/WxPopupAPIContext;", "context", "(Lcom/tencent/mm/plugin/webjsapi/WxPopupAPIContext;)V", "close", "", "popupId", "", "popup", "width", "", "height", "left", "top", "mode", "", "colorRGBA", "onDismissCallback", "onOuterClickCallback", "webview-sdk_release"})
public final class n extends a<o> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(o oVar) {
        super("wxPopup", oVar);
        p.h(oVar, "context");
        AppMethodBeat.i(224842);
        AppMethodBeat.o(224842);
    }

    @JavascriptInterface
    public final void popup(String str, Number number, Number number2, Number number3, Number number4, int i2, String str2, String str3, String str4) {
        String str5;
        int i3;
        AppMethodBeat.i(224840);
        p.h(str, "popupId");
        p.h(number, "width");
        p.h(number2, "height");
        p.h(number3, "left");
        p.h(number4, "top");
        p.h(str2, "colorRGBA");
        p.h(str3, "onDismissCallback");
        p.h(str4, "onOuterClickCallback");
        char[] cArr = {'#'};
        p.h(str2, "$this$trimStart");
        p.h(cArr, "chars");
        String str6 = str2;
        int i4 = 0;
        int length = str6.length();
        while (true) {
            if (i4 >= length) {
                break;
            } else if (!e.contains(cArr, str6.charAt(i4))) {
                str5 = str6.subSequence(i4, str6.length());
                break;
            } else {
                i4++;
            }
        }
        String obj = str5.toString();
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(224840);
            throw tVar;
        }
        String upperCase = obj.toUpperCase();
        p.g(upperCase, "(this as java.lang.String).toUpperCase()");
        if (!new k("[A-F0-9]{8}").aJ(upperCase)) {
            i3 = 0;
        } else if (upperCase == null) {
            t tVar2 = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(224840);
            throw tVar2;
        } else {
            String substring = upperCase.substring(6, 8);
            p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            int parseInt = Integer.parseInt(substring, kotlin.n.a.avR(16));
            if (upperCase == null) {
                t tVar3 = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(224840);
                throw tVar3;
            }
            String substring2 = upperCase.substring(0, 2);
            p.g(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            int parseInt2 = Integer.parseInt(substring2, kotlin.n.a.avR(16));
            if (upperCase == null) {
                t tVar4 = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(224840);
                throw tVar4;
            }
            String substring3 = upperCase.substring(2, 4);
            p.g(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            int parseInt3 = Integer.parseInt(substring3, kotlin.n.a.avR(16));
            if (upperCase == null) {
                t tVar5 = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(224840);
                throw tVar5;
            }
            String substring4 = upperCase.substring(4, 6);
            p.g(substring4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            i3 = Color.argb(parseInt, parseInt2, parseInt3, Integer.parseInt(substring4, kotlin.n.a.avR(16)));
        }
        ((o) this.IBa).aWy(str);
        d.h(new b(this, str, number, number2, number3, number4, i2, i3, str3, str4));
        AppMethodBeat.o(224840);
    }

    @JavascriptInterface
    public final void close(String str) {
        AppMethodBeat.i(224841);
        p.h(str, "popupId");
        d.h(new a(this, str));
        AppMethodBeat.o(224841);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ n IBm;
        final /* synthetic */ String IBn;
        final /* synthetic */ Number IBo;
        final /* synthetic */ Number IBp;
        final /* synthetic */ Number IBq;
        final /* synthetic */ String IBr;
        final /* synthetic */ String IBs;
        final /* synthetic */ Number IzA;
        final /* synthetic */ int oHV;
        final /* synthetic */ int rrz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(n nVar, String str, Number number, Number number2, Number number3, Number number4, int i2, int i3, String str2, String str3) {
            super(0);
            this.IBm = nVar;
            this.IBn = str;
            this.IBo = number;
            this.IzA = number2;
            this.IBp = number3;
            this.IBq = number4;
            this.oHV = i2;
            this.rrz = i3;
            this.IBr = str2;
            this.IBs = str3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(224839);
            String str = this.IBn;
            f.a aVar = f.IBd;
            int c2 = f.a.c(this.IBo);
            f.a aVar2 = f.IBd;
            int c3 = f.a.c(this.IzA);
            f.a aVar3 = f.IBd;
            int c4 = f.a.c(this.IBp);
            f.a aVar4 = f.IBd;
            ((o) this.IBm.IBa).a(str, c2, c3, c4, f.a.c(this.IBq), this.oHV, this.rrz, this.IBr, this.IBs);
            x xVar = x.SXb;
            AppMethodBeat.o(224839);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ n IBm;
        final /* synthetic */ String IBn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(n nVar, String str) {
            super(0);
            this.IBm = nVar;
            this.IBn = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(224838);
            ((o) this.IBm.IBa).close(this.IBn);
            x xVar = x.SXb;
            AppMethodBeat.o(224838);
            return xVar;
        }
    }
}
