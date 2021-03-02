package com.tencent.mm.plugin.webview.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0016J0\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\nH\u0016J-\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J5\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/webview/permission/UIThreadAuthCallBack;", "T", "Lcom/tencent/mm/plugin/webview/permission/AuthCallback;", "authCallback", "(Lcom/tencent/mm/plugin/webview/permission/AuthCallback;)V", "onAuthEnd", "", "reason", "", "reqUrl", "", "onAuthStart", "onContentRedirect", "content", "onError", "errType", "errCode", "errMsg", "onPermissionUpdate", "fullUrl", "response", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "onProcessResult", "", "(ILjava/lang/String;Ljava/lang/Object;)Z", "onUrlRedirect", "forceRedirect", "(IZLjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "webview-sdk_release"})
public final class f<T> implements a<T> {
    final a<T> Jcl;

    public f(a<T> aVar) {
        p.h(aVar, "authCallback");
        AppMethodBeat.i(225141);
        this.Jcl = aVar;
        AppMethodBeat.o(225141);
    }

    @Override // com.tencent.mm.plugin.webview.f.a
    public final void by(int i2, String str) {
        AppMethodBeat.i(225134);
        p.h(str, "reqUrl");
        com.tencent.mm.ac.d.h(new b(this, i2, str));
        AppMethodBeat.o(225134);
    }

    @Override // com.tencent.mm.plugin.webview.f.a
    public final void bx(int i2, String str) {
        AppMethodBeat.i(225135);
        p.h(str, "reqUrl");
        com.tencent.mm.ac.d.h(new a(this, i2, str));
        AppMethodBeat.o(225135);
    }

    @Override // com.tencent.mm.plugin.webview.f.a
    public final boolean b(int i2, String str, T t) {
        AppMethodBeat.i(225136);
        p.h(str, "reqUrl");
        boolean b2 = this.Jcl.b(i2, str, t);
        AppMethodBeat.o(225136);
        return b2;
    }

    @Override // com.tencent.mm.plugin.webview.f.a
    public final void a(int i2, String str, String str2, T t) {
        AppMethodBeat.i(225137);
        p.h(str, "reqUrl");
        p.h(str2, "fullUrl");
        com.tencent.mm.ac.d.h(new e(this, i2, str, str2, t));
        AppMethodBeat.o(225137);
    }

    @Override // com.tencent.mm.plugin.webview.f.a
    public final void a(int i2, boolean z, String str, String str2, T t) {
        AppMethodBeat.i(225138);
        p.h(str, "reqUrl");
        p.h(str2, "fullUrl");
        com.tencent.mm.ac.d.h(new C1951f(this, i2, z, str, str2, t));
        AppMethodBeat.o(225138);
    }

    @Override // com.tencent.mm.plugin.webview.f.a
    public final void C(int i2, String str, String str2) {
        AppMethodBeat.i(225139);
        com.tencent.mm.ac.d.h(new c(this, i2, str, str2));
        AppMethodBeat.o(225139);
    }

    @Override // com.tencent.mm.plugin.webview.f.a
    public final void a(int i2, String str, int i3, int i4, String str2) {
        AppMethodBeat.i(225140);
        p.h(str, "reqUrl");
        p.h(str2, "errMsg");
        com.tencent.mm.ac.d.h(new d(this, i2, str, i3, i4, str2));
        AppMethodBeat.o(225140);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "T", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ f Jcm;
        final /* synthetic */ int kVT;
        final /* synthetic */ String pGq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(f fVar, int i2, String str) {
            super(0);
            this.Jcm = fVar;
            this.kVT = i2;
            this.pGq = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(225129);
            this.Jcm.Jcl.by(this.kVT, this.pGq);
            x xVar = x.SXb;
            AppMethodBeat.o(225129);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "T", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ f Jcm;
        final /* synthetic */ int kVT;
        final /* synthetic */ String pGq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(f fVar, int i2, String str) {
            super(0);
            this.Jcm = fVar;
            this.kVT = i2;
            this.pGq = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(225128);
            this.Jcm.Jcl.bx(this.kVT, this.pGq);
            x xVar = x.SXb;
            AppMethodBeat.o(225128);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "T", "invoke"})
    static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ f Jcm;
        final /* synthetic */ String Jcn;
        final /* synthetic */ Object Jco;
        final /* synthetic */ int kVT;
        final /* synthetic */ String pGq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(f fVar, int i2, String str, String str2, Object obj) {
            super(0);
            this.Jcm = fVar;
            this.kVT = i2;
            this.pGq = str;
            this.Jcn = str2;
            this.Jco = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.tencent.mm.plugin.webview.f.a<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(225132);
            this.Jcm.Jcl.a(this.kVT, this.pGq, this.Jcn, this.Jco);
            x xVar = x.SXb;
            AppMethodBeat.o(225132);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "T", "invoke"})
    /* renamed from: com.tencent.mm.plugin.webview.f.f$f  reason: collision with other inner class name */
    static final class C1951f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ f Jcm;
        final /* synthetic */ String Jcn;
        final /* synthetic */ Object Jco;
        final /* synthetic */ boolean Jcp;
        final /* synthetic */ int kVT;
        final /* synthetic */ String pGq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1951f(f fVar, int i2, boolean z, String str, String str2, Object obj) {
            super(0);
            this.Jcm = fVar;
            this.kVT = i2;
            this.Jcp = z;
            this.pGq = str;
            this.Jcn = str2;
            this.Jco = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.tencent.mm.plugin.webview.f.a<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(225133);
            this.Jcm.Jcl.a(this.kVT, this.Jcp, this.pGq, this.Jcn, this.Jco);
            x xVar = x.SXb;
            AppMethodBeat.o(225133);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "T", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ f Jcm;
        final /* synthetic */ String grJ;
        final /* synthetic */ int kVT;
        final /* synthetic */ String pGq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(f fVar, int i2, String str, String str2) {
            super(0);
            this.Jcm = fVar;
            this.kVT = i2;
            this.pGq = str;
            this.grJ = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(225130);
            this.Jcm.Jcl.C(this.kVT, this.pGq, this.grJ);
            x xVar = x.SXb;
            AppMethodBeat.o(225130);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "T", "invoke"})
    static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ int $errCode;
        final /* synthetic */ String $errMsg;
        final /* synthetic */ int $errType;
        final /* synthetic */ f Jcm;
        final /* synthetic */ int kVT;
        final /* synthetic */ String pGq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(f fVar, int i2, String str, int i3, int i4, String str2) {
            super(0);
            this.Jcm = fVar;
            this.kVT = i2;
            this.pGq = str;
            this.$errType = i3;
            this.$errCode = i4;
            this.$errMsg = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(225131);
            this.Jcm.Jcl.a(this.kVT, this.pGq, this.$errType, this.$errCode, this.$errMsg);
            x xVar = x.SXb;
            AppMethodBeat.o(225131);
            return xVar;
        }
    }
}
