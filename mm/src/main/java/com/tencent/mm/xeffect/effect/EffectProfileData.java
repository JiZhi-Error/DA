package com.tencent.mm.xeffect.effect;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\bJ\t\u0010\u000e\u001a\u00020\nH J\u0011\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H J\u0011\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H J\u0011\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u0003H J\u0006\u0010\u0013\u001a\u00020\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/xeffect/effect/EffectProfileData;", "", "ptr", "", "(J)V", "getPtr", "()J", "array2ProfileRecorder", "Lcom/tencent/mm/xeffect/effect/EffectProfileData$ProfileRecorder;", "array", "", "getCreatePAGFile", "getCreatePAGSurface", "getRenderPAG", "nGetCreatePAGFile", "nGetCreatePAGSurface", "nGetRenderPAG", "nReset", "", "reset", "ProfileRecorder", "renderlib_release"})
public final class EffectProfileData {
    public final long ptr;

    private final native long[] nGetCreatePAGSurface(long j2);

    private final native void nReset(long j2);

    public final native long[] nGetCreatePAGFile();

    public final native long[] nGetRenderPAG(long j2);

    @l(hxD = {1, 1, 15}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/xeffect/effect/EffectProfileData$ProfileRecorder;", "", "startCount", "", "successCount", "costAvg", "", "(IIJ)V", "getCostAvg", "()J", "setCostAvg", "(J)V", "getStartCount", "()I", "setStartCount", "(I)V", "getSuccessCount", "setSuccessCount", "component1", "component2", "component3", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "renderlib_release"})
    public static final class a {
        public int JRy;
        public long RxT;
        public int successCount;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                if (!(this.JRy == aVar.JRy)) {
                    return false;
                }
                if (!(this.successCount == aVar.successCount)) {
                    return false;
                }
                if (!(this.RxT == aVar.RxT)) {
                    return false;
                }
            }
            return true;
        }

        public final int hashCode() {
            long j2 = this.RxT;
            return (((this.JRy * 31) + this.successCount) * 31) + ((int) (j2 ^ (j2 >>> 32)));
        }

        public final String toString() {
            AppMethodBeat.i(237071);
            String str = "ProfileRecorder(startCount=" + this.JRy + ", successCount=" + this.successCount + ", costAvg=" + this.RxT + ")";
            AppMethodBeat.o(237071);
            return str;
        }

        private a() {
            this.JRy = 0;
            this.successCount = 0;
            this.RxT = 0;
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public EffectProfileData(long j2) {
        this.ptr = j2;
    }

    public static a g(long[] jArr) {
        AppMethodBeat.i(237072);
        a aVar = new a((byte) 0);
        if (jArr.length >= 3) {
            aVar.JRy = (int) jArr[0];
            aVar.successCount = (int) jArr[1];
            aVar.RxT = jArr[2];
        }
        AppMethodBeat.o(237072);
        return aVar;
    }
}
