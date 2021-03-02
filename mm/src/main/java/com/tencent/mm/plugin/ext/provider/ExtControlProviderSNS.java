package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.measurement.AppMeasurement;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.ext.key.AESUtil;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;
import com.tencent.mm.storage.as;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public final class ExtControlProviderSNS extends ExtContentProviderBase {
    private static boolean hho = false;
    private static MTimerHandler sND = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.ext.provider.ExtControlProviderSNS.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(24456);
            boolean unused = ExtControlProviderSNS.hho = false;
            AppMethodBeat.o(24456);
            return false;
        }
    }, false);
    private static final String[] sNF = {"feedId", "desc", "url", "nickname", "avatar", AppMeasurement.Param.TIMESTAMP, "mediaCount", "type", "bigImgUrl", "firstImgWidth", "firstImgHeight"};
    private static final UriMatcher sNf;
    private boolean dJL = false;
    private boolean dJM = false;
    private int dJN = 0;
    private String sNG = "";

    static {
        AppMethodBeat.i(24463);
        UriMatcher uriMatcher = new UriMatcher(-1);
        sNf = uriMatcher;
        uriMatcher.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_SNS(), "snsInfo", 17);
        AppMethodBeat.o(24463);
    }

    private static void gW(boolean z) {
        AppMethodBeat.i(24459);
        if (z) {
            hho = true;
            sND.startTimer(15000);
            AppMethodBeat.o(24459);
            return;
        }
        sND.startTimer(0);
        AppMethodBeat.o(24459);
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public final boolean onCreate() {
        return false;
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        long aro;
        Cursor DD;
        AppMethodBeat.i(24460);
        Log.i("MicroMsg.ExtControlProviderSNS", "query() ".concat(String.valueOf(uri)));
        a(uri, getContext(), sNf);
        if (uri == null) {
            HF(3);
            AppMethodBeat.o(24460);
            return null;
        } else if (Util.isNullOrNil(this.sMZ) || Util.isNullOrNil(cSt())) {
            HF(3);
            AppMethodBeat.o(24460);
            return null;
        } else if (hho) {
            Log.w("MicroMsg.ExtControlProviderSNS", "isBusy, return null");
            HF(5);
            AppMethodBeat.o(24460);
            return null;
        } else {
            gW(true);
            if (!ckf()) {
                gW(false);
                HF(1);
                MatrixCursor matrixCursor = this.pem;
                AppMethodBeat.o(24460);
                return matrixCursor;
            } else if (!fe(getContext())) {
                Log.w("MicroMsg.ExtControlProviderSNS", "invalid appid ! return null");
                gW(false);
                HF(2);
                AppMethodBeat.o(24460);
                return null;
            } else if (strArr2 == null || strArr2.length == 0) {
                Log.e("MicroMsg.ExtControlProviderSNS", "invaild selections");
                gW(false);
                HF(3);
                AppMethodBeat.o(24460);
                return null;
            } else {
                String str3 = strArr2[0];
                if (Util.isNullOrNil(str3)) {
                    Log.e("MicroMsg.ExtControlProviderSNS", "userIdStr should not be null or nil");
                    gW(false);
                    HF(3);
                    AppMethodBeat.o(24460);
                    return null;
                }
                try {
                    if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str3.trim())) {
                        aro = 0;
                    } else {
                        aro = AESUtil.aro(str3.trim());
                    }
                    switch (sNf.match(uri)) {
                        case 17:
                            DD = DD(aro);
                            break;
                        default:
                            DD = null;
                            break;
                    }
                    if (DD != null) {
                        HF(0);
                    } else {
                        HF(4);
                    }
                    gW(false);
                    AppMethodBeat.o(24460);
                    return DD;
                } catch (Exception e2) {
                    Log.e("MicroMsg.ExtControlProviderSNS", e2.getMessage());
                    Log.printErrStackTrace("MicroMsg.ExtControlProviderSNS", e2, "", new Object[0]);
                    gW(false);
                    HF(4);
                    AppMethodBeat.o(24460);
                    return null;
                }
            }
        }
    }

    private Cursor DD(long j2) {
        final as Nh;
        boolean z = true;
        AppMethodBeat.i(24461);
        Log.i("MicroMsg.ExtControlProviderSNS", "handleGetSnsInfo() userId = ".concat(String.valueOf(j2)));
        try {
            Log.i("MicroMsg.ExtControlProviderSNS", "startGetSNSInfo, userId=[%s]", Long.valueOf(j2));
            if (j2 == 0) {
                bg.aVF();
                Nh = c.aSN().bjJ(z.aTY());
            } else {
                bg.aVF();
                Nh = c.aSN().Nh(j2);
            }
            if (Nh == null || ((int) Nh.gMZ) <= 0) {
                Log.e("MicroMsg.ExtControlProviderSNS", "ct == null");
                z = false;
            } else {
                this.dJL = com.tencent.mm.contact.c.oR(Nh.field_type);
                this.dJM = z.Im(Nh.field_username);
                Log.d("MicroMsg.ExtControlProviderSNS", "ct.getUsername()=[%s], isFriend=[%s], isSelf=[%s]", Nh.field_username, Boolean.valueOf(this.dJL), Boolean.valueOf(this.dJM));
                final b bVar = new b();
                bVar.c(10000, new Runnable() {
                    /* class com.tencent.mm.plugin.ext.provider.ExtControlProviderSNS.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(24458);
                        gd gdVar = new gd();
                        gdVar.dJK.type = 1;
                        gdVar.dJK.username = Nh.field_username;
                        gdVar.dJK.dJL = ExtControlProviderSNS.this.dJL;
                        gdVar.dJK.dJM = ExtControlProviderSNS.this.dJM;
                        gdVar.dJK.dJN = ExtControlProviderSNS.this.dJN;
                        gdVar.dJK.dJO = new bu.a() {
                            /* class com.tencent.mm.plugin.ext.provider.ExtControlProviderSNS.AnonymousClass2.AnonymousClass1 */

                            @Override // com.tencent.mm.model.bu.a
                            public final void a(g gVar) {
                                AppMethodBeat.i(24457);
                                bVar.countDown();
                                AppMethodBeat.o(24457);
                            }
                        };
                        EventCenter.instance.publish(gdVar);
                        AppMethodBeat.o(24458);
                    }
                });
            }
            if (!z) {
                Log.w("MicroMsg.ExtControlProviderSNS", "startGetSNSInfo() return false");
                AppMethodBeat.o(24461);
                return null;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.ExtControlProviderSNS", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.ExtControlProviderSNS", e2, "", new Object[0]);
        }
        Cursor cSy = cSy();
        AppMethodBeat.o(24461);
        return cSy;
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x0195 A[Catch:{ Exception -> 0x01d8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.database.Cursor cSy() {
        /*
        // Method dump skipped, instructions count: 594
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ext.provider.ExtControlProviderSNS.cSy():android.database.Cursor");
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public final String getType(Uri uri) {
        return null;
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public final int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
