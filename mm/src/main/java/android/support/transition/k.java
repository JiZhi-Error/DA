package android.support.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* access modifiers changed from: package-private */
public final class k<T> extends Property<T, Float> {
    private final PointF BA = new PointF();
    private float BB;
    private final Property<T, PointF> Bx;
    private final float By;
    private final float[] Bz = new float[2];
    private final PathMeasure xZ;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // android.util.Property
    public final /* synthetic */ void set(Object obj, Float f2) {
        Float f3 = f2;
        this.BB = f3.floatValue();
        this.xZ.getPosTan(this.By * f3.floatValue(), this.Bz, null);
        this.BA.x = this.Bz[0];
        this.BA.y = this.Bz[1];
        this.Bx.set(obj, this.BA);
    }

    k(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.Bx = property;
        this.xZ = new PathMeasure(path, false);
        this.By = this.xZ.getLength();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.util.Property
    public final /* synthetic */ Float get(Object obj) {
        return Float.valueOf(this.BB);
    }
}
