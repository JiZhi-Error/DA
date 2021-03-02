package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.network.b;
import com.tencent.mm.network.f;
import com.tencent.mm.protocal.protobuf.cca;
import com.tencent.mm.protocal.protobuf.ccb;
import com.tencent.mm.protocal.protobuf.ie;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a extends f.a implements e {
    private static b.a jDx = new b.a();
    String dMW;
    byte[] ees;
    private boolean foreground = false;
    private byte[] jDo;
    private byte[] jDp;
    private byte[] jDq;
    private b jDr = null;
    byte[] jDs;
    private Map<String, byte[]> jDt = new HashMap();
    private Map<Integer, ccb> jDu = new HashMap();
    private Map<cca, C0483a> jDv = new HashMap();
    List<String> jDw = new ArrayList();
    private int uin;
    String username;

    public interface b {
    }

    static {
        AppMethodBeat.i(197080);
        AppMethodBeat.o(197080);
    }

    public a(b bVar) {
        AppMethodBeat.i(132629);
        this.jDr = bVar;
        bjn();
        AppMethodBeat.o(132629);
    }

    @Override // com.tencent.mm.network.f, com.tencent.mm.network.e
    public final void reset() {
        AppMethodBeat.i(132630);
        Log.i("MicroMsg.AccInfo", "reset accinfo");
        this.username = "";
        this.jDo = null;
        bjn();
        this.uin = 0;
        this.jDp = null;
        this.jDq = null;
        AppMethodBeat.o(132630);
    }

    private void bjn() {
        AppMethodBeat.i(132631);
        this.ees = Util.decodeHexString(bi.aVK().getString("server_id", ""));
        AppMethodBeat.o(132631);
    }

    @Override // com.tencent.mm.network.f, com.tencent.mm.network.e
    public final void setUsername(String str) {
        this.username = str;
    }

    @Override // com.tencent.mm.network.f, com.tencent.mm.network.e
    public final void a(byte[] bArr, byte[] bArr2, byte[] bArr3, int i2) {
        AppMethodBeat.i(132632);
        Log.i("MicroMsg.AccInfo", "summerauth update session info: session single[%s] cli[%s], svr[%s] uin:%d -> %d stack:[%s]", Util.secPrint(Util.dumpHex(bArr)), Util.secPrint(Util.dumpHex(bArr2)), Util.secPrint(Util.dumpHex(bArr3)), Integer.valueOf(this.uin), Integer.valueOf(i2), Util.getStack());
        this.jDo = bArr;
        this.jDp = bArr2;
        this.jDq = bArr3;
        this.uin = i2;
        if (this.jDr != null) {
            aZb();
        }
        AppMethodBeat.o(132632);
    }

    @Override // com.tencent.mm.network.f
    public final void av(byte[] bArr) {
        this.ees = bArr;
    }

    @Override // com.tencent.mm.network.f
    public final void aw(byte[] bArr) {
        this.jDs = bArr;
    }

    @Override // com.tencent.mm.network.f, com.tencent.mm.network.e
    public final byte[] qe(int i2) {
        switch (i2) {
            case 1:
                return this.jDo;
            case 2:
                return this.jDp;
            case 3:
                return this.jDq;
            default:
                return null;
        }
    }

    @Override // com.tencent.mm.network.f, com.tencent.mm.network.e
    public final byte[] aZc() {
        return this.jDs;
    }

    @Override // com.tencent.mm.network.f, com.tencent.mm.network.e
    public final byte[] aZa() {
        return this.ees;
    }

    @Override // com.tencent.mm.network.f, com.tencent.mm.network.e
    public final String getUsername() {
        return this.username;
    }

    @Override // com.tencent.mm.network.f, com.tencent.mm.network.e
    public final int getUin() {
        return this.uin;
    }

    @Override // com.tencent.mm.network.f, com.tencent.mm.network.e
    public final boolean aZb() {
        return this.jDo != null && this.jDp != null && this.jDq != null && this.jDo.length > 0 && this.jDp.length > 0 && this.jDq.length > 0;
    }

    public final String toString() {
        AppMethodBeat.i(132633);
        String str = (((((((("AccInfo:\n" + "|-uin     =" + getUin() + "\n") + "|-user    =" + getUsername() + "\n") + "|-wxuser  =" + aZd() + "\n") + "|-wxuser  =" + aZd() + "\n") + "|-singlesession =" + Util.dumpHex(qe(1)) + "\n") + "|-clientsession =" + Util.dumpHex(qe(2)) + "\n") + "|-serversession =" + Util.dumpHex(qe(3)) + "\n") + "|-ecdhkey =" + Util.dumpHex(aZc()) + "\n") + "`-cookie  =" + Util.dumpHex(aZa());
        AppMethodBeat.o(132633);
        return str;
    }

    @Override // com.tencent.mm.network.f
    public final void RL(String str) {
        this.dMW = str;
    }

    @Override // com.tencent.mm.network.f, com.tencent.mm.network.e
    public final String aZd() {
        return this.dMW;
    }

    @Override // com.tencent.mm.network.f, com.tencent.mm.network.e
    public final void i(String str, byte[] bArr) {
        AppMethodBeat.i(132634);
        this.jDt.put(str, bArr);
        AppMethodBeat.o(132634);
    }

    @Override // com.tencent.mm.network.f, com.tencent.mm.network.e
    public final byte[] MC(String str) {
        AppMethodBeat.i(132635);
        byte[] bArr = this.jDt.get(str);
        AppMethodBeat.o(132635);
        return bArr;
    }

    @Override // com.tencent.mm.network.f, com.tencent.mm.network.e
    public final boolean isForeground() {
        return this.foreground;
    }

    @Override // com.tencent.mm.network.f, com.tencent.mm.network.e
    public final void setForeground(boolean z) {
        AppMethodBeat.i(132636);
        this.foreground = z;
        Log.i("MicroMsg.AccInfo", "somr accinfo setForeground :%b", Boolean.valueOf(this.foreground));
        AppMethodBeat.o(132636);
    }

    private void clear() {
        this.username = null;
        this.jDo = null;
        this.jDp = null;
        this.jDq = null;
        this.ees = null;
        this.uin = 0;
        this.jDs = null;
        this.dMW = null;
    }

    private String bjo() {
        AppMethodBeat.i(132637);
        try {
            ByteBuffer allocate = ByteBuffer.allocate(4096);
            allocate.put(this.jDo).put(this.jDp).put(this.jDq).put(this.jDs).put(this.ees).putInt(this.uin).put(this.dMW.getBytes()).put(this.username.getBytes());
            String messageDigest = g.getMessageDigest(allocate.array());
            AppMethodBeat.o(132637);
            return messageDigest;
        } catch (Exception e2) {
            AppMethodBeat.o(132637);
            return "";
        }
    }

    @Override // com.tencent.mm.network.f, com.tencent.mm.network.e
    public final byte[] aZe() {
        boolean z;
        AppMethodBeat.i(132638);
        long nowMilliSecond = Util.nowMilliSecond();
        if (Util.isNullOrNil(this.username)) {
            z = false;
        } else if (Util.isNullOrNil(this.jDo)) {
            z = false;
        } else if (Util.isNullOrNil(this.jDp)) {
            z = false;
        } else if (Util.isNullOrNil(this.jDq)) {
            z = false;
        } else if (Util.isNullOrNil(this.ees)) {
            z = false;
        } else if (this.uin == 0 || this.uin == -1) {
            z = false;
        } else if (Util.isNullOrNil(this.jDs)) {
            z = false;
        } else if (Util.isNullOrNil(this.dMW)) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            Log.e("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer Error : isCacheValid== false");
            AppMethodBeat.o(132638);
            return null;
        }
        try {
            LVBuffer lVBuffer = new LVBuffer();
            lVBuffer.initBuild();
            lVBuffer.putString(this.username);
            lVBuffer.putString(this.dMW);
            lVBuffer.putInt(this.uin);
            lVBuffer.putBuffer(this.ees);
            lVBuffer.putBuffer(this.jDs);
            lVBuffer.putBuffer(this.jDo);
            lVBuffer.putBuffer(this.jDp);
            lVBuffer.putBuffer(this.jDq);
            lVBuffer.putBuffer(jDx.jDD.getBytes(StandardCharsets.ISO_8859_1));
            lVBuffer.putBuffer(jDx.jDC.getBytes(StandardCharsets.ISO_8859_1));
            String bjo = bjo();
            lVBuffer.putString(bjo);
            byte[] buildFinish = lVBuffer.buildFinish();
            Log.i("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer finish time:%s buflen:%s md5:%s", Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)), Integer.valueOf(buildFinish.length), bjo);
            AppMethodBeat.o(132638);
            return buildFinish;
        } catch (Exception e2) {
            Log.e("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132638);
            return null;
        }
    }

    @Override // com.tencent.mm.network.f, com.tencent.mm.network.e
    public final int al(byte[] bArr) {
        AppMethodBeat.i(132639);
        long nowMilliSecond = Util.nowMilliSecond();
        if (aZb()) {
            Log.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : isLogin == true ");
            AppMethodBeat.o(132639);
            return -2;
        }
        try {
            LVBuffer lVBuffer = new LVBuffer();
            int initParse = lVBuffer.initParse(bArr);
            if (initParse != 0) {
                Log.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : initParse: %s", Integer.valueOf(initParse));
                AppMethodBeat.o(132639);
                return -3;
            }
            this.username = lVBuffer.getString();
            this.dMW = lVBuffer.getString();
            this.uin = lVBuffer.getInt();
            this.ees = lVBuffer.getBuffer();
            this.jDs = lVBuffer.getBuffer();
            this.jDo = lVBuffer.getBuffer();
            this.jDp = lVBuffer.getBuffer();
            this.jDq = lVBuffer.getBuffer();
            jDx.jDD = new String(lVBuffer.getBuffer(), StandardCharsets.ISO_8859_1);
            jDx.jDC = new String(lVBuffer.getBuffer(), StandardCharsets.ISO_8859_1);
            Log.i("MicroMsg.AccInfo", "parseBuf " + jDx.jDD.length() + " " + jDx.jDC.length());
            String string = lVBuffer.getString();
            if (Util.isNullOrNil(string) || !string.equals(bjo())) {
                clear();
                Log.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : checksum failed");
                AppMethodBeat.o(132639);
                return -4;
            }
            Log.i("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf finish time:%s  md5:%s", Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)), string);
            AppMethodBeat.o(132639);
            return 0;
        } catch (Exception e2) {
            clear();
            Log.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132639);
            return -5;
        }
    }

    @Override // com.tencent.mm.network.f, com.tencent.mm.network.e
    public final int am(byte[] bArr) {
        AppMethodBeat.i(197077);
        long nowMilliSecond = Util.nowMilliSecond();
        try {
            LVBuffer lVBuffer = new LVBuffer();
            int initParse = lVBuffer.initParse(bArr);
            if (initParse != 0) {
                Log.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : initParse: %s", Integer.valueOf(initParse));
                AppMethodBeat.o(197077);
                return -3;
            }
            this.username = lVBuffer.getString();
            this.dMW = lVBuffer.getString();
            this.uin = lVBuffer.getInt();
            this.ees = lVBuffer.getBuffer();
            this.jDs = lVBuffer.getBuffer();
            this.jDo = lVBuffer.getBuffer();
            this.jDp = lVBuffer.getBuffer();
            this.jDq = lVBuffer.getBuffer();
            jDx.jDD = new String(lVBuffer.getBuffer(), StandardCharsets.ISO_8859_1);
            jDx.jDC = new String(lVBuffer.getBuffer(), StandardCharsets.ISO_8859_1);
            Log.i("MicroMsg.AccInfo", "parseBuf " + jDx.jDD.length() + " " + jDx.jDC.length());
            String string = lVBuffer.getString();
            if (Util.isNullOrNil(string) || !string.equals(bjo())) {
                clear();
                Log.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : checksum failed");
                AppMethodBeat.o(197077);
                return -4;
            }
            Log.i("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf finish time:%s  md5:%s", Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)), string);
            AppMethodBeat.o(197077);
            return 0;
        } catch (Exception e2) {
            clear();
            Log.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(197077);
            return -5;
        }
    }

    @Override // com.tencent.mm.network.f, com.tencent.mm.network.e
    public final void setUin(int i2) {
        AppMethodBeat.i(132640);
        Log.i("MicroMsg.AccInfo", "summerauth setuin [%d -> %d], stack[%s]", Integer.valueOf(this.uin), Integer.valueOf(i2), Util.getStack());
        this.uin = i2;
        AppMethodBeat.o(132640);
    }

    @Override // com.tencent.mm.network.f, com.tencent.mm.network.e
    public final void h(int i2, byte[] bArr) {
        AppMethodBeat.i(132641);
        Log.i("MicroMsg.AccInfo", "addAxAuthHostList");
        ccb ccb = new ccb();
        try {
            ccb.parseFrom(bArr);
            this.jDu.put(Integer.valueOf(i2), ccb);
            Log.i("MicroMsg.AccInfo", "add host " + i2 + " host " + ccb.oTA.get(0).MhX);
            AppMethodBeat.o(132641);
        } catch (Exception e2) {
            Log.e("MicroMsg.AccInfo", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132641);
        }
    }

    @Override // com.tencent.mm.network.f, com.tencent.mm.network.e
    public final void b(int i2, byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(132642);
        Log.i("MicroMsg.AccInfo", "setAxAuthSessionKey");
        ccb ccb = this.jDu.get(Integer.valueOf(i2));
        if (ccb == null || ccb.oTA.size() == 0) {
            Log.w("MicroMsg.AccInfo", "can not get host list , buss type ".concat(String.valueOf(i2)));
            AppMethodBeat.o(132642);
            return;
        }
        ie ieVar = new ie();
        try {
            ieVar.parseFrom(bArr);
            Log.i("MicroMsg.AccInfo", "axsession key length: server [%d], client [%d]", Integer.valueOf(ieVar.KLr.getILen()), Integer.valueOf(ieVar.KLq.getILen()));
            C0483a aVar = new C0483a();
            aVar.jDy = ieVar;
            aVar.jDz = bArr2;
            Iterator<cca> it = ccb.oTA.iterator();
            while (it.hasNext()) {
                cca next = it.next();
                this.jDv.put(next, aVar);
                Log.i("MicroMsg.AccInfo", "receive axauth host " + next.MhY);
            }
            AppMethodBeat.o(132642);
        } catch (Exception e2) {
            Log.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132642);
        }
    }

    public final void bjp() {
        AppMethodBeat.i(132643);
        if (!(this.jDp == null && this.jDq == null && this.jDv.isEmpty())) {
            this.jDp = null;
            this.jDq = null;
            this.jDv.clear();
        }
        AppMethodBeat.o(132643);
    }

    @Override // com.tencent.mm.network.f, com.tencent.mm.network.e
    public final void aZf() {
        AppMethodBeat.i(132644);
        this.jDv.clear();
        AppMethodBeat.o(132644);
    }

    @Override // com.tencent.mm.network.f, com.tencent.mm.network.e
    public final void aZg() {
        AppMethodBeat.i(132645);
        Log.i("MicroMsg.AccInfo", "clearAxHost");
        this.jDu.clear();
        AppMethodBeat.o(132645);
    }

    @Override // com.tencent.mm.network.f, com.tencent.mm.network.e
    public final boolean MG(String str) {
        AppMethodBeat.i(132646);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(132646);
            return false;
        }
        for (Map.Entry<Integer, ccb> entry : this.jDu.entrySet()) {
            ccb value = entry.getValue();
            if (!(value == null || value.oTA == null)) {
                Iterator<cca> it = value.oTA.iterator();
                while (it.hasNext()) {
                    cca next = it.next();
                    if (next != null && str.equals(next.MhY)) {
                        AppMethodBeat.o(132646);
                        return true;
                    }
                }
                continue;
            }
        }
        AppMethodBeat.o(132646);
        return false;
    }

    @Override // com.tencent.mm.network.f, com.tencent.mm.network.e
    public final byte[] MD(String str) {
        byte[] bArr;
        AppMethodBeat.i(132647);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(132647);
            return null;
        }
        Iterator<Map.Entry<cca, C0483a>> it = this.jDv.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                bArr = null;
                break;
            }
            Map.Entry<cca, C0483a> next = it.next();
            if (str.equals(next.getKey().MhY)) {
                bArr = next.getValue().jDz;
                break;
            }
        }
        AppMethodBeat.o(132647);
        return bArr;
    }

    @Override // com.tencent.mm.network.f
    public final void ax(byte[] bArr) {
        AppMethodBeat.i(132648);
        this.jDw.add(new String(bArr));
        AppMethodBeat.o(132648);
    }

    @Override // com.tencent.mm.network.f
    public final boolean ay(byte[] bArr) {
        AppMethodBeat.i(132649);
        boolean contains = this.jDw.contains(new String(bArr));
        AppMethodBeat.o(132649);
        return contains;
    }

    public final boolean RM(String str) {
        AppMethodBeat.i(132650);
        if ("axhost".equals(str)) {
            boolean isEmpty = this.jDu.isEmpty();
            AppMethodBeat.o(132650);
            return isEmpty;
        }
        boolean isEmpty2 = this.jDw.isEmpty();
        AppMethodBeat.o(132650);
        return isEmpty2;
    }

    @Override // com.tencent.mm.network.f
    public final boolean RN(String str) {
        AppMethodBeat.i(132651);
        if (!MG(str)) {
            AppMethodBeat.o(132651);
            return false;
        }
        byte[] ME = ME(str);
        byte[] MF = MF(str);
        if (ME == null || ME.length <= 0 || MF == null || MF.length <= 0) {
            AppMethodBeat.o(132651);
            return false;
        }
        AppMethodBeat.o(132651);
        return true;
    }

    @Override // com.tencent.mm.network.f, com.tencent.mm.network.e
    public final byte[] ME(String str) {
        ie ieVar;
        AppMethodBeat.i(132652);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(132652);
            return null;
        }
        Iterator<Map.Entry<cca, C0483a>> it = this.jDv.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                ieVar = null;
                break;
            }
            Map.Entry<cca, C0483a> next = it.next();
            if (str.equals(next.getKey().MhY)) {
                ieVar = next.getValue().jDy;
                break;
            }
        }
        if (ieVar != null) {
            try {
                byte[] bufferToBytes = ieVar.KLq.getBufferToBytes();
                AppMethodBeat.o(132652);
                return bufferToBytes;
            } catch (Exception e2) {
                Log.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(132652);
                return null;
            }
        } else {
            AppMethodBeat.o(132652);
            return null;
        }
    }

    @Override // com.tencent.mm.network.f, com.tencent.mm.network.e
    public final byte[] MF(String str) {
        ie ieVar;
        AppMethodBeat.i(132653);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(132653);
            return null;
        }
        Iterator<Map.Entry<cca, C0483a>> it = this.jDv.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                ieVar = null;
                break;
            }
            Map.Entry<cca, C0483a> next = it.next();
            if (str.equals(next.getKey().MhY)) {
                ieVar = next.getValue().jDy;
                break;
            }
        }
        if (ieVar != null) {
            try {
                byte[] bufferToBytes = ieVar.KLr.getBufferToBytes();
                AppMethodBeat.o(132653);
                return bufferToBytes;
            } catch (Exception e2) {
                Log.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(132653);
                return null;
            }
        } else {
            AppMethodBeat.o(132653);
            return null;
        }
    }

    public static void bK(String str, String str2) {
        AppMethodBeat.i(197078);
        try {
            Log.i("MicroMsg.AccInfo", "saveBackUpCgiSignKeys " + str.length() + " " + str2.length());
            jDx.jDD = str;
            jDx.jDC = str2;
            AppMethodBeat.o(197078);
        } catch (Exception e2) {
            Log.e("MicroMsg.AccInfo", e2.getLocalizedMessage());
            AppMethodBeat.o(197078);
        }
    }

    public static String[] aZl() {
        AppMethodBeat.i(197079);
        String[] strArr = new String[2];
        if (jDx != null) {
            strArr[0] = jDx.jDD;
            strArr[1] = jDx.jDC;
            AppMethodBeat.o(197079);
        } else {
            Log.e("MicroMsg.AccInfo", "no find cgi sign keys");
            AppMethodBeat.o(197079);
        }
        return strArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.network.a$a  reason: collision with other inner class name */
    public class C0483a {
        public ie jDy;
        public byte[] jDz;

        C0483a() {
        }
    }
}
