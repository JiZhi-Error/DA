package com.tencent.mm.plugin.sns.ui.item;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.bc;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.plugin.sns.ui.s;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.storage.bp;
import java.util.ArrayList;

public final class b extends BaseTimeLineItem {
    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    public final void d(BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(100066);
        int fbb = aj.fbb();
        if (baseViewHolder.EWD == null) {
            baseViewHolder.EXr = baseViewHolder.convertView.findViewById(R.id.bem);
            baseViewHolder.EXq = true;
        } else if (!baseViewHolder.EXq) {
            baseViewHolder.EWD.setLayoutResource(R.layout.bwc);
            baseViewHolder.EXr = baseViewHolder.EWD.inflate();
            baseViewHolder.EXq = true;
        }
        baseViewHolder.EWG = (TagImageView) baseViewHolder.EXr.findViewById(R.id.bf5);
        baseViewHolder.uzC = (ImageView) baseViewHolder.EXr.findViewById(R.id.i4t);
        baseViewHolder.titleTv = (TextView) baseViewHolder.EXr.findViewById(R.id.ber);
        View view = baseViewHolder.EXr;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = fbb;
        layoutParams.width = fbb;
        view.setLayoutParams(layoutParams);
        r.b(baseViewHolder.EWG, this.mActivity);
        AppMethodBeat.o(100066);
    }

    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    public final void a(BaseTimeLineItem.BaseViewHolder baseViewHolder, int i2, bl blVar, TimeLineObject timeLineObject, int i3, bk bkVar) {
        AppMethodBeat.i(100067);
        baseViewHolder.EWG.setPosition(i2);
        String str = blVar.Eql;
        int size = timeLineObject.ContentObj.LoV.size();
        if (size > 0) {
            cnb cnb = timeLineObject.ContentObj.LoV.get(0);
            switch (timeLineObject.ContentObj.LoU) {
                case 1:
                    baseViewHolder.EWG.setOnClickListener(bkVar.DQs.Erh);
                    bc bcVar = new bc();
                    bcVar.dJX = str;
                    bcVar.index = 0;
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(baseViewHolder.EWG);
                    bcVar.EDW = arrayList;
                    bcVar.EAv = this.EAv;
                    bcVar.position = i2;
                    baseViewHolder.EWG.setTag(bcVar);
                    baseViewHolder.EWG.setVisibility(0);
                    g faL = aj.faL();
                    TagImageView tagImageView = baseViewHolder.EWG;
                    int hashCode = this.mActivity.hashCode();
                    bp gCU = bp.gCU();
                    gCU.hXs = timeLineObject.CreateTime;
                    faL.b(cnb, tagImageView, hashCode, gCU);
                    baseViewHolder.uzC.setVisibility(8);
                    baseViewHolder.titleTv.setText(this.mActivity.getString(R.string.h9f, new Object[]{Integer.valueOf(size)}));
                    baseViewHolder.titleTv.setVisibility(0);
                    break;
                case 15:
                    baseViewHolder.EWG.setTag(new s(timeLineObject, str));
                    baseViewHolder.EWG.setOnClickListener(bkVar.DQs.FaR);
                    baseViewHolder.uzC.setImageResource(R.raw.sns_collapse_video_play);
                    baseViewHolder.uzC.setVisibility(0);
                    baseViewHolder.titleTv.setVisibility(8);
                    g faL2 = aj.faL();
                    TagImageView tagImageView2 = baseViewHolder.EWG;
                    int hashCode2 = this.mActivity.hashCode();
                    bp gCU2 = bp.gCU();
                    gCU2.hXs = timeLineObject.CreateTime;
                    faL2.b(cnb, tagImageView2, hashCode2, gCU2);
                    break;
            }
        }
        bkVar.fiV().c(baseViewHolder.EWG, bkVar.DQs.FaI, bkVar.DQs.Far);
        AppMethodBeat.o(100067);
    }
}
