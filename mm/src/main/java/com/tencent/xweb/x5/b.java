package com.tencent.xweb.x5;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebChromeClient;

public class b extends WebChromeClient {
    public final void huJ() {
        AppMethodBeat.i(153831);
        super.onHideCustomView();
        AppMethodBeat.o(153831);
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public View getVideoLoadingProgressView() {
        AppMethodBeat.i(153832);
        View videoLoadingProgressView = super.getVideoLoadingProgressView();
        AppMethodBeat.o(153832);
        return videoLoadingProgressView;
    }
}
