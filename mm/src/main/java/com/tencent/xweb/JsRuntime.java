package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import org.xwalk.core.XWalkEnvironment;

public final class JsRuntime {
    public static JsRuntimeType Szt;
    private static String Szu = "";

    public enum JsRuntimeType {
        RT_TYPE_AUTO,
        RT_TYPE_SYS,
        RT_TYPE_XWALK,
        RT_TYPE_WEB_X5,
        RT_TYPE_DUMMY,
        RT_TYPE_X5,
        RT_TYPE_J2V8,
        RT_TYPE_NATIVE_SCRIPT,
        RT_TYPE_MMV8;

        public static JsRuntimeType valueOf(String str) {
            AppMethodBeat.i(156760);
            JsRuntimeType jsRuntimeType = (JsRuntimeType) Enum.valueOf(JsRuntimeType.class, str);
            AppMethodBeat.o(156760);
            return jsRuntimeType;
        }

        static {
            AppMethodBeat.i(156761);
            AppMethodBeat.o(156761);
        }
    }

    public static JsRuntimeType hsu() {
        return Szt;
    }

    public static String hsv() {
        return Szu;
    }

    public static JsRuntimeType a(JsRuntimeType jsRuntimeType, String str, Context context) {
        AppMethodBeat.i(156762);
        y.lC(context);
        if (y.hsF().SzZ != JsRuntimeType.RT_TYPE_AUTO) {
            jsRuntimeType = y.hsF().SzZ;
            XWalkEnvironment.addXWalkInitializeLog("XWeb", "use hardcode jscore type = ".concat(String.valueOf(jsRuntimeType)));
        } else if (a.brF(str) != JsRuntimeType.RT_TYPE_AUTO) {
            jsRuntimeType = a.brF(str);
            XWalkEnvironment.addXWalkInitializeLog("XWeb", "module " + str + "use cmd jscore type = " + jsRuntimeType);
        }
        if (WebView.getCurWebType() == WebView.c.WV_KIND_X5) {
            if (!(JsRuntimeType.RT_TYPE_SYS == jsRuntimeType || JsRuntimeType.RT_TYPE_X5 == jsRuntimeType)) {
                jsRuntimeType = JsRuntimeType.RT_TYPE_MMV8;
            }
        } else if (WebView.getCurWebType() == WebView.c.WV_KIND_CW) {
            if (!(JsRuntimeType.RT_TYPE_NATIVE_SCRIPT == jsRuntimeType || JsRuntimeType.RT_TYPE_J2V8 == jsRuntimeType || JsRuntimeType.RT_TYPE_SYS == jsRuntimeType)) {
                jsRuntimeType = JsRuntimeType.RT_TYPE_MMV8;
            }
        } else if (WebView.getCurWebType() == WebView.c.WV_KIND_SYS && JsRuntimeType.RT_TYPE_SYS != jsRuntimeType) {
            jsRuntimeType = JsRuntimeType.RT_TYPE_MMV8;
        }
        AppMethodBeat.o(156762);
        return jsRuntimeType;
    }
}
