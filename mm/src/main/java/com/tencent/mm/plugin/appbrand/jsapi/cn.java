package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.sdk.platformtools.MD5Util;
import java.util.HashMap;
import org.apache.commons.b.g;
import org.json.JSONObject;

public final class cn extends d<ag> {
    public static final int CTRL_INDEX = 66;
    public static final String NAME = "reportSubmitForm";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(ag agVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45632);
        ag agVar2 = agVar;
        ReportSubmitFormTask reportSubmitFormTask = new ReportSubmitFormTask(agVar2.getRuntime().bsB());
        reportSubmitFormTask.type = 1;
        reportSubmitFormTask.lKc = MD5Util.getMD5String(g.a((Object[]) new String[]{agVar2.getAppId(), p.getString(agVar2.getRuntime().bsC().uin), new StringBuilder().append(System.currentTimeMillis()).toString()}, '#'));
        reportSubmitFormTask.pageId = agVar2.nna;
        AppBrandMainProcessService.a(reportSubmitFormTask);
        HashMap hashMap = new HashMap();
        hashMap.put("formId", reportSubmitFormTask.lKc);
        com.tencent.mm.plugin.appbrand.p Un = com.tencent.mm.plugin.appbrand.p.Un(agVar2.getAppId());
        if (Un != null) {
            Un.kCP = reportSubmitFormTask.lKc;
        }
        agVar2.i(i2, n("ok", hashMap));
        AppMethodBeat.o(45632);
    }
}
