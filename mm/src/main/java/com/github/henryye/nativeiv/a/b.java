package com.github.henryye.nativeiv.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    private static AbstractC0084b bbr = new a((byte) 0);

    /* renamed from: com.github.henryye.nativeiv.a.b$b  reason: collision with other inner class name */
    public interface AbstractC0084b {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printStackTrace(String str, Throwable th, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    static class a implements AbstractC0084b {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.github.henryye.nativeiv.a.b.AbstractC0084b
        public final void d(String str, String str2, Object... objArr) {
            AppMethodBeat.i(127380);
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String.format(str2, objArr);
                    }
                } catch (Exception e2) {
                    AppMethodBeat.o(127380);
                    return;
                }
            }
            AppMethodBeat.o(127380);
        }

        @Override // com.github.henryye.nativeiv.a.b.AbstractC0084b
        public final void i(String str, String str2, Object... objArr) {
            AppMethodBeat.i(127381);
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String.format(str2, objArr);
                    }
                } catch (Exception e2) {
                    AppMethodBeat.o(127381);
                    return;
                }
            }
            AppMethodBeat.o(127381);
        }

        @Override // com.github.henryye.nativeiv.a.b.AbstractC0084b
        public final void w(String str, String str2, Object... objArr) {
            AppMethodBeat.i(127382);
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String.format(str2, objArr);
                    }
                } catch (Exception e2) {
                    AppMethodBeat.o(127382);
                    return;
                }
            }
            AppMethodBeat.o(127382);
        }

        @Override // com.github.henryye.nativeiv.a.b.AbstractC0084b
        public final void e(String str, String str2, Object... objArr) {
            AppMethodBeat.i(127383);
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String.format(str2, objArr);
                    }
                } catch (Exception e2) {
                    AppMethodBeat.o(127383);
                    return;
                }
            }
            AppMethodBeat.o(127383);
        }

        @Override // com.github.henryye.nativeiv.a.b.AbstractC0084b
        public final void printStackTrace(String str, Throwable th, String str2, Object... objArr) {
            AppMethodBeat.i(127384);
            if (th != null) {
                if (objArr != null) {
                    try {
                        if (objArr.length > 0) {
                            String.format(str2, objArr);
                        }
                    } catch (Exception e2) {
                    }
                }
                AppMethodBeat.o(127384);
                return;
            }
            AppMethodBeat.o(127384);
        }
    }

    static {
        AppMethodBeat.i(127390);
        AppMethodBeat.o(127390);
    }

    public static void a(AbstractC0084b bVar) {
        bbr = bVar;
    }

    public static void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(127385);
        bbr.d(str, str2, objArr);
        AppMethodBeat.o(127385);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(127386);
        bbr.i(str, str2, objArr);
        AppMethodBeat.o(127386);
    }

    public static void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(127387);
        bbr.w(str, str2, objArr);
        AppMethodBeat.o(127387);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(127388);
        bbr.e(str, str2, objArr);
        AppMethodBeat.o(127388);
    }

    public static void printStackTrace(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.i(127389);
        bbr.printStackTrace(str, th, str2, objArr);
        AppMethodBeat.o(127389);
    }
}
