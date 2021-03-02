package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8ArrayBuffer;
import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8TypedArray;
import com.eclipsesource.v8.V8Value;
import com.eclipsesource.v8.utils.typedarrays.ArrayBuffer;
import com.eclipsesource.v8.utils.typedarrays.Float32Array;
import com.eclipsesource.v8.utils.typedarrays.Float64Array;
import com.eclipsesource.v8.utils.typedarrays.Int16Array;
import com.eclipsesource.v8.utils.typedarrays.Int32Array;
import com.eclipsesource.v8.utils.typedarrays.Int8Array;
import com.eclipsesource.v8.utils.typedarrays.TypedArray;
import com.eclipsesource.v8.utils.typedarrays.UInt16Array;
import com.eclipsesource.v8.utils.typedarrays.UInt32Array;
import com.eclipsesource.v8.utils.typedarrays.UInt8Array;
import com.eclipsesource.v8.utils.typedarrays.UInt8ClampedArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class V8ObjectUtils {
    private static final TypeAdapter DEFAULT_TYPE_ADAPTER = new DefaultTypeAdapter();
    private static final Object IGNORE = new Object();

    static {
        AppMethodBeat.i(61768);
        AppMethodBeat.o(61768);
    }

    public static Object getValue(Object obj) {
        AppMethodBeat.i(61730);
        Object value = getValue(obj, DEFAULT_TYPE_ADAPTER);
        AppMethodBeat.o(61730);
        return value;
    }

    public static Object getValue(Object obj, TypeAdapter typeAdapter) {
        AppMethodBeat.i(61731);
        V8Map v8Map = new V8Map();
        try {
            if (obj instanceof V8Value) {
                obj = getValue(obj, ((V8Value) obj).getV8Type(), v8Map, typeAdapter);
            } else {
                v8Map.release();
                AppMethodBeat.o(61731);
            }
            return obj;
        } finally {
            v8Map.release();
            AppMethodBeat.o(61731);
        }
    }

    public static Map<String, ? super Object> toMap(V8Object v8Object) {
        AppMethodBeat.i(61732);
        Map<String, ? super Object> map = toMap(v8Object, DEFAULT_TYPE_ADAPTER);
        AppMethodBeat.o(61732);
        return map;
    }

    public static Map<String, ? super Object> toMap(V8Object v8Object, TypeAdapter typeAdapter) {
        AppMethodBeat.i(61733);
        V8Map v8Map = new V8Map();
        try {
            return toMap(v8Object, v8Map, typeAdapter);
        } finally {
            v8Map.release();
            AppMethodBeat.o(61733);
        }
    }

    public static List<? super Object> toList(V8Array v8Array) {
        AppMethodBeat.i(61734);
        List<? super Object> list = toList(v8Array, DEFAULT_TYPE_ADAPTER);
        AppMethodBeat.o(61734);
        return list;
    }

    public static List<? super Object> toList(V8Array v8Array, TypeAdapter typeAdapter) {
        AppMethodBeat.i(61735);
        V8Map v8Map = new V8Map();
        try {
            return toList(v8Array, v8Map, typeAdapter);
        } finally {
            v8Map.release();
            AppMethodBeat.o(61735);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v14, resolved type: double[] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v16, resolved type: double[] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v19, resolved type: int[] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v21, resolved type: int[] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        if (r1 < r0) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003f, code lost:
        if (r1 < r0) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0054, code lost:
        if (r1 < r0) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x006a, code lost:
        if (r1 < r0) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0015, code lost:
        if (r1 < r0) goto L_0x0017;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object getTypedArray(com.eclipsesource.v8.V8Array r4, int r5, java.lang.Object r6) {
        /*
        // Method dump skipped, instructions count: 137
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eclipsesource.v8.utils.V8ObjectUtils.getTypedArray(com.eclipsesource.v8.V8Array, int, java.lang.Object):java.lang.Object");
    }

    public static Object getTypedArray(V8Array v8Array, int i2) {
        AppMethodBeat.i(61737);
        int length = v8Array.length();
        if (i2 == 1) {
            int[] integers = v8Array.getIntegers(0, length);
            AppMethodBeat.o(61737);
            return integers;
        } else if (i2 == 2) {
            double[] doubles = v8Array.getDoubles(0, length);
            AppMethodBeat.o(61737);
            return doubles;
        } else if (i2 == 3) {
            boolean[] booleans = v8Array.getBooleans(0, length);
            AppMethodBeat.o(61737);
            return booleans;
        } else if (i2 == 4) {
            String[] strings = v8Array.getStrings(0, length);
            AppMethodBeat.o(61737);
            return strings;
        } else {
            RuntimeException runtimeException = new RuntimeException("Unsupported bulk load type: ".concat(String.valueOf(i2)));
            AppMethodBeat.o(61737);
            throw runtimeException;
        }
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:303)
        	at jadx.core.dex.instructions.InvokeNode.isSame(InvokeNode.java:77)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    public static com.eclipsesource.v8.V8Object toV8Object(com.eclipsesource.v8.V8 r4, java.util.Map<java.lang.String, ? extends java.lang.Object> r5) {
        /*
            r3 = 61738(0xf12a, float:8.6513E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            java.util.Hashtable r2 = new java.util.Hashtable
            r2.<init>()
            com.eclipsesource.v8.V8Object r0 = toV8Object(r4, r5, r2)     // Catch:{ all -> 0x002f }
            com.eclipsesource.v8.V8Object r1 = r0.twin()     // Catch:{ all -> 0x002f }
            java.util.Collection r0 = r2.values()
            java.util.Iterator r2 = r0.iterator()
        L_0x001b:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x002b
            java.lang.Object r0 = r2.next()
            com.eclipsesource.v8.V8Value r0 = (com.eclipsesource.v8.V8Value) r0
            r0.release()
            goto L_0x001b
        L_0x002b:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            return r1
        L_0x002f:
            r0 = move-exception
            r1 = r0
            java.util.Collection r0 = r2.values()
            java.util.Iterator r2 = r0.iterator()
        L_0x0039:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0049
            java.lang.Object r0 = r2.next()
            com.eclipsesource.v8.V8Value r0 = (com.eclipsesource.v8.V8Value) r0
            r0.release()
            goto L_0x0039
        L_0x0049:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eclipsesource.v8.utils.V8ObjectUtils.toV8Object(com.eclipsesource.v8.V8, java.util.Map):com.eclipsesource.v8.V8Object");
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:303)
        	at jadx.core.dex.instructions.InvokeNode.isSame(InvokeNode.java:77)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    public static com.eclipsesource.v8.V8Object toV8Object(com.eclipsesource.v8.V8Context r4, java.util.Map<java.lang.String, ? extends java.lang.Object> r5) {
        /*
            r3 = 61739(0xf12b, float:8.6515E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            java.util.Hashtable r2 = new java.util.Hashtable
            r2.<init>()
            com.eclipsesource.v8.V8Object r0 = toV8Object(r4, r5, r2)     // Catch:{ all -> 0x002f }
            com.eclipsesource.v8.V8Object r1 = r0.twin()     // Catch:{ all -> 0x002f }
            java.util.Collection r0 = r2.values()
            java.util.Iterator r2 = r0.iterator()
        L_0x001b:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x002b
            java.lang.Object r0 = r2.next()
            com.eclipsesource.v8.V8Value r0 = (com.eclipsesource.v8.V8Value) r0
            r0.release()
            goto L_0x001b
        L_0x002b:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            return r1
        L_0x002f:
            r0 = move-exception
            r1 = r0
            java.util.Collection r0 = r2.values()
            java.util.Iterator r2 = r0.iterator()
        L_0x0039:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0049
            java.lang.Object r0 = r2.next()
            com.eclipsesource.v8.V8Value r0 = (com.eclipsesource.v8.V8Value) r0
            r0.release()
            goto L_0x0039
        L_0x0049:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eclipsesource.v8.utils.V8ObjectUtils.toV8Object(com.eclipsesource.v8.V8Context, java.util.Map):com.eclipsesource.v8.V8Object");
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:303)
        	at jadx.core.dex.instructions.InvokeNode.isSame(InvokeNode.java:77)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    public static com.eclipsesource.v8.V8Array toV8Array(com.eclipsesource.v8.V8 r4, java.util.List<? extends java.lang.Object> r5) {
        /*
            r3 = 61740(0xf12c, float:8.6516E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            java.util.Hashtable r2 = new java.util.Hashtable
            r2.<init>()
            com.eclipsesource.v8.V8Array r0 = toV8Array(r4, r5, r2)     // Catch:{ all -> 0x002f }
            com.eclipsesource.v8.V8Array r1 = r0.twin()     // Catch:{ all -> 0x002f }
            java.util.Collection r0 = r2.values()
            java.util.Iterator r2 = r0.iterator()
        L_0x001b:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x002b
            java.lang.Object r0 = r2.next()
            com.eclipsesource.v8.V8Value r0 = (com.eclipsesource.v8.V8Value) r0
            r0.release()
            goto L_0x001b
        L_0x002b:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            return r1
        L_0x002f:
            r0 = move-exception
            r1 = r0
            java.util.Collection r0 = r2.values()
            java.util.Iterator r2 = r0.iterator()
        L_0x0039:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0049
            java.lang.Object r0 = r2.next()
            com.eclipsesource.v8.V8Value r0 = (com.eclipsesource.v8.V8Value) r0
            r0.release()
            goto L_0x0039
        L_0x0049:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eclipsesource.v8.utils.V8ObjectUtils.toV8Array(com.eclipsesource.v8.V8, java.util.List):com.eclipsesource.v8.V8Array");
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:303)
        	at jadx.core.dex.instructions.InvokeNode.isSame(InvokeNode.java:77)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    public static com.eclipsesource.v8.V8Array toV8Array(com.eclipsesource.v8.V8Context r4, java.util.List<? extends java.lang.Object> r5) {
        /*
            r3 = 61741(0xf12d, float:8.6518E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            java.util.Hashtable r2 = new java.util.Hashtable
            r2.<init>()
            com.eclipsesource.v8.V8Array r0 = toV8Array(r4, r5, r2)     // Catch:{ all -> 0x002f }
            com.eclipsesource.v8.V8Array r1 = r0.twin()     // Catch:{ all -> 0x002f }
            java.util.Collection r0 = r2.values()
            java.util.Iterator r2 = r0.iterator()
        L_0x001b:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x002b
            java.lang.Object r0 = r2.next()
            com.eclipsesource.v8.V8Value r0 = (com.eclipsesource.v8.V8Value) r0
            r0.release()
            goto L_0x001b
        L_0x002b:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            return r1
        L_0x002f:
            r0 = move-exception
            r1 = r0
            java.util.Collection r0 = r2.values()
            java.util.Iterator r2 = r0.iterator()
        L_0x0039:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0049
            java.lang.Object r0 = r2.next()
            com.eclipsesource.v8.V8Value r0 = (com.eclipsesource.v8.V8Value) r0
            r0.release()
            goto L_0x0039
        L_0x0049:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eclipsesource.v8.utils.V8ObjectUtils.toV8Array(com.eclipsesource.v8.V8Context, java.util.List):com.eclipsesource.v8.V8Array");
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:303)
        	at jadx.core.dex.instructions.InvokeNode.isSame(InvokeNode.java:77)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    public static java.lang.Object getV8Result(com.eclipsesource.v8.V8 r4, java.lang.Object r5) {
        /*
        // Method dump skipped, instructions count: 119
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eclipsesource.v8.utils.V8ObjectUtils.getV8Result(com.eclipsesource.v8.V8, java.lang.Object):java.lang.Object");
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:303)
        	at jadx.core.dex.instructions.InvokeNode.isSame(InvokeNode.java:77)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    public static java.lang.Object getV8Result(com.eclipsesource.v8.V8Context r4, java.lang.Object r5) {
        /*
        // Method dump skipped, instructions count: 119
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eclipsesource.v8.utils.V8ObjectUtils.getV8Result(com.eclipsesource.v8.V8Context, java.lang.Object):java.lang.Object");
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:303)
        	at jadx.core.dex.instructions.InvokeNode.isSame(InvokeNode.java:77)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    public static void pushValue(com.eclipsesource.v8.V8 r4, com.eclipsesource.v8.V8Array r5, java.lang.Object r6) {
        /*
            r3 = 61744(0xf130, float:8.6522E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            java.util.Hashtable r0 = new java.util.Hashtable
            r0.<init>()
            pushValue(r4, r5, r6, r0)     // Catch:{ all -> 0x002a }
            java.util.Collection r0 = r0.values()
            java.util.Iterator r1 = r0.iterator()
        L_0x0016:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x0026
            java.lang.Object r0 = r1.next()
            com.eclipsesource.v8.V8Value r0 = (com.eclipsesource.v8.V8Value) r0
            r0.release()
            goto L_0x0016
        L_0x0026:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            return
        L_0x002a:
            r1 = move-exception
            java.util.Collection r0 = r0.values()
            java.util.Iterator r2 = r0.iterator()
        L_0x0033:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0043
            java.lang.Object r0 = r2.next()
            com.eclipsesource.v8.V8Value r0 = (com.eclipsesource.v8.V8Value) r0
            r0.release()
            goto L_0x0033
        L_0x0043:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eclipsesource.v8.utils.V8ObjectUtils.pushValue(com.eclipsesource.v8.V8, com.eclipsesource.v8.V8Array, java.lang.Object):void");
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:303)
        	at jadx.core.dex.instructions.InvokeNode.isSame(InvokeNode.java:77)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    public static void pushValue(com.eclipsesource.v8.V8Context r4, com.eclipsesource.v8.V8Array r5, java.lang.Object r6) {
        /*
            r3 = 61745(0xf131, float:8.6523E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            java.util.Hashtable r0 = new java.util.Hashtable
            r0.<init>()
            pushValue(r4, r5, r6, r0)     // Catch:{ all -> 0x002a }
            java.util.Collection r0 = r0.values()
            java.util.Iterator r1 = r0.iterator()
        L_0x0016:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x0026
            java.lang.Object r0 = r1.next()
            com.eclipsesource.v8.V8Value r0 = (com.eclipsesource.v8.V8Value) r0
            r0.release()
            goto L_0x0016
        L_0x0026:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            return
        L_0x002a:
            r1 = move-exception
            java.util.Collection r0 = r0.values()
            java.util.Iterator r2 = r0.iterator()
        L_0x0033:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0043
            java.lang.Object r0 = r2.next()
            com.eclipsesource.v8.V8Value r0 = (com.eclipsesource.v8.V8Value) r0
            r0.release()
            goto L_0x0033
        L_0x0043:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eclipsesource.v8.utils.V8ObjectUtils.pushValue(com.eclipsesource.v8.V8Context, com.eclipsesource.v8.V8Array, java.lang.Object):void");
    }

    public static Object getValue(V8Array v8Array, int i2) {
        AppMethodBeat.i(61746);
        V8Map v8Map = new V8Map();
        Object obj = null;
        try {
            obj = v8Array.get(i2);
            return getValue(obj, v8Array.getType(i2), v8Map, DEFAULT_TYPE_ADAPTER);
        } finally {
            if (obj instanceof Releasable) {
                ((Releasable) obj).release();
            }
            v8Map.release();
            AppMethodBeat.o(61746);
        }
    }

    public static Object getValue(V8Array v8Array, int i2, TypeAdapter typeAdapter) {
        AppMethodBeat.i(61747);
        V8Map v8Map = new V8Map();
        Object obj = null;
        try {
            obj = v8Array.get(i2);
            return getValue(obj, v8Array.getType(i2), v8Map, typeAdapter);
        } finally {
            if (obj instanceof Releasable) {
                ((Releasable) obj).release();
            }
            v8Map.release();
            AppMethodBeat.o(61747);
        }
    }

    public static Object getValue(V8Object v8Object, String str) {
        AppMethodBeat.i(61748);
        Object value = getValue(v8Object, str, DEFAULT_TYPE_ADAPTER);
        AppMethodBeat.o(61748);
        return value;
    }

    public static Object getValue(V8Object v8Object, String str, TypeAdapter typeAdapter) {
        AppMethodBeat.i(61749);
        V8Map v8Map = new V8Map();
        Object obj = null;
        try {
            obj = v8Object.get(str);
            return getValue(obj, v8Object.getType(str), v8Map, typeAdapter);
        } finally {
            if (obj instanceof Releasable) {
                ((Releasable) obj).release();
            }
            v8Map.release();
            AppMethodBeat.o(61749);
        }
    }

    private static Map<String, ? super Object> toMap(V8Object v8Object, V8Map<Object> v8Map, TypeAdapter typeAdapter) {
        AppMethodBeat.i(61750);
        if (v8Object == null) {
            Map<String, ? super Object> emptyMap = Collections.emptyMap();
            AppMethodBeat.o(61750);
            return emptyMap;
        } else if (v8Map.containsKey(v8Object)) {
            Map<String, ? super Object> map = (Map) v8Map.get(v8Object);
            AppMethodBeat.o(61750);
            return map;
        } else {
            V8PropertyMap v8PropertyMap = new V8PropertyMap();
            v8Map.put((V8Value) v8Object, (Object) v8PropertyMap);
            String[] keys = v8Object.getKeys();
            for (String str : keys) {
                Object obj = null;
                try {
                    Object obj2 = v8Object.get(str);
                    Object value = getValue(obj2, v8Object.getType(str), v8Map, typeAdapter);
                    if (value != IGNORE) {
                        v8PropertyMap.put((Object) str, value);
                    }
                    if (obj2 instanceof Releasable) {
                        ((Releasable) obj2).release();
                    }
                } catch (Throwable th) {
                    if (obj instanceof Releasable) {
                        null.release();
                    }
                    AppMethodBeat.o(61750);
                    throw th;
                }
            }
            AppMethodBeat.o(61750);
            return v8PropertyMap;
        }
    }

    private static List<? super Object> toList(V8Array v8Array, V8Map<Object> v8Map, TypeAdapter typeAdapter) {
        AppMethodBeat.i(61751);
        if (v8Array == null) {
            List<? super Object> emptyList = Collections.emptyList();
            AppMethodBeat.o(61751);
            return emptyList;
        } else if (v8Map.containsKey(v8Array)) {
            List<? super Object> list = (List) v8Map.get(v8Array);
            AppMethodBeat.o(61751);
            return list;
        } else {
            ArrayList arrayList = new ArrayList();
            v8Map.put((V8Value) v8Array, (Object) arrayList);
            for (int i2 = 0; i2 < v8Array.length(); i2++) {
                Object obj = null;
                try {
                    Object obj2 = v8Array.get(i2);
                    Object value = getValue(obj2, v8Array.getType(i2), v8Map, typeAdapter);
                    if (value != IGNORE) {
                        arrayList.add(value);
                    }
                    if (obj2 instanceof Releasable) {
                        ((Releasable) obj2).release();
                    }
                } catch (Throwable th) {
                    if (obj instanceof Releasable) {
                        null.release();
                    }
                    AppMethodBeat.o(61751);
                    throw th;
                }
            }
            AppMethodBeat.o(61751);
            return arrayList;
        }
    }

    private static V8Object toV8Object(V8 v8, Map<String, ? extends Object> map, Map<Object, V8Value> map2) {
        AppMethodBeat.i(61752);
        if (map2.containsKey(map)) {
            V8Object v8Object = (V8Object) map2.get(map);
            AppMethodBeat.o(61752);
            return v8Object;
        }
        V8Object v8Object2 = new V8Object(v8);
        map2.put(map, v8Object2);
        try {
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                setValue(v8, v8Object2, entry.getKey(), entry.getValue(), map2);
            }
            AppMethodBeat.o(61752);
            return v8Object2;
        } catch (IllegalStateException e2) {
            v8Object2.release();
            AppMethodBeat.o(61752);
            throw e2;
        }
    }

    private static V8Object toV8Object(V8Context v8Context, Map<String, ? extends Object> map, Map<Object, V8Value> map2) {
        AppMethodBeat.i(61753);
        if (map2.containsKey(map)) {
            V8Object v8Object = (V8Object) map2.get(map);
            AppMethodBeat.o(61753);
            return v8Object;
        }
        V8Object newV8Object = v8Context.newV8Object();
        map2.put(map, newV8Object);
        try {
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                setValue(v8Context, newV8Object, entry.getKey(), entry.getValue(), map2);
            }
            AppMethodBeat.o(61753);
            return newV8Object;
        } catch (IllegalStateException e2) {
            newV8Object.release();
            AppMethodBeat.o(61753);
            throw e2;
        }
    }

    private static V8Array toV8Array(V8 v8, List<? extends Object> list, Map<Object, V8Value> map) {
        AppMethodBeat.i(61754);
        if (map.containsKey(new ListWrapper(list))) {
            V8Array v8Array = (V8Array) map.get(new ListWrapper(list));
            AppMethodBeat.o(61754);
            return v8Array;
        }
        V8Array v8Array2 = new V8Array(v8);
        map.put(new ListWrapper(list), v8Array2);
        for (int i2 = 0; i2 < list.size(); i2++) {
            try {
                pushValue(v8, v8Array2, list.get(i2), map);
            } catch (IllegalStateException e2) {
                v8Array2.release();
                AppMethodBeat.o(61754);
                throw e2;
            }
        }
        AppMethodBeat.o(61754);
        return v8Array2;
    }

    private static V8Array toV8Array(V8Context v8Context, List<? extends Object> list, Map<Object, V8Value> map) {
        AppMethodBeat.i(61755);
        if (map.containsKey(new ListWrapper(list))) {
            V8Array v8Array = (V8Array) map.get(new ListWrapper(list));
            AppMethodBeat.o(61755);
            return v8Array;
        }
        V8Array newV8Array = v8Context.newV8Array();
        map.put(new ListWrapper(list), newV8Array);
        for (int i2 = 0; i2 < list.size(); i2++) {
            try {
                pushValue(v8Context, newV8Array, list.get(i2), map);
            } catch (IllegalStateException e2) {
                newV8Array.release();
                AppMethodBeat.o(61755);
                throw e2;
            }
        }
        AppMethodBeat.o(61755);
        return newV8Array;
    }

    private static V8ArrayBuffer toV8ArrayBuffer(V8 v8, ArrayBuffer arrayBuffer, Map<Object, V8Value> map) {
        AppMethodBeat.i(61756);
        if (map.containsKey(arrayBuffer)) {
            V8ArrayBuffer v8ArrayBuffer = (V8ArrayBuffer) map.get(arrayBuffer);
            AppMethodBeat.o(61756);
            return v8ArrayBuffer;
        }
        V8ArrayBuffer v8ArrayBuffer2 = new V8ArrayBuffer(v8, arrayBuffer.getByteBuffer());
        map.put(arrayBuffer, v8ArrayBuffer2);
        AppMethodBeat.o(61756);
        return v8ArrayBuffer2;
    }

    private static V8ArrayBuffer toV8ArrayBuffer(V8Context v8Context, ArrayBuffer arrayBuffer, Map<Object, V8Value> map) {
        AppMethodBeat.i(61757);
        if (map.containsKey(arrayBuffer)) {
            V8ArrayBuffer v8ArrayBuffer = (V8ArrayBuffer) map.get(arrayBuffer);
            AppMethodBeat.o(61757);
            return v8ArrayBuffer;
        }
        V8ArrayBuffer newV8ArrayBuffer = v8Context.newV8ArrayBuffer(arrayBuffer.getByteBuffer());
        map.put(arrayBuffer, newV8ArrayBuffer);
        AppMethodBeat.o(61757);
        return newV8ArrayBuffer;
    }

    private static V8TypedArray toV8TypedArray(V8 v8, TypedArray typedArray, Map<Object, V8Value> map) {
        AppMethodBeat.i(61758);
        if (map.containsKey(typedArray)) {
            V8TypedArray v8TypedArray = (V8TypedArray) map.get(typedArray);
            AppMethodBeat.o(61758);
            return v8TypedArray;
        }
        V8ArrayBuffer v8ArrayBuffer = new V8ArrayBuffer(v8, typedArray.getByteBuffer());
        try {
            V8TypedArray v8TypedArray2 = new V8TypedArray(v8, v8ArrayBuffer, typedArray.getType(), 0, typedArray.length());
            map.put(typedArray, v8TypedArray2);
            return v8TypedArray2;
        } finally {
            v8ArrayBuffer.release();
            AppMethodBeat.o(61758);
        }
    }

    private static V8TypedArray toV8TypedArray(V8Context v8Context, TypedArray typedArray, Map<Object, V8Value> map) {
        AppMethodBeat.i(61759);
        if (map.containsKey(typedArray)) {
            V8TypedArray v8TypedArray = (V8TypedArray) map.get(typedArray);
            AppMethodBeat.o(61759);
            return v8TypedArray;
        }
        V8ArrayBuffer newV8ArrayBuffer = v8Context.newV8ArrayBuffer(typedArray.getByteBuffer());
        try {
            V8TypedArray newV8TypedArray = v8Context.newV8TypedArray(newV8ArrayBuffer, typedArray.getType(), 0, typedArray.length());
            map.put(typedArray, newV8TypedArray);
            return newV8TypedArray;
        } finally {
            newV8ArrayBuffer.release();
            AppMethodBeat.o(61759);
        }
    }

    private static Object getV8Result(V8 v8, Object obj, Map<Object, V8Value> map) {
        AppMethodBeat.i(61760);
        if (map.containsKey(obj)) {
            V8Value v8Value = map.get(obj);
            AppMethodBeat.o(61760);
            return v8Value;
        } else if (obj instanceof Map) {
            V8Object v8Object = toV8Object(v8, (Map) obj, map);
            AppMethodBeat.o(61760);
            return v8Object;
        } else if (obj instanceof List) {
            V8Array v8Array = toV8Array(v8, (List) obj, map);
            AppMethodBeat.o(61760);
            return v8Array;
        } else if (obj instanceof TypedArray) {
            V8TypedArray v8TypedArray = toV8TypedArray(v8, (TypedArray) obj, map);
            AppMethodBeat.o(61760);
            return v8TypedArray;
        } else if (obj instanceof ArrayBuffer) {
            V8ArrayBuffer v8ArrayBuffer = toV8ArrayBuffer(v8, (ArrayBuffer) obj, map);
            AppMethodBeat.o(61760);
            return v8ArrayBuffer;
        } else {
            AppMethodBeat.o(61760);
            return obj;
        }
    }

    private static Object getV8Result(V8Context v8Context, Object obj, Map<Object, V8Value> map) {
        AppMethodBeat.i(61761);
        if (map.containsKey(obj)) {
            V8Value v8Value = map.get(obj);
            AppMethodBeat.o(61761);
            return v8Value;
        } else if (obj instanceof Map) {
            V8Object v8Object = toV8Object(v8Context, (Map) obj, map);
            AppMethodBeat.o(61761);
            return v8Object;
        } else if (obj instanceof List) {
            V8Array v8Array = toV8Array(v8Context, (List) obj, map);
            AppMethodBeat.o(61761);
            return v8Array;
        } else if (obj instanceof TypedArray) {
            V8TypedArray v8TypedArray = toV8TypedArray(v8Context, (TypedArray) obj, map);
            AppMethodBeat.o(61761);
            return v8TypedArray;
        } else if (obj instanceof ArrayBuffer) {
            V8ArrayBuffer v8ArrayBuffer = toV8ArrayBuffer(v8Context, (ArrayBuffer) obj, map);
            AppMethodBeat.o(61761);
            return v8ArrayBuffer;
        } else {
            AppMethodBeat.o(61761);
            return obj;
        }
    }

    private static void pushValue(V8 v8, V8Array v8Array, Object obj, Map<Object, V8Value> map) {
        AppMethodBeat.i(61762);
        if (obj == null) {
            v8Array.pushUndefined();
            AppMethodBeat.o(61762);
        } else if (obj instanceof Integer) {
            v8Array.push(obj);
            AppMethodBeat.o(61762);
        } else if (obj instanceof Long) {
            v8Array.push(new Double((double) ((Long) obj).longValue()));
            AppMethodBeat.o(61762);
        } else if (obj instanceof Double) {
            v8Array.push(obj);
            AppMethodBeat.o(61762);
        } else if (obj instanceof Float) {
            v8Array.push(obj);
            AppMethodBeat.o(61762);
        } else if (obj instanceof String) {
            v8Array.push((String) obj);
            AppMethodBeat.o(61762);
        } else if (obj instanceof Boolean) {
            v8Array.push(obj);
            AppMethodBeat.o(61762);
        } else if (obj instanceof V8Object) {
            v8Array.push((V8Value) ((V8Object) obj));
            AppMethodBeat.o(61762);
        } else if (obj instanceof TypedArray) {
            v8Array.push((V8Value) toV8TypedArray(v8, (TypedArray) obj, map));
            AppMethodBeat.o(61762);
        } else if (obj instanceof ArrayBuffer) {
            v8Array.push((V8Value) toV8ArrayBuffer(v8, (ArrayBuffer) obj, map));
            AppMethodBeat.o(61762);
        } else if (obj instanceof Map) {
            v8Array.push((V8Value) toV8Object(v8, (Map) obj, map));
            AppMethodBeat.o(61762);
        } else if (obj instanceof List) {
            v8Array.push((V8Value) toV8Array(v8, (List) obj, map));
            AppMethodBeat.o(61762);
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("Unsupported Object of type: " + obj.getClass());
            AppMethodBeat.o(61762);
            throw illegalStateException;
        }
    }

    private static void pushValue(V8Context v8Context, V8Array v8Array, Object obj, Map<Object, V8Value> map) {
        AppMethodBeat.i(61763);
        if (obj == null) {
            v8Array.pushUndefined();
            AppMethodBeat.o(61763);
        } else if (obj instanceof Integer) {
            v8Array.push(obj);
            AppMethodBeat.o(61763);
        } else if (obj instanceof Long) {
            v8Array.push(new Double((double) ((Long) obj).longValue()));
            AppMethodBeat.o(61763);
        } else if (obj instanceof Double) {
            v8Array.push(obj);
            AppMethodBeat.o(61763);
        } else if (obj instanceof Float) {
            v8Array.push(obj);
            AppMethodBeat.o(61763);
        } else if (obj instanceof String) {
            v8Array.push((String) obj);
            AppMethodBeat.o(61763);
        } else if (obj instanceof Boolean) {
            v8Array.push(obj);
            AppMethodBeat.o(61763);
        } else if (obj instanceof V8Object) {
            v8Array.push((V8Value) ((V8Object) obj));
            AppMethodBeat.o(61763);
        } else if (obj instanceof TypedArray) {
            v8Array.push((V8Value) toV8TypedArray(v8Context, (TypedArray) obj, map));
            AppMethodBeat.o(61763);
        } else if (obj instanceof ArrayBuffer) {
            v8Array.push((V8Value) toV8ArrayBuffer(v8Context, (ArrayBuffer) obj, map));
            AppMethodBeat.o(61763);
        } else if (obj instanceof Map) {
            v8Array.push((V8Value) toV8Object(v8Context, (Map) obj, map));
            AppMethodBeat.o(61763);
        } else if (obj instanceof List) {
            v8Array.push((V8Value) toV8Array(v8Context, (List) obj, map));
            AppMethodBeat.o(61763);
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("Unsupported Object of type: " + obj.getClass());
            AppMethodBeat.o(61763);
            throw illegalStateException;
        }
    }

    private static void setValue(V8 v8, V8Object v8Object, String str, Object obj, Map<Object, V8Value> map) {
        AppMethodBeat.i(61764);
        if (obj == null) {
            v8Object.addUndefined(str);
            AppMethodBeat.o(61764);
        } else if (obj instanceof Integer) {
            v8Object.add(str, ((Integer) obj).intValue());
            AppMethodBeat.o(61764);
        } else if (obj instanceof Long) {
            v8Object.add(str, (double) ((Long) obj).longValue());
            AppMethodBeat.o(61764);
        } else if (obj instanceof Double) {
            v8Object.add(str, ((Double) obj).doubleValue());
            AppMethodBeat.o(61764);
        } else if (obj instanceof Float) {
            v8Object.add(str, (double) ((Float) obj).floatValue());
            AppMethodBeat.o(61764);
        } else if (obj instanceof String) {
            v8Object.add(str, (String) obj);
            AppMethodBeat.o(61764);
        } else if (obj instanceof Boolean) {
            v8Object.add(str, ((Boolean) obj).booleanValue());
            AppMethodBeat.o(61764);
        } else if (obj instanceof V8Object) {
            v8Object.add(str, (V8Object) obj);
            AppMethodBeat.o(61764);
        } else if (obj instanceof TypedArray) {
            v8Object.add(str, toV8TypedArray(v8, (TypedArray) obj, map));
            AppMethodBeat.o(61764);
        } else if (obj instanceof ArrayBuffer) {
            v8Object.add(str, toV8ArrayBuffer(v8, (ArrayBuffer) obj, map));
            AppMethodBeat.o(61764);
        } else if (obj instanceof Map) {
            v8Object.add(str, toV8Object(v8, (Map) obj, map));
            AppMethodBeat.o(61764);
        } else if (obj instanceof List) {
            v8Object.add(str, toV8Array(v8, (List) obj, map));
            AppMethodBeat.o(61764);
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("Unsupported Object of type: " + obj.getClass());
            AppMethodBeat.o(61764);
            throw illegalStateException;
        }
    }

    private static void setValue(V8Context v8Context, V8Object v8Object, String str, Object obj, Map<Object, V8Value> map) {
        AppMethodBeat.i(61765);
        if (obj == null) {
            v8Object.addUndefined(str);
            AppMethodBeat.o(61765);
        } else if (obj instanceof Integer) {
            v8Object.add(str, ((Integer) obj).intValue());
            AppMethodBeat.o(61765);
        } else if (obj instanceof Long) {
            v8Object.add(str, (double) ((Long) obj).longValue());
            AppMethodBeat.o(61765);
        } else if (obj instanceof Double) {
            v8Object.add(str, ((Double) obj).doubleValue());
            AppMethodBeat.o(61765);
        } else if (obj instanceof Float) {
            v8Object.add(str, (double) ((Float) obj).floatValue());
            AppMethodBeat.o(61765);
        } else if (obj instanceof String) {
            v8Object.add(str, (String) obj);
            AppMethodBeat.o(61765);
        } else if (obj instanceof Boolean) {
            v8Object.add(str, ((Boolean) obj).booleanValue());
            AppMethodBeat.o(61765);
        } else if (obj instanceof V8Object) {
            v8Object.add(str, (V8Object) obj);
            AppMethodBeat.o(61765);
        } else if (obj instanceof TypedArray) {
            v8Object.add(str, toV8TypedArray(v8Context, (TypedArray) obj, map));
            AppMethodBeat.o(61765);
        } else if (obj instanceof ArrayBuffer) {
            v8Object.add(str, toV8ArrayBuffer(v8Context, (ArrayBuffer) obj, map));
            AppMethodBeat.o(61765);
        } else if (obj instanceof Map) {
            v8Object.add(str, toV8Object(v8Context, (Map) obj, map));
            AppMethodBeat.o(61765);
        } else if (obj instanceof List) {
            v8Object.add(str, toV8Array(v8Context, (List) obj, map));
            AppMethodBeat.o(61765);
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("Unsupported Object of type: " + obj.getClass());
            AppMethodBeat.o(61765);
            throw illegalStateException;
        }
    }

    private static Object getValue(Object obj, int i2, V8Map<Object> v8Map, TypeAdapter typeAdapter) {
        AppMethodBeat.i(61766);
        Object adapt = typeAdapter.adapt(i2, obj);
        if (TypeAdapter.DEFAULT != adapt) {
            AppMethodBeat.o(61766);
            return adapt;
        }
        switch (i2) {
            case 0:
                AppMethodBeat.o(61766);
                return null;
            case 1:
            case 2:
            case 3:
            case 4:
                AppMethodBeat.o(61766);
                return obj;
            case 5:
                List<? super Object> list = toList((V8Array) obj, v8Map, typeAdapter);
                AppMethodBeat.o(61766);
                return list;
            case 6:
                Map<String, ? super Object> map = toMap((V8Object) obj, v8Map, typeAdapter);
                AppMethodBeat.o(61766);
                return map;
            case 7:
                Object obj2 = IGNORE;
                AppMethodBeat.o(61766);
                return obj2;
            case 8:
                Object typedArray = toTypedArray((V8Array) obj);
                AppMethodBeat.o(61766);
                return typedArray;
            case 10:
                ArrayBuffer arrayBuffer = new ArrayBuffer(((V8ArrayBuffer) obj).getBackingStore());
                AppMethodBeat.o(61766);
                return arrayBuffer;
            case 99:
                V8Value undefined = V8.getUndefined();
                AppMethodBeat.o(61766);
                return undefined;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Cannot convert type " + V8Value.getStringRepresentation(i2));
                AppMethodBeat.o(61766);
                throw illegalStateException;
        }
    }

    private static Object toTypedArray(V8Array v8Array) {
        AppMethodBeat.i(61767);
        int type = v8Array.getType();
        ByteBuffer byteBuffer = ((V8TypedArray) v8Array).getByteBuffer();
        switch (type) {
            case 1:
                Int32Array int32Array = new Int32Array(byteBuffer);
                AppMethodBeat.o(61767);
                return int32Array;
            case 2:
                Float64Array float64Array = new Float64Array(byteBuffer);
                AppMethodBeat.o(61767);
                return float64Array;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Known Typed Array type: " + V8Value.getStringRepresentation(type));
                AppMethodBeat.o(61767);
                throw illegalStateException;
            case 9:
                Int8Array int8Array = new Int8Array(byteBuffer);
                AppMethodBeat.o(61767);
                return int8Array;
            case 11:
                UInt8Array uInt8Array = new UInt8Array(byteBuffer);
                AppMethodBeat.o(61767);
                return uInt8Array;
            case 12:
                UInt8ClampedArray uInt8ClampedArray = new UInt8ClampedArray(byteBuffer);
                AppMethodBeat.o(61767);
                return uInt8ClampedArray;
            case 13:
                Int16Array int16Array = new Int16Array(byteBuffer);
                AppMethodBeat.o(61767);
                return int16Array;
            case 14:
                UInt16Array uInt16Array = new UInt16Array(byteBuffer);
                AppMethodBeat.o(61767);
                return uInt16Array;
            case 15:
                UInt32Array uInt32Array = new UInt32Array(byteBuffer);
                AppMethodBeat.o(61767);
                return uInt32Array;
            case 16:
                Float32Array float32Array = new Float32Array(byteBuffer);
                AppMethodBeat.o(61767);
                return float32Array;
        }
    }

    private V8ObjectUtils() {
    }

    static class DefaultTypeAdapter implements TypeAdapter {
        DefaultTypeAdapter() {
        }

        @Override // com.eclipsesource.v8.utils.TypeAdapter
        public Object adapt(int i2, Object obj) {
            return TypeAdapter.DEFAULT;
        }
    }

    /* access modifiers changed from: package-private */
    public static class ListWrapper {
        private List<? extends Object> list;

        public ListWrapper(List<? extends Object> list2) {
            this.list = list2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ListWrapper) || ((ListWrapper) obj).list != this.list) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            AppMethodBeat.i(61729);
            int identityHashCode = System.identityHashCode(this.list);
            AppMethodBeat.o(61729);
            return identityHashCode;
        }
    }
}
