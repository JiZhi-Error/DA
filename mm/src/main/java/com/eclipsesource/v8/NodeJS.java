package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class NodeJS {
    private static final String GLOBAL = "global";
    private static final String NEXT_TICK = "nextTick";
    private static final String NODE = "node";
    private static final String PROCESS = "process";
    private static final String STARTUP_CALLBACK = "__run";
    private static final String STARTUP_SCRIPT = "global.__run(require, exports, module, __filename, __dirname);";
    private static final String STARTUP_SCRIPT_NAME = "startup";
    private static final String TMP_JS_EXT = ".js.tmp";
    private static final String VERSIONS = "versions";
    private String nodeVersion = null;
    private V8Function require;
    private V8 v8;

    static /* synthetic */ void access$000(NodeJS nodeJS, V8Function v8Function) {
        AppMethodBeat.i(61628);
        nodeJS.init(v8Function);
        AppMethodBeat.o(61628);
    }

    public static NodeJS createNodeJS() {
        AppMethodBeat.i(61617);
        NodeJS createNodeJS = createNodeJS(null);
        AppMethodBeat.o(61617);
        return createNodeJS;
    }

    public String getNodeVersion() {
        V8Object v8Object;
        V8Object v8Object2;
        Throwable th;
        AppMethodBeat.i(61618);
        if (this.nodeVersion != null) {
            String str = this.nodeVersion;
            AppMethodBeat.o(61618);
            return str;
        }
        try {
            v8Object = this.v8.getObject(PROCESS);
            try {
                v8Object2 = v8Object.getObject(VERSIONS);
            } catch (Throwable th2) {
                th = th2;
                v8Object2 = null;
                safeRelease(v8Object);
                safeRelease(v8Object2);
                AppMethodBeat.o(61618);
                throw th;
            }
            try {
                this.nodeVersion = v8Object2.getString(NODE);
                safeRelease(v8Object);
                safeRelease(v8Object2);
                String str2 = this.nodeVersion;
                AppMethodBeat.o(61618);
                return str2;
            } catch (Throwable th3) {
                th = th3;
                safeRelease(v8Object);
                safeRelease(v8Object2);
                AppMethodBeat.o(61618);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            v8Object2 = null;
            v8Object = null;
            safeRelease(v8Object);
            safeRelease(v8Object2);
            AppMethodBeat.o(61618);
            throw th;
        }
    }

    public static NodeJS createNodeJS(File file) {
        AppMethodBeat.i(61619);
        V8 createV8Runtime = V8.createV8Runtime(GLOBAL);
        NodeJS nodeJS = new NodeJS(createV8Runtime);
        createV8Runtime.registerJavaMethod(new JavaVoidCallback(nodeJS) {
            /* class com.eclipsesource.v8.NodeJS.AnonymousClass1 */
            final /* synthetic */ NodeJS val$node;

            {
                this.val$node = r1;
            }

            @Override // com.eclipsesource.v8.JavaVoidCallback
            public final void invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.i(61615);
                V8Function v8Function = (V8Function) v8Array.get(0);
                try {
                    NodeJS.access$000(this.val$node, v8Function.twin());
                } finally {
                    v8Function.release();
                    AppMethodBeat.o(61615);
                }
            }
        }, STARTUP_CALLBACK);
        try {
            File createTemporaryScriptFile = createTemporaryScriptFile(STARTUP_SCRIPT, STARTUP_SCRIPT_NAME);
            try {
                createV8Runtime.createNodeRuntime(createTemporaryScriptFile.getAbsolutePath());
                createTemporaryScriptFile.delete();
                if (file != null) {
                    nodeJS.exec(file);
                }
                AppMethodBeat.o(61619);
                return nodeJS;
            } catch (Throwable th) {
                createTemporaryScriptFile.delete();
                AppMethodBeat.o(61619);
                throw th;
            }
        } catch (IOException e2) {
            RuntimeException runtimeException = new RuntimeException(e2);
            AppMethodBeat.o(61619);
            throw runtimeException;
        }
    }

    public V8 getRuntime() {
        return this.v8;
    }

    public boolean handleMessage() {
        AppMethodBeat.i(61620);
        this.v8.checkThread();
        boolean pumpMessageLoop = this.v8.pumpMessageLoop();
        AppMethodBeat.o(61620);
        return pumpMessageLoop;
    }

    public void release() {
        AppMethodBeat.i(61621);
        this.v8.checkThread();
        if (!this.require.isReleased()) {
            this.require.release();
        }
        if (!this.v8.isReleased()) {
            this.v8.release();
        }
        AppMethodBeat.o(61621);
    }

    public boolean isRunning() {
        AppMethodBeat.i(61622);
        this.v8.checkThread();
        boolean isRunning = this.v8.isRunning();
        AppMethodBeat.o(61622);
        return isRunning;
    }

    public V8Object require(File file) {
        AppMethodBeat.i(61623);
        this.v8.checkThread();
        V8Array v8Array = new V8Array(this.v8);
        try {
            v8Array.push(file.getAbsolutePath());
            return (V8Object) this.require.call(null, v8Array);
        } finally {
            v8Array.release();
            AppMethodBeat.o(61623);
        }
    }

    public void exec(File file) {
        V8Object v8Object;
        V8Array v8Array;
        Throwable th;
        AppMethodBeat.i(61624);
        V8Function createScriptExecutionCallback = createScriptExecutionCallback(file);
        try {
            v8Object = this.v8.getObject(PROCESS);
            try {
                v8Array = new V8Array(this.v8);
                try {
                    v8Array.push((V8Value) createScriptExecutionCallback);
                    v8Object.executeObjectFunction(NEXT_TICK, v8Array);
                    safeRelease(v8Object);
                    safeRelease(v8Array);
                    safeRelease(createScriptExecutionCallback);
                    AppMethodBeat.o(61624);
                } catch (Throwable th2) {
                    th = th2;
                    safeRelease(v8Object);
                    safeRelease(v8Array);
                    safeRelease(createScriptExecutionCallback);
                    AppMethodBeat.o(61624);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                v8Array = null;
                safeRelease(v8Object);
                safeRelease(v8Array);
                safeRelease(createScriptExecutionCallback);
                AppMethodBeat.o(61624);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            v8Array = null;
            v8Object = null;
            safeRelease(v8Object);
            safeRelease(v8Array);
            safeRelease(createScriptExecutionCallback);
            AppMethodBeat.o(61624);
            throw th;
        }
    }

    private V8Function createScriptExecutionCallback(final File file) {
        AppMethodBeat.i(61625);
        V8Function v8Function = new V8Function(this.v8, new JavaCallback() {
            /* class com.eclipsesource.v8.NodeJS.AnonymousClass2 */

            @Override // com.eclipsesource.v8.JavaCallback
            public Object invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.i(61616);
                V8Array v8Array2 = new V8Array(NodeJS.this.v8);
                try {
                    v8Array2.push(file.getAbsolutePath());
                    return NodeJS.this.require.call(null, v8Array2);
                } finally {
                    v8Array2.release();
                    AppMethodBeat.o(61616);
                }
            }
        });
        AppMethodBeat.o(61625);
        return v8Function;
    }

    private void safeRelease(Releasable releasable) {
        AppMethodBeat.i(61626);
        if (releasable != null) {
            releasable.release();
        }
        AppMethodBeat.o(61626);
    }

    private NodeJS(V8 v82) {
        this.v8 = v82;
    }

    private void init(V8Function v8Function) {
        this.require = v8Function;
    }

    private static File createTemporaryScriptFile(String str, String str2) {
        AppMethodBeat.i(61627);
        File createTempFile = File.createTempFile(str2, TMP_JS_EXT);
        PrintWriter printWriter = new PrintWriter(createTempFile, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        try {
            printWriter.print(str);
            return createTempFile;
        } finally {
            printWriter.close();
            AppMethodBeat.o(61627);
        }
    }
}
