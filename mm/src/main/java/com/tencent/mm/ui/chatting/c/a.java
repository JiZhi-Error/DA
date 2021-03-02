package com.tencent.mm.ui.chatting.c;

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
import android.view.KeyEvent;
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
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.j.a;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.chatting.ChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUIProxy;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.h;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public final class a implements com.tencent.mm.j.a, h.a {
    boolean OJQ;
    ChattingUIFragment Pmo;
    final ChattingUIProxy Pmp;
    Animation Pmq;
    boolean Pmr = false;
    String Pms;
    private EnumC2090a Pmt = EnumC2090a.ACTIVITY_CREATE;
    HashSet<a.b> Pmu = new HashSet<>();
    a.c Pmv;
    public boolean Pmw = false;
    MMActivity activity;
    private int chattingID;
    TestTimeForChatting chattingView;
    boolean isAnimating;
    ActionBar mActionBar;
    private Bitmap mPrepareBitmap;
    MMHandler mainHandler = new MMHandler(Looper.getMainLooper());
    OnLayoutChangedLinearLayout.a onChattingLayoutChangedListener = new OnLayoutChangedLinearLayout.a() {
        /* class com.tencent.mm.ui.chatting.c.a.AnonymousClass3 */
        long start = 0;

        @Override // com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a
        public final void gJw() {
            AppMethodBeat.i(232963);
            if (a.this.Pmq == null) {
                a.this.Pmq = AnimationUtils.loadAnimation(a.this.activity, MMFragmentActivity.a.ogm);
                a.this.Pmq.setAnimationListener(new Animation.AnimationListener() {
                    /* class com.tencent.mm.ui.chatting.c.a.AnonymousClass3.AnonymousClass1 */

                    public final void onAnimationStart(Animation animation) {
                        AppMethodBeat.i(232960);
                        Log.i("ChattingCompat", "klem onAnimationStart onDrawed->onAnimationStart:%sms", Long.valueOf(System.currentTimeMillis() - AnonymousClass3.this.start));
                        a.this.isAnimating = true;
                        a aVar = a.this;
                        aVar.chattingView.setTranslationX(0.0f);
                        aVar.chattingView.gXV();
                        a.this.onSettle(false, 0);
                        AppMethodBeat.o(232960);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(232961);
                        a.this.isAnimating = false;
                        Log.i("ChattingCompat", "klem animationEnd");
                        com.tencent.f.h.RTc.n(new Runnable() {
                            /* class com.tencent.mm.ui.chatting.c.a.AnonymousClass4 */

                            public final void run() {
                                AppMethodBeat.i(232964);
                                a.this.onSwipe(1.0f);
                                if (!(a.this.chattingView == null || a.this.Pmo == null)) {
                                    a.this.chattingView.gXW();
                                }
                                a.this.Pmp.onEnterEnd();
                                a.this.tryResetChattingSwipeStatus();
                                AppMethodBeat.o(232964);
                            }
                        }, 60);
                        AppMethodBeat.o(232961);
                    }
                });
            }
            a.this.chattingView.setOndispatchDraw(new TestTimeForChatting.a() {
                /* class com.tencent.mm.ui.chatting.c.a.AnonymousClass3.AnonymousClass2 */

                @Override // com.tencent.mm.ui.tools.TestTimeForChatting.a
                public final void gJx() {
                    AppMethodBeat.i(232962);
                    Log.i("ChattingCompat", "[onDrawed]");
                    AnonymousClass3.this.start = System.currentTimeMillis();
                    if (a.this.Pmo == null) {
                        Log.e("ChattingCompat", "chattingFragmet is null!");
                        AppMethodBeat.o(232962);
                        return;
                    }
                    if (a.this.Pmo.getSwipeBackLayout() != null) {
                        a.this.Pmo.getSwipeBackLayout().startAnimation(a.this.Pmq);
                    } else {
                        a.this.Pmo.getView().startAnimation(a.this.Pmq);
                    }
                    a.this.chattingView.setOndispatchDraw(null);
                    AppMethodBeat.o(232962);
                }
            });
            ((OnLayoutChangedLinearLayout) Objects.requireNonNull(a.b(a.this))).OWo = null;
            Log.i("ChattingCompat", "klem CHATTING ONLAYOUT ");
            AppMethodBeat.o(232963);
        }
    };
    Bundle pendingBundle;
    String pendingUser;
    Runnable startChattingRunnable = new Runnable() {
        /* class com.tencent.mm.ui.chatting.c.a.AnonymousClass2 */

        public final void run() {
            AppMethodBeat.i(232959);
            a.this.statusBarColor = a.this.activity.getController().statusBarColor;
            if (!a.this.Pmr) {
                Log.e("ChattingCompat", "start chatting but last chatting does't be close!");
                a.this.ant();
            }
            if (a.this.activity.isFinishing() || a.a(a.this) || !a.this.Pmr) {
                Log.w("ChattingCompat", "[startChattingRunnable] pass! isPause:%s mChattingClosed:%s", Boolean.valueOf(a.a(a.this)), Boolean.valueOf(a.this.Pmr));
                a.this.OJQ = true;
                AppMethodBeat.o(232959);
                return;
            }
            a.this.Pmr = false;
            Iterator<a.b> it = a.this.Pmu.iterator();
            while (it.hasNext()) {
                it.next().anx();
            }
            Intent putExtra = new Intent().putExtra("Chat_User", a.this.pendingUser);
            putExtra.putExtra("Chat_Self", a.this.Pms);
            if (a.this.pendingBundle != null) {
                putExtra.putExtras(a.this.pendingBundle);
            }
            putExtra.putExtra("img_gallery_enter_from_chatting_ui", true);
            a.this.Pmo.getArguments().putAll(IntentUtil.getExtras(putExtra));
            a.a(a.this, false);
            a.b(a.this).setOnChattingLayoutChangedListener(a.this.onChattingLayoutChangedListener);
            a.this.chattingView.setTranslationX((a.this.activity.getWindow().getDecorView().getWidth() == 0 ? (float) a.this.activity.getResources().getDisplayMetrics().widthPixels : (float) a.this.activity.getWindow().getDecorView().getWidth()) - 0.1f);
            a.this.chattingView.setVisibility(0);
            h.a(a.this);
            AppMethodBeat.o(232959);
        }
    };
    int statusBarColor = -1;

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.ui.chatting.c.a$a  reason: collision with other inner class name */
    public enum EnumC2090a {
        ACTIVITY_CREATE,
        ACTIVITY_RESUME,
        ACTIVITY_PAUSE;

        public static EnumC2090a valueOf(String str) {
            AppMethodBeat.i(232969);
            EnumC2090a aVar = (EnumC2090a) Enum.valueOf(EnumC2090a.class, str);
            AppMethodBeat.o(232969);
            return aVar;
        }

        static {
            AppMethodBeat.i(232970);
            AppMethodBeat.o(232970);
        }
    }

    a(MMActivity mMActivity) {
        AppMethodBeat.i(232971);
        this.activity = mMActivity;
        this.Pmo = new ChattingUIFragment();
        this.Pmp = new ChattingUIProxy(mMActivity, this.Pmo);
        AppMethodBeat.o(232971);
    }

    @Override // com.tencent.mm.j.a
    public final void c(Boolean bool) {
        AppMethodBeat.i(232972);
        this.Pmw = bool.booleanValue();
        AppMethodBeat.o(232972);
    }

    @Override // com.tencent.mm.j.a
    public final void a(String str, String str2, a.b bVar) {
        AppMethodBeat.i(232973);
        a(bVar);
        this.pendingUser = str;
        this.Pms = str2;
        this.pendingBundle = null;
        this.OJQ = false;
        this.mainHandler.removeCallbacks(this.startChattingRunnable);
        this.mainHandler.post(this.startChattingRunnable);
        AppMethodBeat.o(232973);
    }

    @Override // com.tencent.mm.j.a
    public final void ant() {
        boolean z = true;
        AppMethodBeat.i(232974);
        this.Pmr = true;
        Object[] objArr = new Object[1];
        if (this.chattingView == null || !this.chattingView.isShown()) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        Log.i("ChattingCompat", "try closeChatting, isShown:%b", objArr);
        if (this.Pmo != null && this.Pmo.isSupportNavigationSwipeBack()) {
            h.b(this);
        }
        if (this.chattingView == null || this.chattingView.getVisibility() == 8 || this.Pmo == null) {
            AppMethodBeat.o(232974);
            return;
        }
        Iterator<a.b> it = this.Pmu.iterator();
        while (it.hasNext()) {
            if (!it.next().any()) {
                it.remove();
            }
        }
        this.chattingView.setVisibility(8);
        ImageView imageView = (ImageView) this.activity.getWindow().getDecorView().findViewById(R.id.gga);
        if (imageView != null && imageView.getVisibility() == 0) {
            imageView.setVisibility(8);
            Log.i("ChattingCompat", "[closeChatting] prepareView GONE");
            if (imageView.getTag() != null) {
                ((View) imageView.getTag()).setVisibility(0);
            }
        }
        this.Pmp.onExitBegin();
        this.Pmp.onExitEnd();
        this.chattingView.setVisibility(8);
        onSwipe(1.0f);
        tryResetChattingSwipeStatus();
        this.activity.getController().setStatusBarColor(this.statusBarColor);
        AppMethodBeat.o(232974);
    }

    @Override // com.tencent.mm.j.a
    public final void onPause() {
        this.Pmt = EnumC2090a.ACTIVITY_PAUSE;
    }

    @Override // com.tencent.mm.j.a
    public final void onResume() {
        boolean z;
        AppMethodBeat.i(232977);
        this.Pmt = EnumC2090a.ACTIVITY_RESUME;
        onSwipe(1.0f);
        if (this.Pmo == null || !this.Pmo.dom.cQp) {
            z = false;
        } else {
            z = true;
        }
        if (!z && this.OJQ) {
            String str = this.pendingUser;
            Bundle bundle = this.pendingBundle;
            this.pendingUser = str;
            this.pendingBundle = bundle;
            this.OJQ = false;
            this.mainHandler.removeCallbacks(this.startChattingRunnable);
            this.mainHandler.post(this.startChattingRunnable);
        }
        AppMethodBeat.o(232977);
    }

    @Override // com.tencent.mm.j.a
    public final void onDestroy() {
        AppMethodBeat.i(232978);
        if (this.mPrepareBitmap != null && !this.mPrepareBitmap.isRecycled()) {
            Log.i("ChattingCompat", "bitmap recycle %s", this.mPrepareBitmap.toString());
            this.mPrepareBitmap.recycle();
        }
        this.OJQ = false;
        this.Pmu.clear();
        this.mainHandler.removeCallbacksAndMessages(null);
        this.activity = null;
        this.Pmo = null;
        this.chattingView = null;
        this.Pmq = null;
        AppMethodBeat.o(232978);
    }

    @Override // com.tencent.mm.j.a
    public final boolean onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(232979);
        if ((i2 == 2001 || i2 == 30763 || i2 == 226 || i2 == 30762 || i2 == 1111) && this.Pmo != null) {
            this.Pmo.onActivityResult(i2, i3, intent);
            AppMethodBeat.o(232979);
            return true;
        }
        AppMethodBeat.o(232979);
        return false;
    }

    @Override // com.tencent.mm.j.a
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(232980);
        if (this.Pmo != null) {
            this.Pmo.onRequestPermissionsResult(i2, strArr, iArr);
        }
        AppMethodBeat.o(232980);
    }

    @Override // com.tencent.mm.ui.widget.h.a
    public final void onSettle(boolean z, int i2) {
        long j2 = 130;
        AppMethodBeat.i(232981);
        Log.v("ChattingCompat", "ashutest: on settle %B, speed %d, resumeStatus %s", Boolean.valueOf(z), Integer.valueOf(i2), this.Pmt);
        if (!d.oD(19) || !b.apl()) {
            AppMethodBeat.o(232981);
            return;
        }
        View findViewById = this.activity.findViewById(R.id.e8x);
        if (findViewById == null) {
            Log.e("ChattingCompat", "[onSettle] null == container");
            AppMethodBeat.o(232981);
            return;
        }
        ImageView imageView = (ImageView) this.activity.findViewById(R.id.gga);
        if (!(imageView == null || imageView.getVisibility() != 8 || imageView.getDrawable() == null)) {
            imageView.setVisibility(0);
            Log.i("ChattingCompat", "[onSettle] prepareView VISIBLE");
            findViewById.setVisibility(8);
        }
        if (imageView == null || imageView.getVisibility() != 0) {
            if (z) {
                if (i2 <= 0) {
                    j2 = 230;
                }
                j.a(findViewById, j2, 0.0f, null);
                AppMethodBeat.o(232981);
                return;
            }
            if (i2 <= 0) {
                j2 = 230;
            }
            j.a(findViewById, j2, (float) ((findViewById.getWidth() * -1) / 4), null);
            AppMethodBeat.o(232981);
        } else if (z) {
            if (i2 <= 0) {
                j2 = 230;
            }
            j.a(imageView, j2, 0.0f, null);
            AppMethodBeat.o(232981);
        } else {
            if (i2 <= 0) {
                j2 = 230;
            }
            j.a(imageView, j2, (float) ((imageView.getWidth() * -1) / 4), null);
            AppMethodBeat.o(232981);
        }
    }

    @Override // com.tencent.mm.ui.widget.h.a
    public final boolean forceRemoveNoMatchOnPath() {
        return false;
    }

    @Override // com.tencent.mm.ui.widget.h.a
    public final void onSwipe(float f2) {
        ViewGroup viewGroup;
        AppMethodBeat.i(232983);
        Log.v("ChattingCompat", "ashutest::on swipe %f, duration %d, status %s", Float.valueOf(f2), 320L, this.Pmt);
        if (!d.oD(19) || !b.apl()) {
            AppMethodBeat.o(232983);
        } else if (this.Pmo == null) {
            AppMethodBeat.o(232983);
        } else {
            if (f2 == 0.0f && !this.Pmr) {
                ImageView imageView = (ImageView) this.activity.getWindow().getDecorView().findViewById(R.id.gga);
                if (!(imageView == null || (viewGroup = (ViewGroup) imageView.getTag()) == null)) {
                    Log.i("ChattingCompat", "[onSwipe] prepareView GONE");
                    viewGroup.setVisibility(0);
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
                if (this.Pmq != null) {
                    this.Pmq.cancel();
                }
            } else if (f2 == 1.0f && !this.Pmr && this.Pmo.isSupportNavigationSwipeBack()) {
                this.activity.getWindow().setBackgroundDrawableResource(R.color.a5p);
                ImageView imageView2 = (ImageView) this.activity.getWindow().getDecorView().findViewById(R.id.gga);
                if (!(imageView2 == null || imageView2.getVisibility() != 0 || imageView2.getTag() == null)) {
                    ((View) imageView2.getTag()).setVisibility(0);
                    Log.i("ChattingCompat", "[onSwipe] prepareView GONE");
                    imageView2.setVisibility(8);
                }
            }
            if (EnumC2090a.ACTIVITY_RESUME == this.Pmt || Float.compare(1.0f, f2) <= 0) {
                View findViewById = this.activity.findViewById(R.id.e8x);
                ImageView imageView3 = (ImageView) this.activity.findViewById(R.id.gga);
                if (!(imageView3 == null || imageView3.getVisibility() != 8 || imageView3.getDrawable() == null || this.Pmr || f2 == 1.0f || f2 == 0.0f)) {
                    imageView3.setVisibility(0);
                    Log.i("ChattingCompat", "[onSwipe] !1 && !0 prepareView VISIBLE");
                    if (findViewById != null) {
                        findViewById.setVisibility(8);
                    }
                }
                if (Float.compare(1.0f, f2) <= 0) {
                    j.q(findViewById, 0.0f);
                    j.q(imageView3, 0.0f);
                    AppMethodBeat.o(232983);
                } else if (imageView3 == null || imageView3.getDrawable() == null) {
                    j.q(findViewById, ((float) (findViewById.getWidth() / 4)) * (1.0f - f2) * -1.0f);
                    AppMethodBeat.o(232983);
                } else {
                    j.q(imageView3, ((float) (imageView3.getWidth() / 4)) * (1.0f - f2) * -1.0f);
                    AppMethodBeat.o(232983);
                }
            } else {
                Log.i("ChattingCompat", "[onSwipe] return! consumedSuperCall:%s", Float.valueOf(f2));
                AppMethodBeat.o(232983);
            }
        }
    }

    @Override // com.tencent.mm.j.a
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(232984);
        Log.d("ChattingCompat", "chatting ui dispatch key event %s", keyEvent);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            this.mainHandler.removeCallbacks(this.startChattingRunnable);
        }
        if (this.isAnimating) {
            AppMethodBeat.o(232984);
            return true;
        } else if (this.Pmo == null || !this.Pmo.onKeyDown(keyEvent.getKeyCode(), keyEvent)) {
            AppMethodBeat.o(232984);
            return false;
        } else {
            AppMethodBeat.o(232984);
            return true;
        }
    }

    @Override // com.tencent.mm.j.a
    public final void a(a.b bVar) {
        AppMethodBeat.i(232985);
        if (bVar != null) {
            this.Pmu.add(bVar);
        }
        AppMethodBeat.o(232985);
    }

    @Override // com.tencent.mm.j.a
    public final void b(a.b bVar) {
        AppMethodBeat.i(232986);
        this.Pmu.remove(bVar);
        AppMethodBeat.o(232986);
    }

    @Override // com.tencent.mm.j.a
    public final boolean anw() {
        return this.Pmr;
    }

    @Override // com.tencent.mm.j.a
    public final void a(a.c cVar) {
        this.Pmv = cVar;
    }

    private Bitmap getMagicDrawingCache(View view) {
        int i2;
        int i3;
        AppMethodBeat.i(232987);
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
        if (i2 <= 0 || i3 <= 0 || this.Pmo.getView() == null) {
            Log.e("ChattingCompat", "viewWidth:%s viewHeight:%s", Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(232987);
            return null;
        }
        Log.i("ChattingCompat", "getBottom:%s keyboardState:%s", Integer.valueOf(this.Pmo.getView().getBottom()), Integer.valueOf(this.Pmo.keyboardState()));
        if (this.Pmo.getView().getBottom() > 0 && (this.Pmo.keyboardState() == 1 || this.Pmo.getView().getBottom() < (this.activity.getResources().getDisplayMetrics().heightPixels * 2) / 3)) {
            Log.e("ChattingCompat", "hardKeyboardHidden:%s", Integer.valueOf(this.Pmo.keyboardState()));
            AppMethodBeat.o(232987);
            return null;
        } else if (this.Pmo.keyboardState() == 1) {
            Log.e("ChattingCompat", "hardKeyboardHidden:%s", Integer.valueOf(this.Pmo.keyboardState()));
            AppMethodBeat.o(232987);
            return null;
        } else {
            if (this.mPrepareBitmap == null || this.mPrepareBitmap.isRecycled() || this.mPrepareBitmap.getWidth() != i2 || this.mPrepareBitmap.getHeight() != i3) {
                if (this.mPrepareBitmap != null && !this.mPrepareBitmap.isRecycled()) {
                    Log.i("ChattingCompat", "bitmap recycle %s", this.mPrepareBitmap.toString());
                    this.mPrepareBitmap.recycle();
                }
                try {
                    this.mPrepareBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_4444);
                } catch (OutOfMemoryError e2) {
                    Log.e("ChattingCompat", "[getMagicDrawingCache] e:%s", e2);
                    AppMethodBeat.o(232987);
                    return null;
                }
            } else {
                this.mPrepareBitmap.eraseColor(0);
            }
            Canvas canvas = new Canvas(this.mPrepareBitmap);
            int dimension = (int) this.activity.getResources().getDimension(R.dimen.apf);
            Paint paint = new Paint();
            paint.setColor(-1);
            canvas.drawRect(0.0f, (float) dimension, (float) i2, (float) (i3 - ((int) this.activity.getResources().getDimension(R.dimen.bc))), paint);
            view.draw(canvas);
            Log.i("ChattingCompat", "[getMagicDrawingCache] cost%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            Bitmap bitmap = this.mPrepareBitmap;
            AppMethodBeat.o(232987);
            return bitmap;
        }
    }

    static void a(HomeUI.FitSystemWindowLayoutView fitSystemWindowLayoutView, Rect rect, ViewGroup viewGroup) {
        AppMethodBeat.i(232988);
        fitSystemWindowLayoutView.setActionBarContainer(viewGroup);
        fitSystemWindowLayoutView.fitSystemWindows(rect);
        AppMethodBeat.o(232988);
    }

    private ViewGroup findRootContainer() {
        AppMethodBeat.i(232989);
        ViewParent parent = this.mActionBar.getCustomView().getParent();
        ViewGroup viewGroup = null;
        ViewGroup viewGroup2 = (ViewGroup) this.activity.getWindow().getDecorView();
        while (parent != viewGroup2 && parent != null) {
            viewGroup = parent;
            parent = parent.getParent();
        }
        ViewGroup viewGroup3 = viewGroup;
        AppMethodBeat.o(232989);
        return viewGroup3;
    }

    @Override // com.tencent.mm.j.a
    public final void anu() {
        AppMethodBeat.i(232975);
        this.activity.getWindow().setFormat(-2);
        com.tencent.mm.pluginsdk.h.q(this.activity);
        this.activity.customfixStatusbar(true);
        AppMethodBeat.o(232975);
    }

    @Override // com.tencent.mm.j.a
    public final void anv() {
        AppMethodBeat.i(232976);
        this.activity.getWindow().setBackgroundDrawableResource(R.color.am);
        this.mActionBar = this.activity.getSupportActionBar();
        this.activity.initNavigationSwipeBack();
        if (this.Pmw) {
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                /* class com.tencent.mm.ui.chatting.c.a.AnonymousClass1 */

                public final boolean queueIdle() {
                    AppMethodBeat.i(232958);
                    if (a.this.activity == null) {
                        AppMethodBeat.o(232958);
                    } else if (a.this.activity.isDestroyed() || a.this.activity.isFinishing()) {
                        AppMethodBeat.o(232958);
                    } else {
                        a.a(a.this, true);
                        AppMethodBeat.o(232958);
                    }
                    return false;
                }
            });
        }
        if (this.Pmo == null || !this.Pmo.dom.cQp) {
            Log.w("ChattingCompat", "[initActionBar] isChattingForeground False!");
            View inflate = aa.jQ(this.activity).inflate(R.layout.bb, (ViewGroup) null);
            com.tencent.mm.ui.a aVar = new com.tencent.mm.ui.a(inflate);
            this.mActionBar.setLogo(new ColorDrawable(this.activity.getResources().getColor(17170445)));
            this.mActionBar.gt();
            this.mActionBar.setDisplayHomeAsUpEnabled(false);
            this.mActionBar.gs();
            this.mActionBar.gu();
            this.mActionBar.setCustomView(inflate);
            this.activity.getController().OGj = aVar.jVO;
            aVar.setClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.c.a.AnonymousClass5 */

                public final void onClick(View view) {
                    AppMethodBeat.i(232965);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/compat/ChattingCompat$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (!a.this.isAnimating) {
                        a.this.mainHandler.removeCallbacks(a.this.startChattingRunnable);
                        if (a.this.Pmv != null) {
                            a.this.Pmv.onFinish();
                        }
                        a.this.activity.finish();
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/compat/ChattingCompat$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(232965);
                }
            });
        } else {
            Log.w("ChattingCompat", "[initActionBar] isChattingForeground True!");
        }
        this.mActionBar.show();
        com.tencent.mm.pluginsdk.h.r(this.activity);
        AppMethodBeat.o(232976);
    }

    /* access modifiers changed from: package-private */
    public final void tryResetChattingSwipeStatus() {
        boolean z = true;
        AppMethodBeat.i(232982);
        if (!d.oD(19) || !b.apl()) {
            AppMethodBeat.o(232982);
            return;
        }
        Object[] objArr = new Object[1];
        if (this.Pmo != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        Log.i("ChattingCompat", "ashutest: tryResetChattingSwipeStatus, chattingFragment NULL ? %B", objArr);
        if (this.Pmo != null) {
            this.Pmo.getSwipeBackLayout().hfx = false;
        }
        AppMethodBeat.o(232982);
    }

    static /* synthetic */ void a(a aVar, boolean z) {
        final ViewGroup viewGroup;
        AppMethodBeat.i(232990);
        if (aVar.chattingView == null) {
            aVar.chattingView = new TestTimeForChatting(aVar.activity);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            aVar.chattingView.setId(R.id.aur);
            aVar.chattingID = aVar.chattingView.getId();
            aVar.chattingView.setOrientation(1);
            int aD = au.aD(aVar.activity);
            Log.i("ChattingCompat", "[prepareChattingView] bottomMargin=%s", Integer.valueOf(aD));
            layoutParams.bottomMargin = aD;
            aVar.chattingView.setLayoutParams(layoutParams);
            final HomeUI.FitSystemWindowLayoutView fitSystemWindowLayoutView = new HomeUI.FitSystemWindowLayoutView(aVar.activity);
            fitSystemWindowLayoutView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            View findRootContainer = aVar.findRootContainer();
            if (findRootContainer == null) {
                findRootContainer = ((ViewGroup) aVar.activity.getWindow().getDecorView()).getChildAt(0);
            }
            ImageView imageView = new ImageView(aVar.activity);
            imageView.setId(R.id.gga);
            imageView.setLayoutParams(layoutParams);
            imageView.setVisibility(8);
            ((ViewGroup) aVar.activity.getWindow().getDecorView()).removeView(findRootContainer);
            findRootContainer.setId(R.id.e8x);
            new FrameLayout.LayoutParams(-1, -1);
            fitSystemWindowLayoutView.addView(findRootContainer);
            fitSystemWindowLayoutView.addView(imageView);
            fitSystemWindowLayoutView.addView(aVar.chattingView);
            ((ViewGroup) aVar.activity.getWindow().getDecorView()).addView(fitSystemWindowLayoutView);
            final int[] iArr = new int[2];
            aVar.mActionBar.getCustomView().getLocationInWindow(iArr);
            if (findRootContainer instanceof SwipeBackLayout) {
                viewGroup = (ViewGroup) ((ViewGroup) findRootContainer).getChildAt(0);
            } else {
                viewGroup = (ViewGroup) findRootContainer;
            }
            if (aVar.chattingView != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) aVar.chattingView.getLayoutParams();
                int aD2 = au.aD(aVar.activity);
                if (layoutParams2.bottomMargin != aD2) {
                    layoutParams2.bottomMargin = aD2;
                    aVar.chattingView.setLayoutParams(layoutParams2);
                }
                Log.i("ChattingCompat", "[fixSystemWindow] bottomMargin=%s", Integer.valueOf(aD2));
            }
            aVar.activity.getWindow().getDecorView().requestFitSystemWindows();
            int i2 = iArr[1];
            if (i2 > 0) {
                a(fitSystemWindowLayoutView, new Rect(0, i2, 0, 0), viewGroup);
            } else {
                aVar.mActionBar.getCustomView().post(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.c.a.AnonymousClass6 */

                    public final void run() {
                        AppMethodBeat.i(232967);
                        a.this.mActionBar.getCustomView().getLocationInWindow(iArr);
                        int i2 = iArr[1];
                        if (i2 > 0) {
                            a.a(fitSystemWindowLayoutView, new Rect(0, i2, 0, 0), viewGroup);
                            AppMethodBeat.o(232967);
                            return;
                        }
                        fitSystemWindowLayoutView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                            /* class com.tencent.mm.ui.chatting.c.a.AnonymousClass6.AnonymousClass1 */

                            @TargetApi(20)
                            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                                AppMethodBeat.i(232966);
                                if (windowInsets == null) {
                                    AppMethodBeat.o(232966);
                                    return null;
                                }
                                Log.i("ChattingCompat", "OnApplyWindowInsetsListener %s", windowInsets);
                                windowInsets.consumeSystemWindowInsets();
                                HomeUI.FitSystemWindowLayoutView fitSystemWindowLayoutView = fitSystemWindowLayoutView;
                                windowInsets.getSystemWindowInsetTop();
                                a.a(fitSystemWindowLayoutView, new Rect(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom()), viewGroup);
                                AppMethodBeat.o(232966);
                                return windowInsets;
                            }
                        });
                        AppMethodBeat.o(232967);
                    }
                });
            }
        } else {
            int[] iArr2 = new int[2];
            aVar.chattingView.getLocationInWindow(iArr2);
            if (iArr2[1] == 0) {
                ViewGroup viewGroup2 = (ViewGroup) aVar.activity.getWindow().getDecorView();
                int i3 = 0;
                while (true) {
                    if (i3 >= viewGroup2.getChildCount()) {
                        break;
                    }
                    View childAt = ((ViewGroup) aVar.activity.getWindow().getDecorView()).getChildAt(i3);
                    if (childAt instanceof HomeUI.FitSystemWindowLayoutView) {
                        aVar.mActionBar.getCustomView().getLocationInWindow(iArr2);
                        HomeUI.FitSystemWindowLayoutView fitSystemWindowLayoutView2 = (HomeUI.FitSystemWindowLayoutView) childAt;
                        fitSystemWindowLayoutView2.fitSystemWindows(new Rect(0, fitSystemWindowLayoutView2.getCacheInsetsTop(), 0, 0));
                        Log.i("ChattingCompat", "rootLayout2 fitSystemWindows, top %s", Integer.valueOf(iArr2[1]));
                        ViewGroup viewGroup3 = (ViewGroup) viewGroup2.findViewById(R.id.e8x);
                        ImageView imageView2 = (ImageView) fitSystemWindowLayoutView2.findViewById(R.id.gga);
                        imageView2.setTag(viewGroup3);
                        ViewGroup.LayoutParams layoutParams3 = viewGroup3.getLayoutParams();
                        if (layoutParams3 == null || (layoutParams3 instanceof FrameLayout.LayoutParams)) {
                            imageView2.setLayoutParams(layoutParams3);
                        } else {
                            Log.w("ChattingCompat", "FIX LayoutParams");
                            imageView2.setLayoutParams(new FrameLayout.LayoutParams(layoutParams3));
                        }
                        Bitmap magicDrawingCache = aVar.getMagicDrawingCache(viewGroup3);
                        if (magicDrawingCache != null) {
                            imageView2.setImageBitmap(magicDrawingCache);
                            viewGroup3.setVisibility(8);
                            imageView2.setVisibility(0);
                            Log.i("ChattingCompat", "[prepareChattingFragment] prepareView VISIBLE");
                        } else {
                            imageView2.setImageBitmap(null);
                        }
                    } else {
                        Log.e("ChattingCompat", "on position %d, rootLayout not found!", Integer.valueOf(i3));
                        i3++;
                    }
                }
            }
            Log.i("ChattingCompat", "ashu::prepareChattingFragment has chattingView, top %s", Integer.valueOf(iArr2[1]));
        }
        if (!aVar.Pmp.isInit) {
            aVar.Pmp.onInit(aVar.chattingID, z);
        } else {
            aVar.Pmp.onEnterBegin();
        }
        if (aVar.Pmo.isSupportNavigationSwipeBack()) {
            aVar.Pmo.getSwipeBackLayout().setNeedRequestActivityTranslucent(false);
        }
        if (z) {
            aVar.chattingView.setVisibility(8);
        }
        AppMethodBeat.o(232990);
    }

    static /* synthetic */ boolean a(a aVar) {
        return aVar.Pmt == EnumC2090a.ACTIVITY_PAUSE;
    }

    static /* synthetic */ OnLayoutChangedLinearLayout b(a aVar) {
        AppMethodBeat.i(232991);
        View view = aVar.Pmo.getView();
        if (view != null) {
            OnLayoutChangedLinearLayout onLayoutChangedLinearLayout = (OnLayoutChangedLinearLayout) view.findViewById(R.id.auc);
            AppMethodBeat.o(232991);
            return onLayoutChangedLinearLayout;
        }
        AppMethodBeat.o(232991);
        return null;
    }
}
