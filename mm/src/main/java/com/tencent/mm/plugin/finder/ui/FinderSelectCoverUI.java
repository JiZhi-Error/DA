package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.LocalVideoCropInfoParcelable;
import com.tencent.mm.plugin.finder.video.o;
import com.tencent.mm.plugin.finder.video.p;
import com.tencent.mm.plugin.finder.widget.post.f;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.protocal.protobuf.bej;
import com.tencent.mm.protocal.protobuf.cjk;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.protocal.protobuf.dlh;
import com.tencent.mm.protocal.protobuf.erf;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.smtt.sdk.WebView;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.ab;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J8\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020!2\u0006\u0010F\u001a\u0002062\u0006\u0010G\u001a\u0002002\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020IH\u0002J8\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020I2\u0006\u0010O\u001a\u00020I2\u0006\u0010P\u001a\u00020I2\u0006\u0010Q\u001a\u00020I2\u0006\u0010R\u001a\u00020I2\u0006\u0010S\u001a\u00020IH\u0002J\b\u0010T\u001a\u00020IH\u0014J\b\u0010U\u001a\u00020DH\u0014J\u0012\u0010V\u001a\u00020D2\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J\b\u0010Y\u001a\u00020DH\u0014J\u0010\u0010Z\u001a\u00020D2\u0006\u0010[\u001a\u00020\\H\u0002J\u0018\u0010]\u001a\u00020D2\u0006\u0010E\u001a\u00020!2\u0006\u0010^\u001a\u000200H\u0002J\u0010\u0010_\u001a\u00020D2\u0006\u0010`\u001a\u00020\u0004H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u000e\u0010\u001d\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 ¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R#\u0010$\u001a\n &*\u0004\u0018\u00010%0%8BX\u0002¢\u0006\f\n\u0004\b)\u0010\b\u001a\u0004\b'\u0010(R\u000e\u0010*\u001a\u00020+X.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u000200X.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010=\u001a\u00020>X.¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006a"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderSelectCoverUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "SEEKBAR_THUMB_HEIGHT", "", "getSEEKBAR_THUMB_HEIGHT", "()F", "SEEKBAR_THUMB_HEIGHT$delegate", "Lkotlin/Lazy;", "SEEKBAR_THUMB_WIDTH", "getSEEKBAR_THUMB_WIDTH", "SEEKBAR_THUMB_WIDTH$delegate", "TAG", "", "conentLayout", "Landroid/view/View;", "coverMarginTop", "cropLayout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "cropWindowView", "firstInitSeekBarProgress", "", "getFirstInitSeekBarProgress", "()Z", "setFirstInitSeekBarProgress", "(Z)V", "firstInitSeekBarThumb", "getFirstInitSeekBarThumb", "setFirstInitSeekBarThumb", "isLongVideo", "longVideoCoverLayout", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMediaList", "()Ljava/util/LinkedList;", "screenPoint", "Landroid/graphics/Point;", "kotlin.jvm.PlatformType", "getScreenPoint", "()Landroid/graphics/Point;", "screenPoint$delegate", "seekBar", "Landroid/widget/SeekBar;", "seeker", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoCoverPreview;", "selectBtn", "thumbBitmap", "Landroid/graphics/Bitmap;", "getThumbBitmap", "()Landroid/graphics/Bitmap;", "setThumbBitmap", "(Landroid/graphics/Bitmap;)V", "thumbCanvas", "Landroid/graphics/Canvas;", "getThumbCanvas", "()Landroid/graphics/Canvas;", "setThumbCanvas", "(Landroid/graphics/Canvas;)V", "thumbFetcher", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "thumbPaint", "Landroid/graphics/Paint;", "getThumbPaint", "()Landroid/graphics/Paint;", "setThumbPaint", "(Landroid/graphics/Paint;)V", "adjustProgressBitmap", "", "media", "canvas", "originBitmap", "i", "", "itemWidth", "itemHeight", "centerCropRect", "Landroid/graphics/Rect;", "left", "top", "right", "bottom", "newWidth", "newHeight", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "packageLongVideoCropInfoToIntent", "intent", "Landroid/content/Intent;", "refreshThumb", "bitmap", "resizeFrameView", "ratio", "plugin-finder_release"})
public final class FinderSelectCoverUI extends MMFinderUI {
    private final String TAG = "Finder.FinderSelectCoverUI";
    private HashMap _$_findViewCache;
    private boolean isLongVideo;
    private final LinkedList<cjl> mediaList = new LinkedList<>();
    private SeekBar oyP;
    private final kotlin.f tFJ = kotlin.g.ah(m.vNJ);
    private p vNg;
    private CropLayout vNh;
    private View vNi;
    private com.tencent.mm.videocomposition.g vNj;
    private Canvas vNk;
    public Bitmap vNl;
    public Paint vNm;
    private final kotlin.f vNn = kotlin.g.ah(new b(this));
    private final kotlin.f vNo = kotlin.g.ah(new a(this));
    private View vNp;
    private View vNq;
    private View vNr;
    private float vNs;
    boolean vNt = true;
    boolean vNu = true;

    private final Point cZM() {
        AppMethodBeat.i(252633);
        Point point = (Point) this.tFJ.getValue();
        AppMethodBeat.o(252633);
        return point;
    }

    private final float dzX() {
        AppMethodBeat.i(252631);
        float floatValue = ((Number) this.vNn.getValue()).floatValue();
        AppMethodBeat.o(252631);
        return floatValue;
    }

    private final float dzY() {
        AppMethodBeat.i(252632);
        float floatValue = ((Number) this.vNo.getValue()).floatValue();
        AppMethodBeat.o(252632);
        return floatValue;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252649);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252649);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252648);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252648);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/graphics/Matrix;", "invoke"})
    public static final class e extends q implements kotlin.g.a.b<Matrix, Boolean> {
        final /* synthetic */ Matrix vNx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(Matrix matrix) {
            super(1);
            this.vNx = matrix;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(Matrix matrix) {
            AppMethodBeat.i(252614);
            Matrix matrix2 = matrix;
            kotlin.g.b.p.h(matrix2, LocaleUtil.ITALIAN);
            matrix2.set(this.vNx);
            Boolean bool = Boolean.TRUE;
            AppMethodBeat.o(252614);
            return bool;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/graphics/Matrix;", "invoke"})
    public static final class f extends q implements kotlin.g.a.b<Matrix, Boolean> {
        public static final f vNy = new f();

        static {
            AppMethodBeat.i(252616);
            AppMethodBeat.o(252616);
        }

        f() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(Matrix matrix) {
            AppMethodBeat.i(252615);
            kotlin.g.b.p.h(matrix, LocaleUtil.ITALIAN);
            Boolean bool = Boolean.TRUE;
            AppMethodBeat.o(252615);
            return bool;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "time", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
    public static final class g extends q implements kotlin.g.a.m<Long, Bitmap, x> {
        final /* synthetic */ Canvas vNA;
        final /* synthetic */ Bitmap vNB;
        final /* synthetic */ FinderSelectCoverUI vNv;
        final /* synthetic */ cjl vNw;
        final /* synthetic */ LinkedList vNz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(FinderSelectCoverUI finderSelectCoverUI, LinkedList linkedList, cjl cjl, Canvas canvas, Bitmap bitmap) {
            super(2);
            this.vNv = finderSelectCoverUI;
            this.vNz = linkedList;
            this.vNw = cjl;
            this.vNA = canvas;
            this.vNB = bitmap;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Long l, Bitmap bitmap) {
            AppMethodBeat.i(252618);
            Bitmap bitmap2 = bitmap;
            int indexOf = this.vNz.indexOf(Long.valueOf(l.longValue()));
            if (indexOf >= 0 && bitmap2 != null) {
                cjl cjl = this.vNw;
                kotlin.g.b.p.g(cjl, "media");
                FinderSelectCoverUI.a(cjl, this.vNA, bitmap2, indexOf, FinderSelectCoverUI.a(this.vNv), (int) FinderSelectCoverUI.b(this.vNv));
                this.vNv.runOnUiThread(new Runnable(this) {
                    /* class com.tencent.mm.plugin.finder.ui.FinderSelectCoverUI.g.AnonymousClass1 */
                    final /* synthetic */ g vNC;

                    {
                        this.vNC = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(252617);
                        FinderSelectCoverUI.c(this.vNC.vNv).setVisibility(0);
                        if (this.vNC.vNv.vNu) {
                            FinderSelectCoverUI.c(this.vNC.vNv).setProgressDrawable(new BitmapDrawable(this.vNC.vNv.getResources(), this.vNC.vNB));
                            this.vNC.vNv.vNu = false;
                            AppMethodBeat.o(252617);
                            return;
                        }
                        Drawable progressDrawable = FinderSelectCoverUI.c(this.vNC.vNv).getProgressDrawable();
                        if (progressDrawable != null) {
                            progressDrawable.invalidateSelf();
                            AppMethodBeat.o(252617);
                            return;
                        }
                        AppMethodBeat.o(252617);
                    }
                });
            }
            x xVar = x.SXb;
            AppMethodBeat.o(252618);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class j extends q implements kotlin.g.a.b<Long, x> {
        final /* synthetic */ FinderSelectCoverUI vNv;
        final /* synthetic */ cjl vNw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(FinderSelectCoverUI finderSelectCoverUI, cjl cjl) {
            super(1);
            this.vNv = finderSelectCoverUI;
            this.vNw = cjl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Long l) {
            AppMethodBeat.i(252626);
            l.longValue();
            y yVar = y.vXH;
            if (y.h(this.vNw)) {
                com.tencent.f.h.RTc.aX(new Runnable(this) {
                    /* class com.tencent.mm.plugin.finder.ui.FinderSelectCoverUI.j.AnonymousClass1 */
                    final /* synthetic */ j vNI;

                    {
                        this.vNI = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(252625);
                        Bitmap bitmap = FinderSelectCoverUI.e(this.vNI.vNv).getBitmap();
                        if (bitmap != null) {
                            FinderSelectCoverUI finderSelectCoverUI = this.vNI.vNv;
                            cjl cjl = this.vNI.vNw;
                            kotlin.g.b.p.g(cjl, "media");
                            FinderSelectCoverUI.a(finderSelectCoverUI, cjl, bitmap);
                            AppMethodBeat.o(252625);
                            return;
                        }
                        AppMethodBeat.o(252625);
                    }
                });
            }
            x xVar = x.SXb;
            AppMethodBeat.o(252626);
            return xVar;
        }
    }

    public FinderSelectCoverUI() {
        AppMethodBeat.i(252638);
        AppMethodBeat.o(252638);
    }

    public static final /* synthetic */ float a(FinderSelectCoverUI finderSelectCoverUI) {
        AppMethodBeat.i(252640);
        float dzX = finderSelectCoverUI.dzX();
        AppMethodBeat.o(252640);
        return dzX;
    }

    public static final /* synthetic */ float b(FinderSelectCoverUI finderSelectCoverUI) {
        AppMethodBeat.i(252641);
        float dzY = finderSelectCoverUI.dzY();
        AppMethodBeat.o(252641);
        return dzY;
    }

    public static final /* synthetic */ SeekBar c(FinderSelectCoverUI finderSelectCoverUI) {
        AppMethodBeat.i(252642);
        SeekBar seekBar = finderSelectCoverUI.oyP;
        if (seekBar == null) {
            kotlin.g.b.p.btv("seekBar");
        }
        AppMethodBeat.o(252642);
        return seekBar;
    }

    public static final /* synthetic */ View d(FinderSelectCoverUI finderSelectCoverUI) {
        AppMethodBeat.i(252643);
        View view = finderSelectCoverUI.vNi;
        if (view == null) {
            kotlin.g.b.p.btv("selectBtn");
        }
        AppMethodBeat.o(252643);
        return view;
    }

    public static final /* synthetic */ p e(FinderSelectCoverUI finderSelectCoverUI) {
        AppMethodBeat.i(252644);
        p pVar = finderSelectCoverUI.vNg;
        if (pVar == null) {
            kotlin.g.b.p.btv("seeker");
        }
        AppMethodBeat.o(252644);
        return pVar;
    }

    public static final /* synthetic */ CropLayout h(FinderSelectCoverUI finderSelectCoverUI) {
        AppMethodBeat.i(252646);
        CropLayout cropLayout = finderSelectCoverUI.vNh;
        if (cropLayout == null) {
            kotlin.g.b.p.btv("cropLayout");
        }
        AppMethodBeat.o(252646);
        return cropLayout;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.ajj;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(252634);
        setTheme(R.style.q6);
        requestWindowFeature(1);
        super.onCreate(bundle);
        Window window = getWindow();
        kotlin.g.b.p.g(window, "window");
        window.setStatusBarColor(WebView.NIGHT_MODE_COLOR);
        updataStatusBarIcon(true);
        setBackBtn(new k(this));
        initView();
        AppMethodBeat.o(252634);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class k implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderSelectCoverUI vNv;

        k(FinderSelectCoverUI finderSelectCoverUI) {
            this.vNv = finderSelectCoverUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(252627);
            this.vNv.finish();
            AppMethodBeat.o(252627);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        int i2;
        int i3;
        int i4;
        int i5;
        erf erf;
        AppMethodBeat.i(252635);
        super.initView();
        this.isLongVideo = getIntent().getBooleanExtra("isLongVideoPost", false);
        findViewById(R.id.hhp).setOnClickListener(new c(this));
        View findViewById = findViewById(R.id.hhs);
        kotlin.g.b.p.g(findViewById, "findViewById(R.id.select_cover_seekbar)");
        this.oyP = (SeekBar) findViewById;
        View findViewById2 = findViewById(R.id.cl1);
        kotlin.g.b.p.g(findViewById2, "findViewById(R.id.finder_crop_layout)");
        this.vNh = (CropLayout) findViewById2;
        View findViewById3 = findViewById(R.id.hhr);
        kotlin.g.b.p.g(findViewById3, "findViewById(R.id.select_cover_ok)");
        this.vNi = findViewById3;
        View findViewById4 = findViewById(R.id.esz);
        kotlin.g.b.p.g(findViewById4, "findViewById<View>(R.id.long_video_cover_layout)");
        this.vNp = findViewById4;
        View findViewById5 = findViewById(R.id.bik);
        kotlin.g.b.p.g(findViewById5, "findViewById<View>(R.id.crop_window_view)");
        this.vNq = findViewById5;
        View findViewById6 = findViewById(R.id.bex);
        kotlin.g.b.p.g(findViewById6, "findViewById<View>(R.id.content_layout)");
        this.vNr = findViewById6;
        cjk cjk = new cjk();
        try {
            cjk.parseFrom(getIntent().getByteArrayExtra("media_list_"));
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
            cjk = null;
        }
        cjk cjk2 = cjk;
        if (cjk2 == null) {
            cjk2 = new cjk();
        }
        this.mediaList.addAll(cjk2.mediaList);
        cjl first = this.mediaList.getFirst();
        z.e eVar = new z.e();
        eVar.SYF = ((long) first.videoDuration) * 1000;
        y yVar = y.vXH;
        if (y.h(first)) {
            kotlin.g.b.p.g(first, "media");
            this.vNg = new com.tencent.mm.plugin.finder.video.f(this, first);
            com.tencent.mm.plugin.sight.base.a aNx = com.tencent.mm.plugin.sight.base.e.aNx(first.url);
            if (aNx != null) {
                eVar.SYF = (long) aNx.videoDuration;
            } else {
                Log.w(this.TAG, "initView: mediaInfo null");
            }
            com.tencent.mm.plugin.gallery.a.c cVar = com.tencent.mm.plugin.gallery.a.c.xsz;
            com.tencent.mm.plugin.sight.base.a awl = com.tencent.mm.plugin.gallery.a.c.awl(first.url);
            i3 = awl.width;
            i2 = awl.height;
            i4 = (int) dzX();
            i5 = (int) dzY();
        } else {
            acn acn = first.MfU;
            if (acn != null) {
                dlh dlh = acn.Gxw.Lnm;
                aty aty = first.MoU;
                if (aty != null) {
                    dlh.Msu.set(0, Integer.valueOf((int) aty.left));
                    dlh.Msu.set(1, Integer.valueOf((int) aty.top));
                    dlh.Msu.set(2, Integer.valueOf((int) aty.right));
                    dlh.Msu.set(3, Integer.valueOf((int) aty.bottom));
                }
                Integer num = dlh.Msu.get(0);
                kotlin.g.b.p.g(num, "originRect.values[0]");
                int intValue = num.intValue();
                Integer num2 = dlh.Msu.get(1);
                kotlin.g.b.p.g(num2, "originRect.values[1]");
                int intValue2 = num2.intValue();
                Integer num3 = dlh.Msu.get(2);
                kotlin.g.b.p.g(num3, "originRect.values[2]");
                int intValue3 = num3.intValue();
                Integer num4 = dlh.Msu.get(3);
                kotlin.g.b.p.g(num4, "originRect.values[3]");
                Rect rect = new Rect(intValue, intValue2, intValue3, num4.intValue());
                eVar.SYF = acn.Lnf - acn.Lne;
                aco aco = acn.Gxw;
                int i6 = aco != null ? aco.targetWidth : 0;
                int height = (rect.height() * i6) / rect.width();
                first.height = (first.width * ((float) rect.height())) / ((float) rect.width());
                x xVar = x.SXb;
                i2 = height;
                i3 = i6;
            } else {
                i2 = 0;
                i3 = 0;
            }
            kotlin.g.b.p.g(first, "media");
            this.vNg = new com.tencent.mm.plugin.finder.video.b(this, first);
            float max = Math.max(dzX() / ((float) i3), dzY() / ((float) i2));
            i4 = (int) (((float) i3) * max);
            i5 = (int) (max * ((float) i2));
        }
        SeekBar seekBar = this.oyP;
        if (seekBar == null) {
            kotlin.g.b.p.btv("seekBar");
        }
        seekBar.setMax(Util.videoMsToSec(eVar.SYF) * 10);
        o oVar = o.wfX;
        this.vNj = o.m(first);
        com.tencent.mm.videocomposition.g gVar = this.vNj;
        if (gVar != null) {
            gVar.setSize(i4, i5);
            x xVar2 = x.SXb;
        }
        float f2 = (1.0f * first.height) / first.width;
        CropLayout cropLayout = this.vNh;
        if (cropLayout == null) {
            kotlin.g.b.p.btv("cropLayout");
        }
        cropLayout.setEnableScale(false);
        CropLayout cropLayout2 = this.vNh;
        if (cropLayout2 == null) {
            kotlin.g.b.p.btv("cropLayout");
        }
        cropLayout2.reset();
        if (this.isLongVideo) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            View view = this.vNr;
            if (view == null) {
                kotlin.g.b.p.btv("conentLayout");
            }
            view.setLayoutParams(layoutParams);
            View view2 = this.vNp;
            if (view2 == null) {
                kotlin.g.b.p.btv("longVideoCoverLayout");
            }
            view2.setVisibility(0);
            CropLayout cropLayout3 = this.vNh;
            if (cropLayout3 == null) {
                kotlin.g.b.p.btv("cropLayout");
            }
            cropLayout3.setEnableTouch(true);
            CropLayout cropLayout4 = this.vNh;
            if (cropLayout4 == null) {
                kotlin.g.b.p.btv("cropLayout");
            }
            cropLayout4.setEnableFling(true);
            CropLayout cropLayout5 = this.vNh;
            if (cropLayout5 == null) {
                kotlin.g.b.p.btv("cropLayout");
            }
            cropLayout5.setEnableOverScroll(false);
            cjx cjx = first.uOR;
            if (!(cjx == null || (erf = cjx.Mpq) == null)) {
                if (erf.left > 0) {
                    CropLayout cropLayout6 = this.vNh;
                    if (cropLayout6 == null) {
                        kotlin.g.b.p.btv("cropLayout");
                    }
                    cropLayout6.setEnableTouch(false);
                    CropLayout cropLayout7 = this.vNh;
                    if (cropLayout7 == null) {
                        kotlin.g.b.p.btv("cropLayout");
                    }
                    cropLayout7.setEnableFling(false);
                }
                int abs = Math.abs(erf.bottom - erf.top);
                this.vNs = ((((float) cZM().y) - ((float) getResources().getDimensionPixelOffset(R.dimen.a5_))) - ((float) abs)) / 2.0f;
                View findViewById7 = findViewById(R.id.bij);
                kotlin.g.b.p.g(findViewById7, "shadowView");
                ViewGroup.LayoutParams layoutParams2 = findViewById7.getLayoutParams();
                layoutParams2.height = (int) this.vNs;
                findViewById7.setLayoutParams(layoutParams2);
                View view3 = this.vNq;
                if (view3 == null) {
                    kotlin.g.b.p.btv("cropWindowView");
                }
                ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                layoutParams3.height = abs;
                View view4 = this.vNq;
                if (view4 == null) {
                    kotlin.g.b.p.btv("cropWindowView");
                }
                view4.setLayoutParams(layoutParams3);
                CropLayout cropLayout8 = this.vNh;
                if (cropLayout8 == null) {
                    kotlin.g.b.p.btv("cropLayout");
                }
                cropLayout8.getVisibilityRect().set(new RectF((float) erf.left, this.vNs, (float) erf.right, ((float) abs) + this.vNs));
                x xVar3 = x.SXb;
            }
        } else {
            CropLayout cropLayout9 = this.vNh;
            if (cropLayout9 == null) {
                kotlin.g.b.p.btv("cropLayout");
            }
            ViewGroup.LayoutParams layoutParams4 = cropLayout9.getLayoutParams();
            layoutParams4.width = cZM().x;
            layoutParams4.height = (int) (f2 * ((float) layoutParams4.width));
            CropLayout cropLayout10 = this.vNh;
            if (cropLayout10 == null) {
                kotlin.g.b.p.btv("cropLayout");
            }
            cropLayout10.setLayoutParams(layoutParams4);
            CropLayout cropLayout11 = this.vNh;
            if (cropLayout11 == null) {
                kotlin.g.b.p.btv("cropLayout");
            }
            cropLayout11.setEnableTouch(false);
            CropLayout cropLayout12 = this.vNh;
            if (cropLayout12 == null) {
                kotlin.g.b.p.btv("cropLayout");
            }
            cropLayout12.setEnableFling(false);
            CropLayout cropLayout13 = this.vNh;
            if (cropLayout13 == null) {
                kotlin.g.b.p.btv("cropLayout");
            }
            cropLayout13.setEnableOverScroll(false);
        }
        cjx cjx2 = first.uOR;
        if ((cjx2 != null ? cjx2.Mpr : null) != null) {
            cjx cjx3 = first.uOR;
            bej bej = cjx3 != null ? cjx3.Mpr : null;
            if (bej != null && bej.LOe.size() == 9) {
                Matrix matrix = new Matrix();
                LinkedList<Float> linkedList = bej.LOe;
                kotlin.g.b.p.g(linkedList, "it.value");
                matrix.setValues(kotlin.a.j.t((Collection<Float>) linkedList));
                Matrix matrix2 = new Matrix(matrix);
                if (this.isLongVideo) {
                    matrix2.postTranslate(0.0f, this.vNs);
                }
                CropLayout cropLayout14 = this.vNh;
                if (cropLayout14 == null) {
                    kotlin.g.b.p.btv("cropLayout");
                }
                p pVar = this.vNg;
                if (pVar == null) {
                    kotlin.g.b.p.btv("seeker");
                }
                cropLayout14.a(pVar.getView(), i3, i2, new Matrix(), CropLayout.e.CENTER_CROP, new e(matrix2));
            }
        } else {
            CropLayout cropLayout15 = this.vNh;
            if (cropLayout15 == null) {
                kotlin.g.b.p.btv("cropLayout");
            }
            p pVar2 = this.vNg;
            if (pVar2 == null) {
                kotlin.g.b.p.btv("seeker");
            }
            cropLayout15.a(pVar2.getView(), i3, i2, new Matrix(), CropLayout.e.CENTER_CROP, f.vNy);
        }
        SeekBar seekBar2 = this.oyP;
        if (seekBar2 == null) {
            kotlin.g.b.p.btv("seekBar");
        }
        seekBar2.setVisibility(4);
        SeekBar seekBar3 = this.oyP;
        if (seekBar3 == null) {
            kotlin.g.b.p.btv("seekBar");
        }
        seekBar3.setEnabled(false);
        View view5 = this.vNi;
        if (view5 == null) {
            kotlin.g.b.p.btv("selectBtn");
        }
        view5.setEnabled(false);
        int i7 = cZM().x;
        AppCompatActivity context = getContext();
        kotlin.g.b.p.g(context, "context");
        int dimension = i7 - ((int) context.getResources().getDimension(R.dimen.ci));
        int ceil = (int) Math.ceil(((double) dimension) / ((double) dzX()));
        if (ceil < 2) {
            ceil = 2;
        }
        long j2 = eVar.SYF / ((long) (ceil - 1));
        LinkedList linkedList2 = new LinkedList();
        Iterator it = kotlin.k.j.mY(0, ceil).iterator();
        while (it.hasNext()) {
            linkedList2.add(Long.valueOf(((long) ((ab) it).nextInt()) * j2));
        }
        LinkedList linkedList3 = linkedList2;
        Bitmap createBitmap = Bitmap.createBitmap(dimension, (int) dzY(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        com.tencent.mm.videocomposition.g gVar2 = this.vNj;
        if (gVar2 != null) {
            gVar2.b(linkedList3, new g(this, linkedList3, first, canvas, createBitmap));
            x xVar4 = x.SXb;
        }
        p pVar3 = this.vNg;
        if (pVar3 == null) {
            kotlin.g.b.p.btv("seeker");
        }
        pVar3.a(new h(this, eVar, first), new i(this), new j(this, first));
        View view6 = this.vNi;
        if (view6 == null) {
            kotlin.g.b.p.btv("selectBtn");
        }
        view6.setOnClickListener(new d(this, first));
        AppMethodBeat.o(252635);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ FinderSelectCoverUI vNv;

        c(FinderSelectCoverUI finderSelectCoverUI) {
            this.vNv = finderSelectCoverUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(252612);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelectCoverUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.vNv.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelectCoverUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(252612);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ FinderSelectCoverUI vNv;
        final /* synthetic */ cjl vNw;

        d(FinderSelectCoverUI finderSelectCoverUI, cjl cjl) {
            this.vNv = finderSelectCoverUI;
            this.vNw = cjl;
        }

        public final void onClick(View view) {
            int i2;
            AppMethodBeat.i(252613);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelectCoverUI$initView$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (FinderSelectCoverUI.d(this.vNv).isEnabled()) {
                com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                int i3 = com.tencent.mm.plugin.finder.storage.c.dqx().iTf;
                int i4 = (int) ((((float) i3) / this.vNw.width) * this.vNw.height);
                Log.i(this.vNv.TAG, "save cover, size: " + i3 + ", " + i4);
                Bitmap createBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                Bitmap bitmap = FinderSelectCoverUI.e(this.vNv).getBitmap();
                if (bitmap == null) {
                    this.vNv.finish();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelectCoverUI$initView$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(252613);
                    return;
                }
                if (this.vNw.MoO) {
                    cjx cjx = this.vNw.uOR;
                    float f2 = FinderSelectCoverUI.h(this.vNv).getContentViewScale()[0];
                    float f3 = -(FinderSelectCoverUI.h(this.vNv).getContentViewTrans()[1] - this.vNv.vNs);
                    erf erf = new erf();
                    erf erf2 = cjx != null ? cjx.Mps : null;
                    if (erf2 != null) {
                        erf.left = erf2.left;
                        erf.right = erf2.right;
                        erf.top = (int) (((float) (erf2.top - erf2.bottom)) + (f3 / f2));
                        erf.bottom = (int) (f3 / f2);
                    } else {
                        erf.left = 0;
                        erf.right = 0;
                        erf.top = 0;
                        erf.bottom = 0;
                    }
                    canvas.drawBitmap(bitmap, new Rect(erf.left, erf.bottom, erf.right, erf.top), new Rect(0, 0, i3, i4), (Paint) null);
                } else {
                    canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(0, 0, i3, i4), (Paint) null);
                }
                StringBuilder sb = new StringBuilder();
                al alVar = al.waC;
                String sb2 = sb.append(al.dEH()).append("cover_").append(System.currentTimeMillis()).toString();
                com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                boolean saveBitmapToImage = BitmapUtil.saveBitmapToImage(createBitmap, com.tencent.mm.plugin.finder.storage.c.dqY(), Bitmap.CompressFormat.JPEG, sb2, false);
                com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (com.tencent.mm.plugin.finder.storage.c.dtU()) {
                    com.tencent.mm.plugin.finder.storage.c cVar4 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    int dqC = com.tencent.mm.plugin.finder.storage.c.dqC();
                    com.tencent.mm.plugin.finder.storage.c cVar5 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    i2 = AdaptiveAdjustBitrate.getVideoImageQuality(dqC, 0, i3, i4, ((float) com.tencent.mm.plugin.finder.storage.c.dqY()) / 100.0f);
                } else {
                    i2 = 0;
                }
                Intent intent = new Intent();
                if (saveBitmapToImage) {
                    f.a aVar = com.tencent.mm.plugin.finder.widget.post.f.wDt;
                    intent.putExtra(com.tencent.mm.plugin.finder.widget.post.f.wDq, sb2);
                    f.a aVar2 = com.tencent.mm.plugin.finder.widget.post.f.wDt;
                    intent.putExtra(com.tencent.mm.plugin.finder.widget.post.f.wDr, i2);
                    FinderSelectCoverUI.a(this.vNv, intent);
                }
                this.vNv.setResult(0, intent);
                this.vNv.finish();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelectCoverUI$initView$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(252613);
        }
    }

    private static Rect b(int i2, int i3, int i4, int i5, int i6, int i7) {
        float f2;
        float f3;
        float f4;
        int i8 = 0;
        AppMethodBeat.i(252636);
        int abs = Math.abs(i4 - i2);
        int abs2 = Math.abs(i5 - i3);
        if (abs * i7 > i6 * abs2) {
            f2 = ((float) i7) / ((float) abs2);
            f4 = ((((float) abs) * f2) - ((float) i6)) * 0.5f;
            f3 = 0.0f;
        } else {
            f2 = ((float) i6) / ((float) abs);
            f3 = ((((float) abs2) * f2) - ((float) i7)) * 0.5f;
            f4 = 0.0f;
        }
        int i9 = (int) (f4 / f2);
        int i10 = (int) (f3 / f2);
        if (i9 < 0) {
            i9 = 0;
        }
        if (i10 >= 0) {
            i8 = i10;
        }
        Rect rect = new Rect(i2 + i9, i3 + i8, i4 - i9, i5 - i8);
        AppMethodBeat.o(252636);
        return rect;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class l implements Runnable {
        final /* synthetic */ FinderSelectCoverUI vNv;

        l(FinderSelectCoverUI finderSelectCoverUI) {
            this.vNv = finderSelectCoverUI;
        }

        public final void run() {
            AppMethodBeat.i(252628);
            if (this.vNv.vNt) {
                SeekBar c2 = FinderSelectCoverUI.c(this.vNv);
                Resources resources = this.vNv.getResources();
                Bitmap bitmap = this.vNv.vNl;
                if (bitmap == null) {
                    kotlin.g.b.p.btv("thumbBitmap");
                }
                c2.setThumb(new BitmapDrawable(resources, bitmap));
                FinderSelectCoverUI.c(this.vNv).setThumbOffset(0);
                this.vNv.vNt = false;
                AppMethodBeat.o(252628);
                return;
            }
            Drawable thumb = FinderSelectCoverUI.c(this.vNv).getThumb();
            if (thumb != null) {
                thumb.invalidateSelf();
                AppMethodBeat.o(252628);
                return;
            }
            AppMethodBeat.o(252628);
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(252637);
        super.onDestroy();
        p pVar = this.vNg;
        if (pVar == null) {
            kotlin.g.b.p.btv("seeker");
        }
        pVar.destroy();
        com.tencent.mm.videocomposition.g gVar = this.vNj;
        if (gVar != null) {
            gVar.destroy();
            AppMethodBeat.o(252637);
            return;
        }
        AppMethodBeat.o(252637);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<Float> {
        final /* synthetic */ FinderSelectCoverUI vNv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderSelectCoverUI finderSelectCoverUI) {
            super(0);
            this.vNv = finderSelectCoverUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Float invoke() {
            AppMethodBeat.i(252611);
            AppCompatActivity context = this.vNv.getContext();
            kotlin.g.b.p.g(context, "context");
            Float valueOf = Float.valueOf(context.getResources().getDimension(R.dimen.cl));
            AppMethodBeat.o(252611);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<Float> {
        final /* synthetic */ FinderSelectCoverUI vNv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(FinderSelectCoverUI finderSelectCoverUI) {
            super(0);
            this.vNv = finderSelectCoverUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Float invoke() {
            AppMethodBeat.i(252610);
            AppCompatActivity context = this.vNv.getContext();
            kotlin.g.b.p.g(context, "context");
            Float valueOf = Float.valueOf(context.getResources().getDimension(R.dimen.cr));
            AppMethodBeat.o(252610);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/graphics/Point;", "kotlin.jvm.PlatformType", "invoke"})
    static final class m extends q implements kotlin.g.a.a<Point> {
        public static final m vNJ = new m();

        static {
            AppMethodBeat.i(252630);
            AppMethodBeat.o(252630);
        }

        m() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Point invoke() {
            AppMethodBeat.i(252629);
            Point az = au.az(MMApplicationContext.getContext());
            AppMethodBeat.o(252629);
            return az;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ z.e vND;
        final /* synthetic */ FinderSelectCoverUI vNv;
        final /* synthetic */ cjl vNw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(FinderSelectCoverUI finderSelectCoverUI, z.e eVar, cjl cjl) {
            super(0);
            this.vNv = finderSelectCoverUI;
            this.vND = eVar;
            this.vNw = cjl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            com.tencent.mm.videocomposition.g gVar;
            AppMethodBeat.i(252623);
            FinderSelectCoverUI.c(this.vNv).setEnabled(true);
            FinderSelectCoverUI.d(this.vNv).setEnabled(true);
            FinderSelectCoverUI.c(this.vNv).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(this) {
                /* class com.tencent.mm.plugin.finder.ui.FinderSelectCoverUI.h.AnonymousClass1 */
                private final kotlin.g.a.m<Long, Bitmap, x> vNE = new a(this);
                private long vNF = -1;
                final /* synthetic */ h vNG;

                @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "time", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
                /* renamed from: com.tencent.mm.plugin.finder.ui.FinderSelectCoverUI$h$1$a */
                static final class a extends q implements kotlin.g.a.m<Long, Bitmap, x> {
                    final /* synthetic */ AnonymousClass1 vNH;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    a(AnonymousClass1 r2) {
                        super(2);
                        this.vNH = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                    @Override // kotlin.g.a.m
                    public final /* synthetic */ x invoke(Long l, Bitmap bitmap) {
                        AppMethodBeat.i(252619);
                        l.longValue();
                        Bitmap bitmap2 = bitmap;
                        if (bitmap2 != null) {
                            FinderSelectCoverUI finderSelectCoverUI = this.vNH.vNG.vNv;
                            cjl cjl = this.vNH.vNG.vNw;
                            kotlin.g.b.p.g(cjl, "media");
                            FinderSelectCoverUI.a(finderSelectCoverUI, cjl, bitmap2);
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(252619);
                        return xVar;
                    }
                }

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.vNG = r4;
                    AppMethodBeat.i(252621);
                    AppMethodBeat.o(252621);
                }

                public final void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                    AppMethodBeat.i(252620);
                    long max = (long) ((((double) i2) / ((double) FinderSelectCoverUI.c(this.vNG.vNv).getMax())) * ((double) this.vNG.vND.SYF));
                    FinderSelectCoverUI.e(this.vNG.vNv).seekTo(max);
                    y yVar = y.vXH;
                    if (!y.h(this.vNG.vNw)) {
                        com.tencent.mm.videocomposition.g gVar = this.vNG.vNv.vNj;
                        if (gVar != null) {
                            gVar.cancel(this.vNF);
                        }
                        com.tencent.mm.videocomposition.g gVar2 = this.vNG.vNv.vNj;
                        if (gVar2 != null) {
                            gVar2.b(kotlin.a.j.listOf(Long.valueOf(max)), this.vNE);
                        }
                        this.vNF = max;
                    }
                    AppMethodBeat.o(252620);
                }

                public final void onStartTrackingTouch(SeekBar seekBar) {
                }

                public final void onStopTrackingTouch(SeekBar seekBar) {
                }
            });
            FinderSelectCoverUI.e(this.vNv).seekTo(0);
            y yVar = y.vXH;
            if (!y.h(this.vNw) && (gVar = this.vNv.vNj) != null) {
                gVar.b(kotlin.a.j.listOf((Object) 0L), new kotlin.g.a.m<Long, Bitmap, x>(this) {
                    /* class com.tencent.mm.plugin.finder.ui.FinderSelectCoverUI.h.AnonymousClass2 */
                    final /* synthetic */ h vNG;

                    {
                        this.vNG = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                    @Override // kotlin.g.a.m
                    public final /* synthetic */ x invoke(Long l, Bitmap bitmap) {
                        AppMethodBeat.i(252622);
                        l.longValue();
                        Bitmap bitmap2 = bitmap;
                        if (bitmap2 != null) {
                            FinderSelectCoverUI finderSelectCoverUI = this.vNG.vNv;
                            cjl cjl = this.vNG.vNw;
                            kotlin.g.b.p.g(cjl, "media");
                            FinderSelectCoverUI.a(finderSelectCoverUI, cjl, bitmap2);
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(252622);
                        return xVar;
                    }
                });
            }
            x xVar = x.SXb;
            AppMethodBeat.o(252623);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class i extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderSelectCoverUI vNv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(FinderSelectCoverUI finderSelectCoverUI) {
            super(0);
            this.vNv = finderSelectCoverUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(252624);
            FinderSelectCoverUI.c(this.vNv).setEnabled(false);
            x xVar = x.SXb;
            AppMethodBeat.o(252624);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(cjl cjl, Canvas canvas, Bitmap bitmap, int i2, float f2, int i3) {
        int i4;
        erf erf;
        erf erf2;
        erf erf3;
        erf erf4;
        AppMethodBeat.i(252639);
        if (cjl.MoO) {
            cjx cjx = cjl.uOR;
            if (cjx == null || (erf4 = cjx.Mps) == null) {
                i4 = 0;
            } else {
                i4 = erf4.left;
            }
            canvas.drawBitmap(bitmap, b(i4, (cjx == null || (erf3 = cjx.Mps) == null) ? 0 : erf3.bottom, (cjx == null || (erf2 = cjx.Mps) == null) ? 0 : erf2.right, (cjx == null || (erf = cjx.Mps) == null) ? 0 : erf.top, (int) f2, i3), new Rect((int) (((float) i2) * f2), 0, (int) (((float) (i2 + 1)) * f2), i3), (Paint) null);
            AppMethodBeat.o(252639);
            return;
        }
        canvas.drawBitmap(BitmapUtil.getCenterCropBitmap(bitmap, (int) f2, i3, false), ((float) i2) * f2, 0.0f, (Paint) null);
        AppMethodBeat.o(252639);
    }

    public static final /* synthetic */ void a(FinderSelectCoverUI finderSelectCoverUI, cjl cjl, Bitmap bitmap) {
        erf erf;
        erf erf2;
        erf erf3;
        erf erf4;
        AppMethodBeat.i(252645);
        if (finderSelectCoverUI.vNk == null) {
            Bitmap createBitmap = Bitmap.createBitmap((int) finderSelectCoverUI.dzX(), (int) finderSelectCoverUI.dzY(), Bitmap.Config.ARGB_8888);
            kotlin.g.b.p.g(createBitmap, "Bitmap.createBitmap(SEEK… Bitmap.Config.ARGB_8888)");
            finderSelectCoverUI.vNl = createBitmap;
            Bitmap bitmap2 = finderSelectCoverUI.vNl;
            if (bitmap2 == null) {
                kotlin.g.b.p.btv("thumbBitmap");
            }
            finderSelectCoverUI.vNk = new Canvas(bitmap2);
            finderSelectCoverUI.vNm = new Paint(1);
            Paint paint = finderSelectCoverUI.vNm;
            if (paint == null) {
                kotlin.g.b.p.btv("thumbPaint");
            }
            paint.setColor(finderSelectCoverUI.getResources().getColor(R.color.Orange_100));
            Paint paint2 = finderSelectCoverUI.vNm;
            if (paint2 == null) {
                kotlin.g.b.p.btv("thumbPaint");
            }
            paint2.setStyle(Paint.Style.STROKE);
            Paint paint3 = finderSelectCoverUI.vNm;
            if (paint3 == null) {
                kotlin.g.b.p.btv("thumbPaint");
            }
            paint3.setStrokeWidth((float) com.tencent.mm.cb.a.fromDPToPix((Context) finderSelectCoverUI.getContext(), 2));
        }
        Canvas canvas = finderSelectCoverUI.vNk;
        if (canvas != null) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            if (!cjl.MoO || finderSelectCoverUI.isLongVideo) {
                canvas.drawBitmap(bitmap, b(0, 0, bitmap.getWidth(), bitmap.getHeight(), (int) finderSelectCoverUI.dzX(), (int) finderSelectCoverUI.dzY()), new Rect(0, 0, (int) finderSelectCoverUI.dzX(), (int) finderSelectCoverUI.dzY()), (Paint) null);
            } else {
                cjx cjx = cjl.uOR;
                canvas.drawBitmap(bitmap, b((cjx == null || (erf4 = cjx.Mps) == null) ? 0 : erf4.left, (cjx == null || (erf3 = cjx.Mps) == null) ? 0 : erf3.bottom, (cjx == null || (erf2 = cjx.Mps) == null) ? 0 : erf2.right, (cjx == null || (erf = cjx.Mps) == null) ? 0 : erf.top, (int) finderSelectCoverUI.dzX(), (int) finderSelectCoverUI.dzY()), new Rect(0, 0, (int) finderSelectCoverUI.dzX(), (int) finderSelectCoverUI.dzY()), (Paint) null);
            }
            float fromDPToPix = (float) com.tencent.mm.cb.a.fromDPToPix((Context) finderSelectCoverUI.getContext(), 2);
            RectF rectF = new RectF(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
            float f2 = 2.0f * fromDPToPix;
            float f3 = fromDPToPix * 2.0f;
            Paint paint4 = finderSelectCoverUI.vNm;
            if (paint4 == null) {
                kotlin.g.b.p.btv("thumbPaint");
            }
            canvas.drawRoundRect(rectF, f2, f3, paint4);
        }
        finderSelectCoverUI.runOnUiThread(new l(finderSelectCoverUI));
        AppMethodBeat.o(252645);
    }

    public static final /* synthetic */ void a(FinderSelectCoverUI finderSelectCoverUI, Intent intent) {
        AppMethodBeat.i(252647);
        if (finderSelectCoverUI.isLongVideo) {
            cjl first = finderSelectCoverUI.mediaList.getFirst();
            cjx cjx = new cjx();
            cjx cjx2 = first.uOR;
            if (cjx2 == null) {
                AppMethodBeat.o(252647);
                return;
            }
            kotlin.g.b.p.g(cjx2, "media.cropInfo ?: return");
            CropLayout cropLayout = finderSelectCoverUI.vNh;
            if (cropLayout == null) {
                kotlin.g.b.p.btv("cropLayout");
            }
            float f2 = cropLayout.getContentViewScale()[0];
            CropLayout cropLayout2 = finderSelectCoverUI.vNh;
            if (cropLayout2 == null) {
                kotlin.g.b.p.btv("cropLayout");
            }
            float f3 = -(cropLayout2.getContentViewTrans()[1] - finderSelectCoverUI.vNs);
            erf erf = new erf();
            erf erf2 = cjx2.Mps;
            if (erf2 == null) {
                kotlin.g.b.p.hyc();
            }
            erf.left = erf2.left;
            erf erf3 = cjx2.Mps;
            if (erf3 == null) {
                kotlin.g.b.p.hyc();
            }
            erf.right = erf3.right;
            erf erf4 = cjx2.Mps;
            if (erf4 == null) {
                kotlin.g.b.p.hyc();
            }
            int i2 = erf4.top;
            erf erf5 = cjx2.Mps;
            if (erf5 == null) {
                kotlin.g.b.p.hyc();
            }
            erf.top = (int) (((float) (i2 - erf5.bottom)) + (f3 / f2));
            erf.bottom = (int) (f3 / f2);
            cjx.Mps = erf;
            cjx cjx3 = first.uOR;
            if (cjx3 == null) {
                kotlin.g.b.p.hyc();
            }
            erf erf6 = cjx3.Mpq;
            erf erf7 = new erf();
            if (erf6 == null) {
                kotlin.g.b.p.hyc();
            }
            erf7.left = erf6.left;
            erf7.bottom = (int) f3;
            erf7.top = erf7.bottom + Math.abs(erf6.bottom - erf6.top);
            erf7.right = erf6.right;
            cjx.Mpq = erf7;
            CropLayout cropLayout3 = finderSelectCoverUI.vNh;
            if (cropLayout3 == null) {
                kotlin.g.b.p.btv("cropLayout");
            }
            Matrix matrix = new Matrix(cropLayout3.getMainMatrix());
            matrix.postTranslate(0.0f, -finderSelectCoverUI.vNs);
            float[] fArr = new float[9];
            matrix.getValues(fArr);
            bej bej = new bej();
            bej.LOe.addAll(kotlin.a.e.s(fArr));
            cjx.Mpr = bej;
            f.a aVar = com.tencent.mm.plugin.finder.widget.post.f.wDt;
            String str = com.tencent.mm.plugin.finder.widget.post.f.wDs;
            LocalVideoCropInfoParcelable localVideoCropInfoParcelable = new LocalVideoCropInfoParcelable();
            localVideoCropInfoParcelable.uOR = cjx;
            intent.putExtra(str, localVideoCropInfoParcelable);
        }
        AppMethodBeat.o(252647);
    }
}
