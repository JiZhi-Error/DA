package com.tencent.mm.plugin.appbrand.appcache.a;

import com.tencent.mm.pluginsdk.j.a.c.l;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public abstract class a extends l {
    public final String appId;
    public final int dMe;
    public volatile boolean kOB = true;
    public final int version;

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.a.a$a  reason: collision with other inner class name */
    public interface AbstractC0542a {
        String bvJ();
    }

    public a(String str, String str2, String str3, String str4, int i2, int i3) {
        super(str, str2, String.valueOf(i2), "AppBrandWxaPkgDownloader", str3, "GET", 1, 2, 0);
        this.appId = str4;
        this.version = i2;
        this.dMe = i3;
        setConnectTimeout((int) TimeUnit.SECONDS.toMillis(15));
        setReadTimeout((int) TimeUnit.SECONDS.toMillis(30));
    }

    public String toShortString() {
        return getClass().getSimpleName() + String.format(Locale.US, "[%s|%d|%d]", this.appId, Integer.valueOf(this.version), Integer.valueOf(this.dMe));
    }
}
