package com.tencent.mm.ui.chatting.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.patmsg.ui.AvatarPatImageView;
import com.tencent.mm.plugin.sns.ui.e.a;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.i;
import com.tencent.mm.plugin.story.api.m;

public class AvatarImageView extends AvatarPatImageView implements m {
    private i EQN;
    private String FeZ;
    private boolean PGf;
    private final String TAG;
    private int pageType;

    public AvatarImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AvatarImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(36689);
        this.TAG = "MicroMsg.AvatarImageView";
        this.pageType = -1;
        this.EQN = null;
        this.FeZ = "";
        this.PGf = true;
        this.EQN = ((e) g.ah(e.class)).getStoryUIFactory().hj(context);
        this.EQN.ba(this);
        setLayerType(1, null);
        AppMethodBeat.o(36689);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(36690);
        super.onDraw(canvas);
        if (this.PGf) {
            this.EQN.a(canvas, true, 0);
            AppMethodBeat.o(36690);
            return;
        }
        this.EQN.a(canvas, false, 0);
        AppMethodBeat.o(36690);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(36691);
        super.onMeasure(i2, i3);
        AppMethodBeat.o(36691);
    }

    public void setShowStoryHint(boolean z) {
        AppMethodBeat.i(36694);
        this.EQN.setShowStoryHint(z);
        AppMethodBeat.o(36694);
    }

    public final void fL(String str, int i2) {
        AppMethodBeat.i(36695);
        this.EQN.fL(str, i2);
        this.FeZ = str;
        this.pageType = i2;
        AppMethodBeat.o(36695);
    }

    public void setChattingBG(boolean z) {
        this.PGf = z;
    }

    @Override // com.tencent.mm.plugin.story.api.m
    public final void cr(String str, boolean z) {
        AppMethodBeat.i(36696);
        if (TextUtils.isEmpty(str) || getContext() == null) {
            AppMethodBeat.o(36696);
            return;
        }
        if (str.equals(this.FeZ)) {
            setShowStoryHint(!z);
        }
        AppMethodBeat.o(36696);
    }

    @Override // com.tencent.mm.plugin.patmsg.ui.AvatarPatImageView
    public void onDetachedFromWindow() {
        AppMethodBeat.i(36697);
        super.onDetachedFromWindow();
        if (this.pageType != -1) {
            a.b(this.pageType, this.FeZ, this);
        }
        AppMethodBeat.o(36697);
    }
}
