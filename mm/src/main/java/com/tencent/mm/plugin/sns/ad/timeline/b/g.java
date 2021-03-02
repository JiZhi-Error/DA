package com.tencent.mm.plugin.sns.ad.timeline.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnb;

public final class g {
    public static cnb a(BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(202235);
        if (!(baseViewHolder == null || baseViewHolder.timeLineObject == null || baseViewHolder.timeLineObject.ContentObj == null)) {
            adp adp = baseViewHolder.timeLineObject.ContentObj;
            if (!c.isEmpty(adp.LoV)) {
                cnb cnb = adp.LoV.get(0);
                AppMethodBeat.o(202235);
                return cnb;
            }
        }
        AppMethodBeat.o(202235);
        return null;
    }

    public static TimeLineObject b(BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        if (baseViewHolder != null) {
            return baseViewHolder.timeLineObject;
        }
        return null;
    }

    public static String c(BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(202236);
        TimeLineObject b2 = b(baseViewHolder);
        if (b2 != null) {
            String str = b2.Id;
            AppMethodBeat.o(202236);
            return str;
        }
        AppMethodBeat.o(202236);
        return "";
    }

    public static k a(bk bkVar) {
        if (bkVar == null || bkVar.EKl == null) {
            return null;
        }
        return bkVar.EKl.EoE;
    }
}
