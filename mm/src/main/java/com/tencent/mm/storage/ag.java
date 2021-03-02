package com.tencent.mm.storage;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.m;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.e;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u001a\u0006\u0010\u000b\u001a\u00020\b\u001a\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n\u001a\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n\u001a\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n\u001a\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u001a\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n\u001a\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u001a\u001e\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n\u001a\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n\u001a\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n\u001a\u0006\u0010\u0019\u001a\u00020\u0012\u001a\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n\u001a\u001e\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\u0006\u0010\u001c\u001a\u00020\u0012\u001a\u001a\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0004\u001a\u0018\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010#\u001a\u00020$\u001aH\u0010%\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010\u00042\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u0012\u001a \u0010.\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0006\u0010/\u001a\u000200\u001a \u00101\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0006\u0010/\u001a\u000200\"\u000e\u0010\u0000\u001a\u00020\u0001X\u000e¢\u0006\u0002\n\u0000\"\u001c\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u000e¢\u0006\u0002\n\u0000\"\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u00062"}, hxF = {"cacheFollowMsgId", "", "cacheFollowValues", "", "", "cacheMsgId", "cacheValues", "checkNewDyeingTemplate", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "checkShowDigesNum", "getArticleUrl", "getDisplayName", "getDyeingDigest", "getDyeingTemplateWord", "Landroid/text/SpannableStringBuilder;", FirebaseAnalytics.b.INDEX, "", "getFollowDisplayName", "getFollowDyeingTemplateWord", "getFollowValue", "getIconUrl", "getItemShowType", "getMsgType", "getUnreadCount", "getUserName", "getValue", "hasOfficialAccountRedDot", "isDyeingTemplateToTimeline", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "msgCluster", "onDyeingTemplateClick", "", "context", "Landroid/content/Context;", "reportMsgNotify", ch.COL_USERNAME, "actionType", "notifyType", "notifyMsgId", "notifyRow", "sessionId", "scene", "enterId", "setFollowMaxLine", "view", "Landroid/widget/TextView;", "setMaxLine", "plugin-biz_release"})
public final class ag {
    private static long NRA;
    private static Map<String, String> NRB;
    private static long NRy;
    private static Map<String, String> NRz;

    public static final boolean d(ca caVar, String str) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(212665);
        if (caVar == null) {
            AppMethodBeat.o(212665);
            return false;
        } else if (!caVar.gDj()) {
            Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "isDyeingTemplateToTimeline isTemplateMsg false");
            AppMethodBeat.o(212665);
            return false;
        } else if (!ab.Jy(str)) {
            Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "isDyeingTemplateToTimeline isMsgClusterNotifyMessage = false");
            AppMethodBeat.o(212665);
            return false;
        } else if (!ab.clc()) {
            Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "isDyeingTemplateToTimeline isBizTimeLineOpen = false");
            AppMethodBeat.o(212665);
            return false;
        } else {
            com.tencent.mm.plugin.expt.b.b bVar = (com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class);
            if (bVar == null || bVar.a(b.a.clicfg_open_dyeing_template_to_timeline, 1) != 1) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "isDyeingTemplateToTimeline open = false");
                AppMethodBeat.o(212665);
                return false;
            }
            Map<String, String> parseXml = XmlParser.parseXml(caVar.getContent(), "msg", null);
            if (parseXml != null) {
                String str2 = parseXml.get(".msg.appmsg.mmreader.notify_msg.act");
                Object[] objArr = new Object[1];
                if (!Util.isNullOrNil(str2)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr[0] = Boolean.valueOf(z2);
                Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "isDyeingTemplateToTimeline notifyMsg = %s", objArr);
                if (!Util.isNullOrNil(str2)) {
                    AppMethodBeat.o(212665);
                    return true;
                }
                AppMethodBeat.o(212665);
                return false;
            }
            Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "isDyeingTemplateToTimeline false");
            AppMethodBeat.o(212665);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0091  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void a(com.tencent.mm.storage.z r7, int r8, android.widget.TextView r9) {
        /*
        // Method dump skipped, instructions count: 162
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.ag.a(com.tencent.mm.storage.z, int, android.widget.TextView):void");
    }

    public static final SpannableStringBuilder h(z zVar, int i2) {
        AppMethodBeat.i(212667);
        p.h(zVar, "info");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Map<String, String> K = K(zVar);
        if (K == null) {
            AppMethodBeat.o(212667);
            return spannableStringBuilder;
        } else if (K == null || !Util.isNullOrNil(K.get(".msg.appmsg.mmreader.notify_msg.act"))) {
            b bVar = new b(K);
            String str = ".msg.appmsg.mmreader.notify_msg.msg.item" + (i2 == 0 ? "" : Integer.valueOf(i2));
            if (!Util.isNullOrNil(K.get(str + ".content"))) {
                spannableStringBuilder.append((CharSequence) bVar.invoke(str));
            }
            AppMethodBeat.o(212667);
            return spannableStringBuilder;
        } else {
            AppMethodBeat.o(212667);
            return spannableStringBuilder;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<no name provided>", "Landroid/text/SpannableString;", "prefix", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.b<String, SpannableString> {
        final /* synthetic */ Map NRx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Map map) {
            super(1);
            this.NRx = map;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ SpannableString invoke(String str) {
            AppMethodBeat.i(212658);
            SpannableString bjd = bjd(str);
            AppMethodBeat.o(212658);
            return bjd;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0047, code lost:
            if (r1 == null) goto L_0x0049;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private android.text.SpannableString bjd(java.lang.String r14) {
            /*
            // Method dump skipped, instructions count: 324
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.ag.b.bjd(java.lang.String):android.text.SpannableString");
        }
    }

    public static final String H(z zVar) {
        String str;
        Map<String, String> map;
        AppMethodBeat.i(212668);
        p.h(zVar, "info");
        a aVar = new a(zVar);
        String str2 = "";
        if (zVar.isText() || zVar.gAz()) {
            map = M(zVar);
            str = ".msgsource.notify_msg.";
        } else if (zVar.gAx()) {
            map = K(zVar);
            str = ".msg.appmsg.mmreader.notify_msg.";
        } else {
            map = null;
            str = null;
        }
        if (map != null && (str2 = map.get(str + "box_digest")) == null) {
            str2 = "";
        }
        if (Util.isNullOrNil(str2) && zVar.gAx()) {
            str2 = (String) aVar.invoke();
        }
        AppMethodBeat.o(212668);
        return str2;
    }

    public static final String I(z zVar) {
        AppMethodBeat.i(212669);
        p.h(zVar, "info");
        String str = "";
        Map<String, String> K = K(zVar);
        if (K == null) {
            AppMethodBeat.o(212669);
        } else {
            if (K != null && (str = K.get(".msg.appmsg.mmreader.notify_msg.publisher_username")) == null) {
                str = "";
            }
            AppMethodBeat.o(212669);
        }
        return str;
    }

    public static final int f(z zVar) {
        int i2;
        AppMethodBeat.i(212670);
        p.h(zVar, "info");
        Map<String, String> K = K(zVar);
        if (K == null) {
            AppMethodBeat.o(212670);
            return 0;
        }
        if (K != null) {
            i2 = Util.getInt(K.get(".msg.appmsg.mmreader.notify_msg.scene"), 0);
        } else {
            i2 = 0;
        }
        AppMethodBeat.o(212670);
        return i2;
    }

    public static final int gBq() {
        az bjY;
        AppMethodBeat.i(212671);
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "service(IMessengerStorage::class.java)");
        bw aST = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aST();
        if (aST == null || (bjY = aST.bjY("officialaccounts")) == null) {
            AppMethodBeat.o(212671);
            return 0;
        } else if (bjY.ajG() <= 0) {
            if ((bjY.oV(TPMediaCodecProfileLevel.HEVCHighTierLevel61) || bjY.oV(TPMediaCodecProfileLevel.HEVCHighTierLevel6)) && bjY.ajH() > 0) {
                AppMethodBeat.o(212671);
                return 1;
            }
            AppMethodBeat.o(212671);
            return 0;
        } else if (!ab.clc() || bjY.oV(16) || bjY.oV(64)) {
            AppMethodBeat.o(212671);
            return 1;
        } else {
            AppMethodBeat.o(212671);
            return 0;
        }
    }

    public static final boolean J(z zVar) {
        AppMethodBeat.i(212672);
        p.h(zVar, "info");
        if (!zVar.gAx()) {
            AppMethodBeat.o(212672);
            return false;
        }
        Map<String, String> K = K(zVar);
        if (K == null) {
            AppMethodBeat.o(212672);
            return false;
        } else if (K == null || Util.isNullOrNil(K.get(".msg.appmsg.mmreader.notify_msg.act"))) {
            Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "checkNewDyeingTemplate false");
            AppMethodBeat.o(212672);
            return false;
        } else {
            AppMethodBeat.o(212672);
            return true;
        }
    }

    public static final Map<String, String> K(z zVar) {
        AppMethodBeat.i(212673);
        if (zVar.field_msgId != NRy || NRz == null) {
            NRy = zVar.field_msgId;
            Map<String, String> parseXml = XmlParser.parseXml(zVar.field_content, "msg", null);
            NRz = parseXml;
            AppMethodBeat.o(212673);
            return parseXml;
        }
        Map<String, String> map = NRz;
        AppMethodBeat.o(212673);
        return map;
    }

    public static final void a(String str, int i2, int i3, long j2, int i4, int i5, int i6, int i7) {
        AppMethodBeat.i(212674);
        h.INSTANCE.a(17750, str, Integer.valueOf((int) (System.currentTimeMillis() / 1000)), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7));
        AppMethodBeat.o(212674);
    }

    public static final SpannableStringBuilder i(z zVar, int i2) {
        AppMethodBeat.i(212675);
        p.h(zVar, "info");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Map<String, String> M = M(zVar);
        if (M == null) {
            AppMethodBeat.o(212675);
            return spannableStringBuilder;
        } else if (M == null || !Util.isNullOrNil(M.get(".msgsource.notify_msg.act"))) {
            c cVar = new c(M);
            String str = ".msgsource.notify_msg.msg.item" + (i2 == 0 ? "" : Integer.valueOf(i2));
            if (!Util.isNullOrNil(M.get(str + ".content"))) {
                spannableStringBuilder.append((CharSequence) cVar.invoke(str));
            }
            AppMethodBeat.o(212675);
            return spannableStringBuilder;
        } else {
            AppMethodBeat.o(212675);
            return spannableStringBuilder;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<no name provided>", "Landroid/text/SpannableString;", "prefix", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.b<String, SpannableString> {
        final /* synthetic */ Map NRx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Map map) {
            super(1);
            this.NRx = map;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ SpannableString invoke(String str) {
            AppMethodBeat.i(212660);
            SpannableString bjd = bjd(str);
            AppMethodBeat.o(212660);
            return bjd;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0047, code lost:
            if (r1 == null) goto L_0x0049;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private android.text.SpannableString bjd(java.lang.String r14) {
            /*
            // Method dump skipped, instructions count: 324
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.ag.c.bjd(java.lang.String):android.text.SpannableString");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0091  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void b(com.tencent.mm.storage.z r7, int r8, android.widget.TextView r9) {
        /*
        // Method dump skipped, instructions count: 162
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.ag.b(com.tencent.mm.storage.z, int, android.widget.TextView):void");
    }

    public static final String L(z zVar) {
        AppMethodBeat.i(212677);
        p.h(zVar, "info");
        String str = "";
        Map<String, String> M = M(zVar);
        if (M == null) {
            AppMethodBeat.o(212677);
        } else {
            if (M != null) {
                StringBuilder sb = new StringBuilder();
                String str2 = M.get(".msgsource.notify_msg.title2");
                if (str2 == null) {
                    str2 = "";
                }
                StringBuilder append = sb.append(str2).append(' ');
                String str3 = M.get(".msgsource.notify_msg.action");
                if (str3 == null) {
                    str3 = "";
                }
                str = append.append(str3).toString();
            }
            AppMethodBeat.o(212677);
        }
        return str;
    }

    private static final Map<String, String> M(z zVar) {
        AppMethodBeat.i(212678);
        if (zVar.field_msgId != NRA || NRB == null) {
            NRA = zVar.field_msgId;
            Map<String, String> parseXml = XmlParser.parseXml(zVar.ajw(), "msgsource", null);
            NRB = parseXml;
            AppMethodBeat.o(212678);
            return parseXml;
        }
        Map<String, String> map = NRB;
        AppMethodBeat.o(212678);
        return map;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<no name provided>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ Map NRx;
        final /* synthetic */ z prL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(z zVar, Map map, Context context) {
            super(0);
            this.prL = zVar;
            this.NRx = map;
            this.$context = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(212662);
            com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af, "service(IMessengerStorage::class.java)");
            if (((com.tencent.mm.plugin.messenger.foundation.a.l) af).eiy().Hb(this.prL.field_msgId).ajL() != 0) {
                String str = this.prL.field_talker;
                String str2 = (String) this.NRx.get(".msg.appmsg.mmreader.notify_msg.publisher_username");
                if (Util.isNullOrNil(str2)) {
                    str2 = str;
                }
                Intent intent = new Intent();
                intent.putExtra("Chat_User", str2);
                intent.putExtra("finish_direct", true);
                intent.putExtra("from_global_search", true);
                intent.putExtra("msg_local_id", this.prL.field_msgId);
                intent.putExtra("specific_chat_from_scene", 9);
                intent.putExtra("preChatTYPE", 13);
                com.tencent.mm.br.c.f(this.$context, ".ui.chatting.ChattingUI", intent);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(212662);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<no name provided>", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ Map NRx;
        final /* synthetic */ z prL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(Map map, z zVar, Context context) {
            super(0);
            this.NRx = map;
            this.prL = zVar;
            this.$context = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            String str;
            String str2;
            AppMethodBeat.i(212663);
            String d2 = m.d((String) this.NRx.get(".msg.appmsg.mmreader.notify_msg.url"), 0, 10000, (int) (System.currentTimeMillis() / 1000));
            String str3 = (String) this.NRx.get(".msg.appmsg.mmreader.category.item.title");
            String str4 = (String) this.NRx.get(".msg.appmsg.template_id");
            String str5 = (String) this.NRx.get(".msg.fromusername");
            if (str5 != null) {
                com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
                as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(str5);
                if (Kn == null || (str2 = Kn.arI()) == null) {
                    str2 = str5;
                }
                str = str2;
            } else {
                str = null;
            }
            int i2 = Util.getInt((String) this.NRx.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", d2);
            intent.putExtra("shortUrl", d2);
            intent.putExtra("webpageTitle", str3);
            intent.putExtra("KTemplateId", str4);
            intent.putExtra("msg_id", this.prL.field_msgId);
            intent.putExtra("KPublisherId", "msg_" + this.prL.field_msgSvrId);
            intent.putExtra("pre_username", this.prL.field_talker);
            intent.putExtra("prePublishId", "msg_" + this.prL.field_msgSvrId);
            intent.putExtra("preChatName", this.prL.field_talker);
            intent.putExtra("geta8key_username", this.prL.field_talker);
            if (!Util.isNullOrNil(str5) && !Util.isNullOrNil(str)) {
                intent.putExtra("srcUsername", str5);
                intent.putExtra("srcDisplayname", str);
                intent.putExtra("mode", 1);
            }
            intent.putExtra("message_id", this.prL.field_msgSvrId);
            intent.putExtra("from_scence", 1);
            intent.putExtra("start_activity_time", System.currentTimeMillis());
            intent.putExtra(e.p.OzA, i2);
            intent.addFlags(536870912);
            if (!((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(2) || !((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(this.$context, d2, i2, 0, 10000, intent)) {
                intent.putExtra("rawUrl", d2);
                com.tencent.mm.br.c.b(this.$context, "webview", ".ui.tools.WebViewUI", intent);
            } else {
                Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "jump to TmplWebview");
            }
            x xVar = x.SXb;
            AppMethodBeat.o(212663);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<no name provided>", "", "invoke"})
    public static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ Map NRx;
        final /* synthetic */ z prL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Map map, z zVar, Context context) {
            super(0);
            this.NRx = map;
            this.prL = zVar;
            this.$context = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            String str;
            AppMethodBeat.i(212664);
            String str2 = (String) this.NRx.get(".msg.fromusername");
            String str3 = (String) this.NRx.get(".msg.appmsg.mmreader.notify_msg.weapp_username");
            String str4 = (String) this.NRx.get(".msg.appmsg.mmreader.notify_msg.weapp_path");
            int i2 = Util.getInt((String) this.NRx.get(".msg.appmsg.mmreader.notify_msg.weapp_version"), 0);
            int i3 = Util.getInt((String) this.NRx.get(".msg.appmsg.mmreader.notify_msg.weapp_state"), 0);
            String nullAsNil = Util.nullAsNil((String) this.NRx.get(".msg.appmsg.template_id"));
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.dCw = this.prL.field_msgSvrId + ':' + str2 + ':' + this.prL.field_talker + ':' + nullAsNil;
            if (((com.tencent.mm.plugin.biz.a.a) g.af(com.tencent.mm.plugin.biz.a.a.class)).HF(str2)) {
                appBrandStatObject.scene = 1174;
                ((r) g.af(r.class)).a(this.$context, str3, (String) null, i3, i2, str4, appBrandStatObject);
            } else {
                appBrandStatObject.scene = 1174;
                com.tencent.mm.api.c fJ = com.tencent.mm.al.g.fJ(str2);
                r rVar = (r) g.af(r.class);
                Context context = this.$context;
                if (fJ == null) {
                    str = null;
                } else {
                    str = fJ.field_appId;
                }
                rVar.a(context, str3, null, i3, i2, str4, appBrandStatObject, str);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(212664);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<no name provided>", "", "invoke"})
    public static final class a extends q implements kotlin.g.a.a<String> {
        final /* synthetic */ z prL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(z zVar) {
            super(0);
            this.prL = zVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            String str;
            AppMethodBeat.i(212657);
            Map<String, String> K = ag.K(this.prL);
            if (K == null) {
                AppMethodBeat.o(212657);
                return "";
            } else if (K == null || !Util.isNullOrNil(K.get(".msg.appmsg.mmreader.notify_msg.act"))) {
                String str2 = K.get(".msg.appmsg.mmreader.notify_msg.title");
                if (str2 == null) {
                    str = "";
                } else {
                    str = str2;
                }
                String str3 = "";
                int i2 = 0;
                while (i2 <= 10) {
                    String str4 = K.get(".msg.appmsg.mmreader.notify_msg.msg.item" + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".content");
                    if (Util.isNullOrNil(str4)) {
                        break;
                    }
                    str3 = str3 + str4;
                    i2++;
                }
                String str5 = (("" + str) + ":") + str3;
                AppMethodBeat.o(212657);
                return str5;
            } else {
                AppMethodBeat.o(212657);
                return "";
            }
        }
    }
}
