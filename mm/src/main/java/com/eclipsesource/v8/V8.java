package com.eclipsesource.v8;

import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.utils.V8Executor;
import com.eclipsesource.v8.utils.V8Map;
import com.eclipsesource.v8.utils.V8Runnable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class V8 extends V8Object {
    public static final int MEMORY_PRESSURE_LEVEL_CRITICAL = 2;
    public static final int MEMORY_PRESSURE_LEVEL_MODERATE = 1;
    public static final int MEMORY_PRESSURE_LEVEL_NONE = 0;
    private static boolean initialized = false;
    private static Object invalid = new Object();
    private static Object lock = new Object();
    private static boolean nativeLibraryLoaded = false;
    private static Error nativeLoadError = null;
    private static Exception nativeLoadException = null;
    private static volatile int runtimeCounter = 0;
    private static ILoadLibraryDelegate sLoadLibraryDelegate = new ILoadLibraryDelegate() {
        /* class com.eclipsesource.v8.V8.AnonymousClass1 */

        @Override // com.eclipsesource.v8.ILoadLibraryDelegate
        public final void loadLibrary(String str) {
            AppMethodBeat.i(61784);
            LibraryLoader.loadLibrary(str);
            AppMethodBeat.o(61784);
        }
    };
    private static V8Value undefined = new V8Object.Undefined();
    private static String v8Flags = "";
    JavaTaskScheduler _javaTaskScheduler;
    private Map<String, Object> data;
    private V8Map<V8Executor> executors;
    private boolean forceTerminateExecutors;
    private Map<Long, MethodDescriptor> functionRegistry;
    private final V8Locker locker;
    Runnable nativeJavaCallback_;
    private long objectReferences;
    private LinkedList<ReferenceHandler> referenceHandlers;
    private LinkedList<V8Runnable> releaseHandlers;
    private List<Releasable> resources;
    private long v8RuntimePtr;
    protected Map<Long, V8Value> v8WeakReferences;

    public interface JavaTaskScheduler {
        void Schedule(Runnable runnable);
    }

    private native void _acquireLock(long j2);

    private native void _add(long j2, long j3, String str, double d2);

    private native void _add(long j2, long j3, String str, int i2);

    private native void _add(long j2, long j3, String str, String str2);

    private native void _add(long j2, long j3, String str, boolean z);

    private native void _addArrayBooleanItem(long j2, long j3, boolean z);

    private native void _addArrayDoubleItem(long j2, long j3, double d2);

    private native void _addArrayIntItem(long j2, long j3, int i2);

    private native void _addArrayNullItem(long j2, long j3);

    private native void _addArrayObjectItem(long j2, long j3, long j4);

    private native void _addArrayStringItem(long j2, long j3, String str);

    private native void _addArrayUndefinedItem(long j2, long j3);

    private native void _addNull(long j2, long j3, String str);

    private native void _addObject(long j2, long j3, String str, long j4);

    private native void _addUndefined(long j2, long j3, String str);

    private native Object _arrayGet(long j2, int i2, long j3, int i3);

    private native boolean _arrayGetBoolean(long j2, long j3, int i2);

    private native int _arrayGetBooleans(long j2, long j3, int i2, int i3, boolean[] zArr);

    private native boolean[] _arrayGetBooleans(long j2, long j3, int i2, int i3);

    private native byte _arrayGetByte(long j2, long j3, int i2);

    private native int _arrayGetBytes(long j2, long j3, int i2, int i3, byte[] bArr);

    private native byte[] _arrayGetBytes(long j2, long j3, int i2, int i3);

    private native double _arrayGetDouble(long j2, long j3, int i2);

    private native int _arrayGetDoubles(long j2, long j3, int i2, int i3, double[] dArr);

    private native double[] _arrayGetDoubles(long j2, long j3, int i2, int i3);

    private native int _arrayGetInteger(long j2, long j3, int i2);

    private native int _arrayGetIntegers(long j2, long j3, int i2, int i3, int[] iArr);

    private native int[] _arrayGetIntegers(long j2, long j3, int i2, int i3);

    private native int _arrayGetSize(long j2, long j3);

    private native String _arrayGetString(long j2, long j3, int i2);

    private native int _arrayGetStrings(long j2, long j3, int i2, int i3, String[] strArr);

    private native String[] _arrayGetStrings(long j2, long j3, int i2, int i3);

    private native void _closeUVLoop(long j2);

    private native boolean _contains(long j2, long j3, String str);

    private native long _createContext(long j2, int i2);

    private native long _createIsolate(String str, boolean z);

    private native void _createTwin(long j2, long j3, long j4);

    private native ByteBuffer _createV8ArrayBufferBackingStore(long j2, long j3, int i2);

    private static native void _debugMessageLoop(long j2);

    private static native void _enableNativeTrans(long j2);

    private native boolean _equals(long j2, long j3, long j4);

    private native boolean _executeBooleanFunction(long j2, long j3, String str, long j4);

    private native boolean _executeBooleanScript(long j2, String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails);

    private static native String _executeDebugScript(long j2, String str, String str2);

    private native double _executeDoubleFunction(long j2, long j3, String str, long j4);

    private native double _executeDoubleScript(long j2, String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails);

    private native Object _executeFunction(long j2, int i2, long j3, String str, long j4);

    private native Object _executeFunction(long j2, long j3, long j4, long j5);

    private native int _executeIntegerFunction(long j2, long j3, String str, long j4);

    private native int _executeIntegerScript(long j2, String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails);

    private native Object _executeScript(long j2, int i2, String str, String str2, int i3, String str3, String str4, int i4, ExecuteDetails executeDetails);

    private native String _executeStringFunction(long j2, long j3, String str, long j4);

    private native String _executeStringScript(long j2, String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails);

    private native void _executeVoidFunction(long j2, long j3, String str, long j4);

    private native void _executeVoidScript(long j2, String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails);

    private native Object _executeWxaScript(long j2, ArrayList<ScriptPartObject> arrayList, int i2, String str, int i3, String str2, String str3, int i4, ExecuteDetails executeDetails);

    private native Object _get(long j2, int i2, long j3, String str);

    private native int _getArrayType(long j2, long j3);

    private native boolean _getBoolean(long j2, long j3, String str);

    private native long _getBuildID();

    private native double _getDouble(long j2, long j3, String str);

    private native long _getGlobalObject(long j2);

    private native int _getInteger(long j2, long j3, String str);

    private native long _getIsolatePtr(long j2);

    private native String[] _getKeys(long j2, long j3);

    private static native long _getNativeTransManager();

    private native String _getString(long j2, long j3, String str);

    private native int _getType(long j2, long j3);

    private native int _getType(long j2, long j3, int i2);

    private native int _getType(long j2, long j3, int i2, int i3);

    private native int _getType(long j2, long j3, String str);

    private native long _getUVLoopPtr(long j2);

    private static native String _getVersion();

    private native int _identityHash(long j2, long j3);

    private native long _initNewSharedV8ArrayBuffer(long j2, ByteBuffer byteBuffer, int i2);

    private native long _initNewV8Array(long j2);

    private native long _initNewV8ArrayBuffer(long j2, int i2);

    private native long _initNewV8ArrayBuffer(long j2, ByteBuffer byteBuffer, int i2);

    private native long _initNewV8Float32Array(long j2, long j3, int i2, int i3);

    private native long _initNewV8Float64Array(long j2, long j3, int i2, int i3);

    private native long[] _initNewV8Function(long j2);

    private native long _initNewV8Int16Array(long j2, long j3, int i2, int i3);

    private native long _initNewV8Int32Array(long j2, long j3, int i2, int i3);

    private native long _initNewV8Int8Array(long j2, long j3, int i2, int i3);

    private native long _initNewV8Object(long j2);

    private native long _initNewV8UInt16Array(long j2, long j3, int i2, int i3);

    private native long _initNewV8UInt32Array(long j2, long j3, int i2, int i3);

    private native long _initNewV8UInt8Array(long j2, long j3, int i2, int i3);

    private native long _initNewV8UInt8ClampedArray(long j2, long j3, int i2, int i3);

    private static native boolean _isRunning(long j2);

    private native boolean _isWeak(long j2, long j3);

    private native void _lowMemoryNotification(long j2);

    private native void _memoryPressureNotification(long j2, int i2);

    private static native void _nativeDispatch(long j2);

    private static native void _nativeLoopStop(long j2);

    private static native void _nativeMessageLoop(long j2);

    private static native void _nativeTransBroadcastMessage(int i2, String str);

    private static native void _nativeTransHandleMessage(long j2);

    private static native void _nativeTransPostMessage(int i2, String str);

    private static native void _nativeTransSetJavaSchedule(long j2);

    private static native boolean _pumpMessageLoop(long j2);

    private static native void _pumpMessageLoopDirect(long j2);

    private native long _registerJavaMethod(long j2, long j3, String str, boolean z);

    private native void _release(long j2, long j3);

    private native void _releaseContext(long j2, long j3);

    private native void _releaseLock(long j2);

    private native void _releaseMethodDescriptor(long j2, long j3);

    private native void _releaseRuntime(long j2);

    private native boolean _sameValue(long j2, long j3, long j4);

    private static native void _setCodeCacheDir(String str);

    private static native void _setFlags(String str);

    private native void _setPrototype(long j2, long j3, long j4);

    private static native void _setSnapshotBlob(byte[] bArr);

    private native void _setWeak(long j2, long j3);

    private static native void _startNodeJS(long j2, String str);

    private native boolean _strictEquals(long j2, long j3, long j4);

    private native void _switchContext(long j2, long j3);

    private native void _terminateExecution(long j2);

    private native String _toString(long j2, long j3);

    private static native void _waitForDebuger(long j2, String str);

    private native void _wakeUpUVLoop(long j2);

    static /* synthetic */ void access$200(long j2) {
        AppMethodBeat.i(194306);
        _nativeTransHandleMessage(j2);
        AppMethodBeat.o(194306);
    }

    static {
        AppMethodBeat.i(61968);
        AppMethodBeat.o(61968);
    }

    /* access modifiers changed from: package-private */
    public class MethodDescriptor {
        JavaCallback callback;
        boolean includeReceiver;
        Method method;
        Object object;
        JavaVoidCallback voidCallback;

        private MethodDescriptor() {
        }
    }

    private static synchronized void load(String str) {
        synchronized (V8.class) {
            AppMethodBeat.i(61785);
            try {
                sLoadLibraryDelegate.loadLibrary(str);
                nativeLibraryLoaded = true;
                AppMethodBeat.o(61785);
            } catch (Error e2) {
                nativeLoadError = e2;
                AppMethodBeat.o(61785);
            } catch (Exception e3) {
                nativeLoadException = e3;
                AppMethodBeat.o(61785);
            }
        }
    }

    public static boolean isLoaded() {
        return nativeLibraryLoaded;
    }

    public static void setFlags(String str) {
        v8Flags = str;
    }

    public static String getFlags() {
        return v8Flags;
    }

    public static V8 createV8Runtime() {
        AppMethodBeat.i(61786);
        V8 createV8Runtime = createV8Runtime(null, null);
        AppMethodBeat.o(61786);
        return createV8Runtime;
    }

    public static V8 createV8Runtime(String str) {
        AppMethodBeat.i(61787);
        V8 createV8Runtime = createV8Runtime(str, null);
        AppMethodBeat.o(61787);
        return createV8Runtime;
    }

    public static V8 createV8Runtime(String str, String str2) {
        AppMethodBeat.i(61788);
        V8 createV8Runtime = createV8Runtime(str, str2, true, null, null);
        AppMethodBeat.o(61788);
        return createV8Runtime;
    }

    protected static V8 createV8Runtime(String str, String str2, boolean z) {
        AppMethodBeat.i(61789);
        V8 createV8Runtime = createV8Runtime(str, str2, z, null, null);
        AppMethodBeat.o(61789);
        return createV8Runtime;
    }

    protected static V8 createV8Runtime(String str, String str2, boolean z, String str3, byte[] bArr) {
        AppMethodBeat.i(61790);
        if (!nativeLibraryLoaded) {
            synchronized (lock) {
                try {
                    if (!nativeLibraryLoaded) {
                        load(str2);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(61790);
                    throw th;
                }
            }
        }
        checkNativeLibraryLoaded();
        if (!initialized) {
            synchronized (lock) {
                if (str3 != null) {
                    try {
                        _setCodeCacheDir(str3);
                    } catch (Throwable th2) {
                        AppMethodBeat.o(61790);
                        throw th2;
                    }
                }
                if (bArr != null) {
                    _setSnapshotBlob(bArr);
                }
            }
            initialized = true;
        }
        V8 v8 = new V8(str, z);
        synchronized (lock) {
            try {
                runtimeCounter++;
            } finally {
                AppMethodBeat.o(61790);
            }
        }
        return v8;
    }

    /* access modifiers changed from: protected */
    public long createV8Context(int i2) {
        AppMethodBeat.i(61791);
        long _createContext = _createContext(this.v8RuntimePtr, i2);
        AppMethodBeat.o(61791);
        return _createContext;
    }

    /* access modifiers changed from: protected */
    public void switchV8Context(long j2) {
        AppMethodBeat.i(61792);
        _switchContext(this.v8RuntimePtr, j2);
        AppMethodBeat.o(61792);
    }

    /* access modifiers changed from: protected */
    public void wakeUpUVLoop() {
        AppMethodBeat.i(61793);
        _wakeUpUVLoop(this.v8RuntimePtr);
        AppMethodBeat.o(61793);
    }

    /* access modifiers changed from: protected */
    public void closeUVLoop() {
        AppMethodBeat.i(61794);
        _closeUVLoop(this.v8RuntimePtr);
        AppMethodBeat.o(61794);
    }

    /* access modifiers changed from: protected */
    public void releaseV8Context(long j2) {
        AppMethodBeat.i(61795);
        _releaseContext(this.v8RuntimePtr, j2);
        AppMethodBeat.o(61795);
    }

    public void addReferenceHandler(ReferenceHandler referenceHandler) {
        AppMethodBeat.i(61796);
        this.referenceHandlers.add(0, referenceHandler);
        AppMethodBeat.o(61796);
    }

    public void addReleaseHandler(V8Runnable v8Runnable) {
        AppMethodBeat.i(61797);
        this.releaseHandlers.add(v8Runnable);
        AppMethodBeat.o(61797);
    }

    public void removeReferenceHandler(ReferenceHandler referenceHandler) {
        AppMethodBeat.i(61798);
        this.referenceHandlers.remove(referenceHandler);
        AppMethodBeat.o(61798);
    }

    public void removeReleaseHandler(V8Runnable v8Runnable) {
        AppMethodBeat.i(61799);
        this.releaseHandlers.remove(v8Runnable);
        AppMethodBeat.o(61799);
    }

    public synchronized void setData(String str, Object obj) {
        AppMethodBeat.i(61800);
        if (this.data == null) {
            this.data = new HashMap();
        }
        this.data.put(str, obj);
        AppMethodBeat.o(61800);
    }

    public Object getData(String str) {
        AppMethodBeat.i(61801);
        if (this.data == null) {
            AppMethodBeat.o(61801);
            return null;
        }
        Object obj = this.data.get(str);
        AppMethodBeat.o(61801);
        return obj;
    }

    private void notifyReleaseHandlers(V8 v8) {
        AppMethodBeat.i(61802);
        Iterator<V8Runnable> it = this.releaseHandlers.iterator();
        while (it.hasNext()) {
            it.next().run(v8);
        }
        AppMethodBeat.o(61802);
    }

    private void notifyReferenceCreated(V8Value v8Value) {
        AppMethodBeat.i(61803);
        Iterator<ReferenceHandler> it = this.referenceHandlers.iterator();
        while (it.hasNext()) {
            it.next().v8HandleCreated(v8Value);
        }
        AppMethodBeat.o(61803);
    }

    private void notifyReferenceDisposed(V8Value v8Value) {
        AppMethodBeat.i(61804);
        Iterator<ReferenceHandler> it = this.referenceHandlers.iterator();
        while (it.hasNext()) {
            it.next().v8HandleDisposed(v8Value);
        }
        AppMethodBeat.o(61804);
    }

    private static void checkNativeLibraryLoaded() {
        AppMethodBeat.i(61805);
        if (nativeLibraryLoaded) {
            AppMethodBeat.o(61805);
        } else if (nativeLoadError != null) {
            IllegalStateException illegalStateException = new IllegalStateException("J2V8 native library not loaded", nativeLoadError);
            AppMethodBeat.o(61805);
            throw illegalStateException;
        } else if (nativeLoadException != null) {
            IllegalStateException illegalStateException2 = new IllegalStateException("J2V8 native library not loaded", nativeLoadException);
            AppMethodBeat.o(61805);
            throw illegalStateException2;
        } else {
            IllegalStateException illegalStateException3 = new IllegalStateException("J2V8 native library not loaded");
            AppMethodBeat.o(61805);
            throw illegalStateException3;
        }
    }

    protected V8() {
        this(null, true);
    }

    protected V8(String str, boolean z) {
        super(null);
        AppMethodBeat.i(61806);
        this.v8WeakReferences = new HashMap();
        this.data = null;
        this.objectReferences = 0;
        this.v8RuntimePtr = 0;
        this.resources = null;
        this.executors = null;
        this.forceTerminateExecutors = false;
        this.functionRegistry = new HashMap();
        this.referenceHandlers = new LinkedList<>();
        this.releaseHandlers = new LinkedList<>();
        this._javaTaskScheduler = null;
        this.released = false;
        this.v8RuntimePtr = _createIsolate(str, z);
        this.locker = new V8Locker(this);
        checkThread();
        if (z) {
            this.objectHandle = _getGlobalObject(this.v8RuntimePtr);
        }
        AppMethodBeat.o(61806);
    }

    public static V8Value getUndefined() {
        return undefined;
    }

    public static int getActiveRuntimes() {
        return runtimeCounter;
    }

    public long getObjectReferenceCount() {
        AppMethodBeat.i(61807);
        long size = this.objectReferences - ((long) this.v8WeakReferences.size());
        AppMethodBeat.o(61807);
        return size;
    }

    /* access modifiers changed from: protected */
    public long getV8RuntimePtr() {
        return this.v8RuntimePtr;
    }

    public static String getV8Version() {
        AppMethodBeat.i(61808);
        String _getVersion = _getVersion();
        AppMethodBeat.o(61808);
        return _getVersion;
    }

    public static String getSCMRevision() {
        return "Unknown revision ID";
    }

    @Override // com.eclipsesource.v8.V8Value, com.eclipsesource.v8.Releasable
    public void release() {
        AppMethodBeat.i(61809);
        release(true);
        AppMethodBeat.o(61809);
    }

    public void terminateExecution() {
        AppMethodBeat.i(61810);
        this.forceTerminateExecutors = true;
        terminateExecution(this.v8RuntimePtr);
        AppMethodBeat.o(61810);
    }

    public void release(boolean z) {
        AppMethodBeat.i(61811);
        if (isReleased()) {
            AppMethodBeat.o(61811);
            return;
        }
        checkThread();
        try {
            notifyReleaseHandlers(this);
            releaseResources();
            shutdownExecutors(this.forceTerminateExecutors);
            if (this.executors != null) {
                this.executors.clear();
            }
            releaseNativeMethodDescriptors();
            synchronized (lock) {
                try {
                    runtimeCounter--;
                } catch (Throwable th) {
                    AppMethodBeat.o(61811);
                    throw th;
                }
            }
            this.locker.release();
            _releaseRuntime(this.v8RuntimePtr);
            this.v8RuntimePtr = 0;
            this.released = true;
            if (!z || getObjectReferenceCount() <= 0) {
                AppMethodBeat.o(61811);
                return;
            }
            IllegalStateException illegalStateException = new IllegalStateException(this.objectReferences + " Object(s) still exist in runtime");
            AppMethodBeat.o(61811);
            throw illegalStateException;
        } catch (Throwable th2) {
            AppMethodBeat.o(61811);
            throw th2;
        }
    }

    private void releaseNativeMethodDescriptors() {
        AppMethodBeat.i(61812);
        for (Long l : this.functionRegistry.keySet()) {
            releaseMethodDescriptor(this.v8RuntimePtr, l.longValue());
        }
        AppMethodBeat.o(61812);
    }

    private void releaseResources() {
        AppMethodBeat.i(61813);
        if (this.resources != null) {
            for (Releasable releasable : this.resources) {
                releasable.release();
            }
            this.resources.clear();
            this.resources = null;
        }
        AppMethodBeat.o(61813);
    }

    public void registerV8Executor(V8Object v8Object, V8Executor v8Executor) {
        AppMethodBeat.i(61814);
        checkThread();
        if (this.executors == null) {
            this.executors = new V8Map<>();
        }
        this.executors.put((V8Value) v8Object, v8Executor);
        AppMethodBeat.o(61814);
    }

    public V8Executor removeExecutor(V8Object v8Object) {
        AppMethodBeat.i(61815);
        checkThread();
        if (this.executors == null) {
            AppMethodBeat.o(61815);
            return null;
        }
        V8Executor remove = this.executors.remove(v8Object);
        AppMethodBeat.o(61815);
        return remove;
    }

    public V8Executor getExecutor(V8Object v8Object) {
        AppMethodBeat.i(61816);
        checkThread();
        if (this.executors == null) {
            AppMethodBeat.o(61816);
            return null;
        }
        V8Executor v8Executor = this.executors.get(v8Object);
        AppMethodBeat.o(61816);
        return v8Executor;
    }

    public void shutdownExecutors(boolean z) {
        AppMethodBeat.i(61817);
        checkThread();
        if (this.executors == null) {
            AppMethodBeat.o(61817);
            return;
        }
        for (V8Executor v8Executor : this.executors.values()) {
            if (z) {
                v8Executor.forceTermination();
            } else {
                v8Executor.shutdown();
            }
        }
        AppMethodBeat.o(61817);
    }

    public void registerResource(Releasable releasable) {
        AppMethodBeat.i(61818);
        checkThread();
        if (this.resources == null) {
            this.resources = new ArrayList();
        }
        this.resources.add(releasable);
        AppMethodBeat.o(61818);
    }

    public int executeIntegerScript(String str) {
        AppMethodBeat.i(61819);
        int executeIntegerScript = executeIntegerScript(str, null, 0, null, null, 0, null);
        AppMethodBeat.o(61819);
        return executeIntegerScript;
    }

    public int executeIntegerScript(String str, String str2, int i2) {
        AppMethodBeat.i(61820);
        int executeIntegerScript = executeIntegerScript(str, str2, i2, null, null, 0, null);
        AppMethodBeat.o(61820);
        return executeIntegerScript;
    }

    public int executeIntegerScript(String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails) {
        AppMethodBeat.i(61821);
        checkThread();
        checkScript(str);
        int executeIntegerScript = executeIntegerScript(this.v8RuntimePtr, str, str2, i2, str3, str4, i3, executeDetails);
        AppMethodBeat.o(61821);
        return executeIntegerScript;
    }

    /* access modifiers changed from: protected */
    public void createTwin(V8Value v8Value, V8Value v8Value2) {
        AppMethodBeat.i(61822);
        checkThread();
        createTwin(this.v8RuntimePtr, v8Value.getHandle(), v8Value2.getHandle());
        AppMethodBeat.o(61822);
    }

    public double executeDoubleScript(String str) {
        AppMethodBeat.i(61823);
        double executeDoubleScript = executeDoubleScript(str, null, 0, null, null, 0, null);
        AppMethodBeat.o(61823);
        return executeDoubleScript;
    }

    public double executeDoubleScript(String str, String str2, int i2) {
        AppMethodBeat.i(61824);
        double executeDoubleScript = executeDoubleScript(str, str2, i2, null, null, 0, null);
        AppMethodBeat.o(61824);
        return executeDoubleScript;
    }

    public double executeDoubleScript(String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails) {
        AppMethodBeat.i(61825);
        checkThread();
        checkScript(str);
        double executeDoubleScript = executeDoubleScript(this.v8RuntimePtr, str, str2, i2, str3, str4, i3, executeDetails);
        AppMethodBeat.o(61825);
        return executeDoubleScript;
    }

    public String executeStringScript(String str) {
        AppMethodBeat.i(61826);
        String executeStringScript = executeStringScript(str, null, 0, null, null, 0, null);
        AppMethodBeat.o(61826);
        return executeStringScript;
    }

    public String executeStringScript(String str, String str2, int i2) {
        AppMethodBeat.i(61827);
        String executeStringScript = executeStringScript(str, str2, i2, null, null, 0, null);
        AppMethodBeat.o(61827);
        return executeStringScript;
    }

    public String executeStringScript(String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails) {
        AppMethodBeat.i(61828);
        checkThread();
        checkScript(str);
        String executeStringScript = executeStringScript(this.v8RuntimePtr, str, str2, i2, str3, str4, i3, executeDetails);
        AppMethodBeat.o(61828);
        return executeStringScript;
    }

    public boolean executeBooleanScript(String str) {
        AppMethodBeat.i(61829);
        boolean executeBooleanScript = executeBooleanScript(str, null, 0, null, null, 0, null);
        AppMethodBeat.o(61829);
        return executeBooleanScript;
    }

    public boolean executeBooleanScript(String str, String str2, int i2) {
        AppMethodBeat.i(61830);
        boolean executeBooleanScript = executeBooleanScript(str, str2, i2, null, null, 0, null);
        AppMethodBeat.o(61830);
        return executeBooleanScript;
    }

    public boolean executeBooleanScript(String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails) {
        AppMethodBeat.i(61831);
        checkThread();
        checkScript(str);
        boolean executeBooleanScript = executeBooleanScript(this.v8RuntimePtr, str, str2, i2, str3, str4, i3, executeDetails);
        AppMethodBeat.o(61831);
        return executeBooleanScript;
    }

    public V8Array executeArrayScript(String str) {
        AppMethodBeat.i(61832);
        V8Array executeArrayScript = executeArrayScript(str, null, 0, null, null, 0, null);
        AppMethodBeat.o(61832);
        return executeArrayScript;
    }

    public V8Array executeArrayScript(String str, String str2, int i2) {
        AppMethodBeat.i(61833);
        V8Array executeArrayScript = executeArrayScript(str, str2, i2, null, null, 0, null);
        AppMethodBeat.o(61833);
        return executeArrayScript;
    }

    public V8Array executeArrayScript(String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails) {
        AppMethodBeat.i(61834);
        checkThread();
        Object executeScript = executeScript(str, str2, i2, str3, str4, i3, executeDetails);
        if (executeScript instanceof V8Array) {
            V8Array v8Array = (V8Array) executeScript;
            AppMethodBeat.o(61834);
            return v8Array;
        }
        V8ResultUndefined v8ResultUndefined = new V8ResultUndefined();
        AppMethodBeat.o(61834);
        throw v8ResultUndefined;
    }

    public Object executeScript(String str) {
        AppMethodBeat.i(61835);
        Object executeScript = executeScript(str, null, 0, null, null, 0, null);
        AppMethodBeat.o(61835);
        return executeScript;
    }

    public Object executeScript(String str, String str2, int i2) {
        AppMethodBeat.i(61836);
        Object executeScript = executeScript(str, str2, i2, null, null, 0, null);
        AppMethodBeat.o(61836);
        return executeScript;
    }

    public Object executeScript(String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails) {
        AppMethodBeat.i(61837);
        checkThread();
        checkScript(str);
        Object executeScript = executeScript(getV8RuntimePtr(), 0, str, str2, i2, str3, str4, i3, executeDetails);
        AppMethodBeat.o(61837);
        return executeScript;
    }

    public V8Object executeObjectScript(String str) {
        AppMethodBeat.i(61838);
        V8Object executeObjectScript = executeObjectScript(str, null, 0, null, null, 0, null);
        AppMethodBeat.o(61838);
        return executeObjectScript;
    }

    public V8Object executeObjectScript(String str, String str2, int i2) {
        AppMethodBeat.i(61839);
        V8Object executeObjectScript = executeObjectScript(str, str2, i2, null, null, 0, null);
        AppMethodBeat.o(61839);
        return executeObjectScript;
    }

    public V8Object executeObjectScript(String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails) {
        AppMethodBeat.i(61840);
        checkThread();
        Object executeScript = executeScript(str, str2, i2, str3, str4, i3, executeDetails);
        if (executeScript instanceof V8Object) {
            V8Object v8Object = (V8Object) executeScript;
            AppMethodBeat.o(61840);
            return v8Object;
        }
        V8ResultUndefined v8ResultUndefined = new V8ResultUndefined();
        AppMethodBeat.o(61840);
        throw v8ResultUndefined;
    }

    public void executeVoidScript(String str) {
        AppMethodBeat.i(61841);
        executeVoidScript(str, null, 0, null, null, 0, null);
        AppMethodBeat.o(61841);
    }

    public void executeVoidScript(String str, String str2, int i2) {
        AppMethodBeat.i(61842);
        executeVoidScript(str, str2, i2, null, null, 0, null);
        AppMethodBeat.o(61842);
    }

    public void executeVoidScript(String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails) {
        AppMethodBeat.i(61843);
        checkThread();
        checkScript(str);
        executeVoidScript(this.v8RuntimePtr, str, str2, i2, str3, str4, i3, executeDetails);
        AppMethodBeat.o(61843);
    }

    public Object executeWxaScript(ArrayList<ScriptPartObject> arrayList, String str, int i2, String str2, String str3, int i3, ExecuteDetails executeDetails) {
        AppMethodBeat.i(175412);
        checkThread();
        Object executeWxaScript = executeWxaScript(this.v8RuntimePtr, arrayList, 0, str, i2, str2, str3, i3, executeDetails);
        AppMethodBeat.o(175412);
        return executeWxaScript;
    }

    public V8Locker getLocker() {
        return this.locker;
    }

    public long getBuildID() {
        AppMethodBeat.i(61844);
        long _getBuildID = _getBuildID();
        AppMethodBeat.o(61844);
        return _getBuildID;
    }

    public void lowMemoryNotification() {
        AppMethodBeat.i(61845);
        checkThread();
        lowMemoryNotification(getV8RuntimePtr());
        AppMethodBeat.o(61845);
    }

    public void memoryPressureNotification(int i2) {
        AppMethodBeat.i(61846);
        _memoryPressureNotification(this.v8RuntimePtr, i2);
        AppMethodBeat.o(61846);
    }

    /* access modifiers changed from: package-private */
    public void checkRuntime(V8Value v8Value) {
        AppMethodBeat.i(61847);
        if (v8Value == null || v8Value.isUndefined()) {
            AppMethodBeat.o(61847);
            return;
        }
        V8 runtime = v8Value.getRuntime();
        if (runtime == null || runtime.isReleased() || runtime != this) {
            Error error = new Error("Invalid target runtime");
            AppMethodBeat.o(61847);
            throw error;
        }
        AppMethodBeat.o(61847);
    }

    /* access modifiers changed from: package-private */
    public void checkThread() {
        AppMethodBeat.i(61848);
        this.locker.checkThread();
        if (isReleased()) {
            Error error = new Error("Runtime disposed error");
            AppMethodBeat.o(61848);
            throw error;
        }
        AppMethodBeat.o(61848);
    }

    static void checkScript(String str) {
        AppMethodBeat.i(61849);
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("Script is null");
            AppMethodBeat.o(61849);
            throw nullPointerException;
        }
        AppMethodBeat.o(61849);
    }

    /* access modifiers changed from: package-private */
    public void registerCallback(Object obj, Method method, long j2, String str, boolean z) {
        AppMethodBeat.i(61850);
        MethodDescriptor methodDescriptor = new MethodDescriptor();
        methodDescriptor.object = obj;
        methodDescriptor.method = method;
        methodDescriptor.includeReceiver = z;
        this.functionRegistry.put(Long.valueOf(registerJavaMethod(getV8RuntimePtr(), j2, str, isVoidMethod(method))), methodDescriptor);
        AppMethodBeat.o(61850);
    }

    /* access modifiers changed from: package-private */
    public void registerVoidCallback(JavaVoidCallback javaVoidCallback, long j2, String str) {
        AppMethodBeat.i(61851);
        MethodDescriptor methodDescriptor = new MethodDescriptor();
        methodDescriptor.voidCallback = javaVoidCallback;
        this.functionRegistry.put(Long.valueOf(registerJavaMethod(getV8RuntimePtr(), j2, str, true)), methodDescriptor);
        AppMethodBeat.o(61851);
    }

    /* access modifiers changed from: package-private */
    public void registerCallback(JavaCallback javaCallback, long j2, String str) {
        AppMethodBeat.i(61852);
        createAndRegisterMethodDescriptor(javaCallback, registerJavaMethod(getV8RuntimePtr(), j2, str, false));
        AppMethodBeat.o(61852);
    }

    /* access modifiers changed from: package-private */
    public void createAndRegisterMethodDescriptor(JavaCallback javaCallback, long j2) {
        AppMethodBeat.i(61853);
        MethodDescriptor methodDescriptor = new MethodDescriptor();
        methodDescriptor.callback = javaCallback;
        this.functionRegistry.put(Long.valueOf(j2), methodDescriptor);
        AppMethodBeat.o(61853);
    }

    private boolean isVoidMethod(Method method) {
        AppMethodBeat.i(61854);
        if (method.getReturnType().equals(Void.TYPE)) {
            AppMethodBeat.o(61854);
            return true;
        }
        AppMethodBeat.o(61854);
        return false;
    }

    private Object getDefaultValue(Class<?> cls) {
        AppMethodBeat.i(61855);
        if (cls.equals(V8Object.class)) {
            V8Object.Undefined undefined2 = new V8Object.Undefined();
            AppMethodBeat.o(61855);
            return undefined2;
        } else if (cls.equals(V8Array.class)) {
            V8Array.Undefined undefined3 = new V8Array.Undefined();
            AppMethodBeat.o(61855);
            return undefined3;
        } else {
            Object obj = invalid;
            AppMethodBeat.o(61855);
            return obj;
        }
    }

    /* access modifiers changed from: protected */
    public void disposeMethodID(long j2) {
        AppMethodBeat.i(61856);
        this.functionRegistry.remove(Long.valueOf(j2));
        AppMethodBeat.o(61856);
    }

    /* access modifiers changed from: protected */
    public void weakReferenceReleased(long j2) {
        AppMethodBeat.i(61857);
        V8Value v8Value = this.v8WeakReferences.get(Long.valueOf(j2));
        if (v8Value != null) {
            this.v8WeakReferences.remove(Long.valueOf(j2));
            try {
                v8Value.release();
                AppMethodBeat.o(61857);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(61857);
    }

    /* access modifiers changed from: protected */
    public Object callObjectJavaMethod(long j2, V8Object v8Object, V8Array v8Array) {
        AppMethodBeat.i(61858);
        MethodDescriptor methodDescriptor = this.functionRegistry.get(Long.valueOf(j2));
        if (methodDescriptor.callback != null) {
            Object checkResult = checkResult(methodDescriptor.callback.invoke(v8Object, v8Array));
            AppMethodBeat.o(61858);
            return checkResult;
        }
        boolean isVarArgs = methodDescriptor.method.isVarArgs();
        Object[] args = getArgs(v8Object, methodDescriptor, v8Array, isVarArgs);
        checkArgs(args);
        try {
            Object checkResult2 = checkResult(methodDescriptor.method.invoke(methodDescriptor.object, args));
            releaseArguments(args, isVarArgs);
            AppMethodBeat.o(61858);
            return checkResult2;
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            AppMethodBeat.o(61858);
            throw targetException;
        } catch (IllegalAccessException e3) {
            AppMethodBeat.o(61858);
            throw e3;
        } catch (IllegalArgumentException e4) {
            AppMethodBeat.o(61858);
            throw e4;
        } catch (Throwable th) {
            releaseArguments(args, isVarArgs);
            AppMethodBeat.o(61858);
            throw th;
        }
    }

    private Object checkResult(Object obj) {
        AppMethodBeat.i(61859);
        if (obj == null) {
            AppMethodBeat.o(61859);
            return obj;
        } else if (obj instanceof Float) {
            Double valueOf = Double.valueOf(((Float) obj).doubleValue());
            AppMethodBeat.o(61859);
            return valueOf;
        } else if ((obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Boolean) || (obj instanceof String)) {
            AppMethodBeat.o(61859);
            return obj;
        } else if (!(obj instanceof V8Value)) {
            V8RuntimeException v8RuntimeException = new V8RuntimeException("Unknown return type: " + obj.getClass());
            AppMethodBeat.o(61859);
            throw v8RuntimeException;
        } else if (((V8Value) obj).isReleased()) {
            V8RuntimeException v8RuntimeException2 = new V8RuntimeException("V8Value already released");
            AppMethodBeat.o(61859);
            throw v8RuntimeException2;
        } else {
            AppMethodBeat.o(61859);
            return obj;
        }
    }

    /* access modifiers changed from: protected */
    public void callVoidJavaMethod(long j2, V8Object v8Object, V8Array v8Array) {
        AppMethodBeat.i(61860);
        MethodDescriptor methodDescriptor = this.functionRegistry.get(Long.valueOf(j2));
        if (methodDescriptor.voidCallback != null) {
            methodDescriptor.voidCallback.invoke(v8Object, v8Array);
            AppMethodBeat.o(61860);
            return;
        }
        boolean isVarArgs = methodDescriptor.method.isVarArgs();
        Object[] args = getArgs(v8Object, methodDescriptor, v8Array, isVarArgs);
        checkArgs(args);
        try {
            methodDescriptor.method.invoke(methodDescriptor.object, args);
            releaseArguments(args, isVarArgs);
            AppMethodBeat.o(61860);
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            AppMethodBeat.o(61860);
            throw targetException;
        } catch (IllegalAccessException e3) {
            AppMethodBeat.o(61860);
            throw e3;
        } catch (IllegalArgumentException e4) {
            AppMethodBeat.o(61860);
            throw e4;
        } catch (Throwable th) {
            releaseArguments(args, isVarArgs);
            AppMethodBeat.o(61860);
            throw th;
        }
    }

    private void checkArgs(Object[] objArr) {
        AppMethodBeat.i(61861);
        for (Object obj : objArr) {
            if (obj == invalid) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("argument type mismatch");
                AppMethodBeat.o(61861);
                throw illegalArgumentException;
            }
        }
        AppMethodBeat.o(61861);
    }

    private void releaseArguments(Object[] objArr, boolean z) {
        AppMethodBeat.i(61862);
        if (z && objArr.length > 0 && (objArr[objArr.length - 1] instanceof Object[])) {
            Object[] objArr2 = (Object[]) objArr[objArr.length - 1];
            for (Object obj : objArr2) {
                if (obj instanceof V8Value) {
                    ((V8Value) obj).release();
                }
            }
        }
        for (Object obj2 : objArr) {
            if (obj2 instanceof V8Value) {
                ((V8Value) obj2).release();
            }
        }
        AppMethodBeat.o(61862);
    }

    private Object[] getArgs(V8Object v8Object, MethodDescriptor methodDescriptor, V8Array v8Array, boolean z) {
        AppMethodBeat.i(61863);
        int length = methodDescriptor.method.getParameterTypes().length;
        int i2 = z ? length - 1 : length;
        Object[] defaultValues = setDefaultValues(new Object[length], methodDescriptor.method.getParameterTypes(), v8Object, methodDescriptor.includeReceiver);
        ArrayList arrayList = new ArrayList();
        populateParamters(v8Array, i2, defaultValues, arrayList, methodDescriptor.includeReceiver);
        if (z) {
            Object varArgContainer = getVarArgContainer(methodDescriptor.method.getParameterTypes(), arrayList.size());
            System.arraycopy(arrayList.toArray(), 0, varArgContainer, 0, arrayList.size());
            defaultValues[i2] = varArgContainer;
        }
        AppMethodBeat.o(61863);
        return defaultValues;
    }

    private Object getVarArgContainer(Class<?>[] clsArr, int i2) {
        AppMethodBeat.i(61864);
        Class<?> cls = clsArr[clsArr.length - 1];
        if (cls.isArray()) {
            cls = cls.getComponentType();
        }
        Object newInstance = Array.newInstance(cls, i2);
        AppMethodBeat.o(61864);
        return newInstance;
    }

    private void populateParamters(V8Array v8Array, int i2, Object[] objArr, List<Object> list, boolean z) {
        AppMethodBeat.i(61865);
        int i3 = 0;
        if (z) {
            i3 = 1;
        }
        for (int i4 = i3; i4 < v8Array.length() + i3; i4++) {
            if (i4 >= i2) {
                list.add(getArrayItem(v8Array, i4 - i3));
            } else {
                objArr[i4] = getArrayItem(v8Array, i4 - i3);
            }
        }
        AppMethodBeat.o(61865);
    }

    private Object[] setDefaultValues(Object[] objArr, Class<?>[] clsArr, V8Object v8Object, boolean z) {
        int i2;
        AppMethodBeat.i(61866);
        if (z) {
            i2 = 1;
            objArr[0] = v8Object;
        } else {
            i2 = 0;
        }
        while (i2 < objArr.length) {
            objArr[i2] = getDefaultValue(clsArr[i2]);
            i2++;
        }
        AppMethodBeat.o(61866);
        return objArr;
    }

    private Object getArrayItem(V8Array v8Array, int i2) {
        AppMethodBeat.i(61867);
        try {
            switch (v8Array.getType(i2)) {
                case 1:
                    Integer valueOf = Integer.valueOf(v8Array.getInteger(i2));
                    AppMethodBeat.o(61867);
                    return valueOf;
                case 2:
                    Double valueOf2 = Double.valueOf(v8Array.getDouble(i2));
                    AppMethodBeat.o(61867);
                    return valueOf2;
                case 3:
                    Boolean valueOf3 = Boolean.valueOf(v8Array.getBoolean(i2));
                    AppMethodBeat.o(61867);
                    return valueOf3;
                case 4:
                    String string = v8Array.getString(i2);
                    AppMethodBeat.o(61867);
                    return string;
                case 5:
                case 8:
                    V8Array array = v8Array.getArray(i2);
                    AppMethodBeat.o(61867);
                    return array;
                case 6:
                    V8Object object = v8Array.getObject(i2);
                    AppMethodBeat.o(61867);
                    return object;
                case 7:
                    V8Object object2 = v8Array.getObject(i2);
                    AppMethodBeat.o(61867);
                    return object2;
                case 10:
                    Object obj = v8Array.get(i2);
                    AppMethodBeat.o(61867);
                    return obj;
                case 99:
                    V8Value undefined2 = getUndefined();
                    AppMethodBeat.o(61867);
                    return undefined2;
            }
        } catch (V8ResultUndefined e2) {
        }
        AppMethodBeat.o(61867);
        return null;
    }

    /* access modifiers changed from: package-private */
    public void createNodeRuntime(String str) {
        AppMethodBeat.i(61868);
        _startNodeJS(this.v8RuntimePtr, str);
        AppMethodBeat.o(61868);
    }

    /* access modifiers changed from: package-private */
    public boolean pumpMessageLoop() {
        AppMethodBeat.i(61869);
        boolean _pumpMessageLoop = _pumpMessageLoop(this.v8RuntimePtr);
        AppMethodBeat.o(61869);
        return _pumpMessageLoop;
    }

    public void pumpMessageLoopDirect() {
        AppMethodBeat.i(194295);
        _pumpMessageLoopDirect(this.v8RuntimePtr);
        AppMethodBeat.o(194295);
    }

    /* access modifiers changed from: package-private */
    public boolean isRunning() {
        AppMethodBeat.i(61870);
        boolean _isRunning = _isRunning(this.v8RuntimePtr);
        AppMethodBeat.o(61870);
        return _isRunning;
    }

    /* access modifiers changed from: protected */
    public long initNewV8Object(long j2) {
        AppMethodBeat.i(61871);
        long _initNewV8Object = _initNewV8Object(j2);
        AppMethodBeat.o(61871);
        return _initNewV8Object;
    }

    /* access modifiers changed from: protected */
    public long getGlobalObject() {
        AppMethodBeat.i(61872);
        long _getGlobalObject = _getGlobalObject(this.v8RuntimePtr);
        AppMethodBeat.o(61872);
        return _getGlobalObject;
    }

    /* access modifiers changed from: protected */
    public void acquireLock(long j2) {
        AppMethodBeat.i(61873);
        _acquireLock(j2);
        AppMethodBeat.o(61873);
    }

    /* access modifiers changed from: protected */
    public void releaseLock(long j2) {
        AppMethodBeat.i(61874);
        _releaseLock(j2);
        AppMethodBeat.o(61874);
    }

    /* access modifiers changed from: protected */
    public void lowMemoryNotification(long j2) {
        AppMethodBeat.i(61875);
        _lowMemoryNotification(j2);
        AppMethodBeat.o(61875);
    }

    /* access modifiers changed from: protected */
    public void createTwin(long j2, long j3, long j4) {
        AppMethodBeat.i(61876);
        _createTwin(j2, j3, j4);
        AppMethodBeat.o(61876);
    }

    /* access modifiers changed from: protected */
    public int executeIntegerScript(long j2, String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails) {
        AppMethodBeat.i(61877);
        int _executeIntegerScript = _executeIntegerScript(j2, str, str2, i2, str3, str4, i3, executeDetails);
        AppMethodBeat.o(61877);
        return _executeIntegerScript;
    }

    /* access modifiers changed from: protected */
    public double executeDoubleScript(long j2, String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails) {
        AppMethodBeat.i(61878);
        double _executeDoubleScript = _executeDoubleScript(j2, str, str2, i2, str3, str4, i3, executeDetails);
        AppMethodBeat.o(61878);
        return _executeDoubleScript;
    }

    /* access modifiers changed from: protected */
    public String executeStringScript(long j2, String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails) {
        AppMethodBeat.i(61879);
        String _executeStringScript = _executeStringScript(j2, str, str2, i2, str3, str4, i3, executeDetails);
        AppMethodBeat.o(61879);
        return _executeStringScript;
    }

    /* access modifiers changed from: protected */
    public boolean executeBooleanScript(long j2, String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails) {
        AppMethodBeat.i(61880);
        boolean _executeBooleanScript = _executeBooleanScript(j2, str, str2, i2, str3, str4, i3, executeDetails);
        AppMethodBeat.o(61880);
        return _executeBooleanScript;
    }

    /* access modifiers changed from: protected */
    public Object executeScript(long j2, int i2, String str, String str2, int i3, String str3, String str4, int i4, ExecuteDetails executeDetails) {
        AppMethodBeat.i(61881);
        Object _executeScript = _executeScript(j2, i2, str, str2, i3, str3, str4, i4, executeDetails);
        AppMethodBeat.o(61881);
        return _executeScript;
    }

    /* access modifiers changed from: protected */
    public void executeVoidScript(long j2, String str, String str2, int i2, String str3, String str4, int i3, ExecuteDetails executeDetails) {
        AppMethodBeat.i(61882);
        _executeVoidScript(j2, str, str2, i2, str3, str4, i3, executeDetails);
        AppMethodBeat.o(61882);
    }

    /* access modifiers changed from: protected */
    public Object executeWxaScript(long j2, ArrayList<ScriptPartObject> arrayList, int i2, String str, int i3, String str2, String str3, int i4, ExecuteDetails executeDetails) {
        AppMethodBeat.i(175413);
        Object _executeWxaScript = _executeWxaScript(j2, arrayList, i2, str, i3, str2, str3, i4, executeDetails);
        AppMethodBeat.o(175413);
        return _executeWxaScript;
    }

    /* access modifiers changed from: protected */
    public void setWeak(long j2, long j3) {
        AppMethodBeat.i(61883);
        _setWeak(j2, j3);
        AppMethodBeat.o(61883);
    }

    /* access modifiers changed from: protected */
    public boolean isWeak(long j2, long j3) {
        AppMethodBeat.i(61884);
        boolean _isWeak = _isWeak(j2, j3);
        AppMethodBeat.o(61884);
        return _isWeak;
    }

    /* access modifiers changed from: protected */
    public void release(long j2, long j3) {
        AppMethodBeat.i(61885);
        _release(j2, j3);
        AppMethodBeat.o(61885);
    }

    /* access modifiers changed from: protected */
    public boolean contains(long j2, long j3, String str) {
        AppMethodBeat.i(61886);
        boolean _contains = _contains(j2, j3, str);
        AppMethodBeat.o(61886);
        return _contains;
    }

    /* access modifiers changed from: protected */
    public String[] getKeys(long j2, long j3) {
        AppMethodBeat.i(61887);
        String[] _getKeys = _getKeys(j2, j3);
        AppMethodBeat.o(61887);
        return _getKeys;
    }

    /* access modifiers changed from: protected */
    public int getInteger(long j2, long j3, String str) {
        AppMethodBeat.i(61888);
        int _getInteger = _getInteger(j2, j3, str);
        AppMethodBeat.o(61888);
        return _getInteger;
    }

    /* access modifiers changed from: protected */
    public boolean getBoolean(long j2, long j3, String str) {
        AppMethodBeat.i(61889);
        boolean _getBoolean = _getBoolean(j2, j3, str);
        AppMethodBeat.o(61889);
        return _getBoolean;
    }

    /* access modifiers changed from: protected */
    public double getDouble(long j2, long j3, String str) {
        AppMethodBeat.i(61890);
        double _getDouble = _getDouble(j2, j3, str);
        AppMethodBeat.o(61890);
        return _getDouble;
    }

    /* access modifiers changed from: protected */
    public String getString(long j2, long j3, String str) {
        AppMethodBeat.i(61891);
        String _getString = _getString(j2, j3, str);
        AppMethodBeat.o(61891);
        return _getString;
    }

    /* access modifiers changed from: protected */
    public Object get(long j2, int i2, long j3, String str) {
        AppMethodBeat.i(61892);
        Object _get = _get(j2, i2, j3, str);
        AppMethodBeat.o(61892);
        return _get;
    }

    /* access modifiers changed from: protected */
    public int executeIntegerFunction(long j2, long j3, String str, long j4) {
        AppMethodBeat.i(61893);
        int _executeIntegerFunction = _executeIntegerFunction(j2, j3, str, j4);
        AppMethodBeat.o(61893);
        return _executeIntegerFunction;
    }

    /* access modifiers changed from: protected */
    public double executeDoubleFunction(long j2, long j3, String str, long j4) {
        AppMethodBeat.i(61894);
        double _executeDoubleFunction = _executeDoubleFunction(j2, j3, str, j4);
        AppMethodBeat.o(61894);
        return _executeDoubleFunction;
    }

    /* access modifiers changed from: protected */
    public String executeStringFunction(long j2, long j3, String str, long j4) {
        AppMethodBeat.i(61895);
        String _executeStringFunction = _executeStringFunction(j2, j3, str, j4);
        AppMethodBeat.o(61895);
        return _executeStringFunction;
    }

    /* access modifiers changed from: protected */
    public boolean executeBooleanFunction(long j2, long j3, String str, long j4) {
        AppMethodBeat.i(61896);
        boolean _executeBooleanFunction = _executeBooleanFunction(j2, j3, str, j4);
        AppMethodBeat.o(61896);
        return _executeBooleanFunction;
    }

    /* access modifiers changed from: protected */
    public Object executeFunction(long j2, int i2, long j3, String str, long j4) {
        AppMethodBeat.i(61897);
        Object _executeFunction = _executeFunction(j2, i2, j3, str, j4);
        AppMethodBeat.o(61897);
        return _executeFunction;
    }

    /* access modifiers changed from: protected */
    public Object executeFunction(long j2, long j3, long j4, long j5) {
        AppMethodBeat.i(61898);
        Object _executeFunction = _executeFunction(j2, j3, j4, j5);
        AppMethodBeat.o(61898);
        return _executeFunction;
    }

    /* access modifiers changed from: protected */
    public void executeVoidFunction(long j2, long j3, String str, long j4) {
        AppMethodBeat.i(61899);
        _executeVoidFunction(j2, j3, str, j4);
        AppMethodBeat.o(61899);
    }

    /* access modifiers changed from: protected */
    public boolean equals(long j2, long j3, long j4) {
        AppMethodBeat.i(61900);
        boolean _equals = _equals(j2, j3, j4);
        AppMethodBeat.o(61900);
        return _equals;
    }

    /* access modifiers changed from: protected */
    public String toString(long j2, long j3) {
        AppMethodBeat.i(61901);
        String _toString = _toString(j2, j3);
        AppMethodBeat.o(61901);
        return _toString;
    }

    /* access modifiers changed from: protected */
    public boolean strictEquals(long j2, long j3, long j4) {
        AppMethodBeat.i(61902);
        boolean _strictEquals = _strictEquals(j2, j3, j4);
        AppMethodBeat.o(61902);
        return _strictEquals;
    }

    /* access modifiers changed from: protected */
    public boolean sameValue(long j2, long j3, long j4) {
        AppMethodBeat.i(61903);
        boolean _sameValue = _sameValue(j2, j3, j4);
        AppMethodBeat.o(61903);
        return _sameValue;
    }

    /* access modifiers changed from: protected */
    public int identityHash(long j2, long j3) {
        AppMethodBeat.i(61904);
        int _identityHash = _identityHash(j2, j3);
        AppMethodBeat.o(61904);
        return _identityHash;
    }

    /* access modifiers changed from: protected */
    public void add(long j2, long j3, String str, int i2) {
        AppMethodBeat.i(61905);
        _add(j2, j3, str, i2);
        AppMethodBeat.o(61905);
    }

    /* access modifiers changed from: protected */
    public void addObject(long j2, long j3, String str, long j4) {
        AppMethodBeat.i(61906);
        _addObject(j2, j3, str, j4);
        AppMethodBeat.o(61906);
    }

    /* access modifiers changed from: protected */
    public void add(long j2, long j3, String str, boolean z) {
        AppMethodBeat.i(61907);
        _add(j2, j3, str, z);
        AppMethodBeat.o(61907);
    }

    /* access modifiers changed from: protected */
    public void add(long j2, long j3, String str, double d2) {
        AppMethodBeat.i(61908);
        _add(j2, j3, str, d2);
        AppMethodBeat.o(61908);
    }

    /* access modifiers changed from: protected */
    public void add(long j2, long j3, String str, String str2) {
        AppMethodBeat.i(61909);
        _add(j2, j3, str, str2);
        AppMethodBeat.o(61909);
    }

    /* access modifiers changed from: protected */
    public void addUndefined(long j2, long j3, String str) {
        AppMethodBeat.i(61910);
        _addUndefined(j2, j3, str);
        AppMethodBeat.o(61910);
    }

    /* access modifiers changed from: protected */
    public void addNull(long j2, long j3, String str) {
        AppMethodBeat.i(61911);
        _addNull(j2, j3, str);
        AppMethodBeat.o(61911);
    }

    /* access modifiers changed from: protected */
    public long registerJavaMethod(long j2, long j3, String str, boolean z) {
        AppMethodBeat.i(61912);
        long _registerJavaMethod = _registerJavaMethod(j2, j3, str, z);
        AppMethodBeat.o(61912);
        return _registerJavaMethod;
    }

    /* access modifiers changed from: protected */
    public long initNewV8ArrayBuffer(long j2, ByteBuffer byteBuffer, int i2) {
        AppMethodBeat.i(61913);
        long _initNewV8ArrayBuffer = _initNewV8ArrayBuffer(j2, byteBuffer, i2);
        AppMethodBeat.o(61913);
        return _initNewV8ArrayBuffer;
    }

    /* access modifiers changed from: protected */
    public long initNewSharedV8ArrayBuffer(long j2, ByteBuffer byteBuffer, int i2) {
        AppMethodBeat.i(61914);
        long _initNewSharedV8ArrayBuffer = _initNewSharedV8ArrayBuffer(j2, byteBuffer, i2);
        AppMethodBeat.o(61914);
        return _initNewSharedV8ArrayBuffer;
    }

    /* access modifiers changed from: protected */
    public long initNewV8ArrayBuffer(long j2, int i2) {
        AppMethodBeat.i(61915);
        long _initNewV8ArrayBuffer = _initNewV8ArrayBuffer(j2, i2);
        AppMethodBeat.o(61915);
        return _initNewV8ArrayBuffer;
    }

    public long initNewV8Int32Array(long j2, long j3, int i2, int i3) {
        AppMethodBeat.i(61916);
        long _initNewV8Int32Array = _initNewV8Int32Array(j2, j3, i2, i3);
        AppMethodBeat.o(61916);
        return _initNewV8Int32Array;
    }

    public long initNewV8Float32Array(long j2, long j3, int i2, int i3) {
        AppMethodBeat.i(61917);
        long _initNewV8Float32Array = _initNewV8Float32Array(j2, j3, i2, i3);
        AppMethodBeat.o(61917);
        return _initNewV8Float32Array;
    }

    public long initNewV8Float64Array(long j2, long j3, int i2, int i3) {
        AppMethodBeat.i(61918);
        long _initNewV8Float64Array = _initNewV8Float64Array(j2, j3, i2, i3);
        AppMethodBeat.o(61918);
        return _initNewV8Float64Array;
    }

    public long initNewV8UInt32Array(long j2, long j3, int i2, int i3) {
        AppMethodBeat.i(61919);
        long _initNewV8UInt32Array = _initNewV8UInt32Array(j2, j3, i2, i3);
        AppMethodBeat.o(61919);
        return _initNewV8UInt32Array;
    }

    public long initNewV8UInt16Array(long j2, long j3, int i2, int i3) {
        AppMethodBeat.i(61920);
        long _initNewV8UInt16Array = _initNewV8UInt16Array(j2, j3, i2, i3);
        AppMethodBeat.o(61920);
        return _initNewV8UInt16Array;
    }

    public long initNewV8Int16Array(long j2, long j3, int i2, int i3) {
        AppMethodBeat.i(61921);
        long _initNewV8Int16Array = _initNewV8Int16Array(j2, j3, i2, i3);
        AppMethodBeat.o(61921);
        return _initNewV8Int16Array;
    }

    public long initNewV8UInt8Array(long j2, long j3, int i2, int i3) {
        AppMethodBeat.i(61922);
        long _initNewV8UInt8Array = _initNewV8UInt8Array(j2, j3, i2, i3);
        AppMethodBeat.o(61922);
        return _initNewV8UInt8Array;
    }

    public long initNewV8Int8Array(long j2, long j3, int i2, int i3) {
        AppMethodBeat.i(61923);
        long _initNewV8Int8Array = _initNewV8Int8Array(j2, j3, i2, i3);
        AppMethodBeat.o(61923);
        return _initNewV8Int8Array;
    }

    public long initNewV8UInt8ClampedArray(long j2, long j3, int i2, int i3) {
        AppMethodBeat.i(61924);
        long _initNewV8UInt8ClampedArray = _initNewV8UInt8ClampedArray(j2, j3, i2, i3);
        AppMethodBeat.o(61924);
        return _initNewV8UInt8ClampedArray;
    }

    /* access modifiers changed from: protected */
    public ByteBuffer createV8ArrayBufferBackingStore(long j2, long j3, int i2) {
        AppMethodBeat.i(61925);
        ByteBuffer _createV8ArrayBufferBackingStore = _createV8ArrayBufferBackingStore(j2, j3, i2);
        AppMethodBeat.o(61925);
        return _createV8ArrayBufferBackingStore;
    }

    /* access modifiers changed from: protected */
    public long initNewV8Array(long j2) {
        AppMethodBeat.i(61926);
        long _initNewV8Array = _initNewV8Array(j2);
        AppMethodBeat.o(61926);
        return _initNewV8Array;
    }

    /* access modifiers changed from: protected */
    public long[] initNewV8Function(long j2) {
        AppMethodBeat.i(61927);
        checkThread();
        long[] _initNewV8Function = _initNewV8Function(j2);
        AppMethodBeat.o(61927);
        return _initNewV8Function;
    }

    /* access modifiers changed from: protected */
    public int arrayGetSize(long j2, long j3) {
        AppMethodBeat.i(61928);
        int _arrayGetSize = _arrayGetSize(j2, j3);
        AppMethodBeat.o(61928);
        return _arrayGetSize;
    }

    /* access modifiers changed from: protected */
    public int arrayGetInteger(long j2, long j3, int i2) {
        AppMethodBeat.i(61929);
        int _arrayGetInteger = _arrayGetInteger(j2, j3, i2);
        AppMethodBeat.o(61929);
        return _arrayGetInteger;
    }

    /* access modifiers changed from: protected */
    public boolean arrayGetBoolean(long j2, long j3, int i2) {
        AppMethodBeat.i(61930);
        boolean _arrayGetBoolean = _arrayGetBoolean(j2, j3, i2);
        AppMethodBeat.o(61930);
        return _arrayGetBoolean;
    }

    /* access modifiers changed from: protected */
    public byte arrayGetByte(long j2, long j3, int i2) {
        AppMethodBeat.i(61931);
        byte _arrayGetByte = _arrayGetByte(j2, j3, i2);
        AppMethodBeat.o(61931);
        return _arrayGetByte;
    }

    /* access modifiers changed from: protected */
    public double arrayGetDouble(long j2, long j3, int i2) {
        AppMethodBeat.i(61932);
        double _arrayGetDouble = _arrayGetDouble(j2, j3, i2);
        AppMethodBeat.o(61932);
        return _arrayGetDouble;
    }

    /* access modifiers changed from: protected */
    public String arrayGetString(long j2, long j3, int i2) {
        AppMethodBeat.i(61933);
        String _arrayGetString = _arrayGetString(j2, j3, i2);
        AppMethodBeat.o(61933);
        return _arrayGetString;
    }

    /* access modifiers changed from: protected */
    public Object arrayGet(long j2, int i2, long j3, int i3) {
        AppMethodBeat.i(61934);
        Object _arrayGet = _arrayGet(j2, i2, j3, i3);
        AppMethodBeat.o(61934);
        return _arrayGet;
    }

    /* access modifiers changed from: protected */
    public void addArrayIntItem(long j2, long j3, int i2) {
        AppMethodBeat.i(61935);
        _addArrayIntItem(j2, j3, i2);
        AppMethodBeat.o(61935);
    }

    /* access modifiers changed from: protected */
    public void addArrayBooleanItem(long j2, long j3, boolean z) {
        AppMethodBeat.i(61936);
        _addArrayBooleanItem(j2, j3, z);
        AppMethodBeat.o(61936);
    }

    /* access modifiers changed from: protected */
    public void addArrayDoubleItem(long j2, long j3, double d2) {
        AppMethodBeat.i(61937);
        _addArrayDoubleItem(j2, j3, d2);
        AppMethodBeat.o(61937);
    }

    /* access modifiers changed from: protected */
    public void addArrayStringItem(long j2, long j3, String str) {
        AppMethodBeat.i(61938);
        _addArrayStringItem(j2, j3, str);
        AppMethodBeat.o(61938);
    }

    /* access modifiers changed from: protected */
    public void addArrayObjectItem(long j2, long j3, long j4) {
        AppMethodBeat.i(61939);
        _addArrayObjectItem(j2, j3, j4);
        AppMethodBeat.o(61939);
    }

    /* access modifiers changed from: protected */
    public void addArrayUndefinedItem(long j2, long j3) {
        AppMethodBeat.i(61940);
        _addArrayUndefinedItem(j2, j3);
        AppMethodBeat.o(61940);
    }

    /* access modifiers changed from: protected */
    public void addArrayNullItem(long j2, long j3) {
        AppMethodBeat.i(61941);
        _addArrayNullItem(j2, j3);
        AppMethodBeat.o(61941);
    }

    /* access modifiers changed from: protected */
    public int getType(long j2, long j3) {
        AppMethodBeat.i(61942);
        int _getType = _getType(j2, j3);
        AppMethodBeat.o(61942);
        return _getType;
    }

    /* access modifiers changed from: protected */
    public int getType(long j2, long j3, String str) {
        AppMethodBeat.i(61943);
        int _getType = _getType(j2, j3, str);
        AppMethodBeat.o(61943);
        return _getType;
    }

    /* access modifiers changed from: protected */
    public int getType(long j2, long j3, int i2) {
        AppMethodBeat.i(61944);
        int _getType = _getType(j2, j3, i2);
        AppMethodBeat.o(61944);
        return _getType;
    }

    /* access modifiers changed from: protected */
    public int getArrayType(long j2, long j3) {
        AppMethodBeat.i(61945);
        int _getArrayType = _getArrayType(j2, j3);
        AppMethodBeat.o(61945);
        return _getArrayType;
    }

    /* access modifiers changed from: protected */
    public int getType(long j2, long j3, int i2, int i3) {
        AppMethodBeat.i(61946);
        int _getType = _getType(j2, j3, i2, i3);
        AppMethodBeat.o(61946);
        return _getType;
    }

    /* access modifiers changed from: protected */
    public void setPrototype(long j2, long j3, long j4) {
        AppMethodBeat.i(61947);
        _setPrototype(j2, j3, j4);
        AppMethodBeat.o(61947);
    }

    /* access modifiers changed from: protected */
    public int[] arrayGetIntegers(long j2, long j3, int i2, int i3) {
        AppMethodBeat.i(61948);
        int[] _arrayGetIntegers = _arrayGetIntegers(j2, j3, i2, i3);
        AppMethodBeat.o(61948);
        return _arrayGetIntegers;
    }

    /* access modifiers changed from: protected */
    public double[] arrayGetDoubles(long j2, long j3, int i2, int i3) {
        AppMethodBeat.i(61949);
        double[] _arrayGetDoubles = _arrayGetDoubles(j2, j3, i2, i3);
        AppMethodBeat.o(61949);
        return _arrayGetDoubles;
    }

    /* access modifiers changed from: protected */
    public boolean[] arrayGetBooleans(long j2, long j3, int i2, int i3) {
        AppMethodBeat.i(61950);
        boolean[] _arrayGetBooleans = _arrayGetBooleans(j2, j3, i2, i3);
        AppMethodBeat.o(61950);
        return _arrayGetBooleans;
    }

    /* access modifiers changed from: protected */
    public byte[] arrayGetBytes(long j2, long j3, int i2, int i3) {
        AppMethodBeat.i(61951);
        byte[] _arrayGetBytes = _arrayGetBytes(j2, j3, i2, i3);
        AppMethodBeat.o(61951);
        return _arrayGetBytes;
    }

    /* access modifiers changed from: protected */
    public String[] arrayGetStrings(long j2, long j3, int i2, int i3) {
        AppMethodBeat.i(61952);
        String[] _arrayGetStrings = _arrayGetStrings(j2, j3, i2, i3);
        AppMethodBeat.o(61952);
        return _arrayGetStrings;
    }

    /* access modifiers changed from: protected */
    public int arrayGetIntegers(long j2, long j3, int i2, int i3, int[] iArr) {
        AppMethodBeat.i(61953);
        int _arrayGetIntegers = _arrayGetIntegers(j2, j3, i2, i3, iArr);
        AppMethodBeat.o(61953);
        return _arrayGetIntegers;
    }

    /* access modifiers changed from: protected */
    public int arrayGetDoubles(long j2, long j3, int i2, int i3, double[] dArr) {
        AppMethodBeat.i(61954);
        int _arrayGetDoubles = _arrayGetDoubles(j2, j3, i2, i3, dArr);
        AppMethodBeat.o(61954);
        return _arrayGetDoubles;
    }

    /* access modifiers changed from: protected */
    public int arrayGetBooleans(long j2, long j3, int i2, int i3, boolean[] zArr) {
        AppMethodBeat.i(61955);
        int _arrayGetBooleans = _arrayGetBooleans(j2, j3, i2, i3, zArr);
        AppMethodBeat.o(61955);
        return _arrayGetBooleans;
    }

    /* access modifiers changed from: protected */
    public int arrayGetBytes(long j2, long j3, int i2, int i3, byte[] bArr) {
        AppMethodBeat.i(61956);
        int _arrayGetBytes = _arrayGetBytes(j2, j3, i2, i3, bArr);
        AppMethodBeat.o(61956);
        return _arrayGetBytes;
    }

    /* access modifiers changed from: protected */
    public int arrayGetStrings(long j2, long j3, int i2, int i3, String[] strArr) {
        AppMethodBeat.i(61957);
        int _arrayGetStrings = _arrayGetStrings(j2, j3, i2, i3, strArr);
        AppMethodBeat.o(61957);
        return _arrayGetStrings;
    }

    /* access modifiers changed from: protected */
    public void terminateExecution(long j2) {
        AppMethodBeat.i(61958);
        _terminateExecution(j2);
        AppMethodBeat.o(61958);
    }

    /* access modifiers changed from: protected */
    public void releaseMethodDescriptor(long j2, long j3) {
        AppMethodBeat.i(61959);
        _releaseMethodDescriptor(j2, j3);
        AppMethodBeat.o(61959);
    }

    /* access modifiers changed from: protected */
    public long getIsolatePtr() {
        AppMethodBeat.i(61960);
        long _getIsolatePtr = _getIsolatePtr(this.v8RuntimePtr);
        AppMethodBeat.o(61960);
        return _getIsolatePtr;
    }

    /* access modifiers changed from: protected */
    public long getUVLoopPtr() {
        AppMethodBeat.i(61961);
        long _getUVLoopPtr = _getUVLoopPtr(this.v8RuntimePtr);
        AppMethodBeat.o(61961);
        return _getUVLoopPtr;
    }

    /* access modifiers changed from: package-private */
    public void addObjRef(V8Value v8Value) {
        AppMethodBeat.i(61962);
        this.objectReferences++;
        if (!this.referenceHandlers.isEmpty()) {
            notifyReferenceCreated(v8Value);
        }
        AppMethodBeat.o(61962);
    }

    /* access modifiers changed from: package-private */
    public void releaseObjRef(V8Value v8Value) {
        AppMethodBeat.i(61963);
        if (!this.referenceHandlers.isEmpty()) {
            notifyReferenceDisposed(v8Value);
        }
        this.objectReferences--;
        AppMethodBeat.o(61963);
    }

    public static void setLoadLibraryDelegate(ILoadLibraryDelegate iLoadLibraryDelegate) {
        AppMethodBeat.i(61964);
        if (iLoadLibraryDelegate == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("setLoadLibraryDelegate: param delegate null");
            AppMethodBeat.o(61964);
            throw illegalArgumentException;
        }
        sLoadLibraryDelegate = iLoadLibraryDelegate;
        AppMethodBeat.o(61964);
    }

    public String executeDebugScript(String str, String str2) {
        AppMethodBeat.i(61965);
        checkThread();
        checkScript(str);
        String _executeDebugScript = _executeDebugScript(this.v8RuntimePtr, str, str2);
        AppMethodBeat.o(61965);
        return _executeDebugScript;
    }

    public void waitForDebugger(String str) {
        AppMethodBeat.i(61966);
        checkThread();
        _waitForDebuger(this.v8RuntimePtr, str);
        AppMethodBeat.o(61966);
    }

    public void debuggerMessageLoop() {
        AppMethodBeat.i(61967);
        checkThread();
        _debugMessageLoop(this.v8RuntimePtr);
        AppMethodBeat.o(61967);
    }

    public void nativeMessageLoop() {
        AppMethodBeat.i(194296);
        _nativeMessageLoop(this.v8RuntimePtr);
        AppMethodBeat.o(194296);
    }

    public void nativeDispatch() {
        AppMethodBeat.i(194297);
        _nativeDispatch(this.v8RuntimePtr);
        AppMethodBeat.o(194297);
    }

    public void nativeLoopStop() {
        AppMethodBeat.i(194298);
        _nativeLoopStop(this.v8RuntimePtr);
        AppMethodBeat.o(194298);
    }

    public void setNativeJavaCallback(Runnable runnable) {
        this.nativeJavaCallback_ = runnable;
    }

    /* access modifiers changed from: protected */
    public void onNativeRunJavaTask() {
        AppMethodBeat.i(194299);
        if (this.nativeJavaCallback_ != null) {
            this.nativeJavaCallback_.run();
        }
        AppMethodBeat.o(194299);
    }

    public void setJavaTaskScheduler(JavaTaskScheduler javaTaskScheduler) {
        AppMethodBeat.i(194300);
        this._javaTaskScheduler = javaTaskScheduler;
        _nativeTransSetJavaSchedule(1);
        AppMethodBeat.o(194300);
    }

    /* access modifiers changed from: protected */
    public void onNativeTransMsgDispatchByJava() {
        AppMethodBeat.i(194301);
        if (this._javaTaskScheduler != null) {
            this._javaTaskScheduler.Schedule(new Runnable() {
                /* class com.eclipsesource.v8.V8.AnonymousClass2 */

                public void run() {
                    AppMethodBeat.i(194294);
                    V8.access$200(V8.this.v8RuntimePtr);
                    AppMethodBeat.o(194294);
                }
            });
        }
        AppMethodBeat.o(194301);
    }

    public void enableNativeTrans() {
        AppMethodBeat.i(194302);
        _enableNativeTrans(this.v8RuntimePtr);
        AppMethodBeat.o(194302);
    }

    public static long getNativeTransManager() {
        AppMethodBeat.i(194303);
        long _getNativeTransManager = _getNativeTransManager();
        AppMethodBeat.o(194303);
        return _getNativeTransManager;
    }

    public static void postMessage(int i2, String str) {
        AppMethodBeat.i(194304);
        _nativeTransPostMessage(i2, str);
        AppMethodBeat.o(194304);
    }

    public static void broadcastMessage(int i2, String str) {
        AppMethodBeat.i(194305);
        _nativeTransBroadcastMessage(i2, str);
        AppMethodBeat.o(194305);
    }
}
