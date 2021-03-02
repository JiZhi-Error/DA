package com.tencent.mm.plugin.extqlauncher.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.plugin.extqlauncher.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;

public class ExtControlProviderQLauncher extends ExtContentProviderBase {
    private static final String[] sMy = {"retCode"};
    private static final UriMatcher sNf;
    private static final String[] sOY = {"id", "count"};
    private Context context;
    private String[] sMN;
    private int sOZ = -1;

    static {
        AppMethodBeat.i(24565);
        UriMatcher uriMatcher = new UriMatcher(-1);
        sNf = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.extqlauncher", "openQRCodeScan", 18);
        sNf.addURI("com.tencent.mm.plugin.extqlauncher", "batchAddShortcut", 19);
        sNf.addURI("com.tencent.mm.plugin.extqlauncher", "getUnreadCount", 20);
        AppMethodBeat.o(24565);
    }

    public ExtControlProviderQLauncher(String[] strArr, int i2, Context context2) {
        this.sMN = strArr;
        this.sOZ = i2;
        this.context = context2;
    }

    public ExtControlProviderQLauncher() {
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
        AppMethodBeat.i(24563);
        Log.d("MicroMsg.ExtControlProviderQLauncher", "query()");
        a(uri, this.context, this.sOZ, this.sMN);
        if (uri == null) {
            HF(3);
            AppMethodBeat.o(24563);
            return null;
        } else if (Util.isNullOrNil(this.sMZ) || Util.isNullOrNil(cSt())) {
            HF(3);
            AppMethodBeat.o(24563);
            return null;
        } else if (!ckf()) {
            HF(1);
            MatrixCursor matrixCursor = this.pem;
            AppMethodBeat.o(24563);
            return matrixCursor;
        } else if (!fe(this.context)) {
            Log.w("MicroMsg.ExtControlProviderQLauncher", "invalid appid ! return null");
            HF(2);
            AppMethodBeat.o(24563);
            return null;
        } else {
            switch (this.sOZ) {
                case 18:
                    Log.d("MicroMsg.ExtControlProviderQLauncher", "toScanQRCode");
                    if (this.context == null) {
                        HF(4);
                        AppMethodBeat.o(24563);
                        return null;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", 1);
                    intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                    c.b(this.context, "scanner", ".ui.BaseScanUI", intent);
                    MatrixCursor matrixCursor2 = new MatrixCursor(sMy);
                    matrixCursor2.addRow(new Object[]{1});
                    HF(0);
                    AppMethodBeat.o(24563);
                    return matrixCursor2;
                case 19:
                    Log.d("MicroMsg.ExtControlProviderQLauncher", "toCreateShortcut");
                    if (this.context == null) {
                        HF(4);
                        AppMethodBeat.o(24563);
                        return null;
                    }
                    c.b(this.context, "extqlauncher", ".ui.QLauncherCreateShortcutUI", new Intent());
                    MatrixCursor matrixCursor3 = new MatrixCursor(sMy);
                    matrixCursor3.addRow(new Object[]{1});
                    HF(0);
                    AppMethodBeat.o(24563);
                    return matrixCursor3;
                case 20:
                    Cursor H = H(strArr2);
                    AppMethodBeat.o(24563);
                    return H;
                default:
                    HF(3);
                    AppMethodBeat.o(24563);
                    return null;
            }
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

    private Cursor H(String[] strArr) {
        AppMethodBeat.i(24564);
        Log.d("MicroMsg.ExtControlProviderQLauncher", "getUnreadCount");
        if (this.context == null) {
            HF(4);
            AppMethodBeat.o(24564);
            return null;
        } else if (strArr == null || strArr.length <= 0) {
            Log.e("MicroMsg.ExtControlProviderQLauncher", "wrong args");
            HF(3);
            AppMethodBeat.o(24564);
            return null;
        } else {
            MatrixCursor matrixCursor = new MatrixCursor(sOY);
            int i2 = 0;
            while (i2 < strArr.length && i2 < 10) {
                try {
                    if (!Util.isNullOrNil(strArr[i2])) {
                        if (strArr[i2].equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                            b.cSI();
                            matrixCursor.addRow(new Object[]{strArr[i2], 0});
                        } else {
                            String agY = com.tencent.mm.plugin.base.model.b.agY(strArr[i2]);
                            if (!Util.isNullOrNil(agY)) {
                                bg.aVF();
                                az bjY = com.tencent.mm.model.c.aST().bjY(agY);
                                if (bjY != null) {
                                    matrixCursor.addRow(new Object[]{strArr[i2], Integer.valueOf(bjY.field_unReadCount)});
                                } else {
                                    matrixCursor.addRow(new Object[]{strArr[i2], 0});
                                }
                            }
                        }
                    }
                    i2++;
                } catch (Exception e2) {
                    Log.e("MicroMsg.ExtControlProviderQLauncher", "exception in updateShortcut, %s", e2.getMessage());
                    HF(4);
                    matrixCursor.close();
                    AppMethodBeat.o(24564);
                    return null;
                }
            }
            HF(0);
            AppMethodBeat.o(24564);
            return matrixCursor;
        }
    }
}
