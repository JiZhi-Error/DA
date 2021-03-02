package com.tencent.mm.plugin.choosemsgfile.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    public int mMaxCount = Integer.MAX_VALUE;
    private Map<Long, MsgFile> qoK = new ConcurrentHashMap();
    public boolean qoL;
    private Set<Long> qoM = new HashSet();

    public a() {
        AppMethodBeat.i(123349);
        AppMethodBeat.o(123349);
    }

    public final synchronized void init(int i2) {
        AppMethodBeat.i(123350);
        Log.i("MicroMsg.ChooseMsgFileHelper", "init count:%d", Integer.valueOf(i2));
        this.mMaxCount = i2;
        this.qoK.clear();
        AppMethodBeat.o(123350);
    }

    public final synchronized void uninit() {
        AppMethodBeat.i(123351);
        Log.i("MicroMsg.ChooseMsgFileHelper", "uninit");
        this.qoK.clear();
        this.qoK = null;
        this.qoM.clear();
        this.qoM = null;
        AppMethodBeat.o(123351);
    }

    public final boolean isInvalid() {
        AppMethodBeat.i(123352);
        if (this.qoK == null) {
            Log.e("MicroMsg.ChooseMsgFileHelper", "isInvalid() msgIdToMsgFile is null, return");
            AppMethodBeat.o(123352);
            return false;
        } else if (this.qoK.size() >= this.mMaxCount) {
            AppMethodBeat.o(123352);
            return true;
        } else {
            AppMethodBeat.o(123352);
            return false;
        }
    }

    public final boolean cyG() {
        AppMethodBeat.i(123353);
        if (this.qoK == null) {
            Log.e("MicroMsg.ChooseMsgFileHelper", "isChange() msgIdToMsgFile is null, return");
            AppMethodBeat.o(123353);
            return false;
        } else if (this.qoK.size() == this.mMaxCount - 1 || this.qoK.size() == this.mMaxCount) {
            AppMethodBeat.o(123353);
            return true;
        } else {
            AppMethodBeat.o(123353);
            return false;
        }
    }

    public final boolean a(long j2, MsgFile msgFile) {
        AppMethodBeat.i(123354);
        if (j2 == -1) {
            Log.e("MicroMsg.ChooseMsgFileHelper", "msgid is invalid");
            AppMethodBeat.o(123354);
            return false;
        } else if (msgFile == null) {
            Log.e("MicroMsg.ChooseMsgFileHelper", "msgFile is null");
            AppMethodBeat.o(123354);
            return false;
        } else if (Util.isNullOrNil(msgFile.filePath)) {
            Log.e("MicroMsg.ChooseMsgFileHelper", "filePath is invalid");
            AppMethodBeat.o(123354);
            return false;
        } else if (isInvalid()) {
            Log.e("MicroMsg.ChooseMsgFileHelper", "exceed max:%d", Integer.valueOf(this.mMaxCount));
            AppMethodBeat.o(123354);
            return false;
        } else if (this.qoK == null) {
            Log.e("MicroMsg.ChooseMsgFileHelper", "msgIdToMsgFile is null, return");
            AppMethodBeat.o(123354);
            return false;
        } else {
            Log.i("MicroMsg.ChooseMsgFileHelper", "msgIdToFilePath put msgId:%d filePath:%s", Long.valueOf(j2), msgFile);
            this.qoK.put(Long.valueOf(j2), msgFile);
            AppMethodBeat.o(123354);
            return true;
        }
    }

    public final boolean BX(long j2) {
        AppMethodBeat.i(123355);
        if (j2 == -1) {
            Log.e("MicroMsg.ChooseMsgFileHelper", "msgid is invalid");
            AppMethodBeat.o(123355);
            return false;
        } else if (this.qoK == null) {
            Log.e("MicroMsg.ChooseMsgFileHelper", "msgIdToMsgFile is null, return");
            AppMethodBeat.o(123355);
            return false;
        } else {
            Log.i("MicroMsg.ChooseMsgFileHelper", "msgIdToFilePath remove msgId:%d", Long.valueOf(j2));
            this.qoK.remove(Long.valueOf(j2));
            AppMethodBeat.o(123355);
            return true;
        }
    }

    public final boolean BY(long j2) {
        AppMethodBeat.i(123356);
        if (this.qoK == null) {
            AppMethodBeat.o(123356);
            return false;
        }
        boolean containsKey = this.qoK.containsKey(Long.valueOf(j2));
        AppMethodBeat.o(123356);
        return containsKey;
    }

    public final int getSelectCount() {
        AppMethodBeat.i(123357);
        if (this.qoK == null) {
            AppMethodBeat.o(123357);
            return 0;
        }
        int size = this.qoK.size();
        AppMethodBeat.o(123357);
        return size;
    }

    public final ArrayList<MsgFile> cyH() {
        AppMethodBeat.i(123358);
        if (this.qoK == null || this.qoK.size() == 0) {
            Log.e("MicroMsg.ChooseMsgFileHelper", "msgIdToFilePath is null, return");
            AppMethodBeat.o(123358);
            return null;
        }
        ArrayList<MsgFile> arrayList = new ArrayList<>();
        for (MsgFile msgFile : this.qoK.values()) {
            arrayList.add(msgFile);
        }
        AppMethodBeat.o(123358);
        return arrayList;
    }

    public final synchronized void BZ(long j2) {
        AppMethodBeat.i(123359);
        if (this.qoM != null) {
            this.qoM.add(Long.valueOf(j2));
        }
        AppMethodBeat.o(123359);
    }

    public final synchronized void Ca(long j2) {
        AppMethodBeat.i(123360);
        if (this.qoM != null) {
            this.qoM.remove(Long.valueOf(j2));
        }
        AppMethodBeat.o(123360);
    }

    public final synchronized boolean Cb(long j2) {
        boolean z;
        AppMethodBeat.i(123361);
        if (this.qoM == null || !this.qoM.contains(Long.valueOf(j2))) {
            z = false;
            AppMethodBeat.o(123361);
        } else {
            z = true;
            AppMethodBeat.o(123361);
        }
        return z;
    }

    public final synchronized boolean cyI() {
        boolean z;
        AppMethodBeat.i(123362);
        if (this.qoM == null || this.qoM.size() <= 0) {
            z = false;
            AppMethodBeat.o(123362);
        } else {
            z = true;
            AppMethodBeat.o(123362);
        }
        return z;
    }
}
