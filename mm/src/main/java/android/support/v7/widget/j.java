package android.support.v7.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.support.v4.graphics.drawable.f;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* access modifiers changed from: package-private */
public class j {
    private static final int[] afR = {16843067, 16843068};
    private final ProgressBar akL;
    Bitmap akM;

    j(ProgressBar progressBar) {
        this.akL = progressBar;
    }

    /* access modifiers changed from: package-private */
    public void a(AttributeSet attributeSet, int i2) {
        az a2 = az.a(this.akL.getContext(), attributeSet, afR, i2, 0);
        Drawable cU = a2.cU(0);
        if (cU != null) {
            ProgressBar progressBar = this.akL;
            if (cU instanceof AnimationDrawable) {
                AnimationDrawable animationDrawable = (AnimationDrawable) cU;
                int numberOfFrames = animationDrawable.getNumberOfFrames();
                AnimationDrawable animationDrawable2 = new AnimationDrawable();
                animationDrawable2.setOneShot(animationDrawable.isOneShot());
                for (int i3 = 0; i3 < numberOfFrames; i3++) {
                    Drawable b2 = b(animationDrawable.getFrame(i3), true);
                    b2.setLevel(10000);
                    animationDrawable2.addFrame(b2, animationDrawable.getDuration(i3));
                }
                animationDrawable2.setLevel(10000);
                cU = animationDrawable2;
            }
            progressBar.setIndeterminateDrawable(cU);
        }
        Drawable cU2 = a2.cU(1);
        if (cU2 != null) {
            this.akL.setProgressDrawable(b(cU2, false));
        }
        a2.ayy.recycle();
    }

    private Drawable b(Drawable drawable, boolean z) {
        if (drawable instanceof f) {
            Drawable eF = ((f) drawable).eF();
            if (eF == null) {
                return drawable;
            }
            ((f) drawable).l(b(eF, z));
            return drawable;
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                int id = layerDrawable.getId(i2);
                drawableArr[i2] = b(layerDrawable.getDrawable(i2), id == 16908301 || id == 16908303);
            }
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            for (int i3 = 0; i3 < numberOfLayers; i3++) {
                layerDrawable2.setId(i3, layerDrawable.getId(i3));
            }
            return layerDrawable2;
        } else if (!(drawable instanceof BitmapDrawable)) {
            return drawable;
        } else {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.akM == null) {
                this.akM = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            if (z) {
                return new ClipDrawable(shapeDrawable, 3, 1);
            }
            return shapeDrawable;
        }
    }
}
