package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.plugin.ipcall.model.h.f;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Map;

public final class e {
    private static e yoD = null;
    IListener kiA = new IListener<bp>() {
        /* class com.tencent.mm.plugin.ipcall.model.e.AnonymousClass1 */

        {
            AppMethodBeat.i(161380);
            this.__eventId = bp.class.getName().hashCode();
            AppMethodBeat.o(161380);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(bp bpVar) {
            AppMethodBeat.i(25355);
            bp bpVar2 = bpVar;
            if (bpVar2.dEN.dEO == 39) {
                Log.i("MicroMsg.IPCallFeedbackConfigUpdater", "checkResUpdateListener callback");
                byte[] aW = s.aW(bpVar2.dEN.filePath, 0, -1);
                if (aW != null) {
                    e.this.bG(aW);
                } else {
                    Log.e("MicroMsg.IPCallFeedbackConfigUpdater", "checkResUpdateListener file not exist");
                }
            }
            AppMethodBeat.o(25355);
            return false;
        }
    };
    public ArrayList<f> yoE = null;

    private e() {
        AppMethodBeat.i(25356);
        AppMethodBeat.o(25356);
    }

    public static e eak() {
        AppMethodBeat.i(25357);
        if (yoD == null) {
            yoD = new e();
        }
        e eVar = yoD;
        AppMethodBeat.o(25357);
        return eVar;
    }

    public final boolean bG(byte[] bArr) {
        String str;
        AppMethodBeat.i(25358);
        try {
            try {
                Map<String, String> parseXml = XmlParser.parseXml(new String(bArr), "feedbackconfig", null);
                if (parseXml != null) {
                    ArrayList<f> arrayList = new ArrayList<>();
                    int i2 = 0;
                    while (true) {
                        String str2 = ".feedbackconfig.resourceslist.resources" + (i2 == 0 ? "" : Integer.valueOf(i2));
                        String str3 = parseXml.get(str2 + ".$langid");
                        if (str3 != null) {
                            int i3 = i2 + 1;
                            f fVar = new f();
                            fVar.ysG = str3;
                            fVar.ysH = new ArrayList<>();
                            String str4 = str2 + ".string";
                            int i4 = 0;
                            while (true) {
                                com.tencent.mm.plugin.ipcall.model.h.e eVar = new com.tencent.mm.plugin.ipcall.model.h.e();
                                String str5 = str4 + (i4 == 0 ? "" : Integer.valueOf(i4));
                                String str6 = parseXml.get(str5);
                                if (str6 == null || (str = parseXml.get(str5 + ".$id")) == null) {
                                    Log.d("MicroMsg.IPCallFeedbackConfigUpdater", "feedbackResource parse id:%s,wording count:%d", fVar.ysG, Integer.valueOf(fVar.ysH.size()));
                                    arrayList.add(fVar);
                                    i2 = i3;
                                } else {
                                    i4++;
                                    eVar.Id = str;
                                    eVar.xJH = str6;
                                    fVar.ysH.add(eVar);
                                }
                            }
                            Log.d("MicroMsg.IPCallFeedbackConfigUpdater", "feedbackResource parse id:%s,wording count:%d", fVar.ysG, Integer.valueOf(fVar.ysH.size()));
                            arrayList.add(fVar);
                            i2 = i3;
                        } else {
                            Log.i("MicroMsg.IPCallFeedbackConfigUpdater", "feedbackResource parse finished count:%d", Integer.valueOf(arrayList.size()));
                            this.yoE = arrayList;
                            AppMethodBeat.o(25358);
                            return true;
                        }
                    }
                } else {
                    Log.e("MicroMsg.IPCallFeedbackConfigUpdater", "parse xml feedbackconfig error");
                    AppMethodBeat.o(25358);
                    return false;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.IPCallFeedbackConfigUpdater", e2, "", new Object[0]);
                Log.e("MicroMsg.IPCallFeedbackConfigUpdater", "parse ipcall feedback config error: %s", e2.getMessage());
                AppMethodBeat.o(25358);
                return false;
            }
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.IPCallFeedbackConfigUpdater", e3, "", new Object[0]);
            Log.e("MicroMsg.IPCallFeedbackConfigUpdater", "parse ipcall feedback config new string error: %s", e3.getMessage());
            AppMethodBeat.o(25358);
            return false;
        }
    }
}
