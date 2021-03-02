package android.support.design.a;

import android.util.Property;
import android.view.ViewGroup;
import com.tencent.mm.R;

public final class d extends Property<ViewGroup, Float> {
    public static final Property<ViewGroup, Float> gQ = new d("childrenAlpha");

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.util.Property
    public final /* synthetic */ Float get(ViewGroup viewGroup) {
        Float f2 = (Float) viewGroup.getTag(R.id.fna);
        if (f2 != null) {
            return f2;
        }
        return Float.valueOf(1.0f);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // android.util.Property
    public final /* synthetic */ void set(ViewGroup viewGroup, Float f2) {
        ViewGroup viewGroup2 = viewGroup;
        float floatValue = f2.floatValue();
        viewGroup2.setTag(R.id.fna, Float.valueOf(floatValue));
        int childCount = viewGroup2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            viewGroup2.getChildAt(i2).setAlpha(floatValue);
        }
    }

    private d(String str) {
        super(Float.class, str);
    }
}
