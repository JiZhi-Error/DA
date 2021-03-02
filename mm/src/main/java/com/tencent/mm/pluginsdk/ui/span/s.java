package com.tencent.mm.pluginsdk.ui.span;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.u;

public final class s {
    public static void i(Context context, Bundle bundle) {
        AppMethodBeat.i(31947);
        h.INSTANCE.a(11621, Integer.valueOf(bundle != null ? bundle.getInt("fromScene") : 0), 0);
        FileDownloadTaskInfo alh = f.cBv().alh("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100008");
        if (alh == null || alh.status != 3) {
            u.makeText(context, context.getString(R.string.b1g), 2000).show();
            g.a aVar = new g.a();
            aVar.alj("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100008");
            aVar.all(context.getString(R.string.b1m));
            aVar.Fl(1);
            aVar.kS(true);
            f.cBv().a(aVar.qIY);
            AppMethodBeat.o(31947);
            return;
        }
        Log.i("MicroMsg.WxPhoneBookHelper", "weixin phonebook already download successfully, install directly");
        if (com.tencent.mm.vfs.s.YS(alh.path)) {
            r.b(context, alh.path, null, false);
        }
        AppMethodBeat.o(31947);
    }
}
