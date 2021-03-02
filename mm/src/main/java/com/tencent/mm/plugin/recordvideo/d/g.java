package com.tencent.mm.plugin.recordvideo.d;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.g.b.a.Cif;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\nJ\u000e\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\nJ\u0012\u0010 \u001a\u00020\u00112\n\u0010!\u001a\u00020\"\"\u00020\u0015J\u000e\u0010#\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\nJ\u000e\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\nJ\u000e\u0010)\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\nJ\u000e\u0010*\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u0004J\u000e\u0010-\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\nJ\u000e\u0010.\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010/\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\nJ\u000e\u00100\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u00101\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u0004J\u000e\u00102\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u000203J\u000e\u00104\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u000203J\u000e\u00105\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u000203J\u0010\u00106\u001a\u00020\u00112\b\u00107\u001a\u0004\u0018\u00010\u0004J\u0010\u00108\u001a\u00020\u00112\b\u00107\u001a\u0004\u0018\u00010\u0004J\u000e\u00109\u001a\u00020\u00112\u0006\u0010:\u001a\u000203J\u0016\u0010;\u001a\u00020\u00112\u0006\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020\u0004J\u0018\u0010>\u001a\u00020\u00112\u0010\u0010?\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030A0@J\u000e\u0010B\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010C\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\nJ\u000e\u0010D\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010E\u001a\u00020\u00112\u0006\u0010F\u001a\u000203R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\fj\b\u0012\u0004\u0012\u00020\u0004`\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/report/VideoWidgetReporter;", "", "()V", "TAG", "", "TYPE_FFMPEG4", "TYPE_MEDIACODEC", "TYPE_MP4V2", "TYPE_X264", "initRouterTimeStamp", "", "routeLogList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "videoLogStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/SightVideoLogStruct;", "doReport", "", "getRouteLog", "setABAPramsUseDaemon", "type", "", "setCameraDataJSON", "jsonObject", "Lcom/tencent/mm/json/JSONObject;", "setConfigProvider", "provider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setCropVideoEndTime", "end", "setCropVideoStartTime", "start", "setEditElementList", "editMaterials", "", "setEnterScene", "setExitTypeAndSendType", "exitType", "sendType", "setFinishRecordTimeStamp", "timeStamp", "setInitRouterTimeStamp", "setJumpToThirdApp", "setMixVideoInfo", "videoPath", "setMuxEndTimeStamp", "setMuxResult", "setMuxStartTimeStamp", "setNetType", "setPhotoAlbumVideoInfo", "setRecordCameraRet", "", "setRecordCpuCrop", "setRecordDaemon", "setRecordHighBitrateVideo", "filePath", "setRecordLowBitrateVideo", "setRemuxMuxerType", "isUseFFmpeg", "setRouterLog", "time", "clazzName", "setRouterMap", "routeMap", "Landroid/util/SparseArray;", "Ljava/lang/Class;", "setSNSDoubleCheck", "setStartRecordTimeStamp", "setUseDaemon", "setUseSoftEncode", "isUse", "plugin-recordvideo_release"})
public final class g {
    public static Cif BXV = new Cif();
    public static long BXW;
    public static final ArrayList<String> BXX = new ArrayList<>();
    public static final g BXY = new g();

    static {
        AppMethodBeat.i(237475);
        AppMethodBeat.o(237475);
    }

    private g() {
    }

    public static void VL(int i2) {
        AppMethodBeat.i(237446);
        BXV.lq(i2);
        AppMethodBeat.o(237446);
    }

    public static void VM(int i2) {
        AppMethodBeat.i(237447);
        BXV.lr(i2);
        AppMethodBeat.o(237447);
    }

    public static void g(SparseArray<Class<?>> sparseArray) {
        AppMethodBeat.i(237448);
        p.h(sparseArray, "routeMap");
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            Class<?> valueAt = sparseArray.valueAt(i2);
            p.g(valueAt, "routeMap.valueAt(index)");
            String simpleName = valueAt.getSimpleName();
            p.g(simpleName, "routeMap.valueAt(index).simpleName");
            sb.append(simpleName).append("#");
        }
        sb.append("}");
        BXV.vN(sb.toString());
        AppMethodBeat.o(237448);
    }

    public static void tp(boolean z) {
        AppMethodBeat.i(237449);
        BXV.ls(z ? 0 : 1);
        AppMethodBeat.o(237449);
    }

    public static void tq(boolean z) {
        AppMethodBeat.i(237450);
        BXV.lt(z ? 0 : 1);
        AppMethodBeat.o(237450);
    }

    public static void tr(boolean z) {
        AppMethodBeat.i(237451);
        BXV.lv(z ? 0 : 1);
        AppMethodBeat.o(237451);
    }

    public static void aLx(String str) {
        String str2;
        AppMethodBeat.i(237452);
        a aNx = e.aNx(str);
        Cif ifVar = BXV;
        if (aNx == null || (str2 = aNx.toString()) == null) {
            str2 = "";
        }
        ifVar.vO(str2);
        AppMethodBeat.o(237452);
    }

    public static void aLy(String str) {
        String str2;
        AppMethodBeat.i(237453);
        a aNx = e.aNx(str);
        Cif ifVar = BXV;
        if (aNx == null || (str2 = aNx.toString()) == null) {
            str2 = "";
        }
        ifVar.vP(str2);
        AppMethodBeat.o(237453);
    }

    public static void F(long j2, String str) {
        AppMethodBeat.i(237454);
        p.h(str, "clazzName");
        i iVar = new i();
        iVar.v("time", j2 - BXW);
        iVar.h("clazz", str);
        BXX.add(iVar.toString());
        AppMethodBeat.o(237454);
    }

    public static void J(int... iArr) {
        AppMethodBeat.i(237455);
        p.h(iArr, "editMaterials");
        i iVar = new i();
        iVar.U("emoji", iArr[0]);
        iVar.U("text", iArr[1]);
        iVar.U("music", iArr[2]);
        String iVar2 = iVar.toString();
        p.g(iVar2, "jsonObject.toString()");
        BXV.vS(n.j(iVar2, ",", ";", false));
        AppMethodBeat.o(237455);
    }

    public static void VN(int i2) {
        AppMethodBeat.i(237456);
        BXV.lw(i2);
        AppMethodBeat.o(237456);
    }

    public static void VO(int i2) {
        AppMethodBeat.i(237457);
        BXV.lx(i2);
        AppMethodBeat.o(237457);
    }

    public static void VP(int i2) {
        AppMethodBeat.i(237458);
        BXV.lz(i2);
        ax(1, 1);
        AppMethodBeat.o(237458);
    }

    public static void eLf() {
        AppMethodBeat.i(237459);
        BXV.ahb();
        AppMethodBeat.o(237459);
    }

    public static void VQ(int i2) {
        AppMethodBeat.i(237460);
        BXV.lA(i2);
        AppMethodBeat.o(237460);
    }

    public static void setConfigProvider(RecordConfigProvider recordConfigProvider) {
        String str;
        Boolean bool;
        VideoTransPara videoTransPara = null;
        AppMethodBeat.i(237461);
        Cif ifVar = BXV;
        if (recordConfigProvider == null || (str = recordConfigProvider.BOz) == null) {
            str = "";
        }
        ifVar.vR(str);
        Cif ifVar2 = BXV;
        if (recordConfigProvider != null) {
            bool = recordConfigProvider.BOt;
        } else {
            bool = null;
        }
        ifVar2.ly(p.j(bool, Boolean.TRUE) ? 0 : 1);
        Cif ifVar3 = BXV;
        if (recordConfigProvider != null) {
            videoTransPara = recordConfigProvider.BOm;
        }
        String valueOf = String.valueOf(videoTransPara);
        if (valueOf == null) {
            valueOf = "";
        }
        ifVar3.vW(valueOf);
        AppMethodBeat.o(237461);
    }

    public static void ts(boolean z) {
        AppMethodBeat.i(237462);
        BXV.vV(z ? "x264" : "mediacodec");
        AppMethodBeat.o(237462);
    }

    public static void tt(boolean z) {
        AppMethodBeat.i(237463);
        BXV.vU(z ? "ffmpeg" : "mp4v2");
        AppMethodBeat.o(237463);
    }

    public static void b(i iVar) {
        AppMethodBeat.i(237464);
        if (iVar == null) {
            AppMethodBeat.o(237464);
            return;
        }
        BXV.lu(iVar.optBoolean("isUseCamera2") ? 2 : 1);
        BXV.lC(iVar.optInt("CameraOpenCost"));
        BXV.lD(iVar.optInt("CameraFirstFrameCost"));
        BXV.lE(iVar.optInt("HighRecordStopWaitTime"));
        BXV.lF(iVar.optInt("LowRecordStopWaitTime"));
        BXV.vT(iVar.optBoolean("RecordMuxerType") ? "ffmpeg" : "mp4v2");
        Cif ifVar = BXV;
        ifVar.qZ(ifVar.ahd() != 0 ? BXV.ahd() : iVar.optLong("OpenCameraTimeStamp"));
        Cif ifVar2 = BXV;
        ifVar2.ra(ifVar2.ahe() != 0 ? BXV.ahe() : iVar.optLong("StartPreviewTimeStamp"));
        Cif ifVar3 = BXV;
        ifVar3.rb(ifVar3.ahf() != 0 ? BXV.ahf() : iVar.optLong("PreviewSuccessTImeStamp"));
        AppMethodBeat.o(237464);
    }

    public static void aLz(String str) {
        String str2;
        AppMethodBeat.i(237465);
        p.h(str, "videoPath");
        a aNx = e.aNx(str);
        Cif ifVar = BXV;
        if (aNx == null || (str2 = aNx.toString()) == null) {
            str2 = "";
        }
        ifVar.vX(str2);
        AppMethodBeat.o(237465);
    }

    public static void aLA(String str) {
        String str2;
        AppMethodBeat.i(237466);
        p.h(str, "videoPath");
        a aNx = e.aNx(str);
        Cif ifVar = BXV;
        if (aNx == null || (str2 = aNx.toString()) == null) {
            str2 = "";
        }
        ifVar.vY(str2);
        AppMethodBeat.o(237466);
    }

    public static void Ia(long j2) {
        AppMethodBeat.i(237467);
        BXV.rc(j2);
        AppMethodBeat.o(237467);
    }

    public static void Ib(long j2) {
        AppMethodBeat.i(237468);
        BXV.rd(j2);
        AppMethodBeat.o(237468);
    }

    public static void Ic(long j2) {
        AppMethodBeat.i(237469);
        BXV.re(j2);
        AppMethodBeat.o(237469);
    }

    public static void Id(long j2) {
        AppMethodBeat.i(237470);
        BXV.rf(j2);
        AppMethodBeat.o(237470);
    }

    public static void Ie(long j2) {
        AppMethodBeat.i(237471);
        BXV.rg(j2);
        AppMethodBeat.o(237471);
    }

    public static void If(long j2) {
        AppMethodBeat.i(237472);
        BXV.rh(j2);
        AppMethodBeat.o(237472);
    }

    public static void ax(int i2, long j2) {
        AppMethodBeat.i(237473);
        BXV.lB(i2);
        BXV.qX(j2);
        AppMethodBeat.o(237473);
    }

    public static String eLg() {
        AppMethodBeat.i(237474);
        StringBuilder sb = new StringBuilder();
        Iterator<T> it = BXX.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next()).append("#");
        }
        String sb2 = sb.toString();
        p.g(sb2, "routeLog.toString()");
        String j2 = n.j(sb2, ",", ";", false);
        AppMethodBeat.o(237474);
        return j2;
    }
}
