package com.tencent.mm.plugin.story.e;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.media.k;
import java.math.BigInteger;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/story/data/StoryUtil;", "", "()V", "Companion", "plugin-story_release"})
public final class b {
    private static final String DEI = DEI;
    public static final a FlA = new a((byte) 0);
    private static final String Flx = Flx;
    private static final float Fly = Fly;
    private static final String Flz = Flz;
    private static final String TAG = TAG;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001:\u0001$B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0012\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u0004J\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004J\u000e\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/story/data/StoryUtil$Companion;", "", "()V", "B_PRE", "", "INVALID_GEO", "", "getINVALID_GEO", "()F", "LOCAL_PATH_PRE", "getLOCAL_PATH_PRE", "()Ljava/lang/String;", "RESPONE_COUNT", "TAG", "bitmapAvailable", "", "bm", "Landroid/graphics/Bitmap;", "dumpMedia", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "exportVideo", "", "videoPath", "getFullStrSeq", "stringSeq", "getStoryResponeCount", "", k.NAME, "Lcom/tencent/mm/plugin/story/data/StoryUtil$Companion$VideoInfo;", "path", "getVideoMIME", "longToFullString", "seq", "", "longToString", "VideoInfo", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static String Jc(long j2) {
            AppMethodBeat.i(118624);
            if (j2 == 0) {
                AppMethodBeat.o(118624);
                return "";
            }
            String binaryString = Long.toBinaryString(j2);
            p.g(binaryString, "java.lang.Long.toBinaryString(seq)");
            String bigInteger = new BigInteger(binaryString, 2).toString();
            p.g(bigInteger, "big.toString()");
            String aOr = aOr(bigInteger);
            AppMethodBeat.o(118624);
            return aOr;
        }

        private static String aOr(String str) {
            AppMethodBeat.i(118625);
            p.h(str, "stringSeq");
            StringBuffer stringBuffer = new StringBuffer(str);
            while (stringBuffer.length() < 25) {
                stringBuffer.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            String stringBuffer2 = stringBuffer.toString();
            p.g(stringBuffer2, "sb.toString()");
            AppMethodBeat.o(118625);
            return stringBuffer2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0041  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.lang.String aRO(java.lang.String r5) {
            /*
                r4 = 118626(0x1cf62, float:1.6623E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                java.lang.String r0 = "path"
                kotlin.g.b.p.h(r5, r0)
                boolean r0 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r5)
                if (r0 == 0) goto L_0x0019
                java.lang.String r0 = ""
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            L_0x0018:
                return r0
            L_0x0019:
                r0 = 0
                com.tencent.mm.media.f.a r1 = new com.tencent.mm.media.f.a     // Catch:{ Exception -> 0x002f, all -> 0x003c }
                r1.<init>(r5)     // Catch:{ Exception -> 0x002f, all -> 0x003c }
                java.lang.String r0 = r1.aMs()     // Catch:{ Exception -> 0x004c, all -> 0x0048 }
                if (r0 != 0) goto L_0x0028
                java.lang.String r0 = ""
            L_0x0028:
                r1.release()
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                goto L_0x0018
            L_0x002f:
                r1 = move-exception
            L_0x0030:
                if (r0 == 0) goto L_0x0035
                r0.release()
            L_0x0035:
                java.lang.String r0 = ""
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                goto L_0x0018
            L_0x003c:
                r1 = move-exception
                r2 = r1
                r3 = r0
            L_0x003f:
                if (r3 == 0) goto L_0x0044
                r3.release()
            L_0x0044:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                throw r2
            L_0x0048:
                r0 = move-exception
                r2 = r0
                r3 = r1
                goto L_0x003f
            L_0x004c:
                r0 = move-exception
                r0 = r1
                goto L_0x0030
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.e.b.a.aRO(java.lang.String):java.lang.String");
        }
    }

    static {
        AppMethodBeat.i(118627);
        AppMethodBeat.o(118627);
    }
}
