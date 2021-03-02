package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem;

public class WebHistoryItem {

    /* renamed from: a  reason: collision with root package name */
    private IX5WebHistoryItem f1900a = null;

    /* renamed from: b  reason: collision with root package name */
    private android.webkit.WebHistoryItem f1901b = null;

    private WebHistoryItem() {
    }

    static WebHistoryItem a(IX5WebHistoryItem iX5WebHistoryItem) {
        AppMethodBeat.i(54629);
        if (iX5WebHistoryItem == null) {
            AppMethodBeat.o(54629);
            return null;
        }
        WebHistoryItem webHistoryItem = new WebHistoryItem();
        webHistoryItem.f1900a = iX5WebHistoryItem;
        AppMethodBeat.o(54629);
        return webHistoryItem;
    }

    static WebHistoryItem a(android.webkit.WebHistoryItem webHistoryItem) {
        AppMethodBeat.i(54630);
        if (webHistoryItem == null) {
            AppMethodBeat.o(54630);
            return null;
        }
        WebHistoryItem webHistoryItem2 = new WebHistoryItem();
        webHistoryItem2.f1901b = webHistoryItem;
        AppMethodBeat.o(54630);
        return webHistoryItem2;
    }

    public String getUrl() {
        AppMethodBeat.i(54631);
        if (this.f1900a != null) {
            String url = this.f1900a.getUrl();
            AppMethodBeat.o(54631);
            return url;
        }
        String url2 = this.f1901b.getUrl();
        AppMethodBeat.o(54631);
        return url2;
    }

    public String getOriginalUrl() {
        AppMethodBeat.i(54632);
        if (this.f1900a != null) {
            String originalUrl = this.f1900a.getOriginalUrl();
            AppMethodBeat.o(54632);
            return originalUrl;
        }
        String originalUrl2 = this.f1901b.getOriginalUrl();
        AppMethodBeat.o(54632);
        return originalUrl2;
    }

    public String getTitle() {
        AppMethodBeat.i(54633);
        if (this.f1900a != null) {
            String title = this.f1900a.getTitle();
            AppMethodBeat.o(54633);
            return title;
        }
        String title2 = this.f1901b.getTitle();
        AppMethodBeat.o(54633);
        return title2;
    }

    public Bitmap getFavicon() {
        AppMethodBeat.i(54634);
        if (this.f1900a != null) {
            Bitmap favicon = this.f1900a.getFavicon();
            AppMethodBeat.o(54634);
            return favicon;
        }
        Bitmap favicon2 = this.f1901b.getFavicon();
        AppMethodBeat.o(54634);
        return favicon2;
    }
}
