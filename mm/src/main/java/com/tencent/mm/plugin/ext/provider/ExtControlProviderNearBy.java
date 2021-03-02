package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.graphics.Bitmap;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.a.ng;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.protocal.protobuf.chi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public final class ExtControlProviderNearBy extends ExtContentProviderBase implements e.a {
    private static final String AUTHORITY = WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_NEARBY();
    private static final String[] COLUMNS = {"nickname", "avatar", "distance", "signature", "sex"};
    private static boolean hho = false;
    private static final UriMatcher sNB;
    private static MTimerHandler sND = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.ext.provider.ExtControlProviderNearBy.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(24441);
            boolean unused = ExtControlProviderNearBy.hho = false;
            AppMethodBeat.o(24441);
            return false;
        }
    }, false);
    private boolean chA;
    private b.a gmA = new b.a() {
        /* class com.tencent.mm.plugin.ext.provider.ExtControlProviderNearBy.AnonymousClass4 */

        @Override // com.tencent.mm.modelgeo.b.a
        public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
            AppMethodBeat.i(24444);
            if (ExtControlProviderNearBy.this.sNC) {
                AppMethodBeat.o(24444);
            } else {
                ExtControlProviderNearBy.this.sNC = true;
                if (!z) {
                    Log.e("MicroMsg.ExtControlProviderNearBy", "get location failed");
                    ExtControlProviderNearBy.f(ExtControlProviderNearBy.this);
                    ExtControlProviderNearBy.this.sNy.countDown();
                    AppMethodBeat.o(24444);
                } else {
                    ng ngVar = new ng();
                    ngVar.dTh.dJY = ExtControlProviderNearBy.this.sNu;
                    ngVar.dTh.dTj = f2;
                    ngVar.dTh.latitude = f3;
                    ngVar.dTh.dTk = (int) d3;
                    ngVar.dTh.dTl = i2;
                    ngVar.dTh.dTm = "";
                    ngVar.dTh.dTn = "";
                    if (EventCenter.instance.publish(ngVar)) {
                        Log.i("MicroMsg.ExtControlProviderNearBy", "do get nearby friend");
                    }
                    AppMethodBeat.o(24444);
                }
            }
            return false;
        }
    };
    private com.tencent.mm.pluginsdk.c.b guy = new com.tencent.mm.pluginsdk.c.b() {
        /* class com.tencent.mm.plugin.ext.provider.ExtControlProviderNearBy.AnonymousClass3 */

        @Override // com.tencent.mm.pluginsdk.c.b
        public final void a(int i2, int i3, String str, IEvent iEvent) {
            AppMethodBeat.i(24443);
            if (iEvent instanceof ng) {
                if (ExtControlProviderNearBy.this.sNy == null) {
                    AppMethodBeat.o(24443);
                    return;
                }
                ng ngVar = (ng) iEvent;
                Log.i("MicroMsg.ExtControlProviderNearBy", "get lbsfriend errcode: " + i3 + ", errType: " + i2);
                if (i2 == 0 && i3 == 0) {
                    ExtControlProviderNearBy.this.sNv = ngVar.dTi.dTp;
                    if (ExtControlProviderNearBy.this.sNv == null || ExtControlProviderNearBy.this.sNv.size() == 0) {
                        Log.e("MicroMsg.ExtControlProviderNearBy", "get lbsfriend list size:0");
                        ExtControlProviderNearBy.this.sNy.countDown();
                    } else {
                        if (ExtControlProviderNearBy.this.sNv.size() > 10) {
                            Log.i("MicroMsg.ExtControlProviderNearBy", "get lbsfriend size > 10," + ExtControlProviderNearBy.this.sNv.size());
                            ExtControlProviderNearBy.this.sNv.subList(10, ExtControlProviderNearBy.this.sNv.size()).clear();
                        }
                        ExtControlProviderNearBy.this.sNz = new CountDownLatch(ExtControlProviderNearBy.this.sNv.size());
                        ExtControlProviderNearBy.this.sNy.countDown();
                        ExtControlProviderNearBy.e(ExtControlProviderNearBy.this);
                    }
                } else {
                    Log.e("MicroMsg.ExtControlProviderNearBy", "get lbsfriend failed: errCode = " + i3 + ", errType=" + i2);
                    ExtControlProviderNearBy.this.sNy.countDown();
                }
                ExtControlProviderNearBy.f(ExtControlProviderNearBy.this);
            }
            AppMethodBeat.o(24443);
        }
    };
    private d iOv;
    private chi sNA;
    private boolean sNC = false;
    private int sNu;
    private List<chi> sNv;
    private com.tencent.mm.storagebase.e sNw;
    private Set<String> sNx;
    private CountDownLatch sNy;
    private CountDownLatch sNz;

    public ExtControlProviderNearBy() {
        AppMethodBeat.i(24445);
        AppMethodBeat.o(24445);
    }

    static {
        AppMethodBeat.i(24455);
        UriMatcher uriMatcher = new UriMatcher(-1);
        sNB = uriMatcher;
        uriMatcher.addURI(AUTHORITY, "male", 1);
        sNB.addURI(AUTHORITY, "female", 2);
        sNB.addURI(AUTHORITY, "all", 0);
        AppMethodBeat.o(24455);
    }

    private static void gW(boolean z) {
        AppMethodBeat.i(24446);
        if (z) {
            hho = true;
            sND.startTimer(15000);
            AppMethodBeat.o(24446);
            return;
        }
        sND.startTimer(0);
        AppMethodBeat.o(24446);
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public final boolean onCreate() {
        return true;
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.i(24447);
        Log.i("MicroMsg.ExtControlProviderNearBy", "query() ".concat(String.valueOf(uri)));
        a(uri, getContext(), 15);
        if (uri == null) {
            HF(3);
            AppMethodBeat.o(24447);
            return null;
        } else if (Util.isNullOrNil(this.sMZ) || Util.isNullOrNil(cSt())) {
            HF(3);
            AppMethodBeat.o(24447);
            return null;
        } else if (hho) {
            Log.w("MicroMsg.ExtControlProviderNearBy", "isDoingRequest, return null");
            HF(5);
            AppMethodBeat.o(24447);
            return null;
        } else {
            gW(true);
            if (!ckf()) {
                gW(false);
                HF(1);
                MatrixCursor matrixCursor = this.pem;
                AppMethodBeat.o(24447);
                return matrixCursor;
            } else if (!fe(getContext())) {
                Log.w("MicroMsg.ExtControlProviderNearBy", "invalid appid ! return null");
                gW(false);
                HF(2);
                AppMethodBeat.o(24447);
                return null;
            } else {
                Log.i("MicroMsg.ExtControlProviderNearBy", "find type = " + this.sNu);
                getType(uri);
                if (this.sNu < 0) {
                    Log.e("MicroMsg.ExtControlProviderNearBy", "unkown uri, return null");
                    gW(false);
                    HF(3);
                    AppMethodBeat.o(24447);
                    return null;
                }
                try {
                    this.sNv = new ArrayList();
                    this.sNw = new com.tencent.mm.storagebase.e(COLUMNS, (byte) 0);
                    this.sNy = new CountDownLatch(1);
                    this.sNz = null;
                    this.sNx = new HashSet();
                    this.sNv = new ArrayList();
                    this.chA = false;
                    Log.v("MicroMsg.ExtControlProviderNearBy", "start()");
                    if (!bg.aAc()) {
                        Log.i("MicroMsg.ExtControlProviderNearBy", "!MMCore.hasSetUin()");
                    } else {
                        com.tencent.mm.pluginsdk.c.b.a(ng.class.getName(), this.guy);
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.ext.provider.ExtControlProviderNearBy.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(24442);
                                if (ExtControlProviderNearBy.this.iOv == null) {
                                    ExtControlProviderNearBy.this.iOv = d.bca();
                                }
                                ExtControlProviderNearBy.this.iOv.a(ExtControlProviderNearBy.this.gmA, true);
                                AppMethodBeat.o(24442);
                            }
                        });
                    }
                    Log.i("MicroMsg.ExtControlProviderNearBy", "wait for get lbs info");
                    if (!this.sNy.await(15000, TimeUnit.MILLISECONDS)) {
                        Log.w("MicroMsg.ExtControlProviderNearBy", "countDownLatchWait time out");
                    }
                    if (this.sNz != null) {
                        Log.i("MicroMsg.ExtControlProviderNearBy", "get lbs info success, wait for get lbs friend");
                        if (!this.sNz.await(15000, TimeUnit.MILLISECONDS)) {
                            Log.w("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet time out");
                        }
                    } else {
                        Log.i("MicroMsg.ExtControlProviderNearBy", "not init countDownGet. return null");
                    }
                } catch (Exception e2) {
                    Log.w("MicroMsg.ExtControlProviderNearBy", e2.getMessage());
                    Log.printErrStackTrace("MicroMsg.ExtControlProviderNearBy", e2, "", new Object[0]);
                    HF(4);
                }
                gW(false);
                p.aYn().b(this);
                this.chA = true;
                cSx();
                if (this.sNw == null || this.sNw.getCount() <= 0) {
                    HF(4);
                } else {
                    HF(0);
                }
                Log.i("MicroMsg.ExtControlProviderNearBy", "return now");
                com.tencent.mm.storagebase.e eVar = this.sNw;
                AppMethodBeat.o(24447);
                return eVar;
            }
        }
    }

    private chi arq(String str) {
        AppMethodBeat.i(24448);
        if (str == null || str.length() <= 0) {
            Log.e("MicroMsg.ExtControlProviderNearBy", "username is null or nill");
            AppMethodBeat.o(24448);
            return null;
        }
        for (chi chi : this.sNv) {
            if (chi.UserName.equals(str)) {
                AppMethodBeat.o(24448);
                return chi;
            }
        }
        AppMethodBeat.o(24448);
        return null;
    }

    private void a(chi chi) {
        AppMethodBeat.i(24449);
        if (chi == null || chi.UserName == null) {
            Log.e("MicroMsg.ExtControlProviderNearBy", "lbsContactInfo is null or lbsContactInfo's userName is null");
            AppMethodBeat.o(24449);
            return;
        }
        this.sNx.add(chi.UserName);
        Bitmap a2 = c.a(chi.UserName, false, -1, null);
        Log.i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet now count: " + this.sNz.getCount());
        if (a2 != null) {
            Log.i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet countDown now");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[0];
            if (a2.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)) {
                bArr = byteArrayOutputStream.toByteArray();
            }
            this.sNx.remove(chi.UserName);
            this.sNw.addRow(new Object[]{chi.oUJ, bArr, chi.MmJ, chi.keb, Integer.valueOf(chi.kdY)});
            Log.i("MicroMsg.ExtControlProviderNearBy", "bitmap recycle %s", a2);
            a2.recycle();
        }
        AppMethodBeat.o(24449);
    }

    @Override // com.tencent.mm.aj.e.a
    public final void Mr(String str) {
        AppMethodBeat.i(24450);
        Log.i("MicroMsg.ExtControlProviderNearBy", "notifyChanged: ".concat(String.valueOf(str)));
        if (this.chA) {
            Log.i("MicroMsg.ExtControlProviderNearBy", "has finished");
            AppMethodBeat.o(24450);
            return;
        }
        a(arq(str));
        this.sNz.countDown();
        AppMethodBeat.o(24450);
    }

    private void cSx() {
        AppMethodBeat.i(24451);
        if (this.sNx.size() > 0) {
            for (String str : this.sNx) {
                Log.i("MicroMsg.ExtControlProviderNearBy", "add lbsfriend has no avatar: ".concat(String.valueOf(str)));
                this.sNA = arq(str);
                if (!(this.sNA == null || this.sNA.UserName == null)) {
                    this.sNw.addRow(new Object[]{this.sNA.oUJ, null, this.sNA.MmJ, this.sNA.keb, Integer.valueOf(this.sNA.kdY)});
                }
            }
            AppMethodBeat.o(24451);
            return;
        }
        Log.i("MicroMsg.ExtControlProviderNearBy", "all user has got avatar");
        AppMethodBeat.o(24451);
    }

    @Override // com.tencent.mm.plugin.ext.provider.ExtContentProviderBase
    public final String getType(Uri uri) {
        AppMethodBeat.i(24452);
        this.sNu = -1;
        switch (sNB.match(uri)) {
            case 0:
                this.sNu = 1;
                break;
            case 1:
                this.sNu = 3;
                break;
            case 2:
                this.sNu = 4;
                break;
            default:
                this.sNu = -1;
                break;
        }
        AppMethodBeat.o(24452);
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

    static /* synthetic */ void e(ExtControlProviderNearBy extControlProviderNearBy) {
        AppMethodBeat.i(24453);
        p.aYn().a(extControlProviderNearBy);
        if (extControlProviderNearBy.sNw == null) {
            extControlProviderNearBy.sNw = new com.tencent.mm.storagebase.e(COLUMNS, (byte) 0);
        }
        for (chi chi : extControlProviderNearBy.sNv) {
            extControlProviderNearBy.a(chi);
        }
        extControlProviderNearBy.sNz.countDown();
        AppMethodBeat.o(24453);
    }

    static /* synthetic */ void f(ExtControlProviderNearBy extControlProviderNearBy) {
        boolean z = true;
        AppMethodBeat.i(24454);
        Log.v("MicroMsg.ExtControlProviderNearBy", "stop()");
        if (!bg.aAc()) {
            Log.i("MicroMsg.ExtControlProviderNearBy", "!MMCore.hasSetUin()");
            AppMethodBeat.o(24454);
            return;
        }
        com.tencent.mm.pluginsdk.c.b.b(ng.class.getName(), extControlProviderNearBy.guy);
        Object[] objArr = new Object[1];
        if (extControlProviderNearBy.iOv != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        Log.v("MicroMsg.ExtControlProviderNearBy", "releaseLbsManager(), lbsManager == null ? [%s]", objArr);
        if (extControlProviderNearBy.iOv != null) {
            extControlProviderNearBy.iOv.c(extControlProviderNearBy.gmA);
        }
        AppMethodBeat.o(24454);
    }
}
