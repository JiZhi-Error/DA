package com.tencent.mm.plugin.vlog.model;

import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.eko;
import com.tencent.mm.protocal.protobuf.fbr;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \b&\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f¢\u0006\u0002\u0010\u0013R\u001a\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001f\"\u0004\b1\u0010!¨\u00062"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/Material;", "", "scaleType", "Lcom/tencent/mm/plugin/vlog/model/ScaleType;", "filter", "Lcom/tencent/mm/plugin/vlog/model/Filter;", "transition", "Lcom/tencent/mm/plugin/vlog/model/TransitionType;", "startTime", "", "endTime", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "path", "", "keyTrace", "", "Lcom/tencent/mm/protocal/protobuf/WindowMeta;", "transitionParams", "Lcom/tencent/mm/protocal/protobuf/TransitionParam;", "(Lcom/tencent/mm/plugin/vlog/model/ScaleType;Lcom/tencent/mm/plugin/vlog/model/Filter;Lcom/tencent/mm/plugin/vlog/model/TransitionType;JJJLjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getDuration", "()J", "setDuration", "(J)V", "getEndTime", "setEndTime", "getFilter", "()Lcom/tencent/mm/plugin/vlog/model/Filter;", "setFilter", "(Lcom/tencent/mm/plugin/vlog/model/Filter;)V", "getKeyTrace", "()Ljava/util/List;", "setKeyTrace", "(Ljava/util/List;)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "getScaleType", "()Lcom/tencent/mm/plugin/vlog/model/ScaleType;", "setScaleType", "(Lcom/tencent/mm/plugin/vlog/model/ScaleType;)V", "getStartTime", "setStartTime", "getTransition", "()Lcom/tencent/mm/plugin/vlog/model/TransitionType;", "setTransition", "(Lcom/tencent/mm/plugin/vlog/model/TransitionType;)V", "getTransitionParams", "setTransitionParams", "plugin-vlog_release"})
public abstract class s {
    private y Gyq;
    private l Gyr;
    private ab Gys;
    List<? extends fbr> Gyt;
    List<? extends eko> Gyu;
    private long duration;
    public long endTime;
    public String path;
    public long startTime;

    private s(y yVar, l lVar, ab abVar, long j2, long j3, long j4, String str) {
        p.h(yVar, "scaleType");
        p.h(lVar, "filter");
        p.h(abVar, "transition");
        p.h(str, "path");
        this.Gyq = yVar;
        this.Gyr = lVar;
        this.Gys = abVar;
        this.startTime = j2;
        this.endTime = j3;
        this.duration = j4;
        this.path = str;
        this.Gyt = null;
        this.Gyu = null;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ s(com.tencent.mm.plugin.vlog.model.y r13, com.tencent.mm.plugin.vlog.model.l r14, com.tencent.mm.plugin.vlog.model.ab r15, long r16, long r18, long r20, java.lang.String r22, int r23) {
        /*
            r12 = this;
            r0 = r23 & 1
            if (r0 == 0) goto L_0x0032
            com.tencent.mm.plugin.vlog.model.y r1 = com.tencent.mm.plugin.vlog.model.y.CENTER_INSIDE
        L_0x0006:
            r0 = r23 & 2
            if (r0 == 0) goto L_0x0030
            com.tencent.mm.plugin.vlog.model.l r2 = com.tencent.mm.plugin.vlog.model.l.NO_FILTER
        L_0x000c:
            r0 = r23 & 4
            if (r0 == 0) goto L_0x002e
            com.tencent.mm.plugin.vlog.model.ab r3 = com.tencent.mm.plugin.vlog.model.ab.NONE
        L_0x0012:
            r0 = r23 & 32
            if (r0 == 0) goto L_0x002b
            long r8 = r18 - r16
        L_0x0018:
            r0 = r23 & 64
            if (r0 == 0) goto L_0x0028
            java.lang.String r10 = ""
        L_0x001f:
            r0 = r12
            r4 = r16
            r6 = r18
            r0.<init>(r1, r2, r3, r4, r6, r8, r10)
            return
        L_0x0028:
            r10 = r22
            goto L_0x001f
        L_0x002b:
            r8 = r20
            goto L_0x0018
        L_0x002e:
            r3 = r15
            goto L_0x0012
        L_0x0030:
            r2 = r14
            goto L_0x000c
        L_0x0032:
            r1 = r13
            goto L_0x0006
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.vlog.model.s.<init>(com.tencent.mm.plugin.vlog.model.y, com.tencent.mm.plugin.vlog.model.l, com.tencent.mm.plugin.vlog.model.ab, long, long, long, java.lang.String, int):void");
    }

    public final void a(y yVar) {
        p.h(yVar, "<set-?>");
        this.Gyq = yVar;
    }

    public final void a(ab abVar) {
        p.h(abVar, "<set-?>");
        this.Gys = abVar;
    }
}
