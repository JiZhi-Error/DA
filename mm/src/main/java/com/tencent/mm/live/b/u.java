package com.tencent.mm.live.b;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/live/model/LiveTimeUtil;", "", "()V", "Companion", "plugin-logic_release"})
public final class u {
    public static final a hIn = new a((byte) 0);

    static {
        AppMethodBeat.i(207693);
        AppMethodBeat.o(207693);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004J4\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/live/model/LiveTimeUtil$Companion;", "", "()V", "formatAnchorLikeCount", "", "likeCnt", "", "formatDuration", "durationMs", "", "splitStr", "formatDurationSecond", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "showH", "", "showM", "showS", "plugin-logic_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static /* synthetic */ String a(int i2, String str, boolean z, boolean z2, boolean z3, int i3) {
            AppMethodBeat.i(207692);
            if ((i3 & 4) != 0) {
                z = true;
            }
            if ((i3 & 8) != 0) {
                z2 = true;
            }
            if ((i3 & 16) != 0) {
                z3 = true;
            }
            p.h(str, "splitStr");
            int i4 = i2 % 60;
            int i5 = (i2 / 60) % 60;
            int i6 = (i2 / 60) / 60;
            String concat = i4 < 10 ? AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(i4)) : String.valueOf(i4);
            String concat2 = i5 < 10 ? AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(i5)) : String.valueOf(i5);
            String concat3 = i6 < 10 ? AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(i6)) : String.valueOf(i6);
            StringBuilder sb = new StringBuilder();
            if (z) {
                sb.append(concat3 + str);
            }
            if (z2) {
                sb.append(concat2 + str);
            }
            if (z3) {
                sb.append(concat);
            }
            String sb2 = sb.toString();
            p.g(sb2, "result.toString()");
            AppMethodBeat.o(207692);
            return sb2;
        }
    }
}
