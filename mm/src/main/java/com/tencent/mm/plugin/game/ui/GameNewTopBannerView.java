package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class GameNewTopBannerView extends FrameLayout implements View.OnClickListener {
    String lAo = null;
    Context mContext;
    int xGR;
    ImageView xPD;
    ImageView xPE;
    int xVk;
    int xVl;
    String xVm = "";
    private String xVn = "";

    public GameNewTopBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(42318);
        super.onFinishInflate();
        this.xPD = (ImageView) findViewById(R.id.a3g);
        this.xPE = (ImageView) findViewById(R.id.ht0);
        Log.i("MicroMsg.GameTopBannerView", "initView finished");
        AppMethodBeat.o(42318);
    }

    /* access modifiers changed from: package-private */
    public final int c(ImageView imageView, int i2, int i3) {
        AppMethodBeat.i(42319);
        int screenWidth = c.getScreenWidth(this.mContext);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams == null) {
            Log.e("MicroMsg.GameTopBannerView", "resizeGameThemePic, params is null");
            AppMethodBeat.o(42319);
            return 0;
        }
        layoutParams.height = (int) (((float) screenWidth) * (((float) i2) / ((float) i3)));
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        int i4 = layoutParams.height;
        AppMethodBeat.o(42319);
        return i4;
    }

    public void onClick(View view) {
        AppMethodBeat.i(42320);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/game/ui/GameNewTopBannerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (view.getTag() != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!Util.isNullOrNil(str)) {
                f.a(this.mContext, 10, HardCoderJNI.FUNC_CANCEL_GPU_HIGH_FREQ, 1, c.D(this.mContext, str, "game_center_top_banner"), 0, null, this.xGR, 0, null, null, this.lAo);
            }
        }
        a.a(this, "com/tencent/mm/plugin/game/ui/GameNewTopBannerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42320);
    }

    static void dWy() {
        AppMethodBeat.i(42321);
        GameIndexListView.setDefaultPadding(0);
        GameIndexListView.setInitPadding(0);
        GameIndexListView.setCanPulldown(false);
        AppMethodBeat.o(42321);
    }
}
