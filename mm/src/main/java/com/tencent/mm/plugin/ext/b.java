package com.tencent.mm.plugin.ext;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.a.a;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.g.a.fq;
import com.tencent.mm.g.a.fy;
import com.tencent.mm.g.a.ge;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi;
import com.tencent.mm.plugin.ext.provider.ExtControlProviderEntry;
import com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg;
import com.tencent.mm.plugin.ext.voicecontrol.ExtControlProviderVoiceControl;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.e;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.protocal.protobuf.eot;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cg;
import com.tencent.mm.storage.ch;
import com.tencent.mm.storage.cr;
import com.tencent.mm.storage.cs;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class b implements bd {
    private static HashMap<Integer, h.b> baseDBFactories;
    private static boolean sMs = false;
    MStorageEx.IOnStorageChange rBr = new MStorageEx.IOnStorageChange() {
        /* class com.tencent.mm.plugin.ext.b.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
        public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
            AppMethodBeat.i(24335);
            if (obj == null || !(obj instanceof String)) {
                Log.d("MicroMsg.SubCoreExt", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i2), mStorageEx, obj);
                AppMethodBeat.o(24335);
            } else if (!bg.aAc()) {
                Log.i("MicroMsg.SubCoreExt", "onNotifyChange acc not ready");
                AppMethodBeat.o(24335);
            } else {
                bg.aVF();
                if (mStorageEx == c.aSN()) {
                    b.d(b.this);
                }
                AppMethodBeat.o(24335);
            }
        }
    };
    private final long sMb = 1600;
    private ao sMc;
    private ch sMd;
    private cs sMe;
    private com.tencent.mm.plugin.ext.a.a sMf;
    private a sMg;
    private C1031b sMh;
    private HashMap<String, Integer> sMi = new HashMap<>();
    private i.a sMj = new i.a() {
        /* class com.tencent.mm.plugin.ext.b.AnonymousClass7 */

        @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i.a
        public final void a(i iVar, i.c cVar) {
            AppMethodBeat.i(24338);
            if (iVar == null || cVar == null || cVar.hIs == null) {
                Log.e("MicroMsg.SubCoreExt", "onMsgChange, wrong args");
                AppMethodBeat.o(24338);
                return;
            }
            synchronized (b.this) {
                try {
                    Cursor gEl = b.cSh().gEl();
                    if (gEl == null) {
                        Log.i("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange getValidOpenMsgListener cu == null");
                        return;
                    }
                    Log.d("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange listener count = %s", Integer.valueOf(gEl.getCount()));
                    if (gEl.getCount() <= 0) {
                        gEl.close();
                        Log.i("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange cu.getCount() <= 0");
                        AppMethodBeat.o(24338);
                        return;
                    }
                    gEl.close();
                    for (int i2 = 0; i2 < cVar.hIs.size(); i2++) {
                        ca caVar = cVar.hIs.get(i2);
                        if (!(caVar == null || caVar.field_isSend != 0 || caVar.field_status == 4 || caVar.getType() == 9999 || caVar.getType() == 10000 || ab.JF(caVar.field_talker) || ab.JJ(caVar.field_talker))) {
                            Integer num = (Integer) b.this.sMi.get(caVar.field_talker);
                            if (num == null) {
                                b.this.sMi.put(caVar.field_talker, 1);
                                Log.d("MicroMsg.SubCoreExt", "onMsgChange %s, %d", caVar.field_talker, 1);
                            } else {
                                b.this.sMi.put(caVar.field_talker, Integer.valueOf(num.intValue() + 1));
                                Log.d("MicroMsg.SubCoreExt", "onMsgChange %s, %d", caVar.field_talker, Integer.valueOf(num.intValue() + 1));
                            }
                        }
                    }
                    if (b.this.sMi.size() > 0) {
                        b.this.cSn();
                    } else {
                        Log.i("MicroMsg.SubCoreExt", "notifyMsgUsers.size < 1");
                    }
                    AppMethodBeat.o(24338);
                } finally {
                    AppMethodBeat.o(24338);
                }
            }
        }
    };
    l.a sMk = new l.a() {
        /* class com.tencent.mm.plugin.ext.b.AnonymousClass8 */

        @Override // com.tencent.mm.pluginsdk.model.l.a
        public final void a(o oVar) {
            AppMethodBeat.i(24339);
            if (oVar == null) {
                AppMethodBeat.o(24339);
                return;
            }
            Iterator<eot> it = oVar.gmC().McK.iterator();
            boolean z = false;
            while (it.hasNext()) {
                eot next = it.next();
                Log.v("MicroMsg.SubCoreExt", "AppId[%s], UserName[%s], Xml[%s]", oVar.appID, next.UserName, next.NmT);
                if (!Util.isNullOrNil(next.UserName) && !Util.isNullOrNil(next.NmT)) {
                    bg.aVF();
                    as bjJ = c.aSN().bjJ(next.UserName);
                    if (bjJ == null || ((int) bjJ.gMZ) <= 0) {
                        Log.e("MicroMsg.SubCoreExt", "contact is null");
                    } else if (bjJ.gBM()) {
                        Log.w("MicroMsg.SubCoreExt", "isBizContact");
                    } else {
                        l.b bdq = l.bdq(next.NmT);
                        if (bdq != null && !Util.isNullOrNil(bdq.JVc)) {
                            Log.v("MicroMsg.SubCoreExt", "AppId[%s], openId[%s]", oVar.appID, bdq.JVc);
                            b.cSi().a(new cr(oVar.appID, next.UserName, bdq.JVc));
                            z = true;
                        }
                    }
                }
            }
            if (z) {
                b.this.cSn();
            }
            AppMethodBeat.o(24339);
        }
    };
    private MMHandler sMl = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.plugin.ext.b.AnonymousClass9 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140514", reviewer = 20, vComment = {EType.INTENTCHECK})
        public final void handleMessage(Message message) {
            boolean z;
            cr crVar;
            AppMethodBeat.i(24341);
            if (MMApplicationContext.getContext() == null || !bg.aAc()) {
                Log.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong status");
                AppMethodBeat.o(24341);
                return;
            }
            Cursor gEl = b.cSh().gEl();
            if (gEl == null) {
                Log.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler getValidOpenMsgListener cu == null");
                AppMethodBeat.o(24341);
                return;
            }
            Log.d("MicroMsg.SubCoreExt", "notifyMsgChangeHandler listener count = %s", Integer.valueOf(gEl.getCount()));
            if (gEl.getCount() <= 0) {
                gEl.close();
                Log.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler cu.getCount() <= 0");
                AppMethodBeat.o(24341);
                return;
            }
            try {
                if (gEl.moveToFirst()) {
                    HashMap hashMap = new HashMap();
                    synchronized (b.this) {
                        try {
                            hashMap.putAll(b.this.sMi);
                            b.this.sMi.clear();
                        } catch (Throwable th) {
                            AppMethodBeat.o(24341);
                            throw th;
                        }
                    }
                    do {
                        LinkedList linkedList = new LinkedList();
                        ArrayList<String> arrayList = new ArrayList<>();
                        if (hashMap.entrySet() == null) {
                            Log.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler waitForNotify.entrySet() == null");
                            AppMethodBeat.o(24341);
                            return;
                        }
                        cg cgVar = new cg();
                        cgVar.convertFrom(gEl);
                        if (Util.isNullOrNil(cgVar.field_appId) || Util.isNullOrNil(cgVar.field_packageName)) {
                            Log.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong msgListener, appid = %s, package = %s", cgVar.field_appId, cgVar.field_packageName);
                        } else {
                            for (Map.Entry entry : hashMap.entrySet()) {
                                String nullAsNil = Util.nullAsNil((String) entry.getKey());
                                Integer num = (Integer) entry.getValue();
                                bg.aVF();
                                az bjY = c.aST().bjY(nullAsNil);
                                if (bjY != null && !Util.isNullOrNil(bjY.field_username) && bjY.field_unReadCount <= 0) {
                                    Log.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler no unread in conversation");
                                } else if (!ab.JF(nullAsNil) && !ab.Eq(nullAsNil) && !ab.IT(nullAsNil)) {
                                    cs cSi = b.cSi();
                                    String str = cgVar.field_appId;
                                    if (str == null || str.length() <= 0 || nullAsNil == null || nullAsNil.length() <= 0) {
                                        crVar = null;
                                    } else {
                                        Cursor query = cSi.db.query("UserOpenIdInApp", null, "appId=? and username=? ", new String[]{Util.escapeSqlValue(str), Util.escapeSqlValue(nullAsNil)}, null, null, null, 2);
                                        if (!query.moveToFirst()) {
                                            Log.w("MicroMsg.scanner.UserOpenIdInAppStorage", "get null with appId-%s, username-%s:", str, nullAsNil);
                                            query.close();
                                            crVar = null;
                                        } else {
                                            crVar = new cr();
                                            crVar.convertFrom(query);
                                            query.close();
                                        }
                                    }
                                    if (crVar == null || Util.isNullOrNil(crVar.field_openId) || Util.isNullOrNil(crVar.field_username)) {
                                        Log.d("MicroMsg.SubCoreExt", "notifyMsgChangeHandler openId is null, go get it.");
                                        Integer num2 = (Integer) b.this.sMi.get(nullAsNil);
                                        if (num2 == null) {
                                            b.this.sMi.put(nullAsNil, num);
                                        } else {
                                            b.this.sMi.put(nullAsNil, Integer.valueOf(num2.intValue() + num.intValue()));
                                        }
                                        linkedList.add(nullAsNil);
                                    } else {
                                        Log.v("MicroMsg.SubCoreExt", "username[%s], appId[%s], openId[%s]", crVar.field_username, crVar.field_appId, crVar.field_openId);
                                        arrayList.add(String.format("%s,%s,%s", crVar.field_openId, num, Long.valueOf(System.currentTimeMillis() - 1600)));
                                    }
                                }
                            }
                            if (linkedList.size() > 0) {
                                Log.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler doGetGetUserInfoInApp");
                                b bVar = b.this;
                                String str2 = cgVar.field_appId;
                                if (!Util.isNullOrNil(str2) && linkedList.size() > 0) {
                                    l gms = l.gms();
                                    Context context = MMApplicationContext.getContext();
                                    l.a aVar = bVar.sMk;
                                    Log.d("MicroMsg.GetUserInfoInAppLogic", "getGetUserInfoInApp");
                                    if (!l.JUZ) {
                                        gms.gmt();
                                    }
                                    if (bg.aAc() && context != null) {
                                        if (linkedList.size() == 0) {
                                            Log.d("MicroMsg.GetUserInfoInAppLogic", "userNameList empty");
                                        } else {
                                            gms.JVb = aVar;
                                            o oVar = new o(str2, linkedList);
                                            com.tencent.mm.pluginsdk.model.app.ao.eAV();
                                            e.a(14, oVar);
                                        }
                                    }
                                }
                            }
                            if (arrayList.size() <= 0) {
                                gEl.close();
                                Log.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler userDataList.size() <= 0");
                                AppMethodBeat.o(24341);
                                return;
                            }
                            if (cgVar.field_status == 1) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (!z) {
                                Log.w("MicroMsg.SubCoreExt", "invalid msgListener, appid = %s, package = %s", cgVar.field_appId, cgVar.field_packageName);
                            } else if (!Util.isNullOrNil(cgVar.field_appId) && !Util.isNullOrNil(cgVar.field_packageName)) {
                                Log.i("MicroMsg.SubCoreExt", "notify app, appId = %s, package = %s", cgVar.field_appId, cgVar.field_packageName);
                                final Intent intent = new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_NOTIFY_MSG");
                                intent.addCategory("com.tencent.mm.category." + cgVar.field_packageName);
                                com.tencent.mm.compatible.a.a.a(12, new a.AbstractC0298a() {
                                    /* class com.tencent.mm.plugin.ext.b.AnonymousClass9.AnonymousClass1 */

                                    @Override // com.tencent.mm.compatible.a.a.AbstractC0298a
                                    public final void run() {
                                        AppMethodBeat.i(24340);
                                        intent.setFlags(32);
                                        AppMethodBeat.o(24340);
                                    }
                                });
                                intent.putExtra("EXTRA_EXT_OPEN_NOTIFY_TYPE", "NEW_MESSAGE");
                                intent.putStringArrayListExtra("EXTRA_EXT_OPEN_USER_DATA", arrayList);
                                MMApplicationContext.getContext().sendBroadcast(intent);
                            }
                        }
                    } while (gEl.moveToNext());
                }
                gEl.close();
                AppMethodBeat.o(24341);
            } catch (Exception e2) {
                Log.e("MicroMsg.SubCoreExt", "Exception in handleMessage, %s", e2.getMessage());
                if (gEl != null) {
                    gEl.close();
                }
                AppMethodBeat.o(24341);
            }
        }
    };
    private LinkedList<String> sMm = new LinkedList<>();
    private final long sMn = 60;
    private MMHandler sMo = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.plugin.ext.b.AnonymousClass10 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            int i2;
            AppMethodBeat.i(24342);
            try {
                if (b.this.sMm.size() <= 0) {
                    AppMethodBeat.o(24342);
                    return;
                }
                Iterator it = b.this.sMm.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (!"*".equals(str)) {
                        g o = com.tencent.mm.pluginsdk.model.app.h.o(str, false, false);
                        if (o == null) {
                            Log.w("MicroMsg.SubCoreExt", "appInfo is null");
                        } else if (Util.isNullOrNil(o.field_appId)) {
                            Log.w("MicroMsg.SubCoreExt", "appId is null");
                        } else {
                            Log.d("MicroMsg.SubCoreExt", "onAppInfoStgChange, notify[%s], appFlag[%s], id[%s]", str, Integer.valueOf(o.field_appInfoFlag), o.field_appId);
                            cg bkL = b.cSh().bkL(o.field_appId);
                            if (bkL == null) {
                                Log.w("MicroMsg.SubCoreExt", "openMsgListener is null, appId = %s", o.field_appId);
                            } else {
                                if (com.tencent.mm.pluginsdk.model.app.h.o(o)) {
                                    if (bkL.field_status != 1) {
                                        bkL.field_status = 1;
                                    }
                                } else if (bkL.field_status != 0) {
                                    bkL.field_status = 0;
                                }
                                ch cSh = b.cSh();
                                String str2 = o.field_appId;
                                if (Util.isNullOrNil(str2) || bkL == null || Util.isNullOrNil(bkL.field_appId)) {
                                    Log.w("MicroMsg.OpenMsgListenerStorage", "wrong argument");
                                } else {
                                    ContentValues convertTo = bkL.convertTo();
                                    if (convertTo.size() > 0) {
                                        i2 = cSh.db.update("OpenMsgListener", convertTo, "appId=?", new String[]{Util.escapeSqlValue(str2)});
                                    } else {
                                        i2 = 0;
                                    }
                                    Log.d("MicroMsg.OpenMsgListenerStorage", "update: id=%s, ret=%s ", bkL.field_appId, Integer.valueOf(i2));
                                }
                            }
                        }
                    }
                }
                b.this.sMm.clear();
                AppMethodBeat.o(24342);
            } catch (Exception e2) {
                Log.e("MicroMsg.SubCoreExt", "exception in onAppInfoStgChange, %s", e2.getMessage());
                AppMethodBeat.o(24342);
            }
        }
    };
    private MStorage.IOnStorageChange sMp = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.plugin.ext.b.AnonymousClass11 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(24343);
            if (!b.this.sMm.contains(str)) {
                b.this.sMm.add(str);
            }
            b.this.sMo.removeMessages(0);
            b.this.sMo.sendEmptyMessageDelayed(0, 60);
            AppMethodBeat.o(24343);
        }
    };
    private boolean sMq = true;
    private boolean sMr = false;

    public b() {
        AppMethodBeat.i(24346);
        AppMethodBeat.o(24346);
    }

    static /* synthetic */ void d(b bVar) {
        AppMethodBeat.i(24362);
        bVar.ms(false);
        AppMethodBeat.o(24362);
    }

    static {
        AppMethodBeat.i(24363);
        int aon = m.aon();
        try {
            if (!Build.CPU_ABI.contains("armeabi")) {
                Log.e("hakon SilkCodec", "x86 machines not supported.");
            } else if ((aon & 1024) != 0) {
                b.class.getClassLoader();
                j.Ed("wechatvoicesilk");
            } else if ((aon & 512) != 0) {
                Log.e("hakon SilkCodec", "load library failed! silk don't support armv6!!!!");
            } else {
                Log.e("hakon SilkCodec", "load library failed! silk don't support armv5!!!!");
            }
        } catch (Exception e2) {
            Log.e("hakon SilkCodec", "load library failed!");
        }
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("OPENMSGLISTENER_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.ext.b.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return ch.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("USEROPENIDINAPP_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.ext.b.AnonymousClass4 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return cs.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("WXATOKENINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.ext.b.AnonymousClass5 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.ext.a.a.SQL_CREATE;
            }
        });
        AppMethodBeat.o(24363);
    }

    public static b cSf() {
        AppMethodBeat.i(24347);
        bg.aVz();
        b bVar = (b) com.tencent.mm.model.cg.KG("plugin.ext");
        if (bVar == null) {
            bVar = new b();
            bg.aVz().a("plugin.ext", bVar);
        }
        AppMethodBeat.o(24347);
        return bVar;
    }

    public static ao cSg() {
        AppMethodBeat.i(24348);
        com.tencent.mm.kernel.g.aAf().azk();
        if (cSf().sMc == null) {
            b cSf = cSf();
            bg.aVF();
            cSf.sMc = new ao(c.getDataDB());
        }
        ao aoVar = cSf().sMc;
        AppMethodBeat.o(24348);
        return aoVar;
    }

    public static ch cSh() {
        AppMethodBeat.i(24349);
        com.tencent.mm.kernel.g.aAf().azk();
        if (cSf().sMd == null) {
            b cSf = cSf();
            bg.aVF();
            cSf.sMd = new ch(c.getDataDB());
        }
        ch chVar = cSf().sMd;
        AppMethodBeat.o(24349);
        return chVar;
    }

    public static cs cSi() {
        AppMethodBeat.i(24350);
        com.tencent.mm.kernel.g.aAf().azk();
        if (cSf().sMe == null) {
            b cSf = cSf();
            bg.aVF();
            cSf.sMe = new cs(c.getDataDB());
        }
        cs csVar = cSf().sMe;
        AppMethodBeat.o(24350);
        return csVar;
    }

    public static com.tencent.mm.plugin.ext.a.a cSj() {
        AppMethodBeat.i(24351);
        com.tencent.mm.kernel.g.aAf().azk();
        if (cSf().sMf == null) {
            b cSf = cSf();
            bg.aVF();
            cSf.sMf = new com.tencent.mm.plugin.ext.a.a(c.getDataDB());
        }
        com.tencent.mm.plugin.ext.a.a aVar = cSf().sMf;
        AppMethodBeat.o(24351);
        return aVar;
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return baseDBFactories;
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
        AppMethodBeat.i(24352);
        cSk();
        AppMethodBeat.o(24352);
    }

    private static void cSk() {
        AppMethodBeat.i(24353);
        com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(com.tencent.mm.kernel.g.aAh().hqG);
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        com.tencent.mm.vfs.o oVar2 = new com.tencent.mm.vfs.o(com.tencent.mm.kernel.g.aAh().hqG + "image/ext/pcm");
        if (!oVar2.exists()) {
            oVar2.mkdirs();
        }
        Log.i("MicroMsg.SubCoreExt", "summerpcm accPath[%s] [%s]", com.tencent.mm.kernel.g.aAh().hqG, Util.getStack());
        AppMethodBeat.o(24353);
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(24354);
        fq fqVar = new fq();
        fqVar.dIO.op = 1;
        if (!EventCenter.instance.publish(fqVar)) {
            Log.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountPostReset");
        }
        l.gms().gmt();
        bg.aVF();
        c.aSQ().a(this.sMj, (Looper) null);
        if (this.sMg == null) {
            this.sMg = new a();
        }
        EventCenter.instance.addListener(this.sMg);
        if (this.sMh == null) {
            this.sMh = new C1031b();
        }
        EventCenter.instance.addListener(this.sMh);
        com.tencent.mm.pluginsdk.model.app.j eAS = com.tencent.mm.pluginsdk.model.app.ao.eAS();
        if (eAS != null) {
            eAS.add(this.sMp);
        }
        SharedPreferences defaultPreference = MMApplicationContext.getDefaultPreference();
        this.sMr = defaultPreference.getBoolean("hasTryToInitVoiceControlData", false);
        sMs = defaultPreference.getBoolean("hasCallVoiceControlApi", false);
        Log.i("MicroMsg.SubCoreExt", "onAccountPostReset,hasTryToInit:%s,hasCallApi:%s", Boolean.valueOf(this.sMr), Boolean.valueOf(sMs));
        bg.aVF();
        c.aSN().add(this.rBr);
        ms(true);
        com.tencent.mm.plugin.ext.d.c.cSB();
        cSk();
        AppMethodBeat.o(24354);
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(24355);
        if (this.sMg != null) {
            EventCenter.instance.removeListener(this.sMg);
        }
        if (this.sMh != null) {
            EventCenter.instance.removeListener(this.sMh);
        }
        com.tencent.mm.pluginsdk.model.app.j eAS = com.tencent.mm.pluginsdk.model.app.ao.eAS();
        if (eAS != null) {
            eAS.remove(this.sMp);
        }
        bg.aVF();
        c.aSQ().a(this.sMj);
        fq fqVar = new fq();
        fqVar.dIO.op = 2;
        if (!EventCenter.instance.publish(fqVar)) {
            Log.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountRelease");
        }
        l gms = l.gms();
        if (bg.aAc()) {
            l.JUZ = false;
            com.tencent.mm.pluginsdk.model.app.ao.eAV().b(14, gms);
        }
        bg.aVF();
        c.aSN().remove(this.rBr);
        com.tencent.mm.plugin.ext.d.c.cSC();
        AppMethodBeat.o(24355);
    }

    public static String cSl() {
        AppMethodBeat.i(24356);
        String str = com.tencent.mm.kernel.g.aAh().hqG + "image/ext/pcm";
        AppMethodBeat.o(24356);
        return str;
    }

    public static class a extends IListener<fy> {
        public a() {
            AppMethodBeat.i(161360);
            this.__eventId = fy.class.getName().hashCode();
            AppMethodBeat.o(161360);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(fy fyVar) {
            AppMethodBeat.i(24344);
            fy fyVar2 = fyVar;
            if (!(fyVar2 instanceof fy)) {
                Log.f("MicroMsg.SubCoreExt", "mismatched event");
                AppMethodBeat.o(24344);
                return false;
            } else if (fyVar2.dJy == null) {
                Log.e("MicroMsg.SubCoreExt", "revent.data is null");
                AppMethodBeat.o(24344);
                return false;
            } else {
                if (fyVar2.dJy.dIT == 9 || fyVar2.dJy.dIT == 13) {
                    ExtControlProviderMsg extControlProviderMsg = new ExtControlProviderMsg(fyVar2.dJy.dBX, fyVar2.dJy.dIT, fyVar2.dJy.context);
                    fyVar2.dJz.dIU = extControlProviderMsg.query(fyVar2.dJy.uri, null, null, fyVar2.dJy.selectionArgs, null);
                } else if (fyVar2.dJy.dIT == 3) {
                    ExtControlProviderEntry extControlProviderEntry = new ExtControlProviderEntry(fyVar2.dJy.dBX, fyVar2.dJy.dIT, fyVar2.dJy.context);
                    fyVar2.dJz.dIU = extControlProviderEntry.query(fyVar2.dJy.uri, null, null, fyVar2.dJy.selectionArgs, null);
                } else if (fyVar2.dJy.dIT == 29) {
                    ExtControlProviderVoiceControl extControlProviderVoiceControl = new ExtControlProviderVoiceControl(fyVar2.dJy.dBX, fyVar2.dJy.dIT, fyVar2.dJy.context);
                    fyVar2.dJz.dIU = extControlProviderVoiceControl.query(fyVar2.dJy.uri, null, null, fyVar2.dJy.selectionArgs, null);
                    SharedPreferences defaultPreference = MMApplicationContext.getDefaultPreference();
                    if (!b.sMs) {
                        defaultPreference.edit().putBoolean("hasCallVoiceControlApi", true).commit();
                        boolean unused = b.sMs = true;
                    }
                } else {
                    ExtControlProviderOpenApi extControlProviderOpenApi = new ExtControlProviderOpenApi(fyVar2.dJy.dBX, fyVar2.dJy.dIT, fyVar2.dJy.context, fyVar2.dJy.appId);
                    fyVar2.dJz.dIU = extControlProviderOpenApi.query(fyVar2.dJy.uri, null, null, fyVar2.dJy.selectionArgs, null);
                }
                AppMethodBeat.o(24344);
                return true;
            }
        }
    }

    public static void cSm() {
        AppMethodBeat.i(24357);
        String str = (String) cSg().get(ar.a.USERINFO_EXT_SPORT_PKGNAME_STRING, (Object) null);
        Log.i("MicroMsg.SubCoreExt", "sendSportBroadcast pkgNames = ".concat(String.valueOf(str)));
        if (str != null) {
            String[] split = str.split(";");
            for (String str2 : split) {
                final Intent intent = new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_SET_SPORT_STEP");
                intent.setPackage(str2);
                com.tencent.mm.compatible.a.a.a(12, new a.AbstractC0298a() {
                    /* class com.tencent.mm.plugin.ext.b.AnonymousClass6 */

                    @Override // com.tencent.mm.compatible.a.a.AbstractC0298a
                    public final void run() {
                        AppMethodBeat.i(24337);
                        intent.setFlags(32);
                        AppMethodBeat.o(24337);
                    }
                });
                intent.putExtra("EXTRA_EXT_OPEN_NOTIFY_TYPE", "SPORT_MESSAGE");
                MMApplicationContext.getContext().sendBroadcast(intent);
            }
        }
        AppMethodBeat.o(24357);
    }

    /* renamed from: com.tencent.mm.plugin.ext.b$b  reason: collision with other inner class name */
    public static class C1031b extends IListener<ge> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ge geVar) {
            AppMethodBeat.i(24345);
            ge geVar2 = geVar;
            if (geVar2.dJP == null) {
                Log.e("MicroMsg.SubCoreExt", "StepCount revent.data is null");
            } else {
                Log.i("MicroMsg.SubCoreExt", " action = " + geVar2.dJP.action);
                if (geVar2.dJP.action == 1) {
                    b.cSm();
                    Log.d("MicroMsg.SubCoreExt", " sendBroadcast");
                    AppMethodBeat.o(24345);
                    return true;
                }
            }
            AppMethodBeat.o(24345);
            return false;
        }

        public C1031b() {
            super(0);
            AppMethodBeat.i(161361);
            this.__eventId = ge.class.getName().hashCode();
            AppMethodBeat.o(161361);
        }
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    public static as DA(long j2) {
        AppMethodBeat.i(24358);
        if (!bg.aAc() || j2 <= 0) {
            AppMethodBeat.o(24358);
            return null;
        }
        bg.aVF();
        as Nh = c.aSN().Nh(j2);
        AppMethodBeat.o(24358);
        return Nh;
    }

    public static void DB(long j2) {
        AppMethodBeat.i(24359);
        if (j2 <= 0) {
            AppMethodBeat.o(24359);
            return;
        }
        try {
            bg.aVF();
            if (c.aSQ().He(j2)) {
                bg.aVF();
                i aSQ = c.aSQ();
                bg.aVF();
                aSQ.aD(c.aSQ().Hb(j2));
                AppMethodBeat.o(24359);
                return;
            }
            Log.e("MicroMsg.SubCoreExt", "msgId is out of range, ".concat(String.valueOf(j2)));
            AppMethodBeat.o(24359);
        } catch (Exception e2) {
            Log.e("MicroMsg.SubCoreExt", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.SubCoreExt", e2, "", new Object[0]);
            AppMethodBeat.o(24359);
        }
    }

    public final void cSn() {
        AppMethodBeat.i(24360);
        this.sMl.removeMessages(0);
        this.sMl.sendEmptyMessageDelayed(0, 1600);
        AppMethodBeat.o(24360);
    }

    private void ms(boolean z) {
        AppMethodBeat.i(24361);
        if (!this.sMq) {
            AppMethodBeat.o(24361);
        } else if (z && this.sMr) {
            Log.i("MicroMsg.SubCoreExt", "fromStartApp and already try to init");
            AppMethodBeat.o(24361);
        } else if (z || sMs) {
            Log.i("MicroMsg.SubCoreExt", "initLocalVoiceControl,fromStartApp:%s,hasTryToInit:%s,hasCallApi:%s", Boolean.valueOf(z), Boolean.valueOf(this.sMr), Boolean.valueOf(sMs));
            this.sMq = false;
            bg.aAk().postToWorkerDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.ext.b.AnonymousClass3 */

                /* JADX WARNING: Code restructure failed: missing block: B:43:0x01cc, code lost:
                    if (r0 >= 0) goto L_0x01ce;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                    // Method dump skipped, instructions count: 521
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ext.b.AnonymousClass3.run():void");
                }
            }, 10000);
            AppMethodBeat.o(24361);
        } else {
            AppMethodBeat.o(24361);
        }
    }
}
