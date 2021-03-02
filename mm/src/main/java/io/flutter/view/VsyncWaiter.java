package io.flutter.view;

import android.view.Choreographer;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;

public class VsyncWaiter {
    private static VsyncWaiter instance;
    private final FlutterJNI.AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate = new FlutterJNI.AsyncWaitForVsyncDelegate() {
        /* class io.flutter.view.VsyncWaiter.AnonymousClass1 */

        @Override // io.flutter.embedding.engine.FlutterJNI.AsyncWaitForVsyncDelegate
        public final void asyncWaitForVsync(final long j2) {
            AppMethodBeat.i(9798);
            Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() {
                /* class io.flutter.view.VsyncWaiter.AnonymousClass1.AnonymousClass1 */

                public final void doFrame(long j2) {
                    AppMethodBeat.i(9684);
                    FlutterJNI.nativeOnVsync(j2, j2 + ((long) (1.0E9d / ((double) VsyncWaiter.this.windowManager.getDefaultDisplay().getRefreshRate()))), j2);
                    AppMethodBeat.o(9684);
                }
            });
            AppMethodBeat.o(9798);
        }
    };
    private final WindowManager windowManager;

    public static VsyncWaiter getInstance(WindowManager windowManager2) {
        AppMethodBeat.i(9731);
        if (instance == null) {
            instance = new VsyncWaiter(windowManager2);
        }
        VsyncWaiter vsyncWaiter = instance;
        AppMethodBeat.o(9731);
        return vsyncWaiter;
    }

    private VsyncWaiter(WindowManager windowManager2) {
        AppMethodBeat.i(9732);
        this.windowManager = windowManager2;
        AppMethodBeat.o(9732);
    }

    public void init() {
        AppMethodBeat.i(9733);
        FlutterJNI.setAsyncWaitForVsyncDelegate(this.asyncWaitForVsyncDelegate);
        FlutterJNI.setRefreshRateFPS(this.windowManager.getDefaultDisplay().getRefreshRate());
        AppMethodBeat.o(9733);
    }
}
