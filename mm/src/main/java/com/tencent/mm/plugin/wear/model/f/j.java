package com.tencent.mm.plugin.wear.model.f;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.ezd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.WeChatLocaleUtil;
import com.tencent.mm.storage.ca;
import com.tencent.recovery.log.RecoveryFileLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public final class j extends b {
    private int dCm;
    private boolean dTG;
    private String talker;

    public j(String str, int i2, boolean z) {
        this.talker = str;
        this.dCm = i2;
        this.dTG = z;
    }

    private String n(String str, ArrayList<ca> arrayList) {
        AppMethodBeat.i(30130);
        Log.d("MicroMsg.WearNotificationCreateTask", "Talker: %s, MsgSize: %d", str, Integer.valueOf(arrayList.size()));
        StringBuffer stringBuffer = new StringBuffer();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            stringBuffer.append(c(str, arrayList.get(size)));
            stringBuffer.append(RecoveryFileLog.LINE_SPLITTER);
        }
        String trim = stringBuffer.toString().trim();
        AppMethodBeat.o(30130);
        return trim;
    }

    private static String aY(ArrayList<ca> arrayList) {
        AppMethodBeat.i(30131);
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<ca> it = arrayList.iterator();
        while (it.hasNext()) {
            ca next = it.next();
            stringBuffer.append(next.field_msgId);
            stringBuffer.append(next.field_talker);
            stringBuffer.append(next.field_content);
            stringBuffer.append(next.getType());
            stringBuffer.append(next.field_createTime);
        }
        String mD5String = MD5Util.getMD5String(stringBuffer.toString());
        AppMethodBeat.o(30131);
        return mD5String;
    }

    @Override // com.tencent.mm.plugin.wear.model.f.d
    public final String getName() {
        return "WearNotificationCreateTask";
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wear.model.f.c
    public final void send() {
        AppMethodBeat.i(30132);
        Log.d("MicroMsg.WearNotificationCreateTask", "start to execute notification create task");
        f aWj = a.fVK().aWj(this.talker);
        ArrayList<ca> arrayList = new ArrayList<>();
        int i2 = this.dCm - aWj.IxY;
        if (i2 < 0) {
            i2 = 0;
        }
        Log.d("MicroMsg.WearNotificationCreateTask", "limit=%d", Integer.valueOf(i2));
        bg.aVF();
        for (ca caVar : c.aSQ().ew(this.talker, i2)) {
            if (!caVar.isSystem()) {
                arrayList.add(caVar);
            }
        }
        Log.i("MicroMsg.WearNotificationCreateTask", "receiveUnreadMsgList.size=%d", Integer.valueOf(arrayList.size()));
        if (arrayList.size() == 0) {
            AppMethodBeat.o(30132);
            return;
        }
        String aY = aY(arrayList);
        if (aWj.md5.equals(aY)) {
            Log.i("MicroMsg.WearNotificationCreateTask", "same md5, not to update");
            AppMethodBeat.o(30132);
            return;
        }
        aWj.md5 = aY;
        ezd ezd = new ezd();
        ezd.xNF = aWj.id;
        ezd.MRZ = aWj.talker;
        ezd.Title = h.aWo(aWj.talker);
        ezd.iAc = n(aWj.talker, arrayList);
        ezd.MWA = this.dCm;
        ezd.NvG = this.dTG;
        ezd.NvF = !WeChatLocaleUtil.isOverseasUserByWechatLanguage();
        Bitmap aWn = h.aWn(aWj.talker);
        if (aWn != null) {
            ezd.Nvo = new b(h.aF(aWn));
        }
        Log.d("MicroMsg.WearNotificationCreateTask", "generate notification content and ready to send");
        try {
            a.fVQ();
            r.a(20003, ezd.toByteArray(), true);
        } catch (IOException e2) {
        }
        Log.d("MicroMsg.WearNotificationCreateTask", "start to update notification status");
        a.fVK().a(aWj);
        a.fVK().aWm(this.talker);
        com.tencent.mm.plugin.wear.model.c.a.jZ(6, 0);
        com.tencent.mm.plugin.wear.model.c.a.aff(1);
        AppMethodBeat.o(30132);
    }
}
