package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class LazyReflectMethod extends ReflectMethod {
    boolean mInited = false;

    public LazyReflectMethod() {
    }

    public LazyReflectMethod(Object obj, String str, Class<?>... clsArr) {
        super(obj, str, clsArr);
    }

    public LazyReflectMethod(Class<?> cls, String str, Class<?>... clsArr) {
        super(cls, str, clsArr);
    }

    @Override // org.xwalk.core.ReflectMethod
    public boolean init(Object obj, Class<?> cls, String str, Class<?>... clsArr) {
        AppMethodBeat.i(207382);
        this.mInstance = obj;
        if (cls == null) {
            cls = obj != null ? obj.getClass() : null;
        }
        this.mClass = cls;
        this.mName = str;
        this.mParameterTypes = clsArr;
        this.mMethod = null;
        this.mInited = false;
        AppMethodBeat.o(207382);
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
        if (r6.mMethod == null) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003e, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(207383);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0065, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(207383);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean doInit() {
        /*
        // Method dump skipped, instructions count: 105
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xwalk.core.LazyReflectMethod.doInit():boolean");
    }

    @Override // org.xwalk.core.ReflectMethod
    public Object invoke(Object... objArr) {
        AppMethodBeat.i(207384);
        doInit();
        Object invoke = super.invoke(objArr);
        AppMethodBeat.o(207384);
        return invoke;
    }

    @Override // org.xwalk.core.ReflectMethod
    public boolean isNull() {
        AppMethodBeat.i(207385);
        doInit();
        boolean isNull = super.isNull();
        AppMethodBeat.o(207385);
        return isNull;
    }
}
