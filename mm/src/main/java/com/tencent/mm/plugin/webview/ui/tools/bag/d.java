package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.p;
import com.tencent.mm.plugin.webview.ui.tools.bag.WebViewBag;
import com.tencent.mm.plugin.webview.ui.tools.bag.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public enum d {
    INSTANCE;
    
    long Dqp = -1;
    WebViewBag JkW;
    private a JkX;
    public boolean JkY;
    public a JkZ = new a();
    private LinkedList<Object> Jla = new LinkedList<>();

    private d(String str) {
        AppMethodBeat.i(80449);
        AppMethodBeat.o(80449);
    }

    static /* synthetic */ void a(d dVar) {
        AppMethodBeat.i(80459);
        dVar.ggp();
        AppMethodBeat.o(80459);
    }

    static /* synthetic */ void a(d dVar, int i2) {
        AppMethodBeat.i(80460);
        dVar.agQ(i2);
        AppMethodBeat.o(80460);
    }

    static /* synthetic */ void a(d dVar, String str, int i2, String str2, Bundle bundle, boolean z) {
        AppMethodBeat.i(80458);
        dVar.a(str, i2, str2, bundle, z);
        AppMethodBeat.o(80458);
    }

    public static d valueOf(String str) {
        AppMethodBeat.i(80448);
        d dVar = (d) Enum.valueOf(d.class, str);
        AppMethodBeat.o(80448);
        return dVar;
    }

    static {
        AppMethodBeat.i(80462);
        AppMethodBeat.o(80462);
    }

    public final void ggo() {
        AppMethodBeat.i(80450);
        Log.i("MicroMsg.WebViewBagMgr", "clearBag mCurrentUrl:%s", this.JkZ.url);
        ggq();
        a aVar = this.JkZ;
        aVar.id = null;
        aVar.url = null;
        aVar.icon = null;
        aVar.iTK = 0;
        aVar.scene = 0;
        aVar.Jlh = new JSONObject();
        aVar.save();
        Log.i("MicroMsg.WebViewBagMgr", "unAttachBag");
        if (this.JkW != null) {
            try {
                ((WindowManager) MMApplicationContext.getContext().getSystemService("window")).removeView(this.JkW);
            } catch (Exception e2) {
                Log.e("MicroMsg.WebViewBagMgr", "remove failed %s", e2);
            }
            this.JkW = null;
        } else {
            Log.e("MicroMsg.WebViewBagMgr", "unAttachBag mBag null");
        }
        if (this.JkX != null) {
            a aVar2 = this.JkX;
            try {
                ((WindowManager) MMApplicationContext.getContext().getSystemService("window")).removeView(aVar2.Jkq);
            } catch (Exception e3) {
                Log.e("MicroMsg.BagCancelController", "whenBagUnAttach remove failed %s", e3);
            }
            this.JkX = null;
        }
        Iterator<Object> it = this.Jla.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(80450);
    }

    /* access modifiers changed from: package-private */
    public final void ggp() {
        AppMethodBeat.i(80451);
        Log.i("MicroMsg.WebViewBagMgr", "showBag url:%s", this.JkZ.url);
        if (!b.cx(MMApplicationContext.getContext())) {
            Log.w("MicroMsg.WebViewBagMgr", "showBag: no float window permission");
            AppMethodBeat.o(80451);
        } else if (Util.isNullOrNil(this.JkZ.url)) {
            ggo();
            AppMethodBeat.o(80451);
        } else {
            boolean z = this.JkW == null;
            if (this.JkW == null) {
                this.JkX = new a(new a.b() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.bag.d.AnonymousClass2 */

                    @Override // com.tencent.mm.plugin.webview.ui.tools.bag.a.b
                    public final void ggn() {
                        AppMethodBeat.i(80441);
                        d.a(d.this, 17);
                        Point point = null;
                        if (d.this.JkW != null) {
                            point = d.this.JkW.getLastTouchDownViewPos();
                        }
                        d.this.ggo();
                        if (point != null) {
                            d.this.JkZ.Jlg = point.x;
                            d.this.JkZ.Jlf = point.y;
                            d.this.JkZ.save();
                        }
                        AppMethodBeat.o(80441);
                    }
                });
                this.JkW = new WebViewBag(MMApplicationContext.getContext(), null);
                this.JkW.setListener(new WebViewBag.a() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.bag.d.AnonymousClass3 */

                    @Override // com.tencent.mm.plugin.webview.ui.tools.bag.WebViewBag.a
                    public final void kp(int i2, int i3) {
                        AppMethodBeat.i(80442);
                        d.a(d.this, 19);
                        d.this.JkZ.Jlg = i2;
                        d.this.JkZ.Jlf = i3;
                        d.this.JkZ.save();
                        AppMethodBeat.o(80442);
                    }

                    @Override // com.tencent.mm.plugin.webview.ui.tools.bag.WebViewBag.a
                    public final void onTouchEvent(MotionEvent motionEvent) {
                        boolean z;
                        boolean z2;
                        float rawX;
                        float rawY;
                        AppMethodBeat.i(80443);
                        if (d.this.JkX != null) {
                            a aVar = d.this.JkX;
                            float rawX2 = motionEvent.getRawX();
                            float rawY2 = motionEvent.getRawY();
                            switch (motionEvent.getAction()) {
                                case 0:
                                    aVar.Jkt.x = rawX2;
                                    aVar.Jkt.y = rawY2;
                                    aVar.Jks = false;
                                    aVar.Jku = false;
                                    break;
                                case 1:
                                    if (aVar.Jku) {
                                        aVar.Jkr.ggn();
                                    } else if (aVar.mIsShowing) {
                                        aVar.mIsShowing = false;
                                        a.C1976a aVar2 = aVar.Jkq;
                                        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, (float) b.JkD, 0.0f, (float) b.JkD);
                                        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                                        AnimationSet animationSet = new AnimationSet(true);
                                        animationSet.addAnimation(alphaAnimation);
                                        animationSet.addAnimation(translateAnimation);
                                        animationSet.setDuration(300);
                                        animationSet.setAnimationListener(
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x016a: INVOKE  
                                              (r6v2 'animationSet' android.view.animation.AnimationSet)
                                              (wrap: com.tencent.mm.plugin.webview.ui.tools.bag.a$a$1 : 0x0167: CONSTRUCTOR  (r1v1 com.tencent.mm.plugin.webview.ui.tools.bag.a$a$1) = (r0v6 'aVar2' com.tencent.mm.plugin.webview.ui.tools.bag.a$a) call: com.tencent.mm.plugin.webview.ui.tools.bag.a.a.1.<init>(com.tencent.mm.plugin.webview.ui.tools.bag.a$a):void type: CONSTRUCTOR)
                                             type: VIRTUAL call: android.view.animation.AnimationSet.setAnimationListener(android.view.animation.Animation$AnimationListener):void in method: com.tencent.mm.plugin.webview.ui.tools.bag.d.3.onTouchEvent(android.view.MotionEvent):void, file: classes6.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                            	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:274)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
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
                                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0167: CONSTRUCTOR  (r1v1 com.tencent.mm.plugin.webview.ui.tools.bag.a$a$1) = (r0v6 'aVar2' com.tencent.mm.plugin.webview.ui.tools.bag.a$a) call: com.tencent.mm.plugin.webview.ui.tools.bag.a.a.1.<init>(com.tencent.mm.plugin.webview.ui.tools.bag.a$a):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.ui.tools.bag.d.3.onTouchEvent(android.view.MotionEvent):void, file: classes6.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                            	... 31 more
                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.ui.tools.bag.a, state: GENERATED_AND_UNLOADED
                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                            	... 37 more
                                            */
                                        /*
                                        // Method dump skipped, instructions count: 388
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.bag.d.AnonymousClass3.onTouchEvent(android.view.MotionEvent):void");
                                    }
                                });
                                this.JkW.setOnClickListener(new View.OnClickListener() {
                                    /* class com.tencent.mm.plugin.webview.ui.tools.bag.d.AnonymousClass4 */

                                    public final void onClick(View view) {
                                        AppMethodBeat.i(80444);
                                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                        bVar.bm(view);
                                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/bag/WebViewBagMgr$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                        d.a(d.this, d.this.JkZ.url, d.this.JkZ.scene);
                                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/bag/WebViewBagMgr$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                        AppMethodBeat.o(80444);
                                    }
                                });
                            }
                            ci(1.0f);
                            this.JkW.setTouchEnable(true);
                            this.JkW.setIcon(this.JkZ.icon);
                            ggr();
                            Log.i("MicroMsg.WebViewBagMgr", "bag showed needAttach:%b mCurrentBagId:%s", Boolean.valueOf(z), this.JkZ.id);
                            if (z) {
                                Log.i("MicroMsg.WebViewBagMgr", "attachBag");
                                WindowManager windowManager = (WindowManager) MMApplicationContext.getContext().getSystemService("window");
                                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                                if (com.tencent.mm.compatible.util.d.oD(26)) {
                                    layoutParams.type = 2038;
                                } else {
                                    layoutParams.type = 2002;
                                }
                                layoutParams.format = 1;
                                layoutParams.packageName = MMApplicationContext.getContext().getPackageName();
                                layoutParams.flags = 40;
                                layoutParams.gravity = 51;
                                layoutParams.width = b.Jkx;
                                layoutParams.height = b.Jkx;
                                layoutParams.x = this.JkZ.Jlg;
                                layoutParams.y = this.JkZ.Jlf;
                                try {
                                    windowManager.addView(this.JkW, layoutParams);
                                    ggr();
                                    AppMethodBeat.o(80451);
                                } catch (Exception e2) {
                                    Log.e("MicroMsg.WebViewBagMgr", "add failed %s", e2);
                                    AppMethodBeat.o(80451);
                                }
                            } else if (this.JkW.getVisibility() != 0) {
                                this.JkW.setVisibility(0);
                                AppMethodBeat.o(80451);
                            } else {
                                Log.i("MicroMsg.WebViewBagMgr", "already showed");
                                AppMethodBeat.o(80451);
                            }
                        }
                    }

                    public final void ggq() {
                        AppMethodBeat.i(80452);
                        if (this.JkW == null) {
                            AppMethodBeat.o(80452);
                            return;
                        }
                        this.JkW.setVisibility(8);
                        AppMethodBeat.o(80452);
                    }

                    public final void ci(float f2) {
                        AppMethodBeat.i(80453);
                        if (this.JkW == null) {
                            AppMethodBeat.o(80453);
                            return;
                        }
                        this.JkW.setAlpha(f2);
                        if (f2 == 0.0f) {
                            this.JkW.setVisibility(8);
                            AppMethodBeat.o(80453);
                            return;
                        }
                        this.JkW.setVisibility(0);
                        AppMethodBeat.o(80453);
                    }

                    /* access modifiers changed from: package-private */
                    public final void a(String str, int i2, String str2, Bundle bundle, boolean z) {
                        AppMethodBeat.i(80454);
                        if (!z || Util.isNullOrNil(this.JkZ.id)) {
                            agQ(23);
                            this.JkZ.id = MD5Util.getMD5String(String.format("bagId#%d#%s", Long.valueOf(System.currentTimeMillis()), this.JkZ.url));
                        }
                        this.JkZ.url = str;
                        this.JkZ.icon = str2;
                        this.JkZ.scene = i2;
                        this.JkZ.iTK = Util.nowMilliSecond();
                        this.JkZ.Jlh = c.be(bundle);
                        this.JkZ.save();
                        AppMethodBeat.o(80454);
                    }

                    private void ggr() {
                        AppMethodBeat.i(80455);
                        Log.i("MicroMsg.WebViewBagMgr", "setAngryInfo mBagInfo.lastActiveTime:%d", Long.valueOf(this.JkZ.iTK));
                        if (this.JkW == null) {
                            AppMethodBeat.o(80455);
                        } else if (ggs()) {
                            this.JkW.p(60000, 100, this.JkZ.iTK + 2000);
                            AppMethodBeat.o(80455);
                        } else {
                            this.JkW.p(3600000, CommonUtils.MAX_TIMEOUT_MS, this.JkZ.iTK + Util.MILLSECONDS_OF_HOUR);
                            AppMethodBeat.o(80455);
                        }
                    }

                    private void agQ(int i2) {
                        AppMethodBeat.i(80456);
                        Log.v("MicroMsg.WebViewBagMgr", "kvReport op:%d", Integer.valueOf(i2));
                        h.INSTANCE.a(11576, this.JkZ.url, Integer.valueOf(i2), 0, Long.valueOf(System.currentTimeMillis() - this.JkZ.iTK), this.JkZ.id);
                        AppMethodBeat.o(80456);
                    }

                    private static boolean ggs() {
                        AppMethodBeat.i(80457);
                        boolean equals = "1".equals((String) g.aAh().azQ().get(ar.a.USERINFO_WEBVIEW_BAG_TEST_INFO_STRING_SYNC, AppEventsConstants.EVENT_PARAM_VALUE_NO));
                        AppMethodBeat.o(80457);
                        return equals;
                    }

                    public static final class a {
                        public int Jlf;
                        public int Jlg;
                        JSONObject Jlh;
                        long iTK;
                        String icon;
                        public String id;
                        int scene;
                        public String url;

                        public a() {
                            AppMethodBeat.i(80445);
                            g.aAi();
                            String str = (String) g.aAh().azQ().get(ar.a.USERINFO_WEBVIEW_BAG_INFO_STRING_SYNC, (Object) null);
                            Log.i("MicroMsg.WebViewBagMgr", "BagInfo#load %s", str);
                            if (Util.isNullOrNil(str)) {
                                this.id = null;
                                this.url = null;
                                this.icon = null;
                                this.Jlg = (com.tencent.mm.cb.a.jn(MMApplicationContext.getContext()) - b.Jkx) - b.Jky;
                                this.Jlf = b.Jkw + MMApplicationContext.getContext().getResources().getDimensionPixelSize(R.dimen.ap7);
                                this.Jlh = new JSONObject();
                                Log.i("MicroMsg.WebViewBagMgr", "BAG_INIT_X:%d BAG_INIT_Y:%d", Integer.valueOf(this.Jlg), Integer.valueOf(this.Jlf));
                                AppMethodBeat.o(80445);
                                return;
                            }
                            try {
                                JSONObject jSONObject = new JSONObject(str);
                                this.url = jSONObject.getString("url");
                                this.id = jSONObject.optString("id", MD5Util.getMD5String(String.format("bagId#%d#%s", Long.valueOf(System.currentTimeMillis()), this.url)));
                                this.icon = jSONObject.getString("icon");
                                this.Jlf = jSONObject.getInt("pos_y");
                                this.Jlg = jSONObject.getInt("pos_x");
                                this.iTK = jSONObject.getLong("last_active_time");
                                this.Jlh = jSONObject.getJSONObject("extras");
                                this.scene = jSONObject.optInt("scene", 0);
                                AppMethodBeat.o(80445);
                            } catch (JSONException e2) {
                                Log.e("MicroMsg.WebViewBagMgr", "BagInfo#load exp:%s", e2);
                                AppMethodBeat.o(80445);
                            }
                        }

                        /* access modifiers changed from: package-private */
                        public final void save() {
                            AppMethodBeat.i(80446);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("id", Util.nullAsNil(this.id));
                                jSONObject.put("url", Util.nullAsNil(this.url));
                                jSONObject.put("icon", Util.nullAsNil(this.icon));
                                jSONObject.put("pos_y", this.Jlf);
                                jSONObject.put("pos_x", this.Jlg);
                                jSONObject.put("last_active_time", this.iTK);
                                jSONObject.put("extras", this.Jlh);
                                jSONObject.put("scene", this.scene);
                                String jSONObject2 = jSONObject.toString();
                                g.aAi();
                                g.aAh().azQ().set(ar.a.USERINFO_WEBVIEW_BAG_INFO_STRING_SYNC, jSONObject2);
                                AppMethodBeat.o(80446);
                            } catch (JSONException e2) {
                                Log.e("MicroMsg.WebViewBagMgr", "BagInfo#save exp:%s", e2);
                                AppMethodBeat.o(80446);
                            }
                        }
                    }

                    static /* synthetic */ void a(d dVar, String str, int i2) {
                        AppMethodBeat.i(80461);
                        Log.i("MicroMsg.WebViewBagMgr", "bag handleClick: url:%s scene:%d", str, Integer.valueOf(i2));
                        long currentTimeMillis = System.currentTimeMillis();
                        if (dVar.Dqp <= 0 || currentTimeMillis - dVar.Dqp >= 500) {
                            dVar.Dqp = currentTimeMillis;
                            dVar.agQ(13);
                            if (!Util.isNullOrNil(str)) {
                                Intent intent = new Intent();
                                c.a(intent, dVar.JkZ.Jlh);
                                intent.putExtra("rawUrl", str);
                                intent.putExtra("from_bag", true);
                                intent.putExtra("from_bag_id", dVar.JkZ.id);
                                intent.putExtra("from_bag_icon", dVar.JkZ.icon);
                                String str2 = ".ui.tools.WebViewUI";
                                if (i2 == 1) {
                                    Log.i("MicroMsg.WebViewBagMgr", "handleClick go jd url");
                                    intent.putExtra("useJs", true);
                                    intent.putExtra("vertical_scroll", true);
                                    intent.putExtra("minimize_secene", 1);
                                    intent.putExtra("KPublisherId", "jd_store");
                                    com.tencent.mm.pluginsdk.wallet.h.setPayChannel(9);
                                } else if (i2 == 2) {
                                    Log.i("MicroMsg.WebViewBagMgr", "handleClick go game url");
                                    str2 = ".ui.tools.WebViewUI";
                                }
                                if (i2 == 3) {
                                    Log.i("MicroMsg.WebViewBagMgr", "handleClick luggage");
                                    p.ar(MMApplicationContext.getContext(), intent);
                                } else {
                                    c.b(MMApplicationContext.getContext(), "webview", str2, intent);
                                }
                                if (dVar.JkW != null) {
                                    dVar.JkW.setTouchEnable(false);
                                }
                                dVar.ci(0.0f);
                                dVar.JkZ.iTK = System.currentTimeMillis();
                                dVar.JkZ.save();
                                dVar.ggr();
                            }
                            AppMethodBeat.o(80461);
                            return;
                        }
                        Log.i("MicroMsg.WebViewBagMgr", "handleClick twice click too short");
                        dVar.Dqp = currentTimeMillis;
                        AppMethodBeat.o(80461);
                    }
                }
