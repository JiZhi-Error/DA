package com.tencent.mm.plugin.topstory.a;

import com.tencent.mm.kernel.b.d;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.xweb.WebView;

public interface b extends d {
    e getRedDotMgr();

    f getReporter();

    WebView.c getWebViewType();

    void onVideoListUIDestroy(eit eit);

    void onVideoListUIPause();

    void onVideoListUIResume();

    boolean openJsAccelerate();
}
