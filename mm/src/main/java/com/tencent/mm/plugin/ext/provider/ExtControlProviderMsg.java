package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.facebook.appevents.AppEventsConstants;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.fx;
import com.tencent.mm.g.a.ga;
import com.tencent.mm.g.a.gg;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice;
import com.tencent.mm.plugin.ext.key.AESUtil;
import com.tencent.mm.pluginsdk.d.a.a;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtControlProviderMsg extends ExtContentProviderBase {
    private static final UriMatcher sNf;
    private static final String[] sNi = {"msgId", "fromUserId", "fromUserNickName", "msgType", DownloadInfo.CONTENTTYPE, "content", "status", "createTime"};
    private static final String[] sNj = {"userId", "unReadCount"};
    private static final String[] sNk = {"userId", "unReadCount"};
    private static final String[] sNl = {"userId", "retCode", "msgId"};
    private static final String[] sNm = {"msgId", "retCode"};
    private static final String[] sNn = {"msgId", "retCode"};
    private String[] sMN;
    private int sMO;
    private boolean sNg;
    private Context sNh;
    private MatrixCursor sNo;

    static {
        AppMethodBeat.i(24440);
        UriMatcher uriMatcher = new UriMatcher(-1);
        sNf = uriMatcher;
        uriMatcher.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_MESSAGE(), "oneMsg", 7);
        sNf.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_MESSAGE(), "unReadCount", 8);
        sNf.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_MESSAGE(), "unReadMsgs", 9);
        sNf.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_MESSAGE(), "unReadUserList", 10);
        sNf.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_MESSAGE(), "recordMsg", 11);
        sNf.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_MESSAGE(), JsApiStartPlayVoice.NAME, 12);
        sNf.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_MESSAGE(), "setReaded", 13);
        sNf.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_MESSAGE(), "sendTextMsg", 14);
        AppMethodBeat.o(24440);
    }

    public ExtControlProviderMsg() {
        this.sNo = null;
        this.sNg = false;
        this.sMN = null;
        this.sMO = -1;
    }

    public ExtControlProviderMsg(String[] strArr, int i2, Context context) {
        this.sNo = null;
        this.sNg = false;
        this.sMN = null;
        this.sMO = -1;
        this.sNg = true;
        this.sMN = strArr;
        this.sMO = i2;
        this.sNh = context;
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public String getType(Uri uri) {
        return null;
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public boolean onCreate() {
        return true;
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.i(24430);
        Log.i("MicroMsg.ExtControlProviderMsg", "ExtControlProviderMsg query() mIsLocalUsed :" + this.sNg);
        if (this.sNg) {
            a(uri, this.sNh, this.sMO, this.sMN);
            if (Util.isNullOrNil(this.sMZ)) {
                Log.e("MicroMsg.ExtControlProviderMsg", "AppID == null");
                fP(3, 7);
                MatrixCursor ahx = a.ahx(7);
                AppMethodBeat.o(24430);
                return ahx;
            } else if (Util.isNullOrNil(cSt())) {
                Log.e("MicroMsg.ExtControlProviderMsg", "PkgName == null");
                fP(3, 6);
                MatrixCursor ahx2 = a.ahx(6);
                AppMethodBeat.o(24430);
                return ahx2;
            } else {
                int cSu = cSu();
                if (cSu != 1) {
                    Log.e("MicroMsg.ExtControlProviderMsg", "invalid appid ! return code = ".concat(String.valueOf(cSu)));
                    fP(2, cSu);
                    MatrixCursor ahx3 = a.ahx(cSu);
                    AppMethodBeat.o(24430);
                    return ahx3;
                }
            }
        } else {
            this.sNh = getContext();
            a(uri, this.sNh, sNf);
            if (uri == null) {
                HF(3);
                AppMethodBeat.o(24430);
                return null;
            } else if (Util.isNullOrNil(this.sMZ) || Util.isNullOrNil(cSt())) {
                HF(3);
                AppMethodBeat.o(24430);
                return null;
            } else if (!ckf()) {
                HF(1);
                MatrixCursor matrixCursor = this.pem;
                AppMethodBeat.o(24430);
                return matrixCursor;
            } else if (!fe(this.sNh)) {
                Log.w("MicroMsg.ExtControlProviderMsg", "invalid appid ! return null");
                HF(2);
                AppMethodBeat.o(24430);
                return null;
            }
        }
        String nullAsNil = Util.nullAsNil(uri.getQueryParameter("source"));
        String nullAsNil2 = Util.nullAsNil(uri.getQueryParameter("count"));
        if (!this.sNg) {
            this.sMO = sNf.match(uri);
        }
        switch (this.sMO) {
            case 7:
                Cursor b2 = b(strArr2, nullAsNil);
                AppMethodBeat.o(24430);
                return b2;
            case 8:
                Cursor C = C(strArr2);
                AppMethodBeat.o(24430);
                return C;
            case 9:
                Cursor b3 = b(strArr2, nullAsNil, nullAsNil2);
                AppMethodBeat.o(24430);
                return b3;
            case 10:
                Cursor cSv = cSv();
                AppMethodBeat.o(24430);
                return cSv;
            case 11:
                Cursor D = D(strArr2);
                AppMethodBeat.o(24430);
                return D;
            case 12:
                Cursor E = E(strArr2);
                AppMethodBeat.o(24430);
                return E;
            case 13:
                Cursor F = F(strArr2);
                AppMethodBeat.o(24430);
                return F;
            case 14:
                Cursor G = G(strArr2);
                AppMethodBeat.o(24430);
                return G;
            default:
                fP(3, 15);
                AppMethodBeat.o(24430);
                return null;
        }
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private Cursor C(String[] strArr) {
        AppMethodBeat.i(24431);
        Log.d("MicroMsg.ExtControlProviderMsg", "getUnReadCount()");
        if (strArr == null || strArr.length <= 0) {
            Log.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            HF(3);
            AppMethodBeat.o(24431);
            return null;
        }
        MatrixCursor matrixCursor = new MatrixCursor(sNj);
        try {
            if ("*".equals(strArr[0])) {
                bg.aVF();
                matrixCursor.addRow(new Object[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, Integer.valueOf(c.aST().JP(""))});
            } else {
                for (String str : strArr) {
                    long aro = AESUtil.aro(str);
                    bg.aVF();
                    as Nh = c.aSN().Nh(aro);
                    if (Nh != null && ((int) Nh.gMZ) > 0) {
                        bg.aVF();
                        matrixCursor.addRow(new Object[]{Long.valueOf(aro), Integer.valueOf(c.aST().JP(" and ( rconversation.username='" + Nh.field_username + "' );"))});
                    }
                }
            }
            HF(0);
            AppMethodBeat.o(24431);
            return matrixCursor;
        } catch (Exception e2) {
            Log.e("MicroMsg.ExtControlProviderMsg", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e2, "", new Object[0]);
            matrixCursor.close();
            HF(4);
            AppMethodBeat.o(24431);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:67:0x01d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.database.Cursor b(java.lang.String[] r13, java.lang.String r14, java.lang.String r15) {
        /*
        // Method dump skipped, instructions count: 496
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg.b(java.lang.String[], java.lang.String, java.lang.String):android.database.Cursor");
    }

    private Cursor cSv() {
        boolean z;
        AppMethodBeat.i(24433);
        Log.d("MicroMsg.ExtControlProviderMsg", "getUnReadUserList()");
        MatrixCursor matrixCursor = new MatrixCursor(sNk);
        try {
            bg.aVF();
            Cursor eiM = c.aSQ().eiM();
            if (eiM != null) {
                if (eiM.moveToFirst()) {
                    do {
                        String string = eiM.getString(eiM.getColumnIndex("talker"));
                        bg.aVF();
                        as Kn = c.aSN().Kn(string);
                        if (!ab.Eq(string)) {
                            if (ab.JE(Kn.field_username) || ab.JA(Kn.field_username) || as.akh(Kn.field_verifyFlag) || ab.Js(Kn.field_username) || ab.Jt(Kn.field_username)) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if (!z) {
                                matrixCursor.addRow(new Object[]{AESUtil.DC((long) ((int) Kn.gMZ)), Integer.valueOf(eiM.getInt(eiM.getColumnIndex("unReadCount")))});
                            }
                        }
                    } while (eiM.moveToNext());
                }
                eiM.close();
            }
            HF(0);
            AppMethodBeat.o(24433);
            return matrixCursor;
        } catch (Exception e2) {
            Log.e("MicroMsg.ExtControlProviderMsg", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e2, "", new Object[0]);
            matrixCursor.close();
            HF(4);
            AppMethodBeat.o(24433);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.database.Cursor b(java.lang.String[] r12, java.lang.String r13) {
        /*
        // Method dump skipped, instructions count: 183
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg.b(java.lang.String[], java.lang.String):android.database.Cursor");
    }

    private Cursor D(final String[] strArr) {
        AppMethodBeat.i(24435);
        Log.d("MicroMsg.ExtControlProviderMsg", "handleRecordMsg()");
        if (strArr == null || strArr.length < 2) {
            Log.w("MicroMsg.ExtControlProviderMsg", "wrong args");
            HF(3);
            AppMethodBeat.o(24435);
            return null;
        }
        try {
            final int intValue = Integer.valueOf(strArr[0]).intValue();
            final long aro = AESUtil.aro(strArr[1]);
            if (aro <= 0) {
                HF(3);
                AppMethodBeat.o(24435);
                return null;
            }
            final b bVar = new b();
            bVar.c(4000, new Runnable() {
                /* class com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(24427);
                    if (intValue == 1) {
                        com.tencent.mm.plugin.ext.b.cSf();
                        as DA = com.tencent.mm.plugin.ext.b.DA(aro);
                        if (DA == null || ((int) DA.gMZ) <= 0) {
                            ExtControlProviderMsg.this.HF(3);
                            bVar.countDown();
                            AppMethodBeat.o(24427);
                            return;
                        }
                        ga gaVar = new ga();
                        gaVar.dJF.op = 1;
                        gaVar.dJF.username = DA.field_username;
                        if (!EventCenter.instance.publish(gaVar)) {
                            ExtControlProviderMsg.this.HF(4);
                            bVar.countDown();
                            AppMethodBeat.o(24427);
                            return;
                        }
                        ExtControlProviderMsg.this.sNo = new MatrixCursor(ExtControlProviderMsg.sNl);
                        if (DA == null || ((int) DA.gMZ) <= 0 || !gaVar.dJG.dFE) {
                            ExtControlProviderMsg.this.sNo.addRow(new Object[]{strArr[1], 2, AppEventsConstants.EVENT_PARAM_VALUE_NO});
                            ExtControlProviderMsg.this.HF(3);
                        } else {
                            ExtControlProviderMsg.this.sNo.addRow(new Object[]{strArr[1], 1, AppEventsConstants.EVENT_PARAM_VALUE_NO});
                            ExtControlProviderMsg.this.HF(0);
                        }
                        Log.d("MicroMsg.ExtControlProviderMsg", "start record, ret=[%s], fileName=[%s]", Boolean.valueOf(gaVar.dJG.dFE), gaVar.dJG.fileName);
                    } else if (intValue == 2) {
                        ga gaVar2 = new ga();
                        gaVar2.dJF.op = 2;
                        if (!EventCenter.instance.publish(gaVar2)) {
                            ExtControlProviderMsg.this.HF(4);
                            bVar.countDown();
                            AppMethodBeat.o(24427);
                            return;
                        }
                        String str = gaVar2.dJG.fileName;
                        ExtControlProviderMsg.this.sNo = new MatrixCursor(ExtControlProviderMsg.sNl);
                        gg ggVar = new gg();
                        ggVar.dKa.fileName = str;
                        if (!EventCenter.instance.publish(ggVar)) {
                            ExtControlProviderMsg.this.HF(4);
                            ExtControlProviderMsg.this.sNo.close();
                            bVar.countDown();
                            AppMethodBeat.o(24427);
                            return;
                        }
                        Log.d("MicroMsg.ExtControlProviderMsg", "stop record, msgId=[%s]", Long.valueOf(ggVar.dKb.msgId));
                        long j2 = ggVar.dKb.msgId;
                        if (j2 > 0) {
                            try {
                                if (!gaVar2.dJG.dFE) {
                                    ExtControlProviderMsg.this.sNo.addRow(new Object[]{strArr[1], 4, AESUtil.DC(j2)});
                                    ExtControlProviderMsg.this.HF(4);
                                } else if (MMApplicationContext.getContext() == null || !NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
                                    ExtControlProviderMsg.this.sNo.addRow(new Object[]{strArr[1], 6, AESUtil.DC(j2)});
                                    ExtControlProviderMsg.this.HF(4);
                                } else {
                                    ExtControlProviderMsg.this.sNo.addRow(new Object[]{strArr[1], 1, AESUtil.DC(j2)});
                                    ExtControlProviderMsg.this.HF(0);
                                }
                            } catch (Exception e2) {
                                Log.w("MicroMsg.ExtControlProviderMsg", e2.getMessage());
                                Log.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e2, "", new Object[0]);
                                ExtControlProviderMsg.this.HF(4);
                            }
                        } else {
                            ExtControlProviderMsg.this.HF(3);
                        }
                    }
                    bVar.countDown();
                    AppMethodBeat.o(24427);
                }
            });
            MatrixCursor matrixCursor = this.sNo;
            AppMethodBeat.o(24435);
            return matrixCursor;
        } catch (Exception e2) {
            Log.e("MicroMsg.ExtControlProviderMsg", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e2, "", new Object[0]);
            if (this.sNo != null) {
                this.sNo.close();
            }
            HF(4);
            AppMethodBeat.o(24435);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0106  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.database.Cursor E(java.lang.String[] r12) {
        /*
        // Method dump skipped, instructions count: 330
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg.E(java.lang.String[]):android.database.Cursor");
    }

    private Cursor F(String[] strArr) {
        AppMethodBeat.i(24437);
        Log.i("MicroMsg.ExtControlProviderMsg", "setMsgReaded()");
        if (strArr == null || strArr.length <= 0) {
            Log.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            fP(3, 3801);
            MatrixCursor ahx = a.ahx(3801);
            AppMethodBeat.o(24437);
            return ahx;
        }
        for (int i2 = 0; i2 < strArr.length; i2++) {
            try {
                if (strArr[i2] == null || strArr[i2].length() <= 0) {
                    Log.w("MicroMsg.ExtControlProviderMsg", "setMsgReaded() wrongArgs i = ".concat(String.valueOf(i2)));
                } else {
                    long aro = AESUtil.aro(strArr[i2]);
                    com.tencent.mm.plugin.ext.b.cSf();
                    com.tencent.mm.plugin.ext.b.DB(aro);
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.ExtControlProviderMsg", e2.getMessage());
                Log.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e2, "", new Object[0]);
                fP(4, 12);
                MatrixCursor ahx2 = a.ahx(12);
                AppMethodBeat.o(24437);
                return ahx2;
            }
        }
        fP(0, 1);
        MatrixCursor ahx3 = a.ahx(1);
        AppMethodBeat.o(24437);
        return ahx3;
    }

    private Cursor G(final String[] strArr) {
        AppMethodBeat.i(24438);
        Log.d("MicroMsg.ExtControlProviderMsg", "sendTextMsg()");
        if (strArr == null || strArr.length <= 0) {
            Log.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            HF(3);
            AppMethodBeat.o(24438);
            return null;
        }
        try {
            long aro = AESUtil.aro(strArr[0]);
            if (aro <= 0) {
                HF(3);
                AppMethodBeat.o(24438);
                return null;
            }
            com.tencent.mm.plugin.ext.b.cSf();
            final as DA = com.tencent.mm.plugin.ext.b.DA(aro);
            if (DA == null || ((int) DA.gMZ) <= 0) {
                Log.e("MicroMsg.ExtControlProviderMsg", "toContact is null ");
                HF(3);
                AppMethodBeat.o(24438);
                return null;
            }
            this.sNo = new MatrixCursor(sNn);
            final b bVar = new b();
            bVar.c(15000, new Runnable() {
                /* class com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(24429);
                    fx fxVar = new fx();
                    fxVar.dJu.dJw = DA.field_username;
                    fxVar.dJu.content = strArr[1];
                    fxVar.dJu.type = ab.JG(DA.field_username);
                    fxVar.dJu.flags = 0;
                    if (!EventCenter.instance.publish(fxVar)) {
                        ExtControlProviderMsg.this.HF(4);
                        bVar.countDown();
                        AppMethodBeat.o(24429);
                        return;
                    }
                    q qVar = fxVar.dJv.dJx;
                    try {
                        final String DC = AESUtil.DC(fxVar.dJv.msgId);
                        bg.azz().a(522, new i() {
                            /* class com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg.AnonymousClass2.AnonymousClass1 */

                            @Override // com.tencent.mm.ak.i
                            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                                AppMethodBeat.i(24428);
                                Log.d("MicroMsg.ExtControlProviderMsg", "onSceneEnd errType=%s, errCode=%s", Integer.valueOf(i2), Integer.valueOf(i3));
                                if (qVar == null) {
                                    Log.e("MicroMsg.ExtControlProviderMsg", "scene == null");
                                    bg.azz().b(522, this);
                                    ExtControlProviderMsg.this.HF(4);
                                    bVar.countDown();
                                    AppMethodBeat.o(24428);
                                    return;
                                }
                                switch (qVar.getType()) {
                                    case 522:
                                        if (i2 != 0 || i3 != 0) {
                                            Log.e("MicroMsg.ExtControlProviderMsg", "rtSENDMSG onSceneEnd err, errType = " + i2 + ", errCode = " + i3);
                                            ExtControlProviderMsg.this.sNo.addRow(new Object[]{DC, 2});
                                            ExtControlProviderMsg.this.HF(4);
                                            break;
                                        } else {
                                            Log.d("MicroMsg.ExtControlProviderMsg", "rtSENDMSG onSceneEnd ok, ");
                                            ExtControlProviderMsg.this.sNo.addRow(new Object[]{DC, 1});
                                        }
                                    default:
                                        ExtControlProviderMsg.this.HF(0);
                                        break;
                                }
                                bVar.countDown();
                                bg.azz().b(522, this);
                                AppMethodBeat.o(24428);
                            }
                        });
                        bg.azz().a(qVar, 0);
                        AppMethodBeat.o(24429);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.ExtControlProviderMsg", e2.getMessage());
                        Log.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e2, "", new Object[0]);
                        ExtControlProviderMsg.this.HF(4);
                        bVar.countDown();
                        AppMethodBeat.o(24429);
                    }
                }
            });
            MatrixCursor matrixCursor = this.sNo;
            AppMethodBeat.o(24438);
            return matrixCursor;
        } catch (Exception e2) {
            Log.e("MicroMsg.ExtControlProviderMsg", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e2, "", new Object[0]);
            if (this.sNo != null) {
                this.sNo.close();
            }
            HF(4);
            AppMethodBeat.o(24438);
            return null;
        }
    }

    private void a(MatrixCursor matrixCursor, ca caVar, as asVar, boolean z, String str, boolean z2, String str2) {
        String str3;
        int i2;
        int Kp;
        String trim;
        AppMethodBeat.i(24439);
        if (caVar == null) {
            AppMethodBeat.o(24439);
        } else if (Util.isNullOrNil(str2)) {
            Log.d("MicroMsg.ExtControlProviderMsg", "userOpenId is null");
            AppMethodBeat.o(24439);
        } else if (caVar.getType() == 9999 || caVar.getType() == 10000) {
            AppMethodBeat.o(24439);
        } else {
            String str4 = "";
            String str5 = "";
            if (z && (Kp = bp.Kp(caVar.field_content)) != -1 && caVar.field_content.length() > Kp && (trim = caVar.field_content.substring(0, Kp).trim()) != null && trim.length() > 0 && caVar.field_content.length() >= Kp + 2) {
                str4 = aa.getDisplayName(trim);
                str5 = caVar.field_content.substring(Kp + 2);
            }
            int av = com.tencent.mm.plugin.ext.b.b.av(caVar);
            if (av == 1) {
                if (z) {
                    str4 = str4 + "!]" + str5;
                } else {
                    str4 = caVar.field_content;
                }
            } else if (av == 2) {
                r uk = o.bib().uk((int) caVar.field_msgId);
                if (uk == null || uk.fileName == null) {
                    str3 = "";
                } else {
                    str3 = s.getFullPath(uk.fileName);
                    Log.d("MicroMsg.ExtControlProviderMsg", "voice file = %s", str3);
                }
                str4 = str3;
            } else if (!z) {
                if (this.sNh != null) {
                    str4 = this.sNh.getString(R.string.c3j);
                } else {
                    str4 = "";
                }
            }
            if (!z2) {
                str2 = AESUtil.DC((long) ((int) asVar.gMZ));
            }
            try {
                if (Util.isNullOrNil(str2)) {
                    Log.w("MicroMsg.ExtControlProviderMsg", "userId is null");
                    AppMethodBeat.o(24439);
                    return;
                }
                Object[] objArr = new Object[8];
                objArr[0] = AESUtil.DC(caVar.field_msgId);
                objArr[1] = str2;
                objArr[2] = str;
                objArr[3] = Integer.valueOf(caVar.field_isSend == 0 ? 1 : 2);
                objArr[4] = Integer.valueOf(av);
                objArr[5] = str4;
                if (caVar.field_status == 4) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                objArr[6] = Integer.valueOf(i2);
                objArr[7] = Long.valueOf(caVar.field_createTime);
                matrixCursor.addRow(objArr);
                AppMethodBeat.o(24439);
            } catch (Exception e2) {
                Log.e("MicroMsg.ExtControlProviderMsg", e2.getMessage());
                Log.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e2, "", new Object[0]);
                AppMethodBeat.o(24439);
            }
        }
    }
}
