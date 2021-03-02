package com.tencent.mm.plugin.fav.offline.ui;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.List;

public final class a {
    private Context context;
    private com.tencent.mm.plugin.fav.offline.b.a tcM;

    public a(Context context2, com.tencent.mm.plugin.fav.offline.b.a aVar) {
        this.context = context2;
        this.tcM = aVar;
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void doImgPreview(String str) {
        AppMethodBeat.i(73574);
        o oVar = new o(Uri.parse(str));
        if (!oVar.exists()) {
            Log.i("MicroMsg.offline.FavOfflineJavaObj", "doImgPreview() currentPath:%s no exist", str);
            AppMethodBeat.o(73574);
        } else if (ImgUtil.isGif(aa.z(oVar.mUri))) {
            Log.d("MicroMsg.offline.FavOfflineJavaObj", "doImgPreview() currentPath:%s is a gif", str);
            AppMethodBeat.o(73574);
        } else {
            Log.i("MicroMsg.offline.FavOfflineJavaObj", "doImgPreview() currentPath:%s", str);
            List<String> stringToList = Util.stringToList(this.tcM.field_imgPaths, ",");
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            int i2 = 0;
            for (int i3 = 0; i3 < stringToList.size(); i3++) {
                String str2 = this.tcM.field_imgDirPath + FilePathGenerator.ANDROID_DIR_SEP + stringToList.get(i3);
                if (!ImgUtil.isGif(str2)) {
                    arrayList.add(str2);
                    if (!z && !Util.isNullOrNil(str) && str.endsWith(stringToList.get(i3))) {
                        z = true;
                    } else if (!z) {
                        i2++;
                    }
                }
            }
            String[] strArr = new String[arrayList.size()];
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                strArr[i4] = (String) arrayList.get(i4);
                if (Util.isEqual((String) arrayList.get(i4), oVar.getName())) {
                    i2 = i4;
                }
            }
            Intent intent = new Intent();
            intent.putExtra("nowUrlPath", str);
            intent.putExtra("nowUrl", strArr[i2]);
            intent.putExtra("urlList", strArr);
            intent.putExtra("type", -255);
            intent.putExtra("isFromWebView", true);
            intent.putExtra("currentPos", i2);
            intent.putExtra("shouldShowScanQrCodeMenu", false);
            if (this.context instanceof Service) {
                intent.addFlags(268435456);
            }
            Bundle bundle = new Bundle();
            bundle.putInt("stat_scene", 4);
            bundle.putString("stat_url", "");
            intent.putExtra("_stat_obj", bundle);
            com.tencent.mm.plugin.webview.a.a.jRt.p(intent, this.context);
            AppMethodBeat.o(73574);
        }
    }
}
