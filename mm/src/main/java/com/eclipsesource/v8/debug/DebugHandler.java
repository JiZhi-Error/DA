package com.eclipsesource.v8.debug;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8Value;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class DebugHandler implements Releasable {
    private static final String CHANGE_BREAK_POINT_CONDITION = "changeBreakPointCondition";
    private static final String CLEAR_BREAK_POINT = "clearBreakPoint";
    private static final String DEBUG_BREAK_HANDLER = "__j2v8_debug_handler";
    public static String DEBUG_OBJECT_NAME = "__j2v8_Debug";
    private static final String DISABLE_ALL_BREAK_POINTS = "disableAllBreakPoints";
    private static final String DISABLE_SCRIPT_BREAK_POINT = "disableScriptBreakPoint";
    private static final String ENABLE_SCRIPT_BREAK_POINT = "enableScriptBreakPoint";
    private static final String FIND_SCRIPT_BREAK_POINT = "findScriptBreakPoint";
    private static final String NUMBER = "number";
    private static final String SCRIPT_BREAK_POINTS = "scriptBreakPoints";
    private static final String SET_BREAK_POINT = "setBreakPoint";
    private static final String SET_LISTENER = "setListener";
    private static final String SET_SCRIPT_BREAK_POINT_BY_NAME = "setScriptBreakPointByName";
    private static final String V8_DEBUG_OBJECT = "Debug";
    private List<BreakHandler> breakHandlers = new ArrayList();
    private V8Object debugObject;
    private V8 runtime;

    public enum DebugEvent {
        Undefined(0),
        Break(1),
        Exception(2),
        NewFunction(3),
        BeforeCompile(4),
        AfterCompile(5),
        CompileError(6),
        PromiseError(7),
        AsyncTaskEvent(8);
        
        int index;

        public static DebugEvent valueOf(String str) {
            AppMethodBeat.i(61454);
            DebugEvent debugEvent = (DebugEvent) Enum.valueOf(DebugEvent.class, str);
            AppMethodBeat.o(61454);
            return debugEvent;
        }

        static {
            AppMethodBeat.i(61455);
            AppMethodBeat.o(61455);
        }

        private DebugEvent(int i2) {
            this.index = i2;
        }
    }

    public DebugHandler(V8 v8) {
        AppMethodBeat.i(61456);
        this.runtime = v8;
        setupDebugObject(v8);
        setupBreakpointHandler();
        AppMethodBeat.o(61456);
    }

    public void addBreakHandler(BreakHandler breakHandler) {
        AppMethodBeat.i(61457);
        this.runtime.getLocker().checkThread();
        this.breakHandlers.add(breakHandler);
        AppMethodBeat.o(61457);
    }

    public void removeBreakHandler(BreakHandler breakHandler) {
        AppMethodBeat.i(61458);
        this.runtime.getLocker().checkThread();
        this.breakHandlers.remove(breakHandler);
        AppMethodBeat.o(61458);
    }

    public int setBreakpoint(V8Function v8Function) {
        AppMethodBeat.i(61459);
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push((V8Value) v8Function);
        try {
            return this.debugObject.executeIntegerFunction(SET_BREAK_POINT, v8Array);
        } finally {
            v8Array.release();
            AppMethodBeat.o(61459);
        }
    }

    public int setScriptBreakpoint(String str, int i2) {
        AppMethodBeat.i(61460);
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(str);
        v8Array.push(i2);
        try {
            return this.debugObject.executeIntegerFunction(SET_SCRIPT_BREAK_POINT_BY_NAME, v8Array);
        } finally {
            v8Array.release();
            AppMethodBeat.o(61460);
        }
    }

    public void enableScriptBreakPoint(int i2) {
        AppMethodBeat.i(61461);
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i2);
        try {
            this.debugObject.executeVoidFunction(ENABLE_SCRIPT_BREAK_POINT, v8Array);
        } finally {
            v8Array.release();
            AppMethodBeat.o(61461);
        }
    }

    public void disableScriptBreakPoint(int i2) {
        AppMethodBeat.i(61462);
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i2);
        try {
            this.debugObject.executeVoidFunction(DISABLE_SCRIPT_BREAK_POINT, v8Array);
        } finally {
            v8Array.release();
            AppMethodBeat.o(61462);
        }
    }

    public void clearBreakPoint(int i2) {
        AppMethodBeat.i(61463);
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i2);
        try {
            this.debugObject.executeVoidFunction(CLEAR_BREAK_POINT, v8Array);
        } finally {
            v8Array.release();
            AppMethodBeat.o(61463);
        }
    }

    public void disableAllBreakPoints() {
        AppMethodBeat.i(61464);
        this.debugObject.executeVoidFunction(DISABLE_ALL_BREAK_POINTS, null);
        AppMethodBeat.o(61464);
    }

    public int getScriptBreakPointCount() {
        AppMethodBeat.i(61465);
        V8Array executeArrayFunction = this.debugObject.executeArrayFunction(SCRIPT_BREAK_POINTS, null);
        try {
            return executeArrayFunction.length();
        } finally {
            executeArrayFunction.release();
            AppMethodBeat.o(61465);
        }
    }

    public int[] getScriptBreakPointIDs() {
        AppMethodBeat.i(61466);
        V8Array executeArrayFunction = this.debugObject.executeArrayFunction(SCRIPT_BREAK_POINTS, null);
        try {
            int[] iArr = new int[executeArrayFunction.length()];
            for (int i2 = 0; i2 < executeArrayFunction.length(); i2++) {
                V8Object object = executeArrayFunction.getObject(i2);
                try {
                    iArr[i2] = object.executeIntegerFunction(NUMBER, null);
                    object.release();
                } catch (Throwable th) {
                    object.release();
                    AppMethodBeat.o(61466);
                    throw th;
                }
            }
            return iArr;
        } finally {
            executeArrayFunction.release();
            AppMethodBeat.o(61466);
        }
    }

    public ScriptBreakPoint getScriptBreakPoint(int i2) {
        AppMethodBeat.i(61467);
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i2);
        v8Array.push(false);
        V8Object v8Object = null;
        try {
            v8Object = this.debugObject.executeObjectFunction(FIND_SCRIPT_BREAK_POINT, v8Array);
            return new ScriptBreakPoint(v8Object);
        } finally {
            v8Array.release();
            if (v8Object != null) {
                v8Object.release();
            }
            AppMethodBeat.o(61467);
        }
    }

    public void changeBreakPointCondition(int i2, String str) {
        AppMethodBeat.i(61468);
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i2);
        v8Array.push(str);
        try {
            this.debugObject.executeVoidFunction(CHANGE_BREAK_POINT_CONDITION, v8Array);
        } finally {
            v8Array.release();
            AppMethodBeat.o(61468);
        }
    }

    @Override // com.eclipsesource.v8.Releasable
    public void release() {
        AppMethodBeat.i(61469);
        this.debugObject.release();
        AppMethodBeat.o(61469);
    }

    private void setupDebugObject(V8 v8) {
        AppMethodBeat.i(61470);
        V8Object object = v8.getObject(DEBUG_OBJECT_NAME);
        try {
            this.debugObject = object.getObject(V8_DEBUG_OBJECT);
        } finally {
            object.release();
            AppMethodBeat.o(61470);
        }
    }

    private void setupBreakpointHandler() {
        V8Function v8Function;
        V8Array v8Array;
        Throwable th;
        AppMethodBeat.i(61471);
        this.debugObject.registerJavaMethod(new BreakpointHandler(), DEBUG_BREAK_HANDLER);
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
                AppMethodBeat.o(61471);
                throw th;
            }
            try {
                this.debugObject.executeFunction(SET_LISTENER, v8Array);
                if (v8Function2 != null && !v8Function2.isReleased()) {
                    v8Function2.release();
                }
                if (v8Array == null || v8Array.isReleased()) {
                    AppMethodBeat.o(61471);
                    return;
                }
                v8Array.release();
                AppMethodBeat.o(61471);
            } catch (Throwable th3) {
                th = th3;
                v8Function = v8Function2;
                if (v8Function != null && !v8Function.isReleased()) {
                    v8Function.release();
                }
                if (v8Array != null && !v8Array.isReleased()) {
                    v8Array.release();
                }
                AppMethodBeat.o(61471);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            v8Array = null;
            v8Function = null;
            v8Function.release();
            v8Array.release();
            AppMethodBeat.o(61471);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public class BreakpointHandler implements JavaVoidCallback {
        private BreakpointHandler() {
        }

        @Override // com.eclipsesource.v8.JavaVoidCallback
        public void invoke(V8Object v8Object, V8Array v8Array) {
            AppMethodBeat.i(61449);
            if (v8Array == null || v8Array.isUndefined()) {
                AppMethodBeat.o(61449);
                return;
            }
            int integer = v8Array.getInteger(0);
            for (BreakHandler breakHandler : DebugHandler.this.breakHandlers) {
                invokeHandler(v8Array, integer, breakHandler);
            }
            AppMethodBeat.o(61449);
        }

        private void invokeHandler(V8Array v8Array, int i2, BreakHandler breakHandler) {
            V8Object v8Object;
            V8Object v8Object2;
            V8Object v8Object3;
            ExecutionState executionState;
            EventData eventData;
            Throwable th;
            AppMethodBeat.i(61450);
            try {
                v8Object = v8Array.getObject(1);
                try {
                    v8Object2 = v8Array.getObject(2);
                } catch (Throwable th2) {
                    th = th2;
                    eventData = null;
                    executionState = null;
                    v8Object3 = null;
                    v8Object2 = null;
                    safeRelease(v8Object);
                    safeRelease(v8Object2);
                    safeRelease(v8Object3);
                    safeRelease(executionState);
                    safeRelease(eventData);
                    AppMethodBeat.o(61450);
                    throw th;
                }
                try {
                    v8Object3 = v8Array.getObject(3);
                    try {
                        executionState = new ExecutionState(v8Object);
                    } catch (Throwable th3) {
                        th = th3;
                        eventData = null;
                        executionState = null;
                        safeRelease(v8Object);
                        safeRelease(v8Object2);
                        safeRelease(v8Object3);
                        safeRelease(executionState);
                        safeRelease(eventData);
                        AppMethodBeat.o(61450);
                        throw th;
                    }
                    try {
                        DebugEvent debugEvent = DebugEvent.values()[i2];
                        eventData = createDebugEvent(debugEvent, v8Object2);
                        try {
                            breakHandler.onBreak(debugEvent, executionState, eventData, v8Object3);
                            safeRelease(v8Object);
                            safeRelease(v8Object2);
                            safeRelease(v8Object3);
                            safeRelease(executionState);
                            safeRelease(eventData);
                            AppMethodBeat.o(61450);
                        } catch (Throwable th4) {
                            th = th4;
                            safeRelease(v8Object);
                            safeRelease(v8Object2);
                            safeRelease(v8Object3);
                            safeRelease(executionState);
                            safeRelease(eventData);
                            AppMethodBeat.o(61450);
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        eventData = null;
                        safeRelease(v8Object);
                        safeRelease(v8Object2);
                        safeRelease(v8Object3);
                        safeRelease(executionState);
                        safeRelease(eventData);
                        AppMethodBeat.o(61450);
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    eventData = null;
                    executionState = null;
                    v8Object3 = null;
                    safeRelease(v8Object);
                    safeRelease(v8Object2);
                    safeRelease(v8Object3);
                    safeRelease(executionState);
                    safeRelease(eventData);
                    AppMethodBeat.o(61450);
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                eventData = null;
                executionState = null;
                v8Object3 = null;
                v8Object2 = null;
                v8Object = null;
                safeRelease(v8Object);
                safeRelease(v8Object2);
                safeRelease(v8Object3);
                safeRelease(executionState);
                safeRelease(eventData);
                AppMethodBeat.o(61450);
                throw th;
            }
        }

        private EventData createDebugEvent(DebugEvent debugEvent, V8Object v8Object) {
            AppMethodBeat.i(61451);
            switch (debugEvent) {
                case Break:
                    BreakEvent breakEvent = new BreakEvent(v8Object);
                    AppMethodBeat.o(61451);
                    return breakEvent;
                case BeforeCompile:
                    CompileEvent compileEvent = new CompileEvent(v8Object);
                    AppMethodBeat.o(61451);
                    return compileEvent;
                case AfterCompile:
                    CompileEvent compileEvent2 = new CompileEvent(v8Object);
                    AppMethodBeat.o(61451);
                    return compileEvent2;
                case Exception:
                    ExceptionEvent exceptionEvent = new ExceptionEvent(v8Object);
                    AppMethodBeat.o(61451);
                    return exceptionEvent;
                default:
                    EventData eventData = new EventData(v8Object);
                    AppMethodBeat.o(61451);
                    return eventData;
            }
        }

        private void safeRelease(Releasable releasable) {
            AppMethodBeat.i(61452);
            if (releasable != null) {
                releasable.release();
            }
            AppMethodBeat.o(61452);
        }
    }
}
