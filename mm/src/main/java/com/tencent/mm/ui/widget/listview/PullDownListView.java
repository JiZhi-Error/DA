package com.tencent.mm.ui.widget.listview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.au;
import java.util.ArrayList;

public class PullDownListView extends ListView implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemSelectedListener {
    private int Bj = 0;
    private int FSu = 0;
    private int FSv = 0;
    private boolean QRA = false;
    private boolean QRB = false;
    private float QRC = 0.05f;
    private float QRD = 0.05f;
    private float QRE = 0.0f;
    private float QRF = 0.0f;
    public boolean QRG = true;
    private View QRH;
    private View QRI;
    private int QRJ = 0;
    public IPullDownCallback QRK;
    private boolean QRL = false;
    private final int QRM = 1;
    private final int QRN = 2;
    private final int QRO = 200;
    private View QRP;
    private float QRQ = 0.0f;
    private float QRR = 0.0f;
    private boolean QRS = false;
    private boolean QRT = false;
    private boolean QRU = false;
    private float QRV;
    private float QRW = 0.0f;
    private int QRX = 0;
    private int QRY = 0;
    private boolean QRZ = false;
    private float QSa = 0.0f;
    private int QSb = 0;
    private int QSc = 0;
    private boolean QSd = false;
    private long QSe = 0;
    private long QSf = 0;
    private int QSg;
    a QSh = null;
    private AdapterView.OnItemLongClickListener QSi;
    private float aZg;
    private float aZh;
    private AdapterView.OnItemClickListener ars;
    private AdapterView.OnItemSelectedListener art;
    private View azm;
    public boolean isVisible = true;
    private int mActivePointerId = -1;
    private int mEX = 0;
    private int mEY = 0;
    private float mLastMotionY;
    private Rect mRect = new Rect();
    private boolean mbo = false;
    private Vibrator ooM;

    public interface IPullDownCallback {
        void UC(int i2);

        void UD(int i2);

        void UE(int i2);

        void eEk();

        void eEl();

        void eEm();

        void eEn();

        void onPostClose();

        void onPostOpen(boolean z);
    }

    public interface a {
        void bI(float f2);
    }

    static /* synthetic */ int e(PullDownListView pullDownListView) {
        AppMethodBeat.i(159462);
        int fuF = pullDownListView.fuF();
        AppMethodBeat.o(159462);
        return fuF;
    }

    static /* synthetic */ int f(PullDownListView pullDownListView) {
        AppMethodBeat.i(159463);
        int fuG = pullDownListView.fuG();
        AppMethodBeat.o(159463);
        return fuG;
    }

    public PullDownListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(159440);
        super.setOnItemClickListener(this);
        super.setOnItemLongClickListener(this);
        super.setOnItemSelectedListener(this);
        au.az(context);
        this.mEY = au.az(context).y;
        this.mEX = au.az(context).x;
        this.ooM = (Vibrator) getContext().getSystemService("vibrator");
        post(new Runnable() {
            /* class com.tencent.mm.ui.widget.listview.PullDownListView.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(159434);
                as.d("MicroMsg.PullDownListView", "mThis.getLeft()=%s, mThis.getTop()=%s, mThis.getRight()=%s, mThis.getBottom()=%s", Integer.valueOf(PullDownListView.this.QRH.getLeft()), Integer.valueOf(PullDownListView.this.QRH.getTop()), Integer.valueOf(PullDownListView.this.QRH.getRight()), Integer.valueOf(PullDownListView.this.QRH.getBottom()));
                PullDownListView.this.mRect.set(PullDownListView.this.QRH.getLeft(), PullDownListView.this.QRH.getTop(), PullDownListView.this.QRH.getRight(), PullDownListView.this.QRH.getBottom());
                AppMethodBeat.o(159434);
            }
        });
        AppMethodBeat.o(159440);
    }

    public void setSupportOverscroll(boolean z) {
        this.QRA = z;
    }

    public void setNeedHover(boolean z) {
        this.QRB = z;
    }

    public void setTabView(View view) {
        this.azm = view;
    }

    public void setMuteView(final View view) {
        AppMethodBeat.i(159441);
        if (view != null) {
            post(new Runnable() {
                /* class com.tencent.mm.ui.widget.listview.PullDownListView.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(159433);
                    if (PullDownListView.this.QRI != null) {
                        PullDownListView.this.QRE = (float) (-PullDownListView.this.QRI.getWidth());
                        PullDownListView.this.QRF = (float) PullDownListView.this.QRI.getHeight();
                        PullDownListView.this.QRI.setVisibility(8);
                    }
                    view.bringToFront();
                    AppMethodBeat.o(159433);
                }
            });
        } else {
            this.QRE = 0.0f;
            this.QRF = 0.0f;
        }
        this.QRI = view;
        AppMethodBeat.o(159441);
    }

    public void setNavigationBarHeight(int i2) {
        AppMethodBeat.i(159442);
        as.i("MicroMsg.PullDownListView", "setNavigationBarHeight=%s", Integer.valueOf(i2));
        this.QRJ = i2;
        AppMethodBeat.o(159442);
    }

    public final void y(View view, int i2, int i3) {
        this.QRP = view;
        this.QRY = i2;
        this.QRX = i3;
        this.FSv = 0;
        this.FSu = 0;
    }

    private int fuF() {
        if (this.FSu == 0) {
            this.FSu = (int) (((float) this.mEY) * this.QRC);
        }
        return this.FSu;
    }

    private int fuG() {
        if (this.FSv == 0) {
            this.FSv = (int) (((float) (this.mEY - this.QRY)) * (1.0f - this.QRD));
        }
        return this.FSv;
    }

    /* access modifiers changed from: protected */
    @TargetApi(11)
    public void onFinishInflate() {
        AppMethodBeat.i(159443);
        this.QRH = this;
        this.QRV = getTranslationY();
        as.d("MicroMsg.PullDownListView", "onFinishInflate %s %s %s %s", Integer.valueOf(this.QRH.getLeft()), Integer.valueOf(this.QRH.getTop()), Integer.valueOf(this.QRH.getRight()), Integer.valueOf(this.QRH.getBottom()));
        AppMethodBeat.o(159443);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(159444);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(159444);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0140  */
    @android.annotation.TargetApi(11)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r14) {
        /*
        // Method dump skipped, instructions count: 1766
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.widget.listview.PullDownListView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setTranslationListener(a aVar) {
        this.QSh = aVar;
    }

    public void setTranslationY(float f2) {
        AppMethodBeat.i(198354);
        super.setTranslationY(f2);
        if (this.QSh != null) {
            this.QSh.bI(f2);
        }
        AppMethodBeat.o(198354);
    }

    private void hbS() {
        AppMethodBeat.i(159446);
        if (this.QRI != null) {
            float translationX = this.QRI.getTranslationX();
            float translationY = this.QRI.getTranslationY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.QRI, "translationX", translationX, this.QRE);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.QRI, "translationY", translationY, this.QRF);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.addListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.ui.widget.listview.PullDownListView.AnonymousClass3 */

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(159435);
                    if (PullDownListView.this.QRI != null) {
                        PullDownListView.this.QRI.setVisibility(8);
                    }
                    AppMethodBeat.o(159435);
                }

                public final void onAnimationCancel(Animator animator) {
                    AppMethodBeat.i(159436);
                    if (PullDownListView.this.QRI != null) {
                        PullDownListView.this.QRI.setVisibility(8);
                    }
                    AppMethodBeat.o(159436);
                }
            });
            animatorSet.start();
        }
        AppMethodBeat.o(159446);
    }

    private void P(final int i2, final int i3, final boolean z) {
        AppMethodBeat.i(159447);
        as.i("MicroMsg.PullDownListView", "story_cat animation: %s %s %s %s %s %s %s %s start:%s, end:%s, openLimitPx():%s, closeLimitPx():%s, isMute:%s", Integer.valueOf(this.mRect.left), Integer.valueOf(this.mRect.top), Integer.valueOf(this.mRect.right), Integer.valueOf(this.mRect.bottom), Integer.valueOf(getLeft()), Integer.valueOf(getTop()), Integer.valueOf(getRight()), Integer.valueOf(getBottom()), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(fuF()), Integer.valueOf(fuG()), Boolean.valueOf(z));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this, "translationY", (float) i2, (float) i3));
        if (this.azm != null && i2 > fuF() && i2 < fuG()) {
            if (i3 != 0) {
                arrayList.add(ObjectAnimator.ofFloat(this.azm, "translationY", (float) i2, (float) i3));
            } else {
                arrayList.add(ObjectAnimator.ofFloat(this.azm, "translationY", (float) i2, (float) (i3 - this.QRJ)));
            }
        }
        if (this.QRP != null) {
            if (i3 >= getBottom()) {
                arrayList.add(lI(((ViewGroup.MarginLayoutParams) this.QRP.getLayoutParams()).topMargin, 0));
            } else {
                arrayList.add(lI(((ViewGroup.MarginLayoutParams) this.QRP.getLayoutParams()).topMargin, this.QRX));
            }
        }
        animatorSet.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.ui.widget.listview.PullDownListView.AnonymousClass4 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(159437);
                as.i("MicroMsg.PullDownListView", "onAnimationStart start:%s, openLimitPx():%s, closeLimitPx():%s", Integer.valueOf(i2), Integer.valueOf(PullDownListView.e(PullDownListView.this)), Integer.valueOf(PullDownListView.f(PullDownListView.this)));
                PullDownListView.this.QRS = true;
                if (i3 == 0) {
                    PullDownListView.this.isVisible = true;
                } else {
                    PullDownListView.this.isVisible = false;
                }
                if (PullDownListView.this.QRK != null && i2 > PullDownListView.e(PullDownListView.this) && i2 < PullDownListView.f(PullDownListView.this)) {
                    if (PullDownListView.this.isVisible) {
                        PullDownListView.this.QRK.eEl();
                        AppMethodBeat.o(159437);
                        return;
                    }
                    PullDownListView.this.QRK.eEk();
                }
                AppMethodBeat.o(159437);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(159438);
                as.i("MicroMsg.PullDownListView", "onAnimationEnd start:%s, openLimitPx():%s, closeLimitPx():%s", Integer.valueOf(i2), Integer.valueOf(PullDownListView.e(PullDownListView.this)), Integer.valueOf(PullDownListView.f(PullDownListView.this)));
                PullDownListView.this.mbo = false;
                PullDownListView.this.QRS = false;
                PullDownListView.this.QRT = false;
                PullDownListView.this.QRU = false;
                if (PullDownListView.this.QRK != null && i2 > PullDownListView.e(PullDownListView.this) && i2 < PullDownListView.f(PullDownListView.this)) {
                    if (PullDownListView.this.isVisible) {
                        PullDownListView.this.QRK.onPostClose();
                        if (PullDownListView.this.azm != null) {
                            AppMethodBeat.o(159438);
                            return;
                        }
                    } else {
                        PullDownListView.this.QRK.onPostOpen(z);
                    }
                }
                AppMethodBeat.o(159438);
            }
        });
        animatorSet.playTogether(arrayList);
        animatorSet.start();
        hbT();
        AppMethodBeat.o(159447);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(159448);
        super.onLayout(z, i2, i3, i4, i5);
        AppMethodBeat.o(159448);
    }

    @TargetApi(11)
    private void hbT() {
        AppMethodBeat.i(159449);
        this.Bj = 0;
        as.d("MicroMsg.PullDownListView", "startAnimation %s %s %s %s", Integer.valueOf(this.QRH.getLeft()), Integer.valueOf(this.QRH.getTop()), Integer.valueOf(this.QRH.getRight()), Integer.valueOf(this.QRH.getBottom()));
        AppMethodBeat.o(159449);
    }

    private boolean hbU() {
        AppMethodBeat.i(159450);
        if (this.mRect.isEmpty() || Math.abs(this.Bj) <= 0) {
            AppMethodBeat.o(159450);
            return false;
        }
        AppMethodBeat.o(159450);
        return true;
    }

    private int apm(int i2) {
        AppMethodBeat.i(159451);
        int abs = (int) Math.abs((((float) i2) / ((float) this.mEY)) * ((float) this.QRX));
        as.d("MicroMsg.PullDownListView", "offset:%s,  ((float) offset / screenHeight):%s,  Math.abs(mCoordinationAnimThreshold):%s,  result:%s", Integer.valueOf(i2), Float.valueOf(((float) i2) / ((float) this.mEY)), Integer.valueOf(Math.abs(this.QRX)), Integer.valueOf(abs));
        AppMethodBeat.o(159451);
        return abs;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009a, code lost:
        if (r3 < ((float) (r9.QRI.getBottom() + r9.QRJ))) goto L_0x0067;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean ax(android.view.MotionEvent r10) {
        /*
        // Method dump skipped, instructions count: 160
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.widget.listview.PullDownListView.ax(android.view.MotionEvent):boolean");
    }

    private void hbV() {
        AppMethodBeat.i(159453);
        if (this.QRI != null) {
            this.QRI.setVisibility(8);
        }
        AppMethodBeat.o(159453);
    }

    private void hbW() {
        AppMethodBeat.i(159454);
        if (this.QRI != null) {
            this.QRI.setTranslationX(this.QRE);
            this.QRI.setTranslationY(this.QRF);
            this.QRI.setVisibility(8);
        }
        AppMethodBeat.o(159454);
    }

    private ValueAnimator lI(int i2, int i3) {
        AppMethodBeat.i(159455);
        as.d("MicroMsg.PullDownListView", "startStoryGalleryOpenAnim start:%s, end:%s", Integer.valueOf(i2), Integer.valueOf(i3));
        ValueAnimator ofInt = ValueAnimator.ofInt(i2, i3);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.ui.widget.listview.PullDownListView.AnonymousClass5 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(159439);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) PullDownListView.this.QRP.getLayoutParams();
                marginLayoutParams.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                PullDownListView.this.QRP.setLayoutParams(marginLayoutParams);
                AppMethodBeat.o(159439);
            }
        });
        AppMethodBeat.o(159455);
        return ofInt;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.ars = onItemClickListener;
    }

    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.QSi = onItemLongClickListener;
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.art = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        AppMethodBeat.i(159456);
        if (this.ars != null && !this.mbo && (this.isVisible || this.QRB)) {
            this.QRL = true;
            this.ars.onItemClick(adapterView, view, i2, j2);
        }
        AppMethodBeat.o(159456);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        AppMethodBeat.i(159457);
        b bVar = new b();
        bVar.bm(adapterView);
        bVar.bm(view);
        bVar.pH(i2);
        bVar.zo(j2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/listview/PullDownListView", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
        if (this.art != null && !this.mbo && (this.isVisible || this.QRB)) {
            this.QRL = true;
            this.art.onItemSelected(adapterView, view, i2, j2);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/listview/PullDownListView", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(159457);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        AppMethodBeat.i(159458);
        if (this.art != null) {
            this.art.onNothingSelected(adapterView);
        }
        AppMethodBeat.o(159458);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        AppMethodBeat.i(159459);
        if (this.QSi == null || (!this.isVisible && !this.QRB)) {
            AppMethodBeat.o(159459);
            return false;
        }
        this.QRL = true;
        boolean onItemLongClick = this.QSi.onItemLongClick(adapterView, view, i2, j2);
        AppMethodBeat.o(159459);
        return onItemLongClick;
    }

    public final void hbX() {
        AppMethodBeat.i(159460);
        as.i("MicroMsg.PullDownListView", "switchNormalStatus", new Object[0]);
        if (!this.isVisible) {
            if (this.QRB) {
                P((int) (((float) this.mEX) * 0.6666667f * (1.0f - this.QRD)), 0, false);
                AppMethodBeat.o(159460);
                return;
            }
            P(fuG() - 1, 0, false);
        }
        AppMethodBeat.o(159460);
    }

    public final void hbY() {
        AppMethodBeat.i(159461);
        as.i("MicroMsg.PullDownListView", "switchPullDownStatus", new Object[0]);
        if (this.isVisible) {
            if (this.QRB) {
                P(fuF() + 1, (int) (((float) this.mEX) * 0.6666667f), false);
                AppMethodBeat.o(159461);
                return;
            }
            P(fuF() + 1, this.QRH.getBottom() + this.QRJ, false);
        }
        AppMethodBeat.o(159461);
    }
}
