package com.tencent.mm.plugin.topstory;

import android.os.Message;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.topstory.a.b.b;
import com.tencent.mm.plugin.topstory.a.f;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c implements f {
    MMHandler Eyp = new MMHandler("TopStoryReportExposeTask") {
        /* class com.tencent.mm.plugin.topstory.c.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(88458);
            switch (message.what) {
                case 0:
                    ((a) message.obj).run();
                    break;
            }
            AppMethodBeat.o(88458);
        }
    };
    Map<Long, a> GiU = new ConcurrentHashMap();

    public c() {
        AppMethodBeat.i(88463);
        AppMethodBeat.o(88463);
    }

    class a implements Runnable {
        HashSet<com.tencent.mm.plugin.topstory.a.b.c> GiW;
        eit GiX;
        long createTime;

        private a() {
            AppMethodBeat.i(88460);
            this.GiW = new HashSet<>();
            AppMethodBeat.o(88460);
        }

        /* synthetic */ a(c cVar, byte b2) {
            this();
        }

        public final void run() {
            List subList;
            AppMethodBeat.i(88461);
            Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "Star to run ReportExposeTask");
            c.this.GiU.remove(Long.valueOf(this.GiX.Nib));
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.GiW);
            int i2 = 0;
            while (true) {
                int i3 = i2 + 20;
                if (i3 >= arrayList.size()) {
                    subList = arrayList.subList(i2, arrayList.size());
                } else {
                    subList = arrayList.subList(i2, i3);
                }
                String a2 = a(subList, this.GiX);
                if (!Util.isNullOrNil(a2)) {
                    final doc doc = new doc();
                    doc.MRe = a2;
                    Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "build14057VideoInfoExposeString %d report string: %s", Integer.valueOf(subList.size()), doc.MRe);
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.topstory.c.a.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(88459);
                            g.azz().a(new y(doc), 0);
                            AppMethodBeat.o(88459);
                        }
                    });
                }
                if (i3 >= arrayList.size()) {
                    AppMethodBeat.o(88461);
                    return;
                }
                i2 = i3;
            }
        }

        private static String a(List<com.tencent.mm.plugin.topstory.a.b.c> list, eit eit) {
            AppMethodBeat.i(88462);
            try {
                if (list.size() == 0) {
                    AppMethodBeat.o(88462);
                    return null;
                }
                StringBuilder sb = new StringBuilder("");
                sb.append("isexpose=1&content=");
                StringBuilder sb2 = new StringBuilder("");
                for (com.tencent.mm.plugin.topstory.a.b.c cVar : list) {
                    eiw eiw = cVar.GjH;
                    sb2.append(eiw.dDw);
                    sb2.append(":");
                    sb2.append(eiw.wWb);
                    sb2.append(":");
                    sb2.append(cVar.xeh);
                    sb2.append(":");
                    sb2.append(eiw.Nir);
                    sb2.append(";");
                }
                try {
                    sb.append(q.encode(sb2.toString(), ProtocolPackage.ServerEncoding));
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", e2, "", new Object[0]);
                }
                sb.append("&resulttype=");
                for (com.tencent.mm.plugin.topstory.a.b.c cVar2 : list) {
                    eiw eiw2 = cVar2.GjH;
                    sb.append(eiw2.dDw);
                    sb.append(":");
                    sb.append(eiw2.Niu);
                    sb.append(";");
                }
                sb.append("&expand=");
                StringBuilder sb3 = new StringBuilder("");
                for (com.tencent.mm.plugin.topstory.a.b.c cVar3 : list) {
                    eiw eiw3 = cVar3.GjH;
                    sb3.append(eiw3.dDw);
                    sb3.append(":");
                    sb3.append(eiw3.Nit);
                    sb3.append(";");
                }
                try {
                    sb.append(q.encode(sb3.toString(), ProtocolPackage.ServerEncoding));
                } catch (UnsupportedEncodingException e3) {
                    Log.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", e3, "", new Object[0]);
                }
                sb.append("&itemtype=");
                StringBuilder sb4 = new StringBuilder("");
                for (com.tencent.mm.plugin.topstory.a.b.c cVar4 : list) {
                    sb4.append(cVar4.GjH.Nis);
                    sb4.append(";");
                }
                sb.append((CharSequence) sb4);
                if (eit != null) {
                    sb.append("&");
                    sb.append("searchid=");
                    sb.append(eit.hes);
                    sb.append("&");
                    sb.append("query=");
                    try {
                        sb.append(q.encode(eit.dDv, ProtocolPackage.ServerEncoding));
                    } catch (Exception e4) {
                        Log.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", e4, "", new Object[0]);
                    }
                    sb.append("&");
                    sb.append("ishomepage=0");
                    sb.append("&");
                    sb.append("sessionid=");
                    sb.append(ai.afq(eit.scene));
                    sb.append("&");
                    sb.append("scene=");
                    sb.append(eit.scene);
                    sb.append("&rec_category=");
                    sb.append(eit.Nib);
                }
                String sb5 = sb.toString();
                AppMethodBeat.o(88462);
                return sb5;
            } catch (Exception e5) {
                Log.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", e5, "build14057VideoInfoExposeString error: %s", e5.getMessage());
                AppMethodBeat.o(88462);
                return null;
            }
        }
    }

    @Override // com.tencent.mm.plugin.topstory.a.f
    public final void a(eit eit, HashSet<com.tencent.mm.plugin.topstory.a.b.c> hashSet) {
        AppMethodBeat.i(88464);
        if (hashSet.size() == 0) {
            AppMethodBeat.o(88464);
            return;
        }
        a aVar = this.GiU.get(Long.valueOf(eit.Nib));
        if (aVar == null || !this.Eyp.hasMessages(0)) {
            if (aVar != null) {
                Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo not report task: %s size: %d", aVar, Integer.valueOf(aVar.GiW.size()));
            }
            a aVar2 = new a(this, (byte) 0);
            Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo new task %d %s", Integer.valueOf(hashSet.size()), aVar2);
            aVar2.createTime = System.currentTimeMillis();
            Iterator<com.tencent.mm.plugin.topstory.a.b.c> it = hashSet.iterator();
            while (it.hasNext()) {
                aVar2.GiW.add(it.next());
            }
            aVar2.GiX = eit;
            if (aVar2.GiW.size() > 0) {
                this.Eyp.removeMessages(0);
                this.Eyp.sendMessageDelayed(this.Eyp.obtainMessage(0, aVar2), 5000);
                this.GiU.put(Long.valueOf(eit.Nib), aVar2);
            }
            AppMethodBeat.o(88464);
            return;
        }
        Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo hit cached task %d add %d", Integer.valueOf(aVar.GiW.size()), Integer.valueOf(hashSet.size()));
        Iterator<com.tencent.mm.plugin.topstory.a.b.c> it2 = hashSet.iterator();
        while (it2.hasNext()) {
            aVar.GiW.add(it2.next());
        }
        AppMethodBeat.o(88464);
    }

    public static void a(eit eit, eiw eiw, b bVar) {
        int i2;
        AppMethodBeat.i(88465);
        Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "stopVideoPlay: %s %s", eiw, bVar);
        if (!(eiw == null || bVar == null)) {
            bVar.Gjn = System.currentTimeMillis();
            bVar.Gjo = bVar.Gjn - bVar.Gjm;
            String b2 = b(eit, eiw, bVar);
            if (!Util.isNullOrNil(b2)) {
                doc doc = new doc();
                doc.MRe = b2;
                Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "build14436VideoPlayReportString %s", doc.MRe);
                g.azz().a(new y(doc), 0);
            }
            if (bVar.GjF != null) {
                i2 = bVar.GjF.videoBitrate;
            } else {
                i2 = 0;
            }
            String format = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", Integer.valueOf(eit.scene), eiw.psI, Long.valueOf(eiw.Niv), "mp4", Integer.valueOf(eiw.Eso), Integer.valueOf(i2), Long.valueOf(bVar.Gjm), Long.valueOf(bVar.Gjn), Long.valueOf(bVar.Gjp), Long.valueOf(bVar.Gjo), Long.valueOf(bVar.Gjr), Long.valueOf(bVar.Gjs), Long.valueOf(bVar.Gjt), Long.valueOf(bVar.Gju), Long.valueOf(bVar.Gjx), Long.valueOf(bVar.Gjy), Long.valueOf(bVar.Gjq), Long.valueOf(bVar.Gjz), Long.valueOf(bVar.GjA), Long.valueOf(bVar.GjC), Long.valueOf(bVar.GjD), bVar.iAh, Long.valueOf(bVar.position), ai.ait(), Long.valueOf(bVar.GjB), Long.valueOf(bVar.GjE), Long.valueOf(bVar.Gjv), Long.valueOf(bVar.Gjw), eit.sGQ);
            Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "stopVideoPlay 15414 %s", format);
            e.INSTANCE.kvStat(15414, format);
            com.tencent.mm.plugin.topstory.a.a.a.a(bVar);
        }
        AppMethodBeat.o(88465);
    }

    @Override // com.tencent.mm.plugin.topstory.a.f
    public final void a(eit eit, eiw eiw, int i2, int i3, String str) {
        AppMethodBeat.i(88466);
        String b2 = b(eit, eiw, i2, i3, str);
        if (!Util.isNullOrNil(b2)) {
            doc doc = new doc();
            doc.MRe = b2;
            Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "do12721ClickVideoReport %s", doc.MRe);
            g.azz().a(new y(doc), 0);
        }
        AppMethodBeat.o(88466);
    }

    private static String b(eit eit, eiw eiw, int i2, int i3, String str) {
        AppMethodBeat.i(88467);
        StringBuilder sb = new StringBuilder("");
        try {
            sb.append("scene=");
            sb.append(eit.scene);
            sb.append("&");
            sb.append("businesstype=3");
            sb.append("&");
            sb.append("mediatype=2");
            sb.append("&");
            sb.append("docid=");
            sb.append(eiw.wWb);
            sb.append("&");
            sb.append("typepos=");
            sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            sb.append("&");
            sb.append("docpos=");
            sb.append(i2 + 1);
            sb.append("&");
            sb.append("searchid=");
            sb.append(eit.hes);
            sb.append("&");
            sb.append("ishomepage=");
            sb.append(0);
            sb.append("&rec_category=");
            sb.append(eiw.Nip);
            sb.append("&");
            sb.append("timestamp=");
            sb.append(System.currentTimeMillis());
            sb.append("&");
            sb.append("clicktype=");
            sb.append(i3);
            sb.append("&");
            sb.append("clickcontent=");
            try {
                sb.append(q.encode(str, ProtocolPackage.ServerEncoding));
            } catch (Exception e2) {
            }
            sb.append("&");
            sb.append("clicksource=");
            sb.append("4");
            sb.append("&");
            sb.append("sceneactiontype=");
            sb.append(1);
            sb.append("&");
            sb.append("query=");
            try {
                sb.append(q.encode(eit.dDv, ProtocolPackage.ServerEncoding));
            } catch (Exception e3) {
            }
            sb.append("&");
            sb.append("resulttype=");
            sb.append(eiw.Niu);
            sb.append("&");
            sb.append("sessionid=");
            sb.append(ai.afq(eit.scene));
            sb.append("&");
            sb.append("expand=");
            try {
                sb.append(q.encode(eiw.Nir, ProtocolPackage.ServerEncoding));
            } catch (Exception e4) {
            }
            sb.append("&");
            sb.append("title=");
            try {
                sb.append(q.encode(eiw.title, ProtocolPackage.ServerEncoding));
            } catch (Exception e5) {
            }
            sb.append("&");
            sb.append("nettype=");
            if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                sb.append("wifi");
            } else if (NetStatusUtil.is4G(MMApplicationContext.getContext())) {
                sb.append("4g");
            } else {
                sb.append("3g");
            }
            sb.append("&");
            sb.append("itemtype=");
            sb.append(eiw.Nis);
        } catch (Exception e6) {
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(88467);
        return sb2;
    }

    private static String b(eit eit, eiw eiw, b bVar) {
        AppMethodBeat.i(88468);
        StringBuilder sb = new StringBuilder("");
        sb.append("ismediaplay=1");
        sb.append("&searchid=");
        sb.append(eit.hes);
        sb.append("&scene=");
        sb.append(eit.scene);
        sb.append("&businesstype=3");
        sb.append("&mediatype=2");
        sb.append("&rec_category=");
        sb.append(eit.Nib);
        sb.append("&docid=");
        sb.append(eiw.wWb);
        sb.append("&cdnsourcetype=");
        sb.append(eiw.NiB);
        try {
            sb.append("&expand1=").append(q.encode(eiw.Nir, ProtocolPackage.ServerEncoding));
        } catch (Exception e2) {
        }
        sb.append("&query=");
        try {
            sb.append(q.encode(eit.dDv, ProtocolPackage.ServerEncoding));
        } catch (Exception e3) {
        }
        sb.append("&title=");
        try {
            sb.append(q.encode(eiw.title, ProtocolPackage.ServerEncoding));
        } catch (Exception e4) {
        }
        sb.append("&duration=");
        sb.append(eiw.Eso * 1000);
        sb.append("&mediaid=");
        sb.append(eiw.psI);
        if (bVar != null) {
            sb.append("&startplaytime=");
            sb.append(bVar.Gjm);
            sb.append("&endplaytime=");
            sb.append(bVar.Gjn);
            sb.append("&playtime=");
            sb.append(bVar.Gjo);
            sb.append("&lastplayms=");
            sb.append(bVar.Gjp);
            sb.append("&autoplay=");
            sb.append(bVar.Gjt);
            sb.append("&hasplayended=");
            sb.append(bVar.Gjq);
            sb.append("&hasquickplay=");
            sb.append(bVar.Gjr);
            sb.append("&hasfullscreen=");
            sb.append(bVar.Gjs);
            sb.append("&hitpreload=");
            sb.append(bVar.Gju);
            sb.append("&firstloadtime=");
            sb.append(bVar.Gjx);
            sb.append("&downloadfinishtime=");
            sb.append(bVar.Gjy);
            sb.append("&firstmoovreadytime=");
            sb.append(bVar.Gjz);
            sb.append("&firstdataavailabletime=");
            sb.append(bVar.GjC);
            sb.append("&filesize=");
            sb.append(bVar.GjG);
            if (bVar.GjF != null) {
                sb.append("&bitrate=");
                sb.append(bVar.GjF.videoBitrate);
                sb.append("&audiobitrate=");
                sb.append(bVar.GjF.audioBitrate);
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(88468);
        return sb2;
    }
}
