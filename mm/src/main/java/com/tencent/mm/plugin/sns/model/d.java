package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.protocal.protobuf.bft;
import com.tencent.mm.protocal.protobuf.ehm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import java.util.Iterator;
import java.util.LinkedList;

public final class d {
    public static void f(String str, long j2, long j3, int i2) {
        bft bft;
        AppMethodBeat.i(95452);
        if (j3 == 0) {
            AppMethodBeat.o(95452);
            return;
        }
        bft aQp = aj.faS().aQp(str);
        if (aQp == null) {
            bft = new bft();
        } else {
            bft = aQp;
        }
        if (j2 != 0 || !bft.LPq.isEmpty()) {
            if (j2 == 0) {
                j2 = bft.LPq.getFirst().Lvb;
            }
            ami ami = new ami();
            ami.Lvb = j2;
            ami.Lvc = j3;
            ehm ehm = new ehm();
            ehm.NgY = j2;
            ehm.NgZ = j3;
            ehm.Nha = i2;
            ami.Lvd.add(ehm);
            while (true) {
                if (bft.LPq.isEmpty()) {
                    break;
                }
                ami first = bft.LPq.getFirst();
                if (aq(ami.Lvc, first.Lvb) > 0) {
                    Log.e("MicroMsg.FaultLogic", "has a fault: newerMin:" + ami.Lvc + " fault.Max" + first.Lvb);
                    break;
                } else {
                    bft.LPq.removeFirst();
                    ami = a(first, ami);
                }
            }
            bft.LPq.addFirst(ami);
            while (bft.LPq.size() > 100) {
                bft.LPq.removeLast();
            }
            if (bft.LPq.size() > 0) {
                Log.d("MicroMsg.FaultLogic", "min " + bft.LPq.get(0).Lvc + " max " + bft.LPq.get(0).Lvb);
            }
            l aQr = aj.faS().aQr(str);
            try {
                aQr.field_userName = str;
                aQr.field_faultS = bft.toByteArray();
                aj.faS().c(aQr);
            } catch (Exception e2) {
            }
            if (bft.LPq.size() > 1) {
                Log.d("MicroMsg.FaultLogic", "fault size : " + bft.LPq.size());
                Iterator<ami> it = bft.LPq.iterator();
                while (it.hasNext()) {
                    ami next = it.next();
                    Log.d("MicroMsg.FaultLogic", "min - max " + next.Lvc + " " + next.Lvb);
                }
            }
            AppMethodBeat.o(95452);
            return;
        }
        AppMethodBeat.o(95452);
    }

    private static ami a(ami ami, ami ami2) {
        int i2;
        long j2;
        AppMethodBeat.i(95453);
        ami ami3 = new ami();
        if (aq(ami.Lvb, ami2.Lvb) > 0) {
            ami3.Lvb = ami.Lvb;
        } else {
            ami3.Lvb = ami2.Lvb;
        }
        if (aq(ami.Lvc, ami2.Lvc) < 0) {
            ami3.Lvc = ami.Lvc;
        } else {
            ami3.Lvc = ami2.Lvc;
        }
        LinkedList<ehm> linkedList = ami.Lvd;
        Iterator<ehm> it = ami2.Lvd.iterator();
        while (it.hasNext()) {
            ehm next = it.next();
            if (linkedList.isEmpty()) {
                Log.e("MicroMsg.FaultLogic", "fault's segments should not empty!!");
                linkedList.addFirst(next);
            } else {
                long j3 = next.NgZ;
                int size = linkedList.size() - 1;
                while (true) {
                    if (size < 0) {
                        size = -1;
                        break;
                    } else if (aq(j3, linkedList.get(size).NgY) <= 0) {
                        break;
                    } else {
                        size--;
                    }
                }
                long j4 = next.NgY;
                int i3 = 0;
                while (true) {
                    i2 = i3;
                    if (i2 >= linkedList.size()) {
                        i2 = linkedList.size();
                        break;
                    } else if (aq(j4, linkedList.get(i2).NgZ) >= 0) {
                        break;
                    } else {
                        i3 = i2 + 1;
                    }
                }
                if (size == -1) {
                    linkedList.addFirst(next);
                } else if (i2 == linkedList.size()) {
                    linkedList.addLast(next);
                } else {
                    ehm ehm = linkedList.get(i2);
                    if (aq(next.NgY, ehm.NgY) < 0) {
                        ehm ehm2 = new ehm();
                        ehm2.NgY = ehm.NgY;
                        long j5 = next.NgY;
                        if (j5 == MAlarmHandler.NEXT_FIRE_INTERVAL) {
                            j2 = Long.MIN_VALUE;
                        } else {
                            j2 = j5 + 1;
                        }
                        ehm2.NgZ = j2;
                        ehm2.Nha = ehm.Nha;
                        linkedList.add(i2, ehm2);
                        size++;
                        i2++;
                    }
                    ehm ehm3 = linkedList.get(size);
                    if (aq(next.NgZ, ehm3.NgZ) > 0) {
                        ehm ehm4 = new ehm();
                        ehm4.NgZ = ehm3.NgZ;
                        ehm4.NgY = Jf(next.NgZ);
                        ehm4.Nha = ehm3.Nha;
                        linkedList.add(size + 1, ehm4);
                    }
                    while (size >= i2) {
                        linkedList.remove(size);
                        size--;
                    }
                    linkedList.add(i2, next);
                    if (linkedList.size() > 100) {
                        long j6 = linkedList.getLast().NgZ;
                        long j7 = linkedList.getLast().NgY;
                        int i4 = linkedList.getLast().Nha;
                        while (linkedList.size() >= 100) {
                            ehm removeLast = linkedList.removeLast();
                            j7 = removeLast.NgY;
                            if (removeLast.Nha < i4) {
                                i4 = removeLast.Nha;
                            }
                        }
                        ehm ehm5 = new ehm();
                        ehm5.NgY = j7;
                        ehm5.NgZ = j6;
                        ehm5.Nha = i4;
                        linkedList.addLast(ehm5);
                    }
                }
            }
        }
        ami3.Lvd = linkedList;
        AppMethodBeat.o(95453);
        return ami3;
    }

    private static long aq(long j2, long j3) {
        if ((j2 <= 0 || j3 <= 0) && (j2 >= 0 || j3 >= 0)) {
            return j2 < 0 ? 1 : -1;
        }
        return j2 - j3;
    }

    public static long Jf(long j2) {
        if (j2 == Long.MIN_VALUE) {
            return MAlarmHandler.NEXT_FIRE_INTERVAL;
        }
        return j2 - 1;
    }

    public static int a(long j2, long j3, String str) {
        AppMethodBeat.i(95454);
        bft aQp = aj.faS().aQp(str);
        LinkedList<ami> linkedList = aQp.LPq;
        Log.i("MicroMsg.FaultLogic", "getLastReqTimeByMinId fault.count %s", Integer.valueOf(aQp.LPq.size()));
        if (linkedList.isEmpty()) {
            AppMethodBeat.o(95454);
            return 0;
        }
        ami first = linkedList.getFirst();
        if (j2 == 0 || aq(first.Lvc, j2) > 0) {
            Log.e("MicroMsg.FaultLogic", "has a fault  minId:" + j3 + " fault.min:" + first.Lvc);
            AppMethodBeat.o(95454);
            return 0;
        } else if (j3 == 0 || aq(first.Lvb, j3) >= 0) {
            LinkedList<ehm> linkedList2 = first.Lvd;
            if (linkedList2.isEmpty()) {
                AppMethodBeat.o(95454);
                return 0;
            }
            Iterator<ehm> it = linkedList2.iterator();
            int i2 = Integer.MAX_VALUE;
            while (it.hasNext()) {
                ehm next = it.next();
                if (j3 == 0 || aq(j3, next.NgZ) >= 0) {
                    if (next.Nha < i2) {
                        i2 = next.Nha;
                    }
                    if (aq(j2, next.NgZ) >= 0) {
                        if (i2 == Integer.MAX_VALUE) {
                            AppMethodBeat.o(95454);
                            return 0;
                        }
                        AppMethodBeat.o(95454);
                        return i2;
                    }
                }
            }
            Log.i("MicroMsg.FaultLogic", "should not to hear  minId:".concat(String.valueOf(j2)));
            AppMethodBeat.o(95454);
            return 0;
        } else {
            Log.e("MicroMsg.FaultLogic", ":" + j3 + " fault.max:" + first.Lvb);
            AppMethodBeat.o(95454);
            return 0;
        }
    }
}
