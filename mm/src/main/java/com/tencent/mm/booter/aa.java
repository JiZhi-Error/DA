package com.tencent.mm.booter;

import com.tencent.f.a;
import com.tencent.f.d;
import com.tencent.f.f;
import com.tencent.f.g;
import com.tencent.f.g.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tav.coremedia.TimeUtil;

public final class aa implements g.a {

    public enum a {
        MAIN_PROCESS {
            @Override // com.tencent.mm.booter.aa.a
            public final int akY() {
                return this.gns * 6;
            }

            @Override // com.tencent.mm.booter.aa.a
            public final int akZ() {
                AppMethodBeat.i(182878);
                int max = (int) Math.max(8.0f, ((float) this.gns) * 1.5f);
                AppMethodBeat.o(182878);
                return max;
            }

            @Override // com.tencent.mm.booter.aa.a
            public final com.tencent.f.a b(a.C0134a aVar) {
                AppMethodBeat.i(182879);
                com.tencent.f.a aVar2 = aVar.mv(this.gns * 4, this.gns * 6).aqO(akZ()).hlX().hlY().a(h.a.FS_POLICY).RSy;
                AppMethodBeat.o(182879);
                return aVar2;
            }
        },
        TOOL_PROCESS {
            @Override // com.tencent.mm.booter.aa.a
            public final int akY() {
                return this.gns * 6;
            }

            @Override // com.tencent.mm.booter.aa.a
            public final int akZ() {
                AppMethodBeat.i(182880);
                int max = (int) Math.max(8.0f, ((float) this.gns) * 1.5f);
                AppMethodBeat.o(182880);
                return max;
            }

            @Override // com.tencent.mm.booter.aa.a
            public final com.tencent.f.a b(a.C0134a aVar) {
                AppMethodBeat.i(182881);
                com.tencent.f.a aVar2 = aVar.mv(this.gns * 4, this.gns * 6).aqO(akZ()).hlX().hlY().a(h.a.FS_POLICY).RSy;
                AppMethodBeat.o(182881);
                return aVar2;
            }
        },
        OTHER {
            @Override // com.tencent.mm.booter.aa.a
            public final int akY() {
                return this.gns * 6;
            }

            @Override // com.tencent.mm.booter.aa.a
            public final int akZ() {
                AppMethodBeat.i(182882);
                int max = (int) Math.max(8.0f, ((float) this.gns) * 1.5f);
                AppMethodBeat.o(182882);
                return max;
            }

            @Override // com.tencent.mm.booter.aa.a
            public final com.tencent.f.a b(a.C0134a aVar) {
                AppMethodBeat.i(182883);
                com.tencent.f.a aVar2 = aVar.mv(this.gns * 4, this.gns * 6).aqO(akZ()).hlX().hlY().a(h.a.FS_POLICY).RSy;
                AppMethodBeat.o(182883);
                return aVar2;
            }
        };
        
        int gns;

        private a() {
            AppMethodBeat.i(182886);
            this.gns = Math.min(4, Runtime.getRuntime().availableProcessors());
            AppMethodBeat.o(182886);
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public static a valueOf(String str) {
            AppMethodBeat.i(182885);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(182885);
            return aVar;
        }

        static {
            AppMethodBeat.i(182887);
            AppMethodBeat.o(182887);
        }

        public int akY() {
            return this.gns;
        }

        public int akZ() {
            return this.gns;
        }

        public com.tencent.f.a b(a.C0134a aVar) {
            return aVar.RSy;
        }
    }

    @Override // com.tencent.f.g.a
    public final void a(g.c cVar) {
        AppMethodBeat.i(182888);
        cVar.a(new d.a() {
            /* class com.tencent.mm.booter.aa.AnonymousClass1 */

            @Override // com.tencent.f.d.a
            public final void i(String str, String str2, Object... objArr) {
                AppMethodBeat.i(182868);
                Log.i(str, String.format(str2, objArr));
                AppMethodBeat.o(182868);
            }

            @Override // com.tencent.f.d.a
            public final void w(String str, String str2, Object... objArr) {
                AppMethodBeat.i(182869);
                Log.w(str, String.format(str2, objArr));
                AppMethodBeat.o(182869);
            }

            @Override // com.tencent.f.d.a
            public final void e(String str, String str2, Object... objArr) {
                AppMethodBeat.i(182870);
                Log.e(str, String.format(str2, objArr));
                AppMethodBeat.o(182870);
            }
        });
        cVar.a(new d.f() {
            /* class com.tencent.mm.booter.aa.AnonymousClass2 */

            @Override // com.tencent.f.d.f
            public final void a(Thread thread, String str, long j2) {
                AppMethodBeat.i(182871);
                Log.i("MicroMsg.ThreadBootDelegate", "[onInterrupt] name=" + str + " id=" + j2);
                AppMethodBeat.o(182871);
            }

            @Override // com.tencent.f.d.f
            public final void b(Thread thread, String str, long j2) {
                AppMethodBeat.i(182872);
                Log.i("MicroMsg.ThreadBootDelegate", "[onThreadStart] name=" + str + " id=" + j2);
                AppMethodBeat.o(182872);
            }

            @Override // com.tencent.f.d.f
            public final void c(Thread thread, String str, long j2) {
                AppMethodBeat.i(182873);
                Log.i("MicroMsg.ThreadBootDelegate", "[onThreadExit] name=" + str + " id=" + j2);
                AppMethodBeat.o(182873);
            }
        });
        cVar.a(new d.e() {
            /* class com.tencent.mm.booter.aa.AnonymousClass3 */

            @Override // com.tencent.f.d.e
            public final void a(String str, int i2, f fVar, long j2, long j3, String str2, boolean z) {
                long j4 = 0;
                AppMethodBeat.i(185080);
                if (fVar == f.CREATED) {
                    StringBuilder append = new StringBuilder("====== ").append(str).append("@").append(i2).append(" state=").append(fVar).append(" delay=");
                    if (j2 >= 0) {
                        j4 = j2 / TimeUtil.SECOND_TO_US;
                    }
                    Log.i("MicroMsg.ThreadBootDelegate", append.append(j4).append(LocaleUtil.MALAY).toString());
                    AppMethodBeat.o(185080);
                } else if (fVar == f.RUNNING) {
                    Log.i("MicroMsg.ThreadBootDelegate", ">>>>>> " + str + "@" + i2 + " state=" + fVar + " pool=" + str2);
                    AppMethodBeat.o(185080);
                } else if (fVar == f.COMPLETE) {
                    Log.i("MicroMsg.ThreadBootDelegate", "<<<<<< " + str + "@" + i2 + " state=" + fVar + " cost=" + j2 + "ms pool=" + str2);
                    AppMethodBeat.o(185080);
                } else if (fVar == f.CANCEL) {
                    Log.i("MicroMsg.ThreadBootDelegate", "|||||| " + str + "@" + i2 + " state=" + fVar);
                    AppMethodBeat.o(185080);
                } else {
                    if (fVar == f.THROW) {
                        Log.i("MicroMsg.ThreadBootDelegate", "****** " + str + "@" + i2 + " state=" + fVar);
                    }
                    AppMethodBeat.o(185080);
                }
            }

            @Override // com.tencent.f.d.e
            public final void a(String str, int i2, Throwable th) {
                AppMethodBeat.i(182875);
                Log.e("MicroMsg.ThreadBootDelegate", str + "@" + i2 + " " + th);
                AppMethodBeat.o(182875);
            }

            @Override // com.tencent.f.d.e
            public final void a(String str, int i2, int i3, long j2, String str2) {
                AppMethodBeat.i(182876);
                Log.w("MicroMsg.ThreadBootDelegate", "[wait] " + str + "@" + i2 + " runningCount=" + i3 + " waitFor=" + (j2 / 100000) + "ms pool=" + str2);
                AppMethodBeat.o(182876);
            }

            @Override // com.tencent.f.d.e
            public final void g(String str, int i2, String str2) {
            }

            @Override // com.tencent.f.d.e
            public final void shutdown() {
                AppMethodBeat.i(182877);
                Log.w("MicroMsg.ThreadBootDelegate", "shutdown");
                AppMethodBeat.o(182877);
            }
        });
        AppMethodBeat.o(182888);
    }

    @Override // com.tencent.f.g.a
    public final com.tencent.f.a a(a.C0134a aVar) {
        AppMethodBeat.i(182889);
        if (MMApplicationContext.isMainProcess()) {
            com.tencent.f.a b2 = a.MAIN_PROCESS.b(aVar);
            AppMethodBeat.o(182889);
            return b2;
        } else if (MMApplicationContext.isToolsProcess()) {
            com.tencent.f.a b3 = a.TOOL_PROCESS.b(aVar);
            AppMethodBeat.o(182889);
            return b3;
        } else {
            com.tencent.f.a b4 = a.OTHER.b(aVar);
            AppMethodBeat.o(182889);
            return b4;
        }
    }
}
