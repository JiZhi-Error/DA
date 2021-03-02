package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH\u0002J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\tH\u0014J\b\u0010\u001b\u001a\u00020\u0014H\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0016R\u000e\u0010\u000b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/StoryMuteView;", "Lcom/tencent/mm/plugin/story/api/AbsStoryMuteView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MUTE_IN_BG_PADDING", "MUTE_OUT_BG_PADDING", "mMuteBg", "Landroid/widget/ImageView;", "mMuteTv", "Landroid/widget/TextView;", "muteDrawable", "Landroid/graphics/drawable/Drawable;", "initViews", "", "measureDimension", "defaultSize", "parentMeasureSpec", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "triggerMuteIn", "triggerMuteOut", "plugin-story_release"})
public final class StoryMuteView extends AbsStoryMuteView {
    private final int FDP = 30;
    private final int FDQ;
    private Drawable FDR;
    private TextView FDS;
    private ImageView FDT;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoryMuteView(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(120281);
        blb();
        AppMethodBeat.o(120281);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoryMuteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(120282);
        blb();
        AppMethodBeat.o(120282);
    }

    public StoryMuteView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(120283);
        blb();
        AppMethodBeat.o(120283);
    }

    private final void blb() {
        AppMethodBeat.i(120276);
        LayoutInflater.from(getContext()).inflate(R.layout.c0p, this);
        this.FDS = (TextView) findViewById(R.id.ic8);
        this.FDT = (ImageView) findViewById(R.id.ic7);
        Context context = getContext();
        p.g(context, "context");
        this.FDR = ar.e(context.getResources().getDrawable(R.raw.icons_outlined_volume_off), -1);
        Drawable drawable = this.FDR;
        if (drawable == null) {
            p.hyc();
        }
        drawable.setBounds(0, 0, a.fromDPToPix(getContext(), 48), a.fromDPToPix(getContext(), 48));
        TextView textView = this.FDS;
        if (textView != null) {
            textView.setCompoundDrawables(null, this.FDR, null, null);
        }
        TextView textView2 = this.FDS;
        if (textView2 != null) {
            Context context2 = getContext();
            p.g(context2, "context");
            textView2.setText(context2.getResources().getString(R.string.hio));
        }
        ImageView imageView = this.FDT;
        if (imageView != null) {
            imageView.setPadding(this.FDQ, this.FDP, this.FDP, this.FDQ);
            AppMethodBeat.o(120276);
            return;
        }
        AppMethodBeat.o(120276);
    }

    private static int jg(int i2, int i3) {
        AppMethodBeat.i(120277);
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == 1073741824) {
            i2 = size;
        } else if (mode == Integer.MIN_VALUE) {
            i2 = Math.min(i2, size);
        }
        AppMethodBeat.o(120277);
        return i2;
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(120278);
        int jg = jg(a.aH(getContext(), R.dimen.agu), i2);
        int jg2 = jg(a.aH(getContext(), R.dimen.agu), i3);
        super.onMeasure(i2, i3);
        setMeasuredDimension(jg, jg2);
        AppMethodBeat.o(120278);
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryMuteView
    public final void fmV() {
        AppMethodBeat.i(120279);
        ImageView imageView = this.FDT;
        if (imageView != null) {
            imageView.setPadding(this.FDQ, this.FDQ, this.FDQ, this.FDQ);
            AppMethodBeat.o(120279);
            return;
        }
        AppMethodBeat.o(120279);
    }

    @Override // com.tencent.mm.plugin.story.api.AbsStoryMuteView
    public final void fmW() {
        AppMethodBeat.i(120280);
        ImageView imageView = this.FDT;
        if (imageView != null) {
            imageView.setPadding(this.FDQ, this.FDP, this.FDP, this.FDQ);
            AppMethodBeat.o(120280);
            return;
        }
        AppMethodBeat.o(120280);
    }
}
