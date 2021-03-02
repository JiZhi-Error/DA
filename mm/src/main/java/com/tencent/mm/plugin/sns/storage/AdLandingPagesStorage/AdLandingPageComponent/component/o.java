package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class o extends m {
    private TextView Edj;
    private int Edk = 0;
    public int Edl;
    private ImageView Xx;
    AnimatorSet xc;

    public o(Context context, p pVar, ViewGroup viewGroup) {
        super(context, pVar, viewGroup);
        AppMethodBeat.i(202931);
        pVar.DZl = 2.14748365E9f;
        this.Edl = a.fromDPToPix(context, 130);
        AppMethodBeat.o(202931);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final int getLayout() {
        return R.layout.bua;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXe() {
        AppMethodBeat.i(202932);
        this.Xx = (ImageView) this.contentView.findViewById(R.id.ieu);
        this.Edj = (TextView) this.contentView.findViewById(R.id.iev);
        ImageView imageView = this.Xx;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "translationY", 0.0f, (float) (-a.fromDPToPix(this.context, 12)));
        ofFloat.setDuration(1000L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "alpha", 0.0f, 0.8f);
        ofFloat2.setDuration(1000L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "alpha", 0.8f, 0.0f);
        ofFloat3.setDuration(500L);
        this.xc = new AnimatorSet();
        this.xc.play(ofFloat).with(ofFloat2);
        this.xc.play(ofFloat3).after(ofFloat);
        this.xc.addListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o.AnonymousClass2 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(202927);
                Log.d("AdLandingPageBottomSwipeComponet", "onAnimationStart");
                AppMethodBeat.o(202927);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(202928);
                o.this.xc.start();
                Log.d("AdLandingPageBottomSwipeComponet", "onAnimationEnd");
                AppMethodBeat.o(202928);
            }

            public final void onAnimationCancel(Animator animator) {
                AppMethodBeat.i(202929);
                Log.d("AdLandingPageBottomSwipeComponet", "onAnimationCancel");
                AppMethodBeat.o(202929);
            }

            public final void onAnimationRepeat(Animator animator) {
                AppMethodBeat.i(202930);
                Log.d("AdLandingPageBottomSwipeComponet", "onAnimationRepeat");
                AppMethodBeat.o(202930);
            }
        });
        this.xc.start();
        if (((p) this.EcX).DZm) {
            this.Edj.setTextColor(Color.parseColor("#CC000000"));
            this.Xx.setImageResource(R.drawable.bwr);
        } else {
            this.Edj.setTextColor(Color.parseColor("#CCFFFFFF"));
            this.Xx.setImageResource(R.drawable.bws);
        }
        this.contentView.findViewById(R.id.b3o).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(202926);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBottomSwipeComponet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                o.this.fdv();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBottomSwipeComponet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(202926);
            }
        });
        AppMethodBeat.o(202932);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWX() {
        AppMethodBeat.i(202933);
        ViewGroup.LayoutParams layoutParams = this.contentView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMargins((int) ((p) this.EcX).paddingLeft, (int) ((p) this.EcX).paddingTop, (int) ((p) this.EcX).paddingRight, (int) ((p) this.EcX).paddingBottom);
            this.contentView.setLayoutParams(marginLayoutParams);
        }
        AppMethodBeat.o(202933);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWT() {
        AppMethodBeat.i(202934);
        if (this.Edj == null || this.Xx == null || ((p) this.EcX) == null) {
            AppMethodBeat.o(202934);
            return;
        }
        if (!TextUtils.isEmpty(((p) this.EcX).DYo)) {
            this.Edj.setText(((p) this.EcX).DYo);
        }
        AppMethodBeat.o(202934);
    }

    public final void fdv() {
        AppMethodBeat.i(202935);
        this.Edk++;
        if (this.context instanceof SnsAdNativeLandingPagesUI) {
            try {
                int i2 = ((p) this.EcX).DYp;
                Log.i("AdLandingPageBottomSwipeComponet", "doJump, swipCount=" + this.Edk + ", actionType=" + i2);
                if (i2 == 0) {
                    SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI = (SnsAdNativeLandingPagesUI) this.context;
                    long aOa = y.aOa(snsAdNativeLandingPagesUI.getIntent().getStringExtra("sns_landing_pages_share_sns_id"));
                    k.a(this.context, ((p) this.EcX).jumpUrl, fds(), snsAdNativeLandingPagesUI.getIntent().getIntExtra("sns_landig_pages_from_source", 0), aOa, ((p) this.EcX).DZi);
                    snsAdNativeLandingPagesUI.overridePendingTransition(R.anim.dq, R.anim.s);
                }
                AppMethodBeat.o(202935);
                return;
            } catch (Throwable th) {
                Log.e("AdLandingPageBottomSwipeComponet", "doJump exp=" + th.toString());
            }
        }
        AppMethodBeat.o(202935);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXd() {
        AppMethodBeat.i(202936);
        super.eXd();
        this.xc.removeAllListeners();
        AppMethodBeat.o(202936);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final boolean bp(JSONObject jSONObject) {
        AppMethodBeat.i(202937);
        if (!super.bp(jSONObject)) {
            Log.e("AdLandingPageBottomSwipeComponet", "setComponentKVReportData super failed");
            AppMethodBeat.o(202937);
            return false;
        }
        try {
            jSONObject.put("jumpCount", this.Edk);
            Log.i("AdLandingPageBottomSwipeComponet", "setComponentKVReportData json=" + jSONObject.toString());
            AppMethodBeat.o(202937);
            return true;
        } catch (Exception e2) {
            Log.e("AdLandingPageBottomSwipeComponet", "setComponentKVReportData exp=" + e2.toString());
            AppMethodBeat.o(202937);
            return false;
        }
    }
}
