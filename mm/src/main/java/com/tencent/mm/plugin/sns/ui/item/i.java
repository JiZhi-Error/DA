package com.tencent.mm.plugin.sns.ui.item;

import android.support.constraint.Guideline;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.protocal.protobuf.col;
import com.tencent.mm.sdk.platformtools.Util;

public final class i extends BaseTimeLineItem {

    public static class a extends BaseTimeLineItem.BaseViewHolder {
        boolean EYl = false;
        View EYm;
        Guideline EYw;
        ImageIndicatorView EYx;
        ImageView EpU;
        ImageView tiQ;
    }

    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    public final void d(BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(203928);
        a aVar = (a) baseViewHolder;
        if (aVar.EWD == null || aVar.EWD.getParent() == null) {
            aVar.EYm = aVar.convertView.findViewById(R.id.hxz);
            aVar.EYl = true;
        } else {
            aVar.EWD.setLayoutResource(R.layout.bvu);
            if (!aVar.EYl) {
                aVar.EYm = aVar.EWD.inflate();
                aVar.EYl = true;
            }
        }
        aVar.EpU = (ImageView) aVar.EYm.findViewById(R.id.hy2);
        aVar.EYx = (ImageIndicatorView) aVar.EYm.findViewById(R.id.hy0);
        aVar.tiQ = (ImageView) aVar.EYm.findViewById(R.id.hy3);
        aVar.EYw = (Guideline) aVar.EYm.findViewById(R.id.hy1);
        AppMethodBeat.o(203928);
    }

    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    public final void a(BaseTimeLineItem.BaseViewHolder baseViewHolder, int i2, bl blVar, TimeLineObject timeLineObject, int i3, bk bkVar) {
        cok cok;
        AppMethodBeat.i(203929);
        if (!(timeLineObject == null || timeLineObject.ContentObj == null || timeLineObject.ContentObj.Lpd == null)) {
            a aVar = (a) baseViewHolder;
            col col = timeLineObject.ContentObj.Lpd;
            if (!Util.isNullOrNil(col.mediaList) && (cok = col.mediaList.get(0)) != null) {
                aVar.EpU.setVisibility(0);
                aVar.EYx.setVisibility(8);
                aVar.EYw.setGuidelineEnd(0);
                Pair<Integer, Integer> a2 = n.a((int) cok.width, (int) cok.height, aVar.EYm.getContext(), false);
                int intValue = ((Integer) a2.first).intValue();
                int intValue2 = ((Integer) a2.second).intValue();
                aVar.EYm.getLayoutParams().width = intValue;
                aVar.EYm.getLayoutParams().height = intValue2;
                aVar.EYm.requestLayout();
                if (!TextUtils.isEmpty(cok.coverUrl)) {
                    ((aj) g.ah(aj.class)).loadImage(cok.coverUrl, aVar.tiQ);
                } else {
                    ((aj) g.ah(aj.class)).loadImage(cok.thumbUrl, aVar.tiQ);
                }
                aVar.EYm.setTag(timeLineObject);
                aVar.EYm.setOnClickListener(bkVar.EBo.ERd);
                bkVar.fiV().c(aVar.EYm, bkVar.DQs.FaN, bkVar.DQs.Far);
            }
        }
        AppMethodBeat.o(203929);
    }
}
