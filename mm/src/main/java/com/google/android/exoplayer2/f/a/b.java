package com.google.android.exoplayer2.f.a;

import android.text.Layout;
import com.google.android.exoplayer2.f.a;

final class b extends a implements Comparable<b> {
    public final int priority;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(b bVar) {
        b bVar2 = bVar;
        if (bVar2.priority < this.priority) {
            return -1;
        }
        if (bVar2.priority > this.priority) {
            return 1;
        }
        return 0;
    }

    public b(CharSequence charSequence, Layout.Alignment alignment, float f2, int i2, float f3, int i3, boolean z, int i4, int i5) {
        super(charSequence, alignment, f2, 0, i2, f3, i3, Float.MIN_VALUE, z, i4);
        this.priority = i5;
    }
}
