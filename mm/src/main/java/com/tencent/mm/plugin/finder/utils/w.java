package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.utils.d;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.protocal.protobuf.bdq;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.coc;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.tools.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.n.k;
import kotlin.n.n;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

public final class w {
    private static final String TAG = TAG;
    private static ArrayList<k> vVe;
    private static final char vXo = vXo;
    public static final w vXp = new w();

    static {
        AppMethodBeat.i(167932);
        ArrayList<k> arrayList = new ArrayList<>();
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        Iterator<T> it = com.tencent.mm.plugin.finder.storage.c.dvt().iterator();
        while (it.hasNext()) {
            arrayList.add(new k((String) it.next()));
        }
        vVe = arrayList;
        AppMethodBeat.o(167932);
    }

    private w() {
    }

    public static char dCx() {
        return vXo;
    }

    public static final class c {
        final int count;
        public final String dST;
        final int start;

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
            if (kotlin.g.b.p.j(r3.dST, r4.dST) != false) goto L_0x0024;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 167915(0x28feb, float:2.35299E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0024
                boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.utils.w.c
                if (r0 == 0) goto L_0x0029
                com.tencent.mm.plugin.finder.utils.w$c r4 = (com.tencent.mm.plugin.finder.utils.w.c) r4
                int r0 = r3.start
                int r1 = r4.start
                if (r0 != r1) goto L_0x0029
                int r0 = r3.count
                int r1 = r4.count
                if (r0 != r1) goto L_0x0029
                java.lang.String r0 = r3.dST
                java.lang.String r1 = r4.dST
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0029
            L_0x0024:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0028:
                return r0
            L_0x0029:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0028
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.utils.w.c.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(167914);
            int i2 = ((this.start * 31) + this.count) * 31;
            String str = this.dST;
            int hashCode = (str != null ? str.hashCode() : 0) + i2;
            AppMethodBeat.o(167914);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(167913);
            String str = "TopicStringInfo(start=" + this.start + ", count=" + this.count + ", topic=" + this.dST + ")";
            AppMethodBeat.o(167913);
            return str;
        }

        public c(int i2, int i3, String str) {
            p.h(str, "topic");
            AppMethodBeat.i(167912);
            this.start = i2;
            this.count = i3;
            this.dST = str;
            AppMethodBeat.o(167912);
        }
    }

    public static final class b {
        final int count;
        final int start;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    if (!(this.start == bVar.start && this.count == bVar.count)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return (this.start * 31) + this.count;
        }

        public final String toString() {
            AppMethodBeat.i(167911);
            String str = "SmileySpanInfo(start=" + this.start + ", count=" + this.count + ")";
            AppMethodBeat.o(167911);
            return str;
        }

        public b(int i2, int i3) {
            this.start = i2;
            this.count = i3;
        }
    }

    public static List<c> a(String str, ArrayList<d.a> arrayList, m<? super Integer, ? super Integer, x> mVar) {
        boolean z;
        boolean z2;
        int i2;
        boolean z3;
        int i3;
        AppMethodBeat.i(253550);
        p.h(str, "curDesc");
        p.h(arrayList, "atStringInfoList");
        ArrayList arrayList2 = new ArrayList();
        if (!Util.isNullOrNil(str)) {
            int i4 = 0;
            int i5 = -1;
            List<b> awk = awk(str);
            while (true) {
                if (i4 >= str.length()) {
                    AppMethodBeat.o(253550);
                    break;
                }
                int charCount = Character.charCount(str.codePointAt(i4));
                for (T t : awk) {
                    if (i4 == t.start) {
                        i3 = t.count;
                    } else {
                        i3 = charCount;
                    }
                    charCount = i3;
                }
                char charAt = str.charAt(i4);
                int length = str.length();
                if (charCount == 1 && A(charAt) && i5 < 0) {
                    i5 = i4;
                } else if (charCount != 1 || !a(Character.valueOf(charAt)) || i5 < 0) {
                    if (i4 + charCount == length) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z && i5 >= 0) {
                        int i6 = i5 + 1;
                        Iterator<d.a> it = arrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z2 = false;
                                break;
                            }
                            int i7 = it.next().start;
                            if (i6 <= i7 && i4 > i7) {
                                z2 = true;
                                break;
                            }
                        }
                        if (!z2) {
                            String substring = str.substring(i6, i4 + charCount);
                            p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            arrayList2.add(new c(i6, (i4 - i6) + charCount, substring));
                            if (mVar != null) {
                                mVar.invoke(Integer.valueOf(i5), Integer.valueOf(i4 + charCount));
                            }
                            int size = arrayList2.size();
                            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                            if (size >= com.tencent.mm.plugin.finder.storage.c.dsC().value().intValue()) {
                                AppMethodBeat.o(253550);
                                break;
                            }
                        }
                    }
                    i5 = i5;
                } else {
                    if (i4 - i5 > 1) {
                        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                        String substring2 = str.substring(i5 + 1, i4);
                        p.g(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        i2 = f.dp(com.tencent.mm.plugin.finder.storage.c.dsN().value().intValue() * 2, substring2);
                    } else {
                        i2 = -1;
                    }
                    if (i2 >= 0) {
                        int i8 = i5 + 1;
                        Iterator<d.a> it2 = arrayList.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z3 = false;
                                break;
                            }
                            int i9 = it2.next().start;
                            if (i8 <= i9 && i4 > i9) {
                                z3 = true;
                                break;
                            }
                        }
                        if (!z3) {
                            String substring3 = str.substring(i8, i4);
                            p.g(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            arrayList2.add(new c(i8, i4 - i8, substring3));
                            if (mVar != null) {
                                mVar.invoke(Integer.valueOf(i5), Integer.valueOf(i4));
                            }
                            int size2 = arrayList2.size();
                            com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
                            if (size2 >= com.tencent.mm.plugin.finder.storage.c.dsC().value().intValue()) {
                                AppMethodBeat.o(253550);
                                break;
                            }
                        }
                    }
                    i5 = A(charAt) ? i4 : -1;
                }
                i4 += charCount;
            }
        } else {
            AppMethodBeat.o(253550);
        }
        return arrayList2;
    }

    private static List<b> awk(String str) {
        int i2;
        AppMethodBeat.i(167919);
        p.h(str, "curDesc");
        SpannableString c2 = l.c(MMApplicationContext.getContext(), str);
        ImageSpan[] imageSpanArr = (ImageSpan[]) c2.getSpans(0, c2.length(), ImageSpan.class);
        ArrayList arrayList = new ArrayList();
        p.g(imageSpanArr, "smileySpanList");
        for (ImageSpan imageSpan : imageSpanArr) {
            int spanStart = c2.getSpanStart(imageSpan);
            int spanEnd = c2.getSpanEnd(imageSpan);
            int spanFlags = c2.getSpanFlags(imageSpan);
            if ((spanFlags & 18) != 0) {
                i2 = (spanEnd - spanStart) + 1;
            } else if ((spanFlags & 17) != 0) {
                i2 = spanEnd - spanStart;
            } else if ((spanFlags & 34) != 0) {
                i2 = spanEnd - spanStart;
                spanStart++;
            } else if ((spanFlags & 33) != 0) {
                i2 = (spanEnd - spanStart) - 1;
                spanStart++;
            } else {
                i2 = 0;
                spanStart = -1;
            }
            if (spanStart >= 0 && i2 > 0) {
                arrayList.add(new b(spanStart, i2));
            }
        }
        AppMethodBeat.o(167919);
        return arrayList;
    }

    private static boolean A(char c2) {
        return c2 == vXo;
    }

    private static boolean a(Character ch) {
        AppMethodBeat.i(253551);
        if (ch == null) {
            AppMethodBeat.o(253551);
            return false;
        }
        String valueOf = String.valueOf(ch.charValue());
        Iterator<T> it = vVe.iterator();
        while (it.hasNext()) {
            if (it.next().aJ(valueOf)) {
                AppMethodBeat.o(253551);
                return true;
            }
        }
        AppMethodBeat.o(253551);
        return false;
    }

    public static /* synthetic */ String dO(String str, int i2) {
        AppMethodBeat.i(167924);
        String dN = dN(str, i2);
        AppMethodBeat.o(167924);
        return dN;
    }

    private static String dN(String str, int i2) {
        String str2;
        AppMethodBeat.i(167923);
        p.h(str, "topic");
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            if (i2 == 2) {
                List b2 = n.b(str, new String[]{"·"});
                if (b2 == null || (str2 = (String) b2.get(0)) == null) {
                    str2 = "";
                }
                jSONObject.put("topic", str2);
            } else {
                jSONObject.put("topic", str);
            }
            jSONObject.put("type", i2);
            jSONObject.put("count", 0L);
            jSONArray.put(jSONObject);
        } catch (Exception e2) {
        }
        String str3 = n.j(z(str, i2, 0), ",", ";", false) + ",,,";
        AppMethodBeat.o(167923);
        return str3;
    }

    public static String z(String str, int i2, long j2) {
        String str2;
        AppMethodBeat.i(167925);
        p.h(str, "topic");
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            if (i2 == 2) {
                List b2 = n.b(str, new String[]{"·"});
                if (b2 == null || (str2 = (String) b2.get(0)) == null) {
                    str2 = "";
                }
                jSONObject.put("topic", str2);
            } else {
                jSONObject.put("topic", str);
            }
            jSONObject.put("type", i2);
            jSONObject.put("count", j2);
            jSONArray.put(jSONObject);
        } catch (Exception e2) {
        }
        String jSONArray2 = jSONArray.toString();
        p.g(jSONArray2, "reportArray.toString()");
        AppMethodBeat.o(167925);
        return jSONArray2;
    }

    public static String z(FinderItem finderItem) {
        String str;
        FinderObjectDesc finderObjectDesc;
        axt axt;
        String str2;
        bdq bdq;
        AppMethodBeat.i(167926);
        p.h(finderItem, "finderItem");
        FinderObjectDesc finderObjectDesc2 = finderItem.getFeedObject().objectDesc;
        if (finderObjectDesc2 == null || (bdq = finderObjectDesc2.topic) == null || (str = bdq.LNs) == null) {
            str = "";
        }
        Map<String, String> parseXml = XmlParser.parseXml(str, "finder", null);
        if (parseXml == null) {
            AppMethodBeat.o(167926);
            return "[]";
        }
        StringBuilder sb = new StringBuilder(".");
        t tVar = t.vWZ;
        StringBuilder append = sb.append(t.dCl()).append('.');
        t tVar2 = t.vWZ;
        int i2 = Util.getInt(parseXml.get(append.append(t.dCm()).toString()), -1);
        if (i2 < 0) {
            AppMethodBeat.o(167926);
            return "[]";
        }
        JSONArray jSONArray = new JSONArray();
        for (int i3 = 0; i3 < i2; i3++) {
            StringBuilder sb2 = new StringBuilder(".");
            t tVar3 = t.vWZ;
            StringBuilder append2 = sb2.append(t.dCl()).append('.');
            t tVar4 = t.vWZ;
            StringBuilder append3 = append2.append(t.dCn()).append(i3).append('.');
            t tVar5 = t.vWZ;
            String str3 = parseXml.get(append3.append(t.dCo()).toString());
            if (!Util.isNullOrNil(str3)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("topic", str3);
                    jSONObject.put("type", 1);
                    jSONObject.put("count", 0);
                    jSONArray.put(jSONObject);
                } catch (Exception e2) {
                }
            }
        }
        FinderObject feedObject = finderItem.getFeedObject();
        if (!(feedObject == null || (finderObjectDesc = feedObject.objectDesc) == null || (axt = finderObjectDesc.location) == null || (str2 = axt.fuK) == null)) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("topic", str2);
                jSONObject2.put("type", 2);
                jSONObject2.put("count", 0);
                jSONArray.put(jSONObject2);
            } catch (Exception e3) {
                x xVar = x.SXb;
            }
        }
        String jSONArray2 = jSONArray.toString();
        p.g(jSONArray2, "reportArray.toString()");
        AppMethodBeat.o(167926);
        return jSONArray2;
    }

    public static String a(cng cng) {
        String str;
        coc coc;
        String str2;
        AppMethodBeat.i(253552);
        p.h(cng, "megaVideo");
        cnl cnl = cng.MtG;
        if (cnl == null || (str = cnl.MtR) == null) {
            str = "";
        }
        Map<String, String> parseXml = XmlParser.parseXml(str, "finder", null);
        if (parseXml == null) {
            AppMethodBeat.o(253552);
            return "[]";
        }
        StringBuilder sb = new StringBuilder(".");
        t tVar = t.vWZ;
        StringBuilder append = sb.append(t.dCl()).append('.');
        t tVar2 = t.vWZ;
        int i2 = Util.getInt(parseXml.get(append.append(t.dCm()).toString()), -1);
        if (i2 < 0) {
            AppMethodBeat.o(253552);
            return "[]";
        }
        JSONArray jSONArray = new JSONArray();
        for (int i3 = 0; i3 < i2; i3++) {
            StringBuilder sb2 = new StringBuilder(".");
            t tVar3 = t.vWZ;
            StringBuilder append2 = sb2.append(t.dCl()).append('.');
            t tVar4 = t.vWZ;
            StringBuilder append3 = append2.append(t.dCn()).append(i3).append('.');
            t tVar5 = t.vWZ;
            String str3 = parseXml.get(append3.append(t.dCo()).toString());
            if (!Util.isNullOrNil(str3)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("topic", str3);
                    jSONObject.put("type", 1);
                    jSONObject.put("count", 0);
                    jSONArray.put(jSONObject);
                } catch (Exception e2) {
                }
            }
        }
        cnl cnl2 = cng.MtG;
        if (!(cnl2 == null || (coc = cnl2.MtS) == null || (str2 = coc.fuK) == null)) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("topic", str2);
                jSONObject2.put("type", 2);
                jSONObject2.put("count", 0);
                jSONArray.put(jSONObject2);
            } catch (Exception e3) {
                x xVar = x.SXb;
            }
        }
        String jSONArray2 = jSONArray.toString();
        p.g(jSONArray2, "reportArray.toString()");
        AppMethodBeat.o(253552);
        return jSONArray2;
    }

    public static final class a {
        public WeakReference<Context> aWF;
        final long feedId;
        final int tvC;

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
            if (kotlin.g.b.p.j(r5.aWF, r6.aWF) != false) goto L_0x0026;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r6) {
            /*
                r5 = this;
                r4 = 253549(0x3de6d, float:3.55298E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                if (r5 == r6) goto L_0x0026
                boolean r0 = r6 instanceof com.tencent.mm.plugin.finder.utils.w.a
                if (r0 == 0) goto L_0x002b
                com.tencent.mm.plugin.finder.utils.w$a r6 = (com.tencent.mm.plugin.finder.utils.w.a) r6
                long r0 = r5.feedId
                long r2 = r6.feedId
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 != 0) goto L_0x002b
                int r0 = r5.tvC
                int r1 = r6.tvC
                if (r0 != r1) goto L_0x002b
                java.lang.ref.WeakReference<android.content.Context> r0 = r5.aWF
                java.lang.ref.WeakReference<android.content.Context> r1 = r6.aWF
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x002b
            L_0x0026:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            L_0x002a:
                return r0
            L_0x002b:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                goto L_0x002a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.utils.w.a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(253548);
            long j2 = this.feedId;
            int i2 = ((((int) (j2 ^ (j2 >>> 32))) * 31) + this.tvC) * 31;
            WeakReference<Context> weakReference = this.aWF;
            int hashCode = (weakReference != null ? weakReference.hashCode() : 0) + i2;
            AppMethodBeat.o(253548);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(167910);
            String str = "ClickExtra(feedId=" + this.feedId + ", topicType=" + this.tvC + ", contextRef=" + this.aWF + ")";
            AppMethodBeat.o(167910);
            return str;
        }

        public /* synthetic */ a(long j2) {
            this(j2, 1, null);
        }

        public a(long j2, int i2, WeakReference<Context> weakReference) {
            this.feedId = j2;
            this.tvC = i2;
            this.aWF = weakReference;
        }
    }

    public static void a(String str, Long l, a aVar) {
        Context context;
        Context context2;
        AppMethodBeat.i(167928);
        p.h(str, "topic");
        p.h(aVar, "clickExtra");
        Intent intent = new Intent();
        intent.putExtra("key_topic_type", 1);
        intent.putExtra("key_topic_title", str);
        intent.putExtra("key_ref_object_id", l);
        WeakReference<Context> weakReference = aVar.aWF;
        if (!(weakReference == null || (context2 = weakReference.get()) == null)) {
            FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
            p.g(context2, LocaleUtil.ITALIAN);
            FinderReporterUIC.a.a(context2, intent, 0, 0, false, 124);
        }
        a aVar3 = a.vUU;
        Context context3 = MMApplicationContext.getContext();
        p.g(context3, "MMApplicationContext.getContext()");
        a.O(context3, intent);
        Log.i(TAG, "onclick topic:".concat(String.valueOf(str)));
        WeakReference<Context> weakReference2 = aVar.aWF;
        if (weakReference2 == null || (context = weakReference2.get()) == null) {
            AppMethodBeat.o(167928);
            return;
        }
        FinderReporterUIC.a aVar4 = FinderReporterUIC.wzC;
        p.g(context, "context");
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
        if (fH != null) {
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.a(aVar.feedId, str, aVar.tvC, fH.tCE);
            com.tencent.mm.plugin.finder.event.a b2 = FinderReporterUIC.b(fH);
            if (b2 != null) {
                b2.cZR().Ey(aVar.feedId);
                AppMethodBeat.o(167928);
                return;
            }
            AppMethodBeat.o(167928);
            return;
        }
        AppMethodBeat.o(167928);
    }

    public static void a(azr azr, Long l, int i2) {
        String str;
        boolean z;
        azk azk;
        azk azk2;
        String str2 = null;
        AppMethodBeat.i(253553);
        Intent intent = new Intent();
        if (azr == null) {
            azr = new azr();
            azr.LJw = 1;
        }
        intent.putExtra("key_topic_type", 4);
        String str3 = (azr == null || (azk2 = azr.musicInfo) == null) ? null : azk2.name;
        if (!(str3 == null || str3.length() == 0)) {
            if (!(azr == null || (azk = azr.musicInfo) == null)) {
                str2 = azk.name;
            }
            intent.putExtra("key_topic_title", str2);
        } else {
            e.a aVar = e.vFX;
            FinderItem Fy = e.a.Fy(l != null ? l.longValue() : 0);
            if (Fy != null) {
                str2 = Fy.getNickName();
            }
            intent.putExtra("key_topic_title", MMApplicationContext.getContext().getString(R.string.coo, str2));
        }
        if (azr != null) {
            String str4 = azr.groupId;
            if (str4 == null || str4.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                str = azr.groupId;
                if (str == null) {
                    str = "";
                }
                intent.putExtra("KEY_FOLLOW_ID", str);
                intent.putExtra("key_ref_object_id", l);
                intent.putExtra("KEY_TAB_TYPE", i2);
                a aVar2 = a.vUU;
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                a.O(context, intent);
                AppMethodBeat.o(253553);
            }
        }
        str = com.tencent.mm.ac.d.zs(l != null ? l.longValue() : -1);
        intent.putExtra("KEY_FOLLOW_ID", str);
        intent.putExtra("key_ref_object_id", l);
        intent.putExtra("KEY_TAB_TYPE", i2);
        a aVar22 = a.vUU;
        Context context2 = MMApplicationContext.getContext();
        p.g(context2, "MMApplicationContext.getContext()");
        a.O(context2, intent);
        AppMethodBeat.o(253553);
    }

    public static void a(SpannableString spannableString, boolean z) {
        AppMethodBeat.i(167930);
        p.h(spannableString, "desc");
        if (Util.isNullOrNil(spannableString)) {
            AppMethodBeat.o(167930);
            return;
        }
        com.tencent.mm.plugin.finder.view.l[] lVarArr = (com.tencent.mm.plugin.finder.view.l[]) spannableString.getSpans(0, spannableString.length(), com.tencent.mm.plugin.finder.view.l.class);
        if (lVarArr != null && lVarArr.length > 0) {
            if (z) {
                for (com.tencent.mm.plugin.finder.view.l lVar : lVarArr) {
                    lVar.sYU = true;
                    Context context = MMApplicationContext.getContext();
                    p.g(context, "MMApplicationContext.getContext()");
                    int color = context.getResources().getColor(R.color.x0);
                    Context context2 = MMApplicationContext.getContext();
                    p.g(context2, "MMApplicationContext.getContext()");
                    lVar.setColor(color, context2.getResources().getColor(R.color.BW_0_Alpha_0_2));
                }
                AppMethodBeat.o(167930);
                return;
            }
            for (com.tencent.mm.plugin.finder.view.l lVar2 : lVarArr) {
                lVar2.sYU = false;
                Context context3 = MMApplicationContext.getContext();
                p.g(context3, "MMApplicationContext.getContext()");
                lVar2.setColor(context3.getResources().getColor(R.color.a2x), 0);
            }
        }
        AppMethodBeat.o(167930);
    }

    public static void a(SpannableString spannableString, boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(253554);
        p.h(spannableString, "desc");
        if (Util.isNullOrNil(spannableString)) {
            AppMethodBeat.o(253554);
            return;
        }
        com.tencent.mm.plugin.finder.view.l[] lVarArr = (com.tencent.mm.plugin.finder.view.l[]) spannableString.getSpans(0, spannableString.length(), com.tencent.mm.plugin.finder.view.l.class);
        if (lVarArr != null) {
            if (!(lVarArr.length == 0)) {
                if (z) {
                    for (com.tencent.mm.plugin.finder.view.l lVar : lVarArr) {
                        lVar.sYU = true;
                        lVar.setColor(i2, i3);
                    }
                    AppMethodBeat.o(253554);
                    return;
                }
                for (com.tencent.mm.plugin.finder.view.l lVar2 : lVarArr) {
                    lVar2.sYU = false;
                    lVar2.setColor(i4, i5);
                }
            }
        }
        AppMethodBeat.o(253554);
    }
}
