package com.tencent.mm.plugin.gallery.picker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.LongSparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.cropview.BaseCropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.VideoTimeView;
import com.tencent.mm.vfs.s;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.x;

public final class WxMediaCropLayout extends FrameLayout {
    public static final a xnb = new a((byte) 0);
    public CommonVideoView ofW;
    public int pXO;
    public com.tencent.mm.plugin.recordvideo.plugin.a.b wgF;
    private final q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, Object> xlW;
    private final kotlin.f xmB = kotlin.g.ah(new g(this));
    private long xmD = -1;
    private final LongSparseArray<b> xmF = new LongSparseArray<>();
    private final RectF xmU = new RectF();
    private final kotlin.f xmV = kotlin.g.ah(new i(this));
    private WxCropOperationLayout.j xmW;
    private boolean xmX;
    private CropLayout.e xmY;
    private final int[] xmZ;
    private final kotlin.f xmz = kotlin.g.ah(new e(this));
    private long xna;

    public interface c {
        void a(int[] iArr, RectF rectF);
    }

    static {
        AppMethodBeat.i(165029);
        AppMethodBeat.o(165029);
    }

    private final ImageView getImageView() {
        AppMethodBeat.i(165030);
        ImageView imageView = (ImageView) this.xmz.getValue();
        AppMethodBeat.o(165030);
        return imageView;
    }

    private final WxCropOperationLayout getOperationLayout() {
        AppMethodBeat.i(257861);
        WxCropOperationLayout wxCropOperationLayout = (WxCropOperationLayout) this.xmV.getValue();
        AppMethodBeat.o(257861);
        return wxCropOperationLayout;
    }

    public final CropLayout getLayout() {
        AppMethodBeat.i(165034);
        CropLayout cropLayout = (CropLayout) this.xmB.getValue();
        AppMethodBeat.o(165034);
        return cropLayout;
    }

    static final class d extends kotlin.g.b.q implements q<String, ImageView, m<? super Integer, ? super Integer, ? extends Object>, x> {
        public static final d xng = new d();

        static {
            AppMethodBeat.i(257857);
            AppMethodBeat.o(257857);
        }

        d() {
            super(3);
        }

        @Override // kotlin.g.a.q
        public final /* synthetic */ x d(String str, ImageView imageView, m<? super Integer, ? super Integer, ? extends Object> mVar) {
            AppMethodBeat.i(257856);
            final String str2 = str;
            final ImageView imageView2 = imageView;
            final m<? super Integer, ? super Integer, ? extends Object> mVar2 = mVar;
            p.h(str2, "mediaPath");
            p.h(imageView2, "imageView");
            p.h(mVar2, "loadedCallback");
            com.tencent.mm.ac.d.i(new kotlin.g.a.a<x>() {
                /* class com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout.d.AnonymousClass1 */

                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    int i2;
                    int i3;
                    AppMethodBeat.i(257855);
                    BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(str2);
                    if (imageOptions != null) {
                        i3 = imageOptions.outWidth;
                        i2 = imageOptions.outHeight;
                        double sqrt = Math.sqrt((double) (1638400 / (i3 * i2)));
                        if (sqrt <= 1.0d) {
                            i3 = (int) (((double) i3) * sqrt);
                            i2 = (int) (sqrt * ((double) i2));
                            if (i3 < 1280 && i2 < 1280) {
                                i2 = 1280;
                                i3 = 1280;
                            }
                        }
                    } else {
                        i2 = 1280;
                        i3 = 1280;
                    }
                    final Bitmap createThumbBitmap = BitmapUtil.createThumbBitmap(str2, i2, i3, true, false);
                    if (createThumbBitmap == null) {
                        Log.e("WxMediaCropLayout", "source is null. file exit=" + s.YS(str2) + " mediaPath=" + str2 + " targetHeight=" + i2 + " targetWidth=" + i3);
                    } else {
                        final int width = createThumbBitmap.getWidth();
                        final int height = createThumbBitmap.getHeight();
                        com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout.d.AnonymousClass1.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass1 xnh;

                            {
                                this.xnh = r2;
                            }

                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                AppMethodBeat.i(257854);
                                imageView2.setImageBitmap(createThumbBitmap);
                                imageView2.setLayoutParams(new FrameLayout.LayoutParams(width, height));
                                mVar2.invoke(Integer.valueOf(width), Integer.valueOf(height));
                                x xVar = x.SXb;
                                AppMethodBeat.o(257854);
                                return xVar;
                            }
                        });
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(257855);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(257856);
            return xVar;
        }
    }

    public static final class h extends kotlin.g.b.q implements m<Integer, Integer, b> {
        final /* synthetic */ String xme;
        final /* synthetic */ WxMediaCropLayout xni;
        final /* synthetic */ c xnj;
        final /* synthetic */ long xnk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(WxMediaCropLayout wxMediaCropLayout, c cVar, long j2, String str) {
            super(2);
            this.xni = wxMediaCropLayout;
            this.xnj = cVar;
            this.xnk = j2;
            this.xme = str;
        }

        @Override // kotlin.g.a.m
        public final /* synthetic */ b invoke(Integer num, Integer num2) {
            AppMethodBeat.i(257858);
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            this.xni.getMediaWH()[0] = intValue;
            this.xni.getMediaWH()[1] = intValue2;
            RectF rectF = new RectF(this.xni.xmU);
            c cVar = this.xnj;
            if (cVar != null) {
                cVar.a(this.xni.getMediaWH(), rectF);
            }
            b a2 = WxMediaCropLayout.a(this.xni, WxMediaCropLayout.c(this.xni), intValue, intValue2, rectF, this.xnk, this.xme);
            AppMethodBeat.o(257858);
            return a2;
        }
    }

    public static final class k extends kotlin.g.b.q implements kotlin.g.a.b<Matrix, Boolean> {
        final /* synthetic */ WxMediaCropLayout xni;
        final /* synthetic */ b xnl;
        final /* synthetic */ Matrix xnm;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(WxMediaCropLayout wxMediaCropLayout, Matrix matrix, b bVar) {
            super(1);
            this.xni = wxMediaCropLayout;
            this.xnm = matrix;
            this.xnl = bVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(Matrix matrix) {
            boolean z = false;
            AppMethodBeat.i(165026);
            Matrix matrix2 = matrix;
            p.h(matrix2, LocaleUtil.ITALIAN);
            if (this.xnm.isIdentity()) {
                Log.i("WxMediaCropLayout", "previousMatrix isIdentity");
                this.xnl.xnd.set(matrix2);
                this.xnl.xne.set(WxMediaCropLayout.d(this.xni).getContentCenterRect());
                this.xnl.viewRect.set(WxMediaCropLayout.d(this.xni).getContentOriginalRect());
                this.xnl.xnf = WxMediaCropLayout.d(this.xni).getContentViewScale()[0];
                this.xnl.aXt = WxMediaCropLayout.d(this.xni).getMaxScaleValue();
                this.xnl.aXu = WxMediaCropLayout.d(this.xni).getMinScaleValue();
            } else {
                Log.i("WxMediaCropLayout", "set previousMatrix");
                matrix2.set(this.xnm);
                WxMediaCropLayout.d(this.xni).setMaxScaleValue(this.xnl.aXt);
                WxMediaCropLayout.d(this.xni).setMinScaleValue(this.xnl.aXu);
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(165026);
            return valueOf;
        }
    }

    public static final /* synthetic */ b a(WxMediaCropLayout wxMediaCropLayout, View view, int i2, int i3, RectF rectF, long j2, String str) {
        AppMethodBeat.i(165049);
        b a2 = wxMediaCropLayout.a(view, i2, i3, rectF, j2, str, 2);
        AppMethodBeat.o(165049);
        return a2;
    }

    public static final /* synthetic */ WxCropOperationLayout a(WxMediaCropLayout wxMediaCropLayout) {
        AppMethodBeat.i(257868);
        WxCropOperationLayout operationLayout = wxMediaCropLayout.getOperationLayout();
        AppMethodBeat.o(257868);
        return operationLayout;
    }

    public static final /* synthetic */ boolean a(WxMediaCropLayout wxMediaCropLayout, long j2) {
        AppMethodBeat.i(165051);
        boolean GF = wxMediaCropLayout.GF(j2);
        AppMethodBeat.o(165051);
        return GF;
    }

    public static final /* synthetic */ ImageView c(WxMediaCropLayout wxMediaCropLayout) {
        AppMethodBeat.i(165048);
        ImageView imageView = wxMediaCropLayout.getImageView();
        AppMethodBeat.o(165048);
        return imageView;
    }

    public static final /* synthetic */ CropLayout d(WxMediaCropLayout wxMediaCropLayout) {
        AppMethodBeat.i(165050);
        CropLayout layout = wxMediaCropLayout.getLayout();
        AppMethodBeat.o(165050);
        return layout;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WxMediaCropLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(165045);
        addView(getLayout(), new FrameLayout.LayoutParams(-1, -1));
        addView(getOperationLayout(), new FrameLayout.LayoutParams(-1, -1));
        this.xmW = WxCropOperationLayout.j.RECT_ADJUST;
        this.xmY = CropLayout.e.CENTER_CROP;
        this.xlW = d.xng;
        this.xmZ = new int[2];
        AppMethodBeat.o(165045);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WxMediaCropLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(165046);
        addView(getLayout(), new FrameLayout.LayoutParams(-1, -1));
        addView(getOperationLayout(), new FrameLayout.LayoutParams(-1, -1));
        this.xmW = WxCropOperationLayout.j.RECT_ADJUST;
        this.xmY = CropLayout.e.CENTER_CROP;
        this.xlW = d.xng;
        this.xmZ = new int[2];
        AppMethodBeat.o(165046);
    }

    public final CommonVideoView getVideoView() {
        AppMethodBeat.i(165031);
        CommonVideoView commonVideoView = this.ofW;
        AppMethodBeat.o(165031);
        return commonVideoView;
    }

    public final void setVideoView(CommonVideoView commonVideoView) {
        this.ofW = commonVideoView;
    }

    public final com.tencent.mm.plugin.recordvideo.plugin.a.b getMusicController() {
        return this.wgF;
    }

    public final void setMusicController(com.tencent.mm.plugin.recordvideo.plugin.a.b bVar) {
        this.wgF = bVar;
    }

    public final int getCurrentType() {
        return this.pXO;
    }

    public final void setCurrentType(int i2) {
        this.pXO = i2;
    }

    public static /* synthetic */ void a(WxMediaCropLayout wxMediaCropLayout, float f2, float f3, RectF rectF) {
        AppMethodBeat.i(257859);
        WxCropOperationLayout.j jVar = WxCropOperationLayout.j.RECT_ADJUST;
        p.h(rectF, "initCropRect");
        p.h(jVar, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        wxMediaCropLayout.getOperationLayout().setLimitMinHeight(f2);
        wxMediaCropLayout.getOperationLayout().setLimitMaxHeight(f3);
        wxMediaCropLayout.getOperationLayout().getVisibilityRect().set(rectF);
        wxMediaCropLayout.setStyle(jVar);
        wxMediaCropLayout.xmU.set(rectF);
        AppMethodBeat.o(257859);
    }

    public final void a(RectF rectF, WxCropOperationLayout.j jVar) {
        AppMethodBeat.i(257860);
        p.h(rectF, "initCropRect");
        p.h(jVar, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        setStyle(jVar);
        this.xmU.set(rectF);
        AppMethodBeat.o(257860);
    }

    private final void setStyle(WxCropOperationLayout.j jVar) {
        AppMethodBeat.i(257862);
        this.xmW = jVar;
        getOperationLayout().setStyle(jVar);
        AppMethodBeat.o(257862);
    }

    public final void setShowBorder(boolean z) {
        AppMethodBeat.i(165037);
        getLayout().setHasBorder(z);
        this.xmX = z;
        if (z) {
            getLayout().setOnBorderVisibilityCallback(new f(this));
        }
        AppMethodBeat.o(165037);
    }

    public static final class f implements BaseCropLayout.b {
        final /* synthetic */ WxMediaCropLayout xni;

        f(WxMediaCropLayout wxMediaCropLayout) {
            this.xni = wxMediaCropLayout;
        }

        @Override // com.tencent.mm.ui.widget.cropview.BaseCropLayout.b
        public final void onShow() {
            AppMethodBeat.i(165019);
            WxMediaCropLayout.a(this.xni).ay(255, 0);
            AppMethodBeat.o(165019);
        }

        @Override // com.tencent.mm.ui.widget.cropview.BaseCropLayout.b
        public final void onDismiss() {
            AppMethodBeat.i(165020);
            WxCropOperationLayout.a(WxMediaCropLayout.a(this.xni));
            AppMethodBeat.o(165020);
        }
    }

    public final CropLayout.e getCropLayoutScaleType() {
        return this.xmY;
    }

    public final void setCropLayoutScaleType(CropLayout.e eVar) {
        AppMethodBeat.i(257863);
        p.h(eVar, "value");
        this.xmY = eVar;
        getLayout().setScaleType(eVar);
        AppMethodBeat.o(257863);
    }

    public final int[] getMediaWH() {
        return this.xmZ;
    }

    public static /* synthetic */ b a(WxMediaCropLayout wxMediaCropLayout, long j2, String str, boolean z, c cVar, q qVar, int i2) {
        c cVar2;
        AppMethodBeat.i(257864);
        if ((i2 & 4) != 0) {
            z = false;
        }
        if ((i2 & 8) != 0) {
            cVar2 = null;
        } else {
            cVar2 = cVar;
        }
        if ((i2 & 16) != 0) {
            qVar = wxMediaCropLayout.xlW;
        }
        p.h(str, "mediaPath");
        p.h(qVar, "contentCreator");
        if (j2 != wxMediaCropLayout.xmD || z) {
            Log.i("WxMediaCropLayout", "onPreviewImage");
            wxMediaCropLayout.onUIPause();
            wxMediaCropLayout.getLayout().De(true);
            wxMediaCropLayout.getLayout().setEnableScale(true);
            wxMediaCropLayout.getImageView().setImageDrawable(wxMediaCropLayout.getBackground());
            wxMediaCropLayout.getOperationLayout().eLC();
            qVar.d(str, wxMediaCropLayout.getImageView(), new h(wxMediaCropLayout, cVar2, j2, str));
            b v = wxMediaCropLayout.v(j2, str);
            AppMethodBeat.o(257864);
            return v;
        }
        b bVar = wxMediaCropLayout.xmF.get(j2);
        if (bVar == null) {
            Log.e("WxMediaCropLayout", "[error] currentPreviewMediaId=" + wxMediaCropLayout.xmD + " mediaId=" + j2 + ' ');
            bVar = new b(-1, "");
        }
        AppMethodBeat.o(257864);
        return bVar;
    }

    public static /* synthetic */ b a(WxMediaCropLayout wxMediaCropLayout, long j2, String str, boolean z, c cVar) {
        AppMethodBeat.i(165041);
        b a2 = wxMediaCropLayout.a(j2, str, z, cVar, false);
        AppMethodBeat.o(165041);
        return a2;
    }

    public final b a(long j2, String str, boolean z, c cVar, boolean z2) {
        AppMethodBeat.i(165040);
        p.h(str, "mediaPath");
        if (j2 != this.xmD || z) {
            Log.i("WxMediaCropLayout", "onPreviewVideo");
            getLayout().De(true);
            getLayout().setEnableScale(true);
            com.tencent.mm.plugin.gallery.a.c cVar2 = com.tencent.mm.plugin.gallery.a.c.xsz;
            com.tencent.mm.plugin.sight.base.a awl = com.tencent.mm.plugin.gallery.a.c.awl(str);
            if (this.ofW == null) {
                this.ofW = new CommonVideoView(getContext());
            }
            CommonVideoView commonVideoView = this.ofW;
            if (commonVideoView != null) {
                if ((!p.j(commonVideoView.getTag(), str)) || z2) {
                    commonVideoView.stop();
                    commonVideoView.dFl();
                    commonVideoView.setLoop(true);
                    commonVideoView.setMute(false);
                    commonVideoView.setIsShowBasicControls(false);
                    commonVideoView.setScaleType(i.e.CONTAIN);
                    commonVideoView.c(false, str, 0);
                    commonVideoView.onUIResume();
                    commonVideoView.start();
                    commonVideoView.setTag(str);
                } else if (!commonVideoView.isPlaying()) {
                    commonVideoView.start();
                }
            }
            this.xmZ[0] = awl.width;
            this.xmZ[1] = awl.height;
            RectF rectF = new RectF(this.xmU);
            if (cVar != null) {
                cVar.a(this.xmZ, rectF);
            }
            getOperationLayout().a(WxCropOperationLayout.h.TOP_RIGHT);
            getOperationLayout().a(WxCropOperationLayout.h.BOTTOM_LEFT);
            VideoTimeView videoTimeView = new VideoTimeView(getContext());
            videoTimeView.setDuration(awl.videoDuration / 1000);
            videoTimeView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            videoTimeView.start();
            getOperationLayout().a(videoTimeView, WxCropOperationLayout.h.TOP_RIGHT);
            getOperationLayout().setBorderVisibilityCallback(videoTimeView);
            getOperationLayout().eLD();
            Log.i("WxMediaCropLayout", "onPreviewVideo ready to setCropView");
            CommonVideoView commonVideoView2 = this.ofW;
            if (commonVideoView2 == null) {
                p.hyc();
            }
            b a2 = a(commonVideoView2, awl.width, awl.height, rectF, j2, str, 1);
            AppMethodBeat.o(165040);
            return a2;
        }
        b bVar = this.xmF.get(j2);
        p.g(bVar, "matrixMap[mediaId]");
        b bVar2 = bVar;
        AppMethodBeat.o(165040);
        return bVar2;
    }

    public final void onUIPause() {
        com.tencent.mm.plugin.recordvideo.plugin.a.b bVar;
        CommonVideoView commonVideoView;
        AppMethodBeat.i(257865);
        Log.i("WxMediaCropLayout", "onUIPause");
        if (!(this.ofW == null || (commonVideoView = this.ofW) == null)) {
            commonVideoView.onUIPause();
        }
        if (this.wgF == null || (bVar = this.wgF) == null) {
            AppMethodBeat.o(257865);
            return;
        }
        bVar.pauseAudio();
        AppMethodBeat.o(257865);
    }

    public final void setEnableScale(boolean z) {
        AppMethodBeat.i(257866);
        getLayout().setEnableScale(z);
        AppMethodBeat.o(257866);
    }

    public final void dRJ() {
        AppMethodBeat.i(257867);
        removeView(getOperationLayout());
        AppMethodBeat.o(257867);
    }

    public final long getLockCropMediaId() {
        return this.xna;
    }

    public final void setLockCropMediaId(long j2) {
        this.xna = j2;
    }

    private final b v(long j2, String str) {
        AppMethodBeat.i(165042);
        if (this.xmF.get(j2) == null) {
            b bVar = new b(j2, str);
            this.xmF.put(j2, bVar);
            this.xmU.round(bVar.iiw);
            AppMethodBeat.o(165042);
            return bVar;
        }
        b bVar2 = this.xmF.get(j2);
        p.g(bVar2, "cropInfo");
        AppMethodBeat.o(165042);
        return bVar2;
    }

    private final boolean GF(long j2) {
        return this.xna == j2 || this.xna == 0;
    }

    private final b a(View view, int i2, int i3, RectF rectF, long j2, String str, int i4) {
        AppMethodBeat.i(165043);
        Log.i("WxMediaCropLayout", "[setCropView] mediaId=" + j2 + " viewW=" + i2 + " viewH=" + i3 + " defaultVisibilityRect=" + rectF + " lockCropRect=" + this.xmU + " path=" + str + " mediaType=" + i4);
        this.xmD = j2;
        if (0 == this.xna) {
            this.xna = j2;
        }
        b v = v(j2, str);
        if (GF(j2)) {
            getOperationLayout().setStyle(this.xmW);
            if (!v.gT.isIdentity()) {
                rectF.set(this.xmU);
            }
            this.xmU.round(v.iiw);
        } else {
            getOperationLayout().setStyle(WxCropOperationLayout.j.RECT_HARD);
            rectF.set(this.xmU);
            this.xmU.round(v.iiw);
        }
        getLayout().getVisibilityRect().set(rectF);
        getOperationLayout().getVisibilityRect().set(rectF);
        getOperationLayout().setOnOperationCallback(new j(this, j2, v));
        getLayout().a(view, i2, i3, v.gT, this.xmY, new k(this, new Matrix(v.gT), v));
        getLayout().setOnChangeListener(new l(this, v));
        b bVar = this.xmF.get(j2);
        p.g(bVar, "matrixMap[mediaId]");
        b bVar2 = bVar;
        AppMethodBeat.o(165043);
        return bVar2;
    }

    public static final class j implements WxCropOperationLayout.i {
        final /* synthetic */ WxMediaCropLayout xni;
        final /* synthetic */ long xnk;
        final /* synthetic */ b xnl;

        j(WxMediaCropLayout wxMediaCropLayout, long j2, b bVar) {
            this.xni = wxMediaCropLayout;
            this.xnk = j2;
            this.xnl = bVar;
        }

        @Override // com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.i
        public final void pA(boolean z) {
        }

        @Override // com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.i
        public final void e(RectF rectF) {
            AppMethodBeat.i(165025);
            p.h(rectF, "rectF");
            if (WxMediaCropLayout.a(this.xni, this.xnk)) {
                this.xni.xmU.set(rectF);
            }
            rectF.round(this.xnl.iiw);
            WxMediaCropLayout.d(this.xni).b(rectF, false);
            AppMethodBeat.o(165025);
        }

        @Override // com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.i
        public final void pz(boolean z) {
        }
    }

    public static final class l implements CropLayout.c {
        final /* synthetic */ WxMediaCropLayout xni;
        final /* synthetic */ b xnl;

        l(WxMediaCropLayout wxMediaCropLayout, b bVar) {
            this.xni = wxMediaCropLayout;
            this.xnl = bVar;
        }

        @Override // com.tencent.mm.ui.widget.cropview.CropLayout.c
        public final void onChange() {
            AppMethodBeat.i(165027);
            this.xnl.rwL.set(WxMediaCropLayout.d(this.xni).getContentRect());
            AppMethodBeat.o(165027);
        }
    }

    public final b getCurrentCropInfo() {
        AppMethodBeat.i(165044);
        b bVar = this.xmF.get(this.xmD);
        if (bVar == null) {
            WxMediaCropLayout wxMediaCropLayout = this;
            Log.w("WxMediaCropLayout", "[getCurrentCropInfo] currentPreviewMediaId=" + wxMediaCropLayout.xmD);
            bVar = new b(wxMediaCropLayout.xmD, "");
        }
        AppMethodBeat.o(165044);
        return bVar;
    }

    public static final class b {
        float aXt = 1.0f;
        float aXu = 1.0f;
        public Matrix gT = new Matrix();
        public Rect iiw = new Rect();
        private final String mediaPath;
        public final Rect rwL = new Rect();
        public Rect viewRect = new Rect();
        private final long xjE;
        private Matrix xnc = new Matrix();
        Matrix xnd = new Matrix();
        public Rect xne = new Rect();
        float xnf = 1.0f;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
            if (kotlin.g.b.p.j(r5.mediaPath, r6.mediaPath) != false) goto L_0x0020;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r6) {
            /*
                r5 = this;
                r4 = 165017(0x28499, float:2.31238E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                if (r5 == r6) goto L_0x0020
                boolean r0 = r6 instanceof com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout.b
                if (r0 == 0) goto L_0x0025
                com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout$b r6 = (com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout.b) r6
                long r0 = r5.xjE
                long r2 = r6.xjE
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 != 0) goto L_0x0025
                java.lang.String r0 = r5.mediaPath
                java.lang.String r1 = r6.mediaPath
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0025
            L_0x0020:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            L_0x0024:
                return r0
            L_0x0025:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                goto L_0x0024
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.picker.view.WxMediaCropLayout.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(165016);
            long j2 = this.xjE;
            int i2 = ((int) (j2 ^ (j2 >>> 32))) * 31;
            String str = this.mediaPath;
            int hashCode = (str != null ? str.hashCode() : 0) + i2;
            AppMethodBeat.o(165016);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(165015);
            String str = "CropInfo(mediaId=" + this.xjE + ", mediaPath=" + this.mediaPath + ")";
            AppMethodBeat.o(165015);
            return str;
        }

        public b(long j2, String str) {
            p.h(str, "mediaPath");
            AppMethodBeat.i(165014);
            this.xjE = j2;
            this.mediaPath = str;
            AppMethodBeat.o(165014);
        }

        public final Matrix dRK() {
            AppMethodBeat.i(165013);
            this.xnc.set(this.gT);
            this.xnc.postTranslate(0.0f, -((float) this.iiw.top));
            Log.d("WxMediaCropLayout", "matrix=" + this.gT + " cropMatrix=" + this.xnc + ' ' + this.iiw);
            Matrix matrix = this.xnc;
            AppMethodBeat.o(165013);
            return matrix;
        }
    }

    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ WxMediaCropLayout xni;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(WxMediaCropLayout wxMediaCropLayout) {
            super(0);
            this.xni = wxMediaCropLayout;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(165018);
            ImageView imageView = new ImageView(this.xni.getContext());
            AppMethodBeat.o(165018);
            return imageView;
        }
    }

    static final class g extends kotlin.g.b.q implements kotlin.g.a.a<CropLayout> {
        final /* synthetic */ WxMediaCropLayout xni;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(WxMediaCropLayout wxMediaCropLayout) {
            super(0);
            this.xni = wxMediaCropLayout;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ CropLayout invoke() {
            AppMethodBeat.i(165021);
            Context context = this.xni.getContext();
            p.g(context, "context");
            CropLayout cropLayout = new CropLayout(context);
            cropLayout.setHasBorder(false);
            cropLayout.setEnableScale(true);
            cropLayout.setEnableFling(true);
            cropLayout.setEnableTouch(true);
            cropLayout.setEnableOverScroll(false);
            AppMethodBeat.o(165021);
            return cropLayout;
        }
    }

    static final class i extends kotlin.g.b.q implements kotlin.g.a.a<WxCropOperationLayout> {
        final /* synthetic */ WxMediaCropLayout xni;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(WxMediaCropLayout wxMediaCropLayout) {
            super(0);
            this.xni = wxMediaCropLayout;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ WxCropOperationLayout invoke() {
            AppMethodBeat.i(165024);
            Context context = this.xni.getContext();
            p.g(context, "context");
            WxCropOperationLayout wxCropOperationLayout = new WxCropOperationLayout(context);
            AppMethodBeat.o(165024);
            return wxCropOperationLayout;
        }
    }
}
