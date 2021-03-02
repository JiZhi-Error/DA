package com.tencent.mm.plugin.vlog.model.report;

import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.os.Debug;
import android.os.Process;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ge;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.q;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.report.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.o;
import com.tencent.mm.videocomposition.c;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017J\u0014\u0010\u0018\u001a\u00020\u00102\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aJ\u000e\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0014J\u000e\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/report/VideoEditResultReport;", "", "()V", "reportJson", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson;", "getReportJson", "()Lcom/tencent/mm/plugin/vlog/model/report/ReportJson;", "setReportJson", "(Lcom/tencent/mm/plugin/vlog/model/report/ReportJson;)V", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/MultiMediaEditResultStruct;", "getStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/MultiMediaEditResultStruct;", "setStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/MultiMediaEditResultStruct;)V", "fillReportMem", "", "report", "setAction", NativeProtocol.WEB_DIALOG_ACTION, "", "setComposition", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "setEditItem", "itemList", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "setSourceType", "source", "setTemplateId", "templateId", "", "setTemplateResourceReady", "ready", "", "Companion", "plugin-vlog_release"})
public final class d {
    public static final a GBk = new a((byte) 0);
    public ge GBi = new ge();
    private c GBj = new c();

    static {
        AppMethodBeat.i(190833);
        AppMethodBeat.o(190833);
    }

    public d() {
        AppMethodBeat.i(190832);
        AppMethodBeat.o(190832);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/report/VideoEditResultReport$Companion;", "", "()V", "ACTION_EXIT", "", "ACTION_NEXT", "SOURCE_MUSIC_FOLLOW", "SOURCE_OTHER", "SOURCE_TEMPLATE_FOLLOW", "SOURCE_TEMPLATE_POST", "TAG", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void b(ac acVar) {
        ArrayList<Long> arrayList;
        ArrayList<Long> arrayList2;
        ArrayList<Integer> arrayList3;
        ArrayList<Integer> arrayList4;
        AppMethodBeat.i(190827);
        p.h(acVar, "composition");
        this.GBj.tGk.clear();
        long j2 = 0;
        long j3 = 0;
        for (T t : acVar.Gzn) {
            c.d dVar = null;
            if (t.type == 2) {
                j2++;
                dVar = new c.f();
                dVar.mwH = t.GzA.mwH;
                MultiMediaVideoChecker.a aTV = MultiMediaVideoChecker.GyY.aTV(t.path);
                if (aTV != null) {
                    dVar.bitrate = aTV.bitrate;
                    dVar.cKu = aTV.cKu;
                    dVar.audioSampleRate = aTV.audioSampleRate;
                    dVar.audioBitrate = aTV.audioBitrate;
                    j3 = j3;
                }
                j3 = j3;
            } else {
                if (t.type == 1) {
                    dVar = new c.d();
                    j3++;
                }
                j3 = j3;
            }
            if (dVar != null) {
                dVar.type = t.type;
            }
            if (!(dVar == null || (arrayList4 = dVar.GBh) == null)) {
                arrayList4.add(Integer.valueOf(t.Gzu));
            }
            if (!(dVar == null || (arrayList3 = dVar.GBh) == null)) {
                arrayList3.add(Integer.valueOf(t.Gzv));
            }
            if (!(dVar == null || (arrayList2 = dVar.GBd) == null)) {
                arrayList2.add(Long.valueOf(t.GzA.startTimeMs));
            }
            if (!(dVar == null || (arrayList = dVar.GBd) == null)) {
                arrayList.add(Long.valueOf(t.GzA.endTimeMs));
            }
            if (dVar != null) {
                this.GBj.tGk.add(dVar);
            }
        }
        this.GBi.ln(1);
        this.GBi.pP(j2);
        this.GBi.pQ(j3);
        this.GBi.pV(acVar.Gzp ? 1 : 0);
        Log.i("MicroMsg.MultiMediaEditReport", "setComposition, isEnableVideoEnhancement:" + acVar.Gzp);
        AppMethodBeat.o(190827);
    }

    public final void hR(List<? extends com.tencent.mm.plugin.recordvideo.ui.editor.item.a> list) {
        c.b aVar;
        String str;
        String str2;
        AppMethodBeat.i(190828);
        p.h(list, "itemList");
        this.GBj.editList.clear();
        for (T t : list) {
            if (t.Cex == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.TEXT) {
                aVar = new c.b();
                c.b bVar = aVar;
                T t2 = !(t instanceof q) ? null : t;
                if (t2 == null || (str2 = t2.CeI) == null) {
                    str2 = "";
                }
                String name = new o(str2).getName();
                p.g(name, "VFSFile((it as? TextItem)?.font ?: \"\").name");
                bVar.setFont(name);
            } else if (t.Cex == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CAPTION) {
                aVar = new c.b();
                c.b bVar2 = aVar;
                T t3 = !(t instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.c) ? null : t;
                if (t3 == null || (str = t3.CeI) == null) {
                    str = "";
                }
                String name2 = new o(str).getName();
                p.g(name2, "VFSFile((it as? CaptionItem)?.font ?: \"\").name");
                bVar2.setFont(name2);
            } else {
                aVar = new c.a();
            }
            aVar.type = t.Cex.value;
            aVar.GBd.add(Long.valueOf(t.Cev.Cgx.getTime()));
            aVar.GBd.add(Long.valueOf(t.Cev.Cgy.getTime()));
            this.GBj.editList.add(aVar);
        }
        this.GBi.pR((long) list.size());
        AppMethodBeat.o(190828);
    }

    public final void KT(long j2) {
        AppMethodBeat.i(190829);
        this.GBi.pT(j2);
        AppMethodBeat.o(190829);
    }

    public final void KU(long j2) {
        AppMethodBeat.i(190830);
        this.GBi.pU(j2);
        AppMethodBeat.o(190830);
    }

    public final void report() {
        AppMethodBeat.i(190831);
        Object systemService = MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.app.ActivityManager");
            AppMethodBeat.o(190831);
            throw tVar;
        }
        Debug.MemoryInfo[] processMemoryInfo = ((ActivityManager) systemService).getProcessMemoryInfo(new int[]{Process.myPid()});
        if ((processMemoryInfo != null ? processMemoryInfo.length : 0) > 0) {
            c.C1850c cVar = this.GBj.GBc;
            Debug.MemoryInfo memoryInfo = processMemoryInfo[0];
            p.g(memoryInfo, "memInfos[0]");
            cVar.GBe = memoryInfo.getTotalPss();
        }
        c.a aVar = com.tencent.mm.videocomposition.c.RgU;
        Map snapshot = com.tencent.mm.videocomposition.c.Asq.snapshot();
        this.GBj.GBc.GBf = snapshot.size();
        c.C1850c cVar2 = this.GBj.GBc;
        int i2 = 0;
        for (Bitmap bitmap : snapshot.values()) {
            p.g(bitmap, LocaleUtil.ITALIAN);
            i2 = bitmap.getAllocationByteCount() + i2;
        }
        cVar2.GBg = i2;
        String jSONObject = this.GBj.toJson().toString();
        p.g(jSONObject, "reportJson.toJson().toString()");
        this.GBi.tI(n.j(jSONObject, ",", ";", false));
        Log.i("MicroMsg.MultiMediaEditReport", "report: " + this.GBi.abW());
        this.GBi.bfK();
        this.GBi = new ge();
        this.GBj = new c();
        AppMethodBeat.o(190831);
    }
}
