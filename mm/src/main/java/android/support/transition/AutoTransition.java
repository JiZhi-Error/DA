package android.support.transition;

import android.content.Context;
import android.util.AttributeSet;

public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        init();
    }

    public AutoTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        ao(1);
        c(new Fade(2)).c(new ChangeBounds()).c(new Fade(1));
    }
}
