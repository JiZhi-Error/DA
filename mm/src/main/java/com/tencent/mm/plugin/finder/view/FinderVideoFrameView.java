package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0016\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tR\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderVideoFrameView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "textureView", "Landroid/view/TextureView;", "getTextureView", "()Landroid/view/TextureView;", "setTextureView", "(Landroid/view/TextureView;)V", "initView", "", "resize", "width", "height", "plugin-finder_release"})
public final class FinderVideoFrameView extends FrameLayout {
    public TextureView bec;

    public final TextureView getTextureView() {
        AppMethodBeat.i(255012);
        TextureView textureView = this.bec;
        if (textureView == null) {
            p.btv("textureView");
        }
        AppMethodBeat.o(255012);
        return textureView;
    }

    public final void setTextureView(TextureView textureView) {
        AppMethodBeat.i(255013);
        p.h(textureView, "<set-?>");
        this.bec = textureView;
        AppMethodBeat.o(255013);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderVideoFrameView(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(255015);
        initView();
        AppMethodBeat.o(255015);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderVideoFrameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(255016);
        initView();
        AppMethodBeat.o(255016);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderVideoFrameView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(255017);
        initView();
        AppMethodBeat.o(255017);
    }

    private final void initView() {
        AppMethodBeat.i(255014);
        LayoutInflater.from(getContext()).inflate(R.layout.al2, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.j4z);
        p.g(findViewById, "findViewById(R.id.video_frame_textureview)");
        this.bec = (TextureView) findViewById;
        AppMethodBeat.o(255014);
    }
}
