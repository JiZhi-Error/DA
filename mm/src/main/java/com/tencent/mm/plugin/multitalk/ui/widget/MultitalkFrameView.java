package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.ae;
import com.tencent.mm.plugin.multitalk.model.f;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.as;
import com.tencent.smtt.sdk.WebView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 \\2\u00020\u00012\u00020\u0002:\u0003\\]^B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u00105\u001a\u000206J\u0006\u00107\u001a\u000206J\u0006\u00108\u001a\u000206J\u0006\u00109\u001a\u000206J\u0018\u0010:\u001a\u0002062\b\u00104\u001a\u0004\u0018\u00010(2\u0006\u0010;\u001a\u00020\u0015J\b\u0010<\u001a\u000206H\u0016J \u0010=\u001a\u0002062\b\u0010>\u001a\u0004\u0018\u00010 2\u0006\u0010?\u001a\u00020\u00152\u0006\u0010@\u001a\u00020\u0015J.\u0010=\u001a\u0002062\u0006\u0010A\u001a\u00020B2\u0006\u0010>\u001a\u00020 2\u0006\u0010?\u001a\u00020\u00152\u0006\u0010@\u001a\u00020\u00152\u0006\u0010C\u001a\u00020\u001bJ(\u0010=\u001a\u0002062\u0006\u0010D\u001a\u00020(2\u0006\u0010E\u001a\u00020 2\u0006\u0010?\u001a\u00020\u00152\u0006\u0010@\u001a\u00020\u0015H\u0016J\u0010\u0010F\u001a\u0002062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010G\u001a\u000206J \u0010H\u001a\u00020\u001b2\b\u0010I\u001a\u0004\u0018\u00010 2\u0006\u0010@\u001a\u00020\u00152\u0006\u0010?\u001a\u00020\u0015J\u0006\u0010J\u001a\u000206J\n\u0010K\u001a\u0004\u0018\u00010\tH\u0016J8\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u00152\u0006\u0010O\u001a\u00020\u00152\u0006\u0010P\u001a\u00020\u00152\u0006\u0010Q\u001a\u00020\u00152\u0006\u0010?\u001a\u00020\u00152\u0006\u0010@\u001a\u00020\u0015H\u0002J\b\u0010R\u001a\u0004\u0018\u00010\u000fJ\b\u0010S\u001a\u0004\u0018\u00010(J\b\u0010T\u001a\u00020(H\u0016J\u0006\u0010U\u001a\u00020\u001bJ\u0006\u0010V\u001a\u00020\u001bJ\u0006\u0010W\u001a\u00020\u001bJ\u0006\u0010X\u001a\u000206J\u0006\u0010Y\u001a\u000206J\b\u0010Z\u001a\u000206H\u0002J\u0006\u0010[\u001a\u000206R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0017\"\u0004\b\u001e\u0010\u0019R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u00020/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0010\u00104\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000¨\u0006_"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView;", "Lcom/tencent/mm/plugin/multitalk/model/IRenderTarget;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "avatarIv", "Landroid/widget/ImageView;", "debugInfo", "Landroid/widget/TextView;", "drawPaint", "Landroid/graphics/Paint;", "elementPrev", "Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView$PrevBitmapDataClass;", "getElementPrev", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView$PrevBitmapDataClass;", "setElementPrev", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView$PrevBitmapDataClass;)V", FirebaseAnalytics.b.INDEX, "", "getIndex", "()I", "setIndex", "(I)V", "mILinkMode", "", "mId", "getMId", "setMId", "mPrevBitmap", "Landroid/graphics/Bitmap;", "mPrevBitmapAngle", "mPrevBitmapMirror", "mRecvFps", "mShowDebugInfo", "mVideoHeight", "mVideoWidth", "nickName", "", "position", "getPosition", "setPosition", "renderView", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "status", "Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView$Status;", "getStatus", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView$Status;", "setStatus", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView$Status;)V", ch.COL_USERNAME, "changeToAvatar", "", "changeToNone", "changeToScreenCast", "changeToVideo", "changeUser", "mid", "drawAvatar", "drawBitmap", "bitmap", "angle", "mirror", "canvas", "Landroid/graphics/Canvas;", "pureDraw", "userName", "bm", "drawBitmapPrev", "drawPrevBitmap", "drawVideo", "img", "finish", "getAvatarIv", "getBitmapMatrix", "Landroid/graphics/Matrix;", "displayWidth", "displayHeight", "bmWidth", "bmHeight", "getCurrentSnapShot", "getNickName", "getUsername", "isAvatarMode", "isScreenCast", "isVideoMode", "refreshDebugInfo", "refreshView", "showVideoInfo", "updateAvatarBitmap", "Companion", "PrevBitmapDataClass", "Status", "plugin-multitalk_release"})
public final class MultitalkFrameView extends FrameLayout implements f {
    public static final a zUV = new a((byte) 0);
    private ImageView gyr;
    private int index;
    private int mId;
    private int mVideoHeight;
    private int mVideoWidth;
    private String nickName;
    private int position;
    private Paint qvj;
    private int qvm;
    public boolean qvn;
    private String username;
    private VoIPRenderTextureView zSZ;
    private TextView zUR;
    private c zUS = c.None;
    private boolean zUT;
    private b zUU;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView$PrevBitmapDataClass;", "", "()V", "currentBitmap", "Landroid/graphics/Bitmap;", "getCurrentBitmap", "()Landroid/graphics/Bitmap;", "setCurrentBitmap", "(Landroid/graphics/Bitmap;)V", "prevAngle", "", "getPrevAngle", "()I", "setPrevAngle", "(I)V", "prevMirror", "getPrevMirror", "setPrevMirror", "plugin-multitalk_release"})
    public static final class b {
        Bitmap zUW;
        int zUX;
        int zUY;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView$Status;", "", "(Ljava/lang/String;I)V", "Avatar", "Video", "ScreenCast", "None", "plugin-multitalk_release"})
    public enum c {
        Avatar,
        Video,
        ScreenCast,
        None;

        static {
            AppMethodBeat.i(239873);
            AppMethodBeat.o(239873);
        }

        public static c valueOf(String str) {
            AppMethodBeat.i(239875);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(239875);
            return cVar;
        }
    }

    static {
        AppMethodBeat.i(239890);
        AppMethodBeat.o(239890);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView$Companion;", "", "()V", "TAG", "", "plugin-multitalk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultitalkFrameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attr");
        AppMethodBeat.i(239889);
        this.qvn = BuildInfo.IS_FLAVOR_RED || WeChatEnvironment.hasDebugger();
        this.mId = -1;
        q eom = ac.eom();
        p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
        this.zUT = eom.ens();
        this.mVideoWidth = getMeasuredWidth();
        this.mVideoHeight = getMeasuredHeight();
        Log.printInfoStack("MicroMsg.MultitalkFrameView", "MultitalkFrameView init " + hashCode(), new Object[0]);
        LayoutInflater.from(context).inflate(R.layout.bcl, this);
        this.zSZ = (VoIPRenderTextureView) getRootView().findViewById(R.id.d9w);
        this.gyr = (ImageView) getRootView().findViewById(R.id.d9s);
        this.zUR = (TextView) getRootView().findViewById(R.id.bl0);
        this.qvj = new Paint();
        Paint paint = this.qvj;
        if (paint != null) {
            paint.setColor(WebView.NIGHT_MODE_COLOR);
        }
        Paint paint2 = this.qvj;
        if (paint2 != null) {
            paint2.setFilterBitmap(false);
        }
        Paint paint3 = this.qvj;
        if (paint3 != null) {
            paint3.setTextSize(40.0f);
        }
        this.zUU = new b();
        AppMethodBeat.o(239889);
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setIndex(int i2) {
        this.index = i2;
    }

    public final int getPosition() {
        return this.position;
    }

    public final void setPosition(int i2) {
        this.position = i2;
    }

    public final c getStatus() {
        return this.zUS;
    }

    public final void setStatus(c cVar) {
        AppMethodBeat.i(239878);
        p.h(cVar, "<set-?>");
        this.zUS = cVar;
        AppMethodBeat.o(239878);
    }

    public final int getMId() {
        return this.mId;
    }

    public final void setMId(int i2) {
        this.mId = i2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ MultitalkFrameView zVe;

        public e(MultitalkFrameView multitalkFrameView) {
            this.zVe = multitalkFrameView;
        }

        public final void run() {
            AppMethodBeat.i(239877);
            Log.i("MicroMsg.MultitalkFrameView", "log location 2");
            MultitalkFrameView.a(this.zVe);
            AppMethodBeat.o(239877);
        }
    }

    public final synchronized void f(Bitmap bitmap, int i2, int i3) {
        Canvas canvas;
        int i4;
        int i5;
        AppMethodBeat.i(239879);
        if (bitmap == null || bitmap.isRecycled()) {
            Log.e("MicroMsg.MultitalkFrameView", "DrawBitmap, bitmap is null or recycled");
            com.tencent.mm.plugin.multitalk.model.p.emX();
            AppMethodBeat.o(239879);
        } else if (this.zSZ == null) {
            AppMethodBeat.o(239879);
        } else {
            VoIPRenderTextureView voIPRenderTextureView = this.zSZ;
            if (voIPRenderTextureView != null) {
                canvas = voIPRenderTextureView.lockCanvas(null);
            } else {
                canvas = null;
            }
            if (canvas == null) {
                Log.e("MicroMsg.MultitalkFrameView", "getCanvasError");
                AppMethodBeat.o(239879);
            } else {
                int width = canvas.getWidth();
                int height = canvas.getHeight();
                int width2 = bitmap.getWidth();
                int height2 = bitmap.getHeight();
                Matrix matrix = new Matrix();
                if (i2 == OpenGlRender.FLAG_Angle270 || i2 == 270) {
                    matrix.postTranslate(((float) (-width2)) / 2.0f, ((float) (-height2)) / 2.0f);
                    matrix.postRotate(270.0f);
                    matrix.postTranslate(((float) height2) / 2.0f, ((float) width2) / 2.0f);
                    i5 = height2;
                    i4 = width2;
                } else if (i2 == OpenGlRender.FLAG_Angle90 || i2 == 90) {
                    matrix.postTranslate(((float) (-width2)) / 2.0f, ((float) (-height2)) / 2.0f);
                    matrix.postRotate(90.0f);
                    matrix.postTranslate(((float) height2) / 2.0f, ((float) width2) / 2.0f);
                    i5 = height2;
                    i4 = width2;
                } else {
                    i5 = width2;
                    i4 = height2;
                }
                if (i3 == OpenGlRender.FLAG_Mirror) {
                    matrix.postScale(-1.0f, 1.0f);
                    matrix.postTranslate((float) i5, 0.0f);
                }
                float f2 = ((float) height) / ((float) width);
                float f3 = ((float) i4) / ((float) i5);
                if (f2 < f3) {
                    float f4 = ((float) height) / ((float) i4);
                    matrix.postScale(f4, f4);
                    matrix.postTranslate((((float) width) - (((float) i5) * f4)) / 2.0f, 0.0f);
                } else if (f2 > f3) {
                    float f5 = ((float) width) / ((float) i5);
                    matrix.postScale(f5, f5);
                    matrix.postTranslate(0.0f, (((float) height) - (f5 * ((float) i4))) / 2.0f);
                } else {
                    matrix.postScale(((float) width) / ((float) i5), ((float) height) / ((float) i4));
                }
                this.mVideoWidth = bitmap.getWidth();
                this.mVideoHeight = bitmap.getHeight();
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                canvas.drawColor(Color.parseColor("#232323"));
                if (!bitmap.isRecycled()) {
                    try {
                        canvas.drawBitmap(bitmap, matrix, this.qvj);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.MultitalkFrameView", "draw bitmap error");
                    }
                }
                try {
                    VoIPRenderTextureView voIPRenderTextureView2 = this.zSZ;
                    if (voIPRenderTextureView2 != null) {
                        voIPRenderTextureView2.unlockCanvasAndPost(canvas);
                    }
                    this.qvm++;
                    AppMethodBeat.o(239879);
                } catch (Exception e3) {
                    Log.printErrStackTrace("MicroMsg.MultitalkFrameView", e3, "drawBitmap unlockCanvasAndPost crash", new Object[0]);
                    AppMethodBeat.o(239879);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        final /* synthetic */ Bitmap hLh;
        final /* synthetic */ int zTq;
        final /* synthetic */ int zTr;
        final /* synthetic */ MultitalkFrameView zVe;

        d(MultitalkFrameView multitalkFrameView, Bitmap bitmap, int i2, int i3) {
            this.zVe = multitalkFrameView;
            this.hLh = bitmap;
            this.zTq = i2;
            this.zTr = i3;
        }

        public final void run() {
            AppMethodBeat.i(239876);
            ImageView imageView = this.zVe.gyr;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            VoIPRenderTextureView voIPRenderTextureView = this.zVe.zSZ;
            if (voIPRenderTextureView != null) {
                voIPRenderTextureView.setVisibility(0);
            }
            this.zVe.f(this.hLh, this.zTq, this.zTr);
            AppMethodBeat.o(239876);
        }
    }

    @Override // com.tencent.mm.plugin.multitalk.model.f
    public final void a(String str, Bitmap bitmap, int i2, int i3) {
        AppMethodBeat.i(239880);
        p.h(str, "userName");
        p.h(bitmap, "bm");
        h.RTc.aV(new d(this, bitmap, i2, i3));
        AppMethodBeat.o(239880);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.f
    public final void emz() {
        AppMethodBeat.i(239881);
        ImageView imageView = this.gyr;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        VoIPRenderTextureView voIPRenderTextureView = this.zSZ;
        if (voIPRenderTextureView != null) {
            voIPRenderTextureView.setVisibility(8);
            AppMethodBeat.o(239881);
            return;
        }
        AppMethodBeat.o(239881);
    }

    @Override // com.tencent.mm.plugin.multitalk.model.f
    public final ImageView getAvatarIv() {
        return this.gyr;
    }

    @Override // com.tencent.mm.plugin.multitalk.model.f
    public final String getUsername() {
        String str = this.username;
        return str == null ? "" : str;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final void eoX() {
        AppMethodBeat.i(239882);
        if (epc()) {
            q eom = ac.eom();
            p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
            eom.enz();
            ae.a(this);
        }
        AppMethodBeat.o(239882);
    }

    public final void eoY() {
        AppMethodBeat.i(239883);
        if (Util.isNullOrNil(getUsername())) {
            AppMethodBeat.o(239883);
            return;
        }
        Log.printInfoStack("MicroMsg.MultitalkFrameView", "changeToAvatar %s from %s", getUsername(), this.zUS.name());
        this.zUS = c.Avatar;
        eoX();
        AppMethodBeat.o(239883);
    }

    public final void eoZ() {
        AppMethodBeat.i(239884);
        Log.printInfoStack("MicroMsg.MultitalkFrameView", "changeToVideo %s from %s", getUsername(), this.zUS.name());
        this.zUS = c.Video;
        a(this.zUU);
        AppMethodBeat.o(239884);
    }

    public final void epa() {
        this.zUS = c.ScreenCast;
        this.zUU.zUW = null;
    }

    public final void epb() {
        AppMethodBeat.i(239885);
        Log.i("MicroMsg.MultitalkFrameView", "changeToNone %s from %s", getUsername(), this.zUS.name());
        this.zUS = c.None;
        eN("", -1);
        AppMethodBeat.o(239885);
    }

    public final void eN(String str, int i2) {
        AppMethodBeat.i(239886);
        Log.i("MicroMsg.MultitalkFrameView", "changeUser from %s to %s", this.username, str);
        this.username = str;
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(str);
        if (Kn != null) {
            this.nickName = Kn.arI();
        } else {
            this.nickName = str;
        }
        this.mId = i2;
        AppMethodBeat.o(239886);
    }

    public final boolean epc() {
        return this.zUS == c.Avatar;
    }

    public final boolean enp() {
        return this.zUS == c.Video;
    }

    public final boolean epd() {
        return this.zUS == c.ScreenCast;
    }

    public final b getElementPrev() {
        return this.zUU;
    }

    public final void setElementPrev(b bVar) {
        AppMethodBeat.i(239887);
        p.h(bVar, "<set-?>");
        this.zUU = bVar;
        AppMethodBeat.o(239887);
    }

    public final b getCurrentSnapShot() {
        return this.zUU;
    }

    public final void a(b bVar) {
        Bitmap bitmap;
        AppMethodBeat.i(239888);
        if (bVar != null) {
            bitmap = bVar.zUW;
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            Bitmap bitmap2 = bVar.zUW;
            if (bitmap2 == null) {
                p.hyc();
            }
            if (!bitmap2.isRecycled()) {
                String str = this.username;
                if (str == null) {
                    str = "";
                }
                Bitmap bitmap3 = bVar.zUW;
                if (bitmap3 == null) {
                    p.hyc();
                }
                a(str, bitmap3, bVar.zUX, bVar.zUY);
            }
        }
        AppMethodBeat.o(239888);
    }

    public static final /* synthetic */ void a(MultitalkFrameView multitalkFrameView) {
        AppMethodBeat.i(239891);
        TextView textView = multitalkFrameView.zUR;
        if (textView != null) {
            textView.setText(n.buv("\n            mid: " + multitalkFrameView.mId + "\n            fps: " + multitalkFrameView.qvm + "\n            size: " + multitalkFrameView.mVideoWidth + 'x' + multitalkFrameView.mVideoHeight + "\n            isILink: " + multitalkFrameView.zUT + "\n            "));
        }
        multitalkFrameView.qvm = 0;
        AppMethodBeat.o(239891);
    }
}
