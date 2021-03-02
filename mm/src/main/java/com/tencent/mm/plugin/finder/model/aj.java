package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.spam.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.g;
import com.tencent.mm.plugin.finder.upload.action.j;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cng;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J>\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fJT\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000fJ\u001e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/FinderLikeLogic;", "", "()V", "TAG", "", "likeComment", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "feedId", "", "objectNonceId", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "like", "", "scene1", "", "isPoster", "likeFeed", "likeAction", ch.COL_FINDEROBJECT, "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isPrivate", "scene", "isShowRecWording", "preIsPrivate", "fromPrivateAccount", "likeMegaVideo", "context", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder_release"})
public final class aj {
    private static final String TAG = TAG;
    public static final aj uOw = new aj();

    static {
        AppMethodBeat.i(166395);
        AppMethodBeat.o(166395);
    }

    private aj() {
    }

    public static /* synthetic */ void a(bbn bbn, FinderItem finderItem, boolean z) {
        AppMethodBeat.i(248768);
        a(bbn, 1, finderItem, z, false, 2, false, false, false);
        AppMethodBeat.o(248768);
    }

    public static void a(bbn bbn, int i2, FinderItem finderItem, boolean z, boolean z2, int i3, boolean z3, boolean z4, boolean z5) {
        AppMethodBeat.i(248767);
        p.h(bbn, "contextObj");
        p.h(finderItem, ch.COL_FINDEROBJECT);
        a aVar = a.vwk;
        if (a.avp("like")) {
            AppMethodBeat.o(248767);
            return;
        }
        e.INSTANCE.idkeyStat(1278, z ? 0 : 1, 1, false);
        int i4 = z ? 2 : 1;
        int i5 = (z2 || z4) ? 6 : 1;
        g gVar = g.vGW;
        boolean z6 = !z5 && !z2 && !z4 && g.Lj(finderItem.getFeedObject().objectType) != null;
        k kVar = k.vfA;
        long id = finderItem.getId();
        int i6 = z6 ? 1 : 0;
        cng megaVideo = finderItem.getMegaVideo();
        k.a(bbn, id, i5, i4, i2, "", i3, z3, z5, i6, megaVideo != null ? megaVideo.id : 0);
        j.a aVar2 = j.vUw;
        j.a(j.vUv, finderItem, z, z2, i3, bbn);
        AppMethodBeat.o(248767);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.tencent.mm.protocal.protobuf.bbn r13, long r14, java.lang.String r16, com.tencent.mm.plugin.finder.storage.an r17, boolean r18, int r19, boolean r20) {
        /*
        // Method dump skipped, instructions count: 175
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.model.aj.a(com.tencent.mm.protocal.protobuf.bbn, long, java.lang.String, com.tencent.mm.plugin.finder.storage.an, boolean, int, boolean):void");
    }
}
