package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnc;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class ao {
    /* JADX WARNING: Removed duplicated region for block: B:107:0x03ac  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x02bb A[EDGE_INSN: B:115:0x02bb->B:96:0x02bb ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01bf A[Catch:{ Exception -> 0x02a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01f4 A[Catch:{ Exception -> 0x039f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String fbs() {
        /*
        // Method dump skipped, instructions count: 943
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.model.ao.fbs():java.lang.String");
    }

    public static void report(long j2) {
        int lastIndexOf;
        AppMethodBeat.i(95888);
        if (j2 == 0) {
            AppMethodBeat.o(95888);
            return;
        }
        SnsInfo JJ = aj.faO().JJ(j2);
        if (JJ == null) {
            AppMethodBeat.o(95888);
        } else if (JJ.field_type != 1) {
            AppMethodBeat.o(95888);
        } else {
            cnc postInfo = JJ.getPostInfo();
            if (postInfo == null) {
                AppMethodBeat.o(95888);
                return;
            }
            LinkedList<eas> linkedList = postInfo.Mth;
            LinkedList<cnb> linkedList2 = JJ.getTimeLine().ContentObj.LoV;
            int min = Math.min(linkedList.size(), linkedList2.size());
            String str = "";
            if (min > 0) {
                str = fbs();
                if (Util.isNullOrNil(str)) {
                    AppMethodBeat.o(95888);
                    return;
                }
            }
            for (int i2 = 0; i2 < min; i2++) {
                eas eas = linkedList.get(i2);
                StringBuffer stringBuffer = new StringBuffer();
                cnb cnb = linkedList2.get(i2);
                stringBuffer.append("||index: ".concat(String.valueOf(i2)));
                stringBuffer.append("||item poi lat " + eas.Nak + " " + eas.Nal);
                stringBuffer.append("||item poi accuracy loctype " + eas.cjn + " " + eas.Esd);
                stringBuffer.append("||item pic lat " + eas.Nai + " " + eas.Naj);
                stringBuffer.append("||item exitime:" + eas.Nan + " filetime: " + eas.Nao);
                stringBuffer.append("||item source: " + eas.Nam);
                stringBuffer.append("||url" + cnb.Url);
                String str2 = cnb.Url;
                if (str2.startsWith("http://mmsns.qpic.cn/mmsns/") && (lastIndexOf = str2.lastIndexOf(FilePathGenerator.ANDROID_DIR_SEP)) > 27 && lastIndexOf < str2.length()) {
                    str2 = str2.substring(27, lastIndexOf);
                }
                String str3 = str2 + "," + r.Jb(j2) + "," + i2 + "," + Util.nowSecond() + "," + eas.Nam + "," + eas.Nao + "," + eas.Nan + "," + eas.Naj + "," + eas.Nai + "," + eas.Nal + "," + eas.Nak + "," + str + "," + eas.cjn + "," + eas.Esd;
                Log.d("MicroMsg.SnsItemReportHelper", "report:%s", str3);
                h.INSTANCE.kvStat(11985, str3);
            }
            AppMethodBeat.o(95888);
        }
    }
}
