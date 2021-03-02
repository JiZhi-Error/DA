package com.tencent.qqmusic.mediaplayer;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u0007J\u001e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0006J&\u0010\u0012\u001a\u00020\u00072\u001e\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004R&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/qqmusic/mediaplayer/PlayStuckMonitor;", "", "()V", "mCallback", "Lkotlin/Function3;", "", "", "", "mEnable", "mHandler", "Landroid/os/Handler;", "mHandlerThread", "Landroid/os/HandlerThread;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "onPlayStuck", "decodeTime", "playTime", "continuous", "setOnPlayStuckListener", "callback", "player_qqmusic_release"})
public final class PlayStuckMonitor {
    public static final PlayStuckMonitor INSTANCE = new PlayStuckMonitor();
    private static q<? super Long, ? super Long, ? super Boolean, x> mCallback;
    private static boolean mEnable;
    private static Handler mHandler;
    private static HandlerThread mHandlerThread;

    static {
        AppMethodBeat.i(190294);
        AppMethodBeat.o(190294);
    }

    private PlayStuckMonitor() {
    }

    public static final /* synthetic */ q access$getMCallback$p(PlayStuckMonitor playStuckMonitor) {
        AppMethodBeat.i(190295);
        q<? super Long, ? super Long, ? super Boolean, x> qVar = mCallback;
        if (qVar == null) {
            p.btv("mCallback");
        }
        AppMethodBeat.o(190295);
        return qVar;
    }

    public final void init() {
        AppMethodBeat.i(190291);
        HandlerThread handlerThread = new HandlerThread("PlayStuckMonitor");
        mHandlerThread = handlerThread;
        handlerThread.start();
        HandlerThread handlerThread2 = mHandlerThread;
        if (handlerThread2 == null) {
            p.btv("mHandlerThread");
        }
        mHandler = new Handler(handlerThread2.getLooper());
        AppMethodBeat.o(190291);
    }

    public final void setOnPlayStuckListener(q<? super Long, ? super Long, ? super Boolean, x> qVar) {
        AppMethodBeat.i(190292);
        p.h(qVar, "callback");
        mCallback = qVar;
        mEnable = true;
        AppMethodBeat.o(190292);
    }

    public final void onPlayStuck(long j2, long j3, boolean z) {
        AppMethodBeat.i(190293);
        if (mEnable) {
            Handler handler = mHandler;
            if (handler == null) {
                p.btv("mHandler");
            }
            handler.post(new PlayStuckMonitor$onPlayStuck$1(j2, j3, z));
        }
        AppMethodBeat.o(190293);
    }
}
