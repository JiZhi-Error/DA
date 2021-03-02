package com.tencent.magicbrush.a;

import com.github.henryye.nativeiv.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {

    public interface b {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printStackTrace(String str, Throwable th, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    static class a implements b {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.tencent.magicbrush.a.c.b
        public final void d(String str, String str2, Object... objArr) {
            AppMethodBeat.i(139961);
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String.format(str2, objArr);
                    }
                } catch (Exception e2) {
                    AppMethodBeat.o(139961);
                    return;
                }
            }
            AppMethodBeat.o(139961);
        }

        @Override // com.tencent.magicbrush.a.c.b
        public final void i(String str, String str2, Object... objArr) {
            AppMethodBeat.i(139962);
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String.format(str2, objArr);
                    }
                } catch (Exception e2) {
                    AppMethodBeat.o(139962);
                    return;
                }
            }
            AppMethodBeat.o(139962);
        }

        @Override // com.tencent.magicbrush.a.c.b
        public final void w(String str, String str2, Object... objArr) {
            AppMethodBeat.i(139963);
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String.format(str2, objArr);
                    }
                } catch (Exception e2) {
                    AppMethodBeat.o(139963);
                    return;
                }
            }
            AppMethodBeat.o(139963);
        }

        @Override // com.tencent.magicbrush.a.c.b
        public final void e(String str, String str2, Object... objArr) {
            AppMethodBeat.i(139964);
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String.format(str2, objArr);
                    }
                } catch (Exception e2) {
                    AppMethodBeat.o(139964);
                    return;
                }
            }
            AppMethodBeat.o(139964);
        }

        @Override // com.tencent.magicbrush.a.c.b
        public final void printStackTrace(String str, Throwable th, String str2, Object... objArr) {
            AppMethodBeat.i(139965);
            if (th != null) {
                if (objArr != null) {
                    try {
                        if (objArr.length > 0) {
                            String.format(str2, objArr);
                        }
                    } catch (Exception e2) {
                    }
                }
                AppMethodBeat.o(139965);
                return;
            }
            AppMethodBeat.o(139965);
        }
    }

    /* renamed from: com.tencent.magicbrush.a.c$c  reason: collision with other inner class name */
    public static class C0193c {
        private static b cMF = new a((byte) 0);

        static {
            AppMethodBeat.i(139976);
            AppMethodBeat.o(139976);
        }

        public static void a(final b bVar) {
            AppMethodBeat.i(139971);
            cMF = bVar;
            com.github.henryye.nativeiv.a.b.a(new b.AbstractC0084b() {
                /* class com.tencent.magicbrush.a.c.C0193c.AnonymousClass1 */

                @Override // com.github.henryye.nativeiv.a.b.AbstractC0084b
                public final void d(String str, String str2, Object... objArr) {
                    AppMethodBeat.i(139966);
                    bVar.d(str, str2, objArr);
                    AppMethodBeat.o(139966);
                }

                @Override // com.github.henryye.nativeiv.a.b.AbstractC0084b
                public final void i(String str, String str2, Object... objArr) {
                    AppMethodBeat.i(139967);
                    bVar.i(str, str2, objArr);
                    AppMethodBeat.o(139967);
                }

                @Override // com.github.henryye.nativeiv.a.b.AbstractC0084b
                public final void w(String str, String str2, Object... objArr) {
                    AppMethodBeat.i(139968);
                    bVar.w(str, str2, objArr);
                    AppMethodBeat.o(139968);
                }

                @Override // com.github.henryye.nativeiv.a.b.AbstractC0084b
                public final void e(String str, String str2, Object... objArr) {
                    AppMethodBeat.i(139969);
                    bVar.e(str, str2, objArr);
                    AppMethodBeat.o(139969);
                }

                @Override // com.github.henryye.nativeiv.a.b.AbstractC0084b
                public final void printStackTrace(String str, Throwable th, String str2, Object... objArr) {
                    AppMethodBeat.i(139970);
                    bVar.printStackTrace(str, th, str2, objArr);
                    AppMethodBeat.o(139970);
                }
            });
            AppMethodBeat.o(139971);
        }

        public static void d(String str, String str2, Object... objArr) {
            AppMethodBeat.i(139972);
            cMF.d(str, str2, objArr);
            AppMethodBeat.o(139972);
        }

        public static void i(String str, String str2, Object... objArr) {
            AppMethodBeat.i(139973);
            cMF.i(str, str2, objArr);
            AppMethodBeat.o(139973);
        }

        public static void e(String str, String str2, Object... objArr) {
            AppMethodBeat.i(139974);
            cMF.e(str, str2, objArr);
            AppMethodBeat.o(139974);
        }

        public static void printStackTrace(String str, Throwable th, String str2, Object... objArr) {
            AppMethodBeat.i(139975);
            cMF.printStackTrace(str, th, str2, objArr);
            AppMethodBeat.o(139975);
        }
    }
}
