package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Looper;
import android.support.v4.content.d;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vfs.s;
import org.json.JSONException;
import org.json.JSONObject;

public final class y extends ak implements b, i.b {
    private long AhP = 0;
    private int Aiv = 0;
    AdLandingVideoWrapper EeO;
    private VideoPlayerSeekBar EeP;
    private ImageView EeQ;
    boolean EeR;
    private ImageView EeS;
    private TextView EeT;
    private Runnable EeU;
    boolean EeV = false;
    boolean EeW = false;
    boolean EeX = false;
    boolean EeY = true;
    boolean EeZ = true;
    private boolean Efa = false;
    private boolean Efb = true;
    private boolean Efc = false;
    private boolean Efd = false;
    private boolean Efe = false;
    int Eff = 0;
    private int Efg = 0;
    private int Efh = 0;
    int Efi = 0;
    int Efj = 0;
    private ao Efk = null;
    private View.OnClickListener Efl = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y.AnonymousClass7 */

        public final void onClick(View view) {
            AppMethodBeat.i(96631);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageNewStreamVideoComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "play btn onclick isPlaying[%b]", Boolean.valueOf(y.this.EeO.isPlaying()));
            if (y.this.EeO.isPlaying()) {
                y.this.cXa();
                y.this.Eff = 4;
            } else {
                if (y.this.EeY) {
                    y.this.fcJ();
                } else {
                    y.this.fcL();
                    y.this.fcK();
                }
                y.b(y.this);
                y.this.Eff = 3;
            }
            if (y.this.DXw) {
                y.this.Efi++;
            }
            a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageNewStreamVideoComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96631);
        }
    };
    private View.OnClickListener Efm = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y.AnonymousClass8 */

        public final void onClick(View view) {
            AppMethodBeat.i(96632);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageNewStreamVideoComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            y.this.Efj++;
            if (y.this.EeY) {
                y.this.fcL();
                y.this.fcK();
            } else {
                y.this.fcJ();
            }
            y.this.EeV = true;
            a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageNewStreamVideoComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96632);
        }
    };
    private View.OnClickListener Efn = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y.AnonymousClass9 */

        public final void onClick(View view) {
            AppMethodBeat.i(96634);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageNewStreamVideoComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            y.b(y.this);
            y.this.EeZ = false;
            y.this.EeW = true;
            y.this.Eff = 3;
            y.this.fcK();
            y.this.setFocus(true);
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y.AnonymousClass9.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(96633);
                    if (y.this.EeX) {
                        AppMethodBeat.o(96633);
                        return;
                    }
                    y.this.setFocus(false);
                    AppMethodBeat.o(96633);
                }
            }, 10000);
            a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageNewStreamVideoComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96634);
        }
    };
    private View.OnClickListener Efo = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y.AnonymousClass10 */

        public final void onClick(View view) {
            AppMethodBeat.i(96635);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageNewStreamVideoComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!y.this.EeX) {
                y.this.EeX = true;
                y.this.setFocus(true);
            }
            a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageNewStreamVideoComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96635);
        }
    };
    private Context context;
    private MMHandler hAk;
    private ProgressBar hRO;
    private boolean isAutoPlay = false;
    private View maskView;
    ImageView xdY;

    static /* synthetic */ void b(y yVar) {
        AppMethodBeat.i(202987);
        yVar.czw();
        AppMethodBeat.o(202987);
    }

    public y(final Context context2, am amVar, ViewGroup viewGroup) {
        super(context2, amVar, viewGroup);
        AppMethodBeat.i(96637);
        this.context = context2;
        this.hAk = new MMHandler(Looper.getMainLooper());
        this.EeU = new Runnable() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(96625);
                y.this.setFocus(false);
                AppMethodBeat.o(96625);
            }
        };
        this.Efk = new ao() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ao
            public final void vg(boolean z) {
                AppMethodBeat.i(96628);
                Intent intent = new Intent("com.tencent.mm.adlanding.video_progressbar_change");
                intent.putExtra("show", z ? 1 : 0);
                intent.putExtra("activity_code", y.this.fcM());
                d.W(context2).b(intent);
                AppMethodBeat.o(96628);
            }
        };
        AppMethodBeat.o(96637);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final int getLayout() {
        return R.layout.buk;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x00be  */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void eXe() {
        /*
        // Method dump skipped, instructions count: 454
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y.eXe():void");
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWT() {
    }

    private void czw() {
        AppMethodBeat.i(96639);
        Log.d("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "starting play");
        if (this.Efc) {
            Log.i("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "last download fail ,try again");
            this.EeO.c(false, ((am) this.EcX).DYS, 0);
            YX(0);
            this.EeO.fdQ();
            AppMethodBeat.o(96639);
            return;
        }
        this.hAk.post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y.AnonymousClass11 */

            public final void run() {
                AppMethodBeat.i(96636);
                if (!y.this.EeO.isPlaying()) {
                    if (y.this.EeO.getCurrPosSec() == y.this.EeO.getVideoDurationSec()) {
                        y.this.YX(0);
                    } else {
                        y.this.YX(y.this.EeO.getCurrPosSec());
                    }
                    y.this.EeO.fdQ();
                }
                AppMethodBeat.o(96636);
            }
        });
        this.AhP = System.currentTimeMillis();
        this.Aiv++;
        AppMethodBeat.o(96639);
    }

    /* access modifiers changed from: package-private */
    public final void cXa() {
        AppMethodBeat.i(96640);
        Log.d("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "pause play");
        this.hAk.post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(96626);
                y.this.EeO.pause();
                AppMethodBeat.o(96626);
            }
        });
        if (this.AhP != 0) {
            this.Efg = (int) (((long) this.Efg) + (System.currentTimeMillis() - this.AhP));
            this.AhP = 0;
        }
        AppMethodBeat.o(96640);
    }

    /* access modifiers changed from: package-private */
    public final void setFocus(boolean z) {
        AppMethodBeat.i(96641);
        if (z) {
            this.EeP.setVisibility(0);
            this.EeQ.setVisibility(0);
            this.maskView.setVisibility(0);
            if (this.Efk != null) {
                this.Efk.vg(true);
            }
            this.hAk.postDelayed(this.EeU, 5000);
            AppMethodBeat.o(96641);
            return;
        }
        this.EeX = false;
        this.EeP.setVisibility(4);
        this.EeQ.setVisibility(8);
        this.maskView.setVisibility(4);
        if (this.Efk != null) {
            this.Efk.vg(false);
        }
        this.hAk.removeCallbacks(this.EeU);
        AppMethodBeat.o(96641);
    }

    /* access modifiers changed from: package-private */
    public final void YX(int i2) {
        AppMethodBeat.i(96642);
        if (this.EeO != null) {
            this.EeS.setVisibility(8);
            if (this.xdY.getVisibility() == 0) {
                this.hRO.setVisibility(0);
            }
            this.EeO.c((double) i2, true);
        }
        AppMethodBeat.o(96642);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
    public final void fcJ() {
        AppMethodBeat.i(96643);
        super.fcJ();
        this.EeQ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, R.drawable.cah));
        this.EeO.setMute(true);
        this.EeY = true;
        AppMethodBeat.o(96643);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
    public final void fcK() {
        AppMethodBeat.i(96644);
        super.fcK();
        this.EeQ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, R.drawable.cai));
        this.EeO.setMute(false);
        this.EeY = false;
        AppMethodBeat.o(96644);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
    public final boolean isPlaying() {
        AppMethodBeat.i(202986);
        boolean isPlaying = this.EeO.isPlaying();
        AppMethodBeat.o(202986);
        return isPlaying;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
    public final void eWZ() {
        AppMethodBeat.i(96645);
        super.eWZ();
        AppMethodBeat.o(96645);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
    public final void eXa() {
        AppMethodBeat.i(96646);
        super.eXa();
        cXa();
        if (this.Efa || this.Efb) {
            this.Efb = false;
            this.Efa = false;
            if (this.Eff == 1) {
                this.Eff = 2;
            }
            AppMethodBeat.o(96646);
            return;
        }
        AppMethodBeat.o(96646);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
    public final void eXd() {
        AppMethodBeat.i(96647);
        super.eXd();
        this.EeO.onUIDestroy();
        AppMethodBeat.o(96647);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
    public final void eXb() {
        AppMethodBeat.i(96648);
        super.eXb();
        int fdl = fdl();
        int height = getView().getHeight();
        Log.d("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "inScreenHeight %d, height %d", Integer.valueOf(fdl), Integer.valueOf(height));
        if (fdl == 0 || height == 0) {
            AppMethodBeat.o(96648);
        } else if (fdl < 0) {
            AppMethodBeat.o(96648);
        } else if (((float) fdl) < ((float) height) * 0.5f) {
            this.Efb = false;
            this.Efa = false;
            cXa();
            if (this.Eff == 1) {
                this.Eff = 2;
            }
            AppMethodBeat.o(96648);
        } else if (!this.Efa || this.Efb) {
            this.Efb = false;
            this.Efa = true;
            this.xdY.setVisibility(0);
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) MMApplicationContext.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (!this.EeZ || (this.EeZ && activeNetworkInfo != null && activeNetworkInfo.getType() == 1)) {
                setFocus(true);
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(96627);
                        if (y.this.EeX) {
                            AppMethodBeat.o(96627);
                            return;
                        }
                        y.this.setFocus(false);
                        AppMethodBeat.o(96627);
                    }
                }, 3000);
            }
            if (this.EeZ) {
                if (activeNetworkInfo == null || !(activeNetworkInfo == null || activeNetworkInfo.getType() == 1)) {
                    this.EeS.setVisibility(0);
                    this.isAutoPlay = false;
                    this.EeZ = false;
                    AppMethodBeat.o(96648);
                    return;
                }
                this.isAutoPlay = true;
                this.EeZ = false;
            }
            if (this.Eff == 0) {
                if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
                    if (this.EeY) {
                        fcJ();
                    } else {
                        fcK();
                    }
                    this.Eff = 1;
                }
                AppMethodBeat.o(96648);
            } else if (this.Eff == 2) {
                if (this.EeY) {
                    fcJ();
                } else {
                    fcK();
                }
                czw();
                this.Eff = 1;
                AppMethodBeat.o(96648);
                return;
            } else {
                if (this.Eff == 3) {
                    if (this.EeY) {
                        fcJ();
                    } else {
                        fcK();
                    }
                }
                AppMethodBeat.o(96648);
            }
            czw();
            AppMethodBeat.o(96648);
        } else {
            AppMethodBeat.o(96648);
        }
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final boolean bp(JSONObject jSONObject) {
        AppMethodBeat.i(96649);
        if (!super.bp(jSONObject)) {
            AppMethodBeat.o(96649);
            return false;
        }
        try {
            jSONObject.put("streamVideoDuraion", this.EeO.getVideoDurationSec() * 1000);
            jSONObject.put("playTimeInterval", this.Efg);
            jSONObject.put("playCount", this.Aiv);
            jSONObject.put("playCompletedCount", this.Efh);
            jSONObject.put("clickPlayControlCount", this.Efi);
            jSONObject.put("clickVoiceControlCount", this.Efj);
            jSONObject.put("isAutoPlay", this.isAutoPlay ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            if (!this.Efd) {
                String mD5String = MD5Util.getMD5String(((am) this.EcX).Ead);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("urlMd5", mD5String);
                jSONObject2.put("needDownload", 1);
                jSONObject.put("thumbUrlInfo", jSONObject2);
            }
            if (!this.Efe) {
                String mD5String2 = MD5Util.getMD5String(((am) this.EcX).DYS);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("urlMd5", mD5String2);
                jSONObject3.put("needDownload", 1);
                jSONObject.put("streamVideoUrlInfo", jSONObject3);
            }
            AppMethodBeat.o(96649);
            return true;
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", e2, "", new Object[0]);
            AppMethodBeat.o(96649);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.b
    public final void aJq() {
        this.EeX = true;
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.b
    public final void rk(int i2) {
        AppMethodBeat.i(96650);
        Log.i("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "onSeek time ".concat(String.valueOf(i2)));
        if (this.EeY) {
            fcJ();
        } else {
            fcL();
            fcK();
        }
        YX(i2);
        AppMethodBeat.o(96650);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dH(String str, String str2) {
        this.Efc = false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dI(String str, String str2) {
        AppMethodBeat.i(96651);
        this.Efh++;
        setFocus(true);
        this.EeO.Ehq.stopTimer();
        if (this.AhP != 0) {
            this.Efg = (int) (((long) this.Efg) + (System.currentTimeMillis() - this.AhP));
            this.AhP = 0;
        }
        this.Eff = 5;
        this.EeO.onUIPause();
        AppMethodBeat.o(96651);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dJ(String str, String str2) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dK(String str, String str2) {
        AppMethodBeat.i(96652);
        this.xdY.setVisibility(8);
        this.hRO.setVisibility(8);
        AppMethodBeat.o(96652);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void d(String str, String str2, int i2, int i3) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void c(String str, String str2, String str3, int i2, int i3) {
        AppMethodBeat.i(96653);
        Log.e("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "online play error, %s", str3);
        this.Efc = true;
        AppMethodBeat.o(96653);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dL(String str, String str2) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dM(String str, String str2) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void fo(String str, String str2) {
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void fdq() {
        AppMethodBeat.i(96654);
        super.fdq();
        cXa();
        String kz = h.kz("adId", ((am) this.EcX).Ead);
        if (s.YS(kz)) {
            this.xdY.setImageBitmap(BitmapUtil.decodeFile(kz));
            this.xdY.setVisibility(0);
        }
        AppMethodBeat.o(96654);
    }

    static /* synthetic */ am a(y yVar) {
        return (am) yVar.EcX;
    }
}
