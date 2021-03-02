package com.tencent.mm.plugin.sns.ui.item;

import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.it;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.bv;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Util;

public final class r extends BaseTimeLineItem {

    public static class a extends BaseTimeLineItem.BaseViewHolder {
        boolean EZQ = false;
        RelativeLayout EZR = null;
        TextView EZS = null;
        TextView EZT = null;
    }

    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    public final void d(BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(203948);
        a aVar = (a) baseViewHolder;
        if (baseViewHolder.EWD == null || baseViewHolder.EWD.getParent() == null) {
            aVar.EZR = (RelativeLayout) baseViewHolder.convertView.findViewById(R.id.i1t);
            aVar.EZQ = true;
        } else {
            baseViewHolder.EWD.setLayoutResource(R.layout.by8);
            if (!aVar.EZQ) {
                aVar.EZR = (RelativeLayout) baseViewHolder.EWD.inflate();
                aVar.EZQ = true;
            }
        }
        aVar.EZS = (TextView) aVar.EZR.findViewById(R.id.i1z);
        aVar.EZT = (TextView) aVar.EZR.findViewById(R.id.i1v);
        AppMethodBeat.o(203948);
    }

    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    public final void a(BaseTimeLineItem.BaseViewHolder baseViewHolder, int i2, bl blVar, TimeLineObject timeLineObject, int i3, bk bkVar) {
        AppMethodBeat.i(203949);
        a aVar = (a) baseViewHolder;
        if (!(blVar.EOi == null || blVar.EOj == null || Util.isNullOrNil(blVar.EOj.Nbk))) {
            aVar.EZS.setText(l.b(aVar.EZS.getContext(), blVar.EOj.Nbl, aVar.EZS.getTextSize()));
            aVar.EZT.setText(aVar.EZT.getContext().getResources().getString(R.string.h73, Integer.valueOf(blVar.EOj.Nbk.size())));
            aVar.EWA.setVisibility(8);
            aVar.EWP.setVisibility(8);
            aVar.EIm.setVisibility(8);
            aVar.jBQ.setVisibility(8);
            aVar.EWO.setVisibility(8);
            bv bvVar = new bv();
            bvVar.username = timeLineObject.UserName;
            bvVar.DIf = blVar.EOj.Nbk.get(0).longValue();
            bvVar.DIg = blVar.EOj.Nbk.get(blVar.EOj.Nbk.size() - 1).longValue();
            bvVar.EQE = blVar.EOi.field_groupId;
            bvVar.idList.addAll(blVar.EOj.Nbk);
            aVar.EZR.setTag(bvVar);
            aVar.EZR.setOnClickListener(bkVar.EBo.ERg);
            blVar.EOd = null;
            blVar.EOe = null;
            blVar.ENM = false;
            blVar.ENK = null;
            blVar.ENW = false;
            it itVar = e.DUQ.DVH.get(Long.valueOf(blVar.ENp));
            if (itVar != null) {
                itVar.ePG = 1;
                itVar.ePJ = (long) (i2 + 1);
            }
        }
        AppMethodBeat.o(203949);
    }
}
