package com.tencent.magicbrush.ui;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.a.c;
import com.tencent.magicbrush.handler.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.m;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\n\b&\u0018\u0000 &2\u00020\u0001:\u0003&'(B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0018\u001a\u00020\u0019H\u0003J\b\u0010\u001a\u001a\u00020\u0019H\u0007J\b\u0010\u001b\u001a\u00020\u001cH\u0017J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\b\u0010 \u001a\u00020\u0019H&J\b\u0010!\u001a\u00020\u0019H&J\b\u0010\"\u001a\u00020\u0019H&J\b\u0010#\u001a\u00020\u0019H&J\b\u0010$\u001a\u00020\u0019H\u0007J\b\u0010%\u001a\u00020\u0019H\u0007R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006)"}, hxF = {"Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "isRunning", "", "()Z", "setRunning", "(Z)V", "getJsThreadHandler", "()Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "locker", "Ljava/lang/Object;", "getLocker", "()Ljava/lang/Object;", "getRuntime", "()Lcom/tencent/magicbrush/MBRuntime;", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "create", "", "destroy", "getLatency", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Latency;", "notifyAnimationFrame", "frameTimeMillis", "", "onCreate", "onDestroy", "onPause", "onResume", "pause", "resume", "Companion", "Latency", "Strategy", "lib-magicbrush-nano_release"})
public abstract class a {
    public static final C0200a cOx = new C0200a((byte) 0);
    final MBRuntime cKJ;
    final Object cOv = new Object();
    final c cOw;
    boolean isRunning;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "", "(Ljava/lang/String;I)V", "ChoreographerInJsThread", "ChoreographerInMainThread", "EglSurfaceSwapLocker", "SchedulerLocker", "NativeLocker", "lib-magicbrush-nano_release"})
    public enum b {
        ChoreographerInJsThread,
        ChoreographerInMainThread,
        EglSurfaceSwapLocker,
        SchedulerLocker,
        NativeLocker;

        static {
            AppMethodBeat.i(140205);
            AppMethodBeat.o(140205);
        }

        public static b valueOf(String str) {
            AppMethodBeat.i(140207);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(140207);
            return bVar;
        }
    }

    public static final a a(MBRuntime mBRuntime, c cVar, b bVar) {
        return C0200a.a(mBRuntime, cVar, bVar);
    }

    public abstract b RB();

    public abstract void onCreate();

    public abstract void onPause();

    public abstract void onResume();

    public a(MBRuntime mBRuntime, c cVar) {
        p.h(mBRuntime, "runtime");
        p.h(cVar, "jsThreadHandler");
        this.cKJ = mBRuntime;
        this.cOw = cVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Companion;", "", "()V", "TAG", "", "create", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "lib-magicbrush-nano_release"})
    /* renamed from: com.tencent.magicbrush.ui.a$a  reason: collision with other inner class name */
    public static final class C0200a {
        private C0200a() {
        }

        public /* synthetic */ C0200a(byte b2) {
            this();
        }

        public static a a(MBRuntime mBRuntime, c cVar, b bVar) {
            j jVar;
            AppMethodBeat.i(206868);
            p.h(mBRuntime, "runtime");
            p.h(cVar, "jsThreadHandler");
            p.h(bVar, "strategy");
            switch (b.$EnumSwitchMapping$0[bVar.ordinal()]) {
                case 1:
                    jVar = new c(mBRuntime, cVar);
                    break;
                case 2:
                    jVar = new d(mBRuntime, cVar);
                    break;
                case 3:
                    jVar = new e(mBRuntime, cVar);
                    break;
                case 4:
                    jVar = new k(mBRuntime, cVar);
                    break;
                case 5:
                    jVar = new j(mBRuntime, cVar);
                    break;
                default:
                    m mVar = new m();
                    AppMethodBeat.o(206868);
                    throw mVar;
            }
            a.a(jVar);
            AppMethodBeat.o(206868);
            return jVar;
        }
    }

    public final void resume() {
        c.C0193c.i("AnimationFrameHandler", "AnimationFrameHandler[%s] resume", RB().name());
        synchronized (this.cOv) {
            if (!this.isRunning) {
                onResume();
                this.isRunning = true;
                x xVar = x.SXb;
            }
        }
    }

    public final void pause() {
        c.C0193c.i("AnimationFrameHandler", "AnimationFrameHandler[%s] pause", RB().name());
        synchronized (this.cOv) {
            if (this.isRunning) {
                onPause();
                this.isRunning = false;
                x xVar = x.SXb;
            }
        }
    }

    public final void destroy() {
        c.C0193c.i("AnimationFrameHandler", "AnimationFrameHandler[%s] destroy", RB().name());
        synchronized (this.cOv) {
            if (this.isRunning) {
                c.C0193c.i("AnimationFrameHandler", "AnimationFrameHandler[%s] pause automatically", RB().name());
                pause();
            }
            x xVar = x.SXb;
        }
    }

    public final void h(double d2) {
        this.cKJ.h(d2);
    }

    public static final /* synthetic */ void a(a aVar) {
        StringBuilder append = new StringBuilder("AnimationFrameHandler[").append(aVar.RB().name()).append("] create ");
        Thread currentThread = Thread.currentThread();
        p.g(currentThread, "Thread.currentThread()");
        c.C0193c.i("AnimationFrameHandler", append.append(currentThread.getName()).toString(), new Object[0]);
        aVar.onCreate();
    }
}
