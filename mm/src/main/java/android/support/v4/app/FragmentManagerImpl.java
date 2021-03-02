package android.support.v4.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.arch.lifecycle.ViewModelStore;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* access modifiers changed from: package-private */
public final class FragmentManagerImpl extends g implements LayoutInflater.Factory2 {
    static final Interpolator ACCELERATE_CUBIC = new AccelerateInterpolator(1.5f);
    static final Interpolator ACCELERATE_QUINT = new AccelerateInterpolator(2.5f);
    static final int ANIM_DUR = 220;
    public static final int ANIM_STYLE_CLOSE_ENTER = 3;
    public static final int ANIM_STYLE_CLOSE_EXIT = 4;
    public static final int ANIM_STYLE_FADE_ENTER = 5;
    public static final int ANIM_STYLE_FADE_EXIT = 6;
    public static final int ANIM_STYLE_OPEN_ENTER = 1;
    public static final int ANIM_STYLE_OPEN_EXIT = 2;
    static boolean DEBUG = false;
    static final Interpolator DECELERATE_CUBIC = new DecelerateInterpolator(1.5f);
    static final Interpolator DECELERATE_QUINT = new DecelerateInterpolator(2.5f);
    static final String TAG = "FragmentManager";
    static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    static final String TARGET_STATE_TAG = "android:target_state";
    static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    static final String VIEW_STATE_TAG = "android:view_state";
    static Field sAnimationListenerField = null;
    SparseArray<Fragment> mActive;
    final ArrayList<Fragment> mAdded = new ArrayList<>();
    ArrayList<Integer> mAvailBackStackIndices;
    ArrayList<b> mBackStack;
    ArrayList<g.c> mBackStackChangeListeners;
    ArrayList<b> mBackStackIndices;
    d mContainer;
    ArrayList<Fragment> mCreatedMenus;
    int mCurState = 0;
    boolean mDestroyed;
    Runnable mExecCommit = new Runnable() {
        /* class android.support.v4.app.FragmentManagerImpl.AnonymousClass1 */

        public final void run() {
            FragmentManagerImpl.this.execPendingActions();
        }
    };
    boolean mExecutingActions;
    boolean mHavePendingDeferredStart;
    f mHost;
    private final CopyOnWriteArrayList<f> mLifecycleCallbacks = new CopyOnWriteArrayList<>();
    boolean mNeedMenuInvalidate;
    int mNextFragmentIndex = 0;
    String mNoTransactionsBecause;
    Fragment mParent;
    ArrayList<h> mPendingActions;
    ArrayList<j> mPostponedTransactions;
    Fragment mPrimaryNav;
    h mSavedNonConfig;
    SparseArray<Parcelable> mStateArray = null;
    Bundle mStateBundle = null;
    boolean mStateSaved;
    boolean mStopped;
    ArrayList<Fragment> mTmpAddedFragments;
    ArrayList<Boolean> mTmpIsPop;
    ArrayList<b> mTmpRecords;

    /* access modifiers changed from: package-private */
    public static class g {
        public static final int[] FU = {16842755, 16842960, 16842961};
    }

    /* access modifiers changed from: package-private */
    public interface h {
        boolean a(ArrayList<b> arrayList, ArrayList<Boolean> arrayList2);
    }

    FragmentManagerImpl() {
    }

    /* access modifiers changed from: package-private */
    public static final class f {
        final g.b FS;
        final boolean FT;

        f(g.b bVar, boolean z) {
            this.FS = bVar;
            this.FT = z;
        }
    }

    static boolean modifiesAlpha(c cVar) {
        if (cVar.FN instanceof AlphaAnimation) {
            return true;
        }
        if (!(cVar.FN instanceof AnimationSet)) {
            return modifiesAlpha(cVar.FO);
        }
        List<Animation> animations = ((AnimationSet) cVar.FN).getAnimations();
        for (int i2 = 0; i2 < animations.size(); i2++) {
            if (animations.get(i2) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    static boolean modifiesAlpha(Animator animator) {
        PropertyValuesHolder[] values;
        if (animator == null) {
            return false;
        }
        if (animator instanceof ValueAnimator) {
            for (PropertyValuesHolder propertyValuesHolder : ((ValueAnimator) animator).getValues()) {
                if ("alpha".equals(propertyValuesHolder.getPropertyName())) {
                    return true;
                }
            }
            return false;
        } else if (!(animator instanceof AnimatorSet)) {
            return false;
        } else {
            ArrayList<Animator> childAnimations = ((AnimatorSet) animator).getChildAnimations();
            for (int i2 = 0; i2 < childAnimations.size(); i2++) {
                if (modifiesAlpha(childAnimations.get(i2))) {
                    return true;
                }
            }
            return false;
        }
    }

    static boolean shouldRunOnHWLayer(View view, c cVar) {
        if (view == null || cVar == null || Build.VERSION.SDK_INT < 19 || view.getLayerType() != 0 || !u.ar(view) || !modifiesAlpha(cVar)) {
            return false;
        }
        return true;
    }

    private void throwException(RuntimeException runtimeException) {
        runtimeException.getMessage();
        PrintWriter printWriter = new PrintWriter(new android.support.v4.e.f(TAG));
        if (this.mHost != null) {
            try {
                this.mHost.a("  ", printWriter, new String[0]);
            } catch (Exception e2) {
            }
        } else {
            try {
                dump("  ", null, printWriter, new String[0]);
            } catch (Exception e3) {
            }
        }
        throw runtimeException;
    }

    @Override // android.support.v4.app.g
    public final k beginTransaction() {
        return new b(this);
    }

    @Override // android.support.v4.app.g
    public final boolean executePendingTransactions() {
        boolean execPendingActions = execPendingActions();
        forcePostponedTransactions();
        return execPendingActions;
    }

    @Override // android.support.v4.app.g
    public final void popBackStack() {
        enqueueAction(new i(null, -1, 0), false);
    }

    @Override // android.support.v4.app.g
    public final boolean popBackStackImmediate() {
        checkStateLoss();
        return popBackStackImmediate(null, -1, 0);
    }

    @Override // android.support.v4.app.g
    public final void popBackStack(String str, int i2) {
        enqueueAction(new i(str, -1, i2), false);
    }

    @Override // android.support.v4.app.g
    public final boolean popBackStackImmediate(String str, int i2) {
        checkStateLoss();
        return popBackStackImmediate(str, -1, i2);
    }

    @Override // android.support.v4.app.g
    public final void popBackStack(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Bad id: ".concat(String.valueOf(i2)));
        }
        enqueueAction(new i(null, i2, i3), false);
    }

    @Override // android.support.v4.app.g
    public final boolean popBackStackImmediate(int i2, int i3) {
        checkStateLoss();
        execPendingActions();
        if (i2 >= 0) {
            return popBackStackImmediate(null, i2, i3);
        }
        throw new IllegalArgumentException("Bad id: ".concat(String.valueOf(i2)));
    }

    private boolean popBackStackImmediate(String str, int i2, int i3) {
        g peekChildFragmentManager;
        execPendingActions();
        ensureExecReady(true);
        if (this.mPrimaryNav != null && i2 < 0 && str == null && (peekChildFragmentManager = this.mPrimaryNav.peekChildFragmentManager()) != null && peekChildFragmentManager.popBackStackImmediate()) {
            return true;
        }
        boolean popBackStackState = popBackStackState(this.mTmpRecords, this.mTmpIsPop, str, i2, i3);
        if (popBackStackState) {
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
            } finally {
                cleanupExec();
            }
        }
        doPendingDeferredStart();
        burpActive();
        return popBackStackState;
    }

    @Override // android.support.v4.app.g
    public final int getBackStackEntryCount() {
        if (this.mBackStack != null) {
            return this.mBackStack.size();
        }
        return 0;
    }

    @Override // android.support.v4.app.g
    public final g.a getBackStackEntryAt(int i2) {
        return this.mBackStack.get(i2);
    }

    @Override // android.support.v4.app.g
    public final void addOnBackStackChangedListener(g.c cVar) {
        if (this.mBackStackChangeListeners == null) {
            this.mBackStackChangeListeners = new ArrayList<>();
        }
        this.mBackStackChangeListeners.add(cVar);
    }

    @Override // android.support.v4.app.g
    public final void removeOnBackStackChangedListener(g.c cVar) {
        if (this.mBackStackChangeListeners != null) {
            this.mBackStackChangeListeners.remove(cVar);
        }
    }

    @Override // android.support.v4.app.g
    public final void putFragment(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mIndex < 0) {
            throwException(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.mIndex);
    }

    @Override // android.support.v4.app.g
    public final Fragment getFragment(Bundle bundle, String str) {
        int i2 = bundle.getInt(str, -1);
        if (i2 == -1) {
            return null;
        }
        Fragment fragment = this.mActive.get(i2);
        if (fragment != null) {
            return fragment;
        }
        throwException(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i2));
        return fragment;
    }

    @Override // android.support.v4.app.g
    public final List<Fragment> getFragments() {
        List<Fragment> list;
        if (this.mAdded.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.mAdded) {
            list = (List) this.mAdded.clone();
        }
        return list;
    }

    /* access modifiers changed from: package-private */
    public final List<Fragment> getActiveFragments() {
        if (this.mActive == null) {
            return null;
        }
        int size = this.mActive.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(this.mActive.valueAt(i2));
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final int getActiveFragmentCount() {
        if (this.mActive == null) {
            return 0;
        }
        return this.mActive.size();
    }

    @Override // android.support.v4.app.g
    public final Fragment.SavedState saveFragmentInstanceState(Fragment fragment) {
        Bundle saveFragmentBasicState;
        if (fragment.mIndex < 0) {
            throwException(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        if (fragment.mState <= 0 || (saveFragmentBasicState = saveFragmentBasicState(fragment)) == null) {
            return null;
        }
        return new Fragment.SavedState(saveFragmentBasicState);
    }

    @Override // android.support.v4.app.g
    public final boolean isDestroyed() {
        return this.mDestroyed;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        if (this.mParent != null) {
            android.support.v4.e.e.a(this.mParent, sb);
        } else {
            android.support.v4.e.e.a(this.mHost, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    @Override // android.support.v4.app.g
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        String str2 = str + "    ";
        if (this.mActive != null && (size5 = this.mActive.size()) > 0) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (int i2 = 0; i2 < size5; i2++) {
                Fragment valueAt = this.mActive.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(valueAt);
                if (valueAt != null) {
                    valueAt.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size6 = this.mAdded.size();
        if (size6 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i3 = 0; i3 < size6; i3++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(this.mAdded.get(i3).toString());
            }
        }
        if (this.mCreatedMenus != null && (size4 = this.mCreatedMenus.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i4 = 0; i4 < size4; i4++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(this.mCreatedMenus.get(i4).toString());
            }
        }
        if (this.mBackStack != null && (size3 = this.mBackStack.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i5 = 0; i5 < size3; i5++) {
                b bVar = this.mBackStack.get(i5);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(bVar.toString());
                bVar.a(str2, printWriter);
            }
        }
        synchronized (this) {
            if (this.mBackStackIndices != null && (size2 = this.mBackStackIndices.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i6 = 0; i6 < size2; i6++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i6);
                    printWriter.print(": ");
                    printWriter.println((b) this.mBackStackIndices.get(i6));
                }
            }
            if (this.mAvailBackStackIndices != null && this.mAvailBackStackIndices.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.mAvailBackStackIndices.toArray()));
            }
        }
        if (this.mPendingActions != null && (size = this.mPendingActions.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i7 = 0; i7 < size; i7++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i7);
                printWriter.print(": ");
                printWriter.println((h) this.mPendingActions.get(i7));
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.mHost);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.mContainer);
        if (this.mParent != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.mParent);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.mCurState);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.mStateSaved);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.mDestroyed);
        if (this.mNeedMenuInvalidate) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.mNeedMenuInvalidate);
        }
        if (this.mNoTransactionsBecause != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.mNoTransactionsBecause);
        }
    }

    static c makeOpenCloseAnimation(Context context, float f2, float f3, float f4, float f5) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(DECELERATE_QUINT);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f4, f5);
        alphaAnimation.setInterpolator(DECELERATE_CUBIC);
        alphaAnimation.setDuration(220);
        animationSet.addAnimation(alphaAnimation);
        return new c(animationSet);
    }

    static c makeFadeAnimation(Context context, float f2, float f3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setInterpolator(DECELERATE_CUBIC);
        alphaAnimation.setDuration(220);
        return new c(alphaAnimation);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050 A[SYNTHETIC, Splitter:B:17:0x0050] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.support.v4.app.FragmentManagerImpl.c loadAnimation(android.support.v4.app.Fragment r10, int r11, boolean r12, int r13) {
        /*
        // Method dump skipped, instructions count: 240
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentManagerImpl.loadAnimation(android.support.v4.app.Fragment, int, boolean, int):android.support.v4.app.FragmentManagerImpl$c");
    }

    public final void performPendingDeferredStart(Fragment fragment) {
        if (!fragment.mDeferStart) {
            return;
        }
        if (this.mExecutingActions) {
            this.mHavePendingDeferredStart = true;
            return;
        }
        fragment.mDeferStart = false;
        moveToState(fragment, this.mCurState, 0, 0, false);
    }

    private static void setHWLayerAnimListenerIfAlpha(View view, c cVar) {
        if (view != null && cVar != null && shouldRunOnHWLayer(view, cVar)) {
            if (cVar.FO != null) {
                cVar.FO.addListener(new d(view));
                return;
            }
            Animation.AnimationListener animationListener = getAnimationListener(cVar.FN);
            view.setLayerType(2, null);
            cVar.FN.setAnimationListener(new a(view, animationListener));
        }
    }

    private static Animation.AnimationListener getAnimationListener(Animation animation) {
        try {
            if (sAnimationListenerField == null) {
                Field declaredField = Animation.class.getDeclaredField("mListener");
                sAnimationListenerField = declaredField;
                declaredField.setAccessible(true);
            }
            return (Animation.AnimationListener) sAnimationListenerField.get(animation);
        } catch (NoSuchFieldException e2) {
            return null;
        } catch (IllegalAccessException e3) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean isStateAtLeast(int i2) {
        return this.mCurState >= i2;
    }

    /* access modifiers changed from: package-private */
    public final void moveToState(Fragment fragment, int i2, int i3, int i4, boolean z) {
        c cVar;
        ViewGroup viewGroup;
        String str;
        FragmentManagerImpl fragmentManagerImpl;
        boolean z2 = true;
        if ((!fragment.mAdded || fragment.mDetached) && i2 > 1) {
            i2 = 1;
        }
        if (fragment.mRemoving && i2 > fragment.mState) {
            if (fragment.mState != 0 || !fragment.isInBackStack()) {
                i2 = fragment.mState;
            } else {
                i2 = 1;
            }
        }
        if (fragment.mDeferStart && fragment.mState < 3 && i2 > 2) {
            i2 = 2;
        }
        if (fragment.mState > i2) {
            if (fragment.mState > i2) {
                switch (fragment.mState) {
                    case 4:
                        if (i2 < 4) {
                            if (DEBUG) {
                                new StringBuilder("movefrom RESUMED: ").append(fragment);
                            }
                            fragment.performPause();
                            dispatchOnFragmentPaused(fragment, false);
                        }
                    case 3:
                        if (i2 < 3) {
                            if (DEBUG) {
                                new StringBuilder("movefrom STARTED: ").append(fragment);
                            }
                            fragment.performStop();
                            dispatchOnFragmentStopped(fragment, false);
                        }
                    case 2:
                        if (i2 < 2) {
                            if (DEBUG) {
                                new StringBuilder("movefrom ACTIVITY_CREATED: ").append(fragment);
                            }
                            if (fragment.mView != null && this.mHost.ek() && fragment.mSavedViewState == null) {
                                saveFragmentViewState(fragment);
                            }
                            fragment.performDestroyView();
                            dispatchOnFragmentViewDestroyed(fragment, false);
                            if (!(fragment.mView == null || fragment.mContainer == null)) {
                                fragment.mContainer.endViewTransition(fragment.mView);
                                fragment.mView.clearAnimation();
                                if (this.mCurState <= 0 || this.mDestroyed || fragment.mView.getVisibility() != 0 || fragment.mPostponedAlpha < 0.0f) {
                                    cVar = null;
                                } else {
                                    cVar = loadAnimation(fragment, i3, false, i4);
                                }
                                fragment.mPostponedAlpha = 0.0f;
                                if (cVar != null) {
                                    animateRemoveFragment(fragment, cVar, i2);
                                }
                                fragment.mContainer.removeView(fragment.mView);
                            }
                            fragment.mContainer = null;
                            fragment.mView = null;
                            fragment.mViewLifecycleOwner = null;
                            fragment.mViewLifecycleOwnerLiveData.setValue(null);
                            fragment.mInnerView = null;
                            fragment.mInLayout = false;
                        }
                        break;
                    case 1:
                        if (i2 <= 0) {
                            if (this.mDestroyed) {
                                if (fragment.getAnimatingAway() != null) {
                                    View animatingAway = fragment.getAnimatingAway();
                                    fragment.setAnimatingAway(null);
                                    animatingAway.clearAnimation();
                                } else if (fragment.getAnimator() != null) {
                                    Animator animator = fragment.getAnimator();
                                    fragment.setAnimator(null);
                                    animator.cancel();
                                }
                            }
                            if (fragment.getAnimatingAway() != null || fragment.getAnimator() != null) {
                                fragment.setStateAfterAnimating(i2);
                                i2 = 1;
                                break;
                            } else {
                                if (DEBUG) {
                                    new StringBuilder("movefrom CREATED: ").append(fragment);
                                }
                                if (!fragment.mRetaining) {
                                    fragment.performDestroy();
                                    dispatchOnFragmentDestroyed(fragment, false);
                                } else {
                                    fragment.mState = 0;
                                }
                                fragment.performDetach();
                                dispatchOnFragmentDetached(fragment, false);
                                if (!z) {
                                    if (fragment.mRetaining) {
                                        fragment.mHost = null;
                                        fragment.mParentFragment = null;
                                        fragment.mFragmentManager = null;
                                        break;
                                    } else {
                                        makeInactive(fragment);
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                }
            }
        } else if (!fragment.mFromLayout || fragment.mInLayout) {
            if (!(fragment.getAnimatingAway() == null && fragment.getAnimator() == null)) {
                fragment.setAnimatingAway(null);
                fragment.setAnimator(null);
                moveToState(fragment, fragment.getStateAfterAnimating(), 0, 0, true);
            }
            switch (fragment.mState) {
                case 0:
                    if (i2 > 0) {
                        if (DEBUG) {
                            new StringBuilder("moveto CREATED: ").append(fragment);
                        }
                        if (fragment.mSavedFragmentState != null) {
                            fragment.mSavedFragmentState.setClassLoader(this.mHost.mContext.getClassLoader());
                            fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray(VIEW_STATE_TAG);
                            fragment.mTarget = getFragment(fragment.mSavedFragmentState, TARGET_STATE_TAG);
                            if (fragment.mTarget != null) {
                                fragment.mTargetRequestCode = fragment.mSavedFragmentState.getInt(TARGET_REQUEST_CODE_STATE_TAG, 0);
                            }
                            if (fragment.mSavedUserVisibleHint != null) {
                                fragment.mUserVisibleHint = fragment.mSavedUserVisibleHint.booleanValue();
                                fragment.mSavedUserVisibleHint = null;
                            } else {
                                fragment.mUserVisibleHint = fragment.mSavedFragmentState.getBoolean(USER_VISIBLE_HINT_TAG, true);
                            }
                            if (!fragment.mUserVisibleHint) {
                                fragment.mDeferStart = true;
                                if (i2 > 2) {
                                    i2 = 2;
                                }
                            }
                        }
                        fragment.mHost = this.mHost;
                        fragment.mParentFragment = this.mParent;
                        if (this.mParent != null) {
                            fragmentManagerImpl = this.mParent.mChildFragmentManager;
                        } else {
                            fragmentManagerImpl = this.mHost.mFragmentManager;
                        }
                        fragment.mFragmentManager = fragmentManagerImpl;
                        if (fragment.mTarget != null) {
                            if (this.mActive.get(fragment.mTarget.mIndex) != fragment.mTarget) {
                                throw new IllegalStateException("Fragment " + fragment + " declared target fragment " + fragment.mTarget + " that does not belong to this FragmentManager!");
                            } else if (fragment.mTarget.mState <= 0) {
                                moveToState(fragment.mTarget, 1, 0, 0, true);
                            }
                        }
                        dispatchOnFragmentPreAttached(fragment, this.mHost.mContext, false);
                        fragment.mCalled = false;
                        fragment.onAttach(this.mHost.mContext);
                        if (!fragment.mCalled) {
                            throw new aa("Fragment " + fragment + " did not call through to super.onAttach()");
                        }
                        if (fragment.mParentFragment == null) {
                            this.mHost.onAttachFragment(fragment);
                        } else {
                            fragment.mParentFragment.onAttachFragment(fragment);
                        }
                        dispatchOnFragmentAttached(fragment, this.mHost.mContext, false);
                        if (!fragment.mIsCreated) {
                            dispatchOnFragmentPreCreated(fragment, fragment.mSavedFragmentState, false);
                            fragment.performCreate(fragment.mSavedFragmentState);
                            dispatchOnFragmentCreated(fragment, fragment.mSavedFragmentState, false);
                        } else {
                            fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
                            fragment.mState = 1;
                        }
                        fragment.mRetaining = false;
                    }
                case 1:
                    ensureInflatedFragmentView(fragment);
                    if (i2 > 1) {
                        if (DEBUG) {
                            new StringBuilder("moveto ACTIVITY_CREATED: ").append(fragment);
                        }
                        if (!fragment.mFromLayout) {
                            if (fragment.mContainerId != 0) {
                                if (fragment.mContainerId == -1) {
                                    throwException(new IllegalArgumentException("Cannot create fragment " + fragment + " for a container view with no id"));
                                }
                                viewGroup = (ViewGroup) this.mContainer.onFindViewById(fragment.mContainerId);
                                if (viewGroup == null && !fragment.mRestored) {
                                    try {
                                        str = fragment.getResources().getResourceName(fragment.mContainerId);
                                    } catch (Resources.NotFoundException e2) {
                                        str = "unknown";
                                    }
                                    throwException(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(fragment.mContainerId) + " (" + str + ") for fragment " + fragment));
                                }
                            } else {
                                viewGroup = null;
                            }
                            fragment.mContainer = viewGroup;
                            fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), viewGroup, fragment.mSavedFragmentState);
                            if (fragment.mView != null) {
                                fragment.mInnerView = fragment.mView;
                                fragment.mView.setSaveFromParentEnabled(false);
                                if (viewGroup != null) {
                                    viewGroup.addView(fragment.mView);
                                }
                                if (fragment.mHidden) {
                                    fragment.mView.setVisibility(8);
                                }
                                fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
                                dispatchOnFragmentViewCreated(fragment, fragment.mView, fragment.mSavedFragmentState, false);
                                if (fragment.mView.getVisibility() != 0 || fragment.mContainer == null) {
                                    z2 = false;
                                }
                                fragment.mIsNewlyAdded = z2;
                            } else {
                                fragment.mInnerView = null;
                            }
                        }
                        fragment.performActivityCreated(fragment.mSavedFragmentState);
                        dispatchOnFragmentActivityCreated(fragment, fragment.mSavedFragmentState, false);
                        if (fragment.mView != null) {
                            fragment.restoreViewState(fragment.mSavedFragmentState);
                        }
                        fragment.mSavedFragmentState = null;
                    }
                case 2:
                    if (i2 > 2) {
                        if (DEBUG) {
                            new StringBuilder("moveto STARTED: ").append(fragment);
                        }
                        fragment.performStart();
                        dispatchOnFragmentStarted(fragment, false);
                    }
                case 3:
                    if (i2 > 3) {
                        if (DEBUG) {
                            new StringBuilder("moveto RESUMED: ").append(fragment);
                        }
                        fragment.performResume();
                        dispatchOnFragmentResumed(fragment, false);
                        fragment.mSavedFragmentState = null;
                        fragment.mSavedViewState = null;
                        break;
                    }
                    break;
            }
        } else {
            return;
        }
        if (fragment.mState != i2) {
            new StringBuilder("moveToState: Fragment state for ").append(fragment).append(" not updated inline; expected state ").append(i2).append(" found ").append(fragment.mState);
            fragment.mState = i2;
        }
    }

    private void animateRemoveFragment(final Fragment fragment, c cVar, int i2) {
        final View view = fragment.mView;
        final ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        fragment.setStateAfterAnimating(i2);
        if (cVar.FN != null) {
            e eVar = new e(cVar.FN, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            eVar.setAnimationListener(new b(getAnimationListener(eVar)) {
                /* class android.support.v4.app.FragmentManagerImpl.AnonymousClass2 */

                @Override // android.support.v4.app.FragmentManagerImpl.b
                public final void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    viewGroup.post(new Runnable() {
                        /* class android.support.v4.app.FragmentManagerImpl.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            if (fragment.getAnimatingAway() != null) {
                                fragment.setAnimatingAway(null);
                                FragmentManagerImpl.this.moveToState(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
                            }
                        }
                    });
                }
            });
            setHWLayerAnimListenerIfAlpha(view, cVar);
            fragment.mView.startAnimation(eVar);
            return;
        }
        Animator animator = cVar.FO;
        fragment.setAnimator(cVar.FO);
        animator.addListener(new AnimatorListenerAdapter() {
            /* class android.support.v4.app.FragmentManagerImpl.AnonymousClass3 */

            public final void onAnimationEnd(Animator animator) {
                viewGroup.endViewTransition(view);
                Animator animator2 = fragment.getAnimator();
                fragment.setAnimator(null);
                if (animator2 != null && viewGroup.indexOfChild(view) < 0) {
                    FragmentManagerImpl.this.moveToState(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
                }
            }
        });
        animator.setTarget(fragment.mView);
        setHWLayerAnimListenerIfAlpha(fragment.mView, cVar);
        animator.start();
    }

    /* access modifiers changed from: package-private */
    public final void moveToState(Fragment fragment) {
        moveToState(fragment, this.mCurState, 0, 0, false);
    }

    /* access modifiers changed from: package-private */
    public final void ensureInflatedFragmentView(Fragment fragment) {
        if (fragment.mFromLayout && !fragment.mPerformedCreateView) {
            fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), null, fragment.mSavedFragmentState);
            if (fragment.mView != null) {
                fragment.mInnerView = fragment.mView;
                fragment.mView.setSaveFromParentEnabled(false);
                if (fragment.mHidden) {
                    fragment.mView.setVisibility(8);
                }
                fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
                dispatchOnFragmentViewCreated(fragment, fragment.mView, fragment.mSavedFragmentState, false);
                return;
            }
            fragment.mInnerView = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void completeShowHideFragment(final Fragment fragment) {
        if (fragment.mView != null) {
            c loadAnimation = loadAnimation(fragment, fragment.getNextTransition(), !fragment.mHidden, fragment.getNextTransitionStyle());
            if (loadAnimation == null || loadAnimation.FO == null) {
                if (loadAnimation != null) {
                    setHWLayerAnimListenerIfAlpha(fragment.mView, loadAnimation);
                    fragment.mView.startAnimation(loadAnimation.FN);
                    loadAnimation.FN.start();
                }
                fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            } else {
                loadAnimation.FO.setTarget(fragment.mView);
                if (!fragment.mHidden) {
                    fragment.mView.setVisibility(0);
                } else if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                } else {
                    final ViewGroup viewGroup = fragment.mContainer;
                    final View view = fragment.mView;
                    viewGroup.startViewTransition(view);
                    loadAnimation.FO.addListener(new AnimatorListenerAdapter() {
                        /* class android.support.v4.app.FragmentManagerImpl.AnonymousClass4 */

                        public final void onAnimationEnd(Animator animator) {
                            viewGroup.endViewTransition(view);
                            animator.removeListener(this);
                            if (fragment.mView != null) {
                                fragment.mView.setVisibility(8);
                            }
                        }
                    });
                }
                setHWLayerAnimListenerIfAlpha(fragment.mView, loadAnimation);
                loadAnimation.FO.start();
            }
        }
        if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
            this.mNeedMenuInvalidate = true;
        }
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    /* access modifiers changed from: package-private */
    public final void moveFragmentToExpectedState(Fragment fragment) {
        ViewGroup viewGroup;
        int indexOfChild;
        int indexOfChild2;
        if (fragment != null) {
            int i2 = this.mCurState;
            if (fragment.mRemoving) {
                if (fragment.isInBackStack()) {
                    i2 = Math.min(i2, 1);
                } else {
                    i2 = Math.min(i2, 0);
                }
            }
            moveToState(fragment, i2, fragment.getNextTransition(), fragment.getNextTransitionStyle(), false);
            if (fragment.mView != null) {
                Fragment findFragmentUnder = findFragmentUnder(fragment);
                if (findFragmentUnder != null && (indexOfChild2 = viewGroup.indexOfChild(fragment.mView)) < (indexOfChild = (viewGroup = fragment.mContainer).indexOfChild(findFragmentUnder.mView))) {
                    viewGroup.removeViewAt(indexOfChild2);
                    viewGroup.addView(fragment.mView, indexOfChild);
                }
                if (fragment.mIsNewlyAdded && fragment.mContainer != null) {
                    if (fragment.mPostponedAlpha > 0.0f) {
                        fragment.mView.setAlpha(fragment.mPostponedAlpha);
                    }
                    fragment.mPostponedAlpha = 0.0f;
                    fragment.mIsNewlyAdded = false;
                    c loadAnimation = loadAnimation(fragment, fragment.getNextTransition(), true, fragment.getNextTransitionStyle());
                    if (loadAnimation != null) {
                        setHWLayerAnimListenerIfAlpha(fragment.mView, loadAnimation);
                        if (loadAnimation.FN != null) {
                            fragment.mView.startAnimation(loadAnimation.FN);
                        } else {
                            loadAnimation.FO.setTarget(fragment.mView);
                            loadAnimation.FO.start();
                        }
                    }
                }
            }
            if (fragment.mHiddenChanged) {
                completeShowHideFragment(fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void moveToState(int i2, boolean z) {
        if (this.mHost == null && i2 != 0) {
            throw new IllegalStateException("No activity");
        } else if (z || i2 != this.mCurState) {
            this.mCurState = i2;
            if (this.mActive != null) {
                int size = this.mAdded.size();
                for (int i3 = 0; i3 < size; i3++) {
                    moveFragmentToExpectedState(this.mAdded.get(i3));
                }
                int size2 = this.mActive.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    Fragment valueAt = this.mActive.valueAt(i4);
                    if (valueAt != null && ((valueAt.mRemoving || valueAt.mDetached) && !valueAt.mIsNewlyAdded)) {
                        moveFragmentToExpectedState(valueAt);
                    }
                }
                startPendingDeferredFragments();
                if (this.mNeedMenuInvalidate && this.mHost != null && this.mCurState == 4) {
                    this.mHost.el();
                    this.mNeedMenuInvalidate = false;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void startPendingDeferredFragments() {
        if (this.mActive != null) {
            for (int i2 = 0; i2 < this.mActive.size(); i2++) {
                Fragment valueAt = this.mActive.valueAt(i2);
                if (valueAt != null) {
                    performPendingDeferredStart(valueAt);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void makeActive(Fragment fragment) {
        if (fragment.mIndex < 0) {
            int i2 = this.mNextFragmentIndex;
            this.mNextFragmentIndex = i2 + 1;
            fragment.setIndex(i2, this.mParent);
            if (this.mActive == null) {
                this.mActive = new SparseArray<>();
            }
            this.mActive.put(fragment.mIndex, fragment);
            if (DEBUG) {
                new StringBuilder("Allocated fragment index ").append(fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void makeInactive(Fragment fragment) {
        if (fragment.mIndex >= 0) {
            if (DEBUG) {
                new StringBuilder("Freeing fragment index ").append(fragment);
            }
            this.mActive.put(fragment.mIndex, null);
            fragment.initState();
        }
    }

    public final void addFragment(Fragment fragment, boolean z) {
        if (DEBUG) {
            new StringBuilder("add: ").append(fragment);
        }
        makeActive(fragment);
        if (fragment.mDetached) {
            return;
        }
        if (this.mAdded.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: ".concat(String.valueOf(fragment)));
        }
        synchronized (this.mAdded) {
            this.mAdded.add(fragment);
        }
        fragment.mAdded = true;
        fragment.mRemoving = false;
        if (fragment.mView == null) {
            fragment.mHiddenChanged = false;
        }
        if (fragment.mHasMenu && fragment.mMenuVisible) {
            this.mNeedMenuInvalidate = true;
        }
        if (z) {
            moveToState(fragment);
        }
    }

    public final void removeFragment(Fragment fragment) {
        if (DEBUG) {
            new StringBuilder("remove: ").append(fragment).append(" nesting=").append(fragment.mBackStackNesting);
        }
        boolean z = !fragment.isInBackStack();
        if (!fragment.mDetached || z) {
            synchronized (this.mAdded) {
                this.mAdded.remove(fragment);
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.mNeedMenuInvalidate = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
        }
    }

    public final void hideFragment(Fragment fragment) {
        boolean z = true;
        if (DEBUG) {
            new StringBuilder("hide: ").append(fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            if (fragment.mHiddenChanged) {
                z = false;
            }
            fragment.mHiddenChanged = z;
        }
    }

    public final void showFragment(Fragment fragment) {
        boolean z = false;
        if (DEBUG) {
            new StringBuilder("show: ").append(fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            if (!fragment.mHiddenChanged) {
                z = true;
            }
            fragment.mHiddenChanged = z;
        }
    }

    public final void detachFragment(Fragment fragment) {
        if (DEBUG) {
            new StringBuilder("detach: ").append(fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (DEBUG) {
                    new StringBuilder("remove from detach: ").append(fragment);
                }
                synchronized (this.mAdded) {
                    this.mAdded.remove(fragment);
                }
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.mNeedMenuInvalidate = true;
                }
                fragment.mAdded = false;
            }
        }
    }

    public final void attachFragment(Fragment fragment) {
        if (DEBUG) {
            new StringBuilder("attach: ").append(fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            if (this.mAdded.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: ".concat(String.valueOf(fragment)));
            }
            if (DEBUG) {
                new StringBuilder("add from attach: ").append(fragment);
            }
            synchronized (this.mAdded) {
                this.mAdded.add(fragment);
            }
            fragment.mAdded = true;
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.mNeedMenuInvalidate = true;
            }
        }
    }

    @Override // android.support.v4.app.g
    public final Fragment findFragmentById(int i2) {
        for (int size = this.mAdded.size() - 1; size >= 0; size--) {
            Fragment fragment = this.mAdded.get(size);
            if (fragment != null && fragment.mFragmentId == i2) {
                return fragment;
            }
        }
        if (this.mActive != null) {
            for (int size2 = this.mActive.size() - 1; size2 >= 0; size2--) {
                Fragment valueAt = this.mActive.valueAt(size2);
                if (valueAt != null && valueAt.mFragmentId == i2) {
                    return valueAt;
                }
            }
        }
        return null;
    }

    @Override // android.support.v4.app.g
    public final Fragment findFragmentByTag(String str) {
        if (str != null) {
            for (int size = this.mAdded.size() - 1; size >= 0; size--) {
                Fragment fragment = this.mAdded.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (!(this.mActive == null || str == null)) {
            for (int size2 = this.mActive.size() - 1; size2 >= 0; size2--) {
                Fragment valueAt = this.mActive.valueAt(size2);
                if (valueAt != null && str.equals(valueAt.mTag)) {
                    return valueAt;
                }
            }
        }
        return null;
    }

    public final Fragment findFragmentByWho(String str) {
        Fragment findFragmentByWho;
        if (!(this.mActive == null || str == null)) {
            for (int size = this.mActive.size() - 1; size >= 0; size--) {
                Fragment valueAt = this.mActive.valueAt(size);
                if (!(valueAt == null || (findFragmentByWho = valueAt.findFragmentByWho(str)) == null)) {
                    return findFragmentByWho;
                }
            }
        }
        return null;
    }

    private void checkStateLoss() {
        if (isStateSaved()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.mNoTransactionsBecause != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.mNoTransactionsBecause);
        }
    }

    @Override // android.support.v4.app.g
    public final boolean isStateSaved() {
        return this.mStateSaved || this.mStopped;
    }

    public final void enqueueAction(h hVar, boolean z) {
        if (!z) {
            checkStateLoss();
        }
        synchronized (this) {
            if (!this.mDestroyed && this.mHost != null) {
                if (this.mPendingActions == null) {
                    this.mPendingActions = new ArrayList<>();
                }
                this.mPendingActions.add(hVar);
                scheduleCommit();
            } else if (!z) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void scheduleCommit() {
        boolean z = true;
        synchronized (this) {
            boolean z2 = this.mPostponedTransactions != null && !this.mPostponedTransactions.isEmpty();
            if (this.mPendingActions == null || this.mPendingActions.size() != 1) {
                z = false;
            }
            if (z2 || z) {
                this.mHost.mHandler.removeCallbacks(this.mExecCommit);
                this.mHost.mHandler.post(this.mExecCommit);
            }
        }
    }

    public final int allocBackStackIndex(b bVar) {
        int i2;
        synchronized (this) {
            if (this.mAvailBackStackIndices == null || this.mAvailBackStackIndices.size() <= 0) {
                if (this.mBackStackIndices == null) {
                    this.mBackStackIndices = new ArrayList<>();
                }
                i2 = this.mBackStackIndices.size();
                if (DEBUG) {
                    new StringBuilder("Setting back stack index ").append(i2).append(" to ").append(bVar);
                }
                this.mBackStackIndices.add(bVar);
            } else {
                i2 = this.mAvailBackStackIndices.remove(this.mAvailBackStackIndices.size() - 1).intValue();
                if (DEBUG) {
                    new StringBuilder("Adding back stack index ").append(i2).append(" with ").append(bVar);
                }
                this.mBackStackIndices.set(i2, bVar);
            }
        }
        return i2;
    }

    public final void setBackStackIndex(int i2, b bVar) {
        synchronized (this) {
            if (this.mBackStackIndices == null) {
                this.mBackStackIndices = new ArrayList<>();
            }
            int size = this.mBackStackIndices.size();
            if (i2 < size) {
                if (DEBUG) {
                    new StringBuilder("Setting back stack index ").append(i2).append(" to ").append(bVar);
                }
                this.mBackStackIndices.set(i2, bVar);
            } else {
                while (size < i2) {
                    this.mBackStackIndices.add(null);
                    if (this.mAvailBackStackIndices == null) {
                        this.mAvailBackStackIndices = new ArrayList<>();
                    }
                    this.mAvailBackStackIndices.add(Integer.valueOf(size));
                    size++;
                }
                if (DEBUG) {
                    new StringBuilder("Adding back stack index ").append(i2).append(" with ").append(bVar);
                }
                this.mBackStackIndices.add(bVar);
            }
        }
    }

    public final void freeBackStackIndex(int i2) {
        synchronized (this) {
            this.mBackStackIndices.set(i2, null);
            if (this.mAvailBackStackIndices == null) {
                this.mAvailBackStackIndices = new ArrayList<>();
            }
            this.mAvailBackStackIndices.add(Integer.valueOf(i2));
        }
    }

    private void ensureExecReady(boolean z) {
        if (this.mExecutingActions) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.mHost == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        } else if (Looper.myLooper() != this.mHost.mHandler.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else {
            if (!z) {
                checkStateLoss();
            }
            if (this.mTmpRecords == null) {
                this.mTmpRecords = new ArrayList<>();
                this.mTmpIsPop = new ArrayList<>();
            }
            this.mExecutingActions = true;
            try {
                executePostponedTransaction(null, null);
            } finally {
                this.mExecutingActions = false;
            }
        }
    }

    public final void execSingleAction(h hVar, boolean z) {
        if (!z || (this.mHost != null && !this.mDestroyed)) {
            ensureExecReady(z);
            if (hVar.a(this.mTmpRecords, this.mTmpIsPop)) {
                this.mExecutingActions = true;
                try {
                    removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                } finally {
                    cleanupExec();
                }
            }
            doPendingDeferredStart();
            burpActive();
        }
    }

    private void cleanupExec() {
        this.mExecutingActions = false;
        this.mTmpIsPop.clear();
        this.mTmpRecords.clear();
    }

    /* JADX INFO: finally extract failed */
    public final boolean execPendingActions() {
        ensureExecReady(true);
        boolean z = false;
        while (generateOpsForPendingActions(this.mTmpRecords, this.mTmpIsPop)) {
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                cleanupExec();
                z = true;
            } catch (Throwable th) {
                cleanupExec();
                throw th;
            }
        }
        doPendingDeferredStart();
        burpActive();
        return z;
    }

    private void executePostponedTransaction(ArrayList<b> arrayList, ArrayList<Boolean> arrayList2) {
        int size;
        boolean z;
        int indexOf;
        int indexOf2;
        if (this.mPostponedTransactions == null) {
            size = 0;
        } else {
            size = this.mPostponedTransactions.size();
        }
        int i2 = 0;
        int i3 = size;
        while (i2 < i3) {
            j jVar = this.mPostponedTransactions.get(i2);
            if (arrayList == null || jVar.FW || (indexOf2 = arrayList.indexOf(jVar.FX)) == -1 || !arrayList2.get(indexOf2).booleanValue()) {
                if (jVar.FY == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z || (arrayList != null && jVar.FX.a(arrayList, 0, arrayList.size()))) {
                    this.mPostponedTransactions.remove(i2);
                    i2--;
                    i3--;
                    if (arrayList == null || jVar.FW || (indexOf = arrayList.indexOf(jVar.FX)) == -1 || !arrayList2.get(indexOf).booleanValue()) {
                        jVar.em();
                    } else {
                        jVar.en();
                    }
                }
            } else {
                jVar.en();
            }
            i2++;
            i3 = i3;
        }
    }

    private void removeRedundantOperationsAndExecute(ArrayList<b> arrayList, ArrayList<Boolean> arrayList2) {
        int i2;
        int i3;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
                throw new IllegalStateException("Internal error with the back stack records");
            }
            executePostponedTransaction(arrayList, arrayList2);
            int size = arrayList.size();
            int i4 = 0;
            int i5 = 0;
            while (i4 < size) {
                if (!arrayList.get(i4).EV) {
                    if (i5 != i4) {
                        executeOpsTogether(arrayList, arrayList2, i5, i4);
                    }
                    int i6 = i4 + 1;
                    if (arrayList2.get(i4).booleanValue()) {
                        while (i6 < size && arrayList2.get(i6).booleanValue() && !arrayList.get(i6).EV) {
                            i6++;
                        }
                    }
                    i3 = i6;
                    executeOpsTogether(arrayList, arrayList2, i4, i3);
                    i2 = i3 - 1;
                } else {
                    i2 = i4;
                    i3 = i5;
                }
                i4 = i2 + 1;
                i5 = i3;
            }
            if (i5 != size) {
                executeOpsTogether(arrayList, arrayList2, i5, size);
            }
        }
    }

    private void executeOpsTogether(ArrayList<b> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        int i4;
        Fragment b2;
        boolean z;
        boolean z2 = arrayList.get(i2).EV;
        if (this.mTmpAddedFragments == null) {
            this.mTmpAddedFragments = new ArrayList<>();
        } else {
            this.mTmpAddedFragments.clear();
        }
        this.mTmpAddedFragments.addAll(this.mAdded);
        int i5 = i2;
        Fragment primaryNavigationFragment = getPrimaryNavigationFragment();
        boolean z3 = false;
        while (i5 < i3) {
            b bVar = arrayList.get(i5);
            if (!arrayList2.get(i5).booleanValue()) {
                b2 = bVar.a(this.mTmpAddedFragments, primaryNavigationFragment);
            } else {
                b2 = bVar.b(this.mTmpAddedFragments, primaryNavigationFragment);
            }
            if (z3 || bVar.EM) {
                z = true;
            } else {
                z = false;
            }
            i5++;
            primaryNavigationFragment = b2;
            z3 = z;
        }
        this.mTmpAddedFragments.clear();
        if (!z2) {
            l.a(this, arrayList, arrayList2, i2, i3, false);
        }
        executeOps(arrayList, arrayList2, i2, i3);
        if (z2) {
            android.support.v4.e.b<Fragment> bVar2 = new android.support.v4.e.b<>();
            addAddedFragments(bVar2);
            i4 = postponePostponableTransactions(arrayList, arrayList2, i2, i3, bVar2);
            makeRemovedFragmentsInvisible(bVar2);
        } else {
            i4 = i3;
        }
        if (i4 != i2 && z2) {
            l.a(this, arrayList, arrayList2, i2, i4, true);
            moveToState(this.mCurState, true);
        }
        while (i2 < i3) {
            b bVar3 = arrayList.get(i2);
            if (arrayList2.get(i2).booleanValue() && bVar3.mIndex >= 0) {
                freeBackStackIndex(bVar3.mIndex);
                bVar3.mIndex = -1;
            }
            bVar3.ea();
            i2++;
        }
        if (z3) {
            reportBackStackChanged();
        }
    }

    private void makeRemovedFragmentsInvisible(android.support.v4.e.b<Fragment> bVar) {
        int size = bVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = (Fragment) bVar.OO[i2];
            if (!fragment.mAdded) {
                View view = fragment.getView();
                fragment.mPostponedAlpha = view.getAlpha();
                view.setAlpha(0.0f);
            }
        }
    }

    private int postponePostponableTransactions(ArrayList<b> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, android.support.v4.e.b<Fragment> bVar) {
        boolean z;
        int i4;
        int i5 = i3 - 1;
        int i6 = i3;
        while (i5 >= i2) {
            b bVar2 = arrayList.get(i5);
            boolean booleanValue = arrayList2.get(i5).booleanValue();
            int i7 = 0;
            while (true) {
                if (i7 >= bVar2.EF.size()) {
                    z = false;
                    break;
                } else if (b.b(bVar2.EF.get(i7))) {
                    z = true;
                    break;
                } else {
                    i7++;
                }
            }
            if (z && !bVar2.a(arrayList, i5 + 1, i3)) {
                if (this.mPostponedTransactions == null) {
                    this.mPostponedTransactions = new ArrayList<>();
                }
                j jVar = new j(bVar2, booleanValue);
                this.mPostponedTransactions.add(jVar);
                bVar2.a(jVar);
                if (booleanValue) {
                    bVar2.eb();
                } else {
                    bVar2.D(false);
                }
                int i8 = i6 - 1;
                if (i5 != i8) {
                    arrayList.remove(i5);
                    arrayList.add(i8, bVar2);
                }
                addAddedFragments(bVar);
                i4 = i8;
            } else {
                i4 = i6;
            }
            i5--;
            i6 = i4;
        }
        return i6;
    }

    /* access modifiers changed from: package-private */
    public final void completeExecute(b bVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            bVar.D(z3);
        } else {
            bVar.eb();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(bVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            l.a(this, (ArrayList<b>) arrayList, (ArrayList<Boolean>) arrayList2, 0, 1, true);
        }
        if (z3) {
            moveToState(this.mCurState, true);
        }
        if (this.mActive != null) {
            int size = this.mActive.size();
            for (int i2 = 0; i2 < size; i2++) {
                Fragment valueAt = this.mActive.valueAt(i2);
                if (valueAt != null && valueAt.mView != null && valueAt.mIsNewlyAdded && bVar.ar(valueAt.mContainerId)) {
                    if (valueAt.mPostponedAlpha > 0.0f) {
                        valueAt.mView.setAlpha(valueAt.mPostponedAlpha);
                    }
                    if (z3) {
                        valueAt.mPostponedAlpha = 0.0f;
                    } else {
                        valueAt.mPostponedAlpha = -1.0f;
                        valueAt.mIsNewlyAdded = false;
                    }
                }
            }
        }
    }

    private Fragment findFragmentUnder(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        View view = fragment.mView;
        if (viewGroup == null || view == null) {
            return null;
        }
        for (int indexOf = this.mAdded.indexOf(fragment) - 1; indexOf >= 0; indexOf--) {
            Fragment fragment2 = this.mAdded.get(indexOf);
            if (fragment2.mContainer == viewGroup && fragment2.mView != null) {
                return fragment2;
            }
        }
        return null;
    }

    private static void executeOps(ArrayList<b> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        while (i2 < i3) {
            b bVar = arrayList.get(i2);
            if (arrayList2.get(i2).booleanValue()) {
                bVar.aq(-1);
                bVar.D(i2 == i3 + -1);
            } else {
                bVar.aq(1);
                bVar.eb();
            }
            i2++;
        }
    }

    private void addAddedFragments(android.support.v4.e.b<Fragment> bVar) {
        if (this.mCurState > 0) {
            int min = Math.min(this.mCurState, 3);
            int size = this.mAdded.size();
            for (int i2 = 0; i2 < size; i2++) {
                Fragment fragment = this.mAdded.get(i2);
                if (fragment.mState < min) {
                    moveToState(fragment, min, fragment.getNextAnim(), fragment.getNextTransition(), false);
                    if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                        bVar.add(fragment);
                    }
                }
            }
        }
    }

    private void forcePostponedTransactions() {
        if (this.mPostponedTransactions != null) {
            while (!this.mPostponedTransactions.isEmpty()) {
                this.mPostponedTransactions.remove(0).em();
            }
        }
    }

    private void endAnimatingAwayFragments() {
        int size = this.mActive == null ? 0 : this.mActive.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment valueAt = this.mActive.valueAt(i2);
            if (valueAt != null) {
                if (valueAt.getAnimatingAway() != null) {
                    int stateAfterAnimating = valueAt.getStateAfterAnimating();
                    View animatingAway = valueAt.getAnimatingAway();
                    Animation animation = animatingAway.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        animatingAway.clearAnimation();
                    }
                    valueAt.setAnimatingAway(null);
                    moveToState(valueAt, stateAfterAnimating, 0, 0, false);
                } else if (valueAt.getAnimator() != null) {
                    valueAt.getAnimator().end();
                }
            }
        }
    }

    private boolean generateOpsForPendingActions(ArrayList<b> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this) {
            if (this.mPendingActions == null || this.mPendingActions.size() == 0) {
                return false;
            }
            int size = this.mPendingActions.size();
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                z |= this.mPendingActions.get(i2).a(arrayList, arrayList2);
            }
            this.mPendingActions.clear();
            this.mHost.mHandler.removeCallbacks(this.mExecCommit);
            return z;
        }
    }

    /* access modifiers changed from: package-private */
    public final void doPendingDeferredStart() {
        if (this.mHavePendingDeferredStart) {
            this.mHavePendingDeferredStart = false;
            startPendingDeferredFragments();
        }
    }

    /* access modifiers changed from: package-private */
    public final void reportBackStackChanged() {
        if (this.mBackStackChangeListeners != null) {
            for (int i2 = 0; i2 < this.mBackStackChangeListeners.size(); i2++) {
                this.mBackStackChangeListeners.get(i2).onBackStackChanged();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void addBackStackState(b bVar) {
        if (this.mBackStack == null) {
            this.mBackStack = new ArrayList<>();
        }
        this.mBackStack.add(bVar);
    }

    /* access modifiers changed from: package-private */
    public final boolean popBackStackState(ArrayList<b> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        if (this.mBackStack == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = this.mBackStack.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.mBackStack.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            int i4 = -1;
            if (str != null || i2 >= 0) {
                int size2 = this.mBackStack.size() - 1;
                while (size2 >= 0) {
                    b bVar = this.mBackStack.get(size2);
                    if ((str != null && str.equals(bVar.mName)) || (i2 >= 0 && i2 == bVar.mIndex)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    size2--;
                    while (size2 >= 0) {
                        b bVar2 = this.mBackStack.get(size2);
                        if ((str == null || !str.equals(bVar2.mName)) && (i2 < 0 || i2 != bVar2.mIndex)) {
                            break;
                        }
                        size2--;
                    }
                }
                i4 = size2;
            }
            if (i4 == this.mBackStack.size() - 1) {
                return false;
            }
            for (int size3 = this.mBackStack.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.mBackStack.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final h retainNonConfig() {
        setRetaining(this.mSavedNonConfig);
        return this.mSavedNonConfig;
    }

    private static void setRetaining(h hVar) {
        if (hVar != null) {
            List<Fragment> list = hVar.FZ;
            if (list != null) {
                for (Fragment fragment : list) {
                    fragment.mRetaining = true;
                }
            }
            List<h> list2 = hVar.Ga;
            if (list2 != null) {
                for (h hVar2 : list2) {
                    setRetaining(hVar2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void saveNonConfig() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        h hVar;
        if (this.mActive != null) {
            int i2 = 0;
            arrayList3 = null;
            arrayList2 = null;
            arrayList = null;
            while (i2 < this.mActive.size()) {
                Fragment valueAt = this.mActive.valueAt(i2);
                if (valueAt != null) {
                    if (valueAt.mRetainInstance) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(valueAt);
                        valueAt.mTargetIndex = valueAt.mTarget != null ? valueAt.mTarget.mIndex : -1;
                        if (DEBUG) {
                            new StringBuilder("retainNonConfig: keeping retained ").append(valueAt);
                        }
                    }
                    if (valueAt.mChildFragmentManager != null) {
                        valueAt.mChildFragmentManager.saveNonConfig();
                        hVar = valueAt.mChildFragmentManager.mSavedNonConfig;
                    } else {
                        hVar = valueAt.mChildNonConfig;
                    }
                    if (arrayList2 == null && hVar != null) {
                        arrayList2 = new ArrayList(this.mActive.size());
                        for (int i3 = 0; i3 < i2; i3++) {
                            arrayList2.add(null);
                        }
                    }
                    if (arrayList2 != null) {
                        arrayList2.add(hVar);
                    }
                    if (arrayList3 == null && valueAt.mViewModelStore != null) {
                        arrayList3 = new ArrayList(this.mActive.size());
                        for (int i4 = 0; i4 < i2; i4++) {
                            arrayList3.add(null);
                        }
                    }
                    if (arrayList3 != null) {
                        arrayList3.add(valueAt.mViewModelStore);
                    }
                }
                i2++;
                arrayList3 = arrayList3;
            }
        } else {
            arrayList3 = null;
            arrayList2 = null;
            arrayList = null;
        }
        if (arrayList == null && arrayList2 == null && arrayList3 == null) {
            this.mSavedNonConfig = null;
        } else {
            this.mSavedNonConfig = new h(arrayList, arrayList2, arrayList3);
        }
    }

    /* access modifiers changed from: package-private */
    public final void saveFragmentViewState(Fragment fragment) {
        if (fragment.mInnerView != null) {
            if (this.mStateArray == null) {
                this.mStateArray = new SparseArray<>();
            } else {
                this.mStateArray.clear();
            }
            fragment.mInnerView.saveHierarchyState(this.mStateArray);
            if (this.mStateArray.size() > 0) {
                fragment.mSavedViewState = this.mStateArray;
                this.mStateArray = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Bundle saveFragmentBasicState(Fragment fragment) {
        Bundle bundle;
        if (this.mStateBundle == null) {
            this.mStateBundle = new Bundle();
        }
        fragment.performSaveInstanceState(this.mStateBundle);
        dispatchOnFragmentSaveInstanceState(fragment, this.mStateBundle, false);
        if (!this.mStateBundle.isEmpty()) {
            bundle = this.mStateBundle;
            this.mStateBundle = null;
        } else {
            bundle = null;
        }
        if (fragment.mView != null) {
            saveFragmentViewState(fragment);
        }
        if (fragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray(VIEW_STATE_TAG, fragment.mSavedViewState);
        }
        if (!fragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean(USER_VISIBLE_HINT_TAG, fragment.mUserVisibleHint);
        }
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public final Parcelable saveAllState() {
        int[] iArr;
        int size;
        boolean z;
        BackStackState[] backStackStateArr = null;
        forcePostponedTransactions();
        endAnimatingAwayFragments();
        execPendingActions();
        this.mStateSaved = true;
        this.mSavedNonConfig = null;
        if (this.mActive == null || this.mActive.size() <= 0) {
            return null;
        }
        int size2 = this.mActive.size();
        FragmentState[] fragmentStateArr = new FragmentState[size2];
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size2) {
            Fragment valueAt = this.mActive.valueAt(i2);
            if (valueAt != null) {
                if (valueAt.mIndex < 0) {
                    throwException(new IllegalStateException("Failure saving state: active " + valueAt + " has cleared index: " + valueAt.mIndex));
                }
                FragmentState fragmentState = new FragmentState(valueAt);
                fragmentStateArr[i2] = fragmentState;
                if (valueAt.mState <= 0 || fragmentState.mSavedFragmentState != null) {
                    fragmentState.mSavedFragmentState = valueAt.mSavedFragmentState;
                } else {
                    fragmentState.mSavedFragmentState = saveFragmentBasicState(valueAt);
                    if (valueAt.mTarget != null) {
                        if (valueAt.mTarget.mIndex < 0) {
                            throwException(new IllegalStateException("Failure saving state: " + valueAt + " has target not in fragment manager: " + valueAt.mTarget));
                        }
                        if (fragmentState.mSavedFragmentState == null) {
                            fragmentState.mSavedFragmentState = new Bundle();
                        }
                        putFragment(fragmentState.mSavedFragmentState, TARGET_STATE_TAG, valueAt.mTarget);
                        if (valueAt.mTargetRequestCode != 0) {
                            fragmentState.mSavedFragmentState.putInt(TARGET_REQUEST_CODE_STATE_TAG, valueAt.mTargetRequestCode);
                        }
                    }
                }
                if (DEBUG) {
                    new StringBuilder("Saved state of ").append(valueAt).append(": ").append(fragmentState.mSavedFragmentState);
                }
                z = true;
            } else {
                z = z2;
            }
            i2++;
            z2 = z;
        }
        if (!z2) {
            return null;
        }
        int size3 = this.mAdded.size();
        if (size3 > 0) {
            iArr = new int[size3];
            for (int i3 = 0; i3 < size3; i3++) {
                iArr[i3] = this.mAdded.get(i3).mIndex;
                if (iArr[i3] < 0) {
                    throwException(new IllegalStateException("Failure saving state: active " + this.mAdded.get(i3) + " has cleared index: " + iArr[i3]));
                }
                if (DEBUG) {
                    new StringBuilder("saveAllState: adding fragment #").append(i3).append(": ").append(this.mAdded.get(i3));
                }
            }
        } else {
            iArr = null;
        }
        if (this.mBackStack != null && (size = this.mBackStack.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i4 = 0; i4 < size; i4++) {
                backStackStateArr[i4] = new BackStackState(this.mBackStack.get(i4));
                if (DEBUG) {
                    new StringBuilder("saveAllState: adding back stack #").append(i4).append(": ").append(this.mBackStack.get(i4));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.Gc = fragmentStateArr;
        fragmentManagerState.Gd = iArr;
        fragmentManagerState.Ge = backStackStateArr;
        if (this.mPrimaryNav != null) {
            fragmentManagerState.Gf = this.mPrimaryNav.mIndex;
        }
        fragmentManagerState.mNextFragmentIndex = this.mNextFragmentIndex;
        saveNonConfig();
        return fragmentManagerState;
    }

    /* access modifiers changed from: package-private */
    public final void restoreAllState(Parcelable parcelable, h hVar) {
        List<ViewModelStore> list;
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.Gc != null) {
                List<h> list2 = null;
                if (hVar != null) {
                    List<Fragment> list3 = hVar.FZ;
                    List<h> list4 = hVar.Ga;
                    List<ViewModelStore> list5 = hVar.Gb;
                    int size = list3 != null ? list3.size() : 0;
                    for (int i2 = 0; i2 < size; i2++) {
                        Fragment fragment = list3.get(i2);
                        if (DEBUG) {
                            new StringBuilder("restoreAllState: re-attaching retained ").append(fragment);
                        }
                        int i3 = 0;
                        while (i3 < fragmentManagerState.Gc.length && fragmentManagerState.Gc[i3].mIndex != fragment.mIndex) {
                            i3++;
                        }
                        if (i3 == fragmentManagerState.Gc.length) {
                            throwException(new IllegalStateException("Could not find active fragment with index " + fragment.mIndex));
                        }
                        FragmentState fragmentState = fragmentManagerState.Gc[i3];
                        fragmentState.Gg = fragment;
                        fragment.mSavedViewState = null;
                        fragment.mBackStackNesting = 0;
                        fragment.mInLayout = false;
                        fragment.mAdded = false;
                        fragment.mTarget = null;
                        if (fragmentState.mSavedFragmentState != null) {
                            fragmentState.mSavedFragmentState.setClassLoader(this.mHost.mContext.getClassLoader());
                            fragment.mSavedViewState = fragmentState.mSavedFragmentState.getSparseParcelableArray(VIEW_STATE_TAG);
                            fragment.mSavedFragmentState = fragmentState.mSavedFragmentState;
                        }
                    }
                    list = list5;
                    list2 = list4;
                } else {
                    list = null;
                }
                this.mActive = new SparseArray<>(fragmentManagerState.Gc.length);
                for (int i4 = 0; i4 < fragmentManagerState.Gc.length; i4++) {
                    FragmentState fragmentState2 = fragmentManagerState.Gc[i4];
                    if (fragmentState2 != null) {
                        h hVar2 = (list2 == null || i4 >= list2.size()) ? null : list2.get(i4);
                        ViewModelStore viewModelStore = null;
                        if (list != null && i4 < list.size()) {
                            viewModelStore = list.get(i4);
                        }
                        f fVar = this.mHost;
                        d dVar = this.mContainer;
                        Fragment fragment2 = this.mParent;
                        if (fragmentState2.Gg == null) {
                            Context context = fVar.mContext;
                            if (fragmentState2.mArguments != null) {
                                fragmentState2.mArguments.setClassLoader(context.getClassLoader());
                            }
                            if (dVar != null) {
                                fragmentState2.Gg = dVar.instantiate(context, fragmentState2.mClassName, fragmentState2.mArguments);
                            } else {
                                fragmentState2.Gg = Fragment.instantiate(context, fragmentState2.mClassName, fragmentState2.mArguments);
                            }
                            if (fragmentState2.mSavedFragmentState != null) {
                                fragmentState2.mSavedFragmentState.setClassLoader(context.getClassLoader());
                                fragmentState2.Gg.mSavedFragmentState = fragmentState2.mSavedFragmentState;
                            }
                            fragmentState2.Gg.setIndex(fragmentState2.mIndex, fragment2);
                            fragmentState2.Gg.mFromLayout = fragmentState2.mFromLayout;
                            fragmentState2.Gg.mRestored = true;
                            fragmentState2.Gg.mFragmentId = fragmentState2.mFragmentId;
                            fragmentState2.Gg.mContainerId = fragmentState2.mContainerId;
                            fragmentState2.Gg.mTag = fragmentState2.mTag;
                            fragmentState2.Gg.mRetainInstance = fragmentState2.mRetainInstance;
                            fragmentState2.Gg.mDetached = fragmentState2.mDetached;
                            fragmentState2.Gg.mHidden = fragmentState2.mHidden;
                            fragmentState2.Gg.mFragmentManager = fVar.mFragmentManager;
                            if (DEBUG) {
                                new StringBuilder("Instantiated fragment ").append(fragmentState2.Gg);
                            }
                        }
                        fragmentState2.Gg.mChildNonConfig = hVar2;
                        fragmentState2.Gg.mViewModelStore = viewModelStore;
                        Fragment fragment3 = fragmentState2.Gg;
                        if (DEBUG) {
                            new StringBuilder("restoreAllState: active #").append(i4).append(": ").append(fragment3);
                        }
                        this.mActive.put(fragment3.mIndex, fragment3);
                        fragmentState2.Gg = null;
                    }
                }
                if (hVar != null) {
                    List<Fragment> list6 = hVar.FZ;
                    int size2 = list6 != null ? list6.size() : 0;
                    for (int i5 = 0; i5 < size2; i5++) {
                        Fragment fragment4 = list6.get(i5);
                        if (fragment4.mTargetIndex >= 0) {
                            fragment4.mTarget = this.mActive.get(fragment4.mTargetIndex);
                            if (fragment4.mTarget == null) {
                                new StringBuilder("Re-attaching retained fragment ").append(fragment4).append(" target no longer exists: ").append(fragment4.mTargetIndex);
                            }
                        }
                    }
                }
                this.mAdded.clear();
                if (fragmentManagerState.Gd != null) {
                    for (int i6 = 0; i6 < fragmentManagerState.Gd.length; i6++) {
                        Fragment fragment5 = this.mActive.get(fragmentManagerState.Gd[i6]);
                        if (fragment5 == null) {
                            throwException(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.Gd[i6]));
                        }
                        fragment5.mAdded = true;
                        if (DEBUG) {
                            new StringBuilder("restoreAllState: added #").append(i6).append(": ").append(fragment5);
                        }
                        if (this.mAdded.contains(fragment5)) {
                            throw new IllegalStateException("Already added!");
                        }
                        synchronized (this.mAdded) {
                            this.mAdded.add(fragment5);
                        }
                    }
                }
                if (fragmentManagerState.Ge != null) {
                    this.mBackStack = new ArrayList<>(fragmentManagerState.Ge.length);
                    for (int i7 = 0; i7 < fragmentManagerState.Ge.length; i7++) {
                        b a2 = fragmentManagerState.Ge[i7].a(this);
                        if (DEBUG) {
                            new StringBuilder("restoreAllState: back stack #").append(i7).append(" (index ").append(a2.mIndex).append("): ").append(a2);
                            PrintWriter printWriter = new PrintWriter(new android.support.v4.e.f(TAG));
                            a2.a("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.mBackStack.add(a2);
                        if (a2.mIndex >= 0) {
                            setBackStackIndex(a2.mIndex, a2);
                        }
                    }
                } else {
                    this.mBackStack = null;
                }
                if (fragmentManagerState.Gf >= 0) {
                    this.mPrimaryNav = this.mActive.get(fragmentManagerState.Gf);
                }
                this.mNextFragmentIndex = fragmentManagerState.mNextFragmentIndex;
            }
        }
    }

    private void burpActive() {
        if (this.mActive != null) {
            for (int size = this.mActive.size() - 1; size >= 0; size--) {
                if (this.mActive.valueAt(size) == null) {
                    this.mActive.delete(this.mActive.keyAt(size));
                }
            }
        }
    }

    public final void attachController(f fVar, d dVar, Fragment fragment) {
        if (this.mHost != null) {
            throw new IllegalStateException("Already attached");
        }
        this.mHost = fVar;
        this.mContainer = dVar;
        this.mParent = fragment;
    }

    public final void noteStateNotSaved() {
        this.mSavedNonConfig = null;
        this.mStateSaved = false;
        this.mStopped = false;
        int size = this.mAdded.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.mAdded.get(i2);
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    public final void dispatchCreate() {
        this.mStateSaved = false;
        this.mStopped = false;
        dispatchStateChange(1);
    }

    public final void dispatchActivityCreated() {
        this.mStateSaved = false;
        this.mStopped = false;
        dispatchStateChange(2);
    }

    public final void dispatchStart() {
        this.mStateSaved = false;
        this.mStopped = false;
        dispatchStateChange(3);
    }

    public final void dispatchResume() {
        this.mStateSaved = false;
        this.mStopped = false;
        dispatchStateChange(4);
    }

    public final void dispatchPause() {
        dispatchStateChange(3);
    }

    public final void dispatchStop() {
        this.mStopped = true;
        dispatchStateChange(2);
    }

    public final void dispatchDestroyView() {
        dispatchStateChange(1);
    }

    public final void dispatchDestroy() {
        this.mDestroyed = true;
        execPendingActions();
        dispatchStateChange(0);
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
    }

    /* JADX INFO: finally extract failed */
    private void dispatchStateChange(int i2) {
        try {
            this.mExecutingActions = true;
            moveToState(i2, false);
            this.mExecutingActions = false;
            execPendingActions();
        } catch (Throwable th) {
            this.mExecutingActions = false;
            throw th;
        }
    }

    public final void dispatchMultiWindowModeChanged(boolean z) {
        for (int size = this.mAdded.size() - 1; size >= 0; size--) {
            Fragment fragment = this.mAdded.get(size);
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z);
            }
        }
    }

    public final void dispatchPictureInPictureModeChanged(boolean z) {
        for (int size = this.mAdded.size() - 1; size >= 0; size--) {
            Fragment fragment = this.mAdded.get(size);
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z);
            }
        }
    }

    public final void dispatchConfigurationChanged(Configuration configuration) {
        for (int i2 = 0; i2 < this.mAdded.size(); i2++) {
            Fragment fragment = this.mAdded.get(i2);
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    public final void dispatchLowMemory() {
        for (int i2 = 0; i2 < this.mAdded.size(); i2++) {
            Fragment fragment = this.mAdded.get(i2);
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    public final boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (this.mCurState <= 0) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        int i2 = 0;
        boolean z = false;
        while (i2 < this.mAdded.size()) {
            Fragment fragment = this.mAdded.get(i2);
            if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                z = true;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
            }
            i2++;
            z = z;
        }
        if (this.mCreatedMenus != null) {
            for (int i3 = 0; i3 < this.mCreatedMenus.size(); i3++) {
                Fragment fragment2 = this.mCreatedMenus.get(i3);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.mCreatedMenus = arrayList;
        return z;
    }

    public final boolean dispatchPrepareOptionsMenu(Menu menu) {
        if (this.mCurState <= 0) {
            return false;
        }
        boolean z = false;
        for (int i2 = 0; i2 < this.mAdded.size(); i2++) {
            Fragment fragment = this.mAdded.get(i2);
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public final boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        if (this.mCurState <= 0) {
            return false;
        }
        for (int i2 = 0; i2 < this.mAdded.size(); i2++) {
            Fragment fragment = this.mAdded.get(i2);
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final boolean dispatchContextItemSelected(MenuItem menuItem) {
        if (this.mCurState <= 0) {
            return false;
        }
        for (int i2 = 0; i2 < this.mAdded.size(); i2++) {
            Fragment fragment = this.mAdded.get(i2);
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void dispatchOptionsMenuClosed(Menu menu) {
        if (this.mCurState > 0) {
            for (int i2 = 0; i2 < this.mAdded.size(); i2++) {
                Fragment fragment = this.mAdded.get(i2);
                if (fragment != null) {
                    fragment.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    public final void setPrimaryNavigationFragment(Fragment fragment) {
        if (fragment == null || (this.mActive.get(fragment.mIndex) == fragment && (fragment.mHost == null || fragment.getFragmentManager() == this))) {
            this.mPrimaryNav = fragment;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    @Override // android.support.v4.app.g
    public final Fragment getPrimaryNavigationFragment() {
        return this.mPrimaryNav;
    }

    @Override // android.support.v4.app.g
    public final void registerFragmentLifecycleCallbacks(g.b bVar, boolean z) {
        this.mLifecycleCallbacks.add(new f(bVar, z));
    }

    @Override // android.support.v4.app.g
    public final void unregisterFragmentLifecycleCallbacks(g.b bVar) {
        synchronized (this.mLifecycleCallbacks) {
            int size = this.mLifecycleCallbacks.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (this.mLifecycleCallbacks.get(i2).FS == bVar) {
                    this.mLifecycleCallbacks.remove(i2);
                    break;
                } else {
                    i2++;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void dispatchOnFragmentPreAttached(Fragment fragment, Context context, boolean z) {
        if (this.mParent != null) {
            g fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentPreAttached(fragment, context, true);
            }
        }
        Iterator<f> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.FT) {
                next.FS.onFragmentPreAttached(this, fragment, context);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void dispatchOnFragmentAttached(Fragment fragment, Context context, boolean z) {
        if (this.mParent != null) {
            g fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentAttached(fragment, context, true);
            }
        }
        Iterator<f> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.FT) {
                next.FS.onFragmentAttached(this, fragment, context);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void dispatchOnFragmentPreCreated(Fragment fragment, Bundle bundle, boolean z) {
        if (this.mParent != null) {
            g fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentPreCreated(fragment, bundle, true);
            }
        }
        Iterator<f> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.FT) {
                next.FS.onFragmentPreCreated(this, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void dispatchOnFragmentCreated(Fragment fragment, Bundle bundle, boolean z) {
        if (this.mParent != null) {
            g fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentCreated(fragment, bundle, true);
            }
        }
        Iterator<f> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.FT) {
                next.FS.onFragmentCreated(this, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void dispatchOnFragmentActivityCreated(Fragment fragment, Bundle bundle, boolean z) {
        if (this.mParent != null) {
            g fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentActivityCreated(fragment, bundle, true);
            }
        }
        Iterator<f> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.FT) {
                next.FS.onFragmentActivityCreated(this, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void dispatchOnFragmentViewCreated(Fragment fragment, View view, Bundle bundle, boolean z) {
        if (this.mParent != null) {
            g fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentViewCreated(fragment, view, bundle, true);
            }
        }
        Iterator<f> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.FT) {
                next.FS.onFragmentViewCreated(this, fragment, view, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void dispatchOnFragmentStarted(Fragment fragment, boolean z) {
        if (this.mParent != null) {
            g fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentStarted(fragment, true);
            }
        }
        Iterator<f> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.FT) {
                next.FS.onFragmentStarted(this, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void dispatchOnFragmentResumed(Fragment fragment, boolean z) {
        if (this.mParent != null) {
            g fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentResumed(fragment, true);
            }
        }
        Iterator<f> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.FT) {
                next.FS.onFragmentResumed(this, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void dispatchOnFragmentPaused(Fragment fragment, boolean z) {
        if (this.mParent != null) {
            g fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentPaused(fragment, true);
            }
        }
        Iterator<f> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.FT) {
                next.FS.onFragmentPaused(this, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void dispatchOnFragmentStopped(Fragment fragment, boolean z) {
        if (this.mParent != null) {
            g fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentStopped(fragment, true);
            }
        }
        Iterator<f> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.FT) {
                next.FS.onFragmentStopped(this, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void dispatchOnFragmentSaveInstanceState(Fragment fragment, Bundle bundle, boolean z) {
        if (this.mParent != null) {
            g fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentSaveInstanceState(fragment, bundle, true);
            }
        }
        Iterator<f> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.FT) {
                next.FS.onFragmentSaveInstanceState(this, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void dispatchOnFragmentViewDestroyed(Fragment fragment, boolean z) {
        if (this.mParent != null) {
            g fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentViewDestroyed(fragment, true);
            }
        }
        Iterator<f> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.FT) {
                next.FS.onFragmentViewDestroyed(this, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void dispatchOnFragmentDestroyed(Fragment fragment, boolean z) {
        if (this.mParent != null) {
            g fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentDestroyed(fragment, true);
            }
        }
        Iterator<f> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.FT) {
                next.FS.onFragmentDestroyed(this, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void dispatchOnFragmentDetached(Fragment fragment, boolean z) {
        if (this.mParent != null) {
            g fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentDetached(fragment, true);
            }
        }
        Iterator<f> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z || next.FT) {
                next.FS.onFragmentDetached(this, fragment);
            }
        }
    }

    public static int reverseTransit(int i2) {
        switch (i2) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    public static int transitToStyleIndex(int i2, boolean z) {
        switch (i2) {
            case 4097:
                return z ? 1 : 2;
            case 4099:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        String str2;
        int i2;
        Fragment fragment;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.FU);
        if (attributeValue == null) {
            str2 = obtainStyledAttributes.getString(0);
        } else {
            str2 = attributeValue;
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.isSupportFragmentClass(this.mHost.mContext, str2)) {
            return null;
        }
        if (view != null) {
            i2 = view.getId();
        } else {
            i2 = 0;
        }
        if (i2 == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str2);
        }
        Fragment findFragmentById = resourceId != -1 ? findFragmentById(resourceId) : null;
        if (findFragmentById == null && string != null) {
            findFragmentById = findFragmentByTag(string);
        }
        if (findFragmentById == null && i2 != -1) {
            findFragmentById = findFragmentById(i2);
        }
        if (DEBUG) {
            new StringBuilder("onCreateView: id=0x").append(Integer.toHexString(resourceId)).append(" fname=").append(str2).append(" existing=").append(findFragmentById);
        }
        if (findFragmentById == null) {
            Fragment instantiate = this.mContainer.instantiate(context, str2, null);
            instantiate.mFromLayout = true;
            instantiate.mFragmentId = resourceId != 0 ? resourceId : i2;
            instantiate.mContainerId = i2;
            instantiate.mTag = string;
            instantiate.mInLayout = true;
            instantiate.mFragmentManager = this;
            instantiate.mHost = this.mHost;
            instantiate.onInflate(this.mHost.mContext, attributeSet, instantiate.mSavedFragmentState);
            addFragment(instantiate, true);
            fragment = instantiate;
        } else if (findFragmentById.mInLayout) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(i2) + " with another fragment for " + str2);
        } else {
            findFragmentById.mInLayout = true;
            findFragmentById.mHost = this.mHost;
            if (!findFragmentById.mRetaining) {
                findFragmentById.onInflate(this.mHost.mContext, attributeSet, findFragmentById.mSavedFragmentState);
            }
            fragment = findFragmentById;
        }
        if (this.mCurState > 0 || !fragment.mFromLayout) {
            moveToState(fragment);
        } else {
            moveToState(fragment, 1, 0, 0, false);
        }
        if (fragment.mView == null) {
            throw new IllegalStateException("Fragment " + str2 + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.mView.setId(resourceId);
        }
        if (fragment.mView.getTag() == null) {
            fragment.mView.setTag(string);
        }
        return fragment.mView;
    }

    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    /* access modifiers changed from: package-private */
    public final LayoutInflater.Factory2 getLayoutInflaterFactory() {
        return this;
    }

    class i implements h {
        final int FV;
        final int mId;
        final String mName;

        i(String str, int i2, int i3) {
            this.mName = str;
            this.mId = i2;
            this.FV = i3;
        }

        @Override // android.support.v4.app.FragmentManagerImpl.h
        public final boolean a(ArrayList<b> arrayList, ArrayList<Boolean> arrayList2) {
            g peekChildFragmentManager;
            if (FragmentManagerImpl.this.mPrimaryNav == null || this.mId >= 0 || this.mName != null || (peekChildFragmentManager = FragmentManagerImpl.this.mPrimaryNav.peekChildFragmentManager()) == null || !peekChildFragmentManager.popBackStackImmediate()) {
                return FragmentManagerImpl.this.popBackStackState(arrayList, arrayList2, this.mName, this.mId, this.FV);
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public static class j implements Fragment.c {
        final boolean FW;
        final b FX;
        int FY;

        j(b bVar, boolean z) {
            this.FW = z;
            this.FX = bVar;
        }

        @Override // android.support.v4.app.Fragment.c
        public final void ej() {
            this.FY--;
            if (this.FY == 0) {
                this.FX.EE.scheduleCommit();
            }
        }

        @Override // android.support.v4.app.Fragment.c
        public final void startListening() {
            this.FY++;
        }

        public final void em() {
            boolean z = false;
            boolean z2 = this.FY > 0;
            FragmentManagerImpl fragmentManagerImpl = this.FX.EE;
            int size = fragmentManagerImpl.mAdded.size();
            for (int i2 = 0; i2 < size; i2++) {
                Fragment fragment = fragmentManagerImpl.mAdded.get(i2);
                fragment.setOnStartEnterTransitionListener(null);
                if (z2 && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            FragmentManagerImpl fragmentManagerImpl2 = this.FX.EE;
            b bVar = this.FX;
            boolean z3 = this.FW;
            if (!z2) {
                z = true;
            }
            fragmentManagerImpl2.completeExecute(bVar, z3, z, true);
        }

        public final void en() {
            this.FX.EE.completeExecute(this.FX, this.FW, false, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static class c {
        public final Animation FN;
        public final Animator FO;

        c(Animation animation) {
            this.FN = animation;
            this.FO = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        c(Animator animator) {
            this.FN = null;
            this.FO = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    static class b implements Animation.AnimationListener {
        private final Animation.AnimationListener FM;

        b(Animation.AnimationListener animationListener) {
            this.FM = animationListener;
        }

        public void onAnimationStart(Animation animation) {
            if (this.FM != null) {
                this.FM.onAnimationStart(animation);
            }
        }

        public void onAnimationEnd(Animation animation) {
            if (this.FM != null) {
                this.FM.onAnimationEnd(animation);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            if (this.FM != null) {
                this.FM.onAnimationRepeat(animation);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class a extends b {
        View mView;

        a(View view, Animation.AnimationListener animationListener) {
            super(animationListener);
            this.mView = view;
        }

        @Override // android.support.v4.app.FragmentManagerImpl.b
        public final void onAnimationEnd(Animation animation) {
            if (u.aD(this.mView) || Build.VERSION.SDK_INT >= 24) {
                this.mView.post(new Runnable() {
                    /* class android.support.v4.app.FragmentManagerImpl.a.AnonymousClass1 */

                    public final void run() {
                        a.this.mView.setLayerType(0, null);
                    }
                });
            } else {
                this.mView.setLayerType(0, null);
            }
            super.onAnimationEnd(animation);
        }
    }

    /* access modifiers changed from: package-private */
    public static class d extends AnimatorListenerAdapter {
        View mView;

        d(View view) {
            this.mView = view;
        }

        public final void onAnimationStart(Animator animator) {
            this.mView.setLayerType(2, null);
        }

        public final void onAnimationEnd(Animator animator) {
            this.mView.setLayerType(0, null);
            animator.removeListener(this);
        }
    }

    /* access modifiers changed from: package-private */
    public static class e extends AnimationSet implements Runnable {
        private boolean CB;
        private final ViewGroup Ee;
        private final View FP;
        private boolean FQ;
        private boolean FR = true;

        e(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.Ee = viewGroup;
            this.FP = view;
            addAnimation(animation);
            this.Ee.post(this);
        }

        public final boolean getTransformation(long j2, Transformation transformation) {
            this.FR = true;
            if (this.CB) {
                if (!this.FQ) {
                    return true;
                }
                return false;
            } else if (super.getTransformation(j2, transformation)) {
                return true;
            } else {
                this.CB = true;
                w.a(this.Ee, this);
                return true;
            }
        }

        public final boolean getTransformation(long j2, Transformation transformation, float f2) {
            this.FR = true;
            if (this.CB) {
                if (!this.FQ) {
                    return true;
                }
                return false;
            } else if (super.getTransformation(j2, transformation, f2)) {
                return true;
            } else {
                this.CB = true;
                w.a(this.Ee, this);
                return true;
            }
        }

        public final void run() {
            if (this.CB || !this.FR) {
                this.Ee.endViewTransition(this.FP);
                this.FQ = true;
                return;
            }
            this.FR = false;
            this.Ee.post(this);
        }
    }
}
