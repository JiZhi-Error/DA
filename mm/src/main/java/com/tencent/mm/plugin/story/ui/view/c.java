package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.e;
import android.view.ViewGroup;
import android.view.Window;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0010H\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/CommentInputDialog;", "Landroid/support/v7/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "commentInputView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentInputView;", "getCommentInputView", "()Lcom/tencent/mm/plugin/story/ui/view/StoryCommentInputView;", "setCommentInputView", "(Lcom/tencent/mm/plugin/story/ui/view/StoryCommentInputView;)V", NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/view/ViewGroup$LayoutParams;", "getParams", "()Landroid/view/ViewGroup$LayoutParams;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "plugin-story_release"})
public final class c extends e {
    StoryCommentInputView FAE;
    private final ViewGroup.LayoutParams zAM = new ViewGroup.LayoutParams(-1, -1);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context, R.style.hb);
        p.h(context, "context");
        AppMethodBeat.i(120021);
        this.FAE = new StoryCommentInputView(context);
        gR();
        AppMethodBeat.o(120021);
    }

    @Override // android.support.v7.app.e
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(120018);
        setContentView(this.FAE, this.zAM);
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.addFlags(67108864);
            window.setLayout(-1, -1);
            window.setSoftInputMode(36);
            AppMethodBeat.o(120018);
            return;
        }
        AppMethodBeat.o(120018);
    }

    /* access modifiers changed from: protected */
    public final void onStart() {
        AppMethodBeat.i(120019);
        super.onStart();
        this.FAE.requestFocus();
        AppMethodBeat.o(120019);
    }

    public final void onBackPressed() {
        AppMethodBeat.i(120020);
        super.onBackPressed();
        AppMethodBeat.o(120020);
    }
}
