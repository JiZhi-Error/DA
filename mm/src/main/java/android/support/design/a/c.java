package android.support.design.a;

import android.animation.TypeEvaluator;

public final class c implements TypeEvaluator<Integer> {
    private static final c gP = new c();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
    @Override // android.animation.TypeEvaluator
    public final /* synthetic */ Integer evaluate(float f2, Integer num, Integer num2) {
        int intValue = num.intValue();
        float f3 = ((float) ((intValue >> 24) & 255)) / 255.0f;
        int intValue2 = num2.intValue();
        float pow = (float) Math.pow((double) (((float) ((intValue >> 16) & 255)) / 255.0f), 2.2d);
        float pow2 = (float) Math.pow((double) (((float) ((intValue >> 8) & 255)) / 255.0f), 2.2d);
        float pow3 = (float) Math.pow((double) (((float) (intValue & 255)) / 255.0f), 2.2d);
        float pow4 = (float) Math.pow((double) (((float) ((intValue2 >> 16) & 255)) / 255.0f), 2.2d);
        float pow5 = (float) Math.pow((double) (((float) ((intValue2 >> 8) & 255)) / 255.0f), 2.2d);
        float f4 = f3 + (((((float) ((intValue2 >> 24) & 255)) / 255.0f) - f3) * f2);
        float f5 = pow + ((pow4 - pow) * f2);
        return Integer.valueOf(Math.round(((float) Math.pow((double) (pow3 + ((((float) Math.pow((double) (((float) (intValue2 & 255)) / 255.0f), 2.2d)) - pow3) * f2)), 0.45454545454545453d)) * 255.0f) | (Math.round(f4 * 255.0f) << 24) | (Math.round(((float) Math.pow((double) f5, 0.45454545454545453d)) * 255.0f) << 16) | (Math.round(((float) Math.pow((double) (pow2 + ((pow5 - pow2) * f2)), 0.45454545454545453d)) * 255.0f) << 8));
    }

    public static c aT() {
        return gP;
    }
}
