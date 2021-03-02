package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.bf;
import com.tencent.mm.plugin.finder.convert.bg;
import com.tencent.mm.plugin.finder.convert.bi;
import com.tencent.mm.plugin.finder.convert.bj;
import com.tencent.mm.plugin.finder.convert.bk;
import com.tencent.mm.plugin.finder.convert.bl;
import com.tencent.mm.plugin.finder.convert.bm;
import com.tencent.mm.plugin.finder.convert.bo;
import com.tencent.mm.plugin.finder.convert.bq;
import com.tencent.mm.plugin.finder.convert.br;
import com.tencent.mm.plugin.finder.convert.bs;
import com.tencent.mm.plugin.finder.convert.bt;
import com.tencent.mm.plugin.finder.convert.bu;
import com.tencent.mm.plugin.finder.convert.bv;
import com.tencent.mm.plugin.finder.model.au;
import com.tencent.mm.plugin.finder.model.av;
import com.tencent.mm.plugin.finder.model.aw;
import com.tencent.mm.plugin.finder.model.ax;
import com.tencent.mm.plugin.finder.model.ay;
import com.tencent.mm.plugin.finder.model.az;
import com.tencent.mm.plugin.finder.model.ba;
import com.tencent.mm.plugin.finder.model.bb;
import com.tencent.mm.plugin.finder.model.bc;
import com.tencent.mm.plugin.finder.model.bd;
import com.tencent.mm.plugin.finder.model.be;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$initView$2", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
public final class FinderMsgContract$MsgViewCallback$initView$2 implements f {
    final /* synthetic */ FinderMsgContract.MsgViewCallback uYD;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FinderMsgContract$MsgViewCallback$initView$2(FinderMsgContract.MsgViewCallback msgViewCallback) {
        this.uYD = msgViewCallback;
    }

    @Override // com.tencent.mm.view.recyclerview.f
    public final e<?> EC(int i2) {
        AppMethodBeat.i(249890);
        if (FinderMsgContract.MsgViewCallback.b(this.uYD).scene == 2) {
            if (i2 == bd.class.getName().hashCode()) {
                bu buVar = new bu(FinderMsgContract.MsgViewCallback.b(this.uYD).scene);
                AppMethodBeat.o(249890);
                return buVar;
            } else if (i2 == ba.class.getName().hashCode()) {
                bq bqVar = new bq(FinderMsgContract.MsgViewCallback.b(this.uYD).scene);
                AppMethodBeat.o(249890);
                return bqVar;
            } else if (i2 == au.class.getName().hashCode()) {
                bg bgVar = new bg(FinderMsgContract.MsgViewCallback.b(this.uYD).scene);
                AppMethodBeat.o(249890);
                return bgVar;
            } else if (i2 == be.class.getName().hashCode()) {
                bv bvVar = new bv();
                AppMethodBeat.o(249890);
                return bvVar;
            } else if (i2 == av.class.getName().hashCode()) {
                bl blVar = new bl(FinderMsgContract.MsgViewCallback.b(this.uYD).scene);
                AppMethodBeat.o(249890);
                return blVar;
            } else if (i2 == bb.class.getName().hashCode()) {
                bs bsVar = new bs(FinderMsgContract.MsgViewCallback.b(this.uYD).scene);
                AppMethodBeat.o(249890);
                return bsVar;
            } else if (i2 == az.class.getName().hashCode()) {
                bo boVar = new bo(FinderMsgContract.MsgViewCallback.b(this.uYD).scene);
                AppMethodBeat.o(249890);
                return boVar;
            } else if (i2 == ay.class.getName().hashCode()) {
                bm bmVar = new bm(FinderMsgContract.MsgViewCallback.b(this.uYD).scene);
                AppMethodBeat.o(249890);
                return bmVar;
            } else if (i2 == bc.class.getName().hashCode()) {
                bt btVar = new bt();
                AppMethodBeat.o(249890);
                return btVar;
            } else if (i2 == ax.class.getName().hashCode()) {
                bk bkVar = new bk((byte) 0);
                AppMethodBeat.o(249890);
                return bkVar;
            } else {
                y yVar = y.vXH;
                y.dQ(FinderMsgContract.MsgViewCallback.c(this.uYD), i2);
                com.tencent.mm.plugin.finder.convert.f fVar = new com.tencent.mm.plugin.finder.convert.f();
                AppMethodBeat.o(249890);
                return fVar;
            }
        } else if (i2 == bd.class.getName().hashCode()) {
            bu buVar2 = new bu(FinderMsgContract.MsgViewCallback.b(this.uYD).scene);
            AppMethodBeat.o(249890);
            return buVar2;
        } else if (i2 == ba.class.getName().hashCode()) {
            bq bqVar2 = new bq(FinderMsgContract.MsgViewCallback.b(this.uYD).scene);
            AppMethodBeat.o(249890);
            return bqVar2;
        } else if (i2 == au.class.getName().hashCode()) {
            bf bfVar = new bf(FinderMsgContract.MsgViewCallback.b(this.uYD).scene);
            AppMethodBeat.o(249890);
            return bfVar;
        } else if (i2 == be.class.getName().hashCode()) {
            bv bvVar2 = new bv();
            AppMethodBeat.o(249890);
            return bvVar2;
        } else if (i2 == av.class.getName().hashCode()) {
            bj bjVar = new bj(FinderMsgContract.MsgViewCallback.b(this.uYD).scene);
            AppMethodBeat.o(249890);
            return bjVar;
        } else if (i2 == bb.class.getName().hashCode()) {
            br brVar = new br(FinderMsgContract.MsgViewCallback.b(this.uYD).scene);
            AppMethodBeat.o(249890);
            return brVar;
        } else if (i2 == az.class.getName().hashCode()) {
            bo boVar2 = new bo(FinderMsgContract.MsgViewCallback.b(this.uYD).scene);
            AppMethodBeat.o(249890);
            return boVar2;
        } else if (i2 == ay.class.getName().hashCode()) {
            bm bmVar2 = new bm(FinderMsgContract.MsgViewCallback.b(this.uYD).scene);
            AppMethodBeat.o(249890);
            return bmVar2;
        } else if (i2 == bc.class.getName().hashCode()) {
            bt btVar2 = new bt();
            AppMethodBeat.o(249890);
            return btVar2;
        } else if (i2 == aw.class.getName().hashCode()) {
            bi biVar = new bi((byte) 0);
            AppMethodBeat.o(249890);
            return biVar;
        } else {
            y yVar2 = y.vXH;
            y.dQ(FinderMsgContract.MsgViewCallback.c(this.uYD), i2);
            com.tencent.mm.plugin.finder.convert.f fVar2 = new com.tencent.mm.plugin.finder.convert.f();
            AppMethodBeat.o(249890);
            return fVar2;
        }
    }
}
