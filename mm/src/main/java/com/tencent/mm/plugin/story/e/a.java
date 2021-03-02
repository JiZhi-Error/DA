package com.tencent.mm.plugin.story.e;

import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/story/data/StoryTimeUtil;", "", "()V", "Companion", "plugin-story_release"})
public final class a {
    public static final C1747a Flw = new C1747a((byte) 0);
    private static final long MILLSECONDS_OF_DAY = (24 * MILLSECONDS_OF_HOUR);
    private static final long MILLSECONDS_OF_HOUR = (MILLSECONDS_OF_MINUTE * 60);
    private static final long MILLSECONDS_OF_MINUTE = (MILLSECONDS_OF_SECOND * 60);
    private static final long MILLSECONDS_OF_SECOND = 1000;
    private static final String TAG = TAG;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0004J\u0015\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001b\u001a\u00020\u0014R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u000e\u0010\r\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/story/data/StoryTimeUtil$Companion;", "", "()V", "MILLSECONDS_OF_DAY", "", "getMILLSECONDS_OF_DAY", "()J", "MILLSECONDS_OF_HOUR", "getMILLSECONDS_OF_HOUR", "MILLSECONDS_OF_MINUTE", "getMILLSECONDS_OF_MINUTE", "MILLSECONDS_OF_SECOND", "getMILLSECONDS_OF_SECOND", "TAG", "", "formatDateInGallery", "", FFmpegMetadataRetriever.METADATA_KEY_DATE, "formatDateInGrid", "formatDateToTimeSecond", "", "formatStoryCreateDate", "time", "formatTimeInGrid", "formatTimeSecondToDate", "(Ljava/lang/Integer;)Ljava/lang/String;", "formatTimeSecondToMD", "nowToYear", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.e.a$a  reason: collision with other inner class name */
    public static final class C1747a {
        private C1747a() {
        }

        public /* synthetic */ C1747a(byte b2) {
            this();
        }

        public static CharSequence aRL(String str) {
            long j2;
            AppMethodBeat.i(118618);
            p.h(str, FFmpegMetadataRetriever.METADATA_KEY_DATE);
            try {
                List<String> a2 = n.a(str, new String[]{"-"});
                j2 = new GregorianCalendar(Integer.parseInt(a2.get(0)), Integer.parseInt(a2.get(1)) - 1, Integer.parseInt(a2.get(2))).getTimeInMillis();
            } catch (Exception e2) {
                Log.printErrStackTrace(a.TAG, e2, e2.getMessage(), new Object[0]);
                j2 = 0;
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
            gregorianCalendar2.setTimeInMillis(j2);
            if (gregorianCalendar.get(1) == gregorianCalendar2.get(1) && gregorianCalendar.get(2) == gregorianCalendar2.get(2)) {
                String string = MMApplicationContext.getContext().getString(R.string.hg6);
                p.g(string, "MMApplicationContext.get…ry_album_date_this_month)");
                String str2 = string;
                AppMethodBeat.o(118618);
                return str2;
            }
            new GregorianCalendar().setTimeInMillis(j2);
            CharSequence format = DateFormat.format(MMApplicationContext.getContext().getString(R.string.hg5), j2);
            p.g(format, "DateFormat.format(MMAppl…_album_date_split), time)");
            AppMethodBeat.o(118618);
            return format;
        }

        public static CharSequence aRM(String str) {
            long j2;
            AppMethodBeat.i(118619);
            p.h(str, FFmpegMetadataRetriever.METADATA_KEY_DATE);
            try {
                List<String> a2 = n.a(str, new String[]{"-"});
                j2 = new GregorianCalendar(Integer.parseInt(a2.get(0)), Integer.parseInt(a2.get(1)) - 1, Integer.parseInt(a2.get(2))).getTimeInMillis();
            } catch (Exception e2) {
                Log.printErrStackTrace(a.TAG, e2, e2.getMessage(), new Object[0]);
                j2 = 0;
            }
            CharSequence format = DateFormat.format(MMApplicationContext.getContext().getString(R.string.hia), j2);
            p.g(format, "DateFormat.format(MMAppl…allery_date_split), time)");
            AppMethodBeat.o(118619);
            return format;
        }

        public static int Ki(long j2) {
            int i2;
            AppMethodBeat.i(118620);
            try {
                i2 = Integer.parseInt(DateFormat.format(MMApplicationContext.getContext().getString(R.string.hg3), j2).toString());
            } catch (NumberFormatException e2) {
                Log.printErrStackTrace(a.TAG, e2, "NumberFormatException", new Object[0]);
                i2 = 0;
            }
            AppMethodBeat.o(118620);
            return i2;
        }

        public static int aRN(String str) {
            AppMethodBeat.i(118621);
            p.h(str, FFmpegMetadataRetriever.METADATA_KEY_DATE);
            Date parse = new SimpleDateFormat("yyyy-MM-dd").parse(str);
            p.g(parse, "simpleDateFormat.parse(date)");
            int time = (int) (parse.getTime() / 1000);
            AppMethodBeat.o(118621);
            return time;
        }

        public static String n(Integer num) {
            AppMethodBeat.i(118622);
            String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date((num != null ? (long) num.intValue() : 0) * 1000));
            p.g(format, "simpleDateFormat.format(date)");
            AppMethodBeat.o(118622);
            return format;
        }
    }

    static {
        AppMethodBeat.i(118623);
        AppMethodBeat.o(118623);
    }
}
