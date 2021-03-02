package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.mm.plugin.appbrand.appstorage.v;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Objects;

public class m extends l {
    @Override // com.tencent.mm.plugin.appbrand.jsapi.audio.l
    public final WxaPkg.Info e(f fVar, String str) {
        AppMethodBeat.i(182767);
        try {
            if (fVar.getFileSystem() instanceof v) {
                WxaPkg.Info openReadPartialInfo = ((IWxaFileSystemWithModularizing) Objects.requireNonNull(((v) fVar.getFileSystem()).az(IWxaFileSystemWithModularizing.class))).openReadPartialInfo(str);
                AppMethodBeat.o(182767);
                return openReadPartialInfo;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiSetAudioStateWxaApp", "getPkgPath with audioSrc(%s), e=%s", str, e2);
        }
        AppMethodBeat.o(182767);
        return null;
    }
}
