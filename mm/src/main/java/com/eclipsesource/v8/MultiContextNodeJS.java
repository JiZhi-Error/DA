package com.eclipsesource.v8;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public final class MultiContextNodeJS {
    private static final String GLOBAL = "global";
    private static final String STARTUP_CALLBACK = "__run";
    private static final String STARTUP_SCRIPT = "global.__run(require, exports, module, __filename, __dirname);";
    private static final String STARTUP_SCRIPT_NAME = "startup";
    private static final String TMP_JS_EXT = ".js.tmp";
    private static IGetTmpFileDirectory sTmpFileDirectoryDelegate = new IGetTmpFileDirectory() {
        /* class com.eclipsesource.v8.MultiContextNodeJS.AnonymousClass2 */

        @Override // com.eclipsesource.v8.MultiContextNodeJS.IGetTmpFileDirectory
        public final File getDirectory() {
            return null;
        }
    };
    private final V8Context mainContext;
    private final MultiContextV8 mv8;
    private V8Function require;

    public interface IGetTmpFileDirectory {
        File getDirectory();
    }

    static /* synthetic */ void access$000(MultiContextNodeJS multiContextNodeJS, V8Function v8Function) {
        AppMethodBeat.i(61597);
        multiContextNodeJS.init(v8Function);
        AppMethodBeat.o(61597);
    }

    public static MultiContextNodeJS createMultiContextNodeJS(int i2) {
        AppMethodBeat.i(61587);
        MultiContextNodeJS createMultiContextNodeJS = createMultiContextNodeJS(i2, null, null, false);
        AppMethodBeat.o(61587);
        return createMultiContextNodeJS;
    }

    public static MultiContextNodeJS createMultiContextNodeJS(int i2, String str, byte[] bArr, boolean z) {
        AppMethodBeat.i(194291);
        MultiContextV8 createMultiContextV8 = MultiContextV8.createMultiContextV8(GLOBAL, str, bArr);
        V8Context createContext = createMultiContextV8.createContext(i2);
        MultiContextNodeJS multiContextNodeJS = new MultiContextNodeJS(createMultiContextV8, createContext);
        if (z) {
            createMultiContextV8.getV8().enableNativeTrans();
        }
        createContext.registerJavaMethod(new JavaVoidCallback(multiContextNodeJS) {
            /* class com.eclipsesource.v8.MultiContextNodeJS.AnonymousClass1 */
            final /* synthetic */ MultiContextNodeJS val$node;

            {
                this.val$node = r1;
            }

            @Override // com.eclipsesource.v8.JavaVoidCallback
            public final void invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.i(61586);
                V8Function v8Function = (V8Function) v8Array.get(0);
                try {
                    MultiContextNodeJS.access$000(this.val$node, v8Function.twin());
                } finally {
                    v8Function.release();
                    AppMethodBeat.o(61586);
                }
            }
        }, STARTUP_CALLBACK);
        try {
            File createTemporaryScriptFile = createTemporaryScriptFile(STARTUP_SCRIPT, String.format("%s_%d_%d", STARTUP_SCRIPT_NAME, Integer.valueOf(Process.myPid()), Long.valueOf(Thread.currentThread().getId())));
            try {
                if (!createMultiContextV8.getV8Locker().hasLock()) {
                    createMultiContextV8.getV8Locker().acquire();
                }
                createMultiContextV8.getV8().createNodeRuntime(createTemporaryScriptFile.getAbsolutePath());
                createMultiContextV8.getV8Locker().release();
                createTemporaryScriptFile.delete();
                AppMethodBeat.o(194291);
                return multiContextNodeJS;
            } catch (Throwable th) {
                createTemporaryScriptFile.delete();
                AppMethodBeat.o(194291);
                throw th;
            }
        } catch (IOException e2) {
            RuntimeException runtimeException = new RuntimeException(e2);
            AppMethodBeat.o(194291);
            throw runtimeException;
        }
    }

    public final V8Context getMainContext() {
        return this.mainContext;
    }

    public final MultiContextV8 getRuntime() {
        return this.mv8;
    }

    public final void wakeUpUVLoop() {
        AppMethodBeat.i(61589);
        this.mv8.getV8().wakeUpUVLoop();
        AppMethodBeat.o(61589);
    }

    public final void closeUVLoop() {
        AppMethodBeat.i(61590);
        this.mv8.getV8().closeUVLoop();
        AppMethodBeat.o(61590);
    }

    public final boolean handleMessage() {
        AppMethodBeat.i(61591);
        this.mv8.getV8().checkThread();
        boolean pumpMessageLoop = this.mv8.getV8().pumpMessageLoop();
        AppMethodBeat.o(61591);
        return pumpMessageLoop;
    }

    public final boolean isRunning() {
        AppMethodBeat.i(61592);
        this.mv8.getV8().checkThread();
        boolean isRunning = this.mv8.getV8().isRunning();
        AppMethodBeat.o(61592);
        return isRunning;
    }

    public final void release() {
        AppMethodBeat.i(61593);
        this.mv8.getV8().checkThread();
        if (!this.require.isReleased()) {
            this.require.release();
        }
        if (!this.mainContext.isReleased()) {
            this.mainContext.release();
        }
        this.mv8.release();
        AppMethodBeat.o(61593);
    }

    public final void waitForDebugger(String str) {
        AppMethodBeat.i(61594);
        this.mv8.waitForDebugger(str);
        AppMethodBeat.o(61594);
    }

    public final void debuggerMessageLoop() {
        AppMethodBeat.i(61595);
        this.mv8.debuggerMessageLoop();
        AppMethodBeat.o(61595);
    }

    private MultiContextNodeJS(MultiContextV8 multiContextV8, V8Context v8Context) {
        this.mv8 = multiContextV8;
        this.mainContext = v8Context;
    }

    private void init(V8Function v8Function) {
        this.require = v8Function;
    }

    private static File createTemporaryScriptFile(String str, String str2) {
        File createTempFile;
        AppMethodBeat.i(61596);
        try {
            createTempFile = File.createTempFile(str2, TMP_JS_EXT, sTmpFileDirectoryDelegate.getDirectory());
        } catch (IOException e2) {
            createTempFile = File.createTempFile(str2, TMP_JS_EXT, sTmpFileDirectoryDelegate.getDirectory());
        }
        PrintWriter printWriter = new PrintWriter(createTempFile, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        try {
            printWriter.print(str);
            return createTempFile;
        } finally {
            printWriter.close();
            AppMethodBeat.o(61596);
        }
    }

    static {
        AppMethodBeat.i(61598);
        AppMethodBeat.o(61598);
    }

    public static void setGetTmpFileDirectoryDelegate(IGetTmpFileDirectory iGetTmpFileDirectory) {
        if (iGetTmpFileDirectory != null) {
            sTmpFileDirectoryDelegate = iGetTmpFileDirectory;
        }
    }

    public final void nativeMessageLoop() {
        AppMethodBeat.i(194292);
        this.mv8.getV8().checkThread();
        this.mv8.getV8().nativeMessageLoop();
        AppMethodBeat.o(194292);
    }

    public final void nativeDispatch() {
        AppMethodBeat.i(194293);
        this.mv8.getV8().nativeDispatch();
        AppMethodBeat.o(194293);
    }
}
