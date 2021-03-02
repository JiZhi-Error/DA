package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.s;
import java.util.Comparator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002R\u000e\u0010\u000b\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/FinderFolder;", "", "path", "", "name", "maxSize", "", "markNoMedia", "", "enableClear", "(Ljava/lang/String;Ljava/lang/String;JZZ)V", "TAG", "getEnableClear", "()Z", "getMarkNoMedia", "getMaxSize", "()J", "getName", "()Ljava/lang/String;", "getPath", "dumpCacheDir", "Lkotlin/Pair;", "initFolder", "", "isNoMedia", "plugin-finder_release"})
public final class i {
    private final String TAG;
    final long maxSize;
    final String name;
    public final String path;
    private final boolean vVx;
    final boolean vVy;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(String str, String str2, long j2, boolean z, int i2) {
        this(str, str2, j2, false, (i2 & 16) != 0 ? true : z);
        AppMethodBeat.i(167886);
        AppMethodBeat.o(167886);
    }

    public i(String str, String str2, long j2, boolean z, boolean z2) {
        p.h(str, "path");
        p.h(str2, "name");
        AppMethodBeat.i(167885);
        this.path = str;
        this.name = str2;
        this.maxSize = j2;
        this.vVx = z;
        this.vVy = z2;
        this.TAG = "Finder.FinderFolder";
        AppMethodBeat.o(167885);
    }

    public final void dBE() {
        AppMethodBeat.i(167883);
        s.boN(this.path);
        if (this.vVx) {
            s.bpc(this.path);
        }
        AppMethodBeat.o(167883);
    }

    public final o<String, Long> dBF() {
        AppMethodBeat.i(167884);
        c cVar = new c("dumpCacheDir");
        String str = this.path;
        Log.i(this.TAG, "dumpCacheDir cache ".concat(String.valueOf(str)));
        Iterable<e> dC = s.dC(str, true);
        List c2 = dC != null ? aa.c(dC) : null;
        if (c2 != null && c2.size() > 1) {
            j.a(c2, (Comparator) new a());
        }
        long j2 = 0;
        if (c2 != null) {
            int i2 = 0;
            for (Object obj : c2) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    j.hxH();
                }
                e eVar = (e) obj;
                if (eVar != null) {
                    String str2 = eVar.name;
                    p.g(str2, "fileEntry.name");
                    if (!awg(str2)) {
                        j2 += eVar.size;
                    } else {
                        i2 = i3;
                    }
                }
                i2 = i3;
            }
        }
        String sb = new StringBuilder("dump ").append(this.name).append(" fileCounts ").append(c2 != null ? Integer.valueOf(c2.size()) : null).append(", cost: ").append(cVar.hvh.apr()).append("ms, totalSize ").append(Util.getSizeKB(j2)).append(" \n").toString();
        Log.i(this.TAG, sb);
        o<String, Long> oVar = new o<>(sb, Long.valueOf(j2));
        AppMethodBeat.o(167884);
        return oVar;
    }

    private static boolean awg(String str) {
        AppMethodBeat.i(253394);
        if (p.j(FilePathGenerator.NO_MEDIA_FILENAME, str)) {
            AppMethodBeat.o(253394);
            return true;
        }
        AppMethodBeat.o(253394);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    public static final class a<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(167882);
            int a2 = kotlin.b.a.a(Long.valueOf(t.RbI), Long.valueOf(t2.RbI));
            AppMethodBeat.o(167882);
            return a2;
        }
    }
}
