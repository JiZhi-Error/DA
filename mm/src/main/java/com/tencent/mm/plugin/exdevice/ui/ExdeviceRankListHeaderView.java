package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public class ExdeviceRankListHeaderView extends RelativeLayout {
    private View.OnClickListener hEZ;
    private Context mContext;
    private Runnable mHideRunnable;
    private TextView rKL;
    private Animation rKM;
    private Animation rKN;
    private boolean rKO;

    public ExdeviceRankListHeaderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        AppMethodBeat.i(24280);
        this.rKO = true;
        bh(context);
        AppMethodBeat.o(24280);
    }

    public ExdeviceRankListHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ExdeviceRankListHeaderView(Context context) {
        super(context);
        AppMethodBeat.i(24281);
        this.rKO = true;
        bh(context);
        AppMethodBeat.o(24281);
    }

    private void bh(Context context) {
        AppMethodBeat.i(24282);
        this.mContext = context;
        this.rKL = (TextView) LayoutInflater.from(this.mContext).inflate(R.layout.a56, (ViewGroup) this, true).findViewById(R.id.aqs);
        this.rKL.setVisibility(4);
        cMc();
        setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankListHeaderView.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(24274);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankListHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (ExdeviceRankListHeaderView.this.rKO) {
                    ExdeviceRankListHeaderView.b(ExdeviceRankListHeaderView.this);
                }
                if (ExdeviceRankListHeaderView.this.hEZ != null) {
                    ExdeviceRankListHeaderView.this.hEZ.onClick(ExdeviceRankListHeaderView.this);
                }
                a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankListHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(24274);
            }
        });
        AppMethodBeat.o(24282);
    }

    private void cMc() {
        AppMethodBeat.i(24283);
        this.rKM = AnimationUtils.loadAnimation(this.mContext, R.anim.f2996a);
        this.rKN = AnimationUtils.loadAnimation(this.mContext, R.anim.f2997b);
        this.mHideRunnable = new Runnable() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankListHeaderView.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(24275);
                ExdeviceRankListHeaderView.this.rKL.startAnimation(ExdeviceRankListHeaderView.this.rKN);
                AppMethodBeat.o(24275);
            }
        };
        this.rKM.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankListHeaderView.AnonymousClass3 */

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(24276);
                ExdeviceRankListHeaderView.this.rKL.setVisibility(0);
                AppMethodBeat.o(24276);
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(24277);
                ExdeviceRankListHeaderView.this.rKN.reset();
                MMHandlerThread.postToMainThreadDelayed(ExdeviceRankListHeaderView.this.mHideRunnable, 4000);
                AppMethodBeat.o(24277);
            }
        });
        this.rKN.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceRankListHeaderView.AnonymousClass4 */

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(24278);
                ExdeviceRankListHeaderView.this.rKL.setVisibility(0);
                AppMethodBeat.o(24278);
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(24279);
                ExdeviceRankListHeaderView.this.rKL.setVisibility(4);
                AppMethodBeat.o(24279);
            }
        });
        this.rKM.setFillAfter(true);
        this.rKM.setFillEnabled(true);
        this.rKN.setFillAfter(true);
        this.rKN.setFillAfter(true);
        AppMethodBeat.o(24283);
    }

    public void setMotto(String str) {
        AppMethodBeat.i(24284);
        this.rKL.setText(str);
        AppMethodBeat.o(24284);
    }

    public String getMotto() {
        AppMethodBeat.i(24285);
        String nullAs = Util.nullAs(this.rKL.getText().toString(), "");
        AppMethodBeat.o(24285);
        return nullAs;
    }

    public void setOnViewClickListener(View.OnClickListener onClickListener) {
        this.hEZ = onClickListener;
    }

    public void setIsShowTip(boolean z) {
        this.rKO = z;
    }

    static /* synthetic */ void b(ExdeviceRankListHeaderView exdeviceRankListHeaderView) {
        AppMethodBeat.i(24286);
        MMHandlerThread.removeRunnable(exdeviceRankListHeaderView.mHideRunnable);
        if (exdeviceRankListHeaderView.rKL.getVisibility() == 4) {
            exdeviceRankListHeaderView.rKM.reset();
            exdeviceRankListHeaderView.rKL.startAnimation(exdeviceRankListHeaderView.rKM);
            AppMethodBeat.o(24286);
            return;
        }
        exdeviceRankListHeaderView.rKN.reset();
        exdeviceRankListHeaderView.rKL.startAnimation(exdeviceRankListHeaderView.rKN);
        AppMethodBeat.o(24286);
    }
}
