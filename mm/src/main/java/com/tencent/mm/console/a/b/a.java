package com.tencent.mm.console.a.b;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.widget.Toast;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.vfs.aa;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.List;

public class a implements com.tencent.mm.pluginsdk.cmd.a {
    private static final int[] gML = {0, 1};

    /* renamed from: com.tencent.mm.console.a.b.a$a  reason: collision with other inner class name */
    public interface AbstractC0306a {
        void execute();
    }

    static /* synthetic */ int oQ(int i2) {
        AppMethodBeat.i(20211);
        int oO = oO(i2);
        AppMethodBeat.o(20211);
        return oO;
    }

    static {
        AppMethodBeat.i(20217);
        try {
            Object newInstance = Class.forName("com.tencent.mm.console.a.b.a").newInstance();
            if (newInstance != null && (newInstance instanceof com.tencent.mm.pluginsdk.cmd.a)) {
                b.a((com.tencent.mm.pluginsdk.cmd.a) newInstance, "//aging");
            }
            AppMethodBeat.o(20217);
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.AgingTestCommand", th, "", new Object[0]);
            AppMethodBeat.o(20217);
        }
    }

    private a() {
    }

    @Override // com.tencent.mm.pluginsdk.cmd.a
    public final boolean a(final Context context, final String[] strArr, String str) {
        AppMethodBeat.i(20204);
        if (Log.getLogLevel() > 1) {
            AppMethodBeat.o(20204);
            return false;
        } else if (strArr.length <= 1) {
            AppMethodBeat.o(20204);
            return false;
        } else {
            String aTY = z.aTY();
            final b bVar = new b();
            for (int i2 = 5001; i2 <= 6000; i2++) {
                bVar.gMT.add("rdgztest_atm".concat(String.valueOf(i2)));
            }
            h db = ((l) g.af(l.class)).eiy().getDB();
            Cursor rawQuery = db.rawQuery("SELECT * FROM message WHERE talker=? AND (type=3 OR type=43 OR type=47) AND isSend=1", new String[]{aTY});
            while (rawQuery.moveToNext()) {
                ca caVar = new ca();
                caVar.convertFrom(rawQuery);
                switch (caVar.getType()) {
                    case 3:
                        Cursor rawQuery2 = db.rawQuery("SELECT * FROM " + i.d.OH(aTY) + " WHERE msgSvrId=?", new String[]{String.valueOf(caVar.field_msgSvrId)});
                        if (rawQuery2.moveToNext()) {
                            com.tencent.mm.av.g gVar = new com.tencent.mm.av.g();
                            gVar.convertFrom(rawQuery2);
                            bVar.gMU.add(new c<>(caVar, gVar));
                        }
                        rawQuery2.close();
                        break;
                    case 43:
                        Cursor rawQuery3 = db.rawQuery("SELECT * FROM videoinfo2 WHERE msgsvrid=?", new String[]{String.valueOf(caVar.field_msgSvrId)});
                        if (rawQuery3.moveToNext()) {
                            s sVar = new s();
                            sVar.convertFrom(rawQuery3);
                            bVar.gMV.add(new c<>(caVar, sVar));
                        }
                        rawQuery3.close();
                        break;
                    case 47:
                        Cursor rawQuery4 = db.rawQuery("SELECT * FROM EmojiInfo WHERE md5=?", new String[]{caVar.field_imgPath});
                        if (rawQuery4.moveToNext()) {
                            EmojiInfo emojiInfo = new EmojiInfo();
                            emojiInfo.convertFrom(rawQuery4);
                            bVar.gMW.add(new c<>(caVar, emojiInfo));
                        }
                        rawQuery4.close();
                        break;
                }
            }
            rawQuery.close();
            if (!bVar.gMU.isEmpty() || !bVar.gMW.isEmpty() || !bVar.gMV.isEmpty()) {
                Log.i("MicroMsg.AgingTestCommand", "[oneliang]username size:%s,image size:%s,emoji size:%s,video size:%s", Integer.valueOf(bVar.gMT.size()), Integer.valueOf(bVar.gMU.size()), Integer.valueOf(bVar.gMW.size()), Integer.valueOf(bVar.gMV.size()));
                if (strArr.length == 2) {
                    Toast.makeText(context, "aging begin", 1).show();
                    bg.aAk().postToWorker(new Runnable() {
                        /* class com.tencent.mm.console.a.b.a.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(20199);
                            a.Z(bVar.gMT);
                            a.a(a.this, (String) null, Util.getInt(strArr[1], 0), bVar);
                            a.a(a.this, context);
                            AppMethodBeat.o(20199);
                        }
                    });
                    AppMethodBeat.o(20204);
                    return true;
                } else if (strArr.length < 3) {
                    AppMethodBeat.o(20204);
                    return false;
                } else {
                    final int i3 = Util.getInt(strArr[2], 0);
                    String str2 = strArr[1];
                    char c2 = 65535;
                    switch (str2.hashCode()) {
                        case 49:
                            if (str2.equals("1")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 50:
                            if (str2.equals("2")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 51:
                            if (str2.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                                c2 = 2;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            bg.aAk().postToWorker(new Runnable() {
                                /* class com.tencent.mm.console.a.b.a.AnonymousClass2 */

                                public final void run() {
                                    AppMethodBeat.i(20200);
                                    a.oP(i3);
                                    a.a(a.this, context);
                                    AppMethodBeat.o(20200);
                                }
                            });
                            AppMethodBeat.o(20204);
                            return true;
                        case 1:
                            final String str3 = null;
                            if (strArr.length == 4) {
                                str3 = strArr[3];
                            }
                            bg.aAk().postToWorker(new Runnable() {
                                /* class com.tencent.mm.console.a.b.a.AnonymousClass3 */

                                public final void run() {
                                    AppMethodBeat.i(20201);
                                    a.a(a.this, str3, i3, bVar);
                                    a.a(a.this, context);
                                    AppMethodBeat.o(20201);
                                }
                            });
                            AppMethodBeat.o(20204);
                            return true;
                        case 2:
                            AppMethodBeat.o(20204);
                            return true;
                        default:
                            AppMethodBeat.o(20204);
                            return true;
                    }
                }
            } else {
                Toast.makeText(context, "please send some data(img,video,emoji) to yourself", 1).show();
                AppMethodBeat.o(20204);
                return false;
            }
        }
    }

    private static int oO(int i2) {
        AppMethodBeat.i(CdnLogic.MediaTypeFriendsImageThumb);
        int random = (int) (Math.random() * ((double) i2));
        if (random >= i2) {
            random = 0;
        }
        AppMethodBeat.o(CdnLogic.MediaTypeFriendsImageThumb);
        return random;
    }

    private static as M(String str, int i2) {
        AppMethodBeat.i(20206);
        as asVar = new as();
        asVar.gMZ = (long) (100000 + i2);
        asVar.setUsername(str);
        asVar.BC("alias_".concat(String.valueOf(i2)));
        asVar.setNickname("nickName_".concat(String.valueOf(i2)));
        asVar.BG("quanPin_".concat(String.valueOf(i2)));
        asVar.BF("pyInitial_".concat(String.valueOf(i2)));
        asVar.setType(3);
        AppMethodBeat.o(20206);
        return asVar;
    }

    private static byte[] yW(long j2) {
        byte[] bArr = new byte[8];
        bArr[7] = (byte) ((int) (j2 & 255));
        bArr[6] = (byte) ((int) ((j2 >> 8) & 255));
        bArr[5] = (byte) ((int) ((j2 >> 16) & 255));
        bArr[4] = (byte) ((int) ((j2 >> 24) & 255));
        bArr[3] = (byte) ((int) ((j2 >> 32) & 255));
        bArr[2] = (byte) ((int) ((j2 >> 40) & 255));
        bArr[1] = (byte) ((int) ((j2 >> 48) & 255));
        bArr[0] = (byte) ((int) ((j2 >> 56) & 255));
        return bArr;
    }

    static /* synthetic */ void Z(List list) {
        AppMethodBeat.i(20207);
        if (list != null) {
            Log.i("MicroMsg.AgingTestCommand", "[oneliang]do insert contact by username list begin,count:" + list.size());
            for (int i2 = 0; i2 < list.size(); i2++) {
                String str = (String) list.get(i2);
                as M = M(str, i2);
                if (!((l) g.af(l.class)).aSN().bjN(str)) {
                    ((l) g.af(l.class)).aSN().ap(M);
                }
            }
            Log.i("MicroMsg.AgingTestCommand", "[oneliang]do insert contact by username list end,count:%s", Integer.valueOf(list.size()));
        }
        AppMethodBeat.o(20207);
    }

    static /* synthetic */ void a(a aVar, String str, final int i2, final b bVar) {
        AppMethodBeat.i(20208);
        if (bVar != null) {
            Cursor gCp = ((l) g.af(l.class)).aSN().gCp();
            ArrayList<String> arrayList = new ArrayList();
            if (!Util.isNullOrNil(str)) {
                arrayList.add(str);
            } else {
                while (gCp.moveToNext()) {
                    try {
                        as asVar = new as();
                        asVar.convertFrom(gCp);
                        String str2 = asVar.field_username;
                        if (str2 != null && str2.startsWith("rdgztest_atm")) {
                            arrayList.add(str2);
                        }
                    } catch (Throwable th) {
                        if (gCp != null) {
                            gCp.close();
                        }
                        AppMethodBeat.o(20208);
                        throw th;
                    }
                }
                if (gCp != null) {
                    gCp.close();
                }
            }
            Log.i("MicroMsg.AgingTestCommand", "[oneliang] batch insert test msg info, begin all transaction,msg count per conversation:%s", Integer.valueOf(i2));
            long currentTimeMillis = System.currentTimeMillis();
            final int[] iArr = {1, 3, 43, 47};
            for (final String str3 : arrayList) {
                AnonymousClass4 r2 = new AbstractC0306a() {
                    /* class com.tencent.mm.console.a.b.a.AnonymousClass4 */

                    @Override // com.tencent.mm.console.a.b.a.AbstractC0306a
                    public final void execute() {
                        ca c2;
                        AppMethodBeat.i(20202);
                        Log.i("MicroMsg.AgingTestCommand", "[oneliang] batch insert test msg info, begin single transaction, username:%s", str3);
                        long currentTimeMillis = System.currentTimeMillis();
                        int i2 = 0;
                        while (i2 < i2) {
                            int i3 = iArr[a.oQ(iArr.length)];
                            c<ca, s> cVar = null;
                            switch (i3) {
                                case 3:
                                    if (!bVar.gMU.isEmpty()) {
                                        c2 = a.a(str3, bVar.gMU.get(a.oQ(bVar.gMU.size())));
                                        break;
                                    } else {
                                        continue;
                                        i2++;
                                    }
                                case 43:
                                    if (!bVar.gMV.isEmpty()) {
                                        c<ca, s> cVar2 = bVar.gMV.get(a.oQ(bVar.gMV.size()));
                                        c2 = a.b(str3, cVar2);
                                        cVar = cVar2;
                                        break;
                                    } else {
                                        continue;
                                        i2++;
                                    }
                                case 47:
                                    if (!bVar.gMW.isEmpty()) {
                                        c2 = a.c(str3, bVar.gMW.get(a.oQ(bVar.gMW.size())));
                                        break;
                                    } else {
                                        continue;
                                        i2++;
                                    }
                                default:
                                    c2 = a.N(str3, i2);
                                    break;
                            }
                            long aC = ((l) g.af(l.class)).eiy().aC(c2);
                            if (aC <= 0) {
                                if (i2 > 0) {
                                    i2--;
                                } else {
                                    i2 = 0;
                                }
                            } else if (i3 == 43) {
                                o.bhj().b(a.a(str3, (int) aC, c2, cVar));
                            }
                            i2++;
                        }
                        Log.i("MicroMsg.AgingTestCommand", "[oneliang] batch insert test msg info, end single transaction, username:%s, cost:%s", str3, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        AppMethodBeat.o(20202);
                    }
                };
                if (str3 != null && !str3.isEmpty()) {
                    com.tencent.mm.plugin.messenger.foundation.a.a.i eiy = ((l) g.af(l.class)).eiy();
                    h db = eiy.getDB();
                    eiy.aEs("test_msg_info");
                    long beginTransaction = db.beginTransaction(Thread.currentThread().getId());
                    Log.i("MicroMsg.AgingTestCommand", "[oneliang] batch insert test msg info, begin transaction ticket:%s,username:%s", Long.valueOf(beginTransaction), str3);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    try {
                        r2.execute();
                        db.endTransaction(beginTransaction);
                    } catch (Throwable th2) {
                        db.endTransaction(beginTransaction);
                        AppMethodBeat.o(20208);
                        throw th2;
                    }
                    Log.i("MicroMsg.AgingTestCommand", "[oneliang] batch insert test msg info, end transaction, cost:" + (System.currentTimeMillis() - currentTimeMillis2));
                    eiy.aEt("test_msg_info");
                }
            }
            Log.i("MicroMsg.AgingTestCommand", "[oneliang] batch insert test msg info, end all transaction, cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        AppMethodBeat.o(20208);
    }

    static /* synthetic */ void a(a aVar, Context context) {
        AppMethodBeat.i(20209);
        try {
            d.a aVar2 = new d.a(context);
            aVar2.aoS(R.string.hn0);
            aVar2.aoV(R.string.x_).c(new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.console.a.b.a.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(20203);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(20203);
                }
            });
            aVar2.hbn().show();
            Toast.makeText(MMApplicationContext.getContext(), (int) R.string.hn0, 1).show();
            AppMethodBeat.o(20209);
        } catch (Exception e2) {
            Log.e("MicroMsg.AgingTestCommand", "[oneliang] show finished dialog error.");
            AppMethodBeat.o(20209);
        }
    }

    static /* synthetic */ void oP(int i2) {
        AppMethodBeat.i(CdnLogic.kMediaTypeAdVideo);
        Log.i("MicroMsg.AgingTestCommand", "[oneliang]do insert contact begin,count:%s", Integer.valueOf(i2));
        Log.i("MicroMsg.AgingTestCommand", "[oneliang]get exists count:%s", Integer.valueOf(ab.aVb()));
        int aVb = ab.aVb();
        for (int i3 = aVb; i3 < i2 + aVb; i3++) {
            String concat = "rdgztest_atm".concat(String.valueOf(i3));
            as M = M("rdgztest_atm".concat(String.valueOf(i3)), i3);
            if (!((l) g.af(l.class)).aSN().bjN(concat)) {
                ((l) g.af(l.class)).aSN().ap(M);
            }
        }
        Log.i("MicroMsg.AgingTestCommand", "[oneliang]do insert contact end,count:%s", Integer.valueOf(i2));
        AppMethodBeat.o(CdnLogic.kMediaTypeAdVideo);
    }

    static /* synthetic */ ca a(String str, c cVar) {
        String str2;
        String str3;
        AppMethodBeat.i(20212);
        if (cVar == null) {
            AppMethodBeat.o(20212);
            return null;
        }
        S s = cVar.gMY;
        ca caVar = new ca();
        caVar.Cy(str);
        caVar.setContent(cVar.gMX.field_content);
        caVar.setType(3);
        int[] iArr = gML;
        caVar.nv(iArr[oO(iArr.length)]);
        if (caVar.field_isSend == 1) {
            caVar.setStatus(4);
        } else {
            caVar.setStatus(3);
        }
        caVar.aa(Util.decodeHexString("7B00000000000000000000000000000000000000000000000100000000000000000000000000000000000000007D"));
        long currentTimeMillis = System.currentTimeMillis();
        String messageDigest = com.tencent.mm.b.g.getMessageDigest(yW(currentTimeMillis));
        String concat = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(messageDigest));
        caVar.yF(currentTimeMillis);
        caVar.setCreateTime(currentTimeMillis);
        caVar.Cz(concat);
        i bcR = q.bcR();
        String str4 = s.iXm;
        String str5 = s.iXo;
        int lastIndexOf = str4.lastIndexOf(".");
        if (lastIndexOf > 0) {
            str3 = str4.substring(0, lastIndexOf);
            str2 = messageDigest + str4.substring(lastIndexOf, str4.length());
        } else {
            str2 = messageDigest;
            str3 = str4;
        }
        com.tencent.mm.av.g gVar = new com.tencent.mm.av.g();
        gVar.setOffset(s.offset);
        gVar.tf(s.iKP);
        gVar.cSx = -1;
        q.bcR();
        gVar.setLocalId(i.Oy(str));
        gVar.Oq(str2);
        gVar.Os(concat);
        gVar.yF(caVar.field_msgSvrId);
        gVar.setCreateTime((int) (currentTimeMillis / 1000));
        gVar.tk(s.iXp);
        gVar.Or(s.iXn);
        gVar.tg(s.iXx);
        bcR.a(caVar.field_talker, "id", gVar);
        StringBuilder sb = new StringBuilder();
        bg.aVF();
        String sb2 = sb.append(c.getAccPath()).append("/image2/").append(str3.substring(0, 2)).append(FilePathGenerator.ANDROID_DIR_SEP).append(str3.substring(2, 4)).toString();
        String replace = str5.replace("THUMBNAIL_DIRPATH://th_", "");
        StringBuilder sb3 = new StringBuilder();
        bg.aVF();
        String sb4 = sb3.append(c.getAccPath()).append("/image2/").append(replace.substring(0, 2)).append(FilePathGenerator.ANDROID_DIR_SEP).append(replace.substring(2, 4)).toString();
        StringBuilder sb5 = new StringBuilder();
        bg.aVF();
        String sb6 = sb5.append(c.getAccPath()).append("/image2/").append(messageDigest.substring(0, 2)).append(FilePathGenerator.ANDROID_DIR_SEP).append(messageDigest.substring(2, 4)).toString();
        Log.v("MicroMsg.AgingTestCommand", "[oneliang]old hash:%s,new hash:%s", str3, messageDigest);
        com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(sb2, FilePathGenerator.NO_MEDIA_FILENAME);
        com.tencent.mm.vfs.o oVar2 = new com.tencent.mm.vfs.o(sb6, FilePathGenerator.NO_MEDIA_FILENAME);
        if (!oVar.exists()) {
            oVar = new com.tencent.mm.vfs.o(sb4, FilePathGenerator.NO_MEDIA_FILENAME);
        }
        if (oVar.exists()) {
            com.tencent.mm.vfs.s.boN(com.tencent.mm.vfs.s.boZ(aa.z(oVar2.mUri)));
            com.tencent.mm.vfs.s.nw(aa.z(oVar.her()), aa.z(oVar2.her()));
        }
        Log.v("MicroMsg.AgingTestCommand", "[oneliang]nomedia,exists:%s,old file:%s,new file:%s", Boolean.valueOf(oVar.exists()), aa.z(oVar.her()), aa.z(oVar2.her()));
        com.tencent.mm.vfs.o oVar3 = new com.tencent.mm.vfs.o(sb2, str3 + ".jpg");
        com.tencent.mm.vfs.o oVar4 = new com.tencent.mm.vfs.o(sb6, messageDigest + ".jpg");
        if (!oVar3.exists()) {
            oVar3 = new com.tencent.mm.vfs.o(sb4, replace + ".jpg");
        }
        if (oVar3.exists()) {
            com.tencent.mm.vfs.s.boN(com.tencent.mm.vfs.s.boZ(aa.z(oVar4.mUri)));
            com.tencent.mm.vfs.s.nw(aa.z(oVar3.her()), aa.z(oVar4.her()));
        }
        Log.v("MicroMsg.AgingTestCommand", "[oneliang]jpg,exists:%s,old file:%s,new file:%s", Boolean.valueOf(oVar3.exists()), aa.z(oVar3.her()), aa.z(oVar4.her()));
        com.tencent.mm.vfs.o oVar5 = new com.tencent.mm.vfs.o(sb2, str3 + ".png");
        com.tencent.mm.vfs.o oVar6 = new com.tencent.mm.vfs.o(sb6, messageDigest + ".png");
        if (!oVar5.exists()) {
            oVar5 = new com.tencent.mm.vfs.o(sb4, replace + ".png");
        }
        if (oVar5.exists()) {
            com.tencent.mm.vfs.s.boN(com.tencent.mm.vfs.s.boZ(aa.z(oVar6.mUri)));
            com.tencent.mm.vfs.s.nw(aa.z(oVar5.her()), aa.z(oVar6.her()));
        }
        Log.v("MicroMsg.AgingTestCommand", "[oneliang]png,exists:%s,old file:%s,new file:%s", Boolean.valueOf(oVar5.exists()), aa.z(oVar5.her()), aa.z(oVar6.her()));
        com.tencent.mm.vfs.o oVar7 = new com.tencent.mm.vfs.o(sb2, "th_".concat(String.valueOf(str3)));
        com.tencent.mm.vfs.o oVar8 = new com.tencent.mm.vfs.o(sb6, "th_".concat(String.valueOf(messageDigest)));
        if (!oVar7.exists()) {
            oVar7 = new com.tencent.mm.vfs.o(sb4, "th_".concat(String.valueOf(replace)));
        }
        if (oVar7.exists()) {
            com.tencent.mm.vfs.s.boN(com.tencent.mm.vfs.s.boZ(aa.z(oVar8.mUri)));
            com.tencent.mm.vfs.s.nw(aa.z(oVar7.her()), aa.z(oVar8.her()));
        }
        Log.v("MicroMsg.AgingTestCommand", "[oneliang]th_**,exists:%s,old file:%s,new file:%s", Boolean.valueOf(oVar7.exists()), aa.z(oVar7.her()), aa.z(oVar8.her()));
        com.tencent.mm.vfs.o oVar9 = new com.tencent.mm.vfs.o(sb2, "th_" + str3 + "hd");
        com.tencent.mm.vfs.o oVar10 = new com.tencent.mm.vfs.o(sb6, "th_" + messageDigest + "hd");
        if (!oVar9.exists()) {
            oVar9 = new com.tencent.mm.vfs.o(sb4, "th_" + replace + "hd");
        }
        if (oVar9.exists()) {
            com.tencent.mm.vfs.s.boN(com.tencent.mm.vfs.s.boZ(aa.z(oVar10.mUri)));
            com.tencent.mm.vfs.s.nw(aa.z(oVar9.her()), aa.z(oVar10.her()));
        }
        Log.v("MicroMsg.AgingTestCommand", "[oneliang]th_**hd,exists:%s,old file:%s,new file:%s", Boolean.valueOf(oVar9.exists()), aa.z(oVar9.her()), aa.z(oVar10.her()));
        AppMethodBeat.o(20212);
        return caVar;
    }

    static /* synthetic */ ca b(String str, c cVar) {
        AppMethodBeat.i(20213);
        if (cVar == null) {
            AppMethodBeat.o(20213);
            return null;
        }
        M m = cVar.gMX;
        String str2 = str + m.field_content.substring(m.field_content.indexOf(":"));
        ca caVar = new ca();
        caVar.Cy(str);
        caVar.setContent(str2);
        caVar.setType(43);
        int[] iArr = gML;
        caVar.nv(iArr[oO(iArr.length)]);
        if (caVar.field_isSend == 1) {
            caVar.setStatus(4);
        } else {
            caVar.setStatus(3);
        }
        caVar.aa(Util.decodeHexString("7B00000000000000000000000000000000000000000000000100000000000000000000000000000000000000007D"));
        long currentTimeMillis = System.currentTimeMillis();
        caVar.yF(currentTimeMillis);
        caVar.setCreateTime(currentTimeMillis);
        caVar.Cz(com.tencent.mm.b.g.getMessageDigest(yW(currentTimeMillis)));
        AppMethodBeat.o(20213);
        return caVar;
    }

    static /* synthetic */ ca c(String str, c cVar) {
        AppMethodBeat.i(20214);
        if (cVar == null) {
            AppMethodBeat.o(20214);
            return null;
        }
        M m = cVar.gMX;
        S s = cVar.gMY;
        String str2 = m.field_content;
        String str3 = str + str2.substring(str2.indexOf(":"));
        ca caVar = new ca();
        caVar.Cy(str);
        caVar.setContent(str3);
        caVar.setType(47);
        int[] iArr = gML;
        caVar.nv(iArr[oO(iArr.length)]);
        if (caVar.field_isSend == 1) {
            caVar.setStatus(4);
        } else {
            caVar.setStatus(3);
        }
        caVar.Cz(m.field_imgPath);
        caVar.aa(Util.decodeHexString("7B00000000000000000000000000000000000000000000000100000000000000000000000000000000000000007D"));
        long currentTimeMillis = System.currentTimeMillis();
        caVar.yF(currentTimeMillis);
        caVar.setCreateTime(currentTimeMillis);
        EmojiInfo emojiInfo = new EmojiInfo();
        emojiInfo.field_md5 = s.getMd5();
        emojiInfo.field_svrid = s.hYp();
        emojiInfo.field_catalog = Util.nullAs(Integer.valueOf(((EmojiInfo) s).field_catalog), 0);
        emojiInfo.field_type = Util.nullAs(Integer.valueOf(((EmojiInfo) s).field_type), 0);
        emojiInfo.field_size = Util.nullAs(Integer.valueOf(((EmojiInfo) s).field_size), 0);
        emojiInfo.field_start = Util.nullAs(Integer.valueOf(((EmojiInfo) s).field_start), 0);
        emojiInfo.field_state = Util.nullAs(Integer.valueOf(((EmojiInfo) s).field_state), 0);
        emojiInfo.field_reserved3 = Util.nullAs(Integer.valueOf(((EmojiInfo) s).field_reserved3), 0);
        emojiInfo.field_reserved4 = Util.nullAs(Integer.valueOf(((EmojiInfo) s).field_reserved4), 0);
        emojiInfo.field_groupId = ((EmojiInfo) s).field_groupId;
        emojiInfo.field_lastUseTime = Util.nullAs(Long.valueOf(((EmojiInfo) s).field_lastUseTime), 0);
        emojiInfo.field_idx = Util.nullAs(Integer.valueOf(((EmojiInfo) s).field_idx), 0);
        emojiInfo.field_temp = Util.nullAs(Integer.valueOf(((EmojiInfo) s).field_temp), 0);
        emojiInfo.field_source = Util.nullAs(Integer.valueOf(((EmojiInfo) s).field_source), 0);
        emojiInfo.field_needupload = Util.nullAs(Integer.valueOf(((EmojiInfo) s).field_needupload), 0);
        emojiInfo.field_thumbUrl = ((EmojiInfo) s).field_thumbUrl;
        emojiInfo.field_cdnUrl = ((EmojiInfo) s).field_cdnUrl;
        emojiInfo.field_encrypturl = ((EmojiInfo) s).field_encrypturl;
        emojiInfo.field_aeskey = ((EmojiInfo) s).field_aeskey;
        emojiInfo.field_width = Util.nullAs(Integer.valueOf(((EmojiInfo) s).field_width), 0);
        emojiInfo.field_height = Util.nullAs(Integer.valueOf(((EmojiInfo) s).field_height), 0);
        if (!k.getEmojiStorageMgr().OpN.bln(s.getMd5())) {
            k.getEmojiStorageMgr().OpN.K(emojiInfo);
        }
        AppMethodBeat.o(20214);
        return caVar;
    }

    static /* synthetic */ ca N(String str, int i2) {
        AppMethodBeat.i(20215);
        ca caVar = new ca();
        caVar.Cy(str);
        caVar.setContent("text_".concat(String.valueOf(i2)));
        caVar.setType(1);
        int[] iArr = gML;
        caVar.nv(iArr[oO(iArr.length)]);
        if (caVar.field_isSend == 1) {
            caVar.setStatus(4);
        } else {
            caVar.setStatus(3);
        }
        long currentTimeMillis = System.currentTimeMillis();
        caVar.yF(currentTimeMillis);
        caVar.setCreateTime(currentTimeMillis);
        AppMethodBeat.o(20215);
        return caVar;
    }

    static /* synthetic */ s a(String str, int i2, ca caVar, c cVar) {
        AppMethodBeat.i(20216);
        if (cVar == null) {
            AppMethodBeat.o(20216);
            return null;
        }
        S s = cVar.gMY;
        long currentTimeMillis = System.currentTimeMillis();
        s sVar = new s();
        sVar.fileName = caVar.field_imgPath;
        sVar.dTS = caVar.field_msgSvrId;
        sVar.jqP = s.jqP;
        sVar.jsj = s.jsj;
        sVar.iKP = s.iKP;
        sVar.jsk = s.jsk;
        sVar.jsl = s.jsl;
        sVar.status = s.status;
        sVar.createTime = currentTimeMillis;
        sVar.iFw = s.iFw;
        sVar.jso = i2;
        sVar.jsp = s.jsp;
        sVar.jsq = s.jsq;
        sVar.dWq = str;
        sVar.jsh = str;
        sVar.jst = s.bhv();
        sVar.jsu = s.jsu;
        sVar.jqz = s.jqz;
        sVar.gqW = s.gqW;
        String fileName = s.getFileName();
        String str2 = caVar.field_imgPath;
        StringBuilder sb = new StringBuilder();
        bg.aVF();
        String sb2 = sb.append(c.getAccPath()).append("/video").toString();
        com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(sb2, fileName + ".jpg");
        com.tencent.mm.vfs.o oVar2 = new com.tencent.mm.vfs.o(sb2, str2 + ".jpg");
        if (oVar.exists()) {
            com.tencent.mm.vfs.s.boN(com.tencent.mm.vfs.s.boZ(aa.z(oVar2.mUri)));
            com.tencent.mm.vfs.s.nw(aa.z(oVar.her()), aa.z(oVar2.her()));
        }
        Log.v("MicroMsg.AgingTestCommand", "[oneliang]video,jpg,exists:%s,old file:%s,new file:%s", Boolean.valueOf(oVar.exists()), aa.z(oVar.her()), aa.z(oVar2.her()));
        com.tencent.mm.vfs.o oVar3 = new com.tencent.mm.vfs.o(sb2, fileName + ".mp4");
        com.tencent.mm.vfs.o oVar4 = new com.tencent.mm.vfs.o(sb2, str2 + ".mp4");
        if (oVar3.exists()) {
            com.tencent.mm.vfs.s.boN(com.tencent.mm.vfs.s.boZ(aa.z(oVar4.mUri)));
            com.tencent.mm.vfs.s.nw(aa.z(oVar3.her()), aa.z(oVar4.her()));
        }
        Log.v("MicroMsg.AgingTestCommand", "[oneliang]video,mp4,exists:%s,old file:%s,new file:%s", Boolean.valueOf(oVar3.exists()), aa.z(oVar3.her()), aa.z(oVar4.her()));
        AppMethodBeat.o(20216);
        return sVar;
    }
}
