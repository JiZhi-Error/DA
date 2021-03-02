package com.tencent.xweb.x5;

import android.graphics.Bitmap;
import android.webkit.WebHistoryItem;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k extends WebHistoryItem {
    private com.tencent.smtt.sdk.WebHistoryItem SFx;

    public k(com.tencent.smtt.sdk.WebHistoryItem webHistoryItem) {
        this.SFx = webHistoryItem;
    }

    public final String getUrl() {
        AppMethodBeat.i(207197);
        if (this.SFx == null) {
            AppMethodBeat.o(207197);
            return null;
        }
        String url = this.SFx.getUrl();
        AppMethodBeat.o(207197);
        return url;
    }

    public final String getOriginalUrl() {
        AppMethodBeat.i(207198);
        if (this.SFx == null) {
            AppMethodBeat.o(207198);
            return null;
        }
        String originalUrl = this.SFx.getOriginalUrl();
        AppMethodBeat.o(207198);
        return originalUrl;
    }

    public final String getTitle() {
        AppMethodBeat.i(207199);
        if (this.SFx == null) {
            AppMethodBeat.o(207199);
            return null;
        }
        String title = this.SFx.getTitle();
        AppMethodBeat.o(207199);
        return title;
    }

    public final Bitmap getFavicon() {
        AppMethodBeat.i(207200);
        if (this.SFx == null) {
            AppMethodBeat.o(207200);
            return null;
        }
        Bitmap favicon = this.SFx.getFavicon();
        AppMethodBeat.o(207200);
        return favicon;
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object, android.webkit.WebHistoryItem, android.webkit.WebHistoryItem
    public final WebHistoryItem clone() {
        AppMethodBeat.i(207201);
        k kVar = new k(this.SFx);
        AppMethodBeat.o(207201);
        return kVar;
    }
}
