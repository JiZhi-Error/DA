package com.tencent.mm.plugin.vlog.ui.thumb;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mmsight.segment.SliderSeekBar;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.ui.thumb.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;

public final class TrackCropView extends FrameLayout {
    private float Avf;
    private f GIX;
    private int GJa;
    private Runnable GJd;
    private final h GJf;
    private boolean GJk;
    private long GMh;
    private long GMi;
    private long GMj;
    private int GMk;
    private int GMl;
    private final h GMm;
    private int GMn;
    private int GMo;
    private SliderSeekBar GPR;
    private boolean GPT;
    private SliderSeekBar.a GPU;
    private a GPV;
    private final String TAG;
    private long duration;
    private RecyclerView hak;
    private long hwQ;
    private int padding;
    private int thumbHeight;
    private int thumbWidth;
    private LinearLayoutManager vKp;

    public interface a {
        void ay(long j2, long j3);

        void az(long j2, long j3);

        void pause();

        void seekTo(long j2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TrackCropView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(192156);
        this.TAG = "MicroMsg.TrackCropView";
        this.vKp = new LinearLayoutManager(0, false);
        this.GIX = new f();
        this.thumbHeight = 112;
        this.thumbWidth = 63;
        this.GJa = 1;
        this.GMj = 1;
        this.Avf = 1.0f;
        h.a aVar = h.GQe;
        this.GMm = h.a.fEy();
        h.a aVar2 = h.GQe;
        this.GJf = h.a.fEy();
        AppMethodBeat.o(192156);
    }

    public static final /* synthetic */ RecyclerView e(TrackCropView trackCropView) {
        AppMethodBeat.i(192159);
        RecyclerView recyclerView = trackCropView.hak;
        if (recyclerView == null) {
            p.btv("recyclerView");
        }
        AppMethodBeat.o(192159);
        return recyclerView;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TrackCropView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(192157);
        AppMethodBeat.o(192157);
    }

    public final SliderSeekBar getSeekSlider() {
        return this.GPR;
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
        return this.GPV;
    }

    public final void setCallback(a aVar) {
        this.GPV = aVar;
    }

    public final void onFinishInflate() {
        AppMethodBeat.i(192151);
        super.onFinishInflate();
        View findViewById = findViewById(R.id.iuk);
        p.g(findViewById, "findViewById(R.id.track_crop_thumb_recycler)");
        this.hak = (RecyclerView) findViewById;
        this.GPR = (SliderSeekBar) findViewById(R.id.iuj);
        SliderSeekBar sliderSeekBar = this.GPR;
        if (sliderSeekBar != null) {
            sliderSeekBar.setMaskColor(1999383596);
        }
        SliderSeekBar sliderSeekBar2 = this.GPR;
        if (sliderSeekBar2 != null) {
            sliderSeekBar2.setEnableHapticAtEdge(true);
        }
        RecyclerView recyclerView = this.hak;
        if (recyclerView == null) {
            p.btv("recyclerView");
        }
        recyclerView.setLayoutManager(this.vKp);
        RecyclerView recyclerView2 = this.hak;
        if (recyclerView2 == null) {
            p.btv("recyclerView");
        }
        recyclerView2.setAdapter(this.GIX);
        RecyclerView recyclerView3 = this.hak;
        if (recyclerView3 == null) {
            p.btv("recyclerView");
        }
        recyclerView3.setItemAnimator(null);
        RecyclerView recyclerView4 = this.hak;
        if (recyclerView4 == null) {
            p.btv("recyclerView");
        }
        recyclerView4.a(new b(this));
        RecyclerView recyclerView5 = this.hak;
        if (recyclerView5 == null) {
            p.btv("recyclerView");
        }
        recyclerView5.a(new c(this));
        this.GPU = new d(this);
        SliderSeekBar sliderSeekBar3 = this.GPR;
        if (sliderSeekBar3 != null) {
            sliderSeekBar3.setOnSliderTouchListener(this.GPU);
            AppMethodBeat.o(192151);
            return;
        }
        AppMethodBeat.o(192151);
    }

    public static final class b extends RecyclerView.l {
        private boolean GJq;
        final /* synthetic */ TrackCropView GPW;

        b(TrackCropView trackCropView) {
            this.GPW = trackCropView;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(192143);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            Log.i(this.GPW.TAG, "onScrollStateChanged: ".concat(String.valueOf(i2)));
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0) {
                TrackCropView.b(this.GPW);
                Log.i(this.GPW.TAG, "onScrollStateChanged: " + this.GPW.GMi + ", " + this.GPW.GMj);
                a callback = this.GPW.getCallback();
                if (callback != null) {
                    callback.ay(this.GPW.GMi, this.GPW.GMj);
                }
                this.GPW.GJk = false;
                this.GJq = false;
            } else if (i2 == 1) {
                if (!this.GJq) {
                    TrackCropView trackCropView = this.GPW;
                    trackCropView.setDragCnt(trackCropView.getDragCnt() + 1);
                }
                this.GJq = true;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(192143);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(192144);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            TrackCropView.b(this.GPW);
            Log.i(this.GPW.TAG, "onScroll: range: " + this.GPW.GMi + ", " + this.GPW.GMj);
            a callback = this.GPW.getCallback();
            if (callback != null) {
                callback.seekTo(this.GPW.GMi);
            }
            this.GPW.setProgress(this.GPW.GMi);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(192144);
        }
    }

    public static final class c extends RecyclerView.q {
        final /* synthetic */ TrackCropView GPW;

        c(TrackCropView trackCropView) {
            this.GPW = trackCropView;
        }

        @Override // android.support.v7.widget.RecyclerView.k, android.support.v7.widget.RecyclerView.q
        public final boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
            AppMethodBeat.i(192145);
            p.h(recyclerView, "rv");
            p.h(motionEvent, "e");
            switch (motionEvent.getAction()) {
                case 0:
                    a callback = this.GPW.getCallback();
                    if (callback != null) {
                        callback.pause();
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (TrackCropView.e(this.GPW).getScrollState() != 0) {
                        this.GPW.GJk = true;
                        break;
                    } else {
                        TrackCropView.b(this.GPW);
                        Log.i(this.GPW.TAG, "onInterceptTouchEvent crop: " + this.GPW.GMi + ", " + this.GPW.GMj);
                        a callback2 = this.GPW.getCallback();
                        if (callback2 != null) {
                            callback2.ay(this.GPW.GMi, this.GPW.GMj);
                        }
                        this.GPW.GJk = false;
                        break;
                    }
            }
            AppMethodBeat.o(192145);
            return false;
        }
    }

    public static final class d implements SliderSeekBar.a {
        final /* synthetic */ TrackCropView GPW;

        d(TrackCropView trackCropView) {
            this.GPW = trackCropView;
        }

        @Override // com.tencent.mm.plugin.mmsight.segment.SliderSeekBar.a
        public final void eky() {
            AppMethodBeat.i(192146);
            a callback = this.GPW.getCallback();
            if (callback != null) {
                callback.pause();
                AppMethodBeat.o(192146);
                return;
            }
            AppMethodBeat.o(192146);
        }

        @Override // com.tencent.mm.plugin.mmsight.segment.SliderSeekBar.a
        public final void ekz() {
            AppMethodBeat.i(192147);
            TrackCropView trackCropView = this.GPW;
            trackCropView.setCutCnt(trackCropView.getCutCnt() + 1);
            TrackCropView.b(this.GPW);
            Log.i(this.GPW.TAG, "onScrollStateChanged: " + this.GPW.GMi + ", " + this.GPW.GMj);
            a callback = this.GPW.getCallback();
            if (callback != null) {
                callback.ay(this.GPW.GMi, this.GPW.GMj);
                AppMethodBeat.o(192147);
                return;
            }
            AppMethodBeat.o(192147);
        }

        @Override // com.tencent.mm.plugin.mmsight.segment.SliderSeekBar.a
        public final void rj(boolean z) {
            AppMethodBeat.i(192148);
            TrackCropView.b(this.GPW);
            Log.i(this.GPW.TAG, "onMove: " + z + ", " + this.GPW.GMi + ", " + this.GPW.GMj);
            a callback = this.GPW.getCallback();
            if (callback != null) {
                callback.az(this.GPW.GMi, this.GPW.GMj);
            }
            if (z) {
                a callback2 = this.GPW.getCallback();
                if (callback2 != null) {
                    callback2.seekTo(this.GPW.GMi);
                }
                this.GPW.setProgress(this.GPW.GMi);
                AppMethodBeat.o(192148);
                return;
            }
            a callback3 = this.GPW.getCallback();
            if (callback3 != null) {
                callback3.seekTo(this.GPW.GMj);
            }
            this.GPW.setProgress(this.GPW.GMj);
            AppMethodBeat.o(192148);
        }
    }

    public final void setEnableLengthEdit(boolean z) {
        AppMethodBeat.i(192152);
        if (z) {
            SliderSeekBar sliderSeekBar = this.GPR;
            if (sliderSeekBar != null) {
                sliderSeekBar.ekB();
                AppMethodBeat.o(192152);
                return;
            }
            AppMethodBeat.o(192152);
            return;
        }
        SliderSeekBar sliderSeekBar2 = this.GPR;
        if (sliderSeekBar2 != null) {
            sliderSeekBar2.ekA();
            AppMethodBeat.o(192152);
            return;
        }
        AppMethodBeat.o(192152);
    }

    public static /* synthetic */ void a(TrackCropView trackCropView, ac acVar) {
        long j2;
        AppMethodBeat.i(192153);
        p.h(acVar, "composition");
        trackCropView.GMn = 0;
        trackCropView.GMo = 0;
        LinkedList linkedList = new LinkedList();
        trackCropView.GJa = 0;
        trackCropView.hwQ = 0;
        trackCropView.duration = acVar.getSourceDuration();
        CMTimeRange hfo = acVar.Gez.hfo();
        if (trackCropView.duration > Util.MILLSECONDS_OF_MINUTE) {
            j2 = Util.MILLSECONDS_OF_MINUTE;
        } else {
            j2 = trackCropView.duration;
        }
        trackCropView.GMh = j2;
        trackCropView.GMi = -1;
        trackCropView.GMj = -1;
        if (-1 < 0 || -1 < 0) {
            trackCropView.GMi = hfo.getStartUs() / 1000;
            trackCropView.GMj = hfo.getEndUs() / 1000;
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
            hVar.height = trackCropView.thumbHeight;
            hVar.width = trackCropView.thumbWidth;
            arrayList.add(hVar);
            i2 = i3;
        }
        linkedList.addAll(arrayList);
        trackCropView.GPT = false;
        trackCropView.GJd = new e(trackCropView, linkedList);
        Runnable runnable = trackCropView.GJd;
        if (runnable != null) {
            runnable.run();
            AppMethodBeat.o(192153);
            return;
        }
        AppMethodBeat.o(192153);
    }

    public static final class e implements Runnable {
        final /* synthetic */ LinkedList GMt;
        final /* synthetic */ long GMu = 3000;
        final /* synthetic */ TrackCropView GPW;

        e(TrackCropView trackCropView, LinkedList linkedList) {
            this.GPW = trackCropView;
            this.GMt = linkedList;
        }

        public final void run() {
            AppMethodBeat.i(192150);
            if (TrackCropView.e(this.GPW).getWidth() <= 0) {
                TrackCropView.e(this.GPW).post(this.GPW.GJd);
                AppMethodBeat.o(192150);
                return;
            }
            this.GPW.padding = com.tencent.mm.cb.a.fromDPToPix(this.GPW.getContext(), 40);
            float height = (((float) TrackCropView.e(this.GPW).getHeight()) * 1.0f) / ((float) this.GPW.thumbHeight);
            this.GPW.GMk = TrackCropView.e(this.GPW).getWidth() - (this.GPW.padding * 2);
            this.GPW.Avf = (((float) this.GPW.GMk) * 1.0f) / ((float) this.GPW.GMh);
            this.GPW.GMl = (int) (this.GPW.Avf * ((float) this.GPW.duration));
            float f2 = ((float) this.GPW.GMl) / (height * ((float) this.GPW.thumbWidth));
            for (h hVar : this.GMt) {
                hVar.GOF = ((f2 / ((float) this.GPW.duration)) * ((float) hVar.fEu())) / hVar.GQc.GzA.mwH;
                hVar.fEv();
                Log.d(this.GPW.TAG, "build thumbInfo index:" + hVar.trackIndex + ", frameCount:" + hVar.GOF + ", frameDuration:" + hVar.fEu() + ", frameWidth:" + (((float) hVar.fEu()) * this.GPW.Avf));
            }
            this.GPW.GMm.hEp = this.GPW.padding;
            this.GPW.GJf.hEp = this.GPW.padding;
            final int max = Math.max(0, Math.min((int) (((float) this.GPW.GMi) * this.GPW.Avf), (int) ((((float) this.GPW.GMj) * this.GPW.Avf) - ((float) this.GPW.GMk))));
            this.GPW.vKp.ah(0, -max);
            this.GMt.add(0, this.GPW.GMm);
            this.GMt.add(this.GPW.GJf);
            this.GPW.GIX.hw(this.GMt);
            this.GPW.GIX.notifyDataSetChanged();
            SliderSeekBar seekSlider = this.GPW.getSeekSlider();
            if (seekSlider != null) {
                seekSlider.ao(TrackCropView.e(this.GPW).getWidth() - (this.GPW.padding * 2), (int) (((float) this.GMu) * this.GPW.Avf), this.GPW.padding);
            }
            SliderSeekBar seekSlider2 = this.GPW.getSeekSlider();
            if (seekSlider2 != null) {
                seekSlider2.setCursorPos(0.0f);
            }
            SliderSeekBar seekSlider3 = this.GPW.getSeekSlider();
            if (seekSlider3 != null) {
                seekSlider3.post(new Runnable(this) {
                    /* class com.tencent.mm.plugin.vlog.ui.thumb.TrackCropView.e.AnonymousClass1 */
                    final /* synthetic */ e GPX;

                    {
                        this.GPX = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(192149);
                        SliderSeekBar seekSlider = this.GPX.GPW.getSeekSlider();
                        if (seekSlider != null) {
                            seekSlider.b(true, (((float) this.GPX.GPW.padding) + (((float) this.GPX.GPW.GMi) * this.GPX.GPW.Avf)) - ((float) max));
                        }
                        SliderSeekBar seekSlider2 = this.GPX.GPW.getSeekSlider();
                        if (seekSlider2 != null) {
                            seekSlider2.b(false, (((float) this.GPX.GPW.padding) + (((float) this.GPX.GPW.GMj) * this.GPX.GPW.Avf)) - ((float) max));
                        }
                        this.GPX.GPW.GPT = true;
                        AppMethodBeat.o(192149);
                    }
                });
                AppMethodBeat.o(192150);
                return;
            }
            AppMethodBeat.o(192150);
        }
    }

    public final void setProgress(long j2) {
        AppMethodBeat.i(192154);
        float f2 = ((float) this.padding) / this.Avf;
        SliderSeekBar sliderSeekBar = this.GPR;
        if (sliderSeekBar != null) {
            sliderSeekBar.setCursorPos(((float) (j2 - getScrollTime())) / ((f2 * 2.0f) + ((float) this.GMh)));
            AppMethodBeat.o(192154);
            return;
        }
        AppMethodBeat.o(192154);
    }

    private final long getScrollTime() {
        long j2;
        View view;
        AppMethodBeat.i(192155);
        View view2 = null;
        RecyclerView recyclerView = this.hak;
        if (recyclerView == null) {
            p.btv("recyclerView");
        }
        int childCount = recyclerView.getChildCount();
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                j2 = 0;
                view = view2;
                break;
            }
            RecyclerView recyclerView2 = this.hak;
            if (recyclerView2 == null) {
                p.btv("recyclerView");
            }
            view = recyclerView2.getChildAt(i2);
            if (view instanceof FrameListView) {
                if (this.hak == null) {
                    p.btv("recyclerView");
                }
                int bw = RecyclerView.bw(view);
                if (bw >= 0 && bw < this.GIX.getItemCount()) {
                    j2 = this.GIX.acK(bw).GQc.GzA.startTimeMs;
                    break;
                }
            } else {
                view = view2;
            }
            i2++;
            view2 = view;
        }
        if (view == null) {
            AppMethodBeat.o(192155);
            return 0;
        }
        long j3 = (long) ((((float) (-view.getLeft())) / this.Avf) + ((float) j2));
        AppMethodBeat.o(192155);
        return j3;
    }

    public static final /* synthetic */ void b(TrackCropView trackCropView) {
        long j2;
        View view;
        AppMethodBeat.i(192158);
        View view2 = null;
        RecyclerView recyclerView = trackCropView.hak;
        if (recyclerView == null) {
            p.btv("recyclerView");
        }
        int childCount = recyclerView.getChildCount();
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                j2 = 0;
                view = view2;
                break;
            }
            RecyclerView recyclerView2 = trackCropView.hak;
            if (recyclerView2 == null) {
                p.btv("recyclerView");
            }
            view = recyclerView2.getChildAt(i2);
            if (view instanceof FrameListView) {
                if (trackCropView.hak == null) {
                    p.btv("recyclerView");
                }
                int bw = RecyclerView.bw(view);
                if (bw >= 0 && bw < trackCropView.GIX.getItemCount()) {
                    j2 = trackCropView.GIX.acK(bw).GQc.GzA.startTimeMs;
                    break;
                }
            } else {
                view = view2;
            }
            i2++;
            view2 = view;
        }
        if (view == null || trackCropView.GPR == null) {
            trackCropView.GMi = 0;
            trackCropView.GMj = trackCropView.duration;
            AppMethodBeat.o(192158);
            return;
        }
        if (trackCropView.GPT) {
            SliderSeekBar sliderSeekBar = trackCropView.GPR;
            if (sliderSeekBar == null) {
                p.hyc();
            }
            trackCropView.GMi = (long) ((((float) (sliderSeekBar.getLeftSliderBound() - view.getLeft())) / trackCropView.Avf) + ((float) j2));
            if (trackCropView.GMi < 0) {
                trackCropView.GMi = 0;
            }
            SliderSeekBar sliderSeekBar2 = trackCropView.GPR;
            if (sliderSeekBar2 == null) {
                p.hyc();
            }
            trackCropView.GMj = (long) ((((float) (sliderSeekBar2.getRightSliderBound() - view.getLeft())) / trackCropView.Avf) + ((float) j2));
            if (trackCropView.GMj > trackCropView.duration) {
                trackCropView.GMj = trackCropView.duration;
            }
        }
        AppMethodBeat.o(192158);
    }
}
