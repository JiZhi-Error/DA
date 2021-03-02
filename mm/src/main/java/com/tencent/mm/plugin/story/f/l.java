package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.ac.c;
import com.tencent.mm.b.g;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.s;
import java.util.Comparator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.n.d;
import kotlin.o;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0018\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\u001a\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\u001fJ\u000e\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004J\u0006\u0010&\u001a\u00020\u0004J\u001c\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020(0'2\u0006\u0010)\u001a\u00020\u0004H\u0002J\u0012\u0010*\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010,\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010-\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010\u0004H\u0007J\u0006\u0010.\u001a\u00020\u001fJ\u000e\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u00020\u0004J\u0012\u00101\u001a\u00020\"2\b\u00102\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u00103\u001a\u00020\u00042\b\u00104\u001a\u0004\u0018\u00010\u0004J\u0006\u00105\u001a\u00020\u001fJ\u0006\u00106\u001a\u00020\u001fJ\u001a\u00107\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u00108\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\u00042\b\u00104\u001a\u0004\u0018\u00010\u0004J\u001a\u0010:\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\u00042\b\u00104\u001a\u0004\u0018\u00010\u0004J\u0010\u0010;\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004J\u001a\u0010<\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010=\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\u00042\b\u00104\u001a\u0004\u0018\u00010\u0004J\u0010\u0010>\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004J\u0010\u0010?\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006@"}, hxF = {"Lcom/tencent/mm/plugin/story/model/StoryFileNameUtil;", "", "()V", "MIX_AUDIO_FILE", "", "MIX_CP_DIR", "MIX_DIR", "MIX_THUMB_FILE", "MIX_VIDEO_FILE", "PICFILE", "PIC_FILE", "TAG", "TMP_FILE", "UP_FILE", "VIDEOFILE", "VIDEO_FILE", "selfName", "getSelfName", "()Ljava/lang/String;", "setSelfName", "(Ljava/lang/String;)V", "accMixStoryPath", "accPath", "audioEnsurePath", "parentPath", "mediaId", "autoPath", "user", "cachePath", "checkSelfName", "checkToCreateDir", "", "newVideoPath", "noMedia", "", "cleanFiles", "copyCacheDir", "path", "dumpCacheDir", "Lkotlin/Pair;", "", "subDir", "getMixAudioPath", ch.COL_LOCALID, "getMixThumbPath", "getMixVideoPath", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "isNoMedia", "name", "isSelf", "userName", "primaryPathVideoPath", ch.COL_USERNAME, "reset", "testCreateFiles", "thumbEnsurePath", "thumbPath", "url", "thumbPathInDownload", "thumbPathInUpload", "videoEnsurePath", "videoPath", "videoPathInDownload", "videoPathInUpload", "plugin-story_release"})
public final class l {
    public static final l FmK = new l();
    private static String gna = "";

    static {
        AppMethodBeat.i(118740);
        AppMethodBeat.o(118740);
    }

    private l() {
    }

    public static void reset() {
        gna = "";
    }

    /* renamed from: for  reason: not valid java name */
    static String m31for() {
        AppMethodBeat.i(118725);
        j.b bVar = j.Fmy;
        String accStoryPath = j.b.getAccStoryPath();
        AppMethodBeat.o(118725);
        return accStoryPath;
    }

    static String fos() {
        AppMethodBeat.i(118726);
        j.b bVar = j.Fmy;
        String accStoryCachePath = j.b.getAccStoryCachePath();
        AppMethodBeat.o(118726);
        return accStoryCachePath;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    public static final class a<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(118724);
            int a2 = kotlin.b.a.a(Long.valueOf(t.RbI), Long.valueOf(t2.RbI));
            AppMethodBeat.o(118724);
            return a2;
        }
    }

    public static String jF(String str, String str2) {
        AppMethodBeat.i(118728);
        if (str2 == null) {
            AppMethodBeat.o(118728);
            return "";
        }
        String k = s.k(str + str2 + ".p", true);
        if (k == null) {
            p.hyc();
        }
        AppMethodBeat.o(118728);
        return k;
    }

    private static String kW(String str, String str2) {
        AppMethodBeat.i(118729);
        if (str2 == null) {
            AppMethodBeat.o(118729);
            return "";
        }
        String k = s.k(str + str2 + ".v", true);
        if (k == null) {
            p.hyc();
        }
        AppMethodBeat.o(118729);
        return k;
    }

    public final String kX(String str, String str2) {
        AppMethodBeat.i(118730);
        if (str == null) {
            AppMethodBeat.o(118730);
            return "";
        }
        byte[] bytes = str.getBytes(d.UTF_8);
        p.g(bytes, "(this as java.lang.String).getBytes(charset)");
        String jF = jF(aRU(str2) + "pic/", g.getMessageDigest(bytes));
        AppMethodBeat.o(118730);
        return jF;
    }

    public final String kY(String str, String str2) {
        AppMethodBeat.i(118731);
        if (str == null) {
            AppMethodBeat.o(118731);
            return "";
        }
        byte[] bytes = str.getBytes(d.UTF_8);
        p.g(bytes, "(this as java.lang.String).getBytes(charset)");
        String kW = kW(aRU(str2) + "video/", g.getMessageDigest(bytes));
        AppMethodBeat.o(118731);
        return kW;
    }

    public static String aRV(String str) {
        AppMethodBeat.i(118732);
        if (str == null) {
            AppMethodBeat.o(118732);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        j.b bVar = j.Fmy;
        String sb2 = sb.append(jF(j.b.getAccStoryPath(), str)).append(".u").toString();
        AppMethodBeat.o(118732);
        return sb2;
    }

    public static String aRW(String str) {
        AppMethodBeat.i(118733);
        if (str == null) {
            AppMethodBeat.o(118733);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        j.b bVar = j.Fmy;
        String sb2 = sb.append(kW(j.b.getAccStoryPath(), str)).append(".u").toString();
        AppMethodBeat.o(118733);
        return sb2;
    }

    public static /* synthetic */ void aRX(String str) {
        AppMethodBeat.i(118735);
        aLP(str);
        AppMethodBeat.o(118735);
    }

    public static void aLP(String str) {
        AppMethodBeat.i(118734);
        p.h(str, "newVideoPath");
        if (str.length() == 0) {
            AppMethodBeat.o(118734);
            return;
        }
        String boZ = s.boZ(str);
        s.boN(boZ);
        s.bpc(boZ);
        AppMethodBeat.o(118734);
    }

    public static boolean awg(String str) {
        AppMethodBeat.i(118736);
        p.h(str, "name");
        if (p.j(FilePathGenerator.NO_MEDIA_FILENAME, str)) {
            AppMethodBeat.o(118736);
            return true;
        }
        AppMethodBeat.o(118736);
        return false;
    }

    public static String fot() {
        AppMethodBeat.i(118737);
        new c("dumpCacheDir");
        o<String, Long> aRY = aRY("pic/");
        o<String, Long> aRY2 = aRY("video/");
        String str = ((String) aRY.first) + "  " + ((String) aRY2.first) + " total: " + Util.getSizeMB(aRY2.second.longValue() + aRY.second.longValue());
        AppMethodBeat.o(118737);
        return str;
    }

    private static o<String, Long> aRY(String str) {
        AppMethodBeat.i(118738);
        c cVar = new c("dumpCacheDir");
        StringBuilder sb = new StringBuilder();
        j.b bVar = j.Fmy;
        String sb2 = sb.append(j.b.getAccStoryCachePath()).append(str).toString();
        Log.i("MicroMsg.StoryFileNameUtil", "dumpCacheDir cache ".concat(String.valueOf(sb2)));
        Iterable<e> dC = s.dC(sb2, true);
        List c2 = dC != null ? aa.c(dC) : null;
        if (c2 != null && c2.size() > 1) {
            kotlin.a.j.a(c2, (Comparator) new a());
        }
        long j2 = 0;
        if (c2 != null) {
            int i2 = 0;
            for (Object obj : c2) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    kotlin.a.j.hxH();
                }
                e eVar = (e) obj;
                if (eVar != null) {
                    Log.i("MicroMsg.StoryFileNameUtil", "dumpCacheDir " + i2 + " filePath: " + eVar.name + " time: " + eVar.RbI + " size: " + Util.getSizeKB(eVar.size) + ' ' + eVar.NGP);
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
        String sb3 = new StringBuilder("dumpCacheDir ").append(str).append(" totalSize ").append(Util.getSizeKB(j2)).append(" fileCounts ").append(c2 != null ? Integer.valueOf(c2.size()) : null).append(" cost:").append(cVar).append(" \n").toString();
        Log.i("MicroMsg.StoryFileNameUtil", sb3);
        o<String, Long> oVar = new o<>(sb3, Long.valueOf(j2));
        AppMethodBeat.o(118738);
        return oVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String aRU(java.lang.String r4) {
        /*
            r3 = 118727(0x1cfc7, float:1.66372E-40)
            r1 = 1
            r2 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            r0 = r4
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0013
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0048
        L_0x0013:
            r0 = r1
        L_0x0014:
            if (r0 != 0) goto L_0x003b
            java.lang.String r0 = com.tencent.mm.plugin.story.f.l.gna
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0022
            int r0 = r0.length()
            if (r0 != 0) goto L_0x004a
        L_0x0022:
            r0 = r1
        L_0x0023:
            if (r0 == 0) goto L_0x004e
            java.lang.String r0 = com.tencent.mm.plugin.story.f.l.gna
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0031
            int r0 = r0.length()
            if (r0 != 0) goto L_0x004c
        L_0x0031:
            if (r1 == 0) goto L_0x003b
            com.tencent.mm.plugin.story.f.j$b r0 = com.tencent.mm.plugin.story.f.j.Fmy
            java.lang.String r0 = com.tencent.mm.plugin.story.f.j.b.fau()
            com.tencent.mm.plugin.story.f.l.gna = r0
        L_0x003b:
            r0 = r2
        L_0x003c:
            if (r0 == 0) goto L_0x0058
            com.tencent.mm.plugin.story.f.j$b r0 = com.tencent.mm.plugin.story.f.j.Fmy
            java.lang.String r0 = com.tencent.mm.plugin.story.f.j.b.getAccStoryPath()
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
        L_0x0047:
            return r0
        L_0x0048:
            r0 = r2
            goto L_0x0014
        L_0x004a:
            r0 = r2
            goto L_0x0023
        L_0x004c:
            r1 = r2
            goto L_0x0031
        L_0x004e:
            java.lang.String r0 = com.tencent.mm.plugin.story.f.l.gna
            boolean r0 = kotlin.g.b.p.j(r0, r4)
            if (r0 == 0) goto L_0x003b
            r0 = r1
            goto L_0x003c
        L_0x0058:
            com.tencent.mm.plugin.story.f.j$b r0 = com.tencent.mm.plugin.story.f.j.Fmy
            java.lang.String r0 = com.tencent.mm.plugin.story.f.j.b.getAccStoryCachePath()
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            goto L_0x0047
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.f.l.aRU(java.lang.String):java.lang.String");
    }

    public static void fou() {
        AppMethodBeat.i(118739);
        j.b bVar = j.Fmy;
        String accStoryCachePath = j.b.getAccStoryCachePath();
        Log.i("MicroMsg.StoryFileNameUtil", "dumpCacheDir cache ".concat(String.valueOf(accStoryCachePath)));
        Iterable<e> dC = s.dC(accStoryCachePath, true);
        for (int i2 = 0; i2 < 100; i2++) {
            if (dC != null) {
                int i3 = 0;
                for (e eVar : dC) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        kotlin.a.j.hxH();
                    }
                    e eVar2 = eVar;
                    String str = eVar2.name;
                    p.g(str, "it.name");
                    if (!awg(str)) {
                        s.nw(eVar2.NGP, eVar2.NGP + System.currentTimeMillis());
                        if (i3 > 2) {
                            break;
                        }
                        i3 = i4;
                    } else {
                        i3 = i4;
                    }
                }
            }
        }
        Log.i("MicroMsg.StoryFileNameUtil", "testCreateFiles done cache ".concat(String.valueOf(accStoryCachePath)));
        AppMethodBeat.o(118739);
    }
}
