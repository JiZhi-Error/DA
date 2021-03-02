package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.g.a.o;
import com.tencent.mm.g.a.yj;
import com.tencent.mm.g.a.yw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.c;
import com.tencent.mm.modelappbrand.d;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.WordingInfo;
import com.tencent.mm.msgsubscription.presenter.SubscribeMsgSettingData;
import com.tencent.mm.msgsubscription.ui.BizSubscribeMsgManagerUI;
import com.tencent.mm.msgsubscription.util.c;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.ae;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.ipc.e;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMAuthScopeRiskInfo;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMUserAvatarInfo;
import com.tencent.mm.plugin.appbrand.jsapi.auth.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.cpc;
import com.tencent.mm.protocal.protobuf.drd;
import com.tencent.mm.protocal.protobuf.dwq;
import com.tencent.mm.protocal.protobuf.dwr;
import com.tencent.mm.protocal.protobuf.eor;
import com.tencent.mm.protocal.protobuf.fce;
import com.tencent.mm.protocal.protobuf.fcf;
import com.tencent.mm.protocal.protobuf.fco;
import com.tencent.mm.protocal.protobuf.fcp;
import com.tencent.mm.protocal.protobuf.fdy;
import com.tencent.mm.protocal.protobuf.hj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppBrandAuthorizeUI extends MMPreference {
    private static final String[] nRs = {"preference_key_subscribe_msg", "scope.userInfo", "scope.userLocation"};
    private static final String[] nRt = {"scope.receiptQrCode", "scope.personalC2CPay"};
    private int cxE;
    private q gxX;
    private boolean jyD = false;
    private String mAppId;
    private String mRa;
    private hj nRA;
    private int nRB;
    private boolean nRC = false;
    private boolean nRD = true;
    private boolean nRE = false;
    private boolean nRF = false;
    private boolean nRG = false;
    boolean nRH = false;
    boolean nRI = false;
    private SubscribeMsgSettingData nRJ;
    private MMUserAvatarInfo nRK;
    private b nRL;
    private boolean nRM;
    private boolean nRN;
    private boolean nRO = false;
    private boolean nRP = true;
    private IListener<o> nRQ = new IListener<o>() {
        /* class com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AnonymousClass1 */

        {
            AppMethodBeat.i(227560);
            this.__eventId = o.class.getName().hashCode();
            AppMethodBeat.o(227560);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(o oVar) {
            AppMethodBeat.i(227561);
            o oVar2 = oVar;
            if (!(AppBrandAuthorizeUI.this.nRm == null || AppBrandAuthorizeUI.this.nRm.bmg("preference_key_notify_msg") == null)) {
                Log.i("MicroMsg.AppBrandAuthorizeUI", "change notify preferent status by event");
                ((CheckBoxPreference) AppBrandAuthorizeUI.this.nRm.bmg("preference_key_notify_msg")).setChecked(oVar2.dCr.dCs);
            }
            AppMethodBeat.o(227561);
            return true;
        }
    };
    protected f nRm;
    List<hj> nRu = new ArrayList();
    private ae nRv;
    private Preference nRw;
    private IconPreference nRx;
    private hj nRy;
    private hj nRz;

    /* access modifiers changed from: package-private */
    public interface a {
        void dQ(boolean z);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AppBrandAuthorizeUI() {
        AppMethodBeat.i(48553);
        AppMethodBeat.o(48553);
    }

    static /* synthetic */ void a(AppBrandAuthorizeUI appBrandAuthorizeUI, IconPreference iconPreference, hj hjVar) {
        AppMethodBeat.i(227594);
        appBrandAuthorizeUI.a(iconPreference, hjVar);
        AppMethodBeat.o(227594);
    }

    static /* synthetic */ void a(AppBrandAuthorizeUI appBrandAuthorizeUI, List list, a aVar) {
        AppMethodBeat.i(227591);
        appBrandAuthorizeUI.a(list, aVar);
        AppMethodBeat.o(227591);
    }

    static /* synthetic */ boolean a(AppBrandAuthorizeUI appBrandAuthorizeUI, List list, SubscribeMsgSettingData subscribeMsgSettingData, boolean z) {
        AppMethodBeat.i(48572);
        boolean a2 = appBrandAuthorizeUI.a(list, subscribeMsgSettingData, z);
        AppMethodBeat.o(48572);
        return a2;
    }

    static /* synthetic */ boolean bS(List list) {
        AppMethodBeat.i(48578);
        boolean bR = bR(list);
        AppMethodBeat.o(48578);
        return bR;
    }

    static /* synthetic */ void e(AppBrandAuthorizeUI appBrandAuthorizeUI) {
        AppMethodBeat.i(48573);
        appBrandAuthorizeUI.bWK();
        AppMethodBeat.o(48573);
    }

    static /* synthetic */ void h(AppBrandAuthorizeUI appBrandAuthorizeUI) {
        AppMethodBeat.i(48577);
        appBrandAuthorizeUI.iH(true);
        AppMethodBeat.o(48577);
    }

    static /* synthetic */ boolean j(String str, List list) {
        AppMethodBeat.i(48571);
        boolean i2 = i(str, list);
        AppMethodBeat.o(48571);
        return i2;
    }

    static /* synthetic */ void n(AppBrandAuthorizeUI appBrandAuthorizeUI) {
        AppMethodBeat.i(227598);
        appBrandAuthorizeUI.bWQ();
        AppMethodBeat.o(227598);
    }

    /* access modifiers changed from: package-private */
    public static class b extends Handler {
        WeakReference<AppBrandAuthorizeUI> nSm;

        b(AppBrandAuthorizeUI appBrandAuthorizeUI) {
            AppMethodBeat.i(48551);
            this.nSm = new WeakReference<>(appBrandAuthorizeUI);
            AppMethodBeat.o(48551);
        }

        public final void handleMessage(Message message) {
            String str;
            T t;
            SubscribeMsgTmpItem subscribeMsgTmpItem;
            AppMethodBeat.i(48552);
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    AppBrandAuthorizeUI appBrandAuthorizeUI = this.nSm.get();
                    if (appBrandAuthorizeUI == null) {
                        AppMethodBeat.o(48552);
                        return;
                    }
                    SubscribeMsgSettingData subscribeMsgSettingData = (SubscribeMsgSettingData) message.obj;
                    appBrandAuthorizeUI.nRI = true;
                    if (subscribeMsgSettingData == null) {
                        AppBrandAuthorizeUI.a(appBrandAuthorizeUI, appBrandAuthorizeUI.nRu, (SubscribeMsgSettingData) null);
                        AppMethodBeat.o(48552);
                        return;
                    }
                    appBrandAuthorizeUI.nRJ = subscribeMsgSettingData;
                    AppBrandAuthorizeUI.a(appBrandAuthorizeUI, appBrandAuthorizeUI.nRu, appBrandAuthorizeUI.nRJ);
                    AppMethodBeat.o(48552);
                    return;
                case 2:
                    AppBrandAuthorizeUI appBrandAuthorizeUI2 = this.nSm.get();
                    if (appBrandAuthorizeUI2 != null) {
                        SubscribeMsgRequestResult subscribeMsgRequestResult = (SubscribeMsgRequestResult) message.obj;
                        AppBrandAuthorizeUI.b(appBrandAuthorizeUI2);
                        if (subscribeMsgRequestResult != null) {
                            SubscribeMsgSettingData subscribeMsgSettingData2 = appBrandAuthorizeUI2.nRJ;
                            p.h(subscribeMsgRequestResult, "result");
                            subscribeMsgSettingData2.jyp = subscribeMsgRequestResult.jyp;
                            subscribeMsgSettingData2.iQD = subscribeMsgRequestResult.jyo;
                            WordingInfo wordingInfo = subscribeMsgRequestResult.jyn;
                            if (wordingInfo == null || (str = wordingInfo.jyL) == null) {
                                str = "";
                            }
                            subscribeMsgSettingData2.jAi = str;
                            ArrayList<SubscribeMsgTmpItem> arrayList = subscribeMsgRequestResult.jyk;
                            ArrayList arrayList2 = new ArrayList();
                            Iterator<T> it = arrayList.iterator();
                            while (it.hasNext()) {
                                Parcel obtain = Parcel.obtain();
                                p.g(obtain, "Parcel.obtain()");
                                it.next().writeToParcel(obtain, 0);
                                obtain.setDataPosition(0);
                                arrayList2.add(new SubscribeMsgTmpItem(obtain));
                                obtain.recycle();
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.addAll(subscribeMsgSettingData2.iHf);
                            int i2 = 0;
                            for (Object obj : arrayList2) {
                                int i3 = i2 + 1;
                                if (i2 < 0) {
                                    j.hxH();
                                }
                                SubscribeMsgTmpItem subscribeMsgTmpItem2 = (SubscribeMsgTmpItem) obj;
                                Iterator it2 = arrayList3.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        Object next = it2.next();
                                        if (TextUtils.equals(((SubscribeMsgTmpItem) next).ixM, subscribeMsgTmpItem2.ixM)) {
                                            subscribeMsgTmpItem = next;
                                        }
                                    } else {
                                        subscribeMsgTmpItem = null;
                                    }
                                }
                                SubscribeMsgTmpItem subscribeMsgTmpItem3 = subscribeMsgTmpItem;
                                if (subscribeMsgTmpItem3 != null) {
                                    arrayList3.set(arrayList3.indexOf(subscribeMsgTmpItem3), subscribeMsgTmpItem2);
                                    i2 = i3;
                                } else {
                                    i2 = i3;
                                }
                            }
                            subscribeMsgSettingData2.iHf = arrayList3;
                            for (T t2 : subscribeMsgRequestResult.jyk) {
                                Iterator<T> it3 = subscribeMsgSettingData2.jAj.jyk.iterator();
                                while (true) {
                                    if (it3.hasNext()) {
                                        T next2 = it3.next();
                                        if (TextUtils.equals(t2.ixM, next2.ixM)) {
                                            t = next2;
                                        }
                                    } else {
                                        t = null;
                                    }
                                }
                                subscribeMsgSettingData2.jAj.jyk.set(j.a((List) subscribeMsgSettingData2.jAj.jyk, (Object) t), t2);
                            }
                            if (appBrandAuthorizeUI2.nRJ.jyp) {
                                Preference bmg = appBrandAuthorizeUI2.nRm.bmg("preference_key_subscribe_msg");
                                if (bmg != null) {
                                    bmg.setSummary(appBrandAuthorizeUI2.nRJ.iQD ? "" : appBrandAuthorizeUI2.getContext().getString(R.string.a3s));
                                    appBrandAuthorizeUI2.nRm.notifyDataSetChanged();
                                }
                            } else {
                                appBrandAuthorizeUI2.nRm.bmi("preference_key_subscribe_msg");
                                appBrandAuthorizeUI2.nRm.notifyDataSetChanged();
                            }
                            AppBrandAuthorizeUI.a(appBrandAuthorizeUI2, appBrandAuthorizeUI2.nRu, appBrandAuthorizeUI2.nRJ, AppBrandAuthorizeUI.j(appBrandAuthorizeUI2.mAppId, appBrandAuthorizeUI2.nRu));
                            yw ywVar = new yw();
                            ywVar.efe.dCl = appBrandAuthorizeUI2.mRa;
                            ywVar.efe.action = !appBrandAuthorizeUI2.nRJ.iQD ? 1 : 2;
                            ywVar.efe.option = 1;
                            EventCenter.instance.publish(ywVar);
                            break;
                        } else {
                            u.makeText(appBrandAuthorizeUI2, appBrandAuthorizeUI2.getString(R.string.a3c), 1).show();
                            AppMethodBeat.o(48552);
                            return;
                        }
                    } else {
                        AppMethodBeat.o(48552);
                        return;
                    }
            }
            AppMethodBeat.o(48552);
        }
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.f3181h;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48554);
        fixStatusbar(true);
        super.onCreate(bundle);
        this.nRL = new b(this);
        String stringExtra = getIntent().getStringExtra("key_username");
        this.mRa = stringExtra;
        if (Util.isNullOrNil(stringExtra)) {
            Log.e("MicroMsg.AppBrandAuthorizeUI", "username is null");
            finish();
            AppMethodBeat.o(48554);
            return;
        }
        this.nRv = y.Xr(this.mRa);
        if (this.nRv == null) {
            Log.e("MicroMsg.AppBrandAuthorizeUI", "attrs is null");
            finish();
            AppMethodBeat.o(48554);
            return;
        }
        this.nRE = getIntent().getBooleanExtra("key_app_authorize_jsapi", false);
        this.jyD = getIntent().getBooleanExtra("key_app_authorize_profile", false);
        setMMTitle(R.string.ix);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AnonymousClass12 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(227571);
                AppBrandAuthorizeUI.e(AppBrandAuthorizeUI.this);
                AppBrandAuthorizeUI.this.finish();
                AppMethodBeat.o(227571);
                return false;
            }
        });
        this.nRm = getPreferenceScreen();
        this.mAppId = this.nRv.appId;
        this.cxE = this.nRv.cyo;
        this.nRM = n.buK().bj(this.mRa, this.cxE);
        String str = this.mAppId;
        d.a aVar = new d.a();
        aVar.iLN = new fce();
        aVar.iLO = new fcf();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp_getauthinfo";
        aVar.funcId = FaceManager.FACE_ACQUIRED_UP;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        fce fce = new fce();
        fce.appId = str;
        aVar.iLN = fce;
        aa.a(aVar.aXF(), new aa.a() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AnonymousClass3 */

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, d dVar, com.tencent.mm.ak.q qVar) {
                AppMethodBeat.i(227563);
                Log.d("MicroMsg.AppBrandAuthorizeUI", "WxaAppGetAuthInfoReq errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                if (i2 == 0 && i3 == 0) {
                    fcf fcf = (fcf) dVar.iLL.iLR;
                    if (fcf == null) {
                        AppBrandAuthorizeUI.h(AppBrandAuthorizeUI.this);
                        Log.e("MicroMsg.AppBrandAuthorizeUI", "WxaAppGetAuthInfoReq failed, response is null!");
                    } else {
                        int i4 = fcf.Nyd.errCode;
                        String str2 = fcf.Nyd.errMsg;
                        if (i4 == 0) {
                            AppBrandAuthorizeUI.this.nRu = fcf.Nye;
                            AppBrandAuthorizeUI.this.nRG = AppBrandAuthorizeUI.bS(fcf.Nye);
                        } else {
                            AppBrandAuthorizeUI.h(AppBrandAuthorizeUI.this);
                            Log.e("MicroMsg.AppBrandAuthorizeUI", "WxaAppGetAuthInfoReq error %s", str2);
                        }
                    }
                    AppBrandAuthorizeUI.this.nRH = true;
                    AppBrandAuthorizeUI.a(AppBrandAuthorizeUI.this, AppBrandAuthorizeUI.this.nRu, AppBrandAuthorizeUI.this.nRJ);
                    AppMethodBeat.o(227563);
                } else {
                    AppBrandAuthorizeUI.h(AppBrandAuthorizeUI.this);
                    AppMethodBeat.o(227563);
                }
                return 0;
            }
        }, true, this);
        String str2 = this.nRE ? "1" : this.jyD ? TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL : "2";
        Log.i("MicroMsg.AppBrandAuthorizeUI", "report enter authorize page:%s", str2);
        com.tencent.mm.plugin.appbrand.backgroundrunning.b.a(this.mAppId, this.cxE, System.currentTimeMillis(), 1, str2);
        String str3 = this.mRa;
        c cVar = c.jDh;
        c.c(str3, new kotlin.g.a.b<SubscribeMsgSettingData, x>() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AnonymousClass18 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(SubscribeMsgSettingData subscribeMsgSettingData) {
                AppMethodBeat.i(227579);
                Message.obtain(AppBrandAuthorizeUI.this.nRL, 1, subscribeMsgSettingData).sendToTarget();
                AppMethodBeat.o(227579);
                return null;
            }
        });
        if (bWM()) {
            bWN();
        }
        EventCenter.instance.addListener(this.nRQ);
        AppMethodBeat.o(48554);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(final f fVar, final Preference preference) {
        String decodeString;
        int i2 = 0;
        AppMethodBeat.i(48555);
        Log.d("MicroMsg.AppBrandAuthorizeUI", "onPreferenceTreeClick, key:%s", preference.mKey);
        if (this.nRu == null) {
            Log.w("MicroMsg.AppBrandAuthorizeUI", "onPreferenceTreeClick, authItem is null");
            AppMethodBeat.o(48555);
            return false;
        }
        final String str = preference.mKey;
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.AppBrandAuthorizeUI", "onPreferenceTreeClick, key is null");
            AppMethodBeat.o(48555);
            return false;
        } else if (str.equalsIgnoreCase("scope.userLocation")) {
            if (this.nRy == null || this.nRv == null) {
                Log.i("MicroMsg.AppBrandAuthorizeUI", "onClickLocationPreference, auth item location or attrs is null");
            } else {
                final int bWR = bWR();
                Log.i("MicroMsg.AppBrandAuthorizeUI", "onClickLocationPreference, current location state:%s", Integer.valueOf(bWR));
                mmSetOnActivityResultCallback(new MMActivity.a() {
                    /* class com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AnonymousClass17 */

                    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
                        r0 = r11.getIntExtra("key_result_state", r2);
                     */
                    @Override // com.tencent.mm.ui.MMActivity.a
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void d(int r9, int r10, android.content.Intent r11) {
                        /*
                        // Method dump skipped, instructions count: 103
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AnonymousClass17.d(int, int, android.content.Intent):void");
                    }
                });
                Intent intent = new Intent(this, AppBrandAuthorizeDetailUI.class);
                intent.putExtra("key_title", this.nRy.KKT);
                String str2 = this.mAppId;
                if (Util.isNullOrNil(str2)) {
                    decodeString = null;
                } else {
                    decodeString = MultiProcessMMKV.getMMKV("appbrand_background_config").decodeString(String.format("%s_permission_location_desc", str2), "");
                }
                intent.putExtra("key_desc", decodeString);
                intent.putExtra("key_state", bWR);
                intent.putExtra("key_three_state", this.nRF);
                com.tencent.mm.br.c.b(this, "appbrand", ".ui.AppBrandAuthorizeDetailUI", intent, 1);
                String str3 = this.nRF ? "1" : "2";
                Log.i("MicroMsg.AppBrandAuthorizeUI", "report click location auth item:%s", str3);
                com.tencent.mm.plugin.appbrand.backgroundrunning.b.a(this.mAppId, this.cxE, System.currentTimeMillis(), 2, str3);
            }
            AppMethodBeat.o(48555);
            return false;
        } else if (str.equalsIgnoreCase("scope.userInfo")) {
            if (this.nRA == null) {
                AppMethodBeat.o(48555);
                return true;
            }
            Intent intent2 = new Intent(this, AppBrandUserInfoAuthorizeUI.class);
            intent2.putExtra("key_app_id", this.mAppId);
            intent2.putExtra("key_nickname", com.tencent.mm.model.aa.getDisplayName(this.mRa));
            intent2.putExtra("key_user_info", this.nRK);
            intent2.putExtra("key_is_state_open", this.nRA.state == 1);
            startActivityForResult(intent2, 2);
            AppMethodBeat.o(48555);
            return true;
        } else if ("preference_key_subscribe_msg".equals(str)) {
            Intent intent3 = new Intent(this, BizSubscribeMsgManagerUI.class);
            intent3.putExtra("key_biz_username", this.mRa);
            intent3.putExtra("key_biz_presenter_class", com.tencent.mm.msgsubscription.presenter.d.class.getName());
            intent3.putExtra("key_biz_nickname", com.tencent.mm.model.aa.getDisplayName(this.mRa));
            intent3.putExtra("key_biz_data", this.nRJ);
            startActivityForResult(intent3, 100);
            AppMethodBeat.o(48555);
            return true;
        } else if ("preference_key_notify_msg".equals(str)) {
            final String str4 = this.mAppId;
            final CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
            final LinkedList<fdy> linkedList = new LinkedList<>();
            fdy fdy = new fdy();
            fdy.dNI = str4;
            if (!checkBoxPreference.isChecked()) {
                i2 = 1;
            }
            fdy.status = i2;
            linkedList.add(fdy);
            dwq dwq = new dwq();
            dwq.MeZ = linkedList;
            dwq.scene = 2;
            bWL();
            d.a aVar = com.tencent.mm.modelappbrand.d.iIp;
            aa.a(d.a.a(dwq), new aa.a() {
                /* class com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AnonymousClass7 */

                @Override // com.tencent.mm.ak.aa.a
                public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, com.tencent.mm.ak.q qVar) {
                    AppMethodBeat.i(227566);
                    Log.d("MicroMsg.AppBrandAuthorizeUI", "setReceiveOff errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                    if (i2 == 0 && i3 == 0) {
                        if (((dwr) dVar.iLL.iLR) == null) {
                            Log.e("MicroMsg.AppBrandAuthorizeUI", "setReceiveOff failed, response is null!");
                        }
                        for (int i4 = 0; i4 < linkedList.size(); i4++) {
                            fdy fdy = (fdy) linkedList.get(i4);
                            if (fdy == null) {
                                Log.w("MicroMsg.AppBrandAuthorizeUI", "scene end, item is null");
                            } else {
                                yj yjVar = new yj();
                                yjVar.eeG.appId = str4;
                                yj.a aVar = yjVar.eeG;
                                aVar.dCs = fdy.status == 0;
                                EventCenter.instance.publish(yjVar);
                            }
                        }
                        AppBrandAuthorizeUI.b(AppBrandAuthorizeUI.this);
                        AppMethodBeat.o(227566);
                    } else {
                        AppBrandAuthorizeUI.b(AppBrandAuthorizeUI.this);
                        u.makeText(AppBrandAuthorizeUI.this, AppBrandAuthorizeUI.this.getString(R.string.a3c), 1).show();
                        checkBoxPreference.setChecked(!checkBoxPreference.isChecked());
                        AppMethodBeat.o(227566);
                    }
                    return 0;
                }
            }, true, this);
            AppMethodBeat.o(48555);
            return true;
        } else {
            for (final hj hjVar : this.nRu) {
                if (str.equals(Util.nullAsNil(hjVar.scope))) {
                    this.nRC = true;
                    if (((CheckBoxPreference) preference).isChecked()) {
                        hjVar.state = 1;
                        ArrayList arrayList = new ArrayList(1);
                        arrayList.add(str);
                        a(arrayList, new a() {
                            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AnonymousClass20 */

                            @Override // com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.a
                            public final void dQ(boolean z) {
                                AppMethodBeat.i(227581);
                                AppBrandAuthorizeUI.a(AppBrandAuthorizeUI.this, z, true, preference, fVar, hjVar);
                                AppMethodBeat.o(227581);
                            }
                        });
                    } else if (this.nRD) {
                        this.nRD = false;
                        com.tencent.mm.plugin.appbrand.ui.a.a.a(this, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AnonymousClass21 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(48543);
                                Log.d("MicroMsg.AppBrandAuthorizeUI", "set authItem.state close");
                                hjVar.state = 2;
                                ArrayList arrayList = new ArrayList(1);
                                arrayList.add(str);
                                AppBrandAuthorizeUI.a(AppBrandAuthorizeUI.this, arrayList, new a() {
                                    /* class com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AnonymousClass21.AnonymousClass1 */

                                    @Override // com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.a
                                    public final void dQ(boolean z) {
                                        AppMethodBeat.i(227582);
                                        AppBrandAuthorizeUI.a(AppBrandAuthorizeUI.this, z, false, preference, fVar, hjVar);
                                        AppMethodBeat.o(227582);
                                    }
                                });
                                AppMethodBeat.o(48543);
                            }
                        }, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AnonymousClass22 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(227583);
                                Log.d("MicroMsg.AppBrandAuthorizeUI", "set authItem.state open");
                                hjVar.state = 1;
                                ((CheckBoxPreference) preference).setChecked(true);
                                fVar.notifyDataSetChanged();
                                AppMethodBeat.o(227583);
                            }
                        }, new DialogInterface.OnCancelListener() {
                            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AnonymousClass23 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(227584);
                                Log.d("MicroMsg.AppBrandAuthorizeUI", "on cancel click!");
                                hjVar.state = 1;
                                ((CheckBoxPreference) preference).setChecked(true);
                                fVar.notifyDataSetChanged();
                                AppMethodBeat.o(227584);
                            }
                        });
                    } else {
                        hjVar.state = 2;
                        ArrayList arrayList2 = new ArrayList(1);
                        arrayList2.add(str);
                        a(arrayList2, new a() {
                            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AnonymousClass24 */

                            @Override // com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.a
                            public final void dQ(boolean z) {
                                AppMethodBeat.i(227585);
                                AppBrandAuthorizeUI.a(AppBrandAuthorizeUI.this, z, false, preference, fVar, hjVar);
                                AppMethodBeat.o(227585);
                            }
                        });
                    }
                }
            }
            AppMethodBeat.o(48555);
            return false;
        }
    }

    private void a(final List<String> list, final a aVar) {
        AppMethodBeat.i(227586);
        if (!NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
            u.makeText(this, getString(R.string.a3c), 1).show();
            if (aVar != null) {
                aVar.dQ(false);
            }
            AppMethodBeat.o(227586);
            return;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(227562);
                if (AppBrandAuthorizeUI.this.nRC) {
                    AppBrandAuthorizeUI.this.nRC = false;
                    AppBrandAuthorizeUI.a(AppBrandAuthorizeUI.this, AppBrandAuthorizeUI.this.mAppId, list, aVar);
                }
                AppMethodBeat.o(227562);
            }
        });
        AppMethodBeat.o(227586);
    }

    private void bWL() {
        AppMethodBeat.i(48557);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(48530);
                if (AppBrandAuthorizeUI.this.gxX == null) {
                    AppBrandAuthorizeUI appBrandAuthorizeUI = AppBrandAuthorizeUI.this;
                    AppCompatActivity context = AppBrandAuthorizeUI.this.getContext();
                    AppBrandAuthorizeUI.this.getString(R.string.zb);
                    appBrandAuthorizeUI.gxX = h.a((Context) context, 3, AppBrandAuthorizeUI.this.getString(R.string.a3b), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AnonymousClass4.AnonymousClass1 */

                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                }
                AppMethodBeat.o(48530);
            }
        });
        AppMethodBeat.o(48557);
    }

    private boolean bWM() {
        AppMethodBeat.i(227587);
        boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_appbrand_notify_msg_enable, false);
        Log.i("MicroMsg.AppBrandAuthorizeUI", "showNotifyMsgPreference, isABtestEnable: %b, isStarApp: %b", Boolean.valueOf(a2), Boolean.valueOf(this.nRM));
        if (!this.nRM || !a2) {
            AppMethodBeat.o(227587);
            return false;
        }
        AppMethodBeat.o(227587);
        return true;
    }

    private void bWN() {
        AppMethodBeat.i(227588);
        c.a aVar = com.tencent.mm.modelappbrand.c.iIo;
        aa.a(c.a.aXF(), new aa.a() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AnonymousClass8 */

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, com.tencent.mm.ak.q qVar) {
                boolean z;
                boolean z2 = true;
                AppMethodBeat.i(227567);
                Log.d("MicroMsg.AppBrandAuthorizeUI", "getNotifyMsgInfo errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                if (i2 == 0 && i3 == 0) {
                    bzh bzh = (bzh) dVar.iLL.iLR;
                    fdy fdy = null;
                    if (bzh.MeZ == null) {
                        Log.e("MicroMsg.AppBrandAuthorizeUI", "wxa_msg_config_list not exist");
                        AppMethodBeat.o(227567);
                    } else {
                        Iterator<fdy> it = bzh.MeZ.iterator();
                        while (it.hasNext()) {
                            fdy next = it.next();
                            if (next == null) {
                                Log.w("MicroMsg.AppBrandAuthorizeUI", "scene end, item is null");
                            } else {
                                if (AppBrandAuthorizeUI.this.mAppId.equals(next.dNI)) {
                                    fdy = next;
                                }
                                yj yjVar = new yj();
                                yjVar.eeG.appId = next.dNI;
                                yj.a aVar = yjVar.eeG;
                                if (next.status == 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                aVar.dCs = z;
                                EventCenter.instance.publish(yjVar);
                            }
                        }
                        if (fdy == null) {
                            Log.e("MicroMsg.AppBrandAuthorizeUI", "currentConfigItem not found, appId: %s", AppBrandAuthorizeUI.this.mAppId);
                            AppMethodBeat.o(227567);
                        } else {
                            AppBrandAuthorizeUI.this.nRO = true;
                            AppBrandAuthorizeUI appBrandAuthorizeUI = AppBrandAuthorizeUI.this;
                            if (fdy.status != 0) {
                                z2 = false;
                            }
                            appBrandAuthorizeUI.nRN = z2;
                            AppBrandAuthorizeUI.a(AppBrandAuthorizeUI.this, AppBrandAuthorizeUI.this.nRu, AppBrandAuthorizeUI.this.nRJ);
                            AppMethodBeat.o(227567);
                        }
                    }
                } else {
                    AppMethodBeat.o(227567);
                }
                return 0;
            }
        }, true, this);
        AppMethodBeat.o(227588);
    }

    private void iH(final boolean z) {
        AppMethodBeat.i(48558);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(227569);
                Preference preference = new Preference(AppBrandAuthorizeUI.this);
                preference.OZw = false;
                preference.setKey("preference_key_tip");
                if (z) {
                    preference.setLayoutResource(R.layout.d_);
                    preference.setTitle(AppBrandAuthorizeUI.this.getString(R.string.ij, new Object[]{AppBrandAuthorizeUI.this.nRv.nickname}));
                } else {
                    preference.setLayoutResource(R.layout.da);
                    preference.setTitle(AppBrandAuthorizeUI.this.getString(R.string.ik, new Object[]{AppBrandAuthorizeUI.this.nRv.nickname}));
                }
                AppBrandAuthorizeUI.this.nRm.bmi("preference_key_tip");
                AppBrandAuthorizeUI.this.nRm.c(preference);
                AppBrandAuthorizeUI.this.nRm.notifyDataSetChanged();
                AppMethodBeat.o(227569);
            }
        });
        AppMethodBeat.o(48558);
    }

    private boolean a(List<hj> list, SubscribeMsgSettingData subscribeMsgSettingData, boolean z) {
        AppMethodBeat.i(48559);
        if ((list == null || (list.size() <= 0 && !z)) && (subscribeMsgSettingData == null || !subscribeMsgSettingData.jyp)) {
            Log.e("MicroMsg.AppBrandAuthorizeUI", "authItems is empty");
            iH(true);
            AppMethodBeat.o(48559);
            return true;
        }
        AppMethodBeat.o(48559);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        int i4 = 2;
        AppMethodBeat.i(48560);
        super.onActivityResult(i2, i3, intent);
        if (i2 != 100 || intent == null) {
            if (i2 == 2 && intent != null) {
                if (intent.getBooleanExtra("key_result_is_open", true)) {
                    i4 = 1;
                }
                int intExtra = intent.getIntExtra("key_result_selected_user_id", 0);
                boolean booleanExtra = intent.getBooleanExtra("key_result_user_info_list_been_modified", false);
                if (!(this.nRB == intExtra && this.nRA.state == i4 && !booleanExtra)) {
                    bWL();
                    this.nRC = true;
                    this.nRB = intExtra;
                    this.nRA.state = i4;
                    Log.i("MicroMsg.AppBrandAuthorizeUI", "userinfo select id" + this.nRB);
                    Log.i("MicroMsg.AppBrandAuthorizeUI", "userinfo main switch state" + this.nRA.state);
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add("scope.userInfo");
                    a(arrayList, new a() {
                        /* class com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AnonymousClass13 */

                        @Override // com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.a
                        public final void dQ(boolean z) {
                            AppMethodBeat.i(227572);
                            AppBrandAuthorizeUI.b(AppBrandAuthorizeUI.this);
                            AppMethodBeat.o(227572);
                        }
                    });
                }
            }
            AppMethodBeat.o(48560);
            return;
        }
        SubscribeMsgSettingData subscribeMsgSettingData = (SubscribeMsgSettingData) intent.getParcelableExtra("key_biz_data");
        if (subscribeMsgSettingData != null) {
            com.tencent.mm.msgsubscription.util.c cVar = com.tencent.mm.msgsubscription.util.c.jDh;
            com.tencent.mm.msgsubscription.util.c.a(this.mRa, subscribeMsgSettingData, new kotlin.g.a.b<SubscribeMsgRequestResult, x>() {
                /* class com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AnonymousClass14 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(SubscribeMsgRequestResult subscribeMsgRequestResult) {
                    AppMethodBeat.i(227573);
                    Message.obtain(AppBrandAuthorizeUI.this.nRL, 2, subscribeMsgRequestResult).sendToTarget();
                    AppMethodBeat.o(227573);
                    return null;
                }
            });
            bWL();
        }
        AppMethodBeat.o(48560);
    }

    private static boolean bR(List<hj> list) {
        AppMethodBeat.i(48562);
        if (list != null) {
            for (hj hjVar : list) {
                if (!Util.isNullOrNil(hjVar.scope) && hjVar.scope.equalsIgnoreCase("scope.userLocationBackground")) {
                    AppMethodBeat.o(48562);
                    return true;
                }
            }
        }
        AppMethodBeat.o(48562);
        return false;
    }

    private void a(final IconPreference iconPreference, hj hjVar) {
        AppMethodBeat.i(180380);
        this.nRA = hjVar;
        if (this.nRA.KKU == null) {
            AppMethodBeat.o(180380);
            return;
        }
        this.nRB = this.nRA.KKU.lHH;
        iconPreference.lb(com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 40), com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 40));
        iconPreference.OZw = false;
        iconPreference.setKey(this.nRA.scope);
        iconPreference.setTitle(this.nRA.KKT);
        this.nRK = new MMUserAvatarInfo(this.nRA.KKU);
        if (this.nRA.state == 2) {
            iconPreference.setSummary(R.string.j0);
            iconPreference.aL(null);
            iconPreference.alH(8);
            AppMethodBeat.o(180380);
            return;
        }
        iconPreference.setSummary("");
        iconPreference.alG(R.drawable.cg_);
        iconPreference.alH(0);
        Log.i("MicroMsg.AppBrandAuthorizeUI", "userinfo default_avatar_id = " + this.nRA.KKU.lHH);
        Iterator<eor> it = this.nRA.KKU.Mzx.iterator();
        while (it.hasNext()) {
            eor next = it.next();
            Log.i("MicroMsg.AppBrandAuthorizeUI", "userinfo list avatar id = " + next.id);
            if (this.nRA.KKU.lHH == next.id) {
                com.tencent.mm.modelappbrand.a.b.aXY().a(new b.k() {
                    /* class com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AnonymousClass15 */

                    @Override // com.tencent.mm.modelappbrand.a.b.k
                    public final void aYg() {
                    }

                    @Override // com.tencent.mm.modelappbrand.a.b.k
                    public final void I(final Bitmap bitmap) {
                        AppMethodBeat.i(227575);
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AnonymousClass15.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(227574);
                                iconPreference.aL(bitmap);
                                iconPreference.alH(0);
                                AppMethodBeat.o(227574);
                            }
                        });
                        AppMethodBeat.o(227575);
                    }

                    @Override // com.tencent.mm.modelappbrand.a.b.k
                    public final void oD() {
                    }

                    @Override // com.tencent.mm.modelappbrand.a.b.k, com.tencent.mm.modelappbrand.a.c
                    public final String Lb() {
                        return null;
                    }
                }, next.lHM, new b.h() {
                    /* class com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AnonymousClass16 */

                    @Override // com.tencent.mm.modelappbrand.a.c
                    public final String Lb() {
                        return "setting_wxa_user_info_icon";
                    }

                    @Override // com.tencent.mm.modelappbrand.a.b.h
                    public final Bitmap J(Bitmap bitmap) {
                        AppMethodBeat.i(227576);
                        Bitmap roundedCornerBitmap = BitmapUtil.getRoundedCornerBitmap(bitmap, false, (float) com.tencent.mm.cb.a.fromDPToPix((Context) AppBrandAuthorizeUI.this.getContext(), 4), false);
                        AppMethodBeat.o(227576);
                        return roundedCornerBitmap;
                    }
                });
                AppMethodBeat.o(180380);
                return;
            }
        }
        AppMethodBeat.o(180380);
    }

    private void bWO() {
        AppMethodBeat.i(48563);
        if (this.nRz == null) {
            Log.i("MicroMsg.AppBrandAuthorizeUI", "create AuthItemLocationBackground");
            this.nRz = new hj();
            this.nRz.state = 2;
            this.nRz.scope = "scope.userLocationBackground";
            this.nRz.KKT = getString(R.string.iw);
            this.nRu.add(this.nRz);
        }
        AppMethodBeat.o(48563);
    }

    private void bWP() {
        AppMethodBeat.i(48564);
        if (this.nRy == null) {
            Log.i("MicroMsg.AppBrandAuthorizeUI", "create AuthItemLocation");
            this.nRy = new hj();
            this.nRy.state = 2;
            this.nRy.scope = "scope.userLocation";
            this.nRy.KKT = getString(R.string.iw);
            this.nRu.add(this.nRy);
        }
        AppMethodBeat.o(48564);
    }

    private void bWQ() {
        AppMethodBeat.i(48565);
        if (this.nRw == null) {
            AppMethodBeat.o(48565);
            return;
        }
        switch (bWR()) {
            case 1:
                this.nRw.setSummary(R.string.iz);
                AppMethodBeat.o(48565);
                return;
            case 2:
                this.nRw.setSummary(R.string.iy);
                AppMethodBeat.o(48565);
                return;
            default:
                this.nRw.setSummary(R.string.j0);
                AppMethodBeat.o(48565);
                return;
        }
    }

    private int bWR() {
        boolean z;
        boolean z2;
        if (this.nRy == null || this.nRy.state != 1) {
            z = true;
        } else {
            z = true;
        }
        if (z) {
            return 0;
        }
        if (this.nRz == null || this.nRz.state != 1) {
            z2 = true;
        } else {
            z2 = true;
        }
        return !z2 ? 2 : 1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(227589);
        super.onResume();
        if (this.nRP) {
            this.nRP = false;
            AppMethodBeat.o(227589);
            return;
        }
        this.nRM = n.buK().bj(this.mRa, this.cxE);
        if (bWM() || this.nRm == null || this.nRm.bmg("preference_key_notify_msg") == null) {
            if (bWM() && this.nRm != null && this.nRm.bmg("preference_key_notify_msg") == null) {
                bWN();
            }
            AppMethodBeat.o(227589);
            return;
        }
        this.nRm.bmi("preference_key_notify_msg");
        AppMethodBeat.o(227589);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(48566);
        if (this.nRC) {
            Log.d("MicroMsg.AppBrandAuthorizeUI", "onPause, key changed!");
        }
        super.onPause();
        AppMethodBeat.o(48566);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(227590);
        super.onDestroy();
        EventCenter.instance.removeListener(this.nRQ);
        AppMethodBeat.o(227590);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(48567);
        bWK();
        super.onBackPressed();
        AppMethodBeat.o(48567);
    }

    private void bWK() {
        AppMethodBeat.i(48568);
        if (!this.nRE) {
            AppMethodBeat.o(48568);
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (hj hjVar : this.nRu) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("scope", hjVar.scope);
                jSONObject.put("state", hjVar.state);
                jSONObject.put("desc", hjVar.KKT);
                jSONArray.put(jSONObject);
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandAuthorizeUI", e2, "", new Object[0]);
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        if (this.nRJ != null) {
            try {
                jSONObject2.put("mainSwitch", this.nRJ.iQD);
                JSONArray jSONArray2 = new JSONArray();
                for (SubscribeMsgTmpItem subscribeMsgTmpItem : this.nRJ.iHf) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("title", subscribeMsgTmpItem.title);
                    jSONObject3.put("templateId", subscribeMsgTmpItem.ixM);
                    jSONObject3.put("templateType", subscribeMsgTmpItem.jyz);
                    jSONObject3.put("status", c(subscribeMsgTmpItem));
                    jSONObject3.put("tid", subscribeMsgTmpItem.tid);
                    jSONArray2.put(jSONObject3);
                }
                jSONObject2.put("templatesInfo", jSONArray2);
            } catch (JSONException e3) {
                Log.printErrStackTrace("MicroMsg.AppBrandAuthorizeUI", e3, "", new Object[0]);
            }
        }
        Log.i("MicroMsg.AppBrandAuthorizeUI", "setResData, authInfo:%s", jSONArray);
        Log.i("MicroMsg.AppBrandAuthorizeUI", "setResData, subscriptionsSetting:%s", jSONObject2);
        Intent intent = new Intent();
        intent.putExtra("key_app_authorize_state", jSONArray.toString());
        intent.putExtra("key_app_subscriptions_setting", jSONObject2.toString());
        setResult(-1, intent);
        AppMethodBeat.o(48568);
    }

    private static int c(SubscribeMsgTmpItem subscribeMsgTmpItem) {
        if (subscribeMsgTmpItem.jyF) {
            return -1;
        }
        if (subscribeMsgTmpItem.jyB == 1 || subscribeMsgTmpItem.jyB != 0) {
            return 1;
        }
        return 0;
    }

    public static final class AuthStateChangedByUserEvent implements Parcelable {
        public static final Parcelable.Creator<AuthStateChangedByUserEvent> CREATOR = new Parcelable.Creator<AuthStateChangedByUserEvent>() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AuthStateChangedByUserEvent.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ AuthStateChangedByUserEvent[] newArray(int i2) {
                return new AuthStateChangedByUserEvent[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ AuthStateChangedByUserEvent createFromParcel(Parcel parcel) {
                AppMethodBeat.i(48547);
                AuthStateChangedByUserEvent authStateChangedByUserEvent = new AuthStateChangedByUserEvent(parcel);
                AppMethodBeat.o(48547);
                return authStateChangedByUserEvent;
            }
        };
        public boolean nSk;
        public boolean nSl;

        public AuthStateChangedByUserEvent() {
            this.nSk = false;
            this.nSl = false;
        }

        protected AuthStateChangedByUserEvent(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(48548);
            if (parcel.readByte() != 0) {
                z = true;
            } else {
                z = false;
            }
            this.nSk = z;
            this.nSl = parcel.readByte() == 0 ? false : z2;
            AppMethodBeat.o(48548);
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            int i3;
            int i4 = 1;
            AppMethodBeat.i(48549);
            if (this.nSk) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            parcel.writeByte((byte) i3);
            if (!this.nSl) {
                i4 = 0;
            }
            parcel.writeByte((byte) i4);
            AppMethodBeat.o(48549);
        }

        public final int describeContents() {
            return 0;
        }

        static {
            AppMethodBeat.i(48550);
            AppMethodBeat.o(48550);
        }
    }

    private static boolean i(String str, List<hj> list) {
        boolean decodeBool;
        AppMethodBeat.i(48561);
        if (Util.isNullOrNil(str)) {
            decodeBool = false;
        } else {
            decodeBool = MultiProcessMMKV.getMMKV("appbrand_background_config").decodeBool(String.format("%s_location_background_required", str), false);
        }
        if (decodeBool) {
            AppMethodBeat.o(48561);
            return true;
        } else if (bR(list)) {
            AppMethodBeat.o(48561);
            return true;
        } else {
            AppMethodBeat.o(48561);
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005f, code lost:
        if (r0 != false) goto L_0x0067;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI r5, final java.util.List r6, final com.tencent.mm.msgsubscription.presenter.SubscribeMsgSettingData r7) {
        /*
        // Method dump skipped, instructions count: 120
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.a(com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI, java.util.List, com.tencent.mm.msgsubscription.presenter.SubscribeMsgSettingData):void");
    }

    static /* synthetic */ void b(AppBrandAuthorizeUI appBrandAuthorizeUI) {
        AppMethodBeat.i(48570);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(227564);
                if (AppBrandAuthorizeUI.this.gxX != null && AppBrandAuthorizeUI.this.gxX.isShowing()) {
                    AppBrandAuthorizeUI.this.gxX.dismiss();
                    AppBrandAuthorizeUI.this.gxX = null;
                }
                AppMethodBeat.o(227564);
            }
        });
        AppMethodBeat.o(48570);
    }

    static /* synthetic */ void a(AppBrandAuthorizeUI appBrandAuthorizeUI, final boolean z, final boolean z2, final Preference preference, final f fVar, final hj hjVar) {
        AppMethodBeat.i(48574);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AnonymousClass19 */

            public final void run() {
                int i2 = 1;
                AppMethodBeat.i(227580);
                if (z) {
                    ((CheckBoxPreference) preference).setChecked(z2);
                    hjVar.state = z2 ? 1 : 2;
                    fVar.notifyDataSetChanged();
                    AppMethodBeat.o(227580);
                    return;
                }
                ((CheckBoxPreference) preference).setChecked(!z2);
                hj hjVar = hjVar;
                if (z2) {
                    i2 = 2;
                }
                hjVar.state = i2;
                fVar.notifyDataSetChanged();
                AppMethodBeat.o(227580);
            }
        });
        AppMethodBeat.o(48574);
    }

    static /* synthetic */ void a(AppBrandAuthorizeUI appBrandAuthorizeUI, String str, List list, final a aVar) {
        AppMethodBeat.i(227592);
        LinkedList<cpc> linkedList = new LinkedList<>();
        int bWR = appBrandAuthorizeUI.bWR();
        for (hj hjVar : appBrandAuthorizeUI.nRu) {
            if (list.contains(hjVar.scope)) {
                Log.i("MicroMsg.AppBrandAuthorizeUI", "setAuthState scope=%s", hjVar.scope);
                if (appBrandAuthorizeUI.nRG || !appBrandAuthorizeUI.nRF || !hjVar.scope.equals("scope.userLocationBackground") || bWR == 2) {
                    cpc cpc = new cpc();
                    if (hjVar.scope.equals("scope.userInfo")) {
                        cpc.Mvc = appBrandAuthorizeUI.nRB;
                    }
                    cpc.CXO = hjVar.scope;
                    cpc.CXP = hjVar.state;
                    linkedList.add(cpc);
                }
            }
        }
        d.a aVar2 = new d.a();
        aVar2.iLN = new fco();
        aVar2.iLO = new fcp();
        aVar2.uri = "/cgi-bin/mmbiz-bin/wxaapp_modauth";
        aVar2.funcId = 1188;
        aVar2.iLP = 0;
        aVar2.respCmdId = 0;
        fco fco = new fco();
        fco.appId = str;
        fco.Nyv = linkedList;
        aVar2.iLN = fco;
        appBrandAuthorizeUI.bWL();
        aa.a(aVar2.aXF(), new aa.a() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AnonymousClass6 */

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, com.tencent.mm.ak.q qVar) {
                boolean z;
                AppMethodBeat.i(227565);
                Log.d("MicroMsg.AppBrandAuthorizeUI", "WxaAppModAuthReq errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                if (i2 == 0 && i3 == 0) {
                    fcp fcp = (fcp) dVar.iLL.iLR;
                    if (fcp == null) {
                        Log.e("MicroMsg.AppBrandAuthorizeUI", "WxaAppModAuthReq failed, response is null!");
                        z = false;
                    } else {
                        int i4 = fcp.Nyd.errCode;
                        String str2 = fcp.Nyd.errMsg;
                        if (i4 == 0) {
                            Log.d("MicroMsg.AppBrandAuthorizeUI", "WxaAppModAuthReq OK!");
                            AppBrandAuthorizeUI.a(AppBrandAuthorizeUI.this, fcp);
                            AppBrandAuthorizeUI.a(AppBrandAuthorizeUI.this, AppBrandAuthorizeUI.this.nRu);
                            AppBrandAuthorizeUI.b(AppBrandAuthorizeUI.this, AppBrandAuthorizeUI.this.nRu);
                            if (!AppBrandAuthorizeUI.b(AppBrandAuthorizeUI.this, fcp)) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (!z) {
                                Log.i("MicroMsg.AppBrandAuthorizeUI", "Risk Intercepted!");
                            }
                        } else {
                            Log.e("MicroMsg.AppBrandAuthorizeUI", "WxaAppModAuthReq error %s", str2);
                            z = false;
                        }
                    }
                    AppBrandAuthorizeUI.b(AppBrandAuthorizeUI.this);
                    if (aVar != null) {
                        aVar.dQ(z);
                    }
                    AppMethodBeat.o(227565);
                } else {
                    AppBrandAuthorizeUI.b(AppBrandAuthorizeUI.this);
                    u.makeText(AppBrandAuthorizeUI.this, AppBrandAuthorizeUI.this.getString(R.string.a3c), 1).show();
                    if (aVar != null) {
                        aVar.dQ(false);
                    }
                    AppMethodBeat.o(227565);
                }
                return 0;
            }
        }, true, appBrandAuthorizeUI);
        AppMethodBeat.o(227592);
    }

    static /* synthetic */ void a(AppBrandAuthorizeUI appBrandAuthorizeUI, fcp fcp) {
        int i2;
        AppMethodBeat.i(180381);
        if (fcp.Nye == null || fcp.Nye.size() <= 0) {
            AppMethodBeat.o(180381);
            return;
        }
        Iterator<hj> it = fcp.Nye.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            final hj next = it.next();
            if ("scope.userInfo".equals(next.scope)) {
                int i3 = 0;
                while (true) {
                    i2 = i3;
                    if (i2 >= appBrandAuthorizeUI.nRu.size()) {
                        i2 = -1;
                        break;
                    } else if ("scope.userInfo".equals(appBrandAuthorizeUI.nRu.get(i2).scope)) {
                        break;
                    } else {
                        i3 = i2 + 1;
                    }
                }
                if (i2 != -1) {
                    appBrandAuthorizeUI.nRu.remove(i2);
                    appBrandAuthorizeUI.nRu.add(i2, next);
                } else {
                    appBrandAuthorizeUI.nRu.add(next);
                }
                appBrandAuthorizeUI.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AnonymousClass9 */

                    public final void run() {
                        AppMethodBeat.i(227568);
                        AppBrandAuthorizeUI.a(AppBrandAuthorizeUI.this, AppBrandAuthorizeUI.this.nRx, next);
                        AppBrandAuthorizeUI.this.nRm.notifyDataSetChanged();
                        AppMethodBeat.o(227568);
                    }
                });
            }
        }
        AppMethodBeat.o(180381);
    }

    static /* synthetic */ void a(AppBrandAuthorizeUI appBrandAuthorizeUI, List list) {
        AppMethodBeat.i(48580);
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                hj hjVar = (hj) list.get(i2);
                if ("scope.subscribemsg".equals(hjVar.scope)) {
                    boolean z = hjVar.state == 2;
                    yw ywVar = new yw();
                    ywVar.efe.dCl = appBrandAuthorizeUI.mRa;
                    yw.a aVar = ywVar.efe;
                    aVar.action = z ? 1 : 2;
                    ywVar.efe.option = 1;
                    EventCenter.instance.publish(ywVar);
                    Log.i("MicroMsg.AppBrandAuthorizeUI", "updateSubscribeMsgItem banMsg:%b", Boolean.valueOf(z));
                    AppMethodBeat.o(48580);
                    return;
                }
            }
        }
        AppMethodBeat.o(48580);
    }

    static /* synthetic */ void b(AppBrandAuthorizeUI appBrandAuthorizeUI, List list) {
        boolean z;
        AppMethodBeat.i(180382);
        Iterator it = list.iterator();
        boolean z2 = false;
        boolean z3 = false;
        while (it.hasNext()) {
            hj hjVar = (hj) it.next();
            if (Util.isNullOrNil(hjVar.scope) || !hjVar.scope.equalsIgnoreCase("scope.userLocation")) {
                if (Util.isNullOrNil(hjVar.scope) || !hjVar.scope.equalsIgnoreCase("scope.userLocationBackground")) {
                    z = z2;
                } else if (hjVar.state == 1) {
                    z = true;
                } else {
                    z = false;
                }
                z2 = z;
            } else {
                z3 = hjVar.state == 1;
            }
        }
        AuthStateChangedByUserEvent authStateChangedByUserEvent = new AuthStateChangedByUserEvent();
        authStateChangedByUserEvent.nSk = z3;
        authStateChangedByUserEvent.nSl = z2;
        e.b(appBrandAuthorizeUI.mAppId, authStateChangedByUserEvent);
        AppMethodBeat.o(180382);
    }

    static /* synthetic */ boolean b(AppBrandAuthorizeUI appBrandAuthorizeUI, fcp fcp) {
        AppMethodBeat.i(227593);
        Iterator<hj> it = fcp.Nye.iterator();
        while (it.hasNext()) {
            drd drd = it.next().KKW;
            if (drd != null) {
                com.tencent.mm.plugin.appbrand.jsapi.auth.h.a(appBrandAuthorizeUI.getContext(), drd.MTL.yO(), drd.MTN.yO(), drd.MTM.yO(), h.b.a(appBrandAuthorizeUI.getContext(), new MMAuthScopeRiskInfo(drd)), null);
                AppMethodBeat.o(227593);
                return true;
            }
        }
        AppMethodBeat.o(227593);
        return false;
    }

    static /* synthetic */ void b(AppBrandAuthorizeUI appBrandAuthorizeUI, List list, SubscribeMsgSettingData subscribeMsgSettingData) {
        String string;
        AppMethodBeat.i(227595);
        Log.i("MicroMsg.AppBrandAuthorizeUI", "updatePreferencesInternal, authItems size = %d", Integer.valueOf(list.size()));
        HashMap hashMap = new HashMap();
        if (subscribeMsgSettingData != null && subscribeMsgSettingData.jyp) {
            Preference preference = new Preference(appBrandAuthorizeUI);
            preference.OZw = false;
            preference.setKey("preference_key_subscribe_msg");
            preference.setTitle(appBrandAuthorizeUI.getContext().getString(R.string.a3r));
            if (subscribeMsgSettingData.iQD) {
                string = "";
            } else {
                string = appBrandAuthorizeUI.getContext().getString(R.string.a3s);
            }
            preference.setSummary(string);
            hashMap.put(preference.mKey, preference);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            hj hjVar = (hj) it.next();
            Log.i("MicroMsg.AppBrandAuthorizeUI", "updatePreferencesInternal, find scope:%s, state:%d", hjVar.scope, Integer.valueOf(hjVar.state));
            if (!Util.isNullOrNil(hjVar.scope) && hjVar.scope.equalsIgnoreCase("scope.userLocationBackground")) {
                appBrandAuthorizeUI.nRz = hjVar;
            } else if (!Util.isNullOrNil(hjVar.scope) && hjVar.scope.equalsIgnoreCase("scope.userLocation")) {
                appBrandAuthorizeUI.nRy = hjVar;
                appBrandAuthorizeUI.nRw = new Preference(appBrandAuthorizeUI);
                appBrandAuthorizeUI.nRw.OZw = false;
                appBrandAuthorizeUI.nRw.setKey(hjVar.scope);
                appBrandAuthorizeUI.nRw.setSummary(hjVar.KKV);
                appBrandAuthorizeUI.nRw.setTitle(hjVar.KKT);
                hashMap.put(appBrandAuthorizeUI.nRw.mKey, appBrandAuthorizeUI.nRw);
            } else if (Util.isNullOrNil(hjVar.scope) || !hjVar.scope.equalsIgnoreCase("scope.userInfo")) {
                CheckBoxPreference checkBoxPreference = new CheckBoxPreference(appBrandAuthorizeUI);
                checkBoxPreference.OZw = false;
                checkBoxPreference.setKey(hjVar.scope);
                checkBoxPreference.setTitle(hjVar.KKT);
                checkBoxPreference.setSummary(hjVar.KKV);
                checkBoxPreference.setChecked(hjVar.state == 1);
                hashMap.put(checkBoxPreference.mKey, checkBoxPreference);
            } else {
                if (appBrandAuthorizeUI.nRx == null) {
                    appBrandAuthorizeUI.nRx = new IconPreference(appBrandAuthorizeUI);
                }
                if (hjVar.KKU == null) {
                    Log.i("MicroMsg.AppBrandAuthorizeUI", "scope userinfo's UserAvatarInfo is null, can not be add into Preference");
                } else {
                    appBrandAuthorizeUI.nRx.OZw = false;
                    appBrandAuthorizeUI.a(appBrandAuthorizeUI.nRx, hjVar);
                    hashMap.put(appBrandAuthorizeUI.nRx.mKey, appBrandAuthorizeUI.nRx);
                }
            }
        }
        if (appBrandAuthorizeUI.bWM()) {
            CheckBoxPreference checkBoxPreference2 = new CheckBoxPreference(appBrandAuthorizeUI);
            checkBoxPreference2.OZw = false;
            checkBoxPreference2.setKey("preference_key_notify_msg");
            checkBoxPreference2.setChecked(appBrandAuthorizeUI.nRN);
            checkBoxPreference2.setTitle(appBrandAuthorizeUI.getContext().getString(R.string.a2d));
            hashMap.put(checkBoxPreference2.mKey, checkBoxPreference2);
        }
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        for (Preference preference2 : hashMap.values()) {
            if (Arrays.asList(nRt).contains(preference2.mKey)) {
                hashMap4.put(preference2.mKey, preference2);
            } else if (Arrays.asList(nRs).contains(preference2.mKey)) {
                hashMap2.put(preference2.mKey, preference2);
            } else {
                hashMap3.put(preference2.mKey, preference2);
            }
        }
        for (String str : nRs) {
            Preference preference3 = (Preference) hashMap2.get(str);
            if (preference3 != null) {
                appBrandAuthorizeUI.nRm.c(preference3);
            }
        }
        for (Preference preference4 : hashMap3.values()) {
            appBrandAuthorizeUI.nRm.c(preference4);
        }
        if (hashMap4.size() > 0) {
            appBrandAuthorizeUI.nRm.c(new PreferenceSmallCategory(appBrandAuthorizeUI.getContext()));
        }
        for (String str2 : nRt) {
            Preference preference5 = (Preference) hashMap4.get(str2);
            if (preference5 != null) {
                appBrandAuthorizeUI.nRm.c(preference5);
            }
        }
        appBrandAuthorizeUI.bWQ();
        appBrandAuthorizeUI.nRm.notifyDataSetChanged();
        AppMethodBeat.o(227595);
    }

    static /* synthetic */ void a(AppBrandAuthorizeUI appBrandAuthorizeUI, int i2) {
        AppMethodBeat.i(227596);
        Log.i("MicroMsg.AppBrandAuthorizeUI", "updateLocationAuthState, state:%d", Integer.valueOf(i2));
        appBrandAuthorizeUI.bWP();
        appBrandAuthorizeUI.bWO();
        if (i2 == 2) {
            if (appBrandAuthorizeUI.nRz != null) {
                appBrandAuthorizeUI.nRz.state = 1;
            }
            if (appBrandAuthorizeUI.nRy != null) {
                appBrandAuthorizeUI.nRy.state = 1;
                AppMethodBeat.o(227596);
                return;
            }
        } else if (i2 == 1) {
            if (appBrandAuthorizeUI.nRy != null) {
                appBrandAuthorizeUI.nRy.state = 1;
            }
            if (appBrandAuthorizeUI.nRz != null) {
                appBrandAuthorizeUI.nRz.state = 2;
                AppMethodBeat.o(227596);
                return;
            }
        } else {
            if (appBrandAuthorizeUI.nRy != null) {
                appBrandAuthorizeUI.nRy.state = 2;
            }
            if (appBrandAuthorizeUI.nRz != null) {
                appBrandAuthorizeUI.nRz.state = 2;
            }
        }
        AppMethodBeat.o(227596);
    }

    static /* synthetic */ void m(AppBrandAuthorizeUI appBrandAuthorizeUI) {
        AppMethodBeat.i(227597);
        Log.i("MicroMsg.AppBrandAuthorizeUI", "report click location background auth state");
        com.tencent.mm.plugin.appbrand.backgroundrunning.b.a(appBrandAuthorizeUI.mAppId, appBrandAuthorizeUI.cxE, System.currentTimeMillis(), 3, "");
        AppMethodBeat.o(227597);
    }
}
