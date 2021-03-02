package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.IXWebLogClient;

public class Log {
    private static IXWebLogClient m_log_callback = null;

    public static void SetLogCallBack(IXWebLogClient iXWebLogClient) {
        m_log_callback = iXWebLogClient;
    }

    public static void f(String str, String str2) {
        AppMethodBeat.i(157204);
        if (m_log_callback != null) {
            m_log_callback.e(str, str2);
            AppMethodBeat.o(157204);
            return;
        }
        AppMethodBeat.o(157204);
    }

    public static void e(String str, String str2, Throwable th) {
        AppMethodBeat.i(157205);
        if (m_log_callback != null) {
            m_log_callback.e(str, str2);
            AppMethodBeat.o(157205);
            return;
        }
        AppMethodBeat.o(157205);
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(157206);
        if (m_log_callback != null) {
            m_log_callback.e(str, str2);
            AppMethodBeat.o(157206);
            return;
        }
        AppMethodBeat.o(157206);
    }

    public static void w(String str, String str2) {
        AppMethodBeat.i(157207);
        if (m_log_callback != null) {
            m_log_callback.w(str, str2);
            AppMethodBeat.o(157207);
            return;
        }
        AppMethodBeat.o(157207);
    }

    public static void w(String str, String str2, Throwable th) {
        AppMethodBeat.i(157208);
        if (m_log_callback != null) {
            m_log_callback.w(str, str2);
            AppMethodBeat.o(157208);
            return;
        }
        AppMethodBeat.o(157208);
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(157209);
        if (m_log_callback != null) {
            m_log_callback.i(str, str2);
            AppMethodBeat.o(157209);
            return;
        }
        AppMethodBeat.o(157209);
    }

    public static void d(String str, String str2) {
        AppMethodBeat.i(157210);
        if (m_log_callback != null) {
            m_log_callback.d(str, str2);
            AppMethodBeat.o(157210);
            return;
        }
        AppMethodBeat.o(157210);
    }

    public static void v(String str, String str2) {
        AppMethodBeat.i(157211);
        if (m_log_callback != null) {
            m_log_callback.v(str, str2);
            AppMethodBeat.o(157211);
            return;
        }
        AppMethodBeat.o(157211);
    }
}
