package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.sns.ad.i.b;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageChattingTask;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.pluginsdk.ui.span.e;
import com.tencent.mm.protocal.protobuf.bvr;
import com.tencent.mm.protocal.protobuf.bvs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.a.e;
import org.json.JSONObject;

public class q extends p {
    protected RoundedCornerFrameLayout Edo;
    public Button Edp;
    View Edq;
    public boolean Edr;
    public boolean Eds;

    public q(Context context, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q qVar, ViewGroup viewGroup) {
        super(context, qVar, viewGroup);
    }

    /* access modifiers changed from: protected */
    public final com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q fdx() {
        return (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final int getLayout() {
        return R.layout.bub;
    }

    /* access modifiers changed from: protected */
    public void fde() {
        AppMethodBeat.i(96497);
        try {
            hWL();
        } catch (Exception e2) {
            Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", "doBtnClick exp=" + e2.toString());
        }
        fdf();
        AppMethodBeat.o(96497);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    @TargetApi(17)
    public void eXe() {
        AppMethodBeat.i(96498);
        View view = this.contentView;
        this.Edo = (RoundedCornerFrameLayout) view.findViewById(R.id.hvp);
        this.Edp = (Button) view.findViewById(R.id.hvo);
        this.Edq = view.findViewById(R.id.hvr);
        AppMethodBeat.o(96498);
    }

    /* access modifiers changed from: package-private */
    public final void a(final n nVar, String str) {
        AppMethodBeat.i(96499);
        try {
            final AdLandingPageChattingTask adLandingPageChattingTask = new AdLandingPageChattingTask();
            String str2 = nVar.weappUserName;
            if (str2 == null) {
                str2 = "";
            }
            final WxaExposedParams.a aVar = new WxaExposedParams.a();
            aVar.appId = nVar.DYj;
            aVar.username = str2;
            aVar.nickname = "";
            aVar.iconUrl = "";
            aVar.kNW = 0;
            aVar.pkgVersion = 0;
            aVar.lhn = "";
            aVar.from = 14;
            aVar.pageId = "";
            aVar.lho = "";
            if (TextUtils.isEmpty(str)) {
                str = str2;
            }
            adLandingPageChattingTask.username = str;
            adLandingPageChattingTask.nickname = "";
            adLandingPageChattingTask.lRW = nVar.lRW;
            adLandingPageChattingTask.lyv = new Runnable() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q.AnonymousClass7 */

                public final void run() {
                    String str;
                    AppMethodBeat.i(96495);
                    Intent intent = new Intent();
                    intent.setFlags(67108864);
                    intent.putExtra("Chat_User", adLandingPageChattingTask.username);
                    intent.putExtra("app_brand_chatting_from_scene", 3);
                    intent.putExtra("app_brand_chatting_expose_params", aVar.bAv());
                    intent.putExtra("key_temp_session_from", adLandingPageChattingTask.lRW);
                    intent.putExtra("finish_direct", true);
                    intent.putExtra("key_need_send_video", false);
                    try {
                        boolean z = nVar.DYk == 1;
                        String str2 = nVar.lSf;
                        String str3 = nVar.lSg;
                        String str4 = nVar.lSh;
                        if (z) {
                            if (!Util.isNullOrNil(str2, str4, str3)) {
                                intent.putExtra("showMessageCard", true);
                                intent.putExtra("sendMessageTitle", str2);
                                intent.putExtra("sendMessagePath", str3);
                                intent.putExtra("sendMessageImg", str4);
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("uxInfo", q.this.fds().uxInfo);
                                str = jSONObject.toString();
                                intent.putExtra("sns_landing_pages_ux_info", str);
                                MMActivity mMActivity = (MMActivity) q.this.context;
                                mMActivity.mmSetOnActivityResultCallback(new MMActivity.a() {
                                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q.AnonymousClass7.AnonymousClass1 */

                                    @Override // com.tencent.mm.ui.MMActivity.a
                                    public final void d(int i2, int i3, Intent intent) {
                                        AppMethodBeat.i(96494);
                                        if (i2 == 1) {
                                            adLandingPageChattingTask.bDK();
                                        }
                                        AppMethodBeat.o(96494);
                                    }
                                });
                                Log.i("MicroMsg.Sns.AdLandingPageBtnComponent", "open ServiceChattingUI， uxInfo=".concat(String.valueOf(str)));
                                c.c(mMActivity, ".ui.chatting.AppBrandServiceChattingUI", intent, 1);
                                AppMethodBeat.o(96495);
                            }
                        }
                        intent.putExtra("showMessageCard", false);
                    } catch (Throwable th) {
                        intent.putExtra("showMessageCard", false);
                        Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", th.toString());
                    }
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("uxInfo", q.this.fds().uxInfo);
                        str = jSONObject2.toString();
                    } catch (Exception e2) {
                        str = "";
                    }
                    intent.putExtra("sns_landing_pages_ux_info", str);
                    MMActivity mMActivity2 = (MMActivity) q.this.context;
                    mMActivity2.mmSetOnActivityResultCallback(new MMActivity.a() {
                        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q.AnonymousClass7.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.MMActivity.a
                        public final void d(int i2, int i3, Intent intent) {
                            AppMethodBeat.i(96494);
                            if (i2 == 1) {
                                adLandingPageChattingTask.bDK();
                            }
                            AppMethodBeat.o(96494);
                        }
                    });
                    Log.i("MicroMsg.Sns.AdLandingPageBtnComponent", "open ServiceChattingUI， uxInfo=".concat(String.valueOf(str)));
                    c.c(mMActivity2, ".ui.chatting.AppBrandServiceChattingUI", intent, 1);
                    AppMethodBeat.o(96495);
                }
            };
            adLandingPageChattingTask.bDJ();
            AppBrandMainProcessService.a(adLandingPageChattingTask);
            AppMethodBeat.o(96499);
        } catch (Exception e2) {
            Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", "doEnterChatting exp:" + e2.toString());
            AppMethodBeat.o(96499);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    @TargetApi(17)
    public void eWT() {
        boolean z;
        boolean z2;
        int i2;
        int i3;
        AppMethodBeat.i(96496);
        this.clickCount = 0;
        int i4 = this.mEX;
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).DZk > 0.0f && ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).DZk <= ((float) i4)) {
            i4 = ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).paddingRight) + ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).DZk) + ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).paddingLeft);
        }
        this.Edo.setBackgroundColor(this.backgroundColor);
        if (!Util.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).DYy)) {
            h.a("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).DYy, false, 0, new f.a() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void eWN() {
                }

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void eWO() {
                }

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                @TargetApi(16)
                public final void aNH(String str) {
                    AppMethodBeat.i(96486);
                    try {
                        Log.i("MicroMsg.Sns.AdLandingPageBtnComponent", "onDownloaded, path=".concat(String.valueOf(str)));
                        Drawable a2 = b.a(q.this.Edp.getResources(), str);
                        q.this.Edp.setBackground(a2);
                        if (a2 != null && q.this.fdx().height > 0.0f && a2.getIntrinsicHeight() > 0) {
                            q.this.Edp.setLayoutParams(new FrameLayout.LayoutParams((int) ((q.this.fdx().height * ((float) a2.getIntrinsicWidth())) / ((float) a2.getIntrinsicHeight())), (int) q.this.fdx().height));
                        }
                        AppMethodBeat.o(96486);
                    } catch (Throwable th) {
                        Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", "the backgroundCoverUrl is set error ,because " + th.toString());
                        AppMethodBeat.o(96486);
                    }
                }
            });
            z2 = false;
        } else {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (Util.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).DYx) || ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).DYu <= 0.0f) {
                z = false;
                z2 = false;
            } else {
                try {
                    i3 = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).DYx);
                } catch (Exception e2) {
                    Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", Util.stackTraceToString(e2));
                    i3 = 0;
                }
                gradientDrawable.setStroke((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).DYu, i3);
                if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).tt > 0.0f) {
                    gradientDrawable.setCornerRadius(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).tt);
                }
                z = true;
                z2 = true;
            }
            if (!Util.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).DYw)) {
                try {
                    i2 = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).DYw);
                } catch (Exception e3) {
                    Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", Util.stackTraceToString(e3));
                    i2 = 0;
                }
                gradientDrawable.setColor(i2);
                z = true;
            }
            if (z) {
                this.Edp.setBackgroundDrawable(gradientDrawable);
            }
        }
        this.Edp.setText(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).title);
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).DYv == 1) {
            this.Edp.setTypeface(Typeface.defaultFromStyle(1));
        } else if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).DYv == 2) {
            this.Edp.setTypeface(Typeface.defaultFromStyle(2));
        }
        this.Edp.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(96489);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBtnComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                q.this.fdw();
                q.this.fde();
                a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBtnComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(96489);
            }
        });
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).fontSize > 0.0f) {
            this.Edp.setTextSize(0, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).fontSize);
        }
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).DYt != null && ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).DYt.length() > 0) {
            try {
                this.Edp.setTextColor(Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).DYt));
            } catch (Exception e4) {
                Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", "invalid color! %s", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).DYt);
            }
        }
        try {
            this.Edp.setTextAlignment(4);
        } catch (Exception e5) {
            Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", "the device has no method btn.setTextAlignment");
        }
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).height > 0.0f) {
            this.Edp.setLayoutParams(new FrameLayout.LayoutParams((i4 - ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).paddingLeft)) - ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).paddingRight), (int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).height));
        } else {
            this.Edp.setLayoutParams(new FrameLayout.LayoutParams((i4 - ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).paddingLeft)) - ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).paddingRight), this.Edp.getLayoutParams().height));
        }
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).DYz == 1) {
            this.Edq.setLayoutParams(new FrameLayout.LayoutParams((i4 - ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).paddingLeft)) - ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).paddingRight), this.Edq.getLayoutParams().height));
            this.Edq.setVisibility(0);
            this.Edq.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q.AnonymousClass2 */

                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(96487);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBtnComponent$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                    q.a(q.this);
                    a.a(true, (Object) this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBtnComponent$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(96487);
                    return true;
                }
            });
            this.Edq.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(96488);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBtnComponent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    q.this.fdw();
                    q.this.fde();
                    a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBtnComponent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(96488);
                }
            });
        } else {
            this.Edq.setVisibility(8);
        }
        if (!z2) {
            this.Edo.setRadius(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).tt);
        }
        com.tencent.mm.plugin.sns.ad.e.f.a(this.context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX, this.Edp);
        AppMethodBeat.o(96496);
    }

    /* access modifiers changed from: protected */
    public void hWL() {
        int i2;
        boolean z;
        boolean z2;
        String str;
        AppMethodBeat.i(259444);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q qVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX;
        long j2 = 0;
        if (this.context instanceof Activity) {
            j2 = y.aOa(((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_share_sns_id"));
            i2 = ((Activity) this.context).getIntent().getIntExtra("sns_landig_pages_from_source", 0);
            ((Activity) this.context).getIntent().getIntExtra("sns_landing_pages_adType", 0);
        } else {
            i2 = 0;
        }
        if (qVar.subType == 4) {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f fVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f) qVar;
            Intent intent = new Intent();
            intent.putExtra("key_card_id", fVar.cardTpId);
            if (!Util.isNullOrNil(fds().aPU(fVar.cardTpId))) {
                fVar.cardExt = fds().aPU(fVar.cardTpId);
            }
            intent.putExtra("key_card_ext", fVar.cardExt);
            intent.putExtra("key_from_scene", 21);
            intent.putExtra("key_stastic_scene", 15);
            c.b(this.context, "card", ".ui.CardDetailUI", intent);
            fdy();
            this.Edn.kv("cardTpId", fVar.cardTpId);
            this.Edn.kv("cardExt", fVar.cardExt);
            AppMethodBeat.o(259444);
        } else if (qVar.subType == 8) {
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX) instanceof k) {
                String str2 = "";
                if (!(this.context instanceof Activity) || fds().bizId != 2) {
                    str = "";
                } else {
                    str2 = ((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_sessionId");
                    str = ((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
                }
                String format = String.format("%s:%s:%s:%s:%d:%s:%s:%d", str2, str, ((k) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX)).DZi, String.valueOf(System.currentTimeMillis() / 1000), Integer.valueOf(fds().bizId), fds().uxInfo, Long.valueOf(j2), Integer.valueOf(i2));
                k kVar = (k) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX);
                r.a(kVar.username, kVar.ecK, "", fds().aid, fds().kZe, format, fds().uxInfo, 1084);
                this.Edn.kv("weappUserName", kVar.username);
                this.Edn.kv("weappPath", kVar.ecK);
            }
            AppMethodBeat.o(259444);
        } else if (qVar.subType == 9) {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h hVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h) qVar;
            Intent intent2 = new Intent();
            intent2.putExtra("map_view_type", 1);
            intent2.putExtra("kwebmap_slat", hVar.DYb.yFu);
            intent2.putExtra("kwebmap_lng", hVar.DYb.yFv);
            intent2.putExtra("kwebmap_scale", hVar.DYb.dRt);
            intent2.putExtra("kPoiName", hVar.DYb.dWi);
            intent2.putExtra("Kwebmap_locaion", hVar.DYb.yFx);
            Log.i("MicroMsg.Sns.AdLandingPageBtnComponent", "locatint to slat " + hVar.DYb.yFu + ", slong " + hVar.DYb.yFv + ", " + hVar.DYb.dWi);
            c.b(this.context, FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent2, 2002);
            AppMethodBeat.o(259444);
        } else if (qVar.subType == 10) {
            if (e.a.KqE == null) {
                AppMethodBeat.o(259444);
                return;
            }
            j jVar = (j) qVar;
            if (jVar.DXU.size() > 1) {
                e.a.KqE.a(this.context, jVar.DXU, new e.b() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q.AnonymousClass5 */

                    @Override // com.tencent.mm.ui.widget.a.e.b
                    public final void onDismiss() {
                        AppMethodBeat.i(96490);
                        ap.hb(q.this.context);
                        AppMethodBeat.o(96490);
                    }
                });
                this.Edn.kv("phonenumber", jVar.DXU.get(0));
                AppMethodBeat.o(259444);
                return;
            }
            if (jVar.DXU.size() > 0) {
                AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity) this.context, jVar.DXU.get(0));
                this.Edn.kv("phonenumber", jVar.DXU.get(0));
            }
            AppMethodBeat.o(259444);
        } else if (qVar.subType == 11) {
            if (this.context instanceof SnsAdNativeLandingPagesUI) {
                SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI = (SnsAdNativeLandingPagesUI) this.context;
                z zVar = qVar.DYG;
                String str3 = qVar.DYD;
                String str4 = qVar.DYE;
                String str5 = qVar.DYF;
                if (qVar.DYB == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (qVar.DYC == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                snsAdNativeLandingPagesUI.a(zVar, str3, str4, str5, z, z2, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).DYA == 1);
            }
            AppMethodBeat.o(259444);
        } else if (qVar.subType == 12) {
            final n nVar = (n) qVar;
            Log.i("MicroMsg.Sns.AdLandingPageBtnComponent", "openServiceChat:".concat(String.valueOf(nVar)));
            try {
                if (TextUtils.isEmpty(nVar.businessId)) {
                    a(nVar, "");
                } else if (!TextUtils.isEmpty(nVar.weappUserName)) {
                    if (!NetStatusUtil.isNetworkConnected(this.context)) {
                        u.makeText(this.context, (int) R.string.h4g, 0).show();
                    } else {
                        d.a aVar = new d.a();
                        aVar.iLN = new bvr();
                        aVar.iLO = new bvs();
                        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getsubbusinessinfo";
                        aVar.funcId = 1303;
                        aVar.iLP = 0;
                        aVar.respCmdId = 0;
                        d aXF = aVar.aXF();
                        bvr bvr = (bvr) aXF.iLK.iLR;
                        bvr.username = nVar.weappUserName;
                        bvr.MbE = nVar.businessId;
                        IPCRunCgi.a(aXF, new IPCRunCgi.a() {
                            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q.AnonymousClass6 */

                            @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                            public final void a(int i2, int i3, String str, d dVar) {
                                AppMethodBeat.i(96493);
                                if (i2 == 0 && i3 == 0 && dVar.iLL.iLR != null) {
                                    final bvs bvs = (bvs) dVar.iLL.iLR;
                                    Log.i("MicroMsg.Sns.AdLandingPageBtnComponent", "getsubbusinessinfo cgi success, subBusinessUsername:%s", bvs.MbF);
                                    MMHandlerThread.postToMainThread(new Runnable() {
                                        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q.AnonymousClass6.AnonymousClass2 */

                                        public final void run() {
                                            AppMethodBeat.i(96492);
                                            q.this.a(nVar, bvs.MbF);
                                            AppMethodBeat.o(96492);
                                        }
                                    });
                                    AppMethodBeat.o(96493);
                                    return;
                                }
                                Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", "getsubbusinessinfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i2), Integer.valueOf(i3), str, dVar.iLL.iLR);
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q.AnonymousClass6.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(96491);
                                        u.makeText(q.this.context, (int) R.string.h4g, 0).show();
                                        AppMethodBeat.o(96491);
                                    }
                                });
                                AppMethodBeat.o(96493);
                            }
                        });
                    }
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", "openServiceChat exp:" + e2.toString());
            }
            this.Edn.kv("weappid", nVar.DYj);
            this.Edn.kv("weappUserName", nVar.weappUserName);
            this.Edn.kv("businessId", nVar.businessId);
            AppMethodBeat.o(259444);
        } else if (qVar.subType == 16) {
            ac acVar = (ac) qVar;
            if (acVar.DZA != null) {
                String str6 = fds().DZW;
                if (TextUtils.isEmpty(str6)) {
                    str6 = fds().uxInfo;
                    Log.i("MicroMsg.Sns.AdLandingPageBtnComponent", "jumpScanUI, use old uxInfo=".concat(String.valueOf(str6)));
                } else {
                    Log.i("MicroMsg.Sns.AdLandingPageBtnComponent", "jumpScanUI, use new uxInfo=".concat(String.valueOf(str6)));
                }
                com.tencent.mm.plugin.sns.ad.e.k.a(this.context, acVar.DZA, str6);
                AppMethodBeat.o(259444);
                return;
            }
            Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", "scanJumpInfo == null");
            AppMethodBeat.o(259444);
        } else {
            String str7 = qVar.DYr;
            this.Edn.kv("btnJumpUrl", str7);
            com.tencent.mm.plugin.sns.data.k.a(this.context, str7, fds(), i2, j2, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) this.EcX).DZi);
            fdy();
            AppMethodBeat.o(259444);
        }
    }

    /* access modifiers changed from: protected */
    public final void fdy() {
        AppMethodBeat.i(202939);
        if (this.Eds && (this.context instanceof Activity)) {
            ((Activity) this.context).overridePendingTransition(R.anim.dq, R.anim.s);
        }
        AppMethodBeat.o(202939);
    }

    static /* synthetic */ void a(q qVar) {
        boolean z;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(96500);
        if (qVar.context instanceof SnsAdNativeLandingPagesUI) {
            SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI = (SnsAdNativeLandingPagesUI) qVar.context;
            z zVar = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) qVar.EcX).DYG;
            String str = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) qVar.EcX).DYD;
            String str2 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) qVar.EcX).DYE;
            String str3 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) qVar.EcX).DYF;
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) qVar.EcX).DYB == 1) {
                z = true;
            } else {
                z = false;
            }
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) qVar.EcX).DYC == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) qVar.EcX).DYA == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            snsAdNativeLandingPagesUI.a(zVar, str, str2, str3, z, z2, z3);
        }
        qVar.Edq.setPressed(false);
        AppMethodBeat.o(96500);
    }
}
