package android.support.transition;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* access modifiers changed from: package-private */
public final class y extends ae implements aa {
    y(Context context, ViewGroup viewGroup, View view) {
        super(context, viewGroup, view);
    }

    @Override // android.support.transition.aa
    public final void add(View view) {
        this.DB.add(view);
    }

    @Override // android.support.transition.aa
    public final void remove(View view) {
        this.DB.remove(view);
    }
}
