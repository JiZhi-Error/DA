package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VoiceInputScrollView extends ScrollView {
    private a KdN;

    public interface a {
    }

    public VoiceInputScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VoiceInputScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setOnScrollListener(a aVar) {
        this.KdN = aVar;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(31307);
        super.onScrollChanged(i2, i3, i4, i5);
        AppMethodBeat.o(31307);
    }
}
