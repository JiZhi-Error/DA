package com.tencent.mm.plugin.emoji.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.bw.b;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cj;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.c;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class a implements cj.a {
    @Override // com.tencent.mm.model.cj.a
    public final void a(h.c cVar) {
    }

    @Override // com.tencent.mm.model.cj.a
    public final void a(h.a aVar) {
        AppMethodBeat.i(108729);
        de deVar = aVar.heO;
        if (deVar.xKb == 10002) {
            String a2 = z.a(deVar.KHn);
            if (Util.isNullOrNil(a2)) {
                Log.w("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "msg content is null");
                AppMethodBeat.o(108729);
                return;
            }
            Map<String, String> parseXml = XmlParser.parseXml(a2, "sysmsg", null);
            if (parseXml != null && parseXml.size() > 0) {
                String str = parseXml.get(".sysmsg.$type");
                if (Util.isNullOrNil(str)) {
                    Log.w("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "empty type");
                    AppMethodBeat.o(108729);
                    return;
                }
                String encodeHexString = Util.encodeHexString(b.cD(q.aoG().getBytes()).aiU(16).zy);
                if (str.equalsIgnoreCase("EmojiBackup")) {
                    int safeParseInt = Util.safeParseInt(parseXml.get(".sysmsg.EmojiBackup.OpCode"));
                    String str2 = parseXml.get(".sysmsg.EmojiBackup.DeviceID");
                    Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "client devicesID:%s server devicesID:%s", encodeHexString, str2);
                    if (Util.isNullOrNil(str2) || !str2.equalsIgnoreCase(encodeHexString)) {
                        ArrayList<ait> amR = b.amR(a2);
                        if (safeParseInt == 1) {
                            if (amR == null || amR.size() <= 0) {
                                Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
                                AppMethodBeat.o(108729);
                                return;
                            }
                            Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. buckupList:%d", Integer.valueOf(amR.size()));
                            c(0, amR);
                            AppMethodBeat.o(108729);
                            return;
                        } else if (safeParseInt != 2) {
                            if (safeParseInt == 3) {
                                Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "set batch emoji download time to 0. ");
                                g.aAh().azQ().set(ar.a.USERINFO_EMOJI_SYNC_CUSTOM_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE);
                            }
                            AppMethodBeat.o(108729);
                            return;
                        } else if (amR == null || amR.size() <= 0) {
                            Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
                            AppMethodBeat.o(108729);
                            return;
                        } else {
                            ArrayList arrayList = new ArrayList();
                            if (amR != null && amR.size() > 0) {
                                Iterator<ait> it = amR.iterator();
                                while (it.hasNext()) {
                                    ait next = it.next();
                                    if (next != null) {
                                        arrayList.add(next.Md5);
                                    }
                                }
                            }
                            k.getEmojiStorageMgr().OpN.iZ(arrayList);
                            g.aAh().azQ().set(ar.a.USERINFO_EMOJI_BACKUP_OVERSIZE_BOOLEAN, Boolean.FALSE);
                            AppMethodBeat.o(108729);
                            return;
                        }
                    } else {
                        Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
                        AppMethodBeat.o(108729);
                        return;
                    }
                } else if (str.equalsIgnoreCase("EmotionBackup")) {
                    int i2 = Util.getInt(parseXml.get(".sysmsg.EmotionBackup.OpCode"), 0);
                    String str3 = parseXml.get(".sysmsg.EmotionBackup.DeviceID");
                    if (Util.isNullOrNil(str3) || !str3.equalsIgnoreCase(encodeHexString)) {
                        ArrayList<String> amS = b.amS(a2);
                        if (amS == null || amS.size() <= 0) {
                            Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
                            AppMethodBeat.o(108729);
                            return;
                        } else if (i2 == 1) {
                            Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. add buckupList:%d", Integer.valueOf(amS.size()));
                            ArrayList<c> arrayList2 = new ArrayList<>();
                            int size = amS.size();
                            for (int i3 = 0; i3 < size; i3++) {
                                arrayList2.add(new com.tencent.mm.plugin.emoji.sync.a.a(amS.get(i3)));
                            }
                            k.cGg().X(arrayList2);
                            k.cGg().rds.cGC();
                            AppMethodBeat.o(108729);
                            return;
                        } else {
                            if (i2 == 2) {
                                Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. delete buckupList:%d", Integer.valueOf(amS.size()));
                                k.getEmojiStorageMgr().OpO.bj(amS);
                            }
                            AppMethodBeat.o(108729);
                            return;
                        }
                    } else {
                        Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
                        AppMethodBeat.o(108729);
                        return;
                    }
                } else if (str.equalsIgnoreCase("SelfieEmojiBackup")) {
                    String str4 = parseXml.get(".sysmsg.SelfieEmojiBackup.DeviceID");
                    Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture client devicesID:%s server devicesID:%s", encodeHexString, str4);
                    if (Util.isNullOrNil(str4) || !str4.equalsIgnoreCase(encodeHexString)) {
                        int safeParseInt2 = Util.safeParseInt(parseXml.get(".sysmsg.SelfieEmojiBackup.OpCode"));
                        ArrayList<ait> amR2 = b.amR(a2);
                        if (amR2 == null || amR2.size() <= 0) {
                            Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: empty list opCode %s", Integer.valueOf(safeParseInt2));
                            AppMethodBeat.o(108729);
                            return;
                        }
                        Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: opCode %s, size %s", Integer.valueOf(safeParseInt2), Integer.valueOf(amR2.size()));
                        if (safeParseInt2 == 1) {
                            Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: add capture %s", Integer.valueOf(amR2.size()));
                            c(1, amR2);
                            AppMethodBeat.o(108729);
                            return;
                        } else if (safeParseInt2 == 2) {
                            Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: delete capture %s", Integer.valueOf(amR2.size()));
                            ArrayList arrayList3 = new ArrayList();
                            Iterator<ait> it2 = amR2.iterator();
                            while (it2.hasNext()) {
                                ait next2 = it2.next();
                                if (next2 != null) {
                                    arrayList3.add(next2.Md5);
                                }
                            }
                            k.getEmojiStorageMgr().OpN.ja(arrayList3);
                            g.aAh().azQ().set(ar.a.USERINFO_EMOJI_BACKUP_OVERSIZE_BOOLEAN, Boolean.FALSE);
                            AppMethodBeat.o(108729);
                            return;
                        } else {
                            if (safeParseInt2 == 3) {
                                Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "back up capture: move to top %s ", Integer.valueOf(amR2.size()));
                                g.aAh().azQ().set(ar.a.USERINFO_EMOJI_SYNC_CAPTURE_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE);
                            }
                            AppMethodBeat.o(108729);
                            return;
                        }
                    } else {
                        Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
                        AppMethodBeat.o(108729);
                        return;
                    }
                } else {
                    Log.e("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "not emoji message type :".concat(String.valueOf(str)));
                }
            }
            AppMethodBeat.o(108729);
            return;
        }
        Log.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "not new xml type:%d ", Integer.valueOf(deVar.xKb));
        AppMethodBeat.o(108729);
    }

    private static void c(int i2, ArrayList<ait> arrayList) {
        AppMethodBeat.i(108730);
        Iterator<ait> it = arrayList.iterator();
        while (it.hasNext()) {
            ait next = it.next();
            EmojiInfo blk = bj.gCJ().OpN.blk(next.Md5);
            if (blk == null) {
                EmojiInfo emojiInfo = new EmojiInfo();
                com.tencent.mm.plugin.emoji.h.b.a(next, emojiInfo);
                if (i2 == 1) {
                    emojiInfo.field_groupId = "capture";
                } else {
                    emojiInfo.field_catalog = EmojiInfo.VkW;
                }
                bj.gCJ().OpN.K(emojiInfo);
            } else {
                if (i2 == 1) {
                    blk.field_groupId = "capture";
                } else {
                    blk.field_catalog = EmojiInfo.VkW;
                }
                bj.gCJ().OpN.L(blk);
            }
        }
        AppMethodBeat.o(108730);
    }
}
