package com.hilive.mediasdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class LogDelegate {
    private static ILog sImp = new DefaultLog();

    public interface ILog {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printStackTrace(String str, Throwable th, String str2, Object... objArr);

        void v(String str, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    static class DefaultLog implements ILog {
        private DefaultLog() {
        }

        @Override // com.hilive.mediasdk.LogDelegate.ILog
        public void v(String str, String str2, Object... objArr) {
            AppMethodBeat.i(73592);
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String.format(str2, objArr);
                    }
                } catch (Exception e2) {
                    AppMethodBeat.o(73592);
                    return;
                }
            }
            AppMethodBeat.o(73592);
        }

        @Override // com.hilive.mediasdk.LogDelegate.ILog
        public void d(String str, String str2, Object... objArr) {
            AppMethodBeat.i(73593);
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String.format(str2, objArr);
                    }
                } catch (Exception e2) {
                    AppMethodBeat.o(73593);
                    return;
                }
            }
            AppMethodBeat.o(73593);
        }

        @Override // com.hilive.mediasdk.LogDelegate.ILog
        public void i(String str, String str2, Object... objArr) {
            AppMethodBeat.i(73594);
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String.format(str2, objArr);
                    }
                } catch (Exception e2) {
                    AppMethodBeat.o(73594);
                    return;
                }
            }
            AppMethodBeat.o(73594);
        }

        @Override // com.hilive.mediasdk.LogDelegate.ILog
        public void w(String str, String str2, Object... objArr) {
            AppMethodBeat.i(73595);
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String.format(str2, objArr);
                    }
                } catch (Exception e2) {
                    AppMethodBeat.o(73595);
                    return;
                }
            }
            AppMethodBeat.o(73595);
        }

        @Override // com.hilive.mediasdk.LogDelegate.ILog
        public void e(String str, String str2, Object... objArr) {
            AppMethodBeat.i(73596);
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String.format(str2, objArr);
                    }
                } catch (Exception e2) {
                    AppMethodBeat.o(73596);
                    return;
                }
            }
            AppMethodBeat.o(73596);
        }

        @Override // com.hilive.mediasdk.LogDelegate.ILog
        public void printStackTrace(String str, Throwable th, String str2, Object... objArr) {
            AppMethodBeat.i(73597);
            if (th != null) {
                if (objArr != null) {
                    try {
                        if (objArr.length > 0) {
                            String.format(str2, objArr);
                        }
                    } catch (Exception e2) {
                    }
                }
                AppMethodBeat.o(73597);
                return;
            }
            AppMethodBeat.o(73597);
        }
    }

    static {
        AppMethodBeat.i(73604);
        AppMethodBeat.o(73604);
    }

    public static void setImp(ILog iLog) {
        if (iLog != null) {
            sImp = iLog;
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        AppMethodBeat.i(73598);
        sImp.v(str, str2, objArr);
        AppMethodBeat.o(73598);
    }

    public static void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(73599);
        sImp.d(str, str2, objArr);
        AppMethodBeat.o(73599);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(73600);
        sImp.i(str, str2, objArr);
        AppMethodBeat.o(73600);
    }

    public static void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(73601);
        sImp.w(str, str2, objArr);
        AppMethodBeat.o(73601);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(73602);
        sImp.e(str, str2, objArr);
        AppMethodBeat.o(73602);
    }

    public static void printStackTrace(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.i(73603);
        sImp.printStackTrace(str, th, str2, objArr);
        AppMethodBeat.o(73603);
    }
}
