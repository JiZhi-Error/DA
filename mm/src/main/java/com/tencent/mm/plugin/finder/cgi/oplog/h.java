package com.tencent.mm.plugin.finder.cgi.oplog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.a.hv;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.finder.cgi.bx;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.v;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ayy;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001 B\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J8\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001dH\u0016J:\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001dH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyFeedSettingService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderModifyFeedSetting;", "Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderOpLogCore;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertToCmdBuf", "Lcom/tencent/mm/protobuf/ByteString;", "kotlin.jvm.PlatformType", "modUserInfo", "getCmdId", "", "handleUpdateResult", "", "cmdBufItem", "retCode", "modifyFeedComment", "feedId", "", "feedObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "objectNonceId", "openComment", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "modifyFeedPrivacy", "ifPrivate", "Companion", "plugin-finder_release"})
public final class h extends k<ayy> implements i, v {
    public static final a txM = new a((byte) 0);
    private final String TAG = "Finder.FinderModifyFeedSettingService";

    static {
        AppMethodBeat.i(165306);
        AppMethodBeat.o(165306);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/oplog/FinderModifyFeedSettingService$Companion;", "", "()V", "CLOSE_COMMENT", "", "OPEN_COMMENT", "SCENE_CLOSE_COMMENT", "SCENE_SET_PRIVATE", "SET_PRIVATE", "SET_PUBLIC", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final /* synthetic */ b di(ayy ayy) {
        AppMethodBeat.i(165304);
        ayy ayy2 = ayy;
        p.h(ayy2, "modUserInfo");
        b cD = b.cD(ayy2.toByteArray());
        AppMethodBeat.o(165304);
        return cD;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int] */
    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final /* synthetic */ void n(ayy ayy, int i2) {
        AppMethodBeat.i(165303);
        ayy ayy2 = ayy;
        p.h(ayy2, "cmdBufItem");
        e.a aVar = e.vFX;
        FinderItem Fy = e.a.Fy(ayy2.LIV);
        if (Fy != null) {
            if (i2 == 0) {
                switch (ayy2.scene) {
                    case 1:
                        Fy.setComment_close(ayy2.dYx);
                        break;
                    case 2:
                        Fy.setPrivate_flag(ayy2.dYx);
                        break;
                }
            }
            hv hvVar = new hv();
            hvVar.dMr.feedId = Fy.getId();
            EventCenter.instance.publish(hvVar);
            Log.i(this.TAG, "FinderExposeInfoChangeEvent " + hvVar.dMr.feedId + ' ' + Fy.getComment_close());
            e.a aVar2 = e.vFX;
            e.a.n(Fy);
            hn hnVar = new hn();
            hnVar.dLW.id = Fy.field_id;
            EventCenter.instance.publish(hnVar);
            AppMethodBeat.o(165303);
            return;
        }
        AppMethodBeat.o(165303);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final String getTAG() {
        return this.TAG;
    }

    @Override // com.tencent.mm.plugin.i.a.v
    public final void a(long j2, FinderObject finderObject, String str, boolean z, ai<ayy> aiVar) {
        int i2;
        int i3 = 1;
        AppMethodBeat.i(165302);
        p.h(finderObject, "feedObj");
        p.h(str, "objectNonceId");
        k kVar = k.vfA;
        if (z) {
            i2 = 2;
        } else {
            i2 = 1;
        }
        p.h(finderObject, ch.COL_FINDEROBJECT);
        String str2 = ((c) g.af(c.class)).cMD() + ',' + i2 + ',' + k.Fg(finderObject.id) + ',' + finderObject.username + ',' + finderObject.likeCount + ',' + finderObject.commentCount + ',' + finderObject.friendLikeCount;
        Log.i(k.TAG, "18952 ".concat(String.valueOf(str2)));
        com.tencent.mm.plugin.report.e.INSTANCE.kvStat(18952, str2);
        ayy ayy = new ayy();
        ayy.LIV = j2;
        ayy.scene = 1;
        if (z) {
            i3 = 0;
        }
        ayy.dYx = i3;
        ayy.objectNonceId = str;
        a(ayy, aiVar, false);
        AppMethodBeat.o(165302);
    }

    @Override // com.tencent.mm.plugin.i.a.v
    public final void b(long j2, FinderObject finderObject, String str, boolean z, ai<ayy> aiVar) {
        int i2;
        boolean z2 = true;
        AppMethodBeat.i(242661);
        p.h(str, "objectNonceId");
        ayy ayy = new ayy();
        ayy.LIV = j2;
        ayy.scene = 2;
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        ayy.dYx = i2;
        ayy.objectNonceId = str;
        if (finderObject != null) {
            z2 = false;
        }
        a(ayy, aiVar, z2);
        AppMethodBeat.o(242661);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.oplog.k
    public final int getCmdId() {
        AppMethodBeat.i(165305);
        bx.a aVar = bx.tvW;
        int i2 = bx.tvN;
        AppMethodBeat.o(165305);
        return i2;
    }
}
