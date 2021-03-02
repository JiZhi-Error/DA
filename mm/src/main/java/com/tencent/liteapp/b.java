package com.tencent.liteapp;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.plugins.a;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\b\u0001\u0010\u000b\u001a\u00020\tH\u0016J\u001c\u0010\f\u001a\u00020\u00072\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/liteapp/WxaLiteAppPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "channel", "Lio/flutter/plugin/common/MethodChannel;", "onAttachedToEngine", "", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "binding", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "Companion", "wxa_lite_app_release"})
public final class b implements io.flutter.embedding.engine.plugins.a, k.c {
    public static final a cqR = new a((byte) 0);
    private k bbv;

    static {
        AppMethodBeat.i(197922);
        AppMethodBeat.o(197922);
    }

    @Override // io.flutter.embedding.engine.plugins.a
    public final void a(a.b bVar) {
        AppMethodBeat.i(197919);
        p.h(bVar, "flutterPluginBinding");
        this.bbv = new k(bVar.hwW().getDartExecutor(), "wxa_lite_app");
        k kVar = this.bbv;
        if (kVar == null) {
            p.btv("channel");
        }
        kVar.a(this);
        AppMethodBeat.o(197919);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, hxF = {"Lcom/tencent/liteapp/WxaLiteAppPlugin$Companion;", "", "()V", "registerWith", "", "registrar", "Lio/flutter/plugin/common/PluginRegistry$Registrar;", "wxa_lite_app_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // io.flutter.plugin.a.k.c
    public final void a(j jVar, k.d dVar) {
        AppMethodBeat.i(197920);
        p.h(jVar, "call");
        p.h(dVar, "result");
        if (p.j(jVar.method, "getPlatformVersion")) {
            dVar.ba("Android " + Build.VERSION.RELEASE);
            AppMethodBeat.o(197920);
            return;
        }
        dVar.dLv();
        AppMethodBeat.o(197920);
    }

    @Override // io.flutter.embedding.engine.plugins.a
    public final void b(a.b bVar) {
        AppMethodBeat.i(197921);
        p.h(bVar, "binding");
        k kVar = this.bbv;
        if (kVar == null) {
            p.btv("channel");
        }
        kVar.a(null);
        AppMethodBeat.o(197921);
    }
}
