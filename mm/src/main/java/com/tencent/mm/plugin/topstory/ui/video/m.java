package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.protocal.protobuf.eix;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.tav.coremedia.TimeUtil;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class m {
    private int Fdo = 0;
    b GlS;
    Map<String, eix> GnA = Collections.synchronizedMap(new HashMap());
    Set<String> GnB = Collections.synchronizedSet(new HashSet());
    String Gnz;

    public m() {
        AppMethodBeat.i(126116);
        AppMethodBeat.o(126116);
    }

    public final void d(b bVar) {
        AppMethodBeat.i(126117);
        this.Fdo++;
        Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "onUICreate %d", Integer.valueOf(this.Fdo));
        this.GlS = bVar;
        this.Gnz = h.aTv(bVar.fyD().sGQ);
        AppMethodBeat.o(126117);
    }

    public final void onUIDestroy() {
        AppMethodBeat.i(126118);
        this.Fdo--;
        Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "onUIDestroy %d", Integer.valueOf(this.Fdo));
        if (this.Fdo <= 0) {
            fzx();
            this.GnB.clear();
            ThreadPool.post(new b(this.Gnz), "TopStory.DeleteVideoFolderTask");
            this.GlS = null;
        }
        AppMethodBeat.o(126118);
    }

    class a implements Runnable {
        private String xnX;

        a(String str) {
            this.xnX = str;
        }

        public final void run() {
            String str;
            eiw eiw;
            AppMethodBeat.i(126112);
            o oVar = new o(this.xnX);
            if (oVar.exists()) {
                o[] het = oVar.het();
                Object[] objArr = new Object[4];
                objArr[0] = Integer.valueOf(m.this.GnB.size());
                objArr[1] = Integer.valueOf(m.this.GnA.size());
                objArr[2] = Integer.valueOf(het != null ? het.length : 0);
                objArr[3] = this.xnX;
                Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "DeleteVideoCacheTask preloadSize: %d cacheSize: %d folderSize: %d folderPath: %s", objArr);
                if (het != null && het.length > 10) {
                    ArrayList arrayList = new ArrayList(het.length);
                    for (o oVar2 : het) {
                        arrayList.add(oVar2);
                    }
                    Collections.sort(arrayList, new Comparator<o>() {
                        /* class com.tencent.mm.plugin.topstory.ui.video.m.a.AnonymousClass1 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                        @Override // java.util.Comparator
                        public final /* synthetic */ int compare(o oVar, o oVar2) {
                            AppMethodBeat.i(126111);
                            int compare = Long.compare(oVar2.lastModified(), oVar.lastModified());
                            AppMethodBeat.o(126111);
                            return compare;
                        }
                    });
                    Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "First: %s Last: %s", f.formatTime(TimeUtil.YYYY2MM2DD_HH1MM1SS, ((o) arrayList.get(0)).lastModified() / 1000), f.formatTime(TimeUtil.YYYY2MM2DD_HH1MM1SS, ((o) arrayList.get(arrayList.size() - 1)).lastModified() / 1000));
                    List<o> subList = arrayList.subList(10, arrayList.size());
                    if (m.this.GlS == null || (eiw = m.this.GlS.fyF().GjK) == null) {
                        str = "";
                    } else {
                        str = com.tencent.mm.plugin.topstory.ui.c.bu(eiw.psI, eiw.Nip);
                    }
                    for (o oVar3 : subList) {
                        String str2 = oVar3.getName().split("\\.")[0];
                        if (!str2.equals(str) && !m.this.GnB.contains(str2)) {
                            Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "Delete cache video %s %s", oVar3.getName(), f.formatTime(TimeUtil.YYYY2MM2DD_HH1MM1SS, oVar3.lastModified() / 1000));
                            m.this.GnA.remove(str2);
                            oVar3.delete();
                        }
                    }
                }
                AppMethodBeat.o(126112);
                return;
            }
            Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "DeleteVideoCacheTask folder %s not exist", this.xnX);
            AppMethodBeat.o(126112);
        }
    }

    class b implements Runnable {
        private String xnX;

        b(String str) {
            this.xnX = str;
        }

        public final void run() {
            AppMethodBeat.i(126113);
            long currentTimeMillis = System.currentTimeMillis();
            s.dy(this.xnX, true);
            Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "DeleteVideoFolderTask %s %d", this.xnX, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(126113);
        }
    }

    public final void fzx() {
        AppMethodBeat.i(126119);
        for (String str : this.GnB) {
            com.tencent.mm.an.f.baQ().Oc(str);
        }
        AppMethodBeat.o(126119);
    }

    static long au(long j2, long j3) {
        if (j3 != 0) {
            return (100 * j2) / j3;
        }
        return 0;
    }

    class d implements g.a {
        private d() {
        }

        /* synthetic */ d(m mVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
            AppMethodBeat.i(126115);
            if (cVar != null && cVar.field_toltalLength > 0 && m.this.GnA.containsKey(str)) {
                eix eix = m.this.GnA.get(str);
                eix.NiK = cVar.field_finishedLength;
                eix.NiL = m.au(cVar.field_finishedLength, cVar.field_toltalLength);
                eix.Niv = cVar.field_toltalLength;
                m.this.GnA.put(str, eix);
            }
            AppMethodBeat.o(126115);
            return 0;
        }

        @Override // com.tencent.mm.i.g.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        @Override // com.tencent.mm.i.g.a
        public final byte[] f(String str, byte[] bArr) {
            return new byte[0];
        }
    }

    class c implements g.b {
        private c() {
        }

        /* synthetic */ c(m mVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.i.g.b
        public final void b(String str, com.tencent.mm.i.d dVar) {
            AppMethodBeat.i(126114);
            if (m.this.GnA.containsKey(str)) {
                eix eix = m.this.GnA.get(str);
                eix.NiK = dVar.field_recvedBytes;
                eix.NiL = m.au(eix.NiK, (long) ((int) dVar.field_fileLength));
                eix.Niv = (long) ((int) dVar.field_fileLength);
                m.this.GnA.put(str, eix);
                Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "VideoPreloadCallback onFinish %s %d %s", str, Long.valueOf(eix.NiL), Util.getSizeMB(eix.NiK, 100.0d));
            }
            AppMethodBeat.o(126114);
        }
    }
}
