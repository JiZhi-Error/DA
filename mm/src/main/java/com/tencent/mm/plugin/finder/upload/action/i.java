package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.cgi.aj;
import com.tencent.mm.plugin.finder.cgi.q;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.j;
import com.tencent.mm.plugin.finder.upload.action.k;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010$\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020\u0007H\u0016J\b\u0010&\u001a\u00020\u0007H\u0016R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0011\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0019R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", ch.COL_FINDEROBJECT, "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "objectNonceId", "", "like", "", "isPrivate", "scene", "", "uicallback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isLongVideo", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;JLjava/lang/String;ZZILcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Z)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFeedId", "()J", "getFinderObject", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "()Z", "getLike", "getObjectNonceId", "()Ljava/lang/String;", "getScene", "()I", "doLikeFeed", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "doLikeLongVideo", "doSomething", "toString", "uniqueId", "plugin-finder_release"})
public final class i extends e {
    public final long feedId;
    private final boolean isLongVideo = false;
    public final String objectNonceId;
    public final int scene;
    private final bbn ttO;
    public final FinderItem vTS;
    public final boolean vUk;
    public final boolean vUr;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "kotlin.jvm.PlatformType", "call"})
    static final class a<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ k.b vTV;
        final /* synthetic */ i vUs;

        a(i iVar, k.b bVar) {
            this.vUs = iVar;
            this.vTV = bVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            int i2 = 0;
            AppMethodBeat.i(253216);
            c.a aVar = (c.a) obj;
            Log.i("Finder.LikeActionTask", "LikeActionTask callback " + aVar.errType + ' ' + aVar.errCode + ' ' + aVar.errMsg);
            if (aVar.errType == 0 && aVar.errCode == 0) {
                int likeCount = this.vUs.vTS.getLikeCount();
                int likeFlag = this.vUs.vTS.getLikeFlag();
                int friendLikeCount = this.vUs.vTS.getFriendLikeCount();
                if (this.vUs.vUr) {
                    this.vUs.vTS.setLikeCount((this.vUs.vTS.getLikeFlag() != 0 ? 0 : 1) + this.vUs.vTS.getLikeCount());
                } else {
                    this.vUs.vTS.setLikeCount((this.vUs.vTS.getLikeFlag() != 0 ? -1 : 0) + this.vUs.vTS.getLikeCount());
                }
                if (likeFlag == 1 && (!this.vUs.vUr || this.vUs.vUk)) {
                    FinderItem finderItem = this.vUs.vTS;
                    finderItem.setFriendLikeCount(finderItem.getFriendLikeCount() - 1);
                } else if (likeFlag != 1 && this.vUs.vUr && !this.vUs.vUk) {
                    FinderItem finderItem2 = this.vUs.vTS;
                    finderItem2.setFriendLikeCount(finderItem2.getFriendLikeCount() + 1);
                }
                if (!this.vUs.vUr || this.vUs.vUk) {
                    j.a aVar2 = j.vUw;
                    j unused = j.vUv;
                    j.aI(this.vUs.vTS.getLikeList());
                } else {
                    j.a aVar3 = j.vUw;
                    j unused2 = j.vUv;
                    j.aG(this.vUs.vTS.getLikeList());
                }
                this.vUs.vTS.setLikeFlag((!this.vUs.vUr || !this.vUs.vUk) ? this.vUs.vUr ? 1 : 0 : 2);
                Log.i("Finder.LikeAction", "CgiFinderLikeFeed end likeFlag:" + this.vUs.vTS.getLikeFlag() + " likeCount " + this.vUs.vTS.getLikeCount() + " friendLikeCount:" + this.vUs.vTS.getFriendLikeCount() + ",  " + likeFlag + ' ' + likeCount + ", oldFriendLikeCount:" + friendLikeCount);
                j.a aVar4 = j.vUw;
                j.vUv.a(this.vUs);
                this.vTV.a(com.tencent.mm.loader.g.j.OK, false);
                hn hnVar = new hn();
                hnVar.dLW.id = this.vUs.feedId;
                hn.a aVar5 = hnVar.dLW;
                if (this.vUs.vUr && this.vUs.vUk) {
                    i2 = 2;
                } else if (this.vUs.vUr) {
                    i2 = 1;
                }
                aVar5.dLZ = i2;
                hnVar.dLW.likeCount = this.vUs.vTS.getLikeCount();
                hnVar.dLW.dLY = 1;
                hnVar.dLW.type = 4;
                Boolean valueOf = Boolean.valueOf(EventCenter.instance.publish(hnVar));
                AppMethodBeat.o(253216);
                return valueOf;
            } else if (aVar.errType == 4) {
                j.a aVar6 = j.vUw;
                j.vUv.a(this.vUs);
                hn hnVar2 = new hn();
                hnVar2.dLW.id = this.vUs.feedId;
                hnVar2.dLW.type = 4;
                EventCenter.instance.publish(hnVar2);
                this.vTV.a(com.tencent.mm.loader.g.j.Fail, false);
                x xVar = x.SXb;
                AppMethodBeat.o(253216);
                return xVar;
            } else {
                this.vTV.a(com.tencent.mm.loader.g.j.Fail, true);
                x xVar2 = x.SXb;
                AppMethodBeat.o(253216);
                return xVar2;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoLikeResponse;", "kotlin.jvm.PlatformType", "call"})
    static final class b<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ k.b vTV;
        final /* synthetic */ i vUs;

        b(i iVar, k.b bVar) {
            this.vUs = iVar;
            this.vTV = bVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            int i2 = 0;
            AppMethodBeat.i(253217);
            c.a aVar = (c.a) obj;
            Log.i("Finder.LikeActionTask", "doLikeLongVideo: isLike" + this.vUs.vUr + ", it.errType = " + aVar.errType + ' ' + aVar.errCode + ' ' + aVar.errMsg);
            if (aVar.errType == 0 && aVar.errCode == 0) {
                j.a aVar2 = j.vUw;
                j.vUv.b(this.vUs);
                this.vTV.a(com.tencent.mm.loader.g.j.OK, false);
                hn hnVar = new hn();
                hnVar.dLW.id = this.vUs.feedId;
                hn.a aVar3 = hnVar.dLW;
                if (this.vUs.vUr) {
                    i2 = 1;
                }
                aVar3.dLZ = i2;
                hnVar.dLW.likeCount = this.vUs.vTS.getLikeCount();
                hnVar.dLW.dLY = 1;
                hnVar.dLW.dLK = 1;
                hnVar.dLW.type = 4;
                Boolean valueOf = Boolean.valueOf(EventCenter.instance.publish(hnVar));
                AppMethodBeat.o(253217);
                return valueOf;
            } else if (aVar.errType == 4) {
                j.a aVar4 = j.vUw;
                j.vUv.b(this.vUs);
                hn hnVar2 = new hn();
                hnVar2.dLW.id = this.vUs.feedId;
                hnVar2.dLW.type = 4;
                hnVar2.dLW.dLK = 1;
                EventCenter.instance.publish(hnVar2);
                this.vTV.a(com.tencent.mm.loader.g.j.Fail, false);
                x xVar = x.SXb;
                AppMethodBeat.o(253217);
                return xVar;
            } else {
                this.vTV.a(com.tencent.mm.loader.g.j.Fail, true);
                x xVar2 = x.SXb;
                AppMethodBeat.o(253217);
                return xVar2;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(FinderItem finderItem, long j2, String str, boolean z, boolean z2, int i2, bbn bbn) {
        super(null);
        p.h(finderItem, ch.COL_FINDEROBJECT);
        p.h(str, "objectNonceId");
        p.h(bbn, "contextObj");
        AppMethodBeat.i(253218);
        this.vTS = finderItem;
        this.feedId = j2;
        this.objectNonceId = str;
        this.vUr = z;
        this.vUk = z2;
        this.scene = i2;
        this.ttO = bbn;
        AppMethodBeat.o(253218);
    }

    public final String toString() {
        AppMethodBeat.i(167805);
        String str = "action_" + this.feedId + '_' + this.vUr + '_' + this.scene + '_' + this.vUi;
        AppMethodBeat.o(167805);
        return str;
    }

    @Override // com.tencent.mm.plugin.finder.upload.action.e
    public final String auK() {
        AppMethodBeat.i(167806);
        String str = "id_" + this.feedId + '_' + this.vUr;
        AppMethodBeat.o(167806);
        return str;
    }

    @Override // com.tencent.mm.plugin.finder.upload.action.e
    public final void a(k.b bVar) {
        AppMethodBeat.i(167807);
        p.h(bVar, "callback");
        super.a(bVar);
        if (this.isLongVideo) {
            new aj(this, this.ttO).aYI().g(new b(this, bVar));
            AppMethodBeat.o(167807);
            return;
        }
        new q(this, this.ttO).aYI().g(new a(this, bVar));
        AppMethodBeat.o(167807);
    }
}
