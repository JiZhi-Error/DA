package com.tencent.mm.svg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class a<T> {
    public Field bUo;
    private String classname;
    private String fieldName;
    private boolean gKM;
    public Object obj;

    public a(Object obj2, String str) {
        AppMethodBeat.i(148753);
        if (obj2 == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("obj cannot be null");
            AppMethodBeat.o(148753);
            throw illegalArgumentException;
        }
        this.obj = obj2;
        this.fieldName = str;
        this.classname = null;
        AppMethodBeat.o(148753);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0066, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0067, code lost:
        r1.getSuperclass();
        com.tencent.matrix.trace.core.AppMethodBeat.o(148754);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006d, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0066 A[ExcHandler: all (r0v3 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:5:0x001a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void prepare() {
        /*
        // Method dump skipped, instructions count: 116
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.svg.b.a.prepare():void");
    }

    public final T get() {
        AppMethodBeat.i(148755);
        prepare();
        if (this.bUo == null) {
            NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
            AppMethodBeat.o(148755);
            throw noSuchFieldException;
        }
        try {
            T t = (T) this.bUo.get(this.obj);
            AppMethodBeat.o(148755);
            return t;
        } catch (ClassCastException e2) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("unable to cast object");
            AppMethodBeat.o(148755);
            throw illegalArgumentException;
        }
    }

    public final boolean apg() {
        AppMethodBeat.i(148756);
        prepare();
        if (this.bUo != null) {
            AppMethodBeat.o(148756);
            return true;
        }
        AppMethodBeat.o(148756);
        return false;
    }
}
