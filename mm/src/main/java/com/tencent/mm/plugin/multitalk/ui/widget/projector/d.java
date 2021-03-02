package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenBlackBoardProjector;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectRootView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getBackgroundView", "Landroid/view/View;", "getLayoutId", "", "initView", "", "Companion", "plugin-multitalk_release"})
public final class d extends l {
    public static final a zWc = new a((byte) 0);

    static {
        AppMethodBeat.i(239922);
        AppMethodBeat.o(239922);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenBlackBoardProjector$Companion;", "", "()V", "TAG", "", "plugin-multitalk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(239921);
        e.a E = new e.a().E(1, 3, 4);
        Context context2 = getContext();
        p.g(context2, "context");
        String string = context2.getResources().getString(R.string.gek);
        p.g(string, "context.resources.getStr…_func_send_to_friend_btn)");
        Context context3 = getContext();
        p.g(context3, "context");
        String string2 = context3.getResources().getString(R.string.gei);
        p.g(string2, "context.resources.getStr…screen_more_func_fav_btn)");
        Context context4 = getContext();
        p.g(context4, "context");
        String string3 = context4.getResources().getString(R.string.gej);
        p.g(string3, "context.resources.getStr…more_func_sav_to_picture)");
        Context context5 = getContext();
        p.g(context5, "context");
        String string4 = context5.getResources().getString(R.string.gev);
        p.g(string4, "context.resources.getStr…n_projector_clear_screen)");
        e.a F = E.a(new e.c(string, 5), new e.c(string2, 6), new e.c(string3, 7), new e.c(string4, 8)).F(11, 9);
        F.type = 3;
        setScreenFuncConfig(F.epo());
        LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
        setMReadyLayout((FrameLayout) findViewById(R.id.a_n));
        setMEditLayout((FrameLayout) findViewById(R.id.a_m));
        setBottomRoot((FrameLayout) findViewById(R.id.a_l));
        setTopRoot((FrameLayout) findViewById(R.id.a_o));
        setAvatarRoot((FrameLayout) findViewById(R.id.a_k));
        FrameLayout mEditLayout = getMEditLayout();
        if (mEditLayout != null) {
            mEditLayout.setVisibility(8);
        }
        Context context6 = getContext();
        p.g(context6, "context");
        setMultiTalkStrokeContext(new b(context6, this, getScreenFuncConfig()));
        Context context7 = getContext();
        p.g(context7, "context");
        setTopUiLayout(new p(context7, this));
        Context context8 = getContext();
        p.g(context8, "context");
        setAvatarLayout(new j(context8, this));
        Context context9 = getContext();
        p.g(context9, "context");
        setBottomUiLayout(new k(context9, this, getScreenFuncConfig()));
        setMScreenReportData(new s());
        Context context10 = getContext();
        p.g(context10, "context");
        setReadyUI(new r(context10, this, getScreenFuncConfig()));
        refreshView();
        sd(true);
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new b(this));
            AppMethodBeat.o(239921);
            return;
        }
        AppMethodBeat.o(239921);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenBlackBoardProjector$initView$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-multitalk_release"})
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ d zWd;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(d dVar) {
            this.zWd = dVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x004d, code lost:
            if (r1 == r2.getMeasuredHeight()) goto L_0x00f5;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onGlobalLayout() {
            /*
            // Method dump skipped, instructions count: 259
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.ui.widget.projector.d.b.onGlobalLayout():void");
        }
    }

    @Override // com.tencent.mm.plugin.multitalk.ui.widget.projector.l
    public final int getLayoutId() {
        return R.layout.bd0;
    }

    @Override // com.tencent.mm.plugin.multitalk.ui.widget.projector.l
    public final View getBackgroundView() {
        AppMethodBeat.i(239920);
        FrameLayout mEditLayout = getMEditLayout();
        AppMethodBeat.o(239920);
        return mEditLayout;
    }
}
