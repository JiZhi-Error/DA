package com.tencent.mm.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.api.s;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bnr;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.bs;
import java.util.List;
import java.util.Map;
import org.apache.commons.b.f;

public final class b implements i {
    private List<com.tencent.mm.api.i> heP;
    private a heQ;
    private s heR;

    public interface a {
        void a(com.tencent.mm.api.i iVar);

        void b(com.tencent.mm.api.i iVar);
    }

    public b(List<com.tencent.mm.api.i> list, s sVar, a aVar) {
        AppMethodBeat.i(114101);
        g.azz().a(825, this);
        this.heR = sVar;
        this.heQ = aVar;
        this.heP = list;
        AppMethodBeat.o(114101);
    }

    public final void awH() {
        int i2;
        AppMethodBeat.i(114102);
        for (com.tencent.mm.api.i iVar : this.heP) {
            if (iVar != null && iVar.field_cgi != null && iVar.field_cmdid > 0) {
                Log.i("FunctionMsg.FunctionMsgFetcher", "[fetchInternal], functionMsgId: %s", iVar.field_functionmsgid);
                iVar.field_status = 0;
                this.heR.b(iVar.field_businessInfo);
                g.azz().a(new com.tencent.mm.bm.a(iVar), 0);
            } else if (iVar != null) {
                de a2 = a(iVar.field_addMsg, iVar.field_defaultContent);
                Log.i("FunctionMsg.FunctionMsgFetcher", "[fetchInternal] addMsgDefault is null? %s", a2);
                iVar.a(a2);
                if (iVar.field_actionTime > cl.aWy() / 1000) {
                    i2 = -2;
                } else {
                    i2 = 2;
                }
                iVar.field_status = i2;
                bs bsVar = bs.OqA;
                bs.a(iVar.field_functionmsgid, iVar);
                if (a2 != null && this.heP.remove(iVar)) {
                    this.heQ.a(iVar);
                } else if (this.heP.remove(iVar)) {
                    this.heQ.b(iVar);
                }
                if (this.heP.size() <= 0) {
                    release();
                }
            }
        }
        AppMethodBeat.o(114102);
    }

    private void release() {
        AppMethodBeat.i(114103);
        g.azz().b(825, this);
        AppMethodBeat.o(114103);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        int i4;
        int i5;
        AppMethodBeat.i(114104);
        if (qVar.getType() != 825) {
            AppMethodBeat.o(114104);
        } else if (this.heP == null) {
            Log.e("FunctionMsg.FunctionMsgFetcher", "[onSceneEnd] mFetchItemList is null.");
            AppMethodBeat.o(114104);
        } else {
            com.tencent.mm.bm.a aVar = (com.tencent.mm.bm.a) qVar;
            bnr bnr = aVar.jDl;
            com.tencent.mm.api.i iVar = aVar.jDm;
            Log.i("FunctionMsg.FunctionMsgFetcher", "[onSceneEnd] size:%s errCode:%s errMsg:%s", Integer.valueOf(this.heP.size()), Integer.valueOf(i3), str);
            if (this.heP.contains(iVar)) {
                if (i3 != 0 || ((i3 == 0 && bnr == null) || ((bnr != null && bnr.OpCode == 2) || (bnr != null && bnr.OpCode == 1)))) {
                    Object[] objArr = new Object[4];
                    objArr[0] = iVar.field_functionmsgid;
                    objArr[1] = Long.valueOf(iVar.field_preVersion);
                    objArr[2] = Long.valueOf(iVar.field_version);
                    objArr[3] = Integer.valueOf(bnr == null ? -1 : bnr.OpCode);
                    Log.i("FunctionMsg.FunctionMsgFetcher", "functionMsgId: %s, fetch failed, mark as fetch failed, preVersion: %s, version: %s op:%s", objArr);
                    if (iVar.field_retryCount < iVar.field_retryCountLimit) {
                        Object[] objArr2 = new Object[4];
                        objArr2[0] = Integer.valueOf(iVar.field_retryCount);
                        objArr2[1] = iVar.field_functionmsgid;
                        objArr2[2] = Integer.valueOf(iVar.field_retryinterval);
                        objArr2[3] = Boolean.valueOf(bnr == null);
                        Log.i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] has retryCount:%s id:%s retryInterval:%s response is null?%s", objArr2);
                        if (bnr != null) {
                            Log.i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] opCode:%s actionTime:%s", Integer.valueOf(bnr.OpCode), Integer.valueOf(bnr.LWh));
                            if (bnr.OpCode == 2) {
                                iVar.field_actionTime = (long) bnr.LWh;
                                iVar.field_retryCount++;
                                iVar.field_status = -1;
                            } else if (bnr.OpCode == 1) {
                                iVar.field_status = 3;
                                iVar.field_retryCount = iVar.field_retryCountLimit;
                            } else {
                                iVar.field_status = 3;
                            }
                            iVar.fz(bnr.LWe);
                        } else {
                            iVar.field_status = -1;
                            iVar.field_actionTime = (cl.aWy() / 1000) + ((long) iVar.field_retryinterval);
                            iVar.field_retryCount++;
                        }
                    } else {
                        iVar.field_status = 3;
                    }
                    bs bsVar = bs.OqA;
                    bs.a(iVar.field_functionmsgid, iVar);
                    if (iVar.field_status != 3) {
                        h.INSTANCE.idkeyStat((long) iVar.field_reportid, (long) iVar.field_failkey, 1, false);
                        Log.i("FunctionMsg.FunctionMsgFetcher", "[handleFailureFetch] maybe has to retry fetch! delay:%sms retryCount:%s", Long.valueOf((iVar.field_actionTime - (cl.aWy() / 1000)) * 1000), Integer.valueOf(iVar.field_retryCount));
                    } else {
                        de a2 = a(iVar.field_addMsg, iVar.field_defaultContent);
                        Log.i("FunctionMsg.FunctionMsgFetcher", "[handleFailFetch] addMsgDefault is null? %s", a2);
                        iVar.a(a2);
                        if (a2 == null) {
                            i4 = 3;
                        } else {
                            i4 = 2;
                        }
                        iVar.field_status = i4;
                        if (3 == iVar.field_status) {
                            iVar.field_version = iVar.field_preVersion;
                            h.INSTANCE.idkeyStat((long) iVar.field_reportid, (long) iVar.field_finalfailkey, 1, false);
                        }
                        bs bsVar2 = bs.OqA;
                        bs.a(iVar.field_functionmsgid, iVar);
                    }
                } else if (bnr != null && i3 == 0 && (bnr.OpCode == 3 || bnr.OpCode == 0)) {
                    Log.i("FunctionMsg.FunctionMsgFetcher", "functionMsgId: %s fetch success, response.version: %s, fetchItem.version: %s ActionTime:%s OpCode:%s", iVar.field_functionmsgid, Long.valueOf(bnr.LRV), Long.valueOf(iVar.field_version), Integer.valueOf(bnr.LWh), Integer.valueOf(bnr.OpCode));
                    if (bnr.OpCode == 3) {
                        i5 = -2;
                    } else {
                        i5 = 2;
                    }
                    iVar.field_status = i5;
                    iVar.a(bnr.LWg);
                    iVar.field_businessInfo = bnr.LWf;
                    iVar.field_actionTime = (long) bnr.LWh;
                    bs bsVar3 = bs.OqA;
                    bs.a(iVar.field_functionmsgid, iVar);
                }
                if ((iVar.field_status == 2 || iVar.field_status == -2) && this.heP.remove(iVar)) {
                    this.heQ.a(iVar);
                    h.INSTANCE.idkeyStat((long) iVar.field_reportid, (long) iVar.field_successkey, 1, false);
                } else if (this.heP.remove(iVar)) {
                    this.heQ.b(iVar);
                }
            }
            if (this.heP.size() <= 0) {
                release();
            }
            AppMethodBeat.o(114104);
        }
    }

    private static de a(de deVar, String str) {
        AppMethodBeat.i(114105);
        if (deVar == null) {
            Log.w("FunctionMsg.FunctionMsgFetcher", "null == raw");
            AppMethodBeat.o(114105);
            return null;
        }
        int indexOf = str.indexOf("<addmsg");
        if (indexOf == -1) {
            Log.e("FunctionMsg.FunctionMsgFetcher", "msgContent not start with <addmsg! content is null?%s", Boolean.valueOf(Util.isNullOrNil(str)));
            AppMethodBeat.o(114105);
            return null;
        }
        Map<String, String> parseXml = XmlParser.parseXml(str.substring(indexOf), "addmsg", null);
        StringBuilder sb = new StringBuilder();
        if (parseXml.containsKey(Fc(".msgid"))) {
            int i2 = Util.getInt(parseXml.get(Fc(".msgid")), 0);
            deVar.Brl = i2;
            sb.append("msgid:".concat(String.valueOf(i2)));
        }
        if (parseXml.containsKey(Fc(".newmsgid"))) {
            long j2 = Util.getLong(parseXml.get(Fc(".newmsgid")), 0);
            deVar.Brn = j2;
            sb.append(" newMsgId:".concat(String.valueOf(j2)));
        }
        if (parseXml.containsKey(Fc(".msgseq"))) {
            int i3 = Util.getInt(parseXml.get(Fc(".msgseq")), 0);
            deVar.KHs = i3;
            sb.append(" msgSeq:".concat(String.valueOf(i3)));
        }
        if (parseXml.containsKey(Fc(".fromusername"))) {
            String str2 = parseXml.get(Fc(".fromusername"));
            deVar.KHl = z.Su(str2);
            sb.append(" fromUsername:".concat(String.valueOf(str2)));
        }
        if (parseXml.containsKey(Fc(".tousername"))) {
            String str3 = parseXml.get(Fc(".tousername"));
            deVar.KHm = z.Su(str3);
            sb.append(" toUsername:".concat(String.valueOf(str3)));
        }
        if (parseXml.containsKey(Fc(".msgtype"))) {
            int i4 = Util.getInt(parseXml.get(Fc(".msgtype")), 0);
            deVar.xKb = i4;
            sb.append(" msgType:".concat(String.valueOf(i4)));
        }
        if (parseXml.containsKey(Fc(".status"))) {
            int i5 = Util.getInt(parseXml.get(Fc(".status")), 0);
            deVar.oTW = i5;
            sb.append(" status:".concat(String.valueOf(i5)));
        }
        if (parseXml.containsKey(Fc(".content"))) {
            deVar.KHn = z.Su(f.bvi(str.substring(str.indexOf("<content>") + 9, str.indexOf("</content>"))));
            sb.append(" msgContent:*");
        } else {
            sb.append(" msgContent:null");
            deVar.KHn = null;
        }
        if (parseXml.containsKey(Fc(".msgsource"))) {
            deVar.KHq = f.bvi(str.substring(str.indexOf("<msgsource>") + 11, str.indexOf("</msgsource>")));
            sb.append(" msgSource:*");
        }
        if (parseXml.containsKey(Fc(".pushcontent"))) {
            deVar.KHr = f.bvi(str.substring(str.indexOf("<pushcontent>") + 13, str.indexOf("</pushcontent>")));
            sb.append(" pushContent:*");
        }
        if (parseXml.containsKey(Fc(".imgstatus"))) {
            int i6 = Util.getInt(parseXml.get(Fc(".imgstatus")), 0);
            deVar.KHo = i6;
            sb.append(" ImgStatus:".concat(String.valueOf(i6)));
        }
        if (parseXml.containsKey(Fc(".imgbuf"))) {
            deVar.KHp = z.Sv(parseXml.get(Fc(".imgbuf")));
            sb.append(" imgBuf:*");
        }
        if (parseXml.containsKey(Fc(".createtime"))) {
            int i7 = Util.getInt(parseXml.get(Fc(".createtime")), 0);
            deVar.CreateTime = i7;
            sb.append(" createTime:".concat(String.valueOf(i7)));
        }
        Log.i("FunctionMsg.FunctionMsgFetcher", "[mergeAddMsg] result:%s", sb.toString());
        AppMethodBeat.o(114105);
        return deVar;
    }

    private static String Fc(String str) {
        AppMethodBeat.i(114106);
        String concat = ".addmsg".concat(String.valueOf(str));
        AppMethodBeat.o(114106);
        return concat;
    }
}
