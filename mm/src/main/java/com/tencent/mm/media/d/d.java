package com.tencent.mm.media.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\b\u001a\u00020\tJ\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\b\u001a\u00020\tJ&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0002J4\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0002J4\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0002¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/media/decoder/DropFrameAlgo;", "", "()V", "dropFrames", "", "", "frames", "", "remains", "", "dropFrames2", "getDown", "", "i", "j", "x", "getUp", "f", "slope", "plugin-mediaeditor_release"})
public final class d {
    public static final d ieb = new d();

    static {
        AppMethodBeat.i(93530);
        AppMethodBeat.o(93530);
    }

    private d() {
    }

    static double a(int i2, int i3, List<Long> list, List<Long> list2) {
        AppMethodBeat.i(93528);
        double longValue = (double) ((list.get(i2).longValue() + (list2.get(i2).longValue() * list2.get(i2).longValue())) - ((list2.get(i3).longValue() * list2.get(i3).longValue()) + list.get(i3).longValue()));
        AppMethodBeat.o(93528);
        return longValue;
    }

    static double a(int i2, int i3, List<Long> list) {
        AppMethodBeat.i(93529);
        double longValue = (double) ((list.get(i2).longValue() - list.get(i3).longValue()) * 2);
        AppMethodBeat.o(93529);
        return longValue;
    }
}
