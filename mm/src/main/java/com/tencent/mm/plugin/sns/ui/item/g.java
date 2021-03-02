package com.tencent.mm.plugin.sns.ui.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.bc;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bp;
import java.util.ArrayList;

public final class g extends BaseTimeLineItem {
    private int EBr = 103;

    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    public final void d(BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(100085);
        baseViewHolder.EWP.setImageResource(R.drawable.aei);
        baseViewHolder.EWx.setTextColor(baseViewHolder.EWx.getContext().getResources().getColor(R.color.a5e));
        if (baseViewHolder.EWD != null) {
            baseViewHolder.EWD.setLayoutResource(R.layout.bvz);
            if (!baseViewHolder.EWE) {
                baseViewHolder.EWX = (PhotosContent) baseViewHolder.EWD.inflate();
                baseViewHolder.EWE = true;
            }
        } else {
            baseViewHolder.EWX = (PhotosContent) baseViewHolder.convertView.findViewById(R.id.dnd);
            baseViewHolder.EWE = true;
        }
        Log.i("MiroMsg.HBRewardTimeLineItem", "viewtype " + this.qcr);
        TagImageView tagImageView = (TagImageView) baseViewHolder.EWX.findViewById(be.EGz[0]);
        baseViewHolder.EWX.a(tagImageView);
        tagImageView.setOnClickListener(this.DQX.DQs.Erh);
        AppMethodBeat.o(100085);
    }

    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    public final void a(BaseTimeLineItem.BaseViewHolder baseViewHolder, int i2, bl blVar, TimeLineObject timeLineObject, int i3, bk bkVar) {
        AppMethodBeat.i(100086);
        String str = blVar.Eql;
        if (baseViewHolder.EXB != null) {
            if (!blVar.ENG || baseViewHolder.snsobj.SnsRedEnvelops == null || baseViewHolder.snsobj.SnsRedEnvelops.Nae <= 0) {
                baseViewHolder.EXB.setBackgroundResource(R.drawable.c9x);
            } else {
                baseViewHolder.EXB.setBackgroundResource(R.drawable.c9y);
            }
        }
        TagImageView ZD = baseViewHolder.EWX.ZD(0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(ZD);
        bc bcVar = new bc();
        bcVar.dJX = str;
        bcVar.index = 0;
        bcVar.EDW = arrayList;
        bcVar.EAv = this.EAv;
        if (ZD != null) {
            ZD.setTag(bcVar);
        }
        cnc cnc = blVar.EOh;
        baseViewHolder.postInfo = cnc;
        if (cnc == null) {
            Log.e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo is null " + blVar.Eql);
            AppMethodBeat.o(100086);
        } else if (z.aTY().equals(timeLineObject.UserName)) {
            baseViewHolder.EWX.setVisibility(0);
            be beVar = bkVar.EBe;
            PhotosContent photosContent = baseViewHolder.EWX;
            String str2 = blVar.Eql;
            int hashCode = this.mActivity.hashCode();
            boolean z = this.EAv;
            bp gCU = bp.gCU();
            gCU.hXs = timeLineObject.CreateTime;
            beVar.a(photosContent, timeLineObject, str2, hashCode, i3, i2, z, gCU, true);
            AppMethodBeat.o(100086);
        } else if (blVar.ENJ) {
            baseViewHolder.EWX.setVisibility(0);
            be beVar2 = bkVar.EBe;
            PhotosContent photosContent2 = baseViewHolder.EWX;
            String str3 = blVar.Eql;
            int hashCode2 = this.mActivity.hashCode();
            boolean z2 = this.EAv;
            bp gCU2 = bp.gCU();
            gCU2.hXs = timeLineObject.CreateTime;
            beVar2.a(photosContent2, timeLineObject, str3, hashCode2, i3, i2, z2, gCU2, false);
            AppMethodBeat.o(100086);
        } else if (cnc.egZ == 0) {
            baseViewHolder.EWX.setVisibility(0);
            be beVar3 = bkVar.EBe;
            PhotosContent photosContent3 = baseViewHolder.EWX;
            String str4 = blVar.Eql;
            int hashCode3 = this.mActivity.hashCode();
            boolean z3 = this.EAv;
            bp gCU3 = bp.gCU();
            gCU3.hXs = timeLineObject.CreateTime;
            beVar3.a(photosContent3, timeLineObject, str4, hashCode3, i3, i2, z3, gCU3, true);
            AppMethodBeat.o(100086);
        } else {
            Log.e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo.hbStatus is " + cnc.egZ);
            AppMethodBeat.o(100086);
        }
    }
}
