package com.tencent.mm.plugin.topstory.ui;

import com.tencent.mm.kernel.b.d;

public interface b extends d {

    public interface a {
        void aTx(String str);
    }

    com.tencent.mm.plugin.topstory.ui.home.d getWebViewMgr();

    void setHaokanEventListener(a aVar);

    void tryToCreateTopStoryWebView();
}
