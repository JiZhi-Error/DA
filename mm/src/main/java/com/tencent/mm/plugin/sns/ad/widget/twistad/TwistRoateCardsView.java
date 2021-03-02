package com.tencent.mm.plugin.sns.ad.widget.twistad;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.ad.e.i;
import com.tencent.mm.plugin.sns.ad.i.b;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.wxmm.v2helper;

public class TwistRoateCardsView extends FrameLayout {
    private float DCA = 1.0f;
    private View DCB;
    public int DCC;
    public String DCD;
    public int DCE;
    ViewOutlineProvider DCF = new ViewOutlineProvider() {
        /* class com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView.AnonymousClass1 */

        public final void getOutline(View view, Outline outline) {
            AppMethodBeat.i(202536);
            outline.setRoundRect(0, 0, TwistRoateCardsView.this.DCv, TwistRoateCardsView.this.DCw, (float) TwistRoateCardsView.this.DCy);
            AppMethodBeat.o(202536);
        }
    };
    private int DCG = 0;
    private a DCH;
    private int DCs = 0;
    private int DCt = 0;
    public int DCu;
    public int DCv;
    public int DCw;
    private int DCx;
    private int DCy;
    private float DCz = 0.0f;
    public boolean DsW = false;
    private final String TAG = "TwistRoateCardsView";
    public Context mContext;

    public interface a {
        void eYT();

        void eYU();

        void eYV();
    }

    static /* synthetic */ int f(TwistRoateCardsView twistRoateCardsView) {
        int i2 = twistRoateCardsView.DCG;
        twistRoateCardsView.DCG = i2 + 1;
        return i2;
    }

    public TwistRoateCardsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(202543);
        this.mContext = context;
        this.DCx = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 14);
        this.DCy = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 8);
        AppMethodBeat.o(202543);
    }

    public void setAnimCardView(View view) {
        this.DCB = view;
    }

    public final void eYS() {
        AppMethodBeat.i(202544);
        for (int i2 = 0; i2 < 12; i2++) {
            ImageView imageView = new ImageView(this.mContext);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.DCv, this.DCw);
            layoutParams.setMargins(this.DCx, this.DCx, this.DCx, this.DCx);
            layoutParams.gravity = 17;
            imageView.setLayoutParams(layoutParams);
            imageView.setClipToOutline(true);
            imageView.setOutlineProvider(this.DCF);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setBackgroundColor(this.DCE);
            b.j(this.DCD, imageView);
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            frameLayout.addView(imageView);
            frameLayout.setBackgroundResource(R.drawable.btg);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(this.DCv + (this.DCx * 2), this.DCw + (this.DCx * 2)));
            addView(frameLayout);
        }
        AppMethodBeat.o(202544);
    }

    private View getCardView$7529eef0() {
        AppMethodBeat.i(259435);
        ImageView imageView = new ImageView(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.DCv, this.DCw);
        layoutParams.setMargins(this.DCx, this.DCx, this.DCx, this.DCx);
        layoutParams.gravity = 17;
        imageView.setLayoutParams(layoutParams);
        imageView.setClipToOutline(true);
        imageView.setOutlineProvider(this.DCF);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setBackgroundColor(this.DCE);
        b.j(this.DCD, imageView);
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        frameLayout.addView(imageView);
        frameLayout.setBackgroundResource(R.drawable.btg);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(this.DCv + (this.DCx * 2), this.DCw + (this.DCx * 2)));
        AppMethodBeat.o(259435);
        return frameLayout;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int cos;
        int sin;
        AppMethodBeat.i(202546);
        if (getWidth() > 0 && getHeight() > 0) {
            this.DCs = getWidth() / 2;
            this.DCt = getHeight() + com.tencent.mm.cb.a.fromDPToPix(this.mContext, 40);
            if (getChildCount() == 12) {
                for (int i6 = 0; i6 < 12; i6++) {
                    View childAt = getChildAt(i6);
                    if (this.DsW) {
                        double d2 = 0.5235987755982988d * ((double) i6);
                        cos = (int) (((double) this.DCu) * Math.cos(d2));
                        sin = (int) (Math.sin(d2) * ((double) this.DCu));
                        childAt.setRotation((float) (90 - ((i6 * v2helper.VOIP_ENC_HEIGHT_LV1) / 12)));
                    } else {
                        double d3 = 0.5235987755982988d * ((double) (-i6));
                        cos = (int) (((double) this.DCu) * Math.cos(d3));
                        sin = (int) (Math.sin(d3) * ((double) this.DCu));
                        childAt.setRotation((float) (((i6 * v2helper.VOIP_ENC_HEIGHT_LV1) / 12) + 90));
                    }
                    int i7 = cos + this.DCs;
                    int i8 = this.DCt - sin;
                    int i9 = this.DCv + (this.DCx * 2);
                    int i10 = this.DCw + (this.DCx * 2);
                    childAt.layout(i7 - (i9 / 2), i8 - (i10 / 2), i7 + (i9 / 2), i8 + (i10 / 2));
                }
            }
        }
        AppMethodBeat.o(202546);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(202547);
        canvas.save();
        canvas.rotate(this.DCz, (float) this.DCs, (float) this.DCt);
        canvas.scale(this.DCA, this.DCA, (float) this.DCs, (float) this.DCt);
        super.dispatchDraw(canvas);
        canvas.restore();
        AppMethodBeat.o(202547);
    }

    public void setOnCardAnimListener(a aVar) {
        this.DCH = aVar;
    }

    static /* synthetic */ void g(TwistRoateCardsView twistRoateCardsView) {
        AppMethodBeat.i(202548);
        if (twistRoateCardsView.DCH != null) {
            twistRoateCardsView.DCH.eYV();
        }
        twistRoateCardsView.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(202540);
                if (TwistRoateCardsView.this.DCH != null) {
                    TwistRoateCardsView.this.DCH.eYT();
                }
                TwistRoateCardsView.i(TwistRoateCardsView.this);
                TwistRoateCardsView.j(TwistRoateCardsView.this);
                AppMethodBeat.o(202540);
            }
        }, 20);
        AppMethodBeat.o(202548);
    }

    static /* synthetic */ void i(TwistRoateCardsView twistRoateCardsView) {
        AppMethodBeat.i(202549);
        for (int i2 = 0; i2 < 12; i2++) {
            View childAt = twistRoateCardsView.getChildAt(i2);
            if (i2 != twistRoateCardsView.DCC) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(childAt, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(500L);
                ofFloat.start();
            }
        }
        AppMethodBeat.o(202549);
    }

    static /* synthetic */ void j(TwistRoateCardsView twistRoateCardsView) {
        AppMethodBeat.i(202550);
        View view = null;
        int i2 = 0;
        while (true) {
            if (i2 >= 12) {
                break;
            } else if (i2 == twistRoateCardsView.DCC) {
                view = twistRoateCardsView.getChildAt(i2);
                break;
            } else {
                i2++;
            }
        }
        if (!(view == null || twistRoateCardsView.DCB == null)) {
            View childAt = ((ViewGroup) view).getChildAt(0);
            View view2 = twistRoateCardsView.DCB;
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            childAt.getGlobalVisibleRect(rect);
            view2.getGlobalVisibleRect(rect2);
            int i3 = rect.bottom - rect.top;
            int i4 = rect2.bottom - (((((int) (((float) i3) / 0.75f)) - i3) / 2) + rect.bottom);
            int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(twistRoateCardsView.mContext, 40);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat((Object) null, "translationY", 0.0f, (float) fromDPToPix);
            ofFloat.setDuration(200L);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat((Object) null, "translationY", (float) fromDPToPix, (float) i4);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat((Object) null, "scaleX", 1.0f, 0.93333334f);
            ofFloat3.setDuration(200L);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat((Object) null, "scaleY", 1.0f, 0.93333334f);
            ofFloat4.setDuration(200L);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat((Object) null, "scaleX", 0.93333334f, 1.3333334f);
            ofFloat5.setDuration(300L);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat((Object) null, "scaleY", 0.93333334f, 1.3333334f);
            ofFloat6.setDuration(300L);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(ofFloat2).after(ofFloat);
            animatorSet.play(ofFloat3).with(ofFloat4);
            animatorSet.play(ofFloat5).with(ofFloat6);
            animatorSet.play(ofFloat5).after(ofFloat3);
            animatorSet.play(ofFloat).with(ofFloat3);
            animatorSet.addListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView.AnonymousClass6 */

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(202542);
                    if (TwistRoateCardsView.this.DCH != null) {
                        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView.AnonymousClass6.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(202541);
                                TwistRoateCardsView.this.DCH.eYU();
                                AppMethodBeat.o(202541);
                            }
                        }, 800);
                    }
                    AppMethodBeat.o(202542);
                }
            });
            animatorSet.setTarget(view);
            animatorSet.start();
            twistRoateCardsView.DCB.setVisibility(0);
            View view3 = twistRoateCardsView.DCB;
            Rect rect3 = new Rect();
            Rect rect4 = new Rect();
            childAt.getGlobalVisibleRect(rect3);
            view3.getGlobalVisibleRect(rect4);
            int i5 = rect4.bottom - rect4.top;
            int i6 = rect3.bottom - (rect4.bottom - ((i5 - ((int) (((float) i5) * 0.75f))) / 2));
            int fromDPToPix2 = com.tencent.mm.cb.a.fromDPToPix(twistRoateCardsView.mContext, 40) + i6;
            ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat((Object) null, "translationY", (float) i6, (float) fromDPToPix2);
            ofFloat7.setDuration(200L);
            ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat((Object) null, "translationY", (float) fromDPToPix2, 0.0f);
            ofFloat8.setDuration(300L);
            ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat((Object) null, "scaleX", 0.75f, 0.7f);
            ofFloat9.setDuration(200L);
            ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat((Object) null, "scaleY", 0.75f, 0.7f);
            ofFloat10.setDuration(200L);
            ObjectAnimator ofFloat11 = ObjectAnimator.ofFloat((Object) null, "scaleX", 0.7f, 1.0f);
            ofFloat11.setDuration(300L);
            ObjectAnimator ofFloat12 = ObjectAnimator.ofFloat((Object) null, "scaleY", 0.7f, 1.0f);
            ofFloat12.setDuration(300L);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.play(ofFloat8).after(ofFloat7);
            animatorSet2.play(ofFloat9).with(ofFloat10);
            animatorSet2.play(ofFloat11).with(ofFloat12);
            animatorSet2.play(ofFloat11).after(ofFloat9);
            animatorSet2.play(ofFloat7).with(ofFloat9);
            animatorSet2.setTarget(twistRoateCardsView.DCB);
            animatorSet2.start();
            new i(twistRoateCardsView.DCB, view, twistRoateCardsView.mContext, twistRoateCardsView.DsW).eWQ();
        }
        AppMethodBeat.o(202550);
    }
}
