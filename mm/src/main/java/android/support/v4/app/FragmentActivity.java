package android.support.v4.app;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.ViewModelStore;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.app.a;
import android.support.v4.e.d;
import android.support.v4.e.o;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class FragmentActivity extends SupportActivity implements ViewModelStoreOwner, a.AbstractC0015a, a.c {
    static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
    static final String FRAGMENTS_TAG = "android:support:fragments";
    static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
    static final int MSG_RESUME_PENDING = 2;
    static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
    static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
    private static final String TAG = "FragmentActivity";
    boolean mCreated;
    final e mFragments = new e(new a());
    final Handler mHandler = new Handler() {
        /* class android.support.v4.app.FragmentActivity.AnonymousClass1 */

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 2:
                    FragmentActivity.this.onResumeFragments();
                    FragmentActivity.this.mFragments.execPendingActions();
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    };
    int mNextCandidateRequestIndex;
    o<String> mPendingFragmentActivityResults;
    boolean mRequestedPermissionsFromFragment;
    boolean mResumed;
    boolean mStartedActivityFromFragment;
    boolean mStartedIntentSenderFromFragment;
    boolean mStopped = true;
    private ViewModelStore mViewModelStore;

    static final class b {
        Object FD;
        ViewModelStore FE;
        h FF;

        b() {
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        Fragment findFragmentByWho;
        this.mFragments.noteStateNotSaved();
        int i4 = i2 >> 16;
        if (i4 != 0) {
            int i5 = i4 - 1;
            String str = this.mPendingFragmentActivityResults.get(i5, null);
            this.mPendingFragmentActivityResults.delete(i5);
            if (str != null && (findFragmentByWho = this.mFragments.findFragmentByWho(str)) != null) {
                findFragmentByWho.onActivityResult(65535 & i2, i3, intent);
                return;
            }
            return;
        }
        a.b dV = a.dV();
        if (dV == null || !dV.dX()) {
            super.onActivityResult(i2, i3, intent);
        }
    }

    public void onBackPressed() {
        FragmentManagerImpl fragmentManagerImpl = this.mFragments.mHost.mFragmentManager;
        boolean isStateSaved = fragmentManagerImpl.isStateSaved();
        if (isStateSaved && Build.VERSION.SDK_INT <= 25) {
            return;
        }
        if (isStateSaved || !fragmentManagerImpl.popBackStackImmediate()) {
            super.onBackPressed();
        }
    }

    public void supportFinishAfterTransition() {
        a.e(this);
    }

    public void setEnterSharedElementCallback(z zVar) {
        a.a(this, zVar);
    }

    public void setExitSharedElementCallback(z zVar) {
        a.b(this, zVar);
    }

    public void supportPostponeEnterTransition() {
        a.f(this);
    }

    public void supportStartPostponedEnterTransition() {
        a.g(this);
    }

    public void onMultiWindowModeChanged(boolean z) {
        this.mFragments.mHost.mFragmentManager.dispatchMultiWindowModeChanged(z);
    }

    public void onPictureInPictureModeChanged(boolean z) {
        this.mFragments.mHost.mFragmentManager.dispatchPictureInPictureModeChanged(z);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFragments.noteStateNotSaved();
        this.mFragments.mHost.mFragmentManager.dispatchConfigurationChanged(configuration);
    }

    @Override // android.arch.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.mViewModelStore == null) {
            b bVar = (b) getLastNonConfigurationInstance();
            if (bVar != null) {
                this.mViewModelStore = bVar.FE;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new ViewModelStore();
            }
        }
        return this.mViewModelStore;
    }

    @Override // android.arch.lifecycle.LifecycleOwner, android.support.v4.app.SupportActivity
    public Lifecycle getLifecycle() {
        return super.getLifecycle();
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.SupportActivity
    public void onCreate(Bundle bundle) {
        e eVar = this.mFragments;
        eVar.mHost.mFragmentManager.attachController(eVar.mHost, eVar.mHost, null);
        super.onCreate(bundle);
        b bVar = (b) getLastNonConfigurationInstance();
        if (!(bVar == null || bVar.FE == null || this.mViewModelStore != null)) {
            this.mViewModelStore = bVar.FE;
        }
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable(FRAGMENTS_TAG);
            e eVar2 = this.mFragments;
            eVar2.mHost.mFragmentManager.restoreAllState(parcelable, bVar != null ? bVar.FF : null);
            if (bundle.containsKey(NEXT_CANDIDATE_REQUEST_INDEX_TAG)) {
                this.mNextCandidateRequestIndex = bundle.getInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG);
                int[] intArray = bundle.getIntArray(ALLOCATED_REQUEST_INDICIES_TAG);
                String[] stringArray = bundle.getStringArray(REQUEST_FRAGMENT_WHO_TAG);
                if (!(intArray == null || stringArray == null || intArray.length != stringArray.length)) {
                    this.mPendingFragmentActivityResults = new o<>(intArray.length);
                    for (int i2 = 0; i2 < intArray.length; i2++) {
                        this.mPendingFragmentActivityResults.put(intArray[i2], stringArray[i2]);
                    }
                }
            }
        }
        if (this.mPendingFragmentActivityResults == null) {
            this.mPendingFragmentActivityResults = new o<>();
            this.mNextCandidateRequestIndex = 0;
        }
        this.mFragments.mHost.mFragmentManager.dispatchCreate();
    }

    public boolean onCreatePanelMenu(int i2, Menu menu) {
        if (i2 != 0) {
            return super.onCreatePanelMenu(i2, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i2, menu);
        e eVar = this.mFragments;
        return onCreatePanelMenu | eVar.mHost.mFragmentManager.dispatchCreateOptionsMenu(menu, getMenuInflater());
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        if (dispatchFragmentsOnCreateView == null) {
            return super.onCreateView(view, str, context, attributeSet);
        }
        return dispatchFragmentsOnCreateView;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        if (dispatchFragmentsOnCreateView == null) {
            return super.onCreateView(str, context, attributeSet);
        }
        return dispatchFragmentsOnCreateView;
    }

    /* access modifiers changed from: package-private */
    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.mHost.mFragmentManager.onCreateView(view, str, context, attributeSet);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.mViewModelStore != null && !isChangingConfigurations()) {
            this.mViewModelStore.clear();
        }
        this.mFragments.mHost.mFragmentManager.dispatchDestroy();
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.mHost.mFragmentManager.dispatchLowMemory();
    }

    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        switch (i2) {
            case 0:
                return this.mFragments.mHost.mFragmentManager.dispatchOptionsItemSelected(menuItem);
            case 6:
                return this.mFragments.mHost.mFragmentManager.dispatchContextItemSelected(menuItem);
            default:
                return false;
        }
    }

    public void onPanelClosed(int i2, Menu menu) {
        switch (i2) {
            case 0:
                this.mFragments.mHost.mFragmentManager.dispatchOptionsMenuClosed(menu);
                break;
        }
        super.onPanelClosed(i2, menu);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
            onResumeFragments();
        }
        this.mFragments.mHost.mFragmentManager.dispatchPause();
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.noteStateNotSaved();
    }

    public void onStateNotSaved() {
        this.mFragments.noteStateNotSaved();
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onResume() {
        super.onResume();
        this.mHandler.sendEmptyMessage(2);
        this.mResumed = true;
        this.mFragments.execPendingActions();
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onPostResume() {
        super.onPostResume();
        this.mHandler.removeMessages(2);
        onResumeFragments();
        this.mFragments.execPendingActions();
    }

    /* access modifiers changed from: protected */
    public void onResumeFragments() {
        this.mFragments.mHost.mFragmentManager.dispatchResume();
    }

    public boolean onPreparePanel(int i2, View view, Menu menu) {
        if (i2 != 0 || menu == null) {
            return super.onPreparePanel(i2, view, menu);
        }
        return onPrepareOptionsPanel(view, menu) | this.mFragments.mHost.mFragmentManager.dispatchPrepareOptionsMenu(menu);
    }

    /* access modifiers changed from: protected */
    public boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public final Object onRetainNonConfigurationInstance() {
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        h retainNonConfig = this.mFragments.mHost.mFragmentManager.retainNonConfig();
        if (retainNonConfig == null && this.mViewModelStore == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        b bVar = new b();
        bVar.FD = onRetainCustomNonConfigurationInstance;
        bVar.FE = this.mViewModelStore;
        bVar.FF = retainNonConfig;
        return bVar;
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.SupportActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        markFragmentsCreated();
        Parcelable saveAllState = this.mFragments.mHost.mFragmentManager.saveAllState();
        if (saveAllState != null) {
            bundle.putParcelable(FRAGMENTS_TAG, saveAllState);
        }
        if (this.mPendingFragmentActivityResults.size() > 0) {
            bundle.putInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG, this.mNextCandidateRequestIndex);
            int[] iArr = new int[this.mPendingFragmentActivityResults.size()];
            String[] strArr = new String[this.mPendingFragmentActivityResults.size()];
            for (int i2 = 0; i2 < this.mPendingFragmentActivityResults.size(); i2++) {
                iArr[i2] = this.mPendingFragmentActivityResults.keyAt(i2);
                strArr[i2] = this.mPendingFragmentActivityResults.valueAt(i2);
            }
            bundle.putIntArray(ALLOCATED_REQUEST_INDICIES_TAG, iArr);
            bundle.putStringArray(REQUEST_FRAGMENT_WHO_TAG, strArr);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.mHost.mFragmentManager.dispatchActivityCreated();
        }
        this.mFragments.noteStateNotSaved();
        this.mFragments.execPendingActions();
        this.mFragments.mHost.mFragmentManager.dispatchStart();
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.mHost.mFragmentManager.dispatchStop();
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public Object getLastCustomNonConfigurationInstance() {
        b bVar = (b) getLastNonConfigurationInstance();
        if (bVar != null) {
            return bVar.FD;
        }
        return null;
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            p.d(this).dump(str2, fileDescriptor, printWriter, strArr);
        }
        this.mFragments.mHost.mFragmentManager.dump(str, fileDescriptor, printWriter, strArr);
    }

    public void onAttachFragment(Fragment fragment) {
    }

    public g getSupportFragmentManager() {
        return this.mFragments.mHost.mFragmentManager;
    }

    @Deprecated
    public p getSupportLoaderManager() {
        return p.d(this);
    }

    public void startActivityForResult(Intent intent, int i2) {
        if (!this.mStartedActivityFromFragment && i2 != -1) {
            checkForValidRequestCode(i2);
        }
        super.startActivityForResult(intent, i2);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        if (!this.mStartedActivityFromFragment && i2 != -1) {
            checkForValidRequestCode(i2);
        }
        super.startActivityForResult(intent, i2, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) {
        if (!this.mStartedIntentSenderFromFragment && i2 != -1) {
            checkForValidRequestCode(i2);
        }
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        if (!this.mStartedIntentSenderFromFragment && i2 != -1) {
            checkForValidRequestCode(i2);
        }
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
    }

    static void checkForValidRequestCode(int i2) {
        if ((-65536 & i2) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    @Override // android.support.v4.app.a.c
    public final void validateRequestPermissionsRequestCode(int i2) {
        if (!this.mRequestedPermissionsFromFragment && i2 != -1) {
            checkForValidRequestCode(i2);
        }
    }

    @Override // android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Fragment findFragmentByWho;
        this.mFragments.noteStateNotSaved();
        int i3 = (i2 >> 16) & 65535;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String str = this.mPendingFragmentActivityResults.get(i4, null);
            this.mPendingFragmentActivityResults.delete(i4);
            if (str != null && (findFragmentByWho = this.mFragments.findFragmentByWho(str)) != null) {
                findFragmentByWho.onRequestPermissionsResult(i2 & 65535, strArr, iArr);
            }
        }
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i2) {
        startActivityFromFragment(fragment, intent, i2, (Bundle) null);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i2, Bundle bundle) {
        this.mStartedActivityFromFragment = true;
        if (i2 == -1) {
            try {
                a.a(this, intent, -1, bundle);
            } finally {
                this.mStartedActivityFromFragment = false;
            }
        } else {
            checkForValidRequestCode(i2);
            a.a(this, intent, ((allocateRequestIndex(fragment) + 1) << 16) + (65535 & i2), bundle);
            this.mStartedActivityFromFragment = false;
        }
    }

    public void startIntentSenderFromFragment(Fragment fragment, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        this.mStartedIntentSenderFromFragment = true;
        if (i2 == -1) {
            try {
                a.a(this, intentSender, i2, intent, i3, i4, i5, bundle);
            } finally {
                this.mStartedIntentSenderFromFragment = false;
            }
        } else {
            checkForValidRequestCode(i2);
            a.a(this, intentSender, ((allocateRequestIndex(fragment) + 1) << 16) + (65535 & i2), intent, i3, i4, i5, bundle);
            this.mStartedIntentSenderFromFragment = false;
        }
    }

    private int allocateRequestIndex(Fragment fragment) {
        if (this.mPendingFragmentActivityResults.size() >= MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        while (true) {
            o<String> oVar = this.mPendingFragmentActivityResults;
            int i2 = this.mNextCandidateRequestIndex;
            if (oVar.OU) {
                oVar.gc();
            }
            if (d.b(oVar.Pi, oVar.mSize, i2) >= 0) {
                this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
            } else {
                int i3 = this.mNextCandidateRequestIndex;
                this.mPendingFragmentActivityResults.put(i3, fragment.mWho);
                this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
                return i3;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public void requestPermissionsFromFragment(Fragment fragment, String[] strArr, int i2) {
        if (i2 == -1) {
            a.a(this, strArr, i2);
            return;
        }
        checkForValidRequestCode(i2);
        try {
            this.mRequestedPermissionsFromFragment = true;
            a.a(this, strArr, ((allocateRequestIndex(fragment) + 1) << 16) + (65535 & i2));
            this.mRequestedPermissionsFromFragment = false;
        } catch (Throwable th) {
            this.mRequestedPermissionsFromFragment = false;
            throw th;
        }
    }

    class a extends f<FragmentActivity> {
        public a() {
            super(FragmentActivity.this);
        }

        @Override // android.support.v4.app.f
        public final void a(String str, PrintWriter printWriter, String[] strArr) {
            FragmentActivity.this.dump(str, null, printWriter, strArr);
        }

        @Override // android.support.v4.app.f
        public final boolean ek() {
            return !FragmentActivity.this.isFinishing();
        }

        @Override // android.support.v4.app.f
        public final LayoutInflater onGetLayoutInflater() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        @Override // android.support.v4.app.f
        public final void el() {
            FragmentActivity.this.supportInvalidateOptionsMenu();
        }

        @Override // android.support.v4.app.f
        public final void a(Fragment fragment, Intent intent, int i2, Bundle bundle) {
            FragmentActivity.this.startActivityFromFragment(fragment, intent, i2, bundle);
        }

        @Override // android.support.v4.app.f
        public final void a(Fragment fragment, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
            FragmentActivity.this.startIntentSenderFromFragment(fragment, intentSender, i2, intent, i3, i4, i5, bundle);
        }

        @Override // android.support.v4.app.f
        public final void a(Fragment fragment, String[] strArr, int i2) {
            FragmentActivity.this.requestPermissionsFromFragment(fragment, strArr, i2);
        }

        @Override // android.support.v4.app.f
        public final boolean r(String str) {
            return a.a(FragmentActivity.this, str);
        }

        @Override // android.support.v4.app.f
        public final boolean onHasWindowAnimations() {
            return FragmentActivity.this.getWindow() != null;
        }

        @Override // android.support.v4.app.f
        public final int onGetWindowAnimations() {
            Window window = FragmentActivity.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        @Override // android.support.v4.app.f
        public final void onAttachFragment(Fragment fragment) {
            FragmentActivity.this.onAttachFragment(fragment);
        }

        @Override // android.support.v4.app.d, android.support.v4.app.f
        public final View onFindViewById(int i2) {
            return FragmentActivity.this.findViewById(i2);
        }

        @Override // android.support.v4.app.d, android.support.v4.app.f
        public final boolean onHasView() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.support.v4.app.f
        public final /* bridge */ /* synthetic */ FragmentActivity onGetHost() {
            return FragmentActivity.this;
        }
    }

    private void markFragmentsCreated() {
        do {
        } while (markState(getSupportFragmentManager(), Lifecycle.State.CREATED));
    }

    private static boolean markState(g gVar, Lifecycle.State state) {
        boolean z;
        boolean z2 = false;
        for (Fragment fragment : gVar.getFragments()) {
            if (fragment != null) {
                if (fragment.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                    fragment.mLifecycleRegistry.markState(state);
                    z2 = true;
                }
                g peekChildFragmentManager = fragment.peekChildFragmentManager();
                if (peekChildFragmentManager != null) {
                    z = markState(peekChildFragmentManager, state) | z2;
                } else {
                    z = z2;
                }
                z2 = z;
            }
        }
        return z2;
    }
}
