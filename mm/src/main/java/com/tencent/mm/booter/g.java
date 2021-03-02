package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.l;
import com.tencent.mm.b.o;
import com.tencent.mm.g.a.jm;
import com.tencent.mm.g.a.oy;
import com.tencent.mm.g.a.wf;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelmulti.b;
import com.tencent.mm.network.af;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.v;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class g {
    public static boolean a(int i2, int i3, byte[] bArr, byte[] bArr2, long j2) {
        long v;
        AppMethodBeat.i(131930);
        Log.i("MicroMsg.NotifySyncMgr", "dealWithNotify Here, MM should NOT bOotEd , opType:%d respType:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 1) {
            yN(2);
            AppMethodBeat.o(131930);
            return true;
        } else if (i2 != 2) {
            AppMethodBeat.o(131930);
            return false;
        } else {
            switch (i3) {
                case 138:
                    if (bArr == null) {
                        v = 7;
                    } else {
                        v = (long) o.v(bArr, 0);
                    }
                    yN(v);
                    break;
                case 268369921:
                    if (Util.isNullOrNil(bArr) || bArr.length <= 8) {
                        Log.e("MicroMsg.NotifySyncMgr", "dkpush dealWithNotify respBuf error ");
                        break;
                    } else {
                        int v2 = o.v(bArr, 0);
                        int v3 = o.v(bArr, 4);
                        Log.d("MicroMsg.NotifySyncMgr", "dkpush: flag:" + v2 + " bufLen:" + v3 + " dump:" + Util.dumpHexBuf(bArr, 0, 8));
                        if (v3 != bArr.length - 8) {
                            Log.e("MicroMsg.NotifySyncMgr", "dkpush: respBuf length error len:" + bArr.length);
                            break;
                        } else {
                            byte[] bArr3 = new byte[v3];
                            System.arraycopy(bArr, 8, bArr3, 0, v3);
                            v.b bVar = new v.b();
                            PByteArray pByteArray = new PByteArray();
                            PByteArray pByteArray2 = new PByteArray();
                            PInt pInt = new PInt();
                            PInt pInt2 = new PInt();
                            PInt pInt3 = new PInt(0);
                            PInt pInt4 = new PInt(255);
                            try {
                                boolean unpack = MMProtocalJni.unpack(pByteArray2, bArr3, bArr2, pByteArray, pInt, pInt2, pInt3, pInt4);
                                if (pInt3.value != 0) {
                                    jm jmVar = new jm();
                                    jmVar.dOn.dOo = pInt3.value;
                                    Log.i("MicroMsg.NotifySyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(EventCenter.instance.publish(jmVar)));
                                    pInt3.value = 0;
                                }
                                if (!(pInt2.value != 13 || af.bkl() == null || af.bkl().jEj == null)) {
                                    byte[] qe = af.bkl().jEj.qe(3);
                                    pByteArray2.value = UtilsJni.AesGcmDecryptWithUncompress(qe, pByteArray2.value);
                                    Object[] objArr = new Object[3];
                                    objArr[0] = Integer.valueOf(qe == null ? -1 : qe.length);
                                    objArr[1] = pByteArray2.value;
                                    objArr[2] = Integer.valueOf(pByteArray2.value == null ? -1 : pByteArray2.value.length);
                                    Log.i("MicroMsg.NotifySyncMgr", "summerdiz dealWithPushResp unpack AES_GCM_ENCRYPT serverSession[%s] new pr[%s, %s]", objArr);
                                }
                                if (unpack) {
                                    bVar.setHeadExtFlags(pInt4.value);
                                    if (pInt.value != -13) {
                                        int fromProtoBuf = bVar.fromProtoBuf(pByteArray2.value);
                                        Log.d("MicroMsg.NotifySyncMgr", "bufToResp using protobuf ok");
                                        bVar.setRetCode(fromProtoBuf);
                                        bVar.setBufferSize((long) bArr3.length);
                                        byte[] decodeHexString = Util.decodeHexString(MMApplicationContext.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.aps()).getString("notify_sync_key_keybuf", ""));
                                        byte[] a2 = z.a(bVar.KAh.Lev);
                                        if (!Util.isNullOrNil(a2) && ad.m(decodeHexString, a2)) {
                                            new b(bVar, v2, j2).doScene(af.bkl(), new i() {
                                                /* class com.tencent.mm.booter.g.AnonymousClass1 */

                                                @Override // com.tencent.mm.ak.i
                                                public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                                                    AppMethodBeat.i(131928);
                                                    Log.i("MicroMsg.NotifySyncMgr", "onGYNetEnd: %d [%d,%d,%s]", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), str);
                                                    AppMethodBeat.o(131928);
                                                }
                                            });
                                            if (pInt3.value != 0) {
                                                jm jmVar2 = new jm();
                                                jmVar2.dOn.dOo = pInt3.value;
                                                Log.i("MicroMsg.NotifySyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(EventCenter.instance.publish(jmVar2)));
                                                pInt3.value = 0;
                                                break;
                                            }
                                        } else {
                                            Log.e("MicroMsg.NotifySyncMgr", "compareKeybuf syncKey failed");
                                            break;
                                        }
                                    } else {
                                        bVar.setRetCode(pInt.value);
                                        Log.e("MicroMsg.NotifySyncMgr", "unpack push resp failed session timeout");
                                        break;
                                    }
                                } else {
                                    Log.e("MicroMsg.NotifySyncMgr", "unpack push resp failed");
                                    break;
                                }
                            } catch (Exception e2) {
                                Log.e("MicroMsg.NotifySyncMgr", "unpack push resp failed: %s", e2);
                                Log.printErrStackTrace("MicroMsg.NotifySyncMgr", e2, "", new Object[0]);
                            }
                        }
                    }
                    break;
                case 1000000205:
                    aa.b bVar2 = new aa.b();
                    try {
                        bVar2.fromProtoBuf(bArr);
                        yN(bVar2.KAs);
                        break;
                    } catch (Exception e3) {
                        Log.printErrStackTrace("MicroMsg.NotifySyncMgr", e3, "", new Object[0]);
                        break;
                    }
                case 2147480001:
                    yN(7);
                    break;
            }
            AppMethodBeat.o(131930);
            return true;
        }
    }

    private static void yN(long j2) {
        AppMethodBeat.i(131931);
        Log.i("MicroMsg.NotifySyncMgr", "dealWithSelector, selector = ".concat(String.valueOf(j2)));
        if ((256 & j2) != 0) {
            wf wfVar = new wf();
            wfVar.ecp.sourceType = 4;
            EventCenter.instance.publish(wfVar);
        }
        if ((2097152 & j2) != 0) {
            EventCenter.instance.publish(new oy());
        }
        if ((-16777217 & j2 & -33 & -257 & -2097153 & 2) != 0) {
            new b().doScene(af.bkl(), new i() {
                /* class com.tencent.mm.booter.g.AnonymousClass2 */

                @Override // com.tencent.mm.ak.i
                public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(131929);
                    Log.i("MicroMsg.NotifySyncMgr", "onGYNetEnd: %d [%d,%d,%s]", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), str);
                    AppMethodBeat.o(131929);
                }
            });
        }
        AppMethodBeat.o(131931);
    }

    public static byte[] a(PInt pInt, int i2) {
        AppMethodBeat.i(131932);
        String nQ = nQ(i2);
        int CQ = CQ(nQ);
        for (int i3 = 1; i3 <= CQ; i3++) {
            String str = nQ + "/syncResp.bin" + i3;
            if (s.YS(str)) {
                byte[] aW = s.aW(str, 0, -1);
                if (Util.isNullOrNil(aW)) {
                    Log.w("MicroMsg.NotifySyncMgr", "readFile getdata null, read again");
                    aW = s.aW(str, 0, -1);
                }
                String messageDigest = com.tencent.mm.b.g.getMessageDigest((com.tencent.mm.compatible.deviceinfo.q.dr(true) + i2).getBytes());
                byte[] d2 = l.d(aW, messageDigest.getBytes());
                Log.i("MicroMsg.NotifySyncMgr", "readFile, index:[%d of %d], dump data:%s -> %s, key:%s", Integer.valueOf(i3), Integer.valueOf(CQ), ab(aW), ab(d2), ab(messageDigest.getBytes()));
                if (!Util.isNullOrNil(d2)) {
                    pInt.value = i3;
                    AppMethodBeat.o(131932);
                    return d2;
                }
            }
        }
        AppMethodBeat.o(131932);
        return null;
    }

    public static void cq(int i2, int i3) {
        AppMethodBeat.i(131933);
        String nQ = nQ(i3);
        int CQ = CQ(nQ);
        s.deleteFile(nQ + "/syncResp.bin" + i2);
        Log.i("MicroMsg.NotifySyncMgr", "consumeData delIndex:%d, total index:%d", Integer.valueOf(i2), Integer.valueOf(CQ));
        if (i2 == CQ) {
            s.deleteFile(nQ + "/syncResp.ini");
            Log.i("MicroMsg.NotifySyncMgr", "consumeData: has consme all respdata");
        }
        AppMethodBeat.o(131933);
    }

    public static int CQ(String str) {
        int i2 = 0;
        AppMethodBeat.i(131934);
        byte[] aW = s.aW(str + "/syncResp.ini", 0, -1);
        if (Util.isNullOrNil(aW)) {
            AppMethodBeat.o(131934);
        } else {
            try {
                i2 = Integer.parseInt(new String(aW));
                AppMethodBeat.o(131934);
            } catch (NumberFormatException e2) {
                AppMethodBeat.o(131934);
            }
        }
        return i2;
    }

    public static String nQ(int i2) {
        AppMethodBeat.i(131935);
        String str = e.qf(i2) + "pushSyncResp";
        s.boN(str);
        AppMethodBeat.o(131935);
        return str;
    }

    public static String ab(byte[] bArr) {
        AppMethodBeat.i(131936);
        if (Util.isNullOrNil(bArr)) {
            AppMethodBeat.o(131936);
            return "buf is nullOrNil";
        } else if (bArr.length == 1) {
            String str = "buf.len is 1: " + Integer.toHexString(bArr[0]);
            AppMethodBeat.o(131936);
            return str;
        } else {
            String str2 = "buf last two[len:" + bArr.length + "]: %s, %s" + Integer.toHexString(bArr[bArr.length - 2] & 255) + ", " + Integer.toHexString(bArr[bArr.length - 1] & 255);
            AppMethodBeat.o(131936);
            return str2;
        }
    }
}
