package com.tencent.kinda.framework.widget.base;

interface FragmentLifecycle {
    void onFragmentOnCreate();

    void onFragmentOnDestroy();

    void onFragmentOnPause();

    void onFragmentOnResume();

    void onFragmentOnStart();

    void onFragmentOnStop();
}
