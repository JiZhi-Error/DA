package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.MessageQueue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.h.b;
import com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.multitask.ui.bg.DynamicBgContainer;
import com.tencent.mm.plugin.multitask.ui.uic.MultiTaskUIC;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.ChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUIProxy;
import com.tencent.mm.ui.conversation.MainUI;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.widget.h;

public class NewChattingTabUI implements LauncherUI.a {
    MMFragmentActivity Dpx;
    LauncherUI.b OJE;
    long OJF = 0;
    private TestTimeForChatting OJG;
    private int OJH;
    MessageQueue.IdleHandler OJI;
    private OnLayoutChangedLinearLayout OJJ;
    String OJK;
    private String OJL;
    private Bundle OJM;
    BaseChattingUIFragment OJN;
    private long OJO;
    a OJP = new a(this, (byte) 0);
    boolean OJQ = false;
    boolean isAnimating = false;
    boolean mChattingClosed = true;
    Animation mChattingInAnim;
    private Animation mChattingOutAnim;
    private IChattingUIProxy mChattingUIProxy;
    private boolean mNeedChattingAnim;
    Bitmap mPrepareBitmap;
    Runnable mStartChattingRunnable = new Runnable() {
        /* class com.tencent.mm.ui.NewChattingTabUI.AnonymousClass6 */

        public final void run() {
            boolean isShown;
            AppMethodBeat.i(232691);
            if (!NewChattingTabUI.this.mChattingClosed) {
                Log.e("MicroMsg.LauncherUI.NewChattingTabUI", "start chatting but last chatting does't be close!");
                NewChattingTabUI.this.Bq(false);
            }
            if (NewChattingTabUI.this.Dpx.isFinishing() || NewChattingTabUI.this.Dpx.isPaused() || !NewChattingTabUI.this.mChattingClosed) {
                Log.w("MicroMsg.LauncherUI.NewChattingTabUI", "[mStartChattingRunnable] pass! isPause:%s mChattingClosed:%s", Boolean.valueOf(NewChattingTabUI.this.Dpx.isPaused()), Boolean.valueOf(NewChattingTabUI.this.mChattingClosed));
                NewChattingTabUI.this.OJQ = true;
                AppMethodBeat.o(232691);
                return;
            }
            NewChattingTabUI.this.mChattingClosed = false;
            Object[] objArr = new Object[1];
            if (NewChattingTabUI.this.OJG == null) {
                isShown = false;
            } else {
                isShown = NewChattingTabUI.this.OJG.isShown();
            }
            objArr[0] = Boolean.valueOf(isShown);
            Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest::startChatting, ishow:%b", objArr);
            Intent putExtra = new Intent().putExtra("Chat_User", NewChattingTabUI.this.OJL);
            if (NewChattingTabUI.this.OJM != null) {
                putExtra.putExtras(NewChattingTabUI.this.OJM);
            }
            putExtra.putExtra("img_gallery_enter_from_chatting_ui", true);
            NewChattingTabUI.a(NewChattingTabUI.this, putExtra, false);
            NewChattingTabUI.this.OJJ.setOnChattingLayoutChangedListener(NewChattingTabUI.this.onChattingLayoutChangedListener);
            NewChattingTabUI.this.OJG.setVisibility(0);
            NewChattingTabUI.this.OJG.setTranslationX((NewChattingTabUI.this.Dpx.getWindow().getDecorView().getWidth() == 0 ? (float) NewChattingTabUI.this.Dpx.getResources().getDisplayMetrics().widthPixels : (float) NewChattingTabUI.this.Dpx.getWindow().getDecorView().getWidth()) - 0.1f);
            NewChattingTabUI.this.OJF = Util.nowSecond();
            NewChattingTabUI.r(NewChattingTabUI.this);
            if (NewChattingTabUI.s(NewChattingTabUI.this)) {
                h.a(NewChattingTabUI.this.Dpx);
            }
            AppMethodBeat.o(232691);
        }

        public final String toString() {
            AppMethodBeat.i(232692);
            String str = super.toString() + "|startChattingRunnable";
            AppMethodBeat.o(232692);
            return str;
        }
    };
    private OnLayoutChangedLinearLayout.a onChattingLayoutChangedListener = new OnLayoutChangedLinearLayout.a() {
        /* class com.tencent.mm.ui.NewChattingTabUI.AnonymousClass7 */
        long start = 0;

        @Override // com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a
        public final void gJw() {
            AppMethodBeat.i(232696);
            if (NewChattingTabUI.this.mChattingInAnim == null) {
                NewChattingTabUI.this.mChattingInAnim = AnimationUtils.loadAnimation(NewChattingTabUI.this.Dpx, MMFragmentActivity.a.ogm);
                NewChattingTabUI.this.mChattingInAnim.setAnimationListener(new Animation.AnimationListener() {
                    /* class com.tencent.mm.ui.NewChattingTabUI.AnonymousClass7.AnonymousClass1 */

                    public final void onAnimationStart(Animation animation) {
                        AppMethodBeat.i(232693);
                        NewChattingTabUI.u(NewChattingTabUI.this);
                        NewChattingTabUI.this.ac(false, 0);
                        AppMethodBeat.o(232693);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(232694);
                        NewChattingTabUI.v(NewChattingTabUI.this);
                        AppMethodBeat.o(232694);
                    }
                });
            }
            if (NewChattingTabUI.this.mNeedChattingAnim) {
                NewChattingTabUI.this.OJG.setOndispatchDraw(new TestTimeForChatting.a() {
                    /* class com.tencent.mm.ui.NewChattingTabUI.AnonymousClass7.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.tools.TestTimeForChatting.a
                    public final void gJx() {
                        AppMethodBeat.i(232695);
                        Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onDrawed]");
                        AnonymousClass7.this.start = System.currentTimeMillis();
                        if (NewChattingTabUI.this.OJN.getSwipeBackLayout() != null) {
                            NewChattingTabUI.this.OJN.getSwipeBackLayout().setNeedChangeWindowBackground(false);
                            NewChattingTabUI.this.OJN.getSwipeBackLayout().startAnimation(NewChattingTabUI.this.mChattingInAnim);
                        } else {
                            NewChattingTabUI.this.OJN.getView().startAnimation(NewChattingTabUI.this.mChattingInAnim);
                        }
                        NewChattingTabUI.this.OJG.setOndispatchDraw(null);
                        AppMethodBeat.o(232695);
                    }
                });
                NewChattingTabUI.this.mNeedChattingAnim = false;
            } else {
                NewChattingTabUI.u(NewChattingTabUI.this);
                NewChattingTabUI.v(NewChattingTabUI.this);
            }
            NewChattingTabUI.this.OJJ.OWo = null;
            Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "klem CHATTING ONLAYOUT ");
            AppMethodBeat.o(232696);
        }
    };

    static /* synthetic */ int h(NewChattingTabUI newChattingTabUI) {
        AppMethodBeat.i(33669);
        int topHeight = newChattingTabUI.getTopHeight();
        AppMethodBeat.o(33669);
        return topHeight;
    }

    static /* synthetic */ void r(NewChattingTabUI newChattingTabUI) {
        AppMethodBeat.i(33671);
        newChattingTabUI.pl(3);
        AppMethodBeat.o(33671);
    }

    static /* synthetic */ boolean s(NewChattingTabUI newChattingTabUI) {
        AppMethodBeat.i(33672);
        boolean gJv = newChattingTabUI.gJv();
        AppMethodBeat.o(33672);
        return gJv;
    }

    static /* synthetic */ void y(NewChattingTabUI newChattingTabUI) {
        AppMethodBeat.i(33675);
        newChattingTabUI.tryResetChattingSwipeStatus();
        AppMethodBeat.o(33675);
    }

    public NewChattingTabUI(LauncherUI.b bVar) {
        AppMethodBeat.i(33655);
        this.OJE = bVar;
        AppMethodBeat.o(33655);
    }

    public final void gHP() {
        AppMethodBeat.i(232701);
        if (gIx()) {
            pl(4);
            if (this.OJN != null && this.OJN.isSupportNavigationSwipeBack()) {
                this.OJN.getSwipeBackLayout().setEnableGesture(false);
            }
        }
        AppMethodBeat.o(232701);
    }

    public final void startChatting(String str, Bundle bundle, boolean z) {
        boolean isShown;
        AppMethodBeat.i(33656);
        this.OJO = System.currentTimeMillis();
        Object[] objArr = new Object[3];
        if (this.OJG == null) {
            isShown = false;
        } else {
            isShown = this.OJG.isShown();
        }
        objArr[0] = Boolean.valueOf(isShown);
        objArr[1] = str;
        objArr[2] = Boolean.valueOf(z);
        Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "try startChatting, ishow:%b userName:%s needAnim:%b", objArr);
        if (!(this.OJN == null || this.OJN.getView() == null)) {
            this.OJN.getView().setImportantForAccessibility(1);
        }
        bg.getNotification().dh(false);
        this.OJQ = false;
        this.OJM = bundle;
        this.OJL = str;
        this.mNeedChattingAnim = z;
        if (!ao.gJN() || (!ao.gJL() && !ao.gJM() && !ao.gJK())) {
            bg.aAk().setLowestPriority();
            MMHandlerThread.setCurrentPriority(-8);
            MMHandlerThread.removeRunnable(this.mStartChattingRunnable);
            MMHandlerThread.postToMainThread(this.mStartChattingRunnable);
            AppMethodBeat.o(33656);
            return;
        }
        Intent intent = new Intent(this.Dpx, ChattingUI.class);
        intent.putExtra("Chat_User", this.OJL);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        MMFragmentActivity mMFragmentActivity = this.Dpx;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(mMFragmentActivity, bl.axQ(), "com/tencent/mm/ui/NewChattingTabUI", "startChatting", "(Ljava/lang/String;Landroid/os/Bundle;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        mMFragmentActivity.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(mMFragmentActivity, "com/tencent/mm/ui/NewChattingTabUI", "startChatting", "(Ljava/lang/String;Landroid/os/Bundle;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(33656);
    }

    class a implements Runnable {
        int OJY;
        Intent dQs;
        int requestCode;
        int resultCode;

        private a() {
            this.OJY = 0;
        }

        /* synthetic */ a(NewChattingTabUI newChattingTabUI, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(33653);
            if (bg.aAc() && NewChattingTabUI.this.Dpx != null) {
                Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "on post select image job, acc has ready, retry count %d", Integer.valueOf(this.OJY));
                NewChattingTabUI.this.startChatting(NewChattingTabUI.this.OJK, null, false);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.ui.NewChattingTabUI.a.AnonymousClass1 */

                    public final void run() {
                        boolean z = true;
                        AppMethodBeat.i(33651);
                        Object[] objArr = new Object[1];
                        if (NewChattingTabUI.this.OJN != null) {
                            z = false;
                        }
                        objArr[0] = Boolean.valueOf(z);
                        Log.d("MicroMsg.LauncherUI.NewChattingTabUI", "on select image ActivityResult. after creat chattingUI, chatting fragment is null? %B", objArr);
                        if (NewChattingTabUI.this.OJN != null) {
                            Log.d("MicroMsg.LauncherUI.NewChattingTabUI", "on select image ActivityResult. do post activity result");
                            NewChattingTabUI.this.OJN.onActivityResult(a.this.requestCode & 65535, a.this.resultCode, a.this.dQs);
                        }
                        AppMethodBeat.o(33651);
                    }

                    public final String toString() {
                        AppMethodBeat.i(33652);
                        String str = super.toString() + "|PostSelectImageJob_onActivityResult";
                        AppMethodBeat.o(33652);
                        return str;
                    }
                });
                AppMethodBeat.o(33653);
            } else if (this.OJY >= 3) {
                Log.w("MicroMsg.LauncherUI.NewChattingTabUI", "on post select image job, match max retry count");
                AppMethodBeat.o(33653);
            } else {
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(NewChattingTabUI.this.Dpx != null);
                objArr[1] = Integer.valueOf(this.OJY);
                Log.w("MicroMsg.LauncherUI.NewChattingTabUI", "on post select image job, acc not ready or view init(%B), cur retry count %d", objArr);
                this.OJY++;
                MMHandlerThread.postToMainThreadDelayed(this, 300);
                AppMethodBeat.o(33653);
            }
        }

        public final String toString() {
            AppMethodBeat.i(33654);
            String str = super.toString() + "|PostSelectImageJob";
            AppMethodBeat.o(33654);
            return str;
        }
    }

    static boolean acceptRequestCode(int i2) {
        AppMethodBeat.i(33657);
        int i3 = 65535 & i2;
        Log.w("MicroMsg.LauncherUI.NewChattingTabUI", "check request code %d", Integer.valueOf(i3));
        switch (i3) {
            case 217:
            case 218:
            case 226:
                AppMethodBeat.o(33657);
                return true;
            default:
                AppMethodBeat.o(33657);
                return false;
        }
    }

    @Override // com.tencent.mm.ui.LauncherUI.a
    public final boolean gIx() {
        if (this.OJN == null) {
            return false;
        }
        return this.OJN.dom.cQp;
    }

    /* access modifiers changed from: package-private */
    public final void pl(final int i2) {
        AppMethodBeat.i(33661);
        if (this.OJN == null) {
            AppMethodBeat.o(33661);
            return;
        }
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.ui.NewChattingTabUI.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(33641);
                d.d(i2, "ChattingUI" + NewChattingTabUI.i(NewChattingTabUI.this), hashCode());
                if (i2 == 4) {
                    d.m("ChattingUI" + NewChattingTabUI.i(NewChattingTabUI.this), NewChattingTabUI.this.OJF, Util.nowSecond());
                }
                AppMethodBeat.o(33641);
            }
        }, "MicroMsg.LauncherUI.NewChattingTabUI|report");
        AppMethodBeat.o(33661);
    }

    private Bitmap getMagicDrawingCache(View view) {
        AppMethodBeat.i(33662);
        long currentTimeMillis = System.currentTimeMillis();
        int width = view.getWidth();
        int height = view.getHeight();
        if (width <= 0) {
            width = view.getMeasuredWidth();
        }
        if (height <= 0) {
            height = view.getMeasuredHeight();
        }
        if (width <= 0 || height <= 0) {
            Log.e("MicroMsg.LauncherUI.NewChattingTabUI", "viewWidth:%s viewHeight:%s", Integer.valueOf(width), Integer.valueOf(height));
            AppMethodBeat.o(33662);
            return null;
        } else if (this.OJN.getView() == null) {
            AppMethodBeat.o(33662);
            return null;
        } else {
            if (this.OJN != null) {
                Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "getBottom:%s keyboardState:%s", Integer.valueOf(this.OJN.getView().getBottom()), Integer.valueOf(this.OJN.keyboardState()));
            }
            if (this.OJN == null || this.OJN.getView().getBottom() <= 0 || (this.OJN.keyboardState() != 1 && this.OJN.getView().getBottom() >= (this.Dpx.getResources().getDisplayMetrics().heightPixels * 2) / 3)) {
                if (this.mPrepareBitmap == null || this.mPrepareBitmap.isRecycled() || this.mPrepareBitmap.getWidth() != width || this.mPrepareBitmap.getHeight() != height) {
                    if (this.mPrepareBitmap != null && !this.mPrepareBitmap.isRecycled()) {
                        Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "bitmap recycle %s", this.mPrepareBitmap.toString());
                        this.mPrepareBitmap.recycle();
                    }
                    try {
                        this.mPrepareBitmap = BitmapUtil.createBitmap(width, height, Bitmap.Config.ARGB_4444);
                        if (this.mPrepareBitmap == null) {
                            AppMethodBeat.o(33662);
                            return null;
                        }
                    } catch (OutOfMemoryError e2) {
                        Log.e("MicroMsg.LauncherUI.NewChattingTabUI", "[getMagicDrawingCache] e:%s", e2);
                        AppMethodBeat.o(33662);
                        return null;
                    }
                }
                view.draw(new Canvas(this.mPrepareBitmap));
                Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[getMagicDrawingCache] cost%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                Bitmap bitmap = this.mPrepareBitmap;
                AppMethodBeat.o(33662);
                return bitmap;
            }
            Log.e("MicroMsg.LauncherUI.NewChattingTabUI", "hardKeyboardHidden:%s", Integer.valueOf(this.OJN.keyboardState()));
            this.Dpx.getWindow().setBackgroundDrawableResource(R.color.a5p);
            AppMethodBeat.o(33662);
            return null;
        }
    }

    public final boolean Bq(boolean z) {
        ImageView imageView;
        AppMethodBeat.i(33663);
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.OJG == null ? false : this.OJG.isShown());
        Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "try closeChatting, ishow:%b", objArr);
        if (!(this.OJN == null || this.OJN.getView() == null)) {
            this.OJN.getView().setImportantForAccessibility(4);
        }
        if (this.OJG == null || this.OJG.getVisibility() == 8 || this.OJN == null || this.Dpx == null) {
            AppMethodBeat.o(33663);
            return false;
        }
        if (this.OJN != null && this.OJN.isSupportNavigationSwipeBack()) {
            h.b(this.Dpx);
        }
        Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[closeChatting] needAnim:%b", Boolean.valueOf(z));
        pl(4);
        this.mChattingClosed = true;
        if (z && this.mChattingOutAnim == null) {
            this.mChattingOutAnim = AnimationUtils.loadAnimation(this.Dpx, MMFragmentActivity.a.ogp);
            this.mChattingOutAnim.setAnimationListener(new Animation.AnimationListener() {
                /* class com.tencent.mm.ui.NewChattingTabUI.AnonymousClass8 */

                public final void onAnimationStart(Animation animation) {
                    AppMethodBeat.i(232697);
                    NewChattingTabUI.this.isAnimating = true;
                    bg.aAk().setLowestPriority();
                    MMHandlerThread.setCurrentPriority(-8);
                    NewChattingTabUI.this.ac(true, 0);
                    Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "klem pop out onAnimationStart");
                    AppMethodBeat.o(232697);
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(232698);
                    NewChattingTabUI.this.isAnimating = false;
                    NewChattingTabUI.this.OJG.setVisibility(8);
                    bg.aAk().setLowPriority();
                    MMHandlerThread.setCurrentPriority(0);
                    NewChattingTabUI.y(NewChattingTabUI.this);
                    Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "klem pop out onAnimationEnd");
                    AppMethodBeat.o(232698);
                }
            });
        }
        aa.d(true, new Intent().putExtra("classname", "mainui").putExtra("main_process", false));
        if (this.OJN.isSupportCustomActionBar() && (imageView = (ImageView) this.Dpx.getWindow().getDecorView().findViewById(R.id.gga)) != null && imageView.getVisibility() == 0) {
            imageView.setVisibility(8);
            Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[closeChatting] prepareView GONE");
        }
        alj(0);
        if (z) {
            this.mChattingUIProxy.onExitBegin();
            this.mChattingUIProxy.onExitEnd();
            this.OJG.startAnimation(this.mChattingOutAnim);
        } else {
            this.mChattingUIProxy.onExitBegin();
            this.mChattingUIProxy.onExitEnd();
            this.OJG.setVisibility(8);
            this.Dpx.onSwipe(1.0f);
            tryResetChattingSwipeStatus();
        }
        AppMethodBeat.o(33663);
        return true;
    }

    private void tryResetChattingSwipeStatus() {
        boolean z = true;
        AppMethodBeat.i(33664);
        if (!gJv()) {
            AppMethodBeat.o(33664);
            return;
        }
        Object[] objArr = new Object[1];
        if (this.OJN != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest: tryResetChattingSwipeStatus, chattingFragment NULL ? %B", objArr);
        if (this.OJN != null) {
            this.OJN.getSwipeBackLayout().hfx = false;
        }
        AppMethodBeat.o(33664);
    }

    public final boolean ac(boolean z, int i2) {
        AppMethodBeat.i(33665);
        Log.v("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest: on settle %B, speed %d, resumeStatus %s", Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(this.OJE.gHZ()));
        if (!gJv()) {
            AppMethodBeat.o(33665);
            return true;
        }
        if (z) {
            this.OJE.gIc();
        }
        if (!this.OJE.gHZ()) {
            AppMethodBeat.o(33665);
            return false;
        }
        View findViewById = this.Dpx.findViewById(R.id.e8x);
        if (findViewById == null) {
            Log.e("MicroMsg.LauncherUI.NewChattingTabUI", "[onSettle] null == container");
            AppMethodBeat.o(33665);
            return true;
        }
        ImageView imageView = (ImageView) this.Dpx.findViewById(R.id.gga);
        if (!(imageView == null || imageView.getVisibility() != 8 || imageView.getDrawable() == null)) {
            imageView.setVisibility(0);
            Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSettle] prepareView VISIBLE");
            findViewById.setVisibility(8);
        }
        if (imageView == null || imageView.getVisibility() != 0) {
            int width = findViewById.getWidth() == 0 ? this.Dpx.getResources().getDisplayMetrics().widthPixels : findViewById.getWidth();
            if (z) {
                j.a(findViewById, 182, 0.0f, null);
            } else {
                j.a(findViewById, 208, ((float) (width * -1)) / 3.5f, null);
            }
        } else {
            int width2 = imageView.getWidth() == 0 ? this.Dpx.getResources().getDisplayMetrics().widthPixels : imageView.getWidth();
            if (z) {
                j.a(imageView, 182, 0.0f, null);
            } else {
                j.a(imageView, 208, ((float) (width2 * -1)) / 3.5f, null);
            }
        }
        AppMethodBeat.o(33665);
        return true;
    }

    static void resetViewTranX(View view, ImageView imageView, float f2) {
        AppMethodBeat.i(33666);
        if (Float.compare(1.0f, f2) <= 0) {
            j.q(view, 0.0f);
            j.q(imageView, 0.0f);
            AppMethodBeat.o(33666);
        } else if (imageView == null || imageView.getDrawable() == null) {
            if (view != null) {
                j.q(view, (((float) view.getWidth()) / 2.5f) * (1.0f - f2) * -1.0f);
            }
            AppMethodBeat.o(33666);
        } else {
            j.q(imageView, (((float) imageView.getWidth()) / 2.5f) * (1.0f - f2) * -1.0f);
            AppMethodBeat.o(33666);
        }
    }

    /* access modifiers changed from: package-private */
    public final void alj(int i2) {
        AppMethodBeat.i(33667);
        Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[setLauncherContainerVisible] visible:%s", Integer.valueOf(i2));
        if (this.Dpx == null) {
            Log.e("MicroMsg.LauncherUI.NewChattingTabUI", "[setLauncherContainerVisible] getActivity is null");
            AppMethodBeat.o(33667);
            return;
        }
        View findViewById = this.Dpx.findViewById(R.id.e8x);
        if (!(findViewById == null || findViewById.getVisibility() == i2)) {
            findViewById.setVisibility(i2);
        }
        AppMethodBeat.o(33667);
    }

    private int getTopHeight() {
        boolean z;
        boolean z2;
        int i2;
        AppMethodBeat.i(33658);
        int statusBarHeight = au.getStatusBarHeight(this.Dpx);
        if (Build.VERSION.SDK_INT < 24 || LauncherUI.getInstance() == null) {
            z = false;
        } else {
            z = LauncherUI.getInstance().isInMultiWindowMode();
        }
        if (!z) {
            SharedPreferences defaultPreference = MMApplicationContext.getDefaultPreference();
            if (defaultPreference != null) {
                z2 = defaultPreference.getBoolean("Main_need_read_top_margin", false);
            } else {
                z2 = false;
            }
            if (z2 && (i2 = defaultPreference.getInt("Main_top_marign", -1)) >= 0) {
                AppMethodBeat.o(33658);
                return i2;
            }
        }
        if (z) {
            statusBarHeight = 0;
        }
        Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "getTopHeight statusHeight:%s, isInMultiWindowMode:%s", Integer.valueOf(statusBarHeight), Boolean.valueOf(z));
        AppMethodBeat.o(33658);
        return statusBarHeight;
    }

    private ViewGroup gJu() {
        AppMethodBeat.i(33659);
        ViewParent parent = this.Dpx.getSupportActionBar().getCustomView().getParent();
        ViewGroup viewGroup = null;
        View decorView = this.Dpx.getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= 24 && LauncherUI.getInstance().isInMultiWindowMode()) {
            decorView = ((ViewGroup) decorView).getChildAt(0);
        }
        while (parent != decorView && parent != null) {
            viewGroup = parent;
            parent = parent.getParent();
        }
        if (viewGroup instanceof ViewGroup) {
            ViewGroup viewGroup2 = viewGroup;
            AppMethodBeat.o(33659);
            return viewGroup2;
        }
        ViewGroup viewGroup3 = (ViewGroup) decorView;
        AppMethodBeat.o(33659);
        return viewGroup3;
    }

    /* access modifiers changed from: package-private */
    public final boolean gJv() {
        AppMethodBeat.i(33660);
        if (!com.tencent.mm.compatible.util.d.oD(19) || !b.apl() || com.tencent.mm.compatible.e.b.cv(this.Dpx)) {
            AppMethodBeat.o(33660);
            return false;
        }
        AppMethodBeat.o(33660);
        return true;
    }

    static /* synthetic */ void a(NewChattingTabUI newChattingTabUI, Intent intent, boolean z) {
        boolean z2;
        boolean z3;
        ViewGroup viewGroup;
        AppMethodBeat.i(33668);
        long currentTimeMillis = System.currentTimeMillis();
        if (newChattingTabUI.OJN == null) {
            newChattingTabUI.OJN = new ChattingUIFragment();
            newChattingTabUI.mChattingUIProxy = new ChattingUIProxy(newChattingTabUI.Dpx, newChattingTabUI.OJN);
            z2 = true;
        } else {
            z2 = false;
        }
        try {
            if (newChattingTabUI.OJG == null) {
                if (!newChattingTabUI.OJN.isSupportCustomActionBar()) {
                    Log.w("MicroMsg.LauncherUI.NewChattingTabUI", "[createChattingView] is not SupportCustomActionBar %s", Boolean.valueOf(b.apl()));
                    newChattingTabUI.OJG = (TestTimeForChatting) newChattingTabUI.Dpx.findViewById(R.id.atz);
                    newChattingTabUI.OJH = newChattingTabUI.OJG.getId();
                } else {
                    final int[] iArr = new int[2];
                    newChattingTabUI.Dpx.getSupportActionBar().getCustomView().getLocationInWindow(iArr);
                    TestTimeForChatting testTimeForChatting = new TestTimeForChatting(newChattingTabUI.Dpx);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    testTimeForChatting.setId(R.id.aur);
                    newChattingTabUI.OJH = testTimeForChatting.getId();
                    testTimeForChatting.setOrientation(1);
                    testTimeForChatting.setLayoutParams(layoutParams);
                    final HomeUI.FitSystemWindowLayoutView fitSystemWindowLayoutView = new HomeUI.FitSystemWindowLayoutView(newChattingTabUI.Dpx);
                    fitSystemWindowLayoutView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    ViewGroup viewGroup2 = (ViewGroup) newChattingTabUI.Dpx.getWindow().getDecorView();
                    if (viewGroup2 != null) {
                        if (Build.VERSION.SDK_INT < 24 || !LauncherUI.getInstance().isInMultiWindowMode() || viewGroup2.getChildAt(0) == null) {
                            viewGroup = viewGroup2;
                        } else {
                            Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "createChattingView isInMultiWindowMode !!");
                            viewGroup = viewGroup2.getChildAt(0);
                        }
                        View gJu = newChattingTabUI.gJu();
                        if (gJu == null) {
                            Log.w("MicroMsg.LauncherUI.NewChattingTabUI", "abRoot == null! try get child(0)");
                            gJu = viewGroup.getChildAt(0);
                        }
                        ImageView imageView = new ImageView(newChattingTabUI.Dpx);
                        imageView.setId(R.id.gga);
                        imageView.setLayoutParams(layoutParams);
                        imageView.setVisibility(8);
                        Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[createChattingView] prepareView GONE");
                        final ViewGroup viewGroup3 = (ViewGroup) gJu;
                        viewGroup.removeView(gJu);
                        if (gJu.getParent() != null && (gJu.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) gJu.getParent()).removeView(gJu);
                        }
                        gJu.setId(R.id.e8x);
                        if (ao.isMultiTaskMode()) {
                            View findViewById = gJu.findViewById(R.id.bl6);
                            if (findViewById.getParent() != null && (findViewById.getParent() instanceof ViewGroup)) {
                                ViewGroup viewGroup4 = (ViewGroup) findViewById.getParent();
                                viewGroup4.removeView(findViewById);
                                DynamicBgContainer dynamicBgContainer = new DynamicBgContainer(newChattingTabUI.Dpx);
                                viewGroup4.addView(dynamicBgContainer, new ViewGroup.LayoutParams(-1, -1));
                                GradientColorBackgroundView gradientColorBackgroundView = new GradientColorBackgroundView(newChattingTabUI.Dpx);
                                gradientColorBackgroundView.setBackgroundColor(0);
                                viewGroup4.addView(gradientColorBackgroundView, new ViewGroup.LayoutParams(-1, -1));
                                dynamicBgContainer.setGradientBgView(gradientColorBackgroundView);
                                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                                viewGroup4.addView(((MultiTaskUIC) com.tencent.mm.ui.component.a.b(newChattingTabUI.Dpx).get(MultiTaskUIC.class)).a(findViewById, dynamicBgContainer, new MultiTaskUIC.b() {
                                    /* class com.tencent.mm.ui.NewChattingTabUI.AnonymousClass3 */

                                    @Override // com.tencent.mm.plugin.multitask.ui.uic.MultiTaskUIC.b
                                    public final int getCurrentTabIndex() {
                                        AppMethodBeat.i(232688);
                                        int currentTabIndex = LauncherUI.getCurrentTabIndex();
                                        AppMethodBeat.o(232688);
                                        return currentTabIndex;
                                    }

                                    @Override // com.tencent.mm.plugin.multitask.ui.uic.MultiTaskUIC.b
                                    public final boolean esy() {
                                        AppMethodBeat.i(232689);
                                        LauncherUI instance = LauncherUI.getInstance();
                                        if (instance == null || instance.ODR.getMainTabUI() == null) {
                                            AppMethodBeat.o(232689);
                                            return false;
                                        }
                                        MainUI mainUI = (MainUI) instance.ODR.getMainTabUI().OIl.get(0);
                                        if (mainUI == null) {
                                            AppMethodBeat.o(232689);
                                            return false;
                                        } else if (mainUI.QfG != null) {
                                            boolean esy = mainUI.QfG.esy();
                                            AppMethodBeat.o(232689);
                                            return esy;
                                        } else {
                                            AppMethodBeat.o(232689);
                                            return false;
                                        }
                                    }

                                    @Override // com.tencent.mm.plugin.multitask.ui.uic.MultiTaskUIC.b
                                    public final void awZ(int i2) {
                                        AppMethodBeat.i(258910);
                                        LauncherUI instance = LauncherUI.getInstance();
                                        if (!(instance == null || instance.ODR.getMainTabUI() == null)) {
                                            MainTabUI mainTabUI = instance.ODR.getMainTabUI();
                                            if (mainTabUI.OIf != null) {
                                                mainTabUI.OIf.awZ(i2);
                                            }
                                        }
                                        AppMethodBeat.o(258910);
                                    }

                                    @Override // com.tencent.mm.plugin.multitask.ui.uic.MultiTaskUIC.b
                                    public final void axa(int i2) {
                                        AppMethodBeat.i(258911);
                                        LauncherUI instance = LauncherUI.getInstance();
                                        if (!(instance == null || instance.ODR.getMainTabUI() == null)) {
                                            MainTabUI mainTabUI = instance.ODR.getMainTabUI();
                                            if (mainTabUI.OIf != null) {
                                                mainTabUI.OIf.axa(i2);
                                            }
                                        }
                                        AppMethodBeat.o(258911);
                                    }
                                }));
                            }
                        }
                        fitSystemWindowLayoutView.addView(gJu);
                        fitSystemWindowLayoutView.addView(imageView);
                        fitSystemWindowLayoutView.addView(testTimeForChatting);
                        viewGroup.addView(fitSystemWindowLayoutView);
                        viewGroup.requestFitSystemWindows();
                        int topHeight = newChattingTabUI.getTopHeight();
                        Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "ashu::fitSystemWindows. statusBarHeight:%d", Integer.valueOf(topHeight));
                        if (topHeight > 0) {
                            newChattingTabUI.OJE.a(fitSystemWindowLayoutView, new Rect(0, topHeight, 0, 0), viewGroup3);
                        } else {
                            newChattingTabUI.Dpx.getSupportActionBar().getCustomView().post(new Runnable() {
                                /* class com.tencent.mm.ui.NewChattingTabUI.AnonymousClass4 */

                                public final void run() {
                                    AppMethodBeat.i(33640);
                                    NewChattingTabUI.this.Dpx.getSupportActionBar().getCustomView().getLocationInWindow(iArr);
                                    int h2 = NewChattingTabUI.h(NewChattingTabUI.this);
                                    if (h2 > 0) {
                                        NewChattingTabUI.this.OJE.a(fitSystemWindowLayoutView, new Rect(0, h2, 0, 0), viewGroup3);
                                        AppMethodBeat.o(33640);
                                        return;
                                    }
                                    if (com.tencent.mm.compatible.util.d.oD(20)) {
                                        fitSystemWindowLayoutView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                                            /* class com.tencent.mm.ui.NewChattingTabUI.AnonymousClass4.AnonymousClass1 */

                                            @TargetApi(20)
                                            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                                                AppMethodBeat.i(232690);
                                                if (windowInsets == null) {
                                                    AppMethodBeat.o(232690);
                                                } else {
                                                    Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "OnApplyWindowInsetsListener %s", windowInsets);
                                                    windowInsets.consumeSystemWindowInsets();
                                                    LauncherUI.b bVar = NewChattingTabUI.this.OJE;
                                                    HomeUI.FitSystemWindowLayoutView fitSystemWindowLayoutView = fitSystemWindowLayoutView;
                                                    windowInsets.getSystemWindowInsetTop();
                                                    bVar.a(fitSystemWindowLayoutView, new Rect(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom()), viewGroup3);
                                                    AppMethodBeat.o(232690);
                                                }
                                                return windowInsets;
                                            }
                                        });
                                    }
                                    AppMethodBeat.o(33640);
                                }
                            });
                        }
                        newChattingTabUI.OJG = (TestTimeForChatting) newChattingTabUI.Dpx.findViewById(newChattingTabUI.OJH);
                        Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "ashu::prepareChattingFragment init chattingView, top %s", Integer.valueOf(topHeight));
                    }
                }
            } else if (newChattingTabUI.OJN.isSupportCustomActionBar()) {
                int[] iArr2 = new int[2];
                newChattingTabUI.OJG.getLocationInWindow(iArr2);
                if (iArr2[1] == 0) {
                    ViewGroup viewGroup5 = (ViewGroup) newChattingTabUI.Dpx.getWindow().getDecorView();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= viewGroup5.getChildCount()) {
                            break;
                        }
                        View childAt = viewGroup5.getChildAt(i2);
                        if (childAt instanceof HomeUI.FitSystemWindowLayoutView) {
                            newChattingTabUI.Dpx.getSupportActionBar().getCustomView().getLocationInWindow(iArr2);
                            HomeUI.FitSystemWindowLayoutView fitSystemWindowLayoutView2 = (HomeUI.FitSystemWindowLayoutView) childAt;
                            ViewGroup viewGroup6 = (ViewGroup) newChattingTabUI.Dpx.findViewById(R.id.e8x);
                            int paddingTop = viewGroup6.getPaddingTop();
                            int topHeight2 = newChattingTabUI.getTopHeight();
                            Rect rect = new Rect();
                            newChattingTabUI.Dpx.getWindow();
                            viewGroup5.getWindowVisibleDisplayFrame(rect);
                            Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "rootLayout2 fitSystemWindows detect: ActionBar's CustomView location[1]:%d, paddingTop:%d getStatusBarHeight():%d, heightFromSysR:%d, rectangle.top:%d, rectangle.height:%d, DecorHeight:%d, cacheInsetsTop:%d", Integer.valueOf(iArr2[1]), Integer.valueOf(paddingTop), Integer.valueOf(ao.jJ(newChattingTabUI.Dpx)), Integer.valueOf(topHeight2), Integer.valueOf(rect.top), Integer.valueOf(rect.height()), Integer.valueOf(viewGroup5.getHeight()), Integer.valueOf(fitSystemWindowLayoutView2.getCacheInsetsTop()));
                            fitSystemWindowLayoutView2.fitSystemWindows(new Rect(0, fitSystemWindowLayoutView2.getCacheInsetsTop(), 0, 0));
                            ImageView imageView2 = (ImageView) fitSystemWindowLayoutView2.findViewById(R.id.gga);
                            imageView2.setTag(viewGroup6);
                            ViewGroup.LayoutParams layoutParams2 = viewGroup6.getLayoutParams();
                            if (layoutParams2 == null || (layoutParams2 instanceof FrameLayout.LayoutParams)) {
                                imageView2.setLayoutParams(layoutParams2);
                            } else {
                                Log.w("MicroMsg.LauncherUI.NewChattingTabUI", "FIX LayoutParams:%s %s", layoutParams2.toString(), viewGroup6);
                                imageView2.setLayoutParams(new FrameLayout.LayoutParams(layoutParams2));
                            }
                            Bitmap magicDrawingCache = newChattingTabUI.getMagicDrawingCache(viewGroup6);
                            if (magicDrawingCache != null) {
                                imageView2.setImageBitmap(magicDrawingCache);
                                viewGroup6.setVisibility(8);
                                imageView2.setVisibility(0);
                                Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[prepareChattingFragment] prepareView VISIBLE");
                            } else {
                                viewGroup6.setVisibility(0);
                                imageView2.setVisibility(8);
                                imageView2.setImageDrawable(null);
                                Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[prepareChattingFragment] prepareView GONE");
                            }
                        } else {
                            ImageView imageView3 = (ImageView) childAt.findViewById(R.id.gga);
                            if (imageView3 != null) {
                                imageView3.setImageDrawable(null);
                            }
                            Object[] objArr = new Object[2];
                            objArr[0] = Integer.valueOf(i2);
                            if (imageView3 == null) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            objArr[1] = Boolean.valueOf(z3);
                            Log.e("MicroMsg.LauncherUI.NewChattingTabUI", "on position %d, rootLayout not found! prepareView is null?%s", objArr);
                            i2++;
                        }
                    }
                }
                Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "ashu::prepareChattingFragment has chattingView, top %s", Integer.valueOf(iArr2[1]));
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.LauncherUI.NewChattingTabUI", e2, "[prepareChattingFragment]", new Object[0]);
        }
        if (intent != null) {
            newChattingTabUI.OJN.getArguments().putAll(IntentUtil.getExtras(intent));
        }
        if (z2) {
            newChattingTabUI.mChattingUIProxy.onInit(newChattingTabUI.OJH, z);
            newChattingTabUI.OJJ = (OnLayoutChangedLinearLayout) newChattingTabUI.OJN.getView().findViewById(R.id.auc);
        } else {
            newChattingTabUI.mChattingUIProxy.onEnterBegin();
        }
        if (newChattingTabUI.OJN.isSupportNavigationSwipeBack()) {
            newChattingTabUI.OJN.getSwipeBackLayout().setNeedRequestActivityTranslucent(false);
        }
        Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "ashu::prepareChattingFragment use %dms, needInit %B, Intent %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(z2), intent);
        AppMethodBeat.o(33668);
    }

    static /* synthetic */ String i(NewChattingTabUI newChattingTabUI) {
        AppMethodBeat.i(33670);
        if (newChattingTabUI.OJN != null) {
            String identityString = newChattingTabUI.OJN.getIdentityString();
            AppMethodBeat.o(33670);
            return identityString;
        }
        AppMethodBeat.o(33670);
        return "";
    }

    static /* synthetic */ void u(NewChattingTabUI newChattingTabUI) {
        AppMethodBeat.i(33673);
        Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[doJobOnChattingAnimStart] cost:%sms", Long.valueOf(System.currentTimeMillis() - newChattingTabUI.OJO));
        newChattingTabUI.isAnimating = true;
        if (newChattingTabUI.OJG != null) {
            newChattingTabUI.OJG.setTranslationX(0.0f);
            newChattingTabUI.OJG.gXV();
        }
        AppMethodBeat.o(33673);
    }

    static /* synthetic */ void v(NewChattingTabUI newChattingTabUI) {
        AppMethodBeat.i(33674);
        Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[doJobOnChattingAnimEnd]");
        bg.getNotification().dh(false);
        newChattingTabUI.isAnimating = false;
        if (newChattingTabUI.OJG != null) {
            newChattingTabUI.OJG.postDelayed(new Runnable() {
                /* class com.tencent.mm.ui.NewChattingTabUI.AnonymousClass9 */

                public final void run() {
                    AppMethodBeat.i(232699);
                    long currentTimeMillis = System.currentTimeMillis();
                    bg.aAk().setLowPriority();
                    MMHandlerThread.setCurrentPriority(0);
                    NewChattingTabUI.this.Dpx.onSwipe(1.0f);
                    if (NewChattingTabUI.this.OJG != null) {
                        NewChattingTabUI.this.OJG.gXW();
                    }
                    NewChattingTabUI.this.mChattingUIProxy.onEnterEnd();
                    NewChattingTabUI.y(NewChattingTabUI.this);
                    Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "doJobOnChattingAnimEnd cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(232699);
                }

                public final String toString() {
                    AppMethodBeat.i(232700);
                    String str = super.toString() + "|chattingView_onAnimationEnd";
                    AppMethodBeat.o(232700);
                    return str;
                }
            }, 60);
        }
        AppMethodBeat.o(33674);
    }
}
