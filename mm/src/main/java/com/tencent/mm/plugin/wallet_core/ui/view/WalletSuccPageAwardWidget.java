package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.c.k;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.l;
import com.tencent.mm.plugin.wallet_core.c.n;
import com.tencent.mm.plugin.wallet_core.c.o;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletAwardShakeAnimView;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.aia;
import com.tencent.mm.protocal.protobuf.ake;
import com.tencent.mm.protocal.protobuf.bqa;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.vfs.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.xweb.util.d;
import e.a.a.a;
import e.a.a.c;
import e.a.a.i;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class WalletSuccPageAwardWidget extends FrameLayout {
    private boolean COc = true;
    private c CsF;
    private boolean HPM;
    private ImageView InX;
    private ImageView InY;
    private WalletScratchShakeView InZ;
    private WalletAwardShakeAnimView Ioa;
    private i Iob;
    private WalletBaseUI Ioc;
    private boolean Iod = false;
    private boolean Ioe = false;
    private boolean Iof = false;
    private a Iog = null;
    private boolean Ioh = false;
    private TextView gxs;
    private MMHandler hAk = new MMHandler(Looper.getMainLooper());
    private TextView hPW;
    private CdnImageView qgQ;
    private String qvD;
    private Button ubX;
    private ViewGroup zhm;

    static /* synthetic */ void fUh() {
    }

    public static boolean a(c cVar) {
        AppMethodBeat.i(71569);
        if (cVar == null || ((cVar.Ltm == null || cVar.Ltm.size() <= 0) && cVar.Ubm == null)) {
            AppMethodBeat.o(71569);
            return false;
        }
        AppMethodBeat.o(71569);
        return true;
    }

    public WalletSuccPageAwardWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(71570);
        init(context);
        AppMethodBeat.o(71570);
    }

    public WalletSuccPageAwardWidget(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(71571);
        init(context);
        AppMethodBeat.o(71571);
    }

    private void init(Context context) {
        AppMethodBeat.i(71572);
        aa.jQ(context).inflate(R.layout.ca5, (ViewGroup) this, true);
        this.zhm = (ViewGroup) findViewById(R.id.bex);
        this.qgQ = (CdnImageView) findViewById(R.id.esl);
        this.gxs = (TextView) findViewById(R.id.fti);
        this.hPW = (TextView) findViewById(R.id.bn6);
        this.ubX = (Button) findViewById(R.id.agf);
        this.InZ = (WalletScratchShakeView) findViewById(R.id.hbp);
        this.InX = (ImageView) findViewById(R.id.y1);
        this.Ioa = (WalletAwardShakeAnimView) findViewById(R.id.hp2);
        this.gxs.setTextSize(1, 17.0f);
        this.hPW.setTextSize(1, 14.0f);
        this.ubX.setTextSize(1, 16.0f);
        this.qgQ.setRoundCorner(true);
        this.qgQ.setUseSdcardCache(true);
        AppMethodBeat.o(71572);
    }

    public final void a(WalletBaseUI walletBaseUI, c cVar, String str, boolean z, ImageView imageView) {
        boolean z2 = true;
        AppMethodBeat.i(71573);
        Object[] objArr = new Object[5];
        objArr[0] = b(cVar);
        objArr[1] = Boolean.valueOf(cVar == null || cVar.Ubk == null);
        if (imageView != null) {
            z2 = false;
        }
        objArr[2] = Boolean.valueOf(z2);
        objArr[3] = Boolean.valueOf(this.Iod);
        objArr[4] = Boolean.valueOf(z);
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "setWidgetData, exposureInfo: %s, layerInfo==null: %s, hostUIBackgroundView==null:%s, isClickH5OrTinyApp: %s, isF2F: %s", objArr);
        this.Ioc = walletBaseUI;
        this.CsF = cVar;
        this.HPM = z;
        this.qvD = str;
        this.InY = imageView;
        fTZ();
        AppMethodBeat.o(71573);
    }

    private void fTZ() {
        int i2 = 2;
        AppMethodBeat.i(71574);
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, exposureInfo: %s, isFirstShow: %s", b(this.CsF), Boolean.valueOf(this.COc));
        if (this.CsF == null) {
            Log.e("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, exposureInfo is null!");
            AppMethodBeat.o(71574);
            return;
        }
        Log.printInfoStack("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, user_operation_type: %s, single_exposure_info_list size: %s, isClickH5OrTinyApp: %s", Integer.valueOf(this.CsF.Ubi), Integer.valueOf(this.CsF.Ltm.size()), Boolean.valueOf(this.Iod));
        if (this.CsF.Ubi <= 0 || this.CsF.Ubi > 5) {
            AppMethodBeat.o(71574);
        } else if (!a(this.CsF)) {
            AppMethodBeat.o(71574);
        } else {
            if (this.CsF.Ubi == 4) {
                fUd();
            } else if (this.CsF.Ubi == 1 || this.CsF.Ubi == 2 || this.CsF.Ubi == 3) {
                fUc();
            } else if (this.CsF.Ubi == 5) {
                fUe();
            }
            if (this.COc || this.Iod) {
                h hVar = h.INSTANCE;
                Object[] objArr = new Object[2];
                objArr[0] = 3;
                if (!this.Iod) {
                    i2 = 1;
                }
                objArr[1] = Integer.valueOf(i2);
                hVar.a(15225, objArr);
            }
            this.COc = false;
            AppMethodBeat.o(71574);
        }
    }

    private void fUa() {
        AppMethodBeat.i(71575);
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "showNetFailedView");
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gxs.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hPW.getLayoutParams();
        layoutParams.addRule(15, -1);
        layoutParams2.addRule(15, 0);
        this.gxs.setLayoutParams(layoutParams);
        this.hPW.setLayoutParams(layoutParams2);
        this.gxs.setVisibility(0);
        this.hPW.setVisibility(8);
        this.gxs.setText(R.string.isx);
        this.gxs.setTextColor(getResources().getColor(R.color.a2x));
        this.hPW.setTextColor(getResources().getColor(R.color.uj));
        this.InX.setVisibility(8);
        findViewById(R.id.g5m).setVisibility(0);
        findViewById(R.id.g5n).setVisibility(0);
        this.ubX.setVisibility(8);
        this.qgQ.setVisibility(0);
        this.qgQ.setImageResource(R.drawable.crr);
        this.InZ.setVisibility(8);
        this.InZ.onDestroy();
        this.Ioa.setVisibility(8);
        this.Ioa.destroy();
        AppMethodBeat.o(71575);
    }

    public final void init() {
        AppMethodBeat.i(71576);
        if (this.Ioc != null) {
            Log.i("MicroMsg.WalletSuccPageAwardWidget", APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
            this.Ioc.addSceneEndListener(1859);
            this.Ioc.addSceneEndListener(2547);
            this.Ioc.addSceneEndListener(2803);
            this.Ioc.addSceneEndListener(2508);
            this.Ioc.addSceneEndListener(2529);
            this.Ioc.addSceneEndListener(2888);
        }
        AppMethodBeat.o(71576);
    }

    public final void onDestroy() {
        int i2 = 2;
        AppMethodBeat.i(71577);
        if (this.Ioc != null) {
            this.Ioc.removeSceneEndListener(1859);
            this.Ioc.removeSceneEndListener(2547);
            this.Ioc.removeSceneEndListener(2803);
            this.Ioc.removeSceneEndListener(2508);
            this.Ioc.removeSceneEndListener(2529);
            this.Ioc.removeSceneEndListener(2888);
            Log.i("MicroMsg.WalletSuccPageAwardWidget", "onDestroy, isShakeOrScratch: %s, isClickAwardButton: %s", Boolean.valueOf(this.Ioe), Boolean.valueOf(this.Iof));
            if (!this.Ioe && !this.Iof) {
                h hVar = h.INSTANCE;
                Object[] objArr = new Object[2];
                objArr[0] = 6;
                if (!this.Iod) {
                    i2 = 1;
                }
                objArr[1] = Integer.valueOf(i2);
                hVar.a(15225, objArr);
                Log.i("MicroMsg.WalletSuccPageAwardWidget", "user do nothing and quit ui, call drawlottery");
                this.Ioc.doSceneProgress(new l(this.CsF.LrG, 4, this.HPM), false);
            }
        }
        if (this.InZ != null) {
            this.InZ.onDestroy();
        }
        if (this.Ioa != null) {
            this.Ioa.destroy();
        }
        AppMethodBeat.o(71577);
    }

    public final void onResume() {
        AppMethodBeat.i(71578);
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "onResume, isClickH5OrTinyApp: %s, exposureInfo: %s, isMiniAppReturn: %s", Boolean.valueOf(this.Iod), b(this.CsF), Boolean.valueOf(this.Ioh));
        if (!this.Ioh) {
            this.Ioh = true;
            fUb();
        }
        AppMethodBeat.o(71578);
    }

    private void fUb() {
        AppMethodBeat.i(71579);
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "updateViewAfterMiniAppReturn");
        if (!(this.CsF.Ubm == null || this.CsF.Ubm.NkQ == 1)) {
            this.InZ.setVisibility(8);
            this.InZ.onDestroy();
            this.Ioa.setVisibility(8);
            this.Ioa.destroy();
        }
        fUg();
        AppMethodBeat.o(71579);
    }

    private void fUc() {
        AppMethodBeat.i(71580);
        fUf();
        if (this.Ioa.getVisibility() != 8) {
            this.Ioa.setVisibility(8);
            this.Ioa.destroy();
        }
        if (this.InZ.getVisibility() != 0) {
            this.InZ.setVisibility(0);
            this.InZ.post(new Runnable() {
                /* class com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(71552);
                    if (WalletSuccPageAwardWidget.this.InZ.getHeight() != WalletSuccPageAwardWidget.this.getHeight()) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) WalletSuccPageAwardWidget.this.InZ.getLayoutParams();
                        layoutParams.width = WalletSuccPageAwardWidget.this.zhm.getWidth();
                        layoutParams.height = WalletSuccPageAwardWidget.this.zhm.getHeight();
                        WalletSuccPageAwardWidget.this.InZ.setLayoutParams(layoutParams);
                    }
                    WalletSuccPageAwardWidget.c(WalletSuccPageAwardWidget.this);
                    AppMethodBeat.o(71552);
                }
            });
        }
        AppMethodBeat.o(71580);
    }

    private void fUd() {
        AppMethodBeat.i(71581);
        fUf();
        if (this.InZ.getVisibility() != 8) {
            this.InZ.setVisibility(8);
            this.InZ.onDestroy();
        }
        if (this.Ioa.getVisibility() != 8) {
            this.Ioa.setVisibility(8);
            this.Ioa.destroy();
        }
        AppMethodBeat.o(71581);
    }

    private void fUe() {
        AppMethodBeat.i(71582);
        fUf();
        if (this.InZ.getVisibility() != 8) {
            this.InZ.setVisibility(8);
            this.InZ.onDestroy();
        }
        if (this.CsF.Ubm != null) {
            Log.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, op_type: %s", Integer.valueOf(this.CsF.Ubm.NkQ));
            switch (this.CsF.Ubm.NkQ) {
                case 1:
                    if (this.Ioa.getVisibility() != 0) {
                        this.Ioa.setVisibility(0);
                        this.Ioa.post(new Runnable() {
                            /* class com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.AnonymousClass4 */

                            public final void run() {
                                AppMethodBeat.i(71556);
                                if (WalletSuccPageAwardWidget.this.Ioa.getHeight() != WalletSuccPageAwardWidget.this.getHeight()) {
                                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) WalletSuccPageAwardWidget.this.Ioa.getLayoutParams();
                                    layoutParams.width = WalletSuccPageAwardWidget.this.zhm.getWidth();
                                    layoutParams.height = WalletSuccPageAwardWidget.this.zhm.getHeight() - com.tencent.mm.cb.a.fromDPToPix(WalletSuccPageAwardWidget.this.getContext(), 2);
                                    layoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix(WalletSuccPageAwardWidget.this.getContext(), 1);
                                    layoutParams.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(WalletSuccPageAwardWidget.this.getContext(), 1);
                                    WalletSuccPageAwardWidget.this.Ioa.setLayoutParams(layoutParams);
                                }
                                AppMethodBeat.o(71556);
                            }
                        });
                    }
                    this.Ioa.destroy();
                    if (!Util.isNullOrNil(this.CsF.Ubm.Ubd)) {
                        Log.i("MicroMsg.WalletSuccPageAwardWidget", "animation_wording: %s", this.CsF.Ubm.Ubd);
                        this.Ioa.setShakeHintWording(this.CsF.Ubm.Ubd);
                    }
                    if (!Util.isNullOrNil(this.CsF.Ubm.Ube)) {
                        try {
                            Log.i("MicroMsg.WalletSuccPageAwardWidget", "animation_wording_color: %s", this.CsF.Ubm.Ube);
                            this.Ioa.setShakeHintWordingColor(g.cI(this.CsF.Ubm.Ube, true));
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", e2, "parse animation_wording_color %s error %s", this.CsF.Ubm.Ube, e2.getMessage());
                        }
                    }
                    if (!Util.isNullOrNil(this.CsF.Ubm.Ubf)) {
                        Log.i("MicroMsg.WalletSuccPageAwardWidget", "after_animation_wording: %s", this.CsF.Ubm.Ubf);
                        this.Ioa.setAfterHintWording(this.CsF.Ubm.Ubf);
                    }
                    if (!Util.isNullOrNil(this.CsF.Ubm.Ubg)) {
                        Log.i("MicroMsg.WalletSuccPageAwardWidget", "after_animation_wording_color: %s", this.CsF.Ubm.Ubg);
                        try {
                            this.Ioa.setAfterHintWordingColor(g.cI(this.CsF.Ubm.Ubg, true));
                        } catch (Exception e3) {
                            Log.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", e3, "parse after_animation_wording_color %s error %s", this.CsF.Ubm.Ubg, e3.getMessage());
                        }
                    }
                    this.Ioa.setShakeOrClickCallback(new WalletAwardShakeAnimView.a() {
                        /* class com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.AnonymousClass5 */

                        @Override // com.tencent.mm.plugin.wallet_core.ui.view.WalletAwardShakeAnimView.a
                        public final void yx(boolean z) {
                            AppMethodBeat.i(71557);
                            Log.i("MicroMsg.WalletSuccPageAwardWidget", "onStartShakeOrClick, isShake: %s, isClickH5OrTinyApp: %s", Boolean.valueOf(z), Boolean.valueOf(WalletSuccPageAwardWidget.this.Iod));
                            if (z) {
                                h hVar = h.INSTANCE;
                                Object[] objArr = new Object[2];
                                objArr[0] = 4;
                                objArr[1] = Integer.valueOf(WalletSuccPageAwardWidget.this.Iod ? 2 : 1);
                                hVar.a(15225, objArr);
                            } else {
                                h hVar2 = h.INSTANCE;
                                Object[] objArr2 = new Object[2];
                                objArr2[0] = 7;
                                objArr2[1] = Integer.valueOf(WalletSuccPageAwardWidget.this.Iod ? 2 : 1);
                                hVar2.a(15225, objArr2);
                            }
                            WalletSuccPageAwardWidget.this.Ioa.setShakeHintWording(WalletSuccPageAwardWidget.this.getContext().getString(R.string.isy));
                            WalletSuccPageAwardWidget.this.Ioa.setShakeHintWordingColor(WalletSuccPageAwardWidget.this.getResources().getColor(R.color.l4));
                            WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this, 2, false);
                            WalletSuccPageAwardWidget.this.Ioe = true;
                            AppMethodBeat.o(71557);
                        }
                    });
                    this.Ioa.fTP();
                    AppMethodBeat.o(71582);
                    return;
                case 2:
                    e.a.a.g gVar = this.CsF.Ubm.Ubc;
                    if (gVar != null) {
                        Log.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, jump tiny app, userName: %s, path: %s, version: %s", gVar.MFd, gVar.MFe, Integer.valueOf(gVar.MFf));
                        wq wqVar = new wq();
                        wqVar.ecI.userName = gVar.MFd;
                        wqVar.ecI.ecK = Util.nullAs(gVar.MFe, "");
                        wqVar.ecI.scene = 1060;
                        wqVar.ecI.dCw = this.qvD;
                        wqVar.ecI.ecL = 0;
                        if (gVar.MFf > 0) {
                            wqVar.ecI.appVersion = gVar.MFf;
                        }
                        wqVar.ecI.context = this.Ioc;
                        EventCenter.instance.publish(wqVar);
                        this.Iod = true;
                        this.Ioh = false;
                        this.hAk.postDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.AnonymousClass6 */

                            public final void run() {
                                AppMethodBeat.i(71558);
                                WalletSuccPageAwardWidget.g(WalletSuccPageAwardWidget.this);
                                AppMethodBeat.o(71558);
                            }
                        }, 3000);
                        AppMethodBeat.o(71582);
                        return;
                    }
                    break;
                case 3:
                    Log.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, goto h5, url: %s", this.CsF.Ubm.url);
                    f.p(this.Ioc, this.CsF.Ubm.url, false);
                    this.Iod = true;
                    this.Ioh = false;
                    this.hAk.postDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.AnonymousClass7 */

                        public final void run() {
                            AppMethodBeat.i(71559);
                            WalletSuccPageAwardWidget.g(WalletSuccPageAwardWidget.this);
                            AppMethodBeat.o(71559);
                        }
                    }, 3000);
                    AppMethodBeat.o(71582);
                    return;
                case 4:
                    Log.i("MicroMsg.WalletSuccPageAwardWidget", "setWithNewShakeView, directly show info");
                    this.InZ.setVisibility(8);
                    this.InZ.onDestroy();
                    break;
                default:
                    this.Ioa.setVisibility(8);
                    this.Ioa.destroy();
                    AppMethodBeat.o(71582);
                    return;
            }
            AppMethodBeat.o(71582);
        }
        this.Ioa.setVisibility(8);
        this.Ioa.destroy();
        AppMethodBeat.o(71582);
    }

    private String aVX(String str) {
        AppMethodBeat.i(71583);
        if (!Util.isNullOrNil(new String[0])) {
            s.boN(getAccImagesPath());
            String str2 = getAccImagesPath() + d.getMessageDigest(str.getBytes());
            Log.i("MicroMsg.WalletSuccPageAwardWidget", "buildImagePathByUrl, url: %s, path: %s", str, str2);
            AppMethodBeat.o(71583);
            return str2;
        }
        AppMethodBeat.o(71583);
        return null;
    }

    private void fUf() {
        boolean z;
        AppMethodBeat.i(71584);
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "initBaseLotteryView");
        LinkedList<i> linkedList = this.CsF.Ltm;
        Object[] objArr = new Object[2];
        objArr[0] = linkedList;
        objArr[1] = Integer.valueOf(linkedList != null ? linkedList.size() : 0);
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "singleExposureInfoList %s, size: %s", objArr);
        if (linkedList != null && linkedList.size() > 0) {
            this.Iob = linkedList.get(0);
            Log.i("MicroMsg.WalletSuccPageAwardWidget", "singleExposureInfo %s, award_name: %s, award_description: %s, logo: %s", 0, this.Iob.UbK, this.Iob.UbL, this.Iob.Bah);
            this.qgQ.setUrl(this.Iob.Bah);
            if (!Util.isNullOrNil(this.Iob.Bah)) {
                this.qgQ.setVisibility(0);
            }
            if (!Util.isNullOrNil(this.Iob.UbK)) {
                this.gxs.setText(this.Iob.UbK);
                this.gxs.setVisibility(0);
                try {
                    if (!Util.isNullOrNil(this.Iob.UbN)) {
                        this.gxs.setTextColor(g.cI(this.Iob.UbN, true));
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", e2, "parse award_name_color error: %s", e2.getMessage());
                }
                z = true;
            } else {
                z = false;
            }
            if (!Util.isNullOrNil(this.Iob.UbL)) {
                this.hPW.setText(this.Iob.UbL);
                this.hPW.setVisibility(0);
                try {
                    if (!Util.isNullOrNil(this.Iob.UbO)) {
                        this.hPW.setTextColor(g.cI(this.Iob.UbO, true));
                    }
                } catch (Exception e3) {
                    Log.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", e3, "parse award_description_color error: %s", e3.getMessage());
                }
                z = true;
            }
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gxs.getLayoutParams();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hPW.getLayoutParams();
                if (!Util.isNullOrNil(this.Iob.UbK) && Util.isNullOrNil(this.Iob.UbL)) {
                    layoutParams.addRule(15, -1);
                    layoutParams2.addRule(15, 0);
                    this.gxs.setLayoutParams(layoutParams);
                    this.hPW.setLayoutParams(layoutParams2);
                    this.gxs.setVisibility(0);
                    this.hPW.setVisibility(8);
                } else if (!Util.isNullOrNil(this.Iob.UbK) || Util.isNullOrNil(this.Iob.UbL)) {
                    layoutParams.addRule(15, 0);
                    layoutParams2.addRule(15, 0);
                    this.gxs.setLayoutParams(layoutParams);
                    this.hPW.setLayoutParams(layoutParams2);
                    this.gxs.setVisibility(0);
                    this.hPW.setVisibility(0);
                } else {
                    layoutParams.addRule(15, 0);
                    layoutParams2.addRule(15, -1);
                    this.gxs.setLayoutParams(layoutParams);
                    this.hPW.setLayoutParams(layoutParams2);
                    this.gxs.setVisibility(8);
                    this.hPW.setVisibility(0);
                }
            }
            if (!Util.isNullOrNil(this.Iob.UbM)) {
                Log.i("MicroMsg.WalletSuccPageAwardWidget", "background_img: %s", this.Iob.UbM);
                c.a aVar = new c.a();
                aVar.jbf = true;
                aVar.jbe = true;
                aVar.fullPath = aVX(this.Iob.UbM);
                q.bcV().a(this.Iob.UbM, (ImageView) null, aVar.bdv(), new k() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.AnonymousClass8 */

                    @Override // com.tencent.mm.av.a.c.k
                    public final void a(String str, View view, Bitmap bitmap, Object... objArr) {
                        AppMethodBeat.i(71562);
                        Log.i("MicroMsg.WalletSuccPageAwardWidget", "load background_img finish, url: %s, bitmap: %s", str, bitmap);
                        if (bitmap != null && WalletSuccPageAwardWidget.this.Iob != null && !Util.isNullOrNil(WalletSuccPageAwardWidget.this.Iob.UbM) && WalletSuccPageAwardWidget.this.Iob.UbM.equals(str)) {
                            final NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(WalletSuccPageAwardWidget.this.getResources(), new NinePatch(bitmap, WalletSuccPageAwardWidget.aE(bitmap), "widget_bg"));
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.AnonymousClass8.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(71561);
                                    WalletSuccPageAwardWidget.this.InX.setImageDrawable(ninePatchDrawable);
                                    WalletSuccPageAwardWidget.this.InX.setVisibility(0);
                                    WalletSuccPageAwardWidget.this.InX.post(new Runnable() {
                                        /* class com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.AnonymousClass8.AnonymousClass1.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(71560);
                                            ViewGroup.LayoutParams layoutParams = WalletSuccPageAwardWidget.this.InX.getLayoutParams();
                                            layoutParams.height = WalletSuccPageAwardWidget.this.zhm.getHeight();
                                            layoutParams.width = WalletSuccPageAwardWidget.this.zhm.getWidth();
                                            WalletSuccPageAwardWidget.this.InX.setLayoutParams(layoutParams);
                                            WalletSuccPageAwardWidget.this.findViewById(R.id.g5m).setVisibility(8);
                                            WalletSuccPageAwardWidget.this.findViewById(R.id.g5n).setVisibility(8);
                                            AppMethodBeat.o(71560);
                                        }
                                    });
                                    AppMethodBeat.o(71561);
                                }
                            });
                        }
                        AppMethodBeat.o(71562);
                    }
                });
            } else {
                this.InX.setVisibility(8);
                findViewById(R.id.g5m).setVisibility(0);
                findViewById(R.id.g5n).setVisibility(0);
            }
        }
        Object[] objArr2 = new Object[3];
        objArr2[0] = Integer.valueOf(this.CsF.Ltn);
        objArr2[1] = this.CsF.Lto;
        objArr2[2] = this.CsF.Lto != null ? this.CsF.Lto.UaZ : "";
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "is_show_btn: %s, btn_info: %s, btn_words: %s", objArr2);
        if (this.CsF.Ltn == 0 || this.CsF.Lto == null || Util.isNullOrNil(this.CsF.Lto.UaZ)) {
            this.ubX.setVisibility(8);
        } else {
            a aVar2 = this.CsF.Lto;
            if (aVar2 != null) {
                Log.i("MicroMsg.WalletSuccPageAwardWidget", "btn_words: %s, type: %s, color: %s, url: %s", aVar2.UaZ, Integer.valueOf(aVar2.Ubb), aVar2.Uba, aVar2.url);
                this.ubX.setText(aVar2.UaZ);
                if (!Util.isNullOrNil(aVar2.Uba)) {
                    Drawable drawable = getContext().getResources().getDrawable(R.drawable.k7);
                    drawable.setColorFilter(g.cI(aVar2.Uba, false), PorterDuff.Mode.SRC);
                    this.ubX.setBackground(drawable);
                }
                this.ubX.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.AnonymousClass9 */

                    public final void onClick(View view) {
                        int i2;
                        AppMethodBeat.i(71565);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/view/WalletSuccPageAwardWidget$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (!(WalletSuccPageAwardWidget.this.CsF == null || WalletSuccPageAwardWidget.this.CsF.Lto == null)) {
                            WalletSuccPageAwardWidget.this.Iog = WalletSuccPageAwardWidget.this.CsF.Lto;
                            Log.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, type: %s", Integer.valueOf(WalletSuccPageAwardWidget.this.Iog.Ubb));
                            if (WalletSuccPageAwardWidget.this.Iog.Ubb == 1) {
                                Log.i("MicroMsg.WalletSuccPageAwardWidget", "click btn_info, type: %s, url: %s", Integer.valueOf(WalletSuccPageAwardWidget.this.Iog.Ubb), WalletSuccPageAwardWidget.this.Iog.url);
                                f.p(WalletSuccPageAwardWidget.this.Ioc, WalletSuccPageAwardWidget.this.Iog.url, false);
                                WalletSuccPageAwardWidget.this.Iod = true;
                                WalletSuccPageAwardWidget.this.Iof = true;
                                WalletSuccPageAwardWidget.this.Ioh = false;
                                WalletSuccPageAwardWidget.this.hAk.postDelayed(new Runnable() {
                                    /* class com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.AnonymousClass9.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(71563);
                                        WalletSuccPageAwardWidget.g(WalletSuccPageAwardWidget.this);
                                        AppMethodBeat.o(71563);
                                    }
                                }, 3000);
                            } else if (WalletSuccPageAwardWidget.this.Iog.Ubb == 2) {
                                e.a.a.g gVar = WalletSuccPageAwardWidget.this.Iog.Ubc;
                                if (gVar != null) {
                                    Log.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, jump tiny app, userName: %s, path: %s, version: %s", gVar.MFd, gVar.MFe, Integer.valueOf(gVar.MFf));
                                    wq wqVar = new wq();
                                    wqVar.ecI.userName = gVar.MFd;
                                    wqVar.ecI.ecK = Util.nullAs(gVar.MFe, "");
                                    wqVar.ecI.scene = 1060;
                                    wqVar.ecI.dCw = WalletSuccPageAwardWidget.this.qvD;
                                    wqVar.ecI.ecL = 0;
                                    if (gVar.MFf > 0) {
                                        wqVar.ecI.appVersion = gVar.MFf;
                                    }
                                    wqVar.ecI.context = WalletSuccPageAwardWidget.this.Ioc;
                                    EventCenter.instance.publish(wqVar);
                                    WalletSuccPageAwardWidget.this.Iod = true;
                                    WalletSuccPageAwardWidget.this.Ioh = false;
                                    WalletSuccPageAwardWidget.this.hAk.postDelayed(new Runnable() {
                                        /* class com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.AnonymousClass9.AnonymousClass2 */

                                        public final void run() {
                                            AppMethodBeat.i(71564);
                                            WalletSuccPageAwardWidget.g(WalletSuccPageAwardWidget.this);
                                            AppMethodBeat.o(71564);
                                        }
                                    }, 3000);
                                }
                                WalletSuccPageAwardWidget.this.Iof = true;
                            } else if (WalletSuccPageAwardWidget.this.Iog.Ubb == 3) {
                                Log.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, do get lottery");
                                WalletSuccPageAwardWidget.r(WalletSuccPageAwardWidget.this);
                                WalletSuccPageAwardWidget.this.Iof = true;
                            } else if (WalletSuccPageAwardWidget.this.Iog.Ubb == 5) {
                                Log.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, do nothing");
                            } else if (WalletSuccPageAwardWidget.this.Iog.Ubb == 6) {
                                Log.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, show layer");
                                WalletSuccPageAwardWidget.this.Iof = true;
                            } else if (WalletSuccPageAwardWidget.this.Iog.Ubb == 7) {
                                Log.i("MicroMsg.WalletSuccPageAwardWidget", "click btn, draw lottery");
                                WalletSuccPageAwardWidget.a(WalletSuccPageAwardWidget.this, 3, true);
                                WalletSuccPageAwardWidget.this.Iof = true;
                            } else if (WalletSuccPageAwardWidget.this.Iog.Ubb == 8) {
                                WalletSuccPageAwardWidget.r(WalletSuccPageAwardWidget.this);
                                Log.i("MicroMsg.WalletSuccPageAwardWidget", "click btn_info, type: %s, url: %s", Integer.valueOf(WalletSuccPageAwardWidget.this.Iog.Ubb), WalletSuccPageAwardWidget.this.Iog.url);
                                WalletSuccPageAwardWidget.this.Iof = true;
                            } else if (WalletSuccPageAwardWidget.this.Iog.Ubb == 9) {
                                WalletSuccPageAwardWidget.r(WalletSuccPageAwardWidget.this);
                                WalletSuccPageAwardWidget.this.Iof = true;
                            }
                            h hVar = h.INSTANCE;
                            Object[] objArr = new Object[2];
                            objArr[0] = 2;
                            if (WalletSuccPageAwardWidget.this.Iod) {
                                i2 = 2;
                            } else {
                                i2 = 1;
                            }
                            objArr[1] = Integer.valueOf(i2);
                            hVar.a(15225, objArr);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/view/WalletSuccPageAwardWidget$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(71565);
                    }
                });
                this.ubX.setVisibility(0);
                if (this.COc || this.Iod) {
                    h hVar = h.INSTANCE;
                    Object[] objArr3 = new Object[2];
                    objArr3[0] = 1;
                    objArr3[1] = Integer.valueOf(this.Iod ? 2 : 1);
                    hVar.a(15225, objArr3);
                }
            }
        }
        if (this.gxs.getVisibility() == 0) {
            this.gxs.setSingleLine();
            this.gxs.post(new Runnable() {
                /* class com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.AnonymousClass10 */

                public final void run() {
                    AppMethodBeat.i(71566);
                    try {
                        if (WalletSuccPageAwardWidget.this.ubX.getVisibility() == 0 && WalletSuccPageAwardWidget.this.gxs.getRight() > 0 && WalletSuccPageAwardWidget.this.ubX.getLeft() > 0 && WalletSuccPageAwardWidget.this.gxs.getRight() >= WalletSuccPageAwardWidget.this.ubX.getLeft() && !Util.isNullOrNil(WalletSuccPageAwardWidget.this.gxs.getText())) {
                            float textSize = WalletSuccPageAwardWidget.this.gxs.getTextSize();
                            Log.i("MicroMsg.WalletSuccPageAwardWidget", "nameTv size exceed, nameTv.getRight(): %s, button.getLeft(): %s", Integer.valueOf(WalletSuccPageAwardWidget.this.gxs.getRight()), Integer.valueOf(WalletSuccPageAwardWidget.this.ubX.getLeft()));
                            Paint paint = new Paint();
                            paint.setTextSize(textSize);
                            String charSequence = WalletSuccPageAwardWidget.this.gxs.getText().toString();
                            float left = (float) (WalletSuccPageAwardWidget.this.ubX.getLeft() - WalletSuccPageAwardWidget.this.gxs.getLeft());
                            int i2 = 1;
                            while (paint.measureText(charSequence.substring(0, (charSequence.length() - i2) - 1)) > left && i2 <= charSequence.length() - 1) {
                                i2++;
                            }
                            Log.i("MicroMsg.WalletSuccPageAwardWidget", "nameTv, exceed len, final search count: %s, text.length: %s", Integer.valueOf(i2), Integer.valueOf(charSequence.length()));
                            String substring = charSequence.substring(0, (charSequence.length() - i2) - 1);
                            if (charSequence.length() > 9 && substring.length() < 9) {
                                substring = charSequence.substring(0, 9);
                            }
                            WalletSuccPageAwardWidget.this.gxs.setText(substring);
                            WalletSuccPageAwardWidget.this.gxs.append("...");
                        }
                        AppMethodBeat.o(71566);
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", e2, "calc nameTv len error: %s", e2.getMessage());
                        AppMethodBeat.o(71566);
                    }
                }
            });
        }
        if (this.ubX.getVisibility() != 0) {
            this.gxs.setEllipsize(TextUtils.TruncateAt.END);
        }
        if (this.CsF.Ubj != 0) {
            Log.i("MicroMsg.WalletSuccPageAwardWidget", "exposureInfo.is_show_layer is true: %s, direct show layer", Integer.valueOf(this.CsF.Ubj));
        }
        if (!Util.isNullOrNil(this.CsF.Ubl)) {
            Log.i("MicroMsg.WalletSuccPageAwardWidget", "background_img_whole: %s", this.CsF.Ubl);
            if (this.InY != null) {
                this.InY.setVisibility(0);
                c.a aVar3 = new c.a();
                aVar3.jbf = true;
                aVar3.jbe = true;
                aVar3.fullPath = aVX(this.CsF.Ubl);
                q.bcV().a(this.CsF.Ubl, (ImageView) null, aVar3.bdv(), new k() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.AnonymousClass11 */

                    @Override // com.tencent.mm.av.a.c.k
                    public final void a(String str, View view, final Bitmap bitmap, Object... objArr) {
                        AppMethodBeat.i(71568);
                        Log.i("MicroMsg.WalletSuccPageAwardWidget", "load background_img_whole finish, url: %s, bitmap: %s", str, bitmap);
                        if (bitmap != null && WalletSuccPageAwardWidget.this.CsF != null && !Util.isNullOrNil(WalletSuccPageAwardWidget.this.CsF.Ubl) && WalletSuccPageAwardWidget.this.CsF.Ubl.equals(str)) {
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.AnonymousClass11.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(71567);
                                    WalletSuccPageAwardWidget.this.InY.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                    WalletSuccPageAwardWidget.this.InY.setImageBitmap(bitmap);
                                    AppMethodBeat.o(71567);
                                }
                            });
                        }
                        AppMethodBeat.o(71568);
                    }
                });
            }
        }
        AppMethodBeat.o(71584);
    }

    private void fUg() {
        AppMethodBeat.i(71585);
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "tryDoModifyExposure, isClickH5OrTinyApp: %s", Boolean.valueOf(this.Iod));
        if (this.Iod) {
            this.Ioc.doSceneProgress(new o(this.CsF.Ltl, this.HPM), false);
        }
        AppMethodBeat.o(71585);
    }

    public final boolean onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        int i4;
        int i5;
        e.a.a.g gVar;
        int i6 = 0;
        AppMethodBeat.i(71586);
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", Integer.valueOf(i2), Integer.valueOf(i3), str, qVar);
        if (qVar instanceof n) {
            n nVar = (n) qVar;
            if (i2 == 0 && i3 == 0) {
                bqa bqa = nVar.HPQ;
                if (bqa == null) {
                    Log.e("MicroMsg.WalletSuccPageAwardWidget", "getLottery end, response is null!!");
                    AppMethodBeat.o(71586);
                    return true;
                }
                Log.i("MicroMsg.WalletSuccPageAwardWidget", "getLottery ret_code: %s, ret_msg: %s, alert_wording: %s, exposure_info: %s", Integer.valueOf(bqa.pTZ), bqa.pUa, bqa.LSG, bqa.Iah);
                if (bqa.pTZ != 0) {
                    Log.i("MicroMsg.WalletSuccPageAwardWidget", "getLotteryFailed");
                } else if (!Util.isNullOrNil(bqa.LSG)) {
                    Toast.makeText(getContext(), bqa.LSG, 1).show();
                    AppMethodBeat.o(71586);
                    return true;
                } else {
                    if (bqa.Iah != null) {
                        int i7 = this.CsF.Lto != null ? this.CsF.Lto.Ubb : 0;
                        this.CsF = bqa.Iah;
                        if (!(bqa.Iah.Lto == null || this.CsF.Lto == null)) {
                            Log.i("MicroMsg.WalletSuccPageAwardWidget", "getLottery end, btn_op_type: %s", Integer.valueOf(bqa.Iah.Lto.Ubb));
                            if (bqa.Iah.Lto.Ubb == 4) {
                                Log.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
                                this.CsF.Lto.Ubb = i7;
                            }
                        }
                        Log.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo");
                        fTZ();
                    }
                    if (this.Iog != null && this.Iof) {
                        if (this.Iog.Ubb == 8) {
                            Log.i("MicroMsg.WalletSuccPageAwardWidget", "on getLotteryEnd, btn_op_type==GET_LOTTERY_AND_JUMP_URL, goto h5");
                            f.p(this.Ioc, this.Iog.url, false);
                            this.Iod = true;
                        } else if (this.Iog.Ubb == 9 && (gVar = this.Iog.Ubc) != null) {
                            Log.i("MicroMsg.WalletSuccPageAwardWidget", "on getLotteryEnd, btn_op_type==GET_LOTTERY_AND_JUMP_MINI_APP, jump tiny app, userName: %s, path: %s, version: %s", gVar.MFd, gVar.MFe, Integer.valueOf(gVar.MFf));
                            wq wqVar = new wq();
                            wqVar.ecI.userName = gVar.MFd;
                            wqVar.ecI.ecK = Util.nullAs(gVar.MFe, "");
                            wqVar.ecI.scene = 1060;
                            wqVar.ecI.dCw = this.qvD;
                            wqVar.ecI.ecL = 0;
                            if (gVar.MFf > 0) {
                                wqVar.ecI.appVersion = gVar.MFf;
                            }
                            wqVar.ecI.context = this.Ioc;
                            EventCenter.instance.publish(wqVar);
                            this.Iod = true;
                            this.Ioh = false;
                            this.hAk.postDelayed(new Runnable() {
                                /* class com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.AnonymousClass3 */

                                public final void run() {
                                    AppMethodBeat.i(71555);
                                    WalletSuccPageAwardWidget.g(WalletSuccPageAwardWidget.this);
                                    AppMethodBeat.o(71555);
                                }
                            }, 3000);
                        }
                    }
                    this.Iog = null;
                    AppMethodBeat.o(71586);
                    return true;
                }
            }
            fUa();
            AppMethodBeat.o(71586);
            return true;
        } else if (qVar instanceof o) {
            o oVar = (o) qVar;
            if (i2 == 0 && i3 == 0) {
                ake ake = oVar.HPS;
                if (ake == null) {
                    Log.e("MicroMsg.WalletSuccPageAwardWidget", "modifyExposure end, response is null!!");
                    AppMethodBeat.o(71586);
                    return true;
                }
                Object[] objArr = new Object[6];
                objArr[0] = Integer.valueOf(ake.pTZ);
                objArr[1] = ake.pUa;
                objArr[2] = ake.Ltm;
                objArr[3] = Integer.valueOf(ake.Ltn);
                objArr[4] = ake.Lto;
                objArr[5] = Integer.valueOf(ake.Lto != null ? ake.Lto.Ubb : 0);
                Log.i("MicroMsg.WalletSuccPageAwardWidget", "modifyExposure, ret_code: %s, ret_msg: %s, single_exposure_info_list: %s, is_show_btn: %s, btn_info: %s, btn_op_type: %s", objArr);
                if (ake.pTZ == 0) {
                    this.CsF.Ltm = ake.Ltm;
                    this.CsF.Ltn = ake.Ltn;
                    if (this.CsF.Lto != null) {
                        i5 = this.CsF.Lto.Ubb;
                    } else {
                        i5 = 0;
                    }
                    if (ake.Lto != null) {
                        this.CsF.Lto = ake.Lto;
                        if (this.CsF.Lto != null && ake.Lto.Ubb == 4) {
                            Log.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
                            this.CsF.Lto.Ubb = i5;
                        }
                    }
                    Log.i("MicroMsg.WalletSuccPageAwardWidget", "after modify, exposureInfo: %s", b(this.CsF));
                    fUf();
                }
            }
            this.Iod = false;
            AppMethodBeat.o(71586);
            return true;
        } else if (qVar instanceof l) {
            l lVar = (l) qVar;
            if (i2 == 0 && i3 == 0) {
                aia aia = lVar.HPL;
                if (aia == null) {
                    Log.e("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, response is null!!");
                    AppMethodBeat.o(71586);
                    return true;
                }
                Object[] objArr2 = new Object[4];
                objArr2[0] = Integer.valueOf(aia.pTZ);
                objArr2[1] = aia.pUa;
                objArr2[2] = aia.Iah;
                objArr2[3] = aia.Iah != null ? aia.Iah.Ltm : "";
                Log.i("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, retcode: %s, retmsg: %s, exposure_info: %s, single_exposure_info_list: %s", objArr2);
                if (aia.Iah == null || aia.Iah.Ltm == null || aia.Iah.Ltm.size() <= 0) {
                    fUa();
                } else {
                    Object[] objArr3 = new Object[3];
                    objArr3[0] = aia.Iah;
                    objArr3[1] = aia.Iah.Lto;
                    if (aia.Iah.Lto != null) {
                        i4 = aia.Iah.Lto.Ubb;
                    } else {
                        i4 = 0;
                    }
                    objArr3[2] = Integer.valueOf(i4);
                    Log.i("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, exposureInfo: %s, btninfo: %s, btn_op_type: %s", objArr3);
                    if (this.CsF.Lto != null) {
                        i6 = this.CsF.Lto.Ubb;
                    }
                    this.CsF = aia.Iah;
                    if (!(this.CsF.Lto == null || aia.Iah.Lto == null || aia.Iah.Lto.Ubb != 4)) {
                        Log.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
                        this.CsF.Lto.Ubb = i6;
                    }
                    fTZ();
                }
            } else {
                fUa();
            }
            AppMethodBeat.o(71586);
            return true;
        } else {
            AppMethodBeat.o(71586);
            return false;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        AppMethodBeat.i(71587);
        if (this.InZ != null && this.InZ.getVisibility() == 0) {
            if (this.InZ != null) {
                WalletScratchShakeView walletScratchShakeView = this.InZ;
                if (walletScratchShakeView.Inx != null) {
                    z = walletScratchShakeView.Inx.ae(motionEvent);
                } else {
                    z = false;
                }
                if (z) {
                }
                WalletScratchShakeView walletScratchShakeView2 = this.InZ;
                if (walletScratchShakeView2.Inx != null) {
                    z2 = walletScratchShakeView2.Inx.InR;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    z3 = this.InZ.dispatchTouchEvent(motionEvent);
                }
            }
            if (this.zhm != null && !z3) {
                boolean dispatchTouchEvent = this.zhm.dispatchTouchEvent(motionEvent);
                AppMethodBeat.o(71587);
                return dispatchTouchEvent;
            }
        }
        boolean dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(71587);
        return dispatchTouchEvent2;
    }

    private static String b(e.a.a.c cVar) {
        AppMethodBeat.i(71588);
        if (cVar != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                if (cVar.Ltm != null && cVar.Ltm.size() > 0) {
                    Iterator<i> it = cVar.Ltm.iterator();
                    while (it.hasNext()) {
                        i next = it.next();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("logo", next.Bah);
                        jSONObject2.put("award_name", next.UbK);
                        jSONObject2.put("award_description", next.UbL);
                        jSONObject2.put("background_img", next.UbM);
                        jSONObject2.put("award_name_color", next.UbN);
                        jSONObject2.put("award_description_color", next.UbO);
                        jSONArray.put(jSONObject2);
                    }
                }
                jSONObject.put("single_exposure_info_list", jSONArray);
                jSONObject.put("is_query_others", cVar.Ubh);
                jSONObject.put("draw_lottery_params", cVar.LrG);
                jSONObject.put("is_show_btn", cVar.Ltn);
                JSONObject jSONObject3 = new JSONObject();
                if (cVar.Lto != null) {
                    jSONObject3.put("btn_words", cVar.Lto.UaZ);
                    jSONObject3.put("btn_color", cVar.Lto.Uba);
                    jSONObject3.put("btn_op_type", cVar.Lto.Ubb);
                    jSONObject3.put("url", cVar.Lto.url);
                    JSONObject jSONObject4 = new JSONObject();
                    if (cVar.Lto.Ubc != null) {
                        jSONObject4.put("activity_tinyapp_username", cVar.Lto.Ubc.MFd);
                        jSONObject4.put("activity_tinyapp_path", cVar.Lto.Ubc.MFe);
                        jSONObject4.put("activity_tinyapp_version", cVar.Lto.Ubc.MFf);
                    }
                    jSONObject3.put("mini_app_info", jSONObject4);
                    jSONObject3.put("get_lottery_params", cVar.Lto.LXU);
                }
                jSONObject.put("btn_info", jSONObject3);
                jSONObject.put("exposure_info_modify_params", cVar.Ltl);
                jSONObject.put("user_opertaion_type", cVar.Ubi);
                jSONObject.put("is_show_layer", cVar.Ubj);
                jSONObject.put("background_img_whole", cVar.Ubl);
                if (cVar.Ubm != null) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("animation_wording", cVar.Ubm.Ubd);
                    jSONObject5.put("animation_wording_color", cVar.Ubm.Ube);
                    jSONObject5.put("url", cVar.Ubm.url);
                    jSONObject5.put("op_type", cVar.Ubm.NkQ);
                    jSONObject5.put("after_animation_wording", cVar.Ubm.Ubf);
                    jSONObject5.put("after_animation_wording_color", cVar.Ubm.Ubg);
                    JSONObject jSONObject6 = new JSONObject();
                    if (cVar.Ubm.Ubc != null) {
                        jSONObject6.put("activity_tinyapp_username", cVar.Ubm.Ubc.MFd);
                        jSONObject6.put("activity_tinyapp_path", cVar.Ubm.Ubc.MFe);
                        jSONObject6.put("activity_tinyapp_version", cVar.Ubm.Ubc.MFf);
                    }
                    jSONObject5.put("mini_app_info", jSONObject6);
                    jSONObject.put("draw_lottery_info", jSONObject5);
                }
                String jSONObject7 = jSONObject.toString();
                AppMethodBeat.o(71588);
                return jSONObject7;
            } catch (Exception e2) {
                AppMethodBeat.o(71588);
                return "";
            }
        } else {
            AppMethodBeat.o(71588);
            return "";
        }
    }

    private String getAccImagesPath() {
        AppMethodBeat.i(71589);
        String str = com.tencent.mm.loader.j.b.aKJ() + "wallet/images/";
        AppMethodBeat.o(71589);
        return str;
    }

    static /* synthetic */ void c(WalletSuccPageAwardWidget walletSuccPageAwardWidget) {
        boolean z;
        AppMethodBeat.i(71590);
        boolean z2 = walletSuccPageAwardWidget.CsF.Ubi == 1 || walletSuccPageAwardWidget.CsF.Ubi == 3;
        if (walletSuccPageAwardWidget.CsF.Ubi == 2 || walletSuccPageAwardWidget.CsF.Ubi == 3) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.WalletSuccPageAwardWidget", "initScratchShakeView, canScratch: %s, canShrake: %s", Boolean.valueOf(z2), Boolean.valueOf(z));
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(walletSuccPageAwardWidget.getContext(), 50);
        WalletScratchShakeView walletScratchShakeView = walletSuccPageAwardWidget.InZ;
        float f2 = (float) fromDPToPix;
        int i2 = fromDPToPix / 2;
        Log.i("MicroMsg.WalletScratchShakeView", "init canShake: %s, canScratch: %s", Boolean.valueOf(z), Boolean.valueOf(z2));
        walletScratchShakeView.Inz = z2;
        walletScratchShakeView.Iny = z;
        if (walletScratchShakeView.Inx != null) {
            walletScratchShakeView.removeView(walletScratchShakeView.Inx);
            walletScratchShakeView.Inx = null;
        }
        walletScratchShakeView.Inx = new WalletScratchShakeView.b(walletScratchShakeView.getContext());
        walletScratchShakeView.addView(walletScratchShakeView.Inx, new ViewGroup.LayoutParams(-1, -1));
        WalletScratchShakeView.b bVar = walletScratchShakeView.Inx;
        Log.i("MicroMsg.WalletScratchShakeView", "init inner view");
        bVar.aYz = new Paint();
        bVar.aYz.setAntiAlias(true);
        bVar.aYz.setDither(true);
        Bitmap decodeResource = BitmapFactory.decodeResource(bVar.getResources(), R.drawable.cs2);
        bVar.InC = new NinePatchDrawable(bVar.getResources(), new NinePatch(decodeResource, WalletScratchShakeView.b.aD(decodeResource), "shake_bg"));
        bVar.InD = new Paint();
        bVar.InD.setAntiAlias(true);
        bVar.InD.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        bVar.InD.setStyle(Paint.Style.STROKE);
        bVar.InD.setStrokeCap(Paint.Cap.ROUND);
        bVar.InD.setStrokeWidth(f2);
        bVar.InE = new Paint();
        bVar.InE.setAntiAlias(true);
        bVar.InE.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        bVar.InE.setStyle(Paint.Style.FILL);
        bVar.InE.setStrokeCap(Paint.Cap.ROUND);
        bVar.InF = new Path();
        bVar.InG = new Path();
        bVar.InO = 0.0f;
        bVar.InN = 0.0f;
        bVar.rZ = ViewConfiguration.get(bVar.getContext()).getScaledTouchSlop();
        bVar.InL = false;
        bVar.InM = false;
        bVar.InP = i2;
        if (WalletScratchShakeView.this.Iny) {
            bVar.getContext();
            bVar.shakeSensor = new com.tencent.mm.pluginsdk.l.d();
            bVar.shakeSensor.a(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0155: INVOKE  
                  (wrap: com.tencent.mm.pluginsdk.l.d : 0x014e: IGET  (r2v12 com.tencent.mm.pluginsdk.l.d) = (r0v7 'bVar' com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView$b) com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView.b.shakeSensor com.tencent.mm.pluginsdk.l.d)
                  (wrap: com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView$b$1 : 0x0152: CONSTRUCTOR  (r3v23 com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView$b$1) = (r0v7 'bVar' com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView$b) call: com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView.b.1.<init>(com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView$b):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.pluginsdk.l.d.a(com.tencent.mm.pluginsdk.l.d$a):void in method: com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.c(com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget):void, file: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0152: CONSTRUCTOR  (r3v23 com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView$b$1) = (r0v7 'bVar' com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView$b) call: com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView.b.1.<init>(com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView$b):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.c(com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget):void, file: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 19 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 25 more
                */
            /*
            // Method dump skipped, instructions count: 379
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.c(com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget):void");
        }

        static /* synthetic */ void a(WalletSuccPageAwardWidget walletSuccPageAwardWidget, int i2, boolean z) {
            AppMethodBeat.i(71591);
            Log.i("MicroMsg.WalletSuccPageAwardWidget", "doDrawLottery, is_query_other: %s", Integer.valueOf(walletSuccPageAwardWidget.CsF.Ubh));
            if (walletSuccPageAwardWidget.CsF.Ubh != 0) {
                walletSuccPageAwardWidget.Ioc.doSceneProgress(new l(walletSuccPageAwardWidget.CsF.LrG, i2, walletSuccPageAwardWidget.HPM), z);
            }
            AppMethodBeat.o(71591);
        }

        static /* synthetic */ void g(WalletSuccPageAwardWidget walletSuccPageAwardWidget) {
            AppMethodBeat.i(71592);
            Log.i("MicroMsg.WalletSuccPageAwardWidget", "delayCheckStartMiniApp, isMiniAppReturn: %s", Boolean.valueOf(walletSuccPageAwardWidget.Ioh));
            if (!walletSuccPageAwardWidget.Ioh) {
                walletSuccPageAwardWidget.fUb();
                walletSuccPageAwardWidget.Ioh = true;
            }
            AppMethodBeat.o(71592);
        }

        static /* synthetic */ byte[] aE(Bitmap bitmap) {
            AppMethodBeat.i(71593);
            int[] iArr = {(bitmap.getWidth() / 2) - 3, (bitmap.getWidth() / 2) + 3};
            int[] iArr2 = {(bitmap.getHeight() / 2) - 3, (bitmap.getHeight() / 2) + 3};
            ByteBuffer order = ByteBuffer.allocate(84).order(ByteOrder.nativeOrder());
            order.put((byte) 1);
            order.put((byte) 2);
            order.put((byte) 2);
            order.put((byte) 9);
            order.putInt(0);
            order.putInt(0);
            order.putInt(0);
            order.putInt(0);
            order.putInt(0);
            order.putInt(0);
            order.putInt(0);
            order.putInt(iArr[0]);
            order.putInt(iArr[1]);
            order.putInt(iArr2[0]);
            order.putInt(iArr2[1]);
            for (int i2 = 0; i2 < 9; i2++) {
                order.putInt(1);
            }
            byte[] array = order.array();
            AppMethodBeat.o(71593);
            return array;
        }

        static /* synthetic */ void r(WalletSuccPageAwardWidget walletSuccPageAwardWidget) {
            AppMethodBeat.i(71594);
            walletSuccPageAwardWidget.Ioc.doSceneProgress(new n(walletSuccPageAwardWidget.CsF.Lto.LXU, walletSuccPageAwardWidget.HPM));
            AppMethodBeat.o(71594);
        }
    }
