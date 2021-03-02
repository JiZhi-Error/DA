package com.tencent.mm.plugin.appbrand.shortlink;

import com.tencent.mm.plugin.appbrand.shortlink.cgi.WxaShortLinkInfo;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\bH&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/shortlink/IShortLinkInfoCache;", "", "clear", "", "shortLink", "", "clearAll", "get", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo;", "store", "info", "luggage-wechat-full-sdk_release"})
public interface a {
    void a(String str, WxaShortLinkInfo wxaShortLinkInfo);

    WxaShortLinkInfo aeX(String str);
}
