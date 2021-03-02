package com.tencent.mm.plugin.appbrand.jsapi.ag.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.u.d;
import com.tencent.mm.plugin.appbrand.m.q;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.skia_canvas.resource_loader.IResourceLoader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.apache.commons.a.e;

public final class c implements IResourceLoader {
    a csX;
    s mJr;
    b mJs;

    public c(b bVar, a aVar, s sVar) {
        this.mJs = bVar;
        this.csX = aVar;
        this.mJr = sVar;
    }

    @Override // com.tencent.xweb.skia_canvas.resource_loader.IResourceLoader
    public final byte[] loadResource(String str, String str2) {
        boolean z;
        AppMethodBeat.i(215815);
        if (this.csX == null || this.mJs == null || this.mJr == null) {
            Log.e("MicroMsg.WxaNativeImageLoader", "mImageLoader or mUrlBuilder is null, return");
            AppMethodBeat.o(215815);
            return null;
        }
        try {
            byte[] byteArray = e.toByteArray(this.mJr.getFileSystem().Wc(str));
            Object[] objArr = new Object[1];
            if (byteArray != null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            Log.i("MicroMsg.WxaNativeImageLoader", "loadResource bytes:%b", objArr);
            AppMethodBeat.o(215815);
            return byteArray;
        } catch (IOException e2) {
            Log.e("MicroMsg.WxaNativeImageLoader", "loadResource sync fail: %s", e2.getMessage());
            AppMethodBeat.o(215815);
            return null;
        }
    }

    @Override // com.tencent.xweb.skia_canvas.resource_loader.IResourceLoader
    public final void loadResourceAsync(final String str, String str2, final IResourceLoader.ResourceLoadCallback resourceLoadCallback) {
        Map<String, String> aaG;
        AppMethodBeat.i(215816);
        if (this.csX == null || this.mJs == null || this.mJr == null || Util.isNullOrNil(str)) {
            Log.e("MicroMsg.WxaNativeImageLoader", "mImageLoader or mUrlBuilder or path:%s is null, return", str);
            resourceLoadCallback.onResourceLoaded(null);
            AppMethodBeat.o(215816);
        } else if (str.startsWith("http") || str.startsWith("https")) {
            String b2 = this.mJs.b(this.mJr, str);
            Log.i("MicroMsg.WxaNativeImageLoader", "finalUrl : %s", b2);
            a aVar = this.csX;
            com.tencent.mm.plugin.appbrand.jsapi.u.a aVar2 = (com.tencent.mm.plugin.appbrand.jsapi.u.a) com.tencent.luggage.a.e.M(com.tencent.mm.plugin.appbrand.jsapi.u.a.class);
            if (aVar2 == null) {
                Log.w("MicroMsg.WxaNativeImageLoader", "buildHeaders, referrerHelper is null");
                aaG = null;
            } else if (str2 == null) {
                Log.w("MicroMsg.WxaNativeImageLoader", "buildHeaders, referrerPolicyStr is null");
                aaG = null;
            } else {
                com.tencent.mm.plugin.appbrand.jsapi.u.c aaF = aVar2.aaF(str2);
                if (aaF == null) {
                    if (this.mJr != null) {
                        aaF = aVar2.x(this.mJr);
                    } else {
                        Log.w("MicroMsg.WxaNativeImageLoader", "buildHeaders, mAppBrandService is null");
                    }
                }
                if (aaF == null) {
                    aaF = aVar2.bIw();
                }
                if (com.tencent.mm.plugin.appbrand.jsapi.u.c.NO_REFERRER == aaF) {
                    aaG = null;
                } else if (this.mJr == null) {
                    Log.w("MicroMsg.WxaNativeImageLoader", "buildHeaders, mAppBrandService is null");
                    aaG = null;
                } else {
                    String y = aVar2.y(this.mJr);
                    Log.i("MicroMsg.WxaNativeImageLoader", "buildHeaders, referrer: ".concat(String.valueOf(y)));
                    aaG = d.aaG(y);
                }
            }
            aVar.a(b2, aaG, new a.c() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.b.c.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.f.a.c
                public final void C(InputStream inputStream) {
                    AppMethodBeat.i(215813);
                    if (inputStream == null) {
                        try {
                            Log.e("MicroMsg.WxaNativeImageLoader", "inputStream is null, error");
                            if (resourceLoadCallback != null) {
                                resourceLoadCallback.onResourceLoaded(null);
                            }
                            AppMethodBeat.o(215813);
                        } catch (IOException e2) {
                            Log.e("MicroMsg.WxaNativeImageLoader", "loadResource Async fail: %s", e2.getMessage());
                            if (resourceLoadCallback != null) {
                                resourceLoadCallback.onResourceLoaded(null);
                            }
                            AppMethodBeat.o(215813);
                        }
                    } else {
                        final byte[] byteArray = e.toByteArray(inputStream);
                        Object[] objArr = new Object[1];
                        objArr[0] = Boolean.valueOf(byteArray != null);
                        Log.i("MicroMsg.WxaNativeImageLoader", "loadResourceAsync bytes:%b", objArr);
                        if (c.this.mJr.getJsRuntime() == null) {
                            Log.e("MicroMsg.WxaNativeImageLoader", "js runtime is null, error");
                            if (resourceLoadCallback != null) {
                                resourceLoadCallback.onResourceLoaded(null);
                            }
                            AppMethodBeat.o(215813);
                            return;
                        }
                        q qVar = (q) c.this.mJr.getJsRuntime().R(q.class);
                        if (qVar != null) {
                            qVar.post(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.b.c.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(215812);
                                    if (resourceLoadCallback != null) {
                                        resourceLoadCallback.onResourceLoaded(byteArray);
                                    }
                                    AppMethodBeat.o(215812);
                                }
                            });
                        }
                        AppMethodBeat.o(215813);
                    }
                }
            });
            AppMethodBeat.o(215816);
        } else if (this.mJr.getJsRuntime() == null) {
            Log.e("MicroMsg.WxaNativeImageLoader", "js runtime is null, error");
            if (resourceLoadCallback != null) {
                resourceLoadCallback.onResourceLoaded(null);
            }
            AppMethodBeat.o(215816);
        } else {
            q qVar = (q) this.mJr.getJsRuntime().R(q.class);
            if (qVar != null) {
                qVar.post(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.ag.b.c.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(215814);
                        try {
                            byte[] byteArray = e.toByteArray(c.this.mJr.getFileSystem().Wc(str));
                            Object[] objArr = new Object[1];
                            objArr[0] = Boolean.valueOf(byteArray != null);
                            Log.i("MicroMsg.WxaNativeImageLoader", "loadResource bytes:%b", objArr);
                            if (resourceLoadCallback != null) {
                                resourceLoadCallback.onResourceLoaded(byteArray);
                            }
                            AppMethodBeat.o(215814);
                        } catch (IOException | NullPointerException e2) {
                            Log.e("MicroMsg.WxaNativeImageLoader", "loadResource sync fail: %s", e2.getMessage());
                            if (resourceLoadCallback != null) {
                                resourceLoadCallback.onResourceLoaded(null);
                            }
                            AppMethodBeat.o(215814);
                        }
                    }
                });
            }
            AppMethodBeat.o(215816);
        }
    }
}
