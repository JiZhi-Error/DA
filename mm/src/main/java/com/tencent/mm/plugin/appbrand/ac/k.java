package com.tencent.mm.plugin.appbrand.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k {
    public static Object a(Class<?> cls, String str, Object obj, Class<?>[] clsArr, Object[] objArr) {
        AppMethodBeat.i(140843);
        Object b2 = b(cls, str, obj, clsArr, objArr);
        AppMethodBeat.o(140843);
        return b2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        if (r6 == r2) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r0 = r2.getDeclaredMethod(r7, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        r2 = r2.getSuperclass();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
        r2.getSuperclass();
        com.tencent.matrix.trace.core.AppMethodBeat.o(174626);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0038, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0031 A[ExcHandler: all (r0v7 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:6:0x001c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> T b(java.lang.Class<?> r6, java.lang.String r7, java.lang.Object r8, java.lang.Class<?>[] r9, java.lang.Object[] r10) {
        /*
            r1 = 0
            r5 = 174626(0x2aa22, float:2.44703E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            if (r8 != 0) goto L_0x0015
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "instance cannot be null"
            r0.<init>(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            throw r0
        L_0x0015:
            java.lang.Class r2 = r8.getClass()
            r0 = r1
        L_0x001a:
            if (r2 == 0) goto L_0x0039
            java.lang.reflect.Method r0 = r2.getDeclaredMethod(r7, r9)     // Catch:{ Exception -> 0x0025, all -> 0x0031 }
            java.lang.Class r2 = r2.getSuperclass()
            goto L_0x001a
        L_0x0025:
            r3 = move-exception
            if (r6 != r2) goto L_0x002c
            java.lang.reflect.Method r0 = r2.getDeclaredMethod(r7, r9)     // Catch:{ Exception -> 0x005e, all -> 0x0031 }
        L_0x002c:
            java.lang.Class r2 = r2.getSuperclass()
            goto L_0x001a
        L_0x0031:
            r0 = move-exception
            r2.getSuperclass()
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            throw r0
        L_0x0039:
            if (r0 != 0) goto L_0x0040
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            r0 = r1
        L_0x003f:
            return r0
        L_0x0040:
            r2 = 1
            r0.setAccessible(r2)     // Catch:{ Exception -> 0x004c }
            java.lang.Object r0 = r0.invoke(r8, r10)     // Catch:{ Exception -> 0x004c }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            goto L_0x003f
        L_0x004c:
            r0 = move-exception
            java.lang.String r2 = "MicroMsg.ReflectUtil"
            java.lang.String r3 = ""
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]
            com.tencent.mm.sdk.platformtools.Log.printErrStackTrace(r2, r0, r3, r4)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            r0 = r1
            goto L_0x003f
        L_0x005e:
            r3 = move-exception
            goto L_0x002c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.ac.k.b(java.lang.Class, java.lang.String, java.lang.Object, java.lang.Class[], java.lang.Object[]):java.lang.Object");
    }
}
