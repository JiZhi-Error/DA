package com.tencent.mm.plugin.sns.k;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.l;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsHeader;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class a {
    public SnsHeader DSh;
    public boolean DSi = false;
    public ListView hUI;
    public int mScreenHeight = 0;
    public int mScreenWidth = 0;

    /* renamed from: com.tencent.mm.plugin.sns.k.a$a  reason: collision with other inner class name */
    public static class C1716a {
        public long DSj;
        public int DSk;
        public int DSl;
        public List<b> DSm;
        public int afB;
        public int mScreenHeight;
        public int mScreenWidth;
    }

    public static class b {
        public int DSA;
        public int DSB;
        public int DSn;
        public int DSo;
        public int DSp;
        public boolean DSq;
        public String DSr;
        public int DSs;
        public int DSt;
        public int DSu;
        public int DSv;
        public int DSw;
        public int DSx;
        public int DSy;
        public int DSz;
        public int aYN;
        public int aYO;
    }

    public final C1716a b(bk bkVar) {
        AppMethodBeat.i(96173);
        int i2 = l.jlv;
        if (i2 == 2) {
            AppMethodBeat.o(96173);
            return null;
        } else if (i2 != 4 || this.DSi) {
            long nanoTime = System.nanoTime();
            C1716a aVar = new C1716a();
            aVar.DSj = System.currentTimeMillis();
            aVar.mScreenHeight = this.mScreenHeight;
            aVar.mScreenWidth = this.mScreenWidth;
            int top = this.DSh.getTop();
            int height = this.DSh.getHeight();
            if (top < 0) {
                height += top;
            }
            aVar.DSl = height;
            int firstVisiblePosition = this.hUI.getFirstVisiblePosition() - 1;
            int lastVisiblePosition = this.hUI.getLastVisiblePosition() - 1;
            aVar.DSk = firstVisiblePosition;
            aVar.afB = lastVisiblePosition;
            int count = bkVar.getCount();
            boolean z = false;
            if (this.hUI.getChildAt(0) != null) {
                z = this.hUI.getChildAt(0) instanceof SnsHeader;
            }
            Log.v("MicroMsg.CaptureSnsHelper", "first last %s %s isHeaderExist %s", Integer.valueOf(firstVisiblePosition), Integer.valueOf(lastVisiblePosition), Boolean.valueOf(z));
            int i3 = z ? 1 : 0;
            int childCount = this.hUI.getChildCount();
            for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                if (i4 < count && i4 >= 0) {
                    if (i3 >= childCount) {
                        Log.e("MicroMsg.CaptureSnsHelper", "childPos biger than childCount %d %d", Integer.valueOf(i3), Integer.valueOf(childCount));
                    } else {
                        if (aVar.DSm == null) {
                            aVar.DSm = new LinkedList();
                        }
                        b bVar = new b();
                        aVar.DSm.add(bVar);
                        View childAt = this.hUI.getChildAt(i3);
                        int i5 = i3 + 1;
                        if (childAt != null) {
                            int top2 = childAt.getTop();
                            int left = childAt.getLeft();
                            int height2 = childAt.getHeight();
                            int width = childAt.getWidth();
                            SnsInfo Zv = bkVar.Zv(i4);
                            bVar.DSr = r.v(Zv);
                            bVar.DSp = Zv.field_type;
                            bVar.DSq = Zv.isAd();
                            bVar.DSn = top2;
                            bVar.DSo = left;
                            bVar.aYO = height2;
                            bVar.aYN = width;
                        }
                        if (!(childAt == null || childAt.getTag() == null || !(childAt.getTag() instanceof BaseTimeLineItem.BaseViewHolder))) {
                            BaseTimeLineItem.BaseViewHolder baseViewHolder = (BaseTimeLineItem.BaseViewHolder) childAt.getTag();
                            if (baseViewHolder.EXa && baseViewHolder.EnO != null) {
                                int top3 = baseViewHolder.EnO.getTop();
                                int left2 = baseViewHolder.EnO.getLeft();
                                int height3 = baseViewHolder.EWR.getHeight();
                                int width2 = baseViewHolder.EWR.getWidth();
                                int top4 = baseViewHolder.EWT.getTop() + top3;
                                int left3 = baseViewHolder.EWT.getLeft() + left2;
                                int height4 = baseViewHolder.EWT.getHeight();
                                int width3 = baseViewHolder.EWT.getWidth();
                                Log.v("MicroMsg.CaptureSnsHelper", "holder position %s %s index %s", Integer.valueOf(baseViewHolder.position), Integer.valueOf(i4), Integer.valueOf(i5));
                                if (baseViewHolder.snsobj.LikeCount != 0) {
                                    bVar.DSt = baseViewHolder.snsobj.LikeCount;
                                    bVar.DSu = top3;
                                    bVar.DSv = left2;
                                    bVar.DSw = width2;
                                    bVar.DSx = height3;
                                }
                                if (baseViewHolder.snsobj.CommentCount != 0) {
                                    bVar.DSs = baseViewHolder.snsobj.CommentCount;
                                    bVar.DSz = left3;
                                    bVar.DSy = top4;
                                    bVar.DSA = width3;
                                    bVar.DSB = height4;
                                }
                            }
                        }
                        i3 = i5;
                    }
                }
            }
            Log.i("MicroMsg.CaptureSnsHelper", "end cap: " + (System.nanoTime() - nanoTime));
            AppMethodBeat.o(96173);
            return aVar;
        } else {
            AppMethodBeat.o(96173);
            return null;
        }
    }
}
