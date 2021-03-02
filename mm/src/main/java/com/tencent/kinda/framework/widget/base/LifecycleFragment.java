package com.tencent.kinda.framework.widget.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragment;
import java.util.List;

/* access modifiers changed from: package-private */
public abstract class LifecycleFragment extends MMFragment implements FragmentLifecycle {
    private static final String TAG = "MicroMsg.LifecycleFragment";
    protected State mState = State.INITIAL;

    LifecycleFragment() {
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        _callFragmentOnCreate();
        _fixOnPauseNotCallingProblem();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        _callFragmentOnCreate();
        _fixOnPauseNotCallingProblem();
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onStart() {
        super.onStart();
        _callFragmentOnStart();
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onResume() {
        super.onResume();
        _fixCallOnResumeOrOnPause();
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onPause() {
        super.onPause();
        _callFragmentOnPause();
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onStop() {
        super.onStop();
        _callFragmentOnStop();
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onDestroyView() {
        super.onDestroyView();
        _callFragmentOnDestroy();
        _fixOnResumeNotCallingProblem();
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onDestroy() {
        super.onDestroy();
        _callFragmentOnDestroy();
        _fixOnResumeNotCallingProblem();
    }

    private void _callFragmentOnCreate() {
        Log.d(TAG, "_callFragmentOnCreate: %s", this.mState);
        if (this.mState == State.INITIAL) {
            this.mState = State.CREATED;
            onFragmentOnCreate();
        }
    }

    private void _callFragmentOnStart() {
        Log.d(TAG, "_callFragmentOnStart: %s", this.mState);
        if (this.mState == State.CREATED || this.mState == State.STOPPED) {
            this.mState = State.STARTED;
            onFragmentOnStart();
        }
    }

    private void _callFragmentOnResume() {
        Log.d(TAG, "_callFragmentOnResume: %s", this.mState);
        if (this.mState == State.STARTED || this.mState == State.PAUSED) {
            this.mState = State.RESUMED;
            onFragmentOnResume();
        }
    }

    private void _callFragmentOnPause() {
        Log.d(TAG, "_callFragmentOnPause: %s", this.mState);
        if (this.mState == State.RESUMED || this.mState == State.STARTED) {
            this.mState = State.PAUSED;
            onFragmentOnPause();
        }
    }

    private void _callFragmentOnStop() {
        Log.d(TAG, "_callFragmentOnStop: %s", this.mState);
        if (this.mState == State.PAUSED) {
            this.mState = State.STOPPED;
            onFragmentOnStop();
        }
    }

    private void _callFragmentOnDestroy() {
        Log.d(TAG, "_callFragmentOnDestroy: %s", this.mState);
        if (this.mState == State.STOPPED) {
            this.mState = State.DESTROYED;
            onFragmentOnDestroy();
        }
    }

    private void _fixCallOnResumeOrOnPause() {
        if (getActivity() == null) {
            Log.w(TAG, "null activity when call");
            return;
        }
        List<Fragment> fragments = getActivity().getSupportFragmentManager().getFragments();
        Log.d(TAG, "call on resume or puase: %s", fragments);
        if (fragments.size() <= 0 || fragments.get(fragments.size() - 1) != this) {
            _callFragmentOnPause();
        } else {
            _callFragmentOnResume();
        }
    }

    private void _fixOnResumeNotCallingProblem() {
        if (getActivity() == null) {
            Log.w(TAG, "null activity when call");
            return;
        }
        List<Fragment> fragments = getActivity().getSupportFragmentManager().getFragments();
        Log.d(TAG, "current fragments: %s", fragments);
        if (fragments.size() > 0) {
            Fragment fragment = fragments.get(fragments.size() - 1);
            if (fragment instanceof LifecycleFragment) {
                ((LifecycleFragment) fragment)._callFragmentOnResume();
            }
        }
    }

    private void _fixOnPauseNotCallingProblem() {
        if (getActivity() == null) {
            Log.w(TAG, "null activity when call");
            return;
        }
        List<Fragment> fragments = getActivity().getSupportFragmentManager().getFragments();
        Log.d(TAG, "current fragments: %s", fragments);
        if (fragments.size() >= 2) {
            Fragment fragment = fragments.get(fragments.size() - 2);
            if (fragment instanceof LifecycleFragment) {
                ((LifecycleFragment) fragment)._callFragmentOnPause();
            }
        }
    }

    @Override // com.tencent.kinda.framework.widget.base.FragmentLifecycle
    public void onFragmentOnCreate() {
        Log.d(TAG, "lifecycle: onFragmentOnCreate, class: %s", toString());
    }

    @Override // com.tencent.kinda.framework.widget.base.FragmentLifecycle
    public void onFragmentOnDestroy() {
        Log.d(TAG, "lifecycle: onFragmentOnDestroy, class: %s", toString());
    }

    @Override // com.tencent.kinda.framework.widget.base.FragmentLifecycle
    public void onFragmentOnStart() {
        Log.d(TAG, "lifecycle: onFragmentOnStart, class: %s", toString());
    }

    @Override // com.tencent.kinda.framework.widget.base.FragmentLifecycle
    public void onFragmentOnStop() {
        Log.d(TAG, "lifecycle: onFragmentOnStop, class: %s", toString());
    }

    @Override // com.tencent.kinda.framework.widget.base.FragmentLifecycle
    public void onFragmentOnResume() {
        Log.d(TAG, "lifecycle: onFragmentOnResume, class: %s", toString());
    }

    @Override // com.tencent.kinda.framework.widget.base.FragmentLifecycle
    public void onFragmentOnPause() {
        Log.d(TAG, "lifecycle: onFragmentOnPause, class: %s", toString());
    }

    /* access modifiers changed from: package-private */
    public enum State {
        INITIAL(0),
        CREATED(1),
        STARTED(2),
        RESUMED(3),
        PAUSED(4),
        STOPPED(5),
        DESTROYED(6);
        
        private int value = 0;

        public static State valueOf(String str) {
            AppMethodBeat.i(178773);
            State state = (State) Enum.valueOf(State.class, str);
            AppMethodBeat.o(178773);
            return state;
        }

        static {
            AppMethodBeat.i(178774);
            AppMethodBeat.o(178774);
        }

        private State(int i2) {
            this.value = i2;
        }
    }
}
