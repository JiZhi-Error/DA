package android.support.design.a;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import java.util.WeakHashMap;

public final class e extends Property<Drawable, Integer> {
    public static final Property<Drawable, Integer> gR = new e();
    private final WeakHashMap<Drawable, Integer> gS = new WeakHashMap<>();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.util.Property
    public final /* synthetic */ Integer get(Drawable drawable) {
        Drawable drawable2 = drawable;
        if (Build.VERSION.SDK_INT >= 19) {
            return Integer.valueOf(drawable2.getAlpha());
        }
        if (this.gS.containsKey(drawable2)) {
            return this.gS.get(drawable2);
        }
        return 255;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // android.util.Property
    public final /* synthetic */ void set(Drawable drawable, Integer num) {
        Drawable drawable2 = drawable;
        Integer num2 = num;
        if (Build.VERSION.SDK_INT < 19) {
            this.gS.put(drawable2, num2);
        }
        drawable2.setAlpha(num2.intValue());
    }

    private e() {
        super(Integer.class, "drawableAlphaCompat");
    }
}
