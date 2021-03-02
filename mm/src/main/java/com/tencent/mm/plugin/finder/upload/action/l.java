package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.c;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.upload.action.j;
import com.tencent.mm.plugin.finder.upload.action.k;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\t¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016J\b\u0010#\u001a\u00020\u0005H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "feedId", "", "objectNonceId", "", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "like", "", "scene", "", "uicallback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isPoster", "(JLjava/lang/String;Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;ZILcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Z)V", "getComment", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFeedId", "()J", "()Z", "getLike", "getObjectNonceId", "()Ljava/lang/String;", "getScene", "()I", "doSomething", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "toString", "uniqueId", "plugin-finder_release"})
public final class l extends e {
    public final long feedId;
    public final String objectNonceId;
    public final int scene;
    private final bbn ttO;
    public final an vUB;
    final boolean vUC;
    public final boolean vUr;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "kotlin.jvm.PlatformType", "call"})
    static final class a<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ k.b vTV;
        final /* synthetic */ l vUD;

        a(l lVar, k.b bVar) {
            this.vUD = lVar;
            this.vTV = bVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            int i2;
            int i3;
            AppMethodBeat.i(167831);
            c.a aVar = (c.a) obj;
            Log.i("Finder.LikeActionTask", "LikeActionTask callback " + aVar.errType + ' ' + aVar.errCode + ' ' + aVar.errMsg);
            if (aVar.errType == 0 && aVar.errCode == 0) {
                int i4 = this.vUD.vUB.dyb().likeCount;
                boolean z = this.vUD.vUB.dyb().likeFlag == 1;
                if (this.vUD.vUr) {
                    an anVar = this.vUD.vUB;
                    int i5 = this.vUD.vUB.dyb().likeCount;
                    if (z) {
                        i3 = 0;
                    } else {
                        i3 = 1;
                    }
                    anVar.setLikeCount(i3 + i5);
                } else {
                    this.vUD.vUB.setLikeCount((z ? -1 : 0) + this.vUD.vUB.dyb().likeCount);
                }
                an anVar2 = this.vUD.vUB;
                if (this.vUD.vUr) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                anVar2.dyb().likeFlag = i2;
                if (this.vUD.vUC && this.vUD.scene == 1) {
                    if (this.vUD.vUr) {
                        this.vUD.vUB.Lb(this.vUD.vUB.dyb().displayFlag | 1);
                    } else {
                        this.vUD.vUB.Lb(this.vUD.vUB.dyb().displayFlag & -2);
                    }
                }
                Log.i("Finder.LikeCommentAction", "CgiFinderLikeFeed end likeFlag: " + this.vUD.vUB.dyb().likeFlag + " likeCount " + this.vUD.vUB.dyb().likeCount + ' ' + z + ' ' + i4);
                j.a aVar2 = j.vUw;
                j.vUv.a(this.vUD);
                this.vTV.a(com.tencent.mm.loader.g.j.OK, false);
            } else if (aVar.errType == 4) {
                d.h(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.finder.upload.action.l.a.AnonymousClass1 */
                    final /* synthetic */ a vUE;

                    {
                        this.vUE = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(167830);
                        j.a aVar = j.vUw;
                        j.vUv.a(this.vUE.vUD);
                        hn hnVar = new hn();
                        hnVar.dLW.id = this.vUE.vUD.feedId;
                        EventCenter.instance.publish(hnVar);
                        x xVar = x.SXb;
                        AppMethodBeat.o(167830);
                        return xVar;
                    }
                });
                this.vTV.a(com.tencent.mm.loader.g.j.Fail, false);
            } else {
                this.vTV.a(com.tencent.mm.loader.g.j.Fail, true);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(167831);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(long j2, String str, an anVar, boolean z, int i2, bbn bbn, boolean z2) {
        super(null);
        p.h(str, "objectNonceId");
        p.h(anVar, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
        p.h(bbn, "contextObj");
        AppMethodBeat.i(253234);
        this.feedId = j2;
        this.objectNonceId = str;
        this.vUB = anVar;
        this.vUr = z;
        this.scene = i2;
        this.ttO = bbn;
        this.vUC = z2;
        AppMethodBeat.o(253234);
    }

    @Override // com.tencent.mm.plugin.finder.upload.action.e
    public final String auK() {
        AppMethodBeat.i(167832);
        String str = "id_" + this.feedId + '_' + this.vUB.dyb().commentId + '_' + this.vUr + '_' + this.scene + '_' + this.vUi;
        AppMethodBeat.o(167832);
        return str;
    }

    public final String toString() {
        AppMethodBeat.i(167833);
        String str = "action_" + this.feedId + '_' + this.vUB.dyb().commentId + '_' + this.vUr + '_' + this.scene;
        AppMethodBeat.o(167833);
        return str;
    }

    @Override // com.tencent.mm.plugin.finder.upload.action.e
    public final void a(k.b bVar) {
        AppMethodBeat.i(167834);
        p.h(bVar, "callback");
        super.a(bVar);
        new com.tencent.mm.plugin.finder.cgi.p(this, this.ttO).aYI().g(new a(this, bVar));
        AppMethodBeat.o(167834);
    }
}
