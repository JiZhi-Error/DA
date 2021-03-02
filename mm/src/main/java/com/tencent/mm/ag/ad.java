package com.tencent.mm.ag;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.v;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\b\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J:\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u0013H\u0002J\u001c\u0010\u0014\u001a\u00020\f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u0013H\u0002J\u001c\u0010\u0015\u001a\u00020\u00102\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u0013H\u0002J$\u0010\u0016\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\fH\u0002J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/message/ReportAppMsgInsertEventListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/AppMsgInsertEvent;", "()V", "callback", "", "event", "doReportReceiveAppMsgFromNotifyMessage", "", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "getBusinessType", "", "opType", "getJumpUrl", "Lkotlin/Pair;", "", "srcUsername", "values", "", "getNewTemplateType", "getSrcUsername", "getTitle", "isNewTemplateSubscribeMsg", "templateType", "reportReceiveAppMsgFromNotifyMessage", "Companion", "plugin-biz_release"})
public final class ad extends IListener<v> {
    public static final a iAY = new a((byte) 0);

    static {
        AppMethodBeat.i(212375);
        AppMethodBeat.o(212375);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/message/ReportAppMsgInsertEventListener$Companion;", "", "()V", "OP_ITEM_TYPE_MSG_REMIND", "", "OP_ITEM_TYPE_WE_APP", "REPORT_APPMSG_LOOP_TAG", "", "REPORT_BUSINESS_TYPE_DEFAULT", "REPORT_BUSINESS_TYPE_OFFLINE_SCAN", "REPORT_BUSINESS_TYPE_REMIND", "REPORT_MSG_TYPE_NORMAL_TEMPLATE_MSG", "REPORT_MSG_TYPE_SUBSCRIBE_MSG", "TAG", "plugin-biz_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(v vVar) {
        AppMethodBeat.i(212373);
        v vVar2 = vVar;
        if (vVar2 == null) {
            AppMethodBeat.o(212373);
        } else {
            ca caVar = vVar2.dCL.dCM;
            if (caVar != null) {
                if (caVar.ajO() == null || !ab.Jx(caVar.ajO())) {
                    Log.w("MicroMsg.AppMsgInsertEventListener", "doReportReceiveAppMsgFromNotifyMessage not from notifymessage and ignore");
                } else {
                    h.RTc.e(new b(this, caVar), "ReportAppMsg");
                }
            }
            AppMethodBeat.o(212373);
        }
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ ad iAZ;
        final /* synthetic */ ca iBa;

        b(ad adVar, ca caVar) {
            this.iAZ = adVar;
            this.iBa = caVar;
        }

        public final void run() {
            AppMethodBeat.i(212372);
            ad.w(this.iBa);
            AppMethodBeat.o(212372);
        }
    }

    private static boolean rL(int i2) {
        return i2 == 2 || i2 == 3;
    }

    private static int x(Map<String, String> map) {
        int i2;
        AppMethodBeat.i(212374);
        String str = map.get(".msg.appmsg.mmreader.template_detail.new_tmpl_type");
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            str = "-1";
        }
        try {
            Integer valueOf = Integer.valueOf(str);
            p.g(valueOf, "Integer.valueOf(newTemplateMsgStr)");
            i2 = valueOf.intValue();
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppMsgInsertEventListener", e2, "", new Object[0]);
            i2 = -1;
        }
        int nullAsInt = Util.nullAsInt(Integer.valueOf(i2), -1);
        AppMethodBeat.o(212374);
        return nullAsInt;
    }

    public static final /* synthetic */ void w(ca caVar) {
        int i2;
        String str;
        int i3;
        int i4;
        String str2;
        o oVar;
        A a2;
        B b2;
        int i5;
        B b3;
        A a3;
        AppMethodBeat.i(212376);
        int type = caVar.getType();
        if (type == 318767153 || type == 721420337) {
            if (type == 721420337) {
                Log.d("MicroMsg.AppMsgInsertEventListener", "alvinluo doReportReceiveAppMsg callback msgType: %d, msgId: %s, createTime: %s, talker: %s, businessType: %d, srcUsername: %s", Integer.valueOf(type), Long.valueOf(caVar.ajL()), Long.valueOf(caVar.getCreateTime()), caVar.ajO(), 2, caVar.ajO());
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(20566, 0, Long.valueOf(caVar.getCreateTime()), 0, 2, caVar.ajO(), "", "", "", 0);
                AppMethodBeat.o(212376);
                return;
            }
            try {
                Map<String, String> parseXml = XmlParser.parseXml(caVar.getContent(), "msg", null);
                if (parseXml == null || parseXml.isEmpty()) {
                    Log.e("MicroMsg.AppMsgInsertEventListener", "doReportReceiveAppMsgFromNotifyMessage parse msg fail");
                    AppMethodBeat.o(212376);
                    return;
                }
                String nullAsNil = Util.nullAsNil(parseXml.get(".msg.fromusername"));
                if (nullAsNil == null) {
                    nullAsNil = "";
                }
                String str3 = nullAsNil;
                if (str3.length() == 0) {
                    str3 = "";
                }
                String str4 = str3;
                int x = x(parseXml);
                if (rL(x)) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                int i6 = Util.getInt(parseXml.get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
                if (i6 == 2) {
                    str = "";
                } else if (Util.getInt(parseXml.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0) != 0) {
                    if (Util.getInt(parseXml.get(".msg.appmsg.mmreader.template_header.ignore_hide_title_and_time"), 0) == 0) {
                        i3 = Util.getInt(parseXml.get(".msg.appmsg.mmreader.template_header.hide_title_and_time"), 0);
                    } else {
                        i3 = 0;
                    }
                    int i7 = Util.getInt(parseXml.get(".msg.appmsg.mmreader.template_header.hide_title"), 0);
                    if (i3 == 0 && i7 == 0) {
                        String nullAsNil2 = Util.nullAsNil(parseXml.get(".msg.appmsg.mmreader.template_header.title"));
                        p.g(nullAsNil2, "Util.nullAsNil(values.ge….template_header.title\"))");
                        str = nullAsNil2;
                    } else {
                        String str5 = parseXml.get(".msg.appmsg.mmreader.category.item.title");
                        if (str5 == null) {
                            str5 = "";
                        }
                        str = str5;
                    }
                } else {
                    String str6 = parseXml.get(".msg.appmsg.mmreader.category.item.title");
                    if (str6 == null) {
                        str = "";
                    } else {
                        str = str6;
                    }
                }
                if (i6 == 2) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                String str7 = parseXml.get(".msg.appmsg.mmreader.category.item.weapp_username");
                if (str7 == null) {
                    str2 = "";
                } else {
                    str2 = str7;
                }
                if (i6 == 1 && !TextUtils.isEmpty(str2)) {
                    String str8 = parseXml.get(".msg.appmsg.mmreader.category.item.weapp_path");
                    if (str8 == null) {
                        str8 = "";
                    }
                    oVar = new o(Uri.encode(str8), str2);
                } else if (i6 == -1 && ((com.tencent.mm.plugin.biz.a.a) g.af(com.tencent.mm.plugin.biz.a.a.class)).HF(str4)) {
                    String str9 = parseXml.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
                    if (str9 == null) {
                        str9 = "";
                    }
                    oVar = new o(Uri.encode(str9), "");
                } else if (i6 == 2) {
                    oVar = null;
                } else {
                    String str10 = parseXml.get(".msg.appmsg.mmreader.category.item.url");
                    if (str10 == null) {
                        str10 = "";
                    }
                    oVar = new o(Uri.encode(str10), "");
                }
                if (oVar == null || (a3 = oVar.first) == null) {
                    a2 = "";
                } else {
                    a2 = a3;
                }
                if (oVar == null || (b3 = oVar.second) == null) {
                    b2 = "";
                } else {
                    b2 = b3;
                }
                boolean HF = ((com.tencent.mm.plugin.biz.a.a) g.af(com.tencent.mm.plugin.biz.a.a.class)).HF(str4);
                if (rL(x)) {
                    i5 = x;
                } else if (HF) {
                    i5 = 1;
                } else {
                    i5 = 0;
                }
                Log.d("MicroMsg.AppMsgInsertEventListener", "alvinluo doReportReceiveAppMsgFromNotifyMessage callback msgType: %d, opType: %d, msgSvrId: %s, createTime: %s, talker: %s, reportMsgType: %d, businessType: %d, srcUsername: %s, title: %s, jumpUrl: %s, jumpUsernanme: %s, msgSubType: %d", Integer.valueOf(type), Integer.valueOf(i6), Long.valueOf(caVar.ajM()), Long.valueOf(caVar.getCreateTime()), caVar.ajO(), Integer.valueOf(i2), Integer.valueOf(i4), str4, str, a2, b2, Integer.valueOf(i5));
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(20566, Long.valueOf(caVar.ajM()), Long.valueOf(caVar.getCreateTime()), Integer.valueOf(i2), Integer.valueOf(i4), str4, str, a2, b2, Integer.valueOf(i5));
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppMsgInsertEventListener", e2, "doReportReceiveAppMsgFromNotifyMessage exception", new Object[0]);
                AppMethodBeat.o(212376);
                return;
            }
        }
        AppMethodBeat.o(212376);
    }
}
