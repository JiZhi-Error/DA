package com.tencent.mm.plugin.finder.view.indictor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.h;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010 \u001a\u00020\nH\u0016J\b\u0010!\u001a\u00020\nH\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010#\u001a\u00020$H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020)2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\nH\u0016J\u0010\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020\u001fH\u0016J\u0010\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020\u001dH\u0016R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0015\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaBannerIndicator;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/view/IMediaBannerIndicator;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "count", "currentIndex", "indicatorLeft", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getIndicatorLeft", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "indicatorLeft$delegate", "Lkotlin/Lazy;", "indicatorRight", "getIndicatorRight", "indicatorRight$delegate", "indicatorTv", "Landroid/widget/TextView;", "getIndicatorTv", "()Landroid/widget/TextView;", "indicatorTv$delegate", "isShowOnlyOneIndicator", "", "onSelectedPageListener", "Lcom/tencent/mm/view/IMediaBannerIndicator$OnSelectedPageListener;", "getCount", "getCurrentIndex", "getOnSelectedPageListener", "getView", "Landroid/view/View;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setCount", "", "setCurrentIndex", "i", "setOnSelectedPageListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setShowOnlyOneIndicator", "isShow", "plugin-finder_release"})
public final class FinderMediaBannerIndicator extends LinearLayout implements h {
    private int count;
    private int currentIndex;
    private final f wsl = g.ah(new c(this));
    private final f wsm = g.ah(new a(this));
    private final f wsn = g.ah(new b(this));
    private h.a wso;
    private boolean wsp = true;

    private final WeImageView getIndicatorLeft() {
        AppMethodBeat.i(255216);
        WeImageView weImageView = (WeImageView) this.wsm.getValue();
        AppMethodBeat.o(255216);
        return weImageView;
    }

    private final WeImageView getIndicatorRight() {
        AppMethodBeat.i(255217);
        WeImageView weImageView = (WeImageView) this.wsn.getValue();
        AppMethodBeat.o(255217);
        return weImageView;
    }

    private final TextView getIndicatorTv() {
        AppMethodBeat.i(255215);
        TextView textView = (TextView) this.wsl.getValue();
        AppMethodBeat.o(255215);
        return textView;
    }

    public FinderMediaBannerIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(255222);
        LayoutInflater.from(getContext()).inflate(R.layout.agf, (ViewGroup) this, true);
        AppMethodBeat.o(255222);
    }

    public FinderMediaBannerIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(255223);
        LayoutInflater.from(getContext()).inflate(R.layout.agf, (ViewGroup) this, true);
        AppMethodBeat.o(255223);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        h.a aVar;
        h.a aVar2;
        AppMethodBeat.i(255218);
        p.h(motionEvent, "event");
        if (motionEvent.getAction() == 1) {
            if (motionEvent.getX() <= ((float) (getWidth() / 2))) {
                if (this.currentIndex > 0 && (aVar2 = this.wso) != null) {
                    aVar2.Ir(this.currentIndex - 1);
                }
            } else if (this.currentIndex + 1 < this.count && (aVar = this.wso) != null) {
                aVar.Ir(this.currentIndex + 1);
            }
        }
        AppMethodBeat.o(255218);
        return true;
    }

    @Override // com.tencent.mm.view.h
    public final void setShowOnlyOneIndicator(boolean z) {
        this.wsp = z;
    }

    @Override // com.tencent.mm.view.h
    public final void setCount(int i2) {
        AppMethodBeat.i(255219);
        this.count = i2;
        setCurrentIndex(0);
        AppMethodBeat.o(255219);
    }

    @Override // com.tencent.mm.view.h
    public final int getCount() {
        return this.count;
    }

    @Override // com.tencent.mm.view.h
    public final void setCurrentIndex(int i2) {
        int i3;
        AppMethodBeat.i(255220);
        if (i2 + 1 > this.count) {
            i3 = 0;
        } else {
            i3 = i2;
        }
        if (this.count == 1) {
            WeImageView indicatorRight = getIndicatorRight();
            Context context = getContext();
            p.g(context, "context");
            indicatorRight.setIconColor(context.getResources().getColor(R.color.v2));
            WeImageView indicatorLeft = getIndicatorLeft();
            Context context2 = getContext();
            p.g(context2, "context");
            indicatorLeft.setIconColor(context2.getResources().getColor(R.color.v2));
        } else if (i3 == 0) {
            WeImageView indicatorLeft2 = getIndicatorLeft();
            Context context3 = getContext();
            p.g(context3, "context");
            indicatorLeft2.setIconColor(context3.getResources().getColor(R.color.v2));
            WeImageView indicatorRight2 = getIndicatorRight();
            Context context4 = getContext();
            p.g(context4, "context");
            indicatorRight2.setIconColor(context4.getResources().getColor(R.color.v9));
        } else if (i2 + 1 == this.count) {
            WeImageView indicatorRight3 = getIndicatorRight();
            Context context5 = getContext();
            p.g(context5, "context");
            indicatorRight3.setIconColor(context5.getResources().getColor(R.color.v2));
            WeImageView indicatorLeft3 = getIndicatorLeft();
            Context context6 = getContext();
            p.g(context6, "context");
            indicatorLeft3.setIconColor(context6.getResources().getColor(R.color.v9));
        }
        this.currentIndex = i2;
        getIndicatorTv().setText((i3 + 1) + " / " + this.count);
        AppMethodBeat.o(255220);
    }

    public final int getCurrentIndex() {
        return this.currentIndex;
    }

    @Override // com.tencent.mm.view.h
    public final View getView() {
        return this;
    }

    @Override // com.tencent.mm.view.h
    public final void setOnSelectedPageListener(h.a aVar) {
        AppMethodBeat.i(255221);
        p.h(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.wso = aVar;
        AppMethodBeat.o(255221);
    }

    public final h.a getOnSelectedPageListener() {
        return this.wso;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c extends q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ FinderMediaBannerIndicator wsq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderMediaBannerIndicator finderMediaBannerIndicator) {
            super(0);
            this.wsq = finderMediaBannerIndicator;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(255214);
            TextView textView = (TextView) this.wsq.findViewById(R.id.dxz);
            AppMethodBeat.o(255214);
            return textView;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a extends q implements kotlin.g.a.a<WeImageView> {
        final /* synthetic */ FinderMediaBannerIndicator wsq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(FinderMediaBannerIndicator finderMediaBannerIndicator) {
            super(0);
            this.wsq = finderMediaBannerIndicator;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ WeImageView invoke() {
            AppMethodBeat.i(255212);
            WeImageView weImageView = (WeImageView) this.wsq.findViewById(R.id.dxx);
            AppMethodBeat.o(255212);
            return weImageView;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends q implements kotlin.g.a.a<WeImageView> {
        final /* synthetic */ FinderMediaBannerIndicator wsq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderMediaBannerIndicator finderMediaBannerIndicator) {
            super(0);
            this.wsq = finderMediaBannerIndicator;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ WeImageView invoke() {
            AppMethodBeat.i(255213);
            WeImageView weImageView = (WeImageView) this.wsq.findViewById(R.id.dxy);
            AppMethodBeat.o(255213);
            return weImageView;
        }
    }
}
