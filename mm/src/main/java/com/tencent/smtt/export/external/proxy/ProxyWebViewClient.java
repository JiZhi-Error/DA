package com.tencent.smtt.export.external.proxy;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import com.tencent.smtt.export.external.interfaces.ClientCertRequest;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;

public abstract class ProxyWebViewClient implements IX5WebViewClient {
    private boolean mCompatibleOnPageStartedOrFinishedMethod = false;
    protected IX5WebViewClient mWebViewClient;

    public void setWebViewClient(IX5WebViewClient iX5WebViewClient) {
        this.mWebViewClient = iX5WebViewClient;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void doUpdateVisitedHistory(IX5WebViewBase iX5WebViewBase, String str, boolean z) {
        if (this.mWebViewClient != null) {
            this.mWebViewClient.doUpdateVisitedHistory(iX5WebViewBase, str, z);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onContentSizeChanged(IX5WebViewBase iX5WebViewBase, int i2, int i3) {
        if (this.mWebViewClient != null) {
            this.mWebViewClient.onContentSizeChanged(iX5WebViewBase, i2, i3);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onFormResubmission(IX5WebViewBase iX5WebViewBase, Message message, Message message2) {
        if (this.mWebViewClient != null) {
            this.mWebViewClient.onFormResubmission(iX5WebViewBase, message, message2);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onLoadResource(IX5WebViewBase iX5WebViewBase, String str) {
        if (this.mWebViewClient != null) {
            this.mWebViewClient.onLoadResource(iX5WebViewBase, str);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onPageFinished(IX5WebViewBase iX5WebViewBase, String str) {
        if (this.mWebViewClient != null) {
            this.mWebViewClient.onPageFinished(iX5WebViewBase, str);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onPageStarted(IX5WebViewBase iX5WebViewBase, String str, Bitmap bitmap) {
        if (this.mWebViewClient != null) {
            this.mWebViewClient.onPageStarted(iX5WebViewBase, str, bitmap);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedError(IX5WebViewBase iX5WebViewBase, int i2, String str, String str2) {
        if (this.mWebViewClient != null) {
            this.mWebViewClient.onReceivedError(iX5WebViewBase, i2, str, str2);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedError(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (this.mWebViewClient != null) {
            this.mWebViewClient.onReceivedError(iX5WebViewBase, webResourceRequest, webResourceError);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedHttpError(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        if (this.mWebViewClient != null) {
            this.mWebViewClient.onReceivedHttpError(iX5WebViewBase, webResourceRequest, webResourceResponse);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedHttpAuthRequest(IX5WebViewBase iX5WebViewBase, HttpAuthHandler httpAuthHandler, String str, String str2) {
        if (this.mWebViewClient != null) {
            this.mWebViewClient.onReceivedHttpAuthRequest(iX5WebViewBase, httpAuthHandler, str, str2);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedSslError(IX5WebViewBase iX5WebViewBase, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (this.mWebViewClient != null) {
            this.mWebViewClient.onReceivedSslError(iX5WebViewBase, sslErrorHandler, sslError);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedClientCertRequest(IX5WebViewBase iX5WebViewBase, ClientCertRequest clientCertRequest) {
        if (this.mWebViewClient != null) {
            this.mWebViewClient.onReceivedClientCertRequest(iX5WebViewBase, clientCertRequest);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onScaleChanged(IX5WebViewBase iX5WebViewBase, float f2, float f3) {
        if (this.mWebViewClient != null) {
            this.mWebViewClient.onScaleChanged(iX5WebViewBase, f2, f3);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onUnhandledKeyEvent(IX5WebViewBase iX5WebViewBase, KeyEvent keyEvent) {
        if (this.mWebViewClient != null) {
            this.mWebViewClient.onUnhandledKeyEvent(iX5WebViewBase, keyEvent);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public boolean shouldOverrideKeyEvent(IX5WebViewBase iX5WebViewBase, KeyEvent keyEvent) {
        return this.mWebViewClient != null && this.mWebViewClient.shouldOverrideKeyEvent(iX5WebViewBase, keyEvent);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public boolean shouldOverrideUrlLoading(IX5WebViewBase iX5WebViewBase, String str) {
        return this.mWebViewClient != null && this.mWebViewClient.shouldOverrideUrlLoading(iX5WebViewBase, str);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public boolean shouldOverrideUrlLoading(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest) {
        return this.mWebViewClient != null && this.mWebViewClient.shouldOverrideUrlLoading(iX5WebViewBase, webResourceRequest);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onTooManyRedirects(IX5WebViewBase iX5WebViewBase, Message message, Message message2) {
        if (this.mWebViewClient != null) {
            this.mWebViewClient.onTooManyRedirects(iX5WebViewBase, message, message2);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest) {
        if (this.mWebViewClient != null) {
            return this.mWebViewClient.shouldInterceptRequest(iX5WebViewBase, webResourceRequest);
        }
        return null;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, Bundle bundle) {
        if (this.mWebViewClient != null) {
            return this.mWebViewClient.shouldInterceptRequest(iX5WebViewBase, webResourceRequest, bundle);
        }
        return null;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, String str) {
        if (this.mWebViewClient != null) {
            return this.mWebViewClient.shouldInterceptRequest(iX5WebViewBase, str);
        }
        return null;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onReceivedLoginRequest(IX5WebViewBase iX5WebViewBase, String str, String str2, String str3) {
        if (this.mWebViewClient != null) {
            this.mWebViewClient.onReceivedLoginRequest(iX5WebViewBase, str, str2, str3);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onPageStarted(IX5WebViewBase iX5WebViewBase, int i2, int i3, String str, Bitmap bitmap) {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onPageFinished(IX5WebViewBase iX5WebViewBase, int i2, int i3, String str) {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onDetectedBlankScreen(IX5WebViewBase iX5WebViewBase, String str, int i2) {
    }

    public void countPVContentCacheCallBack(String str) {
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewClient
    public void onPageCommitVisible(IX5WebViewBase iX5WebViewBase, String str) {
    }
}
