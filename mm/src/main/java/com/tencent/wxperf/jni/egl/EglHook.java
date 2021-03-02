package com.tencent.wxperf.jni.egl;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import com.tencent.wxperf.jni.a;
import java.util.ArrayList;
import java.util.List;

public class EglHook extends a {
    public static final EglHook Syq = new EglHook();
    private static final List<OnChangeListener> listeners = new ArrayList();

    public interface OnChangeListener {
        @Keep
        void onCreateEglContext(a aVar);

        @Keep
        void onCreateEglWindowSurface(a aVar);

        @Keep
        void onCreatePbufferSurface(a aVar);

        @Keep
        void onDeleteEglContext(long j2);

        @Keep
        void onDeleteEglSurface(long j2);
    }

    private native void startHook();

    static {
        AppMethodBeat.i(199060);
        AppMethodBeat.o(199060);
    }

    private EglHook() {
    }

    @Override // com.tencent.wxperf.jni.a
    public final void hrX() {
    }

    @Override // com.tencent.wxperf.jni.a
    public final void hrY() {
        AppMethodBeat.i(199053);
        startHook();
        AppMethodBeat.o(199053);
    }

    public static void a(OnChangeListener onChangeListener) {
        AppMethodBeat.i(199054);
        synchronized (listeners) {
            try {
                listeners.add(onChangeListener);
            } finally {
                AppMethodBeat.o(199054);
            }
        }
    }

    @Keep
    public static void onCreateEglContext(long j2) {
        AppMethodBeat.i(199055);
        Log.i("Wxperf.EglHook", "onCreateEglContext callback");
        a aVar = new a(j2);
        synchronized (listeners) {
            try {
                if (listeners.size() != 0) {
                    for (OnChangeListener onChangeListener : listeners) {
                        onChangeListener.onCreateEglContext(aVar);
                    }
                    AppMethodBeat.o(199055);
                }
            } finally {
                AppMethodBeat.o(199055);
            }
        }
    }

    @Keep
    public static void onDeleteEglSurface(long j2) {
        AppMethodBeat.i(199056);
        Log.i("Wxperf.EglHook", "onDeleteEglSurface callback");
        synchronized (listeners) {
            try {
                if (listeners.size() != 0) {
                    for (OnChangeListener onChangeListener : listeners) {
                        onChangeListener.onDeleteEglSurface(j2);
                    }
                    AppMethodBeat.o(199056);
                }
            } finally {
                AppMethodBeat.o(199056);
            }
        }
    }

    @Keep
    public static void onDeleteEglContext(long j2) {
        AppMethodBeat.i(199057);
        Log.i("Wxperf.EglHook", "onDeleteEglContext callback");
        synchronized (listeners) {
            try {
                if (listeners.size() != 0) {
                    for (OnChangeListener onChangeListener : listeners) {
                        onChangeListener.onDeleteEglContext(j2);
                    }
                    AppMethodBeat.o(199057);
                }
            } finally {
                AppMethodBeat.o(199057);
            }
        }
    }

    @Keep
    public static void onCreateEglWindowSurface(long j2) {
        AppMethodBeat.i(199058);
        Log.i("Wxperf.EglHook", "onCreateEglWindowSurface callback");
        a aVar = new a(j2);
        synchronized (listeners) {
            try {
                if (listeners.size() != 0) {
                    for (OnChangeListener onChangeListener : listeners) {
                        onChangeListener.onCreateEglWindowSurface(aVar);
                    }
                    AppMethodBeat.o(199058);
                }
            } finally {
                AppMethodBeat.o(199058);
            }
        }
    }

    @Keep
    public static void onCreatePbufferSurface(long j2) {
        AppMethodBeat.i(199059);
        Log.i("Wxperf.EglHook", "onCreatePbufferSurface callback");
        a aVar = new a(j2);
        synchronized (listeners) {
            try {
                if (listeners.size() != 0) {
                    for (OnChangeListener onChangeListener : listeners) {
                        onChangeListener.onCreatePbufferSurface(aVar);
                    }
                    AppMethodBeat.o(199059);
                }
            } finally {
                AppMethodBeat.o(199059);
            }
        }
    }
}
