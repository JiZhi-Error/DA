package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.vfs.o;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.util.Comparator;
import kotlin.a.e;
import kotlin.g.b.p;

public final class i {
    private static int FlY = LocalCache.TIME_DAY;
    private static String FlZ;
    private static final String Fma = (FlZ + "mix/");
    public static final a Fmb = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* renamed from: com.tencent.mm.plugin.story.f.i$a$a */
        public static final class RunnableC1759a implements Runnable {
            public static final RunnableC1759a Fmc = new RunnableC1759a();

            static {
                AppMethodBeat.i(118666);
                AppMethodBeat.o(118666);
            }

            RunnableC1759a() {
            }

            public final void run() {
                AppMethodBeat.i(118665);
                a aVar = i.Fmb;
                o[] het = new o(i.Fma).het();
                if (het != null) {
                    if (het.length > 1) {
                        e.a(het, new C1760a());
                    }
                    int length = het.length;
                    int i2 = 0;
                    int i3 = 0;
                    while (i2 < length) {
                        o oVar = het[i2];
                        int i4 = i3 + 1;
                        if (i3 >= 4) {
                            oVar.delete();
                        }
                        i2++;
                        i3 = i4;
                    }
                }
                AppMethodBeat.o(118665);
            }

            /* renamed from: com.tencent.mm.plugin.story.f.i$a$a$a */
            public static final class C1760a<T> implements Comparator<T> {
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    AppMethodBeat.i(118664);
                    int a2 = kotlin.b.a.a(Long.valueOf(t2.lastModified()), Long.valueOf(t.lastModified()));
                    AppMethodBeat.o(118664);
                    return a2;
                }
            }
        }
    }

    static {
        AppMethodBeat.i(118667);
        StringBuilder sb = new StringBuilder();
        com.tencent.mm.kernel.e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        FlZ = sb.append(aAh.getAccPath()).append("story/").toString();
        AppMethodBeat.o(118667);
    }
}
