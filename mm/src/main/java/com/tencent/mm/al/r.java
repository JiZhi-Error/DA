package com.tencent.mm.al;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bJ\u0006\u0010\u0014\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u000bJ\b\u0010\u0017\u001a\u00020\u000fH\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R&\u0010\b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f0\tX\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\tX\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/modelbiz/MpDataLimiter;", "", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "(I)V", "getDuration", "()I", "setDuration", "sets", "", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "[Ljava/util/HashSet;", "slots", "", "[Ljava/lang/Long;", "add", "", "key", "clear", "contains", "", "slotId", "plugin-biz_release"})
public final class r {
    public int duration;
    private final Long[] iOM;
    private final HashSet<String>[] iON;

    public /* synthetic */ r() {
        this(s.iOO);
        AppMethodBeat.i(124708);
        AppMethodBeat.o(124708);
    }

    public r(int i2) {
        AppMethodBeat.i(124707);
        this.duration = i2;
        int i3 = s.SLOT_SIZE;
        Long[] lArr = new Long[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            lArr[i4] = 0L;
        }
        this.iOM = lArr;
        int i5 = s.SLOT_SIZE;
        HashSet<String>[] hashSetArr = new HashSet[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            hashSetArr[i6] = new HashSet<>();
        }
        this.iON = hashSetArr;
        AppMethodBeat.o(124707);
    }

    public final boolean contains(String str) {
        AppMethodBeat.i(212433);
        p.h(str, "key");
        HashSet<String> hashSet = null;
        long aZY = aZY();
        int i2 = (int) (aZY % ((long) s.SLOT_SIZE));
        if (aZY == this.iOM[i2].longValue()) {
            hashSet = this.iON[i2];
        } else {
            int abs = Math.abs(i2 - 1) % s.SLOT_SIZE;
            if (aZY == this.iOM[abs].longValue()) {
                hashSet = this.iON[abs];
            }
        }
        if (hashSet != null) {
            boolean contains = hashSet.contains(str);
            AppMethodBeat.o(212433);
            return contains;
        }
        AppMethodBeat.o(212433);
        return false;
    }

    public final void add(String str) {
        AppMethodBeat.i(124705);
        p.h(str, "key");
        long aZY = aZY();
        int i2 = (int) (aZY % ((long) s.SLOT_SIZE));
        if (this.iOM[i2].longValue() != aZY) {
            this.iON[i2].clear();
            this.iOM[i2] = Long.valueOf(aZY);
        }
        this.iON[i2].add(str);
        AppMethodBeat.o(124705);
    }

    private final long aZY() {
        AppMethodBeat.i(124706);
        long abs = Math.abs(SystemClock.elapsedRealtime() / ((long) this.duration));
        AppMethodBeat.o(124706);
        return abs;
    }
}
