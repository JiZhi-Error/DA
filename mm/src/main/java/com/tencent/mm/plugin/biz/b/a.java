package com.tencent.mm.plugin.biz.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.ahh;
import com.tencent.mm.protocal.protobuf.ahi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u001d\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\nJ \u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u0016\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$J \u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u0011H\u0002J\b\u0010/\u001a\u00020\u0018H\u0002J\u0006\u00100\u001a\u000201J\u001e\u00102\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u001e2\u0006\u0010+\u001a\u00020,J\u0016\u00103\u001a\u0002012\u0006\u00104\u001a\u0002052\u0006\u0010+\u001a\u00020,J\u0018\u00103\u001a\u0002012\b\u0010\u001f\u001a\u0004\u0018\u00010\n2\u0006\u0010+\u001a\u00020,J \u00103\u001a\u0002012\u0006\u00106\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010.\u001a\u00020\u0011H\u0002J\u000e\u00107\u001a\u0002012\u0006\u00108\u001a\u000209J \u0010:\u001a\u0002012\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u0011H\u0002J\f\u0010;\u001a\u00020\b*\u00020\bH\u0002J\f\u0010<\u001a\u00020\b*\u00020\bH\u0002J\f\u0010=\u001a\u00020\b*\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R#\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118FX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006>"}, hxF = {"Lcom/tencent/mm/plugin/biz/util/BizDigestUtil;", "", "()V", "DIGEST_INFO_NO_UPDATE", "", "MILLSECONDS_OF_12HOUR", "", "TAG", "", "clickDigestInfo", "Lcom/tencent/mm/protocal/protobuf/DigestInfo;", "getClickDigestInfo", "()Lcom/tencent/mm/protocal/protobuf/DigestInfo;", "setClickDigestInfo", "(Lcom/tencent/mm/protocal/protobuf/DigestInfo;)V", "isShowBoldDigest", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "showingCustomDigest", "", "getShowingCustomDigest", "()Z", "setShowingCustomDigest", "(Z)V", "getDigestReportInfo", "Lkotlin/Pair;", "digestInfo", "getOfficialAccountsDigest", "", "size", "context", "Landroid/content/Context;", "conv", "Lcom/tencent/mm/storage/Conversation;", "getStartSpannableString", "Landroid/text/SpannableString;", "imgSpanSize", "isMsgDigestShow", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "bold", "slot", "isShowBoldDigestOpen", "onClick", "", "onDigestExpose", "saveDigestInfo", "item", "Lcom/tencent/mm/protocal/protobuf/BizMsgItem;", "key", "setDigestShowCount", "req", "Lcom/tencent/mm/protocal/protobuf/BizMsgReSortReq;", "setMsgDigestShow", "BoldDigestShowKey", "DigestKey", "DigestShowKey", "plugin-biz_release"})
public final class a {
    private static final f iBW = g.ah(C0855a.pfm);
    private static int pfi = -1;
    public static ahh pfj;
    private static boolean pfk;
    public static final a pfl = new a();

    public static MultiProcessMMKV aTI() {
        AppMethodBeat.i(212443);
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) iBW.getValue();
        AppMethodBeat.o(212443);
        return multiProcessMMKV;
    }

    static {
        AppMethodBeat.i(212452);
        AppMethodBeat.o(212452);
    }

    private a() {
    }

    public static String ahe(String str) {
        AppMethodBeat.i(212440);
        String str2 = "digest_" + str + '}';
        AppMethodBeat.o(212440);
        return str2;
    }

    public static String ahf(String str) {
        AppMethodBeat.i(212441);
        String str2 = "digest_show_" + str + '}';
        AppMethodBeat.o(212441);
        return str2;
    }

    public static String ahg(String str) {
        AppMethodBeat.i(212442);
        String str2 = "digest_show_bold_" + str + '}';
        AppMethodBeat.o(212442);
        return str2;
    }

    public static ahh ckr() {
        return pfj;
    }

    public static SpannableString c(int i2, Context context) {
        AppMethodBeat.i(212444);
        p.h(context, "context");
        Drawable drawable = context.getResources().getDrawable(R.drawable.c0a);
        p.g(drawable, "context.resources.getDra…e.biz_timeline_star_icon)");
        drawable.setBounds(0, 0, i2, i2);
        com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(drawable, 1);
        SpannableString spannableString = new SpannableString("@");
        spannableString.setSpan(aVar, 0, 1, 33);
        AppMethodBeat.o(212444);
        return spannableString;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.CharSequence a(int r14, android.content.Context r15, com.tencent.mm.storage.az r16) {
        /*
        // Method dump skipped, instructions count: 502
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.biz.b.a.a(int, android.content.Context, com.tencent.mm.storage.az):java.lang.CharSequence");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static kotlin.o<java.lang.String, java.lang.String> a(com.tencent.mm.storage.z r13) {
        /*
        // Method dump skipped, instructions count: 306
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.biz.b.a.a(com.tencent.mm.storage.z):kotlin.o");
    }

    private static boolean a(z zVar, boolean z, MultiProcessMMKV multiProcessMMKV) {
        AppMethodBeat.i(212447);
        boolean decodeBool = multiProcessMMKV.decodeBool("digest_show_" + z + '_' + zVar.field_msgId + '_' + zVar.field_createTime, false);
        AppMethodBeat.o(212447);
        return decodeBool;
    }

    private static void b(z zVar, boolean z, MultiProcessMMKV multiProcessMMKV) {
        AppMethodBeat.i(212448);
        multiProcessMMKV.encode("digest_show_" + z + '_' + zVar.field_msgId + '_' + zVar.field_createTime, true);
        AppMethodBeat.o(212448);
    }

    public static o<String, String> a(ahh ahh) {
        List<ahi> l;
        AppMethodBeat.i(212449);
        if (ahh == null) {
            o<String, String> oVar = new o<>("", "");
            AppMethodBeat.o(212449);
            return oVar;
        } else if (!pfk) {
            o<String, String> oVar2 = new o<>("", "");
            AppMethodBeat.o(212449);
            return oVar2;
        } else {
            String str = "";
            LinkedList<ahi> linkedList = ahh.KEQ;
            if (!(linkedList == null || (l = j.l(linkedList)) == null)) {
                for (ahi ahi : l) {
                    if (ahi.LqW == 1) {
                        String str2 = str;
                        if (str2 == null || n.aL(str2)) {
                            str = ahi.iAq;
                            p.g(str, "digestItem.digest");
                        } else {
                            str = str + ";" + ahi.iAq;
                        }
                    }
                }
            }
            o<String, String> oVar3 = new o<>(com.tencent.mm.pluginsdk.ui.tools.z.bfG(Util.nullAsNil(ahh.nHe)), com.tencent.mm.pluginsdk.ui.tools.z.bfG(str));
            AppMethodBeat.o(212449);
            return oVar3;
        }
    }

    public static void a(ahh ahh, z zVar) {
        AppMethodBeat.i(212450);
        p.h(zVar, "info");
        if (ahh == null) {
            AppMethodBeat.o(212450);
            return;
        }
        a(ahe(new StringBuilder().append(zVar.field_msgId).append('-').append(zVar.field_createTime).toString()), ahh, (MultiProcessMMKV) c.iNQ.getSlot());
        AppMethodBeat.o(212450);
    }

    public static void a(String str, ahh ahh, MultiProcessMMKV multiProcessMMKV) {
        AppMethodBeat.i(212451);
        try {
            multiProcessMMKV.encode(str, ahh.toByteArray());
            AppMethodBeat.o(212451);
        } catch (Exception e2) {
            Log.e("MicroMsg.BizDigestUtil", "saveWebViewAlbumInfoInfo ex " + e2.getMessage());
            AppMethodBeat.o(212451);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.plugin.biz.b.a$a  reason: collision with other inner class name */
    static final class C0855a extends q implements kotlin.g.a.a<MultiProcessMMKV> {
        public static final C0855a pfm = new C0855a();

        static {
            AppMethodBeat.i(212439);
            AppMethodBeat.o(212439);
        }

        C0855a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MultiProcessMMKV invoke() {
            AppMethodBeat.i(212438);
            MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
            AppMethodBeat.o(212438);
            return singleMMKV;
        }
    }
}
