package com.tencent.mm.xeffect.effect;

import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0004J\u0006\u0010\u0011\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003J\b\u0010\u0015\u001a\u00020\u0016H&R$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\b\"\u0004\b\u000b\u0010\u0004R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/xeffect/effect/VLogEffect;", "", "ptr", "", "(J)V", "<set-?>", "id", "getId", "()J", "setId$renderlib_release", "getPtr", "setPtr", "timeRange", "Lcom/tencent/mm/xeffect/effect/EffectTimeRange;", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "finalize", "", "getTimeRange", "setTimeRange", "start", "end", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "renderlib_release"})
public abstract class ad {
    public i RyZ = new i();
    public long id;
    public long ptr;

    public abstract j hiu();

    public ad(long j2) {
        this.ptr = j2;
    }

    public final void aH(long j2, long j3) {
        a(new i(j2, j3));
    }

    private void a(i iVar) {
        p.h(iVar, "timeRange");
        this.RyZ = iVar;
        VLogEffectJNI.INSTANCE.setEffectTime$renderlib_release(this.ptr, iVar);
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        VLogEffectJNI.INSTANCE.destroyEffect(this);
    }
}
