package com.tencent.mm.modelmulti;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.cts;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public final class s {
    private static ArrayList<de> jeC = new ArrayList<>();
    private static ArrayList<as> jeD = new ArrayList<>();

    static {
        AppMethodBeat.i(20563);
        AppMethodBeat.o(20563);
    }

    public static void ds(final int i2, final int i3) {
        AppMethodBeat.i(20560);
        bg.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.modelmulti.s.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(20559);
                s.access$000();
                s.Pn(b.aKJ() + "/testaddmsg.txt");
                if (s.jeD.size() <= 0 || s.jeC.size() <= 0) {
                    Log.e("MicroMsg.TestSyncAddMsg", "syncAddMsg get source failed cmd:%d contact:%d", Integer.valueOf(s.jeC.size()), Integer.valueOf(s.jeD.size()));
                    AppMethodBeat.o(20559);
                    return;
                }
                new MTimerHandler(bg.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                    /* class com.tencent.mm.modelmulti.s.AnonymousClass1.AnonymousClass1 */
                    int jeG = i2;

                    {
                        AppMethodBeat.i(20557);
                        AppMethodBeat.o(20557);
                    }

                    @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                    public final boolean onTimerExpired() {
                        AppMethodBeat.i(20558);
                        if (this.jeG <= 0) {
                            AppMethodBeat.o(20558);
                            return false;
                        }
                        this.jeG--;
                        v.b bVar = new v.b();
                        bVar.KAh.Ley = new abo();
                        int intRandom = Util.getIntRandom(i3, 1);
                        for (int i2 = 0; i2 < intRandom; i2++) {
                            de deVar = (de) s.jeC.get(Util.getIntRandom(s.jeC.size() - 1, 0));
                            deVar.KHl = new dqi().bhy(((as) s.jeD.get(Util.getIntRandom(s.jeD.size() - 1, 0))).field_username);
                            deVar.CreateTime = (int) Util.nowSecond();
                            deVar.Brn = (long) Math.abs(((int) Util.nowMilliSecond()) % 10000000);
                            try {
                                abn abn = new abn();
                                abn.Lmt = new SKBuiltinBuffer_t();
                                abn.Lmt.setBuffer(deVar.toByteArray());
                                abn.Lms = 5;
                                bVar.KAh.Ley.oTA.add(abn);
                                bVar.KAh.Ley.oTz++;
                                Log.d("MicroMsg.TestSyncAddMsg", "syncAddMsg  loop:%d cnt:[%d,%d] cmdList:%d id:%d u:%s", Integer.valueOf(this.jeG), Integer.valueOf(i2), Integer.valueOf(intRandom), Integer.valueOf(bVar.KAh.Ley.oTA.size()), Long.valueOf(deVar.Brn), deVar.KHl.MTo);
                            } catch (Exception e2) {
                                Log.d("MicroMsg.TestSyncAddMsg", e2.getMessage());
                                Log.printErrStackTrace("MicroMsg.TestSyncAddMsg", e2, "", new Object[0]);
                            }
                        }
                        bVar.KAh.KZh = 0;
                        cts cts = bVar.KAh;
                        bg.aVF();
                        cts.Lev = z.aC(Util.decodeHexString(Util.nullAsNil((String) c.azQ().get(8195, new byte[0]))));
                        bVar.KAh.Ret = 0;
                        bVar.KAh.oTW = 0;
                        p.bdS().a(bVar, 0, Util.nowSecond());
                        AppMethodBeat.o(20558);
                        return true;
                    }
                }, true).startTimer(3000);
                AppMethodBeat.o(20559);
            }
        });
        AppMethodBeat.o(20560);
    }

    static /* synthetic */ void access$000() {
        AppMethodBeat.i(20561);
        bg.aVF();
        Cursor e2 = c.aSN().e(null, null, new ArrayList());
        while (e2.moveToNext()) {
            as asVar = new as();
            asVar.convertFrom(e2);
            jeD.add(asVar);
        }
        e2.close();
        AppMethodBeat.o(20561);
    }

    static /* synthetic */ void Pn(String str) {
        BufferedReader bufferedReader;
        int length;
        int i2 = 0;
        AppMethodBeat.i(20562);
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(com.tencent.mm.vfs.s.openRead(str)));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        i2++;
                        String[] split = readLine.split("###");
                        if (split == null || split.length != 3) {
                            Object[] objArr = new Object[2];
                            objArr[0] = Integer.valueOf(i2);
                            if (split == null) {
                                length = -1;
                            } else {
                                length = split.length;
                            }
                            objArr[1] = Integer.valueOf(length);
                            Log.e("MicroMsg.TestSyncAddMsg", "readMsgFromFile parse line %d failed : len:%d ", objArr);
                        } else {
                            de deVar = new de();
                            deVar.KHm = new dqi().bhy(com.tencent.mm.model.z.aTY());
                            deVar.oTW = 2;
                            deVar.KHp = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
                            deVar.xKb = Util.getInt(split[0], 0);
                            deVar.KHo = Util.getInt(split[1], 0);
                            deVar.KHn = new dqi().bhy(split[2]);
                            jeC.add(deVar);
                        }
                    } else {
                        try {
                            bufferedReader.close();
                            AppMethodBeat.o(20562);
                            return;
                        } catch (Exception e2) {
                            AppMethodBeat.o(20562);
                            return;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        Log.e("MicroMsg.TestSyncAddMsg", "readMsgFromFile failed e:%s", e.getMessage());
                        Log.printErrStackTrace("MicroMsg.TestSyncAddMsg", e, "", new Object[0]);
                        try {
                            bufferedReader.close();
                            AppMethodBeat.o(20562);
                        } catch (Exception e4) {
                            AppMethodBeat.o(20562);
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            bufferedReader.close();
                        } catch (Exception e5) {
                        }
                        AppMethodBeat.o(20562);
                        throw th;
                    }
                }
            }
        } catch (Exception e6) {
            e = e6;
            bufferedReader = null;
            Log.e("MicroMsg.TestSyncAddMsg", "readMsgFromFile failed e:%s", e.getMessage());
            Log.printErrStackTrace("MicroMsg.TestSyncAddMsg", e, "", new Object[0]);
            bufferedReader.close();
            AppMethodBeat.o(20562);
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
            bufferedReader.close();
            AppMethodBeat.o(20562);
            throw th;
        }
    }
}
