package com.tencent.mm.plugin.vlog.ui.plugin.timecrop;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropSliderSeekBar;
import com.tencent.mm.plugin.vlog.ui.thumb.FrameListView;
import com.tencent.mm.plugin.vlog.ui.thumb.f;
import com.tencent.mm.plugin.vlog.ui.thumb.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001RB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010>\u001a\u00020\u001cH\u0002J\b\u0010?\u001a\u00020@H\u0014J0\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\t2\u0006\u0010E\u001a\u00020\t2\u0006\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\tH\u0014J\u000e\u0010H\u001a\u00020@2\u0006\u0010I\u001a\u00020CJ\u000e\u0010J\u001a\u00020@2\u0006\u0010K\u001a\u00020\u001cJ\"\u0010L\u001a\u00020@2\u0006\u0010M\u001a\u00020N2\b\b\u0002\u0010O\u001a\u00020\u001c2\b\b\u0002\u0010P\u001a\u00020\u001cJ\b\u0010Q\u001a\u00020@H\u0002R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0010\"\u0004\b)\u0010\u0012R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\"\u00100\u001a\u0004\u0018\u00010/2\b\u0010.\u001a\u0004\u0018\u00010/@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0010\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006S"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;", "getCallback", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;", "setCallback", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;)V", "cutCnt", "getCutCnt", "()I", "setCutCnt", "(I)V", "dragCnt", "getDragCnt", "setDragCnt", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "endEmptyTrack", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "endInTrack", "frameAdapter", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "lastTime", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "maxCropDuration", "padding", "realTimeCallback", "getRealTimeCallback", "setRealTimeCallback", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "runOnSize", "Ljava/lang/Runnable;", "<set-?>", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar;", "seekSlider", "getSeekSlider", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar;", "seekSliderListener", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$OnSliderTouchListener;", "sizePerTime", "", "startEmptyTrack", "startInTrack", "thumbCropMaxWidth", "thumbDisplayWidth", "thumbHeight", "thumbWidth", "totalWidth", "getScrollTime", "onFinishInflate", "", "onLayout", "changed", "", "left", "top", "right", "bottom", "setEnableLengthEdit", "enable", "setProgress", "timeMs", "setTrack", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "initStart", "initEnd", "updateTrackCrop", "OnCropCallback", "plugin-vlog_release"})
public final class TimeCropViewGroup extends FrameLayout {
    private float Avf;
    private f GIX;
    private int GJa;
    private Runnable GJd;
    private final h GJf;
    private TimeCropSliderSeekBar GMg;
    private long GMh;
    private long GMi;
    private long GMj;
    private int GMk;
    private int GMl;
    private final h GMm;
    private int GMn;
    private int GMo;
    private TimeCropSliderSeekBar.a GMp;
    private a GMq;
    private a GMr;
    private final String TAG;
    private long duration;
    private RecyclerView hak;
    private long hwQ;
    private int padding;
    private int thumbHeight;
    private int thumbWidth;
    private LinearLayoutManager vKp;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;", "", "onCrop", "", "start", "", "end", "onUp", "", "plugin-vlog_release"})
    public interface a {
        void d(long j2, long j3, boolean z);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TimeCropViewGroup(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(191822);
        this.TAG = "MicroMsg.TrackCropView";
        this.thumbHeight = 112;
        this.thumbWidth = 63;
        this.GJa = 1;
        this.GMj = 1;
        this.Avf = 1.0f;
        h.a aVar = h.GQe;
        this.GMm = h.a.fEy();
        h.a aVar2 = h.GQe;
        this.GJf = h.a.fEy();
        AppMethodBeat.o(191822);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TimeCropViewGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(191823);
        AppMethodBeat.o(191823);
    }

    public final TimeCropSliderSeekBar getSeekSlider() {
        return this.GMg;
    }

    public final int getDragCnt() {
        return this.GMn;
    }

    public final void setDragCnt(int i2) {
        this.GMn = i2;
    }

    public final int getCutCnt() {
        return this.GMo;
    }

    public final void setCutCnt(int i2) {
        this.GMo = i2;
    }

    public final a getCallback() {
        return this.GMq;
    }

    public final void setCallback(a aVar) {
        this.GMq = aVar;
    }

    public final a getRealTimeCallback() {
        return this.GMr;
    }

    public final void setRealTimeCallback(a aVar) {
        this.GMr = aVar;
    }

    /* access modifiers changed from: protected */
    public final void onFinishInflate() {
        AppMethodBeat.i(191816);
        super.onFinishInflate();
        this.hak = (RecyclerView) findViewById(R.id.iuk);
        this.GMg = (TimeCropSliderSeekBar) findViewById(R.id.iuj);
        TimeCropSliderSeekBar timeCropSliderSeekBar = this.GMg;
        if (timeCropSliderSeekBar != null) {
            timeCropSliderSeekBar.setMaskColor(1999383596);
        }
        TimeCropSliderSeekBar timeCropSliderSeekBar2 = this.GMg;
        if (timeCropSliderSeekBar2 != null) {
            timeCropSliderSeekBar2.setEnableHapticAtEdge(true);
        }
        getContext();
        this.vKp = new LinearLayoutManager(0, false);
        RecyclerView recyclerView = this.hak;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(this.vKp);
        }
        this.GIX = new f();
        f fVar = this.GIX;
        if (fVar != null) {
            fVar.GPp = true;
        }
        RecyclerView recyclerView2 = this.hak;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.GIX);
        }
        RecyclerView recyclerView3 = this.hak;
        if (recyclerView3 != null) {
            recyclerView3.setItemAnimator(null);
        }
        this.GMp = new b(this);
        TimeCropSliderSeekBar timeCropSliderSeekBar3 = this.GMg;
        if (timeCropSliderSeekBar3 != null) {
            timeCropSliderSeekBar3.setOnSliderTouchListener(this.GMp);
            AppMethodBeat.o(191816);
            return;
        }
        AppMethodBeat.o(191816);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$onFinishInflate$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$OnSliderTouchListener;", "onDown", "", "left", "", "onMove", "onUp", "plugin-vlog_release"})
    public static final class b implements TimeCropSliderSeekBar.a {
        final /* synthetic */ TimeCropViewGroup GMs;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(TimeCropViewGroup timeCropViewGroup) {
            this.GMs = timeCropViewGroup;
        }

        @Override // com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropSliderSeekBar.a
        public final void ekz() {
            AppMethodBeat.i(191812);
            TimeCropViewGroup.a(this.GMs);
            a callback = this.GMs.getCallback();
            if (callback != null) {
                callback.d(this.GMs.GMi, this.GMs.GMj, true);
                AppMethodBeat.o(191812);
                return;
            }
            AppMethodBeat.o(191812);
        }

        @Override // com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropSliderSeekBar.a
        public final void fEi() {
            AppMethodBeat.i(191813);
            TimeCropViewGroup.a(this.GMs);
            a realTimeCallback = this.GMs.getRealTimeCallback();
            if (realTimeCallback != null) {
                realTimeCallback.d(this.GMs.GMi, this.GMs.GMj, false);
                AppMethodBeat.o(191813);
                return;
            }
            AppMethodBeat.o(191813);
        }
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7 = 0;
        AppMethodBeat.i(191817);
        super.onLayout(z, i2, i3, i4, i5);
        Log.i(this.TAG, "onLayout");
        TimeCropSliderSeekBar timeCropSliderSeekBar = this.GMg;
        if (timeCropSliderSeekBar != null) {
            RecyclerView recyclerView = this.hak;
            if (recyclerView != null) {
                i6 = recyclerView.getTop();
            } else {
                i6 = 0;
            }
            timeCropSliderSeekBar.setContentTop(i6);
        }
        TimeCropSliderSeekBar timeCropSliderSeekBar2 = this.GMg;
        if (timeCropSliderSeekBar2 != null) {
            RecyclerView recyclerView2 = this.hak;
            if (recyclerView2 != null) {
                i7 = recyclerView2.getMeasuredHeight();
            }
            timeCropSliderSeekBar2.setContentHeight(i7);
            AppMethodBeat.o(191817);
            return;
        }
        AppMethodBeat.o(191817);
    }

    public final void setEnableLengthEdit(boolean z) {
        AppMethodBeat.i(191818);
        if (z) {
            TimeCropSliderSeekBar timeCropSliderSeekBar = this.GMg;
            if (timeCropSliderSeekBar != null) {
                timeCropSliderSeekBar.ekB();
                AppMethodBeat.o(191818);
                return;
            }
            AppMethodBeat.o(191818);
            return;
        }
        TimeCropSliderSeekBar timeCropSliderSeekBar2 = this.GMg;
        if (timeCropSliderSeekBar2 != null) {
            timeCropSliderSeekBar2.ekA();
            AppMethodBeat.o(191818);
            return;
        }
        AppMethodBeat.o(191818);
    }

    public final void a(ac acVar, long j2, long j3) {
        AppMethodBeat.i(191819);
        p.h(acVar, "composition");
        this.GMn = 0;
        this.GMo = 0;
        LinkedList linkedList = new LinkedList();
        this.GJa = 0;
        this.hwQ = 0;
        this.duration = acVar.getDurationMs();
        CMTimeRange hfo = acVar.Gez.hfo();
        this.GMh = acVar.getDurationMs();
        this.GMi = j2;
        this.GMj = j3;
        if (j2 < 0 || j3 < 0) {
            this.GMi = hfo.getStartUs() / 1000;
            this.GMj = hfo.getEndUs() / 1000;
        }
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
        if (linkedList.size() == 1) {
            linkedList.get(0);
        }
        this.GJd = new c(this, linkedList);
        Runnable runnable = this.GJd;
        if (runnable != null) {
            runnable.run();
            AppMethodBeat.o(191819);
            return;
        }
        AppMethodBeat.o(191819);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ TimeCropViewGroup GMs;
        final /* synthetic */ LinkedList GMt;
        final /* synthetic */ long GMu = 1000;

        c(TimeCropViewGroup timeCropViewGroup, LinkedList linkedList) {
            this.GMs = timeCropViewGroup;
            this.GMt = linkedList;
        }

        public final void run() {
            AppMethodBeat.i(191815);
            RecyclerView recyclerView = this.GMs.hak;
            if (recyclerView == null) {
                AppMethodBeat.o(191815);
            } else if (recyclerView.getWidth() <= 0) {
                recyclerView.post(this.GMs.GJd);
                AppMethodBeat.o(191815);
            } else {
                this.GMs.padding = com.tencent.mm.cb.a.fromDPToPix(this.GMs.getContext(), 40);
                float height = (((float) recyclerView.getHeight()) * 1.0f) / ((float) this.GMs.thumbHeight);
                this.GMs.GMk = recyclerView.getWidth() - (this.GMs.padding * 2);
                this.GMs.Avf = (((float) this.GMs.GMk) * 1.0f) / ((float) this.GMs.GMh);
                this.GMs.GMl = (int) (this.GMs.Avf * ((float) this.GMs.duration));
                float f2 = ((float) this.GMs.GMl) / (height * ((float) this.GMs.thumbWidth));
                for (h hVar : this.GMt) {
                    hVar.GOF = ((f2 / ((float) this.GMs.duration)) * ((float) hVar.fEu())) / hVar.GQc.GzA.mwH;
                    hVar.fEv();
                }
                this.GMs.GMm.hEp = this.GMs.padding;
                this.GMs.GJf.hEp = this.GMs.padding;
                this.GMt.add(0, this.GMs.GMm);
                this.GMt.add(this.GMs.GJf);
                f fVar = this.GMs.GIX;
                if (fVar != null) {
                    fVar.hw(this.GMt);
                }
                f fVar2 = this.GMs.GIX;
                if (fVar2 != null) {
                    fVar2.notifyDataSetChanged();
                }
                TimeCropSliderSeekBar seekSlider = this.GMs.getSeekSlider();
                if (seekSlider != null) {
                    seekSlider.ao(recyclerView.getWidth() - (this.GMs.padding * 2), (int) (((float) this.GMu) * this.GMs.Avf), this.GMs.padding);
                }
                TimeCropSliderSeekBar seekSlider2 = this.GMs.getSeekSlider();
                if (seekSlider2 != null) {
                    seekSlider2.setCursorPos(0.0f);
                }
                TimeCropSliderSeekBar seekSlider3 = this.GMs.getSeekSlider();
                if (seekSlider3 != null) {
                    seekSlider3.post(new a(this));
                    AppMethodBeat.o(191815);
                    return;
                }
                AppMethodBeat.o(191815);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$setTrack$2$1$2"})
        static final class a implements Runnable {
            final /* synthetic */ c GMv;

            a(c cVar) {
                this.GMv = cVar;
            }

            public final void run() {
                AppMethodBeat.i(191814);
                TimeCropSliderSeekBar seekSlider = this.GMv.GMs.getSeekSlider();
                if (seekSlider != null) {
                    seekSlider.b(true, ((float) this.GMv.GMs.padding) + (((float) this.GMv.GMs.GMi) * this.GMv.GMs.Avf));
                }
                TimeCropSliderSeekBar seekSlider2 = this.GMv.GMs.getSeekSlider();
                if (seekSlider2 != null) {
                    seekSlider2.b(false, ((float) this.GMv.GMs.padding) + (((float) this.GMv.GMs.GMj) * this.GMv.GMs.Avf));
                    AppMethodBeat.o(191814);
                    return;
                }
                AppMethodBeat.o(191814);
            }
        }
    }

    public final void setProgress(long j2) {
        AppMethodBeat.i(191820);
        float f2 = ((float) this.padding) / this.Avf;
        TimeCropSliderSeekBar timeCropSliderSeekBar = this.GMg;
        if (timeCropSliderSeekBar != null) {
            timeCropSliderSeekBar.setCursorPos(((float) (getScrollTime() + j2)) / ((f2 * 2.0f) + ((float) this.GMh)));
            AppMethodBeat.o(191820);
            return;
        }
        AppMethodBeat.o(191820);
    }

    private final long getScrollTime() {
        long j2;
        AppMethodBeat.i(191821);
        View view = null;
        RecyclerView recyclerView = this.hak;
        if (recyclerView != null) {
            int i2 = 0;
            int childCount = recyclerView.getChildCount();
            View view2 = null;
            while (true) {
                if (i2 >= childCount) {
                    j2 = 0;
                    view = view2;
                    break;
                }
                view = recyclerView.getChildAt(i2);
                if (view instanceof FrameListView) {
                    int bw = RecyclerView.bw(view);
                    if (bw < 0) {
                        continue;
                    } else {
                        f fVar = this.GIX;
                        if (fVar == null) {
                            p.hyc();
                        }
                        if (bw < fVar.getItemCount()) {
                            f fVar2 = this.GIX;
                            if (fVar2 == null) {
                                p.hyc();
                            }
                            j2 = fVar2.acK(bw).GQc.GzA.startTimeMs;
                        }
                    }
                } else {
                    view = view2;
                }
                i2++;
                view2 = view;
            }
        } else {
            j2 = 0;
        }
        if (view == null) {
            AppMethodBeat.o(191821);
            return 0;
        }
        if (view == null) {
            p.hyc();
        }
        long left = (long) ((((float) view.getLeft()) / this.Avf) + ((float) j2));
        AppMethodBeat.o(191821);
        return left;
    }

    public static final /* synthetic */ void a(TimeCropViewGroup timeCropViewGroup) {
        long j2;
        AppMethodBeat.i(191824);
        View view = null;
        RecyclerView recyclerView = timeCropViewGroup.hak;
        if (recyclerView != null) {
            int i2 = 0;
            int childCount = recyclerView.getChildCount();
            View view2 = null;
            while (true) {
                if (i2 >= childCount) {
                    j2 = 0;
                    view = view2;
                    break;
                }
                view = recyclerView.getChildAt(i2);
                if (view instanceof FrameListView) {
                    int bw = RecyclerView.bw(view);
                    if (bw < 0) {
                        continue;
                    } else {
                        f fVar = timeCropViewGroup.GIX;
                        if (fVar == null) {
                            p.hyc();
                        }
                        if (bw < fVar.getItemCount()) {
                            f fVar2 = timeCropViewGroup.GIX;
                            if (fVar2 == null) {
                                p.hyc();
                            }
                            j2 = fVar2.acK(bw).GQc.GzA.startTimeMs;
                        }
                    }
                } else {
                    view = view2;
                }
                i2++;
                view2 = view;
            }
        } else {
            j2 = 0;
        }
        if (view == null || timeCropViewGroup.GMg == null) {
            timeCropViewGroup.GMi = 0;
            timeCropViewGroup.GMj = timeCropViewGroup.duration;
            AppMethodBeat.o(191824);
            return;
        }
        TimeCropSliderSeekBar timeCropSliderSeekBar = timeCropViewGroup.GMg;
        if (timeCropSliderSeekBar == null) {
            p.hyc();
        }
        int leftSliderBound = timeCropSliderSeekBar.getLeftSliderBound();
        if (view == null) {
            p.hyc();
        }
        timeCropViewGroup.GMi = (long) ((((float) (leftSliderBound - view.getLeft())) / timeCropViewGroup.Avf) + ((float) j2));
        if (timeCropViewGroup.GMi < 0) {
            timeCropViewGroup.GMi = 0;
        }
        TimeCropSliderSeekBar timeCropSliderSeekBar2 = timeCropViewGroup.GMg;
        if (timeCropSliderSeekBar2 == null) {
            p.hyc();
        }
        int rightSliderBound = timeCropSliderSeekBar2.getRightSliderBound();
        if (view == null) {
            p.hyc();
        }
        timeCropViewGroup.GMj = (long) ((((float) (rightSliderBound - view.getLeft())) / timeCropViewGroup.Avf) + ((float) j2));
        if (timeCropViewGroup.GMj > timeCropViewGroup.duration) {
            timeCropViewGroup.GMj = timeCropViewGroup.duration;
        }
        AppMethodBeat.o(191824);
    }
}
