package com.tencent.mm.plugin.story.f.d;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.j;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u00020\u0001:\u0001*B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0013\u0010'\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010)\u001a\u00020\nH\u0016R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyTImeline", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "storyItemScene", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;)V", "TAG", "", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "getComment", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryComment;", "getStory", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyId", "", "getStoryId", "()J", "getStoryItemScene", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "getStoryTImeline", "()Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "userName", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "getVideoItem", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "convertFromFakeDB", "", "videoEditData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "convertFromStoryInfo", "equals", FacebookRequestErrorClassification.KEY_OTHER, "toString", "Companion", "plugin-story_release"})
public final class h {
    public static final a FoY = new a((byte) 0);
    public final j FoT;
    public final g FoU;
    public final j FoV;
    private final eek FoW;
    public final i FoX;
    private final String TAG;
    public final long edx;
    public String userName;

    static {
        AppMethodBeat.i(118932);
        AppMethodBeat.o(118932);
    }

    public /* synthetic */ h(j jVar, eek eek) {
        this(jVar, eek, i.NORMAL);
        AppMethodBeat.i(118931);
        AppMethodBeat.o(118931);
    }

    public h(j jVar, eek eek, i iVar) {
        p.h(jVar, "story");
        p.h(eek, "storyTImeline");
        p.h(iVar, "storyItemScene");
        AppMethodBeat.i(118930);
        this.FoV = jVar;
        this.FoW = eek;
        this.FoX = iVar;
        this.TAG = "MicroMsg.StoryGalleryItem";
        this.edx = this.FoV.field_storyID;
        int i2 = (int) this.FoV.systemRowid;
        long j2 = this.FoV.field_storyID;
        int i3 = this.FoV.field_createTime;
        String str = this.FoV.field_userName;
        j jVar2 = new j(i2, j2, i3, str == null ? "" : str);
        eek eek2 = this.FoW;
        if (eek2.NeB.LoV.size() > 0) {
            edt edt = eek2.NeB.LoV.get(0);
            p.g(edt, "timeline.ContentObj.MediaObjList[0]");
            edt edt2 = edt;
            p.h(edt2, "<set-?>");
            jVar2.Fpd = edt2;
        }
        jVar2.BKf = eek2.NeA;
        this.FoT = jVar2;
        this.FoU = new g();
        a(this.FoV);
        AppMethodBeat.o(118930);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem$Companion;", "", "()V", "createStoryGalleryItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", IssueStorage.COLUMN_EXT_INFO, "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyItemScene", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "createStoryGalleryItemForSns", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static /* synthetic */ h b(j jVar) {
            AppMethodBeat.i(118920);
            h a2 = a(jVar, i.NORMAL);
            AppMethodBeat.o(118920);
            return a2;
        }

        public static h a(j jVar, i iVar) {
            AppMethodBeat.i(118919);
            p.h(jVar, "story");
            p.h(iVar, "storyItemScene");
            h hVar = new h(jVar, jVar.frG(), iVar);
            AppMethodBeat.o(118919);
            return hVar;
        }

        public static h a(f fVar) {
            AppMethodBeat.i(118921);
            p.h(fVar, IssueStorage.COLUMN_EXT_INFO);
            j jVar = new j();
            jVar.field_storyID = fVar.field_syncId;
            jVar.field_createTime = fVar.field_storyPostTime;
            jVar.field_userName = fVar.getUserName();
            q.a aVar = q.FmO;
            eek fox = q.a.fox();
            fox.UserName = fVar.getUserName();
            fox.CreateTime = fVar.field_storyPostTime;
            q.a aVar2 = q.FmO;
            edt edt = new edt();
            edt.Id = "empty_" + cl.aWz();
            edt.Msz = fVar.aBE();
            edt.Url = fVar.frx();
            edt.Ned = fVar.field_duration > 0 ? (float) (((double) fVar.field_duration) / 1000.0d) : 0.0f;
            fox.NeB.LoV.add(edt);
            jVar.c(fox);
            h hVar = new h(jVar, fox);
            AppMethodBeat.o(118921);
            return hVar;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:83:0x020a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean a(com.tencent.mm.plugin.story.i.j r13) {
        /*
        // Method dump skipped, instructions count: 713
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.f.d.h.a(com.tencent.mm.plugin.story.i.j):boolean");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    public static final class b<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(118922);
            int a2 = kotlin.b.a.a(Integer.valueOf(t.iXu), Integer.valueOf(t2.iXu));
            AppMethodBeat.o(118922);
            return a2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    public static final class c<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(118923);
            int a2 = kotlin.b.a.a(Integer.valueOf(t.iXu), Integer.valueOf(t2.iXu));
            AppMethodBeat.o(118923);
            return a2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    public static final class d<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(118924);
            int a2 = kotlin.b.a.a(Integer.valueOf(t.iXu), Integer.valueOf(t2.iXu));
            AppMethodBeat.o(118924);
            return a2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    public static final class e<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(118925);
            int a2 = kotlin.b.a.a(Integer.valueOf(t.iXu), Integer.valueOf(t2.iXu));
            AppMethodBeat.o(118925);
            return a2;
        }
    }

    private final boolean c(com.tencent.mm.plugin.recordvideo.background.c cVar) {
        AppMethodBeat.i(118927);
        aio aio = new aio();
        try {
            aio.parseFrom(cVar.field_baseItemData);
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
            aio = null;
        }
        aio aio2 = aio;
        if (aio2 != null) {
            j jVar = this.FoT;
            k kVar = k.Fake;
            p.h(kVar, "<set-?>");
            jVar.Fpc = kVar;
            j jVar2 = this.FoT;
            String bjl = cVar.bjl();
            p.h(bjl, "<set-?>");
            jVar2.taskId = bjl;
            this.FoT.Fpd.Msz = aio2.thumbPath;
            this.FoT.Fpd.Id = "fake_" + aio2.timeStamp;
            this.FoT.BKf = aio2.BPU;
            if (!s.YS(aio2.videoPath) && aio2.Lsc.size() == 0 && aio2.Lsd == null) {
                com.tencent.mm.plugin.story.f.e.a aVar = com.tencent.mm.plugin.story.f.e.a.Fpl;
                com.tencent.mm.plugin.story.f.e.a.aLh(cVar.bjl());
                AppMethodBeat.o(118927);
                return false;
            }
            if (aio2.Lsc.size() > 0) {
                Iterator<String> it = aio2.Lsc.iterator();
                while (it.hasNext()) {
                    if (!s.YS(it.next())) {
                        com.tencent.mm.plugin.story.f.e.a aVar2 = com.tencent.mm.plugin.story.f.e.a.Fpl;
                        com.tencent.mm.plugin.story.f.e.a.aLh(cVar.bjl());
                        AppMethodBeat.o(118927);
                        return false;
                    }
                }
            }
            this.FoT.Fpe = cVar;
            AppMethodBeat.o(118927);
            return true;
        }
        AppMethodBeat.o(118927);
        return false;
    }

    public final String toString() {
        AppMethodBeat.i(118928);
        String str = "StoryGalleryItem(videoItem=" + this.FoT + ", comment=" + this.FoU + ')';
        AppMethodBeat.o(118928);
        return str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(118929);
        if (!(obj instanceof h)) {
            AppMethodBeat.o(118929);
            return false;
        } else if (this == obj) {
            AppMethodBeat.o(118929);
            return true;
        } else if (this.edx != ((h) obj).edx || !p.j(this.FoT, ((h) obj).FoT) || !p.j(this.FoU, ((h) obj).FoU) || this.FoV.frI().ibG != ((h) obj).FoV.frI().ibG) {
            AppMethodBeat.o(118929);
            return false;
        } else {
            AppMethodBeat.o(118929);
            return true;
        }
    }
}
