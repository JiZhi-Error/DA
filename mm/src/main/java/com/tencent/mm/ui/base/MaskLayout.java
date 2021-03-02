package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ae.a;
import com.tencent.mm.sdk.platformtools.Log;

public class MaskLayout extends RelativeLayout {
    private Drawable OUF;
    private ImageView tlu;
    private View view;

    public enum a {
        SUBSCRIPT_DRAWABLE_DIRECTION_TOP_RIGHT,
        SUBSCRIPT_DRAWABLE_DIRECTION_TOP_LEFT,
        SUBSCRIPT_DRAWABLE_DIRECTION_BOTTOM_RIGHT,
        SUBSCRIPT_DRAWABLE_DIRECTION_BOTTOM_LEFT,
        SUBSCRIPT_DRAWABLE_DIRECTION_ALL;

        public static a valueOf(String str) {
            AppMethodBeat.i(142328);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(142328);
            return aVar;
        }

        static {
            AppMethodBeat.i(142329);
            AppMethodBeat.o(142329);
        }
    }

    public MaskLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(142330);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0244a.MaskLayout, i2, 0);
        this.OUF = obtainStyledAttributes.getDrawable(5);
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(142330);
    }

    public void onFinishInflate() {
        AppMethodBeat.i(142331);
        super.onFinishInflate();
        this.view = findViewById(R.id.be9);
        if (this.view == null) {
            Log.d("MicroMsg.MaskLayout", "%s", "not found view by id, new one");
            this.view = new View(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.view.setLayoutParams(layoutParams);
            addView(this.view);
        }
        this.tlu = new ImageView(getContext());
        this.tlu.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.tlu.setImageDrawable(this.OUF);
        addView(this.tlu);
        AppMethodBeat.o(142331);
    }

    public void setMaskBitmap(Bitmap bitmap) {
        AppMethodBeat.i(142332);
        a(a.SUBSCRIPT_DRAWABLE_DIRECTION_ALL);
        this.tlu.setImageBitmap(bitmap);
        AppMethodBeat.o(142332);
    }

    public void setMaskDrawable(Drawable drawable) {
        AppMethodBeat.i(142333);
        a(a.SUBSCRIPT_DRAWABLE_DIRECTION_ALL);
        this.tlu.setImageDrawable(drawable);
        AppMethodBeat.o(142333);
    }

    public final void a(Bitmap bitmap, a aVar) {
        AppMethodBeat.i(142334);
        a(aVar);
        this.tlu.setImageBitmap(bitmap);
        AppMethodBeat.o(142334);
    }

    public View getContentView() {
        return this.view;
    }

    private void a(a aVar) {
        AppMethodBeat.i(142335);
        removeView(this.tlu);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        switch (aVar) {
            case SUBSCRIPT_DRAWABLE_DIRECTION_BOTTOM_RIGHT:
                layoutParams.addRule(12);
                layoutParams.addRule(11);
                break;
            case SUBSCRIPT_DRAWABLE_DIRECTION_BOTTOM_LEFT:
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                break;
            case SUBSCRIPT_DRAWABLE_DIRECTION_TOP_LEFT:
                break;
            case SUBSCRIPT_DRAWABLE_DIRECTION_TOP_RIGHT:
                layoutParams.addRule(11);
                break;
            default:
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                break;
        }
        addView(this.tlu, layoutParams);
        AppMethodBeat.o(142335);
    }
}
