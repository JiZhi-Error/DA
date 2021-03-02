package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 <2\u00020\u0001:\u0002<=B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u000201H\u0007J\b\u00102\u001a\u00020\tH\u0014J\u000e\u00103\u001a\u00020\u00152\u0006\u00104\u001a\u00020\tJ\u0010\u00105\u001a\u00020\u00152\u0006\u00106\u001a\u00020\u000eH\u0016J\u0010\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u00020\tH\u0016J\u000e\u00109\u001a\u00020\u00152\u0006\u0010:\u001a\u00020;R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R7\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010*\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b+\u0010,¨\u0006>"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "Lcom/tencent/mm/pluginsdk/ui/tools/RedesignVideoPlayerSeekBar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "downX", "downY", "hasStartTrackMove", "", "moveTime", "onCustomLoadingStatusChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isLoading", "", "getOnCustomLoadingStatusChange", "()Lkotlin/jvm/functions/Function1;", "setOnCustomLoadingStatusChange", "(Lkotlin/jvm/functions/Function1;)V", "onSeekEnd", "Lkotlin/Function0;", "getOnSeekEnd", "()Lkotlin/jvm/functions/Function0;", "setOnSeekEnd", "(Lkotlin/jvm/functions/Function0;)V", "onSeekStart", "getOnSeekStart", "setOnSeekStart", "playStatusListener", "Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar$PlayStatusListener;", "getPlayStatusListener", "()Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar$PlayStatusListener;", "setPlayStatusListener", "(Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar$PlayStatusListener;)V", "startTime", "touchSlop", "getTouchSlop", "()I", "touchSlop$delegate", "Lkotlin/Lazy;", "bindFinderVideoLayoutTouch", "videoLayout", "Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout;", "getLayoutId", "onSeekTo", "timeStamp", "setIsPlay", "isPlay", "setPlayTimeText", "playTime", "updateTimeMs", "time", "", "Companion", "PlayStatusListener", "plugin-finder_release"})
public final class FinderLongVideoPlayerSeekBar extends RedesignVideoPlayerSeekBar {
    public static final a wcL = new a((byte) 0);
    private int dvv;
    private int kuv;
    private int kuw;
    b uKd;
    private kotlin.g.a.a<x> wcF;
    private kotlin.g.a.a<x> wcG;
    private kotlin.g.a.b<? super Boolean, x> wcH;
    private boolean wcI;
    private final f wcJ = g.ah(new d(this));
    private int wcK;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar$PlayStatusListener;", "", "onPlayStatusChange", "", "isPlay", "", "onProgress", "times", "", "onSeekTo", "timeStamp", "", "plugin-finder_release"})
    public interface b {
        void kr(boolean z);

        void onProgress(long j2);

        void rk(int i2);
    }

    static {
        AppMethodBeat.i(254058);
        AppMethodBeat.o(254058);
    }

    private final int getTouchSlop() {
        AppMethodBeat.i(254055);
        int intValue = ((Number) this.wcJ.getValue()).intValue();
        AppMethodBeat.o(254055);
        return intValue;
    }

    public static final /* synthetic */ int d(FinderLongVideoPlayerSeekBar finderLongVideoPlayerSeekBar) {
        AppMethodBeat.i(254059);
        int touchSlop = finderLongVideoPlayerSeekBar.getTouchSlop();
        AppMethodBeat.o(254059);
        return touchSlop;
    }

    public FinderLongVideoPlayerSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(254056);
        AppMethodBeat.o(254056);
    }

    public FinderLongVideoPlayerSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(254057);
        AppMethodBeat.o(254057);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final b getPlayStatusListener() {
        return this.uKd;
    }

    public final void setPlayStatusListener(b bVar) {
        this.uKd = bVar;
    }

    public final kotlin.g.a.a<x> getOnSeekStart() {
        return this.wcF;
    }

    public final void setOnSeekStart(kotlin.g.a.a<x> aVar) {
        this.wcF = aVar;
    }

    public final kotlin.g.a.a<x> getOnSeekEnd() {
        return this.wcG;
    }

    public final void setOnSeekEnd(kotlin.g.a.a<x> aVar) {
        this.wcG = aVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super java.lang.Boolean, kotlin.x>, kotlin.g.a.b<java.lang.Boolean, kotlin.x> */
    public final kotlin.g.a.b<Boolean, x> getOnCustomLoadingStatusChange() {
        return this.wcH;
    }

    public final void setOnCustomLoadingStatusChange(kotlin.g.a.b<? super Boolean, x> bVar) {
        this.wcH = bVar;
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar, com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar, com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar
    public final int getLayoutId() {
        return R.layout.al4;
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.sight.decode.ui.a, com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar, com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar
    public final void setIsPlay(boolean z) {
        AppMethodBeat.i(254053);
        super.setIsPlay(z);
        b bVar = this.uKd;
        if (bVar != null) {
            bVar.kr(z);
            AppMethodBeat.o(254053);
            return;
        }
        AppMethodBeat.o(254053);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar
    public final void setPlayTimeText(int i2) {
        AppMethodBeat.i(254054);
        TextView textView = this.mCQ;
        p.g(textView, "mPlaytimeTv");
        textView.setText(xt(i2 / 60) + ":" + xt(i2 % 60));
        AppMethodBeat.o(254054);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
    public static final class c implements View.OnTouchListener {
        final /* synthetic */ FinderLongVideoPlayerSeekBar wcM;
        final /* synthetic */ FinderVideoLayout wcN;

        c(FinderLongVideoPlayerSeekBar finderLongVideoPlayerSeekBar, FinderVideoLayout finderVideoLayout) {
            this.wcM = finderLongVideoPlayerSeekBar;
            this.wcN = finderVideoLayout;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(254051);
            p.g(motionEvent, "event");
            switch (motionEvent.getAction()) {
                case 0:
                    this.wcM.kuv = (int) motionEvent.getX();
                    this.wcM.kuw = (int) motionEvent.getY();
                    AppMethodBeat.o(254051);
                    return true;
                case 1:
                case 3:
                    if (!this.wcM.wcI) {
                        if (Math.abs(motionEvent.getX() - ((float) this.wcM.kuv)) < ((float) FinderLongVideoPlayerSeekBar.d(this.wcM)) && Math.abs(motionEvent.getY() - ((float) this.wcM.kuw)) < ((float) FinderLongVideoPlayerSeekBar.d(this.wcM))) {
                            Log.i("FinderLongVideoPlayerSeekBar", "onFinderVideoLayoutTouch: performClick");
                            this.wcN.performClick();
                            break;
                        }
                    } else {
                        Log.i("FinderLongVideoPlayerSeekBar", "onFinderVideoLayoutTouch: seek end, target time = " + this.wcM.wcK);
                        kotlin.g.a.a<x> onSeekEnd = this.wcM.getOnSeekEnd();
                        if (onSeekEnd != null) {
                            onSeekEnd.invoke();
                        }
                        this.wcM.wcI = false;
                        this.wcM.dvv = 0;
                        r videoView = this.wcN.getVideoView();
                        if (videoView != null) {
                            videoView.c((double) this.wcM.wcK, true);
                        }
                        this.wcN.oQ(true);
                        this.wcM.wcK = 0;
                        AppMethodBeat.o(254051);
                        return true;
                    }
                case 2:
                    if (motionEvent.getPointerCount() > 1) {
                        AppMethodBeat.o(254051);
                        return false;
                    }
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    if (this.wcM.wcI || (Math.abs(((float) (x - this.wcM.kuv)) / ((float) (y - this.wcM.kuw))) > 1.0f && Math.abs(x - this.wcM.kuv) > FinderLongVideoPlayerSeekBar.d(this.wcM))) {
                        if (!this.wcM.wcI) {
                            kotlin.g.a.a<x> onSeekStart = this.wcM.getOnSeekStart();
                            if (onSeekStart != null) {
                                onSeekStart.invoke();
                            }
                            FinderLongVideoPlayerSeekBar finderLongVideoPlayerSeekBar = this.wcM;
                            r videoView2 = this.wcN.getVideoView();
                            finderLongVideoPlayerSeekBar.dvv = videoView2 != null ? videoView2.getCurrentPlaySecond() : 0;
                            this.wcN.oQ(false);
                            Log.i("FinderLongVideoPlayerSeekBar", "onFinderVideoLayoutTouch: start track move, startTime = " + this.wcM.dvv + " videoTotalTime=" + this.wcM.getVideoTotalTime());
                        }
                        this.wcM.wcI = true;
                        this.wcM.wcK = kotlin.h.a.cR((((float) (x - this.wcM.kuv)) / ((float) this.wcN.getWidth())) * ((float) this.wcM.getVideoTotalTime())) + this.wcM.dvv;
                        this.wcM.seek(this.wcM.wcK);
                        AppMethodBeat.o(254051);
                        return true;
                    }
            }
            AppMethodBeat.o(254051);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ FinderLongVideoPlayerSeekBar wcM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderLongVideoPlayerSeekBar finderLongVideoPlayerSeekBar) {
            super(0);
            this.wcM = finderLongVideoPlayerSeekBar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(254052);
            ViewConfiguration viewConfiguration = ViewConfiguration.get(this.wcM.getContext());
            p.g(viewConfiguration, "ViewConfiguration.get(context)");
            Integer valueOf = Integer.valueOf(viewConfiguration.getScaledTouchSlop());
            AppMethodBeat.o(254052);
            return valueOf;
        }
    }
}
