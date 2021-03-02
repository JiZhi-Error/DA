package com.tencent.mm.plugin.music.ui.view;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000f\u0018\u0000 &2\u00020\u0001:\u0002&'B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fJ\b\u0010\u001b\u001a\u00020\u0019H\u0002J\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\tJ\u0006\u0010\u001e\u001a\u00020\u0019J\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\tJ\u000e\u0010!\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\tJ\u000e\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\tR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/music/ui/view/MusicPlayerSeekBar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isSeeking", "", "()Z", "setSeeking", "(Z)V", "onSeekBarChange", "Lcom/tencent/mm/plugin/music/ui/view/MusicPlayerSeekBar$OnSeekBarChange;", "thumbDrawable", "Landroid/graphics/drawable/Drawable;", "getThumbDrawable", "()Landroid/graphics/drawable/Drawable;", "setThumbDrawable", "(Landroid/graphics/drawable/Drawable;)V", "enableLoading", "", "enable", "initView", "setColor", "color", "setGravityNoSpan", "setMaxProgress", "totalDuration", "setOnSeekBarChange", "setProgress", "currentPos", "setTextSize", "textSize", "Companion", "OnSeekBarChange", "plugin-music_release"})
public final class MusicPlayerSeekBar extends FrameLayout {
    public static final a AoV = new a((byte) 0);
    private b AoU;
    private HashMap _$_findViewCache;
    private boolean oyR;
    private Drawable oyT;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/music/ui/view/MusicPlayerSeekBar$OnSeekBarChange;", "", "onSeekBarChange", "", "seekPosition", "", "plugin-music_release"})
    public interface b {
    }

    static {
        AppMethodBeat.i(220068);
        AppMethodBeat.o(220068);
    }

    private View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(220069);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(220069);
        return view;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MusicPlayerSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(220066);
        View.inflate(getContext(), R.layout.bel, this);
        TextView textView = (TextView) _$_findCachedViewById(R.id.bjc);
        if (textView == null) {
            p.hyc();
        }
        textView.setText("00:00");
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.c3o);
        if (textView2 == null) {
            p.hyc();
        }
        textView2.setText("--:--");
        this.oyT = getResources().getDrawable(R.drawable.amd);
        Util.expandViewTouchArea((SeekBar) _$_findCachedViewById(R.id.flb), 100, 100, 100, 100);
        ((SeekBar) _$_findCachedViewById(R.id.flb)).setOnSeekBarChangeListener(new c(this));
        AppMethodBeat.o(220066);
    }

    public final void setSeeking(boolean z) {
        this.oyR = z;
    }

    public final Drawable getThumbDrawable() {
        return this.oyT;
    }

    public final void setThumbDrawable(Drawable drawable) {
        this.oyT = drawable;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MusicPlayerSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(220067);
        AppMethodBeat.o(220067);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/music/ui/view/MusicPlayerSeekBar$initView$1", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "mpSeekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "plugin-music_release"})
    public static final class c implements SeekBar.OnSeekBarChangeListener {
        final /* synthetic */ MusicPlayerSeekBar AoW;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(MusicPlayerSeekBar musicPlayerSeekBar) {
            this.AoW = musicPlayerSeekBar;
        }

        public final void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        }

        public final void onStartTrackingTouch(SeekBar seekBar) {
            AppMethodBeat.i(220059);
            this.AoW.setSeeking(true);
            AppMethodBeat.o(220059);
        }

        public final void onStopTrackingTouch(SeekBar seekBar) {
            AppMethodBeat.i(220060);
            this.AoW.setSeeking(false);
            if (this.AoW.AoU != null) {
                if (this.AoW.AoU == null) {
                    p.hyc();
                }
                if (seekBar == null) {
                    p.hyc();
                }
                seekBar.getProgress();
            }
            AppMethodBeat.o(220060);
        }
    }

    public final void setOnSeekBarChange(b bVar) {
        AppMethodBeat.i(220061);
        p.h(bVar, "onSeekBarChange");
        this.AoU = bVar;
        AppMethodBeat.o(220061);
    }

    public final void setTextSize(int i2) {
        AppMethodBeat.i(220062);
        TextView textView = (TextView) _$_findCachedViewById(R.id.bjc);
        if (textView == null) {
            p.hyc();
        }
        textView.setTextSize(0, (float) i2);
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.c3o);
        if (textView2 == null) {
            p.hyc();
        }
        textView2.setTextSize(0, (float) i2);
        AppMethodBeat.o(220062);
    }

    public final void setColor(int i2) {
        AppMethodBeat.i(220063);
        TextView textView = (TextView) _$_findCachedViewById(R.id.bjc);
        if (textView == null) {
            p.hyc();
        }
        textView.setTextColor(i2);
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.c3o);
        if (textView2 == null) {
            p.hyc();
        }
        textView2.setTextColor(i2);
        SeekBar seekBar = (SeekBar) _$_findCachedViewById(R.id.flb);
        if (seekBar == null) {
            p.hyc();
        }
        seekBar.getProgressDrawable().setColorFilter(i2, PorterDuff.Mode.MULTIPLY);
        SeekBar seekBar2 = (SeekBar) _$_findCachedViewById(R.id.flb);
        if (seekBar2 == null) {
            p.hyc();
        }
        seekBar2.getThumb().setColorFilter(i2, PorterDuff.Mode.MULTIPLY);
        Drawable drawable = this.oyT;
        if (drawable == null) {
            p.hyc();
        }
        drawable.setColorFilter(i2, PorterDuff.Mode.MULTIPLY);
        _$_findCachedViewById(R.id.d5_).setBackgroundColor(i2);
        AppMethodBeat.o(220063);
    }

    public final void setProgress(int i2) {
        AppMethodBeat.i(220064);
        if (this.oyR) {
            AppMethodBeat.o(220064);
            return;
        }
        TextView textView = (TextView) _$_findCachedViewById(R.id.bjc);
        if (textView == null) {
            p.hyc();
        }
        textView.setText(a.Ar(i2));
        SeekBar seekBar = (SeekBar) _$_findCachedViewById(R.id.flb);
        if (seekBar == null) {
            p.hyc();
        }
        seekBar.setProgress(i2);
        if (i2 > 0) {
            View _$_findCachedViewById = _$_findCachedViewById(R.id.d5_);
            p.g(_$_findCachedViewById, "firstPart");
            _$_findCachedViewById.setAlpha(1.0f);
        }
        AppMethodBeat.o(220064);
    }

    public final void setMaxProgress(int i2) {
        AppMethodBeat.i(220065);
        TextView textView = (TextView) _$_findCachedViewById(R.id.c3o);
        if (textView == null) {
            p.hyc();
        }
        textView.setText(a.Ar(i2));
        SeekBar seekBar = (SeekBar) _$_findCachedViewById(R.id.flb);
        if (seekBar == null) {
            p.hyc();
        }
        seekBar.setMax(i2);
        AppMethodBeat.o(220065);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/music/ui/view/MusicPlayerSeekBar$Companion;", "", "()V", "TAG", "", "timeParse", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "plugin-music_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static String Ar(int i2) {
            AppMethodBeat.i(220058);
            StringBuilder sb = new StringBuilder();
            long j2 = ((long) i2) / Util.MILLSECONDS_OF_MINUTE;
            long floor = (long) Math.floor(((double) (((long) i2) % Util.MILLSECONDS_OF_MINUTE)) / 1000.0d);
            if (j2 < 10) {
                sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            sb.append(new StringBuilder().append(j2).append(':').toString());
            if (floor < 10) {
                sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            sb.append(floor);
            String sb2 = sb.toString();
            p.g(sb2, "time.toString()");
            AppMethodBeat.o(220058);
            return sb2;
        }
    }
}
