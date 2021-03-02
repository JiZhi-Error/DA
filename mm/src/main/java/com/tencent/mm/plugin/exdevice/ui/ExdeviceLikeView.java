package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public class ExdeviceLikeView extends RelativeLayout {
    private Context mContext;
    private int rIt;
    private a rIu;
    private int rIv;
    private TextView rIw;
    private ImageView rIx;
    private ProgressBar rIy;

    public interface a {
        boolean cLN();

        void oj(int i2);
    }

    public ExdeviceLikeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        AppMethodBeat.i(24046);
        this.rIv = 2;
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.a4q, (ViewGroup) this, true);
        this.rIw = (TextView) inflate.findViewById(R.id.c5t);
        this.rIx = (ImageView) inflate.findViewById(R.id.c5s);
        this.rIy = (ProgressBar) inflate.findViewById(R.id.c5w);
        setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeView.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(24045);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (ExdeviceLikeView.this.rIu != null) {
                    a aVar = ExdeviceLikeView.this.rIu;
                    int unused = ExdeviceLikeView.this.rIv;
                    if (!aVar.cLN() && ExdeviceLikeView.this.rIv == 0) {
                        Log.d("MicroMsg.ExdeviceLikeView", "click listener is not null");
                        ExdeviceLikeView.this.setSelfLikeState(ExdeviceLikeView.GG(ExdeviceLikeView.this.rIv));
                        if (ExdeviceLikeView.this.rIv == 1) {
                            ExdeviceLikeView.c(ExdeviceLikeView.this);
                        }
                        if (ExdeviceLikeView.this.rIu != null) {
                            ExdeviceLikeView.this.rIu.oj(ExdeviceLikeView.this.rIv);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(24045);
                    }
                }
                Log.d("MicroMsg.ExdeviceLikeView", "hy: loading or has liked or consumed. abort event");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(24045);
            }
        });
        AppMethodBeat.o(24046);
    }

    public ExdeviceLikeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setLikeNum(int i2) {
        AppMethodBeat.i(24047);
        this.rIt = i2;
        String sb = new StringBuilder().append(this.rIt).toString();
        if (this.rIt < 0) {
            Log.w("MicroMsg.ExdeviceLikeView", "hy: like num is negative. set to 0");
            sb = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } else if (i2 > 999) {
            Log.d("MicroMsg.ExdeviceLikeView", "hy: like num exceeded the limit. put plus");
            sb = "999+";
        }
        if (this.rIt <= 0) {
            this.rIw.setVisibility(8);
        } else {
            this.rIw.setVisibility(0);
        }
        this.rIw.setText(sb);
        AppMethodBeat.o(24047);
    }

    public void setSelfLikeState(int i2) {
        AppMethodBeat.i(24048);
        this.rIv = i2;
        if (this.rIv == 1) {
            this.rIy.setVisibility(8);
            this.rIw.setVisibility(0);
            this.rIx.setVisibility(0);
            this.rIx.setImageResource(R.raw.device_rank_item_liked);
            AppMethodBeat.o(24048);
        } else if (this.rIv == 0) {
            this.rIy.setVisibility(8);
            this.rIw.setVisibility(0);
            this.rIx.setVisibility(0);
            this.rIx.setImageResource(R.raw.device_rank_item_unliked);
            AppMethodBeat.o(24048);
        } else if (this.rIv == 2) {
            this.rIw.setVisibility(8);
            this.rIy.setVisibility(0);
            this.rIx.setVisibility(8);
            AppMethodBeat.o(24048);
        } else {
            Log.w("MicroMsg.ExdeviceLikeView", "hy: error state");
            AppMethodBeat.o(24048);
        }
    }

    public void setOnLikeViewClickListener(a aVar) {
        this.rIu = aVar;
    }

    static /* synthetic */ int GG(int i2) {
        AppMethodBeat.i(24049);
        switch (i2) {
            case 0:
                AppMethodBeat.o(24049);
                return 1;
            case 1:
                AppMethodBeat.o(24049);
                return 0;
            case 2:
                AppMethodBeat.o(24049);
                return 2;
            default:
                Log.w("MicroMsg.ExdeviceLikeView", "hy: state error");
                AppMethodBeat.o(24049);
                return 2;
        }
    }

    static /* synthetic */ void c(ExdeviceLikeView exdeviceLikeView) {
        AppMethodBeat.i(24050);
        Animation loadAnimation = AnimationUtils.loadAnimation(exdeviceLikeView.mContext, R.anim.cf);
        loadAnimation.setFillAfter(false);
        exdeviceLikeView.rIx.startAnimation(loadAnimation);
        AppMethodBeat.o(24050);
    }
}
