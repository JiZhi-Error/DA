package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMAuthScopeRiskInfo;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMAuthScopeRiskWxaAppInfo;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper;", "", "()V", "Companion", "IPositivePerformer", "plugin-appbrand-integration_release"})
public final class h {
    private static final String TAG = TAG;
    public static final a lFG = new a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "showDialog", "", "context", "Landroid/content/Context;", "content", "positiveBtnText", "negativeBtnText", "positivePerformer", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "kotlin.jvm.PlatformType", "onDialogClick"})
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.h$a$a  reason: collision with other inner class name */
        public static final class C0635a implements f.c {
            public static final C0635a lFH = new C0635a();

            static {
                AppMethodBeat.i(228302);
                AppMethodBeat.o(228302);
            }

            C0635a() {
            }

            @Override // com.tencent.mm.ui.widget.a.f.c
            public final void e(boolean z, String str) {
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "kotlin.jvm.PlatformType", "onDialogClick"})
        public static final class b implements f.c {
            final /* synthetic */ b lFI;

            b(b bVar) {
                this.lFI = bVar;
            }

            @Override // com.tencent.mm.ui.widget.a.f.c
            public final void e(boolean z, String str) {
                AppMethodBeat.i(228303);
                this.lFI.perform();
                AppMethodBeat.o(228303);
            }
        }
    }

    static {
        AppMethodBeat.i(228309);
        AppMethodBeat.o(228309);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u0001\u0003\t\n\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "", "()V", "perform", "", "Companion", "None", "OpenUrl", "OpenWxa", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$OpenUrl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$OpenWxa;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$None;", "plugin-appbrand-integration_release"})
    public static abstract class b {
        public static final a lFJ = new a((byte) 0);

        public abstract void perform();

        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$Companion;", "", "()V", "create", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "context", "Landroid/content/Context;", "info", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMAuthScopeRiskInfo;", "plugin-appbrand-integration_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$OpenUrl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "context", "Landroid/content/Context;", "url", "", "(Landroid/content/Context;Ljava/lang/String;)V", "perform", "", "plugin-appbrand-integration_release"})
        public static final class c extends b {
            private final Context context;
            private final String url;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(Context context2, String str) {
                super((byte) 0);
                p.h(context2, "context");
                p.h(str, "url");
                AppMethodBeat.i(228306);
                this.context = context2;
                this.url = str;
                AppMethodBeat.o(228306);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.h.b
            public final void perform() {
                AppMethodBeat.i(228305);
                Context context2 = this.context;
                Intent intent = new Intent();
                intent.putExtra("rawUrl", this.url);
                com.tencent.mm.br.c.b(context2, "webview", ".ui.tools.WebViewUI", intent.putExtra("forceHideShare", true));
                AppMethodBeat.o(228305);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$OpenWxa;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "context", "Landroid/content/Context;", "userName", "", "versionType", "", "path", "scene", "version", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;II)V", "perform", "", "plugin-appbrand-integration_release"})
        public static final class d extends b {
            private final Context context;
            private final int iOo;
            private final String path;
            private final int scene;
            private final String userName;
            private final int version;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(Context context2, String str, int i2, String str2, int i3, int i4) {
                super((byte) 0);
                p.h(context2, "context");
                p.h(str, "userName");
                p.h(str2, "path");
                AppMethodBeat.i(228308);
                this.context = context2;
                this.userName = str;
                this.iOo = i2;
                this.path = str2;
                this.scene = i3;
                this.version = i4;
                AppMethodBeat.o(228308);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.h.b
            public final void perform() {
                AppMethodBeat.i(228307);
                g gVar = new g();
                gVar.username = this.userName;
                gVar.kHw = this.path;
                gVar.scene = this.scene;
                gVar.iOo = this.iOo;
                gVar.version = this.version;
                ((r) com.tencent.mm.kernel.g.af(r.class)).a(this.context, gVar);
                AppMethodBeat.o(228307);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer$None;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeRiskInterceptionHelper$IPositivePerformer;", "()V", "perform", "", "plugin-appbrand-integration_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.h$b$b  reason: collision with other inner class name */
        public static final class C0636b extends b {
            public static final C0636b lFK = new C0636b();

            static {
                AppMethodBeat.i(228304);
                AppMethodBeat.o(228304);
            }

            private C0636b() {
                super((byte) 0);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.h.b
            public final void perform() {
            }
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public static final b a(Context context, MMAuthScopeRiskInfo mMAuthScopeRiskInfo) {
            p.h(context, "context");
            p.h(mMAuthScopeRiskInfo, "info");
            switch (mMAuthScopeRiskInfo.lHz) {
                case 1:
                    return new c(context, "");
                case 2:
                    return new c(context, mMAuthScopeRiskInfo.lHC);
                case 3:
                    MMAuthScopeRiskWxaAppInfo mMAuthScopeRiskWxaAppInfo = mMAuthScopeRiskInfo.lHD;
                    if (mMAuthScopeRiskWxaAppInfo != null) {
                        return new d(context, mMAuthScopeRiskWxaAppInfo.username, mMAuthScopeRiskWxaAppInfo.type, mMAuthScopeRiskWxaAppInfo.path, mMAuthScopeRiskWxaAppInfo.scene, mMAuthScopeRiskWxaAppInfo.version);
                    }
                    break;
            }
            return C0636b.lFK;
        }
    }

    public static final void a(Context context, String str, String str2, String str3, b bVar, DialogInterface.OnDismissListener onDismissListener) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(228310);
        p.h(context, "context");
        p.h(str, "content");
        p.h(str2, "positiveBtnText");
        p.h(str3, "negativeBtnText");
        p.h(bVar, "positivePerformer");
        f.a aVar = new f.a(context);
        aVar.bow(str);
        aVar.boA(str2);
        if (str3.length() > 0) {
            aVar.boB(str3);
        }
        aVar.a(a.C0635a.lFH, new a.b(bVar));
        aVar.b(onDismissListener);
        aVar.show();
        d hbv = aVar.hbv();
        if (str3.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        hbv.bT(-2, z);
        d hbv2 = aVar.hbv();
        if (str2.length() <= 0) {
            z2 = false;
        }
        hbv2.bT(-1, z2);
        AppMethodBeat.o(228310);
    }
}
