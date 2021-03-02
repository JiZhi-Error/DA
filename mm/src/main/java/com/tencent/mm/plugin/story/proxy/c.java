package com.tencent.mm.plugin.story.proxy;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.story.f.g.d;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.proxy.StoryCaptureProxy;
import com.tencent.mm.plugin.story.proxy.a;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.protocal.protobuf.dlg;
import com.tencent.mm.protocal.protobuf.eds;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;

public final class c implements a {
    private static final c Ftu = new c();
    public static final a Ftv = new a((byte) 0);
    private static final String TAG = TAG;

    public static VideoTransPara getVideoPara() {
        AppMethodBeat.i(119380);
        if (MMApplicationContext.isMMProcess()) {
            e baZ = e.baZ();
            p.g(baZ, "SubCoreVideoControl.getCore()");
            VideoTransPara bbd = baZ.bbd();
            p.g(bbd, "SubCoreVideoControl.getCore().storyRecordVideoPara");
            AppMethodBeat.o(119380);
            return bbd;
        }
        StoryCaptureProxy.a aVar = StoryCaptureProxy.FsY;
        VideoTransPara videoPara = StoryCaptureProxy.a.fpI().getVideoPara();
        AppMethodBeat.o(119380);
        return videoPara;
    }

    @Override // com.tencent.mm.plugin.story.proxy.a
    public final int commitStory(String str, String str2, String str3, dlg dlg, boolean z, eds eds, int i2, int i3, List<String> list, List<String> list2, List<String> list3) {
        AppMethodBeat.i(222917);
        p.h(str, "videoPath");
        p.h(str2, "thumbPath");
        p.h(str3, "mediaDes");
        p.h(dlg, FirebaseAnalytics.b.LOCATION);
        p.h(eds, "editorInfo");
        p.h(list, "groupList");
        p.h(list2, "blackList");
        p.h(list3, "srcMd5List");
        if (MMApplicationContext.isMMProcess()) {
            String md5 = g.getMD5(str);
            d dVar = new d();
            cly cly = new cly();
            StoryCaptureProxy.a aVar = StoryCaptureProxy.FsY;
            Log.i(StoryCaptureProxy.TAG, "videoPath:" + str + " thumbPath:" + str2 + " mediaDes:" + str3 + " videoMd5:" + md5 + " isCaptureVideo:" + z + " scope:" + i2);
            cly.Mrn = z;
            p.g(md5, "md5");
            dVar.aV(str, str2, md5);
            dVar.b(dlg);
            dVar.a(eds);
            dVar.a(cly);
            dVar.aaJ(i2);
            dVar.hs(list);
            dVar.ht(list2);
            dVar.hu(list3);
            int commit = dVar.commit();
            j.b bVar = j.Fmy;
            j.b.foi().checkPost();
            AppMethodBeat.o(222917);
            return commit;
        }
        StoryCaptureProxy.a aVar2 = StoryCaptureProxy.FsY;
        int a2 = a.C1769a.a(StoryCaptureProxy.a.fpI(), str, str2, str3, dlg, z, eds, i2, list, list2, null, 1152);
        AppMethodBeat.o(222917);
        return a2;
    }

    @Override // com.tencent.mm.plugin.story.proxy.a
    public final int commitStory(String str, String str2, dlg dlg, acg acg, eds eds, int i2, List<String> list, List<String> list2, List<String> list3) {
        AppMethodBeat.i(222918);
        p.h(str, "taskId");
        p.h(str2, "thumbPath");
        p.h(dlg, FirebaseAnalytics.b.LOCATION);
        p.h(acg, "captureInfo");
        p.h(eds, "editorInfo");
        p.h(list, "groupList");
        p.h(list2, "blackList");
        p.h(list3, "srcMd5List");
        if (MMApplicationContext.isMMProcess()) {
            d dVar = new d();
            cly cly = new cly();
            StoryCaptureProxy.a aVar = StoryCaptureProxy.FsY;
            Log.i(StoryCaptureProxy.TAG, "storyEditorData " + str + " isCaptureVideo:" + acg.iqf + " scope:" + i2);
            cly.Mrn = acg.iqf;
            dVar.kZ(str, str2);
            dVar.a(eds);
            dVar.b(dlg);
            dVar.a(cly);
            dVar.aaJ(i2);
            dVar.hs(list);
            dVar.ht(list2);
            dVar.hu(list3);
            dVar.vO(acg.BMX);
            int commit = dVar.commit();
            j.b bVar = j.Fmy;
            j.b.foi().checkPost();
            AppMethodBeat.o(222918);
            return commit;
        }
        StoryCaptureProxy.a aVar2 = StoryCaptureProxy.FsY;
        int commitStory = StoryCaptureProxy.a.fpI().commitStory(str, str2, dlg, acg, eds, i2, list, list2, new ArrayList());
        AppMethodBeat.o(222918);
        return commitStory;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(119383);
        AppMethodBeat.o(119383);
    }
}
