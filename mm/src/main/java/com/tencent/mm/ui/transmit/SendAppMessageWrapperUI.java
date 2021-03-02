package com.tencent.mm.ui.transmit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.WXDynamicVideoMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXEnterpriseCardObject;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXGameVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXWeWorkObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.comm.b;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.protocal.protobuf.fci;
import com.tencent.mm.protocal.protobuf.fcj;
import com.tencent.mm.protocal.protobuf.fcr;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.transmit.d;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.vfs.s;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.xweb.util.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

@a(3)
public class SendAppMessageWrapperUI extends MMActivity {
    private boolean QAa = false;
    private boolean QAb = false;
    private boolean QAc = false;
    private String QAd = "";
    private g QzY = null;
    private boolean QzZ = false;
    private String Rcb;
    private WXMediaMessage pez = null;
    private String pkgName = "";
    private int scene = 0;
    private int sdkVersion = 0;
    private String source = null;
    private MTimerHandler timer = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.ui.transmit.SendAppMessageWrapperUI.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(39415);
            if (SendAppMessageWrapperUI.this.getWindow() != null && SendAppMessageWrapperUI.this.getWindow().getDecorView() != null && SendAppMessageWrapperUI.this.getWindow().getDecorView().getWindowToken() != null) {
                SendAppMessageWrapperUI.c(SendAppMessageWrapperUI.this);
                AppMethodBeat.o(39415);
                return false;
            } else if (SendAppMessageWrapperUI.this.tnt < 10) {
                SendAppMessageWrapperUI.b(SendAppMessageWrapperUI.this);
                AppMethodBeat.o(39415);
                return true;
            } else {
                AppMethodBeat.o(39415);
                return false;
            }
        }
    }, true);
    private q tipDialog;
    private int tnt = 0;
    private String toUser = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SendAppMessageWrapperUI() {
        AppMethodBeat.i(39425);
        AppMethodBeat.o(39425);
    }

    static /* synthetic */ void a(SendAppMessageWrapperUI sendAppMessageWrapperUI, Bundle bundle) {
        AppMethodBeat.i(234524);
        sendAppMessageWrapperUI.d(true, bundle);
        AppMethodBeat.o(234524);
    }

    static /* synthetic */ void a(SendAppMessageWrapperUI sendAppMessageWrapperUI, WXMediaMessage wXMediaMessage, LinkedList linkedList, String str, String str2) {
        AppMethodBeat.i(234532);
        sendAppMessageWrapperUI.a(wXMediaMessage, linkedList, str, str2);
        AppMethodBeat.o(234532);
    }

    static /* synthetic */ void a(SendAppMessageWrapperUI sendAppMessageWrapperUI, String str, LinkedList linkedList, int i2) {
        AppMethodBeat.i(234533);
        sendAppMessageWrapperUI.a(str, linkedList, i2);
        AppMethodBeat.o(234533);
    }

    static /* synthetic */ int b(SendAppMessageWrapperUI sendAppMessageWrapperUI) {
        int i2 = sendAppMessageWrapperUI.tnt + 1;
        sendAppMessageWrapperUI.tnt = i2;
        return i2;
    }

    static /* synthetic */ void b(k.b bVar, WXMediaMessage wXMediaMessage) {
        AppMethodBeat.i(234529);
        a(bVar, wXMediaMessage);
        AppMethodBeat.o(234529);
    }

    static /* synthetic */ void b(WxaAttributes wxaAttributes, k.b bVar, fcr fcr) {
        AppMethodBeat.i(234530);
        a(wxaAttributes, bVar, fcr);
        AppMethodBeat.o(234530);
    }

    static /* synthetic */ boolean h(SendAppMessageWrapperUI sendAppMessageWrapperUI) {
        AppMethodBeat.i(234528);
        boolean gYq = sendAppMessageWrapperUI.gYq();
        AppMethodBeat.o(234528);
        return gYq;
    }

    static /* synthetic */ com.tencent.mm.pluginsdk.model.app.a i(SendAppMessageWrapperUI sendAppMessageWrapperUI) {
        AppMethodBeat.i(234531);
        com.tencent.mm.pluginsdk.model.app.a gYr = sendAppMessageWrapperUI.gYr();
        AppMethodBeat.o(234531);
        return gYr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x034b  */
    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r13) {
        /*
        // Method dump skipped, instructions count: 1007
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.transmit.SendAppMessageWrapperUI.onCreate(android.os.Bundle):void");
    }

    private void gYp() {
        AppMethodBeat.i(234518);
        d(false, null);
        AppMethodBeat.o(234518);
    }

    private void d(boolean z, Bundle bundle) {
        Intent a2;
        AppMethodBeat.i(234519);
        if (this.QAa || !gYq()) {
            a2 = com.tencent.mm.modelsns.a.a(this.sdkVersion, this.pez, this.QzY.field_appId, this.QzY.field_appName, this.QzY.NA(), bundle);
        } else {
            a2 = com.tencent.mm.modelsns.a.a(this.sdkVersion, this.pez, "", "", this.QzY.NA(), bundle);
        }
        if (a2 == null) {
            finish();
            AppMethodBeat.o(234519);
            return;
        }
        String str = null;
        if (this.pez.getType() == 5 || this.pez.getType() == 2 || this.pez.getType() == 38) {
            Log.d("MicroMsg.SendAppMessageWrapperUI", "report(11954), to timeline, appId : %s", this.QzY.field_appId);
            String JX = ad.JX("app_" + this.QzY.field_appId);
            ad.b G = ad.aVe().G(JX, true);
            G.l("prePublishId", "app_" + this.QzY.field_appId);
            if (this.pez.mediaObject instanceof WXWebpageObject) {
                G.l("url", ((WXWebpageObject) this.pez.mediaObject).webpageUrl);
            }
            str = JX;
        }
        bog(str);
        a2.putExtra("reportSessionId", str);
        a2.putExtra("KSnsUploadFromSkipCompress", z);
        a2.putExtra("SendAppMessageWrapper_TokenValid", this.QAa);
        a2.putExtra("SendAppMessageWrapper_PkgName", this.pkgName);
        c.b(this, "sns", ".ui.SnsUploadUI", a2, 1);
        AppMethodBeat.o(234519);
    }

    private boolean gYq() {
        AppMethodBeat.i(39428);
        Log.i("MicroMsg.SendAppMessageWrapperUI", "blockInvalidToken block %b", Boolean.valueOf(this.QAc));
        boolean z = this.QAc;
        AppMethodBeat.o(39428);
        return z;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(39429);
        super.onActivityResult(i2, i3, intent);
        Log.i("MicroMsg.SendAppMessageWrapperUI", "requestCode " + i2 + " resultCode " + i3);
        if (i2 == 1) {
            if (i3 == -1) {
                ReportUtil.a(this, ReportUtil.d(getIntent().getExtras(), 0), false);
            } else {
                ReportUtil.a(this, ReportUtil.d(getIntent().getExtras(), 0), true);
            }
            finish();
            AppMethodBeat.o(39429);
            return;
        }
        if (i2 == 2 && i3 == -1) {
            if (this.pez.mediaObject instanceof WXVideoFileObject) {
                WXVideoFileObject wXVideoFileObject = (WXVideoFileObject) this.pez.mediaObject;
                wXVideoFileObject.filePath = intent.getStringExtra("K_SEGMENTVIDEOPATH");
                if (Util.isNullOrNil(wXVideoFileObject.filePath) || !s.YS(wXVideoFileObject.filePath)) {
                    setResult(-5);
                    finish();
                    AppMethodBeat.o(39429);
                    return;
                }
                gYp();
                AppMethodBeat.o(39429);
                return;
            } else if (this.pez.mediaObject instanceof WXGameVideoFileObject) {
                WXGameVideoFileObject wXGameVideoFileObject = (WXGameVideoFileObject) this.pez.mediaObject;
                wXGameVideoFileObject.filePath = intent.getStringExtra("K_SEGMENTVIDEOPATH");
                if (Util.isNullOrNil(wXGameVideoFileObject.filePath) || !s.YS(wXGameVideoFileObject.filePath)) {
                    setResult(-5);
                    finish();
                } else {
                    gYp();
                    AppMethodBeat.o(39429);
                    return;
                }
            }
        }
        AppMethodBeat.o(39429);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(39430);
        super.onDestroy();
        if (this.QzZ) {
            Log.d("MicroMsg.SendAppMessageWrapperUI", "restore orientation");
            SharedPreferences sharedPreferences = getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
            setRequestedOrientation(1);
            sharedPreferences.edit().putBoolean("settings_landscape_mode", false).commit();
        }
        AppMethodBeat.o(39430);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(39431);
        hideVKB();
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(39431);
        return onTouchEvent;
    }

    private boolean d(WXMediaMessage wXMediaMessage) {
        String str;
        View view;
        Bitmap decodeByteArray;
        AppMethodBeat.i(257977);
        o.a aVar = new o.a(this);
        String stringExtra = getIntent().getStringExtra("Select_Conv_User");
        ArrayList<String> arrayList = null;
        if (stringExtra != null) {
            arrayList = Util.stringsToList(stringExtra.split(","));
        }
        aVar.ea(arrayList);
        byte[] bArr = wXMediaMessage.thumbData;
        if (wXMediaMessage.getType() == 76 || wXMediaMessage.getType() == 3) {
            WXMediaMessage.IMediaObject iMediaObject = wXMediaMessage.mediaObject;
            String str2 = wXMediaMessage.title;
            String str3 = wXMediaMessage.description;
            if (wXMediaMessage.getType() == 76) {
                String str4 = ((WXMusicVideoObject) iMediaObject).singerName;
                str = Util.isNullOrNil(str4) ? wXMediaMessage.description : str4;
            } else {
                str = str3;
            }
            View inflate = View.inflate(this, R.layout.bs6, null);
            ((RoundCornerRelativeLayout) inflate.findViewById(R.id.h9d)).setRadius((float) com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 4));
            View findViewById = inflate.findViewById(R.id.a_q);
            View findViewById2 = inflate.findViewById(R.id.fpx);
            if (ao.isDarkMode()) {
                findViewById2.setBackgroundResource(R.drawable.avn);
            } else {
                findViewById2.setBackgroundResource(R.drawable.avo);
            }
            MMRoundCornerImageView mMRoundCornerImageView = (MMRoundCornerImageView) findViewById2.findViewById(R.id.axd);
            TextView textView = (TextView) findViewById2.findViewById(R.id.axh);
            TextView textView2 = (TextView) findViewById2.findViewById(R.id.axi);
            textView2.setMaxLines(2);
            textView.setMaxLines(1);
            ((TextView) findViewById2.findViewById(R.id.axf)).setMaxLines(1);
            textView2.setText(str2);
            textView.setText(str);
            if (bArr != null && bArr.length > 0 && (decodeByteArray = MMBitmapFactory.decodeByteArray(bArr, 0, bArr.length)) != null && !decodeByteArray.isRecycled()) {
                mMRoundCornerImageView.setImageBitmap(decodeByteArray);
                String messageDigest = d.getMessageDigest("".getBytes());
                b bVar = b.qCp;
                AppCompatActivity context = getContext();
                if (messageDigest == null) {
                    messageDigest = "";
                }
                b.a(context, findViewById, decodeByteArray, messageDigest);
            }
            findViewById2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            view = inflate;
        } else {
            view = null;
        }
        if (view != null) {
            aVar.gl(view);
            aVar.gpz();
            aVar.p(Boolean.TRUE);
            aVar.p(Boolean.TRUE);
            aVar.aii(R.string.b9_).a(a(wXMediaMessage)).kdo.show();
            AppMethodBeat.o(257977);
            return true;
        }
        AppMethodBeat.o(257977);
        return false;
    }

    private y.a a(final WXMediaMessage wXMediaMessage) {
        AppMethodBeat.i(39432);
        AnonymousClass12 r0 = new y.a() {
            /* class com.tencent.mm.ui.transmit.SendAppMessageWrapperUI.AnonymousClass12 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
            public final void a(boolean z, String str, int i2) {
                AppMethodBeat.i(180109);
                if (z) {
                    SendAppMessageWrapperUI.a(SendAppMessageWrapperUI.this, wXMediaMessage, str, i2);
                    AppMethodBeat.o(180109);
                    return;
                }
                SendAppMessageWrapperUI.e(SendAppMessageWrapperUI.this);
                AppMethodBeat.o(180109);
            }
        };
        AppMethodBeat.o(39432);
        return r0;
    }

    private void a(WXMediaMessage wXMediaMessage, LinkedList<String> linkedList, String str, String str2) {
        boolean z;
        String str3;
        AppMethodBeat.i(234520);
        com.tencent.mm.pluginsdk.ui.tools.q.a(this.sdkVersion, this.QzY, wXMediaMessage, linkedList);
        if (wXMediaMessage.getType() == 6) {
            WXFileObject wXFileObject = (WXFileObject) wXMediaMessage.mediaObject;
            byte[] bArr = wXFileObject.fileData;
            if ((bArr == null || bArr.length == 0) && ((str3 = wXFileObject.filePath) == null || str3.length() == 0)) {
                com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.WXFileObject", "checkArgs fail, both arguments is null");
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                Log.e("MicroMsg.SendAppMessageWrapperUI", "check security problem %s", wXFileObject.filePath);
                finish();
                AppMethodBeat.o(234520);
                return;
            } else if (!Util.isNullOrNil(wXFileObject.filePath)) {
                String str4 = wXFileObject.filePath;
                bg.aVF();
                if (!str4.startsWith(com.tencent.mm.model.c.aTg()) && !wXFileObject.filePath.startsWith(com.tencent.mm.loader.j.b.aKM())) {
                    String str5 = wXFileObject.filePath;
                    if (!Util.isNullOrNil(wXFileObject.filePath)) {
                        try {
                            int lastIndexOf = wXFileObject.filePath.lastIndexOf(47) + 1;
                            if (lastIndexOf < 0 || lastIndexOf == wXFileObject.filePath.length()) {
                                lastIndexOf = 0;
                            }
                            String str6 = wXFileObject.filePath;
                            str5 = str6.substring(lastIndexOf, str6.length());
                        } catch (Exception e2) {
                            Log.e("MicroMsg.SendAppMessageWrapperUI", "get file name error " + e2.getMessage());
                            str5 = " ";
                        }
                    }
                    bg.aVF();
                    String aB = m.aB(com.tencent.mm.model.c.aTg(), str5, s.akC(wXFileObject.filePath));
                    s.nw(wXFileObject.filePath, aB);
                    wXFileObject.filePath = aB;
                }
            }
        }
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            String str7 = this.QzY.field_appId;
            if (!this.QAa && gYq()) {
                str7 = "";
            }
            int i2 = 0;
            if (this.scene == 3) {
                i2 = 1;
            }
            m.a(wXMediaMessage, str7, this.QzY.field_appName, next, 2, str, str2, i2, gYr());
        }
        AppMethodBeat.o(234520);
    }

    private void a(String str, LinkedList<String> linkedList, int i2) {
        String string;
        AppMethodBeat.i(234521);
        String string2 = this.QzY.field_appId.equals("wx4310bbd51be7d979") ? null : getString(R.string.b95, new Object[]{h.a(this, this.QzY, this.QzY.field_appName)});
        if (this.QAa || !gYq()) {
            string = string2 == null ? getString(R.string.b94) : string2;
        } else {
            string = getString(R.string.b94);
        }
        String string3 = getString(R.string.b9b);
        AnonymousClass13 r5 = new y.a() {
            /* class com.tencent.mm.ui.transmit.SendAppMessageWrapperUI.AnonymousClass13 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
            public final void a(boolean z, String str, int i2) {
                AppMethodBeat.i(234516);
                SendAppMessageWrapperUI.this.setResult(-1, new Intent().putExtra("Select_stay_in_wx", true));
                SendAppMessageWrapperUI.this.finish();
                AppMethodBeat.o(234516);
            }
        };
        AnonymousClass14 r4 = new y.a() {
            /* class com.tencent.mm.ui.transmit.SendAppMessageWrapperUI.AnonymousClass14 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
            public final void a(boolean z, String str, int i2) {
                AppMethodBeat.i(234517);
                Intent putExtra = new Intent().putExtra("Select_back_to_app", true);
                if (SendAppMessageWrapperUI.this.scene != 3) {
                    if (SendAppMessageWrapperUI.this.getIntent().getExtras() != null) {
                        putExtra.putExtras(SendAppMessageWrapperUI.this.getIntent().getExtras());
                    }
                    SendAppMessageWrapperUI.this.setResult(-1, putExtra);
                    SendAppMessageWrapperUI.this.finish();
                    AppMethodBeat.o(234517);
                    return;
                }
                SendAppMessageWrapperUI.this.setResult(-1);
                SendAppMessageWrapperUI.this.finish();
                ReportUtil.a(SendAppMessageWrapperUI.this, ReportUtil.d(SendAppMessageWrapperUI.this.getIntent().getExtras(), 0), false);
                AppMethodBeat.o(234517);
            }
        };
        if (this.QAb) {
            r4.a(true, str, i2);
        } else {
            com.tencent.mm.plugin.bizui.a.b.a(this.mController, getString(R.string.b99), string, string3, r4, r5);
        }
        if (str == null || str.length() == 0) {
            Log.i("MicroMsg.SendAppMessageWrapperUI", "summerbig dealSucc, text is empty");
            AppMethodBeat.o(234521);
            return;
        }
        Log.d("MicroMsg.SendAppMessageWrapperUI", "summerbig dktext , send msg here:".concat(String.valueOf(str)));
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            o.e Pl = com.tencent.mm.modelmulti.o.Pl(next);
            Pl.toUser = next;
            Pl.content = str;
            o.e tD = Pl.tD(ab.JG(this.toUser));
            tD.cSx = 0;
            tD.jdR = 4;
            tD.bdQ().execute();
        }
        AppMethodBeat.o(234521);
    }

    private com.tencent.mm.pluginsdk.model.app.a gYr() {
        AppMethodBeat.i(39433);
        com.tencent.mm.pluginsdk.model.app.a aVar = new com.tencent.mm.pluginsdk.model.app.a();
        aVar.JVJ = this.QAa ? 1 : 0;
        aVar.pkgName = this.pkgName;
        aVar.pkK = this.QAd;
        AppMethodBeat.o(39433);
        return aVar;
    }

    private static void a(k.b bVar, WXMediaMessage wXMediaMessage) {
        Bitmap decodeByteArray;
        AppMethodBeat.i(39435);
        if (bVar == null || wXMediaMessage == null || wXMediaMessage.mediaObject == null) {
            AppMethodBeat.o(39435);
        } else if (wXMediaMessage.mediaObject instanceof WXDynamicVideoMiniProgramObject) {
            WXDynamicVideoMiniProgramObject wXDynamicVideoMiniProgramObject = (WXDynamicVideoMiniProgramObject) wXMediaMessage.mediaObject;
            com.tencent.mm.ag.a aVar = new com.tencent.mm.ag.a();
            if (!(wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0 || (decodeByteArray = BitmapFactory.decodeByteArray(wXMediaMessage.thumbData, 0, wXMediaMessage.thumbData.length)) == null)) {
                aVar.ivi = decodeByteArray.getWidth();
                aVar.ivj = decodeByteArray.getHeight();
            }
            aVar.videoSource = wXDynamicVideoMiniProgramObject.videoSource;
            aVar.appThumbUrl = wXDynamicVideoMiniProgramObject.appThumbUrl;
            aVar.ivk = 1;
            bVar.a(aVar);
            bVar.izr = wXDynamicVideoMiniProgramObject.disableforward;
            bVar.eah = null;
            AppMethodBeat.o(39435);
        } else {
            if (wXMediaMessage.mediaObject instanceof WXMiniProgramObject) {
                bVar.izr = ((WXMiniProgramObject) wXMediaMessage.mediaObject).disableforward;
            }
            AppMethodBeat.o(39435);
        }
    }

    private static String a(WXMiniProgramObject wXMiniProgramObject) {
        AppMethodBeat.i(234522);
        try {
            JSONObject jSONObject = new JSONObject();
            String extra = wXMiniProgramObject.getExtra(ConstantsAPI.WXMiniProgram.KEY_ACTIVITY_ID, "");
            String extra2 = wXMiniProgramObject.getExtra(ConstantsAPI.WXMiniProgram.KEY_PARAMETER_INFO_LIST, "");
            jSONObject.put("activity_id", extra);
            if (!Util.isNullOrNil(extra2)) {
                jSONObject.put("parameter_list", new JSONArray(extra2));
            }
            Log.d("MicroMsg.SendAppMessageWrapperUI", "getAppBrandActivityInfo activityId: %s, json: %s", extra, jSONObject.toString());
            String jSONObject2 = jSONObject.toString();
            AppMethodBeat.o(234522);
            return jSONObject2;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SendAppMessageWrapperUI", e2, "getAppBrandActivityInfo exception", new Object[0]);
            AppMethodBeat.o(234522);
            return null;
        }
    }

    private static void a(WxaAttributes wxaAttributes, k.b bVar, fcr fcr) {
        AppMethodBeat.i(234523);
        com.tencent.mm.ag.a aVar = new com.tencent.mm.ag.a();
        aVar.ivc = wxaAttributes.bAo().lgD.leb;
        if (fcr != null) {
            aVar.iuT = fcr.Nyi;
            if (fcr.Nyi && fcr.NyB != null) {
                aVar.iuU = fcr.NyB.content;
                aVar.iuV = fcr.NyB.MXr;
                aVar.iuW = fcr.NyB.MXs;
                aVar.iuX = fcr.NyB.MXt;
                aVar.iuY = fcr.NyB.MXu;
                aVar.iuZ = fcr.NyB.MXw;
                aVar.ivb = fcr.NyB.state;
                aVar.iva = fcr.NyB.MXv;
            }
            aVar.ivg = fcr.Nyl;
            if (fcr.Nyl) {
                bVar.izr = 1;
            }
        }
        bVar.a(aVar);
        AppMethodBeat.o(234523);
    }

    private void b(WXMediaMessage wXMediaMessage, LinkedList<String> linkedList) {
        AppMethodBeat.i(39436);
        ArrayList arrayList = new ArrayList();
        arrayList.add(((WXVideoFileObject) wXMediaMessage.mediaObject).filePath);
        if (arrayList.size() > 0) {
            Iterator<String> it = linkedList.iterator();
            while (it.hasNext()) {
                Log.i("MicroMsg.SendAppMessageWrapperUI", "sendMultiVedeo");
                final com.tencent.mm.pluginsdk.model.m mVar = new com.tencent.mm.pluginsdk.model.m(this, arrayList, getIntent(), it.next(), 1, new m.a() {
                    /* class com.tencent.mm.ui.transmit.SendAppMessageWrapperUI.AnonymousClass5 */

                    @Override // com.tencent.mm.pluginsdk.model.m.a
                    public final void gmA() {
                        AppMethodBeat.i(234510);
                        if (SendAppMessageWrapperUI.this.tipDialog != null) {
                            SendAppMessageWrapperUI.this.tipDialog.dismiss();
                            SendAppMessageWrapperUI.this.tipDialog = null;
                        }
                        AppMethodBeat.o(234510);
                    }
                });
                ThreadPool.post(mVar, "ChattingUI_importMultiVideo");
                getString(R.string.zb);
                this.tipDialog = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.ui.transmit.SendAppMessageWrapperUI.AnonymousClass6 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(234511);
                        mVar.gmu();
                        SendAppMessageWrapperUI.this.setResult(-1);
                        SendAppMessageWrapperUI.this.finish();
                        AppMethodBeat.o(234511);
                    }
                });
            }
        }
        AppMethodBeat.o(39436);
    }

    private void c(WXMediaMessage wXMediaMessage, LinkedList<String> linkedList) {
        AppMethodBeat.i(39437);
        WXEnterpriseCardObject wXEnterpriseCardObject = (WXEnterpriseCardObject) wXMediaMessage.mediaObject;
        if (wXEnterpriseCardObject.msgType == 66 || wXEnterpriseCardObject.msgType == 42) {
            Iterator<String> it = linkedList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                o.e Pl = com.tencent.mm.modelmulti.o.Pl(next);
                Pl.toUser = next;
                Pl.content = wXEnterpriseCardObject.cardInfo;
                o.e tD = Pl.tD(wXEnterpriseCardObject.msgType);
                tD.cSx = 0;
                tD.jdR = 4;
                tD.bdQ().execute();
            }
            AppMethodBeat.o(39437);
            return;
        }
        Log.e("MicroMsg.SendAppMessageWrapperUI", "sendCardMsg msgType invalid");
        setResult(0);
        finish();
        AppMethodBeat.o(39437);
    }

    private void bN(LinkedList<String> linkedList) {
        String str;
        AppMethodBeat.i(39438);
        ad.b G = ad.aVe().G("kWXEntryActivity_data_center_session_id", true);
        if (G == null) {
            Log.e("MicroMsg.SendAppMessageWrapperUI", "sendWXWeworkObject fail values is null");
            AppMethodBeat.o(39438);
        } else if (h.ahL(((WXWeWorkObject) this.pez.mediaObject).subType) < 0) {
            Log.e("MicroMsg.SendAppMessageWrapperUI", "sendWXWeworkObject fail innerType < 0");
            AppMethodBeat.o(39438);
        } else {
            k.b HD = k.b.HD((String) G.get("kWXEntryActivity_data_center_wework_msgcontent", ""));
            if (HD != null) {
                com.tencent.mm.protocal.b.a.c aKY = p.aKY(HD.ixl);
                if (aKY == null || Util.isNullOrNil(aKY.title)) {
                    str = HD.title;
                } else {
                    str = aKY.title;
                }
                String str2 = this.QzY.field_appId;
                if (!this.QAa && gYq()) {
                    str2 = "";
                }
                HD.appId = str2;
                HD.title = getResources().getString(R.string.fja, str);
                Iterator<String> it = linkedList.iterator();
                while (it.hasNext()) {
                    rc rcVar = new rc();
                    rcVar.dXF.type = 4;
                    ca caVar = new ca();
                    caVar.setContent(k.b.a(HD, null, null));
                    rcVar.dXF.dTX = caVar;
                    rcVar.dXF.toUser = it.next();
                    rcVar.dXF.dXN = true;
                    EventCenter.instance.publish(rcVar);
                }
                AppMethodBeat.o(39438);
                return;
            }
            Log.e("MicroMsg.SendAppMessageWrapperUI", "dealWXWeWorkObject fail msg content is null");
            AppMethodBeat.o(39438);
        }
    }

    private void bog(String str) {
        AppMethodBeat.i(39439);
        if ("wx5dfbe0a95623607b".equals(this.QzY.field_appId)) {
            if (this.pez.getType() == 5) {
                Log.i("MicroMsg.SendAppMessageWrapperUI", "report(17256) url, to timeline, appId : %s", this.QzY.field_appId);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(17256, str, 2);
                AppMethodBeat.o(39439);
                return;
            } else if (this.pez.getType() == 38) {
                Log.i("MicroMsg.SendAppMessageWrapperUI", "report(17256) video file, to timeline, appId : %s", this.QzY.field_appId);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(17256, str, 1);
            }
        }
        AppMethodBeat.o(39439);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    private void a(WXMediaMessage wXMediaMessage, LinkedList<String> linkedList) {
        String str;
        int i2;
        String str2;
        String str3;
        AppMethodBeat.i(39434);
        if (wXMediaMessage == null || !(wXMediaMessage.mediaObject instanceof WXImageObject)) {
            Log.w("MicroMsg.SendAppMessageWrapperUI", "sendImgMsg msg not img");
            str = null;
        } else {
            WXImageObject wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
            if (!Util.isNullOrNil(wXImageObject.imageData)) {
                Log.d("MicroMsg.SendAppMessageWrapperUI", "getImagePath fileData:" + wXImageObject.imageData.length);
                str = com.tencent.mm.pluginsdk.model.app.m.cC(wXImageObject.imageData);
            } else {
                str = wXImageObject.imagePath;
            }
        }
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.SendAppMessageWrapperUI", "sendImgMsg imgPath is null");
            setResult(0);
            AppMethodBeat.o(39434);
            return;
        }
        int i3 = Util.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
        if (i3 <= 0) {
            i3 = 100;
        }
        int i4 = i3 * 1024;
        long boW = s.boW(str);
        if (boW > 26214400 || boW <= ((long) i4)) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (this.QAa || !gYq()) {
            String str4 = this.QzY.field_appId;
            String str5 = wXMediaMessage.mediaTagName;
            String str6 = wXMediaMessage.messageExt;
            String str7 = wXMediaMessage.messageAction;
            if (!Util.isNullOrNil(str4)) {
                str2 = "<msg>" + com.tencent.mm.av.h.c(str4, str5, str6, str7) + "</msg>";
            } else {
                str2 = null;
            }
            str3 = str2;
        } else {
            str3 = null;
        }
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            o.e tc = com.tencent.mm.modelmulti.o.a(o.d.jdL).tc(6);
            tc.dRL = z.aTY();
            tc.toUser = it.next();
            tc.iZt = str;
            tc.iXp = i2;
            tc.jdS = null;
            tc.dQd = 0;
            tc.iXy = str3;
            tc.thumbPath = "";
            tc.jdV = true;
            tc.jdU = R.drawable.bb4;
            tc.jdR = 11;
            tc.bdQ().execute();
        }
        AppMethodBeat.o(39434);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:118:0x03fd, code lost:
        if (com.tencent.mm.pluginsdk.ui.applet.o.a(r12.mController, r0, true, r12.a(r4)) != null) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x007d, code lost:
        if (com.tencent.mm.pluginsdk.ui.applet.o.a(r12.mController, r1.description, true, r12.a(r1)) != null) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void c(com.tencent.mm.ui.transmit.SendAppMessageWrapperUI r12) {
        /*
        // Method dump skipped, instructions count: 1232
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.transmit.SendAppMessageWrapperUI.c(com.tencent.mm.ui.transmit.SendAppMessageWrapperUI):void");
    }

    static /* synthetic */ void a(SendAppMessageWrapperUI sendAppMessageWrapperUI, final WXMediaMessage wXMediaMessage, final String str, final int i2) {
        AppMethodBeat.i(234525);
        Log.d("MicroMsg.SendAppMessageWrapperUI", "summerbig dealSucc msg[%s], text[%s], parsterLen[%d], scene[%d]", wXMediaMessage, str, Integer.valueOf(i2), Integer.valueOf(sendAppMessageWrapperUI.scene));
        if (sendAppMessageWrapperUI.scene == 0 || sendAppMessageWrapperUI.scene == 3) {
            cf.aWl().f(38, 1);
            final String str2 = null;
            if (wXMediaMessage.getType() == 8) {
                if (wXMediaMessage.thumbData == null) {
                    Log.e("MicroMsg.SendAppMessageWrapperUI", "summerbig code should not reach here due to WXMediaMessage::checkArgs, sendEmoji Fail cause thumbData is null");
                    AppMethodBeat.o(234525);
                    return;
                }
                str2 = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(sendAppMessageWrapperUI, wXMediaMessage, sendAppMessageWrapperUI.QzY.field_appId);
                if (str2 == null) {
                    Log.v("MicroMsg.SendAppMessageWrapperUI", "summerbig sendEmoji Fail cause emojiconmd5 is null");
                    AppMethodBeat.o(234525);
                    return;
                }
                EmojiInfo aml = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(str2);
                if (aml == null) {
                    Log.i("MicroMsg.SendAppMessageWrapperUI", "emoji is null.");
                    AppMethodBeat.o(234525);
                    return;
                }
                if (aml.field_size > Util.getInt(com.tencent.mm.n.h.aqJ().getValue("InputLimitSendThirdPartyAppMsgEmotionBufSize"), 524288)) {
                    Log.i("MicroMsg.SendAppMessageWrapperUI", "third party shared emoji can't bigger 512 KB");
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13461, sendAppMessageWrapperUI.QzY.field_appId, sendAppMessageWrapperUI.QzY.field_appName, Integer.valueOf(aml.field_size));
            }
            final String str3 = null;
            if (wXMediaMessage.getType() == 5 || wXMediaMessage.getType() == 2) {
                Log.d("MicroMsg.SendAppMessageWrapperUI", "report(11954), appId : %s", sendAppMessageWrapperUI.QzY.field_appId);
                str3 = ad.JX("app_" + sendAppMessageWrapperUI.QzY.field_appId);
                ad.aVe().G(str3, true).l("prePublishId", "app_" + sendAppMessageWrapperUI.QzY.field_appId);
            }
            final LinkedList<String> linkedList = new LinkedList<>(Util.stringsToList(sendAppMessageWrapperUI.toUser.split(",")));
            if (wXMediaMessage.getType() == 36 || wXMediaMessage.getType() == 46 || wXMediaMessage.getType() == 48) {
                final WXMiniProgramObject wXMiniProgramObject = (WXMiniProgramObject) wXMediaMessage.mediaObject;
                ((com.tencent.mm.plugin.appbrand.service.q) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xn(wXMiniProgramObject.userName).f(new com.tencent.mm.vending.c.a<Void, WxaAttributes>() {
                    /* class com.tencent.mm.ui.transmit.SendAppMessageWrapperUI.AnonymousClass2 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.mm.vending.c.a
                    public final /* synthetic */ Void call(WxaAttributes wxaAttributes) {
                        AppMethodBeat.i(234506);
                        WxaAttributes wxaAttributes2 = wxaAttributes;
                        if (wxaAttributes2 == null) {
                            Log.e("MicroMsg.SendAppMessageWrapperUI", "get wxaAttributes for appbrand info failed");
                            SendAppMessageWrapperUI.this.setResult(-1);
                            SendAppMessageWrapperUI.this.finish();
                            ReportUtil.a(SendAppMessageWrapperUI.this, ReportUtil.d(SendAppMessageWrapperUI.this.getIntent().getExtras(), -1), false);
                        } else {
                            SendAppMessageWrapperUI.a(SendAppMessageWrapperUI.this, wxaAttributes2, wXMediaMessage, wXMiniProgramObject, linkedList);
                        }
                        Void r0 = QZL;
                        AppMethodBeat.o(234506);
                        return r0;
                    }
                });
            } else if (wXMediaMessage.getType() == 2) {
                com.tencent.mm.pluginsdk.ui.tools.q.a(sendAppMessageWrapperUI.sdkVersion, sendAppMessageWrapperUI.QzY, wXMediaMessage, linkedList);
                sendAppMessageWrapperUI.a(wXMediaMessage, linkedList);
            } else if (wXMediaMessage.getType() == 38) {
                com.tencent.mm.pluginsdk.ui.tools.q.a(sendAppMessageWrapperUI.sdkVersion, sendAppMessageWrapperUI.QzY, wXMediaMessage, linkedList);
                sendAppMessageWrapperUI.b(wXMediaMessage, linkedList);
            } else if (wXMediaMessage.getType() == 45) {
                com.tencent.mm.pluginsdk.ui.tools.q.a(sendAppMessageWrapperUI.sdkVersion, sendAppMessageWrapperUI.QzY, wXMediaMessage, linkedList);
                sendAppMessageWrapperUI.c(wXMediaMessage, linkedList);
            } else if (wXMediaMessage.getType() == 49) {
                com.tencent.mm.pluginsdk.ui.tools.q.a(sendAppMessageWrapperUI.sdkVersion, sendAppMessageWrapperUI.QzY, wXMediaMessage, linkedList);
                sendAppMessageWrapperUI.bN(linkedList);
            } else if (wXMediaMessage.getType() == 76) {
                sendAppMessageWrapperUI.tipDialog = q.a(sendAppMessageWrapperUI, sendAppMessageWrapperUI.getString(R.string.ekc), true, 0, null);
                String str4 = ((WXMusicVideoObject) wXMediaMessage.mediaObject).hdAlbumThumbFilePath;
                if (!Util.isNullOrNil(str4)) {
                    d.a(str4, new d.a() {
                        /* class com.tencent.mm.ui.transmit.SendAppMessageWrapperUI.AnonymousClass4 */

                        @Override // com.tencent.mm.ui.transmit.d.a
                        public final void be(String str, boolean z) {
                            AppMethodBeat.i(234509);
                            if (z) {
                                SendAppMessageWrapperUI.this.QAd = str;
                                SendAppMessageWrapperUI.a(SendAppMessageWrapperUI.this, wXMediaMessage, linkedList, str2, str3);
                                SendAppMessageWrapperUI.this.runOnUiThread(new Runnable() {
                                    /* class com.tencent.mm.ui.transmit.SendAppMessageWrapperUI.AnonymousClass4.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(234508);
                                        SendAppMessageWrapperUI.this.tipDialog.dismiss();
                                        SendAppMessageWrapperUI.a(SendAppMessageWrapperUI.this, str, linkedList, i2);
                                        AppMethodBeat.o(234508);
                                    }
                                });
                                AppMethodBeat.o(234509);
                                return;
                            }
                            Log.e("MicroMsg.SendAppMessageWrapperUI", "thumb img CDN upload fail!");
                            ReportUtil.a(SendAppMessageWrapperUI.this, ReportUtil.d(SendAppMessageWrapperUI.this.getIntent().getExtras(), -1), false);
                            SendAppMessageWrapperUI.this.finish();
                            AppMethodBeat.o(234509);
                        }
                    });
                }
                AppMethodBeat.o(234525);
                return;
            } else {
                sendAppMessageWrapperUI.a(wXMediaMessage, linkedList, str2, str3);
            }
            sendAppMessageWrapperUI.a(str, linkedList, i2);
            AppMethodBeat.o(234525);
            return;
        }
        if (com.tencent.mm.plugin.sns.b.o.DCL != null) {
            com.tencent.mm.plugin.sns.b.o.DCL.a(wXMediaMessage, str, sendAppMessageWrapperUI.QzY.field_appId, sendAppMessageWrapperUI.QzY.field_appName, i2);
            com.tencent.mm.plugin.sns.b.o.DCL.eZn();
        }
        ReportUtil.a(sendAppMessageWrapperUI, ReportUtil.d(sendAppMessageWrapperUI.getIntent().getExtras(), 0), false);
        sendAppMessageWrapperUI.finish();
        AppMethodBeat.o(234525);
    }

    static /* synthetic */ void e(SendAppMessageWrapperUI sendAppMessageWrapperUI) {
        AppMethodBeat.i(234526);
        if (sendAppMessageWrapperUI.scene == 0 || sendAppMessageWrapperUI.scene == 3) {
            Intent intent = new Intent();
            intent.putExtra("Select_Report_Args", ReportUtil.d(sendAppMessageWrapperUI.getIntent().getExtras(), -2));
            sendAppMessageWrapperUI.setResult(0, intent);
        } else {
            ReportUtil.a(sendAppMessageWrapperUI, ReportUtil.d(sendAppMessageWrapperUI.getIntent().getExtras(), -2), false);
        }
        sendAppMessageWrapperUI.finish();
        AppMethodBeat.o(234526);
    }

    static /* synthetic */ void a(SendAppMessageWrapperUI sendAppMessageWrapperUI, final WxaAttributes wxaAttributes, final WXMediaMessage wXMediaMessage, final WXMiniProgramObject wXMiniProgramObject, final LinkedList linkedList) {
        AppMethodBeat.i(234527);
        com.tencent.mm.pluginsdk.ui.tools.q.a(sendAppMessageWrapperUI.sdkVersion, sendAppMessageWrapperUI.QzY, wxaAttributes, wXMediaMessage, wXMiniProgramObject, linkedList);
        StringBuilder sb = new StringBuilder("1_");
        sb.append(sendAppMessageWrapperUI.QzY.field_appId);
        sb.append("_");
        bg.aVF();
        sb.append(MD5Util.getMD5String(com.tencent.mm.b.p.getString(com.tencent.mm.model.c.getUin())));
        sb.append("_");
        sb.append(Util.nowSecond());
        sb.append("_");
        sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        final String sb2 = sb.toString();
        final int i2 = sendAppMessageWrapperUI.scene == 3 ? 1 : 0;
        if (wXMiniProgramObject.withShareTicket) {
            if (wxaAttributes == null) {
                Log.e("MicroMsg.SendAppMessageWrapperUI", "get wxaAttributes for appbrand info failed");
                sendAppMessageWrapperUI.setResult(-1);
                sendAppMessageWrapperUI.finish();
                ReportUtil.a(sendAppMessageWrapperUI, ReportUtil.d(sendAppMessageWrapperUI.getIntent().getExtras(), -1), false);
                AppMethodBeat.o(234527);
                return;
            }
            d.a aVar = new d.a();
            aVar.funcId = FaceManager.FACE_ACQUIRED_NO_FOCUS;
            aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getshareinfo";
            fci fci = new fci();
            fci.dNI = wxaAttributes.field_appId;
            fci.Nyh = linkedList;
            fci.Nyj = a(wXMiniProgramObject);
            fci.Nyi = wXMiniProgramObject.isUpdatableMessage;
            fci.Nyl = wXMiniProgramObject.isSecretMessage;
            fci.LEg = 1;
            Log.d("MicroMsg.SendAppMessageWrapperUI", "sendAppBrandAppMsgImpl appId: %s, isUpdatableMsg: %b, activityInfo: %s, isSecretMsg: %s, sourceType: %d", fci.dNI, Boolean.valueOf(fci.Nyi), fci.Nyj, Boolean.valueOf(fci.Nyl), Integer.valueOf(fci.LEg));
            aVar.iLN = fci;
            aVar.iLO = new fcj();
            aa.a(aVar.aXF(), new aa.a() {
                /* class com.tencent.mm.ui.transmit.SendAppMessageWrapperUI.AnonymousClass3 */

                @Override // com.tencent.mm.ak.aa.a
                public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, com.tencent.mm.ak.q qVar) {
                    fcr fcr;
                    AppMethodBeat.i(234507);
                    Log.i("MicroMsg.SendAppMessageWrapperUI", "callback, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                    fcj fcj = (fcj) dVar.iLL.iLR;
                    if (i2 != 0 || i3 != 0 || fcj == null || fcj.Nym == null) {
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            String str2 = (String) it.next();
                            String str3 = SendAppMessageWrapperUI.this.QzY.field_appId;
                            if (!SendAppMessageWrapperUI.this.QAa && SendAppMessageWrapperUI.h(SendAppMessageWrapperUI.this)) {
                                str3 = "";
                            }
                            k.b bVar = new k.b();
                            bVar.appId = str3;
                            bVar.izj = wxaAttributes.field_appId;
                            bVar.eag = wxaAttributes.field_username;
                            bVar.eah = wxaAttributes.field_nickname;
                            bVar.izz = wXMiniProgramObject.miniprogramType;
                            bVar.appName = SendAppMessageWrapperUI.this.QzY.field_appName;
                            bVar.iwL = 2;
                            bVar.izn = sb2;
                            bVar.izk = wXMiniProgramObject.withShareTicket ? 3 : 2;
                            SendAppMessageWrapperUI.b(bVar, wXMediaMessage);
                            SendAppMessageWrapperUI.b(wxaAttributes, bVar, null);
                            com.tencent.mm.pluginsdk.model.app.m.a(bVar, wXMediaMessage, str2, i2, SendAppMessageWrapperUI.i(SendAppMessageWrapperUI.this));
                        }
                    } else {
                        LinkedList<fcr> linkedList = fcj.Nym == null ? new LinkedList<>() : fcj.Nym;
                        Log.i("MicroMsg.SendAppMessageWrapperUI", "get wxaAppShareInfoList size = %d, toUserList size = %d", Integer.valueOf(linkedList.size()), Integer.valueOf(linkedList.size()));
                        for (int i4 = 0; i4 < linkedList.size(); i4++) {
                            if (i4 < linkedList.size()) {
                                fcr = linkedList.get(i4);
                            } else {
                                fcr = new fcr();
                            }
                            k.b bVar2 = new k.b();
                            String str4 = SendAppMessageWrapperUI.this.QzY.field_appId;
                            if (!SendAppMessageWrapperUI.this.QAa && SendAppMessageWrapperUI.h(SendAppMessageWrapperUI.this)) {
                                str4 = "";
                            }
                            bVar2.appId = str4;
                            bVar2.izj = wxaAttributes.field_appId;
                            bVar2.eag = wxaAttributes.field_username;
                            bVar2.eah = wxaAttributes.field_nickname;
                            bVar2.izz = wXMiniProgramObject.miniprogramType;
                            bVar2.appName = SendAppMessageWrapperUI.this.QzY.field_appName;
                            bVar2.iwL = 2;
                            bVar2.izo = fcr.MXx;
                            bVar2.izn = sb2;
                            bVar2.izk = wXMiniProgramObject.withShareTicket ? 3 : 2;
                            SendAppMessageWrapperUI.b(bVar2, wXMediaMessage);
                            SendAppMessageWrapperUI.b(wxaAttributes, bVar2, fcr);
                            com.tencent.mm.pluginsdk.model.app.m.a(bVar2, wXMediaMessage, (String) linkedList.get(i4), i2, SendAppMessageWrapperUI.i(SendAppMessageWrapperUI.this));
                        }
                    }
                    AppMethodBeat.o(234507);
                    return 0;
                }
            });
        } else if (wxaAttributes == null) {
            Log.e("MicroMsg.SendAppMessageWrapperUI", "get wxaAttributes for appbrand without share ticket info failed");
            sendAppMessageWrapperUI.setResult(-1);
            sendAppMessageWrapperUI.finish();
            ReportUtil.a(sendAppMessageWrapperUI, ReportUtil.d(sendAppMessageWrapperUI.getIntent().getExtras(), -1), false);
            AppMethodBeat.o(234527);
            return;
        } else {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                k.b bVar = new k.b();
                String str2 = sendAppMessageWrapperUI.QzY.field_appId;
                if (!sendAppMessageWrapperUI.QAa && sendAppMessageWrapperUI.gYq()) {
                    str2 = "";
                }
                bVar.appId = str2;
                bVar.izj = wxaAttributes.field_appId;
                bVar.izz = wXMiniProgramObject.miniprogramType;
                bVar.appName = sendAppMessageWrapperUI.QzY.field_appName;
                bVar.iwL = 2;
                bVar.izn = sb2;
                bVar.izk = wXMiniProgramObject.withShareTicket ? 3 : 2;
                bVar.eag = wxaAttributes.field_username;
                bVar.eah = wxaAttributes.field_nickname;
                a(wxaAttributes, bVar, (fcr) null);
                a(bVar, wXMediaMessage);
                com.tencent.mm.pluginsdk.model.app.m.a(bVar, wXMediaMessage, str, i2, sendAppMessageWrapperUI.gYr());
            }
        }
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            String str3 = (String) it2.next();
            int i3 = str3.endsWith("chatroom") ? 1 : 0;
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14127, sendAppMessageWrapperUI.QzY.field_appId, wXMiniProgramObject.userName, com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(wXMiniProgramObject.path)), com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(wXMediaMessage.title)), com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(wXMediaMessage.description)), "", com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(wXMiniProgramObject.webpageUrl)), 0, 1, 0, Integer.valueOf(i3), str3, 1, sb.toString(), "");
        }
        AppMethodBeat.o(234527);
    }
}
