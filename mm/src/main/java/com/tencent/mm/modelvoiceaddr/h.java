package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.esk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class h {
    String jwL;
    LinkedHashMap<String, a> jwM = new LinkedHashMap<>();
    final ReadWriteLock jwN = new ReentrantReadWriteLock();
    private StringBuilder jwO = new StringBuilder();

    public h(String str) {
        AppMethodBeat.i(148591);
        this.jwL = str;
        AppMethodBeat.o(148591);
    }

    public final LinkedList<dqi> biA() {
        AppMethodBeat.i(148592);
        LinkedList<dqi> linkedList = new LinkedList<>();
        this.jwN.readLock().lock();
        for (a aVar : this.jwM.values()) {
            if (aVar.jwQ) {
                linkedList.add(new dqi().bhy(aVar.jwP));
            }
        }
        this.jwN.readLock().unlock();
        AppMethodBeat.o(148592);
        return linkedList;
    }

    public final String getResult() {
        AppMethodBeat.i(148593);
        this.jwO.setLength(0);
        this.jwN.readLock().lock();
        for (a aVar : this.jwM.values()) {
            if (aVar.data != null) {
                this.jwO.append(aVar.data);
            }
        }
        this.jwN.readLock().unlock();
        String sb = this.jwO.toString();
        AppMethodBeat.o(148593);
        return sb;
    }

    public final boolean biB() {
        boolean z;
        AppMethodBeat.i(148594);
        this.jwN.readLock().lock();
        if (this.jwM.size() == 0) {
            Log.i("MicroMsg.ShortSentenceContainer", "isAllRespEnd innerContainer.size() == 0");
            this.jwN.readLock().unlock();
            AppMethodBeat.o(148594);
            return true;
        }
        Iterator<a> it = this.jwM.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            a next = it.next();
            Log.d("MicroMsg.ShortSentenceContainer", "isAllRespEnd voiceId:%s isRequestEnd:%s isResponseEnd:%s", next.jwP, Boolean.valueOf(next.jwR), Boolean.valueOf(next.jwV));
            if (!next.jwV) {
                z = false;
                break;
            }
        }
        this.jwN.readLock().unlock();
        AppMethodBeat.o(148594);
        return z;
    }

    public final void aI(List<esk> list) {
        String sb;
        Integer valueOf;
        int length;
        AppMethodBeat.i(148595);
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(list == null ? 0 : list.size());
        this.jwN.readLock().lock();
        if (this.jwM.size() == 0) {
            this.jwN.readLock().unlock();
            sb = "[]";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[");
            for (a aVar : this.jwM.values()) {
                sb2.append(aVar.jwP).append(", ");
            }
            if (sb2.length() <= 3) {
                this.jwN.readLock().unlock();
                sb = sb2.append("]").toString();
            } else {
                sb2.setLength(sb2.length() - 2);
                this.jwN.readLock().unlock();
                sb = sb2.append("]").toString();
            }
        }
        objArr[1] = sb;
        Log.d("MicroMsg.ShortSentenceContainer", "updateVoiceInfoResult respVTList size %s innerContainer %s", objArr);
        if (list == null || list.size() == 0) {
            Log.i("MicroMsg.ShortSentenceContainer", "respList == null");
            AppMethodBeat.o(148595);
            return;
        }
        this.jwN.readLock().lock();
        for (esk esk : list) {
            if (esk == null) {
                Log.i("MicroMsg.ShortSentenceContainer", "setFetchedVoiceInfoResult voiceTransCell is null.");
            } else {
                a aVar2 = this.jwM.get(esk.KXr);
                if (aVar2 == null) {
                    Log.i("MicroMsg.ShortSentenceContainer", "voiceInfoContainer not found the voiceId %s", esk.KXr);
                } else if (esk == null) {
                    Log.d("MicroMsg.ShortSentenceContainer", "update VoiceInfo cell is null");
                } else {
                    Object[] objArr2 = new Object[12];
                    objArr2[0] = esk.KXr;
                    objArr2[1] = Integer.valueOf(esk.NpA);
                    objArr2[2] = (esk.Nlq == null || esk.Nlq.getBuffer() == null) ? null : Integer.valueOf(esk.Nlq.getILen());
                    objArr2[3] = Boolean.valueOf(esk.jeU != 0);
                    objArr2[4] = Integer.valueOf(esk.jeU);
                    objArr2[5] = aVar2.jwP;
                    objArr2[6] = Boolean.valueOf(aVar2.jwQ);
                    objArr2[7] = Boolean.valueOf(aVar2.jwR);
                    objArr2[8] = Integer.valueOf(aVar2.jwS);
                    objArr2[9] = Integer.valueOf(aVar2.jwU);
                    if (aVar2.data == null) {
                        valueOf = null;
                    } else {
                        valueOf = Integer.valueOf(aVar2.data.length());
                    }
                    objArr2[10] = valueOf;
                    objArr2[11] = Boolean.valueOf(aVar2.jwV);
                    Log.d("MicroMsg.ShortSentenceContainer", "update VoiceInfo get {cell} %s, seq %s, text %s, endFlag %s, endFlag %s {currentInfo} %s, isRequestStart %s, isRequestEnd %s, voiceFileMark %s, seq %s, data %s, isResponseEnd %s", objArr2);
                    if (esk.NpA < aVar2.jwU || aVar2.jwV) {
                        Log.d("MicroMsg.ShortSentenceContainer", "update seq not fit.");
                    } else {
                        aVar2.jwU = esk.NpA;
                        aVar2.data = (esk.Nlq == null || esk.Nlq.getBuffer() == null) ? null : esk.Nlq.getBuffer().yO();
                        aVar2.jwV = esk.jeU != 0;
                        Object[] objArr3 = new Object[4];
                        objArr3[0] = esk.KXr;
                        objArr3[1] = Integer.valueOf(aVar2.jwU);
                        objArr3[2] = Boolean.valueOf(aVar2.jwV);
                        if (aVar2.data == null) {
                            length = -1;
                        } else {
                            length = aVar2.data.length();
                        }
                        objArr3[3] = Integer.valueOf(length);
                        Log.i("MicroMsg.ShortSentenceContainer", "update VoiceId = %s,respSeq = %s,isResponseEnd = %s,data.length = %s", objArr3);
                        if (esk.jeU == 2) {
                            Log.e("MicroMsg.ShortSentenceContainer", "update cell.EndFlag = 2 VoiceId = %s", esk.KXr);
                        }
                    }
                }
            }
        }
        this.jwN.readLock().unlock();
        AppMethodBeat.o(148595);
    }

    public final void ul(int i2) {
        AppMethodBeat.i(148596);
        Log.i("MicroMsg.ShortSentenceContainer", "cutShortSentence markEnd:%s", Integer.valueOf(i2));
        if (i2 < 0) {
            IllegalStateException illegalStateException = new IllegalStateException("splitShortSentence file mark less than zero. mark: ".concat(String.valueOf(i2)));
            AppMethodBeat.o(148596);
            throw illegalStateException;
        }
        this.jwN.readLock().lock();
        if (this.jwM.size() == 0) {
            Log.e("MicroMsg.ShortSentenceContainer", "splitShortSentence there is no last one");
            this.jwN.readLock().unlock();
            AppMethodBeat.o(148596);
            return;
        }
        Iterator<a> it = this.jwM.values().iterator();
        a aVar = null;
        while (it.hasNext()) {
            aVar = it.next();
        }
        if (aVar == null) {
            IllegalStateException illegalStateException2 = new IllegalStateException("splitShortSentence last info is null");
            AppMethodBeat.o(148596);
            throw illegalStateException2;
        }
        Log.d("MicroMsg.ShortSentenceContainer", "cutShortSentence voiceFileMarkEnd:%s voiceId:%s markEnd:%s", Integer.valueOf(aVar.jwS), aVar.jwP, Integer.valueOf(i2));
        aVar.jwS = i2;
        this.jwN.readLock().unlock();
        AppMethodBeat.o(148596);
    }

    public final void biC() {
        AppMethodBeat.i(148597);
        Log.i("MicroMsg.ShortSentenceContainer", "createNewShortSentence");
        this.jwN.writeLock().lock();
        a aVar = new a();
        this.jwM.put(aVar.jwP, aVar);
        this.jwN.writeLock().unlock();
        AppMethodBeat.o(148597);
    }

    public final a um(int i2) {
        a aVar;
        AppMethodBeat.i(148598);
        this.jwN.readLock().lock();
        if (this.jwM.size() == 0) {
            this.jwN.readLock().unlock();
            AppMethodBeat.o(148598);
            return null;
        }
        Iterator<a> it = this.jwM.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = null;
                break;
            }
            aVar = it.next();
            Log.d("MicroMsg.ShortSentenceContainer", "locateCurrentShortSentence oldOffset = %s voiceFileMarkEnd = %s info.isRequestEnd = %s", Integer.valueOf(i2), Integer.valueOf(aVar.jwS), Boolean.valueOf(aVar.jwR));
            if (!aVar.jwR && i2 <= aVar.jwS) {
                break;
            }
        }
        this.jwN.readLock().unlock();
        AppMethodBeat.o(148598);
        return aVar;
    }

    public class a {
        public String data;
        public String jwP;
        public boolean jwQ;
        public boolean jwR;
        public int jwS;
        public int jwT;
        public int jwU;
        public boolean jwV;

        public a() {
            AppMethodBeat.i(148588);
            this.jwQ = false;
            this.jwR = false;
            this.jwS = Integer.MAX_VALUE;
            this.jwT = 0;
            this.jwU = -1;
            this.data = null;
            this.jwV = false;
            this.jwP = Rs(h.this.jwL);
            AppMethodBeat.o(148588);
        }

        public a(String str) {
            AppMethodBeat.i(148589);
            this.jwQ = false;
            this.jwR = false;
            this.jwS = Integer.MAX_VALUE;
            this.jwT = 0;
            this.jwU = -1;
            this.data = null;
            this.jwV = false;
            this.jwP = Rs(str);
            AppMethodBeat.o(148589);
        }

        private static String Rs(String str) {
            AppMethodBeat.i(148590);
            long currentTimeMillis = Util.MAX_32BIT_VALUE & System.currentTimeMillis();
            long nextInt = Util.MAX_32BIT_VALUE & ((long) new Random(System.currentTimeMillis()).nextInt());
            long j2 = (currentTimeMillis << 32) | nextInt;
            if (j2 < 0) {
                j2 = Math.abs(j2);
            }
            String str2 = str + j2;
            Log.i("MicroMsg.ShortSentenceContainer", "finally random = %s(%s) time = %s(%s) id = %s(%s) session = %s strId = %s", Long.valueOf(nextInt), Long.toBinaryString(nextInt), Long.valueOf(currentTimeMillis), Long.toBinaryString(currentTimeMillis), Long.valueOf(j2), Long.toBinaryString(j2), str, str2);
            AppMethodBeat.o(148590);
            return str2;
        }
    }

    public final boolean a(h hVar) {
        AppMethodBeat.i(148599);
        this.jwN.readLock().lock();
        for (a aVar : this.jwM.values()) {
            a aVar2 = new a(hVar.jwL);
            aVar2.jwS = aVar.jwS;
            hVar.jwM.put(aVar2.jwP, aVar2);
        }
        this.jwN.readLock().unlock();
        AppMethodBeat.o(148599);
        return true;
    }

    public final boolean isValid() {
        AppMethodBeat.i(185490);
        if (this.jwM == null || this.jwM.isEmpty()) {
            AppMethodBeat.o(185490);
            return false;
        }
        AppMethodBeat.o(185490);
        return true;
    }
}
