package com.tencent.mm.plugin.story.api;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

public interface i {

    public interface a {
        boolean fnf();
    }

    void a(Canvas canvas, boolean z, int i2);

    void ba(View view);

    void fL(String str, int i2);

    View.OnClickListener fne();

    void setOnClickListener(View.OnClickListener onClickListener);

    void setShowStoryHint(boolean z);

    void setWeakContext(Context context);
}
