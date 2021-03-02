package com.tencent.mm.plugin.vlog.ui.plugin;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.model.j;
import com.tencent.mm.plugin.vlog.model.t;
import com.tencent.mm.plugin.vlog.ui.plugin.e;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.videocomposition.n;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002\u0011\u001b\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\n\u0010&\u001a\u0004\u0018\u00010 H\u0016J\u0006\u0010'\u001a\u00020(J\b\u0010)\u001a\u00020*H\u0016J\n\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0007H\u0016J\b\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020(2\u0006\u00103\u001a\u00020\u0016H\u0016J\b\u00104\u001a\u00020(H\u0016J\u0010\u00105\u001a\u00020(2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u00106\u001a\u00020(2\u0006\u00107\u001a\u00020\u001eH\u0016J\u0012\u00108\u001a\u00020(2\b\u00109\u001a\u0004\u0018\u00010\tH\u0016J(\u0010:\u001a\u00020(2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\u00162\u0006\u0010<\u001a\u00020\u00162\u0006\u0010=\u001a\u00020\u001eH\u0016J\u0010\u0010>\u001a\u00020(2\u0006\u0010?\u001a\u00020\u0019H\u0016J\u0010\u0010@\u001a\u00020(2\u0006\u0010A\u001a\u00020BH\u0016J\u0010\u0010C\u001a\u00020(2\u0006\u0010?\u001a\u00020\u0019H\u0016J\b\u0010D\u001a\u00020(H\u0016J\u0006\u0010E\u001a\u00020(R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewImpl;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "provider", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;)V", "TAG", "", "audioSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "getAudioSeekable", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "setAudioSeekable", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;)V", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "cropChangeListener", "com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$cropChangeListener$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$cropChangeListener$1;", "darkDelayRunnable", "Ljava/lang/Runnable;", "isActive", "", "isFullscreenMode", "maxVisibleRect", "Landroid/graphics/RectF;", "operationCallback", "com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$operationCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$operationCallback$1;", "playingTime", "", "playingTrack", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "getProvider", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "videoCropView", "Landroid/view/View;", "visibleRect", "currentPlayingTrack", "enableFullscreenMode", "", "getCropChangeListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "getCropInView", "Landroid/graphics/Rect;", "getCropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "path", "getOperationCallback", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onActiveChange", "active", "onFinish", "onPreview", "onProgress", "timeMs", "onStart", "seekable", "onUpdate", "playAfterUpdate", "seekToOriginPosition", "seekTo", "setMaxVisibleRect", "rect", "setVideoSize", "size", "Landroid/util/Size;", "setVisibleRect", "showVideoLabel", "updateVideoCrop", "plugin-vlog_release"})
public final class w implements e.c, z {
    e.AbstractC1868e GGU;
    private final View GId = new View(this.GIj.fDf().getContext());
    ad GIe;
    private long GIf;
    final Runnable GIg = new b(this);
    private final a GIh = new a(this);
    private final e GIi = new e(this);
    final aa GIj;
    boolean Gna;
    ac GxA;
    final RectF GyF = new RectF();
    final RectF GyG = new RectF();
    final String TAG = "MicroMsg.MultiVideoPreview";
    private boolean isActive;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/graphics/Matrix;", "invoke"})
    public static final class f extends q implements kotlin.g.a.b<Matrix, Boolean> {
        final /* synthetic */ boolean GHh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(boolean z) {
            super(1);
            this.GHh = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(Matrix matrix) {
            AppMethodBeat.i(191440);
            p.h(matrix, LocaleUtil.ITALIAN);
            Boolean valueOf = Boolean.valueOf(this.GHh);
            AppMethodBeat.o(191440);
            return valueOf;
        }
    }

    public w(aa aaVar) {
        p.h(aaVar, "provider");
        AppMethodBeat.i(191449);
        this.GIj = aaVar;
        AppMethodBeat.o(191449);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ w GIk;

        b(w wVar) {
            this.GIk = wVar;
        }

        public final void run() {
            AppMethodBeat.i(191434);
            if (!this.GIk.Gna) {
                this.GIk.GIj.getOperationLayout().eLF();
            }
            AppMethodBeat.o(191434);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$cropChangeListener$1", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeStartEndListener;", "startScale", "", "onChange", "", "onChangeEnd", "onChangeStart", "plugin-vlog_release"})
    public static final class a implements CropLayout.d {
        private float CIE = 1.0f;
        final /* synthetic */ w GIk;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(w wVar) {
            this.GIk = wVar;
        }

        @Override // com.tencent.mm.ui.widget.cropview.CropLayout.c
        public final void onChange() {
            AppMethodBeat.i(191431);
            Log.i(this.GIk.TAG, "onChange: " + this.GIk.GIj.fDg().getContentRect());
            if (this.GIk.GIj.fDg().getContentRect().isEmpty()) {
                AppMethodBeat.o(191431);
                return;
            }
            ad adVar = this.GIk.GIe;
            if (adVar != null) {
                adVar.Gzx.rwL.set(this.GIk.GIj.fDg().getContentRect());
                adVar.GzA.iiw.set(this.GIk.GIj.fDg().getContentRect());
                adVar.Gzx.rwL.offset(-((int) this.GIk.GyG.left), -((int) this.GIk.GyG.top));
                adVar.GzA.iiw.offset(-((int) this.GIk.GyG.left), -((int) this.GIk.GyG.top));
                adVar.Gzx.iiw.set(adVar.Gzx.rwL);
            }
            if (!this.GIk.GIj.fCU().isPlaying()) {
                this.GIk.GIj.fCU().bLe();
            }
            AppMethodBeat.o(191431);
        }

        @Override // com.tencent.mm.ui.widget.cropview.CropLayout.d
        public final void fDj() {
            j jVar;
            Matrix matrix;
            AppMethodBeat.i(191432);
            String str = this.GIk.TAG;
            StringBuilder sb = new StringBuilder("onChangeStart: audioSeekable:");
            e.AbstractC1868e eVar = this.GIk.GGU;
            Log.i(str, sb.append(eVar != null ? eVar.hashCode() : 0).toString());
            this.GIk.GIj.fCU().pause();
            e.AbstractC1868e eVar2 = this.GIk.GGU;
            if (eVar2 != null) {
                eVar2.pause();
            }
            ad adVar = this.GIk.GIe;
            this.CIE = (adVar == null || (jVar = adVar.Gzx) == null || (matrix = jVar.gT) == null) ? 1.0f : t.e(matrix);
            com.tencent.mm.ac.d.C(this.GIk.GIg);
            this.GIk.GIj.getOperationLayout().eLG();
            AppMethodBeat.o(191432);
        }

        @Override // com.tencent.mm.ui.widget.cropview.CropLayout.d
        public final void fDk() {
            AppMethodBeat.i(191433);
            String str = this.GIk.TAG;
            StringBuilder sb = new StringBuilder("onChangeEnd: audioSeekable:");
            e.AbstractC1868e eVar = this.GIk.GGU;
            Log.i(str, sb.append(eVar != null ? eVar.hashCode() : 0).toString());
            this.GIk.GIj.fDh();
            ad adVar = this.GIk.GIe;
            if (adVar != null) {
                if (this.CIE != t.e(adVar.Gzx.gT)) {
                    adVar.Gzz.scaleCount++;
                } else {
                    adVar.Gzz.dragCount++;
                }
            }
            com.tencent.mm.ac.d.a(3000, this.GIk.GIg);
            AppMethodBeat.o(191433);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$operationCallback$1", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onBlockDownClick", "", "isTopBlock", "", "onBlockTouchUp", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-vlog_release"})
    public static final class e implements WxCropOperationLayout.i {
        final /* synthetic */ w GIk;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(w wVar) {
            this.GIk = wVar;
        }

        @Override // com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.i
        public final void e(RectF rectF) {
            Rect rect;
            j jVar;
            ArrayList<ad> arrayList;
            float f2;
            AppMethodBeat.i(191437);
            p.h(rectF, "rectF");
            this.GIk.GyF.set(rectF);
            Log.i(this.GIk.TAG, "operationCallback onChange:".concat(String.valueOf(rectF)));
            ac acVar = this.GIk.GxA;
            if (!(acVar == null || (arrayList = acVar.Gzn) == null)) {
                for (T t : arrayList) {
                    j jVar2 = t.Gzx;
                    rectF.round(jVar2.iiw);
                    jVar2.iiw.offset(-((int) this.GIk.GyG.left), -((int) this.GIk.GyG.top));
                    if (!p.j(this.GIk.GIe, t) && !this.GIk.Gna) {
                        jVar2.rwL.offset(0, (int) this.GIk.GyG.top);
                        float f3 = rectF.bottom - ((float) jVar2.rwL.bottom);
                        float f4 = rectF.top - ((float) jVar2.rwL.top);
                        if (f3 > 0.0f || f4 < 0.0f) {
                            Matrix matrix = new Matrix();
                            RectF rectF2 = new RectF(jVar2.rwL);
                            float height = rectF.height() / rectF2.height();
                            if (height < 1.0f) {
                                if (f4 >= 0.0f) {
                                    f4 = f3;
                                }
                                f2 = 1.0f;
                            } else {
                                f4 = rectF.centerY() - rectF2.centerY();
                                f2 = height;
                            }
                            matrix.postTranslate(0.0f, f4);
                            matrix.postScale(f2, f2, rectF.centerX(), rectF.centerY());
                            matrix.mapRect(rectF2);
                            rectF2.round(jVar2.rwL);
                            rectF2.round(t.GzA.iiw);
                            t.Gzx.rwL.offset(-((int) this.GIk.GyG.left), -((int) this.GIk.GyG.top));
                            t.GzA.iiw.offset(-((int) this.GIk.GyG.left), -((int) this.GIk.GyG.top));
                            jVar2.gT.postConcat(matrix);
                        } else {
                            t.Gzx.rwL.offset(-((int) this.GIk.GyG.left), -((int) this.GIk.GyG.top));
                        }
                        Log.i(this.GIk.TAG, "operationCallback track info, id:" + t.id + ", contentRect:" + t.Gzx.rwL);
                    }
                }
            }
            ad adVar = this.GIk.GIe;
            if (adVar == null || (jVar = adVar.Gzx) == null) {
                rect = null;
            } else {
                rect = jVar.rwL;
            }
            if (rect == null || !this.GIk.GIj.fDg().getContentRect().isEmpty()) {
                this.GIk.GIj.fDg().b(rectF, false);
            }
            AppMethodBeat.o(191437);
        }

        @Override // com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.i
        public final void pz(boolean z) {
            AppMethodBeat.i(191438);
            com.tencent.mm.ac.d.C(this.GIk.GIg);
            this.GIk.GIj.getOperationLayout().eLG();
            AppMethodBeat.o(191438);
        }

        @Override // com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.i
        public final void pA(boolean z) {
            AppMethodBeat.i(191439);
            com.tencent.mm.ac.d.a(3000, this.GIk.GIg);
            AppMethodBeat.o(191439);
        }
    }

    public final void i(RectF rectF) {
        AppMethodBeat.i(191441);
        p.h(rectF, "rect");
        this.GyG.set(rectF);
        AppMethodBeat.o(191441);
    }

    public final void h(RectF rectF) {
        AppMethodBeat.i(191442);
        p.h(rectF, "rect");
        this.GyF.set(rectF);
        AppMethodBeat.o(191442);
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.z
    public final void a(ac acVar, boolean z, boolean z2, long j2) {
        AppMethodBeat.i(191443);
        p.h(acVar, "composition");
        Log.i(this.TAG, "onUpdate: playRange:" + acVar.Gez.hfo() + ", trackList.size:" + acVar.Gzn.size() + ", playAfterUpdate:" + z);
        VideoCompositionPlayView fCU = this.GIj.fCU();
        if (!p.j(fCU.getParent(), this.GIj.fDf())) {
            ViewParent parent = fCU.getParent();
            if (!(parent instanceof ViewGroup)) {
                parent = null;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup != null) {
                viewGroup.removeView(fCU);
            }
            fCU.setScaleX(1.0f);
            fCU.setScaleY(1.0f);
            fCU.setTranslationX(0.0f);
            fCU.setTranslationY(0.0f);
            Log.i(this.TAG, "videoView size width:" + this.GyG.width() + " height:" + this.GyG.height());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) this.GyG.width(), (int) this.GyG.height());
            layoutParams.topMargin = (int) this.GyG.top;
            layoutParams.addRule(14);
            this.GIj.fDf().addView(fCU, 0, layoutParams);
        }
        if (!this.Gna) {
            this.GIj.fDg().getVisibilityRect().set(this.GyF);
            this.GIj.getOperationLayout().getVisibilityRect().set(this.GyF);
        }
        this.GxA = acVar;
        this.GIe = (ad) kotlin.a.j.L(acVar.Gzn, 0);
        fDJ();
        if (!z || z2 || j2 != -1) {
            com.tencent.mm.plugin.vlog.model.report.b bVar = com.tencent.mm.plugin.vlog.model.report.b.GBb;
            com.tencent.mm.plugin.vlog.model.report.b.report(10);
            VideoCompositionPlayView fCU2 = this.GIj.fCU();
            n composition = acVar.getComposition();
            p.h(composition, "composition");
            com.tencent.mm.videocomposition.c.b.i(VideoCompositionPlayView.TAG, "updateComposition, playAfterUpdate:" + z + ", seekToOriginPosition:" + z2 + ", seekTo:" + j2, new Object[0]);
            com.tencent.mm.videocomposition.play.a aVar = fCU2.RhC;
            if (aVar != null) {
                aVar.a(composition, z, z2, j2);
            }
            fCU2.Gez = composition;
            WxCropOperationLayout operationLayout = this.GIj.getOperationLayout();
            ValueAnimator valueAnimator = operationLayout.BZs;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            operationLayout.BZb = 0;
            operationLayout.invalidate();
            AppMethodBeat.o(191443);
            return;
        }
        this.GIj.fCU().a(acVar.getComposition());
        this.GIj.getOperationLayout().postDelayed(new d(this), 3000);
        AppMethodBeat.o(191443);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ w GIk;

        d(w wVar) {
            this.GIk = wVar;
        }

        public final void run() {
            AppMethodBeat.i(191436);
            WxCropOperationLayout.a(this.GIk.GIj.getOperationLayout());
            AppMethodBeat.o(191436);
        }
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.z
    public final void wH(boolean z) {
        this.isActive = z;
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.z
    public final CropLayout.c fDH() {
        return this.GIh;
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.z
    public final WxCropOperationLayout.i fDI() {
        return this.GIi;
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.z
    public final Rect fDa() {
        AppMethodBeat.i(191444);
        Rect rect = new Rect();
        this.GIj.fDg().getVisibilityRect().round(rect);
        rect.offset(-((int) this.GyG.left), -((int) this.GyG.top));
        AppMethodBeat.o(191444);
        return rect;
    }

    public final void fDJ() {
        AppMethodBeat.i(191445);
        ad adVar = this.GIe;
        if (adVar == null) {
            AppMethodBeat.o(191445);
            return;
        }
        int i2 = adVar.Gzu;
        int i3 = adVar.Gzv;
        j jVar = adVar.Gzx;
        this.GIj.fDg().setMaxScaleValue(jVar.aXt);
        this.GIj.fDg().setMinScaleValue(jVar.aXu);
        boolean isEmpty = this.GIj.fDg().getContentRect().isEmpty();
        this.GIj.fDg().getContentRect().set(jVar.rwL);
        this.GIj.fDg().getContentRect().offset(0, (int) this.GyG.top);
        this.GIj.fDg().a(this.GId, i2, i3, jVar.gT, CropLayout.e.CENTER_INSIDE, new f(isEmpty));
        Log.i(this.TAG, "updateVideoCrop, viewWidth:" + i2 + ", viewHeight:" + i3);
        AppMethodBeat.o(191445);
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.e.c
    public final void a(e.AbstractC1868e eVar) {
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.e.c
    public final void onProgress(long j2) {
        ad adVar;
        ArrayList<ad> arrayList;
        T t;
        boolean z;
        String str = null;
        AppMethodBeat.i(191446);
        if (!this.isActive) {
            AppMethodBeat.o(191446);
            return;
        }
        this.GIf = j2;
        ac acVar = this.GxA;
        if (acVar == null || (arrayList = acVar.Gzn) == null) {
            adVar = null;
        } else {
            Iterator<T> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                T next = it.next();
                T t2 = next;
                if (t2.GzA.startTimeMs > j2 || t2.GzA.endTimeMs <= j2) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    t = next;
                    break;
                }
            }
            adVar = t;
        }
        if (!p.j(adVar, this.GIe)) {
            com.tencent.mm.plugin.vlog.model.local.a aVar = com.tencent.mm.plugin.vlog.model.local.a.GAD;
            if (com.tencent.mm.plugin.vlog.model.local.a.fBV()) {
                com.tencent.mm.plugin.vlog.model.local.a aVar2 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
                if (adVar != null) {
                    str = adVar.path;
                }
                int aUc = com.tencent.mm.plugin.vlog.model.local.a.aUc(str);
                TextView fDi = this.GIj.fDi();
                com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b bVar = com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.GLF;
                fDi.setText(com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.acJ(aUc));
            }
            com.tencent.mm.ac.d.h(new c(this, adVar));
        }
        AppMethodBeat.o(191446);
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.z
    public final void fDK() {
        String str;
        AppMethodBeat.i(191447);
        com.tencent.mm.plugin.vlog.model.local.a aVar = com.tencent.mm.plugin.vlog.model.local.a.GAD;
        ad adVar = this.GIe;
        if (adVar != null) {
            str = adVar.path;
        } else {
            str = null;
        }
        int aUc = com.tencent.mm.plugin.vlog.model.local.a.aUc(str);
        TextView fDi = this.GIj.fDi();
        com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b bVar = com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.GLF;
        fDi.setText(com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.acJ(aUc));
        AppMethodBeat.o(191447);
    }

    @Override // com.tencent.mm.plugin.vlog.ui.plugin.z
    public final void a(Size size) {
        AppMethodBeat.i(191448);
        p.h(size, "size");
        AppMethodBeat.o(191448);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ w GIk;
        final /* synthetic */ ad GIl;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(w wVar, ad adVar) {
            super(0);
            this.GIk = wVar;
            this.GIl = adVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(191435);
            this.GIk.GIe = this.GIl;
            this.GIk.fDJ();
            x xVar = x.SXb;
            AppMethodBeat.o(191435);
            return xVar;
        }
    }
}
