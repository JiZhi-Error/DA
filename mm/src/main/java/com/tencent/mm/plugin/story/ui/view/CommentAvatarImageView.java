package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.story.api.i;
import com.tencent.mm.plugin.story.api.m;
import com.tencent.mm.plugin.story.f.r;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0014J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u000e\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u001eR\u001a\u0010\f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarImageView;", "Landroid/widget/ImageView;", "Lcom/tencent/mm/plugin/story/api/IStoryStatusNotifyListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hintBg", "getHintBg", "()I", "setHintBg", "(I)V", "hintProxy", "Lcom/tencent/mm/plugin/story/api/IStoryHintProxy;", "tagName", "", "bindUsername", "", "userName", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onNotifyStoryStatusChanged", ch.COL_USERNAME, "isRead", "", "setShowStoryHint", "show", "plugin-story_release"})
public final class CommentAvatarImageView extends ImageView implements m {
    private final i EQN;
    private String FeZ;
    private int ktQ;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommentAvatarImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(120011);
        this.FeZ = "";
        setLayerType(1, null);
        this.EQN = r.Fnv.hj(context);
        this.EQN.ba(this);
        this.EQN.setOnClickListener(this.EQN.fne());
        AppMethodBeat.o(120011);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CommentAvatarImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(120012);
        AppMethodBeat.o(120012);
    }

    public final int getHintBg() {
        return this.ktQ;
    }

    public final void setHintBg(int i2) {
        this.ktQ = i2;
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(120007);
        p.h(canvas, "canvas");
        super.onDraw(canvas);
        this.EQN.a(canvas, false, this.ktQ);
        AppMethodBeat.o(120007);
    }

    public final void setShowStoryHint(boolean z) {
        AppMethodBeat.i(120008);
        this.EQN.setShowStoryHint(z);
        AppMethodBeat.o(120008);
    }

    public final void aSD(String str) {
        AppMethodBeat.i(120009);
        p.h(str, "userName");
        this.EQN.fL(str, 6);
        if (!TextUtils.equals(this.FeZ, str)) {
            this.FeZ = str;
        }
        AppMethodBeat.o(120009);
    }

    @Override // com.tencent.mm.plugin.story.api.m
    public final void cr(String str, boolean z) {
        AppMethodBeat.i(120010);
        p.h(str, ch.COL_USERNAME);
        if (TextUtils.isEmpty(str) || getContext() == null) {
            AppMethodBeat.o(120010);
            return;
        }
        if (p.j(str, this.FeZ)) {
            setShowStoryHint(!z);
        }
        AppMethodBeat.o(120010);
    }
}
