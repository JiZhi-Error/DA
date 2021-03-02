package com.tencent.mm.plugin.music.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\tJ\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\tJ\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\tH\u0002R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/music/ui/view/MusicMainSeekBar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isSeeking", "", "()Z", "setSeeking", "(Z)V", "maxDuration", "maxDurationStr", "", "onSeekBarChange", "Lcom/tencent/mm/plugin/music/ui/view/MusicMainSeekBar$OnSeekBarChange;", "initView", "", "setMaxProgress", "totalDuration", "setOnSeekBarChange", "setProgress", "currentPos", "updateTimeInfoText", "Companion", "OnSeekBarChange", "plugin-music_release"})
public final class MusicMainSeekBar extends FrameLayout {
    public static final a Aon = new a((byte) 0);
    private b Aol;
    private String Aom;
    private HashMap _$_findViewCache;
    private int maxDuration;
    private boolean oyR;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/music/ui/view/MusicMainSeekBar$OnSeekBarChange;", "", "onSeekBarChange", "", "seekPosition", "", "max", "onSeekEnd", "onSeekStart", "plugin-music_release"})
    public interface b {
        void evo();

        void hv(int i2, int i3);

        void hw(int i2, int i3);
    }

    static {
        AppMethodBeat.i(220050);
        AppMethodBeat.o(220050);
    }

    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(220052);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(220052);
        return view;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MusicMainSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(220048);
        this.Aom = "04:00";
        View.inflate(getContext(), R.layout.be0, this);
        getResources().getDrawable(R.drawable.amd);
        ((SeekBar) _$_findCachedViewById(R.id.hgm)).setOnSeekBarChangeListener(new c(this));
        ((SeekBar) _$_findCachedViewById(R.id.hgm)).setOnTouchListener(d.Aop);
        AppMethodBeat.o(220048);
    }

    public static final /* synthetic */ void a(MusicMainSeekBar musicMainSeekBar, int i2) {
        AppMethodBeat.i(220051);
        musicMainSeekBar.Tf(i2);
        AppMethodBeat.o(220051);
    }

    public final void setSeeking(boolean z) {
        this.oyR = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MusicMainSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(220049);
        AppMethodBeat.o(220049);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/music/ui/view/MusicMainSeekBar$initView$1", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "plugin-music_release"})
    public static final class c implements SeekBar.OnSeekBarChangeListener {
        final /* synthetic */ MusicMainSeekBar Aoo;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(MusicMainSeekBar musicMainSeekBar) {
            this.Aoo = musicMainSeekBar;
        }

        public final void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            AppMethodBeat.i(220039);
            if (z) {
                MusicMainSeekBar.a(this.Aoo, i2);
                if (seekBar != null) {
                    b bVar = this.Aoo.Aol;
                    if (bVar != null) {
                        bVar.hw(seekBar.getProgress(), seekBar.getMax());
                        AppMethodBeat.o(220039);
                        return;
                    }
                    AppMethodBeat.o(220039);
                    return;
                }
            }
            AppMethodBeat.o(220039);
        }

        public final void onStartTrackingTouch(SeekBar seekBar) {
            int i2;
            AppMethodBeat.i(220040);
            this.Aoo.setSeeking(true);
            LinearLayout linearLayout = (LinearLayout) this.Aoo._$_findCachedViewById(R.id.imr);
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            MusicMainSeekBar musicMainSeekBar = this.Aoo;
            if (seekBar != null) {
                i2 = seekBar.getProgress();
            } else {
                i2 = 0;
            }
            MusicMainSeekBar.a(musicMainSeekBar, i2);
            b bVar = this.Aoo.Aol;
            if (bVar != null) {
                bVar.evo();
                AppMethodBeat.o(220040);
                return;
            }
            AppMethodBeat.o(220040);
        }

        public final void onStopTrackingTouch(SeekBar seekBar) {
            AppMethodBeat.i(220041);
            this.Aoo.setSeeking(false);
            LinearLayout linearLayout = (LinearLayout) this.Aoo._$_findCachedViewById(R.id.imr);
            if (linearLayout != null) {
                linearLayout.setVisibility(4);
            }
            if (seekBar != null) {
                b bVar = this.Aoo.Aol;
                if (bVar != null) {
                    bVar.hv(seekBar.getProgress(), seekBar.getMax());
                    AppMethodBeat.o(220041);
                    return;
                }
                AppMethodBeat.o(220041);
                return;
            }
            AppMethodBeat.o(220041);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
    static final class d implements View.OnTouchListener {
        public static final d Aop = new d();

        static {
            AppMethodBeat.i(220043);
            AppMethodBeat.o(220043);
        }

        d() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(220042);
            p.g(motionEvent, "event");
            switch (motionEvent.getAction()) {
                case 0:
                    p.g(view, "v");
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                case 1:
                    p.g(view, "v");
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    break;
            }
            view.onTouchEvent(motionEvent);
            AppMethodBeat.o(220042);
            return true;
        }
    }

    public final void setOnSeekBarChange(b bVar) {
        AppMethodBeat.i(220044);
        p.h(bVar, "onSeekBarChange");
        this.Aol = bVar;
        AppMethodBeat.o(220044);
    }

    public final void setProgress(int i2) {
        AppMethodBeat.i(220045);
        if (this.oyR) {
            AppMethodBeat.o(220045);
            return;
        }
        Tf(i2);
        SeekBar seekBar = (SeekBar) _$_findCachedViewById(R.id.hgm);
        p.g(seekBar, "seekBar");
        seekBar.setProgress(i2);
        AppMethodBeat.o(220045);
    }

    private final void Tf(int i2) {
        AppMethodBeat.i(220046);
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.imr);
        p.g(linearLayout, "timeInfoLayout");
        if (linearLayout.getVisibility() == 0) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.imp);
            if (textView != null) {
                textView.setText(a.Ar(i2));
            }
            TextView textView2 = (TextView) _$_findCachedViewById(R.id.imq);
            if (textView2 != null) {
                textView2.setText(" / " + this.Aom);
                AppMethodBeat.o(220046);
                return;
            }
        }
        AppMethodBeat.o(220046);
    }

    public final void setMaxProgress(int i2) {
        AppMethodBeat.i(220047);
        this.maxDuration = i2;
        this.Aom = a.Ar(i2);
        SeekBar seekBar = (SeekBar) _$_findCachedViewById(R.id.hgm);
        p.g(seekBar, "seekBar");
        seekBar.setMax(i2);
        new StringBuilder("maxDuration:").append(this.Aom).append(", ").append(i2);
        h.hkS();
        AppMethodBeat.o(220047);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/music/ui/view/MusicMainSeekBar$Companion;", "", "()V", "TAG", "", "timeParse", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "plugin-music_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static String Ar(int i2) {
            AppMethodBeat.i(220038);
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
            AppMethodBeat.o(220038);
            return sb2;
        }
    }
}
