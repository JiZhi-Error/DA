package com.tencent.tencentmap.mapsdk.vector.compat.utils.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxmm.v2helper;
import java.util.concurrent.atomic.AtomicInteger;

public class IconGenerator {
    public static final int SQUARE_TEXT_VIEW_ID = new AtomicInteger(1).get();
    public static final int STYLE_BLUE = 4;
    public static final int STYLE_DEFAULT = 1;
    public static final int STYLE_GREEN = 5;
    public static final int STYLE_ORANGE = 7;
    public static final int STYLE_PURPLE = 6;
    public static final int STYLE_RED = 3;
    public static final int STYLE_WHITE = 2;

    /* renamed from: a  reason: collision with root package name */
    private final Context f2941a;

    /* renamed from: b  reason: collision with root package name */
    private ViewGroup f2942b;

    /* renamed from: c  reason: collision with root package name */
    private RotationLayout f2943c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f2944d;

    /* renamed from: e  reason: collision with root package name */
    private View f2945e;

    /* renamed from: f  reason: collision with root package name */
    private int f2946f;

    /* renamed from: g  reason: collision with root package name */
    private float f2947g = 0.5f;

    /* renamed from: h  reason: collision with root package name */
    private float f2948h = 1.0f;

    static {
        AppMethodBeat.i(199491);
        AppMethodBeat.o(199491);
    }

    public IconGenerator(Context context) {
        AppMethodBeat.i(199477);
        this.f2941a = context;
        this.f2942b = a();
        this.f2943c = (RotationLayout) this.f2942b.getChildAt(0);
        this.f2945e = this.f2944d;
        setStyle(1);
        AppMethodBeat.o(199477);
    }

    private ViewGroup a() {
        AppMethodBeat.i(199478);
        LinearLayout linearLayout = new LinearLayout(this.f2941a);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f2943c = new RotationLayout(this.f2941a);
        this.f2943c.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f2944d = new TextView(this.f2941a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        this.f2944d.setLayoutParams(layoutParams);
        this.f2944d.setPadding(10, 5, 10, 5);
        this.f2944d.setId(SQUARE_TEXT_VIEW_ID);
        this.f2943c.addView(this.f2944d);
        linearLayout.addView(this.f2943c);
        AppMethodBeat.o(199478);
        return linearLayout;
    }

    public Bitmap makeIcon(CharSequence charSequence) {
        AppMethodBeat.i(199479);
        if (this.f2944d != null) {
            this.f2944d.setText(charSequence);
        }
        Bitmap makeIcon = makeIcon();
        AppMethodBeat.o(199479);
        return makeIcon;
    }

    public Bitmap makeIcon() {
        AppMethodBeat.i(199480);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f2942b.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredWidth = this.f2942b.getMeasuredWidth();
        int measuredHeight = this.f2942b.getMeasuredHeight();
        this.f2942b.layout(0, 0, measuredWidth, measuredHeight);
        if (this.f2946f == 1 || this.f2946f == 3) {
            measuredHeight = this.f2942b.getMeasuredWidth();
            measuredWidth = this.f2942b.getMeasuredHeight();
        }
        Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
        createBitmap.eraseColor(0);
        Canvas canvas = new Canvas(createBitmap);
        if (this.f2946f != 0) {
            if (this.f2946f == 1) {
                canvas.translate((float) measuredWidth, 0.0f);
                canvas.rotate(90.0f);
            } else if (this.f2946f == 2) {
                canvas.rotate(180.0f, (float) (measuredWidth / 2), (float) (measuredHeight / 2));
            } else {
                canvas.translate(0.0f, (float) measuredHeight);
                canvas.rotate(270.0f);
            }
        }
        this.f2942b.draw(canvas);
        AppMethodBeat.o(199480);
        return createBitmap;
    }

    public void setContentView(View view) {
        AppMethodBeat.i(199481);
        this.f2943c.removeAllViews();
        this.f2943c.addView(view);
        this.f2945e = view;
        View findViewById = this.f2943c.findViewById(SQUARE_TEXT_VIEW_ID);
        this.f2944d = findViewById instanceof TextView ? (TextView) findViewById : null;
        AppMethodBeat.o(199481);
    }

    public void setContentRotation(int i2) {
        AppMethodBeat.i(199482);
        this.f2943c.setViewRotation(i2);
        AppMethodBeat.o(199482);
    }

    public void setRotation(int i2) {
        this.f2946f = ((i2 + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1) / 90;
    }

    public float getAnchorU() {
        AppMethodBeat.i(199483);
        float a2 = a(this.f2947g, this.f2948h);
        AppMethodBeat.o(199483);
        return a2;
    }

    public float getAnchorV() {
        AppMethodBeat.i(199484);
        float a2 = a(this.f2948h, this.f2947g);
        AppMethodBeat.o(199484);
        return a2;
    }

    private float a(float f2, float f3) {
        AppMethodBeat.i(199485);
        switch (this.f2946f) {
            case 0:
                AppMethodBeat.o(199485);
                return f2;
            case 1:
                float f4 = 1.0f - f3;
                AppMethodBeat.o(199485);
                return f4;
            case 2:
                float f5 = 1.0f - f2;
                AppMethodBeat.o(199485);
                return f5;
            case 3:
                AppMethodBeat.o(199485);
                return f3;
            default:
                IllegalStateException illegalStateException = new IllegalStateException();
                AppMethodBeat.o(199485);
                throw illegalStateException;
        }
    }

    public void setTextAppearance(Context context, int i2) {
        AppMethodBeat.i(199486);
        if (this.f2944d != null) {
            this.f2944d.setTextAppearance(context, i2);
        }
        AppMethodBeat.o(199486);
    }

    public void setTextAppearance(int i2, int i3, float f2, int i4) {
        AppMethodBeat.i(199487);
        setTextAppearance(this.f2941a, i2);
        this.f2944d.setTextColor(i3);
        this.f2944d.setTextSize(f2);
        this.f2944d.setTypeface(this.f2944d.getTypeface(), i4);
        AppMethodBeat.o(199487);
    }

    public void setStyle(int i2) {
        AppMethodBeat.i(199488);
        setTextAppearance(this.f2941a, a(i2));
        if (i2 == 0) {
            setTextAppearance(16973892, -8421505, 14.0f, 0);
            AppMethodBeat.o(199488);
            return;
        }
        if (i2 == 1) {
            setTextAppearance(16973892, -1118482, 14.0f, 0);
        }
        AppMethodBeat.o(199488);
    }

    public void setBackground(Drawable drawable) {
        AppMethodBeat.i(199489);
        this.f2942b.setBackgroundDrawable(drawable);
        if (drawable != null) {
            Rect rect = new Rect();
            drawable.getPadding(rect);
            this.f2942b.setPadding(rect.left, rect.top, rect.right, rect.bottom);
            AppMethodBeat.o(199489);
            return;
        }
        this.f2942b.setPadding(0, 0, 0, 0);
        AppMethodBeat.o(199489);
    }

    public void setContentPadding(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(199490);
        this.f2945e.setPadding(i2, i3, i4, i5);
        AppMethodBeat.o(199490);
    }

    private static int a(int i2) {
        switch (i2) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return 1;
            default:
                return 0;
        }
    }
}
