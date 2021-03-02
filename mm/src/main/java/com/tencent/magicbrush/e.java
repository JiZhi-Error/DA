package com.tencent.magicbrush;

import com.facebook.appevents.UserDataStore;
import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.api.IImageDecodeService;
import com.tencent.magicbrush.a.c;
import com.tencent.magicbrush.internal.EventDispatcher;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.config.SharePluginInfo;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 )2\u00020\u0001:\u0004)*+,B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cJ \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\u001fJ\b\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\"\u001a\u00020\u001aH\u0016J\u000e\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(J\b\u0010\u0015\u001a\u00020\u0016H\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e8G¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006-"}, hxF = {"Lcom/tencent/magicbrush/MagicBrush;", "Lcom/tencent/magicbrush/MBRuntime;", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "(Lcom/tencent/magicbrush/MagicBrushBuilder;)V", "canvasHandler", "Lcom/tencent/magicbrush/MBCanvasHandler;", "getCanvasHandler", "()Lcom/tencent/magicbrush/MBCanvasHandler;", "config", "Lcom/tencent/magicbrush/MagicBrushConfig;", "getConfig", "()Lcom/tencent/magicbrush/MagicBrushConfig;", "firstFrameListeners", "Lcom/tencent/magicbrush/utils/ListenerList;", "Lcom/tencent/magicbrush/MagicBrush$FirstFrameListener;", "getFirstFrameListeners", "()Lcom/tencent/magicbrush/utils/ListenerList;", "jsStuffListeners", "Lcom/tencent/magicbrush/MagicBrush$JSStuffListener;", "getJSStuffListeners", "viewManager", "Lcom/tencent/magicbrush/ui/MBViewManager;", "getViewManager", "()Lcom/tencent/magicbrush/ui/MBViewManager;", "bindTo", "", UserDataStore.FIRST_NAME, "Lkotlin/Function0;", "Lcom/tencent/magicbrush/V8RawPointer;", "isolatePtr", "", "contextPtr", "uvLoopPtr", "destroy", "lazyLoadSync", "name", "", "setAnimationFrameHandler", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "Companion", "FirstFrameListener", "ImageDecodeListener", "JSStuffListener", "lib-magicbrush-nano_release"})
public final class e extends MBRuntime {
    public static final a cLB = new a((byte) 0);
    public final b cLA;
    public final g cLw;
    public final com.tencent.magicbrush.utils.c<d> cLx;
    public final com.tencent.magicbrush.utils.c<b> cLy;
    public final MBViewManager cLz;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, hxF = {"Lcom/tencent/magicbrush/MagicBrush$FirstFrameListener;", "", "onFirstFrame", "", "lib-magicbrush-nano_release"})
    public interface b {
        void onFirstFrame();
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, hxF = {"Lcom/tencent/magicbrush/MagicBrush$JSStuffListener;", "", "onConsole", "", "output", "", "onJSError", "exception", SharePluginInfo.ISSUE_KEY_STACK, "contextId", "", "lib-magicbrush-nano_release"})
    public interface d {
        void onConsole(String str);

        void onJSError(String str, String str2, int i2);
    }

    static {
        AppMethodBeat.i(140097);
        AppMethodBeat.o(140097);
    }

    private e(f fVar) {
        AppMethodBeat.i(140096);
        this.cLw = fVar;
        this.cLx = new com.tencent.magicbrush.utils.c<>();
        this.cLy = new com.tencent.magicbrush.utils.c<>();
        this.cLz = new MBViewManager();
        this.cLA = new b(this);
        this.cLb = fVar.cMr;
        this.mNativeInst = nativeCreate(this.cLb);
        nativeSetEventListener(this.mNativeInst, new EventDispatcher(this));
        com.tencent.magicbrush.handler.a aVar = fVar.cLJ;
        if (aVar == null) {
            p.hyc();
        }
        a(aVar);
        BaseImageDecodeService baseImageDecodeService = fVar.cLQ.cMx;
        if (baseImageDecodeService != null) {
            baseImageDecodeService.addDecodeEventListener(new c());
        }
        a(baseImageDecodeService);
        a(fVar.cLR);
        Rb();
        kotlin.g.a.a<aj> aVar2 = fVar.cLK;
        if (aVar2 == null) {
            p.hyc();
        }
        d(aVar2);
        AppMethodBeat.o(140096);
    }

    public /* synthetic */ e(f fVar, byte b2) {
        this(fVar);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.magicbrush.e$e  reason: collision with other inner class name */
    public static final class RunnableC0198e implements Runnable {
        final /* synthetic */ e cLC;
        final /* synthetic */ kotlin.g.a.a cLD;

        RunnableC0198e(e eVar, kotlin.g.a.a aVar) {
            this.cLC = eVar;
            this.cLD = aVar;
        }

        public final void run() {
            AppMethodBeat.i(140090);
            aj ajVar = (aj) this.cLD.invoke();
            this.cLC.nativeBindTo(this.cLC.mNativeInst, ajVar.cMz, ajVar.cMA, ajVar.cMB);
            AppMethodBeat.o(140090);
        }
    }

    public final void d(kotlin.g.a.a<aj> aVar) {
        AppMethodBeat.i(140093);
        p.h(aVar, UserDataStore.FIRST_NAME);
        m(new RunnableC0198e(this, aVar));
        AppMethodBeat.o(140093);
    }

    public final void dX(String str) {
        AppMethodBeat.i(206821);
        p.h(str, "name");
        c.C0193c.i("MagicBrush", "hy: trigger load ".concat(String.valueOf(str)), new Object[0]);
        com.tencent.magicbrush.a.b.loadLibrary(str);
        String dZ = com.tencent.magicbrush.a.b.dZ(str);
        if (dZ != null) {
            if (!(dZ.length() == 0)) {
                switch (str.hashCode()) {
                    case 1168159709:
                        if (str.equals("mmbox2d")) {
                            nativeLazyLoadBox2D(this.mNativeInst, dZ);
                            AppMethodBeat.o(206821);
                            return;
                        }
                        break;
                    case 1180883462:
                        if (str.equals("mmphysx")) {
                            nativeLazyLoadPhysx(this.mNativeInst, dZ);
                            AppMethodBeat.o(206821);
                            return;
                        }
                        break;
                }
                c.C0193c.e("MagicBrush", "hy: not support", new Object[0]);
                AppMethodBeat.o(206821);
                return;
            }
        }
        c.C0193c.e("MagicBrush", "hy: can not find " + str + " path", new Object[0]);
        AppMethodBeat.o(206821);
    }

    @Override // com.tencent.magicbrush.MBRuntime
    public final void destroy() {
        AppMethodBeat.i(140094);
        c.C0193c.i("MagicBrush", "MagicBrush is destroying...", new Object[0]);
        super.destroy();
        this.cLz.clear$lib_magicbrush_nano_release();
        this.cLx.clear();
        this.cLy.clear();
        c.C0193c.i("MagicBrush", "MagicBrush is destroying...[done]", new Object[0]);
        AppMethodBeat.o(140094);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.magicbrush.MBRuntime
    public final b Ri() {
        return this.cLA;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.magicbrush.MBRuntime
    public final MBViewManager Rj() {
        return this.cLz;
    }

    public final void a(a.b bVar) {
        AppMethodBeat.i(140095);
        p.h(bVar, "strategy");
        boolean z = this.cLj != null;
        if (aa.SXc && !z) {
            AssertionError assertionError = new AssertionError("Assertion failed");
            AppMethodBeat.o(140095);
            throw assertionError;
        } else if (this.cLj.RB() == bVar) {
            AppMethodBeat.o(140095);
        } else {
            c.C0193c.i("MagicBrush", "MagicBrush is changing AnimationFrameHandler strategy from " + this.cLj.RB() + ' ' + "to " + bVar, new Object[0]);
            a.C0200a aVar = com.tencent.magicbrush.ui.a.cOx;
            com.tencent.magicbrush.handler.c Rl = Rl();
            p.g(Rl, "jsThreadHandler");
            m(new g(this, a.C0200a.a(this, Rl, bVar)));
            AppMethodBeat.o(140095);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class g implements Runnable {
        final /* synthetic */ e cLC;
        final /* synthetic */ com.tencent.magicbrush.ui.a cLH;

        g(e eVar, com.tencent.magicbrush.ui.a aVar) {
            this.cLC = eVar;
            this.cLH = aVar;
        }

        public final void run() {
            AppMethodBeat.i(140092);
            com.tencent.magicbrush.ui.a aVar = this.cLC.cLj;
            this.cLC.cLj.pause();
            this.cLC.cLj = this.cLH;
            this.cLC.cLj.resume();
            aVar.destroy();
            AppMethodBeat.o(140092);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J*\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, hxF = {"Lcom/tencent/magicbrush/MagicBrush$ImageDecodeListener;", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$IDecodeEventListener;", "(Lcom/tencent/magicbrush/MagicBrush;)V", "onDecodeEvent", "", "path", "", "event", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$IDecodeEventListener$Event;", "decodeInfo", "Lcom/github/henryye/nativeiv/api/DecodeInfo;", "onDecodeResult", "image", "", "recycleHandler", "Lcom/github/henryye/nativeiv/api/IImageDecodeService$IRecycleHandler;", "config", "Lcom/github/henryye/nativeiv/ImageDecodeConfig;", "lib-magicbrush-nano_release"})
    final class c implements IImageDecodeService.b {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c() {
        }

        @Override // com.github.henryye.nativeiv.api.IImageDecodeService.b
        public final void a(String str, IImageDecodeService.b.a aVar, com.github.henryye.nativeiv.api.a aVar2) {
            AppMethodBeat.i(140088);
            p.h(str, "path");
            p.h(aVar, "event");
            p.h(aVar2, "decodeInfo");
            AppMethodBeat.o(140088);
        }

        @Override // com.github.henryye.nativeiv.api.IImageDecodeService.b
        public final void a(String str, Object obj, IImageDecodeService.c cVar, ImageDecodeConfig imageDecodeConfig) {
            AppMethodBeat.i(140089);
            p.h(str, "path");
            p.h(cVar, "recycleHandler");
            p.h(imageDecodeConfig, "config");
            e.this.b(str, obj, cVar, imageDecodeConfig);
            AppMethodBeat.o(140089);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nJ!\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\b\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/magicbrush/MagicBrush$Companion;", "", "()V", "DEFAULT_WINDOW_ID", "", "TAG", "", "create", "Lcom/tencent/magicbrush/MagicBrush;", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "dls", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "lib-magicbrush-nano_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static e b(f fVar) {
            AppMethodBeat.i(206820);
            p.h(fVar, "builder");
            if (!com.tencent.magicbrush.internal.a.d(fVar)) {
                AppMethodBeat.o(206820);
                return null;
            }
            e eVar = new e(fVar, (byte) 0);
            AppMethodBeat.o(206820);
            return eVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/magicbrush/V8RawPointer;", "invoke"})
    public static final class f extends q implements kotlin.g.a.a<aj> {
        final /* synthetic */ long cLE;
        final /* synthetic */ long cLF;
        final /* synthetic */ long cLG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(long j2, long j3, long j4) {
            super(0);
            this.cLE = j2;
            this.cLF = j3;
            this.cLG = j4;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ aj invoke() {
            AppMethodBeat.i(140091);
            aj ajVar = new aj(this.cLE, this.cLF, this.cLG);
            AppMethodBeat.o(140091);
            return ajVar;
        }
    }
}
