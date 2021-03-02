package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.qa;
import com.tencent.mm.g.a.ti;
import com.tencent.mm.g.a.tj;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.g.b.a.ks;
import com.tencent.mm.g.b.a.nr;
import com.tencent.mm.kernel.i;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.network.p;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.box.BaseBoxDialogView;
import com.tencent.mm.plugin.scanner.box.g;
import com.tencent.mm.plugin.scanner.box.l;
import com.tencent.mm.plugin.scanner.d.a;
import com.tencent.mm.plugin.scanner.f.a;
import com.tencent.mm.plugin.scanner.f.d;
import com.tencent.mm.plugin.scanner.f.e;
import com.tencent.mm.plugin.scanner.model.ad;
import com.tencent.mm.plugin.scanner.model.af;
import com.tencent.mm.plugin.scanner.model.ag;
import com.tencent.mm.plugin.scanner.model.ah;
import com.tencent.mm.plugin.scanner.model.f;
import com.tencent.mm.plugin.scanner.model.w;
import com.tencent.mm.plugin.scanner.model.z;
import com.tencent.mm.plugin.scanner.ui.ScanUIRectView;
import com.tencent.mm.plugin.scanner.ui.component.ScanUITopOpButtonComponent;
import com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanGoodsMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanDebugView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanInfoMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanScrollTabView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.b;
import com.tencent.mm.plugin.scanner.util.j;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.plugin.scanner.util.r;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.plugin.scanner.view.a;
import com.tencent.mm.plugin.scanner.view.c;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.protobuf.chc;
import com.tencent.mm.protocal.protobuf.mu;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.qbar.ScanDecodeFrameData;
import com.tencent.qbar.WxQBarResult;
import com.tencent.tavkit.component.TAVExporter;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;

@i
@a(3)
public class BaseScanUI extends MMSecDataActivity implements d.a, f, c {
    private boolean CAH;
    private boolean CAI;
    private mu CAV;
    private ScanSharedMaskView CGE;
    private ScanInfoMaskView CGF;
    private boolean CGP = true;
    private com.tencent.mm.plugin.scanner.box.i CIq = null;
    private boolean CJA;
    private boolean CJB;
    private boolean CJC;
    private BaseScanRequest CJD;
    private boolean CJE;
    private boolean CJF = false;
    private boolean CJG = true;
    private boolean CJH = true;
    private ad CJI = new ad();
    private boolean CJJ = true;
    private nr CJK = new nr();
    private int CJL;
    private boolean CJM = false;
    private boolean CJN = false;
    private boolean CJO = false;
    private ScanUIRectView.a CJP = new ScanUIRectView.a() {
        /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.scanner.ui.ScanUIRectView.a
        public final void e(final long j2, final Bundle bundle) {
            AppMethodBeat.i(51682);
            if (!BaseScanUI.this.CJG) {
                Log.w("MicroMsg.ScanUI", "alvinluo onScanSuccess can not process code result currentMode: %d", Integer.valueOf(BaseScanUI.this.zTQ));
                AppMethodBeat.o(51682);
                return;
            }
            if (!(BaseScanUI.this.CJm == null || bundle == null)) {
                Log.i("MicroMsg.ScanUI", "scan code cost time: %d", Long.valueOf(System.currentTimeMillis() - BaseScanUI.this.CJs));
                final ArrayList parcelableArrayList = bundle.getParcelableArrayList("result_qbar_result_list");
                if (parcelableArrayList == null || parcelableArrayList.size() <= 0) {
                    Log.w("MicroMsg.ScanUI", "alvinluo onScanSuccess qbarResult invalid");
                    AppMethodBeat.o(51682);
                    return;
                }
                final int i2 = bundle.getInt("result_code_point_count", 0);
                long j3 = bundle.getLong("decode_success_cost_time", 0);
                af.a(BaseScanUI.this.zTQ, true, 1, i2);
                BaseScanUI.e(BaseScanUI.this);
                BaseScanUI.a(BaseScanUI.this, i2 > 1);
                BaseScanUI.b(BaseScanUI.this, false);
                af.a(BaseScanUI.this.zTQ, parcelableArrayList, j3);
                boolean z = BaseScanUI.this.CJh.VC;
                final WxQBarResult wxQBarResult = (WxQBarResult) parcelableArrayList.get(0);
                if (!BaseScanUI.this.CJB) {
                    bundle.putInt("qbar_string_scan_source", 0);
                    if (i2 <= 0 || BaseScanUI.this.CJg == null) {
                        BaseScanUI.b(BaseScanUI.this, true);
                        BaseScanUI.a(BaseScanUI.this, j2, bundle, wxQBarResult);
                    } else {
                        ScanDecodeFrameData scanDecodeFrameData = (ScanDecodeFrameData) bundle.getParcelable("decode_success_frame_data");
                        if (scanDecodeFrameData != null) {
                            BaseScanUI.this.CJg.setDecodeSuccessFrameData(scanDecodeFrameData);
                        }
                        BaseScanUI.this.CJN = i2 > 1;
                        if (i2 > 1) {
                            BaseScanUI.this.CJk.tZ(false);
                            BaseScanUI.this.CJk.b(true, null);
                            BaseScanUI.j(BaseScanUI.this);
                        }
                        BaseScanUI.this.CJF = true;
                        BaseScanUI.this.CJg.setSuccessMarkClickListener(new ag() {
                            /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass1.AnonymousClass1 */

                            @Override // com.tencent.mm.plugin.scanner.model.ag
                            public final void WK(int i2) {
                                AppMethodBeat.i(169958);
                                Log.i("MicroMsg.ScanUI", "alvinluo onScanSuccess onClick mark index: %d", Integer.valueOf(i2));
                                if (i2 < parcelableArrayList.size() && i2 > 1) {
                                    BaseScanUI.this.CJF = false;
                                    BaseScanUI.a(BaseScanUI.this, j2, bundle, (WxQBarResult) parcelableArrayList.get(i2));
                                    af.ib(2, i2);
                                    af.eQn();
                                }
                                AppMethodBeat.o(169958);
                            }
                        });
                        BaseScanUI.k(BaseScanUI.this);
                        BaseScanUI.l(BaseScanUI.this);
                        BaseScanUI.m(BaseScanUI.this);
                        ScanUIRectView scanUIRectView = BaseScanUI.this.CJg;
                        if (com.tencent.mm.plugin.scanner.util.d.eRT()) {
                            if (scanUIRectView.CNk == null) {
                                scanUIRectView.CNk = new ScanDebugView(scanUIRectView.getContext());
                                scanUIRectView.addView(scanUIRectView.CNk);
                            }
                            if (scanUIRectView.CNk != null) {
                                ScanDebugView scanDebugView = scanUIRectView.CNk;
                                if (bundle != null) {
                                    String string = bundle.getString("decode_debug_string");
                                    String str = string;
                                    if (!(str == null || str.length() == 0)) {
                                        scanDebugView.setVisibility(0);
                                        TextView textView = scanDebugView.zUR;
                                        if (textView == null) {
                                            p.btv("debugInfo");
                                        }
                                        textView.setText(string);
                                    } else {
                                        scanDebugView.setVisibility(8);
                                        TextView textView2 = scanDebugView.zUR;
                                        if (textView2 == null) {
                                            p.btv("debugInfo");
                                        }
                                        textView2.setText("");
                                    }
                                }
                            }
                        }
                        BaseScanUI.this.CJg.a(parcelableArrayList, new com.tencent.mm.plugin.scanner.view.d() {
                            /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass1.AnonymousClass2 */

                            @Override // com.tencent.mm.plugin.scanner.view.d
                            public final void eQG() {
                                AppMethodBeat.i(169959);
                                if (i2 == 1 || parcelableArrayList.size() == 1) {
                                    BaseScanUI.this.CJF = false;
                                    BaseScanUI.a(BaseScanUI.this, j2, bundle, wxQBarResult);
                                    af.ib(1, 0);
                                }
                                AppMethodBeat.o(169959);
                            }
                        }, z);
                        AppMethodBeat.o(51682);
                        return;
                    }
                } else if (wxQBarResult == null) {
                    Log.w("MicroMsg.ScanUI", "first Qbar result is null");
                    AppMethodBeat.o(51682);
                    return;
                } else {
                    String str2 = wxQBarResult.typeName;
                    qa qaVar = new qa();
                    String str3 = wxQBarResult.data;
                    qaVar.dWj.scanResult = str3;
                    qaVar.dWj.dWl = str2;
                    qaVar.dWj.cSx = 0;
                    EventCenter.instance.publish(qaVar);
                    Intent intent = new Intent();
                    intent.putExtra("key_scan_result", str3);
                    intent.putExtra("key_scan_result_raw", wxQBarResult.rawData);
                    intent.putExtra("key_scan_result_code_name", str2);
                    intent.putExtra("key_scan_result_code_version", wxQBarResult.RJN);
                    BaseScanUI.this.setResult(-1, intent);
                    BaseScanUI.this.cvn();
                    AppMethodBeat.o(51682);
                    return;
                }
            }
            AppMethodBeat.o(51682);
        }
    };
    private a.c CJQ = new a.c() {
        /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass23 */

        @Override // com.tencent.mm.plugin.scanner.ui.ScanUIRectView.a
        public final void e(long j2, Bundle bundle) {
            AppMethodBeat.i(51709);
            if (BaseScanUI.this.CJo) {
                Log.w("MicroMsg.ScanUI", "alvinluo onScanSuccess isScrolling and ignore");
                AppMethodBeat.o(51709);
                return;
            }
            if (!(BaseScanUI.this.CJm == null || bundle == null)) {
                BaseScanUI.o(BaseScanUI.this);
                int i2 = bundle.getInt("scan_source", 0);
                Log.i("MicroMsg.ScanUI", "alvinluo onScanSuccess cost time %d, scanImageCount: %d, source: %d, session: %d", Long.valueOf(System.currentTimeMillis() - BaseScanUI.this.CJs), Integer.valueOf(BaseScanUI.this.CJL), Integer.valueOf(i2), Long.valueOf(j2));
                if (i2 == 1 && !BaseScanUI.this.CJF) {
                    if (BaseScanUI.this.CJD instanceof ScanGoodsRequest) {
                        bundle.putParcelable("key_scan_request", BaseScanUI.this.CJD);
                        bundle.putInt("key_scan_goods_mode", ((ScanGoodsRequest) BaseScanUI.this.CJD).mode);
                    }
                    BaseScanUI.this.CJm.c(j2, bundle);
                    AppMethodBeat.o(51709);
                    return;
                } else if (i2 == 2) {
                    if (BaseScanUI.this.CJD instanceof ScanGoodsRequest) {
                        bundle.putParcelable("key_scan_request", BaseScanUI.this.CJD);
                    }
                    BaseScanUI.this.CJm.c(j2, bundle);
                }
            }
            AppMethodBeat.o(51709);
        }

        @Override // com.tencent.mm.plugin.scanner.d.a.c
        public final void H(long j2, String str) {
            AppMethodBeat.i(51710);
            Log.e("MicroMsg.ScanUI", "alvinluo onScanFailed session: %d, source: %d, errCode: %d, errMsg: %s", Long.valueOf(j2), 2, 1, str);
            if (Util.isNullOrNil(str)) {
                str = BaseScanUI.this.getResources().getString(R.string.geb);
            }
            h.a(BaseScanUI.this, str, "", BaseScanUI.this.getResources().getString(R.string.x_), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass23.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(51708);
                    BaseScanUI.s(BaseScanUI.this);
                    af.WE(BaseScanUI.this.zTQ);
                    AppMethodBeat.o(51708);
                }
            });
            af.a(2, false, System.currentTimeMillis());
            AppMethodBeat.o(51710);
        }
    };
    private a.AbstractC1671a CJR = new a.AbstractC1671a() {
        /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass27 */

        @Override // com.tencent.mm.plugin.scanner.f.a.AbstractC1671a
        public final void b(z zVar) {
            AppMethodBeat.i(51718);
            if (BaseScanUI.this.zTQ != 12) {
                Log.i("MicroMsg.ScanUI", "alvnluo onScanResultSuccess not SELECT_SCAN_MODE_GOODS and ignore");
                AppMethodBeat.o(51718);
            } else if (BaseScanUI.this.CJo || (zVar.source == 1 && BaseScanUI.this.CJF)) {
                Log.e("MicroMsg.ScanUI", "alvinluo onScanResultSuccess source:%d, isScrolling: %b or needPauseScan: %b and ignore", Integer.valueOf(zVar.source), Boolean.valueOf(BaseScanUI.this.CJo), Boolean.valueOf(BaseScanUI.this.CJF));
                AppMethodBeat.o(51718);
            } else {
                BaseScanUI.a(BaseScanUI.this, zVar);
                AppMethodBeat.o(51718);
            }
        }

        @Override // com.tencent.mm.plugin.scanner.f.a.AbstractC1671a
        public final void b(int i2, long j2, int i3, String str) {
            AppMethodBeat.i(161970);
            if (i2 == 2) {
                af.T(false, i2);
                BaseScanUI.t(BaseScanUI.this);
                BaseScanUI.e(BaseScanUI.this);
                BaseScanUI.this.CJg.b(false, (DialogInterface.OnCancelListener) null);
                if (Util.isNullOrNil(str)) {
                    str = BaseScanUI.this.getResources().getString(R.string.geb);
                }
                h.a(BaseScanUI.this, str, "", BaseScanUI.this.getResources().getString(R.string.x_), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass27.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(51717);
                        BaseScanUI.s(BaseScanUI.this);
                        af.WE(BaseScanUI.this.zTQ);
                        AppMethodBeat.o(51717);
                    }
                });
                AppMethodBeat.o(161970);
                return;
            }
            if (i2 == 1 && i3 == 1003) {
                Log.e("MicroMsg.ScanUI", "alvinluo onScanResultFailed stop upload and show alert");
                if (BaseScanUI.this.CJm != null) {
                    BaseScanUI.this.CJm.F(j2, false);
                }
                BaseScanUI.t(BaseScanUI.this);
                BaseScanUI.e(BaseScanUI.this);
                if (Util.isNullOrNil(str)) {
                    str = BaseScanUI.this.getResources().getString(R.string.gec);
                }
                h.a(BaseScanUI.this, str, "", BaseScanUI.this.getResources().getString(R.string.x_), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass27.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(161969);
                        BaseScanUI.s(BaseScanUI.this);
                        af.WE(BaseScanUI.this.zTQ);
                        AppMethodBeat.o(161969);
                    }
                });
            }
            AppMethodBeat.o(161970);
        }

        @Override // com.tencent.mm.plugin.scanner.f.a.AbstractC1671a
        public final void a(int i2, long j2, int i3) {
            AppMethodBeat.i(240738);
            Log.i("MicroMsg.ScanUI", "notifyEvent source: %d, session: %d, event: %d", Integer.valueOf(i2), Long.valueOf(j2), 1);
            BaseScanUI.u(BaseScanUI.this);
            AppMethodBeat.o(240738);
        }
    };
    private g CJS = new g() {
        /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass29 */

        @Override // com.tencent.mm.plugin.scanner.box.g
        public final void onShow(DialogInterface dialogInterface) {
            AppMethodBeat.i(240739);
            Log.i("MicroMsg.ScanUI", "alvinluo ScanBoxDialog onShow");
            BaseScanUI.this.CJk.ua(false);
            BaseScanUI.e(BaseScanUI.this, false);
            af.Iy(System.currentTimeMillis());
            AppMethodBeat.o(240739);
        }

        @Override // com.tencent.mm.plugin.scanner.box.g
        public final void a(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(240740);
            Log.i("MicroMsg.ScanUI", "alvinluo ScanBoxDialog onDismiss exitType: %d", Integer.valueOf(i2));
            BaseScanUI.this.CJH = true;
            BaseScanUI.this.CJw = true;
            BaseScanUI.this.CJk.ua(true);
            BaseScanUI.s(BaseScanUI.this);
            BaseScanUI.e(BaseScanUI.this, true);
            af.Iz(System.currentTimeMillis());
            af.a(BaseScanUI.this.CJl, i2, BaseScanUI.this.CJD);
            af.WE(12);
            AppMethodBeat.o(240740);
        }

        @Override // com.tencent.mm.plugin.scanner.box.g
        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(240741);
            Log.i("MicroMsg.ScanUI", "alvinluo ScanBoxDialog onCancel");
            BaseScanUI.this.CJF = false;
            BaseScanUI.this.CJH = true;
            BaseScanUI.this.CJw = true;
            AppMethodBeat.o(240741);
        }
    };
    private com.tencent.mm.network.p CJT = new p.a() {
        /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass13 */

        {
            AppMethodBeat.i(169972);
            AppMethodBeat.o(169972);
        }

        @Override // com.tencent.mm.network.p
        public final void onNetworkChange(final int i2) {
            AppMethodBeat.i(240729);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass13.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(240728);
                    boolean L = BaseScanUI.L(BaseScanUI.this);
                    Log.i("MicroMsg.ScanUI", "onNetWorkChange %d, canResume: %b", Integer.valueOf(com.tencent.mm.kernel.g.azz().aYS()), Boolean.valueOf(L));
                    if (BaseScanUI.this.CJg != null) {
                        ScanUIRectView scanUIRectView = BaseScanUI.this.CJg;
                        int i2 = i2;
                        if (com.tencent.mm.kernel.g.azz().aYS() == 6 || com.tencent.mm.kernel.g.azz().aYS() == 4) {
                            scanUIRectView.CJv = true;
                            if (!r.Xd(scanUIRectView.mode) && L) {
                                scanUIRectView.onResume();
                            }
                        } else {
                            scanUIRectView.CJv = false;
                            if (!r.Xd(scanUIRectView.mode)) {
                                scanUIRectView.onPause();
                            }
                        }
                        if (scanUIRectView.CGD != null) {
                            scanUIRectView.CGD.onNetworkChange(i2);
                        }
                        if (scanUIRectView.CGE != null) {
                            ScanSharedMaskView scanSharedMaskView = scanUIRectView.CGE;
                            scanSharedMaskView.eQC();
                            scanSharedMaskView.WY(scanSharedMaskView.CSG);
                        }
                    }
                    if (com.tencent.mm.kernel.g.azz().aYS() == 6 || com.tencent.mm.kernel.g.azz().aYS() == 4) {
                        if (BaseScanUI.this.CJv) {
                            AppMethodBeat.o(240728);
                            return;
                        }
                        BaseScanUI.this.CJv = true;
                        BaseScanUI.N(BaseScanUI.this);
                        AppMethodBeat.o(240728);
                    } else if (!BaseScanUI.this.CJv) {
                        AppMethodBeat.o(240728);
                    } else {
                        BaseScanUI.this.CJv = false;
                        BaseScanUI.N(BaseScanUI.this);
                        AppMethodBeat.o(240728);
                    }
                }
            });
            AppMethodBeat.o(240729);
        }
    };
    private IListener CJU = new IListener<ti>() {
        /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass14 */

        {
            AppMethodBeat.i(240730);
            this.__eventId = ti.class.getName().hashCode();
            AppMethodBeat.o(240730);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ti tiVar) {
            AppMethodBeat.i(240731);
            ti tiVar2 = tiVar;
            if (BaseScanUI.O(BaseScanUI.this) && BaseScanUI.this.CJw) {
                if (tiVar2.dZN.dZO) {
                    BaseScanUI.k(BaseScanUI.this, true);
                } else {
                    BaseScanUI.k(BaseScanUI.this, false);
                }
            }
            AppMethodBeat.o(240731);
            return false;
        }
    };
    private ScanUIRectView CJg;
    private ScannerFlashSwitcher CJh;
    private View CJi;
    private DialogInterface.OnCancelListener CJj;
    private ScanUITopOpButtonComponent CJk;
    private int CJl = 0;
    private e CJm;
    private b CJn;
    private boolean CJo = false;
    private boolean CJp = true;
    private boolean CJq = true;
    private boolean CJr = false;
    private long CJs;
    private boolean CJt = true;
    private boolean CJu = true;
    private boolean CJv = true;
    private boolean CJw = true;
    private boolean CJx = false;
    private int[] CJy;
    private int CJz;
    private FrameLayout container;
    private com.tencent.mm.ui.widget.a.e nVN;
    private Vibrator paT;
    private IListener<zj> qCu = new IListener<zj>() {
        /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass15 */

        {
            AppMethodBeat.i(161004);
            this.__eventId = zj.class.getName().hashCode();
            AppMethodBeat.o(161004);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zj zjVar) {
            AppMethodBeat.i(51699);
            zj zjVar2 = zjVar;
            if (zjVar2 instanceof zj) {
                if (!com.tencent.mm.kernel.g.aAc()) {
                    AppMethodBeat.o(51699);
                    return false;
                } else if (zjVar2.efx.dKy == 3) {
                    if (BaseScanUI.this.CJg != null) {
                        BaseScanUI.this.CJg.onDestroy();
                    }
                    BaseScanUI.this.finish();
                }
            }
            AppMethodBeat.o(51699);
            return true;
        }
    };
    private b.a qgt;
    private com.tencent.mm.modelgeo.d uzs;
    private int zTQ;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BaseScanUI() {
        AppMethodBeat.i(51728);
        AppMethodBeat.o(51728);
    }

    static /* synthetic */ void J(BaseScanUI baseScanUI) {
        AppMethodBeat.i(240769);
        baseScanUI.eQD();
        AppMethodBeat.o(240769);
    }

    static /* synthetic */ void N(BaseScanUI baseScanUI) {
        AppMethodBeat.i(240773);
        baseScanUI.eQC();
        AppMethodBeat.o(240773);
    }

    static /* synthetic */ void a(BaseScanUI baseScanUI, int i2) {
        AppMethodBeat.i(240763);
        baseScanUI.WN(i2);
        AppMethodBeat.o(240763);
    }

    static /* synthetic */ void a(BaseScanUI baseScanUI, int i2, int i3) {
        AppMethodBeat.i(240766);
        baseScanUI.ie(i2, i3);
        AppMethodBeat.o(240766);
    }

    static /* synthetic */ void a(BaseScanUI baseScanUI, boolean z) {
        AppMethodBeat.i(240753);
        baseScanUI.ah(true, z);
        AppMethodBeat.o(240753);
    }

    static /* synthetic */ void b(BaseScanUI baseScanUI, boolean z) {
        AppMethodBeat.i(169989);
        baseScanUI.setEnableSwitchTab(z);
        AppMethodBeat.o(169989);
    }

    static /* synthetic */ void e(BaseScanUI baseScanUI, boolean z) {
        AppMethodBeat.i(240761);
        baseScanUI.tR(z);
        AppMethodBeat.o(240761);
    }

    static /* synthetic */ void i(BaseScanUI baseScanUI, boolean z) {
        AppMethodBeat.i(240771);
        baseScanUI.tT(z);
        AppMethodBeat.o(240771);
    }

    static /* synthetic */ void j(BaseScanUI baseScanUI) {
        AppMethodBeat.i(240754);
        baseScanUI.tS(false);
        AppMethodBeat.o(240754);
    }

    static /* synthetic */ void k(BaseScanUI baseScanUI) {
        AppMethodBeat.i(240756);
        baseScanUI.eQx();
        AppMethodBeat.o(240756);
    }

    static /* synthetic */ void l(BaseScanUI baseScanUI) {
        AppMethodBeat.i(240757);
        baseScanUI.ai(false, false);
        AppMethodBeat.o(240757);
    }

    static /* synthetic */ int o(BaseScanUI baseScanUI) {
        int i2 = baseScanUI.CJL;
        baseScanUI.CJL = i2 + 1;
        return i2;
    }

    static /* synthetic */ void s(BaseScanUI baseScanUI) {
        AppMethodBeat.i(51768);
        baseScanUI.eQE();
        AppMethodBeat.o(51768);
    }

    static /* synthetic */ void y(BaseScanUI baseScanUI) {
        AppMethodBeat.i(170002);
        baseScanUI.goBack();
        AppMethodBeat.o(170002);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bo_;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.i(51729);
        super.onCreate(bundle);
        tR(true);
        if (com.tencent.mm.kernel.g.azz().aYS() == 6 || com.tencent.mm.kernel.g.azz().aYS() == 4) {
            this.CJv = true;
        } else {
            this.CJv = false;
        }
        this.paT = (Vibrator) getSystemService("vibrator");
        this.CJy = getIntent().getIntArrayExtra("key_support_scan_code_type");
        this.CJz = getIntent().getIntExtra("key_scan_entry_scene", 0);
        this.CJA = getIntent().getBooleanExtra("BaseScanUI_only_scan_qrcode_with_zbar", false);
        this.CJB = getIntent().getBooleanExtra("key_set_result_after_scan", false);
        this.CAI = getIntent().getBooleanExtra("key_is_hide_right_btn", false);
        this.zTQ = getIntent().getIntExtra("BaseScanUI_select_scan_mode", 1);
        this.CJu = getIntent().getBooleanExtra("key_show_scan_tips", true);
        this.CJx = getIntent().getBooleanExtra("key_config_black_interval", false);
        this.CJM = getIntent().getBooleanExtra("key_enable_multi_code", false);
        this.CJO = getIntent().getBooleanExtra("key_scan_goods_enable_dynamic_wording", false);
        this.CJE = getIntent().getBooleanExtra("key_for_jsapi_use", false);
        this.CAH = this.CAI;
        if (r.Xe(this.zTQ)) {
            this.CJD = (BaseScanRequest) getIntent().getParcelableExtra("key_scan_request");
            this.CJl = af.a(this.CJD);
        }
        com.tencent.qbar.b.hke();
        com.tencent.qbar.f.hkl();
        r.eSe();
        com.tencent.mm.plugin.scanner.util.d.init();
        boolean eSh = r.eSh();
        Log.i("MicroMsg.ScanUI", "alvinluo initEnableMultiCode configEnableMultiCode: %b, entryEnableMultiCode: %b", Boolean.valueOf(eSh), Boolean.valueOf(this.CJM));
        com.tencent.qbar.h hkp = com.tencent.qbar.h.hkp();
        if (!eSh || !this.CJM) {
            z = false;
        } else {
            z = true;
        }
        hkp.CJM = z;
        com.tencent.qbar.f.DN(z);
        initView();
        this.CJs = System.currentTimeMillis();
        EventCenter.instance.addListener(this.qCu);
        com.tencent.mm.cr.d.hiy();
        af.eQg();
        WO(1);
        w.ePT();
        SecDataUIC.a aVar = SecDataUIC.CWq;
        chc chc = (chc) SecDataUIC.a.b(this, 3, chc.class);
        if (chc != null && "launch_type_scan_qrcode".equals(chc.Mmm)) {
            ks ksVar = new ks();
            ksVar.elF = 2;
            ksVar.eXj = 1;
            ksVar.bfK();
            com.tencent.mm.util.b bVar = com.tencent.mm.util.b.QYu;
            com.tencent.mm.util.b.a(ksVar);
        }
        AppMethodBeat.o(51729);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        int i2;
        AppMethodBeat.i(51730);
        this.container = (FrameLayout) findViewById(R.id.ha2);
        this.CJn = new com.tencent.mm.plugin.scanner.ui.widget.b(this);
        getWindow().getDecorView().setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
        if (com.tencent.mm.compatible.util.d.oD(19)) {
            getWindow().addFlags(67109888);
        } else {
            getWindow().setFlags(1024, 1024);
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        this.CJi = findViewById(R.id.hab);
        this.CGF = (ScanInfoMaskView) findViewById(R.id.ha6);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass30 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(169983);
                BaseScanUI.y(BaseScanUI.this);
                AppMethodBeat.o(169983);
                return true;
            }
        });
        this.CJk = (ScanUITopOpButtonComponent) findViewById(R.id.iso);
        this.CJg = new ScanUIRectView(this);
        this.CJg.CNn = this;
        this.CJg.setScanRequest(this.CJD);
        this.CJg.setEnableScanGoodsDynamicWording(this.CJO);
        ScanScrollTabView scanScrollTabView = (ScanScrollTabView) findViewById(R.id.han);
        com.tencent.mm.plugin.scanner.ui.widget.b bVar = this.CJn;
        kotlin.g.b.p.h(scanScrollTabView, "scrollTabView");
        bVar.CSp = scanScrollTabView;
        ScanScrollTabView scanScrollTabView2 = bVar.CSp;
        if (scanScrollTabView2 != null) {
            scanScrollTabView2.removeAllTabs();
        }
        ScanScrollTabView scanScrollTabView3 = bVar.CSp;
        if (scanScrollTabView3 != null) {
            scanScrollTabView3.setOnTabScrollListener(new b.c());
        }
        bVar.CSq.clear();
        Iterator<T> it = bVar.CSr.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (bVar.a(i3, it.next())) {
                i2 = i3 + 1;
            } else {
                i2 = i3;
            }
            i3 = i2;
        }
        com.tencent.mm.plugin.scanner.ui.widget.b bVar2 = this.CJn;
        AnonymousClass9 r3 = new com.tencent.mm.plugin.scanner.ui.widget.e() {
            /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass9 */

            @Override // com.tencent.mm.plugin.scanner.ui.widget.e
            /* renamed from: if  reason: not valid java name */
            public final void m27if(int i2, int i3) {
                AppMethodBeat.i(240723);
                Log.i("MicroMsg.ScanUI", "alvinluo onTabSelected tabId: %d, tabSelectedAction: %d", Integer.valueOf(i2), Integer.valueOf(i3));
                if (i2 == 12 && !WeChatBrands.Business.Entries.DiscoveryScanRecognize.checkAvailable(BaseScanUI.this.getContext())) {
                    BaseScanUI.this.cvn();
                    AppMethodBeat.o(240723);
                } else if (i2 != 3 || WeChatBrands.Business.Entries.DiscoveryScanTranslate.checkAvailable(BaseScanUI.this.getContext())) {
                    if (!BaseScanUI.this.CJt) {
                        BaseScanUI.a(BaseScanUI.this, i2, i3);
                    } else {
                        BaseScanUI.this.CJt = false;
                    }
                    if (BaseScanUI.this.zTQ != i2) {
                        if (i2 == 12 && i3 == 4) {
                            af.ic(7, i2);
                            BaseScanUI.this.CJl = 3;
                            BaseScanUI.this.CJJ = true;
                            BaseScanUI.G(BaseScanUI.this);
                            if (BaseScanUI.this.CGE != null) {
                                BaseScanUI.this.CGE.setShowToast(true);
                                BaseScanUI.this.CGE.setScanToast(BaseScanUI.this.getResources().getString(R.string.gbe));
                            }
                        } else {
                            BaseScanUI.this.CJl = af.a(BaseScanUI.this.CJD);
                            BaseScanUI.this.CJJ = false;
                            if (BaseScanUI.this.CGE != null) {
                                BaseScanUI.this.CGE.setShowToast(false);
                            }
                        }
                        Log.i("MicroMsg.ScanUI", "alvinluo onTabSelected scanGoodsScene: %d, needAnimateHideBlurBackground: %b", Integer.valueOf(BaseScanUI.this.CJl), Boolean.valueOf(BaseScanUI.this.CJJ));
                        BaseScanUI.c(BaseScanUI.this, i2);
                    }
                    if (r.Xd(i2)) {
                        BaseScanUI.this.CJG = true;
                    }
                    BaseScanUI.J(BaseScanUI.this);
                    AppMethodBeat.o(240723);
                } else {
                    BaseScanUI.this.cvn();
                    AppMethodBeat.o(240723);
                }
            }

            @Override // com.tencent.mm.plugin.scanner.ui.widget.e
            public final void WQ(int i2) {
                AppMethodBeat.i(240724);
                Log.i("MicroMsg.ScanUI", "alvinluo onTabUnSelected tabId: %d", Integer.valueOf(i2));
                if (r.Xd(i2)) {
                    BaseScanUI.this.CJG = false;
                }
                BaseScanUI.WP(i2);
                if (i2 == 12) {
                    BaseScanUI.eQF();
                }
                AppMethodBeat.o(240724);
            }
        };
        kotlin.g.b.p.h(r3, "tabOnSelectedListener");
        b.d dVar = new b.d(bVar2, r3);
        ScanScrollTabView scanScrollTabView4 = bVar2.CSp;
        if (scanScrollTabView4 != null) {
            scanScrollTabView4.setOnTabChangedListener(dVar);
        }
        com.tencent.mm.plugin.scanner.ui.widget.b bVar3 = this.CJn;
        AnonymousClass10 r1 = new com.tencent.mm.plugin.scanner.ui.widget.d() {
            /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass10 */

            @Override // com.tencent.mm.plugin.scanner.ui.widget.d
            public final void u(int i2, float f2) {
                AppMethodBeat.i(240725);
                Log.v("MicroMsg.ScanUI", "alvinluo onScroll offsetX: %f", Float.valueOf(f2));
                AppMethodBeat.o(240725);
            }

            @Override // com.tencent.mm.plugin.scanner.ui.widget.d
            public final void onScrollStateChanged(int i2) {
                AppMethodBeat.i(240726);
                if (i2 == 1) {
                    BaseScanUI.this.CJo = false;
                } else if (i2 == 3 || i2 == 2) {
                    BaseScanUI.this.CJo = true;
                }
                Log.v("MicroMsg.ScanUI", "alvinluo onScrollStateChanged state: %d, isScrolling: %b", Integer.valueOf(i2), Boolean.valueOf(BaseScanUI.this.CJo));
                AppMethodBeat.o(240726);
            }
        };
        kotlin.g.b.p.h(r1, "tabOnScrollListener");
        ScanScrollTabView scanScrollTabView5 = bVar3.CSp;
        if (scanScrollTabView5 != null) {
            scanScrollTabView5.setOnTabScrollListener(r1);
        }
        if (this.CJg != null) {
            this.CJg.setScrollTabController(this.CJn);
        }
        if (this.CJA || this.zTQ == 8) {
            this.CJC = true;
        } else if (com.tencent.mm.aw.b.bdG()) {
            if (r.eSd()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(1);
                if (!WeChatBrands.Business.Entries.DiscoveryScanRecognize.restricted()) {
                    arrayList.add(12);
                }
                if (!WeChatBrands.Business.Entries.DiscoveryScanTranslate.restricted()) {
                    arrayList.add(3);
                }
                this.CJn.gE(arrayList);
            } else {
                this.CJC = true;
            }
        }
        if (this.CJD != null) {
            if (this.CJD.CAE) {
                this.CJC = true;
            }
            if (this.CJD.CAH) {
                this.CAH = true;
            }
            if (this.CJD.CAI) {
                this.CAI = true;
            }
        }
        if (this.CJC) {
            ScanScrollTabView scanScrollTabView6 = this.CJn.CSp;
            if (scanScrollTabView6 != null) {
                scanScrollTabView6.setVisibility(8);
            }
            this.CJp = false;
            this.CJg.setBottomExtraHeight(0);
        } else {
            ScanScrollTabView scanScrollTabView7 = this.CJn.CSp;
            if (scanScrollTabView7 != null) {
                scanScrollTabView7.setVisibility(0);
            }
            this.CJg.setBottomExtraHeight(getResources().getDimensionPixelSize(R.dimen.ai8));
            this.CJp = true;
        }
        setEnableSwitchTab(this.CJp);
        Log.i("MicroMsg.ScanUI", "alvinluo initView currentMode: %d, showOnlyScanCode: %b, hideScrollTab: %b, scanRequest: %s", Integer.valueOf(this.zTQ), Boolean.valueOf(this.CJA), Boolean.valueOf(this.CJC), this.CJD);
        this.CJg.setActivity(this);
        this.container.addView(this.CJg, 0, new FrameLayout.LayoutParams(-1, -1));
        this.CJg.onCreate();
        this.CJg.setShowScanTips(this.CJu);
        this.CJg.setNetworkAvailable(this.CJv);
        this.CJg.setScanMode(this.zTQ);
        this.CJg.refreshView();
        this.CGE = this.CJg.getSharedMaskView();
        ie(this.zTQ, 0);
        eQB();
        af.WE(this.zTQ);
        eQD();
        if (this.CJx) {
            this.CJg.setBlackInterval(com.tencent.qbar.b.hkf());
        }
        eQv();
        eQA();
        if (this.CJy != null && this.CJy.length > 0) {
            this.CJg.setScanCodeReaders(this.CJy);
        }
        if (this.CJE) {
            this.CJg.setMyQrCodeVisible(false);
        }
        this.CJn.ii(this.zTQ, 0);
        eQw();
        this.CJk.setOnCloseClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(240720);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/BaseScanUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                BaseScanUI.eQF();
                BaseScanUI.e(BaseScanUI.this);
                BaseScanUI.y(BaseScanUI.this);
                af.ib(3, -1);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(240720);
            }
        });
        this.CJk.setOnCancelClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(240721);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/BaseScanUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                BaseScanUI.this.onBackPressed();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(240721);
            }
        });
        dzO();
        AppMethodBeat.o(51730);
    }

    private void tR(boolean z) {
        AppMethodBeat.i(51731);
        if (z || ao.isDarkMode()) {
            getController().setNavigationbarColor(getResources().getColor(R.color.a6g));
            AppMethodBeat.o(51731);
            return;
        }
        getController().setNavigationbarColor(getContext().getResources().getColor(R.color.f3044b));
        AppMethodBeat.o(51731);
    }

    private void eQv() {
        AppMethodBeat.i(51732);
        ScanSharedMaskView sharedMaskView = this.CJg.getSharedMaskView();
        if (sharedMaskView == null) {
            AppMethodBeat.o(51732);
        } else if (!this.CAH) {
            sharedMaskView.getGalleryButton().setVisibility(0);
            sharedMaskView.setOnGalleryClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass31 */

                public final void onClick(View view) {
                    AppMethodBeat.i(169984);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/BaseScanUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    BaseScanUI.z(BaseScanUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(169984);
                }
            });
            AppMethodBeat.o(51732);
        } else {
            sharedMaskView.getGalleryButton().setVisibility(8);
            AppMethodBeat.o(51732);
        }
    }

    private void setEnableSwitchTab(boolean z) {
        AppMethodBeat.i(51733);
        Log.i("MicroMsg.ScanUI", "alvinluo setEnableSwitchTab enable: %b, %b", Boolean.valueOf(z), Boolean.valueOf(this.CJp));
        if (this.CJn != null) {
            if (!z) {
                this.CJn.setEnableSwitchTab(false);
            } else if (this.CJp) {
                this.CJn.setEnableSwitchTab(true);
            }
        }
        if (this.CJg != null) {
            if (!z) {
                this.CJg.setEnableScrollSwitchTab(false);
            } else if (this.CJp) {
                this.CJg.setEnableScrollSwitchTab(true);
                AppMethodBeat.o(51733);
                return;
            }
        }
        AppMethodBeat.o(51733);
    }

    private void tS(boolean z) {
        AppMethodBeat.i(240743);
        if (this.CJn != null) {
            com.tencent.mm.plugin.scanner.ui.widget.b bVar = this.CJn;
            Log.i("MicroMsg.ScanScrollTabController", "alvinluo setEnable %b", Boolean.valueOf(z));
            bVar.setEnableSwitchTab(z);
            ScanScrollTabView scanScrollTabView = bVar.CSp;
            if (scanScrollTabView != null) {
                scanScrollTabView.setEnabled(z);
                AppMethodBeat.o(240743);
                return;
            }
        }
        AppMethodBeat.o(240743);
    }

    private void eQw() {
        AppMethodBeat.i(51734);
        ScanSharedMaskView sharedMaskView = this.CJg.getSharedMaskView();
        if (sharedMaskView != null) {
            this.CJh = sharedMaskView.getFlashSwitcherView();
        }
        if (this.CJh != null) {
            this.CJh.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(240717);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/BaseScanUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    com.tencent.qbar.c.RJE.aqx(2);
                    if (!BaseScanUI.this.CJh.VC) {
                        BaseScanUI.a(BaseScanUI.this, 1);
                    } else {
                        BaseScanUI.a(BaseScanUI.this, 2);
                    }
                    af.ia(BaseScanUI.this.zTQ, 2);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(240717);
                }
            });
            this.CJg.setFlashStatus(this.CJh.ddZ);
            if (r.Xf(this.zTQ)) {
                eQx();
                this.CJh.hide();
            }
        }
        AppMethodBeat.o(51734);
    }

    private void WN(int i2) {
        AppMethodBeat.i(51735);
        Log.i("MicroMsg.ScanUI", "alvinluo operateFlash operation: %d", Integer.valueOf(i2));
        tj tjVar = new tj();
        tjVar.dZP.dDe = i2;
        EventCenter.instance.publish(tjVar);
        if (this.CJh != null) {
            if (i2 == 1) {
                this.CJh.eRm();
                AppMethodBeat.o(51735);
                return;
            }
            this.CJh.eRn();
        }
        AppMethodBeat.o(51735);
    }

    private void eQx() {
        AppMethodBeat.i(51736);
        Log.d("MicroMsg.ScanUI", "alvinluo checkAndOperateFlash operation: %d", 2);
        if (this.CJh.VC) {
            WN(2);
        }
        AppMethodBeat.o(51736);
    }

    private void dzO() {
        AppMethodBeat.i(240744);
        this.CJk.setShowMoreButton(eQy());
        this.CJk.setOnMoreClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(51686);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/BaseScanUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                BaseScanUI.D(BaseScanUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(51686);
            }
        });
        AppMethodBeat.o(240744);
    }

    private boolean eQz() {
        boolean z;
        AppMethodBeat.i(240746);
        Log.i("MicroMsg.ScanUI", "alvinluo processCancel isShowingMultiCodeResult: %b, infoViewType: %d", Boolean.valueOf(this.CJN), Integer.valueOf(this.CJI.CGI));
        ScanUITopOpButtonComponent scanUITopOpButtonComponent = this.CJk;
        AnonymousClass8 r0 = new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass8 */

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(240722);
                BaseScanUI.s(BaseScanUI.this);
                AppMethodBeat.o(240722);
            }
        };
        TextView textView = scanUITopOpButtonComponent.CPg;
        if (textView == null) {
            kotlin.g.b.p.btv("cancelButton");
        }
        if (textView.getVisibility() == 0) {
            scanUITopOpButtonComponent.tZ(true);
            scanUITopOpButtonComponent.b(false, r0);
            z = true;
        } else {
            z = false;
        }
        tS(true);
        if (r.Xd(this.zTQ) && this.CJN) {
            this.CJN = false;
            af.ib(3, -1);
            af.eQm();
        }
        if (r.Xd(this.zTQ) && this.CJI != null && this.CJI.CGI == 3) {
            af.ic(5, this.zTQ);
        }
        AppMethodBeat.o(240746);
        return z;
    }

    private void eQA() {
        AppMethodBeat.i(51739);
        switch (this.zTQ) {
            case 1:
            case 4:
            case 8:
                this.CJg.setScanCallback(this.CJP);
                this.CJm = new d(this.zTQ, this.CJz, this.CJg, this, this);
                AppMethodBeat.o(51739);
                return;
            case 3:
                this.CJm = new ah(this);
                AppMethodBeat.o(51739);
                return;
            case 12:
                this.CJg.setScanCallback(this.CJQ);
                this.CJm = new com.tencent.mm.plugin.scanner.f.a(this.zTQ, this.CJg, this, this.CJR);
                AppMethodBeat.o(51739);
                return;
            default:
                this.CJg.setScanCallback(null);
                AppMethodBeat.o(51739);
                return;
        }
    }

    private void ie(int i2, int i3) {
        AppMethodBeat.i(240747);
        Log.v("MicroMsg.ScanUI", "alvinluo reportSwitchTab %b", Boolean.valueOf(this.CJt));
        af.hZ(i2, i3);
        af.Wy(i2);
        af.WA(i2);
        af.WE(i2);
        AppMethodBeat.o(240747);
    }

    private void ah(boolean z, boolean z2) {
        long j2;
        long j3;
        AppMethodBeat.i(240748);
        Log.v("MicroMsg.ScanUI", "alvinluo reportScanPerformance success: %b, isMultiCode: %b", Boolean.valueOf(z), Boolean.FALSE);
        nr nrVar = this.CJK;
        if (z) {
            j2 = 1;
        } else {
            j2 = 0;
        }
        nrVar.fij = j2;
        this.CJK.fik = System.currentTimeMillis() - this.CJs;
        nr nrVar2 = this.CJK;
        if (this.CJg.eQZ()) {
            j3 = 0;
        } else {
            j3 = 1;
        }
        nrVar2.fil = j3;
        this.CJK.fiq = (long) this.zTQ;
        this.CJK.fim = (long) com.tencent.qbar.c.RJE.RJH;
        if (j.CUb.eRV() > 0) {
            this.CJK.fip = j.CUb.eRV() - this.CJs;
        }
        this.CJK.bfK();
        if (r.Xd(this.zTQ)) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(1229, 0, 1);
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(1229, 1, z ? 1 : 0);
            if (z) {
                if (this.CJg.eQZ()) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.n(1229, 5, 1);
                } else {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.n(1229, 3, 1);
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(1229, 7, this.CJK.fik);
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(1229, 9, this.CJK.fim);
                if (z && z2) {
                    Log.v("MicroMsg.ScanUI", "alvinluo reportScanPerformance scanTime: %s, totalFrames: %d", Long.valueOf(this.CJK.fik), Long.valueOf(this.CJK.fim));
                    com.tencent.mm.plugin.report.service.h.INSTANCE.n(1229, 11, 1);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.n(1229, 12, this.CJK.fik);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.n(1229, 14, this.CJK.fim);
                }
            }
        }
        AppMethodBeat.o(240748);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        boolean z;
        AppMethodBeat.i(51741);
        Log.v("MicroMsg.ScanUI", "alvinluo onBackPressed");
        if (this.CIq == null || !this.CIq.isShowingDialog()) {
            if (this.CJI == null || !this.CJI.CGG) {
                z = false;
            } else {
                Log.i("MicroMsg.ScanUI", "alvinluo cancelLoading");
                ad adVar = this.CJI;
                c.a aVar = adVar.CGH;
                if (aVar != null) {
                    aVar.eRN();
                }
                adVar.CGH = null;
                this.CJI.ag(false, false);
                z = true;
            }
            if (z) {
                if (!eQz()) {
                    eQE();
                    AppMethodBeat.o(51741);
                    return;
                }
            } else if (!eQz()) {
                if (this.zTQ == 12) {
                    af.tO(false);
                }
                af.WF(this.zTQ);
                goBack();
            }
            AppMethodBeat.o(51741);
            return;
        }
        this.CIq.dismiss();
        AppMethodBeat.o(51741);
    }

    private void goBack() {
        AppMethodBeat.i(51742);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/BaseScanUI", "com/tencent/mm/plugin/scanner/ui/BaseScanUI", "goBack", "()V", this);
        setResult(0);
        finish();
        overridePendingTransition(0, 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/BaseScanUI", "com/tencent/mm/plugin/scanner/ui/BaseScanUI", "goBack", "()V");
        AppMethodBeat.o(51742);
    }

    @Override // com.tencent.mm.plugin.scanner.f.e.b
    public final void cvn() {
        AppMethodBeat.i(51743);
        Log.i("MicroMsg.ScanUI", "finishUI");
        finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.o(51743);
    }

    private void eQB() {
        AppMethodBeat.i(169986);
        if (this.CJI != null) {
            this.CJI.a(this);
            if (this.CJg != null) {
                this.CJI.a(this.CJg.getScanMaskView(), this.CJg.getSharedMaskView(), this.CGF);
            }
        }
        AppMethodBeat.o(169986);
    }

    @Override // com.tencent.mm.plugin.scanner.f.d.a
    public final void s(int i2, Bundle bundle) {
        boolean z;
        AppMethodBeat.i(240749);
        Log.i("MicroMsg.ScanUI", "alvinluo showInfoView type: %d", Integer.valueOf(i2));
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            if (this.CGE != null) {
                this.CGE.CSH = this.CJg.getTextrueView();
                this.CGE.setAnimateBackgroundView(i2 == 3);
            }
            this.CJF = true;
            if (i2 == 3) {
                z = true;
            } else {
                z = false;
            }
            this.CJk.tZ(false);
            this.CJk.b(z, null);
            if (this.CJI != null) {
                ad adVar = this.CJI;
                kotlin.g.b.p.h(this, "context");
                BaseScanMaskView<BaseScanRequest> baseScanMaskView = adVar.CGD;
                View targetSuccessMarkView = baseScanMaskView != null ? baseScanMaskView.getTargetSuccessMarkView() : null;
                ScanInfoMaskView scanInfoMaskView = adVar.CGF;
                if (scanInfoMaskView != null) {
                    scanInfoMaskView.setAnchorView(targetSuccessMarkView);
                }
                ScanSharedMaskView scanSharedMaskView = adVar.CGE;
                if (scanSharedMaskView != null) {
                    RelativeLayout relativeLayout = scanSharedMaskView.contentLayout;
                    if (relativeLayout == null) {
                        kotlin.g.b.p.btv("contentLayout");
                    }
                    m.a(relativeLayout, 0.0f, 1.0f, 200, (Animator.AnimatorListener) null);
                }
                BaseScanMaskView<BaseScanRequest> baseScanMaskView2 = adVar.CGD;
                if (baseScanMaskView2 != null) {
                    baseScanMaskView2.eRz();
                }
                a.C1682a b2 = adVar.b(this, i2, bundle);
                adVar.CGI = i2;
                ScanInfoMaskView scanInfoMaskView2 = adVar.CGF;
                if (scanInfoMaskView2 != null) {
                    kotlin.g.b.p.h(b2, "viewParams");
                    Log.i("MicroMsg.ScanInfoMaskView", "alvinluo showInfoView needTranslateInfoIcon: %b, showTips: %b, title: %s, subTitle: %s", Boolean.valueOf(scanInfoMaskView2.CSf), Boolean.valueOf(b2.mVp), b2.title, b2.pWf);
                    View view = scanInfoMaskView2.BCP;
                    if (view == null) {
                        kotlin.g.b.p.btv("infoLayout");
                    }
                    TextView textView = (TextView) view.findViewById(R.id.ham);
                    if (textView != null) {
                        textView.setText(b2.title);
                    }
                    TextView textView2 = (TextView) view.findViewById(R.id.hal);
                    if (textView2 != null) {
                        textView2.setText(b2.pWf);
                        textView2.setVisibility(b2.mVp ? 0 : 8);
                    }
                    ImageView imageView = scanInfoMaskView2.jBH;
                    if (imageView == null) {
                        kotlin.g.b.p.btv("infoIcon");
                    }
                    imageView.setImageResource(b2.CUX);
                    TextView textView3 = scanInfoMaskView2.CRU;
                    if (textView3 == null) {
                        kotlin.g.b.p.btv("opButton");
                    }
                    textView3.setVisibility(b2.CUY ? 0 : 8);
                    TextView textView4 = scanInfoMaskView2.CRU;
                    if (textView4 == null) {
                        kotlin.g.b.p.btv("opButton");
                    }
                    textView4.setOnClickListener(b2.CUZ);
                    View view2 = scanInfoMaskView2.xcd;
                    if (view2 == null) {
                        kotlin.g.b.p.btv("loadingLayout");
                    }
                    view2.setVisibility(8);
                    if (!scanInfoMaskView2.CSf) {
                        scanInfoMaskView2.CSf = false;
                        scanInfoMaskView2.ud(false);
                    } else {
                        scanInfoMaskView2.CSa = false;
                        scanInfoMaskView2.CSb = true;
                        View view3 = scanInfoMaskView2.BCP;
                        if (view3 == null) {
                            kotlin.g.b.p.btv("infoLayout");
                        }
                        view3.setVisibility(0);
                        scanInfoMaskView2.setVisibility(4);
                        scanInfoMaskView2.post(new ScanInfoMaskView.d(scanInfoMaskView2));
                    }
                }
            }
            if (i2 == 3) {
                af.ic(4, this.zTQ);
            }
        }
        AppMethodBeat.o(240749);
    }

    @Override // com.tencent.mm.plugin.scanner.view.c
    public final void a(boolean z, boolean z2, c.a aVar) {
        AppMethodBeat.i(51746);
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Boolean.valueOf(this.CJI != null && this.CJI.CGG);
        objArr[2] = Boolean.valueOf(z2);
        Log.i("MicroMsg.ScanUI", "alvinluo showLoadingView show: %b, isLoadingShow: %b, withAnimation: %b", objArr);
        this.CJF = z;
        if (this.CJI != null) {
            this.CJI.CGH = aVar;
            if (this.CJI.CGG != z) {
                this.CJI.ag(z, z2);
                if (z) {
                    this.CJk.tZ(false);
                    this.CJk.b(false, null);
                }
            }
        }
        AppMethodBeat.o(51746);
    }

    private void tT(boolean z) {
        AppMethodBeat.i(51747);
        if (z) {
            this.CJi.setVisibility(0);
            this.CJg.cWj();
            this.CJi.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass11 */

                {
                    AppMethodBeat.i(169969);
                    AppMethodBeat.o(169969);
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(240727);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/BaseScanUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    BaseScanUI.this.CJL = 0;
                    BaseScanUI.i(BaseScanUI.this, false);
                    BaseScanUI.s(BaseScanUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(240727);
                }
            });
            if (this.CJg != null) {
                this.CJg.tW(true);
            }
            this.CJk.tZ(false);
            ai(false, true);
            AppMethodBeat.o(51747);
            return;
        }
        this.CJi.setVisibility(8);
        if (this.CJg != null) {
            this.CJg.tW(false);
        }
        this.CJk.tZ(true);
        AppMethodBeat.o(51747);
    }

    private void tU(boolean z) {
        AppMethodBeat.i(51749);
        Log.i("MicroMsg.ScanUI", "network change %s", Boolean.valueOf(z));
        if (!z) {
            tT(false);
            this.CJg.cWj();
        }
        AppMethodBeat.o(51749);
    }

    private void ai(boolean z, boolean z2) {
        AppMethodBeat.i(51750);
        Log.v("MicroMsg.ScanUI", "alvinluo showFlash show: %b, withAnimation: %b", Boolean.valueOf(z), Boolean.valueOf(z2));
        if (z) {
            if (this.CJh != null && !this.CJh.isShown()) {
                this.CJg.eRe();
                if (z2) {
                    this.CJh.show();
                } else {
                    this.CJh.setVisibility(0);
                }
                com.tencent.qbar.c.RJE.aqx(1);
                af.ia(this.zTQ, 1);
                AppMethodBeat.o(51750);
                return;
            }
        } else if (this.CJh != null && !this.CJh.VC) {
            this.CJg.eRf();
            if (z2) {
                this.CJh.hide();
                AppMethodBeat.o(51750);
                return;
            }
            this.CJh.setVisibility(8);
        }
        AppMethodBeat.o(51750);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00df  */
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        /*
        // Method dump skipped, instructions count: 331
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.ui.BaseScanUI.onResume():void");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(51752);
        Log.i("MicroMsg.ScanUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults len[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr.length), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case 16:
                if (iArr.length > 0 && iArr[0] == -1) {
                    this.CJq = false;
                    h.a((Context) this, getString(R.string.fl0), getString(R.string.flp), getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass18 */

                        {
                            AppMethodBeat.i(161005);
                            AppMethodBeat.o(161005);
                        }

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(169978);
                            BaseScanUI baseScanUI = BaseScanUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(baseScanUI, bl.axQ(), "com/tencent/mm/plugin/scanner/ui/BaseScanUI$25", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            baseScanUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(baseScanUI, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$25", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            BaseScanUI.this.CJq = true;
                            BaseScanUI.this.finish();
                            AppMethodBeat.o(169978);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass19 */

                        {
                            AppMethodBeat.i(161006);
                            AppMethodBeat.o(161006);
                        }

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(169979);
                            BaseScanUI.this.CJq = true;
                            BaseScanUI.this.finish();
                            AppMethodBeat.o(169979);
                        }
                    });
                    AppMethodBeat.o(51752);
                    return;
                }
            case WXMediaMessage.IMediaObject.TYPE_MUSIC_VIDEO:
                if (iArr.length > 0 && iArr[0] == -1) {
                    this.CJr = false;
                    h.a((Context) this, getString(R.string.fl_), getString(R.string.flp), getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass20 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(51705);
                            BaseScanUI baseScanUI = BaseScanUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(baseScanUI, bl.axQ(), "com/tencent/mm/plugin/scanner/ui/BaseScanUI$27", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            baseScanUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(baseScanUI, "com/tencent/mm/plugin/scanner/ui/BaseScanUI$27", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            BaseScanUI.this.CJr = true;
                            BaseScanUI.this.finish();
                            AppMethodBeat.o(51705);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass21 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(51706);
                            BaseScanUI.this.CJr = true;
                            BaseScanUI.this.finish();
                            AppMethodBeat.o(51706);
                        }
                    });
                    break;
                }
        }
        AppMethodBeat.o(51752);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        BaseBoxDialogView baseBoxDialogView;
        AppMethodBeat.i(51753);
        super.onPause();
        Log.i("MicroMsg.ScanUI", "alvinluo onPause needPauseScan: %b", Boolean.valueOf(this.CJF));
        com.tencent.mm.plugin.ball.f.f.e(false, true, true);
        if (this.CJg != null) {
            this.CJg.onPause();
            if (this.CJF) {
                this.CJg.stopPreview();
            }
        }
        if (this.CJK.fij == 0) {
            ah(false, false);
        }
        com.tencent.qbar.c.RJE.bUV();
        j jVar = j.CUb;
        Log.i("MicroMsg.ScanStableDetector", "stop detect scan stable");
        if (jVar.mSensorManager != null) {
            Log.i("MicroMsg.ScanStableDetector", "unregister accelerate listener");
            jVar.mSensorManager.unregisterListener(jVar);
        }
        com.tencent.mm.plugin.ball.f.f.e(false, true, true);
        if (this.CIq == null || (baseBoxDialogView = this.CIq.CCE) == null) {
            AppMethodBeat.o(51753);
            return;
        }
        Log.i("MicroMsg.BaseBoxDialogView", "alvinluo onPause set canMeasured false");
        baseBoxDialogView.CBC = false;
        AppMethodBeat.o(51753);
    }

    private void eQD() {
        AppMethodBeat.i(169987);
        int i2 = 0;
        if (r.Xd(this.zTQ)) {
            i2 = com.tencent.qbar.c.RJB;
        } else if (this.zTQ == 12) {
            i2 = com.tencent.qbar.c.RJC;
        } else if (this.zTQ == 3) {
            i2 = com.tencent.qbar.c.RJD;
        }
        com.tencent.qbar.c.RJE.setTabType(i2);
        AppMethodBeat.o(169987);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(51754);
        super.onStop();
        if (this.CJg != null) {
            this.CJg.onStop();
        }
        this.CJh.eRn();
        com.tencent.mm.kernel.g.aAg().b(this.CJT);
        EventCenter.instance.removeListener(this.CJU);
        getWindow().clearFlags(128);
        AppMethodBeat.o(51754);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(51755);
        Log.i("MicroMsg.ScanUI", "onDestroy()");
        super.onDestroy();
        EventCenter.instance.removeListener(this.qCu);
        if (this.CJm != null) {
            this.CJm.destroy();
            this.CJm = null;
        }
        if (this.CJg != null) {
            this.CJg.onDestroy();
        }
        if (this.CIq != null && this.CIq.isShowingDialog()) {
            this.CIq.dismiss();
        }
        if (this.nVN != null && this.nVN.isShowing()) {
            this.nVN.bMo();
        }
        if (this.uzs != null) {
            this.uzs.c(this.qgt);
        }
        WO(2);
        AppMethodBeat.o(51755);
    }

    private void WO(int i2) {
        AppMethodBeat.i(240750);
        af.b(af.a(this.CJD), this.zTQ, this.CJD, i2);
        AppMethodBeat.o(240750);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x016f  */
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r13, int r14, android.content.Intent r15) {
        /*
        // Method dump skipped, instructions count: 458
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.ui.BaseScanUI.onActivityResult(int, int, android.content.Intent):void");
    }

    private void eQE() {
        AppMethodBeat.i(51757);
        Log.i("MicroMsg.ScanUI", "alvinluo resumeScan");
        this.CJs = System.currentTimeMillis();
        this.CJF = false;
        if (this.CJg != null) {
            this.CJg.onResume();
        }
        setEnableSwitchTab(true);
        AppMethodBeat.o(51757);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(51758);
        super.onConfigurationChanged(configuration);
        Log.i("MicroMsg.ScanUI", "screen orientation %d", Integer.valueOf(configuration.orientation));
        AppMethodBeat.o(51758);
    }

    @Override // com.tencent.mm.plugin.scanner.model.f
    public final void ePP() {
        AppMethodBeat.i(240751);
        tS(true);
        this.CJF = false;
        if (this.CJI != null) {
            this.CJk.b(false, null);
            if (this.CGE != null) {
                this.CGE.f(true, null);
            }
            ad adVar = this.CJI;
            AnonymousClass25 r1 = new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass25 */
                final /* synthetic */ int val$mode = 12;

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(240735);
                    super.onAnimationEnd(animator);
                    BaseScanUI.this.CJn.ii(this.val$mode, 4);
                    AppMethodBeat.o(240735);
                }
            };
            ScanInfoMaskView scanInfoMaskView = adVar.CGF;
            if (scanInfoMaskView != null) {
                View view = scanInfoMaskView.BCP;
                if (view == null) {
                    kotlin.g.b.p.btv("infoLayout");
                }
                if (view.getVisibility() == 0) {
                    View view2 = scanInfoMaskView.xcd;
                    if (view2 == null) {
                        kotlin.g.b.p.btv("loadingLayout");
                    }
                    view2.setVisibility(8);
                    View view3 = scanInfoMaskView.BCP;
                    if (view3 == null) {
                        kotlin.g.b.p.btv("infoLayout");
                    }
                    ScanInfoMaskView.a(view3, r1);
                }
            }
            com.tencent.f.h.RTc.n(new Runnable() {
                /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass26 */

                public final void run() {
                    AppMethodBeat.i(240737);
                    if (!BaseScanUI.this.CJJ || BaseScanUI.this.CGE == null) {
                        BaseScanUI.U(BaseScanUI.this);
                        AppMethodBeat.o(240737);
                        return;
                    }
                    BaseScanUI.this.CJJ = false;
                    BaseScanUI.this.CGE.f(false, new AnimatorListenerAdapter() {
                        /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass26.AnonymousClass1 */

                        public final void onAnimationEnd(Animator animator) {
                            AppMethodBeat.i(240736);
                            super.onAnimationEnd(animator);
                            BaseScanUI.U(BaseScanUI.this);
                            AppMethodBeat.o(240736);
                        }
                    });
                    AppMethodBeat.o(240737);
                }
            }, 1000);
        }
        AppMethodBeat.o(240751);
    }

    @Override // com.tencent.mm.plugin.scanner.model.f
    public final void ePO() {
        AppMethodBeat.i(240752);
        if (this.CJI != null) {
            ad adVar = this.CJI;
            ScanInfoMaskView scanInfoMaskView = adVar.CGF;
            if (scanInfoMaskView != null) {
                scanInfoMaskView.getVisibility();
                scanInfoMaskView.setVisibility(8);
                scanInfoMaskView.CSf = true;
            }
            adVar.CGI = 0;
        }
        AppMethodBeat.o(240752);
    }

    private boolean eQy() {
        AppMethodBeat.i(240745);
        if ((r.Xd(this.zTQ) || r.Xe(this.zTQ) || r.Xf(this.zTQ)) && !this.CAI && !this.CJE) {
            AppMethodBeat.o(240745);
            return true;
        }
        AppMethodBeat.o(240745);
        return false;
    }

    private void eQC() {
        boolean z;
        AppMethodBeat.i(51748);
        if (r.Xd(this.zTQ) || r.Xf(this.zTQ) || r.Xe(this.zTQ)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            tU(this.CJv);
            AppMethodBeat.o(51748);
            return;
        }
        tU(true);
        AppMethodBeat.o(51748);
    }

    static /* synthetic */ void e(BaseScanUI baseScanUI) {
        AppMethodBeat.i(169988);
        af.WF(baseScanUI.zTQ);
        AppMethodBeat.o(169988);
    }

    static /* synthetic */ void a(BaseScanUI baseScanUI, long j2, Bundle bundle, WxQBarResult wxQBarResult) {
        AppMethodBeat.i(240755);
        if (!(baseScanUI.CJm == null || wxQBarResult == null || bundle == null)) {
            bundle.putInt("result_code_format", wxQBarResult.typeID);
            bundle.putString("result_content", wxQBarResult.data);
            bundle.putString("result_code_name", wxQBarResult.typeName);
            bundle.putByteArray("result_raw_data", wxQBarResult.rawData);
            bundle.putInt("result_code_version", wxQBarResult.RJN);
            baseScanUI.CJm.c(j2, bundle);
        }
        AppMethodBeat.o(240755);
    }

    static /* synthetic */ void m(BaseScanUI baseScanUI) {
        AppMethodBeat.i(240758);
        com.tencent.f.h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass12 */

            public final void run() {
                AppMethodBeat.i(169971);
                PlaySound.play(BaseScanUI.this, R.string.fse);
                AppMethodBeat.o(169971);
            }
        });
        baseScanUI.paT.vibrate(10);
        AppMethodBeat.o(240758);
    }

    static /* synthetic */ void a(BaseScanUI baseScanUI, final z zVar) {
        AppMethodBeat.i(240759);
        Log.d("MicroMsg.ScanUI", "alvinluo showScanGoodsResult sessionId: %s, scanId: %s, showResult: %b, reqKey: %s, isScrolling: %b", Long.valueOf(zVar.sessionId), Integer.valueOf(zVar.CGn), Boolean.valueOf(zVar.CGj), zVar.dDL, Boolean.valueOf(baseScanUI.CJo));
        if (zVar.CGj) {
            boolean z = baseScanUI.CJh.VC;
            baseScanUI.eQx();
            baseScanUI.ai(false, false);
            baseScanUI.CJw = false;
            baseScanUI.CJH = false;
            baseScanUI.CJF = true;
            baseScanUI.setEnableSwitchTab(false);
            if (baseScanUI.CJm != null) {
                baseScanUI.CJm.F(zVar.sessionId, true);
            }
            baseScanUI.CJg.b(false, (DialogInterface.OnCancelListener) null);
            baseScanUI.CJg.setScanSource(zVar.source);
            af.WF(baseScanUI.zTQ);
            af.T(true, zVar.source);
            af.tO(true);
            af.a(zVar.source, true, System.currentTimeMillis());
            baseScanUI.CJg.a(zVar, new com.tencent.mm.plugin.scanner.view.d() {
                /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass28 */

                @Override // com.tencent.mm.plugin.scanner.view.d
                public final void eQG() {
                    AppMethodBeat.i(51721);
                    BaseScanUI.this.CJg.post(new Runnable() {
                        /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass28.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(51701);
                            if (!BaseScanUI.this.isFinishing()) {
                                BaseScanUI.b(BaseScanUI.this, zVar);
                            }
                            AppMethodBeat.o(51701);
                        }
                    });
                    AppMethodBeat.o(51721);
                }
            }, z);
        }
        AppMethodBeat.o(240759);
    }

    static /* synthetic */ void t(BaseScanUI baseScanUI) {
        AppMethodBeat.i(169996);
        Log.i("MicroMsg.ScanUI", "alvinluo pauseScan");
        if (baseScanUI.CJg != null) {
            baseScanUI.CJg.eRh();
        }
        AppMethodBeat.o(169996);
    }

    static /* synthetic */ void u(BaseScanUI baseScanUI) {
        AppMethodBeat.i(169997);
        if (baseScanUI.zTQ == 12) {
            boolean k = com.tencent.mm.pluginsdk.permission.b.k(baseScanUI, "android.permission.ACCESS_FINE_LOCATION", false);
            if (!k) {
                Log.w("MicroMsg.ScanUI", "startGetLocation checkLocation: %s and ignore", Boolean.valueOf(k));
                AppMethodBeat.o(169997);
                return;
            }
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(baseScanUI.CAV == null);
            Log.i("MicroMsg.ScanUI", "alvinluo startGetLocation location == null: %b", objArr);
            if (baseScanUI.CAV == null) {
                if (baseScanUI.uzs == null) {
                    baseScanUI.uzs = com.tencent.mm.modelgeo.d.bca();
                }
                if (baseScanUI.qgt == null) {
                    baseScanUI.qgt = new b.a() {
                        /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass32 */

                        @Override // com.tencent.mm.modelgeo.b.a
                        public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
                            AppMethodBeat.i(240742);
                            Log.v("MicroMsg.ScanUI", "onGetLocation isOk: %b, %s, %s, %s", Boolean.valueOf(z), Float.valueOf(f3), Float.valueOf(f2), Double.valueOf(d3));
                            if (z) {
                                BaseScanUI.this.CAV = new mu();
                                BaseScanUI.this.CAV.latitude = f3;
                                BaseScanUI.this.CAV.dTj = f2;
                                BaseScanUI.this.CAV.KRb = (float) ((int) d3);
                                if (BaseScanUI.this.CJm instanceof com.tencent.mm.plugin.scanner.f.a) {
                                    ((com.tencent.mm.plugin.scanner.f.a) BaseScanUI.this.CJm).CAV = BaseScanUI.this.CAV;
                                }
                                BaseScanUI.this.uzs.c(BaseScanUI.this.qgt);
                            }
                            AppMethodBeat.o(240742);
                            return true;
                        }
                    };
                }
                baseScanUI.uzs.a(baseScanUI.qgt, true);
                AppMethodBeat.o(169997);
                return;
            } else if (baseScanUI.CJm instanceof com.tencent.mm.plugin.scanner.f.a) {
                ((com.tencent.mm.plugin.scanner.f.a) baseScanUI.CJm).CAV = baseScanUI.CAV;
            }
        }
        AppMethodBeat.o(169997);
    }

    static /* synthetic */ void b(BaseScanUI baseScanUI, z zVar) {
        boolean z;
        AppMethodBeat.i(240760);
        if (zVar != null) {
            if ((baseScanUI.CJD instanceof ScanGoodsRequest) && ((ScanGoodsRequest) baseScanUI.CJD).CAM == zVar.CGo && zVar.CGo == 1) {
                z = true;
            } else {
                z = false;
            }
            Log.i("MicroMsg.ScanUI", "alvinluo showBoxDialog jumpType: %d, returnType: %d, directFinishWithResult: %b", Integer.valueOf(zVar.jumpType), Integer.valueOf(zVar.CGo), Boolean.valueOf(z));
            if (z) {
                af.a(baseScanUI.CJl, zVar.source, baseScanUI.CJD, 2);
                Intent intent = new Intent();
                intent.putExtra("key_scan_goods_result_req_key", zVar.dDL);
                baseScanUI.setResult(-1, intent);
                baseScanUI.cvn();
                AppMethodBeat.o(240760);
                return;
            } else if (baseScanUI.CJg != null) {
                BaseScanMaskView scanMaskView = baseScanUI.CJg.getScanMaskView();
                if (scanMaskView instanceof ScanGoodsMaskView) {
                    if (baseScanUI.CIq != null) {
                        baseScanUI.CIq.dismissDialog(0);
                    }
                    if (baseScanUI.nVN != null && baseScanUI.nVN.isShowing()) {
                        baseScanUI.nVN.bMo();
                    }
                    af.a(baseScanUI.CJl, zVar.source, baseScanUI.CJD, 1);
                    Bundle bundle = new Bundle();
                    bundle.putInt(MessengerShareContentUtility.TEMPLATE_TYPE, 1);
                    bundle.putString("req_key", zVar.dDL);
                    bundle.putString("enter_session", af.eQh());
                    bundle.putString("tab_session", af.Wz(12));
                    bundle.putString("scan_session", af.WB(12));
                    if ((baseScanUI.CJD instanceof ScanGoodsRequest) && ((ScanGoodsRequest) baseScanUI.CJD).kca > 0) {
                        bundle.putInt("fixed_dialog_height", ((ScanGoodsRequest) baseScanUI.CJD).kca);
                    }
                    baseScanUI.CIq = l.a(baseScanUI, bundle, baseScanUI.CJS);
                    com.tencent.mm.plugin.scanner.box.i iVar = baseScanUI.CIq;
                    ScanGoodsMaskView scanGoodsMaskView = (ScanGoodsMaskView) scanMaskView;
                    kotlin.g.b.p.h(scanGoodsMaskView, "viewModel");
                    BaseBoxDialogView baseBoxDialogView = iVar.CCE;
                    if (baseBoxDialogView != null) {
                        baseBoxDialogView.setBackgroundViewModel(scanGoodsMaskView);
                    }
                    baseScanUI.CIq.a((ScanGoodsMaskView) scanMaskView);
                }
            }
        }
        AppMethodBeat.o(240760);
    }

    static /* synthetic */ void z(BaseScanUI baseScanUI) {
        AppMethodBeat.i(240762);
        if (baseScanUI.CJH) {
            Log.i("MicroMsg.ScanUI", "alvinluo selectImageFromGallery currentMode: %d", Integer.valueOf(baseScanUI.zTQ));
            if (r.Xd(baseScanUI.zTQ)) {
                baseScanUI.CJF = true;
                Intent intent = new Intent();
                intent.putExtra("preview_ui_title", R.string.ge1);
                s.c(baseScanUI, 4660, intent);
                af.WF(baseScanUI.zTQ);
                af.WG(baseScanUI.zTQ);
                AppMethodBeat.o(240762);
                return;
            } else if (r.Xe(baseScanUI.zTQ)) {
                baseScanUI.CJF = true;
                s.c(baseScanUI, 2000, new Intent());
                af.WF(baseScanUI.zTQ);
                af.WG(baseScanUI.zTQ);
                AppMethodBeat.o(240762);
                return;
            } else if (r.Xf(baseScanUI.zTQ)) {
                s.a(baseScanUI, 561, 1, 0, 1, (Intent) null);
            }
        }
        AppMethodBeat.o(240762);
    }

    static /* synthetic */ void D(BaseScanUI baseScanUI) {
        AppMethodBeat.i(240764);
        baseScanUI.nVN = new com.tencent.mm.ui.widget.a.e((Context) baseScanUI, 1, false);
        baseScanUI.nVN.HLX = new o.f() {
            /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass3 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                AppMethodBeat.i(240718);
                if (mVar.gKQ()) {
                    mVar.kV(102, R.string.de);
                }
                AppMethodBeat.o(240718);
            }
        };
        baseScanUI.nVN.HLY = new o.g() {
            /* class com.tencent.mm.plugin.scanner.ui.BaseScanUI.AnonymousClass4 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(240719);
                switch (menuItem.getItemId()) {
                    case 101:
                        Intent intent = new Intent();
                        intent.putExtra("preview_ui_title", R.string.ge1);
                        s.c(BaseScanUI.this, 4660, intent);
                        AppMethodBeat.o(240719);
                        return;
                    case 102:
                        BaseScanUI baseScanUI = BaseScanUI.this;
                        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
                        intent2.putExtra("android.intent.extra.shortcut.NAME", baseScanUI.getString(R.string.cey));
                        intent2.putExtra("duplicate", false);
                        Intent intent3 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
                        intent3.putExtra("LauncherUI.From.Scaner.Shortcut", true);
                        intent3.addFlags(67108864);
                        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent3);
                        intent2.putExtra("shortcut_is_adaptive_icon", true);
                        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(baseScanUI, R.drawable.scan_shortcut_icon));
                        intent2.putExtra("shortcut_icon_resource_id", R.drawable.scan_shortcut_icon);
                        com.tencent.mm.plugin.base.model.b.o(baseScanUI, intent2);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11410, new Object[0]);
                        break;
                }
                AppMethodBeat.o(240719);
            }
        };
        baseScanUI.nVN.dGm();
        AppMethodBeat.o(240764);
    }

    static /* synthetic */ void eQF() {
        AppMethodBeat.i(240765);
        af.tO(false);
        AppMethodBeat.o(240765);
    }

    static /* synthetic */ void G(BaseScanUI baseScanUI) {
        AppMethodBeat.i(240767);
        baseScanUI.setEnableSwitchTab(false);
        if (baseScanUI.CJg != null) {
            baseScanUI.CJg.setIgnorePreviewFrame(true);
        }
        AppMethodBeat.o(240767);
    }

    static /* synthetic */ void c(BaseScanUI baseScanUI, int i2) {
        AppMethodBeat.i(240768);
        Log.i("MicroMsg.ScanUI", "select scan mode %d", Integer.valueOf(i2));
        baseScanUI.CJs = System.currentTimeMillis();
        baseScanUI.CJL = 0;
        baseScanUI.CJN = false;
        baseScanUI.zTQ = i2;
        if (baseScanUI.CJm != null) {
            baseScanUI.CJm.destroy();
        }
        baseScanUI.eQA();
        baseScanUI.CJg.setScanMode(baseScanUI.zTQ);
        baseScanUI.CJg.onPause();
        baseScanUI.tT(false);
        baseScanUI.eQC();
        baseScanUI.eQv();
        baseScanUI.CJg.refreshView();
        baseScanUI.eQB();
        baseScanUI.eQw();
        baseScanUI.dzO();
        if (!baseScanUI.isPaused()) {
            baseScanUI.CJg.onResume();
        }
        baseScanUI.CJg.tX(true);
        baseScanUI.CJr = false;
        AppMethodBeat.o(240768);
    }

    static /* synthetic */ void WP(int i2) {
        AppMethodBeat.i(240770);
        af.WF(i2);
        AppMethodBeat.o(240770);
    }

    static /* synthetic */ boolean L(BaseScanUI baseScanUI) {
        AppMethodBeat.i(240772);
        if (r.Xd(baseScanUI.zTQ) && baseScanUI.CJN) {
            AppMethodBeat.o(240772);
            return false;
        } else if (!r.Xe(baseScanUI.zTQ) || baseScanUI.CIq == null || !baseScanUI.CIq.isShowing()) {
            AppMethodBeat.o(240772);
            return true;
        } else {
            AppMethodBeat.o(240772);
            return false;
        }
    }

    static /* synthetic */ boolean O(BaseScanUI baseScanUI) {
        AppMethodBeat.i(240774);
        if (!r.Xf(baseScanUI.zTQ)) {
            AppMethodBeat.o(240774);
            return true;
        }
        AppMethodBeat.o(240774);
        return false;
    }

    static /* synthetic */ void k(BaseScanUI baseScanUI, boolean z) {
        AppMethodBeat.i(240775);
        baseScanUI.ai(z, true);
        AppMethodBeat.o(240775);
    }

    static /* synthetic */ boolean S(BaseScanUI baseScanUI) {
        AppMethodBeat.i(240776);
        boolean Xd = r.Xd(baseScanUI.zTQ);
        AppMethodBeat.o(240776);
        return Xd;
    }

    static /* synthetic */ void U(BaseScanUI baseScanUI) {
        AppMethodBeat.i(240777);
        baseScanUI.setEnableSwitchTab(true);
        if (baseScanUI.CJg != null) {
            baseScanUI.CJg.setIgnorePreviewFrame(false);
            baseScanUI.CJg.IC(0);
        }
        AppMethodBeat.o(240777);
    }
}
