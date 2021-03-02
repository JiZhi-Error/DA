package org.xwalk.core;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a;
import com.tencent.xweb.b;
import com.tencent.xweb.util.g;
import com.tencent.xweb.xwalk.s;
import java.util.Arrays;

public class RuntimeToSdkChannel {
    public static final String KEY_GET_CONFIG_CMD = "GET_CONFIG_CMD";
    public static final String KEY_GET_CONFIG_CMD_EXTEND = "GET_CONFIG_CMD_EXTEND";
    public static final String KEY_INVOKE_METHOD = "INVOKE_INSTANCE_METHOD";
    public static final String KEY_REPORT_JAVA_EXCEPTION = "REPORT_JAVA_EXCEPTION";
    public static final String KEY_STATIC_METHOD = "INVOKE_STATIC_METHOD";
    public static final String KEY_XPROFILE_RESULT_FORWARD_TO_SDK = "KEY_XPROFILE_RESULT_FORWARD_TO_SDK";
    public static final String KEY_XPROFILE_TRACING_FRAME_COST_RESULT = "KEY_XPROFILE_TRACING_FRAME_COST_RESULT";

    public static synchronized void initRuntimeToSdkChannel() {
        synchronized (RuntimeToSdkChannel.class) {
            AppMethodBeat.i(154613);
            if (XWalkCoreWrapper.getInstance() == null) {
                AppMethodBeat.o(154613);
            } else {
                XWalkCoreWrapper.getInstance();
                XWalkCoreWrapper.invokeRuntimeChannel(80005, new Object[]{new ValueCallback() {
                    /* class org.xwalk.core.RuntimeToSdkChannel.AnonymousClass1 */

                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(Object obj) {
                        AppMethodBeat.i(154612);
                        if (obj == null || !(obj instanceof Object[])) {
                            AppMethodBeat.o(154612);
                            return;
                        }
                        Object[] objArr = (Object[]) obj;
                        if (objArr.length < 3) {
                            AppMethodBeat.o(154612);
                        } else if (!(objArr[0] instanceof String)) {
                            AppMethodBeat.o(154612);
                        } else {
                            objArr[2] = RuntimeToSdkChannel.onRuntimeCalled((String) objArr[0], objArr[1]);
                            AppMethodBeat.o(154612);
                        }
                    }
                }});
                AppMethodBeat.o(154613);
            }
        }
    }

    public static Object onRuntimeCalled(String str, Object obj) {
        Object obj2;
        AppMethodBeat.i(154614);
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1744471054:
                if (str.equals(KEY_XPROFILE_TRACING_FRAME_COST_RESULT)) {
                    c2 = 6;
                    break;
                }
                break;
            case -648440269:
                if (str.equals(KEY_GET_CONFIG_CMD_EXTEND)) {
                    c2 = 1;
                    break;
                }
                break;
            case 51739140:
                if (str.equals(KEY_INVOKE_METHOD)) {
                    c2 = 2;
                    break;
                }
                break;
            case 59342662:
                if (str.equals(KEY_GET_CONFIG_CMD)) {
                    c2 = 0;
                    break;
                }
                break;
            case 886431819:
                if (str.equals(KEY_STATIC_METHOD)) {
                    c2 = 3;
                    break;
                }
                break;
            case 1291018756:
                if (str.equals(KEY_XPROFILE_RESULT_FORWARD_TO_SDK)) {
                    c2 = 5;
                    break;
                }
                break;
            case 2069614781:
                if (str.equals(KEY_REPORT_JAVA_EXCEPTION)) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                if (!(obj instanceof String[])) {
                    AppMethodBeat.o(154614);
                    return "";
                }
                String[] strArr = (String[]) obj;
                if (strArr.length < 2) {
                    AppMethodBeat.o(154614);
                    return "";
                } else if (TextUtils.isEmpty(strArr[1])) {
                    String brJ = a.brJ(strArr[0]);
                    AppMethodBeat.o(154614);
                    return brJ;
                } else {
                    String nS = a.nS(strArr[0], strArr[1]);
                    AppMethodBeat.o(154614);
                    return nS;
                }
            case 1:
                if (!(obj instanceof String[])) {
                    AppMethodBeat.o(154614);
                    return "";
                }
                String[] strArr2 = (String[]) obj;
                if (strArr2.length < 2) {
                    AppMethodBeat.o(154614);
                    return "";
                } else if (TextUtils.isEmpty(strArr2[1])) {
                    String brJ2 = b.brJ(strArr2[0]);
                    AppMethodBeat.o(154614);
                    return brJ2;
                } else {
                    String nS2 = b.nS(strArr2[0], strArr2[1]);
                    AppMethodBeat.o(154614);
                    return nS2;
                }
            case 2:
                if (!(obj instanceof Object[])) {
                    AppMethodBeat.o(154614);
                    return null;
                }
                Object[] objArr = (Object[]) obj;
                if (objArr == null || objArr.length < 2) {
                    AppMethodBeat.o(154614);
                    return null;
                } else if (!(objArr[0] instanceof Object)) {
                    AppMethodBeat.o(154614);
                    return null;
                } else if (!(objArr[1] instanceof String)) {
                    AppMethodBeat.o(154614);
                    return null;
                } else {
                    Object obj3 = objArr[0];
                    if (objArr[0] instanceof String) {
                        obj2 = g.bsF((String) objArr[0]);
                    } else {
                        obj2 = obj3;
                    }
                    if (obj2 == null) {
                        AppMethodBeat.o(154614);
                        return null;
                    }
                    String str2 = (String) objArr[1];
                    if (2 == objArr.length) {
                        Object f2 = g.f(obj2, str2);
                        AppMethodBeat.o(154614);
                        return f2;
                    } else if (4 != objArr.length) {
                        Object f3 = g.f(obj2, str2);
                        AppMethodBeat.o(154614);
                        return f3;
                    } else if (!(objArr[2] instanceof Class[])) {
                        Object f4 = g.f(obj2, str2);
                        AppMethodBeat.o(154614);
                        return f4;
                    } else if (!(objArr[3] instanceof Object[])) {
                        Object f5 = g.f(obj2, str2);
                        AppMethodBeat.o(154614);
                        return f5;
                    } else {
                        Object c3 = g.c(obj2, str2, (Class[]) objArr[2], (Object[]) objArr[3]);
                        AppMethodBeat.o(154614);
                        return c3;
                    }
                }
            case 3:
                if (!(obj instanceof Object[])) {
                    AppMethodBeat.o(154614);
                    return null;
                }
                Object[] objArr2 = (Object[]) obj;
                if (objArr2 == null || objArr2.length < 2) {
                    AppMethodBeat.o(154614);
                    return null;
                } else if (!(objArr2[0] instanceof String)) {
                    AppMethodBeat.o(154614);
                    return null;
                } else if (!(objArr2[1] instanceof String)) {
                    AppMethodBeat.o(154614);
                    return null;
                } else {
                    String str3 = (String) objArr2[0];
                    String str4 = (String) objArr2[1];
                    if (2 == objArr2.length) {
                        Object oj = g.oj(str3, str4);
                        AppMethodBeat.o(154614);
                        return oj;
                    } else if (4 != objArr2.length) {
                        Object f6 = g.f(str3, str4);
                        AppMethodBeat.o(154614);
                        return f6;
                    } else if (!(objArr2[2] instanceof Class[])) {
                        Object oj2 = g.oj(str3, str4);
                        AppMethodBeat.o(154614);
                        return oj2;
                    } else if (!(objArr2[3] instanceof Object[])) {
                        Object oj3 = g.oj(str3, str4);
                        AppMethodBeat.o(154614);
                        return oj3;
                    } else {
                        Object b2 = g.b(str3, str4, (Class[]) objArr2[2], (Object[]) objArr2[3]);
                        AppMethodBeat.o(154614);
                        return b2;
                    }
                }
            case 4:
                if (!(obj instanceof Object[])) {
                    AppMethodBeat.o(154614);
                    return null;
                }
                Object[] objArr3 = (Object[]) obj;
                if (objArr3.length <= 0) {
                    AppMethodBeat.o(154614);
                    return null;
                } else if (!(objArr3[0] instanceof Throwable)) {
                    AppMethodBeat.o(154614);
                    return null;
                } else {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), (Throwable) objArr3[0]);
                    AppMethodBeat.o(154614);
                    return null;
                }
            case 5:
            case 6:
                s sVar = s.a.SHQ;
                if (sVar.SHN == null && (obj instanceof Object[])) {
                    Object[] objArr4 = (Object[]) obj;
                    if ((objArr4[0] instanceof String) && objArr4.length >= 2) {
                        if (sVar.SHM.get((String) objArr4[0]) != null) {
                            Arrays.copyOfRange(objArr4, 1, objArr4.length);
                        }
                    }
                }
                AppMethodBeat.o(154614);
                return null;
            default:
                AppMethodBeat.o(154614);
                return null;
        }
    }
}
