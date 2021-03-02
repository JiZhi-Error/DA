package com.tencent.mm.plugin.multitalk.ui.widget;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;

public class CollapseView extends LinearLayout {
    private float dsz;
    private long duration = 200;
    private Context mContext;
    private boolean qkb = false;
    private ImageView xcA;
    private boolean zRA = false;
    private float zRB = 0.0f;
    private boolean zRC = true;
    private RelativeLayout zRq;
    private RelativeLayout zRr;
    private RelativeLayout zRs;
    private View zRt;
    private View zRu;
    private float zRv = 0.7f;
    private String zRw;
    private ImageButton zRx;
    private boolean zRy = false;
    private boolean zRz = false;

    static /* synthetic */ void a(CollapseView collapseView, View view) {
        AppMethodBeat.i(178924);
        collapseView.eu(view);
        AppMethodBeat.o(178924);
    }

    static /* synthetic */ void b(CollapseView collapseView) {
        AppMethodBeat.i(178923);
        collapseView.eoC();
        AppMethodBeat.o(178923);
    }

    public CollapseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(178913);
        this.mContext = context;
        LayoutInflater.from(this.mContext).inflate(R.layout.bcm, this);
        this.zRs = (RelativeLayout) findViewById(R.id.bed);
        this.zRr = (RelativeLayout) findViewById(R.id.dn4);
        this.xcA = (ImageView) findViewById(R.id.fjt);
        this.xcA.setBackground(ar.m(context, R.raw.icons_filled_arrow, -1));
        this.zRq = (RelativeLayout) findViewById(R.id.fk2);
        final RelativeLayout relativeLayout = this.zRq;
        final int i2 = f.zSq;
        final View view = (View) relativeLayout.getParent();
        view.post(new Runnable() {
            /* class com.tencent.mm.plugin.multitalk.ui.widget.CollapseView.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(178906);
                Rect rect = new Rect();
                relativeLayout.getHitRect(rect);
                rect.top -= i2;
                rect.bottom += i2;
                rect.left -= i2;
                rect.right += i2;
                view.setTouchDelegate(new TouchDelegate(rect, relativeLayout));
                AppMethodBeat.o(178906);
            }
        });
        this.zRq.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.multitalk.ui.widget.CollapseView.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(178905);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/multitalk/ui/widget/CollapseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (CollapseView.this.zRC) {
                    if (ac.eom().enA().emb()) {
                        p.zMu++;
                    }
                    CollapseView.this.zRC = false;
                    CollapseView.this.eoE();
                    CollapseView.b(CollapseView.this);
                }
                a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/CollapseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(178905);
            }
        });
        this.xcA.setRotation(270.0f);
        this.zRs.setVisibility(4);
        AppMethodBeat.o(178913);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(178914);
        A(motionEvent);
        AppMethodBeat.o(178914);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0089  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void A(android.view.MotionEvent r9) {
        /*
        // Method dump skipped, instructions count: 256
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.ui.widget.CollapseView.A(android.view.MotionEvent):void");
    }

    public final void am(View view, int i2) {
        AppMethodBeat.i(178916);
        Log.i("MicroMsg.CollapseView", "setContent animate:%s, controlView:%s, height:%s", Boolean.TRUE, view, Integer.valueOf(i2));
        if (this.zRt != null) {
            Log.i("MicroMsg.CollapseView", "setContent already have content layout");
            AppMethodBeat.o(178916);
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        this.zRt = view;
        this.zRs.addView(this.zRt);
        this.zRs.setVisibility(0);
        this.zRs.setVisibility(0);
        setAlpha(0.0f);
        this.zRq.setAlpha(0.0f);
        animate().alpha(1.0f).setDuration(500).setListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.plugin.multitalk.ui.widget.CollapseView.AnonymousClass3 */

            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(178908);
                CollapseView.this.zRt.post(new Runnable() {
                    /* class com.tencent.mm.plugin.multitalk.ui.widget.CollapseView.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(178907);
                        CollapseView.this.xcA.setTag(Boolean.TRUE);
                        CollapseView.this.zRx.setTag(Boolean.FALSE);
                        CollapseView.a(CollapseView.this, CollapseView.this.zRs);
                        CollapseView.this.zRq.setAlpha(0.0f);
                        CollapseView.this.zRq.animate().alpha(1.0f).setDuration(CollapseView.this.duration).start();
                        CollapseView.b(CollapseView.this);
                        if (CollapseView.this.zRw != null && !ac.eom().zMH) {
                            p.n(1, CollapseView.this.zRw, 2);
                            ac.eom().zMH = true;
                        }
                        AppMethodBeat.o(178907);
                    }
                });
                AppMethodBeat.o(178908);
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        AppMethodBeat.o(178916);
    }

    public void setRoomKey(String str) {
        this.zRw = str;
    }

    public final void setCollapseContent$53599cc9(View view) {
        AppMethodBeat.i(178917);
        Log.i("MicroMsg.CollapseView", "setCollapseContent, animate:%s, collapseView:%s", Boolean.TRUE, view);
        if (this.zRu != null) {
            Log.i("MicroMsg.CollapseView", "setCollapseContent already has collapseView");
            AppMethodBeat.o(178917);
            return;
        }
        if (((ViewGroup) view.getParent()) != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        this.zRu = view;
        this.zRr.addView(view);
        this.zRx = (ImageButton) view.findViewById(R.id.iia);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.zRx.getLayoutParams();
        layoutParams.width = f.zSu;
        layoutParams.height = f.zSu;
        layoutParams.bottomMargin = f.zSn;
        this.zRx.setLayoutParams(layoutParams);
        AppMethodBeat.o(178917);
    }

    private void eoC() {
        AppMethodBeat.i(239455);
        if (this.zRx != null) {
            if (this.zRx.getTag() == null || this.zRx.getTag().equals(Boolean.TRUE)) {
                this.zRx.setTag(Boolean.FALSE);
                final ImageButton imageButton = this.zRx;
                int i2 = f.zSu;
                imageButton.measure(i2, i2);
                final int i3 = f.zSu - f.zSq;
                AnonymousClass4 r2 = new Animation() {
                    /* class com.tencent.mm.plugin.multitalk.ui.widget.CollapseView.AnonymousClass4 */

                    /* access modifiers changed from: protected */
                    public final void applyTransformation(float f2, Transformation transformation) {
                        int i2 = -2;
                        AppMethodBeat.i(178909);
                        CollapseView.this.zRC = f2 == 1.0f;
                        imageButton.getLayoutParams().height = f2 == 1.0f ? -2 : f.zSq + ((int) (((float) i3) * f2));
                        ViewGroup.LayoutParams layoutParams = imageButton.getLayoutParams();
                        if (f2 != 1.0f) {
                            i2 = f.zSq + ((int) (((float) i3) * f2));
                        }
                        layoutParams.width = i2;
                        ((RelativeLayout.LayoutParams) imageButton.getLayoutParams()).bottomMargin = f2 == 1.0f ? f.zSn : f.zSm + ((int) (((float) (f.zSn - f.zSm)) * f2));
                        ((RelativeLayout.LayoutParams) imageButton.getLayoutParams()).topMargin = (int) (((float) f.zSm) * (1.0f - f2));
                        imageButton.requestLayout();
                        AppMethodBeat.o(178909);
                    }

                    public final boolean willChangeBounds() {
                        return true;
                    }
                };
                r2.setDuration(this.duration);
                imageButton.startAnimation(r2);
                AppMethodBeat.o(239455);
                return;
            }
            this.zRx.setTag(Boolean.TRUE);
            final ImageButton imageButton2 = this.zRx;
            final int i4 = f.zSu - f.zSq;
            AnonymousClass5 r22 = new Animation() {
                /* class com.tencent.mm.plugin.multitalk.ui.widget.CollapseView.AnonymousClass5 */

                /* access modifiers changed from: protected */
                public final void applyTransformation(float f2, Transformation transformation) {
                    AppMethodBeat.i(178910);
                    CollapseView.this.zRC = f2 == 1.0f;
                    if (imageButton2.getLayoutParams().height == f.zSq) {
                        AppMethodBeat.o(178910);
                        return;
                    }
                    if (f2 != 1.0f) {
                        imageButton2.getLayoutParams().height = f.zSu - ((int) (((float) i4) * f2));
                        imageButton2.getLayoutParams().width = f.zSu - ((int) (((float) i4) * f2));
                        int i2 = f.zSn;
                        ((RelativeLayout.LayoutParams) imageButton2.getLayoutParams()).bottomMargin = i2 - ((int) (((float) (i2 - f.zSm)) * f2));
                        ((RelativeLayout.LayoutParams) imageButton2.getLayoutParams()).topMargin = (int) (((float) f.zSm) * f2);
                        imageButton2.requestLayout();
                    }
                    AppMethodBeat.o(178910);
                }

                public final boolean willChangeBounds() {
                    return true;
                }
            };
            r22.setDuration(this.duration);
            imageButton2.startAnimation(r22);
        }
        AppMethodBeat.o(239455);
    }

    public final void eoD() {
        AppMethodBeat.i(239456);
        if (this.zRx.getTag() == null || this.zRx.getTag().equals(Boolean.TRUE)) {
            eoC();
        }
        if (this.xcA.getTag() == null || this.xcA.getTag().equals(Boolean.TRUE)) {
            eoE();
        }
        AppMethodBeat.o(239456);
    }

    public final void eoE() {
        int i2;
        AppMethodBeat.i(239457);
        if (this.xcA.getTag() == null || this.xcA.getTag().equals(Boolean.TRUE)) {
            this.xcA.setTag(Boolean.FALSE);
            i2 = 90;
            es(this.zRs);
            if (this.zRw != null) {
                p.n(2, this.zRw, 1);
            }
            p.rD(true);
        } else {
            i2 = 270;
            this.xcA.setTag(Boolean.TRUE);
            eu(this.zRs);
            if (this.zRw != null) {
                p.n(2, this.zRw, 2);
            }
            p.rD(false);
        }
        this.xcA.animate().setDuration(this.duration).rotation((float) i2);
        AppMethodBeat.o(239457);
    }

    private void eoF() {
        AppMethodBeat.i(178918);
        this.xcA.setRotation((float) ((int) (270.0f + (this.zRB * 180.0f))));
        this.xcA.setTag(Boolean.valueOf(this.zRB == 0.0f));
        this.xcA.requestLayout();
        AppMethodBeat.o(178918);
    }

    private void es(final View view) {
        AppMethodBeat.i(239458);
        view.measure(View.MeasureSpec.makeMeasureSpec(ao.az(this.mContext).x, 1073741824), View.MeasureSpec.makeMeasureSpec(1073741823, Integer.MIN_VALUE));
        final int measuredHeight = view.getMeasuredHeight();
        view.setVisibility(0);
        if (this.zRt != null) {
            this.zRt.setVisibility(4);
        }
        AnonymousClass6 r1 = new Animation() {
            /* class com.tencent.mm.plugin.multitalk.ui.widget.CollapseView.AnonymousClass6 */

            /* access modifiers changed from: protected */
            public final void applyTransformation(float f2, Transformation transformation) {
                float f3 = 1.0f;
                AppMethodBeat.i(178911);
                if (f2 == 1.0f) {
                    CollapseView.this.zRt.setVisibility(0);
                    view.getLayoutParams().height = measuredHeight;
                    CollapseView.this.qkb = true;
                } else {
                    if (f2 >= CollapseView.this.zRv) {
                        CollapseView.this.zRt.setVisibility(0);
                        View view = CollapseView.this.zRt;
                        if (((double) ((f2 - CollapseView.this.zRv) + 0.1f)) * 2.5d < 1.0d) {
                            f3 = ((f2 - CollapseView.this.zRv) + 0.1f) * 2.5f;
                        }
                        view.setAlpha(f3);
                    }
                    ((LinearLayout.LayoutParams) view.getLayoutParams()).topMargin = (int) (((float) f.zSp) * f2);
                    ((LinearLayout.LayoutParams) view.getLayoutParams()).bottomMargin = (int) (((float) f.zSh) * f2);
                    view.getLayoutParams().height = (int) (((float) measuredHeight) * f2);
                }
                view.requestLayout();
                AppMethodBeat.o(178911);
            }

            public final boolean willChangeBounds() {
                return true;
            }
        };
        r1.setDuration(this.duration);
        view.startAnimation(r1);
        AppMethodBeat.o(239458);
    }

    private void x(View view, float f2) {
        AppMethodBeat.i(178919);
        view.setVisibility(0);
        if (this.zRt != null) {
            this.zRt.setVisibility(4);
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(ao.az(this.mContext).x, 1073741824), View.MeasureSpec.makeMeasureSpec(1073741823, Integer.MIN_VALUE));
        int measuredHeight = view.getMeasuredHeight();
        float f3 = ((float) view.getLayoutParams().height) + f2;
        if (f3 >= ((float) measuredHeight)) {
            f3 = (float) measuredHeight;
        } else if (f3 <= 0.0f) {
            view.setVisibility(8);
            f3 = 0.0f;
        }
        this.zRB = f3 / ((float) measuredHeight);
        if (this.zRB >= this.zRv) {
            this.zRt.setVisibility(0);
            this.zRt.setAlpha((((double) (this.zRB - this.zRv)) + 0.1d) * 2.5d >= 1.0d ? 1.0f : ((this.zRB - this.zRv) + 0.1f) * 2.5f);
        }
        ((LinearLayout.LayoutParams) view.getLayoutParams()).topMargin = (int) (this.zRB * ((float) f.zSp));
        ((LinearLayout.LayoutParams) view.getLayoutParams()).bottomMargin = (int) (this.zRB * ((float) f.zSh));
        view.getLayoutParams().height = (int) f3;
        view.requestLayout();
        AppMethodBeat.o(178919);
    }

    private void et(View view) {
        AppMethodBeat.i(178920);
        int i2 = f.zSq + ((int) (((float) (f.zSu - f.zSq)) * this.zRB));
        view.getLayoutParams().height = i2;
        view.getLayoutParams().width = i2;
        ((RelativeLayout.LayoutParams) view.getLayoutParams()).bottomMargin = f.zSm + ((int) (((float) (f.zSn - f.zSm)) * this.zRB));
        ((RelativeLayout.LayoutParams) view.getLayoutParams()).topMargin = (int) (((float) f.zSm) * (1.0f - this.zRB));
        view.requestLayout();
        this.zRx.setTag(Boolean.valueOf(i2 != f.zSu));
        AppMethodBeat.o(178920);
    }

    private void eu(final View view) {
        AppMethodBeat.i(178921);
        view.measure(View.MeasureSpec.makeMeasureSpec(ao.az(this.mContext).x, 1073741824), View.MeasureSpec.makeMeasureSpec(1073741823, Integer.MIN_VALUE));
        final int measuredHeight = view.getMeasuredHeight();
        if (this.zRt != null) {
            this.zRt.setVisibility(0);
        }
        AnonymousClass7 r1 = new Animation() {
            /* class com.tencent.mm.plugin.multitalk.ui.widget.CollapseView.AnonymousClass7 */

            /* access modifiers changed from: protected */
            public final void applyTransformation(float f2, Transformation transformation) {
                float f3 = 1.0f;
                AppMethodBeat.i(178912);
                if (f2 == 1.0f) {
                    view.setVisibility(8);
                    CollapseView.this.qkb = false;
                } else {
                    if (f2 >= CollapseView.this.zRv && CollapseView.this.zRt != null) {
                        CollapseView.this.zRt.setVisibility(4);
                    }
                    if (CollapseView.this.zRt != null) {
                        if (((double) (1.0f - f2)) * 2.5d < 1.0d) {
                            f3 = (1.0f - f2) * 2.5f;
                        }
                        CollapseView.this.zRt.setAlpha(f3);
                    }
                    ((LinearLayout.LayoutParams) view.getLayoutParams()).topMargin = (int) (((float) f.zSp) * f2);
                    ((LinearLayout.LayoutParams) view.getLayoutParams()).bottomMargin = (int) (((float) f.zSh) * f2);
                    view.getLayoutParams().height = measuredHeight - ((int) (((float) measuredHeight) * f2));
                }
                view.requestLayout();
                AppMethodBeat.o(178912);
            }

            public final boolean willChangeBounds() {
                return true;
            }
        };
        r1.setDuration(this.duration);
        view.startAnimation(r1);
        AppMethodBeat.o(178921);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(178922);
        Log.d("MicroMsg.CollapseView", "event: " + motionEvent.getAction());
        A(motionEvent);
        AppMethodBeat.o(178922);
        return true;
    }

    public final void Rr(int i2) {
        AppMethodBeat.i(239459);
        if (this.zRx != null) {
            this.zRx.setRotation((float) (360 - i2));
        }
        AppMethodBeat.o(239459);
    }
}
