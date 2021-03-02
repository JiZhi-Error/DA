package com.tencent.mm.plugin.webview.luggage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.n.a;
import me.imid.swipebacklayout.lib.SwipeBackLayout;

public final class d implements f {
    private g ISU;
    private Intent mIntent = new Intent();

    public d(g gVar) {
        AppMethodBeat.i(78201);
        this.ISU = gVar;
        this.mIntent.putExtras(gVar.mParams);
        AppMethodBeat.o(78201);
    }

    @Override // com.tencent.mm.plugin.ball.a.f
    public final Activity getActivity() {
        return (Activity) this.ISU.mContext;
    }

    @Override // com.tencent.mm.plugin.ball.a.f
    public final Intent getIntent() {
        AppMethodBeat.i(78202);
        if (!Util.isNullOrNil(this.ISU.getTitle())) {
            this.mIntent.putExtra("title", this.ISU.getTitle());
        }
        Intent intent = this.mIntent;
        AppMethodBeat.o(78202);
        return intent;
    }

    @Override // com.tencent.mm.plugin.ball.a.f
    public final ViewGroup chG() {
        AppMethodBeat.i(78203);
        if (gbx()) {
            ViewGroup viewGroup = (ViewGroup) getActivity().getWindow().getDecorView();
            AppMethodBeat.o(78203);
            return viewGroup;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.ISU.mContentView.getParent();
        AppMethodBeat.o(78203);
        return viewGroup2;
    }

    @Override // com.tencent.mm.plugin.ball.a.f
    public final View getContentView() {
        AppMethodBeat.i(78204);
        if (!gbx()) {
            View targetView = ((SwipeBackLayout) this.ISU.mContentView).getTargetView();
            AppMethodBeat.o(78204);
            return targetView;
        } else if (((MMActivity) getActivity()).getSwipeBackLayout() != null) {
            View targetContentView = ((MMActivity) getActivity()).getSwipeBackLayout().getTargetContentView();
            AppMethodBeat.o(78204);
            return targetContentView;
        } else {
            AppMethodBeat.o(78204);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.ball.a.f
    public final View getMaskView() {
        AppMethodBeat.i(78205);
        View contentView = getContentView();
        AppMethodBeat.o(78205);
        return contentView;
    }

    @Override // com.tencent.mm.plugin.ball.a.f
    public final Bitmap getBitmap() {
        AppMethodBeat.i(78206);
        Bitmap a2 = a.a(getContentView(), Bitmap.Config.ARGB_8888);
        AppMethodBeat.o(78206);
        return a2;
    }

    @Override // com.tencent.mm.plugin.ball.a.f
    public final int chH() {
        AppMethodBeat.i(78207);
        if (gbx()) {
            AppMethodBeat.o(78207);
            return -1;
        }
        AppMethodBeat.o(78207);
        return 0;
    }

    @Override // com.tencent.mm.plugin.ball.a.f
    public final boolean aGg() {
        return this.ISU.mContentView != null;
    }

    @Override // com.tencent.mm.plugin.ball.a.f
    public final void hb(boolean z) {
        AppMethodBeat.i(78208);
        if (!this.ISU.ctg.Ly().bR(false)) {
            Activity activity = (Activity) this.ISU.mContext;
            if (z) {
                activity.getIntent().putExtra("MMActivity.OverrideExitAnimation", R.anim.di);
                activity.getIntent().putExtra("MMActivity.OverrideEnterAnimation", R.anim.s);
            } else {
                activity.getIntent().putExtra("MMActivity.OverrideExitAnimation", 0);
                activity.getIntent().putExtra("MMActivity.OverrideEnterAnimation", 0);
            }
            activity.finish();
        }
        AppMethodBeat.o(78208);
    }

    @Override // com.tencent.mm.plugin.ball.a.f
    public final void a(f.a aVar) {
        AppMethodBeat.i(78209);
        AppMethodBeat.o(78209);
    }

    @Override // com.tencent.mm.plugin.ball.a.f
    public final void a(final f.b bVar) {
        AppMethodBeat.i(78210);
        if (gbx()) {
            b.a(getActivity(), new b.AbstractC2081b() {
                /* class com.tencent.mm.plugin.webview.luggage.d.AnonymousClass1 */

                @Override // com.tencent.mm.ui.base.b.AbstractC2081b
                public final void ei(boolean z) {
                    AppMethodBeat.i(259607);
                    bVar.ei(z);
                    AppMethodBeat.o(259607);
                }
            });
            AppMethodBeat.o(78210);
            return;
        }
        bVar.ei(true);
        AppMethodBeat.o(78210);
    }

    @Override // com.tencent.mm.plugin.ball.a.f
    public final boolean bCI() {
        return true;
    }

    private boolean gbx() {
        AppMethodBeat.i(78211);
        Log.i("MicroMsg.LuggageFloatBallPageAdapter", "useActivityEnv: " + this.ISU.ctg.Lx().size());
        if (this.ISU.ctg.Lx().size() <= 1) {
            AppMethodBeat.o(78211);
            return true;
        }
        AppMethodBeat.o(78211);
        return false;
    }
}
