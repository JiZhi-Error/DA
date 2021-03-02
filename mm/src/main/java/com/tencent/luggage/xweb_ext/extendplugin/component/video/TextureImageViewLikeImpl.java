package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.util.AttributeSet;
import android.view.TextureView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.luggage.xweb_ext.extendplugin.component.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.smtt.sdk.WebView;

public class TextureImageViewLikeImpl extends ConstraintLayout implements h {
    private final FrameLayout cIL;
    private final TextureView cIM;
    private final ImageView cIN;

    public TextureImageViewLikeImpl(Context context) {
        this(context, null);
    }

    public TextureImageViewLikeImpl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextureImageViewLikeImpl(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(215668);
        setId(R.id.q6);
        setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        this.cIL = new FrameLayout(context);
        addView(this.cIL, -1, -1);
        this.cIL.setId(R.id.q5);
        this.cIM = new TextureView(context);
        this.cIL.addView(this.cIM, -1, -1);
        this.cIN = new ImageView(context);
        this.cIL.addView(this.cIN, -1, -1);
        this.cIN.setVisibility(4);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this);
        constraintSet.connect(R.id.q5, 3, R.id.q6, 3, 0);
        constraintSet.connect(R.id.q5, 4, R.id.q6, 4, 0);
        constraintSet.connect(R.id.q5, 1, R.id.q6, 1, 0);
        constraintSet.connect(R.id.q5, 2, R.id.q6, 2, 0);
        constraintSet.applyTo(this);
        AppMethodBeat.o(215668);
    }

    public void setTextureViewWidthWeight(float f2) {
        AppMethodBeat.i(215669);
        Log.i("MicroMsg.AppBrand.TextureImageViewLikeImpl", "setTextureViewWidthWeight, widthWeight: ".concat(String.valueOf(f2)));
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.cIL.getLayoutParams();
        layoutParams.width = 0;
        layoutParams.matchConstraintPercentWidth = f2;
        layoutParams.height = -1;
        this.cIL.setLayoutParams(layoutParams);
        AppMethodBeat.o(215669);
    }

    public void setTextureViewHeightWeight(float f2) {
        AppMethodBeat.i(215670);
        Log.i("MicroMsg.AppBrand.TextureImageViewLikeImpl", "setTextureViewHeightWeight, heightWeight: ".concat(String.valueOf(f2)));
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.cIL.getLayoutParams();
        layoutParams.height = 0;
        layoutParams.matchConstraintPercentHeight = f2;
        layoutParams.width = -1;
        this.cIL.setLayoutParams(layoutParams);
        AppMethodBeat.o(215670);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.h
    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        AppMethodBeat.i(215671);
        this.cIM.setSurfaceTextureListener(surfaceTextureListener);
        AppMethodBeat.o(215671);
    }

    public TextureView.SurfaceTextureListener getSurfaceTextureListener() {
        AppMethodBeat.i(215672);
        TextureView.SurfaceTextureListener surfaceTextureListener = this.cIM.getSurfaceTextureListener();
        AppMethodBeat.o(215672);
        return surfaceTextureListener;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.h
    public Bitmap getBitmap() {
        AppMethodBeat.i(215673);
        Bitmap bitmap = this.cIM.getBitmap();
        AppMethodBeat.o(215673);
        return bitmap;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.h
    public SurfaceTexture getSurfaceTexture() {
        AppMethodBeat.i(215674);
        SurfaceTexture surfaceTexture = this.cIM.getSurfaceTexture();
        AppMethodBeat.o(215674);
        return surfaceTexture;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.h
    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.i(215675);
        if (bitmap != null) {
            this.cIN.setImageBitmap(bitmap);
            this.cIN.setVisibility(0);
            AppMethodBeat.o(215675);
            return;
        }
        this.cIN.setVisibility(4);
        AppMethodBeat.o(215675);
    }
}
