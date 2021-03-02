package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ad.g.e;
import com.tencent.mm.plugin.sns.ad.g.o;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.protocal.protobuf.eco;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;

public class AdListView extends ListView {
    e Enb;
    f Enc;
    private com.tencent.mm.plugin.sns.model.e End;
    private boolean Ene = true;
    private HashSet<String> Enf = new HashSet<>();
    private int Eng = -1;
    private int Enh = -1;
    private int rZ = -1;

    public AdListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(97673);
        AppMethodBeat.o(97673);
    }

    public AdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(97674);
        AppMethodBeat.o(97674);
    }

    public void setTimelineStat(f fVar) {
        this.Enc = fVar;
    }

    public void setTimelineEvent(com.tencent.mm.plugin.sns.model.e eVar) {
        this.End = eVar;
    }

    /* access modifiers changed from: protected */
    public void layoutChildren() {
        AppMethodBeat.i(97675);
        super.layoutChildren();
        AppMethodBeat.o(97675);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(97676);
        super.onLayout(z, i2, i3, i4, i5);
        AppMethodBeat.o(97676);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public void detachViewFromParent(View view) {
        AppMethodBeat.i(97677);
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
            BaseTimeLineItem.BaseViewHolder baseViewHolder = (BaseTimeLineItem.BaseViewHolder) view.getTag();
            str = baseViewHolder.position + " " + baseViewHolder.dHp;
        }
        if (ac.jPe) {
            Log.d("MicroMsg.AdListView", "1childview  onRemoved " + str + " count:" + getChildCount());
        }
        super.detachViewFromParent(view);
        AppMethodBeat.o(97677);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public void detachViewFromParent(int i2) {
        AppMethodBeat.i(97678);
        if (ac.jPe) {
            Log.d("MicroMsg.AdListView", "2childview  onRemoved " + i2 + " count:" + getChildCount());
        }
        super.detachViewFromParent(i2);
        AppMethodBeat.o(97678);
    }

    /* access modifiers changed from: protected */
    public void attachViewToParent(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(97679);
        super.attachViewToParent(view, i2, layoutParams);
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
            BaseTimeLineItem.BaseViewHolder baseViewHolder = (BaseTimeLineItem.BaseViewHolder) view.getTag();
            String str2 = baseViewHolder.position + " " + baseViewHolder.dHp;
            com.tencent.mm.plugin.sns.k.e.DUQ.ck(baseViewHolder.timeLineObject.Id, baseViewHolder.timeLineObject.sightFolded == 1 || baseViewHolder.timeLineObject.showFlag == 1);
            com.tencent.mm.plugin.sns.k.e.DUQ.kq(baseViewHolder.timeLineObject.Id, baseViewHolder.timeLineObject.AppInfo == null ? "" : baseViewHolder.timeLineObject.AppInfo.Id);
            com.tencent.mm.plugin.sns.k.e.DUQ.Jz(baseViewHolder.EWu);
            if (this.Enb != null && baseViewHolder.isAd) {
                this.Enb.a(baseViewHolder.position, baseViewHolder.dHp, baseViewHolder.xEm, view, baseViewHolder.EWu, baseViewHolder.snsobj, baseViewHolder.qcr, 1);
            }
            if (!this.Enf.contains(baseViewHolder.dRS) && ((baseViewHolder.isAd && baseViewHolder.timeLineObject.ContentObj.LoU == 15) || baseViewHolder.timeLineObject.ContentObj.LoU == 18)) {
                boolean z = false;
                if (baseViewHolder.timeLineObject.ContentObj.LoU == 15 && (baseViewHolder.EUK.Ews instanceof SightPlayImageView)) {
                    z = baseViewHolder.EUK.Ews.Dnr.eVy();
                }
                o.a(aj.faO().aQl(baseViewHolder.dRS), false, z, 0);
                this.Enf.add(baseViewHolder.dRS);
            }
            if (this.Enc != null) {
                this.Enc.a(baseViewHolder.dHp, baseViewHolder.timeLineObject);
            }
            if (this.End != null) {
                this.End.a(baseViewHolder.position, baseViewHolder.dHp, baseViewHolder.EWu, baseViewHolder.timeLineObject, baseViewHolder.isAd, baseViewHolder.DDr);
            }
            g(baseViewHolder);
            str = str2;
        }
        if (ac.jPe) {
            Log.d("MicroMsg.AdListView", "3childview  onAdded " + str + " count:" + getChildCount());
        }
        AppMethodBeat.o(97679);
    }

    public void onViewAdded(View view) {
        AppMethodBeat.i(97680);
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
            BaseTimeLineItem.BaseViewHolder baseViewHolder = (BaseTimeLineItem.BaseViewHolder) view.getTag();
            String str2 = baseViewHolder.position + " " + baseViewHolder.dHp;
            com.tencent.mm.plugin.sns.k.e.DUQ.ck(baseViewHolder.timeLineObject.Id, baseViewHolder.timeLineObject.sightFolded == 1 || baseViewHolder.timeLineObject.showFlag == 1);
            com.tencent.mm.plugin.sns.k.e.DUQ.kq(baseViewHolder.timeLineObject.Id, baseViewHolder.timeLineObject.AppInfo == null ? "" : baseViewHolder.timeLineObject.AppInfo.Id);
            com.tencent.mm.plugin.sns.k.e.DUQ.Jz(baseViewHolder.EWu);
            if (this.Enb != null && baseViewHolder.isAd) {
                this.Enb.a(baseViewHolder.position, baseViewHolder.dHp, baseViewHolder.xEm, view, baseViewHolder.EWu, baseViewHolder.snsobj, baseViewHolder.qcr, 1);
            }
            if (!this.Enf.contains(baseViewHolder.dRS) && ((baseViewHolder.isAd && baseViewHolder.timeLineObject.ContentObj.LoU == 15) || baseViewHolder.timeLineObject.ContentObj.LoU == 18)) {
                boolean z = false;
                if (baseViewHolder.timeLineObject.ContentObj.LoU == 15 && (baseViewHolder.EUK.Ews instanceof SightPlayImageView)) {
                    z = baseViewHolder.EUK.Ews.Dnr.eVy();
                }
                o.a(aj.faO().aQl(baseViewHolder.dRS), false, z, 0);
                this.Enf.add(baseViewHolder.dRS);
            }
            if (this.Enc != null) {
                this.Enc.a(baseViewHolder.dHp, baseViewHolder.timeLineObject);
            }
            if (this.End != null) {
                this.End.a(baseViewHolder.position, baseViewHolder.dHp, baseViewHolder.EWu, baseViewHolder.timeLineObject, baseViewHolder.isAd, baseViewHolder.DDr);
            }
            g(baseViewHolder);
            str = str2;
        }
        if (ac.jPe) {
            Log.d("MicroMsg.AdListView", "4childview  onViewAdded " + str + " count:" + getChildCount());
        }
        AppMethodBeat.o(97680);
    }

    public void onViewRemoved(View view) {
        AppMethodBeat.i(97681);
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
            BaseTimeLineItem.BaseViewHolder baseViewHolder = (BaseTimeLineItem.BaseViewHolder) view.getTag();
            String str2 = baseViewHolder.position + " " + baseViewHolder.dHp;
            if (this.Enb != null && baseViewHolder.isAd) {
                this.Enb.a(baseViewHolder.position, baseViewHolder.dHp, baseViewHolder.EWu, 1);
            }
            if (this.Enc != null) {
                this.Enc.aOU(baseViewHolder.dHp);
            }
            if (this.End != null) {
                this.End.a(baseViewHolder.position, baseViewHolder.dHp, baseViewHolder.EWu, baseViewHolder.timeLineObject, baseViewHolder.isAd);
            }
            if (baseViewHolder.timeLineObject.ContentObj.LoU == 3) {
                SnsInfo aQl = aj.faO().aQl(baseViewHolder.dRS);
                int adRecSrc = aQl == null ? 0 : aQl.getAdRecSrc();
                p.a aVar = p.a.Sns;
                String str3 = baseViewHolder.timeLineObject.statExtStr;
                String Jb = r.Jb(baseViewHolder.EWu);
                if (!Util.isNullOrNil(str3)) {
                    byte[] bArr = new byte[0];
                    try {
                        bArr = Base64.decode(str3, 0);
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.SnsStatExtUtil", e2, "", new Object[0]);
                    }
                    eco eco = new eco();
                    try {
                        eco.parseFrom(bArr);
                        if (eco.NcH == null) {
                            str = str2;
                        } else {
                            Log.i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene(%d), statExtStr:%s(id=%s, uxinfo=%s)", Integer.valueOf(aVar.value), str3, eco.NcH.NcK, eco.NcH.KxO);
                            ((d) g.af(d.class)).a(13235, adRecSrc, new StringBuilder().append(aVar.value).toString(), eco.NcH.NcK, eco.NcH.KxO, Jb);
                        }
                    } catch (Exception e3) {
                        Log.printErrStackTrace("MicroMsg.SnsStatExtUtil", e3, "", new Object[0]);
                        str = str2;
                    }
                }
            }
            str = str2;
        }
        if (ac.jPe) {
            Log.d("MicroMsg.AdListView", "5childview  onViewRemoved " + str + " count:" + getChildCount());
        }
        AppMethodBeat.o(97681);
    }

    public void removeViewInLayout(View view) {
        AppMethodBeat.i(97682);
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
            BaseTimeLineItem.BaseViewHolder baseViewHolder = (BaseTimeLineItem.BaseViewHolder) view.getTag();
            str = baseViewHolder.position + " " + baseViewHolder.dHp;
        }
        if (ac.jPe) {
            Log.d("MicroMsg.AdListView", "6removeViewInLayout  onViewRemoved " + str + " count:" + getChildCount());
        }
        super.removeViewInLayout(view);
        AppMethodBeat.o(97682);
    }

    public void removeView(View view) {
        AppMethodBeat.i(97683);
        super.removeView(view);
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
            BaseTimeLineItem.BaseViewHolder baseViewHolder = (BaseTimeLineItem.BaseViewHolder) view.getTag();
            str = baseViewHolder.position + " " + baseViewHolder.dHp;
        }
        if (ac.jPe) {
            Log.d("MicroMsg.AdListView", "7removeView  onViewRemoved " + str + " count:" + getChildCount());
        }
        AppMethodBeat.o(97683);
    }

    /* access modifiers changed from: protected */
    public void detachViewsFromParent(int i2, int i3) {
        AppMethodBeat.i(97684);
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            View childAt = getChildAt(i4);
            String str = "";
            if (childAt.getTag() != null && (childAt.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
                BaseTimeLineItem.BaseViewHolder baseViewHolder = (BaseTimeLineItem.BaseViewHolder) childAt.getTag();
                if (this.Enb != null && baseViewHolder.isAd) {
                    this.Enb.a(baseViewHolder.position, baseViewHolder.dHp, baseViewHolder.EWu, 1);
                }
                if (this.Enc != null) {
                    this.Enc.aOU(baseViewHolder.dHp);
                }
                if (this.End != null) {
                    this.End.a(baseViewHolder.position, baseViewHolder.dHp, baseViewHolder.EWu, baseViewHolder.timeLineObject, baseViewHolder.isAd);
                }
                str = baseViewHolder.position + " " + baseViewHolder.dHp;
            }
            if (ac.jPe) {
                Log.d("MicroMsg.AdListView", "8removeView  detachViewsFromParent " + str + " count:" + getChildCount());
            }
        }
        super.detachViewsFromParent(i2, i3);
        AppMethodBeat.o(97684);
    }

    private static void g(BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(179144);
        aj.faZ().Jw(baseViewHolder.EWu);
        AppMethodBeat.o(179144);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(203227);
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (this.rZ < 0) {
            this.rZ = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        }
        int actionMasked = motionEvent.getActionMasked();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (actionMasked) {
            case 0:
                this.Enh = x;
                this.Eng = y;
                int abs = Math.abs(x - this.Enh);
                int abs2 = Math.abs(y - this.Eng);
                if (onInterceptTouchEvent && abs > abs2 && abs2 < this.rZ * 2) {
                    onInterceptTouchEvent = false;
                    break;
                }
            case 2:
                int abs3 = Math.abs(x - this.Enh);
                int abs22 = Math.abs(y - this.Eng);
                onInterceptTouchEvent = false;
                break;
        }
        AppMethodBeat.o(203227);
        return onInterceptTouchEvent;
    }
}
