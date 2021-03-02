package com.tencent.mm.plugin.flutter.e;

import android.os.Build;
import com.google.android.gms.dynamite.ProviderConstants;
import com.tencent.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.decode.i;
import com.tencent.mm.plugin.flutter.d.c;
import com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.d;
import com.tencent.mm.xeffect.effect.EffectManager;
import io.flutter.embedding.engine.plugins.a;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\t2\b\b\u0001\u0010\r\u001a\u00020\u000bH\u0016J\u001c\u0010\u000e\u001a\u00020\t2\b\b\u0001\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u0012H\u0016J\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/flutter/plugins/VideoEditorCompositionUiPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", ProviderConstants.API_PATH, "Lcom/tencent/pigeon/VideoEditorCompositionApiPluginApi$VideoEditorCompositionApi;", "channel", "Lio/flutter/plugin/common/MethodChannel;", "onAttachedToEngine", "", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "binding", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "setupApi", "newApi", "Companion", "plugin-flutter_release"})
public final class a implements io.flutter.embedding.engine.plugins.a, k.c {
    public static final C1359a wJv = new C1359a((byte) 0);
    private k bbv;
    private b.as wJu = new com.tencent.mm.plugin.flutter.e.a.a();

    static {
        AppMethodBeat.i(240998);
        AppMethodBeat.o(240998);
    }

    public a() {
        AppMethodBeat.i(240997);
        AppMethodBeat.o(240997);
    }

    @Override // io.flutter.embedding.engine.plugins.a
    public final void a(a.b bVar) {
        AppMethodBeat.i(240994);
        p.h(bVar, "flutterPluginBinding");
        EffectManager.a aVar = EffectManager.RxS;
        EffectManager.a.b(new i());
        com.tencent.mm.videocomposition.b bVar2 = com.tencent.mm.videocomposition.b.RgQ;
        com.tencent.mm.videocomposition.b.a(new d());
        io.flutter.embedding.engine.a hwW = bVar.hwW();
        p.g(hwW, "flutterPluginBinding.flutterEngine");
        hwW.hwF().a(new c());
        this.bbv = new k(bVar.hwX(), "video_editor_composition_ui");
        a aVar2 = new a();
        com.tencent.mm.plugin.flutter.e.a.a aVar3 = new com.tencent.mm.plugin.flutter.e.a.a();
        k kVar = this.bbv;
        if (kVar == null) {
            p.btv("channel");
        }
        kVar.a(aVar2);
        b.as.a(bVar.hwX(), aVar3);
        AppMethodBeat.o(240994);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/flutter/plugins/VideoEditorCompositionUiPlugin$Companion;", "", "()V", "registerWith", "", "registrar", "Lio/flutter/plugin/common/PluginRegistry$Registrar;", "plugin-flutter_release"})
    /* renamed from: com.tencent.mm.plugin.flutter.e.a$a  reason: collision with other inner class name */
    public static final class C1359a {
        private C1359a() {
        }

        public /* synthetic */ C1359a(byte b2) {
            this();
        }
    }

    @Override // io.flutter.plugin.a.k.c
    public final void a(j jVar, k.d dVar) {
        AppMethodBeat.i(240995);
        p.h(jVar, "call");
        p.h(dVar, "result");
        if (p.j(jVar.method, "getPlatformVersion")) {
            dVar.ba("Android " + Build.VERSION.RELEASE);
            AppMethodBeat.o(240995);
            return;
        }
        dVar.dLv();
        AppMethodBeat.o(240995);
    }

    @Override // io.flutter.embedding.engine.plugins.a
    public final void b(a.b bVar) {
        AppMethodBeat.i(240996);
        p.h(bVar, "binding");
        k kVar = this.bbv;
        if (kVar == null) {
            p.btv("channel");
        }
        if (kVar != null) {
            kVar.a(null);
            AppMethodBeat.o(240996);
            return;
        }
        AppMethodBeat.o(240996);
    }
}
