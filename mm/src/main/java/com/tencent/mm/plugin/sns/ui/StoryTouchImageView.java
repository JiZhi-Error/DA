package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.i;

public class StoryTouchImageView extends TouchImageView {
    i EQN;

    public StoryTouchImageView(Context context) {
        this(context, null);
    }

    public StoryTouchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(99695);
        this.EQN = null;
        this.EQN = ((e) g.ah(e.class)).getStoryUIFactory().hj(context);
        this.EQN.ba(this);
        this.EQN.setOnClickListener(this.EQN.fne());
        setLayerType(1, null);
        AppMethodBeat.o(99695);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.TouchImageView
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(99696);
        super.onDraw(canvas);
        this.EQN.a(canvas, true, 0);
        AppMethodBeat.o(99696);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(99697);
        super.setOnClickListener(this.EQN.fne());
        this.EQN.setOnClickListener(onClickListener);
        AppMethodBeat.o(99697);
    }

    public void setShowStoryHint(boolean z) {
        AppMethodBeat.i(99698);
        this.EQN.setShowStoryHint(z);
        AppMethodBeat.o(99698);
    }

    public final void setUserNameAndPageNumber$505cff1c(String str) {
        AppMethodBeat.i(259462);
        this.EQN.fL(str, 1);
        AppMethodBeat.o(259462);
    }
}
