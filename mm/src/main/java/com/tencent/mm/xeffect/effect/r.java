package com.tencent.mm.xeffect.effect;

import android.util.Size;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/xeffect/effect/PagEffect;", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "ptr", "", "(J)V", "imageNum", "", "getImageNum", "()I", "pagDuration", "getPagDuration", "()J", "size", "Landroid/util/Size;", "getSize", "()Landroid/util/Size;", "setCheckMarker", "", "check", "", "renderlib_release"})
public abstract class r extends ad {
    public final Size ApT;
    public final int RyV;
    public final long RyW;

    public r(long j2) {
        super(j2);
        this.ApT = VLogEffectJNI.INSTANCE.getPagSize$renderlib_release(j2);
        this.RyV = VLogEffectJNI.INSTANCE.getPagImageNum$renderlib_release(j2);
        this.RyW = VLogEffectJNI.INSTANCE.getPagDuration$renderlib_release(j2);
    }
}
