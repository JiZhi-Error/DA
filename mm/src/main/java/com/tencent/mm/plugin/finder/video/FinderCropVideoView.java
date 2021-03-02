package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.loader.s;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.gallery.a.c;
import com.tencent.mm.protocal.protobuf.bej;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\fH\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0018H\u0016J\b\u0010#\u001a\u00020$H\u0014J\b\u0010%\u001a\u00020\u0018H\u0016J\b\u0010&\u001a\u00020\fH\u0014J\b\u0010'\u001a\u00020$H\u0016J\b\u0010(\u001a\u00020$H\u0016J\b\u0010)\u001a\u00020\u0018H\u0016J\u0016\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0018J\u0012\u0010.\u001a\u00020$2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0010\u00101\u001a\u00020$2\u0006\u00102\u001a\u00020\u0018H\u0016J\u0010\u00103\u001a\u00020$2\u0006\u00104\u001a\u00020\u0018H\u0016J\u000e\u00105\u001a\u00020$2\u0006\u00106\u001a\u000207J \u00108\u001a\u00020$2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00182\u0006\u0010<\u001a\u00020=H\u0016J\u0010\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020$2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u00020$2\u0006\u0010E\u001a\u00020\u0018H\u0016R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010¨\u0006F"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderCropVideoView;", "Lcom/tencent/mm/plugin/finder/video/FinderVideoView;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cropLayout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "videoRootHeight", "", "getVideoRootHeight", "()I", "setVideoRootHeight", "(I)V", "videoRootWidth", "getVideoRootWidth", "setVideoRootWidth", "getCurrentPlayMs", "", "getCurrentPlaySecond", "getIsNeverStart", "", "getIsShouldPlayResume", "getParentView", "Landroid/view/ViewParent;", "getVideoDuration", "getVideoDurationMs", "getVideoMediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getVideoView", "Landroid/view/View;", "getVideoViewFocused", "initView", "", "isPreviewing", "layoutId", "onMediaInfoAndMatrixPrepared", "onRelease", "prepareToPlay", "rawSeekTo", "time", "", "afterSeekPlay", "setFinderVideoCore", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "setIsShouldPlayResume", "shouldPlayResume", "setPreview", "isPreview", "setRootMatrix", "matrix", "Landroid/graphics/Matrix;", "setVideoMediaInfo", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "isLocal", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setVideoMuteListener", "onMuteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setVideoPlayLifecycle", "videoPlayLifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setVideoViewFocused", "focused", "plugin-finder_release"})
public final class FinderCropVideoView extends FinderVideoView implements r {
    private int UVm;
    private int UVn;
    private CropLayout vNh;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/graphics/Matrix;", "invoke"})
    public static final class a extends q implements b<Matrix, Boolean> {
        final /* synthetic */ Matrix vNx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Matrix matrix) {
            super(1);
            this.vNx = matrix;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(Matrix matrix) {
            AppMethodBeat.i(168000);
            Matrix matrix2 = matrix;
            p.h(matrix2, LocaleUtil.ITALIAN);
            matrix2.set(this.vNx);
            Boolean bool = Boolean.TRUE;
            AppMethodBeat.o(168000);
            return bool;
        }
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean dEN() {
        return false;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setFinderVideoCore(k kVar) {
        AppMethodBeat.i(253863);
        setVideoCore(kVar);
        AppMethodBeat.o(253863);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setVideoMuteListener(t tVar) {
        AppMethodBeat.i(253864);
        p.h(tVar, "onMuteListener");
        setMuteListener(tVar);
        AppMethodBeat.o(253864);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setVideoPlayLifecycle(y yVar) {
        AppMethodBeat.i(253865);
        p.h(yVar, "videoPlayLifecycle");
        setLifecycle(yVar);
        AppMethodBeat.o(253865);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void a(s sVar, boolean z, FeedData feedData) {
        AppMethodBeat.i(253866);
        p.h(sVar, "video");
        p.h(feedData, "feedData");
        b(sVar, z, feedData);
        AppMethodBeat.o(253866);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final s getVideoMediaInfo() {
        AppMethodBeat.i(253867);
        s mediaInfo = getMediaInfo();
        AppMethodBeat.o(253867);
        return mediaInfo;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setIsShouldPlayResume(boolean z) {
        AppMethodBeat.i(253868);
        setShouldPlayResume(z);
        AppMethodBeat.o(253868);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setVideoViewFocused(boolean z) {
        AppMethodBeat.i(253869);
        setViewFocused(z);
        AppMethodBeat.o(253869);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void setPreview(boolean z) {
        AppMethodBeat.i(253870);
        set_isPreviewing(z);
        AppMethodBeat.o(253870);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean dEO() {
        AppMethodBeat.i(253871);
        boolean z = get_isPreviewing();
        AppMethodBeat.o(253871);
        return z;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final int getCurrentPlaySecond() {
        AppMethodBeat.i(253872);
        int currPosSec = getCurrPosSec();
        AppMethodBeat.o(253872);
        return currPosSec;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final long getCurrentPlayMs() {
        AppMethodBeat.i(253873);
        long currPosMs = (long) getCurrPosMs();
        AppMethodBeat.o(253873);
        return currPosMs;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final int getVideoDuration() {
        s sVar;
        cjl cjl;
        cjx cjx;
        AppMethodBeat.i(253874);
        s mediaInfo = getMediaInfo();
        if (mediaInfo == null || (sVar = mediaInfo.tHN) == null || (cjl = sVar.uIw) == null || (cjx = cjl.uOR) == null) {
            int videoDurationSec = getVideoDurationSec();
            AppMethodBeat.o(253874);
            return videoDurationSec;
        } else if (getVideoDurationSec() > (cjx.iqg - cjx.dvv) / 1000) {
            int i2 = (cjx.iqg - cjx.dvv) / 1000;
            AppMethodBeat.o(253874);
            return i2;
        } else {
            int videoDurationSec2 = getVideoDurationSec();
            AppMethodBeat.o(253874);
            return videoDurationSec2;
        }
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final long getVideoDurationMs() {
        s sVar;
        cjl cjl;
        cjx cjx;
        AppMethodBeat.i(253875);
        s mediaInfo = getMediaInfo();
        if (mediaInfo == null || (sVar = mediaInfo.tHN) == null || (cjl = sVar.uIw) == null || (cjx = cjl.uOR) == null) {
            long videoDurationSec = ((long) getVideoDurationSec()) * 1000;
            AppMethodBeat.o(253875);
            return videoDurationSec;
        } else if (getVideoDurationSec() > (cjx.iqg - cjx.dvv) / 1000) {
            long j2 = (long) (cjx.iqg - cjx.dvv);
            AppMethodBeat.o(253875);
            return j2;
        } else {
            long videoDurationSec2 = ((long) getVideoDurationSec()) * 1000;
            AppMethodBeat.o(253875);
            return videoDurationSec2;
        }
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final ViewParent getParentView() {
        AppMethodBeat.i(253876);
        ViewParent parent = getParent();
        AppMethodBeat.o(253876);
        return parent;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final View getVideoView() {
        return this;
    }

    public FinderCropVideoView(Context context) {
        super(context);
    }

    public FinderCropVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.mm.plugin.finder.video.FinderVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final int dEP() {
        return R.layout.a6u;
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void initView() {
        AppMethodBeat.i(168001);
        super.initView();
        View findViewById = findViewById(R.id.cl1);
        p.g(findViewById, "findViewById(R.id.finder_crop_layout)");
        this.vNh = (CropLayout) findViewById;
        CropLayout cropLayout = this.vNh;
        if (cropLayout == null) {
            p.btv("cropLayout");
        }
        cropLayout.setEnableTouch(false);
        CropLayout cropLayout2 = this.vNh;
        if (cropLayout2 == null) {
            p.btv("cropLayout");
        }
        cropLayout2.setEnableScale(false);
        CropLayout cropLayout3 = this.vNh;
        if (cropLayout3 == null) {
            p.btv("cropLayout");
        }
        cropLayout3.setEnableFling(false);
        CropLayout cropLayout4 = this.vNh;
        if (cropLayout4 == null) {
            p.btv("cropLayout");
        }
        cropLayout4.setEnableOverScroll(false);
        AppMethodBeat.o(168001);
    }

    @Override // com.tencent.mm.plugin.finder.video.FinderVideoView
    public final void dEQ() {
        AppMethodBeat.i(168002);
        CropLayout cropLayout = this.vNh;
        if (cropLayout == null) {
            p.btv("cropLayout");
        }
        cropLayout.reset();
        bej videoMatrix = getVideoMatrix();
        if (videoMatrix != null) {
            if (videoMatrix.LOe.size() == 9) {
                Matrix matrix = new Matrix();
                LinkedList<Float> linkedList = videoMatrix.LOe;
                p.g(linkedList, "it.value");
                matrix.setValues(j.t((Collection<Float>) linkedList));
                setRootMatrix(matrix);
            }
            AppMethodBeat.o(168002);
            return;
        }
        AppMethodBeat.o(168002);
    }

    public final int getVideoRootWidth() {
        return this.UVm;
    }

    public final void setVideoRootWidth(int i2) {
        this.UVm = i2;
    }

    public final int getVideoRootHeight() {
        return this.UVn;
    }

    public final void setVideoRootHeight(int i2) {
        this.UVn = i2;
    }

    public final void setRootMatrix(Matrix matrix) {
        AppMethodBeat.i(168003);
        p.h(matrix, "matrix");
        if (getMediaInfo() == null) {
            AppMethodBeat.o(168003);
            return;
        }
        c cVar = c.xsz;
        s mediaInfo = getMediaInfo();
        if (mediaInfo == null) {
            p.hyc();
        }
        com.tencent.mm.plugin.sight.base.a awl = c.awl(mediaInfo.path);
        if (awl == null) {
            AppMethodBeat.o(168003);
            return;
        }
        Matrix matrix2 = new Matrix(matrix);
        CropLayout cropLayout = this.vNh;
        if (cropLayout == null) {
            p.btv("cropLayout");
        }
        RelativeLayout relativeLayout = this.mEy;
        p.g(relativeLayout, "videoRoot");
        cropLayout.a(relativeLayout, this.UVm > 0 ? this.UVm : awl.width, this.UVn > 0 ? this.UVn : awl.height, new Matrix(), CropLayout.e.CENTER_CROP, new a(matrix2));
        AppMethodBeat.o(168003);
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final void onRelease() {
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean getIsNeverStart() {
        return this.wcC;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean getIsShouldPlayResume() {
        return this.wcB;
    }

    @Override // com.tencent.mm.plugin.finder.video.r
    public final boolean getVideoViewFocused() {
        return this.wcA;
    }
}
