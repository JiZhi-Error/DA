package com.tencent.mm.plugin.flutter.e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.flutter.PluginFlutter;
import com.tencent.mm.sdk.platformtools.Log;
import io.flutter.plugin.a.k;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\b\u0012¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0001R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/flutter/plugins/video/api/MethodCallToFlutter;", "", "()V", "TAG", "", "dispatchMethod", "", "methodName", "parameter", "Companion", "plugin-flutter_release"})
public final class o {
    private static o wKH;
    public static final a wKI = new a((byte) 0);
    private final String TAG;

    static {
        AppMethodBeat.i(241116);
        AppMethodBeat.o(241116);
    }

    public /* synthetic */ o(byte b2) {
        this();
    }

    private o() {
        this.TAG = "MethodCallToFlutter";
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/flutter/plugins/video/api/MethodCallToFlutter$Companion;", "", "()V", "mInstance", "Lcom/tencent/mm/plugin/flutter/plugins/video/api/MethodCallToFlutter;", "getInstance", "plugin-flutter_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static o dMh() {
            AppMethodBeat.i(241111);
            if (o.wKH == null) {
                o.wKH = new o((byte) 0);
            }
            o oVar = o.wKH;
            if (oVar == null) {
                p.hyc();
            }
            AppMethodBeat.o(241111);
            return oVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/flutter/plugins/video/api/MethodCallToFlutter$dispatchMethod$1", "Lio/flutter/plugin/common/MethodChannel$Result;", "error", "", "p0", "", "p1", "p2", "", "notImplemented", "success", "plugin-flutter_release"})
    public static final class b implements k.d {
        final /* synthetic */ o wKJ;
        final /* synthetic */ String wKK;

        b(o oVar, String str) {
            this.wKJ = oVar;
            this.wKK = str;
        }

        @Override // io.flutter.plugin.a.k.d
        public final void dLv() {
            AppMethodBeat.i(241112);
            Log.i(this.wKJ.TAG, "callback to flutter notImplemented");
            AppMethodBeat.o(241112);
        }

        @Override // io.flutter.plugin.a.k.d
        public final void b(String str, String str2, Object obj) {
            AppMethodBeat.i(241113);
            Log.i(this.wKJ.TAG, "callback to flutter error " + str + ' ' + str2);
            AppMethodBeat.o(241113);
        }

        @Override // io.flutter.plugin.a.k.d
        public final void ba(Object obj) {
            AppMethodBeat.i(241114);
            Log.i(this.wKJ.TAG, "callback to flutter success " + this.wKK);
            AppMethodBeat.o(241114);
        }
    }

    public final void t(String str, Object obj) {
        AppMethodBeat.i(241115);
        p.h(str, "methodName");
        p.h(obj, "parameter");
        try {
            com.tencent.mm.kernel.b.a ah = g.ah(PluginFlutter.class);
            p.g(ah, "MMKernel.plugin(PluginFlutter::class.java)");
            k kVar = ((PluginFlutter) ah).getFlutterEngineMgr().wJm;
            if (kVar == null) {
                p.hyc();
            }
            kVar.a(str, obj, new b(this, str));
            AppMethodBeat.o(241115);
        } catch (Exception e2) {
            Log.e(this.TAG, "invoke error " + str + " " + e2.getLocalizedMessage());
            AppMethodBeat.o(241115);
        }
    }
}
