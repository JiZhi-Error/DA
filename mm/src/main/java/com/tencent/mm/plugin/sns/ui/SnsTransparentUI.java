package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.sns.a.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.pluginsdk.ui.applet.ab;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.pluginsdk.ui.span.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

@a(7)
public class SnsTransparentUI extends MMActivity {
    private Map<String, Bitmap> Eer = new HashMap();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsTransparentUI() {
        AppMethodBeat.i(99457);
        AppMethodBeat.o(99457);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(99458);
        super.onCreate(bundle);
        this.mController.hideTitleView();
        Intent intent = getIntent();
        if (intent != null) {
            switch (intent.getIntExtra("op", -1)) {
                case 2:
                    final String stringExtra = intent.getStringExtra("adlandingXml");
                    final String stringExtra2 = intent.getStringExtra("shareTitle");
                    final String stringExtra3 = intent.getStringExtra("shareThumbUrl");
                    final String stringExtra4 = intent.getStringExtra("shareDesc");
                    final String stringExtra5 = intent.getStringExtra("shareUrl");
                    final String stringExtra6 = intent.getStringExtra("statExtStr");
                    final String stringExtra7 = intent.getStringExtra("uxInfo");
                    final String stringExtra8 = intent.getStringExtra("canvasId");
                    Log.i("SnsTransparentUI", "doTransimt snsAdNativeLadingPagesUI");
                    Log.i("SnsTransparentUI.Share", "uxInfo = " + stringExtra7 + ", canvasId = " + stringExtra8);
                    Intent intent2 = new Intent();
                    intent2.putExtra("Select_Conv_Type", 259);
                    intent2.putExtra("select_is_ret", true);
                    c.a(this, ".ui.transmit.SelectConversationUI", intent2, 0, new MMActivity.a() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsTransparentUI.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.MMActivity.a
                        public final void d(int i2, int i3, Intent intent) {
                            final String stringExtra;
                            AppMethodBeat.i(99455);
                            if (i3 == -1) {
                                if (intent == null) {
                                    stringExtra = null;
                                } else {
                                    stringExtra = intent.getStringExtra("Select_Conv_User");
                                }
                                if (stringExtra == null || stringExtra.length() == 0) {
                                    Log.e("SnsTransparentUI", "mmOnActivityResult fail, toUser is null");
                                    SnsTransparentUI.this.finish();
                                    AppMethodBeat.o(99455);
                                    return;
                                }
                                Log.i("SnsTransparentUI", "doTransimt snsAdNativeLadingPagesUI is ok");
                                final String str = stringExtra;
                                final SnsTransparentUI snsTransparentUI = SnsTransparentUI.this;
                                ab.a.Kgn.a(snsTransparentUI.getController(), stringExtra2, stringExtra3, stringExtra4, true, snsTransparentUI.getResources().getString(R.string.yq), new y.a() {
                                    /* class com.tencent.mm.plugin.sns.ui.SnsTransparentUI.AnonymousClass1.AnonymousClass1 */

                                    @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
                                    public final void a(boolean z, final String str, int i2) {
                                        AppMethodBeat.i(99454);
                                        if (z) {
                                            final WXMediaMessage wXMediaMessage = new WXMediaMessage();
                                            wXMediaMessage.title = stringExtra2;
                                            wXMediaMessage.description = stringExtra4;
                                            WXWebpageObject wXWebpageObject = new WXWebpageObject();
                                            wXWebpageObject.canvasPageXml = str;
                                            wXWebpageObject.webpageUrl = stringExtra5;
                                            wXMediaMessage.mediaObject = wXWebpageObject;
                                            if (SnsTransparentUI.this.Eer.containsKey(stringExtra3)) {
                                                Bitmap bitmap = (Bitmap) SnsTransparentUI.this.Eer.get(stringExtra3);
                                                if (bitmap != null && !bitmap.isRecycled()) {
                                                    Log.i("SnsTransparentUI", "thumb image is not null");
                                                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                                                    wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                                                }
                                                tt ttVar = new tt();
                                                ttVar.eaf.dCE = wXMediaMessage;
                                                ttVar.eaf.toUser = stringExtra;
                                                ttVar.eaf.dMG = 49;
                                                ttVar.eaf.eag = "";
                                                ttVar.eaf.eah = "";
                                                ttVar.eaf.ean = stringExtra6;
                                                EventCenter.instance.publish(ttVar);
                                                if (!TextUtils.isEmpty(str)) {
                                                    tw twVar = new tw();
                                                    twVar.eaq.dkV = stringExtra;
                                                    twVar.eaq.content = str;
                                                    twVar.eaq.type = com.tencent.mm.model.ab.JG(stringExtra);
                                                    twVar.eaq.flags = 0;
                                                    EventCenter.instance.publish(twVar);
                                                }
                                                b.aI(stringExtra, stringExtra7, stringExtra8);
                                                h.cD(snsTransparentUI, snsTransparentUI.getString(R.string.z0));
                                                SnsTransparentUI.this.finish();
                                                AppMethodBeat.o(99454);
                                                return;
                                            }
                                            MD5Util.getMD5String(stringExtra3);
                                            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a("adId", stringExtra3, false, 1000000001, new f.a() {
                                                /* class com.tencent.mm.plugin.sns.ui.SnsTransparentUI.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                                                public final void eWN() {
                                                }

                                                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                                                public final void eWO() {
                                                    AppMethodBeat.i(99452);
                                                    h.cD(snsTransparentUI, snsTransparentUI.getString(R.string.h0j));
                                                    SnsTransparentUI.this.finish();
                                                    AppMethodBeat.o(99452);
                                                }

                                                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                                                public final void aNH(String str) {
                                                    AppMethodBeat.i(99453);
                                                    try {
                                                        Bitmap decodeFile = BitmapUtil.decodeFile(str);
                                                        SnsTransparentUI.this.Eer.put(stringExtra3, decodeFile);
                                                        if (decodeFile != null && !decodeFile.isRecycled()) {
                                                            Log.i("SnsTransparentUI", "thumb image is not null");
                                                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                                            decodeFile.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                                                            wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                                                        }
                                                        tt ttVar = new tt();
                                                        ttVar.eaf.dCE = wXMediaMessage;
                                                        ttVar.eaf.toUser = stringExtra;
                                                        ttVar.eaf.dMG = 49;
                                                        ttVar.eaf.eag = "";
                                                        ttVar.eaf.eah = "";
                                                        ttVar.eaf.ean = stringExtra6;
                                                        EventCenter.instance.publish(ttVar);
                                                        if (!TextUtils.isEmpty(str)) {
                                                            tw twVar = new tw();
                                                            twVar.eaq.dkV = stringExtra;
                                                            twVar.eaq.content = str;
                                                            twVar.eaq.type = com.tencent.mm.model.ab.JG(stringExtra);
                                                            twVar.eaq.flags = 0;
                                                            EventCenter.instance.publish(twVar);
                                                        }
                                                        b.aI(stringExtra, stringExtra7, stringExtra8);
                                                        h.cD(snsTransparentUI, snsTransparentUI.getString(R.string.z0));
                                                        SnsTransparentUI.this.finish();
                                                        AppMethodBeat.o(99453);
                                                    } catch (Exception e2) {
                                                        Log.e("SnsTransparentUI", "this has a error : " + e2.toString());
                                                        SnsTransparentUI.this.finish();
                                                        AppMethodBeat.o(99453);
                                                    }
                                                }
                                            });
                                            AppMethodBeat.o(99454);
                                            return;
                                        }
                                        h.cD(snsTransparentUI, snsTransparentUI.getString(R.string.h0j));
                                        SnsTransparentUI.this.finish();
                                        AppMethodBeat.o(99454);
                                    }
                                });
                                AppMethodBeat.o(99455);
                                return;
                            }
                            SnsTransparentUI.this.finish();
                            AppMethodBeat.o(99455);
                        }
                    });
                    AppMethodBeat.o(99458);
                    return;
                case 4:
                    e.a.KqE.a(this, intent.getStringExtra("phoneNum"), new DialogInterface.OnDismissListener() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsTransparentUI.AnonymousClass2 */

                        public final void onDismiss(DialogInterface dialogInterface) {
                            AppMethodBeat.i(99456);
                            ap.hb(SnsTransparentUI.this);
                            SnsTransparentUI.this.finish();
                            AppMethodBeat.o(99456);
                        }
                    }, new Bundle());
                    break;
            }
        }
        AppMethodBeat.o(99458);
    }
}
