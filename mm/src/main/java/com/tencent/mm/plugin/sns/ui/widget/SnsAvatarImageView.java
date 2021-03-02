package com.tencent.mm.plugin.sns.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.ui.e.a;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.i;
import com.tencent.mm.plugin.story.api.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.tools.MaskImageButton;

public class SnsAvatarImageView extends MaskImageButton implements m {
    private i EQN;
    private String FeZ;
    private int pageType;

    public SnsAvatarImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(100480);
        this.pageType = -1;
        this.EQN = null;
        this.FeZ = "";
        this.EQN = ((e) g.ah(e.class)).getStoryUIFactory().hj(getContext());
        this.EQN.ba(this);
        setLayerType(1, null);
        AppMethodBeat.o(100480);
    }

    public void setWeakContext(Context context) {
        AppMethodBeat.i(100481);
        if (!(context instanceof Activity)) {
            Log.w("MicroMsg.SnsAvatarImageView", "weakContext is not activity");
        }
        this.EQN.setWeakContext(context);
        AppMethodBeat.o(100481);
    }

    @Override // com.tencent.mm.ui.tools.MaskImageButton
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(100482);
        super.onDraw(canvas);
        this.EQN.a(canvas, true, 0);
        AppMethodBeat.o(100482);
    }

    @Override // com.tencent.mm.ui.tools.MaskImageButton
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(100483);
        super.onMeasure(i2, i3);
        AppMethodBeat.o(100483);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(100484);
        super.setOnClickListener(this.EQN.fne());
        this.EQN.setOnClickListener(onClickListener);
        AppMethodBeat.o(100484);
    }

    public void setShowStoryHint(boolean z) {
        AppMethodBeat.i(100485);
        this.EQN.setShowStoryHint(z);
        AppMethodBeat.o(100485);
    }

    public void setUserName(String str) {
        AppMethodBeat.i(100486);
        fL(str, -1);
        AppMethodBeat.o(100486);
    }

    public final void fL(String str, int i2) {
        AppMethodBeat.i(100487);
        this.EQN.fL(str, i2);
        if (!this.FeZ.equals(str)) {
            this.FeZ = str;
            this.pageType = i2;
        }
        AppMethodBeat.o(100487);
    }

    @Override // com.tencent.mm.plugin.story.api.m
    public final void cr(String str, boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(100488);
        Log.printInfoStack("MicroMsg.SnsAvatarImageView", "onNotifyStoryStatusChanged username: %s , isRead:%b", str, Boolean.valueOf(z));
        if (TextUtils.isEmpty(str) || getContext() == null) {
            AppMethodBeat.o(100488);
            return;
        }
        if (str.equals(this.FeZ)) {
            if (z) {
                z2 = false;
            }
            setShowStoryHint(z2);
        }
        AppMethodBeat.o(100488);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(100489);
        super.onDetachedFromWindow();
        if (this.pageType != -1) {
            a.b(this.pageType, this.FeZ, this);
        }
        AppMethodBeat.o(100489);
    }
}
