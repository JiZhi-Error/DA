package com.tencent.mm.plugin.sns.ui.item;

import android.graphics.Point;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.d;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\"\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J@\u0010\u0011\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/sns/ui/item/FinderLiveTimeLineItem;", "Lcom/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem;", "()V", "TAG", "", "buildContent", "", "imagesKeeper", "Landroid/view/ViewStub;", "holder", "Lcom/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$BaseViewHolder;", "checkLiveStatus", "Lcom/tencent/mm/plugin/sns/ui/item/FinderLiveTimeLineItem$FinderLiveViewHolder;", "tlObj", "Lcom/tencent/mm/protocal/protobuf/TimeLineObject;", "snsInfo", "Lcom/tencent/mm/plugin/sns/storage/SnsInfo;", "fillItem", "position", "", "struct", "Lcom/tencent/mm/plugin/sns/ui/SnsTimeLineVendingStruct;", "viewType", "adapter", "Lcom/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter;", "getOnClickListener", "Landroid/view/View$OnClickListener;", "updateLiveStatus", "finderShareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "FinderLiveViewHolder", "plugin-sns_release"})
public class c extends BaseTimeLineItem {
    private final String TAG = "FinderLiveTimeLineItem";

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/sns/ui/item/FinderLiveTimeLineItem$FinderLiveViewHolder;", "Lcom/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$BaseViewHolder;", "()V", "coverIv", "Landroid/widget/ImageView;", "getCoverIv", "()Landroid/widget/ImageView;", "setCoverIv", "(Landroid/widget/ImageView;)V", "finderLiveEndTag", "Landroid/view/View;", "getFinderLiveEndTag", "()Landroid/view/View;", "setFinderLiveEndTag", "(Landroid/view/View;)V", "finderLiveTag", "getFinderLiveTag", "setFinderLiveTag", "finderMediaRoot", "getFinderMediaRoot", "setFinderMediaRoot", "finderMediaStubHas", "", "getFinderMediaStubHas", "()Z", "setFinderMediaStubHas", "(Z)V", "plugin-sns_release"})
    public static final class a extends BaseTimeLineItem.BaseViewHolder {
        boolean EYl;
        View EYm;
        View EYn;
        View EYo;
        ImageView puw;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008c  */
    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder r7) {
        /*
        // Method dump skipped, instructions count: 142
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.item.c.d(com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem$BaseViewHolder):void");
    }

    @Override // com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem
    public final void a(BaseTimeLineItem.BaseViewHolder baseViewHolder, int i2, bl blVar, TimeLineObject timeLineObject, int i3, bk bkVar) {
        SnsInfo snsInfo;
        AppMethodBeat.i(201818);
        if (!((timeLineObject != null ? timeLineObject.ContentObj : null) == null || timeLineObject.ContentObj.Lpc == null)) {
            if (baseViewHolder == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.sns.ui.item.FinderLiveTimeLineItem.FinderLiveViewHolder");
                AppMethodBeat.o(201818);
                throw tVar;
            }
            a aVar = (a) baseViewHolder;
            axf axf = timeLineObject.ContentObj.Lpc;
            p.g(axf, "finderShareObject");
            f(axf);
            Point ejr = aj.ejr();
            int i4 = ejr.x;
            int i5 = ejr.y;
            View view = aVar.EYm;
            Pair<Integer, Integer> a2 = n.a(i4, i5, view != null ? view.getContext() : null, false);
            Integer num = (Integer) a2.first;
            int floatValue = (int) ((((Number) a2.first).floatValue() * 3.5f) / 3.0f);
            View view2 = aVar.EYm;
            ViewGroup.LayoutParams layoutParams = view2 != null ? view2.getLayoutParams() : null;
            if (layoutParams != null) {
                layoutParams.width = num.intValue();
            }
            if (layoutParams != null) {
                layoutParams.height = floatValue;
            }
            View view3 = aVar.EYm;
            if (view3 != null) {
                view3.setLayoutParams(layoutParams);
            }
            View view4 = aVar.EYm;
            if (view4 != null) {
                view4.requestLayout();
            }
            String str = "";
            String str2 = axf.coverUrl;
            if (!(str2 == null || str2.length() == 0)) {
                String str3 = axf.coverUrl;
                p.g(str3, "finderShareObject.coverUrl");
                str = str3;
            } else {
                String str4 = axf.headUrl;
                if (!(str4 == null || str4.length() == 0)) {
                    String str5 = axf.headUrl;
                    p.g(str5, "finderShareObject.headUrl");
                    str = str5;
                }
            }
            Log.i(this.TAG, "live status:" + axf.liveStatus + " cover url:" + str);
            if (axf.liveStatus == 1) {
                View view5 = ((a) baseViewHolder).EYo;
                if (view5 != null) {
                    view5.setVisibility(8);
                }
                View view6 = ((a) baseViewHolder).EYn;
                if (view6 != null) {
                    view6.setVisibility(0);
                }
                ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).loadImage(str, ((a) baseViewHolder).puw);
                if (blVar != null) {
                    snsInfo = blVar.DqO;
                } else {
                    snsInfo = null;
                }
                a(aVar, timeLineObject, snsInfo);
            } else if (axf.liveStatus == 2) {
                View view7 = ((a) baseViewHolder).EYn;
                if (view7 != null) {
                    view7.setVisibility(8);
                }
                View view8 = ((a) baseViewHolder).EYo;
                if (view8 != null) {
                    view8.setVisibility(0);
                }
                com.tencent.mm.kernel.b.a ah = g.ah(com.tencent.mm.plugin.i.a.aj.class);
                p.g(ah, "MMKernel.plugin(IPluginFinder::class.java)");
                ((com.tencent.mm.plugin.i.a.aj) ah).getFinderUtilApi().g(((a) baseViewHolder).puw, str);
            }
            View view9 = aVar.EYm;
            if (view9 != null) {
                view9.setTag(timeLineObject);
            }
            View view10 = aVar.EYm;
            if (view10 != null) {
                if (bkVar == null) {
                    p.hyc();
                }
                view10.setOnClickListener(c(bkVar));
                AppMethodBeat.o(201818);
                return;
            }
        }
        AppMethodBeat.o(201818);
    }

    /* access modifiers changed from: protected */
    public View.OnClickListener c(bk bkVar) {
        AppMethodBeat.i(259421);
        p.h(bkVar, "adapter");
        View.OnClickListener onClickListener = bkVar.EBo.ERe;
        p.g(onClickListener, "adapter.timelineEvent.finderLiveListener");
        AppMethodBeat.o(259421);
        return onClickListener;
    }

    /* access modifiers changed from: protected */
    public void f(axf axf) {
        AppMethodBeat.i(259422);
        p.h(axf, "finderShareObject");
        AppMethodBeat.o(259422);
    }

    /* access modifiers changed from: protected */
    public void a(a aVar, TimeLineObject timeLineObject, SnsInfo snsInfo) {
        AppMethodBeat.i(259423);
        p.h(aVar, "holder");
        p.h(timeLineObject, "tlObj");
        z.f fVar = new z.f();
        fVar.SYG = (T) timeLineObject.ContentObj.Lpc;
        String str = fVar.SYG.hJs;
        p.g(str, "shareObject.liveId");
        Long buB = kotlin.n.n.buB(str);
        long longValue = buB != null ? buB.longValue() : 0;
        z.d dVar = new z.d();
        dVar.SYE = fVar.SYG.liveStatus;
        ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).refreshLiveStatus(Long.valueOf(longValue), new b(this, longValue, fVar, aVar, snsInfo, dVar, timeLineObject));
        AppMethodBeat.o(259423);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "liveId", "", "status", "", "liveInfo", "", "kotlin.jvm.PlatformType", "onLiveStatusCallback"})
    public static final class b implements aj.b {
        final /* synthetic */ c EYp;
        final /* synthetic */ long EYq;
        final /* synthetic */ z.f EYr;
        final /* synthetic */ a EYs;
        final /* synthetic */ SnsInfo EYt;
        final /* synthetic */ z.d EYu;
        final /* synthetic */ TimeLineObject EYv;

        b(c cVar, long j2, z.f fVar, a aVar, SnsInfo snsInfo, z.d dVar, TimeLineObject timeLineObject) {
            this.EYp = cVar;
            this.EYq = j2;
            this.EYr = fVar;
            this.EYs = aVar;
            this.EYt = snsInfo;
            this.EYu = dVar;
            this.EYv = timeLineObject;
        }

        @Override // com.tencent.mm.plugin.i.a.aj.b
        public final void a(long j2, int i2, Object obj) {
            boolean z;
            String str;
            AppMethodBeat.i(201816);
            Log.i(this.EYp.TAG, "[checkLiveStatus] thisLiveId:" + this.EYq + ",liveID:" + j2 + ",desc:" + this.EYr.SYG.desc + ",share liveStatus:" + this.EYr.SYG.liveStatus + ", callback liveStatus:" + i2);
            if (this.EYq == j2) {
                String str2 = this.EYr.SYG.coverUrl;
                if (!(str2 == null || str2.length() == 0)) {
                    str = this.EYr.SYG.coverUrl;
                } else {
                    String str3 = this.EYr.SYG.headUrl;
                    if (str3 == null || str3.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        str = this.EYr.SYG.headUrl;
                    } else {
                        str = "";
                    }
                }
                if (i2 == 2) {
                    View view = this.EYs.EYn;
                    if (view != null) {
                        view.setVisibility(8);
                    }
                    View view2 = this.EYs.EYo;
                    if (view2 != null) {
                        view2.setVisibility(0);
                    }
                    com.tencent.mm.kernel.b.a ah = g.ah(com.tencent.mm.plugin.i.a.aj.class);
                    p.g(ah, "MMKernel.plugin(IPluginFinder::class.java)");
                    ((com.tencent.mm.plugin.i.a.aj) ah).getFinderUtilApi().g(this.EYs.puw, str);
                } else if (i2 == 1) {
                    this.EYr.SYG.liveStatus = i2;
                    View view3 = this.EYs.EYo;
                    if (view3 != null) {
                        view3.setVisibility(8);
                    }
                    View view4 = this.EYs.EYn;
                    if (view4 != null) {
                        view4.setVisibility(0);
                    }
                }
                SnsInfo snsInfo = this.EYt;
                if (snsInfo != null) {
                    if (this.EYu.SYE == 1 && i2 == 2) {
                        this.EYr.SYG.liveStatus = i2;
                        snsInfo.setTimeLine(this.EYv);
                        d dVar = d.Emh;
                        p.h(snsInfo, "snsinfo");
                        d.bkj().sendMessage(d.bkj().obtainMessage(d.Emg, snsInfo));
                    }
                    AppMethodBeat.o(201816);
                    return;
                }
            }
            AppMethodBeat.o(201816);
        }
    }
}
