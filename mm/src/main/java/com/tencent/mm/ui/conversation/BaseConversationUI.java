package com.tencent.mm.ui.conversation;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.v7.app.ActionBar;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.IChattingUIProxy;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.b.c;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.chatting.ChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUIProxy;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.h;

public class BaseConversationUI extends MMFragmentActivity {
    private static final String LAST_RESTORE_TALKER = "last_restore_talker";
    static final String TAG = "MicroMsg.BaseConversationUI";
    private OnLayoutChangedLinearLayout chattingFragmentView;
    private ChattingUIFragment chattingFragmet;
    private int chattingID = -1;
    private IChattingUIProxy chattingUIProxy;
    private TestTimeForChatting chattingView;
    private long chattinguiResumeTime = 0;
    public BaseConversationFmUI conversationFm;
    private boolean isAnimating;
    private String lastRestoreTalker;
    private a launcherUIStatus = a.ACTIVITY_CREATE;
    private ActionBar mActionBar;
    private com.tencent.mm.ui.a mActionBarHelper;
    public boolean mChattingClosed = true;
    private Animation mChattingInAnim;
    private Animation mChattingOutAnim;
    private boolean mNeedChattingAnim = false;
    private Bitmap mPrepareBitmap;
    private OnLayoutChangedLinearLayout.a onChattingLayoutChangedListener = new OnLayoutChangedLinearLayout.a() {
        /* class com.tencent.mm.ui.conversation.BaseConversationUI.AnonymousClass6 */
        long start = 0;

        @Override // com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a
        public final void gJw() {
            AppMethodBeat.i(38173);
            if (BaseConversationUI.this.mChattingInAnim == null) {
                BaseConversationUI.this.mChattingInAnim = AnimationUtils.loadAnimation(BaseConversationUI.this, MMFragmentActivity.a.ogm);
                BaseConversationUI.this.mChattingInAnim.setAnimationListener(new Animation.AnimationListener() {
                    /* class com.tencent.mm.ui.conversation.BaseConversationUI.AnonymousClass6.AnonymousClass1 */

                    public final void onAnimationStart(Animation animation) {
                        AppMethodBeat.i(38170);
                        Log.i(BaseConversationUI.TAG, "klem onAnimationStart onDrawed->onAnimationStart:%sms", Long.valueOf(System.currentTimeMillis() - AnonymousClass6.this.start));
                        BaseConversationUI.this.isAnimating = true;
                        BaseConversationUI.access$900(BaseConversationUI.this);
                        BaseConversationUI.this.onSettle(false, 0);
                        AppMethodBeat.o(38170);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(38171);
                        BaseConversationUI.this.isAnimating = false;
                        Log.i(BaseConversationUI.TAG, "klem animationEnd");
                        BaseConversationUI.access$1000(BaseConversationUI.this);
                        AppMethodBeat.o(38171);
                    }
                });
            }
            if (BaseConversationUI.this.mNeedChattingAnim) {
                BaseConversationUI.this.chattingView.setOndispatchDraw(new TestTimeForChatting.a() {
                    /* class com.tencent.mm.ui.conversation.BaseConversationUI.AnonymousClass6.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.tools.TestTimeForChatting.a
                    public final void gJx() {
                        AppMethodBeat.i(38172);
                        Log.i(BaseConversationUI.TAG, "[onDrawed]");
                        AnonymousClass6.this.start = System.currentTimeMillis();
                        if (BaseConversationUI.this.chattingFragmet == null) {
                            Log.e(BaseConversationUI.TAG, "chattingFragmet is null!");
                            AppMethodBeat.o(38172);
                            return;
                        }
                        if (BaseConversationUI.this.chattingFragmet.getSwipeBackLayout() != null) {
                            BaseConversationUI.this.chattingFragmet.getSwipeBackLayout().startAnimation(BaseConversationUI.this.mChattingInAnim);
                        } else {
                            BaseConversationUI.this.chattingFragmet.getView().startAnimation(BaseConversationUI.this.mChattingInAnim);
                        }
                        BaseConversationUI.this.chattingView.setOndispatchDraw(null);
                        AppMethodBeat.o(38172);
                    }
                });
                BaseConversationUI.this.mNeedChattingAnim = false;
            } else {
                BaseConversationUI.access$900(BaseConversationUI.this);
                BaseConversationUI.access$1000(BaseConversationUI.this);
            }
            BaseConversationUI.this.chattingFragmentView.OWo = null;
            Log.i(BaseConversationUI.TAG, "klem CHATTING ONLAYOUT ");
            AppMethodBeat.o(38173);
        }
    };
    Bundle pendingBundle;
    String pendingUser;
    private b selectImageJob = new b(this, (byte) 0);
    Runnable startChattingRunnable = new Runnable() {
        /* class com.tencent.mm.ui.conversation.BaseConversationUI.AnonymousClass8 */

        public final void run() {
            boolean isShown;
            AppMethodBeat.i(38177);
            if (!BaseConversationUI.this.mChattingClosed) {
                Log.e(BaseConversationUI.TAG, "start chatting but last chatting does't be close!");
                BaseConversationUI.this.closeChatting(false);
            }
            if (BaseConversationUI.this.isFinishing() || BaseConversationUI.this.isPaused() || !BaseConversationUI.this.mChattingClosed) {
                Log.w(BaseConversationUI.TAG, "[startChattingRunnable] pass! isPause:%s mChattingClosed:%s", Boolean.valueOf(BaseConversationUI.this.isPaused()), Boolean.valueOf(BaseConversationUI.this.mChattingClosed));
                AppMethodBeat.o(38177);
                return;
            }
            BaseConversationUI.this.mChattingClosed = false;
            Object[] objArr = new Object[1];
            if (BaseConversationUI.this.chattingView == null) {
                isShown = false;
            } else {
                isShown = BaseConversationUI.this.chattingView.isShown();
            }
            objArr[0] = Boolean.valueOf(isShown);
            Log.i(BaseConversationUI.TAG, "ashutest::startChatting, ishow:%b", objArr);
            Intent putExtra = new Intent().putExtra("Chat_User", BaseConversationUI.this.pendingUser);
            if (BaseConversationUI.this.pendingBundle != null) {
                putExtra.putExtras(BaseConversationUI.this.pendingBundle);
            }
            putExtra.putExtra("img_gallery_enter_from_chatting_ui", true);
            BaseConversationUI.access$300(BaseConversationUI.this, putExtra, false);
            BaseConversationUI.this.chattingFragmentView.setOnChattingLayoutChangedListener(BaseConversationUI.this.onChattingLayoutChangedListener);
            BaseConversationUI.this.chattingView.setTranslationX((BaseConversationUI.this.getWindow().getDecorView().getWidth() == 0 ? (float) BaseConversationUI.this.getResources().getDisplayMetrics().widthPixels : (float) BaseConversationUI.this.getWindow().getDecorView().getWidth()) - 0.1f);
            BaseConversationUI.this.chattingView.setVisibility(0);
            BaseConversationUI.this.pauseMainFragment();
            if (BaseConversationUI.this.chattingFragmet.isSupportNavigationSwipeBack()) {
                h.a(BaseConversationUI.this);
            }
            ThreadPool.post(new Runnable() {
                /* class com.tencent.mm.ui.conversation.BaseConversationUI.AnonymousClass8.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(38176);
                    if (BaseConversationUI.this.chattingFragmet != null) {
                        d.d(4, BaseConversationUI.this.getLocalClassName(), BaseConversationUI.this.hashCode());
                        d.d(3, "ChattingUI" + BaseConversationUI.this.chattingFragmet.getIdentityString(), BaseConversationUI.this.chattingFragmet.hashCode());
                    }
                    AppMethodBeat.o(38176);
                }
            }, "directReport_startChattingRunnable");
            BaseConversationUI.this.chattinguiResumeTime = Util.nowSecond();
            AppMethodBeat.o(38177);
        }

        public final String toString() {
            AppMethodBeat.i(38178);
            String str = super.toString() + "|startChattingRunnable";
            AppMethodBeat.o(38178);
            return str;
        }
    };
    private String title;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BaseConversationUI() {
        AppMethodBeat.i(38195);
        AppMethodBeat.o(38195);
    }

    static /* synthetic */ String access$000(BaseConversationUI baseConversationUI) {
        AppMethodBeat.i(38228);
        String identityString = baseConversationUI.getIdentityString();
        AppMethodBeat.o(38228);
        return identityString;
    }

    static /* synthetic */ void access$1000(BaseConversationUI baseConversationUI) {
        AppMethodBeat.i(38232);
        baseConversationUI.doJobOnChattingAnimEnd();
        AppMethodBeat.o(38232);
    }

    static /* synthetic */ void access$1300(BaseConversationUI baseConversationUI, HomeUI.FitSystemWindowLayoutView fitSystemWindowLayoutView, int i2, Rect rect, ViewGroup viewGroup) {
        AppMethodBeat.i(38233);
        baseConversationUI.updateRootViewSystemWindowsInsets(fitSystemWindowLayoutView, i2, rect, viewGroup);
        AppMethodBeat.o(38233);
    }

    static /* synthetic */ void access$300(BaseConversationUI baseConversationUI, Intent intent, boolean z) {
        AppMethodBeat.i(38229);
        baseConversationUI.prepareChattingFragment(intent, z);
        AppMethodBeat.o(38229);
    }

    static /* synthetic */ void access$600(BaseConversationUI baseConversationUI) {
        AppMethodBeat.i(38230);
        baseConversationUI.tryResetChattingSwipeStatus();
        AppMethodBeat.o(38230);
    }

    static /* synthetic */ void access$900(BaseConversationUI baseConversationUI) {
        AppMethodBeat.i(38231);
        baseConversationUI.doJobOnChattingAnimStart();
        AppMethodBeat.o(38231);
    }

    /* access modifiers changed from: package-private */
    public enum a {
        ACTIVITY_CREATE,
        ACTIVITY_RESUME,
        ACTIVITY_PAUSE;

        public static a valueOf(String str) {
            AppMethodBeat.i(38183);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(38183);
            return aVar;
        }

        static {
            AppMethodBeat.i(38184);
            AppMethodBeat.o(38184);
        }
    }

    public static class BaseConversationFmUI extends MMFragment {
        private a fmStatus = a.ACTIVITY_CREATE;
        public BaseConversationUI ui;

        @Override // com.tencent.mm.ui.MMFragment
        public int getLayoutId() {
            return 0;
        }

        @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            AppMethodBeat.i(38185);
            this.fmStatus = a.ACTIVITY_CREATE;
            this.ui = (BaseConversationUI) thisActivity();
            View inflate = layoutInflater.inflate(getLayoutId(), viewGroup, false);
            setHasOptionsMenu(true);
            AppMethodBeat.o(38185);
            return inflate;
        }

        @Override // com.tencent.mm.ui.MMFragment
        public void setMMTitle(String str) {
            AppMethodBeat.i(38186);
            if (this.ui != null) {
                this.ui.setTitle(str);
            }
            AppMethodBeat.o(38186);
        }

        @Override // com.tencent.mm.ui.FragmentActivitySupport, com.tencent.mm.ui.MMFragment
        public void finish() {
            AppMethodBeat.i(38187);
            thisActivity().finish();
            AppMethodBeat.o(38187);
        }

        @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
        public void onResume() {
            AppMethodBeat.i(38188);
            super.onResume();
            this.fmStatus = a.ACTIVITY_RESUME;
            AppMethodBeat.o(38188);
        }

        @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
        public void onPause() {
            AppMethodBeat.i(38189);
            super.onPause();
            this.fmStatus = a.ACTIVITY_PAUSE;
            AppMethodBeat.o(38189);
        }

        @Override // com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
        public void onDestroy() {
            AppMethodBeat.i(38190);
            if (this.fmStatus != a.ACTIVITY_PAUSE) {
                Log.w(BaseConversationUI.TAG, "fmStatus != ActivityStatus.ACTIVITY_PAUSE when fm onDestroy");
                onPause();
            }
            super.onDestroy();
            AppMethodBeat.o(38190);
        }

        public String getUserName() {
            return null;
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(38196);
        getWindow().setFormat(-2);
        com.tencent.mm.pluginsdk.h.aU(this);
        super.onCreate(bundle);
        if (!b.gVn()) {
            getWindow().setCallback(new c(getWindow().getCallback(), this));
        }
        this.mActionBar = getSupportActionBar();
        initNavigationSwipeBack();
        AppMethodBeat.o(38196);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(38197);
        super.onNewIntent(intent);
        Log.i(TAG, "onNewIntent");
        setIntent(intent);
        AppMethodBeat.o(38197);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(38198);
        super.onResume();
        h.b(this);
        onSwipe(1.0f);
        this.launcherUIStatus = a.ACTIVITY_RESUME;
        final boolean z = this.chattingView != null && this.chattingView.isShown();
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.ui.conversation.BaseConversationUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(38164);
                d.d(3, z ? "ChattingUI" + BaseConversationUI.access$000(BaseConversationUI.this) : BaseConversationUI.this.getLocalClassName(), z ? BaseConversationUI.this.chattingFragmet.hashCode() : BaseConversationUI.this.hashCode());
                AppMethodBeat.o(38164);
            }
        }, "directReport_onResume");
        if (!z) {
            this.chattinguiResumeTime = Util.nowSecond();
        }
        if (com.tencent.mm.compatible.util.d.oD(19) && com.tencent.mm.compatible.h.b.apl()) {
            if (this.chattingFragmet != null && this.chattingFragmet.isSupportNavigationSwipeBack()) {
                this.chattingFragmet.getSwipeBackLayout().setEnableGesture(true);
            }
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                /* class com.tencent.mm.ui.conversation.BaseConversationUI.AnonymousClass3 */

                public final boolean queueIdle() {
                    String aTY;
                    AppMethodBeat.i(38166);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (BaseConversationUI.this.chattingView == null) {
                        if (BaseConversationUI.this.conversationFm == null || Util.isNullOrNil(BaseConversationUI.this.conversationFm.getUserName())) {
                            aTY = z.aTY();
                        } else {
                            aTY = BaseConversationUI.this.conversationFm.getUserName();
                        }
                        BaseConversationUI.access$300(BaseConversationUI.this, new Intent().putExtra("Chat_User", aTY), true);
                        BaseConversationUI.this.chattingView.setVisibility(8);
                        BaseConversationUI.this.resumeMainFragment();
                    }
                    Log.d(BaseConversationUI.TAG, "prepare chattingUI logic use %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(38166);
                    return false;
                }
            });
        }
        initActionBar();
        this.mActionBar.show();
        AppMethodBeat.o(38198);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(38199);
        Log.i(TAG, "on pause");
        super.onPause();
        if (!isFinishing()) {
            h.a(this);
        }
        this.launcherUIStatus = a.ACTIVITY_PAUSE;
        final boolean z = this.chattingView != null && this.chattingView.isShown();
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.ui.conversation.BaseConversationUI.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(38167);
                int i2 = 0;
                if (BaseConversationUI.this.chattingFragmet != null) {
                    i2 = BaseConversationUI.this.chattingFragmet.hashCode();
                }
                String localClassName = z ? "ChattingUI" + BaseConversationUI.access$000(BaseConversationUI.this) : BaseConversationUI.this.getLocalClassName();
                if (!z) {
                    i2 = BaseConversationUI.this.hashCode();
                }
                d.d(4, localClassName, i2);
                if (z) {
                    d.m("ChattingUI" + BaseConversationUI.access$000(BaseConversationUI.this), BaseConversationUI.this.chattinguiResumeTime, Util.nowSecond());
                }
                AppMethodBeat.o(38167);
            }
        }, "directReport_onPause");
        if (this.chattingFragmet != null && this.chattingFragmet.isSupportNavigationSwipeBack()) {
            this.chattingFragmet.getSwipeBackLayout().setEnableGesture(false);
        }
        AppMethodBeat.o(38199);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(38200);
        super.onDestroy();
        if (this.mPrepareBitmap != null && !this.mPrepareBitmap.isRecycled()) {
            Log.i(TAG, "bitmap recycle %s", this.mPrepareBitmap.toString());
            this.mPrepareBitmap.recycle();
        }
        this.chattingFragmet = null;
        this.chattingFragmentView = null;
        this.chattingView = null;
        this.conversationFm = null;
        this.mActionBarHelper = null;
        this.mChattingInAnim = null;
        this.mChattingOutAnim = null;
        AppMethodBeat.o(38200);
    }

    @Override // com.tencent.mm.ui.widget.h.a, com.tencent.mm.ui.MMFragmentActivity
    public void onSwipe(float f2) {
        ViewGroup viewGroup;
        AppMethodBeat.i(38201);
        Log.v(TAG, "ashutest::on swipe %f, duration %d, status %s", Float.valueOf(f2), 260L, this.launcherUIStatus);
        if (!com.tencent.mm.compatible.util.d.oD(19) || !com.tencent.mm.compatible.h.b.apl()) {
            AppMethodBeat.o(38201);
        } else if (this.chattingFragmet == null) {
            Log.e(TAG, "chattingFragmet is null!");
            AppMethodBeat.o(38201);
        } else {
            if (f2 == 0.0f && !this.mChattingClosed) {
                ImageView imageView = (ImageView) getWindow().getDecorView().findViewById(R.id.gga);
                if (!(imageView == null || (viewGroup = (ViewGroup) imageView.getTag()) == null)) {
                    Log.i(TAG, "[onSwipe] prepareView GONE");
                    viewGroup.setVisibility(0);
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
                if (this.mChattingInAnim != null) {
                    this.mChattingInAnim.cancel();
                }
            } else if (f2 == 1.0f && !this.mChattingClosed && this.chattingFragmet.isSupportNavigationSwipeBack()) {
                getWindow().setBackgroundDrawableResource(R.color.a5p);
                ImageView imageView2 = (ImageView) getWindow().getDecorView().findViewById(R.id.gga);
                if (!(imageView2 == null || imageView2.getVisibility() != 0 || imageView2.getTag() == null)) {
                    ((View) imageView2.getTag()).setVisibility(0);
                    Log.i(TAG, "[onSwipe] prepareView GONE");
                    imageView2.setVisibility(8);
                }
            }
            if (a.ACTIVITY_RESUME == this.launcherUIStatus || Float.compare(1.0f, f2) <= 0) {
                View findViewById = findViewById(R.id.e8x);
                ImageView imageView3 = (ImageView) findViewById(R.id.gga);
                if (!(imageView3 == null || imageView3.getVisibility() != 8 || imageView3.getDrawable() == null || this.mChattingClosed || f2 == 1.0f || f2 == 0.0f)) {
                    imageView3.setVisibility(0);
                    Log.i(TAG, "[onSwipe] !1 && !0 prepareView VISIBLE");
                    if (findViewById != null) {
                        findViewById.setVisibility(8);
                    }
                }
                resetViewTranX(findViewById, imageView3, f2);
                AppMethodBeat.o(38201);
                return;
            }
            Log.i(TAG, "[onSwipe] return! consumedSuperCall:%s", Float.valueOf(f2));
            AppMethodBeat.o(38201);
        }
    }

    private void resetViewTranX(View view, ImageView imageView, float f2) {
        AppMethodBeat.i(38202);
        if (Float.compare(1.0f, f2) <= 0) {
            j.q(view, 0.0f);
            j.q(imageView, 0.0f);
            AppMethodBeat.o(38202);
        } else if (imageView == null || imageView.getDrawable() == null) {
            j.q(view, ((float) (view.getWidth() / 4)) * (1.0f - f2) * -1.0f);
            AppMethodBeat.o(38202);
        } else {
            j.q(imageView, ((float) (imageView.getWidth() / 4)) * (1.0f - f2) * -1.0f);
            AppMethodBeat.o(38202);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(38203);
        super.onActivityResult(i2, i3, intent);
        if (this.conversationFm != null) {
            this.conversationFm.onActivityResult(i2, i3, intent);
        }
        if (i3 != -1) {
            AppMethodBeat.o(38203);
            return;
        }
        if ((i2 == 2001 || i2 == 226) && this.chattingFragmet != null) {
            this.chattingFragmet.onActivityResult(i2, i3, intent);
        }
        if (!acceptRequestCode(i2) || this.chattingFragmet != null) {
            AppMethodBeat.o(38203);
            return;
        }
        Log.i(TAG, "on select image ActivityResult. the chattingUI maybe kill in the background.");
        MMHandlerThread.removeRunnable(this.selectImageJob);
        this.selectImageJob.OJY = 0;
        this.selectImageJob.requestCode = i2;
        this.selectImageJob.resultCode = i3;
        this.selectImageJob.dQs = intent;
        MMHandlerThread.postToMainThread(this.selectImageJob);
        AppMethodBeat.o(38203);
    }

    private void doJobOnChattingAnimStart() {
        AppMethodBeat.i(38204);
        this.chattingView.setTranslationX(0.0f);
        this.chattingView.gXV();
        AppMethodBeat.o(38204);
    }

    private void doJobOnChattingAnimEnd() {
        AppMethodBeat.i(38205);
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.ui.conversation.BaseConversationUI.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(38168);
                bg.aAk().setLowPriority();
                MMHandlerThread.setCurrentPriority(0);
                BaseConversationUI.this.onSwipe(1.0f);
                if (!(BaseConversationUI.this.chattingView == null || BaseConversationUI.this.chattingFragmet == null)) {
                    BaseConversationUI.this.chattingView.gXW();
                }
                BaseConversationUI.this.chattingUIProxy.onEnterEnd();
                BaseConversationUI.access$600(BaseConversationUI.this);
                AppMethodBeat.o(38168);
            }

            public final String toString() {
                AppMethodBeat.i(38169);
                String str = super.toString() + "|chattingView_onAnimationEnd";
                AppMethodBeat.o(38169);
                return str;
            }
        }, 60);
        AppMethodBeat.o(38205);
    }

    public void startChatting(String str) {
        AppMethodBeat.i(38207);
        startChatting(str, null, false);
        AppMethodBeat.o(38207);
    }

    public void startChatting(String str, Bundle bundle, boolean z) {
        AppMethodBeat.i(38208);
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.chattingView == null ? false : this.chattingView.isShown());
        Log.i(TAG, "try startChatting, ishow:%b", objArr);
        this.pendingBundle = bundle;
        this.pendingUser = str;
        this.mNeedChattingAnim = z;
        bg.aAk().setLowestPriority();
        MMHandlerThread.setCurrentPriority(-8);
        MMHandlerThread.removeRunnable(this.startChattingRunnable);
        MMHandlerThread.postToMainThread(this.startChattingRunnable);
        AppMethodBeat.o(38208);
    }

    @TargetApi(19)
    private void prepareChattingFragment(Intent intent, boolean z) {
        boolean z2;
        AppMethodBeat.i(38209);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.chattingFragmet == null) {
            this.chattingFragmet = getChattingUIFragment();
            this.chattingUIProxy = new ChattingUIProxy(this, this.chattingFragmet);
            z2 = true;
        } else {
            z2 = false;
        }
        createChattingView();
        if (intent != null) {
            this.chattingFragmet.getArguments().putAll(IntentUtil.getExtras(intent));
        }
        if (z2) {
            this.chattingUIProxy.onInit(this.chattingID, z);
            this.chattingFragmentView = (OnLayoutChangedLinearLayout) this.chattingFragmet.getView().findViewById(R.id.auc);
        } else {
            this.chattingUIProxy.onEnterBegin();
        }
        if (this.chattingFragmet.isSupportNavigationSwipeBack()) {
            this.chattingFragmet.getSwipeBackLayout().setNeedRequestActivityTranslucent(false);
        }
        Log.i(TAG, "ashu::prepareChattingFragment use %dms, needInit %B, Intent %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(z2), intent);
        AppMethodBeat.o(38209);
    }

    private void createChattingView() {
        final ViewGroup viewGroup;
        AppMethodBeat.i(38210);
        if (this.chattingView != null) {
            if (this.chattingFragmet.isSupportCustomActionBar()) {
                int[] iArr = new int[2];
                this.chattingView.getLocationInWindow(iArr);
                if (iArr[1] == 0) {
                    ViewGroup viewGroup2 = (ViewGroup) getWindow().getDecorView();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= viewGroup2.getChildCount()) {
                            break;
                        }
                        View childAt = ((ViewGroup) getWindow().getDecorView()).getChildAt(i2);
                        if (childAt instanceof HomeUI.FitSystemWindowLayoutView) {
                            getSupportActionBar().getCustomView().getLocationInWindow(iArr);
                            HomeUI.FitSystemWindowLayoutView fitSystemWindowLayoutView = (HomeUI.FitSystemWindowLayoutView) childAt;
                            fitSystemWindowLayoutView.fitSystemWindows(new Rect(0, fitSystemWindowLayoutView.getCacheInsetsTop(), 0, 0));
                            Log.i(TAG, "rootLayout2 fitSystemWindows, top %s", Integer.valueOf(iArr[1]));
                            ViewGroup viewGroup3 = (ViewGroup) viewGroup2.findViewById(R.id.e8x);
                            ImageView imageView = (ImageView) fitSystemWindowLayoutView.findViewById(R.id.gga);
                            imageView.setTag(viewGroup3);
                            ViewGroup.LayoutParams layoutParams = viewGroup3.getLayoutParams();
                            if (layoutParams == null || (layoutParams instanceof FrameLayout.LayoutParams)) {
                                imageView.setLayoutParams(layoutParams);
                            } else {
                                Log.w(TAG, "FIX LayoutParams");
                                imageView.setLayoutParams(new FrameLayout.LayoutParams(layoutParams));
                            }
                            Bitmap magicDrawingCache = getMagicDrawingCache(viewGroup3);
                            if (magicDrawingCache != null) {
                                imageView.setImageBitmap(magicDrawingCache);
                                viewGroup3.setVisibility(8);
                                imageView.setVisibility(0);
                                Log.i(TAG, "[prepareChattingFragment] prepareView VISIBLE");
                            } else {
                                imageView.setImageBitmap(null);
                            }
                        } else {
                            Log.e(TAG, "on position %d, rootLayout not found!", Integer.valueOf(i2));
                            i2++;
                        }
                    }
                }
                Log.i(TAG, "ashu::prepareChattingFragment has chattingView, top %s", Integer.valueOf(iArr[1]));
            }
            AppMethodBeat.o(38210);
        } else if (!this.chattingFragmet.isSupportCustomActionBar()) {
            this.chattingView = (TestTimeForChatting) findViewById(R.id.atz);
            this.chattingID = this.chattingView.getId();
            AppMethodBeat.o(38210);
        } else {
            final int[] iArr2 = new int[2];
            getSupportActionBar().getCustomView().getLocationInWindow(iArr2);
            TestTimeForChatting testTimeForChatting = new TestTimeForChatting(this);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            testTimeForChatting.setId(R.id.aur);
            this.chattingID = testTimeForChatting.getId();
            testTimeForChatting.setOrientation(1);
            testTimeForChatting.setLayoutParams(layoutParams2);
            final HomeUI.FitSystemWindowLayoutView fitSystemWindowLayoutView2 = new HomeUI.FitSystemWindowLayoutView(this);
            fitSystemWindowLayoutView2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            View findRootContainer = findRootContainer();
            if (findRootContainer == null) {
                findRootContainer = ((ViewGroup) getWindow().getDecorView()).getChildAt(0);
            }
            if (findRootContainer instanceof SwipeBackLayout) {
                viewGroup = (ViewGroup) ((ViewGroup) findRootContainer).getChildAt(0);
            } else {
                viewGroup = (ViewGroup) findRootContainer;
            }
            ImageView imageView2 = new ImageView(this);
            imageView2.setId(R.id.gga);
            imageView2.setLayoutParams(layoutParams2);
            imageView2.setVisibility(8);
            ((ViewGroup) getWindow().getDecorView()).removeView(findRootContainer);
            findRootContainer.setId(R.id.e8x);
            fitSystemWindowLayoutView2.addView(findRootContainer);
            fitSystemWindowLayoutView2.addView(imageView2);
            fitSystemWindowLayoutView2.addView(testTimeForChatting);
            ((ViewGroup) getWindow().getDecorView()).addView(fitSystemWindowLayoutView2);
            getWindow().getDecorView().requestFitSystemWindows();
            int i3 = iArr2[1];
            if (i3 > 0) {
                updateRootViewSystemWindowsInsets(fitSystemWindowLayoutView2, i3, new Rect(0, i3, 0, 0), viewGroup);
            } else {
                getSupportActionBar().getCustomView().post(new Runnable() {
                    /* class com.tencent.mm.ui.conversation.BaseConversationUI.AnonymousClass7 */

                    public final void run() {
                        AppMethodBeat.i(38175);
                        BaseConversationUI.this.getSupportActionBar().getCustomView().getLocationInWindow(iArr2);
                        int i2 = iArr2[1];
                        if (i2 > 0) {
                            BaseConversationUI.access$1300(BaseConversationUI.this, fitSystemWindowLayoutView2, i2, new Rect(0, i2, 0, 0), viewGroup);
                            AppMethodBeat.o(38175);
                            return;
                        }
                        if (com.tencent.mm.compatible.util.d.oD(20)) {
                            fitSystemWindowLayoutView2.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                                /* class com.tencent.mm.ui.conversation.BaseConversationUI.AnonymousClass7.AnonymousClass1 */

                                @TargetApi(20)
                                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                                    AppMethodBeat.i(38174);
                                    if (windowInsets == null) {
                                        AppMethodBeat.o(38174);
                                    } else {
                                        Log.i(BaseConversationUI.TAG, "OnApplyWindowInsetsListener %s", windowInsets);
                                        windowInsets.consumeSystemWindowInsets();
                                        BaseConversationUI.access$1300(BaseConversationUI.this, fitSystemWindowLayoutView2, windowInsets.getSystemWindowInsetTop(), new Rect(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom()), viewGroup);
                                        AppMethodBeat.o(38174);
                                    }
                                    return windowInsets;
                                }
                            });
                        }
                        AppMethodBeat.o(38175);
                    }
                });
            }
            this.chattingView = (TestTimeForChatting) findViewById(this.chattingID);
            Log.i(TAG, "ashu::prepareChattingFragment init chattingView, top %s", Integer.valueOf(iArr2[1]));
            AppMethodBeat.o(38210);
        }
    }

    public Bitmap getMagicDrawingCache(View view) {
        int i2;
        int i3;
        AppMethodBeat.i(38211);
        long currentTimeMillis = System.currentTimeMillis();
        int width = view.getWidth();
        int height = view.getHeight();
        if (width <= 0) {
            i2 = view.getMeasuredWidth();
        } else {
            i2 = width;
        }
        if (height <= 0) {
            i3 = view.getMeasuredHeight();
        } else {
            i3 = height;
        }
        if (i2 <= 0 || i3 <= 0 || this.chattingFragmet.getView() == null) {
            Log.e(TAG, "viewWidth:%s viewHeight:%s", Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(38211);
            return null;
        }
        if (this.chattingFragmet != null) {
            Log.i(TAG, "getBottom:%s keyboardState:%s", Integer.valueOf(this.chattingFragmet.getView().getBottom()), Integer.valueOf(this.chattingFragmet.keyboardState()));
        }
        if (this.chattingFragmet != null && this.chattingFragmet.getView().getBottom() > 0 && (this.chattingFragmet.keyboardState() == 1 || this.chattingFragmet.getView().getBottom() < (getResources().getDisplayMetrics().heightPixels * 2) / 3)) {
            Log.e(TAG, "hardKeyboardHidden:%s", Integer.valueOf(this.chattingFragmet.keyboardState()));
            AppMethodBeat.o(38211);
            return null;
        } else if (this.chattingFragmet == null || this.chattingFragmet.keyboardState() != 1) {
            if (this.mPrepareBitmap == null || this.mPrepareBitmap.isRecycled() || this.mPrepareBitmap.getWidth() != i2 || this.mPrepareBitmap.getHeight() != i3) {
                if (this.mPrepareBitmap != null && !this.mPrepareBitmap.isRecycled()) {
                    Log.i(TAG, "bitmap recycle %s", this.mPrepareBitmap.toString());
                    this.mPrepareBitmap.recycle();
                }
                try {
                    this.mPrepareBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_4444);
                } catch (OutOfMemoryError e2) {
                    Log.e(TAG, "[getMagicDrawingCache] e:%s", e2);
                    AppMethodBeat.o(38211);
                    return null;
                }
            } else {
                this.mPrepareBitmap.eraseColor(0);
            }
            Canvas canvas = new Canvas(this.mPrepareBitmap);
            int dimension = (int) getResources().getDimension(R.dimen.apf);
            Paint paint = new Paint();
            paint.setColor(-1);
            canvas.drawRect(0.0f, (float) dimension, (float) i2, (float) (i3 - ((int) getResources().getDimension(R.dimen.bc))), paint);
            view.draw(canvas);
            Log.i(TAG, "[getMagicDrawingCache] cost%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            Bitmap bitmap = this.mPrepareBitmap;
            AppMethodBeat.o(38211);
            return bitmap;
        } else {
            Log.e(TAG, "hardKeyboardHidden:%s", Integer.valueOf(this.chattingFragmet.keyboardState()));
            AppMethodBeat.o(38211);
            return null;
        }
    }

    private void updateRootViewSystemWindowsInsets(HomeUI.FitSystemWindowLayoutView fitSystemWindowLayoutView, int i2, Rect rect, ViewGroup viewGroup) {
        int i3;
        AppMethodBeat.i(38212);
        int bottom = getWindow().getDecorView().getBottom();
        int bottom2 = getSupportActionBar().getCustomView().getBottom();
        if (this.conversationFm == null || this.conversationFm.getView() == null) {
            i3 = 0;
        } else {
            i3 = bottom - ((i2 + bottom2) + this.conversationFm.getView().getBottom());
        }
        Log.i(TAG, "ashu::fitSystemWindows 2. decorBottom:%d, statusBarHeight:%d, actionBarHeight:%d, paddingForNavBar:%d", Integer.valueOf(bottom), Integer.valueOf(i2), Integer.valueOf(bottom2), Integer.valueOf(i3));
        fitSystemWindowLayoutView.setActionBarContainer(viewGroup);
        fitSystemWindowLayoutView.fitSystemWindows(rect);
        AppMethodBeat.o(38212);
    }

    private ViewGroup findRootContainer() {
        AppMethodBeat.i(38213);
        ViewParent parent = this.mActionBar.getCustomView().getParent();
        ViewGroup viewGroup = null;
        ViewGroup viewGroup2 = (ViewGroup) getWindow().getDecorView();
        while (parent != viewGroup2 && parent != null) {
            viewGroup = parent;
            parent = parent.getParent();
        }
        ViewGroup viewGroup3 = viewGroup;
        AppMethodBeat.o(38213);
        return viewGroup3;
    }

    public void pauseMainFragment() {
        AppMethodBeat.i(38214);
        if (this.conversationFm != null && !this.conversationFm.isSupportNavigationSwipeBack()) {
            this.conversationFm.showOptionMenu(false);
        }
        AppMethodBeat.o(38214);
    }

    public void resumeMainFragment() {
        AppMethodBeat.i(38215);
        if (this.conversationFm != null) {
            this.conversationFm.onResume();
            if (!this.conversationFm.isSupportNavigationSwipeBack()) {
                this.conversationFm.showOptionMenu(true);
            }
        }
        AppMethodBeat.o(38215);
    }

    public void closeChatting(boolean z) {
        ImageView imageView;
        AppMethodBeat.i(38216);
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.chattingView == null ? false : this.chattingView.isShown());
        Log.i(TAG, "try closeChatting, ishow:%b", objArr);
        if (this.chattingFragmet != null && this.chattingFragmet.isSupportNavigationSwipeBack()) {
            h.b(this);
        }
        if (this.chattingView == null || this.chattingView.getVisibility() == 8 || this.chattingFragmet == null) {
            AppMethodBeat.o(38216);
            return;
        }
        Log.i(TAG, "[closeChatting] needAnim:%s", Boolean.valueOf(z));
        this.chattingView.setVisibility(8);
        this.mChattingClosed = true;
        if (z && this.mChattingOutAnim == null) {
            this.mChattingOutAnim = AnimationUtils.loadAnimation(this, MMFragmentActivity.a.ogp);
            this.mChattingOutAnim.setAnimationListener(new Animation.AnimationListener() {
                /* class com.tencent.mm.ui.conversation.BaseConversationUI.AnonymousClass9 */

                public final void onAnimationStart(Animation animation) {
                    AppMethodBeat.i(38179);
                    bg.aAk().setLowestPriority();
                    MMHandlerThread.setCurrentPriority(-8);
                    Log.i(BaseConversationUI.TAG, "klem pop out onAnimationStart");
                    BaseConversationUI.this.onSettle(true, 0);
                    AppMethodBeat.o(38179);
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(38180);
                    bg.aAk().setLowPriority();
                    MMHandlerThread.setCurrentPriority(0);
                    BaseConversationUI.access$600(BaseConversationUI.this);
                    Log.i(BaseConversationUI.TAG, "klem pop out onAnimationEnd");
                    AppMethodBeat.o(38180);
                }
            });
        }
        if (this.chattingFragmet.isSupportCustomActionBar() && (imageView = (ImageView) getWindow().getDecorView().findViewById(R.id.gga)) != null && imageView.getVisibility() == 0) {
            imageView.setVisibility(8);
            Log.i(TAG, "[closeChatting] prepareView GONE");
            if (imageView.getTag() != null) {
                ((View) imageView.getTag()).setVisibility(0);
            }
        }
        if (z) {
            this.chattingUIProxy.onExitBegin();
            this.chattingUIProxy.onExitEnd();
            this.chattingView.startAnimation(this.mChattingOutAnim);
        } else {
            this.chattingUIProxy.onExitBegin();
            this.chattingUIProxy.onExitEnd();
            this.chattingView.setVisibility(8);
            onSwipe(1.0f);
            tryResetChattingSwipeStatus();
        }
        if (!this.chattingFragmet.isSupportCustomActionBar()) {
            initActionBar();
        }
        supportInvalidateOptionsMenu();
        resumeMainFragment();
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.ui.conversation.BaseConversationUI.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(38181);
                if (BaseConversationUI.this.chattingFragmet == null) {
                    AppMethodBeat.o(38181);
                    return;
                }
                d.d(4, "ChattingUI" + BaseConversationUI.access$000(BaseConversationUI.this), BaseConversationUI.this.chattingFragmet.hashCode());
                d.m("ChattingUI" + BaseConversationUI.access$000(BaseConversationUI.this), BaseConversationUI.this.chattinguiResumeTime, Util.nowSecond());
                d.d(3, BaseConversationUI.this.getLocalClassName(), BaseConversationUI.this.hashCode());
                AppMethodBeat.o(38181);
            }
        }, "directReport_closeChatting");
        AppMethodBeat.o(38216);
    }

    private void initActionBar() {
        AppMethodBeat.i(38217);
        if (this.chattingFragmet == null || !this.chattingFragmet.dom.cQp) {
            Log.w(TAG, "[initActionBar] isChattingForeground False!");
            View inflate = aa.jQ(this).inflate(R.layout.bb, (ViewGroup) null);
            this.mActionBarHelper = new com.tencent.mm.ui.a(inflate);
            this.mActionBar.setLogo(new ColorDrawable(getResources().getColor(17170445)));
            this.mActionBar.gt();
            this.mActionBar.setDisplayHomeAsUpEnabled(false);
            this.mActionBar.gs();
            this.mActionBar.gu();
            this.mActionBar.setCustomView(inflate);
            updateTitle();
            this.mActionBarHelper.setClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.conversation.BaseConversationUI.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(38165);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/BaseConversationUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (BaseConversationUI.this.isAnimating) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/BaseConversationUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(38165);
                        return;
                    }
                    MMHandlerThread.removeRunnable(BaseConversationUI.this.startChattingRunnable);
                    BaseConversationUI.this.finish();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/BaseConversationUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(38165);
                }
            });
            if (this.mActionBar.getCustomView() != null) {
                this.mActionBar.getCustomView().findViewById(R.id.uo);
                ((TextView) this.mActionBar.getCustomView().findViewById(R.id.ipt)).setTextColor(getResources().getColor(R.color.fr));
            }
            AppMethodBeat.o(38217);
            return;
        }
        Log.w(TAG, "[initActionBar] isChattingForeground True!");
        AppMethodBeat.o(38217);
    }

    public void updateTitle() {
        AppMethodBeat.i(38218);
        if (this.mActionBarHelper != null) {
            this.mActionBarHelper.setTitle(com.tencent.mm.model.aa.getDisplayName(this.title));
        }
        AppMethodBeat.o(38218);
    }

    public void setTitle(String str) {
        AppMethodBeat.i(38219);
        this.title = str;
        if (this.mActionBarHelper != null) {
            updateTitle();
        }
        AppMethodBeat.o(38219);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        AppMethodBeat.i(38220);
        if (this.chattingFragmet == null || this.chattingFragmet.gNg() == null || !this.chattingFragmet.isSupportCustomActionBar()) {
            AppMethodBeat.o(38220);
            return null;
        } else if (com.tencent.mm.compatible.util.d.oF(22)) {
            AppMethodBeat.o(38220);
            return null;
        } else {
            ActionMode startActionMode = this.chattingFragmet.gNg().startActionMode(callback);
            if (startActionMode == null) {
                AppMethodBeat.o(38220);
                return null;
            }
            AppMethodBeat.o(38220);
            return startActionMode;
        }
    }

    class b implements Runnable {
        int OJY;
        Intent dQs;
        int requestCode;
        int resultCode;

        private b() {
            this.OJY = 0;
        }

        /* synthetic */ b(BaseConversationUI baseConversationUI, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(38193);
            if (bg.aAc()) {
                Log.i(BaseConversationUI.TAG, "on post select image job, acc has ready, retry count %d", Integer.valueOf(this.OJY));
                BaseConversationUI.this.startChatting(BaseConversationUI.this.lastRestoreTalker);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.ui.conversation.BaseConversationUI.b.AnonymousClass1 */

                    public final void run() {
                        boolean z = true;
                        AppMethodBeat.i(38191);
                        Object[] objArr = new Object[1];
                        if (BaseConversationUI.this.chattingFragmet != null) {
                            z = false;
                        }
                        objArr[0] = Boolean.valueOf(z);
                        Log.d(BaseConversationUI.TAG, "on select image ActivityResult. after creat chattingUI, chatting fragment is null? %B", objArr);
                        if (BaseConversationUI.this.chattingFragmet != null) {
                            Log.d(BaseConversationUI.TAG, "on select image ActivityResult. do post activity result");
                            BaseConversationUI.this.chattingFragmet.onActivityResult(b.this.requestCode & 65535, b.this.resultCode, b.this.dQs);
                        }
                        AppMethodBeat.o(38191);
                    }

                    public final String toString() {
                        AppMethodBeat.i(38192);
                        String str = super.toString() + "|PostSelectImageJob_onActivityResult";
                        AppMethodBeat.o(38192);
                        return str;
                    }
                });
                AppMethodBeat.o(38193);
            } else if (this.OJY >= 3) {
                Log.w(BaseConversationUI.TAG, "on post select image job, match max retry count");
                AppMethodBeat.o(38193);
            } else {
                Log.w(BaseConversationUI.TAG, "on post select image job, acc not ready, cur retry count %d", Integer.valueOf(this.OJY));
                this.OJY++;
                MMHandlerThread.postToMainThreadDelayed(this, 300);
                AppMethodBeat.o(38193);
            }
        }

        public final String toString() {
            AppMethodBeat.i(38194);
            String str = super.toString() + "|PostSelectImageJob";
            AppMethodBeat.o(38194);
            return str;
        }
    }

    private boolean acceptRequestCode(int i2) {
        AppMethodBeat.i(38221);
        int i3 = 65535 & i2;
        Log.w(TAG, "check request code %d", Integer.valueOf(i3));
        switch (i3) {
            case 217:
            case 218:
                AppMethodBeat.o(38221);
                return true;
            default:
                AppMethodBeat.o(38221);
                return false;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public void onRestoreInstanceState(Bundle bundle) {
        AppMethodBeat.i(38222);
        super.onRestoreInstanceState(bundle);
        this.lastRestoreTalker = bundle.getString(LAST_RESTORE_TALKER);
        Log.d(TAG, "onRestoreInstantceState:%s", this.lastRestoreTalker);
        AppMethodBeat.o(38222);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(38223);
        if (this.chattingFragmet != null && !Util.isNullOrNil(this.chattingFragmet.dom.getTalkerUserName())) {
            Log.d(TAG, "onSaveInstanceState:%s", this.chattingFragmet.dom.getTalkerUserName());
            bundle.putString(LAST_RESTORE_TALKER, this.chattingFragmet.dom.getTalkerUserName());
        }
        AppMethodBeat.o(38223);
    }

    @Override // com.tencent.mm.ui.widget.h.a, com.tencent.mm.ui.MMFragmentActivity
    public void onSettle(boolean z, int i2) {
        long j2 = 130;
        AppMethodBeat.i(38224);
        Log.v(TAG, "ashutest: on settle %B, speed %d, resumeStatus %s", Boolean.valueOf(z), Integer.valueOf(i2), this.launcherUIStatus);
        if (!com.tencent.mm.compatible.util.d.oD(19) || !com.tencent.mm.compatible.h.b.apl()) {
            AppMethodBeat.o(38224);
            return;
        }
        View findViewById = findViewById(R.id.e8x);
        if (findViewById == null) {
            Log.e(TAG, "[onSettle] null == container");
            AppMethodBeat.o(38224);
            return;
        }
        ImageView imageView = (ImageView) findViewById(R.id.gga);
        if (!(imageView == null || imageView.getVisibility() != 8 || imageView.getDrawable() == null)) {
            imageView.setVisibility(0);
            Log.i(TAG, "[onSettle] prepareView VISIBLE");
            findViewById.setVisibility(8);
        }
        if (imageView == null || imageView.getVisibility() != 0) {
            if (z) {
                if (i2 <= 0) {
                    j2 = 230;
                }
                j.a(findViewById, j2, 0.0f, null);
                AppMethodBeat.o(38224);
                return;
            }
            if (i2 <= 0) {
                j2 = 230;
            }
            j.a(findViewById, j2, (float) ((findViewById.getWidth() * -1) / 4), null);
            AppMethodBeat.o(38224);
        } else if (z) {
            if (i2 <= 0) {
                j2 = 230;
            }
            j.a(imageView, j2, 0.0f, null);
            AppMethodBeat.o(38224);
        } else {
            if (i2 <= 0) {
                j2 = 230;
            }
            j.a(imageView, j2, (float) ((imageView.getWidth() * -1) / 4), null);
            AppMethodBeat.o(38224);
        }
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(38225);
        Log.d(TAG, "chatting ui dispatch key event %s", keyEvent);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            MMHandlerThread.removeRunnable(this.startChattingRunnable);
        }
        if (this.isAnimating) {
            AppMethodBeat.o(38225);
            return true;
        } else if (this.chattingFragmet == null || !this.chattingFragmet.onKeyDown(keyEvent.getKeyCode(), keyEvent)) {
            boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
            AppMethodBeat.o(38225);
            return dispatchKeyEvent;
        } else {
            AppMethodBeat.o(38225);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public ChattingUIFragment getChattingUIFragment() {
        AppMethodBeat.i(38226);
        ChattingUIFragment chattingUIFragment = new ChattingUIFragment();
        AppMethodBeat.o(38226);
        return chattingUIFragment;
    }

    private String getIdentityString() {
        AppMethodBeat.i(38227);
        if (this.chattingFragmet != null) {
            String identityString = this.chattingFragmet.getIdentityString();
            AppMethodBeat.o(38227);
            return identityString;
        }
        AppMethodBeat.o(38227);
        return "";
    }

    private void tryResetChattingSwipeStatus() {
        boolean z = true;
        AppMethodBeat.i(38206);
        if (!com.tencent.mm.compatible.util.d.oD(19) || !com.tencent.mm.compatible.h.b.apl()) {
            AppMethodBeat.o(38206);
            return;
        }
        Object[] objArr = new Object[1];
        if (this.chattingFragmet != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        Log.i(TAG, "ashutest: tryResetChattingSwipeStatus, chattingFragment NULL ? %B", objArr);
        if (this.chattingFragmet != null) {
            this.chattingFragmet.getSwipeBackLayout().hfx = false;
        }
        AppMethodBeat.o(38206);
    }
}
