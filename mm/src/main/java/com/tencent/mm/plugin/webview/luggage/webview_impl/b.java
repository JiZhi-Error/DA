package com.tencent.mm.plugin.webview.luggage.webview_impl;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import java.util.Map;

public final class b implements WebResourceRequest {
    private boolean IXl;
    private boolean IXm;
    private Map<String, String> IXn;
    private String csu;
    private boolean mIsRedirect = false;
    private Uri mUri;

    public b(Uri uri, boolean z, boolean z2, String str, Map<String, String> map) {
        this.mUri = uri;
        this.IXl = z;
        this.IXm = z2;
        this.csu = str;
        this.IXn = map;
    }

    public final Uri getUrl() {
        return this.mUri;
    }

    public final boolean isForMainFrame() {
        return this.IXl;
    }

    public final boolean isRedirect() {
        return this.mIsRedirect;
    }

    public final boolean hasGesture() {
        return this.IXm;
    }

    public final String getMethod() {
        return this.csu;
    }

    @Override // android.webkit.WebResourceRequest
    public final Map<String, String> getRequestHeaders() {
        return this.IXn;
    }
}
