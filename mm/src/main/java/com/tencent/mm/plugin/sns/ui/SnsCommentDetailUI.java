package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.g.a.iq;
import com.tencent.mm.g.a.ir;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.a.va;
import com.tencent.mm.g.a.vu;
import com.tencent.mm.g.a.wi;
import com.tencent.mm.g.a.wk;
import com.tencent.mm.g.a.wl;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.g.b.a.ih;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ad.g.j;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.ad.g.o;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.plugin.sns.lucky.view.SnsDetailLuckyHeader;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.model.m;
import com.tencent.mm.plugin.sns.model.s;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.plugin.sns.ui.SnsCommentFooter;
import com.tencent.mm.plugin.sns.ui.br;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.f;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnc;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.blur.f;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@i
public class SnsCommentDetailUI extends MMSecDataActivity implements com.tencent.mm.ak.i, i.a, c.b, ab {
    private static com.tencent.mm.av.a.a.c EBQ;
    private static com.tencent.mm.av.a.a.c EBR;
    public static int EBs = 34;
    private static com.tencent.mm.loader.c.d<String, Bitmap> uIN = new com.tencent.mm.loader.c.c() {
        /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass44 */

        @Override // com.tencent.mm.loader.c.d, com.tencent.mm.loader.c.c
        public final com.tencent.mm.loader.e.c.a<Bitmap> aJK() {
            AppMethodBeat.i(163115);
            com.tencent.mm.loader.e.c.a<Bitmap> aVar = new com.tencent.mm.loader.e.c.a<>(new com.tencent.mm.loader.e.c.c(0.5f).aJY());
            AppMethodBeat.o(163115);
            return aVar;
        }
    };
    private LinearLayout DGk;
    private boolean DKd = false;
    private boolean DKf = false;
    private com.tencent.mm.plugin.sns.ui.d.c Dyw;
    private long EAN = 0;
    private long EAO = 0;
    private View EAP;
    private TextView EAQ;
    private LinearLayout EAR;
    private SnsDetailLuckyHeader EAS;
    private ListView EAT;
    private View EAU;
    private View EAV;
    private b EAW;
    private ScaleAnimation EAX;
    private ScaleAnimation EAY;
    LinearLayout EAZ;
    private boolean EBA = false;
    private String EBB = "";
    private boolean EBC = true;
    private int EBD;
    private boolean EBE = false;
    private int EBF = 0;
    private n EBG = null;
    private TextView EBH = null;
    private boolean EBI;
    private FrameLayout EBJ;
    private f EBK = null;
    private ak EBL = new ak();
    private IListener EBM = new IListener<wi>() {
        /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass1 */

        {
            AppMethodBeat.i(160708);
            this.__eventId = wi.class.getName().hashCode();
            AppMethodBeat.o(160708);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(wi wiVar) {
            AppMethodBeat.i(98533);
            wi wiVar2 = wiVar;
            if (wiVar2 instanceof wi) {
                String str = wiVar2.ect.id;
                String str2 = wiVar2.ect.result;
                String str3 = wiVar2.ect.ecu;
                if (wiVar2.ect.type == 1) {
                    SnsCommentDetailUI.a(SnsCommentDetailUI.this, str, str2, str3);
                } else if (wiVar2.ect.type == 2) {
                    SnsCommentDetailUI.a(SnsCommentDetailUI.this, str);
                }
            }
            AppMethodBeat.o(98533);
            return false;
        }
    };
    private IListener EBN = new IListener<wk>() {
        /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass12 */

        {
            AppMethodBeat.i(160712);
            this.__eventId = wk.class.getName().hashCode();
            AppMethodBeat.o(160712);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(wk wkVar) {
            AppMethodBeat.i(98548);
            wk wkVar2 = wkVar;
            if (wkVar2 instanceof wk) {
                String str = wkVar2.ecw.id;
                if (wkVar2.ecw.type == 1) {
                    SnsCommentDetailUI.b(SnsCommentDetailUI.this, str);
                } else if (wkVar2.ecw.type == 2) {
                    SnsCommentDetailUI.c(SnsCommentDetailUI.this, str);
                }
            }
            AppMethodBeat.o(98548);
            return false;
        }
    };
    private IListener EBO = new IListener<wl>() {
        /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass23 */

        {
            AppMethodBeat.i(160714);
            this.__eventId = wl.class.getName().hashCode();
            AppMethodBeat.o(160714);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(wl wlVar) {
            AppMethodBeat.i(98561);
            wl wlVar2 = wlVar;
            if (wlVar2 instanceof wl) {
                String str = wlVar2.ecx.id;
                if (wlVar2.ecx.type == 1) {
                    SnsCommentDetailUI.d(SnsCommentDetailUI.this, str);
                } else if (wlVar2.ecx.type == 2) {
                    SnsCommentDetailUI.e(SnsCommentDetailUI.this, str);
                }
            }
            AppMethodBeat.o(98561);
            return false;
        }
    };
    private IListener EBP = new IListener<ir>() {
        /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass34 */

        {
            AppMethodBeat.i(160715);
            this.__eventId = ir.class.getName().hashCode();
            AppMethodBeat.o(160715);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ir irVar) {
            AppMethodBeat.i(98574);
            ir irVar2 = irVar;
            if (irVar2 instanceof ir) {
                SnsCommentDetailUI.a(SnsCommentDetailUI.this, irVar2.dNm.dNp, irVar2.dNm.dNo, irVar2);
            }
            AppMethodBeat.o(98574);
            return false;
        }
    };
    private d EBS = new d();
    private View.OnClickListener EBT = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass46 */

        public final void onClick(View view) {
            AppMethodBeat.i(163116);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.e("MicroMsg.SnsCommentDetailUI", "scrollTopClickListener");
            SnsCommentDetailUI.f(SnsCommentDetailUI.this);
            if (!SnsCommentDetailUI.this.EBd) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(163116);
                return;
            }
            SnsCommentDetailUI.h(SnsCommentDetailUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(163116);
        }
    };
    private IListener EBU = new IListener<vu>() {
        /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass8 */

        {
            AppMethodBeat.i(160710);
            this.__eventId = vu.class.getName().hashCode();
            AppMethodBeat.o(160710);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(vu vuVar) {
            AppMethodBeat.i(98545);
            SnsCommentDetailUI.this.fhP();
            AppMethodBeat.o(98545);
            return false;
        }
    };
    private IListener EBV = new IListener<iq>() {
        /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass10 */

        {
            AppMethodBeat.i(163092);
            this.__eventId = iq.class.getName().hashCode();
            AppMethodBeat.o(163092);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* bridge */ /* synthetic */ boolean callback(iq iqVar) {
            return false;
        }
    };
    boolean EBW = false;
    private LinearLayout EBX = null;
    private boolean EBY = false;
    PhotosContent EBZ = null;
    LinearLayout EBa;
    private LinkedList<dzo> EBb;
    private int EBc = -1;
    private boolean EBd = false;
    private be EBe;
    private String EBf;
    private bv EBg;
    private int EBh = 0;
    private ImageView EBi;
    private WeImageView EBj;
    private j EBk;
    private l EBl;
    private boolean EBm = false;
    private long EBn = 0;
    private br EBo;
    private boolean EBp = false;
    private int EBq;
    private int EBr = 103;
    public int EBt = 210;
    private com.tencent.mm.plugin.sns.ui.c.a.a EBu;
    public k EBv;
    private SnsTranslateResultView EBw;
    private boolean EBx = false;
    private Dialog EBy = null;
    private boolean EBz = false;
    int ECa = 0;
    public ay.b.a ECb = new ay.b.a() {
        /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass22 */

        @Override // com.tencent.mm.model.ay.b.a
        public final void p(final String str, final boolean z) {
            AppMethodBeat.i(203516);
            Log.i("MicroMsg.SnsCommentDetailUI", "setAvatar, getContactCallBack, userName=" + str + ", succ=" + z + ", retryCount=" + SnsCommentDetailUI.this.ECa);
            new MMHandler(Looper.getMainLooper()).postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass22.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(203515);
                    if (z && !SnsCommentDetailUI.this.isFinishing() && SnsCommentDetailUI.this.ECa < 5) {
                        Log.i("MicroMsg.SnsCommentDetailUI", "setAvatar, setHeader after getContact, userName=" + str);
                        SnsCommentDetailUI.this.fhP();
                    }
                    SnsCommentDetailUI.this.ECa++;
                    AppMethodBeat.o(203515);
                }
            }, 500);
            AppMethodBeat.o(203516);
        }
    };
    private bq ECc = null;
    private boolean EoG;
    private SnsCommentFooter EoJ;
    private bb EoL;
    private b EoR;
    private com.tencent.mm.plugin.sns.h.b EoS;
    private ap EoT;
    private bu EoU;
    private q EoW = null;
    private IListener EoY = new IListener<va>() {
        /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass43 */

        {
            AppMethodBeat.i(160716);
            this.__eventId = va.class.getName().hashCode();
            AppMethodBeat.o(160716);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(va vaVar) {
            boolean z;
            AppMethodBeat.i(98577);
            va vaVar2 = vaVar;
            if ((vaVar2 instanceof va) && SnsCommentDetailUI.this.EAT != null) {
                ListView listView = SnsCommentDetailUI.this.EAT;
                if (!vaVar2.ebs.enable) {
                    z = true;
                } else {
                    z = false;
                }
                listView.requestDisallowInterceptTouchEvent(z);
            }
            AppMethodBeat.o(98577);
            return false;
        }
    };
    private View.OnTouchListener EqE = Util.genLinearPressedListener();
    private volatile boolean ExJ = false;
    private ScreenShotUtil.ScreenShotCallback EyL = new ScreenShotUtil.ScreenShotCallback() {
        /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass11 */

        @Override // com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback
        public final void onScreenShot(String str, long j2) {
            AppMethodBeat.i(203504);
            Log.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "onScreenShot， path = " + str + "， dateAdded = " + j2);
            SnsCommentDetailUI.u(SnsCommentDetailUI.this);
            AppMethodBeat.o(203504);
        }
    };
    private String dRS;
    private String dSF = "";
    private String gna;
    private IListener lEl = new IListener<mx>() {
        /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass9 */

        {
            AppMethodBeat.i(160711);
            this.__eventId = mx.class.getName().hashCode();
            AppMethodBeat.o(160711);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mx mxVar) {
            AppMethodBeat.i(163091);
            mx mxVar2 = mxVar;
            if (mxVar2 instanceof mx) {
                switch (mxVar2.dSE.action) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 7:
                        SnsCommentDetailUI.q(SnsCommentDetailUI.this);
                        SnsCommentDetailUI.r(SnsCommentDetailUI.this);
                        break;
                }
            }
            AppMethodBeat.o(163091);
            return false;
        }
    };
    private com.tencent.mm.pluginsdk.ui.span.a mAdTagClickCallback = new com.tencent.mm.pluginsdk.ui.span.a() {
        /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass24 */

        @Override // com.tencent.mm.pluginsdk.ui.span.a
        public final void iL(int i2, int i3) {
            AppMethodBeat.i(203517);
            try {
                SnsInfo a2 = SnsCommentDetailUI.a(SnsCommentDetailUI.this, false);
                if (a2 != null) {
                    Log.i("AdTagClickableHelper", "In SnsCommentDetailUI, snsId = " + a2.field_snsId + ", source = " + SnsCommentDetailUI.this.getSource() + ", clickPos = " + i3);
                    com.tencent.mm.plugin.sns.ad.timeline.b.b.a(SnsCommentDetailUI.this, SnsCommentDetailUI.this.getSource(), a2, i3);
                    AppMethodBeat.o(203517);
                    return;
                }
                Log.e("AdTagClickableHelper", "In SnsCommentDetailUI, snsInfo is null");
                AppMethodBeat.o(203517);
            } catch (Throwable th) {
                Log.e("AdTagClickableHelper", th.toString());
                AppMethodBeat.o(203517);
            }
        }
    };
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean mci = false;
    private int oUs = 0;
    private com.tencent.mm.ui.widget.b.a pqr;
    private View.OnClickListener pri = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass45 */

        public final void onClick(View view) {
            ADXml adXml;
            boolean z = false;
            AppMethodBeat.i(98579);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            String str = (String) view.getTag();
            Log.d("MicroMsg.SnsCommentDetailUI", "onCommentClick:".concat(String.valueOf(str)));
            SnsInfo a2 = SnsCommentDetailUI.a(SnsCommentDetailUI.this, true);
            if (a2 == null || !a2.isAd()) {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", str);
                com.tencent.mm.plugin.sns.c.a.jRt.c(intent, SnsCommentDetailUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(98579);
                return;
            }
            SnsAdClick snsAdClick = new SnsAdClick(SnsCommentDetailUI.this.getSource(), 2, a2.field_snsId, 1, 0);
            com.tencent.mm.plugin.sns.data.k.a(snsAdClick, SnsCommentDetailUI.this.EBv, a2, 1);
            if (!(str == null || !str.equals(a2.getUserName()) || (adXml = a2.getAdXml()) == null)) {
                if (adXml.headClickType != 1 || Util.isNullOrNil(adXml.headClickParam)) {
                    com.tencent.mm.plugin.sns.ad.timeline.a.d dVar = new com.tencent.mm.plugin.sns.ad.timeline.a.d();
                    dVar.put("ext_sns_ad_click", (Object) snsAdClick);
                    com.tencent.mm.plugin.sns.ad.timeline.a.c d2 = com.tencent.mm.plugin.sns.ad.timeline.a.a.d(1, SnsCommentDetailUI.this);
                    if (d2 != null && d2.a(view, SnsCommentDetailUI.this.getSource(), a2, dVar)) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(98579);
                        return;
                    }
                } else {
                    String str2 = adXml.headClickParam;
                    ADInfo a3 = SnsCommentDetailUI.a(SnsCommentDetailUI.this, a2);
                    if (a3 != null) {
                        str2 = r.kb(str2, a3.uxInfo);
                    }
                    Log.i("MicroMsg.SnsCommentDetailUI", "headClickParam url " + str2 + " " + adXml.headClickRightBarShow);
                    Intent intent2 = new Intent();
                    if (adXml.headClickRightBarShow == 0) {
                        z = true;
                    }
                    intent2.putExtra("KsnsViewId", SnsCommentDetailUI.a(SnsCommentDetailUI.this, a2).viewId);
                    intent2.putExtra("KRightBtn", z);
                    intent2.putExtra("jsapiargs", new Bundle());
                    intent2.putExtra("rawUrl", str2);
                    intent2.putExtra("useJs", true);
                    com.tencent.mm.plugin.sns.c.a.jRt.i(intent2, SnsCommentDetailUI.this);
                    r.a(snsAdClick);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(98579);
                    return;
                }
            }
            r.a(snsAdClick);
            Intent intent3 = new Intent();
            intent3.putExtra("Contact_User", str);
            intent3.putExtra("Contact_Scene", 37);
            com.tencent.mm.plugin.sns.c.a.jRt.c(intent3, SnsCommentDetailUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98579);
        }
    };
    private View.OnClickListener qOH = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass3 */

        public final void onClick(View view) {
            AppMethodBeat.i(163081);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.e("MicroMsg.SnsCommentDetailUI", "scrollTopClickListener");
            SnsCommentDetailUI.a(SnsCommentDetailUI.this, view);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(163081);
        }
    };
    private int qcr;

    public SnsCommentDetailUI() {
        AppMethodBeat.i(98590);
        AppMethodBeat.o(98590);
    }

    static /* synthetic */ int C(SnsCommentDetailUI snsCommentDetailUI) {
        AppMethodBeat.i(203551);
        int fhN = snsCommentDetailUI.fhN();
        AppMethodBeat.o(203551);
        return fhN;
    }

    static /* synthetic */ ADInfo a(SnsCommentDetailUI snsCommentDetailUI, SnsInfo snsInfo) {
        AppMethodBeat.i(203545);
        ADInfo g2 = snsCommentDetailUI.g(snsInfo);
        AppMethodBeat.o(203545);
        return g2;
    }

    static /* synthetic */ SnsInfo a(SnsCommentDetailUI snsCommentDetailUI, boolean z) {
        AppMethodBeat.i(203544);
        SnsInfo vs = snsCommentDetailUI.vs(z);
        AppMethodBeat.o(203544);
        return vs;
    }

    static /* synthetic */ void b(SnsInfo snsInfo, PhotosContent photosContent, int i2) {
        AppMethodBeat.i(203552);
        a(snsInfo, photosContent, i2);
        AppMethodBeat.o(203552);
    }

    static /* synthetic */ void f(SnsCommentDetailUI snsCommentDetailUI) {
        AppMethodBeat.i(98623);
        snsCommentDetailUI.fhQ();
        AppMethodBeat.o(98623);
    }

    static /* synthetic */ void q(SnsCommentDetailUI snsCommentDetailUI) {
        AppMethodBeat.i(98625);
        snsCommentDetailUI.fhS();
        AppMethodBeat.o(98625);
    }

    static /* synthetic */ void r(SnsCommentDetailUI snsCommentDetailUI) {
        AppMethodBeat.i(203547);
        snsCommentDetailUI.fhT();
        AppMethodBeat.o(203547);
    }

    static {
        AppMethodBeat.i(163117);
        c.a aVar = new c.a();
        aVar.jbf = true;
        aVar.jbd = true;
        EBQ = aVar.bdv();
        c.a aVar2 = new c.a();
        aVar2.jbf = true;
        aVar2.jbd = true;
        EBR = aVar2.bdv();
        AppMethodBeat.o(163117);
    }

    private static boolean f(LinkedList<dzo> linkedList, LinkedList<dzo> linkedList2) {
        AppMethodBeat.i(98591);
        if (linkedList == null || linkedList2 == null) {
            AppMethodBeat.o(98591);
            return false;
        } else if (linkedList.size() != linkedList2.size()) {
            AppMethodBeat.o(98591);
            return false;
        } else {
            int size = linkedList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (!linkedList.get(i2).Username.equals(linkedList2.get(i2).Username)) {
                    AppMethodBeat.o(98591);
                    return false;
                }
            }
            AppMethodBeat.o(98591);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.sns.b.i.a
    public final void a(String str, boolean z, int i2, com.tencent.mm.plugin.sns.b.b bVar) {
    }

    @Override // com.tencent.mm.plugin.sns.b.i.a
    public final void b(String str, boolean z, int i2, com.tencent.mm.plugin.sns.b.b bVar) {
    }

    @Override // com.tencent.mm.plugin.sns.b.i.a
    public final void a(String str, String str2, boolean z, int i2, com.tencent.mm.plugin.sns.b.b bVar) {
    }

    @Override // com.tencent.mm.plugin.sns.ui.ab
    public final ap ffr() {
        return this.EoT;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ab
    public final b ffs() {
        return this.EoR;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ab
    public final bs fft() {
        return null;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ab
    public final bu ffu() {
        return this.EoU;
    }

    /* access modifiers changed from: package-private */
    public class d implements Runnable {
        private int ECI = -1;
        private int ECJ = 10;
        int UZ = -1;
        int kn;
        private int offset = 0;

        d() {
        }

        public final void run() {
            AppMethodBeat.i(98589);
            this.ECJ = 10;
            SnsCommentDetailUI.this.EBd = true;
            this.ECI = SnsCommentDetailUI.this.EoJ.getTop();
            int i2 = this.ECI - this.kn;
            Log.i("MicroMsg.SnsCommentDetailUI", "list.bottom: %d, listOriginalBottom: %d, footerTop: %d, commentFooter.getTop: %d, topSelection: %d", Integer.valueOf(SnsCommentDetailUI.this.EAT.getBottom()), Integer.valueOf(SnsCommentDetailUI.this.EBc), Integer.valueOf(this.ECI), Integer.valueOf(SnsCommentDetailUI.this.EoJ.getTop()), Integer.valueOf(i2));
            if (i2 == this.offset) {
                SnsCommentDetailUI.this.EAT.setSelectionFromTop(SnsCommentDetailUI.this.EAT.getHeaderViewsCount() + this.UZ, i2);
                this.ECJ = 0;
                this.offset = 0;
                AppMethodBeat.o(98589);
                return;
            }
            int i3 = this.ECJ;
            this.ECJ = i3 - 1;
            if (i3 > 0) {
                new MMHandler().postDelayed(this, 100);
                this.offset = i2;
                AppMethodBeat.o(98589);
                return;
            }
            this.offset = 0;
            this.ECJ = 0;
            AppMethodBeat.o(98589);
        }
    }

    /* access modifiers changed from: package-private */
    public class a extends com.tencent.mm.pluginsdk.ui.span.q {
        a() {
        }

        @Override // com.tencent.mm.pluginsdk.ui.span.p, com.tencent.mm.pluginsdk.ui.span.q
        public final void onClick(View view) {
            AppMethodBeat.i(98583);
            SnsCommentDetailUI.this.EBo.ERi.onClick(view);
            AppMethodBeat.o(98583);
        }

        @Override // com.tencent.mm.pluginsdk.ui.span.p, com.tencent.mm.pluginsdk.ui.span.q
        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.i(98584);
            int color = SnsCommentDetailUI.this.getResources().getColor(R.color.a91);
            if (getPress()) {
                textPaint.bgColor = color;
                AppMethodBeat.o(98584);
                return;
            }
            textPaint.bgColor = 0;
            AppMethodBeat.o(98584);
        }
    }

    private void vr(boolean z) {
        AppMethodBeat.i(98592);
        this.EBd = false;
        if (this.EoJ.fhV()) {
            this.EoJ.ECO = 0;
            this.EoJ.fhY();
            this.EoJ.setCommentHint(getString(R.string.hbp));
        }
        this.EoJ.vt(false);
        if (z) {
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(this.EAT);
            Object obj = new Object();
            com.tencent.mm.hellhoundlib.a.a.a(obj, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI", "scrollDown", "(Z)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
            BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI", "scrollDown", "(Z)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        }
        AppMethodBeat.o(98592);
    }

    private SnsInfo vs(boolean z) {
        SnsInfo aQl;
        AppMethodBeat.i(98593);
        if (!Util.isNullOrNil(this.EBf)) {
            aQl = com.tencent.mm.plugin.sns.storage.f.aQm(this.EBf);
            if (aQl == null) {
                if (z) {
                    Toast.makeText(this, (int) R.string.h8u, 0).show();
                }
                finish();
                AppMethodBeat.o(98593);
                return null;
            }
            this.dRS = aQl.getSnsId();
        } else {
            aQl = com.tencent.mm.plugin.sns.storage.f.aQl(this.dRS);
            if (aQl == null) {
                finish();
                AppMethodBeat.o(98593);
                return null;
            }
            this.EBf = aQl.getLocalid();
        }
        AppMethodBeat.o(98593);
        return aQl;
    }

    public final int getSource() {
        if (this.EBD == 16) {
            return 2;
        }
        return 1;
    }

    private ADInfo g(SnsInfo snsInfo) {
        AppMethodBeat.i(98594);
        if (snsInfo == null) {
            AppMethodBeat.o(98594);
            return null;
        } else if (getSource() == 2) {
            ADInfo atAdInfo = snsInfo.getAtAdInfo();
            AppMethodBeat.o(98594);
            return atAdInfo;
        } else {
            ADInfo adInfo = snsInfo.getAdInfo();
            AppMethodBeat.o(98594);
            return adInfo;
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z;
        int intExtra;
        AppMethodBeat.i(98595);
        h.q(this);
        super.onCreate(bundle);
        this.EBI = com.tencent.mm.plugin.sns.ad.timeline.b.f.eXW();
        this.DKd = ((e) g.ah(e.class)).getStoryBasicConfig().a(f.a.TimeLine_Comment);
        this.DKf = ((e) g.ah(e.class)).getStoryBasicConfig().a(f.a.TimeLine_Like);
        com.tencent.mm.ui.b.e(this, true);
        aj.faE().a(5, "@__weixintimtline", this);
        this.EBF = at.fromDPToPix(this, 14);
        Point az = ao.az(this);
        this.mScreenWidth = az.x;
        this.mScreenHeight = az.y;
        this.EAN = System.currentTimeMillis();
        this.pqr = new com.tencent.mm.ui.widget.b.a(this);
        this.EBD = getIntent().getIntExtra("INTENT_COMMENT_TYPE", 0);
        this.EBE = getIntent().getBooleanExtra("INTENT_NEED_RPT_FEED", false);
        if (this.EBE) {
            com.tencent.mm.plugin.sns.k.e.DUQ.fcA();
        }
        a.C1715a aVar = com.tencent.mm.plugin.sns.i.a.DRI;
        a.C1715a.gZ(this);
        this.dRS = Util.nullAs(getIntent().getStringExtra("INTENT_SNSID"), "");
        if (Util.isNullOrNil(this.dRS)) {
            this.dRS = y.bp("sns_table_", getIntent().getLongExtra("INTENT_SNSID", 0));
        }
        this.EBf = Util.nullAs(getIntent().getStringExtra("INTENT_SNS_LOCAL_ID"), "");
        if (Util.isNullOrNil(this.EBf) && (intExtra = getIntent().getIntExtra("INTENT_SNS_LOCAL_ID", -1)) != -1) {
            this.EBf = y.bp("sns_table_", (long) intExtra);
        }
        this.Dyw = new com.tencent.mm.plugin.sns.ui.d.c(getSource(), this, this.EBL) {
            /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.sns.ui.d.c
            public final void dS(Object obj) {
                AppMethodBeat.i(163082);
                SnsCommentDetailUI.f(SnsCommentDetailUI.this);
                SnsCommentDetailUI.this.EoL.v((View) obj, 2, SnsCommentDetailUI.this.getSource());
                View view = (View) obj;
                if (view.getTag() instanceof bc) {
                    bc bcVar = (bc) view.getTag();
                    String str = bcVar.dJX;
                    int i2 = bcVar.index;
                    SnsInfo aQm = com.tencent.mm.plugin.sns.storage.f.aQm(str);
                    com.tencent.mm.plugin.sns.k.e.DUQ.d(aQm, i2);
                    com.tencent.mm.plugin.sns.k.e.DUQ.e(aQm, i2);
                }
                AppMethodBeat.o(163082);
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.c
            public final void ffw() {
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.c
            public final void fr(View view) {
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.c
            public final void fq(View view) {
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.c
            public final void fo(View view) {
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.c
            public final void fp(View view) {
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.c
            public final void fs(View view) {
                AppMethodBeat.i(163083);
                SnsCommentDetailUI.this.EoR.fn(view);
                SnsCommentDetailUI.this.EoT.fcl();
                AppMethodBeat.o(163083);
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.c
            public final void ffx() {
                AppMethodBeat.i(163084);
                SnsCommentDetailUI.this.EoR.ffh();
                AppMethodBeat.o(163084);
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.c
            public final void ft(View view) {
                AppMethodBeat.i(163085);
                Intent intent = new Intent();
                intent.putExtra("result_finish", true);
                SnsCommentDetailUI.this.setResult(-1, intent);
                try {
                    if (view.getTag() != null) {
                        com.tencent.mm.plugin.sns.data.c cVar = (com.tencent.mm.plugin.sns.data.c) view.getTag();
                        SnsInfo aQm = aj.faO().aQm(cVar.dHp);
                        if (aQm == null || !aQm.isAd()) {
                            Log.e("MicroMsg.TimelineClickListener", "reportAdFeedBackDel: info is null or not ad");
                        } else {
                            int source = SnsCommentDetailUI.this.getSource();
                            Log.i("MicroMsg.TimelineClickListener", "source = ".concat(String.valueOf(source)));
                            com.tencent.mm.plugin.sns.data.i.a(2, cVar.ece, aQm.getAdInfo(source), aQm.getAdXml());
                        }
                    }
                } catch (Throwable th) {
                    Log.e("MicroMsg.TimelineClickListener", "reportAdFeedBackDel: " + th.toString());
                }
                if (!(view.getTag() == null || this.EBv == null)) {
                    com.tencent.mm.plugin.sns.data.c cVar2 = (com.tencent.mm.plugin.sns.data.c) view.getTag();
                    this.EBv.a(cVar2.position, cVar2.dHp, cVar2.ece, 2);
                }
                SnsCommentDetailUI.this.finish();
                AppMethodBeat.o(163085);
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.c
            public final void ffy() {
                AppMethodBeat.i(203503);
                Intent intent = new Intent();
                intent.putExtra("result_finish", true);
                SnsCommentDetailUI.this.setResult(-1, intent);
                SnsCommentDetailUI.this.finish();
                AppMethodBeat.o(203503);
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.c
            public final void fu(View view) {
                AppMethodBeat.i(163086);
                SnsCommentDetailUI.this.EoR.fcl();
                SnsCommentDetailUI.this.EoT.v(view, false);
                AppMethodBeat.o(163086);
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.c
            public final void ffz() {
                AppMethodBeat.i(163087);
                SnsCommentDetailUI.this.EoT.fcl();
                SnsCommentDetailUI.this.finish();
                AppMethodBeat.o(163087);
            }
        };
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.in6);
        this.EoS = new com.tencent.mm.plugin.sns.h.b(this, this.Dyw, frameLayout);
        this.EoR = new b(this, this.Dyw, frameLayout, this.EoS);
        this.EoT = new ap(this, this.Dyw, frameLayout);
        this.EoU = new bu(this, this.Dyw, frameLayout);
        this.Dyw.ebz();
        this.EBA = getIntent().getBooleanExtra("intent_show_collapse_info", false);
        this.EBB = getIntent().getStringExtra("intent_content_collapse_hint");
        this.EBo = new br(this, new br.a() {
            /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.sns.ui.br.a
            public final void dWI() {
                AppMethodBeat.i(163088);
                SnsCommentDetailUI.q(SnsCommentDetailUI.this);
                SnsCommentDetailUI.r(SnsCommentDetailUI.this);
                AppMethodBeat.o(163088);
            }
        }, getSource(), this.EBL);
        long currentTimeMillis = System.currentTimeMillis();
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("INTENT_SNS_TIMELINEOBJECT");
        if (byteArrayExtra != null) {
            TimeLineObject timeLineObject = new TimeLineObject();
            try {
                timeLineObject.parseFrom(byteArrayExtra);
                if (aj.faO().JJ(new BigInteger(timeLineObject.Id).longValue()) == null) {
                    Log.i("MicroMsg.SnsCommentDetailUI", "info is null, can insert to sns info");
                    SnsInfo snsInfo = new SnsInfo();
                    snsInfo.field_snsId = new BigInteger(timeLineObject.Id).longValue();
                    try {
                        snsInfo.field_content = timeLineObject.toByteArray();
                    } catch (Exception e2) {
                    }
                    snsInfo.field_createTime = timeLineObject.CreateTime;
                    snsInfo.field_userName = timeLineObject.UserName;
                    snsInfo.field_type = timeLineObject.ContentObj.LoU;
                    snsInfo.setExtFlag();
                    SnsObject snsObject = new SnsObject();
                    snsObject.ObjectDesc = new SKBuiltinBuffer_t();
                    try {
                        snsInfo.field_attrBuf = snsObject.toByteArray();
                    } catch (IOException e3) {
                    }
                    aj.faO().insert(snsInfo);
                    Log.i("MicroMsg.FTS.SnsComment", "insert sns obj use time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                } else {
                    Log.i("MicroMsg.SnsCommentDetailUI", "info is not null, can not insert to sns info");
                }
            } catch (IOException e4) {
            }
        }
        final SnsInfo vs = vs(true);
        Log.i("MicroMsg.SnsCommentDetailUI", "onCreate()  snsId : " + this.dRS + " localSnsId: " + this.EBf);
        if (vs != null) {
            Log.i("MicroMsg.SnsCommentDetailUI", "commentdetail %s", Util.nullAs(vs.getUserName(), ""));
        }
        if (y.aQJ(this.dRS)) {
            if (!y.aNz(this.dRS)) {
                g.aAi();
                g.aAg().hqi.a(new m(y.aOa(this.dRS), 0, g(vs).adInfoSyncBuffer), 0);
            } else if (vs == null) {
                g.aAi();
                g.aAg().hqi.a(new com.tencent.mm.plugin.sns.model.r(y.aOa(this.dRS)), 0);
            } else if (!ab.IR(vs.getUserName())) {
                g.aAi();
                g.aAg().hqi.a(new com.tencent.mm.plugin.sns.model.r(y.aOa(this.dRS)), 0);
            }
        }
        g.aAi();
        g.aAg().hqi.a(210, this);
        g.aAi();
        g.aAg().hqi.a(218, this);
        g.aAi();
        g.aAg().hqi.a(213, this);
        g.aAi();
        g.aAg().hqi.a(com.tencent.mm.plugin.appbrand.jsapi.pay.k.CTRL_INDEX, this);
        g.aAi();
        g.aAg().hqi.a(214, this);
        g.aAi();
        g.aAg().hqi.a(683, this);
        this.EBg = aj.faC();
        this.EoL = new bb(this);
        this.EBe = new be(getContext());
        this.EBk = new j(this, getSource(), this.EBL);
        this.EBl = new l(this);
        if (vs != null) {
            this.qcr = bk.g(vs, false);
            com.tencent.mm.plugin.sns.k.e.DUQ.DVp = System.currentTimeMillis();
            com.tencent.mm.plugin.sns.k.e eVar = com.tencent.mm.plugin.sns.k.e.DUQ;
            if (vs != null) {
                String Jc = r.Jc(vs.field_snsId);
                if (!eVar.DVj.contains(Jc)) {
                    eVar.DVj.add(Jc);
                }
            }
            com.tencent.mm.plugin.sns.k.e.DUQ.DVw = System.currentTimeMillis();
        }
        if (vs != null && vs.isAd()) {
            if (this.EBD == 16) {
                this.EBv = new k(2);
            } else {
                this.EBv = new k(1);
            }
            this.EBv.a(this.mScreenHeight, getSupportActionBar().getCustomView(), this);
            bk.g(vs, false);
            this.Dyw.c(this.EBv);
            this.EoR.DzW = this.EBv;
        }
        initView();
        if (vs != null && vs.isAd()) {
            this.EBv.a(0, vs.getLocalid(), vs.isExposures(), this.EAP, vs.field_snsId, an.B(vs), this.qcr, 2);
        }
        if (!(this.EAP == null || vs == null)) {
            com.tencent.mm.plugin.sight.decode.a.a aVar2 = (com.tencent.mm.plugin.sight.decode.a.a) this.EAP.findViewById(R.id.dup);
            if (vs.getTimeLine().ContentObj == null || vs.getTimeLine().ContentObj.LoU != 15 || !(aVar2 instanceof SightPlayImageView)) {
                z = false;
            } else {
                z = ((SightPlayImageView) aVar2).Dnr.eVy();
            }
            o.a(vs, true, z, getSource());
        }
        if (this.EAT == null) {
            AppMethodBeat.o(98595);
            return;
        }
        this.EAT.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass6 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(163089);
                if (SnsCommentDetailUI.this.EoR != null) {
                    SnsCommentDetailUI.this.EoR.fcl();
                }
                AppMethodBeat.o(163089);
                return false;
            }
        });
        this.EBG = new n(this);
        if (vs != null && Util.isEqual(this.gna, vs.getUserName())) {
            addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass7 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(163090);
                    try {
                        SnsInfo aQm = aj.faO().aQm(vs.getLocalid());
                        n nVar = SnsCommentDetailUI.this.EBG;
                        boolean isEqual = Util.isEqual(SnsCommentDetailUI.this.gna, vs.getUserName());
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        if (isEqual && aQm != null) {
                            if (aQm.getLocalPrivate() <= 0) {
                                arrayList.add(nVar.mContext.getString(R.string.h_g));
                                arrayList2.add(0);
                            } else if (!Util.isNullOrNil(aj.fau()) && aj.fau().equals(aQm.getUserName())) {
                                arrayList.add(nVar.mContext.getString(R.string.h_f));
                                arrayList2.add(1);
                            }
                            if (arrayList.size() != 0) {
                                nVar.Epy = new com.tencent.mm.ui.widget.a.e(nVar.mContext, 1, false);
                                nVar.Epy.HLX = new o.f(arrayList, arrayList2) {
                                    /* class com.tencent.mm.plugin.sns.ui.n.AnonymousClass1 */
                                    final /* synthetic */ List Epz;
                                    final /* synthetic */ List kmw;

                                    {
                                        this.kmw = r2;
                                        this.Epz = r3;
                                    }

                                    @Override // com.tencent.mm.ui.base.o.f
                                    public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                                        AppMethodBeat.i(97846);
                                        n.this.Epy.setFooterView(null);
                                        mVar.clear();
                                        for (int i2 = 0; i2 < this.kmw.size(); i2++) {
                                            mVar.d(((Integer) this.Epz.get(i2)).intValue(), (CharSequence) this.kmw.get(i2));
                                        }
                                        AppMethodBeat.o(97846);
                                    }
                                };
                                nVar.Epy.HLY = new o.g(aQm) {
                                    /* class com.tencent.mm.plugin.sns.ui.n.AnonymousClass2 */
                                    final /* synthetic */ SnsInfo EpB;

                                    {
                                        this.EpB = r2;
                                    }

                                    @Override // com.tencent.mm.ui.base.o.g
                                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                                        AppMethodBeat.i(97847);
                                        int itemId = menuItem.getItemId();
                                        Log.d("MiscroMsg.CommentDetailMenuManager", "showAlert ".concat(String.valueOf(itemId)));
                                        switch (itemId) {
                                            case 1:
                                                n nVar = n.this;
                                                s sVar = new s(this.EpB.field_snsId, 3);
                                                g.aAi();
                                                g.aAg().hqi.a(sVar, 0);
                                                Context context = nVar.mContext;
                                                nVar.mContext.getString(R.string.zb);
                                                nVar.tipDialog = com.tencent.mm.ui.base.h.a(context, nVar.mContext.getString(R.string.h_c), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener(sVar) {
                                                    /* class com.tencent.mm.plugin.sns.ui.n.AnonymousClass4 */
                                                    final /* synthetic */ s EpD;

                                                    {
                                                        this.EpD = r2;
                                                    }

                                                    public final void onCancel(DialogInterface dialogInterface) {
                                                        AppMethodBeat.i(97849);
                                                        g.aAi();
                                                        g.aAg().hqi.a(this.EpD);
                                                        AppMethodBeat.o(97849);
                                                    }
                                                });
                                                AppMethodBeat.o(97847);
                                                return;
                                            case 0:
                                                n nVar2 = n.this;
                                                SnsInfo snsInfo = this.EpB;
                                                if (!snsInfo.isWaitPost() && !snsInfo.isDieItem()) {
                                                    s sVar2 = new s(snsInfo.field_snsId, 2);
                                                    g.aAi();
                                                    g.aAg().hqi.a(sVar2, 0);
                                                    Context context2 = nVar2.mContext;
                                                    nVar2.mContext.getString(R.string.zb);
                                                    nVar2.tipDialog = com.tencent.mm.ui.base.h.a(context2, nVar2.mContext.getString(R.string.h_c), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener(sVar2) {
                                                        /* class com.tencent.mm.plugin.sns.ui.n.AnonymousClass3 */
                                                        final /* synthetic */ s EpC;

                                                        {
                                                            this.EpC = r2;
                                                        }

                                                        public final void onCancel(DialogInterface dialogInterface) {
                                                            AppMethodBeat.i(97848);
                                                            g.aAi();
                                                            g.aAg().hqi.a(this.EpC);
                                                            AppMethodBeat.o(97848);
                                                        }
                                                    });
                                                    break;
                                                } else {
                                                    aj.faO().Zs(snsInfo.localid);
                                                    AppMethodBeat.o(97847);
                                                    return;
                                                }
                                                break;
                                        }
                                        AppMethodBeat.o(97847);
                                    }
                                };
                                nVar.Epy.dGm();
                            }
                        }
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.SnsCommentDetailUI", e2, "", new Object[0]);
                    }
                    AppMethodBeat.o(163090);
                    return true;
                }
            });
        }
        EventCenter.instance.addListener(this.lEl);
        EventCenter.instance.addListener(this.EBM);
        EventCenter.instance.addListener(this.EBN);
        EventCenter.instance.addListener(this.EBO);
        EventCenter.instance.addListener(this.EBP);
        EventCenter.instance.addListener(this.EBU);
        EventCenter.instance.addListener(this.EBV);
        EventCenter.instance.addListener(this.EoY);
        h.r(this);
        AppMethodBeat.o(98595);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(98596);
        aj.faE().a(this, 5);
        g.aAi();
        g.aAg().hqi.b(210, this);
        g.aAi();
        g.aAg().hqi.b(218, this);
        g.aAi();
        g.aAg().hqi.b(213, this);
        g.aAi();
        g.aAg().hqi.b(214, this);
        g.aAi();
        g.aAg().hqi.b(683, this);
        g.aAi();
        g.aAg().hqi.b(com.tencent.mm.plugin.appbrand.jsapi.pay.k.CTRL_INDEX, this);
        aj.faL().aI(this);
        EventCenter.instance.removeListener(this.lEl);
        if (this.EBk != null) {
            this.EBk.activity = null;
        }
        af.ffX();
        if (this.EoJ != null) {
            this.EoJ.fib();
        }
        SnsInfo vs = vs(false);
        if (vs != null && vs.isAd()) {
            if (this.EBv != null) {
                this.EBv.a(0, vs.getLocalid(), vs.field_snsId, 2);
            }
            ADInfo g2 = g(vs);
            String str = g2 == null ? "" : g2.uxInfo;
            if (vs.isRecExpAd()) {
                aj.faI().a(14652, j.a(vs.field_snsId, r.Jb(vs.field_snsId), str, Long.valueOf(this.EAN), Long.valueOf(System.currentTimeMillis())));
            } else {
                aj.faI().a(12012, j.a(vs.field_snsId, r.Jb(vs.field_snsId), str, Long.valueOf(this.EAN), Long.valueOf(System.currentTimeMillis())));
            }
            com.tencent.mm.modelsns.k tP = com.tencent.mm.modelsns.k.tP(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION);
            tP.PH(r.Jb(vs.field_snsId)).PH(str).PH(new StringBuilder().append(this.EAN).toString()).PH(new StringBuilder().append(System.currentTimeMillis()).toString());
            tP.bfK();
        }
        this.Dyw.removeListener();
        EventCenter.instance.removeListener(this.EBM);
        EventCenter.instance.removeListener(this.EBN);
        EventCenter.instance.removeListener(this.EBO);
        EventCenter.instance.removeListener(this.EBP);
        EventCenter.instance.removeListener(this.EBU);
        EventCenter.instance.removeListener(this.EBV);
        EventCenter.instance.removeListener(this.EoY);
        super.onDestroy();
        com.tencent.mm.plugin.sns.k.e eVar = com.tencent.mm.plugin.sns.k.e.DUQ;
        if (eVar.DVp != 0) {
            eVar.DVq += System.currentTimeMillis() - eVar.DVp;
            eVar.DVp = 0;
        }
        com.tencent.mm.plugin.sns.k.e eVar2 = com.tencent.mm.plugin.sns.k.e.DUQ;
        if (eVar2.DVw != 0) {
            eVar2.DVx += System.currentTimeMillis() - eVar2.DVw;
            eVar2.DVw = 0;
        }
        if (!(!this.EBE || vs == null || vs.getTimeLine() == null || vs.getTimeLine().ContentObj == null)) {
            ih fcy = com.tencent.mm.plugin.sns.k.e.DUQ.fcy();
            fcy.eDV = com.tencent.mm.plugin.sns.k.e.DUQ.DVe.eDV;
            fcy.we(com.tencent.mm.plugin.sns.k.e.DUQ.DVe.ePK).wf(r.Jc(vs.field_snsId)).erx = (long) vs.getTimeLine().ContentObj.LoU;
            com.tencent.mm.plugin.sns.k.e.DUQ.fcD();
        }
        if (this.EBK != null) {
            this.EBK.destroy();
        }
        AppMethodBeat.o(98596);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(203538);
        AppMethodBeat.at(this, z);
        super.onWindowFocusChanged(z);
        Log.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "hasFocus = ".concat(String.valueOf(z)));
        if (!z) {
            try {
                ScreenShotUtil.setScreenShotCallback(this, null);
                this.ExJ = false;
                AppMethodBeat.o(203538);
            } catch (Throwable th) {
                Log.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "hasFocus = ".concat(String.valueOf(z)));
                Log.e("MicroMsg.SnsCommentDetailUI.ScreenShot", th.toString());
                AppMethodBeat.o(203538);
            }
        } else {
            if (!this.ExJ) {
                Log.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "onWindowFocusChanged callback");
                ScreenShotUtil.setScreenShotCallback(this, this.EyL);
                this.ExJ = true;
            }
            AppMethodBeat.o(203538);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(98597);
        try {
            if (!this.ExJ) {
                Log.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "onResume callback");
                ScreenShotUtil.setScreenShotCallback(this, this.EyL);
                this.ExJ = true;
            }
        } catch (Throwable th) {
            Log.e("MicroMsg.SnsCommentDetailUI.ScreenShot", th.toString());
        }
        aj.faJ().a(this);
        yh yhVar = new yh();
        yhVar.eeC.eeD = 0;
        yhVar.eeC.eeE = 1;
        yhVar.eeC.eeF = 0;
        yhVar.eeC.type = 0;
        EventCenter.instance.publish(yhVar);
        if (this.EBv != null) {
            this.EBv.onResume();
        }
        if (this.EBu != null) {
            this.EBu.refreshView();
        }
        super.onResume();
        try {
            if (this.EBz && this.EAP != null) {
                Log.i("MicroMsg.SnsCommentDetailUI", "new video vie resumeNormalVideoAd called");
                SnsAdTimelineVideoView snsAdTimelineVideoView = (SnsAdTimelineVideoView) this.EAP.findViewById(R.id.fxe);
                if (a(vs(false), snsAdTimelineVideoView)) {
                    com.tencent.mm.plugin.sns.ad.timeline.b.f.b(snsAdTimelineVideoView);
                    Log.i("MicroMsg.SnsCommentDetailUI", "new video vie resumeNormalVideoAd");
                }
            }
            AppMethodBeat.o(98597);
        } catch (Throwable th2) {
            Log.e("MicroMsg.SnsCommentDetailUI", "resumeNormalVideoAd, exp=" + th2.toString());
            AppMethodBeat.o(98597);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        SnsInfo vs;
        AppMethodBeat.i(98598);
        aj.faJ().b(this);
        try {
            ScreenShotUtil.setScreenShotCallback(this, null);
            this.ExJ = false;
        } catch (Throwable th) {
            Log.e("MicroMsg.SnsCommentDetailUI.ScreenShot", th.toString());
        }
        super.onPause();
        this.EoJ.gte.hideVKB();
        SnsCommentFooter snsCommentFooter = this.EoJ;
        if (snsCommentFooter.rum != null) {
            snsCommentFooter.rum.onPause();
        }
        snsCommentFooter.ECK.onPause();
        new yh().eeC.type = 1;
        try {
            if (this.EBz && this.EAP != null && (vs = vs(false)) != null && vs.isAd()) {
                VideoSightView videoSightView = (VideoSightView) this.EAP.findViewById(R.id.dup);
                SnsAdTimelineVideoView snsAdTimelineVideoView = (SnsAdTimelineVideoView) this.EAP.findViewById(R.id.fxe);
                if (a(vs, snsAdTimelineVideoView)) {
                    if (snsAdTimelineVideoView.isPlaying() && snsAdTimelineVideoView.getVisibility() == 0) {
                        Log.i("MicroMsg.SnsCommentDetailUI", "new video vie pauseNormalVideoAd");
                        com.tencent.mm.plugin.sns.ad.timeline.b.f.c(snsAdTimelineVideoView);
                    }
                } else if (videoSightView.isPlaying() && videoSightView.getVisibility() == 0) {
                    Log.i("MicroMsg.SnsCommentDetailUI", "pauseNormalVideoAd");
                    videoSightView.pause();
                }
            }
        } catch (Throwable th2) {
            Log.e("MicroMsg.SnsCommentDetailUI", "pauseNormalVideoAd, exp=" + th2.toString());
        }
        if (this.EBv != null) {
            this.EBv.onPause();
            SnsInfo vs2 = vs(false);
            if (vs2 != null && vs2.isAd()) {
                this.EBv.IU(vs2.field_snsId);
            }
        }
        if (this.EBu != null) {
            this.EBu.onPause();
        }
        AppMethodBeat.o(98598);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bvi;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z;
        String str;
        int i2;
        AppMethodBeat.i(98599);
        setMMTitle(R.string.h5i);
        setToTop(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass20 */

            public final void onClick(View view) {
                AppMethodBeat.i(203513);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(SnsCommentDetailUI.this.EAT);
                Object obj = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$27", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$27", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203513);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass21 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(203514);
                if (SnsCommentDetailUI.this.EoJ != null) {
                    SnsCommentDetailUI.this.EoJ.vt(false);
                }
                SnsCommentDetailUI.this.finish();
                AppMethodBeat.o(203514);
                return true;
            }
        });
        this.gna = z.aTY();
        if (aj.isInValid()) {
            finish();
        }
        final SnsInfo vs = vs(true);
        if (vs == null) {
            Log.e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.dRS);
            finish();
            AppMethodBeat.o(98599);
            return;
        }
        Log.i("MicroMsg.SnsCommentDetailUI", "snsId: " + this.dRS + "localId " + this.EBf + "  username:" + vs.getUserName());
        TextView textView = (TextView) findViewById(R.id.bel);
        if (this.EBA) {
            textView.setVisibility(0);
            textView.setText(this.EBB);
        } else {
            textView.setVisibility(8);
        }
        if (!y.aQJ(this.dRS) && vs.isDieItem()) {
            cnc postInfo = vs.getPostInfo();
            findViewById(R.id.hzs).setVisibility(0);
            TextView textView2 = (TextView) findViewById(R.id.gf9);
            switch (postInfo.Mtd) {
                case 201:
                    if (!Util.isNullOrNil(postInfo.Mtk)) {
                        textView2.setText(postInfo.Mtk);
                    } else {
                        textView2.setText(R.string.h9l);
                    }
                    findViewById(R.id.hzt).setVisibility(8);
                    z = false;
                    break;
                case 210:
                    if (!Util.isNullOrNil(postInfo.Mtk)) {
                        textView2.setText(postInfo.Mtk);
                    } else {
                        textView2.setText(R.string.h9n);
                    }
                    findViewById(R.id.hzt).setVisibility(8);
                    z = false;
                    break;
                case 211:
                    if (!Util.isNullOrNil(postInfo.Mtk)) {
                        textView2.setText(postInfo.Mtk);
                    } else {
                        textView2.setText(R.string.h9m);
                    }
                    findViewById(R.id.hzt).setVisibility(8);
                    z = true;
                    break;
                default:
                    if (Util.isNullOrNil(postInfo.Mtk)) {
                        if (vs.getTypeFlag() != 28) {
                            textView2.setText(R.string.h9o);
                            findViewById(R.id.hzt).setVisibility(0);
                            z = true;
                            break;
                        } else {
                            textView2.setText(R.string.h9p);
                            findViewById(R.id.hzt).setVisibility(8);
                            z = false;
                            break;
                        }
                    } else {
                        textView2.setText(postInfo.Mtk);
                        findViewById(R.id.hzt).setVisibility(0);
                        z = true;
                        break;
                    }
            }
        } else {
            findViewById(R.id.hzs).setVisibility(8);
            z = false;
        }
        if (z) {
            findViewById(R.id.hzs).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass13 */

                public final void onClick(View view) {
                    AppMethodBeat.i(203505);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (vs.isAd()) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(203505);
                        return;
                    }
                    an.YD(vs.localid);
                    an.YB(vs.localid);
                    aj.faK().eZn();
                    Intent intent = new Intent();
                    SnsCommentDetailUI.this.setResult(-1, intent);
                    if (SnsCommentDetailUI.this.mci) {
                        intent.putExtra("sns_gallery_force_finish", true);
                    }
                    SnsCommentDetailUI.this.finish();
                    SnsCommentDetailUI.this.finish();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(203505);
                }
            });
        }
        this.EAT = (ListView) findViewById(R.id.jh);
        this.EAT.post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass14 */

            public final void run() {
                AppMethodBeat.i(203506);
                SnsCommentDetailUI.this.EBc = SnsCommentDetailUI.this.EAT.getBottom();
                Log.d("MicroMsg.SnsCommentDetailUI", "listOriginalBottom: " + SnsCommentDetailUI.this.EBc);
                AppMethodBeat.o(203506);
            }
        });
        this.EAT.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass15 */

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                AppMethodBeat.i(203507);
                if (i3 > 0) {
                    if (i2 == 0 && !SnsCommentDetailUI.this.EBC) {
                        SnsCommentDetailUI.this.EBC = true;
                        if (SnsCommentDetailUI.this.EBu != null) {
                            SnsCommentDetailUI.this.EBu.refreshView();
                            AppMethodBeat.o(203507);
                            return;
                        } else if (SnsCommentDetailUI.this.EAP != null) {
                            SnsCommentDetailUI.this.fhP();
                            AppMethodBeat.o(203507);
                            return;
                        }
                    } else if (i2 > 0) {
                        SnsCommentDetailUI.this.EBC = false;
                    }
                }
                AppMethodBeat.o(203507);
            }

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
                AppMethodBeat.i(203508);
                if (i2 == 1) {
                    SnsCommentDetailUI.this.hideVKB();
                    SnsCommentDetailUI.z(SnsCommentDetailUI.this);
                }
                if (i2 == 0 && SnsCommentDetailUI.this.EBv != null) {
                    SnsCommentDetailUI.this.EBv.uM(true);
                }
                AppMethodBeat.o(203508);
            }
        });
        SnsInfo vs2 = vs(false);
        this.EAP = aa.jQ(getContext()).inflate(R.layout.bvj, (ViewGroup) null);
        this.EAV = this.EAP.findViewById(R.id.dwv);
        this.EAP.setOnClickListener(this.EBT);
        if (vs2 == null || !vs2.isAd() || !vs2.isLongPressGestureAd()) {
            this.EAT.addHeaderView(this.EAP);
        } else {
            this.EBJ = (FrameLayout) aa.jQ(getContext()).inflate(R.layout.bu4, (ViewGroup) null);
            this.EBJ.addView(this.EAP, 0);
            this.EAT.addHeaderView(this.EBJ);
        }
        boolean fhP = fhP();
        if (!fhP) {
            Log.i("MicroMsg.SnsCommentDetailUI", "error isOk setheader ".concat(String.valueOf(fhP)));
            finish();
            AppMethodBeat.o(98599);
            return;
        }
        if (vs2 != null) {
            this.qcr = bk.g(vs2, false);
        }
        if (this.qcr == 10 && z.aTY().equals(vs.field_userName)) {
            this.EAS = new SnsDetailLuckyHeader(this);
            this.EAS.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.EAS.setOnClickListener(this.EBT);
        }
        this.EAR = new LinearLayout(getContext());
        this.EAR.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        this.EAR.setOnClickListener(this.EBT);
        BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 2.0f);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, 1);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundResource(R.drawable.av_);
        linearLayout.setLayoutParams(layoutParams);
        this.DGk = linearLayout;
        f(vs, true);
        if (this.EAS != null) {
            this.EBx = true;
            this.EAT.addHeaderView(this.EAS);
        }
        SnsObject B = an.B(vs);
        if (B == null) {
            this.EAR.setVisibility(8);
            this.EAW = new b(new LinkedList(), new LinkedList(), this, vs.getLocalid());
        } else {
            this.EBb = B.LikeUserList;
            n(B.LikeUserList, B.CommentUserList.isEmpty());
            if (this.EAS != null) {
                this.EAS.a(vs, this.Dyw);
            }
            this.EAW = new b(B.CommentUserList, B.LikeUserList, this, vs.getLocalid());
            if (this.EBE) {
                com.tencent.mm.plugin.sns.k.e.DUQ.fcy().eOy = (long) B.CommentUserList.size();
                com.tencent.mm.plugin.sns.k.e.DUQ.fcy().eOz = (long) B.LikeUserList.size();
            }
        }
        this.EAT.addHeaderView(this.EAR);
        this.EAT.setAdapter((ListAdapter) this.EAW);
        this.EoJ = (SnsCommentFooter) findViewById(R.id.b8y);
        if (vs == null || vs.getTimeLine() == null || vs.getTimeLine().ContentObj == null || (vs.getTimeLine().ContentObj.LoW & 128) != 0) {
            this.EoJ.setFeedEmojiCommentEnable(false);
        } else {
            this.EoJ.setFeedEmojiCommentEnable(true);
        }
        this.EoJ.setTag(vs);
        this.EoJ.setOnEditTouchListener(new SnsCommentFooter.a() {
            /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass16 */

            @Override // com.tencent.mm.plugin.sns.ui.SnsCommentFooter.a
            public final void fhU() {
                AppMethodBeat.i(203509);
                if (!com.tencent.mm.plugin.sns.lucky.a.m.aOH(vs.getLocalid())) {
                    if (SnsCommentDetailUI.this.EBy == null || !SnsCommentDetailUI.this.EBy.isShowing()) {
                        SnsCommentDetailUI.this.EBy = com.tencent.mm.plugin.sns.lucky.ui.a.f(SnsCommentDetailUI.this.getContext(), SnsCommentDetailUI.this.EBZ.ZD(0));
                        AppMethodBeat.o(203509);
                        return;
                    }
                    AppMethodBeat.o(203509);
                } else if (SnsCommentDetailUI.this.keyboardState() == 1 || SnsCommentDetailUI.this.EoJ.fhW()) {
                    AppMethodBeat.o(203509);
                } else {
                    SnsCommentDetailUI.B(SnsCommentDetailUI.this);
                    AppMethodBeat.o(203509);
                }
            }
        });
        this.EoJ.setOnSmileyShowListener(new SnsCommentFooter.c() {
            /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass17 */

            @Override // com.tencent.mm.plugin.sns.ui.SnsCommentFooter.c
            public final void onShow() {
                AppMethodBeat.i(203510);
                if (SnsCommentDetailUI.this.EoJ.ECW) {
                    AppMethodBeat.o(203510);
                    return;
                }
                SnsCommentDetailUI.B(SnsCommentDetailUI.this);
                AppMethodBeat.o(203510);
            }
        });
        SnsInfo vs3 = vs(true);
        if (vs3 != null && !vs3.isExtFlag()) {
            this.EoJ.setVisibility(8);
        }
        this.EoJ.setAfterEditAction(this.EBS);
        this.EoJ.fhX();
        this.EoJ.setOnCommentSendImp(new SnsCommentFooter.b() {
            /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass18 */

            @Override // com.tencent.mm.plugin.sns.ui.SnsCommentFooter.b
            public final void kP(String str, String str2) {
                int i2;
                int i3 = 8;
                AppMethodBeat.i(203511);
                if (!com.tencent.mm.plugin.sns.lucky.a.m.aOH(vs.getLocalid())) {
                    if (SnsCommentDetailUI.this.EBZ.ZD(0) != null) {
                        com.tencent.mm.plugin.sns.lucky.ui.a.f(SnsCommentDetailUI.this.getContext(), SnsCommentDetailUI.this.EBZ.ZD(0));
                    }
                    AppMethodBeat.o(203511);
                    return;
                }
                if (vs.isAd()) {
                    i2 = SnsCommentDetailUI.this.EoJ.getCommentFlag();
                } else {
                    i2 = 0;
                }
                if (com.tencent.mm.plugin.sns.ui.widget.e.iY(i2, 8)) {
                    String substring = str.substring(SnsCommentDetailUI.this.EoJ.getCommentAtPrefix().length());
                    Log.i("MicroMsg.SnsCommentDetailUI", "send atFriend ad detail comment");
                    aq.a.a(vs, 16, substring, SnsCommentDetailUI.this.EoJ.getCommentInfo(), i2, SnsCommentDetailUI.this.getSource(), str2);
                } else {
                    Log.i("MicroMsg.SnsCommentDetailUI", "send detail comment");
                    SnsInfo snsInfo = vs;
                    if (!vs.isAd()) {
                        i3 = 2;
                    }
                    aq.a.a(snsInfo, i3, str, SnsCommentDetailUI.this.EoJ.getCommentInfo(), i2, SnsCommentDetailUI.this.getSource(), str2);
                }
                SnsCommentDetailUI.this.EoJ.setText("");
                SnsCommentDetailUI.this.EoJ.vt(false);
                Log.i("MicroMsg.SnsCommentDetailUI", "comment send imp!");
                com.tencent.mm.plugin.sns.k.e.DUQ.fcy().eOA = 3;
                SnsCommentDetailUI.z(SnsCommentDetailUI.this);
                AppMethodBeat.o(203511);
            }
        });
        this.EBm = getIntent().getBooleanExtra("INTENT_FROMSUI", false);
        if (this.EBm) {
            this.EBn = getIntent().getLongExtra("INTENT_FROMSUI_COMMENTID", 0);
            if (!(this.EBn == 0 || this.EAW.commentList == null)) {
                int i3 = 0;
                while (true) {
                    if (i3 < this.EAW.commentList.size()) {
                        dzo dzo = this.EAW.commentList.get(i3);
                        if ((dzo.MYT != 0 ? (long) dzo.MYT : dzo.MYV) == this.EBn) {
                            this.EAT.setSelection(i3);
                            as Kn = this.EBg.Kn(dzo.Username);
                            if (Kn != null) {
                                str = Kn.arJ();
                            } else {
                                str = dzo.Nickname != null ? dzo.Nickname : dzo.Username;
                            }
                            this.EoJ.ECO = 0;
                            this.EoJ.fhY();
                            this.EoJ.setCommentHint(getString(R.string.h9y) + str);
                            this.EoJ.setCommentInfo(dzo);
                            if (B.LikeUserList.size() > 0) {
                                i2 = i3 + 1;
                                if (i2 > this.EAW.getCount()) {
                                    i2 = this.EAW.getCount() - 1;
                                }
                            } else {
                                i2 = i3;
                            }
                            this.EBS.UZ = i2;
                        } else {
                            i3++;
                        }
                    }
                }
            }
        }
        if (this.EBm) {
            new MMHandler().postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass19 */

                public final void run() {
                    AppMethodBeat.i(203512);
                    SnsCommentDetailUI.this.hideVKB();
                    SnsCommentDetailUI.this.EBS.kn = SnsCommentDetailUI.C(SnsCommentDetailUI.this);
                    SnsCommentDetailUI.this.EBS.run();
                    AppMethodBeat.o(203512);
                }
            }, 100);
        }
        this.EBw = (SnsTranslateResultView) this.EAP.findViewById(R.id.i1c);
        this.EBw.setResultTextSize(((TextView) this.EAP.findViewById(R.id.bn6)).getTextSize());
        this.EBw.getResultTextView().setBackgroundResource(R.drawable.auv);
        this.EBw.getResultTextView().setTag(new bg(this.dRS, vs.getLocalid(), false, true, 2));
        this.pqr.c(this.EBw.getResultTextView(), this.Dyw.Fau, this.Dyw.Far);
        if (au.fC(this.dRS, 4)) {
            au.b aPp = au.aPp(this.dRS);
            if (aPp == null || !aPp.iGD) {
                this.EBw.setVisibility(8);
                AppMethodBeat.o(98599);
                return;
            }
            this.EBw.setVisibility(0);
            this.EBw.a(null, 1, aPp.result, aPp.brand, false);
            AppMethodBeat.o(98599);
            return;
        }
        this.EBw.setVisibility(8);
        AppMethodBeat.o(98599);
    }

    private int fhN() {
        View childAt;
        AppMethodBeat.i(98600);
        if (this.EAT == null || this.EAT.getChildCount() <= 1 || (childAt = this.EAT.getChildAt(0)) == null) {
            AppMethodBeat.o(98600);
            return 0;
        }
        int height = childAt.getHeight();
        AppMethodBeat.o(98600);
        return height;
    }

    private LinearLayout ZH(int i2) {
        AppMethodBeat.i(98601);
        if (this.EBX == null) {
            this.EBX = (LinearLayout) aa.jQ(this).inflate(i2, (ViewGroup) null);
            LinearLayout linearLayout = this.EBX;
            AppMethodBeat.o(98601);
            return linearLayout;
        }
        this.EBW = true;
        LinearLayout linearLayout2 = this.EBX;
        AppMethodBeat.o(98601);
        return linearLayout2;
    }

    private static boolean fhO() {
        AppMethodBeat.i(98602);
        if ((aq.a.fbx() & 1) <= 0) {
            AppMethodBeat.o(98602);
            return true;
        }
        AppMethodBeat.o(98602);
        return false;
    }

    private void f(SnsInfo snsInfo, boolean z) {
        AppMethodBeat.i(98603);
        if (this.EBH == null) {
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, -2);
            this.EBH = new TextView(this);
            this.EBH.setLayoutParams(layoutParams);
            this.EBH.setText(getString(R.string.h5p));
            this.EBH.setTextColor(getResources().getColor(R.color.a2x));
            this.EBH.setGravity(17);
            this.EBH.setPadding(0, BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 7.0f), 0, BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 12.0f));
            this.EBH.setVisibility(8);
            this.EAT.addFooterView(this.EBH);
        }
        if (snsInfo != null) {
            if ((snsInfo.getLocalPrivate() & 1) != 0) {
                findViewById(R.id.b8y).setVisibility(8);
                TimeLineObject timeLine = snsInfo.getTimeLine();
                if (timeLine != null) {
                    switch (timeLine.ContentObj.LoU) {
                        case 1:
                            this.EBH.setText(getString(R.string.h5q));
                            break;
                        case 2:
                            this.EBH.setText(getString(R.string.h5r));
                            break;
                        case 15:
                            this.EBH.setText(getString(R.string.h5s));
                            break;
                    }
                }
                this.EBH.setVisibility(0);
                AppMethodBeat.o(98603);
                return;
            }
            if (z) {
                findViewById(R.id.b8y).setVisibility(0);
            }
            this.EBH.setVisibility(8);
        }
        AppMethodBeat.o(98603);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x10f7  */
    /* JADX WARNING: Removed duplicated region for block: B:350:0x11ad  */
    /* JADX WARNING: Removed duplicated region for block: B:361:0x11fe  */
    /* JADX WARNING: Removed duplicated region for block: B:366:0x1227  */
    /* JADX WARNING: Removed duplicated region for block: B:369:0x124c  */
    /* JADX WARNING: Removed duplicated region for block: B:395:0x13c5  */
    /* JADX WARNING: Removed duplicated region for block: B:413:0x14c3  */
    @android.annotation.SuppressLint({"ResourceType"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean fhP() {
        /*
        // Method dump skipped, instructions count: 12568
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.fhP():boolean");
    }

    private void a(PhotosContent photosContent) {
        AppMethodBeat.i(203539);
        if (photosContent == null) {
            AppMethodBeat.o(203539);
            return;
        }
        try {
            ImageView imageView = new ImageView(getContext());
            int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 24);
            int fromDPToPix2 = com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 4);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(fromDPToPix, fromDPToPix);
            layoutParams.leftMargin = fromDPToPix2;
            layoutParams.topMargin = fromDPToPix2;
            imageView.setImageDrawable(com.tencent.mm.cb.a.l(getContext(), R.drawable.brd));
            imageView.setLayoutParams(layoutParams);
            photosContent.addView(imageView);
            AppMethodBeat.o(203539);
        } catch (Throwable th) {
            Log.e("MicroMsg.SnsCommentDetailUI", th.toString());
            AppMethodBeat.o(203539);
        }
    }

    private void a(PhotosContent photosContent, int i2) {
        AppMethodBeat.i(203540);
        if (photosContent == null || i2 <= 1) {
            Log.e("MicroMsg.SnsCommentDetailUI", "photosContent == null or imgNums <= 1");
            AppMethodBeat.o(203540);
            return;
        }
        try {
            int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 20);
            for (int i3 = 0; i3 < i2; i3++) {
                if (photosContent.ZD(i3).getVisibility() == 8) {
                    Log.i("MicroMsg.SnsCommentDetailUI", "current index " + i3 + " imageView is a placeholder, so visibility is gone");
                } else {
                    ImageView a2 = com.tencent.mm.plugin.sns.ad.timeline.b.c.a(getContext(), photosContent, i3, fromDPToPix);
                    if (a2 != null) {
                        photosContent.addView(a2);
                    }
                }
            }
            AppMethodBeat.o(203540);
        } catch (Throwable th) {
            Log.e("MicroMsg.SnsCommentDetailUI", th.toString());
            AppMethodBeat.o(203540);
        }
    }

    private void fhQ() {
        AppMethodBeat.i(98605);
        if (this.EAU == null || this.EAU.getVisibility() == 8) {
            AppMethodBeat.o(98605);
            return;
        }
        this.EAU.startAnimation(this.EAY);
        this.EAY.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass48 */

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(259459);
                Log.d("MicroMsg.SnsCommentDetailUI", "onAnimationEnd");
                if (SnsCommentDetailUI.this.EAU != null) {
                    SnsCommentDetailUI.this.EAU.clearAnimation();
                    SnsCommentDetailUI.this.EAU.setVisibility(8);
                }
                AppMethodBeat.o(259459);
            }
        });
        AppMethodBeat.o(98605);
    }

    private void fhR() {
        AppMethodBeat.i(98606);
        if (keyboardState() == 1 || this.EoJ.fhW()) {
            this.EBS.run();
            AppMethodBeat.o(98606);
            return;
        }
        this.EoG = true;
        AppMethodBeat.o(98606);
    }

    private void fhS() {
        AppMethodBeat.i(98607);
        if (this.EBi == null) {
            AppMethodBeat.o(98607);
            return;
        }
        this.EBi.setPressed(false);
        if (br.aMJ(this.dSF)) {
            this.EBi.setImageResource(R.drawable.alq);
            AppMethodBeat.o(98607);
            return;
        }
        this.EBi.setImageResource(R.drawable.am5);
        AppMethodBeat.o(98607);
    }

    @SuppressLint({"ResourceType"})
    private void fhT() {
        AppMethodBeat.i(203541);
        if (this.EBj == null) {
            AppMethodBeat.o(203541);
            return;
        }
        this.EBj.setPressed(false);
        if (br.aMJ(this.dSF)) {
            this.EBj.setImageResource(R.raw.icons_outlined_pause2);
        } else {
            this.EBj.setImageResource(R.raw.icons_outlined_play2);
        }
        this.EBj.setIconColor(getContext().getResources().getColor(R.color.fo));
        AppMethodBeat.o(203541);
    }

    private boolean n(List<dzo> list, boolean z) {
        AppMethodBeat.i(98608);
        int fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 32.0f);
        int fromDPToPix2 = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 6.0f);
        int fromDPToPix3 = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 10.0f);
        int fromDPToPix4 = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 17.0f);
        if (this.EAR == null) {
            AppMethodBeat.o(98608);
            return false;
        }
        int width = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        float dimension = getResources().getDimension(R.dimen.ir);
        Log.d("MicroMsg.SnsCommentDetailUI", "guess size %d %f", Integer.valueOf(width), Float.valueOf(dimension));
        float f2 = ((float) width) - (dimension * 2.0f);
        if (list.size() <= 0) {
            if (this.EAR.getParent() != null) {
                this.EAR.setVisibility(8);
            }
            this.EAR.removeAllViews();
            this.EAR.setVisibility(8);
            this.DGk.setVisibility(8);
            AppMethodBeat.o(98608);
            return false;
        }
        this.EAR.getParent();
        this.EAR.removeAllViews();
        this.EAR.setVisibility(0);
        if (this.qcr != 10) {
            this.EAR.setBackgroundResource(R.drawable.a54);
        } else if (!this.EBx) {
            this.EAR.setBackgroundResource(R.drawable.c9x);
        } else {
            SnsInfo vs = vs(false);
            if (vs == null) {
                this.EAR.setBackgroundResource(R.drawable.c9x);
            } else if (this.gna.equals(vs.getUserName())) {
                this.EAR.setBackgroundResource(R.drawable.c9y);
            } else {
                this.EAR.setBackgroundResource(R.drawable.c9x);
            }
        }
        this.EAR.setPadding(0, fromDPToPix2, 0, fromDPToPix2);
        ImageView imageView = new ImageView(getContext());
        if (this.qcr == 10) {
            imageView.setImageResource(R.raw.friendactivity_likeicon_golden);
        } else {
            imageView.setImageDrawable(ar.m(getContext(), R.raw.friendactivity_likeicon, getContext().getResources().getColor(R.color.Link)));
        }
        imageView.setPadding(fromDPToPix3, fromDPToPix4, fromDPToPix3, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        imageView.setLayoutParams(layoutParams);
        imageView.setClickable(false);
        imageView.setFocusable(false);
        this.EAR.addView(imageView);
        int fromDPToPix5 = com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), EBs);
        int i2 = ((int) (f2 - ((float) fromDPToPix5))) / (fromDPToPix2 + fromDPToPix);
        if (((int) (f2 - ((float) fromDPToPix5))) % (fromDPToPix2 + fromDPToPix) > fromDPToPix) {
            i2++;
        }
        Log.d("MicroMsg.SnsCommentDetailUI", "guess size %d", Integer.valueOf(i2));
        h hVar = new h(getContext());
        hVar.setClipChildren(false);
        hVar.setClipToPadding(false);
        hVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        hVar.setLineMaxCounte(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            dzo dzo = list.get(i3);
            StoryTouchImageView storyTouchImageView = new StoryTouchImageView(getContext());
            storyTouchImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            storyTouchImageView.setImageResource(R.drawable.a56);
            storyTouchImageView.EQN.fL(dzo.Username, 1);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(fromDPToPix, fromDPToPix);
            layoutParams2.setMargins(0, fromDPToPix2, fromDPToPix2, 0);
            storyTouchImageView.setLayoutParams(layoutParams2);
            storyTouchImageView.setTag(dzo.Username);
            a.b.A(storyTouchImageView, dzo.Username);
            storyTouchImageView.setOnClickListener(this.pri);
            hVar.addView(storyTouchImageView);
        }
        this.EAR.addView(hVar);
        this.DGk.setVisibility(z ? 8 : 0);
        AppMethodBeat.o(98608);
        return true;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(98609);
        super.onConfigurationChanged(configuration);
        SnsInfo aQl = com.tencent.mm.plugin.sns.storage.f.aQl(this.dRS);
        SnsObject B = an.B(aQl);
        n(B.LikeUserList, B.CommentUserList.isEmpty());
        if (this.EAS != null) {
            this.EAS.a(aQl, this.Dyw);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        Point point = new Point();
        point.x = displayMetrics.widthPixels;
        point.y = displayMetrics.heightPixels;
        aj.k(point);
        if (this.EBZ != null) {
            this.EBq = aj.fbb();
            this.EBZ.setImageViewWidth(this.EBq);
        }
        AppMethodBeat.o(98609);
    }

    /* access modifiers changed from: package-private */
    public class b extends BaseAdapter {
        LinkedList<dzo> ECC;
        Activity activity;
        public LinkedList<dzo> commentList;
        String dHp;

        public b(LinkedList<dzo> linkedList, LinkedList<dzo> linkedList2, Activity activity2, String str) {
            this.commentList = linkedList;
            this.ECC = linkedList2;
            this.activity = activity2;
            this.dHp = str;
        }

        public final int getCount() {
            int i2 = 0;
            AppMethodBeat.i(98587);
            if (this.ECC.size() > 0) {
                if (this.commentList != null) {
                    i2 = this.commentList.size();
                }
                int i3 = i2 + 1;
                AppMethodBeat.o(98587);
                return i3;
            } else if (this.commentList == null) {
                AppMethodBeat.o(98587);
                return 0;
            } else {
                int size = this.commentList.size();
                AppMethodBeat.o(98587);
                return size;
            }
        }

        public final Object getItem(int i2) {
            return null;
        }

        public final long getItemId(int i2) {
            return 0;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            a aVar;
            String str;
            String str2;
            AppMethodBeat.i(98588);
            if (this.ECC.size() > 0) {
                if (i2 == 0) {
                    LinearLayout linearLayout = SnsCommentDetailUI.this.DGk;
                    AppMethodBeat.o(98588);
                    return linearLayout;
                }
                i2--;
            }
            dzo dzo = this.commentList.get(i2);
            dzo.iAc = Util.nullAsNil(dzo.iAc);
            if (view == null || !(view.getTag() instanceof a)) {
                view = aa.jQ(this.activity).inflate(R.layout.bvk, (ViewGroup) null);
                view.setOnTouchListener(SnsCommentDetailUI.this.EqE);
                a aVar2 = new a();
                aVar2.gvv = (ImageView) view.findViewById(R.id.j9);
                aVar2.gvv.setOnClickListener(SnsCommentDetailUI.this.pri);
                aVar2.kib = (TextView) view.findViewById(R.id.jk);
                aVar2.kib.setOnTouchListener(new af());
                aVar2.kib.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.b.AnonymousClass2 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(98586);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$CommentListAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Log.i("MicroMsg.SnsCommentDetailUI", "onClick nickTv");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$CommentListAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(98586);
                    }
                });
                aVar2.timeTv = (TextView) view.findViewById(R.id.jn);
                aVar2.hXC = (TextView) view.findViewById(R.id.jc);
                aVar2.ECE = (FrameLayout) view.findViewById(R.id.jb);
                aVar2.hXC.setOnTouchListener(new af());
                aVar2.ECF = (SnsTranslateResultView) view.findViewById(R.id.i1c);
                aVar2.ECF.setVisibility(8);
                aVar2.ECH = (EmojiStatusView) view.findViewById(R.id.jd);
                if (SnsCommentDetailUI.this.qcr == 10) {
                    view.findViewById(R.id.b9o).setBackgroundResource(R.drawable.c9w);
                    aVar = aVar2;
                } else {
                    aVar = aVar2;
                }
            } else {
                aVar = (a) view.getTag();
            }
            aVar.ECG = dzo;
            aVar.userName = dzo.Username;
            ((SnsAvatarImageView) aVar.gvv).fL(dzo.Username, 3);
            ((SnsAvatarImageView) aVar.gvv).setWeakContext(this.activity);
            int i3 = SnsCommentDetailUI.this.qcr == 10 ? 3 : 2;
            int unused = SnsCommentDetailUI.this.qcr;
            g.aAi();
            as bjJ = ((l) g.af(l.class)).aSN().bjJ(aVar.userName);
            if (i2 != 0 || !this.ECC.isEmpty()) {
                if (SnsCommentDetailUI.this.qcr == 10) {
                    view.setBackgroundResource(R.drawable.av6);
                } else {
                    view.setBackgroundResource(R.drawable.av5);
                }
            } else if (SnsCommentDetailUI.this.qcr == 10) {
                view.setBackgroundResource(R.drawable.c9x);
            } else {
                view.setBackgroundResource(R.drawable.a54);
            }
            if (i2 == 0) {
                view.findViewById(R.id.hxd).setVisibility(0);
                view.findViewById(R.id.hxe).setVisibility(8);
                if (SnsCommentDetailUI.this.qcr == 10) {
                    ((ImageView) view.findViewById(R.id.hxd)).setImageResource(R.raw.friendactivity_writeicon_golden);
                }
            } else {
                view.findViewById(R.id.hxd).setVisibility(4);
                view.findViewById(R.id.hxe).setVisibility(0);
            }
            SnsInfo aQl = com.tencent.mm.plugin.sns.storage.f.aQl(SnsCommentDetailUI.this.dRS);
            aVar.gvv.setTag(dzo.Username);
            if (!com.tencent.mm.plugin.sns.ui.widget.e.a(aVar.gvv, aQl, dzo.Username)) {
                a.b.A(aVar.gvv, dzo.Username);
            }
            if (bjJ != null) {
                str = bjJ.arJ();
            } else {
                str = dzo.Nickname != null ? dzo.Nickname : dzo.Username;
            }
            if (com.tencent.mm.plugin.sns.ui.widget.e.b(aQl, dzo.Username)) {
                str2 = com.tencent.mm.plugin.sns.ui.widget.e.c(aQl.getAdXml(), str);
            } else {
                str2 = str;
            }
            if (aQl != null) {
                String str3 = aQl.field_userName;
                aVar.hXC.setText(dzo.iAc + " ");
                CharSequence a2 = com.tencent.mm.plugin.sns.ui.widget.e.a(SnsCommentDetailUI.this, dzo, SnsCommentDetailUI.this.EBk, aQl.field_type, aQl.getUserName(), 2, SnsCommentDetailUI.this.DKd, SnsCommentDetailUI.this.DKf, aQl);
                EmojiInfo emojiInfo = null;
                if (!Util.isNullOrNil(dzo.MYY) && dzo.MYY.get(0) != null) {
                    emojiInfo = bj.gCJ().OpN.blk(dzo.MYY.get(0).Md5);
                }
                if (emojiInfo == null) {
                    aVar.ECH.setVisibility(8);
                    aVar.ECH.setEmojiInfo(null);
                } else {
                    aVar.ECH.setTag(new m(SnsCommentDetailUI.this.EBf, SnsCommentDetailUI.this.dRS, dzo, dzo.Username, dzo.iAc, aVar.hXC, 2, str3));
                    aVar.ECH.setVisibility(0);
                    aVar.ECH.setEmojiInfo(emojiInfo);
                    aVar.ECH.setOnClickListener(SnsCommentDetailUI.this.Dyw.FaX);
                }
                aVar.kib.setText(str2, TextView.BufferType.SPANNABLE);
                com.tencent.mm.pluginsdk.ui.span.l.p(aVar.kib, i3);
                com.tencent.mm.pluginsdk.ui.span.m mVar = new com.tencent.mm.pluginsdk.ui.span.m(aVar.kib.getText());
                Log.i("MicroMsg.SnsCommentDetailUI", "test %s,%s", dzo.Username, str2);
                if (com.tencent.mm.plugin.sns.ui.widget.e.b(aQl, dzo.Username)) {
                    mVar.a(new com.tencent.mm.pluginsdk.ui.span.q(new com.tencent.mm.plugin.sns.data.b(aQl.isAd(), dzo.Username, aQl.getLocalid(), 2, com.tencent.mm.plugin.sns.ui.widget.e.iY(dzo.MYX, 32) ? 27 : 2), SnsCommentDetailUI.this.EBk, i3), str2, 0);
                } else {
                    mVar.a(new com.tencent.mm.pluginsdk.ui.span.q(dzo.Username, SnsCommentDetailUI.this.EBk, i3), str2, 0);
                }
                aVar.kib.setText(mVar, TextView.BufferType.SPANNABLE);
                long j2 = (long) dzo.CreateTime;
                if (com.tencent.mm.plugin.sns.ui.widget.e.iY(dzo.MYX, 32)) {
                    j2 = (long) aQl.getCreateTime();
                }
                aVar.timeTv.setText(bm.r(this.activity, j2 * 1000));
                if (Util.isNullOrNil(a2)) {
                    aVar.hXC.setVisibility(8);
                } else {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a2);
                    spannableStringBuilder.append((CharSequence) " ");
                    aVar.hXC.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                    aVar.hXC.setVisibility(0);
                    a.C1715a aVar3 = com.tencent.mm.plugin.sns.i.a.DRI;
                    a.C1715a.a(aVar.hXC, aVar.ECG);
                }
                SnsCommentDetailUI.this.pqr.c(view, SnsCommentDetailUI.this.Dyw.FaE, SnsCommentDetailUI.this.Dyw.Far);
                SnsCommentDetailUI.this.pqr.c(aVar.ECE, SnsCommentDetailUI.this.Dyw.FaE, SnsCommentDetailUI.this.Dyw.Far);
                String kj = au.kj(SnsCommentDetailUI.this.dRS, String.valueOf(dzo.MYT != 0 ? (long) dzo.MYT : dzo.MYV));
                if (au.fC(kj, 4) && aVar.ECF != null) {
                    au.b aPp = au.aPp(kj);
                    if (aPp != null) {
                        aVar.ECF.setVisibility(0);
                        if (!aPp.iGD) {
                            aVar.ECF.ZW(2);
                        } else if (!aPp.aGI) {
                            aVar.ECF.a(aPp, 2, aPp.result, aPp.brand, aPp.DNi);
                        } else {
                            aVar.ECF.setVisibility(8);
                        }
                    } else {
                        aVar.ECF.setVisibility(8);
                    }
                }
                view.setClickable(true);
                Log.d("MicroMsg.SnsCommentDetailUI", "position " + dzo.Username + " self " + SnsCommentDetailUI.this.gna + " commentid " + dzo.MYT + " snsid " + SnsCommentDetailUI.this.dRS);
                if (SnsCommentDetailUI.this.gna.equals(dzo.Username)) {
                    aVar.info = dzo;
                } else {
                    aVar.info = new Object[]{Integer.valueOf(i2), dzo, dzo.Username, str2};
                }
                m mVar2 = new m(SnsCommentDetailUI.this.EBf, SnsCommentDetailUI.this.dRS, dzo, dzo.Username, dzo.iAc, aVar.hXC, 2, str3);
                mVar2.tag = aVar;
                view.setTag(mVar2);
                aVar.hXC.setTag(mVar2);
                view.setOnClickListener(SnsCommentDetailUI.this.qOH);
                com.tencent.mm.pluginsdk.ui.span.o oVar = new com.tencent.mm.pluginsdk.ui.span.o(SnsCommentDetailUI.this);
                if (com.tencent.mm.plugin.sns.ui.widget.e.b(aQl, dzo.Username)) {
                    oVar.setAdTagClickCallback(SnsCommentDetailUI.this.mAdTagClickCallback, 0);
                    oVar.mAdTagClickScene = 31;
                }
                aVar.hXC.setOnTouchListener(oVar);
                aVar.ECE.setTag(mVar2);
                aVar.ECE.setOnClickListener(SnsCommentDetailUI.this.qOH);
                if (!aQl.isAd() && dzo.DeleteFlag > 0) {
                    mVar.setSpan(new ForegroundColorSpan(SnsCommentDetailUI.this.getContext().getResources().getColor(R.color.BW_50)), 0, mVar.length(), 33);
                    aVar.kib.setText(mVar);
                    TextView textView = aVar.hXC;
                    AppCompatActivity context = SnsCommentDetailUI.this.getContext();
                    String string = context.getResources().getString(R.string.h5h);
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(string);
                    spannableStringBuilder2.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.BW_50)), 0, string.length(), 0);
                    spannableStringBuilder2.setSpan(new BackgroundColorSpan(context.getResources().getColor(R.color.BW_90)), 0, string.length(), 0);
                    textView.setText(spannableStringBuilder2);
                    aVar.hXC.setOnTouchListener(null);
                    aVar.ECE.setOnLongClickListener(null);
                    aVar.ECE.setOnClickListener(null);
                    view.setOnClickListener(null);
                    view.setOnLongClickListener(null);
                }
            }
            AppMethodBeat.o(98588);
            return view;
        }

        /* access modifiers changed from: package-private */
        public class a {
            FrameLayout ECE;
            SnsTranslateResultView ECF;
            dzo ECG;
            EmojiStatusView ECH;
            ImageView gvv;
            TextView hXC;
            Object info;
            TextView kib;
            TextView timeTv;
            String userName;

            a() {
            }
        }
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void aOG(String str) {
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void ci(String str, boolean z) {
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void eZJ() {
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(98610);
        Log.i("MicroMsg.SnsCommentDetailUI", "onAcvityResult requestCode:".concat(String.valueOf(i2)));
        if (i2 == 15) {
            if (!(this.Dyw == null || this.Dyw.Far == null)) {
                this.Dyw.Far.onActivityResult(i2, i3, intent);
            }
            AppMethodBeat.o(98610);
        } else if (i2 == 16) {
            Log.i("MicroMsg.SnsCommentDetailUI", "REQUEST_CODE_FOR_FULLSCREEN");
            iq iqVar = new iq();
            iqVar.dNl.scene = 1;
            EventCenter.instance.publish(iqVar);
            AppMethodBeat.o(98610);
        } else if (i2 == 2333) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("Select_Contact");
                if (!Util.isNullOrNil(stringExtra)) {
                    String[] split = stringExtra.split(",");
                    if (split.length > 0) {
                        this.EoJ.gte.showVKB();
                        String displayName = ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(split[0]);
                        if (!Util.isNullOrNil(displayName)) {
                            this.EoJ.fhY();
                            this.EoJ.setText("@" + displayName + " ");
                            this.EoJ.setCommentAtPrefix("@" + displayName + " ");
                            this.EoJ.setCommentInfo(new dzo());
                            this.EoJ.getCommentInfo().Username = split[0];
                            this.EoJ.setCommentFlag(8);
                        }
                    }
                }
            }
            AppMethodBeat.o(98610);
        } else if (i3 != -1) {
            AppMethodBeat.o(98610);
        } else {
            switch (i2) {
                case 1:
                    if (i3 == -1) {
                        Cursor managedQuery = managedQuery(intent.getData(), null, null, null, null);
                        if (managedQuery.moveToFirst()) {
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/".concat(String.valueOf(managedQuery.getString(managedQuery.getColumnIndexOrThrow("_id")))))));
                            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            break;
                        }
                    }
                    break;
            }
            AppMethodBeat.o(98610);
        }
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(98611);
        if (qVar.getType() == 218 && this.EoW != null) {
            this.EoW.dismiss();
        }
        if (i2 == 0 && i3 == 0) {
            if (!(this.EBG == null || this.EBG.tipDialog == null || !this.EBG.tipDialog.isShowing())) {
                this.EBG.tipDialog.dismiss();
            }
            SnsInfo aQl = com.tencent.mm.plugin.sns.storage.f.aQl(this.dRS);
            if (aQl == null) {
                Log.e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.dRS);
                finish();
                AppMethodBeat.o(98611);
                return;
            }
            Log.d("MicroMsg.SnsCommentDetailUI", "snsId: " + this.dRS + "  username:" + aQl.getUserName());
            if (this.EAP == null) {
                Log.e("MicroMsg.SnsCommentDetailUI", "fatal error! Sns onSceneEnd before initView and infoHeader is null!");
                finish();
                AppMethodBeat.o(98611);
                return;
            }
            fhP();
            f(aQl, false);
            SnsObject B = an.B(aQl);
            Log.i("MicroMsg.SnsCommentDetailUI", "onsceneend " + B.LikeUserList.size() + " " + B.CommentUserList.size());
            if (B == null) {
                AppMethodBeat.o(98611);
                return;
            }
            if (!f(this.EBb, B.LikeUserList)) {
                n(B.LikeUserList, B.CommentUserList.isEmpty());
                this.EBb = B.LikeUserList;
            }
            if (this.EAS != null) {
                this.EAS.a(aQl, this.Dyw);
            }
            b bVar = this.EAW;
            LinkedList<dzo> linkedList = B.CommentUserList;
            LinkedList<dzo> linkedList2 = B.LikeUserList;
            bVar.commentList = linkedList;
            bVar.ECC = linkedList2;
            this.EAW.notifyDataSetChanged();
            new MMHandler().postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.b.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(98585);
                    SnsCommentDetailUI.this.EAT.setSelection((SnsCommentDetailUI.this.EAT.getHeaderViewsCount() + b.this.commentList.size()) - 1);
                    AppMethodBeat.o(98585);
                }
            }, 60);
        }
        SnsTimeLineUI.a(i2, i3, qVar, this);
        AppMethodBeat.o(98611);
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void cj(String str, boolean z) {
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void onKeyboardStateChanged() {
        AppMethodBeat.i(98612);
        if (keyboardState() == 2) {
            Log.i("MicroMsg.SnsCommentDetailUI", "keybaordhide! ");
            this.EBd = false;
            AppMethodBeat.o(98612);
            return;
        }
        if (keyboardState() == 1) {
            Log.i("MicroMsg.SnsCommentDetailUI", "keybaordShow");
            fhQ();
            this.EoG = false;
            this.EBS.run();
            if (this.EoR != null) {
                this.EoR.fcl();
            }
        }
        AppMethodBeat.o(98612);
    }

    private boolean a(SnsInfo snsInfo, SnsAdTimelineVideoView snsAdTimelineVideoView) {
        AppMethodBeat.i(203542);
        boolean z = false;
        if (snsAdTimelineVideoView != null && this.EBI && snsInfo != null && snsInfo.isAd()) {
            z = true;
        }
        Log.i("MicroMsg.SnsCommentDetailUI", "the useNewPlayer return value is ".concat(String.valueOf(z)));
        AppMethodBeat.o(203542);
        return z;
    }

    /* access modifiers changed from: package-private */
    public class c implements OfflineVideoView.a {
        private SnsInfo DsC;
        private SnsAdTimelineVideoView Ewt;

        c(SnsInfo snsInfo, SnsAdTimelineVideoView snsAdTimelineVideoView) {
            this.DsC = snsInfo;
            this.Ewt = snsAdTimelineVideoView;
        }

        @Override // com.tencent.mm.plugin.sns.ui.OfflineVideoView.a
        public final boolean a(PString pString) {
            return false;
        }

        @Override // com.tencent.mm.plugin.sns.ui.OfflineVideoView.a
        public final void onStart(int i2) {
            AppMethodBeat.i(203535);
            Log.i("MicroMsg.SnsCommentDetailUI", "the detail new video player onStart called,  durationSecond = ".concat(String.valueOf(i2)));
            AppMethodBeat.o(203535);
        }

        @Override // com.tencent.mm.plugin.sns.ui.OfflineVideoView.a
        public final void onCompletion() {
            AppMethodBeat.i(203536);
            Log.i("MicroMsg.SnsCommentDetailUI", "the detail new video player onCompletion return value is ");
            if (SnsCommentDetailUI.this.EBv == null || this.DsC == null || this.Ewt == null) {
                Log.w("MicroMsg.SnsCommentDetailUI", "the snsAdStatistic or snsInfo is null in onCompletion!!!");
                AppMethodBeat.o(203536);
                return;
            }
            this.Ewt.restart();
            SnsCommentDetailUI.this.EBv.I(this.DsC.field_snsId, false);
            AppMethodBeat.o(203536);
        }

        @Override // com.tencent.mm.plugin.sns.ui.OfflineVideoView.a
        public final void xv(int i2) {
            AppMethodBeat.i(203537);
            Log.i("MicroMsg.SnsCommentDetailUI", "the detail new video player updateTime called, playTimeMs = ".concat(String.valueOf(i2)));
            if (SnsCommentDetailUI.this.EBv == null || this.DsC == null || this.Ewt == null) {
                Log.w("MicroMsg.SnsCommentDetailUI", "the snsAdStatistic or snsInfo is null in updateTime!!!");
                AppMethodBeat.o(203537);
                return;
            }
            SnsCommentDetailUI.this.EBv.IT(this.DsC.field_snsId);
            SnsCommentDetailUI.this.EBv.ao(this.DsC.field_snsId, (long) i2);
            if (!SnsCommentDetailUI.this.EBv.IQ(this.DsC.field_snsId)) {
                int durationMs = this.Ewt.getDurationMs() / 1000;
                Log.i("MicroMsg.SnsCommentDetailUI", "updatePlayStartTime, duration=".concat(String.valueOf(durationMs)));
                SnsCommentDetailUI.this.EBv.c(this.DsC.field_snsId, Util.currentTicks(), false);
                SnsCommentDetailUI.this.EBv.e(this.DsC.field_snsId, durationMs, false);
                SnsCommentDetailUI.this.EBv.an(this.DsC.field_snsId, this.DsC.field_snsId);
            }
            AppMethodBeat.o(203537);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(com.tencent.mm.plugin.sns.storage.SnsInfo r7, com.tencent.mm.plugin.sns.ui.PhotosContent r8, int r9) {
        /*
        // Method dump skipped, instructions count: 144
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.a(com.tencent.mm.plugin.sns.storage.SnsInfo, com.tencent.mm.plugin.sns.ui.PhotosContent, int):void");
    }

    static /* synthetic */ void a(SnsCommentDetailUI snsCommentDetailUI, String str, String str2, String str3) {
        AppMethodBeat.i(98613);
        SnsInfo vs = snsCommentDetailUI.vs(false);
        if (vs == null || !vs.getSnsId().equals(str)) {
            AppMethodBeat.o(98613);
            return;
        }
        if (Util.isNullOrNil(str2)) {
            snsCommentDetailUI.EBw.setVisibility(8);
        } else {
            au.fA(str, 4);
            au.b aPp = au.aPp(str);
            snsCommentDetailUI.EBw.setVisibility(0);
            snsCommentDetailUI.EBw.a(aPp, 1, str2, str3, aPp.DNi);
        }
        snsCommentDetailUI.EAQ.setTag(new bg(snsCommentDetailUI.dRS, vs.getLocalid(), true, false, 2));
        AppMethodBeat.o(98613);
    }

    static /* synthetic */ void a(SnsCommentDetailUI snsCommentDetailUI, String str) {
        AppMethodBeat.i(98614);
        au.fA(str, 4);
        if (snsCommentDetailUI.EAW != null) {
            snsCommentDetailUI.EAW.notifyDataSetChanged();
        }
        AppMethodBeat.o(98614);
    }

    static /* synthetic */ void b(SnsCommentDetailUI snsCommentDetailUI, String str) {
        AppMethodBeat.i(98615);
        if (snsCommentDetailUI.vs(false).getSnsId().equals(str)) {
            snsCommentDetailUI.EBw.setVisibility(0);
            snsCommentDetailUI.EBw.ZW(1);
        }
        AppMethodBeat.o(98615);
    }

    static /* synthetic */ void c(SnsCommentDetailUI snsCommentDetailUI, String str) {
        AppMethodBeat.i(98616);
        au.fA(str, 4);
        if (snsCommentDetailUI.EAW != null) {
            snsCommentDetailUI.EAW.notifyDataSetChanged();
        }
        AppMethodBeat.o(98616);
    }

    static /* synthetic */ void d(SnsCommentDetailUI snsCommentDetailUI, String str) {
        AppMethodBeat.i(98617);
        SnsInfo vs = snsCommentDetailUI.vs(false);
        if (vs.getSnsId().equals(str)) {
            au.fB(str, 4);
            snsCommentDetailUI.EBw.setVisibility(8);
            snsCommentDetailUI.EAQ.setTag(new bg(snsCommentDetailUI.dRS, vs.getLocalid(), true, false, 2));
        }
        AppMethodBeat.o(98617);
    }

    static /* synthetic */ void e(SnsCommentDetailUI snsCommentDetailUI, String str) {
        AppMethodBeat.i(98618);
        au.fB(str, 4);
        if (snsCommentDetailUI.EAW != null) {
            snsCommentDetailUI.EAW.notifyDataSetChanged();
        }
        AppMethodBeat.o(98618);
    }

    static /* synthetic */ void a(SnsCommentDetailUI snsCommentDetailUI, int i2, int i3, ir irVar) {
        SnsInfo vs;
        TagImageView tagImageView;
        AppMethodBeat.i(98619);
        if (i3 == -1 && (vs = snsCommentDetailUI.vs(false)) != null) {
            TimeLineObject timeLine = vs.getTimeLine();
            if (timeLine.ContentObj.LoU == 1 && timeLine.ContentObj.LoV.size() == 4 && i2 > 1 && i2 + 1 < be.EGz.length) {
                i2++;
            }
            if (!(snsCommentDetailUI.EBZ == null || (tagImageView = (TagImageView) snsCommentDetailUI.EBZ.findViewById(be.EGz[i2])) == null)) {
                int[] iArr = new int[2];
                tagImageView.getLocationOnScreen(iArr);
                irVar.dNn.dEq = iArr[0];
                irVar.dNn.dEr = iArr[1];
                irVar.dNn.dEs = tagImageView.getWidth();
                irVar.dNn.dEt = tagImageView.getHeight();
            }
        }
        AppMethodBeat.o(98619);
    }

    static /* synthetic */ void h(SnsCommentDetailUI snsCommentDetailUI) {
        AppMethodBeat.i(203546);
        snsCommentDetailUI.vr(true);
        AppMethodBeat.o(203546);
    }

    static /* synthetic */ void a(SnsCommentDetailUI snsCommentDetailUI, View view) {
        b.a aVar;
        boolean z;
        AppMethodBeat.i(98624);
        if (view.getTag() instanceof m) {
            aVar = (b.a) ((m) view.getTag()).tag;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            if (aVar.info instanceof dzo) {
                if (snsCommentDetailUI.EBd) {
                    snsCommentDetailUI.vr(false);
                }
                final dzo dzo = (dzo) aVar.info;
                final String charSequence = aVar.hXC.getText().toString();
                AppCompatActivity context = snsCommentDetailUI.getContext();
                String[] strArr = {snsCommentDetailUI.getContext().getString(R.string.t_), snsCommentDetailUI.getContext().getString(R.string.tf)};
                snsCommentDetailUI.getContext().getString(R.string.sz);
                com.tencent.mm.ui.base.h.a(context, (String) null, strArr, new h.d() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.base.h.d
                    public final void oj(int i2) {
                        int i3 = 0;
                        AppMethodBeat.i(163080);
                        switch (i2) {
                            case 0:
                                if (ClipboardHelper.setTextSwallowException(charSequence)) {
                                    com.tencent.mm.ui.base.h.cD(SnsCommentDetailUI.this.getContext(), SnsCommentDetailUI.this.getContext().getString(R.string.ta));
                                    String unsignedLongString = Util.getUnsignedLongString(y.aOa(SnsCommentDetailUI.this.dRS));
                                    if (!(dzo == null || charSequence == null || unsignedLongString == null)) {
                                        com.tencent.mm.plugin.secinforeport.a.a aVar = com.tencent.mm.plugin.secinforeport.a.a.INSTANCE;
                                        com.tencent.mm.plugin.secinforeport.a.a.q(4, unsignedLongString + ":" + dzo.MYT, Util.getUTF8ByteLength(charSequence.toString()));
                                    }
                                    AppMethodBeat.o(163080);
                                    return;
                                }
                                com.tencent.mm.ui.base.h.cD(SnsCommentDetailUI.this.getContext(), SnsCommentDetailUI.this.getContext().getString(R.string.j80));
                                AppMethodBeat.o(163080);
                                return;
                            case 1:
                                Log.e("MicroMsg.SnsCommentDetailUI", "del snsId:" + SnsCommentDetailUI.this.dRS + " commentId:" + (dzo != null ? dzo.MYT : 0));
                                final s sVar = new s(y.aOa(SnsCommentDetailUI.this.dRS), y.aNz(SnsCommentDetailUI.this.dRS) ? 4 : 6, dzo);
                                g.aAi();
                                g.aAg().hqi.a(sVar, 0);
                                SnsCommentDetailUI snsCommentDetailUI = SnsCommentDetailUI.this;
                                SnsCommentDetailUI snsCommentDetailUI2 = SnsCommentDetailUI.this;
                                SnsCommentDetailUI.this.getString(R.string.zb);
                                snsCommentDetailUI.EoW = com.tencent.mm.ui.base.h.a((Context) snsCommentDetailUI2, SnsCommentDetailUI.this.getString(R.string.h5m), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                    /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass2.AnonymousClass1 */

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(163079);
                                        g.aAi();
                                        g.aAg().hqi.a(sVar);
                                        AppMethodBeat.o(163079);
                                    }
                                });
                                com.tencent.mm.plugin.sns.k.e.DUQ.fcy().eOA = 4;
                                String str = "";
                                SnsInfo aQl = com.tencent.mm.plugin.sns.storage.f.aQl(SnsCommentDetailUI.this.dRS);
                                if (dzo != null) {
                                    i3 = dzo.MYT;
                                    str = dzo.Username;
                                }
                                com.tencent.mm.plugin.sns.k.e eVar = com.tencent.mm.plugin.sns.k.e.DUQ;
                                com.tencent.mm.plugin.sns.k.e.b(aQl, i3, str, 1);
                                break;
                        }
                        AppMethodBeat.o(163080);
                    }
                });
                AppMethodBeat.o(98624);
                return;
            } else if (aVar.info instanceof Object[]) {
                final Object[] objArr = (Object[]) aVar.info;
                SnsCommentFooter snsCommentFooter = snsCommentDetailUI.EoJ;
                String str = (String) objArr[2];
                if ((snsCommentFooter.DIu == null || snsCommentFooter.DIu.Username == null || !snsCommentFooter.DIu.Username.equals(str)) && !snsCommentFooter.fhV()) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    dzo dzo2 = (dzo) objArr[1];
                    SnsInfo aQm = com.tencent.mm.plugin.sns.storage.f.aQm(snsCommentDetailUI.EBf);
                    snsCommentDetailUI.EoJ.ECO = 0;
                    snsCommentDetailUI.EoJ.setCommentHint(snsCommentDetailUI.getString(R.string.h9y) + objArr[3]);
                    if (aQm != null && aQm.isAd() && dzo2.Username != null && dzo2.Username.equals(aQm.getUserName())) {
                        snsCommentDetailUI.EoJ.ECO = 1;
                    }
                    snsCommentDetailUI.EoJ.setCommentInfo(dzo2);
                    snsCommentDetailUI.EoJ.oY(false);
                    snsCommentDetailUI.EoJ.setToSendTextColor(true);
                    snsCommentDetailUI.EoJ.vt(true);
                    int intValue = ((Integer) objArr[0]).intValue();
                    if (an.C(aQm).LikeUserList.size() > 0 && (intValue = intValue + 1) > snsCommentDetailUI.EAW.getCount()) {
                        intValue = snsCommentDetailUI.EAW.getCount() - 1;
                    }
                    snsCommentDetailUI.EBS.UZ = intValue;
                    snsCommentDetailUI.EBS.kn = view.getHeight();
                    snsCommentDetailUI.fhR();
                    AppMethodBeat.o(98624);
                    return;
                }
                snsCommentDetailUI.getString(R.string.sz);
                com.tencent.mm.ui.base.h.a(snsCommentDetailUI, (String) null, new String[]{snsCommentDetailUI.getString(R.string.h9y) + objArr[3]}, new h.d() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.AnonymousClass47 */

                    @Override // com.tencent.mm.ui.base.h.d
                    public final void oj(int i2) {
                        AppMethodBeat.i(98582);
                        switch (i2) {
                            case 0:
                                SnsCommentDetailUI.this.EoJ.ECO = 0;
                                SnsCommentDetailUI.this.EoJ.fhY();
                                SnsCommentDetailUI.this.EoJ.setCommentHint(SnsCommentDetailUI.this.getString(R.string.h9y) + objArr[3]);
                                SnsCommentDetailUI.this.EoJ.setCommentInfo((dzo) objArr[1]);
                                SnsCommentDetailUI.this.EoJ.oY(false);
                                SnsCommentDetailUI.this.EoJ.setToSendTextColor(true);
                                SnsCommentDetailUI.this.EoJ.vt(true);
                                int intValue = ((Integer) objArr[0]).intValue();
                                if (an.C(com.tencent.mm.plugin.sns.storage.f.aQm(SnsCommentDetailUI.this.EBf)).LikeUserList.size() > 0 && (intValue = intValue + 1) > SnsCommentDetailUI.this.EAW.getCount()) {
                                    intValue = SnsCommentDetailUI.this.EAW.getCount() - 1;
                                }
                                SnsCommentDetailUI.this.EBS.UZ = intValue;
                                SnsCommentDetailUI.this.EBS.run();
                                break;
                        }
                        AppMethodBeat.o(98582);
                    }
                });
            }
        }
        AppMethodBeat.o(98624);
    }

    static /* synthetic */ void u(SnsCommentDetailUI snsCommentDetailUI) {
        AppMethodBeat.i(203548);
        try {
            SnsInfo vs = snsCommentDetailUI.vs(false);
            if (vs == null || !vs.isAd()) {
                AppMethodBeat.o(203548);
                return;
            }
            String nullAsNil = Util.nullAsNil(vs.getAdInfo().uxInfo);
            Log.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "uxInfo = ".concat(String.valueOf(nullAsNil)));
            String aH = com.tencent.mm.plugin.sns.a.b.aH("2", nullAsNil, "");
            Log.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "reportScreenShotParams = ".concat(String.valueOf(aH)));
            com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(19213, aH);
            AppMethodBeat.o(203548);
        } catch (Throwable th) {
            Log.e("MicroMsg.SnsCommentDetailUI.ScreenShot", th.toString());
            AppMethodBeat.o(203548);
        }
    }

    static /* synthetic */ void z(SnsCommentDetailUI snsCommentDetailUI) {
        AppMethodBeat.i(203549);
        if (snsCommentDetailUI.EoJ != null) {
            snsCommentDetailUI.EoJ.vt(false);
            if (snsCommentDetailUI.EoJ.fhV()) {
                snsCommentDetailUI.EoJ.ECO = 0;
                snsCommentDetailUI.EoJ.fhY();
                snsCommentDetailUI.EoJ.setCommentHint(snsCommentDetailUI.getString(R.string.hbp));
                SnsInfo vs = snsCommentDetailUI.vs(true);
                if (vs != null) {
                    if (!vs.isAd() || (vs.getTimeLine().ContentObj.LoW & 8) == 0) {
                        snsCommentDetailUI.EoJ.oY(false);
                    } else {
                        snsCommentDetailUI.EoJ.oY(true);
                        AppMethodBeat.o(203549);
                        return;
                    }
                }
                AppMethodBeat.o(203549);
                return;
            }
            snsCommentDetailUI.EoJ.state = 0;
        }
        AppMethodBeat.o(203549);
    }

    static /* synthetic */ void B(SnsCommentDetailUI snsCommentDetailUI) {
        int i2;
        AppMethodBeat.i(203550);
        int count = snsCommentDetailUI.EAW.getCount() - 1;
        dzo commentInfo = snsCommentDetailUI.EoJ.getCommentInfo();
        long j2 = commentInfo.MYT != 0 ? (long) commentInfo.MYT : commentInfo.MYV;
        if (commentInfo != null) {
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= snsCommentDetailUI.EAW.commentList.size()) {
                    break;
                }
                dzo dzo = snsCommentDetailUI.EAW.commentList.get(i2);
                if ((dzo.MYT != 0 ? (long) dzo.MYT : dzo.MYV) == j2) {
                    break;
                }
                i3 = i2 + 1;
            }
            snsCommentDetailUI.EBS.kn = snsCommentDetailUI.fhN();
            if (an.B(com.tencent.mm.plugin.sns.storage.f.aQl(snsCommentDetailUI.dRS)).LikeUserList.size() > 0 && (i2 = i2 + 1) > snsCommentDetailUI.EAW.getCount()) {
                i2 = snsCommentDetailUI.EAW.getCount() - 1;
            }
            snsCommentDetailUI.EBS.UZ = i2;
            snsCommentDetailUI.fhR();
            AppMethodBeat.o(203550);
        }
        i2 = count;
        snsCommentDetailUI.EBS.kn = snsCommentDetailUI.fhN();
        i2 = snsCommentDetailUI.EAW.getCount() - 1;
        snsCommentDetailUI.EBS.UZ = i2;
        snsCommentDetailUI.fhR();
        AppMethodBeat.o(203550);
    }

    static /* synthetic */ void H(SnsCommentDetailUI snsCommentDetailUI) {
        int i2 = 1;
        AppMethodBeat.i(203553);
        if (y.aQJ(snsCommentDetailUI.dRS)) {
            SnsInfo aQl = com.tencent.mm.plugin.sns.storage.f.aQl(snsCommentDetailUI.dRS);
            if (aQl != null) {
                if (aQl.getLikeFlag() == 0) {
                    aQl.setLikeFlag(1);
                    com.tencent.mm.plugin.sns.storage.f.a(aQl.getSnsId(), aQl);
                    if (aQl.isAd()) {
                        i2 = 7;
                    }
                    aq.a.a(aQl, i2, "", snsCommentDetailUI.getSource());
                    snsCommentDetailUI.EAW.notifyDataSetChanged();
                    com.tencent.mm.plugin.sns.k.e.DUQ.fcy().eOB = 3;
                } else {
                    aQl.setLikeFlag(0);
                    com.tencent.mm.plugin.sns.storage.f.a(aQl.getSnsId(), aQl);
                    aq.a.aPo(aQl.getSnsId());
                    com.tencent.mm.plugin.sns.k.e.DUQ.fcy().eOB = 5;
                }
            }
            if (snsCommentDetailUI.EBu != null && (snsCommentDetailUI.EBu instanceof com.tencent.mm.plugin.sns.ui.c.a.f)) {
                ((com.tencent.mm.plugin.sns.ui.c.a.f) snsCommentDetailUI.EBu).fko();
            }
            SnsObject B = an.B(com.tencent.mm.plugin.sns.storage.f.aQl(snsCommentDetailUI.dRS));
            if (B != null) {
                snsCommentDetailUI.EBb = B.LikeUserList;
                snsCommentDetailUI.n(B.LikeUserList, B.CommentUserList.isEmpty());
                b bVar = snsCommentDetailUI.EAW;
                bVar.ECC = B.LikeUserList;
                bVar.notifyDataSetChanged();
            }
        }
        AppMethodBeat.o(203553);
    }
}
