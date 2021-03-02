package com.tencent.mm.plugin.favorite.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.base.stub.d;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.transmit.d;
import com.tencent.mm.vfs.s;

@a(7)
public class FavOpenApiEntry extends MMActivity {
    private String appId;
    private Bundle dQL;
    private Intent dRc;
    private String source;
    private MTimerHandler timer = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.favorite.ui.FavOpenApiEntry.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(24617);
            if (FavOpenApiEntry.this.getWindow() != null && FavOpenApiEntry.this.getWindow().getDecorView() != null && FavOpenApiEntry.this.getWindow().getDecorView().getWindowToken() != null) {
                new d(FavOpenApiEntry.this, FavOpenApiEntry.this.appId, FavOpenApiEntry.this.tnr.openId, new d.a() {
                    /* class com.tencent.mm.plugin.favorite.ui.FavOpenApiEntry.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.base.stub.d.a
                    public final void jZ(boolean z) {
                        AppMethodBeat.i(24616);
                        boolean isFinishing = FavOpenApiEntry.this.isFinishing();
                        Log.i("MicroMsg.FavOpenApiEntry", "onCheckEnd, isPass = " + z + ", isFinishing = " + isFinishing);
                        if (!z || isFinishing) {
                            ReportUtil.a(FavOpenApiEntry.this, ReportUtil.d(FavOpenApiEntry.this.getIntent().getExtras(), -3), false);
                            FavOpenApiEntry.this.finish();
                            AppMethodBeat.o(24616);
                            return;
                        }
                        FavOpenApiEntry.a(FavOpenApiEntry.this, FavOpenApiEntry.this.tnr.message);
                        AppMethodBeat.o(24616);
                    }
                }).cjR();
                AppMethodBeat.o(24617);
                return false;
            } else if (FavOpenApiEntry.this.tnt < 10) {
                FavOpenApiEntry.b(FavOpenApiEntry.this);
                AppMethodBeat.o(24617);
                return true;
            } else {
                AppMethodBeat.o(24617);
                return false;
            }
        }
    }, true);
    private SendMessageToWX.Req tnr;
    private String tns;
    private int tnt = 0;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FavOpenApiEntry() {
        AppMethodBeat.i(24619);
        AppMethodBeat.o(24619);
    }

    static /* synthetic */ int b(FavOpenApiEntry favOpenApiEntry) {
        int i2 = favOpenApiEntry.tnt + 1;
        favOpenApiEntry.tnt = i2;
        return i2;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(24620);
        super.onCreate(bundle);
        if (this.dRc == null) {
            this.dRc = getIntent();
        }
        this.dQL = this.dRc.getExtras();
        this.appId = this.dQL.getString("SendAppMessageWrapper_AppId");
        if (this.appId == null) {
            this.appId = Uri.parse(this.dQL.getString(ConstantsAPI.CONTENT)).getQueryParameter("appid");
        }
        this.tnr = new SendMessageToWX.Req(this.dQL);
        if (this.tnr.scene != 2) {
            Log.e("MicroMsg.FavOpenApiEntry", "scene not WXSceneFavorite!");
            finish();
            AppMethodBeat.o(24620);
            return;
        }
        this.tns = getString(R.string.c8z);
        this.source = getString(R.string.b9a, new Object[]{b.getAppName(this, this.appId)});
        this.timer.startTimer(100);
        AppMethodBeat.o(24620);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(24621);
        super.onNewIntent(intent);
        this.dRc = intent;
        AppMethodBeat.o(24621);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(24622);
        super.onResume();
        AppMethodBeat.o(24622);
    }

    private static void a(WXMediaMessage wXMediaMessage, g gVar) {
        AppMethodBeat.i(24623);
        gVar.field_sourceType = 4;
        gVar.field_favProto.bhd(wXMediaMessage.title);
        gVar.field_favProto.bhe(wXMediaMessage.description);
        AppMethodBeat.o(24623);
    }

    private void L(g gVar) {
        AppMethodBeat.i(24624);
        anh anh = new anh();
        anh.bhl(this.appId);
        anh.ajm(4);
        anh.bhf(z.aTY());
        anh.bhg(z.aTY());
        gVar.field_fromUser = anh.dRL;
        gVar.field_toUser = anh.toUser;
        gVar.field_favProto.a(anh);
        AppMethodBeat.o(24624);
    }

    private static aml a(WXMediaMessage wXMediaMessage, String str, byte[] bArr, int i2) {
        AppMethodBeat.i(24625);
        aml aml = new aml();
        aml.bgf(wXMediaMessage.title);
        aml.bgg(wXMediaMessage.description);
        aml.ajd(i2);
        if (str != null) {
            aml.bgt(str);
            aml.bgp(s.akC(str));
        } else {
            String messageDigest = com.tencent.mm.b.g.getMessageDigest(bArr);
            if (bArr.length >= 256) {
                aml.bgr(messageDigest);
            } else {
                byte[] bArr2 = new byte[256];
                System.arraycopy(bArr, 0, bArr2, 0, 256);
                aml.bgr(com.tencent.mm.b.g.getMessageDigest(bArr2));
            }
            aml.bgq(messageDigest);
            aml.Mu((long) bArr.length);
            aml.bgs(b.ds(aml.toString(), i2));
            s.e(b.d(aml), bArr, bArr.length);
        }
        a(wXMediaMessage, aml, i2);
        AppMethodBeat.o(24625);
        return aml;
    }

    private static void a(WXMediaMessage wXMediaMessage, aml aml, int i2) {
        AppMethodBeat.i(24626);
        if (wXMediaMessage.thumbData != null) {
            String messageDigest = com.tencent.mm.b.g.getMessageDigest(wXMediaMessage.thumbData);
            aml.bgv(messageDigest);
            if (wXMediaMessage.thumbData.length >= 256) {
                aml.bgw(messageDigest);
            } else {
                byte[] bArr = new byte[256];
                System.arraycopy(wXMediaMessage.thumbData, 0, bArr, 0, 256);
                aml.bgw(com.tencent.mm.b.g.getMessageDigest(bArr));
            }
            if (Util.isNullOrNil(aml.dLl)) {
                aml.bgs(b.ds(aml.toString(), i2));
            }
            aml.Mv((long) wXMediaMessage.thumbData.length);
            String a2 = b.a(aml);
            byte[] bArr2 = wXMediaMessage.thumbData;
            s.e(a2, bArr2, bArr2.length);
            AppMethodBeat.o(24626);
            return;
        }
        aml.At(true);
        AppMethodBeat.o(24626);
    }

    private y.a a(final WXMediaMessage wXMediaMessage) {
        AppMethodBeat.i(24627);
        AnonymousClass2 r0 = new y.a() {
            /* class com.tencent.mm.plugin.favorite.ui.FavOpenApiEntry.AnonymousClass2 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
            public final void a(boolean z, String str, int i2) {
                AppMethodBeat.i(24618);
                if (z) {
                    q.a(IntentUtil.getIntExtra(FavOpenApiEntry.this.getIntent(), ConstantsAPI.SDK_VERSION, 0), FavOpenApiEntry.this.appId, wXMediaMessage);
                    FavOpenApiEntry.b(FavOpenApiEntry.this, wXMediaMessage);
                    ReportUtil.a(FavOpenApiEntry.this, ReportUtil.d(FavOpenApiEntry.this.getIntent().getExtras(), 0), false);
                    AppMethodBeat.o(24618);
                    return;
                }
                FavOpenApiEntry.this.finish();
                ReportUtil.a(FavOpenApiEntry.this, ReportUtil.d(FavOpenApiEntry.this.getIntent().getExtras(), 0), true);
                AppMethodBeat.o(24618);
            }
        };
        AppMethodBeat.o(24627);
        return r0;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(24628);
        super.onPause();
        AppMethodBeat.o(24628);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    static /* synthetic */ void a(FavOpenApiEntry favOpenApiEntry, WXMediaMessage wXMediaMessage) {
        com.tencent.mm.ui.widget.a.d a2;
        com.tencent.mm.ui.widget.a.d a3;
        com.tencent.mm.ui.widget.a.d a4;
        com.tencent.mm.ui.widget.a.d a5;
        com.tencent.mm.ui.widget.a.d b2;
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.i(24629);
        if (wXMediaMessage == null) {
            Log.e("MicroMsg.FavOpenApiEntry", "deal fail, WXMediaMessage is null");
            AppMethodBeat.o(24629);
            return;
        }
        int type = wXMediaMessage.getType();
        switch (type) {
            case 1:
                if (!Util.isNullOrNil(((WXTextObject) wXMediaMessage.mediaObject).text)) {
                    favOpenApiEntry.appId.equals("wx4310bbd51be7d979");
                    if (o.a(favOpenApiEntry.mController, wXMediaMessage.description, false, favOpenApiEntry.tns, favOpenApiEntry.a(wXMediaMessage)) != null) {
                        z2 = true;
                        break;
                    }
                } else {
                    Log.e("MicroMsg.FavOpenApiEntry", "dealText null!");
                    break;
                }
                break;
            case 2:
                WXImageObject wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
                if (wXImageObject.imageData != null || s.YS(wXImageObject.imagePath)) {
                    if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                        WXImageObject wXImageObject2 = (WXImageObject) wXMediaMessage.mediaObject;
                        if (wXImageObject2.imageData == null || wXImageObject2.imageData.length <= 0) {
                            b2 = o.b(favOpenApiEntry.mController, wXImageObject2.imagePath, false, favOpenApiEntry.tns, favOpenApiEntry.a(wXMediaMessage));
                        } else {
                            b2 = o.a(favOpenApiEntry.mController, wXImageObject2.imageData, false, favOpenApiEntry.tns, favOpenApiEntry.a(wXMediaMessage));
                        }
                    } else {
                        b2 = o.a(favOpenApiEntry.mController, wXMediaMessage.thumbData, false, favOpenApiEntry.tns, favOpenApiEntry.a(wXMediaMessage));
                    }
                    if (b2 != null) {
                        z2 = true;
                        break;
                    } else {
                        Log.e("MicroMsg.FavOpenApiEntry", "showImgDialog fail, invalid argument");
                        break;
                    }
                }
                break;
            case 3:
                if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                    a5 = o.a(favOpenApiEntry.mController, (int) R.raw.app_attach_file_icon_music, wXMediaMessage.title, false, favOpenApiEntry.tns, favOpenApiEntry.a(wXMediaMessage));
                } else {
                    a5 = o.a(favOpenApiEntry.mController, wXMediaMessage.title, false, 2, favOpenApiEntry.tns, favOpenApiEntry.a(wXMediaMessage));
                }
                if (a5 == null) {
                    z = false;
                }
                z2 = z;
                break;
            case 4:
                if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                    a4 = o.a(favOpenApiEntry.mController, (int) R.raw.app_attach_file_icon_video, wXMediaMessage.title, false, favOpenApiEntry.tns, favOpenApiEntry.a(wXMediaMessage));
                } else {
                    a4 = o.a(favOpenApiEntry.mController, wXMediaMessage.title, false, 1, favOpenApiEntry.tns, favOpenApiEntry.a(wXMediaMessage));
                }
                if (a4 == null) {
                    z = false;
                }
                z2 = z;
                break;
            case 5:
                if (o.a(favOpenApiEntry.mController, wXMediaMessage.title, wXMediaMessage.description, false, favOpenApiEntry.tns, favOpenApiEntry.a(wXMediaMessage)) == null) {
                    z = false;
                }
                z2 = z;
                break;
            case 6:
                if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                    a3 = o.a(favOpenApiEntry.mController, (int) R.raw.app_attach_file_icon_file, wXMediaMessage.title, false, favOpenApiEntry.tns, favOpenApiEntry.a(wXMediaMessage));
                } else {
                    a3 = o.a(favOpenApiEntry.mController, wXMediaMessage.title, false, 0, favOpenApiEntry.tns, favOpenApiEntry.a(wXMediaMessage));
                }
                if (a3 == null) {
                    z = false;
                }
                z2 = z;
                break;
            case 7:
            case 8:
                break;
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
                if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                    a2 = o.a(favOpenApiEntry.mController, (int) R.raw.app_attach_file_icon_music, wXMediaMessage.title, false, favOpenApiEntry.tns, favOpenApiEntry.a(wXMediaMessage));
                } else {
                    a2 = o.a(favOpenApiEntry.mController, wXMediaMessage.title, false, 2, favOpenApiEntry.tns, favOpenApiEntry.a(wXMediaMessage));
                }
                if (a2 == null) {
                    z = false;
                }
                z2 = z;
                break;
            default:
                Log.e("MicroMsg.FavOpenApiEntry", "unknown type = ".concat(String.valueOf(type)));
                break;
        }
        if (!z2) {
            Log.e("MicroMsg.FavOpenApiEntry", "deal fail, result is false finish()");
            favOpenApiEntry.finish();
        }
        AppMethodBeat.o(24629);
    }

    static /* synthetic */ void b(FavOpenApiEntry favOpenApiEntry, final WXMediaMessage wXMediaMessage) {
        AppMethodBeat.i(24630);
        if (wXMediaMessage == null) {
            Log.e("MicroMsg.FavOpenApiEntry", "deal fail, WXMediaMessage is null");
            AppMethodBeat.o(24630);
            return;
        }
        int type = wXMediaMessage.getType();
        switch (type) {
            case 1:
                WXTextObject wXTextObject = (WXTextObject) wXMediaMessage.mediaObject;
                if (!Util.isNullOrNil(wXTextObject.text)) {
                    g gVar = new g();
                    gVar.field_type = 1;
                    a(wXMediaMessage, gVar);
                    gVar.field_favProto.bhe(wXTextObject.text);
                    favOpenApiEntry.L(gVar);
                    com.tencent.mm.plugin.fav.ui.b.C(gVar);
                    break;
                } else {
                    Log.e("MicroMsg.FavOpenApiEntry", "addText null!");
                    break;
                }
            case 2:
                WXImageObject wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
                if (wXImageObject.imageData != null || s.YS(wXImageObject.imagePath)) {
                    g gVar2 = new g();
                    gVar2.field_type = 2;
                    a(wXMediaMessage, gVar2);
                    favOpenApiEntry.L(gVar2);
                    gVar2.field_favProto.ppH.add(a(wXMediaMessage, wXImageObject.imagePath, wXImageObject.imageData, gVar2.field_type));
                    com.tencent.mm.plugin.fav.ui.b.C(gVar2);
                    break;
                }
            case 3:
                WXMusicObject wXMusicObject = (WXMusicObject) wXMediaMessage.mediaObject;
                if (Util.isNullOrNil(wXMusicObject.musicDataUrl) && Util.isNullOrNil(wXMusicObject.musicUrl) && Util.isNullOrNil(wXMusicObject.musicLowBandUrl)) {
                    Log.e("MicroMsg.FavOpenApiEntry", "addMusic, both url null");
                    break;
                } else {
                    g gVar3 = new g();
                    gVar3.field_type = 7;
                    a(wXMediaMessage, gVar3);
                    aml aml = new aml();
                    aml.bgl(wXMusicObject.musicUrl);
                    aml.bgn(wXMusicObject.musicLowBandUrl);
                    aml.bgm(wXMusicObject.musicDataUrl);
                    aml.bgf(wXMediaMessage.title);
                    aml.bgg(wXMediaMessage.description);
                    a(wXMediaMessage, aml, gVar3.field_type);
                    aml.As(true);
                    aml.ajd(gVar3.field_type);
                    aml.bgL(wXMusicObject.songAlbumUrl);
                    aml.bgM(wXMusicObject.songLyric);
                    gVar3.field_favProto.ppH.add(aml);
                    favOpenApiEntry.L(gVar3);
                    com.tencent.mm.plugin.fav.ui.b.C(gVar3);
                    break;
                }
            case 4:
                WXVideoObject wXVideoObject = (WXVideoObject) wXMediaMessage.mediaObject;
                if (Util.isNullOrNil(wXVideoObject.videoLowBandUrl) && Util.isNullOrNil(wXVideoObject.videoUrl)) {
                    Log.e("MicroMsg.FavOpenApiEntry", "addVideo, both url null");
                    break;
                } else {
                    g gVar4 = new g();
                    gVar4.field_type = 4;
                    a(wXMediaMessage, gVar4);
                    aml aml2 = new aml();
                    aml2.bgl(wXVideoObject.videoUrl);
                    aml2.bgn(wXVideoObject.videoLowBandUrl);
                    aml2.bgf(wXMediaMessage.title);
                    aml2.bgg(wXMediaMessage.description);
                    a(wXMediaMessage, aml2, gVar4.field_type);
                    aml2.As(true);
                    aml2.ajd(gVar4.field_type);
                    gVar4.field_favProto.ppH.add(aml2);
                    favOpenApiEntry.L(gVar4);
                    com.tencent.mm.plugin.fav.ui.b.C(gVar4);
                    break;
                }
                break;
            case 5:
                WXWebpageObject wXWebpageObject = (WXWebpageObject) wXMediaMessage.mediaObject;
                if (!Util.isNullOrNil(wXWebpageObject.webpageUrl)) {
                    g gVar5 = new g();
                    gVar5.field_sessionId = favOpenApiEntry.getIntent().getStringExtra("reportSessionId");
                    gVar5.field_type = 5;
                    a(wXMediaMessage, gVar5);
                    favOpenApiEntry.L(gVar5);
                    gVar5.field_favProto.Lya.bhm(wXWebpageObject.webpageUrl);
                    if (wXMediaMessage.thumbData != null) {
                        aml aml3 = new aml();
                        aml3.bgf(wXMediaMessage.title);
                        aml3.bgg(wXMediaMessage.description);
                        a(wXMediaMessage, aml3, gVar5.field_type);
                        aml3.As(true);
                        aml3.ajd(gVar5.field_type);
                        gVar5.field_favProto.ppH.add(aml3);
                    }
                    com.tencent.mm.plugin.fav.ui.b.C(gVar5);
                    break;
                } else {
                    Log.e("MicroMsg.FavOpenApiEntry", "addUrl null!");
                    break;
                }
            case 6:
                WXFileObject wXFileObject = (WXFileObject) wXMediaMessage.mediaObject;
                if (wXFileObject.fileData == null && !s.YS(wXFileObject.filePath)) {
                    Log.e("MicroMsg.FavOpenApiEntry", "addFile data null");
                    break;
                } else {
                    g gVar6 = new g();
                    gVar6.field_type = 8;
                    a(wXMediaMessage, gVar6);
                    favOpenApiEntry.L(gVar6);
                    gVar6.field_favProto.ppH.add(a(wXMediaMessage, wXFileObject.filePath, wXFileObject.fileData, gVar6.field_type));
                    com.tencent.mm.plugin.fav.ui.b.C(gVar6);
                    break;
                }
                break;
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
                final WXMusicVideoObject wXMusicVideoObject = (WXMusicVideoObject) wXMediaMessage.mediaObject;
                if (!Util.isNullOrNil(wXMusicVideoObject.musicUrl) || !Util.isNullOrNil(wXMusicVideoObject.musicDataUrl)) {
                    if (!Util.isNullOrNil(wXMusicVideoObject.hdAlbumThumbFilePath)) {
                        com.tencent.mm.ui.transmit.d.a(wXMusicVideoObject.hdAlbumThumbFilePath, new d.a() {
                            /* class com.tencent.mm.plugin.favorite.ui.FavOpenApiEntry.AnonymousClass3 */

                            @Override // com.tencent.mm.ui.transmit.d.a
                            public final void be(String str, boolean z) {
                                AppMethodBeat.i(231717);
                                if (z) {
                                    wXMediaMessage.mediaObject = wXMusicVideoObject;
                                    FavOpenApiEntry.a(FavOpenApiEntry.this, wXMediaMessage, str);
                                    AppMethodBeat.o(231717);
                                    return;
                                }
                                Log.e("MicroMsg.FavOpenApiEntry", "thumb img CDN upload fail!");
                                ReportUtil.a(FavOpenApiEntry.this, ReportUtil.d(FavOpenApiEntry.this.getIntent().getExtras(), -1), false);
                                FavOpenApiEntry.this.finish();
                                AppMethodBeat.o(231717);
                            }
                        });
                        break;
                    }
                } else {
                    Log.e("MicroMsg.FavOpenApiEntry", "addMusic, both url null");
                    break;
                }
                break;
            default:
                Log.e("MicroMsg.FavOpenApiEntry", "unsupport type = ".concat(String.valueOf(type)));
                break;
        }
        favOpenApiEntry.finish();
        AppMethodBeat.o(24630);
    }

    static /* synthetic */ void a(FavOpenApiEntry favOpenApiEntry, WXMediaMessage wXMediaMessage, String str) {
        AppMethodBeat.i(231718);
        WXMusicVideoObject wXMusicVideoObject = (WXMusicVideoObject) wXMediaMessage.mediaObject;
        g gVar = new g();
        gVar.field_type = 21;
        a(wXMediaMessage, gVar);
        aml aml = new aml();
        aml.bgf(wXMediaMessage.title);
        aml.bgg(wXMediaMessage.description);
        a(wXMediaMessage, aml, gVar.field_type);
        aml.As(true);
        aml.ajd(gVar.field_type);
        aml.bgl(wXMusicVideoObject.musicUrl);
        aml.bgm(wXMusicVideoObject.musicDataUrl);
        aml.bgL(str);
        aml.bgM(wXMusicVideoObject.songLyric);
        css css = new css();
        css.singerName = wXMusicVideoObject.singerName;
        css.albumName = wXMusicVideoObject.albumName;
        css.musicGenre = wXMusicVideoObject.musicGenre;
        css.issueDate = wXMusicVideoObject.issueDate;
        css.identification = wXMusicVideoObject.identification;
        css.Alz = wXMusicVideoObject.duration;
        css.extraInfo = wXMediaMessage.messageExt;
        amm amm = new amm();
        amm.e(css);
        aml.a(amm);
        gVar.field_favProto.ppH.add(aml);
        favOpenApiEntry.L(gVar);
        com.tencent.mm.plugin.fav.ui.b.C(gVar);
        AppMethodBeat.o(231718);
    }
}
