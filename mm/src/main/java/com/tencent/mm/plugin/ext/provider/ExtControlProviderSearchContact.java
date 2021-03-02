package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.appevents.AppEventsConstants;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.ext.key.AESUtil;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.e;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtControlProviderSearchContact extends ExtContentProviderBase {
    private static List<String> gzY = new ArrayList();
    private static final String[] sNF = {"userId", "nickname", "avatar", "content", "msgId", "msgType"};
    private Cursor sNJ = null;

    static {
        AppMethodBeat.i(24467);
        for (String str : ab.iCO) {
            gzY.add(str);
        }
        gzY.add("officialaccounts");
        gzY.add("helper_entry");
        AppMethodBeat.o(24467);
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public boolean onCreate() {
        return true;
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.i(24465);
        Log.d("MicroMsg.ExtControlProviderSearchContact", "query()");
        a(uri, getContext(), 16);
        if (uri == null) {
            HF(3);
            AppMethodBeat.o(24465);
            return null;
        } else if (Util.isNullOrNil(this.sMZ) || Util.isNullOrNil(cSt())) {
            HF(3);
            AppMethodBeat.o(24465);
            return null;
        } else if (!ckf()) {
            HF(1);
            MatrixCursor matrixCursor = this.pem;
            AppMethodBeat.o(24465);
            return matrixCursor;
        } else if (!fe(getContext())) {
            Log.w("MicroMsg.ExtControlProviderSearchContact", "invalid appid ! return null");
            HF(2);
            AppMethodBeat.o(24465);
            return null;
        } else if (strArr2 == null || strArr2.length == 0) {
            Log.e("MicroMsg.ExtControlProviderSearchContact", "invaild selections");
            HF(3);
            AppMethodBeat.o(24465);
            return null;
        } else {
            String trim = strArr2[0].trim();
            if (Util.isNullOrNil(trim)) {
                Log.e("MicroMsg.ExtControlProviderSearchContact", "filter should not be null or nil");
                HF(3);
                AppMethodBeat.o(24465);
                return null;
            }
            final Cursor a2 = bg.aVF().iBp.a(trim, "@micromsg.no.verify.biz.qq.com", gzY, false, 1, null);
            if (a2 == null) {
                Log.e("MicroMsg.ExtControlProviderSearchContact", "cursor is null");
                HF(3);
                AppMethodBeat.o(24465);
                return null;
            }
            final b bVar = new b();
            bVar.c(4000, new Runnable() {
                /* class com.tencent.mm.plugin.ext.provider.ExtControlProviderSearchContact.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(24464);
                    ExtControlProviderSearchContact.this.sNJ = ExtControlProviderSearchContact.e(a2);
                    bVar.countDown();
                    AppMethodBeat.o(24464);
                }
            });
            if (this.sNJ != null) {
                HF(0);
            } else {
                HF(4);
            }
            Cursor cursor = this.sNJ;
            AppMethodBeat.o(24465);
            return cursor;
        }
    }

    public static Cursor e(Cursor cursor) {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] byteArray;
        byte[] byteArray2;
        String str;
        AppMethodBeat.i(24466);
        e eVar = new e(sNF, (byte) 0);
        try {
            if (cursor.moveToFirst()) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    as asVar = new as();
                    asVar.convertFrom(cursor);
                    if (!ab.Eq(asVar.field_username)) {
                        Bitmap K = p.aYD().K(asVar.field_username, true);
                        if (K != null) {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            K.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                        } else {
                            Log.w("MicroMsg.ExtControlProviderSearchContact", "get useravatar is null");
                            byteArrayOutputStream = null;
                        }
                        bg.aVF();
                        ca[] eH = c.aSQ().eH(asVar.field_username, 1);
                        if (eH == null || eH.length != 1) {
                            Log.w("MicroMsg.ExtControlProviderSearchContact", "get msginfo failed");
                            Object[] objArr = new Object[6];
                            objArr[0] = AESUtil.DC((long) ((int) asVar.gMZ));
                            objArr[1] = asVar.arJ();
                            if (byteArrayOutputStream == null) {
                                byteArray = null;
                            } else {
                                byteArray = byteArrayOutputStream.toByteArray();
                            }
                            objArr[2] = byteArray;
                            objArr[3] = "";
                            objArr[4] = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                            objArr[5] = 0;
                            eVar.addRow(objArr);
                        } else {
                            Object[] objArr2 = new Object[6];
                            objArr2[0] = AESUtil.DC((long) ((int) asVar.gMZ));
                            objArr2[1] = asVar.arJ();
                            if (byteArrayOutputStream == null) {
                                byteArray2 = null;
                            } else {
                                byteArray2 = byteArrayOutputStream.toByteArray();
                            }
                            objArr2[2] = byteArray2;
                            if (eH[0].getType() == 1) {
                                str = eH[0].field_content;
                            } else {
                                str = "";
                            }
                            objArr2[3] = str;
                            objArr2[4] = AESUtil.DC(eH[0].field_msgId);
                            objArr2[5] = Integer.valueOf(com.tencent.mm.plugin.ext.b.b.av(eH[0]));
                            eVar.addRow(objArr2);
                        }
                    }
                    if (!cursor.moveToNext() || i3 >= 15) {
                        break;
                    }
                    i2 = i3;
                }
            }
            cursor.close();
            AppMethodBeat.o(24466);
            return eVar;
        } catch (Exception e2) {
            Log.e("MicroMsg.ExtControlProviderSearchContact", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.ExtControlProviderSearchContact", e2, "", new Object[0]);
            if (cursor != null) {
                cursor.close();
            }
            eVar.close();
            AppMethodBeat.o(24466);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public String getType(Uri uri) {
        return null;
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
}
