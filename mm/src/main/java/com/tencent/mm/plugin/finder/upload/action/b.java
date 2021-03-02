package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.plugin.finder.cgi.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.c;
import com.tencent.mm.plugin.finder.upload.action.k;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010$\u001a\u00020\u0007H\u0016J\b\u0010%\u001a\u00020\u0007H\u0016R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", ch.COL_FINDEROBJECT, "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "objectNonceId", "", "fav", "", "scene", "", "uicallback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isLongVideo", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;JLjava/lang/String;ZILcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Z)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFav", "()Z", "getFeedId", "()J", "getFinderObject", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectNonceId", "()Ljava/lang/String;", "getScene", "()I", "doFavFeed", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "doFavLongVideo", "doSomething", "toString", "uniqueId", "plugin-finder_release"})
public final class b extends e {
    public final long feedId;
    private final boolean isLongVideo;
    public final String objectNonceId;
    private final int scene = 2;
    private final bbn ttO;
    public final FinderItem vTS;
    public final boolean vTT;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderFavResp;", "kotlin.jvm.PlatformType", "call"})
    static final class a<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ b vTU;
        final /* synthetic */ k.b vTV;

        a(b bVar, k.b bVar2) {
            this.vTU = bVar;
            this.vTV = bVar2;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            int i2;
            AppMethodBeat.i(253173);
            c.a aVar = (c.a) obj;
            Log.i("Finder.FavActionTask", "FavActionTask callback " + aVar.errType + ' ' + aVar.errCode + ' ' + aVar.errMsg);
            if (aVar.errType == 0 && aVar.errCode == 0) {
                int favCount = this.vTU.vTS.getFavCount();
                int favFlag = this.vTU.vTS.getFavFlag();
                if (this.vTU.vTT) {
                    this.vTU.vTS.setFavCount((this.vTU.vTS.getFavFlag() == 1 ? 0 : 1) + this.vTU.vTS.getFavCount());
                } else {
                    this.vTU.vTS.setFavCount((this.vTU.vTS.getFavFlag() == 1 ? -1 : 0) + this.vTU.vTS.getFavCount());
                }
                FinderItem finderItem = this.vTU.vTS;
                if (this.vTU.vTT) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                finderItem.setFavFlag(i2);
                Log.i("Finder.FavAction", "CgiFinderFavFeed end favFlag:" + this.vTU.vTS.getFavFlag() + " favCount " + this.vTU.vTS.getFavCount() + ' ' + favFlag + ' ' + favCount);
                c.a aVar2 = c.vUa;
                c.dBq().a(this.vTU);
                this.vTV.a(j.OK, false);
                hn hnVar = new hn();
                hnVar.dLW.id = this.vTU.feedId;
                hnVar.dLW.dLX = this.vTU.vTT ? 1 : 2;
                hnVar.dLW.dLY = 1;
                hnVar.dLW.type = 5;
                Boolean valueOf = Boolean.valueOf(EventCenter.instance.publish(hnVar));
                AppMethodBeat.o(253173);
                return valueOf;
            } else if (aVar.errType == 4) {
                c.a aVar3 = c.vUa;
                c.dBq().a(this.vTU);
                hn hnVar2 = new hn();
                hnVar2.dLW.id = this.vTU.feedId;
                EventCenter.instance.publish(hnVar2);
                this.vTV.a(j.Fail, false);
                x xVar = x.SXb;
                AppMethodBeat.o(253173);
                return xVar;
            } else {
                this.vTV.a(j.Fail, true);
                x xVar2 = x.SXb;
                AppMethodBeat.o(253173);
                return xVar2;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoFavResp;", "kotlin.jvm.PlatformType", "call"})
    /* renamed from: com.tencent.mm.plugin.finder.upload.action.b$b  reason: collision with other inner class name */
    static final class C1303b<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ b vTU;
        final /* synthetic */ k.b vTV;

        C1303b(b bVar, k.b bVar2) {
            this.vTU = bVar;
            this.vTV = bVar2;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(253174);
            c.a aVar = (c.a) obj;
            Log.i("Finder.FavActionTask", "doFavLongVideo: isFav" + this.vTU.vTT + ", it.errType = " + aVar.errType + ' ' + aVar.errCode + ' ' + aVar.errMsg);
            if (aVar.errType == 0 && aVar.errCode == 0) {
                c.a aVar2 = c.vUa;
                c.dBq().b(this.vTU);
                this.vTV.a(j.OK, false);
                hn hnVar = new hn();
                hnVar.dLW.id = this.vTU.feedId;
                hnVar.dLW.dLX = this.vTU.vTT ? 1 : 2;
                hnVar.dLW.dLY = 1;
                hnVar.dLW.type = 5;
                hnVar.dLW.dLK = 1;
                Boolean valueOf = Boolean.valueOf(EventCenter.instance.publish(hnVar));
                AppMethodBeat.o(253174);
                return valueOf;
            } else if (aVar.errType == 4) {
                c.a aVar3 = c.vUa;
                c.dBq().b(this.vTU);
                hn hnVar2 = new hn();
                hnVar2.dLW.id = this.vTU.feedId;
                hnVar2.dLW.dLK = 1;
                EventCenter.instance.publish(hnVar2);
                this.vTV.a(j.Fail, false);
                x xVar = x.SXb;
                AppMethodBeat.o(253174);
                return xVar;
            } else {
                this.vTV.a(j.Fail, true);
                x xVar2 = x.SXb;
                AppMethodBeat.o(253174);
                return xVar2;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(FinderItem finderItem, long j2, String str, boolean z, int i2, bbn bbn) {
        super(null);
        p.h(finderItem, ch.COL_FINDEROBJECT);
        p.h(str, "objectNonceId");
        p.h(bbn, "contextObj");
        AppMethodBeat.i(253178);
        this.vTS = finderItem;
        this.feedId = j2;
        this.objectNonceId = str;
        this.vTT = z;
        this.ttO = bbn;
        this.isLongVideo = false;
        AppMethodBeat.o(253178);
    }

    public final String toString() {
        AppMethodBeat.i(253175);
        String str = "action_" + this.feedId + '_' + this.vTT + '_' + this.scene + '_' + this.vUi;
        AppMethodBeat.o(253175);
        return str;
    }

    @Override // com.tencent.mm.plugin.finder.upload.action.e
    public final String auK() {
        AppMethodBeat.i(253176);
        String str = "id_" + this.feedId + '_' + this.vTT;
        AppMethodBeat.o(253176);
        return str;
    }

    @Override // com.tencent.mm.plugin.finder.upload.action.e
    public final void a(k.b bVar) {
        AppMethodBeat.i(253177);
        p.h(bVar, "callback");
        super.a(bVar);
        if (this.isLongVideo) {
            new com.tencent.mm.plugin.finder.cgi.c(this, this.ttO).aYI().g(new C1303b(this, bVar));
            AppMethodBeat.o(253177);
            return;
        }
        new h(this, this.ttO).aYI().g(new a(this, bVar));
        AppMethodBeat.o(253177);
    }
}
