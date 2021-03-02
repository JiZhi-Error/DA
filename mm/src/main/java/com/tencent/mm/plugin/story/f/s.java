package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.story.f.d.j;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0017\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/story/model/StoryVideoLogic;", "", "()V", "STORY_VIDEO_PREFIX", "", "TAG", "createForFake", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "createForPost", "", "storyId", "", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", ch.COL_USERNAME, "genCdnMediaId", "createTime", "", "url", "genFileName", "snsLocalId", "getOrCreate", "getStoryVideoDir", "getStoryVideoPath", "getStoryVideoTmpPath", "plugin-story_release"})
public final class s {
    private static final String Fnx = Fnx;
    public static final s Fny = new s();
    private static final String TAG = TAG;

    static {
        AppMethodBeat.i(118795);
        AppMethodBeat.o(118795);
    }

    private s() {
    }

    public static String cs(int i2, String str) {
        String a2;
        AppMethodBeat.i(118789);
        if (str == null) {
            a2 = "story_local_video_".concat(String.valueOf(i2));
        } else {
            a2 = c.a("storyvideo", (long) i2, "story", str);
        }
        if (Util.isNullOrNil(a2)) {
            AppMethodBeat.o(118789);
            return null;
        }
        AppMethodBeat.o(118789);
        return a2;
    }

    public static String aSc(String str) {
        AppMethodBeat.i(118790);
        l lVar = l.FmK;
        String k = com.tencent.mm.vfs.s.k(l.aRU(str) + "video/", true);
        if (k == null) {
            p.hyc();
        }
        Log.i(TAG, "get story video dir %s username %s", k, str);
        AppMethodBeat.o(118790);
        return k;
    }

    public static String a(edt edt, String str) {
        AppMethodBeat.i(118791);
        if (edt == null) {
            AppMethodBeat.o(118791);
            return null;
        }
        String kY = l.FmK.kY(edt.Url, str);
        Log.i(TAG, "get story video path %s", kY);
        AppMethodBeat.o(118791);
        return kY;
    }

    public static String a(edt edt) {
        AppMethodBeat.i(118792);
        if (edt == null) {
            AppMethodBeat.o(118792);
            return null;
        }
        l lVar = l.FmK;
        String aRW = l.aRW(edt.Id);
        AppMethodBeat.o(118792);
        return aRW;
    }

    public static n a(j jVar) {
        String str;
        n nVar;
        boolean z;
        AppMethodBeat.i(118793);
        p.h(jVar, "videoItem");
        if (jVar.foV()) {
            n b2 = b(jVar);
            AppMethodBeat.o(118793);
            return b2;
        }
        String a2 = a(jVar.Fpd, jVar.username);
        l lVar = l.FmK;
        if (a2 == null) {
            str = "";
        } else {
            str = a2;
        }
        l.aLP(str);
        j.b bVar = j.Fmy;
        n KC = j.b.fog().KC(jVar.edx);
        if (KC == null) {
            n nVar2 = new n();
            nVar2.field_storyId = jVar.edx;
            nVar2.field_url = jVar.Fpd.Url;
            nVar2.field_cacheSize = 0;
            nVar2.field_totalSize = 0;
            nVar2.field_filePath = a2;
            j.b bVar2 = j.Fmy;
            j.b.fog().a(nVar2);
            nVar = nVar2;
        } else {
            nVar = KC;
        }
        String str2 = nVar.field_filePath;
        if (str2 == null || str2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            nVar.field_filePath = a2;
        }
        AppMethodBeat.o(118793);
        return nVar;
    }

    private static n b(com.tencent.mm.plugin.story.f.d.j jVar) {
        byte[] bArr;
        String str = null;
        AppMethodBeat.i(118794);
        p.h(jVar, "videoItem");
        aio aio = new aio();
        com.tencent.mm.plugin.recordvideo.background.c cVar = jVar.Fpe;
        if (cVar != null) {
            bArr = cVar.field_baseItemData;
        } else {
            bArr = null;
        }
        try {
            aio.parseFrom(bArr);
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
            aio = null;
        }
        aio aio2 = aio;
        if (aio2 != null) {
            str = aio2.videoPath;
        }
        int boW = (int) com.tencent.mm.vfs.s.boW(str);
        n nVar = new n();
        nVar.field_storyId = jVar.edx;
        nVar.field_url = "";
        nVar.field_cacheSize = boW;
        nVar.field_totalSize = boW;
        nVar.field_filePath = str;
        AppMethodBeat.o(118794);
        return nVar;
    }
}
