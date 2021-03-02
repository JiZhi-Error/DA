package com.tencent.mm.openglapihook;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class OpenGLHook {
    private static final String TAG = "OpenGLHook";
    private static OpenGLHook mInstance = new OpenGLHook();
    private a mListener;

    public interface a {
        void a(a aVar);

        void b(a aVar);

        void c(a aVar);

        void d(a aVar);

        void e(a aVar);

        void f(a aVar);

        void g(a aVar);

        void h(a aVar);

        void i(a aVar);
    }

    private static native boolean hookGlDeleteBuffers(int i2);

    private static native boolean hookGlDeleteFramebuffers(int i2);

    private static native boolean hookGlDeleteRenderbuffers(int i2);

    private static native boolean hookGlDeleteTextures(int i2);

    private static native boolean hookGlGenBuffers(int i2);

    private static native boolean hookGlGenFramebuffers(int i2);

    private static native boolean hookGlGenRenderbuffers(int i2);

    private static native boolean hookGlGenTextures(int i2);

    private static native boolean hookGlGetError(int i2);

    public native boolean init();

    static {
        AppMethodBeat.i(187621);
        System.loadLibrary("openglapihook");
        AppMethodBeat.o(187621);
    }

    private OpenGLHook() {
    }

    public static OpenGLHook getInstance() {
        return mInstance;
    }

    public void setListener(a aVar) {
        this.mListener = aVar;
    }

    public boolean hook(String str, int i2) {
        AppMethodBeat.i(187609);
        if (str.equals("glGetError")) {
            boolean hookGlGetError = hookGlGetError(i2);
            AppMethodBeat.o(187609);
            return hookGlGetError;
        } else if (str.equals("glGenTextures")) {
            boolean hookGlGenTextures = hookGlGenTextures(i2);
            AppMethodBeat.o(187609);
            return hookGlGenTextures;
        } else if (str.equals("glDeleteTextures")) {
            boolean hookGlDeleteTextures = hookGlDeleteTextures(i2);
            AppMethodBeat.o(187609);
            return hookGlDeleteTextures;
        } else if (str.equals("glGenBuffers")) {
            boolean hookGlGenBuffers = hookGlGenBuffers(i2);
            AppMethodBeat.o(187609);
            return hookGlGenBuffers;
        } else if (str.equals("glDeleteBuffers")) {
            boolean hookGlDeleteBuffers = hookGlDeleteBuffers(i2);
            AppMethodBeat.o(187609);
            return hookGlDeleteBuffers;
        } else if (str.equals("glGenFramebuffers")) {
            boolean hookGlGenFramebuffers = hookGlGenFramebuffers(i2);
            AppMethodBeat.o(187609);
            return hookGlGenFramebuffers;
        } else if (str.equals("glDeleteFramebuffers")) {
            boolean hookGlDeleteFramebuffers = hookGlDeleteFramebuffers(i2);
            AppMethodBeat.o(187609);
            return hookGlDeleteFramebuffers;
        } else if (str.equals("glGenRenderbuffers")) {
            boolean hookGlGenRenderbuffers = hookGlGenRenderbuffers(i2);
            AppMethodBeat.o(187609);
            return hookGlGenRenderbuffers;
        } else if (str.equals("glDeleteRenderbuffers")) {
            boolean hookGlDeleteRenderbuffers = hookGlDeleteRenderbuffers(i2);
            AppMethodBeat.o(187609);
            return hookGlDeleteRenderbuffers;
        } else {
            AppMethodBeat.o(187609);
            return false;
        }
    }

    public static void onGlGenTextures(int[] iArr) {
        AppMethodBeat.i(187610);
        if (getInstance().mListener != null) {
            getInstance().mListener.b(new a(iArr));
        }
        AppMethodBeat.o(187610);
    }

    public static void onGlDeleteTextures(int[] iArr) {
        AppMethodBeat.i(187611);
        if (getInstance().mListener != null) {
            getInstance().mListener.c(new a(iArr));
        }
        AppMethodBeat.o(187611);
    }

    public static void onGlGenBuffers(int[] iArr) {
        AppMethodBeat.i(187612);
        if (getInstance().mListener != null) {
            getInstance().mListener.d(new a(iArr));
        }
        AppMethodBeat.o(187612);
    }

    public static void onGlDeleteBuffers(int[] iArr) {
        AppMethodBeat.i(187613);
        if (getInstance().mListener != null) {
            getInstance().mListener.e(new a(iArr));
        }
        AppMethodBeat.o(187613);
    }

    public static void onGlGenFramebuffers(int[] iArr) {
        AppMethodBeat.i(187614);
        if (getInstance().mListener != null) {
            getInstance().mListener.f(new a(iArr));
        }
        AppMethodBeat.o(187614);
    }

    public static void onGlDeleteFramebuffers(int[] iArr) {
        AppMethodBeat.i(187615);
        if (getInstance().mListener != null) {
            getInstance().mListener.g(new a(iArr));
        }
        AppMethodBeat.o(187615);
    }

    public static void onGlGenRenderbuffers(int[] iArr) {
        AppMethodBeat.i(187616);
        if (getInstance().mListener != null) {
            getInstance().mListener.h(new a(iArr));
        }
        AppMethodBeat.o(187616);
    }

    public static void onGlDeleteRenderbuffers(int[] iArr) {
        AppMethodBeat.i(187617);
        if (getInstance().mListener != null) {
            getInstance().mListener.i(new a(iArr));
        }
        AppMethodBeat.o(187617);
    }

    public static void onGetError(int i2) {
        AppMethodBeat.i(187618);
        if (getInstance().mListener != null) {
            getInstance().mListener.a(new a(i2));
        }
        AppMethodBeat.o(187618);
    }

    public static String getStack() {
        AppMethodBeat.i(187619);
        String stackTraceToString = stackTraceToString(new Throwable().getStackTrace());
        AppMethodBeat.o(187619);
        return stackTraceToString;
    }

    private static String stackTraceToString(StackTraceElement[] stackTraceElementArr) {
        AppMethodBeat.i(187620);
        if (stackTraceElementArr == null) {
            AppMethodBeat.o(187620);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < stackTraceElementArr.length; i2++) {
            if (i2 != 0) {
                StackTraceElement stackTraceElement = stackTraceElementArr[i2];
                if (!stackTraceElement.getClassName().contains("java.lang.Thread")) {
                    sb.append("\t").append(stackTraceElement).append('\n');
                }
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(187620);
        return sb2;
    }
}
