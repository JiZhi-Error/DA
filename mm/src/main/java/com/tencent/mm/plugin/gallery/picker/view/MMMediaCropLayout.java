package com.tencent.mm.plugin.gallery.picker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.LongSparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

public final class MMMediaCropLayout extends FrameLayout {
    public static final a xmG = new a((byte) 0);
    private final kotlin.f xmA = kotlin.g.ah(new g(this));
    private final kotlin.f xmB = kotlin.g.ah(new e(this));
    private CropLayout.e xmC = CropLayout.e.CENTER_INSIDE;
    private long xmD;
    public boolean xmE;
    private final LongSparseArray<b> xmF = new LongSparseArray<>();
    private final kotlin.f xmz = kotlin.g.ah(new d(this));

    static {
        AppMethodBeat.i(164935);
        AppMethodBeat.o(164935);
    }

    public final ImageView getImageView() {
        AppMethodBeat.i(164936);
        ImageView imageView = (ImageView) this.xmz.getValue();
        AppMethodBeat.o(164936);
        return imageView;
    }

    public final CropLayout getLayout() {
        AppMethodBeat.i(164938);
        CropLayout cropLayout = (CropLayout) this.xmB.getValue();
        AppMethodBeat.o(164938);
        return cropLayout;
    }

    public final CommonVideoView getVideoView() {
        AppMethodBeat.i(164937);
        CommonVideoView commonVideoView = (CommonVideoView) this.xmA.getValue();
        AppMethodBeat.o(164937);
        return commonVideoView;
    }

    public static final class f<T, R> implements com.tencent.mm.loader.f.e<GalleryItem.MediaItem, Bitmap> {
        final /* synthetic */ MMMediaCropLayout xmJ;
        final /* synthetic */ GalleryItem.MediaItem xmK;

        f(MMMediaCropLayout mMMediaCropLayout, GalleryItem.MediaItem mediaItem) {
            this.xmJ = mMMediaCropLayout;
            this.xmK = mediaItem;
        }

        @Override // com.tencent.mm.loader.f.e
        public final /* synthetic */ void a(com.tencent.mm.loader.h.a.a<GalleryItem.MediaItem> aVar, com.tencent.mm.loader.e.b.g gVar, Bitmap bitmap) {
            AppMethodBeat.i(164933);
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null) {
                com.tencent.mm.ac.d.h(new a(bitmap2, this));
                AppMethodBeat.o(164933);
                return;
            }
            AppMethodBeat.o(164933);
        }

        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ Bitmap cKG;
            final /* synthetic */ f xmL;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Bitmap bitmap, f fVar) {
                super(0);
                this.cKG = bitmap;
                this.xmL = fVar;
            }

            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(164932);
                MMMediaCropLayout.a(this.xmL.xmJ, this.xmL.xmJ.getImageView(), this.xmL.xmK.xiZ, this.cKG.getWidth(), this.cKG.getHeight(), this.xmL.xmK);
                x xVar = x.SXb;
                AppMethodBeat.o(164932);
                return xVar;
            }
        }
    }

    public static final /* synthetic */ void a(MMMediaCropLayout mMMediaCropLayout, View view, long j2, int i2, int i3, GalleryItem.MediaItem mediaItem) {
        AppMethodBeat.i(164948);
        mMMediaCropLayout.a(view, j2, i2, i3, mediaItem);
        AppMethodBeat.o(164948);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MMMediaCropLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(164946);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(getLayout(), layoutParams);
        AppMethodBeat.o(164946);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MMMediaCropLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(164947);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(getLayout(), layoutParams);
        AppMethodBeat.o(164947);
    }

    public final CropLayout.e getDefaultScaleType() {
        return this.xmC;
    }

    public final void setDefaultScaleType(CropLayout.e eVar) {
        AppMethodBeat.i(164939);
        p.h(eVar, "<set-?>");
        this.xmC = eVar;
        AppMethodBeat.o(164939);
    }

    public final long getCurrentPreviewMediaId() {
        return this.xmD;
    }

    public final void setCurrentPreviewMediaId(long j2) {
        this.xmD = j2;
    }

    public final void setLockCropWindow(boolean z) {
        this.xmE = z;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static /* synthetic */ void a(MMMediaCropLayout mMMediaCropLayout, GalleryItem.MediaItem mediaItem) {
        AppMethodBeat.i(164940);
        p.h(mediaItem, "media");
        if (mediaItem.xiZ != mMMediaCropLayout.xmD) {
            mMMediaCropLayout.getLayout().setEnableOverScroll(false);
            if (mMMediaCropLayout.getVideoView().isPlaying()) {
                mMMediaCropLayout.getVideoView().pause();
            }
            CropLayout.b(mMMediaCropLayout.getLayout());
            com.tencent.mm.plugin.gallery.picker.c.f fVar = com.tencent.mm.plugin.gallery.picker.c.f.xlA;
            com.tencent.mm.loader.a.b<GalleryItem.MediaItem, Bitmap> bP = com.tencent.mm.plugin.gallery.picker.c.f.dRE().bP(mediaItem);
            bP.hXY = new f(mMMediaCropLayout, mediaItem);
            bP.a(mMMediaCropLayout.getImageView(), false);
        }
        AppMethodBeat.o(164940);
    }

    public static /* synthetic */ void b(MMMediaCropLayout mMMediaCropLayout, GalleryItem.MediaItem mediaItem) {
        AppMethodBeat.i(164941);
        p.h(mediaItem, "media");
        if (mediaItem.xiZ != mMMediaCropLayout.xmD) {
            CropLayout.b(mMMediaCropLayout.getLayout());
            mMMediaCropLayout.getLayout().setEnableOverScroll(false);
            com.tencent.mm.plugin.gallery.a.c cVar = com.tencent.mm.plugin.gallery.a.c.xsz;
            com.tencent.mm.plugin.sight.base.a awl = com.tencent.mm.plugin.gallery.a.c.awl(mediaItem.xiW);
            if (!p.j(mMMediaCropLayout.getVideoView().getTag(), mediaItem.dRh())) {
                mMMediaCropLayout.getVideoView().stop();
                mMMediaCropLayout.getVideoView().setLoop(true);
                mMMediaCropLayout.getVideoView().setMute(true);
                mMMediaCropLayout.getVideoView().dFl();
                mMMediaCropLayout.getVideoView().setIsShowBasicControls(false);
                mMMediaCropLayout.getVideoView().setScaleType(i.e.COVER);
                mMMediaCropLayout.getVideoView().c(false, mediaItem.xiW, 0);
                mMMediaCropLayout.getVideoView().start();
                mMMediaCropLayout.getVideoView().play();
                mMMediaCropLayout.a(mMMediaCropLayout.getVideoView(), mediaItem.xiZ, awl.width, awl.height, mediaItem);
                mMMediaCropLayout.getVideoView().setTag(mediaItem.dRh());
                AppMethodBeat.o(164941);
                return;
            } else if (!mMMediaCropLayout.getVideoView().isPlaying()) {
                mMMediaCropLayout.a(mMMediaCropLayout.getVideoView(), mediaItem.xiZ, awl.width, awl.height, mediaItem);
                mMMediaCropLayout.getVideoView().start();
            }
        }
        AppMethodBeat.o(164941);
    }

    private final void a(View view, long j2, int i2, int i3, GalleryItem.MediaItem mediaItem) {
        Matrix matrix;
        CropLayout.e eVar;
        boolean z;
        AppMethodBeat.i(164942);
        Log.i("MMMediaCropLayout", "[setContentView] mediaId=" + j2 + " width=" + i2 + " height=" + i3 + " isLockCropWindow=" + this.xmE);
        this.xmD = j2;
        b bVar = this.xmF.get(j2);
        if (bVar == null || (matrix = bVar.gT) == null) {
            MMMediaCropLayout mMMediaCropLayout = this;
            b bVar2 = new b(j2);
            mMMediaCropLayout.getLayout().getVisibilityRect().round(bVar2.iiw);
            bVar2.viewRect.set(0, 0, i2, i3);
            bVar2.rwL = mMMediaCropLayout.getLayout().getContentRect();
            Object obj = mediaItem.iMa;
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.gallery.picker.view.MMMediaCropLayout.MediaExtra");
                AppMethodBeat.o(164942);
                throw tVar;
            }
            ((c) obj).a(bVar2);
            mMMediaCropLayout.xmF.put(j2, bVar2);
            matrix = bVar2.gT;
        }
        if (this.xmE || mediaItem.getType() == 2) {
            eVar = CropLayout.e.CENTER_CROP;
        } else {
            eVar = this.xmC;
        }
        CropLayout layout = getLayout();
        if (mediaItem.getType() != 2) {
            z = true;
        } else {
            z = false;
        }
        layout.setEnableScale(z);
        CropLayout.a(getLayout(), view, i2, i3, matrix, eVar, null, 32);
        AppMethodBeat.o(164942);
    }

    public static /* synthetic */ void a(MMMediaCropLayout mMMediaCropLayout) {
        AppMethodBeat.i(164943);
        int width = (int) mMMediaCropLayout.getLayout().getVisibilityRect().width();
        int height = (int) mMMediaCropLayout.getLayout().getVisibilityRect().height();
        if (!mMMediaCropLayout.xmE) {
            Log.i("MMMediaCropLayout", "[lockCropWindow] width=" + width + " height=" + height);
            mMMediaCropLayout.xmE = true;
            mMMediaCropLayout.getLayout().getLayoutParams().width = width;
            mMMediaCropLayout.getLayout().getLayoutParams().height = height;
            mMMediaCropLayout.getLayout().requestLayout();
        }
        AppMethodBeat.o(164943);
    }

    public final void onDetachedFromWindow() {
        AppMethodBeat.i(164944);
        super.onDetachedFromWindow();
        getVideoView().onUIDestroy();
        AppMethodBeat.o(164944);
    }

    public static /* synthetic */ void b(MMMediaCropLayout mMMediaCropLayout) {
        AppMethodBeat.i(164945);
        CropLayout.e eVar = CropLayout.e.CENTER_INSIDE;
        p.h(eVar, "scaleType");
        Log.i("MMMediaCropLayout", "[reset]");
        mMMediaCropLayout.xmF.clear();
        mMMediaCropLayout.xmE = false;
        mMMediaCropLayout.xmC = eVar;
        mMMediaCropLayout.getLayout().setScaleType(mMMediaCropLayout.xmC);
        b bVar = mMMediaCropLayout.xmF.get(mMMediaCropLayout.xmD);
        if (bVar != null) {
            bVar.gT.reset();
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        mMMediaCropLayout.getLayout().setLayoutParams(layoutParams);
        AppMethodBeat.o(164945);
    }

    public static final class b {
        public Matrix gT = new Matrix();
        public Rect iiw;
        public Rect rwL;
        public Rect viewRect = new Rect();
        private final long xjE;

        public final boolean equals(Object obj) {
            return this == obj || ((obj instanceof b) && this.xjE == ((b) obj).xjE);
        }

        public final int hashCode() {
            long j2 = this.xjE;
            return (int) (j2 ^ (j2 >>> 32));
        }

        public final String toString() {
            AppMethodBeat.i(164926);
            String str = "CropInfo(mediaId=" + this.xjE + ")";
            AppMethodBeat.o(164926);
            return str;
        }

        public b(long j2) {
            AppMethodBeat.i(164925);
            this.xjE = j2;
            AppMethodBeat.o(164925);
        }
    }

    public static final class c {
        public static final a xmI = new a((byte) 0);
        private int vLG = -1;
        private b xmH = new b(0);

        static {
            AppMethodBeat.i(164929);
            AppMethodBeat.o(164929);
        }

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        public c() {
            AppMethodBeat.i(164928);
            AppMethodBeat.o(164928);
        }

        public final void a(b bVar) {
            AppMethodBeat.i(164927);
            p.h(bVar, "<set-?>");
            this.xmH = bVar;
            AppMethodBeat.o(164927);
        }
    }

    static final class d extends q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ MMMediaCropLayout xmJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(MMMediaCropLayout mMMediaCropLayout) {
            super(0);
            this.xmJ = mMMediaCropLayout;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(164930);
            ImageView imageView = new ImageView(this.xmJ.getContext());
            AppMethodBeat.o(164930);
            return imageView;
        }
    }

    static final class g extends q implements kotlin.g.a.a<CommonVideoView> {
        final /* synthetic */ MMMediaCropLayout xmJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(MMMediaCropLayout mMMediaCropLayout) {
            super(0);
            this.xmJ = mMMediaCropLayout;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ CommonVideoView invoke() {
            AppMethodBeat.i(164934);
            CommonVideoView commonVideoView = new CommonVideoView(this.xmJ.getContext());
            AppMethodBeat.o(164934);
            return commonVideoView;
        }
    }

    static final class e extends q implements kotlin.g.a.a<CropLayout> {
        final /* synthetic */ MMMediaCropLayout xmJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(MMMediaCropLayout mMMediaCropLayout) {
            super(0);
            this.xmJ = mMMediaCropLayout;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ CropLayout invoke() {
            AppMethodBeat.i(164931);
            Context context = this.xmJ.getContext();
            p.g(context, "context");
            CropLayout cropLayout = new CropLayout(context);
            AppMethodBeat.o(164931);
            return cropLayout;
        }
    }
}
