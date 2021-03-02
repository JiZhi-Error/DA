package com.tencent.mm.plugin.qqmail.stub;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.qqmail.c;
import com.tencent.mm.plugin.qqmail.d.k;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.e;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ca;
import java.net.URI;
import java.net.URL;
import java.util.Map;

public class ReadMailProxy extends a {
    private c.a BqR;
    private c.a BtA;
    private ReadMailUI.a BtB;
    private o.a BtC = new o.a() {
        /* class com.tencent.mm.plugin.qqmail.stub.ReadMailProxy.AnonymousClass1 */

        @Override // com.tencent.mm.pluginsdk.ui.tools.o.a
        public final void onSuccess(int i2) {
            AppMethodBeat.i(198668);
            ReadMailProxy.this.CLIENT_CALL("onGetQQMailUnreadSuccess", Integer.valueOf(i2));
            AppMethodBeat.o(198668);
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.o.a
        public final void eGv() {
            AppMethodBeat.i(198669);
            ReadMailProxy.this.CLIENT_CALL("onGetQQMailUnreadFailed", new Object[0]);
            AppMethodBeat.o(198669);
        }
    };

    public ReadMailProxy(d dVar, c.a aVar) {
        super(dVar);
        AppMethodBeat.i(198675);
        this.BqR = aVar;
        this.BtA = new c.a() {
            /* class com.tencent.mm.plugin.qqmail.stub.ReadMailProxy.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.qqmail.c.a
            public final boolean onReady() {
                AppMethodBeat.i(198670);
                boolean booleanValue = ((Boolean) ReadMailProxy.this.CLIENT_CALL("onReady", new Object[0])).booleanValue();
                AppMethodBeat.o(198670);
                return booleanValue;
            }

            @Override // com.tencent.mm.plugin.qqmail.c.a
            public final void onSuccess(String str, Map<String, String> map) {
                AppMethodBeat.i(198671);
                ReadMailProxy.this.CLIENT_CALL("onSuccess", str, map);
                AppMethodBeat.o(198671);
            }

            @Override // com.tencent.mm.plugin.qqmail.c.a
            public final void onError(int i2, String str) {
                AppMethodBeat.i(198672);
                ReadMailProxy.this.CLIENT_CALL("onError", Integer.valueOf(i2), str);
                AppMethodBeat.o(198672);
            }

            @Override // com.tencent.mm.plugin.qqmail.c.a
            public final void onComplete() {
                AppMethodBeat.i(198673);
                ReadMailProxy.this.CLIENT_CALL("onComplete", new Object[0]);
                AppMethodBeat.o(198673);
            }
        };
        AppMethodBeat.o(198675);
    }

    public ReadMailProxy(d dVar, c.a aVar, ReadMailUI.a aVar2) {
        super(dVar);
        AppMethodBeat.i(198676);
        this.BqR = aVar;
        this.BtB = aVar2;
        this.BtA = new c.a() {
            /* class com.tencent.mm.plugin.qqmail.stub.ReadMailProxy.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.qqmail.c.a
            public final boolean onReady() {
                AppMethodBeat.i(122812);
                boolean booleanValue = ((Boolean) ReadMailProxy.this.CLIENT_CALL("onReady", new Object[0])).booleanValue();
                AppMethodBeat.o(122812);
                return booleanValue;
            }

            @Override // com.tencent.mm.plugin.qqmail.c.a
            public final void onSuccess(String str, Map<String, String> map) {
                AppMethodBeat.i(122813);
                ReadMailProxy.this.CLIENT_CALL("onSuccess", str, map);
                AppMethodBeat.o(122813);
            }

            @Override // com.tencent.mm.plugin.qqmail.c.a
            public final void onError(int i2, String str) {
                AppMethodBeat.i(122814);
                ReadMailProxy.this.CLIENT_CALL("onError", Integer.valueOf(i2), str);
                AppMethodBeat.o(122814);
            }

            @Override // com.tencent.mm.plugin.qqmail.c.a
            public final void onComplete() {
                AppMethodBeat.i(122815);
                ReadMailProxy.this.CLIENT_CALL("onComplete", new Object[0]);
                AppMethodBeat.o(122815);
            }
        };
        AppMethodBeat.o(198676);
    }

    @e
    public boolean onReady() {
        AppMethodBeat.i(122824);
        if (this.BqR == null) {
            AppMethodBeat.o(122824);
            return true;
        }
        boolean onReady = this.BqR.onReady();
        AppMethodBeat.o(122824);
        return onReady;
    }

    @e
    public void onSuccess(String str, Map<String, String> map) {
        AppMethodBeat.i(122825);
        if (this.BqR != null) {
            this.BqR.onSuccess(str, map);
        }
        AppMethodBeat.o(122825);
    }

    @e
    public void onError(int i2, String str) {
        AppMethodBeat.i(122826);
        if (this.BqR != null) {
            this.BqR.onError(i2, str);
        }
        AppMethodBeat.o(122826);
    }

    @e
    public void onComplete() {
        AppMethodBeat.i(122827);
        if (this.BqR != null) {
            this.BqR.onComplete();
        }
        AppMethodBeat.o(122827);
    }

    @f
    public long get(String str, Map map, Bundle bundle) {
        AppMethodBeat.i(122833);
        c.b bVar = new c.b();
        bVar.fromBundle(bundle);
        long a2 = ((k) g.ah(k.class)).getNormalMailAppService().a(str, 0, map, bVar, this.BtA);
        AppMethodBeat.o(122833);
        return a2;
    }

    @f
    public long post(String str, Map map, Bundle bundle) {
        AppMethodBeat.i(122834);
        c.b bVar = new c.b();
        bVar.fromBundle(bundle);
        long a2 = ((k) g.ah(k.class)).getNormalMailAppService().a(str, map, bVar, this.BtA);
        AppMethodBeat.o(122834);
        return a2;
    }

    @f
    public void cancel(final long j2) {
        AppMethodBeat.i(122835);
        new MMHandler().post(new Runnable() {
            /* class com.tencent.mm.plugin.qqmail.stub.ReadMailProxy.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(198674);
                ((k) g.ah(k.class)).getNormalMailAppService().cancel(j2);
                AppMethodBeat.o(198674);
            }
        });
        AppMethodBeat.o(122835);
    }

    @f
    public boolean isSDCardAvailable() {
        AppMethodBeat.i(122836);
        boolean isSDCardAvailable = g.aAh().isSDCardAvailable();
        AppMethodBeat.o(122836);
        return isSDCardAvailable;
    }

    @f
    public String getMsgContent(long j2) {
        AppMethodBeat.i(122837);
        String str = ((l) g.af(l.class)).eiy().Hb(j2).field_content;
        AppMethodBeat.o(122837);
        return str;
    }

    @f
    public void replaceMsgContent(final long j2, final String str) {
        AppMethodBeat.i(122838);
        new MMHandler().post(new Runnable() {
            /* class com.tencent.mm.plugin.qqmail.stub.ReadMailProxy.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(122820);
                ca Hb = ((l) g.af(l.class)).eiy().Hb(j2);
                Hb.setContent(Hb.field_content.replaceFirst("<digest>.*</digest>", "<digest>" + str + "</digest>"));
                ((l) g.af(l.class)).eiy().a(j2, Hb);
                AppMethodBeat.o(122820);
            }
        });
        AppMethodBeat.o(122838);
    }

    @f
    public void deleteMsgById(long j2) {
        AppMethodBeat.i(122840);
        ((l) g.af(l.class)).eiy().Hc(j2);
        AppMethodBeat.o(122840);
    }

    @f
    public String getUserBindEmail() {
        AppMethodBeat.i(122841);
        String userBindEmail = z.getUserBindEmail();
        AppMethodBeat.o(122841);
        return userBindEmail;
    }

    @f
    public long downloadQQMailApp(String str, String str2) {
        long j2;
        AppMethodBeat.i(122844);
        try {
            URL url = new URL(str);
            URL url2 = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()).toURL();
            g.a aVar = new g.a();
            aVar.alj(url2.toString());
            aVar.all("qqmail.apk");
            aVar.setFileMD5(str2);
            aVar.kS(true);
            aVar.Fl(1);
            j2 = com.tencent.mm.plugin.downloader.model.f.cBv().a(aVar.qIY);
        } catch (Exception e2) {
            Log.e("MicroMsg.ReadMailProxy", "dz[download qq mail error:%s]", e2.toString());
            Log.printErrStackTrace("MicroMsg.ReadMailProxy", e2, "", new Object[0]);
            j2 = -1;
        }
        AppMethodBeat.o(122844);
        return j2;
    }

    @f
    public int removeDownloadQQMailAppTask(long j2) {
        AppMethodBeat.i(122845);
        int Cn = com.tencent.mm.plugin.downloader.model.f.cBv().Cn(j2);
        AppMethodBeat.o(122845);
        return Cn;
    }

    @f
    public String getBindUin() {
        AppMethodBeat.i(122846);
        String pVar = new p(Util.nullAsNil((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(9, (Object) null))).toString();
        AppMethodBeat.o(122846);
        return pVar;
    }

    @f
    public Integer showMailAppRecommend() {
        AppMethodBeat.i(122847);
        if (ChannelUtil.channelId == 1) {
            AppMethodBeat.o(122847);
            return 0;
        }
        Integer valueOf = Integer.valueOf(h.aqK().aqB());
        AppMethodBeat.o(122847);
        return valueOf;
    }

    @f
    public String getMailAppEnterUlAndroid() {
        AppMethodBeat.i(122848);
        String mailAppEnterUlAndroid = h.aqK().getMailAppEnterUlAndroid();
        AppMethodBeat.o(122848);
        return mailAppEnterUlAndroid;
    }

    @f
    public String getMailAppRedirectUrlAndroid() {
        AppMethodBeat.i(122849);
        String aqC = h.aqK().aqC();
        AppMethodBeat.o(122849);
        return aqC;
    }

    @f
    public Integer getMailAppDownloadStatus(long j2) {
        AppMethodBeat.i(122850);
        Integer valueOf = Integer.valueOf(com.tencent.mm.plugin.downloader.model.f.cBv().Co(j2).status);
        AppMethodBeat.o(122850);
        return valueOf;
    }

    @f
    public double getMailAppDownloadProgress(long j2) {
        AppMethodBeat.i(122851);
        FileDownloadTaskInfo Co = com.tencent.mm.plugin.downloader.model.f.cBv().Co(j2);
        if (Co.oJj <= 0) {
            AppMethodBeat.o(122851);
            return 0.0d;
        }
        double d2 = (1.0d * ((double) Co.qJe)) / ((double) Co.oJj);
        AppMethodBeat.o(122851);
        return d2;
    }

    @f
    public void reportKvState(int i2, int i3) {
        AppMethodBeat.i(122852);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(i2, Integer.valueOf(i3));
        AppMethodBeat.o(122852);
    }

    @f
    public void reportKvStates(int i2, int i3, int i4) {
        AppMethodBeat.i(122853);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(i2, Integer.valueOf(i3), Integer.valueOf(i4));
        AppMethodBeat.o(122853);
    }

    @f
    public void getUnreadMailCount() {
        AppMethodBeat.i(122854);
        o.a(this.BtC);
        AppMethodBeat.o(122854);
    }

    @f
    public Object getUneradMailCountFromConfig() {
        AppMethodBeat.i(122855);
        Object obj = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_QQMAIL_UNREAD_COUNT_INT, (Object) -1);
        AppMethodBeat.o(122855);
        return obj;
    }
}
