package com.tencent.mm.plugin.music.ui.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u0000 42\u00020\u0001:\u00014B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020#H\u0002J\u0010\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u0019H\u0002J\b\u0010'\u001a\u00020\u0013H\u0002J\u0016\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\tJ\b\u0010,\u001a\u00020\u0013H\u0016J\u0016\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020!J\u000e\u00100\u001a\u00020#2\u0006\u0010&\u001a\u00020\u0019J\u000e\u00101\u001a\u00020#2\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u00102\u001a\u00020#2\u0006\u0010/\u001a\u00020!H\u0002J\b\u00103\u001a\u00020#H\u0002R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u00065"}, hxF = {"Lcom/tencent/mm/plugin/music/ui/view/MarqueeLyricView;", "Landroid/support/v7/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentLine", "faceOutTask", "Ljava/lang/Runnable;", "fadeIn", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "fadeOut", "hasStartedFadeIn", "", "lyricObj", "Lcom/tencent/mm/plugin/music/model/LyricObj;", "mDistance", "mDuration", "mMinDuration", "", "mScroller", "Landroid/widget/Scroller;", "mStartX", "mXPaused", "scrollTask", "calculateScrollingLen", "lyricTxt", "", "computeScroll", "", "doFaceIn", "getLyricLine", "currentTime", "hasNoLyric", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "textSize", "", "textColor", "isFocused", "setContent", "lineCnt", "content", "setCurrentTime", "setLyricObj", "startScroll", "stopScroll", "Companion", "plugin-music_release"})
public final class MarqueeLyricView extends AppCompatTextView {
    public static final a Aof = new a((byte) 0);
    private e Amv;
    private int Amw;
    private Runnable Aoa;
    private long Aob;
    private Runnable Aoc;
    private Animation Aod;
    private boolean Aoe;
    private int Dm;
    private int atU;
    private int mDistance;
    private Scroller mScroller;
    private Animation sSE;
    private int wDQ;

    static {
        AppMethodBeat.i(220023);
        AppMethodBeat.o(220023);
    }

    public MarqueeLyricView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MarqueeLyricView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(220022);
        this.mScroller = new Scroller(getContext(), new LinearInterpolator());
        this.wDQ = -getWidth();
        this.Aoa = new c(this);
        this.Aob = 200;
        this.Aoc = new b(this);
        this.sSE = AnimationUtils.loadAnimation(getContext(), R.anim.br);
        this.Aod = AnimationUtils.loadAnimation(getContext(), R.anim.bs);
        this.Amw = -1;
        setScroller(this.mScroller);
        setHorizontallyScrolling(true);
        AppMethodBeat.o(220022);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ MarqueeLyricView Aog;

        c(MarqueeLyricView marqueeLyricView) {
            this.Aog = marqueeLyricView;
        }

        public final void run() {
            AppMethodBeat.i(220013);
            Log.d("MicroMsg.MarqueeLyricView", "scrollTask, mStartX:%s, mDistance:%s, mDuration:%s", Integer.valueOf(this.Aog.Dm), Integer.valueOf(this.Aog.mDistance), Integer.valueOf(this.Aog.atU));
            this.Aog.mScroller.startScroll(this.Aog.Dm, 0, this.Aog.mDistance, 0, this.Aog.atU);
            this.Aog.invalidate();
            AppMethodBeat.o(220013);
        }
    }

    private final void evn() {
        AppMethodBeat.i(220014);
        Animation animation = this.sSE;
        p.g(animation, "fadeIn");
        animation.setDuration(this.Aob);
        startAnimation(this.sSE);
        Log.d("MicroMsg.MarqueeLyricView", "doFaceIn, duration:%s", Long.valueOf(this.Aob));
        AppMethodBeat.o(220014);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ MarqueeLyricView Aog;

        b(MarqueeLyricView marqueeLyricView) {
            this.Aog = marqueeLyricView;
        }

        public final void run() {
            AppMethodBeat.i(220012);
            Animation animation = this.Aog.Aod;
            p.g(animation, "fadeOut");
            animation.setDuration(this.Aog.Aob);
            this.Aog.startAnimation(this.Aog.Aod);
            Log.d("MicroMsg.MarqueeLyricView", "doFaceOut, duration:%s", Long.valueOf(this.Aog.Aob));
            AppMethodBeat.o(220012);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/music/ui/view/MarqueeLyricView$Companion;", "", "()V", "TAG", "", "plugin-music_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final boolean isFocused() {
        return true;
    }

    public final void setLyricObj(e eVar) {
        AppMethodBeat.i(220015);
        p.h(eVar, "lyricObj");
        setText("");
        this.Aoe = false;
        removeCallbacks(this.Aoc);
        kQ();
        this.Amv = eVar;
        AppMethodBeat.o(220015);
    }

    public final void bM(int i2, String str) {
        long j2;
        AppMethodBeat.i(220016);
        p.h(str, "content");
        e eVar = this.Amv;
        if (eVar != null) {
            setText(str);
            int i3 = i2 + 1;
            if (i3 < eVar.euw()) {
                j2 = eVar.SQ(i3).timestamp - eVar.SQ(i2).timestamp;
            } else {
                j2 = 5000;
            }
            boolean z = j2 > 1000;
            long j3 = (long) (0.3d * ((double) j2));
            this.Aob = j.aN(200, j3);
            int aIc = aIc(str);
            Log.d("MicroMsg.MarqueeLyricView", "content:%s, width:%s,  contentWidth:%s, duration:%s, duration30Percent:%s, mMinDuration:%s", str, Integer.valueOf(getWidth()), Integer.valueOf(aIc), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(this.Aob));
            kQ();
            if (this.Aoe) {
                evn();
                this.Aoe = false;
            }
            if (getWidth() >= aIc || !z) {
                Log.d("MicroMsg.MarqueeLyricView", "stopScroll");
            } else {
                Log.d("MicroMsg.MarqueeLyricView", "startScroll");
                aIb(str);
                if (eVar.euw() - 1 > i2) {
                    postDelayed(this.Aoc, j2 - this.Aob);
                    this.Aoe = true;
                    AppMethodBeat.o(220016);
                    return;
                }
            }
            AppMethodBeat.o(220016);
            return;
        }
        AppMethodBeat.o(220016);
    }

    private final void aIb(String str) {
        AppMethodBeat.i(220018);
        int aIc = aIc(str);
        int i2 = aIc - ((this.wDQ * 3) / 4);
        if (i2 != 0) {
            Log.d("MicroMsg.MarqueeLyricView", "scrollingLen:%s, mXPause:%s, distance:%s", Integer.valueOf(aIc), Integer.valueOf(this.wDQ), Integer.valueOf(i2));
            this.atU = (int) (((((float) i2) * 1.0f) / ((float) at.fromDPToPix(getContext(), 25))) * 1000.0f);
            this.Dm = this.wDQ;
            this.mDistance = i2;
            postDelayed(this.Aoa, 1000);
        }
        AppMethodBeat.o(220018);
    }

    private final int aIc(String str) {
        AppMethodBeat.i(220019);
        TextPaint paint = getPaint();
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        if (rect.width() > 0) {
            int width = rect.width();
            AppMethodBeat.o(220019);
            return width;
        }
        AppMethodBeat.o(220019);
        return 25;
    }

    private final void kQ() {
        AppMethodBeat.i(220020);
        removeCallbacks(this.Aoa);
        this.mScroller.startScroll(0, 0, 0, 0, 0);
        AppMethodBeat.o(220020);
    }

    public final void computeScroll() {
        AppMethodBeat.i(220021);
        super.computeScroll();
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            invalidate();
        }
        AppMethodBeat.o(220021);
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setCurrentTime(long r12) {
        /*
        // Method dump skipped, instructions count: 478
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.music.ui.view.MarqueeLyricView.setCurrentTime(long):void");
    }
}
