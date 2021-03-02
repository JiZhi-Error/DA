package com.tencent.magicbrush.internal;

import android.support.annotation.Keep;
import com.tencent.magicbrush.a.c;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.sqlitelint.config.SharePluginInfo;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J6\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0\u000eH\u0002J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\b\u0010\u0016\u001a\u00020\bH\u0007J \u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0012H\u0007J\u0018\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0012H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001d"}, hxF = {"Lcom/tencent/magicbrush/internal/EventDispatcher;", "", "magicbrush", "Lcom/tencent/magicbrush/MagicBrush;", "(Lcom/tencent/magicbrush/MagicBrush;)V", "getMagicbrush", "()Lcom/tencent/magicbrush/MagicBrush;", "dispatchTryCatch", "", "T", "R", "l", "Lcom/tencent/magicbrush/utils/ListenerList;", "block", "Lkotlin/Function1;", "getRenderingContextListener", "Lcom/tencent/magicbrush/ui/MagicBrushView$RenderingContextListener;", "virtualElementId", "", "onConsole", "output", "", "onFirstFrameRendered", "onJSError", "exception", SharePluginInfo.ISSUE_KEY_STACK, "contextId", "onScreenCanvasRenderingContextCreated", "type", "lib-magicbrush-nano_release"})
public final class EventDispatcher {
    private final e cui;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/magicbrush/MagicBrush$JSStuffListener;", "invoke"})
    static final class a extends q implements kotlin.g.a.b<e.d, x> {
        final /* synthetic */ String cOp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str) {
            super(1);
            this.cOp = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(e.d dVar) {
            AppMethodBeat.i(140188);
            e.d dVar2 = dVar;
            p.h(dVar2, LocaleUtil.ITALIAN);
            dVar2.onConsole(this.cOp);
            x xVar = x.SXb;
            AppMethodBeat.o(140188);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/magicbrush/MagicBrush$FirstFrameListener;", "invoke"})
    static final class b extends q implements kotlin.g.a.b<e.b, x> {
        public static final b cOq = new b();

        static {
            AppMethodBeat.i(140190);
            AppMethodBeat.o(140190);
        }

        b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(e.b bVar) {
            AppMethodBeat.i(140189);
            e.b bVar2 = bVar;
            p.h(bVar2, LocaleUtil.ITALIAN);
            bVar2.onFirstFrame();
            x xVar = x.SXb;
            AppMethodBeat.o(140189);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/magicbrush/MagicBrush$JSStuffListener;", "invoke"})
    static final class c extends q implements kotlin.g.a.b<e.d, x> {
        final /* synthetic */ String cOr;
        final /* synthetic */ String cOs;
        final /* synthetic */ int cOt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(String str, String str2, int i2) {
            super(1);
            this.cOr = str;
            this.cOs = str2;
            this.cOt = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(e.d dVar) {
            AppMethodBeat.i(140191);
            e.d dVar2 = dVar;
            p.h(dVar2, LocaleUtil.ITALIAN);
            dVar2.onJSError(this.cOr, this.cOs, this.cOt);
            x xVar = x.SXb;
            AppMethodBeat.o(140191);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/magicbrush/ui/MagicBrushView$RenderingContextListener;", "invoke"})
    static final class d extends q implements kotlin.g.a.b<MagicBrushView.g, x> {
        final /* synthetic */ int $type;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(int i2) {
            super(1);
            this.$type = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(MagicBrushView.g gVar) {
            AppMethodBeat.i(140192);
            MagicBrushView.g gVar2 = gVar;
            p.h(gVar2, LocaleUtil.ITALIAN);
            gVar2.hI(this.$type);
            x xVar = x.SXb;
            AppMethodBeat.o(140192);
            return xVar;
        }
    }

    public EventDispatcher(e eVar) {
        p.h(eVar, "magicbrush");
        AppMethodBeat.i(140198);
        this.cui = eVar;
        AppMethodBeat.o(140198);
    }

    @Keep
    public final void onJSError(String str, String str2, int i2) {
        AppMethodBeat.i(140193);
        p.h(str, "exception");
        p.h(str2, SharePluginInfo.ISSUE_KEY_STACK);
        a(this.cui.cLx, new c(str, str2, i2));
        AppMethodBeat.o(140193);
    }

    @Keep
    public final void onConsole(String str) {
        AppMethodBeat.i(140194);
        p.h(str, "output");
        a(this.cui.cLx, new a(str));
        AppMethodBeat.o(140194);
    }

    @Keep
    public final void onFirstFrameRendered() {
        AppMethodBeat.i(140195);
        a(this.cui.cLy, b.cOq);
        AppMethodBeat.o(140195);
    }

    private static <T, R> void a(com.tencent.magicbrush.utils.c<T> cVar, kotlin.g.a.b<? super T, ? extends R> bVar) {
        AppMethodBeat.i(140197);
        try {
            cVar.b(bVar);
            AppMethodBeat.o(140197);
        } catch (Exception e2) {
            c.C0193c.printStackTrace("MagicBrush", e2, "dispatch event failed", new Object[0]);
            AppMethodBeat.o(140197);
        }
    }

    @Keep
    public final void onScreenCanvasRenderingContextCreated(int i2, int i3) {
        AppMethodBeat.i(140196);
        try {
            this.cui.cLz.find(i2).getRenderingContextListeners().c(new d(i3));
            AppMethodBeat.o(140196);
        } catch (Exception e2) {
            c.C0193c.e("MagicBrush", "onScreenCanvasRenderingContextCreated error: ".concat(String.valueOf(e2)), new Object[0]);
            AppMethodBeat.o(140196);
        }
    }
}
