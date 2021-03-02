package com.tencent.mm.plugin.ball.a;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.n.a;
import java.util.concurrent.atomic.AtomicInteger;

public class e implements f {
    public Activity activity;

    public e(Activity activity2) {
        this.activity = activity2;
    }

    @Override // com.tencent.mm.plugin.ball.a.f
    public Activity getActivity() {
        return this.activity;
    }

    @Override // com.tencent.mm.plugin.ball.a.f
    public Intent getIntent() {
        AppMethodBeat.i(127516);
        Activity activity2 = getActivity();
        if (activity2 == null) {
            AppMethodBeat.o(127516);
            return null;
        }
        Intent intent = activity2.getIntent();
        AppMethodBeat.o(127516);
        return intent;
    }

    @Override // com.tencent.mm.plugin.ball.a.f
    public ViewGroup chG() {
        AppMethodBeat.i(127517);
        Activity activity2 = getActivity();
        if (activity2 == null) {
            AppMethodBeat.o(127517);
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) activity2.getWindow().getDecorView();
        AppMethodBeat.o(127517);
        return viewGroup;
    }

    @Override // com.tencent.mm.plugin.ball.a.f
    public View getContentView() {
        AppMethodBeat.i(127518);
        if (!(this.activity instanceof MMActivity) || ((MMActivity) this.activity).getSwipeBackLayout() == null) {
            AppMethodBeat.o(127518);
            return null;
        }
        View targetContentView = ((MMActivity) this.activity).getSwipeBackLayout().getTargetContentView();
        AppMethodBeat.o(127518);
        return targetContentView;
    }

    @Override // com.tencent.mm.plugin.ball.a.f
    public View getMaskView() {
        AppMethodBeat.i(127519);
        if (this.activity instanceof MMActivity) {
            View bodyView = ((MMActivity) this.activity).getBodyView();
            AppMethodBeat.o(127519);
            return bodyView;
        }
        AppMethodBeat.o(127519);
        return null;
    }

    @Override // com.tencent.mm.plugin.ball.a.f
    public Bitmap getBitmap() {
        AppMethodBeat.i(127520);
        Bitmap a2 = a.a(getMaskView(), Bitmap.Config.ARGB_8888);
        AppMethodBeat.o(127520);
        return a2;
    }

    @Override // com.tencent.mm.plugin.ball.a.f
    public int chH() {
        return -1;
    }

    @Override // com.tencent.mm.plugin.ball.a.f
    public boolean aGg() {
        AppMethodBeat.i(127521);
        if (!(this.activity instanceof MMActivity) || ((MMActivity) this.activity).getSwipeBackLayout() == null) {
            AppMethodBeat.o(127521);
            return false;
        }
        AppMethodBeat.o(127521);
        return true;
    }

    @Override // com.tencent.mm.plugin.ball.a.f
    public void a(f.a aVar) {
        AppMethodBeat.i(127522);
        if (this.activity instanceof MMActivity) {
            ((MMActivity) this.activity).getSwipeBackLayout();
        }
        AppMethodBeat.o(127522);
    }

    @Override // com.tencent.mm.plugin.ball.a.f
    public void hb(boolean z) {
        AppMethodBeat.i(127523);
        Log.i("MicroMsg.FloatBallPageAdapter", "finish, withAnimation:%s", Boolean.valueOf(z));
        if (getIntent() != null) {
            if (z) {
                getIntent().putExtra("MMActivity.OverrideExitAnimation", R.anim.di);
                getIntent().putExtra("MMActivity.OverrideEnterAnimation", R.anim.s);
            } else {
                getIntent().putExtra("MMActivity.OverrideExitAnimation", 0);
                getIntent().putExtra("MMActivity.OverrideEnterAnimation", 0);
            }
        }
        if (getActivity() != null) {
            getActivity().finish();
        }
        AppMethodBeat.o(127523);
    }

    @Override // com.tencent.mm.plugin.ball.a.f
    public void a(final f.b bVar) {
        AppMethodBeat.i(127524);
        Log.i("MicroMsg.FloatBallPageAdapter", "convertToTranslucent");
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        b.a(this.activity, new b.AbstractC2081b() {
            /* class com.tencent.mm.plugin.ball.a.e.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.b.AbstractC2081b
            public final void ei(boolean z) {
                AppMethodBeat.i(188573);
                if (z || atomicInteger.getAndIncrement() > 0) {
                    if (bVar != null) {
                        bVar.ei(z);
                    }
                    AppMethodBeat.o(188573);
                    return;
                }
                b.a(e.this.activity, new b.AbstractC2081b() {
                    /* class com.tencent.mm.plugin.ball.a.e.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.b.AbstractC2081b
                    public final void ei(boolean z) {
                        AppMethodBeat.i(188572);
                        if (bVar != null) {
                            bVar.ei(z);
                        }
                        AppMethodBeat.o(188572);
                    }
                });
                AppMethodBeat.o(188573);
            }
        });
        Log.i("MicroMsg.FloatBallPageAdapter", "float ball page convertActivityToTranslucent");
        AppMethodBeat.o(127524);
    }

    @Override // com.tencent.mm.plugin.ball.a.f
    public boolean bCI() {
        return true;
    }
}
