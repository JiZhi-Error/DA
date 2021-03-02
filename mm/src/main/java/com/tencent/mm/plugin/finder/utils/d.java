package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.Intent;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.FinderPostAtUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.atx;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.protocal.protobuf.cjn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.i;
import kotlin.n.k;
import kotlin.n.n;
import kotlin.o;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001HB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bJ\u0014\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bJ\u0016\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0004J\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020'J \u0010(\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020'J\"\u0010-\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u00102\b\u0010.\u001a\u0004\u0018\u00010\u0010J(\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u00102\u0006\u00101\u001a\u00020*2\u0006\u0010,\u001a\u00020'2\u0006\u0010)\u001a\u00020*H\u0002J \u00102\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u00102\u0006\u00101\u001a\u00020*2\u0006\u0010)\u001a\u00020*H\u0002J\u0001\u00103\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002050\t042\u0006\u00106\u001a\u00020\u00102\"\u00107\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001c0\u0015j\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001c`\u00172M\u00108\u001aI\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(=\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u001e\u0018\u000109Ju\u0010>\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002050\t042\u0006\u00106\u001a\u00020\u00102M\u00108\u001aI\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(=\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u001e\u0018\u000109J\u000e\u0010?\u001a\u00020\u00162\u0006\u0010@\u001a\u00020\u001cJ\u0010\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020\u001cJ\u0010\u0010D\u001a\u0004\u0018\u00010\u001c2\u0006\u0010C\u001a\u00020BJ\u000e\u0010D\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020FJ\u0010\u0010D\u001a\u0004\u0018\u00010\u001c2\u0006\u0010C\u001a\u00020\u0016J\u000e\u0010G\u001a\u00020F2\u0006\u0010C\u001a\u00020\u001cR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R1\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015j\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0016`\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006I"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil;", "", "()V", "AT_SOME_ONE_NO_COUNT_LIMIT", "", "AT_SOME_ONE_PREFIX_CHAR", "", "AT_SOME_ONE_SUFFIX_CHAR", "END_CHARS_REG", "Ljava/util/ArrayList;", "Lkotlin/text/Regex;", "getEND_CHARS_REG", "()Ljava/util/ArrayList;", "setEND_CHARS_REG", "(Ljava/util/ArrayList;)V", "FINDER_AT_MMKV", "", "FINDER_AT_MMKV_RECENT_AT", "SIGNATURE_AT_SOME_ONE_SUFFIX_CHAR", "TAG", "nicknameToContactMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "Lkotlin/collections/HashMap;", "getNicknameToContactMap", "()Ljava/util/HashMap;", "_readRecentAt", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "_writeRecentAt", "", "atContacts", "findEndIndex", "content", "startIndex", "getMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getReportAtContent", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "jumpAtProfileUI", "context", "Landroid/content/Context;", "nickname", "feedObject", "jumpAtProfileUIOfSignature", "fromProfileUsername", "jumpContinue", ch.COL_USERNAME, LocaleUtil.ITALIAN, "jumpContinueOfSignature", "parseDesc", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "sendContent", "atContactMap", "onSetAtSpan", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "start", "end", "parseDescOfSignature", "transformToFinderContact", "lcontact", "transformToLocalContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "contact", "transformToLocalFinderAtContact", "contactParcel", "Lcom/tencent/mm/plugin/finder/utils/LocalFinderAtContactParcel;", "transformToLocalFinderAtContactParcel", "AtStringInfo", "plugin-finder_release"})
public final class d {
    public static final String TAG = TAG;
    private static ArrayList<k> vVe;
    public static final HashMap<String, FinderContact> vVf = new HashMap<>();
    public static final d vVg = new d();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "o1", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "kotlin.jvm.PlatformType", "o2", "compare"})
    public static final class b<T> implements Comparator<cjj> {
        public static final b vVj = new b();

        static {
            AppMethodBeat.i(253365);
            AppMethodBeat.o(253365);
        }

        b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(cjj cjj, cjj cjj2) {
            AppMethodBeat.i(253364);
            int compare = Long.compare(cjj2.wal, cjj.wal);
            AppMethodBeat.o(253364);
            return compare;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetUserResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class c<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ Context $context;
        final /* synthetic */ FinderItem vST;
        final /* synthetic */ String vVk;

        c(String str, Context context, FinderItem finderItem) {
            this.vVk = str;
            this.$context = context;
            this.vST = finderItem;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            String str;
            String str2;
            AppMethodBeat.i(253366);
            c.a aVar = (c.a) obj;
            if (aVar.errType == 0 && aVar.errCode == 0) {
                LinkedList<FinderContact> linkedList = ((atx) aVar.iLC).LCI;
                p.g(linkedList, "it.resp.contactList");
                FinderContact finderContact = (FinderContact) j.kt(linkedList);
                if (finderContact == null || (str2 = finderContact.username) == null) {
                    str = "";
                } else {
                    str = str2;
                }
                p.g(str, "it.resp.contactList.firstOrNull()?.username ?: \"\"");
                d dVar = d.vVg;
                String str3 = this.vVk;
                LinkedList<FinderContact> linkedList2 = ((atx) aVar.iLC).LCI;
                p.g(linkedList2, "it.resp.contactList");
                d.dBz().put(str3, j.kt(linkedList2));
                if (!Util.isNullOrNil(str)) {
                    d dVar2 = d.vVg;
                    d.b(str, this.$context, this.vST, this.$context);
                } else {
                    d dVar3 = d.vVg;
                    Log.i(d.TAG, "username nil");
                    u.makeText(this.$context, (int) R.string.ci1, 0).show();
                }
            } else {
                d dVar4 = d.vVg;
                Log.i(d.TAG, "cgi failed.");
            }
            x xVar = x.SXb;
            AppMethodBeat.o(253366);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetUserResponse;", "kotlin.jvm.PlatformType", "call"})
    /* renamed from: com.tencent.mm.plugin.finder.utils.d$d  reason: collision with other inner class name */
    public static final class C1314d<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ Context $context;
        final /* synthetic */ String vVk;
        final /* synthetic */ String vVl;

        public C1314d(String str, Context context, String str2) {
            this.vVk = str;
            this.$context = context;
            this.vVl = str2;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            String str;
            String str2;
            AppMethodBeat.i(253367);
            c.a aVar = (c.a) obj;
            if (aVar.errType == 0 && aVar.errCode == 0) {
                LinkedList<FinderContact> linkedList = ((atx) aVar.iLC).LCI;
                p.g(linkedList, "it.resp.contactList");
                FinderContact finderContact = (FinderContact) j.kt(linkedList);
                if (finderContact == null || (str2 = finderContact.username) == null) {
                    str = "";
                } else {
                    str = str2;
                }
                p.g(str, "it.resp.contactList.firstOrNull()?.username ?: \"\"");
                d dVar = d.vVg;
                String str3 = this.vVk;
                LinkedList<FinderContact> linkedList2 = ((atx) aVar.iLC).LCI;
                p.g(linkedList2, "it.resp.contactList");
                d.dBz().put(str3, j.kt(linkedList2));
                if (!Util.isNullOrNil(str)) {
                    d dVar2 = d.vVg;
                    d.f(str, this.$context);
                    h hVar = h.INSTANCE;
                    StringBuilder append = new StringBuilder("0,2,").append(this.vVk).append(",1,");
                    String str4 = this.vVl;
                    if (str4 == null) {
                        str4 = "";
                    }
                    hVar.kvStat(21172, append.append(str4).toString());
                } else {
                    d dVar3 = d.vVg;
                    Log.i(d.TAG, "username nil");
                    u.makeText(this.$context, (int) R.string.ci1, 0).show();
                    h hVar2 = h.INSTANCE;
                    StringBuilder append2 = new StringBuilder("0,2,").append(this.vVk).append(",2,");
                    String str5 = this.vVl;
                    if (str5 == null) {
                        str5 = "";
                    }
                    hVar2.kvStat(21172, append2.append(str5).toString());
                }
            } else {
                d dVar4 = d.vVg;
                Log.i(d.TAG, "cgi failed.");
            }
            x xVar = x.SXb;
            AppMethodBeat.o(253367);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(253383);
        ArrayList<k> arrayList = new ArrayList<>();
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        Iterator<T> it = com.tencent.mm.plugin.finder.storage.c.dvu().iterator();
        while (it.hasNext()) {
            arrayList.add(new k((String) it.next()));
        }
        vVe = arrayList;
        AppMethodBeat.o(253383);
    }

    private d() {
    }

    public static final /* synthetic */ void b(String str, Context context, FinderItem finderItem, Context context2) {
        AppMethodBeat.i(253384);
        a(str, context, finderItem, context2);
        AppMethodBeat.o(253384);
    }

    public static final /* synthetic */ void f(String str, Context context) {
        AppMethodBeat.i(253385);
        e(str, context);
        AppMethodBeat.o(253385);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "", "start", "", "end", "atNickname", "", "finderContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "(IILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderContact;)V", "getAtNickname", "()Ljava/lang/String;", "getEnd", "()I", "getFinderContact", "()Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getStart", "component1", "component2", "component3", "component4", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-finder_release"})
    public static final class a {
        final int end;
        final int start;
        final String vVh;
        private final FinderContact vVi;

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
            if (kotlin.g.b.p.j(r3.vVi, r4.vVi) != false) goto L_0x002e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 253363(0x3ddb3, float:3.55037E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x002e
                boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.utils.d.a
                if (r0 == 0) goto L_0x0033
                com.tencent.mm.plugin.finder.utils.d$a r4 = (com.tencent.mm.plugin.finder.utils.d.a) r4
                int r0 = r3.start
                int r1 = r4.start
                if (r0 != r1) goto L_0x0033
                int r0 = r3.end
                int r1 = r4.end
                if (r0 != r1) goto L_0x0033
                java.lang.String r0 = r3.vVh
                java.lang.String r1 = r4.vVh
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0033
                com.tencent.mm.protocal.protobuf.FinderContact r0 = r3.vVi
                com.tencent.mm.protocal.protobuf.FinderContact r1 = r4.vVi
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0033
            L_0x002e:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0032:
                return r0
            L_0x0033:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0032
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.utils.d.a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(253362);
            int i3 = ((this.start * 31) + this.end) * 31;
            String str = this.vVh;
            int hashCode = ((str != null ? str.hashCode() : 0) + i3) * 31;
            FinderContact finderContact = this.vVi;
            if (finderContact != null) {
                i2 = finderContact.hashCode();
            }
            int i4 = hashCode + i2;
            AppMethodBeat.o(253362);
            return i4;
        }

        public final String toString() {
            AppMethodBeat.i(253361);
            String str = "AtStringInfo(start=" + this.start + ", end=" + this.end + ", atNickname=" + this.vVh + ", finderContact=" + this.vVi + ")";
            AppMethodBeat.o(253361);
            return str;
        }

        public /* synthetic */ a(int i2, int i3, String str) {
            this(i2, i3, str, new FinderContact());
            AppMethodBeat.i(253360);
            AppMethodBeat.o(253360);
        }

        public a(int i2, int i3, String str, FinderContact finderContact) {
            p.h(str, "atNickname");
            p.h(finderContact, "finderContact");
            AppMethodBeat.i(253359);
            this.start = i2;
            this.end = i3;
            this.vVh = str;
            this.vVi = finderContact;
            AppMethodBeat.o(253359);
        }
    }

    public static o<ArrayList<cjj>, ArrayList<a>> a(String str, HashMap<String, cjj> hashMap, q<? super Integer, ? super Integer, ? super String, x> qVar) {
        int a2;
        AppMethodBeat.i(253368);
        p.h(str, "sendContent");
        p.h(hashMap, "atContactMap");
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Util.isNullOrNil(str)) {
            o<ArrayList<cjj>, ArrayList<a>> oVar = new o<>(arrayList, arrayList2);
            AppMethodBeat.o(253368);
            return oVar;
        }
        LinkedList<String> linkedList = new LinkedList();
        int i2 = 0;
        while (i2 < str.length() && (a2 = n.a((CharSequence) str, '@', i2, false, 4)) != -1 && a2 < str.length() - 1) {
            i2 = dL(str, a2 + 1);
            if (i2 == -1) {
                i2 = str.length();
            }
            if (i2 - a2 > 1) {
                String substring = str.substring(a2 + 1, i2);
                p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                linkedList.add(substring);
                if (qVar != null) {
                    qVar.d(Integer.valueOf(a2), Integer.valueOf(i2), substring);
                }
                arrayList2.add(new a(a2, i2, substring));
            }
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dsT().value().intValue() != 1000) {
                int size = arrayList2.size();
                com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (size >= com.tencent.mm.plugin.finder.storage.c.dsT().value().intValue()) {
                    break;
                }
            }
        }
        Log.i(TAG, "after split @ :%s", linkedList);
        if (linkedList.size() <= 0) {
            o<ArrayList<cjj>, ArrayList<a>> oVar2 = new o<>(arrayList, arrayList2);
            AppMethodBeat.o(253368);
            return oVar2;
        } else if (linkedList.size() > 0) {
            int i3 = 0;
            for (String str2 : linkedList) {
                if (hashMap.containsKey(str2)) {
                    cjj cjj = hashMap.get(str2);
                    if (cjj != null) {
                        cjj cjj2 = new cjj();
                        cjj2.username = cjj.username;
                        cjj2.kog = cjj.kog;
                        cjj2.nickname = cjj.nickname;
                        cjj2.authInfo = cjj.authInfo;
                        cjj2.wal = cjj.wal;
                        cjj2.type = cjj.type;
                        cjj2.index = i3;
                        arrayList.add(cjj2);
                        i3++;
                    }
                } else {
                    cjj cjj3 = new cjj();
                    cjj3.username = "";
                    cjj3.kog = "";
                    cjj3.nickname = str2;
                    cjj3.authInfo = null;
                    cjj3.wal = cl.aWy();
                    cjj3.type = 5;
                    cjj3.index = i3;
                    arrayList.add(cjj3);
                    i3++;
                }
            }
            Log.d(TAG, "[getAtContactList] cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            o<ArrayList<cjj>, ArrayList<a>> oVar3 = new o<>(arrayList, arrayList2);
            AppMethodBeat.o(253368);
            return oVar3;
        } else {
            Log.w(TAG, "list is null or size 0");
            o<ArrayList<cjj>, ArrayList<a>> oVar4 = new o<>(arrayList, arrayList2);
            AppMethodBeat.o(253368);
            return oVar4;
        }
    }

    public static o<ArrayList<cjj>, ArrayList<a>> a(String str, q<? super Integer, ? super Integer, ? super String, x> qVar) {
        int a2;
        AppMethodBeat.i(253369);
        p.h(str, "sendContent");
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Util.isNullOrNil(str)) {
            o<ArrayList<cjj>, ArrayList<a>> oVar = new o<>(arrayList, arrayList2);
            AppMethodBeat.o(253369);
            return oVar;
        }
        LinkedList<String> linkedList = new LinkedList();
        int i2 = 0;
        while (i2 < str.length() && (a2 = n.a((CharSequence) str, '@', i2, false, 4)) != -1 && a2 < str.length() - 1) {
            int dL = dL(str, a2 + 1);
            if (dL == -1) {
                dL = str.length();
            }
            if (dL - a2 > 1) {
                String substring = str.substring(a2 + 1, dL);
                p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                linkedList.add(substring);
                qVar.d(Integer.valueOf(a2), Integer.valueOf(dL), substring);
                arrayList2.add(new a(a2, dL, substring));
            }
            i2 = dL;
        }
        Log.i(TAG, "after split @ :%s", linkedList);
        if (linkedList.size() <= 0) {
            o<ArrayList<cjj>, ArrayList<a>> oVar2 = new o<>(arrayList, arrayList2);
            AppMethodBeat.o(253369);
            return oVar2;
        } else if (linkedList.size() > 0) {
            int i3 = 0;
            for (String str2 : linkedList) {
                cjj cjj = new cjj();
                cjj.username = "";
                cjj.kog = "";
                cjj.nickname = str2;
                cjj.authInfo = null;
                cjj.wal = cl.aWy();
                cjj.type = 5;
                cjj.index = i3;
                arrayList.add(cjj);
                i3++;
            }
            Log.d(TAG, "[getAtContactList] cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            o<ArrayList<cjj>, ArrayList<a>> oVar3 = new o<>(arrayList, arrayList2);
            AppMethodBeat.o(253369);
            return oVar3;
        } else {
            Log.w(TAG, "list is null or size 0");
            o<ArrayList<cjj>, ArrayList<a>> oVar4 = new o<>(arrayList, arrayList2);
            AppMethodBeat.o(253369);
            return oVar4;
        }
    }

    private static int dL(String str, int i2) {
        AppMethodBeat.i(253370);
        p.h(str, "content");
        Iterator<T> it = vVe.iterator();
        int i3 = -1;
        while (it.hasNext()) {
            i p = it.next().p(str, i2);
            if (p != null && (i3 < 0 || p.hMg().SYU < i3)) {
                i3 = p.hMg().SYU;
            }
            i3 = i3;
        }
        AppMethodBeat.o(253370);
        return i3;
    }

    public static LinkedList<cjj> dBy() {
        AppMethodBeat.i(253371);
        byte[] decodeBytes = VQ().decodeBytes("_finder_at_mmkv_recent_at");
        if (decodeBytes != null) {
            if (!(decodeBytes.length == 0)) {
                cjn cjn = new cjn();
                try {
                    cjn.parseFrom(decodeBytes);
                    LinkedList<cjj> linkedList = cjn.LDz;
                    AppMethodBeat.o(253371);
                    return linkedList;
                } catch (IOException e2) {
                    FinderPostAtUI.a aVar = FinderPostAtUI.vME;
                    Log.printErrStackTrace(FinderPostAtUI.TAG, e2, "_readRecentAt, LocalFinderRecentAtContactCache, _read: %s", e2.getMessage());
                    AppMethodBeat.o(253371);
                    return null;
                }
            }
        }
        AppMethodBeat.o(253371);
        return null;
    }

    public static g a(cjj cjj) {
        AppMethodBeat.i(253372);
        p.h(cjj, "contact");
        g gVar = new g();
        gVar.field_username = cjj.username;
        gVar.field_nickname = cjj.nickname;
        String str = cjj.kog;
        if (str == null) {
            str = "";
        }
        gVar.asL(str);
        gVar.field_authInfo = cjj.authInfo;
        AppMethodBeat.o(253372);
        return gVar;
    }

    public static cjj h(g gVar) {
        AppMethodBeat.i(253373);
        p.h(gVar, "contact");
        cjj cjj = new cjj();
        cjj.username = gVar.getUsername();
        cjj.nickname = gVar.getNickname();
        cjj.kog = gVar.cXH();
        cjj.authInfo = gVar.field_authInfo;
        AppMethodBeat.o(253373);
        return cjj;
    }

    public static cjj e(FinderContact finderContact) {
        AppMethodBeat.i(253374);
        p.h(finderContact, "contact");
        cjj cjj = new cjj();
        cjj.username = finderContact.username;
        cjj.nickname = finderContact.nickname;
        cjj.kog = finderContact.headUrl;
        cjj.authInfo = finderContact.authInfo;
        AppMethodBeat.o(253374);
        return cjj;
    }

    public static FinderContact b(cjj cjj) {
        AppMethodBeat.i(253375);
        p.h(cjj, "lcontact");
        FinderContact finderContact = new FinderContact();
        finderContact.username = cjj.username;
        finderContact.headUrl = cjj.kog;
        finderContact.nickname = cjj.nickname;
        finderContact.authInfo = cjj.authInfo;
        AppMethodBeat.o(253375);
        return finderContact;
    }

    public static LocalFinderAtContactParcel c(cjj cjj) {
        byte[] bArr;
        AppMethodBeat.i(253376);
        p.h(cjj, "contact");
        LocalFinderAtContactParcel localFinderAtContactParcel = new LocalFinderAtContactParcel();
        localFinderAtContactParcel.username = cjj.username;
        localFinderAtContactParcel.kog = cjj.kog;
        localFinderAtContactParcel.nickname = cjj.nickname;
        FinderAuthInfo finderAuthInfo = cjj.authInfo;
        if (finderAuthInfo != null) {
            bArr = finderAuthInfo.toByteArray();
        } else {
            bArr = null;
        }
        localFinderAtContactParcel.wak = bArr;
        localFinderAtContactParcel.wal = cjj.wal;
        AppMethodBeat.o(253376);
        return localFinderAtContactParcel;
    }

    public static cjj a(LocalFinderAtContactParcel localFinderAtContactParcel) {
        AppMethodBeat.i(253377);
        p.h(localFinderAtContactParcel, "contactParcel");
        cjj cjj = new cjj();
        cjj.username = localFinderAtContactParcel.username;
        cjj.kog = localFinderAtContactParcel.kog;
        cjj.nickname = localFinderAtContactParcel.nickname;
        byte[] bArr = localFinderAtContactParcel.wak;
        if (bArr != null) {
            try {
                FinderAuthInfo finderAuthInfo = new FinderAuthInfo();
                finderAuthInfo.parseFrom(bArr);
                cjj.authInfo = finderAuthInfo;
            } catch (Exception e2) {
                cjj.authInfo = null;
                Log.e(TAG, "transformToLocalFinderAtContact FinderAuthInfo parseFrom:%s", e2.getMessage());
            }
        }
        cjj.wal = localFinderAtContactParcel.wal;
        AppMethodBeat.o(253377);
        return cjj;
    }

    public static MultiProcessMMKV VQ() {
        AppMethodBeat.i(253378);
        StringBuilder sb = new StringBuilder("_finder_at_mmkv");
        p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(sb.append(com.tencent.mm.kernel.a.getUin()).toString());
        p.g(mmkv, "MultiProcessMMKV.getMMKV…+ MMKernel.account().uin)");
        AppMethodBeat.o(253378);
        return mmkv;
    }

    public static String w(FinderItem finderItem) {
        AppMethodBeat.i(253379);
        p.h(finderItem, "finderItem");
        LinkedList<cjj> linkedList = finderItem.field_postinfo.Mpg;
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<cjj> it = linkedList.iterator();
        while (it.hasNext()) {
            cjj next = it.next();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(FirebaseAnalytics.b.INDEX, next.index);
            jSONObject2.put("type", next.type);
            jSONArray.put(jSONObject2);
        }
        jSONObject.put("atcontent", jSONArray);
        jSONObject.put("num", linkedList.size());
        String jSONObject3 = jSONObject.toString();
        p.g(jSONObject3, "report.toString()");
        AppMethodBeat.o(253379);
        return jSONObject3;
    }

    public static HashMap<String, FinderContact> dBz() {
        return vVf;
    }

    public static void a(Context context, String str, FinderItem finderItem) {
        AppMethodBeat.i(253380);
        p.h(str, "nickname");
        p.h(finderItem, "feedObject");
        if (context != null) {
            if (vVf.containsKey(str)) {
                FinderContact finderContact = vVf.get(str);
                String str2 = finderContact != null ? finderContact.username : null;
                if (Util.isNullOrNil(str2) || str2 == null) {
                    Log.i(TAG, "username nil");
                    u.makeText(context, (int) R.string.ci1, 0).show();
                    AppMethodBeat.o(253380);
                    return;
                }
                a(str2, context, finderItem, context);
                AppMethodBeat.o(253380);
                return;
            }
            new com.tencent.mm.plugin.i.a.j(j.listOf(str)).aYI().g(new c(str, context, finderItem));
        }
        AppMethodBeat.o(253380);
    }

    private static void a(String str, Context context, FinderItem finderItem, Context context2) {
        com.tencent.mm.plugin.finder.event.a b2;
        AppMethodBeat.i(253381);
        Intent intent = new Intent();
        intent.putExtra("finder_username", str);
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC.a.a(context, intent, finderItem.field_id == 0 ? finderItem.getLocalId() : finderItem.field_id, 2, false, 64);
        a aVar2 = a.vUU;
        a.enterFinderProfileUI(context, intent);
        FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
        if (fH != null) {
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.a(fH.dIx(), finderItem, str);
        }
        FinderReporterUIC.a aVar4 = FinderReporterUIC.wzC;
        FinderReporterUIC fH2 = FinderReporterUIC.a.fH(context2);
        if (fH2 == null || (b2 = FinderReporterUIC.b(fH2)) == null) {
            AppMethodBeat.o(253381);
            return;
        }
        b2.cZR().EA(finderItem.getId());
        AppMethodBeat.o(253381);
    }

    public static void e(String str, Context context) {
        AppMethodBeat.i(253382);
        Intent intent = new Intent();
        intent.putExtra("finder_username", str);
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC.a.a(context, intent, 0, 2, false, 64);
        a aVar2 = a.vUU;
        a.enterFinderProfileUI(context, intent);
        AppMethodBeat.o(253382);
    }
}
