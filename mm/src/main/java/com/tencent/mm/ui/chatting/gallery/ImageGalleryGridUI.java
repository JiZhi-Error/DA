package com.tencent.mm.ui.chatting.gallery;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.z;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.ir;
import com.tencent.mm.g.a.is;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.g.a.ry;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.v;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.a;
import com.tencent.mm.ui.chatting.au;
import com.tencent.mm.ui.chatting.gallery.c;
import com.tencent.mm.ui.chatting.gallery.h;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.ui.chatting.l;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

@a(19)
public class ImageGalleryGridUI extends MMActivity implements MenuItem.OnMenuItemClickListener, View.OnClickListener, ViewTreeObserver.OnPreDrawListener, AdapterView.OnItemClickListener, z, h.b {
    private Animation Dog;
    private GridView EAK;
    private long Pwr = 0;
    public View PxA = null;
    private View PxB;
    private int PxC = -1;
    private View PxD;
    private View PxE;
    private View PxF;
    private View PxG;
    public int Pxq;
    c Pxr;
    private WeakReference<c.a> Pxs;
    private Boolean Pxt;
    private Boolean Pxu;
    private TextView Pxv;
    private TextView Pxw;
    private Runnable Pxx = new Runnable() {
        /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(35950);
            if (!(ImageGalleryGridUI.this.EAK == null || ImageGalleryGridUI.this.EAK.getVisibility() == 4)) {
                ImageGalleryGridUI.this.EAK.setVisibility(4);
            }
            AppMethodBeat.o(35950);
        }
    };
    private Runnable Pxy = new Runnable() {
        /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI.AnonymousClass3 */

        public final void run() {
            AppMethodBeat.i(35952);
            if (!(ImageGalleryGridUI.this.EAK == null || ImageGalleryGridUI.this.EAK.getVisibility() == 0)) {
                ImageGalleryGridUI.this.EAK.setVisibility(0);
            }
            AppMethodBeat.o(35952);
        }
    };
    Runnable Pxz = new Runnable() {
        /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI.AnonymousClass8 */

        @TargetApi(12)
        public final void run() {
            AppMethodBeat.i(35961);
            if (ImageGalleryGridUI.this.PxA != null) {
                ImageGalleryGridUI.this.PxA.setVisibility(8);
                ImageGalleryGridUI.this.PxA = null;
            }
            AppMethodBeat.o(35961);
        }
    };
    protected MMHandler handler;
    private boolean mIsPause = true;
    public long ppv;
    private IListener qoC = new IListener<ir>() {
        /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI.AnonymousClass4 */

        {
            AppMethodBeat.i(161539);
            this.__eventId = ir.class.getName().hashCode();
            AppMethodBeat.o(161539);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ir irVar) {
            AppMethodBeat.i(35953);
            ir irVar2 = irVar;
            ImageGalleryGridUI.a(ImageGalleryGridUI.this, irVar2.dNm.dNp, irVar2);
            AppMethodBeat.o(35953);
            return false;
        }
    };
    private boolean qoo = false;
    private String talker;
    public boolean tca;
    private boolean tkg = false;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ImageGalleryGridUI() {
        AppMethodBeat.i(35964);
        AppMethodBeat.o(35964);
    }

    static /* synthetic */ void a(ImageGalleryGridUI imageGalleryGridUI, cz czVar) {
        AppMethodBeat.i(35996);
        imageGalleryGridUI.c(czVar);
        AppMethodBeat.o(35996);
    }

    static /* synthetic */ void ju(List list) {
        AppMethodBeat.i(35997);
        jo(list);
        AppMethodBeat.o(35997);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.avi;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(35965);
        super.onCreate(bundle);
        this.tkg = true;
        this.handler = new MMHandler();
        Rs(0);
        EventCenter.instance.addListener(this.qoC);
        AppMethodBeat.o(35965);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean fromFullScreenActivity() {
        return true;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(35966);
        this.handler.removeCallbacks(this.Pxy);
        this.handler = null;
        q.bcV().onScrollStateChanged(0);
        EventCenter.instance.removeListener(this.qoC);
        super.onDestroy();
        AppMethodBeat.o(35966);
    }

    private void handleIntent(Intent intent) {
        boolean z = true;
        AppMethodBeat.i(35969);
        if (intent.getIntExtra("kintent_intent_source", 0) != 1) {
            z = false;
        }
        this.Pxt = Boolean.valueOf(z);
        this.talker = intent.getStringExtra("kintent_talker");
        this.Pxq = intent.getIntExtra("kintent_image_index", 0);
        this.tca = intent.getBooleanExtra("key_is_biz_chat", false);
        this.ppv = getIntent().getLongExtra("key_biz_chat_id", -1);
        this.Pxu = Boolean.TRUE;
        AppMethodBeat.o(35969);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(35970);
        setIntent(intent);
        super.onNewIntent(intent);
        Rs(1);
        AppMethodBeat.o(35970);
    }

    @TargetApi(11)
    private void Rs(int i2) {
        AppMethodBeat.i(35972);
        handleIntent(getIntent());
        setMMTitle(getString(R.string.gs));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(35954);
                ImageGalleryGridUI.this.onBackPressed();
                AppMethodBeat.o(35954);
                return true;
            }
        });
        this.PxB = findViewById(R.id.fju);
        View findViewById = findViewById(R.id.cb4);
        this.PxD = findViewById;
        findViewById.setOnClickListener(this);
        View findViewById2 = findViewById(R.id.iuu);
        this.PxE = findViewById2;
        findViewById2.setOnClickListener(this);
        View findViewById3 = findViewById(R.id.h__);
        this.PxF = findViewById3;
        findViewById3.setOnClickListener(this);
        View findViewById4 = findViewById(R.id.blh);
        this.PxG = findViewById4;
        findViewById4.setOnClickListener(this);
        this.Pxv = (TextView) findViewById(R.id.lb);
        this.Pxw = (TextView) findViewById(R.id.kk);
        if (i2 == 0) {
            this.EAK = (GridView) findViewById(R.id.dvs);
            this.EAK.setOnItemClickListener(this);
            this.EAK.setNumColumns(3);
            ca caVar = new ca();
            if (this.tca) {
                caVar.yG(this.ppv);
            }
            this.Pxr = new c(this, caVar, this.talker);
            if (this.Pxr.getCount() == 0) {
                this.Pxw.setVisibility(0);
                AppMethodBeat.o(35972);
                return;
            }
            this.Pxw.setVisibility(8);
            this.EAK.setAdapter((ListAdapter) this.Pxr);
            gSj();
        } else if (this.Pxr != null) {
            this.Pxr.notifyDataSetChanged();
            gSj();
        }
        this.EAK.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI.AnonymousClass6 */
            private Runnable qpo = new Runnable() {
                /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI.AnonymousClass6.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(35955);
                    ImageGalleryGridUI.this.Pxv.startAnimation(AnimationUtils.loadAnimation(ImageGalleryGridUI.this.getContext(), R.anim.bs));
                    ImageGalleryGridUI.this.Pxv.setVisibility(8);
                    AppMethodBeat.o(35955);
                }
            };

            {
                AppMethodBeat.i(35956);
                AppMethodBeat.o(35956);
            }

            private void kI(boolean z) {
                AppMethodBeat.i(35957);
                if (z) {
                    ImageGalleryGridUI.this.Pxv.removeCallbacks(this.qpo);
                    if (ImageGalleryGridUI.this.Pxv.getVisibility() != 0) {
                        ImageGalleryGridUI.this.Pxv.clearAnimation();
                        Animation loadAnimation = AnimationUtils.loadAnimation(ImageGalleryGridUI.this.getContext(), R.anim.br);
                        ImageGalleryGridUI.this.Pxv.setVisibility(0);
                        ImageGalleryGridUI.this.Pxv.startAnimation(loadAnimation);
                        AppMethodBeat.o(35957);
                        return;
                    }
                } else {
                    ImageGalleryGridUI.this.Pxv.removeCallbacks(this.qpo);
                    ImageGalleryGridUI.this.Pxv.postDelayed(this.qpo, 256);
                }
                AppMethodBeat.o(35957);
            }

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
                AppMethodBeat.i(35958);
                if (1 == i2) {
                    kI(true);
                } else if (i2 == 0) {
                    kI(false);
                }
                q.bcV().onScrollStateChanged(i2);
                AppMethodBeat.o(35958);
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                String a2;
                AppMethodBeat.i(35959);
                ImageGalleryGridUI imageGalleryGridUI = ImageGalleryGridUI.this;
                ca caVar = (ca) imageGalleryGridUI.Pxr.getItem(i2);
                if (caVar == null) {
                    a2 = null;
                } else {
                    a2 = com.tencent.mm.ui.gridviewheaders.a.gWr().a(new Date(caVar.field_createTime), imageGalleryGridUI);
                }
                ImageGalleryGridUI.this.Pxv.setText(a2);
                AppMethodBeat.o(35959);
            }
        });
        AppMethodBeat.o(35972);
    }

    private void gSj() {
        AppMethodBeat.i(35973);
        int firstVisiblePosition = this.EAK.getFirstVisiblePosition();
        int lastVisiblePosition = this.EAK.getLastVisiblePosition();
        int i2 = this.Pxq;
        if (i2 < firstVisiblePosition || i2 > lastVisiblePosition) {
            this.EAK.setSelection(i2);
            AppMethodBeat.o(35973);
            return;
        }
        AppMethodBeat.o(35973);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(35974);
        super.finish();
        h.a.Pys.detach();
        AppMethodBeat.o(35974);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        k.b bVar;
        boolean z;
        int i3;
        boolean z2;
        String str;
        int i4;
        AppMethodBeat.i(35975);
        b bVar2 = new b();
        bVar2.bm(adapterView);
        bVar2.bm(view);
        bVar2.pH(i2);
        bVar2.zo(j2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar2.axR());
        ca caVar = (ca) this.Pxr.getItem(i2);
        String str2 = caVar.field_content;
        if (str2 != null) {
            bVar = k.b.aD(str2, caVar.field_reserved);
        } else {
            bVar = null;
        }
        if (bVar != null && bVar.type == 6) {
            cx(caVar);
        } else if (bVar != null && bVar.type == 3) {
            String R = com.tencent.mm.pluginsdk.model.app.q.R(bVar.url, "message");
            String R2 = com.tencent.mm.pluginsdk.model.app.q.R(bVar.iwH, "message");
            PackageInfo packageInfo = getPackageInfo(getContext(), bVar.appId);
            if (packageInfo == null) {
                str = null;
            } else {
                str = packageInfo.versionName;
            }
            if (packageInfo == null) {
                i4 = 0;
            } else {
                i4 = packageInfo.versionCode;
            }
            String str3 = bVar.appId;
            long j3 = caVar.field_msgId;
            long j4 = caVar.field_msgSvrId;
            if ((R == null || R.length() == 0) && (R2 == null || R2.length() == 0)) {
                Log.e("MicroMsg.GalleryGridUI", "url, lowUrl both are empty");
            } else {
                if (!NetStatusUtil.isMobile(getContext()) ? R == null || R.length() <= 0 : R2 != null && R2.length() > 0) {
                    R = R2;
                }
                Intent intent = new Intent();
                intent.putExtra("msg_id", j3);
                intent.putExtra("rawUrl", R);
                intent.putExtra("version_name", str);
                intent.putExtra("version_code", i4);
                intent.putExtra("usePlugin", true);
                intent.putExtra("geta8key_username", this.talker);
                intent.putExtra("KPublisherId", "msg_" + Long.toString(j4));
                intent.putExtra("KAppId", str3);
                String cw = cw(caVar);
                intent.putExtra("pre_username", cw);
                intent.putExtra("prePublishId", "msg_" + Long.toString(j4));
                if (caVar != null) {
                    intent.putExtra("preUsername", cw);
                }
                intent.putExtra("preChatName", this.talker);
                intent.putExtra("preChatTYPE", ac.aJ(cw, this.talker));
                intent.putExtra("preMsgIndex", 0);
                com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", intent);
            }
        } else if (bVar == null || bVar.type != 5) {
            if (bVar != null && bVar.type == 19) {
                Intent intent2 = new Intent();
                intent2.putExtra("message_id", caVar.field_msgId);
                intent2.putExtra("record_xml", bVar.ixl);
                com.tencent.mm.br.c.b(getContext(), "record", ".ui.RecordMsgDetailUI", intent2);
            } else if (bVar != null && bVar.type == 24) {
                pa paVar = new pa();
                paVar.dVb.context = getContext();
                paVar.dVb.msgId = caVar.field_msgId;
                paVar.dVb.dVc = bVar.ixl;
                EventCenter.instance.publish(paVar);
            } else if (bVar != null && bVar.type == 7) {
                g o = com.tencent.mm.pluginsdk.model.app.h.o(bVar.appId, false, false);
                if (o != null) {
                    String str4 = this.talker;
                    if (ab.Eq(str4)) {
                        str4 = bp.Ks(caVar.field_content);
                    }
                    long j5 = caVar.field_msgSvrId;
                    int i5 = (o == null || !com.tencent.mm.pluginsdk.model.app.q.s(getContext(), o.field_packageName)) ? 6 : 3;
                    if (bVar.type == 2) {
                        i5 = 4;
                    } else if (bVar.type == 5) {
                        i5 = 1;
                    }
                    ry ryVar = new ry();
                    ryVar.dYw.context = getContext();
                    ryVar.dYw.scene = 1;
                    ryVar.dYw.dNI = bVar.appId;
                    ryVar.dYw.packageName = o == null ? null : o.field_packageName;
                    ryVar.dYw.msgType = bVar.type;
                    ryVar.dYw.dRL = str4;
                    ryVar.dYw.dYx = i5;
                    ryVar.dYw.mediaTagName = bVar.mediaTagName;
                    ryVar.dYw.dTS = j5;
                    ryVar.dYw.dYy = "";
                    ryVar.dYw.dCw = this.talker;
                    EventCenter.instance.publish(ryVar);
                    com.tencent.mm.plugin.game.api.b dSQ = b.a.dSQ();
                    if (com.tencent.mm.pluginsdk.model.app.h.a(getContext(), o) || dSQ == null) {
                        z2 = false;
                    } else {
                        if (!Util.isNullOrNil(o.fmK)) {
                            boolean ck = r.ck(getContext(), o.fmK);
                            Log.i("MicroMsg.GalleryGridUI", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", o.fmK, Boolean.valueOf(ck));
                            if (ck) {
                                z2 = true;
                            }
                        }
                        is isVar = new is();
                        isVar.dNr.actionCode = 2;
                        isVar.dNr.scene = 1;
                        isVar.dNr.appId = o.field_appId;
                        isVar.dNr.context = getContext();
                        EventCenter.instance.publish(isVar);
                        new Intent();
                        getContext();
                        dSQ.am(o.field_appId, 1, 1);
                        z2 = true;
                    }
                    if (!z2) {
                        if (bVar.dCK == null || bVar.dCK.length() == 0) {
                            String str5 = caVar.field_content;
                            if (caVar.field_isSend == 0) {
                                int i6 = caVar.field_isSend;
                                if (!this.tca && ab.Eq(this.talker) && str5 != null && i6 == 0) {
                                    str5 = bp.Kt(str5);
                                }
                            }
                            k.b HD = k.b.HD(str5);
                            g o2 = com.tencent.mm.pluginsdk.model.app.h.o(HD.appId, true, false);
                            if (o2 == null || !com.tencent.mm.pluginsdk.model.app.q.s(getContext(), o2.field_packageName)) {
                                String R3 = com.tencent.mm.pluginsdk.model.app.q.R(getContext(), HD.appId, "message");
                                Intent intent3 = new Intent();
                                intent3.putExtra("rawUrl", R3);
                                com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", intent3);
                            } else if (o2.field_status == 3) {
                                Log.e("MicroMsg.GalleryGridUI", "requestAppShow fail, app is in blacklist, packageName = " + o2.field_packageName);
                            } else if (!com.tencent.mm.pluginsdk.model.app.q.b(getContext(), o2)) {
                                Log.e("MicroMsg.GalleryGridUI", "The app %s signature is incorrect.", o2.field_appName);
                                Toast.makeText(getContext(), getString(R.string.dpi, new Object[]{com.tencent.mm.pluginsdk.model.app.h.a(getContext(), o2, (String) null)}), 1).show();
                            } else if (!a(caVar, o2)) {
                                WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
                                wXAppExtendObject.extInfo = HD.extInfo;
                                if (HD.dCK != null && HD.dCK.length() > 0) {
                                    com.tencent.mm.pluginsdk.model.app.c bdx = ao.cgO().bdx(HD.dCK);
                                    wXAppExtendObject.filePath = bdx == null ? null : bdx.field_fileFullPath;
                                }
                                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                                wXMediaMessage.sdkVer = Build.SDK_INT;
                                wXMediaMessage.mediaObject = wXAppExtendObject;
                                wXMediaMessage.title = HD.title;
                                wXMediaMessage.description = HD.description;
                                wXMediaMessage.messageAction = HD.messageAction;
                                wXMediaMessage.messageExt = HD.messageExt;
                                wXMediaMessage.thumbData = s.aW(q.bcR().Oz(caVar.field_imgPath), 0, -1);
                                new au(this).a(o2.field_packageName, wXMediaMessage, o2.field_appId, o2.field_openId);
                            }
                        } else if (!this.qoo) {
                            u.g(getContext(), null);
                        } else {
                            Intent intent4 = new Intent();
                            intent4.setClassName(getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                            intent4.putExtra("app_msg_id", caVar.field_msgId);
                            startActivityForResult(intent4, 210);
                        }
                    }
                }
            } else if (caVar.cWJ() || caVar.gAz() || caVar.cWL() || caVar.gDr()) {
                if (bVar == null || Util.isNullOrNil(bVar.iyZ)) {
                    z = false;
                } else {
                    String str6 = caVar.field_imgPath;
                    Intent intent5 = new Intent();
                    intent5.putExtra("KFromTimeLine", false);
                    intent5.putExtra("KStremVideoUrl", bVar.iyZ);
                    intent5.putExtra("KThumUrl", bVar.ize);
                    intent5.putExtra("KThumbPath", str6);
                    intent5.putExtra("KMediaId", "fakeid_" + caVar.field_msgId);
                    intent5.putExtra("KMediaVideoTime", bVar.iza);
                    intent5.putExtra("StremWebUrl", bVar.izd);
                    intent5.putExtra("StreamWording", bVar.izc);
                    intent5.putExtra("KMediaTitle", bVar.title);
                    String str7 = caVar.field_talker;
                    boolean Eq = ab.Eq(str7);
                    String Ks = Eq ? bp.Ks(caVar.field_content) : str7;
                    intent5.putExtra("KSta_StremVideoAduxInfo", bVar.izf);
                    intent5.putExtra("KSta_StremVideoPublishId", bVar.izg);
                    intent5.putExtra("KSta_SourceType", 1);
                    if (Eq) {
                        i3 = a.b.TalkChat.value;
                    } else {
                        i3 = a.b.Chat.value;
                    }
                    intent5.putExtra("KSta_Scene", i3);
                    intent5.putExtra("KSta_FromUserName", Ks);
                    intent5.putExtra("KSta_ChatName", str7);
                    intent5.putExtra("KSta_MsgId", caVar.field_msgSvrId);
                    intent5.putExtra("KSta_SnsStatExtStr", bVar.ean);
                    if (Eq) {
                        intent5.putExtra("KSta_ChatroomMembercount", v.Ie(str7));
                    }
                    if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ad_landing_page_new_stream_video, 0) > 0) {
                        com.tencent.mm.br.c.b(getContext(), "sns", ".ui.SnsAdStreamVideoPlayUI", intent5);
                        Log.i("MicroMsg.GalleryGridUI", "use new stream video play UI");
                    } else {
                        com.tencent.mm.br.c.b(getContext(), "sns", ".ui.VideoAdPlayerUI", intent5);
                    }
                    z = true;
                }
                if (z) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(35975);
                    return;
                }
                aK(view, i2);
            } else if (bVar != null && bVar.type == 15) {
                String str8 = bVar.ixo;
                if (TextUtils.isEmpty(str8)) {
                    str8 = ((d) com.tencent.mm.kernel.g.ah(d.class)).getEmojiMgr().ams(bVar.url);
                }
                if (TextUtils.isEmpty(str8)) {
                    Intent intent6 = new Intent();
                    intent6.putExtra("geta8key_username", com.tencent.mm.model.z.aTY());
                    intent6.putExtra("rawUrl", bVar.url);
                    com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", intent6);
                } else {
                    Log.d("MicroMsg.GalleryGridUI", "start emoji detail from brandcontact");
                    Intent intent7 = new Intent();
                    intent7.putExtra("extra_id", str8);
                    intent7.putExtra("preceding_scence", 123);
                    intent7.putExtra("download_entrance_scene", 23);
                    com.tencent.mm.br.c.b(getContext(), "emoji", ".ui.EmojiStoreDetailUI", intent7);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(10993, 2, str8);
                }
            } else if (bVar != null && bVar.type == 26) {
                int i7 = bVar.tid;
                String str9 = bVar.iyW;
                String str10 = bVar.desc;
                String str11 = bVar.iconUrl;
                String str12 = bVar.secondUrl;
                if (i7 != 0) {
                    Intent intent8 = new Intent();
                    intent8.putExtra("geta8key_username", cw(caVar));
                    intent8.putExtra("rawUrl", bVar.fQR);
                    intent8.putExtra("topic_id", i7);
                    intent8.putExtra("topic_name", str9);
                    intent8.putExtra("topic_desc", str10);
                    intent8.putExtra("topic_icon_url", str11);
                    intent8.putExtra("topic_ad_url", str12);
                    intent8.putExtra("extra_scence", 23);
                    com.tencent.mm.br.c.b(getContext(), "emoji", ".ui.EmojiStoreTopicUI", intent8);
                } else {
                    Log.i("MicroMsg.GalleryGridUI", "topic id is zero.");
                }
            } else if (bVar == null || bVar.type != 27) {
                Log.i("MicroMsg.GalleryGridUI", "talker:%s, msgId:%s, msgType:%s, msgContent:%s", caVar.field_talker, Long.valueOf(caVar.field_msgId), Integer.valueOf(caVar.getType()), caVar.field_content);
                if (bVar.url != null && !bVar.url.equals("") && bVar.url != null && !bVar.url.equals("")) {
                    String R4 = com.tencent.mm.pluginsdk.model.app.q.R(bVar.url, ab.Eq(this.talker) ? "groupmessage" : "singlemessage");
                    String str13 = bVar.url;
                    PackageInfo packageInfo2 = getPackageInfo(getContext(), bVar.appId);
                    Intent intent9 = new Intent();
                    intent9.putExtra("rawUrl", R4);
                    intent9.putExtra("webpageTitle", bVar.title);
                    if (bVar.appId != null && ("wx751a1acca5688ba3".equals(bVar.appId) || "wxfbc915ff7c30e335".equals(bVar.appId) || "wx482a4001c37e2b74".equals(bVar.appId))) {
                        Bundle bundle = new Bundle();
                        bundle.putString("jsapi_args_appid", bVar.appId);
                        intent9.putExtra("jsapiargs", bundle);
                    }
                    if (!Util.isNullOrNil(str13)) {
                        intent9.putExtra("shortUrl", str13);
                    } else {
                        intent9.putExtra("shortUrl", bVar.url);
                    }
                    intent9.putExtra("version_name", packageInfo2 == null ? null : packageInfo2.versionName);
                    intent9.putExtra("version_code", packageInfo2 == null ? 0 : packageInfo2.versionCode);
                    if (!Util.isNullOrNil(bVar.eag)) {
                        intent9.putExtra("srcUsername", bVar.eag);
                        intent9.putExtra("srcDisplayname", bVar.eah);
                    }
                    intent9.putExtra("msg_id", caVar.field_msgId);
                    intent9.putExtra("KPublisherId", "msg_" + Long.toString(caVar.field_msgSvrId));
                    intent9.putExtra("KAppId", bVar.appId);
                    intent9.putExtra("geta8key_username", com.tencent.mm.model.z.aTY());
                    intent9.putExtra("pre_username", cw(caVar));
                    intent9.putExtra("prePublishId", "msg_" + Long.toString(caVar.field_msgSvrId));
                    String cw2 = cw(caVar);
                    String aTY = com.tencent.mm.model.z.aTY();
                    intent9.putExtra("preUsername", cw2);
                    intent9.putExtra("preChatName", aTY);
                    intent9.putExtra("preChatTYPE", ac.aJ(cw2, aTY));
                    intent9.putExtra("preMsgIndex", 0);
                    com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", intent9);
                }
            } else {
                int i8 = bVar.tid;
                String str14 = bVar.iyW;
                String str15 = bVar.desc;
                String str16 = bVar.iconUrl;
                String str17 = bVar.secondUrl;
                int i9 = bVar.pageType;
                if (i8 != 0) {
                    Intent intent10 = new Intent();
                    intent10.putExtra("geta8key_username", cw(caVar));
                    intent10.putExtra("rawUrl", bVar.fQR);
                    intent10.putExtra("set_id", i8);
                    intent10.putExtra("set_title", str14);
                    intent10.putExtra("set_iconURL", str16);
                    intent10.putExtra("set_desc", str15);
                    intent10.putExtra("headurl", str17);
                    intent10.putExtra("pageType", i9);
                    com.tencent.mm.br.c.b(getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent10);
                } else {
                    Log.i("MicroMsg.GalleryGridUI", "topic id is zero.");
                }
            }
        } else if (bVar.url != null && !bVar.url.equals("")) {
            String R5 = com.tencent.mm.pluginsdk.model.app.q.R(bVar.url, ab.Eq(this.talker) ? "groupmessage" : "singlemessage");
            String str18 = bVar.url;
            PackageInfo packageInfo3 = getPackageInfo(getContext(), bVar.appId);
            Intent intent11 = new Intent();
            intent11.putExtra("rawUrl", R5);
            intent11.putExtra("webpageTitle", bVar.title);
            if (bVar.appId != null && ("wx751a1acca5688ba3".equals(bVar.appId) || "wxfbc915ff7c30e335".equals(bVar.appId) || "wx482a4001c37e2b74".equals(bVar.appId))) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("jsapi_args_appid", bVar.appId);
                intent11.putExtra("jsapiargs", bundle2);
            }
            if (!Util.isNullOrNil(str18)) {
                intent11.putExtra("shortUrl", str18);
            } else {
                intent11.putExtra("shortUrl", bVar.url);
            }
            intent11.putExtra("version_name", packageInfo3 == null ? null : packageInfo3.versionName);
            intent11.putExtra("version_code", packageInfo3 == null ? 0 : packageInfo3.versionCode);
            if (!Util.isNullOrNil(bVar.eag)) {
                intent11.putExtra("srcUsername", bVar.eag);
                intent11.putExtra("srcDisplayname", bVar.eah);
            }
            intent11.putExtra("msg_id", caVar.field_msgId);
            intent11.putExtra("KPublisherId", "msg_" + Long.toString(caVar.field_msgSvrId));
            intent11.putExtra("KAppId", bVar.appId);
            intent11.putExtra("geta8key_username", this.talker);
            String cw3 = cw(caVar);
            intent11.putExtra("pre_username", cw3);
            intent11.putExtra("prePublishId", "msg_" + Long.toString(caVar.field_msgSvrId));
            intent11.putExtra("preUsername", cw3);
            intent11.putExtra("preChatName", this.talker);
            intent11.putExtra("preChatTYPE", ac.aJ(cw3, this.talker));
            intent11.putExtra("preMsgIndex", 0);
            com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", intent11);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(35975);
    }

    private static String bs(Context context, String str) {
        String str2;
        AppMethodBeat.i(35977);
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo next = packageManager.queryIntentActivities(intent, 0).iterator().next();
            if (next != null) {
                str2 = next.activityInfo.name;
                AppMethodBeat.o(35977);
                return str2;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            Log.printErrStackTrace("MicroMsg.GalleryGridUI", e2, "", new Object[0]);
        }
        str2 = null;
        AppMethodBeat.o(35977);
        return str2;
    }

    private String cw(ca caVar) {
        String str;
        AppMethodBeat.i(35978);
        String nullAs = Util.nullAs(this.talker, "");
        boolean Eq = ab.Eq(this.talker);
        if (!Eq) {
            AppMethodBeat.o(35978);
            return nullAs;
        }
        if (!Eq || (str = bp.Ks(caVar.field_content)) == null || str.length() <= 0) {
            str = nullAs;
        }
        AppMethodBeat.o(35978);
        return str;
    }

    private boolean gSk() {
        AppMethodBeat.i(35980);
        long currentTimeMillis = System.currentTimeMillis();
        this.Pwr = currentTimeMillis;
        if (this.Pwr + 30000 < currentTimeMillis) {
            bg.aVF();
            this.qoo = com.tencent.mm.model.c.isSDCardAvailable();
        }
        boolean z = this.qoo;
        AppMethodBeat.o(35980);
        return z;
    }

    private void cx(ca caVar) {
        AppMethodBeat.i(35981);
        if (!gSk()) {
            u.g(getContext(), null);
            AppMethodBeat.o(35981);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
        intent.putExtra("app_msg_id", caVar.field_msgId);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "enterAppMsgShow", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "enterAppMsgShow", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(35981);
    }

    private void aK(View view, int i2) {
        AppMethodBeat.i(35982);
        if (this.Pxr == null) {
            AppMethodBeat.o(35982);
            return;
        }
        Log.i("MicroMsg.GalleryGridUI", "[ImageGalleryUI] enter");
        Intent intent = new Intent(this, ImageGalleryUI.class);
        intent.putExtra("key_biz_chat_id", this.ppv);
        intent.putExtra("key_is_biz_chat", this.tca);
        intent.putExtra("intent.key.with.footer", true);
        ca caVar = (ca) this.Pxr.getItem(i2);
        if (caVar == null) {
            AppMethodBeat.o(35982);
            return;
        }
        int i3 = getResources().getConfiguration().orientation;
        int i4 = 0;
        int i5 = 0;
        int[] iArr = new int[2];
        if (view != null) {
            i4 = view.getWidth();
            i5 = view.getHeight();
            view.getLocationInWindow(iArr);
        }
        intent.addFlags(536870912);
        intent.putExtra("img_gallery_msg_id", caVar.field_msgId).putExtra("img_gallery_msg_svr_id", caVar.field_msgSvrId).putExtra("img_gallery_talker", caVar.field_talker).putExtra("img_gallery_chatroom_name", caVar.field_talker).putExtra("img_gallery_orientation", i3);
        if (view != null) {
            intent.putExtra("img_gallery_width", i4).putExtra("img_gallery_height", i5).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]).putExtra("img_gallery_enter_from_grid", true);
        } else {
            intent.putExtra("img_gallery_back_from_grid", true);
        }
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "enterGallery", "(Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "enterGallery", "(Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        overridePendingTransition(0, 0);
        AppMethodBeat.o(35982);
    }

    public boolean onPreDraw() {
        AppMethodBeat.i(35983);
        c.a aVar = this.Pxs.get();
        if (aVar == null) {
            AppMethodBeat.o(35983);
        } else {
            ViewTreeObserver viewTreeObserver = aVar.tkI.getViewTreeObserver();
            if (!viewTreeObserver.isAlive()) {
                AppMethodBeat.o(35983);
            } else {
                viewTreeObserver.removeOnPreDrawListener(this);
                int measuredWidth = aVar.tkI.getMeasuredWidth();
                int measuredHeight = aVar.tkI.getMeasuredHeight();
                if (measuredWidth <= 0 || measuredHeight <= 0) {
                    AppMethodBeat.o(35983);
                } else {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) aVar.tkK.getLayoutParams();
                    ((ViewGroup.LayoutParams) layoutParams).width = measuredWidth;
                    ((ViewGroup.LayoutParams) layoutParams).height = measuredHeight;
                    aVar.tkK.setLayoutParams(layoutParams);
                    final ImageView imageView = aVar.tkK;
                    final DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
                    if (Build.VERSION.SDK_INT >= 12) {
                        this.PxA = imageView;
                        this.handler.postDelayed(new Runnable() {
                            /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI.AnonymousClass7 */

                            public final void run() {
                                AppMethodBeat.i(35960);
                                if (Build.VERSION.SDK_INT >= 16) {
                                    imageView.animate().setDuration(500).alpha(0.0f).withEndAction(ImageGalleryGridUI.this.Pxz).withLayer().setInterpolator(decelerateInterpolator);
                                    AppMethodBeat.o(35960);
                                } else if (ImageGalleryGridUI.this.handler == null) {
                                    AppMethodBeat.o(35960);
                                } else {
                                    imageView.animate().setDuration(500).alpha(0.0f).setInterpolator(decelerateInterpolator);
                                    ImageGalleryGridUI.this.handler.postDelayed(ImageGalleryGridUI.this.Pxz, 500);
                                    AppMethodBeat.o(35960);
                                }
                            }
                        }, 700);
                    }
                    AppMethodBeat.o(35983);
                }
            }
        }
        return true;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        AppMethodBeat.i(35984);
        if (menuItem.getTitle().equals(getString(R.string.dlt))) {
            h.a.Pys.clear();
            cWH();
        } else {
            cWI();
        }
        AppMethodBeat.o(35984);
        return false;
    }

    private void cWH() {
        AppMethodBeat.i(35985);
        setMMTitle(getString(R.string.dn5, new Object[]{Integer.valueOf(h.a.Pys.tkt.size())}));
        h.a.Pys.tku = true;
        if (this.Pxr == null) {
            AppMethodBeat.o(35985);
            return;
        }
        if (this.Dog == null) {
            this.Dog = AnimationUtils.loadAnimation(this, R.anim.dq);
        }
        this.Pxr.cWH();
        this.PxB.setVisibility(0);
        this.PxB.startAnimation(this.Dog);
        this.PxD.setEnabled(false);
        this.PxE.setEnabled(false);
        this.PxF.setEnabled(false);
        this.PxG.setEnabled(false);
        this.PxC = this.EAK.getPaddingBottom();
        this.EAK.setPadding(this.EAK.getPaddingLeft(), this.EAK.getPaddingTop(), this.EAK.getPaddingRight(), com.tencent.mm.cb.a.aG(getContext(), R.dimen.k4));
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11627, 2);
        removeOptionMenu(0);
        addTextOptionMenu(0, getString(R.string.dls), this);
        AppMethodBeat.o(35985);
    }

    private static void jo(List<ca> list) {
        AppMethodBeat.i(35989);
        for (ca caVar : list) {
            com.tencent.mm.ui.chatting.a.a(a.c.Fav, a.d.Samll, caVar, 0);
        }
        AppMethodBeat.o(35989);
    }

    private static List<ca> jt(List<ca> list) {
        AppMethodBeat.i(35990);
        ArrayList arrayList = new ArrayList();
        for (ca caVar : list) {
            if (!b.cn(caVar) && !b.co(caVar) && !b.cq(caVar)) {
                arrayList.add(caVar);
            }
        }
        AppMethodBeat.o(35990);
        return arrayList;
    }

    private void c(cz czVar) {
        AppMethodBeat.i(35991);
        czVar.dFZ.activity = this;
        czVar.dFZ.dGf = 45;
        EventCenter.instance.publish(czVar);
        if (czVar.dGa.ret == -2 || czVar.dGa.ret > 0) {
            AppMethodBeat.o(35991);
            return;
        }
        if (czVar.dGa.ret <= 0) {
            cWI();
            if (14 != czVar.dFZ.type) {
                Log.d("MicroMsg.GalleryGridUI", "not record type, do not report");
                AppMethodBeat.o(35991);
                return;
            } else if (czVar.dFZ.dGc == null) {
                Log.e("MicroMsg.GalleryGridUI", "want to report record fav, but type count is null");
                AppMethodBeat.o(35991);
                return;
            } else {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11142, Integer.valueOf(czVar.dFZ.dGc.Lyp), Integer.valueOf(czVar.dFZ.dGc.Lyq), Integer.valueOf(czVar.dFZ.dGc.Lyr), Integer.valueOf(czVar.dFZ.dGc.xiP), Integer.valueOf(czVar.dFZ.dGc.Lys), Integer.valueOf(czVar.dFZ.dGc.Lyt), Integer.valueOf(czVar.dFZ.dGc.Lyu), Integer.valueOf(czVar.dFZ.dGc.fileCount), Integer.valueOf(czVar.dFZ.dGc.Lyv), Integer.valueOf(czVar.dFZ.dGc.Lyw), Integer.valueOf(czVar.dFZ.dGc.Lyx), Integer.valueOf(czVar.dFZ.dGc.Lyy), Integer.valueOf(czVar.dFZ.dGc.Lyz), Integer.valueOf(czVar.dFZ.dGc.LyA), Integer.valueOf(czVar.dFZ.dGc.LyB));
            }
        }
        AppMethodBeat.o(35991);
    }

    @Override // com.tencent.mm.ui.chatting.gallery.h.b
    public final void gSm() {
        AppMethodBeat.i(35992);
        if (this.Pxr != null && this.mIsPause) {
            this.Pxr.Pxj = true;
        }
        setMMTitle(getString(R.string.dn5, new Object[]{Integer.valueOf(h.a.Pys.tkt.size())}));
        gSl();
        AppMethodBeat.o(35992);
    }

    @Override // com.tencent.mm.ui.chatting.gallery.h.b
    public final void clear() {
        AppMethodBeat.i(35993);
        if (this.Pxr != null && this.mIsPause) {
            this.Pxr.Pxj = true;
        }
        gSl();
        AppMethodBeat.o(35993);
    }

    @Override // com.tencent.mm.ag.z
    public final void a(z.a aVar) {
    }

    @Override // com.tencent.mm.ag.z
    public final void b(z.a aVar) {
    }

    @Override // com.tencent.mm.ag.z
    public final boolean aSC() {
        return true;
    }

    @Override // com.tencent.mm.ag.z
    public final boolean aSD() {
        return false;
    }

    @Override // com.tencent.mm.ag.z
    public final boolean aSE() {
        return false;
    }

    @Override // com.tencent.mm.ag.z
    public final void B(Bundle bundle) {
    }

    @Override // com.tencent.mm.ag.z
    public final void c(z.a aVar) {
        AppMethodBeat.i(35994);
        if (aVar == z.a.del) {
            this.Pxr.anp();
            this.Pxr.notifyDataSetChanged();
        }
        cWI();
        AppMethodBeat.o(35994);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(35967);
        h.a.Pys.a(this);
        this.mIsPause = false;
        if (this.tkg) {
            if (h.a.Pys.tku) {
                cWH();
            } else {
                cWI();
            }
        }
        this.handler.postDelayed(this.Pxy, 300);
        super.onResume();
        if (this.Pxr != null) {
            this.Pxr.Pxj = true;
            c cVar = this.Pxr;
            if (cVar.Pxj) {
                cVar.notifyDataSetChanged();
            }
            if (h.a.Pys.tku) {
                setMMTitle(getString(R.string.dn5, new Object[]{Integer.valueOf(h.a.Pys.tkt.size())}));
            }
        }
        this.tkg = false;
        gSl();
        AppMethodBeat.o(35967);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(35968);
        h.a.Pys.tkv.remove(this);
        this.mIsPause = true;
        super.onPause();
        AppMethodBeat.o(35968);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(35971);
        if (h.a.Pys.tku) {
            cWI();
            AppMethodBeat.o(35971);
        } else if (this.Pxt.booleanValue()) {
            super.onBackPressed();
            AppMethodBeat.o(35971);
        } else {
            if (this.Pxq >= 0) {
                aK(null, this.Pxq);
            }
            finish();
            AppMethodBeat.o(35971);
        }
    }

    private boolean a(ca caVar, g gVar) {
        int i2;
        AppMethodBeat.i(35976);
        if (!caVar.field_talker.endsWith("@qqim") || !gVar.field_packageName.equals(TbsConfig.APP_QQ)) {
            AppMethodBeat.o(35976);
            return false;
        }
        Log.d("MicroMsg.GalleryGridUI", "jacks open QQ");
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.addFlags(268435456);
        intent.setClassName(TbsConfig.APP_QQ, bs(getContext(), TbsConfig.APP_QQ));
        intent.putExtra(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, "wechat");
        bg.aVF();
        Object obj = com.tencent.mm.model.c.azQ().get(9, (Object) null);
        if (obj == null || !(obj instanceof Integer)) {
            i2 = 0;
        } else {
            i2 = ((Integer) obj).intValue();
        }
        if (i2 != 0) {
            try {
                byte[] bytes = String.valueOf(i2).getBytes(ProtocolPackage.ServerEncoding);
                byte[] bytes2 = "asdfghjkl;'".getBytes(ProtocolPackage.ServerEncoding);
                int length = bytes2.length;
                int i3 = 0;
                int i4 = 0;
                while (i3 < length) {
                    byte b2 = bytes2[i3];
                    if (i4 >= bytes.length) {
                        break;
                    }
                    bytes[i4] = (byte) (b2 ^ bytes[i4]);
                    i3++;
                    i4++;
                }
                intent.putExtra("tencent_gif", bytes);
            } catch (UnsupportedEncodingException e2) {
                Log.printErrStackTrace("MicroMsg.GalleryGridUI", e2, "", new Object[0]);
            }
        }
        try {
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        } catch (Exception e3) {
        }
        AppMethodBeat.o(35976);
        return true;
    }

    private static PackageInfo getPackageInfo(Context context, String str) {
        String str2;
        PackageInfo packageInfo = null;
        AppMethodBeat.i(35979);
        if (str == null || str.length() == 0) {
            str2 = null;
        } else {
            g o = com.tencent.mm.pluginsdk.model.app.h.o(str, true, false);
            str2 = o == null ? null : o.field_packageName;
        }
        if (str2 == null) {
            AppMethodBeat.o(35979);
        } else {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
                AppMethodBeat.o(35979);
            } catch (PackageManager.NameNotFoundException e2) {
                Log.printErrStackTrace("MicroMsg.GalleryGridUI", e2, "", new Object[0]);
                AppMethodBeat.o(35979);
            }
        }
        return packageInfo;
    }

    private void gSl() {
        AppMethodBeat.i(35986);
        if (!h.a.Pys.tkt.isEmpty() && h.a.Pys.tku) {
            this.PxD.setEnabled(true);
            this.PxE.setEnabled(true);
            this.PxF.setEnabled(true);
            this.PxG.setEnabled(true);
            AppMethodBeat.o(35986);
            return;
        }
        this.PxD.setEnabled(false);
        this.PxE.setEnabled(false);
        this.PxF.setEnabled(false);
        this.PxG.setEnabled(false);
        AppMethodBeat.o(35986);
    }

    public final void cWI() {
        AppMethodBeat.i(35987);
        h.a.Pys.tku = false;
        setMMTitle(getString(R.string.gs));
        if (this.Pxr == null) {
            AppMethodBeat.o(35987);
            return;
        }
        this.Pxr.notifyDataSetChanged();
        if (this.PxC >= 0) {
            this.EAK.setPadding(this.EAK.getPaddingLeft(), this.EAK.getPaddingTop(), this.EAK.getPaddingRight(), this.PxC);
        }
        this.PxB.setVisibility(8);
        removeOptionMenu(0);
        addTextOptionMenu(0, getString(R.string.dlt), this);
        AppMethodBeat.o(35987);
    }

    public void onClick(View view) {
        String string;
        AppMethodBeat.i(35988);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (h.a.Pys.tkt.isEmpty()) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35988);
            return;
        }
        boolean Eq = ab.Eq(this.talker);
        final ArrayList<ca> arrayList = h.a.Pys.tkt;
        if (arrayList == null || arrayList.isEmpty()) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(35988);
            return;
        }
        if (view.getId() == R.id.blh) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11627, 5);
            final TreeSet treeSet = new TreeSet();
            for (ca caVar : arrayList) {
                treeSet.add(Long.valueOf(caVar.field_msgId));
            }
            com.tencent.mm.ui.base.h.c(this, getString(R.string.b91), "", getString(R.string.blj), getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI.AnonymousClass9 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(35962);
                    Log.i("MicroMsg.GalleryGridUI", "delete message");
                    j.a(ImageGalleryGridUI.this, treeSet, ImageGalleryGridUI.this);
                    ImageGalleryGridUI.this.cWI();
                    AppMethodBeat.o(35962);
                }
            }, null);
        } else if (view.getId() == R.id.cb4) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(219, 18, 1, true);
            final cz czVar = new cz();
            if (com.tencent.mm.pluginsdk.model.j.a(getContext(), czVar, this.talker, arrayList, false)) {
                c(czVar);
                jo(arrayList);
            } else if (arrayList.size() > 1) {
                AppCompatActivity context = getContext();
                String string2 = czVar.dFZ.dGe >= 0 ? getContext().getString(R.string.c_f) : getContext().getString(R.string.c_e);
                if (czVar.dFZ.dGe >= 0) {
                    string = getContext().getString(R.string.b98);
                } else {
                    string = getContext().getString(R.string.fn9);
                }
                com.tencent.mm.ui.base.h.c(context, string2, "", string, getContext().getString(R.string.b96), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI.AnonymousClass10 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(35963);
                        if (czVar.dFZ.type == 14 && czVar.dFZ.dGb.ppH.size() == 0) {
                            ImageGalleryGridUI.this.cWI();
                            AppMethodBeat.o(35963);
                            return;
                        }
                        ImageGalleryGridUI.a(ImageGalleryGridUI.this, czVar);
                        ImageGalleryGridUI.ju(arrayList);
                        AppMethodBeat.o(35963);
                    }
                }, null);
            } else {
                com.tencent.mm.ui.base.h.n(getContext(), czVar.dFZ.dGe, 0);
            }
        } else if (view.getId() == R.id.iuu) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(219, 19, 1, true);
            l.a(this, arrayList, Eq, this.talker, this);
            cWI();
        } else {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11627, 3);
            final List<ca> jt = jt(arrayList);
            if (jt.size() != arrayList.size()) {
                com.tencent.mm.ui.base.h.a(getContext(), (int) R.string.dmo, (int) R.string.zb, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(35951);
                        b.f(ImageGalleryGridUI.this.getContext(), jt);
                        ImageGalleryGridUI.this.cWI();
                        AppMethodBeat.o(35951);
                    }
                }, (DialogInterface.OnClickListener) null);
            } else {
                ca caVar2 = jt.get(0);
                if (arrayList.size() != 1 || caVar2 == null || !caVar2.dOQ()) {
                    b.f(this, arrayList);
                    cWI();
                } else {
                    String str = caVar2.field_content;
                    k.b bVar2 = null;
                    if (str != null) {
                        bVar2 = k.b.aD(str, caVar2.field_reserved);
                    }
                    if (bVar2 != null && bVar2.type == 6) {
                        cx(caVar2);
                    }
                }
            }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(35988);
    }

    static /* synthetic */ void a(ImageGalleryGridUI imageGalleryGridUI, int i2, ir irVar) {
        View childAt;
        AppMethodBeat.i(35995);
        if (imageGalleryGridUI.EAK != null) {
            int firstVisiblePosition = imageGalleryGridUI.EAK.getFirstVisiblePosition();
            int lastVisiblePosition = imageGalleryGridUI.EAK.getLastVisiblePosition();
            if (i2 >= firstVisiblePosition && i2 <= lastVisiblePosition && (childAt = imageGalleryGridUI.EAK.getChildAt(i2 - firstVisiblePosition)) != null) {
                int[] iArr = new int[2];
                childAt.getLocationInWindow(iArr);
                irVar.dNn.dEq = iArr[0];
                irVar.dNn.dEr = iArr[1];
                irVar.dNn.dEs = childAt.getWidth();
                irVar.dNn.dEt = childAt.getHeight();
            }
        }
        AppMethodBeat.o(35995);
    }
}
