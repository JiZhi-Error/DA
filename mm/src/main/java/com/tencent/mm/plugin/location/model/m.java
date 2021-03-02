package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.h;
import com.tencent.mm.pluginsdk.location.c;
import com.tencent.mm.pluginsdk.location.d;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class m implements i {
    public static final String URL = (HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e2d) + "/api?size=%d*%d&center=%f,%f&zoom=%d&referer=weixin");
    private List<c> callbacks = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    int f1506h = 300;
    private QueueWorkerThread iVg = new QueueWorkerThread(1, "location_worker");
    int w = 300;
    LinkedList<d> yGc = new LinkedList<>();
    d yGd = null;

    static /* synthetic */ void a(m mVar, boolean z) {
        AppMethodBeat.i(55724);
        mVar.qG(z);
        AppMethodBeat.o(55724);
    }

    static {
        AppMethodBeat.i(201731);
        AppMethodBeat.o(201731);
    }

    public final void a(c cVar) {
        AppMethodBeat.i(55715);
        for (c cVar2 : this.callbacks) {
            if (cVar.equals(cVar2)) {
                AppMethodBeat.o(55715);
                return;
            }
        }
        this.callbacks.add(cVar);
        Log.i("MicroMsg.StaticMapServer", "addMapCallBack " + this.callbacks.size());
        if (this.callbacks.size() == 1) {
            start();
        }
        AppMethodBeat.o(55715);
    }

    public final void b(c cVar) {
        AppMethodBeat.i(55716);
        this.callbacks.remove(cVar);
        Log.i("MicroMsg.StaticMapServer", "removeCallback " + this.callbacks.size());
        if (this.callbacks.size() == 0) {
            Log.i("MicroMsg.StaticMapServer", "clean task");
            this.yGc.clear();
            this.yGd = null;
            stop();
        }
        AppMethodBeat.o(55716);
    }

    public m() {
        AppMethodBeat.i(55717);
        start();
        AppMethodBeat.o(55717);
    }

    private void start() {
        AppMethodBeat.i(55718);
        g.azz().a(com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.a.CTRL_INDEX, this);
        AppMethodBeat.o(55718);
    }

    public final void stop() {
        AppMethodBeat.i(55719);
        Log.i("MicroMsg.StaticMapServer", "stop static map server");
        g.azz().b(com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.a.CTRL_INDEX, this);
        AppMethodBeat.o(55719);
    }

    /* access modifiers changed from: package-private */
    public final void bbY() {
        int i2;
        AppMethodBeat.i(55720);
        if (this.yGd == null && this.yGc.size() > 0) {
            this.yGd = this.yGc.removeFirst();
            try {
                i2 = Integer.valueOf(Util.nullAs(h.aqJ().getValue("StaticMapGetClient"), "")).intValue();
            } catch (Exception e2) {
                i2 = 0;
            }
            Log.i("MicroMsg.StaticMapServer", "run local %d", Integer.valueOf(i2));
            if (i2 == 0) {
                g.azz().a(new h(this.yGd.iUY, this.yGd.iUZ, this.yGd.dRt + 1, this.w, this.f1506h, b(this.yGd), LocaleUtil.getApplicationLanguage()), 0);
                AppMethodBeat.o(55720);
                return;
            }
            int i3 = this.w;
            int i4 = this.f1506h;
            while (i3 * i4 > 270000) {
                i3 = (int) (((double) i3) / 1.2d);
                i4 = (int) (((double) i4) / 1.2d);
            }
            if (Util.isOverseasUser(MMApplicationContext.getContext())) {
                this.iVg.add(new a(true, String.format("https://maps.googleapis.com/maps/api/staticmap?size=%dx%d&center=%f,%f&zoom=%d&format=jpg&language=%s&sensor=true", Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(this.yGd.iUY), Float.valueOf(this.yGd.iUZ), Integer.valueOf(this.yGd.dRt), LocaleUtil.getApplicationLanguage()), b(this.yGd)));
                AppMethodBeat.o(55720);
                return;
            }
            this.iVg.add(new a(false, String.format(URL, Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(this.yGd.iUZ), Float.valueOf(this.yGd.iUY), Integer.valueOf(this.yGd.dRt)), b(this.yGd)));
        }
        AppMethodBeat.o(55720);
    }

    public class a implements QueueWorkerThread.ThreadObject {
        private byte[] data;
        private String mFilePath;
        String url = "";
        boolean yGe = true;
        private int yGf;
        private int yGg;

        public a(boolean z, String str, String str2) {
            AppMethodBeat.i(55712);
            this.yGe = z;
            this.yGf = m.this.w;
            this.yGg = m.this.f1506h;
            this.url = str;
            while (this.yGf * this.yGg > 270000) {
                this.yGf = (int) (((double) this.yGf) / 1.2d);
                this.yGg = (int) (((double) this.yGg) / 1.2d);
            }
            this.mFilePath = str2;
            Log.i("MicroMsg.StaticMapServer", "get url %s %s", str, Util.nullAs(this.mFilePath, ""));
            AppMethodBeat.o(55712);
        }

        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        public final boolean doInBackground() {
            AppMethodBeat.i(55713);
            this.data = Util.httpGet(this.url);
            if (this.data != null) {
                s.f(this.mFilePath, this.data, this.data.length);
            }
            AppMethodBeat.o(55713);
            return true;
        }

        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        public final boolean onPostExecute() {
            AppMethodBeat.i(55714);
            Log.i("MicroMsg.StaticMapServer", "http onPostExecute " + (this.data == null) + " isGoole: " + this.yGe);
            if (this.data != null) {
                m.a(m.this, true);
                AppMethodBeat.o(55714);
            } else if (!this.yGe) {
                m.a(m.this, false);
                AppMethodBeat.o(55714);
            } else if (m.this.yGd == null) {
                m.a(m.this, false);
                AppMethodBeat.o(55714);
            } else {
                this.url = String.format(m.URL, Integer.valueOf(this.yGf), Integer.valueOf(this.yGg), Float.valueOf(m.this.yGd.iUZ), Float.valueOf(m.this.yGd.iUY), Integer.valueOf(m.this.yGd.dRt));
                m.this.iVg.add(new a(false, this.url, m.b(m.this.yGd)));
                AppMethodBeat.o(55714);
            }
            return false;
        }
    }

    public static String b(d dVar) {
        AppMethodBeat.i(55721);
        String messageDigest = com.tencent.mm.b.g.getMessageDigest((dVar.toString()).getBytes());
        String str = com.tencent.mm.plugin.image.d.aSZ() + messageDigest.charAt(0) + messageDigest.charAt(1) + FilePathGenerator.ANDROID_DIR_SEP + messageDigest.charAt(3) + messageDigest.charAt(4) + FilePathGenerator.ANDROID_DIR_SEP;
        if (!s.YS(str)) {
            new o(str).mkdirs();
        }
        String str2 = str + "static_map_" + messageDigest;
        AppMethodBeat.o(55721);
        return str2;
    }

    private void qG(boolean z) {
        AppMethodBeat.i(55722);
        Log.i("MicroMsg.StaticMapServer", "httpgetStaticmapDone %b", Boolean.valueOf(z));
        if (z) {
            if (this.yGd != null) {
                for (c cVar : this.callbacks) {
                    if (cVar != null) {
                        cVar.a(b(this.yGd), this.yGd);
                    }
                }
            }
        } else if (this.yGd != null) {
            for (c cVar2 : this.callbacks) {
                if (cVar2 != null) {
                    cVar2.a(this.yGd);
                }
            }
        }
        this.yGd = null;
        bbY();
        AppMethodBeat.o(55722);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(55723);
        if (qVar.getType() == 648) {
            if (i2 == 0 && i3 == 0 && this.yGd != null) {
                qG(true);
                AppMethodBeat.o(55723);
                return;
            }
            qG(false);
        }
        AppMethodBeat.o(55723);
    }
}
