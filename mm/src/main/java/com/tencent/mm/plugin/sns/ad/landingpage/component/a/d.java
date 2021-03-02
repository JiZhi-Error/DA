package com.tencent.mm.plugin.sns.ad.landingpage.component.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.uy;
import com.tencent.mm.g.a.ve;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.ad.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends m {
    com.tencent.mm.plugin.sns.ad.landingpage.component.b.d DtD;
    private IListener<ve> DtE;
    private IListener<uy> DtF;
    ViewGroup DtG;
    private ViewGroup DtH;
    private q DtI;
    private BroadcastReceiver DtJ;
    int DtK;
    int DtL;
    int DtM;
    int DtN;
    boolean DtO;
    private TextView Ws;

    public d(Context context, com.tencent.mm.plugin.sns.ad.landingpage.component.b.d dVar, ViewGroup viewGroup, int i2) {
        super(context, dVar, viewGroup);
        this.DtD = dVar;
        this.DtK = 0;
        this.DtL = 0;
        this.DtN = i2;
        this.DtO = true;
    }

    public d(Context context, com.tencent.mm.plugin.sns.ad.landingpage.component.b.d dVar, ViewGroup viewGroup) {
        this(context, dVar, viewGroup, -1);
        AppMethodBeat.i(201991);
        int i2 = dVar != null ? dVar.DtU : 0;
        this.DtN = com.tencent.mm.cb.a.fromDPToPix(this.context, i2 <= 0 ? 130 : i2);
        AppMethodBeat.o(201991);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWT() {
        AppMethodBeat.i(201993);
        try {
            super.eWT();
            TextView textView = this.Ws;
            com.tencent.mm.plugin.sns.ad.landingpage.component.b.d dVar = this.DtD;
            if (!(textView == null || dVar == null)) {
                textView.setText(dVar.DtS);
            }
            AppMethodBeat.o(201993);
        } catch (Throwable th) {
            AppMethodBeat.o(201993);
        }
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final int getLayout() {
        return R.layout.buf;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWZ() {
        AppMethodBeat.i(201994);
        try {
            super.eWZ();
            if (this.DtI != null) {
                this.DtI.eWZ();
            }
            AppMethodBeat.o(201994);
        } catch (Throwable th) {
            AppMethodBeat.o(201994);
        }
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXa() {
        AppMethodBeat.i(201995);
        try {
            super.eXa();
            if (this.DtI != null) {
                this.DtI.eXa();
            }
            AppMethodBeat.o(201995);
        } catch (Throwable th) {
            AppMethodBeat.o(201995);
        }
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXd() {
        AppMethodBeat.i(201996);
        try {
            super.eXd();
            if (this.DtI != null) {
                this.DtI.eXd();
            }
            if (this.DtJ != null) {
                android.support.v4.content.d.W(this.context).unregisterReceiver(this.DtJ);
                this.DtJ = null;
            }
            if (this.DtE != null) {
                this.DtE.dead();
                this.DtE = null;
            }
            if (this.DtF != null) {
                this.DtF.dead();
                this.DtF = null;
            }
            AppMethodBeat.o(201996);
        } catch (Throwable th) {
            AppMethodBeat.o(201996);
        }
    }

    /* access modifiers changed from: package-private */
    public final void uK(boolean z) {
        AppMethodBeat.i(201997);
        if (!(this.DtI == null || this.DtI.Edp == null)) {
            this.DtI.Edr = z;
            this.DtI.Edp.performClick();
        }
        AppMethodBeat.o(201997);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final boolean G(JSONArray jSONArray) {
        AppMethodBeat.i(201998);
        if (jSONArray == null) {
            AppMethodBeat.o(201998);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (bp(jSONObject)) {
                jSONObject.put("clickCount", this.DtK);
                jSONObject.put("autoJumpCount", this.DtL);
                jSONObject.put("swipeJumpCount", this.DtM);
                jSONArray.put(jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                if (this.DtI != null && this.DtI.bp(jSONObject2)) {
                    jSONArray.put(jSONObject2);
                }
                AppMethodBeat.o(201998);
                return true;
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(201998);
        return false;
    }

    class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(d dVar, byte b2) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(201990);
            try {
                int intExtra = g.getIntExtra(intent, "show", 0);
                int intExtra2 = g.getIntExtra(intent, "activity_code", 0);
                Context context2 = d.this.context;
                if (context2 == null || intExtra2 != context2.hashCode()) {
                    Log.w("SnsAd.FloatJumpComp", "the context is not same!!");
                    AppMethodBeat.o(201990);
                } else if (intExtra == 0) {
                    d.this.contentView.setVisibility(0);
                    AppMethodBeat.o(201990);
                } else {
                    d.this.contentView.setVisibility(8);
                    AppMethodBeat.o(201990);
                }
            } catch (Throwable th) {
                AppMethodBeat.o(201990);
            }
        }
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXe() {
        AppMethodBeat.i(201992);
        try {
            if (this.DtJ == null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.tencent.mm.adlanding.video_progressbar_change");
                this.DtJ = new a(this, (byte) 0);
                android.support.v4.content.d.W(this.context).a(this.DtJ, intentFilter);
            }
            if (this.DtE == null) {
                this.DtE = new IListener<ve>() {
                    /* class com.tencent.mm.plugin.sns.ad.landingpage.component.a.d.AnonymousClass2 */

                    {
                        AppMethodBeat.i(201985);
                        this.__eventId = ve.class.getName().hashCode();
                        AppMethodBeat.o(201985);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(ve veVar) {
                        AppMethodBeat.i(201987);
                        boolean eXf = eXf();
                        AppMethodBeat.o(201987);
                        return eXf;
                    }

                    private boolean eXf() {
                        boolean z;
                        AppMethodBeat.i(201986);
                        try {
                            d dVar = d.this;
                            Log.d("SnsAd.FloatJumpComp", "the SnsAdVideoBonusSceneEvent is received!");
                            com.tencent.mm.plugin.sns.ad.landingpage.component.b.d dVar2 = dVar.DtD;
                            if (dVar2 != null && dVar2.DtT > 0) {
                                if (dVar.DtK > 0 || dVar.DtL > 0 || dVar.DtM > 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (!z) {
                                    dVar.DtL++;
                                    dVar.uK(true);
                                    AppMethodBeat.o(201986);
                                    return true;
                                }
                            }
                            Log.d("SnsAd.FloatJumpComp", "the comp is clicked, or the auto jump is less than 0!");
                        } catch (Throwable th) {
                            Log.w("SnsAd.FloatJumpComp", "onEventCall called has wrong!");
                        }
                        AppMethodBeat.o(201986);
                        return true;
                    }
                };
                this.DtE.alive();
            }
            if (this.DtF == null) {
                this.DtF = new IListener<uy>() {
                    /* class com.tencent.mm.plugin.sns.ad.landingpage.component.a.d.AnonymousClass3 */

                    {
                        AppMethodBeat.i(201988);
                        this.__eventId = uy.class.getName().hashCode();
                        AppMethodBeat.o(201988);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(uy uyVar) {
                        AppMethodBeat.i(201989);
                        uy uyVar2 = uyVar;
                        d dVar = d.this;
                        int i2 = uyVar2.ebn.scrollY;
                        int i3 = uyVar2.ebn.ebo;
                        Log.d("SnsAd.FloatJumpComp", "the onSlideEventCall is called, the current Y is " + i2 + "; the oldY is " + i3);
                        if (i3 == 0) {
                            dVar.DtO = true;
                        }
                        dVar.DtG.setTranslationY((float) (-i2));
                        if (Math.abs(i2) >= dVar.DtN && dVar.DtO) {
                            dVar.DtO = false;
                            dVar.DtM++;
                            dVar.uK(false);
                        }
                        AppMethodBeat.o(201989);
                        return false;
                    }
                };
                this.DtF.alive();
            }
            if (this.contentView != null) {
                this.DtG = (ViewGroup) this.contentView.findViewById(R.id.hvd);
                this.Ws = (TextView) this.contentView.findViewById(R.id.hve);
                this.DtH = (ViewGroup) this.contentView.findViewById(R.id.hvc);
            }
            com.tencent.mm.plugin.sns.ad.landingpage.component.b.d dVar = this.DtD;
            if (!(dVar == null || dVar.DtV == null)) {
                m a2 = ay.a(this.context, dVar.DtV, this.DtH, 0);
                if (a2 instanceof q) {
                    this.DtI = (q) a2;
                    this.DtI.Eds = true;
                    this.DtH.removeAllViews();
                    this.DtH.addView(a2.getView());
                }
            }
            if (this.DtG != null) {
                this.DtG.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.sns.ad.landingpage.component.a.d.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(201984);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingFloatJumpComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        try {
                            Log.d("SnsAd.FloatJumpComp", "the root is clicked!");
                            d.this.DtK++;
                            d.this.uK(false);
                        } catch (Throwable th) {
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingFloatJumpComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(201984);
                    }
                });
            }
            AppMethodBeat.o(201992);
        } catch (Throwable th) {
            AppMethodBeat.o(201992);
        }
    }
}
