package com.tencent.mm.plugin.sns.e;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.a.c;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.h;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.z;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.ui.widget.a.e;
import java.lang.ref.WeakReference;

public final class b {
    public volatile boolean DDe = false;
    public Context mContext;
    q nUi = null;
    public e oXS;

    public b() {
        AppMethodBeat.i(179077);
        AppMethodBeat.o(179077);
    }

    public static View a(Context context, ADXml.AdCardActionBtnInfo adCardActionBtnInfo, SnsInfo snsInfo, bv bvVar) {
        AppMethodBeat.i(202578);
        View inflate = LayoutInflater.from(context).inflate(R.layout.bvb, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.jk0);
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) inflate.findViewById(R.id.jjz);
        TextView textView2 = (TextView) inflate.findViewById(R.id.idr);
        if (adCardActionBtnInfo == null || snsInfo == null) {
            try {
                Log.e("HalfScreenSubscribeUtils", "adCardActionBtnInfo == null || snsInfo == null");
            } catch (Throwable th) {
                Log.e("HalfScreenSubscribeUtils", th.toString());
            }
        } else {
            if (Util.isNullOrNil(adCardActionBtnInfo.subscribeNickname)) {
                String userName = snsInfo.getUserName();
                if (!Util.isNullOrNil(userName)) {
                    as bjK = bvVar.bjK(userName);
                    if (bjK != null) {
                        userName = bjK.arJ();
                    }
                    if (snsInfo.isAd()) {
                        ADXml adXml = snsInfo.getAdXml();
                        if (adXml.usePreferedInfo) {
                            userName = adXml.preferNickName;
                        } else if (Util.isNullOrNil(userName) && !Util.isNullOrNil(adXml.nickname)) {
                            userName = adXml.nickname;
                        }
                        adCardActionBtnInfo.subscribeNickname = userName;
                    }
                }
            }
            if (Util.isNullOrNil(adCardActionBtnInfo.subscribeHeadImg)) {
                a.b.c(roundCornerImageView, snsInfo.getUserName());
            } else {
                String str = adCardActionBtnInfo.subscribeHeadImg;
                if (!TextUtils.equals((String) roundCornerImageView.getTag(R.id.hwe), str)) {
                    roundCornerImageView.setImageDrawable(null);
                    c.k(str, roundCornerImageView);
                }
            }
        }
        textView.setText(adCardActionBtnInfo.subscribeNickname);
        textView2.setText(adCardActionBtnInfo.subscribeTitle);
        ((TextView) inflate.findViewById(R.id.idk)).setText(adCardActionBtnInfo.subscribeContent);
        ((Button) inflate.findViewById(R.id.idg)).setText(adCardActionBtnInfo.subscribeSubmitBtnTitle);
        AppMethodBeat.o(202578);
        return inflate;
    }

    public static class a implements i {
        private WeakReference<b> DDn;
        av.a DDo;
        private SnsInfo DsC;
        private int DxM;
        ADXml.AdCardActionBtnInfo adCardActionBtnInfo;

        public a(b bVar, ADXml.AdCardActionBtnInfo adCardActionBtnInfo2, SnsInfo snsInfo, int i2, av.a aVar) {
            AppMethodBeat.i(202576);
            this.DDn = new WeakReference<>(bVar);
            this.adCardActionBtnInfo = adCardActionBtnInfo2;
            this.DsC = snsInfo;
            this.DxM = i2;
            this.DDo = aVar;
            AppMethodBeat.o(202576);
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            AppMethodBeat.i(202577);
            Log.i("HalfSubscribeController", "onSceneEnd errType %d,errCode %d,errMsg %s,scene %s", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(qVar.getType()));
            try {
                if (qVar instanceof h) {
                    if (this.DDn == null || this.DDn.get() == null) {
                        g.azz().b(qVar.getType(), this);
                        AppMethodBeat.o(202577);
                        return;
                    }
                    final b bVar = this.DDn.get();
                    bVar.DDe = true;
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.e.b.a.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(202573);
                            if (bVar.nUi != null) {
                                bVar.nUi.dismiss();
                                bVar.nUi = null;
                            }
                            if (bVar.oXS != null && bVar.oXS.isShowing()) {
                                Log.i("HalfSubscribeController", "mmBottomSheet tryHide due to send subscribe");
                                bVar.oXS.bMo();
                            }
                            AppMethodBeat.o(202573);
                        }
                    });
                    final Context context = bVar.mContext;
                    if (i2 == 0 && i3 == 0) {
                        Log.i("HalfSubscribeController", "subscribe is success");
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.sns.e.b.a.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(202574);
                                try {
                                    a.this.DDo.a(a.this.adCardActionBtnInfo);
                                    if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                                        u.cG(context, a.this.adCardActionBtnInfo.subscribeSucTip);
                                    }
                                    AppMethodBeat.o(202574);
                                } catch (Throwable th) {
                                    Log.e("HalfSubscribeController", th.toString());
                                    AppMethodBeat.o(202574);
                                }
                            }
                        });
                        String Jb = r.Jb(this.DsC.field_snsId);
                        try {
                            g.aAf();
                            String ayV = com.tencent.mm.kernel.a.ayV();
                            if (Util.isNullOrNil(Jb, ayV)) {
                                Log.e("StorageHelper", "HalfScreenSubscribe, snsId or uin is empty");
                            } else {
                                StringBuilder sb = new StringBuilder();
                                if (Util.isNullOrNil(Jb)) {
                                    Jb = "";
                                }
                                sb.append(Jb);
                                if (Util.isNullOrNil(ayV)) {
                                    ayV = "";
                                }
                                sb.append(ayV);
                                if (sb.length() <= 0) {
                                    Log.e("StorageHelper", "HalfScreenSubscribe, key is empty");
                                } else {
                                    String sb2 = sb.toString();
                                    SharedPreferences.Editor edit = MMApplicationContext.getContext().getSharedPreferences("SnsAdVoteSubscribe", 0).edit();
                                    edit.putString(sb2, "1");
                                    edit.commit();
                                    Log.i("StorageHelper", "HalfScreenSubscribe, key = " + sb2 + ", isSubscribe=" + "1");
                                }
                            }
                        } catch (Throwable th) {
                            Log.e("StorageHelper", th.toString());
                        }
                        c.a(this.DsC, this.DxM, new z(this.adCardActionBtnInfo.tempId, this.adCardActionBtnInfo.weappUserName, 1, 0));
                    } else {
                        Log.e("HalfSubscribeController", "subscribe is failed");
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.sns.e.b.a.AnonymousClass3 */

                            public final void run() {
                                AppMethodBeat.i(202575);
                                try {
                                    if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                                        u.cH(context, a.this.adCardActionBtnInfo.subscribeFailedTip);
                                    }
                                    AppMethodBeat.o(202575);
                                } catch (Throwable th) {
                                    Log.e("HalfSubscribeController", th.toString());
                                    AppMethodBeat.o(202575);
                                }
                            }
                        });
                        c.a(this.DsC, this.DxM, new z(this.adCardActionBtnInfo.tempId, this.adCardActionBtnInfo.weappUserName, 1, -3));
                    }
                    g.azz().b(qVar.getType(), this);
                }
                AppMethodBeat.o(202577);
            } catch (Throwable th2) {
                Log.e("HalfSubscribeController", th2.toString());
                AppMethodBeat.o(202577);
            }
        }
    }
}
