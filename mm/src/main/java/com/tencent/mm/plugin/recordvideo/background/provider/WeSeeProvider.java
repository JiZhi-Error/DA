package com.tencent.mm.plugin.recordvideo.background.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.recordvideo.background.provider.b;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;
import com.tencent.mm.storagebase.h;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJ/\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0013H\u0002¢\u0006\u0002\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\nH\u0016JK\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00132\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010 J9\u0010!\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010\"R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeProvider;", "Landroid/content/ContentProvider;", "()V", "queueSql", "", "uriMatcher", "Landroid/content/UriMatcher;", "weSeeStorage", "Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeDataStorage;", "checkMD5", "", "checkTime", "checkValid", WeSeeProvider.BMy, "", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "selection", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getCallingPackages", "()[Ljava/lang/String;", "getType", WeSeeProvider.BMz, "values", "Landroid/content/ContentValues;", "onCreate", "query", "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "plugin-recordvideo_release"})
public final class WeSeeProvider extends ContentProvider {
    private static final String AUTHORITY = WeChatAuthorities.AUTHORITIES_PLUGIN_RECORDVIDEO_BACKGROUND_PROVIDER_WESEEPROVIDER();
    private static final int BMA = 100;
    private static final int BMB = 101;
    private static final int BMC = 1;
    private static final int BMD = BMD;
    public static final a BME = new a((byte) 0);
    private static final String BMv = BMv;
    private static final String BMw = BMw;
    private static final String BMx = "query";
    private static final String BMy = BMy;
    private static final String BMz = BMz;
    private static final String TAG = TAG;
    private a BMt;
    private final String BMu;
    private UriMatcher sNB = new UriMatcher(-1);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bR\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u000e\u0010\u0010\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007R\u000e\u0010\u0015\u001a\u00020\tXD¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeProvider$Companion;", "", "()V", "AUTHORITY", "", "kotlin.jvm.PlatformType", "getAUTHORITY", "()Ljava/lang/String;", "CHECK_TIME", "", "CODE_DELETE", "CODE_QUERY", WeSeeProvider.BMw, "getKEY_INSERT_TIME", WeSeeProvider.BMv, "getKEY_INSERT_VIDEO_PATH", "PATH_DELETE", "PATH_INSERT", "PATH_QUERY", "TAG", "getTAG", "VALUE_INDEX", WeSeeProvider.BMy, "", WeSeeProvider.BMz, "weSeeUri", "time", "", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void bg(String str, long j2) {
            AppMethodBeat.i(163417);
            p.h(str, "weSeeUri");
            Log.i(WeSeeProvider.TAG, "insert fun");
            e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            h dataDB = aAh.getDataDB();
            p.g(dataDB, "MMKernel.storage().dataDB");
            a aVar = new a(dataDB);
            b bVar = new b();
            bVar.field_weSeeUri = str;
            bVar.field_time = j2;
            if (aVar.getCount() == 0) {
                Log.i(WeSeeProvider.TAG, "insert weseeProvider:" + str + ", time:" + j2);
                aVar.insert(bVar);
                AppMethodBeat.o(163417);
                return;
            }
            Log.i(WeSeeProvider.TAG, "update weseeProvider:" + str + ", time:" + j2);
            aVar.update((long) WeSeeProvider.BMC, bVar);
            AppMethodBeat.o(163417);
        }

        public static void delete() {
            AppMethodBeat.i(163418);
            Log.i(WeSeeProvider.TAG, "delete fun");
            e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            h dataDB = aAh.getDataDB();
            p.g(dataDB, "MMKernel.storage().dataDB");
            a aVar = new a(dataDB);
            int count = aVar.getCount();
            if (count == 0) {
                Log.d(WeSeeProvider.TAG, "delete fail count == 0");
                AppMethodBeat.o(163418);
                return;
            }
            Log.d(WeSeeProvider.TAG, "delete into count: ".concat(String.valueOf(count)));
            if (count > 1) {
                Log.e(WeSeeProvider.TAG, "delete count error, count: " + count + ' ');
            }
            aVar.delete((long) WeSeeProvider.BMC);
            AppMethodBeat.o(163418);
        }
    }

    public WeSeeProvider() {
        AppMethodBeat.i(75337);
        StringBuilder sb = new StringBuilder("select * from ");
        b.a aVar = b.BMF;
        this.BMu = sb.append(b.TABLE).toString();
        this.sNB.addURI(AUTHORITY, BMx, BMA);
        this.sNB.addURI(AUTHORITY, BMy, BMB);
        AppMethodBeat.o(75337);
    }

    static {
        AppMethodBeat.i(75338);
        AppMethodBeat.o(75338);
    }

    private final String[] eJq() {
        int i2;
        AppMethodBeat.i(75330);
        try {
            int callingUid = Binder.getCallingUid();
            Context context = getContext();
            if (context == null) {
                p.hyc();
            }
            p.g(context, "context!!");
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(Binder.getCallingUid());
            String str = TAG;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(callingUid);
            if (packagesForUid != null) {
                i2 = Integer.valueOf(packagesForUid.length);
            } else {
                i2 = 0;
            }
            objArr[1] = i2;
            Log.i(str, "getCallingPackages, callingUid = %d, packages size = %d", objArr);
            if (packagesForUid == null) {
                Log.w(TAG, "getCallingPackages fail, packages is null");
                String[] strArr = new String[0];
                AppMethodBeat.o(75330);
                return strArr;
            }
            for (String str2 : packagesForUid) {
                Log.i(TAG, "getCallingPackages = %s", str2);
            }
            AppMethodBeat.o(75330);
            return packagesForUid;
        } catch (Exception e2) {
            Log.e(TAG, "getCallingPackages, ex = %s", e2.getMessage());
            String[] strArr2 = new String[0];
            AppMethodBeat.o(75330);
            return strArr2;
        }
    }

    public final boolean onCreate() {
        AppMethodBeat.i(75331);
        Log.d(TAG, "onCreate");
        AppMethodBeat.o(75331);
        return true;
    }

    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.i(75332);
        p.h(uri, ShareConstants.MEDIA_URI);
        Log.d(TAG, "query uri:" + uri + ", projection:" + strArr + ", selection:" + str + ", selectionArgs:" + strArr2 + ", sortOrder:" + str2);
        if (!checkValid()) {
            Log.e(TAG, "query checkValid failed");
            AppMethodBeat.o(75332);
            return null;
        } else if (this.sNB.match(uri) == BMA) {
            Log.i(TAG, "query inner ");
            a aVar = this.BMt;
            if (aVar != null) {
                Cursor rawQuery = aVar.rawQuery(this.BMu, new String[0]);
                AppMethodBeat.o(75332);
                return rawQuery;
            }
            AppMethodBeat.o(75332);
            return null;
        } else {
            Log.i(TAG, "query uriMatcher match failed");
            AppMethodBeat.o(75332);
            return null;
        }
    }

    public final int delete(Uri uri, String str, String[] strArr) {
        AppMethodBeat.i(75333);
        p.h(uri, ShareConstants.MEDIA_URI);
        Log.d(TAG, "delete uri" + uri + ", selection" + str + ", selectionArgs:" + strArr);
        if (!checkValid()) {
            Log.e(TAG, "delete checkValid failed");
            AppMethodBeat.o(75333);
        } else {
            if (this.sNB.match(uri) == BMB) {
                a aVar = this.BMt;
                Integer valueOf = aVar != null ? Integer.valueOf(aVar.getCount()) : null;
                if (valueOf == null) {
                    p.hyc();
                }
                int intValue = valueOf.intValue();
                if (intValue == 0) {
                    Log.d(TAG, "delete fail count == 0");
                } else {
                    Log.d(TAG, "delete into count: ".concat(String.valueOf(intValue)));
                    if (intValue > 1) {
                        Log.e(TAG, "delete count error, count: " + intValue + ' ');
                    }
                    a aVar2 = this.BMt;
                    if (aVar2 != null) {
                        aVar2.delete((long) BMC);
                    }
                }
            } else {
                Log.i(TAG, "delete uriMatcher match failed");
            }
            AppMethodBeat.o(75333);
        }
        return 0;
    }

    public final Uri insert(Uri uri, ContentValues contentValues) {
        AppMethodBeat.i(75334);
        p.h(uri, ShareConstants.MEDIA_URI);
        Log.d(TAG, "insert uri:" + uri + ", values:" + contentValues);
        AppMethodBeat.o(75334);
        return null;
    }

    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        AppMethodBeat.i(75335);
        p.h(uri, ShareConstants.MEDIA_URI);
        Log.d(TAG, "update uri" + uri + ", values:" + contentValues + ", selection:" + str + ", selectionArgs:" + strArr);
        AppMethodBeat.o(75335);
        return 0;
    }

    public final String getType(Uri uri) {
        AppMethodBeat.i(75336);
        p.h(uri, ShareConstants.MEDIA_URI);
        Log.d(TAG, "getType uri: ".concat(String.valueOf(uri)));
        AppMethodBeat.o(75336);
        return null;
    }

    private boolean checkValid() {
        boolean z;
        Integer num;
        boolean z2;
        AppMethodBeat.i(75329);
        String[] eJq = eJq();
        if (!(eJq.length == 0)) {
            String str = eJq[0];
            Signature[] cj = q.cj(getContext(), str);
            if (cj == null) {
                p.hyc();
            }
            String messageDigest = com.tencent.mm.b.g.getMessageDigest(cj[0].toByteArray());
            Log.i(TAG, "checkMD5 packageName:" + str + ", signatures:" + cj + ", sig:" + messageDigest);
            if (n.I("2A281593D71DF33374E6124E9106DF08", messageDigest, true)) {
                Log.i(TAG, "checkMD5 success sig:".concat(String.valueOf(messageDigest)));
                z = true;
            } else {
                Log.i(TAG, "checkMD5 failed diff sig:".concat(String.valueOf(messageDigest)));
                z = false;
            }
        } else {
            Log.i(TAG, "checkMD5 failed, packages is empty");
            z = false;
        }
        if (!z) {
            AppMethodBeat.o(75329);
            return false;
        } else if (!g.aAi().aAb() || !g.aAf().azp()) {
            Log.e(TAG, "MMKernel uninit");
            AppMethodBeat.o(75329);
            return false;
        } else {
            if (this.BMt == null) {
                e aAh = g.aAh();
                p.g(aAh, "MMKernel.storage()");
                h dataDB = aAh.getDataDB();
                p.g(dataDB, "MMKernel.storage().dataDB");
                this.BMt = new a(dataDB);
                Log.i(TAG, "checkValid, init database");
            }
            a aVar = this.BMt;
            Cursor rawQuery = aVar != null ? aVar.rawQuery(this.BMu, new String[0]) : null;
            if (rawQuery != null) {
                rawQuery.moveToFirst();
            }
            if (rawQuery != null) {
                num = Integer.valueOf(rawQuery.getCount());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 1) {
                long j2 = rawQuery.getLong(rawQuery.getColumnIndex("time"));
                long currentTimeMillis = System.currentTimeMillis();
                Log.d(TAG, "checkTime db time: " + j2 + ", current time: " + currentTimeMillis + ", diff: " + (currentTimeMillis - j2));
                if (j2 - currentTimeMillis >= ((long) BMD)) {
                    Log.i(TAG, "checkTime timeout diff is: " + (j2 - currentTimeMillis));
                    z2 = false;
                } else {
                    z2 = true;
                }
            } else if (num != null && num.intValue() == 0) {
                Log.i(TAG, "checkTime no data in db");
                z2 = true;
            } else {
                Log.e(TAG, "checkTime count error : ".concat(String.valueOf(num)));
                z2 = false;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            if (!z2) {
                AppMethodBeat.o(75329);
                return false;
            }
            AppMethodBeat.o(75329);
            return true;
        }
    }
}
