package com.tencent.mm.plugin.sns.ui.item;

import android.text.SpannableString;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.ai;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.ar;

public final class h extends BaseTimeLineItem {

    public static class a extends BaseTimeLineItem.BaseViewHolder {
    }

    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    public final void a(BaseTimeLineItem.BaseViewHolder baseViewHolder, int i2, bl blVar, TimeLineObject timeLineObject, int i3, bk bkVar) {
        AppMethodBeat.i(203927);
        if (timeLineObject.ContentObj.Lpa != null) {
            baseViewHolder.EWG.setPosition(i2);
            baseViewHolder.EIs.setVisibility(0);
            cnb cnb = new cnb();
            cnb.Url = timeLineObject.ContentObj.Lpa.iAo;
            cnb.Msz = timeLineObject.ContentObj.Lpa.iAo;
            cnb.oUv = 2;
            cnb.MsA = 1;
            cnb.MsB = new cnd();
            cnb.Mcw = 1;
            cnb.MsB.Mto = (float) timeLineObject.ContentObj.Lpa.width;
            cnb.MsB.Mtp = (float) timeLineObject.ContentObj.Lpa.height;
            cnb.Id = timeLineObject.Id;
            g faL = aj.faL();
            TagImageView tagImageView = baseViewHolder.EWG;
            int hashCode = this.mActivity.hashCode();
            bp gCU = bp.gCU();
            gCU.hXs = timeLineObject.CreateTime;
            faL.b(cnb, tagImageView, hashCode, gCU);
            baseViewHolder.uzC.setPressed(false);
            baseViewHolder.uzC.setImageDrawable(ar.m(baseViewHolder.uzC.getContext(), R.raw.icons_outlined_video_call, -1));
            baseViewHolder.EIs.setTag(new ai(timeLineObject, baseViewHolder.EWG, blVar.Eql));
            baseViewHolder.EWH.setVisibility(8);
            bkVar.fiV().c(baseViewHolder.EIs, bkVar.DQs.FaM, bkVar.DQs.Far);
            baseViewHolder.EIs.setOnClickListener(bkVar.EBo.ERc);
            String str = timeLineObject.ContentObj.Lpa.title;
            if (!Util.isNullOrNil(str)) {
                baseViewHolder.titleTv.setVisibility(0);
                baseViewHolder.titleTv.setText(new SpannableString(str), TextView.BufferType.SPANNABLE);
                AppMethodBeat.o(203927);
                return;
            }
            baseViewHolder.titleTv.setVisibility(8);
            AppMethodBeat.o(203927);
            return;
        }
        baseViewHolder.EIs.setVisibility(8);
        AppMethodBeat.o(203927);
    }

    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    public final void d(BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(203926);
        if (baseViewHolder.EWD != null) {
            baseViewHolder.EWD.setLayoutResource(R.layout.bwh);
            baseViewHolder.EXp = (ViewStub) baseViewHolder.convertView.findViewById(R.id.dwu);
            if (!baseViewHolder.EXq && baseViewHolder.EXp != null) {
                baseViewHolder.EXr = baseViewHolder.EXp.inflate();
                baseViewHolder.EXq = true;
            }
        } else {
            baseViewHolder.EXr = baseViewHolder.convertView.findViewById(R.id.fbh);
            baseViewHolder.EXq = true;
        }
        baseViewHolder.EIs = baseViewHolder.EXr;
        baseViewHolder.EIs.findViewById(R.id.i4t).setOnTouchListener(this.DQX.EqE);
        baseViewHolder.EWG = (TagImageView) baseViewHolder.EIs.findViewById(R.id.dw4);
        baseViewHolder.uzC = (ImageView) baseViewHolder.EIs.findViewById(R.id.i4t);
        baseViewHolder.EWH = (TextView) baseViewHolder.EIs.findViewById(R.id.h7r);
        baseViewHolder.titleTv = (TextView) baseViewHolder.EIs.findViewById(R.id.ir7);
        baseViewHolder.titleTv.setMaxLines(2);
        r.b(baseViewHolder.EWG, this.mActivity);
        AppMethodBeat.o(203926);
    }
}
