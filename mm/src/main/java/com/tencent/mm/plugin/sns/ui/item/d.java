package com.tencent.mm.plugin.sns.ui.item;

import android.support.constraint.Guideline;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.ao;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.e;
import com.tencent.mm.view.f;
import java.util.HashMap;
import java.util.Map;

public final class d extends BaseTimeLineItem {
    private Map<String, Boolean> Vbe = new HashMap();

    public static class a extends BaseTimeLineItem.BaseViewHolder {
        boolean EYl = false;
        View EYm;
        Guideline EYw;
        ImageIndicatorView EYx;
        ImageView EpU;
        ImageView tiQ;
    }

    public d() {
        AppMethodBeat.i(259466);
        AppMethodBeat.o(259466);
    }

    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    public final void d(BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(203918);
        a aVar = (a) baseViewHolder;
        if (baseViewHolder.EWD == null || baseViewHolder.EWD.getParent() == null) {
            aVar.EYm = baseViewHolder.convertView.findViewById(R.id.hxz);
            aVar.EYl = true;
        } else {
            baseViewHolder.EWD.setLayoutResource(R.layout.bvu);
            if (!aVar.EYl) {
                aVar.EYm = baseViewHolder.EWD.inflate();
                aVar.EYl = true;
            }
        }
        aVar.EpU = (ImageView) aVar.EYm.findViewById(R.id.hy2);
        aVar.EYx = (ImageIndicatorView) aVar.EYm.findViewById(R.id.hy0);
        aVar.tiQ = (ImageView) aVar.EYm.findViewById(R.id.hy3);
        aVar.EYw = (Guideline) aVar.EYm.findViewById(R.id.hy1);
        AppMethodBeat.o(203918);
    }

    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    public final void a(BaseTimeLineItem.BaseViewHolder baseViewHolder, int i2, bl blVar, TimeLineObject timeLineObject, int i3, bk bkVar) {
        bch bch;
        AppMethodBeat.i(203919);
        if (!(timeLineObject == null || timeLineObject.ContentObj == null || timeLineObject.ContentObj.dME == null)) {
            a aVar = (a) baseViewHolder;
            final bcj bcj = timeLineObject.ContentObj.dME;
            final SnsInfo snsInfo = blVar.DqO;
            if (snsInfo.getSnsId() == null || this.Vbe.get(snsInfo.getSnsId()) == null) {
                f.a(baseViewHolder.convertView, new e.b() {
                    /* class com.tencent.mm.plugin.sns.ui.item.d.AnonymousClass1 */

                    @Override // com.tencent.mm.view.e.b
                    public final void p(View view, boolean z) {
                        AppMethodBeat.i(259464);
                        if (z) {
                            ((ao) g.af(ao.class)).y(3, snsInfo.getUserName(), bcj.objectId);
                        }
                        AppMethodBeat.o(259464);
                    }

                    @Override // com.tencent.mm.view.e.b
                    public final long hE(View view) {
                        AppMethodBeat.i(259465);
                        long hashCode = (long) (snsInfo.getSnsId().hashCode() + view.hashCode());
                        AppMethodBeat.o(259465);
                        return hashCode;
                    }
                });
                if (snsInfo.getSnsId() != null) {
                    this.Vbe.put(snsInfo.getSnsId(), Boolean.TRUE);
                }
            }
            if (!Util.isNullOrNil(bcj.mediaList) && (bch = bcj.mediaList.get(0)) != null) {
                if (bcj.vXJ == 4) {
                    aVar.EpU.setVisibility(0);
                    aVar.EYx.setVisibility(8);
                    aVar.EYw.setGuidelineEnd(0);
                    Pair<Integer, Integer> a2 = n.a((int) bch.width, (int) bch.height, aVar.EYm.getContext(), false);
                    int intValue = ((Integer) a2.first).intValue();
                    int intValue2 = ((Integer) a2.second).intValue();
                    aVar.EYm.getLayoutParams().width = intValue;
                    aVar.EYm.getLayoutParams().height = intValue2;
                    aVar.EYm.requestLayout();
                } else {
                    aVar.EpU.setVisibility(8);
                    aVar.EYx.setVisibility(8);
                    aVar.EYx.FdA = bcj.dJl;
                    aVar.EYw.setGuidelineEnd(0);
                    Pair<Integer, Integer> a3 = n.a((int) bch.width, (int) bch.height, aVar.EYm.getContext());
                    int intValue3 = ((Integer) a3.first).intValue();
                    int intValue4 = ((Integer) a3.second).intValue();
                    aVar.EYm.getLayoutParams().width = intValue3;
                    aVar.EYm.getLayoutParams().height = intValue4;
                    aVar.EYm.requestLayout();
                }
                ((aj) g.ah(aj.class)).loadImage(bch.thumbUrl, aVar.tiQ);
                aVar.EYm.setTag(timeLineObject);
                aVar.EYm.setOnClickListener(bkVar.EBo.ERd);
                bkVar.fiV().c(aVar.EYm, bkVar.DQs.FaN, bkVar.DQs.Far);
            }
        }
        AppMethodBeat.o(203919);
    }
}
