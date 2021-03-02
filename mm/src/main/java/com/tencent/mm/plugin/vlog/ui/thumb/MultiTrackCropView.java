package com.tencent.mm.plugin.vlog.ui.thumb;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.ui.thumb.c;
import com.tencent.mm.plugin.vlog.ui.thumb.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 M2\u00020\u0001:\u0002MNB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010=\u001a\u00020\u00182\b\u0010>\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010?\u001a\u00020@H\u0014J\u0016\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u0013J\u000e\u0010E\u001a\u00020@2\u0006\u0010F\u001a\u00020\u0018J\u000e\u0010G\u001a\u00020@2\u0006\u0010H\u001a\u00020\u0013J\u000e\u0010I\u001a\u00020@2\u0006\u0010B\u001a\u00020CJ\b\u0010J\u001a\u00020@H\u0002J\u0012\u0010K\u001a\u00020@2\b\b\u0002\u0010L\u001a\u00020\u0018H\u0002R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0011\u00100\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b1\u0010\u0015R\u000e\u00102\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0017\u00106\u001a\b\u0012\u0004\u0012\u00020\u001a07¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u000e\u0010:\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "baseScrollOffset", "callback", "Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView$OnCropCallback;", "getCallback", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView$OnCropCallback;", "setCallback", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView$OnCropCallback;)V", "cutDuration", "", "getCutDuration", "()J", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "enableAutoScroll", "", "endEmptyTrack", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "frameAdapter", "Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter;", "isTouchSlider", "lastMoveEvent", "Landroid/view/MotionEvent;", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "marginLeft", "maxCropDuration", "padding", "parentWidth", "playEnd", "playStart", "playWaitIdle", "recyclerView", "Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackRecyclerView;", "replayInterval", "replayLastMoveEventRunnable", "Ljava/lang/Runnable;", "runOnSize", "scrolledX", "sourceDuration", "getSourceDuration", "startEmptyTrack", "thumbHeight", "thumbWidth", "totalWidth", "trackList", "Ljava/util/LinkedList;", "getTrackList", "()Ljava/util/LinkedList;", "waitForUpdateComposition", "waitForUpdateProgress", "waitProgress", "dispatchTouchEvent", "ev", "onFinishInflate", "", "onUpdateComposition", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "seekTo", "setEnableLengthEdit", "enable", "setProgress", "timeMs", "setTrack", "updateSelection", "updateTrackInfo", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "Companion", "OnCropCallback", "plugin-vlog_release"})
public final class MultiTrackCropView extends FrameLayout {
    public static final a GPI = new a((byte) 0);
    public int FVU;
    public int GJa;
    public boolean GJb;
    private Runnable GJd;
    private final h GJf;
    private boolean GJk;
    private long GMh;
    private final h GMm;
    private final LinkedList<h> GOJ;
    private MotionEvent GPA;
    public boolean GPB;
    public boolean GPC;
    public long GPD;
    private boolean GPE;
    private b GPF;
    private final long GPG;
    private final Runnable GPH;
    public MultiTrackRecyclerView GPx;
    private c GPy;
    public int GPz;
    public long GhH;
    private long duration;
    private final int hbc;
    private final int oxq;
    private final int padding;
    private int thumbHeight;
    private int thumbWidth;
    private LinearLayoutManager vKp;
    public long wbl;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J(\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\tH&¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView$OnCropCallback;", "", "onTapDown", "", "position", "", "left", "", "startTimeMs", "", "endTimeMs", "onTapMove", "onTapUp", "pause", "resume", "seekTo", "timeMs", "plugin-vlog_release"})
    public interface b {
        void a(int i2, boolean z, long j2, long j3);

        void b(int i2, boolean z, long j2, long j3);

        void fCR();

        void pause();

        void seekTo(long j2);
    }

    static {
        AppMethodBeat.i(192120);
        AppMethodBeat.o(192120);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiTrackCropView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(192118);
        this.GPy = new c();
        this.thumbHeight = 112;
        this.thumbWidth = 63;
        this.GJa = 1;
        this.GJb = true;
        this.hbc = com.tencent.mm.cb.a.jn(context);
        this.padding = com.tencent.mm.cb.a.fromDPToPix(context, 40);
        this.oxq = com.tencent.mm.cb.a.fromDPToPix(context, 64);
        h.a aVar = h.GQe;
        this.GMm = h.a.fEy();
        h.a aVar2 = h.GQe;
        this.GJf = h.a.fEy();
        this.GOJ = new LinkedList<>();
        this.GPG = 16;
        this.GPH = new f(this);
        AppMethodBeat.o(192118);
    }

    public static final /* synthetic */ MultiTrackRecyclerView n(MultiTrackCropView multiTrackCropView) {
        AppMethodBeat.i(192122);
        MultiTrackRecyclerView multiTrackRecyclerView = multiTrackCropView.GPx;
        if (multiTrackRecyclerView == null) {
            p.btv("recyclerView");
        }
        AppMethodBeat.o(192122);
        return multiTrackRecyclerView;
    }

    public static final /* synthetic */ void u(MultiTrackCropView multiTrackCropView) {
        AppMethodBeat.i(192123);
        multiTrackCropView.wM(true);
        AppMethodBeat.o(192123);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MultiTrackCropView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(192119);
        AppMethodBeat.o(192119);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final LinkedList<h> getTrackList() {
        return this.GOJ;
    }

    public final b getCallback() {
        return this.GPF;
    }

    public final void setCallback(b bVar) {
        this.GPF = bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class f implements Runnable {
        final /* synthetic */ MultiTrackCropView GPJ;

        f(MultiTrackCropView multiTrackCropView) {
            this.GPJ = multiTrackCropView;
        }

        public final void run() {
            AppMethodBeat.i(192105);
            Log.d("MicroMsg.MultiTrackCropView", "replayLastMoveEvent, lastMoveEvent:" + this.GPJ.GPA);
            this.GPJ.dispatchTouchEvent(this.GPJ.GPA);
            AppMethodBeat.o(192105);
        }
    }

    public final long getSourceDuration() {
        AppMethodBeat.i(192110);
        long j2 = 0;
        Iterator<T> it = this.GOJ.iterator();
        while (it.hasNext()) {
            j2 = it.next().GQc.GzA.GJB + j2;
        }
        AppMethodBeat.o(192110);
        return j2;
    }

    public final long getCutDuration() {
        AppMethodBeat.i(192111);
        long j2 = 0;
        Iterator<T> it = this.GOJ.iterator();
        while (it.hasNext()) {
            j2 = it.next().fEu() + j2;
        }
        AppMethodBeat.o(192111);
        return j2;
    }

    /* access modifiers changed from: protected */
    public final void onFinishInflate() {
        AppMethodBeat.i(192112);
        super.onFinishInflate();
        View findViewById = findViewById(R.id.iuk);
        p.g(findViewById, "findViewById(R.id.track_crop_thumb_recycler)");
        this.GPx = (MultiTrackRecyclerView) findViewById;
        getContext();
        this.vKp = new MultiTrackCropView$onFinishInflate$1(this);
        MultiTrackRecyclerView multiTrackRecyclerView = this.GPx;
        if (multiTrackRecyclerView == null) {
            p.btv("recyclerView");
        }
        LinearLayoutManager linearLayoutManager = this.vKp;
        if (linearLayoutManager == null) {
            p.btv("layoutManager");
        }
        multiTrackRecyclerView.setLayoutManager(linearLayoutManager);
        MultiTrackRecyclerView multiTrackRecyclerView2 = this.GPx;
        if (multiTrackRecyclerView2 == null) {
            p.btv("recyclerView");
        }
        multiTrackRecyclerView2.setAdapter(this.GPy);
        MultiTrackRecyclerView multiTrackRecyclerView3 = this.GPx;
        if (multiTrackRecyclerView3 == null) {
            p.btv("recyclerView");
        }
        multiTrackRecyclerView3.setItemAnimator(null);
        MultiTrackRecyclerView multiTrackRecyclerView4 = this.GPx;
        if (multiTrackRecyclerView4 == null) {
            p.btv("recyclerView");
        }
        multiTrackRecyclerView4.b(new d());
        MultiTrackRecyclerView multiTrackRecyclerView5 = this.GPx;
        if (multiTrackRecyclerView5 == null) {
            p.btv("recyclerView");
        }
        multiTrackRecyclerView5.a(new c(this));
        MultiTrackRecyclerView multiTrackRecyclerView6 = this.GPx;
        if (multiTrackRecyclerView6 == null) {
            p.btv("recyclerView");
        }
        multiTrackRecyclerView6.a(new d());
        this.GPy.GOM = new e(this);
        AppMethodBeat.o(192112);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView$onFinishInflate$2", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-vlog_release"})
    public static final class c extends RecyclerView.l {
        final /* synthetic */ MultiTrackCropView GPJ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(MultiTrackCropView multiTrackCropView) {
            this.GPJ = multiTrackCropView;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(192099);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView$onFinishInflate$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            Log.i("MicroMsg.MultiTrackCropView", "onScrollStateChanged: ".concat(String.valueOf(i2)));
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0 && this.GPJ.GJk) {
                Log.i("MicroMsg.MultiTrackCropView", "onScrollStateChanged: SCROLL_STATE_IDLE");
                this.GPJ.GJk = false;
                this.GPJ.GJb = true;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView$onFinishInflate$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(192099);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(192100);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView$onFinishInflate$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            this.GPJ.FVU += i2;
            Log.d("MicroMsg.MultiTrackCropView", "onScrolled, scrolled:" + this.GPJ.FVU + ", dx:" + i2);
            if (!this.GPJ.GJb && !this.GPJ.GPB && !this.GPJ.GPE) {
                long j2 = (((this.GPJ.GhH - this.GPJ.wbl) * ((long) (this.GPJ.FVU - this.GPJ.GPz))) / ((long) this.GPJ.GJa)) + this.GPJ.wbl;
                Log.d("MicroMsg.MultiTrackCropView", "onScrolled, seekTo:".concat(String.valueOf(j2)));
                b callback = this.GPJ.getCallback();
                if (callback != null) {
                    callback.seekTo(j2);
                }
            }
            if (!this.GPJ.GPE) {
                MultiTrackCropView.m(this.GPJ);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView$onFinishInflate$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(192100);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView$onFinishInflate$3", "Landroid/support/v7/widget/RecyclerView$SimpleOnItemTouchListener;", "onInterceptTouchEvent", "", "rv", "Landroid/support/v7/widget/RecyclerView;", "e", "Landroid/view/MotionEvent;", "plugin-vlog_release"})
    public static final class d extends RecyclerView.q {
        d() {
        }

        @Override // android.support.v7.widget.RecyclerView.k, android.support.v7.widget.RecyclerView.q
        public final boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
            AppMethodBeat.i(192101);
            p.h(recyclerView, "rv");
            p.h(motionEvent, "e");
            AppMethodBeat.o(192101);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J(\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView$onFinishInflate$4", "Lcom/tencent/mm/plugin/vlog/ui/thumb/EditFrameListAdapter$OnSliderTouchListener;", "onDown", "", "position", "", "startAvailableSpace", "left", "", "onMove", "consumed", "rawX", "", "onUp", "plugin-vlog_release"})
    public static final class e implements c.d {
        final /* synthetic */ MultiTrackCropView GPJ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(MultiTrackCropView multiTrackCropView) {
            this.GPJ = multiTrackCropView;
        }

        @Override // com.tencent.mm.plugin.vlog.ui.thumb.c.d
        public final void bf(int i2, boolean z) {
            AppMethodBeat.i(192102);
            this.GPJ.GPE = true;
            MultiTrackCropView.n(this.GPJ).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(MultiTrackCropView.n(this.GPJ).getHeight(), 1073741824));
            MultiTrackCropView.n(this.GPJ).layout(0, 0, MultiTrackCropView.n(this.GPJ).getWidth(), MultiTrackCropView.n(this.GPJ).getHeight());
            if (z) {
                Log.d("MicroMsg.MultiTrackCropView", "onTapDown, position:" + (i2 - 1) + ", left:" + z + ", startTimeMs:0, endTimeMs:" + this.GPJ.getTrackList().get(i2).GOE);
                b callback = this.GPJ.getCallback();
                if (callback != null) {
                    callback.a(i2 - 1, z, 0, this.GPJ.getTrackList().get(i2).GOE);
                    AppMethodBeat.o(192102);
                    return;
                }
                AppMethodBeat.o(192102);
                return;
            }
            Log.d("MicroMsg.MultiTrackCropView", "onTapDown, position:" + (i2 - 1) + ", left:" + z + ", startTimeMs:" + this.GPJ.getTrackList().get(i2).GOD + ", endTimeMs:" + this.GPJ.getTrackList().get(i2).GQc.GzA.GJB);
            b callback2 = this.GPJ.getCallback();
            if (callback2 != null) {
                callback2.a(i2 - 1, z, this.GPJ.getTrackList().get(i2).GOD, this.GPJ.getTrackList().get(i2).GQc.GzA.GJB);
                AppMethodBeat.o(192102);
                return;
            }
            AppMethodBeat.o(192102);
        }

        @Override // com.tencent.mm.plugin.vlog.ui.thumb.c.d
        public final void bg(int i2, boolean z) {
            AppMethodBeat.i(192103);
            this.GPJ.GPE = false;
            MultiTrackCropView.a(this.GPJ);
            MultiTrackCropView.m(this.GPJ);
            this.GPJ.GPB = true;
            MultiTrackCropView.n(this.GPJ).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(MultiTrackCropView.n(this.GPJ).getHeight(), 1073741824));
            MultiTrackCropView.n(this.GPJ).layout(0, 0, MultiTrackCropView.n(this.GPJ).getWidth(), MultiTrackCropView.n(this.GPJ).getHeight());
            Log.d("MicroMsg.MultiTrackCropView", "onTapUp, position:" + (i2 - 1) + ", left:" + z + ", startTimeMs:" + this.GPJ.getTrackList().get(i2).GOD + ", endTimeMs:" + this.GPJ.getTrackList().get(i2).GOE);
            b callback = this.GPJ.getCallback();
            if (callback != null) {
                callback.b(i2 - 1, z, this.GPJ.getTrackList().get(i2).GOD, this.GPJ.getTrackList().get(i2).GOE);
            }
            this.GPJ.removeCallbacks(this.GPJ.GPH);
            AppMethodBeat.o(192103);
        }

        @Override // com.tencent.mm.plugin.vlog.ui.thumb.c.d
        public final void a(int i2, int i3, boolean z, float f2) {
            AppMethodBeat.i(192104);
            h hVar = this.GPJ.getTrackList().get(i2);
            p.g(hVar, "trackList[position]");
            h hVar2 = hVar;
            if (z) {
                Log.d("MicroMsg.MultiTrackCropView", "onMove, left:" + z + ", seekTo:" + (hVar2.GPZ + ((long) (((float) hVar2.GOD) / hVar2.GQc.GzA.mwH))));
                b callback = this.GPJ.getCallback();
                if (callback != null) {
                    callback.seekTo(hVar2.GPZ + ((long) (((float) hVar2.GOD) / hVar2.GQc.GzA.mwH)));
                }
                MultiTrackCropView.n(this.GPJ).scrollBy(-i3, 0);
            } else {
                Log.d("MicroMsg.MultiTrackCropView", "onMove, left:" + z + ", seekTo:" + (hVar2.GPZ + ((long) (((float) hVar2.fEu()) / hVar2.GQc.GzA.mwH))));
                b callback2 = this.GPJ.getCallback();
                if (callback2 != null) {
                    callback2.seekTo(hVar2.GPZ + ((long) (((float) hVar2.fEu()) / hVar2.GQc.GzA.mwH)));
                }
            }
            b callback3 = this.GPJ.getCallback();
            if (callback3 != null) {
                this.GPJ.getTrackList().get(i2);
                this.GPJ.getTrackList().get(i2);
                callback3.fCR();
            }
            boolean z2 = false;
            if (f2 > ((float) (this.GPJ.hbc - this.GPJ.padding))) {
                MultiTrackCropView.n(this.GPJ).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(MultiTrackCropView.n(this.GPJ).getHeight(), 1073741824));
                MultiTrackCropView.n(this.GPJ).layout(0, 0, MultiTrackCropView.n(this.GPJ).getWidth(), MultiTrackCropView.n(this.GPJ).getHeight());
                MultiTrackCropView.n(this.GPJ).scrollBy((int) (f2 - ((float) (this.GPJ.hbc - this.GPJ.padding))), 0);
                z2 = true;
            }
            if (f2 < ((float) (this.GPJ.oxq + this.GPJ.padding))) {
                MultiTrackCropView.n(this.GPJ).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(MultiTrackCropView.n(this.GPJ).getHeight(), 1073741824));
                MultiTrackCropView.n(this.GPJ).layout(0, 0, MultiTrackCropView.n(this.GPJ).getWidth(), MultiTrackCropView.n(this.GPJ).getHeight());
                MultiTrackCropView.n(this.GPJ).scrollBy((int) ((f2 - ((float) this.GPJ.oxq)) - ((float) this.GPJ.padding)), 0);
                z2 = true;
            }
            if (z2) {
                this.GPJ.removeCallbacks(this.GPJ.GPH);
                this.GPJ.postDelayed(this.GPJ.GPH, this.GPJ.GPG);
            }
            AppMethodBeat.o(192104);
        }
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Integer num = null;
        AppMethodBeat.i(192113);
        Log.d("MicroMsg.MultiTrackCropView", "dispatchTouchEvent, action:" + (motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null) + ", rawX:" + (motionEvent != null ? Float.valueOf(motionEvent.getRawX()) : null) + ", rawY:" + (motionEvent != null ? Float.valueOf(motionEvent.getRawY()) : null));
        if (motionEvent != null) {
            num = Integer.valueOf(motionEvent.getAction());
        }
        if (num != null && num.intValue() == 0) {
            Log.d("MicroMsg.MultiTrackCropView", "RecyclerView onInterceptTouchEvent:ACTION_DOWN, set enableAutoScroll:false");
            this.GJk = false;
            this.GJb = false;
            b bVar = this.GPF;
            if (bVar != null) {
                bVar.pause();
            }
            MultiTrackRecyclerView multiTrackRecyclerView = this.GPx;
            if (multiTrackRecyclerView == null) {
                p.btv("recyclerView");
            }
            multiTrackRecyclerView.kQ();
        } else if ((num != null && num.intValue() == 3) || (num != null && num.intValue() == 1)) {
            MultiTrackRecyclerView multiTrackRecyclerView2 = this.GPx;
            if (multiTrackRecyclerView2 == null) {
                p.btv("recyclerView");
            }
            if (multiTrackRecyclerView2.getScrollState() == 0) {
                Log.d("MicroMsg.MultiTrackCropView", "RecyclerView onInterceptTouchEvent:ACTION_UP, SCROLL_STATE_IDLE, set playWaitIdle:false, enableAutoScroll:true");
                this.GJk = false;
                this.GJb = true;
            } else {
                Log.d("MicroMsg.MultiTrackCropView", "RecyclerView onInterceptTouchEvent:ACTION_UP, set playWaitIdle:true");
                this.GJk = true;
            }
        } else if (num != null && num.intValue() == 2) {
            this.GPA = MotionEvent.obtain(motionEvent);
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(192113);
        return dispatchTouchEvent;
    }

    public final void setEnableLengthEdit(boolean z) {
    }

    public final void setTrack(ac acVar) {
        long j2 = Util.MILLSECONDS_OF_MINUTE;
        AppMethodBeat.i(192114);
        p.h(acVar, "composition");
        this.GOJ.clear();
        this.duration = acVar.Gez.getSourceDuration();
        CMTimeRange hfo = acVar.Gez.hfo();
        this.wbl = hfo.getStartUs() / 1000;
        this.GhH = hfo.getEndUs() / 1000;
        if (this.duration <= Util.MILLSECONDS_OF_MINUTE) {
            j2 = this.duration;
        }
        this.GMh = j2;
        LinkedList<h> linkedList = this.GOJ;
        List<ad> fBD = acVar.fBD();
        ArrayList arrayList = new ArrayList(j.a(fBD, 10));
        int i2 = 0;
        for (T t : fBD) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            h hVar = new h(t);
            hVar.trackIndex = i2;
            hVar.height = this.thumbHeight;
            hVar.width = this.thumbWidth;
            arrayList.add(hVar);
            i2 = i3;
        }
        linkedList.addAll(arrayList);
        this.GPB = true;
        LinearLayoutManager linearLayoutManager = this.vKp;
        if (linearLayoutManager == null) {
            p.btv("layoutManager");
        }
        linearLayoutManager.ah(0, 0);
        this.FVU = 0;
        this.GJd = new h(this);
        Runnable runnable = this.GJd;
        if (runnable != null) {
            runnable.run();
            AppMethodBeat.o(192114);
            return;
        }
        AppMethodBeat.o(192114);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class h implements Runnable {
        final /* synthetic */ MultiTrackCropView GPJ;

        h(MultiTrackCropView multiTrackCropView) {
            this.GPJ = multiTrackCropView;
        }

        public final void run() {
            AppMethodBeat.i(192108);
            if (MultiTrackCropView.n(this.GPJ).getWidth() <= 0) {
                MultiTrackCropView.n(this.GPJ).post(this.GPJ.GJd);
                AppMethodBeat.o(192108);
                return;
            }
            MultiTrackCropView.u(this.GPJ);
            this.GPJ.GPz = this.GPJ.hbc / 2;
            Log.d("MicroMsg.MultiTrackCropView", "baseScrollOffset: " + this.GPJ.GPz);
            this.GPJ.GMm.trackIndex = -2;
            this.GPJ.GMm.hEp = MultiTrackCropView.n(this.GPJ).getWidth();
            this.GPJ.GJf.trackIndex = -3;
            this.GPJ.GJf.hEp = MultiTrackCropView.n(this.GPJ).getWidth();
            this.GPJ.getTrackList().add(0, this.GPJ.GMm);
            this.GPJ.getTrackList().add(this.GPJ.GJf);
            this.GPJ.GPy.setSelection(-1);
            MultiTrackCropView.n(this.GPJ).va = -1;
            this.GPJ.GPy.hw(this.GPJ.getTrackList());
            this.GPJ.GPy.notifyDataSetChanged();
            MultiTrackCropView.n(this.GPJ).post(new Runnable(this) {
                /* class com.tencent.mm.plugin.vlog.ui.thumb.MultiTrackCropView.h.AnonymousClass1 */
                final /* synthetic */ h GPK;

                {
                    this.GPK = r1;
                }

                public final void run() {
                    AppMethodBeat.i(192107);
                    MultiTrackCropView.n(this.GPK.GPJ).scrollBy(this.GPK.GPJ.GPz, 0);
                    this.GPK.GPJ.GPB = false;
                    AppMethodBeat.o(192107);
                }
            });
            AppMethodBeat.o(192108);
        }
    }

    public final void setProgress(long j2) {
        AppMethodBeat.i(192115);
        com.tencent.mm.ac.d.h(new g(this, j2));
        AppMethodBeat.o(192115);
    }

    static /* synthetic */ void a(MultiTrackCropView multiTrackCropView) {
        AppMethodBeat.i(192117);
        multiTrackCropView.wM(false);
        AppMethodBeat.o(192117);
    }

    private final void wM(boolean z) {
        AppMethodBeat.i(192116);
        MultiTrackRecyclerView multiTrackRecyclerView = this.GPx;
        if (multiTrackRecyclerView == null) {
            p.btv("recyclerView");
        }
        int height = multiTrackRecyclerView.getHeight();
        MultiTrackRecyclerView multiTrackRecyclerView2 = this.GPx;
        if (multiTrackRecyclerView2 == null) {
            p.btv("recyclerView");
        }
        int paddingTop = height - multiTrackRecyclerView2.getPaddingTop();
        MultiTrackRecyclerView multiTrackRecyclerView3 = this.GPx;
        if (multiTrackRecyclerView3 == null) {
            p.btv("recyclerView");
        }
        float paddingBottom = (((float) (paddingTop - multiTrackRecyclerView3.getPaddingBottom())) * 1.0f) / ((float) this.thumbHeight);
        this.GJa = 0;
        long j2 = 0;
        for (T t : this.GOJ) {
            if (z) {
                t.GOF = (((float) t.GQc.GzA.GJB) / t.GQc.GzA.mwH) / 1000.0f;
                long j3 = (long) (((float) t.GQc.GzA.GJB) / t.GOF);
                int ceil = (int) Math.ceil((double) t.GOF);
                t.GOG.clear();
                for (int i2 = 0; i2 < ceil; i2++) {
                    e eVar = new e();
                    eVar.Asv = kotlin.h.a.L((double) ((((float) ((((long) i2) * j3) + (j3 / 2))) * 1.0f) / 500.0f)) * 500;
                    if (eVar.Asv >= t.GQc.GzA.GJB) {
                        eVar.Asv = ((t.GQc.GzA.GJB - 1) / 500) * 500;
                    }
                    t.GOG.add(eVar);
                }
            }
            t.GPZ = j2;
            t.kxW = (int) ((((t.GOF * ((float) t.width)) * paddingBottom) * ((float) t.fEu())) / ((float) t.GQc.GzA.GJB));
            this.GJa += t.kxW;
            j2 += (long) (((float) t.fEu()) / t.GQc.GzA.mwH);
            Log.d("MicroMsg.MultiTrackCropView", "build thumbInfo index:" + t.trackIndex + ", frameCount:" + t.GOF + ", frameDuration:" + t.fEu() + ", frameWidth:" + t.kxW);
        }
        this.wbl = 0;
        this.GhH = j2;
        AppMethodBeat.o(192116);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView$updateSelection$1$1"})
    public static final class i implements Runnable {
        final /* synthetic */ h GOR;
        final /* synthetic */ MultiTrackCropView GPJ;
        final /* synthetic */ z.d GPL;
        final /* synthetic */ int puW;

        i(int i2, h hVar, MultiTrackCropView multiTrackCropView, z.d dVar) {
            this.puW = i2;
            this.GOR = hVar;
            this.GPJ = multiTrackCropView;
            this.GPL = dVar;
        }

        public final void run() {
            AppMethodBeat.i(192109);
            MultiTrackCropView.n(this.GPJ).va = this.puW;
            this.GPJ.GPy.setSelection(this.GOR.trackIndex);
            AppMethodBeat.o(192109);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ MultiTrackCropView GPJ;
        final /* synthetic */ long wfK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(MultiTrackCropView multiTrackCropView, long j2) {
            super(0);
            this.GPJ = multiTrackCropView;
            this.wfK = j2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(192106);
            Log.d("MicroMsg.MultiTrackCropView", "setProgress: " + this.wfK);
            if (this.GPJ.GPC) {
                if (this.wfK == 0 || (this.wfK >= this.GPJ.GPD - 100 && this.wfK <= this.GPJ.GPD + 100)) {
                    Log.d("MicroMsg.MultiTrackCropView", "waitForProgress, waitProgress:" + this.GPJ.GPD + ", timeMs:" + this.wfK + ", pass");
                    this.GPJ.GPC = false;
                } else {
                    Log.d("MicroMsg.MultiTrackCropView", "waitForProgress, waitProgress:" + this.GPJ.GPD + ", timeMs:" + this.wfK + ", fail");
                    x xVar = x.SXb;
                    AppMethodBeat.o(192106);
                    return xVar;
                }
            }
            if (this.GPJ.GJb && !this.GPJ.GPB) {
                if (this.wfK == this.GPJ.wbl) {
                    Log.d("MicroMsg.MultiTrackCropView", "setProgress, timeMs == playStart == " + this.GPJ.wbl + ", scrolled:" + this.GPJ.FVU + ", scrollBy" + ((-this.GPJ.FVU) + this.GPJ.GPz));
                    MultiTrackCropView.n(this.GPJ).scrollBy((-this.GPJ.FVU) + this.GPJ.GPz, 0);
                } else {
                    MultiTrackCropView.n(this.GPJ).smoothScrollBy((this.GPJ.GPz + ((int) ((((float) ((this.wfK - this.GPJ.wbl) * ((long) this.GPJ.GJa))) * 1.0f) / ((float) (this.GPJ.GhH - this.GPJ.wbl))))) - this.GPJ.FVU, 0);
                }
            }
            x xVar2 = x.SXb;
            AppMethodBeat.o(192106);
            return xVar2;
        }
    }

    public static final /* synthetic */ void m(MultiTrackCropView multiTrackCropView) {
        AppMethodBeat.i(192121);
        z.d dVar = new z.d();
        dVar.SYE = multiTrackCropView.GPz;
        int i2 = 0;
        for (T t : multiTrackCropView.GOJ) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            T t2 = t;
            if (i2 == 0 || i2 == j.kq(multiTrackCropView.GOJ)) {
                i2 = i3;
            } else {
                dVar.SYE += t2.kxW;
                if (multiTrackCropView.FVU < dVar.SYE) {
                    multiTrackCropView.post(new i(i2, t2, multiTrackCropView, dVar));
                    AppMethodBeat.o(192121);
                    return;
                }
                i2 = i3;
            }
        }
        AppMethodBeat.o(192121);
    }
}
