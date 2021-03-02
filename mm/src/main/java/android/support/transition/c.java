package android.support.transition;

import android.animation.TypeEvaluator;

final class c implements TypeEvaluator<float[]> {
    private float[] AV;

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
    @Override // android.animation.TypeEvaluator
    public final /* bridge */ /* synthetic */ float[] evaluate(float f2, float[] fArr, float[] fArr2) {
        float[] fArr3 = fArr;
        float[] fArr4 = fArr2;
        float[] fArr5 = this.AV;
        if (fArr5 == null) {
            fArr5 = new float[fArr3.length];
        }
        for (int i2 = 0; i2 < fArr5.length; i2++) {
            float f3 = fArr3[i2];
            fArr5[i2] = f3 + ((fArr4[i2] - f3) * f2);
        }
        return fArr5;
    }

    c(float[] fArr) {
        this.AV = fArr;
    }
}
