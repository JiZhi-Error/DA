package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.mmsight.segment.SliderSeekBar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0002J\b\u0010\u0011\u001a\u00020\fH\u0014¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSliderSeekBar;", "Lcom/tencent/mm/plugin/mmsight/segment/SliderSeekBar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "barMode", "", "getUnscaledDrawable", "Landroid/graphics/drawable/Drawable;", "drawableRes", "iconSize", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "plugin-mv_release"})
public final class MusicMvSliderSeekBar extends SliderSeekBar {
    public MusicMvSliderSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MusicMvSliderSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.SliderSeekBar
    public final void init() {
        AppMethodBeat.i(257611);
        super.init();
        this.zxz = a.fromDPToPix(getContext(), 16);
        this.zxA = ((float) this.zxz) * 0.5f;
        this.zxM = a.fromDPToPix(getContext(), 16);
        ekA();
        AppMethodBeat.o(257611);
    }

    private final Drawable hy(int i2, int i3) {
        AppMethodBeat.i(257612);
        Context context = getContext();
        p.g(context, "context");
        Drawable drawable = context.getResources().getDrawable(i2);
        p.g(drawable, "drawable");
        float intrinsicWidth = (1.0f * ((float) i3)) / ((float) drawable.getIntrinsicWidth());
        Context context2 = getContext();
        p.g(context2, "context");
        Drawable a2 = com.tencent.mm.svg.a.a.a(context2.getResources(), i2, intrinsicWidth);
        p.g(a2, "SVGCompat.getSVGDrawable…rces, drawableRes, scale)");
        AppMethodBeat.o(257612);
        return a2;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.SliderSeekBar
    public final void ekC() {
        AppMethodBeat.i(257613);
        int fromDPToPix = a.fromDPToPix(getContext(), 16);
        this.zxx = new SliderSeekBar.b(hy(R.raw.music_mv_left_bar, fromDPToPix), hy(R.raw.music_mv_left_bar, fromDPToPix));
        this.zxy = new SliderSeekBar.b(hy(R.raw.music_mv_right_bar, fromDPToPix), hy(R.raw.music_mv_right_bar, fromDPToPix));
        this.zxP = true;
        postInvalidate();
        AppMethodBeat.o(257613);
    }
}
