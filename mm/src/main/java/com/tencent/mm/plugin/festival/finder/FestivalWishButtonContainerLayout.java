package com.tencent.mm.plugin.festival.finder;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.u;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.festival.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.h.a;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u00020*2\u0006\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020*H\u0002J\u0010\u0010=\u001a\u0002082\u0006\u0010>\u001a\u00020?H\u0014J0\u0010@\u001a\u0002082\u0006\u0010A\u001a\u00020*2\u0006\u0010B\u001a\u00020\t2\u0006\u0010C\u001a\u00020\t2\u0006\u0010D\u001a\u00020\t2\u0006\u0010E\u001a\u00020\tH\u0014J\u0010\u0010F\u001a\u0002082\u0006\u0010G\u001a\u00020HH\u0016J\u0012\u0010I\u001a\u0002082\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\u0006\u0010J\u001a\u000208J\u0010\u0010K\u001a\u0002082\u0006\u0010)\u001a\u00020*H\u0016R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'X.¢\u0006\u0002\n\u0000R$\u0010+\u001a\u00020*2\u0006\u0010)\u001a\u00020*@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00100\u001a\u00020*2\u0006\u0010/\u001a\u00020*@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R\u000e\u00102\u001a\u00020(X.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000¨\u0006L"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalWishButtonContainerLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "BACKGROUND_GLOW_RADIUS", "", "BUBBLE_EFFECT_DURATION", "BUBBLE_EFFECT_HEIGHT", "BUBBLE_EFFECT_WIDTH", "BUBBLE_FRAME_COUNT", "BUBBLE_FRAME_INTERVAL", "BUBBLE_STAY_DURATION", "ROTATE_EFFECT_DURATION", "ROTATE_EFFECT_SIZE", "ROTATE_INTERVAL", "TAG", "", "WISH_BUTTON_TOUCH_EXPAND_PADDING", "backgroundGlowDrawRect", "Landroid/graphics/RectF;", "backgroundGlowPaint", "Landroid/graphics/Paint;", "bitmapRect", "Landroid/graphics/Rect;", "bubbleEffectDrawRect", "currentFrameIndex", "currentFrameStartUptimeMillis", "", "currentRotateDegree", "currentRotateStartUptimeMillis", "effectDrawPaint", "frameBitmapList", "", "Landroid/graphics/Bitmap;", "enabled", "", "isEffectEnabled", "()Z", "setEffectEnabled", "(Z)V", "paused", "isEffectPaused", "setEffectPaused", "rotateBitmap", "rotateEffectDrawRect", "wishButton", "Landroid/widget/TextView;", "wishButtonTouchRect", "computeScroll", "", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "ensureEffectMaterialInitialized", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "left", "top", "right", "bottom", "onViewAdded", "child", "Landroid/view/View;", "onViewRemoved", "release", "setEnabled", "plugin-festival_release"})
public final class FestivalWishButtonContainerLayout extends FrameLayout {
    private final String TAG = "MicroMsg.FestivalWishButtonContainerLayout";
    private int Utp;
    private long Utq;
    private final int UwQ;
    private final int UwR;
    private final int UwS;
    private final int UwT;
    private final int UwU;
    private final int UwV;
    private final int UwW;
    private final int UwX;
    private final int UwY;
    private final float UwZ;
    private TextView Uxa;
    private final Rect Uxb;
    private boolean Uxc;
    private boolean Uxd;
    private final Rect Uxe;
    private final Rect Uxf;
    private Paint Uxg;
    List<Bitmap> Uxh;
    private long Uxi;
    private float Uxj;
    Bitmap Uxk;
    private final RectF Uxl;
    private Paint Uxm;
    private final Rect diV;
    private final int ugm;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FestivalWishButtonContainerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(262878);
        Context context2 = getContext();
        p.g(context2, "context");
        this.UwQ = context2.getResources().getDimensionPixelSize(R.dimen.ct);
        this.UwR = 5000;
        this.UwS = a.cR(((float) this.UwR) / 360.0f);
        this.ugm = 500;
        this.UwT = 72;
        this.UwU = 3000;
        this.UwV = a.cR(((float) (this.UwU - this.ugm)) / ((float) this.UwT));
        Context context3 = getContext();
        p.g(context3, "context");
        this.UwW = context3.getResources().getDimensionPixelSize(R.dimen.cl);
        Context context4 = getContext();
        p.g(context4, "context");
        this.UwX = context4.getResources().getDimensionPixelSize(R.dimen.cr);
        Context context5 = getContext();
        p.g(context5, "context");
        this.UwY = context5.getResources().getDimensionPixelSize(R.dimen.c1);
        this.UwZ = 40.0f;
        this.Uxb = new Rect();
        c cVar = c.UxA;
        setEffectEnabled(c.gFi());
        this.Uxc = true;
        this.diV = new Rect();
        this.Uxe = new Rect();
        this.Uxf = new Rect();
        this.Utp = -1;
        this.Utq = -1;
        this.Uxi = -1;
        this.Uxl = new RectF();
        AppMethodBeat.o(262878);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FestivalWishButtonContainerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(262879);
        Context context2 = getContext();
        p.g(context2, "context");
        this.UwQ = context2.getResources().getDimensionPixelSize(R.dimen.ct);
        this.UwR = 5000;
        this.UwS = a.cR(((float) this.UwR) / 360.0f);
        this.ugm = 500;
        this.UwT = 72;
        this.UwU = 3000;
        this.UwV = a.cR(((float) (this.UwU - this.ugm)) / ((float) this.UwT));
        Context context3 = getContext();
        p.g(context3, "context");
        this.UwW = context3.getResources().getDimensionPixelSize(R.dimen.cl);
        Context context4 = getContext();
        p.g(context4, "context");
        this.UwX = context4.getResources().getDimensionPixelSize(R.dimen.cr);
        Context context5 = getContext();
        p.g(context5, "context");
        this.UwY = context5.getResources().getDimensionPixelSize(R.dimen.c1);
        this.UwZ = 40.0f;
        this.Uxb = new Rect();
        c cVar = c.UxA;
        setEffectEnabled(c.gFi());
        this.Uxc = true;
        this.diV = new Rect();
        this.Uxe = new Rect();
        this.Uxf = new Rect();
        this.Utp = -1;
        this.Utq = -1;
        this.Uxi = -1;
        this.Uxl = new RectF();
        AppMethodBeat.o(262879);
    }

    private final void setEffectEnabled(boolean z) {
        AppMethodBeat.i(262868);
        this.Uxc = z;
        setWillNotDraw(!z);
        if (z) {
            setLayerType(1, null);
        }
        AppMethodBeat.o(262868);
    }

    public final void setEffectPaused(boolean z) {
        AppMethodBeat.i(262869);
        if (this.Uxd != z) {
            if (!z && this.Uxc) {
                u.X(this);
            }
            this.Uxd = z;
        }
        AppMethodBeat.o(262869);
    }

    private final boolean gFe() {
        AppMethodBeat.i(262870);
        if (this.Uxh == null) {
            try {
                Context context = getContext();
                p.g(context, "context");
                Bitmap decodeStream = BitmapFactory.decodeStream(context.getAssets().open("festival2021/fest_wish_btn_dynamic_bg/wish_rotate_effect.png"));
                p.g(decodeStream, "BitmapFactory.decodeStre…wish_rotate_effect.png\"))");
                this.Uxk = decodeStream;
                ArrayList arrayList = new ArrayList(this.UwT);
                int i2 = this.UwT;
                for (int i3 = 0; i3 < i2; i3++) {
                    Context context2 = getContext();
                    p.g(context2, "context");
                    AssetManager assets = context2.getAssets();
                    ae aeVar = ae.SYK;
                    Locale locale = Locale.ENGLISH;
                    p.g(locale, "Locale.ENGLISH");
                    String format = String.format(locale, "festival2021/fest_wish_btn_dynamic_bg/wish_particle_@2x_%05d.png", Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
                    p.g(format, "java.lang.String.format(locale, format, *args)");
                    arrayList.add(i3, BitmapFactory.decodeStream(assets.open(format)));
                }
                this.Uxh = arrayList;
                this.Utp = -1;
                this.Utq = -1;
                this.Uxg = new Paint(1);
                Paint paint = new Paint(1);
                paint.setMaskFilter(new BlurMaskFilter(40.0f, BlurMaskFilter.Blur.NORMAL));
                paint.setColor(Color.argb(26, 255, 250, 210));
                paint.setStyle(Paint.Style.FILL);
                this.Uxm = paint;
                AppMethodBeat.o(262870);
                return true;
            } catch (OutOfMemoryError e2) {
                Log.e(this.TAG, "ensureEffectMaterialInitialized get oom");
                AppMethodBeat.o(262870);
                return false;
            }
        } else {
            AppMethodBeat.o(262870);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(262871);
        p.h(canvas, "canvas");
        if (!this.Uxc) {
            AppMethodBeat.o(262871);
            return;
        }
        if (!this.Uxl.isEmpty() && this.Uxm != null) {
            RectF rectF = this.Uxl;
            Paint paint = this.Uxm;
            if (paint == null) {
                p.btv("backgroundGlowPaint");
            }
            canvas.drawOval(rectF, paint);
        }
        if (!this.Uxe.isEmpty() && this.Uxk != null) {
            Bitmap bitmap = this.Uxk;
            if (bitmap == null) {
                p.btv("rotateBitmap");
            }
            if (!bitmap.isRecycled()) {
                Paint paint2 = this.Uxg;
                if (paint2 == null) {
                    p.btv("effectDrawPaint");
                }
                paint2.setStyle(Paint.Style.FILL);
                Rect rect = this.diV;
                Bitmap bitmap2 = this.Uxk;
                if (bitmap2 == null) {
                    p.btv("rotateBitmap");
                }
                int width = bitmap2.getWidth();
                Bitmap bitmap3 = this.Uxk;
                if (bitmap3 == null) {
                    p.btv("rotateBitmap");
                }
                rect.set(0, 0, width, bitmap3.getHeight());
                canvas.save();
                canvas.rotate(this.Uxj, (float) this.Uxe.centerX(), (float) this.Uxe.centerY());
                Bitmap bitmap4 = this.Uxk;
                if (bitmap4 == null) {
                    p.btv("rotateBitmap");
                }
                Rect rect2 = this.diV;
                Rect rect3 = this.Uxe;
                Paint paint3 = this.Uxg;
                if (paint3 == null) {
                    p.btv("effectDrawPaint");
                }
                canvas.drawBitmap(bitmap4, rect2, rect3, paint3);
                canvas.restore();
            }
        }
        if (!this.Uxf.isEmpty() && this.Uxh != null) {
            List<Bitmap> list = this.Uxh;
            if (list == null) {
                p.btv("frameBitmapList");
            }
            int size = list.size();
            int i2 = this.Utp;
            if (i2 < 0) {
                AppMethodBeat.o(262871);
                return;
            } else if (size > i2) {
                List<Bitmap> list2 = this.Uxh;
                if (list2 == null) {
                    p.btv("frameBitmapList");
                }
                Bitmap bitmap5 = list2.get(this.Utp);
                this.diV.set(0, 0, bitmap5.getWidth(), bitmap5.getHeight());
                Paint paint4 = this.Uxg;
                if (paint4 == null) {
                    p.btv("effectDrawPaint");
                }
                paint4.setStyle(Paint.Style.FILL);
                Rect rect4 = this.diV;
                Rect rect5 = this.Uxf;
                Paint paint5 = this.Uxg;
                if (paint5 == null) {
                    p.btv("effectDrawPaint");
                }
                canvas.drawBitmap(bitmap5, rect4, rect5, paint5);
            }
        }
        AppMethodBeat.o(262871);
    }

    public final void computeScroll() {
        AppMethodBeat.i(262872);
        if (!this.Uxc || this.Uxd) {
            AppMethodBeat.o(262872);
        } else if (!gFe()) {
            AppMethodBeat.o(262872);
        } else {
            if (this.Uxi < 0) {
                this.Uxj = 0.0f;
                this.Uxi = AnimationUtils.currentAnimationTimeMillis();
            } else if (AnimationUtils.currentAnimationTimeMillis() - this.Uxi > ((long) this.UwS)) {
                this.Uxj += 1.0f;
                if (this.Uxj >= 360.0f) {
                    this.Uxj = 0.0f;
                }
            }
            if (this.Utp < 0 || this.Utq < 0) {
                this.Utp = 0;
                this.Utq = AnimationUtils.currentAnimationTimeMillis();
            } else if (AnimationUtils.currentAnimationTimeMillis() - this.Utq > ((long) this.UwV)) {
                this.Utq = AnimationUtils.currentAnimationTimeMillis();
                int i2 = this.Utp;
                List<Bitmap> list = this.Uxh;
                if (list == null) {
                    p.btv("frameBitmapList");
                }
                if (i2 >= list.size()) {
                    this.Utp = 0;
                } else {
                    this.Utp++;
                    int i3 = this.Utp;
                    List<Bitmap> list2 = this.Uxh;
                    if (list2 == null) {
                        p.btv("frameBitmapList");
                    }
                    if (i3 >= list2.size()) {
                        this.Utq += (long) this.ugm;
                        this.Utp = this.UwT;
                    }
                }
            }
            u.X(this);
            AppMethodBeat.o(262872);
        }
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(262873);
        super.onLayout(z, i2, i3, i4, i5);
        TextView textView = this.Uxa;
        if (textView != null) {
            this.Uxb.set(Math.max(textView.getLeft() - this.UwQ, 0), Math.max(textView.getTop() - this.UwQ, 0), Math.min(textView.getRight() + this.UwQ, getMeasuredWidth()), Math.min(textView.getBottom() + this.UwQ, getMeasuredHeight()));
            int width = (textView.getWidth() / 2) + textView.getLeft();
            int height = (textView.getHeight() / 2) + textView.getTop();
            float textSize = textView.getTextSize() * 1.1f;
            int cR = a.cR(((float) Math.max(0, a.cR((((float) textView.getMeasuredWidth()) - Layout.getDesiredWidth(textView.getText(), 0, textView.getText().length(), textView.getPaint())) / 2.0f))) + textView.getX() + (textSize / 2.0f));
            int cR2 = a.cR(textView.getY() + (((float) textView.getMeasuredHeight()) / 2.0f));
            this.Uxe.left = cR - (this.UwY / 2);
            this.Uxe.right = this.Uxe.left + this.UwY;
            this.Uxe.top = cR2 - (this.UwY / 2);
            this.Uxe.bottom = this.Uxe.top + this.UwY;
            this.Uxf.left = cR - (this.UwW / 2);
            this.Uxf.right = this.Uxf.left + this.UwW;
            this.Uxf.bottom = a.cR((textSize / 2.0f) + ((float) cR2));
            this.Uxf.top = this.Uxf.bottom - this.UwX;
            float width2 = ((((float) textView.getWidth()) * 1.1f) + this.UwZ) / 2.0f;
            float height2 = ((((float) textView.getHeight()) * 1.6f) + this.UwZ) / 2.0f;
            this.Uxl.set(((float) width) - width2, ((float) height) - height2, ((float) width) + width2, height2 + ((float) height));
            AppMethodBeat.o(262873);
            return;
        }
        AppMethodBeat.o(262873);
    }

    public final void onViewAdded(View view) {
        AppMethodBeat.i(262874);
        p.h(view, "child");
        super.onViewAdded(view);
        if (view.getId() == R.id.jvg) {
            this.Uxa = (TextView) view;
            this.Uxb.setEmpty();
            Rect rect = this.Uxb;
            TextView textView = this.Uxa;
            if (textView == null) {
                p.hyc();
            }
            setTouchDelegate(new TouchDelegate(rect, textView));
        }
        AppMethodBeat.o(262874);
    }

    public final void onViewRemoved(View view) {
        AppMethodBeat.i(262875);
        super.onViewRemoved(view);
        if (p.j(view, this.Uxa)) {
            this.Uxb.setEmpty();
            this.Uxe.setEmpty();
            this.Uxf.setEmpty();
            this.Uxl.setEmpty();
            setTouchDelegate(null);
        }
        AppMethodBeat.o(262875);
    }

    public final void setEnabled(boolean z) {
        boolean z2;
        AppMethodBeat.i(262876);
        super.setEnabled(z);
        if (z) {
            c cVar = c.UxA;
            if (c.gFi()) {
                z2 = true;
                setEffectEnabled(z2);
                AppMethodBeat.o(262876);
            }
        }
        z2 = false;
        setEffectEnabled(z2);
        AppMethodBeat.o(262876);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(262877);
        p.h(motionEvent, "ev");
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (dispatchTouchEvent && this.Uxa != null) {
            switch (motionEvent.getAction()) {
                case 0:
                case 1:
                case 3:
                    TextView textView = this.Uxa;
                    if (textView == null) {
                        p.hyc();
                    }
                    setEffectPaused(textView.isPressed());
                    break;
            }
        }
        AppMethodBeat.o(262877);
        return dispatchTouchEvent;
    }
}
