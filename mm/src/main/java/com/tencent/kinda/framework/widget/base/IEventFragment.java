package com.tencent.kinda.framework.widget.base;

public interface IEventFragment {
    boolean addFragment(BaseFragment baseFragment);

    boolean popFragment();

    boolean removeModal(BaseFragment baseFragment);
}
