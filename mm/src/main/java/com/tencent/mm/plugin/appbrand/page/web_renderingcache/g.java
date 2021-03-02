package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.web_renderingcache.WebRenderingCacheIPCOperations;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.protocal.protobuf.es;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0016J0\u0010\u0017\u001a\u00020\u00182\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0016J\f\u0010\u001c\u001a\u00020\u0006*\u00020\u0006H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheProviderNewImpl;", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/IPageWebRenderingCacheProvider;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "appVersionId", "", "commLibVersionId", "enabled", "", "filePrefix", "renderingCachePBMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/protocal/protobuf/AppBrandWebRenderingCachePB;", "acquireCachePB", "pagePath", "createIPCOpParcel", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "path", "getCacheFilePath", "getCachedContent", "getCachedServiceData", "getCachedWebViewData", "saveRenderingCache", "", "content", "webviewData", "serviceData", "urlEncode", "Companion", "plugin-appbrand-integration_release"})
public final class g implements a {
    public static final a nww = new a((byte) 0);
    private final boolean enabled;
    private final q kGW;
    private final String nwq;
    private final String nwr;
    private final String nwu;
    private final ConcurrentHashMap<String, es> nwv;

    static {
        AppMethodBeat.i(50993);
        AppMethodBeat.o(50993);
    }

    private /* synthetic */ g(q qVar, byte b2) {
        this(qVar);
    }

    private g(q qVar) {
        String str;
        boolean z;
        AppMethodBeat.i(50992);
        this.kGW = qVar;
        String bvc = this.kGW.bqZ().bvc();
        p.g(bvc, "runtime.libReader.versionBuildInfo()");
        this.nwq = bvc;
        switch (this.kGW.brf()) {
            case 1:
                str = "TEST";
                break;
            case 2:
                str = "DEMO";
                break;
            default:
                str = String.valueOf(this.kGW.OJ());
                break;
        }
        this.nwr = str;
        WebRenderingCacheDirectoryDescriptor webRenderingCacheDirectoryDescriptor = this.kGW.bsC().ldV;
        String str2 = webRenderingCacheDirectoryDescriptor != null ? webRenderingCacheDirectoryDescriptor.nwn : null;
        String str3 = str2;
        if (str3 == null || str3.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.enabled = false;
            this.nwu = "";
        } else {
            this.enabled = true;
            this.nwu = str2 + '_' + this.nwq.hashCode() + '_' + this.nwr;
        }
        this.nwv = new ConcurrentHashMap<>();
        AppMethodBeat.o(50992);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheProviderNewImpl$Companion;", "", "()V", "TAG", "", "create", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheProviderNewImpl;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private final String aee(String str) {
        AppMethodBeat.i(50985);
        StringBuilder append = new StringBuilder().append(this.nwu).append('_');
        String encode = URLEncoder.encode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        p.g(encode, "URLEncoder.encode(this, \"UTF-8\")");
        String sb = append.append(encode).append(".rc").toString();
        AppMethodBeat.o(50985);
        return sb;
    }

    private final WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel aef(String str) {
        AppMethodBeat.i(50986);
        String appId = this.kGW.getAppId();
        p.g(appId, "runtime.appId");
        WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel webRenderingCacheRecordParcel = new WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel(appId, this.nwq, this.nwr, str);
        AppMethodBeat.o(50986);
        return webRenderingCacheRecordParcel;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.web_renderingcache.a
    public final void i(String str, String str2, String str3, String str4) {
        int i2;
        int i3 = -1;
        AppMethodBeat.i(50987);
        if (this.enabled) {
            String str5 = str;
            if (!(str5 == null || str5.length() == 0)) {
                StringBuilder append = new StringBuilder("save path[").append(str).append("] content[");
                if (str2 != null) {
                    i2 = str2.length();
                } else {
                    i2 = -1;
                }
                StringBuilder append2 = append.append(i2).append("] webviewData[").append(str3 != null ? str3.length() : -1).append("] serviceData[");
                if (str4 != null) {
                    i3 = str4.length();
                }
                Log.i("MicroMsg.AppBrand.WebRenderingCacheProviderNewImpl", append2.append(i3).append(']').toString());
                if (str2 == null) {
                    s.deleteFile(aee(str));
                    f.a(new WebRenderingCacheIPCOperations.c(), aef(str));
                    AppMethodBeat.o(50987);
                    return;
                }
                ConcurrentHashMap<String, es> concurrentHashMap = this.nwv;
                es esVar = new es();
                esVar.content = str2;
                esVar.KIi = str3;
                esVar.KIj = str4;
                String aee = aee(str);
                try {
                    s.C(aee, esVar.toByteArray());
                    WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel aef = aef(str);
                    aef.filePath = aee;
                    f.a(new WebRenderingCacheIPCOperations.b(), aef);
                } catch (IOException e2) {
                    Log.e("MicroMsg.AppBrand.WebRenderingCacheProviderNewImpl", "saveRenderingCache appId[" + this.kGW.getAppId() + "] path[" + str + "] e=" + e2);
                }
                concurrentHashMap.put(str, esVar);
                AppMethodBeat.o(50987);
                return;
            }
        }
        Log.e("MicroMsg.AppBrand.WebRenderingCacheProviderNewImpl", "saveRenderingCache disabled appId[" + this.kGW.getAppId() + "] path[" + str + ']');
        AppMethodBeat.o(50987);
    }

    private final es aeg(String str) {
        AppMethodBeat.i(50988);
        es esVar = this.nwv.get(str);
        if (esVar == null) {
            String aee = aee(str);
            long boW = s.boW(aee);
            if (boW > 0) {
                es esVar2 = new es();
                try {
                    esVar2.parseFrom(s.aW(aee, 0, (int) boW));
                } catch (IOException e2) {
                    s.deleteFile(aee);
                }
                this.nwv.put(str, esVar2);
                esVar = esVar2;
            }
        }
        AppMethodBeat.o(50988);
        return esVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.web_renderingcache.a
    public final String adZ(String str) {
        boolean z;
        boolean z2;
        String str2 = null;
        AppMethodBeat.i(50989);
        if (this.enabled) {
            String str3 = str;
            if (str3 == null || str3.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                es aeg = aeg(str);
                if (aeg != null) {
                    str2 = aeg.content;
                }
                String str4 = str2;
                if (str4 == null || str4.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    f.a(new WebRenderingCacheIPCOperations.a(), aef(str));
                }
                AppMethodBeat.o(50989);
                return str2;
            }
        }
        AppMethodBeat.o(50989);
        return str2;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.web_renderingcache.a
    public final String aea(String str) {
        AppMethodBeat.i(50990);
        if (this.enabled) {
            String str2 = str;
            if (!(str2 == null || str2.length() == 0)) {
                es aeg = aeg(str);
                if (aeg != null) {
                    String str3 = aeg.KIi;
                    AppMethodBeat.o(50990);
                    return str3;
                }
                AppMethodBeat.o(50990);
                return null;
            }
        }
        AppMethodBeat.o(50990);
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.web_renderingcache.a
    public final String aeb(String str) {
        AppMethodBeat.i(50991);
        if (this.enabled) {
            String str2 = str;
            if (!(str2 == null || str2.length() == 0)) {
                es aeg = aeg(str);
                if (aeg != null) {
                    String str3 = aeg.KIj;
                    AppMethodBeat.o(50991);
                    return str3;
                }
                AppMethodBeat.o(50991);
                return null;
            }
        }
        AppMethodBeat.o(50991);
        return null;
    }

    public static final g D(q qVar) {
        AppMethodBeat.i(229254);
        p.h(qVar, "rt");
        if (qVar.bqZ() == null) {
            Log.e("MicroMsg.AppBrand.WebRenderingCacheProviderNewImpl", "try create provider but rt.libReader is NULL, appId:" + qVar.getAppId());
            AppMethodBeat.o(229254);
            return null;
        }
        g gVar = new g(qVar, (byte) 0);
        AppMethodBeat.o(229254);
        return gVar;
    }
}
