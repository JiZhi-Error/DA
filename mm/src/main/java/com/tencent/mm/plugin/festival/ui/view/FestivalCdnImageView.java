package com.tencent.mm.plugin.festival.ui.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.b;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.ui.MMImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\tH\u0014R(\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/view/FestivalCdnImageView;", "Lcom/tencent/mm/ui/MMImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "url", "", "imageCdnUrl", "getImageCdnUrl", "()Ljava/lang/String;", "setImageCdnUrl", "(Ljava/lang/String;)V", "loader", "Lcom/tencent/mm/modelimage/loader/ImageLoader;", "getLoader", "()Lcom/tencent/mm/modelimage/loader/ImageLoader;", "setLoader", "(Lcom/tencent/mm/modelimage/loader/ImageLoader;)V", "placeholderDrawable", "Landroid/graphics/drawable/Drawable;", "getPlaceholderDrawable", "()Landroid/graphics/drawable/Drawable;", "setPlaceholderDrawable", "(Landroid/graphics/drawable/Drawable;)V", "showCircleImage", "", "getShowCircleImage", "()Z", "setShowCircleImage", "(Z)V", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "plugin-festival_release"})
public final class FestivalCdnImageView extends MMImageView {
    private a UFK;
    private String UFL;
    private boolean UFM;
    private Drawable aMY;

    public FestivalCdnImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(263442);
        a bcV = q.bcV();
        if (bcV == null) {
            p.hyc();
        }
        this.UFK = bcV;
        this.UFL = "";
        this.aMY = b.l(getContext(), R.raw.default_avatar_round);
        AppMethodBeat.o(263442);
    }

    public FestivalCdnImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(263443);
        a bcV = q.bcV();
        if (bcV == null) {
            p.hyc();
        }
        this.UFK = bcV;
        this.UFL = "";
        this.aMY = b.l(getContext(), R.raw.default_avatar_round);
        AppMethodBeat.o(263443);
    }

    public final a getLoader() {
        return this.UFK;
    }

    public final void setLoader(a aVar) {
        AppMethodBeat.i(263439);
        p.h(aVar, "<set-?>");
        this.UFK = aVar;
        AppMethodBeat.o(263439);
    }

    public final String getImageCdnUrl() {
        return this.UFL;
    }

    public final void setImageCdnUrl(String str) {
        AppMethodBeat.i(263440);
        this.UFK.a(this.UFL, this);
        a aVar = this.UFK;
        FestivalCdnImageView festivalCdnImageView = this;
        c.a aVar2 = new c.a();
        if (isLaidOut()) {
            aVar2.tw(getMeasuredWidth());
            aVar2.tx(getMeasuredHeight());
        } else {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null && layoutParams.width > 0 && layoutParams.height > 0) {
                aVar2.tw(layoutParams.width);
                aVar2.tx(layoutParams.height);
            }
        }
        aVar2.x(this.aMY);
        aVar2.bdt();
        aVar.a(str, festivalCdnImageView, aVar2.bdv());
        this.UFL = str;
        AppMethodBeat.o(263440);
    }

    public final Drawable getPlaceholderDrawable() {
        return this.aMY;
    }

    public final void setPlaceholderDrawable(Drawable drawable) {
        this.aMY = drawable;
    }

    public final boolean getShowCircleImage() {
        return this.UFM;
    }

    public final void setShowCircleImage(boolean z) {
        this.UFM = z;
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(263441);
        super.onMeasure(i2, i3);
        if (getMeasuredWidth() == getMeasuredHeight()) {
            setScaleType(ImageView.ScaleType.FIT_XY);
        }
        AppMethodBeat.o(263441);
    }
}
