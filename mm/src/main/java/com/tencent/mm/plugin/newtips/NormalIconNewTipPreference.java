package com.tencent.mm.plugin.newtips;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.av.d;
import com.tencent.mm.av.q;
import com.tencent.mm.av.r;
import com.tencent.mm.plugin.newtips.a.g;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.newtips.b;
import com.tencent.mm.protocal.protobuf.ehv;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.preference.NormalIconPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.tools.v;
import java.lang.ref.WeakReference;

public class NormalIconNewTipPreference extends NormalIconPreference implements com.tencent.mm.plugin.newtips.a.a {
    private WeakReference<f> ACF;
    private String ACG;
    private r.a ACH;
    private a ACI;
    private r.a ACJ;
    public boolean ACK;
    public h Akx;
    private Context context;
    protected View gvQ;
    private String path;

    public interface a {
        void aIA(String str);
    }

    public NormalIconNewTipPreference(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public NormalIconNewTipPreference(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(127184);
        this.ACG = null;
        this.ACF = null;
        this.ACJ = new r.a() {
            /* class com.tencent.mm.plugin.newtips.NormalIconNewTipPreference.AnonymousClass1 */

            @Override // com.tencent.mm.av.r.a
            public final void a(final String str, Bitmap bitmap, String str2) {
                final Bitmap roundedCornerBitmap;
                AppMethodBeat.i(127183);
                if (!NormalIconNewTipPreference.this.ACK || bitmap == null || bitmap.isRecycled()) {
                    roundedCornerBitmap = BitmapUtil.getRoundedCornerBitmap(bitmap, false, 0.1f * ((float) bitmap.getWidth()));
                } else {
                    roundedCornerBitmap = BitmapUtil.getRoundedCornerBitmap(bitmap, false, (float) (bitmap.getWidth() / 2));
                }
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.newtips.NormalIconNewTipPreference.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(127182);
                        Log.i("MicroMsg.NewTips.NormalIconNewTipPreference", "download url " + str + " , result " + (roundedCornerBitmap == null));
                        if (str.equals(NormalIconNewTipPreference.this.ACG)) {
                            NormalIconNewTipPreference.this.aL(roundedCornerBitmap);
                            NormalIconNewTipPreference.this.ACG = null;
                            NormalIconNewTipPreference.this.notifyDataSetChanged();
                        }
                        AppMethodBeat.o(127182);
                    }
                });
                AppMethodBeat.o(127183);
            }
        };
        this.ACK = false;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, b.a.NormalIconNewTipPreference, i2, 0);
        this.path = obtainStyledAttributes.getString(0);
        this.context = context2;
        obtainStyledAttributes.recycle();
        Log.i("MicroMsg.NewTips.NormalIconNewTipPreference", "NormalIconNewTipPreference() path:%s", this.path);
        AppMethodBeat.o(127184);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference, com.tencent.mm.ui.base.preference.IconPreference, com.tencent.mm.ui.base.preference.NormalIconPreference
    public View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(127185);
        View onCreateView = super.onCreateView(viewGroup);
        if (this.gvQ == null) {
            this.gvQ = onCreateView;
        }
        AppMethodBeat.o(127185);
        return onCreateView;
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public final String getPath() {
        return this.path;
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public final boolean ehp() {
        return false;
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public final View getRoot() {
        AppMethodBeat.i(127186);
        if (this.gvQ == null) {
            this.gvQ = new View(this.context);
        }
        View view = this.gvQ;
        AppMethodBeat.o(127186);
        return view;
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public final void a(k kVar, boolean z) {
        AppMethodBeat.i(127187);
        g.a(this, kVar, z);
        AppMethodBeat.o(127187);
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public final boolean qV(boolean z) {
        AppMethodBeat.i(127188);
        boolean a2 = g.a(z, this);
        AppMethodBeat.o(127188);
        return a2;
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public boolean qW(boolean z) {
        AppMethodBeat.i(127189);
        Log.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showRedPoint() show:%s", Boolean.valueOf(z));
        if (z) {
            alF(0);
        } else {
            alF(8);
            alE(8);
            alI(8);
            alD(8);
        }
        notifyDataSetChanged();
        AppMethodBeat.o(127189);
        return true;
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public boolean qX(boolean z) {
        AppMethodBeat.i(127190);
        Log.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showNew() show:%s", Boolean.valueOf(z));
        if (z) {
            alD(0);
            gY(this.context.getString(R.string.x4), R.drawable.amr);
        } else {
            alF(8);
            alE(8);
            alI(8);
            alD(8);
        }
        notifyDataSetChanged();
        AppMethodBeat.o(127190);
        return true;
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public boolean a(boolean z, ehv ehv) {
        AppMethodBeat.i(127191);
        Log.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showRedPointTitle() show:%s", Boolean.valueOf(z));
        if (z) {
            alF(8);
            alE(0);
            aS(ehv.title, -1, Color.parseColor("#8c8c8c"));
            BB(true);
            alI(8);
        } else {
            alF(8);
            alE(8);
            alI(8);
            alD(8);
        }
        notifyDataSetChanged();
        AppMethodBeat.o(127191);
        return true;
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public final boolean b(boolean z, ehv ehv) {
        Bitmap roundedCornerBitmap;
        AppMethodBeat.i(127192);
        Log.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showRedPointIcon() show:%s", Boolean.valueOf(z));
        if (z) {
            alF(8);
            alI(0);
            alH(0);
            alJ(0);
            BB(false);
            Bitmap decodeResource = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.bca);
            if (this.ACK) {
                decodeResource = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.bcd);
            }
            aL(decodeResource);
            if (this.Akx != null) {
                aIz(ehv.url);
            } else {
                q.bcQ();
                Bitmap EP = d.EP(ehv.url);
                if (this.ACH != null) {
                    if (EP != null) {
                        if (this.ACI != null) {
                            this.ACI.aIA(null);
                        }
                        aL(EP);
                    } else {
                        if (this.ACI != null) {
                            this.ACI.aIA(ehv.url);
                        }
                        q.bcU().a(ehv.url, this.ACH);
                    }
                } else if (EP != null) {
                    this.ACG = null;
                    if (this.ACK) {
                        roundedCornerBitmap = BitmapUtil.getRoundedCornerBitmap(EP, false, (float) (EP.getWidth() / 2));
                    } else {
                        roundedCornerBitmap = BitmapUtil.getRoundedCornerBitmap(EP, false, 0.1f * ((float) EP.getWidth()));
                    }
                    aL(roundedCornerBitmap);
                } else {
                    q.bcU().a(ehv.url, this.ACJ);
                    this.ACG = ehv.url;
                }
            }
        } else {
            alF(8);
            alE(8);
            alI(8);
            alD(8);
        }
        notifyDataSetChanged();
        AppMethodBeat.o(127192);
        return true;
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public final boolean c(boolean z, ehv ehv) {
        Bitmap roundedCornerBitmap;
        AppMethodBeat.i(127193);
        Log.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showRedPointPointTitleIcon() show:%s", Boolean.valueOf(z));
        if (z) {
            alF(8);
            alI(0);
            alH(0);
            alJ(0);
            alE(0);
            BB(false);
            aS(ehv.title, -1, Color.parseColor("#8c8c8c"));
            Bitmap decodeResource = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.bca);
            if (this.ACK) {
                decodeResource = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.bcd);
            }
            aL(decodeResource);
            if (this.Akx != null) {
                aIz(ehv.url);
            } else {
                q.bcQ();
                Bitmap EP = d.EP(ehv.url);
                if (this.ACH != null) {
                    if (EP != null) {
                        if (this.ACI != null) {
                            this.ACI.aIA(null);
                        }
                        aL(EP);
                    } else {
                        q.bcU().a(ehv.url, this.ACH);
                        if (this.ACI != null) {
                            this.ACI.aIA(ehv.url);
                        }
                    }
                } else if (EP != null) {
                    this.ACG = null;
                    if (this.ACK) {
                        roundedCornerBitmap = BitmapUtil.getRoundedCornerBitmap(EP, false, (float) (EP.getWidth() / 2));
                    } else {
                        roundedCornerBitmap = BitmapUtil.getRoundedCornerBitmap(EP, false, 0.1f * ((float) EP.getWidth()));
                    }
                    aL(roundedCornerBitmap);
                } else {
                    q.bcU().a(ehv.url, this.ACJ);
                    this.ACG = ehv.url;
                }
            }
        } else {
            alF(8);
            alE(8);
            alI(8);
            alD(8);
        }
        notifyDataSetChanged();
        AppMethodBeat.o(127193);
        return true;
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public final boolean d(boolean z, ehv ehv) {
        AppMethodBeat.i(127194);
        Log.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showCounter() show:%s", Boolean.valueOf(z));
        if (z) {
            alD(0);
            String sb = new StringBuilder().append(ehv.ibS).toString();
            if (ehv.ibS > 99) {
                sb = this.context.getString(R.string.hk6);
            }
            gY(sb, v.aQ(this.mContext, ehv.ibS));
        } else {
            alF(8);
            alE(8);
            alI(8);
            alD(8);
        }
        notifyDataSetChanged();
        AppMethodBeat.o(127194);
        return true;
    }

    /* access modifiers changed from: protected */
    public final void notifyDataSetChanged() {
        f fVar;
        AppMethodBeat.i(127195);
        if (!(this.ACF == null || (fVar = this.ACF.get()) == null)) {
            fVar.notifyDataSetChanged();
        }
        AppMethodBeat.o(127195);
    }

    public final void a(r.a aVar, a aVar2) {
        this.ACH = aVar;
        this.ACI = aVar2;
    }

    private void aIz(String str) {
        AppMethodBeat.i(127196);
        int dimensionPixelOffset = this.context.getResources().getDimensionPixelOffset(R.dimen.v5);
        c.a aVar = new c.a();
        aVar.prefixPath = com.tencent.mm.loader.j.b.aKJ();
        q.bcW();
        aVar.jbw = null;
        aVar.jbf = true;
        aVar.iaT = true;
        aVar.jbd = true;
        aVar.hZA = dimensionPixelOffset;
        aVar.hZz = dimensionPixelOffset;
        q.bcV().a(str, gLG(), aVar.bdv(), this.Akx);
        AppMethodBeat.o(127196);
    }

    public final void a(f fVar) {
        AppMethodBeat.i(127197);
        this.ACF = new WeakReference<>(fVar);
        AppMethodBeat.o(127197);
    }
}
