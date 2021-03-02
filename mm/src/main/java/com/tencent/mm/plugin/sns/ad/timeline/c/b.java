package com.tencent.mm.plugin.sns.ad.timeline.c;

import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.ad.timeline.b.g;
import com.tencent.mm.plugin.sns.ad.timeline.video.online.d;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.plugin.sns.ui.item.q;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class b extends q {
    private boolean Dzj = false;
    private String Dzk = "";

    public static class a extends BaseTimeLineItem.BaseViewHolder {
    }

    static /* synthetic */ void b(b bVar) {
        AppMethodBeat.i(202255);
        bVar.fkq();
        AppMethodBeat.o(202255);
    }

    @Override // com.tencent.mm.plugin.sns.ui.item.q
    public final boolean eXX() {
        AppMethodBeat.i(202253);
        if (this.Dzj) {
            AppMethodBeat.o(202253);
            return false;
        }
        boolean eXX = super.eXX();
        AppMethodBeat.o(202253);
        return eXX;
    }

    @Override // com.tencent.mm.plugin.sns.ui.item.q
    public final boolean eXY() {
        return this.Dzj;
    }

    @Override // com.tencent.mm.plugin.sns.ui.video.a, com.tencent.mm.plugin.sns.ui.item.q
    public final void a(BaseTimeLineItem.BaseViewHolder baseViewHolder, int i2) {
        AppMethodBeat.i(202254);
        if (this.Dzj) {
            Log.d("SnsAd.AdSightTimeLineItem", "the new video  item is online video");
            if (baseViewHolder == null) {
                Log.e("SnsAd.AdSightTimeLineItem", "the holder is null");
                AppMethodBeat.o(202254);
                return;
            }
            cnb a2 = g.a(baseViewHolder);
            String c2 = g.c(baseViewHolder);
            SnsInfo aQm = aj.faO().aQm(baseViewHolder.dHp);
            k a3 = g.a(this.DQX);
            String str = baseViewHolder.dHp;
            if (a2 == null || c2 == null || aQm == null) {
                Log.e("SnsAd.AdSightTimeLineItem", "the media , timelineId, sns info is null");
                AppMethodBeat.o(202254);
                return;
            }
            com.tencent.mm.plugin.sns.ui.video.b.fkM().pause();
            eYc();
            d dVar = new d("SnsAd.AdSightTimeLineItem");
            dVar.mContainer = (FrameLayout) baseViewHolder.EUK.Ewr.findViewById(R.id.i1s);
            dVar.DzV = a2;
            dVar.DqO = aQm;
            dVar.rzs = str;
            dVar.Dzk = c2;
            dVar.DzW = a3;
            dVar.a(1, new SnsTimelineVideoView.b() {
                /* class com.tencent.mm.plugin.sns.ad.timeline.c.b.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.b
                public final void Zl(String str) {
                    AppMethodBeat.i(202251);
                    if (!Util.isNullOrNil(str) && str.equals(b.this.Dzk)) {
                        Log.w("SnsAd.AdSightTimeLineItem", "timelineVideoView setUICallback onDestroy, the tlId is " + str + ", the timelineId is " + b.this.Dzk);
                        b.b(b.this);
                    }
                    AppMethodBeat.o(202251);
                }
            });
            AppMethodBeat.o(202254);
            return;
        }
        Log.d("SnsAd.AdSightTimeLineItem", "the new video item is running, execute super play!");
        super.a(baseViewHolder, i2);
        AppMethodBeat.o(202254);
    }

    @Override // com.tencent.mm.plugin.sns.ui.item.q, com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    public final void a(BaseTimeLineItem.BaseViewHolder baseViewHolder, int i2, bl blVar, TimeLineObject timeLineObject, int i3, bk bkVar) {
        cnb cnb;
        AppMethodBeat.i(202252);
        if (blVar != null) {
            try {
                if (blVar.DqO != null) {
                    if (!com.tencent.mm.plugin.sns.ad.timeline.b.a.a(blVar.DqO.getAdXml()) || !com.tencent.mm.plugin.sns.ad.timeline.b.a.eXT()) {
                        this.Dzj = false;
                    } else {
                        this.Dzj = true;
                    }
                }
            } catch (Throwable th) {
            }
        }
        if (!(timeLineObject == null || timeLineObject.Id == null)) {
            this.Dzk = timeLineObject.Id;
        }
        if (timeLineObject.ContentObj == null || timeLineObject.ContentObj.LoV.size() <= 0) {
            cnb = null;
        } else {
            cnb = timeLineObject.ContentObj.LoV.get(0);
        }
        if (blVar.Eoq) {
            if (this.Dzj) {
                com.tencent.mm.plugin.sns.ad.e.b.a(blVar.DqO, cnb);
            } else {
                com.tencent.mm.plugin.sns.ad.e.b.a(cnb, false);
            }
        }
        super.a(baseViewHolder, i2, blVar, timeLineObject, i3, bkVar);
        AppMethodBeat.o(202252);
    }
}
