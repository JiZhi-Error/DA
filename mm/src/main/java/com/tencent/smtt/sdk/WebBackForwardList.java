package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5WebBackForwardList;

public class WebBackForwardList {

    /* renamed from: a  reason: collision with root package name */
    private IX5WebBackForwardList f1898a = null;

    /* renamed from: b  reason: collision with root package name */
    private android.webkit.WebBackForwardList f1899b = null;

    static WebBackForwardList a(IX5WebBackForwardList iX5WebBackForwardList) {
        AppMethodBeat.i(54641);
        if (iX5WebBackForwardList == null) {
            AppMethodBeat.o(54641);
            return null;
        }
        WebBackForwardList webBackForwardList = new WebBackForwardList();
        webBackForwardList.f1898a = iX5WebBackForwardList;
        AppMethodBeat.o(54641);
        return webBackForwardList;
    }

    static WebBackForwardList a(android.webkit.WebBackForwardList webBackForwardList) {
        AppMethodBeat.i(54642);
        if (webBackForwardList == null) {
            AppMethodBeat.o(54642);
            return null;
        }
        WebBackForwardList webBackForwardList2 = new WebBackForwardList();
        webBackForwardList2.f1899b = webBackForwardList;
        AppMethodBeat.o(54642);
        return webBackForwardList2;
    }

    public WebHistoryItem getCurrentItem() {
        AppMethodBeat.i(54643);
        if (this.f1898a != null) {
            WebHistoryItem a2 = WebHistoryItem.a(this.f1898a.getCurrentItem());
            AppMethodBeat.o(54643);
            return a2;
        }
        WebHistoryItem a3 = WebHistoryItem.a(this.f1899b.getCurrentItem());
        AppMethodBeat.o(54643);
        return a3;
    }

    public int getCurrentIndex() {
        AppMethodBeat.i(54644);
        if (this.f1898a != null) {
            int currentIndex = this.f1898a.getCurrentIndex();
            AppMethodBeat.o(54644);
            return currentIndex;
        }
        int currentIndex2 = this.f1899b.getCurrentIndex();
        AppMethodBeat.o(54644);
        return currentIndex2;
    }

    public WebHistoryItem getItemAtIndex(int i2) {
        AppMethodBeat.i(54645);
        if (this.f1898a != null) {
            WebHistoryItem a2 = WebHistoryItem.a(this.f1898a.getItemAtIndex(i2));
            AppMethodBeat.o(54645);
            return a2;
        }
        WebHistoryItem a3 = WebHistoryItem.a(this.f1899b.getItemAtIndex(i2));
        AppMethodBeat.o(54645);
        return a3;
    }

    public int getSize() {
        AppMethodBeat.i(54646);
        if (this.f1898a != null) {
            int size = this.f1898a.getSize();
            AppMethodBeat.o(54646);
            return size;
        }
        int size2 = this.f1899b.getSize();
        AppMethodBeat.o(54646);
        return size2;
    }
}
