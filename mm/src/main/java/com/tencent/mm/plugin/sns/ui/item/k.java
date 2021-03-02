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
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.plugin.sns.ui.s;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;

public final class k extends BaseTimeLineItem {
    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    public final void a(BaseTimeLineItem.BaseViewHolder baseViewHolder, int i2, bl blVar, TimeLineObject timeLineObject, int i3, bk bkVar) {
        AppMethodBeat.i(100088);
        String str = blVar.Eql;
        if (!timeLineObject.ContentObj.LoV.isEmpty()) {
            baseViewHolder.EWG.setPosition(i2);
            baseViewHolder.EIs.setVisibility(0);
            cnb cnb = timeLineObject.ContentObj.LoV.get(0);
            g faL = aj.faL();
            TagImageView tagImageView = baseViewHolder.EWG;
            int hashCode = this.mActivity.hashCode();
            bp gCU = bp.gCU();
            gCU.hXs = timeLineObject.CreateTime;
            faL.a(cnb, tagImageView, R.raw.app_attach_file_icon_music, hashCode, gCU);
            baseViewHolder.uzC.setPressed(false);
            if (bk.aMJ(timeLineObject.Id)) {
                baseViewHolder.uzC.setImageResource(R.drawable.alq);
            } else {
                baseViewHolder.uzC.setImageResource(R.drawable.am5);
            }
            baseViewHolder.EWG.setTag(new s(timeLineObject, str));
            baseViewHolder.EWG.setOnClickListener(bkVar.EBo.ERq);
            baseViewHolder.EIs.setTag(new s(timeLineObject, str));
            bkVar.fiV().c(baseViewHolder.EIs, bkVar.DQs.FaG, bkVar.DQs.Far);
            baseViewHolder.EIs.setOnClickListener(bkVar.EBo.EIc);
            String str2 = cnb.Desc;
            if (!Util.isNullOrNil(str2)) {
                baseViewHolder.EWH.setVisibility(0);
                baseViewHolder.EWH.setText(str2);
            } else {
                baseViewHolder.EWH.setVisibility(4);
            }
            String str3 = cnb.Title;
            if (!Util.isNullOrNil(str3)) {
                baseViewHolder.titleTv.setVisibility(0);
                baseViewHolder.titleTv.setText(new SpannableString(str3), TextView.BufferType.SPANNABLE);
                AppMethodBeat.o(100088);
                return;
            }
            baseViewHolder.titleTv.setVisibility(8);
            AppMethodBeat.o(100088);
            return;
        }
        baseViewHolder.EIs.setVisibility(8);
        AppMethodBeat.o(100088);
    }

    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    public final void d(BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(100087);
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
        baseViewHolder.titleTv.setTextColor(this.mActivity.getResources().getColor(R.color.a92));
        baseViewHolder.titleTv.setMaxLines(1);
        r.b(baseViewHolder.EWG, this.mActivity);
        AppMethodBeat.o(100087);
    }
}
