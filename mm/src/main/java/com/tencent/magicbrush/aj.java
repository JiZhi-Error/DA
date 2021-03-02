package com.tencent.magicbrush;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, hxF = {"Lcom/tencent/magicbrush/V8RawPointer;", "", "isolatePtr", "", "contextPtr", "uvLoopPtr", "(JJJ)V", "getContextPtr", "()J", "getIsolatePtr", "getUvLoopPtr", "component1", "component2", "component3", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "lib-magicbrush-nano_release"})
public final class aj {
    final long cMA;
    final long cMB;
    final long cMz;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof aj) {
                aj ajVar = (aj) obj;
                if (!(this.cMz == ajVar.cMz && this.cMA == ajVar.cMA && this.cMB == ajVar.cMB)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        long j2 = this.cMz;
        long j3 = this.cMA;
        long j4 = this.cMB;
        return (((((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)));
    }

    public final String toString() {
        AppMethodBeat.i(140187);
        String str = "V8RawPointer(isolatePtr=" + this.cMz + ", contextPtr=" + this.cMA + ", uvLoopPtr=" + this.cMB + ")";
        AppMethodBeat.o(140187);
        return str;
    }

    public aj(long j2, long j3, long j4) {
        this.cMz = j2;
        this.cMA = j3;
        this.cMB = j4;
    }
}
