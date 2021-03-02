package com.tencent.midas.plugin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.util.HashMap;

@SuppressLint({"NewApi"})
public class APLayoutInflaterFactory implements LayoutInflater.Factory2 {
    private final Object[] constructorArgs = new Object[2];
    private final HashMap<String, Constructor<? extends View>> constructorMap = new HashMap<>();
    private final Class<?>[] constructorSign = {Context.class, AttributeSet.class};

    public APLayoutInflaterFactory() {
        AppMethodBeat.i(193166);
        AppMethodBeat.o(193166);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = new android.view.InflateException(r14.getPositionDescription() + ": Error inflating class " + r12);
        r3.initCause(r1);
        com.tencent.matrix.trace.core.AppMethodBeat.o(193167);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x009a, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x009b, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x009c, code lost:
        r10.constructorArgs[0] = r0;
        r10.constructorArgs[1] = null;
        com.tencent.matrix.trace.core.AppMethodBeat.o(193167);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a7, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a8, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a9, code lost:
        r3 = new android.view.InflateException(r14.getPositionDescription() + ": Class is not a View " + r12);
        r3.initCause(r1);
        com.tencent.matrix.trace.core.AppMethodBeat.o(193167);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00d3, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00d4, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00d5, code lost:
        r3 = new android.view.InflateException(r14.getPositionDescription() + ": Class not found " + r12);
        r3.initCause(r1);
        com.tencent.matrix.trace.core.AppMethodBeat.o(193167);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ff, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x011a, code lost:
        r3 = "<unknown>";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0132, code lost:
        r3 = r3.getName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0137, code lost:
        r1 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x006f A[ExcHandler: NoSuchMethodException (r1v16 'e' java.lang.NoSuchMethodException A[CUSTOM_DECLARE]), Splitter:B:8:0x003b] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a8 A[ExcHandler: ClassCastException (r1v14 'e' java.lang.ClassCastException A[CUSTOM_DECLARE]), Splitter:B:8:0x003b] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00d4 A[ExcHandler: ClassNotFoundException (r1v12 'e' java.lang.ClassNotFoundException A[CUSTOM_DECLARE]), Splitter:B:8:0x003b] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0132  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onCreateView(android.view.View r11, java.lang.String r12, android.content.Context r13, android.util.AttributeSet r14) {
        /*
        // Method dump skipped, instructions count: 316
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.midas.plugin.APLayoutInflaterFactory.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        AppMethodBeat.i(193168);
        View onCreateView = onCreateView(null, str, context, attributeSet);
        AppMethodBeat.o(193168);
        return onCreateView;
    }
}
