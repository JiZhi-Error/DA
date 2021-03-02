package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.utils.d;
import com.tencent.mm.plugin.finder.utils.w;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010$\u001a\u00020%2\n\u0010&\u001a\u00060'j\u0002`(2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020!H\u0002J\u001c\u0010+\u001a\u00020%2\n\u0010&\u001a\u00060'j\u0002`(2\u0006\u0010,\u001a\u00020\u0004H\u0002J$\u0010-\u001a\u00020%2\n\u0010&\u001a\u00060'j\u0002`(2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020!H\u0002J\u0010\u0010.\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002J2\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u00042\"\u00101\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020302j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u000203`4JA\u00105\u001a\u00020%2\u0006\u00106\u001a\u0002072\f\u00108\u001a\b\u0012\u0004\u0012\u00020:092!\u0010;\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020%0<H\u0002J^\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020B2\u0006\u00106\u001a\u0002072\f\u0010C\u001a\b\u0012\u0004\u0012\u00020E0D26\u0010F\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(H\u0012\u0013\u0012\u00110I¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020%0GH\u0002Jh\u0010K\u001a\u0002072\b\u0010&\u001a\u0004\u0018\u00010\u00042\u0006\u0010L\u001a\u0002072\f\u0010C\u001a\b\u0012\u0004\u0012\u00020E0D26\u0010F\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(H\u0012\u0013\u0012\u00110I¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020%0G2\u0006\u0010A\u001a\u00020BH\u0002J¥\u0001\u0010M\u001a\u0002072\b\u0010&\u001a\u0004\u0018\u00010\u00042\u0006\u0010L\u001a\u0002072\u0006\u0010A\u001a\u00020B2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020E0D2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020P0O2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020R0O26\u0010F\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(H\u0012\u0013\u0012\u00110I¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020%0G2!\u0010;\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020%0<R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u000e\u0010\u000b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0006R\u0014\u0010\u001a\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0006R\u0014\u0010\u001c\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0006R\u0014\u0010\u001e\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0006R\u0014\u0010 \u001a\u00020!XD¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006S"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/FinderStyleUtil;", "", "()V", "AT", "", "getAT", "()Ljava/lang/String;", "FINDER", "getFINDER", "STYLE", "getSTYLE", "TAG", "TAG_AT_END", "TAG_AT_START", "TAG_CDATA", "TAG_FINDER_END", "TAG_FINDER_START", "TAG_STYLE_END", "TAG_STYLE_START", "TAG_TOPIC", "TAG_VALUE_COUNT", "TAG_VALUE_END", "TAG_VALUE_START", "TAG_VERSION", "TOPIC", "getTOPIC", "VALUE", "getVALUE", "VALUE_COUNT", "getVALUE_COUNT", "VERSION", "getVERSION", "version", "", "getVersion", "()I", "appendNormalValue", "", "xml", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "count", "appendStyleAt", "atIndexs", "appendTopicValue", "appendVersionValue", "getDescXml", "curDesc", "atContactMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "Lkotlin/collections/HashMap;", "handleAt", "desc", "Landroid/text/SpannableString;", "atContactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "onAtClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", ch.COL_USERNAME, "handleTopic", "feedId", "", "topicInfoList", "", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$TopicStringInfo;", "onTopicClick", "Lkotlin/Function2;", t.vWL, "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "clickExtra", "parseDefatultDesc", "defaultDesc", "parseXml", "atFinderContactList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "mentionedUserList", "Lcom/tencent/mm/protocal/protobuf/FinderMentionedUser;", "plugin-finder_release"})
public final class t {
    private static final String TAG = TAG;
    private static final String VALUE = "value";
    private static final String VERSION = "version";
    private static final String vWI = vWI;
    private static final String vWJ = "style";
    private static final String vWK = vWK;
    private static final String vWL = vWL;
    private static final String vWM = vWM;
    private static final String vWN = ("<" + vWI + '>');
    private static final String vWO = ("</" + vWI + '>');
    private static final String vWP = ("<" + vWJ + '>');
    private static final String vWQ = ("</" + vWJ + '>');
    private static final String vWR = ("<" + vWM + '>');
    private static final String vWS = ("</" + vWM + '>');
    private static final String vWT = vWT;
    private static final String vWU = ("<" + vWK + ">%d</" + vWK + '>');
    private static final String vWV = ("<" + VALUE + "%d>");
    private static final String vWW = ("</" + VALUE + "%d>");
    private static final String vWX = ("<" + vWL + ">%s</" + vWL + '>');
    private static final String vWY = ("<" + VERSION + ">%d</" + VERSION + '>');
    public static final t vWZ = new t();
    private static final int version = 1;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", ch.COL_USERNAME, "", "invoke", "com/tencent/mm/plugin/finder/utils/FinderStyleUtil$handleAt$1$1"})
    public static final class a extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ SpannableString vXa;
        final /* synthetic */ z.d vXb;
        final /* synthetic */ z.d vXc;
        final /* synthetic */ kotlin.g.a.b vXd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(SpannableString spannableString, z.d dVar, z.d dVar2, kotlin.g.a.b bVar) {
            super(1);
            this.vXa = spannableString;
            this.vXb = dVar;
            this.vXc = dVar2;
            this.vXd = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(253524);
            String str2 = str;
            p.h(str2, ch.COL_USERNAME);
            com.tencent.mm.kernel.c.a af = g.af(ad.class);
            p.g(af, "MMKernel.service(IFinder…enModeConfig::class.java)");
            if (!((ad) af).dxX()) {
                this.vXd.invoke(str2);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(253524);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", t.vWL, "", "invoke", "com/tencent/mm/plugin/finder/utils/FinderStyleUtil$handleTopic$1$1"})
    public static final class b extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ SpannableString vXa;
        final /* synthetic */ z.d vXe;
        final /* synthetic */ z.d vXf;
        final /* synthetic */ m vXg;
        final /* synthetic */ long vXh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(SpannableString spannableString, z.d dVar, z.d dVar2, m mVar, long j2) {
            super(1);
            this.vXa = spannableString;
            this.vXe = dVar;
            this.vXf = dVar2;
            this.vXg = mVar;
            this.vXh = j2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(253525);
            String str2 = str;
            p.h(str2, t.vWL);
            com.tencent.mm.kernel.c.a af = g.af(ad.class);
            p.g(af, "MMKernel.service(IFinder…enModeConfig::class.java)");
            if (!((ad) af).dxX()) {
                this.vXg.invoke(str2, new w.a(this.vXh));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(253525);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", t.vWL, "", "invoke", "com/tencent/mm/plugin/finder/utils/FinderStyleUtil$parseDefatultDesc$2$1"})
    public static final class c extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ m vXg;
        final /* synthetic */ long vXh;
        final /* synthetic */ SpannableString vXi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(SpannableString spannableString, m mVar, long j2) {
            super(1);
            this.vXi = spannableString;
            this.vXg = mVar;
            this.vXh = j2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(253526);
            String str2 = str;
            p.h(str2, t.vWL);
            this.vXg.invoke(str2, new w.a(this.vXh));
            x xVar = x.SXb;
            AppMethodBeat.o(253526);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(253533);
        AppMethodBeat.o(253533);
    }

    private t() {
    }

    public static String dCl() {
        return vWI;
    }

    public static String dCm() {
        return vWK;
    }

    public static String dCn() {
        return VALUE;
    }

    public static String dCo() {
        return vWL;
    }

    public static String c(String str, HashMap<String, cjj> hashMap) {
        List<w.c> list;
        d.a aVar;
        int i2;
        w.c cVar;
        AppMethodBeat.i(253527);
        p.h(str, "curDesc");
        p.h(hashMap, "atContactMap");
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(253527);
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.drO()) {
            d dVar = d.vVg;
            arrayList2 = d.a(str, hashMap, (kotlin.g.a.q<? super Integer, ? super Integer, ? super String, x>) null).second;
        }
        com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.drN()) {
            w wVar = w.vXp;
            list = w.a(str, arrayList2, (m<? super Integer, ? super Integer, x>) null);
        } else {
            list = arrayList;
        }
        sb.append(vWN);
        if (!list.isEmpty() || !arrayList2.isEmpty()) {
            int i3 = 0;
            int i4 = 0;
            String str2 = "";
            int i5 = 0;
            while (i4 < str.length()) {
                if (!list.isEmpty()) {
                    int i6 = 0;
                    int size = list.size();
                    while (true) {
                        if (i6 >= size) {
                            break;
                        }
                        cVar = list.get(i6);
                        int i7 = cVar.start - 1;
                        if (i7 != i4) {
                            if (i7 > i4) {
                                break;
                            }
                            i6++;
                        } else {
                            break;
                        }
                    }
                    cVar = null;
                    if (cVar != null) {
                        list.remove(cVar);
                        int i8 = cVar.start - 1;
                        int i9 = cVar.count + i8 + 1;
                        if (i8 >= i5) {
                            if (i8 > i5) {
                                String substring = str.substring(i5, i8);
                                p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                a(sb, substring, i3);
                                i3++;
                            }
                            StringBuilder sb2 = new StringBuilder();
                            String substring2 = str.substring(i8, i9);
                            p.g(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            String sb3 = sb2.append(substring2).append("#").toString();
                            ae aeVar = ae.SYK;
                            String format = String.format(vWV, Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
                            p.g(format, "java.lang.String.format(format, *args)");
                            sb.append(format);
                            ae aeVar2 = ae.SYK;
                            String str3 = vWX;
                            ae aeVar3 = ae.SYK;
                            String format2 = String.format(vWT, Arrays.copyOf(new Object[]{sb3}, 1));
                            p.g(format2, "java.lang.String.format(format, *args)");
                            String format3 = String.format(str3, Arrays.copyOf(new Object[]{format2}, 1));
                            p.g(format3, "java.lang.String.format(format, *args)");
                            sb.append(format3);
                            ae aeVar4 = ae.SYK;
                            String format4 = String.format(vWW, Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
                            p.g(format4, "java.lang.String.format(format, *args)");
                            sb.append(format4);
                            i4 = i9;
                            i5 = i9;
                            i3++;
                        } else {
                            Log.e(TAG, "topicStart:" + i8 + ", startIndex:" + i5);
                        }
                    }
                }
                if (!arrayList2.isEmpty()) {
                    int i10 = 0;
                    int size2 = arrayList2.size();
                    while (true) {
                        if (i10 >= size2) {
                            break;
                        }
                        Object obj = arrayList2.get(i10);
                        p.g(obj, "atContactList[atIndex]");
                        aVar = (d.a) obj;
                        int i11 = aVar.start;
                        if (i11 != i4) {
                            if (i11 > i4) {
                                break;
                            }
                            i10++;
                        } else {
                            break;
                        }
                    }
                    aVar = null;
                    if (aVar != null) {
                        arrayList2.remove(aVar);
                        int i12 = aVar.start;
                        int i13 = aVar.end;
                        if (i12 >= i5) {
                            if (i12 > i5) {
                                String substring3 = str.substring(i5, i12);
                                p.g(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                i2 = i3 + 1;
                                a(sb, substring3, i3);
                            } else {
                                i2 = i3;
                            }
                            StringBuilder sb4 = new StringBuilder();
                            String substring4 = str.substring(i12, i13);
                            p.g(substring4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            i3 = i2 + 1;
                            a(sb, sb4.append(substring4).append(" ").toString(), i2);
                            str2 = str2 + String.valueOf(i3 - 1) + ",";
                            i4 = i13;
                            i5 = i13;
                        } else {
                            Log.e(TAG, "topicStart:" + i12 + ", startIndex:" + i5);
                        }
                    }
                }
                i4++;
            }
            if (i5 < str.length()) {
                String substring5 = str.substring(i5, str.length());
                p.g(substring5, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                a(sb, substring5, i3);
                i3++;
            }
            if (!Util.isNullOrNil(str2)) {
                sb.append(vWP);
                sb.append(vWR);
                int length = str2.length() - 1;
                if (str2 == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(253527);
                    throw tVar;
                }
                String substring6 = str2.substring(0, length);
                p.g(substring6, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb.append(substring6);
                sb.append(vWS);
                sb.append(vWQ);
            }
            ae aeVar5 = ae.SYK;
            String format5 = String.format(vWU, Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
            p.g(format5, "java.lang.String.format(format, *args)");
            p.g(sb.append(format5), "xml.append(String.format(TAG_VALUE_COUNT, count))");
        } else {
            ae aeVar6 = ae.SYK;
            String format6 = String.format(vWU, Arrays.copyOf(new Object[]{1}, 1));
            p.g(format6, "java.lang.String.format(format, *args)");
            sb.append(format6);
            a(sb, str, 0);
        }
        ae aeVar7 = ae.SYK;
        String format7 = String.format(vWY, Arrays.copyOf(new Object[]{Integer.valueOf(version)}, 1));
        p.g(format7, "java.lang.String.format(format, *args)");
        sb.append(format7);
        sb.append(vWO);
        Log.d(TAG, "xml:".concat(String.valueOf(sb)));
        String sb5 = sb.toString();
        p.g(sb5, "xml.toString()");
        AppMethodBeat.o(253527);
        return sb5;
    }

    private static void a(StringBuilder sb, String str, int i2) {
        AppMethodBeat.i(253528);
        ae aeVar = ae.SYK;
        String format = String.format(vWV, Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
        p.g(format, "java.lang.String.format(format, *args)");
        sb.append(format);
        ae aeVar2 = ae.SYK;
        String format2 = String.format(vWT, Arrays.copyOf(new Object[]{str}, 1));
        p.g(format2, "java.lang.String.format(format, *args)");
        sb.append(format2);
        ae aeVar3 = ae.SYK;
        String format3 = String.format(vWW, Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
        p.g(format3, "java.lang.String.format(format, *args)");
        sb.append(format3);
        AppMethodBeat.o(253528);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x004a, code lost:
        if (com.tencent.mm.plugin.finder.storage.c.drO() == false) goto L_0x004c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.text.SpannableString a(java.lang.String r22, android.text.SpannableString r23, long r24, java.util.List<com.tencent.mm.plugin.finder.utils.w.c> r26, java.util.LinkedList<com.tencent.mm.protocal.protobuf.FinderContact> r27, java.util.LinkedList<com.tencent.mm.protocal.protobuf.ayq> r28, kotlin.g.a.m<? super java.lang.String, ? super com.tencent.mm.plugin.finder.utils.w.a, kotlin.x> r29, kotlin.g.a.b<? super java.lang.String, kotlin.x> r30) {
        /*
        // Method dump skipped, instructions count: 1071
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.utils.t.a(java.lang.String, android.text.SpannableString, long, java.util.List, java.util.LinkedList, java.util.LinkedList, kotlin.g.a.m, kotlin.g.a.b):android.text.SpannableString");
    }

    private static void a(long j2, SpannableString spannableString, List<w.c> list, m<? super String, ? super w.a, x> mVar) {
        int color;
        int color2;
        AppMethodBeat.i(253530);
        z.d dVar = new z.d();
        com.tencent.mm.kernel.c.a af = g.af(ad.class);
        p.g(af, "MMKernel.service(IFinder…enModeConfig::class.java)");
        if (((ad) af).dxX()) {
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            color = context.getResources().getColor(R.color.FG_0);
        } else {
            Context context2 = MMApplicationContext.getContext();
            p.g(context2, "MMApplicationContext.getContext()");
            color = context2.getResources().getColor(R.color.Link_80);
        }
        dVar.SYE = color;
        z.d dVar2 = new z.d();
        com.tencent.mm.kernel.c.a af2 = g.af(ad.class);
        p.g(af2, "MMKernel.service(IFinder…enModeConfig::class.java)");
        if (((ad) af2).dxX()) {
            Context context3 = MMApplicationContext.getContext();
            p.g(context3, "MMApplicationContext.getContext()");
            color2 = context3.getResources().getColor(R.color.ac_);
        } else {
            Context context4 = MMApplicationContext.getContext();
            p.g(context4, "MMApplicationContext.getContext()");
            color2 = context4.getResources().getColor(R.color.BW_0_Alpha_0_2);
        }
        dVar2.SYE = color2;
        for (T t : list) {
            String str = t.dST;
            if (str == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(253530);
                throw tVar;
            }
            String substring = str.substring(1);
            p.g(substring, "(this as java.lang.String).substring(startIndex)");
            spannableString.setSpan(new com.tencent.mm.plugin.finder.view.l(substring, dVar.SYE, dVar2.SYE, new b(spannableString, dVar, dVar2, mVar, j2)), t.start, t.count + t.start, 17);
        }
        AppMethodBeat.o(253530);
    }

    private static void a(SpannableString spannableString, ArrayList<d.a> arrayList, kotlin.g.a.b<? super String, x> bVar) {
        int color;
        int color2;
        AppMethodBeat.i(253531);
        z.d dVar = new z.d();
        com.tencent.mm.kernel.c.a af = g.af(ad.class);
        p.g(af, "MMKernel.service(IFinder…enModeConfig::class.java)");
        if (((ad) af).dxX()) {
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            color = context.getResources().getColor(R.color.FG_0);
        } else {
            Context context2 = MMApplicationContext.getContext();
            p.g(context2, "MMApplicationContext.getContext()");
            color = context2.getResources().getColor(R.color.Link_80);
        }
        dVar.SYE = color;
        z.d dVar2 = new z.d();
        com.tencent.mm.kernel.c.a af2 = g.af(ad.class);
        p.g(af2, "MMKernel.service(IFinder…enModeConfig::class.java)");
        if (((ad) af2).dxX()) {
            Context context3 = MMApplicationContext.getContext();
            p.g(context3, "MMApplicationContext.getContext()");
            color2 = context3.getResources().getColor(R.color.ac_);
        } else {
            Context context4 = MMApplicationContext.getContext();
            p.g(context4, "MMApplicationContext.getContext()");
            color2 = context4.getResources().getColor(R.color.BW_0_Alpha_0_2);
        }
        dVar2.SYE = color2;
        for (T t : arrayList) {
            String str = t.vVh;
            if (str == null) {
                str = "";
            }
            spannableString.setSpan(new com.tencent.mm.plugin.finder.view.l(str, dVar.SYE, dVar2.SYE, new a(spannableString, dVar, dVar2, bVar)), t.start, t.end, 17);
        }
        AppMethodBeat.o(253531);
    }

    private static SpannableString a(String str, SpannableString spannableString, List<w.c> list, m<? super String, ? super w.a, x> mVar, long j2) {
        AppMethodBeat.i(253532);
        if (Util.isNullOrNil(str)) {
            w wVar = w.vXp;
            String spannableString2 = spannableString.toString();
            p.g(spannableString2, "defaultDesc.toString()");
            for (T t : w.a(spannableString2, new ArrayList(), (m<? super Integer, ? super Integer, x>) null)) {
                int i2 = t.start - 1;
                if (i2 < 0) {
                    i2 = 0;
                }
                list.add(new w.c(i2, t.count + 1, "#" + t.dST));
            }
            spannableString = SpannableString.valueOf(new SpannableStringBuilder(com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), spannableString.toString())));
            for (T t2 : list) {
                String str2 = t2.dST;
                if (str2 == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(253532);
                    throw tVar;
                }
                String substring = str2.substring(1);
                p.g(substring, "(this as java.lang.String).substring(startIndex)");
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                int color = context.getResources().getColor(R.color.Link_80);
                Context context2 = MMApplicationContext.getContext();
                p.g(context2, "MMApplicationContext.getContext()");
                spannableString.setSpan(new com.tencent.mm.plugin.finder.view.l(substring, color, context2.getResources().getColor(R.color.BW_0_Alpha_0_2), false, true, new c(spannableString, mVar, j2)), t2.start, t2.start + t2.count, 17);
            }
            p.g(spannableString, "ret");
            AppMethodBeat.o(253532);
        } else {
            AppMethodBeat.o(253532);
        }
        return spannableString;
    }
}
