package android.support.design.a;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

public final class f extends Property<ImageView, Matrix> {
    private final Matrix gT = new Matrix();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.util.Property
    public final /* synthetic */ Matrix get(ImageView imageView) {
        this.gT.set(imageView.getImageMatrix());
        return this.gT;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // android.util.Property
    public final /* synthetic */ void set(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }

    public f() {
        super(Matrix.class, "imageMatrixProperty");
    }
}
