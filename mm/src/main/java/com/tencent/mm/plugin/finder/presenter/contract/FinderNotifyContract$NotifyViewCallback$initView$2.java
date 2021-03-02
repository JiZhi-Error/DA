package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.bf;
import com.tencent.mm.plugin.finder.convert.bi;
import com.tencent.mm.plugin.finder.convert.bj;
import com.tencent.mm.plugin.finder.convert.bk;
import com.tencent.mm.plugin.finder.convert.bl;
import com.tencent.mm.plugin.finder.convert.bm;
import com.tencent.mm.plugin.finder.convert.bn;
import com.tencent.mm.plugin.finder.convert.bo;
import com.tencent.mm.plugin.finder.convert.bp;
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
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback$initView$2", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
public final class FinderNotifyContract$NotifyViewCallback$initView$2 implements f {
    final /* synthetic */ FinderNotifyContract.NotifyViewCallback uZd;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public FinderNotifyContract$NotifyViewCallback$initView$2(FinderNotifyContract.NotifyViewCallback notifyViewCallback) {
        this.uZd = notifyViewCallback;
    }

    @Override // com.tencent.mm.view.recyclerview.f
    public final e<?> EC(int i2) {
        AppMethodBeat.i(249944);
        if (this.uZd.uZa.scene == 2) {
            if (i2 == bd.class.getName().hashCode()) {
                bu buVar = new bu(this.uZd.uZa.scene);
                AppMethodBeat.o(249944);
                return buVar;
            } else if (i2 == ba.class.getName().hashCode()) {
                bq bqVar = new bq(this.uZd.uZa.scene);
                AppMethodBeat.o(249944);
                return bqVar;
            } else if (i2 == au.class.getName().hashCode()) {
                bf bfVar = new bf(this.uZd.uZa.scene);
                AppMethodBeat.o(249944);
                return bfVar;
            } else if (i2 == be.class.getName().hashCode()) {
                bv bvVar = new bv();
                AppMethodBeat.o(249944);
                return bvVar;
            } else if (i2 == av.class.getName().hashCode()) {
                bl blVar = new bl(this.uZd.uZa.scene);
                AppMethodBeat.o(249944);
                return blVar;
            } else if (i2 == bb.class.getName().hashCode()) {
                bs bsVar = new bs(this.uZd.uZa.scene);
                AppMethodBeat.o(249944);
                return bsVar;
            } else if (i2 == az.class.getName().hashCode()) {
                bp bpVar = new bp(this.uZd.uZa.scene);
                AppMethodBeat.o(249944);
                return bpVar;
            } else if (i2 == ay.class.getName().hashCode()) {
                bn bnVar = new bn(this.uZd.uZa.scene);
                AppMethodBeat.o(249944);
                return bnVar;
            } else if (i2 == bc.class.getName().hashCode()) {
                bt btVar = new bt();
                AppMethodBeat.o(249944);
                return btVar;
            } else if (i2 == ax.class.getName().hashCode()) {
                bk bkVar = new bk((byte) 0);
                AppMethodBeat.o(249944);
                return bkVar;
            } else {
                p.hyc();
                AppMethodBeat.o(249944);
                return null;
            }
        } else if (i2 == bd.class.getName().hashCode()) {
            bu buVar2 = new bu(this.uZd.uZa.scene);
            AppMethodBeat.o(249944);
            return buVar2;
        } else if (i2 == ba.class.getName().hashCode()) {
            bq bqVar2 = new bq(this.uZd.uZa.scene);
            AppMethodBeat.o(249944);
            return bqVar2;
        } else if (i2 == au.class.getName().hashCode()) {
            bf bfVar2 = new bf(this.uZd.uZa.scene);
            AppMethodBeat.o(249944);
            return bfVar2;
        } else if (i2 == be.class.getName().hashCode()) {
            bv bvVar2 = new bv();
            AppMethodBeat.o(249944);
            return bvVar2;
        } else if (i2 == av.class.getName().hashCode()) {
            bj bjVar = new bj(this.uZd.uZa.scene);
            AppMethodBeat.o(249944);
            return bjVar;
        } else if (i2 == bb.class.getName().hashCode()) {
            br brVar = new br(this.uZd.uZa.scene);
            AppMethodBeat.o(249944);
            return brVar;
        } else if (i2 == az.class.getName().hashCode()) {
            bo boVar = new bo(this.uZd.uZa.scene);
            AppMethodBeat.o(249944);
            return boVar;
        } else if (i2 == ay.class.getName().hashCode()) {
            bm bmVar = new bm(this.uZd.uZa.scene);
            AppMethodBeat.o(249944);
            return bmVar;
        } else if (i2 == bc.class.getName().hashCode()) {
            bt btVar2 = new bt();
            AppMethodBeat.o(249944);
            return btVar2;
        } else if (i2 == aw.class.getName().hashCode()) {
            bi biVar = new bi((byte) 0);
            AppMethodBeat.o(249944);
            return biVar;
        } else {
            p.hyc();
            AppMethodBeat.o(249944);
            return null;
        }
    }
}
