package com.eclipsesource.v8.debug;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8Value;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

public class V8DebugServer {
    private static final String DEBUG_BREAK_HANDLER = "__j2v8_debug_handler";
    public static String DEBUG_OBJECT_NAME = "__j2v8_Debug";
    private static final String HEADER_EMBEDDING_HOST = "Embedding-Host: ";
    private static final String HEADER_PROTOCOL_VERSION = "Protocol-Version: ";
    private static final String HEADER_TYPE = "Type: ";
    private static final String HEADER_V8_VERSION = "V8-Version: ";
    private static final String J2V8_VERSION = "4.0.0";
    private static final String MAKE_BREAK_EVENT = "__j2v8_MakeBreakEvent";
    private static final String MAKE_COMPILE_EVENT = "__j2v8_MakeCompileEvent";
    private static final int PROTOCOL_BUFFER_SIZE = 4096;
    private static final Charset PROTOCOL_CHARSET = Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
    private static final byte[] PROTOCOL_CONTENT_LENGTH_BYTES = PROTOCOL_CONTENT_LENGTH_HEADER.getBytes(PROTOCOL_CHARSET);
    private static final String PROTOCOL_CONTENT_LENGTH_HEADER = "Content-Length:";
    private static final String PROTOCOL_EOL = "\r\n";
    private static final byte[] PROTOCOL_EOL_BYTES = "\r\n".getBytes(PROTOCOL_CHARSET);
    private static final String PROTOCOL_VERSION = "1";
    private static final String SET_LISTENER = "setListener";
    private static final String V8_DEBUG_OBJECT = "Debug";
    private static final String V8_VERSION = "4.10.253";
    private Socket client;
    private Object clientLock = new Object();
    private V8Object debugObject;
    private List<String> requests = new LinkedList();
    private V8Object runningStateDcp;
    private V8 runtime;
    private ServerSocket server;
    private V8Object stoppedStateDcp;
    private boolean traceCommunication = false;
    private boolean waitForConnection;

    static /* synthetic */ void access$1000(V8DebugServer v8DebugServer, String str, String str2) {
        AppMethodBeat.i(61568);
        v8DebugServer.sendMessage(str, str2);
        AppMethodBeat.o(61568);
    }

    static /* synthetic */ boolean access$300(V8DebugServer v8DebugServer) {
        AppMethodBeat.i(61565);
        boolean isConnected = v8DebugServer.isConnected();
        AppMethodBeat.o(61565);
        return isConnected;
    }

    static /* synthetic */ void access$400(V8DebugServer v8DebugServer, V8Object v8Object, V8Object v8Object2) {
        AppMethodBeat.i(61566);
        v8DebugServer.enterBreakLoop(v8Object, v8Object2);
        AppMethodBeat.o(61566);
    }

    static /* synthetic */ void access$500(V8DebugServer v8DebugServer, V8Object v8Object) {
        AppMethodBeat.i(61567);
        v8DebugServer.sendCompileEvent(v8Object);
        AppMethodBeat.o(61567);
    }

    static {
        AppMethodBeat.i(61569);
        AppMethodBeat.o(61569);
    }

    public static void configureV8ForDebugging() {
        AppMethodBeat.i(61552);
        try {
            V8.setFlags("-expose-debug-as=" + DEBUG_OBJECT_NAME);
            AppMethodBeat.o(61552);
        } catch (Throwable th) {
            AppMethodBeat.o(61552);
        }
    }

    public V8DebugServer(V8 v8, int i2, boolean z) {
        AppMethodBeat.i(61553);
        this.runtime = v8;
        this.waitForConnection = z;
        V8Object object = v8.getObject(DEBUG_OBJECT_NAME);
        if (object == null) {
            System.err.println("Cannot initialize debugger server - global debug object not found.");
            AppMethodBeat.o(61553);
            return;
        }
        try {
            this.debugObject = object.getObject(V8_DEBUG_OBJECT);
            object.release();
            v8.executeVoidScript("(function() {\n " + DEBUG_OBJECT_NAME + ".Debug. __j2v8_MakeBreakEvent = function (break_id,breakpoints_hit) {\n  return new " + DEBUG_OBJECT_NAME + ".BreakEvent(break_id,breakpoints_hit);\n }\n " + DEBUG_OBJECT_NAME + ".Debug. __j2v8_MakeCompileEvent = function(script,type) {\n  var scripts = " + DEBUG_OBJECT_NAME + ".Debug.scripts()\n  for (var i in scripts) {\n   if (scripts[i].id == script.id()) {\n     return new " + DEBUG_OBJECT_NAME + ".CompileEvent(scripts[i], type);\n   }\n  }\n  return {toJSONProtocol: function() {return ''}}\n }\n})()");
            try {
                this.server = new ServerSocket(i2);
                AppMethodBeat.o(61553);
            } catch (Exception e2) {
                logError(e2);
                AppMethodBeat.o(61553);
            }
        } catch (Throwable th) {
            object.release();
            AppMethodBeat.o(61553);
            throw th;
        }
    }

    public int getPort() {
        AppMethodBeat.i(61554);
        if (this.server == null || !this.server.isBound()) {
            AppMethodBeat.o(61554);
            return -1;
        }
        int localPort = this.server.getLocalPort();
        AppMethodBeat.o(61554);
        return localPort;
    }

    public void setTraceCommunication(boolean z) {
        this.traceCommunication = z;
    }

    public void start() {
        AppMethodBeat.i(61555);
        if (this.server == null) {
            AppMethodBeat.o(61555);
            return;
        }
        boolean z = this.waitForConnection;
        Thread thread = new Thread(new ClientLoop(), "J2V8 Debugger Server");
        thread.setDaemon(true);
        thread.start();
        setupEventHandler();
        this.runningStateDcp = this.runtime.executeObjectScript("(function() {return new " + DEBUG_OBJECT_NAME + ".DebugCommandProcessor(null, true)})()");
        if (z) {
            synchronized (this.clientLock) {
                while (this.waitForConnection) {
                    try {
                        try {
                            this.clientLock.wait();
                        } catch (InterruptedException e2) {
                        }
                    } finally {
                        AppMethodBeat.o(61555);
                    }
                }
            }
            try {
                processRequests(100);
                AppMethodBeat.o(61555);
            } catch (InterruptedException e3) {
            }
        }
    }

    public void stop() {
        AppMethodBeat.i(61556);
        try {
            this.server.close();
            synchronized (this.clientLock) {
                try {
                    if (this.client != null) {
                        this.client.close();
                        this.client = null;
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(61556);
                    throw th;
                }
            }
        } catch (IOException e2) {
            logError(e2);
        }
        if (this.runningStateDcp != null) {
            this.runningStateDcp.release();
            this.runningStateDcp = null;
        }
        if (this.debugObject != null) {
            this.debugObject.release();
            this.debugObject = null;
        }
        if (this.stoppedStateDcp != null) {
            this.stoppedStateDcp.release();
            this.stoppedStateDcp = null;
        }
        AppMethodBeat.o(61556);
    }

    private void sendJson(String str) {
        AppMethodBeat.i(61557);
        sendMessage("", str.replace("\\/", FilePathGenerator.ANDROID_DIR_SEP));
        AppMethodBeat.o(61557);
    }

    /* access modifiers changed from: protected */
    public void logError(Throwable th) {
    }

    private void sendMessage(String str, String str2) {
        AppMethodBeat.i(61558);
        synchronized (this.clientLock) {
            try {
                if (!isConnected()) {
                    IOException iOException = new IOException("There is no connected client.");
                    AppMethodBeat.o(61558);
                    throw iOException;
                }
                byte[] bytes = str2.getBytes(PROTOCOL_CHARSET);
                this.client.getOutputStream().write((str + PROTOCOL_CONTENT_LENGTH_HEADER + Integer.toString(bytes.length) + "\r\n" + "\r\n").getBytes(PROTOCOL_CHARSET));
                if (bytes.length > 0) {
                    this.client.getOutputStream().write(bytes);
                }
            } finally {
                AppMethodBeat.o(61558);
            }
        }
    }

    private boolean isConnected() {
        boolean z;
        AppMethodBeat.i(61559);
        synchronized (this.clientLock) {
            try {
                z = (this.server == null || this.client == null || !this.client.isConnected()) ? false : true;
            } finally {
                AppMethodBeat.o(61559);
            }
        }
        return z;
    }

    public void processRequests(long j2) {
        String[] strArr;
        AppMethodBeat.i(61560);
        if (this.server == null) {
            AppMethodBeat.o(61560);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        while (true) {
            synchronized (this.requests) {
                try {
                    strArr = (String[]) this.requests.toArray(new String[this.requests.size()]);
                    this.requests.clear();
                } finally {
                    AppMethodBeat.o(61560);
                }
            }
            for (String str : strArr) {
                try {
                    processRequest(str);
                } catch (Exception e2) {
                    logError(e2);
                }
            }
            if (strArr.length <= 0) {
                if (j2 > 0) {
                    Thread.sleep(10);
                }
                if (j2 <= 0 || currentTimeMillis + j2 <= System.currentTimeMillis()) {
                }
            }
        }
    }

    private void processRequest(String str) {
        AppMethodBeat.i(61561);
        if (this.traceCommunication) {
            System.out.println("Got message: \n" + str.substring(0, Math.min(str.length(), 1000)));
        }
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(str);
        V8Object v8Object = this.stoppedStateDcp != null ? this.stoppedStateDcp : this.runningStateDcp;
        String obj = v8Object.executeFunction("processDebugJSONRequest", v8Array).toString();
        if (this.stoppedStateDcp == null && obj.contains("\"running\":false")) {
            obj = obj.replace("\"running\":false", "\"running\":true").replace("\"success\":true", "\"success\":false").replace("{\"", "{\"message\":\"Client requested suspension is not supported on J2V8.\",\"");
            v8Object.add("running_", true);
        }
        if (this.traceCommunication) {
            System.out.println("Returning response: \n" + obj.substring(0, Math.min(obj.length(), 1000)));
        }
        sendJson(obj);
        AppMethodBeat.o(61561);
    }

    private void setupEventHandler() {
        V8Function v8Function;
        V8Array v8Array;
        Throwable th;
        AppMethodBeat.i(61562);
        this.debugObject.registerJavaMethod(new EventHandler(), DEBUG_BREAK_HANDLER);
        try {
            V8Function v8Function2 = (V8Function) this.debugObject.getObject(DEBUG_BREAK_HANDLER);
            try {
                v8Array = new V8Array(this.runtime).push((V8Value) v8Function2);
            } catch (Throwable th2) {
                th = th2;
                v8Array = null;
                v8Function = v8Function2;
                v8Function.release();
                v8Array.release();
                AppMethodBeat.o(61562);
                throw th;
            }
            try {
                this.debugObject.executeFunction(SET_LISTENER, v8Array);
                if (v8Function2 != null && !v8Function2.isReleased()) {
                    v8Function2.release();
                }
                if (v8Array == null || v8Array.isReleased()) {
                    AppMethodBeat.o(61562);
                    return;
                }
                v8Array.release();
                AppMethodBeat.o(61562);
            } catch (Throwable th3) {
                th = th3;
                v8Function = v8Function2;
                if (v8Function != null && !v8Function.isReleased()) {
                    v8Function.release();
                }
                if (v8Array != null && !v8Array.isReleased()) {
                    v8Array.release();
                }
                AppMethodBeat.o(61562);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            v8Array = null;
            v8Function = null;
            v8Function.release();
            v8Array.release();
            AppMethodBeat.o(61562);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void enterBreakLoop(com.eclipsesource.v8.V8Object r10, com.eclipsesource.v8.V8Object r11) {
        /*
        // Method dump skipped, instructions count: 190
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eclipsesource.v8.debug.V8DebugServer.enterBreakLoop(com.eclipsesource.v8.V8Object, com.eclipsesource.v8.V8Object):void");
    }

    private void sendCompileEvent(V8Object v8Object) {
        V8Object v8Object2 = null;
        AppMethodBeat.i(61564);
        if (!isConnected()) {
            AppMethodBeat.o(61564);
            return;
        }
        int integer = v8Object.getInteger("type_");
        V8Object object = v8Object.getObject("script_");
        V8Array v8Array = new V8Array(this.runtime);
        try {
            v8Array.push((V8Value) object);
            v8Array.push(integer);
            V8Object executeObjectFunction = this.debugObject.executeObjectFunction(MAKE_COMPILE_EVENT, v8Array);
            String executeStringFunction = executeObjectFunction.executeStringFunction("toJSONProtocol", null);
            if (this.traceCommunication) {
                System.out.println("Sending event (CompileEvent):\n" + executeStringFunction.substring(0, Math.min(executeStringFunction.length(), 1000)));
            }
            if (executeStringFunction.length() > 0) {
                sendJson(executeStringFunction);
            }
            v8Array.release();
            object.release();
            if (executeObjectFunction != null) {
                executeObjectFunction.release();
                AppMethodBeat.o(61564);
                return;
            }
            AppMethodBeat.o(61564);
        } catch (Throwable th) {
            v8Array.release();
            object.release();
            if (0 != 0) {
                v8Object2.release();
            }
            AppMethodBeat.o(61564);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public class EventHandler implements JavaVoidCallback {
        private EventHandler() {
        }

        @Override // com.eclipsesource.v8.JavaVoidCallback
        public void invoke(V8Object v8Object, V8Array v8Array) {
            V8Object v8Object2;
            V8Object v8Object3;
            AppMethodBeat.i(61550);
            if (v8Array == null || v8Array.isUndefined()) {
                AppMethodBeat.o(61550);
                return;
            }
            try {
                int integer = v8Array.getInteger(0);
                v8Object3 = v8Array.getObject(1);
                try {
                    v8Object2 = v8Array.getObject(2);
                } catch (Exception e2) {
                    e = e2;
                    v8Object2 = null;
                    try {
                        V8DebugServer.this.logError(e);
                        safeRelease(v8Object3);
                        safeRelease(v8Object2);
                        AppMethodBeat.o(61550);
                    } catch (Throwable th) {
                        th = th;
                        safeRelease(v8Object3);
                        safeRelease(v8Object2);
                        AppMethodBeat.o(61550);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    v8Object2 = null;
                    safeRelease(v8Object3);
                    safeRelease(v8Object2);
                    AppMethodBeat.o(61550);
                    throw th;
                }
                try {
                    if (V8DebugServer.this.traceCommunication) {
                        String str = "unknown";
                        switch (integer) {
                            case 1:
                                str = "Break";
                                break;
                            case 2:
                                str = "Exception";
                                break;
                            case 3:
                                str = "NewFunction";
                                break;
                            case 4:
                                str = "BeforeCompile";
                                break;
                            case 5:
                                str = "AfterCompile";
                                break;
                            case 6:
                                str = "CompileError";
                                break;
                            case 7:
                                str = "PromiseEvent";
                                break;
                            case 8:
                                str = "AsyncTaskEvent";
                                break;
                        }
                        System.out.println("V8 has emmitted an event of type ".concat(String.valueOf(str)));
                    }
                    if (!V8DebugServer.access$300(V8DebugServer.this)) {
                        safeRelease(v8Object3);
                        safeRelease(v8Object2);
                        AppMethodBeat.o(61550);
                        return;
                    }
                    switch (integer) {
                        case 1:
                            V8DebugServer.access$400(V8DebugServer.this, v8Object3, v8Object2);
                            break;
                        case 5:
                        case 6:
                            V8DebugServer.access$500(V8DebugServer.this, v8Object2);
                            break;
                    }
                    safeRelease(v8Object3);
                    safeRelease(v8Object2);
                    AppMethodBeat.o(61550);
                } catch (Exception e3) {
                    e = e3;
                    V8DebugServer.this.logError(e);
                    safeRelease(v8Object3);
                    safeRelease(v8Object2);
                    AppMethodBeat.o(61550);
                }
            } catch (Exception e4) {
                e = e4;
                v8Object2 = null;
                v8Object3 = null;
                V8DebugServer.this.logError(e);
                safeRelease(v8Object3);
                safeRelease(v8Object2);
                AppMethodBeat.o(61550);
            } catch (Throwable th3) {
                th = th3;
                v8Object2 = null;
                v8Object3 = null;
                safeRelease(v8Object3);
                safeRelease(v8Object2);
                AppMethodBeat.o(61550);
                throw th;
            }
        }

        private void safeRelease(Releasable releasable) {
            AppMethodBeat.i(61551);
            if (releasable != null) {
                releasable.release();
            }
            AppMethodBeat.o(61551);
        }
    }

    class ClientLoop implements Runnable {
        private int from;

        private ClientLoop() {
        }

        public void run() {
            AppMethodBeat.i(61544);
            while (true) {
                try {
                    Socket accept = V8DebugServer.this.server.accept();
                    accept.setTcpNoDelay(true);
                    synchronized (V8DebugServer.this.clientLock) {
                        try {
                            V8DebugServer.this.client = accept;
                            V8DebugServer.this.waitForConnection = false;
                            V8DebugServer.this.clientLock.notifyAll();
                        } catch (Throwable th) {
                            AppMethodBeat.o(61544);
                            throw th;
                        }
                    }
                    startHandshake();
                    processClientRequests();
                } catch (Exception e2) {
                    synchronized (V8DebugServer.this.clientLock) {
                        if (V8DebugServer.this.client != null) {
                            try {
                                V8DebugServer.this.client.close();
                            } catch (IOException e3) {
                            }
                            V8DebugServer.this.client = null;
                        }
                        V8DebugServer.this.logError(e2);
                    }
                } catch (Throwable th2) {
                    AppMethodBeat.o(61544);
                    throw th2;
                }
            }
        }

        private void startHandshake() {
            AppMethodBeat.i(61545);
            V8DebugServer.access$1000(V8DebugServer.this, V8DebugServer.HEADER_V8_VERSION + V8DebugServer.V8_VERSION + "\r\n" + V8DebugServer.HEADER_PROTOCOL_VERSION + "1" + "\r\n" + V8DebugServer.HEADER_EMBEDDING_HOST + "j2v8 " + V8DebugServer.J2V8_VERSION + "\r\n" + V8DebugServer.HEADER_TYPE + "connect" + "\r\n", "");
            AppMethodBeat.o(61545);
        }

        private void processClientRequests() {
            InputStream inputStream;
            AppMethodBeat.i(61546);
            byte[] bArr = new byte[0];
            byte[] bArr2 = new byte[4096];
            synchronized (V8DebugServer.this.clientLock) {
                try {
                    inputStream = V8DebugServer.this.client.getInputStream();
                } finally {
                    AppMethodBeat.o(61546);
                }
            }
            int i2 = -1;
            byte[] bArr3 = bArr;
            boolean z = false;
            int i3 = 0;
            while (true) {
                int read = inputStream.read(bArr2, i3, 4096 - i3);
                if (read > 0) {
                    int i4 = i3 + read;
                    this.from = 0;
                    do {
                        if (i2 < 0) {
                            i2 = readContentLength(bArr2, i4);
                            if (i2 < 0) {
                                break;
                            }
                        }
                        if (!z && !(z = skipToolInfo(bArr2, i4))) {
                            break;
                        }
                        int min = Math.min(i2 - bArr3.length, i4 - this.from);
                        bArr3 = join(bArr3, bArr2, this.from, min);
                        this.from = min + this.from;
                        if (bArr3.length == i2) {
                            String str = new String(bArr3, V8DebugServer.PROTOCOL_CHARSET);
                            synchronized (V8DebugServer.this.requests) {
                                try {
                                    V8DebugServer.this.requests.add(str);
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            i2 = -1;
                            bArr3 = bArr;
                            z = false;
                        }
                    } while (this.from < i4);
                    if (this.from < i4) {
                        System.arraycopy(bArr2, this.from, bArr2, 0, i4 - this.from);
                        i3 = i4 - this.from;
                    } else {
                        i3 = 0;
                    }
                } else {
                    AppMethodBeat.o(61546);
                    return;
                }
            }
        }

        private int readContentLength(byte[] bArr, int i2) {
            int i3 = -1;
            AppMethodBeat.i(61547);
            int indexOf = indexOf(V8DebugServer.PROTOCOL_CONTENT_LENGTH_BYTES, bArr, this.from, i2);
            if (indexOf < 0) {
                AppMethodBeat.o(61547);
            } else {
                int length = indexOf + V8DebugServer.PROTOCOL_CONTENT_LENGTH_BYTES.length;
                int indexOf2 = indexOf(V8DebugServer.PROTOCOL_EOL_BYTES, bArr, length, i2);
                if (indexOf2 < 0) {
                    AppMethodBeat.o(61547);
                } else {
                    String str = new String(bArr, length, indexOf2 - length, V8DebugServer.PROTOCOL_CHARSET);
                    try {
                        i3 = Integer.parseInt(str.trim());
                        this.from = V8DebugServer.PROTOCOL_EOL_BYTES.length + indexOf2;
                        AppMethodBeat.o(61547);
                    } catch (Exception e2) {
                        IOException iOException = new IOException("Invalid content length header: '" + str + "' in message" + new String(bArr, V8DebugServer.PROTOCOL_CHARSET));
                        AppMethodBeat.o(61547);
                        throw iOException;
                    }
                }
            }
            return i3;
        }

        private boolean skipToolInfo(byte[] bArr, int i2) {
            AppMethodBeat.i(61548);
            int indexOf = indexOf(V8DebugServer.PROTOCOL_EOL_BYTES, bArr, this.from, i2);
            if (indexOf < 0) {
                AppMethodBeat.o(61548);
                return false;
            }
            this.from = indexOf + V8DebugServer.PROTOCOL_EOL_BYTES.length;
            AppMethodBeat.o(61548);
            return true;
        }

        private int indexOf(byte[] bArr, byte[] bArr2, int i2, int i3) {
            int length = bArr.length;
            for (int i4 = i2; i4 < i3; i4++) {
                for (int i5 = 0; i5 <= length; i5++) {
                    if (i5 == length) {
                        return i4;
                    }
                    if (i4 + i5 >= i3 || bArr2[i4 + i5] != bArr[i5]) {
                        break;
                    }
                }
            }
            return -1;
        }

        private byte[] join(byte[] bArr, byte[] bArr2, int i2, int i3) {
            AppMethodBeat.i(61549);
            byte[] bArr3 = new byte[(bArr.length + i3)];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, i2, bArr3, bArr.length, i3);
            AppMethodBeat.o(61549);
            return bArr3;
        }
    }
}
