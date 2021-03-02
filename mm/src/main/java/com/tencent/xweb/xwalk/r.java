package com.tencent.xweb.xwalk;

import android.graphics.Bitmap;
import android.webkit.WebHistoryItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkNavigationItem;

public final class r extends WebHistoryItem {
    XWalkNavigationItem SHL;

    public r(XWalkNavigationItem xWalkNavigationItem) {
        this.SHL = xWalkNavigationItem;
    }

    public final String getUrl() {
        AppMethodBeat.i(207322);
        if (this.SHL == null) {
            AppMethodBeat.o(207322);
            return null;
        }
        String url = this.SHL.getUrl();
        AppMethodBeat.o(207322);
        return url;
    }

    public final String getOriginalUrl() {
        AppMethodBeat.i(207323);
        if (this.SHL == null) {
            AppMethodBeat.o(207323);
            return null;
        }
        String originalUrl = this.SHL.getOriginalUrl();
        AppMethodBeat.o(207323);
        return originalUrl;
    }

    public final String getTitle() {
        AppMethodBeat.i(207324);
        if (this.SHL == null) {
            AppMethodBeat.o(207324);
            return null;
        }
        String title = this.SHL.getTitle();
        AppMethodBeat.o(207324);
        return title;
    }

    public final Bitmap getFavicon() {
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object, android.webkit.WebHistoryItem, android.webkit.WebHistoryItem
    public final WebHistoryItem clone() {
        AppMethodBeat.i(207325);
        r rVar = new r(this.SHL);
        AppMethodBeat.o(207325);
        return rVar;
    }
}
