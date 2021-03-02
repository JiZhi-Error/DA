package com.tencent.mm.plugin.sns.ui;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.i;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.aa;
import com.tencent.mm.g.a.pb;
import com.tencent.mm.g.a.uz;
import com.tencent.mm.g.a.vc;
import com.tencent.mm.g.a.vf;
import com.tencent.mm.g.c.f;
import com.tencent.mm.plugin.fav.a.v;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.ad.landingpage.component.a.b;
import com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.FloatJumpCompHelper;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistCoverView;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdlandingRemoteServiceConnectedReceiver;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aq;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aj;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdlandingDummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.b.c;
import com.tencent.mm.plugin.sns.ui.b.d;
import com.tencent.mm.plugin.sns.ui.b.e;
import com.tencent.mm.plugin.sns.ui.helper.FloatWebViewHelper;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView;
import com.tencent.mm.protocal.protobuf.bq;
import com.tencent.mm.protocal.protobuf.eco;
import com.tencent.mm.protocal.protobuf.ecp;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.b;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.snackbar.a;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(32)
public class SnsAdNativeLandingPagesUI extends MMActivity {
    private ImageView BQk;
    private ah DJT;
    private int DZU;
    private String DZW;
    private String DZY;
    public long DZZ;
    private SnsInfo DsC;
    private Map<String, String> Eaa = new HashMap();
    private aq Eim;
    public LinkedList<g> Elq = new LinkedList<>();
    private String ExA;
    private String ExB;
    private String ExC;
    private String ExD;
    private ImageView ExE;
    String ExF;
    String ExG;
    private boolean ExH = false;
    k ExI = new k();
    private volatile boolean ExJ = false;
    boolean ExK = false;
    private int ExL = 0;
    private boolean ExM = false;
    private String ExN;
    private String ExO;
    private String ExP;
    private String ExQ;
    private AdlandingDummyViewPager ExR;
    private int ExS;
    private int ExT;
    private MMHandler ExU = new MMHandler();
    private FrameLayout ExV;
    private View ExW;
    private View ExX;
    private boolean ExY = true;
    private List<m> ExZ;
    public ad Exu;
    private ImageView Exv;
    private TextView Exw;
    private boolean Exx = false;
    private boolean Exy = false;
    private String Exz;
    private b EyA;
    private String EyB = "";
    private BroadcastReceiver EyC = new BroadcastReceiver() {
        /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            boolean z = true;
            AppMethodBeat.i(98324);
            int intExtra = com.tencent.mm.plugin.sns.ad.i.g.getIntExtra(intent, "show", 0);
            if (SnsAdNativeLandingPagesUI.this.ExR == null || !(SnsAdNativeLandingPagesUI.this.ExR.getAdapter() instanceof i)) {
                Log.w("MicroMsg.SnsAdNativeLandingPagesUI", "videoProgressbarStatusChangeReceiver called ,but the viewpager or adapter is null!!");
                AppMethodBeat.o(98324);
                return;
            }
            i iVar = (i) SnsAdNativeLandingPagesUI.this.ExR.getAdapter();
            int currentItem = SnsAdNativeLandingPagesUI.this.ExR.getCurrentItem();
            int count = iVar.getCount();
            if (currentItem >= count) {
                Log.w("MicroMsg.SnsAdNativeLandingPagesUI", "videoProgressbarStatusChangeReceiver called ,current index is larger than item count!!!");
                AppMethodBeat.o(98324);
                return;
            }
            Log.d("MicroMsg.SnsAdNativeLandingPagesUI", "recv videoProgressbarStatusChangeReceiver show " + intExtra + "the index is " + currentItem + " the count is " + count);
            ContentFragment contentFragment = (ContentFragment) iVar.getItem(currentItem);
            if (intExtra != 1) {
                z = false;
            }
            SnsAdNativeLandingPagesUI.this.Eyi = z;
            SnsAdNativeLandingPagesUI.this.JC(500);
            contentFragment.vj(z);
            AppMethodBeat.o(98324);
        }
    };
    private BroadcastReceiver EyD = new BroadcastReceiver() {
        /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass12 */

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(98343);
            ap.aK(SnsAdNativeLandingPagesUI.this);
            AppMethodBeat.o(98343);
        }
    };
    private final String EyE = "huawei nxt-al10|mix 2s";
    private ContentFragment.a EyF = new ContentFragment.a() {
        /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass23 */

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.a
        public final void q(final ContentFragment contentFragment) {
            AppMethodBeat.i(98351);
            Log.d("MicroMsg.SnsAdNativeLandingPagesUI.launch", "firstPage afterOnCreateView");
            final RecyclerView recyclerView = contentFragment.getRecyclerView();
            if (recyclerView != null) {
                recyclerView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass23.AnonymousClass1 */

                    public final boolean onPreDraw() {
                        int i2;
                        int i3;
                        AppMethodBeat.i(98350);
                        Log.d("MicroMsg.SnsAdNativeLandingPagesUI.launch", "firstPage onPreDraw");
                        Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "onPreDraw %d, %d", Integer.valueOf(SnsAdNativeLandingPagesUI.this.ExV.getHeight()), Integer.valueOf(SnsAdNativeLandingPagesUI.this.mEY));
                        SnsAdNativeLandingPagesUI.d(SnsAdNativeLandingPagesUI.this);
                        if (SnsAdNativeLandingPagesUI.this.Eyw) {
                            if (SnsAdNativeLandingPagesUI.this.Eyx) {
                                SnsAdNativeLandingPagesUI.this.jUG.setVisibility(8);
                                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(SnsAdNativeLandingPagesUI.this.ExX, "alpha", 0.0f, 1.0f);
                                ofFloat.setDuration(1000L);
                                ofFloat.start();
                            }
                            if (SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this, contentFragment)) {
                                recyclerView.getViewTreeObserver().removeOnPreDrawListener(this);
                                AppMethodBeat.o(98350);
                                return false;
                            }
                        }
                        final Bitmap bitmap = null;
                        aj i4 = SnsAdNativeLandingPagesUI.i(SnsAdNativeLandingPagesUI.this);
                        if (i4 != null) {
                            u fdH = i4.fdH();
                            Bitmap kw = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.kw(fdH != null ? fdH.DWL : "", "scene_ad_landing");
                            StringBuilder append = new StringBuilder("onPreDraw, fullscreen, container.size=").append(SnsAdNativeLandingPagesUI.this.ExX.getWidth()).append(", ").append(SnsAdNativeLandingPagesUI.this.ExX.getHeight()).append(", shootImg.w=");
                            if (kw != null) {
                                i2 = kw.getWidth();
                            } else {
                                i2 = 0;
                            }
                            StringBuilder append2 = append.append(i2).append(", shootImg.h=");
                            if (kw != null) {
                                i3 = kw.getHeight();
                            } else {
                                i3 = 0;
                            }
                            Log.i("SphereImageView.SnsAdNativeLandingPagesUI", append2.append(i3).toString());
                            bitmap = kw;
                        }
                        if (SnsAdNativeLandingPagesUI.this.Exx) {
                            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                                /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass23.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(98349);
                                    Bitmap bitmap = null;
                                    if (bitmap != null) {
                                        bitmap = bitmap;
                                    } else {
                                        try {
                                            if (SnsAdNativeLandingPagesUI.this.Exy) {
                                                bitmap = BitmapUtil.getBitmapFromView(recyclerView.getChildAt(0));
                                                SnsAdNativeLandingPagesUI.this.Exv.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                            } else {
                                                bitmap = BitmapUtil.getBitmapFromView(SnsAdNativeLandingPagesUI.this.ExX);
                                                SnsAdNativeLandingPagesUI.this.Exv.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                            }
                                        } catch (Throwable th) {
                                            Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "getBitmapFromView exp=" + th.toString());
                                        }
                                    }
                                    if (bitmap != null) {
                                        SnsAdNativeLandingPagesUI.this.ExV.setAlpha(1.0f);
                                        SnsAdNativeLandingPagesUI.this.Exv.setImageBitmap(bitmap);
                                        SnsAdNativeLandingPagesUI.a(SnsAdNativeLandingPagesUI.this, recyclerView, bitmap.getWidth(), bitmap.getHeight());
                                        AppMethodBeat.o(98349);
                                        return;
                                    }
                                    SnsAdNativeLandingPagesUI.this.ExV.setAlpha(1.0f);
                                    AppMethodBeat.o(98349);
                                }
                            }, 50);
                        } else {
                            SnsAdNativeLandingPagesUI.this.ExW.setVisibility(0);
                            SnsAdNativeLandingPagesUI.this.JC(300);
                        }
                        recyclerView.getViewTreeObserver().removeOnPreDrawListener(this);
                        AppMethodBeat.o(98350);
                        return false;
                    }
                });
            }
            AppMethodBeat.o(98351);
        }
    };
    private ViewPager.OnPageChangeListener EyG = new ViewPager.f() {
        /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass27 */

        @Override // android.support.v4.view.ViewPager.f, android.support.v4.view.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int i2, float f2, int i3) {
            AppMethodBeat.i(98352);
            super.onPageScrolled(i2, f2, i3);
            if (SnsAdNativeLandingPagesUI.n(SnsAdNativeLandingPagesUI.this) != null) {
                ContentFragment n = SnsAdNativeLandingPagesUI.n(SnsAdNativeLandingPagesUI.this);
                if (n.cQp && n.Eik != null) {
                    n.Eik.fdT();
                }
            }
            if (SnsAdNativeLandingPagesUI.this.keyboardState() == 1) {
                SnsAdNativeLandingPagesUI.this.hideVKB();
            }
            AppMethodBeat.o(98352);
        }

        @Override // android.support.v4.view.ViewPager.f, android.support.v4.view.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int i2) {
            Fragment fragment;
            AppMethodBeat.i(98353);
            super.onPageScrollStateChanged(i2);
            SnsAdNativeLandingPagesUI.n(SnsAdNativeLandingPagesUI.this).Eiu = i2;
            if (i2 == 1) {
                for (int i3 = 0; i3 < SnsAdNativeLandingPagesUI.this.Elq.size(); i3++) {
                    Fragment fragment2 = (Fragment) SnsAdNativeLandingPagesUI.this.EyM.get(Integer.valueOf(SnsAdNativeLandingPagesUI.this.Elq.get(i3).id));
                    if (fragment2 != null) {
                        ((ContentFragment) fragment2).fee();
                    }
                }
                ap.hb(SnsAdNativeLandingPagesUI.this.getContext());
                AppMethodBeat.o(98353);
                return;
            }
            if (i2 == 0 && (fragment = (Fragment) SnsAdNativeLandingPagesUI.this.EyM.get(Integer.valueOf(SnsAdNativeLandingPagesUI.this.Elq.get(SnsAdNativeLandingPagesUI.this.ExR.getCurrentItem()).id))) != null) {
                SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this, (ContentFragment) fragment);
            }
            AppMethodBeat.o(98353);
        }

        @Override // android.support.v4.view.ViewPager.f, android.support.v4.view.ViewPager.OnPageChangeListener
        public final void onPageSelected(int i2) {
            AppMethodBeat.i(98354);
            super.onPageSelected(i2);
            SnsAdNativeLandingPagesUI.this.hideVKB();
            for (int i3 = 0; i3 < SnsAdNativeLandingPagesUI.this.Elq.size(); i3++) {
                Fragment fragment = (Fragment) SnsAdNativeLandingPagesUI.this.EyM.get(Integer.valueOf(SnsAdNativeLandingPagesUI.this.Elq.get(i3).id));
                if (fragment != null) {
                    if (i3 == i2) {
                        SnsAdNativeLandingPagesUI.b(SnsAdNativeLandingPagesUI.this, (ContentFragment) fragment);
                    } else {
                        ((ContentFragment) fragment).fee();
                    }
                }
            }
            SnsAdNativeLandingPagesUI.this.JC(300);
            AppMethodBeat.o(98354);
        }
    };
    private AdLandingPagesProxy.e EyH = new AdLandingPagesProxy.e() {
        /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass28 */

        @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e
        public final void bn(final Object obj) {
            AppMethodBeat.i(98357);
            SnsAdNativeLandingPagesUI.this.ExU.removeCallbacksAndMessages(null);
            SnsAdNativeLandingPagesUI.this.ExU.post(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass28.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(98356);
                    String str = SnsAdNativeLandingPagesUI.this.Exz;
                    String unused = SnsAdNativeLandingPagesUI.this.ExA;
                    String str2 = (String) obj;
                    String unused2 = SnsAdNativeLandingPagesUI.this.aid;
                    String unused3 = SnsAdNativeLandingPagesUI.this.kZe;
                    i.a aVar = new i.a(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.kF(str, str2), SnsAdNativeLandingPagesUI.this.ExA);
                    SnsAdNativeLandingPagesUI.this.Elq = aVar.Elq;
                    SnsAdNativeLandingPagesUI.this.Exu = aVar.Elr;
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass28.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(98355);
                            SnsAdNativeLandingPagesUI.u(SnsAdNativeLandingPagesUI.this);
                            AppMethodBeat.o(98355);
                        }
                    });
                    AppMethodBeat.o(98356);
                }
            });
            AppMethodBeat.o(98357);
        }

        @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e
        public final void h(int i2, int i3, Object obj) {
        }
    };
    private IListener<pb> EyI = new IListener<pb>() {
        /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass29 */

        {
            AppMethodBeat.i(160704);
            this.__eventId = pb.class.getName().hashCode();
            AppMethodBeat.o(160704);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(pb pbVar) {
            AppMethodBeat.i(98358);
            boolean a2 = a(pbVar);
            AppMethodBeat.o(98358);
            return a2;
        }

        private boolean a(pb pbVar) {
            AppMethodBeat.i(176294);
            if (SnsAdNativeLandingPagesUI.n(SnsAdNativeLandingPagesUI.this).Eig.Elj != null && SnsAdNativeLandingPagesUI.n(SnsAdNativeLandingPagesUI.this).Eig.Elj.containsKey(pbVar.dVd.dVe) && !SnsAdNativeLandingPagesUI.this.Eyf.containsKey(pbVar.dVd.dVe)) {
                SnsAdNativeLandingPagesUI.n(SnsAdNativeLandingPagesUI.this).onPause();
                Bundle bundle = new Bundle();
                bundle.putString("sns_landing_pages_xml", SnsAdNativeLandingPagesUI.this.Exz);
                bundle.putString("sns_float_component_id", pbVar.dVd.dVe);
                bundle.putInt("sns_landing_page_index", SnsAdNativeLandingPagesUI.n(SnsAdNativeLandingPagesUI.this).Eig.id);
                bundle.putString("sns_landing_page_snsId", SnsAdNativeLandingPagesUI.this.dRS);
                bundle.putString("sns_landing_pages_rawSnsId", SnsAdNativeLandingPagesUI.this.ExG);
                bundle.putString("sns_landing_pages_ux_info", SnsAdNativeLandingPagesUI.this.uxInfo);
                bundle.putString("sns_landing_pages_aid", SnsAdNativeLandingPagesUI.this.aid);
                bundle.putInt("sns_landing_pages_biz_id", SnsAdNativeLandingPagesUI.this.bizId);
                bundle.putString("sns_landing_pages_traceid", SnsAdNativeLandingPagesUI.this.kZe);
                bundle.putInt("sns_landig_pages_from_source", SnsAdNativeLandingPagesUI.this.source);
                bundle.putString("sns_landing_pages_xml_prefix", SnsAdNativeLandingPagesUI.this.ExA);
                bundle.putBoolean("sns_landing_is_native_sight_ad", SnsAdNativeLandingPagesUI.this.ExH);
                bundle.putString("sns_landing_pages_canvas_ext", SnsAdNativeLandingPagesUI.this.adCanvasExtXml);
                SnsAdLandingPageFloatView snsAdLandingPageFloatView = new SnsAdLandingPageFloatView(SnsAdNativeLandingPagesUI.this);
                String string = bundle.getString("sns_landing_pages_xml");
                snsAdLandingPageFloatView.dVe = bundle.getString("sns_float_component_id");
                int i2 = bundle.getInt("sns_landing_page_index", -1);
                String string2 = bundle.getString("sns_landing_pages_ux_info");
                String string3 = bundle.getString("sns_landing_pages_aid");
                String string4 = bundle.getString("sns_landing_pages_traceid");
                snsAdLandingPageFloatView.adCanvasExtXml = bundle.getString("sns_landing_pages_canvas_ext");
                if (Util.isNullOrNil(string, snsAdLandingPageFloatView.dVe) || i2 == -1) {
                    Log.e("MicroMsg.SnsAdLandingPageFloatView", "invalid landing float page data!");
                } else {
                    LinkedList<g> linkedList = new i.a(string, Util.nullAs(bundle.getString("sns_landing_pages_xml_prefix"), f.COL_ADXML)).Elq;
                    if (linkedList != null && linkedList.size() > i2) {
                        g gVar = linkedList.get(i2);
                        snsAdLandingPageFloatView.Fem = new g();
                        snsAdLandingPageFloatView.Fem.lco = gVar.lco;
                        z zVar = gVar.Elj.get(snsAdLandingPageFloatView.dVe);
                        if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.Zm(zVar.type)) {
                            snsAdLandingPageFloatView.Fel = (x) zVar;
                            snsAdLandingPageFloatView.Fem.Eli.add(snsAdLandingPageFloatView.Fel);
                            snsAdLandingPageFloatView.Fem.Elj.putAll(gVar.Elj);
                        }
                        snsAdLandingPageFloatView.Fem.id = 0;
                        snsAdLandingPageFloatView.Fem.Elk = true;
                    }
                    Log.i("MicroMsg.SnsAdLandingPageFloatView", "[reportInfo] aid %s,traceId %s,uxInfo %s,adCanvasExtXml %s", string3, string4, string2, snsAdLandingPageFloatView.adCanvasExtXml);
                    snsAdLandingPageFloatView.initView();
                }
                snsAdLandingPageFloatView.setBackgroundColor(SnsAdNativeLandingPagesUI.this.getResources().getColor(R.color.a86));
                SnsAdNativeLandingPagesUI.this.ExV.addView(snsAdLandingPageFloatView, SnsAdNativeLandingPagesUI.this.ExV.getChildCount() - 1, new FrameLayout.LayoutParams(-1, -1));
                snsAdLandingPageFloatView.flb();
                SnsAdNativeLandingPagesUI.n(SnsAdNativeLandingPagesUI.this).fee();
                SnsAdNativeLandingPagesUI.this.k(false, 0);
                SnsAdNativeLandingPagesUI.this.Eyf.put(pbVar.dVd.dVe, snsAdLandingPageFloatView);
            }
            AppMethodBeat.o(176294);
            return false;
        }
    };
    private IListener<uz> EyJ = new IListener<uz>() {
        /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass30 */

        {
            AppMethodBeat.i(160705);
            this.__eventId = uz.class.getName().hashCode();
            AppMethodBeat.o(160705);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(uz uzVar) {
            AppMethodBeat.i(98359);
            uz uzVar2 = uzVar;
            String str = uzVar2.ebq.ebr;
            switch (uzVar2.ebq.state) {
                case 123:
                    if (!Util.isNullOrNil(str) && SnsAdNativeLandingPagesUI.this.Eyf.containsKey(str)) {
                        SnsAdNativeLandingPagesUI.this.ExV.removeView((View) SnsAdNativeLandingPagesUI.this.Eyf.get(str));
                        SnsAdNativeLandingPagesUI.this.onResume();
                        SnsAdNativeLandingPagesUI.n(SnsAdNativeLandingPagesUI.this).onResume();
                        break;
                    }
            }
            AppMethodBeat.o(98359);
            return false;
        }
    };
    private Runnable EyK = new Runnable() {
        /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass7 */

        public final void run() {
            AppMethodBeat.i(98336);
            SnsAdNativeLandingPagesUI.this.Eyo = true;
            if (!SnsAdNativeLandingPagesUI.this.Eyn && SnsAdNativeLandingPagesUI.this.isVisible) {
                SnsAdNativeLandingPagesUI.Q(SnsAdNativeLandingPagesUI.this);
            }
            AppMethodBeat.o(98336);
        }
    };
    private ScreenShotUtil.ScreenShotCallback EyL = new ScreenShotUtil.ScreenShotCallback() {
        /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass8 */

        @Override // com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback
        public final void onScreenShot(String str, long j2) {
            AppMethodBeat.i(203413);
            Log.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "onScreenShot， path = " + str + "， dateAdded = " + j2);
            SnsAdNativeLandingPagesUI.R(SnsAdNativeLandingPagesUI.this);
            AppMethodBeat.o(203413);
        }
    };
    private Map<Integer, ContentFragment> EyM = new HashMap();
    private boolean EyN = false;
    public b.a EyO = new b.a() {
        /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass20 */

        @Override // com.tencent.mm.ui.b.a
        public final void bQ(boolean z) {
            AppMethodBeat.i(203432);
            SnsAdNativeLandingPagesUI.this.Eyj = z;
            Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "onKeyboardStateChanged, visiable=".concat(String.valueOf(z)));
            SnsAdNativeLandingPagesUI.this.JC(300);
            AppMethodBeat.o(203432);
        }
    };
    private BroadcastReceiver EyP = new BroadcastReceiver() {
        /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass22 */

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(203434);
            if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                Log.d("MicroMsg.SnsAdNativeLandingPagesUI", "android.intent.action.SCREEN_OFF");
                AppMethodBeat.o(203434);
                return;
            }
            if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
                Log.d("MicroMsg.SnsAdNativeLandingPagesUI", "android.intent.action.SCREEN_ON");
                ap.aK(SnsAdNativeLandingPagesUI.this);
            }
            AppMethodBeat.o(203434);
        }
    };
    private n EyQ = null;
    private q EyR = null;
    public FloatJumpCompHelper EyS;
    private c Eya;
    private e Eyb;
    private d Eyc;
    private volatile boolean Eyd;
    private boolean Eye;
    private Map<String, SnsAdLandingPageFloatView> Eyf = new HashMap();
    private com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.a Eyg;
    private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d Eyh;
    private boolean Eyi = false;
    public boolean Eyj = false;
    private boolean Eyk = false;
    Collection<String> Eyl = new HashSet();
    private volatile boolean Eym = false;
    private volatile boolean Eyn = false;
    private volatile boolean Eyo = false;
    private MMHandler Eyp = new MMHandler();
    private String Eyq = "";
    private FloatWebViewHelper Eyr;
    private com.tencent.mm.ui.widget.a.e Eys;
    public boolean Eyt = false;
    private TwistRoateCardsView Eyu;
    private ADXml.k Eyv;
    private boolean Eyw = false;
    private boolean Eyx = false;
    private boolean Eyy = false;
    private View Eyz;
    private boolean aMp = false;
    private String adCanvasExtXml;
    private String adExtInfo = "";
    private int adType;
    private String aid;
    private int bizId;
    public String dRS;
    private long dUy = 0;
    private long enterTime = 0;
    public boolean forbiddenCustomAnimation = false;
    private ImageView hTd;
    private volatile boolean isVisible = false;
    private ImageView jUG;
    private String kZe;
    private String lAP;
    private int mEX;
    private int mEY;
    String msN;
    private boolean preloadWeAppPkg = false;
    private int qaF = 0;
    private int qaG = 0;
    private int qaH = 0;
    private int qaI = 0;
    String rCq;
    private int recSrc;
    Bundle savedInstanceState;
    private int source;
    private long startTime;
    private String uin;
    private String uxInfo;
    private Map<String, String> values;
    private String viewId;
    String xDQ;
    protected a.b xxK = new a.b() {
        /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass19 */

        @Override // com.tencent.mm.ui.widget.snackbar.a.b
        public final void bDZ() {
            AppMethodBeat.i(203431);
            try {
                AdLandingPagesProxy.getInstance().favEditTag();
                AppMethodBeat.o(203431);
            } catch (Exception e2) {
                Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "favorite edittag fail, ex = " + e2.getMessage());
                AppMethodBeat.o(203431);
            }
        }
    };

    public SnsAdNativeLandingPagesUI() {
        AppMethodBeat.i(98362);
        AppMethodBeat.o(98362);
    }

    static /* synthetic */ void B(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.i(203464);
        snsAdNativeLandingPagesUI.fgT();
        AppMethodBeat.o(203464);
    }

    static /* synthetic */ boolean F(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.i(203465);
        boolean fhl = snsAdNativeLandingPagesUI.fhl();
        AppMethodBeat.o(203465);
        return fhl;
    }

    static /* synthetic */ boolean G(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.i(203466);
        boolean fhk = snsAdNativeLandingPagesUI.fhk();
        AppMethodBeat.o(203466);
        return fhk;
    }

    static /* synthetic */ void Q(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.i(203469);
        snsAdNativeLandingPagesUI.fhd();
        AppMethodBeat.o(203469);
    }

    static /* synthetic */ boolean a(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI, ContentFragment contentFragment) {
        AppMethodBeat.i(203458);
        boolean r = snsAdNativeLandingPagesUI.r(contentFragment);
        AppMethodBeat.o(203458);
        return r;
    }

    static /* synthetic */ void b(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI, ContentFragment contentFragment) {
        AppMethodBeat.i(203462);
        snsAdNativeLandingPagesUI.s(contentFragment);
        AppMethodBeat.o(203462);
    }

    static /* synthetic */ void d(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.i(203457);
        snsAdNativeLandingPagesUI.fgS();
        AppMethodBeat.o(203457);
    }

    static /* synthetic */ aj i(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.i(203459);
        aj fhm = snsAdNativeLandingPagesUI.fhm();
        AppMethodBeat.o(203459);
        return fhm;
    }

    static /* synthetic */ ContentFragment n(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.i(203461);
        ContentFragment fhn = snsAdNativeLandingPagesUI.fhn();
        AppMethodBeat.o(203461);
        return fhn;
    }

    static /* synthetic */ void u(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.i(203463);
        snsAdNativeLandingPagesUI.fhg();
        AppMethodBeat.o(203463);
    }

    private void fgS() {
        boolean z = true;
        AppMethodBeat.i(203441);
        boolean z2 = false;
        try {
            int i2 = getApplicationContext().getApplicationInfo().targetSdkVersion;
            if (com.tencent.mm.compatible.util.d.oD(29) && (com.tencent.mm.compatible.util.d.oD(30) || i2 >= 29)) {
                z2 = true;
            }
            String nullAsNil = Util.nullAsNil(Build.MODEL);
            if (z2 || TextUtils.isEmpty(nullAsNil) || !"huawei nxt-al10|mix 2s".contains(nullAsNil.toLowerCase())) {
                z = z2;
            }
            if (z) {
                com.tencent.mm.ui.base.b.a(this, null);
            }
            Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "fixActivityTranslucent, device=" + nullAsNil + ", api=" + Build.VERSION.SDK_INT + ", targetSdkVer=" + i2 + ", needFix=" + z);
            AppMethodBeat.o(203441);
        } catch (Throwable th) {
            Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "fixActivityTranslucent exp=" + th.toString());
            AppMethodBeat.o(203441);
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(98363);
        super.onCreate(bundle);
        Log.d("MicroMsg.SnsAdNativeLandingPagesUI.launch", "onCreate");
        this.startTime = System.currentTimeMillis();
        this.enterTime = System.currentTimeMillis();
        this.ExI.enterTime = this.enterTime;
        ap.aK(this);
        int[] ha = ap.ha(this);
        this.mEX = ha[0];
        this.mEY = ha[1];
        this.savedInstanceState = bundle;
        this.mController.hideTitleView();
        this.qaF = getIntent().getIntExtra("img_gallery_top", 0);
        if (ao.aQ(this)) {
            int aP = ao.aP(this);
            this.qaF -= aP;
            Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "hasCutOut, h=" + aP + ", thumbTop=" + this.qaF);
        }
        this.qaG = getIntent().getIntExtra("img_gallery_left", 0);
        this.qaH = getIntent().getIntExtra("img_gallery_width", 0);
        this.qaI = getIntent().getIntExtra("img_gallery_height", 0);
        getWindow().addFlags(128);
        this.isVisible = false;
        this.Eym = false;
        this.Eyn = false;
        this.Eyo = false;
        if (this.Eyp != null) {
            this.Eyp.removeCallbacks(this.EyK);
        }
        this.source = getIntent().getIntExtra("sns_landig_pages_from_source", 0);
        this.DZU = getIntent().getIntExtra("sns_landig_pages_origin_from_source", 0);
        Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "source=" + this.source + ", originScene=" + this.DZU);
        this.Exz = getIntent().getStringExtra("sns_landing_pages_xml");
        String stringExtra = getIntent().getStringExtra("sns_landing_pages_too_large_xml_path");
        if (Util.isNullOrNil(this.Exz) && !Util.isNullOrNil(stringExtra)) {
            this.Exz = ap.aQd(stringExtra);
        }
        if (Util.isNullOrNil(this.Exz)) {
            finish();
        } else {
            this.Exz = this.Exz.replaceAll("</*RecXml[\\s|\\S]*?>", "");
            this.ExI.DQS = getIntent().getStringExtra("sns_landing_pages_expid");
            this.ExA = getIntent().getStringExtra("sns_landing_pages_xml_prefix");
            this.dRS = getIntent().getStringExtra("sns_landing_pages_share_sns_id");
            this.ExG = getIntent().getStringExtra("sns_landing_pages_rawSnsId");
            this.uxInfo = getIntent().getStringExtra("sns_landing_pages_ux_info");
            this.aid = getIntent().getStringExtra("sns_landing_pages_aid");
            this.kZe = getIntent().getStringExtra("sns_landing_pages_traceid");
            String stringExtra2 = getIntent().getStringExtra("sns_landing_pages_search_extra");
            k kVar = this.ExI;
            if (!TextUtils.isEmpty(stringExtra2)) {
                if (kVar.extra.length() > 0) {
                    kVar.extra += "&";
                }
                kVar.extra += "searchextra=" + URLEncoder.encode(stringExtra2);
            }
            String stringExtra3 = getIntent().getStringExtra("sns_landing_pages_extra");
            Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "initParams, extraData=".concat(String.valueOf(stringExtra3)));
            k kVar2 = this.ExI;
            if (!TextUtils.isEmpty(stringExtra3)) {
                if (kVar2.extra.length() > 0) {
                    kVar2.extra += "&";
                }
                kVar2.extra += URLEncoder.encode(stringExtra3);
            }
            this.ExH = getIntent().getBooleanExtra("sns_landing_is_native_sight_ad", false);
            this.recSrc = getIntent().getIntExtra("sns_landing_pages_rec_src", 0);
            this.ExL = getIntent().getIntExtra("sns_landing_pages_from_outer_index", 0);
            this.lAP = getIntent().getStringExtra("sns_landing_pages_ad_info");
            this.Exx = getIntent().getBooleanExtra("sns_landing_pages_need_enter_and_exit_animation", false);
            this.Exy = getIntent().getBooleanExtra("sns_landing_pages_is_normal_ad_animation", false);
            this.DZZ = getIntent().getLongExtra("sns_landing_page_sight_video_seek_time", 0);
            this.ExI.rna = this.source;
            this.ExI.ElM = 0;
            this.ExI.ElN = 0;
            this.ExI.ElO = 1;
            this.ExI.ElP = 0;
            this.ExI.DZU = this.DZU;
            if (this.ExA == null || "".equals(this.Exz)) {
                this.ExA = f.COL_ADXML;
            }
            if (Util.isNullOrNil(this.Exz) || Util.isNullOrNil(this.ExA)) {
                Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "landingPagesXml is " + this.Exz + ",landingPagesXmlPrex is " + this.ExA);
            } else {
                this.values = XmlParser.parseXml(this.Exz, this.ExA, null);
                if (this.values != null) {
                    this.ExI.lAN = Util.nullAs(this.values.get("." + this.ExA + ".adCanvasInfo.id"), "");
                    this.Eyq = Util.nullAs(this.values.get("." + this.ExA + ".adExtInfo"), "");
                    this.adExtInfo = com.tencent.mm.plugin.sns.data.i.aNZ(this.Eyq);
                    this.Eyt = Util.safeParseInt(this.values.get(new StringBuilder(".").append(this.ExA).append(".forbiddenLeftSwipe").toString())) == 1;
                    if (Util.safeParseInt(this.values.get("." + this.ExA + ".forbiddenCustomAnimation")) == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.forbiddenCustomAnimation = z;
                } else {
                    Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "initParams, values is null");
                }
                if (this.forbiddenCustomAnimation) {
                    this.Exx = false;
                    this.Exy = false;
                }
                if (this.Exx) {
                    this.ExI.gYH = 0;
                    this.ExI.gmJ = 0;
                } else {
                    this.ExI.gYH = 1;
                    this.ExI.gmJ = 1;
                }
                this.EyB = getIntent().getStringExtra("sns_landing_page_is_gesture_twist_card_id");
                if (this.values != null) {
                    this.Eyv = ADXml.k.J(this.values, "." + this.ExA + ".adTwistInfo");
                }
                boolean aPT = ADXml.k.aPT(this.Exz);
                boolean booleanExtra = getIntent().getBooleanExtra("sns_landing_page_is_gesture_twist_ad", false);
                if (this.Eyv != null) {
                    if (aPT) {
                        if (booleanExtra) {
                            this.Eyw = true;
                            this.Eyx = false;
                        } else {
                            int i2 = this.source;
                            boolean z3 = i2 == 1 || i2 == 2 || i2 == 16;
                            Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "isFromShare, source=" + i2 + ", ret=" + z3);
                            if (!z3) {
                                this.Eyw = true;
                                this.Eyx = true;
                            }
                        }
                    } else if (booleanExtra && this.Eyv.DWW) {
                        this.Eyy = true;
                    }
                }
                Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "isSharedTypeTwistAnim=" + this.Eyx + ", isTwistAdAnim=" + this.Eyw + ", intent twistCardId=" + this.EyB + ", isSimpleTwistAnim=" + this.Eyy);
                if (this.values != null) {
                    if (Util.safeParseInt(this.values.get("." + this.ExA + ".preloadWeAppPkg")) != 1) {
                        z2 = false;
                    }
                    this.preloadWeAppPkg = z2;
                }
            }
        }
        initView();
        Log.d("MicroMsg.SnsAdNativeLandingPagesUI.launch", "before AdLandingPagesProxy connect");
        if (!AdLandingPagesProxy.getInstance().isConnected()) {
            Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "isConnected==false");
            AdLandingPagesProxy.getInstance().connect(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass31 */

                public final void run() {
                    AppMethodBeat.i(98360);
                    Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "after Connected");
                    SnsAdNativeLandingPagesUI.B(SnsAdNativeLandingPagesUI.this);
                    AppMethodBeat.o(98360);
                }
            });
        } else {
            Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "isConnected==true");
            fgT();
        }
        EventCenter.instance.addListener(this.EyJ);
        try {
            registerReceiver(this.EyP, new IntentFilter("android.intent.action.SCREEN_ON"));
            AppMethodBeat.o(98363);
        } catch (Exception e2) {
            Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "registerReceiver, exp=" + e2.toString());
            AppMethodBeat.o(98363);
        }
    }

    private void fgT() {
        AppMethodBeat.i(98364);
        Log.d("MicroMsg.SnsAdNativeLandingPagesUI.launch", "initAfterConnectToMM");
        AdlandingRemoteServiceConnectedReceiver.a(android.support.v4.content.d.W(this));
        amZ();
        if (this.Exx) {
            boD();
        } else {
            fhg();
        }
        refreshView();
        fha();
        fhb();
        vp(true);
        this.aMp = true;
        fgU();
        fgV();
        AppMethodBeat.o(98364);
    }

    private void fgU() {
        AppMethodBeat.i(203442);
        if (ZF(this.source) && !TextUtils.isEmpty(this.uxInfo)) {
            Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "doUpdateUxInfoScene, uxInfo=" + this.uxInfo);
            AdLandingPagesProxy.getInstance().doUpdateUxInfoScene(this.uxInfo, new AdLandingPagesProxy.e() {
                /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass32 */

                @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e
                public final void bn(Object obj) {
                }

                @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e
                public final void h(int i2, int i3, Object obj) {
                    AppMethodBeat.i(203440);
                    Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "doUpdateUxInfoScene end, errType=" + i2 + ", errNo=" + i3 + ", newUxInfo=" + obj);
                    if (i2 == 0 && i3 == 0 && (obj instanceof String)) {
                        SnsAdNativeLandingPagesUI.this.DZW = (String) obj;
                    }
                    AppMethodBeat.o(203440);
                }
            });
            fgW();
        }
        AppMethodBeat.o(203442);
    }

    private void fgV() {
        AppMethodBeat.i(203443);
        AdLandingPagesProxy.getInstance().doAdNativeAntiAbuseScene(this.ExI.lAN, this.uxInfo, this.source, this.adExtInfo, new AdLandingPagesProxy.e() {
            /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e
            public final void bn(Object obj) {
            }

            @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e
            public final void h(int i2, int i3, Object obj) {
                AppMethodBeat.i(203408);
                Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "doAdNativeAntiAbuseScene end, errType = " + i2 + ", errNo = " + i3 + ", canvasAuthFailed = " + obj);
                if (i2 == 0 && i3 == 0 && obj != null) {
                    try {
                        bq bqVar = new bq();
                        bqVar.parseFrom((byte[]) obj);
                        if (bqVar.KFp != 0) {
                            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                                /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass2.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(203407);
                                    Context applicationContext = SnsAdNativeLandingPagesUI.this.getApplicationContext();
                                    if (applicationContext != null) {
                                        com.tencent.mm.ui.base.u.cH(applicationContext, "广告无效，已为你关闭");
                                    }
                                    SnsAdNativeLandingPagesUI.this.cvQ();
                                    AppMethodBeat.o(203407);
                                }
                            }, 500);
                        }
                        AppMethodBeat.o(203408);
                        return;
                    } catch (Throwable th) {
                        Log.e("MicroMsg.SnsAdNativeLandingPagesUI", th.toString());
                    }
                }
                AppMethodBeat.o(203408);
            }
        });
        AppMethodBeat.o(203443);
    }

    private void fgW() {
        AppMethodBeat.i(203444);
        try {
            Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "checkPreloadScanRes, uxinfo=" + this.uxInfo);
            com.tencent.mm.plugin.sns.ad.timeline.b.e.a(ADXml.b.F(this.values, ".adxml.adScanInfo"), this.uxInfo);
            AppMethodBeat.o(203444);
        } catch (Exception e2) {
            Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "checkPreloadScanRes exp=" + e2.toString());
            AppMethodBeat.o(203444);
        }
    }

    public static boolean ZF(int i2) {
        AppMethodBeat.i(203445);
        boolean z = i2 == 3 || i2 == 5 || i2 == 4;
        Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "isNeedUpdateUxinfo, source=" + i2 + ", ret=" + z);
        AppMethodBeat.o(203445);
        return z;
    }

    private void fgX() {
        AppMethodBeat.i(203446);
        try {
            if (this.Eys != null && this.Eys.isShowing()) {
                this.Eys.bMo();
            }
            AppMethodBeat.o(203446);
        } catch (Exception e2) {
            Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "hideMoreOptionMenu exp=" + e2.toString());
            AppMethodBeat.o(203446);
        }
    }

    private void refreshView() {
        int i2;
        AppMethodBeat.i(98365);
        if (this.bizId == 2 && !fhj()) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ExR.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, au.aD(this));
            this.ExR.setLayoutParams(layoutParams);
        }
        int i3 = R.color.a7z;
        if (!fhj()) {
            int color = getResources().getColor(R.color.a7y);
            if (this.Elq == null || this.Elq.size() <= 0 || Util.isNullOrNil(this.Elq.getFirst().lco)) {
                i2 = color;
            } else {
                i2 = Color.parseColor(this.Elq.getFirst().lco);
            }
            this.ExW.setBackgroundColor(i2);
            i3 = R.color.a7y;
        }
        Drawable drawable = this.hTd.getDrawable();
        if (drawable != null) {
            android.support.v4.graphics.drawable.a.a(drawable, android.support.v4.content.b.n(this, i3));
            this.hTd.setImageDrawable(drawable);
        }
        Drawable drawable2 = this.BQk.getDrawable();
        if (drawable2 != null) {
            android.support.v4.graphics.drawable.a.a(drawable2, android.support.v4.content.b.n(this, i3));
            this.BQk.setImageDrawable(drawable2);
        }
        if (fhk() && !fhl() && this.bizId == 2) {
            this.BQk.setVisibility(8);
            this.Exw.setVisibility(0);
            this.Exw.setText(this.ExB);
            this.Exw.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(203409);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    SnsAdNativeLandingPagesUI.this.J(SnsAdNativeLandingPagesUI.this, SnsAdNativeLandingPagesUI.this.ExC, SnsAdNativeLandingPagesUI.this.ExD);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(203409);
                }
            });
            AppMethodBeat.o(98365);
        } else if (fhh()) {
            Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "canShowMenuBtn=true, disableShareBitSet=" + this.ExS);
            this.BQk.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass4 */

                public final void onClick(View view) {
                    AppMethodBeat.i(203410);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    SnsAdNativeLandingPagesUI.this.fgY();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(203410);
                }
            });
            AppMethodBeat.o(98365);
        } else {
            Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "canShowMenuBtn=false, disableShareBitSet=" + this.ExS);
            this.BQk.setVisibility(8);
            AppMethodBeat.o(98365);
        }
    }

    public final void fgY() {
        AppMethodBeat.i(203447);
        if (this.BQk.getVisibility() != 0) {
            AppMethodBeat.o(203447);
            return;
        }
        fgX();
        this.Eys = new com.tencent.mm.ui.widget.a.e((Context) this, 1, false);
        this.Eys.HLX = new o.f() {
            /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass5 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                AppMethodBeat.i(203411);
                if (SnsAdNativeLandingPagesUI.this.ExS == 0 || (SnsAdNativeLandingPagesUI.this.ExS & 2) == 0) {
                    mVar.b(1, SnsAdNativeLandingPagesUI.this.getString(R.string.g5j), R.raw.bottomsheet_icon_transmit);
                }
                if (SnsAdNativeLandingPagesUI.this.ExS == 0 || (SnsAdNativeLandingPagesUI.this.ExS & 1) == 0) {
                    mVar.b(2, SnsAdNativeLandingPagesUI.this.getString(R.string.h4u), R.raw.bottomsheet_icon_moment);
                }
                if ((SnsAdNativeLandingPagesUI.this.ExS == 0 || (SnsAdNativeLandingPagesUI.this.ExS & 4) == 0) && SnsAdNativeLandingPagesUI.this.source != 7) {
                    mVar.b(3, SnsAdNativeLandingPagesUI.this.getString(R.string.ay9), R.raw.bottomsheet_icon_fav);
                }
                if ((SnsAdNativeLandingPagesUI.this.ExS == 0 || SnsAdNativeLandingPagesUI.F(SnsAdNativeLandingPagesUI.this)) && SnsAdNativeLandingPagesUI.this.bizId == 2 && SnsAdNativeLandingPagesUI.G(SnsAdNativeLandingPagesUI.this)) {
                    mVar.b(4, SnsAdNativeLandingPagesUI.this.ExB != null ? SnsAdNativeLandingPagesUI.this.ExB : "", 0);
                }
                if (!((SnsAdNativeLandingPagesUI.this.ExS != 0 && (SnsAdNativeLandingPagesUI.this.ExS & 32) != 0) || SnsAdNativeLandingPagesUI.this.Eyr == null || SnsAdNativeLandingPagesUI.this.Eyr.EWp == null)) {
                    mVar.b(5, SnsAdNativeLandingPagesUI.this.getString(R.string.h4s), 0);
                }
                AppMethodBeat.o(203411);
            }
        };
        this.Eys.mLO = true;
        this.Eys.HLY = new o.g() {
            /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass6 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(203412);
                ap.aK(SnsAdNativeLandingPagesUI.this);
                if (menuItem != null) {
                    switch (menuItem.getItemId()) {
                        case 1:
                            SnsAdNativeLandingPagesUI.J(SnsAdNativeLandingPagesUI.this);
                            AppMethodBeat.o(203412);
                            return;
                        case 2:
                            SnsAdNativeLandingPagesUI.K(SnsAdNativeLandingPagesUI.this);
                            AppMethodBeat.o(203412);
                            return;
                        case 3:
                            SnsAdNativeLandingPagesUI.L(SnsAdNativeLandingPagesUI.this);
                            AppMethodBeat.o(203412);
                            return;
                        case 4:
                            SnsAdNativeLandingPagesUI.this.J(SnsAdNativeLandingPagesUI.this, SnsAdNativeLandingPagesUI.this.ExC, SnsAdNativeLandingPagesUI.this.ExD);
                            AppMethodBeat.o(203412);
                            return;
                        case 5:
                            SnsAdNativeLandingPagesUI.M(SnsAdNativeLandingPagesUI.this);
                            break;
                    }
                }
                AppMethodBeat.o(203412);
            }
        };
        hideVKB();
        this.Eys.dGm();
        AppMethodBeat.o(203447);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(98366);
        getWindow().clearFlags(128);
        if (this.Eyp != null) {
            this.Eyp.removeCallbacks(this.EyK);
        }
        if (this.Eyh != null) {
            this.Eyh.eXd();
        }
        if (this.aMp) {
            Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "the SnsAdNativeLadingPagesUI is destroy, bHandleExit=" + this.ExK);
            if (!this.ExK) {
                fgZ();
                report();
            }
        } else {
            Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "onDestroy, isConnected=false");
        }
        this.Eyf.clear();
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b bVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b) this.ExR.getAdapter();
        if (bVar != null) {
            bVar.fragments.clear();
        }
        try {
            unregisterReceiver(this.EyP);
        } catch (Exception e2) {
            Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "unregisterReceiver, exp=" + e2.toString());
        }
        EventCenter.instance.removeListener(this.EyJ);
        try {
            vc vcVar = new vc();
            vcVar.ebu.ebv = 5;
            EventCenter.instance.publish(vcVar);
        } catch (Throwable th) {
        }
        AdLandingPagesProxy.getInstance().clearCallback();
        super.onDestroy();
        AppMethodBeat.o(98366);
    }

    private void fgZ() {
        AppMethodBeat.i(98367);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b bVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b) this.ExR.getAdapter();
        if (bVar == null) {
            AppMethodBeat.o(98367);
            return;
        }
        Iterator<Fragment> it = bVar.fragments.iterator();
        while (it.hasNext()) {
            ContentFragment contentFragment = (ContentFragment) it.next();
            if (contentFragment.Eik != null && contentFragment.getUserVisibleHint()) {
                contentFragment.Eik.fdU();
            }
        }
        if (this.Eyh != null) {
            this.Eyh.eXa();
        }
        AppMethodBeat.o(98367);
    }

    private void report() {
        AppMethodBeat.i(98368);
        List<m> allComp = getAllComp();
        for (SnsAdLandingPageFloatView snsAdLandingPageFloatView : this.Eyf.values()) {
            allComp.addAll(snsAdLandingPageFloatView.getAllComp());
        }
        if (this.Eyh != null) {
            allComp.add(this.Eyh);
            p fcX = this.Eyh.fcX();
            if (fcX != null) {
                this.Eyh.fcW();
                allComp.add(fcX);
            }
        }
        if (this.Eyg != null) {
            List<m> eXi = this.Eyg.eXi();
            if (com.tencent.mm.plugin.sns.ad.i.c.o(eXi)) {
                allComp.addAll(eXi);
            }
        }
        this.dUy += System.currentTimeMillis() - this.startTime;
        this.ExI.ElR = (int) this.dUy;
        this.ExI.ElQ = allComp.size();
        k kVar = this.ExI;
        for (m mVar : allComp) {
            if (!mVar.fdk().DZr) {
                JSONObject jSONObject = new JSONObject();
                if (!mVar.G(kVar.ElU) && mVar.bp(jSONObject)) {
                    kVar.ElU.put(jSONObject);
                }
            }
        }
        Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "landingPage report json %s", this.ExI.ElU);
        String feA = this.ExI.feA();
        if (this.bizId == 2) {
            AdLandingPagesProxy.getInstance().doCgiReportCanvasBrowseInfo(15041, feA);
            Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "post cgi stat 15041 data: ".concat(String.valueOf(feA)));
            AppMethodBeat.o(98368);
        } else if (AdLandingPagesProxy.getInstance().isRecExpAd(this.ExI.dRS)) {
            h.INSTANCE.kvStat(14650, feA);
            Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 14650 data: ".concat(String.valueOf(feA)));
            AppMethodBeat.o(98368);
        } else {
            h.INSTANCE.kvStat(13387, feA);
            Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 13387 data: ".concat(String.valueOf(feA)));
            AppMethodBeat.o(98368);
        }
    }

    private void fha() {
        AppMethodBeat.i(98369);
        if (this.recSrc != 2) {
            h hVar = h.INSTANCE;
            Object[] objArr = new Object[7];
            objArr[0] = r.Jb(r.aOw(this.ExI.dRS));
            objArr[1] = this.uxInfo == null ? "" : this.uxInfo;
            objArr[2] = Integer.valueOf(this.ExI.gYH);
            objArr[3] = Integer.valueOf(this.ExI.rna);
            objArr[4] = Long.valueOf(this.enterTime);
            objArr[5] = Integer.valueOf(this.DZU);
            objArr[6] = this.ExI.lAN;
            hVar.a(14655, objArr);
        }
        AppMethodBeat.o(98369);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(179183);
        super.onStart();
        this.isVisible = true;
        if (this.aMp) {
            try {
                if (!Util.isNullOrNil(this.viewId, this.DZY) && !this.Eyn) {
                    if (this.Eyo) {
                        Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "execute mValidExposure onStart immediately");
                        fhd();
                        AppMethodBeat.o(179183);
                        return;
                    } else if (this.Eyp != null) {
                        Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "execute mValidExposureRunnable onStart");
                        this.Eyp.removeCallbacks(this.EyK);
                        this.Eyp.postDelayed(this.EyK, 1000);
                    }
                }
                AppMethodBeat.o(179183);
                return;
            } catch (Throwable th) {
                Log.e("MicroMsg.SnsAdNativeLandingPagesUI", th.toString());
            }
        }
        AppMethodBeat.o(179183);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(179184);
        super.onStop();
        this.isVisible = false;
        if (this.Eyp != null) {
            this.Eyp.removeCallbacks(this.EyK);
        }
        AppMethodBeat.o(179184);
    }

    private void fhb() {
        AppMethodBeat.i(179185);
        try {
            if (!Util.isNullOrNil(this.viewId, this.DZY)) {
                if (!this.Eym) {
                    fhc();
                }
                if (!this.Eyn && this.Eyp != null) {
                    Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "execute mValidExposureRunnable onCreate");
                    this.Eyp.removeCallbacks(this.EyK);
                    this.Eyp.postDelayed(this.EyK, 1000);
                }
            }
            AppMethodBeat.o(179185);
        } catch (Throwable th) {
            Log.e("MicroMsg.SnsAdNativeLandingPagesUI", th.toString());
            AppMethodBeat.o(179185);
        }
    }

    private void fhc() {
        AppMethodBeat.i(179186);
        Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "reportOriginalExposure viewId = " + this.viewId + ", commInfo = " + this.DZY + ", uxInfo = " + this.uxInfo + ", exposureType = 0");
        this.Eym = true;
        i(this.viewId, this.DZY, this.uxInfo, 0);
        AppMethodBeat.o(179186);
    }

    private void fhd() {
        AppMethodBeat.i(179187);
        Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "reportValidExposure viewId = " + this.viewId + ", commInfo = " + this.DZY + ", uxInfo = " + this.uxInfo + ", exposureType = 1");
        this.Eyn = true;
        i(this.viewId, this.DZY, this.uxInfo, 1);
        AppMethodBeat.o(179187);
    }

    private static void i(String str, String str2, String str3, int i2) {
        AppMethodBeat.i(179188);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewid", str);
            jSONObject.put("commInfo", str2);
            jSONObject.put("uxinfo", str3);
            jSONObject.put("exposureType", i2);
            com.tencent.mm.plugin.sns.data.k.jY("rewarded_canvas_exposure", jSONObject.toString());
            AppMethodBeat.o(179188);
        } catch (Exception e2) {
            Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "doCanvasExposureReport exp=" + e2.toString());
            AppMethodBeat.o(179188);
        }
    }

    private boolean fhe() {
        AppMethodBeat.i(98370);
        int childCount = this.ExV.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (this.ExV.getChildAt(i2) instanceof SnsAdLandingPageFloatView) {
                AppMethodBeat.o(98370);
                return true;
            }
        }
        AppMethodBeat.o(98370);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        SnsAdLandingPageFloatView snsAdLandingPageFloatView;
        AppMethodBeat.i(98371);
        Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "onResume");
        super.onResume();
        if (this.Eyt && isSupportNavigationSwipeBack()) {
            getSwipeBackLayout().setEnableGesture(false);
        }
        try {
            if (!this.ExJ) {
                Log.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "onResume callback");
                ScreenShotUtil.setScreenShotCallback(this, this.EyL);
                this.ExJ = true;
            }
        } catch (Throwable th) {
            Log.e("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", th.toString());
        }
        ap.aK(this);
        if (fhe()) {
            int childCount = this.ExV.getChildCount() - 1;
            while (true) {
                if (childCount < 0) {
                    snsAdLandingPageFloatView = null;
                    break;
                }
                View childAt = this.ExV.getChildAt(childCount);
                if (childAt instanceof SnsAdLandingPageFloatView) {
                    snsAdLandingPageFloatView = (SnsAdLandingPageFloatView) childAt;
                    break;
                }
                childCount--;
            }
            snsAdLandingPageFloatView.onResume();
            AppMethodBeat.o(98371);
            return;
        }
        this.Eye = false;
        this.ExR.Eia.add(this.EyG);
        android.support.v4.content.d.W(this).a(this.EyC, new IntentFilter("com.tencent.mm.adlanding.video_progressbar_change"));
        android.support.v4.content.d.W(this).a(this.EyD, new IntentFilter("com.tencent.mm.adlanding.set_uioption"));
        if (this.aMp) {
            this.startTime = System.currentTimeMillis();
        }
        EventCenter.instance.addListener(this.EyI);
        if (this.ExM) {
            vp(false);
        }
        if (this.Eyh != null && this.Eyh.isShowing()) {
            this.Eyh.eWZ();
        }
        AppMethodBeat.o(98371);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.i(203448);
        super.onAttachedToWindow();
        fgS();
        AppMethodBeat.o(203448);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(203449);
        AppMethodBeat.at(this, z);
        super.onWindowFocusChanged(z);
        Log.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "hasFocus = ".concat(String.valueOf(z)));
        if (!z) {
            try {
                ScreenShotUtil.setScreenShotCallback(this, null);
                this.ExJ = false;
                AppMethodBeat.o(203449);
            } catch (Throwable th) {
                Log.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "hasFocus = ".concat(String.valueOf(z)));
                Log.e("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", th.toString());
                AppMethodBeat.o(203449);
            }
        } else {
            if (!this.ExJ) {
                Log.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "onWindowFocusChanged callback");
                ScreenShotUtil.setScreenShotCallback(this, this.EyL);
                this.ExJ = true;
            }
            AppMethodBeat.o(203449);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(98372);
        super.onPause();
        Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "onPause");
        this.Eye = true;
        if (this.aMp) {
            this.dUy += System.currentTimeMillis() - this.startTime;
        }
        try {
            ScreenShotUtil.setScreenShotCallback(this, null);
            this.ExJ = false;
        } catch (Throwable th) {
            Log.e("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", th.toString());
        }
        if (fhe()) {
            for (SnsAdLandingPageFloatView snsAdLandingPageFloatView : this.Eyf.values()) {
                snsAdLandingPageFloatView.onPause();
            }
        }
        this.ExR.Eia.remove(this.EyG);
        android.support.v4.content.d.W(this).unregisterReceiver(this.EyC);
        android.support.v4.content.d.W(this).unregisterReceiver(this.EyD);
        EventCenter.instance.removeListener(this.EyI);
        if (this.EyQ != null) {
            this.EyQ.bMo();
        }
        if (this.Eyh != null && this.Eyh.isShowing()) {
            this.Eyh.eXa();
        }
        AppMethodBeat.o(98372);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.widget.SwipeBackLayout.a
    public void onSwipeBack() {
        AppMethodBeat.i(98373);
        this.ExI.gmJ = 2;
        this.ExI.ElP++;
        super.onSwipeBack();
        try {
            hideVKB();
            AppMethodBeat.o(98373);
        } catch (Exception e2) {
            Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "onSwipeBack hideVKB exp=" + e2.toString());
            AppMethodBeat.o(98373);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x087d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void amZ() {
        /*
        // Method dump skipped, instructions count: 2486
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.amZ():void");
    }

    public final ah fds() {
        int i2;
        String str;
        boolean z;
        String valueOf;
        AppMethodBeat.i(203450);
        if (this.DJT == null) {
            this.DJT = new ah();
        }
        ah ahVar = this.DJT;
        if (this.DZU == 0) {
            i2 = this.source;
        } else {
            i2 = this.DZU;
        }
        ahVar.DZU = i2;
        this.DJT.source = this.source;
        this.DJT.DZV = this.ExH;
        this.DJT.uxInfo = this.uxInfo;
        this.DJT.DZW = this.DZW;
        this.DJT.uin = this.uin;
        this.DJT.bizId = this.bizId;
        this.DJT.aid = this.aid;
        this.DJT.kZe = this.kZe;
        this.DJT.Eaa.putAll(this.Eaa);
        ah ahVar2 = this.DJT;
        if (this.ExI != null) {
            str = this.ExI.lAN;
        } else {
            str = "";
        }
        ahVar2.lAN = str;
        ah ahVar3 = this.DJT;
        if (this.Exu != null) {
            z = true;
        } else {
            z = false;
        }
        ahVar3.DZX = z;
        try {
            ah ahVar4 = this.DJT;
            if (Util.isNullOrNil(this.dRS)) {
                valueOf = this.ExI != null ? String.valueOf(com.tencent.mm.plugin.sns.data.k.aOa(this.ExI.dRS)) : "";
            } else {
                valueOf = String.valueOf(com.tencent.mm.plugin.sns.data.k.aOa(this.dRS));
            }
            ahVar4.dRS = valueOf;
        } catch (Throwable th) {
            Log.e("MicroMsg.SnsAdNativeLandingPagesUI", th.toString());
        }
        if (!Util.isNullOrNil(this.viewId, this.DZY)) {
            this.DJT.viewId = this.viewId;
            this.DJT.DZY = this.DZY;
        }
        this.DJT.adExtInfo = this.adExtInfo;
        this.DJT.DZZ = this.DZZ;
        ah ahVar5 = this.DJT;
        AppMethodBeat.o(203450);
        return ahVar5;
    }

    private void M(Map<String, String> map, String str) {
        int i2;
        int i3;
        AppMethodBeat.i(98375);
        String str2 = map.get(str + ".adCanvasInfo.arrowDownIconStyle.iconUrl");
        if (TextUtils.isEmpty(str2)) {
            this.Eim = null;
            AppMethodBeat.o(98375);
            return;
        }
        if (this.Eim == null) {
            this.Eim = new aq();
        }
        this.Eim.iconUrl = str2;
        int safeParseInt = Util.safeParseInt(map.get(str + ".adCanvasInfo.sizeType"));
        int safeParseInt2 = Util.safeParseInt(map.get(str + ".adCanvasInfo.basicRootFontSize"));
        int safeParseInt3 = Util.safeParseInt(map.get(str + ".adCanvasInfo.basicWidth"));
        if (safeParseInt2 == 0 && safeParseInt == 1) {
            i2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.Elo;
        } else {
            i2 = safeParseInt2;
        }
        if (safeParseInt3 == 0 && safeParseInt == 1) {
            i3 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.Eln;
        } else {
            i3 = safeParseInt3;
        }
        this.Eim.paddingBottom = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(Util.safeParseDouble(map.get(str + ".adCanvasInfo.arrowDownIconStyle.paddingBottom")), safeParseInt, i3, i2);
        this.Eim.width = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(Util.safeParseDouble(map.get(str + ".adCanvasInfo.arrowDownIconStyle.layoutWidth")), safeParseInt, i3, i2);
        this.Eim.height = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(Util.safeParseDouble(map.get(str + ".adCanvasInfo.arrowDownIconStyle.layoutHeight")), safeParseInt, i3, i2);
        AppMethodBeat.o(98375);
    }

    private List<g> fhf() {
        AppMethodBeat.i(98376);
        ArrayList arrayList = new ArrayList();
        Iterator<g> it = this.Elq.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next.Elk) {
                arrayList.add(next);
            }
        }
        hb(arrayList);
        AppMethodBeat.o(98376);
        return arrayList;
    }

    private void hb(List<g> list) {
        AppMethodBeat.i(98377);
        try {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            for (g gVar : list) {
                Iterator<z> it = gVar.Eli.iterator();
                while (it.hasNext()) {
                    z next = it.next();
                    if (next instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) {
                        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) next).DXN = i2;
                        i2++;
                    }
                    if (next instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) {
                        String str = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) next).DYr;
                        if (!TextUtils.isEmpty(str)) {
                            this.Eyl.add(str);
                        }
                    }
                    if (next instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p) {
                        String str2 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p) next).jumpUrl;
                        if (!TextUtils.isEmpty(str2)) {
                            this.Eyl.add(str2);
                        }
                    }
                    if (!this.EyN) {
                        com.tencent.mm.plugin.sns.ad.e.e.a(next, arrayList);
                    }
                }
            }
            if (!this.EyN) {
                this.EyN = true;
                if (!arrayList.isEmpty()) {
                    com.tencent.mm.plugin.sns.ad.e.e.g(arrayList, this.preloadWeAppPkg);
                }
            }
            if (!com.tencent.mm.plugin.sns.ad.i.c.isEmpty(this.Eyl)) {
                String[] a2 = com.tencent.mm.plugin.sns.ad.d.a.a.a(this.Eyl, this.kZe, this.aid, this.DZW, this.uxInfo);
                if (!com.tencent.mm.plugin.sns.ad.i.c.w(a2)) {
                    AdLandingPagesProxy.getInstance().prefetchH5Url(TextUtils.isEmpty(this.dRS) ? this.ExG : this.dRS, a2);
                }
            }
            AppMethodBeat.o(98377);
        } catch (Exception e2) {
            Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "giveIdxForApkBtnInfo, exp=" + e2.toString());
            AppMethodBeat.o(98377);
        }
    }

    private void boD() {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b bVar;
        AppMethodBeat.i(98378);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b bVar2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b) this.ExR.getAdapter();
        if (bVar2 == null) {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b bVar3 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b(getSupportFragmentManager(), new ArrayList());
            this.ExR.setAdapter(bVar3);
            bVar = bVar3;
        } else {
            bVar = bVar2;
        }
        List<g> fhf = fhf();
        if (fhf.size() > 0) {
            g gVar = fhf.get(0);
            Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "loadFirstPage load id %s", Integer.valueOf(gVar.id));
            ContentFragment contentFragment = this.EyM.get(Integer.valueOf(gVar.id));
            if (contentFragment == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("pageInfo", gVar);
                hashMap.put("pageCount", Integer.valueOf(fhf.size()));
                hashMap.put("viewPager", this.ExR);
                hashMap.put("pageDownIconInfo", this.Eim);
                hashMap.put("is_first_show_page", Boolean.TRUE);
                if (fhf.size() == 1) {
                    hashMap.put("is_last_shown_page", Boolean.TRUE);
                }
                hashMap.put("needEnterAnimation", Boolean.valueOf(this.Exx));
                hashMap.put("needDirectionAnimation", Boolean.valueOf(fhi()));
                hashMap.put("groupListCompShowIndex", Integer.valueOf(this.ExL));
                contentFragment = new ContentFragment();
                contentFragment.params = hashMap;
                contentFragment.Eiv = this.EyF;
                this.EyM.put(Integer.valueOf(gVar.id), contentFragment);
            } else {
                contentFragment.a(gVar);
            }
            if (contentFragment != null) {
                bVar.c(contentFragment, 0);
            }
            bVar.notifyDataSetChanged();
            this.ExR.setOffscreenPageLimit(fhf.size());
        }
        AppMethodBeat.o(98378);
    }

    private void fhg() {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b bVar;
        boolean z;
        int i2;
        AppMethodBeat.i(98379);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b bVar2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b) this.ExR.getAdapter();
        if (bVar2 == null) {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b bVar3 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b(getSupportFragmentManager(), new ArrayList());
            this.ExR.setAdapter(bVar3);
            bVar = bVar3;
        } else {
            bVar = bVar2;
        }
        List<g> fhf = fhf();
        int i3 = 0;
        while (i3 < fhf.size()) {
            g gVar = this.Elq.get(i3);
            Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "loadLandingPages load id %s", Integer.valueOf(gVar.id));
            ContentFragment contentFragment = this.EyM.get(Integer.valueOf(gVar.id));
            if (contentFragment == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("pageInfo", gVar);
                hashMap.put("pageCount", Integer.valueOf(fhf.size()));
                hashMap.put("viewPager", this.ExR);
                hashMap.put("pageDownIconInfo", this.Eim);
                hashMap.put("is_first_show_page", Boolean.valueOf(i3 == 0));
                if (i3 == fhf.size() - 1) {
                    z = true;
                } else {
                    z = false;
                }
                hashMap.put("is_last_shown_page", Boolean.valueOf(z));
                hashMap.put("needEnterAnimation", Boolean.valueOf(this.Exx));
                hashMap.put("needDirectionAnimation", Boolean.valueOf(fhi()));
                if (i3 == 0) {
                    i2 = this.ExL;
                } else {
                    i2 = 0;
                }
                hashMap.put("groupListCompShowIndex", Integer.valueOf(i2));
                contentFragment = new ContentFragment();
                contentFragment.params = hashMap;
                if (i3 == 0) {
                    contentFragment.Eiv = this.EyF;
                }
                this.EyM.put(Integer.valueOf(gVar.id), contentFragment);
            } else {
                contentFragment.a(gVar);
            }
            if (contentFragment != null) {
                bVar.c(contentFragment, i3);
            }
            i3++;
        }
        bVar.notifyDataSetChanged();
        this.ExR.setOffscreenPageLimit(fhf.size());
        AppMethodBeat.o(98379);
    }

    public final List<m> getAllComp() {
        AppMethodBeat.i(98380);
        this.ExZ = new ArrayList();
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b bVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b) this.ExR.getAdapter();
        if (bVar != null) {
            Iterator<Fragment> it = bVar.fragments.iterator();
            while (it.hasNext()) {
                this.ExZ.addAll(((ContentFragment) it.next()).fdY());
            }
        }
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.gU(this.ExZ);
        List<m> list = this.ExZ;
        AppMethodBeat.o(98380);
        return list;
    }

    @Override // com.tencent.mm.ui.MMActivity
    @TargetApi(16)
    public void initView() {
        AppMethodBeat.i(98381);
        super.initView();
        this.ExV = (FrameLayout) findViewById(R.id.h8v);
        this.ExX = findViewById(R.id.ben);
        this.ExR = (AdlandingDummyViewPager) findViewById(R.id.j3f);
        this.ExW = findViewById(R.id.fcw);
        this.Eyu = (TwistRoateCardsView) findViewById(R.id.iz_);
        Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "before, assistActivity");
        if (ao.aQ(getContext())) {
            final int aP = ao.aP(this);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ExV.getLayoutParams();
            layoutParams.height = this.mEY - aP;
            layoutParams.topMargin = aP;
            this.ExV.setLayoutParams(layoutParams);
            getController().setActionbarColor(getResources().getColor(R.color.bj));
            this.ExV.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass9 */

                public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    AppMethodBeat.i(203414);
                    try {
                        Rect rect = new Rect();
                        SnsAdNativeLandingPagesUI.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                        int i10 = rect.top;
                        Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "rect=" + rect.toString() + ", screenH=" + SnsAdNativeLandingPagesUI.this.mEY + ", cutH=" + aP + ", statusBarH=" + i10);
                        if (i10 > 0) {
                            if (i10 != aP) {
                                Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "cutH != statusBarH, reset height");
                                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SnsAdNativeLandingPagesUI.this.ExV.getLayoutParams();
                                layoutParams.height = SnsAdNativeLandingPagesUI.this.mEY - i10;
                                layoutParams.topMargin = i10;
                                SnsAdNativeLandingPagesUI.this.ExV.setLayoutParams(layoutParams);
                                j.b(j.DEb, "", aP, i10, SnsAdNativeLandingPagesUI.this.mEX + "|" + SnsAdNativeLandingPagesUI.this.mEY);
                            }
                            SnsAdNativeLandingPagesUI.this.ExV.removeOnLayoutChangeListener(this);
                        }
                        AppMethodBeat.o(203414);
                    } catch (Throwable th) {
                        Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "onLayoutChange error:" + th.toString());
                        SnsAdNativeLandingPagesUI.this.ExV.removeOnLayoutChangeListener(this);
                        AppMethodBeat.o(203414);
                    }
                }
            });
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass10 */

                public final void run() {
                    AppMethodBeat.i(203415);
                    Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "hasCutOut, assistActivity");
                    com.tencent.mm.ui.b.a(SnsAdNativeLandingPagesUI.this, true, SnsAdNativeLandingPagesUI.this.ExV, SnsAdNativeLandingPagesUI.this.EyO);
                    AppMethodBeat.o(203415);
                }
            }, 1500);
        } else {
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass11 */

                public final void run() {
                    AppMethodBeat.i(98342);
                    Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "noCutOut, assistActivity");
                    com.tencent.mm.ui.b.a(SnsAdNativeLandingPagesUI.this, false, SnsAdNativeLandingPagesUI.this.ExV, SnsAdNativeLandingPagesUI.this.EyO);
                    AppMethodBeat.o(98342);
                }
            }, 1500);
        }
        this.jUG = (ImageView) findViewById(R.id.dcj);
        this.Exv = (ImageView) findViewById(R.id.mw);
        this.hTd = (ImageView) findViewById(R.id.hvn);
        this.hTd.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass13 */

            public final void onClick(View view) {
                AppMethodBeat.i(203416);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (SnsAdNativeLandingPagesUI.this.keyboardState() == 1) {
                    SnsAdNativeLandingPagesUI.this.hideVKB();
                }
                SnsAdNativeLandingPagesUI.this.cvQ();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdNativeLandingPagesUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203416);
            }
        });
        this.BQk = (ImageView) findViewById(R.id.hw4);
        this.Exw = (TextView) findViewById(R.id.hw5);
        this.ExE = (ImageView) findViewById(R.id.hz9);
        if (this.Eyw) {
            this.Exv.setVisibility(8);
            if (!this.Eyx) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.jUG, "alpha", 0.0f, 0.2f);
                ofFloat.setDuration(200L);
                ofFloat.start();
                this.ExX.setAlpha(0.0f);
            }
            com.tencent.mm.ui.base.b.a(this, null);
            AppMethodBeat.o(98381);
            return;
        }
        if (this.Exx) {
            this.ExV.setAlpha(0.0f);
            this.jUG.setAlpha(0.0f);
            com.tencent.mm.ui.base.b.a(this, null);
        }
        AppMethodBeat.o(98381);
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public boolean convertActivityFromTranslucent() {
        return false;
    }

    private boolean r(ContentFragment contentFragment) {
        float f2;
        AppMethodBeat.i(203451);
        if (this.EyA == null) {
            Iterator<m> it = contentFragment.fdY().iterator();
            while (true) {
                if (it.hasNext()) {
                    com.tencent.mm.plugin.sns.ad.landingpage.component.a.b b2 = com.tencent.mm.plugin.sns.ad.landingpage.component.a.b.b(it.next());
                    if (b2 != null) {
                        this.EyA = b2;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (this.EyA == null || this.Eyv == null) {
            Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "mEggCardComponent==null");
            AppMethodBeat.o(203451);
            return false;
        }
        if (TextUtils.isEmpty(this.EyB)) {
            Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "start reqTwistCardId, source=" + this.source);
            final long currentTimeMillis = System.currentTimeMillis();
            AdLandingPagesProxy.getInstance().getTwistAdCard(this.uxInfo, this.ExG, this.source, Util.nullAsNil(this.ExI.lAN), "", new AdLandingPagesProxy.e() {
                /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass26 */

                @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e
                public final void h(int i2, int i3, Object obj) {
                    AppMethodBeat.i(203439);
                    SnsAdNativeLandingPagesUI.this.EyB = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.f.i(i2, i3, obj);
                    Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "reqTwistCardId rsp, errType=" + i2 + ", errNo=" + i3 + ", cardId=" + SnsAdNativeLandingPagesUI.this.EyB + ", timeCost=" + (System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(203439);
                }

                @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e
                public final void bn(Object obj) {
                }
            });
        } else {
            Log.w("MicroMsg.SnsAdNativeLandingPagesUI", "skip reqTwistCardId, twistCardId=" + this.EyB);
        }
        if (isSupportNavigationSwipeBack()) {
            getSwipeBackLayout().setEnableGesture(false);
            getSwipeBackLayout().CV(true);
        }
        if (this.Eyx) {
            this.EyA.contentView.setVisibility(4);
        }
        this.Eyu.setVisibility(0);
        this.Eyu.setOnCardAnimListener(new TwistRoateCardsView.a() {
            /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass14 */

            @Override // com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView.a
            public final void eYT() {
                AppMethodBeat.i(203417);
                if (!SnsAdNativeLandingPagesUI.this.Eyx) {
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(SnsAdNativeLandingPagesUI.this.ExX, "alpha", 0.0f, 1.0f);
                    ofFloat.setDuration(500L);
                    ofFloat.start();
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(SnsAdNativeLandingPagesUI.this.jUG, "alpha", SnsAdNativeLandingPagesUI.this.jUG.getAlpha(), 0.0f);
                    ofFloat2.setDuration(300L);
                    ofFloat2.start();
                }
                SnsAdNativeLandingPagesUI.this.ExW.setVisibility(0);
                ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(SnsAdNativeLandingPagesUI.this.ExW, "alpha", 0.0f, 1.0f);
                ofFloat3.setDuration(500L);
                ofFloat3.start();
                SnsAdNativeLandingPagesUI.this.EyA.contentView.setVisibility(0);
                AppMethodBeat.o(203417);
            }

            @Override // com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView.a
            public final void eYU() {
                AppMethodBeat.i(203418);
                if (SnsAdNativeLandingPagesUI.this.isSupportNavigationSwipeBack()) {
                    SnsAdNativeLandingPagesUI.this.getSwipeBackLayout().setEnableGesture(true);
                }
                SnsAdNativeLandingPagesUI.u(SnsAdNativeLandingPagesUI.this);
                SnsAdNativeLandingPagesUI.U(SnsAdNativeLandingPagesUI.this);
                SnsAdNativeLandingPagesUI.this.Eyu.setVisibility(8);
                if (SnsAdNativeLandingPagesUI.this.EyA != null) {
                    SnsAdNativeLandingPagesUI.this.EyA.eXc();
                }
                AppMethodBeat.o(203418);
            }

            @Override // com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView.a
            public final void eYV() {
                z zVar;
                AppMethodBeat.i(203419);
                String str = SnsAdNativeLandingPagesUI.this.EyB;
                Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "onPrepareCard, twistId=".concat(String.valueOf(str)));
                com.tencent.mm.plugin.sns.ad.landingpage.component.a.b bVar = SnsAdNativeLandingPagesUI.this.EyA;
                if (!TextUtils.isEmpty(str)) {
                    Iterator<z> it = bVar.Dto.aQz.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        zVar = it.next();
                        if (str.equals(zVar.DZu)) {
                            break;
                        }
                    }
                }
                zVar = null;
                if (zVar == null) {
                    zVar = bVar.eWV();
                }
                ArrayList arrayList = new ArrayList();
                if (zVar != null) {
                    arrayList.add(zVar);
                }
                if (bVar.Dtq == null) {
                    bVar.Dtq = new l(arrayList, bVar.context, (FrameLayout) bVar.contentView);
                    bVar.Dtq.layout();
                    bVar.Dtp = bVar.eWU();
                } else {
                    bVar.Dtq.gV(arrayList);
                }
                if (TextUtils.isEmpty(str)) {
                    TwistCoverView.a(SnsAdNativeLandingPagesUI.this.fds(), 2);
                } else {
                    TwistCoverView.a(SnsAdNativeLandingPagesUI.this.fds(), 1);
                }
                SnsAdNativeLandingPagesUI.this.Eyz = com.tencent.mm.plugin.sns.ad.landingpage.component.a.b.a(SnsAdNativeLandingPagesUI.this.EyA);
                if (SnsAdNativeLandingPagesUI.this.Eyz != null) {
                    SnsAdNativeLandingPagesUI.this.Eyu.setAnimCardView(SnsAdNativeLandingPagesUI.this.Eyz);
                    AppMethodBeat.o(203419);
                    return;
                }
                Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "mTwistCardAnimView==null");
                AppMethodBeat.o(203419);
            }
        });
        Pair<Integer, Integer> eWW = this.EyA.eWW();
        TwistRoateCardsView twistRoateCardsView = this.Eyu;
        int intValue = ((Integer) eWW.first).intValue();
        int intValue2 = ((Integer) eWW.second).intValue();
        boolean z = this.Eyv.DWV;
        String str = this.EyA.Dto.DtQ;
        String str2 = this.EyA.Dto.DtR;
        org.xwalk.core.Log.i("TwistRoateCardsView", "initData, defBgColor=" + str2 + ", imgUrl=" + str);
        twistRoateCardsView.DCD = str;
        if (!TextUtils.isEmpty(str2)) {
            try {
                twistRoateCardsView.DCE = Color.parseColor(str2);
            } catch (Exception e2) {
                org.xwalk.core.Log.e("TwistRoateCardsView", "parseColor exp=" + e2.toString());
            }
        }
        if (intValue <= 0 || intValue2 <= 0) {
            org.xwalk.core.Log.e("TwistRoateCardsView", "initData, size is 0, w=" + intValue + ", h=" + intValue2);
            twistRoateCardsView.DCv = com.tencent.mm.cb.a.fromDPToPix(twistRoateCardsView.mContext, (int) TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS);
            twistRoateCardsView.DCw = com.tencent.mm.cb.a.fromDPToPix(twistRoateCardsView.mContext, 375);
        } else {
            twistRoateCardsView.DCv = (int) (((float) intValue) * 0.75f);
            twistRoateCardsView.DCw = (int) (((float) intValue2) * 0.75f);
        }
        twistRoateCardsView.DCu = com.tencent.mm.cb.a.fromDPToPix(twistRoateCardsView.mContext, 200) + (twistRoateCardsView.DCw / 2);
        twistRoateCardsView.DsW = z;
        if (twistRoateCardsView.DsW) {
            twistRoateCardsView.DCC = 3;
        } else {
            twistRoateCardsView.DCC = 9;
        }
        twistRoateCardsView.removeAllViews();
        twistRoateCardsView.eYS();
        TwistRoateCardsView twistRoateCardsView2 = this.Eyu;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(twistRoateCardsView2, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(1500L);
        if (twistRoateCardsView2.DsW) {
            f2 = -180.0f;
        } else {
            f2 = 180.0f;
        }
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(f2, 0.0f);
        ofFloat2.setDuration(1500L);
        ofFloat2.addUpdateListener(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0181: INVOKE  
              (r0v33 'ofFloat2' android.animation.ValueAnimator)
              (wrap: com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView$2 : 0x017e: CONSTRUCTOR  (r3v3 com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView$2) = (r1v12 'twistRoateCardsView2' com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView) call: com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView.2.<init>(com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView):void type: CONSTRUCTOR)
             type: VIRTUAL call: android.animation.ValueAnimator.addUpdateListener(android.animation.ValueAnimator$AnimatorUpdateListener):void in method: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.r(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment):boolean, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x017e: CONSTRUCTOR  (r3v3 com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView$2) = (r1v12 'twistRoateCardsView2' com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView) call: com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView.2.<init>(com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.r(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment):boolean, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 18 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 24 more
            */
        /*
        // Method dump skipped, instructions count: 558
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.r(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment):boolean");
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.buw;
    }

    private boolean fhh() {
        AppMethodBeat.i(98382);
        if (this.ExS == 0) {
            AppMethodBeat.o(98382);
            return true;
        } else if ((this.ExS & 4) == 0 || (this.ExS & 2) == 0 || ((fhl() && this.bizId == 2) || (this.ExS & 1) == 0 || (this.ExS & 32) == 0)) {
            AppMethodBeat.o(98382);
            return true;
        } else {
            AppMethodBeat.o(98382);
            return false;
        }
    }

    private boolean fhi() {
        return (this.ExS & 8) == 0;
    }

    private boolean fhj() {
        return this.ExT == 0;
    }

    private boolean fhk() {
        AppMethodBeat.i(98383);
        if (Util.isNullOrNil(this.ExB) || Util.isNullOrNil(this.ExC)) {
            AppMethodBeat.o(98383);
            return false;
        }
        AppMethodBeat.o(98383);
        return true;
    }

    private boolean fhl() {
        return (this.ExS & 16) == 0;
    }

    public final void cvQ() {
        AppMethodBeat.i(98384);
        try {
            for (SnsAdLandingPageFloatView snsAdLandingPageFloatView : this.Eyf.values()) {
                snsAdLandingPageFloatView.onPause();
                snsAdLandingPageFloatView.setVisibility(8);
            }
            hideVKB();
            fgX();
            fgZ();
            report();
            this.ExK = true;
            this.ExW.setVisibility(8);
            if (!this.Exx) {
                finish();
                AppMethodBeat.o(98384);
            } else if (this.Eyd) {
                Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "is playing animation");
                AppMethodBeat.o(98384);
            } else {
                Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "run exit animation, %s", Boolean.valueOf(this.Exx));
                this.Eyd = true;
                if (isSupportNavigationSwipeBack()) {
                    getSwipeBackLayout().setEnableGesture(false);
                }
                for (m mVar : fhn().fdY()) {
                    if (mVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) {
                        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) mVar).fcJ();
                        mVar.fdq();
                    }
                }
                fgS();
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass17 */

                    public final void run() {
                        AppMethodBeat.i(203427);
                        SnsAdNativeLandingPagesUI.Z(SnsAdNativeLandingPagesUI.this);
                        AppMethodBeat.o(203427);
                    }
                }, 30);
                AppMethodBeat.o(98384);
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SnsAdNativeLandingPagesUI", e2, "play exit animation error", new Object[0]);
            finish();
            AppMethodBeat.o(98384);
        }
    }

    private aj fhm() {
        AppMethodBeat.i(98385);
        for (m mVar : fhn().fdY()) {
            if (mVar instanceof aj) {
                aj ajVar = (aj) mVar;
                AppMethodBeat.o(98385);
                return ajVar;
            }
        }
        AppMethodBeat.o(98385);
        return null;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(98386);
        cvQ();
        AppMethodBeat.o(98386);
    }

    private ContentFragment fhn() {
        AppMethodBeat.i(98387);
        ContentFragment contentFragment = null;
        if (this.Elq.size() > 0) {
            contentFragment = this.EyM.get(Integer.valueOf(this.Elq.get(this.ExR.getCurrentItem()).id));
        }
        AppMethodBeat.o(98387);
        return contentFragment;
    }

    private a fho() {
        int adVoteIndex;
        AppMethodBeat.i(98388);
        ADXml aDXml = new ADXml(this.Exz);
        if (!aDXml.hasVoteInfo() || (adVoteIndex = AdLandingPagesProxy.getInstance().getAdVoteIndex(aDXml.adVoteInfo.DWX, this.uxInfo, this.uin)) <= 0 || adVoteIndex > aDXml.adVoteInfo.DWZ.size()) {
            AppMethodBeat.o(98388);
            return null;
        }
        ADXml.m mVar = aDXml.adVoteInfo.DWZ.get(adVoteIndex - 1);
        a aVar = new a(this, (byte) 0);
        if (!Util.isNullOrNil(mVar.msN)) {
            aVar.msN = mVar.msN;
        } else {
            aVar.msN = this.msN;
        }
        if (!Util.isNullOrNil(mVar.xDQ)) {
            aVar.xDQ = mVar.xDQ;
        } else {
            aVar.xDQ = this.xDQ;
        }
        if (!Util.isNullOrNil(mVar.DXa)) {
            aVar.DXa = mVar.DXa;
        } else {
            aVar.DXa = this.ExF;
        }
        AppMethodBeat.o(98388);
        return aVar;
    }

    private String aQZ(String str) {
        AppMethodBeat.i(98389);
        String nullAs = Util.nullAs(this.values.get("." + this.ExA + ".adCanvasInfo.shareThumbUrl"), "");
        if (!Util.isNullOrNil(nullAs)) {
            AppMethodBeat.o(98389);
            return nullAs;
        }
        AppMethodBeat.o(98389);
        return str;
    }

    private String fhp() {
        AppMethodBeat.i(98390);
        eco eco = new eco();
        eco.NcH = new ecp();
        eco.NcH.KxO = this.ExI.uxInfo;
        eco.NcH.NcK = this.ExI.dRS;
        eco.NcH.adType = this.adType;
        try {
            String encodeToString = Base64.encodeToString(eco.toByteArray(), 2);
            AppMethodBeat.o(98390);
            return encodeToString;
        } catch (Exception e2) {
            AppMethodBeat.o(98390);
            return "";
        }
    }

    private String fhq() {
        AppMethodBeat.i(98391);
        try {
            String replaceAll = this.Exz.replaceAll("(?s)<adCanvasInfoLeft[^>]*>.*?</adCanvasInfoLeft>", "").replaceAll("(?s)<adCanvasInfoRight[^>]*>.*?</adCanvasInfoRight>", "");
            if (replaceAll != null && replaceAll.contains("<adFullCardGestureCanvasInfo>")) {
                replaceAll = replaceAll.replaceAll("(?s)<adFullCardGestureCanvasInfo[^>]*>.*?</adFullCardGestureCanvasInfo>", "");
            }
            if (replaceAll.contains("<shareAdCanvasInfo>")) {
                replaceAll = replaceAll.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replace("shareAdCanvasInfo", "adCanvasInfo");
            }
            AppMethodBeat.o(98391);
            return replaceAll;
        } catch (Throwable th) {
            Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "genForwardXml, exp=" + th.toString());
            String str = this.Exz;
            AppMethodBeat.o(98391);
            return str;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(98392);
        if (i2 == 2001) {
            if (i3 == -1) {
                Log.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "share to timeLine success");
                try {
                    String A = com.tencent.mm.plugin.sns.a.b.A(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, "", Util.nullAsNil(this.uxInfo), Util.nullAsNil(this.ExI.lAN));
                    Log.i("AntiCheatingReportUtils", "reportScreenShotParams = ".concat(String.valueOf(A)));
                    h.INSTANCE.kvStat(19214, A);
                } catch (Throwable th) {
                    Log.e("AntiCheatingReportUtils", th.toString());
                }
                com.tencent.mm.ui.base.h.cD(getContext(), getContext().getString(R.string.z0));
            }
        } else if (i2 == 2) {
            Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "handleOpenInBrowserResult, ret=".concat(String.valueOf(((aa) com.tencent.mm.kernel.g.af(aa.class)).a(this, i2, i3, intent))));
        } else if (i2 == 2002) {
            if (com.tencent.mm.plugin.sns.ad.i.g.getBooleanExtra(intent, "kfavorite", false)) {
                ((v) com.tencent.mm.kernel.g.af(v.class)).a(AdLandingPagesProxy.getInstance().doFav(intent, 42), 42, this, this.xxK);
            }
        } else if (i2 == 2004) {
            try {
                String stringExtra = intent.getStringExtra("KComponentCid");
                Iterator<m> it = getAllComp().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    m next = it.next();
                    if (next.fdn().equals(stringExtra)) {
                        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah ahVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah) next;
                        int intExtra = intent.getIntExtra("KStreamVideoPlayCount", 0);
                        int intExtra2 = intent.getIntExtra("KStreamVideoPlayCompleteCount", 0);
                        int intExtra3 = intent.getIntExtra("KStreamVideoTotalPlayTimeInMs", 0);
                        ahVar.DvS = intExtra + ahVar.DvS;
                        ahVar.DvT += intExtra2;
                        ahVar.DvU += intExtra3;
                        break;
                    }
                }
            } catch (Exception e2) {
            }
        } else if (i2 == 2003) {
            vf vfVar = new vf();
            vfVar.ebD.EX = 1;
            vfVar.ebD.requestCode = i2;
            vfVar.ebD.resultCode = i3;
            vfVar.ebD.dQs = intent;
            EventCenter.instance.publish(vfVar);
        } else if (i2 == 2000) {
            try {
                String stringExtra2 = intent.getStringExtra("KComponentCid");
                Iterator<m> it2 = getAllComp().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    m next2 = it2.next();
                    if (next2.fdn().equals(stringExtra2)) {
                        int intExtra4 = intent.getIntExtra("KComponentVideoType", 0);
                        int intExtra5 = intent.getIntExtra("KComponentCurrentTime", 0);
                        boolean booleanExtra = intent.getBooleanExtra("KComponentVoiceType", false);
                        boolean booleanExtra2 = intent.getBooleanExtra("KComponentProgressType", false);
                        int intExtra6 = intent.getIntExtra("KComponentClickPlayControlCount", 0);
                        int intExtra7 = intent.getIntExtra("KComponentDoubleClickCount", 0);
                        int intExtra8 = intent.getIntExtra("KComponentClickVoiceControlCount", 0);
                        int intExtra9 = intent.getIntExtra("KComponentPlayCompletedCount", 0);
                        int intExtra10 = intent.getIntExtra("KComponentPlayCount", 0);
                        long longExtra = intent.getLongExtra("KComponentPlayTimeInterval", 0);
                        boolean booleanExtra3 = intent.getBooleanExtra("KComponentIsWaiting", false);
                        int intExtra11 = intent.getIntExtra("KComponentSeekTimeDueWaiting", 0);
                        String stringExtra3 = intent.getStringExtra("KComponentFullVideoFloatBarReportInfo");
                        long longExtra2 = intent.getLongExtra("KComponentFullScreenStayTime", 0);
                        this.dUy += longExtra2;
                        Log.i("VideoFullScreenActivity", "videoType = " + intExtra4 + ", cid = " + stringExtra2 + ", currPosSec = " + intExtra5 + ", bNoVoice = " + booleanExtra + ", isPlaying = " + booleanExtra2 + ", clickPlayControlCount = " + intExtra6 + ", doubleClickCount = " + intExtra7 + ", clickVoiceControlCount = " + intExtra8 + ", playCompletedCount = " + intExtra9 + ", playCount = " + intExtra10 + ", playTimeInterval = " + longExtra + ", floatBarReportInfo = " + stringExtra3 + ", fullScreenStayTime = " + longExtra2);
                        if (intExtra4 == 0) {
                            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah) next2).a(intExtra5, booleanExtra, booleanExtra2, intExtra6, intExtra7, intExtra8, intExtra9, intExtra10, longExtra, stringExtra3, longExtra2);
                        } else if (intExtra4 == 1) {
                            ((al) next2).a(intExtra5, booleanExtra, booleanExtra2, intExtra6, intExtra7, intExtra8, intExtra9, intExtra10, longExtra, booleanExtra3, intExtra11, stringExtra3, longExtra2);
                        }
                    }
                }
            } catch (Throwable th2) {
                Log.e("VideoFullScreenActivity", th2.toString());
            }
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(98392);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void onKeyboardStateChanged() {
        AppMethodBeat.i(98393);
        super.onKeyboardStateChanged();
        Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "onKeyboardStateChanged, state=" + keyboardState());
        if (this.ExR != null) {
            this.ExR.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass21 */

                public final void run() {
                    AppMethodBeat.i(203433);
                    if (SnsAdNativeLandingPagesUI.this.keyboardState() != 1) {
                        ap.aK(SnsAdNativeLandingPagesUI.this);
                    }
                    if (!SnsAdNativeLandingPagesUI.this.Eye) {
                        new ArrayList();
                        Iterator<Fragment> it = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b) SnsAdNativeLandingPagesUI.this.ExR.getAdapter()).fragments.iterator();
                        while (it.hasNext()) {
                            SnsAdNativeLandingPagesUI.this.keyboardState();
                            ((ContentFragment) it.next()).fdZ();
                        }
                    }
                    AppMethodBeat.o(203433);
                }
            }, 500);
        }
        AppMethodBeat.o(98393);
    }

    /* access modifiers changed from: package-private */
    public class a {
        public String DXa;
        public String msN;
        public String xDQ;

        private a() {
            this.msN = "";
            this.xDQ = "";
            this.DXa = "";
        }

        /* synthetic */ a(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI, byte b2) {
            this();
        }
    }

    public final void vp(boolean z) {
        AppMethodBeat.i(98394);
        if (z && this.bizId == 1) {
            AdLandingPagesProxy.getInstance().doDynamicUpdateScene(this.ExN, this.ExO, this.ExP, this.EyH);
        }
        if (this.bizId == 2 && !Util.isNullOrNil(this.ExQ)) {
            AdLandingPagesProxy.getInstance().doSearchDynamicUpdateScene(this.ExQ, this.EyH);
        }
        this.ExM = true;
        AppMethodBeat.o(98394);
    }

    public final void a(z zVar, String str, String str2, String str3, boolean z, boolean z2, final boolean z3) {
        AppMethodBeat.i(98395);
        if (this.EyQ == null || z3) {
            AnonymousClass24 r9 = new AdLandingPagesProxy.e() {
                /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass24 */

                @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e
                public final void bn(Object obj) {
                }

                @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e
                public final void h(int i2, int i3, Object obj) {
                    AppMethodBeat.i(203435);
                    SnsAdNativeLandingPagesUI.this.vp(false);
                    if (z3) {
                        if (SnsAdNativeLandingPagesUI.this.EyQ != null) {
                            SnsAdNativeLandingPagesUI.this.EyQ.bMo();
                        }
                        if (SnsAdNativeLandingPagesUI.this.EyR != null) {
                            SnsAdNativeLandingPagesUI.this.EyR.dismiss();
                            SnsAdNativeLandingPagesUI.this.EyR = null;
                        }
                    }
                    AppMethodBeat.o(203435);
                }
            };
            if (!z3) {
                m a2 = ay.a(getContext(), zVar, new LinearLayout(getContext()), !Util.isNullOrNil(zVar.DZn) ? Color.parseColor(zVar.DZn) : -1);
                this.EyQ = new n(getContext(), a2, str, str2, str3, z, z2);
                final View view = a2.getView();
                this.EyQ.Edg = new n.a() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass25 */

                    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.a
                    public final void fdt() {
                        AppMethodBeat.i(203436);
                        Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "onDismiss");
                        onRemove();
                        AppMethodBeat.o(203436);
                    }

                    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.a
                    public final void fdu() {
                        AppMethodBeat.i(203437);
                        Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "onCancel");
                        onRemove();
                        AppMethodBeat.o(203437);
                    }

                    private void onRemove() {
                        AppMethodBeat.i(203438);
                        if (!(view == null || view.getParent() == null)) {
                            ((ViewGroup) view.getParent()).removeView(view);
                        }
                        SnsAdNativeLandingPagesUI.this.EyQ = null;
                        AppMethodBeat.o(203438);
                    }
                };
                this.EyQ.dGm();
            }
            if (!Util.isNullOrNil(str)) {
                AdLandingPagesProxy.getInstance().doFavOfficialItemScene(str, r9);
                if (z3) {
                    this.EyR = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.h82), false, (DialogInterface.OnCancelListener) null);
                }
            }
            AppMethodBeat.o(98395);
            return;
        }
        Log.w("MicroMsg.SnsAdNativeLandingPagesUI", "bottom sheet appear several times");
        this.EyQ.bMo();
        if (this.EyR != null) {
            this.EyR.dismiss();
            this.EyR = null;
        }
        AppMethodBeat.o(98395);
    }

    public final void J(Context context, String str, String str2) {
        AppMethodBeat.i(98396);
        Intent intent = new Intent();
        intent.putExtra("sns_landig_pages_from_source", 14);
        intent.putExtra("sns_landig_pages_origin_from_source", this.DZU == 0 ? this.source : this.DZU);
        intent.putExtra("sns_landing_pages_canvasid", str);
        intent.putExtra("sns_landing_pages_canvas_ext", str2);
        intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
        intent.putExtra("sns_landing_pages_no_store", 1);
        String stringExtra = ((Activity) context).getIntent().getStringExtra("sns_landing_pages_sessionId");
        String stringExtra2 = ((Activity) context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
        if (!Util.isNullOrNil(stringExtra)) {
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sessionId", valueOf);
                jSONObject.put("cid", "");
                jSONObject.put("adBuffer", !Util.isNullOrNil(stringExtra2) ? stringExtra2 : "");
                jSONObject.put("preSessionId", stringExtra);
            } catch (Exception e2) {
            }
            intent.putExtra("sns_landing_pages_search_extra", jSONObject.toString());
            intent.putExtra("sns_landing_pages_sessionId", valueOf);
            intent.putExtra("sns_landing_pages_ad_buffer", stringExtra2);
        }
        com.tencent.mm.br.c.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
        AppMethodBeat.o(98396);
    }

    public final void fhr() {
        AppMethodBeat.i(203452);
        try {
            boolean fhs = fhs();
            Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "jumpNextPage, hasNextPage=".concat(String.valueOf(fhs)));
            if (fhs) {
                this.ExR.setCurrentItem$2563266(this.ExR.getCurrentItem() + 1);
            }
            AppMethodBeat.o(203452);
        } catch (Exception e2) {
            Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "jumpNextPage exp:" + e2.toString());
            AppMethodBeat.o(203452);
        }
    }

    public final boolean fhs() {
        AppMethodBeat.i(98397);
        try {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b bVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b) this.ExR.getAdapter();
            int currentItem = this.ExR.getCurrentItem();
            Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "hasNextPage, curPage=" + currentItem + ", pageCount=" + bVar.getCount());
            if (currentItem < bVar.getCount() - 1) {
                AppMethodBeat.o(98397);
                return true;
            }
            AppMethodBeat.o(98397);
            return false;
        } catch (Exception e2) {
            Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "hasNextPage exp:" + e2.toString());
            AppMethodBeat.o(98397);
            return true;
        }
    }

    private void b(i.a aVar) {
        AppMethodBeat.i(203453);
        try {
            if (!(aVar.Els == null || this.ExX == null)) {
                this.Eyr = FloatWebViewHelper.a(aVar.Els, (ViewGroup) this.ExX);
                getLifecycle().addObserver(this.Eyr);
            }
            AppMethodBeat.o(203453);
        } catch (Throwable th) {
            AppMethodBeat.o(203453);
        }
    }

    private void c(i.a aVar) {
        com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.b a2;
        AppMethodBeat.i(203454);
        try {
            fht();
            if (!(this.Eyg == null || (a2 = this.Eyg.a(aVar)) == null)) {
                a2.C((ViewGroup) this.ExX);
                a2.eXl();
            }
            AppMethodBeat.o(203454);
        } catch (Throwable th) {
            AppMethodBeat.o(203454);
        }
    }

    private void d(i.a aVar) {
        FloatJumpCompHelper a2;
        AppMethodBeat.i(203455);
        try {
            fht();
            if (!(aVar.Elt == null || this.ExX == null || this.Eyg == null || (a2 = this.Eyg.a(aVar.Elt, (ViewGroup) this.ExX)) == null)) {
                this.EyS = a2;
                getLifecycle().addObserver(a2);
                if (aVar.Elt.DtV != null) {
                    String str = aVar.Elt.DtV.DYr;
                    if (!TextUtils.isEmpty(str)) {
                        this.Eyl.add(str);
                    }
                }
            }
            AppMethodBeat.o(203455);
        } catch (Throwable th) {
            AppMethodBeat.o(203455);
        }
    }

    private void fht() {
        AppMethodBeat.i(203456);
        if (this.Eyg == null) {
            this.Eyg = new com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.a();
        }
        AppMethodBeat.o(203456);
    }

    private void fhu() {
        AppMethodBeat.i(98398);
        if (!(this.Exu == null || this.ExV == null || this.Eyh != null)) {
            this.Eyh = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d(this, this.Exu, this.ExV);
            k(false, 0);
            if (this.Exu.DZH instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) {
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q qVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.Exu.DZH;
                if (!TextUtils.isEmpty(qVar.DYr)) {
                    this.Eyl.add(qVar.DYr);
                }
            }
        }
        AppMethodBeat.o(98398);
    }

    private void s(ContentFragment contentFragment) {
        AppMethodBeat.i(98399);
        if (!fhv()) {
            contentFragment.fed();
        }
        AppMethodBeat.o(98399);
    }

    public final boolean fhv() {
        AppMethodBeat.i(98400);
        if (this.Eyh != null) {
            boolean isShowing = this.Eyh.isShowing();
            AppMethodBeat.o(98400);
            return isShowing;
        }
        AppMethodBeat.o(98400);
        return false;
    }

    private void JP(long j2) {
        AppMethodBeat.i(98401);
        if (this.Eyh != null) {
            Log.d("MicroMsg.SnsAdNativeLandingPagesUI", "showFloatBarView");
            this.Eyh.JA(j2);
            ContentFragment fhn = fhn();
            if (fhn != null) {
                fhn.fee();
            }
        }
        AppMethodBeat.o(98401);
    }

    public final void k(boolean z, long j2) {
        AppMethodBeat.i(98402);
        if (this.Eyh != null) {
            Log.d("MicroMsg.SnsAdNativeLandingPagesUI", "hideFloatBarView");
            this.Eyh.j(z, j2);
        }
        AppMethodBeat.o(98402);
    }

    public final void JC(long j2) {
        AppMethodBeat.i(98403);
        if (this.Eyh == null || this.Exu == null) {
            AppMethodBeat.o(98403);
            return;
        }
        ContentFragment fhn = fhn();
        if (fhn == null) {
            AppMethodBeat.o(98403);
            return;
        }
        boolean fhw = fhw();
        boolean feb = fhn.feb();
        boolean z = this.Eyj;
        boolean z2 = fhn.Ein;
        boolean z3 = fhn.jUX;
        boolean fea = fhn.fea();
        boolean z4 = this.Eyi;
        boolean feh = fhn.feh();
        boolean feg = fhn.feg();
        if (z2 && feh) {
            this.Eyk = true;
        }
        if (!z2) {
            this.Eyk = true;
        }
        Log.d("MicroMsg.SnsAdNativeLandingPagesUI", "toggleFloatBarView, isSourceAllow=" + fhw + ", isForbid=" + feb + ", isKeybordShow=" + z + ", isFirstPage=" + z2 + ", isLastPage=" + z3 + ", isCoverVideo=" + fea + ", isVideoCtrlBarShow=" + z4 + ", isTopAppearOk=" + feh + ", isBottomAppearOk=" + feg + ", IsTopAppearChecked=" + this.Eyk);
        if (!fhw) {
            k(false, 0);
            AppMethodBeat.o(98403);
        } else if (feb) {
            k(true, 0);
            AppMethodBeat.o(98403);
        } else if (z) {
            k(false, 0);
            AppMethodBeat.o(98403);
        } else if (fea && z4) {
            k(true, 200);
            AppMethodBeat.o(98403);
        } else if (z3 && !feg) {
            k(true, 0);
            AppMethodBeat.o(98403);
        } else if (!z2 || feh || this.Eyk) {
            JP(j2);
            AppMethodBeat.o(98403);
        } else {
            AppMethodBeat.o(98403);
        }
    }

    private boolean fhw() {
        AppMethodBeat.i(98404);
        if (this.Exu == null) {
            AppMethodBeat.o(98404);
            return false;
        } else if (this.Exu.DZG == 1) {
            boolean YU = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u.YU(this.source);
            AppMethodBeat.o(98404);
            return YU;
        } else {
            AppMethodBeat.o(98404);
            return true;
        }
    }

    static /* synthetic */ void a(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI, final RecyclerView recyclerView, int i2, int i3) {
        AppMethodBeat.i(203460);
        if (snsAdNativeLandingPagesUI.Eyd) {
            Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "is playing animation");
            AppMethodBeat.o(203460);
            return;
        }
        snsAdNativeLandingPagesUI.Eyd = true;
        if (snsAdNativeLandingPagesUI.isSupportNavigationSwipeBack()) {
            snsAdNativeLandingPagesUI.getSwipeBackLayout().setEnableGesture(false);
            snsAdNativeLandingPagesUI.getSwipeBackLayout().CV(true);
        }
        if (snsAdNativeLandingPagesUI.Eyy) {
            int width = snsAdNativeLandingPagesUI.ExV.getWidth();
            int height = snsAdNativeLandingPagesUI.ExV.getHeight();
            snsAdNativeLandingPagesUI.ExX.setVisibility(0);
            snsAdNativeLandingPagesUI.ExW.setVisibility(0);
            snsAdNativeLandingPagesUI.ExX.setAlpha(0.0f);
            snsAdNativeLandingPagesUI.jUG.setAlpha(0.0f);
            snsAdNativeLandingPagesUI.ExW.setAlpha(0.0f);
            Bundle bundle = new Bundle();
            bundle.putInt("param_thumb_left", snsAdNativeLandingPagesUI.qaG);
            bundle.putInt("param_thumb_top", snsAdNativeLandingPagesUI.qaF);
            bundle.putInt("param_thumb_width", snsAdNativeLandingPagesUI.qaH);
            bundle.putInt("param_thumb_height", snsAdNativeLandingPagesUI.qaI);
            bundle.putInt("param_target_width", width);
            bundle.putInt("param_target_height", height);
            snsAdNativeLandingPagesUI.Eyb = new e(snsAdNativeLandingPagesUI, snsAdNativeLandingPagesUI.Exv, bundle, snsAdNativeLandingPagesUI.Eyv.DWV);
            snsAdNativeLandingPagesUI.Eyb.a(new com.tencent.mm.plugin.sns.ui.b.b() {
                /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass15 */

                @Override // com.tencent.mm.plugin.sns.ui.b.b
                public final void onAnimationStart() {
                }

                @Override // com.tencent.mm.plugin.sns.ui.b.b
                public final void bX(float f2) {
                    AppMethodBeat.i(203420);
                    SnsAdNativeLandingPagesUI.this.jUG.setAlpha(1.0f - f2);
                    SnsAdNativeLandingPagesUI.this.ExX.setAlpha(1.0f - f2);
                    SnsAdNativeLandingPagesUI.this.ExW.setAlpha(1.0f - f2);
                    AppMethodBeat.o(203420);
                }

                @Override // com.tencent.mm.plugin.sns.ui.b.b
                public final void onAnimationEnd() {
                    AppMethodBeat.i(203421);
                    SnsAdNativeLandingPagesUI.this.Eyd = false;
                    SnsAdNativeLandingPagesUI.this.Exv.setVisibility(8);
                    SnsAdNativeLandingPagesUI.u(SnsAdNativeLandingPagesUI.this);
                    SnsAdNativeLandingPagesUI.U(SnsAdNativeLandingPagesUI.this);
                    if (!SnsAdNativeLandingPagesUI.this.Eyt && SnsAdNativeLandingPagesUI.this.isSupportNavigationSwipeBack()) {
                        SnsAdNativeLandingPagesUI.this.getSwipeBackLayout().setEnableGesture(true);
                    }
                    AppMethodBeat.o(203421);
                }
            });
            snsAdNativeLandingPagesUI.Exv.setVisibility(0);
            snsAdNativeLandingPagesUI.Eyb.fkj();
            AdLandingPagesProxy.getInstance().playTimelineClickAnimation(0);
            AppMethodBeat.o(203460);
            return;
        }
        if (snsAdNativeLandingPagesUI.Eya == null) {
            snsAdNativeLandingPagesUI.Eya = new c(snsAdNativeLandingPagesUI, snsAdNativeLandingPagesUI.Exv, snsAdNativeLandingPagesUI.Exy);
            AdLandingPagesProxy.getInstance().playTimelineClickAnimation(0);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("param_thumb_left", snsAdNativeLandingPagesUI.qaG);
            bundle2.putInt("param_thumb_top", snsAdNativeLandingPagesUI.qaF);
            bundle2.putInt("param_thumb_width", snsAdNativeLandingPagesUI.qaH);
            bundle2.putInt("param_thumb_height", snsAdNativeLandingPagesUI.qaI);
            bundle2.putInt("param_target_width", i2);
            bundle2.putInt("param_target_height", i3);
            snsAdNativeLandingPagesUI.Eya.aG(bundle2);
            snsAdNativeLandingPagesUI.Eya.a(new com.tencent.mm.plugin.sns.ui.b.b() {
                /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass16 */

                @Override // com.tencent.mm.plugin.sns.ui.b.b
                public final void onAnimationStart() {
                    AppMethodBeat.i(203424);
                    Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "sns enter anim start");
                    if (SnsAdNativeLandingPagesUI.this.Exy) {
                        SnsAdNativeLandingPagesUI.this.ExX.setVisibility(0);
                        recyclerView.setVisibility(4);
                        AppMethodBeat.o(203424);
                        return;
                    }
                    SnsAdNativeLandingPagesUI.this.ExX.setVisibility(4);
                    AppMethodBeat.o(203424);
                }

                @Override // com.tencent.mm.plugin.sns.ui.b.b
                public final void bX(float f2) {
                    AppMethodBeat.i(203425);
                    SnsAdNativeLandingPagesUI.this.jUG.setAlpha(1.0f - f2);
                    SnsAdNativeLandingPagesUI.this.ExX.setAlpha(1.0f - f2);
                    AppMethodBeat.o(203425);
                }

                @Override // com.tencent.mm.plugin.sns.ui.b.b
                public final void onAnimationEnd() {
                    AppMethodBeat.i(203426);
                    SnsAdNativeLandingPagesUI.this.Eyd = false;
                    Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "sns enter anim end");
                    SnsAdNativeLandingPagesUI.this.ExW.setVisibility(0);
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(200);
                    SnsAdNativeLandingPagesUI.this.ExW.startAnimation(alphaAnimation);
                    if (SnsAdNativeLandingPagesUI.this.Exy) {
                        recyclerView.setVisibility(0);
                        recyclerView.getChildAt(0).setAlpha(0.01f);
                        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                        alphaAnimation2.setDuration(150);
                        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) com.tencent.mm.cb.a.fromDPToPix((Context) SnsAdNativeLandingPagesUI.this, 15), 0.0f);
                        translateAnimation.setDuration(150);
                        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                            /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass16.AnonymousClass1 */

                            public final void onAnimationStart(Animation animation) {
                            }

                            public final void onAnimationEnd(Animation animation) {
                                AppMethodBeat.i(203423);
                                recyclerView.getChildAt(0).setAlpha(1.0f);
                                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                                alphaAnimation.setDuration(1);
                                alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                                    /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass16.AnonymousClass1.AnonymousClass1 */

                                    public final void onAnimationStart(Animation animation) {
                                    }

                                    public final void onAnimationEnd(Animation animation) {
                                        AppMethodBeat.i(203422);
                                        SnsAdNativeLandingPagesUI.this.Exv.setVisibility(8);
                                        AppMethodBeat.o(203422);
                                    }

                                    public final void onAnimationRepeat(Animation animation) {
                                    }
                                });
                                SnsAdNativeLandingPagesUI.this.Exv.startAnimation(alphaAnimation);
                                AppMethodBeat.o(203423);
                            }

                            public final void onAnimationRepeat(Animation animation) {
                            }
                        });
                        AnimationSet animationSet = new AnimationSet(false);
                        animationSet.addAnimation(alphaAnimation2);
                        animationSet.addAnimation(translateAnimation);
                        recyclerView.startAnimation(animationSet);
                    } else {
                        SnsAdNativeLandingPagesUI.this.ExX.setVisibility(0);
                    }
                    SnsAdNativeLandingPagesUI.u(SnsAdNativeLandingPagesUI.this);
                    SnsAdNativeLandingPagesUI.U(SnsAdNativeLandingPagesUI.this);
                    if (!SnsAdNativeLandingPagesUI.this.Eyt && SnsAdNativeLandingPagesUI.this.isSupportNavigationSwipeBack()) {
                        SnsAdNativeLandingPagesUI.this.getSwipeBackLayout().setEnableGesture(true);
                    }
                    AppMethodBeat.o(203426);
                }
            });
            snsAdNativeLandingPagesUI.Eya.fkj();
        }
        AppMethodBeat.o(203460);
    }

    static /* synthetic */ void J(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.i(203467);
        Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "doTransimt snsAdNativeLadingPagesUI");
        snsAdNativeLandingPagesUI.ExI.tar++;
        String fhp = snsAdNativeLandingPagesUI.fhp();
        String fhq = snsAdNativeLandingPagesUI.fhq();
        a fho = snsAdNativeLandingPagesUI.fho();
        String kb = r.kb(snsAdNativeLandingPagesUI.rCq, snsAdNativeLandingPagesUI.uxInfo);
        Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "doTransimt, shareUrl=".concat(String.valueOf(kb)));
        if (fho != null) {
            AdLandingPagesProxy.getInstance().doTransimt(snsAdNativeLandingPagesUI, fhq, fho.msN, snsAdNativeLandingPagesUI.aQZ(fho.DXa), fho.xDQ, kb, fhp, Util.nullAsNil(snsAdNativeLandingPagesUI.uxInfo), Util.nullAsNil(snsAdNativeLandingPagesUI.ExI.lAN));
            AppMethodBeat.o(203467);
            return;
        }
        AdLandingPagesProxy.getInstance().doTransimt(snsAdNativeLandingPagesUI, fhq, snsAdNativeLandingPagesUI.msN, snsAdNativeLandingPagesUI.aQZ(snsAdNativeLandingPagesUI.ExF), snsAdNativeLandingPagesUI.xDQ, kb, fhp, Util.nullAsNil(snsAdNativeLandingPagesUI.uxInfo), Util.nullAsNil(snsAdNativeLandingPagesUI.ExI.lAN));
        AppMethodBeat.o(203467);
    }

    static /* synthetic */ void K(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.i(203468);
        Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "doShareToTimeline snsAdNativeLadingPagesUI");
        snsAdNativeLandingPagesUI.ExI.tas++;
        String str = snsAdNativeLandingPagesUI.rCq;
        a fho = snsAdNativeLandingPagesUI.fho();
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.SnsAdNativeLandingPagesUI", "doTimeline fail, link is null");
            AppMethodBeat.o(203468);
            return;
        }
        String kb = r.kb(snsAdNativeLandingPagesUI.rCq, snsAdNativeLandingPagesUI.uxInfo);
        Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "doShareToTimeline, shareUrl=".concat(String.valueOf(kb)));
        int i2 = snsAdNativeLandingPagesUI.qaH;
        Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "doTimeline, init intent");
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_width", i2);
        intent.putExtra("Ksnsupload_height", i2);
        intent.putExtra("Ksnsupload_link", kb);
        if (fho != null) {
            intent.putExtra("Ksnsupload_title", fho.msN);
            intent.putExtra("Ksnsupload_imgurl", snsAdNativeLandingPagesUI.aQZ(fho.DXa));
        } else {
            intent.putExtra("Ksnsupload_title", snsAdNativeLandingPagesUI.msN);
            intent.putExtra("Ksnsupload_imgurl", snsAdNativeLandingPagesUI.aQZ(snsAdNativeLandingPagesUI.ExF));
        }
        intent.putExtra("Ksnsupload_canvas_info", snsAdNativeLandingPagesUI.fhq());
        intent.putExtra("Ksnsupload_contentattribute", 0);
        intent.putExtra("Ksnsupload_source", 1);
        intent.putExtra("Ksnsupload_type", 1);
        String fhp = snsAdNativeLandingPagesUI.fhp();
        if (!Util.isNullOrNil(fhp)) {
            intent.putExtra("key_snsad_statextstr", fhp);
        }
        Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "doTimeline, start activity");
        intent.putExtra("need_result", true);
        String str2 = "sns_";
        if (snsAdNativeLandingPagesUI.source == 1 || snsAdNativeLandingPagesUI.source == 2 || snsAdNativeLandingPagesUI.source == 3 || snsAdNativeLandingPagesUI.source == 4 || snsAdNativeLandingPagesUI.source == 9 || snsAdNativeLandingPagesUI.source == 10 || snsAdNativeLandingPagesUI.source == 11) {
            str2 = "sns_" + snsAdNativeLandingPagesUI.dRS;
        } else if (snsAdNativeLandingPagesUI.source == 5 || snsAdNativeLandingPagesUI.source == 6) {
            str2 = "msg_".concat(String.valueOf(snsAdNativeLandingPagesUI.getIntent().getExtras().getLong("msg_id", -2147483648L)));
        } else if (snsAdNativeLandingPagesUI.source == 7) {
            str2 = "fav_".concat(String.valueOf(snsAdNativeLandingPagesUI.getIntent().getExtras().getString("sns_landing_favid")));
        }
        String JX = com.tencent.mm.model.ad.JX(str2);
        com.tencent.mm.model.ad.aVe().G(JX, true).l("prePublishId", str2);
        intent.putExtra("reportSessionId", JX);
        com.tencent.mm.br.c.a((Context) snsAdNativeLandingPagesUI.getContext(), "sns", ".ui.SnsUploadUI", intent, 2001, false);
        AppMethodBeat.o(203468);
    }

    static /* synthetic */ void L(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.i(179189);
        snsAdNativeLandingPagesUI.ExI.favCount++;
        Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "doFav snsAdNativeLadingPagesUI");
        long j2 = snsAdNativeLandingPagesUI.getIntent().getExtras().getLong("msg_id", -2147483648L);
        String str = null;
        if (!Util.isNullOrNil(snsAdNativeLandingPagesUI.dRS)) {
            SnsInfo snsInfo = AdLandingPagesProxy.getInstance().getSnsInfo(snsAdNativeLandingPagesUI.dRS);
            if (snsInfo != null) {
                str = snsInfo.getLocalid();
            }
            AppMethodBeat.o(179189);
        }
        String nullAsNil = Util.nullAsNil(snsAdNativeLandingPagesUI.getIntent().getStringExtra("prePublishId"));
        a fho = snsAdNativeLandingPagesUI.fho();
        String fhp = snsAdNativeLandingPagesUI.fhp();
        String fhq = snsAdNativeLandingPagesUI.fhq();
        if (fho != null) {
            AdLandingPagesProxy.getInstance().doFavAdlanding(j2, str, snsAdNativeLandingPagesUI.source, snsAdNativeLandingPagesUI.rCq, nullAsNil, fho.msN, fho.xDQ, fhq, 34, snsAdNativeLandingPagesUI.aQZ(fho.DXa), fhp);
        } else {
            AdLandingPagesProxy.getInstance().doFavAdlanding(j2, str, snsAdNativeLandingPagesUI.source, snsAdNativeLandingPagesUI.rCq, nullAsNil, snsAdNativeLandingPagesUI.msN, snsAdNativeLandingPagesUI.xDQ, fhq, 34, snsAdNativeLandingPagesUI.aQZ(snsAdNativeLandingPagesUI.ExF), fhp);
        }
        ((v) com.tencent.mm.kernel.g.af(v.class)).a(0, 34, snsAdNativeLandingPagesUI, snsAdNativeLandingPagesUI.xxK);
        AppMethodBeat.o(179189);
    }

    static /* synthetic */ void M(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e eVar;
        AppMethodBeat.i(179190);
        if (!(snsAdNativeLandingPagesUI.Eyr == null || (eVar = snsAdNativeLandingPagesUI.Eyr.EWp) == null || TextUtils.isEmpty(eVar.DXV))) {
            String str = eVar.DXV;
            String str2 = snsAdNativeLandingPagesUI.fds().DZW;
            if (TextUtils.isEmpty(str2)) {
                str2 = snsAdNativeLandingPagesUI.fds().uxInfo;
            }
            if (!TextUtils.isEmpty(str2)) {
                str = r.kb(str, str2);
            }
            ((aa) com.tencent.mm.kernel.g.af(aa.class)).c(snsAdNativeLandingPagesUI, str);
            Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "doOpenInBrowser, url=".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(179190);
    }

    static /* synthetic */ void R(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.i(203470);
        try {
            Log.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "uxInfo = " + snsAdNativeLandingPagesUI.uxInfo + ", canvasId = " + snsAdNativeLandingPagesUI.ExI.lAN);
            String aH = com.tencent.mm.plugin.sns.a.b.aH("5", snsAdNativeLandingPagesUI.uxInfo, snsAdNativeLandingPagesUI.ExI.lAN);
            Log.i("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", "reportScreenShotParams = ".concat(String.valueOf(aH)));
            h.INSTANCE.kvStat(19213, aH);
            AppMethodBeat.o(203470);
        } catch (Throwable th) {
            Log.e("MicroMsg.SnsAdNativeLandingPagesUI.ScreenShot", th.toString());
            AppMethodBeat.o(203470);
        }
    }

    static /* synthetic */ void U(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        AppMethodBeat.i(203471);
        if (snsAdNativeLandingPagesUI.Elq != null) {
            Iterator<g> it = snsAdNativeLandingPagesUI.Elq.iterator();
            while (it.hasNext()) {
                ContentFragment contentFragment = snsAdNativeLandingPagesUI.EyM.get(Integer.valueOf(it.next().id));
                if (contentFragment != null) {
                    contentFragment.Eiq = true;
                    contentFragment.JC(0);
                }
            }
            snsAdNativeLandingPagesUI.s(snsAdNativeLandingPagesUI.EyM.get(Integer.valueOf(snsAdNativeLandingPagesUI.Elq.getFirst().id)));
        }
        AppMethodBeat.o(203471);
    }

    static /* synthetic */ void Z(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        int i2;
        AppMethodBeat.i(203472);
        if (snsAdNativeLandingPagesUI.Eyc == null) {
            snsAdNativeLandingPagesUI.Eyc = new d(snsAdNativeLandingPagesUI, snsAdNativeLandingPagesUI.Exv, snsAdNativeLandingPagesUI.Exy);
            AdLandingPagesProxy.getInstance().playTimelineBackAnimation(0);
            Bundle bundle = new Bundle();
            bundle.putInt("param_thumb_left", snsAdNativeLandingPagesUI.qaG);
            bundle.putInt("param_thumb_top", snsAdNativeLandingPagesUI.qaF);
            bundle.putInt("param_thumb_width", snsAdNativeLandingPagesUI.qaH);
            bundle.putInt("param_thumb_height", snsAdNativeLandingPagesUI.qaI);
            Drawable drawable = snsAdNativeLandingPagesUI.Exv.getDrawable();
            bundle.putInt("param_target_width", drawable != null ? drawable.getIntrinsicWidth() : 0);
            if (drawable != null) {
                i2 = drawable.getIntrinsicHeight();
            } else {
                i2 = 0;
            }
            bundle.putInt("param_target_height", i2);
            snsAdNativeLandingPagesUI.Eyc.aG(bundle);
        }
        snsAdNativeLandingPagesUI.k(false, 0);
        Bitmap bitmap = null;
        aj fhm = snsAdNativeLandingPagesUI.fhm();
        if (fhm != null) {
            fhm.fdJ();
            bitmap = fhm.fdI();
        }
        if (bitmap == null && !snsAdNativeLandingPagesUI.Exy) {
            bitmap = BitmapUtil.getBitmapFromView(snsAdNativeLandingPagesUI.ExX);
        }
        if (bitmap != null) {
            snsAdNativeLandingPagesUI.Exv.setImageBitmap(bitmap);
        }
        snsAdNativeLandingPagesUI.Eyc.a(new com.tencent.mm.plugin.sns.ui.b.b() {
            /* class com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.AnonymousClass18 */

            @Override // com.tencent.mm.plugin.sns.ui.b.b
            public final void onAnimationStart() {
                AppMethodBeat.i(203428);
                Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "sns exit anim start");
                if (SnsAdNativeLandingPagesUI.this.Exy) {
                    SnsAdNativeLandingPagesUI.this.jUG.setAlpha(0.0f);
                    AppMethodBeat.o(203428);
                    return;
                }
                SnsAdNativeLandingPagesUI.this.ExX.setVisibility(4);
                AppMethodBeat.o(203428);
            }

            @Override // com.tencent.mm.plugin.sns.ui.b.b
            public final void bX(float f2) {
                float f3 = 0.0f;
                AppMethodBeat.i(203429);
                if (SnsAdNativeLandingPagesUI.this.Exy) {
                    float f4 = 1.0f - (4.0f * f2);
                    if (f4 >= 0.0f) {
                        f3 = f4;
                    }
                    SnsAdNativeLandingPagesUI.this.ExX.setAlpha(f3);
                    AppMethodBeat.o(203429);
                    return;
                }
                SnsAdNativeLandingPagesUI.this.jUG.setAlpha(1.0f - f2);
                AppMethodBeat.o(203429);
            }

            @Override // com.tencent.mm.plugin.sns.ui.b.b
            public final void onAnimationEnd() {
                AppMethodBeat.i(203430);
                SnsAdNativeLandingPagesUI.this.Eyd = false;
                Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "sns exit anim end");
                SnsAdNativeLandingPagesUI.this.finish();
                SnsAdNativeLandingPagesUI.this.overridePendingTransition(R.anim.s, R.anim.s);
                if (!SnsAdNativeLandingPagesUI.this.Eyt && SnsAdNativeLandingPagesUI.this.isSupportNavigationSwipeBack()) {
                    SnsAdNativeLandingPagesUI.this.getSwipeBackLayout().setEnableGesture(true);
                }
                AppMethodBeat.o(203430);
            }
        });
        snsAdNativeLandingPagesUI.Eyc.fkj();
        AppMethodBeat.o(203472);
    }
}
