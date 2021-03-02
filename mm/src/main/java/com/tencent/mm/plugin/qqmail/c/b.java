package com.tencent.mm.plugin.qqmail.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.URI;
import java.net.URL;

public class b implements com.tencent.mm.ipcinvoker.b<Bundle, IPCLong> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public /* synthetic */ void invoke(Bundle bundle, d<IPCLong> dVar) {
        AppMethodBeat.i(198579);
        Bundle bundle2 = bundle;
        try {
            String string = bundle2.getString("download_url", "");
            String string2 = bundle2.getString("download_md5", "");
            Log.i("MicroMsg.DownloadMailApkTask", "download, url %s, md5 %s", string, string2);
            URL url = new URL(string);
            URL url2 = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()).toURL();
            g.a aVar = new g.a();
            aVar.alj(url2.toString());
            aVar.all("qqmail.apk");
            aVar.setFileMD5(string2);
            aVar.kS(true);
            aVar.Fl(1);
            dVar.bn(new IPCLong(f.cBv().a(aVar.qIY)));
            AppMethodBeat.o(198579);
        } catch (Exception e2) {
            dVar.bn(new IPCLong(-1));
            Log.e("MicroMsg.DownloadMailApkTask", "dz[download qq mail error:%s]", e2.toString());
            Log.printErrStackTrace("MicroMsg.DownloadMailApkTask", e2, "", new Object[0]);
            AppMethodBeat.o(198579);
        }
    }
}
