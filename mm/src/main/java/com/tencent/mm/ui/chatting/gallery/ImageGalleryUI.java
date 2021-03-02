package com.tencent.mm.ui.chatting.gallery;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.view.ViewPager;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.y;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.g.a.aw;
import com.tencent.mm.g.a.ax;
import com.tencent.mm.g.a.ay;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.g.a.ir;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.qy;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.g.a.rl;
import com.tencent.mm.g.a.to;
import com.tencent.mm.g.a.tp;
import com.tencent.mm.g.b.a.ep;
import com.tencent.mm.g.b.a.jc;
import com.tencent.mm.g.c.fx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.appbrand.openmaterial.h;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.api.f;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.plugin.scanner.word.a;
import com.tencent.mm.plugin.webview.ui.tools.media.e;
import com.tencent.mm.plugin.webview.ui.tools.media.h;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.gallery.a.f;
import com.tencent.mm.ui.chatting.gallery.a.g;
import com.tencent.mm.ui.chatting.gallery.a.j;
import com.tencent.mm.ui.chatting.gallery.a.k;
import com.tencent.mm.ui.chatting.gallery.a.l;
import com.tencent.mm.ui.chatting.gallery.a.m;
import com.tencent.mm.ui.chatting.gallery.a.n;
import com.tencent.mm.ui.chatting.gallery.b;
import com.tencent.mm.ui.chatting.gallery.h;
import com.tencent.mm.ui.chatting.gallery.view.SearchImageBubbleView;
import com.tencent.mm.ui.chatting.viewitems.al;
import com.tencent.mm.ui.tools.e;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsListener;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.p;

@com.tencent.mm.ui.base.a(3)
@i
public class ImageGalleryUI extends MMActivity implements View.OnClickListener, a.AbstractC1683a<String, com.tencent.mm.plugin.scanner.word.b> {
    int EAA;
    int EAB = 0;
    private float EAC = 1.0f;
    private int EAD = 0;
    private int EAE = 0;
    private long EAl = 0;
    private com.tencent.mm.plugin.scanner.api.a.a EAm = null;
    private com.tencent.mm.plugin.scanner.api.a.b EAn = ((com.tencent.mm.plugin.scanner.api.b) g.af(com.tencent.mm.plugin.scanner.api.b.class)).eOT();
    private com.tencent.mm.plugin.scanner.api.a.c EAo = new com.tencent.mm.plugin.scanner.api.a.c() {
        /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass42 */

        @Override // com.tencent.mm.plugin.scanner.api.a.c
        public final void eOW() {
            AppMethodBeat.i(233359);
            ImageGalleryUI.q(ImageGalleryUI.this);
            AppMethodBeat.o(233359);
        }

        @Override // com.tencent.mm.plugin.scanner.api.a.c
        public final void eOZ() {
            AppMethodBeat.i(233360);
            ImageGalleryUI.s(ImageGalleryUI.this);
            ImageGalleryUI.r(ImageGalleryUI.this);
            AppMethodBeat.o(233360);
        }

        @Override // com.tencent.mm.plugin.scanner.api.a.c
        public final void eOY() {
            AppMethodBeat.i(233361);
            ImageGalleryUI.s(ImageGalleryUI.this);
            AppMethodBeat.o(233361);
        }

        @Override // com.tencent.mm.plugin.scanner.api.a.c
        public final void eOX() {
            AppMethodBeat.i(233362);
            ImageGalleryUI.r(ImageGalleryUI.this);
            AppMethodBeat.o(233362);
        }
    };
    int EAz;
    private boolean Erb;
    private boolean FLK = false;
    protected RedesignVideoPlayerSeekBar FLz;
    private h Jgz = null;
    public e JjJ;
    public View JvM = null;
    protected View JvS;
    int Pdu;
    private HashSet<Long> Poq = new HashSet<>();
    private boolean Ptq = false;
    protected boolean Ptr = false;
    private boolean PwE = false;
    private final boolean PwF = false;
    public b Pwu;
    private n PxO = new n() {
        /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass23 */

        {
            AppMethodBeat.i(161542);
            AppMethodBeat.o(161542);
        }

        @Override // com.tencent.mm.ui.chatting.gallery.n
        public final void b(long j2, View view, String str, Bitmap bitmap) {
            AppMethodBeat.i(233333);
            if (!(view == null || bitmap == null || Util.isNullOrNil(str))) {
                Log.i("MicroMsg.ImageGalleryUI", "alvinluo onImageLoaded msgId: %d, currentMsgId: %d, imagePath: %s, bitmap: %s", Long.valueOf(j2), Long.valueOf(ImageGalleryUI.this.PyG), str, Integer.valueOf(bitmap.hashCode()));
                ImageGalleryUI.a(ImageGalleryUI.this, view, str, bitmap, ImageGalleryUI.this.Pzt);
                if (j2 == ImageGalleryUI.this.PyG) {
                    ImageGalleryUI.a(ImageGalleryUI.this, j2);
                }
            }
            AppMethodBeat.o(233333);
        }

        @Override // com.tencent.mm.ui.chatting.gallery.n
        public final void ar(long j2, int i2) {
            AppMethodBeat.i(233334);
            Log.i("MicroMsg.ImageGalleryUI", "alvinluo onImageDownloaded msgId: %d, currentMsgId: %d, compressType: %d", Long.valueOf(j2), Long.valueOf(ImageGalleryUI.this.PyG), Integer.valueOf(i2));
            if (j2 == ImageGalleryUI.this.PyG && !d.amZ(i2)) {
                ImageGalleryUI.a(ImageGalleryUI.this, j2);
            }
            AppMethodBeat.o(233334);
        }
    };
    private boolean PyA = true;
    public f PyB = new f();
    private int PyC = 0;
    private int PyD = 0;
    private int PyE = 0;
    private int PyF = 0;
    private long PyG = 0;
    private boolean PyH = false;
    private int PyI = 0;
    private View PyJ = null;
    private View PyK;
    private View PyL;
    private View PyM;
    private View PyN;
    private View PyO;
    private View PyP;
    private View PyQ;
    private View PyR;
    private SearchImageBubbleView PyS;
    View PyT;
    Button PyU;
    Button PyV;
    View PyW;
    int PyX = 0;
    int PyY = 0;
    boolean PyZ;
    private b.EnumC2096b Pyw;
    private RelativeLayout Pyx;
    private boolean Pyy;
    private boolean Pyz = false;
    private boolean PzA = true;
    private String PzB = null;
    private AppBrandOpenMaterialCollection PzC = null;
    c PzD = null;
    private int PzE = 0;
    private boolean PzF = false;
    private boolean PzG = true;
    private ViewPager.OnPageChangeListener PzH = new ViewPager.OnPageChangeListener() {
        /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass28 */
        private boolean PzX = false;

        /* JADX WARNING: Removed duplicated region for block: B:41:0x014f  */
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onPageSelected(int r14) {
            /*
            // Method dump skipped, instructions count: 701
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass28.onPageSelected(int):void");
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int i2, float f2, int i3) {
            AppMethodBeat.i(233342);
            Log.v("MicroMsg.ImageGalleryUI", "position: %d, positionOffset: %f, positionOffsetPixels: %d", Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3));
            if (!this.PzX && i3 > 0) {
                this.PzX = true;
            }
            AppMethodBeat.o(233342);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int i2) {
            AppMethodBeat.i(233343);
            Log.d("MicroMsg.ImageGalleryUI", "onPageScrollStateChanged: %d", Integer.valueOf(i2));
            if (i2 == 2) {
                ImageGalleryUI.this.PzF = true;
            }
            if (i2 == 0) {
                this.PzX = false;
                boolean unused = ImageGalleryUI.this.PzF;
                ImageGalleryUI.this.PzF = false;
            }
            if (ImageGalleryUI.this.Pwu != null) {
                b bVar = ImageGalleryUI.this.Pwu;
                if (bVar.PwA != null) {
                    d dVar = bVar.PwA;
                    dVar.mScrollState = i2;
                    if (dVar.PxQ != null) {
                        dVar.PxQ.onPageScrollStateChanged(i2);
                    }
                }
            }
            AppMethodBeat.o(233343);
        }
    };
    public TextView PzI;
    public View PzJ;
    public ImageView PzK;
    private boolean PzL = false;
    boolean PzM = false;
    private HashMap<Long, String> PzN = new HashMap<>();
    private boolean PzO = false;
    private boolean PzP = false;
    ArrayList<Integer> Pza = new ArrayList<>();
    private n Pzb = new n();
    private boolean Pzc = false;
    private j Pzd;
    private com.tencent.mm.ui.chatting.gallery.a.g Pze = new com.tencent.mm.ui.chatting.gallery.a.g();
    private int Pzf = 0;
    private f Pzg;
    private l Pzh = new l();
    private boolean Pzi;
    protected boolean Pzj = false;
    protected boolean Pzk = false;
    private boolean Pzl;
    private int Pzm = -1;
    private int Pzn;
    private boolean Pzo;
    private String Pzp = null;
    private boolean Pzq;
    private ScanCodeSheetItemLogic Pzr;
    private com.tencent.mm.ui.chatting.gallery.a.f Pzs = new com.tencent.mm.ui.chatting.gallery.a.f();
    private com.tencent.mm.ui.chatting.gallery.a.h Pzt = new com.tencent.mm.ui.chatting.gallery.a.h() {
        /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass1 */

        @Override // com.tencent.mm.ui.chatting.gallery.a.h
        public final void b(qz qzVar) {
            AppMethodBeat.i(233300);
            String a2 = ImageGalleryUI.a(ImageGalleryUI.this);
            String k = s.k(a2, false);
            if (k == null || !k.equals(qzVar.dXz.filePath)) {
                Log.e("MicroMsg.ImageGalleryUI", "not same filepath");
                AppMethodBeat.o(233300);
                return;
            }
            ImageGalleryUI.this.VlB.hYF();
            Log.i("MicroMsg.ImageGalleryUI", "scanCode onSuccess result: %s, recognizeType: %d, curPath: %s, path: %s", qzVar.dXz.result, Integer.valueOf(qzVar.dXz.dXx), k, a2);
            if (!Util.isNullOrNil(qzVar.dXz.result)) {
                n nVar = ImageGalleryUI.this.Pzb;
                p.h(qzVar, "event");
                nVar.CFJ = qzVar.dXz.result;
                nVar.dFL = qzVar.dXz.dFL;
                nVar.dFM = qzVar.dXz.dFM;
                n.a aVar = new n.a();
                aVar.PDf = new PointF(qzVar.dXz.dXC / ((float) qzVar.dXz.dXA), qzVar.dXz.dXD / ((float) qzVar.dXz.dXB));
                aVar.PDg = qzVar.dXz.dXA;
                aVar.PDh = qzVar.dXz.dXB;
                nVar.PDc = aVar;
                Log.d("MicroMsg.ImageGalleryUI", "scanCode onSuccess codePointInfo: %s", ImageGalleryUI.this.Pzb.PDc);
                ImageGalleryUI.this.Pze.li(2, 1);
                ImageGalleryUI.this.Pze.e(2, new Runnable() {
                    /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(233299);
                        if (ImageGalleryUI.this.oXS == null || !ImageGalleryUI.this.oXS.isShowing()) {
                            ImageGalleryUI.a(ImageGalleryUI.this, 2);
                        } else {
                            ImageGalleryUI.this.dTH();
                            if (ImageGalleryUI.f(ImageGalleryUI.this) && ImageGalleryUI.this.Jgz != null) {
                                Log.i("MicroMsg.ImageGalleryUI", "scanCode onSuccess, hide enhance bottomSheet");
                                ImageGalleryUI.this.Jgz.a(h.a.HIDE);
                                AppMethodBeat.o(233299);
                                return;
                            }
                        }
                        AppMethodBeat.o(233299);
                    }
                });
                if (2 == qzVar.dXz.dXx) {
                    ImageGalleryUI.this.Pzr.cl(ImageGalleryUI.this.Pzb.dFL, ImageGalleryUI.this.Pzb.CFJ);
                }
            }
            if (!ImageGalleryUI.f(ImageGalleryUI.this) && ImageGalleryUI.this.oXS != null && ImageGalleryUI.this.oXS.isShowing() && ImageGalleryUI.this.Jgz != null) {
                Log.i("MicroMsg.ImageGalleryUI", "scanCode onSuccess, show enhance bottomSheet");
                ImageGalleryUI.this.Jgz.a(h.a.ENABLE);
            }
            AppMethodBeat.o(233300);
        }

        @Override // com.tencent.mm.ui.chatting.gallery.a.h
        public final void b(qy qyVar) {
            AppMethodBeat.i(233301);
            String a2 = ImageGalleryUI.a(ImageGalleryUI.this);
            String k = s.k(a2, false);
            if (k == null || !k.equals(qyVar.dXy.filePath)) {
                Log.e("MicroMsg.ImageGalleryUI", "not same filepath");
                AppMethodBeat.o(233301);
                return;
            }
            ImageGalleryUI.this.VlB.hYF();
            Log.i("MicroMsg.ImageGalleryUI", "scanCode onFailed result: %s, curPath: %s, path: %s", qyVar.dXy.result, k, a2);
            if (ImageGalleryUI.this.Pze.ans(2) != 1) {
                ImageGalleryUI.this.Pze.li(2, 2);
            }
            ImageGalleryUI.a(ImageGalleryUI.this, 2);
            if (!ImageGalleryUI.f(ImageGalleryUI.this) && ImageGalleryUI.this.oXS != null && ImageGalleryUI.this.oXS.isShowing() && ImageGalleryUI.this.Jgz != null) {
                Log.i("MicroMsg.ImageGalleryUI", "scanCode onFailed, show enhance bottomSheet");
                ImageGalleryUI.this.Jgz.a(h.a.ENABLE);
            }
            AppMethodBeat.o(233301);
        }
    };
    private com.tencent.mm.ui.chatting.gallery.a.i Pzu = new com.tencent.mm.ui.chatting.gallery.a.i() {
        /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass12 */

        @Override // com.tencent.mm.ui.chatting.gallery.a.i
        public final void a(np npVar) {
            boolean z;
            int i2 = 1;
            AppMethodBeat.i(233314);
            Log.i("MicroMsg.ImageGalleryUI", "handleCode callback notifyEvent: %d", Integer.valueOf(npVar.dTL.dTJ));
            if (ImageGalleryUI.i(ImageGalleryUI.this).PyP != null) {
                ImageGalleryUI.i(ImageGalleryUI.this).PyP.setOnClickListener(ImageGalleryUI.this);
            }
            if (npVar.dTL.activity != ImageGalleryUI.this || !npVar.dTL.dDX.equals(ImageGalleryUI.this.Pzb.CFJ)) {
                Log.e("MicroMsg.ImageGalleryUI", "handleCode callback not the same");
                AppMethodBeat.o(233314);
                return;
            }
            switch (npVar.dTL.dTJ) {
                case 0:
                case 1:
                case 2:
                    ImageGalleryUI.this.Pzs.anq(2);
                    ImageGalleryUI.hW(ImageGalleryUI.l(ImageGalleryUI.this).PyQ);
                    AppMethodBeat.o(233314);
                    return;
                case 3:
                    Bundle bundle = npVar.dTL.dTM;
                    if (bundle != null) {
                        z = bundle.getBoolean("key_scan_qr_code_result", true);
                    } else {
                        z = true;
                    }
                    com.tencent.mm.ui.chatting.gallery.a.f fVar = ImageGalleryUI.this.Pzs;
                    if (!z) {
                        i2 = 2;
                    }
                    fVar.anq(i2);
                    ImageGalleryUI.this.finish();
                    break;
            }
            AppMethodBeat.o(233314);
        }
    };
    private com.tencent.mm.ui.chatting.gallery.a.c Pzv = new com.tencent.mm.ui.chatting.gallery.a.c() {
        /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass33 */

        {
            AppMethodBeat.i(161543);
            AppMethodBeat.o(161543);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [long, java.lang.Object] */
        @Override // com.tencent.mm.plugin.scanner.api.a
        public final /* synthetic */ void c(long j2, com.tencent.mm.ui.chatting.gallery.a.b bVar) {
            AppMethodBeat.i(233350);
            com.tencent.mm.ui.chatting.gallery.a.b bVar2 = bVar;
            f fVar = bVar2.PBQ;
            if (fVar != null) {
                Log.i("MicroMsg.ImageGalleryUI", "alvinluo searchImagePreview onCallback currentMsgId: %d, opImageType: %d, result.msgId: %d, success: %b, resultCode: %d, searchImageWording: %s, errCode: %d, errMsg: %s", Long.valueOf(ImageGalleryUI.this.PyG), Integer.valueOf(fVar.CAT), Long.valueOf(bVar2.msgId), Boolean.valueOf(fVar.success), Integer.valueOf(bVar2.resultCode), fVar.CBb, Integer.valueOf(fVar.errCode), fVar.errMsg);
                if (fVar.CAT != 2 || ImageGalleryUI.this.PyG != bVar2.msgId) {
                    AppMethodBeat.o(233350);
                    return;
                } else if (!fVar.success || bVar2.resultCode != 2 || !ImageGalleryUI.b(fVar)) {
                    if (bVar2.resultCode == 3) {
                        com.tencent.mm.ui.chatting.gallery.a.g gVar = ImageGalleryUI.this.Pze;
                        Log.i("MicroMsg.ImageScanButtonStatusManager", "alvinluo disableAction type: %d", 1);
                        g.a aVar = gVar.PCk.get(1);
                        if (aVar != null) {
                            aVar.setEnable(false);
                        }
                        gVar.PCl.put(1, 2);
                        ImageGalleryUI.this.Pze.li(1, 5);
                    }
                    ImageGalleryUI.this.Pze.li(3, 2);
                    ImageGalleryUI.a(ImageGalleryUI.this, 3);
                } else {
                    ImageGalleryUI.this.Pzg = fVar;
                    ImageGalleryUI.this.Pze.li(3, 1);
                    ImageGalleryUI.this.Pze.e(3, new Runnable() {
                        /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass33.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(233348);
                            ImageGalleryUI.a(ImageGalleryUI.this, 3);
                            AppMethodBeat.o(233348);
                        }
                    });
                    AppMethodBeat.o(233350);
                    return;
                }
            }
            AppMethodBeat.o(233350);
        }

        @Override // com.tencent.mm.ui.chatting.gallery.a.c
        public final void bmZ(String str) {
            String str2;
            String str3;
            AppMethodBeat.i(233349);
            if (ImageGalleryUI.this.Pwu == null) {
                AppMethodBeat.o(233349);
                return;
            }
            ca amt = ImageGalleryUI.this.Pwu.amt(ImageGalleryUI.this.PzE);
            if (amt == null) {
                AppMethodBeat.o(233349);
                return;
            }
            boolean Eq = ab.Eq(amt.field_talker);
            com.tencent.mm.ui.chatting.gallery.a.f fVar = ImageGalleryUI.this.Pzs;
            long j2 = amt.field_msgSvrId;
            int i2 = Eq ? 2 : 1;
            String n = ImageGalleryUI.n(amt, Eq);
            if (Eq) {
                str2 = amt.field_talker;
            } else {
                str2 = "";
            }
            f.c cVar = fVar.PBY;
            if (cVar != null) {
                String valueOf = String.valueOf(System.currentTimeMillis());
                p.h(valueOf, "<set-?>");
                cVar.sessionId = valueOf;
                cVar.msgId = j2;
                cVar.scene = 67;
                cVar.chatType = i2;
                if (n == null) {
                    str3 = "";
                } else {
                    str3 = n;
                }
                p.h(str3, "<set-?>");
                cVar.PCe = str3;
                if (str2 == null) {
                    str2 = "";
                }
                p.h(str2, "<set-?>");
                cVar.qUK = str2;
                if (str == null) {
                    str = "";
                }
                p.h(str, "<set-?>");
                cVar.imagePath = str;
                AppMethodBeat.o(233349);
                return;
            }
            AppMethodBeat.o(233349);
        }
    };
    public b Pzw;
    private View Pzx;
    private CheckBox Pzy;
    private View Pzz;
    private final d VlB = new d(this, (byte) 0);
    protected String chatroomName;
    private View contentView;
    public ImageView gyr;
    private boolean isAnimated = false;
    private ImageView jUG;
    private MMHandler mHandler = new MMHandler(Looper.getMainLooper());
    public long msgId;
    private com.tencent.mm.ui.widget.a.e oXS;
    public TextView pIN;
    public MMNeat7extView pIO;
    public long ppv;
    Bundle qaD;
    com.tencent.mm.ui.tools.e qaE;
    int qaF = 0;
    int qaG = 0;
    int qaH = 0;
    int qaI = 0;
    private o.g rjz = new o.g() {
        /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass26 */

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(233337);
            if (ImageGalleryUI.this == null || ImageGalleryUI.this.isDestroyed() || ImageGalleryUI.this.isFinishing()) {
                Log.i("MicroMsg.ImageGalleryUI", "receive onMMMenuItemSelected but activity is invalid");
                AppMethodBeat.o(233337);
                return;
            }
            ImageGalleryUI.this.EAn.reset();
            Log.i("MicroMsg.ImageGalleryUI", "curTransState %d", Integer.valueOf(ImageGalleryUI.this.tgN));
            switch (menuItem.getItemId()) {
                case 0:
                    ca gSg = ImageGalleryUI.this.Pwu.gSg();
                    if (gSg == null || !gSg.cWJ()) {
                        ImageGalleryUI.this.Pwu.amO(ImageGalleryUI.this.xqs.getCurrentItem());
                    } else {
                        com.tencent.mm.modelvideo.s QN = u.QN(gSg.field_imgPath);
                        if (QN == null || QN.status == 199 || QN.status == 199) {
                            ImageGalleryUI.this.Pwu.amO(ImageGalleryUI.this.xqs.getCurrentItem());
                        } else {
                            ImageGalleryUI.this.Pzp = u.f(gSg.field_msgId, 1);
                            ImageGalleryUI.this.Pwu.amT(ImageGalleryUI.this.xqs.getCurrentItem());
                        }
                    }
                    if (gSg != null && gSg.cWK()) {
                        com.tencent.mm.plugin.webview.ui.tools.media.a aVar = com.tencent.mm.plugin.webview.ui.tools.media.a.JvG;
                        com.tencent.mm.plugin.webview.ui.tools.media.a.aN(1, ImageGalleryUI.W(ImageGalleryUI.this), ImageGalleryUI.X(ImageGalleryUI.this));
                        y cG = j.cG(gSg);
                        if (cG != null) {
                            h.a aVar2 = com.tencent.mm.plugin.webview.ui.tools.media.h.JwJ;
                            h.a.i(1, cG.KOf, cG.KOe, ImageGalleryUI.this.PyB.pHu);
                        }
                    }
                    if (br.D(gSg)) {
                        jc jcVar = new jc();
                        jcVar.emN = gSg.field_msgSvrId;
                        jcVar.eLn = (long) gSg.getType();
                        jcVar.eQu = (long) br.C(gSg);
                        jcVar.ejA = 5;
                        jcVar.bfK();
                    }
                    AppMethodBeat.o(233337);
                    return;
                case 1:
                    ca gSg2 = ImageGalleryUI.this.Pwu.gSg();
                    if (gSg2 == null || !gSg2.cWJ()) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(ImageGalleryUI.this.Pwu.gSg());
                        com.tencent.mm.modelstat.b.jmd.af((ca) arrayList.get(0));
                        b.f(ImageGalleryUI.this.getContext(), arrayList);
                    } else {
                        com.tencent.mm.modelvideo.s QN2 = u.QN(gSg2.field_imgPath);
                        if (QN2 == null || QN2.status == 199 || QN2.status == 199) {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(ImageGalleryUI.this.Pwu.gSg());
                            b.f(ImageGalleryUI.this.getContext(), arrayList2);
                        } else {
                            ImageGalleryUI.this.Pzp = u.f(gSg2.field_msgId, 2);
                            ImageGalleryUI.this.Pwu.amT(ImageGalleryUI.this.xqs.getCurrentItem());
                        }
                    }
                    if (br.D(gSg2)) {
                        jc jcVar2 = new jc();
                        jcVar2.emN = gSg2.field_msgSvrId;
                        jcVar2.eLn = (long) gSg2.getType();
                        jcVar2.eQu = (long) br.C(gSg2);
                        jcVar2.ejA = 7;
                        jcVar2.bfK();
                    }
                    AppMethodBeat.o(233337);
                    return;
                case 2:
                    if (com.tencent.mm.br.c.aZU("favorite")) {
                        ImageGalleryUI.this.Pwu.amQ(ImageGalleryUI.this.xqs.getCurrentItem());
                        ca gSg3 = ImageGalleryUI.this.Pwu.gSg();
                        if (gSg3 != null && gSg3.cWK()) {
                            com.tencent.mm.plugin.webview.ui.tools.media.a aVar3 = com.tencent.mm.plugin.webview.ui.tools.media.a.JvG;
                            com.tencent.mm.plugin.webview.ui.tools.media.a.aN(2, ImageGalleryUI.W(ImageGalleryUI.this), ImageGalleryUI.X(ImageGalleryUI.this));
                        }
                        AppMethodBeat.o(233337);
                        return;
                    }
                    break;
                case 3:
                    Log.i("MicroMsg.ImageGalleryUI", "request deal QBAR string");
                    if (ImageGalleryUI.this.oXS != null && ImageGalleryUI.this.oXS.isShowing()) {
                        ImageGalleryUI.this.oXS.bMo();
                    }
                    String safeFormatString = Util.safeFormatString("%d,%d", 1, Long.valueOf(System.currentTimeMillis()));
                    Log.i("MicroMsg.ImageGalleryUI", "18684 report:".concat(String.valueOf(safeFormatString)));
                    com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(18684, safeFormatString);
                    ImageGalleryUI.Z(ImageGalleryUI.this);
                    AppMethodBeat.o(233337);
                    return;
                case 4:
                    ImageGalleryUI.this.Pwu.amP(ImageGalleryUI.this.xqs.getCurrentItem());
                    AppMethodBeat.o(233337);
                    return;
                case 5:
                    ImageGalleryUI.Y(ImageGalleryUI.this);
                    AppMethodBeat.o(233337);
                    return;
                case 6:
                    if (ImageGalleryUI.this.Pwu != null) {
                        if (b.j(ImageGalleryUI.this.Pwu.gSg())) {
                            ImageGalleryUI.aa(ImageGalleryUI.this);
                        }
                        AppMethodBeat.o(233337);
                        return;
                    }
                    break;
                case 7:
                    if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(ImageGalleryUI.this.getContext())) {
                        ImageGalleryUI.ab(ImageGalleryUI.this);
                        AppMethodBeat.o(233337);
                        return;
                    }
                    break;
                case 10:
                    ca gSg4 = ImageGalleryUI.this.Pwu.gSg();
                    if (gSg4 != null && gSg4.cWK()) {
                        com.tencent.mm.plugin.webview.ui.tools.media.a aVar4 = com.tencent.mm.plugin.webview.ui.tools.media.a.JvG;
                        com.tencent.mm.plugin.webview.ui.tools.media.a.aN(4, ImageGalleryUI.W(ImageGalleryUI.this), ImageGalleryUI.X(ImageGalleryUI.this));
                        y cG2 = j.cG(gSg4);
                        if (cG2 != null) {
                            ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(cG2, ImageGalleryUI.this, ImageGalleryUI.this.PyB.pHu);
                        }
                        AppMethodBeat.o(233337);
                        return;
                    }
                case 11:
                    ImageGalleryUI.b(ImageGalleryUI.this, System.currentTimeMillis());
                    AppMethodBeat.o(233337);
                    return;
                case 12:
                    ImageGalleryUI.ac(ImageGalleryUI.this);
                    break;
            }
            AppMethodBeat.o(233337);
        }
    };
    public View tFX;
    protected String talker;
    public boolean tca = false;
    private com.tencent.mm.plugin.scanner.word.a tgL;
    private volatile int tgM;
    private int tgN = 0;
    private ImageView tgP;
    private ImageView tgQ;
    private ImageView tgR;
    private ValueAnimator tgS;
    private IListener<tp> tgT = new IListener<tp>() {
        /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass27 */

        {
            AppMethodBeat.i(233339);
            this.__eventId = tp.class.getName().hashCode();
            AppMethodBeat.o(233339);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(tp tpVar) {
            AppMethodBeat.i(233340);
            final tp tpVar2 = tpVar;
            Log.i("MicroMsg.ImageGalleryUI", "scanTranslationResult %d, %s", Integer.valueOf(tpVar2.dZZ.dEb), Boolean.valueOf(tpVar2.dZZ.dDz));
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass27.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(233338);
                    if (ImageGalleryUI.this.tgM == tpVar2.dZZ.dEb) {
                        ImageGalleryUI.u(ImageGalleryUI.this);
                        if (tpVar2.dZZ.dDz) {
                            if (s.YS(tpVar2.dZZ.eaa)) {
                                String a2 = ImageGalleryUI.a(ImageGalleryUI.this);
                                Intent intent = new Intent();
                                intent.putExtra("original_file_path", a2);
                                intent.putExtra("msg_id", ImageGalleryUI.this.Pwu.amt(ImageGalleryUI.this.PzE).field_msgId);
                                intent.putExtra("translate_source", tpVar2.dZZ.source);
                                com.tencent.mm.av.g k = ImageGalleryUI.k(ImageGalleryUI.this.Pwu.gSg());
                                if (k != null) {
                                    intent.putExtra("fileid", k.getFileId());
                                    intent.putExtra("aeskey", k.getAesKey());
                                }
                                ImageGalleryUI.a(ImageGalleryUI.this, TranslationResultUI.class, intent);
                                ImageGalleryUI.this.finish();
                                ImageGalleryUI.this.overridePendingTransition(R.anim.s, R.anim.s);
                                ImageGalleryUI.this.Pzs.anq(1);
                                AppMethodBeat.o(233338);
                                return;
                            }
                            Log.w("MicroMsg.ImageGalleryUI", "trans result path %s not exist!", tpVar2.dZZ.eaa);
                        }
                        ImageGalleryUI.y(ImageGalleryUI.this);
                        com.tencent.mm.ui.base.h.a((Context) ImageGalleryUI.this, ImageGalleryUI.this.getString(R.string.ge4), "", false, (DialogInterface.OnClickListener) null);
                        ImageGalleryUI.this.Pzs.anq(2);
                    }
                    AppMethodBeat.o(233338);
                }
            });
            AppMethodBeat.o(233340);
            return true;
        }
    };
    private com.tencent.mm.network.p tgU = new p.a() {
        /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass44 */

        @Override // com.tencent.mm.network.p
        public final void onNetworkChange(int i2) {
            AppMethodBeat.i(233365);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass44.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(233364);
                    if (com.tencent.mm.kernel.g.azz().aYS() == 6 || com.tencent.mm.kernel.g.azz().aYS() == 4) {
                        if (ImageGalleryUI.this.Pwu == null) {
                            AppMethodBeat.o(233364);
                            return;
                        }
                        int currentItem = ImageGalleryUI.this.getCurrentItem();
                        ca amt = ImageGalleryUI.this.Pwu.amt(currentItem);
                        if (amt != null && amt.cWK()) {
                            if (ImageGalleryUI.this.Pwu.gSh() == null) {
                                ImageGalleryUI.this.Pwu.gSh().gTe();
                            }
                            if (ImageGalleryUI.this.Pwu.gSh().gTe().PAP.getVisibility() == 0 || ImageGalleryUI.this.Pwu.gSh().gTe().PAY.getVisibility() == 0) {
                                ImageGalleryUI.this.Pwu.amS(currentItem);
                            }
                        }
                    } else if (ImageGalleryUI.this.tgN == 1) {
                        com.tencent.mm.ui.base.h.c(ImageGalleryUI.this, ImageGalleryUI.this.getString(R.string.x3), "", true);
                        ImageGalleryUI.u(ImageGalleryUI.this);
                        ImageGalleryUI.this.Pzs.anq(2);
                        AppMethodBeat.o(233364);
                        return;
                    }
                    AppMethodBeat.o(233364);
                }
            });
            AppMethodBeat.o(233365);
        }
    };
    private RelativeLayout tmY;
    MTimerHandler tnh = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass34 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(233351);
            if (ImageGalleryUI.this.PzM) {
                ImageGalleryUI.this.gSG();
            }
            AppMethodBeat.o(233351);
            return false;
        }
    }, false);
    protected MMViewPager xqs;
    private boolean zss;

    public interface b {
        void t(Boolean bool);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // com.tencent.mm.plugin.scanner.word.a.AbstractC1683a
    public final /* synthetic */ void M(String str, com.tencent.mm.plugin.scanner.word.b bVar) {
        boolean z;
        final boolean z2;
        int i2 = 3;
        AppMethodBeat.i(36214);
        com.tencent.mm.plugin.scanner.word.b bVar2 = bVar;
        String cVV = cVV();
        if (!str.equals(cVV)) {
            Log.i("MicroMsg.ImageGalleryUI", "scanTranslate onEnd, not the same image");
            AppMethodBeat.o(36214);
            return;
        }
        if (((com.tencent.mm.plugin.scanner.api.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.scanner.api.c.class)).gy(bVar2.CVF)) {
            this.Erb = true;
            if (this.oXS != null && this.oXS.isShowing()) {
                dTH();
            }
        }
        int gw = com.tencent.mm.plugin.scanner.i.gw(bVar2.CVF);
        Log.i("MicroMsg.ImageGalleryUI", "scanTranslate onEnd, img %s, ratioList %s, ratio %d, showOcrMenu: %b", cVV, bVar2.CVF, Integer.valueOf(gw), Boolean.valueOf(this.Erb));
        if (gw > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_img_word_detect_threshold, 100);
            Log.i("MicroMsg.ScannerHelper", "show quick menu, translateLangRatio %d, threshold %d", Integer.valueOf(gw), Integer.valueOf(a2));
            if (gw >= a2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.Pze.ans(1) == 5) {
                bI(1, false);
                AppMethodBeat.o(36214);
                return;
            }
            com.tencent.mm.ui.chatting.gallery.a.g gVar = this.Pze;
            if (z2) {
                i2 = 1;
            }
            gVar.li(1, i2);
            this.Pze.e(1, new Runnable() {
                /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass43 */

                public final void run() {
                    AppMethodBeat.i(233363);
                    if (z2) {
                        ImageGalleryUI.this.Pzo = true;
                        ImageGalleryUI.a(ImageGalleryUI.this, 1);
                    }
                    AppMethodBeat.o(233363);
                }
            });
            if (!z2) {
                bI(1, false);
            }
            AppMethodBeat.o(36214);
            return;
        }
        this.Pze.li(1, 2);
        bI(1, false);
        AppMethodBeat.o(36214);
    }

    public ImageGalleryUI() {
        AppMethodBeat.i(36149);
        AppMethodBeat.o(36149);
    }

    static /* synthetic */ void C(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(258964);
        imageGalleryUI.cvQ();
        AppMethodBeat.o(258964);
    }

    static /* synthetic */ c P(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(258969);
        c gSC = imageGalleryUI.gSC();
        AppMethodBeat.o(258969);
        return gSC;
    }

    static /* synthetic */ boolean Q(ImageGalleryUI imageGalleryUI) {
        if (imageGalleryUI.Pzn == 1) {
            return false;
        }
        return true;
    }

    static /* synthetic */ boolean R(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(258970);
        boolean gSD = imageGalleryUI.gSD();
        AppMethodBeat.o(258970);
        return gSD;
    }

    static /* synthetic */ boolean S(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(258971);
        boolean gMw = imageGalleryUI.gMw();
        AppMethodBeat.o(258971);
        return gMw;
    }

    static /* synthetic */ int W(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(258974);
        int gSN = imageGalleryUI.gSN();
        AppMethodBeat.o(258974);
        return gSN;
    }

    static /* synthetic */ int X(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(258975);
        int gSM = imageGalleryUI.gSM();
        AppMethodBeat.o(258975);
        return gSM;
    }

    static /* synthetic */ void Z(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(233442);
        imageGalleryUI.BY(false);
        AppMethodBeat.o(233442);
    }

    static /* synthetic */ View a(ImageGalleryUI imageGalleryUI, b bVar, MMViewPager mMViewPager) {
        AppMethodBeat.i(258966);
        View a2 = imageGalleryUI.a(bVar, mMViewPager);
        AppMethodBeat.o(258966);
        return a2;
    }

    static /* synthetic */ String a(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(233410);
        String cVV = imageGalleryUI.cVV();
        AppMethodBeat.o(233410);
        return cVV;
    }

    static /* synthetic */ void a(ImageGalleryUI imageGalleryUI, int i2) {
        AppMethodBeat.i(258950);
        imageGalleryUI.bI(i2, false);
        AppMethodBeat.o(258950);
    }

    static /* synthetic */ void a(ImageGalleryUI imageGalleryUI, View view, String str, Bitmap bitmap, com.tencent.mm.ui.chatting.gallery.a.h hVar) {
        AppMethodBeat.i(258953);
        imageGalleryUI.a(view, str, bitmap, 1, hVar);
        AppMethodBeat.o(258953);
    }

    static /* synthetic */ void a(ImageGalleryUI imageGalleryUI, Class cls, Intent intent) {
        AppMethodBeat.i(258979);
        imageGalleryUI.startActivity(cls, intent);
        AppMethodBeat.o(258979);
    }

    static /* synthetic */ void aa(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(233444);
        imageGalleryUI.gSV();
        AppMethodBeat.o(233444);
    }

    static /* synthetic */ void ab(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(258977);
        imageGalleryUI.BZ(false);
        AppMethodBeat.o(258977);
    }

    static /* synthetic */ void ae(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(258980);
        imageGalleryUI.gSy();
        AppMethodBeat.o(258980);
    }

    static /* synthetic */ ImageGalleryUI am(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(258984);
        ImageGalleryUI gSq = imageGalleryUI.gSq();
        AppMethodBeat.o(258984);
        return gSq;
    }

    static /* synthetic */ void b(ImageGalleryUI imageGalleryUI, long j2) {
        AppMethodBeat.i(258978);
        imageGalleryUI.aq(j2, 2);
        AppMethodBeat.o(258978);
    }

    static /* synthetic */ boolean c(ImageGalleryUI imageGalleryUI, String str) {
        AppMethodBeat.i(258973);
        boolean bmX = imageGalleryUI.bmX(str);
        AppMethodBeat.o(258973);
        return bmX;
    }

    static /* synthetic */ boolean d(ImageGalleryUI imageGalleryUI, int i2) {
        AppMethodBeat.i(258972);
        boolean anc = imageGalleryUI.anc(i2);
        AppMethodBeat.o(258972);
        return anc;
    }

    static /* synthetic */ void e(ImageGalleryUI imageGalleryUI, int i2) {
        AppMethodBeat.i(258983);
        imageGalleryUI.ane(i2);
        AppMethodBeat.o(258983);
    }

    static /* synthetic */ boolean f(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(258949);
        boolean hYE = imageGalleryUI.hYE();
        AppMethodBeat.o(258949);
        return hYE;
    }

    static /* synthetic */ void hW(View view) {
        AppMethodBeat.i(258952);
        aL(view, 8);
        AppMethodBeat.o(258952);
    }

    static /* synthetic */ ImageGalleryUI i(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(233413);
        ImageGalleryUI gSu = imageGalleryUI.gSu();
        AppMethodBeat.o(233413);
        return gSu;
    }

    static /* synthetic */ ImageGalleryUI l(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(258951);
        ImageGalleryUI gSv = imageGalleryUI.gSv();
        AppMethodBeat.o(258951);
        return gSv;
    }

    static /* synthetic */ String n(ca caVar, boolean z) {
        AppMethodBeat.i(258955);
        String k = k(caVar, z);
        AppMethodBeat.o(258955);
        return k;
    }

    static /* synthetic */ void s(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(258958);
        imageGalleryUI.fhA();
        AppMethodBeat.o(258958);
    }

    static /* synthetic */ void v(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(258960);
        imageGalleryUI.gSB();
        AppMethodBeat.o(258960);
    }

    static /* synthetic */ boolean w(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(258961);
        boolean fhB = imageGalleryUI.fhB();
        AppMethodBeat.o(258961);
        return fhB;
    }

    static /* synthetic */ void z(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(258962);
        imageGalleryUI.Ci(true);
        AppMethodBeat.o(258962);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(36150);
        Log.i("MicroMsg.ImageGalleryUI", "on pause");
        super.onPause();
        if (!gSA() && Build.VERSION.SDK_INT >= 21) {
            getWindow().setFlags(2048, 2048);
        }
        if (!isFinishing() && this.Pwu != null) {
            b bVar = this.Pwu;
            bVar.PwB.PAq.sendEmptyMessageDelayed(1, 200);
            bVar.PwC.stopAll();
        }
        com.tencent.mm.plugin.ball.f.f.e(false, true, true);
        gSx().PyS.setBubbleClickListener(this);
        gSw().PyR.setOnClickListener(this);
        AppMethodBeat.o(36150);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(36151);
        super.onStop();
        com.tencent.mm.graphics.b.d.INSTANCE.axH();
        if (com.tencent.mm.graphics.b.c.INSTANCE.hki) {
            com.tencent.mm.graphics.b.c.INSTANCE.stop();
        }
        aL(gSv().PyQ, 8);
        AppMethodBeat.o(36151);
    }

    /* access modifiers changed from: package-private */
    public final ImageGalleryUI gSq() {
        AppMethodBeat.i(36152);
        if (this.PyT == null) {
            this.PyT = findViewById(R.id.dvm);
            this.PyU = (Button) this.PyT.findViewById(R.id.biv);
            this.PyV = (Button) this.PyT.findViewById(R.id.biw);
            this.PyW = this.PyT.findViewById(R.id.bix);
            this.PyU.getPaint().setFakeBoldText(true);
            this.PyV.getPaint().setFakeBoldText(true);
            ((TextView) this.PyT.findViewById(R.id.bir)).getPaint().setFakeBoldText(true);
            float min = Math.min(1.125f, com.tencent.mm.cb.a.ez(this));
            this.PyU.setTextSize(1, 12.0f * min);
            this.PyV.setTextSize(1, min * 12.0f);
        }
        AppMethodBeat.o(36152);
        return this;
    }

    /* access modifiers changed from: protected */
    public final ImageGalleryUI gSr() {
        AppMethodBeat.i(36153);
        if (this.FLz == null) {
            this.FLz = (RedesignVideoPlayerSeekBar) findViewById(R.id.j5y);
            this.JvS = findViewById(R.id.irz);
            this.FLz.setPlayBtnOnClickListener(this);
        }
        AppMethodBeat.o(36153);
        return this;
    }

    private ImageGalleryUI gSs() {
        AppMethodBeat.i(36154);
        if (this.PyL == null) {
            this.PyL = findViewById(R.id.c41);
        }
        AppMethodBeat.o(36154);
        return this;
    }

    private ImageGalleryUI gSt() {
        AppMethodBeat.i(36155);
        if (this.PyN == null) {
            this.PyN = findViewById(R.id.btn);
        }
        AppMethodBeat.o(36155);
        return this;
    }

    private ImageGalleryUI gSu() {
        AppMethodBeat.i(233371);
        if (this.PyP == null) {
            this.PyP = findViewById(R.id.dcr);
        }
        AppMethodBeat.o(233371);
        return this;
    }

    private ImageGalleryUI gSv() {
        AppMethodBeat.i(233372);
        if (this.PyQ == null) {
            this.PyQ = findViewById(R.id.hap);
        }
        AppMethodBeat.o(233372);
        return this;
    }

    private ImageGalleryUI gSw() {
        AppMethodBeat.i(233373);
        if (this.PyR == null) {
            this.PyR = findViewById(R.id.dcs);
        }
        AppMethodBeat.o(233373);
        return this;
    }

    private ImageGalleryUI gSx() {
        AppMethodBeat.i(233374);
        if (this.PyS == null) {
            this.PyS = (SearchImageBubbleView) findViewById(R.id.he_);
        }
        AppMethodBeat.o(233374);
        return this;
    }

    private static void aL(View view, int i2) {
        AppMethodBeat.i(36156);
        if (view != null) {
            view.setVisibility(i2);
        }
        AppMethodBeat.o(36156);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean noActionBar() {
        AppMethodBeat.i(233375);
        if (!gSA()) {
            AppMethodBeat.o(233375);
            return true;
        }
        AppMethodBeat.o(233375);
        return false;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(36157);
        requestWindowFeature(1);
        ao.bm(this);
        if (gSA()) {
            setTheme(R.style.pp);
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.PzA = true;
        super.onCreate(bundle);
        if (gSA()) {
            setMMTitle("");
            addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass45 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(233366);
                    ImageGalleryUI.v(ImageGalleryUI.this);
                    AppMethodBeat.o(233366);
                    return true;
                }
            });
            setBackBtn(new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass46 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(233367);
                    ImageGalleryUI.this.finish();
                    AppMethodBeat.o(233367);
                    return true;
                }
            });
        } else {
            if (com.tencent.mm.compatible.util.d.oD(19)) {
                getWindow().setFlags(201327616, 201327616);
                this.zss = true;
            } else {
                getWindow().setFlags(1024, 1024);
                this.zss = false;
            }
            setLightNavigationbarIcon();
        }
        initView();
        if (this.Pwu != null) {
            this.Pzs.b(1, d.k(this.Pwu.gSg()));
        }
        this.qaD = bundle;
        EventCenter.instance.addListener(this.tgT);
        this.FLK = false;
        this.Pzr = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.b() {
            /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.b
            public final void asu(String str) {
                AppMethodBeat.i(233302);
                if (ImageGalleryUI.this.oXS != null && ImageGalleryUI.this.oXS.isShowing() && Util.isEqual(str, ImageGalleryUI.this.Pzb.CFJ)) {
                    ImageGalleryUI.this.dTH();
                }
                AppMethodBeat.o(233302);
            }
        });
        Log.d("MicroMsg.ImageGalleryUI", "ImageGallery onCreate spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(36157);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        int i2;
        AppMethodBeat.i(36158);
        super.onResume();
        if (this.Pwu != null) {
            if (this.Pwu.PwE) {
                i2 = 0;
            } else {
                i2 = 100000;
            }
            b.a.PwO = i2;
        }
        if (!gSA() && Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(2048);
        }
        if (!this.PzA && this.Pwu != null) {
            and(this.xqs.getCurrentItem());
        }
        this.PzA = false;
        if (this.Pwu != null) {
            this.Pwu.gSi();
        }
        com.tencent.mm.kernel.g.aAg().a(this.tgU);
        com.tencent.mm.plugin.ball.f.f.e(true, true, true);
        AppMethodBeat.o(36158);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        ca amt;
        boolean z = true;
        AppMethodBeat.i(36159);
        this.Pzk = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
        if (!this.Pyy && !gSA()) {
            Bundle bundle = this.qaD;
            Log.i("MicroMsg.ImageGalleryUI", "[handleAnimation] isAnimated:" + this.isAnimated);
            if (!this.isAnimated) {
                this.isAnimated = true;
                if (Build.VERSION.SDK_INT >= 12) {
                    this.qaF = getIntent().getIntExtra("img_gallery_top", 0);
                    this.qaG = getIntent().getIntExtra("img_gallery_left", 0);
                    this.qaH = getIntent().getIntExtra("img_gallery_width", 0);
                    this.qaI = getIntent().getIntExtra("img_gallery_height", 0);
                    if (this.qaF == 0 && this.qaG == 0 && this.qaH == 0 && this.qaI == 0 && (amt = this.Pwu.amt(this.xqs.getCurrentItem())) != null) {
                        bf bfVar = new bf();
                        bfVar.dEo.dCM = amt;
                        EventCenter.instance.publish(bfVar);
                        this.qaH = bfVar.dEp.dEs;
                        this.qaI = bfVar.dEp.dEt;
                        this.qaG = bfVar.dEp.dEq;
                        this.qaF = bfVar.dEp.dEr;
                    }
                    this.qaE.Q(this.qaG, this.qaF, this.qaH, this.qaI);
                    Object[] objArr = new Object[1];
                    if (bundle != null) {
                        z = false;
                    }
                    objArr[0] = Boolean.valueOf(z);
                    Log.i("MicroMsg.ImageGalleryUI", "[handleAnimation] savedInstanceState is null?%s", objArr);
                    if (bundle == null) {
                        this.xqs.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                            /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass14 */

                            public final boolean onPreDraw() {
                                com.tencent.mm.ui.base.g gVar;
                                AppMethodBeat.i(233319);
                                ImageGalleryUI.this.xqs.getViewTreeObserver().removeOnPreDrawListener(this);
                                Log.i("MicroMsg.ImageGalleryUI", "[handleAnimation] -> onPreDraw, isBackFromGrid:" + ImageGalleryUI.this.Pzk);
                                ImageGalleryUI.this.EAz = ImageGalleryUI.this.xqs.getWidth();
                                ImageGalleryUI.this.EAA = ImageGalleryUI.this.xqs.getHeight();
                                if (ImageGalleryUI.this.Pwu.gSg().cWL()) {
                                    ImageGalleryUI.this.EAA = (int) ((((float) ImageGalleryUI.this.EAz) / ((float) ImageGalleryUI.this.qaH)) * ((float) ImageGalleryUI.this.qaI));
                                }
                                if (ImageGalleryUI.this.Pwu.gSg().gAz() && (gVar = (com.tencent.mm.ui.base.g) ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.this.Pwu, ImageGalleryUI.this.xqs)) != null) {
                                    ImageGalleryUI.this.EAA = (int) (((float) gVar.getImageHeight()) * (((float) ImageGalleryUI.this.EAz) / ((float) gVar.getImageWidth())));
                                    if (ImageGalleryUI.this.EAA > ImageGalleryUI.this.xqs.getHeight()) {
                                        ImageGalleryUI.this.EAA = ImageGalleryUI.this.xqs.getHeight();
                                    }
                                }
                                ImageGalleryUI.this.qaE.ls(ImageGalleryUI.this.EAz, ImageGalleryUI.this.EAA);
                                if (!ImageGalleryUI.this.Pzk) {
                                    ImageGalleryUI.this.qaE.a(ImageGalleryUI.this.xqs, ImageGalleryUI.this.jUG, new e.c() {
                                        /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass14.AnonymousClass1 */

                                        @Override // com.tencent.mm.ui.tools.e.c
                                        public final void onAnimationStart() {
                                            AppMethodBeat.i(233317);
                                            if (ImageGalleryUI.this.Pzw != null) {
                                                ImageGalleryUI.this.Pzw.t(Boolean.TRUE);
                                            }
                                            AppMethodBeat.o(233317);
                                        }

                                        @Override // com.tencent.mm.ui.tools.e.c
                                        public final void onAnimationEnd() {
                                            AppMethodBeat.i(233318);
                                            ImageGalleryUI.this.mHandler.post(new Runnable() {
                                                /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass14.AnonymousClass1.AnonymousClass1 */

                                                public final void run() {
                                                    AppMethodBeat.i(233316);
                                                    if (ImageGalleryUI.this.Pzw != null) {
                                                        ImageGalleryUI.this.Pzw.t(Boolean.FALSE);
                                                    }
                                                    AppMethodBeat.o(233316);
                                                }
                                            });
                                            AppMethodBeat.o(233318);
                                        }
                                    });
                                }
                                ImageGalleryUI.J(ImageGalleryUI.this);
                                AppMethodBeat.o(233319);
                                return true;
                            }
                        });
                    }
                }
            }
        }
        super.onStart();
        AppMethodBeat.o(36159);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        long j2;
        AppMethodBeat.i(36160);
        Log.i("MicroMsg.ImageGalleryUI", "%d image gallery ui on destroy", Integer.valueOf(hashCode()));
        try {
            if (this.Pwu != null) {
                ane(this.PzE);
                this.PyB.a(this, this.PzE, 0);
                this.Pwu.detach();
                this.Pwu = null;
            }
            this.tnh.stopTimer();
            Cc(false);
            this.tgS.removeAllUpdateListeners();
            EventCenter.instance.removeListener(this.tgT);
            com.tencent.mm.kernel.g.aAg().b(this.tgU);
            rl rlVar = new rl();
            rlVar.dYc.activity = this;
            EventCenter.instance.publish(rlVar);
            if (this.FLz != null) {
                this.FLz.setPlayBtnOnClickListener(null);
            }
            this.FLz = null;
            gSy();
            if (this.Pzd != null) {
                j jVar = this.Pzd;
                if (jVar.PCs) {
                    jVar.PCy.dead();
                    jVar.PCz.dead();
                    jVar.PCA.dead();
                }
                Set<String> keySet = jVar.PCt.keySet();
                kotlin.g.b.p.g(keySet, "scanCodeRequestMap.keys");
                for (T t : keySet) {
                    j.b bVar = jVar.PCt.get(t);
                    ax axVar = new ax();
                    axVar.dDY.filePath = t;
                    ax.a aVar = axVar.dDY;
                    if (bVar != null) {
                        j2 = bVar.dDZ;
                    } else {
                        j2 = 0;
                    }
                    aVar.dDZ = j2;
                    EventCenter.instance.publish(axVar);
                }
                jVar.PCt.clear();
                jVar.PCu.clear();
                jVar.PCv.clear();
                Log.v("MicroMsg.ImageScanCodeManager", "releaseHandleCode");
                Set<String> keySet2 = jVar.PCw.keySet();
                kotlin.g.b.p.g(keySet2, "handleCodeRequestMap.keys");
                for (T t2 : keySet2) {
                    aw awVar = new aw();
                    awVar.dDW.activity = jVar.dKq;
                    awVar.dDW.dDX = t2;
                    EventCenter.instance.publish(awVar);
                }
                jVar.PCx.clear();
            }
            if (this.Pzh != null) {
                l lVar = this.Pzh;
                Log.d("MicroMsg.ImageSearchPreviewManager", "alvinluo release previewImage session size: %d", Integer.valueOf(lVar.PCJ.size()));
                for (Map.Entry<Long, com.tencent.mm.ui.chatting.gallery.a.a> entry : lVar.PCL.entrySet()) {
                    l.Is(entry.getKey().longValue());
                }
                lVar.PCK.clear();
                lVar.PCJ.clear();
            }
            if (this.EAm != null) {
                this.EAm.release();
            }
            m.release();
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ImageGalleryUI", e2, "", new Object[0]);
        }
        if (com.tencent.mm.graphics.b.c.INSTANCE.hki) {
            com.tencent.mm.graphics.b.c.INSTANCE.stop();
        }
        super.onDestroy();
        AppMethodBeat.o(36160);
    }

    private void gSy() {
        int i2 = 2;
        AppMethodBeat.i(233376);
        boolean anc = anc(1);
        boolean anc2 = anc(2);
        if (anc && anc2) {
            i2 = 4;
        } else if (anc) {
            i2 = 3;
        } else if (!anc2) {
            i2 = 1;
        }
        this.Pzs.ano(i2);
        AppMethodBeat.o(233376);
    }

    private boolean anc(int i2) {
        AppMethodBeat.i(233377);
        if (this.Pze.ans(i2) != 2) {
            AppMethodBeat.o(233377);
            return true;
        }
        AppMethodBeat.o(233377);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(36161);
        Log.i("MicroMsg.ImageGalleryUI", "onBackPressed");
        if (fhB()) {
            AppMethodBeat.o(36161);
        } else if (this.Pzj) {
            anf(1);
            AppMethodBeat.o(36161);
        } else {
            try {
                h.a.gSp().detach();
                cvQ();
                AppMethodBeat.o(36161);
            } catch (Exception e2) {
                Log.e("MicroMsg.ImageGalleryUI", e2.getMessage());
                finish();
                AppMethodBeat.o(36161);
            }
        }
    }

    private void fhA() {
        AppMethodBeat.i(233378);
        this.PyA = true;
        if (this.xqs != null) {
            this.xqs.setEnableGalleryScale(true);
            this.xqs.setSingleMode(false);
        }
        AppMethodBeat.o(233378);
    }

    private boolean fhB() {
        AppMethodBeat.i(233379);
        fhA();
        if (this.EAm == null || !this.EAm.It(this.EAl)) {
            AppMethodBeat.o(233379);
            return false;
        }
        this.EAl = 0;
        AppMethodBeat.o(233379);
        return true;
    }

    private String gSz() {
        AppMethodBeat.i(36162);
        if (this.chatroomName == null || this.chatroomName.length() <= 0) {
            String str = this.talker;
            AppMethodBeat.o(36162);
            return str;
        }
        String str2 = this.chatroomName;
        AppMethodBeat.o(36162);
        return str2;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        ca caVar;
        AppMethodBeat.i(36163);
        this.qaE = new com.tencent.mm.ui.tools.e(getContext());
        this.isAnimated = false;
        this.talker = getIntent().getStringExtra("img_gallery_talker");
        this.Pzj = getIntent().getBooleanExtra("img_gallery_enter_from_grid", false);
        this.Ptr = getIntent().getBooleanExtra("img_gallery_enter_from_chatting_ui", false);
        this.Pzl = getIntent().getBooleanExtra("img_gallery_enter_from_appbrand_service_chatting_ui", false);
        this.Ptq = getIntent().getBooleanExtra("show_search_chat_content_result", false);
        this.Pzi = getIntent().getBooleanExtra("show_enter_grid", true);
        this.tca = getIntent().getBooleanExtra("key_is_biz_chat", false);
        this.ppv = getIntent().getLongExtra("key_biz_chat_id", -1);
        this.Pyy = getIntent().getBooleanExtra("img_preview_only", false);
        this.Pzn = getIntent().getIntExtra("img_gallery_enter_from_scene", 0);
        this.Pdu = getIntent().getIntExtra("msg_type", 0);
        if (!this.Pyy && Util.isNullOrNil(this.talker)) {
            Log.e("MicroMsg.ImageGalleryUI", " initView, talker is null. intent: " + getIntent());
        }
        this.chatroomName = getIntent().getStringExtra("img_gallery_chatroom_name");
        this.Pzk = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
        this.Pzp = getIntent().getStringExtra("img_gallery_enter_video_opcode");
        boolean booleanExtra = getIntent().getBooleanExtra("img_gallery_is_restransmit_after_download", false);
        String stringExtra = getIntent().getStringExtra("img_gallery_directly_send_name");
        this.tgQ = (ImageView) findViewById(R.id.hb1);
        this.tgR = (ImageView) findViewById(R.id.haz);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.tgR.getLayoutParams();
        layoutParams.bottomMargin += au.aD(this);
        this.tgR.setLayoutParams(layoutParams);
        this.tgR.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(233303);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ImageGalleryUI.w(ImageGalleryUI.this);
                ay ayVar = new ay();
                ayVar.dEa.scene = 1;
                ayVar.dEa.dEb = ImageGalleryUI.this.tgM;
                EventCenter.instance.publish(ayVar);
                ImageGalleryUI.u(ImageGalleryUI.this);
                ImageGalleryUI.y(ImageGalleryUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(233303);
            }
        });
        this.tgP = (ImageView) findViewById(R.id.hb2);
        this.tgS = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.tgS.setDuration(5000L);
        this.tgS.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass11 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(233312);
                ImageGalleryUI.this.tgP.setAlpha(0.0f);
                AppMethodBeat.o(233312);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(233313);
                ImageGalleryUI.this.tgP.setAlpha(0.0f);
                AppMethodBeat.o(233313);
            }
        });
        final int height = getWindowManager().getDefaultDisplay().getHeight();
        this.tgS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass13 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(233315);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue <= 0.1f) {
                    ImageGalleryUI.this.tgP.setAlpha(floatValue * 10.0f);
                } else if (floatValue >= 0.9f) {
                    ImageGalleryUI.this.tgP.setAlpha((1.0f - floatValue) * 10.0f);
                }
                ImageGalleryUI.this.tgP.setTranslationY(floatValue * ((float) (height - ImageGalleryUI.this.tgP.getHeight())));
                AppMethodBeat.o(233315);
            }
        });
        this.msgId = getIntent().getLongExtra("img_gallery_msg_id", 0);
        this.PwE = getIntent().getBooleanExtra("img_gallery_is_mp_video_without_msg", false);
        this.Pzm = getIntent().getIntExtra("img_gallery_mp_video_click_from", 2);
        long longExtra = getIntent().getLongExtra("img_gallery_msg_svr_id", 0);
        if (this.PwE) {
            caVar = j.f(this.talker, this);
        } else if (this.msgId > 0 || longExtra != 0) {
            if (this.msgId == 0) {
                bg.aVF();
                this.msgId = com.tencent.mm.model.c.aSQ().aJ(gSz(), longExtra).field_msgId;
            }
            bg.aVF();
            ca Hb = com.tencent.mm.model.c.aSQ().Hb(this.msgId);
            if (Hb.field_msgId <= 0) {
                Log.e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.msgId + ", msgSvrId = " + longExtra + ", stack = " + Util.getStack());
                finish();
                AppMethodBeat.o(36163);
                return;
            }
            caVar = Hb;
        } else {
            Log.e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.msgId + ", msgSvrId = " + longExtra + ", stack = " + Util.getStack());
            finish();
            AppMethodBeat.o(36163);
            return;
        }
        this.Pzq = NQ(this.msgId) == 3;
        if (com.tencent.mm.q.a.aty()) {
            this.Pzq = true;
        }
        this.Pwu = new b(this, this.msgId, gSz(), this.tca, this.ppv, booleanExtra, stringExtra, Boolean.valueOf(this.Pzk), this.Pdu);
        this.Pwu.PwF = false;
        this.Pwu.Pwy = getIntent().getBooleanExtra("start_chatting_ui", true);
        this.Pwu.PwD = new b.c() {
            /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass4 */

            @Override // com.tencent.mm.ui.chatting.gallery.b.c
            public final void tf() {
                AppMethodBeat.i(233304);
                if (ImageGalleryUI.this.Pwu == null) {
                    AppMethodBeat.o(233304);
                    return;
                }
                ImageGalleryUI.this.gSF();
                ImageGalleryUI.z(ImageGalleryUI.this);
                ImageGalleryUI.this.Pwu.onPageSelected(b.a.PwO);
                AppMethodBeat.o(233304);
            }
        };
        b bVar = this.Pwu;
        n nVar = this.PxO;
        if (bVar.PwA != null) {
            bVar.PwA.PxO = nVar;
        }
        com.tencent.mm.ui.chatting.gallery.a.e.init();
        this.Pzd = new j(this, !this.Pyy);
        this.Pze = new com.tencent.mm.ui.chatting.gallery.a.g();
        this.Pzc = com.tencent.mm.ui.chatting.gallery.a.e.gTr() && gSK();
        Log.i("MicroMsg.ImageGalleryUI", "initScanCode isPreviewOnly: %b, canShowScanCodeButton: %b, isEnterFromChattingUI: %b, isEnterFromGrid: %b", Boolean.valueOf(this.Pyy), Boolean.valueOf(this.Pzc), Boolean.valueOf(this.Ptr), Boolean.valueOf(this.Pzj));
        this.PyC = 0;
        this.PyD = getResources().getDimensionPixelSize(R.dimen.wr);
        this.PyE = getResources().getDimensionPixelSize(R.dimen.wq);
        this.tmY = (RelativeLayout) findViewById(R.id.biu);
        this.Pyx = (RelativeLayout) findViewById(R.id.biz);
        this.tmY.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(233305);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(233305);
            }
        });
        this.PyK = findViewById(R.id.j43);
        this.PyK.setOnClickListener(this);
        this.PyM = findViewById(R.id.j5w);
        this.PyO = findViewById(R.id.dct);
        if (bq(this)) {
            ghP();
        } else {
            ghQ();
        }
        this.jUG = (ImageView) findViewById(R.id.dcj);
        this.xqs = (MMViewPager) findViewById(R.id.dci);
        this.xqs.setVerticalFadingEdgeEnabled(false);
        this.xqs.setHorizontalFadingEdgeEnabled(false);
        this.xqs.setSingleClickOverListener(new MMViewPager.f() {
            /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass6 */

            @Override // com.tencent.mm.ui.base.MMViewPager.f
            public final void bmt() {
                AppMethodBeat.i(233306);
                if (ImageGalleryUI.this.PyA) {
                    ImageGalleryUI.B(ImageGalleryUI.this);
                }
                AppMethodBeat.o(233306);
            }

            @Override // com.tencent.mm.ui.base.MMViewPager.f
            public final void dSr() {
                AppMethodBeat.i(233307);
                ImageGalleryUI.C(ImageGalleryUI.this);
                AppMethodBeat.o(233307);
            }
        });
        this.xqs.setDoubleClickListener(new MMViewPager.a() {
            /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass7 */

            @Override // com.tencent.mm.ui.base.MMViewPager.a
            public final boolean ab(MotionEvent motionEvent) {
                AppMethodBeat.i(233308);
                if (ImageGalleryUI.this.EAm != null) {
                    boolean onDoubleTap = ImageGalleryUI.this.EAm.onDoubleTap(motionEvent);
                    AppMethodBeat.o(233308);
                    return onDoubleTap;
                }
                AppMethodBeat.o(233308);
                return false;
            }
        });
        if (gSA()) {
            gSH();
            this.jUG.setVisibility(8);
        } else if (!this.Pyy) {
            this.xqs.setOnPageChangeListener(this.PzH);
            this.xqs.setLongClickOverListener(new MMViewPager.d() {
                /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass8 */

                @Override // com.tencent.mm.ui.base.MMViewPager.d
                public final void bmu() {
                    long j2;
                    AppMethodBeat.i(233309);
                    if (ImageGalleryUI.this.EAm != null && ImageGalleryUI.this.EAm.eOV()) {
                        AppMethodBeat.o(233309);
                    } else if (ImageGalleryUI.this.tgN == 1) {
                        AppMethodBeat.o(233309);
                    } else {
                        ImageGalleryUI.this.Pyz = true;
                        if (ImageGalleryUI.this.tgN == 0 || ImageGalleryUI.this.tgN == 2) {
                            ep epVar = new ep();
                            if (ImageGalleryUI.this.tgN == 2) {
                                j2 = 1;
                            } else {
                                j2 = 0;
                            }
                            epVar.erW = j2;
                            epVar.ejA = 1;
                            epVar.eDV = 4;
                            com.tencent.mm.av.g k = ImageGalleryUI.k(ImageGalleryUI.this.Pwu.gSg());
                            if (k != null) {
                                epVar.rK(k.getFileId());
                                epVar.rL(k.getAesKey());
                            }
                            epVar.bfK();
                        }
                        ImageGalleryUI.a(ImageGalleryUI.this, s.k(ImageGalleryUI.a(ImageGalleryUI.this), false), ImageGalleryUI.this.Pzt);
                        ImageGalleryUI.this.dTH();
                        AppMethodBeat.o(233309);
                    }
                }
            });
        } else {
            gSH();
        }
        this.xqs.setOffscreenPageLimit(1);
        this.xqs.setAdapter(this.Pwu);
        and(b.a.PwO);
        this.xqs.setCurrentItem(b.a.PwO);
        this.xqs.postDelayed(new Runnable() {
            /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass9 */

            public final void run() {
                AppMethodBeat.i(233310);
                if (ImageGalleryUI.this.Pwu == null) {
                    AppMethodBeat.o(233310);
                    return;
                }
                if (h.a.gSp().tku && ImageGalleryUI.this.Pzy != null) {
                    ImageGalleryUI.this.Pzy.setChecked(h.a.gSp().cE(ImageGalleryUI.this.Pwu.gSg()));
                    ImageGalleryUI.this.Pzz.setOnClickListener(ImageGalleryUI.this);
                }
                int i2 = b.a.PwO;
                if (ImageGalleryUI.this.xqs.getCurrentItem() != i2) {
                    AppMethodBeat.o(233310);
                    return;
                }
                ImageGalleryUI.this.gSQ();
                b.EnumC2096b cr = b.cr(ImageGalleryUI.this.Pwu.amt(i2));
                if (!ImageGalleryUI.this.Pzk && cr == b.EnumC2096b.video) {
                    ImageGalleryUI.this.Pwu.amS(i2);
                }
                if (cr == b.EnumC2096b.sight) {
                    ImageGalleryUI.this.Pwu.amW(i2);
                }
                AppMethodBeat.o(233310);
            }
        }, 0);
        if (h.a.gSp().tku) {
            this.Pzx = ((ViewStub) findViewById(R.id.hj1)).inflate();
            this.Pzx.setVisibility(0);
            this.Pzy = (CheckBox) this.Pzx.findViewById(R.id.fbe);
            this.Pzz = this.Pzx.findViewById(R.id.fbf);
        }
        this.PyZ = getIntent().getBooleanExtra("img_gallery_enter_PhotoEditUI", false);
        com.tencent.mm.av.g i2 = this.Pwu.i(caVar, true);
        if (i2 == null) {
            Log.e("MicroMsg.ImageGalleryUI", "[initView] imgInfo is null!!! isSoonEnterPhotoEdit:%s", Boolean.valueOf(this.PyZ));
        }
        if (this.PyZ && i2 != null && i2.bcu()) {
            gSV();
            this.PyZ = false;
        } else if (this.PyZ) {
            Log.w("MicroMsg.ImageGalleryUI", "img not GetCompleted!");
        }
        this.xqs.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass10 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(233311);
                switch (motionEvent.getAction()) {
                    case 0:
                        ad.b G = ad.aVe().G("basescanui@datacenter", true);
                        PointF e2 = com.tencent.mm.plugin.scanner.util.m.e(ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.this.Pwu, ImageGalleryUI.this.xqs), motionEvent.getRawX(), motionEvent.getRawY());
                        if (e2 == null) {
                            Log.e("MicroMsg.ImageGalleryUI", "alvinluo get touchCoordinate is invalid");
                            G.l("key_basescanui_screen_position", Boolean.TRUE);
                            G.l("key_basescanui_screen_x", Float.valueOf(motionEvent.getRawX()));
                            G.l("key_basescanui_screen_y", Float.valueOf(motionEvent.getRawY()));
                            break;
                        } else {
                            G.l("key_basescanui_touch_normalize_x", Float.valueOf(e2.x));
                            G.l("key_basescanui_touch_normalize_y", Float.valueOf(e2.y));
                            break;
                        }
                }
                AppMethodBeat.o(233311);
                return false;
            }
        });
        if (gMw() || gSA()) {
            this.PyM.setVisibility(8);
            aL(gSs().PyL, 8);
            aL(gSt().PyN, 8);
            aL(this.PyO, 8);
            aL(gSu().PyP, 8);
            aL(gSw().PyR, 8);
            aL(gSx().PyS, 8);
        }
        AppMethodBeat.o(36163);
    }

    private View a(b bVar, MMViewPager mMViewPager) {
        View view;
        AppMethodBeat.i(36164);
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(bVar == null);
        objArr[1] = Boolean.valueOf(mMViewPager == null);
        Log.d("MicroMsg.ImageGalleryUI", "get current view adapter is null %b, gallery is null %b", objArr);
        if (bVar == null || mMViewPager == null) {
            Log.w("MicroMsg.ImageGalleryUI", "%d get current view but adapter or gallery is null", Integer.valueOf(hashCode()));
            view = null;
        } else if (bVar.gSg() == null) {
            AppMethodBeat.o(36164);
            return null;
        } else if (bVar.gSg().gAz() || bVar.gSg().gDr()) {
            view = bVar.NQ(mMViewPager.getCurrentItem());
            if (view == null) {
                view = bVar.NR(mMViewPager.getCurrentItem());
            }
        } else {
            if (bVar.gSg().cWJ() || bVar.gSg().cWL() || bVar.gSg().cWK()) {
                view = bVar.amR(mMViewPager.getCurrentItem());
            }
            view = null;
        }
        AppMethodBeat.o(36164);
        return view;
    }

    private boolean gMw() {
        if (this.Pdu == 1) {
            return true;
        }
        return false;
    }

    private boolean gSA() {
        AppMethodBeat.i(233381);
        this.Pdu = getIntent().getIntExtra("msg_type", 0);
        if (this.Pdu == 2) {
            AppMethodBeat.o(233381);
            return true;
        }
        AppMethodBeat.o(233381);
        return false;
    }

    private void cvQ() {
        int i2;
        int i3;
        int i4;
        com.tencent.mm.ui.base.g gVar;
        AppMethodBeat.i(36165);
        if (this.FLK || this.Pwu == null) {
            Log.i("MicroMsg.ImageGalleryUI", "isRunningExitAnimation");
            AppMethodBeat.o(36165);
            return;
        }
        Cb(true);
        fhB();
        if (this.Pyy) {
            finish();
            com.tencent.mm.ui.base.b.kc(getContext());
            AppMethodBeat.o(36165);
            return;
        }
        Log.i("MicroMsg.ImageGalleryUI", "runExitAnimation");
        int width = this.xqs.getWidth() / 2;
        int height = this.xqs.getHeight() / 2;
        this.Pwu.gSf();
        if (gMw()) {
            i2 = this.qaH;
            i3 = this.qaI;
            width = this.qaG;
            i4 = this.qaF;
        } else if (this.Pzj) {
            ir irVar = new ir();
            irVar.dNm.msgId = this.Pwu.amt(this.xqs.getCurrentItem()).field_msgId;
            EventCenter.instance.publish(irVar);
            i2 = irVar.dNn.dEs;
            i3 = irVar.dNn.dEt;
            width = irVar.dNn.dEq;
            i4 = irVar.dNn.dEr;
        } else {
            ca amt = this.Pwu.amt(this.xqs.getCurrentItem());
            if (amt != null) {
                bf bfVar = new bf();
                bfVar.dEo.dCM = amt;
                EventCenter.instance.publish(bfVar);
                i2 = bfVar.dEp.dEs;
                i3 = bfVar.dEp.dEt;
                width = bfVar.dEp.dEq;
                height = bfVar.dEp.dEr;
            } else {
                i3 = 0;
                i2 = 0;
            }
            if (width == 0 && height == 0) {
                width = this.xqs.getWidth() / 2;
                i4 = this.xqs.getHeight() / 2;
            } else {
                if (amt != null) {
                    if (amt.field_isSend == 0) {
                        this.PyX = com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 5);
                    }
                    if (amt.field_isSend == 1) {
                        this.PyY = com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 5);
                    }
                }
                i4 = height;
            }
        }
        this.EAz = this.xqs.getWidth();
        this.EAA = this.xqs.getHeight();
        if (this.Pwu.gSg() != null) {
            if (this.Pwu.gSg().cWL() || this.Pwu.gSg().cWJ() || this.Pwu.gSg().cWK()) {
                this.EAA = (int) ((((float) this.EAz) / ((float) i2)) * ((float) i3));
            }
            if ((this.Pwu.gSg().gAz() || this.Pwu.gSg().gDr()) && (gVar = (com.tencent.mm.ui.base.g) a(this.Pwu, this.xqs)) != null) {
                this.EAA = (int) (((float) gVar.getImageHeight()) * (((float) this.EAz) / ((float) gVar.getImageWidth())));
                if (this.EAA > this.xqs.getHeight()) {
                    if (((double) this.EAA) < ((double) this.xqs.getHeight()) * 1.5d) {
                        if (this.Pzj) {
                            this.EAB = this.EAA - this.xqs.getHeight();
                        } else {
                            i3 = (this.xqs.getHeight() * i3) / this.EAA;
                        }
                    }
                    this.EAA = this.xqs.getHeight();
                }
            }
        }
        this.qaE.lt(this.PyX, this.PyY);
        this.qaE.QtK = this.EAB;
        this.qaE.ls(this.EAz, this.EAA);
        this.qaE.Q(width, i4, i2, i3);
        MMViewPager mMViewPager = this.xqs;
        View a2 = a(this.Pwu, this.xqs);
        if (a2 == null) {
            a2 = mMViewPager;
        } else if (((double) this.EAC) != 1.0d) {
            this.qaE.QtG = 1.0f / this.EAC;
            if (!(this.EAD == 0 && this.EAE == 0)) {
                this.qaE.lu(((int) (((float) (this.xqs.getWidth() / 2)) * (1.0f - this.EAC))) + this.EAD, (int) (((float) ((this.xqs.getHeight() / 2) + this.EAE)) - (((float) (this.EAA / 2)) * this.EAC)));
            }
        }
        if (this.PzM) {
            gSH();
        }
        this.qaE.a(a2, this.jUG, new e.c() {
            /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass16 */

            @Override // com.tencent.mm.ui.tools.e.c
            public final void onAnimationStart() {
                AppMethodBeat.i(233324);
                ImageGalleryUI.this.FLK = true;
                new MMHandler().postDelayed(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass16.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(233322);
                        View a2 = ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.this.Pwu, ImageGalleryUI.this.xqs);
                        if (a2 != null && (a2 instanceof com.tencent.mm.ui.base.g)) {
                            if (a2 instanceof MultiTouchImageView) {
                                ((MultiTouchImageView) a2).gKy();
                                AppMethodBeat.o(233322);
                                return;
                            } else if (a2 instanceof WxImageView) {
                                ((WxImageView) a2).gKy();
                            }
                        }
                        AppMethodBeat.o(233322);
                    }
                }, 20);
                AppMethodBeat.o(233324);
            }

            @Override // com.tencent.mm.ui.tools.e.c
            public final void onAnimationEnd() {
                AppMethodBeat.i(233325);
                Log.i("MicroMsg.ImageGalleryUI", "runExitAnimation onAnimationEnd");
                ImageGalleryUI.this.mHandler.post(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass16.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(233323);
                        ImageGalleryUI.this.finish();
                        ImageGalleryUI.this.overridePendingTransition(0, 0);
                        AppMethodBeat.o(233323);
                    }
                });
                ImageGalleryUI.this.FLK = false;
                AppMethodBeat.o(233325);
            }
        }, null);
        AppMethodBeat.o(36165);
    }

    private String cVV() {
        AppMethodBeat.i(36166);
        String str = null;
        if (this.Pwu != null) {
            ca amt = this.Pwu.amt(this.PzE);
            if (b.j(amt)) {
                com.tencent.mm.av.g i2 = this.Pwu.i(amt, true);
                if (i2 != null) {
                    str = d.a(amt, i2);
                }
            } else if (b.cp(amt)) {
                str = b.l(amt);
            }
        }
        String nullAsNil = Util.nullAsNil(str);
        AppMethodBeat.o(36166);
        return nullAsNil;
    }

    private void gSB() {
        AppMethodBeat.i(233382);
        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) this, 1, false);
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass17 */

            {
                AppMethodBeat.i(161541);
                AppMethodBeat.o(161541);
            }

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                AppMethodBeat.i(233326);
                ca gSg = ImageGalleryUI.this.Pwu.gSg();
                if (!br.F(gSg)) {
                    mVar.d(0, ImageGalleryUI.this.getString(R.string.g5j));
                    String string = ImageGalleryUI.this.getString(R.string.gau);
                    if (b.j(gSg) || b.cp(gSg)) {
                        string = ImageGalleryUI.this.getString(R.string.gaq);
                    } else if ((b.m(gSg) || b.cn(gSg)) && !gSg.cWK()) {
                        string = ImageGalleryUI.this.getString(R.string.gav);
                    }
                    if (!gSg.cWK()) {
                        mVar.d(1, string);
                    }
                }
                mVar.b(5, ImageGalleryUI.this.getString(R.string.ayx), R.raw.icons_outlined_chats);
                AppMethodBeat.o(233326);
            }
        };
        eVar.HLY = this.rjz;
        eVar.dGm();
        AppMethodBeat.o(233382);
    }

    /* access modifiers changed from: package-private */
    public class c implements com.tencent.mm.plugin.appbrand.openmaterial.j {
        Runnable PAd;
        ca PAe;

        private c() {
            this.PAd = null;
            this.PAe = null;
        }

        /* synthetic */ c(ImageGalleryUI imageGalleryUI, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.openmaterial.j
        public final void ae(Runnable runnable) {
            AppMethodBeat.i(233370);
            Log.i("MicroMsg.ImageGalleryUI", "executeOrDefer");
            ca gSg = ImageGalleryUI.this.Pwu.gSg();
            if (gSg == null || !gSg.cWJ()) {
                com.tencent.mm.plugin.appbrand.openmaterial.j.nlj.ae(runnable);
                AppMethodBeat.o(233370);
                return;
            }
            com.tencent.mm.modelvideo.s QN = u.QN(gSg.field_imgPath);
            if (QN == null || QN.status == 199 || QN.status == 199) {
                com.tencent.mm.plugin.appbrand.openmaterial.j.nlj.ae(runnable);
                AppMethodBeat.o(233370);
                return;
            }
            Log.i("MicroMsg.ImageGalleryUI", "executeOrDefer, video start download and waiting");
            ImageGalleryUI.this.Pzp = u.f(gSg.field_msgId, 4);
            ImageGalleryUI.this.Pwu.amT(ImageGalleryUI.this.xqs.getCurrentItem());
            this.PAd = runnable;
            this.PAe = gSg;
            AppMethodBeat.o(233370);
        }
    }

    /* access modifiers changed from: package-private */
    public class d {
        volatile int mState;

        private d() {
            this.mState = 0;
        }

        /* synthetic */ d(ImageGalleryUI imageGalleryUI, byte b2) {
            this();
        }

        public final int get() {
            AppMethodBeat.i(258942);
            int i2 = this.mState;
            Log.i("MicroMsg.ImageGalleryUI", "get#ScanState, state: ".concat(String.valueOf(i2)));
            AppMethodBeat.o(258942);
            return i2;
        }

        public final void byH(String str) {
            AppMethodBeat.i(258943);
            Log.i("MicroMsg.ImageGalleryUI", "onScanStart#ScanState, realScanImgPath: ".concat(String.valueOf(str)));
            if (!Util.isEqual(s.k(ImageGalleryUI.a(ImageGalleryUI.this), false), str)) {
                Log.i("MicroMsg.ImageGalleryUI", "onScanStart#ScanState, not match");
                AppMethodBeat.o(258943);
                return;
            }
            this.mState = 1;
            AppMethodBeat.o(258943);
        }

        public final void hYF() {
            AppMethodBeat.i(258944);
            Log.i("MicroMsg.ImageGalleryUI", "onScanFinishPathChecked#ScanState");
            this.mState = 2;
            AppMethodBeat.o(258944);
        }
    }

    private boolean hYE() {
        AppMethodBeat.i(258945);
        if (2 != this.VlB.get()) {
            Log.i("MicroMsg.ImageGalleryUI", "isNeedHideAppBrandEntrance, not scanned");
            AppMethodBeat.o(258945);
            return true;
        } else if (1 != this.Pze.ans(2)) {
            Log.i("MicroMsg.ImageGalleryUI", "isNeedHideAppBrandEntrance, code not found");
            AppMethodBeat.o(258945);
            return false;
        } else {
            int i2 = this.Pzb.dFL;
            String str = this.Pzb.CFJ;
            if (com.tencent.mm.plugin.scanner.g.cb(i2, str) || com.tencent.mm.plugin.scanner.g.cd(i2, str) || com.tencent.mm.plugin.scanner.g.cc(i2, str) || com.tencent.mm.plugin.scanner.g.ce(i2, str)) {
                AppMethodBeat.o(258945);
                return true;
            } else if (com.tencent.mm.plugin.scanner.g.ca(i2, str)) {
                AppMethodBeat.o(258945);
                return true;
            } else if (com.tencent.mm.plugin.scanner.g.ch(i2, str)) {
                AppMethodBeat.o(258945);
                return true;
            } else if (com.tencent.mm.plugin.scanner.g.cg(i2, str)) {
                AppMethodBeat.o(258945);
                return true;
            } else if (!e.d.ahw(i2)) {
                AppMethodBeat.o(258945);
                return false;
            } else {
                AppMethodBeat.o(258945);
                return true;
            }
        }
    }

    private c gSC() {
        AppMethodBeat.i(233383);
        if (this.PzD == null) {
            this.PzD = new c(this, (byte) 0);
        }
        c cVar = this.PzD;
        AppMethodBeat.o(233383);
        return cVar;
    }

    /* access modifiers changed from: package-private */
    public static class a implements com.tencent.mm.plugin.appbrand.openmaterial.i {
        private final WeakReference<ImageGalleryUI> Kwe;
        private final com.tencent.mm.plugin.appbrand.service.i Kwf;
        private final String PAc;
        private final com.tencent.mm.plugin.appbrand.openmaterial.model.b nkA;

        public a(ImageGalleryUI imageGalleryUI, String str, com.tencent.mm.plugin.appbrand.service.i iVar, com.tencent.mm.plugin.appbrand.openmaterial.model.b bVar) {
            AppMethodBeat.i(233368);
            this.Kwe = new WeakReference<>(imageGalleryUI);
            this.PAc = str;
            this.Kwf = iVar;
            this.nkA = bVar;
            AppMethodBeat.o(233368);
        }

        @Override // com.tencent.mm.plugin.appbrand.openmaterial.i
        public final void a(boolean z, AppBrandOpenMaterialCollection appBrandOpenMaterialCollection) {
            p pVar;
            AppMethodBeat.i(233369);
            ImageGalleryUI imageGalleryUI = this.Kwe.get();
            if (imageGalleryUI == null) {
                Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet#onMyOpenMaterialsGot, ui is null");
                AppMethodBeat.o(233369);
            } else if (!z) {
                Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet#onMyOpenMaterialsGot, fail");
                AppMethodBeat.o(233369);
            } else if (imageGalleryUI.oXS == null) {
                Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet#onMyOpenMaterialsGot, bottomSheet is null");
                AppMethodBeat.o(233369);
            } else {
                imageGalleryUI.PzB = this.PAc;
                imageGalleryUI.PzC = appBrandOpenMaterialCollection;
                if (imageGalleryUI.Pwu != null) {
                    pVar = imageGalleryUI.Pwu.gSe();
                } else {
                    pVar = null;
                }
                if (!(pVar == null || p.EXPIRED == pVar)) {
                    if (imageGalleryUI.Jgz != null) {
                        imageGalleryUI.Jgz.dead();
                    }
                    imageGalleryUI.Jgz = this.Kwf.a(this.nkA, imageGalleryUI, imageGalleryUI.oXS, imageGalleryUI.PzC, null, ImageGalleryUI.P(imageGalleryUI));
                    if (com.tencent.mm.plugin.appbrand.openmaterial.model.b.nlN == this.nkA && ImageGalleryUI.f(imageGalleryUI)) {
                        Log.i("MicroMsg.ImageGalleryUI", "tryEnhanceBottomSheet#onMyOpenMaterialsGot, hide enhance bottomSheet");
                        imageGalleryUI.Jgz.a(h.a.HIDE);
                    }
                }
                AppMethodBeat.o(233369);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0100  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dTH() {
        /*
        // Method dump skipped, instructions count: 765
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.dTH():void");
    }

    private void BY(boolean z) {
        com.tencent.mm.av.g i2;
        Map<String, String> parseXml;
        int i3 = 2;
        AppMethodBeat.i(233385);
        if (this.Pzd != null) {
            this.Pzb.PDd = z;
            this.Pzb.dFP = getIntent().getBundleExtra("_stat_obj");
            n nVar = this.Pzb;
            Log.i("MicroMsg.ImageGalleryUI", "talker: %s, chatroom: %s", this.talker, this.chatroomName);
            String str = "";
            if (!Util.isNullOrNil(this.chatroomName) && ab.Eq(this.chatroomName)) {
                Log.d("MicroMsg.ImageGalleryUI", "is chatroom: %s", this.chatroomName);
                str = this.chatroomName;
            } else if (!Util.isNullOrNil(this.talker)) {
                if (ab.IT(this.talker)) {
                    Log.d("MicroMsg.ImageGalleryUI", "is biz: %s", this.talker);
                    i3 = 4;
                    if (nVar.dFP != null) {
                        nVar.dFP.putString("img_gallery_talker", this.talker);
                    }
                } else if (ab.Eq(this.talker)) {
                    Log.d("MicroMsg.ImageGalleryUI", "taler is chatroom: %s", this.talker);
                } else {
                    Log.d("MicroMsg.ImageGalleryUI", "is single chat: %s", this.talker);
                    i3 = 1;
                }
                str = this.talker;
            } else {
                Log.e("MicroMsg.ImageGalleryUI", "unknow source");
                i3 = -1;
            }
            nVar.sourceType = i3;
            kotlin.g.b.p.h(str, "<set-?>");
            nVar.source = str;
            n nVar2 = this.Pzb;
            if (!(this.Pwu == null || this.Pwu.gSg() == null || (i2 = this.Pwu.i(this.Pwu.gSg(), true)) == null || Util.isNullOrNil(i2.iXy) || (parseXml = XmlParser.parseXml(i2.iXy, "msg", null)) == null)) {
                nVar2.dFO = parseXml.get(".msg.img.$aeskey");
                nVar2.imagePath = parseXml.get(".msg.img.$cdnmidimgurl");
            }
            j jVar = this.Pzd;
            View a2 = a(this.Pwu, this.xqs);
            n nVar3 = this.Pzb;
            AnonymousClass25 r4 = new k() {
                /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass25 */

                @Override // com.tencent.mm.ui.chatting.gallery.a.k
                public final void a(PointF pointF, AnimatorListenerAdapter animatorListenerAdapter) {
                    AppMethodBeat.i(233336);
                    com.tencent.mm.ui.chatting.gallery.a.o.a(ImageGalleryUI.l(ImageGalleryUI.this).PyQ, pointF.x, pointF.y, animatorListenerAdapter);
                    AppMethodBeat.o(233336);
                }
            };
            com.tencent.mm.ui.chatting.gallery.a.i iVar = this.Pzu;
            kotlin.g.b.p.h(nVar3, "codeResult");
            if (jVar.PCs) {
                Log.i("MicroMsg.ImageScanCodeManager", "alvinluo handleCode %s", nVar3.CFJ);
                j.d dVar = new j.d(jVar, iVar);
                com.tencent.mm.ui.chatting.gallery.a.o oVar = com.tencent.mm.ui.chatting.gallery.a.o.PDi;
                com.tencent.mm.ui.chatting.gallery.a.o.a(jVar.dKq, a2, nVar3, r4, dVar);
            }
        }
        AppMethodBeat.o(233385);
    }

    private boolean gSD() {
        AppMethodBeat.i(36168);
        if (this.Pzl) {
            AppMethodBeat.o(36168);
            return false;
        } else if (this.Pzn == 1) {
            AppMethodBeat.o(36168);
            return false;
        } else if (this.PwE) {
            AppMethodBeat.o(36168);
            return false;
        } else if (this.Ptq || this.tca || h.a.gSp().tku) {
            AppMethodBeat.o(36168);
            return false;
        } else {
            AppMethodBeat.o(36168);
            return true;
        }
    }

    private boolean bmX(String str) {
        AppMethodBeat.i(36169);
        if (this.Pzn == 1) {
            AppMethodBeat.o(36169);
            return false;
        } else if (this.Pzb == null || Util.isNullOrNil(this.Pzb.CFJ)) {
            AppMethodBeat.o(36169);
            return false;
        } else if (!this.Pzl) {
            AppMethodBeat.o(36169);
            return true;
        } else {
            String[] split = ((String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.APPBRAND_BLOCK_QRCODE_PREFIX_STRING_SYNC, "")).split("\\|");
            if (split != null && split.length > 0) {
                for (String str2 : split) {
                    if (!Util.isNullOrNil(str2) && str.startsWith(str2)) {
                        Log.i("MicroMsg.ImageGalleryUI", "curDealQBarStr:%s, blockQrcodeStr:%s", str, str2);
                        AppMethodBeat.o(36169);
                        return false;
                    }
                }
            }
            AppMethodBeat.o(36169);
            return true;
        }
    }

    private void BZ(boolean z) {
        long j2;
        long j3;
        AppMethodBeat.i(233386);
        String cVV = cVV();
        if ((this.tgN == 0 || this.tgN == 2) && !Util.isNullOrNil(cVV)) {
            ep epVar = new ep();
            if (this.tgN == 2) {
                j2 = 1;
            } else {
                j2 = 0;
            }
            epVar.erW = j2;
            epVar.ejA = 3;
            if (z) {
                j3 = 10;
            } else {
                j3 = 4;
            }
            epVar.eDV = j3;
            com.tencent.mm.av.g k = d.k(this.Pwu.gSg());
            if (k != null) {
                epVar.rK(k.getFileId());
                epVar.rL(k.getAesKey());
            }
            epVar.bfK();
            this.tgM = (int) (((long) z.aTY().hashCode()) + System.currentTimeMillis());
            fx translationResult = ((com.tencent.mm.plugin.scanner.e) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.scanner.e.class)).getTranslationResult(cVV);
            if (translationResult == null || !s.YS(translationResult.field_resultFile)) {
                if (com.tencent.mm.kernel.g.azz().aYS() == 6 || com.tencent.mm.kernel.g.azz().aYS() == 4) {
                    this.tgN = 1;
                    cWi();
                } else {
                    com.tencent.mm.ui.base.h.c(this, getString(R.string.x3), "", true);
                    Cb(false);
                }
                Log.i("MicroMsg.ImageGalleryUI", "try to translate img %s, sessionId %d", cVV, Integer.valueOf(this.tgM));
                to toVar = new to();
                toVar.dZY.scene = z ? 7 : 1;
                toVar.dZY.filePath = cVV;
                toVar.dZY.dEb = this.tgM;
                EventCenter.instance.publish(toVar);
            } else if (this.Pwu.amt(this.PzE) != null) {
                Intent intent = new Intent();
                intent.putExtra("original_file_path", cVV);
                intent.putExtra("msg_id", this.Pwu.amt(this.PzE).field_msgId);
                intent.putExtra("translate_source", z ? 10 : 4);
                if (k != null) {
                    intent.putExtra("fileid", k.getFileId());
                    intent.putExtra("aeskey", k.getAesKey());
                }
                startActivity(TranslationResultUI.class, intent);
                finish();
                overridePendingTransition(R.anim.s, R.anim.s);
                this.Pzs.anq(1);
                AppMethodBeat.o(233386);
                return;
            }
        }
        AppMethodBeat.o(233386);
    }

    private void gSE() {
        AppMethodBeat.i(233387);
        this.tgP.setVisibility(0);
        this.tgQ.setVisibility(0);
        this.tgR.setVisibility(0);
        gSG();
        AppMethodBeat.o(233387);
    }

    private void Ca(boolean z) {
        AppMethodBeat.i(233388);
        this.tgP.setVisibility(8);
        this.tgQ.setVisibility(8);
        this.tgR.setVisibility(8);
        if (!z) {
            gSQ();
            Cd(false);
        }
        AppMethodBeat.o(233388);
    }

    private void Cb(boolean z) {
        AppMethodBeat.i(36170);
        this.tgN = 0;
        Cc(z);
        AppMethodBeat.o(36170);
    }

    private void cWi() {
        AppMethodBeat.i(233389);
        gSE();
        this.tgS.setRepeatMode(1);
        this.tgS.setRepeatCount(-1);
        this.tgS.start();
        AppMethodBeat.o(233389);
    }

    private void Cc(boolean z) {
        AppMethodBeat.i(233390);
        Ca(z);
        this.tgS.setRepeatMode(1);
        this.tgS.setRepeatCount(0);
        this.tgS.end();
        AppMethodBeat.o(233390);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.avb;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void onCreateBeforeSetContentView() {
        AppMethodBeat.i(36172);
        super.onCreateBeforeSetContentView();
        AppMethodBeat.o(36172);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(36173);
        super.onActivityResult(i2, i3, intent);
        if (this.JjJ == null || !this.JjJ.d(this, i2, i3, intent)) {
            AppMethodBeat.o(36173);
        } else {
            AppMethodBeat.o(36173);
        }
    }

    private void a(View view, String str, Bitmap bitmap, int i2, com.tencent.mm.ui.chatting.gallery.a.h hVar) {
        AppMethodBeat.i(233391);
        if (this.Pzd != null) {
            if (i2 != 1) {
                this.VlB.byH(str);
                this.Pzd.a(view, str, bitmap, false, i2, hVar);
            } else if (this.Pzc) {
                this.VlB.byH(str);
                this.Pzd.a(view, str, bitmap, true, i2, hVar);
                AppMethodBeat.o(233391);
                return;
            }
        }
        AppMethodBeat.o(233391);
    }

    public final void gSF() {
        AppMethodBeat.i(258946);
        Cd(false);
        AppMethodBeat.o(258946);
    }

    private void Cd(boolean z) {
        ca caVar;
        boolean z2;
        AppMethodBeat.i(233393);
        if (BuildInfo.IS_FLAVOR_RED) {
            Log.d("MicroMsg.ImageGalleryUI", "showOpLayer isShowOpToolbar: %b, pageChanged: %b, %s", Boolean.valueOf(this.PzM), Boolean.valueOf(z), Util.getStack());
        }
        if (this.Pyy) {
            AppMethodBeat.o(233393);
            return;
        }
        if (this.Pwu != null) {
            caVar = this.Pwu.gSg();
        } else {
            caVar = null;
        }
        if (caVar == null) {
            AppMethodBeat.o(233393);
        } else if (br.K(caVar)) {
            Log.w("MicroMsg.ImageGalleryUI", "ignore show opLayer");
            AppMethodBeat.o(233393);
        } else {
            if (!this.PzM) {
                gSR();
                z2 = false;
            } else {
                z2 = true;
            }
            this.PyC = 0;
            this.PzM = true;
            this.Pyx.setVisibility(0);
            gSQ();
            gSJ();
            l(caVar, z);
            if (!z) {
                bI(0, true);
            } else if (!gSP()) {
                bJ(0, z2);
            }
            if (gSO()) {
                cWW();
            }
            pF(true);
            Ci(true);
            AppMethodBeat.o(233393);
        }
    }

    public final void gSG() {
        AppMethodBeat.i(36175);
        if (BuildInfo.IS_FLAVOR_RED) {
            Log.d("MicroMsg.ImageGalleryUI", "hideOpLayer isShowOpToolbar: %b, %s", Boolean.valueOf(this.PzM), Util.getStack());
        }
        if (!this.PzM) {
            AppMethodBeat.o(36175);
            return;
        }
        this.PzM = false;
        ghN();
        AppMethodBeat.o(36175);
    }

    private void bI(int i2, boolean z) {
        int i3;
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(233394);
        if (gMw() || gSA()) {
            AppMethodBeat.o(233394);
            return;
        }
        Log.d("MicroMsg.ImageGalleryUI", "alvinluo checkShowQuickButton fromType: %d, needHide: %b", Integer.valueOf(i2), Boolean.valueOf(z));
        View view = null;
        if (Ce(z)) {
            view = gSu().PyP;
            i3 = 2;
        } else if (Ch(z)) {
            view = gSx().PyS;
            i3 = 3;
        } else if (Cf(z)) {
            view = this.PyO;
            i3 = 1;
        } else if (bK(i2, z)) {
            i3 = 4;
            view = gSw().PyR;
        } else {
            i3 = 0;
        }
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i3);
        objArr[1] = Integer.valueOf(this.PyI);
        objArr[2] = view;
        objArr[3] = view != null ? Float.valueOf(view.getAlpha()) : BuildConfig.COMMAND;
        objArr[4] = view != null ? Integer.valueOf(view.getVisibility()) : BuildConfig.COMMAND;
        Log.i("MicroMsg.ImageGalleryUI", "alvinluo checkShowQuickButton showType: %d, currentQuickButtonType: %d, targetView: %s, targetView.alpha: %s, targetView.visibility: %s", objArr);
        if (i3 != 0) {
            int i4 = this.PyI;
            if (i3 != this.PyI) {
                if (this.PyI == 0 || !(i3 != 3 || view == null || view.getVisibility() == 0)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.Pzf = 0;
                B(view, z2);
                int visibility = gSx().PyS.getVisibility();
                bJ(i3, false);
                if (this.PyI == 3) {
                    aL(gSx().PyS, visibility);
                    C(gSx().PyS, true);
                }
                this.PyI = i3;
                this.PyJ = view;
            }
            if (i3 == 3) {
                View view2 = gSw().PyR;
                if (i4 != 0 || gSq().PyR.getVisibility() == 0) {
                    z3 = false;
                }
                B(view2, z3);
            }
            AppMethodBeat.o(233394);
            return;
        }
        if (this.Pze.gTv()) {
            Log.i("MicroMsg.ImageGalleryUI", "alvinluo checkShowQuickButton isAllValid and hideQuickButton");
            C(this.PyJ, (this.PyI == 0 || this.PyJ == null) ? false : true);
            if (this.PyI == 3) {
                View view3 = gSw().PyR;
                if (gSq().PyR.getVisibility() != 0) {
                    z3 = false;
                }
                C(view3, z3);
            }
            gSI();
        }
        AppMethodBeat.o(233394);
    }

    private static void B(View view, boolean z) {
        AppMethodBeat.i(233395);
        if (view == null) {
            AppMethodBeat.o(233395);
            return;
        }
        Log.d("MicroMsg.ImageGalleryUI", "alvinluo showButton view: %s, withAnimation: %b", view, Boolean.valueOf(z));
        view.setVisibility(0);
        if (z) {
            view.setAlpha(0.0f);
            m.gE(view);
            AppMethodBeat.o(233395);
            return;
        }
        view.setAlpha(1.0f);
        AppMethodBeat.o(233395);
    }

    private static void C(View view, boolean z) {
        AppMethodBeat.i(233396);
        Log.d("MicroMsg.ImageGalleryUI", "alvinluo hideButton view: %s, withAnimation: %b", view, Boolean.valueOf(z));
        if (view == null) {
            AppMethodBeat.o(233396);
        } else if (!z) {
            aL(view, 8);
            m.gG(view);
            AppMethodBeat.o(233396);
        } else {
            if (view.getVisibility() == 0) {
                m.gF(view);
            }
            AppMethodBeat.o(233396);
        }
    }

    private void bJ(int i2, boolean z) {
        AppMethodBeat.i(233397);
        if (gMw() || gSA()) {
            AppMethodBeat.o(233397);
            return;
        }
        Log.i("MicroMsg.ImageGalleryUI", "alvinluo hideQuickButton showType: %d, withAnimation: %b", Integer.valueOf(i2), Boolean.valueOf(z));
        if (i2 != 2) {
            C(gSu().PyP, z);
        }
        if (i2 != 3) {
            C(gSx().PyS, z);
        }
        if (i2 != 1) {
            C(this.PyO, z);
        }
        if (i2 != 4) {
            C(gSw().PyR, z);
        }
        if (i2 == 0) {
            gSI();
        }
        AppMethodBeat.o(233397);
    }

    private void gSI() {
        this.PyI = 0;
        this.PyJ = null;
    }

    private void gSJ() {
        int i2 = 0;
        AppMethodBeat.i(233398);
        if (gMw() || gSA()) {
            AppMethodBeat.o(233398);
            return;
        }
        aL(this.PyM, 0);
        aL(gSs().PyL, this.Pzi ? 0 : 8);
        int i3 = this.PyC;
        if (this.Pzi) {
            i2 = 1;
        }
        this.PyC = i3 + i2 + 1;
        AppMethodBeat.o(233398);
    }

    private void l(ca caVar, boolean z) {
        boolean z2;
        int i2 = 1;
        AppMethodBeat.i(233399);
        if (this.Pyw != b.EnumC2096b.image) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (br.B(caVar) || br.J(caVar)) {
            z2 = false;
        }
        if (gMw() || gSA()) {
            z2 = false;
        }
        View view = gSt().PyN;
        if (!z) {
            aL(view, z2 ? 0 : 8);
        } else if (z2) {
            B(view, view.getVisibility() != 0);
        } else {
            C(view, true);
        }
        int i3 = this.PyC;
        if (!z2) {
            i2 = 0;
        }
        this.PyC = i3 + i2;
        AppMethodBeat.o(233399);
    }

    private boolean Ce(boolean z) {
        AppMethodBeat.i(233400);
        if (!this.Pzc) {
            AppMethodBeat.o(233400);
            return false;
        }
        boolean gMw = gMw();
        boolean oe = this.Pze.oe(2);
        boolean z2 = oe && !gMw && !gSA();
        Log.v("MicroMsg.ImageGalleryUI", "showScanCodeButton showQRCodeResult: %b, isFromQuoteMsg: %b, show: %b", Boolean.valueOf(oe), Boolean.valueOf(gMw), Boolean.valueOf(z2));
        if (z2) {
            this.Pzs.ann(2);
            if (gSu().PyP.getVisibility() != 0) {
                aL(gSu().PyP, 0);
            }
            AppMethodBeat.o(233400);
            return true;
        }
        if (z) {
            aL(gSu().PyP, 8);
        }
        AppMethodBeat.o(233400);
        return false;
    }

    private boolean Cf(boolean z) {
        long j2;
        com.tencent.mm.av.g k;
        AppMethodBeat.i(233401);
        if (!gSK()) {
            AppMethodBeat.o(233401);
            return false;
        }
        boolean oe = this.Pze.oe(1);
        boolean z2 = this.Pzo && oe && !gSA();
        Log.v("MicroMsg.ImageGalleryUI", "showScanTranslateButton showQuickTrans: %b, showTranslateResult: %b, show: %b", Boolean.valueOf(this.Pzo), Boolean.valueOf(oe), Boolean.valueOf(z2));
        if (z2) {
            ep epVar = new ep();
            if (this.tgN == 2) {
                j2 = 1;
            } else {
                j2 = 0;
            }
            epVar.erW = j2;
            epVar.ejA = 8;
            epVar.eDV = 10;
            if (!(this.Pwu == null || (k = d.k(this.Pwu.gSg())) == null)) {
                epVar.rK(k.getFileId());
                epVar.rL(k.getAesKey());
            }
            epVar.bfK();
            this.Pzs.ann(3);
            if (this.PyO.getVisibility() != 0) {
                aL(this.PyO, 0);
            }
            AppMethodBeat.o(233401);
            return true;
        }
        if (z) {
            aL(this.PyO, 8);
        }
        AppMethodBeat.o(233401);
        return false;
    }

    private boolean gSK() {
        return this.Ptr || this.Pzj;
    }

    private boolean Cg(boolean z) {
        AppMethodBeat.i(233402);
        if (!gSK() || !com.tencent.mm.ui.chatting.gallery.a.e.gTs()) {
            AppMethodBeat.o(233402);
            return false;
        }
        boolean z2 = !gMw() && !gSA() && this.Pze.oe(4);
        Log.i("MicroMsg.ImageGalleryUI", "alvinluo showSearchImageButton showButton: %b", Boolean.valueOf(z2));
        if (z2) {
            aL(gSw().PyR, 0);
            this.Pzs.anr(3);
            AppMethodBeat.o(233402);
            return true;
        }
        if (z) {
            aL(gSw().PyR, 8);
        }
        AppMethodBeat.o(233402);
        return false;
    }

    private boolean Ch(boolean z) {
        boolean z2;
        int i2;
        int i3;
        AppMethodBeat.i(233403);
        if (!gSK() || !com.tencent.mm.ui.chatting.gallery.a.e.gTt()) {
            AppMethodBeat.o(233403);
            return false;
        }
        boolean z3 = !gMw() && !gSA() && this.Pzg != null && !Util.isNullOrNil(this.Pzg.CBb) && this.Pze.oe(3);
        Log.i("MicroMsg.ImageGalleryUI", "alvinluo showSearchImageBubbleView showBubble: %b", Boolean.valueOf(z3));
        if (z3) {
            if (this.Pyx.getVisibility() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            View view = gSw().PyR;
            if (z2) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            aL(view, i2);
            SearchImageBubbleView searchImageBubbleView = gSx().PyS;
            if (z2) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            aL(searchImageBubbleView, i3);
            int measuredWidth = this.xqs.getMeasuredWidth();
            int i4 = (measuredWidth - ((this.PyC + 1) * this.PyD)) - this.PyF;
            if (this.PyC > 1) {
                i4 -= this.PyC * this.PyE;
            }
            Log.i("MicroMsg.ImageGalleryUI", "alvinluo showSearchImageBubbleView visible: %b, galleryWidth: %d, showButtonCount: %d, viewPositionX: %d, bottomBtnSize: %d, bottomBtnRightExtrMargin: %d", Boolean.valueOf(z2), Integer.valueOf(measuredWidth), Integer.valueOf(this.PyC), Integer.valueOf(i4), Integer.valueOf(this.PyD), Integer.valueOf(this.PyF));
            SearchImageBubbleView searchImageBubbleView2 = gSx().PyS;
            searchImageBubbleView2.setViewWidth(measuredWidth);
            searchImageBubbleView2.setBubbleText(this.Pzg.CBb);
            searchImageBubbleView2.lj(this.PyD, this.PyD);
            searchImageBubbleView2.setAnchorViewPosition$255f295(i4);
            searchImageBubbleView2.setBubbleClickListener(this);
            if (z2) {
                searchImageBubbleView2.show();
            } else {
                searchImageBubbleView2.setVisibility(8);
            }
            this.Pzs.anr(4);
            this.Pzs.anr(3);
            AppMethodBeat.o(233403);
            return true;
        }
        if (z) {
            aL(gSx().PyS, 8);
        }
        AppMethodBeat.o(233403);
        return false;
    }

    private void gSL() {
        AppMethodBeat.i(233404);
        if (gSx().PyS.getVisibility() == 0) {
            Ch(true);
        }
        AppMethodBeat.o(233404);
    }

    private boolean bK(int i2, boolean z) {
        AppMethodBeat.i(233405);
        if (!gSK() || !com.tencent.mm.ui.chatting.gallery.a.e.gTs()) {
            AppMethodBeat.o(233405);
            return false;
        }
        this.Pze.li(4, 2);
        boolean isValid = this.Pze.isValid(4);
        Log.i("MicroMsg.ImageGalleryUI", "alvinluo checkShowSearchImageButton fromType: %s, isSearchButtonValid: %b", Integer.valueOf(i2), Boolean.valueOf(isValid));
        if (isValid) {
            this.Pze.li(4, 1);
            if (this.Pze.oe(4)) {
                this.Pze.anu(4);
                boolean Cg = Cg(z);
                AppMethodBeat.o(233405);
                return Cg;
            }
        }
        AppMethodBeat.o(233405);
        return false;
    }

    private void Ci(boolean z) {
        AppMethodBeat.i(36177);
        if (this.Pyw != b.EnumC2096b.image || gSA()) {
            aL(this.PyT, 4);
            AppMethodBeat.o(36177);
            return;
        }
        ca caVar = null;
        if (this.Pwu != null) {
            caVar = this.Pwu.gSg();
        }
        if (caVar == null || br.D(caVar)) {
            aL(this.PyT, 4);
            AppMethodBeat.o(36177);
            return;
        }
        com.tencent.mm.av.g i2 = this.Pwu.i(caVar, false);
        if (z) {
            this.xqs.getCurrentItem();
            if (f(caVar, i2) && !caVar.gDB() && i2.bcu()) {
                gSq().PyU.setVisibility(0);
                gSq().PyV.setVisibility(8);
                gSq().PyW.setVisibility(8);
                String str = this.PzN.get(Long.valueOf(i2.localId));
                if (str == null) {
                    str = NP((long) g(i2));
                    this.PzN.put(Long.valueOf(i2.localId), str);
                }
                gSq().PyU.setText(getString(R.string.bjv, new Object[]{str}));
                aL(this.PyT, 0);
                AppMethodBeat.o(36177);
                return;
            }
        }
        aL(this.PyT, 4);
        AppMethodBeat.o(36177);
    }

    private void pF(boolean z) {
        int i2 = 8;
        AppMethodBeat.i(36178);
        if (this.tmY == null) {
            AppMethodBeat.o(36178);
        } else if ((!z || this.tmY.getVisibility() != 0) && (z || this.tmY.getVisibility() != 8)) {
            RelativeLayout relativeLayout = this.tmY;
            if (z) {
                i2 = 0;
            }
            relativeLayout.setVisibility(i2);
            this.tmY.startAnimation(AnimationUtils.loadAnimation(getContext(), z ? R.anim.n : R.anim.o));
            AppMethodBeat.o(36178);
        } else {
            AppMethodBeat.o(36178);
        }
    }

    private static boolean f(ca caVar, com.tencent.mm.av.g gVar) {
        AppMethodBeat.i(36179);
        if (gVar == null) {
            AppMethodBeat.o(36179);
            return false;
        }
        try {
            if (b.c(caVar, gVar) == 0 && gVar.bcv() && !caVar.gDB()) {
                AppMethodBeat.o(36179);
                return true;
            }
        } catch (NullPointerException e2) {
            Log.e("MicroMsg.ImageGalleryUI", "error:".concat(String.valueOf(e2)));
        }
        AppMethodBeat.o(36179);
        return false;
    }

    public final void and(int i2) {
        AppMethodBeat.i(36180);
        m(this.Pwu.amt(i2), false);
        AppMethodBeat.o(36180);
    }

    private int gSM() {
        if (this.Pzm == 0) {
            com.tencent.mm.plugin.webview.ui.tools.media.a aVar = com.tencent.mm.plugin.webview.ui.tools.media.a.JvG;
            return 2;
        } else if (this.Pzm == 1) {
            com.tencent.mm.plugin.webview.ui.tools.media.a aVar2 = com.tencent.mm.plugin.webview.ui.tools.media.a.JvG;
            return 4;
        } else {
            com.tencent.mm.plugin.webview.ui.tools.media.a aVar3 = com.tencent.mm.plugin.webview.ui.tools.media.a.JvG;
            return 1;
        }
    }

    private int gSN() {
        return this.Pyz ? 3 : 4;
    }

    private void ane(int i2) {
        AppMethodBeat.i(36181);
        ca amt = this.Pwu.amt(i2);
        if (amt == null || !amt.cWK() || this.PwE) {
            AppMethodBeat.o(36181);
            return;
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(new i.c(amt.field_talker, "update", amt));
        AppMethodBeat.o(36181);
    }

    protected static com.tencent.mm.av.g k(ca caVar) {
        AppMethodBeat.i(258947);
        com.tencent.mm.av.g k = d.k(caVar);
        AppMethodBeat.o(258947);
        return k;
    }

    private boolean gSO() {
        if (this.Pyw == b.EnumC2096b.video) {
            return true;
        }
        return false;
    }

    private boolean gSP() {
        return this.Pyw == b.EnumC2096b.image || this.Pyw == b.EnumC2096b.appimage;
    }

    /* access modifiers changed from: protected */
    public final void gSQ() {
        AppMethodBeat.i(36182);
        if (this.PzM) {
            if (gSO()) {
                this.tnh.startTimer(3000);
                AppMethodBeat.o(36182);
                return;
            }
            this.tnh.startTimer(5000);
        }
        AppMethodBeat.o(36182);
    }

    private void cWW() {
        ca gSg;
        AppMethodBeat.i(36183);
        Log.i("MicroMsg.ImageGalleryUI", "show video tool bar");
        Cj(true);
        aL(this.PyT, 4);
        aL(gSr().FLz, 0);
        aL(gSr().JvS, 0);
        aL(this.PyK, 0);
        if (this.Pyy) {
            gSG();
        }
        if (!(this.Pwu == null || (gSg = this.Pwu.gSg()) == null || !gSg.cWK())) {
            aL(this.JvM, 0);
        }
        AppMethodBeat.o(36183);
    }

    public final void cWV() {
        AppMethodBeat.i(36184);
        Log.i("MicroMsg.ImageGalleryUI", "hide video tool bar");
        Cj(false);
        aL(gSr().FLz, 8);
        aL(gSr().JvS, 8);
        aL(this.PyK, 8);
        aL(this.JvM, 8);
        AppMethodBeat.o(36184);
    }

    private static void Cj(boolean z) {
        AppMethodBeat.i(36185);
        Log.d("MicroMsg.ImageGalleryUI", "switch tool bar bg %b", Boolean.valueOf(z));
        AppMethodBeat.o(36185);
    }

    private static String NP(long j2) {
        AppMethodBeat.i(36188);
        if (j2 < 0) {
            AppMethodBeat.o(36188);
            return "";
        }
        BigDecimal bigDecimal = new BigDecimal(j2);
        float floatValue = bigDecimal.divide(new BigDecimal(1048576), 2, 0).floatValue();
        if (floatValue > 1.0f) {
            String str = ((int) floatValue) + "M";
            AppMethodBeat.o(36188);
            return str;
        }
        String str2 = ((int) bigDecimal.divide(new BigDecimal(1024), 2, 0).floatValue()) + "K";
        AppMethodBeat.o(36188);
        return str2;
    }

    private void anf(int i2) {
        AppMethodBeat.i(36189);
        Log.i("MicroMsg.ImageGalleryUI", "enterGrid source : ".concat(String.valueOf(i2)));
        if (this.Pwu == null) {
            Log.w("MicroMsg.ImageGalleryUI", "try to enterGrid, but adapter is NULL");
            AppMethodBeat.o(36189);
            return;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(219, 13, 1, true);
        int realCount = this.Pwu.getRealCount();
        if (this.Pwu.gSg() == null) {
            Log.e("MicroMsg.ImageGalleryUI", "msgInfo is null");
            AppMethodBeat.o(36189);
            return;
        }
        int amX = this.Pwu.Pww.amX(this.xqs.getCurrentItem());
        if (!this.Pzj) {
            Intent intent = new Intent();
            intent.setClass(getContext(), MediaHistoryGalleryUI.class);
            intent.addFlags(67108864);
            intent.putExtra("kintent_intent_source", i2);
            intent.putExtra("kintent_talker", gSz());
            intent.putExtra("kintent_image_count", realCount);
            intent.putExtra("kintent_image_index", amX);
            intent.putExtra("key_biz_chat_id", this.ppv);
            intent.putExtra("key_is_biz_chat", this.tca);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "enterGrid", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "enterGrid", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            this.mHandler.postDelayed(new Runnable() {
                /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass35 */

                public final void run() {
                    AppMethodBeat.i(233352);
                    ImageGalleryUI.this.finish();
                    AppMethodBeat.o(233352);
                }
            }, 50);
            AppMethodBeat.o(36189);
            return;
        }
        cvQ();
        AppMethodBeat.o(36189);
    }

    public final int getCurrentItem() {
        AppMethodBeat.i(258948);
        int currentItem = this.xqs.getCurrentItem();
        AppMethodBeat.o(258948);
        return currentItem;
    }

    public void onClick(View view) {
        boolean z;
        AppMethodBeat.i(36191);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (this.Pwu == null) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(36191);
            return;
        }
        if (view.getId() == R.id.c41) {
            anf(0);
        } else if (view.getId() == R.id.j5w) {
            this.Pyz = false;
            dTH();
            if (anc(2) && bmX(this.Pzb.CFJ)) {
                this.Pzr.cl(this.Pzb.dFL, this.Pzb.CFJ);
            }
        } else if (view.getId() == R.id.btn) {
            Log.i("MicroMsg.ImageGalleryUI", "[oreh download_and_save] hdImg suc, curPos:%d", Integer.valueOf(this.xqs.getCurrentItem()));
            ca amt = this.Pwu.amt(this.xqs.getCurrentItem());
            com.tencent.mm.av.g i2 = this.Pwu.i(amt, false);
            this.xqs.getCurrentItem();
            if (!f(amt, i2) || amt.gDB() || !i2.bcu()) {
                b.c(getContext(), this.Pwu.gSg(), true);
            } else {
                this.Pwu.bH(this.xqs.getCurrentItem(), true);
            }
        } else if (view.getId() == R.id.biv) {
            this.tgN = 2;
            this.tgM = 0;
            this.Pwu.bH(this.xqs.getCurrentItem(), false);
        } else if (view.getId() == R.id.biw) {
            this.Pwu.amV(this.xqs.getCurrentItem());
            and(this.xqs.getCurrentItem());
        } else if (view.getId() == R.id.eh) {
            onBackPressed();
        } else if (view.getId() == R.id.j43) {
            onBackPressed();
        } else if (view.getId() == R.id.fbf) {
            boolean isChecked = this.Pzy.isChecked();
            if (isChecked || h.a.gSp().tkt.size() < 9) {
                CheckBox checkBox = this.Pzy;
                if (!isChecked) {
                    z = true;
                } else {
                    z = false;
                }
                checkBox.setChecked(z);
                if (this.Pzy.isChecked()) {
                    h.a.gSp().cC(this.Pwu.gSg());
                } else {
                    h.a.gSp().cD(this.Pwu.gSg());
                }
            } else {
                Toast.makeText(this, getResources().getString(R.string.dms, 9), 1).show();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(36191);
                return;
            }
        } else if (view.getId() == R.id.gcc) {
            this.Pwu.gSh();
            this.Pwu.amS(this.xqs.getCurrentItem());
        } else if (view.getId() == R.id.dct) {
            if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(getContext())) {
                this.Pzs.anp(3);
                BZ(true);
            }
        } else if (view.getId() == R.id.dcr) {
            gSu().PyP.setOnClickListener(null);
            this.Pzs.anp(2);
            BY(true);
        } else if (view.getId() == R.id.dcs) {
            gSw().PyR.setOnClickListener(null);
            aq(System.currentTimeMillis(), 3);
        } else if (view.getId() == R.id.he9) {
            gSx().PyS.setBubbleClickListener(null);
            aq(System.currentTimeMillis(), 4);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(36191);
    }

    private void aq(long j2, int i2) {
        AppMethodBeat.i(233409);
        Log.i("MicroMsg.ImageGalleryUI", "dealWithSearchImage sessionId: %s, fromSource: %s", Long.valueOf(j2), Integer.valueOf(i2));
        ca gSg = this.Pwu.gSg();
        com.tencent.mm.plugin.websearch.api.o oVar = new com.tencent.mm.plugin.websearch.api.o();
        oVar.sessionId = j2;
        oVar.context = this;
        oVar.dTX = gSg;
        oVar.dGf = i2;
        ((com.tencent.mm.plugin.websearch.api.c) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).startImageSearch(oVar);
        AppMethodBeat.o(233409);
    }

    public final void setVideoStateIv(boolean z) {
        AppMethodBeat.i(36192);
        try {
            gSr().FLz.setIsPlay(!z);
            AppMethodBeat.o(36192);
        } catch (Exception e2) {
            Log.e("MicroMsg.ImageGalleryUI", "set video state iv error : " + e2.toString());
            AppMethodBeat.o(36192);
        }
    }

    public final boolean dFG() {
        AppMethodBeat.i(36193);
        boolean cEF = gSr().FLz.cEF();
        AppMethodBeat.o(36193);
        return cEF;
    }

    public final void ang(final int i2) {
        AppMethodBeat.i(36194);
        if (gSr().FLz == null) {
            AppMethodBeat.o(36194);
            return;
        }
        gSr().FLz.post(new Runnable() {
            /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass36 */

            public final void run() {
                AppMethodBeat.i(233353);
                if (ImageGalleryUI.this.Pwu == null) {
                    AppMethodBeat.o(233353);
                    return;
                }
                b bVar = ImageGalleryUI.this.Pwu;
                bVar.PwB.pause(i2);
                AppMethodBeat.o(233353);
            }
        });
        AppMethodBeat.o(36194);
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(36195);
        if (keyEvent.getKeyCode() == 82 && keyEvent.getAction() == 1) {
            if (this.oXS != null) {
                this.oXS.bMo();
                this.oXS = null;
            } else if (this.tgN == 0 || this.tgN == 2) {
                dTH();
            } else {
                dTH();
            }
            AppMethodBeat.o(36195);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(36195);
        return dispatchKeyEvent;
    }

    private void ghN() {
        boolean z = true;
        AppMethodBeat.i(36196);
        Object[] objArr = new Object[1];
        if (this.Pyx.getVisibility() != 0) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        Log.d("MicroMsg.ImageGalleryUI", "fadeOutOpLayout: %b", objArr);
        Animation anh = anh(150);
        anh.setFillAfter(false);
        anh.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass37 */

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(233354);
                if (!ImageGalleryUI.this.PzM) {
                    ImageGalleryUI.this.gSH();
                }
                AppMethodBeat.o(233354);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        this.Pyx.clearAnimation();
        this.Pyx.startAnimation(anh);
        AppMethodBeat.o(36196);
    }

    private void gSR() {
        boolean z = true;
        AppMethodBeat.i(36197);
        Object[] objArr = new Object[1];
        if (this.Pyx.getVisibility() != 0) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        Log.d("MicroMsg.ImageGalleryUI", "fadeInOpLayout: %b", objArr);
        this.Pyx.clearAnimation();
        this.Pyx.startAnimation(gSS());
        AppMethodBeat.o(36197);
    }

    private static Animation gSS() {
        AppMethodBeat.i(36198);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(150);
        alphaAnimation.setFillAfter(true);
        AppMethodBeat.o(36198);
        return alphaAnimation;
    }

    static Animation anh(int i2) {
        AppMethodBeat.i(36199);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration((long) i2);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setInterpolator(new AccelerateInterpolator(10.0f));
        AppMethodBeat.o(36199);
        return alphaAnimation;
    }

    public final void ani(int i2) {
        AppMethodBeat.i(36200);
        cWV();
        Cd(false);
        gSq().PyT.setVisibility(0);
        gSq().PyU.setVisibility(8);
        gSq().PyV.setVisibility(0);
        gSq().PyW.setVisibility(8);
        gSq().PyV.setText(i2 + "%");
        AppMethodBeat.o(36200);
    }

    public final void gST() {
        AppMethodBeat.i(36201);
        cWV();
        gSq().PyT.setVisibility(0);
        gSq().PyU.setVisibility(8);
        gSq().PyV.setVisibility(0);
        gSq().PyW.setVisibility(8);
        gSq().PyV.setText("0%");
        AppMethodBeat.o(36201);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(36202);
        if (i2 == 82) {
            AppMethodBeat.o(36202);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(36202);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(36203);
        this.Poq.clear();
        super.finish();
        AppMethodBeat.o(36203);
    }

    public final int NQ(long j2) {
        AppMethodBeat.i(36204);
        if (Util.isNullOrNil(this.Pzp)) {
            AppMethodBeat.o(36204);
            return 0;
        }
        try {
            int g2 = u.g(j2, this.Pzp);
            if (g2 == -1) {
                this.Pzp = null;
                g2 = 0;
            }
            Log.d("MicroMsg.ImageGalleryUI", "get enter video op code %d %s", Integer.valueOf(g2), this.Pzp);
            AppMethodBeat.o(36204);
            return g2;
        } catch (Exception e2) {
            Log.e("MicroMsg.ImageGalleryUI", "get enter video op code error : " + e2.toString());
            AppMethodBeat.o(36204);
            return 0;
        }
    }

    public final void NR(long j2) {
        AppMethodBeat.i(36205);
        if (Util.isNullOrNil(this.Pzp) || j2 == 0) {
            AppMethodBeat.o(36205);
        } else if (this.Pzq) {
            this.Pzp = u.f(j2, 3);
            Log.d("MicroMsg.ImageGalleryUI", "reset enter video op code %s", this.Pzp);
            AppMethodBeat.o(36205);
        } else {
            if (u.g(j2, this.Pzp) == -1) {
                this.Pzp = null;
                Log.d("MicroMsg.ImageGalleryUI", "reset enter video op code %s", this.Pzp);
            }
            AppMethodBeat.o(36205);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(36206);
        super.onConfigurationChanged(configuration);
        if (this.EAm != null) {
            this.EAm.onConfigurationChanged(configuration);
        }
        if (configuration.orientation == 1) {
            Log.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is vertical screen", Integer.valueOf(hashCode()));
            this.PyH = true;
            ghP();
            AppMethodBeat.o(36206);
        } else if (configuration.orientation == 2) {
            Log.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is horizontal screen", Integer.valueOf(hashCode()));
            this.PyH = true;
            ghQ();
            AppMethodBeat.o(36206);
        } else {
            AppMethodBeat.o(36206);
        }
    }

    private void ghP() {
        AppMethodBeat.i(36207);
        final View decorView = getWindow().getDecorView();
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass39 */

            public final void onGlobalLayout() {
                AppMethodBeat.i(233356);
                decorView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                ImageGalleryUI.ap(ImageGalleryUI.this);
                AppMethodBeat.o(233356);
            }
        });
        AppMethodBeat.o(36207);
    }

    private void ghQ() {
        AppMethodBeat.i(36208);
        final View decorView = getWindow().getDecorView();
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass40 */

            public final void onGlobalLayout() {
                AppMethodBeat.i(233357);
                decorView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int jn = com.tencent.mm.cb.a.jn(ImageGalleryUI.this);
                int jo = com.tencent.mm.cb.a.jo(ImageGalleryUI.this);
                Log.i("MicroMsg.ImageGalleryUI", "handleHorizontalUI width = %d, height = %d", Integer.valueOf(jn), Integer.valueOf(jo));
                if (jn <= jo || (com.tencent.mm.compatible.util.d.oD(24) && ImageGalleryUI.this.isInMultiWindowMode())) {
                    ImageGalleryUI.ap(ImageGalleryUI.this);
                    AppMethodBeat.o(233357);
                    return;
                }
                ImageGalleryUI.aq(ImageGalleryUI.this);
                AppMethodBeat.o(233357);
            }
        });
        AppMethodBeat.o(36208);
    }

    private void anj(int i2) {
        AppMethodBeat.i(36209);
        if (this.JvM != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.JvM.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, i2, 0);
            this.JvM.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(36209);
    }

    private void gSU() {
        AppMethodBeat.i(36210);
        if (this.JvM != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.JvM.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, 0, 0);
            this.JvM.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(36210);
    }

    private boolean bq(Activity activity) {
        AppMethodBeat.i(36211);
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        int i2 = width < height ? 1 : 0;
        Log.d("MicroMsg.ImageGalleryUI", "%d is vertical screen orient %d [%d, %d]", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(width), Integer.valueOf(height));
        if (i2 == 0) {
            AppMethodBeat.o(36211);
            return false;
        }
        AppMethodBeat.o(36211);
        return true;
    }

    private void gSV() {
        AppMethodBeat.i(36212);
        ca gSg = this.Pwu.gSg();
        String a2 = d.a(gSg, d.k(gSg));
        Log.i("MicroMsg.ImageGalleryUI", "edit image path:%s msgId:%s", a2, Long.valueOf(gSg.field_msgId));
        bmY(a2);
        AppMethodBeat.o(36212);
    }

    private void bmY(String str) {
        AppMethodBeat.i(36213);
        RecordConfigProvider jA = RecordConfigProvider.jA(str, "");
        jA.scene = this.Pzn;
        UICustomParam.a aVar = new UICustomParam.a();
        aVar.apE();
        aVar.apD();
        aVar.dz(true);
        jA.BOn = aVar.gLU;
        com.tencent.mm.plugin.recordvideo.jumper.a aVar2 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
        com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4369, R.anim.ei, -1, jA, 1, 2);
        AppMethodBeat.o(36213);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 2;
    }

    private static String k(ca caVar, boolean z) {
        AppMethodBeat.i(233380);
        if (caVar.field_isSend == 1) {
            String aTY = z.aTY();
            AppMethodBeat.o(233380);
            return aTY;
        } else if (z) {
            String Ks = bp.Ks(caVar.field_content);
            AppMethodBeat.o(233380);
            return Ks;
        } else {
            String str = caVar.field_talker;
            AppMethodBeat.o(233380);
            return str;
        }
    }

    public final void gSH() {
        AppMethodBeat.i(36176);
        this.tnh.stopTimer();
        this.PyM.setVisibility(8);
        gSs().PyL.clearAnimation();
        aL(gSs().PyL, 8);
        aL(gSt().PyN, 8);
        this.PyO.setVisibility(8);
        aL(gSu().PyP, 8);
        aL(gSw().PyR, 8);
        aL(gSx().PyS, 8);
        cWV();
        pF(false);
        Ci(false);
        this.Pyx.setVisibility(8);
        AppMethodBeat.o(36176);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final synchronized void m(ca caVar, boolean z) {
        int i2;
        AppMethodBeat.i(233407);
        if (caVar != null && caVar.cWK()) {
            if (this.JvM == null) {
                this.JvM = ((ViewStub) findViewById(R.id.dcq)).inflate();
                this.tFX = findViewById(R.id.flk);
                this.gyr = (ImageView) findViewById(R.id.flj);
                this.PzK = (ImageView) findViewById(R.id.flw);
                this.pIN = (TextView) findViewById(R.id.flu);
                this.pIO = (MMNeat7extView) findViewById(R.id.flz);
                this.PzI = (TextView) findViewById(R.id.fm1);
                this.pIN.getPaint().setFakeBoldText(true);
                this.PzI.getPaint().setFakeBoldText(true);
                this.pIO.getPaint().setFakeBoldText(true);
                this.PzJ = findViewById(R.id.fm0);
                this.JvM.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass30 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(233345);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(233345);
                    }
                });
            }
            boolean aA = au.aA(this);
            int aD = au.aD(this);
            if (this.zss && aA) {
                if (bq(this)) {
                    gSU();
                } else {
                    anj(aD);
                }
            }
            final y cG = j.cG(caVar);
            if (cG == null) {
                Log.w("MicroMsg.ImageGalleryUI", "fillMpVideoInfoLayout mpShareVideoInfo is null");
            } else {
                this.pIO.aw(cG.title);
                k.b bVar = new k.b();
                bVar.eah = cG.iAg;
                bVar.eag = cG.dHc;
                al.a(this, bVar, this.gyr, this.pIN);
                this.tFX.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass31 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(233346);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (cG == null || Util.isNullOrNil(cG.dHc)) {
                            Log.w("MicroMsg.ImageGalleryUI", "srcUserName is null");
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(233346);
                            return;
                        }
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", cG.dHc);
                        intent.putExtra("Contact_Scene", TbsListener.ErrorCode.STARTDOWNLOAD_4);
                        intent.putExtra("force_get_contact", true);
                        intent.putExtra("key_use_new_contact_profile", true);
                        com.tencent.mm.br.c.b(ImageGalleryUI.this.Pwu.Pwv, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(18589, 1, Integer.valueOf(ImageGalleryUI.X(ImageGalleryUI.this)));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(233346);
                    }
                });
                this.PzJ.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass32 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(233347);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Intent intent = new Intent();
                        int intExtra = ImageGalleryUI.this.getIntent().getIntExtra("KOpenArticleSceneFromScene", 1);
                        intent.putExtra("srcUsername", cG.dHc);
                        intent.putExtra("srcDisplayname", cG.iAg);
                        String d2 = com.tencent.mm.ag.m.d(cG.KOe, com.tencent.mm.plugin.appbrand.jsapi.p.b.CTRL_INDEX, intExtra, (int) (System.currentTimeMillis() / 1000));
                        if (!((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(ImageGalleryUI.this, d2, -1, com.tencent.mm.plugin.appbrand.jsapi.p.b.CTRL_INDEX, intExtra, intent)) {
                            intent.putExtra("rawUrl", d2);
                            com.tencent.mm.br.c.b(ImageGalleryUI.this, "webview", ".ui.tools.WebViewUI", intent);
                        }
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(18589, 15, Integer.valueOf(ImageGalleryUI.X(ImageGalleryUI.this)));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(233347);
                    }
                });
                com.tencent.mm.ui.tools.o.hq(this.tFX);
                com.tencent.mm.ui.tools.o.hq(this.PzJ);
                if (cG.KOe != null) {
                    ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(cG.KOe, -1, 2, new Object[0]);
                    this.PzJ.setVisibility(0);
                } else {
                    this.PzJ.setVisibility(8);
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.PzK.getLayoutParams();
                layoutParams.height = (int) (((double) this.PzI.getTextSize()) * 1.45d);
                layoutParams.width = layoutParams.height;
                this.PzK.setLayoutParams(layoutParams);
                if (this.PwE) {
                    Cd(false);
                    cWW();
                }
            }
        } else if (this.JvM != null) {
            this.JvM.setVisibility(8);
        }
        this.Pyw = b.cr(caVar);
        Log.i("MicroMsg.ImageGalleryUI", "updateFooterInfo currGalleryType: %s, pageChanged: %b", this.Pyw, Boolean.valueOf(z));
        if (h.a.gSp().tku && this.Pzy != null) {
            this.Pzy.setChecked(h.a.gSp().cE(caVar));
        }
        switch (this.Pyw) {
            case video:
                aL(this.PyT, 4);
                setVideoStateIv(true);
                com.tencent.mm.modelvideo.s cF = j.cF(caVar);
                if (cF == null) {
                    AppMethodBeat.o(233407);
                    break;
                } else {
                    gSr().FLz.setVideoTotalTime(cF.iFw);
                    try {
                        if (!(this.Pwu.gSh() == null || this.Pwu.gSh().PAO == null)) {
                            i2 = this.Pwu.gSh().PAO.getCurrentPosition() / 1000;
                            gSr().FLz.seek(i2);
                            Cd(z);
                            AppMethodBeat.o(233407);
                            break;
                        }
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.ImageGalleryUI", e2, "", new Object[0]);
                    }
                    i2 = 0;
                    gSr().FLz.seek(i2);
                    Cd(z);
                    AppMethodBeat.o(233407);
                }
            case image:
                com.tencent.mm.av.g i3 = this.Pwu.i(caVar, false);
                cWV();
                Cd(z);
                if (i3 != null) {
                    if (this.PyZ && i3.bcu() && this.Pwu.gSg() != null && caVar.field_msgId == this.Pwu.gSg().field_msgId) {
                        Log.i("MicroMsg.ImageGalleryUI", "get image successfully! -> gotoPhotoEditUI msgId:%s", Long.valueOf(caVar.field_msgId));
                        gSV();
                        this.PyZ = false;
                        AppMethodBeat.o(233407);
                        break;
                    } else {
                        ca gSg = this.Pwu.gSg();
                        Object[] objArr = new Object[4];
                        objArr[0] = Boolean.valueOf(this.PyZ);
                        objArr[1] = Long.valueOf(caVar.field_msgId);
                        objArr[2] = gSg == null ? BuildConfig.COMMAND : Long.valueOf(gSg.field_msgId);
                        objArr[3] = Boolean.valueOf(i3.bcu());
                        Log.w("MicroMsg.ImageGalleryUI", "isSoonEnterPhotoEdit:%s msgId:%s curMsgId:%s getCompleted:%s", objArr);
                        AppMethodBeat.o(233407);
                        break;
                    }
                } else {
                    Log.w("MicroMsg.ImageGalleryUI", "updateFooterInfo img info is null");
                    AppMethodBeat.o(233407);
                    break;
                }
                break;
            case appimage:
                cWV();
                Cd(z);
                AppMethodBeat.o(233407);
                break;
            case sight:
                cWV();
                Cd(z);
                aL(this.PyT, 4);
                this.Pwu.amW(this.xqs.getCurrentItem());
                AppMethodBeat.o(233407);
                break;
            default:
                Cd(z);
                AppMethodBeat.o(233407);
                break;
        }
    }

    private static int g(com.tencent.mm.av.g gVar) {
        AppMethodBeat.i(36187);
        Map<String, String> parseXml = XmlParser.parseXml(gVar.iXy, "msg", null);
        if (parseXml == null) {
            Log.e("MicroMsg.ImageGalleryUI", "parse cdnInfo failed. [%s]", gVar.iXy);
            AppMethodBeat.o(36187);
            return -1;
        }
        int i2 = Util.getInt(parseXml.get(".msg.img.$hdlength"), 0);
        if (i2 == 0) {
            i2 = Util.getInt(parseXml.get(".msg.img.$tphdlength"), 0);
        }
        AppMethodBeat.o(36187);
        return i2;
    }

    static /* synthetic */ void a(ImageGalleryUI imageGalleryUI, long j2) {
        AppMethodBeat.i(258954);
        Log.v("MicroMsg.ImageGalleryUI", "doSearchImagePreview msgId: %s", Long.valueOf(j2));
        if (com.tencent.mm.ui.chatting.gallery.a.e.gTs()) {
            imageGalleryUI.Pze.li(4, 2);
            imageGalleryUI.Pze.e(4, new Runnable() {
                /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass29 */

                public final void run() {
                    AppMethodBeat.i(233344);
                    com.tencent.mm.ui.chatting.gallery.a.g gVar = ImageGalleryUI.this.Pze;
                    Iterator<T> it = gVar.PCj.iterator();
                    while (it.hasNext()) {
                        int intValue = it.next().intValue();
                        if (gVar.ant(intValue) == null) {
                            Log.v("MicroMsg.ImageScanButtonStatusManager", "updateAllStatusIfNeedOnOverTime type: %d", Integer.valueOf(intValue));
                            gVar.anu(intValue);
                            gVar.li(intValue, 4);
                        }
                    }
                    ImageGalleryUI.this.Pze.li(4, 1);
                    ImageGalleryUI.a(ImageGalleryUI.this, 4);
                    AppMethodBeat.o(233344);
                }
            });
        }
        if (com.tencent.mm.ui.chatting.gallery.a.e.gTt()) {
            l.a(j2, new l.g(imageGalleryUI.Pzh, imageGalleryUI.Pzv, j2, System.currentTimeMillis()));
            AppMethodBeat.o(258954);
            return;
        }
        l.a(j2, new l.e(imageGalleryUI.Pzv, j2));
        AppMethodBeat.o(258954);
    }

    static /* synthetic */ boolean b(com.tencent.mm.plugin.scanner.api.f fVar) {
        AppMethodBeat.i(258956);
        if (!Util.isNullOrNil(fVar.CBb)) {
            AppMethodBeat.o(258956);
            return true;
        }
        AppMethodBeat.o(258956);
        return false;
    }

    static /* synthetic */ void q(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(258957);
        imageGalleryUI.PyA = false;
        if (imageGalleryUI.xqs != null) {
            imageGalleryUI.xqs.setEnableGalleryScale(false);
            imageGalleryUI.xqs.setSingleMode(true);
        }
        AppMethodBeat.o(258957);
    }

    static /* synthetic */ void r(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(233422);
        imageGalleryUI.Cc(false);
        AppMethodBeat.o(233422);
    }

    static /* synthetic */ void u(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(258959);
        imageGalleryUI.Cb(false);
        AppMethodBeat.o(258959);
    }

    static /* synthetic */ void y(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(233426);
        imageGalleryUI.tgM = 0;
        AppMethodBeat.o(233426);
    }

    static /* synthetic */ void B(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(258963);
        Log.i("MicroMsg.ImageGalleryUI", "%d handle single click event.", Integer.valueOf(imageGalleryUI.hashCode()));
        if (imageGalleryUI.gSO()) {
            imageGalleryUI.PzF = false;
            if (imageGalleryUI.PzM) {
                imageGalleryUI.gSG();
                AppMethodBeat.o(258963);
                return;
            }
            imageGalleryUI.Cd(false);
            AppMethodBeat.o(258963);
            return;
        }
        if (imageGalleryUI.tgN != 1) {
            imageGalleryUI.onBackPressed();
        }
        AppMethodBeat.o(258963);
    }

    static /* synthetic */ void a(ImageGalleryUI imageGalleryUI, String str, com.tencent.mm.ui.chatting.gallery.a.h hVar) {
        AppMethodBeat.i(258965);
        imageGalleryUI.a((View) null, str, (Bitmap) null, 2, hVar);
        AppMethodBeat.o(258965);
    }

    static /* synthetic */ void J(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(36232);
        imageGalleryUI.xqs.setGalleryScaleListener(new MMViewPager.c() {
            /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.AnonymousClass15 */

            @Override // com.tencent.mm.ui.base.MMViewPager.c
            public final void S(float f2, float f3) {
                float f4 = 1.0f;
                AppMethodBeat.i(233320);
                float height = 1.0f - (f3 / ((float) ImageGalleryUI.this.xqs.getHeight()));
                if (height <= 1.0f) {
                    f4 = height;
                }
                ImageGalleryUI.this.EAC = f4;
                Log.d("MicroMsg.ImageGalleryUI", "alvinluo onGalleryScale tx: %f, ty: %f, scale: %f", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4));
                ImageGalleryUI.this.contentView = ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.this.Pwu, ImageGalleryUI.this.xqs);
                if (ImageGalleryUI.this.contentView != null) {
                    if (f2 == 0.0f && f3 == 0.0f) {
                        ImageGalleryUI.M(ImageGalleryUI.this);
                    } else if (Math.abs(f2) > 10.0f || Math.abs(f3) > 10.0f) {
                        ImageGalleryUI.N(ImageGalleryUI.this);
                    }
                    ImageGalleryUI.this.contentView.setPivotX((float) (ImageGalleryUI.this.xqs.getWidth() / 2));
                    ImageGalleryUI.this.contentView.setPivotY((float) (ImageGalleryUI.this.xqs.getHeight() / 2));
                    ImageGalleryUI.this.contentView.setScaleX(f4);
                    ImageGalleryUI.this.contentView.setScaleY(f4);
                    ImageGalleryUI.this.contentView.setTranslationX(f2);
                    ImageGalleryUI.this.contentView.setTranslationY(f3);
                    ImageGalleryUI.this.jUG.setAlpha(f4);
                    AppMethodBeat.o(233320);
                    return;
                }
                Log.w("MicroMsg.ImageGalleryUI", "runDragAnimation contentView is null !!");
                AppMethodBeat.o(233320);
            }

            @Override // com.tencent.mm.ui.base.MMViewPager.c
            public final void ao(float f2, float f3) {
                AppMethodBeat.i(233321);
                ImageGalleryUI.this.EAD = (int) f2;
                ImageGalleryUI.this.EAE = (int) f3;
                AppMethodBeat.o(233321);
            }
        });
        AppMethodBeat.o(36232);
    }

    static /* synthetic */ void M(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(258967);
        if (imageGalleryUI.gSO() && imageGalleryUI.PzO) {
            try {
                if (imageGalleryUI.Pwu.gSh().gTe().PAN.getVisibility() == 8) {
                    imageGalleryUI.Pwu.gSh().gTe().PAN.setVisibility(0);
                    imageGalleryUI.PzO = false;
                }
            } catch (Exception e2) {
            }
        }
        if (imageGalleryUI.PzP) {
            imageGalleryUI.Cd(false);
            imageGalleryUI.PzP = false;
        }
        AppMethodBeat.o(258967);
    }

    static /* synthetic */ void N(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(258968);
        if (imageGalleryUI.gSO()) {
            try {
                if (imageGalleryUI.Pwu.gSh().gTe().PAN.getVisibility() == 0) {
                    imageGalleryUI.Pwu.gSh().gTe().PAN.setVisibility(8);
                    imageGalleryUI.PzO = true;
                }
            } catch (Exception e2) {
            }
        }
        if (imageGalleryUI.tmY.getVisibility() == 0) {
            imageGalleryUI.gSG();
        }
        imageGalleryUI.PzP = true;
        AppMethodBeat.o(258968);
    }

    static /* synthetic */ void Y(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(258976);
        if (imageGalleryUI.Pwu == null || (imageGalleryUI.Pwu != null && imageGalleryUI.Pwu.amt(imageGalleryUI.PzE) == null && imageGalleryUI.Pwu.gSg() == null)) {
            AppMethodBeat.o(258976);
            return;
        }
        ca amt = imageGalleryUI.Pwu.amt(imageGalleryUI.PzE);
        if (amt == null) {
            amt = imageGalleryUI.Pwu.gSg();
        }
        long j2 = amt.field_msgId;
        Log.i("MicroMsg.ImageGalleryUI", "enterPositionAtChatRecords-->talker:%s,magId:%d", imageGalleryUI.talker, Long.valueOf(j2));
        Intent intent = new Intent(imageGalleryUI.getContext(), ChattingUI.class);
        intent.putExtra("Chat_User", imageGalleryUI.gSz());
        intent.putExtra("finish_direct", true);
        intent.putExtra("show_search_chat_content_result", true);
        intent.putExtra("show_footer", true);
        intent.putExtra("key_is_biz_chat", imageGalleryUI.tca);
        intent.putExtra("key_biz_chat_id", imageGalleryUI.ppv);
        bg.aVF();
        intent.putExtra("need_hight_item", ((Boolean) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_POSITION_AT_CHATRECORD_FIRST_IN_BOOLEAN, Boolean.TRUE)).booleanValue());
        intent.putExtra("msg_local_id", j2);
        intent.putExtra("img_gallery_enter_from_chatting_ui", true);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(imageGalleryUI, bl.axQ(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "enterPositionAtChatRecords", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        imageGalleryUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(imageGalleryUI, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "enterPositionAtChatRecords", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (imageGalleryUI.Pzj) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(219, 16, 1, true);
            AppMethodBeat.o(258976);
            return;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(219, 17, 1, true);
        AppMethodBeat.o(258976);
    }

    static /* synthetic */ void ac(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(233446);
        if (imageGalleryUI.EAm == null) {
            imageGalleryUI.EAm = ((com.tencent.mm.plugin.scanner.api.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.scanner.api.c.class)).gT(imageGalleryUI);
            imageGalleryUI.EAm.eN(imageGalleryUI.xqs);
        }
        ca amt = imageGalleryUI.Pwu.amt(imageGalleryUI.PzE);
        if (amt == null) {
            Log.e("MicroMsg.ImageGalleryUI", "alvinluo dealWithImageOcr msgInfo is null");
            AppMethodBeat.o(233446);
            return;
        }
        boolean Eq = ab.Eq(amt.field_talker);
        com.tencent.mm.plugin.scanner.api.e eVar = new com.tencent.mm.plugin.scanner.api.e();
        eVar.msgId = imageGalleryUI.PyG;
        eVar.sessionId = System.currentTimeMillis();
        eVar.CAT = 3;
        eVar.CAX = false;
        eVar.efT = false;
        eVar.source = 201;
        eVar.CAY.CAZ = k(amt, Eq);
        Log.i("MicroMsg.ImageGalleryUI", "alvinluo dealWithImageOcr msgId: %s, isChatRoom: %b, sourceUsername: %s", Long.valueOf(imageGalleryUI.PyG), Boolean.valueOf(Eq), eVar.CAY.CAZ);
        imageGalleryUI.cWi();
        imageGalleryUI.EAm.eO(imageGalleryUI.a(imageGalleryUI.Pwu, imageGalleryUI.xqs));
        imageGalleryUI.EAn.hY(1, Eq ? 2 : 1);
        com.tencent.mm.plugin.scanner.api.d dVar = new com.tencent.mm.plugin.scanner.api.d();
        dVar.CAL = true;
        imageGalleryUI.EAl = imageGalleryUI.EAm.a(eVar, dVar, imageGalleryUI.EAo);
        AppMethodBeat.o(233446);
    }

    static /* synthetic */ void af(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(258981);
        if (!(imageGalleryUI.PyI == 0 || imageGalleryUI.PyI == 4 || (imageGalleryUI.Pze.isValid(imageGalleryUI.PyI) && imageGalleryUI.Pze.oe(imageGalleryUI.PyI)))) {
            imageGalleryUI.Pzf++;
            Log.i("MicroMsg.ImageGalleryUI", "alvinluo checkQuickButtonWhenPageChanged not valid %d, currentButtonType: %d", Integer.valueOf(imageGalleryUI.Pzf), Integer.valueOf(imageGalleryUI.PyI));
            if (imageGalleryUI.Pzf >= 2) {
                imageGalleryUI.bJ(0, false);
                imageGalleryUI.Pzf = 0;
            }
        }
        AppMethodBeat.o(258981);
    }

    static /* synthetic */ void ag(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(258982);
        com.tencent.mm.ui.chatting.gallery.a.g gVar = imageGalleryUI.Pze;
        Log.i("MicroMsg.ImageScanButtonStatusManager", "alvinluo resetSet");
        gVar.anv(1);
        gVar.anv(2);
        gVar.anv(3);
        gVar.anv(4);
        Iterator<T> it = gVar.PCj.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            gVar.anu(intValue);
            g.a aVar = gVar.PCk.get(Integer.valueOf(intValue));
            if (aVar != null) {
                aVar.setEnable(true);
            }
        }
        n nVar = imageGalleryUI.Pzb;
        nVar.CFJ = null;
        nVar.dFL = 0;
        nVar.dFM = 0;
        nVar.PDc = null;
        imageGalleryUI.Erb = false;
        d dVar = imageGalleryUI.VlB;
        Log.i("MicroMsg.ImageGalleryUI", "reset#ScanState");
        dVar.mState = 0;
        AppMethodBeat.o(258982);
    }

    static /* synthetic */ void ap(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(258985);
        int aD = au.aD(imageGalleryUI);
        Log.i("MicroMsg.ImageGalleryUI", "%d handleVerticalUI image gallery ui isNavigationBarTint %b navBarHeight %d", Integer.valueOf(imageGalleryUI.hashCode()), Boolean.valueOf(imageGalleryUI.zss), Integer.valueOf(aD));
        imageGalleryUI.gSU();
        int aH = com.tencent.mm.cb.a.aH(imageGalleryUI, R.dimen.ct);
        int aH2 = com.tencent.mm.cb.a.aH(imageGalleryUI, R.dimen.cc);
        int aH3 = com.tencent.mm.cb.a.aH(imageGalleryUI, R.dimen.c5);
        int aH4 = com.tencent.mm.cb.a.aH(imageGalleryUI, R.dimen.ce);
        int i2 = (aH * 2) + aD;
        imageGalleryUI.tmY.setPadding(0, aH * 2, 0, i2);
        imageGalleryUI.PyE = aH3;
        imageGalleryUI.PyF = aH2;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageGalleryUI.gSr().FLz.getLayoutParams();
        layoutParams.removeRule(1);
        layoutParams.removeRule(0);
        layoutParams.setMargins(aH2, aH4, aH2, 0);
        imageGalleryUI.gSr().FLz.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageGalleryUI.gSr().JvS.getLayoutParams();
        layoutParams2.height = com.tencent.mm.cb.a.aG(imageGalleryUI, R.dimen.c4);
        layoutParams2.bottomMargin = aD;
        imageGalleryUI.gSr().JvS.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) imageGalleryUI.PyK.getLayoutParams();
        layoutParams3.addRule(3, R.id.j5y);
        layoutParams3.setMargins(aH2, aH4, 0, 0);
        layoutParams3.removeRule(15);
        imageGalleryUI.PyK.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) imageGalleryUI.PyM.getLayoutParams();
        layoutParams4.addRule(3, R.id.j5y);
        layoutParams4.setMargins(0, aH4, aH2, 0);
        layoutParams4.removeRule(15);
        imageGalleryUI.PyM.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) imageGalleryUI.gSs().PyL.getLayoutParams();
        layoutParams5.addRule(3, R.id.j5y);
        layoutParams5.setMargins(0, aH4, aH3, 0);
        layoutParams5.removeRule(15);
        imageGalleryUI.gSs().PyL.setLayoutParams(layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) imageGalleryUI.gSt().PyN.getLayoutParams();
        layoutParams6.addRule(3, R.id.j5y);
        layoutParams6.setMargins(0, aH4, aH3, 0);
        layoutParams6.removeRule(15);
        imageGalleryUI.gSt().PyN.setLayoutParams(layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) imageGalleryUI.PyO.getLayoutParams();
        layoutParams7.addRule(3, R.id.j5y);
        layoutParams7.setMargins(0, aH4, aH3, 0);
        layoutParams7.removeRule(15);
        imageGalleryUI.PyO.setLayoutParams(layoutParams7);
        RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) imageGalleryUI.gSu().PyP.getLayoutParams();
        layoutParams8.addRule(3, R.id.j5y);
        layoutParams8.setMargins(0, aH4, aH3, 0);
        layoutParams8.removeRule(15);
        imageGalleryUI.gSu().PyP.setLayoutParams(layoutParams8);
        RelativeLayout.LayoutParams layoutParams9 = (RelativeLayout.LayoutParams) imageGalleryUI.gSw().PyR.getLayoutParams();
        layoutParams9.addRule(3, R.id.j5y);
        layoutParams9.setMargins(0, aH4, aH3, 0);
        layoutParams9.removeRule(15);
        imageGalleryUI.gSw().PyR.setLayoutParams(layoutParams9);
        RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) imageGalleryUI.gSq().PyT.getLayoutParams();
        layoutParams10.setMargins(aH2, aH4, 0, 0);
        layoutParams10.removeRule(15);
        layoutParams10.addRule(9);
        imageGalleryUI.gSq().PyT.setLayoutParams(layoutParams10);
        RelativeLayout.LayoutParams layoutParams11 = (RelativeLayout.LayoutParams) imageGalleryUI.gSx().PyS.getLayoutParams();
        layoutParams11.setMargins(0, 0, aH2, imageGalleryUI.PyD + i2 + aH);
        imageGalleryUI.gSx().PyS.setLayoutParams(layoutParams11);
        if (imageGalleryUI.PyH) {
            imageGalleryUI.PyH = false;
            imageGalleryUI.gSL();
        }
        AppMethodBeat.o(258985);
    }

    static /* synthetic */ void aq(ImageGalleryUI imageGalleryUI) {
        AppMethodBeat.i(258986);
        int aD = au.aD(imageGalleryUI);
        Log.i("MicroMsg.ImageGalleryUI", "%d handleHorizontalUI image gallery ui isNavigationBarTint %b navBarHeight %d", Integer.valueOf(imageGalleryUI.hashCode()), Boolean.valueOf(imageGalleryUI.zss), Integer.valueOf(aD));
        imageGalleryUI.anj(aD);
        int aH = com.tencent.mm.cb.a.aH(imageGalleryUI, R.dimen.ct);
        int aH2 = com.tencent.mm.cb.a.aH(imageGalleryUI, R.dimen.ce);
        int aH3 = com.tencent.mm.cb.a.aH(imageGalleryUI, R.dimen.c5);
        int aH4 = com.tencent.mm.cb.a.aH(imageGalleryUI, R.dimen.ci);
        int aH5 = com.tencent.mm.cb.a.aH(imageGalleryUI, R.dimen.cr);
        int max = Math.max(aD - (aH * 3), 0);
        int i2 = aH * 2;
        int max2 = Math.max(aH4 - max, 0);
        imageGalleryUI.tmY.setPadding(max, aH * 2, max, i2);
        imageGalleryUI.PyE = aH3;
        imageGalleryUI.PyF = max + aH4;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageGalleryUI.PyK.getLayoutParams();
        layoutParams.removeRule(3);
        layoutParams.setMargins(max2, aH2, 0, aH2);
        layoutParams.addRule(15);
        imageGalleryUI.PyK.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageGalleryUI.gSr().JvS.getLayoutParams();
        layoutParams2.height = com.tencent.mm.cb.a.aG(imageGalleryUI, R.dimen.bz);
        layoutParams2.bottomMargin = 0;
        imageGalleryUI.gSr().JvS.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) imageGalleryUI.PyM.getLayoutParams();
        layoutParams3.removeRule(3);
        layoutParams3.setMargins(0, aH2, aH4, aH2);
        layoutParams3.addRule(15);
        imageGalleryUI.PyM.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) imageGalleryUI.gSs().PyL.getLayoutParams();
        layoutParams4.removeRule(3);
        layoutParams4.setMargins(0, aH2, aH3, aH2);
        layoutParams4.addRule(15);
        imageGalleryUI.gSs().PyL.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) imageGalleryUI.gSt().PyN.getLayoutParams();
        layoutParams5.removeRule(3);
        layoutParams5.setMargins(0, aH2, aH3, aH2);
        layoutParams5.addRule(15);
        imageGalleryUI.gSt().PyN.setLayoutParams(layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) imageGalleryUI.PyO.getLayoutParams();
        layoutParams6.removeRule(3);
        layoutParams6.setMargins(0, aH2, aH3, aH2);
        layoutParams6.addRule(15);
        imageGalleryUI.PyO.setLayoutParams(layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) imageGalleryUI.gSu().PyP.getLayoutParams();
        layoutParams7.removeRule(3);
        layoutParams7.setMargins(0, aH2, aH3, aH2);
        layoutParams7.addRule(15);
        imageGalleryUI.gSu().PyP.setLayoutParams(layoutParams7);
        RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) imageGalleryUI.gSw().PyR.getLayoutParams();
        layoutParams8.removeRule(3);
        layoutParams8.setMargins(0, aH2, aH3, aH2);
        layoutParams8.addRule(15);
        imageGalleryUI.gSw().PyR.setLayoutParams(layoutParams8);
        RelativeLayout.LayoutParams layoutParams9 = (RelativeLayout.LayoutParams) imageGalleryUI.gSq().PyT.getLayoutParams();
        layoutParams9.setMargins(max2, aH2, 0, aH2);
        layoutParams9.removeRule(3);
        layoutParams9.addRule(15);
        layoutParams9.addRule(9);
        imageGalleryUI.gSq().PyT.setLayoutParams(layoutParams9);
        RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) imageGalleryUI.gSr().FLz.getLayoutParams();
        layoutParams10.addRule(1, R.id.j43);
        layoutParams10.addRule(0, R.id.c41);
        layoutParams10.setMargins(aH5, aH2, aH5, aH2);
        imageGalleryUI.gSr().FLz.setLayoutParams(layoutParams10);
        RelativeLayout.LayoutParams layoutParams11 = (RelativeLayout.LayoutParams) imageGalleryUI.gSx().PyS.getLayoutParams();
        layoutParams11.setMargins(0, 0, aH4 + max, aH + aH2 + i2 + imageGalleryUI.PyD);
        imageGalleryUI.gSx().PyS.setLayoutParams(layoutParams11);
        if (imageGalleryUI.PyH) {
            imageGalleryUI.PyH = false;
            imageGalleryUI.gSL();
        }
        AppMethodBeat.o(258986);
    }
}
