package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.plugin.story.f.i;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.s;
import java.util.Comparator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ \u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/story/model/CleanVideoTask;", "", "()V", "MAX_COUNT", "", "MAX_STORY_SIZE", "TAG", "", "getTAG", "()Ljava/lang/String;", "isRun", "", "cancel", "", "cleanCacheFiles", "subDir", "maxStoryCache", "maxStoryCount", "plugin-story_release"})
public final class a {
    boolean DGJ = true;
    final int FlB = 314572800;
    final int MAX_COUNT = 100;
    final String TAG = "MicroMsg.GalleryMgr";

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    /* renamed from: com.tencent.mm.plugin.story.f.a$a  reason: collision with other inner class name */
    public static final class C1748a<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(118628);
            int a2 = kotlin.b.a.a(Long.valueOf(t.RbI), Long.valueOf(t2.RbI));
            AppMethodBeat.o(118628);
            return a2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ a FlC;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar) {
            super(0);
            this.FlC = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(118629);
            try {
                a.a(this.FlC, "pic/", this.FlC.FlB / 10, this.FlC.MAX_COUNT);
                a.a(this.FlC, "video/", this.FlC.FlB, this.FlC.MAX_COUNT);
            } catch (Exception e2) {
                Log.printErrStackTrace(this.FlC.TAG, e2, "", new Object[0]);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(118629);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(a aVar, String str, int i2, int i3) {
        List<e> c2;
        AppMethodBeat.i(118630);
        c cVar = new c("dumpCacheDir ".concat(String.valueOf(str)));
        StringBuilder sb = new StringBuilder();
        j.b bVar = j.Fmy;
        String sb2 = sb.append(j.b.getAccStoryCachePath()).append(str).toString();
        Iterable<e> dC = s.dC(sb2, true);
        if (dC == null || (c2 = aa.c(dC)) == null) {
            AppMethodBeat.o(118630);
            return;
        }
        p.g(c2, "VFSFileOp.listFiles(cach…              } ?: return");
        if (c2.size() > 1) {
            kotlin.a.j.a(c2, (Comparator) new C1748a());
        }
        long j2 = 0;
        for (e eVar : c2) {
            j2 = (eVar != null ? eVar.size : 0) + j2;
        }
        long j3 = j2 > ((long) i2) ? (long) (((double) j2) / 2.0d) : 0;
        int size = c2.size();
        int i4 = size > i3 ? i3 - size : 0;
        Log.i(aVar.TAG, "cleanCacheFiles cache " + sb2 + "  sumSize:" + j2 + " targetSize:" + j3 + "  targetCount" + i4);
        long j4 = 0;
        a aVar2 = aVar;
        int i5 = 0;
        long j5 = j3;
        for (Object obj : c2) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                kotlin.a.j.hxH();
            }
            e eVar2 = (e) obj;
            if (eVar2 != null) {
                if (!aVar2.DGJ) {
                    break;
                }
                l lVar = l.FmK;
                String str2 = eVar2.name;
                p.g(str2, "fileEntry.name");
                if (!l.awg(str2)) {
                    long milliSecondsToNow = Util.milliSecondsToNow(eVar2.RbI);
                    i.a aVar3 = i.Fmb;
                    if (milliSecondsToNow <= ((long) (i.FlY * 1000))) {
                        break;
                    }
                    Log.i(aVar2.TAG, "cleanCacheFiles1 " + i5 + " filePath: " + eVar2.name + " time: " + eVar2.RbI + " size: " + Util.getSizeKB(eVar2.size));
                    long j6 = eVar2.size + j4;
                    j5 -= eVar2.size;
                    i4--;
                    s.deleteFile(eVar2.NGP);
                    j4 = j6;
                    i5 = i6;
                } else {
                    i5 = i6;
                }
            } else {
                i5 = i6;
            }
        }
        if (j5 > 0 || i4 > 0) {
            a aVar4 = aVar;
            if (c2 != null) {
                int i7 = 0;
                for (Object obj2 : c2) {
                    int i8 = i7 + 1;
                    if (i7 < 0) {
                        kotlin.a.j.hxH();
                    }
                    e eVar3 = (e) obj2;
                    if (eVar3 != null) {
                        if (!aVar4.DGJ) {
                            break;
                        }
                        Log.i(aVar4.TAG, "cleanCacheFiles2 " + i7 + " filePath: " + eVar3.name + " time: " + eVar3.RbI + " size: " + Util.getSizeKB(eVar3.size));
                        l lVar2 = l.FmK;
                        String str3 = eVar3.name;
                        p.g(str3, "fileEntry.name");
                        if (!l.awg(str3)) {
                            j4 += eVar3.size;
                            j5 -= eVar3.size;
                            i4--;
                            s.deleteFile(eVar3.NGP);
                            if (j5 <= 0 && i4 <= 0) {
                                break;
                            }
                        } else {
                            i7 = i8;
                        }
                    }
                    i7 = i8;
                }
            }
        }
        Log.i(aVar.TAG, "cleanCacheFiles totalSize " + Util.getSizeKB(j2) + " newsize " + (j2 - j4) + " fileSize:" + c2.size() + " cost:" + cVar);
        AppMethodBeat.o(118630);
    }
}
