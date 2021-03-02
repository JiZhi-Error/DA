package com.bumptech.glide.load.c;

import com.bumptech.glide.g.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.URL;
import java.security.MessageDigest;

public class g implements com.bumptech.glide.load.g {
    private int aHK;
    public final h aJR;
    public final String aJS;
    public String aJT;
    public URL aJU;
    private volatile byte[] aJV;
    public final URL url;

    public g(URL url2) {
        this(url2, h.aJX);
    }

    public g(String str) {
        this(str, h.aJX);
    }

    private g(URL url2, h hVar) {
        AppMethodBeat.i(77237);
        this.url = (URL) j.checkNotNull(url2, "Argument must not be null");
        this.aJS = null;
        this.aJR = (h) j.checkNotNull(hVar, "Argument must not be null");
        AppMethodBeat.o(77237);
    }

    private g(String str, h hVar) {
        AppMethodBeat.i(77238);
        this.url = null;
        this.aJS = j.checkNotEmpty(str);
        this.aJR = (h) j.checkNotNull(hVar, "Argument must not be null");
        AppMethodBeat.o(77238);
    }

    private String getCacheKey() {
        AppMethodBeat.i(77239);
        if (this.aJS != null) {
            String str = this.aJS;
            AppMethodBeat.o(77239);
            return str;
        }
        String url2 = ((URL) j.checkNotNull(this.url, "Argument must not be null")).toString();
        AppMethodBeat.o(77239);
        return url2;
    }

    public String toString() {
        AppMethodBeat.i(77240);
        String cacheKey = getCacheKey();
        AppMethodBeat.o(77240);
        return cacheKey;
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object obj) {
        AppMethodBeat.i(77242);
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (!getCacheKey().equals(gVar.getCacheKey()) || !this.aJR.equals(gVar.aJR)) {
                AppMethodBeat.o(77242);
                return false;
            }
            AppMethodBeat.o(77242);
            return true;
        }
        AppMethodBeat.o(77242);
        return false;
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        AppMethodBeat.i(77243);
        if (this.aHK == 0) {
            this.aHK = getCacheKey().hashCode();
            this.aHK = (this.aHK * 31) + this.aJR.hashCode();
        }
        int i2 = this.aHK;
        AppMethodBeat.o(77243);
        return i2;
    }

    @Override // com.bumptech.glide.load.g
    public final void a(MessageDigest messageDigest) {
        AppMethodBeat.i(77241);
        if (this.aJV == null) {
            this.aJV = getCacheKey().getBytes(aEV);
        }
        messageDigest.update(this.aJV);
        AppMethodBeat.o(77241);
    }
}
