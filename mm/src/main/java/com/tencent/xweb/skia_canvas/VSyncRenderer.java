package com.tencent.xweb.skia_canvas;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.skia_canvas.VSyncWaiter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
public class VSyncRenderer implements VSyncWaiter.VSyncWaiterCallback {
    private static ThreadLocal<VSyncRenderer> sRendererList = new ThreadLocal<>();
    private final Map<Long, AnimationCallback> mAnimationCallbackIdMap = new HashMap();
    private long mAnimationCallbackUniqueId;
    private final List<PresentCallback> mPresentCallbackList = new LinkedList();
    private final long mStartFrameTimeNanos = SystemClock.elapsedRealtimeNanos();
    private final IXWebWorkingHandler mThreadHandler;
    private boolean mWaitingForNextVSync;

    /* access modifiers changed from: package-private */
    public interface AnimationCallback {
        void doAnimation(long j2);
    }

    /* access modifiers changed from: package-private */
    public interface PresentCallback {
        void doPresent();
    }

    static {
        AppMethodBeat.i(217605);
        AppMethodBeat.o(217605);
    }

    static void initRenderer(IXWebWorkingHandler iXWebWorkingHandler) {
        AppMethodBeat.i(217594);
        if (sRendererList.get() == null) {
            sRendererList.set(new VSyncRenderer(iXWebWorkingHandler));
        }
        AppMethodBeat.o(217594);
    }

    static VSyncRenderer getInstance() {
        AppMethodBeat.i(217595);
        VSyncRenderer vSyncRenderer = sRendererList.get();
        AppMethodBeat.o(217595);
        return vSyncRenderer;
    }

    VSyncRenderer(IXWebWorkingHandler iXWebWorkingHandler) {
        AppMethodBeat.i(217596);
        this.mThreadHandler = iXWebWorkingHandler;
        AppMethodBeat.o(217596);
    }

    /* access modifiers changed from: package-private */
    public void addPresentCallback(PresentCallback presentCallback) {
        AppMethodBeat.i(217597);
        this.mPresentCallbackList.add(presentCallback);
        triggerNextVSync();
        AppMethodBeat.o(217597);
    }

    /* access modifiers changed from: package-private */
    public void removePresentCallback(PresentCallback presentCallback) {
        AppMethodBeat.i(217598);
        this.mPresentCallbackList.remove(presentCallback);
        AppMethodBeat.o(217598);
    }

    /* access modifiers changed from: package-private */
    public long addAnimationCallback(AnimationCallback animationCallback) {
        AppMethodBeat.i(217599);
        long generateAnimationCallbackUniqueId = generateAnimationCallbackUniqueId();
        this.mAnimationCallbackIdMap.put(Long.valueOf(generateAnimationCallbackUniqueId), animationCallback);
        triggerNextVSync();
        AppMethodBeat.o(217599);
        return generateAnimationCallbackUniqueId;
    }

    /* access modifiers changed from: package-private */
    public void removeAnimationCallback(long j2) {
        AppMethodBeat.i(217600);
        this.mAnimationCallbackIdMap.remove(Long.valueOf(j2));
        AppMethodBeat.o(217600);
    }

    private long generateAnimationCallbackUniqueId() {
        long j2 = this.mAnimationCallbackUniqueId;
        this.mAnimationCallbackUniqueId = 1 + j2;
        return j2;
    }

    private void checkAndPost(Runnable runnable) {
        AppMethodBeat.i(217601);
        if (this.mThreadHandler.isRunOnWorkingThread()) {
            runnable.run();
            AppMethodBeat.o(217601);
            return;
        }
        this.mThreadHandler.post(runnable);
        AppMethodBeat.o(217601);
    }

    private void schedulerNextVSync() {
        AppMethodBeat.i(217602);
        this.mWaitingForNextVSync = true;
        VSyncWaiter.getInstance().asyncWaitForVSync(this);
        AppMethodBeat.o(217602);
    }

    /* access modifiers changed from: package-private */
    public void triggerNextVSync() {
        AppMethodBeat.i(217603);
        if (!this.mWaitingForNextVSync) {
            schedulerNextVSync();
        }
        AppMethodBeat.o(217603);
    }

    @Override // com.tencent.xweb.skia_canvas.VSyncWaiter.VSyncWaiterCallback
    public void doFrame(long j2) {
        AppMethodBeat.i(217604);
        checkAndPost(new Runnable() {
            /* class com.tencent.xweb.skia_canvas.VSyncRenderer.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(217593);
                VSyncRenderer.this.mWaitingForNextVSync = false;
                for (PresentCallback presentCallback : VSyncRenderer.this.mPresentCallbackList) {
                    presentCallback.doPresent();
                }
                long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() - VSyncRenderer.this.mStartFrameTimeNanos;
                ArrayList<AnimationCallback> arrayList = new ArrayList(VSyncRenderer.this.mAnimationCallbackIdMap.values());
                VSyncRenderer.this.mAnimationCallbackIdMap.clear();
                for (AnimationCallback animationCallback : arrayList) {
                    animationCallback.doAnimation(elapsedRealtimeNanos);
                }
                AppMethodBeat.o(217593);
            }
        });
        AppMethodBeat.o(217604);
    }
}
