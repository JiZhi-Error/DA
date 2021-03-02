package com.tencent.mm.plugin.vlog.model;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.protocal.protobuf.erh;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u0000 I2\u00020\u0001:\u0001IBu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e\u0012\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\fj\b\u0012\u0004\u0012\u00020\u0010`\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0014J\t\u00109\u001a\u00020\u0003HÆ\u0003J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010;\u001a\u00020\bHÆ\u0003J\t\u0010<\u001a\u00020\nHÆ\u0003J\u0019\u0010=\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eHÆ\u0003J\u0019\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\u00100\fj\b\u0012\u0004\u0012\u00020\u0010`\u000eHÆ\u0003J\t\u0010?\u001a\u00020\u0012HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\fj\b\u0012\u0004\u0012\u00020\u0010`\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0001J\u0013\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010E\u001a\u00020 J\t\u0010F\u001a\u00020 HÖ\u0001J\u0006\u0010G\u001a\u00020CJ\b\u0010H\u001a\u00020\bH\u0016R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\fj\b\u0012\u0004\u0012\u00020\u0010`\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR*\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0011\u0010/\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b0\u0010\"R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0016\"\u0004\b2\u0010\u0018R\u0011\u00103\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b4\u0010\"R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006J"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "", "respId", "", "materials", "", "Lcom/tencent/mm/plugin/vlog/model/Material;", "netMusicPath", "", "xEffectConfig", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "editItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "Lkotlin/collections/ArrayList;", "editData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "drawingRect", "", "validRect", "(JLjava/util/List;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/VlogResp;Ljava/util/ArrayList;Ljava/util/ArrayList;[F[F)V", "getDrawingRect", "()[F", "setDrawingRect", "([F)V", "getEditData", "()Ljava/util/ArrayList;", "setEditData", "(Ljava/util/ArrayList;)V", "getEditItems", "setEditItems", "fid", "", "getFid", "()I", "getMaterials", "()Ljava/util/List;", "setMaterials", "(Ljava/util/List;)V", "getNetMusicPath", "()Ljava/lang/String;", "setNetMusicPath", "(Ljava/lang/String;)V", "getRespId", "()J", "setRespId", "(J)V", "sid", "getSid", "getValidRect", "setValidRect", "vid", "getVid", "getXEffectConfig", "()Lcom/tencent/mm/protocal/protobuf/VlogResp;", "setXEffectConfig", "(Lcom/tencent/mm/protocal/protobuf/VlogResp;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "getVideoDurationMs", "hashCode", "isValid", "toString", "Companion", "plugin-vlog_release"})
public final class ah {
    public static final a GzT = new a((byte) 0);
    public float[] BKV;
    public float[] BKW;
    public ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> BNn;
    public ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> BNo;
    public long GzP;
    public List<? extends s> GzQ;
    public String GzR;
    public erh GzS;

    static {
        AppMethodBeat.i(110947);
        AppMethodBeat.o(110947);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005a, code lost:
        if (kotlin.g.b.p.j(r5.BKW, r6.BKW) != false) goto L_0x005c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
        // Method dump skipped, instructions count: 102
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.vlog.model.ah.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(110948);
        long j2 = this.GzP;
        int i3 = ((int) (j2 ^ (j2 >>> 32))) * 31;
        List<? extends s> list = this.GzQ;
        int hashCode = ((list != null ? list.hashCode() : 0) + i3) * 31;
        String str = this.GzR;
        int hashCode2 = ((str != null ? str.hashCode() : 0) + hashCode) * 31;
        erh erh = this.GzS;
        int hashCode3 = ((erh != null ? erh.hashCode() : 0) + hashCode2) * 31;
        ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> arrayList = this.BNn;
        int hashCode4 = ((arrayList != null ? arrayList.hashCode() : 0) + hashCode3) * 31;
        ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> arrayList2 = this.BNo;
        int hashCode5 = ((arrayList2 != null ? arrayList2.hashCode() : 0) + hashCode4) * 31;
        float[] fArr = this.BKV;
        int hashCode6 = ((fArr != null ? Arrays.hashCode(fArr) : 0) + hashCode5) * 31;
        float[] fArr2 = this.BKW;
        if (fArr2 != null) {
            i2 = Arrays.hashCode(fArr2);
        }
        int i4 = hashCode6 + i2;
        AppMethodBeat.o(110948);
        return i4;
    }

    private ah(long j2, List<? extends s> list, String str, erh erh, ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> arrayList, ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> arrayList2, float[] fArr) {
        p.h(list, "materials");
        p.h(str, "netMusicPath");
        p.h(erh, "xEffectConfig");
        p.h(arrayList, "editItems");
        p.h(arrayList2, "editData");
        p.h(fArr, "drawingRect");
        AppMethodBeat.i(110945);
        this.GzP = j2;
        this.GzQ = list;
        this.GzR = str;
        this.GzS = erh;
        this.BNn = arrayList;
        this.BNo = arrayList2;
        this.BKV = fArr;
        this.BKW = null;
        AppMethodBeat.o(110945);
    }

    public /* synthetic */ ah(long j2, List list, String str, erh erh) {
        this(j2, list, str, erh, new ArrayList(), new ArrayList(), new float[]{0.0f, 0.0f, 0.0f, 0.0f});
        AppMethodBeat.i(110946);
        AppMethodBeat.o(110946);
    }

    public final void aT(ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> arrayList) {
        AppMethodBeat.i(110943);
        p.h(arrayList, "<set-?>");
        this.BNn = arrayList;
        AppMethodBeat.o(110943);
    }

    public final void p(float[] fArr) {
        AppMethodBeat.i(110944);
        p.h(fArr, "<set-?>");
        this.BKV = fArr;
        AppMethodBeat.o(110944);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel$Companion;", "", "()V", BuildConfig.KINDA_DEFAULT, "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final int getVideoDurationMs() {
        long j2;
        AppMethodBeat.i(110941);
        long j3 = 0;
        for (T t : this.GzQ) {
            if (t.endTime > j3) {
                j2 = t.endTime;
            } else {
                j2 = j3;
            }
            j3 = j2;
        }
        int i2 = (int) j3;
        AppMethodBeat.o(110941);
        return i2;
    }

    public final String toString() {
        AppMethodBeat.i(110942);
        String str = "VLogScriptModel(respId=" + this.GzP + ", materials=" + this.GzQ + ", netMusicPath='" + this.GzR + "', xEffectConfig=" + this.GzS + ", editItems=" + this.BNn + ", editData=" + this.BNo + ", drawingRect=" + Arrays.toString(this.BKV) + ')';
        AppMethodBeat.o(110942);
        return str;
    }

    public final int fBJ() {
        return (int) this.GzS.NoU.LQL;
    }

    public final int fBK() {
        return (int) this.GzS.NoU.LQM;
    }

    public final int fBL() {
        return (int) this.GzS.NoU.KTS;
    }
}
