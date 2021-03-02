package com.github.henryye.nativeiv.b;

import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import java.io.BufferedInputStream;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;

public final class a implements b {
    public int bbs = 60000;
    public int bbt = 60000;

    @Override // com.github.henryye.nativeiv.b.b
    public final boolean accept(Object obj) {
        AppMethodBeat.i(127391);
        if (!(obj instanceof String)) {
            AppMethodBeat.o(127391);
            return false;
        } else if (((String) obj).startsWith(HttpWrapperBase.PROTOCAL_HTTP) || ((String) obj).startsWith(HttpWrapperBase.PROTOCAL_HTTPS)) {
            AppMethodBeat.o(127391);
            return true;
        } else {
            AppMethodBeat.o(127391);
            return false;
        }
    }

    @Override // com.github.henryye.nativeiv.b.b
    public final b.a a(Object obj, ImageDecodeConfig imageDecodeConfig) {
        AppMethodBeat.i(219805);
        b.a aVar = new b.a();
        try {
            URLConnection openConnection = new URL((String) obj).openConnection();
            openConnection.setReadTimeout(this.bbt);
            openConnection.setConnectTimeout(this.bbs);
            aVar.inputStream = new BufferedInputStream(openConnection.getInputStream());
        } catch (SocketTimeoutException e2) {
            aVar.errorMsg = "http请求超时";
            com.github.henryye.nativeiv.a.b.e("NativeImageHttpFetcher", "ImageFetch Timeout! path[%s] connectionTimeout[%d] readTimeout[%d] error[%s]", obj, Integer.valueOf(this.bbs), Integer.valueOf(this.bbt), e2.toString());
        } catch (Exception e3) {
            aVar.errorMsg = "http请求出现错误";
            com.github.henryye.nativeiv.a.b.e("NativeImageHttpFetcher", "fetch error. path = [%s], error = [%s]", obj, e3.toString());
        }
        AppMethodBeat.o(219805);
        return aVar;
    }

    @Override // com.github.henryye.nativeiv.b.b
    public final String sS() {
        return "http";
    }
}
