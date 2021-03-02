package android.support.design.a;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

public final class g implements TypeEvaluator<Matrix> {
    private final float[] gU = new float[9];
    private final float[] gV = new float[9];
    private final Matrix gW = new Matrix();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
    @Override // android.animation.TypeEvaluator
    public final /* synthetic */ Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.gU);
        matrix2.getValues(this.gV);
        for (int i2 = 0; i2 < 9; i2++) {
            this.gV[i2] = ((this.gV[i2] - this.gU[i2]) * f2) + this.gU[i2];
        }
        this.gW.setValues(this.gV);
        return this.gW;
    }
}
