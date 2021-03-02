package com.tencent.mm.plugin.appbrand.appstorage;

import android.support.annotation.Keep;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;

@Keep
public interface IWxaFileSystemWithModularizing extends q {
    WxaPkg.Info openReadPartialInfo(String str);
}
